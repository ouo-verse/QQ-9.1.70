package com.qzone.common.business.service;

import NS_MOBILE_OPERATION.s_arkshare;
import NS_MOBILE_OPERATION.share_outsite_rsp;
import PHOTO_OPENID_TO_QQ.GetShareKeyRsp;
import android.os.Bundle;
import android.os.Handler;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.IQZoneServiceListener;
import com.qzone.common.business.QZoneBusinessLooper;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.common.protocol.request.QZoneShareGetMiniProgramShareKeyRequest;
import com.qzone.common.protocol.request.QzoneGetOutShareUrlRequest;
import com.qzone.util.al;
import cooperation.qzone.util.QZLog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class OutSiteShareService implements IQZoneServiceListener {

    /* renamed from: d, reason: collision with root package name */
    private static final al<OutSiteShareService, Void> f45588d = new a();

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes39.dex */
    public @interface ShareOutType {
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a extends al<OutSiteShareService, Void> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.qzone.util.al
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public OutSiteShareService a(Void r16) {
            return new OutSiteShareService();
        }
    }

    public static OutSiteShareService a() {
        return f45588d.get(null);
    }

    private void h(QZoneTask qZoneTask) {
        Object obj;
        GetShareKeyRsp getShareKeyRsp = (GetShareKeyRsp) qZoneTask.mRequest.rsp;
        QZoneResult result = qZoneTask.getResult(0);
        if (getShareKeyRsp != null && getShareKeyRsp.ret == 0) {
            if (QZLog.isColorLevel()) {
                QZLog.d("OutSiteShareService", 2, "sharekey(" + getShareKeyRsp.share_key + "),ret(" + getShareKeyRsp.ret + ")");
            }
            result.getBundle().putSerializable("OutSiteShareServiceBundleKey", getShareKeyRsp);
        } else {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("respone is null or respone ret: ");
            if (getShareKeyRsp != null) {
                obj = Integer.valueOf(getShareKeyRsp.ret);
            } else {
                obj = "null";
            }
            sb5.append(obj);
            QZLog.e("OutSiteShareService", sb5.toString());
            result.setSucceed(false);
        }
        qZoneTask.sendResultMsg(result);
    }

    private void i(QZoneTask qZoneTask) {
        share_outsite_rsp share_outsite_rspVar = (share_outsite_rsp) qZoneTask.mRequest.rsp;
        QZoneResult result = qZoneTask.getResult(1000083);
        if (share_outsite_rspVar != null) {
            if (QZLog.isColorLevel()) {
                QZLog.d("OutSiteShareService", 2, "url(" + share_outsite_rspVar.url + "),msg(" + share_outsite_rspVar.f25021msg + "),code(" + share_outsite_rspVar.ret + ")");
            }
            Bundle bundle = result.getBundle();
            bundle.putString("url", share_outsite_rspVar.url);
            bundle.putString("msg", share_outsite_rspVar.f25021msg);
            bundle.putString("mini_id", share_outsite_rspVar.strProgramID);
            bundle.putString("mini_path", share_outsite_rspVar.strProgramPath);
            bundle.putString("mini_title", share_outsite_rspVar.strProgramMsg);
            bundle.putInt("iShareOutType", share_outsite_rspVar.iShareOutType);
            bundle.putString("short_url", share_outsite_rspVar.short_url);
            s_arkshare s_arkshareVar = share_outsite_rspVar.ark_sharedata;
            if (s_arkshareVar != null) {
                bundle.putString("ark_content", s_arkshareVar.ark_content);
            }
        } else {
            QZLog.e("OutSiteShareService", "respone is null");
            result.setSucceed(false);
        }
        qZoneTask.sendResultMsg(result);
    }

    public static boolean j(int i3) {
        if (i3 != 1 && i3 != 2 && i3 != 3) {
            return true;
        }
        return false;
    }

    public void b(com.qzone.common.business.a aVar, String str, long j3) {
        if (QZLog.isColorLevel()) {
            QZLog.d("OutSiteShareService", 2, "getMiniProgramShareKey() called with: albumid = [" + str + "], ownerUin = [" + j3 + "]");
        }
        QZoneTask qZoneTask = new QZoneTask(new QZoneShareGetMiniProgramShareKeyRequest(str, j3), null, this, 2);
        qZoneTask.setCallback(aVar);
        QZoneBusinessLooper.getInstance().runTask(qZoneTask);
    }

    public void c(Handler handler, int i3, int i16, String str, String str2, String str3, String str4) {
        if (QZLog.isColorLevel()) {
            QZLog.d("OutSiteShareService", 2, "getOutShareUrl() called with: appid = [" + i3 + "], ugcType = [" + i16 + "], cellid = [" + str + "], albumid = [" + str2 + "], lloc = [" + str3 + "], batchid = [" + str4 + "]");
        }
        QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new QzoneGetOutShareUrlRequest(i3, i16, str, str2, str3, str4), handler, this, 1));
    }

    public void d(Handler handler, int i3, int i16, String str, String str2, String str3, String str4, int i17, long j3, int i18, Map<Integer, String> map) {
        if (QZLog.isColorLevel()) {
            QZLog.d("OutSiteShareService", 2, "getOutShareUrl() called with: appid = [" + i3 + "], ugcType = [" + i16 + "], cellid = [" + str + "], albumid = [" + str2 + "], lloc = [" + str3 + "], batchid = [" + str4 + "], iIsShareTo = [" + i17 + "], hostUin = [" + j3 + "], shareScene = [" + i18 + "], busi_param = [" + map + "]");
        }
        QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new QzoneGetOutShareUrlRequest(i3, i16, str, str2, str3, str4, i17, j3, i18, map), handler, this, 1));
    }

    public void e(Handler handler, int i3, int i16, String str, String str2, String str3, String str4, long j3, int i17, String str5, int i18) {
        if (QZLog.isColorLevel()) {
            QZLog.d("OutSiteShareService", 2, "getOutShareUrl() called with: appid = [" + i3 + "], ugcType = [" + i16 + "], cellid = [" + str + "], albumid = [" + str2 + "], lloc = [" + str3 + "], batchid = [" + str4 + "], uHostUin = [" + j3 + "], iIsShareTo = [" + i17 + "]], strMd5Key = [" + str5);
        }
        QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new QzoneGetOutShareUrlRequest(i3, i16, str, str2, str3, str4, j3, i17, str5, i18), handler, this, 1));
    }

    public void f(Handler handler, int i3, int i16, String str, String str2, String str3, String str4, long j3, int i17, String str5, int i18, Map<Integer, String> map) {
        if (QZLog.isColorLevel()) {
            QZLog.d("OutSiteShareService", 2, "getOutShareUrl() called with: appid = [" + i3 + "], ugcType = [" + i16 + "], cellid = [" + str + "], albumid = [" + str2 + "], lloc = [" + str3 + "], batchid = [" + str4 + "], uHostUin = [" + j3 + "], iIsShareTo = [" + i17 + "]], strMd5Key = [" + str5 + "], busi_param = [" + map.toString() + "]");
        }
        QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new QzoneGetOutShareUrlRequest(i3, i16, str, str2, str3, str4, j3, i17, str5, i18, map), handler, this, 1));
    }

    public void g(Handler handler, int i3, int i16, String str, String str2, String str3, String str4, long j3, int i17, Map<Integer, String> map) {
        if (QZLog.isColorLevel()) {
            QZLog.d("OutSiteShareService", 2, "getOutShareUrl() called with: appid = [" + i3 + "], ugcType = [" + i16 + "], cellid = [" + str + "], albumid = [" + str2 + "], lloc = [" + str3 + "], batchid = [" + str4 + "], uHostUin = [" + j3 + "], iIsShareTo = [" + i17 + "], busi_param = [" + map.toString() + "]");
        }
        QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new QzoneGetOutShareUrlRequest(i3, i16, str, str2, str3, str4, j3, i17, map), handler, this, 1));
    }

    public void k(int i3) {
        u5.b.r0("key_permission_setting_access", i3, LoginData.getInstance().getUin());
    }

    @Override // com.qzone.common.business.IQZoneServiceListener
    public void onTaskResponse(QZoneTask qZoneTask) {
        int i3 = qZoneTask.mType;
        if (i3 == 1) {
            i(qZoneTask);
        } else {
            if (i3 != 2) {
                return;
            }
            h(qZoneTask);
        }
    }
}
