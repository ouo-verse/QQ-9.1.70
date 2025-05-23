package ox2;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.tvideo.channel.event.QFSTVideoChannelClickEvent;
import com.tencent.mobileqq.tvideo.channel.event.QFSTVideoLandScapeChannelClickEvent;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.ArrayList;
import nx2.f;
import nx2.i;
import ox2.d;
import tvideo.Video;

/* compiled from: P */
/* loaded from: classes19.dex */
public class d implements SimpleEventReceiver {

    /* renamed from: h, reason: collision with root package name */
    private static boolean f424449h = true;

    /* renamed from: d, reason: collision with root package name */
    private i f424450d;

    /* renamed from: e, reason: collision with root package name */
    private f f424451e;

    /* renamed from: f, reason: collision with root package name */
    private nx2.d f424452f;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a implements i.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f424453a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Video f424454b;

        a(Activity activity, Video video) {
            this.f424453a = activity;
            this.f424454b = video;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void c(Activity activity, RecyclerView recyclerView, TextView textView, Video video) {
            if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
                View childAt = recyclerView.getChildAt(1);
                View view = textView;
                if (childAt != null) {
                    view = childAt;
                }
                px2.b.e(view, video);
            }
        }

        @Override // nx2.i.b
        public void a(final RecyclerView recyclerView, final TextView textView) {
            if (d.f424449h) {
                d.f424449h = false;
                RFWThreadManager rFWThreadManager = RFWThreadManager.getInstance();
                final Activity activity = this.f424453a;
                final Video video = this.f424454b;
                rFWThreadManager.runOnUiThread(new Runnable() { // from class: ox2.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        d.a.c(activity, recyclerView, textView, video);
                    }
                }, 1000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private static final d f424456a = new d();
    }

    d() {
    }

    public static d c() {
        return b.f424456a;
    }

    public i d() {
        return this.f424450d;
    }

    public void e() {
        f fVar = this.f424451e;
        if (fVar != null) {
            fVar.g(false, false);
        }
    }

    public void f(View view) {
        if (this.f424452f == null) {
            this.f424452f = new nx2.d(view);
        }
    }

    public void g(Activity activity, View view, Video video) {
        f424449h = true;
        this.f424450d = new i(view);
        SimpleEventBus.getInstance().registerReceiver(this);
        c().j(new a(activity, video));
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(QFSTVideoChannelClickEvent.class);
        arrayList.add(QFSTVideoLandScapeChannelClickEvent.class);
        return arrayList;
    }

    public void h() {
        this.f424450d = null;
        this.f424451e = null;
        this.f424452f = null;
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    public void i(boolean z16) {
        nx2.d dVar = this.f424452f;
        if (dVar != null) {
            if (z16) {
                dVar.o();
            } else {
                dVar.g(true, false);
            }
        }
    }

    public void j(i.b bVar) {
        i iVar = this.f424450d;
        if (iVar != null) {
            iVar.v(bVar);
        }
    }

    public void k(View view) {
        if (this.f424451e == null) {
            this.f424451e = new f(view);
        }
        this.f424451e.o();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSTVideoChannelClickEvent) {
            QFSTVideoChannelClickEvent qFSTVideoChannelClickEvent = (QFSTVideoChannelClickEvent) simpleBaseEvent;
            if (this.f424450d != null && !qFSTVideoChannelClickEvent.getFromTitle()) {
                this.f424450d.k(qFSTVideoChannelClickEvent);
            }
            f fVar = this.f424451e;
            if (fVar != null) {
                fVar.k(qFSTVideoChannelClickEvent);
            }
            nx2.d dVar = this.f424452f;
            if (dVar != null) {
                dVar.k(qFSTVideoChannelClickEvent);
            }
        }
    }
}
