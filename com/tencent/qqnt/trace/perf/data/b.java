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
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0000H\u0016R\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/trace/perf/data/b;", "Lcom/tencent/qqnt/trace/perf/a;", "Lcom/tencent/qqnt/trace/perf/AIOPerfDataType;", "getType", "", "getTitle", "", "getContentList", "prevData", "", "b", "", "a", "J", "showSnapshotTime", "showChatListTime", "<init>", "(JJ)V", "nt_trace_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class b implements com.tencent.qqnt.trace.perf.a<b> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private long showSnapshotTime;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private long showChatListTime;

    public b() {
        this(0L, 0L, 3, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            return;
        }
        iPatchRedirector.redirect((short) 7, (Object) this);
    }

    @Override // com.tencent.qqnt.trace.perf.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(@NotNull b prevData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) prevData);
            return;
        }
        Intrinsics.checkNotNullParameter(prevData, "prevData");
        if (this.showSnapshotTime == 0) {
            this.showSnapshotTime = prevData.showSnapshotTime;
        }
        if (this.showChatListTime == 0) {
            this.showChatListTime = prevData.showChatListTime;
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
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"\u5feb\u7167\u663e\u793a\u8017\u65f6\uff1a" + this.showSnapshotTime + " ms", "\u5217\u8868\u663e\u793a\u8017\u65f6\uff1a" + this.showChatListTime + " ms"});
        return listOf;
    }

    @Override // com.tencent.qqnt.trace.perf.a
    @NotNull
    public String getTitle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "\u6d88\u606f\u5217\u8868\u663e\u793a";
    }

    @Override // com.tencent.qqnt.trace.perf.a
    @NotNull
    public AIOPerfDataType getType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (AIOPerfDataType) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return AIOPerfDataType.CHAT_LIST_SHOW;
    }

    public b(long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Long.valueOf(j16));
        } else {
            this.showSnapshotTime = j3;
            this.showChatListTime = j16;
        }
    }

    public /* synthetic */ b(long j3, long j16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0L : j3, (i3 & 2) == 0 ? j16 : 0L);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3), defaultConstructorMarker);
    }
}
