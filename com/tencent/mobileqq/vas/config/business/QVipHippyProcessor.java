package com.tencent.mobileqq.vas.config.business;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import com.tencent.mobileqq.config.ai;
import com.tencent.mobileqq.config.am;
import com.tencent.mobileqq.vas.IConfigProxy;
import com.tencent.mobileqq.vas.config.business.QVipHippyConfig;
import com.tencent.mobileqq.vas.config.business.qvip.BaseQVipConfigProcessor;
import com.tencent.mobileqq.vas.toggle.VasLongToggle;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

/* loaded from: classes20.dex */
public class QVipHippyProcessor extends BaseQVipConfigProcessor<QVipHippyConfig> {

    /* renamed from: a, reason: collision with root package name */
    private static QVipHippyConfig f308945a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class a extends TypeToken<Map<String, QVipHippyConfig.HippyInfo>> {
        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class b extends TypeToken<Map<String, QVipHippyConfig.HippyInfo>> {
        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class c extends TypeToken<Map<String, QVipHippyConfig.HippyInfo>> {
        c() {
        }
    }

    public static QVipHippyConfig a() {
        IConfigProxy iConfigProxy = VasLongToggle.HIPPY_CONFIG;
        if (iConfigProxy.isEnable(true)) {
            QVipHippyConfig qVipHippyConfig = f308945a;
            if (qVipHippyConfig != null) {
                return qVipHippyConfig;
            }
            try {
                String stringData = iConfigProxy.getStringData("{\"_VAS_DEBUG_DEMO_\":{\"enableDomain\":[\"vip.qq.com\",\"qun.qq.com\"]},\"VasGuideQqgxhRecall\":{\"enableDomain\":[\"vip.qq.com\",\"qun.qq.com\"]},\"VasGuideQqgxhRecallV2\":{\"enableDomain\":[\"vip.qq.com\",\"qun.qq.com\"]},\"VasGuideQqgxhProfileDisplay\":{\"enableDomain\":[\"vip.qq.com\",\"qun.qq.com\"]},\"VasGuideQqgxhProfileDisplayV2\":{\"enableDomain\":[\"vip.qq.com\",\"qun.qq.com\"]},\"VasGuideClmFloating\":{\"enableDomain\":[\"vip.qq.com\",\"qun.qq.com\"]},\"QQVipSSR\":{\"enableDomain\":[\"vip.qq.com\",\"qzone.qq.com\"]},\"QQVip\":{\"enableDomain\":[\"vip.qq.com\",\"qzone.qq.com\"],\"openParams\":{\"url\":\"https://club.vip.qq.com/index?_wv=16778247&_wwv=68&_wvx=10&_proxy=1&page_from=qqchouti\",\"errorUrl\":\"https://club.vip.qq.com/index?_wv=16778247&_wwv=68&_wvx=10&_proxy=1&from=hippy_error\",\"isCustomNightMode\":true,\"isPreload\":true,\"isPreloadWhenClosed\":true,\"isPredraw\":true,\"isPredrawWhenClosed\":true,\"isAnimated\":true,\"bundleName\":\"QQVip\",\"domain\":\"vip.qq.com\"}},\"QQVipV2\":{\"enableDomain\":[\"vip.qq.com\",\"qzone.qq.com\"],\"openParams\":{\"bundleName\":\"QQVipV2\",\"domain\":\"vip.qq.com\",\"url\":\"https://club.vip.qq.com/index?_wv=16778247&_wwv=68&_wvx=10&_proxy=1&page_from=qqchouti&page=home&_ffs=https%3A%2F%2Fclub.vip.qq.com%2Fhippy-ssr%2Fdist%2Fall%2Fhome.ffs.ios.js\",\"errorUrl\":\"https://club.vip.qq.com/index?_wv=16778247&_wwv=68&_wvx=10&_proxy=1&from=hippy_error\"}},\"QQVipAggregation\":{\"enableDomain\":[\"vip.qq.com\",\"qzone.qq.com\"],\"openParams\":{\"url\":\"https://club.vip.qq.com/card?_wv=16778247&_wwv=68&_wvx=10&_proxy=1&from=config\",\"errorUrl\":\"https://club.vip.qq.com/card?_wv=16778247&_wwv=68&_wvx=10&_proxy=1&from=hippy_error\",\"isCustomNightMode\":true,\"isPreload\":true,\"isPreloadWhenClosed\":true,\"isPredraw\":true,\"isPredrawWhenClosed\":true,\"isAnimated\":true,\"bundleName\":\"QQVipAggregation\",\"domain\":\"vip.qq.com\"}},\"qqgxh\":{\"enableDomain\":[\"vip.qq.com\"],\"openParams\":{\"url\":\"https://zb.vip.qq.com/v2/home?_wv=5123&_wwv=128&_proxy=1&ADTAG=mobileqq.drawer&trace_detail=base64-eyJhcHBpZCI6Im91dHNpZGUiLCJwYWdlX2lkIjoiMyJ9\",\"errorUrl\":\"https://zb.vip.qq.com/v2/home?_wv=5123&_wwv=128&_proxy=1&ADTAG=mobileqq.drawer&trace_detail=base64-eyJhcHBpZCI6Im91dHNpZGUiLCJwYWdlX2lkIjoiMyJ9\",\"isCustomNightMode\":true,\"isPreloadWhenClosed\":true,\"isPredraw\":true,\"isPredrawWhenClosed\":true,\"isAnimated\":true,\"bundleName\":\"qqgxh\",\"domain\":\"vip.qq.com\"}},\"QQVipPay\":{\"enableDomain\":[\"vip.qq.com\"]},\"qqSport\":{\"enableDomain\":[\"yundong.qq.com\"]},\"qqdhy\":{\"enableDomain\":[\"qzone.qq.com\"],\"openParams\":{\"url\":\"https://h5.qzone.qq.com/v2/vip/dhy/home?_wv=16778243&qzUseTransparentNavBar=1&_wwv=1&_ws=32&showtab=1&_proxy=1\",\"errorUrl\":\"https://h5.qzone.qq.com/v2/vip/dhy/home?_wv=16778243&qzUseTransparentNavBar=1&_wwv=1&_ws=32&showtab=1&_proxy=1\",\"isPreloadWhenClosed\":true,\"isPredraw\":true,\"isPredrawWhenClosed\":true,\"isAnimated\":true,\"bundleName\":\"qqdhy\",\"domain\":\"qzone.qq.com\"}},\"qqMiniGame\":{\"enableDomain\":[\"qzone.qq.com\",\"tianshu.qq.com\"]},\"qqshop\":{\"enableDomain\":[\"qianbao.qq.com\"]},\"minigameEntry\":{\"enableDomain\":[\"qzone.qq.com\"]},\"qqWeather\":{\"enableDomain\":[\"mp.qq.com\",\"qzone.qq.com\",\"tianshu.qq.com\",\"p.qq.com\",\"gdt.qq.com\"]},\"superqqshow_gamearea\":{\"enableDomain\":[\"gamecenter.qq.com\"]}}");
                QLog.d("QVipHippyProcessor", 2, stringData);
                if (!TextUtils.isEmpty(stringData)) {
                    QVipHippyConfig qVipHippyConfig2 = new QVipHippyConfig((LinkedTreeMap) new Gson().fromJson(stringData, new a().getType()));
                    f308945a = qVipHippyConfig2;
                    return qVipHippyConfig2;
                }
                return new QVipHippyConfig((LinkedTreeMap) new Gson().fromJson(new r03.a().a(), new b().getType()));
            } catch (Exception e16) {
                QLog.e("QVipHippyProcessor", 1, e16, new Object[0]);
                return new QVipHippyConfig(new LinkedTreeMap());
            }
        }
        QVipHippyConfig qVipHippyConfig3 = (QVipHippyConfig) am.s().x(com.tencent.luggage.wxa.ci.a.CTRL_INDEX);
        if (qVipHippyConfig3 == null) {
            return new QVipHippyConfig(new LinkedTreeMap());
        }
        return qVipHippyConfig3;
    }

    @Override // com.tencent.mobileqq.vas.config.business.qvip.BaseQVipConfigProcessor
    @NonNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public QVipHippyConfig migrateDefaultContent() {
        return new QVipHippyConfig(new LinkedTreeMap());
    }

    @Override // com.tencent.mobileqq.vas.config.business.qvip.BaseQVipConfigProcessor
    @NonNull
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public QVipHippyConfig migrateOldContent() {
        return new QVipHippyConfig(new LinkedTreeMap());
    }

    @Override // com.tencent.mobileqq.config.l
    public Class<QVipHippyConfig> clazz() {
        return QVipHippyConfig.class;
    }

    @Override // com.tencent.mobileqq.vas.config.business.qvip.BaseQVipConfigProcessor
    @NonNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public QVipHippyConfig parsed(ai[] aiVarArr) {
        try {
            String str = aiVarArr[0].f202268b;
            QLog.d("QVipHippyProcessor", 2, str);
            if (!TextUtils.isEmpty(str)) {
                return new QVipHippyConfig((LinkedTreeMap) new Gson().fromJson(str, new c().getType()));
            }
        } catch (Exception e16) {
            QLog.e("QVipHippyProcessor", 1, e16, new Object[0]);
        }
        return new QVipHippyConfig(new LinkedTreeMap());
    }

    @Override // com.tencent.mobileqq.vas.config.business.qvip.BaseQVipConfigProcessor, com.tencent.mobileqq.config.l
    public boolean isNeedCompressed() {
        return true;
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        return com.tencent.luggage.wxa.ci.a.CTRL_INDEX;
    }
}
