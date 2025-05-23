package com.tencent.mobileqq.nearby.api;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import appoint.define.appoint_define$InterestTag;
import com.gcloudsdk.gcloud.voice.GCloudVoiceErrorCode;
import com.tencent.biz.TroopRedpoint.TroopRedTouchManager;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.bs;
import com.tencent.mobileqq.app.cy;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.DynamicAvatar;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.managers.ShieldMsgManger;
import com.tencent.mobileqq.nearby.NearbyCardManager;
import com.tencent.mobileqq.nearby.interestTag.IInterestTagUtils;
import com.tencent.mobileqq.nearby.ipc.g;
import com.tencent.mobileqq.nearby.l;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.util.ao;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0x686.Oidb_0x686$CharmEvent;
import tencent.im.oidb.cmd0x686.Oidb_0x686$NearbyCharmNotify;
import tencent.im.oidb.cmd0x686.Oidb_0x686$NearbyFeedConfig;
import tencent.im.oidb.cmd0x686.Oidb_0x686$NearbyRankConfig;
import tencent.im.oidb.cmd0x8dd.oidb_0x8dd$SelfInfo;
import tencent.im.oidb.cmd0x9c7.cmd0x9c7$RspBody;

/* loaded from: classes33.dex */
public class NearbyProxy implements Manager, com.tencent.mobileqq.nearby.api.a {
    ConditionSearchManager.c C;
    private ArrayList<String> D;
    protected IFaceDecoder E;
    ao G;

    /* renamed from: d, reason: collision with root package name */
    QQAppInterface f252514d;

    /* renamed from: m, reason: collision with root package name */
    ConditionSearchManager f252519m;

    /* renamed from: e, reason: collision with root package name */
    List<g> f252515e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    List<g> f252516f = new ArrayList();
    protected HashSet<String> F = new HashSet<>();
    int H = 0;
    cy I = new c();
    bs J = new d();

    /* renamed from: h, reason: collision with root package name */
    MqqHandler f252517h = ThreadManager.getUIHandler();

    /* renamed from: i, reason: collision with root package name */
    MqqHandler f252518i = ThreadManager.getSubThreadHandler();

    /* loaded from: classes33.dex */
    class a implements ConditionSearchManager.c {
        a() {
        }

