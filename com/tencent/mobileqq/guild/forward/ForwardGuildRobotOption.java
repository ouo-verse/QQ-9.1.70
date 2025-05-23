package com.tencent.mobileqq.guild.forward;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.ProtoUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.share.IShareArkViewApi;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.ak;
import com.tencent.mobileqq.forward.al;
import com.tencent.mobileqq.forward.e;
import com.tencent.mobileqq.guild.feed.api.SharePublishGuildFeedParam;
import com.tencent.mobileqq.guild.feed.api.g;
import com.tencent.mobileqq.guild.forward.ForwardGuildRobotOption;
import com.tencent.mobileqq.guild.robot.api.model.share.RobotShareInGuildParams;
import com.tencent.mobileqq.guild.robot.api.model.share.RobotShareInQQParams;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xb77.oidb_cmd0xb77$ArkV1MsgBody;
import tencent.im.oidb.cmd0xb77.oidb_cmd0xb77$ReqBody;
import tencent.im.oidb.cmd0xb77.oidb_cmd0xb77$TemplateItem;

/* compiled from: P */
/* loaded from: classes33.dex */
public class ForwardGuildRobotOption extends ForwardBaseOption implements al {

    /* renamed from: d, reason: collision with root package name */
    private final long f224515d;

    /* renamed from: e, reason: collision with root package name */
    private final String f224516e;

    /* renamed from: f, reason: collision with root package name */
    private int f224517f;

    /* renamed from: h, reason: collision with root package name */
    private int f224518h;

    /* renamed from: i, reason: collision with root package name */
    private int f224519i;

    public ForwardGuildRobotOption(Intent intent) {
        super(intent);
        this.f224517f = 1;
        this.f224518h = 0;
        this.f224519i = 0;
        intent.putExtra("is_need_show_toast", false);
        this.f224515d = this.mExtraData.getLong("robot_uin");
        this.f224516e = this.mExtraData.getString("robot_name");
    }

