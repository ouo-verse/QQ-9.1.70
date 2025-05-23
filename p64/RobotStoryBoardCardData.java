package p64;

import com.tencent.android.androidbypass.richui.viewdata.k;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.qqnt.kernel.nativeinterface.HalfViewCardNode;
import com.tencent.qqnt.kernel.nativeinterface.StoryBaseInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0013\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0001H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0001H\u0016J\t\u0010\t\u001a\u00020\bH\u00d6\u0001J\t\u0010\u000b\u001a\u00020\nH\u00d6\u0001R\u0017\u0010\u0011\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0017\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lp64/b;", "Lp64/a;", "", "other", "", "equals", "b", "a", "", "toString", "", "hashCode", "Lcom/tencent/qqnt/kernel/nativeinterface/HalfViewCardNode;", "c", "Lcom/tencent/qqnt/kernel/nativeinterface/HalfViewCardNode;", "e", "()Lcom/tencent/qqnt/kernel/nativeinterface/HalfViewCardNode;", IndividuationUrlHelper.UrlId.CARD_HOME, "Lcom/tencent/android/androidbypass/richui/viewdata/k;", "d", "Lcom/tencent/android/androidbypass/richui/viewdata/k;", "f", "()Lcom/tencent/android/androidbypass/richui/viewdata/k;", "viewNode", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/HalfViewCardNode;Lcom/tencent/android/androidbypass/richui/viewdata/k;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: p64.b, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class RobotStoryBoardCardData extends a {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final HalfViewCardNode card;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final k viewNode;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotStoryBoardCardData(@NotNull HalfViewCardNode card, @NotNull k viewNode) {
        super("RobotStoryBoardCardData", false, 2, null);
        Intrinsics.checkNotNullParameter(card, "card");
        Intrinsics.checkNotNullParameter(viewNode, "viewNode");
        this.card = card;
        this.viewNode = viewNode;
    }

    @Override // p64.a
    public boolean a(@NotNull a other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (!(other instanceof RobotStoryBoardCardData)) {
            return false;
        }
        return q64.a.a(this.card, ((RobotStoryBoardCardData) other).card);
    }

    @Override // p64.a
    public boolean b(@NotNull a other) {
        Long l3;
        StoryBaseInfo storyBaseInfo;
        StoryBaseInfo storyBaseInfo2;
        Intrinsics.checkNotNullParameter(other, "other");
        if (!(other instanceof RobotStoryBoardCardData)) {
            return false;
        }
        HalfViewCardNode halfViewCardNode = this.card;
        Long l16 = null;
        if (halfViewCardNode != null && (storyBaseInfo2 = halfViewCardNode.storyBaseInfo) != null) {
            l3 = Long.valueOf(storyBaseInfo2.storyId);
        } else {
            l3 = null;
        }
        HalfViewCardNode halfViewCardNode2 = ((RobotStoryBoardCardData) other).card;
        if (halfViewCardNode2 != null && (storyBaseInfo = halfViewCardNode2.storyBaseInfo) != null) {
            l16 = Long.valueOf(storyBaseInfo.storyId);
        }
        return Intrinsics.areEqual(l3, l16);
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final HalfViewCardNode getCard() {
        return this.card;
    }

    @Override // p64.a
    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RobotStoryBoardCardData) || !super.equals(other)) {
            return false;
        }
        RobotStoryBoardCardData robotStoryBoardCardData = (RobotStoryBoardCardData) other;
        if (Intrinsics.areEqual(this.viewNode, robotStoryBoardCardData.viewNode) && Intrinsics.areEqual(this.card, robotStoryBoardCardData.card) && q64.a.a(this.card, robotStoryBoardCardData.card)) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final k getViewNode() {
        return this.viewNode;
    }

    public int hashCode() {
        return (this.card.hashCode() * 31) + this.viewNode.hashCode();
    }

    @NotNull
    public String toString() {
        return "RobotStoryBoardCardData(card=" + this.card + ", viewNode=" + this.viewNode + ")";
    }
}
