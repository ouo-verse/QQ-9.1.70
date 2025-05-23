package com.tencent.qqnt.chats.main.vm.datasource.filter;

import com.dataline.nt.c;
import com.tencent.mobileqq.activity.recent.gamemsgbox.m;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IKernelRecentContactService;
import com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactModuleShieldInfo;
import com.tencent.qqnt.msg.f;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b \u0010\u0014J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007J\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\tR<\u0010\u0015\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\fj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r`\u000e8\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u001b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u000f\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001d\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0017\u001a\u0004\b\u0016\u0010\u0018\"\u0004\b\u001c\u0010\u001aR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u001e\u00a8\u0006!"}, d2 = {"Lcom/tencent/qqnt/chats/main/vm/datasource/filter/ChatsFilterUtil;", "", "", "Lcom/tencent/qqnt/chats/main/vm/datasource/filter/b;", "d", "Llw3/a;", "a", "", "mode", "", h.F, "e", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "b", "Ljava/util/ArrayList;", "getChatsNtFilterClass", "()Ljava/util/ArrayList;", "getChatsNtFilterClass$annotations", "()V", "chatsNtFilterClass", "c", "I", "()I", "f", "(I)V", "currentMode", "g", "currentModeFilterSize", "Ljava/util/List;", "chatsNtFilterList", "<init>", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class ChatsFilterUtil {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ChatsFilterUtil f355413a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Chats/Inject_ChatFilter.yml", version = 1)
    @NotNull
    private static final ArrayList<Class<lw3.a>> chatsNtFilterClass;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static int currentMode;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static int currentModeFilterSize;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<lw3.a> chatsNtFilterList;

    static {
        int collectionSizeOrDefault;
        Object first;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46169);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
            return;
        }
        f355413a = new ChatsFilterUtil();
        ArrayList<Class<lw3.a>> arrayList = new ArrayList<>();
        chatsNtFilterClass = arrayList;
        arrayList.add(com.tencent.qqnt.chats.filter.a.class);
        arrayList.add(c.class);
        arrayList.add(m.class);
        currentMode = -1;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            Constructor<?>[] constructors = ((Class) it.next()).getConstructors();
            Intrinsics.checkNotNullExpressionValue(constructors, "it.constructors");
            first = ArraysKt___ArraysKt.first(constructors);
            Object newInstance = ((Constructor) first).newInstance(new Object[0]);
            Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type com.tencent.qqnt.chats.core.filter.IChatsNtFilter");
            arrayList2.add((lw3.a) newInstance);
        }
        chatsNtFilterList = arrayList2;
    }

    ChatsFilterUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final List<lw3.a> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (List) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return chatsNtFilterList;
    }

    public final int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return currentMode;
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return currentModeFilterSize;
    }

    @Deprecated(message = "\u5e9f\u5f03", replaceWith = @ReplaceWith(expression = "\u901a\u77e5NT\u8de8\u5e73\u53f0\u7684\u4fee\u6539\uff0c\u6216\u8005\u8d70IChatsNtFilter\u5b9e\u73b0", imports = {}))
    @NotNull
    public final List<b> d() {
        List<b> emptyList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return (List) iPatchRedirector.redirect((short) 6, (Object) this);
    }

    public final void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            currentMode = -1;
            currentModeFilterSize = 0;
        }
    }

    public final void f(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            currentMode = i3;
        }
    }

    public final void g(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            currentModeFilterSize = i3;
        }
    }

    public final void h(final int mode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, mode);
            return;
        }
        if (QLog.isDebugVersion()) {
            QLog.d("ChatsFilterUtil", 1, "[triggerChatsNtFilter] start call!");
        }
        com.tencent.qqnt.chats.utils.h.f355549a.e("triggerChatsNtFilter", true, new Function0<Unit>(mode) { // from class: com.tencent.qqnt.chats.main.vm.datasource.filter.ChatsFilterUtil$triggerChatsNtFilter$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ int $mode;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$mode = mode;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, mode);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IKernelRecentContactService recentContactService;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                ArrayList<RecentContactModuleShieldInfo> arrayList = new ArrayList<>();
                Iterator<T> it = ChatsFilterUtil.f355413a.a().iterator();
                while (it.hasNext()) {
                    arrayList.addAll(((lw3.a) it.next()).a());
                }
                ChatsFilterUtil chatsFilterUtil = ChatsFilterUtil.f355413a;
                if (chatsFilterUtil.c() == arrayList.size() && this.$mode >= 0 && chatsFilterUtil.b() == this.$mode) {
                    QLog.d("ChatsFilterUtil", 1, "[triggerChatsNtFilter] update mode repeat. size=" + chatsFilterUtil.c() + ", mode=" + this.$mode);
                    return;
                }
                IQQNTWrapperSession k3 = f.k();
                if (k3 != null && (recentContactService = k3.getRecentContactService()) != null) {
                    chatsFilterUtil.f(this.$mode);
                    chatsFilterUtil.g(arrayList.size());
                    recentContactService.upInsertModule(arrayList);
                }
                QLog.d("ChatsFilterUtil", 1, "[triggerChatsNtFilter] update mode list: " + arrayList.size() + ", mode=" + chatsFilterUtil.b());
            }
        });
    }
}
