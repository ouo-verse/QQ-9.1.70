package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class StFeed implements ISSOReqModel, ISSORspModel<StFeed> {
    public final String content;
    public final StImage cover;

    /* renamed from: id, reason: collision with root package name */
    public final String f114289id;
    public final ArrayList<StImage> images;
    public final StUser poster;
    public final int type;
    public final StVideo video;
    public final StVisitor visitorInfo;

    public StFeed(String str, StUser stUser, StImage stImage, StVideo stVideo, String str2, int i3, StVisitor stVisitor, ArrayList<StImage> arrayList) {
        this.f114289id = str;
        this.poster = stUser;
        this.cover = stImage;
        this.video = stVideo;
        this.content = str2;
        this.type = i3;
        this.visitorInfo = stVisitor;
        this.images = arrayList;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        eVar.v("id", this.f114289id);
        StUser stUser = this.poster;
        if (stUser != null) {
            eVar.v(QAdVrReport.ElementID.AD_POSTER, stUser.encode());
        }
        StImage stImage = this.cover;
        if (stImage != null) {
            eVar.v("cover", stImage.encode());
        }
        StVideo stVideo = this.video;
        if (stVideo != null) {
            eVar.v("video", stVideo.encode());
        }
        eVar.v("content", this.content);
        eVar.t("type", this.type);
        StVisitor stVisitor = this.visitorInfo;
        if (stVisitor != null) {
            eVar.v("visitor_info", stVisitor.encode());
        }
        b bVar = new b();
        ArrayList<StImage> arrayList = this.images;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                bVar.t(((StImage) it.next()).encode());
            }
        }
        eVar.v("images", bVar);
        return eVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final StFeed decode(e eVar) {
        int i3;
        StVisitor stVisitor;
        String str;
        String str2;
        int i16;
        b bVar;
        String str3 = "";
        String q16 = eVar.q("id", "");
        e m3 = eVar.m(QAdVrReport.ElementID.AD_POSTER);
        ArrayList arrayList = null;
        StUser stUser = m3 != null ? new StUser(m3.q("id", ""), m3.q("nick", "")) : null;
        e m16 = eVar.m("cover");
        String str4 = "width";
        StImage stImage = m16 != null ? new StImage(m16.k("width", 0), m16.k("height", 0), m16.q("pic_url", ""), m16.q("layer_pic_url", "")) : null;
        e m17 = eVar.m("video");
        StVideo stVideo = m17 != null ? new StVideo(m17.k("fileSize", 0), m17.k("duration", 0), m17.k("width", 0), m17.k("height", 0), m17.q("play_url", "")) : null;
        String q17 = eVar.q("content", "");
        int k3 = eVar.k("type", 0);
        e m18 = eVar.m("visitor_info");
        StVisitor stVisitor2 = m18 != null ? new StVisitor(m18.k("view_count", 0)) : null;
        b l3 = eVar.l("images");
        if (l3 != null) {
            arrayList = new ArrayList();
            int c16 = l3.c();
            stVisitor = stVisitor2;
            int i17 = 0;
            while (i17 < c16) {
                int i18 = c16;
                Object d16 = l3.d(i17);
                if (d16 != null) {
                    bVar = l3;
                    Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                    e eVar2 = (e) d16;
                    i16 = k3;
                    str2 = str4;
                    str = str3;
                    arrayList.add(new StImage(eVar2.k(str4, 0), eVar2.k("height", 0), eVar2.q("pic_url", str3), eVar2.q("layer_pic_url", str3)));
                } else {
                    str = str3;
                    str2 = str4;
                    i16 = k3;
                    bVar = l3;
                }
                i17++;
                c16 = i18;
                l3 = bVar;
                k3 = i16;
                str4 = str2;
                str3 = str;
            }
            i3 = k3;
        } else {
            i3 = k3;
            stVisitor = stVisitor2;
        }
        ArrayList arrayList2 = arrayList;
        eVar.g("orgFeedDeleted", false);
        b l16 = eVar.l("opMask");
        if (l16 != null) {
            ArrayList arrayList3 = new ArrayList();
            int c17 = l16.c();
            for (int i19 = 0; i19 < c17; i19++) {
                arrayList3.add(Integer.valueOf(l16.i(i19)));
            }
        }
        b l17 = eVar.l("opMask2");
        if (l17 != null) {
            ArrayList arrayList4 = new ArrayList();
            int c18 = l17.c();
            for (int i26 = 0; i26 < c18; i26++) {
                arrayList4.add(Integer.valueOf(l17.i(i26)));
            }
        }
        b l18 = eVar.l("atUinList");
        if (l18 != null) {
            ArrayList arrayList5 = new ArrayList();
            int c19 = l18.c();
            for (int i27 = 0; i27 < c19; i27++) {
                String o16 = l18.o(i27);
                if (o16 != null) {
                    arrayList5.add(o16);
                }
            }
        }
        return new StFeed(q16, stUser, stImage, stVideo, q17, i3, stVisitor, arrayList2);
    }

    public /* synthetic */ StFeed() {
        this("", null, null, null, "", 0, null, null);
    }
}
