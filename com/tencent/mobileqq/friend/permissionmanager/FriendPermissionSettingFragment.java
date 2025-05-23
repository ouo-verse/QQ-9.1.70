package com.tencent.mobileqq.friend.permissionmanager;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.abtest.api.IAddFriendTabApi;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.friend.api.IFriendHandlerService;
import com.tencent.mobileqq.friend.permissionmanager.FriendPermissionAdapter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.util.LoadingUtil;
import com.tencent.util.QQToastUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes33.dex */
public class FriendPermissionSettingFragment extends QIphoneTitleBarFragment implements View.OnClickListener {
    private QQAppInterface D;
    private Context E;
    private Intent F;
    private XListView G;
    private Button H;
    private ActionSheet I;
    private IFriendHandlerService J;
    private FriendPermissionAdapter K;
    private Dialog L;
    int C = -1;
    FriendPermissionAdapter.c M = new a();
    com.tencent.mobileqq.friend.observer.a N = new b();

    /* loaded from: classes33.dex */
    class a implements FriendPermissionAdapter.c {
        a() {
        }

        @Override // com.tencent.mobileqq.friend.permissionmanager.FriendPermissionAdapter.c
        public void a() {
            FriendPermissionSettingFragment.this.yh();
        }
    }

    /* loaded from: classes33.dex */
    class b extends com.tencent.mobileqq.friend.observer.a {
        b() {
        }

