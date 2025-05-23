package com.tencent.qqnt.pluspanel.processor;

import android.content.Intent;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.tencent.aio.data.AIOSession;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qwallet.transaction.impl.NotifyMsgApiImpl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.IKernelGetUinInfoCallback;
import com.tencent.qqnt.pluspanel.data.msg.PlusPanelEvent;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.HashMap;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.LogUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/pluspanel/processor/ae;", "Lcom/tencent/qqnt/pluspanel/logic/b;", "", "uin", "Lmqq/app/AppRuntime;", "app", "Lcom/tencent/aio/api/runtime/a;", "context", "", "d", "Lcom/tencent/qqnt/pluspanel/data/a;", "data", "a", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ae implements com.tencent.qqnt.pluspanel.logic.b {

    /* renamed from: a, reason: collision with root package name */
    private static final a f360502a = new a(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/pluspanel/processor/ae$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(AIOSession session, ae this$0, AppRuntime app, com.tencent.aio.api.runtime.a context, HashMap hashMap) {
        Intrinsics.checkNotNullParameter(session, "$session");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        Long l3 = hashMap != null ? (Long) hashMap.get(session.c().j()) : null;
        QLog.d("TransferOnClickProcessor", 1, "onClick uin:" + LogUtil.wrapLogUin(String.valueOf(l3)));
        if (l3 != null) {
            l3.longValue();
            long longValue = l3.longValue();
            Intrinsics.checkNotNullExpressionValue(app, "app");
            this$0.d(longValue, app, context);
        }
    }

    @Override // com.tencent.qqnt.pluspanel.logic.b
    public void a(com.tencent.qqnt.pluspanel.data.a data, final com.tencent.aio.api.runtime.a context) {
        HashSet<String> hashSetOf;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(context, "context");
        context.e().h(PlusPanelEvent.UpdatePlusPanel.f360444d);
        final AIOSession r16 = context.g().r();
        final AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!(peekAppRuntime instanceof QQAppInterface)) {
            QLog.e("TransferOnClickProcessor", 1, "need QQAppInterface");
            return;
        }
        com.tencent.qqnt.kernel.api.ag uixConvertService = ((IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")).getUixConvertService();
        Intrinsics.checkNotNull(uixConvertService, "null cannot be cast to non-null type com.tencent.qqnt.kernel.api.IUixConvertService");
        hashSetOf = SetsKt__SetsKt.hashSetOf(r16.c().j());
        uixConvertService.getUin(hashSetOf, new IKernelGetUinInfoCallback() { // from class: com.tencent.qqnt.pluspanel.processor.ad
            @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGetUinInfoCallback
            public final void onResult(HashMap hashMap) {
                ae.c(AIOSession.this, this, peekAppRuntime, context, hashMap);
            }
        });
    }

    private final void d(long uin, AppRuntime app, com.tencent.aio.api.runtime.a context) {
        FragmentActivity requireActivity = context.c().requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "context.fragment.requireActivity()");
        String valueOf = String.valueOf(uin);
        int c16 = com.tencent.nt.adapter.session.c.c(context.g().r().c().e());
        String g16 = context.g().r().c().g();
        Intent intent = new Intent();
        intent.putExtra("come_from", 2);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(IProfileProtocolConst.PARAM_TARGET_UIN, valueOf);
            jSONObject.put("targetNickname", g16);
            jSONObject.put("sign", "");
            jSONObject.put(NotifyMsgApiImpl.KEY_GROUP_TYPE, 0);
            if (!TextUtils.isEmpty(null)) {
                jSONObject.put("groupUin", (Object) null);
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        intent.putExtra("extra_data", jSONObject.toString());
        intent.putExtra(com.tencent.mobileqq.msf.core.c0.j.T0, "appid#20000001|bargainor_id#1000026901|channel#aio");
        intent.putExtra("isJumpToH5", false);
        RouteUtils.startActivity(requireActivity, intent, "/qwallet/transaction");
        ReportController.o(app, "P_CliOper", "Vip_pay_mywallet", "", QCircleDaTongConstant.ElementParamValue.WALLET, "transferAIOclick", 0, 0, "", "", "", "");
        Intrinsics.checkNotNull(app, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        l61.a.b((QQAppInterface) app, "0X8005CB0", c16);
    }
}
