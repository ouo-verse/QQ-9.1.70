package com.tencent.mobileqq.activity.contact.troop;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.BaseForwardSelectionActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.activity.contact.troop.BaseTroopView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.troopcreate.api.ITroopCreateService;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.RedDotTextView;
import com.tencent.mobileqq.widget.TabBarView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.PopupMenuDialog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes10.dex */
public class TroopActivity extends BaseForwardSelectionActivity implements Handler.Callback, Observer {
    static IPatchRedirector $redirector_;

    /* renamed from: v0, reason: collision with root package name */
    protected static final int[] f181335v0;

    /* renamed from: w0, reason: collision with root package name */
    protected static final int[] f181336w0;

    /* renamed from: e0, reason: collision with root package name */
    public int f181337e0;

    /* renamed from: f0, reason: collision with root package name */
    public int f181338f0;

    /* renamed from: g0, reason: collision with root package name */
    protected BaseTroopView.a f181339g0;

    /* renamed from: h0, reason: collision with root package name */
    protected TabBarView f181340h0;

    /* renamed from: i0, reason: collision with root package name */
    protected FrameLayout f181341i0;

    /* renamed from: j0, reason: collision with root package name */
    ImageView f181342j0;

    /* renamed from: k0, reason: collision with root package name */
    TextView f181343k0;

    /* renamed from: l0, reason: collision with root package name */
    protected MqqWeakReferenceHandler f181344l0;

    /* renamed from: m0, reason: collision with root package name */
    ArrayList<BaseTroopView> f181345m0;

    /* renamed from: n0, reason: collision with root package name */
    protected boolean f181346n0;

    /* renamed from: o0, reason: collision with root package name */
    protected String f181347o0;

    /* renamed from: p0, reason: collision with root package name */
    boolean f181348p0;

    /* renamed from: q0, reason: collision with root package name */
    protected TabBarView.d f181349q0;

    /* renamed from: r0, reason: collision with root package name */
    protected BaseTroopView f181350r0;

    /* renamed from: s0, reason: collision with root package name */
    boolean f181351s0;

    /* renamed from: t0, reason: collision with root package name */
    protected PopupMenuDialog f181352t0;

    /* renamed from: u0, reason: collision with root package name */
    protected View.OnClickListener f181353u0;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    private static class GetUnReadNumRunnable implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private QQAppInterface f181364d;

        /* renamed from: e, reason: collision with root package name */
        private WeakReference<TroopActivity> f181365e;

        /* renamed from: f, reason: collision with root package name */
        private TextView f181366f;

        /* renamed from: h, reason: collision with root package name */
        private ImageView f181367h;

