package com.tencent.mobileqq.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.AuthDevOpenUgActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.FaceIdentificationEnablePreFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.loginregister.IFaceIdentificationEnablePrePageApi;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.servlet.LoginVerifyServlet;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.util.av;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.ao;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import com.tencent.util.LoadingUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Marker;
import tencent.im.login.GetLocalPhone$MaskPhoneData;
import tencent.im.login.GetLocalPhone$OIDBGetPhoneRsp;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 Q2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002RSB\u0007\u00a2\u0006\u0004\bO\u0010PJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J$\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u001a\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0018\u001a\u00020\u0006H\u0016J\b\u0010\u0019\u001a\u00020\u0006H\u0016J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u0006H\u0016J\u0012\u0010\u001f\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010 \u001a\u00020\u0004H\u0016J\b\u0010!\u001a\u00020\u0004H\u0016J\b\u0010\"\u001a\u00020\u0004H\u0016J\b\u0010#\u001a\u00020\u0004H\u0016J\n\u0010$\u001a\u0004\u0018\u00010\rH\u0016J\n\u0010&\u001a\u0004\u0018\u00010%H\u0016J\n\u0010(\u001a\u0004\u0018\u00010'H\u0016R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010/\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00102\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0018\u00104\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00101R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u00108\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u00106R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010>\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b=\u00106R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010D\u001a\u00020?8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bC\u0010AR\u0016\u0010F\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bE\u00106R\u0018\u0010J\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010N\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010M\u00a8\u0006T"}, d2 = {"Lcom/tencent/mobileqq/fragment/FaceIdentificationEnablePreFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mobileqq/fragment/k;", "", "ph", "", "rh", "Landroid/view/View;", "root", "initViews", "sh", "finishActivity", "", "qh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "needStatusTrans", "needImmersive", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "onBackEvent", "v", NodeProps.ON_CLICK, "onDetach", MosaicConstants$JsFunction.FUNC_ON_DESTROY, UIJsPlugin.EVENT_SHOW_LOADING, UIJsPlugin.EVENT_HIDE_LOADING, "k2", "Landroid/app/Activity;", "d0", "Lmqq/app/AppRuntime;", "getAppRuntime", "Lcom/tencent/mobileqq/app/QBaseActivity;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/app/QBaseActivity;", "mQBaseActivity", "D", "Lmqq/app/AppRuntime;", "mAppRuntime", "E", "Ljava/lang/String;", "phoneNum", UserInfo.SEX_FEMALE, "countryCode", "G", "Landroid/view/View;", "H", "backBtn", "Landroid/widget/Button;", "I", "Landroid/widget/Button;", "confirmBtn", "J", "layoutPhoneNum", "Landroid/widget/TextView;", "K", "Landroid/widget/TextView;", "textPhoneNum", "L", "textCountryCode", "M", "space", "Landroid/app/Dialog;", "N", "Landroid/app/Dialog;", "loadingDialog", "Lcom/tencent/mobileqq/fragment/FaceIdentificationEnablePreFragment$b;", "P", "Lcom/tencent/mobileqq/fragment/FaceIdentificationEnablePreFragment$b;", "faceIdentificationPhoneTokenHandler", "<init>", "()V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "b", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class FaceIdentificationEnablePreFragment extends QPublicBaseFragment implements View.OnClickListener, k {
    static IPatchRedirector $redirector_;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private QBaseActivity mQBaseActivity;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private AppRuntime mAppRuntime;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private String phoneNum;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private String countryCode;

    /* renamed from: G, reason: from kotlin metadata */
    private View root;

    /* renamed from: H, reason: from kotlin metadata */
    private View backBtn;

    /* renamed from: I, reason: from kotlin metadata */
    private Button confirmBtn;

    /* renamed from: J, reason: from kotlin metadata */
    private View layoutPhoneNum;

    /* renamed from: K, reason: from kotlin metadata */
    private TextView textPhoneNum;

    /* renamed from: L, reason: from kotlin metadata */
    private TextView textCountryCode;

    /* renamed from: M, reason: from kotlin metadata */
    private View space;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private Dialog loadingDialog;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private b faceIdentificationPhoneTokenHandler;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/fragment/FaceIdentificationEnablePreFragment$a;", "", "", "GET_MASK_PHONE_MAX_TIME", "J", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.fragment.FaceIdentificationEnablePreFragment$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
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

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001,B\u000f\u0012\u0006\u0010)\u001a\u00020&\u00a2\u0006\u0004\b*\u0010+J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u001c\u0010\u000b\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\u0006\u0010\r\u001a\u00020\u0002J\u001c\u0010\u0010\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\bH\u0016J$\u0010\u0015\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\bH\u0016J\u0006\u0010\u0016\u001a\u00020\u0002J\u000e\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\bR\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010$\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u001eR\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020&0%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010'\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/fragment/FaceIdentificationEnablePreFragment$b;", "Lcom/tencent/mobileqq/observer/c;", "", "g", "Ltencent/im/login/GetLocalPhone$MaskPhoneData;", "data", DomainData.DOMAIN_NAME, "i", "", "openId", "tmpKey", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "o", "openid", "tmpkey", "getTmpKeySuccess", "cmd", "", "code", "message", "onFailedResponse", "j", BaseConstants.ATTR_KET_PHONE_TOKEN, tl.h.F, "d", "Ltencent/im/login/GetLocalPhone$MaskPhoneData;", "maskPhoneData", "", "e", "J", "requestMaskPhoneStartTime", "", "f", "Z", "isRequestingMaskPhone", "clickVerifyBtnTime", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/fragment/k;", "Lmqq/util/WeakReference;", "baseViewRef", "baseView", "<init>", "(Lcom/tencent/mobileqq/fragment/k;)V", "a", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b extends com.tencent.mobileqq.observer.c {
        static IPatchRedirector $redirector_;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private GetLocalPhone$MaskPhoneData maskPhoneData;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private long requestMaskPhoneStartTime;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private boolean isRequestingMaskPhone;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private long clickVerifyBtnTime;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<k> baseViewRef;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/fragment/FaceIdentificationEnablePreFragment$b$a;", "", "", "BTN_CLICK_DURATION", "J", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.fragment.FaceIdentificationEnablePreFragment$b$a, reason: from kotlin metadata */
        /* loaded from: classes12.dex */
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

        @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/fragment/FaceIdentificationEnablePreFragment$b$b", "Lne1/a;", "Ltencent/im/login/GetLocalPhone$OIDBGetPhoneRsp;", "data", "", "a", "", "errorCode", "", "errorMsg", "onFail", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.fragment.FaceIdentificationEnablePreFragment$b$b, reason: collision with other inner class name */
        /* loaded from: classes12.dex */
        public static final class C7620b implements ne1.a {
            static IPatchRedirector $redirector_;

            C7620b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
                }
            }

            @Override // ne1.a
            public void a(@NotNull GetLocalPhone$OIDBGetPhoneRsp data) {
                String k26;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) data);
                    return;
                }
                Intrinsics.checkNotNullParameter(data, "data");
                b.this.isRequestingMaskPhone = false;
                GetLocalPhone$MaskPhoneData getLocalPhone$MaskPhoneData = data.msg_mask_phone_data.get();
                Unit unit = null;
                String str = null;
                if (getLocalPhone$MaskPhoneData != null) {
                    b bVar = b.this;
                    PBStringField pBStringField = getLocalPhone$MaskPhoneData.str_mask_phone;
                    if (pBStringField != null) {
                        str = pBStringField.get();
                    }
                    String str2 = "";
                    if (str == null) {
                        str = "";
                    } else {
                        Intrinsics.checkNotNullExpressionValue(str, "it.str_mask_phone?.get() ?: \"\"");
                    }
                    k kVar = (k) bVar.baseViewRef.get();
                    if (kVar != null && (k26 = kVar.k2()) != null) {
                        str2 = k26;
                    }
                    if (TextUtils.equals(str2, str)) {
                        bVar.maskPhoneData = getLocalPhone$MaskPhoneData;
                    } else {
                        QLog.i("FaceIdentificationPhoneTokenHandler", 1, "getMaskPhoneNum getMaskPhoneSuccess maskPhoneNum not same. " + str + ", " + str2);
                    }
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    QLog.e("FaceIdentificationPhoneTokenHandler", 1, "getMaskPhoneNum getMaskPhoneSuccess but maskPhoneData is null");
                }
            }

            @Override // ne1.a
            public void onFail(int errorCode, @Nullable String errorMsg) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, errorCode, (Object) errorMsg);
                    return;
                }
                QLog.e("FaceIdentificationPhoneTokenHandler", 1, "getMaskPhoneNum onException code: " + errorCode, errorMsg);
                b.this.isRequestingMaskPhone = false;
            }
        }

        @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/fragment/FaceIdentificationEnablePreFragment$b$c", "Lne1/a;", "Ltencent/im/login/GetLocalPhone$OIDBGetPhoneRsp;", "data", "", "a", "", "errorCode", "", "errorMsg", "onFail", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes12.dex */
        public static final class c implements ne1.a {
            static IPatchRedirector $redirector_;

            c() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void d(b this$0) {
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                this$0.l();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void e(b this$0) {
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                this$0.l();
            }

            @Override // ne1.a
            public void a(@NotNull GetLocalPhone$OIDBGetPhoneRsp data) {
                boolean z16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) data);
                    return;
                }
                Intrinsics.checkNotNullParameter(data, "data");
                String str = data.msg_encrypt_phone_data.get().str_encypt_phone.get();
                if (str != null) {
                    if (str.length() == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16) {
                        QLog.i("FaceIdentificationPhoneTokenHandler", 1, "getPhoneToken getPhoneNumSuccess phoneToken: " + str);
                        b.this.h(str);
                        return;
                    }
                }
                QLog.i("FaceIdentificationPhoneTokenHandler", 1, "getPhoneNumSuccess phoneToken null or empty? " + str);
                Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                final b bVar = b.this;
                uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.fragment.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        FaceIdentificationEnablePreFragment.b.c.e(FaceIdentificationEnablePreFragment.b.this);
                    }
                });
            }

            @Override // ne1.a
            public void onFail(int errorCode, @Nullable String errorMsg) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, errorCode, (Object) errorMsg);
                    return;
                }
                QLog.e("FaceIdentificationPhoneTokenHandler", 1, "getPhoneToken onException code: " + errorCode + ".", errorMsg);
                Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                final b bVar = b.this;
                uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.fragment.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        FaceIdentificationEnablePreFragment.b.c.d(FaceIdentificationEnablePreFragment.b.this);
                    }
                });
            }
        }

        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/fragment/FaceIdentificationEnablePreFragment$b$d", "Lcom/tencent/mobileqq/widget/ao$b;", "", "isChecked", "", "a", "qqlogin-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes12.dex */
        public static final class d implements ao.b {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ k f211153a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ b f211154b;

            d(k kVar, b bVar) {
                this.f211153a = kVar;
                this.f211154b = bVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) kVar, (Object) bVar);
                }
            }

            @Override // com.tencent.mobileqq.widget.ao.b
            public void a(boolean isChecked) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, isChecked);
                } else if (isChecked) {
                    k kVar = this.f211153a;
                    if (kVar != null) {
                        kVar.showLoading();
                    }
                    this.f211154b.i();
                }
            }
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17934);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 7)) {
                redirector.redirect((short) 7);
            } else {
                INSTANCE = new Companion(null);
            }
        }

        public b(@NotNull k baseView) {
            Intrinsics.checkNotNullParameter(baseView, "baseView");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseView);
            } else {
                this.baseViewRef = new WeakReference<>(baseView);
            }
        }

        private final void g() {
            this.isRequestingMaskPhone = true;
            com.tencent.mobileqq.gateway.localphone.ecdh.g.n(1, 9, new C7620b(), null, 8, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void i() {
            com.tencent.mobileqq.gateway.localphone.ecdh.g.n(3, 9, new c(), null, 8, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void k(b this$0, k kVar) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this$0.maskPhoneData != null) {
                if (kVar != null) {
                    kVar.hideLoading();
                }
                GetLocalPhone$MaskPhoneData getLocalPhone$MaskPhoneData = this$0.maskPhoneData;
                Intrinsics.checkNotNull(getLocalPhone$MaskPhoneData);
                this$0.n(getLocalPhone$MaskPhoneData);
                return;
            }
            if (kVar != null) {
                kVar.showLoading();
            }
            this$0.l();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void l() {
            Activity activity;
            k kVar = this.baseViewRef.get();
            IFaceIdentificationEnablePrePageApi iFaceIdentificationEnablePrePageApi = (IFaceIdentificationEnablePrePageApi) QRoute.api(IFaceIdentificationEnablePrePageApi.class);
            if (kVar != null) {
                activity = kVar.d0();
            } else {
                activity = null;
            }
            iFaceIdentificationEnablePrePageApi.onVerifyFinish(activity, false, null, null);
        }

        private final void m(String openId, String tmpKey) {
            Activity activity;
            k kVar = this.baseViewRef.get();
            IFaceIdentificationEnablePrePageApi iFaceIdentificationEnablePrePageApi = (IFaceIdentificationEnablePrePageApi) QRoute.api(IFaceIdentificationEnablePrePageApi.class);
            if (kVar != null) {
                activity = kVar.d0();
            } else {
                activity = null;
            }
            iFaceIdentificationEnablePrePageApi.onVerifyFinish(activity, true, openId, tmpKey);
        }

        private final synchronized void n(GetLocalPhone$MaskPhoneData data) {
            Activity d06;
            k kVar = this.baseViewRef.get();
            if (kVar != null && (d06 = kVar.d0()) != null) {
                if (d06.isFinishing()) {
                    QLog.e("FaceIdentificationPhoneTokenHandler", 1, "showGatewayDialog activity is finishing");
                    return;
                }
                HashMap hashMap = new HashMap();
                String str = data.str_mask_phone.get();
                Intrinsics.checkNotNullExpressionValue(str, "data.str_mask_phone.get()");
                hashMap.put("key_phone_num", str);
                String string = d06.getString(R.string.f200384rz);
                Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.str\u2026enable_face_quick_verify)");
                hashMap.put("key_self_btn_text", string);
                String string2 = d06.getString(R.string.cancel);
                Intrinsics.checkNotNullExpressionValue(string2, "activity.getString(com.t\u2026eqq.qqui.R.string.cancel)");
                hashMap.put("key_other_btn_text", string2);
                String str2 = data.str_terms_wording.get();
                Intrinsics.checkNotNullExpressionValue(str2, "data.str_terms_wording.get()");
                hashMap.put("key_user_agreement", str2);
                hashMap.put("key_other_click_ignore_agreement", Boolean.TRUE);
                try {
                    new ao(d06, hashMap, new d(kVar, this), null).show();
                } catch (Exception e16) {
                    QLog.e("FaceIdentificationPhoneTokenHandler", 1, "showGatewayDialog catch exception! ", e16);
                }
            }
        }

        @Override // com.tencent.mobileqq.observer.c
        public void getTmpKeySuccess(@Nullable String openid, @Nullable String tmpkey) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) openid, (Object) tmpkey);
                return;
            }
            boolean z16 = true;
            QLog.i("FaceIdentificationPhoneTokenHandler", 1, "getTmpKeySuccess openId: " + openid + ", tmpKey: " + tmpkey);
            if (TextUtils.isEmpty(openid) || TextUtils.isEmpty(tmpkey)) {
                z16 = false;
            }
            if (z16) {
                m(openid, tmpkey);
            } else {
                l();
            }
        }

        public final void h(@NotNull String phoneToken) {
            String str;
            AppRuntime appRuntime;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) phoneToken);
                return;
            }
            Intrinsics.checkNotNullParameter(phoneToken, "phoneToken");
            k kVar = this.baseViewRef.get();
            if (kVar != null && (appRuntime = kVar.getAppRuntime()) != null) {
                str = appRuntime.getAccount();
            } else {
                str = null;
            }
            LoginVerifyServlet.g(101810106, str, "phone_token", phoneToken, this);
        }

        public final void j() {
            long j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
                return;
            }
            if (this.clickVerifyBtnTime > 0 && System.currentTimeMillis() - this.clickVerifyBtnTime <= 500) {
                return;
            }
            this.clickVerifyBtnTime = System.currentTimeMillis();
            GetLocalPhone$MaskPhoneData getLocalPhone$MaskPhoneData = this.maskPhoneData;
            if (getLocalPhone$MaskPhoneData != null) {
                Intrinsics.checkNotNull(getLocalPhone$MaskPhoneData);
                n(getLocalPhone$MaskPhoneData);
                return;
            }
            if (this.isRequestingMaskPhone) {
                if (this.requestMaskPhoneStartTime > 0) {
                    j3 = 8000 - (System.currentTimeMillis() - this.requestMaskPhoneStartTime);
                } else {
                    j3 = 0;
                }
                QLog.i("FaceIdentificationPhoneTokenHandler", 2, "onClick waitingTime: " + j3);
            } else {
                j3 = 0;
            }
            final k kVar = this.baseViewRef.get();
            if (j3 <= 0) {
                if (kVar != null) {
                    kVar.showLoading();
                }
                l();
            } else {
                if (kVar != null) {
                    kVar.showLoading();
                }
                ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.fragment.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        FaceIdentificationEnablePreFragment.b.k(FaceIdentificationEnablePreFragment.b.this, kVar);
                    }
                }, j3);
            }
        }

        public final void o() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                this.requestMaskPhoneStartTime = System.currentTimeMillis();
                g();
            }
        }

        @Override // com.tencent.mobileqq.observer.c
        public void onFailedResponse(@Nullable String cmd, int code, @Nullable String message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, cmd, Integer.valueOf(code), message);
                return;
            }
            QLog.e("FaceIdentificationPhoneTokenHandler", 1, "onFailedResponse cmd:" + cmd + " code: " + code + ", message: " + message);
            if (Intrinsics.areEqual("getTmpkey", cmd)) {
                l();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18207);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public FaceIdentificationEnablePreFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.phoneNum = "";
            this.countryCode = "86";
        }
    }

    private final void finishActivity() {
        QBaseActivity qBaseActivity = this.mQBaseActivity;
        if (qBaseActivity != null) {
            Object systemService = qBaseActivity.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            InputMethodManager inputMethodManager = (InputMethodManager) systemService;
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(qBaseActivity.getWindow().getDecorView().getWindowToken(), 0);
            }
            qBaseActivity.finish();
        }
    }

    private final void initViews(View root) {
        List listOf;
        Intent intent;
        CharSequence trim;
        boolean startsWith$default;
        View findViewById = root.findViewById(R.id.b7p);
        Intrinsics.checkNotNullExpressionValue(findViewById, "root.findViewById(R.id.confirm_btn)");
        this.confirmBtn = (Button) findViewById;
        View findViewById2 = root.findViewById(R.id.e4r);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "root.findViewById(R.id.layout_phone_num)");
        this.layoutPhoneNum = findViewById2;
        View findViewById3 = root.findViewById(R.id.f109946h7);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "root.findViewById(R.id.tv_phone_num)");
        this.textPhoneNum = (TextView) findViewById3;
        View findViewById4 = root.findViewById(R.id.f107076_f);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "root.findViewById(R.id.tv_country_code)");
        this.textCountryCode = (TextView) findViewById4;
        View findViewById5 = root.findViewById(R.id.a47);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "root.findViewById(R.id.back_btn)");
        this.backBtn = findViewById5;
        View findViewById6 = root.findViewById(R.id.iz9);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "root.findViewById(R.id.space)");
        this.space = findViewById6;
        View[] viewArr = new View[2];
        Button button = this.confirmBtn;
        View view = null;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("confirmBtn");
            button = null;
        }
        viewArr[0] = button;
        View view2 = this.backBtn;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backBtn");
            view2 = null;
        }
        viewArr[1] = view2;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) viewArr);
        Iterator it = listOf.iterator();
        while (it.hasNext()) {
            ((View) it.next()).setOnClickListener(this);
        }
        QBaseActivity qBaseActivity = this.mQBaseActivity;
        if (qBaseActivity != null) {
            intent = qBaseActivity.getIntent();
        } else {
            intent = null;
        }
        if (intent != null) {
            this.phoneNum = intent.getStringExtra(AuthDevOpenUgActivity.KEY_PHONE_NUM);
            String stringExtra = intent.getStringExtra("country_code");
            if (!TextUtils.isEmpty(stringExtra)) {
                this.countryCode = stringExtra;
            } else {
                QLog.e("FaceIdentificationEnablePreFragment", 1, "onCreateView countryCode is empty, use default");
            }
        }
        if (!TextUtils.isEmpty(this.countryCode)) {
            String str = this.countryCode;
            Intrinsics.checkNotNull(str);
            trim = StringsKt__StringsKt.trim((CharSequence) str);
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(trim.toString(), Marker.ANY_NON_NULL_MARKER, false, 2, null);
            if (!startsWith$default) {
                String str2 = Marker.ANY_NON_NULL_MARKER + this.countryCode;
                TextView textView = this.textCountryCode;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("textCountryCode");
                    textView = null;
                }
                textView.setText(str2);
            } else {
                TextView textView2 = this.textCountryCode;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("textCountryCode");
                    textView2 = null;
                }
                textView2.setText(this.countryCode);
            }
        }
        TextView textView3 = this.textPhoneNum;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textPhoneNum");
            textView3 = null;
        }
        textView3.setText(qh());
        if (FontSettingManager.isFontSizeLarge()) {
            View view3 = this.space;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("space");
            } else {
                view = view3;
            }
            view.setVisibility(8);
        }
        sh(root);
    }

    private final void ph() {
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            if (this.root == null) {
                Intrinsics.throwUninitializedPropertyAccessException("root");
            }
            View view = this.root;
            Window window = null;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("root");
                view = null;
            }
            ImmersiveUtils.setFitsSystemWindows(view, true);
            if (!ThemeUtil.isNowThemeIsNight(null, false, null)) {
                QBaseActivity qBaseActivity = this.mQBaseActivity;
                if (qBaseActivity != null) {
                    window = qBaseActivity.getWindow();
                }
                ImmersiveUtils.setStatusTextColor(true, window);
            }
        }
    }

    private final String qh() {
        String str = this.phoneNum;
        if (str != null) {
            if (str.length() > 5) {
                String substring = str.substring(0, 3);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                String substring2 = str.substring(str.length() - 2);
                Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
                return substring + "******" + substring2;
            }
            return str;
        }
        return "";
    }

    private final boolean rh() {
        QBaseActivity qBaseActivity = getQBaseActivity();
        this.mQBaseActivity = qBaseActivity;
        if (qBaseActivity == null) {
            return false;
        }
        Intrinsics.checkNotNull(qBaseActivity);
        AppRuntime appRuntime = qBaseActivity.getAppRuntime();
        this.mAppRuntime = appRuntime;
        if (appRuntime == null) {
            QBaseActivity qBaseActivity2 = this.mQBaseActivity;
            Intrinsics.checkNotNull(qBaseActivity2);
            qBaseActivity2.finish();
            return false;
        }
        return true;
    }

    private final void sh(View root) {
        if (com.tencent.mobileqq.loginregister.z.b(getContext())) {
            com.tencent.mobileqq.loginregister.z.w(root.findViewById(R.id.f86614s5));
        } else {
            com.tencent.mobileqq.loginregister.z.A(root.findViewById(R.id.f86614s5));
        }
    }

    @Override // com.tencent.mobileqq.fragment.k
    @Nullable
    public Activity d0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (Activity) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.mQBaseActivity;
    }

    @Override // com.tencent.mobileqq.fragment.k
    @Nullable
    public AppRuntime getAppRuntime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (AppRuntime) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.mAppRuntime;
    }

    @Override // com.tencent.mobileqq.fragment.k
    public void hideLoading() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
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

    @Override // com.tencent.mobileqq.fragment.k
    @Nullable
    public String k2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return qh();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        ((IFaceIdentificationEnablePrePageApi) QRoute.api(IFaceIdentificationEnablePrePageApi.class)).onCancelVerify(this.mQBaseActivity);
        finishActivity();
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) v3);
        } else {
            if (v3 != null) {
                num = Integer.valueOf(v3.getId());
            } else {
                num = null;
            }
            if (num != null && num.intValue() == R.id.b7p) {
                b bVar = this.faceIdentificationPhoneTokenHandler;
                if (bVar != null) {
                    bVar.j();
                }
            } else if (num != null && num.intValue() == R.id.a47) {
                onBackEvent();
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) newConfig);
            return;
        }
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        View view = this.root;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("root");
            view = null;
        }
        sh(view);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            view = (View) iPatchRedirector.redirect((short) 2, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            View inflate = inflater.inflate(R.layout.gy7, container, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(\n      \u2026          false\n        )");
            this.root = inflate;
            QLog.i("FaceIdentificationEnablePreFragment", 2, "onCreateView " + getView());
            if (!rh()) {
                view = this.root;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("root");
                    view = null;
                }
            } else {
                View view2 = this.root;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("root");
                    view2 = null;
                }
                initViews(view2);
                b bVar = new b(this);
                this.faceIdentificationPhoneTokenHandler = bVar;
                bVar.o();
                view = this.root;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("root");
                    view = null;
                }
            }
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            hideLoading();
            super.onDestroy();
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            super.onDetach();
            av.f306600a.a(getActivity());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ph();
    }

    @Override // com.tencent.mobileqq.fragment.k
    public void showLoading() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        try {
            String string = getString(R.string.f211365km);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.qqlog\u2026_qqstr_loginvie_b90c1b5a)");
            boolean isEmpty = TextUtils.isEmpty(string);
            Dialog dialog = this.loadingDialog;
            if (dialog != null && dialog.isShowing()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!(isEmpty | z16) && getQBaseActivity() != null && !getQBaseActivity().isFinishing()) {
                Dialog showLoadingDialog = LoadingUtil.showLoadingDialog(getQBaseActivity(), string, false);
                this.loadingDialog = showLoadingDialog;
                if (showLoadingDialog != null) {
                    showLoadingDialog.show();
                }
            }
        } catch (Exception e16) {
            QLog.e("BaseLoginFragment", 1, "showLoading exception", e16);
        }
    }
}
