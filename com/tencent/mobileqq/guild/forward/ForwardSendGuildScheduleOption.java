package com.tencent.mobileqq.guild.forward;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.ak;
import com.tencent.mobileqq.forward.al;
import com.tencent.mobileqq.forward.e;
import com.tencent.mobileqq.guild.api.IGuildHandlerNameApi;
import com.tencent.mobileqq.guild.data.ark.AttaIdReportData;
import com.tencent.mobileqq.guild.feed.api.SharePublishGuildFeedParam;
import com.tencent.mobileqq.guild.feed.api.g;
import com.tencent.mobileqq.qqguildsdk.data.cu;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQCustomArkDialogUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class ForwardSendGuildScheduleOption extends ForwardBaseOption implements al {

    /* renamed from: d, reason: collision with root package name */
    private long f224523d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f224524e;

    public ForwardSendGuildScheduleOption(Intent intent) {
        super(intent);
        this.f224524e = false;
    }

    private Bundle l(ResultRecord resultRecord) {
        Bundle bundle = new Bundle();
        int uinType = resultRecord.getUinType();
        long j3 = this.mExtraData.getLong(AppConstants.Key.GUILD_SOURCE_ID, 0L);
        long j16 = this.mExtraData.getLong(AppConstants.Key.GUILD_SOURCE_CHANNEL_ID, 0L);
        long j17 = this.mExtraData.getLong(AppConstants.Key.GUILD_SCHEDULE_ID, 0L);
        bundle.putInt("uintype", uinType);
        bundle.putLong(AppConstants.Key.GUILD_SOURCE_ID, j3);
        bundle.putLong(AppConstants.Key.GUILD_SOURCE_CHANNEL_ID, j16);
        bundle.putLong(AppConstants.Key.GUILD_SCHEDULE_ID, j17);
        bundle.putString(QQCustomArkDialogUtil.META_DATA, this.mExtraData.getString(QQCustomArkDialogUtil.META_DATA, ""));
        bundle.putString("uin", resultRecord.uin);
        if (QLog.isColorLevel()) {
            QLog.d("Guild.share.ForwardSendGuildScheduleOption", 4, "target_type: " + uinType);
            QLog.d("Guild.share.ForwardSendGuildScheduleOption", 4, "sourceChannelId: " + j16);
            QLog.d("Guild.share.ForwardSendGuildScheduleOption", 4, "sourceGuildId: " + j3);
        }
        if (uinType == 10014) {
            bundle.putString("guild_id", resultRecord.guildId);
        }
        if (this.mIntent.hasExtra("extra_key_atta_report_id")) {
            bundle.putParcelable("extra_key_atta_report_id", this.mIntent.getParcelableExtra("extra_key_atta_report_id"));
        }
        return bundle;
    }

    private String m(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject(QQPermissionConstants.Permission.CALENDAR_GROUP);
            if (jSONObject.length() == 0) {
                if (QLog.isColorLevel()) {
                    QLog.d("Guild.share.ForwardSendGuildScheduleOption", 2, " your metaData has no contact! ");
                }
                return "";
            }
            try {
                try {
                    String queryParameter = Uri.parse(jSONObject.getString(WadlProxyConsts.KEY_JUMP_URL)).getQueryParameter(str2);
                    return queryParameter == null ? "" : queryParameter;
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("Guild.share.ForwardSendGuildScheduleOption", 2, e16, new Object[0]);
                    }
                    e16.printStackTrace();
                    return "";
                }
            } catch (Exception e17) {
                if (QLog.isColorLevel()) {
                    QLog.d("Guild.share.ForwardSendGuildScheduleOption", 2, e17, new Object[0]);
                }
                e17.printStackTrace();
                return "";
            }
        } catch (Exception e18) {
            QLog.d("Guild.share.ForwardSendGuildScheduleOption", 2, e18, new Object[0]);
            e18.printStackTrace();
            return "";
        }
    }

    @Override // com.tencent.mobileqq.forward.al
    public /* synthetic */ void a(Activity activity, String str, int i3, g gVar) {
        ak.a(this, activity, str, i3, gVar);
    }

    @Override // com.tencent.mobileqq.forward.al
    public /* synthetic */ boolean b() {
        return ak.b(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void buildForwardAbility() {
        if (QLog.isColorLevel()) {
            QLog.i("Guild.share.ForwardSendGuildScheduleOption", 1, "buildForwardAbility() called");
        }
        if (allowDiscussAbility()) {
            this.mForwardAbilities.add(e.Q3);
        }
        if (allowTroopAbility()) {
            this.mForwardAbilities.add(e.P3);
        }
        if (allowFriendAbility()) {
            this.mForwardAbilities.add(e.O3);
        }
    }

    @Override // com.tencent.mobileqq.forward.al
    public SharePublishGuildFeedParam c() {
        String string = this.mExtraData.getString("detail_url", "");
        String string2 = this.mExtraData.getString(AppConstants.Key.SHARE_REQ_IMAGE_REMOTE_URL, "");
        if (TextUtils.isEmpty(string2)) {
            string2 = this.mExtraData.getString("image_url", "");
        }
        String string3 = this.mExtraData.getString("title", "");
        String string4 = this.mExtraData.getString("desc", "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return new SharePublishGuildFeedParam.LinkTypeParam(string, string2, string3, string4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public int getEditTextType() {
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public List<ResultRecord> getMultiTargetWithoutDataLine() {
        if (this.f224524e) {
            return this.mIntent.getParcelableArrayListExtra("selected_target_list");
        }
        return super.getMultiTargetWithoutDataLine();
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void initContext(QQAppInterface qQAppInterface, Activity activity) {
        super.initContext(qQAppInterface, activity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean isMultiTarget2Send() {
        if (this.f224524e) {
            return true;
        }
        return super.isMultiTarget2Send();
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean isSupportMultipleForward() {
        if (!QLog.isColorLevel()) {
            return true;
        }
        QLog.i("Guild.share.ForwardSendGuildScheduleOption", 4, "isSupportMultipleForward() called\uff01 ");
        return true;
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean preloadData() {
        this.f224523d = this.mExtraData.getLong(AppConstants.Key.GUILD_SCHEDULE_ID, 0L);
        Iterator<String> it = this.mExtraData.keySet().iterator();
        while (it.hasNext()) {
            this.mExtraData.get(it.next());
        }
        return super.preloadData();
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean realForwardTo() {
        this.f224524e = this.mIntent.getIntExtra(PictureConst.KEY_REQ_FOR_RECENT_OR_VIDEO, -1) == 3;
        this.mIntent.putExtra("is_need_show_toast", false);
        String b16 = jo1.b.b(this.mExtraData, this.mConfirmDialog);
        if (isMultiTarget2Send()) {
            Iterator<ResultRecord> it = getMultiTargetWithoutDataLine().iterator();
            while (it.hasNext()) {
                n(l(it.next()), b16);
            }
        } else {
            n(this.mExtraData, b16);
        }
        if (this.f224524e) {
            return super.realForwardTo(true);
        }
        return super.realForwardTo();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean sendMessage2TargetOnConfirm(String str, String str2, int i3) {
        return true;
    }

    private void o(ArrayList<Long> arrayList, cu cuVar, long j3, String str, String str2, String str3, AttaIdReportData attaIdReportData) {
        ((com.tencent.mobileqq.guild.message.schedule.a) this.app.getBusinessHandler(((IGuildHandlerNameApi) QRoute.api(IGuildHandlerNameApi.class)).getSendGuildScheduleMsgHandlerName())).s(arrayList, new ArrayList<>(), new ArrayList<>(), cuVar, j3, 1, str, str2, str3, attaIdReportData);
    }

    private void p(ArrayList<cu> arrayList, cu cuVar, long j3, String str, String str2, String str3) {
        ((com.tencent.mobileqq.guild.message.schedule.a) this.app.getBusinessHandler(((IGuildHandlerNameApi) QRoute.api(IGuildHandlerNameApi.class)).getSendGuildScheduleMsgHandlerName())).s(new ArrayList<>(), new ArrayList<>(), arrayList, cuVar, j3, 3, str, str2, str3, null);
    }

    private void q(ArrayList<Long> arrayList, cu cuVar, long j3, String str, String str2, String str3, AttaIdReportData attaIdReportData) {
        ((com.tencent.mobileqq.guild.message.schedule.a) this.app.getBusinessHandler(((IGuildHandlerNameApi) QRoute.api(IGuildHandlerNameApi.class)).getSendGuildScheduleMsgHandlerName())).s(new ArrayList<>(), arrayList, new ArrayList<>(), cuVar, j3, 2, str, str2, str3, attaIdReportData);
    }

    private boolean n(Bundle bundle, String str) {
        cu c16 = new cu.a().e(bundle.getLong(AppConstants.Key.GUILD_SOURCE_ID, 0L)).d(bundle.getLong(AppConstants.Key.GUILD_SOURCE_CHANNEL_ID, 0L)).c();
        long j3 = bundle.getLong(AppConstants.Key.GUILD_SCHEDULE_ID, 0L);
        String string = bundle.getString("uin", "");
        AttaIdReportData attaIdReportData = this.mIntent.hasExtra("extra_key_atta_report_id") ? (AttaIdReportData) this.mIntent.getParcelableExtra("extra_key_atta_report_id") : null;
        if (TextUtils.isEmpty(string)) {
            if (QLog.isColorLevel()) {
                QLog.i("Guild.share.ForwardSendGuildScheduleOption", 2, " try to get target_uin failed! ");
            }
            return false;
        }
        String string2 = bundle.getString(QQCustomArkDialogUtil.META_DATA, "");
        if (TextUtils.isEmpty(string2)) {
            if (QLog.isColorLevel()) {
                QLog.d("Guild.share.ForwardSendGuildScheduleOption", 2, " your metaData is empty! ");
            }
            return false;
        }
        String m3 = m(string2, "from");
        String m16 = m(string2, "biz");
        int i3 = bundle.getInt("uintype", -1);
        SessionInfo sessionInfo = new SessionInfo();
        sessionInfo.f179555d = i3;
        sessionInfo.f179557e = string;
        sessionInfo.f179559f = string;
        if (i3 == 0) {
            ArrayList<Long> arrayList = new ArrayList<>();
            arrayList.add(Long.valueOf(Long.parseLong(string)));
            o(arrayList, c16, j3, "", m3, m16, attaIdReportData);
        } else if (i3 == 1) {
            ArrayList<Long> arrayList2 = new ArrayList<>();
            arrayList2.add(Long.valueOf(Long.parseLong(string)));
            q(arrayList2, c16, j3, "", m3, m16, attaIdReportData);
        } else {
            if (i3 != 10014) {
                if (QLog.isColorLevel()) {
                    QLog.i("Guild.share.ForwardSendGuildScheduleOption", 2, "targetType is not: toFriends or toTroop or toGuild, targetType:  " + i3);
                }
                return false;
            }
            String string3 = bundle.getString("guild_id", "");
            sessionInfo.f179559f = string3;
            cu c17 = new cu.a().e(Long.parseLong(string3)).d(Long.parseLong(string)).c();
            ArrayList<cu> arrayList3 = new ArrayList<>();
            arrayList3.add(c17);
            p(arrayList3, c16, j3, "", m3, m16);
        }
        jo1.b.d(sessionInfo, str);
        return true;
    }
}
