package defpackage;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.transfile.filebrowser.MimeTypeParser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes34.dex */
public final class p implements ISSOReqModel, ISSORspModel<p> {

    /* renamed from: a, reason: collision with root package name */
    public final String f424815a;

    /* renamed from: b, reason: collision with root package name */
    public final String f424816b;

    /* renamed from: c, reason: collision with root package name */
    public final String f424817c;

    /* renamed from: d, reason: collision with root package name */
    public final String f424818d;

    /* renamed from: e, reason: collision with root package name */
    public final int f424819e;

    /* renamed from: f, reason: collision with root package name */
    public final String f424820f;

    /* renamed from: g, reason: collision with root package name */
    public final String f424821g;

    /* renamed from: h, reason: collision with root package name */
    public final List<n> f424822h;

    /* renamed from: i, reason: collision with root package name */
    public final long f424823i;

    public p(String str, String str2, String str3, String str4, int i3, String str5, String str6, List<n> list, long j3) {
        this.f424815a = str;
        this.f424816b = str2;
        this.f424817c = str3;
        this.f424818d = str4;
        this.f424819e = i3;
        this.f424820f = str5;
        this.f424821g = str6;
        this.f424822h = list;
        this.f424823i = j3;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.v("result_id", this.f424815a);
        eVar.v("name", this.f424816b);
        eVar.v("pic_url", this.f424817c);
        eVar.v("jmp_url", this.f424818d);
        eVar.t("hide_add_button", this.f424819e);
        eVar.v("word", this.f424820f);
        b a16 = o.a(eVar, MimeTypeParser.ATTR_EXTENSION, this.f424821g);
        List<n> list = this.f424822h;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                a16.t(((n) it.next()).encode());
            }
        }
        eVar.v("rpt_meaning", a16);
        eVar.u("group_mask", this.f424823i);
        return eVar;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final p decode(e eVar) {
        ArrayList arrayList;
        List list;
        List list2;
        b bVar;
        String q16 = eVar.q("result_id", "");
        String q17 = eVar.q("name", "");
        String q18 = eVar.q("pic_url", "");
        String q19 = eVar.q("jmp_url", "");
        int k3 = eVar.k("hide_add_button", 0);
        String q26 = eVar.q("word", "");
        String q27 = eVar.q(MimeTypeParser.ATTR_EXTENSION, "");
        b l3 = eVar.l("rpt_meaning");
        if (l3 != null) {
            arrayList = new ArrayList();
            int c16 = l3.c();
            int i3 = 0;
            while (i3 < c16) {
                Object d16 = l3.d(i3);
                if (d16 != null) {
                    Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                    e eVar2 = (e) d16;
                    bVar = l3;
                    arrayList.add(new n(eVar2.q("words", ""), eVar2.k("eflag", 0)));
                } else {
                    bVar = l3;
                }
                i3++;
                l3 = bVar;
            }
        } else {
            arrayList = null;
        }
        long o16 = eVar.o("group_mask", 0L);
        if (arrayList != null) {
            list2 = CollectionsKt___CollectionsKt.toList(arrayList);
            list = list2;
        } else {
            list = null;
        }
        return new p(q16, q17, q18, q19, k3, q26, q27, list, o16);
    }

    public /* synthetic */ p() {
        this("", "", "", "", 0, "", "", null, 0L);
    }
}
