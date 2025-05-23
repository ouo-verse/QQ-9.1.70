package com.tencent.mobileqq.teamwork.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ar;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.api.ITeamWorkHandler;
import com.tencent.mobileqq.teamwork.bh;
import com.tencent.mobileqq.teamwork.s;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.pb.teamwork.TimDocSSOMsg$UinRightInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes18.dex */
public class TeamWorkAuthorizeSettingFragment extends IphoneTitleBarFragment implements View.OnClickListener {
    String C;
    int D;
    TextView E;
    TextView F;
    TextView G;
    XListView H;
    TextView I;
    List<s.b> J;
    Map<Integer, List<s.b>> K;
    s L;
    private ITeamWorkHandler P;
    private QQAppInterface R;
    int M = -1;
    boolean N = false;
    ar Q = new a();
    bh S = new b();

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a extends ar {
        a() {
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onUpdateFriendInfo(String str, boolean z16) {
            TeamWorkAuthorizeSettingFragment.this.L.k(str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class b extends bh {
        b() {
        }

        @Override // com.tencent.mobileqq.teamwork.bh
        public void c(boolean z16, String str, int i3, List<TimDocSSOMsg$UinRightInfo> list) {
            TeamWorkAuthorizeSettingFragment.this.stopTitleProgress();
            if (!z16) {
                com.tencent.mobileqq.filemanager.util.d.f(HardCodeUtil.qqStr(R.string.u17));
                return;
            }
            if (!str.equalsIgnoreCase(TeamWorkAuthorizeSettingFragment.this.C)) {
                return;
            }
            TeamWorkAuthorizeSettingFragment.this.J.clear();
            for (TimDocSSOMsg$UinRightInfo timDocSSOMsg$UinRightInfo : list) {
                s.b bVar = new s.b();
                bVar.f292332b = String.valueOf(timDocSSOMsg$UinRightInfo.uint64_uin.get());
                bVar.f292331a = timDocSSOMsg$UinRightInfo;
                TeamWorkAuthorizeSettingFragment.this.L.d(bVar);
            }
            TeamWorkAuthorizeSettingFragment teamWorkAuthorizeSettingFragment = TeamWorkAuthorizeSettingFragment.this;
            teamWorkAuthorizeSettingFragment.M = i3;
            teamWorkAuthorizeSettingFragment.Ah(i3);
            TeamWorkAuthorizeSettingFragment.this.vh();
            TeamWorkAuthorizeSettingFragment.this.zh(true);
        }

        @Override // com.tencent.mobileqq.teamwork.bh
        public void d(boolean z16, String str, int i3) {
            TeamWorkAuthorizeSettingFragment.this.stopTitleProgress();
            if (!z16) {
                com.tencent.mobileqq.filemanager.util.d.f(HardCodeUtil.qqStr(R.string.u1i));
                return;
            }
            TeamWorkAuthorizeSettingFragment teamWorkAuthorizeSettingFragment = TeamWorkAuthorizeSettingFragment.this;
            if (teamWorkAuthorizeSettingFragment.D != i3 && !str.equalsIgnoreCase(teamWorkAuthorizeSettingFragment.C)) {
                return;
            }
            if (QLog.isDevelopLevel()) {
                QLog.i("TeamWorkAuthorizeSettingFragment", 1, "padInfo is null, maybe is newpad");
            }
            TeamWorkAuthorizeSettingFragment.this.J.clear();
            TeamWorkAuthorizeSettingFragment teamWorkAuthorizeSettingFragment2 = TeamWorkAuthorizeSettingFragment.this;
            teamWorkAuthorizeSettingFragment2.M = 2;
            teamWorkAuthorizeSettingFragment2.Ah(2);
            TeamWorkAuthorizeSettingFragment.this.vh();
            TeamWorkAuthorizeSettingFragment.this.zh(true);
        }

        @Override // com.tencent.mobileqq.teamwork.bh
        public void h(boolean z16, String str, int i3) {
            TeamWorkAuthorizeSettingFragment.this.zh(true);
            TeamWorkAuthorizeSettingFragment.this.getRightTextView().setEnabled(true);
            TeamWorkAuthorizeSettingFragment.this.stopTitleProgress();
            if (!z16) {
                com.tencent.mobileqq.filemanager.util.d.f(HardCodeUtil.qqStr(R.string.tzz));
                return;
            }
            com.tencent.mobileqq.filemanager.util.d.h(HardCodeUtil.qqStr(R.string.f172756u01));
            TeamWorkAuthorizeSettingFragment.this.stopTitleProgress();
            Intent intent = new Intent();
            intent.putExtra("url", str);
            intent.putExtra("type", i3);
            if (TeamWorkAuthorizeSettingFragment.this.isAdded()) {
                TeamWorkAuthorizeSettingFragment.this.getBaseActivity().setResult(1122, intent);
                TeamWorkAuthorizeSettingFragment.this.getBaseActivity().finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class c implements ActionSheet.OnButtonClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ SparseArray f292121d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ActionSheet f292122e;

        c(SparseArray sparseArray, ActionSheet actionSheet) {
            this.f292121d = sparseArray;
            this.f292122e = actionSheet;
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            int intValue;
            if (this.f292121d.get(i3) == null) {
                intValue = -1;
            } else {
                intValue = ((Integer) this.f292121d.get(i3)).intValue();
            }
            if (intValue == R.string.hxg) {
                TeamWorkAuthorizeSettingFragment.this.Ah(2);
            } else if (intValue == R.string.hxh) {
                TeamWorkAuthorizeSettingFragment.this.Ah(1);
            } else if (intValue == R.string.hxi) {
                TeamWorkAuthorizeSettingFragment.this.Ah(0);
            }
            TeamWorkAuthorizeSettingFragment.this.vh();
            if (this.f292122e.isShowing()) {
                this.f292122e.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class d implements ActionSheet.OnButtonClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ SparseArray f292124d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ActionSheet f292125e;

        d(SparseArray sparseArray, ActionSheet actionSheet) {
            this.f292124d = sparseArray;
            this.f292125e = actionSheet;
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            int intValue;
            if (this.f292124d.get(i3) == null) {
                intValue = -1;
            } else {
                intValue = ((Integer) this.f292124d.get(i3)).intValue();
            }
            if (intValue == R.string.hxe) {
                TeamWorkAuthorizeSettingFragment.this.Ah(2);
            } else if (intValue == R.string.hxf) {
                TeamWorkAuthorizeSettingFragment.this.Ah(3);
            }
            TeamWorkAuthorizeSettingFragment.this.vh();
            if (this.f292125e.isShowing()) {
                this.f292125e.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class e implements ActionSheet.OnButtonClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ s.a f292127d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ SparseArray f292128e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ActionSheet f292129f;

        /* compiled from: P */
        /* loaded from: classes18.dex */
        class a implements DialogInterface.OnClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ TimDocSSOMsg$UinRightInfo f292131d;

            a(TimDocSSOMsg$UinRightInfo timDocSSOMsg$UinRightInfo) {
                this.f292131d = timDocSSOMsg$UinRightInfo;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                TeamWorkAuthorizeSettingFragment teamWorkAuthorizeSettingFragment = TeamWorkAuthorizeSettingFragment.this;
                teamWorkAuthorizeSettingFragment.N = true;
                teamWorkAuthorizeSettingFragment.L.e(String.valueOf(this.f292131d.uint64_uin.get()));
                TeamWorkAuthorizeSettingFragment.this.L.notifyDataSetChanged();
                TeamWorkAuthorizeSettingFragment teamWorkAuthorizeSettingFragment2 = TeamWorkAuthorizeSettingFragment.this;
                if (teamWorkAuthorizeSettingFragment2.M == 1) {
                    ReportController.o(teamWorkAuthorizeSettingFragment2.R, "dc00898", "", "", "0x8007CFD", "0x8007CFD", 0, 0, "", "", "", "");
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes18.dex */
        class b implements DialogInterface.OnClickListener {
            b() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                TeamWorkAuthorizeSettingFragment teamWorkAuthorizeSettingFragment = TeamWorkAuthorizeSettingFragment.this;
                if (teamWorkAuthorizeSettingFragment.M == 1) {
                    ReportController.o(teamWorkAuthorizeSettingFragment.R, "dc00898", "", "", "0x8007CFE", "0x8007CFE", 0, 0, "", "", "", "");
                }
            }
        }

        e(s.a aVar, SparseArray sparseArray, ActionSheet actionSheet) {
            this.f292127d = aVar;
            this.f292128e = sparseArray;
            this.f292129f = actionSheet;
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x0088  */
        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(View view, int i3) {
            int intValue;
            String string;
            TeamWorkAuthorizeSettingFragment teamWorkAuthorizeSettingFragment;
            TimDocSSOMsg$UinRightInfo timDocSSOMsg$UinRightInfo = this.f292127d.f292329e;
            if (this.f292128e.get(i3) == null) {
                intValue = -1;
            } else {
                intValue = ((Integer) this.f292128e.get(i3)).intValue();
            }
            if (intValue == R.string.hxe) {
                timDocSSOMsg$UinRightInfo.uint32_right.set(1);
            } else if (intValue == R.string.hxf) {
                timDocSSOMsg$UinRightInfo.uint32_right.set(2);
            } else if (intValue == R.string.a0s) {
                if (timDocSSOMsg$UinRightInfo.uint32_right.get() == 1) {
                    TeamWorkAuthorizeSettingFragment teamWorkAuthorizeSettingFragment2 = TeamWorkAuthorizeSettingFragment.this;
                    if (teamWorkAuthorizeSettingFragment2.M == 1) {
                        string = teamWorkAuthorizeSettingFragment2.getString(R.string.hxb);
                        DialogUtil.createCustomDialog(TeamWorkAuthorizeSettingFragment.this.getBaseActivity(), 230, HardCodeUtil.qqStr(R.string.u0c), string, R.string.cancel, R.string.f170822ak3, new a(timDocSSOMsg$UinRightInfo), new b()).show();
                        teamWorkAuthorizeSettingFragment = TeamWorkAuthorizeSettingFragment.this;
                        if (teamWorkAuthorizeSettingFragment.M == 1) {
                            ReportController.o(teamWorkAuthorizeSettingFragment.R, "dc00898", "", "", "0x8007CFC", "0x8007CFC", 0, 0, "", "", "", "");
                        }
                    }
                }
                string = TeamWorkAuthorizeSettingFragment.this.getString(R.string.hxa);
                DialogUtil.createCustomDialog(TeamWorkAuthorizeSettingFragment.this.getBaseActivity(), 230, HardCodeUtil.qqStr(R.string.u0c), string, R.string.cancel, R.string.f170822ak3, new a(timDocSSOMsg$UinRightInfo), new b()).show();
                teamWorkAuthorizeSettingFragment = TeamWorkAuthorizeSettingFragment.this;
                if (teamWorkAuthorizeSettingFragment.M == 1) {
                }
            }
            TeamWorkAuthorizeSettingFragment.this.vh();
            TeamWorkAuthorizeSettingFragment.this.L.notifyDataSetChanged();
            if (this.f292129f.isShowing()) {
                this.f292129f.dismiss();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class g implements DialogInterface.OnClickListener {
        g() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            TeamWorkAuthorizeSettingFragment.this.getBaseActivity().finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ah(int i3) {
        if (i3 <= 3 && i3 >= 0) {
            this.I.setText(R.string.hxc);
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            QLog.w("TeamWorkAuthorizeSettingFragment", 1, "no process PUBFLAG:" + i3);
                            return;
                        }
                        this.F.setText(R.string.hxg);
                        this.G.setText(R.string.hxf);
                    } else {
                        this.F.setText(R.string.hxg);
                        this.G.setText(R.string.hxe);
                        this.I.setText(R.string.hxd);
                    }
                } else {
                    this.F.setText(R.string.hxh);
                }
            } else {
                this.F.setText(R.string.hxi);
            }
            int i16 = this.M;
            if (i16 != i3) {
                this.N = true;
                if (i16 == 2 || i16 == 1) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(this.J);
                    this.K.put(Integer.valueOf(this.M), arrayList);
                }
                this.J.clear();
            }
            this.M = i3;
            if (this.K.containsKey(Integer.valueOf(i3))) {
                this.J.addAll(this.K.get(Integer.valueOf(i3)));
            }
            s sVar = this.L;
            if (sVar != null) {
                sVar.j(this.M);
                return;
            }
            return;
        }
        QLog.e("TeamWorkAuthorizeSettingFragment", 1, "pubFlag error:" + i3);
    }

    private void initUI() {
        this.f211156vg.changeBg(true);
        this.E = (TextView) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.bne);
        this.F = (TextView) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.cjq);
        this.G = (TextView) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.cuh);
        this.H = (XListView) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.kmd);
        this.I = (TextView) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.btd);
        setLeftViewName(R.string.f170549u3);
        setRightButton(R.string.f171151ok, this);
        setTitle(getBaseActivity().getResources().getString(R.string.hxj));
    }

    private void parseIntent() {
        Intent intent = getBaseActivity().getIntent();
        String stringExtra = intent.getStringExtra("team_work_name");
        if (TextUtils.isEmpty(stringExtra)) {
            this.E.setVisibility(8);
        }
        this.E.setText("\u5bf9\"" + stringExtra + "\"\u8fdb\u884c\u8bbe\u7f6e");
        this.C = intent.getStringExtra("team_work_pad_url");
        this.D = intent.getIntExtra("team_work_pad_list_type", -1);
        this.M = intent.getIntExtra("team_work_public_tag", -1);
        this.K = new HashMap();
        this.J = new ArrayList();
        s sVar = new s(this.R, getBaseActivity(), this, this.J);
        this.L = sVar;
        this.H.setAdapter((ListAdapter) sVar);
    }

    private void uh() {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < this.J.size(); i3++) {
            arrayList.add(String.valueOf(this.J.get(i3).f292332b));
        }
        Intent intent = new Intent();
        intent.putExtra(ISelectMemberActivityConstants.PARAM_UIN_SELECT_DEFAULT, arrayList);
        intent.putExtra("param_type", 9504);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_SUBTYPE, 0);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_ENTRANCE, 31);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_MIN, 0);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_MAX, 2000);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_ENABLE_ALL_SELECT, true);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_OVERLOAD_TIPS_INCLUDE_DEFAULT_COUNT, true);
        intent.putExtra(ISelectMemberActivityConstants.PARAM_DONOT_NEED_CONTACTS, true);
        ((ISelectMemberApi) QRoute.api(ISelectMemberApi.class)).startSelectMemberActivityForResult(getActivity(), intent, 1001);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vh() {
        View findViewById = ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.bcz);
        View findViewById2 = ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.cui);
        int i3 = this.M;
        if (i3 == 2) {
            findViewById2.setVisibility(0);
            findViewById.setVisibility(0);
        } else if (i3 == 3) {
            findViewById2.setVisibility(0);
            findViewById.setVisibility(8);
        } else if (i3 == 1) {
            findViewById2.setVisibility(8);
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
            findViewById2.setVisibility(8);
        }
    }

    private void wh() {
        ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(getBaseActivity(), null);
        SparseArray sparseArray = new SparseArray();
        actionSheet.addButton(getString(R.string.hxe), 5);
        sparseArray.put(0, Integer.valueOf(R.string.hxe));
        actionSheet.addButton(getString(R.string.hxf), 5);
        sparseArray.put(1, Integer.valueOf(R.string.hxf));
        actionSheet.setOnButtonClickListener(new d(sparseArray, actionSheet));
        actionSheet.setMainTitle(HardCodeUtil.qqStr(R.string.u1r));
        actionSheet.addCancelButton(R.string.cancel);
        actionSheet.show();
    }

    private void xh() {
        ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(getBaseActivity(), null);
        SparseArray sparseArray = new SparseArray();
        actionSheet.addButton(getString(R.string.hxg), 5);
        sparseArray.put(0, Integer.valueOf(R.string.hxg));
        actionSheet.addButton(getString(R.string.hxh), 5);
        sparseArray.put(1, Integer.valueOf(R.string.hxh));
        actionSheet.addButton(getString(R.string.hxi), 5);
        sparseArray.put(2, Integer.valueOf(R.string.hxi));
        actionSheet.setOnButtonClickListener(new c(sparseArray, actionSheet));
        actionSheet.setMainTitle(HardCodeUtil.qqStr(R.string.u0j));
        actionSheet.addCancelButton(R.string.cancel);
        actionSheet.show();
    }

    private void yh(s.a aVar) {
        ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(getBaseActivity(), null);
        SparseArray sparseArray = new SparseArray();
        int i3 = 0;
        if (this.M != 2) {
            actionSheet.addButton(getString(R.string.hxe), 5);
            sparseArray.put(0, Integer.valueOf(R.string.hxe));
            actionSheet.addButton(getString(R.string.hxf), 5);
            sparseArray.put(1, Integer.valueOf(R.string.hxf));
            i3 = 2;
        }
        actionSheet.addButton(getString(R.string.a0s), 3);
        sparseArray.put(i3, Integer.valueOf(R.string.a0s));
        actionSheet.setOnButtonClickListener(new e(aVar, sparseArray, actionSheet));
        actionSheet.addCancelButton(R.string.cancel);
        actionSheet.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zh(boolean z16) {
        ViewGroup viewGroup = (ViewGroup) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.cjr);
        ViewGroup viewGroup2 = (ViewGroup) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.cui);
        ViewGroup viewGroup3 = (ViewGroup) ((IphoneTitleBarFragment) this).mContentView.findViewById(R.id.f163995gd);
        for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
            viewGroup.getChildAt(i3).setEnabled(z16);
        }
        for (int i16 = 0; i16 < viewGroup2.getChildCount(); i16++) {
            viewGroup2.getChildAt(i16).setEnabled(z16);
        }
        for (int i17 = 0; i17 < viewGroup3.getChildCount(); i17++) {
            viewGroup3.getChildAt(i17).setEnabled(z16);
        }
        viewGroup.setEnabled(z16);
        viewGroup2.setEnabled(z16);
        viewGroup3.setEnabled(z16);
        if (z16) {
            Ah(this.M);
            vh();
            viewGroup.setOnClickListener(this);
            viewGroup2.setOnClickListener(this);
            viewGroup3.setOnClickListener(this);
            return;
        }
        viewGroup.setOnClickListener(null);
        viewGroup2.setOnClickListener(null);
        viewGroup3.setOnClickListener(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        startTitleProgress();
        QQAppInterface qQAppInterface = getBaseActivity().app;
        this.R = qQAppInterface;
        qQAppInterface.addObserver(this.S);
        initUI();
        parseIntent();
        ITeamWorkHandler iTeamWorkHandler = (ITeamWorkHandler) this.R.getBusinessHandler(BusinessHandlerFactory.TEAM_WORK_HANDLER);
        this.P = iTeamWorkHandler;
        iTeamWorkHandler.getPadRightsInfo(this.D, this.C);
        ReportController.o(this.R, "dc00898", "", "", "0x8007CF5", "0x8007CF5", 0, 0, "", "", "", "");
        zh(false);
        this.R.addObserver(this.Q);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.c0b;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        if (i3 == 1001 && -1 == i16) {
            ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(ISelectMemberActivityConstants.PARAM_RESULT_SET);
            if (parcelableArrayListExtra != null && parcelableArrayListExtra.size() > 0) {
                Iterator it = parcelableArrayListExtra.iterator();
                while (it.hasNext()) {
                    ResultRecord resultRecord = (ResultRecord) it.next();
                    TimDocSSOMsg$UinRightInfo timDocSSOMsg$UinRightInfo = new TimDocSSOMsg$UinRightInfo();
                    timDocSSOMsg$UinRightInfo.uint64_uin.set(Long.parseLong(resultRecord.uin));
                    timDocSSOMsg$UinRightInfo.uint32_right.set(2);
                    timDocSSOMsg$UinRightInfo.uint32_uin_type.set(0);
                    s.b bVar = new s.b();
                    bVar.f292332b = resultRecord.uin;
                    bVar.f292335e = resultRecord.name;
                    bVar.f292334d = resultRecord.groupUin;
                    bVar.f292333c = resultRecord.type;
                    bVar.f292331a = timDocSSOMsg$UinRightInfo;
                    this.L.d(bVar);
                    this.N = true;
                }
            }
            this.L.notifyDataSetChanged();
        }
    }

    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment, com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        ReportController.o(this.R, "dc00898", "", "", "0x8007D01", "0x8007D01", 0, 0, "", "", "", "");
        if (this.N) {
            DialogUtil.createCustomDialog(getBaseActivity(), 230, getString(R.string.hx9), "", R.string.hx8, R.string.hx_, new f(), new g()).show();
            return false;
        }
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.f163995gd) {
            uh();
            ReportController.o(this.R, "dc00898", "", "", "0x8007CFA", "0x8007CFA", 0, 0, "", "", "", "");
        } else if (id5 == R.id.cjr) {
            xh();
            ReportController.o(this.R, "dc00898", "", "", "0x8007CFA", "0x8007CFA", 0, 0, "", "", "", "");
        } else if (id5 == R.id.cui) {
            wh();
            ReportController.o(this.R, "dc00898", "", "", "0x8007CFA", "0x8007CFA", 0, 0, "", "", "", "");
        } else if (id5 == R.id.jby) {
            yh((s.a) view.getTag());
            if (this.M == 1) {
                ReportController.o(this.R, "dc00898", "", "", "0x8007CFA", "0x8007CFA", 0, 0, "", "", "", "");
            }
        } else if (id5 == R.id.ivTitleBtnRightText) {
            ReportController.o(this.R, "dc00898", "", "", "0x8007CFA", "0x8007CFA", 0, 0, "", "", "", "");
            ArrayList arrayList = new ArrayList();
            for (s.b bVar : this.J) {
                if (this.M == 2) {
                    bVar.f292331a.uint32_right.set(2);
                }
                arrayList.add(bVar.f292331a);
            }
            this.P.setPadRightsInfo(this.M, this.C, this.D, arrayList);
            zh(false);
            getRightTextView().setEnabled(false);
            startTitleProgress();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        QQAppInterface qQAppInterface = this.R;
        if (qQAppInterface != null) {
            qQAppInterface.removeObserver(this.S);
        }
        super.onDestroyView();
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class f implements DialogInterface.OnClickListener {
        f() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }
}
