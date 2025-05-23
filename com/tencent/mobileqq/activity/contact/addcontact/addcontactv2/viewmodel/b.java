package com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.viewmodel;

import com.tencent.mobileqq.activity.contact.addcontact.addcontactv2.model.g;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001f\u0010 JA\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u0002H\u00c6\u0001J\t\u0010\r\u001a\u00020\tH\u00d6\u0001J\t\u0010\u000e\u001a\u00020\u0007H\u00d6\u0001J\u0013\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\n\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u000b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0011\u001a\u0004\b\u001e\u0010\u0013\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/viewmodel/b;", "", "", "isSuccess", "", "Lcom/tencent/mobileqq/activity/contact/addcontact/addcontactv2/model/g;", "contentList", "", "errCode", "", "errMsg", "needShowEmptyView", "a", "toString", "hashCode", "other", "equals", "Z", "g", "()Z", "b", "Ljava/util/List;", "c", "()Ljava/util/List;", "I", "d", "()I", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "f", "<init>", "(ZLjava/util/List;ILjava/lang/String;Z)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final /* data */ class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final boolean isSuccess;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<g> contentList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int errCode;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String errMsg;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean needShowEmptyView;

    public b(boolean z16, @NotNull List<g> contentList, int i3, @NotNull String errMsg, boolean z17) {
        Intrinsics.checkNotNullParameter(contentList, "contentList");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), contentList, Integer.valueOf(i3), errMsg, Boolean.valueOf(z17));
            return;
        }
        this.isSuccess = z16;
        this.contentList = contentList;
        this.errCode = i3;
        this.errMsg = errMsg;
        this.needShowEmptyView = z17;
    }

    public static /* synthetic */ b b(b bVar, boolean z16, List list, int i3, String str, boolean z17, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            z16 = bVar.isSuccess;
        }
        if ((i16 & 2) != 0) {
            list = bVar.contentList;
        }
        List list2 = list;
        if ((i16 & 4) != 0) {
            i3 = bVar.errCode;
        }
        int i17 = i3;
        if ((i16 & 8) != 0) {
            str = bVar.errMsg;
        }
        String str2 = str;
        if ((i16 & 16) != 0) {
            z17 = bVar.needShowEmptyView;
        }
        return bVar.a(z16, list2, i17, str2, z17);
    }

    @NotNull
    public final b a(boolean isSuccess, @NotNull List<g> contentList, int errCode, @NotNull String errMsg, boolean needShowEmptyView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (b) iPatchRedirector.redirect((short) 13, this, Boolean.valueOf(isSuccess), contentList, Integer.valueOf(errCode), errMsg, Boolean.valueOf(needShowEmptyView));
        }
        Intrinsics.checkNotNullParameter(contentList, "contentList");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        return new b(isSuccess, contentList, errCode, errMsg, needShowEmptyView);
    }

    @NotNull
    public final List<g> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.contentList;
    }

    public final int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.errCode;
    }

    @NotNull
    public final String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.errMsg;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof b)) {
            return false;
        }
        b bVar = (b) other;
        if (this.isSuccess == bVar.isSuccess && Intrinsics.areEqual(this.contentList, bVar.contentList) && this.errCode == bVar.errCode && Intrinsics.areEqual(this.errMsg, bVar.errMsg) && this.needShowEmptyView == bVar.needShowEmptyView) {
            return true;
        }
        return false;
    }

    public final boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.needShowEmptyView;
    }

    public final boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.isSuccess;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        boolean z16 = this.isSuccess;
        int i3 = 1;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int hashCode = ((((((r06 * 31) + this.contentList.hashCode()) * 31) + this.errCode) * 31) + this.errMsg.hashCode()) * 31;
        boolean z17 = this.needShowEmptyView;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return hashCode + i3;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return "AddContactUIState(isSuccess=" + this.isSuccess + ", contentList=" + this.contentList + ", errCode=" + this.errCode + ", errMsg=" + this.errMsg + ", needShowEmptyView=" + this.needShowEmptyView + ")";
    }

    public /* synthetic */ b(boolean z16, List list, int i3, String str, boolean z17, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(z16, list, (i16 & 4) != 0 ? 0 : i3, (i16 & 8) != 0 ? "" : str, (i16 & 16) != 0 ? true : z17);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), list, Integer.valueOf(i3), str, Boolean.valueOf(z17), Integer.valueOf(i16), defaultConstructorMarker);
    }
}
