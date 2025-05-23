package com.tencent.mobileqq.troop.memberlist;

import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.q;
import com.tencent.mobileqq.troop.api.troopmemberlist.ITroopMemberListActivityApi;
import com.tencent.mobileqq.troop.api.troopmemberlist.d;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.troop.widget.e;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes19.dex */
public class AddFrdHelper implements View.OnClickListener, d {
    static IPatchRedirector $redirector_;
    private b C;
    private final com.tencent.mobileqq.friend.observer.a D;
    private final com.tencent.mobileqq.friend.observer.b E;

    /* renamed from: d, reason: collision with root package name */
    public TroopMemberListActivity f297792d;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList<String> f297793e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f297794f;

    /* renamed from: h, reason: collision with root package name */
    public int f297795h;

    /* renamed from: i, reason: collision with root package name */
    public com.tencent.mobileqq.troop.troopmemberlist.a f297796i;

    /* renamed from: m, reason: collision with root package name */
    public com.tencent.mobileqq.troop.api.troopmemberlist.a f297797m;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a extends com.tencent.mobileqq.friend.observer.a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AddFrdHelper.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.friend.observer.a
        public void onUpdateAddFriend(boolean z16, boolean z17, boolean z18, String str, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), str, bundle);
            } else if (z16 && z17) {
                AddFrdHelper.this.g(1, str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final List<Long> f297799a;

        /* renamed from: b, reason: collision with root package name */
        int f297800b;

        public b(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
                return;
            }
            this.f297800b = 0;
            this.f297799a = new ArrayList(5);
            try {
                String configContentForTag = ((ITroopMemberListActivityApi) QRoute.api(ITroopMemberListActivityApi.class)).getConfigContentForTag(str, AppConstants.Preferences.TROOP_MEMBER_LIST_CONFIG);
                if (configContentForTag != null) {
                    JSONObject jSONObject = new JSONObject(configContentForTag);
                    this.f297800b = jSONObject.optInt("maxTroopMemberSize");
                    JSONArray optJSONArray = jSONObject.optJSONArray("troopClassIdList");
                    for (int i3 = 0; optJSONArray != null && i3 < optJSONArray.length(); i3++) {
                        this.f297799a.add(Long.valueOf(optJSONArray.optLong(i3)));
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.i("AddFrdHelper", 2, String.format("TroopMemberListConfig max: %s, idList: %s, config: %s", Integer.valueOf(this.f297800b), TextUtils.join(",", this.f297799a), configContentForTag));
                }
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
    }

    public AddFrdHelper(TroopMemberListActivity troopMemberListActivity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopMemberListActivity);
            return;
        }
        this.f297794f = false;
        this.f297795h = 0;
        this.f297796i = null;
        this.C = null;
        a aVar = new a();
        this.D = aVar;
        com.tencent.mobileqq.friend.observer.b bVar = (com.tencent.mobileqq.friend.observer.b) ((ITroopMemberListActivityApi) QRoute.api(ITroopMemberListActivityApi.class)).getFriendListObserverForAddFrd(this);
        this.E = bVar;
        this.f297792d = troopMemberListActivity;
        this.f297793e = new ArrayList<>(5);
        this.f297797m = ((ITroopMemberListActivityApi) QRoute.api(ITroopMemberListActivityApi.class)).getAddFrdStateMngProxy(troopMemberListActivity.getApp());
        troopMemberListActivity.getApp().addObserver(bVar);
        troopMemberListActivity.getApp().addObserver(aVar);
    }

    private void i(View view, com.tencent.mobileqq.troop.troopmemberlist.a aVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("qq_num", aVar.j());
        VideoReport.reportEvent("dt_clck", view, hashMap);
    }

    @Override // com.tencent.mobileqq.troop.api.troopmemberlist.d
    public void a(boolean z16, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Boolean.valueOf(z16), str, Integer.valueOf(i3));
        } else {
            g(1, str);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.troopmemberlist.d
    public void b(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
        } else {
            g(2, null);
        }
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        TroopMemberListActivity troopMemberListActivity = this.f297792d;
        if (troopMemberListActivity != null && !troopMemberListActivity.isFinishing() && troopMemberListActivity.isResume()) {
            if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
                if (QLog.isColorLevel()) {
                    QLog.i("AddFrdHelper", 2, "checkNeedUpdate cur thread is not main thread!");
                    return;
                }
                return;
            }
            int i3 = this.f297795h;
            if (i3 == 1) {
                try {
                    for (com.tencent.mobileqq.troop.troopmemberlist.a aVar : troopMemberListActivity.mListData) {
                        if (aVar != null && this.f297793e.contains(aVar.j())) {
                            aVar.m(d(aVar.j()));
                        }
                    }
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
                troopMemberListActivity.refreshAddFrdState();
            } else if (i3 == 2) {
                try {
                    for (com.tencent.mobileqq.troop.troopmemberlist.a aVar2 : troopMemberListActivity.mListData) {
                        if (aVar2 != null) {
                            aVar2.m(d(aVar2.j()));
                        }
                    }
                } catch (Throwable th6) {
                    th6.printStackTrace();
                }
                troopMemberListActivity.refreshAddFrdState();
            }
            this.f297795h = 0;
            try {
                this.f297793e.clear();
                return;
            } catch (Throwable th7) {
                th7.printStackTrace();
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("AddFrdHelper", 2, "checkNeedUpdate activity is not resume or is finishing!");
        }
    }

    public int d(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str)).intValue();
        }
        TroopMemberListActivity troopMemberListActivity = this.f297792d;
        if (troopMemberListActivity == null || !f(troopMemberListActivity.mTroopInfo) || this.f297797m == null || ((ITroopRobotService) troopMemberListActivity.getApp().getRuntimeService(ITroopRobotService.class, "all")).isRobotUin(str)) {
            return 0;
        }
        return this.f297797m.a(str, troopMemberListActivity.getApp());
    }

    public void destroy() {
        AppInterface app;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        TroopMemberListActivity troopMemberListActivity = this.f297792d;
        if (troopMemberListActivity != null && (app = troopMemberListActivity.getApp()) != null) {
            app.removeObserver(this.E);
            app.removeObserver(this.D);
        }
        this.f297792d = null;
    }

    protected void e() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (this.C == null) {
            TroopMemberListActivity troopMemberListActivity = this.f297792d;
            if (troopMemberListActivity != null && troopMemberListActivity.getApp() != null) {
                str = troopMemberListActivity.getApp().getCurrentAccountUin();
            } else {
                str = null;
            }
            this.C = new b(str);
        }
    }

    public boolean f(TroopInfo troopInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) troopInfo)).booleanValue();
        }
        if (troopInfo == null || troopInfo.isQidianPrivateTroop()) {
            return false;
        }
        if (this.C == null) {
            e();
        }
        if (!this.C.f297799a.contains(Long.valueOf(troopInfo.dwGroupClassExt)) || troopInfo.wMemberNum > this.C.f297800b) {
            return false;
        }
        return true;
    }

    public void g(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) str);
            return;
        }
        if (i3 > this.f297795h) {
            this.f297795h = i3;
        }
        if (this.f297795h < 2 && !TextUtils.isEmpty(str)) {
            try {
                this.f297793e.add(str);
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            c();
            return;
        }
        TroopMemberListActivity troopMemberListActivity = this.f297792d;
        if (troopMemberListActivity != null && troopMemberListActivity.isResume()) {
            troopMemberListActivity.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.troop.memberlist.AddFrdHelper.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AddFrdHelper.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        AddFrdHelper.this.c();
                    }
                }
            });
        }
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        com.tencent.mobileqq.troop.troopmemberlist.a aVar = this.f297796i;
        if (aVar != null) {
            aVar.m(d(aVar.j()));
            g(1, this.f297796i.j());
        } else {
            c();
        }
        this.f297796i = null;
    }

    public void j(e eVar, com.tencent.mobileqq.troop.troopmemberlist.a aVar) {
        boolean z16;
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) eVar, (Object) aVar);
            return;
        }
        if (eVar == null) {
            return;
        }
        TroopMemberListActivity troopMemberListActivity = this.f297792d;
        if (eVar.addFrdLayout != null && troopMemberListActivity != null) {
            TroopInfo troopInfo = troopMemberListActivity.mTroopInfo;
            AppInterface app = troopMemberListActivity.getApp();
            if (aVar != null && aVar.a() < 0) {
                aVar.m(d(aVar.j()));
            }
            if (aVar == null || (aVar.a() != 3 && aVar.a() != 2)) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                eVar.addFrdLayout.setVisibility(0);
                Button button = (Button) eVar.addFrdLayout.findViewById(R.id.f164019h6);
                TextView textView = (TextView) eVar.addFrdLayout.findViewById(R.id.f164021h8);
                if (aVar.a() == 2) {
                    button.setVisibility(8);
                    textView.setVisibility(0);
                    return;
                }
                if (aVar.a() == 3) {
                    button.setTag(aVar);
                    button.setOnClickListener(this);
                    button.setText(HardCodeUtil.qqStr(R.string.un9));
                    button.setVisibility(0);
                    textView.setVisibility(8);
                    if (!this.f297794f) {
                        this.f297794f = true;
                        if (troopInfo != null) {
                            str = troopInfo.troopuin;
                            str2 = String.valueOf(troopInfo.dwGroupClassExt);
                        } else {
                            str = "";
                            str2 = "";
                        }
                        new q(app).a("Grp_mber").f("mber_list").d("add_exp").b(str, str2).g();
                        return;
                    }
                    return;
                }
                button.setVisibility(8);
                textView.setVisibility(8);
                return;
            }
            eVar.addFrdLayout.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        TroopInfo troopInfo;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) view);
        } else {
            TroopMemberListActivity troopMemberListActivity = this.f297792d;
            Object tag = view.getTag();
            if (troopMemberListActivity != null && (tag instanceof com.tencent.mobileqq.troop.troopmemberlist.a)) {
                com.tencent.mobileqq.troop.troopmemberlist.a aVar = (com.tencent.mobileqq.troop.troopmemberlist.a) tag;
                this.f297796i = aVar;
                String str2 = troopMemberListActivity.mTroopCode;
                if (str2 == null && (troopInfo = troopMemberListActivity.mTroopInfo) != null) {
                    str2 = troopInfo.troopcode;
                }
                ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).launchAddFriend(troopMemberListActivity, ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).startAddFriend(troopMemberListActivity, 1, aVar.j(), str2, 3004, 13, aVar.f().troopnick, null, null, null, null));
                TroopInfo troopInfo2 = troopMemberListActivity.mTroopInfo;
                if (troopInfo2 == null) {
                    str = "";
                } else {
                    str = String.valueOf(troopInfo2.dwGroupClassExt);
                }
                new q(troopMemberListActivity.getApp()).a("Grp_mber").f("mber_list").d("add_clk").b("", str).g();
                i(view, aVar);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
