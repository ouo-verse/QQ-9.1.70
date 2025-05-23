package com.tencent.android.androidbypass.viewgroup;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\t\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\t8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0010\u0010\r\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/android/androidbypass/viewgroup/e;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "Lcom/tencent/android/androidbypass/viewgroup/b;", "a", "Ljava/util/List;", "()Ljava/util/List;", "elementGroupList", "Lcom/tencent/android/androidbypass/viewgroup/c;", "b", "extDataList", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "bypass_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final /* data */ class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<b> elementGroupList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<c> extDataList;

    /* JADX WARN: Multi-variable type inference failed */
    public e(@NotNull List<? extends b> elementGroupList, @NotNull List<c> extDataList) {
        Intrinsics.checkNotNullParameter(elementGroupList, "elementGroupList");
        Intrinsics.checkNotNullParameter(extDataList, "extDataList");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) elementGroupList, (Object) extDataList);
        } else {
            this.elementGroupList = elementGroupList;
            this.extDataList = extDataList;
        }
    }

    @NotNull
    public final List<b> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (List) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.elementGroupList;
    }

    @NotNull
    public final List<c> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.extDataList;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, other)).booleanValue();
        }
        if (this != other) {
            if (other instanceof e) {
                e eVar = (e) other;
                if (!Intrinsics.areEqual(this.elementGroupList, eVar.elementGroupList) || !Intrinsics.areEqual(this.extDataList, eVar.extDataList)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        List<b> list = this.elementGroupList;
        int i16 = 0;
        if (list != null) {
            i3 = list.hashCode();
        } else {
            i3 = 0;
        }
        int i17 = i3 * 31;
        List<c> list2 = this.extDataList;
        if (list2 != null) {
            i16 = list2.hashCode();
        }
        return i17 + i16;
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return "ParseResult(elementGroupList=" + this.elementGroupList + ", extDataList=" + this.extDataList + ")";
    }
}