        @Override // com.tencent.mobileqq.friend.observer.a
        protected void onUpdateSetFriendPermission(boolean z16, HashMap<String, Integer> hashMap, int i3) {
            FriendPermissionSettingFragment.this.dismissProgressDialog();
            if (z16 && hashMap != null && hashMap.size() != 0) {
                HashSet<String> q16 = FriendPermissionSettingFragment.this.K.q();
                ConcurrentHashMap<String, Integer> p16 = FriendPermissionSettingFragment.this.K.p();
                Iterator<String> it = q16.iterator();
                int i16 = 0;
                while (it.hasNext()) {
                    String next = it.next();
                    Integer num = 0;
                    if (num.equals(hashMap.get(next))) {
                        it.remove();
                        p16.put(next, Integer.valueOf(i3));
                    } else {
                        i16++;
                    }
                }
                if (i16 > 0) {
                    QQToast.makeText(FriendPermissionSettingFragment.this.getQBaseActivity(), 1, String.format(FriendPermissionSettingFragment.this.getQBaseActivity().getString(R.string.f225476lq), Integer.valueOf(i16)), 1);
                } else {
                    QQToastUtil.showQQToast(2, R.string.f225496ls);
                }
                FriendPermissionSettingFragment.this.K.notifyDataSetChanged();
                FriendPermissionSettingFragment.this.yh();
                return;
            }
            QQToastUtil.showQQToast(1, R.string.f225466lp);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            FriendPermissionSettingFragment.this.I.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissProgressDialog() {
        Dialog dialog = this.L;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.L.dismiss();
    }

    private <T extends View> T findViewById(int i3) {
        return (T) ((QIphoneTitleBarFragment) this).mContentView.findViewById(i3);
    }

    private void initView() {
        Context context;
        Context context2 = this.E;
        if (context2 != null) {
            setTitle(context2.getString(R.string.f225366lf));
        } else {
            setTitle("");
        }
        setLeftButton(R.string.f225376lg, (View.OnClickListener) null);
        TextView textView = this.leftViewNotBack;
        if (textView != null && (context = this.E) != null) {
            textView.setTextColor(context.getColorStateList(R.color.qui_common_text_nav_secondary_selector));
        }
        this.G = (XListView) findViewById(R.id.cny);
        FriendPermissionAdapter friendPermissionAdapter = new FriendPermissionAdapter(this.E, this.D, this.G, this.C, this.M, this.J);
        this.K = friendPermissionAdapter;
        this.G.setAdapter((ListAdapter) friendPermissionAdapter);
        Button button = (Button) findViewById(R.id.td5);
        this.H = button;
        button.setOnClickListener(this);
        yh();
        Context context3 = this.E;
        if (context3 != null) {
            this.L = LoadingUtil.createLoadingDialog(context3, context3.getString(R.string.f225456lo), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showProgressDialog() {
        Dialog dialog = this.L;
        if (dialog == null || dialog.isShowing()) {
            return;
        }
        this.L.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> xh(HashSet<String> hashSet) {
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = hashSet.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yh() {
        String format;
        int size = this.K.q().size();
        this.H.setEnabled(size > 0);
        Button button = this.H;
        if (size > 0) {
            format = String.format(this.E.getString(R.string.f225426ll), Integer.valueOf(size));
        } else {
            format = String.format(this.E.getString(R.string.f225436lm), new Object[0]);
        }
        button.setText(format);
    }

    private void zh() {
        this.I = (ActionSheet) ActionSheetHelper.createDialog(this.E, null);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        FrameLayout createPermissionSwitchForContacts = ((IAddFriendTabApi) QRoute.api(IAddFriendTabApi.class)).createPermissionSwitchForContacts(getContext());
        createPermissionSwitchForContacts.setLayoutParams(layoutParams);
        View inflate = LayoutInflater.from(this.E).inflate(R.layout.ea5, (ViewGroup) null);
        inflate.setLayoutParams(layoutParams);
        this.I.addViewCustomeTitle(inflate);
        this.I.addView(createPermissionSwitchForContacts);
        TextView textView = (TextView) this.I.mContentContainer.findViewById(R.id.f237707b);
        TextView textView2 = (TextView) this.I.mContentContainer.findViewById(R.id.f237807c);
        textView.setOnClickListener(new c());
        textView2.setOnClickListener(new d(createPermissionSwitchForContacts));
        ActionSheet actionSheet = this.I;
        if (actionSheet == null || actionSheet.isShowing()) {
            return;
        }
        this.I.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        this.E = getQBaseActivity();
        Intent intent = getQBaseActivity().getIntent();
        this.F = intent;
        if (intent == null) {
            return;
        }
        this.C = intent.getIntExtra("groupId", -1);
        QQAppInterface qQAppInterface = (QQAppInterface) getQBaseActivity().getAppRuntime();
        this.D = qQAppInterface;
        this.J = (IFriendHandlerService) qQAppInterface.getRuntimeService(IFriendHandlerService.class, "");
        this.D.addObserver(this.N);
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.e46;
    }

    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        boolean onBackEvent = super.onBackEvent();
        getActivity().overridePendingTransition(R.anim.f154422j, R.anim.f154423k);
        return onBackEvent;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != R.id.td5) {
            return;
        }
        zh();
        ReportController.o(this.D, "dc00898", "", "", "0X800C110F", "0X800C11F", 0, 0, "", "", "", "");
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        this.K.destroy();
        this.D.removeObserver(this.N);
        Dialog dialog = this.L;
        if (dialog != null && dialog.isShowing()) {
            this.L.dismiss();
        }
        super.onDestroy();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        super.onFinish();
        try {
            getActivity().overridePendingTransition(R.anim.f154422j, R.anim.f154423k);
        } catch (NullPointerException e16) {
            com.tencent.xaction.log.b.a("FriendPermissionSetting", 2, "e:" + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes33.dex */
    public class d implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FrameLayout f211702d;

        d(FrameLayout frameLayout) {
            this.f211702d = frameLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!NetworkUtil.isNetSupport(FriendPermissionSettingFragment.this.getActivity())) {
                QQToastUtil.showQQToast(1, R.string.f171002mk);
                FriendPermissionSettingFragment.this.I.dismiss();
                return;
            }
            FriendPermissionSettingFragment friendPermissionSettingFragment = FriendPermissionSettingFragment.this;
            List<String> xh5 = friendPermissionSettingFragment.xh(friendPermissionSettingFragment.K.q());
            int switchResult = ((IAddFriendTabApi) QRoute.api(IAddFriendTabApi.class)).getSwitchResult(this.f211702d);
            int reportParam = ((IAddFriendTabApi) QRoute.api(IAddFriendTabApi.class)).getReportParam(this.f211702d);
            FriendPermissionSettingFragment.this.J.setBatchFriendPermission(xh5, switchResult);
            FriendPermissionSettingFragment.this.I.dismiss();
            FriendPermissionSettingFragment.this.showProgressDialog();
            ReportController.o(FriendPermissionSettingFragment.this.D, "dc00898", "", "", "0X800C124", "0X800C124", 0, reportParam, "", "", "", "");
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        activity.overridePendingTransition(R.anim.f154424l, R.anim.f154425m);
    }
}
