package com.tencent.ecommerce.biz.register.refactoring.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.xsad.rewarded.dynamic.method.AdCommonMethodHandler;
import com.tencent.ecommerce.base.eventbus.EventObserver;
import com.tencent.ecommerce.base.eventbus.LifecycleEventBus;
import com.tencent.ecommerce.base.eventbus.ThreadMode;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.ecommerce.base.ui.api.ECToastIcon;
import com.tencent.ecommerce.base.ui.d;
import com.tencent.ecommerce.base.ui.i;
import com.tencent.ecommerce.biz.register.ECommerceCaptchaVerifyDialog;
import com.tencent.ecommerce.biz.register.a;
import com.tencent.ecommerce.biz.register.network.CaptchaStatus;
import com.tencent.ecommerce.biz.register.refactoring.dialog.ECRegisterCommonDialog;
import com.tencent.ecommerce.biz.register.refactoring.repo.ECommerceRegisterRepo;
import com.tencent.ecommerce.biz.register.refactoring.repo.IECRegisterSmsCallback;
import com.tencent.ecommerce.biz.register.refactoring.utils.ECRegisterReportScene;
import com.tencent.ecommerce.biz.register.refactoring.utils.ECRegisterSuccessEvent;
import com.tencent.ecommerce.biz.util.ECThreadUtilKt;
import com.tencent.ecommerce.biz.util.q;
import com.tencent.ecommerce.repo.register.ECRegisterRespStatus;
import com.tencent.ecommerce.repo.register.ECaptcha;
import com.tencent.ecommerce.repo.register.ECaptchaErrorCode;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QzoneIPCModule;
import java.util.Arrays;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000o\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n*\u0001N\u0018\u0000 Z2\u00020\u0001:\u0001[B\u0007\u00a2\u0006\u0004\bX\u0010YJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001a\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\"\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0013H\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0002J\b\u0010\u0018\u001a\u00020\u0006H\u0002J\b\u0010\u0019\u001a\u00020\u0006H\u0002J\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0013H\u0002J\b\u0010\u001c\u001a\u00020\u0006H\u0002J\u0012\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010\u001e\u001a\u00020\u001dH\u0002J\b\u0010 \u001a\u00020\u0006H\u0002J\b\u0010!\u001a\u00020\u0006H\u0002J\b\u0010\"\u001a\u00020\u0006H\u0002R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010%R\u0016\u0010*\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010%R\u0016\u0010,\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010%R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00102\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u0010/R\u0018\u00105\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0018\u00107\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00104R\u0018\u00109\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00104R\u0018\u0010;\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u00104R\u0016\u0010=\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010<R\u0016\u0010?\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u00104R\u0016\u0010A\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u00104R\u0016\u0010C\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u00104R\u0016\u0010E\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u00104R\u0018\u0010I\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010M\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010Q\u001a\u00020N8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u001b\u0010W\u001a\u00020R8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bS\u0010T\u001a\u0004\bU\u0010V\u00a8\u0006\\"}, d2 = {"Lcom/tencent/ecommerce/biz/register/refactoring/fragment/ECommerceRegisterUserInfoFragment;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "", "getContentLayoutId", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "getBusinessDescription", "", "Bh", "Eh", "Dh", "gi", "initListener", "mi", "enable", "li", "ii", "Lcom/tencent/ecommerce/repo/register/ECaptcha;", "captcha", WidgetCacheLunarData.JI, "di", "ei", "hi", "Landroid/widget/EditText;", "P", "Landroid/widget/EditText;", "nameEditTx", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "idEditTx", BdhLogUtil.LogTag.Tag_Req, "phoneNumEditTx", ExifInterface.LATITUDE_SOUTH, "captchaEditTx", "Landroid/widget/Button;", "T", "Landroid/widget/Button;", "captchaButton", "U", "goOnButton", "V", "Ljava/lang/String;", "userName", "W", "userID", "X", "userPhone", "Y", "userSmsCode", "Z", "inputCheck", "a0", "isMcn", "b0", "jumpScheme", "c0", "deliverProductCallbackId", "d0", "isFollowAccount", "Lcom/tencent/ecommerce/biz/register/ECommerceCaptchaVerifyDialog;", "e0", "Lcom/tencent/ecommerce/biz/register/ECommerceCaptchaVerifyDialog;", "eCommerceCaptchaVerifyDialog", "Landroid/os/CountDownTimer;", "f0", "Landroid/os/CountDownTimer;", "sendCaptchaCountDownTimer", "com/tencent/ecommerce/biz/register/refactoring/fragment/ECommerceRegisterUserInfoFragment$j", "g0", "Lcom/tencent/ecommerce/biz/register/refactoring/fragment/ECommerceRegisterUserInfoFragment$j;", "successRegisteredEventObserve", "Lcom/tencent/ecommerce/biz/register/refactoring/viewmodel/a;", "h0", "Lkotlin/Lazy;", "fi", "()Lcom/tencent/ecommerce/biz/register/refactoring/viewmodel/a;", "viewModel", "<init>", "()V", "i0", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECommerceRegisterUserInfoFragment extends ECBaseFragment {

    /* renamed from: P, reason: from kotlin metadata */
    private EditText nameEditTx;

    /* renamed from: Q, reason: from kotlin metadata */
    private EditText idEditTx;

    /* renamed from: R, reason: from kotlin metadata */
    private EditText phoneNumEditTx;

    /* renamed from: S, reason: from kotlin metadata */
    private EditText captchaEditTx;

    /* renamed from: T, reason: from kotlin metadata */
    private Button captchaButton;

    /* renamed from: U, reason: from kotlin metadata */
    private Button goOnButton;

    /* renamed from: V, reason: from kotlin metadata */
    private String userName;

    /* renamed from: W, reason: from kotlin metadata */
    private String userID;

    /* renamed from: X, reason: from kotlin metadata */
    private String userPhone;

    /* renamed from: Y, reason: from kotlin metadata */
    private String userSmsCode;

    /* renamed from: Z, reason: from kotlin metadata */
    private boolean inputCheck;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private ECommerceCaptchaVerifyDialog eCommerceCaptchaVerifyDialog;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private CountDownTimer sendCaptchaCountDownTimer;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private final Lazy viewModel;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private String isMcn = "";

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private String jumpScheme = "";

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private String deliverProductCallbackId = "";

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private String isFollowAccount = "";

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private final j successRegisteredEventObserve = new j();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/ecommerce/biz/register/refactoring/fragment/ECommerceRegisterUserInfoFragment$b", "Lcom/tencent/ecommerce/biz/register/refactoring/utils/d;", "Landroid/text/Editable;", "editTx", "", "afterTextChanged", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b extends com.tencent.ecommerce.biz.register.refactoring.utils.d {
        b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editTx) {
            ECommerceRegisterUserInfoFragment.this.userName = String.valueOf(editTx);
            ECommerceRegisterUserInfoFragment.this.mi();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/ecommerce/biz/register/refactoring/fragment/ECommerceRegisterUserInfoFragment$c", "Lcom/tencent/ecommerce/biz/register/refactoring/utils/d;", "Landroid/text/Editable;", "editTx", "", "afterTextChanged", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c extends com.tencent.ecommerce.biz.register.refactoring.utils.d {
        c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editTx) {
            ECommerceRegisterUserInfoFragment.this.userID = String.valueOf(editTx);
            ECommerceRegisterUserInfoFragment.this.mi();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/ecommerce/biz/register/refactoring/fragment/ECommerceRegisterUserInfoFragment$d", "Lcom/tencent/ecommerce/biz/register/refactoring/utils/d;", "Landroid/text/Editable;", "editTx", "", "afterTextChanged", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d extends com.tencent.ecommerce.biz.register.refactoring.utils.d {
        d() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editTx) {
            ECommerceRegisterUserInfoFragment.this.userPhone = String.valueOf(editTx);
            ECommerceRegisterUserInfoFragment.this.mi();
            ECommerceRegisterUserInfoFragment eCommerceRegisterUserInfoFragment = ECommerceRegisterUserInfoFragment.this;
            eCommerceRegisterUserInfoFragment.li(eCommerceRegisterUserInfoFragment.fi().P1(String.valueOf(editTx)));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/ecommerce/biz/register/refactoring/fragment/ECommerceRegisterUserInfoFragment$e", "Lcom/tencent/ecommerce/biz/register/refactoring/utils/d;", "Landroid/text/Editable;", "editTx", "", "afterTextChanged", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class e extends com.tencent.ecommerce.biz.register.refactoring.utils.d {
        e() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editTx) {
            ECommerceRegisterUserInfoFragment.this.userSmsCode = String.valueOf(editTx);
            ECommerceRegisterUserInfoFragment.this.mi();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!ECommerceRegisterUserInfoFragment.this.fi().L1()) {
                ECommerceRegisterUserInfoFragment.this.ii();
                a.f103962b.g();
            } else {
                ECommerceRegisterUserInfoFragment.ki(ECommerceRegisterUserInfoFragment.this, null, 1, null);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECommerceRegisterUserInfoFragment.this.yh().requestFocus();
            q.f104879a.a(ECommerceRegisterUserInfoFragment.this.requireActivity(), ECommerceRegisterUserInfoFragment.this.requireContext());
            String str = ECommerceRegisterUserInfoFragment.this.userID;
            if (str != null) {
                if (!ECommerceRegisterUserInfoFragment.this.fi().O1(str)) {
                    ECRegisterCommonDialog.q(ECRegisterCommonDialog.f104005a, ECRegisterRespStatus.REGISTER_ERROR_CODE_ID_INVALID.status, ECommerceRegisterUserInfoFragment.this.requireContext(), null, 4, null);
                } else if (ECommerceRegisterUserInfoFragment.this.fi().N1(str)) {
                    ECommerceRegisterUserInfoFragment.this.hi();
                    ECommerceRegisterUserInfoFragment.this.fi().M1();
                } else {
                    ECRegisterCommonDialog.q(ECRegisterCommonDialog.f104005a, ECRegisterRespStatus.REGISTER_ERROR_CODE_UNDER_AGE.status, ECommerceRegisterUserInfoFragment.this.requireContext(), null, 4, null);
                }
            }
            hg0.a.c(hg0.a.f404850b, "ECRegisterUserProfileConfirm", null, 2, null);
            a.f103962b.e();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/ecommerce/biz/register/refactoring/fragment/ECommerceRegisterUserInfoFragment$h", "Lcom/tencent/ecommerce/biz/register/refactoring/utils/a;", "", "restoreAuthorizeFloatWindow", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class h extends com.tencent.ecommerce.biz.register.refactoring.utils.a {
        h() {
        }

        @Override // com.tencent.ecommerce.biz.register.refactoring.utils.IECAuthorizeDelegateCallBack
        public void restoreAuthorizeFloatWindow() {
            ECommerceRegisterUserInfoFragment.this.hi();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n\u00b8\u0006\u0000"}, d2 = {"com/tencent/ecommerce/biz/register/refactoring/fragment/ECommerceRegisterUserInfoFragment$sendCaptcha$2$1", "Lcom/tencent/ecommerce/biz/register/refactoring/repo/IECRegisterSmsCallback;", "", "code", "", "msg", "", "ts", "", "onCheck", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class i implements IECRegisterSmsCallback {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ECaptcha f104089b;

        i(ECaptcha eCaptcha) {
            this.f104089b = eCaptcha;
        }

        @Override // com.tencent.ecommerce.biz.register.refactoring.repo.IECRegisterSmsCallback
        public void onCheck(int code, String msg2, long ts5) {
            ECToastIcon eCToastIcon;
            CaptchaStatus captchaStatus = CaptchaStatus.VERIFICATION_SUCCESS;
            if (code == captchaStatus.ordinal()) {
                ECommerceRegisterUserInfoFragment.this.ei();
            } else {
                ECommerceRegisterUserInfoFragment.this.li(true);
            }
            ECommerceRegisterUserInfoFragment.this.fi().Q1(ts5);
            com.tencent.ecommerce.base.ui.i iVar = com.tencent.ecommerce.base.ui.i.f101155b;
            if (code == captchaStatus.ordinal()) {
                eCToastIcon = ECToastIcon.ICON_SUCCESS;
            } else {
                eCToastIcon = ECToastIcon.ICON_ERROR;
            }
            iVar.d(msg2, eCToastIcon, 0);
            a.f103962b.j(1, ECRegisterReportScene.SEND_CAPTCHA.sceneType, code);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/ecommerce/biz/register/refactoring/fragment/ECommerceRegisterUserInfoFragment$j", "Lcom/tencent/ecommerce/base/eventbus/EventObserver;", "Lcom/tencent/ecommerce/biz/register/refactoring/utils/c;", "event", "", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class j implements EventObserver<ECRegisterSuccessEvent> {
        j() {
        }

        @Override // com.tencent.ecommerce.base.eventbus.EventObserver
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onEvent(ECRegisterSuccessEvent event) {
            FragmentActivity activity = ECommerceRegisterUserInfoFragment.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    public ECommerceRegisterUserInfoFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.ecommerce.biz.register.refactoring.viewmodel.a>() { // from class: com.tencent.ecommerce.biz.register.refactoring.fragment.ECommerceRegisterUserInfoFragment$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.ecommerce.biz.register.refactoring.viewmodel.a invoke() {
                return (com.tencent.ecommerce.biz.register.refactoring.viewmodel.a) new ViewModelProvider(ECommerceRegisterUserInfoFragment.this).get(com.tencent.ecommerce.biz.register.refactoring.viewmodel.a.class);
            }
        });
        this.viewModel = lazy;
    }

    public static final /* synthetic */ Button Nh(ECommerceRegisterUserInfoFragment eCommerceRegisterUserInfoFragment) {
        Button button = eCommerceRegisterUserInfoFragment.captchaButton;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("captchaButton");
        }
        return button;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void di() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.tencent.ecommerce.biz.register.refactoring.fragment.ECommerceRegisterUserInfoFragment$captchaVerifiedFailed$1
                @Override // java.lang.Runnable
                public final void run() {
                    ECommerceCaptchaVerifyDialog eCommerceCaptchaVerifyDialog;
                    eCommerceCaptchaVerifyDialog = ECommerceRegisterUserInfoFragment.this.eCommerceCaptchaVerifyDialog;
                    if (eCommerceCaptchaVerifyDialog != null) {
                        eCommerceCaptchaVerifyDialog.dismiss();
                    }
                    i.f101155b.d(ECommerceRegisterUserInfoFragment.this.requireContext().getString(R.string.wdl), ECToastIcon.ICON_ERROR, 0);
                    ECommerceRegisterUserInfoFragment.this.li(true);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ei() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.tencent.ecommerce.biz.register.refactoring.fragment.ECommerceRegisterUserInfoFragment$captchaVerifiedSuccess$1

                /* compiled from: P */
                @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/ecommerce/biz/register/refactoring/fragment/ECommerceRegisterUserInfoFragment$captchaVerifiedSuccess$1$a", "Landroid/os/CountDownTimer;", "", "millisUntilFinished", "", AdCommonMethodHandler.AdCommonEvent.ON_TICK, "onFinish", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
                /* loaded from: classes31.dex */
                public static final class a extends CountDownTimer {
                    a(long j3, long j16) {
                        super(j3, j16);
                    }

                    @Override // android.os.CountDownTimer
                    public void onFinish() {
                        Button Nh = ECommerceRegisterUserInfoFragment.Nh(ECommerceRegisterUserInfoFragment.this);
                        Nh.setEnabled(true);
                        Nh.setText(Nh.getResources().getString(R.string.wdn));
                    }

                    @Override // android.os.CountDownTimer
                    public void onTick(long millisUntilFinished) {
                        Button Nh = ECommerceRegisterUserInfoFragment.Nh(ECommerceRegisterUserInfoFragment.this);
                        Nh.setEnabled(false);
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        String format = String.format(ECommerceRegisterUserInfoFragment.this.requireContext().getString(R.string.f169580we4), Arrays.copyOf(new Object[]{Long.valueOf(millisUntilFinished / 1000)}, 1));
                        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
                        Nh.setText(format);
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    ECommerceCaptchaVerifyDialog eCommerceCaptchaVerifyDialog;
                    CountDownTimer countDownTimer;
                    eCommerceCaptchaVerifyDialog = ECommerceRegisterUserInfoFragment.this.eCommerceCaptchaVerifyDialog;
                    if (eCommerceCaptchaVerifyDialog != null) {
                        eCommerceCaptchaVerifyDialog.dismiss();
                    }
                    ECommerceRegisterUserInfoFragment.this.sendCaptchaCountDownTimer = new a(60000L, 1000L);
                    countDownTimer = ECommerceRegisterUserInfoFragment.this.sendCaptchaCountDownTimer;
                    if (countDownTimer != null) {
                        countDownTimer.start();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.ecommerce.biz.register.refactoring.viewmodel.a fi() {
        return (com.tencent.ecommerce.biz.register.refactoring.viewmodel.a) this.viewModel.getValue();
    }

    private final void gi() {
        this.nameEditTx = (EditText) yh().findViewById(R.id.f163002ns2);
        this.idEditTx = (EditText) yh().findViewById(R.id.f163001ns1);
        this.phoneNumEditTx = (EditText) yh().findViewById(R.id.f163003ns3);
        this.captchaEditTx = (EditText) yh().findViewById(R.id.f163000ns0);
        this.captchaButton = (Button) yh().findViewById(R.id.nrz);
        this.goOnButton = (Button) yh().findViewById(R.id.nry);
        EditText editText = this.nameEditTx;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nameEditTx");
        }
        editText.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hi() {
        Map mapOf;
        FragmentActivity requireActivity = requireActivity();
        Uri parse = Uri.parse(String.valueOf(50));
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("is_trans_activity", "1"));
        yi0.a.u(requireActivity, 2, parse, mapOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r3v3, types: [T, android.app.Dialog, com.tencent.ecommerce.base.ui.d] */
    public final void ii() {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = null;
        Context context = getContext();
        if (context != null) {
            ?? dVar = new com.tencent.ecommerce.base.ui.d(context, null, 2, null);
            dVar.setCanceledOnTouchOutside(true);
            Unit unit = Unit.INSTANCE;
            objectRef.element = dVar;
            dVar.show();
        }
        ECommerceCaptchaVerifyDialog eCommerceCaptchaVerifyDialog = new ECommerceCaptchaVerifyDialog();
        Bundle bundle = new Bundle();
        bundle.putString("appId", "2065455486");
        Unit unit2 = Unit.INSTANCE;
        eCommerceCaptchaVerifyDialog.setArguments(bundle);
        this.eCommerceCaptchaVerifyDialog = eCommerceCaptchaVerifyDialog;
        eCommerceCaptchaVerifyDialog.uh(getChildFragmentManager(), new Function1<ECommerceCaptchaVerifyDialog.CaptchaVerifyDialogResult, Unit>() { // from class: com.tencent.ecommerce.biz.register.refactoring.fragment.ECommerceRegisterUserInfoFragment$popupToVerifyHuman$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ECommerceCaptchaVerifyDialog.CaptchaVerifyDialogResult captchaVerifyDialogResult) {
                invoke2(captchaVerifyDialogResult);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ECommerceCaptchaVerifyDialog.CaptchaVerifyDialogResult captchaVerifyDialogResult) {
                ECommerceCaptchaVerifyDialog eCommerceCaptchaVerifyDialog2;
                d dVar2 = (d) objectRef.element;
                if (dVar2 != null) {
                    dVar2.dismiss();
                }
                if (Intrinsics.areEqual(captchaVerifyDialogResult, ECommerceCaptchaVerifyDialog.CaptchaVerifyDialogResult.Cancel.f103956d)) {
                    cg0.a.b("ECommerceRegisterUserInfoFragment", "ECommerceCaptchaVerifyDialog onCanceled");
                    ECommerceRegisterUserInfoFragment.this.di();
                } else {
                    if (captchaVerifyDialogResult instanceof ECommerceCaptchaVerifyDialog.CaptchaVerifyDialogResult.Verified) {
                        ECaptcha eCaptcha = ((ECommerceCaptchaVerifyDialog.CaptchaVerifyDialogResult.Verified) captchaVerifyDialogResult).captcha;
                        cg0.a.a("ECommerceRegisterUserInfoFragment", "doSendCaptcha", "errorCode " + eCaptcha.getErrorCode() + ", ticket " + eCaptcha.getTicket());
                        if (eCaptcha.getErrorCode() == ECaptchaErrorCode.DEFAULT.getErrorCode()) {
                            if (!(eCaptcha.getTicket().length() == 0)) {
                                ECommerceRegisterUserInfoFragment.this.ji(eCaptcha);
                                cg0.a.b("ECommerceRegisterUserInfoFragment", "ECommerceCaptchaVerifyDialog onVerified");
                            }
                        }
                        eCommerceCaptchaVerifyDialog2 = ECommerceRegisterUserInfoFragment.this.eCommerceCaptchaVerifyDialog;
                        if (eCommerceCaptchaVerifyDialog2 != null) {
                            eCommerceCaptchaVerifyDialog2.dismiss();
                        }
                        ECommerceRegisterUserInfoFragment.this.di();
                        return;
                    }
                    if (Intrinsics.areEqual(captchaVerifyDialogResult, ECommerceCaptchaVerifyDialog.CaptchaVerifyDialogResult.PageReady.f103957d)) {
                        cg0.a.b("ECommerceRegisterUserInfoFragment", "ECommerceCaptchaVerifyDialog PageReady");
                    }
                }
                a.f103962b.h();
            }
        });
    }

    private final void initListener() {
        EditText editText = this.nameEditTx;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nameEditTx");
        }
        editText.addTextChangedListener(new b());
        EditText editText2 = this.idEditTx;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("idEditTx");
        }
        editText2.addTextChangedListener(new c());
        EditText editText3 = this.phoneNumEditTx;
        if (editText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("phoneNumEditTx");
        }
        editText3.addTextChangedListener(new d());
        EditText editText4 = this.captchaEditTx;
        if (editText4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("captchaEditTx");
        }
        editText4.addTextChangedListener(new e());
        Button button = this.captchaButton;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("captchaButton");
        }
        button.setOnClickListener(new f());
        Button button2 = this.goOnButton;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("goOnButton");
        }
        button2.setOnClickListener(new g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ji(ECaptcha captcha) {
        ECThreadUtilKt.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.register.refactoring.fragment.ECommerceRegisterUserInfoFragment$sendCaptcha$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ECommerceCaptchaVerifyDialog eCommerceCaptchaVerifyDialog;
                eCommerceCaptchaVerifyDialog = ECommerceRegisterUserInfoFragment.this.eCommerceCaptchaVerifyDialog;
                if (eCommerceCaptchaVerifyDialog != null) {
                    eCommerceCaptchaVerifyDialog.dismiss();
                }
                ECommerceRegisterUserInfoFragment.this.li(false);
            }
        });
        String str = this.userPhone;
        if (str != null) {
            ECommerceRegisterRepo.f104099a.h(str, captcha, new i(captcha));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void li(boolean enable) {
        int color;
        Button button = this.captchaButton;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("captchaButton");
        }
        button.setEnabled(enable);
        if (enable) {
            color = ECSkin.INSTANCE.getColor(R.color.f6942x);
        } else {
            color = ECSkin.INSTANCE.getColor(R.color.f6962z);
        }
        button.setTextColor(color);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0048, code lost:
    
        if ((r0 != null && r0.length() > 0) != false) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void mi() {
        String str = this.userName;
        boolean z16 = true;
        if (str != null && str.length() > 0) {
            String str2 = this.userID;
            if (str2 != null && str2.length() > 0) {
                String str3 = this.userPhone;
                if ((str3 != null && str3.length() > 0) && fi().P1(this.userPhone)) {
                    String str4 = this.userSmsCode;
                }
            }
        }
        z16 = false;
        if (this.inputCheck != z16) {
            this.inputCheck = z16;
            Button button = this.goOnButton;
            if (button == null) {
                Intrinsics.throwUninitializedPropertyAccessException("goOnButton");
            }
            button.setEnabled(z16);
        }
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Bh() {
        return true;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Dh() {
        return true;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Eh() {
        return true;
    }

    @Override // com.tencent.ecommerce.base.fragment.api.IECBaseFragment
    /* renamed from: getBusinessDescription */
    public String getTAG() {
        return "ECommerceRegisterUserInfoFragment";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.cvi;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode != 2) {
            return;
        }
        Integer valueOf = data != null ? Integer.valueOf(data.getIntExtra("authorize_page_result_key", 0)) : null;
        if (valueOf != null && valueOf.intValue() == 1) {
            Context requireContext = requireContext();
            Bundle bundle = new Bundle();
            bundle.putString("userName", this.userName);
            bundle.putString("userId", this.userID);
            bundle.putString("userPhone", this.userPhone);
            bundle.putString("userSmsCode", this.userSmsCode);
            bundle.putString("jump_scheme", this.jumpScheme);
            bundle.putString("scheme_callback_id", this.deliverProductCallbackId);
            bundle.putString("is_mcn", this.isMcn);
            bundle.putString("is_follow", this.isFollowAccount);
            new ECRegisterAuthorizeDelegate(requireContext, requireActivity(), bundle, getViewLifecycleOwner(), getChildFragmentManager(), new h()).p();
        }
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        String str;
        String str2;
        String string;
        String string2;
        LifecycleEventBus.f100688b.d(ThreadMode.ORIGIN, ECRegisterSuccessEvent.class, this.successRegisteredEventObserve);
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        String str3 = "0";
        if (arguments == null || (str = arguments.getString("is_mcn", "0")) == null) {
            str = "0";
        }
        this.isMcn = str;
        Bundle arguments2 = getArguments();
        String str4 = "";
        if (arguments2 == null || (str2 = arguments2.getString("jump_scheme", "")) == null) {
            str2 = "";
        }
        this.jumpScheme = str2;
        Bundle arguments3 = getArguments();
        if (arguments3 != null && (string2 = arguments3.getString("scheme_callback_id", "")) != null) {
            str4 = string2;
        }
        this.deliverProductCallbackId = str4;
        Bundle arguments4 = getArguments();
        if (arguments4 != null && (string = arguments4.getString("is_follow", "0")) != null) {
            str3 = string;
        }
        this.isFollowAccount = str3;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        CountDownTimer countDownTimer = this.sendCaptchaCountDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.sendCaptchaCountDownTimer = null;
        LifecycleEventBus.f100688b.e(this.successRegisteredEventObserve);
        super.onDestroy();
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        gi();
        initListener();
    }

    static /* synthetic */ void ki(ECommerceRegisterUserInfoFragment eCommerceRegisterUserInfoFragment, ECaptcha eCaptcha, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            eCaptcha = new ECaptcha(null, null, 0, null, 15, null);
        }
        eCommerceRegisterUserInfoFragment.ji(eCaptcha);
    }
}
