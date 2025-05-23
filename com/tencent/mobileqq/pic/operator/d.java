package com.tencent.mobileqq.pic.operator;

import android.graphics.BitmapFactory;
import com.tencent.image.GifDrawable;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.msg.api.IMessageRecordFactory;
import com.tencent.mobileqq.pic.l;
import com.tencent.mobileqq.pic.v;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.BaseTransFileController;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.PicFowardDbRecordData;
import com.tencent.mobileqq.transfile.RichMediaUtil;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes16.dex */
public abstract class d extends BasePicOperator {
    static IPatchRedirector $redirector_;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MessageRecord p(l lVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 2, (Object) this, (Object) lVar);
        }
        if (lVar != null && lVar.f258730e) {
            long currentTimeMillis = System.currentTimeMillis();
            v vVar = lVar.f258731f;
            PicFowardDbRecordData picFowardDbRecordData = new PicFowardDbRecordData();
            picFowardDbRecordData.fowardThumbPath = vVar.L;
            MessageForPic messageForPic = (MessageForPic) ((IMessageRecordFactory) QRoute.api(IMessageRecordFactory.class)).createSendMSg_Pic(this.f258754m, vVar.f258715m, vVar.C, vVar.f258713h);
            messageForPic.path = vVar.K;
            boolean z16 = true;
            messageForPic.type = 1;
            File file = new File(vVar.K);
            if (file.exists()) {
                if (GifDrawable.isGifFile(file)) {
                    messageForPic.imageType = 2000;
                }
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                options.inSampleSize = 1;
                SafeBitmapFactory.decodeFile(vVar.K, options);
                messageForPic.width = options.outWidth;
                messageForPic.height = options.outHeight;
                if (RichMediaUtil.isPicLandscape(vVar.K)) {
                    messageForPic.width = options.outHeight;
                    messageForPic.height = options.outWidth;
                    if (QLog.isColorLevel()) {
                        com.tencent.mobileqq.pic.f.c(this.f258750e, this.f258749d, "packForwardMsg", " pic is Landscape,swap w,h; options.outWidth = " + options.outWidth + ",options.outHeight = " + options.outHeight + ",mr.width = " + messageForPic.width + ",mr.height = " + messageForPic.height);
                    }
                }
                messageForPic.md5 = vVar.J;
            }
            messageForPic.fileSizeFlag = lVar.f258731f.f258818d0;
            com.tencent.mobileqq.pic.k kVar = lVar.f258732h;
            if (kVar != null) {
                String str = kVar.J;
                if (str != null) {
                    messageForPic.md5 = str;
                }
                long j3 = kVar.D;
                if (j3 != 0) {
                    picFowardDbRecordData.fowardOrgId = j3;
                }
                String str2 = kVar.f258715m;
                if (str2 != null) {
                    picFowardDbRecordData.fowardOrgUin = str2;
                }
                int i3 = kVar.f258713h;
                if (i3 != -1) {
                    picFowardDbRecordData.fowardOrgUinType = i3;
                }
                String str3 = kVar.K;
                if (str3 != null) {
                    picFowardDbRecordData.fowardOrgUrl = str3;
                }
            }
            if (vVar.f258832r0 != -1) {
                PicMessageExtraData picMessageExtraData = new PicMessageExtraData();
                picMessageExtraData.imageBizType = vVar.f258832r0;
                messageForPic.picExtraData = picMessageExtraData;
            }
            messageForPic.picExtraFlag = 10;
            messageForPic.picExtraObject = picFowardDbRecordData;
            v.b bVar = vVar.A0;
            if (bVar == null) {
                z16 = false;
            }
            if (z16) {
                messageForPic.msgseq = bVar.f258841a;
                messageForPic.shmsgseq = bVar.f258842b;
                messageForPic.msgUid = bVar.f258843c;
            }
            messageForPic.localUUID = vVar.f258711e;
            com.tencent.mobileqq.pic.f.c(this.f258750e, this.f258749d, "bindUrlKeyAndUniseq", messageForPic.localUUID + "|" + messageForPic.uniseq);
            messageForPic.imageType = com.tencent.mobileqq.v.a(vVar.K);
            ArrayList<Integer> arrayList = vVar.P;
            if (arrayList != null && !arrayList.isEmpty()) {
                n(vVar, messageForPic);
                messageForPic.imageType = 1003;
            } else if (QLog.isColorLevel()) {
                QLog.d("peak_pgjpeg", 2, "Slice infos is null");
            }
            messageForPic.serial();
            vVar.D = messageForPic.uniseq;
            ITransFileController iTransFileController = (ITransFileController) this.f258754m.getRuntimeService(ITransFileController.class, "");
            if (iTransFileController != 0) {
                iTransFileController.addProcessor(messageForPic.frienduin + messageForPic.uniseq, new BaseTransProcessor((BaseTransFileController) iTransFileController));
            }
            o(messageForPic);
            com.tencent.mobileqq.pic.f.c(this.f258750e, this.f258749d, "packForwardMsg", "cost:" + (System.currentTimeMillis() - currentTimeMillis));
            com.tencent.mobileqq.pic.f.c(this.f258750e, this.f258749d, "packForwardMsg", "retry:" + z16);
            return messageForPic;
        }
        return null;
    }
}
