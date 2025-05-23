package com.tencent.qqnt.trace.perf.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.trace.perf.AIOPerfDataType;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B9\u0012\b\b\u0002\u0010\u000f\u001a\u00020\f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\f\u0012\b\b\u0002\u0010\u0013\u001a\u00020\f\u0012\b\b\u0002\u0010\u0015\u001a\u00020\f\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0000H\u0016R\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000eR\u0016\u0010\u0015\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u000eR\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/qqnt/trace/perf/data/d;", "Lcom/tencent/qqnt/trace/perf/a;", "", "b", "Lcom/tencent/qqnt/trace/perf/AIOPerfDataType;", "getType", "getTitle", "", "getContentList", "prevData", "", "c", "", "a", "J", "appStartupTime", "processStartupCostTime", "mainShowCostTime", "d", "msgSyncCostTime", "e", "totalCostTime", "Ljava/text/SimpleDateFormat;", "f", "Ljava/text/SimpleDateFormat;", "sdf", "<init>", "(JJJJJ)V", "nt_trace_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class d implements com.tencent.qqnt.trace.perf.a<d> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private long appStartupTime;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private long processStartupCostTime;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long mainShowCostTime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long msgSyncCostTime;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long totalCostTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SimpleDateFormat sdf;

    public d() {
        this(0L, 0L, 0L, 0L, 0L, 31, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            return;
        }
        iPatchRedirector.redirect((short) 7, (Object) this);
    }

    private final String b() {
        long currentTimeMillis = (System.currentTimeMillis() - this.appStartupTime) / 60000;
        long j3 = 60;
        return (currentTimeMillis / j3) + " \u5c0f\u65f6 " + (currentTimeMillis % j3) + " \u5206\u949f";
    }

    @Override // com.tencent.qqnt.trace.perf.a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void a(@NotNull d prevData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) prevData);
            return;
        }
        Intrinsics.checkNotNullParameter(prevData, "prevData");
        if (this.appStartupTime == 0) {
            this.appStartupTime = prevData.appStartupTime;
        }
        if (this.processStartupCostTime == 0) {
            this.processStartupCostTime = prevData.processStartupCostTime;
        }
        if (this.mainShowCostTime == 0) {
            this.mainShowCostTime = prevData.mainShowCostTime;
        }
        if (this.msgSyncCostTime == 0) {
            this.msgSyncCostTime = prevData.msgSyncCostTime;
        }
        if (this.totalCostTime == 0) {
            this.totalCostTime = prevData.totalCostTime;
        }
    }

    @Override // com.tencent.qqnt.trace.perf.a
    @NotNull
    public List<String> getContentList() {
        List<String> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"\u8fdb\u7a0b\u8fd0\u884c\u65f6\u95f4\uff1a" + b(), "\u8fdb\u7a0b\u542f\u52a8\u8017\u65f6\uff1a" + this.processStartupCostTime + " ms", "\u4e3b\u754c\u9762\u521b\u5efa\u8017\u65f6\uff1a" + this.mainShowCostTime + " ms", "\u6ce8\u518c\u4ee3\u7406\u8017\u65f6\uff1a" + this.msgSyncCostTime + " ms", "\u603b\u8017\u65f6\uff1a" + this.totalCostTime + " ms"});
        return listOf;
    }

    @Override // com.tencent.qqnt.trace.perf.a
    @NotNull
    public String getTitle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "\u8fdb\u7a0b\u542f\u52a8";
    }

    @Override // com.tencent.qqnt.trace.perf.a
    @NotNull
    public AIOPerfDataType getType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (AIOPerfDataType) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return AIOPerfDataType.SYNC_MSG_TIME;
    }

    public d(long j3, long j16, long j17, long j18, long j19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17), Long.valueOf(j18), Long.valueOf(j19));
            return;
        }
        this.appStartupTime = j3;
        this.processStartupCostTime = j16;
        this.mainShowCostTime = j17;
        this.msgSyncCostTime = j18;
        this.totalCostTime = j19;
        this.sdf = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
    }

    public /* synthetic */ d(long j3, long j16, long j17, long j18, long j19, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0L : j3, (i3 & 2) != 0 ? 0L : j16, (i3 & 4) != 0 ? 0L : j17, (i3 & 8) != 0 ? 0L : j18, (i3 & 16) != 0 ? 0L : j19);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17), Long.valueOf(j18), Long.valueOf(j19), Integer.valueOf(i3), defaultConstructorMarker);
    }
}
