package com.tencent.av.app;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ar;
import com.tencent.mobileqq.app.bs;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.friend.api.IFriendHandlerService;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import tencent.mobileim.structmsg.structmsg$StructMsg;
import tencent.mobileim.structmsg.structmsg$SystemMsgAction;
import tencent.mobileim.structmsg.structmsg$SystemMsgActionInfo;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: i, reason: collision with root package name */
    public static String f73136i = "AvAddFriendService";

    /* renamed from: b, reason: collision with root package name */
    QQAppInterface f73138b;

    /* renamed from: a, reason: collision with root package name */
    boolean f73137a = false;

    /* renamed from: c, reason: collision with root package name */
    int f73139c = 0;

    /* renamed from: d, reason: collision with root package name */
    public HashMap<String, e> f73140d = new HashMap<>();

    /* renamed from: e, reason: collision with root package name */
    com.tencent.mobileqq.avatar.observer.a f73141e = new a();

    /* renamed from: f, reason: collision with root package name */
    com.tencent.mobileqq.friend.observer.a f73142f = new C0732b();

    /* renamed from: g, reason: collision with root package name */
    ar f73143g = new c();

    /* renamed from: h, reason: collision with root package name */
    bs f73144h = new d();

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a extends com.tencent.mobileqq.avatar.observer.a {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.avatar.observer.a
        public void onUpdateCustomHead(boolean z16, String str) {
            if (QLog.isColorLevel()) {
                QLog.d(b.f73136i, 2, "\u597d\u53cbonUpdateCustomHead success = " + z16 + ", uin = " + str);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.av.app.b$b, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    class C0732b extends com.tencent.mobileqq.friend.observer.a {
        C0732b() {
        }

        @Override // com.tencent.mobileqq.friend.observer.a
        protected void onGetAutoInfo(boolean z16, String str, String str2, int i3) {
            if (QLog.isColorLevel()) {
                QLog.d(b.f73136i, 2, "onGetAutoInfo  isSuccess= " + z16 + ",uin=" + str + ",remark=" + str2 + ",groupId" + i3);
            }
        }

        @Override // com.tencent.mobileqq.friend.observer.a
        protected void onQueryUinSafetyFlag(boolean z16, long j3, int i3) {
            if (QLog.isColorLevel()) {
                QLog.d(b.f73136i, 2, "onQueryUinSafetyFlag isSuccess=" + z16 + ",status=" + i3 + ",uin=" + j3);
            }
            if (!z16 || i3 == 0) {
                b.this.h(String.valueOf(j3));
            } else {
                b.this.m(String.valueOf(j3), 3, i3);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.friend.observer.a
        public void onUpdateAddFriend(boolean z16, boolean z17, boolean z18, String str, Bundle bundle) {
            super.onUpdateAddFriend(z16, z17, z18, str, bundle);
            int i3 = bundle.getInt("friend_setting");
            if (QLog.isColorLevel()) {
                QLog.d(b.f73136i, 2, "onUpdateAddFriend \u8bf7\u6c42\u52a0\u597d\u53cb\u56de\u8c03  isSuccess= " + z16 + ",addSuccess=" + z17 + ",reqestUin=" + str + ",friendSetting" + i3);
            }
            if (z17 && b.this.f73138b.getAccount().equals(str) && i3 == 0) {
                b.this.f73137a = true;
            }
        }

        @Override // com.tencent.mobileqq.friend.observer.a
        protected void onUpdateAddFriendSetting(boolean z16, Bundle bundle) {
            String string = bundle.getString("uin");
            int i3 = bundle.getInt("friend_setting");
            if (QLog.isColorLevel()) {
                QLog.d(b.f73136i, 2, "onUpdateAddFriendSetting  isSuccess= " + z16 + ",uin" + string + ",friendSetting=" + i3);
            }
            if (b.this.f73138b.getAccount().equals(string) && i3 == 0) {
                b.this.f73137a = true;
                return;
            }
            ((IFriendHandlerService) b.this.f73138b.getRuntimeService(IFriendHandlerService.class)).requestAddFriend(string, null, i3, (byte) 0, "", b.this.f73139c, 0, true, null, true, "", "");
            if (z16) {
                if (b.this.i(string) != 2) {
                    b.this.l(string, 1);
                    b.this.k(string);
                } else {
                    b.this.d(string);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class c extends ar {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.ar
        public void onAddFriend(String str) {
            super.onAddFriend(str);
            if (QLog.isColorLevel()) {
                QLog.d(b.f73136i, 2, "onAddFriend \u8fdb\u5165\u597d\u53cb\u5217\u8868" + str);
            }
            b.this.l(str, 4);
            b.this.k(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.ar
        public void onUpdateDelFriend(boolean z16, Object obj) {
            super.onUpdateDelFriend(z16, obj);
            String valueOf = String.valueOf((Long) obj);
            if (QLog.isColorLevel()) {
                QLog.d(b.f73136i, 2, "onUpdateDelFriend \u5220\u9664\u597d\u53cb" + valueOf);
            }
            b.this.l(valueOf, 0);
            b.this.k(valueOf);
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class d extends bs {
        d() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Failed to find 'out' block for switch in B:40:0x013e. Please report as an issue. */
        @Override // com.tencent.mobileqq.app.bs
        public void onGetSystemMsgFin(boolean z16, boolean z17, List<MessageRecord> list) {
            if (QLog.isColorLevel()) {
                QLog.i(b.f73136i, 2, "onGetSystemMsgFin.bengin");
            }
            if (z16) {
                if (QLog.isColorLevel()) {
                    QLog.i(b.f73136i, 2, "onGetSystemMsgFin.success");
                }
                try {
                    List<MessageRecord> Q = b.this.f73138b.getMessageFacade().Q(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0);
                    if (QLog.isColorLevel()) {
                        QLog.d(b.f73136i, 2, "onGetSystemMsgFin mDataList size=" + Q.size());
                    }
                    for (int size = Q.size() - 1; size >= 0; size--) {
                        MessageForSystemMsg messageForSystemMsg = (MessageForSystemMsg) Q.get(size);
                        if (messageForSystemMsg == null) {
                            return;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d(b.f73136i, 2, "msg_type=" + messageForSystemMsg.structMsg.msg_type.get() + ", source id" + messageForSystemMsg.structMsg.f436065msg.src_id.get() + "senderuin" + messageForSystemMsg.senderuin);
                            String str = b.f73136i;
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("onGetSystemMsgFin ");
                            sb5.append(messageForSystemMsg.senderuin);
                            sb5.append(" \u8bf7\u6c42\u52a0\u597d\u53cb");
                            QLog.d(str, 2, sb5.toString());
                        }
                        if (messageForSystemMsg.structMsg.f436065msg.src_id.get() != 3023 && messageForSystemMsg.structMsg.f436065msg.src_id.get() != 2023 && messageForSystemMsg.structMsg.f436065msg.src_id.get() != 3025 && messageForSystemMsg.structMsg.f436065msg.src_id.get() != 2025) {
                            if (QLog.isColorLevel()) {
                                QLog.d(b.f73136i, 2, "no av talk src id");
                                return;
                            }
                            return;
                        }
                        if (messageForSystemMsg.structMsg.msg_type.get() == 1) {
                            String str2 = messageForSystemMsg.senderuin;
                            int i3 = messageForSystemMsg.structMsg.f436065msg.sub_type.get();
                            if (QLog.isColorLevel()) {
                                QLog.d(b.f73136i, 2, "systemMsg subType : " + i3);
                            }
                            if (i3 != 1) {
                                switch (i3) {
                                    case 6:
                                        return;
                                    case 7:
                                    case 8:
                                        if (b.this.i(str2) == 2) {
                                            b.this.l(str2, 0);
                                            b.this.k(messageForSystemMsg.senderuin);
                                            return;
                                        }
                                        return;
                                }
                            }
                            if (b.this.i(str2) == 4) {
                                if (QLog.isColorLevel()) {
                                    QLog.d(b.f73136i, 2, "already fiend :" + str2);
                                    return;
                                }
                                return;
                            }
                            if (b.this.i(str2) == 1) {
                                if (QLog.isColorLevel()) {
                                    QLog.d(b.f73136i, 2, "recv add friend request when had send request, accept it automatically :" + str2);
                                }
                                b.this.d(str2);
                                return;
                            }
                            if (!b.this.f73140d.containsKey(str2)) {
                                b.this.f73140d.put(str2, new e());
                            }
                            b.this.l(str2, 2);
                            b.this.k(messageForSystemMsg.senderuin);
                            return;
                        }
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            } else if (z17 && QLog.isColorLevel()) {
                QLog.e(b.f73136i, 2, "onGetSystemMsgFin bTimeout");
            }
            super.onGetSystemMsgFin(z16, z17, list);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.bs
        public void onSendResult(boolean z16, String str, long j3) {
            if (QLog.isColorLevel()) {
                QLog.i(b.f73136i, 2, "onSendSystemMsgActionError.bengin, isSuccess=" + z16 + ", uin" + str);
            }
            super.onSendResult(z16, str, j3);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.bs
        public void onSendSystemMsgActionError(String str) {
            if (QLog.isColorLevel()) {
                QLog.i(b.f73136i, 2, "onSendSystemMsgActionError.bengin \u540c\u610f\u6dfb\u52a0\u597d\u53cb\u5931\u8d25 :" + str);
            }
            long currStructMsgKey = ((INewFriendApi) QRoute.api(INewFriendApi.class)).getCurrStructMsgKey();
            if (!TextUtils.isEmpty(str)) {
                try {
                    currStructMsgKey = Long.parseLong(str);
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
            if (((INewFriendApi) QRoute.api(INewFriendApi.class)).getStructMsgFromMap(Long.valueOf(currStructMsgKey)) == null && QLog.isColorLevel()) {
                QLog.i(b.f73136i, 2, "onSendSystemMsgActionError structMsg = null");
            }
            super.onSendSystemMsgActionError(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.bs
        public void onSendSystemMsgActionFin(boolean z16, String str, int i3, String str2, int i16, int i17, String str3, String str4, int i18) {
            if (QLog.isColorLevel()) {
                QLog.i(b.f73136i, 2, "onSendSystemMsgActionFin \u540c\u610f\u52a0\u5bf9\u65b9\u597d\u53cb\u56de\u8c03 issuc" + z16 + ",logStr=" + str + ";actionType=" + i3 + ";msgDetail=" + str2 + ";resultCode=" + i16 + ";respType=" + i17 + ";msgFail=" + str3 + ";msgInvalidDecided=" + str4 + ";remarkRet=" + i18);
            }
            long currStructMsgKey = ((INewFriendApi) QRoute.api(INewFriendApi.class)).getCurrStructMsgKey();
            if (!TextUtils.isEmpty(str)) {
                try {
                    currStructMsgKey = Long.parseLong(str);
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
            structmsg$StructMsg structMsgFromMap = ((INewFriendApi) QRoute.api(INewFriendApi.class)).getStructMsgFromMap(Long.valueOf(currStructMsgKey));
            if (structMsgFromMap != null) {
                String valueOf = String.valueOf(structMsgFromMap.req_uin.get());
                if (QLog.isColorLevel()) {
                    QLog.i(b.f73136i, 2, "onSendSystemMsgActionFin \u540c\u610f\u52a0\u5bf9\u65b9\u597d\u53cb\u56de\u8c03  uin=" + valueOf);
                }
            } else if (QLog.isColorLevel()) {
                QLog.i(b.f73136i, 2, "onSendSystemMsgActionFin structMsg = null");
            }
            super.onSendSystemMsgActionFin(z16, str, i3, str2, i16, i17, str3, str4, i18);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public int f73149a = 0;

        /* renamed from: b, reason: collision with root package name */
        public int f73150b = 0;
    }

    public b(QQAppInterface qQAppInterface) {
        if (QLog.isColorLevel()) {
            QLog.d(f73136i, 2, "AvAddFriendLogic");
        }
        this.f73138b = qQAppInterface;
        qQAppInterface.addObserver(this.f73144h);
        this.f73138b.addObserver(this.f73143g);
        this.f73138b.addObserver(this.f73141e);
        this.f73138b.addObserver(this.f73142f);
    }

    private boolean f(int i3, String str) {
        Friends friends;
        if (i3 != 1 || str.equals(this.f73138b.getCurrentAccountUin())) {
            return false;
        }
        try {
            Long.parseLong(str);
            FriendsManager friendsManager = (FriendsManager) this.f73138b.getManager(QQManagerFactory.FRIENDS_MANAGER);
            if (friendsManager != null) {
                friends = friendsManager.v(str);
            } else {
                friends = null;
            }
            if (friends != null && friends.groupid >= 0) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(String str) {
        if (this.f73138b.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER) != null) {
            ((IFriendHandlerService) this.f73138b.getRuntimeService(IFriendHandlerService.class)).requestUserAddFriendSetting(str, this.f73139c, 0, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(String str, int i3) {
        if (!this.f73140d.containsKey(str)) {
            if (QLog.isColorLevel()) {
                QLog.d(f73136i, 2, "setRelationStatus no uin in map:" + str);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f73136i, 2, "setRelationStatus :" + str + ",status" + i3);
        }
        this.f73140d.get(str).f73150b = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(String str, int i3, int i16) {
        if (!this.f73140d.containsKey(str)) {
            if (QLog.isColorLevel()) {
                QLog.d(f73136i, 2, "setRelationStatus no uin in map:" + str);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f73136i, 2, "setRelationStatus :" + str + ",status" + i3 + ",safeStatus:" + i16);
        }
        this.f73140d.get(str).f73150b = i3;
        this.f73140d.get(str).f73150b = i16;
    }

    private void n(structmsg$StructMsg structmsg_structmsg, long j3) {
        if (structmsg_structmsg != null) {
            long j16 = structmsg_structmsg.get().msg_seq.get() + structmsg_structmsg.get().msg_type.get();
            ((INewFriendApi) QRoute.api(INewFriendApi.class)).putStructMsgToMap(Long.valueOf(j16), structmsg_structmsg.get());
            ((INewFriendApi) QRoute.api(INewFriendApi.class)).setCurrStructMsgKey(j16);
            ((INewFriendApi) QRoute.api(INewFriendApi.class)).setCurrentUniseq(j3);
        }
    }

    public void d(String str) {
        if (TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.d(f73136i, 2, "acceptAddFriend uin is null");
                return;
            }
            return;
        }
        List<MessageRecord> Q = this.f73138b.getMessageFacade().Q(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0);
        if (Q == null) {
            if (QLog.isColorLevel()) {
                QLog.d(f73136i, 2, "systemMsgList is null");
                return;
            }
            return;
        }
        if (Q.size() > 0 && !(Q.get(0) instanceof MessageForSystemMsg)) {
            if (QLog.isColorLevel()) {
                QLog.d(f73136i, 2, "systemMsgList error");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f73136i, 2, "answerAddFriend systemMsgList size" + Q.size());
        }
        structmsg$StructMsg structmsg_structmsg = null;
        for (int size = Q.size() - 1; size >= 0; size--) {
            structmsg_structmsg = ((MessageForSystemMsg) Q.get(size)).getSystemMsg();
            if (QLog.isColorLevel()) {
                QLog.d(f73136i, 2, "answerAddFriend structMsg.req_uin =" + String.valueOf(structmsg_structmsg.req_uin.get()) + "friendUin=" + str);
            }
            if (str.equals(String.valueOf(structmsg_structmsg.req_uin.get()))) {
                break;
            }
        }
        if (structmsg_structmsg != null && str.equals(String.valueOf(structmsg_structmsg.req_uin.get()))) {
            int i3 = structmsg_structmsg.msg_type.get();
            long j3 = structmsg_structmsg.msg_seq.get();
            long j16 = structmsg_structmsg.req_uin.get();
            int i16 = structmsg_structmsg.f436065msg.sub_type.get();
            int i17 = structmsg_structmsg.f436065msg.src_id.get();
            int i18 = structmsg_structmsg.f436065msg.sub_src_id.get();
            int i19 = structmsg_structmsg.f436065msg.group_msg_type.get();
            List<structmsg$SystemMsgAction> list = structmsg_structmsg.f436065msg.actions.get();
            if (list != null && list.size() > 0) {
                structmsg$SystemMsgActionInfo structmsg_systemmsgactioninfo = list.get(0).action_info.get();
                structmsg_systemmsgactioninfo.remark.set("");
                structmsg_systemmsgactioninfo.group_id.set(0);
                this.f73138b.getMsgHandler().m3().r0(i3, j3, j16, i16, i17, i18, i19, structmsg_systemmsgactioninfo, 0, structmsg_structmsg, false);
                n(structmsg_structmsg, structmsg_structmsg.msg_seq.get());
                if (QLog.isColorLevel()) {
                    QLog.d(f73136i, 2, "answerAddFriend  structMsg.req_uin:  " + String.valueOf(structmsg_structmsg.req_uin.get()));
                    return;
                }
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f73136i, 2, "answerAddFriend  structMsg == null | , friendUin == structMsg.req_uin | ");
        }
    }

    public boolean e(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.d(f73136i, 2, "addFriend uin is null");
            }
            return false;
        }
        this.f73139c = i3;
        if (((FriendsManager) this.f73138b.getManager(QQManagerFactory.FRIENDS_MANAGER)).c0(str)) {
            this.f73140d.put(str, new e());
            l(str, 4);
            k(str);
            return true;
        }
        if (!f(1, str)) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(f73136i, 2, "addFriend uin" + str);
        }
        this.f73140d.put(str, new e());
        ((IFriendHandlerService) this.f73138b.getRuntimeService(IFriendHandlerService.class)).requestUinSafetyFlag(Long.parseLong(str));
        return true;
    }

    protected void finalize() throws Throwable {
        try {
            if (QLog.isColorLevel()) {
                QLog.d(f73136i, 2, "finalize");
            }
        } finally {
            super.finalize();
        }
    }

    public void g(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f73140d.clear();
        } else if (this.f73140d.containsKey(str)) {
            this.f73140d.remove(str);
        }
    }

    public int i(String str) {
        if (!this.f73140d.containsKey(str)) {
            if (QLog.isColorLevel()) {
                QLog.d(f73136i, 2, "getRelationStatus no uin in map:" + str);
                return 0;
            }
            return 0;
        }
        return this.f73140d.get(str).f73150b;
    }

    public void j() {
        if (QLog.isColorLevel()) {
            QLog.d(f73136i, 2, "AvAddFriendLogic onDestory");
        }
        this.f73140d.clear();
        this.f73138b.removeObserver(this.f73144h);
        this.f73138b.removeObserver(this.f73143g);
        this.f73138b.removeObserver(this.f73141e);
        this.f73138b.removeObserver(this.f73142f);
        this.f73138b = null;
    }

    void k(String str) {
        Intent intent = new Intent();
        intent.setAction("tencent.video.q2v.AddfrindMsg");
        intent.putExtra("peerUin", str);
        QQAppInterface qQAppInterface = this.f73138b;
        if (qQAppInterface != null) {
            qQAppInterface.getApp().sendBroadcast(intent);
        }
    }
}
