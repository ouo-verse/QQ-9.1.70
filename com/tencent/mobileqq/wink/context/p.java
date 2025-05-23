package com.tencent.mobileqq.wink.context;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.sdk.Wink;
import com.tencent.mobileqq.winkpublish.report.WinkContextErrorCode;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \r2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001c\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\t\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001c\u0010\u000b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u000fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/wink/context/p;", "", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/content/Intent;", "intent", "", "e", "d", "f", "b", "a", "outState", "c", "", "Ljava/lang/String;", PreDownloadConstants.RPORT_KEY_BUSINESS_NAME, "traceId", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String businessName;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String traceId;

    private final void b(Intent intent) {
        String str;
        long currentTimeMillis = System.currentTimeMillis();
        WinkContext.Companion companion = WinkContext.INSTANCE;
        WinkContext h16 = companion.h(this.traceId);
        boolean z16 = true;
        QLog.i("SetupCurrentDelegate", 1, "[ensureWinkContext] cost=" + (System.currentTimeMillis() - currentTimeMillis) + ", traceId=" + this.traceId + ", winkContext=" + h16);
        if (h16 == null) {
            QLog.e("SetupCurrentDelegate", 1, "[ensureWinkContext] invalid WinkContext, traceId=" + this.traceId);
            f(intent);
            String str2 = this.businessName;
            if (str2 == null) {
                str2 = "";
            }
            h16 = companion.c(new BuildParams(str2, this.traceId, null, null, null, null));
        } else {
            this.businessName = h16.k().a();
            if (intent != null) {
                str = intent.getStringExtra(QQWinkConstants.MISSION_ID);
            } else {
                str = null;
            }
            if (str != null && str.length() != 0) {
                z16 = false;
            }
            if (!z16) {
                h16.y(str);
            }
        }
        companion.o(h16);
        h16.t(intent);
    }

    private final void d(Bundle savedInstanceState, Intent intent) {
        if (TextUtils.isEmpty(this.businessName) && savedInstanceState != null) {
            this.businessName = savedInstanceState.getString(QQWinkConstants.ENTRY_BUSINESS_NAME);
        }
        if (TextUtils.isEmpty(this.businessName) && intent != null) {
            this.businessName = intent.getStringExtra(QQWinkConstants.ENTRY_BUSINESS_NAME);
        }
        if (TextUtils.isEmpty(this.businessName)) {
            QLog.w("SetupCurrentDelegate", 1, "[prepareBusinessName] inState=" + savedInstanceState + ", intent=" + intent);
            this.businessName = "QCIRCLE";
        }
    }

    private final void e(Bundle savedInstanceState, Intent intent) {
        if (TextUtils.isEmpty(this.traceId) && savedInstanceState != null) {
            this.traceId = savedInstanceState.getString(PeakConstants.QCIRCLE_CLIENT_TRACEID);
        }
        if (TextUtils.isEmpty(this.traceId) && intent != null) {
            this.traceId = intent.getStringExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID);
        }
        if (TextUtils.isEmpty(this.traceId)) {
            String g16 = WinkContext.INSTANCE.g();
            this.traceId = g16;
            QLog.e("SetupCurrentDelegate", 1, "[prepareTraceId] invalid traceId, new traceId=" + g16);
        }
    }

    private final void f(Intent intent) {
        String str;
        String str2;
        WinkContextErrorCode winkContextErrorCode = new WinkContextErrorCode(WinkContextErrorCode.ERROR_CODE_SET_CURRENT_EMPTY, null);
        String str3 = "";
        if (intent == null || (str = intent.getStringExtra("public_fragment_class")) == null) {
            str = "";
        }
        if (intent == null || (str2 = intent.getStringExtra("key_scheme")) == null) {
            str2 = "";
        }
        WinkPublishQualityReportData.Builder builder = new WinkPublishQualityReportData.Builder();
        WinkPublishQualityReportData.Builder eventId = builder.eventId("E_WINK_CONTEXT_SET_CURRENT");
        String str4 = this.traceId;
        if (str4 != null) {
            str3 = str4;
        }
        eventId.traceId(str3).retCode(String.valueOf(winkContextErrorCode.transformedCode())).ext1(str).ext2(str2).desc(winkContextErrorCode.getMessage());
        z93.c f16 = Wink.INSTANCE.f();
        if (f16 != null) {
            WinkPublishQualityReportData reportData = builder.getReportData();
            String str5 = this.businessName;
            if (str5 == null) {
                str5 = "QCIRCLE";
            }
            f16.b(reportData, str5);
        }
    }

    public void a(@Nullable Bundle savedInstanceState, @Nullable Intent intent) {
        e(savedInstanceState, intent);
        d(savedInstanceState, intent);
        b(intent);
    }

    public void c(@NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        outState.putString(PeakConstants.QCIRCLE_CLIENT_TRACEID, this.traceId);
        outState.putString(QQWinkConstants.ENTRY_BUSINESS_NAME, this.businessName);
    }
}
