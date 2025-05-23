package com.tencent.guild.aio.input.at.hashtag.ui;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.guild.aio.input.at.hashtag.ui.GuildHashtagListAdapter;
import com.tencent.guild.api.channel.IGuildChannelApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.aiopopuppanel.service.api.IGuildAIOPopupPanelServiceApi;
import com.tencent.mobileqq.guild.event.GuildHashtagDialogDismissEvent;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProCategoryChannelInfoList;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import uo0.p;

/* compiled from: P */
/* loaded from: classes6.dex */
public class g implements ho0.a, PopupWindow.OnDismissListener, p.b {
    private qp0.a C;
    private f D;
    private View H;
    private GuildHashtagListAdapter.b I;
    private GPServiceObserver J;
    private String K;
    private PopupWindow.OnDismissListener R;

    /* renamed from: d, reason: collision with root package name */
    private Activity f110924d;

    /* renamed from: f, reason: collision with root package name */
    private String f110926f;

    /* renamed from: h, reason: collision with root package name */
    private String f110927h;

    /* renamed from: i, reason: collision with root package name */
    private int f110928i;

    /* renamed from: m, reason: collision with root package name */
    private int f110929m;
    private boolean G = false;
    private boolean L = false;
    private String M = "";
    private int N = 0;
    private int P = 0;
    private String Q = "";

