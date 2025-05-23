package com.tencent.imcore.message.ext.getaiolist;

import com.tencent.mobileqq.activity.aio.q;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.FeedsManager;
import com.tencent.mobileqq.data.MessageForQzoneFeed;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static void a(int i3, List<MessageRecord> list, QQAppInterface qQAppInterface) {
        q qVar;
        if (list != null && list.size() != 0 && i3 != 10014) {
            ArrayList arrayList = new ArrayList(8);
            String str = null;
            for (MessageRecord messageRecord : list) {
                if (messageRecord == null) {
                    arrayList.add(messageRecord);
                } else {
                    str = messageRecord.frienduin;
                    int i16 = messageRecord.msgtype;
                    if (i16 != -2006 && messageRecord.isValid) {
                        if (i16 == -2015 && (messageRecord instanceof MessageForQzoneFeed)) {
                            MessageForQzoneFeed messageForQzoneFeed = (MessageForQzoneFeed) messageRecord;
                            messageForQzoneFeed.parse();
                            if (QZoneHelper.hideAioFeeds()) {
                                if (QLog.isColorLevel()) {
                                    QLog.i("Q.msg.MsgProxyUtils", 2, "QZoneFeeds ,\u7a7a\u95f4\u4e0b\u53d1\u914d\u7f6e\u5c4f\u853d aiofeeds\uff0c\u4e0d\u518d\u663e\u793a");
                                }
                                arrayList.add(messageRecord);
                            } else if (messageForQzoneFeed.isOldStructMsg) {
                                if (QLog.isColorLevel()) {
                                    QLog.i("Q.msg.MsgProxyUtils", 2, "QZoneFeeds ,\u7a7a\u95f4aio feeds\u683c\u5f0f\u4e0d\u517c\u5bb9\uff0c\u4e0d\u518d\u663e\u793a");
                                }
                                arrayList.add(messageRecord);
                            } else if (FeedsManager.isShowStatus(messageRecord.frienduin)) {
                                if (QLog.isColorLevel()) {
                                    QLog.i("Q.msg.MsgProxyUtils", 2, "QZoneFeeds ,\u5f53\u524d\u4f1a\u8bdd\u5217\u8868\u4e2d\u6709\u65b0\u52a8\u6001\uff0c\u5148\u5c06aio\u4e2d\u7684feeds\u9690\u85cf\uff0c\u907f\u514daio\u4e2d\u7684feeds\u8df3\u53d8");
                                }
                                arrayList.add(messageRecord);
                            }
                        }
                    } else {
                        arrayList.add(messageRecord);
                    }
                }
            }
            list.removeAll(arrayList);
            if (str != null && FeedsManager.isShowStatus(str) && qQAppInterface != null && (qVar = (q) qQAppInterface.getManager(QQManagerFactory.BEANCURD_MANAGER)) != null) {
                qVar.c(list, false);
            }
        }
    }
}
