package com.tencent.mobileqq.qqexpand.flutter.channel.chat;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.ao;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.ar;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.matchchat.RecentMatchChatListItem;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.qqexpand.chat.ILimitChatUtils;
import com.tencent.mobileqq.qqexpand.ipc.IExpandFlutterIPCServerHelper;
import com.tencent.mobileqq.qqexpand.manager.e;
import com.tencent.mobileqq.qqexpand.network.ExpandObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.utils.ad;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes35.dex */
public class ExpandChatRepository implements Handler.Callback {
    private final ExpandObserver E;
    private final QQAppInterface F;
    private final ar G;
    private final Observer H;

    /* renamed from: f, reason: collision with root package name */
    private final MqqHandler f263553f;

    /* renamed from: d, reason: collision with root package name */
    private List<RecentMatchChatListItem> f263551d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    private final HashMap<String, RecentMatchChatListItem> f263552e = new HashMap<>();

    /* renamed from: h, reason: collision with root package name */
    private volatile boolean f263554h = false;

    /* renamed from: i, reason: collision with root package name */
    private long f263555i = 0;

    /* renamed from: m, reason: collision with root package name */
    private volatile boolean f263556m = false;
    private final List<Integer> C = new ArrayList();
    private final List<Long> D = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public interface a {
        void a(int i3, String str, ExpandConverListResponse expandConverListResponse);
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    private class b {

        /* renamed from: a, reason: collision with root package name */
        private final long f263572a;

        /* renamed from: b, reason: collision with root package name */
        private final int f263573b;

        /* renamed from: c, reason: collision with root package name */
        private final a f263574c;

        public b(long j3, int i3, a aVar) {
            this.f263572a = j3;
            this.f263573b = i3;
            this.f263574c = aVar;
        }

        public void b() {
            ExpandChatRepository.this.n(0, this.f263573b, this.f263574c);
        }
    }

    public ExpandChatRepository(QQAppInterface qQAppInterface) {
        ExpandObserver expandObserver = new ExpandObserver() { // from class: com.tencent.mobileqq.qqexpand.flutter.channel.chat.ExpandChatRepository.1
            @Override // com.tencent.mobileqq.qqexpand.network.ExpandObserver
            protected void e(final boolean z16, final Card card, final int i3) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.flutter.channel.chat.ExpandChatRepository.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (z16 && card != null) {
                            QLog.d("expand.chat.ExpandChatRepository", 2, "onGetExtendFriendInfo success");
                            ExtendFriendInfo extendFriendInfo = new ExtendFriendInfo();
                            Card card2 = card;
                            extendFriendInfo.nickName = card2.strNick;
                            extendFriendInfo.declaration = card2.declaration;
                            extendFriendInfo.voiceUrl = card2.voiceUrl;
                            String json = new Gson().toJson(extendFriendInfo);
                            Bundle bundle = new Bundle();
                            bundle.putString("data", json);
                            bundle.putInt(TroopAvatarWallPreviewActivity.KEY_SEQ_NUM, i3);
                            QIPCServerHelper.getInstance().getServer().callClient(((IExpandFlutterIPCServerHelper) QRoute.api(IExpandFlutterIPCServerHelper.class)).getProcessName(), 1, "ExpandFlutterIPCClient", "notifyGetExtendFriendInfoResponse", bundle);
                            return;
                        }
                        QLog.w("expand.chat.ExpandChatRepository", 2, "onGetExtendFriendInfo success=" + z16);
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("data", "");
                        bundle2.putInt(TroopAvatarWallPreviewActivity.KEY_SEQ_NUM, i3);
                        QIPCServerHelper.getInstance().getServer().callClient(((IExpandFlutterIPCServerHelper) QRoute.api(IExpandFlutterIPCServerHelper.class)).getProcessName(), 1, "ExpandFlutterIPCClient", "notifyGetExtendFriendInfoResponse", bundle2);
                    }
                }, 16, null, true);
            }

            @Override // com.tencent.mobileqq.qqexpand.network.ExpandObserver
            protected void f(boolean z16, final List<Long> list, final int i3, final List<Long> list2) {
                if (!z16) {
                    QLog.w("expand.chat.ExpandChatRepository", 1, "onGetExtendFriendOnlineState failed seqNum:" + i3);
                    ExpandChatRepository.this.f263556m = true;
                    return;
                }
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.flutter.channel.chat.ExpandChatRepository.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!ExpandChatRepository.this.C.contains(Integer.valueOf(i3))) {
                            if (QLog.isColorLevel()) {
                                QLog.d("expand.chat.ExpandChatRepository", 1, "onGetExtendFriendOnlineState not mine req:" + i3);
                            }
                            HashSet hashSet = new HashSet(ExpandChatRepository.this.D);
                            ArrayList arrayList = new ArrayList();
                            for (Long l3 : list) {
                                if (!hashSet.contains(l3)) {
                                    arrayList.add(l3);
                                }
                            }
                            ExpandChatRepository.this.D.addAll(arrayList);
                        } else {
                            ExpandChatRepository.this.D.clear();
                            ExpandChatRepository.this.D.addAll(list);
                        }
                        QLog.i("expand.chat.ExpandChatRepository", 1, "onGetExtendFriendOnlineState cached list size=" + ExpandChatRepository.this.D.size());
                        ArrayList arrayList2 = new ArrayList();
                        for (Long l16 : list2) {
                            OnlineStateInfo onlineStateInfo = new OnlineStateInfo();
                            onlineStateInfo.uin = l16 + "";
                            onlineStateInfo.online = list.contains(l16);
                            arrayList2.add(onlineStateInfo);
                            if (onlineStateInfo.online && QLog.isColorLevel()) {
                                QLog.d("expand.chat.ExpandChatRepository", 1, "notifyOnlineState  " + MsfSdkUtils.getShortUin(onlineStateInfo.uin));
                            }
                        }
                        ExpandChatRepository.this.r(arrayList2, i3);
                    }
                }, 16, null, true);
            }
        };
        this.E = expandObserver;
        ar arVar = new ar() { // from class: com.tencent.mobileqq.qqexpand.flutter.channel.chat.ExpandChatRepository.2
            @Override // com.tencent.mobileqq.app.ar
            protected void onUpdateFriendInfo(final String str, boolean z16) {
                if (z16) {
                    ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.flutter.channel.chat.ExpandChatRepository.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (QLog.isColorLevel()) {
                                QLog.d("expand.chat.ExpandChatRepository", 2, "onUpdateFriendInfo uin =" + str);
                            }
                            RecentMatchChatListItem recentMatchChatListItem = (RecentMatchChatListItem) ExpandChatRepository.this.f263552e.get(str);
                            if (recentMatchChatListItem != null) {
                                recentMatchChatListItem.mTitleName = ac.g(ExpandChatRepository.this.F, recentMatchChatListItem.messageRecord.senderuin, true);
                                ExpandChatRepository.this.p(str);
                            }
                        }
                    }, 16, null, true);
                }
            }
        };
        this.G = arVar;
        Observer observer = new Observer() { // from class: com.tencent.mobileqq.qqexpand.flutter.channel.chat.ExpandChatRepository.3
            @Override // java.util.Observer
            public void update(Observable observable, final Object obj) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqexpand.flutter.channel.chat.ExpandChatRepository.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Object obj2 = obj;
                        if (obj2 instanceof MessageRecord) {
                            MessageRecord messageRecord = (MessageRecord) obj2;
                            if (((ILimitChatUtils) QRoute.api(ILimitChatUtils.class)).isExtendMatchChatMsg(messageRecord)) {
                                if (QLog.isColorLevel()) {
                                    QLog.d("expand.chat.ExpandChatRepository", 2, "MessageRecord uin =" + messageRecord.senderuin);
                                }
                                if (!TextUtils.isEmpty(messageRecord.senderuin) && !messageRecord.senderuin.equals(ExpandChatRepository.this.F.getCurrentAccountUin())) {
                                    ExpandChatRepository.this.f263556m = true;
                                }
                                ExpandChatRepository.this.s();
                                return;
                            }
                            return;
                        }
                        if ((obj2 instanceof RecentUser) && ExpandChatRepository.this.f263554h) {
                            if (QLog.isColorLevel()) {
                                QLog.d("expand.chat.ExpandChatRepository", 2, "RecentUser uin =" + ((RecentUser) obj).uin);
                            }
                            ExpandChatRepository.this.s();
                        }
                    }
                }, 16, null, true);
            }
        };
        this.H = observer;
        this.F = qQAppInterface;
        qQAppInterface.addObserver(expandObserver);
        QQMessageFacade messageFacade = qQAppInterface.getMessageFacade();
        if (messageFacade != null) {
            messageFacade.addObserver(observer);
        } else {
            QLog.e("expand.chat.ExpandChatRepository", 1, "msg facade is null?");
        }
        qQAppInterface.addObserver(arVar);
        this.f263553f = new ad(ThreadManagerV2.getSubThreadLooper(), this);
    }

    private List<MessageRecord> m(List<MessageRecord> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList(list);
        HashSet hashSet = new HashSet();
        for (int size = arrayList2.size() - 1; size >= 0; size--) {
            if (hashSet.contains(ao.d((MessageRecord) arrayList2.get(size)))) {
                arrayList.add((MessageRecord) arrayList2.get(size));
            } else {
                hashSet.add(ao.d((MessageRecord) arrayList2.get(size)));
            }
        }
        arrayList2.removeAll(arrayList);
        Collections.reverse(arrayList2);
        if (arrayList2.size() <= 150) {
            return arrayList2;
        }
        QLog.i("expand.chat.ExpandChatRepository", 1, "too many conversation items " + arrayList2.size());
        return arrayList2.subList(0, 150);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ExpandConverListResponse n(int i3, int i16, a aVar) {
        ExpandConverListResponse expandConverListResponse = new ExpandConverListResponse();
        int i17 = i16 + i3;
        if (i17 >= this.f263551d.size()) {
            expandConverListResponse.finishFlag = true;
            expandConverListResponse.cursor = "";
            i17 = this.f263551d.size();
        } else {
            expandConverListResponse.finishFlag = false;
            expandConverListResponse.cursor = i17 + "";
        }
        List<RecentMatchChatListItem> subList = this.f263551d.subList(i3, i17);
        ArrayList arrayList = new ArrayList(subList.size());
        Iterator<RecentMatchChatListItem> it = subList.iterator();
        while (it.hasNext()) {
            arrayList.add(ExpandConversation.convert2Con(it.next()));
        }
        expandConverListResponse.conversations = arrayList;
        aVar.a(0, "", expandConverListResponse);
        if (!this.D.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList(this.D);
            for (ExpandConversation expandConversation : expandConverListResponse.conversations) {
                OnlineStateInfo onlineStateInfo = new OnlineStateInfo();
                String str = expandConversation.peerUin;
                onlineStateInfo.uin = str;
                try {
                    onlineStateInfo.online = arrayList3.contains(Long.valueOf(Long.parseLong(str)));
                } catch (NumberFormatException e16) {
                    QLog.w("expand.chat.ExpandChatRepository", 1, "uin error " + onlineStateInfo.uin + " " + e16);
                    onlineStateInfo.online = false;
                }
                arrayList2.add(onlineStateInfo);
                if (onlineStateInfo.online) {
                    QLog.d("expand.chat.ExpandChatRepository", 1, "getPageSizeConversation notifyOnlineState  " + MsfSdkUtils.getShortUin(onlineStateInfo.uin));
                }
            }
            r(arrayList2, -1);
        }
        return expandConverListResponse;
    }

    private List<RecentMatchChatListItem> o(List<MessageRecord> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() != 0) {
            for (MessageRecord messageRecord : list) {
                if (messageRecord != null) {
                    RecentMatchChatListItem recentMatchChatListItem = new RecentMatchChatListItem(messageRecord);
                    recentMatchChatListItem.c(this.F, BaseApplication.getContext());
                    arrayList.add(recentMatchChatListItem);
                    ((e) BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).o(messageRecord.frienduin, true);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        RecentMatchChatListItem recentMatchChatListItem = this.f263552e.get(str);
        if (recentMatchChatListItem == null) {
            q(str);
            QLog.i("expand.chat.ExpandChatRepository", 1, "notifyConversationChanged delete uin =" + str);
            return;
        }
        if (recentMatchChatListItem.getRecentUserUin() == null) {
            QLog.i("expand.chat.ExpandChatRepository", 1, "notifyConversationChanged error update uin =" + str);
            return;
        }
        t(ExpandConversation.convert2Con(recentMatchChatListItem));
        if (QLog.isColorLevel()) {
            QLog.d("expand.chat.ExpandChatRepository", 2, "notifyConversationChanged update uin =" + str);
        }
    }

    private void q(String str) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(str);
        String json = new Gson().toJson(arrayList);
        Bundle bundle = new Bundle();
        bundle.putString("response", json);
        QIPCServerHelper.getInstance().getServer().callClient(((IExpandFlutterIPCServerHelper) QRoute.api(IExpandFlutterIPCServerHelper.class)).getProcessName(), 1, "ExpandFlutterIPCClient", "notifyConversationDelete", bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(List<OnlineStateInfo> list, int i3) {
        if (list.isEmpty()) {
            return;
        }
        String json = new Gson().toJson(list);
        Bundle bundle = new Bundle();
        bundle.putString("data", json);
        bundle.putInt(TroopAvatarWallPreviewActivity.KEY_SEQ_NUM, i3);
        QIPCServerHelper.getInstance().getServer().callClient(((IExpandFlutterIPCServerHelper) QRoute.api(IExpandFlutterIPCServerHelper.class)).getProcessName(), 1, "ExpandFlutterIPCClient", "notifyGetOnLineStateResponse", bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        QIPCServerHelper.getInstance().getServer().callClient(((IExpandFlutterIPCServerHelper) QRoute.api(IExpandFlutterIPCServerHelper.class)).getProcessName(), 1, "ExpandFlutterIPCClient", "notifyConversationRefresh", new Bundle());
        QLog.i("expand.chat.ExpandChatRepository", 1, "notifyRefreshConversationList");
    }

    private void t(ExpandConversation expandConversation) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(expandConversation);
        String json = new Gson().toJson(arrayList);
        Bundle bundle = new Bundle();
        bundle.putString("response", json);
        QIPCServerHelper.getInstance().getServer().callClient(((IExpandFlutterIPCServerHelper) QRoute.api(IExpandFlutterIPCServerHelper.class)).getProcessName(), 1, "ExpandFlutterIPCClient", "notifyConversationUpdate", bundle);
    }

    private List<MessageRecord> v(List<MessageRecord> list) {
        return m(list);
    }

    private List<RecentMatchChatListItem> w() {
        List<MessageRecord> E = this.F.getMessageFacade().E(AppConstants.MATCH_CHAT_UIN, 1044, null, 150);
        if (E == null) {
            E = new ArrayList<>();
        }
        List<RecentMatchChatListItem> o16 = o(v(E));
        this.f263551d = o16;
        this.f263554h = true;
        ArrayList arrayList = new ArrayList(this.f263551d.size());
        for (RecentMatchChatListItem recentMatchChatListItem : this.f263551d) {
            this.f263552e.put(recentMatchChatListItem.getRecentUserUin(), recentMatchChatListItem);
            arrayList.add(recentMatchChatListItem.getRecentUserUin());
        }
        l(arrayList);
        return o16;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 0) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.i("expand.chat.ExpandChatRepository", 1, "start load data");
        }
        List<RecentMatchChatListItem> w3 = w();
        b bVar = (b) message.obj;
        bVar.b();
        QLog.i("expand.chat.ExpandChatRepository", 1, "load by user. data size=" + w3.size() + "time cost:" + (SystemClock.elapsedRealtime() - bVar.f263572a));
        return false;
    }

    public int l(List<String> list) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f263556m || currentTimeMillis - this.f263555i > 180000) {
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                try {
                    arrayList.add(Long.valueOf(str));
                } catch (Exception e16) {
                    QLog.w("expand.chat.ExpandChatRepository", 1, "error uin " + str);
                    QLog.w("expand.chat.ExpandChatRepository", 1, e16.toString());
                }
            }
            if (!arrayList.isEmpty()) {
                com.tencent.mobileqq.qqexpand.network.e eVar = (com.tencent.mobileqq.qqexpand.network.e) this.F.getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER);
                int z16 = eVar.z1();
                if (eVar.w1(arrayList, z16)) {
                    this.f263555i = currentTimeMillis;
                    this.f263556m = false;
                    this.C.add(Integer.valueOf(z16));
                }
                return z16;
            }
        }
        return 0;
    }

    public void u() {
        this.F.removeObserver(this.E);
        this.F.removeObserver(this.G);
        QQMessageFacade messageFacade = this.F.getMessageFacade();
        if (messageFacade != null) {
            messageFacade.deleteObserver(this.H);
        }
        this.f263551d.clear();
        this.f263554h = false;
        this.D.clear();
        this.C.clear();
        this.f263555i = 0L;
        this.f263553f.removeMessages(0);
        QLog.i("expand.chat.ExpandChatRepository", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
    }

    public void k(String str, int i3, a aVar) {
        if (i3 <= 0) {
            QLog.w("expand.chat.ExpandChatRepository", 1, "getConversationList param error. pageCount:" + i3);
            aVar.a(-1, "pageCount error", null);
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (QLog.isColorLevel()) {
            QLog.d("expand.chat.ExpandChatRepository", 2, "getConversationList cursor=" + str + " pageCount=" + i3);
        }
        int i16 = 0;
        if (TextUtils.isEmpty(str)) {
            Message message = new Message();
            message.what = 0;
            message.arg2 = i3;
            message.obj = new b(elapsedRealtime, i3, aVar);
            this.f263553f.sendMessage(message);
            return;
        }
        try {
            int parseInt = Integer.parseInt(str);
            if (parseInt >= 0) {
                if (parseInt >= this.f263551d.size()) {
                    QLog.w("expand.chat.ExpandChatRepository", 1, "getConversationList find no data with cursor:" + str);
                    aVar.a(-1, "find no data with cursor:" + str, null);
                    return;
                }
                i16 = parseInt;
            }
            n(i16, i3, aVar);
            if (QLog.isColorLevel()) {
                QLog.d("expand.chat.ExpandChatRepository", 2, "getConversationList time cost:" + (SystemClock.elapsedRealtime() - elapsedRealtime));
            }
        } catch (NumberFormatException unused) {
            QLog.w("expand.chat.ExpandChatRepository", 1, "getConversationList error cursor:" + str);
            aVar.a(-1, "cursor error " + str, null);
        }
    }
}
