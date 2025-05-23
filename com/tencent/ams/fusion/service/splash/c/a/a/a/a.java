package com.tencent.ams.fusion.service.splash.c.a.a.a;

import android.text.TextUtils;
import android.util.Pair;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.ads.data.AdParam;
import com.tencent.ams.fusion.a.j;
import com.tencent.ams.fusion.service.splash.SplashConstants;
import com.tencent.ams.fusion.service.splash.data.d;
import com.tencent.ams.fusion.service.splash.model.SplashOrder;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdConfigDefine$VersionDefine;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.List;
import ot.c;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a implements SplashOrder {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private String f70396a;

    public a(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) cVar);
        } else {
            b(cVar);
        }
    }

    private void b(c cVar) {
        String str;
        int i3;
        int i16;
        int i17;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("oid");
        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
        sb5.append(j.a("55"));
        sb5.append(ContainerUtils.FIELD_DELIMITER);
        sb5.append("loc");
        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
        if (cVar != null) {
            str = cVar.i();
        } else {
            str = "";
        }
        sb5.append(j.a(str));
        sb5.append(ContainerUtils.FIELD_DELIMITER);
        sb5.append("loid");
        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
        sb5.append(j.a(0));
        sb5.append(ContainerUtils.FIELD_DELIMITER);
        sb5.append("seq");
        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
        sb5.append(j.a(0));
        sb5.append(ContainerUtils.FIELD_DELIMITER);
        sb5.append("index");
        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
        sb5.append(j.a(0));
        sb5.append(ContainerUtils.FIELD_DELIMITER);
        sb5.append(WadlProxyConsts.CHANNEL);
        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
        sb5.append(j.a(com.tencent.ams.fusion.a.a.a(0)));
        sb5.append(ContainerUtils.FIELD_DELIMITER);
        sb5.append("pv_type");
        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
        sb5.append(j.a(Integer.valueOf(com.tencent.ams.fusion.service.splash.a.a.d().k())));
        sb5.append(ContainerUtils.FIELD_DELIMITER);
        sb5.append("chid");
        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
        if (cVar != null) {
            i3 = cVar.n();
        } else {
            i3 = 0;
        }
        sb5.append(j.a(Integer.valueOf(i3)));
        sb5.append(ContainerUtils.FIELD_DELIMITER);
        sb5.append("appversion");
        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
        sb5.append(j.a(SplashConstants.f70308a));
        sb5.append(ContainerUtils.FIELD_DELIMITER);
        sb5.append(AdParam.PF);
        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
        sb5.append(j.a(QAdConfigDefine$VersionDefine.K_QAD_PF));
        sb5.append(ContainerUtils.FIELD_DELIMITER);
        sb5.append(AdParam.DTYPE);
        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
        sb5.append(j.a("3"));
        sb5.append(ContainerUtils.FIELD_DELIMITER);
        sb5.append("splash_fst");
        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
        sb5.append(j.a(0));
        sb5.append(ContainerUtils.FIELD_DELIMITER);
        sb5.append("exp");
        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
        sb5.append(j.a(0));
        sb5.append(ContainerUtils.FIELD_DELIMITER);
        sb5.append("calltype");
        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
        if (cVar != null && cVar.a()) {
            i16 = 1;
        } else {
            i16 = 0;
        }
        sb5.append(j.a(Integer.valueOf(i16)));
        sb5.append(ContainerUtils.FIELD_DELIMITER);
        sb5.append("callfrom");
        sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
        if (cVar != null) {
            i17 = cVar.m();
        } else {
            i17 = 5;
        }
        sb5.append(j.a(Integer.valueOf(i17)));
        String j3 = com.tencent.ams.fusion.service.splash.a.a.d().j();
        if (TextUtils.isEmpty(j3)) {
            j3 = "https://p.l.qq.com/p?";
        }
        if (!j3.endsWith(ContainerUtils.FIELD_DELIMITER) && !j3.endsWith(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
            sb5.insert(0, ContainerUtils.FIELD_DELIMITER);
        }
        sb5.insert(0, j3);
        this.f70396a = sb5.toString();
    }

    @Override // com.tencent.ams.fusion.service.splash.model.SplashOrder
    public List<Pair<Integer, Integer>> F(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        }
        return null;
    }

    @Override // com.tencent.ams.fusion.service.splash.model.SplashOrder
    public int G(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Integer) iPatchRedirector.redirect((short) 34, (Object) this, (Object) str)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.ams.fusion.service.splash.model.SplashOrder
    public SplashOrder a(SplashOrder splashOrder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (SplashOrder) iPatchRedirector.redirect((short) 30, (Object) this, (Object) splashOrder);
        }
        return splashOrder;
    }

    @Override // com.tencent.ams.fusion.service.splash.model.SplashOrder
    public boolean aA() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.ams.fusion.service.splash.model.SplashOrder
    public String aB() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.ams.fusion.service.splash.model.SplashOrder
    public String aC() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.ams.fusion.service.splash.model.SplashOrder
    public List<com.tencent.ams.fusion.service.splash.b.a.a> aD() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (List) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.ams.fusion.service.splash.model.SplashOrder
    public List<com.tencent.ams.fusion.service.splash.b.a.a> aE() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (List) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.ams.fusion.service.splash.model.SplashOrder
    public List<com.tencent.ams.fusion.service.splash.b.a.a> aF() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (List) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.ams.fusion.service.splash.model.SplashOrder
    public List<com.tencent.ams.fusion.service.splash.b.a.a> aG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (List) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.ams.fusion.service.splash.model.SplashOrder
    public List<com.tencent.ams.fusion.service.splash.b.a.a> aL() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (List) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.ams.fusion.service.splash.model.SplashOrder
    public List<com.tencent.ams.fusion.service.splash.b.a.a> aM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (List) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.ams.fusion.service.splash.model.SplashOrder
    public List<com.tencent.ams.fusion.service.splash.b.a.a> aN() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (List) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.ams.fusion.service.splash.model.SplashOrder
    public List<com.tencent.ams.fusion.service.splash.b.a.a> aO() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (List) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.ams.fusion.service.splash.model.SplashOrder
    public List<com.tencent.ams.fusion.service.splash.b.a.a> aP() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (List) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.ams.fusion.service.splash.model.SplashOrder
    public d aQ() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (d) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.ams.fusion.service.splash.model.SplashOrder
    public com.tencent.ams.fusion.service.splash.data.c aR() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (com.tencent.ams.fusion.service.splash.data.c) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.ams.fusion.service.splash.model.SplashOrder
    public String au() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.ams.fusion.service.splash.model.SplashOrder
    public int av() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.ams.fusion.service.splash.model.SplashOrder
    public boolean aw() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.ams.fusion.service.splash.model.SplashOrder
    public boolean ax() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.ams.fusion.service.splash.model.SplashOrder
    public int az() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Integer) iPatchRedirector.redirect((short) 32, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.ams.fusion.service.splash.model.SplashOrder
    public long ba() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Long) iPatchRedirector.redirect((short) 26, (Object) this)).longValue();
        }
        return 0L;
    }

    @Override // com.tencent.ams.fusion.service.splash.model.SplashOrder
    public int bd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.ams.fusion.service.splash.model.SplashOrder
    public int bf() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Integer) iPatchRedirector.redirect((short) 33, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.ams.fusion.service.splash.model.SplashOrder
    public int bh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.ams.fusion.service.splash.model.SplashOrder
    public boolean bk() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.ams.fusion.service.splash.model.SplashOrder
    public boolean bl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Boolean) iPatchRedirector.redirect((short) 28, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.ams.fusion.service.splash.model.SplashOrder
    public boolean bm() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Boolean) iPatchRedirector.redirect((short) 29, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.ams.fusion.service.splash.model.SplashOrder
    public String bn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.ams.fusion.service.splash.model.SplashOrder
    public boolean bp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Boolean) iPatchRedirector.redirect((short) 31, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.ams.fusion.service.splash.model.SplashOrder
    public String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "55";
    }

    @Override // com.tencent.ams.fusion.service.splash.model.SplashOrder
    public String y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return null;
    }
}
