package com.tencent.mobileqq.qqecommerce.biz.kuikly.preload;

import com.tencent.hippy.qq.api.TabPreloadItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u00a2\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R$\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\b\u0010\u0006\"\u0004\b\t\u0010\nR\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/preload/g;", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/preload/a;", "", "c", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "cmd", "a", "setBody", "(Ljava/lang/String;)V", "body", "", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/preload/b;", "e", "Ljava/util/List;", "b", "()Ljava/util/List;", TabPreloadItem.TAB_NAME_DYNAMIC, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class g extends a {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final String cmd;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String body;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final List<b> dynamic;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(String cmd, String str, List<b> list) {
        super(str, list);
        Intrinsics.checkNotNullParameter(cmd, "cmd");
        this.cmd = cmd;
        this.body = str;
        this.dynamic = list;
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.preload.a
    /* renamed from: a, reason: from getter */
    public String getBody() {
        return this.body;
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.preload.a
    public List<b> b() {
        return this.dynamic;
    }

    /* renamed from: d, reason: from getter */
    public final String getCmd() {
        return this.cmd;
    }
}
