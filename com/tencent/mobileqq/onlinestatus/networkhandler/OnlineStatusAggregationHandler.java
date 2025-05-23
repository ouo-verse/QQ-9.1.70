package com.tencent.mobileqq.onlinestatus.networkhandler;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.api.f;
import com.tencent.qqnt.aio.api.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.util.WeakReference;
import tencent.im.onlinestatus.OnlineStatusLikeInfo$CheckLikeReq;
import tencent.im.onlinestatus.OnlineStatusLikeInfo$CheckLikeRsp;
import tencent.im.onlinestatus.OnlineStatusLikeInfo$GetLikeListReq;
import tencent.im.onlinestatus.OnlineStatusLikeInfo$GetLikeListRsp;
import tencent.im.onlinestatus.OnlineStatusLikeInfo$LikeItem;
import tencent.im.onlinestatus.OnlineStatusLikeInfo$LikeStatusReq;
import tencent.im.onlinestatus.OnlineStatusLikeInfo$LikeStatusRsp;
import tencent.im.onlinestatus.OnlineStatusLikeInfo$ReadLikeListReq;
import tencent.im.onlinestatus.OnlineStatusLikeInfo$ReadLikeListRsp;
import tencent.im.onlinestatus.OnlineStatusLikeInfo$UinLikeInfo;

/* compiled from: P */
/* loaded from: classes16.dex */
public class OnlineStatusAggregationHandler extends BusinessHandler implements ec2.c {

    /* renamed from: d, reason: collision with root package name */
    private final AppInterface f256062d;

    /* renamed from: e, reason: collision with root package name */
    private WeakReference<g> f256063e;

    /* renamed from: f, reason: collision with root package name */
    private WeakReference<f> f256064f;

    protected OnlineStatusAggregationHandler(AppInterface appInterface) {
        super(appInterface);
        this.f256062d = appInterface;
    }

