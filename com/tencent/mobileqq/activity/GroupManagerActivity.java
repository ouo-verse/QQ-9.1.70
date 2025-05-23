package com.tencent.mobileqq.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import androidx.annotation.Nullable;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.proxy.GroupActionResp;
import com.tencent.mobileqq.emosm.view.DragSortListView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialogWtihInput;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.ntrelation.api.IFriendsTABService;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.util.QQToastUtil;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.AdapterView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public class GroupManagerActivity extends IphoneTitleBarActivity implements Handler.Callback {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    private DragSortListView f176140a0;

    /* renamed from: b0, reason: collision with root package name */
    List<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> f176141b0;

    /* renamed from: c0, reason: collision with root package name */
    private com.tencent.mobileqq.adapter.r<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> f176142c0;

    /* renamed from: d0, reason: collision with root package name */
    private Dialog f176143d0;

    /* renamed from: e0, reason: collision with root package name */
    private Dialog f176144e0;

    /* renamed from: f0, reason: collision with root package name */
    private int f176145f0;

    /* renamed from: g0, reason: collision with root package name */
    private int f176146g0;

    /* renamed from: h0, reason: collision with root package name */
    private com.tencent.qqnt.ntrelation.friendsinfo.bean.b f176147h0;

    /* renamed from: i0, reason: collision with root package name */
    private QQCustomDialogWtihInput f176148i0;

    /* renamed from: j0, reason: collision with root package name */
    private hx3.b f176149j0;

    /* renamed from: k0, reason: collision with root package name */
    private DialogInterface.OnClickListener f176150k0;

    /* renamed from: l0, reason: collision with root package name */
    private DialogInterface.OnClickListener f176151l0;

    /* renamed from: m0, reason: collision with root package name */
    byte[] f176152m0;

    /* renamed from: n0, reason: collision with root package name */
    byte[] f176153n0;

    /* renamed from: o0, reason: collision with root package name */
    private DragSortListView.h f176154o0;

    /* renamed from: p0, reason: collision with root package name */
    private DragSortListView.l f176155p0;

    /* renamed from: q0, reason: collision with root package name */
    private boolean f176156q0;

    /* renamed from: r0, reason: collision with root package name */
    private boolean f176157r0;

    /* renamed from: s0, reason: collision with root package name */
    private boolean f176158s0;

    /* renamed from: t0, reason: collision with root package name */
    @SuppressLint({"HandlerLeak"})
    private Handler f176159t0;

    /* renamed from: u0, reason: collision with root package name */
    private com.tencent.mobileqq.app.ar f176160u0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements DialogInterface.OnDismissListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GroupManagerActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                GroupManagerActivity.this.f176143d0 = null;
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements ActionSheet.OnButtonClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ byte f176165d;

        b(byte b16) {
            this.f176165d = b16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, GroupManagerActivity.this, Byte.valueOf(b16));
            }
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
                return;
            }
            GroupManagerActivity.this.g3();
            if (i3 == 0) {
                GroupManagerActivity.this.f176140a0.setDragEnabled(true);
                GroupManagerActivity groupManagerActivity = GroupManagerActivity.this;
                groupManagerActivity.f176156q0 = groupManagerActivity.f3(this.f176165d);
                if (QLog.isColorLevel()) {
                    QLog.d("GroupManagerActivity", 2, "DeleteFriendGroup :" + ((int) this.f176165d) + ", " + GroupManagerActivity.this.f176156q0);
                }
                if (GroupManagerActivity.this.f176156q0) {
                    GroupManagerActivity.this.s3(R.string.bok);
                } else if (GroupManagerActivity.this.f176142c0 != null) {
                    GroupManagerActivity.this.f176142c0.notifyDataSetChanged();
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class c extends Handler {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GroupManagerActivity.this);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("GroupManagerActivity", 2, "mWaitingDialogControlHandler operationFinished = " + GroupManagerActivity.this.f176157r0);
            }
            GroupManagerActivity.this.f176158s0 = true;
            if (GroupManagerActivity.this.f176157r0) {
                GroupManagerActivity.this.h3(true);
                return;
            }
            GroupManagerActivity.this.f176159t0.sendMessageDelayed(GroupManagerActivity.this.f176159t0.obtainMessage(0), 60000L);
            GroupManagerActivity.this.f176157r0 = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class d implements DialogInterface.OnDismissListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GroupManagerActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                GroupManagerActivity.this.f176144e0 = null;
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class e extends com.tencent.mobileqq.app.ar {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GroupManagerActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onAddGroupResp(boolean z16, GroupActionResp groupActionResp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), groupActionResp);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("GroupManagerActivity", 2, "onAddGroupResp isSuccess = " + z16);
            }
            GroupManagerActivity.this.h3(z16);
            GroupManagerActivity.this.f176157r0 = true;
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onDeleteGroupResp(boolean z16, GroupActionResp groupActionResp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), groupActionResp);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("GroupManagerActivity", 2, "onDeleteGroupResp isSuccess = " + z16);
            }
            GroupManagerActivity.this.h3(z16);
            GroupManagerActivity.this.f176157r0 = true;
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onRenameGroupResp(boolean z16, GroupActionResp groupActionResp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), groupActionResp);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("GroupManagerActivity", 2, "onRenameGroupResp isSuccess = " + z16);
            }
            GroupManagerActivity.this.h3(z16);
            GroupManagerActivity.this.f176157r0 = true;
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onResortGroupResp(boolean z16, GroupActionResp groupActionResp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), groupActionResp);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("GroupManagerActivity", 2, "onResortGroupResp isSuccess = " + z16);
            }
            GroupManagerActivity.this.h3(true);
            GroupManagerActivity.this.f176157r0 = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class f implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GroupManagerActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                GroupManagerActivity.this.finish();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class g implements AdapterView.OnItemClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.utils.ar f176171d;

        g(com.tencent.mobileqq.utils.ar arVar) {
            this.f176171d = arVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GroupManagerActivity.this, (Object) arVar);
            }
        }

        @Override // com.tencent.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, adapterView, view, Integer.valueOf(i3), Long.valueOf(j3));
                return;
            }
            int i16 = i3 - 1;
            if (i16 >= 0 && GroupManagerActivity.this.f176141b0.size() > i16) {
                GroupManagerActivity groupManagerActivity = GroupManagerActivity.this;
                groupManagerActivity.f176147h0 = groupManagerActivity.f176141b0.get(i16);
                GroupManagerActivity groupManagerActivity2 = GroupManagerActivity.this;
                groupManagerActivity2.f176148i0 = com.tencent.mobileqq.utils.ak.g(groupManagerActivity2, R.string.bod, R.string.boh, groupManagerActivity2.f176147h0.f(), this.f176171d, GroupManagerActivity.this.f176150k0, GroupManagerActivity.this.f176151l0);
                GroupManagerActivity.this.f176146g0 = 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class h implements DragSortListView.k {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GroupManagerActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.emosm.view.DragSortListView.k
        public void a(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
            }
        }

        @Override // com.tencent.mobileqq.emosm.view.DragSortListView.k
        public void b(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class i implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.utils.ar f176174d;

        i(com.tencent.mobileqq.utils.ar arVar) {
            this.f176174d = arVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GroupManagerActivity.this, (Object) arVar);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean z16;
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                int privilegeFlags = VasUtil.getSignedService(GroupManagerActivity.this.app).getVipStatus().getPrivilegeFlags(null);
                boolean z17 = true;
                if ((privilegeFlags & 2) != 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if ((privilegeFlags & 4) == 0) {
                    z17 = false;
                }
                if (!z16 && !z17) {
                    if (16 <= GroupManagerActivity.this.f176141b0.size()) {
                        QQToast qQToast = new QQToast(GroupManagerActivity.this);
                        qQToast.setDuration(2000);
                        qQToast.setToastMsg(R.string.f173214i34);
                        qQToast.show();
                    }
                    GroupManagerActivity groupManagerActivity = GroupManagerActivity.this;
                    groupManagerActivity.f176148i0 = com.tencent.mobileqq.utils.ak.g(groupManagerActivity, R.string.bob, R.string.boh, null, this.f176174d, groupManagerActivity.f176150k0, GroupManagerActivity.this.f176151l0);
                    GroupManagerActivity.this.f176146g0 = 0;
                } else {
                    if (30 <= GroupManagerActivity.this.f176141b0.size()) {
                        QQToast qQToast2 = new QQToast(GroupManagerActivity.this);
                        qQToast2.setDuration(2000);
                        qQToast2.setToastMsg(R.string.f173215i35);
                        qQToast2.show();
                    }
                    GroupManagerActivity groupManagerActivity2 = GroupManagerActivity.this;
                    groupManagerActivity2.f176148i0 = com.tencent.mobileqq.utils.ak.g(groupManagerActivity2, R.string.bob, R.string.boh, null, this.f176174d, groupManagerActivity2.f176150k0, GroupManagerActivity.this.f176151l0);
                    GroupManagerActivity.this.f176146g0 = 0;
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class j implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GroupManagerActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            String inputValue = GroupManagerActivity.this.f176148i0.getInputValue();
            if (inputValue.equals("")) {
                inputValue = GroupManagerActivity.this.getResources().getString(R.string.bnj);
            }
            byte b16 = 1;
            if (GroupManagerActivity.this.f176146g0 == 0) {
                if (GroupManagerActivity.this.f176141b0.size() > 0) {
                    List<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> list = GroupManagerActivity.this.f176141b0;
                    b16 = (byte) (list.get(list.size() - 1).h() + 1);
                }
                GroupManagerActivity groupManagerActivity = GroupManagerActivity.this;
                groupManagerActivity.f176156q0 = groupManagerActivity.e3(b16, inputValue);
                if (QLog.isColorLevel()) {
                    QLog.d("GroupManagerActivity", 2, "AddFriendGroup needShowDialog = " + GroupManagerActivity.this.f176156q0);
                }
                if (GroupManagerActivity.this.f176156q0) {
                    GroupManagerActivity.this.s3(R.string.boi);
                }
                ReportController.o(GroupManagerActivity.this.app, "CliOper", "", "", "category", "Add_category", 0, 0, "", "", "", "");
                return;
            }
            if (1 == GroupManagerActivity.this.f176146g0) {
                GroupManagerActivity groupManagerActivity2 = GroupManagerActivity.this;
                groupManagerActivity2.f176156q0 = groupManagerActivity2.l3((byte) groupManagerActivity2.f176147h0.d(), inputValue);
                if (QLog.isColorLevel()) {
                    QLog.d("GroupManagerActivity", 2, "EditeFriendGroup needShowDialog = " + GroupManagerActivity.this.f176156q0);
                }
                if (GroupManagerActivity.this.f176156q0) {
                    GroupManagerActivity.this.s3(R.string.bol);
                }
                ReportController.o(GroupManagerActivity.this.app, "CliOper", "", "", "category", "Name_category", 0, 0, "", "", "", "");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class k implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GroupManagerActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class l implements DragSortListView.h {
        static IPatchRedirector $redirector_;

        l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GroupManagerActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.emosm.view.DragSortListView.h
        public void drop(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            if (i3 == i16) {
                return;
            }
            int size = GroupManagerActivity.this.f176141b0.size();
            if (i3 < size && i16 < size) {
                GroupManagerActivity groupManagerActivity = GroupManagerActivity.this;
                groupManagerActivity.f176152m0 = new byte[size];
                groupManagerActivity.f176153n0 = new byte[size];
                for (int i17 = 0; i17 < size; i17++) {
                    GroupManagerActivity groupManagerActivity2 = GroupManagerActivity.this;
                    groupManagerActivity2.f176152m0[i17] = (byte) groupManagerActivity2.f176141b0.get(i17).d();
                }
                if (i16 < i3) {
                    for (int i18 = size - 1; i18 >= 0; i18--) {
                        if (i16 < i18 && i18 <= i3) {
                            GroupManagerActivity groupManagerActivity3 = GroupManagerActivity.this;
                            groupManagerActivity3.f176153n0[i18] = groupManagerActivity3.f176152m0[i18 - 1];
                        } else if (i18 == i16) {
                            GroupManagerActivity groupManagerActivity4 = GroupManagerActivity.this;
                            groupManagerActivity4.f176153n0[i18] = groupManagerActivity4.f176152m0[i3];
                        } else {
                            GroupManagerActivity groupManagerActivity5 = GroupManagerActivity.this;
                            groupManagerActivity5.f176153n0[i18] = groupManagerActivity5.f176152m0[i18];
                        }
                    }
                } else if (i3 < i16) {
                    for (int i19 = 0; i19 < size; i19++) {
                        if (i19 >= i3 && i16 >= i19) {
                            if (i19 == i16) {
                                GroupManagerActivity groupManagerActivity6 = GroupManagerActivity.this;
                                groupManagerActivity6.f176153n0[i19] = groupManagerActivity6.f176152m0[i3];
                            } else {
                                GroupManagerActivity groupManagerActivity7 = GroupManagerActivity.this;
                                groupManagerActivity7.f176153n0[i19] = groupManagerActivity7.f176152m0[i19 + 1];
                            }
                        } else {
                            GroupManagerActivity groupManagerActivity8 = GroupManagerActivity.this;
                            groupManagerActivity8.f176153n0[i19] = groupManagerActivity8.f176152m0[i19];
                        }
                    }
                }
                for (int i26 = 0; i26 < size; i26++) {
                    GroupManagerActivity.this.f176152m0[i26] = (byte) i26;
                }
                if (i16 < i3) {
                    GroupManagerActivity.this.f176141b0.add(i16, GroupManagerActivity.this.f176141b0.remove(i3));
                } else if (i3 < i16) {
                    GroupManagerActivity.this.f176141b0.add(i16, GroupManagerActivity.this.f176141b0.remove(i3));
                }
                GroupManagerActivity.this.f176142c0.notifyDataSetChanged();
                if (QLog.isColorLevel()) {
                    QLog.d("GroupManagerActivity", 2, "DragSortListView.DropListener onDrop groupIdList = " + Arrays.toString(GroupManagerActivity.this.f176153n0));
                    QLog.d("GroupManagerActivity", 2, "DragSortListView.DropListener onDrop sortIdList = " + Arrays.toString(GroupManagerActivity.this.f176152m0));
                }
                GroupManagerActivity groupManagerActivity9 = GroupManagerActivity.this;
                groupManagerActivity9.f176156q0 = groupManagerActivity9.n3(groupManagerActivity9.f176153n0, groupManagerActivity9.f176152m0);
                if (QLog.isColorLevel()) {
                    QLog.d("GroupManagerActivity", 2, "SortFriendGroup needShowDialog = " + GroupManagerActivity.this.f176156q0);
                }
                if (GroupManagerActivity.this.f176156q0) {
                    GroupManagerActivity.this.s3(R.string.bon);
                } else {
                    GroupManagerActivity.this.refresh();
                }
                ReportController.o(GroupManagerActivity.this.app, "CliOper", "", "", "category", "Move_category", 0, 0, "", "", "", "");
                return;
            }
            QLog.d("GroupManagerActivity", 2, "from >= length || to >= lengt");
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class m implements DragSortListView.l {
        static IPatchRedirector $redirector_;

        m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GroupManagerActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.emosm.view.DragSortListView.l
        public void remove(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("GroupManagerActivity", 2, "RemoveListener which = " + i3);
            }
            int i16 = i3 - 1;
            if (i16 >= 0 && i16 < GroupManagerActivity.this.f176141b0.size()) {
                com.tencent.qqnt.ntrelation.friendsinfo.bean.b bVar = GroupManagerActivity.this.f176141b0.get(i16);
                byte d16 = (byte) bVar.d();
                if (QLog.isColorLevel()) {
                    QLog.d("GroupManagerActivity", 2, "RemoveListener remove groupId :" + ((int) d16));
                    QLog.d("GroupManagerActivity", 2, "RemoveListener remove friend_count :" + bVar.e());
                }
                if (d16 != 0) {
                    GroupManagerActivity.this.r3(d16);
                    ReportController.o(GroupManagerActivity.this.app, "CliOper", "", "", "category", "Delete_category", 0, 0, "", "", "", "");
                } else {
                    QQToastUtil.showQQToastInUiThread(0, HardCodeUtil.qqStr(R.string.i3a));
                }
            }
        }
    }

    public GroupManagerActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f176149j0 = new hx3.b() { // from class: com.tencent.mobileqq.activity.GroupManagerActivity.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GroupManagerActivity.this);
                }
            }

            @Override // hx3.b
            public void onQueryResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e eVar) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) eVar);
                } else if (eVar != null && eVar.a() == 0 && eVar.b() != null) {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable(eVar) { // from class: com.tencent.mobileqq.activity.GroupManagerActivity.1.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ com.tencent.qqnt.ntrelation.friendsinfo.bean.e f176162d;

                        {
                            this.f176162d = eVar;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, (Object) eVar);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                                return;
                            }
                            GroupManagerActivity.this.f176141b0.clear();
                            GroupManagerActivity.this.f176141b0.addAll(this.f176162d.b());
                            GroupManagerActivity.this.i3();
                            if (GroupManagerActivity.this.f176142c0 == null) {
                                GroupManagerActivity groupManagerActivity = GroupManagerActivity.this;
                                GroupManagerActivity groupManagerActivity2 = GroupManagerActivity.this;
                                groupManagerActivity.f176142c0 = new com.tencent.mobileqq.adapter.r(groupManagerActivity2, groupManagerActivity2.f176141b0, groupManagerActivity2.f176140a0);
                                GroupManagerActivity.this.f176140a0.setAdapter((ListAdapter) GroupManagerActivity.this.f176142c0);
                            } else {
                                GroupManagerActivity.this.f176142c0.notifyDataSetChanged();
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d("GroupManagerActivity", 2, "End Refresh************************ size = " + GroupManagerActivity.this.f176141b0.size());
                                String str = "[";
                                for (int i3 = 0; i3 < GroupManagerActivity.this.f176141b0.size(); i3++) {
                                    str = str + ((int) ((byte) GroupManagerActivity.this.f176141b0.get(i3).d())) + "   ";
                                }
                                QLog.d("GroupManagerActivity", 2, "End Refresh************************ s = " + (str + "]"));
                            }
                        }
                    });
                }
            }
        };
        this.f176150k0 = new j();
        this.f176151l0 = new k();
        this.f176152m0 = null;
        this.f176153n0 = null;
        this.f176154o0 = new l();
        this.f176155p0 = new m();
        this.f176159t0 = new c();
        this.f176160u0 = new e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i3() {
        Iterator<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> it = this.f176141b0.iterator();
        while (it.hasNext()) {
            if (it.next().d() == ((IFriendsTABService) QRoute.api(IFriendsTABService.class)).getSpecialCareCategoryId()) {
                it.remove();
                return;
            }
        }
    }

    private void initTitleBar() {
        this.leftView.setVisibility(8);
        setRightButton(R.string.bog, new f());
        setTitle(R.string.bof);
    }

    private void initUI() {
        DragSortListView dragSortListView = (DragSortListView) findViewById(android.R.id.list);
        this.f176140a0 = dragSortListView;
        com.tencent.mobileqq.emosm.view.c buildController = buildController(dragSortListView);
        this.f176140a0.setFloatViewManager(buildController);
        this.f176140a0.setOnTouchListener(buildController);
        this.f176140a0.setDropListener(this.f176154o0);
        this.f176140a0.setRemoveListener(this.f176155p0);
        com.tencent.mobileqq.utils.ar arVar = new com.tencent.mobileqq.utils.ar();
        this.f176140a0.setOnItemClickListener(new g(arVar));
        this.f176140a0.setLeftEventListener(new h());
        this.f176140a0.setVerticalScrollBarEnabled(false);
        View inflate = getLayoutInflater().inflate(R.layout.f168013oz, (ViewGroup) null);
        this.f176140a0.addHeaderView(inflate);
        inflate.findViewById(R.id.f165402cy2).setOnClickListener(new i(arVar));
        View view = new View(getActivity());
        view.setLayoutParams(new AbsListView.LayoutParams(-1, (int) (getResources().getDisplayMetrics().density * 10.0f)));
        this.f176140a0.addFooterView(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r3(byte b16) {
        g3();
        ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(this, null);
        actionSheet.setMainTitle(R.string.boj);
        actionSheet.addButton(R.string.boc, 3);
        actionSheet.addCancelButton(R.string.boe);
        actionSheet.setOnDismissListener(new a());
        actionSheet.setOnButtonClickListener(new b(b16));
        this.f176143d0 = actionSheet;
        actionSheet.show();
    }

    public static void startGroupManager(Activity activity) {
        activity.startActivity(new Intent(activity, (Class<?>) GroupManagerActivity.class));
        activity.overridePendingTransition(R.anim.f154424l, R.anim.f154425m);
    }

    public com.tencent.mobileqq.emosm.view.c buildController(DragSortListView dragSortListView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (com.tencent.mobileqq.emosm.view.c) iPatchRedirector.redirect((short) 9, (Object) this, (Object) dragSortListView);
        }
        com.tencent.mobileqq.emosm.view.c cVar = new com.tencent.mobileqq.emosm.view.c(dragSortListView);
        cVar.e(R.id.f165020bq3);
        cVar.d(R.id.ayu);
        cVar.g(true);
        cVar.j(true);
        cVar.f(0);
        cVar.h(0);
        return cVar;
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d("GroupManagerActivity", 2, "onCreate");
        }
        super.doOnCreate(bundle);
        com.tencent.relation.common.utils.a.a(this, -1, 1);
        this.f176145f0 = getResources().getDimensionPixelSize(R.dimen.title_bar_height);
        super.setContentView(R.layout.av5);
        initTitleBar();
        initUI();
        this.app.addObserver(this.f176160u0);
        this.f176141b0 = new ArrayList();
        j3(true);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("GroupManagerActivity", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
        super.doOnDestroy();
        this.f176159t0.removeMessages(0);
        this.app.removeObserver(this.f176160u0);
        ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).unregisterFriendCategoryInfoCallback("GroupManagerActivity", this.f176149j0);
    }

    public boolean e3(byte b16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, this, Byte.valueOf(b16), str)).booleanValue();
        }
        if (!NetworkUtil.isNetSupport(getApplication())) {
            QQToast.makeText(BaseApplicationImpl.sApplication, R.string.f171137ci2, 0).show();
            return false;
        }
        FriendListHandler friendListHandler = (FriendListHandler) this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
        if (friendListHandler == null) {
            return false;
        }
        friendListHandler.addFriendGroup(b16, str);
        return true;
    }

    public boolean f3(byte b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, this, Byte.valueOf(b16))).booleanValue();
        }
        if (!NetworkUtil.isNetSupport(getApplication())) {
            QQToast.makeText(BaseApplicationImpl.sApplication, R.string.f171137ci2, 0).show();
            return false;
        }
        FriendListHandler friendListHandler = (FriendListHandler) this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
        if (friendListHandler == null) {
            return false;
        }
        friendListHandler.deleteFriendGroup(b16);
        return true;
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.finish();
            overridePendingTransition(R.anim.f154422j, R.anim.f154423k);
        }
    }

    void g3() {
        Dialog dialog = this.f176143d0;
        if (dialog != null) {
            if (dialog.isShowing()) {
                this.f176143d0.dismiss();
            }
            this.f176143d0 = null;
        }
    }

    void h3(boolean z16) {
        Dialog dialog;
        if (QLog.isColorLevel()) {
            QLog.d("GroupManagerActivity", 2, "dismissWaitingDialog delayPassed = " + this.f176158s0);
        }
        if (this.f176158s0 && (dialog = this.f176144e0) != null) {
            if (dialog.isShowing()) {
                this.f176144e0.dismiss();
            }
            this.f176144e0 = null;
            if (z16) {
                refresh();
            }
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (456 == i3) {
            refresh();
            return false;
        }
        if (457 == i3) {
            p3();
            return false;
        }
        return false;
    }

    void j3(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("GroupManagerActivity", 2, "/************************Start Refresh:");
        }
        ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).friendsCategoryInfo(z16, "GroupManagerActivity", false, this.f176149j0);
    }

    public boolean l3(byte b16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, this, Byte.valueOf(b16), str)).booleanValue();
        }
        if (!NetworkUtil.isNetSupport(getApplication())) {
            QQToast.makeText(BaseApplicationImpl.sApplication, R.string.f171137ci2, 0).show();
            return false;
        }
        FriendListHandler friendListHandler = (FriendListHandler) this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
        if (friendListHandler == null) {
            return false;
        }
        friendListHandler.renameFriendGroup(b16, str);
        return true;
    }

    public boolean n3(byte[] bArr, byte[] bArr2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) bArr, (Object) bArr2)).booleanValue();
        }
        if (!NetworkUtil.isNetSupport(getApplication())) {
            QQToast.makeText(BaseApplicationImpl.sApplication, R.string.f171137ci2, 0).show();
            return false;
        }
        FriendListHandler friendListHandler = (FriendListHandler) this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
        if (friendListHandler == null) {
            return false;
        }
        friendListHandler.resortFriendGroup(bArr, bArr2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        boolean onBackEvent = super.onBackEvent();
        overridePendingTransition(R.anim.f154422j, R.anim.f154423k);
        return onBackEvent;
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @SuppressLint({"NewApi"})
    void p3() {
        if (QLog.isColorLevel()) {
            QLog.d("GroupManagerActivity", 2, "scrollToBottom:" + this.f176141b0.size());
        }
        this.f176140a0.smoothScrollToPosition(this.f176141b0.size());
    }

    void s3(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("GroupManagerActivity", 2, "showWaitingDialog");
        }
        h3(false);
        Dialog dialog = this.f176144e0;
        if (dialog != null && dialog.isShowing()) {
            if (QLog.isColorLevel()) {
                QLog.d("GroupManagerActivity", 2, "WatingDialog is showing already!");
                return;
            }
            return;
        }
        QQProgressDialog qQProgressDialog = new QQProgressDialog(this, this.f176145f0);
        qQProgressDialog.setMessage(i3);
        this.f176144e0 = qQProgressDialog;
        qQProgressDialog.setOnDismissListener(new d());
        this.f176144e0.show();
        this.f176157r0 = false;
        this.f176159t0.sendMessageDelayed(this.f176159t0.obtainMessage(0), 500L);
    }

    void refresh() {
    }
}
