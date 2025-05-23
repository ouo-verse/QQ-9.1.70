package com.qzone.reborn.feedx.presenter;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.qzone.personalize.business.FeedSkinData;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.feedx.presenter.vas.QZoneSkinView;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.FastDynamicDrawable;
import com.tencent.cachedrawable.dynamicdrawable.d;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.vas.VasDynamicDrawableCache;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vas.apng.api.IVasSharpPFactoryForQzone;
import com.tencent.qzonehub.api.zipanimate.IZipAnimationDrawable;
import java.io.File;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes37.dex */
public class bu extends vg.a implements View.OnClickListener {
    private static final int G = ImmersiveUtils.dpToPx(55.0f);
    private static final float H = ViewUtils.getScreenWidth() / 720.0f;
    private final ch.b F = new ch.b();

    private void O() {
        QZoneSkinView qZoneSkinView;
        View childAt = ((ViewGroup) this.f441563e).getChildAt(0);
        if (childAt instanceof QZoneSkinView) {
            qZoneSkinView = (QZoneSkinView) childAt;
        } else {
            qZoneSkinView = new QZoneSkinView(this.f441563e.getContext());
            qZoneSkinView.setContentDescription("\u8bf4\u8bf4\u5361\u7247\u88c5\u626e");
            qZoneSkinView.setScaleType(ImageView.ScaleType.FIT_XY);
        }
        M(qZoneSkinView);
        N(qZoneSkinView);
        if (qZoneSkinView.getVisibility() != 0) {
            qZoneSkinView.setVisibility(0);
        }
        if (qZoneSkinView.getParent() == null) {
            ((ViewGroup) this.f441563e).addView(qZoneSkinView, 0, new ViewGroup.LayoutParams(-1, -1));
        }
        qZoneSkinView.setSkinAlpha(com.qzone.adapter.feedcomponent.i.H().E0());
    }

    private boolean P(FeedSkinData feedSkinData) {
        return (TextUtils.isEmpty(feedSkinData.strFrameZip) || feedSkinData.iFrameRate <= 0 || U()) ? false : true;
    }

    private boolean Q() {
        return this.f441565h.getCoverInfo() == null && !TextUtils.isEmpty(this.F.e());
    }

    private boolean R() {
        return this.f441565h.getCoverInfo() == null && !TextUtils.isEmpty(this.F.f());
    }

    private boolean S(FeedSkinData feedSkinData) {
        return feedSkinData.nSkinType == 392 && !TextUtils.isEmpty(feedSkinData.sPicUrl);
    }

    private boolean T() {
        return (this.f441565h.getCoverInfo() == null && this.F.c(this.f441565h)) || U();
    }

