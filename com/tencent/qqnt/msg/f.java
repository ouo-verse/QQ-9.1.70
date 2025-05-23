package com.tencent.qqnt.msg;

import com.tencent.mobileqq.injector.q;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.ab;
import com.tencent.qqnt.kernel.api.ac;
import com.tencent.qqnt.kernel.api.ag;
import com.tencent.qqnt.kernel.api.s;
import com.tencent.qqnt.kernel.api.t;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.api.y;
import com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001a\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000\u001a\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u001a\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u001a\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u001a\b\u0010\t\u001a\u0004\u0018\u00010\b\u001a\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u001a\b\u0010\r\u001a\u0004\u0018\u00010\f\u001a\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u001a\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u001a\b\u0010\u0012\u001a\u0004\u0018\u00010\b\u001a\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u001a\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\"6\u0010\u001e\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00180\u0017j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0018`\u001a8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u0016\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0017\u0010\"\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u001f\u001a\u0004\b \u0010!\u00a8\u0006#"}, d2 = {"Lcom/tencent/qqnt/kernel/api/IKernelService;", "i", "Lcom/tencent/qqnt/kernel/api/w;", "e", "Lcom/tencent/qqnt/kernel/api/t;", "d", "Lcom/tencent/qqnt/kernel/api/ab;", "g", "Lcom/tencent/qqnt/kernel/api/ag;", "l", "Lcom/tencent/qqnt/kernel/nativeinterface/IQQNTWrapperSession;", "k", "Lcom/tencent/qqnt/kernel/api/s;", "c", "Lcom/tencent/qqnt/kernel/api/m;", "b", "Lcom/tencent/qqnt/kernel/api/y;", "f", "j", "Lcom/tencent/qqnt/kernel/api/ac;", tl.h.F, "Lcom/tencent/qqnt/kernel/api/i;", "a", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lcom/tencent/qqnt/msg/api/a;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "getSKernelServiceProviderList", "()Ljava/util/ArrayList;", "sKernelServiceProviderList", "Lcom/tencent/qqnt/msg/api/a;", "getSKernelServiceProvider", "()Lcom/tencent/qqnt/msg/api/a;", "sKernelServiceProvider", "msg_api_release"}, k = 2, mv = {1, 7, 1})
@JvmName(name = "KernelServiceUtil")
/* loaded from: classes24.dex */
public final class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Service/Msg/Inject_KernelServiceProvider.yml", version = 1)
    @NotNull
    private static final ArrayList<Class<com.tencent.qqnt.msg.api.a>> f359636a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final com.tencent.qqnt.msg.api.a f359637b;

    static {
        int collectionSizeOrDefault;
        Object first;
        Object first2;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37872);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        ArrayList<Class<com.tencent.qqnt.msg.api.a>> arrayList = new ArrayList<>();
        f359636a = arrayList;
        arrayList.add(q.class);
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            Constructor<?>[] constructors = ((Class) it.next()).getConstructors();
            Intrinsics.checkNotNullExpressionValue(constructors, "it.constructors");
            first2 = ArraysKt___ArraysKt.first(constructors);
            Object newInstance = ((Constructor) first2).newInstance(new Object[0]);
            Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type com.tencent.qqnt.msg.api.IKernelServiceProvider");
            arrayList2.add((com.tencent.qqnt.msg.api.a) newInstance);
        }
        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList2);
        f359637b = (com.tencent.qqnt.msg.api.a) first;
    }

    @Nullable
    public static final com.tencent.qqnt.kernel.api.i a() {
        IKernelService i3 = i();
        if (i3 != null) {
            return i3.getBaseEmojiService();
        }
        return null;
    }

    @Nullable
    public static final com.tencent.qqnt.kernel.api.m b() {
        IKernelService i3 = i();
        if (i3 != null) {
            return i3.getBuddyService();
        }
        return null;
    }

    @Nullable
    public static final s c() {
        IKernelService i3 = i();
        if (i3 != null) {
            return i3.getGroupService();
        }
        return null;
    }

    @Nullable
    public static final t d() {
        IKernelService i3 = i();
        if (i3 != null) {
            return i3.getGuildMsgService();
        }
        return null;
    }

    @Nullable
    public static final w e() {
        IKernelService i3 = i();
        if (i3 != null) {
            return i3.getMsgService();
        }
        return null;
    }

    @Nullable
    public static final y f() {
        IKernelService i3 = i();
        if (i3 != null) {
            return i3.getProfileService();
        }
        return null;
    }

    @Nullable
    public static final ab g() {
        IKernelService i3 = i();
        if (i3 != null) {
            return i3.getRichMediaService();
        }
        return null;
    }

    @Nullable
    public static final ac h() {
        IKernelService i3 = i();
        if (i3 != null) {
            return i3.getRobotService();
        }
        return null;
    }

    @Nullable
    public static final IKernelService i() {
        return f359637b.a();
    }

    @Nullable
    public static final ag j() {
        IKernelService i3 = i();
        if (i3 != null) {
            return i3.getUixConvertService();
        }
        return null;
    }

    @Nullable
    public static final IQQNTWrapperSession k() {
        IKernelService i3 = i();
        if (i3 != null) {
            return i3.getWrapperSession();
        }
        return null;
    }

    @Nullable
    public static final ag l() {
        IKernelService i3 = i();
        if (i3 != null) {
            return i3.getUixConvertService();
        }
        return null;
    }
}
