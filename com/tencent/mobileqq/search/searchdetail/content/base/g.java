package com.tencent.mobileqq.search.searchdetail.content.base;

import com.tencent.qqnt.kernel.nativeinterface.SearchJump;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J*\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/content/base/g;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/SearchJump;", "moreJumpInfo", "", "", "extensionMap", "", "d", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public interface g {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes18.dex */
    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void a(g gVar, SearchJump searchJump, Map map, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    map = null;
                }
                gVar.d(searchJump, map);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: doJump");
        }
    }

    void d(@Nullable SearchJump moreJumpInfo, @Nullable Map<String, String> extensionMap);
}
