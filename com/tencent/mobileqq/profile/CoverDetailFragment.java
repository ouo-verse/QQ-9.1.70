package com.tencent.mobileqq.profile;

import ProfileLogic.QC.setUserProfileRsp;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SVIPObserver;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.profile.ProfileCardManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.util.cu;
import com.tencent.mobileqq.utils.eh;
import com.tencent.mobileqq.vas.ao;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.qzone.util.SystemUtil;

/* compiled from: P */
/* loaded from: classes16.dex */
public class CoverDetailFragment extends IphoneTitleBarFragment implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    private ImageView C;
    private ImageView D;
    private Button E;
    private TextView F;
    private int G;
    private int H;
    private ProfileCardManager.a I;
    private URLDrawable.URLDrawableListener J;
    private SVIPObserver K;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CoverDetailFragment.this);
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            CoverDetailFragment.this.D.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            Drawable drawable = CoverDetailFragment.this.getBaseActivity().getResources().getDrawable(R.drawable.h7o);
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mRequestWidth = CoverDetailFragment.this.D.getWidth();
            obtain.mRequestHeight = CoverDetailFragment.this.D.getHeight();
            obtain.mLoadingDrawable = drawable;
            obtain.mFailedDrawable = drawable;
            URLDrawable drawable2 = URLDrawable.getDrawable(CoverDetailFragment.this.I.f260012e, obtain);
            drawable2.setURLDrawableListener(CoverDetailFragment.this.J);
            CoverDetailFragment.this.D.setImageDrawable(drawable2);
            CoverDetailFragment.this.C.setImageDrawable(CoverDetailFragment.this.wh(drawable2));
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class b implements URLDrawable.URLDrawableListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CoverDetailFragment.this);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable uRLDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) uRLDrawable);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) uRLDrawable, (Object) th5);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) uRLDrawable, i3);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable uRLDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) uRLDrawable);
            } else {
                CoverDetailFragment.this.C.setImageDrawable(CoverDetailFragment.this.wh(uRLDrawable));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class c extends SVIPObserver {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) CoverDetailFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.app.SVIPObserver
        public void onDefaultCardRsp(boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), obj);
                return;
            }
            BaseActivity baseActivity = CoverDetailFragment.this.getBaseActivity();
            if (baseActivity == null) {
                return;
            }
            if (z16) {
                if (obj instanceof setUserProfileRsp) {
                    int i3 = ((setUserProfileRsp) obj).ret;
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.profilecard.FrdProfileCard.CoverDetailFragment", 2, "onDefaultCardRsp: [setUserProfileRsp] ret=" + i3);
                    }
                    if (i3 != 0) {
                        CoverDetailFragment.this.xh(baseActivity);
                        return;
                    }
                    Intent intent = new Intent();
                    intent.putExtra("cover_id_key", CoverDetailFragment.this.G);
                    baseActivity.setResult(-1, intent);
                    baseActivity.finish();
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("Q.profilecard.FrdProfileCard.CoverDetailFragment", 2, "onDefaultCardRsp: isSuccess=false, cmd=" + obj);
            }
            if ("profilelogic.setUserProfile".equals(obj)) {
                CoverDetailFragment.this.xh(baseActivity);
            }
        }
    }

    public CoverDetailFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.J = new b();
            this.K = new c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xh(BaseActivity baseActivity) {
        QQToast.makeText(baseActivity, 1, R.string.i8c, 0).show();
        this.E.setBackgroundResource(R.drawable.skin_common_btn_white_unpressed);
        this.H = 1;
        this.E.setTextColor(-16777216);
        this.E.setText(R.string.cxt);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, layoutInflater, viewGroup, bundle);
            return;
        }
        BaseActivity baseActivity = getBaseActivity();
        baseActivity.getWindow().addFlags(256);
        baseActivity.getWindow().addFlags(512);
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        this.C = (ImageView) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.f164971bh3);
        this.D = (ImageView) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.f164745ar4);
        this.F = (TextView) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.bhf);
        Button button = (Button) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.f164682ak4);
        this.E = button;
        button.setOnClickListener(this);
        ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.f164920bb1).setOnClickListener(this);
        this.C.setImageDrawable(wh(null));
        getBaseActivity().app.addObserver(this.K);
        hideTitleBar();
        ViewGroup.LayoutParams layoutParams = ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.bhj).getLayoutParams();
        int notchHeight = SystemUtil.getNotchHeight(getBaseActivity(), getBaseActivity());
        if (notchHeight > layoutParams.height) {
            layoutParams.height = notchHeight;
        } else {
            int statusBarHeight = ImmersiveUtils.getStatusBarHeight(getBaseActivity());
            if (statusBarHeight > layoutParams.height) {
                layoutParams.height = statusBarHeight;
            }
        }
        this.G = baseActivity.getIntent().getIntExtra("cover_id_key", 0);
        int intExtra = baseActivity.getIntent().getIntExtra("cover_button_key", 0);
        this.H = intExtra;
        if (intExtra == 0) {
            this.E.setBackgroundResource(R.drawable.skin_common_btn_disabled);
            this.E.setTextColor(RichStatus.ACTION_COLOR_NORMAL);
            this.E.setText(R.string.cxt);
        } else if (intExtra == 2) {
            this.E.setBackgroundResource(R.drawable.skin_common_btn_disabled);
            this.E.setTextColor(RichStatus.ACTION_COLOR_NORMAL);
            this.E.setText(R.string.hgo);
        } else {
            this.E.setBackgroundResource(R.drawable.skin_common_btn_white_unpressed);
            this.E.setTextColor(-16777216);
            this.E.setText(R.string.cxt);
        }
        ProfileCardManager profileCardManager = ((ao) baseActivity.app.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).f308431i;
        if (profileCardManager != null && (i3 = this.G) > 0) {
            ProfileCardManager.a q16 = profileCardManager.q(i3, false);
            this.I = q16;
            if (q16 != null) {
                if (!TextUtils.isEmpty(q16.f260009b)) {
                    this.F.setText(this.I.f260009b);
                }
                if (!TextUtils.isEmpty(this.I.f260012e)) {
                    this.D.getViewTreeObserver().addOnGlobalLayoutListener(new a());
                    return;
                }
                return;
            }
            QLog.e("Q.profilecard.FrdProfileCard.CoverDetailFragment", 2, "item is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.layout.be8;
    }

    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment
    protected boolean isTransparent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.f164920bb1) {
                if (getBaseActivity() != null) {
                    getBaseActivity().finish();
                }
            } else if (id5 == R.id.f164682ak4) {
                int i3 = this.H;
                if (i3 == 1) {
                    if (getBaseActivity() != null && getBaseActivity().app != null && this.G > 0) {
                        QQAppInterface qQAppInterface = getBaseActivity().app;
                        ((ISVIPHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).setDefaultCardId(this.G);
                        VasWebviewUtil.reportCommercialDrainage(qQAppInterface.getCurrentAccountUin(), "defaultcard", "set_defaultcard", "", 1, 0, 0, "", Integer.toString(this.G), "");
                        this.E.setBackgroundResource(R.drawable.skin_common_btn_disabled);
                        this.E.setTextColor(RichStatus.ACTION_COLOR_NORMAL);
                        this.E.setText(HardCodeUtil.qqStr(R.string.l4y));
                        this.H = 3;
                    }
                } else if (i3 == 0 && getBaseActivity() != null) {
                    QQToast.makeText(getBaseActivity(), 0, R.string.f170685yi, 0).show();
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.onDestroy();
        if (getBaseActivity().app != null) {
            getBaseActivity().app.removeObserver(this.K);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.onResume();
            yh();
        }
    }

    public Drawable wh(Drawable drawable) {
        Bitmap copy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Drawable) iPatchRedirector.redirect((short) 5, (Object) this, (Object) drawable);
        }
        Bitmap bitmap = null;
        if (getBaseActivity() == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) drawable).getBitmap();
        } else if (drawable instanceof URLDrawable) {
            Drawable currDrawable = ((URLDrawable) drawable).getCurrDrawable();
            if (currDrawable instanceof RegionDrawable) {
                bitmap = ((RegionDrawable) currDrawable).getBitmap();
            }
        }
        if (bitmap == null) {
            copy = Bitmap.createBitmap(10, 10, Bitmap.Config.ARGB_8888);
            copy.eraseColor(-7829368);
        } else {
            copy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        }
        eh.a(copy, 40);
        return new LayerDrawable(new Drawable[]{new BitmapDrawable(getBaseActivity().getResources(), copy), new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-1728053248, -1275068417, -1})});
    }

    void yh() {
        SystemBarCompact systemBarComp;
        if (getTitleBarView() != null) {
            getTitleBarView().setBackgroundResource(0);
            getTitleBarView().setBackgroundColor(-1);
        }
        BaseActivity baseActivity = getBaseActivity();
        if (baseActivity != null && (baseActivity instanceof PublicFragmentActivity) && (systemBarComp = SystemBarActivityModule.getSystemBarComp((PublicFragmentActivity) baseActivity)) != null && needImmersive() && needStatusTrans() && ImmersiveUtils.isSupporImmersive() == 1) {
            if (ThemeUtil.isInNightMode(baseActivity.getAppRuntime())) {
                if (!cu.g() && !cu.f()) {
                    systemBarComp.setStatusBarColor(8947848);
                    return;
                } else {
                    systemBarComp.setStatusBarColor(8947848);
                    systemBarComp.setStatusBarDarkMode(true);
                    return;
                }
            }
            if (!cu.g() && !cu.f()) {
                baseActivity.getWindow().getDecorView().setSystemUiVisibility(9216);
                systemBarComp.setStatusBarColor(16777215);
            } else if (!cu.f()) {
                systemBarComp.setStatusBarColor(14408667);
            } else {
                systemBarComp.setStatusBarColor(16777215);
                systemBarComp.setStatusBarDarkMode(true);
            }
        }
    }
}
