package com.tencent.mobileqq.gamecenter.share;

import android.os.Bundle;
import android.os.Message;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.luggage.wxa.gf.n0;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqgamepub.api.IGameShareUtil;
import com.tencent.mobileqq.qqgamepub.data.GetArkTailReq;
import com.tencent.mobileqq.qqgamepub.data.GetArkTailRsp;
import com.tencent.mobileqq.qqgamepub.data.ReportTypeReq;
import com.tencent.mobileqq.qqgamepub.data.ReportTypeRsp;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletApi;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import mqq.observer.BusinessObserver;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GameShareNetHelper {

    /* renamed from: b, reason: collision with root package name */
    private static volatile GameShareNetHelper f213210b;

    /* renamed from: a, reason: collision with root package name */
    private Map<MessageRecord, Long> f213211a = new HashMap();

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements BusinessObserver {
        a() {
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            ReportTypeRsp reportTypeRsp = (ReportTypeRsp) bundle.getSerializable("rsp");
            if (QLog.isColorLevel()) {
                QLog.d("NetHelper", 2, "ReportTypeRsp reportObserver:" + z16 + "|" + reportTypeRsp);
            }
        }
    }

    public static GameShareNetHelper b() {
        if (f213210b == null) {
            synchronized (GameShareNetHelper.class) {
                if (f213210b == null) {
                    f213210b = new GameShareNetHelper();
                }
            }
        }
        return f213210b;
    }

    public void c(String str, int i3, int i16) {
        ReportTypeReq reportTypeReq = new ReportTypeReq();
        reportTypeReq.appid = str;
        reportTypeReq.type = i3;
        reportTypeReq.subType = i16;
        reportTypeReq.f264495tt = 1;
        ((IQWalletApi) QRoute.api(IQWalletApi.class)).servletSendRequest(reportTypeReq, new a());
    }

    public void d(long j3, final MessageRecord messageRecord) {
        long longValue;
        if (messageRecord == null) {
            return;
        }
        Long l3 = this.f213211a.get(messageRecord);
        if (l3 == null) {
            longValue = 0;
        } else {
            longValue = l3.longValue();
        }
        Long valueOf = Long.valueOf(longValue);
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        if (serverTimeMillis - valueOf.longValue() <= 30000) {
            return;
        }
        this.f213211a.put(messageRecord, Long.valueOf(serverTimeMillis));
        BaseQQAppInterface qQAppInterface = ((IQWalletApi) QRoute.api(IQWalletApi.class)).getQQAppInterface();
        if (qQAppInterface == null) {
            return;
        }
        GetArkTailReq getArkTailReq = new GetArkTailReq();
        getArkTailReq.appid = j3 + "";
        getArkTailReq.f264493tt = 1;
        getArkTailReq.sceneId = 1;
        getArkTailReq.qqVersion = ah.P();
        final WeakReference weakReference = new WeakReference(qQAppInterface);
        ((IQWalletApi) QRoute.api(IQWalletApi.class)).servletSendRequest(getArkTailReq, new BusinessObserver() { // from class: com.tencent.mobileqq.gamecenter.share.GameShareNetHelper.2
            @Override // mqq.observer.BusinessObserver
            public void onReceive(int i3, boolean z16, Bundle bundle) {
                GetArkTailRsp getArkTailRsp = (GetArkTailRsp) bundle.getSerializable("rsp");
                if (QLog.isColorLevel()) {
                    QLog.d("NetHelper", 2, "GetArkTailRsp reportObserver:" + z16 + "|" + getArkTailRsp + "|msghashcode:" + messageRecord.hashCode());
                }
                if (z16 && getArkTailRsp != null) {
                    ((IGameShareUtil) QRoute.api(IGameShareUtil.class)).saveValueToMsg(IGameShareUtil.KEY_SOURCE_AIO_TXT, getArkTailRsp.desc, messageRecord);
                    ((IGameShareUtil) QRoute.api(IGameShareUtil.class)).saveValueToMsg(IGameShareUtil.KEY_SOURCE_AIO_URL, getArkTailRsp.jumpUrl, messageRecord);
                    ((IGameShareUtil) QRoute.api(IGameShareUtil.class)).saveValueToMsg(IGameShareUtil.KEY_SOURCE_AIO_TYPE, getArkTailRsp.type + "", messageRecord);
                    ((IGameShareUtil) QRoute.api(IGameShareUtil.class)).saveValueToMsg(IGameShareUtil.KEY_SOURCE_AIO_SUBTYPE, getArkTailRsp.subType + "", messageRecord);
                    final QQAppInterface qQAppInterface2 = (QQAppInterface) weakReference.get();
                    if (qQAppInterface2 != null) {
                        MqqHandler handler = qQAppInterface2.getHandler(ChatActivity.class);
                        if (handler != null) {
                            Message message = new Message();
                            message.what = 80;
                            message.arg1 = n0.CTRL_INDEX;
                            Bundle bundle2 = new Bundle();
                            bundle2.putLong("messageUniseq", messageRecord.uniseq);
                            message.setData(bundle2);
                            handler.sendMessage(message);
                        }
                        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.share.GameShareNetHelper.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                QQMessageFacade messageFacade = qQAppInterface2.getMessageFacade();
                                MessageRecord messageRecord2 = messageRecord;
                                messageFacade.a1(messageRecord2.frienduin, messageRecord2.istroop, messageRecord2.uniseq, AppConstants.Key.COLUMN_EXT_STR, messageRecord2.extStr);
                            }
                        }, 32, null, false);
                    }
                }
                GameShareNetHelper.this.f213211a.remove(messageRecord);
            }
        });
    }
}
