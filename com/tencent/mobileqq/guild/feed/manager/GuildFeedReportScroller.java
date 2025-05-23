package com.tencent.mobileqq.guild.feed.manager;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.report.GuildFeedReportTable12003;
import com.tencent.mobileqq.guild.feed.report.GuildFeedReporter;
import com.tencent.mobileqq.guild.feed.report.GuildReportBean;
import com.tencent.mobileqq.guild.feed.widget.GuildBaseWidgetView;
import com.tencent.mobileqq.guild.mainframe.GuildFeedReportSourceInfo;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildFeedReportScroller extends com.tencent.mobileqq.guild.feed.manager.b {
    private final GuildReportBean E;
    private final int J;
    private final GuildFeedReportSourceInfo K;
    private final HashMap<Integer, a> F = new HashMap<>();
    private final HashMap<Integer, a> G = new HashMap<>();
    private final HashMap<Integer, a> H = new HashMap<>();
    private final ArrayList<b> I = new ArrayList<>();
    private boolean L = true;

    /* compiled from: P */
    /* loaded from: classes13.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private View f220132a;

        /* renamed from: b, reason: collision with root package name */
        private long f220133b;

        /* renamed from: c, reason: collision with root package name */
        private long f220134c;

        /* renamed from: d, reason: collision with root package name */
        private int f220135d;

        /* renamed from: e, reason: collision with root package name */
        private ij1.g f220136e;

        public ij1.g b() {
            return this.f220136e;
        }

        public View c() {
            return this.f220132a;
        }

        public int d() {
            return this.f220135d;
        }

        public long e() {
            return this.f220134c;
        }

        public void f(ij1.g gVar) {
            this.f220136e = gVar;
        }

        public void g() {
            this.f220133b = System.currentTimeMillis();
        }
    }

    /* compiled from: P */
    /* loaded from: classes13.dex */
    public interface b {
        void a(RecyclerView recyclerView, int i3, int i16, boolean z16);

        void onPause();

        void onResume();
    }

    public GuildFeedReportScroller(int i3, GuildReportBean guildReportBean, GuildFeedReportSourceInfo guildFeedReportSourceInfo) {
        this.J = i3;
        this.E = guildReportBean;
        this.K = guildFeedReportSourceInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(String str) {
        Iterator<Map.Entry<Integer, a>> it = this.H.entrySet().iterator();
        while (it.hasNext()) {
            a value = it.next().getValue();
            if (value != null) {
                u(value.f220132a, str, true);
                it.remove();
            }
        }
        QLog.d("GuildFeedReportScroller", 4, "flushValidExposeReport by " + str + ",retain size:" + this.H.size());
    }

    private int B(View view) {
        if (!(view instanceof BaseWidgetView)) {
            return 0;
        }
        return ((BaseWidgetView) view).getDataPosInList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ij1.g C(View view) {
        if (!(view instanceof BaseWidgetView)) {
            return null;
        }
        GuildBaseWidgetView guildBaseWidgetView = (GuildBaseWidgetView) view;
        if (!(guildBaseWidgetView.getData() instanceof ij1.g)) {
            return null;
        }
        return (ij1.g) guildBaseWidgetView.getData();
    }

    private ij1.g D(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder != null) {
            return C(viewHolder.itemView);
        }
        return null;
    }

    private boolean E(View view) {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void F(a aVar) {
        if (aVar != null && (aVar.c() instanceof GuildBaseWidgetView)) {
            GuildBaseWidgetView guildBaseWidgetView = (GuildBaseWidgetView) aVar.c();
            ij1.g gVar = (ij1.g) guildBaseWidgetView.getData();
            String str = gVar.b().idd;
            aVar.f(gVar);
            QLog.d("GuildFeedReportScroller", 4, "refreshBeanData,index:" + guildBaseWidgetView.getDataPosInList() + ",feedId:" + str + ",pageId:" + this.J);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(ij1.g gVar, int i3, boolean z16) {
        if (gVar == null) {
            return;
        }
        GuildFeedReportTable12003.b(new GuildFeedReportTable12003.a(com.tencent.mobileqq.guild.feed.report.f.b(gVar.b(), this.K.getReportInfoMap().get("extra_feeds_page_forum_type")).K("imp").J("success").Y(this.K.getReportInfoMap().get("extra_feeds_page_id")).V(this.K.getReportInfoMap().get("extra_feeds_page_forum_type")).g0(this.K.getReportInfoMap().get("extra_feeds_pre_page_id")).f0(this.K.getReportInfoMap().get("extra_feeds_pre_page_forum_type"))));
    }

    private void I() {
        for (Map.Entry<Integer, a> entry : this.G.entrySet()) {
            int intValue = entry.getKey().intValue();
            a value = entry.getValue();
            if (!this.H.containsKey(Integer.valueOf(intValue)) && x(value.c()) && value.b() != null) {
                this.H.put(Integer.valueOf(intValue), value);
                QLog.d("GuildFeedReportScroller", 4, "add validExposePool from scroll,index:" + value.d() + ",feedId:" + value.b().b().idd + ",pageId:" + this.J);
                if (w(Integer.valueOf(intValue), value)) {
                    QLog.d("GuildFeedReportScroller", 4, "record feed stay event from scroll,index:" + value.d() + ",feedId:" + value.b().b().idd + ",pageId:" + this.J);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(String str) {
        QLog.d("GuildFeedReportScroller", 4, "scanValidExposeWhenRefreshOrResume,baseExposePool size:" + this.G.size() + ",validExposePool size:" + this.H.size());
        for (a aVar : this.G.values()) {
            if (aVar != null) {
                if (aVar.c() != null) {
                    aVar.c().setTag(R.id.f166942ja3, Boolean.FALSE);
                    u(aVar.c(), str, false);
                }
                F(aVar);
                if (x(aVar.c()) && aVar.b() != null) {
                    aVar.g();
                    this.F.put(Integer.valueOf(aVar.d()), aVar);
                    QLog.d("GuildFeedReportScroller", 4, "record feed stay event from " + str + ",index:" + aVar.d() + ",feedId:" + aVar.b().b().idd + ",pageId:" + this.J);
                    u(aVar.c(), str, true);
                }
            }
        }
    }

    private void u(View view, final String str, final boolean z16) {
        if (!E(view)) {
            return;
        }
        if (z16 && !v(view)) {
            return;
        }
        final ij1.g C = C(view);
        final int B = B(view);
        if (C == null) {
            QLog.e("GuildFeedReportScroller", 1, "asyncReportFeedExpose no feed data!from " + str + ",index:" + B + ",pageId:" + this.J);
            return;
        }
        GuildFeedReporter.o().n().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.manager.GuildFeedReportScroller.1
            @Override // java.lang.Runnable
            public void run() {
                GuildFeedReportScroller.this.G(C, B, z16);
                QLog.d("GuildFeedReportScroller", 4, "report expose from " + str + ",isValid:" + z16 + ",index:" + B + ",feedId:" + C.b().idd + ",pageId:" + GuildFeedReportScroller.this.J);
            }
        });
    }

    private boolean v(View view) {
        if (view != null) {
            Object tag = view.getTag(R.id.f166942ja3);
            boolean z16 = true;
            if (tag instanceof Boolean) {
                z16 = true ^ ((Boolean) tag).booleanValue();
            }
            if (z16) {
                view.setTag(R.id.f166942ja3, Boolean.TRUE);
            }
            return z16;
        }
        return false;
    }

    private boolean w(Integer num, a aVar) {
        if (!this.F.containsValue(aVar)) {
            aVar.g();
            this.F.put(num, aVar);
            return true;
        }
        return false;
    }

    private boolean x(View view) {
        int i3;
        if (view == null) {
            return false;
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        int height = view.getHeight();
        int i16 = rect.bottom;
        if (i16 > 0) {
            i3 = i16 - rect.top;
        } else {
            i3 = 0;
        }
        float f16 = i3 / height;
        if (f16 < 0.5d || Float.isNaN(f16)) {
            return false;
        }
        return true;
    }

    private void y(int i3, int i16, RecyclerView.LayoutManager layoutManager) {
        if (i3 > i16) {
            return;
        }
        while (i3 <= i16) {
            View findViewByPosition = layoutManager.findViewByPosition(i3);
            if (E(findViewByPosition) && x(findViewByPosition)) {
                u(findViewByPosition, "onIdle", true);
            }
            i3++;
        }
    }

    private void z(String str) {
        Iterator<Map.Entry<Integer, a>> it = this.F.entrySet().iterator();
        while (it.hasNext()) {
            a value = it.next().getValue();
            if (value != null) {
                H(value);
                QLog.d("GuildFeedReportScroller", 4, "report feed stay event from flush by " + str + ",index:" + value.d() + ",feedId:" + value.b().b().idd + ",pageId:" + this.J + ",stayTime:" + value.e() + "ms");
            }
            it.remove();
        }
        QLog.d("GuildFeedReportScroller", 4, "flushStayEventReport by " + str + ",retain size:" + this.F.size());
    }

    @Override // com.tencent.mobileqq.guild.feed.manager.b
    public void g() {
        if (this.L) {
            QLog.d("GuildFeedReportScroller", 4, MiniSDKConst.NOTIFY_EVENT_ONPAUSE + ",pageId:" + this.J);
            A(MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
            z(MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        }
        this.L = d();
        if (this.I.size() > 0) {
            Iterator<b> it = this.I.iterator();
            while (it.hasNext()) {
                it.next().onPause();
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.manager.b
    public void h() {
        boolean d16 = d();
        this.L = d16;
        if (d16 && this.G.size() > 0) {
            QLog.d("GuildFeedReportScroller", 4, "onRefresh,pageId:" + this.J);
            z(HippyScrollViewEventHelper.EVENT_TYPE_REFRESH);
            A(HippyScrollViewEventHelper.EVENT_TYPE_REFRESH);
            RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.manager.GuildFeedReportScroller.2
                @Override // java.lang.Runnable
                public void run() {
                    GuildFeedReportScroller.this.J(HippyScrollViewEventHelper.EVENT_TYPE_REFRESH);
                    GuildFeedReportScroller.this.A(HippyScrollViewEventHelper.EVENT_TYPE_REFRESH);
                }
            }, 100L);
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.manager.b
    public void i(RecyclerView recyclerView, int i3, int i16, boolean z16) {
        if (!this.L) {
            return;
        }
        I();
        if (this.I.size() > 0) {
            Iterator<b> it = this.I.iterator();
            while (it.hasNext()) {
                it.next().a(recyclerView, i3, i16, z16);
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.manager.b
    public void j(RecyclerView recyclerView, int i3, RecyclerView.LayoutManager layoutManager, int i16, int i17, int i18, int i19, boolean z16) {
        if (this.L && i3 == 0) {
            try {
                y(i16, i17, layoutManager);
            } catch (Exception e16) {
                QLog.e("GuildFeedReportScroller", 1, "findValidItemAndReport error", e16);
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.manager.b
    public void k(RecyclerView.ViewHolder viewHolder) {
        if (E(viewHolder.itemView) && this.L) {
            u(viewHolder.itemView, "onAttach", false);
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.manager.b
    public void l(RecyclerView.ViewHolder viewHolder) {
        if (!E(viewHolder.itemView)) {
            return;
        }
        ij1.g D = D(viewHolder);
        int B = B(viewHolder.itemView);
        if (D == null) {
            QLog.e("GuildFeedReportScroller", 1, "onViewDetachedFromWindow holder miss feed data!pageId:" + this.J);
            return;
        }
        String str = D.b().idd;
        if (this.G.containsKey(Integer.valueOf(B))) {
            QLog.d("GuildFeedReportScroller", 4, "remove baseExposePool from detach,index:" + B + ",feedId:" + str + ",pageId:" + this.J);
            this.G.remove(Integer.valueOf(B));
        }
        if (this.F.containsKey(Integer.valueOf(B))) {
            a aVar = this.F.get(Integer.valueOf(B));
            if (aVar != null) {
                H(aVar);
                QLog.d("GuildFeedReportScroller", 4, "report feed stay event from detach,index:" + B + ",feedId:" + str + ",pageId:" + this.J + ",stayTime:" + aVar.e() + "ms");
            }
            this.F.remove(Integer.valueOf(B));
        }
        if (this.H.containsKey(Integer.valueOf(B))) {
            u(viewHolder.itemView, "onDetach", true);
            this.H.remove(Integer.valueOf(B));
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.manager.b
    public void onDestroy() {
        Iterator<Integer> it = this.F.keySet().iterator();
        while (it.hasNext()) {
            Integer next = it.next();
            if (next != null) {
                a aVar = this.F.get(next);
                if (aVar != null) {
                    H(aVar);
                    if (aVar.b() != null) {
                        QLog.d("GuildFeedReportScroller", 4, "report feed stay event from destory,index:" + aVar.d() + ",feedId:" + aVar.b().b().idd + ",pageId:" + this.J + ",stayTime:" + aVar.e() + "ms");
                    }
                }
                it.remove();
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.manager.b
    public void onResume() {
        boolean d16 = d();
        this.L = d16;
        if (d16) {
            QLog.d("GuildFeedReportScroller", 4, "onResume,pageId:" + this.J);
            J("onResume");
            A("onResume");
        }
        if (this.I.size() > 0) {
            Iterator<b> it = this.I.iterator();
            while (it.hasNext()) {
                it.next().onResume();
            }
        }
    }

    private void H(a aVar) {
    }
}
