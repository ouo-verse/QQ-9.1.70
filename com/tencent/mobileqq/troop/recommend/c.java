package com.tencent.mobileqq.troop.recommend;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.recommend.data.RecommendTroopItem;
import java.util.List;
import tencent.im.oidb.cmd0xf57.cmd0xf57$MedalInfo;
import tencent.im.oidb.guild_search_recommend_svr.guildSearchRecommendSvr$FirstShow;
import tencent.im.oidb.guild_search_recommend_svr.guildSearchRecommendSvr$Label;

/* compiled from: P */
/* loaded from: classes19.dex */
public class c implements BusinessObserver {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static int f298243d;

    /* renamed from: e, reason: collision with root package name */
    public static final int f298244e;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f298245a;

        /* renamed from: b, reason: collision with root package name */
        public String f298246b;

        /* renamed from: c, reason: collision with root package name */
        public String f298247c;

        /* renamed from: d, reason: collision with root package name */
        public int f298248d;

        /* renamed from: e, reason: collision with root package name */
        public List<guildSearchRecommendSvr$Label> f298249e;

        /* renamed from: f, reason: collision with root package name */
        public List<guildSearchRecommendSvr$Label> f298250f;

        /* renamed from: g, reason: collision with root package name */
        public List<guildSearchRecommendSvr$Label> f298251g;

        /* renamed from: h, reason: collision with root package name */
        public List<cmd0xf57$MedalInfo> f298252h;

        /* renamed from: i, reason: collision with root package name */
        public String f298253i;

        /* renamed from: j, reason: collision with root package name */
        public String f298254j;

        /* renamed from: k, reason: collision with root package name */
        public int f298255k;

        /* renamed from: l, reason: collision with root package name */
        public int f298256l;

        /* renamed from: m, reason: collision with root package name */
        public int f298257m;

        /* renamed from: n, reason: collision with root package name */
        public String f298258n;

        /* renamed from: o, reason: collision with root package name */
        public String f298259o;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f298259o = "";
            }
        }

        public RecommendTroopItem a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (RecommendTroopItem) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            RecommendTroopItem recommendTroopItem = new RecommendTroopItem();
            recommendTroopItem.uin = this.f298245a;
            recommendTroopItem.name = this.f298246b;
            recommendTroopItem.intro = this.f298247c;
            recommendTroopItem.labelList = b.b(this.f298249e);
            recommendTroopItem.stateList = b.b(this.f298251g);
            recommendTroopItem.icon = this.f298258n;
            recommendTroopItem.type = this.f298257m;
            recommendTroopItem.memberNum = this.f298248d;
            recommendTroopItem.authSig = this.f298254j;
            recommendTroopItem.activity = this.f298255k;
            recommendTroopItem.privilege = this.f298256l;
            recommendTroopItem.recomAlgol = this.f298253i;
            recommendTroopItem.labels = this.f298250f;
            recommendTroopItem.medalInfoList = this.f298252h;
            recommendTroopItem.gameGradeIcon = b.a(this.f298249e);
            recommendTroopItem.recommendTrace = this.f298259o;
            return recommendTroopItem;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28858);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f298243d = 0 + 1;
            f298244e = 0;
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void b(int i3, boolean z16, Object obj) {
        boolean z17;
        if (i3 == f298244e && (obj instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            int intValue = ((Integer) objArr[0]).intValue();
            String str = (String) objArr[1];
            int intValue2 = ((Integer) objArr[2]).intValue();
            int intValue3 = ((Integer) objArr[3]).intValue();
            List<a> list = (List) objArr[4];
            guildSearchRecommendSvr$FirstShow guildsearchrecommendsvr_firstshow = (guildSearchRecommendSvr$FirstShow) objArr[5];
            ByteStringMicro byteStringMicro = (ByteStringMicro) objArr[6];
            boolean booleanValue = ((Boolean) objArr[7]).booleanValue();
            if (intValue3 == 1) {
                z17 = true;
            } else {
                z17 = false;
            }
            a(z16, intValue, str, intValue2, z17, list, guildsearchrecommendsvr_firstshow, byteStringMicro, booleanValue);
        }
    }

    protected void a(boolean z16, int i3, String str, int i16, boolean z17, List<a> list, guildSearchRecommendSvr$FirstShow guildsearchrecommendsvr_firstshow, ByteStringMicro byteStringMicro, boolean z18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), str, Integer.valueOf(i16), Boolean.valueOf(z17), list, guildsearchrecommendsvr_firstshow, byteStringMicro, Boolean.valueOf(z18));
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
        } else {
            b(i3, z16, obj);
        }
    }
}
