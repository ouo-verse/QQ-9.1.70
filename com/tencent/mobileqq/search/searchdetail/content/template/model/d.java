package com.tencent.mobileqq.search.searchdetail.content.template.model;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.qqnt.kernel.nativeinterface.SearchGroupFile;
import kotlin.Deprecated;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Deprecated(message = "\u5df2\u7ecf\u4e0b\u7ebf \u4e0d\u5b8c\u6574")
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/template/model/d;", "Lcom/tencent/mobileqq/search/searchdetail/content/template/model/a;", "", "getItemType", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchGroupFile;", "G", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchGroupFile;", HippyTKDListViewAdapter.X, "()Lcom/tencent/qqnt/kernel/nativeinterface/SearchGroupFile;", "groupFile", "H", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class d extends a {

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final SearchGroupFile groupFile;

    @Override // com.tencent.mobileqq.search.searchdetail.a, com.tencent.mobileqq.search.searchdetail.c
    public int getItemType() {
        return 8;
    }

    @NotNull
    /* renamed from: x, reason: from getter */
    public final SearchGroupFile getGroupFile() {
        return this.groupFile;
    }
}
