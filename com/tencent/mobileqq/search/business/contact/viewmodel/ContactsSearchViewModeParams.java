package com.tencent.mobileqq.search.business.contact.viewmodel;

import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.startup.step.InitSkin;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vaswebviewplugin.VasWebReport;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010#\n\u0002\b\b\n\u0002\u0010\"\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B\u00a3\u0001\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0004\u0012\b\b\u0002\u0010#\u001a\u00020\u001d\u0012\u000e\b\u0002\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00020$\u0012\u000e\b\u0002\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00020$\u0012\u000e\b\u0002\u00100\u001a\b\u0012\u0004\u0012\u00020\u00020-\u0012\b\b\u0002\u00106\u001a\u00020\u0002\u0012\u0010\b\u0002\u0010<\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u000107\u0012\b\b\u0002\u0010?\u001a\u00020\u0007\u0012\b\b\u0002\u0010A\u001a\u00020\u0004\u0012\b\b\u0002\u0010C\u001a\u00020\u0007\u00a2\u0006\u0004\bD\u0010EJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0013\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\"\u0010\u0016\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0014\u0010\f\"\u0004\b\u0015\u0010\u000eR\"\u0010\u001c\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010#\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001e\u0010 \"\u0004\b!\u0010\"R\u001d\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00020$8\u0006\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001d\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00020$8\u0006\u00a2\u0006\f\n\u0004\b*\u0010&\u001a\u0004\b+\u0010(R(\u00100\u001a\b\u0012\u0004\u0012\u00020\u00020-8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010&\u001a\u0004\b*\u0010(\"\u0004\b.\u0010/R\"\u00106\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b1\u00103\"\u0004\b4\u00105R*\u0010<\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u00108\u001a\u0004\b\u0010\u00109\"\u0004\b:\u0010;R\"\u0010?\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b=\u0010\n\u001a\u0004\b\t\u0010\f\"\u0004\b>\u0010\u000eR\"\u0010A\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0017\u001a\u0004\b%\u0010\u0019\"\u0004\b@\u0010\u001bR\"\u0010C\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\n\u001a\u0004\b=\u0010\f\"\u0004\bB\u0010\u000e\u00a8\u0006F"}, d2 = {"Lcom/tencent/mobileqq/search/business/contact/viewmodel/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "d", "()Z", "r", "(Z)V", "filterRobot", "b", "c", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "filterGroupRobot", "l", "w", "isMultiSelect", "I", "getCombineType", "()I", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(I)V", "combineType", "", "e", "J", "()J", ReportConstant.COSTREPORT_PREFIX, "(J)V", VasWebReport.WEB_CORE_DATA_FLAGS, "", "f", "Ljava/util/Set;", "j", "()Ljava/util/Set;", "selectedUinSet", "g", h.F, "joinedUinSet", "", "u", "(Ljava/util/Set;)V", "hiddenUinSet", "i", "Ljava/lang/String;", "()Ljava/lang/String;", "v", "(Ljava/lang/String;)V", "masterGroupUin", "", "Ljava/util/List;", "()Ljava/util/List;", "p", "(Ljava/util/List;)V", "filterGroupList", "k", "o", "filterBlockGroup", "t", IProfileCardConst.KEY_FROM_TYPE, DomainData.DOMAIN_NAME, "isDefaultSingleMode", "<init>", "(ZZZIJLjava/util/Set;Ljava/util/Set;Ljava/util/Set;Ljava/lang/String;Ljava/util/List;ZIZ)V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.search.business.contact.viewmodel.a, reason: from toString */
/* loaded from: classes18.dex */
public final /* data */ class ContactsSearchViewModeParams {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean filterRobot;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean filterGroupRobot;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isMultiSelect;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private int combineType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private long filterType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final Set<String> selectedUinSet;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final Set<String> joinedUinSet;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private Set<String> hiddenUinSet;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String masterGroupUin;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private List<String> filterGroupList;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean filterBlockGroup;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    private int fromType;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isDefaultSingleMode;

    public ContactsSearchViewModeParams() {
        this(false, false, false, 0, 0L, null, null, null, null, null, false, 0, false, InitSkin.DRAWABLE_COUNT, null);
    }

    /* renamed from: a, reason: from getter */
    public final boolean getFilterBlockGroup() {
        return this.filterBlockGroup;
    }

    @Nullable
    public final List<String> b() {
        return this.filterGroupList;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getFilterGroupRobot() {
        return this.filterGroupRobot;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getFilterRobot() {
        return this.filterRobot;
    }

    /* renamed from: e, reason: from getter */
    public final long getFilterType() {
        return this.filterType;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ContactsSearchViewModeParams)) {
            return false;
        }
        ContactsSearchViewModeParams contactsSearchViewModeParams = (ContactsSearchViewModeParams) other;
        if (this.filterRobot == contactsSearchViewModeParams.filterRobot && this.filterGroupRobot == contactsSearchViewModeParams.filterGroupRobot && this.isMultiSelect == contactsSearchViewModeParams.isMultiSelect && this.combineType == contactsSearchViewModeParams.combineType && this.filterType == contactsSearchViewModeParams.filterType && Intrinsics.areEqual(this.selectedUinSet, contactsSearchViewModeParams.selectedUinSet) && Intrinsics.areEqual(this.joinedUinSet, contactsSearchViewModeParams.joinedUinSet) && Intrinsics.areEqual(this.hiddenUinSet, contactsSearchViewModeParams.hiddenUinSet) && Intrinsics.areEqual(this.masterGroupUin, contactsSearchViewModeParams.masterGroupUin) && Intrinsics.areEqual(this.filterGroupList, contactsSearchViewModeParams.filterGroupList) && this.filterBlockGroup == contactsSearchViewModeParams.filterBlockGroup && this.fromType == contactsSearchViewModeParams.fromType && this.isDefaultSingleMode == contactsSearchViewModeParams.isDefaultSingleMode) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final int getFromType() {
        return this.fromType;
    }

    @NotNull
    public final Set<String> g() {
        return this.hiddenUinSet;
    }

    @NotNull
    public final Set<String> h() {
        return this.joinedUinSet;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v18, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v2, types: [boolean] */
    public int hashCode() {
        int hashCode;
        boolean z16 = this.filterRobot;
        int i3 = 1;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i16 = r06 * 31;
        ?? r26 = this.filterGroupRobot;
        int i17 = r26;
        if (r26 != 0) {
            i17 = 1;
        }
        int i18 = (i16 + i17) * 31;
        ?? r27 = this.isMultiSelect;
        int i19 = r27;
        if (r27 != 0) {
            i19 = 1;
        }
        int a16 = (((((((((((((i18 + i19) * 31) + this.combineType) * 31) + androidx.fragment.app.a.a(this.filterType)) * 31) + this.selectedUinSet.hashCode()) * 31) + this.joinedUinSet.hashCode()) * 31) + this.hiddenUinSet.hashCode()) * 31) + this.masterGroupUin.hashCode()) * 31;
        List<String> list = this.filterGroupList;
        if (list == null) {
            hashCode = 0;
        } else {
            hashCode = list.hashCode();
        }
        int i26 = (a16 + hashCode) * 31;
        ?? r28 = this.filterBlockGroup;
        int i27 = r28;
        if (r28 != 0) {
            i27 = 1;
        }
        int i28 = (((i26 + i27) * 31) + this.fromType) * 31;
        boolean z17 = this.isDefaultSingleMode;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return i28 + i3;
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final String getMasterGroupUin() {
        return this.masterGroupUin;
    }

    @NotNull
    public final Set<String> j() {
        return this.selectedUinSet;
    }

    /* renamed from: k, reason: from getter */
    public final boolean getIsDefaultSingleMode() {
        return this.isDefaultSingleMode;
    }

    /* renamed from: l, reason: from getter */
    public final boolean getIsMultiSelect() {
        return this.isMultiSelect;
    }

    public final void m(int i3) {
        this.combineType = i3;
    }

    public final void n(boolean z16) {
        this.isDefaultSingleMode = z16;
    }

    public final void o(boolean z16) {
        this.filterBlockGroup = z16;
    }

    public final void p(@Nullable List<String> list) {
        this.filterGroupList = list;
    }

    public final void q(boolean z16) {
        this.filterGroupRobot = z16;
    }

    public final void r(boolean z16) {
        this.filterRobot = z16;
    }

    public final void s(long j3) {
        this.filterType = j3;
    }

    public final void t(int i3) {
        this.fromType = i3;
    }

    @NotNull
    public String toString() {
        return "ContactsSearchViewModeParams(filterRobot=" + this.filterRobot + ", filterGroupRobot=" + this.filterGroupRobot + ", isMultiSelect=" + this.isMultiSelect + ", combineType=" + this.combineType + ", filterType=" + this.filterType + ", selectedUinSet=" + this.selectedUinSet + ", joinedUinSet=" + this.joinedUinSet + ", hiddenUinSet=" + this.hiddenUinSet + ", masterGroupUin=" + this.masterGroupUin + ", filterGroupList=" + this.filterGroupList + ", filterBlockGroup=" + this.filterBlockGroup + ", fromType=" + this.fromType + ", isDefaultSingleMode=" + this.isDefaultSingleMode + ")";
    }

    public final void u(@NotNull Set<String> set) {
        Intrinsics.checkNotNullParameter(set, "<set-?>");
        this.hiddenUinSet = set;
    }

    public final void v(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.masterGroupUin = str;
    }

    public final void w(boolean z16) {
        this.isMultiSelect = z16;
    }

    public ContactsSearchViewModeParams(boolean z16, boolean z17, boolean z18, int i3, long j3, @NotNull Set<String> selectedUinSet, @NotNull Set<String> joinedUinSet, @NotNull Set<String> hiddenUinSet, @NotNull String masterGroupUin, @Nullable List<String> list, boolean z19, int i16, boolean z26) {
        Intrinsics.checkNotNullParameter(selectedUinSet, "selectedUinSet");
        Intrinsics.checkNotNullParameter(joinedUinSet, "joinedUinSet");
        Intrinsics.checkNotNullParameter(hiddenUinSet, "hiddenUinSet");
        Intrinsics.checkNotNullParameter(masterGroupUin, "masterGroupUin");
        this.filterRobot = z16;
        this.filterGroupRobot = z17;
        this.isMultiSelect = z18;
        this.combineType = i3;
        this.filterType = j3;
        this.selectedUinSet = selectedUinSet;
        this.joinedUinSet = joinedUinSet;
        this.hiddenUinSet = hiddenUinSet;
        this.masterGroupUin = masterGroupUin;
        this.filterGroupList = list;
        this.filterBlockGroup = z19;
        this.fromType = i16;
        this.isDefaultSingleMode = z26;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ ContactsSearchViewModeParams(boolean z16, boolean z17, boolean z18, int i3, long j3, Set set, Set set2, Set set3, String str, List list, boolean z19, int i16, boolean z26, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1, r3, r4, r5, r6, r8, r10, (i17 & 128) != 0 ? SetsKt__SetsKt.emptySet() : set3, (i17 & 256) != 0 ? "" : str, (i17 & 512) != 0 ? null : list, (i17 & 1024) != 0 ? false : z19, (i17 & 2048) != 0 ? -1 : i16, (i17 & 4096) == 0 ? z26 : false);
        Set set4;
        Set set5;
        boolean z27 = (i17 & 1) != 0 ? false : z16;
        boolean z28 = (i17 & 2) != 0 ? false : z17;
        boolean z29 = (i17 & 4) != 0 ? true : z18;
        int i18 = (i17 & 8) != 0 ? 0 : i3;
        long j16 = (i17 & 16) != 0 ? -1L : j3;
        if ((i17 & 32) != 0) {
            set4 = Collections.synchronizedSet(new HashSet());
            Intrinsics.checkNotNullExpressionValue(set4, "synchronizedSet(HashSet())");
        } else {
            set4 = set;
        }
        if ((i17 & 64) != 0) {
            set5 = Collections.synchronizedSet(new HashSet());
            Intrinsics.checkNotNullExpressionValue(set5, "synchronizedSet(HashSet())");
        } else {
            set5 = set2;
        }
    }
}
