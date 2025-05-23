package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.ProtoUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;
import com.tencent.mobileqq.activity.aio.BaseForwardUtil;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.business.OpenSdkFakeMsgProcessor;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.mini.share.opensdk.OpenSdkShareModel;
import com.tencent.mobileqq.pic.ad;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.BuddySource;
import common.config.service.QzoneConfig;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;
import tencent.im.msg.im_msg_body$RichText;
import tencent.im.oidb.cmd0xb77.oidb_cmd0xb77$ReqBody;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ForwardSDKB77Sender {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name */
    private static final String f210805g;

    /* renamed from: a, reason: collision with root package name */
    private Context f210806a;

    /* renamed from: b, reason: collision with root package name */
    private long f210807b;

    /* renamed from: c, reason: collision with root package name */
    private String f210808c;

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f210809d;

    /* renamed from: e, reason: collision with root package name */
    private MessageForArkApp f210810e;

    /* renamed from: f, reason: collision with root package name */
    private OpenSdkShareModel f210811f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements com.tencent.mobileqq.pic.ad {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Bundle f210812d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f210813e;

        a(Bundle bundle, long j3) {
            this.f210812d = bundle;
            this.f210813e = j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ForwardSDKB77Sender.this, bundle, Long.valueOf(j3));
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
            } else {
                QLog.d("SDK_SHARE.ForwardSDKB77Sender", 1, "upCallBack onSend result=", aVar);
                ForwardSDKB77Sender.this.f(aVar, this.f210812d, this.f210813e);
            }
        }

        @Override // com.tencent.mobileqq.pic.ad
        public void r(ad.a aVar) {
            String aVar2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
                return;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("upCallBack updateMsg info =");
            if (aVar == null) {
                aVar2 = "null";
            } else {
                aVar2 = aVar.toString();
            }
            sb5.append(aVar2);
            QLog.d("SDK_SHARE.ForwardSDKB77Sender", 1, sb5.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b extends ProtoUtils.TroopProtocolObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f210815d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Bundle f210816e;

        b(long j3, Bundle bundle) {
            this.f210815d = j3;
            this.f210816e = bundle;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ForwardSDKB77Sender.this, Long.valueOf(j3), bundle);
            }
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public boolean onError(int i3, String str, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, bundle)).booleanValue();
            }
            if (!TextUtils.isEmpty(str)) {
                QLog.e("SDK_SHARE.ForwardSDKB77Sender", 1, "onError msg =", str);
            }
            return super.onError(i3, str, bundle);
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int i3, byte[] bArr, Bundle bundle) {
            boolean z16;
            boolean z17;
            int i16 = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), bArr, bundle);
                return;
            }
            if (i16 == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            ForwardStatisticsReporter.k("KEY_STAGE_2_NORMAL_B77", z16);
            if (System.currentTimeMillis() - this.f210815d > 10000) {
                z17 = true;
            } else {
                z17 = false;
            }
            QLog.d("SDK_SHARE.ForwardSDKB77Sender", 1, "notifyServerSendMessage() onResult errorCode=", Integer.valueOf(i3), ", timeout=", Boolean.valueOf(z17));
            if (z17) {
                ForwardSDKB77Sender.this.g(new Object[]{0, "", HardCodeUtil.qqStr(R.string.mpy), ""}, -6);
                return;
            }
            if (bundle != null) {
                long j3 = bundle.getLong("0xb77_9_sendTime", -1L);
                if (j3 == -1 || j3 != ForwardSDKB77Sender.this.f210807b) {
                    QLog.d("SDK_SHARE.ForwardSDKB77Sender", 1, "handleGetMessageState currentRequestTime =" + ForwardSDKB77Sender.this.f210807b + ", sendStamp = " + j3);
                    return;
                }
            }
            ReportController.o(null, "dc00898", "", "", "0X8009C94", "0X8009C94", 0, 0, "" + i16, jq3.a.q(this.f210816e.getInt(AppConstants.Key.SHARE_REQ_TYPE)), jq3.a.r(this.f210816e.getInt("uintype")), this.f210816e.getString("title"));
            if (i16 == 0 && bArr != null) {
                ForwardSDKB77Sender.this.k(this.f210816e);
            }
            ForwardSDKB77Sender forwardSDKB77Sender = ForwardSDKB77Sender.this;
            Object[] b06 = ForwardUtils.b0(bArr);
            if (bArr == null) {
                i16 = -7;
            }
            forwardSDKB77Sender.g(b06, i16);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(72172);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f210805g = HardCodeUtil.qqStr(R.string.vrk);
        }
    }

    public ForwardSDKB77Sender() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f210807b = -1L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(ad.a aVar, Bundle bundle, long j3) {
        boolean z16;
        String str;
        if (System.currentTimeMillis() - j3 > 10000) {
            z16 = true;
        } else {
            z16 = false;
        }
        String string = bundle.getString("uin");
        HashMap hashMap = new HashMap();
        if (z16) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("param_time_out", str);
        if (string == null) {
            string = "";
        }
        ForwardStatisticsReporter.i("KEY_STAGE_2_SEND_MSG_BY_SERVER", string, hashMap, ForwardUtils.P(aVar));
        QLog.d("SDK_SHARE.ForwardSDKB77Sender", 1, "handleSendResult timeout=", Boolean.valueOf(z16));
        if (z16) {
            g(new Object[]{0, "", HardCodeUtil.qqStr(R.string.mpy), ""}, -3);
            return;
        }
        int i3 = aVar.f258597a;
        String[] strArr = (String[]) aVar.f258608l;
        if (i3 == 0) {
            if (strArr != null && strArr.length == 2) {
                QLog.i("SDK_SHARE.ForwardSDKB77Sender", 1, "UpCallBack onSend urls=" + strArr[0] + ", " + strArr[1]);
                h(bundle, strArr[0], strArr[1], j3);
                return;
            }
            QLog.e("SDK_SHARE.ForwardSDKB77Sender", 1, "onSend updateMsg error !");
            return;
        }
        if (-1 == i3) {
            int i16 = aVar.f258598b;
            boolean b16 = BaseForwardUtil.b(this.f210806a);
            QLog.d("SDK_SHARE.ForwardSDKB77Sender", 1, "UpCallBack onSend failed errCode=", i16 + ", hasSDPermission=", Boolean.valueOf(b16));
            if (i16 == 9402 && !b16 && strArr != null && strArr.length == 2) {
                QLog.d("SDK_SHARE.ForwardSDKB77Sender", 1, "UpCallBack onSend failed urls=", strArr[0], " ,", strArr[1]);
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.forward.ForwardSDKB77Sender.2
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) ForwardSDKB77Sender.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        } else {
                            QQToast.makeText(MobileQQ.sMobileQQ.getApplicationContext(), R.string.f1357502a, 0).show();
                        }
                    }
                });
                h(bundle, strArr[0], strArr[1], j3);
                return;
            }
            g(new Object[]{0, "", f210805g, ""}, -4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Object[] objArr, int i3) {
        QLog.d("SDK_SHARE.ForwardSDKB77Sender", 1, "notifyAIOActivity result[0]=", objArr[0], ", result[1]=", objArr[1], ", result[2]=", objArr[2], ", result[3]=", objArr[3], ", errorCode=", Integer.valueOf(i3));
        n(objArr, i3);
        if (-6 != i3 && -3 != i3) {
            HashMap hashMap = new HashMap();
            hashMap.put("key_b77_jump_result", objArr[0]);
            hashMap.put("key_b77_jump_url", objArr[1]);
            hashMap.put("key_b77_wording", objArr[2]);
            hashMap.put("key_b77_develop_msg", objArr[3]);
            hashMap.put("key_b77_error_code", Integer.valueOf(i3));
            Intent intent = new Intent("action_notify_aio_activity_by_b77");
            intent.putExtra("key_b77_error_code", i3);
            BaseApplication.getContext().sendBroadcast(intent);
            ((u) this.f210809d.getManager(QQManagerFactory.SDK_SHARE)).a(this.f210808c, hashMap);
            QLog.d("SDK_SHARE.ForwardSDKB77Sender", 1, "notifyAIOActivity mKey =", this.f210808c);
        }
    }

    private void h(Bundle bundle, String str, String str2, long j3) {
        long j16;
        MessageForArkApp messageForArkApp = this.f210810e;
        if (messageForArkApp == null) {
            j16 = 0;
        } else {
            j16 = messageForArkApp.uniseq;
        }
        oidb_cmd0xb77$ReqBody i3 = x.i(bundle, str, str2, null, j16);
        x.g(this.f210811f, bundle, i3);
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime == null) {
            QLog.e("SDK_SHARE.ForwardSDKB77Sender", 1, "notifyServerSendMessage send runtime = null ");
            g(new Object[]{0, "", f210805g, ""}, -5);
            return;
        }
        this.f210807b = System.currentTimeMillis();
        Bundle bundle2 = new Bundle();
        bundle2.putLong("0xb77_9_sendTime", this.f210807b);
        QLog.d("SDK_SHARE.ForwardSDKB77Sender", 1, "notifyServerSendMessage sendOIDBRequest");
        ForwardStatisticsReporter.m("KEY_STAGE_2_NORMAL_B77");
        ProtoUtils.c(runtime, new b(j3, bundle), i3.toByteArray(), "OidbSvc.0xb77_9", 2935, 9, bundle2, 0L);
    }

    private void i(AbsShareMsg absShareMsg, Bundle bundle) {
        String string = bundle.getString("uin");
        int i3 = bundle.getInt("uintype");
        String string2 = bundle.getString("troop_uin");
        ForwardStatisticsReporter.m("KEY_STAGE_2_SEND_MSG_BY_SERVER");
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        a aVar = new a(bundle, System.currentTimeMillis());
        if (m(bundle)) {
            MessageForArkApp sendSdkFakeMessage = AbsShareMsg.sendSdkFakeMessage(bundle, qQAppInterface, absShareMsg, string, i3, string2, aVar);
            this.f210810e = sendSdkFakeMessage;
            j(sendSdkFakeMessage, absShareMsg, bundle);
            bundle.putString("fake_friend_uin", this.f210810e.frienduin);
            bundle.putInt("fake_is_troop", this.f210810e.istroop);
            bundle.putLong("fake_uinseq", this.f210810e.uniseq);
            return;
        }
        AbsShareMsg.sendSdkShareMessageByServer(qQAppInterface, absShareMsg, string, i3, string2, aVar);
    }

    private void j(MessageForArkApp messageForArkApp, AbsShareMsg absShareMsg, Bundle bundle) {
        String str;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("fake_key", this.f210808c);
            jSONObject.put("forward_type", absShareMsg.forwardType);
            jSONObject.put("serviceType", absShareMsg.mMsgServiceID);
            jSONObject.put("appId", absShareMsg.mSourceAppid);
            jSONObject.put("pkg_name", absShareMsg.shareData.pkgName);
            jSONObject.put("targetUrl", absShareMsg.mMsgUrl);
            jSONObject.put("title", absShareMsg.mContentTitle);
            jSONObject.put("summary", absShareMsg.mContentSummary);
            jSONObject.put("image_url", absShareMsg.mContentCover);
            jSONObject.put(AppConstants.Key.SHARE_REQ_AUDIO_URL, absShareMsg.mContentSrc);
            jSONObject.put("imageUrlStatus", (int) absShareMsg.shareData.imageUrlStatus);
            jSONObject.put("shortUrlStatus", (int) absShareMsg.shareData.shortUrlStatus);
            jSONObject.put("appInfo_sourceName", absShareMsg.mSourceName);
            jSONObject.put("appInfo_sourceIconSmall", absShareMsg.mSourceIcon);
            jSONObject.put("appInfo_sourceIconBig", absShareMsg.shareData.sourceIconBig);
            jSONObject.put("appInfo_sourceUrl", absShareMsg.mSourceUrl);
            jSONObject.put("appInfo_packName", absShareMsg.mSource_A_ActionData);
            jSONObject.put("appInfo_status", (int) absShareMsg.shareData.appInfoStatus);
            jSONObject.put("uin", bundle.getString("uin"));
            jSONObject.put(AppConstants.Key.SHARE_REQ_TYPE, bundle.getInt(AppConstants.Key.SHARE_REQ_TYPE));
            jSONObject.put("title", bundle.getString("title"));
            jSONObject.put("uintype", bundle.getInt("uintype"));
            jSONObject.put(AppConstants.Key.SHARE_RES_COMMENT_MESSAGE_FOR_SERVER, bundle.getString(AppConstants.Key.SHARE_RES_COMMENT_MESSAGE_FOR_SERVER));
            jSONObject.put("req_share_id", bundle.getLong("req_share_id"));
            jSONObject.put("desc", bundle.getString("desc"));
            jSONObject.put("detail_url", bundle.getString("detail_url"));
            jSONObject.put(AppConstants.Key.SHARE_REQ_IMAGE_REMOTE_URL, bundle.getString(AppConstants.Key.SHARE_REQ_IMAGE_REMOTE_URL));
            jSONObject.put(AppConstants.Key.SHARE_RES_PKG_NAME, bundle.getString(AppConstants.Key.SHARE_RES_PKG_NAME));
            jSONObject.put(AppConstants.Key.SHARE_RES_COMMENT_MESSAGE, bundle.getString(AppConstants.Key.SHARE_RES_COMMENT_MESSAGE));
            jSONObject.put("forward_ark_app_name", bundle.getString("forward_ark_app_name"));
            jSONObject.put("forward_ark_app_view", bundle.getString("forward_ark_app_view"));
            jSONObject.put("forward_ark_app_ver", bundle.getString("forward_ark_app_ver"));
            jSONObject.put("forward_ark_app_meta", bundle.getString("forward_ark_app_meta"));
            jSONObject.put(AppConstants.Key.FORWARD_ARK_APP_CONFIG, bundle.getString(AppConstants.Key.FORWARD_ARK_APP_CONFIG));
            jSONObject.put(AppConstants.Key.SHARE_REQ_ARK_INFO, bundle.getString(AppConstants.Key.SHARE_REQ_ARK_INFO));
            jSONObject.put(AppConstants.Key.FORWARD_ARK_APP_DESC, bundle.getString(AppConstants.Key.FORWARD_ARK_APP_DESC));
            jSONObject.put("forward_ark_app_prompt", bundle.getString("forward_ark_app_prompt"));
            jSONObject.put(AppConstants.Key.FORWARD_ARK_APP_COMPAT, bundle.getString(AppConstants.Key.FORWARD_ARK_APP_COMPAT));
            jSONObject.put("uin", bundle.getString("uin"));
            jSONObject.put("troop_uin", bundle.getString("troop_uin"));
            jSONObject.put(AppConstants.Key.PHONENUM, bundle.getString(AppConstants.Key.PHONENUM));
            jSONObject.put(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, bundle.getInt(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, 0));
            jSONObject.put(AppConstants.Key.ADD_FRIEND_SOURCE_ID, bundle.getInt(AppConstants.Key.ADD_FRIEND_SOURCE_ID, BuddySource.DEFAULT));
            jSONObject.put(AppConstants.Key.SHARE_REQ_GAME_TAG_NAME, bundle.getString(AppConstants.Key.SHARE_REQ_GAME_TAG_NAME));
            jSONObject.put(AppConstants.Key.SHARE_REQ_GAME_MESSAGE_EXT, bundle.getString(AppConstants.Key.SHARE_REQ_GAME_MESSAGE_EXT));
            jSONObject.put("guild_id", bundle.getString("guild_id"));
            String jSONObject2 = jSONObject.toString();
            str = "SDK_SHARE.ForwardSDKB77Sender";
            try {
                QLog.d(str, 1, "saveExtInfo jsonStr=", jSONObject2);
                messageForArkApp.saveExtInfoToExtStr(com.tencent.mobileqq.service.message.i.f286280w, Integer.toString(-1));
                messageForArkApp.saveExtInfoToExtStr(com.tencent.mobileqq.service.message.i.f286282y, jSONObject2);
            } catch (Exception e16) {
                e = e16;
                QLog.e(str, 1, "Exception", e);
            }
        } catch (Exception e17) {
            e = e17;
            str = "SDK_SHARE.ForwardSDKB77Sender";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(Bundle bundle) {
        int i3 = bundle.getInt("uintype");
        String string = bundle.getString(AppConstants.Key.SHARE_RES_COMMENT_MESSAGE_FOR_SERVER);
        if (this.f210806a != null && !TextUtils.isEmpty(string)) {
            if (this.f210806a != null && !TextUtils.isEmpty(string)) {
                if (i3 != 10014) {
                    l(bundle);
                    return;
                } else {
                    ForwardUtils.l0(bundle);
                    return;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.e("SDK_SHARE.ForwardSDKB77Sender", 2, "sendCommentMsg null ");
                return;
            }
            return;
        }
        QLog.d("SDK_SHARE.ForwardSDKB77Sender", 1, "sendCommentMsg null");
    }

    private void l(Bundle bundle) {
        String string = bundle.getString(AppConstants.Key.SHARE_RES_COMMENT_MESSAGE_FOR_SERVER);
        try {
            SessionInfo p06 = ForwardUtils.p0(bundle);
            com.tencent.biz.anonymous.a.h().f78364c = true;
            com.tencent.mobileqq.forward.utils.f.f211079a.i(p06, string);
        } catch (Exception e16) {
            QLog.e("SDK_SHARE.ForwardSDKB77Sender", 1, "sendCommentMsgToC2C exception", e16);
        }
    }

    private boolean m(Bundle bundle) {
        if (!OpenSdkFakeMsgProcessor.a() || ArkFullScreenAppActivity.T2(bundle)) {
            return false;
        }
        int i3 = bundle.getInt("uintype");
        if ("0".equals(jq3.a.r(i3))) {
            QLog.d("SDK_SHARE.ForwardSDKB77Sender", 1, "toFakeMsg not support =", Integer.valueOf(i3));
            return false;
        }
        int i16 = bundle.getInt(AppConstants.Key.SHARE_REQ_TYPE);
        QLog.d("SDK_SHARE.ForwardSDKB77Sender", 1, "toFakeMsg reqType=", Integer.valueOf(i16));
        if (i16 != 1 && i16 != 2) {
            return false;
        }
        return true;
    }

    private void n(Object[] objArr, int i3) {
        MessageForArkApp messageForArkApp = this.f210810e;
        if (messageForArkApp == null) {
            QLog.d("SDK_SHARE.ForwardSDKB77Sender", 1, "updateFakeArkMsg (null == mFakeArkMsg)");
            return;
        }
        if (i3 != 0 && i3 != -2) {
            l.h(this.f210809d, messageForArkApp, i3, (String) objArr[2]);
            return;
        }
        QLog.d("SDK_SHARE.ForwardSDKB77Sender", 1, "updateFakeArkMsg errorCode=", Integer.valueOf(i3));
        MessageForArkApp messageForArkApp2 = this.f210810e;
        messageForArkApp2.extraflag = 0;
        messageForArkApp2.saveMsgExtStrAndFlag(this.f210809d);
        com.tencent.mobileqq.service.message.e msgCache = this.f210809d.getMsgCache();
        MessageForArkApp messageForArkApp3 = this.f210810e;
        msgCache.G1(messageForArkApp3.frienduin, messageForArkApp3.istroop, messageForArkApp3.uniseq);
        MessageHandler msgHandler = this.f210809d.getMsgHandler();
        MessageForArkApp messageForArkApp4 = this.f210810e;
        msgHandler.notifyUI(6003, true, new String[]{messageForArkApp4.frienduin, String.valueOf(messageForArkApp4.uniseq)});
    }

    public void e(QQAppInterface qQAppInterface, AbsShareMsg absShareMsg, Activity activity, Bundle bundle, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, qQAppInterface, absShareMsg, activity, bundle, str);
            return;
        }
        this.f210809d = qQAppInterface;
        this.f210808c = str;
        this.f210806a = activity;
        this.f210811f = (OpenSdkShareModel) activity.getIntent().getParcelableExtra("KEY_MINI_PROGRAM_SHARE_OBJ");
        if (absShareMsg == null) {
            QLog.e("SDK_SHARE.ForwardSDKB77Sender", 1, "requestShareMessage error structMsg = null");
            return;
        }
        if (!NetworkUtil.isNetSupport(this.f210806a)) {
            g(new Object[]{0, "", HardCodeUtil.qqStr(R.string.mpz), ""}, -2);
            QLog.e("SDK_SHARE.ForwardSDKB77Sender", 1, " requestShareMessage net error");
        } else {
            QLog.d("SDK_SHARE.ForwardSDKB77Sender", 1, " forwardShare structMsg=", absShareMsg.getXml(), ", key=", str);
            jq3.a.j(bundle);
            i(absShareMsg, bundle);
        }
    }
}
