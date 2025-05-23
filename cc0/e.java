package cc0;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.data.idata.IDataDisplaySurface;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes5.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static e30.b f30626a = null;

    /* renamed from: b, reason: collision with root package name */
    public static volatile long f30627b = -1;

    /* renamed from: c, reason: collision with root package name */
    public static volatile int f30628c = -1;

    /* renamed from: d, reason: collision with root package name */
    public static volatile boolean f30629d = false;

    /* renamed from: e, reason: collision with root package name */
    public static volatile long f30630e;

    /* JADX WARN: Multi-variable type inference failed */
    public static e30.b a(String str) {
        IDataDisplaySurface displaySurface;
        MutableLiveData displaySurfaceData;
        UIStateData uIStateData;
        if (!TextUtils.isEmpty(str) && (displaySurface = w20.a.j().getDisplaySurface(e30.b.class, String.valueOf(6))) != null && (displaySurfaceData = displaySurface.getDisplaySurfaceData(new Object[0])) != null && displaySurfaceData.getValue() != 0 && (uIStateData = (UIStateData) displaySurfaceData.getValue()) != null && uIStateData.getData() != null) {
            for (e30.b bVar : new ArrayList((Collection) uIStateData.getData())) {
                if (bVar != null && str.equals(bVar.g().f398449id.get())) {
                    return bVar;
                }
            }
        }
        return null;
    }

    public static void b(e30.b bVar) {
        e30.b a16;
        if (bVar != null && bVar.g() != null && (a16 = a(bVar.g().f398449id.get())) != null && a16 == bVar) {
            f30626a = bVar;
        }
    }

    public static e30.b c(@NonNull String str) {
        e30.b bVar = f30626a;
        if (bVar != null && bVar.g() != null && f30626a.g().f398449id.get().equals(str)) {
            return f30626a;
        }
        return null;
    }

    public static void d(long j3, int i3) {
        RFWLog.d("FeedLine_TEdgeRS_QFSRerankTemp", RFWLog.USR, "[updateLastPlayAdInfo] lastPlayAdTime:" + j3 + ",lastAdIndex:" + i3);
        f30627b = j3;
        f30628c = i3;
        f30629d = false;
    }
}
