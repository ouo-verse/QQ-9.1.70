package com.tencent.richframework.gallery.delegate.outer;

import com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegate;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R$\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00030\u00040\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R&\u0010\b\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00050\n0\t0\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007R&\u0010\f\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00050\n0\t0\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u0007\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/richframework/gallery/delegate/outer/IDelegateAndSectionProvider;", "", "extDelegates", "", "Lcom/tencent/biz/richframework/part/adapter/delegate/AdapterDelegate;", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "getExtDelegates", "()Ljava/util/List;", "extPicSections", "Ljava/lang/Class;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "getExtPicSections", "extVideoSections", "getExtVideoSections", "function-gallery_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public interface IDelegateAndSectionProvider {
    @NotNull
    List<AdapterDelegate<List<RFWLayerItemMediaInfo>>> getExtDelegates();

    @NotNull
    List<Class<? extends Section<RFWLayerItemMediaInfo>>> getExtPicSections();

    @NotNull
    List<Class<? extends Section<RFWLayerItemMediaInfo>>> getExtVideoSections();
}
