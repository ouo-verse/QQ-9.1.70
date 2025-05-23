package com.tencent.mobileqq.teamworkforgroup;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.PadInfo;
import com.tencent.mobileqq.teamwork.api.IGetExternalInterface;
import com.tencent.mobileqq.teamwork.api.IGroupTeamWorkAdapterCreator;
import com.tencent.mobileqq.teamwork.api.IGroupTeamWorkHandler;
import com.tencent.mobileqq.teamwork.api.ITeamWorkDocEditBrowserProxy;
import com.tencent.mobileqq.teamwork.api.ITeamWorkFacadeCreator;
import com.tencent.mobileqq.teamwork.api.ITeamWorkHandler;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtilsTemp;
import com.tencent.mobileqq.teamwork.be;
import com.tencent.mobileqq.teamwork.bh;
import com.tencent.mobileqq.teamwork.t;
import com.tencent.mobileqq.teamworkforgroup.b;
import com.tencent.mobileqq.teamworkforgroup.d;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.api.ITroopSPUtilApi;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ea;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.mobileqq.webview.util.u;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.AbsListView;
import com.tencent.widget.FixSizeImageView;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.PopupMenuDialog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0xae9.online_docs$DocId;

/* compiled from: P */
/* loaded from: classes18.dex */
public class GroupTeamWorkListActivity extends IphoneTitleBarActivity implements View.OnClickListener, Handler.Callback, AbsListView.OnScrollListener, OverScrollViewListener, com.tencent.mobileqq.teamwork.m {
    com.tencent.mobileqq.teamworkforgroup.f B0;
    IGroupTeamWorkHandler C0;
    TextView E0;
    EditText F0;
    public long G0;
    private long H0;
    private QQCustomDialog M0;

    /* renamed from: b0, reason: collision with root package name */
    private View f292452b0;

    /* renamed from: c0, reason: collision with root package name */
    private HorizontalListView f292453c0;

    /* renamed from: d0, reason: collision with root package name */
    private com.tencent.mobileqq.teamworkforgroup.d f292454d0;

    /* renamed from: e0, reason: collision with root package name */
    private View f292455e0;

    /* renamed from: f0, reason: collision with root package name */
    private FPSSwipListView f292456f0;

    /* renamed from: g0, reason: collision with root package name */
    private PullRefreshHeader f292457g0;

    /* renamed from: h0, reason: collision with root package name */
    private com.tencent.mobileqq.teamwork.g f292458h0;

    /* renamed from: i0, reason: collision with root package name */
    private View f292459i0;

    /* renamed from: j0, reason: collision with root package name */
    private View f292460j0;

    /* renamed from: k0, reason: collision with root package name */
    private TextView f292461k0;

    /* renamed from: l0, reason: collision with root package name */
    private ProgressBar f292462l0;

    /* renamed from: m0, reason: collision with root package name */
    private View f292463m0;

    /* renamed from: n0, reason: collision with root package name */
    private View f292464n0;

    /* renamed from: o0, reason: collision with root package name */
    private View f292465o0;

    /* renamed from: p0, reason: collision with root package name */
    private TextView f292466p0;

    /* renamed from: q0, reason: collision with root package name */
    private com.tencent.mobileqq.activity.recent.d f292467q0;

    /* renamed from: w0, reason: collision with root package name */
    be f292473w0;

    /* renamed from: x0, reason: collision with root package name */
    ITeamWorkHandler f292474x0;

    /* renamed from: z0, reason: collision with root package name */
    RelativeLayout f292476z0;

    /* renamed from: a0, reason: collision with root package name */
    public int f292451a0 = 0;

    /* renamed from: r0, reason: collision with root package name */
    private boolean f292468r0 = false;

    /* renamed from: s0, reason: collision with root package name */
    private boolean f292469s0 = false;

    /* renamed from: t0, reason: collision with root package name */
    private boolean f292470t0 = false;

    /* renamed from: u0, reason: collision with root package name */
    private boolean f292471u0 = false;

