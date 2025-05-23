package com.tencent.mobileqq.qqlive.base;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.base.ipc.QQLiveClientQIPCModule;
import com.tencent.mobileqq.qqlive.context.QQLiveContext;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.common.api.IQQLiveReportApi;
import com.tencent.qqlive.common.report.constant.QQLiveReportConstants;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\b\u0016\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001c\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\u0006H\u0004J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0004R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/qqlive/base/QQLiveBaseFragment2;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/content/Intent;", "intent", "", "ph", "", "qh", "onCreate", "outState", "onSaveInstanceState", "setStatusBarImmersive", "", "screenOn", "rh", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "traceId", "<init>", "()V", "D", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public class QQLiveBaseFragment2 extends QPublicBaseFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private String traceId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/base/QQLiveBaseFragment2$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.base.QQLiveBaseFragment2$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22007);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQLiveBaseFragment2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void ph(Bundle savedInstanceState, Intent intent) {
        String qh5 = qh(savedInstanceState, intent);
        QQLiveContext.Companion companion = QQLiveContext.INSTANCE;
        QQLiveContext d16 = companion.d(qh5);
        if (d16 == null) {
            d16 = companion.a(intent);
        }
        companion.f(d16);
        AegisLogger.INSTANCE.i("Open_Live|QQLiveBaseFragment2", "ensureLiveContext", "traceId=" + qh5);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0025, code lost:
    
        if (r5 != false) goto L17;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String qh(Bundle savedInstanceState, Intent intent) {
        boolean z16;
        String str;
        String str2;
        boolean isBlank;
        boolean isBlank2;
        String str3 = this.traceId;
        boolean z17 = false;
        if (str3 != null) {
            isBlank2 = StringsKt__StringsJVMKt.isBlank(str3);
            if (!isBlank2) {
                z16 = false;
                if (z16 && savedInstanceState != null) {
                    this.traceId = savedInstanceState.getString(QQLiveReportConstants.INTENT_TRACE_ID);
                }
                str = this.traceId;
                if (str != null) {
                    isBlank = StringsKt__StringsJVMKt.isBlank(str);
                }
                z17 = true;
                if (z17 && intent != null) {
                    this.traceId = intent.getStringExtra(QQLiveReportConstants.INTENT_TRACE_ID);
                }
                str2 = this.traceId;
                if (str2 != null) {
                    String generateTraceId = ((IQQLiveReportApi) QRoute.api(IQQLiveReportApi.class)).generateTraceId();
                    Intrinsics.checkNotNullExpressionValue(generateTraceId, "api(IQQLiveReportApi::cl\u2026s.java).generateTraceId()");
                    return generateTraceId;
                }
                return str2;
            }
        }
        z16 = true;
        if (z16) {
            this.traceId = savedInstanceState.getString(QQLiveReportConstants.INTENT_TRACE_ID);
        }
        str = this.traceId;
        if (str != null) {
        }
        z17 = true;
        if (z17) {
            this.traceId = intent.getStringExtra(QQLiveReportConstants.INTENT_TRACE_ID);
        }
        str2 = this.traceId;
        if (str2 != null) {
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Intent intent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) savedInstanceState);
            return;
        }
        if (getQBaseActivity() != null) {
            intent = getQBaseActivity().getIntent();
        } else {
            intent = null;
        }
        ph(savedInstanceState, intent);
        QQLiveClientQIPCModule.INSTANCE.c().registerModule();
        super.onCreate(savedInstanceState);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle outState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) outState);
            return;
        }
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putString(QQLiveReportConstants.INTENT_TRACE_ID, this.traceId);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void rh(boolean screenOn) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, screenOn);
            return;
        }
        try {
            Window window = getQBaseActivity().getWindow();
            if (screenOn) {
                window.addFlags(128);
            } else {
                window.clearFlags(128);
            }
        } catch (Exception e16) {
            AegisLogger.INSTANCE.e("Open_Live|QQLiveBaseFragment2", "setKeepScreen", "error, ", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setStatusBarImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (getQBaseActivity() == null) {
            QLog.e("Open_Live|QQLiveBaseFragment2", 1, "setStatusBarImmersive qBaseActivity is null");
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
}
