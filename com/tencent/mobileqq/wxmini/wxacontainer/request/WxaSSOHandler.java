package com.tencent.mobileqq.wxmini.wxacontainer.request;

import NS_QWEB_PROTOCAL.PROTOCAL;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.common.app.AppInterface;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.wxmini.pb.UserGrowGuard$CommonExt;
import com.tencent.mobileqq.wxmini.pb.UserGrowGuard$GuardInstruction;
import com.tencent.mobileqq.wxmini.pb.UserGrowGuard$JudgeTimingReq;
import com.tencent.mobileqq.wxmini.pb.UserGrowGuard$JudgeTimingRsp;
import com.tencent.mobileqq.wxmini.pb.UserGrowGuard$ReportExecuteReq;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.PlatformInfor;
import cooperation.qzone.QUA;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import lb3.GuardInstruction;
import lb3.JudgeTimingData;
import mqq.app.NewIntent;
import nb3.a;
import nb3.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 22\u00020\u0001:\u00013B\u000f\u0012\u0006\u0010,\u001a\u00020%\u00a2\u0006\u0004\b1\u0010+J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0014\u0010\f\u001a\u00020\u00062\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\nH\u0002J\"\u0010\u0010\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0006H\u0002J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J&\u0010\u0015\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u0018\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0017\u0018\u00010\u0016H\u0014J6\u0010!\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u001fJ \u0010$\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\"2\b\u0010 \u001a\u0004\u0018\u00010\u001fR\"\u0010,\u001a\u00020%8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/wxmini/wxacontainer/request/WxaSSOHandler;", "Lcom/tencent/mobileqq/app/BusinessHandler;", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "req", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "res", "", "data", "", "F2", "Lcom/tencent/mobileqq/pb/MessageMicro;", Const.BUNDLE_KEY_REQUEST, "E2", "", "type", WebViewPlugin.KEY_RESPONSE, Constants.BASE_IN_PLUGIN_VERSION, "", "", "getCommandList", "", "onReceive", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/app/BusinessObserver;", "observerClass", "appId", "factType", "Lcom/tencent/mobileqq/wxmini/pb/UserGrowGuard$CommonExt;", "ext", "duration", "totalTime", "Lnb3/a;", "observer", Constants.MMCCID, "Llb3/h;", "instruction", "H2", "Lcom/tencent/common/app/AppInterface;", "d", "Lcom/tencent/common/app/AppInterface;", "getApp", "()Lcom/tencent/common/app/AppInterface;", "setApp", "(Lcom/tencent/common/app/AppInterface;)V", "app", "Ljava/util/concurrent/atomic/AtomicLong;", "e", "Ljava/util/concurrent/atomic/AtomicLong;", "sIndexCounter", "<init>", "f", "a", "wxmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class WxaSSOHandler extends BusinessHandler {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private AppInterface app;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final AtomicLong sIndexCounter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WxaSSOHandler(AppInterface app) {
        super(app);
        Intrinsics.checkNotNullParameter(app, "app");
        this.app = app;
        this.sIndexCounter = new AtomicLong(0L);
    }

    private final byte[] D2(ToServiceMsg req, int type, byte[] responseData) {
        PROTOCAL.StQWebRsp stQWebRsp = new PROTOCAL.StQWebRsp();
        stQWebRsp.mergeFrom(responseData);
        if (stQWebRsp.retCode.get() != 0) {
            QLog.e("[wxa-q]WxaSSOHandler", 1, req.getServiceCmd() + " error " + stQWebRsp.retCode.get() + " msg:" + stQWebRsp.errMsg.get());
            notifyUI(req, type, false, (Object) stQWebRsp.errMsg.get());
            return null;
        }
        return stQWebRsp.busiBuff.get().toByteArray();
    }

    private final byte[] E2(MessageMicro<?> request) {
        PROTOCAL.StQWebReq stQWebReq = new PROTOCAL.StQWebReq();
        stQWebReq.Seq.set(this.sIndexCounter.incrementAndGet());
        stQWebReq.qua.set(QUA.getQUA3());
        stQWebReq.deviceInfo.set(PlatformInfor.g().getDeviceInfor());
        stQWebReq.busiBuff.set(ByteStringMicro.copyFrom(request.toByteArray()));
        byte[] byteArray = stQWebReq.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "webReq.toByteArray()");
        return byteArray;
    }

    public final void G2(String appId, int factType, UserGrowGuard$CommonExt ext, int duration, int totalTime, a observer) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(ext, "ext");
        Intrinsics.checkNotNullParameter(observer, "observer");
        UserGrowGuard$JudgeTimingReq userGrowGuard$JudgeTimingReq = new UserGrowGuard$JudgeTimingReq();
        userGrowGuard$JudgeTimingReq.ext_info.set(ext);
        userGrowGuard$JudgeTimingReq.appid.set(appId);
        userGrowGuard$JudgeTimingReq.fact_type.set(factType);
        userGrowGuard$JudgeTimingReq.duration.set(duration);
        userGrowGuard$JudgeTimingReq.total_time.set(totalTime);
        ToServiceMsg createToServiceMsg = createToServiceMsg("miniapp.trpc.wxgame.user_grow_guard.UserGrowGuard.JudgeTiming", observer, true);
        createToServiceMsg.putWupBuffer(E2(userGrowGuard$JudgeTimingReq));
        sendPbReq(createToServiceMsg);
        NewIntent newIntent = new NewIntent(this.app.getApp(), b.class);
        newIntent.putExtra(ToServiceMsg.class.getSimpleName(), createToServiceMsg);
        this.app.startServlet(newIntent);
    }

    public final void H2(String appId, GuardInstruction instruction, a observer) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(instruction, "instruction");
        UserGrowGuard$ReportExecuteReq userGrowGuard$ReportExecuteReq = new UserGrowGuard$ReportExecuteReq();
        userGrowGuard$ReportExecuteReq.appid.set(appId);
        userGrowGuard$ReportExecuteReq.instr_trace_id.set(instruction.getTraceId());
        userGrowGuard$ReportExecuteReq.exec_time.set(System.currentTimeMillis() / 1000);
        userGrowGuard$ReportExecuteReq.rule_name.set(instruction.getRuleName());
        ToServiceMsg createToServiceMsg = createToServiceMsg("miniapp.trpc.wxgame.user_grow_guard.UserGrowGuard.ReportExecute", observer);
        createToServiceMsg.putWupBuffer(E2(userGrowGuard$ReportExecuteReq));
        sendPbReq(createToServiceMsg);
        NewIntent newIntent = new NewIntent(this.app.getApp(), b.class);
        newIntent.putExtra(ToServiceMsg.class.getSimpleName(), createToServiceMsg);
        this.app.startServlet(newIntent);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("miniapp.trpc.wxgame.user_grow_guard.UserGrowGuard.JudgeTiming");
            this.allowCmdSet.add("miniapp.trpc.wxgame.user_grow_guard.UserGrowGuard.ReportExecute");
        }
        Set<String> allowCmdSet = this.allowCmdSet;
        Intrinsics.checkNotNullExpressionValue(allowCmdSet, "allowCmdSet");
        return allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return null;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg req, FromServiceMsg res, Object data) {
        Intrinsics.checkNotNull(res);
        if (msgCmdFilter(res.getServiceCmd())) {
            if (QLog.isColorLevel()) {
                QLog.d("[wxa-q]WxaSSOHandler", 2, "cmdfilter error=" + res.getServiceCmd());
                return;
            }
            return;
        }
        res.getBusinessFailCode();
        res.getBusinessFailMsg();
        if (Intrinsics.areEqual("miniapp.trpc.wxgame.user_grow_guard.UserGrowGuard.JudgeTiming", req != null ? req.getServiceCmd() : null)) {
            F2(req, res, (byte[]) data);
            return;
        }
        if (Intrinsics.areEqual("miniapp.trpc.wxgame.user_grow_guard.UserGrowGuard.ReportExecute", req != null ? req.getServiceCmd() : null)) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("handleReportExecute result:");
            sb5.append(!res.isSuccess() || data == null);
            QLog.i("[wxa-q]WxaSSOHandler", 1, sb5.toString());
        }
    }

    private final void F2(ToServiceMsg req, FromServiceMsg res, byte[] data) {
        if (res.isSuccess() && data != null) {
            byte[] D2 = D2(req, 1, data);
            UserGrowGuard$JudgeTimingRsp userGrowGuard$JudgeTimingRsp = new UserGrowGuard$JudgeTimingRsp();
            MessageMicro.mergeFrom(userGrowGuard$JudgeTimingRsp, D2);
            UserGrowGuard$CommonExt lastExt = userGrowGuard$JudgeTimingRsp.ext_info.get();
            int i3 = userGrowGuard$JudgeTimingRsp.next_duration.get();
            List<UserGrowGuard$GuardInstruction> instruction = userGrowGuard$JudgeTimingRsp.instructions.get();
            ArrayList arrayList = new ArrayList();
            Intrinsics.checkNotNullExpressionValue(instruction, "instruction");
            for (Iterator it = instruction.iterator(); it.hasNext(); it = it) {
                UserGrowGuard$GuardInstruction userGrowGuard$GuardInstruction = (UserGrowGuard$GuardInstruction) it.next();
                int i16 = userGrowGuard$GuardInstruction.type.get();
                String str = userGrowGuard$GuardInstruction.title.get();
                String str2 = userGrowGuard$GuardInstruction.f327804msg.get();
                String str3 = userGrowGuard$GuardInstruction.url.get();
                int i17 = userGrowGuard$GuardInstruction.modal.get();
                String str4 = userGrowGuard$GuardInstruction.data.get();
                String str5 = userGrowGuard$GuardInstruction.rule_name.get();
                String str6 = userGrowGuard$GuardInstruction.rule_family.get();
                long j3 = userGrowGuard$GuardInstruction.logout_time.get();
                String str7 = userGrowGuard$GuardInstruction.instr_trace_id.get();
                Intrinsics.checkNotNullExpressionValue(str7, "instructiosn.instr_trace_id.get()");
                String str8 = userGrowGuard$GuardInstruction.btn_text.get();
                Intrinsics.checkNotNullExpressionValue(str8, "instructiosn.btn_text.get()");
                arrayList.add(new GuardInstruction(i16, str, str2, str3, i17, str4, str5, str6, j3, str7, str8, userGrowGuard$GuardInstruction.report_scene.get()));
            }
            Intrinsics.checkNotNullExpressionValue(lastExt, "lastExt");
            notifyUI(req, 1, true, (Object) new JudgeTimingData(lastExt, i3, arrayList));
            return;
        }
        QLog.e("[wxa-q]WxaSSOHandler", 1, "handleJudgeTiming error");
        notifyUI(req, 1, false, (Object) res.getBusinessFailMsg());
    }
}
