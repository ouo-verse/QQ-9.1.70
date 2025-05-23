package com.tencent.mobileqq.login.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.aj;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \"2\u00020\u00012\u00020\u0002:\u0001#B\u0007\u00a2\u0006\u0004\b \u0010!J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002J\n\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\r\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\nH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J&\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u001a\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u001f\u001a\u00020\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001aH\u0016\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/login/fragment/LoginRegisterGuideFragment;", "Lcom/tencent/mobileqq/login/fragment/BaseLoginFragment;", "Landroid/view/View$OnClickListener;", "Landroid/widget/ImageView;", "logoIv", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "scaleRatio", "marginRatio", "", "Zh", "Th", "Uh", "Vh", "", "Sh", "", "tValue", "Yh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "v", NodeProps.ON_CLICK, "<init>", "()V", "K", "a", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class LoginRegisterGuideFragment extends BaseLoginFragment implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0007\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/login/fragment/LoginRegisterGuideFragment$a;", "", "", "GATEWAY_GET_PHONE_WAITING_TIME", "J", "", "REPORT_TVALUE_WELCOMEPAGE_LOGIN_CLICK", "Ljava/lang/String;", "REPORT_TVALUE_WELCOMEPAGE_NEW_USER_CLICK", "REPORT_TVALUE_WELCOMEPAGE_SHOW", "TAG", "TOGGLE_GATEWAY_GET_MASK_PHONE", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.login.fragment.LoginRegisterGuideFragment$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21027);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public LoginRegisterGuideFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final long Sh() {
        long n3 = aj.f306554f.n(3000L);
        if (n3 < 100) {
            n3 = 0;
        }
        QLog.i("LoginRegisterGuideFragment", 1, "getGatewayGetPhoneWaitingTime: " + n3);
        return n3;
    }

    private final Bitmap Th() {
        InputStream inputStream;
        Bitmap bitmap = null;
        try {
            try {
                inputStream = BaseApplication.getContext().getAssets().open(com.tencent.mobileqq.splash.f.f288712a.d());
            } catch (Throwable th5) {
                th = th5;
                inputStream = null;
            }
            try {
                bitmap = BitmapFactory.decodeStream(inputStream);
            } catch (Throwable th6) {
                th = th6;
                try {
                    QLog.e("LoginRegisterGuideFragment", 1, "getSplashLogoBitmap error:", th);
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    return bitmap;
                } catch (Throwable th7) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e16) {
                            QLog.e("LoginRegisterGuideFragment", 1, "close error:", e16);
                        }
                    }
                    throw th7;
                }
            }
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (IOException e17) {
            QLog.e("LoginRegisterGuideFragment", 1, "close error:", e17);
        }
        return bitmap;
    }

    private final void Uh() {
        Intent intent;
        Yh("0X8007575");
        Yh("0X800AA26");
        FragmentActivity activity = getActivity();
        if (activity != null) {
            intent = activity.getIntent();
        } else {
            intent = null;
        }
        if (intent == null) {
            intent = new Intent();
        }
        int e16 = l.f242160a.e(intent);
        if (e16 != 3 && e16 != 4) {
            Hh(e16, intent.getExtras(), false);
        } else {
            aj.f306554f.t(this, intent.getExtras(), Sh());
        }
    }

    private final void Vh() {
        Yh("0X8007576");
        Yh("0X800AA25");
        QBaseActivity qBaseActivity = getQBaseActivity();
        if (qBaseActivity != null) {
            com.tencent.mobileqq.register.n.f280469a.m(qBaseActivity, 5, null, true, false, false, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Wh(final LoginRegisterGuideFragment this$0, final ImageView imageView) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        final Bitmap Th = this$0.Th();
        if (Th == null) {
            return;
        }
        com.tencent.mobileqq.splash.f fVar = com.tencent.mobileqq.splash.f.f288712a;
        final float e16 = fVar.e();
        final float c16 = fVar.c();
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.login.fragment.n
            @Override // java.lang.Runnable
            public final void run() {
                LoginRegisterGuideFragment.Xh(LoginRegisterGuideFragment.this, imageView, Th, e16, c16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Xh(LoginRegisterGuideFragment this$0, ImageView logoIv, Bitmap bitmap, float f16, float f17) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(bitmap, "$bitmap");
        Intrinsics.checkNotNullExpressionValue(logoIv, "logoIv");
        this$0.Zh(logoIv, bitmap, f16, f17);
    }

    private final void Yh(String tValue) {
        ReportController.o(getAppRuntime(), "CliOper", "", "", tValue, tValue, 0, 0, "", "", "", "");
    }

    private final void Zh(ImageView logoIv, Bitmap bitmap, float scaleRatio, float marginRatio) {
        Resources resources;
        FragmentActivity activity = getActivity();
        ViewGroup.MarginLayoutParams marginLayoutParams = null;
        if (activity != null) {
            resources = activity.getResources();
        } else {
            resources = null;
        }
        if (resources == null) {
            return;
        }
        int i3 = (int) (scaleRatio * resources.getDisplayMetrics().widthPixels);
        int height = (bitmap.getHeight() * i3) / bitmap.getWidth();
        ViewGroup.LayoutParams layoutParams = logoIv.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        }
        if (marginLayoutParams == null) {
            return;
        }
        marginLayoutParams.width = i3;
        marginLayoutParams.height = height;
        marginLayoutParams.bottomMargin = (int) (marginRatio * height);
        logoIv.setLayoutParams(marginLayoutParams);
        logoIv.setImageBitmap(bitmap);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) v3);
        } else {
            if (v3 != null) {
                num = Integer.valueOf(v3.getId());
            } else {
                num = null;
            }
            if (num != null && num.intValue() == R.id.btn_register) {
                Vh();
            } else if (num != null && num.intValue() == R.id.btn_login) {
                Uh();
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            inflate = (View) iPatchRedirector.redirect((short) 2, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            inflate = inflater.inflate(R.layout.gyj, container, false);
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.mobileqq.login.fragment.BaseLoginFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        final ImageView imageView = (ImageView) view.findViewById(R.id.dwa);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.login.fragment.m
            @Override // java.lang.Runnable
            public final void run() {
                LoginRegisterGuideFragment.Wh(LoginRegisterGuideFragment.this, imageView);
            }
        }, 64, null, true);
        view.findViewById(R.id.btn_register).setOnClickListener(this);
        view.findViewById(R.id.btn_login).setOnClickListener(this);
        l.f242160a.s(true);
        Yh("0X800AA24");
    }
}
