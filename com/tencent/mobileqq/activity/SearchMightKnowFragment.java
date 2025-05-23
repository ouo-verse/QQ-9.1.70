package com.tencent.mobileqq.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.relation.widget.RecommendFriendContainerV2;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.search.ActionCallbackAdapter;
import com.tencent.mobileqq.widget.search.QUISearchBar;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.shadow.dynamic.host.Constant;
import com.tencent.util.InputMethodUtil;

/* compiled from: P */
/* loaded from: classes9.dex */
public class SearchMightKnowFragment extends PublicBaseFragment {
    static IPatchRedirector $redirector_;
    public QuickPinyinEditText C;
    public QQAppInterface D;
    private RecommendFriendContainerV2 E;
    private QUISearchBar F;
    private InputMethodManager G;
    private final BroadcastReceiver H;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SearchMightKnowFragment.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
            } else if ("search_might_know_finish".equals(intent.getAction()) && SearchMightKnowFragment.this.getBaseActivity() != null && !SearchMightKnowFragment.this.getBaseActivity().isFinishing()) {
                SearchMightKnowFragment.this.getBaseActivity().finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b extends ActionCallbackAdapter {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SearchMightKnowFragment.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.search.ActionCallbackAdapter, com.tencent.mobileqq.widget.search.QUISearchBar.ActionCallback
        public void onSearch() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                SearchMightKnowFragment.this.doSearch();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    public SearchMightKnowFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.D = null;
            this.H = new a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doSearch() {
        String trim = this.C.getText().toString().trim();
        InputMethodUtil.hide(this.C);
        if (trim != null && !trim.equals("")) {
            uh(trim);
        }
    }

    private void initView(View view) {
        this.D = getBaseActivity().app;
        QUISearchBar qUISearchBar = (QUISearchBar) view.findViewById(R.id.search_box);
        this.F = qUISearchBar;
        qUISearchBar.setCustomResource(com.tencent.mobileqq.search.util.ar.a());
        this.F.bindSearchChain(false);
        this.F.setActionCallback(new b());
        th();
        RecommendFriendContainerV2 recommendFriendContainerV2 = (RecommendFriendContainerV2) view.findViewById(R.id.s66);
        this.E = recommendFriendContainerV2;
        recommendFriendContainerV2.setAdapter(63);
        this.E.D();
        if (SimpleUIUtil.isNowElderMode()) {
            this.C.setHintTextColor(ResourcesCompat.getColor(getResources(), R.color.f156958bf2, null));
        }
        this.C.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.ew
            @Override // java.lang.Runnable
            public final void run() {
                SearchMightKnowFragment.this.lambda$initView$0();
            }
        }, 500L);
        sh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$0() {
        InputMethodUtil.show(this.C);
    }

    private void sh() {
        QuickPinyinEditText quickPinyinEditText = this.C;
        if (quickPinyinEditText == null) {
            return;
        }
        quickPinyinEditText.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.ex
            @Override // java.lang.Runnable
            public final void run() {
                SearchMightKnowFragment.this.vh();
            }
        }, 300L);
    }

    private void th() {
        QUISearchBar qUISearchBar = this.F;
        if (qUISearchBar == null) {
            return;
        }
        QuickPinyinEditText inputWidget = qUISearchBar.getInputWidget();
        this.C = inputWidget;
        inputWidget.setHint(HardCodeUtil.qqStr(R.string.f172666t70));
        this.G = (InputMethodManager) getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
    }

    private void uh(String str) {
        ReportController.o(null, "dc00898", "", "", "0X800A338", "0X800A338", 0, 0, "", "", "", "");
        ActiveEntitySearchActivity.c3(getBaseActivity(), str, HardCodeUtil.qqStr(R.string.t6z), new long[]{1001, Constant.FROM_ID_UNINSTALL_PLUGIN});
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: wh, reason: merged with bridge method [inline-methods] */
    public void vh() {
        if (this.C != null && this.G != null) {
            this.F.setFocusable(false);
            this.F.setFocusableInTouchMode(false);
            this.C.requestFocus();
            this.G.showSoftInput(this.C, 1);
            this.C.setCursorVisible(true);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
            return;
        }
        super.onCreate(bundle);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("search_might_know_finish");
        getContext().registerReceiver(this.H, intentFilter);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            inflate = (View) iPatchRedirector.redirect((short) 4, this, layoutInflater, viewGroup, bundle);
        } else {
            inflate = layoutInflater.inflate(R.layout.cez, viewGroup, false);
            initView(inflate);
            ReportController.o(null, "dc00898", "", "", "0X800A337", "0X800A337", 0, 0, "", "", "", "");
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.onDestroy();
            getContext().unregisterReceiver(this.H);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.onDestroyView();
        RecommendFriendContainerV2 recommendFriendContainerV2 = this.E;
        if (recommendFriendContainerV2 != null) {
            recommendFriendContainerV2.I();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onPause();
        RecommendFriendContainerV2 recommendFriendContainerV2 = this.E;
        if (recommendFriendContainerV2 != null) {
            recommendFriendContainerV2.J();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.onResume();
        RecommendFriendContainerV2 recommendFriendContainerV2 = this.E;
        if (recommendFriendContainerV2 != null) {
            recommendFriendContainerV2.K();
        }
    }
}
