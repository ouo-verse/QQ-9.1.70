package com.tencent.rmonitor.metrics.looper;

import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.base.meta.DropFrameResultMeta;
import com.tencent.rmonitor.base.plugin.listener.IDropFrameListener;
import com.tencent.rmonitor.common.logger.Logger;
import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes25.dex */
public class d implements Function0<Integer> {
    public void a(DropFrameResultMeta dropFrameResultMeta) {
        try {
            Iterator<IDropFrameListener> it = i04.a.dropFrameListener.c().iterator();
            while (it.hasNext()) {
                it.next().onRecordData(dropFrameResultMeta);
            }
        } catch (Throwable unused) {
        }
    }

    public boolean b(String str, DropFrameResultMeta dropFrameResultMeta) {
        String jSONObject;
        int c16 = e.c(dropFrameResultMeta);
        if (c16 != 0) {
            if (dropFrameResultMeta == null) {
                jSONObject = "null";
            } else {
                jSONObject = dropFrameResultMeta.toJSONObject().toString();
            }
            Logger.f365497g.i("RMonitor_looper_metric", "checkData, pluginName: " + str + ", ret: " + c16 + ", invalid data: " + jSONObject);
            if (c16 != 1) {
                com.tencent.rmonitor.sla.g.a("looper", str, String.valueOf(c16), ReportDataBuilder.getClientIdentify(BaseInfo.userMeta), jSONObject);
            }
        }
        if (c16 != 0) {
            return false;
        }
        return true;
    }

    public void c(String str, DropFrameResultMeta dropFrameResultMeta) {
        JSONObject jSONObject = new JSONObject();
        s04.b.j().b(true, str, dropFrameResultMeta.scene, jSONObject);
        if (jSONObject.has(ReportDataBuilder.KEY_USER_CUSTOM)) {
            try {
                dropFrameResultMeta.userCustom = jSONObject.getJSONObject(ReportDataBuilder.KEY_USER_CUSTOM);
            } catch (Throwable unused) {
            }
        }
    }

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Integer invoke() {
        return 0;
    }

    public boolean e(String str, DropFrameResultMeta dropFrameResultMeta) {
        com.tencent.rmonitor.base.db.c dbHandler;
        com.tencent.rmonitor.base.db.d dVar = BaseInfo.dbHelper;
        if (dVar == null || (dbHandler = dVar.getDbHandler()) == null) {
            return false;
        }
        int h16 = dbHandler.h(new com.tencent.rmonitor.base.db.table.a(BaseInfo.makeBaseDBParam(), str, dropFrameResultMeta), this);
        if (h16 == -1) {
            Logger.f365497g.d("RMonitor_looper_metric", str + " save fail, meta: " + dropFrameResultMeta.toJSONObject());
        }
        if (h16 == -1) {
            return false;
        }
        return true;
    }
}
