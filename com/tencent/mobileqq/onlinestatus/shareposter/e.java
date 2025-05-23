package com.tencent.mobileqq.onlinestatus.shareposter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.config.avatar.AvatarViewConfig;
import com.tencent.mobileqq.config.avatar.ConfigData;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.onlinestatus.af;
import com.tencent.mobileqq.onlinestatus.au;
import com.tencent.mobileqq.onlinestatus.bs;
import com.tencent.mobileqq.onlinestatus.utils.OnlineStatusToggleUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IContactUtilsApi;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class e extends ShareActionSheetV2 {
    private ViewGroup J0;
    private View K0;
    protected com.tencent.mobileqq.onlinestatus.model.g L0;
    protected boolean M0;
    private String N0;
    private Bitmap O0;

    public e(ShareActionSheetV2.Param param) {
        super(param);
    }

    private void r0() {
        View view;
        WeakReference<Context> weakReference = this.f317430e;
        if (weakReference != null && weakReference.get() != null && (view = this.G) != null && this.J0 == null) {
            view.findViewById(R.id.f84204lm).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.onlinestatus.shareposter.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    e.this.x0(view2);
                }
            });
            ViewGroup viewGroup = (ViewGroup) this.G.findViewById(R.id.f84444m_);
            this.J0 = viewGroup;
            viewGroup.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.onlinestatus.shareposter.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    e.y0(view2);
                }
            });
            View inflate = View.inflate(this.f317430e.get(), u0(), null);
            Resources resources = this.f317430e.get().getResources();
            float dimension = resources.getDimension(R.dimen.bwx);
            float dimension2 = resources.getDimension(R.dimen.bww);
            float width = this.J0.getWidth() / dimension;
            inflate.setScaleX(width);
            inflate.setScaleY(width);
            inflate.setPivotX(0.0f);
            inflate.setPivotY(0.0f);
            this.J0.addView(inflate, new FrameLayout.LayoutParams((int) dimension, (int) dimension2));
            this.K0 = inflate;
            AnimationSet animationSet = new AnimationSet(true);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setInterpolator(new LinearInterpolator());
            animationSet.addAnimation(alphaAnimation);
            ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f, 1.0f, 0.8f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setInterpolator(new DecelerateInterpolator());
            animationSet.addAnimation(scaleAnimation);
            animationSet.setDuration(450L);
            this.J0.startAnimation(animationSet);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void y0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z0(DialogInterface dialogInterface) {
        if (QLog.isColorLevel()) {
            QLog.d("OnlineStatusShareActionSheet", 2, "onShow ", Integer.valueOf(this.N.getHeight()));
        }
        D0();
    }

    protected void A0(Drawable drawable) {
        View view = this.G;
        if (view == null) {
            return;
        }
        ((ImageView) view.findViewById(R.id.zxn)).setImageDrawable(drawable);
    }

    protected void B0() {
        View view = this.G;
        if (view == null) {
            return;
        }
        ((ImageView) view.findViewById(R.id.zy_)).setImageDrawable(URLDrawable.getDrawable(this.N0, URLDrawable.URLDrawableOptions.obtain()));
    }

    protected void C0(AppInterface appInterface) {
        View view = this.G;
        if (view == null) {
            return;
        }
        ((ImageView) view.findViewById(R.id.gqx)).setImageDrawable(FaceDrawable.getFaceDrawable(appInterface, 1, appInterface.getCurrentUin()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x017d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void D0() {
        Drawable O;
        AppRuntime.Status status;
        String str;
        String str2;
        String str3;
        String str4;
        WeakReference<Context> weakReference;
        String str5;
        ArrayList<au> arrayList;
        boolean z16;
        boolean z17;
        r0();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!(peekAppRuntime instanceof AppInterface)) {
            QLog.e("OnlineStatusShareActionSheet", 1, "bindData error, app is not AppInterface!");
            return;
        }
        AppInterface appInterface = (AppInterface) peekAppRuntime;
        if (this.L0 == null) {
            QLog.e("OnlineStatusShareActionSheet", 1, "bindData error, mOnlineStatusData is null!");
            return;
        }
        if (this.G == null) {
            QLog.e("OnlineStatusShareActionSheet", 1, "show dialog error! No showing view!");
            return;
        }
        B0();
        ImageView imageView = (ImageView) this.G.findViewById(R.id.f59152ry);
        ImageView imageView2 = (ImageView) this.G.findViewById(R.id.f59162rz);
        TextView textView = (TextView) this.G.findViewById(R.id.f61792z3);
        TextView textView2 = (TextView) this.G.findViewById(R.id.f84264ls);
        TextView textView3 = (TextView) this.G.findViewById(R.id.zy5);
        TextView textView4 = (TextView) this.G.findViewById(R.id.f84474mc);
        ImageView imageView3 = (ImageView) this.G.findViewById(R.id.f84484md);
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            imageView.setImageDrawable(BaseImageUtil.maskDrawableByColor(drawable, t0()));
        }
        Drawable drawable2 = imageView2.getDrawable();
        if (drawable2 != null) {
            imageView2.setImageDrawable(BaseImageUtil.maskDrawableByColor(drawable2, t0()));
        }
        C0(appInterface);
        textView.setText(((IContactUtilsApi) QRoute.api(IContactUtilsApi.class)).getBuddyName(appInterface.getCurrentUin(), false));
        textView2.setText(new SimpleDateFormat("yyyy.MM.dd").format(Long.valueOf(NetConnInfoCenter.getServerTimeMillis())));
        af C = af.C();
        com.tencent.mobileqq.onlinestatus.model.g gVar = this.L0;
        au I = C.I(gVar.f256022a, gVar.f256023b);
        com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c H = bs.H("OnlineStatusShareActionSheet");
        if (H == null) {
            QLog.e("OnlineStatusShareActionSheet", 1, "updateSharePosterContainer simpleInfo is null");
            return;
        }
        AppRuntime.Status status2 = this.L0.f256022a;
        AppRuntime.Status status3 = AppRuntime.Status.online;
        if (status2 == status3) {
            af C2 = af.C();
            if (I.f255489b > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!C2.h0(I, H, z17)) {
                O = af.C().O(0L, status3, 1, H, 0);
                A0(com.tencent.mobileqq.onlinestatus.utils.j.a(O));
                if (I.f255489b != 2000) {
                    if (this.L0.f256022a == status3) {
                        af C3 = af.C();
                        if (I.f255489b > 0) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        status = status3;
                        str = C3.x(appInterface, H, textView3, 3, I, Boolean.valueOf(z16));
                    } else {
                        status = status3;
                        str = af.C().o(appInterface, I, this.L0.f256022a, H, textView3, 3);
                    }
                } else {
                    status = status3;
                    str = I.f255490c;
                }
                textView3.setText(str);
                com.tencent.mobileqq.onlinestatus.model.g gVar2 = this.L0;
                int i3 = bs.r(gVar2.f256022a, gVar2.f256023b).f256383a;
                int t16 = bs.t(H, i3);
                ConfigData f16 = AvatarViewConfig.INSTANCE.a().f(i3, t16);
                str2 = "";
                if (!OnlineStatusToggleUtils.d()) {
                    if (I.f255489b == 1000 && I.f255494g == status && (arrayList = I.f255512y) != null && arrayList.size() > 0 && I.f255512y.size() > t16) {
                        I = I.f255512y.get(t16);
                    }
                    if (TextUtils.isEmpty(I.f255508u)) {
                        str5 = "";
                    } else {
                        str5 = I.f255508u;
                    }
                    if (!TextUtils.isEmpty(I.f255509v)) {
                        str2 = I.f255509v;
                    }
                    str3 = str2;
                    str2 = str5;
                } else if (f16 == null) {
                    str3 = "";
                } else {
                    if (TextUtils.isEmpty(f16.getPosterText())) {
                        str4 = "";
                    } else {
                        str4 = f16.getPosterText();
                    }
                    if (!TextUtils.isEmpty(f16.getPosterStatusTextColor())) {
                        str2 = f16.getPosterStatusTextColor();
                    }
                    String str6 = str2;
                    str2 = str4;
                    str3 = str6;
                }
                if (!TextUtils.isEmpty(str2)) {
                    textView4.setText(str2);
                }
                if (!TextUtils.isEmpty(str3) && !this.M0) {
                    try {
                        textView3.setTextColor(Color.parseColor(str3));
                    } catch (Throwable unused) {
                        QLog.e("OnlineStatusShareActionSheet", 1, "parse posterTextColor error, color is ", str3);
                    }
                }
                if (this.M0 && (weakReference = this.f317430e) != null && weakReference.get() != null) {
                    textView3.setTextColor(this.f317430e.get().getColor(R.color.cez));
                }
                imageView3.setImageBitmap(this.O0);
            }
        }
        af C4 = af.C();
        com.tencent.mobileqq.onlinestatus.model.g gVar3 = this.L0;
        O = C4.O(gVar3.f256023b, gVar3.f256022a, 1, H, 0);
        A0(com.tencent.mobileqq.onlinestatus.utils.j.a(O));
        if (I.f255489b != 2000) {
        }
        textView3.setText(str);
        com.tencent.mobileqq.onlinestatus.model.g gVar22 = this.L0;
        int i36 = bs.r(gVar22.f256022a, gVar22.f256023b).f256383a;
        int t162 = bs.t(H, i36);
        ConfigData f162 = AvatarViewConfig.INSTANCE.a().f(i36, t162);
        str2 = "";
        if (!OnlineStatusToggleUtils.d()) {
        }
        if (!TextUtils.isEmpty(str2)) {
        }
        if (!TextUtils.isEmpty(str3)) {
            textView3.setTextColor(Color.parseColor(str3));
        }
        if (this.M0) {
            textView3.setTextColor(this.f317430e.get().getColor(R.color.cez));
        }
        imageView3.setImageBitmap(this.O0);
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheetV2
    protected int I() {
        return R.layout.f167529dq0;
    }

    public void s0(com.tencent.mobileqq.onlinestatus.model.g gVar, String str, Bitmap bitmap) {
        this.L0 = gVar;
        if (TextUtils.isEmpty(str)) {
            this.N0 = "https://online-status-avatar.cdn-go.cn/resources/0.0.9/filament/bg_resource/state_bg_cedff1.png";
            this.M0 = true;
        } else {
            this.N0 = str;
        }
        this.O0 = bitmap;
        setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.tencent.mobileqq.onlinestatus.shareposter.b
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                e.this.z0(dialogInterface);
            }
        });
    }

    protected int t0() {
        return -16777216;
    }

    protected int u0() {
        return R.layout.f167532dq3;
    }

    public ViewGroup v0() {
        return this.J0;
    }

    public View w0() {
        return this.K0;
    }
}
