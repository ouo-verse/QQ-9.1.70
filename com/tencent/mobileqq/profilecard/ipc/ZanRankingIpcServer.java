package com.tencent.mobileqq.profilecard.ipc;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.LikeRankingListActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.ProfileCardManager;
import com.tencent.mobileqq.profilecard.data.CardCoverData;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.vas.ao;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateConstants;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.d;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.util.e;
import eipc.EIPCResult;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes35.dex */
public class ZanRankingIpcServer extends QIPCModule implements Handler.Callback {
    public static final String ACTION_GET_CARD_COVER = "action_get_card_cover";
    public static final String ACTION_GET_FRD_NICKS = "action_get_frd_nicks";
    public static final String NAME = "ZanRankingIpcServer";
    public static final String TAG = "ZanRankingIpcServer";
    Set<GetCoverTask> getCoverTasks;
    Handler mSubHandler;

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class GetCoverTask implements Runnable {
        WeakReference<QQAppInterface> appRef;
        volatile Card card;
        volatile CardCoverData coverData;
        Bundle params;
        volatile boolean stopped = false;
        CallBacker vasCallBacker = new CallBacker() { // from class: com.tencent.mobileqq.profilecard.ipc.ZanRankingIpcServer.GetCoverTask.1
            @Override // com.tencent.mobileqq.vas.updatesystem.callback.CallBacker
            public void callback(long j3, String str, String str2, String str3, int i3, int i16) {
                if (j3 == 15 && str.startsWith(VasUpdateConstants.SCID_CARD_PREFIX) && i3 == 0 && GetCoverTask.this.card != null) {
                    GetCoverTask getCoverTask = GetCoverTask.this;
                    getCoverTask.onGetCardCover(getCoverTask.card);
                }
            }
        };
        ProfileCardObserver cardObserver = new ProfileCardObserver() { // from class: com.tencent.mobileqq.profilecard.ipc.ZanRankingIpcServer.GetCoverTask.2
            @Override // com.tencent.mobileqq.profilecard.observer.ProfileCardObserver
            protected void onGetProfileCard(boolean z16, Object obj) {
                if (z16 && (obj instanceof Card)) {
                    Card card = (Card) obj;
                    if (card.uin.equals(GetCoverTask.this.params.getString("uin"))) {
                        GetCoverTask.this.onGetCard(card, false);
                    }
                }
            }
        };

        public GetCoverTask(Bundle bundle) {
            ZanRankingIpcServer.this.getCoverTasks.add(this);
            QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
            this.appRef = new WeakReference<>(qQAppInterface);
            this.params = bundle;
            this.coverData = new CardCoverData(3, "");
            if (qQAppInterface != null) {
                ((IVasQuickUpdateService) qQAppInterface.getRuntimeService(IVasQuickUpdateService.class, "")).addCallBacker(this.vasCallBacker);
                qQAppInterface.addObserver(this.cardObserver, true);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onGetCard(Card card, boolean z16) {
            if (QLog.isColorLevel()) {
                QLog.i("ZanRankingIpcServer", 2, String.format("GetCoverTask onGetCard() uin=%s", card.uin));
            }
            QQAppInterface qQAppInterface = this.appRef.get();
            if (this.stopped || qQAppInterface == null) {
                return;
            }
            if (e.h(card)) {
                if (!e.f(card)) {
                    long j3 = card.lCurrentBgId;
                    if (j3 != 1600 && j3 != 160 && !ProfileTemplateApi.isDiyTemplateStyleID(card.lCurrentStyleId)) {
                        this.card = card;
                        ((ao) qQAppInterface.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).f308431i.j(qQAppInterface, VasUpdateConstants.SCID_CARD_PREFIX + card.lCurrentBgId);
                        return;
                    }
                    e.k(card);
                    onGetCardCover(card);
                    return;
                }
                onGetCardCover(card);
                return;
            }
            Object[] coverData = card.getCoverData(0);
            String str = (String) coverData[0];
            if (TextUtils.isEmpty(str)) {
                onResult(this.coverData);
                return;
            }
            this.coverData.type = 1;
            this.coverData.text = str;
            onResult(this.coverData);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onGetCardCover(Card card) {
            String u16;
            QQAppInterface qQAppInterface = this.appRef.get();
            if (this.stopped || qQAppInterface == null) {
                return;
            }
            long j3 = card.lCurrentBgId;
            if (j3 != 160 && j3 != 1600) {
                u16 = ProfileCardManager.r(qQAppInterface.getApp(), card.lCurrentStyleId, card.lCurrentBgId);
            } else {
                u16 = ProfileCardUtil.u(card.strDrawerCardUrl);
            }
            if (QLog.isColorLevel()) {
                QLog.d("ZanRankingIpcServer", 2, "GetCoverTask updateCoverCard() type personal card, path" + u16);
            }
            this.coverData.type = 2;
            this.coverData.text = u16;
            onResult(this.coverData);
        }

        private void onResult(CardCoverData cardCoverData) {
            int i3 = this.params.getInt("callbackId");
            this.params.putInt("type", cardCoverData.type.intValue());
            this.params.putString("text", cardCoverData.text);
            EIPCResult createResult = EIPCResult.createResult(0, this.params);
            if (i3 > 0) {
                ZanRankingIpcServer.this.callbackResult(i3, createResult);
            }
            onDestroy();
        }

        public void onDestroy() {
            ZanRankingIpcServer.this.getCoverTasks.remove(this);
            QQAppInterface qQAppInterface = this.appRef.get();
            if (qQAppInterface != null) {
                ((IVasQuickUpdateService) qQAppInterface.getRuntimeService(IVasQuickUpdateService.class, "")).removeCallBacker(this.vasCallBacker);
                qQAppInterface.removeObserver(this.cardObserver);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            QQAppInterface qQAppInterface = this.appRef.get();
            if (this.stopped || qQAppInterface == null) {
                return;
            }
            boolean z16 = this.params.getBoolean("fromCache", true);
            String string = this.params.getString("uin");
            if (z16) {
                Card r16 = ((FriendsManager) qQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).r(string);
                if (r16 != null) {
                    onGetCard(r16, true);
                    return;
                }
                return;
            }
            LikeRankingListActivity.H2(qQAppInterface, string);
        }

        public void stop() {
            if (QLog.isColorLevel()) {
                QLog.i("ZanRankingIpcServer", 2, "stop");
            }
            this.stopped = true;
            onDestroy();
        }
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    private static class Holder {
        private static ZanRankingIpcServer sInstance = new ZanRankingIpcServer();

        Holder() {
        }
    }

    ZanRankingIpcServer() {
        super("ZanRankingIpcServer");
        this.mSubHandler = new Handler(ThreadManagerV2.getSubThreadLooper(), this);
        this.getCoverTasks = Collections.synchronizedSet(new HashSet());
    }

    private EIPCResult getFriendNicks(ArrayList<String> arrayList) {
        String p16;
        Bundle bundle = new Bundle();
        ArrayList<String> arrayList2 = new ArrayList<>(arrayList.size());
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(next), "ZanRankingIpcServer");
            if (friendsSimpleInfoWithUid == null) {
                p16 = "";
            } else {
                p16 = friendsSimpleInfoWithUid.p();
            }
            if (!TextUtils.isEmpty(p16)) {
                next = p16;
            }
            arrayList2.add(next);
        }
        bundle.putStringArrayList("uins", arrayList);
        bundle.putStringArrayList("nicks", arrayList2);
        return EIPCResult.createSuccessResult(bundle);
    }

    public static ZanRankingIpcServer getInstance() {
        return Holder.sInstance;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        return false;
    }

    @Override // com.tencent.mobileqq.qipc.QIPCModule
    public void onAccountChange() {
        super.onAccountChange();
        this.mSubHandler.removeCallbacksAndMessages(null);
        Iterator<GetCoverTask> it = this.getCoverTasks.iterator();
        while (it.hasNext()) {
            it.next().stop();
        }
        this.getCoverTasks.clear();
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("ZanRankingIpcServer", 2, "onCall, params=" + bundle + ", action=" + str + ", callBackId=" + i3);
        }
        if (bundle == null) {
            QLog.d("ZanRankingIpcServer", 1, "onCall, param is null, action=" + str + ", callBackId=" + i3);
            return null;
        }
        if (ACTION_GET_CARD_COVER.equals(str)) {
            bundle.putInt("callbackId", i3);
            this.mSubHandler.post(new GetCoverTask(bundle));
        } else if (ACTION_GET_FRD_NICKS.equals(str)) {
            return getFriendNicks(bundle.getStringArrayList("uins"));
        }
        return null;
    }
}
