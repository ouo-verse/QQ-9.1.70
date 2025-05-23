package com.tencent.mobileqq.now;

import ac2.c;
import ac2.d;
import ac2.e;
import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import cc2.b;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetailActivity;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.now.netchannel.websso.c;
import com.tencent.mobileqq.now.recommend.NoRecommendDataEvent;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDKManager;
import com.tencent.mobileqq.qqlive.api.config.QQLiveSDKConfigHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.o;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.timi.game.api.cookie.QQLiveCookieConstants;
import com.tencent.widget.ThemeImageWrapper;
import cooperation.qqfav.QfavUtil;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes9.dex */
public class NowQQLiveFragment extends PublicBaseFragment implements c.b, SimpleEventReceiver, c.d {
    private String C;
    private View D;
    private RecyclerView E;
    private qb2.c F;
    private ac2.c G;
    private NavBarAIO H;
    private boolean I;
    private Dialog J;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements com.tencent.mobileqq.widget.navbar.a {
        a() {
        }

        @Override // com.tencent.mobileqq.widget.navbar.a
        public void onItemSelect(View view, int i3) {
            if (4 == i3) {
                ActivityURIRequest activityURIRequest = new ActivityURIRequest(NowQQLiveFragment.this.getBaseActivity(), IPublicAccountDetailActivity.ROUTE_NAME);
                activityURIRequest.extra().putString("uin", qb2.a.f428781a);
                QRoute.startUri(activityURIRequest, (o) null);
                return;
            }
            if (5 == i3) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                intent.setComponent(new ComponentName(NowQQLiveFragment.this.getBaseActivity(), (Class<?>) ChatActivity.class));
                bundle.putString("uin", qb2.a.f428781a);
                bundle.putInt("uintype", 1008);
                bundle.putString("uinname", HardCodeUtil.qqStr(R.string.f171702og));
                intent.putExtras(bundle);
                intent.setFlags(67108864);
                intent.putExtra("isforceRequestDetail", false);
                intent.putExtra("jump_from", 2);
                NowQQLiveFragment.this.getBaseActivity().startActivity(intent);
                bc2.a.f();
                bc2.a.g();
                return;
            }
            if (1 == i3) {
                NowQQLiveFragment.this.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish() {
        com.tencent.mobileqq.now.netchannel.websso.c.d().h();
        if (getBaseActivity() != null) {
            getBaseActivity().finish();
        }
    }

    private void initData() {
        CookieManager.getInstance().setCookie("fastest.now.qq.com", "__client_type=16130");
        CookieManager.getInstance().setCookie(QQLiveCookieConstants.NOW_DOMAIN, "__client_type=16130");
        com.tencent.mobileqq.now.netchannel.websso.c.d().f(this);
    }

    private void initView(View view) {
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, 1);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.i4m);
        this.E = recyclerView;
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        if (getBaseActivity() != null && !getBaseActivity().isFinishing()) {
            this.E.addItemDecoration(new e(getBaseActivity().getResources().getDimensionPixelSize(R.dimen.dbu)));
        }
        qb2.c cVar = new qb2.c(getBaseActivity(), this.E, this.G.f());
        this.F = cVar;
        this.E.setAdapter(cVar);
        rh();
        th(view);
    }

    private void qh() {
        if (NetworkUtil.isNetworkAvailable()) {
            Dialog dialog = this.J;
            if (dialog != null && dialog.isShowing()) {
                this.J.dismiss();
                return;
            }
            return;
        }
        if (this.J == null) {
            this.J = DialogUtil.createContentClickableDialog(getBaseActivity(), null, getBaseActivity().getString(R.string.f171722oi), 0, R.string.f171732oj, null, null, null);
        }
        if (!this.J.isShowing()) {
            this.J.show();
        }
    }

    private IPublicAccountDetail sh() {
        IPublicAccountDataManager iPublicAccountDataManager;
        AppInterface b16 = com.tencent.mobileqq.now.netchannel.websso.e.b();
        if (b16 != null && (iPublicAccountDataManager = (IPublicAccountDataManager) b16.getRuntimeService(IPublicAccountDataManager.class, "all")) != null) {
            return iPublicAccountDataManager.findAccountDetailInfo(qb2.a.f428781a);
        }
        return null;
    }

    private void th(View view) {
        String qqStr;
        NavBarAIO navBarAIO = (NavBarAIO) view.findViewById(R.id.zv9);
        this.H = navBarAIO;
        if (navBarAIO == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) navBarAIO.getLayoutParams();
        layoutParams.setMargins(0, b.a(getBaseActivity()), 0, 0);
        this.H.setLayoutParams(layoutParams);
        View findViewById = this.H.findViewById(R.id.ivTitleBtnLeft);
        if (findViewById != null) {
            if (ThemeImageWrapper.isNightMode()) {
                findViewById.setBackgroundResource(R.drawable.b5b);
                this.H.setRight1Icon(R.drawable.skin_header_icon_single_aio_detheme_sel);
                this.H.setRight2Icon(R.drawable.n49);
            } else {
                findViewById.setBackgroundResource(R.drawable.hij);
                this.H.setRight1Icon(R.drawable.crg);
                this.H.setRight2Icon(R.drawable.n48);
            }
        }
        int c16 = qb2.b.c();
        if (c16 > 0) {
            TextView textView = (TextView) this.H.findViewById(R.id.dt6);
            textView.setText(String.valueOf(c16));
            textView.setVisibility(0);
            qb2.b.a();
        }
        View findViewById2 = this.H.findViewById(R.id.f165972dz1);
        if (findViewById2 != null) {
            findViewById2.setVisibility(8);
        }
        View findViewById3 = this.H.findViewById(R.id.j65);
        if (findViewById3 != null) {
            findViewById3.setVisibility(8);
        }
        TextView textView2 = (TextView) this.H.findViewById(R.id.title);
        if (textView2 != null) {
            IPublicAccountDetail sh5 = sh();
            if (sh5 != null && !TextUtils.isEmpty(sh5.getName())) {
                qqStr = sh5.getName();
            } else {
                qqStr = HardCodeUtil.qqStr(R.string.f171712oh);
            }
            textView2.setText(qqStr);
        }
        this.H.setOnSelectListener(new a());
    }

