package com.tencent.icgame.api.impl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import av0.l;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.icgame.api.ITimiGameApi;
import com.tencent.icgame.game.api.live.LiveRoomExtraInfo;
import com.tencent.icgame.game.gift.impl.timi.IGiftPanelExtBean;
import com.tencent.icgame.game.liveroom.impl.ipc.TGLiveClientQIPCModule;
import com.tencent.icgame.game.utils.g;
import com.tencent.icgame.game.utils.k;
import com.tencent.mobileqq.icgame.api.config.QQLiveSDKConfigHelper;
import com.tencent.mobileqq.icgame.api.room.IAudienceRoom;
import com.tencent.mobileqq.icgame.data.room.LiveInfo;
import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveRoomInfo;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import fu0.c;
import fu0.d;
import fu0.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0016\u0018\u0000 12\u00020\u0001:\u000223B\u0007\u00a2\u0006\u0004\b/\u00100J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u0002H\u0016J0\u0010\"\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\fH\u0016J\u0010\u0010#\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\bH\u0016J\u0010\u0010$\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\bH\u0016J\u0010\u0010&\u001a\u00020\f2\u0006\u0010%\u001a\u00020\u001eH\u0016R\"\u0010'\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b\u0003\u0010+R\"\u0010,\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010(\u001a\u0004\b-\u0010*\"\u0004\b.\u0010+\u00a8\u00064"}, d2 = {"Lcom/tencent/icgame/api/impl/TimiGameApiImpl;", "Lcom/tencent/icgame/api/ITimiGameApi;", "", "setHasCalledBusiness", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "roomId", "", "roomType", "Lcom/tencent/icgame/api/impl/TimiGameApiImpl$b;", "getCurAnchorTriple", "", "loginOrReconnect", "doWhenQQLogin", "doWhenQQLogout", "Landroid/content/Context;", "context", "initLiveModule", "destroyLiveModule", "Lau0/a;", "getLiveReportUtil", "subSceneId", "openGiftPanelFragmentFromActivity", "Lcom/tencent/icgame/game/api/live/LiveRoomExtraInfo;", "roomExtraInfo", "recordLiveRoomExtraData", "registerTGLiveQIPCModule", "businessId", "panelType", "", "gameType", "anchorId", "needPanelRes", "preloadGiftRes", "initGiftSdk", "destroySdk", "moduleName", "isTimiModule", "hasCalledBusiness", "Z", "getHasCalledBusiness", "()Z", "(Z)V", "hasInitLiveModule", "getHasInitLiveModule", "setHasInitLiveModule", "<init>", "()V", "Companion", "a", "b", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class TimiGameApiImpl implements ITimiGameApi {

    @NotNull
    public static final String TAG = "ICGameUnknown|ICGameGameApiImpl_";
    private boolean hasCalledBusiness;
    private boolean hasInitLiveModule;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012&\u0010\u0013\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u000fj\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u0001`\u0010\u00a2\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u0003\u0010\u000bR7\u0010\u0013\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u000fj\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u0001`\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\r\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/icgame/api/impl/TimiGameApiImpl$b;", "", "", "a", "J", "d", "()J", "userId", "", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "nickName", "c", "headUrl", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "()Ljava/util/HashMap;", "tranMap", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/util/HashMap;)V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final long userId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String nickName;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String headUrl;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final HashMap<String, String> tranMap;

        public b(long j3, @NotNull String nickName, @NotNull String headUrl, @Nullable HashMap<String, String> hashMap) {
            Intrinsics.checkNotNullParameter(nickName, "nickName");
            Intrinsics.checkNotNullParameter(headUrl, "headUrl");
            this.userId = j3;
            this.nickName = nickName;
            this.headUrl = headUrl;
            this.tranMap = hashMap;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getHeadUrl() {
            return this.headUrl;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getNickName() {
            return this.nickName;
        }

        @Nullable
        public final HashMap<String, String> c() {
            return this.tranMap;
        }

        /* renamed from: d, reason: from getter */
        public final long getUserId() {
            return this.userId;
        }
    }

    private final b getCurAnchorTriple(Activity activity, long roomId, int roomType) {
        long j3;
        String str;
        String str2;
        String str3;
        e n3 = ((c) qx0.a.b(c.class)).n(roomId);
        if (n3 != null) {
            j3 = n3.getAnchorUid();
        } else {
            j3 = 0;
        }
        long j16 = j3;
        String str4 = null;
        if (n3 != null) {
            str = n3.f400637b;
        } else {
            str = null;
        }
        if (str == null) {
            str2 = "";
        } else {
            str2 = str;
        }
        if (n3 != null) {
            str4 = n3.f400638c;
        }
        if (str4 == null) {
            str3 = "";
        } else {
            str3 = str4;
        }
        return new b(j16, str2, str3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initLiveModule$lambda$1() {
        final Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = System.currentTimeMillis();
        ((ev0.b) qx0.a.b(ev0.b.class)).v3(new ev0.a() { // from class: com.tencent.icgame.api.impl.a
            @Override // ev0.a
            public final void a(boolean z16) {
                TimiGameApiImpl.initLiveModule$lambda$1$lambda$0(Ref.LongRef.this, z16);
            }
        });
        TGLiveClientQIPCModule.INSTANCE.a().registerModule();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initLiveModule$lambda$1$lambda$0(Ref.LongRef startTime, boolean z16) {
        Intrinsics.checkNotNullParameter(startTime, "$startTime");
        g.h(TAG, "initLiveModule syncEnsureInit costTime = " + (System.currentTimeMillis() - startTime.element));
    }

    @Override // com.tencent.icgame.api.ITimiGameApi
    public void destroyLiveModule() {
        g.d(TAG, "destroyLiveModule start - " + this.hasInitLiveModule);
        this.hasInitLiveModule = false;
        ((c) qx0.a.b(c.class)).O1();
        ((ev0.b) qx0.a.b(ev0.b.class)).w();
        qx0.a.a();
        g.d(TAG, "destroyLiveModule end");
    }

    @Override // com.tencent.icgame.api.ITimiGameApi
    public void destroySdk(int businessId) {
        com.tencent.icgame.game.initer.impl.b.f115068a.a(businessId);
    }

    @Override // com.tencent.icgame.api.ITimiGameApi
    public void doWhenQQLogout() {
        g.d("YesApiImpl", "doWhenQQLogout, hasCalledBiz = " + this.hasCalledBusiness);
        if (this.hasCalledBusiness) {
            ((ev0.b) qx0.a.b(ev0.b.class)).w();
        }
    }

    public final boolean getHasCalledBusiness() {
        return this.hasCalledBusiness;
    }

    public final boolean getHasInitLiveModule() {
        return this.hasInitLiveModule;
    }

    @Override // com.tencent.icgame.api.ITimiGameApi
    @NotNull
    public au0.a getLiveReportUtil() {
        return ((ru0.a) qx0.a.b(ru0.a.class)).u();
    }

    @Override // com.tencent.icgame.api.ITimiGameApi
    public void initGiftSdk(int businessId) {
        com.tencent.icgame.game.initer.impl.b.f115068a.d(businessId);
    }

    @Override // com.tencent.icgame.api.ITimiGameApi
    public void initLiveModule(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        g.h(TAG, "initLiveModule - " + context + " - " + this.hasInitLiveModule);
        if (this.hasInitLiveModule) {
            return;
        }
        this.hasInitLiveModule = true;
        k.a(new Runnable() { // from class: com.tencent.icgame.api.impl.b
            @Override // java.lang.Runnable
            public final void run() {
                TimiGameApiImpl.initLiveModule$lambda$1();
            }
        });
    }

    @Override // com.tencent.icgame.api.ITimiGameApi
    public boolean isTimiModule(@NotNull String moduleName) {
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        return TextUtils.equals(moduleName, HippyQQConstants.ModuleName.QQ_NEARBY_GAME);
    }

    @Override // com.tencent.icgame.api.ITimiGameApi
    public void openGiftPanelFragmentFromActivity(int subSceneId, @NotNull Activity activity) {
        boolean z16;
        long j3;
        LiveRoomExtraInfo liveRoomExtraInfo;
        boolean z17;
        int i3;
        String str;
        Long l3;
        Integer num;
        String str2;
        TimiGameApiImpl timiGameApiImpl;
        int i16;
        long j16;
        int i17;
        long j17;
        String str3;
        String str4;
        String str5;
        String str6;
        long j18;
        int i18;
        String str7;
        String str8;
        String str9;
        String str10;
        Set<Map.Entry<String, String>> entries;
        LiveRoomInfo liveRoomInfo;
        Bundle bundle;
        Intrinsics.checkNotNullParameter(activity, "activity");
        d s16 = ((c) qx0.a.b(c.class)).s();
        int i19 = 0;
        if (s16 != null && !s16.b()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return;
        }
        BaseRoomInfo q16 = ((c) qx0.a.b(c.class)).q(0L);
        if (q16 != null) {
            j3 = q16.getRoomId();
        } else {
            j3 = 0;
        }
        LiveUserInfo selfUserInfo = ((c) qx0.a.b(c.class)).getSelfUserInfo();
        LiveInfo d16 = s16.d(j3);
        if (d16 != null && (liveRoomInfo = d16.roomInfo) != null && (bundle = liveRoomInfo.extData) != null) {
            liveRoomExtraInfo = (LiveRoomExtraInfo) bundle.getParcelable("live_room_extra_data");
        } else {
            liveRoomExtraInfo = null;
        }
        if (liveRoomExtraInfo != null && liveRoomExtraInfo.f114882f == 1) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        LiveUserInfo selfUserInfo2 = ((c) qx0.a.b(c.class)).getSelfUserInfo();
        IAudienceRoom N = ((c) qx0.a.b(c.class)).N(j3);
        if (N == null || (str = Long.valueOf(N.getEnterRoomTime()).toString()) == null) {
            str = "0";
        }
        if (selfUserInfo2 != null) {
            l3 = Long.valueOf(selfUserInfo2.uid);
        } else {
            l3 = null;
        }
        String str11 = l3 + "_" + j3 + "_" + str;
        if (liveRoomExtraInfo != null) {
            num = Integer.valueOf(liveRoomExtraInfo.f114882f);
        } else {
            num = null;
        }
        if (num != null && num.intValue() == 1) {
            str2 = "QQ\u6e38\u620f";
        } else {
            str2 = "QQ\u5a31\u4e50";
        }
        String str12 = str2;
        if (num != null) {
            i16 = num.intValue();
            timiGameApiImpl = this;
        } else {
            timiGameApiImpl = this;
            i16 = 0;
        }
        b curAnchorTriple = timiGameApiImpl.getCurAnchorTriple(activity, j3, i16);
        if (curAnchorTriple == null) {
            return;
        }
        l.Companion companion = l.INSTANCE;
        int sceneId = QQLiveSDKConfigHelper.getSceneId();
        if (q16 != null) {
            j16 = q16.getRoomId();
        } else {
            j16 = 0;
        }
        if (liveRoomExtraInfo != null) {
            i17 = liveRoomExtraInfo.f114882f;
        } else {
            i17 = 0;
        }
        if (selfUserInfo != null) {
            j17 = selfUserInfo.uid;
        } else {
            j17 = 0;
        }
        if (selfUserInfo != null) {
            str3 = selfUserInfo.nick;
        } else {
            str3 = null;
        }
        if (str3 == null) {
            str4 = "";
        } else {
            str4 = str3;
        }
        if (selfUserInfo != null) {
            str5 = selfUserInfo.headUrl;
        } else {
            str5 = null;
        }
        if (str5 == null) {
            str6 = "";
        } else {
            str6 = str5;
        }
        long userId = curAnchorTriple.getUserId();
        String nickName = curAnchorTriple.getNickName();
        String headUrl = curAnchorTriple.getHeadUrl();
        long j19 = j16;
        if (liveRoomExtraInfo != null) {
            j18 = liveRoomExtraInfo.f114885m;
        } else {
            j18 = 0;
        }
        String valueOf = String.valueOf(j18);
        if (liveRoomExtraInfo != null) {
            i18 = liveRoomExtraInfo.f114883h;
        } else {
            i18 = 0;
        }
        String valueOf2 = String.valueOf(i18);
        if (q16 != null) {
            str7 = q16.getProgramId();
        } else {
            str7 = null;
        }
        if (str7 == null) {
            str8 = "";
        } else {
            str8 = str7;
        }
        String qQLiveAppId = QQLiveSDKConfigHelper.getQQLiveAppId();
        Intrinsics.checkNotNullExpressionValue(qQLiveAppId, "getQQLiveAppId()");
        if (liveRoomExtraInfo != null) {
            str9 = liveRoomExtraInfo.D;
        } else {
            str9 = null;
        }
        if (str9 == null) {
            str10 = "";
        } else {
            str10 = str9;
        }
        if (liveRoomExtraInfo != null) {
            i19 = liveRoomExtraInfo.f114883h;
        }
        String valueOf3 = String.valueOf(i19);
        ArrayList<IGiftPanelExtBean> arrayList = new ArrayList<>();
        HashMap<String, String> c16 = curAnchorTriple.c();
        if (c16 != null && (entries = c16.entrySet()) != null) {
            Intrinsics.checkNotNullExpressionValue(entries, "entries");
            Iterator<T> it = entries.iterator();
            while (it.hasNext()) {
                final Map.Entry entry = (Map.Entry) it.next();
                arrayList.add(new IGiftPanelExtBean() { // from class: com.tencent.icgame.api.impl.TimiGameApiImpl$openGiftPanelFragmentFromActivity$1$1$1
                    @Override // com.tencent.icgame.game.gift.impl.timi.IGiftPanelExtBean
                    @NotNull
                    public String getKey() {
                        String key = entry.getKey();
                        Intrinsics.checkNotNullExpressionValue(key, "e.key");
                        return key;
                    }

                    @Override // com.tencent.icgame.game.gift.impl.timi.IGiftPanelExtBean
                    @NotNull
                    public String getValue() {
                        String value = entry.getValue();
                        Intrinsics.checkNotNullExpressionValue(value, "e.value");
                        return value;
                    }
                });
            }
        }
        Unit unit = Unit.INSTANCE;
        companion.e(activity, false, sceneId, j19, i17, j17, str4, str6, userId, nickName, headUrl, valueOf, valueOf2, str8, qQLiveAppId, str10, valueOf3, i3, subSceneId, str11, "1", "\u793c\u7269", str12, arrayList);
    }

    @Override // com.tencent.icgame.api.ITimiGameApi
    public void preloadGiftRes(int businessId, int panelType, @NotNull String gameType, @NotNull String anchorId, boolean needPanelRes) {
        Intrinsics.checkNotNullParameter(gameType, "gameType");
        Intrinsics.checkNotNullParameter(anchorId, "anchorId");
        com.tencent.icgame.game.initer.impl.b.f115068a.e(businessId, panelType, gameType, anchorId, needPanelRes);
    }

    @Override // com.tencent.icgame.api.ITimiGameApi
    public void recordLiveRoomExtraData(@NotNull LiveRoomExtraInfo roomExtraInfo) {
        Intrinsics.checkNotNullParameter(roomExtraInfo, "roomExtraInfo");
        ((c) qx0.a.b(c.class)).y0(roomExtraInfo);
    }

    @Override // com.tencent.icgame.api.ITimiGameApi
    public void registerTGLiveQIPCModule() {
        TGLiveClientQIPCModule.INSTANCE.a().registerModule();
    }

    public final void setHasCalledBusiness(boolean z16) {
        this.hasCalledBusiness = z16;
    }

    public final void setHasInitLiveModule(boolean z16) {
        this.hasInitLiveModule = z16;
    }

    private final void setHasCalledBusiness() {
        this.hasCalledBusiness = true;
    }

    @Override // com.tencent.icgame.api.ITimiGameApi
    public void doWhenQQLogin(boolean loginOrReconnect) {
    }
}
