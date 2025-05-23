package com.tencent.biz.richframework.network.servlet;

import NS_COMM.COMM;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.richframework.network.request.QzoneAioStoryFeedRequest;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.observer.QZoneObserver;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import mqq.app.MSFServlet;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QzoneAioStoryFeedServlet extends MSFServlet {
    public static final String KEY_EXT = "key_ext";
    public static final String KEY_FOR_AIO_STORY_FEED_DATA = "KEY_FOR_AIO_STORY_FEED_DATA";
    public static final String KEY_FRIEND_UIN = "key_friend_uid";
    public static final String KEY_LAST_AIO_STORY_CREATE_TIME = "key_last_aio_story_create_time";
    public static final String TAG = "QzoneAioStoryFeedServlet";

    public String getTraceId() {
        String account = BaseApplicationImpl.sApplication.getRuntime().getAccount();
        StringBuilder sb5 = new StringBuilder(50);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMddHHmmss");
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        sb5.append(account);
        sb5.append("_");
        sb5.append(simpleDateFormat.format(new Date()));
        sb5.append(System.currentTimeMillis() % 1000);
        sb5.append("_");
        sb5.append(random.nextInt(90000) + 10000);
        return sb5.toString();
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        try {
            Bundle bundle = new Bundle();
            if (fromServiceMsg != null) {
                if (fromServiceMsg.isSuccess()) {
                    bundle.putParcelable(KEY_FOR_AIO_STORY_FEED_DATA, fromServiceMsg);
                    notifyObserver(intent, 1010, true, bundle, QZoneObserver.class);
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "inform QzoneAioStoryFeedServlet isSuccess false:", fromServiceMsg.getBusinessFailMsg());
                    }
                    notifyObserver(intent, 1010, false, bundle, QZoneObserver.class);
                }
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5 + "onReceive error");
            notifyObserver(null, 1010, false, null, QZoneObserver.class);
        }
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        COMM.StCommonExt stCommonExt;
        long longExtra = intent.getLongExtra(KEY_LAST_AIO_STORY_CREATE_TIME, 0L);
        long longExtra2 = intent.getLongExtra(KEY_FRIEND_UIN, -1L);
        byte[] byteArrayExtra = intent.getByteArrayExtra("key_ext");
        if (byteArrayExtra != null) {
            COMM.StCommonExt stCommonExt2 = new COMM.StCommonExt();
            try {
                stCommonExt2.mergeFrom(byteArrayExtra);
            } catch (InvalidProtocolBufferMicroException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "onSend. mergeFrom exception!");
                }
                e16.printStackTrace();
            }
            stCommonExt = stCommonExt2;
        } else {
            stCommonExt = null;
        }
        byte[] encode = new QzoneAioStoryFeedRequest(stCommonExt, longExtra, longExtra2).encode(intent, -1, getTraceId());
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setSSOCommand(QzoneAioStoryFeedRequest.CMD_STRING);
        packet.putSendData(fh.b(encode));
        packet.setTimeout(intent.getLongExtra("timeout", 30000L));
    }
}
