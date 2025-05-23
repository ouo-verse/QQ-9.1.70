package com.tencent.av.chatroom;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.n;
import com.tencent.av.r;
import com.tencent.av.t;
import com.tencent.av.utils.at;
import com.tencent.av.utils.e;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.app.NewIntent;
import tencent.av.chatroom.chatroom_sso$Msg;
import tencent.av.chatroom.chatroom_sso$PushMsg;
import tencent.av.chatroom.chatroom_sso$ReqGetMsg;
import tencent.av.chatroom.chatroom_sso$ReqSendMsg;
import tencent.av.chatroom.chatroom_sso$RoomKey;
import tencent.av.chatroom.chatroom_sso$RspGetMsg;
import tencent.av.chatroom.chatroom_sso$RspSendMsg;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ChatRoomMng implements Handler.Callback {

    /* renamed from: d, reason: collision with root package name */
    private final VideoAppInterface f73510d;

    /* renamed from: e, reason: collision with root package name */
    private final ConcurrentLinkedQueue<ChatRoomInfo> f73511e = new ConcurrentLinkedQueue<>();

    /* renamed from: f, reason: collision with root package name */
    private final ConcurrentLinkedQueue<b> f73512f = new ConcurrentLinkedQueue<>();

    /* renamed from: h, reason: collision with root package name */
    private final ConcurrentHashMap<ChatRoomInfo, ConcurrentLinkedQueue<com.tencent.av.chatroom.a>> f73513h = new ConcurrentHashMap<>();

    /* renamed from: m, reason: collision with root package name */
    private int f73515m = 0;
    Comparator<com.tencent.av.chatroom.a> C = new a();

    /* renamed from: i, reason: collision with root package name */
    private final Handler f73514i = new Handler(Looper.getMainLooper(), this);

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a implements Comparator<com.tencent.av.chatroom.a> {
        a() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x0024, code lost:
        
            if (r5 > r3) goto L7;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0031, code lost:
        
            if (r9 > r3) goto L7;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x004c, code lost:
        
            if (r9 > r3) goto L7;
         */
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public int compare(com.tencent.av.chatroom.a aVar, com.tencent.av.chatroom.a aVar2) {
            if (aVar == aVar2) {
                return 0;
            }
            if (aVar != null) {
                if (aVar2 != null) {
                    if (aVar.c() && aVar2.c()) {
                        long j3 = aVar.f73529g;
                        long j16 = aVar2.f73529g;
                        if (j3 == j16) {
                            long j17 = aVar.f73526d;
                            long j18 = aVar2.f73526d;
                            if (j17 == j18) {
                                return 0;
                            }
                        }
                    } else if (!aVar.c()) {
                        if (!aVar2.c()) {
                            long j19 = aVar.f73526d;
                            long j26 = aVar2.f73526d;
                            if (j19 == j26) {
                                return 0;
                            }
                        }
                    }
                }
                return 1;
            }
            return -1;
        }
    }

    public ChatRoomMng(VideoAppInterface videoAppInterface) {
        this.f73510d = videoAppInterface;
    }

    private ChatRoomInfo c(chatroom_sso$RoomKey chatroom_sso_roomkey) {
        ChatRoomInfo chatRoomInfo;
        SessionInfo f16 = n.e().f();
        int l3 = f16.l();
        long m3 = f16.m();
        long b16 = f16.b();
        long a16 = f16.a();
        if (l3 == chatroom_sso_roomkey.type.get() && m3 == chatroom_sso_roomkey.f435895id.get()) {
            if (r.h0() != null) {
                r.h0().j("pushMsg", f16);
            }
            b16 = f16.b();
            a16 = f16.a();
        }
        ChatRoomInfo chatRoomInfo2 = null;
        if (l3 == chatroom_sso_roomkey.type.get() && m3 == chatroom_sso_roomkey.f435895id.get() && b16 == chatroom_sso_roomkey.room_id.get() && a16 == chatroom_sso_roomkey.create_ts.get()) {
            chatRoomInfo = f(f16);
        } else {
            chatRoomInfo = null;
        }
        if (chatRoomInfo != null) {
            Iterator<ChatRoomInfo> it = this.f73511e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ChatRoomInfo next = it.next();
                if (next != null && next.f73504d == chatroom_sso_roomkey.type.get() && next.f73506f == chatroom_sso_roomkey.f435895id.get() && next.f73507h == chatroom_sso_roomkey.create_ts.get() && next.f73505e != chatroom_sso_roomkey.room_id.get()) {
                    chatRoomInfo2 = next;
                    break;
                }
            }
            if (chatRoomInfo2 != chatRoomInfo) {
                t(chatRoomInfo2);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("ChatRoomMng", 2, "checkFromPushMsg, curRoomInfo[" + chatRoomInfo + "]");
        }
        return chatRoomInfo;
    }

    private void e(ChatRoomInfo chatRoomInfo, long j3) {
        if (chatRoomInfo == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ChatRoomMng", 2, "doRetryGetMsgList, room[" + chatRoomInfo + "], retryDelay[" + j3 + "], canRetry[" + chatRoomInfo.a() + "]");
        }
        long max = Math.max(j3, 1000L);
        if (chatRoomInfo.a()) {
            Message obtain = Message.obtain();
            obtain.obj = chatRoomInfo;
            obtain.what = 3;
            this.f73514i.sendMessageDelayed(obtain, max);
        }
    }

    private ConcurrentLinkedQueue<com.tencent.av.chatroom.a> i(ChatRoomInfo chatRoomInfo) {
        ConcurrentLinkedQueue<com.tencent.av.chatroom.a> concurrentLinkedQueue = this.f73513h.get(chatRoomInfo);
        if (concurrentLinkedQueue == null) {
            ConcurrentLinkedQueue<com.tencent.av.chatroom.a> concurrentLinkedQueue2 = new ConcurrentLinkedQueue<>();
            this.f73513h.put(chatRoomInfo, concurrentLinkedQueue2);
            return concurrentLinkedQueue2;
        }
        return concurrentLinkedQueue;
    }

    private void l(int i3, ChatRoomInfo chatRoomInfo) {
        this.f73515m = i3 | this.f73515m;
        if (!this.f73514i.hasMessages(1, chatRoomInfo)) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = chatRoomInfo;
            this.f73514i.sendMessage(obtain);
        }
    }

    private void m(com.tencent.av.chatroom.a aVar) {
        if (!this.f73514i.hasMessages(2, aVar)) {
            Message obtain = Message.obtain();
            obtain.what = 2;
            obtain.obj = aVar;
            this.f73514i.sendMessage(obtain);
        }
    }

    private void x(com.tencent.av.chatroom.a aVar) {
        ChatRoomInfo chatRoomInfo;
        long j3;
        if (aVar != null && (chatRoomInfo = aVar.f73523a) != null) {
            try {
                j3 = Long.parseLong(this.f73510d.getCurrentAccountUin());
            } catch (Throwable th5) {
                QLog.i("ChatRoomMng", 1, "sendMsg get self uin fail.", th5);
                j3 = 0;
            }
            long d16 = e.d();
            if (QLog.isColorLevel()) {
                QLog.i("ChatRoomMng", 2, "sendMsg, seq[" + d16 + "], room[" + chatRoomInfo + "], msg[" + aVar + "]");
            }
            aVar.e();
            chatroom_sso$RoomKey chatroom_sso_roomkey = new chatroom_sso$RoomKey();
            chatroom_sso_roomkey.type.set(chatRoomInfo.f73504d);
            chatroom_sso_roomkey.room_id.set(chatRoomInfo.f73505e);
            chatroom_sso_roomkey.f435895id.set(chatRoomInfo.f73506f);
            chatroom_sso_roomkey.create_ts.set((int) chatRoomInfo.f73507h);
            chatroom_sso$Msg chatroom_sso_msg = new chatroom_sso$Msg();
            chatroom_sso_msg.f435892msg.set(aVar.f73525c);
            chatroom_sso_msg.uin.set(j3);
            chatroom_sso$ReqSendMsg chatroom_sso_reqsendmsg = new chatroom_sso$ReqSendMsg();
            chatroom_sso_reqsendmsg.room_key.set(chatroom_sso_roomkey);
            chatroom_sso_reqsendmsg.f435894msg.set(chatroom_sso_msg);
            NewIntent newIntent = new NewIntent(this.f73510d.getApplication(), t.class);
            newIntent.putExtra("reqType", 21);
            newIntent.putExtra("ssoCmd", "QQRTCSvc.chatroom_send_msg");
            newIntent.putExtra("vMsg", chatroom_sso_reqsendmsg.toByteArray());
            newIntent.putExtra("room_key", chatRoomInfo);
            newIntent.putExtra("localSeq", aVar.f73526d);
            at.f(newIntent, d16);
            this.f73510d.startServlet(newIntent);
            if (aVar.f73528f == com.tencent.av.chatroom.a.f73519j) {
                l(1, chatRoomInfo);
            }
        }
    }

    public void b(b bVar) {
        if (QLog.isColorLevel()) {
            QLog.i("ChatRoomMng", 2, "addObserver, observer[" + bVar + "]");
        }
        if (bVar != null && !this.f73512f.contains(bVar)) {
            this.f73512f.add(bVar);
        }
    }

    public void d() {
        if (QLog.isColorLevel()) {
            QLog.i("ChatRoomMng", 2, "clearObserver");
        }
        this.f73512f.clear();
    }

    public ChatRoomInfo f(SessionInfo sessionInfo) {
        ChatRoomInfo k3 = k(sessionInfo, true);
        if (k3 != null) {
            ConcurrentLinkedQueue<com.tencent.av.chatroom.a> concurrentLinkedQueue = this.f73513h.get(k3);
            if (concurrentLinkedQueue == null) {
                this.f73513h.put(k3, new ConcurrentLinkedQueue<>());
            } else {
                concurrentLinkedQueue.clear();
            }
            Message obtain = Message.obtain();
            obtain.obj = k3;
            obtain.what = 3;
            this.f73514i.sendMessage(obtain);
        }
        if (QLog.isDevelopLevel() && sessionInfo != null) {
            QLog.i("ChatRoomMng", 4, "enterChatRoom, SessionType[" + sessionInfo.f73035i + "], relationType[" + sessionInfo.S0 + "], relationId[" + sessionInfo.P0 + "], peerUin[" + sessionInfo.f73091w + "], extraUin[" + sessionInfo.f73103z + "], isDoubleVideoMeeting[" + sessionInfo.f73060o0 + "], room[" + k3 + "]");
        }
        return k3;
    }

    public void g(ChatRoomInfo chatRoomInfo, List<com.tencent.av.chatroom.a> list) {
        if (chatRoomInfo != null && list != null) {
            ConcurrentLinkedQueue<com.tencent.av.chatroom.a> concurrentLinkedQueue = this.f73513h.get(chatRoomInfo);
            if (concurrentLinkedQueue != null && concurrentLinkedQueue.size() > 0) {
                list.addAll(concurrentLinkedQueue);
            }
            try {
                Collections.sort(list, this.C);
            } catch (Throwable th5) {
                if (QLog.isDevelopLevel()) {
                    QLog.i("ChatRoomMng", 4, "getChatRoomMsg", th5);
                }
            }
        }
    }

    public com.tencent.av.chatroom.a h(ChatRoomInfo chatRoomInfo, long j3) {
        ConcurrentLinkedQueue<com.tencent.av.chatroom.a> i3;
        if (chatRoomInfo == null || (i3 = i(chatRoomInfo)) == null || i3.size() <= 0) {
            return null;
        }
        Iterator<com.tencent.av.chatroom.a> it = i3.iterator();
        while (it.hasNext()) {
            com.tencent.av.chatroom.a next = it.next();
            if (next != null && next.f73526d == j3) {
                return next;
            }
        }
        return null;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        com.tencent.av.chatroom.a aVar;
        int i3 = message.what;
        if (i3 == 1) {
            int i16 = this.f73515m;
            this.f73515m = 0;
            ChatRoomInfo chatRoomInfo = (ChatRoomInfo) message.obj;
            Iterator<b> it = this.f73512f.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (next != null) {
                    next.b(i16, chatRoomInfo);
                }
            }
        } else if (i3 == 2) {
            com.tencent.av.chatroom.a aVar2 = (com.tencent.av.chatroom.a) message.obj;
            Iterator<b> it5 = this.f73512f.iterator();
            while (it5.hasNext()) {
                b next2 = it5.next();
                if (next2 != null) {
                    next2.a(aVar2);
                }
            }
        } else if (i3 == 3) {
            final ChatRoomInfo chatRoomInfo2 = (ChatRoomInfo) message.obj;
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.chatroom.ChatRoomMng.2
                @Override // java.lang.Runnable
                public void run() {
                    ChatRoomMng.this.f73514i.removeMessages(3, chatRoomInfo2);
                    ChatRoomMng.this.v(chatRoomInfo2);
                }
            }, 16, null, true);
        } else if (i3 == 4 && (aVar = (com.tencent.av.chatroom.a) message.obj) != null && aVar.a()) {
            x(aVar);
        }
        return true;
    }

    public ChatRoomInfo j(int i3, long j3, long j16, long j17) {
        Iterator<ChatRoomInfo> it = this.f73511e.iterator();
        while (it.hasNext()) {
            ChatRoomInfo next = it.next();
            if (next != null && next.b(i3, j3, j16, j17)) {
                return next;
            }
        }
        return null;
    }

    public ChatRoomInfo k(SessionInfo sessionInfo, boolean z16) {
        if (sessionInfo != null) {
            int l3 = sessionInfo.l();
            long m3 = sessionInfo.m();
            long b16 = sessionInfo.b();
            long a16 = sessionInfo.a();
            if (z16 && (b16 == 0 || (l3 == 1 && a16 == 0))) {
                if (l3 == 2) {
                    r.h0().P();
                } else if (l3 == 1) {
                    r.h0().g0();
                }
                b16 = sessionInfo.b();
                a16 = sessionInfo.a();
            }
            long j3 = b16;
            long j16 = a16;
            ChatRoomInfo j17 = j(l3, j3, m3, j16);
            if (j17 == null && z16) {
                if (j3 != 0 && m3 != 0 && l3 != 0) {
                    ChatRoomInfo chatRoomInfo = new ChatRoomInfo(l3, j3, m3, j16);
                    this.f73511e.add(chatRoomInfo);
                    j17 = chatRoomInfo;
                }
                if (QLog.isDevelopLevel()) {
                    QLog.i("ChatRoomMng", 4, "getRoomInfo, SessionType[" + sessionInfo.f73035i + "], relationType[" + sessionInfo.S0 + "], relationId[" + sessionInfo.P0 + "], peerUin[" + sessionInfo.f73091w + "], extraUin[" + sessionInfo.f73103z + "], isDoubleVideoMeeting[" + sessionInfo.f73060o0 + "], type[" + l3 + "], roomID[" + j3 + "], id[" + m3 + "], createTime[" + j16 + "], room[" + j17 + "]");
                    return j17;
                }
                return j17;
            }
            return j17;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:82:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0294  */
    /* JADX WARN: Type inference failed for: r7v10, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void n(String str, boolean z16, int i3, Intent intent, byte[] bArr) {
        long j3;
        String str2;
        String str3;
        int i16;
        ChatRoomInfo chatRoomInfo;
        InvalidProtocolBufferMicroException invalidProtocolBufferMicroException;
        List<chatroom_sso$Msg> list;
        boolean z17;
        boolean z18;
        String str4;
        String str5;
        String str6;
        int i17;
        long j16;
        ChatRoomInfo chatRoomInfo2;
        ?? r75;
        long j17;
        long a16 = at.a(intent);
        if (QLog.isColorLevel()) {
            QLog.i("ChatRoomMng", 2, "onChatRoomRsp, cmd[" + str + "], isSuc[" + z16 + "], resultCode[" + i3 + "], seq[" + a16 + "]");
        }
        int i18 = -1;
        String str7 = null;
        String str8 = null;
        List<chatroom_sso$Msg> list2 = null;
        if ("QQRTCSvc.chatroom_send_msg".equals(str)) {
            ChatRoomInfo chatRoomInfo3 = (ChatRoomInfo) intent.getParcelableExtra("room_key");
            long longExtra = intent.getLongExtra("localSeq", 0L);
            if (chatRoomInfo3 != null) {
                str6 = "]";
                j16 = longExtra;
                str5 = "ChatRoomMng";
                i17 = 4;
                chatRoomInfo2 = j(chatRoomInfo3.f73504d, chatRoomInfo3.f73505e, chatRoomInfo3.f73506f, chatRoomInfo3.f73507h);
            } else {
                str5 = "ChatRoomMng";
                str6 = "]";
                i17 = 4;
                j16 = longExtra;
                chatRoomInfo2 = null;
            }
            com.tencent.av.chatroom.a h16 = chatRoomInfo2 != null ? h(chatRoomInfo2, j16) : null;
            if (chatRoomInfo2 != null && h16 != null) {
                if (z16 && bArr != null && bArr.length > 0) {
                    chatroom_sso$RspSendMsg chatroom_sso_rspsendmsg = new chatroom_sso$RspSendMsg();
                    try {
                        chatroom_sso_rspsendmsg.mergeFrom(bArr);
                        i18 = chatroom_sso_rspsendmsg.result.get();
                        str8 = chatroom_sso_rspsendmsg.err_msg.get();
                        j17 = chatroom_sso_rspsendmsg.msg_id.get();
                        r75 = 1;
                    } catch (InvalidProtocolBufferMicroException e16) {
                        r75 = 1;
                        QLog.i(str5, 1, "onChatRoomRsp, parse RspSendMsg fail.", e16);
                        j17 = 0;
                    }
                    if (QLog.isColorLevel()) {
                        Object[] objArr = new Object[i17];
                        objArr[0] = Integer.valueOf(i18);
                        objArr[r75] = Long.valueOf(j17);
                        objArr[2] = str8;
                        objArr[3] = Long.valueOf(j16);
                        QLog.i(str5, 2, String.format("onChatRoomRsp, result[%s], msgSeq[%s], errorMsg[%s], localSeq[%s]", objArr));
                    }
                    if (i18 != 0) {
                        h16.f(com.tencent.av.chatroom.a.f73520k);
                        m(h16);
                        if (h16.a()) {
                            Message obtain = Message.obtain();
                            obtain.what = i17;
                            obtain.obj = h16;
                            this.f73514i.sendMessageDelayed(obtain, 200L);
                            return;
                        }
                        return;
                    }
                    h16.f73529g = j17;
                    h16.f(com.tencent.av.chatroom.a.f73521l);
                    m(h16);
                    if (!chatRoomInfo2.E) {
                        c.e("0X800A8D4");
                        chatRoomInfo2.E = r75;
                    }
                    if (chatRoomInfo2.F || TextUtils.isEmpty(h16.f73525c) || h16.f73525c.indexOf(20) < 0) {
                        return;
                    }
                    c.e("0X800A8D5");
                    chatRoomInfo2.F = r75;
                    return;
                }
                h16.f(com.tencent.av.chatroom.a.f73520k);
                m(h16);
                if (QLog.isColorLevel()) {
                    QLog.i(str5, 2, "onChatRoomRsp send msg fail, localSeq[" + j16 + str6);
                    return;
                }
                return;
            }
            QLog.i(str5, 1, "onChatRoomRsp find msg fail, localSeq[" + j16 + "], room[" + chatRoomInfo3 + str6);
            return;
        }
        if ("QQRTCSvc.chatroom_get_msg".equals(str)) {
            ChatRoomInfo chatRoomInfo4 = (ChatRoomInfo) intent.getParcelableExtra("room_key");
            if (chatRoomInfo4 != null) {
                str2 = "ChatRoomMng";
                j3 = a16;
                str3 = "]";
                i16 = 1;
                chatRoomInfo = j(chatRoomInfo4.f73504d, chatRoomInfo4.f73505e, chatRoomInfo4.f73506f, chatRoomInfo4.f73507h);
            } else {
                j3 = a16;
                str2 = "ChatRoomMng";
                str3 = "]";
                i16 = 1;
                chatRoomInfo = null;
            }
            if (chatRoomInfo == null) {
                QLog.i(str2, i16, "onChatRoomRsp find room info fail. room[" + chatRoomInfo4 + str3);
                return;
            }
            String str9 = str2;
            long j18 = 1000;
            if (z16 && bArr != null && bArr.length > 0) {
                chatroom_sso$RspGetMsg chatroom_sso_rspgetmsg = new chatroom_sso$RspGetMsg();
                try {
                    chatroom_sso_rspgetmsg.mergeFrom(bArr);
                    i18 = chatroom_sso_rspgetmsg.result.get();
                    str4 = chatroom_sso_rspgetmsg.err_msg.get();
                    try {
                        list2 = chatroom_sso_rspgetmsg.msg_list.get();
                        z18 = chatroom_sso_rspgetmsg.retry.get();
                    } catch (InvalidProtocolBufferMicroException e17) {
                        invalidProtocolBufferMicroException = e17;
                        list = list2;
                        str7 = str4;
                        z17 = false;
                        QLog.i(str9, i16, "onChatRoomRsp, parse RspGetMsg fail.", invalidProtocolBufferMicroException);
                        z18 = z17;
                        str4 = str7;
                        if (QLog.isColorLevel()) {
                        }
                        if (i18 == 0) {
                        }
                    }
                } catch (InvalidProtocolBufferMicroException e18) {
                    invalidProtocolBufferMicroException = e18;
                    list = null;
                }
                try {
                    j18 = chatroom_sso_rspgetmsg.retry_delay.get();
                    list = list2;
                } catch (InvalidProtocolBufferMicroException e19) {
                    invalidProtocolBufferMicroException = e19;
                    list = list2;
                    str7 = str4;
                    z17 = z18;
                    QLog.i(str9, i16, "onChatRoomRsp, parse RspGetMsg fail.", invalidProtocolBufferMicroException);
                    z18 = z17;
                    str4 = str7;
                    if (QLog.isColorLevel()) {
                    }
                    if (i18 == 0) {
                    }
                }
                if (QLog.isColorLevel()) {
                    Object[] objArr2 = new Object[5];
                    objArr2[0] = Integer.valueOf(i18);
                    objArr2[i16] = str4;
                    objArr2[2] = Integer.valueOf(list == null ? 0 : list.size());
                    objArr2[3] = Boolean.valueOf(z18);
                    objArr2[4] = Long.valueOf(j18);
                    QLog.i(str9, 2, String.format("onChatRoomRsp, get msg from server, result[%s], errorMsg[%s], msgSize[%s], retry[%s], retryDelay[%s]", objArr2));
                }
                if (i18 == 0) {
                    if (z18 && (list == null || list.size() == 0)) {
                        e(chatRoomInfo, j18);
                        return;
                    } else {
                        o(chatRoomInfo, list, false);
                        return;
                    }
                }
                e(chatRoomInfo, j18);
                return;
            }
            e(chatRoomInfo, 1000L);
            if (QLog.isColorLevel()) {
                QLog.i(str9, 2, "onChatRoomRsp get msg fail seq[" + j3 + str3);
            }
        }
    }

    public void o(ChatRoomInfo chatRoomInfo, List<chatroom_sso$Msg> list, boolean z16) {
        if (chatRoomInfo != null && list != null && list.size() != 0) {
            if (QLog.isDevelopLevel()) {
                QLog.i("ChatRoomMng", 4, "onRecvMsg, room[" + chatRoomInfo + "], size[" + list.size() + "]");
            }
            for (chatroom_sso$Msg chatroom_sso_msg : list) {
                if (chatroom_sso_msg != null) {
                    p(chatRoomInfo, chatroom_sso_msg, z16);
                }
            }
        }
    }

    public void p(ChatRoomInfo chatRoomInfo, chatroom_sso$Msg chatroom_sso_msg, boolean z16) {
        boolean z17;
        boolean z18;
        if (chatRoomInfo != null && chatroom_sso_msg != null) {
            long j3 = chatroom_sso_msg.uin.get();
            ConcurrentLinkedQueue<com.tencent.av.chatroom.a> i3 = i(chatRoomInfo);
            Iterator<com.tencent.av.chatroom.a> it = i3.iterator();
            com.tencent.av.chatroom.a aVar = null;
            com.tencent.av.chatroom.a aVar2 = null;
            while (true) {
                if (it.hasNext()) {
                    com.tencent.av.chatroom.a next = it.next();
                    if (next != null) {
                        if (next.d(chatroom_sso_msg)) {
                            next.f73527e = chatroom_sso_msg.msg_time.get();
                            next.f(com.tencent.av.chatroom.a.f73522m);
                            aVar = next;
                            z17 = true;
                            break;
                        }
                        if (next.f73529g == Long.MIN_VALUE && next.f73524b == j3 && TextUtils.equals(next.f73525c, chatroom_sso_msg.f435892msg.get())) {
                            aVar2 = next;
                        }
                    }
                } else {
                    z17 = false;
                    break;
                }
            }
            if (!z17 && aVar2 != null) {
                aVar2.f73529g = chatroom_sso_msg.msg_id.get();
                aVar2.f73527e = chatroom_sso_msg.msg_time.get();
                aVar2.f(com.tencent.av.chatroom.a.f73522m);
                z18 = true;
            } else {
                z18 = z17;
                aVar2 = aVar;
            }
            if (!z18) {
                com.tencent.av.chatroom.a aVar3 = new com.tencent.av.chatroom.a(chatRoomInfo, chatroom_sso_msg.uin.get(), chatroom_sso_msg.f435892msg.get(), chatroom_sso_msg.msg_time.get(), chatroom_sso_msg.msg_id.get(), com.tencent.av.chatroom.a.f73522m);
                i3.add(aVar3);
                if (z16) {
                    l(4, chatRoomInfo);
                } else {
                    l(2, chatRoomInfo);
                }
                aVar2 = aVar3;
            }
            if (QLog.isDevelopLevel()) {
                QLog.i("ChatRoomMng", 4, "onRecvMsg, isDuplicatedMsg[" + z18 + "], msg[" + aVar2 + "], isFromPush[" + z16 + "]");
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void q(int i3, byte[] bArr) {
        chatroom_sso$RoomKey chatroom_sso_roomkey;
        chatroom_sso$Msg chatroom_sso_msg;
        chatroom_sso$RoomKey chatroom_sso_roomkey2;
        int i16;
        int i17;
        ChatRoomInfo j3;
        if (i3 == 2 && bArr != null && bArr.length != 0) {
            chatroom_sso$PushMsg chatroom_sso_pushmsg = new chatroom_sso$PushMsg();
            chatroom_sso$Msg chatroom_sso_msg2 = null;
            try {
                chatroom_sso_pushmsg.mergeFrom(bArr);
                if (chatroom_sso_pushmsg.room_key.has()) {
                    chatroom_sso_roomkey = chatroom_sso_pushmsg.room_key.get();
                    i16 = 0;
                } else {
                    chatroom_sso_roomkey = null;
                    i16 = 2;
                }
            } catch (InvalidProtocolBufferMicroException e16) {
                e = e16;
                chatroom_sso_roomkey = null;
            }
            try {
                if (chatroom_sso_pushmsg.f435893msg.has()) {
                    chatroom_sso_msg2 = chatroom_sso_pushmsg.f435893msg.get();
                } else {
                    i16 = 3;
                }
                chatroom_sso_msg = chatroom_sso_msg2;
                chatroom_sso_roomkey2 = chatroom_sso_roomkey;
            } catch (InvalidProtocolBufferMicroException e17) {
                e = e17;
                if (QLog.isColorLevel()) {
                    QLog.i("ChatRoomMng", 2, "processAVChatRoomMsgPush parse fail.", e);
                }
                chatroom_sso_msg = null;
                chatroom_sso_roomkey2 = chatroom_sso_roomkey;
                i16 = 1;
                if (chatroom_sso_roomkey2 != null) {
                    chatroom_sso$Msg chatroom_sso_msg3 = chatroom_sso_msg;
                    chatroom_sso$RoomKey chatroom_sso_roomkey3 = chatroom_sso_roomkey2;
                    j3 = j(chatroom_sso_roomkey2.type.get(), chatroom_sso_roomkey2.room_id.get(), chatroom_sso_roomkey2.f435895id.get(), chatroom_sso_roomkey2.create_ts.get());
                    if (j3 == null) {
                    }
                    if (j3 == null) {
                    }
                }
                i17 = i16;
                if (QLog.isColorLevel()) {
                }
            }
            if (chatroom_sso_roomkey2 != null && chatroom_sso_msg != null) {
                chatroom_sso$Msg chatroom_sso_msg32 = chatroom_sso_msg;
                chatroom_sso$RoomKey chatroom_sso_roomkey32 = chatroom_sso_roomkey2;
                j3 = j(chatroom_sso_roomkey2.type.get(), chatroom_sso_roomkey2.room_id.get(), chatroom_sso_roomkey2.f435895id.get(), chatroom_sso_roomkey2.create_ts.get());
                if (j3 == null) {
                    j3 = c(chatroom_sso_roomkey32);
                }
                if (j3 == null) {
                    p(j3, chatroom_sso_msg32, true);
                } else {
                    if (QLog.isDevelopLevel()) {
                        QLog.i("ChatRoomMng", 4, String.format("onReceivePushMsg, [type: %s, room_id: %s, id: %s, create_ts: %s", Integer.valueOf(chatroom_sso_roomkey32.type.get()), Long.valueOf(chatroom_sso_roomkey32.room_id.get()), Long.valueOf(chatroom_sso_roomkey32.f435895id.get()), Integer.valueOf(chatroom_sso_roomkey32.create_ts.get())));
                    }
                    i17 = 4;
                    if (QLog.isColorLevel()) {
                        QLog.i("ChatRoomMng", 2, "onReceivePushMsg, ret[" + i17 + "]");
                        return;
                    }
                    return;
                }
            }
            i17 = i16;
            if (QLog.isColorLevel()) {
            }
        } else if (QLog.isDevelopLevel()) {
            QLog.i("ChatRoomMng", 4, "onReceivePushMsg params error.");
        }
    }

    public void r(SessionInfo sessionInfo) {
        ChatRoomInfo k3 = k(sessionInfo, false);
        boolean j3 = r.h0().j("onSwitchTerminalSuccess", sessionInfo);
        ChatRoomInfo k16 = k(sessionInfo, false);
        if (k16 == null) {
            k16 = f(sessionInfo);
        }
        if (k16 != null) {
            if (k3 != k16) {
                t(k3);
            }
            k16.G = true;
            if (k3 != k16 && k3 != null) {
                k16.H = k3.f73505e;
            }
            this.f73514i.removeMessages(3, k16);
            Message obtain = Message.obtain();
            obtain.obj = k16;
            obtain.what = 3;
            this.f73514i.sendMessage(obtain);
        }
        if (QLog.isColorLevel()) {
            QLog.i("ChatRoomMng", 2, String.format("onSwitchTerminalSuccess, ret[%s], pre[%s], cur[%s]", Boolean.valueOf(j3), k3, k16));
        }
    }

    public void s(SessionInfo sessionInfo) {
        ChatRoomInfo k3 = k(sessionInfo, false);
        t(k3);
        if (QLog.isDevelopLevel() && sessionInfo != null) {
            QLog.i("ChatRoomMng", 4, "quitChatRoom, SessionType[" + sessionInfo.f73035i + "], relationType[" + sessionInfo.S0 + "], relationId[" + sessionInfo.P0 + "], peerUin[" + sessionInfo.f73091w + "], extraUin[" + sessionInfo.f73103z + "], isDoubleVideoMeeting[" + sessionInfo.f73060o0 + "], room[" + k3 + "]");
        }
    }

    public void t(ChatRoomInfo chatRoomInfo) {
        if (chatRoomInfo != null) {
            this.f73511e.remove(chatRoomInfo);
            this.f73513h.remove(chatRoomInfo);
        }
        if (QLog.isColorLevel()) {
            QLog.i("ChatRoomMng", 2, "removeChatRoom, room[" + chatRoomInfo + "]");
        }
    }

    public void u(b bVar) {
        if (QLog.isColorLevel()) {
            QLog.i("ChatRoomMng", 2, "removeObserver, observer[" + bVar + "]");
        }
        if (bVar != null) {
            this.f73512f.remove(bVar);
        }
    }

    protected void v(ChatRoomInfo chatRoomInfo) {
        if (chatRoomInfo == null) {
            QLog.i("ChatRoomMng", 1, "reqGetMsgFromServer, no room info.");
            return;
        }
        long d16 = e.d();
        if (QLog.isColorLevel()) {
            QLog.i("ChatRoomMng", 2, "reqGetMsgFromServer, seq[" + d16 + "], curRoomInfo[" + chatRoomInfo + "]");
        }
        int i3 = (int) chatRoomInfo.f73507h;
        chatroom_sso$RoomKey chatroom_sso_roomkey = new chatroom_sso$RoomKey();
        chatroom_sso_roomkey.type.set(chatRoomInfo.f73504d);
        chatroom_sso_roomkey.room_id.set(chatRoomInfo.f73505e);
        chatroom_sso_roomkey.f435895id.set(chatRoomInfo.f73506f);
        chatroom_sso_roomkey.create_ts.set(i3);
        chatroom_sso$ReqGetMsg chatroom_sso_reqgetmsg = new chatroom_sso$ReqGetMsg();
        chatroom_sso_reqgetmsg.room_key.set(chatroom_sso_roomkey);
        if (chatRoomInfo.G) {
            chatroom_sso_reqgetmsg.is_terminal_switch.set(true);
            long j3 = chatRoomInfo.H;
            if (j3 != 0) {
                chatroom_sso_reqgetmsg.room_id.set(j3);
            }
        }
        chatRoomInfo.c();
        NewIntent newIntent = new NewIntent(this.f73510d.getApplication(), t.class);
        newIntent.putExtra("reqType", 21);
        newIntent.putExtra("ssoCmd", "QQRTCSvc.chatroom_get_msg");
        newIntent.putExtra("vMsg", chatroom_sso_reqgetmsg.toByteArray());
        newIntent.putExtra("room_key", chatRoomInfo);
        at.f(newIntent, d16);
        this.f73510d.startServlet(newIntent);
    }

    public void w(ChatRoomInfo chatRoomInfo, String str, long j3) {
        long j16;
        if (chatRoomInfo != null && !TextUtils.isEmpty(str)) {
            try {
                j16 = Long.parseLong(this.f73510d.getCurrentAccountUin());
            } catch (Throwable th5) {
                QLog.i("ChatRoomMng", 1, "sendMsg get self uin fail.", th5);
                j16 = 0;
            }
            com.tencent.av.chatroom.a aVar = new com.tencent.av.chatroom.a(chatRoomInfo, j16, str, j3, Long.MIN_VALUE, com.tencent.av.chatroom.a.f73519j);
            i(chatRoomInfo).add(aVar);
            x(aVar);
        }
    }
}
