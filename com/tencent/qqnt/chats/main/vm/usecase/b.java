package com.tencent.qqnt.chats.main.vm.usecase;

import android.view.View;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.qqnt.chats.main.vm.usecase.longclick.b;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 \u00162\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J1\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0086\u0002\u00f8\u0001\u0000\u00f8\u0001\u0001\u00f8\u0001\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u0082\u0002\u000f\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\n\u0002\b\u0019\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qqnt/chats/main/vm/usecase/b;", "", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Landroid/view/View;", "view", "Lkotlin/Result;", "Lcom/tencent/qqnt/chats/main/vm/usecase/result/a;", "a", "(Lcom/tencent/qqnt/chats/core/adapter/itemdata/b;Landroid/view/View;)Ljava/lang/Object;", "Lcom/tencent/qqnt/chats/main/vm/usecase/longclick/a;", "Lcom/tencent/qqnt/chats/main/vm/usecase/longclick/a;", "getDefaultLongClickUseCase", "()Lcom/tencent/qqnt/chats/main/vm/usecase/longclick/a;", "defaultLongClickUseCase", "", "Lcom/tencent/qqnt/chats/main/vm/usecase/longclick/b;", "b", "Ljava/util/List;", "subUseCase", "<init>", "()V", "c", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Chats/Inject_LongClickUseCase.yml", version = 1)
    @NotNull
    private static final ArrayList<Class<com.tencent.qqnt.chats.main.vm.usecase.longclick.b>> f355453d;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.chats.main.vm.usecase.longclick.a defaultLongClickUseCase;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<com.tencent.qqnt.chats.main.vm.usecase.longclick.b> subUseCase;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chats/main/vm/usecase/b$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.main.vm.usecase.b$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46221);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        INSTANCE = new Companion(null);
        ArrayList<Class<com.tencent.qqnt.chats.main.vm.usecase.longclick.b>> arrayList = new ArrayList<>();
        f355453d = arrayList;
        arrayList.add(com.tencent.qqnt.chats.biz.guild.usecase.b.class);
    }

    public b() {
        int collectionSizeOrDefault;
        Object first;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.defaultLongClickUseCase = new com.tencent.qqnt.chats.main.vm.usecase.longclick.a();
        ArrayList<Class<com.tencent.qqnt.chats.main.vm.usecase.longclick.b>> arrayList = f355453d;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            Constructor<?>[] constructors = ((Class) it.next()).getConstructors();
            Intrinsics.checkNotNullExpressionValue(constructors, "it.constructors");
            first = ArraysKt___ArraysKt.first(constructors);
            Object newInstance = ((Constructor) first).newInstance(new Object[0]);
            Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type com.tencent.qqnt.chats.main.vm.usecase.longclick.ILongClickUseCase");
            arrayList2.add((com.tencent.qqnt.chats.main.vm.usecase.longclick.b) newInstance);
        }
        this.subUseCase = arrayList2;
    }

    @NotNull
    public final Object a(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.b item, @NotNull View view) {
        Result result;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, (Object) this, (Object) item, (Object) view);
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(view, "view");
        b.a aVar = new b.a(item, view);
        if (this.subUseCase.isEmpty()) {
            Result.Companion companion = Result.INSTANCE;
            return Result.m476constructorimpl(this.defaultLongClickUseCase.b(aVar));
        }
        Iterator<T> it = this.subUseCase.iterator();
        while (true) {
            if (it.hasNext()) {
                com.tencent.qqnt.chats.main.vm.usecase.longclick.b bVar = (com.tencent.qqnt.chats.main.vm.usecase.longclick.b) it.next();
                if (bVar.a(aVar)) {
                    Result.Companion companion2 = Result.INSTANCE;
                    result = Result.m475boximpl(Result.m476constructorimpl(bVar.b(aVar)));
                    break;
                }
            } else {
                result = null;
                break;
            }
        }
        boolean z16 = false;
        if (result != null && Result.m483isSuccessimpl(result.getValue())) {
            z16 = true;
        }
        if (!z16) {
            Result.Companion companion3 = Result.INSTANCE;
            return Result.m476constructorimpl(this.defaultLongClickUseCase.b(aVar));
        }
        if (result != null) {
            return result.getValue();
        }
        return Result.m476constructorimpl(null);
    }
}