    /* renamed from: v0, reason: collision with root package name */
    protected final MqqHandler f292472v0 = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);

    /* renamed from: y0, reason: collision with root package name */
    List<GPadInfo> f292475y0 = new ArrayList();
    List<GroupPadTemplateInfo> A0 = new ArrayList();
    public Dialog D0 = null;
    private PopupMenuDialog.OnClickActionListener I0 = new m();
    Comparator<PadInfo> J0 = new n();
    private volatile int K0 = 1;
    volatile boolean L0 = false;
    public int N0 = 0;
    com.tencent.mobileqq.teamworkforgroup.g O0 = new f();
    bh P0 = new g();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            ((QQCustomDialog) dialogInterface).getCheckBoxState();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ PadInfo f292481d;

        b(PadInfo padInfo) {
            this.f292481d = padInfo;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (!NetworkUtil.isNetworkAvailable(BaseApplication.getContext())) {
                QQToast.makeText(BaseApplicationImpl.getApplication(), 1, BaseApplicationImpl.getApplication().getString(R.string.b3j), 0).show(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                return;
            }
            if (GroupTeamWorkListActivity.this.C0 != null) {
                ITeamWorkUtils iTeamWorkUtils = (ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class);
                PadInfo padInfo = this.f292481d;
                online_docs$DocId docId = iTeamWorkUtils.getDocId(padInfo.domainId, padInfo.padId);
                if (GroupTeamWorkListActivity.this.M0.getCheckBoxState()) {
                    GroupTeamWorkListActivity groupTeamWorkListActivity = GroupTeamWorkListActivity.this;
                    groupTeamWorkListActivity.C0.reqDeleteGroupTeamWorkFile(groupTeamWorkListActivity.G0, docId, this.f292481d.pad_url, true);
                } else {
                    GroupTeamWorkListActivity groupTeamWorkListActivity2 = GroupTeamWorkListActivity.this;
                    groupTeamWorkListActivity2.C0.reqDeleteGroupTeamWorkFile(groupTeamWorkListActivity2.G0, docId, this.f292481d.pad_url, false);
                }
                GroupTeamWorkListActivity.this.i3(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class c implements DialogInterface.OnClickListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            GroupTeamWorkListActivity.this.c3();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class d implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ PadInfo f292484d;

        d(PadInfo padInfo) {
            this.f292484d = padInfo;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (!NetworkUtil.isNetworkAvailable(BaseApplication.getContext())) {
                QQToast.makeText(BaseApplicationImpl.getApplication(), 1, BaseApplicationImpl.getApplication().getString(R.string.b3j), 0).show(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                return;
            }
            if (GroupTeamWorkListActivity.this.C0 != null) {
                ITeamWorkUtils iTeamWorkUtils = (ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class);
                PadInfo padInfo = this.f292484d;
                online_docs$DocId docId = iTeamWorkUtils.getDocId(padInfo.domainId, padInfo.padId);
                GroupTeamWorkListActivity groupTeamWorkListActivity = GroupTeamWorkListActivity.this;
                groupTeamWorkListActivity.C0.reqDeleteGroupTeamWorkFile(groupTeamWorkListActivity.G0, docId, this.f292484d.pad_url, true);
                GroupTeamWorkListActivity.this.i3(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class e implements DialogInterface.OnClickListener {
        e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            GroupTeamWorkListActivity.this.c3();
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class f extends com.tencent.mobileqq.teamworkforgroup.g {
        f() {
        }

        @Override // com.tencent.mobileqq.teamworkforgroup.g
        public void a(boolean z16, int i3, String str) {
            if (QLog.isColorLevel()) {
                QLog.i("GroupTeamWorkListActivity", 2, " onDeletePanInfo success: " + z16 + " \nretCode: " + i3 + " \nerrorMsg: " + str);
            }
            if (z16 && i3 == 0) {
                GroupTeamWorkListActivity.this.e3(5);
                QQToast.makeText(GroupTeamWorkListActivity.this.app.getApp(), 1, GroupTeamWorkListActivity.this.getString(R.string.akc), 0).show(GroupTeamWorkListActivity.this.getTitleBarHeight());
            } else {
                QQToast.makeText(GroupTeamWorkListActivity.this.app.getApp(), 1, GroupTeamWorkListActivity.this.getString(R.string.ak6), 0).show(GroupTeamWorkListActivity.this.getTitleBarHeight());
                GroupTeamWorkListActivity.this.i3(2);
            }
        }

        @Override // com.tencent.mobileqq.teamworkforgroup.g
        public void b(boolean z16, int i3, String str, List<GPadInfo> list, int i16, int i17) {
            int i18;
            if (QLog.isColorLevel()) {
                QLog.i(com.tencent.mobileqq.teamworkforgroup.g.f292610d, 2, " onGetPadList success: " + z16 + " \nretCode: " + i3 + " \nerrorMsg: " + str + "\n next =" + i16);
            }
            GroupTeamWorkListActivity groupTeamWorkListActivity = GroupTeamWorkListActivity.this;
            groupTeamWorkListActivity.N0 = i16;
            boolean z17 = true;
            boolean z18 = false;
            if (groupTeamWorkListActivity.f292470t0) {
                if (z16) {
                    i18 = 1;
                } else {
                    i18 = 2;
                }
                GroupTeamWorkListActivity.this.f292472v0.sendMessageDelayed(GroupTeamWorkListActivity.this.f292472v0.obtainMessage(111, i18, 0), 500L);
                GroupTeamWorkListActivity.this.f292470t0 = false;
            }
            if (GroupTeamWorkListActivity.this.f292471u0) {
                GroupTeamWorkListActivity.this.i3(2);
                GroupTeamWorkListActivity.this.f292471u0 = false;
            }
            int i19 = 3;
            if (i17 != 2) {
                if (i17 == 3) {
                    i19 = 4;
                } else {
                    i19 = 2;
                }
            }
            if (z16 && i3 == 0) {
                GroupTeamWorkListActivity.this.e3(i19);
            } else {
                if (i19 == 2) {
                    if (GroupTeamWorkListActivity.this.f292458h0 != null && GroupTeamWorkListActivity.this.f292458h0.getCount() == 0) {
                        GroupTeamWorkListActivity.this.f292456f0.setVisibility(8);
                        if (GroupTeamWorkListActivity.this.f292463m0.getVisibility() == 0) {
                            GroupTeamWorkListActivity.this.f292463m0.setVisibility(8);
                        }
                        GroupTeamWorkListActivity.this.f292464n0.setVisibility(0);
                    } else {
                        QQToast.makeText(GroupTeamWorkListActivity.this.app.getApp(), 1, GroupTeamWorkListActivity.this.getString(R.string.c5o), 0).show(GroupTeamWorkListActivity.this.getTitleBarHeight());
                    }
                }
                if (i19 == 4) {
                    QQToast.makeText(GroupTeamWorkListActivity.this.app.getApp(), 1, GroupTeamWorkListActivity.this.getString(R.string.c5o), 0).show(GroupTeamWorkListActivity.this.getTitleBarHeight());
                } else {
                    z17 = false;
                }
                GroupTeamWorkListActivity.this.i3(2);
                z18 = z17;
            }
            if (z18) {
                GroupTeamWorkListActivity.this.f292460j0.setVisibility(8);
            }
        }

        @Override // com.tencent.mobileqq.teamworkforgroup.g
        public void c(boolean z16, int i3, String str, List<GPadInfo> list) {
            if (QLog.isColorLevel()) {
                QLog.i(com.tencent.mobileqq.teamworkforgroup.g.f292610d, 2, " onGetPadTemplateList success: " + z16 + " \nretCode: " + i3 + " \nerrorMsg: " + str);
            }
            if (z16 && i3 == 0) {
                GroupTeamWorkListActivity.this.f3(2);
                if (GroupTeamWorkListActivity.this.f292454d0 != null) {
                    GroupTeamWorkListActivity.this.f292454d0.notifyDataSetChanged();
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class g extends bh {
        g() {
        }

        @Override // com.tencent.mobileqq.teamwork.bh
        public void a(boolean z16, int i3, String str) {
            GroupTeamWorkListActivity.this.c3();
            if (QLog.isColorLevel()) {
                QLog.i("GroupTeamWorkListActivity", 2, " onDeletePad success: " + z16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ITeamWorkUtils iTeamWorkUtils = (ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class);
            GroupTeamWorkListActivity groupTeamWorkListActivity = GroupTeamWorkListActivity.this;
            iTeamWorkUtils.reportClickWithTroopType(groupTeamWorkListActivity.app, "0X800993E", String.valueOf(groupTeamWorkListActivity.G0));
            PadInfo padInfo = (PadInfo) ((b.a) view.getTag()).f292582a;
            Bundle bundle = new Bundle();
            bundle.putString("url", HtmlOffline.b(padInfo.pad_url, "_bid=2517"));
            bundle.putInt(ITeamWorkDocEditBrowserProxy.KEY_TEAM_WORK_EDIT_TYPE, padInfo.type);
            bundle.putString(ITeamWorkDocEditBrowserProxy.KEY_TEAM_WORK_TITLE, padInfo.title);
            bundle.putString(ITeamWorkDocEditBrowserProxy.KEY_TEAM_WORK_SOURCE_URL, padInfo.pad_url);
            bundle.putInt(ITeamWorkDocEditBrowserProxy.KEY_TEAM_WORK_PAD_LIST_TYPE, padInfo.type_list);
            bundle.putString(ITeamWorkUtils.TD_SOURCE_QQ_ADTAG, ITeamWorkUtils.TD_SOURCE_QQ_GRPFILE);
            TeamWorkDocEditBrowserActivity.openTeamWorkDocEditBrowserActivity(GroupTeamWorkListActivity.this, bundle, true);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class i implements View.OnClickListener {
        i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            d.b bVar = (d.b) view.getTag();
            if (bVar.f292596e == com.tencent.mobileqq.teamworkforgroup.d.C) {
                ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).report(GroupTeamWorkListActivity.this.app, "0X8009938");
                ITeamWorkUtilsTemp iTeamWorkUtilsTemp = (ITeamWorkUtilsTemp) QRoute.api(ITeamWorkUtilsTemp.class);
                GroupTeamWorkListActivity groupTeamWorkListActivity = GroupTeamWorkListActivity.this;
                iTeamWorkUtilsTemp.openTroopTemplatePreviewUrlWithCheck(groupTeamWorkListActivity.app, groupTeamWorkListActivity, 2, "group_online_doc_more_temp", groupTeamWorkListActivity.G0, groupTeamWorkListActivity.H0, GroupTeamWorkListActivity.this.app.getLongAccountUin());
                ReportController.o(GroupTeamWorkListActivity.this.app, "dc00898", "", "", "0X8009C67", "0X8009C67", 0, 0, "", "", "" + GroupTeamWorkListActivity.this.H0, "");
            } else {
                GroupTeamWorkListActivity groupTeamWorkListActivity2 = GroupTeamWorkListActivity.this;
                String i3 = QFileUtils.i(groupTeamWorkListActivity2.app, groupTeamWorkListActivity2.G0);
                if (!TextUtils.isEmpty(i3)) {
                    QQToast.makeText(GroupTeamWorkListActivity.this, i3, 0).show();
                } else {
                    ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).report(GroupTeamWorkListActivity.this.app, "0X8009937");
                    ITeamWorkUtils iTeamWorkUtils = (ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class);
                    GroupTeamWorkListActivity groupTeamWorkListActivity3 = GroupTeamWorkListActivity.this;
                    iTeamWorkUtils.openGroupPadTemplatePreviewUrl(groupTeamWorkListActivity3.app, groupTeamWorkListActivity3, "group_online_doc_temp", groupTeamWorkListActivity3.H0, bVar.f292592a);
                    ReportController.o(GroupTeamWorkListActivity.this.app, "dc00898", "", "", "0X8009C66", "0X8009C66", 0, 0, "", "", "" + GroupTeamWorkListActivity.this.H0, "");
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class j implements View.OnFocusChangeListener {

        /* compiled from: P */
        /* loaded from: classes18.dex */
        class a implements DialogInterface.OnDismissListener {
            a() {
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                GroupTeamWorkListActivity.this.D0 = null;
            }
        }

        j() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z16) {
            if (z16) {
                ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).report(GroupTeamWorkListActivity.this.app, "0X800993D");
                view.clearFocus();
                GroupTeamWorkListActivity groupTeamWorkListActivity = GroupTeamWorkListActivity.this;
                if (groupTeamWorkListActivity.D0 != null) {
                    return;
                }
                ITeamWorkFacadeCreator iTeamWorkFacadeCreator = (ITeamWorkFacadeCreator) QRoute.api(ITeamWorkFacadeCreator.class);
                GroupTeamWorkListActivity groupTeamWorkListActivity2 = GroupTeamWorkListActivity.this;
                View view2 = groupTeamWorkListActivity2.f292455e0;
                GroupTeamWorkListActivity groupTeamWorkListActivity3 = GroupTeamWorkListActivity.this;
                groupTeamWorkListActivity.D0 = iTeamWorkFacadeCreator.getTroopTeamWorkFileSearchDialog(groupTeamWorkListActivity2, view2, groupTeamWorkListActivity3.app, groupTeamWorkListActivity3.G0);
                GroupTeamWorkListActivity.this.D0.setTitle(HardCodeUtil.qqStr(R.string.f172081n64));
                GroupTeamWorkListActivity.this.D0.setCanceledOnTouchOutside(true);
                GroupTeamWorkListActivity.this.D0.show();
                GroupTeamWorkListActivity.this.D0.setOnDismissListener(new a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class k extends ClickableSpan {
        k() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            Intent intent = new Intent(GroupTeamWorkListActivity.this.getActivity(), (Class<?>) QQBrowserActivity.class);
            intent.putExtra("uin", GroupTeamWorkListActivity.this.app.getCurrentAccountUin());
            intent.putExtra("hide_more_button", true);
            intent.putExtra("hide_operation_bar", true);
            GroupTeamWorkListActivity.this.startActivity(intent.putExtra("url", "https://tim.qq.com/htdocs/2.0_lead/document.html"));
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(GroupTeamWorkListActivity.this.getResources().getColor(R.color.f156949g1));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class l implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f292494d;

        l(View view) {
            this.f292494d = view;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            this.f292494d.setVisibility(8);
            GroupTeamWorkListActivity.this.f292458h0.notifyDataSetChanged();
            GroupTeamWorkListActivity groupTeamWorkListActivity = GroupTeamWorkListActivity.this;
            ea.C2(groupTeamWorkListActivity, groupTeamWorkListActivity.app.getCurrentUin(), 1, false);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class m implements PopupMenuDialog.OnClickActionListener {
        m() {
        }

        @Override // com.tencent.widget.PopupMenuDialog.OnClickActionListener
        public void onClickAction(PopupMenuDialog.MenuItem menuItem) {
            int i3;
            int i16 = menuItem.f384641id;
            if (i16 == R.id.azr) {
                ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).report(GroupTeamWorkListActivity.this.app, "0X800993B");
                ITeamWorkUtilsTemp iTeamWorkUtilsTemp = (ITeamWorkUtilsTemp) QRoute.api(ITeamWorkUtilsTemp.class);
                GroupTeamWorkListActivity groupTeamWorkListActivity = GroupTeamWorkListActivity.this;
                iTeamWorkUtilsTemp.openTroopTemplatePreviewUrlWithCheck(groupTeamWorkListActivity.app, groupTeamWorkListActivity, 1, "group_online_doc", groupTeamWorkListActivity.G0, groupTeamWorkListActivity.H0, GroupTeamWorkListActivity.this.app.getLongAccountUin());
                i3 = 1;
            } else if (i16 == R.id.azs) {
                ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).report(GroupTeamWorkListActivity.this.app, "0X800993C");
                ITeamWorkUtilsTemp iTeamWorkUtilsTemp2 = (ITeamWorkUtilsTemp) QRoute.api(ITeamWorkUtilsTemp.class);
                GroupTeamWorkListActivity groupTeamWorkListActivity2 = GroupTeamWorkListActivity.this;
                iTeamWorkUtilsTemp2.openTroopTemplatePreviewUrlWithCheck(groupTeamWorkListActivity2.app, groupTeamWorkListActivity2, 2, "group_online_doc", groupTeamWorkListActivity2.G0, groupTeamWorkListActivity2.H0, GroupTeamWorkListActivity.this.app.getLongAccountUin());
                i3 = 2;
            } else if (i16 == R.id.azp) {
                ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).report(GroupTeamWorkListActivity.this.app, "0X800993C");
                ITeamWorkUtilsTemp iTeamWorkUtilsTemp3 = (ITeamWorkUtilsTemp) QRoute.api(ITeamWorkUtilsTemp.class);
                GroupTeamWorkListActivity groupTeamWorkListActivity3 = GroupTeamWorkListActivity.this;
                iTeamWorkUtilsTemp3.openTroopTemplatePreviewUrlWithCheck(groupTeamWorkListActivity3.app, groupTeamWorkListActivity3, 3, "group_online_doc", groupTeamWorkListActivity3.G0, groupTeamWorkListActivity3.H0, GroupTeamWorkListActivity.this.app.getLongAccountUin());
                i3 = 3;
            } else {
                i3 = 0;
            }
            ReportController.o(GroupTeamWorkListActivity.this.app, "dc00898", "", "", "0X8009C65", "0X8009C65", 0, 0, "", "", "" + GroupTeamWorkListActivity.this.H0, "" + i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class n implements Comparator<PadInfo> {
        n() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(PadInfo padInfo, PadInfo padInfo2) {
            long j3 = padInfo2.lastEditTime - padInfo.lastEditTime;
            if (j3 > 0) {
                return 1;
            }
            if (j3 < 0) {
                return -1;
            }
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c3() {
        QQCustomDialog qQCustomDialog = this.M0;
        if (qQCustomDialog != null) {
            if (qQCustomDialog.isShowing()) {
                try {
                    this.M0.dismiss();
                } catch (Exception e16) {
                    QLog.e("GroupTeamWorkListActivity", 1, " dismiss exception: " + e16.toString());
                }
            }
            this.M0 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d3(long j3, int i3, int i16, int i17) {
        IGroupTeamWorkHandler iGroupTeamWorkHandler = this.C0;
        if (iGroupTeamWorkHandler != null) {
            iGroupTeamWorkHandler.getGroupTeamWorkList(j3, i3, i16, i17);
            this.C0.getGroupPadTemplateList(j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e3(final int i3) {
        ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.mobileqq.teamworkforgroup.GroupTeamWorkListActivity.8
            @Override // java.lang.Runnable
            public void run() {
                GroupTeamWorkListActivity groupTeamWorkListActivity = GroupTeamWorkListActivity.this;
                com.tencent.mobileqq.teamworkforgroup.f fVar = groupTeamWorkListActivity.B0;
                if (fVar != null) {
                    if (i3 == 1) {
                        fVar.i(groupTeamWorkListActivity.G0);
                    }
                    List<GPadInfo> f16 = GroupTeamWorkListActivity.this.B0.f();
                    if (f16 != null) {
                        synchronized (GroupTeamWorkListActivity.this.f292475y0) {
                            GroupTeamWorkListActivity.this.g3(f16);
                            GroupTeamWorkListActivity groupTeamWorkListActivity2 = GroupTeamWorkListActivity.this;
                            Collections.sort(groupTeamWorkListActivity2.f292475y0, groupTeamWorkListActivity2.J0);
                        }
                    }
                    if (i3 == 1) {
                        GroupTeamWorkListActivity groupTeamWorkListActivity3 = GroupTeamWorkListActivity.this;
                        groupTeamWorkListActivity3.d3(groupTeamWorkListActivity3.G0, 0, 20, 1);
                    }
                    GroupTeamWorkListActivity.this.f292472v0.sendMessage(GroupTeamWorkListActivity.this.f292472v0.obtainMessage(113, 0, i3, null));
                }
            }
        }, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f3(final int i3) {
        ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.mobileqq.teamworkforgroup.GroupTeamWorkListActivity.10
            @Override // java.lang.Runnable
            public void run() {
                GroupTeamWorkListActivity groupTeamWorkListActivity = GroupTeamWorkListActivity.this;
                com.tencent.mobileqq.teamworkforgroup.f fVar = groupTeamWorkListActivity.B0;
                if (fVar != null) {
                    if (i3 == 1) {
                        fVar.i(groupTeamWorkListActivity.G0);
                    }
                    List<GroupPadTemplateInfo> g16 = GroupTeamWorkListActivity.this.B0.g();
                    if (g16 != null) {
                        synchronized (GroupTeamWorkListActivity.this.A0) {
                            GroupTeamWorkListActivity.this.h3(g16);
                        }
                    }
                    GroupTeamWorkListActivity.this.f292472v0.sendMessage(GroupTeamWorkListActivity.this.f292472v0.obtainMessage(115, 0, 0, null));
                }
            }
        }, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g3(List<GPadInfo> list) {
        if (list == null) {
            return;
        }
        this.f292475y0.clear();
        this.f292475y0.addAll(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h3(List<GroupPadTemplateInfo> list) {
        if (list == null) {
            return;
        }
        this.A0.clear();
        this.A0.addAll(list);
    }

    private void initTitleBar() {
        this.leftView.setText(getResources().getString(R.string.bo9));
        this.leftView.setBackgroundResource(R.drawable.top_back_left_selector);
        this.rightViewImg.setVisibility(0);
        this.rightViewImg.setImageResource(R.drawable.header_btn_add);
        this.rightViewImg.setOnClickListener(this);
        this.centerView.setMaxEms(13);
        this.centerView.setText(getResources().getString(R.string.bo7));
        this.centerView.setOnClickListener(this);
    }

    private void initUI() {
        this.f292455e0 = findViewById(R.id.root);
        this.f292463m0 = findViewById(R.id.jcd);
        View findViewById = findViewById(R.id.jcc);
        this.f292464n0 = findViewById;
        findViewById.setOnClickListener(this);
        this.f292465o0 = findViewById(R.id.f166949jc1);
        this.f292466p0 = (TextView) findViewById(R.id.f166951jc3);
        FPSSwipListView fPSSwipListView = (FPSSwipListView) findViewById(R.id.eap);
        this.f292456f0 = fPSSwipListView;
        fPSSwipListView.setDragEnable(true);
        this.f292456f0.setDivider(null);
        this.f292456f0.setOnScrollListener(this);
        this.f292456f0.setOverScrollListener(this);
        this.f292456f0.setOverscrollHeader(getResources().getDrawable(R.drawable.common_list_overscoll_top_bg));
        View inflate = LayoutInflater.from(this).inflate(R.layout.c0g, (ViewGroup) this.f292456f0, false);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        linearLayout.addView(inflate);
        this.f292456f0.addHeaderView(linearLayout);
        View inflate2 = LayoutInflater.from(this).inflate(R.layout.c0q, (ViewGroup) this.f292456f0, false);
        this.f292452b0 = inflate2;
        HorizontalListView horizontalListView = (HorizontalListView) inflate2.findViewById(R.id.cy9);
        this.f292453c0 = horizontalListView;
        if (horizontalListView != null) {
            horizontalListView.setVisibility(0);
            this.f292453c0.setDividerWidth(getResources().getDimensionPixelSize(R.dimen.t_));
        }
        this.f292456f0.addHeaderView(this.f292452b0);
        this.E0 = (TextView) this.f292452b0.findViewById(R.id.kag);
        EditText editText = (EditText) this.f292452b0.findViewById(R.id.et_search_keyword);
        this.F0 = editText;
        editText.setCursorVisible(false);
        this.F0.setOnFocusChangeListener(new j());
        PullRefreshHeader pullRefreshHeader = (PullRefreshHeader) LayoutInflater.from(this).inflate(R.layout.f168433w5, (ViewGroup) null);
        this.f292457g0 = pullRefreshHeader;
        this.f292456f0.setOverScrollHeader(pullRefreshHeader);
        View inflate3 = LayoutInflater.from(this).inflate(R.layout.c0j, (ViewGroup) null);
        this.f292459i0 = inflate3;
        this.f292460j0 = inflate3.findViewById(R.id.jcg);
        this.f292461k0 = (TextView) this.f292459i0.findViewById(R.id.jcf);
        this.f292462l0 = (ProgressBar) this.f292459i0.findViewById(R.id.jce);
        this.f292456f0.addFooterView(this.f292459i0);
        initTitleBar();
        this.f292476z0 = (RelativeLayout) findViewById(R.id.rlCommenTitle);
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.tencent.mobileqq.activity.recent.d.f185382g);
        arrayList.add(com.tencent.mobileqq.activity.recent.d.f185383h);
        arrayList.add(com.tencent.mobileqq.activity.recent.d.f185384i);
        this.f292467q0 = new com.tencent.mobileqq.activity.recent.d(this, arrayList, this.I0);
        this.f292456f0.setVisibility(8);
        this.f292463m0.setVisibility(0);
        if (ea.j2(this, this.app.getCurrentUin(), 1)) {
            new k();
            inflate.setVisibility(0);
            TextView textView = (TextView) inflate.findViewById(R.id.azo);
            FixSizeImageView fixSizeImageView = (FixSizeImageView) inflate.findViewById(R.id.azn);
            textView.setText(getString(R.string.f170752a43));
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            fixSizeImageView.setOnClickListener(new l(inflate));
            return;
        }
        inflate.setVisibility(8);
    }

    private void j3(boolean z16) {
        if (z16) {
            this.f292462l0.setVisibility(0);
            this.f292461k0.setText(R.string.hyx);
            this.f292460j0.setVisibility(0);
        } else {
            this.f292462l0.setVisibility(8);
            this.f292461k0.setText(R.string.hyy);
            this.f292460j0.setVisibility(0);
        }
    }

    private void l3(PadInfo padInfo) {
        String string;
        String string2;
        String str;
        String str2;
        c3();
        if (padInfo == null) {
            return;
        }
        String string3 = getString(R.string.f171151ok);
        if (this.f292451a0 != 1 && (padInfo.creatorUin <= 0 || !this.app.getCurrentAccountUin().equalsIgnoreCase(String.valueOf(padInfo.creatorUin)))) {
            QQAppInterface qQAppInterface = this.app;
            if (TroopUtils.a(qQAppInterface, this.G0, qQAppInterface.getCurrentAccountUin())) {
                if (padInfo.type == 1) {
                    string = getString(R.string.ak9);
                    string2 = getString(R.string.ajx);
                } else {
                    string = getString(R.string.aka);
                    string2 = getString(R.string.ajx);
                }
            } else {
                str = string3;
                str2 = "";
                if (padInfo.creatorUin <= 0 && this.app.getCurrentAccountUin().equalsIgnoreCase(String.valueOf(padInfo.creatorUin))) {
                    this.M0 = DialogUtil.createDialogInGroupTeamWork(this, 230, null, str2, getString(R.string.akd), getString(R.string.cancel), str, new a(), new b(padInfo), new c());
                } else {
                    QQCustomDialog message = DialogUtil.createCustomDialog(this, 230).setMessage(str2);
                    this.M0 = message;
                    message.setPositiveButton(str, new d(padInfo));
                    this.M0.setNegativeButton(getString(R.string.cancel), new e());
                }
                this.M0.show();
            }
        } else if (padInfo.type == 1) {
            string = getString(R.string.ak_);
            string2 = getString(R.string.ajx);
        } else {
            string = getString(R.string.akb);
            string2 = getString(R.string.ajx);
        }
        str2 = string;
        str = string2;
        if (padInfo.creatorUin <= 0) {
        }
        QQCustomDialog message2 = DialogUtil.createCustomDialog(this, 230).setMessage(str2);
        this.M0 = message2;
        message2.setPositiveButton(str, new d(padInfo));
        this.M0.setNegativeButton(getString(R.string.cancel), new e());
        this.M0.show();
    }

    @Override // com.tencent.mobileqq.teamwork.m
    public void D1(PadInfo padInfo) {
        if (padInfo != null && !TextUtils.isEmpty(padInfo.pad_url)) {
            String str = padInfo.pad_url;
            String str2 = padInfo.title;
            String valueOf = String.valueOf(padInfo.creatorUin);
            Intent intent = new Intent(getApplicationContext(), (Class<?>) TeamWorkTransparentShareActivity.class);
            if (!TextUtils.isEmpty(valueOf) && valueOf.equals(getCurrentAccountUin())) {
                intent.putExtra("team_is_my_document", true);
            }
            if (!TextUtils.isEmpty(str2)) {
                intent.putExtra(t.f292396a, str2);
            }
            if (!TextUtils.isEmpty(str)) {
                intent.putExtra("team_work_pad_url", str);
            }
            intent.putExtra("team_policy", padInfo.policy);
            intent.putExtra("team_work_pad_list_type", padInfo.type_list);
            intent.putExtra("team_work_pad_type", padInfo.type);
            intent.putExtra("from_activity", "GroupTeamWorkListActivity");
            intent.putExtra("select_type", this.f292451a0);
            overridePendingTransition(0, 0);
            startActivity(intent);
        }
    }

    @Override // com.tencent.mobileqq.teamwork.m
    public void X1(PadInfo padInfo) {
        if (padInfo != null && !TextUtils.isEmpty(padInfo.pad_url)) {
            l3(padInfo);
        }
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        if (QLog.isColorLevel()) {
            QLog.d("GroupTeamWorkListActivity", 2, " onActivityResult,requestCode=" + i3 + ",resultCode=" + i16);
        }
        if (i3 == 14001) {
            d3(this.G0, 0, 20, 1);
            this.f292471u0 = true;
        }
        super.doOnActivityResult(i3, i16, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        TroopInfo k3;
        super.doOnCreate(bundle);
        setContentView(R.layout.f168020p6);
        this.G0 = getIntent().getLongExtra(t.f292400e, 0L);
        QQAppInterface qQAppInterface = this.app;
        String str = BusinessHandlerFactory.GROUP_TEAM_WORK_HANDLER;
        this.C0 = (IGroupTeamWorkHandler) qQAppInterface.getBusinessHandler(str);
        this.B0 = (com.tencent.mobileqq.teamworkforgroup.f) this.app.getManager(QQManagerFactory.GROUP_TEAM_WORK_MANAGER);
        this.f292474x0 = (ITeamWorkHandler) this.app.getBusinessHandler(BusinessHandlerFactory.TEAM_WORK_HANDLER);
        this.f292473w0 = (be) this.app.getManager(QQManagerFactory.TEAMWORK_MANAGER);
        this.f292458h0 = ((IGroupTeamWorkAdapterCreator) QRoute.api(IGroupTeamWorkAdapterCreator.class)).getGroupTeamWorkAdapter(this.app, this, this, null);
        initUI();
        this.app.addObserver(this.O0);
        this.app.addObserver(this.P0);
        TroopManager troopManager = (TroopManager) this.app.getManager(QQManagerFactory.TROOP_MANAGER);
        if (troopManager != null && (k3 = troopManager.k(String.valueOf(this.G0))) != null) {
            this.H0 = k3.dwGroupClassExt;
        }
        e3(1);
        ((com.tencent.mobileqq.model.d) this.app.getManager(QQManagerFactory.TROOPINFO_MANAGER)).f(this.app.getApp(), String.valueOf(this.G0), IGetExternalInterface.TIM_GROUP_TM_REDDOT, false);
        ((IGroupTeamWorkHandler) this.app.getBusinessHandler(str)).getGroupTeamWorkListLastAddTime(this.G0);
        this.f292471u0 = true;
        this.f292456f0.setAdapter((ListAdapter) this.f292458h0);
        this.f292458h0.c(new h());
        this.f292458h0.b(this.f292475y0);
        this.f292454d0 = new com.tencent.mobileqq.teamworkforgroup.d(this, this);
        f3(1);
        this.f292453c0.setAdapter((ListAdapter) this.f292454d0);
        this.f292454d0.setData(this.A0);
        this.f292454d0.notifyDataSetChanged();
        this.f292454d0.d(new i());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        com.tencent.mobileqq.activity.recent.d dVar = this.f292467q0;
        if (dVar != null) {
            dVar.a();
        }
        MqqHandler mqqHandler = this.f292472v0;
        if (mqqHandler != null) {
            mqqHandler.removeMessages(114);
            this.f292472v0.removeMessages(111);
            this.f292472v0.removeMessages(112);
        }
        ((ITroopSPUtilApi) QRoute.api(ITroopSPUtilApi.class)).removeGroupTIMFileNewsInfo(this.app.getCurrentAccountUin(), ITroopSPUtilApi.KEY_GROUP_FILE_INNER_REDDOT_TIM, String.valueOf(this.G0));
        this.app.removeObserver(this.O0);
        this.app.removeObserver(this.P0);
        c3();
        if (this.f292454d0 != null) {
            this.f292454d0 = null;
        }
        super.doOnDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        super.doOnPause();
        com.tencent.mobileqq.activity.recent.d dVar = this.f292467q0;
        if (dVar != null) {
            dVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        super.doOnResume();
        ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.teamworkforgroup.GroupTeamWorkListActivity.3

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.teamworkforgroup.GroupTeamWorkListActivity$3$a */
            /* loaded from: classes18.dex */
            class a implements u {
                a() {
                }

                @Override // com.tencent.mobileqq.webview.util.u
                public void onResult(boolean z16) {
                    if (z16 && QLog.isColorLevel()) {
                        QLog.i("Tag_webView", 1, "Web_qqbrowser_web TeamWorkList preloadWebProcess success! ");
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                ((IWebProcessManagerService) GroupTeamWorkListActivity.this.app.getRuntimeService(IWebProcessManagerService.class, "")).startWebProcessUnderStrategy(7, new a());
            }
        }, 100L);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 111:
                PullRefreshHeader pullRefreshHeader = this.f292457g0;
                if (pullRefreshHeader != null) {
                    if (message.arg1 == 1) {
                        pullRefreshHeader.l(0);
                    } else {
                        pullRefreshHeader.l(1);
                    }
                }
                Message message2 = new Message();
                message2.what = 112;
                this.f292472v0.sendMessageDelayed(message2, 500L);
                return true;
            case 112:
                FPSSwipListView fPSSwipListView = this.f292456f0;
                if (fPSSwipListView != null) {
                    fPSSwipListView.springBackOverScrollHeaderView();
                }
                return true;
            case 113:
                if (this.f292458h0 != null) {
                    int i3 = message.arg2;
                    if (i3 == 4) {
                        j3(false);
                    }
                    synchronized (this.f292475y0) {
                        this.f292458h0.b(this.f292475y0);
                    }
                    if (i3 == 1) {
                        if (this.f292458h0.getCount() > 0) {
                            if (this.f292463m0.getVisibility() == 0) {
                                this.f292463m0.setVisibility(8);
                            }
                            if (this.f292465o0.getVisibility() == 0) {
                                this.f292465o0.setVisibility(8);
                            }
                            this.f292456f0.setVisibility(0);
                            if (this.f292471u0) {
                                i3(1);
                            }
                        }
                    } else if (this.f292458h0.getCount() > 0) {
                        if (this.f292463m0.getVisibility() == 0) {
                            this.f292463m0.setVisibility(8);
                        }
                        if (this.f292465o0.getVisibility() == 0) {
                            this.f292465o0.setVisibility(8);
                        }
                        this.f292456f0.setVisibility(0);
                        if ((this.f292456f0.getLastVisiblePosition() - this.f292456f0.getFirstVisiblePosition()) + 1 >= this.f292458h0.getCount()) {
                            this.f292460j0.setVisibility(8);
                        }
                    } else {
                        if (this.f292463m0.getVisibility() == 0) {
                            this.f292463m0.setVisibility(8);
                        }
                        if (this.f292456f0.getVisibility() == 0) {
                            this.f292456f0.setVisibility(8);
                        }
                        this.f292465o0.setVisibility(0);
                    }
                    if (this.L0 || i3 == 5) {
                        i3(2);
                    }
                }
                return true;
            case 114:
                this.f292472v0.removeMessages(114);
                if (this.f292462l0.getVisibility() == 8) {
                    this.f292460j0.setVisibility(8);
                }
                return true;
            case 115:
                if (this.f292454d0 != null) {
                    synchronized (this.A0) {
                        this.f292454d0.setData(this.A0);
                    }
                    if (this.f292454d0.getCount() > 0) {
                        this.f292453c0.setVisibility(0);
                    }
                }
                return true;
            default:
                return true;
        }
    }

    public void i3(int i3) {
        if (i3 == 1) {
            this.L0 = true;
            startTitleProgress();
        } else if (i3 == 2) {
            this.L0 = false;
            stopTitleProgress();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        com.tencent.mobileqq.activity.recent.d dVar = this.f292467q0;
        if (dVar != null) {
            dVar.a();
        }
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.ivTitleBtnRightImage) {
            ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).report(this.app, "0X800993A");
            com.tencent.mobileqq.activity.recent.d dVar = this.f292467q0;
            if (dVar != null) {
                RelativeLayout relativeLayout = this.f292476z0;
                dVar.d(relativeLayout, relativeLayout.getWidth() - getResources().getDimensionPixelSize(R.dimen.aua), getResources().getDimensionPixelSize(R.dimen.au8));
            }
        } else if (id5 == R.id.jcc) {
            d3(this.G0, 0, 20, 1);
            this.f292464n0.setVisibility(8);
            this.f292463m0.setVisibility(0);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.widget.OverScrollViewListener
    public void onNotCompleteVisable(int i3, View view, ListView listView) {
        ((PullRefreshHeader) view).i(0L);
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        if (i17 != 0 && i3 + i16 == i17) {
            this.f292468r0 = true;
            if (i17 <= i16) {
                this.f292469s0 = false;
                return;
            } else {
                this.f292469s0 = true;
                return;
            }
        }
        this.f292468r0 = false;
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i3) {
        boolean z16;
        com.tencent.mobileqq.teamwork.g gVar;
        if (i3 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (this.f292468r0 && (gVar = this.f292458h0) != null && gVar.getCount() > 0 && this.f292469s0 && z16) {
            if (this.N0 != 0) {
                j3(true);
                d3(this.G0, this.N0, 20, 3);
            } else {
                j3(false);
                this.f292472v0.sendEmptyMessageDelayed(114, 1500L);
            }
        }
    }

    @Override // com.tencent.widget.OverScrollViewListener
    public void onViewCompleteVisable(int i3, View view, ListView listView) {
        ((PullRefreshHeader) view).d(0L);
    }

    @Override // com.tencent.widget.OverScrollViewListener
    public boolean onViewCompleteVisableAndReleased(int i3, View view, ListView listView) {
        ((PullRefreshHeader) view).h(0L);
        d3(this.G0, 0, 20, 2);
        this.f292470t0 = true;
        return true;
    }

    @Override // com.tencent.widget.OverScrollViewListener
    public void onViewNotCompleteVisableAndReleased(int i3, View view, ListView listView) {
    }
}
