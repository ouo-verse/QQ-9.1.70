package com.tencent.qqnt.ntrelation.friendsinfo.bean;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\u0005\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001Bo\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0002\u0012\b\b\u0002\u0010$\u001a\u00020\u001e\u0012\u0018\b\u0002\u0010,\u001a\u0012\u0012\u0004\u0012\u00020&0%j\b\u0012\u0004\u0012\u00020&`'\u0012\u0018\b\u0002\u0010.\u001a\u0012\u0012\u0004\u0012\u00020\u00040%j\b\u0012\u0004\u0012\u00020\u0004`'\u00a2\u0006\u0004\b/\u00100J\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0006\u001a\u00020\u0002H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\n\u001a\u0004\b\u0018\u0010\f\"\u0004\b\u0019\u0010\u000eR\"\u0010\u001d\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u001b\u0010\f\"\u0004\b\u001c\u0010\u000eR\"\u0010$\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R2\u0010,\u001a\u0012\u0012\u0004\u0012\u00020&0%j\b\u0012\u0004\u0012\u00020&`'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010(\u001a\u0004\b\u0010\u0010)\"\u0004\b*\u0010+R2\u0010.\u001a\u0012\u0012\u0004\u0012\u00020\u00040%j\b\u0012\u0004\u0012\u00020\u0004`'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010(\u001a\u0004\b\u0017\u0010)\"\u0004\b-\u0010+\u00a8\u00061"}, d2 = {"Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/b;", "", "", "a", "", "toString", "hashCode", "other", "", "equals", "I", "d", "()I", "j", "(I)V", "categoryId", "b", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "l", "(Ljava/lang/String;)V", "categoryName", "c", "e", "k", "categoryMbCount", "g", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "categoryOnlineMbCount", "", "B", h.F, "()B", DomainData.DOMAIN_NAME, "(B)V", "sortId", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/d;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "setBuddyList", "(Ljava/util/ArrayList;)V", "buddyList", "i", "buddyUidList", "<init>", "(ILjava/lang/String;IIBLjava/util/ArrayList;Ljava/util/ArrayList;)V", "contacts_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final /* data */ class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int categoryId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String categoryName;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int categoryMbCount;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int categoryOnlineMbCount;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private byte sortId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<d> buddyList;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<String> buddyUidList;

    public b() {
        this(0, null, 0, 0, (byte) 0, null, null, 127, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 28)) {
            return;
        }
        iPatchRedirector.redirect((short) 28, (Object) this);
    }

    public final int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        return this.categoryId;
    }

    @NotNull
    public final ArrayList<d> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (ArrayList) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.buddyList;
    }

    @NotNull
    public final ArrayList<String> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (ArrayList) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.buddyUidList;
    }

    public final int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.categoryId;
    }

    public final int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.categoryMbCount;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof b)) {
            return false;
        }
        b bVar = (b) other;
        if (this.categoryId == bVar.categoryId && Intrinsics.areEqual(this.categoryName, bVar.categoryName) && this.categoryMbCount == bVar.categoryMbCount && this.categoryOnlineMbCount == bVar.categoryOnlineMbCount && this.sortId == bVar.sortId && Intrinsics.areEqual(this.buddyList, bVar.buddyList) && Intrinsics.areEqual(this.buddyUidList, bVar.buddyUidList)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.categoryName;
    }

    public final int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.categoryOnlineMbCount;
    }

    public final byte h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Byte) iPatchRedirector.redirect((short) 11, (Object) this)).byteValue();
        }
        return this.sortId;
    }

    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Integer) iPatchRedirector.redirect((short) 26, (Object) this)).intValue();
        }
        int i3 = this.categoryId * 31;
        String str = this.categoryName;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return ((((((((((i3 + hashCode) * 31) + this.categoryMbCount) * 31) + this.categoryOnlineMbCount) * 31) + this.sortId) * 31) + this.buddyList.hashCode()) * 31) + this.buddyUidList.hashCode();
    }

    public final void i(@NotNull ArrayList<String> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) arrayList);
        } else {
            Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
            this.buddyUidList = arrayList;
        }
    }

    public final void j(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            this.categoryId = i3;
        }
    }

    public final void k(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        } else {
            this.categoryMbCount = i3;
        }
    }

    public final void l(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        } else {
            this.categoryName = str;
        }
    }

    public final void m(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
        } else {
            this.categoryOnlineMbCount = i3;
        }
    }

    public final void n(byte b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Byte.valueOf(b16));
        } else {
            this.sortId = b16;
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (String) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        int i3 = this.categoryId;
        String str = this.categoryName;
        int i16 = this.categoryMbCount;
        int i17 = this.categoryOnlineMbCount;
        byte b16 = this.sortId;
        return "NTCategoryInfo(categoryId=" + i3 + ", categoryName=" + str + ", categoryMbCount=" + i16 + ", categoryOnlineMbCount=" + i17 + ", sortId=" + ((int) b16) + ", buddyList=" + this.buddyList + ", buddyUidList=" + this.buddyUidList + ")";
    }

    public b(int i3, @Nullable String str, int i16, int i17, byte b16, @NotNull ArrayList<d> buddyList, @NotNull ArrayList<String> buddyUidList) {
        Intrinsics.checkNotNullParameter(buddyList, "buddyList");
        Intrinsics.checkNotNullParameter(buddyUidList, "buddyUidList");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), str, Integer.valueOf(i16), Integer.valueOf(i17), Byte.valueOf(b16), buddyList, buddyUidList);
            return;
        }
        this.categoryId = i3;
        this.categoryName = str;
        this.categoryMbCount = i16;
        this.categoryOnlineMbCount = i17;
        this.sortId = b16;
        this.buddyList = buddyList;
        this.buddyUidList = buddyUidList;
    }

    public /* synthetic */ b(int i3, String str, int i16, int i17, byte b16, ArrayList arrayList, ArrayList arrayList2, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this((i18 & 1) != 0 ? -1 : i3, (i18 & 2) != 0 ? "" : str, (i18 & 4) != 0 ? 0 : i16, (i18 & 8) != 0 ? 0 : i17, (i18 & 16) != 0 ? (byte) 0 : b16, (i18 & 32) != 0 ? new ArrayList() : arrayList, (i18 & 64) != 0 ? new ArrayList() : arrayList2);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, Integer.valueOf(i16), Integer.valueOf(i17), Byte.valueOf(b16), arrayList, arrayList2, Integer.valueOf(i18), defaultConstructorMarker);
    }
}
