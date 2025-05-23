package com.tencent.mobileqq.guild.forward;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.ak;
import com.tencent.mobileqq.forward.al;
import com.tencent.mobileqq.forward.e;
import com.tencent.mobileqq.guild.api.IGuildHandlerNameApi;
import com.tencent.mobileqq.guild.feed.api.SharePublishGuildFeedParam;
import com.tencent.mobileqq.guild.feed.api.g;
import com.tencent.mobileqq.guild.message.serversendarkmsg.c;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQCustomArkDialogUtil;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes33.dex */
public class ForwardGuildInvitationArkMsgOption extends ForwardBaseOption implements al {

    /* renamed from: d, reason: collision with root package name */
    private boolean f224514d;

    public ForwardGuildInvitationArkMsgOption(Intent intent) {
        super(intent);
        this.f224514d = false;
    }

    private Bundle l(ResultRecord resultRecord) {
        Bundle bundle = new Bundle();
        int uinType = resultRecord.getUinType();
        long j3 = this.mExtraData.getLong(AppConstants.Key.GUILD_SOURCE_ID, 0L);
        long j16 = this.mExtraData.getLong(AppConstants.Key.GUILD_SOURCE_CHANNEL_ID, 0L);
        String string = this.mExtraData.getString(AppConstants.Key.GUILD_INVITATION_YOLO_GAME_ID, "");
        int i3 = this.mExtraData.getInt("businessType");
        bundle.putInt("uintype", uinType);
        bundle.putLong(AppConstants.Key.GUILD_SOURCE_ID, j3);
        bundle.putLong(AppConstants.Key.GUILD_SOURCE_CHANNEL_ID, j16);
        bundle.putString(AppConstants.Key.GUILD_INVITATION_YOLO_GAME_ID, string);
        bundle.putInt("businessType", i3);
        if (!TextUtils.isEmpty(string)) {
            bundle.putString(AppConstants.Key.GUILD_INVITATION_YOLO_TEAM_ID, this.mExtraData.getString(AppConstants.Key.GUILD_INVITATION_YOLO_TEAM_ID, ""));
            bundle.putString(AppConstants.Key.GUILD_INVITATION_YOLO_TEAM_GUILD_ID, this.mExtraData.getString(AppConstants.Key.GUILD_INVITATION_YOLO_TEAM_GUILD_ID, ""));
            bundle.putString(AppConstants.Key.GUILD_INVITATION_YOLO_TEAM_CHANNEL_ID, this.mExtraData.getString(AppConstants.Key.GUILD_INVITATION_YOLO_TEAM_CHANNEL_ID, ""));
            bundle.putString(AppConstants.Key.GUILD_INVITATION_YOLO_JUMP_ACTION, this.mExtraData.getString(AppConstants.Key.GUILD_INVITATION_YOLO_JUMP_ACTION, ""));
            bundle.putInt(AppConstants.Key.GUILD_INVITATION_YOLO_GAME_MODE_ID, this.mExtraData.getInt(AppConstants.Key.GUILD_INVITATION_YOLO_GAME_MODE_ID));
        }
        bundle.putString(QQCustomArkDialogUtil.META_DATA, this.mExtraData.getString(QQCustomArkDialogUtil.META_DATA, ""));
        bundle.putString("uin", resultRecord.uin);
        if (QLog.isColorLevel()) {
            QLog.d("Guild.share.GuildInviteOption.0x101b", 2, "target_type: " + uinType + " sourceChannelId: " + j16 + " sourceGuildId: " + j3 + " gameId:" + string);
        }
        if (uinType == 10014) {
            bundle.putString("guild_id", resultRecord.guildId);
        }
        String string2 = this.mExtraData.getString(AppConstants.Key.GUILD_MEDIA_ARK_CUSTOM_SESSION_ID, "");
        String string3 = this.mExtraData.getString(AppConstants.Key.GUILD_MEDIA_ARK_CUSTOM_TITLE, "");
        String string4 = this.mExtraData.getString(AppConstants.Key.GUILD_MEDIA_ARK_CUSTOM_FILE_ID, "");
        bundle.putString(AppConstants.Key.GUILD_MEDIA_ARK_CUSTOM_SESSION_ID, string2);
        bundle.putString(AppConstants.Key.GUILD_MEDIA_ARK_CUSTOM_TITLE, string3);
        bundle.putString(AppConstants.Key.GUILD_MEDIA_ARK_CUSTOM_FILE_ID, string4);
        if (this.mIntent.hasExtra("extra_key_atta_report_id")) {
            bundle.putParcelable("extra_key_atta_report_id", this.mIntent.getParcelableExtra("extra_key_atta_report_id"));
        }
        return bundle;
    }

    private void n(Bundle bundle, String str) {
        SessionInfo sessionInfo = new SessionInfo();
        sessionInfo.f179555d = bundle.getInt("uintype");
        sessionInfo.f179557e = bundle.getString("uin", "");
        if (sessionInfo.f179555d == 10014) {
            sessionInfo.f179559f = bundle.getString("guild_id", "");
        }
        jo1.b.d(sessionInfo, str);
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
            QLog.i("Guild.share.GuildInviteOption.0x101b", 4, "buildForwardAbility() called");
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
        return jo1.b.f410734a.a(this.mIntent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public int getEditTextType() {
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public List<ResultRecord> getMultiTargetWithoutDataLine() {
        if (this.f224514d) {
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
        if (this.f224514d) {
            return true;
        }
        return super.isMultiTarget2Send();
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean isSupportMultipleForward() {
        if (!QLog.isColorLevel()) {
            return true;
        }
        QLog.i("Guild.share.GuildInviteOption.0x101b", 4, "isSupportMultipleForward() called\uff01 ");
        return true;
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean realForwardTo() {
        this.f224514d = this.mIntent.getIntExtra(PictureConst.KEY_REQ_FOR_RECENT_OR_VIDEO, -1) == 3;
        this.mIntent.putExtra("is_need_show_toast", false);
        long currentTimeMillis = System.currentTimeMillis();
        String b16 = jo1.b.b(this.mExtraData, this.mConfirmDialog);
        if (isMultiTarget2Send()) {
            List<ResultRecord> multiTargetWithoutDataLine = getMultiTargetWithoutDataLine();
            Iterator<ResultRecord> it = multiTargetWithoutDataLine.iterator();
            while (it.hasNext()) {
                m(l(it.next()), currentTimeMillis, multiTargetWithoutDataLine.size(), b16);
            }
        } else {
            m(this.mExtraData, currentTimeMillis, 1, b16);
        }
        if (this.f224514d) {
            return super.realForwardTo(true);
        }
        return super.realForwardTo();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean sendMessage2TargetOnConfirm(String str, String str2, int i3) {
        return true;
    }

    private void m(Bundle bundle, long j3, int i3, String str) {
        if (bundle == null) {
            if (QLog.isColorLevel()) {
                QLog.d("Guild.share.GuildInviteOption.0x101b", 4, "Bundle is null when sendArkMsg(Bundle bundle) is called");
            }
        } else {
            ((c) this.app.getBusinessHandler(((IGuildHandlerNameApi) QRoute.api(IGuildHandlerNameApi.class)).getServerSendArkMsgHandlerName())).v1(bundle, "", j3, i3);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            n(bundle, str);
        }
    }
}
