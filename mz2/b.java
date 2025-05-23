package mz2;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.qqva.wedata_report.wedata_report.WedataReportPB;
import cooperation.qzone.remote.ServiceConst;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016JP\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00062\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006H\u0002J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J \u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002JN\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00062\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006\u00a8\u0006\u0017"}, d2 = {"Lmz2/b;", "", "", "busiId", "event", "sessionId", "", "eventParams", "businessParams", "", "c", "Lcom/tencent/trpcprotocol/qqva/wedata_report/wedata_report/WedataReportPB$ReportReq;", Const.BUNDLE_KEY_REQUEST, "g", "eventCode", "Lcom/tencent/trpcprotocol/qqva/wedata_report/wedata_report/WedataReportPB$Item$b;", "d", "Lcom/tencent/trpcprotocol/qqva/wedata_report/wedata_report/WedataReportPB$Item;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "b", "e", "<init>", "()V", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f417903a = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"mz2/b$a", "Lcom/tencent/biz/ProtoUtils$TroopProtocolObserver;", "", "errorCode", "", "data", "Landroid/os/Bundle;", "bundle", "", "onResult", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class a extends ProtoUtils.TroopProtocolObserver {
        a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int errorCode, @Nullable byte[] data, @Nullable Bundle bundle) {
            QLog.d("NegativeFeedBackReportService", 4, "report NFB result");
            if (errorCode == 0 && data != null) {
                try {
                    QLog.d("NegativeFeedBackReportService", 4, "report NFB result " + ((WedataReportPB.ReportRsp.b) WedataReportPB.ReportRsp.newBuilder().mergeFrom(data)).build());
                    return;
                } catch (InvalidProtocolBufferMicroException e16) {
                    QLog.e("NegativeFeedBackReportService", 4, "sendOIDBRequest fail", e16);
                    return;
                }
            }
            QLog.e("NegativeFeedBackReportService", 4, "report NFB to Server result error! errorCode = " + errorCode);
        }
    }

    b() {
    }

    private final WedataReportPB.ReportReq b(WedataReportPB.Item item) {
        WedataReportPB.ReportReq.b newBuilder = WedataReportPB.ReportReq.newBuilder();
        newBuilder.D("negative_feedback");
        newBuilder.n(item);
        WedataReportPB.ReportReq build = newBuilder.build();
        Intrinsics.checkNotNullExpressionValue(build, "newBuilder().apply {\n   \u2026t(item)\n        }.build()");
        return build;
    }

    private final void c(String busiId, String event, String sessionId, Map<String, String> eventParams, Map<String, String> businessParams) {
        QLog.d("NegativeFeedBackReportService", 4, "buildRequestAndReportEvent, event: " + event);
        WedataReportPB.Item.b d16 = d(busiId, event, sessionId);
        if (businessParams != null) {
            d16.B(businessParams);
        }
        if (eventParams != null) {
            d16.B(eventParams);
        }
        WedataReportPB.Item build = d16.build();
        Intrinsics.checkNotNullExpressionValue(build, "itemBuilder.build()");
        g(b(build));
    }

    private final WedataReportPB.Item.b d(String busiId, String eventCode, String sessionId) {
        String str;
        Object obj;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Object obj2 = null;
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getAccount();
        } else {
            str = null;
        }
        String str2 = "";
        if (str == null) {
            str = "";
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            obj = Result.m476constructorimpl(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date(System.currentTimeMillis())));
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            obj = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        if (!Result.m482isFailureimpl(obj)) {
            obj2 = obj;
        }
        String str3 = (String) obj2;
        if (str3 != null) {
            str2 = str3;
        }
        WedataReportPB.Item.b newBuilder = WedataReportPB.Item.newBuilder();
        newBuilder.C("busi_id", busiId);
        newBuilder.C("uin", str);
        newBuilder.C("event_code", eventCode);
        newBuilder.C("event_time", str2);
        newBuilder.C(ServiceConst.PARA_SESSION_ID, sessionId);
        newBuilder.C("sdk_version", "1.0.1");
        newBuilder.C("platform", "android");
        newBuilder.C("app_version", AppSetting.f99551k);
        newBuilder.C("report_src", "app");
        Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder().apply {\n   \u2026RC, REPORT_SRC)\n        }");
        return newBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(String busiId, String event, String sessionId, Map map, Map map2) {
        Intrinsics.checkNotNullParameter(busiId, "$busiId");
        Intrinsics.checkNotNullParameter(event, "$event");
        Intrinsics.checkNotNullParameter(sessionId, "$sessionId");
        f417903a.c(busiId, event, sessionId, map, map2);
    }

    private final void g(WedataReportPB.ReportReq request) {
        ProtoUtils.a(MobileQQ.sMobileQQ.peekAppRuntime(), new a(), request.toByteArray(), "OidbSvcTrpcTcp.0x93ba_0", 37818, 0);
    }

    public final void e(@NotNull final String busiId, @NotNull final String event, @NotNull final String sessionId, @Nullable final Map<String, String> eventParams, @Nullable final Map<String, String> businessParams) {
        Intrinsics.checkNotNullParameter(busiId, "busiId");
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        ThreadManagerV2.excute(new Runnable() { // from class: mz2.a
            @Override // java.lang.Runnable
            public final void run() {
                b.f(busiId, event, sessionId, eventParams, businessParams);
            }
        }, 16, null, false);
    }
}
