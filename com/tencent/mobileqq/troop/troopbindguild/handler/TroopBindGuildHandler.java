package com.tencent.mobileqq.troop.troopbindguild.handler;

import android.text.TextUtils;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.msf.core.f0.c.e.h;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.handler.TroopBaseHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import ft2.a;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0xf00.oidb_0xf00$GroupInfoExt;
import tencent.im.oidb.cmd0xf00.oidb_0xf00$ReqBody;
import tencent.im.oidb.cmd0xf00.oidb_0xf00$RspBody;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001a2\u00020\u00012\u00020\u0002:\u0001\u001bB\u0011\b\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0014J\u0012\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\fH\u0016J\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J&\u0010\u0012\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013H\u0014\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/troop/troopbindguild/handler/TroopBindGuildHandler;", "Lcom/tencent/mobileqq/troop/handler/TroopBaseHandler;", "", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "req", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "res", "data", "", "F2", "", "getTag", "", "getCommandList", "troopUin", "", h.f248218g, Constants.MMCCID, "onReceive", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/app/BusinessObserver;", "observerClass", "Lcom/tencent/common/app/AppInterface;", "app", "<init>", "(Lcom/tencent/common/app/AppInterface;)V", "e", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopBindGuildHandler extends TroopBaseHandler {
    TroopBindGuildHandler(AppInterface appInterface) {
        super(appInterface);
    }

    private final void F2(ToServiceMsg req, FromServiceMsg res, Object data) {
        String troopUin = req.extraData.getString("troop_uin", "0");
        boolean z16 = req.extraData.getBoolean("CMD_ATTR_BIND_GUILD_SWITCH", false);
        try {
            oidb_0xf00$RspBody oidb_0xf00_rspbody = new oidb_0xf00$RspBody();
            int parseOIDBPkg = OidbWrapper.parseOIDBPkg(res, data, oidb_0xf00_rspbody);
            if (parseOIDBPkg == 0 && res.isSuccess()) {
                int i3 = oidb_0xf00_rspbody.int32_result.get();
                if (i3 != 0) {
                    QLog.e("TroopBindGuildHandler", 2, "handleSetBindGuildSwitch| rspResult = " + i3);
                    Intrinsics.checkNotNullExpressionValue(troopUin, "troopUin");
                    notifyUI(1, false, new Object[]{troopUin, Boolean.valueOf(z16)});
                    return;
                }
                QLog.i("TroopBindGuildHandler", 1, "handleSetBindGuildSwitch| switch= " + z16);
                Intrinsics.checkNotNullExpressionValue(troopUin, "troopUin");
                notifyUI(1, true, new Object[]{troopUin, Boolean.valueOf(z16)});
                return;
            }
            QLog.e("TroopBindGuildHandler", 1, "handleSetBindGuildSwitch parse result=" + parseOIDBPkg + ", isSuccess=" + res.isSuccess() + "errorMsg=" + res.getBusinessFailMsg());
            Intrinsics.checkNotNullExpressionValue(troopUin, "troopUin");
            notifyUI(1, false, new Object[]{troopUin, Boolean.valueOf(z16)});
        } catch (Exception e16) {
            QLog.e("TroopBindGuildHandler", 1, "handleSetBindGuildSwitch| exception: " + e16.getMessage());
            Intrinsics.checkNotNullExpressionValue(troopUin, "troopUin");
            notifyUI(1, false, new Object[]{troopUin, Boolean.valueOf(z16)});
        }
    }

    public void G2(@NotNull String troopUin, boolean isOpen) {
        int i3;
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        if (TextUtils.isEmpty(troopUin)) {
            QLog.e("TroopBindGuildHandler", 1, "setTroopBindGuildSwitch troopUin is null");
            return;
        }
        try {
            oidb_0xf00$ReqBody oidb_0xf00_reqbody = new oidb_0xf00$ReqBody();
            oidb_0xf00_reqbody.uint64_group_code.set(Long.parseLong(troopUin));
            oidb_0xf00$GroupInfoExt oidb_0xf00_groupinfoext = new oidb_0xf00$GroupInfoExt();
            PBUInt32Field pBUInt32Field = oidb_0xf00_groupinfoext.uint32_group_bind_guild_switch;
            if (isOpen) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            pBUInt32Field.set(i3);
            oidb_0xf00_reqbody.msg_group_info_ext.set(oidb_0xf00_groupinfoext);
            ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0xf00_3", 3840, 3, oidb_0xf00_reqbody.toByteArray(), 30000L);
            makeOIDBPkg.extraData.putString("troop_uin", troopUin);
            makeOIDBPkg.extraData.putBoolean("CMD_ATTR_BIND_GUILD_SWITCH", isOpen);
            sendPbReq(makeOIDBPkg);
        } catch (Exception e16) {
            QLog.e("TroopBindGuildHandler", 1, "setEssenceMsgShowInCardSwitch Exception e:" + e16.getClass().getSimpleName());
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    @Nullable
    public Set<String> getCommandList() {
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("OidbSvc.0xf00_3");
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.troop.handler.TroopBaseHandler
    @NotNull
    protected String getTag() {
        return "TroopBindGuildHandler";
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    @NotNull
    protected Class<? extends BusinessObserver> observerClass() {
        return a.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(@Nullable ToServiceMsg req, @Nullable FromServiceMsg res, @Nullable Object data) {
        if (res != null && req != null) {
            String serviceCmd = res.getServiceCmd();
            Intrinsics.checkNotNullExpressionValue(serviceCmd, "res.serviceCmd");
            if (msgCmdFilter(serviceCmd)) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopBindGuildHandler", 2, "cmdfilter error=" + serviceCmd);
                    return;
                }
                return;
            }
            if (!Intrinsics.areEqual(getTag(), req.extraData.getString("REQ_TAG"))) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopBindGuildHandler", 2, "REQ_TAG doesn't match. cmd:  " + serviceCmd);
                    return;
                }
                return;
            }
            if (Intrinsics.areEqual("OidbSvc.0xf00_3", res.getServiceCmd())) {
                F2(req, res, data);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopBindGuildHandler", 2, "onReceive,resp == null or req == null");
        }
    }
}
