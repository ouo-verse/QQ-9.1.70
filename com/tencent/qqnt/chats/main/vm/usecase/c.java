package com.tencent.qqnt.chats.main.vm.usecase;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.activity.recent.gamemsgbox.GameBoxRedDotDragUseCase;
import com.tencent.mobileqq.channel.node.unread.ChannelRedDotDragUseCase;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.qqnt.chats.biz.guild.usecase.GuildRedDotDragUseCase;
import com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo;
import com.tencent.qqnt.chats.main.vm.usecase.reddot.DefaultRedDotDragUseCase;
import com.tencent.qqnt.chats.main.vm.usecase.reddot.IRedDotDragUseCase;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 \u00182\u00020\u0001:\u0001\u0005B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0011\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0086\u0002R\u0017\u0010\n\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0010\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/qqnt/chats/main/vm/usecase/c;", "", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "a", "Lcom/tencent/qqnt/chats/main/vm/datasource/IRecentContactRepo;", "Lcom/tencent/qqnt/chats/main/vm/datasource/IRecentContactRepo;", "getRepo", "()Lcom/tencent/qqnt/chats/main/vm/datasource/IRecentContactRepo;", "repo", "Lcom/tencent/qqnt/chats/main/vm/usecase/reddot/DefaultRedDotDragUseCase;", "b", "Lcom/tencent/qqnt/chats/main/vm/usecase/reddot/DefaultRedDotDragUseCase;", "getDefaultRedDotDragUseCase", "()Lcom/tencent/qqnt/chats/main/vm/usecase/reddot/DefaultRedDotDragUseCase;", "defaultRedDotDragUseCase", "", "Lcom/tencent/qqnt/chats/main/vm/usecase/reddot/IRedDotDragUseCase;", "c", "Ljava/util/List;", "subUseCase", "<init>", "(Lcom/tencent/qqnt/chats/main/vm/datasource/IRecentContactRepo;)V", "d", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Chats/Inject_ItemRedDotDragUseCase.yml", version = 1)
    @NotNull
    private static final ArrayList<Class<IRedDotDragUseCase>> f355465e;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IRecentContactRepo repo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final DefaultRedDotDragUseCase defaultRedDotDragUseCase;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<IRedDotDragUseCase> subUseCase;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chats/main/vm/usecase/c$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.main.vm.usecase.c$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46223);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        INSTANCE = new Companion(null);
        ArrayList<Class<IRedDotDragUseCase>> arrayList = new ArrayList<>();
        f355465e = arrayList;
        arrayList.add(GuildRedDotDragUseCase.class);
        arrayList.add(ChannelRedDotDragUseCase.class);
        arrayList.add(GameBoxRedDotDragUseCase.class);
    }

    public c(@NotNull IRecentContactRepo repo) {
        int collectionSizeOrDefault;
        Object first;
        Intrinsics.checkNotNullParameter(repo, "repo");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) repo);
            return;
        }
        this.repo = repo;
        this.defaultRedDotDragUseCase = new DefaultRedDotDragUseCase(repo);
        ArrayList<Class<IRedDotDragUseCase>> arrayList = f355465e;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            Constructor<?>[] constructors = ((Class) it.next()).getConstructors();
            Intrinsics.checkNotNullExpressionValue(constructors, "it.constructors");
            first = ArraysKt___ArraysKt.first(constructors);
            Object newInstance = ((Constructor) first).newInstance(this.repo);
            Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type com.tencent.qqnt.chats.main.vm.usecase.reddot.IRedDotDragUseCase");
            arrayList2.add((IRedDotDragUseCase) newInstance);
        }
        this.subUseCase = arrayList2;
    }

    public final void a(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.b item) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) item);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        IRedDotDragUseCase.a aVar = new IRedDotDragUseCase.a(item);
        if (this.subUseCase.isEmpty()) {
            this.defaultRedDotDragUseCase.invoke(aVar);
            return;
        }
        Iterator<T> it = this.subUseCase.iterator();
        while (true) {
            if (it.hasNext()) {
                IRedDotDragUseCase iRedDotDragUseCase = (IRedDotDragUseCase) it.next();
                if (iRedDotDragUseCase.interestedIn(aVar)) {
                    z16 = iRedDotDragUseCase.invoke(aVar);
                    break;
                }
            } else {
                z16 = false;
                break;
            }
        }
        if (!z16) {
            this.defaultRedDotDragUseCase.invoke(aVar);
        }
    }
}
