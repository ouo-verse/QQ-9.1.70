package az1;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\n\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u00a2\u0006\u0004\b)\u0010*J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016JO\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\n2\b\b\u0002\u0010\u0012\u001a\u00020\u000eH\u00c6\u0001J\t\u0010\u0014\u001a\u00020\nH\u00d6\u0001J\t\u0010\u0015\u001a\u00020\u0002H\u00d6\u0001J\u0013\u0010\u0018\u001a\u00020\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u00d6\u0003R\u0017\u0010\u000b\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010\r\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u001a\u001a\u0004\b!\u0010\u001cR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0017\u0010\u0010\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u001e\u001a\u0004\b&\u0010 R\u0017\u0010\u0011\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b'\u0010\u001cR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b&\u0010#\u001a\u0004\b(\u0010%\u00a8\u0006+"}, d2 = {"Laz1/c;", "Laz1/a;", "", "j", "", "getItemId", "Laz1/d;", "newItem", "", "f", "", "groupName", "groupCode", "signature", "", "isBanned", "groupMemberSize", "onlineMemberSize", "isGroupMember", "d", "toString", "hashCode", "", "other", "equals", "b", "Ljava/lang/String;", "i", "()Ljava/lang/String;", "c", "J", "g", "()J", "l", "e", "Z", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Z", h.F, "k", DomainData.DOMAIN_NAME, "<init>", "(Ljava/lang/String;JLjava/lang/String;ZJLjava/lang/String;Z)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: az1.c, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class GroupChatShowData extends a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String groupName;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final long groupCode;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String signature;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isBanned;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final long groupMemberSize;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String onlineMemberSize;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isGroupMember;

    public GroupChatShowData(@NotNull String groupName, long j3, @NotNull String signature, boolean z16, long j16, @NotNull String onlineMemberSize, boolean z17) {
        Intrinsics.checkNotNullParameter(groupName, "groupName");
        Intrinsics.checkNotNullParameter(signature, "signature");
        Intrinsics.checkNotNullParameter(onlineMemberSize, "onlineMemberSize");
        this.groupName = groupName;
        this.groupCode = j3;
        this.signature = signature;
        this.isBanned = z16;
        this.groupMemberSize = j16;
        this.onlineMemberSize = onlineMemberSize;
        this.isGroupMember = z17;
    }

    public static /* synthetic */ GroupChatShowData e(GroupChatShowData groupChatShowData, String str, long j3, String str2, boolean z16, long j16, String str3, boolean z17, int i3, Object obj) {
        String str4;
        long j17;
        String str5;
        boolean z18;
        long j18;
        String str6;
        boolean z19;
        if ((i3 & 1) != 0) {
            str4 = groupChatShowData.groupName;
        } else {
            str4 = str;
        }
        if ((i3 & 2) != 0) {
            j17 = groupChatShowData.groupCode;
        } else {
            j17 = j3;
        }
        if ((i3 & 4) != 0) {
            str5 = groupChatShowData.signature;
        } else {
            str5 = str2;
        }
        if ((i3 & 8) != 0) {
            z18 = groupChatShowData.isBanned;
        } else {
            z18 = z16;
        }
        if ((i3 & 16) != 0) {
            j18 = groupChatShowData.groupMemberSize;
        } else {
            j18 = j16;
        }
        if ((i3 & 32) != 0) {
            str6 = groupChatShowData.onlineMemberSize;
        } else {
            str6 = str3;
        }
        if ((i3 & 64) != 0) {
            z19 = groupChatShowData.isGroupMember;
        } else {
            z19 = z17;
        }
        return groupChatShowData.d(str4, j17, str5, z18, j18, str6, z19);
    }

    @NotNull
    public final GroupChatShowData d(@NotNull String groupName, long groupCode, @NotNull String signature, boolean isBanned, long groupMemberSize, @NotNull String onlineMemberSize, boolean isGroupMember) {
        Intrinsics.checkNotNullParameter(groupName, "groupName");
        Intrinsics.checkNotNullParameter(signature, "signature");
        Intrinsics.checkNotNullParameter(onlineMemberSize, "onlineMemberSize");
        return new GroupChatShowData(groupName, groupCode, signature, isBanned, groupMemberSize, onlineMemberSize, isGroupMember);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GroupChatShowData)) {
            return false;
        }
        GroupChatShowData groupChatShowData = (GroupChatShowData) other;
        if (Intrinsics.areEqual(this.groupName, groupChatShowData.groupName) && this.groupCode == groupChatShowData.groupCode && Intrinsics.areEqual(this.signature, groupChatShowData.signature) && this.isBanned == groupChatShowData.isBanned && this.groupMemberSize == groupChatShowData.groupMemberSize && Intrinsics.areEqual(this.onlineMemberSize, groupChatShowData.onlineMemberSize) && this.isGroupMember == groupChatShowData.isGroupMember) {
            return true;
        }
        return false;
    }

    @Override // az1.a
    @NotNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public List<Integer> c(@NotNull d newItem) {
        List<Integer> emptyList;
        List<Integer> listOf;
        List<Integer> emptyList2;
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if (!(newItem instanceof GroupChatShowData)) {
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            return emptyList2;
        }
        GroupChatShowData groupChatShowData = (GroupChatShowData) newItem;
        if (Intrinsics.areEqual(groupChatShowData.signature, this.signature) || !Intrinsics.areEqual(e(this, null, 0L, null, false, 0L, null, false, 127, null), e(groupChatShowData, null, 0L, this.signature, false, 0L, null, false, 123, null))) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        listOf = CollectionsKt__CollectionsJVMKt.listOf(6);
        return listOf;
    }

    /* renamed from: g, reason: from getter */
    public final long getGroupCode() {
        return this.groupCode;
    }

    @Override // az1.d
    public long getItemId() {
        return Objects.hash(Integer.valueOf(j()));
    }

    /* renamed from: h, reason: from getter */
    public final long getGroupMemberSize() {
        return this.groupMemberSize;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((this.groupName.hashCode() * 31) + androidx.fragment.app.a.a(this.groupCode)) * 31) + this.signature.hashCode()) * 31;
        boolean z16 = this.isBanned;
        int i3 = 1;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int a16 = (((((hashCode + i16) * 31) + androidx.fragment.app.a.a(this.groupMemberSize)) * 31) + this.onlineMemberSize.hashCode()) * 31;
        boolean z17 = this.isGroupMember;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return a16 + i3;
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final String getGroupName() {
        return this.groupName;
    }

    public int j() {
        return 2;
    }

    @NotNull
    /* renamed from: k, reason: from getter */
    public final String getOnlineMemberSize() {
        return this.onlineMemberSize;
    }

    @NotNull
    /* renamed from: l, reason: from getter */
    public final String getSignature() {
        return this.signature;
    }

    /* renamed from: m, reason: from getter */
    public final boolean getIsBanned() {
        return this.isBanned;
    }

    /* renamed from: n, reason: from getter */
    public final boolean getIsGroupMember() {
        return this.isGroupMember;
    }

    @NotNull
    public String toString() {
        return "GroupChatShowData(groupName=" + this.groupName + ", groupCode=" + this.groupCode + ", signature=" + this.signature + ", isBanned=" + this.isBanned + ", groupMemberSize=" + this.groupMemberSize + ", onlineMemberSize=" + this.onlineMemberSize + ", isGroupMember=" + this.isGroupMember + ")";
    }
}
