package com.tencent.qqnt.chats.main.vm.usecase;

import android.content.Context;
import com.dataline.nt.DataLineMenuDeleteUseCase;
import com.dataline.nt.DataLineMenuSetTopUseCase;
import com.tencent.biz.pubaccount.recentcontact.DefaultPAUnsubscribeMenuUseCase;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qqcircle.publicaccount.QCirclePublicAccountMenuCancelSetTopUseCase;
import com.tencent.biz.qqcircle.publicaccount.QCirclePublicAccountMenuDeleteUseCase;
import com.tencent.biz.qqcircle.publicaccount.QCirclePublicAccountMenuSetTopUseCase;
import com.tencent.biz.qqcircle.publicaccount.QCirclePublicAccountMenuUnsubscribeUseCase;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.activateFriend.QQNotifyDeleteMenuUseCase;
import com.tencent.mobileqq.activity.bless.BlessDeleteMenuUseCase;
import com.tencent.mobileqq.channel.node.menu.ChannelSetTopMenuUseCase;
import com.tencent.mobileqq.channel.node.menu.ChannelUnsetTopMenuCase;
import com.tencent.mobileqq.channel.node.menu.ChannelUnsubscribeMenuUseCase;
import com.tencent.mobileqq.chat.SubAccountAssistantDeleteMenuUseCase;
import com.tencent.mobileqq.guild.usecase.GuildCancelTopMenuUseCaseTop;
import com.tencent.mobileqq.guild.usecase.GuildTopMenuUseCase;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.nt.QQStrangerCancelSetTopMenuUseCase;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.nt.QQStrangerDeleteMenuUseCase;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.nt.QQStrangerSetTopMenuUseCase;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.biz.guild.usecase.GuildCancelFoldUseCase;
import com.tencent.qqnt.chats.biz.guild.usecase.GuildCancelMsgNoDisturbUseCase;
import com.tencent.qqnt.chats.biz.guild.usecase.GuildDeleteMenuUseCase;
import com.tencent.qqnt.chats.biz.guild.usecase.GuildFoldUseCase;
import com.tencent.qqnt.chats.biz.guild.usecase.GuildMsgNoDisturbUseCase;
import com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo;
import com.tencent.qqnt.chats.main.vm.usecase.menu.DefaultCancelTopUseCase;
import com.tencent.qqnt.chats.main.vm.usecase.menu.DefaultDeleteMenuUseCase;
import com.tencent.qqnt.chats.main.vm.usecase.menu.DefaultMarkReadUseCase;
import com.tencent.qqnt.chats.main.vm.usecase.menu.DefaultMarkUnreadUseCase;
import com.tencent.qqnt.chats.main.vm.usecase.menu.DefaultTopMenuUseCase;
import com.tencent.qqnt.chats.main.vm.usecase.menu.DefaultUnHiddenChatUseCase;
import com.tencent.qqnt.chats.main.vm.usecase.menu.DefaultUnSubscribeUseCase;
import com.tencent.qqnt.chats.main.vm.usecase.meun.a;
import com.tencent.troopguild.unread.TroopGuildDeleteMenuUseCase;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000 !2\u00020\u0001:\u0001\u000eB\u0017\u0012\u0006\u0010\u001e\u001a\u00020\u0013\u0012\u0006\u0010\u0011\u001a\u00020\u000f\u00a2\u0006\u0004\b\u001f\u0010 J,\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006*\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003`\u0005J!\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0086\u0002R\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0010R\"\u0010\u0016\u001a\u0010\u0012\f\u0012\n \u0014*\u0004\u0018\u00010\u00130\u00130\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0015R0\u0010\u001b\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\u0017j\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0004`\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR<\u0010\u001d\u001a*\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00060\u0017j\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0006`\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001a\u00a8\u0006\""}, d2 = {"Lcom/tencent/qqnt/chats/main/vm/usecase/e;", "", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lcom/tencent/qqnt/chats/main/vm/usecase/meun/a;", "Lkotlin/collections/ArrayList;", "", "b", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/b;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "menuId", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/qqnt/chats/main/vm/usecase/result/a;", "a", "Lcom/tencent/qqnt/chats/main/vm/datasource/IRecentContactRepo;", "Lcom/tencent/qqnt/chats/main/vm/datasource/IRecentContactRepo;", "recentContactRepo", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "Ljava/lang/ref/WeakReference;", "contextRef", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "c", "Ljava/util/HashMap;", "defaultUseCase", "d", "subUseCases", "context", "<init>", "(Landroid/content/Context;Lcom/tencent/qqnt/chats/main/vm/datasource/IRecentContactRepo;)V", "e", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: f, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Chats/Inject_MenuUseCase.yml", version = 2)
    @NotNull
    private static final ArrayList<Class<com.tencent.qqnt.chats.main.vm.usecase.meun.a>> f355477f;

    /* renamed from: g, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Chats/Inject_MenuUseCase.yml", version = 2)
    @NotNull
    private static final ArrayList<Class<com.tencent.qqnt.chats.main.vm.usecase.meun.a>> f355478g;

    /* renamed from: h, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Chats/Inject_MenuUseCase.yml", version = 2)
    @NotNull
    private static final ArrayList<Class<com.tencent.qqnt.chats.main.vm.usecase.meun.a>> f355479h;

    /* renamed from: i, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Chats/Inject_MenuUseCase.yml", version = 2)
    @NotNull
    private static final ArrayList<Class<com.tencent.qqnt.chats.main.vm.usecase.meun.a>> f355480i;

    /* renamed from: j, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Chats/Inject_MenuUseCase.yml", version = 2)
    @NotNull
    private static final ArrayList<Class<com.tencent.qqnt.chats.main.vm.usecase.meun.a>> f355481j;

    /* renamed from: k, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Chats/Inject_MenuUseCase.yml", version = 2)
    @NotNull
    private static final ArrayList<Class<com.tencent.qqnt.chats.main.vm.usecase.meun.a>> f355482k;

    /* renamed from: l, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Chats/Inject_MenuUseCase.yml", version = 2)
    @NotNull
    private static final ArrayList<Class<com.tencent.qqnt.chats.main.vm.usecase.meun.a>> f355483l;

    /* renamed from: m, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Chats/Inject_MenuUseCase.yml", version = 2)
    @NotNull
    private static final ArrayList<Class<com.tencent.qqnt.chats.main.vm.usecase.meun.a>> f355484m;

    /* renamed from: n, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Chats/Inject_MenuUseCase.yml", version = 2)
    @NotNull
    private static final ArrayList<Class<com.tencent.qqnt.chats.main.vm.usecase.meun.a>> f355485n;

    /* renamed from: o, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Chats/Inject_MenuUseCase.yml", version = 2)
    @NotNull
    private static final ArrayList<Class<com.tencent.qqnt.chats.main.vm.usecase.meun.a>> f355486o;

    /* renamed from: p, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Chats/Inject_MenuUseCase.yml", version = 2)
    @NotNull
    private static final ArrayList<Class<com.tencent.qqnt.chats.main.vm.usecase.meun.a>> f355487p;

    /* renamed from: q, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Chats/Inject_MenuUseCase.yml", version = 2)
    @NotNull
    private static final ArrayList<Class<com.tencent.qqnt.chats.main.vm.usecase.meun.a>> f355488q;

    /* renamed from: r, reason: collision with root package name */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Chats/Inject_MenuUseCase.yml", version = 2)
    @NotNull
    private static final ArrayList<Class<com.tencent.qqnt.chats.main.vm.usecase.meun.a>> f355489r;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IRecentContactRepo recentContactRepo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<Context> contextRef;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<Integer, com.tencent.qqnt.chats.main.vm.usecase.meun.a> defaultUseCase;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<Integer, List<com.tencent.qqnt.chats.main.vm.usecase.meun.a>> subUseCases;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chats/main/vm/usecase/e$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.main.vm.usecase.e$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 15)) {
                return;
            }
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) defaultConstructorMarker);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46259);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        INSTANCE = new Companion(null);
        f355477f = new ArrayList<>();
        f355478g = new ArrayList<>();
        ArrayList<Class<com.tencent.qqnt.chats.main.vm.usecase.meun.a>> arrayList = new ArrayList<>();
        f355479h = arrayList;
        arrayList.add(GuildTopMenuUseCase.class);
        arrayList.add(ChannelSetTopMenuUseCase.class);
        arrayList.add(QCirclePublicAccountMenuSetTopUseCase.class);
        arrayList.add(DataLineMenuSetTopUseCase.class);
        arrayList.add(QQStrangerSetTopMenuUseCase.class);
        ArrayList<Class<com.tencent.qqnt.chats.main.vm.usecase.meun.a>> arrayList2 = new ArrayList<>();
        f355480i = arrayList2;
        arrayList2.add(GuildCancelTopMenuUseCaseTop.class);
        arrayList2.add(ChannelUnsetTopMenuCase.class);
        arrayList2.add(QCirclePublicAccountMenuCancelSetTopUseCase.class);
        arrayList2.add(QQStrangerCancelSetTopMenuUseCase.class);
        ArrayList<Class<com.tencent.qqnt.chats.main.vm.usecase.meun.a>> arrayList3 = new ArrayList<>();
        f355481j = arrayList3;
        arrayList3.add(SubAccountAssistantDeleteMenuUseCase.class);
        arrayList3.add(BlessDeleteMenuUseCase.class);
        arrayList3.add(QQNotifyDeleteMenuUseCase.class);
        arrayList3.add(TroopGuildDeleteMenuUseCase.class);
        arrayList3.add(QQStrangerDeleteMenuUseCase.class);
        arrayList3.add(GuildDeleteMenuUseCase.class);
        arrayList3.add(QCirclePublicAccountMenuDeleteUseCase.class);
        arrayList3.add(DataLineMenuDeleteUseCase.class);
        ArrayList<Class<com.tencent.qqnt.chats.main.vm.usecase.meun.a>> arrayList4 = new ArrayList<>();
        f355482k = arrayList4;
        arrayList4.add(QCirclePublicAccountMenuUnsubscribeUseCase.class);
        arrayList4.add(DefaultPAUnsubscribeMenuUseCase.class);
        f355483l = new ArrayList<>();
        ArrayList<Class<com.tencent.qqnt.chats.main.vm.usecase.meun.a>> arrayList5 = new ArrayList<>();
        f355484m = arrayList5;
        arrayList5.add(ChannelUnsubscribeMenuUseCase.class);
        f355485n = new ArrayList<>();
        ArrayList<Class<com.tencent.qqnt.chats.main.vm.usecase.meun.a>> arrayList6 = new ArrayList<>();
        f355486o = arrayList6;
        arrayList6.add(GuildMsgNoDisturbUseCase.class);
        ArrayList<Class<com.tencent.qqnt.chats.main.vm.usecase.meun.a>> arrayList7 = new ArrayList<>();
        f355487p = arrayList7;
        arrayList7.add(GuildCancelMsgNoDisturbUseCase.class);
        ArrayList<Class<com.tencent.qqnt.chats.main.vm.usecase.meun.a>> arrayList8 = new ArrayList<>();
        f355488q = arrayList8;
        arrayList8.add(GuildFoldUseCase.class);
        ArrayList<Class<com.tencent.qqnt.chats.main.vm.usecase.meun.a>> arrayList9 = new ArrayList<>();
        f355489r = arrayList9;
        arrayList9.add(GuildCancelFoldUseCase.class);
    }

    public e(@NotNull Context context, @NotNull IRecentContactRepo recentContactRepo) {
        List<com.tencent.qqnt.chats.main.vm.usecase.meun.a> listOf;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(recentContactRepo, "recentContactRepo");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) recentContactRepo);
            return;
        }
        this.recentContactRepo = recentContactRepo;
        this.contextRef = new WeakReference<>(context);
        HashMap<Integer, com.tencent.qqnt.chats.main.vm.usecase.meun.a> hashMap = new HashMap<>();
        DefaultCancelTopUseCase defaultCancelTopUseCase = new DefaultCancelTopUseCase(recentContactRepo);
        hashMap.put(Integer.valueOf(defaultCancelTopUseCase.getProcessType()), defaultCancelTopUseCase);
        DefaultDeleteMenuUseCase defaultDeleteMenuUseCase = new DefaultDeleteMenuUseCase(recentContactRepo);
        hashMap.put(Integer.valueOf(defaultDeleteMenuUseCase.getProcessType()), defaultDeleteMenuUseCase);
        DefaultTopMenuUseCase defaultTopMenuUseCase = new DefaultTopMenuUseCase(recentContactRepo);
        hashMap.put(Integer.valueOf(defaultTopMenuUseCase.getProcessType()), defaultTopMenuUseCase);
        DefaultMarkReadUseCase defaultMarkReadUseCase = new DefaultMarkReadUseCase(recentContactRepo);
        hashMap.put(Integer.valueOf(defaultMarkReadUseCase.getProcessType()), defaultMarkReadUseCase);
        DefaultMarkUnreadUseCase defaultMarkUnreadUseCase = new DefaultMarkUnreadUseCase(recentContactRepo);
        hashMap.put(Integer.valueOf(defaultMarkUnreadUseCase.getProcessType()), defaultMarkUnreadUseCase);
        DefaultUnSubscribeUseCase defaultUnSubscribeUseCase = new DefaultUnSubscribeUseCase(recentContactRepo);
        hashMap.put(Integer.valueOf(defaultUnSubscribeUseCase.getProcessType()), defaultUnSubscribeUseCase);
        DefaultUnHiddenChatUseCase defaultUnHiddenChatUseCase = new DefaultUnHiddenChatUseCase(recentContactRepo);
        hashMap.put(Integer.valueOf(defaultUnHiddenChatUseCase.getProcessType()), defaultUnHiddenChatUseCase);
        this.defaultUseCase = hashMap;
        HashMap<Integer, List<com.tencent.qqnt.chats.main.vm.usecase.meun.a>> hashMap2 = new HashMap<>();
        hashMap2.put(Integer.valueOf(R.id.epz), b(f355481j));
        hashMap2.put(Integer.valueOf(R.id.eqb), b(f355477f));
        hashMap2.put(Integer.valueOf(R.id.eqe), b(f355479h));
        hashMap2.put(Integer.valueOf(R.id.epu), b(f355480i));
        hashMap2.put(Integer.valueOf(R.id.eqa), b(f355478g));
        Integer valueOf = Integer.valueOf(R.id.z4o);
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new com.tencent.qqnt.chats.main.vm.usecase.menu.b(recentContactRepo));
        hashMap2.put(valueOf, listOf);
        hashMap2.put(Integer.valueOf(R.id.z4b), b(f355482k));
        hashMap2.put(Integer.valueOf(R.id.eqo), b(f355483l));
        hashMap2.put(Integer.valueOf(R.id.z3n), b(f355484m));
        hashMap2.put(Integer.valueOf(R.id.gsg), b(f355485n));
        hashMap2.put(Integer.valueOf(R.id.z49), b(f355486o));
        hashMap2.put(Integer.valueOf(R.id.z3l), b(f355487p));
        hashMap2.put(Integer.valueOf(R.id.z3x), b(f355488q));
        hashMap2.put(Integer.valueOf(R.id.z3k), b(f355489r));
        this.subUseCases = hashMap2;
    }

    @Nullable
    public final Flow<com.tencent.qqnt.chats.main.vm.usecase.result.a> a(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.b item, int menuId) {
        Result result;
        Flow flow;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Flow) iPatchRedirector.redirect((short) 3, (Object) this, (Object) item, menuId);
        }
        Intrinsics.checkNotNullParameter(item, "item");
        List<com.tencent.qqnt.chats.main.vm.usecase.meun.a> list = this.subUseCases.get(Integer.valueOf(menuId));
        a.C9600a c9600a = new a.C9600a(item, this.contextRef.get());
        Object obj = null;
        if (list != null && !list.isEmpty()) {
            Iterator<com.tencent.qqnt.chats.main.vm.usecase.meun.a> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    com.tencent.qqnt.chats.main.vm.usecase.meun.a next = it.next();
                    if (next.interestedIn(c9600a)) {
                        QLog.d("MenuOperateUseCase", 1, next + " process " + item + " menu click");
                        Result.Companion companion = Result.INSTANCE;
                        result = Result.m475boximpl(Result.m476constructorimpl(next.invoke(c9600a)));
                        break;
                    }
                } else {
                    result = null;
                    break;
                }
            }
            if (result != null) {
                Object value = result.getValue();
                if (Result.m482isFailureimpl(value)) {
                    value = null;
                }
                flow = (Flow) value;
            } else {
                flow = null;
            }
            if (flow == null) {
                com.tencent.qqnt.chats.main.vm.usecase.meun.a aVar = this.defaultUseCase.get(Integer.valueOf(menuId));
                if (aVar == null) {
                    return null;
                }
                return aVar.invoke(c9600a);
            }
            Object value2 = result.getValue();
            if (!Result.m482isFailureimpl(value2)) {
                obj = value2;
            }
            return (Flow) obj;
        }
        com.tencent.qqnt.chats.main.vm.usecase.meun.a aVar2 = this.defaultUseCase.get(Integer.valueOf(menuId));
        if (aVar2 == null) {
            return null;
        }
        return aVar2.invoke(c9600a);
    }

    @NotNull
    public final List<com.tencent.qqnt.chats.main.vm.usecase.meun.a> b(@NotNull ArrayList<Class<com.tencent.qqnt.chats.main.vm.usecase.meun.a>> arrayList) {
        int collectionSizeOrDefault;
        Object first;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) arrayList);
        }
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            Constructor<?>[] constructors = ((Class) it.next()).getConstructors();
            Intrinsics.checkNotNullExpressionValue(constructors, "it.constructors");
            first = ArraysKt___ArraysKt.first(constructors);
            Object newInstance = ((Constructor) first).newInstance(this.recentContactRepo);
            Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type com.tencent.qqnt.chats.main.vm.usecase.meun.IMenuUseCase");
            arrayList2.add((com.tencent.qqnt.chats.main.vm.usecase.meun.a) newInstance);
        }
        return arrayList2;
    }
}
