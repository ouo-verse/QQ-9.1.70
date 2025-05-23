package com.tencent.rmonitor.base.plugin.monitor;

import android.content.SharedPreferences;
import com.tencent.rmonitor.base.config.ConfigProxy;
import com.tencent.rmonitor.base.config.PluginCombination;
import com.tencent.rmonitor.base.config.d;
import com.tencent.rmonitor.base.meta.BaseInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/rmonitor/base/plugin/monitor/PluginController;", "", "", "pluginName", "", "sampleRatio", "", "g", "", "c", "a", "b", "f", "d", "e", "", "J", "startDate", "<init>", "()V", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class PluginController {

    /* renamed from: b, reason: collision with root package name */
    public static final PluginController f365404b = new PluginController();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final long startDate = (float) Math.rint((float) (System.currentTimeMillis() / 86400000));

    PluginController() {
    }

    @JvmStatic
    public static final boolean g(@NotNull String pluginName, float sampleRatio) {
        Intrinsics.checkParameterIsNotNull(pluginName, "pluginName");
        if (!f365404b.b(pluginName) || Math.random() >= sampleRatio) {
            return false;
        }
        return true;
    }

    public final void a(@NotNull String pluginName) {
        Intrinsics.checkParameterIsNotNull(pluginName, "pluginName");
        d i3 = ConfigProxy.INSTANCE.getConfig().i(pluginName);
        if (i3 != null) {
            i3.curReportNum++;
            BaseInfo.editor.c("count_plugin_" + i3.pluginName, i3.curReportNum);
            BaseInfo.editor.a();
        }
    }

    public final boolean b(@NotNull String pluginName) {
        Intrinsics.checkParameterIsNotNull(pluginName, "pluginName");
        d i3 = ConfigProxy.INSTANCE.getConfig().i(pluginName);
        if (i3 == null || i3.curReportNum >= i3.com.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String.dailyReportLimit) {
            return false;
        }
        return true;
    }

    public final void c() {
        long j3;
        SharedPreferences sharedPreferences = BaseInfo.sharePreference;
        if (sharedPreferences != null) {
            j3 = sharedPreferences.getLong("last_start_date", 0L);
        } else {
            j3 = startDate;
        }
        long j16 = startDate;
        if (j16 - j3 > 0) {
            BaseInfo.editor.d("last_start_date", j16);
            PluginCombination.INSTANCE.a(new Function1<d, Unit>() { // from class: com.tencent.rmonitor.base.plugin.monitor.PluginController$resetReportNum$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(d dVar) {
                    invoke2(dVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull d it) {
                    Intrinsics.checkParameterIsNotNull(it, "it");
                    BaseInfo.editor.c("count_plugin_" + it.pluginName, 0);
                    it.curReportNum = 0;
                }
            });
            BaseInfo.editor.a();
        } else {
            final SharedPreferences sharedPreferences2 = BaseInfo.sharePreference;
            if (sharedPreferences2 != null) {
                PluginCombination.INSTANCE.a(new Function1<d, Unit>() { // from class: com.tencent.rmonitor.base.plugin.monitor.PluginController$resetReportNum$2$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(d dVar) {
                        invoke2(dVar);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull d it) {
                        Intrinsics.checkParameterIsNotNull(it, "it");
                        it.curReportNum = sharedPreferences2.getInt("count_plugin_" + it.pluginName, 0);
                    }
                });
            }
        }
    }

    public final boolean d(@NotNull String pluginName) {
        float f16;
        Intrinsics.checkParameterIsNotNull(pluginName, "pluginName");
        if (!b(pluginName)) {
            return false;
        }
        d i3 = ConfigProxy.INSTANCE.getConfig().i(pluginName);
        if (i3 != null) {
            f16 = i3.com.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String.eventSampleRatio;
        } else {
            f16 = 0.0f;
        }
        if (Math.random() >= f16) {
            return false;
        }
        return true;
    }

    public final boolean e(@NotNull String pluginName) {
        float f16;
        Intrinsics.checkParameterIsNotNull(pluginName, "pluginName");
        if (!b(pluginName)) {
            return false;
        }
        d i3 = ConfigProxy.INSTANCE.getConfig().i(pluginName);
        if (i3 != null) {
            f16 = i3.com.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String.reportSampleRatio;
        } else {
            f16 = 0.0f;
        }
        if (Math.random() >= f16) {
            return false;
        }
        return true;
    }

    public final boolean f(@NotNull String pluginName) {
        Intrinsics.checkParameterIsNotNull(pluginName, "pluginName");
        d i3 = ConfigProxy.INSTANCE.getConfig().i(pluginName);
        if (i3 != null) {
            return i3.com.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String.enabled;
        }
        return false;
    }
}
