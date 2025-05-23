package com.tencent.mobileqq.guild.forward;

import android.app.Activity;
import android.content.Intent;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.ak;
import com.tencent.mobileqq.forward.al;
import com.tencent.mobileqq.forward.e;
import com.tencent.mobileqq.guild.api.IGuildHandlerNameApi;
import com.tencent.mobileqq.guild.data.ark.AttaIdReportData;
import com.tencent.mobileqq.guild.feed.api.SharePublishGuildFeedParam;
import com.tencent.mobileqq.guild.feed.api.g;
import com.tencent.mobileqq.guild.util.GuildForwardUtilKt;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.qphone.base.util.QLog;
import eu1.a;
import java.util.List;

/* compiled from: P */
/* loaded from: classes33.dex */
public class ForwardGuildCommentArgMsgOption extends ForwardBaseOption implements al {

    /* renamed from: d, reason: collision with root package name */
    private boolean f224513d;

    public ForwardGuildCommentArgMsgOption(Intent intent) {
        super(intent);
        this.f224513d = false;
    }

    private a.C10265a l() {
        a.C10265a c10265a = new a.C10265a();
        if (isMultiTarget2Send()) {
            for (ResultRecord resultRecord : getMultiTargetWithoutDataLine()) {
                int i3 = resultRecord.uinType;
                if (i3 == 0) {
                    c10265a.f397134b.add(resultRecord.uin);
                } else if (i3 == 1) {
                    c10265a.f397135c.add(resultRecord.uin);
                } else if (i3 == 10014) {
                    c10265a.f397133a.add(new a.b(resultRecord.guildId, resultRecord.uin));
                }
            }
        } else {
            int i16 = this.mExtraData.getInt("uintype", -1);
            String string = this.mExtraData.getString("uin", "");
            if (i16 == 0) {
                c10265a.f397134b.add(string);
            } else if (i16 == 1) {
                c10265a.f397135c.add(string);
            } else if (i16 == 10014) {
                c10265a.f397133a.add(new a.b(this.mExtraData.getString("guild_id", ""), string));
            }
        }
        return c10265a;
    }

    private void m(a.C10265a c10265a) {
        String b16 = jo1.b.b(this.mExtraData, this.mConfirmDialog);
        for (String str : c10265a.f397134b) {
            jo1.b.c(0, str, str, b16);
        }
        for (String str2 : c10265a.f397135c) {
            jo1.b.c(1, str2, str2, b16);
        }
        for (a.b bVar : c10265a.f397133a) {
            jo1.b.c(10014, bVar.f397136a, bVar.f397137b, b16);
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
            QLog.i("Guild.share.CommonArkMsgOption.0xffa", 4, "buildForwardAbility() called");
        }
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

    @Override // com.tencent.mobileqq.forward.al
    public SharePublishGuildFeedParam c() {
        return GuildForwardUtilKt.h(this.mExtraData);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public int getEditTextType() {
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public List<ResultRecord> getMultiTargetWithoutDataLine() {
        if (this.f224513d) {
            return this.mIntent.getParcelableArrayListExtra("selected_target_list");
        }
        return super.getMultiTargetWithoutDataLine();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean isMultiTarget2Send() {
        if (this.f224513d) {
            return true;
        }
        return super.isMultiTarget2Send();
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean isSupportMultipleForward() {
        if (!QLog.isColorLevel()) {
            return true;
        }
        QLog.i("Guild.share.CommonArkMsgOption.0xffa", 4, "isSupportMultipleForward() called\uff01 ");
        return true;
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean realForwardTo() {
        this.f224513d = this.mIntent.getIntExtra(PictureConst.KEY_REQ_FOR_RECENT_OR_VIDEO, -1) == 3;
        this.mIntent.putExtra("is_need_show_toast", false);
        int intExtra = this.mIntent.getIntExtra(AppConstants.Key.GUILD_COMMEN_ARG_MSG_SHARE_TYPE, 0);
        String stringExtra = this.mIntent.getStringExtra("forward_ark_app_meta");
        eu1.a aVar = (eu1.a) this.app.getBusinessHandler(((IGuildHandlerNameApi) QRoute.api(IGuildHandlerNameApi.class)).getGuildCommentArgMsgHandlerName());
        String stringExtra2 = this.mIntent.getStringExtra(AppConstants.Key.GUILD_SOURCE_ID);
        String stringExtra3 = this.mIntent.getStringExtra(AppConstants.Key.GUILD_SOURCE_CHANNEL_ID);
        AttaIdReportData attaIdReportData = this.mIntent.hasExtra("extra_key_atta_report_id") ? (AttaIdReportData) this.mIntent.getParcelableExtra("extra_key_atta_report_id") : null;
        a.C10265a l3 = l();
        aVar.o1(l3, intExtra, stringExtra, "", new a.b(stringExtra2, stringExtra3), attaIdReportData);
        m(l3);
        if (this.f224513d) {
            return super.realForwardTo(true);
        }
        return super.realForwardTo();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean sendMessage2TargetOnConfirm(String str, String str2, int i3) {
        return true;
    }
}