    private void E2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (toServiceMsg != null && fromServiceMsg != null && obj != null) {
            try {
                boolean isSuccess = fromServiceMsg.isSuccess();
                if (!isSuccess) {
                    QLog.d("OnlineStatusAggregationHandler", 1, "handleGetLikeStatusSingleUser isSuccess: false");
                    notifyUI(2, false, null);
                    WeakReference<g> weakReference = this.f256063e;
                    if (weakReference != null && weakReference.get() != null) {
                        this.f256063e.get().a(false);
                        return;
                    }
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("OnlineStatusAggregationHandler", 2, "isSuccess: " + isSuccess);
                }
                notifyUI(2, true, obj);
                I2((byte[]) obj);
                return;
            } catch (Exception e16) {
                QLog.e("OnlineStatusAggregationHandler", 1, "receive: " + e16);
                notifyUI(2, false, null);
                WeakReference<g> weakReference2 = this.f256063e;
                if (weakReference2 != null && weakReference2.get() != null) {
                    this.f256063e.get().a(false);
                    return;
                }
                return;
            }
        }
        QLog.d("OnlineStatusAggregationHandler", 1, "handleGetLikeStatusSingleUser res: " + fromServiceMsg + " req: " + toServiceMsg + " data: " + obj);
        notifyUI(2, false, null);
        WeakReference<g> weakReference3 = this.f256063e;
        if (weakReference3 != null && weakReference3.get() != null) {
            this.f256063e.get().a(false);
        }
    }

    private void F2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (obj == null) {
            QLog.d("OnlineStatusAggregationHandler", 1, "handleLikeListRsp data is null");
            notifyUI(3, false, null);
            return;
        }
        try {
            OnlineStatusLikeInfo$GetLikeListRsp onlineStatusLikeInfo$GetLikeListRsp = new OnlineStatusLikeInfo$GetLikeListRsp();
            onlineStatusLikeInfo$GetLikeListRsp.mergeFrom((byte[]) obj);
            HashMap hashMap = new HashMap();
            hashMap.put("from", toServiceMsg.getAttribute("from"));
            hashMap.put("unread_num", Integer.valueOf(onlineStatusLikeInfo$GetLikeListRsp.unread_num.get()));
            hashMap.put("time_out", Long.valueOf(onlineStatusLikeInfo$GetLikeListRsp.timeout.get() * 1000));
            hashMap.put("notify_items", onlineStatusLikeInfo$GetLikeListRsp.notify_items.get());
            if (QLog.isColorLevel()) {
                QLog.d("OnlineStatusAggregationHandler", 2, "handleLikeListRsp isSuccess: " + fromServiceMsg.isSuccess() + ", resData: " + hashMap);
            }
            notifyUI(3, fromServiceMsg.isSuccess(), hashMap);
        } catch (Exception e16) {
            QLog.e("OnlineStatusAggregationHandler", 1, "handleLikeListRsp", e16);
            notifyUI(3, false, null);
        }
    }

    private void G2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        if (toServiceMsg != null && fromServiceMsg != null && obj != null) {
            try {
                boolean isSuccess = fromServiceMsg.isSuccess();
                OnlineStatusLikeInfo$LikeStatusRsp onlineStatusLikeInfo$LikeStatusRsp = new OnlineStatusLikeInfo$LikeStatusRsp();
                onlineStatusLikeInfo$LikeStatusRsp.mergeFrom((byte[]) obj);
                int i3 = onlineStatusLikeInfo$LikeStatusRsp.err_code.get();
                QLog.d("OnlineStatusAggregationHandler", 1, "handleLikeStatus isSuccess = " + isSuccess + " resultCode = " + i3 + " resultMsg = " + onlineStatusLikeInfo$LikeStatusRsp.err_msg.get().toString());
                Bundle bundle = new Bundle(2);
                Object attribute = toServiceMsg.getAttribute("os_uin_key");
                if (attribute instanceof String) {
                    bundle.putString("os_uin_key", (String) attribute);
                }
                Object attribute2 = toServiceMsg.getAttribute("os_like_key");
                if (attribute2 instanceof Integer) {
                    bundle.putInt("os_like_key", ((Integer) attribute2).intValue());
                }
                if (isSuccess && i3 == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                notifyUI(1, z16, bundle);
                J2(toServiceMsg, isSuccess, i3);
                return;
            } catch (Exception e16) {
                QLog.e("OnlineStatusAggregationHandler", 1, "receive: " + e16);
                notifyUI(1, false, null);
                WeakReference<f> weakReference = this.f256064f;
                if (weakReference != null && weakReference.get() != null) {
                    this.f256064f.get().a(false, 0L);
                    return;
                }
                return;
            }
        }
        QLog.d("OnlineStatusAggregationHandler", 1, "handleLikeStatus res: " + fromServiceMsg + " req: " + toServiceMsg + " data: " + obj);
        notifyUI(1, false, null);
        WeakReference<f> weakReference2 = this.f256064f;
        if (weakReference2 != null && weakReference2.get() != null) {
            this.f256064f.get().a(false, 0L);
        }
    }

    private void H2(FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        if (fromServiceMsg != null && obj != null) {
            try {
                boolean isSuccess = fromServiceMsg.isSuccess();
                OnlineStatusLikeInfo$ReadLikeListRsp onlineStatusLikeInfo$ReadLikeListRsp = new OnlineStatusLikeInfo$ReadLikeListRsp();
                onlineStatusLikeInfo$ReadLikeListRsp.mergeFrom((byte[]) obj);
                int i3 = onlineStatusLikeInfo$ReadLikeListRsp.err_code.get();
                QLog.d("OnlineStatusAggregationHandler", 1, "handleLikeStatus isSuccess = " + isSuccess + " resultCode = " + i3 + " resultMsg = " + onlineStatusLikeInfo$ReadLikeListRsp.err_msg.get().toString());
                if (isSuccess && i3 == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                notifyUI(4, z16, null);
                return;
            } catch (Exception e16) {
                QLog.e("OnlineStatusAggregationHandler", 1, "receive: " + e16);
                notifyUI(4, false, null);
                return;
            }
        }
        QLog.d("OnlineStatusAggregationHandler", 1, "handleLikeStatus res: " + fromServiceMsg + " data: " + obj);
        notifyUI(4, false, null);
    }

    private void I2(byte[] bArr) {
        boolean z16;
        WeakReference<g> weakReference = this.f256063e;
        if (weakReference != null && weakReference.get() != null) {
            try {
                OnlineStatusLikeInfo$CheckLikeRsp onlineStatusLikeInfo$CheckLikeRsp = new OnlineStatusLikeInfo$CheckLikeRsp();
                onlineStatusLikeInfo$CheckLikeRsp.mergeFrom(bArr);
                int i3 = onlineStatusLikeInfo$CheckLikeRsp.err_code.get();
                String obj = onlineStatusLikeInfo$CheckLikeRsp.err_msg.get().toString();
                if (i3 != 0) {
                    this.f256063e.get().a(false);
                    QLog.d("OnlineStatusAggregationHandler", 1, "processNormalOnlineStatusToFu resultCode: " + i3 + " resultMsg: " + obj);
                    return;
                }
                Iterator<OnlineStatusLikeInfo$UinLikeInfo> it = onlineStatusLikeInfo$CheckLikeRsp.like_info.get().iterator();
                if (it.hasNext()) {
                    List<OnlineStatusLikeInfo$LikeItem> list = it.next().like_items.get();
                    g gVar = this.f256063e.get();
                    if (list.size() != 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    gVar.a(z16);
                    return;
                }
                return;
            } catch (Exception e16) {
                QLog.e("OnlineStatusAggregationHandler", 1, "processNormalOnlineStatusToFu: " + e16);
                this.f256063e.get().a(false);
                return;
            }
        }
        QLog.i("OnlineStatusAggregationHandler", 1, "mNormalStatusToFuCb == null");
    }

    private void J2(ToServiceMsg toServiceMsg, boolean z16, int i3) {
        boolean z17;
        boolean z18;
        WeakReference<f> weakReference = this.f256064f;
        if (weakReference != null && weakReference.get() != null) {
            Object attribute = toServiceMsg.getAttribute("os_uin_key");
            if (!(attribute instanceof String)) {
                this.f256064f.get().a(false, 0L);
                QLog.i("OnlineStatusAggregationHandler", 1, "value instanceof String false");
                return;
            }
            try {
                long parseLong = Long.parseLong((String) attribute);
                f fVar = this.f256064f.get();
                if (z16 && i3 == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                fVar.a(z17, parseLong);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("isSuccess ");
                if (z16 && i3 == 0) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                sb5.append(z18);
                sb5.append(" uinLong ");
                sb5.append(((String) attribute).substring(0, 4));
                QLog.i("OnlineStatusAggregationHandler", 1, sb5.toString());
                return;
            } catch (Exception e16) {
                QLog.e("OnlineStatusAggregationHandler", 1, "handleLikeStatus " + e16);
                this.f256064f.get().a(false, 0L);
                return;
            }
        }
        QLog.i("OnlineStatusAggregationHandler", 1, "mNormalStatusSendCb == null");
    }

    public void D2(ArrayList<String> arrayList, int i3) {
        if (arrayList.size() != 0 && i3 >= 0) {
            OnlineStatusLikeInfo$CheckLikeReq onlineStatusLikeInfo$CheckLikeReq = new OnlineStatusLikeInfo$CheckLikeReq();
            onlineStatusLikeInfo$CheckLikeReq.business_type.set(i3);
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                onlineStatusLikeInfo$CheckLikeReq.uins.add(Long.valueOf(Long.parseLong(it.next())));
            }
            ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.f256062d.getCurrentAccountUin(), "trpc.QQService.CommonLogic.StatusService.SsoCheckLike");
            toServiceMsg.putWupBuffer(onlineStatusLikeInfo$CheckLikeReq.toByteArray());
            sendPbReq(toServiceMsg);
            return;
        }
        QLog.e("OnlineStatusAggregationHandler", 1, "getLikeStatusSingleUserReq: uins.size() = " + arrayList.size() + " businessType = " + i3);
    }

    public void K2(String str, int i3, int i16, int i17, byte[] bArr) {
        if (!TextUtils.isEmpty(str) && i3 >= 0 && i16 >= 0) {
            OnlineStatusLikeInfo$LikeStatusReq onlineStatusLikeInfo$LikeStatusReq = new OnlineStatusLikeInfo$LikeStatusReq();
            onlineStatusLikeInfo$LikeStatusReq.business_type.set(i16);
            onlineStatusLikeInfo$LikeStatusReq.uin.set(Long.parseLong(str));
            OnlineStatusLikeInfo$LikeItem onlineStatusLikeInfo$LikeItem = new OnlineStatusLikeInfo$LikeItem();
            onlineStatusLikeInfo$LikeItem.like_type.set(i3);
            ArrayList arrayList = new ArrayList();
            arrayList.add(onlineStatusLikeInfo$LikeItem);
            if (bArr != null) {
                onlineStatusLikeInfo$LikeItem.ext_info.set(ByteStringMicro.copyFrom(bArr));
            }
            onlineStatusLikeInfo$LikeStatusReq.is_cancel.set(i17);
            onlineStatusLikeInfo$LikeStatusReq.like_items.set(arrayList);
            ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.f256062d.getCurrentAccountUin(), "trpc.QQService.CommonLogic.StatusService.SsoLikeStatus");
            toServiceMsg.putWupBuffer(onlineStatusLikeInfo$LikeStatusReq.toByteArray());
            toServiceMsg.addAttribute("os_uin_key", str);
            toServiceMsg.addAttribute("os_like_key", Integer.valueOf(i3));
            sendPbReq(toServiceMsg);
            return;
        }
        QLog.e("OnlineStatusAggregationHandler", 1, "sendLikeStatusReq: uin = " + str + " likeType = " + i3 + " businessType = " + i16);
    }

    public void L2() {
        OnlineStatusLikeInfo$ReadLikeListReq onlineStatusLikeInfo$ReadLikeListReq = new OnlineStatusLikeInfo$ReadLikeListReq();
        onlineStatusLikeInfo$ReadLikeListReq.time.set(System.currentTimeMillis());
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.f256062d.getCurrentAccountUin(), "trpc.QQService.CommonLogic.StatusService.SsoReadLikeList");
        toServiceMsg.putWupBuffer(onlineStatusLikeInfo$ReadLikeListReq.toByteArray());
        sendPbReq(toServiceMsg);
    }

    public void M2(f fVar) {
        this.f256064f = new WeakReference<>(fVar);
    }

    public void N2(g gVar) {
        this.f256063e = new WeakReference<>(gVar);
    }

    @Override // ec2.c
    public void d(String str) {
        QLog.d("OnlineStatusAggregationHandler", 1, "sendGetLikeListReq from=" + str);
        OnlineStatusLikeInfo$GetLikeListReq onlineStatusLikeInfo$GetLikeListReq = new OnlineStatusLikeInfo$GetLikeListReq();
        onlineStatusLikeInfo$GetLikeListReq.time.set(System.currentTimeMillis());
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.f256062d.getCurrentAccountUin(), "trpc.QQService.CommonLogic.StatusService.SsoGetLikeList");
        toServiceMsg.addAttribute("from", str);
        toServiceMsg.putWupBuffer(onlineStatusLikeInfo$GetLikeListReq.toByteArray());
        sendPbReq(toServiceMsg);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("trpc.QQService.CommonLogic.StatusService.SsoLikeStatus");
            this.allowCmdSet.add("trpc.QQService.CommonLogic.StatusService.SsoCheckLike");
            this.allowCmdSet.add("trpc.QQService.CommonLogic.StatusService.SsoGetLikeList");
            this.allowCmdSet.add("trpc.QQService.CommonLogic.StatusService.SsoReadLikeList");
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return com.tencent.mobileqq.onlinestatus.observer.b.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (toServiceMsg != null && fromServiceMsg != null) {
            String serviceCmd = fromServiceMsg.getServiceCmd();
            if (msgCmdFilter(serviceCmd) && QLog.isColorLevel()) {
                QLog.d("OnlineStatusAggregationHandler", 2, "onReceive, msgCmdFilter is true,cmd  = " + serviceCmd);
            }
            if ("trpc.QQService.CommonLogic.StatusService.SsoLikeStatus".equals(serviceCmd)) {
                G2(toServiceMsg, fromServiceMsg, obj);
                return;
            }
            if ("trpc.QQService.CommonLogic.StatusService.SsoCheckLike".equals(serviceCmd)) {
                E2(toServiceMsg, fromServiceMsg, obj);
                return;
            } else if ("trpc.QQService.CommonLogic.StatusService.SsoGetLikeList".equals(serviceCmd)) {
                F2(toServiceMsg, fromServiceMsg, obj);
                return;
            } else {
                if ("trpc.QQService.CommonLogic.StatusService.SsoReadLikeList".equals(serviceCmd)) {
                    H2(fromServiceMsg, obj);
                    return;
                }
                return;
            }
        }
        QLog.e("OnlineStatusAggregationHandler", 1, "req: " + toServiceMsg + " res: " + fromServiceMsg);
    }
}
