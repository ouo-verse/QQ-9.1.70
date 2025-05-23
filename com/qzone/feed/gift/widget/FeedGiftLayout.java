package com.qzone.feed.gift.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.qzone.feed.gift.util.FeedGiftUtil;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellDecorateInfo;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.qzone.proxy.feedcomponent.ui.g;
import com.qzone.proxy.feedcomponent.util.j;
import com.qzone.util.ar;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qzonehub.api.zipanimate.IZipAnimationDrawable;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelperCallBack;
import java.io.File;
import v6.c;
import yo.d;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedGiftLayout extends FrameLayout implements View.OnClickListener {
    private b C;
    private String D;
    private boolean E;
    private boolean F;
    private int G;
    private int H;
    private g I;
    private int J;
    private c.b K;

    /* renamed from: d, reason: collision with root package name */
    private CardFlipLayout f47244d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f47245e;

    /* renamed from: f, reason: collision with root package name */
    private Drawable f47246f;

    /* renamed from: h, reason: collision with root package name */
    private Context f47247h;

    /* renamed from: i, reason: collision with root package name */
    private CellDecorateInfo.CellGiftData f47248i;

    /* renamed from: m, reason: collision with root package name */
    private BusinessFeedData f47249m;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements c.b {

        /* renamed from: d, reason: collision with root package name */
        private boolean f47252d = false;

        a() {
        }

        @Override // v6.c.b
        public void c(int i3) {
            if (FeedGiftLayout.this.C.hasMessages(2)) {
                FeedGiftLayout.this.C.removeMessages(2);
            }
            FeedGiftLayout.this.C.sendEmptyMessage(2);
        }

        @Override // v6.c.b
        public void b() {
            j.e("FeedGiftLayout", 4, "onAnimationBegin");
            this.f47252d = false;
            FeedGiftLayout.this.F = true;
        }

        @Override // v6.c.b
        public void onAnimationFinish() {
            j.e("FeedGiftLayout", 4, "onAnimationFinish");
            FeedGiftLayout.this.F = false;
        }

        @Override // v6.c.b
        public void a(float f16) {
            if (f16 < 0.7f || this.f47252d) {
                return;
            }
            this.f47252d = true;
            if (FeedGiftLayout.this.f47244d != null) {
                FeedGiftLayout.this.f47244d.p();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i3 = message.what;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        return;
                    } else {
                        FeedGiftLayout.this.f47244d.o(false, 1);
                    }
                }
                if (FeedGiftLayout.this.f47246f != null) {
                    ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).start(FeedGiftLayout.this.f47246f);
                    FeedGiftLayout.this.f47245e.setScaleX(2.0f);
                    FeedGiftLayout.this.f47245e.setScaleY(2.0f);
                    return;
                }
                return;
            }
            if (FeedGiftLayout.this.f47246f == null) {
                return;
            }
            FeedGiftLayout.this.f47245e.setImageDrawable(FeedGiftLayout.this.f47246f);
            FeedGiftLayout.this.E = true;
        }
    }

    public FeedGiftLayout(Context context) {
        super(context);
        this.E = false;
        this.F = false;
        this.K = new a();
        l(context);
    }

    private void l(Context context) {
        this.f47247h = context;
        this.C = new b(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(String str) {
        if (this.f47246f == null) {
            this.f47246f = ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).getZipAnimationDrawable();
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setAnimationRes(this.f47246f, this.D + File.separator + str, 10);
            this.f47246f.setCallback(this);
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setScale(this.f47246f, FeedGiftUtil.f47229a);
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).clearFirstFrame(this.f47246f);
        }
        this.C.sendEmptyMessage(1);
    }

    private void q() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        j.e("FeedGiftLayout", 4, "width = " + layoutParams.width + " height = " + layoutParams.height);
        int l3 = ar.l() - (ar.e(8.0f) * 2);
        layoutParams.width = l3;
        int i3 = (int) (((float) l3) * 0.56980056f);
        layoutParams.height = i3;
        this.G = l3;
        this.H = i3;
        j.e("FeedGiftLayout", 4, "after width = " + layoutParams.width + " height = " + layoutParams.height);
        setLayoutParams(layoutParams);
    }

    private void r() {
        CellDecorateInfo cellDecorateInfo;
        CellDecorateInfo.CellGiftData cellGiftData;
        j.f("FeedGiftLayout", "setGiftData ");
        BusinessFeedData businessFeedData = this.f47249m;
        if (businessFeedData != null && (cellDecorateInfo = businessFeedData.cellDecorateInfo) != null && (cellGiftData = cellDecorateInfo.cellGiftData) != null) {
            this.f47244d.setCardLength(this.G, this.H, cellGiftData.iType);
        }
        this.f47244d.setCardData(this.f47249m);
        FeedGiftUtil.d(this.f47248i.strPlayZipUrl, new QzoneZipCacheHelperCallBack() { // from class: com.qzone.feed.gift.widget.FeedGiftLayout.1
            @Override // cooperation.qzone.webviewplugin.QzoneZipCacheHelperCallBack
            public void onResult(boolean z16) {
                FeedGiftLayout feedGiftLayout = FeedGiftLayout.this;
                feedGiftLayout.D = FeedGiftUtil.a(feedGiftLayout.f47248i.strPlayZipUrl);
                j.e("FeedGiftLayout", 4, "loadGiftZipRes  onResult = " + z16 + " mZipPath = " + FeedGiftLayout.this.D);
                if (z16) {
                    FeedGiftLayout.this.m("particleExplosion");
                    FeedGiftLayout.this.f47244d.h(FeedGiftLayout.this.D);
                    if (FeedGiftLayout.this.f47249m.feedType == 2) {
                        FeedGiftLayout.this.C.postDelayed(new Runnable() { // from class: com.qzone.feed.gift.widget.FeedGiftLayout.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                FeedGiftLayout.this.t();
                            }
                        }, 800L);
                        return;
                    }
                    return;
                }
                j.c("FeedGiftLayout", "loadGiftZipRes fail mZipPath = " + FeedGiftLayout.this.D + " url = " + FeedGiftLayout.this.f47248i.strPlayZipUrl);
            }

            @Override // cooperation.qzone.webviewplugin.QzoneZipCacheHelperCallBack
            public void onResultOfNativeRequest(boolean z16, String str, String str2) {
            }
        });
    }

    public void n() {
        if (getChildCount() != 0 || getParent() == null) {
            return;
        }
        ((ViewGroup) getParent()).setClipChildren(false);
        ((ViewGroup) getParent()).setClipToPadding(false);
    }

    public void o() {
        CardFlipLayout cardFlipLayout = this.f47244d;
        if (cardFlipLayout != null) {
            cardFlipLayout.l();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        CellDecorateInfo.CellGiftData cellGiftData = this.f47248i;
        if (cellGiftData != null && !TextUtils.isEmpty(cellGiftData.actionUrl)) {
            FeedGiftUtil.e(2);
            d.d(this.f47248i.actionUrl, this.f47247h, null);
        }
        g gVar = this.I;
        if (gVar != null) {
            gVar.onClick(this, FeedElement.FEED_GIFT, this.J, Boolean.TRUE);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void p() {
        CardFlipLayout cardFlipLayout = this.f47244d;
        if (cardFlipLayout != null) {
            cardFlipLayout.m();
        }
        if (this.f47246f != null) {
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).release(this.f47246f);
        }
        removeAllViews();
    }

    public void s(BusinessFeedData businessFeedData) {
        CellDecorateInfo cellDecorateInfo;
        this.f47249m = businessFeedData;
        if (businessFeedData == null || (cellDecorateInfo = businessFeedData.cellDecorateInfo) == null) {
            return;
        }
        this.f47248i = cellDecorateInfo.cellGiftData;
        j.e("FeedGiftLayout", 4, "isFirst = " + businessFeedData.cellDecorateInfo.cellGiftData.isFirst + " index = " + businessFeedData.cellDecorateInfo.cellGiftData.currentIndex);
        if (this.f47248i == null) {
            return;
        }
        q();
        if (getChildCount() == 0) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).setClipChildren(false);
                ((ViewGroup) getParent()).setClipToPadding(false);
            }
            setClipChildren(false);
            setClipToPadding(false);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            CardFlipLayout cardFlipLayout = new CardFlipLayout(this.f47247h);
            this.f47244d = cardFlipLayout;
            cardFlipLayout.setOnAnimationListener(this.K);
            this.f47244d.setOnFeedElementClickListener(this.I);
            this.f47244d.setFeedPosition(this.J);
            addView(this.f47244d, layoutParams);
            this.f47245e = new ImageView(this.f47247h);
            int i3 = this.H;
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i3, i3);
            layoutParams2.gravity = 17;
            addView(this.f47245e, layoutParams2);
            this.f47244d.setOnClickListener(this);
            r();
            FeedGiftUtil.e(1);
        }
    }

    public void setFeedPosition(int i3) {
        this.J = i3;
    }

    public void setOnFeedElementClickListener(g gVar) {
        this.I = gVar;
    }

    public void t() {
        CellDecorateInfo.CellGiftData cellGiftData;
        if (!this.E || this.F || (cellGiftData = this.f47248i) == null) {
            return;
        }
        if (cellGiftData == null || cellGiftData.isFirst) {
            CardFlipLayout cardFlipLayout = this.f47244d;
            if (cardFlipLayout == null || !cardFlipLayout.k()) {
                if (this.C.hasMessages(3)) {
                    this.C.removeMessages(3);
                }
                this.C.sendEmptyMessageDelayed(3, 200L);
                this.f47248i.isFirst = false;
                FeedGiftUtil.f(this.f47249m);
            }
        }
    }

    public FeedGiftLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.E = false;
        this.F = false;
        this.K = new a();
        l(context);
    }

    public FeedGiftLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.E = false;
        this.F = false;
        this.K = new a();
        l(context);
    }
}
