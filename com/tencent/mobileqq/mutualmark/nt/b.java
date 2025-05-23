package com.tencent.mobileqq.mutualmark.nt;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B;\u0012\u001a\u0010\u0018\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\n0\tj\n\u0012\u0006\u0012\u0004\u0018\u00010\n`\u000b\u0012\u0016\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00190\tj\b\u0012\u0004\u0012\u00020\u0019`\u000b\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016R6\u0010\u0012\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\n0\tj\n\u0012\u0006\u0012\u0004\u0018\u00010\n`\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R2\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00130\tj\b\u0012\u0004\u0012\u00020\u0013`\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u0015\u0010\u000f\"\u0004\b\u0016\u0010\u0011\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/mutualmark/nt/b;", "", "other", "", "equals", "", "hashCode", "", "toString", "Ljava/util/ArrayList;", "Landroid/graphics/drawable/Drawable;", "Lkotlin/collections/ArrayList;", "a", "Ljava/util/ArrayList;", "getDisplayUnit", "()Ljava/util/ArrayList;", "setDisplayUnit", "(Ljava/util/ArrayList;)V", "displayUnit", "Lcom/tencent/mobileqq/mutualmark/nt/a;", "b", "getBaseInfo", "setBaseInfo", "baseInfo", "inputDrawableList", "Lcom/tencent/mobileqq/mutualmark/info/c;", "inputInfoList", "<init>", "(Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<Drawable> displayUnit;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<a> baseInfo;

    public b(@NotNull ArrayList<Drawable> inputDrawableList, @NotNull ArrayList<com.tencent.mobileqq.mutualmark.info.c> inputInfoList) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(inputDrawableList, "inputDrawableList");
        Intrinsics.checkNotNullParameter(inputInfoList, "inputInfoList");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) inputDrawableList, (Object) inputInfoList);
            return;
        }
        this.displayUnit = inputDrawableList;
        this.baseInfo = new ArrayList<>();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(inputInfoList, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (com.tencent.mobileqq.mutualmark.info.c cVar : inputInfoList) {
            arrayList.add(Boolean.valueOf(this.baseInfo.add(new a(cVar.f252085a, cVar.f252086b, cVar.f252093i))));
        }
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, other)).booleanValue();
        }
        if (!(other instanceof b)) {
            return false;
        }
        b bVar = (b) other;
        if (this.displayUnit.size() != bVar.displayUnit.size()) {
            return false;
        }
        Iterator<Drawable> it = this.displayUnit.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            int i16 = i3 + 1;
            Drawable next = it.next();
            Drawable drawable = bVar.displayUnit.get(i3);
            if (next == null || drawable == null || !Intrinsics.areEqual(next.getConstantState(), drawable.getConstantState())) {
                return false;
            }
            i3 = i16;
        }
        return true;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.displayUnit.hashCode();
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        String str = "drawable size " + this.displayUnit.size() + " ";
        Iterator<a> it = this.baseInfo.iterator();
        while (it.hasNext()) {
            str = str + " " + it.next();
        }
        return str;
    }
}
