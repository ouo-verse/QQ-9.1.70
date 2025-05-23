package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0015\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\r\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006\u0012\u0006\u0010!\u001a\u00020\u001c\u0012\u0006\u0010%\u001a\u00020\t\u0012\u0006\u0010&\u001a\u00020\t\u0012\u0006\u0010(\u001a\u00020\t\u00a2\u0006\u0004\b)\u0010*B\t\b\u0016\u00a2\u0006\u0004\b)\u0010+B#\b\u0016\u0012\u0018\u0010,\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\r\u00a2\u0006\u0004\b)\u0010-B;\b\u0016\u0012\u0018\u0010,\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\r\u0012\u0006\u0010.\u001a\u00020\t\u0012\u0006\u0010&\u001a\u00020\t\u0012\u0006\u0010/\u001a\u00020\t\u00a2\u0006\u0004\b)\u00100J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0007\u0010\bJ\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\u0013\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R)\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\r8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R(\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010!\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u001d\u001a\u0004\b\u0015\u0010\u001e\"\u0004\b\u001f\u0010 R\u0017\u0010%\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\"\u001a\u0004\b#\u0010$R\u0017\u0010&\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b#\u0010\"\u001a\u0004\b\u0010\u0010$R\u0017\u0010(\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b'\u0010\"\u001a\u0004\b'\u0010$\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/activity/ij;", "", "", "toString", "", "needSearchIcon", "", "d", "(Z)[Ljava/lang/String;", "", "hashCode", "other", "equals", "", "", "Lcom/tencent/mobileqq/troop/troopmemberlist/a;", "a", "Ljava/util/Map;", "g", "()Ljava/util/Map;", "sortedResultList", "b", "[Ljava/lang/String;", "c", "()[Ljava/lang/String;", "i", "([Ljava/lang/String;)V", "groupNameArray", "", "[I", "()[I", tl.h.F, "([I)V", "groupIndexArray", "I", "e", "()I", "normalMemberCount", "charSegmentCount", "f", "otherMemberCount", "<init>", "(Ljava/util/Map;[Ljava/lang/String;[IIII)V", "()V", "resultList", "(Ljava/util/Map;)V", "itemCount", "otherTypeItemCount", "(Ljava/util/Map;III)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final /* data */ class ij {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, List<com.tencent.mobileqq.troop.troopmemberlist.a>> sortedResultList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String[] groupNameArray;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private int[] groupIndexArray;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int normalMemberCount;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int charSegmentCount;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int otherMemberCount;

    public ij(@NotNull Map<String, List<com.tencent.mobileqq.troop.troopmemberlist.a>> sortedResultList, @NotNull String[] groupNameArray, @NotNull int[] groupIndexArray, int i3, int i16, int i17) {
        Intrinsics.checkNotNullParameter(sortedResultList, "sortedResultList");
        Intrinsics.checkNotNullParameter(groupNameArray, "groupNameArray");
        Intrinsics.checkNotNullParameter(groupIndexArray, "groupIndexArray");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, sortedResultList, groupNameArray, groupIndexArray, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        this.sortedResultList = sortedResultList;
        this.groupNameArray = groupNameArray;
        this.groupIndexArray = groupIndexArray;
        this.normalMemberCount = i3;
        this.charSegmentCount = i16;
        this.otherMemberCount = i17;
    }

    public final int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.charSegmentCount;
    }

    @NotNull
    public final int[] b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (int[]) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.groupIndexArray;
    }

    @NotNull
    public final String[] c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String[]) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.groupNameArray;
    }

    @NotNull
    public final String[] d(boolean needSearchIcon) {
        List mutableList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String[]) iPatchRedirector.redirect((short) 14, (Object) this, needSearchIcon);
        }
        String[] strArr = this.groupNameArray;
        ArrayList arrayList = new ArrayList();
        int length = strArr.length;
        int i3 = 0;
        while (true) {
            boolean z16 = true;
            if (i3 >= length) {
                break;
            }
            String str = strArr[i3];
            if (str.length() != 1 || (!Character.isLetter(str.charAt(0)) && !Intrinsics.areEqual(str, "#"))) {
                z16 = false;
            }
            if (z16) {
                arrayList.add(str);
            }
            i3++;
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        List list = mutableList;
        if ((!list.isEmpty()) && needSearchIcon) {
            mutableList.add(0, "$");
        }
        Object[] array = list.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (String[]) array;
    }

    public final int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.normalMemberCount;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof ij)) {
            return false;
        }
        ij ijVar = (ij) other;
        if (Intrinsics.areEqual(this.sortedResultList, ijVar.sortedResultList) && Intrinsics.areEqual(this.groupNameArray, ijVar.groupNameArray) && Intrinsics.areEqual(this.groupIndexArray, ijVar.groupIndexArray) && this.normalMemberCount == ijVar.normalMemberCount && this.charSegmentCount == ijVar.charSegmentCount && this.otherMemberCount == ijVar.otherMemberCount) {
            return true;
        }
        return false;
    }

    public final int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.otherMemberCount;
    }

    @NotNull
    public final Map<String, List<com.tencent.mobileqq.troop.troopmemberlist.a>> g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Map) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.sortedResultList;
    }

    public final void h(@NotNull int[] iArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) iArr);
        } else {
            Intrinsics.checkNotNullParameter(iArr, "<set-?>");
            this.groupIndexArray = iArr;
        }
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this)).intValue();
        }
        return (((((((((this.sortedResultList.hashCode() * 31) + Arrays.hashCode(this.groupNameArray)) * 31) + Arrays.hashCode(this.groupIndexArray)) * 31) + this.normalMemberCount) * 31) + this.charSegmentCount) * 31) + this.otherMemberCount;
    }

    public final void i(@NotNull String[] strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) strArr);
        } else {
            Intrinsics.checkNotNullParameter(strArr, "<set-?>");
            this.groupNameArray = strArr;
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        int size = this.sortedResultList.size();
        String arrays = Arrays.toString(this.groupNameArray);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
        String arrays2 = Arrays.toString(this.groupIndexArray);
        Intrinsics.checkNotNullExpressionValue(arrays2, "toString(this)");
        return "TroopMemberListSortResult(sortedResultList.size=" + size + ", groupNameArray=" + arrays + ", groupIndexArray=" + arrays2 + ", normalMemberCount=" + this.normalMemberCount + ", charSegmentCount=" + this.charSegmentCount + ", otherTypeItemCount=" + this.otherMemberCount + ")";
    }

    public ij() {
        this(new LinkedHashMap(), new String[0], new int[0], 0, 0, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            return;
        }
        iPatchRedirector.redirect((short) 10, (Object) this);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ij(@NotNull Map<String, List<com.tencent.mobileqq.troop.troopmemberlist.a>> resultList) {
        this(resultList, new String[0], new int[0], 0, 0, 0);
        Intrinsics.checkNotNullParameter(resultList, "resultList");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
            return;
        }
        iPatchRedirector.redirect((short) 11, (Object) this, (Object) resultList);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ij(@NotNull Map<String, List<com.tencent.mobileqq.troop.troopmemberlist.a>> resultList, int i3, int i16, int i17) {
        this(resultList, new String[0], new int[0], i3, i16, i17);
        Intrinsics.checkNotNullParameter(resultList, "resultList");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) {
            return;
        }
        iPatchRedirector.redirect((short) 12, this, resultList, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
    }
}
