package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.biz.ProtoUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.BaseForwardUtil;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.api.ILaunchGuildChatPieApi;
import com.tencent.mobileqq.guild.api.LaunchGuildChatPieParam;
import com.tencent.mobileqq.guild.util.IGuildFeedsHomeJumpApi;
import com.tencent.mobileqq.mini.share.opensdk.OpenSdkShareModel;
import com.tencent.mobileqq.pic.ad;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import tencent.im.msg.im_msg_body$RichText;
import tencent.im.oidb.cmd0xb77.oidb_cmd0xb77$ImageInfo;
import tencent.im.oidb.cmd0xdc2.oidb_cmd0xdc2$BatchSendReq;
import tencent.im.oidb.cmd0xdc2.oidb_cmd0xdc2$BatchSendRsp;
import tencent.im.oidb.cmd0xdc2.oidb_cmd0xdc2$ReqBody;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ForwardMultServerShare implements Handler.Callback {
    static IPatchRedirector $redirector_;
    private static String G;
    private AbsShareMsg C;
    private g D;
    private OpenSdkShareModel E;
    protected List<ResultRecord> F;

    /* renamed from: d, reason: collision with root package name */
    private final MqqHandler f210686d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f210687e;

    /* renamed from: f, reason: collision with root package name */
    private long f210688f;

    /* renamed from: h, reason: collision with root package name */
    protected Bundle f210689h;

    /* renamed from: i, reason: collision with root package name */
    private Activity f210690i;

    /* renamed from: m, reason: collision with root package name */
    private QQAppInterface f210691m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements com.tencent.mobileqq.pic.ad {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardMultServerShare.this);
            }
        }

        @Override // com.tencent.mobileqq.pic.ad
        public MessageRecord g(im_msg_body$RichText im_msg_body_richtext) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (MessageRecord) iPatchRedirector.redirect((short) 2, (Object) this, (Object) im_msg_body_richtext);
            }
            return null;
        }

        @Override // com.tencent.mobileqq.pic.ad
        public void q(ad.a aVar) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
                return;
            }
            String string = ForwardMultServerShare.this.f210689h.getString("uin");
            HashMap hashMap = new HashMap();
            if (ForwardMultServerShare.this.f210687e) {
                str = "1";
            } else {
                str = "0";
            }
            hashMap.put("param_time_out", str);
            if (string == null) {
                string = "";
            }
            ForwardStatisticsReporter.i("KEY_STAGE_2_SEND_MSG_BY_SERVER", string, hashMap, ForwardUtils.P(aVar));
            QLog.d(ForwardMultServerShare.G, 1, "requestNormalShare onSend result =", aVar, ", isTimeOut=", Boolean.valueOf(ForwardMultServerShare.this.f210687e));
            if (ForwardMultServerShare.this.f210687e) {
                return;
            }
            if (ForwardUtils.P(aVar)) {
                String[] strArr = (String[]) aVar.f258608l;
                QLog.i(ForwardMultServerShare.G, 1, "requestNormalShare onSend urls=" + strArr[0] + " ," + strArr[1]);
                ForwardMultServerShare.this.u(strArr[0], strArr[1]);
                return;
            }
            int i3 = aVar.f258598b;
            boolean b16 = BaseForwardUtil.b(ForwardMultServerShare.this.f210690i);
            String[] strArr2 = (String[]) aVar.f258608l;
            QLog.e(ForwardMultServerShare.G, 1, "requestNormalShare onSend error result.result : ", Integer.valueOf(aVar.f258597a), ", errCode=" + i3 + ", hasSDPermission=" + b16);
            if (i3 != 9402 || b16 || strArr2 == null || strArr2.length != 2) {
                ForwardMultServerShare.this.v();
            } else {
                ForwardMultServerShare.this.u(strArr2[0], strArr2[1]);
            }
        }

        @Override // com.tencent.mobileqq.pic.ad
        public void r(ad.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
                return;
            }
            if (aVar != null && QLog.isColorLevel()) {
                QLog.d(ForwardMultServerShare.G, 2, "requestNormalShare updateMsg info =" + aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b extends ProtoUtils.TroopProtocolObserver {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardMultServerShare.this);
            }
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public boolean onError(int i3, String str, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, bundle)).booleanValue();
            }
            if (!TextUtils.isEmpty(str)) {
                QLog.e(ForwardMultServerShare.G, 1, "notifyImageSendMessage onError msg =" + str);
            }
            return super.onError(i3, str, bundle);
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int i3, byte[] bArr, Bundle bundle) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), bArr, bundle);
                return;
            }
            if (i3 == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            ForwardStatisticsReporter.k("KEY_STAGE_2_IMAGE_DC2", z16);
            if (bundle != null) {
                long j3 = bundle.getLong("0xdc2_9_sendTime", -1L);
                if (QLog.isColorLevel()) {
                    QLog.d(ForwardMultServerShare.G, 2, "notifyImageSendMessage onResult currentRequestTime =", Long.valueOf(ForwardMultServerShare.this.f210688f), ", sendStamp = ", Long.valueOf(j3));
                }
                if (j3 == -1 || j3 != ForwardMultServerShare.this.f210688f) {
                    ForwardMultServerShare.this.v();
                    return;
                }
            }
            List<oidb_cmd0xdc2$BatchSendRsp> c06 = ForwardUtils.c0(bArr);
            if (i3 == 0 && c06 != null) {
                ForwardMultServerShare.this.w(c06);
                ForwardMultServerShare.this.C(c06);
            } else {
                QLog.e(ForwardMultServerShare.G, 1, "notifyImageSendMessage onResult error errorCode != 0 || result == null, errorCode=", Integer.valueOf(i3));
                ForwardMultServerShare.this.v();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class c extends ProtoUtils.TroopProtocolObserver {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardMultServerShare.this);
            }
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public boolean onError(int i3, String str, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, bundle)).booleanValue();
            }
            if (!TextUtils.isEmpty(str)) {
                QLog.e(ForwardMultServerShare.G, 1, "notifyNormalSendMessage onError msg =", str);
            }
            return super.onError(i3, str, bundle);
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int i3, byte[] bArr, Bundle bundle) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), bArr, bundle);
                return;
            }
            QLog.d(ForwardMultServerShare.G, 1, "notifyNormalSendMessage onResult errorCode=", Integer.valueOf(i3), ", isTimeOut=", Boolean.valueOf(ForwardMultServerShare.this.f210687e));
            if (i3 == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            ForwardStatisticsReporter.k("KEY_STAGE_2_NORMAL_DC2", z16);
            if (ForwardMultServerShare.this.f210687e) {
                return;
            }
            if (bundle != null) {
                long j3 = bundle.getLong("0xdc2_9_sendTime", -1L);
                if (QLog.isColorLevel()) {
                    QLog.d(ForwardMultServerShare.G, 2, "notifyNormalSendMessage currentRequestTime =", Long.valueOf(ForwardMultServerShare.this.f210688f), ", sendStamp = ", Long.valueOf(j3));
                }
                if (j3 == -1 || j3 != ForwardMultServerShare.this.f210688f) {
                    ForwardMultServerShare.this.v();
                    return;
                }
            }
            ReportController.o(null, "dc00898", "", "", "0X8009C94", "0X8009C94", 0, 0, "" + i3, "", "", "");
            List<oidb_cmd0xdc2$BatchSendRsp> c06 = ForwardUtils.c0(bArr);
            if (i3 == 0 && c06 != null) {
                ForwardMultServerShare.this.w(c06);
                ForwardMultServerShare.this.C(c06);
            } else {
                QLog.e(ForwardMultServerShare.G, 1, "notifyNormalSendMessage sendOIDBRequest onResult errorCode != 0 || result == null, errorCode=", Integer.valueOf(i3));
                ForwardMultServerShare.this.v();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(72097);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            G = "ForwardMultServerShare";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ForwardMultServerShare(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bundle);
            return;
        }
        this.f210686d = new MqqWeakReferenceHandler(Looper.getMainLooper(), this);
        this.f210687e = false;
        this.f210688f = -1L;
        this.f210689h = bundle;
        this.E = (OpenSdkShareModel) bundle.getParcelable("KEY_MINI_PROGRAM_SHARE_OBJ");
    }

    private void A() {
        MqqHandler mqqHandler = this.f210686d;
        mqqHandler.sendMessageDelayed(mqqHandler.obtainMessage(95), 500L);
        if (this.C instanceof StructMsgForImageShare) {
            y();
        } else {
            z();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(List<oidb_cmd0xdc2$BatchSendRsp> list) {
        if (this.f210689h.getInt("uintype") == 10014) {
            ForwardUtils.m0(this.F, list, this.f210689h.getString(AppConstants.Key.SHARE_RES_COMMENT_MESSAGE_FOR_SERVER));
        } else {
            ForwardUtils.k0(this.F, list, this.f210690i, this.f210689h.getString(AppConstants.Key.SHARE_RES_COMMENT_MESSAGE_FOR_SERVER));
        }
    }

    private void D(Map<ResultRecord, ad.a> map, ResultRecord resultRecord, oidb_cmd0xdc2$BatchSendReq oidb_cmd0xdc2_batchsendreq) {
        oidb_cmd0xb77$ImageInfo l3;
        if (map != null && (l3 = l(map.get(resultRecord))) != null) {
            oidb_cmd0xdc2_batchsendreq.image_info.set(l3);
        }
    }

    private oidb_cmd0xb77$ImageInfo l(ad.a aVar) {
        if (aVar == null) {
            return null;
        }
        Object obj = aVar.f258608l;
        if (!(obj instanceof int[])) {
            return null;
        }
        int[] iArr = (int[]) obj;
        if (iArr.length != 5) {
            return null;
        }
        oidb_cmd0xb77$ImageInfo oidb_cmd0xb77_imageinfo = new oidb_cmd0xb77$ImageInfo();
        oidb_cmd0xb77_imageinfo.md5.set(aVar.f258603g);
        oidb_cmd0xb77_imageinfo.uuid.set(aVar.f258602f);
        oidb_cmd0xb77_imageinfo.file_size.set(iArr[0]);
        oidb_cmd0xb77_imageinfo.img_type.set(iArr[1]);
        oidb_cmd0xb77_imageinfo.width.set(iArr[2]);
        oidb_cmd0xb77_imageinfo.height.set(iArr[3]);
        oidb_cmd0xb77_imageinfo.original.set(iArr[4]);
        oidb_cmd0xb77_imageinfo.file_id.set((int) aVar.f258604h);
        return oidb_cmd0xb77_imageinfo;
    }

    private void m(Intent intent, List<oidb_cmd0xdc2$BatchSendRsp> list) {
        ResultRecord o16;
        intent.putExtra("sdk_mult_share_total_count", list.size());
        if (list.size() == 1) {
            oidb_cmd0xdc2$BatchSendRsp oidb_cmd0xdc2_batchsendrsp = list.get(0);
            if (oidb_cmd0xdc2_batchsendrsp.err_code.get() == 901503) {
                if (QLog.isColorLevel()) {
                    QLog.d(G, 2, "buildResult SHARE_ERROR_NOT_FRIEND");
                }
                intent.putExtra("sdk_mult_share_result_code", 901503);
                String str = oidb_cmd0xdc2_batchsendrsp.rsp_body.wording.get();
                if (TextUtils.isEmpty(str)) {
                    str = x.f211080d;
                }
                intent.putExtra("sdk_mult_share_error_wording", str);
                return;
            }
        }
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        for (oidb_cmd0xdc2$BatchSendRsp oidb_cmd0xdc2_batchsendrsp2 : list) {
            if (QLog.isColorLevel()) {
                QLog.d(G, 2, "rsp.recv_uin=", oidb_cmd0xdc2_batchsendrsp2.recv_uin, ", rsp.err_msg=", oidb_cmd0xdc2_batchsendrsp2.err_msg, ", rsp.err_code=", oidb_cmd0xdc2_batchsendrsp2.err_code);
            }
            if (oidb_cmd0xdc2_batchsendrsp2.err_code.get() != 0 && (o16 = o(oidb_cmd0xdc2_batchsendrsp2.recv_uin.get())) != null) {
                arrayList.add(o16);
            }
        }
        if (arrayList.isEmpty()) {
            intent.putExtra("sdk_mult_share_result_code", 0);
        } else if (arrayList.size() == this.F.size()) {
            intent.putExtra("sdk_mult_share_result_code", 2);
        } else {
            intent.putExtra("sdk_mult_share_result_code", 1);
            intent.putParcelableArrayListExtra("sdk_mult_share_fail_record", arrayList);
        }
    }

    private oidb_cmd0xdc2$ReqBody n(String str, String str2, Map<ResultRecord, ad.a> map) {
        oidb_cmd0xdc2$ReqBody oidb_cmd0xdc2_reqbody = new oidb_cmd0xdc2$ReqBody();
        oidb_cmd0xdc2_reqbody.msg_body.set(x.h(this.f210689h, str, str2, null));
        ArrayList arrayList = new ArrayList();
        for (ResultRecord resultRecord : this.F) {
            oidb_cmd0xdc2$BatchSendReq oidb_cmd0xdc2_batchsendreq = new oidb_cmd0xdc2$BatchSendReq();
            oidb_cmd0xdc2_batchsendreq.recv_uin.set(ForwardUtils.Z(resultRecord.uin));
            int i3 = resultRecord.uinType;
            if (i3 == 0) {
                oidb_cmd0xdc2_batchsendreq.send_type.set(0);
            } else if (i3 == 1) {
                oidb_cmd0xdc2_batchsendreq.send_type.set(1);
            } else if (i3 == 3000) {
                oidb_cmd0xdc2_batchsendreq.send_type.set(2);
            } else if (i3 == 10014) {
                oidb_cmd0xdc2_batchsendreq.send_type.set(3);
                oidb_cmd0xdc2_batchsendreq.recv_guild_id.set(ForwardUtils.Z(resultRecord.guildId));
            }
            D(map, resultRecord, oidb_cmd0xdc2_batchsendreq);
            arrayList.add(oidb_cmd0xdc2_batchsendreq);
        }
        oidb_cmd0xdc2_reqbody.batch_send_req.set(arrayList);
        return oidb_cmd0xdc2_reqbody;
    }

    private ResultRecord o(long j3) {
        for (ResultRecord resultRecord : this.F) {
            if (Long.toString(j3).equals(resultRecord.uin)) {
                return resultRecord;
            }
        }
        QLog.e(G, 1, "recvUin not found");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(Map<ResultRecord, ad.a> map) {
        oidb_cmd0xdc2$ReqBody n3 = n(null, null, map);
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime == null) {
            QLog.e(G, 1, "notifyImageSendMessage runtime = null ");
            v();
            return;
        }
        Bundle bundle = new Bundle();
        long currentTimeMillis = System.currentTimeMillis();
        this.f210688f = currentTimeMillis;
        bundle.putLong("0xdc2_9_sendTime", currentTimeMillis);
        QLog.i(G, 1, "notifyImageSendMessage OIDBRequest ");
        ForwardStatisticsReporter.m("KEY_STAGE_2_IMAGE_DC2");
        ProtoUtils.c(runtime, new b(), n3.toByteArray(), "OidbSvc.0xdc2_9", 3522, 9, bundle, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(String str, String str2) {
        oidb_cmd0xdc2$ReqBody n3 = n(str, str2, null);
        x.g(this.E, this.f210689h, n3.msg_body);
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime == null) {
            QLog.e(G, 1, "notifyNormalSendMessage send runtime = null");
            v();
            return;
        }
        this.f210688f = System.currentTimeMillis();
        Bundle bundle = new Bundle();
        bundle.putLong("0xdc2_9_sendTime", this.f210688f);
        if (QLog.isColorLevel()) {
            QLog.i(G, 2, "notifyNormalSendMessage sendOIDBRequest");
        }
        ForwardStatisticsReporter.m("KEY_STAGE_2_NORMAL_DC2");
        ProtoUtils.c(runtime, new c(), n3.toByteArray(), "OidbSvc.0xdc2_9", 3522, 9, bundle, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        QLog.e(G, 1, "onError");
        this.f210686d.removeMessages(96);
        this.f210686d.removeMessages(95);
        this.D.a(this.f210690i);
        ForwardUtils.S(this.f210690i, this.f210689h, x.f211080d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(List<oidb_cmd0xdc2$BatchSendRsp> list) {
        Intent p16;
        if (QLog.isColorLevel()) {
            QLog.d(G, 2, "onShareEnd");
        }
        this.f210686d.removeMessages(96);
        this.f210686d.removeMessages(95);
        if (s()) {
            p16 = q();
        } else {
            p16 = p();
        }
        p16.putExtra("k_from_login", true);
        p16.putExtra("sdk_mult_share_app_name", this.f210689h.getString("app_name"));
        p16.putExtra("sdk_mult_share_source_app_id", this.C.mSourceAppid);
        p16.putExtra("sdk_mult_share_msg_service_id", this.C.mMsgServiceID);
        p16.putExtra("sdk_mult_share", true);
        m(p16, list);
        int i3 = -1;
        if (this.f210689h.getInt("forward_type", -1) == 11) {
            ForwardUtils.g(this.f210690i, this.f210689h.getString("pkg_name"), p16, this.f210689h.getLong("req_share_id"));
        }
        if (s()) {
            i3 = 10014;
        }
        ForwardUtils.f0(i3, p16, this.f210689h);
        this.f210690i.startActivity(p16);
        this.D.a(this.f210690i);
        ForwardUtils.l(this.f210690i);
    }

    private void x() {
        int size;
        QLog.d(G, 1, "reportException");
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        List<ResultRecord> list = this.F;
        if (list == null) {
            size = 0;
        } else {
            size = list.size();
        }
        ForwardUtils.h0(qQAppInterface, "0X800A739", Integer.toString(size));
    }

    private void y() {
        QLog.d(G, 1, "-->ForwardMultServerShare requestImageShare");
        HashMap hashMap = new HashMap();
        ForwardStatisticsReporter.m("KEY_STAGE_2_UPLOAD_IMAGE_MULT");
        Iterator<ResultRecord> it = this.F.iterator();
        while (it.hasNext()) {
            ThreadManagerV2.post(new Runnable(it.next(), hashMap) { // from class: com.tencent.mobileqq.forward.ForwardMultServerShare.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ ResultRecord f210692d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ Map f210693e;

                /* compiled from: P */
                /* renamed from: com.tencent.mobileqq.forward.ForwardMultServerShare$2$a */
                /* loaded from: classes12.dex */
                class a implements com.tencent.mobileqq.pic.ad {
                    static IPatchRedirector $redirector_;

                    a() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                        }
                    }

                    @Override // com.tencent.mobileqq.pic.ad
                    public MessageRecord g(im_msg_body$RichText im_msg_body_richtext) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            return (MessageRecord) iPatchRedirector.redirect((short) 2, (Object) this, (Object) im_msg_body_richtext);
                        }
                        return null;
                    }

                    @Override // com.tencent.mobileqq.pic.ad
                    public void q(ad.a aVar) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
                            return;
                        }
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        anonymousClass2.f210693e.put(anonymousClass2.f210692d, aVar);
                        QLog.d(ForwardMultServerShare.G, 1, "requestImageShare onSend result =", aVar, ", isTimeOut=", Boolean.valueOf(ForwardMultServerShare.this.f210687e));
                        if (AnonymousClass2.this.f210693e.size() == ForwardMultServerShare.this.F.size()) {
                            ForwardStatisticsReporter.c("KEY_STAGE_2_UPLOAD_IMAGE_MULT");
                            AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                            ForwardMultServerShare.this.t(anonymousClass22.f210693e);
                        }
                    }

                    @Override // com.tencent.mobileqq.pic.ad
                    public void r(ad.a aVar) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
                            return;
                        }
                        if (aVar != null) {
                            QLog.d(ForwardMultServerShare.G, 1, "requestImageShare updateMsg info =" + aVar);
                        }
                    }
                }

                {
                    this.f210692d = r8;
                    this.f210693e = hashMap;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, ForwardMultServerShare.this, r8, hashMap);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        QQAppInterface qQAppInterface = ForwardMultServerShare.this.f210691m;
                        StructMsgForImageShare structMsgForImageShare = (StructMsgForImageShare) ForwardMultServerShare.this.C;
                        ResultRecord resultRecord = this.f210692d;
                        StructMsgForImageShare.sendAndUploadImageShare(qQAppInterface, structMsgForImageShare, resultRecord.uin, resultRecord.uinType, null, 0, new a(), true);
                        return;
                    }
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }, 8, null, false);
        }
    }

    private void z() {
        QLog.d(G, 1, "-->ForwardMultServerShare requestNormalShare");
        WeakReference weakReference = new WeakReference(new a());
        int i3 = this.f210689h.getInt("uintype");
        String string = this.f210689h.getString("uin");
        String string2 = this.f210689h.getString("troop_uin");
        ForwardStatisticsReporter.m("KEY_STAGE_2_SEND_MSG_BY_SERVER");
        AbsShareMsg.sendSdkShareMessageByServer(this.f210691m, this.C, string, i3, string2, (com.tencent.mobileqq.pic.ad) weakReference.get());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B(List<ResultRecord> list) {
        this.F = list;
        if (list != null && !list.isEmpty()) {
            if (this.f210691m == null) {
                QLog.e(G, 1, " sendArkWithStruct error null == mApp");
                x();
                return;
            }
            Bundle bundle = this.f210689h;
            if (bundle == null) {
                QLog.e(G, 1, " sendArkWithStruct error null == mExtraData");
                x();
                return;
            }
            if (this.f210690i == null) {
                QLog.e(G, 1, " sendArkWithStruct error null == mActivity");
                x();
                return;
            }
            AbsStructMsg e16 = com.tencent.mobileqq.structmsg.i.e(bundle);
            if (!(e16 instanceof AbsShareMsg)) {
                QLog.e(G, 1, " sendArkWithStruct error !(structMsg instanceof AbsShareMsg)");
                x();
                return;
            }
            this.C = (AbsShareMsg) e16;
            if (!NetworkUtil.isNetSupport(this.f210690i)) {
                QLog.d(G, 1, "sendArkWithStruct no network");
                ForwardUtils.S(this.f210690i, this.f210689h, HardCodeUtil.qqStr(R.string.mpz));
                return;
            } else {
                A();
                return;
            }
        }
        QLog.e(G, 1, "null == multiTargetWithoutDataLine || multiTargetWithoutDataLine.isEmpty()");
        x();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 != 95) {
            if (i3 == 96) {
                QLog.d(G, 1, "MSG_SDK_SHARE_REQUEST_TIMEOUT_STATUS");
                this.f210687e = true;
                if (!this.f210690i.isFinishing()) {
                    this.D.a(this.f210690i);
                    ForwardUtils.S(this.f210690i, this.f210689h, HardCodeUtil.qqStr(R.string.mpy));
                    return false;
                }
                x();
                return false;
            }
            return false;
        }
        QLog.d(G, 1, "MSG_SDK_SHARE_REQUEST_LOADING_STATUS");
        this.D.f(this.f210690i);
        MqqHandler mqqHandler = this.f210686d;
        mqqHandler.sendMessageDelayed(mqqHandler.obtainMessage(96), 10000L);
        return false;
    }

    protected Intent p() {
        Intent m3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Intent) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        Intent aliasIntent = SplashActivity.getAliasIntent(this.f210690i);
        if (!this.f210689h.getBoolean("share_from_aio", false)) {
            m3 = BaseAIOUtils.m(aliasIntent, new int[]{2});
            this.f210689h.remove("share_from_aio");
        } else {
            m3 = BaseAIOUtils.m(aliasIntent, null);
            m3.putExtra("share_from_aio", true);
        }
        m3.putExtra("open_chatfragment", false);
        m3.putExtra(SplashActivity.FRAGMENT_ID, 1);
        return m3;
    }

    protected Intent q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Intent) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (!this.f210689h.getBoolean("share_from_aio", false)) {
            this.f210689h.remove("share_from_aio");
        } else {
            this.f210689h.putBoolean("share_from_aio", true);
        }
        if (((IGuildFeedsHomeJumpApi) QRoute.api(IGuildFeedsHomeJumpApi.class)).isJumpFeedsHome()) {
            return ((ILaunchGuildChatPieApi) QRoute.api(ILaunchGuildChatPieApi.class)).getGuildChatActivityIntent(this.f210690i, new com.tencent.mobileqq.guild.api.i().f(this.F.get(0).guildId).b(this.F.get(0).uin).d(com.tencent.guild.aio.factory.a.class.getName()).e(null).a());
        }
        return ((ILaunchGuildChatPieApi) QRoute.api(ILaunchGuildChatPieApi.class)).getGuildChatPieIntent(this.f210690i, new LaunchGuildChatPieParam().l(this.F.get(0).guildId).b(this.F.get(0).uin).k(null).r(false).o(2).f(true).a());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(QQAppInterface qQAppInterface, Activity activity) {
        this.f210691m = qQAppInterface;
        this.f210690i = activity;
        this.D = new g();
    }

    protected boolean s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        List<ResultRecord> list = this.F;
        if (list == null || list.size() <= 0) {
            return false;
        }
        Iterator<ResultRecord> it = this.F.iterator();
        while (it.hasNext()) {
            if (it.next().uinType != 10014) {
                return false;
            }
        }
        return true;
    }
}
