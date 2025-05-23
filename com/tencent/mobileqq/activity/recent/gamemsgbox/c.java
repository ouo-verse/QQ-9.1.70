package com.tencent.mobileqq.activity.recent.gamemsgbox;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager;
import com.tencent.mobileqq.gamecenter.api.IGameCenterCommonApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.msginfo.GameSwitchConfig;
import com.tencent.mobileqq.gamecenter.nt.api.IGameMsgNtApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.api.IChatPartConvertProcessor;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactExtAttr;
import com.tencent.qqnt.kernel.nativeinterface.TempChatGameSession;
import cooperation.qzone.QZoneShareManager;
import cooperation.qzone.util.QZoneImageUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \r2\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R0\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014j\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016`\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0018R0\u0010\u001a\u001a\u001e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160\u0014j\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0016`\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0018R\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/activity/recent/gamemsgbox/c;", "Lcom/tencent/qqnt/chats/data/converter/e;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/qqnt/chats/data/converter/c;", "params", "", "a", "c", "Lgd1/a;", "info", "b", "e", "d", "Lmqq/app/AppRuntime;", "app", "f", "", QZoneImageUtils.KEY_MATCH, "update", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "onlineTypeMap", "gameOnlineNickName", "", "Lcom/tencent/qqnt/chats/data/converter/g;", "Ljava/util/List;", "mProcessorList", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class c extends com.tencent.qqnt.chats.data.converter.e {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<Integer, String> onlineTypeMap;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<String, String> gameOnlineNickName;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<com.tencent.qqnt.chats.data.converter.g> mProcessorList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/activity/recent/gamemsgbox/c$a;", "", "", "SEX_FEMALE", "I", "SEX_MALE", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.activity.recent.gamemsgbox.c$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52682);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public c() {
        List<com.tencent.qqnt.chats.data.converter.g> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        HashMap<Integer, String> hashMap = new HashMap<>();
        this.onlineTypeMap = hashMap;
        HashMap<String, String> hashMap2 = new HashMap<>();
        this.gameOnlineNickName = hashMap2;
        hashMap.put(1, "[{gameName}\u5728\u7ebf]");
        hashMap.put(2, "[\u6e38\u620f\u4e2d]");
        hashMap2.put(QZoneShareManager.GLORY_OF_KINGS, "\u738b\u8005");
        hashMap2.put("1106467070", "\u548c\u5e73");
        hashMap2.put("1106838536", "CODM");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.qqnt.chats.data.converter.g[]{(com.tencent.qqnt.chats.data.converter.g) ((IChatPartConvertProcessor) QRoute.api(IChatPartConvertProcessor.class)).createTitleConvertProcessor(), (com.tencent.qqnt.chats.data.converter.g) ((IChatPartConvertProcessor) QRoute.api(IChatPartConvertProcessor.class)).createSummaryConvertProcessor(), (com.tencent.qqnt.chats.data.converter.g) ((IChatPartConvertProcessor) QRoute.api(IChatPartConvertProcessor.class)).createTimeConvertProcessor(), (com.tencent.qqnt.chats.data.converter.g) ((IChatPartConvertProcessor) QRoute.api(IChatPartConvertProcessor.class)).createUnreadConvertProcessor()});
        this.mProcessorList = listOf;
    }

    private final void a(com.tencent.qqnt.chats.core.adapter.itemdata.g item, com.tencent.qqnt.chats.data.converter.c params) {
        String str;
        String string = BaseApplication.getContext().getString(R.string.f199264oy);
        Intrinsics.checkNotNullExpressionValue(string, "getContext().getString(c\u2026ly_partner_msg_box_title)");
        item.S(new g.f(string));
        item.K(new g.a(2, "", null, null, 12, null));
        item.g().l(Integer.valueOf(R.drawable.muo));
        TempChatGameSession gameSessionFromPeerUid = ((IGameMsgNtApi) QRoute.api(IGameMsgNtApi.class)).getGameSessionFromPeerUid(item.k());
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        String str2 = "";
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IGameMsgManagerService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IG\u2026va, ProcessConstant.MAIN)");
        IGameMsgManagerService iGameMsgManagerService = (IGameMsgManagerService) runtimeService;
        if (gameSessionFromPeerUid != null) {
            str = gameSessionFromPeerUid.peerRoleId;
        } else {
            str = null;
        }
        if (str != null) {
            str2 = str;
        }
        gd1.a singleGameDetailV2 = iGameMsgManagerService.getSingleGameDetailV2(str2);
        if (singleGameDetailV2 != null) {
            b(item, singleGameDetailV2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0046, code lost:
    
        if (r10 != null) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void b(com.tencent.qqnt.chats.core.adapter.itemdata.g item, gd1.a info) {
        String str;
        boolean z16;
        String str2;
        String str3;
        String str4 = this.onlineTypeMap.get(Integer.valueOf(info.f401946j));
        String str5 = "";
        if (!TextUtils.isEmpty(str4)) {
            if (TextUtils.isEmpty(this.gameOnlineNickName.get(info.f401939c))) {
                str2 = info.f401947k;
            } else {
                str2 = this.gameOnlineNickName.get(info.f401939c);
            }
            if (str2 == null) {
                str3 = "";
            } else {
                str3 = str2;
            }
            if (str4 != null) {
                str = StringsKt__StringsJVMKt.replace$default(str4, "{gameName}", str3, false, 4, (Object) null);
            }
        }
        str = "";
        if (item.p() != null) {
            ArrayList<RecentContactExtAttr> p16 = item.p();
            Intrinsics.checkNotNull(p16);
            Iterator<RecentContactExtAttr> it = p16.iterator();
            while (it.hasNext()) {
                RecentContactExtAttr next = it.next();
                if (next.getGameSession() == null) {
                    TempChatGameSession gameSession = next.getGameSession();
                    Intrinsics.checkNotNull(gameSession);
                    if (gameSession.nickname != null) {
                    }
                }
                TempChatGameSession gameSession2 = next.getGameSession();
                Intrinsics.checkNotNull(gameSession2);
                str5 = gameSession2.nickname;
                Intrinsics.checkNotNullExpressionValue(str5, "attr.getGameSession()!!.nickname");
            }
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        boolean z17 = true;
        if (str5.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            spannableStringBuilder.append((CharSequence) str5).append((CharSequence) MsgSummary.STR_COLON);
        }
        if (str.length() <= 0) {
            z17 = false;
        }
        if (z17) {
            spannableStringBuilder.append((CharSequence) str);
        }
        spannableStringBuilder.append(item.v().f());
        item.v().o(spannableStringBuilder);
    }

    private final void c(com.tencent.qqnt.chats.core.adapter.itemdata.g item, com.tencent.qqnt.chats.data.converter.c params) {
        String str;
        int valueOf;
        TempChatGameSession gameSessionFromPeerUid = ((IGameMsgNtApi) QRoute.api(IGameMsgNtApi.class)).getGameSessionFromPeerUid(item.k());
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        String str2 = "";
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IGameMsgManagerService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IG\u2026va, ProcessConstant.MAIN)");
        IGameMsgManagerService iGameMsgManagerService = (IGameMsgManagerService) runtimeService;
        if (gameSessionFromPeerUid != null) {
            str = gameSessionFromPeerUid.peerRoleId;
        } else {
            str = null;
        }
        if (str != null) {
            str2 = str;
        }
        gd1.a singleGameDetailV2 = iGameMsgManagerService.getSingleGameDetailV2(str2);
        if (singleGameDetailV2 != null) {
            String str3 = singleGameDetailV2.f401940d;
            Intrinsics.checkNotNullExpressionValue(str3, "info.mFaceUrl");
            item.K(new g.a(1, str3, null, null, 12, null));
            g.a g16 = item.g();
            int i3 = singleGameDetailV2.f401945i;
            if (i3 != 1) {
                if (i3 != 2) {
                    valueOf = 0;
                } else {
                    valueOf = Integer.valueOf(R.drawable.nec);
                }
            } else {
                valueOf = Integer.valueOf(R.drawable.nef);
            }
            g16.m(valueOf);
            e(item, singleGameDetailV2);
            String str4 = singleGameDetailV2.f401941e;
            Intrinsics.checkNotNullExpressionValue(str4, "info.mNickInGame");
            item.S(new g.f(str4));
            f(peekAppRuntime, singleGameDetailV2, item);
            if (QLog.isDebugVersion()) {
                QLog.d("GameBoxChatConvertProcessor", 4, "GameDetail=" + singleGameDetailV2);
            }
        }
    }

    private final void d(com.tencent.qqnt.chats.core.adapter.itemdata.g item, com.tencent.qqnt.chats.data.converter.c params) {
        ArrayList arrayList = new ArrayList();
        if (item.H()) {
            arrayList.add(com.tencent.qqnt.chats.core.adapter.menu.creator.c.INSTANCE.d());
        } else {
            arrayList.add(com.tencent.qqnt.chats.core.adapter.menu.creator.c.INSTANCE.q());
        }
        arrayList.add(com.tencent.qqnt.chats.core.adapter.menu.creator.c.INSTANCE.g());
        item.O(arrayList);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x003c, code lost:
    
        r10 = kotlin.text.StringsKt__StringsJVMKt.replace$default(r1, "{gameName}", r3, false, 4, (java.lang.Object) null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void e(com.tencent.qqnt.chats.core.adapter.itemdata.g item, gd1.a info) {
        boolean z16;
        String str;
        String str2;
        String replace$default;
        String str3 = this.onlineTypeMap.get(Integer.valueOf(info.f401946j));
        String str4 = "";
        if (!TextUtils.isEmpty(str3)) {
            if (TextUtils.isEmpty(this.gameOnlineNickName.get(info.f401939c))) {
                str = info.f401947k;
            } else {
                str = this.gameOnlineNickName.get(info.f401939c);
            }
            if (str == null) {
                str2 = "";
            } else {
                str2 = str;
            }
            if (str3 != null && replace$default != null) {
                str4 = replace$default;
            }
        }
        if (str4.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            g.e v3 = item.v();
            SpannableStringBuilder append = new SpannableStringBuilder().append((CharSequence) str4).append(item.v().f());
            Intrinsics.checkNotNullExpressionValue(append, "SpannableStringBuilder()\u2026m.summaryInfo.msgSummary)");
            v3.o(append);
        }
    }

    private final void f(AppRuntime app, gd1.a info, com.tencent.qqnt.chats.core.adapter.itemdata.g item) {
        IRuntimeService runtimeService = app.getRuntimeService(IGameMsgManagerService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IG\u2026va, ProcessConstant.MAIN)");
        GameSwitchConfig findGameSwitchConfig = ((IGameMsgManagerService) runtimeService).findGameSwitchConfig(info.f401939c);
        if (findGameSwitchConfig != null && findGameSwitchConfig.mSyncSwitch == 1 && findGameSwitchConfig.mMuteSwitch == 1) {
            item.x().e(2);
        }
        IRuntimeService runtimeService2 = app.getRuntimeService(IGameMsgBoxManager.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService2, "app.getRuntimeService(IG\u2026va, ProcessConstant.MAIN)");
        IGameMsgBoxManager iGameMsgBoxManager = (IGameMsgBoxManager) runtimeService2;
        iGameMsgBoxManager.updateNTOpenSyncUser(info, findGameSwitchConfig);
        iGameMsgBoxManager.updateGameTabInfo(info, findGameSwitchConfig);
        iGameMsgBoxManager.setConfigToNTKernel(app, findGameSwitchConfig, info.f401947k, false);
    }

    @Override // com.tencent.qqnt.chats.data.converter.e
    public boolean match(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) item)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(item, "item");
        if (item.n() == 105) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqnt.chats.data.converter.e
    public void update(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g item, @NotNull com.tencent.qqnt.chats.data.converter.c params) {
        int collectionSizeOrDefault;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) item, (Object) params);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(params, "params");
        item.q().putBoolean("is_first_data", false);
        List<com.tencent.qqnt.chats.data.converter.g> list = this.mProcessorList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            ((com.tencent.qqnt.chats.data.converter.g) it.next()).update(item, params);
            arrayList.add(Unit.INSTANCE);
        }
        if (((IGameCenterCommonApi) QRoute.api(IGameCenterCommonApi.class)).isApplyPartnerBox(item)) {
            item.O(new ArrayList());
            a(item, params);
        } else {
            d(item, params);
            c(item, params);
        }
    }
}