    private oidb_cmd0xb77$ReqBody q(Bundle bundle) {
        String string = bundle.getString("guild_id");
        String string2 = bundle.getString("uin");
        oidb_cmd0xb77$ReqBody oidb_cmd0xb77_reqbody = new oidb_cmd0xb77$ReqBody();
        long j3 = bundle.getLong("req_share_id");
        int i3 = bundle.getInt("uintype");
        String string3 = bundle.getString("forward_ark_app_name");
        String string4 = bundle.getString("forward_ark_app_view");
        String string5 = bundle.getString(AppConstants.Key.FORWARD_ARK_APP_DESC);
        String string6 = bundle.getString("forward_ark_app_ver");
        String string7 = bundle.getString("forward_ark_app_prompt");
        String string8 = bundle.getString(AppConstants.Key.FORWARD_ARK_APP_CONFIG);
        Parcelable parcelable = bundle.getParcelable("ROBOT_SHARE_PARAMS");
        long j16 = this.mExtraData.getLong("robot_id");
        long j17 = this.mExtraData.getLong("robot_uin");
        oidb_cmd0xb77_reqbody.appid.set(j3);
        oidb_cmd0xb77_reqbody.app_type.set(1);
        oidb_cmd0xb77_reqbody.msg_style.set(3);
        oidb_cmd0xb77$ArkV1MsgBody oidb_cmd0xb77_arkv1msgbody = new oidb_cmd0xb77$ArkV1MsgBody();
        oidb_cmd0xb77_arkv1msgbody.app.set(v(string3));
        oidb_cmd0xb77_arkv1msgbody.view.set(v(string4));
        oidb_cmd0xb77_arkv1msgbody.desc.set(v(string5));
        oidb_cmd0xb77_arkv1msgbody.ver.set(v(string6));
        oidb_cmd0xb77_arkv1msgbody.prompt.set(v(string7));
        oidb_cmd0xb77_arkv1msgbody.items.add(r("id", String.valueOf(j16), 0));
        oidb_cmd0xb77_arkv1msgbody.items.add(r("uin", String.valueOf(j17), 0));
        if (parcelable instanceof RobotShareInGuildParams) {
            RobotShareInGuildParams robotShareInGuildParams = (RobotShareInGuildParams) parcelable;
            oidb_cmd0xb77_arkv1msgbody.app.set(v(robotShareInGuildParams.c()));
            oidb_cmd0xb77_arkv1msgbody.config.set(v(string8));
            oidb_cmd0xb77_arkv1msgbody.meta.set(robotShareInGuildParams.a());
            oidb_cmd0xb77_reqbody.send_type.set(3);
            oidb_cmd0xb77_arkv1msgbody.items.add(r("channelId", string2, 0));
            if (!TextUtils.isEmpty(string)) {
                oidb_cmd0xb77_arkv1msgbody.items.add(r("guildId", string, 0));
            }
            oidb_cmd0xb77_arkv1msgbody.items.add(r("name", robotShareInGuildParams.k(), 0));
            oidb_cmd0xb77_arkv1msgbody.items.add(r("desc", robotShareInGuildParams.j(), 0));
            oidb_cmd0xb77_arkv1msgbody.items.add(r("avatar", robotShareInGuildParams.g(), 1));
            oidb_cmd0xb77_arkv1msgbody.items.add(r("app_id", String.valueOf(robotShareInGuildParams.f()), 0));
            oidb_cmd0xb77_arkv1msgbody.items.add(r("remarks", robotShareInGuildParams.l(), 0));
            oidb_cmd0xb77_arkv1msgbody.items.add(r("addBtnText", robotShareInGuildParams.b(), 0));
            oidb_cmd0xb77_arkv1msgbody.items.add(r("tagText", robotShareInGuildParams.m(), 0));
            if (!TextUtils.isEmpty(string)) {
                oidb_cmd0xb77_reqbody.recv_guild_id.set(ForwardUtils.Z(string));
            }
        } else if (parcelable instanceof RobotShareInQQParams) {
            RobotShareInQQParams robotShareInQQParams = (RobotShareInQQParams) parcelable;
            oidb_cmd0xb77_arkv1msgbody.meta.set(robotShareInQQParams.a());
            oidb_cmd0xb77_reqbody.send_type.set(i3);
            oidb_cmd0xb77_arkv1msgbody.items.add(r("name", robotShareInQQParams.g(), 0));
            oidb_cmd0xb77_arkv1msgbody.items.add(r("desc", robotShareInQQParams.f(), 0));
            oidb_cmd0xb77_arkv1msgbody.items.add(r("avatar", robotShareInQQParams.e(), 1));
            oidb_cmd0xb77_arkv1msgbody.items.add(r("app_id", String.valueOf(robotShareInQQParams.c()), 0));
            oidb_cmd0xb77_arkv1msgbody.items.add(r("remarks", robotShareInQQParams.j(), 0));
            oidb_cmd0xb77_arkv1msgbody.items.add(r("remarksLogo", robotShareInQQParams.k(), 1));
        }
        oidb_cmd0xb77_reqbody.arkv1_msg_body.set(oidb_cmd0xb77_arkv1msgbody);
        oidb_cmd0xb77_reqbody.recv_uin.set(ForwardUtils.Z(string2));
        return oidb_cmd0xb77_reqbody;
    }

    private oidb_cmd0xb77$TemplateItem r(String str, String str2, int i3) {
        oidb_cmd0xb77$TemplateItem oidb_cmd0xb77_templateitem = new oidb_cmd0xb77$TemplateItem();
        oidb_cmd0xb77_templateitem.key.set(x(str));
        oidb_cmd0xb77_templateitem.value.set(str2);
        oidb_cmd0xb77_templateitem.type.set(i3);
        return oidb_cmd0xb77_templateitem;
    }

    private void s(Bundle bundle) {
        oidb_cmd0xb77$ReqBody q16 = q(bundle);
        ProtoUtils.c(this.app, new a(bundle, jo1.b.b(this.mExtraData, this.mConfirmDialog)), q16.toByteArray(), "OidbSvc.0xb77_46", 2935, 46, new Bundle(), 5000L);
    }

    private Bundle t(ResultRecord resultRecord) {
        Bundle bundle = new Bundle();
        bundle.putAll(this.mExtraData);
        bundle.putInt("uintype", resultRecord.getUinType());
        bundle.putString("guild_id", resultRecord.guildId);
        bundle.putString("uin", resultRecord.uin);
        return bundle;
    }

