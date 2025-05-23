package com.tencent.mobileqq.guild.feed.part;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.event.GuildJoinSuccessEvent;
import com.tencent.mobileqq.guild.feed.event.GuildEmptyPartEvent;
import com.tencent.mobileqq.guild.feed.event.GuildFeedThemeChangeEvent;
import com.tencent.mobileqq.guild.feed.event.GuildFeedTopDataEvent;
import com.tencent.mobileqq.guild.feed.event.GuildSpeakThresholdStateChangeEvent;
import com.tencent.mobileqq.guild.feed.viewmodel.GuildFeedListViewModel;
import com.tencent.mobileqq.guild.util.IGuildFastClickUtilApi;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;

/* loaded from: classes13.dex */
public class GuildFeedEmptyListPart extends com.tencent.mobileqq.guild.feed.part.f implements View.OnClickListener {
    private static final Float H = Float.valueOf(65.0f);
    private static final Float I = Float.valueOf(141.8f);
    private static final Float J = Float.valueOf(40.0f);
    private static final Float K = Float.valueOf(44.0f);
    private QUIEmptyState C;
    private boolean D;
    private boolean E = false;
    private boolean F = true;
    private List<ij1.h> G;

    /* renamed from: h, reason: collision with root package name */
    private LinearLayout f222421h;

    /* renamed from: i, reason: collision with root package name */
    private TextView f222422i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f222423m;

