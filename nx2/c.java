package nx2;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.tvideo.channel.event.QFSTVideoChannelClickEvent;
import com.tencent.mobileqq.tvideo.channel.event.QFSTVideoLandScapeChannelClickEvent;
import com.tencent.mobileqq.tvideo.pr.TVideoPrFloatShowShowEvent;
import com.tencent.qqlive.common.screen.ScreenUtils;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.List;
import java.util.Map;
import mx2.d;
import ox2.b;
import tvideo.TVideoChannelList$VideoChannelData;

/* compiled from: P */
/* loaded from: classes19.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    protected final View f421524a;

    /* renamed from: b, reason: collision with root package name */
    protected RecyclerView f421525b;

    /* renamed from: c, reason: collision with root package name */
    protected mx2.d f421526c;

    /* renamed from: d, reason: collision with root package name */
    protected RecyclerView.LayoutManager f421527d;

    public c(View view) {
        this.f421524a = view;
        h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(List list) {
        this.f421526c.setData(list);
    }

    private void l(boolean z16, boolean z17, boolean z18) {
        if (z16) {
            return;
        }
        TVideoPrFloatShowShowEvent tVideoPrFloatShowShowEvent = new TVideoPrFloatShowShowEvent();
        tVideoPrFloatShowShowEvent.setShow(z17);
        tVideoPrFloatShowShowEvent.setHandleLeftWebView(true);
        tVideoPrFloatShowShowEvent.setNeedRestore(true ^ z18);
        SimpleEventBus.getInstance().dispatchEvent(tVideoPrFloatShowShowEvent);
    }

    private void n(View view, String str) {
        Map<String, Object> g16 = gy2.c.g();
        g16.put("style", f());
        VideoReport.setElementParams(view, g16);
        VideoReport.setElementId(view, str);
    }

    protected mx2.d c() {
        return new mx2.b(this.f421525b);
    }

    protected RecyclerView.LayoutManager d() {
        return new LinearLayoutManager(this.f421524a.getContext(), 1, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void i(TVideoChannelList$VideoChannelData tVideoChannelList$VideoChannelData) {
        ox2.b.e().l(tVideoChannelList$VideoChannelData);
        QFSTVideoLandScapeChannelClickEvent qFSTVideoLandScapeChannelClickEvent = new QFSTVideoLandScapeChannelClickEvent();
        qFSTVideoLandScapeChannelClickEvent.setChannelId(tVideoChannelList$VideoChannelData.channel_id.get());
        SimpleEventBus.getInstance().dispatchEvent(qFSTVideoLandScapeChannelClickEvent);
    }

    protected String f() {
        return "horizontal";
    }

    public void g(boolean z16, boolean z17) {
        if (this.f421524a.getVisibility() == 0) {
            l(z16, true, z17);
        }
        this.f421524a.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h() {
        RecyclerView recyclerView = (RecyclerView) this.f421524a.findViewById(R.id.ts8);
        this.f421525b = recyclerView;
        RecyclerView.LayoutManager d16 = d();
        this.f421527d = d16;
        recyclerView.setLayoutManager(d16);
        mx2.d c16 = c();
        this.f421526c = c16;
        this.f421525b.setAdapter(c16);
        this.f421526c.n0(new d.b() { // from class: nx2.a
            @Override // mx2.d.b
            public final void a(TVideoChannelList$VideoChannelData tVideoChannelList$VideoChannelData) {
                c.this.i(tVideoChannelList$VideoChannelData);
            }
        });
    }

    public void k(QFSTVideoChannelClickEvent qFSTVideoChannelClickEvent) {
        mx2.d dVar = this.f421526c;
        if (dVar != null) {
            dVar.notifyDataSetChanged();
        }
    }

    protected void m() {
        ox2.b.e().k(new b.a() { // from class: nx2.b
            @Override // ox2.b.a
            public final void a(List list) {
                c.this.j(list);
            }
        });
    }

    public void o() {
        n(this.f421524a, "channel_nav");
        VideoReport.reportEvent("imp", this.f421524a, null);
        if (this.f421526c.getItemCount() == 0) {
            m();
        }
        this.f421524a.setVisibility(0);
        k(null);
        l(ScreenUtils.isLandscape(), false, false);
    }
}
