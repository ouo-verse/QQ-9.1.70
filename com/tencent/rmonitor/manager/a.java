package com.tencent.rmonitor.manager;

import android.text.TextUtils;
import com.tencent.rmonitor.base.plugin.monitor.QAPMMonitorPlugin;
import com.tencent.rmonitor.common.logger.Logger;
import java.lang.reflect.Constructor;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/rmonitor/manager/a;", "Lcom/tencent/rmonitor/manager/d;", "Lcom/tencent/rmonitor/base/config/d;", "pluginConfig", "Lcom/tencent/rmonitor/base/plugin/monitor/QAPMMonitorPlugin;", "createPlugin", "", "a", "Ljava/lang/String;", "tag", "<init>", "()V", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class a implements d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String tag = "RMonitor_manager";

    @Override // com.tencent.rmonitor.manager.d
    @Nullable
    public QAPMMonitorPlugin createPlugin(@Nullable com.tencent.rmonitor.base.config.d pluginConfig) {
        QAPMMonitorPlugin qAPMMonitorPlugin;
        Throwable th5;
        Class<?> cls;
        QAPMMonitorPlugin qAPMMonitorPlugin2 = null;
        if (pluginConfig == null || TextUtils.isEmpty(pluginConfig.common.config.service.QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE java.lang.String)) {
            return null;
        }
        try {
            cls = Class.forName(pluginConfig.common.config.service.QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE java.lang.String);
            try {
                Object invoke = cls.getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
                if (!(invoke instanceof QAPMMonitorPlugin)) {
                    invoke = null;
                }
                qAPMMonitorPlugin = (QAPMMonitorPlugin) invoke;
            } catch (Throwable unused) {
                qAPMMonitorPlugin = null;
            }
        } catch (ClassNotFoundException unused2) {
        } catch (Throwable th6) {
            qAPMMonitorPlugin = null;
            th5 = th6;
        }
        if (qAPMMonitorPlugin == null) {
            try {
                Constructor<?> constructor = cls.getConstructor(new Class[0]);
                if (constructor != null) {
                    qAPMMonitorPlugin2 = (QAPMMonitorPlugin) constructor.newInstance(new Object[0]);
                }
            } catch (ClassNotFoundException unused3) {
                qAPMMonitorPlugin2 = qAPMMonitorPlugin;
                Logger.f365497g.i(this.tag, "can not find plugin {name: " + pluginConfig.pluginName + ", entrance: " + pluginConfig.common.config.service.QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE java.lang.String + '}');
                return qAPMMonitorPlugin2;
            } catch (Throwable th7) {
                th5 = th7;
                Logger.f365497g.b(this.tag, "fail to register plugin {name: " + pluginConfig.pluginName + ", entrance: " + pluginConfig.common.config.service.QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE java.lang.String + '}', th5);
                return qAPMMonitorPlugin;
            }
            return qAPMMonitorPlugin2;
        }
        return qAPMMonitorPlugin;
    }
}
