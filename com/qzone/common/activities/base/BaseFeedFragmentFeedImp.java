package com.qzone.common.activities.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.View;
import com.qzone.module.feedcomponent.ui.NormalAbsFeedView;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.ui.AbsFeedView;
import com.qzone.widget.QZonePullToRefreshListView;
import com.tencent.luan.ioc.annotation.Inject;
import com.tencent.widget.ListView;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class BaseFeedFragmentFeedImp implements d5.l {

    /* renamed from: i, reason: collision with root package name */
    private static int f45027i = -1;

    /* renamed from: j, reason: collision with root package name */
    private static int f45028j = -1;

    /* renamed from: k, reason: collision with root package name */
    protected static int f45029k = -1;

    /* renamed from: a, reason: collision with root package name */
    protected BaseFeedFragmentContainerImp f45030a;

    /* renamed from: b, reason: collision with root package name */
    private Map<String, BusinessFeedData> f45031b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private View f45032c;

    /* renamed from: d, reason: collision with root package name */
    private int f45033d;

    /* renamed from: e, reason: collision with root package name */
    private int f45034e;

    /* renamed from: f, reason: collision with root package name */
    private BroadcastReceiver f45035f;

    /* renamed from: g, reason: collision with root package name */
    private BroadcastReceiver f45036g;

    /* renamed from: h, reason: collision with root package name */
    private BroadcastReceiver f45037h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("com.tencent.qq.VideoPlaySetting".equals(intent.getAction())) {
                BaseFeedFragmentFeedImp.y();
                BaseFeedFragmentFeedImp.this.f45030a.h();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class b extends BroadcastReceiver {
        b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("com.tencent.qq.GifPlaySetting".equals(intent.getAction())) {
                BaseFeedFragmentFeedImp.x();
                BaseFeedFragmentFeedImp.this.f45030a.h();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class c extends BroadcastReceiver {
        c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("com.tencent.qq.syncNoPhotoSetting".equals(intent.getAction())) {
                BaseFeedFragmentFeedImp.f45029k = BaseFeedFragmentFeedImp.m();
                BaseFeedFragmentFeedImp.this.f45030a.h();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class d implements d5.d<View> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d5.m f45041a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Map f45042b;

        d(d5.m mVar, Map map) {
            this.f45041a = mVar;
            this.f45042b = map;
        }

        @Override // d5.d
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean accept(View view) {
            BusinessFeedData businessFeedData;
            BusinessFeedData businessFeedData2;
            if (view instanceof AbsFeedView) {
                AbsFeedView absFeedView = (AbsFeedView) view;
                if (BaseFeedFragmentFeedImp.this.f45032c == null) {
                    BaseFeedFragmentFeedImp.this.f45032c = absFeedView;
                    BaseFeedFragmentFeedImp.this.f45033d = absFeedView.getTop();
                    BaseFeedFragmentFeedImp.this.f45034e = absFeedView.getMFeedPosition();
                }
                int top = absFeedView.getTop();
                int bottom = absFeedView.getBottom();
                if (top > 60 && bottom < this.f45041a.o()) {
                    BaseFeedFragmentFeedImp.this.f45033d = top;
                    BaseFeedFragmentFeedImp.this.f45032c = absFeedView;
                    BaseFeedFragmentFeedImp.this.f45034e = absFeedView.getMFeedPosition();
                }
                if ((absFeedView instanceof NormalAbsFeedView) && (businessFeedData = absFeedView.mFeedData) != null && businessFeedData.getFeedCommInfo().ugckey != null && (businessFeedData2 = (BusinessFeedData) this.f45042b.get(businessFeedData.getFeedCommInfo().ugckey)) != null) {
                    QZLog.i("TAG", "feed update. \u5c40\u90e8\u5237\u65b0 ugckey:" + businessFeedData.getFeedCommInfo().ugckey);
                    if (!businessFeedData2.hasCalculate) {
                        businessFeedData2.preCalculate();
                        businessFeedData2.hasCalculate = true;
                    }
                    com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface().setFeedViewData(BaseFeedFragmentFeedImp.this.f45030a.getActivity(), absFeedView, businessFeedData2, false);
                }
            }
            return false;
        }
    }

    @Inject
    public BaseFeedFragmentFeedImp() {
    }

    static /* bridge */ /* synthetic */ int m() {
        return r();
    }

    private void o(d5.m mVar) {
        if (this.f45032c != null && (mVar instanceof QZonePullToRefreshListView)) {
            QZonePullToRefreshListView qZonePullToRefreshListView = (QZonePullToRefreshListView) mVar;
            qZonePullToRefreshListView.setSelectionFromTop(this.f45034e, this.f45033d - qZonePullToRefreshListView.getPaddingTop());
        }
        this.f45032c = null;
        this.f45033d = 0;
        this.f45034e = 0;
    }

    public static int p() {
        if (f45028j == -1) {
            x();
        }
        return f45028j;
    }

    public static int q() {
        if (f45029k == -1) {
            f45029k = r();
        }
        return f45029k;
    }

    private static int r() {
        return 0;
    }

    public static int s() {
        if (f45027i == -1) {
            y();
        }
        return f45027i;
    }

    private void t() {
        if (this.f45036g == null) {
            this.f45036g = new b();
            this.f45030a.registerReceiver(this.f45036g, new IntentFilter("com.tencent.qq.GifPlaySetting"));
        }
    }

    private void u() {
        if (this.f45037h == null) {
            this.f45037h = new c();
            this.f45030a.registerReceiver(this.f45037h, new IntentFilter("com.tencent.qq.syncNoPhotoSetting"));
        }
    }

    private void v() {
        if (this.f45035f == null) {
            this.f45035f = new a();
            this.f45030a.registerReceiver(this.f45035f, new IntentFilter("com.tencent.qq.VideoPlaySetting"));
        }
    }

    public static boolean w() {
        int p16 = p();
        int networkType = NetworkState.getNetworkType();
        if (p16 != 0) {
            if (p16 != 1 && p16 == 2) {
                return false;
            }
        } else if (networkType != 1) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void x() {
        int i3 = LocalMultiProcConfig.getInt(LocalMultiProcConfig.PREFS_NAME_LOCAL_QZ_SETTING, LocalMultiProcConfig.QZONE_SET_PLAYMODE, 0);
        f45028j = (i3 == 2 || !QZoneHelper.canGifPlaySwitch()) ? 2 : i3;
        QZLog.d("BaseFeedFragmentFeedImp", 2, "[jinqianli-config] reload gif config from sp, auto play gif mode is " + i3);
    }

    public static void y() {
        f45027i = LocalMultiProcConfig.getInt(LocalMultiProcConfig.PREFS_NAME_LOCAL_QZ_SETTING, LocalMultiProcConfig.QZONE_SET_PLAYMODE, 0);
        QZLog.d("BaseFeedFragmentFeedImp", 2, "[video-config] reload video config from sp, auto play video mode is " + f45027i);
    }

    @Override // d5.l
    public void a(d5.m mVar) {
        HashMap hashMap = new HashMap(this.f45031b);
        this.f45031b.clear();
        if (hashMap.size() <= 0 || mVar == null) {
            return;
        }
        mVar.s(new d(mVar, hashMap));
        o(mVar);
    }

    @Override // d5.l
    public void b(boolean z16) {
        com.qzone.adapter.feedcomponent.i.H().w2(z16);
    }

    @Override // d5.l
    public void c(d5.m mVar) {
        if (mVar instanceof QZonePullToRefreshListView) {
            ListView j06 = ((QZonePullToRefreshListView) mVar).j0();
            int childCount = j06.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = j06.getChildAt(i3);
                if (childAt instanceof AbsFeedView) {
                    ((AbsFeedView) childAt).onPause();
                }
            }
        }
    }

    @Override // d5.l
    public void d() {
        u();
        v();
        t();
    }

    @Override // d5.l
    public void e(d5.m mVar) {
        if (mVar instanceof QZonePullToRefreshListView) {
            ListView j06 = ((QZonePullToRefreshListView) mVar).j0();
            if (this.f45030a.b(128)) {
                com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface().onListViewIdle(j06);
            }
            for (int i3 = 0; i3 < j06.getCount(); i3++) {
                View childAt = j06.getChildAt(i3);
                if (childAt instanceof AbsFeedView) {
                    ((AbsFeedView) childAt).invalidate();
                }
            }
        }
    }

    @Override // d5.l
    public void f() {
        BroadcastReceiver broadcastReceiver = this.f45037h;
        if (broadcastReceiver != null) {
            this.f45030a.unregisterReceiver(broadcastReceiver);
        }
        BroadcastReceiver broadcastReceiver2 = this.f45035f;
        if (broadcastReceiver2 != null) {
            this.f45030a.unregisterReceiver(broadcastReceiver2);
        }
        BroadcastReceiver broadcastReceiver3 = this.f45036g;
        if (broadcastReceiver3 != null) {
            this.f45030a.unregisterReceiver(broadcastReceiver3);
        }
    }

    @Override // d5.l
    public void g(Object obj) {
        Object[] objArr = (Object[]) obj;
        List<BusinessFeedData> list = (List) objArr[0];
        Map<? extends String, ? extends BusinessFeedData> map = (Map) objArr[1];
        QZLog.i("BaseFeedFragmentFeedImp", "Feed\u589e\u91cf\u66f4\u65b0 size:" + map.size());
        this.f45031b.putAll(map);
        z(list, false);
    }

    @Override // d5.l
    public void h() {
        x();
        y();
        f45029k = r();
    }

    @Inject
    public void setContainer(d5.u uVar) {
        this.f45030a = (BaseFeedFragmentContainerImp) uVar;
    }

    protected void z(List<BusinessFeedData> list, boolean z16) {
    }
}
