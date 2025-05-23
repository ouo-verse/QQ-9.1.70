package com.tencent.qqnt.ntrelation.friendsinfo.bean;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u0005\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\"\u001a\u00020\u001c\u00a2\u0006\u0004\b#\u0010$J\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0006\u001a\u00020\u0002H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\n\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR\"\u0010\"\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/a;", "", "", "a", "", "toString", "hashCode", "other", "", "equals", "I", "b", "()I", "e", "(I)V", "categoryId", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "f", "(Ljava/lang/String;)V", "categoryName", "c", "setCategoryMbCount", "categoryMbCount", "getCategoryOnlineMbCount", "setCategoryOnlineMbCount", "categoryOnlineMbCount", "", "B", "getSortId", "()B", "setSortId", "(B)V", "sortId", "<init>", "(ILjava/lang/String;IIB)V", "contacts_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final /* data */ class a {
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

    public a() {
        this(0, null, 0, 0, (byte) 0, 31, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 22)) {
            return;
        }
        iPatchRedirector.redirect((short) 22, (Object) this);
    }

    public final int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return this.categoryId;
    }

    public final int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.categoryId;
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.categoryMbCount;
    }

    @Nullable
    public final String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.categoryName;
    }

    public final void e(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            this.categoryId = i3;
        }
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof a)) {
            return false;
        }
        a aVar = (a) other;
        if (this.categoryId == aVar.categoryId && Intrinsics.areEqual(this.categoryName, aVar.categoryName) && this.categoryMbCount == aVar.categoryMbCount && this.categoryOnlineMbCount == aVar.categoryOnlineMbCount && this.sortId == aVar.sortId) {
            return true;
        }
        return false;
    }

    public final void f(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        } else {
            this.categoryName = str;
        }
    }

    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        int i3 = this.categoryId * 31;
        String str = this.categoryName;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return ((((((i3 + hashCode) * 31) + this.categoryMbCount) * 31) + this.categoryOnlineMbCount) * 31) + this.sortId;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (String) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return "NTCategoryBaseInfo(categoryId=" + this.categoryId + ", categoryName=" + this.categoryName + ", categoryMbCount=" + this.categoryMbCount + ", categoryOnlineMbCount=" + this.categoryOnlineMbCount + ", sortId=" + ((int) this.sortId) + ")";
    }

    public a(int i3, @Nullable String str, int i16, int i17, byte b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), str, Integer.valueOf(i16), Integer.valueOf(i17), Byte.valueOf(b16));
            return;
        }
        this.categoryId = i3;
        this.categoryName = str;
        this.categoryMbCount = i16;
        this.categoryOnlineMbCount = i17;
        this.sortId = b16;
    }

    public /* synthetic */ a(int i3, String str, int i16, int i17, byte b16, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this((i18 & 1) != 0 ? -1 : i3, (i18 & 2) != 0 ? "" : str, (i18 & 4) != 0 ? 0 : i16, (i18 & 8) != 0 ? 0 : i17, (i18 & 16) != 0 ? (byte) 0 : b16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, Integer.valueOf(i16), Integer.valueOf(i17), Byte.valueOf(b16), Integer.valueOf(i18), defaultConstructorMarker);
    }
}
