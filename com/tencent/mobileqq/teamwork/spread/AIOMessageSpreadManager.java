package com.tencent.mobileqq.teamwork.spread;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.business.tendoc.TencentDocTipsConfigProcessor;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.teamwork.spread.a;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TimerTask;
import mqq.manager.Manager;
import ta1.q;

/* compiled from: P */
/* loaded from: classes18.dex */
public class AIOMessageSpreadManager implements Manager {

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f292336d;

    /* renamed from: e, reason: collision with root package name */
    private ConfigSetting f292337e;

    /* renamed from: i, reason: collision with root package name */
    private long f292340i;

    /* renamed from: f, reason: collision with root package name */
    private a f292338f = null;

    /* renamed from: h, reason: collision with root package name */
    private String f292339h = "https://docs.qq.com/scenario/createpad.html?";

    /* renamed from: m, reason: collision with root package name */
    private List<MessageRecord> f292341m = new ArrayList();
    long C = 0;

    public AIOMessageSpreadManager(QQAppInterface qQAppInterface) {
        this.f292336d = qQAppInterface;
        this.f292337e = new ConfigSetting(qQAppInterface);
    }

    private boolean i(char c16, char c17) {
        if (j(c16) && k(c17)) {
            return true;
        }
        return false;
    }

    static boolean j(char c16) {
        if (c16 >= '\ud800' && c16 < '\udc00') {
            return true;
        }
        return false;
    }

    static boolean k(char c16) {
        if (c16 >= '\udc00' && c16 < '\ue000') {
            return true;
        }
        return false;
    }

