package com.qq.e.comm.plugin.tangramsplash.fusionsdkimpl;

import com.qq.e.comm.util.GDTLogger;
import com.tencent.ams.fusion.service.event.Subscriber;
import com.tencent.ams.fusion.service.event.ThreadMode;
import com.tencent.ams.fusion.service.event.impl.b;
import com.tencent.biz.qqcircle.immersive.constants.QFSNumberConstants;
import com.tencent.luggage.wxa.yf.t;
import com.tencent.luggage.wxa.yf.u;
import com.tencent.mobileqq.app.LocaleManager;
import java.util.HashMap;
import java.util.Map;
import org.apache.httpcore.HttpStatus;

/* compiled from: P */
/* loaded from: classes3.dex */
public class SplashEventHandlerCenter {
    private static final int FUSION_STEP_DYNAMIC = 3;
    private static final int FUSION_STEP_PRELOAD = 2;
    private static final int FUSION_STEP_SELECT_ORDER = 1;
    private Map<Integer, Integer> preloadMappingList = new HashMap<Integer, Integer>() { // from class: com.qq.e.comm.plugin.tangramsplash.fusionsdkimpl.SplashEventHandlerCenter.1
        {
            put(400, 1310101);
            put(401, 1310102);
            put(402, 1310103);
            put(410, 1310160);
            put(411, 1310161);
            put(412, 1310162);
            put(420, 1310163);
            put(421, 1310164);
            put(422, 1310165);
            put(428, 1310166);
            put(Integer.valueOf(HttpStatus.SC_TOO_MANY_REQUESTS), 1310167);
            put(430, 1310168);
            put(431, 1310169);
            put(432, 1310170);
            put(433, 1310171);
            put(450, 1310172);
            put(451, 1310173);
            put(452, 1310174);
            put(Integer.valueOf(t.CTRL_INDEX), 1310175);
            put(Integer.valueOf(u.CTRL_INDEX), 1310176);
            put(455, 1310177);
            put(Integer.valueOf(QFSNumberConstants.Int.NUM_456), 1310178);
            put(457, 1310179);
            put(458, 1310180);
            put(459, 1310181);
            put(Integer.valueOf(LocaleManager.MOBILE_COUNTRY_CODE_CN_INT), 1310182);
            put(461, 1310183);
        }
    };
    private Map<Integer, Integer> selectOrderMappingList = new HashMap<Integer, Integer>() { // from class: com.qq.e.comm.plugin.tangramsplash.fusionsdkimpl.SplashEventHandlerCenter.2
        {
            put(1, 1310221);
            put(2, 1310203);
            put(4, 1310223);
            put(6, 1310222);
            put(108, 1311215);
            put(109, 1310227);
            put(110, 1310228);
            put(111, 1310208);
            put(112, 1310271);
            put(115, 1310272);
            put(103, 1310205);
            put(104, 1310206);
            put(105, 1310207);
            put(113, 1311202);
            put(114, 1310274);
            put(117, 1311218);
            put(118, 1310226);
            put(3, 1310217);
            put(7, 1310218);
            put(100, 1310211);
            put(101, 1310204);
            put(102, 1310242);
            put(106, 1310248);
            put(107, 1310253);
            put(129, 1311201);
            put(121, 1311203);
            put(122, 1311204);
            put(123, 1311205);
            put(126, 1311208);
            put(132, 1311219);
            put(133, 1311220);
            put(134, 1311221);
            put(135, 1311222);
            put(130, 1311216);
            put(131, 1311217);
            put(124, 1311207);
            put(125, 1311206);
            put(127, 1311209);
            put(128, 1311210);
            put(303, 1311211);
            put(304, 1311212);
            put(305, 1311213);
            put(1001, 1311214);
            put(306, 1311214);
            put(300, 1311214);
            put(903, 1310231);
            put(198, 1311300);
            put(199, 1311301);
            put(136, 1310402);
            put(159, 1310403);
            put(160, 1310404);
            put(161, 1310405);
        }
    };

    @Subscriber(threadMode = ThreadMode.BACKGROUND)
    public void handleReportEvent(com.tencent.ams.fusion.service.event.impl.b bVar) {
        int i3;
        int i16;
        if (bVar == null) {
            return;
        }
        Integer num = this.selectOrderMappingList.get(Integer.valueOf(bVar.f70286b));
        if (num == null || num.intValue() == 0) {
            num = this.preloadMappingList.get(Integer.valueOf(bVar.f70286b));
        }
        if (num != null) {
            i3 = num.intValue();
        } else {
            i3 = 0;
        }
        int i17 = i3;
        if (i17 == 0) {
            return;
        }
        if (this.preloadMappingList.containsValue(Integer.valueOf(i17))) {
            i16 = 2;
        } else {
            i16 = 1;
        }
        int i18 = i16;
        b.c cVar = bVar.f70289e;
        String str = cVar.f70299a;
        b.a aVar = bVar.f70288d;
        String str2 = aVar.f70291a;
        String str3 = aVar.f70292b;
        String str4 = aVar.f70293c;
        b.C0676b c0676b = bVar.f70290f;
        com.qq.e.comm.plugin.tangramsplash.report.c.a(i17, str, str2, str3, str4, c0676b.f70294a, cVar.f70300b, (int) bVar.f70287c, c0676b.f70295b, c0676b.f70298e, i18, c0676b.f70296c, c0676b.f70297d);
    }

    @Subscriber(threadMode = ThreadMode.BACKGROUND)
    public void handleReportSplashDynamicEvent(com.tencent.ams.fusion.service.event.impl.b bVar) {
        if (bVar != null && !bVar.f70285a) {
            GDTLogger.d("handleReportSplashDynamicEvent " + bVar.toString());
            int i3 = bVar.f70286b;
            b.c cVar = bVar.f70289e;
            String str = cVar.f70299a;
            b.a aVar = bVar.f70288d;
            String str2 = aVar.f70291a;
            String str3 = aVar.f70292b;
            b.C0676b c0676b = bVar.f70290f;
            com.qq.e.comm.plugin.tangramsplash.report.c.a(i3, str, str2, str3, c0676b.f70294a, cVar.f70300b, (int) bVar.f70287c, c0676b.f70295b, c0676b.f70298e, 3);
        }
    }
}
