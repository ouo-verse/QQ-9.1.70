package com.tencent.mobileqq.search.business.activatepage;

import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.report.Reporters;
import com.tencent.mobileqq.search.business.activatepage.ActivatePageRepo;
import com.tencent.mobileqq.search.util.n;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IKernelUnifySearchService;
import com.tencent.qqnt.kernel.nativeinterface.IUnifySearchDiscoveryCallback;
import com.tencent.qqnt.kernel.nativeinterface.UfsDisReqBody;
import com.tencent.qqnt.kernel.nativeinterface.UfsDisRspBody;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0002\u000f\u0010B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ>\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042$\u0010\u000b\u001a \u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\u0004\u0012\u00020\n0\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/search/business/activatepage/ActivatePageRepo;", "", "", "from", "", "byCached", "Lkotlin/Function1;", "Lkotlin/Triple;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/UfsDisRspBody;", "", "callback", "b", "<init>", "()V", "a", "ThrowableWithError", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class ActivatePageRepo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0005H\u00c6\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/search/business/activatepage/ActivatePageRepo$ThrowableWithError;", "", "errorCode", "", "errorMsg", "", "causeMsg", "(ILjava/lang/String;Ljava/lang/String;)V", "getCauseMsg", "()Ljava/lang/String;", "getErrorCode", "()I", "getErrorMsg", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes18.dex */
    public static final /* data */ class ThrowableWithError extends Throwable {

        @NotNull
        private final String causeMsg;
        private final int errorCode;

        @NotNull
        private final String errorMsg;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ThrowableWithError(int i3, @NotNull String errorMsg, @NotNull String causeMsg) {
            super(causeMsg);
            Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
            Intrinsics.checkNotNullParameter(causeMsg, "causeMsg");
            this.errorCode = i3;
            this.errorMsg = errorMsg;
            this.causeMsg = causeMsg;
        }

        public static /* synthetic */ ThrowableWithError copy$default(ThrowableWithError throwableWithError, int i3, String str, String str2, int i16, Object obj) {
            if ((i16 & 1) != 0) {
                i3 = throwableWithError.errorCode;
            }
            if ((i16 & 2) != 0) {
                str = throwableWithError.errorMsg;
            }
            if ((i16 & 4) != 0) {
                str2 = throwableWithError.causeMsg;
            }
            return throwableWithError.copy(i3, str, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final int getErrorCode() {
            return this.errorCode;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final String getErrorMsg() {
            return this.errorMsg;
        }

        @NotNull
        /* renamed from: component3, reason: from getter */
        public final String getCauseMsg() {
            return this.causeMsg;
        }

        @NotNull
        public final ThrowableWithError copy(int errorCode, @NotNull String errorMsg, @NotNull String causeMsg) {
            Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
            Intrinsics.checkNotNullParameter(causeMsg, "causeMsg");
            return new ThrowableWithError(errorCode, errorMsg, causeMsg);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ThrowableWithError)) {
                return false;
            }
            ThrowableWithError throwableWithError = (ThrowableWithError) other;
            if (this.errorCode == throwableWithError.errorCode && Intrinsics.areEqual(this.errorMsg, throwableWithError.errorMsg) && Intrinsics.areEqual(this.causeMsg, throwableWithError.causeMsg)) {
                return true;
            }
            return false;
        }

        @NotNull
        public final String getCauseMsg() {
            return this.causeMsg;
        }

        public final int getErrorCode() {
            return this.errorCode;
        }

        @NotNull
        public final String getErrorMsg() {
            return this.errorMsg;
        }

        public int hashCode() {
            return (((this.errorCode * 31) + this.errorMsg.hashCode()) * 31) + this.causeMsg.hashCode();
        }

        @Override // java.lang.Throwable
        @NotNull
        public String toString() {
            return "ThrowableWithError(errorCode=" + this.errorCode + ", errorMsg=" + this.errorMsg + ", causeMsg=" + this.causeMsg + ")";
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/search/business/activatepage/ActivatePageRepo$a;", "", "", "from", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.search.business.activatepage.ActivatePageRepo$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final int a(int from) {
            if (from == 1) {
                return 1;
            }
            if (from == 2) {
                return 2;
            }
            if (from != 21) {
                return 1;
            }
            return 3;
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/search/business/activatepage/ActivatePageRepo$b", "Lcom/tencent/qqnt/kernel/nativeinterface/IUnifySearchDiscoveryCallback;", "", "errCode", "", "errMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/UfsDisRspBody;", "rsp", "", "onResult", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b implements IUnifySearchDiscoveryCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f282820a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IPerformanceReportTask f282821b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function1<Triple<Integer, String, UfsDisRspBody>, Unit> f282822c;

        /* JADX WARN: Multi-variable type inference failed */
        b(long j3, IPerformanceReportTask iPerformanceReportTask, Function1<? super Triple<Integer, String, UfsDisRspBody>, Unit> function1) {
            this.f282820a = j3;
            this.f282821b = iPerformanceReportTask;
            this.f282822c = function1;
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IUnifySearchDiscoveryCallback
        public void onResult(int errCode, @Nullable String errMsg, @Nullable UfsDisRspBody rsp) {
            String str;
            QLog.d("ActivatePageRepo", 1, "unifySearchDiscovery rsp <<< code " + errCode + ",cost " + (System.currentTimeMillis() - this.f282820a));
            this.f282821b.setResultCode((long) errCode);
            IPerformanceReportTask iPerformanceReportTask = this.f282821b;
            if (errMsg == null) {
                str = "";
            } else {
                str = errMsg;
            }
            iPerformanceReportTask.setResultMsg(str);
            this.f282821b.report();
            Function1<Triple<Integer, String, UfsDisRspBody>, Unit> function1 = this.f282822c;
            Integer valueOf = Integer.valueOf(errCode);
            if (errMsg == null) {
                errMsg = "";
            }
            if (rsp == null) {
                rsp = new UfsDisRspBody();
            }
            function1.invoke(new Triple<>(valueOf, errMsg, rsp));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(long j3, Function1 callback, int i3, String str, UfsDisRspBody ufsDisRspBody) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        QLog.d("ActivatePageRepo", 1, "requestSearchDiscoveryByCached code " + i3 + ",cost " + (System.currentTimeMillis() - j3));
        callback.invoke(new Triple(Integer.valueOf(i3), str, ufsDisRspBody));
    }

    public final void b(int from, boolean byCached, @NotNull final Function1<? super Triple<Integer, String, UfsDisRspBody>, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        UfsDisReqBody ufsDisReqBody = new UfsDisReqBody();
        ufsDisReqBody.fromType = from;
        ufsDisReqBody.business = 128;
        String subVersion = AppSetting.f99551k;
        Intrinsics.checkNotNullExpressionValue(subVersion, "subVersion");
        Charset UTF_8 = StandardCharsets.UTF_8;
        Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
        byte[] bytes = subVersion.getBytes(UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        ufsDisReqBody.version = bytes;
        QLog.d("ActivatePageRepo", 1, "requestSearchDiscoveryDataByCb " + byCached + " fromType " + from);
        final long currentTimeMillis = System.currentTimeMillis();
        Unit unit = null;
        if (byCached) {
            IKernelUnifySearchService c16 = n.c();
            if (c16 != null) {
                c16.unifySearchDiscoveryInCache(ufsDisReqBody, new IUnifySearchDiscoveryCallback() { // from class: tn2.a
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IUnifySearchDiscoveryCallback
                    public final void onResult(int i3, String str, UfsDisRspBody ufsDisRspBody) {
                        ActivatePageRepo.c(currentTimeMillis, callback, i3, str, ufsDisRspBody);
                    }
                });
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                QLog.e("ActivatePageRepo", 1, "requestSearchDiscoveryByCached unifySearchService is null");
                callback.invoke(new Triple(-1, "unifySearchService is null", new UfsDisRspBody()));
                return;
            }
            return;
        }
        QLog.d("ActivatePageRepo", 1, "unifySearchDiscovery >>> " + byCached + " fromType " + from);
        IPerformanceReportTask a16 = Reporters.f231995a.c().a("search_discovery_nt_request_quality");
        IKernelUnifySearchService c17 = n.c();
        if (c17 != null) {
            c17.unifySearchDiscovery(ufsDisReqBody, new b(currentTimeMillis, a16, callback));
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            QLog.e("ActivatePageRepo", 1, "unifySearchDiscovery unifySearchService is null");
            callback.invoke(new Triple(-1, "unifySearchService is null", new UfsDisRspBody()));
        }
    }
}
