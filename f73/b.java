package f73;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.wink.editor.music.lyric.common.TimerTaskManager;

/* compiled from: P */
/* loaded from: classes21.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final c<Handler, Void> f397976a = new a();

    /* renamed from: b, reason: collision with root package name */
    private static c<TimerTaskManager, Void> f397977b = new C10285b();

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class a extends c<Handler, Void> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // f73.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Handler a(Void r26) {
            return new Handler(Looper.getMainLooper());
        }
    }

    /* compiled from: P */
    /* renamed from: f73.b$b, reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    class C10285b extends c<TimerTaskManager, Void> {
        C10285b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // f73.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public TimerTaskManager a(Void r16) {
            return new TimerTaskManager();
        }
    }

    public static Handler a() {
        return f397976a.b(null);
    }

    public static TimerTaskManager b() {
        return f397977b.b(null);
    }
}
