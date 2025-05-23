package com.tencent.mobileqq.wink.publish.util;

import com.tencent.mobileqq.wink.publish.util.WinkDraftUtil;
import com.tencent.mobileqq.winkpublish.model.DraftBean;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
/* synthetic */ class WinkDraftUtil$Companion$sBeansConverter$1 extends FunctionReferenceImpl implements Function1<List<? extends ha3.b>, List<? extends DraftBean>> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public WinkDraftUtil$Companion$sBeansConverter$1(Object obj) {
        super(1, obj, WinkDraftUtil.Companion.class, "publishContents2DraftBeans", "publishContents2DraftBeans(Ljava/util/List;)Ljava/util/List;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    @NotNull
    public final List<DraftBean> invoke(@NotNull List<? extends ha3.b> p06) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        return ((WinkDraftUtil.Companion) this.receiver).q(p06);
    }
}
