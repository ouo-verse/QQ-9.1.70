package com.tencent.storage.view.rtv;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__ReversedViewsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.StringsKt___StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u001c\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ.\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J*\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00042\u0012\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00070\u0007J0\u0010\u0016\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0007\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0004J*\u0010\u0019\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0007\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\fH\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/storage/view/rtv/a;", "", "T", "", "", "start", "end", "", "d", "", "progress", "columnIndex", "", "columns", "Lcom/tencent/storage/view/rtv/b;", "c", "", "sourceText", "targetText", "index", "Lkotlin/Pair;", "Lcom/tencent/storage/view/rtv/Direction;", "b", "sourceChar", "targetChar", "a", "<init>", "()V", "storage-view-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/storage/view/rtv/a$a;", "", "Lcom/tencent/storage/view/rtv/a;", "a", "<init>", "()V", "storage-view-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.storage.view.rtv.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes26.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/storage/view/rtv/a$a$a", "Lcom/tencent/storage/view/rtv/a;", "", "sourceChar", "targetChar", "Lkotlin/Pair;", "", "Lcom/tencent/storage/view/rtv/Direction;", "a", "storage-view-kit_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.storage.view.rtv.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes26.dex */
        public static final class C9869a extends a {
            static IPatchRedirector $redirector_;

            C9869a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // com.tencent.storage.view.rtv.a
            @NotNull
            public Pair<List<Character>, Direction> a(char sourceChar, char targetChar) {
                List listOf;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    listOf = CollectionsKt__CollectionsJVMKt.listOf(Character.valueOf(targetChar));
                    return TuplesKt.to(listOf, Direction.SCROLL_DOWN);
                }
                return (Pair) iPatchRedirector.redirect((short) 2, this, Character.valueOf(sourceChar), Character.valueOf(targetChar));
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final a a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (a) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return new C9869a();
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35560);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final <T> List<T> d(Iterable<? extends T> iterable, int i3, int i16) {
        boolean z16;
        ArrayList arrayList = new ArrayList();
        int i17 = 0;
        for (T t16 : iterable) {
            int i18 = i17 + 1;
            if (i17 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            if (i3 <= i17 && i17 <= i16) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList.add(t16);
            }
            i17 = i18;
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0060 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[LOOP:0: B:12:0x0041->B:33:?, LOOP_END, SYNTHETIC] */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Pair<List<Character>, Direction> a(char sourceChar, char targetChar) {
        Object obj;
        Iterable asIterable;
        int indexOf;
        int indexOf2;
        List asReversed;
        List listOf;
        boolean contains$default;
        boolean z16;
        boolean contains$default2;
        List listOf2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Pair) iPatchRedirector.redirect((short) 4, this, Character.valueOf(sourceChar), Character.valueOf(targetChar));
        }
        if (sourceChar == targetChar) {
            listOf2 = CollectionsKt__CollectionsJVMKt.listOf(Character.valueOf(targetChar));
            return TuplesKt.to(listOf2, Direction.SCROLL_DOWN);
        }
        Iterator<T> it = com.tencent.storage.view.a.f373651a.b().iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            String str = (String) next;
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, sourceChar, false, 2, (Object) null);
            if (contains$default) {
                contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) str, targetChar, false, 2, (Object) null);
                if (contains$default2) {
                    z16 = true;
                    if (!z16) {
                        obj = next;
                        break;
                    }
                }
            }
            z16 = false;
            if (!z16) {
            }
        }
        String str2 = (String) obj;
        if (str2 == null) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(Character.valueOf(targetChar));
            return TuplesKt.to(listOf, Direction.SCROLL_DOWN);
        }
        asIterable = StringsKt___StringsKt.asIterable(str2);
        indexOf = CollectionsKt___CollectionsKt.indexOf((Iterable<? extends Character>) ((Iterable<? extends Object>) asIterable), Character.valueOf(sourceChar));
        indexOf2 = CollectionsKt___CollectionsKt.indexOf((Iterable<? extends Character>) ((Iterable<? extends Object>) asIterable), Character.valueOf(targetChar));
        if (indexOf >= indexOf2) {
            asReversed = CollectionsKt__ReversedViewsKt.asReversed(d(asIterable, indexOf2, indexOf));
            return TuplesKt.to(asReversed, Direction.SCROLL_UP);
        }
        return TuplesKt.to(d(asIterable, indexOf, indexOf2), Direction.SCROLL_DOWN);
    }

    @NotNull
    public final Pair<List<Character>, Direction> b(@NotNull CharSequence sourceText, @NotNull CharSequence targetText, int index) {
        char c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        char c17 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Pair) iPatchRedirector.redirect((short) 3, this, sourceText, targetText, Integer.valueOf(index));
        }
        Intrinsics.checkNotNullParameter(sourceText, "sourceText");
        Intrinsics.checkNotNullParameter(targetText, "targetText");
        int max = Math.max(sourceText.length(), targetText.length());
        int length = max - sourceText.length();
        int length2 = max - targetText.length();
        if (index >= length) {
            c16 = sourceText.charAt(index - length);
        } else {
            c16 = 0;
        }
        if (index >= length2) {
            c17 = targetText.charAt(index - length2);
        }
        return a(c16, c17);
    }

    @NotNull
    public final b c(double progress, int columnIndex, @NotNull List<? extends List<Character>> columns) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (b) iPatchRedirector.redirect((short) 2, this, Double.valueOf(progress), Integer.valueOf(columnIndex), columns);
        }
        Intrinsics.checkNotNullParameter(columns, "columns");
        double size = (columns.get(columnIndex).size() - 1) * progress;
        int i3 = (int) size;
        return new b(i3, size - i3, progress);
    }
}
