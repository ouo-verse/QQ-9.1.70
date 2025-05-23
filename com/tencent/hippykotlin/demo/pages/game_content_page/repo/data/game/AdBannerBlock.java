package com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game;

import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class AdBannerBlock implements ISSOReqModel, ISSORspModel<AdBannerBlock> {
    public final List<TopBannerItem> bannerList;

    public AdBannerBlock() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOReqModel
    public final e encode() {
        e eVar = new e();
        b bVar = new b();
        List<TopBannerItem> list = this.bannerList;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                bVar.t(((TopBannerItem) it.next()).encode());
            }
        }
        eVar.v("banner_list", bVar);
        return eVar;
    }

    public AdBannerBlock(List<TopBannerItem> list) {
        this.bannerList = list;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.hippykotlin.demo.pages.base.ISSORspModel
    public final AdBannerBlock decode(e eVar) {
        ArrayList arrayList;
        b l3 = eVar.l("banner_list");
        if (l3 != null) {
            arrayList = new ArrayList();
            int c16 = l3.c();
            for (int i3 = 0; i3 < c16; i3++) {
                Object d16 = l3.d(i3);
                if (d16 != null) {
                    Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                    e eVar2 = (e) d16;
                    arrayList.add(new TopBannerItem(eVar2.q("banner_id", ""), eVar2.q("super_img", ""), eVar2.k("is_super_img_dynamic", 0), eVar2.q("small_img", ""), eVar2.k("is_small_img_dynamic", 0), eVar2.q("video_url", ""), eVar2.q("jump_url", "")));
                }
            }
        } else {
            arrayList = null;
        }
        return new AdBannerBlock(arrayList != null ? CollectionsKt___CollectionsKt.toList(arrayList) : null);
    }

    public /* synthetic */ AdBannerBlock(List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null);
    }
}
