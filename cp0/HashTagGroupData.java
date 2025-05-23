package cp0;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u0012\u0006\u0010\u001c\u001a\u00020\u000b\u0012\u0016\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u001dj\b\u0012\u0004\u0012\u00020\u0001`\u001e\u0012\b\b\u0002\u0010(\u001a\u00020\u0010\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0004\b-\u0010.J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0006\u0010\n\u001a\u00020\u0000J\t\u0010\f\u001a\u00020\u000bH\u00d6\u0001J\t\u0010\r\u001a\u00020\u0002H\u00d6\u0001J\u0013\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u00d6\u0003R\u0017\u0010\u0017\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001c\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR'\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u001dj\b\u0012\u0004\u0012\u00020\u0001`\u001e8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u001f\u001a\u0004\b \u0010!R\"\u0010(\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R$\u0010,\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0019\u001a\u0004\b)\u0010\u001b\"\u0004\b*\u0010+\u00a8\u0006/"}, d2 = {"Lcp0/f;", "Lcp0/a;", "", tl.h.F, "", "getItemId", "Lcp0/k;", "newItem", "", "f", "d", "", "toString", "hashCode", "", "other", "", "equals", "Lcp0/g;", "b", "Lcp0/g;", "j", "()Lcp0/g;", "type", "c", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "groupName", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "e", "()Ljava/util/ArrayList;", "allChildList", "Z", "k", "()Z", "l", "(Z)V", "isCollapse", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Ljava/lang/String;)V", "subGroupName", "<init>", "(Lcp0/g;Ljava/lang/String;Ljava/util/ArrayList;ZLjava/lang/String;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: cp0.f, reason: from toString */
/* loaded from: classes6.dex */
public final /* data */ class HashTagGroupData extends a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final HashTagGroupType type;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String groupName;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final ArrayList<a> allChildList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isCollapse;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String subGroupName;

    public /* synthetic */ HashTagGroupData(HashTagGroupType hashTagGroupType, String str, ArrayList arrayList, boolean z16, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(hashTagGroupType, str, arrayList, (i3 & 8) != 0 ? false : z16, (i3 & 16) != 0 ? null : str2);
    }

    @NotNull
    public final HashTagGroupData d() {
        return new HashTagGroupData(this.type, this.groupName, this.allChildList, this.isCollapse, this.subGroupName);
    }

    @NotNull
    public final ArrayList<a> e() {
        return this.allChildList;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HashTagGroupData)) {
            return false;
        }
        HashTagGroupData hashTagGroupData = (HashTagGroupData) other;
        if (Intrinsics.areEqual(this.type, hashTagGroupData.type) && Intrinsics.areEqual(this.groupName, hashTagGroupData.groupName) && Intrinsics.areEqual(this.allChildList, hashTagGroupData.allChildList) && this.isCollapse == hashTagGroupData.isCollapse && Intrinsics.areEqual(this.subGroupName, hashTagGroupData.subGroupName)) {
            return true;
        }
        return false;
    }

    @Override // cp0.a
    @NotNull
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public List<Integer> c(@NotNull k newItem) {
        List<Integer> emptyList;
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if (!(newItem instanceof HashTagGroupData)) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        ArrayList arrayList = new ArrayList();
        boolean z16 = this.isCollapse;
        boolean z17 = ((HashTagGroupData) newItem).isCollapse;
        if (z16 != z17) {
            if (z17) {
                arrayList.add(3);
            } else {
                arrayList.add(2);
            }
        }
        return arrayList;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getGroupName() {
        return this.groupName;
    }

    @Override // cp0.k
    public long getItemId() {
        return Objects.hash(Integer.valueOf(h()), this.type, this.groupName);
    }

    public int h() {
        return 3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2 = ((((this.type.hashCode() * 31) + this.groupName.hashCode()) * 31) + this.allChildList.hashCode()) * 31;
        boolean z16 = this.isCollapse;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (hashCode2 + i3) * 31;
        String str = this.subGroupName;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return i16 + hashCode;
    }

    @Nullable
    /* renamed from: i, reason: from getter */
    public final String getSubGroupName() {
        return this.subGroupName;
    }

    @NotNull
    /* renamed from: j, reason: from getter */
    public final HashTagGroupType getType() {
        return this.type;
    }

    /* renamed from: k, reason: from getter */
    public final boolean getIsCollapse() {
        return this.isCollapse;
    }

    public final void l(boolean z16) {
        this.isCollapse = z16;
    }

    public final void m(@Nullable String str) {
        this.subGroupName = str;
    }

    @NotNull
    public String toString() {
        return "HashTagGroupData(type=" + this.type + ", groupName=" + this.groupName + ", allChildList=" + this.allChildList + ", isCollapse=" + this.isCollapse + ", subGroupName=" + this.subGroupName + ")";
    }

    public HashTagGroupData(@NotNull HashTagGroupType type, @NotNull String groupName, @NotNull ArrayList<a> allChildList, boolean z16, @Nullable String str) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(groupName, "groupName");
        Intrinsics.checkNotNullParameter(allChildList, "allChildList");
        this.type = type;
        this.groupName = groupName;
        this.allChildList = allChildList;
        this.isCollapse = z16;
        this.subGroupName = str;
    }
}
