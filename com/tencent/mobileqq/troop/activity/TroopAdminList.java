package com.tencent.mobileqq.troop.activity;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.ar;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileCardConst;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.ac;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.widget.AbsListView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopAdminList extends IphoneTitleBarActivity {
    static IPatchRedirector $redirector_;

    /* renamed from: a0, reason: collision with root package name */
    protected final String f293519a0;

    /* renamed from: b0, reason: collision with root package name */
    protected LinearLayout f293520b0;

    /* renamed from: c0, reason: collision with root package name */
    protected XListView f293521c0;

    /* renamed from: d0, reason: collision with root package name */
    d f293522d0;

    /* renamed from: e0, reason: collision with root package name */
    protected String[] f293523e0;

    /* renamed from: f0, reason: collision with root package name */
    protected List<Map<String, String>> f293524f0;

    /* renamed from: g0, reason: collision with root package name */
    protected String f293525g0;

    /* renamed from: h0, reason: collision with root package name */
    protected FriendListHandler f293526h0;

    /* renamed from: i0, reason: collision with root package name */
    protected String f293527i0;

    /* renamed from: j0, reason: collision with root package name */
    protected String f293528j0;

    /* renamed from: k0, reason: collision with root package name */
    com.tencent.mobileqq.avatar.observer.a f293529k0;

    /* renamed from: l0, reason: collision with root package name */
    ar f293530l0;

    /* renamed from: m0, reason: collision with root package name */
    public View.OnClickListener f293531m0;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a extends com.tencent.mobileqq.avatar.observer.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAdminList.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.avatar.observer.a
        public void onUpdateCustomHead(boolean z16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str);
            } else if (z16 && !TextUtils.isEmpty(str)) {
                TroopAdminList.this.H2();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class b extends ar {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAdminList.this);
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onUpdateFriendInfoFinished(ArrayList arrayList, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, arrayList, Boolean.valueOf(z16));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("TroopAdminList", 2, "onUpdateFriendInfoFinished ");
            }
            TroopAdminList.this.H2();
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAdminList.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AllInOne allInOne;
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                e eVar = (e) view.getTag();
                if (eVar != null) {
                    String str = eVar.f187210d;
                    if (TroopAdminList.this.app.getCurrentAccountUin().equals(str)) {
                        allInOne = new AllInOne(str, 0);
                    } else {
                        int intExtra = TroopAdminList.this.getIntent().getIntExtra("t_s_f", -1);
                        com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), "openProfileCardForTroopSysMsg");
                        TroopInfo k3 = ((TroopManager) TroopAdminList.this.app.getManager(QQManagerFactory.TROOP_MANAGER)).k(TroopAdminList.this.f293527i0);
                        if (friendsSimpleInfoWithUid != null && friendsSimpleInfoWithUid.B()) {
                            if (k3 != null) {
                                allInOne = new AllInOne(str, 20);
                                TroopAdminList troopAdminList = TroopAdminList.this;
                                allInOne.troopUin = troopAdminList.f293528j0;
                                allInOne.troopCode = troopAdminList.f293527i0;
                            } else {
                                allInOne = new AllInOne(str, 1);
                            }
                            allInOne.nickname = friendsSimpleInfoWithUid.p();
                            allInOne.remark = friendsSimpleInfoWithUid.r();
                        } else if (intExtra == 1002) {
                            allInOne = new AllInOne(str, 97);
                        } else if (k3 != null) {
                            allInOne = new AllInOne(str, 21);
                            TroopAdminList troopAdminList2 = TroopAdminList.this;
                            allInOne.troopUin = troopAdminList2.f293528j0;
                            allInOne.troopCode = troopAdminList2.f293527i0;
                            allInOne.subSourceId = 12;
                        } else {
                            allInOne = new AllInOne(str, 23);
                            Bundle bundle = new Bundle();
                            bundle.putString(AppConstants.Key.TROOP_CODE, TroopAdminList.this.f293528j0);
                            bundle.putString("troop_uin", TroopAdminList.this.f293527i0);
                            allInOne.extras.putBundle("flc_extra_param", bundle);
                        }
                    }
                    allInOne.extras.putInt(ProfileCardConst.ENTER_PAGE_SOURCE_ID, 1);
                    allInOne.extras.putInt(ProfileCardConst.ENTER_PAGE_SUB_SOURCE_ID, 16);
                    ProfileUtils.openProfileCard(TroopAdminList.this, allInOne);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class d extends BaseAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private LayoutInflater f293537d;

        public d(Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopAdminList.this, (Object) context);
            } else {
                this.f293537d = LayoutInflater.from(context);
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return TroopAdminList.this.f293524f0.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Long) iPatchRedirector.redirect((short) 4, (Object) this, i3)).longValue();
            }
            return 0L;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            View view2;
            e eVar;
            View view3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                view2 = (View) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), view, viewGroup);
                view3 = view;
            } else {
                if (view == null) {
                    eVar = new e();
                    view2 = this.f293537d.inflate(R.layout.f168592ah1, (ViewGroup) null);
                    eVar.f187212f = (ImageView) view2.findViewById(R.id.dvn);
                    eVar.f293539i = (TextView) view2.findViewById(R.id.f5e);
                    eVar.f293540m = (TextView) view2.findViewById(R.id.info);
                    view2.setTag(eVar);
                    view2.setOnClickListener(TroopAdminList.this.f293531m0);
                } else {
                    view2 = view;
                    eVar = (e) view.getTag();
                }
                Map<String, String> map = TroopAdminList.this.f293524f0.get(i3);
                String obj = map.get("uin").toString();
                eVar.f187210d = obj;
                eVar.f187212f.setBackgroundDrawable(BaseImageUtil.getDefaultFaceDrawable());
                FaceDrawable userFaceDrawable = FaceDrawable.getUserFaceDrawable(TroopAdminList.this.app, map.get("uin").toString(), (byte) 3);
                if (userFaceDrawable != null) {
                    eVar.f187212f.setBackgroundDrawable(userFaceDrawable);
                }
                eVar.f293539i.setText(map.get("nick").toString());
                if (TroopAdminList.this.f293525g0.equals(obj)) {
                    eVar.f293540m.setVisibility(0);
                } else {
                    eVar.f293540m.setVisibility(4);
                }
                view3 = view2;
            }
            EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
            return view2;
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class e extends com.tencent.mobileqq.adapter.k {
        static IPatchRedirector $redirector_;

        /* renamed from: i, reason: collision with root package name */
        public TextView f293539i;

        /* renamed from: m, reason: collision with root package name */
        public TextView f293540m;

        public e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public TroopAdminList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f293519a0 = "TroopAdminList";
        this.f293524f0 = new ArrayList();
        this.f293529k0 = new a();
        this.f293530l0 = new b();
        this.f293531m0 = new c();
    }

    protected boolean G2() {
        ArrayList<String> stringArrayListExtra;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        String stringExtra = getIntent().getStringExtra("uin");
        this.f293525g0 = stringExtra;
        int i3 = 0;
        if (TextUtils.isEmpty(stringExtra) || (stringArrayListExtra = getIntent().getStringArrayListExtra(AppConstants.Key.TROOP_INFO_MEMO)) == null || stringArrayListExtra.size() < 1) {
            return false;
        }
        String[] strArr = new String[stringArrayListExtra.size()];
        this.f293523e0 = strArr;
        strArr[0] = this.f293525g0;
        int size = stringArrayListExtra.size();
        int i16 = 1;
        while (i16 < size) {
            if (!stringArrayListExtra.get(i3).equals(this.f293525g0)) {
                this.f293523e0[i16] = stringArrayListExtra.get(i3);
                i16++;
            }
            i3++;
        }
        this.f293527i0 = getIntent().getStringExtra("troop_uin");
        this.f293528j0 = getIntent().getStringExtra(AppConstants.Key.TROOP_CODE);
        return true;
    }

    protected void H2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.troop.activity.TroopAdminList.4
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopAdminList.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    int size = TroopAdminList.this.f293524f0.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        TroopAdminList.this.f293524f0.get(i3).put("nick", ac.y(TroopAdminList.this.app, TroopAdminList.this.f293524f0.get(i3).get("uin")));
                    }
                    TroopAdminList.this.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.troop.activity.TroopAdminList.4.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass4.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                                return;
                            }
                            d dVar = TroopAdminList.this.f293522d0;
                            if (dVar != null) {
                                dVar.notifyDataSetChanged();
                            }
                        }
                    });
                }
            }, 8, null, true);
            return;
        }
        int size = this.f293524f0.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.f293524f0.get(i3).put("nick", ac.y(this.app, this.f293524f0.get(i3).get("uin")));
        }
        runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.troop.activity.TroopAdminList.5
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopAdminList.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                d dVar = TroopAdminList.this.f293522d0;
                if (dVar != null) {
                    dVar.notifyDataSetChanged();
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        if (G2()) {
            initUI();
            initData();
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.i("TroopAdminList", 2, "onCreate, illegal param, troopuin = ");
        }
        finish();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        removeObserver(this.f293530l0);
        removeObserver(this.f293529k0);
        super.doOnDestroy();
    }

    protected void initData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.f293524f0 = new ArrayList();
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.troop.activity.TroopAdminList.3
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopAdminList.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    int length = TroopAdminList.this.f293523e0.length;
                    for (int i3 = 0; i3 < length; i3++) {
                        String str = TroopAdminList.this.f293523e0[i3];
                        if (!TextUtils.isEmpty(str)) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("uin", str);
                            hashMap.put("nick", ac.y(TroopAdminList.this.app, str));
                            TroopAdminList.this.f293524f0.add(hashMap);
                        }
                    }
                    TroopAdminList troopAdminList = TroopAdminList.this;
                    troopAdminList.f293526h0 = (FriendListHandler) troopAdminList.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
                    TroopAdminList troopAdminList2 = TroopAdminList.this;
                    troopAdminList2.addObserver(troopAdminList2.f293530l0);
                    TroopAdminList troopAdminList3 = TroopAdminList.this;
                    troopAdminList3.addObserver(troopAdminList3.f293529k0);
                    TroopAdminList troopAdminList4 = TroopAdminList.this;
                    troopAdminList4.f293526h0.getFriendsInfo(troopAdminList4.f293523e0);
                    TroopAdminList.this.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.troop.activity.TroopAdminList.3.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass3.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                                return;
                            }
                            TroopAdminList troopAdminList5 = TroopAdminList.this;
                            TroopAdminList troopAdminList6 = TroopAdminList.this;
                            troopAdminList5.f293522d0 = new d(troopAdminList6);
                            TroopAdminList troopAdminList7 = TroopAdminList.this;
                            troopAdminList7.f293521c0.setAdapter((ListAdapter) troopAdminList7.f293522d0);
                        }
                    });
                }
            }, 8, null, true);
        }
    }

    protected void initUI() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        View inflate = View.inflate(this, R.layout.f168591ah0, null);
        XListView xListView = (XListView) inflate.findViewById(R.id.common_xlistview);
        this.f293521c0 = xListView;
        xListView.setVerticalScrollBarEnabled(false);
        this.f293521c0.setDivider(null);
        this.f293520b0 = new LinearLayout(this);
        this.f293520b0.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        this.f293520b0.setOrientation(1);
        setContentView(inflate);
        setTitle(getString(R.string.c7d));
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
