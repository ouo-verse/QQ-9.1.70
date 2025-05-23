package com.tencent.rdelivery.reshub.report;

import android.os.Environment;
import android.os.StatFs;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import com.tencent.mobileqq.qwallet.preload.IPreloadServiceProxy;
import com.tencent.raft.standard.report.BaseEvent;
import com.tencent.rdelivery.reshub.core.k;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J4\u0010\r\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\"\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\nj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u000bH\u0002J\u0016\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0006J\u001e\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0004J\u000e\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0018\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/rdelivery/reshub/report/ReportHelper;", "", "", "f", "", "eventId", "Ljava/util/Properties;", "params", "", "d", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "map", "e", "Lcom/tencent/rdelivery/reshub/core/k;", Const.BUNDLE_KEY_REQUEST, "p", "c", "Ljz3/e;", "resConfig", "", "failedType", "appId", "g", "Lcom/tencent/rdelivery/reshub/report/a;", "error", "b", "<init>", "()V", "reshub_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class ReportHelper {
    /* JADX INFO: Access modifiers changed from: private */
    public final void d(String eventId, Properties params) {
        for (Map.Entry entry : GlobalParamsHolder.f364562b.a().entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (!params.containsKey(key)) {
                params.put(key, value);
            }
        }
        HashMap<String, String> hashMap = new HashMap<>();
        for (Map.Entry entry2 : params.entrySet()) {
            hashMap.put(entry2.getKey().toString(), entry2.getValue().toString());
        }
        com.tencent.rdelivery.reshub.core.j jVar = com.tencent.rdelivery.reshub.core.j.L;
        if (jVar.S() && jVar.w().getIsRdmTest()) {
            jz3.d.h("Report", "Do Reporting Event: " + eventId + ", Params: " + params);
        } else {
            jz3.d.a("Report", "Do Reporting Event2: " + eventId + ", Params: " + params);
        }
        e(eventId, hashMap);
    }

    private final void e(String eventId, HashMap<String, String> map) {
        BaseEvent baseEvent = new BaseEvent(eventId, "", false, map);
        com.tencent.rdelivery.reshub.core.j jVar = com.tencent.rdelivery.reshub.core.j.L;
        if (jVar.U()) {
            jVar.D().reportToBeacon("0AND0SOBHI4GADI0", baseEvent);
        }
    }

    private final float f() {
        float f16;
        String path = Environment.getDataDirectory().getPath();
        Intrinsics.checkExpressionValueIsNotNull(path, "Environment.getDataDirectory().getPath()");
        try {
            StatFs statFs = new StatFs(path);
            float availableBlocks = statFs.getAvailableBlocks() * statFs.getBlockSize();
            float f17 = 1024;
            f16 = (availableBlocks / f17) / f17;
        } catch (Exception e16) {
            jz3.d.d("ReportHelper", "getAvailableInnerStorageSize exception", e16);
            f16 = -1.0f;
        }
        jz3.d.a("ReportHelper", "getAvailableInnerStorageSize size = " + f16 + " mb");
        return f16;
    }

    public final void b(@NotNull a error) {
        Intrinsics.checkParameterIsNotNull(error, "error");
        if (error.d()) {
            return;
        }
        Properties properties = new Properties();
        properties.put(CheckForwardServlet.KEY_ERR_CODE, Integer.valueOf(error.getErrorCode()));
        properties.put("err_msg", c.a(error));
        d("rs_get_l", properties);
    }

    public final void c(@NotNull k request, @NotNull Properties p16) {
        Intrinsics.checkParameterIsNotNull(request, "request");
        Intrinsics.checkParameterIsNotNull(p16, "p");
        final Properties b16 = g.b(request);
        b16.putAll(p16);
        f.f364572b.c(request, b16, new Function0<Unit>() { // from class: com.tencent.rdelivery.reshub.report.ReportHelper$doLoadResultReport$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ReportHelper.this.d("rd_res_load", b16);
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x004e, code lost:
    
        r6 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r6);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void g(@NotNull jz3.e resConfig, int failedType, @NotNull String appId) {
        int i3;
        int i16;
        Object obj;
        Intrinsics.checkParameterIsNotNull(resConfig, "resConfig");
        Intrinsics.checkParameterIsNotNull(appId, "appId");
        i3 = e.f364570a;
        if (i3 < 5) {
            i16 = e.f364570a;
            e.f364570a = i16 + 1;
            Properties properties = new Properties();
            properties.put(IPreloadServiceProxy.KEY_RESID, resConfig.getResId());
            properties.put("app_id", appId);
            String str = resConfig.f411279t;
            if (str == null || obj == null) {
                obj = 0;
            }
            properties.put("res_ver", obj);
            properties.put("file_ver", Long.valueOf(resConfig.f411261b));
            properties.put("storage_size", Float.valueOf(f()));
            properties.put("fail_type", Integer.valueOf(failedType));
            d("rd_res_load_preset_err", properties);
            return;
        }
        jz3.d.c("ReportHelper", "reportLoadPresetResFailedResult return for limit, resConfig = " + resConfig);
    }
}
