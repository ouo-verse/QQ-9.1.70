package com.tencent.mobileqq.guild.feed.partpanel.ui;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.guild.aio.input.at.utils.j;
import com.tencent.guild.api.channel.IGuildChannelApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.aiopopuppanel.service.api.IGuildAIOPopupPanelServiceApi;
import com.tencent.mobileqq.guild.event.partevent.GuildPartPanelDismissEvent;
import com.tencent.mobileqq.guild.feed.partpanel.ui.a;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQToastUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import uo0.p;

/* compiled from: P */
/* loaded from: classes13.dex */
public class b implements ze1.a<ye1.b>, PopupWindow.OnDismissListener, p.b {
    private int C;
    private qp0.a D;
    private e E;
    private final com.tencent.mobileqq.guild.feed.partpanel.ui.a F;
    private final an1.d G;
    private View I;
    private a.InterfaceC7770a J;
    private GPServiceObserver K;
    private InterfaceC7771b L;
    private PopupWindow.OnDismissListener S;
    private boolean U;

    /* renamed from: d, reason: collision with root package name */
    private final Context f222647d;

    /* renamed from: e, reason: collision with root package name */
    private final AppRuntime f222648e;

    /* renamed from: f, reason: collision with root package name */
    private String f222649f;

    /* renamed from: h, reason: collision with root package name */
    private int f222650h;

    /* renamed from: i, reason: collision with root package name */
    private int f222651i;

