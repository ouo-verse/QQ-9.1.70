package com.tencent.mobileqq.zplan.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.utils.PagLoader;
import com.tencent.widget.immersive.ImmersiveUtils;
import org.libpag.PAGView;

/* loaded from: classes34.dex */
public class ZPlanAvatarSettingLoadingView extends LinearLayout implements PagLoader.b {

    /* renamed from: d, reason: collision with root package name */
    private final PagLoader f335909d;

    /* renamed from: e, reason: collision with root package name */
    private PAGView f335910e;

    /* renamed from: f, reason: collision with root package name */
    private ViewStub f335911f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f335912h;

    public ZPlanAvatarSettingLoadingView(Context context) {
        this(context, null);
    }

    private URLDrawable c() {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mFailedDrawable = new ColorDrawable(15464447);
        obtain.mLoadingDrawable = new ColorDrawable(15464447);
        return URLDrawable.getDrawable("https://downv6.qq.com/extendfriend/893_zplanavatarsetting_loadingbg.png", obtain);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.f335909d.d()) {
            if (this.f335910e == null) {
                PAGView pAGView = (PAGView) this.f335911f.inflate().findViewById(R.id.q6o);
                this.f335910e = pAGView;
                pAGView.setRepeatCount(0);
                this.f335910e.setVisibility(0);
            }
            this.f335910e.setComposition(PagViewMonitor.Load(getContext().getAssets(), "zplan/zplan_avatar_edit_loading_anim.pag"));
            if (!this.f335912h || this.f335910e.isPlaying()) {
                return;
            }
            this.f335910e.play();
            this.f335912h = false;
        }
    }

    private void e(Context context) {
        Drawable c16;
        LayoutInflater.from(context).inflate(R.layout.d2w, this);
        ImageView imageView = (ImageView) findViewById(R.id.q6q);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        boolean isNowThemeIsNight = QQTheme.isNowThemeIsNight();
        if (isNowThemeIsNight) {
            c16 = new ColorDrawable(-16777216);
        } else {
            c16 = c();
        }
        imageView.setImageDrawable(c16);
        int i3 = isNowThemeIsNight ? -1 : -16777216;
        ((TextView) findViewById(R.id.q6z)).setTextColor(i3);
        ((TextView) findViewById(R.id.qrs)).setTextColor(i3);
        ((ImageView) findViewById(R.id.pfb)).setColorFilter(i3);
        ((LinearLayout) findViewById(R.id.qi9)).setPadding(0, ImmersiveUtils.getStatusBarHeight(getContext()), 0, 0);
        this.f335911f = (ViewStub) findViewById(R.id.q6p);
        f();
    }

    private void f() {
        if (this.f335909d.d()) {
            d();
        } else {
            QLog.i("ZPlanAvatarSettingLoadingView", 4, "pag is not loaded waiting loading");
            this.f335909d.f(getContext(), this);
        }
    }

    public void b() {
        PAGView pAGView = this.f335910e;
        if (pAGView != null) {
            pAGView.stop();
        }
        setVisibility(8);
    }

    @Override // com.tencent.sqshow.zootopia.utils.PagLoader.b
    public void onComplete(boolean z16) {
        QLog.i("ZPlanAvatarSettingLoadingView", 4, "loadPag result:" + z16);
        if (z16) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.view.ZPlanAvatarSettingLoadingView.1
                @Override // java.lang.Runnable
                public void run() {
                    ZPlanAvatarSettingLoadingView.this.d();
                }
            });
        }
    }

    public ZPlanAvatarSettingLoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void g() {
        setVisibility(0);
        PAGView pAGView = this.f335910e;
        if (pAGView != null && !pAGView.isPlaying()) {
            this.f335910e.play();
        } else {
            this.f335912h = true;
        }
    }

    public ZPlanAvatarSettingLoadingView(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public ZPlanAvatarSettingLoadingView(Context context, AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        this.f335909d = PagLoader.c();
        this.f335912h = false;
        e(context);
    }
}
