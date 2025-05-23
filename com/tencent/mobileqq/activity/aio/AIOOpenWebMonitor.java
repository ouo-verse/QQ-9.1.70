package com.tencent.mobileqq.activity.aio;

import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.WebAccelerator;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class AIOOpenWebMonitor extends com.tencent.mobileqq.webview.swift.utils.c {
    public static void o(Intent intent, final QQAppInterface qQAppInterface, MessageRecord messageRecord) {
        int i3;
        if (messageRecord != null && SystemClock.uptimeMillis() % 10 == 1) {
            int d16 = com.tencent.mobileqq.structmsg.d.d(messageRecord.istroop);
            if (WebAccelerator.f177626l) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            com.tencent.mobileqq.webview.swift.utils.c.m(intent, d16, i3);
            final String str = messageRecord.frienduin;
            final long j3 = messageRecord.msgUid;
            final int i16 = messageRecord.istroop;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.AIOOpenWebMonitor.1
                @Override // java.lang.Runnable
                public void run() {
                    QQAppInterface qQAppInterface2 = QQAppInterface.this;
                    if (qQAppInterface2 == null) {
                        return;
                    }
                    int i17 = 1;
                    if (i16 == 1) {
                        TroopInfo k3 = ((TroopManager) qQAppInterface2.getManager(QQManagerFactory.TROOP_MANAGER)).k(str);
                        if (k3 == null) {
                            return;
                        }
                        HashMap<String, String> hashMap = new HashMap<>(3);
                        hashMap.put("m_num", k3.wMemberNum + "");
                        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String) null, "AIOWebTC", false, 0L, 0L, hashMap, "", false);
                    }
                    List<ChatMessage> l16 = QQAppInterface.this.getMessageFacade().l1(str, i16);
                    if (l16 == null) {
                        return;
                    }
                    Iterator<ChatMessage> it = l16.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (it.next().msgUid == j3) {
                                break;
                            }
                        } else {
                            i17 = 2;
                            break;
                        }
                    }
                    HashMap<String, String> hashMap2 = new HashMap<>(3);
                    hashMap2.put("m_i", i17 + "");
                    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String) null, "AIOWebmsgposition", false, 0L, 0L, hashMap2, "", false);
                }
            }, 2, null, false);
        }
    }
}
