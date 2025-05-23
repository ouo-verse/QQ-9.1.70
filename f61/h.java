package f61;

import com.tencent.mobileqq.mutualmark.model.MutualMarkModel;
import com.tencent.mobileqq.partner.signin.pb.SigninPB$SignInInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.mutualmark.mutualmark$State;
import tencent.im.oidb.oidb_0x1250.oidb_0x1250$Guide;
import tencent.im.oidb.oidb_0x1250.oidb_0x1250$MutualMarkList;
import tencent.im.oidb.oidb_0x1250.oidb_0x1250$PartnerInfo;

/* compiled from: P */
/* loaded from: classes10.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public int f397920a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f397921b = 0;

    /* renamed from: c, reason: collision with root package name */
    public final List<MutualMarkModel> f397922c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public final List<MutualMarkModel> f397923d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public final List<MutualMarkModel> f397924e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    public final List<MutualMarkModel> f397925f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    public final List<d> f397926g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    public final List<j> f397927h = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    public final List<com.tencent.mobileqq.partner.signin.drawer.f> f397928i = new ArrayList();

    public static h a(oidb_0x1250$MutualMarkList oidb_0x1250_mutualmarklist) {
        h hVar = new h();
        if (oidb_0x1250_mutualmarklist == null) {
            return hVar;
        }
        if (oidb_0x1250_mutualmarklist.lightup_num.has()) {
            hVar.f397920a = oidb_0x1250_mutualmarklist.lightup_num.get();
        }
        if (oidb_0x1250_mutualmarklist.total_num.has()) {
            hVar.f397921b = oidb_0x1250_mutualmarklist.total_num.get();
        }
        if (oidb_0x1250_mutualmarklist.rpt_all_mutual_mark.has()) {
            Iterator<mutualmark$State> it = oidb_0x1250_mutualmarklist.rpt_all_mutual_mark.get().iterator();
            while (it.hasNext()) {
                hVar.f397922c.add(g.a(it.next()));
            }
        }
        if (oidb_0x1250_mutualmarklist.rpt_prefetch_mutual_mark.has()) {
            Iterator<mutualmark$State> it5 = oidb_0x1250_mutualmarklist.rpt_prefetch_mutual_mark.get().iterator();
            while (it5.hasNext()) {
                hVar.f397923d.add(g.a(it5.next()));
            }
        }
        if (oidb_0x1250_mutualmarklist.rpt_degrade_mutual_mark.has()) {
            Iterator<mutualmark$State> it6 = oidb_0x1250_mutualmarklist.rpt_degrade_mutual_mark.get().iterator();
            while (it6.hasNext()) {
                hVar.f397924e.add(g.a(it6.next()));
            }
        }
        if (oidb_0x1250_mutualmarklist.rpt_lightoff_mutual_mark.has()) {
            Iterator<mutualmark$State> it7 = oidb_0x1250_mutualmarklist.rpt_lightoff_mutual_mark.get().iterator();
            while (it7.hasNext()) {
                hVar.f397925f.add(g.a(it7.next()));
            }
        }
        if (oidb_0x1250_mutualmarklist.guides.has()) {
            Iterator<oidb_0x1250$Guide> it8 = oidb_0x1250_mutualmarklist.guides.get().iterator();
            while (it8.hasNext()) {
                hVar.f397926g.add(d.a(it8.next()));
            }
        }
        if (oidb_0x1250_mutualmarklist.partner_infos.has()) {
            Iterator<oidb_0x1250$PartnerInfo> it9 = oidb_0x1250_mutualmarklist.partner_infos.get().iterator();
            while (it9.hasNext()) {
                hVar.f397927h.add(j.a(it9.next()));
            }
        }
        if (oidb_0x1250_mutualmarklist.sign_in_infos.has()) {
            for (SigninPB$SignInInfo signinPB$SignInInfo : oidb_0x1250_mutualmarklist.sign_in_infos.get()) {
                hVar.f397928i.add(new com.tencent.mobileqq.partner.signin.drawer.f(signinPB$SignInInfo.mark_id.get(), com.tencent.mobileqq.partner.signin.c.a(signinPB$SignInInfo.siginin_detail, 0, signinPB$SignInInfo.mark_id.get()), signinPB$SignInInfo.detail_url.get()));
            }
        }
        return hVar;
    }
}
