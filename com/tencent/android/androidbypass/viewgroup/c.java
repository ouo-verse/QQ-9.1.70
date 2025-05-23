package com.tencent.android.androidbypass.viewgroup;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\"\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0011j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u0012\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u0017\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0007\u00a2\u0006\u0004\b \u0010!J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR3\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0011j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\t\u0010\u0015R\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0018\u001a\u0004\b\u000e\u0010\u0019R\"\u0010\u001f\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u001b\u001a\u0004\b\u0013\u0010\u001c\"\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/android/androidbypass/viewgroup/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "nodeType", "b", "d", "nodeId", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "c", "Ljava/util/HashMap;", "()Ljava/util/HashMap;", "attrMap", "", "Ljava/util/List;", "()Ljava/util/List;", "dataLinkList", "Z", "()Z", "f", "(Z)V", "end", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;Ljava/util/List;Z)V", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final /* data */ class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String nodeType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String nodeId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<String, String> attrMap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> dataLinkList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean end;

    public c(@NotNull String nodeType, @NotNull String nodeId, @NotNull HashMap<String, String> attrMap, @NotNull List<String> dataLinkList, boolean z16) {
        Intrinsics.checkNotNullParameter(nodeType, "nodeType");
        Intrinsics.checkNotNullParameter(nodeId, "nodeId");
        Intrinsics.checkNotNullParameter(attrMap, "attrMap");
        Intrinsics.checkNotNullParameter(dataLinkList, "dataLinkList");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, nodeType, nodeId, attrMap, dataLinkList, Boolean.valueOf(z16));
            return;
        }
        this.nodeType = nodeType;
        this.nodeId = nodeId;
        this.attrMap = attrMap;
        this.dataLinkList = dataLinkList;
        this.end = z16;
    }

    @NotNull
    public final HashMap<String, String> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (HashMap) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.attrMap;
    }

    @NotNull
    public final List<String> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.dataLinkList;
    }

    public final boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.end;
    }

    @NotNull
    public final String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.nodeId;
    }

    @NotNull
    public final String e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (String) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.nodeType;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, other)).booleanValue();
        }
        if (this != other) {
            if (other instanceof c) {
                c cVar = (c) other;
                if (!Intrinsics.areEqual(this.nodeType, cVar.nodeType) || !Intrinsics.areEqual(this.nodeId, cVar.nodeId) || !Intrinsics.areEqual(this.attrMap, cVar.attrMap) || !Intrinsics.areEqual(this.dataLinkList, cVar.dataLinkList) || this.end != cVar.end) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public final void f(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        } else {
            this.end = z16;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3;
        int i16;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        String str = this.nodeType;
        int i18 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i19 = i3 * 31;
        String str2 = this.nodeId;
        if (str2 != null) {
            i16 = str2.hashCode();
        } else {
            i16 = 0;
        }
        int i26 = (i19 + i16) * 31;
        HashMap<String, String> hashMap = this.attrMap;
        if (hashMap != null) {
            i17 = hashMap.hashCode();
        } else {
            i17 = 0;
        }
        int i27 = (i26 + i17) * 31;
        List<String> list = this.dataLinkList;
        if (list != null) {
            i18 = list.hashCode();
        }
        int i28 = (i27 + i18) * 31;
        boolean z16 = this.end;
        int i29 = z16;
        if (z16 != 0) {
            i29 = 1;
        }
        return i28 + i29;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return "ExtData(nodeType=" + this.nodeType + ", nodeId=" + this.nodeId + ", attrMap=" + this.attrMap + ", dataLinkList=" + this.dataLinkList + ", end=" + this.end + ")";
    }

    public /* synthetic */ c(String str, String str2, HashMap hashMap, List list, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, hashMap, list, (i3 & 16) != 0 ? false : z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            return;
        }
        iPatchRedirector.redirect((short) 8, this, str, str2, hashMap, list, Boolean.valueOf(z16), Integer.valueOf(i3), defaultConstructorMarker);
    }
}
