package com.tencent.mobileqq.forward;

import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.cn;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class l {
    static IPatchRedirector $redirector_;

    private static void a(ContentValues contentValues, String str, Object obj, Object obj2) {
        if (obj == obj2) {
            return;
        }
        QLog.d("SDK_SHARE.ForwardOptionUtils", 1, "addValues key=", str, ", oldValue=", obj, ", newValue=", obj2);
        if (obj2 instanceof Integer) {
            contentValues.put(str, (Integer) obj2);
            return;
        }
        if (obj2 instanceof String) {
            contentValues.put(str, (String) obj2);
            return;
        }
        if (obj2 instanceof Boolean) {
            contentValues.put(str, (Boolean) obj2);
            return;
        }
        if (obj2 instanceof Long) {
            contentValues.put(str, (Long) obj2);
        } else if (obj2 instanceof byte[]) {
            contentValues.put(str, (byte[]) obj2);
        } else {
            QLog.e("SDK_SHARE.ForwardOptionUtils", 1, "addValues fail -------key=", str, ", oldValue=", obj, ", newValue=", obj2);
        }
    }

    private static ContentValues b(MessageRecord messageRecord, MessageForArkApp messageForArkApp) {
        ContentValues contentValues = new ContentValues();
        a(contentValues, "uniseq", Long.valueOf(messageRecord.uniseq), Long.valueOf(messageForArkApp.uniseq));
        a(contentValues, AppConstants.Key.COLUMN_MSG_TYPE, Integer.valueOf(messageRecord.msgtype), Integer.valueOf(messageForArkApp.msgtype));
        a(contentValues, "time", Long.valueOf(messageRecord.time), Long.valueOf(messageForArkApp.time));
        a(contentValues, AppConstants.Key.COLUMN_SHMSG_SEQ, Long.valueOf(messageRecord.shmsgseq), Long.valueOf(messageForArkApp.shmsgseq));
        a(contentValues, AppConstants.Key.COLUMN_MSG_SEQ, Long.valueOf(messageRecord.msgseq), Long.valueOf(messageForArkApp.msgseq));
        a(contentValues, AppConstants.Key.COLUMN_IS_READ, Boolean.valueOf(messageRecord.isread), Boolean.valueOf(messageForArkApp.isread));
        a(contentValues, AppConstants.Key.COLUMN_IS_SEND, Integer.valueOf(messageRecord.issend), Integer.valueOf(messageForArkApp.issend));
        a(contentValues, AppConstants.Key.COLUMN_IS_TROOP, Integer.valueOf(messageRecord.istroop), Integer.valueOf(messageForArkApp.istroop));
        a(contentValues, AppConstants.Key.COLUMN_EXTRA_FLAG, Integer.valueOf(messageRecord.extraflag), Integer.valueOf(messageForArkApp.extraflag));
        a(contentValues, AppConstants.Key.COLUMN_SEND_FAIL_CODE, Integer.valueOf(messageRecord.sendFailCode), Integer.valueOf(messageForArkApp.sendFailCode));
        a(contentValues, "msgId", Long.valueOf(messageRecord.msgId), Long.valueOf(messageForArkApp.msgId));
        a(contentValues, AppConstants.Key.COLUMN_MSG_UID, Long.valueOf(messageRecord.msgUid), Long.valueOf(messageForArkApp.msgUid));
        a(contentValues, AppConstants.Key.COLUMN_EXT_INT, Integer.valueOf(messageRecord.extInt), Integer.valueOf(messageForArkApp.extInt));
        a(contentValues, AppConstants.Key.COLUMN_EXT_LONG, Integer.valueOf(messageRecord.extLong), Integer.valueOf(messageForArkApp.extLong));
        a(contentValues, AppConstants.Key.COLUMN_EXT_STR, messageRecord.extStr, messageForArkApp.extStr);
        a(contentValues, AppConstants.Key.COLUMN_IS_VALID, Boolean.valueOf(messageRecord.isValid), Boolean.valueOf(messageForArkApp.isValid));
        a(contentValues, "versionCode", Integer.valueOf(messageRecord.versionCode), Integer.valueOf(messageForArkApp.versionCode));
        a(contentValues, AppConstants.Key.COLUMN_VIP_BUBBLE_ID, Long.valueOf(messageRecord.vipBubbleID), Long.valueOf(messageForArkApp.vipBubbleID));
        a(contentValues, AppConstants.Key.COLUMN_LONG_MSG_COUNT, Integer.valueOf(messageRecord.longMsgCount), Integer.valueOf(messageForArkApp.longMsgCount));
        a(contentValues, AppConstants.Key.COLUMN_LONG_MSG_ID, Integer.valueOf(messageRecord.longMsgId), Integer.valueOf(messageForArkApp.longMsgId));
        a(contentValues, AppConstants.Key.COLUMN_LONG_MSG_INDEX, Integer.valueOf(messageRecord.longMsgIndex), Integer.valueOf(messageForArkApp.longMsgIndex));
        a(contentValues, AppConstants.Key.COLUMN_MSG_DATA, messageRecord.msgData, messageForArkApp.msgData);
        return contentValues;
    }

    public static int c(int i3, double d16) {
        float f16;
        float f17;
        if (i3 > 150) {
            f16 = i3 / 100;
        } else {
            f16 = 1.0f;
        }
        if (d16 <= 1.5d || d16 <= 2.0d) {
            f17 = f16 * 9.0f;
        } else {
            f17 = f16 * 4.0f;
        }
        return (int) f17;
    }

    public static final boolean d(Intent intent) {
        if (intent != null && intent.hasExtra("report") && "Music_gene_aio".equals(intent.getStringExtra("report"))) {
            return true;
        }
        return false;
    }

    public static Drawable e(Bitmap bitmap, double d16) {
        Bitmap round = BaseImageUtil.round(bitmap, c(0, d16));
        if (round != null) {
            return new BitmapDrawable(BaseApplicationImpl.getApplication().getResources(), round);
        }
        return null;
    }

    public static Drawable f(Drawable drawable, double d16) {
        return e(cn.d(drawable), d16);
    }

    public static Drawable g(Bitmap bitmap) {
        Bitmap circleFaceBitmap = BaseImageUtil.getCircleFaceBitmap(bitmap, bitmap.getWidth(), bitmap.getHeight());
        if (circleFaceBitmap != null) {
            return new BitmapDrawable(BaseApplicationImpl.getApplication().getResources(), circleFaceBitmap);
        }
        return null;
    }

    public static void h(QQAppInterface qQAppInterface, MessageForArkApp messageForArkApp, int i3, String str) {
        QLog.d("SDK_SHARE.ForwardOptionUtils", 1, "updateFakeArkMsg errorCode=", Integer.valueOf(i3), ", errorText=", str, ", fakeArkApp.uniseq=", Long.valueOf(messageForArkApp.uniseq));
        if (!messageForArkApp.isSendFromLocal()) {
            QLog.d("SDK_SHARE.ForwardOptionUtils", 1, "fakeArkApp isSendFromLocal false fakeArkApp.issend=" + messageForArkApp.issend);
            return;
        }
        if (Integer.toString(0).equals(messageForArkApp.getExtInfoFromExtStr(com.tencent.mobileqq.service.message.i.f286280w))) {
            QLog.d("SDK_SHARE.ForwardOptionUtils", 1, "updateFailFakeMsg already success\uff0creturn");
            return;
        }
        if (TextUtils.isEmpty(messageForArkApp.getExtInfoFromExtStr(com.tencent.mobileqq.service.message.i.f286282y))) {
            QLog.d("SDK_SHARE.ForwardOptionUtils", 1, "updateFailFakeMsg fakeShareInfo empty\uff0creturn");
            return;
        }
        messageForArkApp.extraflag = 32768;
        messageForArkApp.saveExtInfoToExtStr(com.tencent.mobileqq.service.message.i.f286280w, String.valueOf(i3));
        messageForArkApp.saveExtInfoToExtStr(com.tencent.mobileqq.service.message.i.f286281x, str);
        messageForArkApp.saveMsgData(qQAppInterface);
        messageForArkApp.saveMsgExtStrAndFlag(qQAppInterface);
        qQAppInterface.getMsgCache().G1(messageForArkApp.frienduin, messageForArkApp.istroop, messageForArkApp.uniseq);
        Object[] objArr = new Object[8];
        objArr[0] = messageForArkApp.frienduin;
        objArr[1] = Integer.valueOf(messageForArkApp.istroop);
        objArr[2] = 0;
        objArr[3] = null;
        objArr[4] = 0L;
        objArr[5] = Long.valueOf(messageForArkApp.uniseq);
        qQAppInterface.getMsgHandler().notifyUI(3001, false, objArr);
    }

    public static List<MessageRecord> i(QQAppInterface qQAppInterface, List<MessageRecord> list) {
        if (QLog.isColorLevel()) {
            QLog.d("SDK_SHARE.ForwardOptionUtils", 2, "updateFakeMsg newRecords.size=" + list.size());
        }
        ArrayList arrayList = null;
        for (MessageRecord messageRecord : list) {
            if (messageRecord instanceof MessageForArkApp) {
                MessageForArkApp messageForArkApp = (MessageForArkApp) messageRecord;
                ArkAppMessage arkAppMessage = messageForArkApp.ark_app_message;
                if (arkAppMessage == null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("SDK_SHARE.ForwardOptionUtils", 2, "updateFakeMsg null == serverArkRecord.ark_app_message");
                    }
                } else {
                    long optMsgSeq = arkAppMessage.optMsgSeq();
                    if (optMsgSeq != -1) {
                        MessageRecord w06 = qQAppInterface.getMessageFacade().w0(messageForArkApp.frienduin, messageForArkApp.istroop, optMsgSeq);
                        QLog.d("SDK_SHARE.ForwardOptionUtils", 1, "arkConfig.extraUniseq=", Long.valueOf(optMsgSeq), "fakeRecord=", w06);
                        if (!(w06 instanceof MessageForArkApp)) {
                            QLog.d("SDK_SHARE.ForwardOptionUtils", 1, "error !(fakeRecord instanceof MessageForArkApp)");
                        } else {
                            MessageForArkApp messageForArkApp2 = (MessageForArkApp) w06;
                            ContentValues b16 = b(w06, messageForArkApp);
                            MessageRecord.copyMessageRecordBaseField(w06, messageForArkApp);
                            messageForArkApp2.updateArkAppMetaData(messageForArkApp.ark_app_message.metaList);
                            messageForArkApp2.ark_app_message.mExtra = messageForArkApp.ark_app_message.getFilterExtra();
                            b16.put(AppConstants.Key.COLUMN_EXTRA_FLAG, Integer.valueOf(messageForArkApp2.extraflag));
                            messageForArkApp2.saveExtInfoToExtStr(com.tencent.mobileqq.service.message.i.f286280w, Integer.toString(0));
                            b16.put(AppConstants.Key.COLUMN_EXT_STR, messageForArkApp2.extStr);
                            b16.put(AppConstants.Key.COLUMN_EXT_LONG, Integer.valueOf(messageForArkApp2.extLong));
                            qQAppInterface.getMessageFacade().c1(w06.frienduin, w06.istroop, messageForArkApp2, b16, new int[]{2, 3});
                            qQAppInterface.getMsgHandler().notifyUI(6003, true, new String[]{w06.frienduin, String.valueOf(w06.uniseq)});
                            qQAppInterface.getMsgCache().G1(w06.frienduin, w06.istroop, optMsgSeq);
                            if (arrayList == null) {
                                arrayList = new ArrayList(list);
                            }
                            arrayList.remove(messageForArkApp);
                        }
                    }
                }
            }
        }
        if (arrayList == null) {
            return list;
        }
        return arrayList;
    }
}
