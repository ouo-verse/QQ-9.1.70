package com.tencent.qqnt.pluspanel.data.repository;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.pluspanel.data.appinfo.PlusPanelAppInfo;
import com.tencent.qqnt.pluspanel.data.loader.e;
import com.tencent.qqnt.pluspanel.data.loader.f;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\r\u0012\u0006\u0010\u0012\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0006\u0010\u0003\u001a\u00020\u0002J\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b2\u0006\u0010\u0005\u001a\u00020\u0004J\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nR\u0014\u0010\u000f\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqnt/pluspanel/data/repository/c;", "Lcom/tencent/qqnt/pluspanel/data/repository/b;", "", "c", "Landroid/content/Context;", "context", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/pluspanel/data/a;", "Lkotlin/collections/ArrayList;", "a", "", "Lcom/tencent/qqnt/pluspanel/data/appinfo/PlusPanelAppInfo;", "b", "", "Ljava/lang/String;", "id", "", "I", "type", "Lcom/tencent/qqnt/pluspanel/data/loader/e;", "Lcom/tencent/qqnt/pluspanel/data/loader/e;", "mLoader", "<init>", "(Ljava/lang/String;I)V", "plus_panel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class c extends b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int type;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private e mLoader;

    public c(@NotNull String id5, int i3) {
        Intrinsics.checkNotNullParameter(id5, "id");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) id5, i3);
        } else {
            this.id = id5;
            this.type = i3;
        }
    }

    @NotNull
    public final ArrayList<com.tencent.qqnt.pluspanel.data.a> a(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ArrayList) iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        e eVar = this.mLoader;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLoader");
            eVar = null;
        }
        eVar.e();
        ArrayList<com.tencent.qqnt.pluspanel.data.a> arrayList = new ArrayList<>();
        e eVar2 = this.mLoader;
        if (eVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLoader");
            eVar2 = null;
        }
        List<PlusPanelAppInfo> c16 = eVar2.c();
        int size = c16.size();
        for (int i3 = 0; i3 < size; i3++) {
            PlusPanelAppInfo plusPanelAppInfo = c16.get(i3);
            e eVar3 = this.mLoader;
            if (eVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLoader");
                eVar3 = null;
            }
            com.tencent.qqnt.pluspanel.data.a d16 = eVar3.d(plusPanelAppInfo, i3, context);
            if (d16 != null) {
                arrayList.add(d16);
            }
        }
        arrayList.isEmpty();
        a.f360445a.b(this.id, this.type, c16);
        return arrayList;
    }

    @NotNull
    public final List<PlusPanelAppInfo> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        e eVar = this.mLoader;
        if (eVar != null) {
            e eVar2 = null;
            if (eVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLoader");
                eVar = null;
            }
            eVar.e();
            e eVar3 = this.mLoader;
            if (eVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLoader");
            } else {
                eVar2 = eVar3;
            }
            List<PlusPanelAppInfo> c16 = eVar2.c();
            a.f360445a.b(this.id, this.type, c16);
            return c16;
        }
        return new ArrayList();
    }

    public final void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.mLoader = new f().a(this.id, this.type);
        }
    }
}
