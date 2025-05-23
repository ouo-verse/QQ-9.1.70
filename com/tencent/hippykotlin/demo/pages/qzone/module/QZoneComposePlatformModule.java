package com.tencent.hippykotlin.demo.pages.qzone.module;

import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.Module;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.b;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes33.dex */
public final class QZoneComposePlatformModule extends Module {
    public static final Companion Companion = new Companion();

    /* loaded from: classes33.dex */
    public static final class Companion {
        public final QZoneComposePlatformModule get() {
            try {
                b g16 = c.f117352a.g();
                if (g16 != null) {
                    return (QZoneComposePlatformModule) g16.acquireModule("QZoneComposePlatformModule");
                }
                return null;
            } catch (Exception e16) {
                KLog kLog = KLog.INSTANCE;
                String message = e16.getMessage();
                if (message == null) {
                    message = "";
                }
                kLog.e("QZoneComposePlatformModule", message);
                return null;
            }
        }

        public final String getUin() {
            String syncToNativeMethod;
            QZoneComposePlatformModule qZoneComposePlatformModule = get();
            return (qZoneComposePlatformModule == null || (syncToNativeMethod = qZoneComposePlatformModule.syncToNativeMethod("getUin", (e) null, (Function1<? super e, Unit>) null)) == null) ? "" : syncToNativeMethod;
        }
    }

    @Override // com.tencent.kuikly.core.module.Module
    public final String moduleName() {
        return "QZoneComposePlatformModule";
    }
}