    private String u() {
        try {
            JSONArray jSONArray = new JSONArray();
            if (isMultiTarget2Send()) {
                List<ResultRecord> multiTargetWithoutDataLine = getMultiTargetWithoutDataLine();
                if (multiTargetWithoutDataLine != null) {
                    for (ResultRecord resultRecord : multiTargetWithoutDataLine) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("guildId", resultRecord.guildId);
                        jSONObject.put("channelId", resultRecord.uin);
                        jSONArray.mo162put(jSONObject);
                    }
                }
            } else {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("guildId", this.mExtraData.getString("guild_id"));
                jSONObject2.put("channelId", this.mExtraData.getString("uin"));
                jSONArray.mo162put(jSONObject2);
            }
            return jSONArray.toString();
        } catch (JSONException e16) {
            QLog.e("ForwardGuildRobotOption", 1, e16, new Object[0]);
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        String string;
        if (this.f224518h + this.f224519i < this.f224517f) {
            return;
        }
        BaseApplication context = BaseApplication.getContext();
        int systemNetwork = NetworkUtil.getSystemNetwork(context);
        int i3 = this.f224518h;
        int i16 = this.f224517f;
        int i17 = 2;
        if (i3 == i16) {
            string = context.getString(R.string.f132804e);
        } else {
            if (this.f224519i == i16) {
                string = context.getString(R.string.f132784c);
            } else {
                string = context.getString(R.string.f132794d, Integer.valueOf(i3), Integer.valueOf(this.f224519i));
            }
            i17 = 1;
        }
        if (systemNetwork != 0) {
            QQToast.makeText(context, i17, string, 0).show(context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
        }
    }

    private String x(String str) {
        return "#" + str + "#";
    }

    @Override // com.tencent.mobileqq.forward.al
    public /* synthetic */ void a(Activity activity, String str, int i3, g gVar) {
        ak.a(this, activity, str, i3, gVar);
    }

    @Override // com.tencent.mobileqq.forward.al
    public boolean b() {
        Intent intent = this.mIntent;
        return (intent == null || jo1.b.f410734a.a(intent) == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void buildForwardAbility() {
        if (allowFriendAbility()) {
            this.mForwardAbilities.add(e.O3);
        }
        if (allowTroopAbility()) {
            this.mForwardAbilities.add(e.P3);
        }
        if (allowDiscussAbility()) {
            this.mForwardAbilities.add(e.Q3);
        }
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void buildForwardDialog(int i3, Bundle bundle) {
        ViewGroup rootView;
        super.buildForwardDialog(i3, bundle);
        QQCustomDialog qQCustomDialog = this.mConfirmDialog;
        if (qQCustomDialog == null || (rootView = qQCustomDialog.getRootView()) == null) {
            return;
        }
        String valueOf = String.valueOf(this.f224515d);
        VideoReport.addToDetectionWhitelist(this.mActivity);
        VideoReport.setPageId(rootView, "pg_qqrobot_share");
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE");
        hashMap.put("qq_robot_channel_id", u());
        hashMap.put("qq_robot_robot_id", valueOf);
        VideoReport.setPageParams(rootView, new PageParams(hashMap));
        TextView btnLeft = qQCustomDialog.getBtnLeft();
        TextView btnight = qQCustomDialog.getBtnight();
        if (btnLeft != null) {
            VideoReport.setElementId(btnLeft, "em_sgrp_qqrobot_share_cancel");
            VideoReport.setElementClickPolicy(btnLeft, ClickPolicy.REPORT_ALL);
            VideoReport.setElementExposePolicy(btnLeft, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementEndExposePolicy(btnLeft, EndExposurePolicy.REPORT_ALL);
        }
        if (btnight != null) {
            VideoReport.setElementId(btnight, "em_sgrp_qqrobot_share_confirm");
            VideoReport.setElementClickPolicy(btnight, ClickPolicy.REPORT_ALL);
            VideoReport.setElementExposePolicy(btnight, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementEndExposePolicy(btnight, EndExposurePolicy.REPORT_ALL);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public View buildNewVersionContentView() {
        if (!this.mFromSharePanelPreviewAndSend && !useBottomSheetPreview()) {
            return super.buildNewVersionContentView();
        }
        return ((IShareArkViewApi) QRoute.api(IShareArkViewApi.class)).createShareArkView(this.mActivity, this.mExtraData);
    }

    @Override // com.tencent.mobileqq.forward.al
    public SharePublishGuildFeedParam c() {
        return jo1.b.f410734a.a(this.mIntent);
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean isSupportMultipleForward() {
        return true;
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean realForwardTo() {
        if (isMultiTarget2Send()) {
            List<ResultRecord> multiTargetWithoutDataLine = getMultiTargetWithoutDataLine();
            if (multiTargetWithoutDataLine == null) {
                return false;
            }
            this.f224518h = 0;
            this.f224519i = 0;
            this.f224517f = multiTargetWithoutDataLine.size();
            Iterator<ResultRecord> it = multiTargetWithoutDataLine.iterator();
            while (it.hasNext()) {
                s(t(it.next()));
            }
        } else {
            this.f224518h = 0;
            this.f224519i = 0;
            this.f224517f = 1;
            s(this.mExtraData);
        }
        return super.realForwardTo();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean sendMessage2TargetOnConfirm(String str, String str2, int i3) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean useNewVersionDialog() {
        if (this.mFromSharePanelPreviewAndSend || useBottomSheetPreview()) {
            return true;
        }
        return super.useNewVersionDialog();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class a extends ProtoUtils.TroopProtocolObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Bundle f224520d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f224521e;

        a(Bundle bundle, String str) {
            this.f224520d = bundle;
            this.f224521e = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d() {
            ForwardGuildRobotOption.this.f224519i++;
            ForwardGuildRobotOption.this.w();
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public boolean onError(int i3, String str, Bundle bundle) {
            if (QLog.isColorLevel()) {
                QLog.e("ForwardGuildRobotOption", 2, "fail to share, params: " + this.f224520d + ", error code: " + i3 + ", error message: ", str);
            }
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.guild.forward.a
                @Override // java.lang.Runnable
                public final void run() {
                    ForwardGuildRobotOption.a.this.d();
                }
            });
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(boolean z16) {
            if (z16) {
                ForwardGuildRobotOption.this.f224518h++;
            } else {
                ForwardGuildRobotOption.this.f224519i++;
            }
            ForwardGuildRobotOption.this.w();
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0025  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x003b  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x006b  */
        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onResult(int i3, byte[] bArr, Bundle bundle) {
            String str;
            final boolean z16;
            if (i3 == 0) {
                Object[] b06 = ForwardUtils.b0(bArr);
                str = "";
                if (b06 != null) {
                    if (b06.length > 0) {
                        Object obj = b06[0];
                        if ((obj instanceof Integer) && ((Integer) obj).intValue() == 0) {
                            z16 = true;
                            if (b06.length > 2) {
                                Object obj2 = b06[2];
                                if (obj2 instanceof String) {
                                    str = (String) obj2;
                                }
                            }
                            if (!z16) {
                                if (QLog.isColorLevel()) {
                                    QLog.e("ForwardGuildRobotOption", 2, "fail to share, params: " + this.f224520d + ", code: " + i3 + ", message: ", str);
                                }
                            } else if (!TextUtils.isEmpty(this.f224521e)) {
                                this.f224520d.putString(AppConstants.Key.SHARE_RES_COMMENT_MESSAGE, this.f224521e);
                                SessionInfo n06 = ForwardUtils.n0(new Intent().putExtras(this.f224520d));
                                String string = this.f224520d.getString("guild_id");
                                if (n06.f179555d == 10014 && !TextUtils.isEmpty(string)) {
                                    n06.f179559f = string;
                                } else {
                                    QLog.i("ForwardGuildRobotOption", 1, "[sendCommentMsgToGuild] Fail to get guildId");
                                }
                                jo1.b.d(n06, this.f224521e);
                            }
                            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.guild.forward.b
                                @Override // java.lang.Runnable
                                public final void run() {
                                    ForwardGuildRobotOption.a.this.e(z16);
                                }
                            });
                            QLog.d("ForwardGuildRobotOption", 2, "share result, code: " + i3 + ", message: " + str);
                        }
                    }
                    z16 = false;
                    if (b06.length > 2) {
                    }
                    if (!z16) {
                    }
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.guild.forward.b
                        @Override // java.lang.Runnable
                        public final void run() {
                            ForwardGuildRobotOption.a.this.e(z16);
                        }
                    });
                    QLog.d("ForwardGuildRobotOption", 2, "share result, code: " + i3 + ", message: " + str);
                }
            } else {
                str = "sso error";
            }
            z16 = false;
            if (!z16) {
            }
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.guild.forward.b
                @Override // java.lang.Runnable
                public final void run() {
                    ForwardGuildRobotOption.a.this.e(z16);
                }
            });
            QLog.d("ForwardGuildRobotOption", 2, "share result, code: " + i3 + ", message: " + str);
        }
    }

    private String v(String str) {
        return str == null ? "" : str;
    }
}
