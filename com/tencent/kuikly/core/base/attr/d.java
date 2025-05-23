package com.tencent.kuikly.core.base.attr;

import com.tencent.kuikly.core.base.t;
import com.tencent.kuikly.core.base.u;
import com.tencent.kuikly.core.base.x;
import com.tencent.kuikly.core.base.y;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J:\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\nH&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/kuikly/core/base/attr/d;", "", "Lcom/tencent/kuikly/core/base/t;", CanvasView.ACTION_ROTATE, "Lcom/tencent/kuikly/core/base/u;", "scale", "Lcom/tencent/kuikly/core/base/y;", CanvasView.ACTION_TRANSLATE, "Lcom/tencent/kuikly/core/base/a;", "anchor", "Lcom/tencent/kuikly/core/base/x;", "skew", "transform", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public interface d {
    d transform(t rotate, u scale, y translate, com.tencent.kuikly.core.base.a anchor, x skew);

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class a {
        public static /* synthetic */ d a(d dVar, t tVar, u uVar, y yVar, com.tencent.kuikly.core.base.a aVar, x xVar, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    tVar = t.INSTANCE.a();
                }
                if ((i3 & 2) != 0) {
                    uVar = u.INSTANCE.a();
                }
                u uVar2 = uVar;
                if ((i3 & 4) != 0) {
                    yVar = y.INSTANCE.a();
                }
                y yVar2 = yVar;
                if ((i3 & 8) != 0) {
                    aVar = com.tencent.kuikly.core.base.a.INSTANCE.a();
                }
                com.tencent.kuikly.core.base.a aVar2 = aVar;
                if ((i3 & 16) != 0) {
                    xVar = x.INSTANCE.a();
                }
                return dVar.transform(tVar, uVar2, yVar2, aVar2, xVar);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: transform");
        }
    }
}
