package com.tencent.imcore.message.facade.unread.filter;

import android.util.SparseArray;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u001c\b\u0002\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000e\u0012 \b\u0002\u0010\u001b\u001a\u001a\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00160\fj\b\u0012\u0004\u0012\u00020\u0016`\u000e\u0018\u00010\u0015\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR6\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u000f\u0010\u0013R:\u0010\u001b\u001a\u001a\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00160\fj\b\u0012\u0004\u0012\u00020\u0016`\u000e\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u0005\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/imcore/message/facade/unread/filter/w;", "", "", "toString", "", "a", "Z", "getToggle", "()Z", "c", "(Z)V", "toggle", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "b", "Ljava/util/ArrayList;", "getNeedFilterUinTypes", "()Ljava/util/ArrayList;", "(Ljava/util/ArrayList;)V", "needFilterUinTypes", "Landroid/util/SparseArray;", "Lcom/tencent/imcore/message/facade/unread/filter/c;", "Landroid/util/SparseArray;", "getNeedFilterConvs", "()Landroid/util/SparseArray;", "(Landroid/util/SparseArray;)V", "needFilterConvs", "<init>", "(ZLjava/util/ArrayList;Landroid/util/SparseArray;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class w {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean toggle;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ArrayList<Integer> needFilterUinTypes;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private SparseArray<ArrayList<c>> needFilterConvs;

    public w(boolean z16, @Nullable ArrayList<Integer> arrayList, @Nullable SparseArray<ArrayList<c>> sparseArray) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), arrayList, sparseArray);
            return;
        }
        this.toggle = z16;
        this.needFilterUinTypes = arrayList;
        this.needFilterConvs = sparseArray;
    }

    public final void a(@Nullable SparseArray<ArrayList<c>> sparseArray) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) sparseArray);
        } else {
            this.needFilterConvs = sparseArray;
        }
    }

    public final void b(@Nullable ArrayList<Integer> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) arrayList);
        } else {
            this.needFilterUinTypes = arrayList;
        }
    }

    public final void c(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            this.toggle = z16;
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return "UnreadFilterConfig(toggle=" + this.toggle + ", needFilterUinTypes=" + this.needFilterUinTypes + ", needFilterConvs=" + this.needFilterConvs + ")";
    }

    public /* synthetic */ w(boolean z16, ArrayList arrayList, SparseArray sparseArray, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(z16, (i3 & 2) != 0 ? null : arrayList, (i3 & 4) == 0 ? sparseArray : null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), arrayList, sparseArray, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
