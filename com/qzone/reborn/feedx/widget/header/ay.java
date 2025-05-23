package com.qzone.reborn.feedx.widget.header;

import android.animation.ValueAnimator;
import android.content.res.Configuration;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.event.Event;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.IObserver;
import com.qzone.cover.ui.QzoneDynamicCoverController;
import com.qzone.proxy.covercomponent.CoverComponentProxy;
import com.qzone.proxy.covercomponent.QZoneCoverUtils;
import com.qzone.proxy.covercomponent.adapter.CoverResAdapter;
import com.qzone.proxy.covercomponent.env.CoverEnv;
import com.qzone.proxy.covercomponent.ui.IOnCoverChangedListener;
import com.qzone.proxy.covercomponent.ui.IOnCoverClickListener;
import com.qzone.proxy.covercomponent.ui.IQZoneCoverContainer;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.model.CoverCacheData;

/* compiled from: P */
/* loaded from: classes37.dex */
public abstract class ay extends com.qzone.reborn.feedx.widget.header.d implements IObserver.main {
    private boolean C;
    private int D;
    private int E;
    private com.qzone.reborn.feedx.viewmodel.f F;

    /* renamed from: f, reason: collision with root package name */
    public final ViewGroup f56217f;

    /* renamed from: h, reason: collision with root package name */
    private final QzoneDynamicCoverController f56218h;

    /* renamed from: i, reason: collision with root package name */
    public IQZoneCoverContainer f56219i;

