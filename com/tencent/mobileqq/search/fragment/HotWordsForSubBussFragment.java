package com.tencent.mobileqq.search.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.UnifySearchHandler;
import com.tencent.mobileqq.app.di;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.search.api.impl.FunctionConfigManagerImpl;
import com.tencent.mobileqq.search.model.BusinessGroupWord;
import com.tencent.mobileqq.search.searchlocal.HotWordForSubTipsContainer;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class HotWordsForSubBussFragment extends QBaseFragment {
    public static final String L = "unify_search" + HotWordsForSubBussFragment.class.getSimpleName();
    protected static int M = -1;
    protected View C;
    protected TextView D;
    protected HotWordForSubTipsContainer E;
    protected UnifySearchHandler F;
    protected long[] G;
    private int H;
    private Boolean J;
    private boolean I = false;
    protected di K = new a();

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a extends di {
        a() {
        }

        @Override // com.tencent.mobileqq.app.di
        public void a(int i3, String str) {
            super.a(i3, str);
            if (QLog.isColorLevel()) {
                QLog.w(HotWordsForSubBussFragment.L, 2, "unify handleBusiHotWordError code=" + i3 + " errorMsg;" + str);
            }
        }

        @Override // com.tencent.mobileqq.app.di
        public void b(int i3, List<BusinessGroupWord> list) {
            HotWordsForSubBussFragment.M = i3;
            HotWordsForSubBussFragment.this.vh(list);
            if (QLog.isColorLevel()) {
                QLog.i(HotWordsForSubBussFragment.L, 2, "unify handleTabSearchResult expireTime;" + HotWordsForSubBussFragment.M);
            }
        }
    }

    private boolean rh() {
        AppInterface appInterface = (AppInterface) getQBaseActivity().getAppRuntime();
        if (appInterface == null) {
            return false;
        }
        if (this.J == null) {
            this.J = Boolean.valueOf(((IFeatureRuntimeService) appInterface.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("search_is_hot_word_req_enabled", false));
        }
        return this.J.booleanValue();
    }

    private void th() {
        long parseLong;
        if (!rh()) {
            return;
        }
        if (this.F != null) {
            final boolean z16 = false;
            String string = BaseApplication.getContext().getSharedPreferences(UnifySearchHandler.f195169m, 0).getString(UnifySearchHandler.C, "");
            if (!TextUtils.isEmpty(string)) {
                try {
                    parseLong = Long.parseLong(string);
                } catch (Exception unused) {
                    if (QLog.isColorLevel()) {
                        QLog.i(L, 2, "UnifySearchHandler reqTimeStr number format error");
                    }
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (M != -1 || currentTimeMillis - parseLong > r2 * 1000) {
                    z16 = true;
                }
                ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.search.fragment.HotWordsForSubBussFragment.1
                    @Override // java.lang.Runnable
                    public void run() {
                        final byte[] N2 = HotWordsForSubBussFragment.this.F.N2(UnifySearchHandler.f195169m);
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.search.fragment.HotWordsForSubBussFragment.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (N2 != null) {
                                    QLog.d(HotWordsForSubBussFragment.L, 1, "UnifySearchHandler use cache!");
                                    HotWordsForSubBussFragment.this.F.F2(null, 1000, N2);
                                } else if (!z16 && QLog.isColorLevel()) {
                                    QLog.d(HotWordsForSubBussFragment.L, 2, "UnifySearchHandler hot word list cache is null\uff01");
                                }
                            }
                        });
                    }
                }, 5, null, true);
                return;
            }
            parseLong = -1;
            long currentTimeMillis2 = System.currentTimeMillis();
            if (M != -1) {
            }
            z16 = true;
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.search.fragment.HotWordsForSubBussFragment.1
                @Override // java.lang.Runnable
                public void run() {
                    final byte[] N2 = HotWordsForSubBussFragment.this.F.N2(UnifySearchHandler.f195169m);
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.search.fragment.HotWordsForSubBussFragment.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (N2 != null) {
                                QLog.d(HotWordsForSubBussFragment.L, 1, "UnifySearchHandler use cache!");
                                HotWordsForSubBussFragment.this.F.F2(null, 1000, N2);
                            } else if (!z16 && QLog.isColorLevel()) {
                                QLog.d(HotWordsForSubBussFragment.L, 2, "UnifySearchHandler hot word list cache is null\uff01");
                            }
                        }
                    });
                }
            }, 5, null, true);
            return;
        }
        QLog.e(L, 2, "requestData HANDLE is null");
    }

    private void uh(List<BusinessGroupWord.c> list) {
        if (this.G == null) {
            return;
        }
        if (list != null && list.size() != 0) {
            this.D.setVisibility(0);
            if (this.I) {
                this.E.d(list, R.drawable.f160847ny, getResources().getColor(R.color.acm), getResources().getColor(R.color.acl));
                return;
            } else {
                this.E.d(list, R.drawable.f160844nv, getResources().getColor(R.color.black), getResources().getColor(R.color.ack));
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(L, 2, "update BusiHotWords results is null");
        }
        this.D.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vh(List<BusinessGroupWord> list) {
        if (this.G == null) {
            return;
        }
        if (list == null) {
            if (QLog.isColorLevel()) {
                QLog.d(L, 2, "updateBusiHotWords results is null");
                return;
            }
            return;
        }
        for (BusinessGroupWord businessGroupWord : list) {
            long[] k3 = SearchUtils.k(businessGroupWord.groupID.f283445a);
            if (k3 != null && Arrays.equals(k3, this.G)) {
                BusinessGroupWord.a aVar = businessGroupWord.clueWordItem;
                QBaseActivity qBaseActivity = getQBaseActivity();
                if (qBaseActivity instanceof ActiveEntitySearchActivity) {
                    ((ActiveEntitySearchActivity) qBaseActivity).l3(aVar.f283444b);
                }
                List<BusinessGroupWord.c> list2 = businessGroupWord.hotWordItemList;
                if (list2 != null && list2.size() > 0) {
                    this.D.setVisibility(0);
                    if (this.I) {
                        this.E.d(list2, R.drawable.f160847ny, getResources().getColor(R.color.acm), getResources().getColor(R.color.acl));
                    } else {
                        this.E.d(list2, R.drawable.f160844nv, getResources().getColor(R.color.black), getResources().getColor(R.color.ack));
                    }
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.G = arguments.getLongArray("group_masks");
            this.H = arguments.getInt(IProfileCardConst.KEY_FROM_TYPE, -1);
        }
        qh();
        th();
        super.onCreate(bundle);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.b4r, (ViewGroup) null);
        this.C = inflate;
        this.D = (TextView) inflate.findViewById(R.id.k8q);
        this.E = (HotWordForSubTipsContainer) this.C.findViewById(R.id.jmp);
        boolean isInNightMode = ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime());
        this.I = isInNightMode;
        if (isInNightMode) {
            this.D.setTextColor(Color.parseColor("#44608A"));
            this.C.setBackgroundResource(R.drawable.f160534jf);
        } else {
            this.D.setTextColor(Color.parseColor("#999999"));
            this.C.setBackgroundResource(R.drawable.f160533je);
        }
        uh(FunctionConfigManagerImpl.busiHotWordListMap.get(FunctionConfigManagerImpl.convertGroupMaskToKey(this.G)));
        View view = this.C;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        sh();
    }

    protected void qh() {
        AppInterface appInterface = (AppInterface) getQBaseActivity().getAppRuntime();
        this.F = (UnifySearchHandler) appInterface.getBusinessHandler(BusinessHandlerFactory.UNIFY_SEARCH_UNITE_HANDLER);
        appInterface.addObserver(this.K);
    }

    protected void sh() {
        ((AppInterface) getQBaseActivity().getAppRuntime()).removeObserver(this.K);
    }
}
