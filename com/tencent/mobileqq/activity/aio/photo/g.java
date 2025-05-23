package com.tencent.mobileqq.activity.aio.photo;

import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.r;
import com.tencent.mobileqq.activity.aio.y;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.v;
import com.tencent.mobileqq.transfile.BaseDownloadProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes10.dex */
public class g implements r {
    private long C;
    private int D;
    private int E;

    /* renamed from: d, reason: collision with root package name */
    private String[] f179741d;

    /* renamed from: e, reason: collision with root package name */
    private String f179742e;

    /* renamed from: f, reason: collision with root package name */
    private int f179743f = 0;

    /* renamed from: h, reason: collision with root package name */
    private QQAppInterface f179744h;

    /* renamed from: i, reason: collision with root package name */
    private MessageForShortVideo f179745i;

    /* renamed from: m, reason: collision with root package name */
    private i f179746m;

    public g(QQAppInterface qQAppInterface, MessageForShortVideo messageForShortVideo, i iVar, long j3, int i3, int i16) {
        this.f179744h = qQAppInterface;
        this.f179745i = messageForShortVideo;
        this.f179746m = iVar;
        this.C = j3;
        this.D = i3;
        this.E = i16;
    }

    private void b(FileMsg fileMsg) {
        int i3 = fileMsg.status;
        if (i3 != 2002) {
            if (i3 != 2003) {
                if (i3 != 2005) {
                    if (i3 != 5001) {
                        if (i3 == 5002) {
                            this.f179743f = fileMsg.errorCode;
                            if (QLog.isColorLevel()) {
                                QLog.d("carverW GetUrlAction", 2, "handleMessage STATUS_FILE_EXPIRED  error = " + this.f179743f);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    this.f179743f = fileMsg.errorCode;
                    if (QLog.isColorLevel()) {
                        QLog.d("carverW GetUrlAction", 2, "handleMessage STATUS_FILE_UNSAFE  error = " + this.f179743f);
                        return;
                    }
                    return;
                }
                this.f179743f = fileMsg.errorCode;
                if (QLog.isColorLevel()) {
                    QLog.d("carverW GetUrlAction", 2, "handleMessage STATUS_RECV_ERROR  error = " + this.f179743f);
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("carverW GetUrlAction", 2, "handleMessage STATUS_RECV_FINISHED");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("carverW GetUrlAction", 2, "STATUS_RECV_PROCESS: get url finished urls=" + fileMsg.urls + " domain =" + fileMsg.domain + " mMsg=" + this.f179745i);
        }
        String[] strArr = fileMsg.urls;
        if (strArr != null) {
            this.f179741d = strArr;
            String str = fileMsg.domain;
            this.f179742e = str;
            if (!StringUtil.isEmpty(str)) {
                StringBuilder sb5 = new StringBuilder();
                String[] strArr2 = this.f179741d;
                sb5.append(strArr2[0]);
                sb5.append("&txhost=");
                sb5.append(this.f179742e);
                strArr2[0] = sb5.toString();
            }
            MessageForShortVideo messageForShortVideo = this.f179745i;
            if (messageForShortVideo != null && MessageForShortVideo.class.isInstance(messageForShortVideo) && this.f179746m != null) {
                this.f179746m.j0(this.C, this.D, this.E, com.tencent.mobileqq.shortvideo.j.j(this.f179745i, "mp4"), this.f179741d, this.f179742e, this.f179745i, fileMsg.fileType, null);
            }
        }
    }

    public void a() {
        MessageForShortVideo messageForShortVideo = this.f179745i;
        IHttpCommunicatorListener findProcessor = ((ITransFileController) this.f179744h.getRuntimeService(ITransFileController.class)).findProcessor(messageForShortVideo.frienduin, messageForShortVideo.uniseq);
        if (findProcessor != null && (findProcessor instanceof BaseDownloadProcessor)) {
            ((BaseDownloadProcessor) findProcessor).cancel();
        }
        View view = new View(BaseApplicationImpl.getApplication());
        y d16 = y.d(this.f179744h);
        if (d16 != null) {
            d16.a(view, this);
        }
        v c16 = com.tencent.mobileqq.shortvideo.h.c(this.f179744h, this.f179745i, 1);
        if (c16 != null) {
            com.tencent.mobileqq.shortvideo.l.e(c16, this.f179744h);
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.r
    public void handleMessage(View view, FileMsg fileMsg, int i3, int i16) {
        MessageForShortVideo messageForShortVideo = this.f179745i;
        if (messageForShortVideo != null && messageForShortVideo.uniseq == fileMsg.uniseq) {
            if (QLog.isColorLevel()) {
                QLog.d("carverW GetUrlAction", 2, " handleMessage what==" + i3 + ", arg1:" + i16 + " fileType=" + fileMsg.fileType + " status=" + fileMsg.status + " msg.id=" + this.f179745i.uniseq);
            }
            int i17 = fileMsg.fileType;
            if (i17 == 6 || i17 == 17 || i17 == 9 || i17 == 67 || i17 == 20) {
                b(fileMsg);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("carverW GetUrlAction", 2, " handleMessage return file.uniseq=" + fileMsg.uniseq);
        }
    }
}