    /* renamed from: m, reason: collision with root package name */
    private RecyclerView f56220m;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a implements Observer<CoverCacheData> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(CoverCacheData coverCacheData) {
            ay.this.C(coverCacheData);
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class b extends com.qzone.reborn.feedx.viewmodel.g {
        b() {
        }

        @Override // com.qzone.reborn.feedx.viewmodel.g, com.qzone.reborn.feedx.viewmodel.b
        public void v0(QZoneResult qZoneResult) {
            ay.this.F.O1(qZoneResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class d implements IOnCoverClickListener {
        d() {
        }

        @Override // com.qzone.proxy.covercomponent.ui.IOnCoverClickListener
        public void onLongClick(View view) {
            if (ay.this.f56218h != null) {
                ay.this.f56218h.i();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class e implements ValueAnimator.AnimatorUpdateListener {
        e() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ay ayVar = ay.this;
            ayVar.q(ayVar.f56217f, ((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    public ay(View view) {
        super(view);
        this.f56217f = (ViewGroup) view.findViewById(R.id.mzu);
        this.f56218h = new QzoneDynamicCoverController(view, g(), (ImageView) view.findViewById(R.id.mzx));
    }

    private void A() {
        if (this.f56219i == null || this.f56220m == null) {
            return;
        }
        if (z()) {
            this.f56219i.breezeResume();
        } else {
            this.f56219i.breezePause();
        }
    }

    private void B() {
        EventCenter.getInstance().addUIObserver(this, "Personalize", 8, 12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(View view, int i3) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = i3;
            view.setLayoutParams(layoutParams);
        }
    }

    private void s() {
        View findViewById = d().findViewById(R.id.myz);
        if (findViewById != null) {
            if (QQTheme.isNowThemeIsNightForQzone()) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
        }
    }

    private void y() {
        this.E = CoverEnv.getFinalCoverHeight();
        int finalCoverHeight = CoverEnv.getFinalCoverHeight() + CoverEnv.getCoverFriendPaddingTop();
        this.D = finalCoverHeight;
        q(this.f56217f, finalCoverHeight);
    }

    private boolean z() {
        View childAt;
        RecyclerView recyclerView = this.f56220m;
        if (recyclerView != null) {
            return com.qzone.reborn.feedx.util.ah.a(recyclerView) == 0 && (childAt = this.f56220m.getChildAt(0)) != null && childAt.getTop() == this.f56220m.getPaddingTop() && !this.C;
        }
        QLog.e("QzoneFeedxCoverElement", 1, "isTop: mRvFeedList is null");
        return false;
    }

    public void C(CoverCacheData coverCacheData) {
        this.f56219i.setCacheCover(w(), coverCacheData);
    }

    @Override // com.qzone.reborn.feedx.widget.header.d, com.qzone.reborn.feedx.widget.header.b
    public void b(RecyclerView recyclerView, int i3, int i16) {
        if (this.f56219i != null) {
            A();
            if (this.f56217f.getBottom() < 0) {
                this.f56219i.onCoverInvislble();
            } else {
                if (this.f56219i.isCoverVisible() || this.C) {
                    return;
                }
                this.f56219i.onCoverVisible();
            }
        }
    }

    @Override // com.qzone.reborn.feedx.widget.header.d, com.qzone.reborn.feedx.widget.header.b
    public void delayShow() {
        IQZoneCoverContainer iQZoneCoverContainer = this.f56219i;
        if (iQZoneCoverContainer != null) {
            iQZoneCoverContainer.delayShow();
        }
    }

    @Override // com.qzone.reborn.feedx.widget.header.d
    public void l() {
        y();
        x();
        B();
        com.qzone.reborn.feedx.viewmodel.f fVar = (com.qzone.reborn.feedx.viewmodel.f) k(com.qzone.reborn.feedx.viewmodel.f.class);
        this.F = fVar;
        fVar.N1().observe(i(), new a());
        s();
        v().k2(new b());
    }

    @Override // com.qzone.reborn.feedx.widget.header.d, com.qzone.reborn.feedx.widget.header.b
    public void onConfigurationChanged(Configuration configuration) {
        this.f56219i.onConfigurationChanged(configuration);
    }

    @Override // com.qzone.reborn.feedx.widget.header.d, com.qzone.reborn.feedx.widget.header.b
    public void onDestroy() {
        EventCenter.getInstance().removeObserver(this);
        IQZoneCoverContainer iQZoneCoverContainer = this.f56219i;
        if (iQZoneCoverContainer != null) {
            iQZoneCoverContainer.onDestory();
        }
        QzoneDynamicCoverController qzoneDynamicCoverController = this.f56218h;
        if (qzoneDynamicCoverController != null) {
            qzoneDynamicCoverController.j();
        }
    }

    @Override // com.qzone.common.event.IObserver.main
    public void onEventUIThread(Event event) {
        CoverCacheData coverCacheData;
        if ("Personalize".equals(event.source.getName())) {
            int i3 = event.what;
            if (i3 != 8) {
                if (i3 != 12) {
                    return;
                }
                v().P1();
                return;
            }
            Object[] objArr = (Object[]) event.params;
            if (objArr != null && objArr.length > 0) {
                Object obj = objArr[0];
                if (obj instanceof CoverCacheData) {
                    coverCacheData = (CoverCacheData) obj;
                    this.F.N1().setValue(coverCacheData);
                    this.F.M1().setValue(Integer.valueOf(QZoneCoverUtils.getSuperCoverTrans(coverCacheData)));
                }
            }
            coverCacheData = null;
            this.F.N1().setValue(coverCacheData);
            this.F.M1().setValue(Integer.valueOf(QZoneCoverUtils.getSuperCoverTrans(coverCacheData)));
        }
    }

    @Override // com.qzone.reborn.feedx.widget.header.d, com.qzone.reborn.feedx.widget.header.b
    public void onHandleMessage(Message message) {
        IQZoneCoverContainer iQZoneCoverContainer;
        IQZoneCoverContainer iQZoneCoverContainer2;
        int i3 = message.what;
        if (i3 == 1193) {
            RecyclerView recyclerView = this.f56220m;
            if (recyclerView != null && (iQZoneCoverContainer = this.f56219i) != null) {
                iQZoneCoverContainer.showFullscreenCover((ViewGroup) recyclerView.getParent());
            }
        } else if (i3 == 1194 && (iQZoneCoverContainer2 = this.f56219i) != null) {
            iQZoneCoverContainer2.hideFullscreenCover();
        }
        IQZoneCoverContainer iQZoneCoverContainer3 = this.f56219i;
        if (iQZoneCoverContainer3 != null) {
            iQZoneCoverContainer3.onHandleMessage(message);
        }
    }

    @Override // com.qzone.reborn.feedx.widget.header.d, com.qzone.reborn.feedx.widget.header.b
    public void onPostThemeChanged() {
        s();
    }

    @Override // com.qzone.reborn.feedx.widget.header.d, com.qzone.reborn.feedx.widget.header.b
    public void onStart() {
        IQZoneCoverContainer iQZoneCoverContainer = this.f56219i;
        if (iQZoneCoverContainer != null) {
            iQZoneCoverContainer.onStart();
        }
    }

    @Override // com.qzone.reborn.feedx.widget.header.d, com.qzone.reborn.feedx.widget.header.b
    public void onStop() {
        IQZoneCoverContainer iQZoneCoverContainer = this.f56219i;
        if (iQZoneCoverContainer != null) {
            iQZoneCoverContainer.onStop();
        }
    }

    abstract int t();

    public int u() {
        IQZoneCoverContainer iQZoneCoverContainer = this.f56219i;
        if (iQZoneCoverContainer != null) {
            return iQZoneCoverContainer.getTransparency();
        }
        return 255;
    }

    abstract tc.b v();

    abstract long w();

    public void x() {
        IQZoneCoverContainer coverContainerInstance = CoverComponentProxy.f50099g.getUiInterface().getCoverContainerInstance(CoverEnv.getContext(), this.f56217f, w(), CoverResAdapter.getInstance());
        this.f56219i = coverContainerInstance;
        coverContainerInstance.setRefer(t());
        this.f56219i.getAttachView().setContentDescription(com.qzone.util.l.a(R.string.rv8));
        this.f56219i.setActivity(g());
        this.f56219i.setOnCoverChangedListener(new c());
        this.f56219i.setOnCoverClickListener(new d());
        this.f56219i.setHandler(this.f56248e.Z());
        this.f56219i.setCacheCover(w());
    }

    @Override // com.qzone.reborn.feedx.widget.header.d, com.qzone.reborn.feedx.widget.header.b
    public void M() {
        ValueAnimator ofInt = ValueAnimator.ofInt(this.f56217f.getLayoutParams().height, this.D);
        ofInt.setDuration(200L).start();
        ofInt.addUpdateListener(new e());
        ofInt.start();
    }

    @Override // com.qzone.reborn.feedx.widget.header.d, com.qzone.reborn.feedx.widget.header.b
    public void onPause() {
        this.C = true;
        IQZoneCoverContainer iQZoneCoverContainer = this.f56219i;
        if (iQZoneCoverContainer != null) {
            iQZoneCoverContainer.onPause();
            this.f56219i.breezePause();
        }
        QzoneDynamicCoverController qzoneDynamicCoverController = this.f56218h;
        if (qzoneDynamicCoverController != null) {
            qzoneDynamicCoverController.k();
        }
    }

    @Override // com.qzone.reborn.feedx.widget.header.d, com.qzone.reborn.feedx.widget.header.b
    public void onResume() {
        this.C = false;
        if (this.f56219i != null) {
            if (z()) {
                this.f56219i.breezeResume();
            }
            this.f56219i.onResume();
            int coverType = this.f56219i.getCoverType();
            if (coverType == 9 || coverType == 15 || coverType == 19 || coverType == 16 || coverType == 18 || coverType == 10) {
                wo.a.a(coverType);
            }
        }
        QzoneDynamicCoverController qzoneDynamicCoverController = this.f56218h;
        if (qzoneDynamicCoverController != null) {
            qzoneDynamicCoverController.l();
        }
    }

    @Override // com.qzone.reborn.feedx.widget.header.d, com.qzone.reborn.feedx.widget.header.b
    public void r(RecyclerView recyclerView) {
        if (recyclerView == null) {
            return;
        }
        this.f56220m = recyclerView;
    }

    @Override // com.qzone.reborn.feedx.widget.header.d, com.qzone.reborn.feedx.widget.header.b
    public boolean c(float f16, float f17) {
        if (f16 > 0.0f && this.f56217f.getLayoutParams().height < this.E) {
            q(this.f56217f, (int) (r5.getLayoutParams().height + f16));
            return true;
        }
        if (f16 >= 0.0f || this.f56217f.getBottom() <= this.D) {
            return false;
        }
        q(this.f56217f, (int) (r5.getLayoutParams().height + f16));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class c implements IOnCoverChangedListener {
        c() {
        }

        @Override // com.qzone.proxy.covercomponent.ui.IOnCoverChangedListener
        public void onCoverChanged(CoverCacheData coverCacheData, CoverCacheData coverCacheData2) {
        }
    }
}
