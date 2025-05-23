package com.tencent.mobileqq.zplan.show;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.aio.event.ZPlanMsgEvent;
import com.tencent.mobileqq.zplan.show.IZPlanMsgService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqnt.kernel.api.ag;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.IKernelGetUidInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgAttributeInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.TextElement;
import com.tencent.qqnt.kernel.nativeinterface.ZPlanMsgElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.state.report.SquareReportConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0016\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rJ\u0018\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\u0016\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/zplan/show/g;", "", "", "eventKey", "", "source", "", "e", "d", "Lcom/tencent/mobileqq/zplan/show/IZPlanMsgService$b;", "msg", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgAttributeInfo;", "c", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "i", "Landroid/content/Context;", "context", "Landroid/view/View;", "anchorView", "j", "uin", "f", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f335631a = new g();

    g() {
    }

    private final MsgAttributeInfo c(IZPlanMsgService.ZPlanActionMsg msg2) {
        return com.tencent.qqnt.kernel.util.a.c(com.tencent.qqnt.kernel.util.a.f359256a, 11, 0L, null, null, null, null, null, null, null, null, null, null, new ZPlanMsgElement(msg2.getMasterActionId(), msg2.getGuestActionId(), msg2.getActionType(), new byte[0]), null, null, null, null, null, null, 520190, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(String uin, IZPlanMsgService.ZPlanActionMsg msg2, HashMap hashMap) {
        ArrayList<MsgElement> arrayListOf;
        Intrinsics.checkNotNullParameter(uin, "$uin");
        Intrinsics.checkNotNullParameter(msg2, "$msg");
        String str = (String) hashMap.get(Long.valueOf(Long.parseLong(uin)));
        if (str != null) {
            Contact contact = new Contact(1, str, "");
            TextElement textElement = new TextElement();
            textElement.content = msg2.getActionName();
            MsgElement msgElement = new MsgElement();
            msgElement.elementType = 1;
            msgElement.textElement = textElement;
            HashMap<Integer, MsgAttributeInfo> hashMap2 = new HashMap<>();
            hashMap2.put(11, f335631a.c(msg2));
            w e16 = com.tencent.qqnt.msg.f.e();
            if (e16 != null) {
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(msgElement);
                e16.sendMsg(0L, contact, arrayListOf, hashMap2, new IOperateCallback() { // from class: com.tencent.mobileqq.zplan.show.f
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                    public final void onResult(int i3, String str2) {
                        g.h(i3, str2);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(int i3, String str) {
        QLog.d("ZPlanSuperQQShowSendHelper", 1, "ZPlanSuperQQShowSendHelper.sendActionMsg = " + i3 + ", err = " + str);
    }

    public final void f(final String uin, final IZPlanMsgService.ZPlanActionMsg msg2) {
        HashSet<Long> hashSetOf;
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        hashSetOf = SetsKt__SetsKt.hashSetOf(Long.valueOf(Long.parseLong(uin)));
        ag l3 = com.tencent.qqnt.msg.f.l();
        if (l3 != null) {
            l3.getUid(hashSetOf, new IKernelGetUidInfoCallback() { // from class: com.tencent.mobileqq.zplan.show.e
                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGetUidInfoCallback
                public final void onResult(HashMap hashMap) {
                    g.g(uin, msg2, hashMap);
                }
            });
        }
    }

    public final void i(int source, com.tencent.aio.api.runtime.a aioContext) {
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        if (xh3.a.f448008a.a()) {
            return;
        }
        aioContext.e().h(new ZPlanMsgEvent.ShowBubbleTipEvent(new ZPlanMsgEvent.a(d(source), 0, 0.0f, 0, 0L, 30, null)));
        e("imp", source);
    }

    public final void j(Context context, View anchorView) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (xh3.a.f448008a.a() || anchorView == null) {
            return;
        }
        ZPlanMsgEvent.a aVar = new ZPlanMsgEvent.a(d(8), 0, 0.0f, 0, 0L, 30, null);
        com.tencent.mobileqq.widget.tip.a r16 = com.tencent.mobileqq.widget.tip.a.r(context);
        r16.S(anchorView);
        r16.k0(1);
        r16.R(0);
        r16.o0(aVar.c());
        r16.p0(aVar.d());
        r16.q0(aVar.e());
        r16.b0(aVar.b());
        r16.f0(false);
        r16.W(aVar.a());
        r16.j0(10.0f, 8.0f, 10.0f, 8.0f);
        r16.s0();
    }

    private final void e(String eventKey, int source) {
        Map mapOf;
        try {
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY), TuplesKt.to("zplan_guide_toast_source", Integer.valueOf(source)), TuplesKt.to("zplan_action_type", eventKey));
            VideoReport.reportEvent("ev_zplan_guide_toast", mapOf);
        } catch (Exception e16) {
            QLog.e("ZPlanShowGuideDialogFragment", 2, "ZPlanShowGuideDialogFragment\uff1areport error = " + e16);
        }
    }

    private final String d(int source) {
        if (source == 7) {
            return "\u53ef\u5728\u8fd9\u5f00\u542f\u597d\u53cb\u65f6\u5149";
        }
        if (source != 8) {
            return "\u8981\u5148\u5f00\u542f\u597d\u53cb\u65f6\u5149\u54e6";
        }
        return "\u53ef\u5728\u8fd9\u5173\u95ed\u597d\u53cb\u65f6\u5149";
    }
}
