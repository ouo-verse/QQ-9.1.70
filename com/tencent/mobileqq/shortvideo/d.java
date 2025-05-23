package com.tencent.mobileqq.shortvideo;

import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMultiMsgProxy;
import com.tencent.mobileqq.pic.ad;
import com.tencent.mobileqq.pic.m;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import tencent.im.msg.im_msg_body$RichText;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes18.dex */
public class d implements com.tencent.mobileqq.pic.ad {

    /* renamed from: d, reason: collision with root package name */
    private final MultiForwardShortVideoTask f287847d;

    /* renamed from: e, reason: collision with root package name */
    final int f287848e;

    /* renamed from: f, reason: collision with root package name */
    y f287849f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(MultiForwardShortVideoTask multiForwardShortVideoTask, int i3) {
        this.f287847d = multiForwardShortVideoTask;
        this.f287848e = i3;
        this.f287849f = multiForwardShortVideoTask.f287621f.get(i3);
    }

    @Override // com.tencent.mobileqq.pic.ad
    public MessageRecord g(im_msg_body$RichText im_msg_body_richtext) {
        return (MessageForShortVideo) this.f287847d.f287620e.get(this.f287848e).f288210x;
    }

    @Override // com.tencent.mobileqq.pic.ad
    public void q(ad.a aVar) {
        synchronized (this.f287847d.f287621f) {
            if (aVar.f258597a == 0) {
                r(aVar);
                this.f287849f.f288328a = 0;
                if (QLog.isColorLevel()) {
                    QLog.d("BaseShortVideoOprerator", 2, "onsend success!");
                }
            } else {
                y yVar = this.f287849f;
                yVar.f288328a = -1;
                yVar.f288329b = new m.a();
                m.a aVar2 = this.f287849f.f288329b;
                aVar2.f258737b = aVar.f258599c;
                aVar2.f258738c = aVar.f258598b;
                if (QLog.isColorLevel()) {
                    QLog.d("BaseShortVideoOprerator", 2, "onsend fail! err:" + aVar.f258599c);
                }
            }
            int g16 = this.f287847d.g();
            if (g16 == 0) {
                MultiForwardShortVideoTask multiForwardShortVideoTask = this.f287847d;
                multiForwardShortVideoTask.f287619d.x(3, 0, multiForwardShortVideoTask.f287621f);
            } else {
                MultiForwardShortVideoTask multiForwardShortVideoTask2 = this.f287847d;
                if (multiForwardShortVideoTask2.f287622h == multiForwardShortVideoTask2.f287620e.size() - g16) {
                    this.f287847d.h();
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.pic.ad
    public void r(ad.a aVar) {
        MessageForShortVideo messageForShortVideo = (MessageForShortVideo) this.f287847d.f287620e.get(this.f287848e).f288210x;
        messageForShortVideo.videoFileStatus = 1003;
        messageForShortVideo.md5 = aVar.f258603g;
        messageForShortVideo.uuid = aVar.f258602f;
        messageForShortVideo.thumbFileSize = (int) aVar.f258605i;
        messageForShortVideo.videoAttr = aVar.f258606j;
        messageForShortVideo.videoKandianType = aVar.f258607k;
        messageForShortVideo.serial();
        ((IMultiMsgProxy) QRoute.api(IMultiMsgProxy.class)).updateMultiMsg(this.f287847d.f287619d.f287783d, messageForShortVideo);
    }
}
