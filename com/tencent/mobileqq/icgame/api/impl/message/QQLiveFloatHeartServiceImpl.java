package com.tencent.mobileqq.icgame.api.impl.message;

import android.text.TextUtils;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.mobileqq.icgame.api.IQQLiveSDK;
import com.tencent.mobileqq.icgame.api.config.ICGameQMCCConfigKeysKt;
import com.tencent.mobileqq.icgame.api.config.IICGameConfigApi;
import com.tencent.mobileqq.icgame.api.gift.IQQLivePushCmdHelper;
import com.tencent.mobileqq.icgame.api.heart.IQQLiveFloatHeartService;
import com.tencent.mobileqq.icgame.api.login.IQQLiveModuleLogin;
import com.tencent.mobileqq.icgame.data.heart.FloatHeart;
import com.tencent.mobileqq.icgame.sso.g;
import com.tencent.mobileqq.icgame.sso.i;
import com.tencent.mobileqq.qqlive.data.heart.FreeLove;
import com.tencent.mobileqq.qqlive.data.heart.QLBroadCastFreeLove;
import com.tencent.mobileqq.qqlive.data.message.LiveMsgExtInfo;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public class QQLiveFloatHeartServiceImpl implements IQQLiveFloatHeartService {
    private static final long CLICK_HEART_INTERVAL_MS = 100;
    private static final int FLOAT_HEART_CMD = 15;
    private static final String FLOAT_HEART_METHOD = "UserLikeAction";
    private static final String FLOAT_HEART_SERVICE = "trpc.icggame.live_room_like_svr.LiveRoomLikeSvr";
    private static final String TAG = "ICGameFloatHeartService";
    private IQQLiveSDK liveSDK;
    private t32.b pushReceiver;
    private long sendRequestInterval;
    private IAegisLogApi log = (IAegisLogApi) QRoute.api(IAegisLogApi.class);
    private Set<ji2.a> listenerSet = new HashSet();
    private ArrayList<FloatHeart> clickedHeartList = new ArrayList<>();
    private long lastSendHeartTime = 0;
    private long lastTouchTime = 0;

    public QQLiveFloatHeartServiceImpl() {
        this.sendRequestInterval = 1000L;
        String rawConfig = ((IICGameConfigApi) QRoute.api(IICGameConfigApi.class)).getRawConfig(ICGameQMCCConfigKeysKt.KEY_ICGAME_LIVE_SDK_USER_LIKE_ACTION_INTERVAL, "");
        this.log.i(TAG, "config " + rawConfig);
        if (!TextUtils.isEmpty(rawConfig)) {
            try {
                this.sendRequestInterval = new JSONObject(rawConfig).optInt(WidgetCacheConstellationData.INTERVAL, 1000);
            } catch (JSONException e16) {
                this.log.e(TAG, "parse config failed", e16);
            }
        }
    }

    private long getSelfUid() {
        IQQLiveModuleLogin loginModule;
        LiveUserInfo userInfo;
        IQQLiveSDK iQQLiveSDK = this.liveSDK;
        if (iQQLiveSDK != null && (loginModule = iQQLiveSDK.getLoginModule()) != null && (userInfo = loginModule.getUserInfo()) != null) {
            return userInfo.uid;
        }
        return 0L;
    }

    private void initPush(IQQLiveSDK iQQLiveSDK) {
        t32.a aVar = (t32.a) iQQLiveSDK.getExtModule("roomPush");
        if (aVar == null) {
            this.log.e(TAG, "GET roomPushService NULL");
            return;
        }
        for (int i3 : ((IQQLivePushCmdHelper) QRoute.api(IQQLivePushCmdHelper.class)).getLowPriorityPushCmd(iQQLiveSDK.getAppId())) {
            this.pushReceiver = aVar.b().b(i3, new ni2.a() { // from class: com.tencent.mobileqq.icgame.api.impl.message.b
                @Override // ni2.a
                public final void onRecv(int i16, byte[] bArr, LiveMsgExtInfo liveMsgExtInfo) {
                    QQLiveFloatHeartServiceImpl.this.lambda$initPush$0(i16, bArr, liveMsgExtInfo);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initPush$0(int i3, byte[] bArr, LiveMsgExtInfo liveMsgExtInfo) {
        if (bArr == null) {
            this.log.e(TAG, "QQLive LiveRoomLikePushMsg onReceive data null");
            return;
        }
        try {
            cz0.a c16 = cz0.a.c(bArr);
            if (c16.f392433a != 15) {
                if (QLog.isColorLevel()) {
                    this.log.d(TAG, "get LOW_PRIORITY_MESSAGE but not like");
                    return;
                }
                return;
            }
            onFreeLoveMessageReceive(hz0.a.c(c16.f392435c));
        } catch (InvalidProtocolBufferNanoException unused) {
            this.log.e(TAG, "QQLive LiveRoomLikePushMsg onReceive data parse fail");
        }
    }

    private void onFreeLoveMessageReceive(hz0.a aVar) {
        if (QLog.isColorLevel()) {
            this.log.d(TAG, "[onFreeLoveMessageReceive] data:" + aVar);
        }
        QLBroadCastFreeLove qLBroadCastFreeLove = new QLBroadCastFreeLove();
        qLBroadCastFreeLove.roomId = aVar.f406943a;
        qLBroadCastFreeLove.headImg = aVar.f406946d;
        qLBroadCastFreeLove.roomMsg = aVar.f406947e;
        qLBroadCastFreeLove.userNick = aVar.f406945c;
        qLBroadCastFreeLove.uid = aVar.f406944b;
        qLBroadCastFreeLove.freeLoves = new ArrayList<>();
        for (int i3 = 0; i3 < aVar.f406948f.length; i3++) {
            FreeLove freeLove = new FreeLove();
            freeLove.loveType = aVar.f406948f[i3];
            freeLove.loveNum = 1;
            qLBroadCastFreeLove.freeLoves.add(freeLove);
        }
        for (ji2.a aVar2 : this.listenerSet) {
            aVar2.onReceiveRoomLikePush(qLBroadCastFreeLove);
            aVar2.onReceiveFreeLove(qLBroadCastFreeLove.uid, qLBroadCastFreeLove.freeLoves, Boolean.TRUE);
        }
    }

    private hz0.b packSendFreeLoveReq(FloatHeart floatHeart) {
        hz0.b bVar = new hz0.b();
        bVar.f406950b = floatHeart.roomId;
        bVar.f406954f = floatHeart.anchorId;
        int size = this.clickedHeartList.size();
        String[] strArr = new String[size];
        boolean z16 = false;
        for (int i3 = 0; i3 < this.clickedHeartList.size() && i3 < size; i3++) {
            FloatHeart floatHeart2 = this.clickedHeartList.get(i3);
            if (floatHeart2.firstLike) {
                z16 = true;
            }
            strArr[i3] = floatHeart2.materialId;
        }
        bVar.f406949a = z16;
        bVar.f406952d = strArr;
        bVar.f406951c = this.clickedHeartList.size();
        this.clickedHeartList.clear();
        return bVar;
    }

    private void sendRequest(FloatHeart floatHeart) {
        ((com.tencent.mobileqq.icgame.sso.c) this.liveSDK.getExtModule("sso_module")).f(FLOAT_HEART_SERVICE, FLOAT_HEART_METHOD, MessageNano.toByteArray(packSendFreeLoveReq(floatHeart)), new g() { // from class: com.tencent.mobileqq.icgame.api.impl.message.QQLiveFloatHeartServiceImpl.1
            @Override // com.tencent.mobileqq.icgame.sso.g
            public void onReceive(int i3, boolean z16, i iVar) {
                QQLiveFloatHeartServiceImpl.this.log.d(QQLiveFloatHeartServiceImpl.TAG, "[sendFloatHeart] onReceive:" + z16);
                if (!z16) {
                    QQLiveFloatHeartServiceImpl.this.log.e(QQLiveFloatHeartServiceImpl.TAG, "[sendFloatHeart] failed, code " + iVar.b() + ", proxy code " + iVar.g() + ", msg " + iVar.c());
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.icgame.api.heart.IQQLiveFloatHeartService
    public void addOnReceiveFloatHeartListener(ji2.a aVar) {
        if (aVar != null) {
            this.listenerSet.add(aVar);
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void destroy() {
        this.listenerSet.clear();
        t32.b bVar = this.pushReceiver;
        if (bVar != null) {
            bVar.a();
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void init(IQQLiveSDK iQQLiveSDK) {
        initPush(iQQLiveSDK);
        this.liveSDK = iQQLiveSDK;
    }

    @Override // com.tencent.mobileqq.icgame.api.heart.IQQLiveFloatHeartService
    public void removeOnReceiveFloatHeartListener(ji2.a aVar) {
        if (aVar != null) {
            this.listenerSet.remove(aVar);
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void reset() {
        this.listenerSet.clear();
        t32.b bVar = this.pushReceiver;
        if (bVar != null) {
            bVar.a();
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.heart.IQQLiveFloatHeartService
    public void sendFloatHeart(FloatHeart floatHeart) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.lastTouchTime < 100) {
            return;
        }
        this.lastTouchTime = currentTimeMillis;
        this.clickedHeartList.add(floatHeart);
        ArrayList<FreeLove> arrayList = new ArrayList<>();
        arrayList.add(new FreeLove(floatHeart.materialId, 1));
        Iterator<ji2.a> it = this.listenerSet.iterator();
        while (it.hasNext()) {
            it.next().onReceiveFreeLove(getSelfUid(), arrayList, Boolean.FALSE);
        }
        if (currentTimeMillis - this.lastSendHeartTime < this.sendRequestInterval) {
            return;
        }
        this.lastSendHeartTime = currentTimeMillis;
        if (this.liveSDK == null) {
            this.log.e(TAG, "[sendFloatHeart] liveSdk is null!");
        } else {
            sendRequest(floatHeart);
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.heart.IQQLiveFloatHeartService
    public void sendFloatHeartEnd() {
        if (this.clickedHeartList.isEmpty()) {
            return;
        }
        if (this.liveSDK == null) {
            this.log.e(TAG, "sendFloatHeartEnd liveSdk is null!");
        } else {
            this.lastSendHeartTime = System.currentTimeMillis();
            sendRequest(this.clickedHeartList.get(0));
        }
    }
}
