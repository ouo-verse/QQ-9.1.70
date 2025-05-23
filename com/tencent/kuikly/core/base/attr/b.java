package com.tencent.kuikly.core.base.attr;

import com.tencent.ditto.shell.LayoutAttrDefine;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H&J\u001a\u0010\t\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/kuikly/core/base/attr/b;", "", "", "src", "", "isDotNineImage", "e", "Lcom/tencent/kuikly/core/base/attr/e;", LayoutAttrDefine.CLICK_URI, "b", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public interface b {
    b b(e uri, boolean isDotNineImage);

    b e(String src, boolean isDotNineImage);

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class a {
        public static /* synthetic */ b a(b bVar, e eVar, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    z16 = false;
                }
                return bVar.b(eVar, z16);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: src");
        }

        public static /* synthetic */ b b(b bVar, String str, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    z16 = false;
                }
                return bVar.e(str, z16);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: src");
        }
    }
}
