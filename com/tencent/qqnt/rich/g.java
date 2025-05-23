package com.tencent.qqnt.rich;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001BG\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000f\u0012\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\b\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0016\u00a2\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0003\u0010\u0012R\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u0017\u0010\u0019\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0017\u001a\u0004\b\n\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/qqnt/rich/g;", "", "Lcom/tencent/android/androidbypass/e;", "a", "Lcom/tencent/android/androidbypass/e;", "d", "()Lcom/tencent/android/androidbypass/e;", "imageClickListener", "", "Lcom/tencent/android/androidbypass/parser/api/b;", "b", "Ljava/util/List;", "e", "()Ljava/util/List;", "schemeClickListeners", "Lst/a;", "c", "Lst/a;", "()Lst/a;", "codeBlockStyleCallback", "Lut/a;", "hiddenLinkRenderList", "Ltt/a;", "Ltt/a;", "()Ltt/a;", "hiddenLinkClickListener", "<init>", "(Lcom/tencent/android/androidbypass/e;Ljava/util/List;Lst/a;Ljava/util/List;Ltt/a;)V", "rich_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final com.tencent.android.androidbypass.e imageClickListener;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<com.tencent.android.androidbypass.parser.api.b> schemeClickListeners;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final st.a codeBlockStyleCallback;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<ut.a> hiddenLinkRenderList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final tt.a hiddenLinkClickListener;

    public g() {
        this(null, null, null, null, null, 31, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            return;
        }
        iPatchRedirector.redirect((short) 8, (Object) this);
    }

    @NotNull
    public final st.a a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (st.a) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.codeBlockStyleCallback;
    }

    @NotNull
    public final tt.a b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (tt.a) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.hiddenLinkClickListener;
    }

    @NotNull
    public final List<ut.a> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.hiddenLinkRenderList;
    }

    @Nullable
    public final com.tencent.android.androidbypass.e d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.android.androidbypass.e) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.imageClickListener;
    }

    @NotNull
    public final List<com.tencent.android.androidbypass.parser.api.b> e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.schemeClickListeners;
    }

    public g(@Nullable com.tencent.android.androidbypass.e eVar, @NotNull List<? extends com.tencent.android.androidbypass.parser.api.b> schemeClickListeners, @NotNull st.a codeBlockStyleCallback, @NotNull List<? extends ut.a> hiddenLinkRenderList, @NotNull tt.a hiddenLinkClickListener) {
        Intrinsics.checkNotNullParameter(schemeClickListeners, "schemeClickListeners");
        Intrinsics.checkNotNullParameter(codeBlockStyleCallback, "codeBlockStyleCallback");
        Intrinsics.checkNotNullParameter(hiddenLinkRenderList, "hiddenLinkRenderList");
        Intrinsics.checkNotNullParameter(hiddenLinkClickListener, "hiddenLinkClickListener");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, eVar, schemeClickListeners, codeBlockStyleCallback, hiddenLinkRenderList, hiddenLinkClickListener);
            return;
        }
        this.imageClickListener = eVar;
        this.schemeClickListeners = schemeClickListeners;
        this.codeBlockStyleCallback = codeBlockStyleCallback;
        this.hiddenLinkRenderList = hiddenLinkRenderList;
        this.hiddenLinkClickListener = hiddenLinkClickListener;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ g(com.tencent.android.androidbypass.e eVar, List list, st.a aVar, List list2, tt.a aVar2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(r2, r3, r4, r5, (i3 & 16) != 0 ? new com.tencent.qqnt.markdown.click.a() : aVar2);
        List list3;
        List list4;
        List emptyList;
        List listOf;
        com.tencent.android.androidbypass.e eVar2 = (i3 & 1) != 0 ? null : eVar;
        if ((i3 & 2) != 0) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.android.androidbypass.parser.api.b[]{new com.tencent.qqnt.markdown.click.c(), new com.tencent.qqnt.markdown.click.d()});
            list3 = listOf;
        } else {
            list3 = list;
        }
        st.a gVar = (i3 & 4) != 0 ? new com.tencent.qqnt.markdown.codeblock.g() : aVar;
        if ((i3 & 8) != 0) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            list4 = emptyList;
        } else {
            list4 = list2;
        }
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, eVar, list, aVar, list2, aVar2, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
