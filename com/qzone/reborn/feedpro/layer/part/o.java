package com.qzone.reborn.feedpro.layer.part;

import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fR(\u0010\b\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00030\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R(\u0010\n\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00030\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\u0007\u00a8\u0006\r"}, d2 = {"Lcom/qzone/reborn/feedpro/layer/part/o;", "Lcom/qzone/reborn/layer/part/y;", "", "Ljava/lang/Class;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "getExtPicSections", "()Ljava/util/List;", "extPicSections", "getExtVideoSections", "extVideoSections", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class o extends com.qzone.reborn.layer.part.y {
    @Override // com.qzone.reborn.layer.part.y, com.tencent.richframework.gallery.delegate.outer.IDelegateAndSectionProvider
    public List<Class<? extends Section<RFWLayerItemMediaInfo>>> getExtPicSections() {
        ArrayList arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(sk.a.class, je.c.class);
        return arrayListOf;
    }

    @Override // com.qzone.reborn.layer.part.y, com.tencent.richframework.gallery.delegate.outer.IDelegateAndSectionProvider
    public List<Class<? extends Section<RFWLayerItemMediaInfo>>> getExtVideoSections() {
        ArrayList arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(je.c.class);
        return arrayListOf;
    }
}
