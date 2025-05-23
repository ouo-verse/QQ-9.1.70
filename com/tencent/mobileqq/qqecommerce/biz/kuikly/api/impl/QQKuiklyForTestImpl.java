package com.tencent.mobileqq.qqecommerce.biz.kuikly.api.impl;

import com.tencent.ark.ark;
import com.tencent.ecommerce.base.config.api.IECLocalConfig;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyForTest;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.QQKuiklyBundleSpecificConfig;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u0000 %2\u00020\u0001:\u0001&B\u0007\u00a2\u0006\u0004\b#\u0010$J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\tH\u0002J\f\u0010\r\u001a\u00020\t*\u00020\u0004H\u0002J\f\u0010\u000e\u001a\u00020\u0004*\u00020\tH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0016J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0018\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0004H\u0016J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u001d\u001a\u00020\u0006H\u0016R\u0014\u0010\u0019\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001fR\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/impl/QQKuiklyForTestImpl;", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/IQQKuiklyForTest;", "", "resId", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/j;", "info", "", "saveTestConfig", "loadTestConfig", "Lorg/json/JSONObject;", "loadAllTestConfig", ark.ARKMETADATA_JSON, "saveTestConfigLocked", "toJSONObject", "toBundleSpecificConfig", "", "isQrEnable", "isTestEnabled", "isTestSwitchOn", "isSwitchOn", "setTestSwitchStatus", "getCacheVersion", "", "version", "cacheQRResult", DownloadInfo.spKey_Config, "cacheSpecificConfig", "getCacheSpecificConfig", "removeSpecificConfig", QCircleLpReportDc05507.KEY_CLEAR, "Loe2/a;", "Loe2/a;", "", "mConfigLock", "Ljava/lang/Object;", "<init>", "()V", "Companion", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class QQKuiklyForTestImpl implements IQQKuiklyForTest {
    private static final String KEY_KUIKLY_TEST = "key_kuikly_test_config";
    private static final String KEY_KUIKLY_TEST_SWITCH_STATUS = "kuikly_test_switch_status";
    private static final String TAG = "QQKuiklyForTest";
    private final oe2.a config = new oe2.a();
    private final Object mConfigLock = new Object();

    private final JSONObject loadAllTestConfig() {
        try {
            oe2.a aVar = this.config;
            String jSONObject = new JSONObject().toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "JSONObject().toString()");
            return new JSONObject(IECLocalConfig.a.f(aVar, KEY_KUIKLY_TEST, jSONObject, null, 4, null));
        } catch (Exception e16) {
            QLog.e(TAG, 1, "Failed to loadAllTestConfigLocked", e16);
            return new JSONObject();
        }
    }

    private final void saveTestConfig(String resId, QQKuiklyBundleSpecificConfig info) {
        try {
            JSONObject loadAllTestConfig = loadAllTestConfig();
            loadAllTestConfig.put(resId, toJSONObject(info));
            saveTestConfigLocked(loadAllTestConfig);
        } catch (Exception e16) {
            QLog.i(TAG, 1, "Failed to saveTestConfig", e16);
        }
    }

    private final void saveTestConfigLocked(JSONObject json) {
        IECLocalConfig.a.g(this.config, KEY_KUIKLY_TEST, json.toString(), null, 4, null);
    }

    private final QQKuiklyBundleSpecificConfig toBundleSpecificConfig(JSONObject jSONObject) {
        String optString = jSONObject.optString("resId", "");
        Intrinsics.checkNotNullExpressionValue(optString, "optString(\"resId\", \"\")");
        return new QQKuiklyBundleSpecificConfig(optString, jSONObject.optString(MiniAppGetGameTaskTicketServlet.KEY_TASKID, ""), jSONObject.optLong("version", 0L), jSONObject.optString(WadlProxyConsts.EXTRA_DATA, ""));
    }

    private final JSONObject toJSONObject(QQKuiklyBundleSpecificConfig qQKuiklyBundleSpecificConfig) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("resId", qQKuiklyBundleSpecificConfig.getResId());
        jSONObject.put(MiniAppGetGameTaskTicketServlet.KEY_TASKID, qQKuiklyBundleSpecificConfig.getTaskId());
        jSONObject.put("version", qQKuiklyBundleSpecificConfig.getVersion());
        jSONObject.put(WadlProxyConsts.EXTRA_DATA, qQKuiklyBundleSpecificConfig.getExtraData());
        return jSONObject;
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyForTest
    public void cacheQRResult(String resId, long version) {
        Intrinsics.checkNotNullParameter(resId, "resId");
        if (isTestSwitchOn()) {
            QQKuiklyBundleSpecificConfig qQKuiklyBundleSpecificConfig = new QQKuiklyBundleSpecificConfig(resId, null, version, null, 10, null);
            synchronized (this.mConfigLock) {
                saveTestConfig(resId, qQKuiklyBundleSpecificConfig);
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyForTest
    public void cacheSpecificConfig(String resId, QQKuiklyBundleSpecificConfig config) {
        Intrinsics.checkNotNullParameter(resId, "resId");
        Intrinsics.checkNotNullParameter(config, "config");
        if (isTestSwitchOn()) {
            synchronized (this.mConfigLock) {
                saveTestConfig(resId, config);
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyForTest
    public void clear() {
        synchronized (this.mConfigLock) {
            saveTestConfigLocked(new JSONObject());
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyForTest
    public QQKuiklyBundleSpecificConfig getCacheSpecificConfig(String resId) {
        QQKuiklyBundleSpecificConfig loadTestConfig;
        Intrinsics.checkNotNullParameter(resId, "resId");
        if (!isTestSwitchOn()) {
            return null;
        }
        synchronized (this.mConfigLock) {
            loadTestConfig = loadTestConfig(resId);
        }
        return loadTestConfig;
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyForTest
    public String getCacheVersion(String resId) {
        Intrinsics.checkNotNullParameter(resId, "resId");
        if (!isTestSwitchOn()) {
            return "";
        }
        synchronized (this.mConfigLock) {
            QQKuiklyBundleSpecificConfig loadTestConfig = loadTestConfig(resId);
            if (loadTestConfig == null) {
                return "";
            }
            return String.valueOf(loadTestConfig.getVersion());
        }
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyForTest
    public boolean isQrEnable() {
        return isTestSwitchOn();
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyForTest
    public boolean isTestEnabled() {
        return false;
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyForTest
    public boolean isTestSwitchOn() {
        return Intrinsics.areEqual(IECLocalConfig.a.f(this.config, KEY_KUIKLY_TEST_SWITCH_STATUS, "0", null, 4, null), "1");
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyForTest
    public void removeSpecificConfig(String resId) {
        Intrinsics.checkNotNullParameter(resId, "resId");
        synchronized (this.mConfigLock) {
            try {
                JSONObject loadAllTestConfig = loadAllTestConfig();
                loadAllTestConfig.remove(resId);
                saveTestConfigLocked(loadAllTestConfig);
            } catch (Exception e16) {
                QLog.i(TAG, 1, "Failed to saveTestConfig", e16);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyForTest
    public void setTestSwitchStatus(boolean isSwitchOn) {
        String str;
        oe2.a aVar = this.config;
        if (isSwitchOn) {
            str = "1";
        } else {
            str = "0";
        }
        IECLocalConfig.a.j(aVar, KEY_KUIKLY_TEST_SWITCH_STATUS, str, null, 4, null);
    }

    private final QQKuiklyBundleSpecificConfig loadTestConfig(String resId) {
        try {
            JSONObject optJSONObject = loadAllTestConfig().optJSONObject(resId);
            if (optJSONObject == null) {
                return null;
            }
            return toBundleSpecificConfig(optJSONObject);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "Failed to loadTestConfig", e16);
            return null;
        }
    }
}
