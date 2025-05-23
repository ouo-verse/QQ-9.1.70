package com.tencent.troopguild.api.impl;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.qqguildsdk.api.IGProSession;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GuildGroupOptType;
import com.tencent.qqnt.kernel.nativeinterface.GuildGroupSceneType;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.SceneInfoParam;
import com.tencent.qqnt.kernel.nativeinterface.UnreadCnt;
import com.tencent.qqnt.kernel.nativeinterface.UnreadCntInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProContact;
import com.tencent.qqnt.kernelgpro.nativeinterface.IUnreadCntCallback;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import com.tencent.troopguild.api.ITroopGuildApi;
import com.tencent.troopguild.api.ITroopGuildInfoService;
import com.tencent.troopguild.api.ITroopGuildUnreadCntService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 )2\u00020\u00012\u00020\u0002:\u0001*B\u0007\u00a2\u0006\u0004\b'\u0010(J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u0005H\u0016J*\u0010\u0013\u001a\u00020\u00052 \u0010\u0012\u001a\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0011\u0018\u00010\u000fH\u0016J \u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u0010\u0010 \u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u0010\u0010!\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0014H\u0016R\u0016\u0010\"\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R \u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00070$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u0006+"}, d2 = {"Lcom/tencent/troopguild/api/impl/TroopGuildUnreadCntServiceImpl;", "Lcom/tencent/troopguild/api/ITroopGuildUnreadCntService;", "Ljava/util/Observable;", "Lcom/tencent/qqnt/kernel/nativeinterface/UnreadCntInfo;", "unreadCntInfo", "", "handleUnreadCntInfoUpdate", "Luo4/f;", "troopGuildUnreadCntInfo", "notifyUnreadCntInfoChanged", "handleVerifyTroopInfoGuildId", "Lmqq/app/AppRuntime;", "appRuntime", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Ljava/util/HashMap;", "", "Ljava/util/ArrayList;", "unreadCntInfos", "onUnreadCntUpdate", "", "troopUin", "Lcom/tencent/qqnt/kernel/nativeinterface/GuildGroupSceneType;", "sceneType", "", "isDelete", "setTroopGuildMsgRead", "cleanTroopGuildUnreadHighLight", "fetchUnreadCntInfo", "Ljava/util/Observer;", "observer", "addUnreadCntInfoObserver", "deleteUnreadCntInfoObserver", "getUnreadCntInfo", "mAppRuntime", "Lmqq/app/AppRuntime;", "Ljava/util/concurrent/ConcurrentHashMap;", "mUnreadCntInfoCache", "Ljava/util/concurrent/ConcurrentHashMap;", "<init>", "()V", "Companion", "a", "troop-guild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class TroopGuildUnreadCntServiceImpl extends Observable implements ITroopGuildUnreadCntService {

    @NotNull
    private static final String TAG = "TroopGuildUnreadCntServiceImpl";
    private AppRuntime mAppRuntime;

    @NotNull
    private final ConcurrentHashMap<String, uo4.f> mUnreadCntInfoCache = new ConcurrentHashMap<>();

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes7.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f381239a;

        static {
            int[] iArr = new int[GuildGroupSceneType.values().length];
            try {
                iArr[GuildGroupSceneType.KALL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[GuildGroupSceneType.KFEEDBASE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[GuildGroupSceneType.KFEEDNUMERIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f381239a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cleanTroopGuildUnreadHighLight$lambda$7(String troopUin, String guildId, int i3, String str) {
        Intrinsics.checkNotNullParameter(troopUin, "$troopUin");
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        QLog.d(TAG, 1, "cleanTroopGuildUnreadHighLight troopUin = " + troopUin + " guildId = " + guildId + " result = " + i3 + " errMsg = " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fetchUnreadCntInfo$lambda$8(String troopUin, String guildId, int i3, String str) {
        Intrinsics.checkNotNullParameter(troopUin, "$troopUin");
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        QLog.d(TAG, 1, "fetchUnreadCntInfo troopUin = " + troopUin + " guildId = " + guildId + " result = " + i3 + " errMsg = " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getUnreadCntInfo$lambda$10(String troopUin, String guildId, int i3, String str, ArrayList arrayList) {
        Integer num;
        Object firstOrNull;
        Intrinsics.checkNotNullParameter(troopUin, "$troopUin");
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        if (arrayList != null) {
            num = Integer.valueOf(arrayList.size());
        } else {
            num = null;
        }
        QLog.d(TAG, 1, "getUnreadCntInfo troopUin = " + troopUin + " guildId = " + guildId + " result = " + i3 + " errMsg = " + str + " cnt = {" + num + "}");
        if (arrayList != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList);
        }
    }

    private final void handleUnreadCntInfoUpdate(UnreadCntInfo unreadCntInfo) {
        uo4.f fVar = new uo4.f(true, unreadCntInfo);
        ConcurrentHashMap<String, uo4.f> concurrentHashMap = this.mUnreadCntInfoCache;
        String str = unreadCntInfo.peer.peerUid;
        Intrinsics.checkNotNullExpressionValue(str, "unreadCntInfo.peer.peerUid");
        concurrentHashMap.put(str, fVar);
        notifyUnreadCntInfoChanged(fVar);
    }

    private final void handleVerifyTroopInfoGuildId(UnreadCntInfo unreadCntInfo) {
        AppRuntime appRuntime = this.mAppRuntime;
        if (appRuntime == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAppRuntime");
            appRuntime = null;
        }
        ITroopGuildInfoService iTroopGuildInfoService = (ITroopGuildInfoService) appRuntime.getRuntimeService(ITroopGuildInfoService.class, "");
        String str = unreadCntInfo.peer.peerUid;
        Intrinsics.checkNotNullExpressionValue(str, "unreadCntInfo.peer.peerUid");
        String str2 = unreadCntInfo.peer.guildId;
        Intrinsics.checkNotNullExpressionValue(str2, "unreadCntInfo.peer.guildId");
        iTroopGuildInfoService.verifyTroopInfoGuildId(str, str2);
    }

    private final void notifyUnreadCntInfoChanged(final uo4.f troopGuildUnreadCntInfo) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.troopguild.api.impl.o
            @Override // java.lang.Runnable
            public final void run() {
                TroopGuildUnreadCntServiceImpl.notifyUnreadCntInfoChanged$lambda$11(uo4.f.this, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void notifyUnreadCntInfoChanged$lambda$11(uo4.f troopGuildUnreadCntInfo, TroopGuildUnreadCntServiceImpl this$0) {
        boolean z16;
        Intrinsics.checkNotNullParameter(troopGuildUnreadCntInfo, "$troopGuildUnreadCntInfo");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        UnreadCntInfo unreadCntInfo = troopGuildUnreadCntInfo.getUnreadCntInfo();
        String str = unreadCntInfo.peer.peerUid;
        int i3 = unreadCntInfo.showUnreadCnt.cnt;
        int i16 = unreadCntInfo.atmeUnreadCnt.cnt;
        int ordinal = unreadCntInfo.lastRelatedToFeedType.ordinal();
        long j3 = unreadCntInfo.relatedToMeStringTime;
        byte[] bArr = unreadCntInfo.headerUrl;
        Intrinsics.checkNotNullExpressionValue(bArr, "unreadCntInfo.headerUrl");
        if (bArr.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("notifyUnreadCntInfoChanged troopUin = ");
        sb5.append(str);
        sb5.append(" showCnt = ");
        sb5.append(i3);
        sb5.append(" atMeCnt = ");
        sb5.append(i16);
        sb5.append(" feedType = ");
        sb5.append(ordinal);
        sb5.append(" RelatedToMeTime = ");
        sb5.append(j3);
        sb5.append(" has headUrl: ");
        sb5.append(!z16);
        QLog.i(TAG, 1, sb5.toString());
        this$0.setChanged();
        this$0.notifyObservers(troopGuildUnreadCntInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setTroopGuildMsgRead$lambda$5(String troopUin, String guildId, int i3, String str) {
        Intrinsics.checkNotNullParameter(troopUin, "$troopUin");
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        QLog.d(TAG, 1, "setTroopGuildMsgRead troopUin = " + troopUin + " guildId = " + guildId + " result = " + i3 + " errMsg = " + str);
    }

    @Override // com.tencent.troopguild.api.ITroopGuildUnreadCntService
    public void addUnreadCntInfoObserver(@NotNull Observer observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        addObserver(observer);
    }

    @Override // com.tencent.troopguild.api.ITroopGuildUnreadCntService
    public void cleanTroopGuildUnreadHighLight(@NotNull final String troopUin) {
        ArrayList<SceneInfoParam> arrayListOf;
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        QLog.d(TAG, 1, "cleanTroopGuildUnreadHighLight troopUin = " + troopUin);
        uo4.f fVar = this.mUnreadCntInfoCache.get(troopUin);
        if (fVar != null) {
            UnreadCntInfo unreadCntInfo = fVar.getUnreadCntInfo();
            this.mUnreadCntInfoCache.put(troopUin, new uo4.f(fVar.getHasLoad(), new UnreadCntInfo(unreadCntInfo.showUnreadCnt, unreadCntInfo.allUnreadCnt, unreadCntInfo.atmeUnreadCnt, unreadCntInfo.atallUnreadCnt, unreadCntInfo.peer, unreadCntInfo.relatedToMeString, unreadCntInfo.relatedToMeCnt, unreadCntInfo.lastRelatedToMeType, unreadCntInfo.relatedToMeStringTime, GuildGroupOptType.KUNKNOWN, unreadCntInfo.headerUrl)));
        }
        final String troopGuildId = ((ITroopGuildApi) QRoute.api(ITroopGuildApi.class)).getTroopGuildId(troopUin);
        IMsgService iMsgService = (IMsgService) QRoute.api(IMsgService.class);
        Contact contact = new Contact(9, troopUin, troopGuildId);
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new SceneInfoParam(GuildGroupSceneType.KUNKNOWN.ordinal()));
        iMsgService.setGroupGuildMsgRead(contact, arrayListOf, true, false, new IOperateCallback() { // from class: com.tencent.troopguild.api.impl.m
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                TroopGuildUnreadCntServiceImpl.cleanTroopGuildUnreadHighLight$lambda$7(troopUin, troopGuildId, i3, str);
            }
        });
    }

    @Override // com.tencent.troopguild.api.ITroopGuildUnreadCntService
    public void deleteUnreadCntInfoObserver(@NotNull Observer observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        deleteObserver(observer);
    }

    @Override // com.tencent.troopguild.api.ITroopGuildUnreadCntService
    public void fetchUnreadCntInfo(@NotNull final String troopUin) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        QLog.d(TAG, 1, "fetchUnreadCntInfo troopUin = " + troopUin);
        final String troopGuildId = ((ITroopGuildApi) QRoute.api(ITroopGuildApi.class)).getTroopGuildId(troopUin);
        ((IMsgService) QRoute.api(IMsgService.class)).fetchGroupGuildUnread(new Contact(9, troopUin, troopGuildId), true, new IOperateCallback() { // from class: com.tencent.troopguild.api.impl.l
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                TroopGuildUnreadCntServiceImpl.fetchUnreadCntInfo$lambda$8(troopUin, troopGuildId, i3, str);
            }
        });
    }

    @Override // com.tencent.troopguild.api.ITroopGuildUnreadCntService
    @NotNull
    public uo4.f getUnreadCntInfo(@NotNull final String troopUin) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        uo4.f fVar = this.mUnreadCntInfoCache.get(troopUin);
        if (fVar != null) {
            return fVar;
        }
        uo4.f fVar2 = new uo4.f(false, new UnreadCntInfo());
        this.mUnreadCntInfoCache.put(troopUin, fVar2);
        final String troopGuildId = ((ITroopGuildApi) QRoute.api(ITroopGuildApi.class)).getTroopGuildId(troopUin);
        AppRuntime appRuntime = this.mAppRuntime;
        if (appRuntime == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAppRuntime");
            appRuntime = null;
        }
        uh2.c gProGuildMsgService = ((IGProSession) appRuntime.getRuntimeService(IGProSession.class, "")).getGProGuildMsgService();
        if (gProGuildMsgService != null) {
            gProGuildMsgService.p(new GProContact(9, troopUin, troopGuildId), new IUnreadCntCallback() { // from class: com.tencent.troopguild.api.impl.k
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IUnreadCntCallback
                public final void onResult(int i3, String str, ArrayList arrayList) {
                    TroopGuildUnreadCntServiceImpl.getUnreadCntInfo$lambda$10(troopUin, troopGuildId, i3, str, arrayList);
                }
            });
        }
        return fVar2;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(@NotNull AppRuntime appRuntime) {
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        this.mAppRuntime = appRuntime;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        deleteObservers();
    }

    @Override // com.tencent.troopguild.api.ITroopGuildUnreadCntService
    public void onUnreadCntUpdate(@Nullable HashMap<Integer, ArrayList<UnreadCntInfo>> unreadCntInfos) {
        ArrayList<UnreadCntInfo> value;
        if (unreadCntInfos != null) {
            for (Map.Entry<Integer, ArrayList<UnreadCntInfo>> entry : unreadCntInfos.entrySet()) {
                Integer key = entry.getKey();
                if (key != null && key.intValue() == 7 && (value = entry.getValue()) != null) {
                    for (UnreadCntInfo unreadCntInfo : value) {
                        if (unreadCntInfo != null) {
                            handleUnreadCntInfoUpdate(unreadCntInfo);
                            handleVerifyTroopInfoGuildId(unreadCntInfo);
                        }
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x014e  */
    @Override // com.tencent.troopguild.api.ITroopGuildUnreadCntService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setTroopGuildMsgRead(@NotNull String troopUin, @NotNull GuildGroupSceneType sceneType, boolean isDelete) {
        TroopGuildUnreadCntServiceImpl troopGuildUnreadCntServiceImpl;
        final String str;
        ArrayList<SceneInfoParam> arrayListOf;
        AppRuntime appRuntime;
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(sceneType, "sceneType");
        QLog.d(TAG, 1, "setTroopGuildMsgRead troopUin = " + troopUin + " sceneType = " + sceneType.ordinal() + ", isDelete: " + isDelete);
        uo4.f fVar = this.mUnreadCntInfoCache.get(troopUin);
        if (fVar != null) {
            UnreadCntInfo unreadCntInfo = fVar.getUnreadCntInfo();
            int i3 = b.f381239a[sceneType.ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        str = troopUin;
                        this.mUnreadCntInfoCache.put(str, new uo4.f(fVar.getHasLoad(), new UnreadCntInfo(unreadCntInfo.showUnreadCnt, unreadCntInfo.allUnreadCnt, new UnreadCnt(0, 0), unreadCntInfo.atallUnreadCnt, unreadCntInfo.peer, unreadCntInfo.relatedToMeString, unreadCntInfo.relatedToMeCnt, unreadCntInfo.lastRelatedToMeType, unreadCntInfo.relatedToMeStringTime, unreadCntInfo.lastRelatedToFeedType, unreadCntInfo.headerUrl)));
                    }
                } else {
                    str = troopUin;
                    this.mUnreadCntInfoCache.put(str, new uo4.f(fVar.getHasLoad(), new UnreadCntInfo(new UnreadCnt(0, 0), unreadCntInfo.allUnreadCnt, unreadCntInfo.atmeUnreadCnt, unreadCntInfo.atallUnreadCnt, unreadCntInfo.peer, unreadCntInfo.relatedToMeString, unreadCntInfo.relatedToMeCnt, unreadCntInfo.lastRelatedToMeType, unreadCntInfo.relatedToMeStringTime, unreadCntInfo.lastRelatedToFeedType, unreadCntInfo.headerUrl)));
                }
                troopGuildUnreadCntServiceImpl = this;
            } else {
                troopGuildUnreadCntServiceImpl = this;
                str = troopUin;
                troopGuildUnreadCntServiceImpl.mUnreadCntInfoCache.put(str, new uo4.f(fVar.getHasLoad(), new UnreadCntInfo()));
            }
            final String troopGuildId = ((ITroopGuildApi) QRoute.api(ITroopGuildApi.class)).getTroopGuildId(str);
            IMsgService iMsgService = (IMsgService) QRoute.api(IMsgService.class);
            Contact contact = new Contact(9, str, troopGuildId);
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new SceneInfoParam(sceneType.ordinal()));
            iMsgService.setGroupGuildMsgRead(contact, arrayListOf, false, isDelete, new IOperateCallback() { // from class: com.tencent.troopguild.api.impl.n
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i16, String str2) {
                    TroopGuildUnreadCntServiceImpl.setTroopGuildMsgRead$lambda$5(str, troopGuildId, i16, str2);
                }
            });
            if (sceneType != GuildGroupSceneType.KALL || sceneType == GuildGroupSceneType.KFEEDNUMERIC) {
                appRuntime = troopGuildUnreadCntServiceImpl.mAppRuntime;
                if (appRuntime == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAppRuntime");
                    appRuntime = null;
                }
                ((IConversationFacade) appRuntime.getRuntimeService(IConversationFacade.class, "")).updateTroopGuildUnreadCount(str, 1, 0);
            }
            return;
        }
        troopGuildUnreadCntServiceImpl = this;
        str = troopUin;
        final String troopGuildId2 = ((ITroopGuildApi) QRoute.api(ITroopGuildApi.class)).getTroopGuildId(str);
        IMsgService iMsgService2 = (IMsgService) QRoute.api(IMsgService.class);
        Contact contact2 = new Contact(9, str, troopGuildId2);
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new SceneInfoParam(sceneType.ordinal()));
        iMsgService2.setGroupGuildMsgRead(contact2, arrayListOf, false, isDelete, new IOperateCallback() { // from class: com.tencent.troopguild.api.impl.n
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i16, String str2) {
                TroopGuildUnreadCntServiceImpl.setTroopGuildMsgRead$lambda$5(str, troopGuildId2, i16, str2);
            }
        });
        if (sceneType != GuildGroupSceneType.KALL) {
        }
        appRuntime = troopGuildUnreadCntServiceImpl.mAppRuntime;
        if (appRuntime == null) {
        }
        ((IConversationFacade) appRuntime.getRuntimeService(IConversationFacade.class, "")).updateTroopGuildUnreadCount(str, 1, 0);
    }
}