    private void uh() {
        if (this.I == b.b()) {
            return;
        }
        this.I = b.b();
        this.H.onPostThemeChanged();
        if (this.I) {
            b.e(getBaseActivity(), true);
            View findViewById = this.H.findViewById(R.id.ivTitleBtnLeft);
            if (findViewById != null) {
                findViewById.setBackgroundResource(R.drawable.b5b);
            }
            TextView textView = (TextView) this.H.findViewById(R.id.title);
            if (textView != null) {
                textView.setTextColor(-1);
                return;
            }
            return;
        }
        b.e(getBaseActivity(), false);
        View findViewById2 = this.H.findViewById(R.id.ivTitleBtnLeft);
        if (findViewById2 != null) {
            findViewById2.setBackgroundResource(R.drawable.hij);
        }
        TextView textView2 = (TextView) this.H.findViewById(R.id.title);
        if (textView2 != null) {
            textView2.setTextColor(-16777216);
        }
        if (!QQTheme.isCustomTheme(MobileQQ.sMobileQQ.waitAppRuntime(null).getCurrentUin(), false)) {
            this.H.setBackgroundColor(-1);
        }
    }

    public static final void vh(Context context, String str, int i3) {
        Intent intent = new Intent(context, (Class<?>) PublicFragmentActivity.class);
        intent.putExtra("public_account_uin", str);
        intent.putExtra("public_account_source", i3);
        intent.addFlags(67108864);
        PublicFragmentActivity.b.a(context, intent, PublicFragmentActivity.class, NowQQLiveFragment.class);
    }

    @Override // com.tencent.mobileqq.now.netchannel.websso.c.d
    public void c3(int i3, String str) {
        vb2.b.c().e();
        this.G.j(0, this, false);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(NoRecommendDataEvent.class);
        return arrayList;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        super.initWindowStyleAndAnimation(activity);
        activity.getWindow().setSoftInputMode(17);
        activity.overridePendingTransition(R.anim.f154427o, R.anim.f154429q);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getBaseActivity().getIntent();
        this.C = intent.getStringExtra("public_account_uin");
        this.G = new ac2.c();
        this.I = !b.b();
        qh();
        bc2.a.a(String.valueOf(intent.getIntExtra("public_account_source", 1)));
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view;
        initData();
        View inflate = layoutInflater.inflate(R.layout.fpg, viewGroup, false);
        this.D = inflate;
        initView(inflate);
        if (getBaseActivity() == null) {
            QLog.e("NowQQLiveFragment", 1, "activity is null");
            view = this.D;
        } else if (getArguments() == null) {
            QLog.e("NowQQLiveFragment", 1, "argsBundle is null");
            view = this.D;
        } else {
            SimpleEventBus.getInstance().registerReceiver(this);
            view = this.D;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        vb2.b.c().d();
        URLDrawable.clearMemoryCache();
        ((IQQLiveSDKManager) QRoute.api(IQQLiveSDKManager.class)).destroySDKImpl(QQLiveSDKConfigHelper.getQQLiveAppId());
        qb2.c cVar = this.F;
        if (cVar != null) {
            cVar.onDestroy();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // ac2.c.b
    public void onFailed() {
        this.F.t(2);
        this.F.notifyDataSetChanged();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        ac2.c cVar;
        if (getBaseActivity() != null && !NetworkUtil.isNetworkAvailable(getBaseActivity().getApplication())) {
            QfavUtil.Q(getBaseActivity(), R.string.f170702lr, 1);
            onFailed();
        } else {
            if (com.tencent.mobileqq.now.netchannel.websso.c.d().e()) {
                if ((simpleBaseEvent instanceof NoRecommendDataEvent) && (cVar = this.G) != null) {
                    cVar.j(0, this, false);
                    return;
                }
                return;
            }
            com.tencent.mobileqq.now.netchannel.websso.c.d().f(this);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.F.onResume();
        this.G.g(this);
        vb2.b.c().e();
        uh();
    }

    @Override // ac2.c.b
    public void onSuccess(List<d> list) {
        this.F.t(1);
        this.F.notifyDataSetChanged();
    }

    public void rh() {
        this.E.getItemAnimator().setAddDuration(0L);
        this.E.getItemAnimator().setChangeDuration(0L);
        this.E.getItemAnimator().setMoveDuration(0L);
        this.E.getItemAnimator().setRemoveDuration(0L);
        if (this.E.getItemAnimator() instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) this.E.getItemAnimator()).setSupportsChangeAnimations(false);
        }
    }
}
