package com.tencent.biz.subscribe.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.utils.Md5Utils;
import java.io.File;
import java.util.ArrayList;
import ve0.b;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class AbsSubscribeShareCardView extends FrameLayout {
    public static final int E = ScreenUtil.dip2px(311.0f);
    public static final int F = ScreenUtil.dip2px(415.0f);
    public static final int G = ScreenUtil.dip2px(375.0f);
    public static final int H = ScreenUtil.dip2px(701.0f);
    public static final int I = ScreenUtil.dip2px(667.0f);
    protected View C;
    private volatile int D;

    /* renamed from: d, reason: collision with root package name */
    public float f96360d;

    /* renamed from: e, reason: collision with root package name */
    protected b f96361e;

    /* renamed from: f, reason: collision with root package name */
    protected Bitmap f96362f;

    /* renamed from: h, reason: collision with root package name */
    protected View f96363h;

    /* renamed from: i, reason: collision with root package name */
    protected ArrayList<String> f96364i;

    /* renamed from: m, reason: collision with root package name */
    protected ArrayList<ImageView> f96365m;

    /* compiled from: P */
    /* renamed from: com.tencent.biz.subscribe.widget.AbsSubscribeShareCardView$2, reason: invalid class name */
    /* loaded from: classes5.dex */
    class AnonymousClass2 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ArrayList f96367d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f96368e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f96369f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ ArrayList f96370h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ a f96371i;

        AnonymousClass2(ArrayList arrayList, int i3, String str, ArrayList arrayList2, a aVar) {
            this.f96367d = arrayList;
            this.f96368e = i3;
            this.f96369f = str;
            this.f96370h = arrayList2;
            this.f96371i = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            HttpNetReq httpNetReq = new HttpNetReq();
            httpNetReq.mCallback = new INetEngineListener() { // from class: com.tencent.biz.subscribe.widget.AbsSubscribeShareCardView.2.1
                @Override // com.tencent.mobileqq.transfile.INetEngineListener
                public void onResp(NetResp netResp) {
                    if (netResp.mResult == 0) {
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        ((ImageView) anonymousClass2.f96367d.get(anonymousClass2.f96368e)).setImageBitmap(SafeBitmapFactory.decodeFile(AnonymousClass2.this.f96369f));
                        AbsSubscribeShareCardView.this.D++;
                        if (AbsSubscribeShareCardView.this.D == AnonymousClass2.this.f96370h.size()) {
                            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.subscribe.widget.AbsSubscribeShareCardView.2.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    a aVar = AnonymousClass2.this.f96371i;
                                    if (aVar != null) {
                                        aVar.onLoadSuccessed(null);
                                    }
                                }
                            });
                            return;
                        }
                        return;
                    }
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.subscribe.widget.AbsSubscribeShareCardView.2.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            a aVar = AnonymousClass2.this.f96371i;
                            if (aVar != null) {
                                aVar.onLoadFialed(null, null);
                            }
                        }
                    });
                }

                @Override // com.tencent.mobileqq.transfile.INetEngineListener
                public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
                }
            };
            httpNetReq.mReqUrl = (String) this.f96370h.get(this.f96368e);
            httpNetReq.mHttpMethod = 0;
            httpNetReq.mOutPath = this.f96369f;
            httpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
            QQStoryContext.h();
            ((IHttpEngineService) QQStoryContext.a().getRuntimeService(IHttpEngineService.class, "all")).sendReq(httpNetReq);
        }
    }

    public AbsSubscribeShareCardView(Context context) {
        this(context, null);
    }

    public void c(FrameLayout frameLayout, int i3, int i16) {
        int i17;
        int i18;
        int i19 = I;
        if (i() != null) {
            if (i3 != 0 && i16 != 0 && i3 != i16) {
                if (i3 > i16) {
                    i17 = E;
                    i18 = (int) (i17 / this.f96360d);
                } else {
                    i19 = H;
                    i17 = E;
                    i18 = Math.min((int) (i17 * this.f96360d), F);
                }
            } else {
                i17 = E;
                i18 = i17;
            }
            i().getLayoutParams().width = i17;
            i().getLayoutParams().height = i18;
            i().setLayoutParams(i().getLayoutParams());
            if (frameLayout != null) {
                frameLayout.getLayoutParams().width = i17;
                frameLayout.getLayoutParams().height = i19 - ScreenUtil.dip2px(168.0f);
                frameLayout.setLayoutParams(frameLayout.getLayoutParams());
            }
            this.C.getLayoutParams().height = i19;
            measure(G, i19);
            layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void e(b bVar, Bitmap bitmap, a aVar) {
        this.f96361e = bVar;
        this.f96362f = bitmap;
        measure(G, I);
        layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(ArrayList<String> arrayList, ArrayList<ImageView> arrayList2, final a aVar) {
        if (arrayList != null && arrayList.size() == arrayList2.size()) {
            this.D = 0;
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                String str = SubscribeQRCodeShareHelper.f96413l + Md5Utils.getMD5(arrayList.get(i3)) + ".png";
                if (new File(str).exists()) {
                    arrayList2.get(i3).setImageBitmap(SafeBitmapFactory.decodeFile(str));
                    this.D++;
                    if (this.D == arrayList.size()) {
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.subscribe.widget.AbsSubscribeShareCardView.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a aVar2 = aVar;
                                if (aVar2 != null) {
                                    aVar2.onLoadSuccessed(null);
                                }
                            }
                        });
                    }
                } else {
                    ThreadManagerV2.executeOnFileThread(new AnonymousClass2(arrayList2, i3, str, arrayList, aVar));
                }
            }
        }
    }

    public abstract int g();

    public Bitmap h() {
        try {
            View view = this.C;
            if (view == null) {
                return null;
            }
            Bitmap createBitmap = Bitmap.createBitmap(view.getLayoutParams().width, this.C.getLayoutParams().height, Bitmap.Config.RGB_565);
            this.C.draw(new Canvas(createBitmap));
            return createBitmap;
        } catch (Throwable unused) {
            QLog.d("AbsSubscribeShareCardView", 4, "failed to get bitmap from view");
            return null;
        }
    }

    protected abstract URLImageView i();

    public abstract void j(View view);

    public AbsSubscribeShareCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AbsSubscribeShareCardView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f96360d = 1.3333334f;
        this.f96364i = new ArrayList<>();
        this.f96365m = new ArrayList<>();
        setWillNotDraw(false);
        View inflate = LayoutInflater.from(getContext()).inflate(g(), this);
        this.f96363h = inflate;
        j(inflate);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static abstract class a implements URLDrawable.URLDrawableListener {
        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public abstract void onLoadSuccessed(URLDrawable uRLDrawable);

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable uRLDrawable) {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
        }
    }

    public void d() {
    }
}
