package com.tencent.mobileqq.tvideo.parts;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.immersive.QFSBaseFragment;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.tvideo.TVideoLayerBean;
import com.tencent.mobileqq.tvideo.channel.event.QFSTVideoLandScapeChannelClickEvent;
import com.tencent.mobileqq.tvideo.event.TVideoChannelAutoJumpEvent;
import com.tencent.mobileqq.tvideo.event.TVideoMultiTabPageBackEvent;
import com.tencent.mobileqq.tvideo.event.TVideoMultiTabPageFinishEvent;
import com.tencent.mobileqq.tvideo.parts.TVideoLayerMultiTabPart;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.screen.ScreenUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import nx2.i;
import org.light.utils.CollectionUtils;
import tvideo.TVideoChannelList$VideoChannelData;
import tvideo.Video;
import tvideo.VideoBaseInfo;

/* loaded from: classes19.dex */
public class TVideoLayerMultiTabPart extends com.tencent.biz.qqcircle.immersive.part.u implements SimpleEventReceiver {

    /* renamed from: d, reason: collision with root package name */
    private final TVideoLayerBean f304501d;

    /* renamed from: e, reason: collision with root package name */
    private View f304502e;

    /* renamed from: f, reason: collision with root package name */
    private ViewPager2 f304503f;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.mobileqq.tvideo.base.e f304504h;

    /* renamed from: i, reason: collision with root package name */
    private nx2.i f304505i;

    /* renamed from: m, reason: collision with root package name */
    private int f304506m = 0;
    private int C = 0;
    private final List<TVideoChannelList$VideoChannelData> D = new CopyOnWriteArrayList();
    private final AtomicBoolean E = new AtomicBoolean(false);
    private final ViewPager2.OnPageChangeCallback F = new a();
    private final i.a G = new b();

