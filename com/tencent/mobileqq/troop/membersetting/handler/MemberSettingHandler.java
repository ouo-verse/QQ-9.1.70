package com.tencent.mobileqq.troop.membersetting.handler;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.common.app.AppInterface;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.mobileqq.troop.api.IBizTroopMemberInfoService;
import com.tencent.mobileqq.troop.membersetting.handler.MemberSettingHandler;
import com.tencent.mobileqq.troop.troopgag.api.a;
import com.tencent.mobileqq.troop.troopgag.data.a;
import com.tencent.mobileqq.troop.troopgag.data.b;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import com.tencent.state.data.SquareJSConst;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MainService;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import tencent.im.oidb.cmd0x8a0.oidb_0x8a0$KickMemberInfo;
import tencent.im.oidb.cmd0x8a0.oidb_0x8a0$KickResult;
import tencent.im.oidb.cmd0x8a0.oidb_0x8a0$ReqBody;
import tencent.im.oidb.cmd0x8a0.oidb_0x8a0$RspBody;
import tencent.im.oidb.cmd0x8bb.oidb_0x8bb$ForbidUin;
import tencent.im.oidb.cmd0x8bb.oidb_0x8bb$GroupConcernedInfo;
import tencent.im.oidb.cmd0x8bb.oidb_0x8bb$ReqBody;
import tencent.im.oidb.cmd0x8bb.oidb_0x8bb$UinInfo;
import tencent.im.oidb.cmd0x8bb.oidb_0x8bb$WriteReq;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;
import ws2.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 D2\u00020\u0001:\u0001EB\u000f\u0012\u0006\u0010A\u001a\u00020@\u00a2\u0006\u0004\bB\u0010CJ.\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006H\u0002J0\u0010\u0011\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J0\u0010\u0012\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J$\u0010\u0014\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0013\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J\"\u0010\u0016\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J&\u0010\u001c\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002J\u0018\u0010 \u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J \u0010$\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\u001eH\u0002J\u0012\u0010&\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010%H\u0002J\u0018\u0010*\u001a\u00020\b2\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020\u0015H\u0002J\u001a\u0010,\u001a\u00020\b2\b\u0010+\u001a\u0004\u0018\u00010\u00022\u0006\u0010)\u001a\u00020\u0015H\u0002J\u000e\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00020-H\u0016J \u0010/\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u00102\u001a\n\u0012\u0006\b\u0001\u0012\u00020100H\u0014J.\u00108\u001a\u00020\b2\u0006\u00103\u001a\u00020\u001e2\u000e\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e042\u0006\u00106\u001a\u00020\u00152\u0006\u00107\u001a\u00020\u0015J$\u0010;\u001a\u00020\b2\u0006\u00109\u001a\u00020'2\u0006\u00103\u001a\u00020\u001e2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u001e04J\"\u0010>\u001a\u00020\u00152\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010<\u001a\u0004\u0018\u00010\u00022\u0006\u0010=\u001a\u00020\u001eJ\u0010\u0010?\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u000bH\u0016\u00a8\u0006F"}, d2 = {"Lcom/tencent/mobileqq/troop/membersetting/handler/MemberSettingHandler;", "Lcom/tencent/mobileqq/app/BusinessHandler;", "", "sUin", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/troop/troopgag/api/a$a;", "Lkotlin/collections/ArrayList;", "arList", "", "F2", "cmd", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "req", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "resp", "", "data", "H2", "J2", "res", "I2", "", "K2", MainService.SERVICE_CMD, "", "wupBuffer", "Landroid/os/Bundle;", WadlProxyConsts.EXTRA_DATA, "O2", Const.BUNDLE_KEY_REQUEST, "", "timeout", "N2", "uin", "isSucceed", PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, "L2", "Lcom/tencent/mobileqq/troop/troopgag/data/a;", BdhLogUtil.LogTag.Tag_Conn, "", "resId", "bSucceed", "showTipsToast", "text", "P2", "", "getCommandList", "onReceive", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/app/BusinessObserver;", "observerClass", "troopUin", "", "uinsToDelete", "isBlack", "normalMemberDel", "E2", "type", "uinsToFocus", "M2", "sMemberUin", "lSecond", Constants.MMCCID, "sendPbReq", "Lcom/tencent/common/app/AppInterface;", "app", "<init>", "(Lcom/tencent/common/app/AppInterface;)V", "d", "a", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class MemberSettingHandler extends BusinessHandler {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberSettingHandler(AppInterface app) {
        super(app);
        Intrinsics.checkNotNullParameter(app, "app");
    }

    private final boolean K2(ToServiceMsg req, FromServiceMsg res, Object data) {
        if (!Intrinsics.areEqual("OidbSvc.0x570_8", res.getServiceCmd())) {
            return false;
        }
        String string = req.extraData.getString("troopUin");
        long j3 = req.extraData.getLong("timpStamp");
        int i3 = R.string.emp;
        int i16 = R.string.emq;
        if (data != null && res.isSuccess()) {
            try {
                oidb_sso$OIDBSSOPkg mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) data);
                if (mergeFrom == null || !mergeFrom.uint32_result.has() || !mergeFrom.bytes_bodybuffer.has() || mergeFrom.bytes_bodybuffer.get() == null) {
                    if (string != null) {
                        L2(string, false, j3);
                    }
                    return true;
                }
                if (mergeFrom.uint32_result.get() != 0) {
                    if (mergeFrom.uint32_result.get() == 10) {
                        if (j3 == 0) {
                            i3 = R.string.ekg;
                        }
                        showTipsToast(i3, false);
                    } else {
                        if (j3 == 0) {
                            i16 = R.string.ekg;
                        }
                        showTipsToast(i16, false);
                    }
                    if (string != null) {
                        L2(string, false, j3);
                    }
                    return true;
                }
                if (string != null) {
                    L2(string, true, j3);
                }
                showTipsToast(j3 == 0 ? R.string.ekh : R.string.emr, true);
                return true;
            } catch (InvalidProtocolBufferMicroException unused) {
                if (string != null) {
                    L2(string, false, j3);
                }
                if (j3 == 0) {
                    i16 = R.string.ekg;
                }
                showTipsToast(i16, false);
                return true;
            }
        }
        if (res.getResultCode() == 10) {
            if (j3 == 0) {
                i3 = R.string.ekg;
            }
            showTipsToast(i3, false);
        } else {
            if (j3 == 0) {
                i16 = R.string.ekg;
            }
            showTipsToast(i16, false);
        }
        if (string != null) {
            L2(string, false, j3);
        }
        return true;
    }

    private final void L2(String uin, boolean isSucceed, long timeStamp) {
        a aVar = new a(uin, new b(isSucceed, timeStamp));
        aVar.f300229i = 3;
        C(aVar);
    }

    private final void N2(ToServiceMsg request, long timeout) {
        request.addAttribute(MobileQQServiceBase.REQ_PB_PROTOCOL_FLAG, Boolean.TRUE);
        if (request.getWupBuffer() != null) {
            long length = request.getWupBuffer().length;
            int i3 = (int) length;
            byte[] bArr = new byte[i3 + 4];
            PkgTools.dWord2Byte(bArr, 0, length + 4);
            PkgTools.copyData(bArr, 4, request.getWupBuffer(), i3);
            request.putWupBuffer(bArr);
            if (QLog.isColorLevel()) {
                QLog.d("MemberSettingHandler", 2, "PB cmd: req cmd: " + request.getServiceCmd());
            }
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            NewIntent newIntent = new NewIntent(peekAppRuntime.getApplication(), c.class);
            newIntent.putExtra(ToServiceMsg.class.getSimpleName(), request);
            peekAppRuntime.startServlet(newIntent);
            request.extraData.putLong("sendtimekey", System.currentTimeMillis());
        }
    }

    private final void O2(String serviceCmd, byte[] wupBuffer, Bundle extraData) {
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin(), serviceCmd);
        toServiceMsg.putWupBuffer(wupBuffer);
        if (extraData != null) {
            toServiceMsg.extraData = extraData;
        }
        sendPbReq(toServiceMsg);
    }

    private final void P2(final String text, final boolean bSucceed) {
        if (TextUtils.isEmpty(text)) {
            return;
        }
        final Context applicationContext = MobileQQ.sMobileQQ.peekAppRuntime().getApplication().getApplicationContext();
        final int dimensionPixelSize = applicationContext.getResources().getDimensionPixelSize(R.dimen.title_bar_height);
        if (!Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: ws2.a
                @Override // java.lang.Runnable
                public final void run() {
                    MemberSettingHandler.Q2(bSucceed, applicationContext, text, dimensionPixelSize);
                }
            });
        } else if (bSucceed) {
            QQToast.makeText(applicationContext, 2, text, 0).show(dimensionPixelSize);
        } else {
            QQToast.makeText(applicationContext, R.drawable.f160605la, text, 0).show(dimensionPixelSize);
        }
    }

    private final void showTipsToast(int resId, boolean bSucceed) {
        P2(MobileQQ.sMobileQQ.peekAppRuntime().getApplication().getApplicationContext().getString(resId), bSucceed);
    }

    public final void E2(long troopUin, List<Long> uinsToDelete, boolean isBlack, boolean normalMemberDel) {
        Intrinsics.checkNotNullParameter(uinsToDelete, "uinsToDelete");
        oidb_0x8a0$ReqBody oidb_0x8a0_reqbody = new oidb_0x8a0$ReqBody();
        oidb_0x8a0_reqbody.opt_uint64_group_code.set(troopUin);
        ArrayList arrayList = new ArrayList();
        if (!normalMemberDel) {
            int size = uinsToDelete.size();
            for (int i3 = 0; i3 < size; i3++) {
                oidb_0x8a0$KickMemberInfo oidb_0x8a0_kickmemberinfo = new oidb_0x8a0$KickMemberInfo();
                oidb_0x8a0_kickmemberinfo.opt_uint32_operate.set(5);
                PBUInt64Field pBUInt64Field = oidb_0x8a0_kickmemberinfo.opt_uint64_member_uin;
                Long l3 = uinsToDelete.get(i3);
                pBUInt64Field.set(l3 != null ? l3.longValue() : 0L);
                oidb_0x8a0_kickmemberinfo.opt_uint32_flag.set(isBlack ? 1 : 0);
                arrayList.add(oidb_0x8a0_kickmemberinfo);
            }
        } else {
            oidb_0x8a0_reqbody.rpt_kick_list.set(uinsToDelete);
            oidb_0x8a0_reqbody.uint32_kick_flag.set(isBlack ? 1 : 0);
        }
        oidb_0x8a0_reqbody.rpt_msg_kick_list.set(arrayList);
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(Constants.Action.ACTION_WTLOGIN_GET_OPEN_KEY_WITHOUT_PASSWD);
        oidb_sso_oidbssopkg.uint32_result.set(0);
        oidb_sso_oidbssopkg.uint32_service_type.set(normalMemberDel ? 1 : 0);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_0x8a0_reqbody.toByteArray()));
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin(), "OidbSvc.0x8a0_0");
        toServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
        toServiceMsg.extraData.putLong("troopUin", troopUin);
        sendPbReq(toServiceMsg);
    }

    public final boolean G2(String sUin, String sMemberUin, long lSecond) {
        boolean isEmpty = TextUtils.isEmpty(sUin);
        int i3 = R.string.ekg;
        if (!isEmpty && !Intrinsics.areEqual(sUin, "0")) {
            if (!TextUtils.isEmpty(sMemberUin) && !Intrinsics.areEqual(sMemberUin, "0")) {
                ArrayList<a.C8807a> arrayList = new ArrayList<>();
                arrayList.add(new a.C8807a(sMemberUin, lSecond));
                F2(sUin, arrayList);
                return true;
            }
            if (lSecond != 0) {
                i3 = R.string.emq;
            }
            showTipsToast(i3, false);
            return false;
        }
        if (lSecond != 0) {
            i3 = R.string.emq;
        }
        showTipsToast(i3, false);
        return false;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("OidbSvc.0x8bb_2");
            this.allowCmdSet.add("OidbSvc.0x8bb_9");
            this.allowCmdSet.add("OidbSvc.0x8bb_7");
            this.allowCmdSet.add("OidbSvc.0x8a0_0");
            this.allowCmdSet.add("OidbSvc.0x89a_0");
            this.allowCmdSet.add("OidbSvc.0x570_8");
        }
        Set<String> allowCmdSet = this.allowCmdSet;
        Intrinsics.checkNotNullExpressionValue(allowCmdSet, "allowCmdSet");
        return allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return ws2.b.class;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x0023. Please report as an issue. */
    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg req, FromServiceMsg res, Object data) {
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(res, "res");
        Intrinsics.checkNotNullParameter(data, "data");
        String serviceCmd = res.getServiceCmd();
        if (msgCmdFilter(serviceCmd) || serviceCmd == null) {
            return;
        }
        switch (serviceCmd.hashCode()) {
            case 398438425:
                if (!serviceCmd.equals("OidbSvc.0x570_8")) {
                    return;
                }
                I2(req, res, data);
                return;
            case 401315651:
                if (!serviceCmd.equals("OidbSvc.0x89a_0")) {
                    return;
                }
                I2(req, res, data);
                return;
            case 402460202:
                if (serviceCmd.equals("OidbSvc.0x8a0_0")) {
                    H2(serviceCmd, req, res, data);
                    return;
                }
                return;
            case 402538045:
                if (!serviceCmd.equals("OidbSvc.0x8bb_2")) {
                    return;
                }
                J2(serviceCmd, req, res, data);
                return;
            case 402538050:
                if (!serviceCmd.equals("OidbSvc.0x8bb_7")) {
                    return;
                }
                J2(serviceCmd, req, res, data);
                return;
            case 402538052:
                if (!serviceCmd.equals("OidbSvc.0x8bb_9")) {
                    return;
                }
                J2(serviceCmd, req, res, data);
                return;
            default:
                return;
        }
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void sendPbReq(ToServiceMsg request) {
        Intrinsics.checkNotNullParameter(request, "request");
        N2(request, 30000L);
    }

    private final void C(com.tencent.mobileqq.troop.troopgag.data.a data) {
        notifyUI(2, true, data);
    }

    private final void F2(String sUin, ArrayList<a.C8807a> arList) {
        if (arList == null || arList.size() == 0) {
            return;
        }
        int size = arList.size();
        String str = "";
        for (int i3 = 0; i3 < size; i3++) {
            a.C8807a c8807a = arList.get(i3);
            Intrinsics.checkNotNullExpressionValue(c8807a, "arList[index]");
            a.C8807a c8807a2 = c8807a;
            str = str + c8807a2.f300216a + c8807a2.f300217b + "|";
        }
        ByteBuffer allocate = ByteBuffer.allocate((arList.size() * 8) + 7);
        if (sUin != null) {
            allocate.putInt((int) Long.parseLong(sUin));
        }
        allocate.put((byte) 32);
        allocate.putShort((short) arList.size());
        int size2 = arList.size();
        String str2 = null;
        long j3 = 0;
        int i16 = 0;
        while (i16 < size2) {
            a.C8807a c8807a3 = arList.get(i16);
            Intrinsics.checkNotNullExpressionValue(c8807a3, "arList[index]");
            a.C8807a c8807a4 = c8807a3;
            String str3 = c8807a4.f300216a;
            Intrinsics.checkNotNullExpressionValue(str3, "tempParam.sUin");
            allocate.putInt((int) Long.parseLong(str3));
            allocate.putInt((int) c8807a4.f300217b);
            String str4 = c8807a4.f300216a;
            long j16 = c8807a4.f300217b;
            i16++;
            str2 = str4;
            j3 = j16;
        }
        byte[] array = allocate.array();
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(1392);
        oidb_sso_oidbssopkg.uint32_result.set(0);
        oidb_sso_oidbssopkg.uint32_service_type.set(8);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(array));
        Bundle bundle = new Bundle();
        bundle.putString("troopUin", sUin);
        bundle.putString("memberUin", str2);
        bundle.putLong("timpStamp", j3);
        bundle.putInt("key_subcmd", 2);
        O2("OidbSvc.0x570_8", oidb_sso_oidbssopkg.toByteArray(), bundle);
    }

    private final void I2(ToServiceMsg req, FromServiceMsg res, Object data) {
        if (req == null || req.extraData.getInt("key_subcmd", -1) != 2) {
            return;
        }
        K2(req, res, data);
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00d6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void J2(String cmd, ToServiceMsg req, FromServiceMsg resp, Object data) {
        byte b16;
        if (req != null && resp != null) {
            if (resp.getResultCode() != 1000) {
                notifyUI(1, false, new Object[]{cmd, 2, null});
                return;
            }
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            try {
                Intrinsics.checkNotNull(data, "null cannot be cast to non-null type kotlin.ByteArray");
                oidb_sso$OIDBSSOPkg mergeFrom = oidb_sso_oidbssopkg.mergeFrom((byte[]) data);
                if (mergeFrom != null && mergeFrom.uint32_result.has()) {
                    int i3 = mergeFrom.uint32_result.get();
                    if (i3 != 0) {
                        if (i3 == 65) {
                            notifyUI(1, false, new Object[]{cmd, 3, null});
                            return;
                        } else if (i3 != 66) {
                            notifyUI(1, false, new Object[]{cmd, 2, null});
                            return;
                        } else {
                            notifyUI(1, false, new Object[]{cmd, 4, null});
                            return;
                        }
                    }
                    long j3 = req.extraData.getLong("troopUin");
                    long[] longArray = req.extraData.getLongArray(SquareJSConst.Params.PARAMS_UIN_LIST);
                    String valueOf = String.valueOf(j3);
                    if (cmd != null) {
                        int hashCode = cmd.hashCode();
                        if (hashCode != 402538045) {
                            if (hashCode != 402538050) {
                                if (hashCode == 402538052 && cmd.equals("OidbSvc.0x8bb_9")) {
                                    b16 = 0;
                                }
                            } else if (cmd.equals("OidbSvc.0x8bb_7")) {
                                b16 = 2;
                            }
                        } else if (cmd.equals("OidbSvc.0x8bb_2")) {
                            b16 = 1;
                        }
                        if (longArray != null) {
                            for (long j16 : longArray) {
                                String valueOf2 = String.valueOf(j16);
                                if (!TextUtils.isEmpty(valueOf) && !TextUtils.isEmpty(valueOf2)) {
                                    ((IBizTroopMemberInfoService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IBizTroopMemberInfoService.class, "")).saveTroopMemberSpearkFlag(valueOf, valueOf2, b16);
                                }
                            }
                        }
                        notifyUI(1, true, new Object[]{cmd, 1, longArray});
                        return;
                    }
                    b16 = -100;
                    if (longArray != null) {
                    }
                    notifyUI(1, true, new Object[]{cmd, 1, longArray});
                    return;
                }
                notifyUI(1, false, new Object[]{cmd, 2, null});
                return;
            } catch (InvalidProtocolBufferMicroException unused) {
                notifyUI(1, false, new Object[]{cmd, 2, null});
                return;
            }
        }
        notifyUI(1, false, new Object[]{cmd, 2, null});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q2(boolean z16, Context context, String str, int i3) {
        if (z16) {
            QQToast.makeText(context, 2, str, 0).show(i3);
        } else {
            QQToast.makeText(context, R.drawable.f160605la, str, 0).show(i3);
        }
    }

    private final void H2(String cmd, ToServiceMsg req, FromServiceMsg resp, Object data) {
        if (req != null && resp != null) {
            long j3 = req.extraData.getLong("troopUin");
            StringBuilder sb5 = new StringBuilder();
            sb5.append(j3);
            String sb6 = sb5.toString();
            if (resp.getResultCode() != 1000) {
                notifyUI(3, false, new Object[]{3, null, sb6});
                return;
            }
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            try {
                Intrinsics.checkNotNull(data, "null cannot be cast to non-null type kotlin.ByteArray");
                oidb_sso$OIDBSSOPkg mergeFrom = oidb_sso_oidbssopkg.mergeFrom((byte[]) data);
                if (mergeFrom != null && mergeFrom.uint32_result.has() && mergeFrom.uint32_result.get() == 0 && mergeFrom.bytes_bodybuffer.has() && mergeFrom.bytes_bodybuffer.get() != null) {
                    oidb_0x8a0$RspBody oidb_0x8a0_rspbody = new oidb_0x8a0$RspBody();
                    try {
                        oidb_0x8a0_rspbody.mergeFrom(mergeFrom.bytes_bodybuffer.get().toByteArray());
                        List<oidb_0x8a0$KickResult> list = oidb_0x8a0_rspbody.rpt_msg_kick_result.get();
                        ArrayList arrayList = new ArrayList();
                        boolean z16 = true;
                        int i3 = 1;
                        for (oidb_0x8a0$KickResult oidb_0x8a0_kickresult : list) {
                            if (oidb_0x8a0_kickresult.opt_uint32_result.get() == 0) {
                                arrayList.add(String.valueOf(oidb_0x8a0_kickresult.opt_uint64_member_uin.get()));
                            } else {
                                i3 = oidb_0x8a0_kickresult.opt_uint32_result.get();
                                z16 = false;
                            }
                        }
                        if (arrayList.size() > 0) {
                            notifyUI(3, true, new Object[]{1, arrayList, sb6});
                            return;
                        } else {
                            if (z16) {
                                return;
                            }
                            notifyUI(3, z16, new Object[]{Integer.valueOf(i3), null, sb6});
                            return;
                        }
                    } catch (InvalidProtocolBufferMicroException unused) {
                        notifyUI(3, false, new Object[]{3, null, sb6});
                        return;
                    }
                }
                notifyUI(3, false, new Object[]{3, null, sb6});
                return;
            } catch (InvalidProtocolBufferMicroException unused2) {
                notifyUI(3, false, new Object[]{3, null, sb6});
                return;
            }
        }
        notifyUI(3, false, new Object[]{3, null, ""});
    }

    public final void M2(int type, long troopUin, List<Long> uinsToFocus) {
        String str;
        Intrinsics.checkNotNullParameter(uinsToFocus, "uinsToFocus");
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(2235);
        int i3 = 0;
        oidb_sso_oidbssopkg.uint32_result.set(0);
        oidb_0x8bb$ReqBody oidb_0x8bb_reqbody = new oidb_0x8bb$ReqBody();
        oidb_0x8bb$GroupConcernedInfo oidb_0x8bb_groupconcernedinfo = new oidb_0x8bb$GroupConcernedInfo();
        long[] jArr = new long[uinsToFocus.size()];
        if (type == 0) {
            int size = uinsToFocus.size();
            while (i3 < size) {
                oidb_0x8bb_groupconcernedinfo.rpt_uint64_default_uins.add(uinsToFocus.get(i3));
                jArr[i3] = uinsToFocus.get(i3).longValue();
                i3++;
            }
            oidb_sso_oidbssopkg.uint32_service_type.set(9);
        } else if (type == 1) {
            ArrayList arrayList = new ArrayList();
            int size2 = uinsToFocus.size();
            while (i3 < size2) {
                oidb_0x8bb$UinInfo oidb_0x8bb_uininfo = new oidb_0x8bb$UinInfo();
                oidb_0x8bb_uininfo.uint64_uin.set(uinsToFocus.get(i3).longValue());
                arrayList.add(oidb_0x8bb_uininfo);
                jArr[i3] = uinsToFocus.get(i3).longValue();
                i3++;
            }
            oidb_0x8bb_groupconcernedinfo.rpt_msg_concerned.set(arrayList);
            oidb_sso_oidbssopkg.uint32_service_type.set(2);
        } else {
            if (type != 2) {
                return;
            }
            ArrayList arrayList2 = new ArrayList();
            int size3 = uinsToFocus.size();
            while (i3 < size3) {
                oidb_0x8bb$ForbidUin oidb_0x8bb_forbiduin = new oidb_0x8bb$ForbidUin();
                oidb_0x8bb_forbiduin.uint64_uin.set(uinsToFocus.get(i3).longValue());
                arrayList2.add(oidb_0x8bb_forbiduin);
                jArr[i3] = uinsToFocus.get(i3).longValue();
                i3++;
            }
            oidb_0x8bb_groupconcernedinfo.rpt_msg_forbid_uins.set(arrayList2);
            oidb_sso_oidbssopkg.uint32_service_type.set(7);
        }
        oidb_0x8bb_groupconcernedinfo.uint64_group_code.set(troopUin);
        oidb_0x8bb$WriteReq oidb_0x8bb_writereq = new oidb_0x8bb$WriteReq();
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(oidb_0x8bb_groupconcernedinfo);
        oidb_0x8bb_writereq.rpt_msg_group_concerned.set(arrayList3);
        oidb_0x8bb_reqbody.msg_write_req.set(oidb_0x8bb_writereq);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_0x8bb_reqbody.toByteArray()));
        if (type == 1) {
            str = "OidbSvc.0x8bb_2";
        } else if (type != 2) {
            str = "OidbSvc.0x8bb_9";
        } else {
            str = "OidbSvc.0x8bb_7";
        }
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin(), str);
        toServiceMsg.extraData.putLong("troopUin", troopUin);
        toServiceMsg.extraData.putLongArray(SquareJSConst.Params.PARAMS_UIN_LIST, jArr);
        toServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
        sendPbReq(toServiceMsg);
    }
}
