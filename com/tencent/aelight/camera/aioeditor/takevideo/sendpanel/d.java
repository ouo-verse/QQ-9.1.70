package com.tencent.aelight.camera.aioeditor.takevideo.sendpanel;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.aelight.camera.report.api.IAEBaseDataReporter;
import com.tencent.aelight.camera.report.api.IAEBaseReportParam;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.armap.f;
import com.tencent.mobileqq.avatar.api.IQQNonMainProcAvatarLoaderApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QuickSendProgressView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.RecentDynamicAvatarView;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes32.dex */
public class d extends BaseAdapter implements View.OnClickListener {
    private com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.a C;
    private int E;
    private SendPanelPart G;

    /* renamed from: d, reason: collision with root package name */
    private Context f68819d;

    /* renamed from: e, reason: collision with root package name */
    private List<com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.e> f68820e;

    /* renamed from: f, reason: collision with root package name */
    private f f68821f;

    /* renamed from: h, reason: collision with root package name */
    private f f68822h;

    /* renamed from: i, reason: collision with root package name */
    private f f68823i;

    /* renamed from: m, reason: collision with root package name */
    private f f68824m;
    private ConcurrentHashMap<Integer, URLDrawable> F = new ConcurrentHashMap<>();
    private Bitmap D = BaseImageUtil.getDefaultFaceBitmap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements com.tencent.mobileqq.armap.e {
        a() {
        }

        @Override // com.tencent.mobileqq.armap.e
        public void h(String str, String str2, Bitmap bitmap) {
            if (d.this.C != null) {
                d.this.C.I(str, 1, str2, bitmap);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b implements com.tencent.mobileqq.armap.e {
        b() {
        }

        @Override // com.tencent.mobileqq.armap.e
        public void h(String str, String str2, Bitmap bitmap) {
            if (d.this.C != null) {
                d.this.C.I(str, 4, str2, bitmap);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class c implements com.tencent.mobileqq.armap.e {
        c() {
        }

        @Override // com.tencent.mobileqq.armap.e
        public void h(String str, String str2, Bitmap bitmap) {
            if (d.this.C != null) {
                d.this.C.I(str, 4, str2, bitmap);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.d$d, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    public class C0616d implements com.tencent.mobileqq.armap.e {
        C0616d() {
        }

        @Override // com.tencent.mobileqq.armap.e
        public void h(String str, String str2, Bitmap bitmap) {
            if (d.this.C != null) {
                d.this.C.I(str, 101, str2, bitmap);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class e {

        /* renamed from: a, reason: collision with root package name */
        public RecentDynamicAvatarView f68829a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f68830b;

        /* renamed from: c, reason: collision with root package name */
        public QuickSendProgressView f68831c;

        /* renamed from: d, reason: collision with root package name */
        public com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.e f68832d;

        public e() {
        }
    }

    public d(Context context, com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.a aVar) {
        this.f68819d = context;
        this.C = aVar;
        this.E = BaseAIOUtils.f(40.0f, this.f68819d.getResources());
        d();
    }

    public static Drawable c(String str, int i3, int i16) {
        com.tencent.mobileqq.drawable.b bVar = new com.tencent.mobileqq.drawable.b(Color.rgb(214, 214, 214), i3, i16);
        if (!TextUtils.isEmpty(str)) {
            try {
                URLDrawable drawable = URLDrawable.getDrawable(str, bVar, bVar);
                if (drawable.getStatus() != 1) {
                    drawable.downloadImediatly();
                }
                return drawable;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("SendPanelAdapter", 2, "getIconDrawable Exception, coverUrl=" + str, e16);
                }
            }
        }
        return bVar;
    }

    private void d() {
        f nonMainAppHeadLoader = ((IQQNonMainProcAvatarLoaderApi) QRoute.api(IQQNonMainProcAvatarLoaderApi.class)).getNonMainAppHeadLoader(this.f68819d, 1);
        this.f68821f = nonMainAppHeadLoader;
        nonMainAppHeadLoader.init();
        this.f68821f.a(new a());
        f nonMainAppHeadLoader2 = ((IQQNonMainProcAvatarLoaderApi) QRoute.api(IQQNonMainProcAvatarLoaderApi.class)).getNonMainAppHeadLoader(this.f68819d, 4);
        this.f68822h = nonMainAppHeadLoader2;
        nonMainAppHeadLoader2.init();
        this.f68822h.a(new b());
        f nonMainAppHeadLoader3 = ((IQQNonMainProcAvatarLoaderApi) QRoute.api(IQQNonMainProcAvatarLoaderApi.class)).getNonMainAppHeadLoader(this.f68819d, 113);
        this.f68823i = nonMainAppHeadLoader3;
        nonMainAppHeadLoader3.init();
        this.f68823i.a(new c());
        f nonMainAppHeadLoader4 = ((IQQNonMainProcAvatarLoaderApi) QRoute.api(IQQNonMainProcAvatarLoaderApi.class)).getNonMainAppHeadLoader(this.f68819d, 101);
        this.f68824m = nonMainAppHeadLoader4;
        nonMainAppHeadLoader4.init();
        this.f68824m.a(new C0616d());
    }

    private void f(String str, int i3, int i16, RecentDynamicAvatarView recentDynamicAvatarView, int i17) {
        if (FileUtils.fileExistsAndNotEmpty(str)) {
            URL thumbUrl = ShortVideoUtils.getThumbUrl(str);
            if (thumbUrl != null) {
                Drawable c16 = c(thumbUrl.toString(), i3, i16);
                if (c16 instanceof URLDrawable) {
                    this.F.put(Integer.valueOf(i17), (URLDrawable) c16);
                }
                recentDynamicAvatarView.setImageDrawable(c16);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("SendPanelAdapter", 2, "url  is null ");
            }
        }
    }

    private com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.e k(String str, int i3, int i16) {
        List<com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.e> list;
        if (TextUtils.isEmpty(str) || (list = this.f68820e) == null || list.size() <= 0) {
            return null;
        }
        for (com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.e eVar : this.f68820e) {
            if (!TextUtils.isEmpty(eVar.f68834a) && str.equals(eVar.f68834a) && i3 == eVar.f68837d) {
                eVar.f68838e = i16;
                if (i16 == 1) {
                    eVar.f68843j = true;
                }
                return eVar;
            }
        }
        return null;
    }

    public void destroy() {
        ConcurrentHashMap<Integer, URLDrawable> concurrentHashMap = this.F;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
        }
    }

    public boolean e() {
        List<com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.e> list = this.f68820e;
        if (list == null || list.size() <= 0) {
            return false;
        }
        return !TextUtils.isEmpty(this.f68820e.get(0).f68845l);
    }

    public void g() {
        f fVar = this.f68821f;
        if (fVar != null) {
            fVar.destroy();
        }
        f fVar2 = this.f68822h;
        if (fVar2 != null) {
            fVar2.destroy();
        }
        f fVar3 = this.f68824m;
        if (fVar3 != null) {
            fVar3.destroy();
        }
        h(false);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.e> list = this.f68820e;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        List<com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.e> list = this.f68820e;
        if (list != null) {
            return list.get(i3);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        List<com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.e> list = this.f68820e;
        if (list == null || i3 >= list.size()) {
            return 0L;
        }
        try {
            return Long.parseLong(this.f68820e.get(i3).f68834a);
        } catch (Exception e16) {
            if (!QLog.isColorLevel()) {
                return 0L;
            }
            QLog.d("SendPanelAdapter", 2, "getItemId exception = " + e16.getMessage());
            return 0L;
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.e eVar = (com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.e) getItem(i3);
        if (view == null) {
            view = LayoutInflater.from(this.f68819d).inflate(R.layout.ceg, (ViewGroup) null);
            e eVar2 = new e();
            eVar2.f68829a = (RecentDynamicAvatarView) view.findViewById(R.id.icon);
            eVar2.f68830b = (TextView) view.findViewById(R.id.f5e);
            eVar2.f68831c = (QuickSendProgressView) view.findViewById(R.id.lyd);
            eVar2.f68832d = eVar;
            b(i3, eVar2);
            view.setTag(eVar2);
        } else {
            e eVar3 = (e) view.getTag();
            eVar3.f68832d = eVar;
            b(i3, eVar3);
        }
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return view;
    }

    public void h(boolean z16) {
        SendPanelPart sendPanelPart;
        if (QLog.isColorLevel()) {
            QLog.d("SendPanelAdapter", 2, "onEditUpdate");
        }
        List<com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.e> list = this.f68820e;
        if (list != null && list.size() > 0) {
            com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.e eVar = this.f68820e.get(0);
            if (TextUtils.isEmpty(eVar.f68845l) && TextUtils.isEmpty(eVar.f68847n)) {
                return;
            }
            if (z16 && (sendPanelPart = this.G) != null) {
                com.tencent.aelight.camera.aioeditor.b.o(sendPanelPart.mParent);
            }
            Iterator<com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.e> it = this.f68820e.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
        notifyDataSetChanged();
    }

    public void j(SendPanelPart sendPanelPart) {
        this.G = sendPanelPart;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Object valueOf;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getTag() instanceof e) {
            e eVar = (e) view.getTag();
            if (eVar.f68832d == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("SendPanelAdapter", 2, "onClick itemInfo is null");
                }
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d("SendPanelAdapter", 2, "onClick operateStatus = " + eVar.f68832d.f68838e);
                }
                com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.e eVar2 = eVar.f68832d;
                int i3 = eVar2.f68838e;
                if (i3 != 0) {
                    if (i3 == 1) {
                        com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.e k3 = k(eVar2.f68834a, eVar2.f68837d, 0);
                        if (k3 != null) {
                            eVar.f68832d = k3;
                            l(eVar);
                            com.tencent.aelight.camera.aioeditor.editipc.a.a(k3);
                        }
                        SendPanelPart sendPanelPart = this.G;
                        if (sendPanelPart != null) {
                            com.tencent.aelight.camera.aioeditor.b.d(sendPanelPart.mParent, k3);
                        }
                    } else if (i3 == 2) {
                        if (!NetworkUtil.isNetworkAvailable(this.f68819d)) {
                            Context context = this.f68819d;
                            QQToast.makeText(context, context.getString(R.string.vs8), 0).show();
                        } else {
                            com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.e eVar3 = eVar.f68832d;
                            com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.e k16 = k(eVar3.f68834a, eVar3.f68837d, 1);
                            if (k16 != null) {
                                eVar.f68832d = k16;
                                l(eVar);
                                com.tencent.aelight.camera.aioeditor.editipc.a.e(k16);
                            }
                            SendPanelPart sendPanelPart2 = this.G;
                            if (sendPanelPart2 != null) {
                                com.tencent.aelight.camera.aioeditor.b.h(sendPanelPart2.mParent, k16);
                            }
                        }
                    }
                } else if (!NetworkUtil.isNetworkAvailable(this.f68819d)) {
                    Context context2 = this.f68819d;
                    QQToast.makeText(context2, context2.getString(R.string.vs8), 0).show();
                } else if (!TextUtils.isEmpty(eVar.f68832d.f68847n)) {
                    com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.e eVar4 = eVar.f68832d;
                    com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.e k17 = k(eVar4.f68834a, eVar4.f68837d, 1);
                    if (k17 != null) {
                        eVar.f68832d = k17;
                        l(eVar);
                        if (k17.f68842i) {
                            com.tencent.aelight.camera.aioeditor.editipc.a.k(k17.f68845l, k17.f68846m, k17, SendPanelManager.k().G, SendPanelManager.k().n());
                        } else {
                            com.tencent.aelight.camera.aioeditor.editipc.a.j(k17.f68845l, k17, SendPanelManager.k().G, SendPanelManager.k().n());
                        }
                    }
                    SendPanelPart sendPanelPart3 = this.G;
                    if (sendPanelPart3 != null) {
                        com.tencent.aelight.camera.aioeditor.b.i(sendPanelPart3.mParent, k17);
                    }
                    ((IAEBaseDataReporter) QRoute.api(IAEBaseDataReporter.class)).reportPostBtn(eVar.f68832d.f68847n, k17 == null ? -1 : k17.f68837d);
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("\u3010OnClick\u3011messageType:");
                    if (k17 == null) {
                        valueOf = "-1";
                    } else {
                        valueOf = Integer.valueOf(k17.f68837d);
                    }
                    sb5.append(valueOf);
                    ms.a.f("SendPanelAdapter", sb5.toString());
                } else {
                    ((IAEBaseReportParam) QRoute.api(IAEBaseReportParam.class)).resetEditInfo();
                    this.G.mParent.u(20, eVar.f68832d);
                    this.G.mParent.Q0();
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setData(List<com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.e> list) {
        if (list == null) {
            if (QLog.isColorLevel()) {
                QLog.d("SendPanelAdapter", 2, "setData list is empty");
            }
        } else if (this.f68820e != null && list.isEmpty()) {
            if (QLog.isColorLevel()) {
                QLog.d("SendPanelAdapter", 2, "setData do not need refresh");
            }
        } else {
            this.f68820e = list;
            notifyDataSetChanged();
        }
    }

    private void l(e eVar) {
        com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.e eVar2;
        if (eVar != null && (eVar2 = eVar.f68832d) != null) {
            eVar.f68831c.setStatus(eVar2.f68838e);
            com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.e eVar3 = eVar.f68832d;
            if (eVar3.f68838e == 1) {
                eVar.f68831c.setProgress(eVar3.f68839f);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SendPanelAdapter", 2, "updateStatusView fail");
        }
    }

    public void b(int i3, e eVar) {
        com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.e eVar2;
        if (eVar != null && (eVar2 = eVar.f68832d) != null) {
            Bitmap bitmap = eVar2.f68841h;
            if (bitmap != null && !bitmap.isRecycled()) {
                eVar.f68829a.setImageBitmap(eVar2.f68841h);
            } else if (!TextUtils.isEmpty(eVar2.f68840g)) {
                URLDrawable uRLDrawable = this.F.get(Integer.valueOf(i3));
                if (uRLDrawable != null) {
                    eVar.f68829a.setImageDrawable(uRLDrawable);
                } else {
                    String str = eVar2.f68840g;
                    int i16 = this.E;
                    f(str, i16, i16, eVar.f68829a, i3);
                }
            } else {
                Bitmap bitmap2 = this.D;
                int i17 = eVar2.f68837d;
                if (i17 == 0 || i17 == 1000 || i17 == 1004) {
                    bitmap2 = this.f68821f.b(eVar2.f68834a, true);
                } else if (i17 == 1) {
                    if (eVar2.f68844k) {
                        bitmap2 = this.f68823i.b(eVar2.f68834a, true);
                    } else {
                        bitmap2 = this.f68822h.b(eVar2.f68834a, true);
                    }
                } else if (i17 == 3000) {
                    bitmap2 = this.f68824m.b(eVar2.f68834a, true);
                }
                if (bitmap2 != null) {
                    eVar.f68829a.setImageBitmap(bitmap2);
                }
            }
            eVar.f68830b.setText(eVar2.f68836c);
            eVar.f68831c.setTag(eVar);
            eVar.f68831c.setOnClickListener(this);
            l(eVar);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SendPanelAdapter", 2, "bindData fail viewHolder");
        }
    }

    public void i(int i3, com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.e eVar) {
        List<com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.e> list;
        if (i3 >= 0 && (list = this.f68820e) != null && i3 <= list.size() && eVar != null) {
            this.f68820e.set(i3, eVar);
        } else if (QLog.isColorLevel()) {
            QLog.d("SendPanelAdapter", 2, "onUpdate return");
        }
    }
}
