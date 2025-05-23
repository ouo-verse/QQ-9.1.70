package com.tencent.mobileqq.troop.homework.entry.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.troop.ITroopListRepoApi;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes19.dex */
public class HomeWorkTroopSelectorFragment extends QIphoneTitleBarFragment implements Runnable {
    static IPatchRedirector $redirector_;
    private ListView C;
    private AppInterface D;
    private boolean E;
    private String F;
    private List<String> G;
    private TroopInfo H;
    private b I;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) HomeWorkTroopSelectorFragment.this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ArrayList<String> arrayList = new ArrayList<>();
                ArrayList<String> arrayList2 = new ArrayList<>();
                if (HomeWorkTroopSelectorFragment.this.I != null) {
                    int count = HomeWorkTroopSelectorFragment.this.I.getCount();
                    for (int i3 = 0; i3 < count; i3++) {
                        c cVar = (c) HomeWorkTroopSelectorFragment.this.I.getItem(i3);
                        if (((Boolean) cVar.f296955b).booleanValue() && !HomeWorkTroopSelectorFragment.this.F.equals(((TroopInfo) cVar.f296954a).troopuin)) {
                            arrayList.add(((TroopInfo) cVar.f296954a).troopname);
                            arrayList2.add(((TroopInfo) cVar.f296954a).troopuin);
                        }
                    }
                }
                Intent intent = new Intent();
                intent.putStringArrayListExtra("HomeWorkConstants:homework_async_uin_list_key", arrayList2);
                intent.putStringArrayListExtra("HomeWorkConstants:homework_async_name_list_key", arrayList);
                HomeWorkTroopSelectorFragment.this.getActivity().setResult(262, intent);
                HomeWorkTroopSelectorFragment.this.getQBaseActivity().doOnBackPressed();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class b extends BaseAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private Activity f296945d;

        /* renamed from: e, reason: collision with root package name */
        List<c<TroopInfo, Boolean>> f296946e;

        /* renamed from: f, reason: collision with root package name */
        private String f296947f;

        /* compiled from: P */
        /* loaded from: classes19.dex */
        class a implements CompoundButton.OnCheckedChangeListener {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ c f296948d;

            a(c cVar) {
                this.f296948d = cVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this, (Object) cVar);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r1v2, types: [S, java.lang.Boolean] */
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, compoundButton, Boolean.valueOf(z16));
                } else if (compoundButton.isEnabled() && !((TroopInfo) this.f296948d.f296954a).troopuin.equals(b.this.f296947f)) {
                    this.f296948d.f296955b = Boolean.valueOf(z16);
                }
                EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
            }
        }

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.troop.homework.entry.ui.HomeWorkTroopSelectorFragment$b$b, reason: collision with other inner class name */
        /* loaded from: classes19.dex */
        class ViewOnClickListenerC8736b implements View.OnClickListener {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ CheckBox f296950d;

            ViewOnClickListenerC8736b(CheckBox checkBox) {
                this.f296950d = checkBox;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this, (Object) checkBox);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                } else {
                    this.f296950d.setChecked(!r0.isChecked());
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }

        /* compiled from: P */
        /* loaded from: classes19.dex */
        static class c {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            CheckBox f296952a;

            /* renamed from: b, reason: collision with root package name */
            TextView f296953b;

            c() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }
        }

        b(Activity activity, List<TroopInfo> list, TroopInfo troopInfo, List<String> list2) {
            String str;
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, activity, list, troopInfo, list2);
                return;
            }
            this.f296945d = activity;
            ArrayList arrayList = new ArrayList();
            this.f296946e = arrayList;
            if (troopInfo != null) {
                arrayList.add(new c(troopInfo, Boolean.TRUE));
                String str2 = troopInfo.troopuin;
                this.f296947f = str2;
                if (str2 == null) {
                    this.f296947f = "";
                }
            }
            if (list != null) {
                for (TroopInfo troopInfo2 : list) {
                    if (troopInfo2 != null && (str = troopInfo2.troopuin) != null && !str.equals(this.f296947f)) {
                        if (list2 != null && list2.contains(troopInfo2.troopuin)) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        this.f296946e.add(new c<>(troopInfo2, Boolean.valueOf(z16)));
                    }
                }
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.f296946e.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return this.f296946e.get(i3);
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
        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            c cVar;
            View view2;
            View view3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                view2 = (View) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), view, viewGroup);
                view3 = view;
            } else {
                c cVar2 = (c) getItem(i3);
                if (view != null) {
                    cVar = (c) view.getTag();
                } else {
                    c cVar3 = new c();
                    LinearLayout linearLayout = new LinearLayout(this.f296945d);
                    linearLayout.setMinimumHeight(ScreenUtil.dip2px(48.0f));
                    linearLayout.setOrientation(0);
                    linearLayout.setGravity(16);
                    linearLayout.setBackground(ContextCompat.getDrawable(this.f296945d, R.drawable.qui_common_bg_bottom_light_bg));
                    CheckBox checkBox = new CheckBox(this.f296945d);
                    cVar3.f296952a = checkBox;
                    checkBox.setButtonDrawable(R.drawable.kcr);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.setMargins(ScreenUtil.dip2px(12.0f), 0, 0, 0);
                    cVar3.f296952a.setLayoutParams(layoutParams);
                    LinearLayout linearLayout2 = new LinearLayout(this.f296945d);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
                    layoutParams2.setMargins(ScreenUtil.dip2px(12.0f), 0, ScreenUtil.dip2px(12.0f), 0);
                    linearLayout2.setLayoutParams(layoutParams2);
                    linearLayout2.setOrientation(1);
                    TextView textView = new TextView(this.f296945d);
                    cVar3.f296953b = textView;
                    textView.setTextColor(this.f296945d.getColor(R.color.qui_common_text_primary));
                    cVar3.f296953b.setTextSize(1, 16.0f);
                    cVar3.f296953b.setGravity(16);
                    cVar3.f296953b.setMaxLines(2);
                    cVar3.f296953b.setEllipsize(TextUtils.TruncateAt.END);
                    LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, 0);
                    layoutParams3.weight = 1.0f;
                    cVar3.f296953b.setLayoutParams(layoutParams3);
                    View view4 = new View(this.f296945d);
                    view4.setBackground(ContextCompat.getDrawable(this.f296945d, R.drawable.qui_common_border_standard_bg));
                    view4.setLayoutParams(new LinearLayout.LayoutParams(-1, 2));
                    linearLayout2.addView(cVar3.f296953b);
                    linearLayout2.addView(view4);
                    linearLayout.addView(cVar3.f296952a);
                    linearLayout.addView(linearLayout2);
                    linearLayout.setClickable(true);
                    linearLayout.setTag(cVar3);
                    cVar = cVar3;
                    view = linearLayout;
                }
                view.setOnClickListener(null);
                cVar.f296952a.setOnCheckedChangeListener(null);
                cVar.f296952a.setChecked(((Boolean) cVar2.f296955b).booleanValue());
                cVar.f296952a.setEnabled(true ^ ((TroopInfo) cVar2.f296954a).troopuin.equals(this.f296947f));
                cVar.f296952a.setOnCheckedChangeListener(new a(cVar2));
                view.setOnClickListener(new ViewOnClickListenerC8736b(cVar.f296952a));
                cVar.f296953b.setText(((TroopInfo) cVar2.f296954a).troopname);
                view2 = view;
                view3 = view2;
            }
            EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
            return view2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class c<F, S> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public F f296954a;

        /* renamed from: b, reason: collision with root package name */
        public S f296955b;

        c(F f16, S s16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) f16, (Object) s16);
            } else {
                this.f296954a = f16;
                this.f296955b = s16;
            }
        }
    }

    public HomeWorkTroopSelectorFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.F = "";
        this.G = null;
        this.H = null;
        this.I = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void th(List<TroopInfo> list) {
        if (this.C != null) {
            b bVar = new b(getActivity(), list, this.H, this.G);
            this.I = bVar;
            this.C.setAdapter((ListAdapter) bVar);
        }
    }

    public static void uh(Activity activity, String str, ArrayList<String> arrayList) {
        Intent intent = new Intent();
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("HomeWorkTroopSelectorFragment:my_troop_uin", str);
        }
        if (arrayList != null) {
            intent.putExtra("HomeWorkTroopSelectorFragment:select_troop_uin", arrayList);
        }
        QPublicFragmentActivity.startForResult(activity, intent, (Class<? extends QPublicBaseFragment>) HomeWorkTroopSelectorFragment.class, 263);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        AppInterface appInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, layoutInflater, viewGroup, bundle);
            return;
        }
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        ListView listView = (ListView) ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.d77);
        this.C = listView;
        listView.setDivider(null);
        this.C.setDividerHeight(0);
        if (getActivity() == null) {
            appInterface = null;
        } else {
            appInterface = (AppInterface) getQBaseActivity().getAppRuntime();
        }
        this.D = appInterface;
        if (appInterface == null) {
            getActivity().finish();
            return;
        }
        this.E = true;
        setRightButton(R.string.enn, new a());
        setTitle(HardCodeUtil.qqStr(R.string.n98));
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("HomeWorkTroopSelectorFragment:my_troop_uin");
            this.F = string;
            if (string == null) {
                this.F = "";
            }
            ArrayList<String> stringArrayList = arguments.getStringArrayList("HomeWorkTroopSelectorFragment:select_troop_uin");
            this.G = stringArrayList;
            if (stringArrayList == null) {
                this.G = new ArrayList();
            }
        }
        ThreadManagerV2.postImmediately(this, null, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return R.layout.aix;
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        this.E = false;
        return super.onBackEvent();
    }

    @Override // java.lang.Runnable
    public void run() {
        List<TroopInfo> joinedTroopInfoFromCache;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (this.D != null && (joinedTroopInfoFromCache = ((ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class)).getJoinedTroopInfoFromCache()) != null) {
            if (this.F == null) {
                this.F = "";
            }
            if (!TextUtils.isEmpty(this.F)) {
                this.H = ((ITroopListRepoApi) QRoute.api(ITroopListRepoApi.class)).getTroopInfoFromCache(this.F);
            }
            LinkedList linkedList = new LinkedList();
            for (TroopInfo troopInfo : joinedTroopInfoFromCache) {
                if (troopInfo.isOwnerOrAdmin()) {
                    linkedList.add(troopInfo);
                }
            }
            ThreadManager.getUIHandler().post(new Runnable(linkedList) { // from class: com.tencent.mobileqq.troop.homework.entry.ui.HomeWorkTroopSelectorFragment.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ List f296943d;

                {
                    this.f296943d = linkedList;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HomeWorkTroopSelectorFragment.this, (Object) linkedList);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (HomeWorkTroopSelectorFragment.this.E) {
                        HomeWorkTroopSelectorFragment.this.th(this.f296943d);
                    }
                }
            });
        }
    }
}