    private boolean U() {
        return R() || Q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void V(int[] iArr, int[] iArr2, Canvas canvas, Bitmap bitmap) {
        com.tencent.mobileqq.vas.image.e eVar = new com.tencent.mobileqq.vas.image.e(bitmap, iArr, iArr2, new Rect(0, 1, 0, 0));
        eVar.setBounds(canvas.getClipBounds());
        eVar.draw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit W(FastDynamicDrawable fastDynamicDrawable, final int[] iArr, final int[] iArr2, com.tencent.cachedrawable.dynamicdrawable.d dVar) {
        fastDynamicDrawable.b(new d.b() { // from class: com.qzone.reborn.feedx.presenter.bp
            @Override // com.tencent.cachedrawable.dynamicdrawable.d.b
            public final void a(Canvas canvas, Bitmap bitmap) {
                bu.V(iArr, iArr2, canvas, bitmap);
            }
        });
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X() {
        this.F.i(this.f441565h);
        c0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y() {
        if (this.F.i(this.f441565h)) {
            this.F.l(new ch.a() { // from class: com.qzone.reborn.feedx.presenter.br
                @Override // ch.a
                public final void a() {
                    bu.this.X();
                }
            });
        } else {
            c0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z() {
        if (T()) {
            O();
        }
    }

    private void a0(QZoneSkinView qZoneSkinView, String str) {
        ViewGroup.LayoutParams layoutParams = qZoneSkinView.getLayoutParams();
        int i3 = layoutParams != null ? layoutParams.height : -2;
        if (layoutParams != null && i3 != -2) {
            layoutParams.height = -2;
        }
        final int[] iArr = {27, 47};
        final int[] iArr2 = {1, 129};
        final FastDynamicDrawable a16 = com.tencent.cachedrawable.dynamicdrawable.api.a.a().l(VasDynamicDrawableCache.INSTANCE).k(str).a();
        a16.c0(new Function1() { // from class: com.qzone.reborn.feedx.presenter.bt
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit W;
                W = bu.W(FastDynamicDrawable.this, iArr, iArr2, (com.tencent.cachedrawable.dynamicdrawable.d) obj);
                return W;
            }
        });
        qZoneSkinView.setImageDrawable(a16);
        if (layoutParams == null || i3 == -2) {
            return;
        }
        layoutParams.height = i3;
    }

    private void b0(QZoneSkinView qZoneSkinView, String str, ArrayList<Integer> arrayList) {
        FrameLayout frameLayout = (FrameLayout) this.f441563e.findViewById(R.id.mvt);
        int[] iArr = new int[2];
        this.f441563e.getLocationInWindow(iArr);
        int[] iArr2 = new int[2];
        if (frameLayout != null) {
            frameLayout.getLocationInWindow(iArr2);
            qZoneSkinView.setLvTenDetailLocation((iArr2[1] - iArr[1]) + frameLayout.getHeight());
        }
        qZoneSkinView.b(str, arrayList);
        qZoneSkinView.setBigBgDrawable(com.tencent.cachedrawable.dynamicdrawable.api.a.a().d(new File(str, "top.png").getAbsolutePath()).a());
    }

    private void c0() {
        l().post(new Runnable() { // from class: com.qzone.reborn.feedx.presenter.bs
            @Override // java.lang.Runnable
            public final void run() {
                bu.this.Z();
            }
        });
    }

    @Override // vg.a
    protected void A(BusinessFeedData businessFeedData) {
        if (VasToggle.BUG_105410810.isEnable(true) && businessFeedData != null && com.qzone.adapter.feedcomponent.i.H().d1()) {
            if (!this.F.m(this.f441565h)) {
                View childAt = ((ViewGroup) this.f441563e).getChildAt(0);
                if (!(childAt instanceof QZoneSkinView) || childAt.getVisibility() == 8) {
                    return;
                }
                childAt.setVisibility(8);
                return;
            }
            this.F.k();
            ThreadManagerV2.excute(new Runnable() { // from class: com.qzone.reborn.feedx.presenter.bq
                @Override // java.lang.Runnable
                public final void run() {
                    bu.this.Y();
                }
            }, 16, null, false);
        }
    }

    @Override // vg.a
    /* renamed from: k */
    protected String getTAG() {
        return "QZoneFeedVipBackgroundPresenter";
    }

    @Override // vg.a
    protected int s() {
        return 0;
    }

    @Override // vg.a
    protected boolean x() {
        return false;
    }

    private void M(QZoneSkinView qZoneSkinView) {
        Drawable optimizedApngDrawable;
        qZoneSkinView.setImageDrawable(null);
        qZoneSkinView.setBigBgDrawable(null);
        qZoneSkinView.a();
        qZoneSkinView.setIsDetail(com.qzone.reborn.feedx.util.x.f55790a.c(o()));
        FeedSkinData cellFeedSkinInfo = this.f441565h.getCellFeedSkinInfo();
        String g16 = this.F.g(this.f441565h);
        String e16 = this.F.e();
        String f16 = this.F.f();
        if (R()) {
            b0(qZoneSkinView, f16, cellFeedSkinInfo.lv10Numbers);
            return;
        }
        if (Q()) {
            if (e16.contains("shp")) {
                optimizedApngDrawable = ((IVasSharpPFactoryForQzone) QRoute.api(IVasSharpPFactoryForQzone.class)).getSharpPURLDrawable(e16, e16);
            } else {
                optimizedApngDrawable = VasApngUtil.getOptimizedApngDrawable(e16, e16, new ColorDrawable(16777215), VasApngUtil.VIP_APNG_TAGS, "luxury_10", null);
            }
            qZoneSkinView.setBigBgDrawable(optimizedApngDrawable);
            return;
        }
        if (S(cellFeedSkinInfo)) {
            a0(qZoneSkinView, cellFeedSkinInfo.sPicUrl);
        } else {
            if (TextUtils.isEmpty(g16)) {
                return;
            }
            a0(qZoneSkinView, g16);
        }
    }

    private void N(QZoneSkinView qZoneSkinView) {
        qZoneSkinView.setFgDrawable(null);
        FeedSkinData cellFeedSkinInfo = this.f441565h.getCellFeedSkinInfo();
        if (P(cellFeedSkinInfo)) {
            Drawable zipAnimationDrawable = ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).getZipAnimationDrawable();
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setAnimationRes(zipAnimationDrawable, cellFeedSkinInfo.strFrameZip, cellFeedSkinInfo.iFrameRate);
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setScale(zipAnimationDrawable, H);
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).clearFirstFrame(zipAnimationDrawable);
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setRepeatAnimation(zipAnimationDrawable, true);
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setShowLastFrameWhenStop(zipAnimationDrawable, true);
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).start(zipAnimationDrawable);
            qZoneSkinView.setFgDrawable(zipAnimationDrawable);
        }
    }

    @Override // vg.a
    protected void C(View view) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