    /* loaded from: classes13.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!((IGuildFastClickUtilApi) QRoute.api(IGuildFastClickUtilApi.class)).isFastClick(view)) {
                GuildFeedEmptyListPart.this.L9();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes13.dex */
    class b implements Observer<UIStateData<List<ij1.g>>> {
        b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(UIStateData<List<ij1.g>> uIStateData) {
            GuildFeedEmptyListPart.this.z9(uIStateData);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes13.dex */
    public class c implements Observer<String> {
        c() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(String str) {
            if (GuildFeedEmptyListPart.this.f222422i != null) {
                TextView textView = GuildFeedEmptyListPart.this.f222422i;
                if (GuildFeedEmptyListPart.this.x9().getBusinessType() == 7) {
                    str = GuildFeedEmptyListPart.this.getContext().getString(R.string.f144020nn);
                }
                textView.setText(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes13.dex */
    public class d implements Observer<Boolean> {
        d() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            boolean z16;
            boolean k3 = sz1.d.k(GuildFeedEmptyListPart.this.x9().getGuildId(), GuildFeedEmptyListPart.this.x9().getChannelId());
            boolean isChannelLevelAdmin = ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).isChannelLevelAdmin(GuildFeedEmptyListPart.this.x9().getChannelId());
            GuildFeedEmptyListPart guildFeedEmptyListPart = GuildFeedEmptyListPart.this;
            if (k3 && !isChannelLevelAdmin) {
                z16 = true;
            } else {
                z16 = false;
            }
            guildFeedEmptyListPart.E = z16;
            GuildFeedEmptyListPart.this.S9(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes13.dex */
    public class e implements Observer<Long> {
        e() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Long l3) {
            GuildFeedEmptyListPart.this.R9(com.tencent.mobileqq.guild.setting.mute.c.O(l3));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes13.dex */
    public class f implements Observer<Long> {
        f() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Long l3) {
            GuildFeedEmptyListPart.this.R9(com.tencent.mobileqq.guild.setting.mute.c.O(l3));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes13.dex */
    public class g implements Observer<Boolean> {
        g() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            GuildFeedEmptyListPart.this.R9(bool.booleanValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes13.dex */
    public class h implements Observer<Boolean> {
        h() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            GuildFeedEmptyListPart guildFeedEmptyListPart = GuildFeedEmptyListPart.this;
            guildFeedEmptyListPart.R9(guildFeedEmptyListPart.D);
        }
    }

    private void I9() {
        QUIEmptyState qUIEmptyState;
        if (x9() != null && this.f222421h != null) {
            if (x9().isNewCreated()) {
                this.f222421h.setVisibility(0);
            }
            if (x9().getBusinessType() == 7) {
                this.f222422i.setText(getContext().getString(R.string.f144020nn));
            } else {
                this.f222422i.setText(x9().getChannelName());
            }
            P9();
            if (!x9().isMember() && (qUIEmptyState = this.C) != null) {
                qUIEmptyState.findViewById(R.id.uum).setAlpha(0.5f);
                this.C.findViewById(R.id.uuk).setAlpha(0.5f);
                this.F = false;
            }
            QLog.d("GuildFeedEmptyListPart", 1, "isNewCreated");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J9() {
        int i3;
        List<ij1.h> list = this.G;
        if (list != null) {
            i3 = list.size();
        } else {
            i3 = 0;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (x9().getBusinessType() == 7) {
            if (T9()) {
                layoutParams.setMargins(0, com.tencent.mobileqq.guild.feed.util.e.a(getContext(), H.floatValue() + K.floatValue() + (i3 * J.floatValue())) + ImmersiveUtils.getStatusBarHeight(getContext()), 0, 0);
            } else {
                layoutParams.setMargins(0, com.tencent.mobileqq.guild.feed.util.e.a(getContext(), H.floatValue() + (i3 * J.floatValue())), 0, 0);
            }
        } else {
            layoutParams.setMargins(0, com.tencent.mobileqq.guild.feed.util.e.a(getContext(), I.floatValue() + (i3 * J.floatValue())), 0, 0);
        }
        this.f222421h.setLayoutParams(layoutParams);
    }

    private void K9(GuildJoinSuccessEvent guildJoinSuccessEvent) {
        if (x9() != null && !TextUtils.isEmpty(guildJoinSuccessEvent.getCurrentId())) {
            x9().setIsMember(true);
            S9(!this.D);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L9() {
        if (x9() != null && getContext() != null) {
            if (this.F) {
                em1.a.c(getContext(), x9());
                com.tencent.mobileqq.guild.main.d.d(MobileQQ.sMobileQQ.peekAppRuntime(), x9().getGuildId(), "publish click on empty list part");
            } else if (x9().getBusinessType() != 7 && ch.j0(x9().getGuildId())) {
                QQToast.makeText(getActivity(), getActivity().getString(R.string.f143780n0), 0).show();
            } else if (sz1.d.k(x9().getGuildId(), x9().getChannelId())) {
                com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.view.c.c(getActivity(), x9().getGuildId());
            } else {
                QQToast.makeText(getActivity(), com.tencent.mobileqq.guild.feed.util.av.f223852a.e(getActivity(), this.f222551f, x9()), 0).show();
            }
        }
    }

    private void M9(GuildSpeakThresholdStateChangeEvent guildSpeakThresholdStateChangeEvent) {
        boolean z16;
        if (O9(guildSpeakThresholdStateChangeEvent.mSpeakThresholdState.getGuildLimitType()) && !guildSpeakThresholdStateChangeEvent.mIsChannelLevelAdmin) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.E = z16;
        S9(true);
    }

    private void N9(GuildEmptyPartEvent guildEmptyPartEvent) {
        int i3;
        LinearLayout linearLayout = this.f222421h;
        if (linearLayout == null) {
            return;
        }
        if (guildEmptyPartEvent.isShowView()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        linearLayout.setVisibility(i3);
        if (guildEmptyPartEvent.isShowView()) {
            J9();
        }
    }

    private boolean O9(int i3) {
        if (i3 != 4 && i3 != 2) {
            return false;
        }
        return true;
    }

    private void P9() {
        if (getHostFragment() == null) {
            return;
        }
        this.f222551f.M1().observe(getHostFragment(), new c());
        this.f222551f.R1().observe(getHostFragment(), new d());
        this.f222551f.T1().observe(getHostFragment(), new e());
        this.f222551f.L1().observe(getHostFragment(), new f());
        this.f222551f.U1().observe(getHostFragment(), new g());
        this.f222551f.O1().observe(getHostFragment(), new h());
    }

    private void Q9() {
        if (getContext() == null) {
            return;
        }
        QQTheme.isNowThemeIsNight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R9(boolean z16) {
        boolean z17;
        boolean b26 = this.f222551f.b2();
        this.D = b26;
        if (b26 && !this.E) {
            z17 = false;
        } else {
            z17 = true;
        }
        S9(z17);
        U9(b26);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S9(boolean z16) {
        if (this.C == null) {
            return;
        }
        if (z16 && x9() != null && x9().isMember() && !this.D && !this.E) {
            this.F = true;
            this.C.findViewById(R.id.uum).setAlpha(1.0f);
            this.C.findViewById(R.id.uuk).setAlpha(1.0f);
        } else {
            this.F = false;
            this.C.findViewById(R.id.uum).setAlpha(0.5f);
            this.C.findViewById(R.id.uuk).setAlpha(0.5f);
        }
    }

    private boolean T9() {
        if (getActivity() == null || getActivity().getIntent() == null) {
            return false;
        }
        return getActivity().getIntent().getBooleanExtra("key_show_title", false);
    }

    private void U9(boolean z16) {
        String string;
        if (this.E) {
            this.f222423m.setVisibility(4);
            return;
        }
        if (z16 && x9() != null) {
            this.f222423m.setVisibility(0);
            String u16 = com.tencent.mobileqq.guild.setting.mute.c.u(x9().getGuildId(), x9().getChannelId());
            if (TextUtils.isEmpty(u16)) {
                u16 = getContext().getString(R.string.f197334jq);
            }
            TextView textView = this.f222423m;
            if (x9().getBusinessType() == 7) {
                u16 = getContext().getString(R.string.f144040np);
            }
            textView.setText(u16);
            return;
        }
        this.f222423m.setVisibility(0);
        TextView textView2 = this.f222423m;
        if (x9().getBusinessType() == 7) {
            string = getContext().getString(R.string.f144040np);
        } else {
            string = getContext().getString(R.string.f144030no);
        }
        textView2.setText(string);
    }

    @Override // com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> eventClass = super.getEventClass();
        eventClass.add(GuildEmptyPartEvent.class);
        eventClass.add(GuildFeedThemeChangeEvent.class);
        eventClass.add(GuildJoinSuccessEvent.class);
        eventClass.add(GuildSpeakThresholdStateChangeEvent.class);
        eventClass.add(GuildFeedTopDataEvent.class);
        return eventClass;
    }

    @Override // com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "GuildFeedEmptyListPart";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.feed.part.f
    public void initViewModel() {
        com.tencent.mobileqq.guild.feed.viewmodel.l lVar = (com.tencent.mobileqq.guild.feed.viewmodel.l) getViewModel(GuildFeedListViewModel.class);
        this.f222550e = lVar;
        if (lVar == null) {
            return;
        }
        lVar.j().observeForever(new b());
        if (x9() == null) {
            return;
        }
        com.tencent.mobileqq.guild.feed.viewmodel.k kVar = (com.tencent.mobileqq.guild.feed.viewmodel.k) getViewModel(com.tencent.mobileqq.guild.feed.viewmodel.k.class);
        this.f222551f = kVar;
        kVar.Z1(x9().getGuildId(), x9().getChannelId());
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.w8y);
        this.f222421h = linearLayout;
        linearLayout.setOnClickListener(this);
        this.f222423m = (TextView) view.findViewById(R.id.wf5);
        this.f222422i = (TextView) view.findViewById(R.id.wbv);
        QUIEmptyState build = new QUIEmptyState.Builder(getContext()).setImageType(8).setButton(HardCodeUtil.qqStr(R.string.f144850pw), new a()).setHalfScreenState(false).setBackgroundColorType(0).build();
        this.C = build;
        ((QUIButton) build.findViewById(R.id.uum)).getLayoutParams().width = -2;
        ((LinearLayout) view.findViewById(R.id.v2_)).addView(this.C);
        Q9();
        I9();
    }

    @Override // com.tencent.mobileqq.guild.feed.part.f, com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        this.f222551f.onDestroy();
        super.onPartDestroy(activity);
    }

    @Override // com.tencent.mobileqq.guild.feed.part.d, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        super.onReceiveEvent(simpleBaseEvent);
        if (simpleBaseEvent instanceof GuildEmptyPartEvent) {
            N9((GuildEmptyPartEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof GuildFeedThemeChangeEvent) {
            Q9();
            return;
        }
        if (simpleBaseEvent instanceof GuildJoinSuccessEvent) {
            K9((GuildJoinSuccessEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof GuildSpeakThresholdStateChangeEvent) {
            M9((GuildSpeakThresholdStateChangeEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof GuildFeedTopDataEvent) {
            this.G = ((GuildFeedTopDataEvent) simpleBaseEvent).getTopDataList();
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.part.GuildFeedEmptyListPart.9
                @Override // java.lang.Runnable
                public void run() {
                    GuildFeedEmptyListPart.this.J9();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.feed.part.f
    public void z9(UIStateData<List<ij1.g>> uIStateData) {
        super.z9(uIStateData);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
