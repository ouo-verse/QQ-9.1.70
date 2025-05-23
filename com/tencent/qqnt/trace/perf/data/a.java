package com.tencent.qqnt.trace.perf.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.trace.perf.AIOPerfDataType;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0000H\u0016R\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/trace/perf/data/a;", "Lcom/tencent/qqnt/trace/perf/a;", "Lcom/tencent/qqnt/trace/perf/AIOPerfDataType;", "getType", "", "getTitle", "", "getContentList", "prevData", "", "b", "", "a", "I", "refreshCount", "<init>", "()V", "nt_trace_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a implements com.tencent.qqnt.trace.perf.a<a> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int refreshCount;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.trace.perf.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(@NotNull a prevData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) prevData);
        } else {
            Intrinsics.checkNotNullParameter(prevData, "prevData");
            this.refreshCount = prevData.refreshCount + 1;
        }
    }

    @Override // com.tencent.qqnt.trace.perf.a
    @NotNull
    public List<String> getContentList() {
        List<String> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        listOf = CollectionsKt__CollectionsJVMKt.listOf("\u5237\u65b0\u6b21\u6570\uff1a " + this.refreshCount);
        return listOf;
    }

    @Override // com.tencent.qqnt.trace.perf.a
    @NotNull
    public String getTitle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "\u6d88\u606f\u5217\u8868\u5237\u65b0\u6b21\u6570\uff08\u5f53\u6b21\u524d\u53f0\uff09";
    }

    @Override // com.tencent.qqnt.trace.perf.a
    @NotNull
    public AIOPerfDataType getType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AIOPerfDataType) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return AIOPerfDataType.CHAT_LIST_REFRESH_COUNT;
    }
}
