package i04;

import android.support.annotation.RestrictTo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.rmonitor.base.plugin.listener.IBaseListener;
import com.tencent.rmonitor.base.plugin.listener.IBatteryListener;
import com.tencent.rmonitor.base.plugin.listener.ICustomDataCollector;
import com.tencent.rmonitor.base.plugin.listener.ICustomDataCollectorForIssue;
import com.tencent.rmonitor.base.plugin.listener.IDBTracerListener;
import com.tencent.rmonitor.base.plugin.listener.IDeviceInfoListener;
import com.tencent.rmonitor.base.plugin.listener.IDropFrameListener;
import com.tencent.rmonitor.base.plugin.listener.IIoTracerListener;
import com.tencent.rmonitor.base.plugin.listener.ILooperListener;
import com.tencent.rmonitor.base.plugin.listener.IMemoryCeilingListener;
import com.tencent.rmonitor.base.plugin.listener.IMemoryLeakListener;
import com.tencent.rmonitor.base.plugin.listener.IMemoryPeakListener;
import com.tencent.rmonitor.base.plugin.listener.IPluginStateListener;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b/\u00100R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0005R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0005R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0005R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0005R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00130\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0005R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00130\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0005R\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00180\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0005R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00130\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0005R\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0005R\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020 0\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\u0005R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020#0\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010\u0005R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020&0\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010\u0005R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020)0\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010\u0005R\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020,0\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010\u0005\u00a8\u00061"}, d2 = {"Li04/a;", "", "Li04/b;", "Lcom/tencent/rmonitor/base/plugin/listener/IMemoryLeakListener;", "a", "Li04/b;", "memoryLeakListener", "Lcom/tencent/rmonitor/base/plugin/listener/IMemoryCeilingListener;", "b", "memoryCeilingListener", "Lcom/tencent/rmonitor/base/plugin/listener/IDropFrameListener;", "c", "dropFrameListener", "Lcom/tencent/rmonitor/base/plugin/listener/ILooperListener;", "d", "looperListener", "Lcom/tencent/rmonitor/base/plugin/listener/IIoTracerListener;", "e", "ioTracerListener", "Lcom/tencent/rmonitor/base/plugin/listener/IBaseListener;", "f", "bigBitmapListener", "g", "fdLeakListener", "Lcom/tencent/rmonitor/base/plugin/listener/IDBTracerListener;", h.F, "dbTracerListener", "i", "natMemListener", "Lcom/tencent/rmonitor/base/plugin/listener/IDeviceInfoListener;", "j", "deviceInfoListener", "Lcom/tencent/rmonitor/base/plugin/listener/IBatteryListener;", "k", "batteryListener", "Lcom/tencent/rmonitor/base/plugin/listener/IPluginStateListener;", "l", "pluginStateListener", "Lcom/tencent/rmonitor/base/plugin/listener/ICustomDataCollector;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "customDataCollector", "Lcom/tencent/rmonitor/base/plugin/listener/ICustomDataCollectorForIssue;", DomainData.DOMAIN_NAME, "customDataCollectorForIssue", "Lcom/tencent/rmonitor/base/plugin/listener/IMemoryPeakListener;", "o", "memoryPeakListener", "<init>", "()V", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes25.dex */
public final class a {

    /* renamed from: p, reason: collision with root package name */
    public static final a f407011p = new a();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public static final b<IMemoryLeakListener> memoryLeakListener = new b<>();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public static final b<IMemoryCeilingListener> memoryCeilingListener = new b<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public static final b<IDropFrameListener> dropFrameListener = new b<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public static final b<ILooperListener> looperListener = new b<>();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public static final b<IIoTracerListener> ioTracerListener = new b<>();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public static final b<IBaseListener> bigBitmapListener = new b<>();

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public static final b<IBaseListener> fdLeakListener = new b<>();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public static b<IDBTracerListener> dbTracerListener = new b<>();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public static final b<IBaseListener> natMemListener = new b<>();

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public static final b<IDeviceInfoListener> deviceInfoListener = new b<>();

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public static final b<IBatteryListener> batteryListener = new b<>();

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public static final b<IPluginStateListener> pluginStateListener = new b<>();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public static final b<ICustomDataCollector> customDataCollector = new b<>();

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public static final b<ICustomDataCollectorForIssue> customDataCollectorForIssue = new b<>();

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @JvmField
    @NotNull
    public static final b<IMemoryPeakListener> memoryPeakListener = new b<>();

    a() {
    }
}
