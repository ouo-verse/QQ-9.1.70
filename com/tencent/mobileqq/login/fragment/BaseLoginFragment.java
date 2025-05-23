package com.tencent.mobileqq.login.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.constants.TangramHippyConstants;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quipolarlight.QUIPolarLightView;
import com.tencent.biz.qui.quipolarlight.a;
import com.tencent.biz.qui.quipolarlight.render.PolarImageRender;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.LoginPublicFragmentActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.login.aa;
import com.tencent.mobileqq.login.aj;
import com.tencent.mobileqq.login.am;
import com.tencent.mobileqq.login.api.ILoginReporter;
import com.tencent.mobileqq.login.y;
import com.tencent.mobileqq.loginregister.ILoginRegisterApi;
import com.tencent.mobileqq.loginregister.z;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import com.tencent.util.LoadingUtil;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0016\u0018\u0000 V2\u00020\u0001:\u0001WB\u0007\u00a2\u0006\u0004\bT\u0010UJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\nH\u0002J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\nH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\b\u0010\u0015\u001a\u00020\u0004H\u0016J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\u0012\u0010\u0019\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u001a\u001a\u00020\rH\u0016J\b\u0010\u001b\u001a\u00020\rH\u0016J\u000e\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\bJ\u0010\u0010 \u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eJ\u0006\u0010!\u001a\u00020\u0004J\b\u0010\"\u001a\u00020\u0004H\u0016J\"\u0010&\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\u001e2\b\u0010%\u001a\u0004\u0018\u00010\u000fH\u0016J\u0018\u0010)\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\b2\u0006\u0010(\u001a\u00020'H\u0016J\u0010\u0010*\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\bH\u0016J\u0010\u0010+\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u001eH\u0016J\"\u0010/\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\b2\b\u0010-\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010.\u001a\u00020\rJ\u000e\u00101\u001a\u0002002\u0006\u0010#\u001a\u00020\bJ\u0006\u00103\u001a\u000202J\b\u00104\u001a\u00020\u0004H\u0016R\"\u0010,\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010B\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0014\u0010E\u001a\u00020\r8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bC\u0010DR\u0011\u0010I\u001a\u00020F8F\u00a2\u0006\u0006\u001a\u0004\bG\u0010HR\u0011\u0010K\u001a\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\bJ\u00108R\u0011\u0010M\u001a\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\bL\u00108R\u0011\u0010O\u001a\u00020\r8F\u00a2\u0006\u0006\u001a\u0004\bN\u0010DR\u0011\u0010Q\u001a\u00020\r8F\u00a2\u0006\u0006\u001a\u0004\bP\u0010DR\u0011\u0010S\u001a\u00020\r8F\u00a2\u0006\u0006\u001a\u0004\bR\u0010D\u00a8\u0006X"}, d2 = {"Lcom/tencent/mobileqq/login/fragment/BaseLoginFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "Ch", OcrConfig.CHINESE, "Bh", "", "qh", "", "vh", "xh", "", "Dh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/content/Intent;", "intent", "onNewIntent", "needStatusTrans", "needImmersive", "msgId", "Oh", "", "msg", UIJsPlugin.EVENT_SHOW_LOADING, UIJsPlugin.EVENT_HIDE_LOADING, "Ph", TangramHippyConstants.LOGIN_TYPE, "uin", "bundle", "Lh", "Lcom/tencent/mobileqq/login/aj;", "failedInfo", "Kh", "Jh", "Mh", "fragmentType", "arguments", "forceRoot", "Hh", "Lcom/tencent/mobileqq/login/aa;", "th", "Lcom/tencent/mobileqq/login/y;", "wh", "onPostThemeChanged", BdhLogUtil.LogTag.Tag_Conn, "I", "rh", "()I", "Nh", "(I)V", "Landroid/app/Dialog;", "D", "Landroid/app/Dialog;", "loadingDialog", "Lcom/tencent/biz/qui/quipolarlight/QUIPolarLightView;", "E", "Lcom/tencent/biz/qui/quipolarlight/QUIPolarLightView;", "polarLightView", "yh", "()Z", "needShowBack", "Lmqq/app/AppRuntime;", "getAppRuntime", "()Lmqq/app/AppRuntime;", "appRuntime", "uh", "loginEntrance", "sh", "fromEntrance", "Eh", "isNestedLogin", "Gh", "isSubAccountLogin", "Fh", "isOpenSdkAddAccount", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public class BaseLoginFragment extends QPublicBaseFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static float G;

    @NotNull
    private static final List<Integer> H;

    @NotNull
    private static final List<Integer> I;

    @NotNull
    private static final a.b J;

    /* renamed from: C, reason: from kotlin metadata */
    private int fragmentType;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private Dialog loadingDialog;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private QUIPolarLightView polarLightView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0005R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\tR\u0014\u0010\u000f\u001a\u00020\u000e8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\t\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/login/fragment/BaseLoginFragment$a;", "", "", "", "POLAR_RENDER_COLORS_DEFAULT", "Ljava/util/List;", "POLAR_RENDER_COLORS_NIGHT", "", "POLAR_RENDER_FREQUENCY", UserInfo.SEX_FEMALE, "Lcom/tencent/biz/qui/quipolarlight/a$b;", "POLAR_RENDER_GRADIENT", "Lcom/tencent/biz/qui/quipolarlight/a$b;", "POLAR_RENDER_OFFSET", "", "TAG", "Ljava/lang/String;", "polarLightFrame", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.login.fragment.BaseLoginFragment$a, reason: from kotlin metadata */
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
        List<Integer> listOf;
        List<Integer> listOf2;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20934);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 30)) {
            redirector.redirect((short) 30);
            return;
        }
        INSTANCE = new Companion(null);
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(Color.parseColor("#FFEEB4")), Integer.valueOf(Color.parseColor("#FABCFF")), Integer.valueOf(Color.parseColor("#BAB8FF")), Integer.valueOf(Color.parseColor("#BDCFFF")), Integer.valueOf(Color.parseColor("#A3F0FF")), Integer.valueOf(Color.parseColor("#F3FFF6"))});
        H = listOf;
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(Color.parseColor("#094789")), Integer.valueOf(Color.parseColor("#393BB8")), Integer.valueOf(Color.parseColor("#623982")), Integer.valueOf(Color.parseColor("#733E71")), Integer.valueOf(Color.parseColor("#804956")), Integer.valueOf(Color.parseColor("#80674A"))});
        I = listOf2;
        J = new a.b(0.7f, 0.5f, 0.3f, 0.5f, 0.0f);
    }

    public BaseLoginFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ah(BaseLoginFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Bh(View rootView) {
        QUIPolarLightView qUIPolarLightView;
        List<Integer> list;
        if (getAppRuntime().isLogin() || Eh() || Gh() || Fh() || (qUIPolarLightView = (QUIPolarLightView) rootView.findViewById(R.id.f26270d3)) == null) {
            return;
        }
        this.polarLightView = qUIPolarLightView;
        qUIPolarLightView.setVisibility(0);
        ViewGroup.LayoutParams layoutParams = qUIPolarLightView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = (int) (ViewUtils.getScreenHeight() * 0.6d);
        }
        PolarImageRender polarLightRender = qUIPolarLightView.getPolarLightRender();
        polarLightRender.p(0.025f);
        polarLightRender.r(0.5f);
        polarLightRender.q(J);
        if (Dh()) {
            list = I;
        } else {
            list = H;
        }
        polarLightRender.s(list);
    }

    private final void Ch(View rootView) {
        String str;
        boolean z16;
        int i3;
        String str2;
        boolean z17;
        int i16;
        boolean z18;
        boolean z19;
        Intent intent;
        Intent intent2;
        View findViewById = rootView.findViewById(R.id.yur);
        if (findViewById == null) {
            return;
        }
        ImageView imageView = (ImageView) findViewById.findViewById(R.id.f61782z2);
        TextView textView = (TextView) findViewById.findViewById(R.id.yud);
        TextView textView2 = (TextView) findViewById.findViewById(R.id.yun);
        FragmentActivity activity = getActivity();
        String str3 = null;
        if (activity != null && (intent2 = activity.getIntent()) != null) {
            str = intent2.getStringExtra("key_login_page_title");
        } else {
            str = null;
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null && (intent = activity2.getIntent()) != null) {
            str3 = intent.getStringExtra("key_login_page_sub_title");
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        textView.setVisibility(i3);
        String str4 = "";
        if (str == null) {
            str2 = "";
        } else {
            str2 = str;
        }
        textView.setText(str2);
        if (str3 != null && str3.length() != 0) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (z17) {
            i16 = 8;
        } else {
            i16 = 0;
        }
        textView2.setVisibility(i16);
        if (str3 != null) {
            str4 = str3;
        }
        textView2.setText(str4);
        if (str != null && str.length() != 0) {
            z18 = false;
        } else {
            z18 = true;
        }
        if (z18) {
            if (str3 != null && str3.length() != 0) {
                z19 = false;
            } else {
                z19 = true;
            }
            if (z19) {
                imageView.setVisibility(0);
                imageView.setImageResource(R.drawable.ojp);
                if (AppSetting.f99565y) {
                    imageView.setImportantForAccessibility(1);
                    imageView.setFocusable(true);
                    imageView.setContentDescription(getString(R.string.f170384pb));
                    return;
                }
                return;
            }
        }
        imageView.setVisibility(8);
    }

    private final boolean Dh() {
        Context context = getContext();
        if (context != null) {
            return com.tencent.biz.qui.quicommon.a.b(ContextCompat.getColor(context, R.color.qui_common_bg_bottom_standard));
        }
        return QQTheme.isNowThemeIsNight();
    }

    public static /* synthetic */ void Ih(BaseLoginFragment baseLoginFragment, int i3, Bundle bundle, boolean z16, int i16, Object obj) {
        if (obj == null) {
            if ((i16 & 4) != 0) {
                z16 = false;
            }
            baseLoginFragment.Hh(i3, bundle, z16);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: jumpLoginFragment");
    }

    private final int qh() {
        int i3 = this.fragmentType;
        if (i3 != 3) {
            if (i3 != 4) {
                if (i3 != 5) {
                    if (i3 != 6) {
                        return 0;
                    }
                    return 14;
                }
                return 13;
            }
            if ((this instanceof PhoneNumLoginFragment) && ((PhoneNumLoginFragment) this).xi()) {
                return 11;
            }
            return 12;
        }
        return 10;
    }

    private final List<Integer> vh() {
        List<Integer> listOf;
        List<Integer> emptyList;
        List<Integer> listOf2;
        List<Integer> listOf3;
        List<Integer> listOf4;
        List<Integer> emptyList2;
        int i3 = this.fragmentType;
        if (i3 == 3) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(10);
            return listOf;
        }
        if (i3 != 4) {
            if (i3 == 5) {
                listOf3 = CollectionsKt__CollectionsJVMKt.listOf(13);
                return listOf3;
            }
            if (i3 != 6) {
                emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                return emptyList2;
            }
            listOf4 = CollectionsKt__CollectionsJVMKt.listOf(14);
            return listOf4;
        }
        if (!(this instanceof PhoneNumLoginFragment) || !((PhoneNumLoginFragment) this).xi()) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{11, 12});
        return listOf2;
    }

    private final List<Integer> xh() {
        List<Integer> listOf;
        List<Integer> emptyList;
        List<Integer> listOf2;
        List<Integer> listOf3;
        List<Integer> listOf4;
        List<Integer> emptyList2;
        int i3 = this.fragmentType;
        if (i3 == 3) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(4);
            return listOf;
        }
        if (i3 != 4) {
            if (i3 == 5) {
                listOf3 = CollectionsKt__CollectionsJVMKt.listOf(1);
                return listOf3;
            }
            if (i3 != 6) {
                emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                return emptyList2;
            }
            listOf4 = CollectionsKt__CollectionsJVMKt.listOf(8);
            return listOf4;
        }
        if (!(this instanceof PhoneNumLoginFragment) || !((PhoneNumLoginFragment) this).xi()) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{5, 7});
        return listOf2;
    }

    private final boolean yh() {
        if (getActivity() instanceof LoginActivity) {
            return z.l(getActivity());
        }
        return true;
    }

    private final void zh(View rootView) {
        String str;
        View findViewById = rootView.findViewById(R.id.a47);
        if (findViewById == null) {
            return;
        }
        if (yh()) {
            findViewById.setVisibility(0);
            if (AppSetting.f99565y) {
                FragmentActivity activity = getActivity();
                if (activity == null || (str = activity.getString(R.string.f211435kt)) == null) {
                    str = "";
                }
                AccessibilityUtil.p(findViewById, str);
            }
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.login.fragment.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BaseLoginFragment.Ah(BaseLoginFragment.this, view);
                }
            });
            return;
        }
        findViewById.setVisibility(8);
    }

    public final boolean Eh() {
        Intent intent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        FragmentActivity activity = getActivity();
        if (activity == null || (intent = activity.getIntent()) == null) {
            return false;
        }
        return intent.getBooleanExtra("key_login_nested_login", false);
    }

    public final boolean Fh() {
        Intent intent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        FragmentActivity activity = getActivity();
        if (activity == null || (intent = activity.getIntent()) == null) {
            return false;
        }
        return intent.getBooleanExtra("is_open_sdk_add_account", false);
    }

    public final boolean Gh() {
        Intent intent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        FragmentActivity activity = getActivity();
        if (activity == null || (intent = activity.getIntent()) == null) {
            return false;
        }
        return intent.getBooleanExtra("is_sub_account_login", false);
    }

    public final void Hh(int fragmentType, @Nullable Bundle arguments, boolean forceRoot) {
        Bundle bundle;
        Intent intent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, Integer.valueOf(fragmentType), arguments, Boolean.valueOf(forceRoot));
            return;
        }
        if (getActivity() == null) {
            QLog.w("BaseLoginFragment", 1, "jumpLoginFragment but activity is null");
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null) {
            bundle = intent.getExtras();
        } else {
            bundle = null;
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (arguments != null) {
            bundle.putAll(arguments);
        }
        if (fragmentType == 3 && Fh()) {
            fragmentType = 4;
        }
        l.f242160a.m(getActivity(), fragmentType, bundle, forceRoot);
    }

    public void Jh(int loginType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, loginType);
            return;
        }
        QLog.d("BaseLoginFragment", 1, getClass().getName() + " onLoginCancel loginType=" + loginType);
        Ph();
    }

    public void Kh(int loginType, @NotNull aj failedInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, loginType, (Object) failedInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(failedInfo, "failedInfo");
        QLog.d("BaseLoginFragment", 1, getClass().getName() + " onLoginFailed loginType=" + loginType + " ret=" + failedInfo.f241864a + " errorMsg=" + failedInfo.f241866c);
        Ph();
    }

    public void Lh(int loginType, @NotNull String uin, @Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, Integer.valueOf(loginType), uin, bundle);
            return;
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        QLog.d("BaseLoginFragment", 1, getClass().getName() + " onLoginSuccess loginType=" + loginType + " uin=" + StringUtil.getSimpleUinForPrint(uin));
    }

    public void Mh(@NotNull String uin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) uin);
        } else {
            Intrinsics.checkNotNullParameter(uin, "uin");
            hideLoading();
        }
    }

    public final void Nh(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            this.fragmentType = i3;
        }
    }

    public final void Oh(int msgId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, msgId);
        } else {
            showLoading(BaseApplication.getContext().getString(msgId));
        }
    }

    public void Ph() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
        }
    }

    @NotNull
    public final AppRuntime getAppRuntime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AppRuntime) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (getQBaseActivity() != null) {
            AppRuntime appRuntime = getQBaseActivity().getAppRuntime();
            Intrinsics.checkNotNullExpressionValue(appRuntime, "{\n            qBaseActivity.appRuntime\n        }");
            return appRuntime;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "{\n            MobileQQ.s\u2026eekAppRuntime()\n        }");
        return peekAppRuntime;
    }

    public final void hideLoading() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        Dialog dialog = this.loadingDialog;
        if (dialog != null && dialog.isShowing()) {
            try {
                dialog.dismiss();
            } catch (Exception e16) {
                QLog.e("BaseLoginFragment", 1, "hideLoading exception", e16);
            }
        }
        this.loadingDialog = null;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        FragmentActivity activity;
        Bundle arguments;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) savedInstanceState);
            return;
        }
        super.onCreate(savedInstanceState);
        l.f242160a.p(this);
        if ((getActivity() instanceof LoginPublicFragmentActivity) && (arguments = getArguments()) != null) {
            this.fragmentType = arguments.getInt("loginFragmentType", 0);
        }
        am.c();
        if (savedInstanceState != null && am.f241878a.g(this) && (activity = getActivity()) != null) {
            activity.finish();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        super.onDestroy();
        hideLoading();
        Ph();
        l.f242160a.q(this);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onNewIntent(@Nullable Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) intent);
        } else {
            super.onNewIntent(intent);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        super.onPause();
        QUIPolarLightView qUIPolarLightView = this.polarLightView;
        if (qUIPolarLightView != null) {
            G = qUIPolarLightView.getPolarLightRender().getFirstFrame();
            qUIPolarLightView.stopAnimation();
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public void onPostThemeChanged() {
        PolarImageRender polarImageRender;
        List<Integer> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this);
            return;
        }
        super.onPostThemeChanged();
        boolean Dh = Dh();
        QUIPolarLightView qUIPolarLightView = this.polarLightView;
        if (qUIPolarLightView != null) {
            polarImageRender = qUIPolarLightView.getPolarLightRender();
        } else {
            polarImageRender = null;
        }
        if (polarImageRender != null) {
            if (Dh) {
                list = I;
            } else {
                list = H;
            }
            polarImageRender.s(list);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        List<Integer> vh5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        super.onResume();
        if (this.fragmentType != 1 && !((ILoginRegisterApi) QRoute.api(ILoginRegisterApi.class)).isLoggingIn()) {
            List<Integer> xh5 = xh();
            if (sh() != 0) {
                vh5 = CollectionsKt__CollectionsJVMKt.listOf(Integer.valueOf(sh()));
            } else {
                vh5 = vh();
            }
            Iterator<Integer> it = xh5.iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                Iterator<Integer> it5 = vh5.iterator();
                while (it5.hasNext()) {
                    ((ILoginReporter) QRoute.api(ILoginReporter.class)).reportLoginPageExposure(it5.next().intValue(), intValue);
                }
            }
        }
        QUIPolarLightView qUIPolarLightView = this.polarLightView;
        if (qUIPolarLightView != null) {
            qUIPolarLightView.getPolarLightRender().n(G);
            qUIPolarLightView.m();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Ch(view);
        zh(view);
        Bh(view);
    }

    public final int rh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.fragmentType;
    }

    public final int sh() {
        Intent intent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        FragmentActivity activity = getActivity();
        if (activity == null || (intent = activity.getIntent()) == null) {
            return 0;
        }
        return intent.getIntExtra("key_login_page_entrance", 0);
    }

    public final void showLoading(@Nullable String msg2) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) msg2);
            return;
        }
        boolean isEmpty = TextUtils.isEmpty(msg2);
        Dialog dialog = this.loadingDialog;
        if (dialog != null && dialog.isShowing()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!(isEmpty | z16) && getQBaseActivity() != null && !getQBaseActivity().isFinishing()) {
            try {
                Dialog showLoadingDialog = LoadingUtil.showLoadingDialog(getQBaseActivity(), msg2, false);
                this.loadingDialog = showLoadingDialog;
                if (showLoadingDialog != null) {
                    showLoadingDialog.show();
                }
            } catch (Exception e16) {
                QLog.e("BaseLoginFragment", 1, "showLoading exception", e16);
            }
        }
    }

    @NotNull
    public final aa th(int loginType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (aa) iPatchRedirector.redirect((short) 27, (Object) this, loginType);
        }
        return new v(this, loginType);
    }

    public final int uh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        int sh5 = sh();
        if (sh5 == 0) {
            return qh();
        }
        return sh5;
    }

    @NotNull
    public final y wh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (y) iPatchRedirector.redirect((short) 28, (Object) this);
        }
        return new w(this);
    }
}