    /* renamed from: e, reason: collision with root package name */
    private AppRuntime f110925e = MobileQQ.sMobileQQ.peekAppRuntime();
    private GuildHashtagListAdapter E = new GuildHashtagListAdapter();
    private uo0.b F = new uo0.b(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class a extends GPServiceObserver {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelInfoUpdated(String str) {
            if (((IGPSService) g.this.f110925e.getRuntimeService(IGPSService.class, "")).getGuildIdOf(str).equals(g.this.f110926f) && g.this.L) {
                g gVar = g.this;
                gVar.h(gVar.K);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelListUpdated(String str) {
            if (g.this.f110926f.equals(str) && g.this.L) {
                g gVar = g.this;
                gVar.h(gVar.K);
            }
        }
    }

    public g(String str, String str2, Activity activity, int i3) {
        this.f110926f = str;
        this.f110927h = str2;
        this.f110929m = i3;
        this.f110924d = activity;
        IGProChannelInfo channelInfo = ((IGPSService) this.f110925e.getRuntimeService(IGPSService.class, "")).getChannelInfo(this.f110927h);
        if (channelInfo != null) {
            this.f110928i = channelInfo.getType();
        }
        k();
    }

    private boolean g() {
        if (this.N == 0) {
            return true;
        }
        return false;
    }

    private void i(List<IGProCategoryChannelInfoList> list) {
        boolean z16;
        ArrayList<IGProChannel> channelInfoList;
        if (list == null || list.isEmpty() || this.N == 0) {
            return;
        }
        if (this.P != 0 && !((IGPSService) this.f110925e.getRuntimeService(IGPSService.class, "")).getGuildPermission(this.f110926f).a(this.P)) {
            z16 = false;
        } else {
            z16 = true;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            IGProCategoryChannelInfoList iGProCategoryChannelInfoList = list.get(i3);
            if (iGProCategoryChannelInfoList != null && (channelInfoList = iGProCategoryChannelInfoList.getChannelInfoList()) != null && !channelInfoList.isEmpty()) {
                Iterator<IGProChannel> it = channelInfoList.iterator();
                while (it.hasNext()) {
                    IGProChannel next = it.next();
                    if (!TextUtils.isEmpty(this.Q) && TextUtils.equals(String.valueOf(next.getChannelId()), this.Q)) {
                        it.remove();
                    } else if (this.N != 0 && next.getChannelType() != this.N) {
                        it.remove();
                    } else if (!z16 && next.getIsChannelAdmin() != 1 && next.getIsCategoryAdmin() != 1) {
                        it.remove();
                    }
                }
            }
        }
    }

    private int j() {
        return this.f110929m;
    }

    private void l() {
        boolean z16;
        if (QLog.isColorLevel()) {
            QLog.i("GuildHashtagManager", 2, "initPanel");
        }
        int i3 = this.f110928i;
        if (i3 != 5 && i3 != 2) {
            z16 = false;
        } else {
            z16 = true;
        }
        f f16 = f.f(this.f110924d, -1, -1, z16, this.f110929m, this.C);
        this.D = f16;
        f16.setFocusable(this.G);
        this.D.setOutsideTouchable(false);
        this.D.setOnDismissListener(this);
        this.E.r(this.D.n().h());
        this.E.p(g());
        ListView listView = (ListView) this.D.l().findViewById(R.id.w1z);
        listView.setSelector(new ColorDrawable(0));
        listView.setAdapter((ListAdapter) this.E);
        listView.setOnItemClickListener(this.E);
        this.E.notifyDataSetChanged();
    }

    private void m() {
        r();
        this.D.v(this.H);
        s("pgin");
    }

    private void s(String str) {
        if (!g()) {
            return;
        }
        VideoReport.addToDetectionWhitelist(this.f110924d);
        VideoReport.setPageId(this.D.getContentView(), "pg_sgrp_sub_channel_link");
        HashMap hashMap = new HashMap();
        hashMap.put("dt_pgid", "pg_sgrp_sub_channel_link");
        hashMap.put("sgrp_channel_id", this.f110926f);
        hashMap.put("sgrp_sub_channel_id", this.f110927h);
        hashMap.put("sgrp_subchannel_type", Integer.valueOf(this.f110928i));
        VideoReport.setPageParams(this.D.getContentView(), new PageParams(hashMap));
        VideoReport.reportEvent(str, this.D.getContentView(), hashMap);
    }

    private void t(String str, boolean z16) {
        this.K = str;
        this.F.u(this.f110926f, str, z16);
    }

    @Override // ho0.a
    public boolean dismissPanel() {
        if (o()) {
            this.D.dismiss();
            s("pgout");
            return true;
        }
        return false;
    }

    @Override // ze1.d
    public void e(ze1.c cVar, String str, List list, Object obj) {
        IGProChannel iGProChannel;
        if (cVar instanceof uo0.d) {
            iGProChannel = ((uo0.d) cVar).q();
        } else {
            iGProChannel = null;
        }
        if (!ko0.a.c(list)) {
            if (o()) {
                i(list);
                int count = this.E.getCount();
                this.E.o(list, iGProChannel);
                if (count != this.E.getCount()) {
                    this.D.e();
                    return;
                }
                return;
            }
            if (this.L) {
                i(list);
                this.E.o(list, iGProChannel);
                m();
                return;
            }
            return;
        }
        dismissPanel();
    }

    public void h(String str) {
        if (str == null) {
            return;
        }
        t(str, true);
    }

    protected void k() {
        this.J = new a();
        ((IGPSService) this.f110925e.getRuntimeService(IGPSService.class, "")).addObserver(this.J);
    }

    public boolean n() {
        if (com.tencent.guild.aio.input.at.utils.j.b(j(), -3) != 0) {
            return true;
        }
        return false;
    }

    public boolean o() {
        f fVar = this.D;
        if (fVar != null && fVar.isShowing()) {
            return true;
        }
        return false;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        com.tencent.guild.aio.input.at.utils.j.e(j(), 2);
        this.E.q(null);
        this.L = false;
        PopupWindow.OnDismissListener onDismissListener = this.R;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
        SimpleEventBus.getInstance().dispatchEvent(new GuildHashtagDialogDismissEvent(), true);
    }

    public boolean p() {
        return false;
    }

    public void q() {
        dismissPanel();
        this.F.e();
        ((IGPSService) this.f110925e.getRuntimeService(IGPSService.class, "")).deleteObserver(this.J);
    }

    public void r() {
        String currentThemeId = ((IGuildChannelApi) QRoute.api(IGuildChannelApi.class)).getCurrentThemeId();
        if (!this.M.equals(currentThemeId) && !this.M.equals("") && this.f110924d != null) {
            this.D.dismiss();
            this.D = null;
            l();
        }
        this.M = currentThemeId;
        ((IGuildAIOPopupPanelServiceApi) QRoute.api(IGuildAIOPopupPanelServiceApi.class)).markScenePopupPanelType(j(), 2);
    }

    public void u(String str) {
        this.Q = str;
    }

    public void v(int i3) {
        this.N = i3;
    }

    public void w(GuildHashtagListAdapter.b bVar) {
        this.I = bVar;
    }

    public void x(int i3) {
        this.P = i3;
    }

    public void y(qp0.a aVar) {
        this.C = aVar;
    }

    public void z(View view, String str) {
        if (n()) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("GuildHashtagManager", 2, "showPanel");
        }
        if (this.D == null) {
            l();
        }
        this.E.q(this.I);
        this.H = view;
        this.L = true;
        if (!TextUtils.isEmpty(str)) {
            this.L = false;
            str = "";
        }
        t(str, true);
    }

    @Override // ze1.d
    public void d(ze1.c cVar, String str, String str2, int i3) {
    }
}