        @Override // com.tencent.mobileqq.app.ConditionSearchManager.c
        public void onGetConfig(int i3, boolean z16) {
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.DATING, 2, "onGetConfig, resultCode:" + i3 + ",isSuccess:" + z16);
            }
            NearbyProxy.this.q(4130, Integer.valueOf(i3), Boolean.valueOf(z16));
        }
    }

    /* loaded from: classes33.dex */
    class b implements DecodeTaskCompletionListener {
        b() {
        }

        @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
        public void onDecodeTaskCompleted(int i3, int i16, String str, Bitmap bitmap) {
            synchronized (NearbyProxy.this.F) {
                if (NearbyProxy.this.F.contains(str)) {
                    if (QLog.isColorLevel()) {
                        QLog.d("NearbyProxy", 2, "onDecodeTaskCompleted: reqUin=" + str + ", avatar=" + bitmap);
                    }
                    NearbyProxy.this.F.remove(str);
                    NearbyProxy.this.q(4160, Integer.valueOf(i16), str, bitmap);
                }
            }
        }
    }

    /* loaded from: classes33.dex */
    class d extends bs {
        d() {
        }

        @Override // com.tencent.mobileqq.app.bs
        protected void onInsertIntoBlackList(boolean z16, Object[] objArr) {
            if (((Integer) objArr[0]).intValue() != 1) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("NearbyProxy", 2, "onInsertIntoBlackList from nearby");
            }
            if (!z16 || objArr.length != 4) {
                NearbyProxy.this.q(4115, Boolean.FALSE);
                return;
            }
            ((Long) objArr[1]).longValue();
            String str = (String) objArr[2];
            ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).setValue(NearbyProxy.this.f252514d.getAccount(), "blacklist_sequence", Integer.valueOf(((Integer) objArr[3]).intValue()));
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(str));
            NearbyProxy nearbyProxy = NearbyProxy.this;
            nearbyProxy.f252514d.addObserver(nearbyProxy.I);
            ((ShieldMsgManger) NearbyProxy.this.f252514d.getManager(QQManagerFactory.SHIELD_LIST_MANAGER)).l(1001, arrayList, 1);
        }

        @Override // com.tencent.mobileqq.app.bs
        protected void onRemoveFromBlackList(boolean z16, String str, int i3) {
            if (i3 != 1) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("NearbyProxy", 2, "onRemoveFromBlackList from nearby");
            }
            if (!z16) {
                NearbyProxy.this.q(4116, Boolean.FALSE);
                return;
            }
            ShieldMsgManger shieldMsgManger = (ShieldMsgManger) NearbyProxy.this.f252514d.getManager(QQManagerFactory.SHIELD_LIST_MANAGER);
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(str));
            NearbyProxy nearbyProxy = NearbyProxy.this;
            nearbyProxy.f252514d.addObserver(nearbyProxy.I);
            shieldMsgManger.n(1001, arrayList, 1);
        }
    }

    public NearbyProxy(QQAppInterface qQAppInterface) {
        this.f252514d = qQAppInterface;
    }

    private Object[] p(int i3) {
        return com.tencent.mobileqq.nearby.ipc.a.b(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object[] q(int i3, Object... objArr) {
        return com.tencent.mobileqq.nearby.ipc.a.c(i3, objArr);
    }

    @Override // com.tencent.mobileqq.nearby.api.a
    public void a(Object obj) {
        cmd0x9c7$RspBody cmd0x9c7_rspbody = (cmd0x9c7$RspBody) obj;
        l.c(LogTag.NEARBY, "updateNearbyCard", cmd0x9c7_rspbody);
        if (cmd0x9c7_rspbody == null) {
            return;
        }
        List<appoint_define$InterestTag> list = cmd0x9c7_rspbody.rpt_msg_tags.has() ? cmd0x9c7_rspbody.rpt_msg_tags.get() : null;
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                m92.a aVar = (m92.a) ((IInterestTagUtils) QRoute.api(IInterestTagUtils.class)).convertFrom(list.get(i3));
                if (aVar != null) {
                    arrayList.add(aVar);
                }
            }
        }
        QQAppInterface qQAppInterface = this.f252514d;
        EntityManager createEntityManager = qQAppInterface.getEntityManagerFactory(qQAppInterface.getAccount()).createEntityManager();
        NearbyPeopleCard nearbyPeopleCard = (NearbyPeopleCard) DBMethodProxy.find(createEntityManager, NearbyPeopleCard.class, "uin=?", new String[]{this.f252514d.getCurrentAccountUin()});
        if (nearbyPeopleCard == null) {
            nearbyPeopleCard = new NearbyPeopleCard();
            nearbyPeopleCard.uin = this.f252514d.getCurrentAccountUin();
        }
        nearbyPeopleCard.updateInterestTags(nearbyPeopleCard.tagFlag, list);
        if (nearbyPeopleCard.getStatus() == 1000) {
            createEntityManager.persistOrReplace(nearbyPeopleCard);
        } else if (nearbyPeopleCard.getStatus() == 1001 || nearbyPeopleCard.getStatus() == 1002) {
            createEntityManager.update(nearbyPeopleCard);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:21:0x003e. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0169 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.tencent.mobileqq.nearby.api.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object[] b(Context context, int i3, Object... objArr) {
        RedTouchItem j3;
        byte[] bArr;
        Oidb_0x686$CharmEvent oidb_0x686$CharmEvent;
        Object obj;
        Oidb_0x686$NearbyCharmNotify oidb_0x686$NearbyCharmNotify;
        cmd0x9c7$RspBody cmd0x9c7_rspbody;
        byte[] bArr2;
        BusinessInfoCheckUpdate.RedTypeInfo u16;
        if (i3 == 4098) {
            n(false, objArr);
        } else if (i3 == 4099) {
            n(true, objArr);
        } else {
            if (i3 == 4104) {
                if (objArr == null) {
                    return null;
                }
                return new Object[]{Boolean.valueOf(((IRedTouchManager) this.f252514d.getRuntimeService(IRedTouchManager.class, "")).isNumRedTouchEnable(((Integer) objArr[0]).intValue()))};
            }
            if (i3 == 4105) {
                if (objArr == null) {
                    return null;
                }
                return new Object[]{((IRedTouchManager) this.f252514d.getRuntimeService(IRedTouchManager.class, "")).getAppInfoByPath((String) objArr[0]).toByteArray()};
            }
            if (i3 == 4131) {
                ((NearbyCardManager) this.f252514d.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)).s(true);
                return null;
            }
            if (i3 != 4144) {
                if (i3 == 4146) {
                    if (QLog.isColorLevel()) {
                        QLog.d("NearbyProxy", 2, "call preload now plugin!");
                    }
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.mobileqq.nearby.api.NearbyProxy.2
                        @Override // java.lang.Runnable
                        public void run() {
                            ((com.tencent.mobileqq.intervideo.now.dynamic.b) NearbyProxy.this.f252514d.getManager(QQManagerFactory.NOW_DYNAMIC_MANAGER)).preload();
                        }
                    });
                } else {
                    if (i3 == 4140) {
                        if (objArr == null || objArr.length != 1 || (j3 = ((LocalRedTouchManager) this.f252514d.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER)).j(((Integer) objArr[0]).intValue())) == null) {
                            return null;
                        }
                        return new Object[]{Integer.valueOf(j3.taskId), Long.valueOf(j3.curSeq), Integer.valueOf(j3.redtouchType), Integer.valueOf(j3.count), j3.icon, j3.tips, Long.valueOf(j3.receiveTime), Integer.valueOf(j3.validTimeRemained), Boolean.valueOf(j3.unReadFlag), Integer.valueOf(j3.passThroughLevel), j3.configVersion, Boolean.valueOf(j3.isClosed)};
                    }
                    if (i3 != 4141) {
                        switch (i3) {
                            case GCloudVoiceErrorCode.GCloudVoiceErrno.GCLOUD_VOICE_POLL_MSG_PARSE_ERR /* 4107 */:
                                if (objArr == null || objArr.length != 3) {
                                    return null;
                                }
                                return new Object[]{((com.tencent.mobileqq.dating.d) this.f252514d.getManager(QQManagerFactory.DATING_PROXY_MANAGER)).a().c((String) objArr[0], ((Integer) objArr[1]).intValue(), ((Boolean) objArr[2]).booleanValue())};
                            case GCloudVoiceErrorCode.GCloudVoiceErrno.GCLOUD_VOICE_POLL_MSG_NO /* 4108 */:
                                if (objArr != null && objArr.length >= 1) {
                                    Object obj2 = objArr[0];
                                    if (obj2 instanceof Byte) {
                                        g(((Byte) obj2).byteValue() == 0);
                                    }
                                }
                                return null;
                            case 4109:
                                if (objArr != null && objArr.length == 1) {
                                    Object obj3 = objArr[0];
                                    if ((obj3 instanceof byte[]) && (bArr = (byte[]) obj3) != null && bArr.length > 0) {
                                        try {
                                            oidb_0x8dd$SelfInfo oidb_0x8dd_selfinfo = new oidb_0x8dd$SelfInfo();
                                            oidb_0x8dd_selfinfo.mergeFrom(bArr);
                                            com.tencent.mobileqq.nearby.b bVar = (com.tencent.mobileqq.nearby.b) this.f252514d.getManager(QQManagerFactory.NEARBY_CARD_MANAGER);
                                            if (bVar != null) {
                                                bVar.h(oidb_0x8dd_selfinfo);
                                            }
                                        } catch (Exception e16) {
                                            e16.printStackTrace();
                                        }
                                    }
                                }
                                return null;
                            case 4110:
                                if (objArr == null || objArr.length < 2) {
                                    return new Object[]{Boolean.FALSE};
                                }
                                this.f252514d.addObserver(this.J);
                                ((MessageHandler) this.f252514d.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).n4(((Long) objArr[0]).longValue(), ((Integer) objArr[1]).intValue(), 1);
                                return new Object[]{Boolean.TRUE};
                            case 4111:
                                if (objArr == null || objArr.length < 1) {
                                    return new Object[]{Boolean.FALSE};
                                }
                                this.f252514d.addObserver(this.J);
                                ((MessageHandler) this.f252514d.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).T2((String) objArr[0], 1);
                                return new Object[]{Boolean.TRUE};
                            case 4112:
                                if (objArr == null || objArr.length < 1) {
                                    return null;
                                }
                                return new Object[]{Boolean.valueOf(((ShieldMsgManger) this.f252514d.getManager(QQManagerFactory.SHIELD_LIST_MANAGER)).h((String) objArr[0]))};
                            default:
                                switch (i3) {
                                    case 4119:
                                        if (objArr == null) {
                                            return null;
                                        }
                                        return new Object[]{Boolean.valueOf(RecentUtil.b(this.f252514d, (String) objArr[0]))};
                                    case 4120:
                                        if (objArr != null) {
                                            com.tencent.mobileqq.app.message.c.c(this.f252514d, (String) objArr[0], (String) objArr[1], ((Integer) objArr[2]).intValue(), ((Boolean) objArr[3]).booleanValue(), ((Boolean) objArr[4]).booleanValue());
                                            break;
                                        } else {
                                            return null;
                                        }
                                    case 4121:
                                        if (objArr != null) {
                                            com.tencent.mobileqq.app.message.c.a(this.f252514d, (String) objArr[0], (String) objArr[1], ((Integer) objArr[2]).intValue());
                                            break;
                                        } else {
                                            return null;
                                        }
                                    case 4122:
                                        if (objArr != null && objArr.length >= 3) {
                                            String str = (String) objArr[0];
                                            Object obj4 = objArr[1];
                                            if (obj4 != null) {
                                                try {
                                                    byte[] bArr3 = (byte[]) obj4;
                                                    oidb_0x686$CharmEvent = new Oidb_0x686$CharmEvent();
                                                    try {
                                                        oidb_0x686$CharmEvent.mergeFrom(bArr3);
                                                    } catch (Throwable unused) {
                                                    }
                                                } catch (Throwable unused2) {
                                                }
                                                obj = objArr[2];
                                                if (obj != null) {
                                                    try {
                                                        byte[] bArr4 = (byte[]) obj;
                                                        oidb_0x686$NearbyCharmNotify = new Oidb_0x686$NearbyCharmNotify();
                                                        try {
                                                            oidb_0x686$NearbyCharmNotify.mergeFrom(bArr4);
                                                        } catch (Throwable unused3) {
                                                        }
                                                    } catch (Throwable unused4) {
                                                    }
                                                    ((INearbyCardManagerUtils) QRoute.api(INearbyCardManagerUtils.class)).updateNearbyPeopleCard(this.f252514d, str, oidb_0x686$CharmEvent, oidb_0x686$NearbyCharmNotify);
                                                }
                                                oidb_0x686$NearbyCharmNotify = null;
                                                ((INearbyCardManagerUtils) QRoute.api(INearbyCardManagerUtils.class)).updateNearbyPeopleCard(this.f252514d, str, oidb_0x686$CharmEvent, oidb_0x686$NearbyCharmNotify);
                                            }
                                            oidb_0x686$CharmEvent = null;
                                            obj = objArr[2];
                                            if (obj != null) {
                                            }
                                            oidb_0x686$NearbyCharmNotify = null;
                                            ((INearbyCardManagerUtils) QRoute.api(INearbyCardManagerUtils.class)).updateNearbyPeopleCard(this.f252514d, str, oidb_0x686$CharmEvent, oidb_0x686$NearbyCharmNotify);
                                        }
                                        return null;
                                    case 4123:
                                        if (objArr != null && objArr.length >= 1) {
                                            try {
                                                bArr2 = (byte[]) objArr[0];
                                                cmd0x9c7_rspbody = new cmd0x9c7$RspBody();
                                            } catch (Exception e17) {
                                                e = e17;
                                                cmd0x9c7_rspbody = null;
                                            }
                                            try {
                                                cmd0x9c7_rspbody.mergeFrom(bArr2);
                                            } catch (Exception e18) {
                                                e = e18;
                                                e.printStackTrace();
                                                a(cmd0x9c7_rspbody);
                                                return null;
                                            }
                                            a(cmd0x9c7_rspbody);
                                        }
                                        return null;
                                    default:
                                        switch (i3) {
                                            case 4127:
                                                if (this.f252519m == null) {
                                                    this.f252519m = (ConditionSearchManager) this.f252514d.getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER);
                                                }
                                                this.C = new a();
                                                this.f252519m.h(this);
                                                this.f252519m.g(this.C);
                                                return null;
                                            case 4128:
                                                if (objArr != null && objArr.length == 1) {
                                                    String str2 = (String) objArr[0];
                                                    ConditionSearchManager conditionSearchManager = this.f252519m;
                                                    if (conditionSearchManager != null) {
                                                        return new Object[]{conditionSearchManager.N(str2.split("-"))};
                                                    }
                                                }
                                                return null;
                                            case 4129:
                                                ConditionSearchManager conditionSearchManager2 = this.f252519m;
                                                if (conditionSearchManager2 == null) {
                                                    return null;
                                                }
                                                conditionSearchManager2.o(this);
                                                ConditionSearchManager.c cVar = this.C;
                                                if (cVar != null) {
                                                    this.f252519m.S(cVar);
                                                }
                                                return null;
                                            default:
                                                switch (i3) {
                                                    case 4155:
                                                        if (QLog.isColorLevel()) {
                                                            QLog.d("NearbyProxy", 2, "MSG_GET_NOW_SEX_INFO!");
                                                        }
                                                        FriendsManager friendsManager = (FriendsManager) this.f252514d.getManager(QQManagerFactory.FRIENDS_MANAGER);
                                                        Card r16 = friendsManager == null ? null : friendsManager.r(this.f252514d.getCurrentAccountUin());
                                                        if (r16 != null) {
                                                            return new Object[]{Short.valueOf(r16.shGender)};
                                                        }
                                                        break;
                                                    case 4156:
                                                        Integer num = (Integer) objArr[0];
                                                        TroopRedTouchManager troopRedTouchManager = (TroopRedTouchManager) this.f252514d.getManager(QQManagerFactory.MGR_RED_TOUCH_EX);
                                                        switch (num.intValue()) {
                                                            case 1:
                                                                u16 = troopRedTouchManager.u();
                                                                break;
                                                            case 2:
                                                                u16 = troopRedTouchManager.s();
                                                                break;
                                                            case 3:
                                                                u16 = troopRedTouchManager.o();
                                                                break;
                                                            case 5:
                                                                if (troopRedTouchManager.x()) {
                                                                    u16 = new BusinessInfoCheckUpdate.RedTypeInfo();
                                                                    break;
                                                                }
                                                            case 4:
                                                            case 6:
                                                            case 7:
                                                            case 8:
                                                            case 11:
                                                            default:
                                                                u16 = null;
                                                                break;
                                                            case 9:
                                                                u16 = troopRedTouchManager.j();
                                                                break;
                                                            case 10:
                                                                u16 = troopRedTouchManager.m();
                                                                break;
                                                            case 12:
                                                                u16 = troopRedTouchManager.i();
                                                                break;
                                                        }
                                                        if (u16 != null) {
                                                            return new Object[]{u16.toByteArray()};
                                                        }
                                                        break;
                                                    case 4157:
                                                        ((TroopRedTouchManager) this.f252514d.getManager(QQManagerFactory.MGR_RED_TOUCH_EX)).c(((Integer) objArr[0]).intValue());
                                                        break;
                                                }
                                        }
                                }
                        }
                    } else if (objArr != null && objArr.length == 1) {
                        ((DynamicAvatarManager) this.f252514d.getManager(QQManagerFactory.DYNAMIC_AVATAR_MANAGER)).g((byte[]) objArr[0]);
                        if (QLog.isColorLevel()) {
                            QLog.i(LogTag.TAG_DYNAMIC_AVATAR, 2, "handle ipc msg: save dynamic info 2 db.");
                        }
                    }
                }
            } else if (objArr != null) {
                String str3 = (String) objArr[0];
                ((com.tencent.mobileqq.nearby.b) this.f252514d.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)).c().put(str3, 1);
                if (QLog.isColorLevel()) {
                    QLog.i("MSG_SHOULD_REFRESH_CARD_MSG", 2, "handle ipc msg: MSG_SHOULD_REFRESH_CARD_MSG uin:" + str3);
                }
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.nearby.api.a
    public void c(String str, Object obj, Object obj2, Object obj3, Object obj4) {
        int i3;
        Oidb_0x686$NearbyRankConfig oidb_0x686$NearbyRankConfig = (Oidb_0x686$NearbyRankConfig) obj;
        Oidb_0x686$NearbyFeedConfig oidb_0x686$NearbyFeedConfig = (Oidb_0x686$NearbyFeedConfig) obj2;
        Oidb_0x686$CharmEvent oidb_0x686$CharmEvent = (Oidb_0x686$CharmEvent) obj3;
        Oidb_0x686$NearbyCharmNotify oidb_0x686$NearbyCharmNotify = (Oidb_0x686$NearbyCharmNotify) obj4;
        ((INearbyCardManagerUtils) QRoute.api(INearbyCardManagerUtils.class)).updateNearbyPeopleCard(this.f252514d, str, oidb_0x686$CharmEvent, oidb_0x686$NearbyCharmNotify);
        if (oidb_0x686$CharmEvent != null) {
            i3 = oidb_0x686$CharmEvent.uint32_new_charm_level.get();
        } else {
            i3 = oidb_0x686$NearbyCharmNotify != null ? oidb_0x686$NearbyCharmNotify.uint32_new_charm_level.get() : 0;
        }
        if (com.tencent.mobileqq.nearby.ipc.a.a()) {
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(i3);
            objArr[1] = oidb_0x686$NearbyRankConfig == null ? null : oidb_0x686$NearbyRankConfig.toByteArray();
            objArr[2] = oidb_0x686$NearbyFeedConfig != null ? oidb_0x686$NearbyFeedConfig.toByteArray() : null;
            q(4122, objArr);
        }
    }

    @Override // com.tencent.mobileqq.nearby.api.a
    public boolean h() {
        if (this.H == 0) {
            this.H = ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).getDatingSessionSwitch(this.f252514d.getCurrentAccountUin()) ? 3 : 4;
        }
        int i3 = this.H;
        return i3 == 1 || i3 == 3;
    }

    @Override // com.tencent.mobileqq.nearby.api.a
    public void i(String str) {
        if (m() == null) {
            r(new ArrayList<>());
        }
        if (m().contains(str)) {
            return;
        }
        m().add(str);
    }

    public synchronized ao l() {
        if (this.G == null) {
            this.G = new ao(this.f252514d);
        }
        return this.G;
    }

    public ArrayList<String> m() {
        return this.D;
    }

    public void o(final int i3, final Object... objArr) {
        int i16;
        synchronized (this.f252515e) {
            for (int i17 = 0; i17 < this.f252515e.size(); i17++) {
                final g gVar = this.f252515e.get(i17);
                this.f252517h.post(new Runnable() { // from class: com.tencent.mobileqq.nearby.api.NearbyProxy.4
                    @Override // java.lang.Runnable
                    public void run() {
                        gVar.d(i3, objArr);
                    }
                });
            }
            if (i3 == 4124) {
                Iterator<g> it = this.f252515e.iterator();
                while (it.hasNext()) {
                    g next = it.next();
                    if (next != null && next.a()) {
                        it.remove();
                    }
                }
            }
        }
        synchronized (this.f252516f) {
            for (i16 = 0; i16 < this.f252516f.size(); i16++) {
                final g gVar2 = this.f252516f.get(i16);
                this.f252518i.post(new Runnable() { // from class: com.tencent.mobileqq.nearby.api.NearbyProxy.5
                    @Override // java.lang.Runnable
                    public void run() {
                        gVar2.d(i3, objArr);
                    }
                });
            }
            if (i3 == 4124) {
                Iterator<g> it5 = this.f252516f.iterator();
                while (it5.hasNext()) {
                    g next2 = it5.next();
                    if (next2 != null && next2.a()) {
                        it5.remove();
                    }
                }
            }
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        this.f252515e.clear();
        this.f252516f.clear();
        this.f252514d.removeObserver(this.I);
        this.f252514d.removeObserver(this.J);
        IFaceDecoder iFaceDecoder = this.E;
        if (iFaceDecoder != null) {
            iFaceDecoder.destory();
        }
    }

    public void r(ArrayList<String> arrayList) {
        this.D = arrayList;
    }

    @Override // com.tencent.mobileqq.nearby.api.a
    public void g(boolean z16) {
        com.tencent.mobileqq.dating.f.i("setNearbyDatingMsg", Boolean.valueOf(z16), Integer.valueOf(this.H));
        int i3 = this.H;
        boolean z17 = i3 == 1 || i3 == 3;
        if (i3 == 0 || z17 != z16) {
            ((INearbySPUtil) QRoute.api(INearbySPUtil.class)).setValue(this.f252514d.getAccount(), "dating_recv_msg", Boolean.valueOf(z16));
        }
        this.H = z16 ? 1 : 2;
    }

    /* loaded from: classes33.dex */
    class c extends cy {
        c() {
        }

        @Override // com.tencent.mobileqq.app.cy
        protected void b(boolean z16, List<Long> list, int i3) {
            if (i3 == 1) {
                if (QLog.isColorLevel()) {
                    QLog.d("NearbyProxy", 2, "onAddShieldList from nearby");
                }
                NearbyProxy.this.q(4113, Boolean.valueOf(z16), list);
            }
        }

        @Override // com.tencent.mobileqq.app.cy
        protected void d(boolean z16, List<Long> list, int i3) {
            if (i3 == 1) {
                if (QLog.isColorLevel()) {
                    QLog.d("NearbyProxy", 2, "onDeleteShieldList from nearby");
                }
                NearbyProxy.this.q(4114, Boolean.valueOf(z16), list);
            }
        }
    }

    @Override // com.tencent.mobileqq.nearby.api.a
    public void d() {
        p(4158);
    }

    @Override // com.tencent.mobileqq.nearby.api.a
    public void j() {
        p(4139);
    }

    @Override // com.tencent.mobileqq.nearby.api.a
    public void f() {
        o(4124, null);
    }

    @Override // com.tencent.mobileqq.nearby.api.a
    public Message e(Context context, Message message) {
        if (message == null) {
            return null;
        }
        Bundle data = message.getData();
        int i3 = message.what;
        if (i3 == 4118) {
            if (data == null) {
                return null;
            }
            Bundle a16 = l().a(data);
            Message obtain = Message.obtain();
            obtain.setData(a16);
            return obtain;
        }
        if (i3 == 4142) {
            if (QLog.isColorLevel()) {
                QLog.i(LogTag.TAG_DYNAMIC_AVATAR, 2, "handle ipc msg get dynamic_avatar_info.");
            }
            Message obtain2 = Message.obtain();
            Bundle data2 = message.getData();
            DynamicAvatar i16 = ((DynamicAvatarManager) this.f252514d.getManager(QQManagerFactory.DYNAMIC_AVATAR_MANAGER)).i(data2.getInt("type"), data2.getString("id"));
            if (i16 == null) {
                return null;
            }
            Bundle bundle = new Bundle();
            data2.putParcelable("avatarInfo", i16);
            obtain2.setData(bundle);
            return obtain2;
        }
        if (i3 != 4159) {
            return null;
        }
        if (QLog.isColorLevel()) {
            QLog.i(LogTag.TAG_DYNAMIC_AVATAR, 2, "handle ipc msg get face bitmap");
        }
        try {
            Message obtain3 = Message.obtain();
            Bundle data3 = message.getData();
            String string = data3.getString("uin");
            int i17 = data3.getInt("headType");
            data3.getBoolean("appendToTail");
            if (this.E == null) {
                IFaceDecoder iQQAvatarService = ((IQQAvatarService) this.f252514d.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.f252514d);
                this.E = iQQAvatarService;
                iQQAvatarService.setDecodeTaskCompletionListener(new b());
            }
            Bitmap bitmapFromCache = this.E.getBitmapFromCache(i17, string, 200);
            if (bitmapFromCache == null) {
                synchronized (this.F) {
                    this.F.add(string);
                }
                this.E.requestDecodeFace(string, i17, true);
                return null;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("faceBmp", bitmapFromCache);
            obtain3.setData(bundle2);
            return obtain3;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("NearbyProxy", 2, "MSG_GET_FACE_BITMAP exception:" + e16);
            }
            return null;
        }
    }

    void n(boolean z16, Object... objArr) {
        if (objArr == null) {
            return;
        }
        if (z16) {
            ReportController.o(this.f252514d, (String) objArr[0], (String) objArr[1], (String) objArr[2], (String) objArr[3], (String) objArr[4], ((Integer) objArr[5]).intValue(), ((Integer) objArr[6]).intValue(), (String) objArr[7], (String) objArr[8], (String) objArr[9], (String) objArr[10]);
        } else {
            ReportController.o(this.f252514d, (String) objArr[0], (String) objArr[1], (String) objArr[2], (String) objArr[3], (String) objArr[4], ((Integer) objArr[5]).intValue(), ((Integer) objArr[6]).intValue(), (String) objArr[7], (String) objArr[8], (String) objArr[9], (String) objArr[10]);
        }
    }
}
