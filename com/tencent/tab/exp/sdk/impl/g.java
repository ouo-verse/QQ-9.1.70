package com.tencent.tab.exp.sdk.impl;

import android.text.TextUtils;
import android.util.Log;
import com.squareup.wire.Wire;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.tab.exp.sdk.impl.k;
import com.tencent.tab.exp.sdk.pbdata.ControlData;
import com.tencent.tab.exp.sdk.pbdata.DataUpdateType;
import com.tencent.tab.exp.sdk.pbdata.Experiment;
import com.tencent.tab.exp.sdk.pbdata.GetExperimentsRespV2;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes26.dex */
public final class g {
    static k a(String str, Experiment experiment) {
        if (!TextUtils.isEmpty(str) && experiment != null) {
            return new k.b().i(experiment).m(str).k(experiment.exp_group_key).g(experiment.exp_key).j(String.valueOf(experiment.exp_id)).l(experiment.params).h();
        }
        return null;
    }

    static e b(ControlData controlData) {
        if (controlData == null) {
            return null;
        }
        boolean booleanValue = ((Boolean) Wire.get(controlData.enable_report, Boolean.FALSE)).booleanValue();
        int intValue = ((Integer) Wire.get(controlData.refresh_duration, 600)).intValue();
        int n3 = n(((Integer) Wire.get(controlData.report_time_interval, 60)).intValue());
        e eVar = new e();
        eVar.f(controlData, booleanValue, intValue, n3);
        return eVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static GetExperimentsRespV2 c(Object obj) {
        byte[] a16;
        if (!(obj instanceof gd4.b) || (a16 = ((gd4.b) obj).a()) == null) {
            return null;
        }
        try {
            return GetExperimentsRespV2.ADAPTER.decode(a16);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DataUpdateType d(GetExperimentsRespV2 getExperimentsRespV2) {
        DataUpdateType dataUpdateType;
        if (getExperimentsRespV2 != null && (dataUpdateType = getExperimentsRespV2.data_update_type) != null) {
            return dataUpdateType;
        }
        return GetExperimentsRespV2.DEFAULT_DATA_UPDATE_TYPE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long e(GetExperimentsRespV2 getExperimentsRespV2) {
        Long l3;
        if (getExperimentsRespV2 != null && (l3 = getExperimentsRespV2.modify_timestamp) != null) {
            return l3.longValue();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e f(GetExperimentsRespV2 getExperimentsRespV2) {
        ControlData controlData;
        if (getExperimentsRespV2 != null && (controlData = getExperimentsRespV2.control_data) != null) {
            return b(controlData);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String g(GetExperimentsRespV2 getExperimentsRespV2) {
        if (getExperimentsRespV2 != null && !TextUtils.isEmpty(getExperimentsRespV2.snapshot_version)) {
            return getExperimentsRespV2.snapshot_version;
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ConcurrentHashMap<String, k> h(GetExperimentsRespV2 getExperimentsRespV2) {
        k a16;
        if (getExperimentsRespV2 != null && getExperimentsRespV2.exp_data != null) {
            ConcurrentHashMap<String, k> concurrentHashMap = new ConcurrentHashMap<>();
            for (Map.Entry<String, Experiment> entry : getExperimentsRespV2.exp_data.entrySet()) {
                if (entry != null) {
                    String key = entry.getKey();
                    Experiment value = entry.getValue();
                    if (!TextUtils.isEmpty(key) && value != null && !EmoticonPackage.MAGIC_FACE_EPID.equals(String.valueOf(value.exp_id)) && (a16 = a(key, value)) != null) {
                        concurrentHashMap.put(key, a16);
                    }
                }
            }
            return concurrentHashMap;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<String> i(GetExperimentsRespV2 getExperimentsRespV2) {
        List<String> list;
        if (getExperimentsRespV2 != null && (list = getExperimentsRespV2.exp_data_removed) != null) {
            return list;
        }
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static k j(byte[] bArr) {
        Experiment experiment;
        if (bArr == null) {
            return null;
        }
        try {
            experiment = Experiment.ADAPTER.decode(bArr);
        } catch (Exception unused) {
            Log.d("TAB.TabExpDataParser", "Experiment decode failed");
            experiment = null;
        }
        if (experiment == null) {
            return null;
        }
        return a(experiment.module_code, experiment);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e k(byte[] bArr) {
        ControlData controlData;
        if (bArr == null) {
            return null;
        }
        try {
            controlData = ControlData.ADAPTER.decode(bArr);
        } catch (Exception unused) {
            Log.d("TAB.TabExpDataParser", "ControlData decode failed");
            controlData = null;
        }
        if (controlData == null) {
            return null;
        }
        return b(controlData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] l(k kVar) {
        Experiment b16;
        if (kVar == null || (b16 = kVar.b()) == null) {
            return null;
        }
        try {
            return b16.encode();
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] m(e eVar) {
        ControlData b16;
        if (eVar == null || (b16 = eVar.b()) == null) {
            return null;
        }
        try {
            return b16.encode();
        } catch (Exception unused) {
            return null;
        }
    }

    static int n(int i3) {
        if (i3 > 0) {
            return i3;
        }
        if (i3 == 0) {
            return 60;
        }
        return 0;
    }
}
