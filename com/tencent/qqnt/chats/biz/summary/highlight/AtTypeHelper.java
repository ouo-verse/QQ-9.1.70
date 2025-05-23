package com.tencent.qqnt.chats.biz.summary.highlight;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010$\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J&\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0002J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0002J\u000e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0002R!\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R!\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013R!\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0018\u0010\u0013R!\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R'\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0011\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/qqnt/chats/biz/summary/highlight/AtTypeHelper;", "", "", "id", "", "d", "", "newSeq", "newType", "oldSeq", "oldType", "", h.F, "type", "b", "g", "", "Lkotlin/Lazy;", "e", "()Ljava/util/List;", "typeToPriorityMap", "c", "getRealTimeNotificationMap", "realTimeNotificationMap", "getNormalNotificationMap", "normalNotificationMap", "newGroupNotificationMap", "", "f", "()Ljava/util/Map;", "typeToStrMap", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class AtTypeHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final AtTypeHelper f354392a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy typeToPriorityMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy realTimeNotificationMap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy normalNotificationMap;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy newGroupNotificationMap;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy typeToStrMap;

    static {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Lazy lazy5;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44246);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        f354392a = new AtTypeHelper();
        lazy = LazyKt__LazyJVMKt.lazy(AtTypeHelper$typeToPriorityMap$2.INSTANCE);
        typeToPriorityMap = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(AtTypeHelper$realTimeNotificationMap$2.INSTANCE);
        realTimeNotificationMap = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(AtTypeHelper$normalNotificationMap$2.INSTANCE);
        normalNotificationMap = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(AtTypeHelper$newGroupNotificationMap$2.INSTANCE);
        newGroupNotificationMap = lazy4;
        lazy5 = LazyKt__LazyJVMKt.lazy(AtTypeHelper$typeToStrMap$2.INSTANCE);
        typeToStrMap = lazy5;
    }

    AtTypeHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final List<Integer> c() {
        return (List) newGroupNotificationMap.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String d(int id5) {
        String string = MobileQQ.sMobileQQ.getResources().getString(id5);
        Intrinsics.checkNotNullExpressionValue(string, "sMobileQQ.resources.getString(id)");
        return string;
    }

    private final List<Integer> e() {
        return (List) typeToPriorityMap.getValue();
    }

    private final Map<Integer, String> f() {
        return (Map) typeToStrMap.getValue();
    }

    @NotNull
    public final String b(int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, type);
        }
        String str = f().get(Integer.valueOf(type));
        if (str == null) {
            return "";
        }
        return str;
    }

    public final boolean g(int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, type)).booleanValue();
        }
        if (c().contains(Integer.valueOf(type))) {
            return true;
        }
        return false;
    }

    public final boolean h(long newSeq, int newType, long oldSeq, int oldType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, Long.valueOf(newSeq), Integer.valueOf(newType), Long.valueOf(oldSeq), Integer.valueOf(oldType))).booleanValue();
        }
        if (newSeq > oldSeq) {
            return true;
        }
        if (oldSeq != newSeq || oldType == newType || e().indexOf(Integer.valueOf(newType)) <= e().indexOf(Integer.valueOf(oldType))) {
            return false;
        }
        return true;
    }
}
