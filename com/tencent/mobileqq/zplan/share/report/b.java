package com.tencent.mobileqq.zplan.share.report;

import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.zplan.share.ZPlanShareLaunchParam;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.report.ExtItem;
import com.tencent.sqshow.zootopia.report.MsgBodyContent;
import com.tencent.sqshow.zootopia.report.ReportMsgBean;
import com.tencent.sqshow.zootopia.report.ReportMsgInfo;
import com.tencent.sqshow.zootopia.utils.ah;
import com.tencent.sqshow.zootopia.utils.w;
import com.tencent.state.report.SquareReportConst;
import java.util.ArrayList;
import java.util.Map;
import k74.i;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J$\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001c\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/zplan/share/report/b;", "Lcom/tencent/mobileqq/zplan/share/report/a;", "", "channelID", "Lcom/tencent/mobileqq/zplan/share/ZPlanShareLaunchParam;", ConstantsAPI.Token.WX_LAUNCH_PARAM_KEY, "", "o", "Lcom/tencent/sqshow/zootopia/report/ReportMsgBean;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "", "", DomainData.DOMAIN_NAME, "d", tl.h.F, "<init>", "()V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class b extends a {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/zplan/share/report/b$b", "Lrh3/b;", "", "onSuccess", "", "errorCode", "", "msg", "onFailed", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.share.report.b$b, reason: collision with other inner class name */
    /* loaded from: classes34.dex */
    public static final class C9203b implements rh3.b {
        C9203b() {
        }

        @Override // rh3.b
        public void onFailed(int errorCode, String msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QLog.e("DressShareReporter", 1, "report fail " + errorCode + ", " + msg2);
        }

        @Override // rh3.b
        public void onSuccess() {
            QLog.d("DressShareReporter", 1, "report success");
        }
    }

    public b() {
        l(new ShareReportCommonInfo("pg_zplan_dress_share", SquareReportConst.ElementId.ELEMENT_ID_FRIEND_STATUS_PANEL_CLOSE, "zplan_content_type", "ev_zplan_outfit_content_share_success", SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, "zplan_share_channel"));
    }

    private final ReportMsgBean m(int channelID, ZPlanShareLaunchParam launchParam) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, Object> entry : n(channelID, launchParam).entrySet()) {
            arrayList.add(new ExtItem(entry.getKey(), entry.getValue().toString()));
        }
        ReportMsgInfo reportMsgInfo = new ReportMsgInfo(kb4.a.f411993a.b(), 8005, new MsgBodyContent(w.f373306a.b(), System.currentTimeMillis(), arrayList));
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(reportMsgInfo);
        return new ReportMsgBean(arrayList2);
    }

    private final void o(int channelID, ZPlanShareLaunchParam launchParam) {
        String str;
        Object obj;
        ReportMsgBean m3 = m(channelID, launchParam);
        QLog.d("DressShareReporter", 1, "report msg " + m3);
        ((rh3.a) i.INSTANCE.a(rh3.a.class)).reportMsg(m3, new C9203b());
        kb4.a aVar = kb4.a.f411993a;
        Map<String, Object> bizExtraParams = launchParam.getBizExtraParams();
        if (bizExtraParams == null || (obj = bizExtraParams.get("KEY_DRESS_KEY_ID")) == null || (str = obj.toString()) == null) {
            str = "";
        }
        kb4.a.g(aVar, str, 1, null, null, 12, null);
    }

    @Override // com.tencent.mobileqq.zplan.share.report.a, com.tencent.mobileqq.zplan.share.report.c
    public void d(int channelID, ZPlanShareLaunchParam launchParam) {
        Intrinsics.checkNotNullParameter(launchParam, "launchParam");
        super.d(channelID, launchParam);
        o(channelID, launchParam);
    }

    @Override // com.tencent.mobileqq.zplan.share.report.a
    public Map<String, Object> h(ZPlanShareLaunchParam launchParam) {
        Object obj;
        Object obj2;
        Map<String, Object> mutableMapOf;
        Intrinsics.checkNotNullParameter(launchParam, "launchParam");
        Pair[] pairArr = new Pair[3];
        pairArr[0] = TuplesKt.to(i().getKeyExternalEntrance(), ah.b(launchParam.getSource()));
        Map<String, Object> bizExtraParams = launchParam.getBizExtraParams();
        if (bizExtraParams == null || (obj = bizExtraParams.get("KEY_DRESS_KEY_ID")) == null) {
            obj = -1;
        }
        pairArr[1] = TuplesKt.to("zplan_content_id", obj.toString());
        Map<String, Object> bizExtraParams2 = launchParam.getBizExtraParams();
        if (bizExtraParams2 == null || (obj2 = bizExtraParams2.get("KEY_DRESS_KEY_CONTENT_TYPE")) == null) {
            obj2 = "";
        }
        pairArr[2] = TuplesKt.to("zplan_content_type", obj2.toString());
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        return mutableMapOf;
    }

    private final Map<String, Object> n(int channelID, ZPlanShareLaunchParam launchParam) {
        Object obj;
        Object obj2;
        Map<String, Object> mutableMapOf;
        Pair[] pairArr = new Pair[5];
        pairArr[0] = TuplesKt.to(i().getKeyShareChannel(), Integer.valueOf(channelID));
        pairArr[1] = TuplesKt.to(i().getKeyExternalEntrance(), ah.b(launchParam.getSource()));
        Map<String, Object> bizExtraParams = launchParam.getBizExtraParams();
        if (bizExtraParams == null || (obj = bizExtraParams.get("KEY_DRESS_KEY_ID")) == null) {
            obj = -1;
        }
        pairArr[2] = TuplesKt.to("id", obj.toString());
        Map<String, Object> bizExtraParams2 = launchParam.getBizExtraParams();
        if (bizExtraParams2 == null || (obj2 = bizExtraParams2.get("KEY_DRESS_KEY_FEED_ID")) == null) {
            obj2 = "";
        }
        pairArr[3] = TuplesKt.to("feed_id", obj2.toString());
        pairArr[4] = TuplesKt.to("zplan_content_type", String.valueOf(launchParam.getContentType()));
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        return mutableMapOf;
    }
}
