package com.tencent.mobileqq.fragment;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.framebusiness.controllerinject.TabDataHelper;
import com.tencent.mobileqq.activity.home.ITabFrameController;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.eldermode.ElderModeManager;
import com.tencent.mobileqq.fragment.BottomTabSettingFragment;
import com.tencent.mobileqq.guild.api.IGuildConfigApi;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.logic.TabDataHandler;
import com.tencent.mobileqq.qcircle.api.event.QCircleFrameEvent;
import com.tencent.mobileqq.qcircle.api.requests.QCircleSetCircleSwitchRequest;
import com.tencent.mobileqq.qcircle.api.utils.EeveeRedpointUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.setting.api.ISettingApi;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import qqcircle.QQCircleCounter$RedPointInfo;
import qqcircle.QQCircleSwitch$SetCircleSwitchRsp;

/* compiled from: P */
/* loaded from: classes12.dex */
public class BottomTabSettingFragment extends QIphoneTitleBarFragment implements CompoundButton.OnCheckedChangeListener {
    static IPatchRedirector $redirector_;
    private QQAppInterface C;
    protected RelativeLayout D;
    protected LinearLayout E;
    protected Map<String, Integer> F;
    protected String G;
    private Map<String, Integer> H;
    private int I;
    private int J;
    private int K;
    private int L;
    private int M;
    private ListView N;
    private final HashMap<Integer, String> P;
    private c Q;
    private com.tencent.mobileqq.fragment.bottomtab.b R;
    private List<FormSwitchItem> S;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements d {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BottomTabSettingFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.fragment.BottomTabSettingFragment.d
        public void a(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
                return;
            }
            QCircleFrameEvent qCircleFrameEvent = new QCircleFrameEvent();
            qCircleFrameEvent.mAddTab = true;
            SimpleEventBus.getInstance().dispatchEvent(qCircleFrameEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements d {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BottomTabSettingFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.fragment.BottomTabSettingFragment.d
        public void a(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
            } else {
                BottomTabSettingFragment.mi(z16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class c extends BaseAdapter {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* loaded from: classes12.dex */
        class a extends AccessibilityDelegateCompat {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f211139a;

            a(int i3) {
                this.f211139a = i3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this, i3);
                }
            }

            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                boolean z16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) accessibilityNodeInfoCompat);
                    return;
                }
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                if (this.f211139a == BottomTabSettingFragment.this.M) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                accessibilityNodeInfoCompat.setSelected(z16);
            }
        }

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BottomTabSettingFragment.this);
            }
        }

        private View.OnClickListener b(final int i3) {
            return new View.OnClickListener() { // from class: com.tencent.mobileqq.fragment.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BottomTabSettingFragment.c.this.c(i3, view);
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(int i3, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (BottomTabSettingFragment.this.R.c(System.currentTimeMillis()) && view.getTag() != null && BottomTabSettingFragment.this.M != ((Integer) view.getTag()).intValue()) {
                BottomTabSettingFragment.this.Kh(i3);
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return BottomTabSettingFragment.this.P.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return Integer.valueOf(i3);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Long) iPatchRedirector.redirect((short) 4, (Object) this, i3)).longValue();
            }
            return i3;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [android.view.View] */
        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            FormSimpleItem formSimpleItem;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                formSimpleItem = (View) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), view, viewGroup);
            } else {
                FormSimpleItem formSimpleItem2 = new FormSimpleItem(BottomTabSettingFragment.this.getQBaseActivity());
                if (i3 == BottomTabSettingFragment.this.M) {
                    formSimpleItem2.setRightIcon(BottomTabSettingFragment.this.getResources().getDrawable(R.drawable.qq_account_select_icon), ScreenUtil.dip2px(16.0f), ScreenUtil.dip2px(16.0f));
                } else {
                    formSimpleItem2.setRightIcon(null);
                }
                if (i3 < BottomTabSettingFragment.this.P.size()) {
                    formSimpleItem2.setLeftText((CharSequence) BottomTabSettingFragment.this.P.get(Integer.valueOf(i3)));
                }
                formSimpleItem2.setTag(Integer.valueOf(i3));
                formSimpleItem2.setOnClickListener(b(i3));
                if (getCount() == 1) {
                    formSimpleItem2.setBgType(0);
                } else if (i3 == 0) {
                    formSimpleItem2.setBgType(1);
                } else if (i3 == getCount() - 1) {
                    formSimpleItem2.setBgType(3);
                } else {
                    formSimpleItem2.setBgType(2);
                }
                formSimpleItem = formSimpleItem2;
                if (AppSetting.f99565y) {
                    ViewCompat.setAccessibilityDelegate(formSimpleItem2, new a(i3));
                    formSimpleItem = formSimpleItem2;
                }
            }
            EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
            return formSimpleItem;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public interface d {
        void a(boolean z16);
    }

    public BottomTabSettingFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.F = new HashMap();
        this.H = new HashMap();
        this.I = 0;
        this.J = 1;
        this.K = 2;
        this.P = new HashMap<>();
        this.S = new ArrayList();
    }

    private void Ah() {
        if (this.S.isEmpty()) {
            return;
        }
        FormSwitchItem formSwitchItem = this.S.get(0);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) formSwitchItem.getLayoutParams();
        marginLayoutParams.topMargin = formSwitchItem.getContext().getResources().getDimensionPixelOffset(R.dimen.d95);
        formSwitchItem.setLayoutParams(marginLayoutParams);
    }

    private boolean Bh(String str) {
        if ((!((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch() && !ElderModeManager.j()) || this.F.get(str) == null) {
            return false;
        }
        int i3 = 0;
        for (Map.Entry<String, Integer> entry : this.F.entrySet()) {
            if (!str.equals(entry.getKey()) && entry.getValue() != null && entry.getValue().intValue() == 2) {
                i3++;
            }
        }
        if (i3 < 2) {
            return false;
        }
        return true;
    }

    private int Ch() {
        String str = TabDataHelper.TAB_NEW_WORLD;
        boolean Uh = Uh(TabDataHelper.TAB_NEW_WORLD);
        boolean Uh2 = Uh(TabDataHelper.TAB_RIJ);
        int i3 = this.I;
        if (Uh) {
            i3 = this.K;
        } else if (Uh2) {
            i3 = this.J;
            str = TabDataHelper.TAB_RIJ;
        } else {
            str = "none";
        }
        ji(str);
        return i3;
    }

    private int Fh() {
        int i3 = 0;
        for (Integer num : this.H.values()) {
            if (num != null && num.intValue() == 2) {
                i3++;
            }
        }
        return i3;
    }

    private HashMap<String, Boolean> Gh(String str) {
        HashMap<String, Boolean> hashMap = new HashMap<>();
        if (Vh(TabDataHelper.TAB_RIJ) != null) {
            hashMap.put(TabDataHelper.TAB_RIJ, Boolean.valueOf(str.equals(TabDataHelper.TAB_RIJ)));
        }
        if (Vh(TabDataHelper.TAB_NEW_WORLD) != null) {
            hashMap.put(TabDataHelper.TAB_NEW_WORLD, Boolean.valueOf(str.equals(TabDataHelper.TAB_NEW_WORLD)));
        }
        return hashMap;
    }

    private void Hh() {
        if (Vh(TabDataHelper.TAB_NEW_WORLD) != null) {
            mi(false);
        }
        ReportController.o(BaseApplicationImpl.getApplication().getRuntime(), "CliOper", "", "", "bottom_tab", "kandian_clk", 0, 0, "", "", "", "");
    }

    private void Ih() {
        if (Vh(TabDataHelper.TAB_NEW_WORLD) != null) {
            mi(false);
        }
        ReportController.o(BaseApplicationImpl.getApplication().getRuntime(), "CliOper", "", "", "bottom_tab", "no_display_clk", 0, 0, "", "", "", "");
    }

    private void Jh() {
        mi(true);
        ReportController.o(BaseApplicationImpl.getApplication().getRuntime(), "CliOper", "", "", "bottom_tab", "littleworld_clk", 0, 0, "", "", "", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kh(int i3) {
        String str;
        String str2 = this.P.get(Integer.valueOf(i3));
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        if (str2.equals(getResources().getString(R.string.c08))) {
            Hh();
            str = TabDataHelper.TAB_RIJ;
        } else {
            if (str2.equals(getResources().getString(R.string.zfw))) {
                Ih();
            } else if (str2.equals(uq3.c.O3())) {
                Jh();
                str = TabDataHelper.TAB_NEW_WORLD;
            }
            str = "none";
        }
        this.M = i3;
        c cVar = this.Q;
        if (cVar != null) {
            cVar.notifyDataSetChanged();
        }
        oi(Gh(str), this.R);
        ii(str);
    }

    private void Lh() {
        View view;
        View view2;
        if (!needBlur() || this.quiSecNavBar == null || (view = ((QIphoneTitleBarFragment) this).mContentView) == null) {
            return;
        }
        ((QIphoneTitleBarFragment) this).mContentView.setPadding(0, com.tencent.biz.qui.quisecnavbar.e.b(view.getContext()), 0, 0);
        boolean isSettingPageNavNeedBlur = ((ISettingApi) QRoute.api(ISettingApi.class)).isSettingPageNavNeedBlur();
        boolean isSettingPageNavNeedAlpha = ((ISettingApi) QRoute.api(ISettingApi.class)).isSettingPageNavNeedAlpha();
        QUISecNavBar qUISecNavBar = this.quiSecNavBar;
        if (isSettingPageNavNeedBlur) {
            view2 = ((QIphoneTitleBarFragment) this).mContentView;
        } else {
            view2 = null;
        }
        qUISecNavBar.setBlur(isSettingPageNavNeedBlur, view2);
        if (!isSettingPageNavNeedAlpha) {
            return;
        }
        if (isSettingPageNavNeedBlur) {
            this.quiSecNavBar.setTitleBlurAlpha(0.0f);
        } else {
            this.quiSecNavBar.setTitleAlpha(0.0f);
        }
    }

    private void Mh(int i3) {
        FormSwitchItem Qh = Qh(TabDataHelper.TAB_NEW_WORLD, R.id.twt, uq3.c.O3(), new b());
        if (Qh.getVisibility() == 0) {
            this.S.add(Qh);
        }
        Qh.setText(uq3.c.O3());
        yh(i3, TabDataHelper.TAB_NEW_WORLD, Qh);
    }

    private void Nh() {
        CharSequence guildTabName = ((IGuildConfigApi) QRoute.api(IGuildConfigApi.class)).getGuildTabName();
        FormSwitchItem Qh = Qh("GUILD", R.id.vvg, getString(R.string.f197834l3, guildTabName), new a());
        Qh.setText(guildTabName);
        if (Qh.getVisibility() == 0) {
            this.S.add(Qh);
        }
    }

    private void Oh() {
        Bundle arguments;
        if (getArguments() == null) {
            arguments = Bundle.EMPTY;
        } else {
            arguments = getArguments();
        }
        int i3 = arguments.getInt("KEY_ENABLE_TAB_ID", -1);
        if (!TabDataHelper.isTabShield(getContext(), this.C.getCurrentUin(), TabDataHelper.TAB_NEW_WORLD)) {
            Mh(i3);
        }
        if (!TabDataHelper.isTabShield(getContext(), this.C.getCurrentUin(), TabDataHelper.TAB_META_DREAM)) {
            Ph(i3);
        }
    }

    private void Ph(int i3) {
        FormSwitchItem Qh = Qh(TabDataHelper.TAB_META_DREAM, R.id.z5o, this.C.getApplicationContext().getString(R.string.f197844l4), null);
        int modelType = TabDataHelper.getModelType();
        if (modelType != 3 && modelType != 4) {
            Boolean Vh = Vh(TabDataHelper.TAB_META_DREAM);
            if (Vh == null) {
                return;
            }
            if (Qh.getVisibility() == 0) {
                this.S.add(Qh);
            }
            yh(i3, TabDataHelper.TAB_META_DREAM, Qh);
            if (Vh.booleanValue() && Xh()) {
                Qh.setChecked(false);
                return;
            }
            return;
        }
        Qh.setVisibility(8);
        if (this.H.containsKey(TabDataHelper.TAB_META_DREAM)) {
            this.H.put(TabDataHelper.TAB_META_DREAM, null);
        }
    }

    private FormSwitchItem Qh(final String str, int i3, String str2, final d dVar) {
        if (QLog.isColorLevel()) {
            QLog.d("BottomTabSettingFragment", 2, "[BottomTabSettingFragment][initSwitchItem] isGetTabSwitchCache: " + str);
        }
        final FormSwitchItem formSwitchItem = (FormSwitchItem) ((QIphoneTitleBarFragment) this).mContentView.findViewById(i3);
        Boolean Vh = Vh(str);
        if (Vh == null) {
            formSwitchItem.setVisibility(8);
            return formSwitchItem;
        }
        formSwitchItem.setVisibility(0);
        formSwitchItem.setContentDescription(str2);
        formSwitchItem.setChecked(Vh.booleanValue());
        ki(str, Vh.booleanValue(), false);
        formSwitchItem.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.fragment.d
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                BottomTabSettingFragment.this.Yh(formSwitchItem, str, dVar, compoundButton, z16);
            }
        });
        return formSwitchItem;
    }

    private void Rh() {
        if (Vh(TabDataHelper.TAB_RIJ) != null || Vh(TabDataHelper.TAB_NEW_WORLD) != null) {
            this.P.put(Integer.valueOf(this.I), getResources().getString(R.string.zfw));
        }
        if (Vh(TabDataHelper.TAB_RIJ) != null) {
            this.P.put(Integer.valueOf(this.J), getResources().getString(R.string.c08));
        }
        if (Vh(TabDataHelper.TAB_NEW_WORLD) != null) {
            this.P.put(Integer.valueOf(this.K), uq3.c.O3());
        }
    }

    private boolean Uh(String str) {
        Integer num = this.H.get(str);
        if (num == null || num.intValue() != 2) {
            return false;
        }
        return true;
    }

    private Boolean Vh(String str) {
        boolean z16;
        Map<String, Integer> map = this.H;
        if (map == null) {
            if (QLog.isColorLevel()) {
                QLog.d("BottomTabSettingFragment", 2, "[BottomTabSettingFragment][isSwitchHide] tabResultMap : " + ((Object) null));
            }
            return null;
        }
        Integer num = map.get(str);
        if (num != null && (num.intValue() == 3 || num.intValue() == 2)) {
            if (QLog.isColorLevel()) {
                QLog.d("BottomTabSettingFragment", 2, "[BottomTabSettingFragment][isSwitchHide] value : " + num);
            }
            if (num.intValue() == 2) {
                z16 = true;
            } else {
                z16 = false;
            }
            return Boolean.valueOf(z16);
        }
        if (QLog.isColorLevel()) {
            QLog.d("BottomTabSettingFragment", 2, "[BottomTabSettingFragment][isSwitchHide] value : " + num);
        }
        return null;
    }

    private boolean Wh() {
        if (Fh() + TabDataHelper.TAB_ARRAY_CONSTANT.length >= 5) {
            return true;
        }
        return false;
    }

    private boolean Xh() {
        if (Fh() + TabDataHelper.TAB_ARRAY_CONSTANT.length > 5) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Yh(FormSwitchItem formSwitchItem, String str, d dVar, CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        ei(formSwitchItem, str, z16, dVar);
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Zh(String str, boolean z16) {
        HashMap hashMap = new HashMap();
        hashMap.put(str, Boolean.valueOf(z16));
        ((TabDataHandler) this.C.getBusinessHandler(TabDataHandler.class.getName())).M2(hashMap, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void ai() {
        ((TabDataHandler) this.C.getBusinessHandler(TabDataHandler.class.getName())).D2(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void bi(boolean z16, BaseRequest baseRequest, boolean z17, long j3, String str, QQCircleSwitch$SetCircleSwitchRsp qQCircleSwitch$SetCircleSwitchRsp) {
        if (z17 && j3 == 0) {
            QLog.w("BottomTabSettingFragment", 1, "toggleQCircleTab success isChecked" + z16);
            if (!z16) {
                hi();
                com.tencent.mobileqq.activity.qcircle.utils.c.f().clearPedPoint();
                QLog.w("BottomTabSettingFragment", 1, "toggleQCircleTab success clearPedPoint");
                return;
            }
            return;
        }
        QLog.w("BottomTabSettingFragment", 1, "toggleQCircleTab error retcode= " + j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void ci(HashMap hashMap, com.tencent.mobileqq.fragment.bottomtab.b bVar) {
        ((TabDataHandler) ((QQAppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null)).getBusinessHandler(TabDataHandler.class.getName())).L2(hashMap);
        if (bVar != null) {
            bVar.f();
        }
    }

    private boolean di() {
        int i3 = this.L;
        int i16 = this.J;
        if ((i3 == i16 && this.M != i16) || (i3 != i16 && this.M == i16)) {
            return true;
        }
        return false;
    }

    private void ei(FormSwitchItem formSwitchItem, final String str, final boolean z16, d dVar) {
        int i3;
        if (z16 && Wh()) {
            formSwitchItem.setChecked(false);
            QQToast.makeText(this.C.getApplicationContext(), R.string.f197814l1, 0).show();
            return;
        }
        if (z16 && Bh(str)) {
            formSwitchItem.setChecked(false);
            QQToast.makeText(this.C.getApplicationContext(), 0, R.string.f197804l0, 0).show();
            return;
        }
        formSwitchItem.setEnabled(false);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.fragment.e
            @Override // java.lang.Runnable
            public final void run() {
                BottomTabSettingFragment.this.Zh(str, z16);
            }
        }, 160, null, true);
        ki(str, z16, true);
        if (dVar != null) {
            dVar.a(z16);
        }
        HashMap hashMap = new HashMap();
        int i16 = 2;
        if (z16) {
            i3 = 2;
        } else {
            i3 = 3;
        }
        hashMap.put(str, Integer.valueOf(i3));
        TabDataHelper.updateTabLocalSwitch(BaseApplication.getContext(), this.C.getCurrentAccountUin(), hashMap);
        Map<String, Integer> map = this.H;
        if (!z16) {
            i16 = 3;
        }
        map.put(str, Integer.valueOf(i16));
        this.R.f();
        ThreadManager.getUIHandler().postDelayed(new Runnable(formSwitchItem) { // from class: com.tencent.mobileqq.fragment.BottomTabSettingFragment.3
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ FormSwitchItem f211135d;

            {
                this.f211135d = formSwitchItem;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) BottomTabSettingFragment.this, (Object) formSwitchItem);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    this.f211135d.setEnabled(true);
                }
            }
        }, 200L);
    }

    private static void hi() {
        String str;
        QCircleLpReportDc05504.DataBuilder subActionType = new QCircleLpReportDc05504.DataBuilder().setToUin(HostDataTransUtils.getAccount()).setActionType(170).setSubActionType(1);
        QQCircleCounter$RedPointInfo lastExposeRedPointInfo = EeveeRedpointUtil.getLastExposeRedPointInfo();
        if (lastExposeRedPointInfo != null) {
            str = lastExposeRedPointInfo.extend.get();
            if (!TextUtils.isEmpty(str)) {
                subActionType.setExt10(str);
            }
        } else {
            str = null;
        }
        QLog.d("BottomTabSettingFragment", 1, "[reportRedPoint-reportQCircleTabClose] success extInfo:" + str);
        QCircleLpReportDc05504.report(subActionType);
    }

    private void ii(String str) {
        String q16 = ((ITabFrameController) QRoute.api(ITabFrameController.class)).getFrameInfoByKey(str).q();
        ReportController.o(null, "dc00898", "", "", q16, q16, 0, 0, Dh(), "", "", "");
    }

    private void initUI() {
        if (!TabDataHelper.isTabShield(getContext(), this.C.getCurrentUin(), "GUILD")) {
            Nh();
        }
        this.D = (RelativeLayout) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.t9y);
        this.E = (LinearLayout) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f27300fv);
        if (!Th()) {
            return;
        }
        if (Vh(TabDataHelper.TAB_RIJ) == null) {
            this.K = this.J;
            this.J = -100;
        }
        Rh();
        int Ch = Ch();
        this.M = Ch;
        this.L = Ch;
        this.N = (ListView) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f164638tb1);
        c cVar = new c();
        this.Q = cVar;
        this.N.setAdapter((ListAdapter) cVar);
        this.R = new com.tencent.mobileqq.fragment.bottomtab.b(this.E, this.C);
        View findViewById = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.bmt);
        if (findViewById != null) {
            findViewById.setBackgroundColor(getResources().getColor(R.color.skin_color_ffe6e6e6));
        }
        Oh();
        this.N.setVisibility(8);
        zh();
        Ah();
    }

    private void ji(String str) {
        int i3;
        int i16;
        int i17 = 2;
        if (str.equals("none")) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        ReportController.o(null, "dc00898", "", "", TabDataHelper.VALUE_SETTING_NONE_REPORT, TabDataHelper.VALUE_SETTING_NONE_REPORT, i3, 0, Dh(), "", "", "");
        if (str.equals(TabDataHelper.TAB_NEW_WORLD)) {
            i16 = 1;
        } else {
            i16 = 2;
        }
        ReportController.o(null, "dc00898", "", "", TabDataHelper.VALUE_SETTING_NEW_WORLD_REPORT, TabDataHelper.VALUE_SETTING_NEW_WORLD_REPORT, i16, 0, Dh(), "", "", "");
        if (str.equals(TabDataHelper.TAB_RIJ)) {
            i17 = 1;
        }
        ReportController.o(null, "dc00898", "", "", TabDataHelper.VALUE_SETTING_RIJ_REPORT, TabDataHelper.VALUE_SETTING_RIJ_REPORT, i17, 0, Dh(), "", "", "");
    }

    public static void mi(final boolean z16) {
        String str;
        String str2;
        if (StudyModeManager.t()) {
            str = QzoneConfig.SECONDARY_QQCIRCLE_SHOW_ENTRANCE_ON_MAIN_TAB_CHILDREN_MODE;
        } else {
            str = QzoneConfig.SECONDARY_QQCIRCLE_SHOW_ENTRANCE_ON_MAIN_TAB;
        }
        String str3 = "1";
        if (z16) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        QCircleSetCircleSwitchRequest qCircleSetCircleSwitchRequest = new QCircleSetCircleSwitchRequest("qqcircle", str, str2);
        QzoneConfig qzoneConfig = QzoneConfig.getInstance();
        if (!z16) {
            str3 = "0";
        }
        qzoneConfig.updateOneConfig("qqcircle", str, str3);
        QLog.w("BottomTabSettingFragment", 1, "toggleQCircleTab:" + z16);
        VSNetworkHelper.getInstance().sendRequest(qCircleSetCircleSwitchRequest, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.mobileqq.fragment.a
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z17, long j3, String str4, Object obj) {
                BottomTabSettingFragment.bi(z16, baseRequest, z17, j3, str4, (QQCircleSwitch$SetCircleSwitchRsp) obj);
            }
        });
    }

    public static void ni(HashMap<String, Boolean> hashMap) {
        oi(hashMap, null);
    }

    public static void oi(final HashMap<String, Boolean> hashMap, final com.tencent.mobileqq.fragment.bottomtab.b bVar) {
        if (hashMap != null) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.fragment.c
                @Override // java.lang.Runnable
                public final void run() {
                    BottomTabSettingFragment.ci(hashMap, bVar);
                }
            }, 160, null, true);
        }
    }

    private void yh(int i3, String str, FormSwitchItem formSwitchItem) {
        Boolean Vh;
        if (TabDataHelper.isAutoEnable() && (Vh = Vh(str)) != null && !Vh.booleanValue() && i3 == TabDataHelper.getTabId(str) && !Wh()) {
            formSwitchItem.setChecked(true);
        }
    }

    private void zh() {
        if (this.S.isEmpty()) {
            return;
        }
        if (this.S.size() == 1) {
            this.S.get(0).setBgType(0);
            return;
        }
        int size = this.S.size();
        this.S.get(0).setBgType(1);
        int i3 = 1;
        while (true) {
            int i16 = size - 1;
            if (i3 < i16) {
                this.S.get(i3).setBgType(2);
                i3++;
            } else {
                this.S.get(i16).setBgType(3);
                return;
            }
        }
    }

    protected String Dh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        if (getActivity() != null && getActivity().getIntent() != null) {
            String stringExtra = getActivity().getIntent().getStringExtra("KEY_ENTRANCE");
            QLog.d("BottomTabSettingFragment", 1, "getEntranceReportValue entrance: " + stringExtra);
            if ("VALUE_QQ_SETTING".equals(stringExtra)) {
                return "1";
            }
            if ("VALUE_QQ_ASSISTANT_SETTING".equals(stringExtra)) {
                return "2";
            }
            return "";
        }
        return "";
    }

    protected void Eh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        this.G = TabDataHelper.getTabRuleList(this.C.getApplicationContext(), this.C.getCurrentUin(), TabDataHelper.getModelType());
        this.F = TabDataHelper.getTabSwitch(this.C.getApplicationContext(), this.C.getCurrentUin(), TabDataHelper.SCENE_BOTTOM_TAB_SETTING);
        if (QLog.isColorLevel()) {
            QLog.d("BottomTabSettingFragment", 2, "[BottomTabSettingFragment][getLocalTabCache]  allTabListCacheString: " + this.G + " tabSwitchMap: " + this.F);
        }
    }

    protected boolean Sh() {
        boolean gi5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        boolean z16 = true;
        if (this.F != null && !TextUtils.isEmpty(this.G)) {
            gi5 = true;
        } else {
            QQToast.makeText(getQBaseActivity(), 1, R.string.f197784ky, 2000).show();
            gi5 = gi();
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[BottomTabSettingFragment][isGetTabSwitchCache] tabSwitchMap == null: ");
            if (this.F != null) {
                z16 = false;
            }
            sb5.append(z16);
            QLog.d("BottomTabSettingFragment", 2, sb5.toString());
            if (this.F != null) {
                QLog.d("BottomTabSettingFragment", 2, "[BottomTabSettingFragment][isGetTabSwitchCache] tabSwitchMap.isEmpty(): " + this.F.isEmpty() + " TextUtils.isEmpty(allTabListCacheString): " + TextUtils.isEmpty(this.G));
            }
        }
        return gi5;
    }

    public boolean Th() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        if (this.H != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, layoutInflater, viewGroup, bundle);
            return;
        }
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        setTitle(getResources().getText(R.string.f170635zg0));
        initUI();
        Lh();
        ReportController.o(BaseApplicationImpl.getApplication().getRuntime(), "CliOper", "", "", "bottom_tab", "page_exp", 0, 0, "1", "", "", "");
        ReportController.o(null, "dc00898", "", "", TabDataHelper.VALUE_SETTING_BOTTOM_TAB, TabDataHelper.VALUE_SETTING_BOTTOM_TAB, 0, 0, Dh(), "", "", "");
    }

    protected void fi() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        Eh();
        Map<String, Integer> map = this.F;
        if (map == null) {
            if (QLog.isColorLevel()) {
                QLog.d("BottomTabSettingFragment", 2, "[BottomTabSettingFragment][openTabTips] tabSwitchMap == null: true");
            }
        } else {
            Integer num = map.get(TabDataHelper.TAB_NEW_WORLD);
            if (this.F != null && num != null && (str = this.G) != null) {
                str.isEmpty();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.layout.g3j;
    }

    protected boolean gi() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        boolean z16 = true;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.fragment.b
            @Override // java.lang.Runnable
            public final void run() {
                BottomTabSettingFragment.this.ai();
            }
        }, 160, null, true);
        Map<String, Integer> map = this.F;
        if (map != null && !map.isEmpty() && !TextUtils.isEmpty(this.G)) {
            return true;
        }
        QQToast.makeText(getQBaseActivity(), 1, R.string.f197774kx, 2000).show();
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[BottomTabSettingFragment][refreshTabListNet] tabSwitchMap == null: ");
            if (this.F != null) {
                z16 = false;
            }
            sb5.append(z16);
            QLog.d("BottomTabSettingFragment", 2, sb5.toString());
            if (this.F != null) {
                QLog.d("BottomTabSettingFragment", 2, "[BottomTabSettingFragment][refreshTabListNet] tabSwitchMap.isEmpty(): " + this.F.isEmpty() + " TextUtils.isEmpty(allTabListCacheString): " + TextUtils.isEmpty(this.G));
            }
        }
        return false;
    }

    protected void ki(String str, boolean z16, boolean z17) {
        String r16;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, str, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        com.tencent.mobileqq.activity.home.impl.c frameInfoByKey = ((ITabFrameController) QRoute.api(ITabFrameController.class)).getFrameInfoByKey(str);
        if (z17) {
            r16 = frameInfoByKey.q();
        } else {
            r16 = frameInfoByKey.r();
        }
        String str2 = r16;
        if (!z16) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        ReportController.o(null, "dc00898", "", "", str2, str2, i3, 0, Dh(), "", "", "");
    }

    protected HashMap<String, Integer> li() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (HashMap) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        if (this.F == null) {
            if (QLog.isColorLevel()) {
                QLog.d("BottomTabSettingFragment", 2, "[BottomTabSettingFragment][tabInfo] tabSwitchMap == null: true");
            }
            return null;
        }
        if (this.G == null) {
            if (QLog.isColorLevel()) {
                QLog.d("BottomTabSettingFragment", 2, "[BottomTabSettingFragment][tabInfo] allTabListCacheString == null: true");
            }
            return null;
        }
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (Map.Entry<String, Integer> entry : this.F.entrySet()) {
            Integer value = entry.getValue();
            if (this.G.contains(entry.getKey()) && value != null && (value.intValue() == 2 || value.intValue() == 3)) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return hashMap;
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public boolean needBlur() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, compoundButton, Boolean.valueOf(z16));
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) configuration);
        } else {
            super.onConfigurationChanged(configuration);
            this.R.e(configuration);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle);
            return;
        }
        super.onCreate(bundle);
        QQAppInterface qQAppInterface = (QQAppInterface) getQBaseActivity().getAppRuntime();
        this.C = qQAppInterface;
        if (!qQAppInterface.isLogin()) {
            Intent intent = new Intent();
            intent.addFlags(262144);
            RouteUtils.startActivity(getQBaseActivity(), intent, RouterConstants.UI_ROUTER_LOGIN);
            getQBaseActivity().finish();
        }
        Eh();
        this.H = li();
        if (!Sh() || this.H == null) {
            onDestroy();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        super.onDestroy();
        fi();
        if (di()) {
            ((ILebaHelperService) this.C.getRuntimeService(ILebaHelperService.class, "")).reloadLebaItems(this.C);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public boolean useQUISecNavBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return true;
    }
}
