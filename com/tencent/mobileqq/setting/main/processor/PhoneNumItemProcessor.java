package com.tencent.mobileqq.setting.main.processor;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneUnityManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SecSvcHandler;
import com.tencent.mobileqq.app.cx;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ea;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import com.tencent.xweb.FileReaderHelper;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 Y2\u00020\u00012\u00020\u0002:\u0001ZB\u000f\u0012\u0006\u0010V\u001a\u00020U\u00a2\u0006\u0004\bW\u0010XJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\b\u0010\t\u001a\u00020\u0003H\u0002J\u001a\u0010\r\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\nH\u0002J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\nH\u0002J\u001a\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002J\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0013H\u0002J\b\u0010\u001a\u001a\u00020\u0003H\u0002J\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\b\u0010\u001f\u001a\u00020\u001eH\u0002J\b\u0010!\u001a\u00020 H\u0016J\n\u0010\"\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010#\u001a\u00020\u0003H\u0016J\b\u0010$\u001a\u00020\u0003H\u0016J\b\u0010%\u001a\u00020\u0003H\u0016J\b\u0010&\u001a\u00020\u0003H\u0016J\"\u0010*\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020\u001b2\b\u0010\u0014\u001a\u0004\u0018\u00010)H\u0016R\u0016\u0010,\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010\bR\u0018\u0010/\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00101\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010\bR\u0016\u00103\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010\bR\u0016\u00105\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u0010\bR\u0016\u00107\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u0010\bR\u0016\u00109\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u0010\bR\u0018\u0010<\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\"\u0010A\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\b\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0018\u0010B\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010.R\u0016\u0010D\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010\bR\u0018\u0010F\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010.R\u0016\u0010H\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010\bR\u0014\u0010L\u001a\u00020I8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0014\u0010P\u001a\u00020M8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010T\u001a\u0004\u0018\u00010Q8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bR\u0010S\u00a8\u0006["}, d2 = {"Lcom/tencent/mobileqq/setting/main/processor/PhoneNumItemProcessor;", "Lcom/tencent/mobileqq/setting/processor/e;", "Lcom/tencent/mobileqq/setting/processor/c;", "", "e0", "Y", "g0", "a0", "Z", "N", "", FileReaderHelper.OPEN_FILE_FROM_FORCE, "isUserClicked", "c0", "Lcom/tencent/mobileqq/activity/contact/phonecontact/PhoneUnityManager;", "manager", "T", ExifInterface.LATITUDE_SOUTH, "isSuccess", "Landroid/os/Bundle;", "data", "f0", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, BdhLogUtil.LogTag.Tag_Req, "phoneBundle", "P", "O", "", "msgResId", "b0", "", "M", "Lcom/tencent/mobileqq/setting/config/a;", "V", "d", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "o", "onResume", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "p", "g", NodeProps.VISIBLE, tl.h.F, "Ljava/lang/String;", "infoText", "i", UIJsPlugin.EVENT_SHOW_LOADING, "j", "showRedDot", "k", "isFirstGetLocalData", "l", "isRequestingPhoneUnity", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "isClickGetPhoneUnity", DomainData.DOMAIN_NAME, "Landroid/os/Bundle;", "phoneUnityData", "U", "()Z", "setPhoneVerified", "(Z)V", "isPhoneVerified", "unVerifiedPhone", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "isIOTPhone", "r", "iotPhone", ReportConstant.COSTREPORT_PREFIX, "isBindMb", "Lcom/tencent/mobileqq/app/cx;", "t", "Lcom/tencent/mobileqq/app/cx;", "secSvcObserver", "Landroid/content/BroadcastReceiver;", "u", "Landroid/content/BroadcastReceiver;", "bindMiBaoReceiver", "Lcom/tencent/mobileqq/app/QQAppInterface;", "L", "()Lcom/tencent/mobileqq/app/QQAppInterface;", "appInterface", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "v", "a", "qq_setting_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class PhoneNumItemProcessor extends com.tencent.mobileqq.setting.processor.c implements com.tencent.mobileqq.setting.processor.e {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean visible;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private String infoText;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean showLoading;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private boolean showRedDot;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private boolean isFirstGetLocalData;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private boolean isRequestingPhoneUnity;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isClickGetPhoneUnity;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private Bundle phoneUnityData;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private boolean isPhoneVerified;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private String unVerifiedPhone;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private boolean isIOTPhone;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private String iotPhone;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private boolean isBindMb;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private final cx secSvcObserver;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private final BroadcastReceiver bindMiBaoReceiver;

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\bH\u0014\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/setting/main/processor/PhoneNumItemProcessor$b", "Lcom/tencent/mobileqq/app/cx;", "", "data", "", "d", "", "isSuccess", "Landroid/os/Bundle;", "c", "qq_setting_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends cx {
        b() {
        }

        @Override // com.tencent.mobileqq.app.cx
        protected void c(boolean isSuccess, Bundle data) {
            QLog.i("SecSvcObserver", 1, "onGetPhoneUnityInfo isSuc: " + isSuccess);
            PhoneNumItemProcessor.this.isRequestingPhoneUnity = false;
            PhoneNumItemProcessor.this.f0(isSuccess, data);
            if (PhoneNumItemProcessor.this.isClickGetPhoneUnity) {
                if (PhoneNumItemProcessor.this.S()) {
                    PhoneNumItemProcessor.this.O();
                } else if (PhoneNumItemProcessor.this.k()) {
                    PhoneNumItemProcessor.this.b0(R.string.f173742tz);
                }
            }
            PhoneNumItemProcessor.this.isClickGetPhoneUnity = false;
            PhoneNumItemProcessor.this.e0();
        }

        @Override // com.tencent.mobileqq.app.cx
        protected void d(Object data) {
            Bundle bundle;
            QLog.i("SecSvcObserver", 1, "onGetPhoneUnityLocalData");
            boolean z16 = data == null;
            if (!z16 && (data instanceof com.tencent.mobileqq.activity.contact.phonecontact.a)) {
                z16 = ((com.tencent.mobileqq.activity.contact.phonecontact.a) data).f181302i;
            }
            PhoneNumItemProcessor.this.visible = z16;
            if (PhoneNumItemProcessor.this.visible) {
                AppInterface f16 = PhoneNumItemProcessor.this.f();
                Manager manager = f16 != null ? f16.getManager(QQManagerFactory.PHONE_UNITY_MANAGER) : null;
                PhoneUnityManager phoneUnityManager = manager instanceof PhoneUnityManager ? (PhoneUnityManager) manager : null;
                if (phoneUnityManager != null && (bundle = phoneUnityManager.D) != null) {
                    PhoneNumItemProcessor.this.f0(true, bundle);
                }
                PhoneNumItemProcessor phoneNumItemProcessor = PhoneNumItemProcessor.this;
                PhoneNumItemProcessor.d0(phoneNumItemProcessor, phoneNumItemProcessor.isFirstGetLocalData, false, 2, null);
                PhoneNumItemProcessor.this.isFirstGetLocalData = false;
            }
            PhoneNumItemProcessor.this.e0();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhoneNumItemProcessor(Context context) {
        super(context, 11);
        Intrinsics.checkNotNullParameter(context, "context");
        this.visible = true;
        this.isFirstGetLocalData = true;
        this.isPhoneVerified = true;
        this.unVerifiedPhone = "";
        this.iotPhone = "";
        this.secSvcObserver = new b();
        this.bindMiBaoReceiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.setting.main.processor.PhoneNumItemProcessor$bindMiBaoReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                boolean z16;
                boolean z17;
                boolean z18;
                Intrinsics.checkNotNullParameter(context2, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                if (QLog.isColorLevel()) {
                    z18 = PhoneNumItemProcessor.this.isBindMb;
                    QLog.d("MainSetting_PhoneNum", 1, "bindMiBaoReceiver onReceive mIsBindMb\uff1a" + z18);
                }
                z16 = PhoneNumItemProcessor.this.isBindMb;
                if (z16) {
                    com.tencent.mobileqq.setting.utils.o.k(com.tencent.mobileqq.setting.utils.o.f286768a, "0X800B312", 0, null, null, null, null, 62, null);
                }
                z17 = PhoneNumItemProcessor.this.isIOTPhone;
                if (z17) {
                    com.tencent.mobileqq.setting.utils.o.k(com.tencent.mobileqq.setting.utils.o.f286768a, "0X800BDAC", 0, null, null, null, null, 62, null);
                }
            }
        };
    }

    private final QQAppInterface L() {
        AppInterface f16 = f();
        if (f16 instanceof QQAppInterface) {
            return (QQAppInterface) f16;
        }
        return null;
    }

    private final String M() {
        AppInterface f16 = f();
        String currentAccountUin = f16 != null ? f16.getCurrentAccountUin() : null;
        return currentAccountUin == null ? "" : currentAccountUin;
    }

    private final void N() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Manager manager = peekAppRuntime != null ? peekAppRuntime.getManager(QQManagerFactory.PHONE_UNITY_MANAGER) : null;
        PhoneUnityManager phoneUnityManager = manager instanceof PhoneUnityManager ? (PhoneUnityManager) manager : null;
        if (phoneUnityManager != null) {
            phoneUnityManager.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O() {
        Activity e16 = e();
        if (e16 != null) {
            Intent intent = new Intent(e16, (Class<?>) PhoneUnityBindInfoActivity.class);
            intent.putExtra("kSrouce", 1);
            Bundle bundle = this.phoneUnityData;
            if (bundle != null) {
                intent.putExtra("kBindPhoneData", bundle);
            }
            e16.startActivityForResult(intent, 2001);
        }
    }

    private final boolean P(Bundle phoneBundle) {
        String str;
        if (phoneBundle.getInt("phone_type") != 4) {
            return false;
        }
        this.unVerifiedPhone = phoneBundle.getString("phone");
        Bundle bundle = this.phoneUnityData;
        String string = bundle != null ? bundle.getString("str_red_dot_tips", "") : null;
        String str2 = string != null ? string : "";
        if (this.phoneUnityData != null) {
            str = this.unVerifiedPhone + "(" + str2 + ")";
        } else {
            str = this.unVerifiedPhone;
        }
        this.infoText = str;
        if (!ea.O1(BaseApplication.getContext(), M(), this.unVerifiedPhone)) {
            this.showRedDot = true;
        }
        this.showLoading = false;
        return true;
    }

    private final boolean Q(Bundle data) {
        if (!data.getBoolean("bool_is_IOT", false)) {
            return false;
        }
        this.iotPhone = data.getString("phone");
        String string = data.getString("str_red_dot_tips", "");
        this.infoText = this.iotPhone + "(" + string + ")";
        if (!ea.O1(BaseApplication.getContext(), M(), this.iotPhone)) {
            this.showRedDot = true;
        }
        this.showLoading = false;
        return true;
    }

    private final boolean R(Bundle data) {
        Parcelable[] parcelableArray = data.getParcelableArray("phone_info");
        Bundle[] bundleArr = parcelableArray instanceof Bundle[] ? (Bundle[]) parcelableArray : null;
        if (bundleArr != null) {
            for (Bundle bundle : bundleArr) {
                if (P(bundle)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean S() {
        Bundle bundle = this.phoneUnityData;
        return bundle != null && bundle.getBoolean("is_all_phone_get", true);
    }

    private final boolean T(PhoneUnityManager manager) {
        return manager.D == null || manager.f181279d || System.currentTimeMillis() - manager.G > 1800000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(PhoneNumItemProcessor this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Y();
        com.tencent.mobileqq.setting.utils.o oVar = com.tencent.mobileqq.setting.utils.o.f286768a;
        Intrinsics.checkNotNullExpressionValue(view, "view");
        com.tencent.mobileqq.setting.utils.o.g(oVar, view, "em_bas_mobile_phone_number", null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        com.tencent.mobileqq.setting.utils.o.f286768a.l(view, "em_bas_mobile_phone_number", null, false);
    }

    private final void Y() {
        g0();
        a0();
        Bundle bundle = this.phoneUnityData;
        if (bundle == null) {
            QLog.i("MainSetting_PhoneNum", 1, "onClick mPhoneUnityData is null");
            c0(true, true);
            return;
        }
        if (bundle == null) {
            return;
        }
        if (this.isIOTPhone) {
            O();
            PhoneUnityManager.k(L(), "0X800B328", bundle);
            return;
        }
        if (bundle.getInt("check_result") == 1) {
            String str = this.unVerifiedPhone;
            if (str == null || str.length() == 0) {
                String string = bundle.getString("mibao_set_url");
                if (!TextUtils.isEmpty(string)) {
                    PhoneUnityManager.k(L(), "0X800B328", bundle);
                    Activity e16 = e();
                    if (e16 != null) {
                        this.isBindMb = true;
                        PhoneUnityManager.m(e16, L(), string, 2002);
                        return;
                    }
                    return;
                }
                QLog.e("MainSetting_PhoneNum", 1, "mb set url is null.");
                return;
            }
        }
        if (S()) {
            PhoneUnityManager.k(L(), "0X800B328", bundle);
            O();
        } else {
            c0(true, true);
        }
    }

    private final void Z() {
        int i3;
        int i16;
        Bundle bundle = this.phoneUnityData;
        if (bundle == null) {
            i3 = 4;
        } else {
            String string = bundle != null ? bundle.getString("phone") : null;
            Bundle bundle2 = this.phoneUnityData;
            Integer valueOf = bundle2 != null ? Integer.valueOf(bundle2.getInt("status", 0)) : null;
            if (valueOf == null || valueOf.intValue() != 3) {
                i3 = !TextUtils.isEmpty(string) ? 1 : 2;
            } else {
                i16 = 3;
                com.tencent.mobileqq.setting.utils.o.k(com.tencent.mobileqq.setting.utils.o.f286768a, "0X800B896", i16, null, null, null, null, 60, null);
            }
        }
        i16 = i3;
        com.tencent.mobileqq.setting.utils.o.k(com.tencent.mobileqq.setting.utils.o.f286768a, "0X800B896", i16, null, null, null, null, 60, null);
    }

    private final void a0() {
        IPhoneContactService iPhoneContactService;
        com.tencent.mobileqq.setting.utils.o oVar = com.tencent.mobileqq.setting.utils.o.f286768a;
        oVar.c("CliOper", "0X8005DEA", "0X8005DEA", (r20 & 8) != 0 ? 0 : 0, (r20 & 16) != 0 ? "" : null, (r20 & 32) != 0 ? "" : null, (r20 & 64) != 0 ? "" : null, (r20 & 128) != 0 ? "" : null);
        com.tencent.mobileqq.setting.utils.o.k(oVar, "0X800689D", 0, null, null, null, null, 62, null);
        com.tencent.mobileqq.setting.utils.o.k(oVar, "0X800B82E", 0, null, null, null, null, 62, null);
        AppInterface f16 = f();
        if (f16 == null || (iPhoneContactService = (IPhoneContactService) f16.getRuntimeService(IPhoneContactService.class, "")) == null) {
            return;
        }
        int selfBindState = iPhoneContactService.getSelfBindState();
        if (selfBindState == 1 || selfBindState == 5) {
            com.tencent.mobileqq.setting.utils.o.k(oVar, "0X800689E", 0, null, null, null, null, 62, null);
        }
        if (S()) {
            return;
        }
        Z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b0(int msgResId) {
        QQToast.makeText(BaseApplication.getContext(), msgResId, 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
    }

    private final void c0(boolean force, boolean isUserClicked) {
        this.isClickGetPhoneUnity = isUserClicked;
        if (this.isRequestingPhoneUnity) {
            QLog.i("MainSetting_PhoneNum", 1, "startGetPhoneUnityStatus: on requesting, return.");
            return;
        }
        QQAppInterface L = L();
        if (L == null) {
            QLog.e("MainSetting_PhoneNum", 1, "startGetPhoneUnityStatus: app is null");
            return;
        }
        Manager manager = L.getManager(QQManagerFactory.PHONE_UNITY_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.activity.contact.phonecontact.PhoneUnityManager");
        PhoneUnityManager phoneUnityManager = (PhoneUnityManager) manager;
        boolean z16 = force || T(phoneUnityManager);
        BusinessHandler businessHandler = L.getBusinessHandler(BusinessHandlerFactory.SEC_SVC_HANDLER);
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.app.SecSvcHandler");
        SecSvcHandler secSvcHandler = (SecSvcHandler) businessHandler;
        if (QLog.isColorLevel()) {
            QLog.i("MainSetting_PhoneNum", 2, "startGetPhoneUnityStatus force: " + force + ", isUserClicked: " + isUserClicked + ", needGetInfo: " + z16);
        }
        if (z16) {
            this.isRequestingPhoneUnity = true;
            phoneUnityManager.G = System.currentTimeMillis();
            phoneUnityManager.f181279d = false;
            if (isUserClicked) {
                secSvcHandler.G2(2);
            } else {
                secSvcHandler.G2(1);
            }
            if (this.phoneUnityData == null) {
                this.showLoading = true;
                this.showRedDot = false;
                this.infoText = "";
                return;
            }
            return;
        }
        f0(true, phoneUnityManager.D);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e0() {
        com.tencent.mobileqq.widget.listitem.a<?> g16 = g();
        com.tencent.mobileqq.setting.config.a aVar = g16 instanceof com.tencent.mobileqq.setting.config.a ? (com.tencent.mobileqq.setting.config.a) g16 : null;
        if (aVar != null) {
            aVar.p(this.visible);
            String str = this.infoText;
            if (str == null) {
                str = "";
            }
            aVar.M(str);
            aVar.O(this.showRedDot);
            aVar.N(this.showLoading);
            l();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f0(boolean isSuccess, Bundle data) {
        String string;
        if (QLog.isDevelopLevel()) {
            QLog.i("MainSetting_PhoneNum", 4, "updatePhoneUnityInfo suc: " + isSuccess);
        }
        if (this.isRequestingPhoneUnity) {
            QLog.i("MainSetting_PhoneNum", 1, "updatePhoneUnityInfo: ignore because is requesting now");
            return;
        }
        Integer valueOf = data != null ? Integer.valueOf(data.getInt("status", 0)) : null;
        if (isSuccess && data != null && (valueOf == null || valueOf.intValue() != 4)) {
            this.phoneUnityData = data;
            this.showLoading = false;
            this.showRedDot = false;
            this.isPhoneVerified = data.getBoolean("phone_verified", true);
            Bundle bundle = this.phoneUnityData;
            this.isIOTPhone = bundle != null ? bundle.getBoolean("bool_is_IOT", false) : false;
            if (!Q(data) && !R(data)) {
                String string2 = data.getString("phone");
                if (valueOf != null && valueOf.intValue() == 3) {
                    string = BaseApplication.getContext().getString(R.string.f171161cs3);
                } else if (!TextUtils.isEmpty(string2)) {
                    Intrinsics.checkNotNull(string2);
                    string = string2;
                } else {
                    string = BaseApplication.getContext().getString(R.string.f171160cs2);
                }
                this.infoText = string;
                if (S()) {
                    this.showRedDot = data.getInt("need_unify", 0) == 1 && !TextUtils.isEmpty(string2);
                }
            }
            PhoneUnityManager.k(L(), "0X800B327", data);
            return;
        }
        this.phoneUnityData = null;
        this.infoText = "";
        this.showLoading = false;
        this.showRedDot = false;
    }

    private final void g0() {
        BaseApplication context = BaseApplication.getContext();
        if (!this.isPhoneVerified && !ea.O1(context, M(), this.unVerifiedPhone)) {
            ea.r3(context, M(), this.unVerifiedPhone, true);
            this.showRedDot = false;
        }
        if (this.isIOTPhone && !ea.O1(context, M(), this.iotPhone)) {
            ea.r3(context, M(), this.iotPhone, true);
            this.showRedDot = false;
        }
        e0();
    }

    /* renamed from: U, reason: from getter */
    public final boolean getIsPhoneVerified() {
        return this.isPhoneVerified;
    }

    @Override // com.tencent.mobileqq.setting.processor.c
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.setting.config.a q() {
        String string = BaseApplication.getContext().getString(R.string.f2045853a);
        Intrinsics.checkNotNullExpressionValue(string, "getContext().getString(R\u2026.qq_setting_phone_number)");
        com.tencent.mobileqq.setting.config.a aVar = new com.tencent.mobileqq.setting.config.a(string, R.drawable.qui_phone);
        aVar.p(this.visible);
        String str = this.infoText;
        if (str == null) {
            str = "";
        }
        aVar.M(str);
        aVar.O(this.showRedDot);
        aVar.N(this.showLoading);
        aVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.setting.main.processor.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PhoneNumItemProcessor.W(PhoneNumItemProcessor.this, view);
            }
        });
        aVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.setting.main.processor.q
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                PhoneNumItemProcessor.X(view);
            }
        });
        return aVar;
    }

    @Override // com.tencent.mobileqq.setting.processor.e
    public Bundle d() {
        if (this.phoneUnityData == null) {
            QLog.i("MainSetting_PhoneNum", 1, "getPhoneData mPhoneUnityData is null");
            c0(true, true);
        }
        return this.phoneUnityData;
    }

    @Override // com.tencent.mobileqq.setting.processor.c
    public void o() {
        super.o();
        QQAppInterface L = L();
        if (L != null) {
            L.addObserver(this.secSvcObserver);
        }
        N();
    }

    @Override // com.tencent.mobileqq.setting.processor.c, com.tencent.mobileqq.setting.processor.d
    public void onCreate() {
        super.onCreate();
        QQAppInterface L = L();
        if (L != null) {
            L.addObserver(this.secSvcObserver);
        }
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.tencent.mobileqq.InvitationWebViewPlugin.accountIdentityNotify");
            BaseApplication.getContext().registerReceiver(this.bindMiBaoReceiver, intentFilter);
        } catch (Exception e16) {
            QLog.e("MainSetting_PhoneNum", 1, "registerReceiver error:", e16);
        }
        com.tencent.mobileqq.setting.utils.o.k(com.tencent.mobileqq.setting.utils.o.f286768a, "0X800B7CA", 0, null, null, null, null, 62, null);
    }

    @Override // com.tencent.mobileqq.setting.processor.c, com.tencent.mobileqq.setting.processor.d
    public void onDestroy() {
        super.onDestroy();
        QQAppInterface L = L();
        if (L != null) {
            L.removeObserver(this.secSvcObserver);
        }
        try {
            BaseApplication.getContext().unregisterReceiver(this.bindMiBaoReceiver);
        } catch (Exception e16) {
            QLog.e("MainSetting_PhoneNum", 1, "unregisterReceiver error:", e16);
        }
    }

    @Override // com.tencent.mobileqq.setting.processor.c, com.tencent.mobileqq.setting.processor.d
    public void onResume() {
        super.onResume();
        N();
    }

    @Override // com.tencent.mobileqq.setting.processor.c
    public void p(int requestCode, int resultCode, Intent data) {
        super.p(requestCode, resultCode, data);
        if (requestCode != 2001) {
            if (requestCode != 2002) {
                return;
            }
            this.isBindMb = false;
            d0(this, true, false, 2, null);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("MainSetting_PhoneNum", 2, "REQ_CODE_PHONE_UNITY_BIND_INFO [" + resultCode + "]");
        }
        if (resultCode == 4001) {
            d0(this, true, false, 2, null);
        }
    }

    static /* synthetic */ void d0(PhoneNumItemProcessor phoneNumItemProcessor, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z17 = false;
        }
        phoneNumItemProcessor.c0(z16, z17);
    }
}