    /* renamed from: m, reason: collision with root package name */
    private final int f222652m;
    private boolean H = false;
    private boolean M = false;
    private String N = "";
    private int P = 0;
    private int Q = 0;
    private String R = "";
    private List<IGProChannel> T = new ArrayList();
    private boolean V = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class a extends GPServiceObserver {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelInfoUpdated(String str) {
            if (((IGPSService) b.this.f222648e.getRuntimeService(IGPSService.class, "")).getGuildIdOf(str).equals(b.this.f222649f) && b.this.M) {
                b.this.w("", true);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelListUpdated(String str) {
            if (b.this.f222649f.equals(str) && b.this.M) {
                b.this.w("", true);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.guild.feed.partpanel.ui.b$b, reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public interface InterfaceC7771b {
        void a(List<IGProChannel> list);
    }

    public b(String str, String str2, Context context, int i3, int i16) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        this.f222648e = peekAppRuntime;
        this.F = new com.tencent.mobileqq.guild.feed.partpanel.ui.a(i16);
        this.f222649f = str;
        this.f222652m = i3;
        this.C = i16;
        this.f222647d = context;
        IGProChannelInfo channelInfo = ((IGPSService) peekAppRuntime.getRuntimeService(IGPSService.class, "")).getChannelInfo(str2);
        if (channelInfo != null) {
            this.f222651i = channelInfo.getType();
        }
        q();
        this.G = new an1.d(this);
        w("", true);
    }

    private void C() {
        e eVar = this.E;
        if (eVar != null) {
            TextView textView = (TextView) eVar.k().findViewById(R.id.f2257043);
            if (this.U) {
                textView.setText(R.string.f144790pq);
            } else {
                textView.setVisibility(0);
                textView.setText(R.string.f144800pr);
            }
        }
    }

    private void D() {
        e eVar = this.E;
        if (eVar != null) {
            TextView textView = (TextView) eVar.k().findViewById(R.id.wrw);
            ImageView imageView = (ImageView) this.E.k().findViewById(R.id.wic);
            ((TextView) this.E.k().findViewById(R.id.f2258044)).setVisibility(8);
            textView.setVisibility(8);
            imageView.setVisibility(8);
        }
    }

    private void n(List<IGProChannel> list) {
        boolean z16;
        if (list != null && !list.isEmpty()) {
            if (this.Q != 0 && !((IGPSService) this.f222648e.getRuntimeService(IGPSService.class, "")).getGuildPermission(this.f222649f).a(this.Q)) {
                z16 = false;
            } else {
                z16 = true;
            }
            Iterator<IGProChannel> it = list.iterator();
            while (it.hasNext()) {
                IGProChannel next = it.next();
                if (!TextUtils.isEmpty(this.R) && TextUtils.equals(String.valueOf(next.getChannelId()), this.R)) {
                    it.remove();
                } else if (next.getChannelType() != 7) {
                    it.remove();
                } else if (!z16 && next.getIsChannelAdmin() != 1) {
                    it.remove();
                }
            }
        }
    }

    private void o(List<IGProChannel> list) {
        if (list != null && !list.isEmpty()) {
            int i3 = this.C;
            if (i3 != 2 && i3 != 3) {
                return;
            }
            IGProChannel iGProChannel = list.get(0);
            if (iGProChannel.getHiddenPostChannel() == 1 && iGProChannel.getSpeakPermission() == 2) {
                this.U = true;
                list.remove(0);
            }
            C();
        }
    }

    private int p() {
        return this.f222652m;
    }

    private void r() {
        boolean z16;
        if (QLog.isColorLevel()) {
            QLog.i("GuildPartPanelManager", 2, "initPanel");
        }
        int i3 = this.f222651i;
        if (i3 != 5 && i3 != 2) {
            z16 = false;
        } else {
            z16 = true;
        }
        e f16 = e.f(this.f222647d, -1, -1, z16, this.D);
        this.E = f16;
        f16.setFocusable(this.H);
        this.E.setOutsideTouchable(false);
        this.E.setOnDismissListener(this);
        this.F.k(this.E.m().h());
        ListView listView = (ListView) this.E.k().findViewById(R.id.f2256042);
        listView.setSelector(new ColorDrawable(0));
        listView.setAdapter((ListAdapter) this.F);
        listView.setOnItemClickListener(this.F);
        this.F.notifyDataSetChanged();
        TextView textView = (TextView) this.E.k().findViewById(R.id.f2257043);
        int i16 = this.C;
        if (i16 != 2 && i16 != 3) {
            if (i16 == 1) {
                textView.setText(this.f222647d.getString(R.string.f144400oo));
            }
        } else {
            textView.setText(this.f222647d.getString(R.string.f144800pr));
        }
        D();
    }

    private void s() {
        v();
        this.E.u(this.I);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(String str, boolean z16) {
        if (!this.f222649f.isEmpty()) {
            this.G.t(this.f222649f);
            return;
        }
        InterfaceC7771b interfaceC7771b = this.L;
        if (interfaceC7771b != null) {
            interfaceC7771b.a(null);
        }
    }

    public void A(int i3) {
        this.Q = i3;
    }

    public void B(View view, String str, String str2) {
        if (t()) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("GuildPartPanelManager", 2, "showPanel");
        }
        if (this.E == null) {
            r();
        }
        this.F.j(this.J);
        this.F.i(str);
        this.I = view;
        this.M = true;
        w(str2, true);
    }

    @Override // ze1.a
    public boolean a() {
        e eVar = this.E;
        if (eVar != null && eVar.isShowing()) {
            return true;
        }
        return false;
    }

    @Override // ze1.a
    public void dismiss() {
        e eVar = this.E;
        if (eVar == null) {
            onDismiss();
        } else {
            eVar.dismiss();
        }
    }

    @Override // ze1.d
    public void e(ze1.c cVar, String str, List list, Object obj) {
        QLog.i("GuildPartPanelManager", 1, "[onSearchResult] keyword = " + str + ", count = " + list.size());
        n(list);
        InterfaceC7771b interfaceC7771b = this.L;
        if (interfaceC7771b != null) {
            interfaceC7771b.a(list);
        }
        o(list);
        this.T = new ArrayList(list);
        if (!ko0.a.c(list)) {
            if (a()) {
                int count = this.F.getCount();
                this.F.h(list);
                if (count != this.F.getCount()) {
                    this.E.e();
                    return;
                }
                return;
            }
            if (this.M) {
                this.F.h(list);
                if (this.V && list.size() == 1) {
                    QQToastUtil.showQQToast(0, "\u5f53\u524d\u6ca1\u6709\u53ef\u79fb\u52a8\u7684\u7248\u5757");
                    dismiss();
                    return;
                } else {
                    s();
                    return;
                }
            }
            return;
        }
        if (this.C == 1) {
            QQToastUtil.showQQToast(0, "\u5f53\u524d\u6ca1\u6709\u53ef\u79fb\u52a8\u7684\u7248\u5757");
        }
        dismiss();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        j.e(p(), 8);
        this.F.j(null);
        this.M = false;
        PopupWindow.OnDismissListener onDismissListener = this.S;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
        GuildPartPanelDismissEvent guildPartPanelDismissEvent = new GuildPartPanelDismissEvent();
        guildPartPanelDismissEvent.mHashCode = this.f222650h;
        SimpleEventBus.getInstance().dispatchEvent(guildPartPanelDismissEvent, true);
    }

    protected void q() {
        this.K = new a();
        ((IGPSService) this.f222648e.getRuntimeService(IGPSService.class, "")).addObserver(this.K);
    }

    public boolean t() {
        if (j.b(p(), -9) != 0) {
            return true;
        }
        return false;
    }

    public void u() {
        dismiss();
        this.G.e();
        ((IGPSService) this.f222648e.getRuntimeService(IGPSService.class, "")).deleteObserver(this.K);
    }

    public void v() {
        String currentThemeId = ((IGuildChannelApi) QRoute.api(IGuildChannelApi.class)).getCurrentThemeId();
        if (!this.N.equals(currentThemeId) && !this.N.equals("") && this.f222647d != null) {
            this.E.dismiss();
            this.E = null;
            r();
        }
        this.N = currentThemeId;
        ((IGuildAIOPopupPanelServiceApi) QRoute.api(IGuildAIOPopupPanelServiceApi.class)).markScenePopupPanelType(p(), 8);
    }

    public void x(boolean z16) {
        this.H = z16;
        e eVar = this.E;
        if (eVar != null) {
            eVar.setFocusable(z16);
        }
    }

    public void y(boolean z16) {
        this.V = z16;
    }

    public void z(a.InterfaceC7770a interfaceC7770a) {
        this.J = interfaceC7770a;
    }

    @Override // ze1.d
    public void d(ze1.c cVar, String str, String str2, int i3) {
    }
}
