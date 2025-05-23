package com.tencent.mobileqq.troop.troopapps;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopAppShortcutFragment extends PublicBaseFragment {
    static IPatchRedirector $redirector_;
    private TroopAppShortcutContainer C;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a extends TroopAppShortcutContainer {
        static IPatchRedirector $redirector_;

        a(Activity activity, SessionInfo sessionInfo, String str, int i3) {
            super(activity, sessionInfo, str, i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TroopAppShortcutFragment.this, activity, sessionInfo, str, Integer.valueOf(i3));
            }
        }

        @Override // com.tencent.mobileqq.troop.troopapps.TroopAppShortcutContainer
        public void y(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
            } else {
                this.f299317d.finish();
            }
        }
    }

    public TroopAppShortcutFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void ph(String str, int i3, View view) {
        VideoReport.addToDetectionWhitelist(requireActivity());
        VideoReport.setPageId(view, "pg_group_app");
        HashMap hashMap = new HashMap();
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_USER_FROM, Integer.valueOf(i3));
        hashMap.put("group_id", str);
        VideoReport.setPageParams(view, new PageParams(hashMap));
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bundle);
            return;
        }
        super.onActivityCreated(bundle);
        setStatusBar();
        TroopAppShortcutContainer troopAppShortcutContainer = this.C;
        if (troopAppShortcutContainer != null) {
            troopAppShortcutContainer.E();
            this.C.D();
        }
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.onActivityResult(i3, i16, intent);
        TroopAppShortcutContainer troopAppShortcutContainer = this.C;
        if (troopAppShortcutContainer != null) {
            troopAppShortcutContainer.i(i3, i16, intent);
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) configuration);
            return;
        }
        super.onConfigurationChanged(configuration);
        TroopAppShortcutContainer troopAppShortcutContainer = this.C;
        if (troopAppShortcutContainer != null) {
            troopAppShortcutContainer.A(configuration);
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View l3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            l3 = (View) iPatchRedirector.redirect((short) 2, this, layoutInflater, viewGroup, bundle);
        } else {
            String stringExtra = getBaseActivity().getIntent().getStringExtra("troop_uin");
            SessionInfo sessionInfo = (SessionInfo) getBaseActivity().getIntent().getParcelableExtra(AppConstants.Key.SESSION_INFO);
            int intExtra = getBaseActivity().getIntent().getIntExtra("reportfrom", 2);
            a aVar = new a(getBaseActivity(), sessionInfo, stringExtra, 2);
            this.C = aVar;
            if (aVar.l() == null) {
                l3 = null;
            } else {
                this.C.P(intExtra);
                ph(stringExtra, intExtra, this.C.l());
                l3 = this.C.l();
            }
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, l3);
        return l3;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.onDestroy();
        TroopAppShortcutContainer troopAppShortcutContainer = this.C;
        if (troopAppShortcutContainer != null) {
            troopAppShortcutContainer.C();
            this.C.B();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            super.onPause();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            super.onResume();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            super.onStart();
        }
    }

    public void setStatusBar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        SystemBarCompact systemBarComp = SystemBarActivityModule.getSystemBarComp((PublicFragmentActivity) getBaseActivity());
        if (systemBarComp != null) {
            systemBarComp.setStatusDrawable(null);
            systemBarComp.setStatusBarColor(0);
            systemBarComp.setStatusColor(0);
            if (!ThemeUtil.isNowThemeIsNight(getBaseActivity().app, true, null)) {
                ImmersiveUtils.setStatusTextColor(true, getBaseActivity().getWindow());
            }
        }
    }
}
