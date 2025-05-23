package jy1;

import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.api.RoleGroupUserUIData;
import com.tencent.mobileqq.guild.client.widget.GuildClientIdentityView;
import com.tencent.mobileqq.guild.rolegroup.fragments.memberlist.GuildCommonViewMemberFragment;
import com.tencent.mobileqq.guild.rolegroup.fragments.memberlist.GuildRoleMemberParamData;
import com.tencent.mobileqq.guild.rolegroup.viewmodel.memberlist.strategy.ap;
import com.tencent.mobileqq.guild.rolegroup.viewmodel.memberlist.strategy.as;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.cn;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import ef1.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a extends b {
    private final as C;
    private String G;
    private final GuildRoleMemberParamData J;
    private final cn<Boolean> D = new cn<>();
    private final MutableLiveData<ArrayList<RoleGroupUserUIData>> E = new MutableLiveData<>();
    private final MutableLiveData<ArrayList<RoleGroupUserUIData>> F = new MutableLiveData<>();
    private boolean H = false;
    private boolean I = false;
    private final HashMap<String, RoleGroupUserUIData> K = new HashMap<>();

    /* compiled from: P */
    /* renamed from: jy1.a$a, reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public interface InterfaceC10621a {
        void a(ri1.a aVar);

        void onSuccess();
    }

    public a(GuildRoleMemberParamData guildRoleMemberParamData) {
        this.J = guildRoleMemberParamData;
        this.C = ap.a(this, guildRoleMemberParamData);
    }

    private void N1(ArrayList<RoleGroupUserUIData> arrayList, ArrayList<RoleGroupUserUIData> arrayList2) {
        if (arrayList2.isEmpty()) {
            return;
        }
        if (!this.H && (this.J.getLayoutType() == 0 || this.J.getLayoutType() == 1)) {
            arrayList.add(new RoleGroupUserUIData(2, HardCodeUtil.qqStr(R.string.f15008141)));
            this.H = true;
        }
        arrayList.addAll(arrayList2);
    }

    private void O1(IGProUserInfo iGProUserInfo, ArrayList<RoleGroupUserUIData> arrayList) {
        if (this.K.containsKey(iGProUserInfo.getTinyId())) {
            arrayList.add(this.K.get(iGProUserInfo.getTinyId()));
            return;
        }
        RoleGroupUserUIData roleGroupUserUIData = new RoleGroupUserUIData(1);
        roleGroupUserUIData.setName(ch.d0(iGProUserInfo));
        roleGroupUserUIData.setTinyId(iGProUserInfo.getTinyId());
        roleGroupUserUIData.setUserIdentity(GuildClientIdentityView.e(iGProUserInfo));
        roleGroupUserUIData.setUserType(iGProUserInfo.getUserType());
        this.K.put(iGProUserInfo.getTinyId(), roleGroupUserUIData);
        arrayList.add(roleGroupUserUIData);
    }

    private void P1(ArrayList<RoleGroupUserUIData> arrayList, ArrayList<RoleGroupUserUIData> arrayList2) {
        if (arrayList2.isEmpty()) {
            return;
        }
        if (!this.I && (this.J.getLayoutType() == 0 || this.J.getLayoutType() == 1)) {
            arrayList.add(new RoleGroupUserUIData(2, HardCodeUtil.qqStr(R.string.f1502014c)));
            this.I = true;
        }
        arrayList.addAll(arrayList2);
    }

    private ArrayList<RoleGroupUserUIData> R1(ArrayList<IGProUserInfo> arrayList) {
        ArrayList<RoleGroupUserUIData> arrayList2 = new ArrayList<>();
        ArrayList<RoleGroupUserUIData> arrayList3 = new ArrayList<>();
        ArrayList<RoleGroupUserUIData> arrayList4 = new ArrayList<>();
        b2(arrayList, arrayList3, arrayList4);
        if (this.F.getValue() != null && !this.F.getValue().isEmpty()) {
            arrayList2.addAll(this.F.getValue());
        }
        N1(arrayList2, arrayList3);
        P1(arrayList2, arrayList4);
        return arrayList2;
    }

    private boolean T1() {
        if (this.J.getLayoutType() != 5 && !this.C.getIsRequesting() && !this.C.getIsDataEnd()) {
            return true;
        }
        return false;
    }

    private void a2(ArrayList<IGProUserInfo> arrayList, ArrayList<RoleGroupUserUIData> arrayList2) {
        if (TextUtils.equals(this.J.getRoleGroupId(), "2")) {
            Iterator<IGProUserInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                IGProUserInfo next = it.next();
                if (!ch.p0(next)) {
                    O1(next, arrayList2);
                }
            }
            return;
        }
        Iterator<IGProUserInfo> it5 = arrayList.iterator();
        while (it5.hasNext()) {
            O1(it5.next(), arrayList2);
        }
    }

    private void b2(ArrayList<IGProUserInfo> arrayList, ArrayList<RoleGroupUserUIData> arrayList2, ArrayList<RoleGroupUserUIData> arrayList3) {
        Iterator<IGProUserInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            IGProUserInfo next = it.next();
            if (ch.f0(next)) {
                O1(next, arrayList2);
            } else {
                O1(next, arrayList3);
            }
        }
    }

    private ArrayList<RoleGroupUserUIData> c2(ArrayList<RoleGroupUserUIData> arrayList) {
        Iterator<RoleGroupUserUIData> it = arrayList.iterator();
        while (it.hasNext()) {
            if (this.J.getExcludeList().contains(it.next().getMTinyId())) {
                it.remove();
            }
        }
        if (!arrayList.isEmpty() && arrayList.get(0).getType() != 2 && arrayList.get(0).getType() != 3) {
            arrayList.add(0, new RoleGroupUserUIData(3));
        }
        return arrayList;
    }

    private void e2(boolean z16) {
        if (!T1()) {
            return;
        }
        if (z16) {
            this.C.i(null);
            this.D.setValue(Boolean.TRUE);
        }
        this.C.a(100, z16);
    }

    private boolean n2() {
        if (TextUtils.equals(this.J.getRoleGroupId(), "2") && this.J.getLayoutType() == 3) {
            return true;
        }
        return false;
    }

    private void r2(ArrayList<RoleGroupUserUIData> arrayList) {
        this.E.postValue(c2(new ArrayList<>(arrayList)));
    }

    public void Q1(ArrayList<RoleGroupUserUIData> arrayList) {
        Iterator<RoleGroupUserUIData> it = arrayList.iterator();
        while (it.hasNext()) {
            RoleGroupUserUIData next = it.next();
            if (next != null && next.getType() == 1 && !TextUtils.isEmpty(next.getMTinyId())) {
                this.K.put(next.getMTinyId(), next);
            }
        }
        v2(arrayList);
    }

    public ArrayList<RoleGroupUserUIData> S1(ArrayList<IGProUserInfo> arrayList) {
        ArrayList<RoleGroupUserUIData> arrayList2 = new ArrayList<>();
        ArrayList<RoleGroupUserUIData> arrayList3 = new ArrayList<>();
        a2(arrayList, arrayList3);
        if (this.J.getLayoutType() == 1 && !this.I && !arrayList3.isEmpty()) {
            arrayList2.add(new RoleGroupUserUIData(2, HardCodeUtil.qqStr(R.string.f1502014c)));
            this.I = true;
        }
        if (this.F.getValue() != null && !this.F.getValue().isEmpty()) {
            arrayList2.addAll(this.F.getValue());
        }
        arrayList2.addAll(arrayList3);
        if (!this.H && n2()) {
            arrayList2.add(0, new RoleGroupUserUIData(2, HardCodeUtil.qqStr(R.string.f15008141)));
            this.H = true;
        }
        return arrayList2;
    }

    @MainThread
    public void U1() {
        this.C.i(null);
        this.C.k(false);
        this.C.j(false);
        W1();
    }

    @MainThread
    public void W1() {
        this.F.postValue(new ArrayList<>());
        this.H = false;
        this.I = false;
    }

    @MainThread
    public void X1() {
        this.E.postValue(new ArrayList<>());
    }

    public void Z1() {
        this.K.clear();
    }

    public void d2(int i3, String str) {
        QLog.w("Guild.rg.GuildRoleGroupFetchMemberViewModel", 1, "fetchMemberFail fail, errCode=" + i3 + "errMsg=" + str);
        BaseApplication context = BaseApplication.getContext();
        com.tencent.mobileqq.guild.util.security.b.c(context, i3, str, context.getString(R.string.f154581f7));
        W1();
    }

    public int f2() {
        return this.C.getTotalCount();
    }

    public ArrayList<RoleGroupUserUIData> g2() {
        if (this.F.getValue() == null) {
            return new ArrayList<>();
        }
        return this.F.getValue();
    }

    public cn<Boolean> h2() {
        return this.D;
    }

    public ArrayList<RoleGroupUserUIData> i2(Set<String> set) {
        ArrayList<RoleGroupUserUIData> arrayList = new ArrayList<>();
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(this.K.get(it.next()));
        }
        return arrayList;
    }

    public MutableLiveData<ArrayList<RoleGroupUserUIData>> j2() {
        return this.F;
    }

    public MutableLiveData<ArrayList<RoleGroupUserUIData>> k2() {
        return this.E;
    }

    public boolean l2() {
        return this.C.getIsDataEnd();
    }

    public boolean m2() {
        return this.C.getIsRequesting();
    }

    public void o2() {
        this.C.h(this.G, false);
    }

    public void p2() {
        e2(false);
    }

    public void q2(ArrayList<String> arrayList, ArrayList<String> arrayList2, @NonNull InterfaceC10621a interfaceC10621a) {
        this.C.g(arrayList, arrayList2, interfaceC10621a);
    }

    public void s2(List<IGProUserInfo> list) {
        ArrayList<RoleGroupUserUIData> arrayList = new ArrayList<>();
        a2(new ArrayList<>(list), arrayList);
        r2(arrayList);
    }

    public void t2(List<IGProUserInfo> list) {
        this.F.postValue(c2(S1(new ArrayList<>(list))));
    }

    public void u2(List<IGProUserInfo> list) {
        this.F.postValue(c2(R1(new ArrayList<>(list))));
    }

    public void v2(ArrayList<RoleGroupUserUIData> arrayList) {
        this.F.postValue(c2(new ArrayList<>(arrayList)));
    }

    public void w2() {
        e2(true);
    }

    public void x2(RoleGroupUserUIData roleGroupUserUIData) {
        ArrayList<RoleGroupUserUIData> value = this.F.getValue();
        if (value == null) {
            return;
        }
        ArrayList<RoleGroupUserUIData> arrayList = new ArrayList<>();
        Iterator<RoleGroupUserUIData> it = value.iterator();
        while (it.hasNext()) {
            RoleGroupUserUIData next = it.next();
            if (!TextUtils.equals(next.getMTinyId(), roleGroupUserUIData.getMTinyId())) {
                arrayList.add(next);
            }
        }
        v2(arrayList);
    }

    public void y2(int i3, String str) {
        QLog.w("Guild.rg.GuildRoleGroupFetchMemberViewModel", 1, "searchMemberFail fail, errCode=" + i3 + "errMsg=" + str);
        GuildCommonViewMemberFragment.showToast(BaseApplication.getContext().getString(R.string.f155011gc), 1);
        X1();
    }

    public void z2(String str) {
        this.G = str;
        this.C.h(str, true);
    }
}
