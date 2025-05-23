package com.tencent.mobileqq.activity.contact.troop;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.contact.troop.BaseTroopView;
import com.tencent.mobileqq.adapter.i;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.search.activity.ContactSearchComponentActivity;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes10.dex */
public class DiscussionView extends BaseTroopView implements View.OnClickListener, SlideDetectListView.c, OverScrollViewListener, i.d, AbsListView.OnScrollListener {
    static IPatchRedirector $redirector_;
    View F;
    Button G;
    protected SlideDetectListView H;
    private PullRefreshHeader I;
    protected i J;
    boolean K;
    private a L;
    private TextView M;
    int N;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a extends com.tencent.mobileqq.discussion.observer.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DiscussionView.this);
            }
        }

        @Override // com.tencent.mobileqq.discussion.observer.a
        protected void f(boolean z16, int i3, long j3, ArrayList<String> arrayList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Integer.valueOf(i3), Long.valueOf(j3), arrayList);
            } else if (z16) {
                DiscussionView.this.J.notifyDataSetChanged();
            }
        }

        @Override // com.tencent.mobileqq.discussion.observer.a
        protected void g(boolean z16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(z16), str);
            } else if (z16) {
                DiscussionView.this.J.notifyDataSetChanged();
            }
        }

        @Override // com.tencent.mobileqq.discussion.observer.a
        protected void h(boolean z16, Long l3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                iPatchRedirector.redirect((short) 12, this, Boolean.valueOf(z16), l3);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("DiscussionView", 2, "onUncollectDiscussion isSuccess:" + z16 + " uin:" + l3);
            }
            DiscussionView.this.J.notifyDataSetChanged();
        }

        @Override // com.tencent.mobileqq.discussion.observer.a
        protected void i(boolean z16, int i3, long j3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), Integer.valueOf(i3), Long.valueOf(j3), str);
            } else if (z16) {
                DiscussionView.this.J.notifyDataSetChanged();
            }
        }

        @Override // com.tencent.mobileqq.discussion.observer.a
        protected void k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this);
            } else {
                DiscussionView.this.J.notifyDataSetChanged();
            }
        }

        @Override // com.tencent.mobileqq.discussion.observer.a
        protected void q(boolean z16, Long l3, Long l16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, this, Boolean.valueOf(z16), l3, l16);
            } else {
                DiscussionView.this.J.notifyDataSetChanged();
            }
        }

        @Override // com.tencent.mobileqq.discussion.observer.a
        protected void r(boolean z16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), str);
            } else if (z16) {
                DiscussionView.this.J.notifyDataSetChanged();
            }
        }

        @Override // com.tencent.mobileqq.discussion.observer.a
        protected void s(boolean z16, Long l3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                iPatchRedirector.redirect((short) 13, this, Boolean.valueOf(z16), l3);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("DiscussionView", 2, "onUncollectDiscussion isSuccess:" + z16 + " uin:" + l3);
            }
            DiscussionView.this.J.notifyDataSetChanged();
        }

        @Override // com.tencent.mobileqq.discussion.observer.a
        protected void t() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this);
            } else {
                DiscussionView.this.J.notifyDataSetChanged();
            }
        }

        @Override // com.tencent.mobileqq.discussion.observer.a
        protected void v(boolean z16, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, this, Boolean.valueOf(z16), Long.valueOf(j3));
            } else if (z16) {
                DiscussionView.this.J.notifyDataSetChanged();
            }
        }

        @Override // com.tencent.mobileqq.discussion.observer.a
        protected void w(boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), obj);
            } else if (z16) {
                DiscussionView.this.J.notifyDataSetChanged();
            }
        }

        @Override // com.tencent.mobileqq.discussion.observer.a
        protected void x(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
                return;
            }
            if (z16) {
                DiscussionView.this.B();
            }
            DiscussionView.this.J.notifyDataSetChanged();
            DiscussionView discussionView = DiscussionView.this;
            if (discussionView.K) {
                discussionView.K = false;
                if (z16) {
                    discussionView.I.l(0);
                    DiscussionView.this.p(100, 800L);
                } else {
                    discussionView.H.springBackOverScrollHeaderView();
                    DiscussionView.this.r(R.string.hqe);
                }
            }
        }
    }

    public DiscussionView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
        } else {
            this.K = false;
            this.L = new a();
        }
    }

    private void C(int i3) {
        i iVar;
        int i16;
        View childAt;
        if (f() != null && (iVar = this.J) != null) {
            if (i3 == 0) {
                this.M.setVisibility(4);
                return;
            }
            if (i3 >= 0 && i3 < iVar.getCount()) {
                Object item = this.J.getItem(0);
                if (item instanceof Integer) {
                    i16 = ((Integer) item).intValue();
                } else {
                    i16 = 0;
                }
                int i17 = R.string.cdr;
                if (i16 != 0 && i3 <= i16 + 1) {
                    i17 = R.string.f171131ce2;
                }
                this.M.setVisibility(0);
                this.M.setText(i17);
                if (this.J.getItem(i3) instanceof Integer) {
                    if (i3 < this.J.getCount() && (childAt = this.H.getChildAt(0)) != null) {
                        int bottom = childAt.getBottom();
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.M.getLayoutParams();
                        int i18 = this.N;
                        if (bottom < i18) {
                            layoutParams.topMargin = bottom - i18;
                        } else {
                            layoutParams.topMargin = 0;
                        }
                        this.M.setLayoutParams(layoutParams);
                        this.M.requestLayout();
                        return;
                    }
                    return;
                }
                if (i3 < this.J.getCount()) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.M.getLayoutParams();
                    if (layoutParams2.topMargin != 0) {
                        layoutParams2.topMargin = 0;
                        this.M.setLayoutParams(layoutParams2);
                        this.M.requestLayout();
                        return;
                    }
                    return;
                }
                return;
            }
            this.M.setVisibility(4);
        }
    }

    private void D(String str, String str2) {
        com.tencent.qqperf.opt.threadpriority.b.k(true);
        Intent m3 = BaseAIOUtils.m(SplashActivity.getAliasIntent(f()), null);
        m3.putExtra("uin", str);
        m3.putExtra("uintype", 3000);
        m3.putExtra("uinname", str2);
        t(m3);
    }

    private void w() {
        Intent intent = new Intent();
        intent.putExtra("param_type", 3000);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_SUBTYPE, 0);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_FROM, 1002);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_MIN, 2);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_MAX, 99);
        intent.putExtra(ISelectMemberActivityConstants.MULTICHAT, true);
        ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).startSelectMemberActivityForResult(this.f181328d.getActivity(), intent, 1300);
        ReportController.o(this.f181329e, "CliOper", "", "", "Contacts_tab", "Contacts_tab_creat_discuss", 0, 0, "", "", "", "");
    }

    private long x() {
        return f().getSharedPreferences("rec_last_discussion_list_refresh_time", 0).getLong("rec_last_discussion_list_refresh_time", 0L);
    }

    private void y() {
        View findViewById = findViewById(R.id.bwp);
        this.F = findViewById;
        this.G = (Button) findViewById.findViewById(R.id.bbl);
        this.F.setVisibility(8);
        this.M = (TextView) findViewById(R.id.k1f);
        this.N = getResources().getDimensionPixelSize(R.dimen.f159607b14);
        SlideDetectListView slideDetectListView = (SlideDetectListView) findViewById(R.id.lv_discussion);
        this.H = slideDetectListView;
        slideDetectListView.setNeedCheckSpringback(true);
        LayoutInflater from = LayoutInflater.from(f());
        View inflate = from.inflate(R.layout.search_box, (ViewGroup) this.H, false);
        inflate.findViewById(R.id.btn_cancel_search).setVisibility(8);
        EditText editText = (EditText) inflate.findViewById(R.id.et_search_keyword);
        editText.setFocusableInTouchMode(false);
        editText.setOnClickListener(this);
        editText.setCursorVisible(false);
        this.H.addHeaderView(inflate);
        this.H.setContentBackground(R.drawable.bg_texture);
        this.H.setEmptyView(this.F);
        this.H.setVisibility(8);
        PullRefreshHeader pullRefreshHeader = (PullRefreshHeader) from.inflate(R.layout.f168433w5, (ViewGroup) this.H, false);
        this.I = pullRefreshHeader;
        this.H.setOverScrollHeader(pullRefreshHeader);
        this.H.setOverScrollListener(this);
        this.H.setOnScrollGroupFloatingListener(this);
        this.G.setOnClickListener(this);
        if (!this.f181328d.d()) {
            this.H.setOnSlideListener(this);
        }
    }

    protected void A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        i iVar = new i(f(), this, this.H, this.f181329e, false);
        this.J = iVar;
        this.H.setAdapter((ListAdapter) iVar);
        e(this.L);
    }

    void B() {
        f().getSharedPreferences("rec_last_discussion_list_refresh_time", 0).edit().putLong("rec_last_discussion_list_refresh_time", System.currentTimeMillis()).commit();
    }

    protected boolean E() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (NetworkUtil.isNetworkAvailable(f())) {
            this.K = true;
            ((DiscussionHandler) this.f181329e.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).R2(Long.valueOf(this.f181329e.getCurrentAccountUin()).longValue());
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.adapter.i.d
    public void a(DiscussionInfo discussionInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) discussionInfo);
            return;
        }
        int i3 = 1;
        if (this.f181328d.d()) {
            ForwardBaseOption f16 = this.f181328d.f();
            if (f16 != null) {
                Bundle bundle = new Bundle();
                bundle.putString("uin", discussionInfo.uin);
                bundle.putInt("uintype", 3000);
                bundle.putString("uinname", ForwardUtils.r(this.f181329e, discussionInfo.discussionName, discussionInfo.uin));
                bundle.putBoolean("forward_report_confirm", true);
                bundle.putString("forward_report_confirm_action_name", "0X8005A12");
                f16.buildForwardDialog(com.tencent.mobileqq.forward.e.Q3.intValue(), bundle);
            }
            String str = "";
            try {
                long longExtra = this.f181328d.getActivity().getIntent().getLongExtra("req_share_id", 0L);
                if (longExtra > 0) {
                    str = String.valueOf(longExtra);
                }
            } catch (Exception unused) {
            }
            ReportCenter.f().p(this.f181329e.getAccount(), "", str, "1000", "32", "0", false);
            return;
        }
        D(discussionInfo.uin, discussionInfo.discussionName);
        QQAppInterface qQAppInterface = this.f181329e;
        if (!discussionInfo.hasCollect) {
            i3 = 2;
        }
        ReportController.o(qQAppInterface, "CliOper", "", "", "0X8006666", "0X8006666", i3, 0, "", "", "", "");
    }

    @Override // com.tencent.mobileqq.widget.SlideDetectListView.c
    public void c(SlideDetectListView slideDetectListView, View view, int i3) {
        ShaderAnimLayout shaderAnimLayout;
        Button button;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, slideDetectListView, view, Integer.valueOf(i3));
            return;
        }
        DiscussionInfo d16 = this.J.d(i3);
        if (d16 == null || (shaderAnimLayout = (ShaderAnimLayout) view.findViewById(R.id.blq)) == null || (button = (Button) shaderAnimLayout.findViewById(R.id.blp)) == null) {
            return;
        }
        slideDetectListView.setDeleteAreaWidth(shaderAnimLayout.getLayoutParams().width);
        Activity f16 = f();
        if (!d16.hasCollect) {
            i16 = R.string.dsq;
        } else {
            i16 = R.string.dsm;
        }
        String string = f16.getString(i16);
        button.setText(string);
        button.setVisibility(0);
        button.setTag(d16);
        if (AppSetting.f99565y) {
            button.setContentDescription(string);
        }
        shaderAnimLayout.f();
    }

    @Override // com.tencent.mobileqq.widget.SlideDetectListView.c
    public void d(SlideDetectListView slideDetectListView, View view, int i3) {
        ShaderAnimLayout shaderAnimLayout;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, slideDetectListView, view, Integer.valueOf(i3));
            return;
        }
        if (this.J.d(i3) != null && (shaderAnimLayout = (ShaderAnimLayout) view.findViewById(R.id.blq)) != null) {
            shaderAnimLayout.a();
            Button button = (Button) shaderAnimLayout.findViewById(R.id.blp);
            if (button != null) {
                button.setTag(null);
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.contact.troop.BaseTroopView
    public boolean g(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 != 100) {
            if (i3 == 102) {
                this.H.springBackOverScrollHeaderView();
                r(R.string.hqe);
                return true;
            }
            return true;
        }
        this.H.springBackOverScrollHeaderView();
        return true;
    }

    @Override // com.tencent.mobileqq.activity.contact.troop.BaseTroopView
    public void i(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        if (i16 == -1 && i3 == 21007 && intent != null) {
            if (this.f181328d.d()) {
                SearchUtil.h(intent, this.f181328d.f());
            } else {
                D(intent.getStringExtra("contactSearchResultTroopUin"), intent.getStringExtra("contactSearchResultName"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.contact.troop.BaseTroopView
    public void k(Intent intent, BaseTroopView.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) intent, (Object) aVar);
            return;
        }
        super.k(intent, aVar);
        q(R.layout.a1m);
        y();
        A();
        if (this.f181328d.d()) {
            this.E = 7;
        } else {
            this.E = 2;
        }
    }

    @Override // com.tencent.mobileqq.activity.contact.troop.BaseTroopView
    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.l();
        i iVar = this.J;
        if (iVar != null) {
            iVar.G = false;
        }
    }

    @Override // com.tencent.mobileqq.activity.contact.troop.BaseTroopView
    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        i iVar = this.J;
        if (iVar != null) {
            iVar.G = true;
            iVar.notifyDataSetChanged();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.et_search_keyword) {
                z();
                ReportController.o(this.f181329e, "CliOper", "", "", "0X8006665", "0X8006665", 0, 0, "", "", "", "");
            } else if (id5 == R.id.bbl) {
                w();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.contact.troop.BaseTroopView
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        super.onDestroy();
        o(this.L);
        i iVar = this.J;
        if (iVar != null) {
            iVar.c();
        }
    }

    @Override // com.tencent.widget.OverScrollViewListener
    public void onNotCompleteVisable(int i3, View view, ListView listView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), view, listView);
        } else {
            this.I.i(x());
        }
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, absListView, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        } else if (this.J != null) {
            C(i3);
        }
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) absListView, i3);
        }
    }

    @Override // com.tencent.widget.OverScrollViewListener
    public void onViewCompleteVisable(int i3, View view, ListView listView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), view, listView);
        } else {
            this.I.d(x());
        }
    }

    @Override // com.tencent.widget.OverScrollViewListener
    public boolean onViewCompleteVisableAndReleased(int i3, View view, ListView listView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), view, listView)).booleanValue();
        }
        this.I.h(x());
        if (!E()) {
            p(102, 1000L);
        }
        return true;
    }

    @Override // com.tencent.widget.OverScrollViewListener
    public void onViewNotCompleteVisableAndReleased(int i3, View view, ListView listView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), view, listView);
        }
    }

    public void z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else {
            ContactSearchComponentActivity.V2(f(), null, 5, 8, 21007);
        }
    }
}
