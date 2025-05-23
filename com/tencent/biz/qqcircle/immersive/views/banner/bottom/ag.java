package com.tencent.biz.qqcircle.immersive.views.banner.bottom;

import android.text.TextUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0014\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/views/banner/bottom/ag;", "Lcom/tencent/biz/qqcircle/immersive/views/banner/bottom/ai;", "", "isElementCanActivate", "", "onElementActivated", "", "getPriority", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/biz/qqcircle/immersive/views/banner/bottom/a;", "host", "<init>", "(Lcom/tencent/biz/qqcircle/immersive/views/banner/bottom/a;)V", "I", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class ag extends ai {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ag(@NotNull a host) {
        super(host);
        Intrinsics.checkNotNullParameter(host, "host");
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public int getPriority() {
        return 102;
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public boolean isElementCanActivate() {
        Map<String, String> o16 = com.tencent.biz.qqcircle.immersive.views.search.util.p.o(this.f90602e);
        String str = o16.get("query");
        if (str == null) {
            str = "";
        }
        A(str);
        if (Intrinsics.areEqual("2", o16.get("search")) && !TextUtils.isEmpty(getKeyword())) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.ai, com.tencent.biz.qqcircle.immersive.views.banner.bottom.c
    @NotNull
    public String m() {
        return "QFSSearchFeedOperatingSearchInputBarView";
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.bottom.ai, com.tencent.biz.richframework.order.IOrderElement
    public void onElementActivated() {
        super.onElementActivated();
        ai.D(this, getKeyword(), null, true, 2, null);
    }
}
