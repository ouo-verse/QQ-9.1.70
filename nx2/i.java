package nx2;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.tvideo.channel.event.QFSTVideoChannelClickEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.richframework.thread.RFWThreadManager;
import java.lang.ref.WeakReference;
import java.util.List;
import ox2.b;
import tvideo.TVideoChannelList$VideoChannelData;

/* compiled from: P */
/* loaded from: classes19.dex */
public class i extends c {

    /* renamed from: e, reason: collision with root package name */
    private WeakReference<a> f421533e;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface a {
        void a(List<TVideoChannelList$VideoChannelData> list);

        void b(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface b {
        void a(RecyclerView recyclerView, TextView textView);
    }

    public i(View view) {
        super(view);
        m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(final List list) {
        mx2.d dVar = this.f421526c;
        if (dVar != null && this.f421525b != null) {
            dVar.setData(list);
            RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: nx2.h
                @Override // java.lang.Runnable
                public final void run() {
                    i.this.s(list);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s(List list) {
        WeakReference<a> weakReference = this.f421533e;
        if (weakReference != null && weakReference.get() != null) {
            this.f421533e.get().a(list);
        }
        this.f421525b.scrollToPosition(ox2.b.e().f(ox2.b.e().d()));
    }

    @Override // nx2.c
    protected mx2.d c() {
        return new mx2.f(this.f421525b);
    }

    @Override // nx2.c
    protected RecyclerView.LayoutManager d() {
        return new LinearLayoutManager(this.f421524a.getContext(), 0, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // nx2.c
    /* renamed from: e */
    public void i(TVideoChannelList$VideoChannelData tVideoChannelList$VideoChannelData) {
        ox2.b.e().l(tVideoChannelList$VideoChannelData);
        QFSTVideoChannelClickEvent qFSTVideoChannelClickEvent = new QFSTVideoChannelClickEvent();
        qFSTVideoChannelClickEvent.setChannelId(tVideoChannelList$VideoChannelData.channel_id.get());
        qFSTVideoChannelClickEvent.setFromTitle(true);
        SimpleEventBus.getInstance().dispatchEvent(qFSTVideoChannelClickEvent);
        WeakReference<a> weakReference = this.f421533e;
        if (weakReference != null && weakReference.get() != null) {
            this.f421533e.get().b(tVideoChannelList$VideoChannelData.channel_id.get());
        }
    }

    @Override // nx2.c
    protected String f() {
        return "vertical";
    }

    @Override // nx2.c
    public void k(QFSTVideoChannelClickEvent qFSTVideoChannelClickEvent) {
        if (qFSTVideoChannelClickEvent != null) {
            int channelId = qFSTVideoChannelClickEvent.getChannelId();
            int f16 = ox2.b.e().f(channelId);
            QLog.d("TVideoChannelTitleDisplayer", 1, "[onSelectedChange], position=" + f16);
            this.f421525b.scrollToPosition(f16);
            mx2.d dVar = this.f421526c;
            if (dVar instanceof mx2.f) {
                ((mx2.f) dVar).q0(ox2.b.e().h(channelId));
            }
        }
        mx2.d dVar2 = this.f421526c;
        if (dVar2 != null) {
            dVar2.notifyDataSetChanged();
        }
    }

    @Override // nx2.c
    protected void m() {
        ox2.b.e().k(new b.a() { // from class: nx2.g
            @Override // ox2.b.a
            public final void a(List list) {
                i.this.j(list);
            }
        });
    }

    public void r(int i3) {
        TVideoChannelList$VideoChannelData h16;
        int i16;
        if (this.f421525b == null || this.f421526c == null || (h16 = ox2.b.e().h(i3)) == null) {
            return;
        }
        int f16 = ox2.b.e().f(i3);
        ox2.b.e().l(h16);
        QFSTVideoChannelClickEvent qFSTVideoChannelClickEvent = new QFSTVideoChannelClickEvent();
        qFSTVideoChannelClickEvent.setChannelId(i3);
        SimpleEventBus.getInstance().dispatchEvent(qFSTVideoChannelClickEvent);
        mx2.d dVar = this.f421526c;
        if (f16 == 0) {
            i16 = 0;
        } else {
            i16 = f16 - 1;
        }
        dVar.notifyItemRangeChanged(i16, 3);
        VideoReport.reportEvent("clck", this.f421525b, this.f421526c.j0(h16, f16));
    }

    public void t() {
        WeakReference<a> weakReference = this.f421533e;
        if (weakReference != null) {
            weakReference.clear();
            this.f421533e = null;
        }
    }

    public void u(a aVar) {
        this.f421533e = new WeakReference<>(aVar);
    }

    public void v(b bVar) {
        mx2.d dVar = this.f421526c;
        if (dVar != null) {
            dVar.o0(bVar);
        }
    }
}
