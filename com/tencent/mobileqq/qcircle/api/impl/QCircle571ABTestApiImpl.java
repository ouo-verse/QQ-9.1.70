package com.tencent.mobileqq.qcircle.api.impl;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.mobileqq.qcircle.api.IQCircle571ABTestApi;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tab.exp.sdk.export.config.TabEnvironment;
import com.tencent.tab.exp.sdk.impl.TabExpDependInjector;
import com.tencent.tab.exp.sdk.pbdata.Experiment;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import uq3.o;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QCircle571ABTestApiImpl implements IQCircle571ABTestApi {
    private static final Set<String> REPORT_RECORD = Collections.synchronizedSet(new HashSet());
    private static final String STORAGE_CONTRAST_FLAG = "_A";
    private static final String STORAGE_EXPERIMENT_FLAG = "_B";
    private static final String STORAGE_FACTORY_IMPL_KEY = "mStorageFactoryImpl";
    private static final String TAB_EXP_SDK_DATA_INFO_KEY = "tab_exp_sdk_data_info";
    private static final String TAG = "QCircle571ABTestApiImpl";
    private final AtomicReference<id4.a> mTabStorage571Ref = new AtomicReference<>();

    private Experiment decodeExpInfo(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        try {
            return Experiment.ADAPTER.decode(bArr);
        } catch (Exception unused) {
            Log.d("TAB.TabExpDataParser", "Experiment decode failed");
            return null;
        }
    }

    private boolean hasReport(String str) {
        if (!o.b2()) {
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        Set<String> set = REPORT_RECORD;
        if (set.contains(str)) {
            return true;
        }
        set.add(str);
        return false;
    }

    private void init571ExpStorage() {
        if (this.mTabStorage571Ref.get() != null) {
            return;
        }
        try {
            String str = "tab_exp_sdk_data_info_" + TabEnvironment.RELEASE.toString().toLowerCase() + "_" + ABTestController.APPID_571 + "_" + ABTestController.SCENE_571 + "_" + RFWApplication.getAccountId();
            TabExpDependInjector a16 = new TabExpDependInjector.b().a();
            Field declaredField = TabExpDependInjector.class.getDeclaredField(STORAGE_FACTORY_IMPL_KEY);
            declaredField.setAccessible(true);
            Object obj = declaredField.get(a16);
            if (obj instanceof id4.b) {
                this.mTabStorage571Ref.set(((id4.b) obj).create(str));
                QLog.d(TAG, 1, "[init571ExpStorage] init load exp success.");
            } else {
                QLog.d(TAG, 1, "[init571ExpStorage] init load fail.");
            }
        } catch (Throwable th5) {
            QLog.d(TAG, 1, "[initExpStorage] ex: ", th5);
        }
    }

    private Experiment obtainStorageExpInfo(String str) {
        init571ExpStorage();
        id4.a aVar = this.mTabStorage571Ref.get();
        if (aVar == null) {
            return null;
        }
        String[] allKeys = aVar.allKeys();
        if (allKeys != null && allKeys.length != 0) {
            if (!Arrays.asList(allKeys).contains(str)) {
                return null;
            }
            return decodeExpInfo(aVar.getByteArray(str));
        }
        QLog.d(TAG, 1, "[isStorageHitExp] allKeys == null || allKeys.length == 0");
        return null;
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircle571ABTestApi
    public String getAssignment(String str) {
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity(ABTestController.APPID_571, str);
        if (expEntity == null) {
            return "";
        }
        return expEntity.getAssignment();
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircle571ABTestApi
    public String getAssignmentByLayerCode(String str) {
        ExpEntityInfo expEntityByLayerCode = ABTestController.getInstance().getExpEntityByLayerCode(ABTestController.APPID_571, str);
        if (expEntityByLayerCode == null) {
            return "";
        }
        return expEntityByLayerCode.getAssignment();
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircle571ABTestApi
    public String getExpNameByLayerCode(String str) {
        ExpEntityInfo expEntityByLayerCode = ABTestController.getInstance().getExpEntityByLayerCode(ABTestController.APPID_571, str);
        if (expEntityByLayerCode == null) {
            return "";
        }
        return expEntityByLayerCode.getExpName();
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircle571ABTestApi
    public Map<String, String> getParamsByLayerCode(String str) {
        ExpEntityInfo expEntityByLayerCode = ABTestController.getInstance().getExpEntityByLayerCode(ABTestController.APPID_571, str);
        if (expEntityByLayerCode == null) {
            return new HashMap();
        }
        return expEntityByLayerCode.getTabParams();
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircle571ABTestApi
    public String getStorageExpGroupName(String str) {
        try {
            Experiment obtainStorageExpInfo = obtainStorageExpInfo(str);
            QLog.d(TAG, 1, "[getStorageExpGroupName] expName: " + str + " | experiment: " + obtainStorageExpInfo);
            return obtainStorageExpInfo.exp_key;
        } catch (Throwable th5) {
            QLog.d(TAG, 1, "[isStorageContrast] ex: ", th5);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircle571ABTestApi
    public boolean isContrast(String str) {
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity(ABTestController.APPID_571, str);
        if (expEntity != null && expEntity.isContrast()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircle571ABTestApi
    public boolean isExpHit(String str, String str2) {
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity(ABTestController.APPID_571, str);
        if (expEntity != null && expEntity.isExpHit(str2)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircle571ABTestApi
    public boolean isExperiment(String str) {
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity(ABTestController.APPID_571, str);
        if (expEntity != null && expEntity.isExperiment()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircle571ABTestApi
    public boolean isStorageContrast(String str) {
        String str2;
        try {
            Experiment obtainStorageExpInfo = obtainStorageExpInfo(str);
            QLog.d(TAG, 1, "[isStorageContrast] expName: " + str + " | experiment: " + obtainStorageExpInfo);
            if (obtainStorageExpInfo != null && (str2 = obtainStorageExpInfo.exp_key) != null) {
                return TextUtils.equals(str2.toLowerCase(), (str + STORAGE_CONTRAST_FLAG).toLowerCase());
            }
            return false;
        } catch (Throwable th5) {
            QLog.d(TAG, 1, "[isStorageContrast] ex: ", th5);
            return false;
        }
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircle571ABTestApi
    public boolean isStorageExperiment(String str) {
        String str2;
        try {
            Experiment obtainStorageExpInfo = obtainStorageExpInfo(str);
            QLog.d(TAG, 1, "[isStorageExperiment] expName: " + str + " | experiment: " + obtainStorageExpInfo);
            if (obtainStorageExpInfo != null && (str2 = obtainStorageExpInfo.exp_key) != null) {
                return TextUtils.equals(str2.toLowerCase(), (str + STORAGE_EXPERIMENT_FLAG).toLowerCase());
            }
            return false;
        } catch (Throwable th5) {
            QLog.d(TAG, 1, "[isStorageExperiment] ex: ", th5);
            return false;
        }
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircle571ABTestApi
    public void onAccountChange() {
        if (!o.b2()) {
            return;
        }
        REPORT_RECORD.clear();
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircle571ABTestApi
    public void reportExperimentExport(String str) {
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity(ABTestController.APPID_571, str);
        if (expEntity == null || hasReport(str)) {
            return;
        }
        expEntity.reportExpExposure();
        com.tencent.qcircle.cooperation.config.debug.e.a(new com.tencent.qcircle.cooperation.config.debug.e(System.currentTimeMillis(), str, PlayerResources.ViewId.EXTENDED_VIEW_LEFT_TOP_CIRCLE, expEntity.getAssignment()));
    }
}
