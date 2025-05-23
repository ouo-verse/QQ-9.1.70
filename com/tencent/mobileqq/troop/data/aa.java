package com.tencent.mobileqq.troop.data;

import android.graphics.Color;
import android.util.SparseArray;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.profilecard.vas.misc.VasProfileTemplatePreloadHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ThemeLabelTextView;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes19.dex */
public class aa {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    private static aa f294885c;

    /* renamed from: a, reason: collision with root package name */
    public int f294886a;

    /* renamed from: b, reason: collision with root package name */
    protected SparseArray<a> f294887b;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f294888a;

        /* renamed from: b, reason: collision with root package name */
        public int f294889b;

        /* renamed from: c, reason: collision with root package name */
        public String f294890c;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    aa() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f294887b = new SparseArray<>();
            this.f294886a = BaseApplication.getContext().getResources().getColor(R.color.f157716xl);
        }
    }

    public static synchronized aa a() {
        aa aaVar;
        synchronized (aa.class) {
            if (f294885c == null) {
                f294885c = b();
            }
            aaVar = f294885c;
        }
        return aaVar;
    }

    protected static aa b() {
        aa aaVar;
        try {
            aaVar = e(BaseApplication.getContext().getSharedPreferences("troop_rank_cfg", 0).getString("rank_map_key", ""));
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.w("TroopRankConfig", 2, "getConfigFromLocal exp:", e16);
            }
            aaVar = null;
        }
        if (aaVar == null) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopRankConfig", 2, "getConfigFromLocal exp, localConfig==null");
            }
            aa aaVar2 = new aa();
            a aVar = new a();
            aVar.f294888a = 300;
            aVar.f294890c = HardCodeUtil.qqStr(R.string.upl);
            aVar.f294889b = Color.parseColor("#F4BF20");
            a aVar2 = new a();
            aVar2.f294888a = 301;
            aVar2.f294890c = HardCodeUtil.qqStr(R.string.upa);
            aVar2.f294889b = Color.parseColor("#6CD9A3");
            a aVar3 = new a();
            aVar3.f294888a = 302;
            aVar3.f294890c = "";
            aVar3.f294889b = Color.parseColor("#B395EF");
            a aVar4 = new a();
            aVar4.f294888a = 303;
            aVar4.f294890c = HardCodeUtil.qqStr(R.string.upb);
            aVar4.f294889b = Color.parseColor("#F4BF20");
            a aVar5 = new a();
            aVar5.f294888a = 304;
            aVar5.f294890c = HardCodeUtil.qqStr(R.string.upi);
            aVar5.f294889b = Color.parseColor("#6CD9A3");
            a aVar6 = new a();
            aVar6.f294888a = 305;
            aVar6.f294890c = HardCodeUtil.qqStr(R.string.upd);
            aVar6.f294889b = Color.parseColor("#FF988A");
            a aVar7 = new a();
            aVar7.f294888a = 306;
            aVar7.f294890c = HardCodeUtil.qqStr(R.string.upk);
            aVar7.f294889b = Color.parseColor("#F4BF20");
            a aVar8 = new a();
            aVar8.f294888a = 307;
            aVar8.f294890c = HardCodeUtil.qqStr(R.string.upf);
            aVar8.f294889b = Color.parseColor("#72CCE6");
            a aVar9 = new a();
            aVar9.f294888a = 308;
            aVar9.f294890c = HardCodeUtil.qqStr(R.string.upj);
            aVar9.f294889b = Color.parseColor("#FF988A");
            a aVar10 = new a();
            aVar10.f294888a = 315;
            aVar10.f294890c = "";
            aVar10.f294889b = Color.parseColor("#8EBDF9");
            a aVar11 = new a();
            aVar11.f294888a = 311;
            aVar11.f294890c = HardCodeUtil.qqStr(R.string.upe);
            aVar11.f294889b = Color.parseColor("#F25D5D");
            a aVar12 = new a();
            aVar12.f294888a = 312;
            aVar12.f294890c = HardCodeUtil.qqStr(R.string.upg);
            aVar12.f294889b = Color.parseColor("#F25D5D");
            a aVar13 = new a();
            aVar13.f294888a = 313;
            aVar13.f294890c = HardCodeUtil.qqStr(R.string.upn);
            aVar13.f294889b = Color.parseColor("#FFA5BD");
            a aVar14 = new a();
            aVar14.f294888a = 314;
            aVar14.f294890c = HardCodeUtil.qqStr(R.string.upc);
            aVar14.f294889b = Color.parseColor("#FFA5BD");
            a aVar15 = new a();
            aVar15.f294888a = 332;
            aVar15.f294890c = HardCodeUtil.qqStr(R.string.uph);
            aVar15.f294889b = Color.parseColor("#F4C020");
            a aVar16 = new a();
            aVar16.f294888a = 333;
            aVar16.f294890c = HardCodeUtil.qqStr(R.string.upm);
            aVar16.f294889b = Color.parseColor("#F4C020");
            aaVar2.f294887b.put(300, aVar);
            aaVar2.f294887b.put(301, aVar2);
            aaVar2.f294887b.put(302, aVar3);
            aaVar2.f294887b.put(303, aVar4);
            aaVar2.f294887b.put(304, aVar5);
            aaVar2.f294887b.put(305, aVar6);
            aaVar2.f294887b.put(306, aVar7);
            aaVar2.f294887b.put(307, aVar8);
            aaVar2.f294887b.put(308, aVar9);
            aaVar2.f294887b.put(311, aVar11);
            aaVar2.f294887b.put(312, aVar12);
            aaVar2.f294887b.put(313, aVar13);
            aaVar2.f294887b.put(314, aVar14);
            aaVar2.f294887b.put(315, aVar10);
            aaVar2.f294887b.put(332, aVar15);
            aaVar2.f294887b.put(333, aVar16);
            return aaVar2;
        }
        return aaVar;
    }

    protected static aa e(String str) {
        try {
            aa aaVar = new aa();
            JSONArray jSONArray = new JSONObject(str).getJSONArray("rankMap");
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                a aVar = new a();
                aVar.f294888a = jSONObject.getInt("id");
                aVar.f294890c = jSONObject.getString("rank");
                aVar.f294889b = Color.parseColor(jSONObject.getString(VasProfileTemplatePreloadHelper.BACKGROUND));
                aaVar.f294887b.put(aVar.f294888a, aVar);
            }
            return aaVar;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.w("TroopRankConfig", 2, "parseConfig exp:", e16);
                return null;
            }
            return null;
        }
    }

    public static synchronized boolean f(String str) {
        synchronized (aa.class) {
            try {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopRankConfig", 2, "refreshConfig:" + str);
                }
                aa e16 = e(str);
                if (e16 != null) {
                    f294885c = e16;
                    BaseApplication.getContext().getSharedPreferences("troop_rank_cfg", 0).edit().putString("rank_map_key", str).commit();
                    return true;
                }
            } catch (Exception e17) {
                if (QLog.isColorLevel()) {
                    QLog.e("TroopRankConfig", 2, "TroopRankTitleConfig.refreshConfig exp, jsonStr=" + str, e17);
                }
            }
            return false;
        }
    }

    public static void i(TextView textView, int i3) {
        textView.setBackgroundDrawable(com.tencent.mobileqq.troop.utils.a.a(BaseApplication.getContext().getResources(), i3));
        if (textView instanceof ThemeLabelTextView) {
            ((ThemeLabelTextView) textView).setSupportMaskView(true);
        }
    }

    public a c(int i3, boolean z16, boolean z17, boolean z18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18));
        }
        if (i3 < 10000 && i3 > 0) {
            return g(this.f294887b.get(i3), z17, z18, true);
        }
        if (z16) {
            return g(this.f294887b.get(302), z17, z18, true);
        }
        if (z17) {
            return this.f294887b.get(300);
        }
        if (z18) {
            return this.f294887b.get(301);
        }
        return this.f294887b.get(i3 - 10000);
    }

    public boolean d(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) str2)).booleanValue();
        }
        try {
            boolean z16 = BaseApplication.getContext().getSharedPreferences("troop_rank_cfg", 4).getBoolean("new_rank_flag" + str + "_" + str2, false);
            if (QLog.isColorLevel()) {
                QLog.d("TroopRankConfig", 2, "hasNewRankRedDot: troopUin=" + str + ", memberUin=" + str2 + ", ret=" + z16);
            }
            return z16;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.w("TroopRankConfig", 2, "hasNewRankRedDot exp:", e16);
            }
            return false;
        }
    }

    protected a g(a aVar, boolean z16, boolean z17, boolean z18) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (a) iPatchRedirector.redirect((short) 3, this, aVar, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18));
        }
        if (aVar != null && (i3 = aVar.f294888a) != 300 && i3 != 301) {
            if (z16 && this.f294887b.get(300) != null) {
                if (z18) {
                    a aVar2 = new a();
                    aVar2.f294888a = aVar.f294888a;
                    aVar2.f294890c = aVar.f294890c;
                    aVar2.f294889b = this.f294887b.get(300).f294889b;
                    return aVar2;
                }
                aVar.f294889b = this.f294887b.get(300).f294889b;
            } else if (z17 && this.f294887b.get(301) != null) {
                if (z18) {
                    a aVar3 = new a();
                    aVar3.f294888a = aVar.f294888a;
                    aVar3.f294890c = aVar.f294890c;
                    aVar3.f294889b = this.f294887b.get(301).f294889b;
                    return aVar3;
                }
                aVar.f294889b = this.f294887b.get(301).f294889b;
            }
        }
        return aVar;
    }

    public void h(String str, String str2, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, str2, Boolean.valueOf(z16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopRankConfig", 2, "setHasNewRankRedDot, troopUin=" + str + ", memberUin=" + str2 + ", hasRedDot=" + z16);
        }
        try {
            BaseApplication.getContext().getSharedPreferences("troop_rank_cfg", 4).edit().putBoolean("new_rank_flag" + str + "_" + str2, z16).commit();
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.w("TroopRankConfig", 2, "setHasNewRankRedDot exp:", e16);
            }
        }
    }
}
