package com.tencent.qqnt.chats.main.vm.usecase;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import com.dataline.nt.DataLineItemClickUseCase;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.activateFriend.t;
import com.tencent.mobileqq.activity.home.chats.troophelper.TroopHelperItemClickUseCase;
import com.tencent.mobileqq.activity.recent.gamemsgbox.v;
import com.tencent.mobileqq.channel.node.click.ChannelItemClickUseCase;
import com.tencent.mobileqq.chat.SubAccountAssistantItemClickUseCase;
import com.tencent.mobileqq.phonecontact.nt.ContactStrangerClickUseCase;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.main.vm.usecase.click.b;
import com.tencent.robot.route.RobotClickUseCase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ty.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\b\u0016\u0018\u0000 \u001b2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b \u0010!J!\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0096\u0002R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR!\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R!\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015R!\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00170\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0013\u001a\u0004\b\u001b\u0010\u0015R\u0016\u0010\u001f\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/qqnt/chats/main/vm/usecase/ItemClickUseCase;", "", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Landroid/view/View;", "view", "Lcom/tencent/qqnt/chats/core/a;", "context", "", "g", "Lcom/tencent/qqnt/chats/main/vm/usecase/click/a;", "a", "Lcom/tencent/qqnt/chats/main/vm/usecase/click/a;", "getDefaultClickUseCase", "()Lcom/tencent/qqnt/chats/main/vm/usecase/click/a;", "defaultClickUseCase", "", "Lcom/tencent/qqnt/chats/main/vm/usecase/click/b;", "b", "Lkotlin/Lazy;", "d", "()Ljava/util/List;", "subUseCase", "Lcom/tencent/qqnt/chats/main/vm/usecase/click/c;", "c", "e", "subUseCasePreClick", "f", "subUseCaseWhenClick", "", "J", "lastTime", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public class ItemClickUseCase {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: g, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Chats/Inject_ClickUseCase.yml", version = 1)
    @NotNull
    private static final ArrayList<Class<com.tencent.qqnt.chats.main.vm.usecase.click.b>> f355443g;

    /* renamed from: h, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Chats/Inject_ClickUseCase.yml", version = 2)
    @NotNull
    private static final ArrayList<Class<com.tencent.qqnt.chats.main.vm.usecase.click.c>> f355444h;

    /* renamed from: i, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Chats/Inject_ClickUseCase.yml", version = 1)
    @NotNull
    private static final ArrayList<Class<com.tencent.qqnt.chats.main.vm.usecase.click.c>> f355445i;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.chats.main.vm.usecase.click.a defaultClickUseCase;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy subUseCase;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy subUseCasePreClick;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy subUseCaseWhenClick;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long lastTime;

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u000bR<\u0010\u0006\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003`\u00058\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR<\u0010\r\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00030\u0002j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0003`\u00058\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0007\u0012\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u000e\u0010\tR<\u0010\u0010\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00030\u0002j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0003`\u00058\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0007\u0012\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0011\u0010\tR\u0014\u0010\u0014\u001a\u00020\u00138\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00168\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/qqnt/chats/main/vm/usecase/ItemClickUseCase$a;", "", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lcom/tencent/qqnt/chats/main/vm/usecase/click/b;", "Lkotlin/collections/ArrayList;", "subUseCaseClass", "Ljava/util/ArrayList;", "a", "()Ljava/util/ArrayList;", "getSubUseCaseClass$annotations", "()V", "Lcom/tencent/qqnt/chats/main/vm/usecase/click/c;", "subUseCasePreClickClass", "b", "getSubUseCasePreClickClass$annotations", "subUseCaseWhenClickClass", "c", "getSubUseCaseWhenClickClass$annotations", "", "MULTI_CLICK_THRESHOLD", "J", "", "TAG", "Ljava/lang/String;", "<init>", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.main.vm.usecase.ItemClickUseCase$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final ArrayList<Class<com.tencent.qqnt.chats.main.vm.usecase.click.b>> a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return ItemClickUseCase.f355443g;
            }
            return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this);
        }

        @NotNull
        public final ArrayList<Class<com.tencent.qqnt.chats.main.vm.usecase.click.c>> b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return ItemClickUseCase.f355444h;
            }
            return (ArrayList) iPatchRedirector.redirect((short) 3, (Object) this);
        }

        @NotNull
        public final ArrayList<Class<com.tencent.qqnt.chats.main.vm.usecase.click.c>> c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return ItemClickUseCase.f355445i;
            }
            return (ArrayList) iPatchRedirector.redirect((short) 4, (Object) this);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46218);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        INSTANCE = new Companion(null);
        ArrayList<Class<com.tencent.qqnt.chats.main.vm.usecase.click.b>> arrayList = new ArrayList<>();
        f355443g = arrayList;
        arrayList.add(com.qzone.reborn.publicaccount.c.class);
        arrayList.add(com.tencent.mobileqq.qqecommerce.base.publicaccount.c.class);
        arrayList.add(TroopHelperItemClickUseCase.class);
        arrayList.add(com.tencent.mobileqq.qqshop.api.a.class);
        arrayList.add(com.tencent.biz.qqcircle.publicaccount.a.class);
        arrayList.add(h.class);
        arrayList.add(com.tencent.mobileqq.activity.home.chats.biz.guild.ItemClickUseCase.class);
        arrayList.add(com.tencent.mobileqq.weather.chat.c.class);
        arrayList.add(l43.b.class);
        arrayList.add(r23.a.class);
        arrayList.add(o23.a.class);
        arrayList.add(x33.a.class);
        arrayList.add(bw3.a.class);
        arrayList.add(com.tencent.mobileqq.qqgamepub.nt.a.class);
        arrayList.add(kb2.a.class);
        arrayList.add(com.tencent.mobileqq.qqnews.chat.a.class);
        arrayList.add(com.tencent.mobileqq.tvideo.base.h.class);
        arrayList.add(ky.a.class);
        arrayList.add(fy.a.class);
        arrayList.add(SubAccountAssistantItemClickUseCase.class);
        arrayList.add(ContactStrangerClickUseCase.class);
        arrayList.add(v.class);
        arrayList.add(com.tencent.mobileqq.activity.bless.e.class);
        arrayList.add(t.class);
        arrayList.add(ChannelItemClickUseCase.class);
        arrayList.add(DataLineItemClickUseCase.class);
        arrayList.add(com.tencent.mobileqq.activity.recent.gamemsgbox.d.class);
        arrayList.add(ka2.a.class);
        arrayList.add(com.tencent.mobileqq.matchfriend.reborn.content.msg.nt.f.class);
        arrayList.add(com.tencent.mobileqq.guildhelper.b.class);
        arrayList.add(RobotClickUseCase.class);
        arrayList.add(y12.a.class);
        ArrayList<Class<com.tencent.qqnt.chats.main.vm.usecase.click.c>> arrayList2 = new ArrayList<>();
        f355444h = arrayList2;
        arrayList2.add(com.tencent.mobileqq.guild.usecase.b.class);
        arrayList2.add(fy.b.class);
        arrayList2.add(z44.a.class);
        ArrayList<Class<com.tencent.qqnt.chats.main.vm.usecase.click.c>> arrayList3 = new ArrayList<>();
        f355445i = arrayList3;
        arrayList3.add(com.tencent.mobileqq.activity.home.chats.anim.a.class);
    }

    public ItemClickUseCase() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.defaultClickUseCase = new com.tencent.qqnt.chats.main.vm.usecase.click.a();
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) ItemClickUseCase$subUseCase$2.INSTANCE);
        this.subUseCase = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) ItemClickUseCase$subUseCasePreClick$2.INSTANCE);
        this.subUseCasePreClick = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) ItemClickUseCase$subUseCaseWhenClick$2.INSTANCE);
        this.subUseCaseWhenClick = lazy3;
    }

    private final List<com.tencent.qqnt.chats.main.vm.usecase.click.b> d() {
        return (List) this.subUseCase.getValue();
    }

    private final List<com.tencent.qqnt.chats.main.vm.usecase.click.c> e() {
        return (List) this.subUseCasePreClick.getValue();
    }

    private final List<com.tencent.qqnt.chats.main.vm.usecase.click.c> f() {
        return (List) this.subUseCaseWhenClick.getValue();
    }

    public void g(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.b item, @NotNull View view, @NotNull com.tencent.qqnt.chats.core.a context) {
        Object obj;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, item, view, context);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(context, "context");
        if (SystemClock.uptimeMillis() - this.lastTime < 400) {
            return;
        }
        this.lastTime = SystemClock.uptimeMillis();
        b.a aVar = new b.a(item, view, context);
        Iterator<T> it = e().iterator();
        while (it.hasNext()) {
            ((com.tencent.qqnt.chats.main.vm.usecase.click.c) it.next()).invoke(aVar);
        }
        int size = d().size();
        int e16 = item.e();
        if (item instanceof com.tencent.qqnt.chats.core.adapter.itemdata.g) {
            obj = Integer.valueOf(((com.tencent.qqnt.chats.core.adapter.itemdata.g) item).n());
        } else {
            obj = "";
        }
        QLog.d("ItemClickUseCase", 1, "[ItemClick] before subUseCase, hasSubUseCase=" + size + ", handle: viewType=" + e16 + ", contactType=" + obj);
        if (d().isEmpty()) {
            this.defaultClickUseCase.invoke(aVar);
            return;
        }
        Iterator<T> it5 = d().iterator();
        while (true) {
            if (it5.hasNext()) {
                com.tencent.qqnt.chats.main.vm.usecase.click.b bVar = (com.tencent.qqnt.chats.main.vm.usecase.click.b) it5.next();
                if (bVar.interestedIn(aVar)) {
                    if (bVar.needUnifiedAnim(aVar)) {
                        Iterator<T> it6 = f().iterator();
                        while (it6.hasNext()) {
                            ((com.tencent.qqnt.chats.main.vm.usecase.click.c) it6.next()).invoke(aVar);
                        }
                    }
                    z16 = bVar.invoke(aVar);
                    String name = bVar.getClass().getName();
                    Intrinsics.checkNotNullExpressionValue(name, "it::class.java.name ?: \"\"");
                    QLog.d("ItemClickUseCase", 1, "[ItemClick] subUseCase=" + name + ", subUseCaseResult=" + z16);
                }
            } else {
                z16 = false;
                break;
            }
        }
        QLog.d("ItemClickUseCase", 1, "[ItemClick] after subUseCase: subUseCaseResult=" + z16);
        if (!z16) {
            this.defaultClickUseCase.invoke(aVar);
        } else if (aVar.c().getContext() instanceof Activity) {
            Context context2 = aVar.c().getContext();
            Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type android.app.Activity");
            ((Activity) context2).overridePendingTransition(R.anim.f154445lb, R.anim.f154449lf);
        }
    }
}