        public GetUnReadNumRunnable(QQAppInterface qQAppInterface, WeakReference<TroopActivity> weakReference, TextView textView, ImageView imageView) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, qQAppInterface, weakReference, textView, imageView);
                return;
            }
            this.f181364d = qQAppInterface;
            this.f181365e = weakReference;
            this.f181366f = textView;
            this.f181367h = imageView;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean e() {
            if (this.f181365e.get() != null && !this.f181365e.get().isFinishing() && this.f181367h != null && this.f181366f != null) {
                return true;
            }
            return false;
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            QQAppInterface qQAppInterface = this.f181364d;
            if (qQAppInterface != null) {
                ThreadManager.getUIHandler().post(new Runnable(qQAppInterface.getMessageFacade().H1()) { // from class: com.tencent.mobileqq.activity.contact.troop.TroopActivity.GetUnReadNumRunnable.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ int f181368d;

                    {
                        this.f181368d = r5;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GetUnReadNumRunnable.this, r5);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        if (GetUnReadNumRunnable.this.e()) {
                            GetUnReadNumRunnable.this.f181366f.setVisibility(0);
                            GetUnReadNumRunnable.this.f181367h.setVisibility(0);
                            GetUnReadNumRunnable.this.f181366f.setText("" + this.f181368d);
                            if (this.f181368d <= 0) {
                                GetUnReadNumRunnable.this.f181366f.setVisibility(4);
                            }
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements BaseTroopView.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.activity.contact.troop.BaseTroopView.a
        public View b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (View) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return TroopActivity.this.findViewById(R.id.idz);
        }

        @Override // com.tencent.mobileqq.activity.contact.troop.BaseTroopView.a
        public View c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (View) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return TroopActivity.this.f181340h0;
        }

        @Override // com.tencent.mobileqq.activity.contact.troop.BaseTroopView.a
        public boolean d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) {
                return ((BaseForwardSelectionActivity) TroopActivity.this).f175038c0;
            }
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }

        @Override // com.tencent.mobileqq.activity.contact.troop.BaseTroopView.a
        public boolean e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 15)) {
                return ((BaseForwardSelectionActivity) TroopActivity.this).f175037b0;
            }
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }

        @Override // com.tencent.mobileqq.activity.contact.troop.BaseTroopView.a
        public ForwardBaseOption f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) {
                return ((BaseForwardSelectionActivity) TroopActivity.this).f175036a0;
            }
            return (ForwardBaseOption) iPatchRedirector.redirect((short) 11, (Object) this);
        }

        @Override // com.tencent.mobileqq.activity.contact.troop.BaseTroopView.a
        public View g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (View) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return TroopActivity.this.findViewById(R.id.ids);
        }

        @Override // com.tencent.mobileqq.activity.contact.troop.BaseTroopView.a
        public Activity getActivity() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Activity) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return TroopActivity.this;
        }

        @Override // com.tencent.mobileqq.activity.contact.troop.BaseTroopView.a
        public QQAppInterface getApp() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (QQAppInterface) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return TroopActivity.this.app;
        }

        @Override // com.tencent.mobileqq.activity.contact.troop.BaseTroopView.a
        public MqqWeakReferenceHandler getHandler() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (MqqWeakReferenceHandler) iPatchRedirector.redirect((short) 12, (Object) this);
            }
            return TroopActivity.this.f181344l0;
        }

        @Override // com.tencent.mobileqq.activity.contact.troop.BaseTroopView.a
        public View getRootView() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (View) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return TroopActivity.this.findViewById(R.id.root);
        }

        @Override // com.tencent.mobileqq.activity.contact.troop.BaseTroopView.a
        public void showToast(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            } else if (TroopActivity.this.isResume()) {
                QQToast.makeText(getActivity(), str, 0).show(TroopActivity.this.getTitleBarHeight());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class b implements TabBarView.d {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.TabBarView.d
        public void a(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            BaseTroopView baseTroopView = TroopActivity.this.f181350r0;
            if (baseTroopView != null) {
                baseTroopView.n();
            }
            if (i16 != 0) {
                if (i16 != 1) {
                    ReportController.o(TroopActivity.this.app, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_mygrp", 0, 0, "", "", "", "");
                    ReportController.o(TroopActivity.this.app, "CliOper", "", "", "0X8006620", "0X8006620", 0, 0, "", "", "", "");
                    TroopActivity.this.f181337e0 = 0;
                } else {
                    ReportController.o(TroopActivity.this.app, "P_CliOper", "Grp_contacts", "", "discuss", "contact_discuss_tab", 0, 0, "", "", "", "");
                    ReportController.o(TroopActivity.this.app, "CliOper", "", "", "0X8006621", "0X8006621", 0, 0, "", "", "", "");
                    TroopActivity.this.f181337e0 = 1;
                }
            } else {
                ReportController.o(TroopActivity.this.app, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_mygrp", 0, 0, "", "", "", "");
                ReportController.o(TroopActivity.this.app, "CliOper", "", "", "0X8006620", "0X8006620", 0, 0, "", "", "", "");
                TroopActivity.this.f181337e0 = 0;
            }
            TroopActivity troopActivity = TroopActivity.this;
            troopActivity.V2(troopActivity.f181337e0);
            TroopActivity.this.f181344l0.sendEmptyMessage(1234);
            TroopActivity.this.Z2(i16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class c implements PopupMenuDialog.OnClickActionListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopActivity.this);
            }
        }

        @Override // com.tencent.widget.PopupMenuDialog.OnClickActionListener
        public void onClickAction(PopupMenuDialog.MenuItem menuItem) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) menuItem);
                return;
            }
            int i3 = menuItem.f384641id;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 3) {
                        TroopActivity.this.N2();
                        return;
                    }
                    return;
                } else {
                    ReportController.o(TroopActivity.this.app, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_right_join", 0, 0, "", "", "", "");
                    ReportController.o(TroopActivity.this.app, "CliOper", "", "", "Grp", "grplist_plus_join", 47, 0, "", "", "", "");
                    AddContactsActivity.W2(TroopActivity.this, 1);
                    return;
                }
            }
            ReportController.o(TroopActivity.this.app, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_right_create", 0, 0, "", "", "", "");
            ReportController.o(TroopActivity.this.app, "CliOper", "", "", "0X8006622", "0X8006622", 0, 0, "", "", "", "");
            ITroopCreateService iTroopCreateService = (ITroopCreateService) TroopActivity.this.app.getRuntimeService(ITroopCreateService.class, "");
            if (iTroopCreateService != null) {
                iTroopCreateService.startCreateTroopSession(TroopActivity.this, 0);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class d implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                int id5 = view.getId();
                if (id5 != R.id.k4f && id5 != R.id.f165972dz1 && id5 != R.id.ivTitleBtnLeft) {
                    if (id5 == R.id.ivTitleBtnRightImage) {
                        ReportController.o(TroopActivity.this.app, "P_CliOper", "Grp_contacts", "", "Grp_contactlist", "Clk_right", 0, 0, "", "", "", "");
                        if (TroopActivity.this.T2()) {
                            TroopActivity.this.Q2();
                        } else {
                            ReportController.o(TroopActivity.this.app, "CliOper", "", "", "Grp", "Clk_grplist_plus", 0, 0, "", "", "", "");
                            TroopActivity.this.U2();
                        }
                    } else {
                        TroopActivity.this.Q2();
                    }
                } else {
                    TroopActivity.this.onBackPressed();
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(67952);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
        } else {
            f181335v0 = new int[]{R.string.i9b, R.string.f170113gr, R.string.i9c, R.string.conversation_options_multichat};
            f181336w0 = new int[]{R.drawable.qb_group_menu_create_group, R.drawable.qb_group_menu_search_group, R.drawable.qb_group_menu_groupmsg_setting, R.drawable.conversation_options_multichat};
        }
    }

    public TroopActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f181337e0 = 0;
        this.f181345m0 = new ArrayList<>();
        this.f181346n0 = false;
        this.f181347o0 = "DEFAULT";
        this.f181349q0 = new b();
        this.f181353u0 = new d();
    }

    private BaseTroopView H2(int i3) {
        BaseTroopView troopView;
        BaseTroopView baseTroopView = this.f181345m0.get(i3);
        if (baseTroopView != null) {
            return baseTroopView;
        }
        if (i3 != 0) {
            if (i3 != 1) {
                troopView = new TroopView(this);
            } else {
                troopView = new DiscussionView(this);
            }
        } else {
            troopView = new TroopView(this);
        }
        this.f181345m0.set(i3, troopView);
        troopView.k(null, this.f181339g0);
        return troopView;
    }

    private void L2() {
        int i3 = this.f181337e0;
        if (i3 != 0) {
            if (i3 != 1) {
                this.f181340h0.setSelectedTab(0, true);
                return;
            } else {
                this.f181340h0.setSelectedTab(1, true);
                return;
            }
        }
        this.f181340h0.setSelectedTab(0, true);
    }

    private void M2(View view, int i3) {
        Drawable drawable = getResources().getDrawable(i3);
        if (drawable != null) {
            drawable.setTint(getResources().getColor(R.color.qui_button_text_primary));
        }
        view.setBackground(drawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N2() {
        Intent intent = new Intent();
        intent.putExtra("param_type", 3000);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_SUBTYPE, 0);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_FROM, 1002);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_TITLE, getString(R.string.conversation_options_multichat));
        intent.putExtra(ISelectMemberActivityConstants.PARAM_DONE_BUTTON_WORDING, getString(R.string.f173099hd3));
        intent.putExtra(ISelectMemberActivityConstants.PARAM_DONE_BUTTON_HIGHLIGHT_WORDING, getString(R.string.f173100hd4));
        intent.putExtra(ISelectMemberActivityConstants.MULTICHAT, true);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_MIN, 1);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_MAX, 99);
        ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).startSelectMemberActivityForResult(this, intent, 1300);
        ReportController.o(this.app, "CliOper", "", "", "Contacts_tab", "Contacts_tab_creat_discuss", 0, 0, "", "", "", "");
        ReportController.o(this.app, "P_CliOper", "Grp_contacts", "", "discuss", "creat_discuss_contact", 0, 0, "", "", "", "");
    }

    private void R2() {
        this.f181339g0 = new a();
    }

    private void S2() {
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        while (true) {
            int[] iArr = f181335v0;
            if (i3 < iArr.length) {
                PopupMenuDialog.MenuItem menuItem = new PopupMenuDialog.MenuItem();
                menuItem.f384641id = i3;
                String string = getString(iArr[i3]);
                menuItem.title = string;
                menuItem.contentDescription = string;
                menuItem.iconId = f181336w0[i3];
                arrayList.add(menuItem);
                i3++;
            } else {
                this.f181352t0 = PopupMenuDialog.build(this, arrayList, new c());
                return;
            }
        }
    }

    private void W2(int i3, String str) {
        ITroopCreateService iTroopCreateService = (ITroopCreateService) this.app.getRuntimeService(ITroopCreateService.class, "");
        if (iTroopCreateService != null) {
            iTroopCreateService.startCreateTroopSession(this, i3, str);
        }
    }

    private void Y2(TextView textView, ImageView imageView) {
        ThreadManagerV2.excute(new Runnable(textView, imageView) { // from class: com.tencent.mobileqq.activity.contact.troop.TroopActivity.4
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ TextView f181360d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ ImageView f181361e;

            {
                this.f181360d = textView;
                this.f181361e = imageView;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, TroopActivity.this, textView, imageView);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable(TroopActivity.this.app.getMessageFacade().H1()) { // from class: com.tencent.mobileqq.activity.contact.troop.TroopActivity.4.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ int f181362d;

                        {
                            this.f181362d = r5;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass4.this, r5);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                            TextView textView2 = anonymousClass4.f181360d;
                            if (textView2 != null && anonymousClass4.f181361e != null) {
                                textView2.setText("" + this.f181362d);
                                if (this.f181362d <= 0) {
                                    AnonymousClass4.this.f181360d.setVisibility(4);
                                }
                                if (AppSetting.f99565y) {
                                    AnonymousClass4.this.f181360d.setContentDescription(HardCodeUtil.qqStr(R.string.u_v) + this.f181362d + HardCodeUtil.qqStr(R.string.u_p));
                                    AnonymousClass4.this.f181361e.setContentDescription(HardCodeUtil.qqStr(R.string.u_u) + this.f181362d + HardCodeUtil.qqStr(R.string.u_t));
                                }
                            }
                        }
                    });
                }
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z2(int i3) {
        if (AppSetting.f99565y) {
            int childCount = this.f181340h0.getChildCount();
            for (int i16 = 0; i16 < childCount; i16++) {
                RedDotTextView o16 = this.f181340h0.o(i16);
                StringBuilder sb5 = new StringBuilder(24);
                sb5.append(o16.getText());
                o16.setContentDescription(sb5);
            }
        }
    }

    @TargetApi(14)
    private void initViews() {
        String string;
        this.f181348p0 = ThemeUtil.isDefaultOrDIYTheme(false);
        View findViewById = findViewById(R.id.root);
        if (this.mNeedStatusTrans && ImmersiveUtils.isSupporImmersive() == 1) {
            findViewById.setFitsSystemWindows(true);
            findViewById.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
        }
        TextView textView = (TextView) findViewById(R.id.ivTitleBtnLeft);
        M2(textView, R.drawable.top_back_left_selector);
        Intent intent = getIntent();
        if (intent.getIntExtra("forward_type", Integer.MAX_VALUE) == 23) {
            string = HardCodeUtil.qqStr(R.string.u_r);
            textView.setMaxWidth(BaseAIOUtils.f(120.0f, getResources()));
        } else {
            string = intent.getExtras().getString(AppConstants.LeftViewText.LEFTVIEWTEXT);
            if (string == null) {
                string = getString(R.string.button_back);
            }
            if (this.f181348p0) {
                this.app.getMessageFacade().addObserver(this);
                textView.setVisibility(8);
                TextView textView2 = (TextView) findViewById(R.id.k4f);
                ImageView imageView = (ImageView) findViewById(R.id.f165972dz1);
                imageView.setVisibility(0);
                Y2(textView2, imageView);
                P2(textView2, 0, 0, 0, BaseAIOUtils.f(30.5f, getResources()));
                textView2.setOnClickListener(this.f181353u0);
                imageView.setOnClickListener(this.f181353u0);
            }
        }
        textView.setText("");
        textView.setOnClickListener(this.f181353u0);
        this.f181343k0 = (TextView) findViewById(R.id.ivTitleBtnRightText);
        this.f181342j0 = (ImageView) findViewById(R.id.ivTitleBtnRightImage);
        this.f181340h0 = (TabBarView) findViewById(R.id.i9x);
        if (!this.f175038c0 && !this.f175037b0) {
            M2(this.f181342j0, R.drawable.top_button_right_selector);
            this.f181342j0.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            ViewGroup.LayoutParams layoutParams = this.f181342j0.getLayoutParams();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            layoutParams.width = (displayMetrics.densityDpi * 36) / 160;
            layoutParams.height = -2;
            this.f181342j0.setLayoutParams(layoutParams);
            this.f181342j0.setMaxWidth((displayMetrics.densityDpi * 100) / 160);
            this.f181342j0.setVisibility(0);
            this.f181342j0.setOnClickListener(this.f181353u0);
        } else {
            this.f181342j0.setVisibility(8);
        }
        TextView textView3 = (TextView) findViewById(R.id.ivTitleName);
        if (getIntent().getBooleanExtra("onlyOneSegement", false)) {
            findViewById(R.id.ids).setVisibility(8);
            if (this.f181338f0 == 3) {
                textView3.setText(R.string.znr);
            } else {
                int i3 = this.f181337e0;
                if (i3 == 0) {
                    textView3.setText(R.string.a_6);
                } else if (1 == i3) {
                    textView3.setText(R.string.a_3);
                }
            }
        }
        M2(this.f181342j0, R.drawable.header_btn_add);
        this.f181340h0.c(0, getString(R.string.a_6));
        findViewById(R.id.ids).setVisibility(8);
        this.f181340h0.setOnTabChangeListener(this.f181349q0);
        this.f181341i0 = (FrameLayout) findViewById(R.id.dm6);
        S2();
        L2();
        if (AppSetting.f99565y) {
            if (this.f175038c0) {
                textView.setContentDescription(((Object) textView3.getText()) + HardCodeUtil.qqStr(R.string.u_o) + string + HardCodeUtil.qqStr(R.string.u_q));
                textView.postDelayed(new Runnable(textView) { // from class: com.tencent.mobileqq.activity.contact.troop.TroopActivity.3
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ TextView f181359d;

                    {
                        this.f181359d = textView;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopActivity.this, (Object) textView);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        } else {
                            this.f181359d.sendAccessibilityEvent(8);
                        }
                    }
                }, 1000L);
            } else {
                textView.setContentDescription(string + HardCodeUtil.qqStr(R.string.u_m));
            }
            if (this.f181342j0.getVisibility() == 0) {
                this.f181342j0.setContentDescription(HardCodeUtil.qqStr(R.string.u_n));
            }
        }
    }

    public void P2(View view, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, view, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        } else {
            if (view == null) {
                return;
            }
            ((View) view.getParent()).post(new Runnable(view, i3, i16, i17, i18) { // from class: com.tencent.mobileqq.activity.contact.troop.TroopActivity.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ View f181354d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f181355e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ int f181356f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ int f181357h;

                /* renamed from: i, reason: collision with root package name */
                final /* synthetic */ int f181358i;

                {
                    this.f181354d = view;
                    this.f181355e = i3;
                    this.f181356f = i16;
                    this.f181357h = i17;
                    this.f181358i = i18;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, TroopActivity.this, view, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    Rect rect = new Rect();
                    this.f181354d.setEnabled(true);
                    this.f181354d.getHitRect(rect);
                    rect.top -= this.f181355e;
                    rect.bottom += this.f181356f;
                    rect.left -= this.f181357h;
                    rect.right += this.f181358i;
                    TouchDelegate touchDelegate = new TouchDelegate(rect, this.f181354d);
                    if (View.class.isInstance(this.f181354d.getParent())) {
                        ((View) this.f181354d.getParent()).setTouchDelegate(touchDelegate);
                    }
                }
            });
        }
    }

    public void Q2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else if (T2()) {
            this.f181352t0.dismiss();
        }
    }

    public boolean T2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        PopupMenuDialog popupMenuDialog = this.f181352t0;
        if (popupMenuDialog != null && popupMenuDialog.isShowing()) {
            return true;
        }
        return false;
    }

    void U2() {
        this.f181352t0.showAsDropDown(this.f181339g0.b(), (this.f181339g0.b().getWidth() - getResources().getDimensionPixelSize(R.dimen.aua)) - getResources().getDimensionPixelSize(R.dimen.au7), getResources().getDimensionPixelSize(R.dimen.au8));
    }

    void V2(int i3) {
        BaseTroopView baseTroopView;
        BaseTroopView H2 = H2(i3);
        if (H2 != null && (baseTroopView = this.f181350r0) != H2) {
            if (baseTroopView != null) {
                if (isResume()) {
                    this.f181350r0.l();
                }
                this.f181350r0.onStop();
            }
            this.f181350r0 = H2;
            H2.onStart();
            if (isResume()) {
                this.f181350r0.m();
            }
            this.f181341i0.removeAllViews();
            this.f181341i0.addView(this.f181350r0);
        }
    }

    @Override // com.tencent.mobileqq.activity.BaseForwardSelectionActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.BaseForwardSelectionActivity, mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        super.doOnActivityResult(i3, i16, intent);
        BaseTroopView baseTroopView = this.f181350r0;
        if (baseTroopView != null) {
            baseTroopView.i(i3, i16, intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.BaseForwardSelectionActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        super.setContentView(R.layout.a1l);
        super.getWindow().setBackgroundDrawable(null);
        this.f181344l0 = new MqqWeakReferenceHandler(this);
        this.f181345m0.add(null);
        this.f181345m0.add(null);
        this.f181345m0.add(null);
        this.f181345m0.add(null);
        this.f181338f0 = getIntent().getIntExtra("key_from", 0);
        this.f181346n0 = getIntent().getBooleanExtra("fromH5", false);
        this.f181347o0 = getIntent().getStringExtra("troopType");
        this.f175037b0 = getIntent().getBooleanExtra(AppConstants.Key.IS_SELECT_TROOP, false);
        R2();
        initViews();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.BaseForwardSelectionActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        this.app.getMessageFacade().deleteObserver(this);
        Iterator<BaseTroopView> it = this.f181345m0.iterator();
        while (it.hasNext()) {
            BaseTroopView next = it.next();
            if (next != null) {
                next.onDestroy();
            }
        }
        super.doOnDestroy();
        this.f175036a0 = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, i3, (Object) keyEvent)).booleanValue();
        }
        return super.doOnKeyDown(i3, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        BaseTroopView baseTroopView = this.f181350r0;
        if (baseTroopView != null) {
            baseTroopView.l();
        }
        PopupMenuDialog popupMenuDialog = this.f181352t0;
        if (popupMenuDialog != null) {
            popupMenuDialog.onPause();
        }
        this.f181351s0 = false;
        super.doOnPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.doOnResume();
        BaseTroopView baseTroopView = this.f181350r0;
        if (baseTroopView != null) {
            baseTroopView.m();
        }
        this.f181351s0 = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.doOnStart();
        BaseTroopView baseTroopView = this.f181350r0;
        if (baseTroopView != null) {
            baseTroopView.onStart();
        }
        if (this.f181346n0) {
            W2(4, this.f181347o0);
            this.f181346n0 = false;
            this.f181347o0 = "DEFAULT";
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        BaseTroopView baseTroopView = this.f181350r0;
        if (baseTroopView != null) {
            baseTroopView.onStop();
        }
        super.doOnStop();
    }

    @Override // com.tencent.mobileqq.activity.BaseForwardSelectionActivity, com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            super.finish();
            overridePendingTransition(R.anim.activity_back, R.anim.activity_finish);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, (Object) message)).booleanValue();
        }
        if (message.what == 1234) {
            runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.activity.contact.troop.TroopActivity.8
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopActivity.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    BaseTroopView baseTroopView = TroopActivity.this.f181350r0;
                    if (baseTroopView != null) {
                        baseTroopView.j();
                    }
                }
            });
            return true;
        }
        Iterator<BaseTroopView> it = this.f181345m0.iterator();
        while (it.hasNext()) {
            BaseTroopView next = it.next();
            if (next != null) {
                next.g(message);
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        if (-1 == i16 && i3 == 1300) {
            this.f181337e0 = 1;
            L2();
            if (intent != null) {
                TroopUtils.e(this, intent.getStringExtra("roomId"), true);
            }
        }
        super.onActivityResult(i3, i16, intent);
    }

    @Override // com.tencent.mobileqq.activity.BaseForwardSelectionActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void requestWindowFeature(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
        } else {
            requestWindowFeature(1);
        }
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) observable, obj);
            return;
        }
        if (obj instanceof MessageRecord) {
            MessageRecord messageRecord = (MessageRecord) obj;
            if (!messageRecord.isSendFromLocal() && this.f181348p0) {
                TextView textView = (TextView) findViewById(R.id.k4f);
                ImageView imageView = (ImageView) findViewById(R.id.f165972dz1);
                if (textView != null && imageView != null) {
                    ThreadManagerV2.postImmediately(new GetUnReadNumRunnable(this.app, new WeakReference(this), textView, imageView), null, false);
                }
            }
            messageRecord.isSendFromLocal();
        }
    }
}