    private List<String> l(String str) {
        ArrayList arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        int length = str.length();
        int i3 = 0;
        while (i3 < length) {
            int i16 = i3 + 1;
            if (i16 < length) {
                if (i(str.charAt(i3), str.charAt(i16))) {
                    arrayList.add(new String(new char[]{str.charAt(i3), str.charAt(i16)}));
                    i3 += 2;
                } else {
                    arrayList.add(String.valueOf(str.charAt(i3)));
                }
            } else {
                arrayList.add(String.valueOf(str.charAt(i3)));
            }
            i3 = i16;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float m(String str, String str2) {
        float f16;
        List<String> l3 = l(str);
        List<String> l16 = l(str2);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayList = new ArrayList();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (String str3 : l3) {
            if (linkedHashMap.containsKey(str3)) {
                Float f17 = (Float) linkedHashMap.get(str3);
                f17.floatValue();
                linkedHashMap.put(str3, f17);
            } else {
                linkedHashMap.put(str3, Float.valueOf(1.0f));
            }
            if (linkedHashSet.add(str3)) {
                arrayList.add(str3);
            }
        }
        for (String str4 : l16) {
            if (linkedHashMap2.containsKey(str4)) {
                Float f18 = (Float) linkedHashMap2.get(str4);
                f18.floatValue();
                linkedHashMap2.put(str4, f18);
            } else {
                linkedHashMap2.put(str4, Float.valueOf(1.0f));
            }
            if (linkedHashSet.add(str4)) {
                arrayList.add(str4);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int i3 = 0;
        while (true) {
            f16 = 0.0f;
            if (i3 >= arrayList.size()) {
                break;
            }
            String str5 = (String) arrayList.get(i3);
            if (linkedHashMap.containsKey(str5)) {
                arrayList2.add(Float.valueOf(((Float) linkedHashMap.get(str5)).floatValue()));
            } else {
                arrayList2.add(Float.valueOf(0.0f));
            }
            if (linkedHashMap2.containsKey(str5)) {
                arrayList3.add(Float.valueOf(((Float) linkedHashMap2.get(str5)).floatValue()));
            } else {
                arrayList3.add(Float.valueOf(0.0f));
            }
            i3++;
        }
        if (arrayList2.size() != arrayList3.size() || arrayList2.size() == 0) {
            return 0.0f;
        }
        float f19 = 0.0f;
        float f26 = 0.0f;
        for (int i16 = 0; i16 < arrayList2.size(); i16++) {
            f26 += ((Float) arrayList2.get(i16)).floatValue() * ((Float) arrayList3.get(i16)).floatValue();
            f16 += ((Float) arrayList2.get(i16)).floatValue() * ((Float) arrayList2.get(i16)).floatValue();
            f19 += ((Float) arrayList3.get(i16)).floatValue() * ((Float) arrayList3.get(i16)).floatValue();
        }
        return f26 / (((float) Math.pow(f16, 0.5d)) * ((float) Math.pow(f19, 0.5d)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean o(ChatMessage chatMessage) {
        int h16 = this.f292337e.h();
        int d16 = TencentDocTipsConfigProcessor.a().d();
        if (d16 == 0) {
            if (QLog.isColorLevel()) {
                QLog.i("AIOMessageSpreadManager", 1, "config is max: 0, return");
            }
            return false;
        }
        if (h16 > d16) {
            if (QLog.isColorLevel()) {
                QLog.i("AIOMessageSpreadManager", 1, "file count over[" + h16 + "], return");
            }
            return false;
        }
        if (!(chatMessage instanceof MessageForText)) {
            return true;
        }
        boolean l3 = TencentDocTipsConfigProcessor.a().l();
        if (QLog.isColorLevel()) {
            QLog.i("AIOMessageSpreadManager", 1, " is Text Switch On:" + l3);
        }
        return l3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(final ChatMessage chatMessage, final String str, final String str2, final String str3, final q.b bVar) {
        if (!this.f292337e.q() && QLog.isColorLevel()) {
            QLog.i("AIOMessageSpreadManager", 1, "last insert time less");
            return;
        }
        if (QLog.isDebugVersion()) {
            QLog.i("AIOMessageSpreadManager", 1, "insertGaryTips:" + str + " link:" + str2);
        }
        this.f292337e.s(chatMessage);
        new Handler(ThreadManagerV2.getSubThreadLooper()).postDelayed(new Runnable() { // from class: com.tencent.mobileqq.teamwork.spread.AIOMessageSpreadManager.2
            @Override // java.lang.Runnable
            public void run() {
                q.b bVar2;
                QQMessageFacade messageFacade = AIOMessageSpreadManager.this.f292336d.getMessageFacade();
                ChatMessage chatMessage2 = chatMessage;
                MessageRecord P = messageFacade.P(chatMessage2.frienduin, chatMessage2.istroop, chatMessage2.uniseq);
                if (P == null) {
                    if (QLog.isColorLevel()) {
                        QLog.e("AIOMessageSpreadManager", 1, "cant find cache msg,uniseq:" + chatMessage.uniseq);
                    }
                    P = chatMessage;
                }
                MessageRecord messageRecord = P;
                HashMap hashMap = new HashMap();
                String str4 = str;
                if (str4.contains("%s") && (bVar2 = bVar) != null) {
                    try {
                        String str5 = str;
                        String str6 = bVar2.f435750a;
                        str4 = String.format(str5, str6, str6);
                        hashMap.put("tim_aio_file_tips", str4);
                        hashMap.put("tim_aio_file_link", String.format(str2, bVar.f435750a));
                    } catch (Exception e16) {
                        QLog.e("AIOMessageSpreadManager", 2, e16.toString());
                    }
                } else {
                    hashMap.put("tim_aio_file_tips", str);
                    hashMap.put("tim_aio_file_link", str2);
                }
                String str7 = str4;
                hashMap.put("tim_aio_file_msg_uiniseq", String.valueOf(messageRecord.uniseq));
                hashMap.put("tim_aio_tips_type", str3);
                q.b bVar3 = bVar;
                if (bVar3 != null) {
                    hashMap.put("tim_aio_tips_template_id", String.valueOf(bVar3.f435751b));
                    hashMap.put("tim_aio_tips_template_type", String.valueOf(bVar.f435752c));
                    hashMap.put("tim_aio_tips_keyword", String.valueOf(bVar.f435750a));
                    hashMap.put("tim_aio_tips_type", String.valueOf(bVar.f435752c));
                }
                long o16 = AIOMessageSpreadManager.this.f292336d.getFileManagerDataCenter().o(messageRecord.frienduin, AIOMessageSpreadManager.this.f292336d.getCurrentAccountUin(), messageRecord.istroop, MessageRecord.MSG_TYPE_TIM_AIOMSG_TIPS, hashMap, str7, messageRecord.msgUid, messageRecord.shmsgseq, messageRecord.time);
                if (QLog.isDebugVersion()) {
                    QLog.i("AIOMessageSpreadManager", 1, "insertGaryTips:" + o16 + "findMsg:" + messageRecord.hashCode());
                }
                messageRecord.saveExtInfoToExtStr("tim_aio_gary_uniseq", String.valueOf(o16));
                AIOMessageSpreadManager.this.f292336d.getMessageFacade().a1(messageRecord.frienduin, messageRecord.istroop, messageRecord.uniseq, AppConstants.Key.COLUMN_EXT_STR, messageRecord.getExtInfoString());
                AIOMessageSpreadManager.this.f292336d.getMessageFacade().a1(messageRecord.frienduin, messageRecord.istroop, messageRecord.uniseq, AppConstants.Key.COLUMN_EXT_LONG, Integer.valueOf(messageRecord.extLong));
            }
        }, 1000L);
    }

    public void n(MessageRecord messageRecord) {
        if (messageRecord == null) {
            QLog.e("AIOMessageSpreadManager", 1, FileManagerUtil.printStack());
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("AIOMessageSpreadManager", 1, "send file:" + messageRecord.msgUid);
        }
        ThreadManager.getUIHandler().postDelayed(new TimerTask() { // from class: com.tencent.mobileqq.teamwork.spread.AIOMessageSpreadManager.3
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                synchronized (AIOMessageSpreadManager.this) {
                    long currentTimeMillis = System.currentTimeMillis();
                    long j3 = currentTimeMillis - AIOMessageSpreadManager.this.C;
                    if (j3 >= 950) {
                        if (QLog.isColorLevel()) {
                            QLog.i("AIOMessageSpreadManager", 1, "lastInsertTime[" + AIOMessageSpreadManager.this.C + "],now[" + currentTimeMillis + "], dur[" + j3 + "],timeOut start check!");
                        }
                        for (int size = AIOMessageSpreadManager.this.f292341m.size() - 1; size >= 0; size--) {
                            AIOMessageSpreadManager.this.p((ChatMessage) ((MessageRecord) AIOMessageSpreadManager.this.f292341m.get(size)));
                        }
                        AIOMessageSpreadManager aIOMessageSpreadManager = AIOMessageSpreadManager.this;
                        aIOMessageSpreadManager.C = 0L;
                        aIOMessageSpreadManager.f292341m.clear();
                    } else if (QLog.isColorLevel()) {
                        QLog.i("AIOMessageSpreadManager", 1, "lastInsertTime[" + AIOMessageSpreadManager.this.C + "],now[" + currentTimeMillis + "], dur[" + j3 + "]");
                    }
                }
            }
        }, 1000L);
        synchronized (this) {
            this.f292341m.add(messageRecord);
            this.C = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
                QLog.i("AIOMessageSpreadManager", 1, "lastInsertTime[" + this.C + "],lstCache size[" + this.f292341m.size() + "]");
            }
        }
    }

    public void p(final ChatMessage chatMessage) {
        if (QLog.isDebugVersion()) {
            QLog.i("AIOMessageSpreadManager", 4, "ready to post to SubThread Process\uff0c msgUid[" + chatMessage.msgUid + "], hashCode:" + chatMessage.hashCode());
            if (chatMessage.msgUid == 0) {
                FileManagerUtil.printStack();
            }
        }
        long j3 = this.f292340i;
        long j16 = chatMessage.uniseq;
        if (j3 == j16 && (chatMessage instanceof MessageForText)) {
            return;
        }
        if (chatMessage instanceof MessageForText) {
            this.f292340i = j16;
        }
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.teamwork.spread.AIOMessageSpreadManager.1

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.teamwork.spread.AIOMessageSpreadManager$1$a */
            /* loaded from: classes18.dex */
            class a implements a.InterfaceC8642a {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ String f292343a;

                a(String str) {
                    this.f292343a = str;
                }

                @Override // com.tencent.mobileqq.teamwork.spread.a.InterfaceC8642a
                public void a(List<String> list) {
                    String str;
                    if (list != null && list.size() != 0) {
                        float e16 = (float) TencentDocTipsConfigProcessor.a().e();
                        for (String str2 : list) {
                            float m3 = AIOMessageSpreadManager.this.m(this.f292343a, str2);
                            if (QLog.isColorLevel()) {
                                QLog.i("AIOMessageSpreadManager", 1, "file[" + this.f292343a + "] and [" + str2 + "], precentage[" + m3 + "]");
                            }
                            if (m3 - e16 > 0.0f) {
                                String f16 = TencentDocTipsConfigProcessor.a().f();
                                String g16 = TencentDocTipsConfigProcessor.a().g();
                                String str3 = f16 + "\u3002" + g16;
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                AIOMessageSpreadManager.this.r(chatMessage, str3, g16, "precent", null);
                                return;
                            }
                        }
                        return;
                    }
                    if (QLog.isDebugVersion()) {
                        if (list == null) {
                            str = "lst is null";
                        } else {
                            str = "lst.size() = 0";
                        }
                        QLog.i("AIOMessageSpreadManager", 1, str);
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                String str;
                if (QLog.isDebugVersion()) {
                    QLog.i("AIOMessageSpreadManager", 1, "SubThread Process Start");
                }
                if (!AIOMessageSpreadManager.this.o(chatMessage)) {
                    if (QLog.isColorLevel()) {
                        QLog.i("AIOMessageSpreadManager", 1, "config return false!");
                        return;
                    }
                    return;
                }
                ChatMessage chatMessage2 = chatMessage;
                if (chatMessage2 instanceof MessageForText) {
                    AIOMessageSpreadManager aIOMessageSpreadManager = AIOMessageSpreadManager.this;
                    aIOMessageSpreadManager.f292338f = new j(aIOMessageSpreadManager.f292336d, chatMessage, AIOMessageSpreadManager.this.f292337e);
                    if (QLog.isDebugVersion()) {
                        QLog.i("AIOMessageSpreadManager", 1, "message is MessageForText");
                    }
                } else if (chatMessage2 instanceof MessageForFile) {
                    if (QLog.isDebugVersion()) {
                        QLog.i("AIOMessageSpreadManager", 1, "message is MessageForFile");
                    }
                    AIOMessageSpreadManager aIOMessageSpreadManager2 = AIOMessageSpreadManager.this;
                    aIOMessageSpreadManager2.f292338f = new BuddyFileAIOMsgTips(aIOMessageSpreadManager2.f292336d, chatMessage, AIOMessageSpreadManager.this.f292337e);
                } else if (chatMessage2 instanceof MessageForTroopFile) {
                    if (QLog.isDebugVersion()) {
                        QLog.i("AIOMessageSpreadManager", 1, "message is MessageForTroopFile");
                    }
                    AIOMessageSpreadManager aIOMessageSpreadManager3 = AIOMessageSpreadManager.this;
                    aIOMessageSpreadManager3.f292338f = new TroopFileAIOMsgTips(aIOMessageSpreadManager3.f292336d, chatMessage, AIOMessageSpreadManager.this.f292337e);
                } else {
                    if (QLog.isDebugVersion()) {
                        QLog.i("AIOMessageSpreadManager", 1, "message is unknown");
                        return;
                    }
                    return;
                }
                if (!AIOMessageSpreadManager.this.f292338f.c()) {
                    if (QLog.isColorLevel()) {
                        QLog.i("AIOMessageSpreadManager", 1, "file[" + AIOMessageSpreadManager.this.f292338f.a() + "] is not support!");
                        return;
                    }
                    return;
                }
                String a16 = AIOMessageSpreadManager.this.f292338f.a();
                if (QLog.isColorLevel()) {
                    QLog.i("AIOMessageSpreadManager", 1, "recv new File name is :" + a16);
                }
                String[] m3 = AIOMessageSpreadManager.this.f292337e.m(AIOMessageSpreadManager.this.f292338f);
                boolean z16 = false;
                if (QLog.isDebugVersion()) {
                    StringBuilder sb5 = new StringBuilder();
                    for (String str2 : m3) {
                        sb5.append(str2);
                        sb5.append(",");
                    }
                    if (sb5.length() > 0) {
                        sb5.deleteCharAt(sb5.length() - 1);
                    }
                    QLog.i("AIOMessageSpreadManager", 1, "getConfig keyWords:" + sb5.toString());
                }
                int length = m3.length;
                int i3 = 0;
                while (true) {
                    if (i3 < length) {
                        str = m3[i3];
                        if (a16.contains(str)) {
                            z16 = true;
                            break;
                        }
                        i3++;
                    } else {
                        str = "";
                        break;
                    }
                }
                if (z16) {
                    if (QLog.isColorLevel()) {
                        QLog.i("AIOMessageSpreadManager", 1, "keyWord[" + str + "] find!");
                    }
                    String l3 = AIOMessageSpreadManager.this.f292337e.l(AIOMessageSpreadManager.this.f292338f);
                    String k3 = AIOMessageSpreadManager.this.f292337e.k(AIOMessageSpreadManager.this.f292338f);
                    if (TextUtils.isEmpty(l3) && QLog.isColorLevel()) {
                        QLog.i("AIOMessageSpreadManager", 1, "tips is null! return, tips[" + l3 + "], link[" + k3 + "]");
                    }
                    String str3 = l3 + "\u3002" + k3;
                    if ((AIOMessageSpreadManager.this.f292338f instanceof BuddyFileAIOMsgTips) || (AIOMessageSpreadManager.this.f292338f instanceof TroopFileAIOMsgTips)) {
                        AIOMessageSpreadManager.this.r(chatMessage, str3, k3, "keyword", null);
                        return;
                    } else {
                        if (AIOMessageSpreadManager.this.f292338f instanceof j) {
                            AIOMessageSpreadManager aIOMessageSpreadManager4 = AIOMessageSpreadManager.this;
                            aIOMessageSpreadManager4.r(chatMessage, str3, k3, "text_keyword", aIOMessageSpreadManager4.f292337e.i(str));
                            return;
                        }
                        return;
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.i("AIOMessageSpreadManager", 1, "keyWords not find!");
                }
                if (!(AIOMessageSpreadManager.this.f292338f instanceof j)) {
                    AIOMessageSpreadManager.this.f292338f.b(new a(a16));
                }
            }
        });
    }

    public void q(MessageRecord messageRecord) {
        String extInfoFromExtStr = messageRecord.getExtInfoFromExtStr("tim_aio_gary_uniseq");
        if (QLog.isColorLevel()) {
            QLog.i("AIOMessageSpreadManager", 1, "del garyTips id[" + extInfoFromExtStr + "],targetId[" + messageRecord.msgUid + "], hashCode:" + messageRecord.hashCode());
        }
        if (!TextUtils.isEmpty(extInfoFromExtStr)) {
            try {
                this.f292336d.getMessageFacade().V1(messageRecord.frienduin, messageRecord.istroop, Long.parseLong(extInfoFromExtStr), true);
            } catch (Exception e16) {
                e16.printStackTrace();
                QLog.e("AIOMessageSpreadManager", 1, e16.toString());
            }
        }
    }

    public void s(q qVar) {
        this.f292337e.t(qVar);
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
    }
}
