package com.qzone.reborn.feedx.widget.picmixvideo;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.tencent.biz.qqcircle.richframework.widget.RoundCorneredFrameLayout;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import mqq.app.MobileQQ;

/* loaded from: classes37.dex */
public class QZoneSinglePicWidgetView extends QZoneBaseWidgetView<BusinessFeedData> {
    private b C;

    /* renamed from: e, reason: collision with root package name */
    private BusinessFeedData f56468e;

    /* renamed from: f, reason: collision with root package name */
    private int f56469f;

    /* renamed from: h, reason: collision with root package name */
    private RoundCorneredFrameLayout f56470h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f56471i;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f56472m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class a implements IPicLoadStateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f56473d;

        a(String str) {
            this.f56473d = str;
        }

        @Override // com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(LoadState loadState, Option option) {
            String str;
            if (loadState.isFinishSuccess() && option.getAnimatable() != null) {
                option.getAnimatable().start();
            }
            if (loadState.isFinishSuccess() && QZoneSinglePicWidgetView.this.f56468e != null && QZoneSinglePicWidgetView.this.f56468e.getPictureInfo() != null && QZoneSinglePicWidgetView.this.f56468e.getPictureInfo().pics.size() == 1) {
                QZoneSinglePicWidgetView qZoneSinglePicWidgetView = QZoneSinglePicWidgetView.this;
                qZoneSinglePicWidgetView.u0(loadState, qZoneSinglePicWidgetView.f56468e.getPictureInfo().pics.get(0), option);
            }
            if (loadState.isFinish()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("loadImage  | state = ");
                sb5.append(loadState);
                sb5.append(" | feedId = ");
                if (QZoneSinglePicWidgetView.this.f56468e != null) {
                    str = QZoneSinglePicWidgetView.this.f56468e.getIdInfo().cellId;
                } else {
                    str = "";
                }
                sb5.append(str);
                sb5.append(" | pos = ");
                sb5.append(QZoneSinglePicWidgetView.this.f56469f);
                sb5.append(" | url = ");
                sb5.append(this.f56473d);
                QLog.i("QZoneSinglePicWidgetView", 1, sb5.toString());
            }
        }
    }

    /* loaded from: classes37.dex */
    public interface b {
        void a(BusinessFeedData businessFeedData, View view);

        String b(BusinessFeedData businessFeedData);

        boolean c();

        FrameLayout.LayoutParams d(Context context, BusinessFeedData businessFeedData, FrameLayout.LayoutParams layoutParams);
    }

    public QZoneSinglePicWidgetView(Context context) {
        super(context);
        y0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A0(PictureItem pictureItem, BitmapDrawable bitmapDrawable) {
        pictureItem.currentUrl.width = bitmapDrawable.getIntrinsicWidth();
        pictureItem.currentUrl.height = bitmapDrawable.getIntrinsicHeight();
        RoundCorneredFrameLayout roundCorneredFrameLayout = this.f56470h;
        if (roundCorneredFrameLayout == null || this.f56471i == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = roundCorneredFrameLayout.getLayoutParams();
        com.qzone.reborn.feedx.widget.picmixvideo.b.a(getContext(), this.f56468e, layoutParams, pictureItem.currentUrl, pl.a.f426446a.l(getContext()));
        this.f56470h.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.f56471i.getLayoutParams();
        layoutParams2.width = layoutParams.width;
        layoutParams2.height = layoutParams.height;
        this.f56471i.setLayoutParams(layoutParams2);
        com.qzone.reborn.feedx.widget.picmixvideo.a.a(getContext(), com.qzone.reborn.feedx.widget.picmixvideo.b.g(this.f56468e.getFeedCommInfo().feedskey, pictureItem.currentUrl), layoutParams.width, layoutParams.height);
        D0(pictureItem.currentUrl.url);
        QLog.i("QZoneSinglePicWidgetView", 1, "adjustSinglePicNoHW  | feedId = " + this.f56468e.getFeedCommInfo().feedskey + " | pos = " + this.f56469f + " | url = " + pictureItem.currentUrl.url + " | width = " + pictureItem.currentUrl.width + " | height = " + pictureItem.currentUrl.height + " | this = " + this + " | mFeedData = " + this.f56468e.hashCode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B0(final PictureItem pictureItem, LoadState loadState, Option option) {
        if (this.f56468e == null || pictureItem == null || pictureItem.currentUrl == null || !loadState.isFinishSuccess() || option.getResultBitMap() == null || this.f56468e.getPictureInfo().pics.size() != 1) {
            return;
        }
        PictureUrl pictureUrl = pictureItem.currentUrl;
        if (pictureUrl.width > 0 || pictureUrl.height > 0) {
            return;
        }
        Pair<Integer, Integer> c16 = com.qzone.reborn.feedx.widget.picmixvideo.a.c(getContext(), com.qzone.reborn.feedx.widget.picmixvideo.b.g(this.f56468e.getFeedCommInfo().feedskey, pictureItem.currentUrl));
        if (c16 == null || ((Integer) c16.first).intValue() <= 0 || ((Integer) c16.second).intValue() <= 0) {
            final BitmapDrawable bitmapDrawable = new BitmapDrawable(option.getResultBitMap());
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.qzone.reborn.feedx.widget.picmixvideo.m
                @Override // java.lang.Runnable
                public final void run() {
                    QZoneSinglePicWidgetView.this.A0(pictureItem, bitmapDrawable);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        b bVar = this.C;
        if (bVar != null) {
            bVar.a(this.f56468e, view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private void D0(String str) {
        if (this.f56471i == null) {
            return;
        }
        Option obtain = Option.obtain();
        obtain.setUrl(str);
        if (this.f56471i.getLayoutParams() != null) {
            obtain.setRequestWidth(this.f56471i.getLayoutParams().width);
            obtain.setRequestHeight(this.f56471i.getLayoutParams().height);
        }
        com.tencent.mobileqq.qzone.picload.c.a().h(obtain);
    }

    private void s0() {
        if (this.f56468e == null) {
            QLog.e("QZoneSinglePicWidgetView", 1, "adjustViewSize params error");
            return;
        }
        b bVar = this.C;
        if (bVar != null) {
            FrameLayout.LayoutParams d16 = bVar.d(getContext(), this.f56468e, (FrameLayout.LayoutParams) this.f56470h.getLayoutParams());
            String str = "";
            if (d16 == null) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("adjustViewSize error layoutParams is null! | position = ");
                sb5.append(this.f56469f);
                sb5.append(" | text = ");
                if (this.f56468e.getCellSummaryV2() != null) {
                    str = this.f56468e.getCellSummaryV2().displayStr;
                }
                sb5.append(str);
                sb5.append(" | cellId = ");
                sb5.append(this.f56468e.getIdInfo().cellId);
                QLog.e("QZoneSinglePicWidgetView", 1, sb5.toString());
                return;
            }
            this.f56470h.setLayoutParams(d16);
            if (this.f56471i.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.f56471i.getLayoutParams();
                layoutParams.width = d16.width;
                layoutParams.height = d16.height;
                this.f56471i.setLayoutParams(layoutParams);
            }
            StringBuilder sb6 = new StringBuilder();
            sb6.append("adjustViewSize  | position = ");
            sb6.append(this.f56469f);
            sb6.append(" | text = ");
            if (this.f56468e.getCellSummaryV2() != null) {
                str = this.f56468e.getCellSummaryV2().displayStr;
            }
            sb6.append(str);
            sb6.append(" | cellId = ");
            sb6.append(this.f56468e.getIdInfo().cellId);
            sb6.append(" | realWidth = ");
            sb6.append(d16.width);
            sb6.append(" | realHeight = ");
            sb6.append(d16.height);
            QLog.i("QZoneSinglePicWidgetView", 1, sb6.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0(final LoadState loadState, final PictureItem pictureItem, final Option option) {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.qzone.reborn.feedx.widget.picmixvideo.l
            @Override // java.lang.Runnable
            public final void run() {
                QZoneSinglePicWidgetView.this.B0(pictureItem, loadState, option);
            }
        });
    }

    private void w0() {
        b bVar = this.C;
        if (bVar != null && !TextUtils.isEmpty(bVar.b(this.f56468e))) {
            String b16 = this.C.b(this.f56468e);
            Option e16 = com.tencent.mobileqq.qzone.picload.c.e(b16);
            e16.setTargetView(this.f56471i);
            if (this.f56471i.getLayoutParams() != null) {
                e16.setRequestWidth(this.f56471i.getLayoutParams().width);
                e16.setRequestHeight(this.f56471i.getLayoutParams().height);
            }
            com.qzone.reborn.util.m mVar = com.qzone.reborn.util.m.f59551a;
            e16.setLoadingDrawable(mVar.b(getContext()));
            e16.setFailDrawable(mVar.a(getContext()));
            com.tencent.mobileqq.qzone.picload.c.a().i(e16, new a(b16));
            return;
        }
        QLog.e("QZoneSinglePicWidgetView", 1, "initImageView error,mIoc is null");
    }

    private void x0() {
        b bVar = this.C;
        if (bVar == null) {
            QLog.e("QZoneSinglePicWidgetView", 1, "initImageView error,mIoc is null");
        } else {
            this.f56472m.setVisibility(bVar.c() ? 0 : 8);
            AccessibilityUtil.c(this.f56471i, com.qzone.util.l.a(this.C.c() ? R.string.f2202968q : R.string.gqp), View.class.getName());
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.chn;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        s0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: v0, reason: merged with bridge method [inline-methods] */
    public void bindData(BusinessFeedData businessFeedData, int i3) {
        this.f56468e = businessFeedData;
        this.f56469f = i3;
        s0();
        w0();
        x0();
    }

    public void z0(b bVar) {
        this.C = bVar;
    }

    public QZoneSinglePicWidgetView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        y0();
    }

    private void y0() {
        RoundCorneredFrameLayout roundCorneredFrameLayout = (RoundCorneredFrameLayout) findViewById(R.id.n6k);
        this.f56470h = roundCorneredFrameLayout;
        roundCorneredFrameLayout.setRadius(DisplayUtil.dip2px(MobileQQ.sMobileQQ, 2.0f));
        ImageView imageView = (ImageView) findViewById(R.id.n3d);
        this.f56471i = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedx.widget.picmixvideo.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZoneSinglePicWidgetView.this.C0(view);
            }
        });
        ImageView imageView2 = (ImageView) findViewById(R.id.l2y);
        this.f56472m = imageView2;
        imageView2.setImageResource(R.drawable.f15538f);
    }

    public QZoneSinglePicWidgetView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        y0();
    }
}
