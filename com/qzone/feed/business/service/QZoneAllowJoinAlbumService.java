package com.qzone.feed.business.service;

import NS_MOBILE_PHOTO.AllowJoinShareAlbum;
import NS_MOBILE_PHOTO.JoinShareAlbumRsp;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.qzone.album.protocol.QZoneJoinShareAlbumRequest;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.IQZoneServiceListener;
import com.qzone.common.business.QZoneBusinessLooper;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.common.protocol.request.QZoneRequest;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.util.al;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneAllowJoinAlbumService implements IQZoneServiceListener {

    /* renamed from: f, reason: collision with root package name */
    private static final al<QZoneAllowJoinAlbumService, Void> f47164f = new a();

    /* renamed from: d, reason: collision with root package name */
    private final String f47165d = "QZoneAllowJoinAlbumService";

    /* renamed from: e, reason: collision with root package name */
    private final int f47166e = 0;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a extends al<QZoneAllowJoinAlbumService, Void> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.qzone.util.al
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public QZoneAllowJoinAlbumService a(Void r16) {
            return new QZoneAllowJoinAlbumService();
        }
    }

    public static QZoneAllowJoinAlbumService b() {
        return f47164f.get(null);
    }

    public void a(final Handler handler, final BusinessFeedData businessFeedData) {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).post(new Runnable() { // from class: com.qzone.feed.business.service.QZoneAllowJoinAlbumService.2
            @Override // java.lang.Runnable
            public void run() {
                BusinessFeedData businessFeedData2 = businessFeedData;
                if (businessFeedData2 == null || businessFeedData2.getFeedCommInfo() == null || businessFeedData.getFeedCommInfo().extendInfoData == null) {
                    return;
                }
                long uin = LoginData.getInstance().getUin();
                if (businessFeedData.getFeedCommInfo().extendInfoData.get("photo_invite_jce") != null) {
                    QZoneTask qZoneTask = new QZoneTask(new QZoneJoinShareAlbumRequest(uin, 2, null, new AllowJoinShareAlbum(1, businessFeedData.getFeedCommInfo().extendInfoData.get("photo_invite_jce"))), handler, QZoneAllowJoinAlbumService.this, 0);
                    qZoneTask.addParameter("allow_feed", businessFeedData);
                    QZoneBusinessLooper.getInstance().runTask(qZoneTask);
                }
            }
        });
    }

    @Override // com.qzone.common.business.IQZoneServiceListener
    public void onTaskResponse(QZoneTask qZoneTask) {
        if (qZoneTask != null && qZoneTask.mType == 0) {
            c(qZoneTask);
        }
    }

    private void c(QZoneTask qZoneTask) {
        JceStruct jceStruct;
        if (qZoneTask == null) {
            return;
        }
        QZoneResult result = qZoneTask.getResult(1000196);
        if (qZoneTask.succeeded()) {
            if (qZoneTask.getParameter("allow_feed") instanceof BusinessFeedData) {
                BusinessFeedData businessFeedData = (BusinessFeedData) qZoneTask.getParameter("allow_feed");
                QZoneRequest qZoneRequest = qZoneTask.mRequest;
                if (qZoneRequest != null && (jceStruct = qZoneRequest.rsp) != null && (jceStruct instanceof JoinShareAlbumRsp)) {
                    JoinShareAlbumRsp joinShareAlbumRsp = (JoinShareAlbumRsp) jceStruct;
                    int i3 = joinShareAlbumRsp.ret;
                    String str = joinShareAlbumRsp.f25029msg;
                    QZoneJoinShareAlbumRequest.a aVar = new QZoneJoinShareAlbumRequest.a();
                    aVar.f43949a = i3;
                    aVar.f43950b = str;
                    Bundle bundle = new Bundle();
                    if (i3 == 0) {
                        ParcelableWrapper.putDataToBundle(bundle, "allow_feed", businessFeedData);
                    } else {
                        QLog.i("QZoneAllowJoinAlbumService", 1, "onAllowJoinShare fail ret:" + i3 + "msg:" + str);
                    }
                    bundle.putInt("ret_code", i3);
                    result.setData(bundle);
                }
            }
            result.setSucceed(true);
        } else {
            if (!TextUtils.isEmpty(qZoneTask.f45835msg)) {
                result.setFailReason(qZoneTask.f45835msg);
            }
            result.setSucceed(false);
        }
        qZoneTask.sendResultMsg(result);
    }
}
