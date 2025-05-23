package com.qzone.business.gift.business.service;

import NS_MOBILE_TEMPLATE_GIFT.send_common_gift_rsp;
import NS_MOBILE_TEMPLATE_GIFT.send_gift_fail_item;
import android.os.Handler;
import com.qq.taf.jce.JceStruct;
import com.qzone.business.gift.business.protocol.QzoneGiftCommonSendRequest;
import com.qzone.common.business.IQZoneServiceListener;
import com.qzone.common.business.QZoneBusinessLooper;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.common.event.Event;
import com.qzone.common.event.IObserver;
import com.qzone.util.al;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QzoneConfig;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes39.dex */
public class a implements IObserver.background, IQZoneServiceListener {

    /* renamed from: d, reason: collision with root package name */
    private static final al<a, Void> f44528d = new C0356a();

    /* compiled from: P */
    /* renamed from: com.qzone.business.gift.business.service.a$a, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    class C0356a extends al<a, Void> {
        C0356a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.qzone.util.al
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public a a(Void r16) {
            return new a();
        }
    }

    a() {
    }

    public static a b() {
        return f44528d.get(null);
    }

    public void c(h5.a aVar, Handler handler) {
        QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new QzoneGiftCommonSendRequest(aVar.a()), handler, this, 10));
    }

    private void a(QZoneTask qZoneTask) {
        QZoneResult result = qZoneTask.getResult(1000004);
        String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "SendGiftSuccess", "\u8d60\u9001\u793c\u7269\u6210\u529f\uff01");
        if (result.getSucceed()) {
            JceStruct jceStruct = qZoneTask.mRequest.rsp;
            send_common_gift_rsp send_common_gift_rspVar = jceStruct instanceof send_common_gift_rsp ? (send_common_gift_rsp) jceStruct : null;
            if (send_common_gift_rspVar != null) {
                ArrayList<send_gift_fail_item> arrayList = send_common_gift_rspVar.failList;
                StringBuffer stringBuffer = new StringBuffer();
                if (arrayList != null && arrayList.size() > 0) {
                    for (int i3 = 0; i3 < arrayList.size(); i3++) {
                        send_gift_fail_item send_gift_fail_itemVar = arrayList.get(i3);
                        if (send_gift_fail_itemVar != null) {
                            stringBuffer.append(send_gift_fail_itemVar.name);
                            stringBuffer.append(":");
                            stringBuffer.append(send_gift_fail_itemVar.reason);
                            stringBuffer.append("\n");
                        }
                    }
                    stringBuffer.delete(stringBuffer.length() - 1, stringBuffer.length());
                    result.setMessage(stringBuffer.toString());
                } else {
                    result.setMessage(config);
                }
            } else {
                result.setMessage(config);
            }
            result.setData(Boolean.TRUE);
        } else {
            result.setData(Boolean.FALSE);
        }
        qZoneTask.sendResultMsg(result);
    }

    @Override // com.qzone.common.business.IQZoneServiceListener
    public void onTaskResponse(QZoneTask qZoneTask) {
        if (qZoneTask != null && qZoneTask.mType == 10) {
            a(qZoneTask);
        }
    }

    @Override // com.qzone.common.event.IObserver.background
    public void onEventBackgroundThread(Event event) {
    }
}
