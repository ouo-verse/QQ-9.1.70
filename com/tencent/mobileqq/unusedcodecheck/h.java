package com.tencent.mobileqq.unusedcodecheck;

import android.util.Base64;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.zip.GZIPOutputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J(\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u0006\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/unusedcodecheck/h;", "", "Lcom/tencent/mobileqq/unusedcodecheck/CheckStateData;", "checkState", "", "loadRate", "", "processCount", "", "c", "Lcom/tencent/mobileqq/unusedcodecheck/LoadedClassInfoObject;", "info", "d", "", "minLoadRate", "", "isReportCoverInfo", "lookupCountLimit", "a", "<init>", "()V", "unusedcode-check_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes17.dex */
public final class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0004\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/unusedcodecheck/h$a;", "", "", "REPORT_KEY_ALL_CLASS_COUNT", "Ljava/lang/String;", "REPORT_KEY_COMMIT_ID", "REPORT_KEY_COVERAGE_LOOKUP_COUNT", "REPORT_KEY_COVERAGE_PROCESS_COUNT", "REPORT_KEY_COVERAGE_RATE", "REPORT_KEY_DATA", "REPORT_KEY_FIRST_CLASS_NAME", "REPORT_KEY_LAST_CLASS_NAME", "REPORT_KEY_PART_CLASS_COUNT", "REPORT_KEY_PART_CLASS_HASH", "REPORT_KEY_VERSION", "TAG", "<init>", "()V", "unusedcode-check_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.mobileqq.unusedcodecheck.h$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(8382);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    public static /* synthetic */ boolean b(h hVar, CheckStateData checkStateData, double d16, boolean z16, int i3, int i16, Object obj) {
        if ((i16 & 8) != 0) {
            i3 = b.f306127n.k();
        }
        return hVar.a(checkStateData, d16, z16, i3);
    }

    private final void c(CheckStateData checkState, float loadRate, int processCount) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("commitID", checkState.b());
        linkedHashMap.put("version", checkState.f());
        linkedHashMap.put("coverageRate", String.valueOf(loadRate));
        linkedHashMap.put("lookupCount", String.valueOf(checkState.c()));
        linkedHashMap.put("processCount", String.valueOf(processCount));
        b.f306127n.n().f(linkedHashMap);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void d(CheckStateData checkState, LoadedClassInfoObject info) {
        byte[] bArr;
        IOException e16;
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] byteArray = info.getMarker().toByteArray();
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    gZIPOutputStream.write(byteArray);
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(gZIPOutputStream, null);
                    bArr = byteArrayOutputStream.toByteArray();
                } finally {
                }
            } finally {
            }
        } catch (IOException e17) {
            bArr = null;
            e16 = e17;
            b.f306127n.n().h("UnusedCodeCheck.Report", "reportInternal error", e16);
            if (bArr != null) {
            }
        }
        try {
            CloseableKt.closeFinally(byteArrayOutputStream, null);
        } catch (IOException e18) {
            e16 = e18;
            b.f306127n.n().h("UnusedCodeCheck.Report", "reportInternal error", e16);
            if (bArr != null) {
            }
        }
        if (bArr != null) {
            String reportData = Base64.encodeToString(bArr, 11);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            String firstClassName = info.getFirstClassName();
            Intrinsics.checkNotNullExpressionValue(firstClassName, "info.firstClassName");
            linkedHashMap.put("firstClassName", firstClassName);
            String lastClassName = info.getLastClassName();
            Intrinsics.checkNotNullExpressionValue(lastClassName, "info.lastClassName");
            linkedHashMap.put("lastClassName", lastClassName);
            linkedHashMap.put("partClassCount", String.valueOf(info.getPartClassCount()));
            linkedHashMap.put("allClassCount", String.valueOf(info.getAllClassCount()));
            Intrinsics.checkNotNullExpressionValue(reportData, "reportData");
            linkedHashMap.put("reportData", reportData);
            linkedHashMap.put("commitID", checkState.b());
            linkedHashMap.put("version", checkState.f());
            if (info.getHashResult() != null) {
                String hashResult = info.getHashResult();
                Intrinsics.checkNotNullExpressionValue(hashResult, "info.hashResult");
                linkedHashMap.put("partClassHash", hashResult);
            }
            b bVar = b.f306127n;
            bVar.n().i(linkedHashMap);
            g n3 = bVar.n();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("report version:");
            sb5.append(checkState.f());
            sb5.append(" commitID:");
            sb5.append(checkState.b());
            sb5.append(" firstClassName:");
            sb5.append(info.getFirstClassName());
            sb5.append("  byteExpression.size:");
            sb5.append(byteArray.length);
            sb5.append(" compressBytes.size:");
            Intrinsics.checkNotNull(bArr);
            sb5.append(bArr.length);
            sb5.append(" reportData.length:");
            sb5.append(reportData.length());
            n3.c("UnusedCodeCheck.Report", sb5.toString());
        }
    }

    public final boolean a(@NotNull CheckStateData checkState, double minLoadRate, boolean isReportCoverInfo, int lookupCountLimit) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Boolean) iPatchRedirector.redirect((short) 1, this, checkState, Double.valueOf(minLoadRate), Boolean.valueOf(isReportCoverInfo), Integer.valueOf(lookupCountLimit))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(checkState, "checkState");
        if (checkState.c() < lookupCountLimit) {
            return false;
        }
        LoadResult a16 = new a(checkState).a(isReportCoverInfo);
        List<LoadedClassInfoObject> a17 = a16.a();
        float b16 = a16.b();
        if (isReportCoverInfo) {
            c(checkState, b16, a16.c());
        }
        if (b16 > minLoadRate) {
            Iterator<T> it = a17.iterator();
            while (it.hasNext()) {
                d(checkState, (LoadedClassInfoObject) it.next());
            }
            z16 = true;
        }
        b.f306127n.n().c("UnusedCodeCheck.Report", "triggerReport isReportCoverInfo:" + isReportCoverInfo + " loadResult:" + a16 + " isReported:" + z16);
        return z16;
    }
}
