package com.tencent.mobileqq.troop.opensdkhandler;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.troop.api.ITroopTrpcHandlerService;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.troop.api.TroopTrpcRemoteResponse;
import com.tencent.mobileqq.troop.utils.aq;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.open.model.AppInfo;
import com.tencent.protofile.game_bind_troop.GuildGroupSvrPB$QueryGuildGroupInfoReq;
import com.tencent.protofile.game_bind_troop.GuildGroupSvrPB$QueryGuildGroupInfoRsp;
import com.tencent.protofile.game_bind_troop.GuildGroupSvrPB$UnbindGuildGroupReq;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.Foreground;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b>\u0010?J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\n\u001a\u00020\tJ?\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042'\u0010\u0011\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00060\u000bj\u0002`\u0010J,\u0010\u0016\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0015\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0016\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018J*\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001e\u001a\u00020\u001dJ*\u0010\"\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u0004J\u0006\u0010#\u001a\u00020\u0006J\u001e\u0010)\u001a\u00020\u00182\u0006\u0010%\u001a\u00020$2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u0004J\u000e\u0010+\u001a\u00020\u00062\u0006\u0010*\u001a\u00020$J\u000e\u0010-\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u0018J\u001c\u0010.\u001a\u0004\u0018\u00010\u00182\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0010\u0010/\u001a\u0004\u0018\u00010\u00042\u0006\u0010(\u001a\u00020\u0004J\b\u00100\u001a\u0004\u0018\u00010\u0018J\u000e\u00101\u001a\u00020\u00062\u0006\u0010*\u001a\u00020$R\u0018\u0010*\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0018\u00106\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\"\u0010=\u001a\u0002078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<\u00a8\u0006@"}, d2 = {"Lcom/tencent/mobileqq/troop/opensdkhandler/d;", "", "", "appId", "", "guildId", "", "v", "(Ljava/lang/Integer;Ljava/lang/String;)V", "", DomainData.DOMAIN_NAME, "Lkotlin/Function1;", "Lcom/tencent/protofile/game_bind_troop/GuildGroupSvrPB$QueryGuildGroupInfoRsp;", "Lkotlin/ParameterName;", "name", "resp", "Lcom/tencent/mobileqq/troop/opensdkhandler/QueryGuildGroupCallback;", "callback", "g", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "appName", ReportConstant.COSTREPORT_PREFIX, "troopUin", "Lorg/json/JSONObject;", "packedExtraData", "l", "authSig", "joinTroopIntro", "Landroid/content/Context;", "context", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "rstCode", "rstMsg", "f", "p", "Lzp3/d;", "handler", "Lcom/tencent/open/model/AppInfo;", "appInfo", WadlProxyConsts.EXTRA_DATA, "o", "helper", "e", "extraDataJSON", "d", tl.h.F, "i", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "b", "Lzp3/d;", "c", "Lorg/json/JSONObject;", "cacheExtraDataForBindGroup", "Ljava/util/concurrent/atomic/AtomicInteger;", "Ljava/util/concurrent/atomic/AtomicInteger;", "k", "()Ljava/util/concurrent/atomic/AtomicInteger;", "setUnbindDialogState", "(Ljava/util/concurrent/atomic/AtomicInteger;)V", "unbindDialogState", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class d {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static zp3.d helper;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static JSONObject cacheExtraDataForBindGroup;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f298075a = new d();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static AtomicInteger unbindDialogState = new AtomicInteger(GuildBindGroupDialogState.UNKNOWN.ordinal());

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/troop/opensdkhandler/d$a", "Lcom/tencent/mobileqq/troop/api/f;", "Lcom/tencent/mobileqq/troop/api/TroopTrpcRemoteResponse;", "errorResponse", "", "a", "successResponse", "b", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class a implements com.tencent.mobileqq.troop.api.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<GuildGroupSvrPB$QueryGuildGroupInfoRsp, Unit> f298079a;

        /* JADX WARN: Multi-variable type inference failed */
        a(Function1<? super GuildGroupSvrPB$QueryGuildGroupInfoRsp, Unit> function1) {
            this.f298079a = function1;
        }

        @Override // com.tencent.mobileqq.troop.api.f
        public void a(@NotNull TroopTrpcRemoteResponse errorResponse) {
            Intrinsics.checkNotNullParameter(errorResponse, "errorResponse");
            this.f298079a.invoke(null);
            QLog.i("GuildBindGroupHelper", 1, "[getBindTroopByGuildId] onError, error = " + errorResponse);
        }

        @Override // com.tencent.mobileqq.troop.api.f
        public void b(@NotNull TroopTrpcRemoteResponse successResponse) {
            Intrinsics.checkNotNullParameter(successResponse, "successResponse");
            try {
                if (successResponse.data == null) {
                    this.f298079a.invoke(null);
                    QLog.i("GuildBindGroupHelper", 1, "[getBindTroopByGuildId] onSuccess, successResponse.data == null");
                } else {
                    GuildGroupSvrPB$QueryGuildGroupInfoRsp guildGroupSvrPB$QueryGuildGroupInfoRsp = new GuildGroupSvrPB$QueryGuildGroupInfoRsp();
                    guildGroupSvrPB$QueryGuildGroupInfoRsp.mergeFrom(successResponse.data);
                    this.f298079a.invoke(guildGroupSvrPB$QueryGuildGroupInfoRsp);
                }
            } catch (Exception e16) {
                QLog.e("GuildBindGroupHelper", 1, "[getBindTroopByGuildId]  onException = " + e16);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/troop/opensdkhandler/d$b", "Lcom/tencent/mobileqq/troop/api/f;", "Lcom/tencent/mobileqq/troop/api/TroopTrpcRemoteResponse;", "errorResponse", "", "a", "successResponse", "b", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b implements com.tencent.mobileqq.troop.api.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f298080a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f298081b;

        b(Activity activity, String str) {
            this.f298080a = activity;
            this.f298081b = str;
        }

        @Override // com.tencent.mobileqq.troop.api.f
        public void a(@NotNull TroopTrpcRemoteResponse errorResponse) {
            Intrinsics.checkNotNullParameter(errorResponse, "errorResponse");
            QQToast.makeText(this.f298080a, HardCodeUtil.qqStr(R.string.f146420u5), 0).show();
            d dVar = d.f298075a;
            String str = this.f298081b;
            GuildBindGroupStateCode guildBindGroupStateCode = GuildBindGroupStateCode.UNBIND_GROUP_FAIL;
            dVar.f("", str, guildBindGroupStateCode.getCode(), guildBindGroupStateCode.getMsg());
            QLog.i("GuildBindGroupHelper", 1, "[unbindGuildGroup] onError, error = " + errorResponse);
        }

        @Override // com.tencent.mobileqq.troop.api.f
        public void b(@NotNull TroopTrpcRemoteResponse successResponse) {
            Intrinsics.checkNotNullParameter(successResponse, "successResponse");
            try {
                QQToast.makeText(this.f298080a, HardCodeUtil.qqStr(R.string.f146430u6), 0).show();
                d dVar = d.f298075a;
                String str = this.f298081b;
                GuildBindGroupStateCode guildBindGroupStateCode = GuildBindGroupStateCode.UNBIND_GROUP_SUCCESS;
                dVar.f("", str, guildBindGroupStateCode.getCode(), guildBindGroupStateCode.getMsg());
                QLog.i("GuildBindGroupHelper", 1, "[unbindGuildGroup] onSuccess");
            } catch (Exception e16) {
                QLog.e("GuildBindGroupHelper", 1, "[unbindGuildGroup]  onException = " + e16);
            }
        }
    }

    d() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(zp3.d helper2, JumpActivity jumpActivity, QQCustomDialog mAccountConfirmDlg, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(helper2, "$helper");
        Intrinsics.checkNotNullParameter(mAccountConfirmDlg, "$mAccountConfirmDlg");
        if (i3 != 0) {
            if (i3 == 1) {
                Intent intent = new Intent();
                intent.putExtra("is_change_account", true);
                intent.putExtra("if_check_account_same", true);
                intent.putExtra("appid", helper2.getAppId());
                intent.putExtra("openid", helper2.getOpenId());
                intent.putExtra("key_action", "key_sdk_add_friend");
                intent.addFlags(268435456);
                intent.addFlags(67108864);
                RouteUtils.startActivity(jumpActivity, intent, RouterConstants.UI_ROUTER_LOGIN);
                f298075a.p();
                jumpActivity.finish();
                return;
            }
            return;
        }
        mAccountConfirmDlg.cancel();
        d dVar = f298075a;
        String appId = helper2.getAppId();
        GuildBindGroupStateCode guildBindGroupStateCode = GuildBindGroupStateCode.E_USER_NOT_SAME;
        dVar.f(appId, "", guildBindGroupStateCode.getCode(), guildBindGroupStateCode.getMsg());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(String str, String str2, DialogInterface dialogInterface, int i3) {
        Integer num;
        d dVar = f298075a;
        if (str != null) {
            num = StringsKt__StringNumberConversionsKt.toIntOrNull(str);
        } else {
            num = null;
        }
        dVar.v(num, str2);
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(String str, String str2, DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
        d dVar = f298075a;
        GuildBindGroupStateCode guildBindGroupStateCode = GuildBindGroupStateCode.UNBIND_GROUP_CANCELED;
        dVar.f(str, str2, guildBindGroupStateCode.getCode(), guildBindGroupStateCode.getMsg());
    }

    private final void v(Integer appId, String guildId) {
        if (appId != null && guildId != null) {
            b bVar = new b(Foreground.getTopActivity(), guildId);
            try {
                GuildGroupSvrPB$UnbindGuildGroupReq guildGroupSvrPB$UnbindGuildGroupReq = new GuildGroupSvrPB$UnbindGuildGroupReq();
                guildGroupSvrPB$UnbindGuildGroupReq.app_id.set(appId.intValue());
                guildGroupSvrPB$UnbindGuildGroupReq.guild_id.set(guildId);
                ((ITroopTrpcHandlerService) QRoute.api(ITroopTrpcHandlerService.class)).sendRequest("trpc.iqun.guild_group_svr.GuildGroupSvr", "/trpc.iqun.guild_group_svr.GuildGroupSvr/UnbindGuildGroup", guildGroupSvrPB$UnbindGuildGroupReq.toByteArray(), 1, null, bVar);
                return;
            } catch (Exception e16) {
                GuildBindGroupStateCode guildBindGroupStateCode = GuildBindGroupStateCode.ERROR_CODE;
                f("", guildId, guildBindGroupStateCode.getCode(), guildBindGroupStateCode.getMsg());
                QLog.i("GuildBindGroupHelper", 1, "[getBindTroopByGuildId] exception = " + e16);
                return;
            }
        }
        QLog.i("GuildBindGroupHelper", 1, "[unbindGuildGroup] appId = " + appId + ", guildId = " + guildId);
        GuildBindGroupStateCode guildBindGroupStateCode2 = GuildBindGroupStateCode.ERROR_CODE;
        f("", guildId, guildBindGroupStateCode2.getCode(), guildBindGroupStateCode2.getMsg());
    }

    public final void d(@NotNull JSONObject extraDataJSON) {
        Intrinsics.checkNotNullParameter(extraDataJSON, "extraDataJSON");
        cacheExtraDataForBindGroup = extraDataJSON;
        if (extraDataJSON != null) {
            extraDataJSON.put("dataCachedTimestamp", System.currentTimeMillis());
        }
    }

    public final void e(@NotNull zp3.d helper2) {
        Intrinsics.checkNotNullParameter(helper2, "helper");
        helper = helper2;
    }

    public final void f(@Nullable String appId, @Nullable String guildId, int rstCode, @NotNull String rstMsg) {
        Intrinsics.checkNotNullParameter(rstMsg, "rstMsg");
        QLog.i("GuildBindGroupHelper", 1, "[doCallbackForOut] helper = " + helper + ", appId = " + appId + ", guildId = " + guildId + ", rstCode = " + rstCode + ", rstMsg = " + rstMsg);
        zp3.d dVar = helper;
        if (dVar != null) {
            dVar.c(Foreground.getTopActivity(), rstCode, rstMsg);
            f298075a.p();
            if (dVar.getContext() instanceof JumpActivity) {
                Context context = dVar.getContext();
                Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.tencent.mobileqq.activity.JumpActivity");
                ((JumpActivity) context).finish();
            }
        }
    }

    public final void g(@NotNull String appId, @NotNull String guildId, @NotNull Function1<? super GuildGroupSvrPB$QueryGuildGroupInfoRsp, Unit> callback) {
        Integer intOrNull;
        int i3;
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        a aVar = new a(callback);
        try {
            GuildGroupSvrPB$QueryGuildGroupInfoReq guildGroupSvrPB$QueryGuildGroupInfoReq = new GuildGroupSvrPB$QueryGuildGroupInfoReq();
            guildGroupSvrPB$QueryGuildGroupInfoReq.guild_id.set(guildId);
            PBUInt32Field pBUInt32Field = guildGroupSvrPB$QueryGuildGroupInfoReq.app_id;
            intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(appId);
            if (intOrNull != null) {
                i3 = intOrNull.intValue();
            } else {
                i3 = 0;
            }
            pBUInt32Field.set(i3);
            ((ITroopTrpcHandlerService) QRoute.api(ITroopTrpcHandlerService.class)).sendRequest("trpc.iqun.guild_group_svr.GuildGroupSvr", "/trpc.iqun.guild_group_svr.GuildGroupSvr/QueryGuildGroupInfo", guildGroupSvrPB$QueryGuildGroupInfoReq.toByteArray(), 1, null, aVar);
        } catch (Exception e16) {
            QLog.i("GuildBindGroupHelper", 1, "[getBindTroopByGuildId] exception = " + e16);
        }
    }

    @Nullable
    public final JSONObject h(@Nullable String appId, @Nullable String guildId) {
        JSONObject jSONObject = cacheExtraDataForBindGroup;
        if (jSONObject != null) {
            String optString = jSONObject.optString("appid");
            String optString2 = jSONObject.optString("guildId");
            if (!TextUtils.isEmpty(appId) && !TextUtils.isEmpty(guildId) && TextUtils.equals(appId, optString) && TextUtils.equals(guildId, optString2)) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("dataCachedTimestamp", jSONObject.optLong("dataCachedTimestamp", 0L));
                jSONObject2.put("gameName", jSONObject.optString("app_name", ""));
                jSONObject2.put("gameIcon", jSONObject.optString("app_icon_url", ""));
                jSONObject2.put("guildName", jSONObject.optString("guildName", ""));
                return jSONObject2;
            }
            return null;
        }
        return null;
    }

    @Nullable
    public final String i(@NotNull String extraData) {
        Intrinsics.checkNotNullParameter(extraData, "extraData");
        try {
            return new JSONObject(extraData).optString("joinTroopIntro");
        } catch (Exception unused) {
            QLog.e("GuildBindGroupHelper", 1, "[getJoinTroopIntro]");
            return null;
        }
    }

    @Nullable
    public final JSONObject j() {
        JSONObject jSONObject = new JSONObject();
        zp3.d dVar = helper;
        String str = null;
        if (dVar == null) {
            return null;
        }
        JSONObject jSONObject2 = cacheExtraDataForBindGroup;
        if (jSONObject2 != null) {
            str = jSONObject2.optString("guildId");
        }
        jSONObject.put("guildId", str);
        jSONObject.put("appId", dVar.getAppId());
        return jSONObject;
    }

    @NotNull
    public final AtomicInteger k() {
        return unbindDialogState;
    }

    public final void l(@NotNull String troopUin, @NotNull JSONObject packedExtraData) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(packedExtraData, "packedExtraData");
        Activity topActivity = Foreground.getTopActivity();
        Intent m3 = BaseAIOUtils.m(((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).getSplashActivityIntent(topActivity), new int[]{2});
        m3.putExtra("uin", troopUin);
        m3.putExtra("uintype", 1);
        m3.putExtra("fromThirdAppByOpenSDK", true);
        m3.putExtra("action", 3);
        m3.putExtra("appid", packedExtraData.optString("appid"));
        m3.putExtra("app_name", packedExtraData.optString("app_name"));
        m3.putExtra("pkg_name", packedExtraData.optString("pkg_name"));
        m3.putExtra("guildId", packedExtraData.optString("guildId"));
        m3.putExtra("isFromGuildBindGroup", true);
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(topActivity, RouterConstants.UI_ROUTER_SPLASH);
        Bundle extras = m3.getExtras();
        Bundle extra = activityURIRequest.extra();
        if (extras == null) {
            extras = new Bundle();
        }
        extra.putAll(extras);
        activityURIRequest.setFlags(m3.getFlags());
        activityURIRequest.setData(m3.getData());
        activityURIRequest.setType(m3.getType());
        activityURIRequest.setIntentAction(m3.getAction());
        QRoute.startUri(activityURIRequest);
        p();
    }

    public final void m(@NotNull String troopUin, @Nullable String authSig, @Nullable String joinTroopIntro, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(context, "context");
        Bundle b16 = aq.b(troopUin, 32);
        b16.putString("join_troop_verify_message", joinTroopIntro);
        b16.putString("authSig", authSig);
        ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).openTroopInfoActivity(context, b16, 2);
    }

    public final boolean n() {
        boolean b16 = com.tencent.mobileqq.troop.config.b.f294691a.b("101294", "is_enable", false);
        QLog.i("GuildBindGroupHelper", 1, "[isConfigEnable] rtn = " + b16);
        return b16;
    }

    @NotNull
    public final JSONObject o(@NotNull zp3.d handler, @NotNull AppInfo appInfo, @NotNull String extraData) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(appInfo, "appInfo");
        Intrinsics.checkNotNullParameter(extraData, "extraData");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject = new JSONObject(extraData);
        } catch (Exception e16) {
            QLog.e("GuildBindGroupHelper", 1, "[packParams] extraData = " + extraData + ", exception = " + e16);
        }
        jSONObject.put("appid", handler.getAppId());
        jSONObject.put("app_name", appInfo.e());
        jSONObject.put("pkg_name", handler.getPackageName());
        jSONObject.put("app_icon_url", appInfo.b());
        return jSONObject;
    }

    public final void p() {
        helper = null;
    }

    public final void q(@NotNull final zp3.d helper2) {
        final JumpActivity jumpActivity;
        Intrinsics.checkNotNullParameter(helper2, "helper");
        Context context = helper2.getContext();
        if (context instanceof JumpActivity) {
            jumpActivity = (JumpActivity) context;
        } else {
            jumpActivity = null;
        }
        if (jumpActivity == null) {
            String appId = helper2.getAppId();
            GuildBindGroupStateCode guildBindGroupStateCode = GuildBindGroupStateCode.E_USER_NOT_SAME;
            f(appId, "", guildBindGroupStateCode.getCode(), guildBindGroupStateCode.getMsg());
            return;
        }
        final QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(jumpActivity, 230);
        Intrinsics.checkNotNullExpressionValue(createCustomDialog, "createCustomDialog(activ\u2026 DialogUtil.ALERT_DIALOG)");
        createCustomDialog.setTitle(R.string.b1v);
        createCustomDialog.setMessage(R.string.d65);
        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.opensdkhandler.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                d.r(zp3.d.this, jumpActivity, createCustomDialog, dialogInterface, i3);
            }
        };
        createCustomDialog.setNegativeButton(R.string.cancel, onClickListener);
        createCustomDialog.setPositiveButton(R.string.d5b, onClickListener);
        createCustomDialog.show();
    }

    public final void s(@Nullable Activity activity, @Nullable final String appId, @NotNull String appName, @Nullable final String guildId) {
        Intrinsics.checkNotNullParameter(appName, "appName");
        if (unbindDialogState.compareAndSet(GuildBindGroupDialogState.NEED_SHOW.ordinal(), GuildBindGroupDialogState.SHOWN.ordinal())) {
            if (activity == null) {
                QLog.i("GuildBindGroupHelper", 1, "[showUnBindDialog] activity = null");
            } else {
                DialogUtil.createCustomDialog(activity, 230, (String) null, activity.getString(R.string.yty, appName), HardCodeUtil.qqStr(R.string.f2059456z), HardCodeUtil.qqStr(R.string.f20595570), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.opensdkhandler.b
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        d.t(appId, guildId, dialogInterface, i3);
                    }
                }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.opensdkhandler.c
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        d.u(appId, guildId, dialogInterface, i3);
                    }
                }).show();
            }
        }
    }
}
