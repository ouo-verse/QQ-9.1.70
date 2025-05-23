package com.tencent.mobileqq.troop.createNewTroop;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.pad.m;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.o;
import com.tencent.mobileqq.search.api.IQQSearchApi;
import com.tencent.mobileqq.search.api.ISearchViewCreator;
import com.tencent.mobileqq.search.k;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.ITroopCreateInfoService;
import com.tencent.mobileqq.troop.api.troopcreate.IQQBase;
import com.tencent.mobileqq.troop.selecttroopmember.a;
import com.tencent.mobileqq.troop.troopcreate.api.IRelationFriendsTroopViewHelper;
import com.tencent.mobileqq.troop.troopcreate.api.ITroopCreatePage;
import com.tencent.mobileqq.troop.troopcreate.api.ITroopCreateService;
import com.tencent.mobileqq.troop.troopcreate.tempapi.ICreateTroopForUI;
import com.tencent.mobileqq.troop.troopcreate.ui.AbsNewTroopBaseView;
import com.tencent.mobileqq.troop.troopcreate.ui.RelationFriendsTroopViewHelper;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.InputMethodRelativeLayout;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.search.ActionCallbackAdapter;
import com.tencent.mobileqq.widget.search.QUISearchBar;
import com.tencent.mobileqq.widget.search.ext.ChatUserListExt;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qui.quiblurview.QQBlur;
import com.tencent.qui.quiblurview.QQBlurView;
import com.tencent.util.InputMethodUtil;
import com.tencent.widget.AbsListView;
import com.tencent.widget.PinnedFooterExpandableListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes19.dex */
public class NewTroopContactView extends AbsNewTroopBaseView implements View.OnClickListener, ITroopCreateInfoService.a {
    static IPatchRedirector $redirector_;
    protected FrameLayout C;
    private QUISearchBar D;
    private ChatUserListExt<ResultRecord> E;
    private com.tencent.mobileqq.troop.selecttroopmember.a F;
    InputMethodRelativeLayout G;
    protected View H;
    protected int I;
    protected int J;
    protected com.tencent.mobileqq.troop.troopcreate.ui.a K;
    public ArrayList<ResultRecord> L;
    long M;
    protected float N;
    protected Dialog P;
    private ICreateTroopForUI Q;
    protected IFaceDecoder R;
    protected Bitmap S;
    protected InputMethodManager T;
    protected long U;
    protected PinnedFooterExpandableListView V;
    public ContactListAdapter W;

    /* renamed from: a0, reason: collision with root package name */
    protected RelativeLayout f294704a0;

    /* renamed from: b0, reason: collision with root package name */
    protected Button f294705b0;

    /* renamed from: c0, reason: collision with root package name */
    protected Button f294706c0;

    /* renamed from: d0, reason: collision with root package name */
    protected Button f294707d0;

    /* renamed from: e0, reason: collision with root package name */
    protected Button f294708e0;

    /* renamed from: f, reason: collision with root package name */
    private IQQBase f294709f;

    /* renamed from: f0, reason: collision with root package name */
    protected Button f294710f0;

    /* renamed from: g0, reason: collision with root package name */
    protected Button f294711g0;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.mobileqq.search.view.f f294712h;

    /* renamed from: h0, reason: collision with root package name */
    protected com.tencent.mobileqq.friend.observer.a f294713h0;

    /* renamed from: i, reason: collision with root package name */
    public ArrayList<String> f294714i;

    /* renamed from: i0, reason: collision with root package name */
    protected boolean f294715i0;

    /* renamed from: j0, reason: collision with root package name */
    protected QQBlurView f294716j0;

    /* renamed from: k0, reason: collision with root package name */
    protected int f294717k0;

    /* renamed from: l0, reason: collision with root package name */
    RelationFriendsTroopViewHelper f294718l0;

    /* renamed from: m, reason: collision with root package name */
    public ArrayList<String> f294719m;

    /* renamed from: m0, reason: collision with root package name */
    private boolean f294720m0;

    /* renamed from: n0, reason: collision with root package name */
    private boolean f294721n0;

    /* renamed from: o0, reason: collision with root package name */
    private boolean f294722o0;

    /* renamed from: p0, reason: collision with root package name */
    private List<String> f294723p0;

    /* renamed from: q0, reason: collision with root package name */
    private boolean f294724q0;

    /* renamed from: r0, reason: collision with root package name */
    private final QUISearchBar.ActionCallback f294725r0;

