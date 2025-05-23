package com.tencent.mobileqq.qqecommerce.biz.kuikly.preload;

import com.tencent.hippy.qq.api.TabPreloadItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\f\u0010\u000b\u001a\u0004\b\u0011\u0010\rR\"\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/preload/c;", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/preload/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "c", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "url", "d", "domain", "a", "body", "", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/preload/b;", "f", "Ljava/util/List;", "b", "()Ljava/util/List;", TabPreloadItem.TAB_NAME_DYNAMIC, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.qqecommerce.biz.kuikly.preload.c, reason: from toString */
/* loaded from: classes35.dex */
public final /* data */ class HttpRequestItem extends a {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final String url;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final String domain;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final String body;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final List<b> dynamic;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpRequestItem(String url, String domain, String str, List<b> list) {
        super(str, list);
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(domain, "domain");
        this.url = url;
        this.domain = domain;
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
    public final String getDomain() {
        return this.domain;
    }

    /* renamed from: e, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return (((((this.url.hashCode() * 31) + this.domain.hashCode()) * 31) + (getBody() == null ? 0 : getBody().hashCode())) * 31) + (b() != null ? b().hashCode() : 0);
    }

    public String toString() {
        return "HttpRequestItem(url=" + this.url + ", domain=" + this.domain + ", body=" + getBody() + ", dynamic=" + b() + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HttpRequestItem)) {
            return false;
        }
        HttpRequestItem httpRequestItem = (HttpRequestItem) other;
        return Intrinsics.areEqual(this.url, httpRequestItem.url) && Intrinsics.areEqual(this.domain, httpRequestItem.domain) && Intrinsics.areEqual(getBody(), httpRequestItem.getBody()) && Intrinsics.areEqual(b(), httpRequestItem.b());
    }
}
