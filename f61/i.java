package f61;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4$DnaDetail;
import tencent.im.oidb.oidb_0xcf4.oidb_0xcf4$NewDnaInfo;

/* compiled from: P */
/* loaded from: classes10.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    public int f397929a;

    /* renamed from: b, reason: collision with root package name */
    public String f397930b;

    /* renamed from: c, reason: collision with root package name */
    public String f397931c;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList<a> f397932d;

    /* renamed from: e, reason: collision with root package name */
    public String f397933e;

    /* renamed from: f, reason: collision with root package name */
    public String f397934f;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public String f397935a;

        /* renamed from: b, reason: collision with root package name */
        public int f397936b;

        /* renamed from: c, reason: collision with root package name */
        public int f397937c;

        public static a a(oidb_0xcf4$DnaDetail oidb_0xcf4_dnadetail) {
            if (oidb_0xcf4_dnadetail != null && oidb_0xcf4_dnadetail.has()) {
                a aVar = new a();
                if (oidb_0xcf4_dnadetail.bytes_desc.has()) {
                    aVar.f397935a = oidb_0xcf4_dnadetail.bytes_desc.get().toStringUtf8();
                }
                if (oidb_0xcf4_dnadetail.uint32_bold_index.has()) {
                    aVar.f397936b = oidb_0xcf4_dnadetail.uint32_bold_index.get();
                }
                if (oidb_0xcf4_dnadetail.uint32_bold_len.has()) {
                    aVar.f397937c = oidb_0xcf4_dnadetail.uint32_bold_len.get();
                }
                return aVar;
            }
            return null;
        }

        public String toString() {
            return "DnaDetail{description=" + this.f397935a + ", boldIndex=" + this.f397936b + ", boldLen=" + this.f397937c + '}';
        }
    }

    public static ArrayList<i> a(List<oidb_0xcf4$NewDnaInfo> list) {
        if (list != null && !list.isEmpty()) {
            ArrayList<i> arrayList = new ArrayList<>();
            for (oidb_0xcf4$NewDnaInfo oidb_0xcf4_newdnainfo : list) {
                if (oidb_0xcf4_newdnainfo != null && oidb_0xcf4_newdnainfo.has()) {
                    i iVar = new i();
                    if (oidb_0xcf4_newdnainfo.eDnaType.has()) {
                        iVar.f397929a = oidb_0xcf4_newdnainfo.eDnaType.get();
                    }
                    if (oidb_0xcf4_newdnainfo.bytes_title.has()) {
                        iVar.f397930b = oidb_0xcf4_newdnainfo.bytes_title.get().toStringUtf8();
                    }
                    if (oidb_0xcf4_newdnainfo.bytes_jump_url.has()) {
                        iVar.f397931c = oidb_0xcf4_newdnainfo.bytes_jump_url.get().toStringUtf8();
                    }
                    if (oidb_0xcf4_newdnainfo.bytes_cover_url.has()) {
                        iVar.f397933e = oidb_0xcf4_newdnainfo.bytes_cover_url.get().toStringUtf8();
                    }
                    if (oidb_0xcf4_newdnainfo.bytes_jump_minapp_url.has()) {
                        iVar.f397934f = oidb_0xcf4_newdnainfo.bytes_jump_minapp_url.get().toStringUtf8();
                    }
                    if (oidb_0xcf4_newdnainfo.rpt_detail.has()) {
                        Iterator<oidb_0xcf4$DnaDetail> it = oidb_0xcf4_newdnainfo.rpt_detail.get().iterator();
                        while (it.hasNext()) {
                            a a16 = a.a(it.next());
                            if (a16 != null) {
                                if (iVar.f397932d == null) {
                                    iVar.f397932d = new ArrayList<>();
                                }
                                iVar.f397932d.add(a16);
                            }
                        }
                    }
                    arrayList.add(iVar);
                }
            }
            return arrayList;
        }
        return null;
    }

    public String toString() {
        return "NewDnaInfo{type=" + this.f397929a + ", title=" + this.f397930b + ", jumpUrl=" + this.f397931c + ", coverUrl=" + this.f397933e + ", jumpMinappUrl=" + this.f397934f + ", details=" + this.f397932d + '}';
    }
}
