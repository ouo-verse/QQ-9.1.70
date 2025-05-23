package com.tencent.biz.subscribe.widget.relativevideo;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StFeed;
import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.event.SubDraftChangeEvent;
import com.tencent.biz.subscribe.event.SubscribeFeedsEvent;
import com.tencent.biz.subscribe.fragments.SubscribeBaseBottomPersonalFragment;
import com.tencent.biz.subscribe.fragments.SubscribePersonalBottomDraftsFragment;
import com.tencent.biz.subscribe.fragments.SubscribePersonalBottomOpusFragment;
import com.tencent.biz.subscribe.part.block.MultiViewBlock;
import com.tencent.biz.subscribe.part.block.a;
import com.tencent.biz.subscribe.utils.SubscribeDraftManager;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.PermissionUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public class RelativePersonalBottomView extends BaseWidgetView<a.d> implements SimpleEventReceiver {
    private RadioGroup E;
    private ViewPager F;
    private RadioButton G;
    private RadioButton H;
    private c I;
    private MultiViewBlock J;
    private List<SubscribeBaseBottomPersonalFragment> K;
    private SubscribePersonalBottomOpusFragment L;
    private SubscribePersonalBottomDraftsFragment M;
    private String N;
    private a.d P;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements RadioGroup.OnCheckedChangeListener {
        a() {
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup radioGroup, int i3) {
            EventCollector.getInstance().onRadioGroupCheckedBefore(radioGroup, i3);
            if (RelativePersonalBottomView.this.G.getId() == i3) {
                RelativePersonalBottomView.this.F.setCurrentItem(0);
            } else if (RelativePersonalBottomView.this.H.getId() == i3) {
                if (!PermissionUtils.isStorePermissionEnable(RelativePersonalBottomView.this.getContext())) {
                    DialogUtil.showPermissionDialogForStorage((PublicFragmentActivity) RelativePersonalBottomView.this.getContext());
                    RelativePersonalBottomView.this.E.getChildAt(0).performClick();
                } else {
                    RelativePersonalBottomView.this.F.setCurrentItem(1);
                }
            }
            EventCollector.getInstance().onRadioGroupChecked(radioGroup, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class c extends FragmentPagerAdapter {
        public c(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public BaseFragment getItem(int i3) {
            if (i3 < RelativePersonalBottomView.this.K.size()) {
                return (BaseFragment) RelativePersonalBottomView.this.K.get(i3);
            }
            return null;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        /* renamed from: getCount */
        public int getF373114d() {
            return RelativePersonalBottomView.this.K.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }
    }

    public RelativePersonalBottomView(Context context, MultiViewBlock multiViewBlock) {
        this(context);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.J = multiViewBlock;
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    private void B() {
        this.K = new ArrayList();
        SubscribePersonalBottomOpusFragment subscribePersonalBottomOpusFragment = new SubscribePersonalBottomOpusFragment();
        this.L = subscribePersonalBottomOpusFragment;
        this.K.add(subscribePersonalBottomOpusFragment);
        if (getContext() instanceof PublicFragmentActivity) {
            this.N = ((PublicFragmentActivity) getContext()).app.getAccount();
        }
    }

    private void C() {
        this.E.setOnCheckedChangeListener(new a());
        this.F.setOnPageChangeListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        if (SubscribeDraftManager.f().i(this.N)) {
            if (this.M == null) {
                SubscribePersonalBottomDraftsFragment subscribePersonalBottomDraftsFragment = new SubscribePersonalBottomDraftsFragment();
                this.M = subscribePersonalBottomDraftsFragment;
                a.d dVar = this.P;
                if (dVar != null) {
                    Object obj = dVar.f96169a;
                    if (obj instanceof SubscribeBaseBottomPersonalFragment.a) {
                        SubscribeBaseBottomPersonalFragment.a aVar = (SubscribeBaseBottomPersonalFragment.a) obj;
                        subscribePersonalBottomDraftsFragment.rh(aVar.f96054a, aVar);
                    }
                }
            }
            if (!this.K.contains(this.M)) {
                VSReporter.p(this.N, "auth_pubish", "exp_draft", 0, 0, new String[0]);
                this.K.add(this.M);
                this.H.setVisibility(0);
                this.I.notifyDataSetChanged();
            }
            this.G.setBackgroundDrawable(getResources().getDrawable(R.drawable.a9z));
        } else {
            this.F.setCurrentItem(0);
            if (this.K.contains(this.M)) {
                this.K.remove(this.M);
                this.H.setVisibility(8);
                this.I.notifyDataSetChanged();
                this.G.setBackgroundDrawable(null);
            }
        }
        y();
    }

    private void y() {
        List<CertifiedAccountMeta$StFeed> list;
        List<SubscribeBaseBottomPersonalFragment> list2;
        MultiViewBlock multiViewBlock;
        a.d dVar = this.P;
        if (dVar != null) {
            Object obj = dVar.f96169a;
            if ((obj instanceof SubscribeBaseBottomPersonalFragment.a) && (((list = ((SubscribeBaseBottomPersonalFragment.a) obj).f96057d) == null || list.size() == 0) && (list2 = this.K) != null && !list2.contains(this.M) && (multiViewBlock = this.J) != null)) {
                final View childAt = multiViewBlock.A().a0().g().getChildAt(0);
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.subscribe.widget.relativevideo.RelativePersonalBottomView.4
                    @Override // java.lang.Runnable
                    public void run() {
                        if (childAt != null) {
                            ViewGroup.LayoutParams layoutParams = RelativePersonalBottomView.this.getLayoutParams();
                            layoutParams.height = ImmersiveUtils.getScreenHeight() - childAt.getHeight();
                            RelativePersonalBottomView.this.setLayoutParams(layoutParams);
                        }
                    }
                });
                return;
            }
        }
        if (getLayoutParams() != null && getLayoutParams().height != -1) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.subscribe.widget.relativevideo.RelativePersonalBottomView.5
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup.LayoutParams layoutParams = RelativePersonalBottomView.this.getLayoutParams();
                    layoutParams.height = -1;
                    RelativePersonalBottomView.this.setLayoutParams(layoutParams);
                }
            });
        }
    }

    public int A() {
        ViewPager viewPager = this.F;
        if (viewPager != null) {
            return viewPager.getCurrentItem();
        }
        return 0;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(SubDraftChangeEvent.class);
        arrayList.add(SubscribeFeedsEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView
    protected int i() {
        return R.layout.f167701ln;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(final SimpleBaseEvent simpleBaseEvent) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.subscribe.widget.relativevideo.RelativePersonalBottomView.3
            @Override // java.lang.Runnable
            public void run() {
                if (RelativePersonalBottomView.this.F != null && RelativePersonalBottomView.this.F.getContext() != null && !((Activity) RelativePersonalBottomView.this.F.getContext()).isFinishing()) {
                    SimpleBaseEvent simpleBaseEvent2 = simpleBaseEvent;
                    if (simpleBaseEvent2 instanceof SubDraftChangeEvent) {
                        RelativePersonalBottomView.this.D();
                        if (((SubDraftChangeEvent) simpleBaseEvent).getIsSave() && RelativePersonalBottomView.this.K.size() > 1 && RelativePersonalBottomView.this.F.getCurrentItem() != 1) {
                            RelativePersonalBottomView.this.F.setCurrentItem(1);
                            return;
                        }
                        return;
                    }
                    if ((simpleBaseEvent2 instanceof SubscribeFeedsEvent) && RelativePersonalBottomView.this.F.getCurrentItem() != 0 && ((SubscribeFeedsEvent) simpleBaseEvent).mState == 1) {
                        RelativePersonalBottomView.this.F.setCurrentItem(0);
                    }
                }
            }
        });
    }

    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView
    protected void p(Context context, View view) {
        this.E = (RadioGroup) view.findViewById(R.id.f166790m62);
        this.G = (RadioButton) view.findViewById(R.id.bxs);
        RadioButton radioButton = (RadioButton) view.findViewById(R.id.a6x);
        this.H = radioButton;
        radioButton.setVisibility(8);
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.byc);
        this.F = viewPager;
        viewPager.setOffscreenPageLimit(1);
        this.I = new c(((PublicFragmentActivity) context).getSupportFragmentManager());
        B();
        C();
    }

    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void c(a.d dVar) {
        if (dVar != null) {
            Object obj = dVar.f96169a;
            if (obj instanceof SubscribeBaseBottomPersonalFragment.a) {
                this.P = dVar;
                SubscribeBaseBottomPersonalFragment.a aVar = (SubscribeBaseBottomPersonalFragment.a) obj;
                Iterator<SubscribeBaseBottomPersonalFragment> it = this.K.iterator();
                while (it.hasNext()) {
                    it.next().rh(aVar.f96054a, aVar);
                }
                y();
                if (aVar.f96060g) {
                    D();
                }
            }
        }
    }

    public RelativePersonalBottomView(@NonNull Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b implements ViewPager.OnPageChangeListener {
        b() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i3) {
            com.tencent.biz.subscribe.a.a();
            if (RelativePersonalBottomView.this.E != null && RelativePersonalBottomView.this.E.getChildCount() > i3) {
                RelativePersonalBottomView.this.E.getChildAt(i3).performClick();
            }
            if (RelativePersonalBottomView.this.K.size() > i3) {
                ((SubscribeBaseBottomPersonalFragment) RelativePersonalBottomView.this.K.get(i3)).qh(i3);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i3) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i3, float f16, int i16) {
        }
    }
}
