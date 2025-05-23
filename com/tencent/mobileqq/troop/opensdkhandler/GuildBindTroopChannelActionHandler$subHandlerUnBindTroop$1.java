package com.tencent.mobileqq.troop.opensdkhandler;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.open.model.AppInfo;
import com.tencent.protofile.game_bind_troop.GuildGroupSvrPB$QueryGuildGroupInfoRsp;
import com.tencent.util.QQToastUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import mqq.app.Foreground;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\n\u00a2\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "troopUin", "", "isMember", "", "resp", "Lcom/tencent/protofile/game_bind_troop/GuildGroupSvrPB$QueryGuildGroupInfoRsp;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public final class GuildBindTroopChannelActionHandler$subHandlerUnBindTroop$1 extends Lambda implements Function3<Long, Boolean, GuildGroupSvrPB$QueryGuildGroupInfoRsp, Unit> {
    final /* synthetic */ AppInfo $appInfo;
    final /* synthetic */ String $extraData;
    final /* synthetic */ String $guildId;
    final /* synthetic */ zp3.d $helper;
    final /* synthetic */ GuildBindTroopChannelActionHandler this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildBindTroopChannelActionHandler$subHandlerUnBindTroop$1(zp3.d dVar, AppInfo appInfo, String str, GuildBindTroopChannelActionHandler guildBindTroopChannelActionHandler, String str2) {
        super(3);
        this.$helper = dVar;
        this.$appInfo = appInfo;
        this.$extraData = str;
        this.this$0 = guildBindTroopChannelActionHandler;
        this.$guildId = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(zp3.d helper, AppInfo appInfo, String guildId) {
        Intrinsics.checkNotNullParameter(helper, "$helper");
        Intrinsics.checkNotNullParameter(appInfo, "$appInfo");
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        d dVar = d.f298075a;
        Activity topActivity = Foreground.getTopActivity();
        String appId = helper.getAppId();
        String e16 = appInfo.e();
        Intrinsics.checkNotNullExpressionValue(e16, "appInfo.name");
        dVar.s(topActivity, appId, e16, guildId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(zp3.d helper, AppInfo appInfo, String guildId) {
        Intrinsics.checkNotNullParameter(helper, "$helper");
        Intrinsics.checkNotNullParameter(appInfo, "$appInfo");
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        d dVar = d.f298075a;
        Activity topActivity = Foreground.getTopActivity();
        String appId = helper.getAppId();
        String e16 = appInfo.e();
        Intrinsics.checkNotNullExpressionValue(e16, "appInfo.name");
        dVar.s(topActivity, appId, e16, guildId);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(Long l3, Boolean bool, GuildGroupSvrPB$QueryGuildGroupInfoRsp guildGroupSvrPB$QueryGuildGroupInfoRsp) {
        invoke(l3.longValue(), bool.booleanValue(), guildGroupSvrPB$QueryGuildGroupInfoRsp);
        return Unit.INSTANCE;
    }

    public final void invoke(long j3, boolean z16, @Nullable GuildGroupSvrPB$QueryGuildGroupInfoRsp guildGroupSvrPB$QueryGuildGroupInfoRsp) {
        PBBoolField pBBoolField;
        boolean z17 = false;
        if (guildGroupSvrPB$QueryGuildGroupInfoRsp != null && (pBBoolField = guildGroupSvrPB$QueryGuildGroupInfoRsp.dissolved) != null && pBBoolField.get()) {
            z17 = true;
        }
        if (z17) {
            d.f298075a.k().set(GuildBindGroupDialogState.NEED_SHOW.ordinal());
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final zp3.d dVar = this.$helper;
            final AppInfo appInfo = this.$appInfo;
            final String str = this.$guildId;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.troop.opensdkhandler.h
                @Override // java.lang.Runnable
                public final void run() {
                    GuildBindTroopChannelActionHandler$subHandlerUnBindTroop$1.c(zp3.d.this, appInfo, str);
                }
            });
            return;
        }
        if (z16) {
            d dVar2 = d.f298075a;
            dVar2.k().set(GuildBindGroupDialogState.NEED_SHOW.ordinal());
            dVar2.l(String.valueOf(j3), dVar2.o(this.$helper, this.$appInfo, this.$extraData));
            Handler uIHandlerV22 = ThreadManagerV2.getUIHandlerV2();
            final zp3.d dVar3 = this.$helper;
            final AppInfo appInfo2 = this.$appInfo;
            final String str2 = this.$guildId;
            uIHandlerV22.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.troop.opensdkhandler.i
                @Override // java.lang.Runnable
                public final void run() {
                    GuildBindTroopChannelActionHandler$subHandlerUnBindTroop$1.d(zp3.d.this, appInfo2, str2);
                }
            }, 800L);
        } else {
            GuildBindGroupStateCode guildBindGroupStateCode = GuildBindGroupStateCode.USER_IS_NOT_GROUP_MEMBER;
            QQToastUtil.showQQToastInUiThread(1, guildBindGroupStateCode.getMsg());
            this.this$0.g(this.$helper, guildBindGroupStateCode.getCode(), guildBindGroupStateCode.getMsg());
        }
        GuildBindTroopChannelActionHandler guildBindTroopChannelActionHandler = this.this$0;
        Context context = this.$helper.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "helper.context");
        guildBindTroopChannelActionHandler.h(context);
    }
}
