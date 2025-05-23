package com.tencent.mobileqq.richmediabrowser.api.impl;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import com.tencent.mobileqq.comment.DanmuItemBean;
import com.tencent.mobileqq.comment.a;
import com.tencent.mobileqq.comment.b;
import com.tencent.mobileqq.comment.c;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.api.ICommentDanmakuDepend;
import com.tencent.mobileqq.richmediabrowser.api.IDanmuDataIPCServer;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

/* loaded from: classes18.dex */
public class DanmuDataIPCServerImpl extends QIPCModule implements IDanmuDataIPCServer, c.InterfaceC7462c {
    public static final String TAG = "DanmuDataIPCServer";
    private static volatile DanmuDataIPCServerImpl mInstance;

    public DanmuDataIPCServerImpl() {
        super("DanmuDataIPCServer");
    }

    public static DanmuDataIPCServerImpl getInstance() {
        if (mInstance == null) {
            synchronized (DanmuDataIPCServerImpl.class) {
                if (mInstance == null) {
                    mInstance = new DanmuDataIPCServerImpl();
                }
            }
        }
        return mInstance;
    }

    private static long[] toArray(List<Long> list) {
        long[] jArr = new long[list.size()];
        Iterator<Long> it = list.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            jArr[i3] = it.next().longValue();
            i3++;
        }
        return jArr;
    }

    @Override // com.tencent.mobileqq.richmediabrowser.api.IDanmuDataIPCServer
    public QIPCModule getDanmuIPCServer() {
        return getInstance();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0063  */
    @Override // com.tencent.mobileqq.richmediabrowser.api.IDanmuDataIPCServer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void notifyDanmuSendResult(long j3, long j16, String str, String str2, long j17, SpannableString spannableString) {
        String str3;
        boolean aioAnonymousStatus;
        QLog.d("DanmuDataIPCServer", 1, "notifyDanmuSendResult");
        if (spannableString != null) {
            String spannableString2 = spannableString.toString();
            if (str.length() > spannableString2.length() && str.startsWith(spannableString2)) {
                String substring = str.substring(spannableString.length());
                if (!TextUtils.isEmpty(substring)) {
                    str3 = substring;
                    DanmuItemBean danmuItemBean = new DanmuItemBean(Long.parseLong(MobileQQ.sMobileQQ.waitAppRuntime(null).getCurrentUin()), 0L, j3, j16, str3, "");
                    aioAnonymousStatus = ((ICommentDanmakuDepend) QRoute.api(ICommentDanmakuDepend.class)).getAioAnonymousStatus(str2);
                    danmuItemBean.C = aioAnonymousStatus;
                    if (aioAnonymousStatus) {
                        if (QLog.isColorLevel()) {
                            QLog.d("DanmuDataIPCServer", 2, "notifyDanmuSendResult, anonymousFlag true");
                        }
                        danmuItemBean.D = ((ICommentDanmakuDepend) QRoute.api(ICommentDanmakuDepend.class)).getAnonymousNickName(str2);
                        danmuItemBean.E = ((ICommentDanmakuDepend) QRoute.api(ICommentDanmakuDepend.class)).getAnonymousHeadId(str2);
                    }
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("key_barrage_danmu_msg", danmuItemBean);
                    bundle.putLong("key_barrage_msg_seq", j17);
                    bundle.putString("key_barrage_grp_uin", str2);
                    QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:peak", "DanmuDataIPCClient", "qipc_action_send_barrage", bundle, null);
                }
            }
        }
        str3 = str;
        DanmuItemBean danmuItemBean2 = new DanmuItemBean(Long.parseLong(MobileQQ.sMobileQQ.waitAppRuntime(null).getCurrentUin()), 0L, j3, j16, str3, "");
        aioAnonymousStatus = ((ICommentDanmakuDepend) QRoute.api(ICommentDanmakuDepend.class)).getAioAnonymousStatus(str2);
        danmuItemBean2.C = aioAnonymousStatus;
        if (aioAnonymousStatus) {
        }
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable("key_barrage_danmu_msg", danmuItemBean2);
        bundle2.putLong("key_barrage_msg_seq", j17);
        bundle2.putString("key_barrage_grp_uin", str2);
        QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:peak", "DanmuDataIPCClient", "qipc_action_send_barrage", bundle2, null);
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        a aVar;
        if ("qipc_action_get_barrage".equals(str)) {
            long j3 = bundle.getLong("key_barrage_msg_seq");
            long j16 = bundle.getLong("key_barrage_grp_uin");
            int i16 = bundle.getInt("key_barrage_topic_type");
            boolean z16 = bundle.getBoolean("key_barrage_is_update");
            QLog.d("DanmuDataIPCServer", 1, "onCall, msgSeq:", Long.valueOf(j3), " groupUin:", Long.valueOf(j16), " topicType:", Integer.valueOf(i16), " peakCached:", Boolean.valueOf(z16));
            b.a c16 = b.f().c(b.f().d(j16, j3));
            if (c16 != null && !c16.f201748c) {
                QLog.d("DanmuDataIPCServer", 1, "filter duplicate request, continue pull is not completed");
                Bundle bundle2 = new Bundle();
                bundle2.putBoolean("key_barrage_is_success", false);
                callbackResult(i3, EIPCResult.createSuccessResult(bundle2));
                return null;
            }
            if (c16 == null) {
                aVar = new a(j16, j3, i16, z16);
            } else {
                aVar = c16.f201747b;
            }
            aVar.f201739e = bundle.getLong("key_barrage_req_time");
            aVar.f201740f = System.currentTimeMillis();
            aVar.f201738d = z16;
            b.f().h(aVar, this);
            callbackResult(i3, EIPCResult.createSuccessResult(bundle));
        }
        if ("qipc_action_clear_cache".equals(str)) {
            b.f().a();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.comment.c.InterfaceC7462c
    public void onDanmuPullResult(a aVar, boolean z16, boolean z17, int i3, ArrayList<DanmuItemBean> arrayList, List<Long> list) {
        QLog.d("DanmuDataIPCServer", 1, "onDanmuPullResult, isPullEnd:", Boolean.valueOf(z17));
        if (aVar == null) {
            QLog.d("DanmuDataIPCServer", 1, "onDanmuPullResult fail, pullContext is null");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putLong("key_barrage_msg_seq", aVar.f201735a);
        bundle.putLong("key_barrage_grp_uin", aVar.f201736b);
        bundle.putInt("key_barrage_topic_type", aVar.f201737c);
        bundle.putInt("key_barrage_interval_time", i3);
        bundle.putBoolean("key_barrage_is_success", z16);
        long j3 = aVar.f201739e;
        if (j3 > 0) {
            bundle.putLong("key_barrage_req_time", j3);
            bundle.putLong("key_barrage_net_req_time", aVar.f201740f);
            bundle.putLong("key_barrage_net_response_time", System.currentTimeMillis());
            aVar.f201739e = -1L;
        }
        if (arrayList != null) {
            bundle.putParcelableArrayList("key_barrage_danmu_list", arrayList);
        }
        if (list != null) {
            bundle.putLongArray("key_barrage_del_seq_list", toArray(list));
        }
        QIPCServerHelper.getInstance().callClient("com.tencent.mobileqq:peak", "DanmuDataIPCClient", "qipc_action_get_barrage_result", bundle, null);
    }
}
