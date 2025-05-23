package com.tencent.qqnt.graytips.util;

import android.view.View;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u0014J \u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0018\u0010\n\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004R<\u0010\u0015\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f`\u000e8\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0017\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qqnt/graytips/util/d;", "", "Landroid/view/View;", "view", "", "busiId", "", "text", "", "c", "e", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lcom/tencent/qqnt/graytips/util/i;", "Lkotlin/collections/ArrayList;", "b", "Ljava/util/ArrayList;", "getReportProviderClass", "()Ljava/util/ArrayList;", "getReportProviderClass$annotations", "()V", "reportProviderClass", "", "Ljava/util/List;", "reportProviderList", "<init>", "graytips_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f356912a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/AIO/tips/gray_tips_inject_config.yml", version = 1)
    @NotNull
    private static final ArrayList<Class<i>> reportProviderClass;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<i> reportProviderList;

    static {
        int collectionSizeOrDefault;
        Object first;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31754);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        f356912a = new d();
        ArrayList<Class<i>> arrayList = new ArrayList<>();
        reportProviderClass = arrayList;
        arrayList.add(com.tencent.mobileqq.troop.essencemsg.graytip.c.class);
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            Constructor<?>[] constructors = ((Class) it.next()).getConstructors();
            Intrinsics.checkNotNullExpressionValue(constructors, "it.constructors");
            first = ArraysKt___ArraysKt.first(constructors);
            Object newInstance = ((Constructor) first).newInstance(new Object[0]);
            Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type com.tencent.qqnt.graytips.util.IGrayTipReportProcessor");
            arrayList2.add((i) newInstance);
        }
        reportProviderList = arrayList2;
    }

    d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(View view, long j3, String text) {
        Intrinsics.checkNotNullParameter(text, "$text");
        Iterator<T> it = reportProviderList.iterator();
        while (it.hasNext()) {
            ((i) it.next()).a(view, j3, text);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(View view, long j3) {
        Iterator<T> it = reportProviderList.iterator();
        while (it.hasNext()) {
            ((i) it.next()).b(view, j3);
        }
    }

    public final void c(@Nullable final View view, final long busiId, @NotNull final String text) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, view, Long.valueOf(busiId), text);
        } else {
            Intrinsics.checkNotNullParameter(text, "text");
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.graytips.util.c
                @Override // java.lang.Runnable
                public final void run() {
                    d.d(view, busiId, text);
                }
            }, 16, null, false);
        }
    }

    public final void e(@Nullable final View view, final long busiId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, view, Long.valueOf(busiId));
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.graytips.util.b
                @Override // java.lang.Runnable
                public final void run() {
                    d.f(view, busiId);
                }
            }, 16, null, false);
        }
    }
}
