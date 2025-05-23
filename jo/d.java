package jo;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.qzone.report.QZonePerfReporter;
import com.tencent.util.AppSetting;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0016\u0018\u0000 ,2\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0004\u00a2\u0006\u0004\b+\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\r\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0007H\u0016J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0004H\u0016J\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0007H\u0016J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u0004H\u0016R\"\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001a0\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u001bR&\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u00040\u001dj\b\u0012\u0004\u0012\u00020\u0004`\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u001fR\u0016\u0010#\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\"R\u0016\u0010%\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010\"R\u0016\u0010&\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\"R\u0016\u0010'\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\"R\u0016\u0010(\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\"R\u0016\u0010*\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010)\u00a8\u0006-"}, d2 = {"Ljo/d;", "", "Landroid/view/View;", "itemView", "", "c", "msg", "", "isError", "", "d", "f", "shouldLog", "g", "key", tl.h.F, "i", "a", "b", "Ljava/lang/String;", "getMMonitorName", "()Ljava/lang/String;", "setMMonitorName", "(Ljava/lang/String;)V", "mMonitorName", "", "", "Ljava/util/Map;", "mStartTimeMap", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "mStartLogMap", "", "I", "mLogThresholdTime", "e", "mRecordThresholdTime", "mWarnThresholdTime", "mReportThresholdTime", "mLogReportLevel", "Z", "mLogEnable", "<init>", "j", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String mMonitorName;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private Map<String, Long> mStartTimeMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private ArrayList<String> mStartLogMap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int mLogThresholdTime;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int mRecordThresholdTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int mWarnThresholdTime;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int mReportThresholdTime;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mLogReportLevel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean mLogEnable;

    public d(String mMonitorName) {
        Intrinsics.checkNotNullParameter(mMonitorName, "mMonitorName");
        this.mMonitorName = mMonitorName;
        this.mStartTimeMap = new LinkedHashMap();
        this.mStartLogMap = new ArrayList<>();
        this.mLogThresholdTime = 5;
        this.mRecordThresholdTime = 10;
        this.mWarnThresholdTime = 20;
        this.mReportThresholdTime = 20;
        this.mLogReportLevel = 2;
        this.mLogEnable = !AppSetting.isPublicVersion();
    }

    private final String c(View itemView) {
        return itemView.getClass().getSimpleName() + "#" + this.mMonitorName;
    }

    private final void d(String msg2, boolean isError) {
        if (this.mLogEnable) {
            if (isError) {
                Log.e("qzone_monitor_" + this.mMonitorName, msg2);
                return;
            }
            Log.d("qzone_monitor_" + this.mMonitorName, msg2);
        }
    }

    public void a(View itemView) {
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        b(c(itemView));
    }

    public void b(String key) {
        Long l3;
        Intrinsics.checkNotNullParameter(key, "key");
        if (TextUtils.isEmpty(key) || (l3 = this.mStartTimeMap.get(key)) == null) {
            return;
        }
        l3.longValue();
        long currentTimeMillis = System.currentTimeMillis() - l3.longValue();
        this.mStartTimeMap.remove(key);
        if (currentTimeMillis >= this.mLogThresholdTime || this.mStartLogMap.contains(key)) {
            d(key + ", end cost " + currentTimeMillis + " ms", currentTimeMillis > ((long) this.mWarnThresholdTime));
            if (currentTimeMillis > this.mReportThresholdTime) {
                QZonePerfReporter.f59697a.i(key, currentTimeMillis);
            }
            if (currentTimeMillis > this.mRecordThresholdTime) {
                com.qzone.reborn.debug.timecost.b.f53835a.c(this.mMonitorName, key, currentTimeMillis);
            }
            this.mStartLogMap.remove(key);
        }
    }

    public void f(View itemView) {
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        i(c(itemView), false);
    }

    public void g(View itemView, boolean shouldLog) {
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        i(c(itemView), shouldLog);
    }

    public void h(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        i(key, false);
    }

    public void i(String key, boolean shouldLog) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (TextUtils.isEmpty(key)) {
            return;
        }
        this.mStartTimeMap.put(key, Long.valueOf(System.currentTimeMillis()));
        if (shouldLog) {
            e(this, key + ", >>>start", false, 2, null);
            this.mStartLogMap.add(key);
        }
    }

    static /* synthetic */ void e(d dVar, String str, boolean z16, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                z16 = false;
            }
            dVar.d(str, z16);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: log");
    }
}
