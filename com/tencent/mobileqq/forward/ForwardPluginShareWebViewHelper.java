package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.ProtoUtils;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0xb77.oidb_cmd0xb77$ClientInfo;
import tencent.im.oidb.cmd0xb77.oidb_cmd0xb77$ReqBody;
import tencent.im.oidb.cmd0xb77.oidb_cmd0xb77$RichMsgBody;
import tencent.im.oidb.cmd0xdc2.oidb_cmd0xdc2$BatchSendReq;
import tencent.im.oidb.cmd0xdc2.oidb_cmd0xdc2$BatchSendRsp;
import tencent.im.oidb.cmd0xdc2.oidb_cmd0xdc2$ReqBody;

/* loaded from: classes12.dex */
public class ForwardPluginShareWebViewHelper {
    static IPatchRedirector $redirector_;

    /* loaded from: classes12.dex */
    class a extends ProtoUtils.TroopProtocolObserver {
        static IPatchRedirector $redirector_;
        final /* synthetic */ QQAppInterface C;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQProgressDialog f210745d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Activity f210746e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ SessionInfo f210747f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f210748h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ boolean f210749i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ Intent f210750m;

        a(QQProgressDialog qQProgressDialog, Activity activity, SessionInfo sessionInfo, String str, boolean z16, Intent intent, QQAppInterface qQAppInterface) {
            this.f210745d = qQProgressDialog;
            this.f210746e = activity;
            this.f210747f = sessionInfo;
            this.f210748h = str;
            this.f210749i = z16;
            this.f210750m = intent;
            this.C = qQAppInterface;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, qQProgressDialog, activity, sessionInfo, str, Boolean.valueOf(z16), intent, qQAppInterface);
            }
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public boolean onError(int i3, String str, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, bundle)).booleanValue();
            }
            this.f210745d.dismiss();
            QQToast.makeText(BaseApplication.getContext(), R.string.hit, 0).show();
            this.f210746e.finish();
            QLog.e("ForwardPluginShareWebViewHelper", 1, "onError errCode= ", Integer.valueOf(i3), ", msg= ", str);
            return true;
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0052  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0086  */
        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onResult(int i3, byte[] bArr, Bundle bundle) {
            boolean z16;
            List<oidb_cmd0xdc2$BatchSendRsp> c06;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), bArr, bundle);
                return;
            }
            this.f210745d.dismiss();
            String str = "";
            if (i3 == 0 && (c06 = ForwardUtils.c0(bArr)) != null && c06.size() > 0) {
                oidb_cmd0xdc2$BatchSendRsp oidb_cmd0xdc2_batchsendrsp = c06.get(0);
                if (oidb_cmd0xdc2_batchsendrsp.err_code.get() == 0) {
                    z16 = true;
                    if (!z16) {
                        com.tencent.mobileqq.forward.utils.f.f211079a.i(this.f210747f, this.f210748h);
                        if (this.f210749i) {
                            this.f210746e.startActivity(this.f210750m);
                        }
                        QQToast.makeText(this.C.getApp(), 2, R.string.f170969bc3, 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                    } else {
                        String string = BaseApplication.getContext().getString(R.string.hit);
                        if (!TextUtils.isEmpty(str)) {
                            string = string + ":" + str;
                        }
                        QQToast.makeText(BaseApplication.getContext(), 1, string, 0).show();
                    }
                    this.f210746e.finish();
                    QLog.d("ForwardPluginShareWebViewHelper", 1, "webview send oidb_cmd0xdc2 errorCode= ", Integer.valueOf(i3), ", errorMsg= ", str);
                }
                str = oidb_cmd0xdc2_batchsendrsp.rsp_body.wording.get();
            }
            z16 = false;
            if (!z16) {
            }
            this.f210746e.finish();
            QLog.d("ForwardPluginShareWebViewHelper", 1, "webview send oidb_cmd0xdc2 errorCode= ", Integer.valueOf(i3), ", errorMsg= ", str);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0049, code lost:
    
        if (r6 > 0) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static oidb_cmd0xb77$ReqBody a(SessionInfo sessionInfo, Bundle bundle, AbsShareMsg absShareMsg) {
        long j3;
        int i3 = sessionInfo.f179555d;
        String string = bundle.getString("title");
        String string2 = bundle.getString("desc");
        String string3 = bundle.getString("detail_url");
        String string4 = bundle.getString(AppConstants.Key.SHARE_REQ_IMAGE_REMOTE_URL);
        if (absShareMsg != null) {
            if (TextUtils.isEmpty(string)) {
                string = absShareMsg.mContentTitle;
            }
            if (TextUtils.isEmpty(string2)) {
                string2 = absShareMsg.mContentSummary;
            }
            if (TextUtils.isEmpty(string3)) {
                string3 = absShareMsg.mMsgUrl;
            }
            if (TextUtils.isEmpty(string4)) {
                string4 = absShareMsg.mSourceIcon;
            }
            j3 = absShareMsg.mSourceAppid;
        }
        j3 = 100446242;
        if (j3 == 100446242) {
            j3 = c(bundle, j3);
        }
        long Z = ForwardUtils.Z(bundle.getString("uin"));
        long Z2 = ForwardUtils.Z(bundle.getString("guild_id"));
        QLog.d("ForwardPluginShareWebViewHelper", 1, "buildcmd0xb77ReqBody picture_url =" + string4 + "\n, appId=" + j3 + ", uinType = " + i3 + "\n, title = " + string + ", summary = " + string2 + ", url = " + string3 + " channelId = " + Z + " guildId " + Z2);
        oidb_cmd0xb77$ReqBody oidb_cmd0xb77_reqbody = new oidb_cmd0xb77$ReqBody();
        oidb_cmd0xb77_reqbody.appid.set(j3);
        oidb_cmd0xb77_reqbody.app_type.set(1);
        oidb_cmd0xb77_reqbody.msg_style.set(0);
        oidb_cmd0xb77_reqbody.recv_uin.set(Z);
        oidb_cmd0xb77$RichMsgBody oidb_cmd0xb77_richmsgbody = new oidb_cmd0xb77$RichMsgBody();
        oidb_cmd0xb77_richmsgbody.using_ark.set(true);
        if (!TextUtils.isEmpty(string)) {
            oidb_cmd0xb77_richmsgbody.title.set(string);
        }
        if (!TextUtils.isEmpty(string2)) {
            if (string2.contains(HardCodeUtil.qqStr(R.string.mqe))) {
                string2 = string2.replace(HardCodeUtil.qqStr(R.string.mr5), "");
            }
            oidb_cmd0xb77_richmsgbody.summary.set(string2);
        }
        if (!TextUtils.isEmpty(string3)) {
            oidb_cmd0xb77_richmsgbody.url.set(string3);
        }
        if (!TextUtils.isEmpty(string4)) {
            oidb_cmd0xb77_richmsgbody.picture_url.set(string4);
        }
        oidb_cmd0xb77_reqbody.rich_msg_body.set(oidb_cmd0xb77_richmsgbody);
        oidb_cmd0xb77_reqbody.send_type.set(3);
        oidb_cmd0xb77_reqbody.recv_guild_id.set(Z2);
        return oidb_cmd0xb77_reqbody;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x00d3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static oidb_cmd0xdc2$ReqBody b(SessionInfo sessionInfo, Bundle bundle) {
        int i3;
        int i16 = sessionInfo.f179555d;
        long parseLong = Long.parseLong(sessionInfo.f179557e);
        String string = bundle.getString("title");
        String string2 = bundle.getString("desc");
        String string3 = bundle.getString("detail_url");
        String string4 = bundle.getString(AppConstants.Key.SHARE_REQ_IMAGE_REMOTE_URL);
        String string5 = bundle.getString(AppConstants.Key.SHARE_BRIEF);
        QLog.d("ForwardPluginShareWebViewHelper", 1, "buildcmd0xb77ReqBody picture_url =" + string4 + "\n, appId=100446242, uinType = " + i16 + "\n, brief = " + string5 + "\n, title = " + string + ", summary = " + string2 + ", url = " + string3);
        if (i16 != 0) {
            if (i16 == 1) {
                i3 = 1;
            } else if (i16 == 3000) {
                i3 = 2;
            }
            oidb_cmd0xdc2$ReqBody oidb_cmd0xdc2_reqbody = new oidb_cmd0xdc2$ReqBody();
            oidb_cmd0xb77$ReqBody oidb_cmd0xb77_reqbody = new oidb_cmd0xb77$ReqBody();
            oidb_cmd0xb77_reqbody.appid.set(100446242L);
            oidb_cmd0xb77_reqbody.app_type.set(1);
            oidb_cmd0xb77_reqbody.msg_style.set(0);
            oidb_cmd0xb77_reqbody.recv_uin.set(parseLong);
            oidb_cmd0xb77$ClientInfo oidb_cmd0xb77_clientinfo = new oidb_cmd0xb77$ClientInfo();
            oidb_cmd0xb77_clientinfo.platform.set(1);
            oidb_cmd0xb77_reqbody.client_info.set(oidb_cmd0xb77_clientinfo);
            oidb_cmd0xb77$RichMsgBody oidb_cmd0xb77_richmsgbody = new oidb_cmd0xb77$RichMsgBody();
            oidb_cmd0xb77_richmsgbody.using_ark.set(true);
            if (!TextUtils.isEmpty(string)) {
                oidb_cmd0xb77_richmsgbody.title.set(string);
            }
            if (!TextUtils.isEmpty(string2)) {
                if (string2.contains(HardCodeUtil.qqStr(R.string.mqe))) {
                    string2 = string2.replace(HardCodeUtil.qqStr(R.string.mr5), "");
                }
                oidb_cmd0xb77_richmsgbody.summary.set(string2);
            }
            if (!TextUtils.isEmpty(string3)) {
                oidb_cmd0xb77_richmsgbody.url.set(string3);
            }
            if (!TextUtils.isEmpty(string4)) {
                oidb_cmd0xb77_richmsgbody.picture_url.set(string4);
            }
            if (!TextUtils.isEmpty(string5)) {
                oidb_cmd0xb77_richmsgbody.brief.set(string5);
            }
            oidb_cmd0xb77_reqbody.rich_msg_body.set(oidb_cmd0xb77_richmsgbody);
            oidb_cmd0xdc2_reqbody.msg_body.set(oidb_cmd0xb77_reqbody);
            ArrayList arrayList = new ArrayList();
            oidb_cmd0xdc2$BatchSendReq oidb_cmd0xdc2_batchsendreq = new oidb_cmd0xdc2$BatchSendReq();
            oidb_cmd0xdc2_batchsendreq.recv_uin.set(parseLong);
            oidb_cmd0xdc2_batchsendreq.send_type.set(i3);
            arrayList.add(oidb_cmd0xdc2_batchsendreq);
            oidb_cmd0xdc2_reqbody.batch_send_req.set(arrayList);
            return oidb_cmd0xdc2_reqbody;
        }
        i3 = 0;
        oidb_cmd0xdc2$ReqBody oidb_cmd0xdc2_reqbody2 = new oidb_cmd0xdc2$ReqBody();
        oidb_cmd0xb77$ReqBody oidb_cmd0xb77_reqbody2 = new oidb_cmd0xb77$ReqBody();
        oidb_cmd0xb77_reqbody2.appid.set(100446242L);
        oidb_cmd0xb77_reqbody2.app_type.set(1);
        oidb_cmd0xb77_reqbody2.msg_style.set(0);
        oidb_cmd0xb77_reqbody2.recv_uin.set(parseLong);
        oidb_cmd0xb77$ClientInfo oidb_cmd0xb77_clientinfo2 = new oidb_cmd0xb77$ClientInfo();
        oidb_cmd0xb77_clientinfo2.platform.set(1);
        oidb_cmd0xb77_reqbody2.client_info.set(oidb_cmd0xb77_clientinfo2);
        oidb_cmd0xb77$RichMsgBody oidb_cmd0xb77_richmsgbody2 = new oidb_cmd0xb77$RichMsgBody();
        oidb_cmd0xb77_richmsgbody2.using_ark.set(true);
        if (!TextUtils.isEmpty(string)) {
        }
        if (!TextUtils.isEmpty(string2)) {
        }
        if (!TextUtils.isEmpty(string3)) {
        }
        if (!TextUtils.isEmpty(string4)) {
        }
        if (!TextUtils.isEmpty(string5)) {
        }
        oidb_cmd0xb77_reqbody2.rich_msg_body.set(oidb_cmd0xb77_richmsgbody2);
        oidb_cmd0xdc2_reqbody2.msg_body.set(oidb_cmd0xb77_reqbody2);
        ArrayList arrayList2 = new ArrayList();
        oidb_cmd0xdc2$BatchSendReq oidb_cmd0xdc2_batchsendreq2 = new oidb_cmd0xdc2$BatchSendReq();
        oidb_cmd0xdc2_batchsendreq2.recv_uin.set(parseLong);
        oidb_cmd0xdc2_batchsendreq2.send_type.set(i3);
        arrayList2.add(oidb_cmd0xdc2_batchsendreq2);
        oidb_cmd0xdc2_reqbody2.batch_send_req.set(arrayList2);
        return oidb_cmd0xdc2_reqbody2;
    }

    protected static long c(Bundle bundle, long j3) {
        try {
            if (!TextUtils.isEmpty(bundle.getString("detail_url")) && bundle.getString("detail_url").contains("appid=")) {
                for (String str : bundle.getString("detail_url").split(ContainerUtils.FIELD_DELIMITER)) {
                    if (!TextUtils.isEmpty(str) && str.contains("appid=")) {
                        long longValue = Long.valueOf(str.replace("appid=", "")).longValue();
                        if (longValue > SafeBitmapFactory.PX_THRESHOID_DEFAULTS) {
                            return longValue;
                        }
                        return j3;
                    }
                }
                return j3;
            }
            return j3;
        } catch (Exception e16) {
            QLog.e("ForwardPluginShareWebViewHelper", 1, "decode appid fail" + e16);
            return j3;
        }
    }

    public static void d(@NonNull QQAppInterface qQAppInterface, @NonNull Activity activity, @NonNull SessionInfo sessionInfo, @NonNull Intent intent, AbsShareMsg absShareMsg) {
        QQProgressDialog qQProgressDialog = new QQProgressDialog(activity, activity.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
        qQProgressDialog.setMessage(R.string.cpr);
        qQProgressDialog.show();
        String stringExtra = intent.getStringExtra(AppConstants.Key.SHARE_RES_COMMENT_MESSAGE);
        Bundle extras = intent.getExtras();
        extras.putInt("uintype", sessionInfo.f179555d);
        extras.putString("uin", sessionInfo.f179557e);
        extras.putLong("req_share_id", 0L);
        extras.putInt(AppConstants.Key.SHARE_REQ_TYPE, 1);
        oidb_cmd0xb77$ReqBody a16 = a(sessionInfo, extras, absShareMsg);
        ProtoUtils.c(qQAppInterface, new ProtoUtils.TroopProtocolObserver(activity, sessionInfo, stringExtra, qQAppInterface) { // from class: com.tencent.mobileqq.forward.ForwardPluginShareWebViewHelper.2
            static IPatchRedirector $redirector_;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Activity f210740e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ SessionInfo f210741f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ String f210742h;

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ QQAppInterface f210743i;

            {
                this.f210740e = activity;
                this.f210741f = sessionInfo;
                this.f210742h = stringExtra;
                this.f210743i = qQAppInterface;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, QQProgressDialog.this, activity, sessionInfo, stringExtra, qQAppInterface);
                }
            }

            @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
            public boolean onError(int i3, String str, Bundle bundle) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, bundle)).booleanValue();
                }
                QQProgressDialog.this.dismiss();
                QQToast.makeText(BaseApplication.getContext(), R.string.hit, 0).show();
                this.f210740e.finish();
                QLog.e("ForwardPluginShareWebViewHelper", 1, "onError msg =", str);
                return true;
            }

            /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
            /* JADX WARN: Removed duplicated region for block: B:21:0x0061  */
            @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onResult(int i3, byte[] bArr, Bundle bundle) {
                String str;
                boolean z16;
                String str2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), bArr, bundle);
                    return;
                }
                QQProgressDialog.this.dismiss();
                if (i3 == 0) {
                    Object[] b06 = ForwardUtils.b0(bArr);
                    str = "";
                    if (b06 != null && b06.length > 0) {
                        if (((Integer) b06[0]).intValue() == 0) {
                            z16 = true;
                            if (!z16) {
                                com.tencent.mobileqq.forward.utils.f.f211079a.i(this.f210741f, this.f210742h);
                                str2 = BaseApplication.getContext().getString(R.string.f170969bc3);
                            } else {
                                str2 = BaseApplication.getContext().getString(R.string.hit) + ":" + str;
                                QQToast.makeText(BaseApplication.getContext(), str2, 0).show();
                            }
                            ThreadManager.getUIHandler().postDelayed(new Runnable(str2) { // from class: com.tencent.mobileqq.forward.ForwardPluginShareWebViewHelper.2.1
                                static IPatchRedirector $redirector_;

                                /* renamed from: d, reason: collision with root package name */
                                final /* synthetic */ String f210744d;

                                {
                                    this.f210744d = str2;
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this, (Object) str2);
                                    }
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    IPatchRedirector iPatchRedirector2 = $redirector_;
                                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                        iPatchRedirector2.redirect((short) 2, (Object) this);
                                    } else if (NetworkUtil.getSystemNetwork(BaseApplication.getContext()) != 0) {
                                        QQToast.makeText(AnonymousClass2.this.f210743i.getApp(), 2, this.f210744d, 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                                    }
                                }
                            }, 300L);
                            this.f210740e.finish();
                            QLog.d("ForwardPluginShareWebViewHelper", 1, "webview send oidb_cmd0xdc2 errorCode=", Integer.valueOf(i3), ",errorMsg = ", str);
                        }
                        str = (String) b06[2];
                    }
                } else {
                    str = "sso error";
                }
                z16 = false;
                if (!z16) {
                }
                ThreadManager.getUIHandler().postDelayed(new Runnable(str2) { // from class: com.tencent.mobileqq.forward.ForwardPluginShareWebViewHelper.2.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ String f210744d;

                    {
                        this.f210744d = str2;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this, (Object) str2);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else if (NetworkUtil.getSystemNetwork(BaseApplication.getContext()) != 0) {
                            QQToast.makeText(AnonymousClass2.this.f210743i.getApp(), 2, this.f210744d, 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                        }
                    }
                }, 300L);
                this.f210740e.finish();
                QLog.d("ForwardPluginShareWebViewHelper", 1, "webview send oidb_cmd0xdc2 errorCode=", Integer.valueOf(i3), ",errorMsg = ", str);
            }
        }, a16.toByteArray(), "OidbSvc.0xb77_34", 2935, 34, new Bundle(), 5000L);
    }

    public static void e(@NonNull QQAppInterface qQAppInterface, @NonNull Activity activity, @NonNull SessionInfo sessionInfo, @NonNull Intent intent, boolean z16) {
        QQProgressDialog qQProgressDialog = new QQProgressDialog(activity, activity.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
        qQProgressDialog.setMessage(R.string.cpr);
        qQProgressDialog.show();
        String stringExtra = intent.getStringExtra(AppConstants.Key.SHARE_RES_COMMENT_MESSAGE);
        Bundle extras = intent.getExtras();
        extras.putInt("uintype", sessionInfo.f179555d);
        extras.putString("uin", sessionInfo.f179557e);
        extras.putLong("req_share_id", 0L);
        extras.putInt(AppConstants.Key.SHARE_REQ_TYPE, 1);
        oidb_cmd0xdc2$ReqBody b16 = b(sessionInfo, extras);
        ProtoUtils.c(qQAppInterface, new a(qQProgressDialog, activity, sessionInfo, stringExtra, z16, intent, qQAppInterface), b16.toByteArray(), "OidbSvc.0xdc2_34", 3522, 34, new Bundle(), 5000L);
    }
}
