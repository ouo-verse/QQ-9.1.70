package com.tencent.mobileqq.richmedia.ordersend;

import android.text.TextUtils;
import android.view.View;
import com.tencent.image.GifDrawable;
import com.tencent.mobileqq.activity.aio.r;
import com.tencent.mobileqq.activity.aio.y;
import com.tencent.mobileqq.app.BaseMessageObserver;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.bs;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.api.IPicUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.richmedia.ordersend.IOrderMediaMsgService;
import com.tencent.mobileqq.shortvideo.VideoCompressProcessor;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.MobileQQ;

/* compiled from: P */
@KeepClassConstructor
/* loaded from: classes18.dex */
public class MediaMsgController implements com.tencent.mobileqq.richmedia.ordersend.a {

    /* renamed from: a, reason: collision with root package name */
    private QQAppInterface f281593a;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a extends bs {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ BaseMessageObserver f281594d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ MessageRecord f281595e;

        a(BaseMessageObserver baseMessageObserver, MessageRecord messageRecord) {
            this.f281594d = baseMessageObserver;
            this.f281595e = messageRecord;
        }

        @Override // com.tencent.mobileqq.app.bs, com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            long j3;
            if (i3 == 5006) {
                BaseMessageObserver baseMessageObserver = this.f281594d;
                if (baseMessageObserver == null) {
                    Object[] objArr = new Object[4];
                    objArr[0] = "observer is null! uniseq:";
                    MessageRecord messageRecord = this.f281595e;
                    if (messageRecord != null) {
                        j3 = messageRecord.uniseq;
                    } else {
                        j3 = 0;
                    }
                    objArr[1] = Long.valueOf(j3);
                    objArr[2] = " ,isSuccess:";
                    objArr[3] = Boolean.valueOf(z16);
                    QLog.d("MediaMsgController", 1, objArr);
                    return;
                }
                baseMessageObserver.onUpdate(i3, z16, obj);
            }
        }
    }

    public MediaMsgController() {
        this.f281593a = (QQAppInterface) MobileQQ.sMobileQQ.waitAppRuntime();
    }

    @Override // com.tencent.mobileqq.richmedia.ordersend.a
    public void a(MessageRecord messageRecord) {
        if (messageRecord != null && this.f281593a != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (messageRecord instanceof MessageForMixedMsg) {
                this.f281593a.getMessageFacade().m(messageRecord);
            } else {
                ((ISVIPHandler) this.f281593a.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).addSendingBubbleId(messageRecord);
                this.f281593a.getMessageFacade().c(messageRecord, this.f281593a.getCurrentAccountUin());
            }
            if (QLog.isColorLevel()) {
                QLog.d("MediaMsgController", 2, "addMsg cost:" + (System.currentTimeMillis() - currentTimeMillis) + " uniseq = " + messageRecord.uniseq + ", msgtype = " + messageRecord.msgtype);
            }
        }
    }

    @Override // com.tencent.mobileqq.richmedia.ordersend.a
    public void b(View view, r rVar) {
        y d16 = y.d(this.f281593a);
        if (d16 != null) {
            d16.a(view, rVar);
        }
    }

    @Override // com.tencent.mobileqq.richmedia.ordersend.a
    public void c(MessageRecord messageRecord, BaseMessageObserver baseMessageObserver, IOrderMediaMsgService.a aVar) {
        if (messageRecord == null) {
            return;
        }
        if (aVar != null) {
            aVar.onSendBegin(messageRecord);
        }
        this.f281593a.getMessageFacade().D0(messageRecord, new a(baseMessageObserver, messageRecord));
    }

    @Override // com.tencent.mobileqq.richmedia.ordersend.a
    public boolean d(MessageRecord messageRecord) {
        if (m(messageRecord)) {
            k(messageRecord);
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.richmedia.ordersend.a
    public boolean e(int i3) {
        if (i3 != -2000 && i3 != -2022 && i3 != -1035 && i3 != -1036) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0026  */
    @Override // com.tencent.mobileqq.richmedia.ordersend.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int f(MessageRecord messageRecord) {
        int i3;
        if (messageRecord != null) {
            IHttpCommunicatorListener findProcessor = ((ITransFileController) this.f281593a.getRuntimeService(ITransFileController.class)).findProcessor(messageRecord.frienduin, messageRecord.uniseq);
            if (findProcessor instanceof BaseTransProcessor) {
                i3 = ((BaseTransProcessor) findProcessor).getCurrentProgress();
                if (QLog.isColorLevel()) {
                    QLog.d("MediaMsgController", 2, "getUploadProgress:", Integer.valueOf(i3));
                }
                return i3;
            }
        }
        i3 = -1;
        if (QLog.isColorLevel()) {
        }
        return i3;
    }

    @Override // com.tencent.mobileqq.richmedia.ordersend.a
    public String g(MessageRecord messageRecord) {
        if (messageRecord instanceof MessageForShortVideo) {
            return ((MessageForShortVideo) messageRecord).videoFileName;
        }
        if (messageRecord instanceof MessageForPic) {
            return ((MessageForPic) messageRecord).path;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.richmedia.ordersend.a
    public boolean h(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (file.exists() && GifDrawable.isGifFile(file)) {
            if (QLog.isColorLevel()) {
                QLog.d("MediaMsgController", 2, "isDoutuPic gifFile");
            }
            return true;
        }
        int imageType = ((IPicUtil) QRoute.api(IPicUtil.class)).getImageType(str);
        if (imageType != 2000 && imageType != 3) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MediaMsgController", 2, "isDoutuPic imageType:", Integer.valueOf(imageType));
        }
        return true;
    }

    @Override // com.tencent.mobileqq.richmedia.ordersend.a
    public boolean i(MessageRecord messageRecord) {
        int i3;
        if (messageRecord != null && messageRecord.extraflag == 32768) {
            return true;
        }
        if (messageRecord instanceof MessageForShortVideo) {
            i3 = ((MessageForShortVideo) messageRecord).videoFileStatus;
        } else if ((messageRecord instanceof MessageForPic) && ((MessageForPic) messageRecord).size <= 0) {
            i3 = l(messageRecord);
            if (i3 == -1) {
                return true;
            }
        } else {
            i3 = 0;
        }
        return j(i3);
    }

    @Override // com.tencent.mobileqq.richmedia.ordersend.a
    public boolean j(int i3) {
        if (i3 != 1004 && i3 != 1005 && i3 != 2005 && i3 != 5001 && i3 != 5002) {
            return false;
        }
        return true;
    }

    protected void k(MessageRecord messageRecord) {
        QQAppInterface qQAppInterface = this.f281593a;
        VideoCompressProcessor.b().d(messageRecord.uniseq, new VideoCompressProcessor.CompressTask(qQAppInterface, qQAppInterface.getApplication(), (MessageForShortVideo) messageRecord, null));
    }

    public int l(MessageRecord messageRecord) {
        if (messageRecord != null) {
            IHttpCommunicatorListener findProcessor = ((ITransFileController) this.f281593a.getRuntimeService(ITransFileController.class)).findProcessor(messageRecord.frienduin, messageRecord.uniseq);
            if (findProcessor instanceof BaseTransProcessor) {
                return (int) ((BaseTransProcessor) findProcessor).getFileStatus();
            }
        }
        return -1;
    }

    public boolean m(MessageRecord messageRecord) {
        if (messageRecord instanceof MessageForShortVideo) {
            MessageForShortVideo messageForShortVideo = (MessageForShortVideo) messageRecord;
            if (messageForShortVideo.busiType == 0 && messageForShortVideo.videoFileStatus != 998 && TextUtils.isEmpty(messageForShortVideo.md5)) {
                if (QLog.isColorLevel()) {
                    QLog.d("MediaMsgController", 2, "isVideoNeedPreCompress is true, " + messageRecord.uniseq);
                }
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.richmedia.ordersend.a
    public void removeCompressTask(long j3) {
        VideoCompressProcessor.b().c(j3);
    }

    public MediaMsgController(QQAppInterface qQAppInterface) {
        this.f281593a = qQAppInterface;
    }
}
