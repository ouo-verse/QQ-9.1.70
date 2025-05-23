package com.tencent.mobileqq.emosm.favroaming;

import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.pic.ad;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import tencent.im.msg.im_msg_body$RichText;

/* compiled from: P */
/* loaded from: classes6.dex */
public class b implements ad, j {

    /* renamed from: d, reason: collision with root package name */
    BaseQQAppInterface f204327d;

    /* renamed from: e, reason: collision with root package name */
    CustomEmotionData f204328e;

    /* renamed from: f, reason: collision with root package name */
    c f204329f;

    /* renamed from: h, reason: collision with root package name */
    public int f204330h;

    public b(BaseQQAppInterface baseQQAppInterface, c cVar, int i3) {
        this.f204327d = baseQQAppInterface;
        this.f204329f = cVar;
        this.f204330h = i3;
    }

    public static void c(b bVar) {
        if (bVar != null) {
            ad.a aVar = new ad.a();
            aVar.f258597a = -1;
            bVar.q(aVar);
        }
    }

    protected void a() {
        if (QLog.isColorLevel()) {
            QLog.d("EmoBatchAdded", 2, "EmoBatchAddedCallback  handlePicResultOk()");
        }
        CustomEmotionData customEmotionData = this.f204328e;
        if (!customEmotionData.isMarkFace && TextUtils.isEmpty(customEmotionData.md5)) {
            byte[] fileMd5 = MD5.getFileMd5(this.f204328e.emoPath);
            this.f204328e.md5 = HexUtil.bytes2HexStr(fileMd5);
            EntityManager createEntityManager = this.f204327d.getEntityManagerFactory().createEntityManager();
            if (createEntityManager != null) {
                createEntityManager.update(this.f204328e);
                createEntityManager.close();
            }
        }
        ((IFavroamingDBManagerService) this.f204327d.getRuntimeService(IFavroamingDBManagerService.class)).insertCustomEmotion(this.f204328e);
        this.f204329f.b(4);
        MqqHandler handler = this.f204327d.getHandler(((IEmosmService) QRoute.api(IEmosmService.class)).getChatActivityClass());
        if (handler != null) {
            handler.obtainMessage(10).sendToTarget();
        }
    }

    @Override // com.tencent.mobileqq.emosm.favroaming.j
    public void b(CustomEmotionData customEmotionData) {
        this.f204328e = customEmotionData;
    }

    @Override // com.tencent.mobileqq.pic.ad
    public MessageRecord g(im_msg_body$RichText im_msg_body_richtext) {
        return null;
    }

    @Override // com.tencent.mobileqq.emosm.favroaming.j
    public int getEmoId() {
        return this.f204330h;
    }

    @Override // com.tencent.mobileqq.emosm.favroaming.j
    public k getHandler() {
        return this.f204329f;
    }

    @Override // com.tencent.mobileqq.emosm.favroaming.j
    public void m(int i3) {
        if (400010 != i3 && 400011 != i3) {
            this.f204329f.b(3);
        } else {
            this.f204329f.b(1);
        }
    }

    @Override // com.tencent.mobileqq.pic.ad
    public void q(ad.a aVar) {
        int i3 = aVar.f258597a;
        if (QLog.isColorLevel()) {
            QLog.d("EmoBatchAdded", 2, "EmoBatchAddedCallback  onSend() res=" + i3);
        }
        if (i3 == 0) {
            a();
            return;
        }
        if (-1 == i3) {
            int i16 = aVar.f258598b;
            if (QLog.isColorLevel()) {
                QLog.d("EmoBatchAdded", 2, "add custom emotion result errCode=" + i16);
            }
            m(i16);
        }
    }

    @Override // com.tencent.mobileqq.pic.ad
    public void r(ad.a aVar) {
    }
}
