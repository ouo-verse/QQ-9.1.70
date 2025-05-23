package com.tencent.rmonitor.manager;

import android.text.TextUtils;
import com.tencent.bugly.common.utils.AndroidVersion;
import com.tencent.rmonitor.base.config.PluginCombination;
import com.tencent.rmonitor.base.plugin.monitor.QAPMMonitorPlugin;
import com.tencent.rmonitor.common.logger.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0006\b\u0016\u0018\u0000 \u00042\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b!\u0010\"J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0003H\u0002J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0003H\u0002J\n\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\u0015\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0016\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\u0017\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\u0018\u001a\u00020\u00112\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u0019\u001a\u00020\u0007H\u0016R \u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u001bR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u001eR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010 \u00a8\u0006#"}, d2 = {"Lcom/tencent/rmonitor/manager/f;", "Lcom/tencent/rmonitor/manager/c;", "", "Lcom/tencent/rmonitor/base/plugin/monitor/QAPMMonitorPlugin;", "d", "Lcom/tencent/rmonitor/base/config/d;", "pluginConfig", "", "f", "", "pluginName", "g", "plugin", "i", h.F, "Lcom/tencent/rmonitor/manager/d;", "e", "", "needRegister", "c", "pluginFactory", "a", "start", "stop", "b", "stopAll", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/ConcurrentHashMap;", "plugins", "", "Ljava/util/List;", "startedPlugin", "Lcom/tencent/rmonitor/manager/d;", "<init>", "()V", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public class f implements c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ConcurrentHashMap<String, QAPMMonitorPlugin> plugins = new ConcurrentHashMap<>();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final List<QAPMMonitorPlugin> startedPlugin = new ArrayList();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private d pluginFactory;

    private final List<QAPMMonitorPlugin> d() {
        ConcurrentHashMap<String, QAPMMonitorPlugin> concurrentHashMap = this.plugins;
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<String, QAPMMonitorPlugin>> it = concurrentHashMap.entrySet().iterator();
        while (it.hasNext()) {
            QAPMMonitorPlugin value = it.next().getValue();
            if (value != null) {
                arrayList.add(value);
            }
        }
        return arrayList;
    }

    private final d e() {
        if (this.pluginFactory == null) {
            this.pluginFactory = new a();
        }
        return this.pluginFactory;
    }

    private final void f(com.tencent.rmonitor.base.config.d pluginConfig) {
        QAPMMonitorPlugin qAPMMonitorPlugin;
        if (this.plugins.containsKey(pluginConfig.pluginName)) {
            return;
        }
        d e16 = e();
        if (e16 != null) {
            qAPMMonitorPlugin = e16.createPlugin(pluginConfig);
        } else {
            qAPMMonitorPlugin = null;
        }
        if (qAPMMonitorPlugin != null) {
            this.plugins.put(pluginConfig.pluginName, qAPMMonitorPlugin);
            qAPMMonitorPlugin.setPluginConfig(pluginConfig);
            Logger.f365497g.i("RMonitor_manager_PluginMng", "register module " + pluginConfig.pluginName + " success.");
        }
    }

    private final void g(String pluginName) {
        com.tencent.rmonitor.base.config.d c16 = PluginCombination.INSTANCE.c(pluginName);
        if (c16 != null) {
            f(c16);
        }
    }

    private final void h(QAPMMonitorPlugin plugin) {
        String str;
        synchronized (this.startedPlugin) {
            if (!this.startedPlugin.contains(plugin)) {
                plugin.start();
                this.startedPlugin.add(plugin);
                Logger logger = Logger.f365497g;
                String[] strArr = new String[2];
                strArr[0] = "RMonitor_manager_PluginMng";
                StringBuilder sb5 = new StringBuilder();
                sb5.append("start ");
                com.tencent.rmonitor.base.config.d pluginConfig = plugin.getPluginConfig();
                if (pluginConfig != null) {
                    str = pluginConfig.pluginName;
                } else {
                    str = null;
                }
                sb5.append(str);
                strArr[1] = sb5.toString();
                logger.i(strArr);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void i(QAPMMonitorPlugin plugin) {
        String str;
        synchronized (this.startedPlugin) {
            if (this.startedPlugin.contains(plugin)) {
                plugin.stop();
                this.startedPlugin.remove(plugin);
                Logger logger = Logger.f365497g;
                String[] strArr = new String[2];
                strArr[0] = "RMonitor_manager_PluginMng";
                StringBuilder sb5 = new StringBuilder();
                sb5.append("stop ");
                com.tencent.rmonitor.base.config.d pluginConfig = plugin.getPluginConfig();
                if (pluginConfig != null) {
                    str = pluginConfig.pluginName;
                } else {
                    str = null;
                }
                sb5.append(str);
                strArr[1] = sb5.toString();
                logger.i(strArr);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // com.tencent.rmonitor.manager.c
    public void a(@Nullable d pluginFactory) {
        if (pluginFactory != null) {
            this.pluginFactory = pluginFactory;
        }
    }

    @Override // com.tencent.rmonitor.manager.c
    public boolean b(@Nullable String pluginName) {
        QAPMMonitorPlugin c16 = c(false, pluginName);
        if (c16 == null || !this.startedPlugin.contains(c16)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.rmonitor.manager.c
    @Nullable
    public QAPMMonitorPlugin c(boolean needRegister, @Nullable String pluginName) {
        if (TextUtils.isEmpty(pluginName) || !AndroidVersion.INSTANCE.isOverJellyBean()) {
            return null;
        }
        if (needRegister) {
            if (pluginName == null) {
                Intrinsics.throwNpe();
            }
            g(pluginName);
        }
        QAPMMonitorPlugin qAPMMonitorPlugin = this.plugins.get(pluginName);
        if (needRegister && qAPMMonitorPlugin == null) {
            Logger.f365497g.i("RMonitor_manager_PluginMng", pluginName + " is null.");
        }
        return qAPMMonitorPlugin;
    }

    @Override // com.tencent.rmonitor.manager.c
    public void start(@Nullable String pluginName) {
        QAPMMonitorPlugin c16 = c(true, pluginName);
        if (c16 == null) {
            Logger.f365497g.i("RMonitor_manager_PluginMng", "start plugin fail for " + pluginName + " is null.");
            return;
        }
        if (!b(pluginName)) {
            h(c16);
            return;
        }
        Logger.f365497g.d("RMonitor_manager_PluginMng", "plugin not need to start for " + pluginName + " has started before.");
    }

    @Override // com.tencent.rmonitor.manager.c
    public void stop(@Nullable String pluginName) {
        QAPMMonitorPlugin c16 = c(false, pluginName);
        if (c16 == null) {
            if (Logger.verbos) {
                Logger.f365497g.v("RMonitor_manager_PluginMng", "plugin not need to stop for " + pluginName + " is null.");
                return;
            }
            return;
        }
        if (b(pluginName)) {
            i(c16);
            return;
        }
        if (Logger.verbos) {
            Logger.f365497g.v("RMonitor_manager_PluginMng", "plugin not need to stop for " + pluginName + " has not started before.");
        }
    }

    @Override // com.tencent.rmonitor.manager.c
    public void stopAll() {
        Iterator<T> it = d().iterator();
        while (it.hasNext()) {
            i((QAPMMonitorPlugin) it.next());
        }
    }
}
