package com.tencent.now.linkpkanchorplay.mainpage.model;

import com.tencent.now.linkpkanchorplay.mainpage.model.LinkPKTabData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 \n2\u00020\u0001:\u0002\u0004\nB\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0005R\u0014\u0010\u000f\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/mainpage/model/b;", "", "", "Lcom/tencent/now/linkpkanchorplay/mainpage/model/LinkPKTabData;", "a", "", "c", "Lcom/tencent/now/linkpkanchorplay/mainpage/model/b$b;", "dataCallBack", "", "b", "selectedId", "d", "Lcom/tencent/hy/common/utils/a;", "Lcom/tencent/hy/common/utils/a;", "tabDataSPUtil", "<init>", "()V", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.hy.common.utils.a tabDataSPUtil = new com.tencent.hy.common.utils.a("LinkAndPKTabData");

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/mainpage/model/b$b;", "", "", "Lcom/tencent/now/linkpkanchorplay/mainpage/model/LinkPKTabData;", "tabList", "", "a", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.now.linkpkanchorplay.mainpage.model.b$b, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public interface InterfaceC9245b {
        void a(@Nullable List<LinkPKTabData> tabList);
    }

    private final List<LinkPKTabData> a() {
        boolean z16;
        int c16 = c();
        ArrayList arrayList = new ArrayList();
        LinkPKTabData.TabId tabId = LinkPKTabData.TabId.PK_TAB;
        boolean z17 = true;
        if (c16 == tabId.getId()) {
            z16 = true;
        } else {
            z16 = false;
        }
        arrayList.add(new LinkPKTabData(tabId, "PK", z16));
        LinkPKTabData.TabId tabId2 = LinkPKTabData.TabId.LINK_TAB;
        if (c16 != tabId2.getId()) {
            z17 = false;
        }
        arrayList.add(new LinkPKTabData(tabId2, "\u8fde\u9ea6", z17));
        return arrayList;
    }

    private final int c() {
        return this.tabDataSPUtil.a("selected_tab_id", LinkPKTabData.TabId.PK_TAB.getId());
    }

    public final void b(@NotNull InterfaceC9245b dataCallBack) {
        Intrinsics.checkNotNullParameter(dataCallBack, "dataCallBack");
        dataCallBack.a(a());
    }

    public final void d(int selectedId) {
        this.tabDataSPUtil.c("selected_tab_id", selectedId);
    }
}
