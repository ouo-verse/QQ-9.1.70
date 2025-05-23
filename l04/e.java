package l04;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.tencent.bugly.common.thread.ThreadManager;
import com.tencent.rmonitor.base.plugin.listener.IBaseListener;
import com.tencent.rmonitor.common.logger.Logger;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes25.dex */
public class e implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: m, reason: collision with root package name */
    private static final Long f413616m = 1000L;

    /* renamed from: d, reason: collision with root package name */
    private final String f413617d;

    /* renamed from: e, reason: collision with root package name */
    private final WeakReference<View> f413618e;

    /* renamed from: f, reason: collision with root package name */
    private final b f413619f;

    /* renamed from: h, reason: collision with root package name */
    private final c f413620h;

    /* renamed from: i, reason: collision with root package name */
    private final Handler f413621i = new a(ThreadManager.getMonitorThreadLooper());

    /* compiled from: P */
    /* loaded from: classes25.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NotNull Message message) {
            try {
                if (e.this.f413618e != null && e.this.f413618e.get() != null && (e.this.f413618e.get() instanceof ViewGroup)) {
                    ArrayList arrayList = new ArrayList();
                    e eVar = e.this;
                    eVar.e(arrayList, eVar.f413617d, com.tencent.rmonitor.common.util.c.a(e.this.f413618e.get(), null), (View) e.this.f413618e.get());
                    if (arrayList.size() > 0) {
                        e.this.f(arrayList);
                    }
                }
            } catch (Throwable th5) {
                Logger.f365497g.c("RMonitor_BigBitmap_RootViewDetectListener", th5);
            }
        }
    }

    public e(String str, View view, b bVar, c cVar) {
        this.f413617d = str;
        this.f413618e = new WeakReference<>(view);
        this.f413619f = bVar;
        this.f413620h = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(List<n04.b> list, String str, String str2, View view) {
        if (view != null && view.getVisibility() != 8 && view.getWidth() > 0 && view.getHeight() > 0) {
            this.f413619f.c(list, str, str2, view);
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (viewGroup.getChildCount() > 0) {
                    for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                        View childAt = viewGroup.getChildAt(i3);
                        if (childAt != null) {
                            e(list, str, str2 + " \n " + com.tencent.rmonitor.common.util.c.a(childAt, Integer.valueOf(i3)), childAt);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(List<n04.b> list) {
        this.f413620h.d(list);
        Iterator<IBaseListener> it = i04.a.bigBitmapListener.c().iterator();
        while (it.hasNext()) {
            IBaseListener next = it.next();
            if (next instanceof o04.a) {
                ((o04.a) next).a(list);
            }
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        this.f413621i.removeMessages(0);
        this.f413621i.sendEmptyMessageDelayed(0, f413616m.longValue());
    }
}
