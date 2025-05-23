package com.tencent.qqnt.trace.perf.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.trace.perf.AIOPerfDataType;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B/\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0000H\u0016R\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\rR\u0016\u0010\u0013\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\r\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/trace/perf/data/c;", "Lcom/tencent/qqnt/trace/perf/a;", "Lcom/tencent/qqnt/trace/perf/AIOPerfDataType;", "getType", "", "getTitle", "", "getContentList", "prevData", "", "b", "", "a", "J", "loadMsgTime", "loadRoamMsgTime", "c", "processMsgTime", "d", "firstScreenTime", "<init>", "(JJJJ)V", "nt_trace_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class c implements com.tencent.qqnt.trace.perf.a<c> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private long loadMsgTime;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private long loadRoamMsgTime;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long processMsgTime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long firstScreenTime;

    public c() {
        this(0L, 0L, 0L, 0L, 15, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            return;
        }
        iPatchRedirector.redirect((short) 7, (Object) this);
    }

    @Override // com.tencent.qqnt.trace.perf.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(@NotNull c prevData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) prevData);
            return;
        }
        Intrinsics.checkNotNullParameter(prevData, "prevData");
        if (this.loadMsgTime == 0) {
            this.loadMsgTime = prevData.loadMsgTime;
        }
        if (this.loadRoamMsgTime == 0) {
            this.loadRoamMsgTime = prevData.loadRoamMsgTime;
        }
        if (this.processMsgTime == 0) {
            this.processMsgTime = prevData.processMsgTime;
        }
        if (this.firstScreenTime == 0) {
            this.firstScreenTime = prevData.firstScreenTime;
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
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"\u9996\u5c4f\u6d88\u606f\u52a0\u8f7d\uff1a" + this.loadMsgTime + " ms", "\u6f2b\u6e38\u6d88\u606f\u52a0\u8f7d\uff1a" + this.loadRoamMsgTime + " ms", "\u6d88\u606f\u5904\u7406\uff1a" + this.processMsgTime + " ms", "\u9996\u5c4f\u663e\u793a\u65f6\u95f4\uff1a" + this.firstScreenTime + " ms"});
        return listOf;
    }

    @Override // com.tencent.qqnt.trace.perf.a
    @NotNull
    public String getTitle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "AIO \u663e\u793a";
    }

    @Override // com.tencent.qqnt.trace.perf.a
    @NotNull
    public AIOPerfDataType getType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (AIOPerfDataType) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return AIOPerfDataType.AIO_LOAD_TIME;
    }

    public c(long j3, long j16, long j17, long j18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17), Long.valueOf(j18));
            return;
        }
        this.loadMsgTime = j3;
        this.loadRoamMsgTime = j16;
        this.processMsgTime = j17;
        this.firstScreenTime = j18;
    }

    public /* synthetic */ c(long j3, long j16, long j17, long j18, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0L : j3, (i3 & 2) != 0 ? 0L : j16, (i3 & 4) != 0 ? 0L : j17, (i3 & 8) != 0 ? 0L : j18);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17), Long.valueOf(j18), Integer.valueOf(i3), defaultConstructorMarker);
    }
}
