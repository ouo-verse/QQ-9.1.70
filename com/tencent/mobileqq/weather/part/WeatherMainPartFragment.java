package com.tencent.mobileqq.weather.part;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyRouter;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.weather.event.WeatherMainPageActivityResultEvent;
import com.tencent.mobileqq.weather.event.WeatherMainPageLifeCircleEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.QzoneIPCModule;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 (2\u00020\u0001:\u0001)B\u0007\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016J\b\u0010\t\u001a\u00020\bH\u0014J&\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0002H\u0016J\u0012\u0010\u0015\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0016\u001a\u00020\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u0002H\u0016J\b\u0010\u0018\u001a\u00020\u0002H\u0016J\"\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016R\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/weather/part/WeatherMainPartFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", "setStatusBarImmersive", "ph", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "", "getContentLayoutId", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "", "isWrapContent", "onPostThemeChanged", "onCreate", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "", BdhLogUtil.LogTag.Tag_Conn, "J", "mEnterTime", "", "D", "Ljava/lang/String;", "mJumpFrom", "<init>", "()V", "E", "a", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class WeatherMainPartFragment extends QPublicBaseFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private long mEnterTime;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private String mJumpFrom;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/weather/part/WeatherMainPartFragment$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.weather.part.WeatherMainPartFragment$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42838);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public WeatherMainPartFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mJumpFrom = "";
        }
    }

    private final void ph() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
            QPublicFragmentActivity.start(getContext(), activity.getIntent(), WeatherMainPartFragment.class);
        }
    }

    private final void setStatusBarImmersive() {
        if (getQBaseActivity() == null) {
            QLog.e("WeatherMainPartFragment", 1, "setStatusBarImmersive qBaseActivity is null");
            return;
        }
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            if (SystemBarActivityModule.getSystemBarComp(getQBaseActivity()) == null) {
                SystemBarActivityModule.setImmersiveStatus(getQBaseActivity(), 0);
                return;
            }
            SystemBarActivityModule.getSystemBarComp(getQBaseActivity()).setStatusBarDrawable(null);
            SystemBarActivityModule.getSystemBarComp(getQBaseActivity()).setStatusBarColor(0);
            SystemBarActivityModule.getSystemBarComp(getQBaseActivity()).setStatusColor(0);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Nullable
    public List<Part> assembleParts() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new WeatherTitlePart());
        arrayList.add(new WeatherMainPart());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return R.layout.h7e;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
        } else {
            super.onActivityResult(requestCode, resultCode, data);
            SimpleEventBus.getInstance().dispatchEvent(new WeatherMainPageActivityResultEvent(new WeakReference(getActivity()), requestCode, resultCode, data));
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Bundle bundle;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) savedInstanceState);
            return;
        }
        super.onCreate(savedInstanceState);
        com.tencent.mobileqq.weather.util.report.j.f313683a.c();
        Bundle arguments = getArguments();
        if (arguments == null || (bundle = arguments.getBundle("params")) == null) {
            bundle = new Bundle();
        }
        String pageUrl = bundle.getString("url", "");
        String str = "0";
        String isFromShare = bundle.getString("isFromShare", "0");
        String b16 = com.tencent.mobileqq.weather.util.b.b(pageUrl, ReportConstant.COSTREPORT_PREFIX);
        Intrinsics.checkNotNullExpressionValue(b16, "getPageUrlParamValue(pag\u2026tant.EXTRA_KEY_JUMP_FROM)");
        this.mJumpFrom = b16;
        com.tencent.mobileqq.weather.util.g gVar = com.tencent.mobileqq.weather.util.g.f313646a;
        if (gVar.I(pageUrl, Intrinsics.areEqual(isFromShare, "1"))) {
            if (com.tencent.mobileqq.weather.util.b.f(getActivity(), QQPermissionConstants.Business.SCENE.WEATHER_H5)) {
                str = "1";
            }
            Context context = getContext();
            if (context != null) {
                IQQKuiklyRouter iQQKuiklyRouter = (IQQKuiklyRouter) QRoute.api(IQQKuiklyRouter.class);
                Intrinsics.checkNotNullExpressionValue(pageUrl, "pageUrl");
                Intrinsics.checkNotNullExpressionValue(isFromShare, "isFromShare");
                iQQKuiklyRouter.jump(context, gVar.C(pageUrl, isFromShare, str));
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View onCreateView;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            onCreateView = (View) iPatchRedirector.redirect((short) 4, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            setStatusBarImmersive();
            Activity hostActivity = getHostActivity();
            if (hostActivity != null) {
                Bundle bundleExtra = hostActivity.getIntent().getBundleExtra("params");
                com.tencent.mobileqq.weather.util.g gVar = com.tencent.mobileqq.weather.util.g.f313646a;
                if (bundleExtra != null) {
                    str = bundleExtra.getString("url");
                } else {
                    str = null;
                }
                if (gVar.M(str)) {
                    if (gVar.F()) {
                        com.tencent.mobileqq.weather.webpage.f.f313714a.p(hostActivity, "1");
                    } else {
                        gVar.O(hostActivity, gVar.g());
                    }
                }
            }
            onCreateView = super.onCreateView(inflater, container, savedInstanceState);
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView);
        return onCreateView;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            super.onDestroy();
            SimpleEventBus.getInstance().dispatchEvent(new WeatherMainPageLifeCircleEvent(5));
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        super.onPause();
        com.tencent.mobileqq.weather.util.report.j jVar = com.tencent.mobileqq.weather.util.report.j.f313683a;
        String currentAccountUinFromRuntime = getQBaseActivity().getCurrentAccountUinFromRuntime();
        Intrinsics.checkNotNullExpressionValue(currentAccountUinFromRuntime, "qBaseActivity.currentAccountUinFromRuntime");
        jVar.e(currentAccountUinFromRuntime, this.mEnterTime, System.currentTimeMillis());
        SimpleEventBus.getInstance().dispatchEvent(new WeatherMainPageLifeCircleEvent(3));
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public void onPostThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.onPostThemeChanged();
        QLog.d("WeatherMainPartFragment", 1, "onPostThemeChanged");
        ph();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.onResume();
        this.mEnterTime = System.currentTimeMillis();
        com.tencent.mobileqq.weather.util.h.f313657a.c(com.tencent.mobileqq.weather.data.f.f313296a.o());
        com.tencent.mobileqq.weather.util.report.j jVar = com.tencent.mobileqq.weather.util.report.j.f313683a;
        boolean f16 = com.tencent.mobileqq.weather.util.b.f(getActivity(), QQPermissionConstants.Business.SCENE.WEATHER_H5);
        String str = this.mJumpFrom;
        if (str.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            str = "0";
        }
        jVar.d(f16, str);
        SimpleEventBus.getInstance().dispatchEvent(new WeatherMainPageLifeCircleEvent(2));
    }
}
