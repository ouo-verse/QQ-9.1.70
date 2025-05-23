package lb3;

import com.tencent.mobileqq.wxmini.pb.UserGrowGuard$CommonExt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0015\u001a\u0004\b\n\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Llb3/i;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/wxmini/pb/UserGrowGuard$CommonExt;", "a", "Lcom/tencent/mobileqq/wxmini/pb/UserGrowGuard$CommonExt;", "b", "()Lcom/tencent/mobileqq/wxmini/pb/UserGrowGuard$CommonExt;", "lastExt", "I", "c", "()I", "nextDuration", "", "Llb3/h;", "Ljava/util/List;", "()Ljava/util/List;", "instructionList", "<init>", "(Lcom/tencent/mobileqq/wxmini/pb/UserGrowGuard$CommonExt;ILjava/util/List;)V", "wxmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: lb3.i, reason: from toString */
/* loaded from: classes38.dex */
public final /* data */ class JudgeTimingData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final UserGrowGuard$CommonExt lastExt;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int nextDuration;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<GuardInstruction> instructionList;

    public JudgeTimingData(UserGrowGuard$CommonExt lastExt, int i3, List<GuardInstruction> instructionList) {
        Intrinsics.checkNotNullParameter(lastExt, "lastExt");
        Intrinsics.checkNotNullParameter(instructionList, "instructionList");
        this.lastExt = lastExt;
        this.nextDuration = i3;
        this.instructionList = instructionList;
    }

    public final List<GuardInstruction> a() {
        return this.instructionList;
    }

    /* renamed from: b, reason: from getter */
    public final UserGrowGuard$CommonExt getLastExt() {
        return this.lastExt;
    }

    /* renamed from: c, reason: from getter */
    public final int getNextDuration() {
        return this.nextDuration;
    }

    public int hashCode() {
        return (((this.lastExt.hashCode() * 31) + this.nextDuration) * 31) + this.instructionList.hashCode();
    }

    public String toString() {
        return "JudgeTimingData(lastExt=" + this.lastExt + ", nextDuration=" + this.nextDuration + ", instructionList=" + this.instructionList + ')';
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof JudgeTimingData)) {
            return false;
        }
        JudgeTimingData judgeTimingData = (JudgeTimingData) other;
        return Intrinsics.areEqual(this.lastExt, judgeTimingData.lastExt) && this.nextDuration == judgeTimingData.nextDuration && Intrinsics.areEqual(this.instructionList, judgeTimingData.instructionList);
    }
}