    /* loaded from: classes19.dex */
    class a extends ViewPager2.OnPageChangeCallback {
        a() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i3) {
            super.onPageSelected(i3);
            TVideoLayerMultiTabPart.this.ia(i3);
            TVideoLayerMultiTabPart tVideoLayerMultiTabPart = TVideoLayerMultiTabPart.this;
            tVideoLayerMultiTabPart.Q9(tVideoLayerMultiTabPart.C);
            TVideoLayerMultiTabPart.this.C = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class b implements i.a {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(int i3) {
            TVideoLayerMultiTabPart.this.da(ox2.b.e().f(i3));
        }

        @Override // nx2.i.a
        public void a(List<TVideoChannelList$VideoChannelData> list) {
            QLog.d("TVideoLayerMultiTabPart", 1, "onChannelDataCallback");
            if (!CollectionUtils.isEmpty(list)) {
                TVideoLayerMultiTabPart.this.D.clear();
                TVideoLayerMultiTabPart.this.D.addAll(list);
            }
            if (TVideoLayerMultiTabPart.this.f304504h != null) {
                TVideoLayerMultiTabPart.this.pa();
                TVideoLayerMultiTabPart.this.f304504h.m0(TVideoLayerMultiTabPart.this.D);
                TVideoLayerMultiTabPart.this.R9();
            }
        }

        @Override // nx2.i.a
        public void b(final int i3) {
            if (TVideoLayerMultiTabPart.this.f304503f != null) {
                TVideoLayerMultiTabPart.this.f304503f.post(new Runnable() { // from class: com.tencent.mobileqq.tvideo.parts.aq
                    @Override // java.lang.Runnable
                    public final void run() {
                        TVideoLayerMultiTabPart.b.this.d(i3);
                    }
                });
            }
        }
    }

    public TVideoLayerMultiTabPart(TVideoLayerBean tVideoLayerBean) {
        this.f304501d = tVideoLayerBean;
    }

    private void P9() {
        TVideoChannelList$VideoChannelData c16 = ox2.b.e().c();
        if (c16 != null && c16.channel_page_type.get() == 0) {
            this.D.add(c16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q9(final int i3) {
        if (this.f304503f != null && this.f304504h != null && !ba()) {
            this.f304503f.post(new Runnable() { // from class: com.tencent.mobileqq.tvideo.parts.al
                @Override // java.lang.Runnable
                public final void run() {
                    TVideoLayerMultiTabPart.this.ca(i3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R9() {
        int i3 = this.C;
        for (int i16 = 0; i16 < this.D.size(); i16++) {
            TVideoChannelList$VideoChannelData tVideoChannelList$VideoChannelData = this.D.get(i16);
            if (tVideoChannelList$VideoChannelData != null) {
                int i17 = tVideoChannelList$VideoChannelData.channel_id.get();
                int i18 = tVideoChannelList$VideoChannelData.channel_page_type.get();
                String str = tVideoChannelList$VideoChannelData.page_module_name.get();
                if (i18 == 2 && !TextUtils.isEmpty(str)) {
                    ma(str);
                }
                if (ox2.b.e().d() == i17) {
                    i3 = i16;
                }
            }
        }
        da(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> S9() {
        Video q16;
        VideoBaseInfo videoBaseInfo;
        HashMap hashMap = new HashMap();
        TVideoLayerBean tVideoLayerBean = this.f304501d;
        if (tVideoLayerBean != null && tVideoLayerBean.getFeed() != null && (q16 = jy2.g.q(this.f304501d.getFeed())) != null && (videoBaseInfo = q16.video_base_info) != null) {
            String str = videoBaseInfo.cid;
            String str2 = videoBaseInfo.vid;
            String str3 = videoBaseInfo.material_aspect_vid;
            if (str == null) {
                str = "";
            }
            hashMap.put("cid", str);
            if (str2 == null) {
                str2 = "";
            }
            hashMap.put("vid", str2);
            if (str3 == null) {
                str3 = "";
            }
            hashMap.put("material_vid", str3);
        }
        return hashMap;
    }

    private void T9(QFSTVideoLandScapeChannelClickEvent qFSTVideoLandScapeChannelClickEvent) {
        QLog.d("TVideoLayerMultiTabPart", 1, "handleChannelClickEvent");
        if (this.f304503f == null) {
            return;
        }
        final int f16 = ox2.b.e().f(qFSTVideoLandScapeChannelClickEvent.getChannelId());
        if (ba()) {
            V9(f16);
        }
        this.f304503f.post(new Runnable() { // from class: com.tencent.mobileqq.tvideo.parts.am
            @Override // java.lang.Runnable
            public final void run() {
                TVideoLayerMultiTabPart.this.da(f16);
            }
        });
    }

    private void U9(Configuration configuration) {
        ViewPager2 viewPager2;
        boolean z16;
        QLog.d("TVideoLayerMultiTabPart", 1, "handleConfigChange");
        if (configuration != null && (viewPager2 = this.f304503f) != null) {
            if (configuration.orientation == 2) {
                z16 = true;
            } else {
                z16 = false;
            }
            viewPager2.setUserInputEnabled(!z16);
            na(this.C);
        }
    }

    private void V9(int i3) {
        QLog.d("TVideoLayerMultiTabPart", 1, "handleFragmentReplace  position:" + i3);
        com.tencent.mobileqq.tvideo.base.e eVar = this.f304504h;
        if (eVar != null) {
            eVar.o0(i3, 0);
        }
    }

    private void W9(View view) {
        if (this.f304504h == null && view != null) {
            aa(view);
            Y9(view);
            Z9();
        }
    }

    private void X9() {
        if (getActivity() != null) {
            getActivity().finish();
        }
    }

    private void Y9(View view) {
        QLog.d("TVideoLayerMultiTabPart", 1, "initChannelLayout");
        View findViewById = view.findViewById(R.id.f45661sh);
        this.f304502e = findViewById;
        if (findViewById != null) {
            findViewById.post(new Runnable() { // from class: com.tencent.mobileqq.tvideo.parts.an
                @Override // java.lang.Runnable
                public final void run() {
                    TVideoLayerMultiTabPart.this.ea();
                }
            });
        }
        ox2.d.c().g(getActivity(), this.f304502e, null);
        nx2.i d16 = ox2.d.c().d();
        this.f304505i = d16;
        d16.u(this.G);
    }

    private void Z9() {
        QLog.d("TVideoLayerMultiTabPart", 1, "initFragments");
        if (this.D.size() == 0) {
            P9();
        }
        oa();
    }

    private void aa(View view) {
        QLog.d("TVideoLayerMultiTabPart", 1, "initMultiTabViewPager");
        ViewPager2 viewPager2 = (ViewPager2) view.findViewById(R.id.f45691sk);
        this.f304503f = viewPager2;
        viewPager2.registerOnPageChangeCallback(this.F);
        View childAt = this.f304503f.getChildAt(0);
        if (childAt instanceof RecyclerView) {
            ((RecyclerView) childAt).setItemViewCacheSize(4);
        }
    }

    private boolean ba() {
        return ScreenUtils.isLandscape();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ca(int i3) {
        this.f304504h.i0(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ea() {
        this.f304506m = this.f304502e.getBottom();
    }

    private void finishActivity() {
        gy2.c.u(false, false);
        if (getActivity() != null) {
            getActivity().finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ga(int i3) {
        this.f304503f.setCurrentItem(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ha(int i3) {
        this.f304504h.l0(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ia(int i3) {
        QLog.d("TVideoLayerMultiTabPart", 1, "onSwitchTab:" + i3);
        nx2.i iVar = this.f304505i;
        if (iVar == null) {
            return;
        }
        iVar.r(this.D.get(i3).channel_id.get());
    }

    private void ja(TVideoChannelAutoJumpEvent tVideoChannelAutoJumpEvent) {
        int f16 = ox2.b.e().f(tVideoChannelAutoJumpEvent.getChannelId());
        if (f16 == this.C) {
            return;
        }
        da(f16);
        ia(f16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: la, reason: merged with bridge method [inline-methods] */
    public void da(final int i3) {
        ViewPager2 viewPager2;
        QLog.d("TVideoLayerMultiTabPart", 1, "onSwitchViewPager:" + i3);
        if (!ab0.a.a(i3, this.D) && (viewPager2 = this.f304503f) != null && viewPager2.getCurrentItem() != i3) {
            if (ba()) {
                this.f304503f.setCurrentItem(i3, false);
                return;
            }
            if (Math.abs(i3 - this.C) > 1) {
                this.f304503f.setCurrentItem(i3, false);
            }
            this.f304503f.post(new Runnable() { // from class: com.tencent.mobileqq.tvideo.parts.ao
                @Override // java.lang.Runnable
                public final void run() {
                    TVideoLayerMultiTabPart.this.ga(i3);
                }
            });
        }
    }

    private void ma(String str) {
        if (this.E.compareAndSet(false, true)) {
            QLog.d("TVideoLayerMultiTabPart", 1, "readyHippy:" + str);
            com.tencent.mobileqq.tvideo.hippy.a.b(str);
        }
    }

    private void na(final int i3) {
        if (this.f304503f != null && this.f304504h != null && !ba()) {
            this.f304503f.post(new Runnable() { // from class: com.tencent.mobileqq.tvideo.parts.ap
                @Override // java.lang.Runnable
                public final void run() {
                    TVideoLayerMultiTabPart.this.ha(i3);
                }
            });
        }
    }

    private void oa() {
        QLog.d("TVideoLayerMultiTabPart", 1, "setUpAdapter");
        if (this.f304503f == null) {
            return;
        }
        QFSBaseFragment hostFragment = getHostFragment();
        if (this.f304504h == null && hostFragment != null && hostFragment.isAdded()) {
            this.f304504h = new com.tencent.mobileqq.tvideo.base.e(hostFragment, this.D, new HashMap<String, String>() { // from class: com.tencent.mobileqq.tvideo.parts.TVideoLayerMultiTabPart.3
                {
                    putAll(TVideoLayerMultiTabPart.this.S9());
                    put(NodeProps.MARGIN_TOP, TVideoLayerMultiTabPart.this.f304506m + "");
                    put(MosaicConstants$JsProperty.PROP_ENV, "release");
                }
            });
        }
        this.f304503f.setAdapter(this.f304504h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pa() {
        if (this.f304502e != null) {
            this.f304504h.n0(NodeProps.MARGIN_TOP, this.f304502e.getBottom() + "");
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        return new ArrayList<Class>() { // from class: com.tencent.mobileqq.tvideo.parts.TVideoLayerMultiTabPart.4
            {
                add(QFSTVideoLandScapeChannelClickEvent.class);
                add(TVideoMultiTabPageFinishEvent.class);
                add(TVideoChannelAutoJumpEvent.class);
            }
        };
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "TVideoLayerMultiTabPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        if (ab0.a.a(this.C, this.D)) {
            finishActivity();
            return true;
        }
        SimpleEventBus.getInstance().dispatchEvent(new TVideoMultiTabPageBackEvent());
        return true;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        U9(configuration);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        W9(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        ox2.b.e().j();
        ViewPager2 viewPager2 = this.f304503f;
        if (viewPager2 != null) {
            viewPager2.unregisterOnPageChangeCallback(this.F);
            this.f304503f.setAdapter(null);
        }
        nx2.i iVar = this.f304505i;
        if (iVar != null) {
            iVar.t();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSTVideoLandScapeChannelClickEvent) {
            T9((QFSTVideoLandScapeChannelClickEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof TVideoMultiTabPageFinishEvent) {
            X9();
        } else if (simpleBaseEvent instanceof TVideoChannelAutoJumpEvent) {
            ja((TVideoChannelAutoJumpEvent) simpleBaseEvent);
        }
    }
}
