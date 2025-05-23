package com.qzone.homepage.ui.Facade.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.qzone.common.account.LoginData;
import com.qzone.homepage.ui.Facade.FacadeVideoDownLoaderManager;
import com.qzone.homepage.ui.Facade.e;
import com.qzone.homepage.ui.Facade.h;
import com.qzone.homepage.ui.Facade.i;
import com.qzone.homepage.ui.Facade.j;
import com.qzone.widget.AsyncImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.media.image.BitmapReference;
import com.tencent.component.media.image.ImageManager;
import com.tencent.component.media.image.drawable.ImageDrawable;
import com.tencent.jalpha.videoplayer.render.AlphaBlendRender;
import com.tencent.jalpha.videoplayer.render.BaseRender;
import com.tencent.jalpha.videoplayer.render.RenderFactory;
import com.tencent.jalpha.videoplayer.view.JalphaTextureView;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.VasDynamicDrawableCache;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.qq.effect.alphavideo.videoplayer.view.PlayTextureView;
import cooperation.qzone.QZoneHelper;
import java.io.File;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FacadeView extends ViewGroup implements RenderFactory {
    private double C;
    private double D;
    private boolean E;
    private View.OnClickListener F;
    private int G;
    private Activity H;
    private int I;
    private boolean J;
    private PlayTextureView K;
    private JalphaTextureView L;
    private int M;

    /* renamed from: d, reason: collision with root package name */
    private AsyncImageView f47646d;

    /* renamed from: e, reason: collision with root package name */
    private CustomPhotoView f47647e;

    /* renamed from: f, reason: collision with root package name */
    private List<i> f47648f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f47649h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f47650i;

    /* renamed from: m, reason: collision with root package name */
    private final int f47651m;

    public FacadeView(Context context) {
        this(context, null);
    }

    private void d(View view, i iVar) {
        if (this.M == 1 && (iVar instanceof j) && (view instanceof TextView) && !TextUtils.isEmpty(iVar.f47611c)) {
            int i3 = iVar.f47618j;
            int i16 = (int) (i3 * 1.4d);
            int i17 = i16 - i3;
            if (i17 > 0) {
                ((TextView) view).setGravity(((j) iVar).f47625q);
                iVar.f47617i -= i17 / 2;
                iVar.f47618j = i16;
            }
        }
        if ((iVar instanceof com.qzone.homepage.ui.Facade.b) && (view instanceof EditableView)) {
            com.qzone.homepage.ui.Facade.b bVar = (com.qzone.homepage.ui.Facade.b) iVar;
            EditableView editableView = (EditableView) view;
            int i18 = iVar.f47618j;
            int i19 = (int) (i18 * 1.4d);
            int i26 = i19 - i18;
            if (i26 <= 0) {
                return;
            }
            int i27 = bVar.f47617i;
            bVar.f47559r = i27;
            bVar.f47560s = bVar.f47618j;
            editableView.setTopOfText(i27);
            editableView.setHeighOfText(bVar.f47560s);
            editableView.setGravity(bVar.f47558q);
            iVar.f47617i -= i26 / 2;
            iVar.f47618j = i19;
        }
    }

    private double f(double d16) {
        double d17 = this.D;
        return (d16 - (d17 / 2.0d)) / (1.0d - d17);
    }

    private double g(double d16) {
        double d17 = this.C;
        return (d16 - (d17 / 2.0d)) / (1.0d - d17);
    }

    private void n(View view, int i3) {
        if (view instanceof TextView) {
            ((TextView) view).setTextSize(1, ViewUtils.pxToDp(i3) * 0.65f);
        } else if (view instanceof EditableView) {
            ((EditableView) view).setTextSize(ViewUtils.pxToDp(i3) * 0.65f);
        }
    }

    public void a(List<i> list, String str, boolean z16) {
        this.f47648f = list;
        c();
        b(str, z16);
        if (list == null || list.size() < 1) {
            return;
        }
        for (i iVar : list) {
            View c16 = iVar.c(this);
            c16.setTag(iVar);
            if (iVar.f47610b == 3) {
                if (c16 instanceof CustomPhotoView) {
                    this.f47647e = (CustomPhotoView) c16;
                    addView(c16, 1);
                } else {
                    addView(c16, 0);
                }
            } else {
                addView(c16);
            }
        }
        invalidate();
    }

    public void b(String str, boolean z16) {
        if (TextUtils.isEmpty(str) || QZoneHelper.isInQzoneFacadeDynamicBlackList()) {
            return;
        }
        if (z16) {
            this.L = new JalphaTextureView(getContext());
            this.L.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.L.setRenderFactory(this);
            this.L.setEnabled(true);
            addView(this.L);
            this.L.setOpaque(false);
            this.L.setLoopState(true);
            String d16 = FacadeVideoDownLoaderManager.d(str);
            if (this.L != null && d16 != null && !d16.trim().equals("")) {
                this.L.setContentVisible(true);
                this.L.playFile(d16);
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("op", "show");
            StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(LoginData.getInstance().getUinString(), "qzone_jalpha_video", true, 0L, 0L, hashMap, null);
            return;
        }
        this.K = new PlayTextureView(getContext());
        this.K.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.K.setEnabled(true);
        addView(this.K);
        this.K.setOpaque(false);
        this.K.setLoopState(true);
        String d17 = FacadeVideoDownLoaderManager.d(str);
        if (this.K == null || d17 == null || d17.trim().equals("")) {
            return;
        }
        this.K.setContentVisible(true);
        this.K.playFile(d17);
    }

    public void c() {
        removeAllViews();
        addView(this.f47646d);
    }

    @Override // com.tencent.jalpha.videoplayer.render.RenderFactory
    public BaseRender createRender() {
        return new AlphaBlendRender();
    }

    public Activity i() {
        return this.H;
    }

    public int j() {
        return this.M;
    }

    public int k() {
        return this.I;
    }

    public boolean m() {
        return this.f47649h;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        PlayTextureView playTextureView = this.K;
        if (playTextureView != null) {
            playTextureView.setContentVisible(false);
            this.K.stop();
            this.K = null;
        }
        JalphaTextureView jalphaTextureView = this.L;
        if (jalphaTextureView != null) {
            jalphaTextureView.setContentVisible(false);
            this.L.stop();
            this.L = null;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.J && !this.f47649h;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        int childCount = getChildCount();
        int i19 = i17 - i3;
        int i26 = i18 - i16;
        for (int i27 = 0; i27 < childCount; i27++) {
            View childAt = getChildAt(i27);
            if (this.f47646d != childAt && this.K != childAt && this.L != childAt) {
                i iVar = (i) childAt.getTag();
                childAt.layout(iVar.f47616h - 0, iVar.f47617i - 0, (childAt.getMeasuredWidth() + iVar.f47616h) - 0, (childAt.getMeasuredHeight() + iVar.f47617i) - 0);
            } else {
                childAt.layout(0, 0, i19, i26);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        int size = View.MeasureSpec.getSize(i16);
        int size2 = View.MeasureSpec.getSize(i3);
        int childCount = getChildCount();
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt = getChildAt(i17);
            if (this.f47646d != childAt && this.K != childAt && this.L != childAt) {
                i iVar = (i) childAt.getTag();
                double d16 = size;
                iVar.f47617i = (int) Math.round(g(iVar.f47613e) * d16);
                iVar.f47618j = (int) Math.round(d16 * e(iVar.f47614f));
                double d17 = size2;
                iVar.f47616h = (int) Math.round(f(iVar.f47612d) * d17);
                int round = (int) Math.round(d17 * h(iVar.f47615g));
                iVar.f47619k = round;
                if (iVar instanceof j) {
                    if (iVar.f47616h < 0) {
                        iVar.f47616h = 0;
                    }
                    if (round > size2) {
                        iVar.f47619k = size2;
                    }
                }
                n(childAt, iVar.f47618j);
                d(childAt, iVar);
                if ((iVar instanceof e) && ((e) iVar).f47584n) {
                    iVar.f47618j = iVar.f47619k;
                }
                childAt.measure(ViewGroup.getChildMeasureSpec(i3, 0, iVar.f47619k), ViewGroup.getChildMeasureSpec(i16, 0, iVar.f47618j));
            } else {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                childAt.measure(ViewGroup.getChildMeasureSpec(i3, 0, layoutParams.width), ViewGroup.getChildMeasureSpec(i16, 0, layoutParams.height));
            }
        }
        setMeasuredDimension(size2, size);
    }

    public void setCanVisit(boolean z16) {
        this.E = z16;
    }

    public void setEditable(boolean z16) {
        this.f47649h = z16;
    }

    public void setFacadeImage(String str, int i3, int i16) {
        Bitmap decodeFile;
        this.f47646d.setAsyncRootFilePath(h.l().j());
        if (this.M == 1) {
            try {
                File localFileByUrl = ImageManager.getLocalFileByUrl(getContext(), str, h.l().i());
                if (localFileByUrl != null && (decodeFile = BitmapFactory.decodeFile(localFileByUrl.getAbsolutePath())) != null) {
                    this.f47646d.setImageDrawable(new com.qzone.homepage.ui.Facade.c().process(new ImageDrawable(BitmapReference.getBitmapReference(decodeFile))));
                }
            } catch (OutOfMemoryError unused) {
            }
        } else if (VasNormalToggle.VAS_QZONE_NEW_IMAGE_LOADER.isEnable(true)) {
            this.f47646d.setImageDrawable(com.tencent.cachedrawable.dynamicdrawable.api.a.a().k(str).l(VasDynamicDrawableCache.INSTANCE).a());
        } else {
            this.f47646d.setAsyncImage(str);
        }
        this.C = com.qzone.homepage.ui.Facade.c.a(i3, i16);
        this.D = com.qzone.homepage.ui.Facade.c.b(i3, i16);
        invalidate();
        requestLayout();
    }

    public void setFacadeStyle(int i3) {
        this.G = i3;
    }

    public void setFixedJump(View.OnClickListener onClickListener) {
        this.F = onClickListener;
    }

    public void setJumpBySchemeAllow(boolean z16) {
        this.f47650i = z16;
    }

    public FacadeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void l() {
        setBackgroundColor(-1);
        this.f47646d = new AsyncImageView(getContext());
        this.f47646d.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f47646d.setAsyncImageProcessor(new com.qzone.homepage.ui.Facade.c());
        this.f47646d.setScaleType(ImageView.ScaleType.FIT_XY);
        addView(this.f47646d);
    }

    public void setModeAsFullScreenPreview() {
        this.M = 5;
    }

    public void setModeAsViewGuest() {
        this.M = 3;
    }

    public void setModeAsViewSelf() {
        this.M = 2;
    }

    public FacadeView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f47651m = ViewUtils.dpToPx(10.0f);
        this.J = false;
        l();
    }

    private double e(double d16) {
        return d16 / (1.0d - this.C);
    }

    private double h(double d16) {
        return d16 / (1.0d - this.D);
    }
}
