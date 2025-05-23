package com.tencent.mobileqq.aio.input.at.common.list.data;

import com.tencent.mobileqq.aio.input.at.common.list.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0012\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0000\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0002H\u0000\u00a2\u0006\u0004\b\n\u0010\bJ\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0000H\u0016J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0000H\u0016J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u000b\u001a\u00020\u0000H\u0016J\b\u0010\u0011\u001a\u00020\u0000H&R\u001a\u0010\u0016\u001a\u00020\u00128\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0017\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/aio/input/at/common/list/data/b;", "", "", "d", "g", "isMultiSelectMode", "", "i", "(Z)V", "isSelected", h.F, "newItemData", "f", "e", "", "Lcom/tencent/mobileqq/aio/input/at/common/list/a;", "b", "a", "", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "mUid", "Z", "mIsMultiSelectMode", "mIsSelected", "<init>", "(Ljava/lang/String;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public abstract class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String mUid;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean mIsMultiSelectMode;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean mIsSelected;

    public b(@NotNull String mUid) {
        Intrinsics.checkNotNullParameter(mUid, "mUid");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mUid);
        } else {
            this.mUid = mUid;
        }
    }

    @NotNull
    public abstract b a();

    @NotNull
    public List<com.tencent.mobileqq.aio.input.at.common.list.a> b(@NotNull b newItemData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (List) iPatchRedirector.redirect((short) 9, (Object) this, (Object) newItemData);
        }
        Intrinsics.checkNotNullParameter(newItemData, "newItemData");
        ArrayList arrayList = new ArrayList();
        if (d() != newItemData.d()) {
            arrayList.add(new a.C7256a(newItemData.d()));
        }
        if (g() != newItemData.g()) {
            arrayList.add(new a.b(newItemData.g()));
        }
        return arrayList;
    }

    @NotNull
    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mUid;
    }

    public final boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.mIsMultiSelectMode;
    }

    public boolean e(@NotNull b newItemData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) newItemData)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(newItemData, "newItemData");
        if (this.mIsMultiSelectMode == newItemData.mIsMultiSelectMode && this.mIsSelected == newItemData.mIsSelected) {
            return true;
        }
        return false;
    }

    public boolean f(@NotNull b newItemData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) newItemData)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(newItemData, "newItemData");
        return Intrinsics.areEqual(c(), newItemData.c());
    }

    public final boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.mIsSelected;
    }

    public final void h(boolean isSelected) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, isSelected);
        } else {
            this.mIsSelected = isSelected;
        }
    }

    public final void i(boolean isMultiSelectMode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, isMultiSelectMode);
        } else {
            this.mIsMultiSelectMode = isMultiSelectMode;
        }
    }
}
