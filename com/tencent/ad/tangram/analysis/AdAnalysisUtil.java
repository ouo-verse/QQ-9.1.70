package com.tencent.ad.tangram.analysis;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.ad.tangram.analysis.sqlite.AdAnalysisSQLiteEntry;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.json.AdJSON;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.process.AdProcessManager;
import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.ad.tangram.protocol.gdt_analysis_request;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* compiled from: P */
@AdKeep
/* loaded from: classes3.dex */
public final class AdAnalysisUtil {
    private static final String TAG = "AdAnalysisUtil";
    public static final int VERSION = 4;

    @Nullable
    public static gdt_analysis_event[] createBody(@Nullable List<AdAnalysisSQLiteEntry> list) {
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            Iterator<AdAnalysisSQLiteEntry> it = list.iterator();
            while (it.hasNext()) {
                gdt_analysis_event createEvent = createEvent(it.next());
                if (createEvent != null) {
                    arrayList.add(createEvent);
                }
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            gdt_analysis_event[] gdt_analysis_eventVarArr = new gdt_analysis_event[arrayList.size()];
            arrayList.toArray(gdt_analysis_eventVarArr);
            return gdt_analysis_eventVarArr;
        }
        AdLog.e(TAG, "createBody error");
        return null;
    }

    @Nullable
    private static gdt_analysis_event createEvent(@Nullable AdAnalysisSQLiteEntry adAnalysisSQLiteEntry) {
        if (adAnalysisSQLiteEntry == null) {
            return null;
        }
        try {
            return (gdt_analysis_event) gdt_analysis_event.class.cast(AdJSON.toObject(new JSONObject(adAnalysisSQLiteEntry.eventString), gdt_analysis_event.class));
        } catch (Throwable th5) {
            AdLog.e(TAG, "createEvent", th5);
            return null;
        }
    }

    @Nullable
    public static gdt_analysis_request createRequest(Context context, @Nullable gdt_analysis_event[] gdt_analysis_eventVarArr, String str) {
        if (gdt_analysis_eventVarArr != null && gdt_analysis_eventVarArr.length > 0 && !TextUtils.isEmpty(str)) {
            gdt_analysis_request gdt_analysis_requestVar = new gdt_analysis_request();
            gdt_analysis_requestVar.bid = 10001013;
            gdt_analysis_requestVar.androidSDK = Build.VERSION.SDK_INT;
            gdt_analysis_requestVar.androidBrand = Build.BRAND;
            gdt_analysis_requestVar.androidManufacturer = Build.MANUFACTURER;
            gdt_analysis_requestVar.appVersion = str;
            gdt_analysis_requestVar.osType = 2;
            gdt_analysis_requestVar.osVersion = Build.VERSION.RELEASE;
            gdt_analysis_requestVar.body = gdt_analysis_eventVarArr;
            return gdt_analysis_requestVar;
        }
        AdLog.e(TAG, "getRequest error");
        return null;
    }

    public static void initEvent(Context context, int i3, @Nullable gdt_analysis_event gdt_analysis_eventVar) {
        if (gdt_analysis_eventVar != null && i3 != Integer.MIN_VALUE) {
            gdt_analysis_eventVar.eventId = String.valueOf(i3);
            gdt_analysis_eventVar.androidCurrentProcessName = AdProcessManager.getInstance().getCurrentProcessName(context);
            gdt_analysis_eventVar.currentTime = System.currentTimeMillis();
            return;
        }
        AdLog.e(TAG, "initEvent error");
    }
}
