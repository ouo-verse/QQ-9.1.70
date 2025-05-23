package com.tencent.mobileqq.activity.qqsettingme;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.utils.SchemaUtils;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.financial.FinancialEntry$DrawerReq;
import com.tencent.mobileqq.pb.financial.FinancialEntry$DrawerRsp;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.INewQWalletApi;
import com.tencent.mobileqq.qwallet.api.IQWalletKuiklyApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.fh;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AppSetting;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import pl2.p;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 '2\u00020\u0001:\u0001(B\u0007\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\n\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u0012\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\bH\u0002J\u0012\u0010\u000f\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\u0010\u001a\u00020\bH\u0016J\u0012\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u0002H\u0016J\u0012\u0010\u0018\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016R\u001c\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010$\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010!\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/activity/qqsettingme/QQSettingMeFinancialProcessor;", "Lcom/tencent/mobileqq/activity/qqsettingme/q;", "", "y", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/mobileqq/activity/qqsettingme/bean/d;", "bean", "D", "", "actionName", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;", "v", "url", BdhLogUtil.LogTag.Tag_Conn, "B", "w", "Lcom/tencent/mobileqq/qqsettingme/a;", "qqSettingMe", "d", "preload", "onResume", "onPostThemeChanged", "Landroid/view/View;", NodeProps.ON_CLICK, "", "f", "Landroidx/lifecycle/MutableLiveData;", "i", "Landroidx/lifecycle/MutableLiveData;", "beanLiveData", "Ljava/util/concurrent/atomic/AtomicBoolean;", "j", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isCurrentResume", "k", "hasCheckRes", "<init>", "()V", "l", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class QQSettingMeFinancialProcessor extends q {
    static IPatchRedirector $redirector_;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<com.tencent.mobileqq.activity.qqsettingme.bean.d> beanLiveData;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AtomicBoolean isCurrentResume;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AtomicBoolean hasCheckRes;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/activity/qqsettingme/QQSettingMeFinancialProcessor$a;", "", "", "REPORT_DRAWER_CLICK_KEY", "Ljava/lang/String;", "REPORT_DRAWER_SHOW_KEY", "TAG", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.activity.qqsettingme.QQSettingMeFinancialProcessor$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
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

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\r\u001a\u00020\n\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000\"\u0010\b\u0001\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\t\u001a\n \b*\u0004\u0018\u00010\u00070\u0007H\n\u00a2\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lcom/tencent/mobileqq/pb/MessageMicro;", "Req", "Rsp", "", "<anonymous parameter 0>", "", "isSuccess", "Landroid/os/Bundle;", "kotlin.jvm.PlatformType", "bundle", "", "onReceive", "(IZLandroid/os/Bundle;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements BusinessObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ pl2.o f184674d;

        public b(pl2.o oVar) {
            this.f184674d = oVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) oVar);
            }
        }

        @Override // mqq.observer.BusinessObserver
        public final void onReceive(int i3, boolean z16, Bundle bundle) {
            int i16;
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
                return;
            }
            if (bundle != null) {
                i16 = bundle.getInt("rsp_code");
            } else {
                i16 = 1001;
            }
            if (bundle != null) {
                str = bundle.getString("rsp_msg");
            } else {
                str = null;
            }
            if (z16) {
                try {
                    MessageMicro rsp = ((MessageMicro) FinancialEntry$DrawerRsp.class.newInstance()).mergeFrom(bundle.getByteArray("rsp_bytes"));
                    pl2.o oVar = this.f184674d;
                    if (oVar != null) {
                        Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
                        oVar.onSuccess((pl2.o) rsp);
                        return;
                    }
                    return;
                } catch (Exception unused) {
                    QLog.e("QWalletHttp-QWalletPbServlet", 1, "mergeFrom bytes array to " + FinancialEntry$DrawerRsp.class + " failed.");
                    pl2.o oVar2 = this.f184674d;
                    if (oVar2 != null) {
                        oVar2.onFail(i16, pl2.p.INSTANCE.a());
                        return;
                    }
                    return;
                }
            }
            pl2.o oVar3 = this.f184674d;
            if (oVar3 != null) {
                if (str == null) {
                    str = "empty bundle";
                }
                oVar3.onFail(i16, str);
            }
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/activity/qqsettingme/QQSettingMeFinancialProcessor$c", "Lpl2/o;", "Lcom/tencent/mobileqq/pb/financial/FinancialEntry$DrawerRsp;", "rsp", "", "a", "", "errCode", "", "errMsg", "onFail", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class c implements pl2.o<FinancialEntry$DrawerRsp> {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQSettingMeFinancialProcessor.this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // pl2.k
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@NotNull FinancialEntry$DrawerRsp rsp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) rsp);
                return;
            }
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            com.tencent.mobileqq.activity.qqsettingme.bean.d dVar = (com.tencent.mobileqq.activity.qqsettingme.bean.d) QQSettingMeFinancialProcessor.this.beanLiveData.getValue();
            if (dVar == null) {
                dVar = new com.tencent.mobileqq.activity.qqsettingme.bean.d(false, null, null, 7, null);
            }
            dVar.d(rsp.title.get());
            boolean z16 = true;
            if (rsp.show_flag.get() != 1) {
                z16 = false;
            }
            dVar.f(z16);
            dVar.e(rsp.url.get());
            QQSettingMeFinancialProcessor.this.beanLiveData.postValue(dVar);
        }

        @Override // pl2.k
        public void onFail(int errCode, @NotNull String errMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, errCode, (Object) errMsg);
                return;
            }
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QLog.w("QQSettingMeFinancialProcessor", 1, "requestDrawerEntry error: " + errMsg);
            QQSettingMeFinancialProcessor.this.beanLiveData.postValue(new com.tencent.mobileqq.activity.qqsettingme.bean.d(false, null, null, 7, null));
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52391);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQSettingMeFinancialProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.beanLiveData = new MutableLiveData<>(null);
        this.isCurrentResume = new AtomicBoolean(false);
        this.hasCheckRes = new AtomicBoolean(false);
    }

    private final void A() {
        c cVar = new c();
        FinancialEntry$DrawerReq financialEntry$DrawerReq = new FinancialEntry$DrawerReq();
        financialEntry$DrawerReq.child_mode_flag.set(StudyModeManager.t() ? 1 : 0);
        p.Companion companion = pl2.p.INSTANCE;
        QLog.i("QWalletHttp-QWalletPbServlet", 1, "send req: cmd=trpc.finance.entry.Entry.SsoDrawer callback: " + cVar + TokenParser.SP);
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        NewIntent newIntent = new NewIntent(waitAppRuntime.getApplication(), pl2.p.class);
        newIntent.putExtra("cmd", "trpc.finance.entry.Entry.SsoDrawer");
        newIntent.putExtra("data", fh.b(financialEntry$DrawerReq.toByteArray()));
        newIntent.putExtra("timeout", 30000L);
        newIntent.setObserver(new b(cVar));
        waitAppRuntime.startServlet(newIntent);
    }

    private final void B(String url) {
        boolean startsWith$default;
        boolean contains$default;
        QLog.i("QQSettingMeFinancialProcessor", 1, "startCheckKuiklyRes");
        if (url != null) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url, SchemaUtils.SCHEMA_MQQAPI, false, 2, null);
            if (startsWith$default) {
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) IQWalletKuiklyApi.KUIKLY_BUNDLE_QWALLET_FINANCIAL, false, 2, (Object) null);
                if (contains$default) {
                    ((IQWalletKuiklyApi) QRoute.api(IQWalletKuiklyApi.class)).preloadKuiklyBundle(IQWalletKuiklyApi.KUIKLY_BUNDLE_QWALLET_FINANCIAL, QQSettingMeFinancialProcessor$startCheckKuiklyRes$1.INSTANCE);
                }
            }
        }
    }

    private final void C(String url) {
        boolean contains$default;
        boolean contains$default2;
        QBaseActivity qBaseActivity = this.f259741b.get();
        if (qBaseActivity == null) {
            return;
        }
        boolean z16 = true;
        QLog.i("QQSettingMeFinancialProcessor", 1, "startCheckPreLogin");
        int i3 = 0;
        if (url != null && url.length() != 0) {
            z16 = false;
        }
        if (!z16) {
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) IQWalletKuiklyApi.URL_ABILITY_KEY_H5_PRELOGIN, false, 2, (Object) null);
            if (!contains$default) {
                contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) url, (CharSequence) IQWalletKuiklyApi.URL_ABILITY_KEY_KUIKLY_PRELOGIN, false, 2, (Object) null);
                if (contains$default2) {
                    i3 = 6;
                } else {
                    return;
                }
            }
            ((INewQWalletApi) QRoute.api(INewQWalletApi.class)).startPreLogin(qBaseActivity, IQWalletKuiklyApi.FINANCIAL_APPID, i3, url);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D(com.tencent.mobileqq.activity.qqsettingme.bean.d bean) {
        boolean z16;
        boolean z17;
        String str;
        View i3 = com.tencent.mobileqq.qqsettingme.a.i("d_financial", Boolean.FALSE);
        if (i3 == null) {
            return;
        }
        if (bean != null && bean.c()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && !com.tencent.mobileqq.activity.qqsettingme.utils.b.h(com.tencent.mobileqq.qqsettingme.a.c("d_financial"))) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17 && bean != null) {
            if (this.isCurrentResume.compareAndSet(true, false)) {
                z("qqwallet.minivault_cty.show");
                if (this.hasCheckRes.compareAndSet(false, true)) {
                    C(bean.b());
                    B(bean.b());
                }
            }
            i3.setVisibility(0);
            if (!QQTheme.isNowSimpleUI()) {
                TextView textView = (TextView) i3.findViewById(R.id.umj);
                if (textView == null) {
                    return;
                } else {
                    textView.setText(bean.a());
                }
            }
        } else {
            i3.setVisibility(8);
        }
        if (QLog.isColorLevel()) {
            if (bean != null) {
                str = bean.a();
            } else {
                str = null;
            }
            QLog.d("QQSettingMeFinancialProcessor", 2, "updateFinancialView:" + z17 + ", " + str);
        }
    }

    private final BusinessInfoCheckUpdate.AppInfo v() {
        return this.f185016h.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void y() {
        this.beanLiveData.postValue(this.beanLiveData.getValue());
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028 A[Catch: JSONException -> 0x0023, TRY_LEAVE, TryCatch #0 {JSONException -> 0x0023, blocks: (B:27:0x001a, B:10:0x0028), top: B:26:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void z(String actionName) {
        String str;
        boolean z16;
        JSONObject jSONObject;
        String str2;
        PBUInt32Field pBUInt32Field;
        PBStringField pBStringField;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        BusinessInfoCheckUpdate.AppInfo v3 = v();
        String str3 = null;
        if (v3 != null && (pBStringField = v3.buffer) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        if (str != null) {
            try {
            } catch (JSONException e16) {
                QLog.w("QQSettingMeFinancialProcessor", 1, "bufferJSON is null", e16);
            }
            if (str.length() != 0) {
                z16 = false;
                if (!z16) {
                    jSONObject = new JSONObject(str);
                    if (jSONObject != null) {
                        str2 = jSONObject.optString("ad_id");
                    } else {
                        str2 = null;
                    }
                    if (v3 != null && (pBUInt32Field = v3.type) != null) {
                        str3 = Integer.valueOf(pBUInt32Field.get()).toString();
                    }
                    ReportController.o(peekAppRuntime, "P_CliOper", "Vip_pay_mywallet", null, QCircleDaTongConstant.ElementParamValue.WALLET, actionName, 0, 0, str2, null, str3, RedTouch.getRedTypeInfoText(v3));
                }
                jSONObject = null;
                if (jSONObject != null) {
                }
                if (v3 != null) {
                    str3 = Integer.valueOf(pBUInt32Field.get()).toString();
                }
                ReportController.o(peekAppRuntime, "P_CliOper", "Vip_pay_mywallet", null, QCircleDaTongConstant.ElementParamValue.WALLET, actionName, 0, 0, str2, null, str3, RedTouch.getRedTypeInfoText(v3));
            }
        }
        z16 = true;
        if (!z16) {
        }
        jSONObject = null;
        if (jSONObject != null) {
        }
        if (v3 != null) {
        }
        ReportController.o(peekAppRuntime, "P_CliOper", "Vip_pay_mywallet", null, QCircleDaTongConstant.ElementParamValue.WALLET, actionName, 0, 0, str2, null, str3, RedTouch.getRedTypeInfoText(v3));
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.q, com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void d(@Nullable com.tencent.mobileqq.qqsettingme.a qqSettingMe) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) qqSettingMe);
            return;
        }
        super.d(qqSettingMe);
        MutableLiveData<com.tencent.mobileqq.activity.qqsettingme.bean.d> mutableLiveData = this.beanLiveData;
        LifecycleOwner lifecycleOwner = this.f259743d;
        final Function1<com.tencent.mobileqq.activity.qqsettingme.bean.d, Unit> function1 = new Function1<com.tencent.mobileqq.activity.qqsettingme.bean.d, Unit>() { // from class: com.tencent.mobileqq.activity.qqsettingme.QQSettingMeFinancialProcessor$initViewBinder$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQSettingMeFinancialProcessor.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.activity.qqsettingme.bean.d dVar) {
                invoke2(dVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable com.tencent.mobileqq.activity.qqsettingme.bean.d dVar) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    QQSettingMeFinancialProcessor.this.D(dVar);
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) dVar);
                }
            }
        };
        mutableLiveData.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.activity.qqsettingme.z
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQSettingMeFinancialProcessor.x(Function1.this, obj);
            }
        });
        this.beanLiveData.postValue(new com.tencent.mobileqq.activity.qqsettingme.bean.d(false, null, null, 7, null));
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        if (((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.activity.qqsettingme.q, com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void onClick(@Nullable View v3) {
        String str;
        AppRuntime peekAppRuntime;
        IRedTouchManager iRedTouchManager;
        PBInt32Field pBInt32Field;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) v3);
            return;
        }
        QBaseActivity qBaseActivity = this.f259741b.get();
        if (qBaseActivity == null) {
            return;
        }
        Integer num = null;
        if (com.tencent.mobileqq.qwallet.utils.g.b("qwalley_key_financial_kuikly") && !AppSetting.isPublicVersion()) {
            com.tencent.mobileqq.qwallet.utils.k.h(qBaseActivity, "mqqapi://kuikly/open?page_name=qwallet_financial_home&bundle_name=qwallet_financial&version=1&src_type=app&custom_back_pressed=1");
        } else {
            com.tencent.mobileqq.activity.qqsettingme.bean.d value = this.beanLiveData.getValue();
            if (value != null) {
                str = value.b();
            } else {
                str = null;
            }
            com.tencent.mobileqq.qwallet.utils.k.h(qBaseActivity, str);
        }
        BusinessInfoCheckUpdate.AppInfo value2 = this.f185016h.getValue();
        if (value2 != null && (pBInt32Field = value2.iNewFlag) != null) {
            num = Integer.valueOf(pBInt32Field.get());
        }
        if (num != null && num.intValue() != 0 && (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) != null && (iRedTouchManager = (IRedTouchManager) peekAppRuntime.getRuntimeService(IRedTouchManager.class, "")) != null) {
            iRedTouchManager.reportLevelOneRedInfo(BusinessInfoCheckUpdateItem.UIAPPID_FINANCIAL, 31);
        }
        z("qqwallet.minivault_cty.click");
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void onPostThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.onPostThemeChanged();
            y();
        }
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onResume();
        this.isCurrentResume.set(true);
        A();
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void preload() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.preload();
            A();
        }
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    @NotNull
    public String w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "d_financial";
    }
}
