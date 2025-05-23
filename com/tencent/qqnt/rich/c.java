package com.tencent.qqnt.rich;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\"\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00100\u000fj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0010`\u0011\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR3\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00100\u000fj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0010`\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqnt/rich/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "Lcom/tencent/android/androidbypass/viewgroup/b;", "a", "Ljava/util/List;", "()Ljava/util/List;", "elementGroupList", "Ljava/util/HashMap;", "Lcom/tencent/qqnt/markdown/data/b;", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "()Ljava/util/HashMap;", "extData", "<init>", "(Ljava/util/List;Ljava/util/HashMap;)V", "rich_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final /* data */ class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<com.tencent.android.androidbypass.viewgroup.b> elementGroupList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<String, com.tencent.qqnt.markdown.data.b> extData;

    /* JADX WARN: Multi-variable type inference failed */
    public c(@NotNull List<? extends com.tencent.android.androidbypass.viewgroup.b> elementGroupList, @NotNull HashMap<String, com.tencent.qqnt.markdown.data.b> extData) {
        Intrinsics.checkNotNullParameter(elementGroupList, "elementGroupList");
        Intrinsics.checkNotNullParameter(extData, "extData");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) elementGroupList, (Object) extData);
        } else {
            this.elementGroupList = elementGroupList;
            this.extData = extData;
        }
    }

    @NotNull
    public final List<com.tencent.android.androidbypass.viewgroup.b> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.elementGroupList;
    }

    @NotNull
    public final HashMap<String, com.tencent.qqnt.markdown.data.b> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (HashMap) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.extData;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof c)) {
            return false;
        }
        c cVar = (c) other;
        if (Intrinsics.areEqual(this.elementGroupList, cVar.elementGroupList) && Intrinsics.areEqual(this.extData, cVar.extData)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return (this.elementGroupList.hashCode() * 31) + this.extData.hashCode();
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return "DataInfo(elementGroupList=" + this.elementGroupList + ", extData=" + this.extData + ')';
    }
}