    /* renamed from: s0, reason: collision with root package name */
    public final a.InterfaceViewOnClickListenerC8768a f294726s0;

    /* renamed from: t0, reason: collision with root package name */
    com.tencent.mobileqq.search.view.d f294727t0;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a extends ActionCallbackAdapter {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NewTroopContactView.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.search.ActionCallbackAdapter, com.tencent.mobileqq.widget.search.QUISearchBar.ActionCallback
        public void onSearch() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            String obj = NewTroopContactView.this.D.getInputWidget().getText().toString();
            if (TextUtils.isEmpty(obj)) {
                if (NewTroopContactView.this.f294722o0) {
                    NewTroopContactView.this.f294722o0 = false;
                    return;
                }
                if (NewTroopContactView.this.C.getVisibility() == 0 && NewTroopContactView.this.f294712h != null) {
                    NewTroopContactView.this.f294712h.y8();
                }
                NewTroopContactView.this.C.setVisibility(8);
                NewTroopContactView.this.V.setVisibility(0);
            } else {
                if (NewTroopContactView.this.C.getVisibility() == 8) {
                    NewTroopContactView.this.D();
                }
                NewTroopContactView.this.C.setVisibility(0);
                NewTroopContactView.this.V.setVisibility(8);
            }
            if (NewTroopContactView.this.f294712h != null) {
                NewTroopContactView.this.f294712h.startSearch(obj);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class b implements a.InterfaceViewOnClickListenerC8768a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NewTroopContactView.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.selecttroopmember.a.InterfaceViewOnClickListenerC8768a
        public void Mf(ResultRecord resultRecord) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) resultRecord);
                return;
            }
            QLog.i("createNewTroop.NewTroopContactView", 1, "[onItemDeleted] " + resultRecord);
            String str = resultRecord.uin;
            if (NewTroopContactView.this.A(str)) {
                NewTroopContactView.this.L(str);
                NewTroopContactView.this.W.notifyDataSetChanged();
                NewTroopContactView.this.P();
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
            } else {
                Mf((ResultRecord) view.getTag());
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class c extends com.tencent.mobileqq.friend.observer.a {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NewTroopContactView.this);
            }
        }

        @Override // com.tencent.mobileqq.friend.observer.a
        protected void onUpdateFriendList(boolean z16, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            } else if (z16) {
                NewTroopContactView.this.W.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class d implements IRelationFriendsTroopViewHelper.a {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NewTroopContactView.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.troopcreate.api.IRelationFriendsTroopViewHelper.a
        public ArrayList<ResultRecord> a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (ArrayList) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return NewTroopContactView.this.L;
        }

        @Override // com.tencent.mobileqq.troop.troopcreate.api.IRelationFriendsTroopViewHelper.a
        public ArrayList<String> b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (ArrayList) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            ArrayList<String> arrayList = new ArrayList<>();
            for (int i3 = 0; i3 < NewTroopContactView.this.L.size(); i3++) {
                arrayList.add(NewTroopContactView.this.L.get(i3).uin);
            }
            return arrayList;
        }

        @Override // com.tencent.mobileqq.troop.troopcreate.api.IRelationFriendsTroopViewHelper.a
        public void c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            NewTroopContactView.this.W.notifyDataSetChanged();
            if (NewTroopContactView.this.W.getGroupCount() > 0) {
                com.tencent.qqnt.ntrelation.friendsinfo.bean.b n3 = NewTroopContactView.this.W.n(1007L);
                com.tencent.qqnt.ntrelation.friendsinfo.bean.b n16 = NewTroopContactView.this.W.n(1008L);
                if (n3 != null || n16 != null) {
                    NewTroopContactView.this.V.expandGroup(0);
                    NewTroopContactView.this.V.setIsNeedScrollPositionTop(true);
                    NewTroopContactView.this.V.smoothScrollToPositionFromTop(1, 0, 0);
                }
                if (n3 != null) {
                    NewTroopContactView.this.f294718l0.l();
                }
                if (n16 != null) {
                    NewTroopContactView.this.f294718l0.n();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class e implements QQBlur.c {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NewTroopContactView.this);
            }
        }

        @Override // com.tencent.qui.quiblurview.QQBlur.c
        public void a(Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle);
            }
        }

        @Override // com.tencent.qui.quiblurview.QQBlur.c
        public void b(Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class f implements k {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NewTroopContactView.this);
            }
        }

        @Override // com.tencent.mobileqq.search.k
        public void a(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, z16);
                return;
            }
            QLog.i("createNewTroop.NewTroopContactView", 1, "setSearchFragmentVisibility " + z16);
            if (!z16) {
                NewTroopContactView.this.J();
            } else if (NewTroopContactView.this.C.getVisibility() == 8) {
                NewTroopContactView.this.C.setVisibility(0);
                if (NewTroopContactView.this.f294712h != null) {
                    NewTroopContactView.this.f294712h.tb();
                }
            }
        }

        @Override // com.tencent.mobileqq.search.k
        public void b(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class g implements com.tencent.mobileqq.search.view.d {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NewTroopContactView.this);
            }
        }

        private int a(ArrayList<ResultRecord> arrayList, String str) {
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (arrayList.get(i3).uin.equals(str)) {
                    return i3;
                }
            }
            return -1;
        }

        @Override // com.tencent.mobileqq.search.view.d
        public void onAction(View view) {
            String str;
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                return;
            }
            com.tencent.mobileqq.search.model.k kVar = (com.tencent.mobileqq.search.model.k) view.getTag(R.id.kxb);
            if (kVar == null) {
                return;
            }
            String uin = kVar.getUin();
            String charSequence = kVar.getTitleSpans().toString();
            if (NewTroopContactView.this.Q != null) {
                str = NewTroopContactView.this.Q.getTroopUinFromModel(kVar);
            } else {
                str = "-1";
            }
            String str2 = str;
            ArrayList<String> arrayList = NewTroopContactView.this.f294714i;
            if ((arrayList == null || !arrayList.contains(uin)) && !NewTroopContactView.this.A(uin) && !NewTroopContactView.this.z()) {
                if (NewTroopContactView.this.Q != null) {
                    i3 = NewTroopContactView.this.Q.getUinTypeFromModel(kVar);
                } else {
                    i3 = -1;
                }
                if (i3 != -1) {
                    NewTroopContactView.this.L.add(new ResultRecord(uin, charSequence, i3, str2, ""));
                }
                NewTroopContactView.this.I();
                NewTroopContactView.this.W.notifyDataSetChanged();
                if (NewTroopContactView.this.f294712h != null && NewTroopContactView.this.f294712h.K9() && NewTroopContactView.this.f294712h.L5()) {
                    NewTroopContactView.this.f294722o0 = true;
                }
                NewTroopContactView.this.D.getInputWidget().setText("");
                NewTroopContactView.this.P();
            }
        }

        @Override // com.tencent.mobileqq.search.view.d
        public void selectedItemClick(String str, int i3, boolean z16) {
            int a16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), Boolean.valueOf(z16));
            } else {
                if (!z16 || (a16 = a(NewTroopContactView.this.L, str)) == -1) {
                    return;
                }
                NewTroopContactView.this.L.remove(a16);
                NewTroopContactView.this.I();
                NewTroopContactView.this.W.notifyDataSetChanged();
            }
        }
    }

    public NewTroopContactView(QBaseActivity qBaseActivity, com.tencent.mobileqq.troop.troopcreate.ui.a aVar) {
        super(qBaseActivity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qBaseActivity, (Object) aVar);
            return;
        }
        this.L = new ArrayList<>();
        this.M = 0L;
        this.T = null;
        this.U = 0L;
        this.f294717k0 = 0;
        this.f294720m0 = true;
        this.f294721n0 = true;
        this.f294722o0 = false;
        this.f294723p0 = new ArrayList();
        this.f294724q0 = ((IQQSearchApi) QRoute.api(IQQSearchApi.class)).enableDefaultSingleMode();
        this.f294725r0 = new a();
        this.f294726s0 = new b();
        this.f294727t0 = new g();
        this.Q = (ICreateTroopForUI) this.f300108e.getRuntimeService(ICreateTroopForUI.class, "");
        this.f294709f = (IQQBase) this.f300108e.getRuntimeService(IQQBase.class, "");
        this.K = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B(View view, boolean z16) {
        if (z16) {
            N();
        }
    }

    private k C() {
        return new f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        this.f294723p0.clear();
        this.f294723p0.addAll(v());
        com.tencent.mobileqq.search.view.f fVar = this.f294712h;
        if (fVar != null) {
            fVar.B5(v(), u());
            this.f294712h.tb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        InputMethodUtil.hide(this.D.getInputWidget());
        this.D.getInputWidget().setText("");
        this.D.getInputWidget().clearFocus();
        FrameLayout frameLayout = this.C;
        if (frameLayout != null && frameLayout.getVisibility() == 0) {
            this.C.setVisibility(8);
            com.tencent.mobileqq.search.view.f fVar = this.f294712h;
            if (fVar != null) {
                fVar.y8();
            }
        }
    }

    private void K(int i3) {
        String format;
        if (i3 <= 0) {
            String string = getContext().getString(R.string.f2327675f);
            this.f294711g0.setText(string);
            this.f294711g0.setContentDescription(string);
            this.f294711g0.setEnabled(false);
            return;
        }
        this.f294711g0.setEnabled(true);
        if (i3 == 1) {
            format = getContext().getString(R.string.f2327575e);
        } else {
            format = String.format(getContext().getString(R.string.f2327775g), Integer.valueOf(i3));
        }
        this.f294711g0.setText(format);
        this.f294711g0.setContentDescription(format);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(String str) {
        for (int i3 = 0; i3 < this.L.size(); i3++) {
            if (this.L.get(i3).uin.equals(str)) {
                this.L.remove(i3);
            }
        }
        this.f294723p0.remove(str);
        I();
    }

    private void M(View view, float f16) {
        if (view == null) {
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        marginLayoutParams.topMargin = Utils.n(f16, getResources());
        view.setLayoutParams(marginLayoutParams);
    }

    private void N() {
        k kVar;
        boolean s16 = s();
        if (s16) {
            kVar = C();
        } else {
            kVar = null;
        }
        com.tencent.mobileqq.search.view.f createNTContactSearchFragment = ((ISearchViewCreator) QRoute.api(ISearchViewCreator.class)).createNTContactSearchFragment(-1, 4194309, null, this.f294719m, !s16, 0, -1L, this.f294727t0, s16, kVar);
        if (createNTContactSearchFragment != null) {
            createNTContactSearchFragment.z7(false);
            createNTContactSearchFragment.e2(true);
            createNTContactSearchFragment.B5(v(), u());
            FragmentTransaction beginTransaction = ((FragmentActivity) getContext()).getSupportFragmentManager().beginTransaction();
            com.tencent.mobileqq.search.view.f fVar = this.f294712h;
            if (fVar != null) {
                beginTransaction.remove(fVar.getFragment());
            }
            beginTransaction.add(R.id.result_layout, createNTContactSearchFragment.getFragment());
            beginTransaction.commitAllowingStateLoss();
            this.f294712h = createNTContactSearchFragment;
        }
    }

    private void O(String str) {
        if (System.currentTimeMillis() - this.U > 2000) {
            QQToast.makeText(this.f300107d, str, 2000).show(this.f300107d.getTitleBarHeight());
            this.U = System.currentTimeMillis();
        }
    }

    private void Q(ArrayList<ResultRecord> arrayList) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("group_type", 1);
            StringBuilder sb5 = new StringBuilder();
            IQQBase iQQBase = this.f294709f;
            AppInterface appInterface = this.f300108e;
            sb5.append(iQQBase.getAccountNickName(appInterface, appInterface.getCurrentAccountUin()));
            sb5.append(HardCodeUtil.qqStr(R.string.f172240or2));
            jSONObject.put("name", sb5.toString());
            jSONObject.put("classify", 10010);
            jSONObject.put("isJumpAio", 1);
            jSONObject.put("create_source", this.f294717k0);
            jSONObject.put("new_create_source", 2);
        } catch (JSONException e16) {
            QLog.e("createNewTroop.NewTroopContactView", 1, e16, new Object[0]);
        }
        ((ITroopCreateInfoService) this.f300108e.getRuntimeService(ITroopCreateInfoService.class, "")).refreshCreateInfo(jSONObject.toString(), 5);
        ((ITroopCreateService) this.f300108e.getRuntimeService(ITroopCreateService.class, "")).startCreateTroop(this, this.f300107d, arrayList);
        ReportController.o(this.f300108e, "dc00899", "Grp_create_new", "", "create_page", "clk_now", 0, 0, "", "" + this.f294717k0, "", "");
    }

    private void R() {
        Intent intent = new Intent();
        intent.putExtra("create_source", 3);
        com.tencent.mobileqq.troop.troopcreate.a.k(this.f300107d, intent, RouterConstants.UI_ROUTE_FACE2FACE_DISCUSSION);
        ReportController.o(this.f300108e, "dc00899", "Grp_create_new", "", "create_page", "clk_face", 0, 0, "", "" + this.f294717k0, "", "");
    }

    private void T(ResultRecord resultRecord) {
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(getContext(), RouterConstants.UI_ROUTE_CHAT_ACTVITY);
        activityURIRequest.extra().putBoolean("open_chatfragment", true);
        activityURIRequest.extra().putString("uinname", resultRecord.name);
        activityURIRequest.extra().putString("uin", resultRecord.uin);
        activityURIRequest.extra().putInt("uintype", 0);
        activityURIRequest.setFlags(268435456);
        QRoute.startUri(activityURIRequest, (o) null);
        r();
    }

    private void r() {
        if (!AppSetting.t(this.f300107d) || !m.b(this.f300107d)) {
            this.f300107d.finish();
        }
    }

    private boolean s() {
        return this.f294724q0;
    }

    private List<String> u() {
        if (s()) {
            ArrayList<String> arrayList = this.f294714i;
            if (arrayList != null) {
                this.f294723p0.addAll(arrayList);
            }
            return this.f294723p0;
        }
        return this.f294714i;
    }

    @TargetApi(19)
    private void w() {
        boolean z16;
        boolean isDefaultOrDIYTheme = ThemeUtil.isDefaultOrDIYTheme(false);
        this.f294715i0 = isDefaultOrDIYTheme;
        if (!isDefaultOrDIYTheme) {
            this.f294716j0.setVisibility(8);
            if ("1103".equals(ThemeUtil.curThemeId)) {
                this.H.setBackgroundColor(-15921907);
                return;
            }
            return;
        }
        this.f294716j0.setVisibility(0);
        this.f294716j0.j(this.V);
        QQBlurView qQBlurView = this.f294716j0;
        qQBlurView.m(qQBlurView);
        this.f294716j0.p(-1);
        QQBlurView qQBlurView2 = this.f294716j0;
        if (Build.VERSION.SDK_INT >= 24) {
            z16 = true;
        } else {
            z16 = false;
        }
        qQBlurView2.setEnableBlur(z16);
        this.f294716j0.k(0);
        this.f294716j0.A(8.0f);
        this.f294716j0.l(8);
        this.f294716j0.setDisableBlurDrawableRes(R.drawable.skin_list_item_normal_theme_version2);
        this.f294716j0.q(new e());
        this.f294716j0.x();
        this.f294716j0.onResume();
        this.H.setBackgroundColor(0);
    }

    private void x() {
        if (QLog.isColorLevel()) {
            QLog.i("createNewTroop.NewTroopContactView", 1, "[initFriendTeamList] start");
        }
        ContactListAdapter contactListAdapter = new ContactListAdapter(this, this.f300108e, this.V, this.f300107d.getIntent().getBooleanExtra(ISelectMemberActivityConstants.PARAMS_KEY_IS_EXPAND_FIRST, true));
        this.W = contactListAdapter;
        this.V.setAdapter(contactListAdapter);
        this.V.setSelector(R.color.ajr);
        this.V.setGroupIndicator(this.f300107d.getResources().getDrawable(R.drawable.f160570ki));
        this.V.setOnScrollListener(this.W);
        c cVar = new c();
        this.f294713h0 = cVar;
        this.f300108e.addObserver(cVar);
        RelationFriendsTroopViewHelper relationFriendsTroopViewHelper = new RelationFriendsTroopViewHelper(this.f300108e, this.V, new d());
        this.f294718l0 = relationFriendsTroopViewHelper;
        this.W.A(relationFriendsTroopViewHelper);
    }

    public boolean A(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) str)).booleanValue();
        }
        for (int i3 = 0; i3 < this.L.size(); i3++) {
            if (this.L.get(i3).uin.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public void E(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        if (i3 == 1300 && i16 == -1 && intent != null) {
            ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(ISelectMemberActivityConstants.PARAM_RESULT_SET);
            if (parcelableArrayListExtra != null && !parcelableArrayListExtra.isEmpty()) {
                q(parcelableArrayListExtra, true);
            }
            int intExtra = intent.getIntExtra(ISelectMemberActivityConstants.PARAM_ENTRANCE, 0);
            String stringExtra = intent.getStringExtra(ISelectMemberActivityConstants.Result_Uin);
            if (intExtra == 27 && !TextUtils.isEmpty(stringExtra)) {
                r();
                ((ITroopCreateService) this.f300108e.getRuntimeService(ITroopCreateService.class, "")).jumpToAioAfterCreated(stringExtra, intent.getStringExtra(ISelectMemberActivityConstants.Result_Name), intent.getBooleanExtra("isReuse", false), false);
            }
        }
    }

    public void F() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (this.D.getInputWidget().hasFocus()) {
            J();
        }
        Dialog dialog = this.P;
        if (dialog != null && dialog.isShowing()) {
            this.P.dismiss();
        }
        IFaceDecoder iFaceDecoder = this.R;
        if (iFaceDecoder != null) {
            iFaceDecoder.destory();
        }
        ITroopCreateService iTroopCreateService = (ITroopCreateService) this.f300108e.getRuntimeService(ITroopCreateService.class, "");
        if (iTroopCreateService != null) {
            iTroopCreateService.releaseCreateCallback(this);
        }
        this.f300108e.removeObserver(this.f294713h0);
        InputMethodRelativeLayout inputMethodRelativeLayout = this.G;
        if (inputMethodRelativeLayout != null) {
            inputMethodRelativeLayout.g();
        }
    }

    public boolean G(String str, String str2, int i3, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, this, str, str2, Integer.valueOf(i3), str3)).booleanValue();
        }
        if (A(str)) {
            L(str);
        } else if (!z()) {
            this.L.add(new ResultRecord(str, str2, i3, str3, ""));
            I();
            return z16;
        }
        z16 = false;
        I();
        return z16;
    }

    public void H(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) str);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.i("createNewTroop.NewTroopContactView", 2, "onRelationTroopItemClick: empty");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("createNewTroop.NewTroopContactView", 2, "onRelationTroopItemClick: troopUin:" + str);
        }
        onReusedTroop(str);
        this.f294718l0.m();
    }

    public void I() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        com.tencent.mobileqq.search.view.f fVar = this.f294712h;
        if (fVar != null) {
            fVar.B5(v(), u());
        }
        K(this.L.size());
        this.F.updateData(this.L);
    }

    public void P() {
        ResultRecord resultRecord;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        if (this.L.size() > 0) {
            resultRecord = this.L.get(r0.size() - 1);
        } else {
            resultRecord = null;
        }
        this.f294718l0.i(resultRecord);
    }

    public void S() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        int size = this.L.size();
        if (size >= 1 && System.currentTimeMillis() - this.M >= 1500) {
            this.M = System.currentTimeMillis();
            ArrayList<ResultRecord> arrayList = new ArrayList<>(size);
            arrayList.addAll(this.L);
            if (size == 1) {
                T(arrayList.get(0));
            } else {
                Q(arrayList);
            }
            HashMap hashMap = new HashMap();
            hashMap.put("choose_members_num", Integer.toString(size));
            VideoReport.setElementParams(this.f294711g0, hashMap);
        }
    }

    public void U() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra(ISelectMemberActivityConstants.PARAM_ONLY_TROOP_OR_DISCUSSION_MEMBER, true);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_ENTRANCE, 27);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_SELECTED_RECORDS_FOR_CREATE_DISCURRION, this.L);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_OVERLOAD_TIPS_INCLUDE_DEFAULT_COUNT, true);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_TITLE, this.f300107d.getString(R.string.conversation_options_multichat));
        intent.putExtra(ISelectMemberActivityConstants.PARAM_DONE_BUTTON_WORDING, this.f300107d.getString(R.string.f173097hd1));
        intent.putExtra(ISelectMemberActivityConstants.PARAM_DONE_BUTTON_HIGHLIGHT_WORDING, this.f300107d.getString(R.string.f173098hd2));
        intent.putExtra(ISelectMemberActivityConstants.PARAM_MAX, 99);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_MIN, 0);
        intent.putExtra(ISelectMemberActivityConstants.MULTICHAT, true);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_EXIT_ANIMATION, this.f294709f.getAnimationTypeR2L());
        intent.putExtra(ISelectMemberActivityConstants.PARAM_BACK_BUTTON_SIDE, this.f294709f.getBackButtonSideL());
        intent.setFlags(603979776);
        com.tencent.mobileqq.troop.troopcreate.a.l(this.f300107d, intent, RouterConstants.UI_ROUTE_SELECTMEMBER, 1300);
        this.f300107d.overridePendingTransition(R.anim.f155013gl, 0);
        ReportController.o(this.f300108e, "dc00899", "Grp_create_new", "", "create_page", "clk_chose", 0, 0, "", "" + this.f294717k0, "", "");
    }

    @Override // com.tencent.mobileqq.troop.troopcreate.ui.AbsNewTroopBaseView
    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        if (this.C.getVisibility() == 0) {
            J();
            return true;
        }
        if (!TextUtils.isEmpty(this.D.getInputWidget().getText())) {
            J();
            return true;
        }
        if (this.D.getInputWidget().hasFocus()) {
            J();
        }
        return super.a();
    }

    @Override // com.tencent.mobileqq.troop.troopcreate.ui.AbsNewTroopBaseView
    public void b(QBaseActivity qBaseActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) qBaseActivity);
            return;
        }
        super.b(qBaseActivity);
        t();
        this.N = getResources().getDisplayMetrics().density;
        y();
        x();
        this.S = BaseImageUtil.getDefaultFaceBitmap();
        ReportController.o(this.f300108e, "dc00899", "Grp_create_new", "", "create_page", "exp_person", 0, 0, "", "" + this.f294717k0, "", "");
    }

    @Override // com.tencent.mobileqq.troop.troopcreate.ui.AbsNewTroopBaseView
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.e();
        if (this.f294721n0) {
            this.f294721n0 = false;
            ReportController.o(this.f300108e, "dc00899", "Grp_create", "", "grptab", "select_exp", 0, 0, "", "" + this.f294717k0, "", "");
            if (this.f294720m0) {
                this.f294720m0 = false;
                return;
            }
            ReportController.o(this.f300108e, "dc00899", "Grp_create", "", "grptab", "select_clk", 0, 0, "", "" + this.f294717k0, "", "");
        }
    }

    @Override // com.tencent.mobileqq.troop.troopcreate.ui.AbsNewTroopBaseView
    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            super.f();
            this.f294721n0 = true;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.agm) {
                R();
            } else if (id5 == R.id.ahk) {
                U();
            } else if (id5 == R.id.bbt) {
                S();
            } else if (id5 == R.id.ahp) {
                ((ITroopCreatePage) QRoute.api(ITroopCreatePage.class)).openCreateTroopByCategoryPage(this.f300107d);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopCreateInfoService.a
    public void onCreateTroopCompletely(int i3, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, str2);
        } else if (i3 == 0 && !TextUtils.isEmpty(str)) {
            r();
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopCreateInfoService.a
    public void onInviteComplete(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3, (Object) str);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.ITroopCreateInfoService.a
    public void onReusedTroop(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            ((ITroopCreateService) this.f300108e.getRuntimeService(ITroopCreateService.class, "")).jumpToAioAfterCreated(str, null, true, false);
            r();
        }
    }

    public boolean q(List<ResultRecord> list, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, this, list, Boolean.valueOf(z16))).booleanValue();
        }
        if (z16) {
            this.L.clear();
        }
        HashSet hashSet = new HashSet(this.L.size());
        Iterator<ResultRecord> it = this.L.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().uin);
        }
        ArrayList<String> arrayList = this.f294714i;
        if (arrayList != null) {
            Iterator<String> it5 = arrayList.iterator();
            while (it5.hasNext()) {
                hashSet.add(it5.next());
            }
        }
        for (ResultRecord resultRecord : list) {
            if (!hashSet.contains(resultRecord.uin)) {
                if (z()) {
                    break;
                }
                this.L.add(resultRecord);
            }
        }
        I();
        P();
        return true;
    }

    protected void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        Intent intent = this.f300107d.getIntent();
        this.f294714i = intent.getStringArrayListExtra(ISelectMemberActivityConstants.PARAM_UIN_SELECT_DEFAULT);
        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra(ISelectMemberActivityConstants.PARAM_HIDE_UIN_LIST);
        this.f294719m = stringArrayListExtra;
        if (stringArrayListExtra == null) {
            this.f294719m = new ArrayList<>();
        }
        this.f294719m.add(AppConstants.BABY_Q_UIN);
        this.I = intent.getIntExtra(ISelectMemberActivityConstants.PARAM_MAX, Integer.MAX_VALUE);
        this.J = intent.getIntExtra(ISelectMemberActivityConstants.PARAM_MIN, 1);
        this.f294717k0 = intent.getIntExtra("create_source", 0);
    }

    public ArrayList<String> v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (ArrayList) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i3 = 0; i3 < this.L.size(); i3++) {
            arrayList.add(this.L.get(i3).uin);
        }
        return arrayList;
    }

    @TargetApi(14)
    protected void y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        g(R.layout.ahv);
        this.G = (InputMethodRelativeLayout) findViewById(R.id.f8n);
        this.H = findViewById(R.id.bbu);
        this.V = (PinnedFooterExpandableListView) findViewById(R.id.bzf);
        LinearLayout linearLayout = (LinearLayout) this.f300107d.getLayoutInflater().inflate(R.layout.acw, (ViewGroup) null);
        this.V.addHeaderView(linearLayout);
        TextView textView = new TextView(this.f300107d);
        textView.setLayoutParams(new AbsListView.LayoutParams(-1, Utils.n(68.0f, getResources())));
        this.V.addFooterView(textView);
        this.V.setIsDrawIndicator(false);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.result_layout);
        this.C = frameLayout;
        frameLayout.setVisibility(8);
        QUISearchBar qUISearchBar = (QUISearchBar) findViewById(R.id.imi);
        this.D = qUISearchBar;
        qUISearchBar.setSearchMode(1);
        this.D.setActionCallback(this.f294725r0);
        this.E = new ChatUserListExt<>(this.D);
        com.tencent.mobileqq.troop.selecttroopmember.a aVar = new com.tencent.mobileqq.troop.selecttroopmember.a(this.f294726s0);
        this.F = aVar;
        this.E.setAdapter(aVar);
        this.D.setSearchBarLayoutExt(this.E);
        this.D.getInputWidget().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.tencent.mobileqq.troop.createNewTroop.h
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z16) {
                NewTroopContactView.this.B(view, z16);
            }
        });
        this.C = (FrameLayout) findViewById(R.id.result_layout);
        this.F.updateData(this.L);
        RelativeLayout relativeLayout = (RelativeLayout) linearLayout.findViewById(R.id.agj);
        this.f294704a0 = relativeLayout;
        relativeLayout.setVisibility(8);
        this.f294706c0 = (Button) linearLayout.findViewById(R.id.ahp);
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102735", false)) {
            Drawable drawable = ContextCompat.getDrawable(getContext(), R.drawable.jae);
            if (drawable != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                this.f294706c0.setCompoundDrawables(null, null, drawable, null);
            }
            this.f294706c0.setCompoundDrawablePadding(ViewUtils.dpToPx(8.0f));
            this.f294706c0.invalidate();
        }
        this.f294706c0.setOnClickListener(this);
        if (!this.K.a()) {
            this.f294706c0.setVisibility(8);
        }
        VideoReport.setElementId(this.f294706c0, "em_group_create_chat_category");
        com.tencent.mobileqq.troop.troopcreate.classify.b.a((LinearLayout) linearLayout.findViewById(R.id.yof));
        com.tencent.mobileqq.troop.troopcreate.classify.detail.g.f("createNewTroop.NewTroopContactView");
        Button button = (Button) linearLayout.findViewById(R.id.ahj);
        this.f294710f0 = button;
        button.setVisibility(8);
        Button button2 = (Button) linearLayout.findViewById(R.id.agl);
        this.f294708e0 = button2;
        button2.setVisibility(8);
        Button button3 = (Button) linearLayout.findViewById(R.id.ahk);
        this.f294705b0 = button3;
        button3.setOnClickListener(this);
        VideoReport.setElementId(this.f294705b0, "em_group_select_from_chat");
        Button button4 = (Button) linearLayout.findViewById(R.id.agm);
        this.f294707d0 = button4;
        button4.setOnClickListener(this);
        this.f294707d0.setText(this.f300107d.getString(R.string.f170105g7));
        this.f294707d0.setContentDescription(this.f300107d.getString(R.string.f170105g7));
        VideoReport.setElementId(this.f294707d0, "em_group_create_chat_facetoface");
        if ("guild".equals(this.f300107d.getIntent().getStringExtra("createScene"))) {
            this.f294707d0.setVisibility(8);
        }
        Button button5 = (Button) findViewById(R.id.bbt);
        this.f294711g0 = button5;
        button5.setOnClickListener(this);
        this.f294711g0.setEnabled(false);
        this.f294711g0.setEnabled(false);
        this.f294716j0 = (QQBlurView) findViewById(R.id.ac8);
        VideoReport.setElementId(this.f294711g0, "em_group_create_chat_now");
        M(findViewById(R.id.uxp), 0.0f);
        linearLayout.setPadding(0, Utils.n(12.0f, getResources()), 0, 0);
        w();
    }

    public boolean z() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        if (this.L.size() < this.I) {
            return false;
        }
        ArrayList<String> arrayList = this.f294714i;
        if (arrayList != null) {
            i3 = arrayList.size();
        } else {
            i3 = 0;
        }
        O(String.format(this.f300107d.getString(R.string.cpx), Integer.valueOf(i3 + this.I)));
        return true;
    }
}
