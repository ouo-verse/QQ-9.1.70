package com.tencent.mobileqq.troop.entereffect;

import QQService.EVIPSPEC;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.VipTypeParam;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.vasinfo.api.IVasInfoService;
import com.tencent.qqnt.ntrelation.vasinfo.bean.NTVasSimpleInfo;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.qun.group_effect.group_effect$EffectInfo;
import tencent.qun.group_effect.group_effect$UserConfig;
import tencent.qun.group_effect.group_effect_commu$TEffectDetail;
import tencent.qun.group_effect.group_effect_commu$TGetMyEffectRsp0x2;

/* compiled from: P */
/* loaded from: classes19.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public boolean f295226a;

    /* renamed from: b, reason: collision with root package name */
    public b f295227b;

    /* renamed from: c, reason: collision with root package name */
    public AtomicBoolean f295228c;

    /* renamed from: d, reason: collision with root package name */
    public Vector<d> f295229d;

    /* renamed from: e, reason: collision with root package name */
    private Comparator<d> f295230e;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a implements Comparator<d> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(d dVar, d dVar2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) dVar, (Object) dVar2)).intValue();
            }
            return dVar2.f295243c - dVar.f295243c;
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f295232a;

        /* renamed from: b, reason: collision with root package name */
        public int f295233b;

        /* renamed from: c, reason: collision with root package name */
        public String f295234c;

        /* renamed from: d, reason: collision with root package name */
        public ConcurrentHashMap<String, c> f295235d;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f295232a = 600;
                this.f295235d = new ConcurrentHashMap<>();
            }
        }

        public void a(group_effect_commu$TGetMyEffectRsp0x2 group_effect_commu_tgetmyeffectrsp0x2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) group_effect_commu_tgetmyeffectrsp0x2);
                return;
            }
            this.f295232a = group_effect_commu_tgetmyeffectrsp0x2.query_interval.get();
            this.f295233b = group_effect_commu_tgetmyeffectrsp0x2.global_effect_id.get();
            group_effect$EffectInfo group_effect_effectinfo = group_effect_commu_tgetmyeffectrsp0x2.st_global_effectinfo.get();
            if (group_effect_effectinfo != null) {
                this.f295234c = group_effect_effectinfo.name.get();
            }
            if (group_effect_commu_tgetmyeffectrsp0x2.rpt_userconfig.has() && group_effect_commu_tgetmyeffectrsp0x2.rpt_userconfig.size() > 0) {
                List<group_effect_commu$TEffectDetail> list = group_effect_commu_tgetmyeffectrsp0x2.rpt_userconfig.get();
                for (int i3 = 0; i3 < list.size(); i3++) {
                    group_effect_commu$TEffectDetail group_effect_commu_teffectdetail = list.get(i3);
                    c cVar = new c();
                    cVar.a(group_effect_commu_teffectdetail);
                    if (QLog.isDebugVersion()) {
                        QLog.d("EffectInfo.TAG", 2, "mergeFromPB rpt_userconfig index = " + i3 + " detail = " + cVar.toString());
                    }
                    this.f295235d.put(cVar.f295236a + "", cVar);
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("EffectInfo.TAG", 2, "mergeFromPB nextReqTime = " + this.f295232a + " global_effectId = " + this.f295233b + " global_effectName = " + this.f295234c + " individual effect size = " + this.f295235d.size());
            }
        }

        public group_effect_commu$TGetMyEffectRsp0x2 b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (group_effect_commu$TGetMyEffectRsp0x2) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            group_effect_commu$TGetMyEffectRsp0x2 group_effect_commu_tgetmyeffectrsp0x2 = new group_effect_commu$TGetMyEffectRsp0x2();
            group_effect_commu_tgetmyeffectrsp0x2.query_interval.set(this.f295232a);
            group_effect_commu_tgetmyeffectrsp0x2.global_effect_id.set(this.f295233b);
            new group_effect$EffectInfo().name.set(this.f295234c);
            if (this.f295235d.size() > 0) {
                ArrayList arrayList = new ArrayList();
                Iterator<Map.Entry<String, c>> it = this.f295235d.entrySet().iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().getValue().b());
                }
                group_effect_commu_tgetmyeffectrsp0x2.rpt_userconfig.set(arrayList);
            }
            return group_effect_commu_tgetmyeffectrsp0x2;
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public long f295236a;

        /* renamed from: b, reason: collision with root package name */
        public int f295237b;

        /* renamed from: c, reason: collision with root package name */
        public String f295238c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f295239d;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public void a(group_effect_commu$TEffectDetail group_effect_commu_teffectdetail) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) group_effect_commu_teffectdetail);
                return;
            }
            group_effect$UserConfig group_effect_userconfig = group_effect_commu_teffectdetail.st_userconfig.get();
            group_effect$EffectInfo group_effect_effectinfo = group_effect_commu_teffectdetail.st_effectinfo.get();
            this.f295237b = group_effect_userconfig.effect_id.get();
            this.f295238c = group_effect_effectinfo.name.get();
            this.f295236a = group_effect_userconfig.group_code.get();
            if (group_effect_userconfig.status.get() != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.f295239d = z16;
        }

        public group_effect_commu$TEffectDetail b() {
            long j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (group_effect_commu$TEffectDetail) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            group_effect_commu$TEffectDetail group_effect_commu_teffectdetail = new group_effect_commu$TEffectDetail();
            group_effect$UserConfig group_effect_userconfig = new group_effect$UserConfig();
            group_effect_userconfig.effect_id.set(this.f295237b);
            group_effect_userconfig.group_code.set(this.f295236a);
            PBUInt64Field pBUInt64Field = group_effect_userconfig.status;
            if (this.f295239d) {
                j3 = 1;
            } else {
                j3 = 0;
            }
            pBUInt64Field.set(j3);
            new group_effect$EffectInfo().name.set(this.f295238c);
            return group_effect_commu_teffectdetail;
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (String) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return "{groupCode: " + this.f295236a + ", effectId: " + this.f295237b + ", isOn: " + this.f295239d + "}";
        }

        public c(long j3, int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), Integer.valueOf(i3), str);
                return;
            }
            this.f295236a = j3;
            this.f295237b = i3;
            this.f295238c = str;
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class d {
        static IPatchRedirector $redirector_;

        /* renamed from: o, reason: collision with root package name */
        private static final String f295240o;

        /* renamed from: a, reason: collision with root package name */
        public int f295241a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f295242b;

        /* renamed from: c, reason: collision with root package name */
        public int f295243c;

        /* renamed from: d, reason: collision with root package name */
        public String f295244d;

        /* renamed from: e, reason: collision with root package name */
        public ArrayList<a> f295245e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f295246f;

        /* renamed from: g, reason: collision with root package name */
        public int f295247g;

        /* renamed from: h, reason: collision with root package name */
        public String f295248h;

        /* renamed from: i, reason: collision with root package name */
        public int f295249i;

        /* renamed from: j, reason: collision with root package name */
        public int f295250j;

        /* renamed from: k, reason: collision with root package name */
        public int f295251k;

        /* renamed from: l, reason: collision with root package name */
        public String f295252l;

        /* renamed from: m, reason: collision with root package name */
        public ArrayList<Integer> f295253m;

        /* renamed from: n, reason: collision with root package name */
        public int f295254n;

        /* compiled from: P */
        /* loaded from: classes19.dex */
        public static class a {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            public int f295255a;

            /* renamed from: b, reason: collision with root package name */
            public int f295256b;

            /* renamed from: c, reason: collision with root package name */
            public String f295257c;

            public a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28518);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 4)) {
                redirector.redirect((short) 4);
            } else {
                f295240o = HardCodeUtil.qqStr(R.string.f172811ue4);
            }
        }

        public d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f295245e = new ArrayList<>();
                this.f295253m = new ArrayList<>();
            }
        }

        public static int a(AppRuntime appRuntime) {
            int i3;
            NTVasSimpleInfo vasSimpleInfoWithUid = ((IVasInfoService) QRoute.api(IVasInfoService.class)).getVasSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(appRuntime.getCurrentUin()), "GrayTipsConfig.GrayTips");
            if (vasSimpleInfoWithUid == null) {
                return 1;
            }
            VipTypeParam vipTypeParam = new VipTypeParam(vasSimpleInfoWithUid.qqVipInfo, vasSimpleInfoWithUid.superQqInfo, vasSimpleInfoWithUid.superVipInfo, vasSimpleInfoWithUid.bigClubInfo);
            EVIPSPEC evipspec = EVIPSPEC.E_SP_QQVIP;
            boolean isServiceEnabled = vipTypeParam.isServiceEnabled(evipspec);
            EVIPSPEC evipspec2 = EVIPSPEC.E_SP_SUPERVIP;
            if (vipTypeParam.isServiceEnabled(evipspec2)) {
                if (vipTypeParam.getServiceType(evipspec2) == 1) {
                    i3 = 22;
                } else {
                    i3 = 5;
                }
                return i3;
            }
            if (!isServiceEnabled) {
                return 1;
            }
            if (vipTypeParam.getServiceType(evipspec) == 1) {
                return 21;
            }
            return 4;
        }

        private void d() {
            int i3;
            int indexOf;
            while (this.f295244d.indexOf(91) > 0) {
                int indexOf2 = this.f295244d.indexOf(91);
                String replaceFirst = this.f295244d.replaceFirst("\\[", "");
                this.f295244d = replaceFirst;
                int indexOf3 = replaceFirst.indexOf(93, indexOf2);
                if (indexOf3 > 0) {
                    this.f295244d = this.f295244d.replaceFirst("]", "");
                    indexOf3--;
                }
                if (indexOf3 < this.f295244d.length() - 1) {
                    int i16 = indexOf3 + 1;
                    if (this.f295244d.charAt(i16) == '(' && (indexOf = this.f295244d.indexOf(41, (i3 = indexOf3 + 2))) > 0) {
                        String substring = this.f295244d.substring(i3, indexOf);
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(this.f295244d.substring(0, i3 - 1));
                        String str = this.f295244d;
                        sb5.append(str.substring(indexOf + 1, str.length()));
                        this.f295244d = sb5.toString();
                        a aVar = new a();
                        aVar.f295255a = indexOf2;
                        aVar.f295256b = i16;
                        aVar.f295257c = substring;
                        this.f295245e.add(aVar);
                    }
                }
            }
        }

        public boolean b(int i3, AppRuntime appRuntime) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) appRuntime)).booleanValue();
            }
            int a16 = a(appRuntime);
            if (!this.f295242b) {
                return false;
            }
            int i16 = this.f295254n;
            if (i3 != i16 && i16 != 0) {
                return false;
            }
            if (!this.f295253m.contains(Integer.valueOf(a16)) && !this.f295253m.contains(0)) {
                return false;
            }
            return true;
        }

        public void c(JSONObject jSONObject) {
            boolean z16;
            boolean z17;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) jSONObject);
                return;
            }
            if (jSONObject == null) {
                QLog.e("GrayTipsConfig.GrayTips", 1, "mergeFromJson error grayTipsObj == null");
                return;
            }
            this.f295241a = jSONObject.optInt("id");
            if (jSONObject.optInt(AppConstants.Key.COLUMN_IS_VALID) == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.f295242b = z16;
            this.f295243c = jSONObject.optInt("priority");
            this.f295244d = jSONObject.optString("wording");
            d();
            if (jSONObject.optInt("noLongerPrompt") == 1) {
                z17 = true;
            } else {
                z17 = false;
            }
            this.f295246f = z17;
            if (z17) {
                this.f295244d += f295240o;
            }
            this.f295247g = jSONObject.optInt("linkType");
            this.f295248h = jSONObject.optString("serviceCode");
            this.f295249i = jSONObject.optInt("hardType");
            this.f295250j = jSONObject.optInt("openMonth");
            this.f295251k = jSONObject.optInt("hardMonth");
            this.f295252l = jSONObject.optString("aidAndroid");
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("vipType");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        this.f295253m.add(Integer.valueOf(optJSONArray.getInt(i3)));
                    }
                }
            } catch (Exception e16) {
                QLog.e("GrayTipsConfig.GrayTips", 1, "mergeFromJson error: " + e16.getMessage());
            }
            this.f295254n = jSONObject.optInt("settingStatus");
        }
    }

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f295228c = new AtomicBoolean(false);
        this.f295229d = new Vector<>();
        this.f295230e = new a();
    }

    public void a(String str) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray optJSONArray = jSONObject.optJSONArray("effectSwitch");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                if (optJSONArray.getJSONObject(0).optInt("androidSwitch") == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                this.f295226a = z16;
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("grayMsgList");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                    JSONObject jSONObject2 = optJSONArray2.getJSONObject(i3);
                    d dVar = new d();
                    dVar.c(jSONObject2);
                    this.f295229d.add(dVar);
                }
                Collections.sort(this.f295229d, this.f295230e);
            }
            if (QLog.isColorLevel()) {
                QLog.d("TroopEnterEffectConfig.Config", 2, "config mergeFromJSON enable = " + this.f295226a + " graytips: " + this.f295229d.size());
            }
        } catch (Exception e16) {
            QLog.e("TroopEnterEffectConfig.Config", 1, "mergeFromJSON error: " + e16.getMessage());
        }
    }
}
