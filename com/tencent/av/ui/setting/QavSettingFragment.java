package com.tencent.av.ui.setting;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.biz.qui.quisecnavbar.e;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.setting.api.ISettingApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ea;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.bf;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class QavSettingFragment extends QIphoneTitleBarFragment {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class a implements CompoundButton.OnCheckedChangeListener {
        a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            int i3;
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            ea.m3(QavSettingFragment.this.getQBaseActivity().getAppRuntime().getCurrentUin(), z16);
            if (z16) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            ReportController.o(null, "dc00898", "", "", "0X800C136", "0X800C136", i3, 0, "", "", "", "");
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class b implements CompoundButton.OnCheckedChangeListener {
        b() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            int i3;
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            ea.n3(QavSettingFragment.this.getQBaseActivity().getAppRuntime().getCurrentUin(), z16);
            if (z16) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            ReportController.o(null, "dc00898", "", "", "0X800C137", "0X800C137", i3, 0, "", "", "", "");
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    private void ph() {
        BounceScrollView bounceScrollView;
        if (!needBlur() || this.quiSecNavBar == null) {
            return;
        }
        View view = ((QIphoneTitleBarFragment) this).mContentView;
        if (!(view instanceof BounceScrollView)) {
            return;
        }
        BounceScrollView bounceScrollView2 = (BounceScrollView) view;
        int b16 = e.b(bounceScrollView2.getContext());
        bounceScrollView2.setPadding(0, b16, 0, 0);
        bounceScrollView2.setClipToPadding(false);
        boolean isSettingPageNavNeedBlur = ((ISettingApi) QRoute.api(ISettingApi.class)).isSettingPageNavNeedBlur();
        boolean isSettingPageNavNeedAlpha = ((ISettingApi) QRoute.api(ISettingApi.class)).isSettingPageNavNeedAlpha();
        QUISecNavBar qUISecNavBar = this.quiSecNavBar;
        if (isSettingPageNavNeedBlur) {
            bounceScrollView = bounceScrollView2;
        } else {
            bounceScrollView = null;
        }
        qUISecNavBar.setBlur(isSettingPageNavNeedBlur, bounceScrollView);
        if (!isSettingPageNavNeedAlpha) {
            return;
        }
        if (isSettingPageNavNeedBlur) {
            this.quiSecNavBar.setTitleBlurAlpha(0.0f);
        } else {
            this.quiSecNavBar.setTitleAlpha(0.0f);
        }
        bounceScrollView2.setScrollListener(new c(b16, isSettingPageNavNeedBlur));
    }

    private void qh() {
        FormSwitchItem formSwitchItem = (FormSwitchItem) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f165149v11);
        formSwitchItem.setChecked(ea.s2(getQBaseActivity().getAppRuntime().getCurrentUin()));
        formSwitchItem.setOnCheckedChangeListener(new a());
        FormSwitchItem formSwitchItem2 = (FormSwitchItem) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f165150v12);
        formSwitchItem2.setChecked(ea.t2(getQBaseActivity().getAppRuntime().getCurrentUin()));
        formSwitchItem2.setOnCheckedChangeListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        setTitle("\u8bed\u97f3/\u89c6\u9891\u901a\u8bdd\u60ac\u6d6e\u7a97");
        qh();
        ph();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.fu8;
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public boolean needBlur() {
        return true;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public boolean useQUISecNavBar() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class c implements bf {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f76622a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f76623b;

        c(int i3, boolean z16) {
            this.f76622a = i3;
            this.f76623b = z16;
        }

        @Override // com.tencent.mobileqq.widget.bf
        public void c(View view, int i3, int i16, int i17, int i18) {
            float f16;
            int i19 = this.f76622a / 2;
            if (i16 <= 0) {
                f16 = 0.0f;
            } else if (i16 < i19) {
                f16 = (i16 * 1.0f) / i19;
            } else {
                f16 = 1.0f;
            }
            if (this.f76623b) {
                QavSettingFragment.this.quiSecNavBar.setTitleBlurAlpha(f16);
            } else {
                QavSettingFragment.this.quiSecNavBar.setTitleAlpha(f16);
            }
        }

        @Override // com.tencent.mobileqq.widget.bf
        public void b(View view, int i3) {
        }

        @Override // com.tencent.mobileqq.widget.bf
        public void a(View view, float f16, float f17) {
        }

        @Override // com.tencent.mobileqq.widget.bf
        public void d(View view, float f16, float f17) {
        }
    }
}
