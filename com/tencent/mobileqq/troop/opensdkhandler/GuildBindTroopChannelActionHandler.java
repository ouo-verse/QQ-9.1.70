package com.tencent.mobileqq.troop.opensdkhandler;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.open.model.AppInfo;
import com.tencent.protofile.game_bind_troop.GuildGroupSvrPB$QueryGuildGroupInfoRsp;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQToastUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.Foreground;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import zp3.d;

/* compiled from: P */
@KeepClassConstructor
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 &2\u00020\u0001:\u0001!B\u0007\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0006H\u0002J(\u0010\u000e\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J(\u0010\u000f\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\\\u0010\u0019\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022B\u0010\u0018\u001a>\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0004\u0012\u00020\n0\u0010j\u0002`\u0017H\u0002J \u0010\u001d\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0006H\u0002J\u0010\u0010 \u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J\u0018\u0010!\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010#\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/troop/opensdkhandler/GuildBindTroopChannelActionHandler;", "Lzp3/c;", "Lzp3/d;", "helper", "", "f", "", WadlProxyConsts.EXTRA_DATA, "Lcom/tencent/open/model/AppInfo;", "appInfo", "", "l", "guildId", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "o", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "troopUin", "isMember", "Lcom/tencent/protofile/game_bind_troop/GuildGroupSvrPB$QueryGuildGroupInfoRsp;", "Lcom/tencent/mobileqq/troop/opensdkhandler/OnGetGuildGroupHandler;", "onGetGuildGroupHandler", "i", "", "rstCode", "rstMsg", "g", "Landroid/content/Context;", "context", tl.h.F, "a", "Z", "mGetAppConnectCheckResultTimeout", "<init>", "()V", "b", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class GuildBindTroopChannelActionHandler implements zp3.c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean mGetAppConnectCheckResultTimeout;

    private final boolean f(zp3.d helper) {
        if (this.mGetAppConnectCheckResultTimeout && helper.getContext() != null) {
            GuildBindGroupStateCode guildBindGroupStateCode = GuildBindGroupStateCode.CONNECTION_TIMEOUT;
            QQToastUtil.showQQToastInUiThread(1, guildBindGroupStateCode.getMsg());
            Intent intent = new Intent();
            intent.addFlags(268435456);
            intent.addFlags(67108864);
            RouteUtils.startActivity(helper.getContext(), intent, RouterConstants.UI_ROUTER_SPLASH);
            g(helper, guildBindGroupStateCode.getCode(), guildBindGroupStateCode.getMsg());
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(zp3.d helper, int rstCode, String rstMsg) {
        QLog.i("GuildBindTroopChannelActionHandler", 1, "[doCallbackInner] helper = " + helper + ", rstCode = " + rstCode + ", rstMsg = " + rstMsg);
        helper.c(Foreground.getTopActivity(), rstCode, rstMsg);
        d.f298075a.p();
        Context context = helper.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "helper.context");
        h(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(Context context) {
        QLog.i("GuildBindTroopChannelActionHandler", 1, "[exitJumpActivity]");
        if (context instanceof JumpActivity) {
            ((Activity) context).finish();
        }
    }

    private final void i(String guildId, final zp3.d helper, final Function3<? super Long, ? super Boolean, ? super GuildGroupSvrPB$QueryGuildGroupInfoRsp, Unit> onGetGuildGroupHandler) {
        d dVar = d.f298075a;
        String appId = helper.getAppId();
        Intrinsics.checkNotNullExpressionValue(appId, "helper.appId");
        dVar.g(appId, guildId, new Function1<GuildGroupSvrPB$QueryGuildGroupInfoRsp, Unit>() { // from class: com.tencent.mobileqq.troop.opensdkhandler.GuildBindTroopChannelActionHandler$getAndCheckBindGroup$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GuildGroupSvrPB$QueryGuildGroupInfoRsp guildGroupSvrPB$QueryGuildGroupInfoRsp) {
                invoke2(guildGroupSvrPB$QueryGuildGroupInfoRsp);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable GuildGroupSvrPB$QueryGuildGroupInfoRsp guildGroupSvrPB$QueryGuildGroupInfoRsp) {
                if (guildGroupSvrPB$QueryGuildGroupInfoRsp == null) {
                    GuildBindGroupStateCode guildBindGroupStateCode = GuildBindGroupStateCode.NETWORK_FAIL;
                    QQToastUtil.showQQToastInUiThread(1, guildBindGroupStateCode.getMsg());
                    GuildBindTroopChannelActionHandler.this.g(helper, guildBindGroupStateCode.getCode(), guildBindGroupStateCode.getMsg());
                    return;
                }
                if (guildGroupSvrPB$QueryGuildGroupInfoRsp.dissolved.get()) {
                    QQToastUtil.showQQToastInUiThread(1, GuildBindGroupStateCode.GROUP_DISSOLVED.getMsg());
                } else if (guildGroupSvrPB$QueryGuildGroupInfoRsp.freeze.get()) {
                    QQToastUtil.showQQToastInUiThread(1, GuildBindGroupStateCode.GROUP_FREEZE.getMsg());
                } else if (guildGroupSvrPB$QueryGuildGroupInfoRsp.suspended.get()) {
                    QQToastUtil.showQQToastInUiThread(1, GuildBindGroupStateCode.GROUP_SUSPENDED.getMsg());
                }
                if (guildGroupSvrPB$QueryGuildGroupInfoRsp.binding_status.get() == 2 && guildGroupSvrPB$QueryGuildGroupInfoRsp.group_code.get() > 0) {
                    onGetGuildGroupHandler.invoke(Long.valueOf(guildGroupSvrPB$QueryGuildGroupInfoRsp.group_code.get()), Boolean.valueOf(guildGroupSvrPB$QueryGuildGroupInfoRsp.is_group_member.get()), guildGroupSvrPB$QueryGuildGroupInfoRsp);
                    return;
                }
                GuildBindGroupStateCode guildBindGroupStateCode2 = GuildBindGroupStateCode.GUILD_NO_BIND_GROUP;
                QQToastUtil.showQQToastInUiThread(1, guildBindGroupStateCode2.getMsg());
                GuildBindTroopChannelActionHandler.this.g(helper, guildBindGroupStateCode2.getCode(), guildBindGroupStateCode2.getMsg());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(GuildBindTroopChannelActionHandler this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mGetAppConnectCheckResultTimeout = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(GuildBindTroopChannelActionHandler this$0, zp3.d helper, String extraData, int i3, byte[] bArr, Bundle bundle, AppInfo appInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(helper, "$helper");
        Intrinsics.checkNotNullParameter(extraData, "$extraData");
        QLog.i("GuildBindTroopChannelActionHandler", 1, "[handleAction] errCode = " + i3);
        d dVar = d.f298075a;
        dVar.e(helper);
        if (!this$0.f(helper)) {
            if (i3 != 0) {
                if (i3 == GuildBindGroupStateCode.E_USER_NOT_SAME.getCode()) {
                    dVar.q(helper);
                    return;
                }
                this$0.g(helper, i3, "errorCode = " + i3);
                return;
            }
            Intrinsics.checkNotNullExpressionValue(appInfo, "appInfo");
            this$0.l(extraData, helper, appInfo);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004a A[Catch: Exception -> 0x00c1, TryCatch #0 {Exception -> 0x00c1, blocks: (B:3:0x001c, B:5:0x0034, B:7:0x003e, B:12:0x004a, B:15:0x0058, B:17:0x0076, B:19:0x007d, B:21:0x0085, B:23:0x008c, B:25:0x0094, B:27:0x009b, B:30:0x00a9), top: B:2:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0058 A[Catch: Exception -> 0x00c1, TryCatch #0 {Exception -> 0x00c1, blocks: (B:3:0x001c, B:5:0x0034, B:7:0x003e, B:12:0x004a, B:15:0x0058, B:17:0x0076, B:19:0x007d, B:21:0x0085, B:23:0x008c, B:25:0x0094, B:27:0x009b, B:30:0x00a9), top: B:2:0x001c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void l(String extraData, zp3.d helper, AppInfo appInfo) {
        Integer intOrNull;
        boolean z16;
        QLog.i("GuildBindTroopChannelActionHandler", 1, "[handleBindTroopInner] extraData = " + extraData);
        try {
            JSONObject jSONObject = new JSONObject(extraData);
            String optString = jSONObject.optString("bizType");
            Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(PARAM_KEY_BIZ_TYPE)");
            intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(optString);
            if (intOrNull != null) {
                int intValue = intOrNull.intValue();
                String guildId = jSONObject.optString("guildId");
                if (guildId != null && guildId.length() != 0) {
                    z16 = false;
                    if (!z16) {
                        GuildBindGroupStateCode guildBindGroupStateCode = GuildBindGroupStateCode.GUILD_ID_EMPTY;
                        g(helper, guildBindGroupStateCode.getCode(), guildBindGroupStateCode.getMsg());
                        return;
                    }
                    d dVar = d.f298075a;
                    dVar.d(dVar.o(helper, appInfo, extraData));
                    dVar.k().set(GuildBindGroupDialogState.UNKNOWN.ordinal());
                    if (intValue == GuildBindGroupBusinessType.CREATE_GROUP.getType()) {
                        Intrinsics.checkNotNullExpressionValue(guildId, "guildId");
                        m(helper, guildId);
                        return;
                    } else if (intValue == GuildBindGroupBusinessType.GO_CHAT.getType()) {
                        Intrinsics.checkNotNullExpressionValue(guildId, "guildId");
                        n(guildId, extraData, helper, appInfo);
                        return;
                    } else if (intValue == GuildBindGroupBusinessType.UNBIND_GROUP.getType()) {
                        Intrinsics.checkNotNullExpressionValue(guildId, "guildId");
                        o(guildId, extraData, helper, appInfo);
                        return;
                    } else {
                        GuildBindGroupStateCode guildBindGroupStateCode2 = GuildBindGroupStateCode.BIZ_TYPE_INVALIDATE;
                        g(helper, guildBindGroupStateCode2.getCode(), guildBindGroupStateCode2.getMsg());
                        return;
                    }
                }
                z16 = true;
                if (!z16) {
                }
            } else {
                QQToastUtil.showQQToastInUiThread(1, HardCodeUtil.qqStr(R.string.f146350ty));
                GuildBindGroupStateCode guildBindGroupStateCode3 = GuildBindGroupStateCode.BIZ_TYPE_INVALIDATE;
                g(helper, guildBindGroupStateCode3.getCode(), guildBindGroupStateCode3.getMsg());
            }
        } catch (Exception e16) {
            QLog.e("GuildBindTroopChannelActionHandler", 1, "[handleBindTroopInner] exception = " + e16);
        }
    }

    private final void m(zp3.d helper, String guildId) {
        Activity topActivity = Foreground.getTopActivity();
        if (topActivity == null) {
            Context context = helper.getContext();
            if (context instanceof Activity) {
                topActivity = (Activity) context;
            } else {
                topActivity = null;
            }
        }
        if (topActivity == null) {
            QLog.e("GuildBindTroopChannelActionHandler", 1, "[subHandlerBindTroop] activity == null");
            return;
        }
        String str = ("https://admin.qun.qq.com/mcreatev4/create?entry_from=2&_wv=3&_wwv=128&cateid=25&_bid=206&_wv=2098179&guildId=" + guildId) + "&appid=" + helper.getAppId();
        Intent intent = new Intent();
        intent.putExtra("url", str);
        com.tencent.mobileqq.troop.troopcreate.a.k(topActivity, intent, RouterConstants.UI_ROUTE_BROWSER);
        Context context2 = helper.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "helper.context");
        h(context2);
        QLog.i("GuildBindTroopChannelActionHandler", 1, "[subHandlerBindTroop] activity = " + topActivity + ", url = " + str);
    }

    private final void n(String guildId, final String extraData, final zp3.d helper, final AppInfo appInfo) {
        i(guildId, helper, new Function3<Long, Boolean, GuildGroupSvrPB$QueryGuildGroupInfoRsp, Unit>() { // from class: com.tencent.mobileqq.troop.opensdkhandler.GuildBindTroopChannelActionHandler$subHandlerJoinTroop$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Long l3, Boolean bool, GuildGroupSvrPB$QueryGuildGroupInfoRsp guildGroupSvrPB$QueryGuildGroupInfoRsp) {
                invoke(l3.longValue(), bool.booleanValue(), guildGroupSvrPB$QueryGuildGroupInfoRsp);
                return Unit.INSTANCE;
            }

            public final void invoke(long j3, boolean z16, @Nullable GuildGroupSvrPB$QueryGuildGroupInfoRsp guildGroupSvrPB$QueryGuildGroupInfoRsp) {
                PBStringField pBStringField;
                if (z16) {
                    d dVar = d.f298075a;
                    dVar.l(String.valueOf(j3), dVar.o(zp3.d.this, appInfo, extraData));
                } else {
                    d dVar2 = d.f298075a;
                    String valueOf = String.valueOf(j3);
                    String str = (guildGroupSvrPB$QueryGuildGroupInfoRsp == null || (pBStringField = guildGroupSvrPB$QueryGuildGroupInfoRsp.join_group_auth_key) == null) ? null : pBStringField.get();
                    String i3 = dVar2.i(extraData);
                    Context context = zp3.d.this.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "helper.context");
                    dVar2.m(valueOf, str, i3, context);
                }
                GuildBindTroopChannelActionHandler guildBindTroopChannelActionHandler = this;
                Context context2 = zp3.d.this.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "helper.context");
                guildBindTroopChannelActionHandler.h(context2);
            }
        });
    }

    private final void o(String guildId, String extraData, zp3.d helper, AppInfo appInfo) {
        i(guildId, helper, new GuildBindTroopChannelActionHandler$subHandlerUnBindTroop$1(helper, appInfo, extraData, this, guildId));
    }

    @Override // zp3.c
    public void a(@NotNull final String extraData, @NotNull final zp3.d helper) {
        Intrinsics.checkNotNullParameter(extraData, "extraData");
        Intrinsics.checkNotNullParameter(helper, "helper");
        if (helper.getContext() == null) {
            QLog.i("GuildBindTroopChannelActionHandler", 1, "helper.context == null");
            return;
        }
        if (!d.f298075a.n()) {
            QLog.i("GuildBindTroopChannelActionHandler", 1, "config forbid");
            GuildBindGroupStateCode guildBindGroupStateCode = GuildBindGroupStateCode.SWITCH_CONFIG_CLOSED;
            QQToastUtil.showQQToastInUiThread(1, guildBindGroupStateCode.getMsg());
            g(helper, guildBindGroupStateCode.getCode(), guildBindGroupStateCode.getMsg());
            return;
        }
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.troop.opensdkhandler.f
            @Override // java.lang.Runnable
            public final void run() {
                GuildBindTroopChannelActionHandler.j(GuildBindTroopChannelActionHandler.this);
            }
        }, 16, null, true, 20000L);
        helper.a(new d.b() { // from class: com.tencent.mobileqq.troop.opensdkhandler.g
            @Override // zp3.d.b
            public final void a(int i3, byte[] bArr, Bundle bundle, AppInfo appInfo) {
                GuildBindTroopChannelActionHandler.k(GuildBindTroopChannelActionHandler.this, helper, extraData, i3, bArr, bundle, appInfo);
            }
        });
    }
}
