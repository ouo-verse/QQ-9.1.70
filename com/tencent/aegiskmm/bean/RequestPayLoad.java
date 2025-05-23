package com.tencent.aegiskmm.bean;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\f\u001a\u0004\b\r\u0010\u000eR'\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/aegiskmm/bean/i;", "Lcom/tencent/aegiskmm/bean/e;", "Lcom/tencent/kuikly/core/nvi/serialization/json/e;", "b", "", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getTopic", "()Ljava/lang/String;", "topic", "Ljava/util/ArrayList;", "Lcom/tencent/aegiskmm/bean/d;", "Lkotlin/collections/ArrayList;", "c", "Ljava/util/ArrayList;", "getData", "()Ljava/util/ArrayList;", "data", "<init>", "(Ljava/lang/String;Ljava/util/ArrayList;)V", "ShiplyCS-KuiklyAegis_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.aegiskmm.bean.i, reason: from toString */
/* loaded from: classes37.dex */
public final /* data */ class RequestPayLoad extends e {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String topic;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final ArrayList<DataItem> data;

    public RequestPayLoad(String topic, ArrayList<DataItem> data) {
        Intrinsics.checkNotNullParameter(topic, "topic");
        Intrinsics.checkNotNullParameter(data, "data");
        this.topic = topic;
        this.data = data;
    }

    public com.tencent.kuikly.core.nvi.serialization.json.e b() {
        com.tencent.kuikly.core.nvi.serialization.json.b bVar = new com.tencent.kuikly.core.nvi.serialization.json.b();
        Iterator<T> it = this.data.iterator();
        while (it.hasNext()) {
            bVar.t(((DataItem) it.next()).b());
        }
        getCom.tencent.ark.ark.ARKMETADATA_JSON java.lang.String().v("topic", this.topic);
        getCom.tencent.ark.ark.ARKMETADATA_JSON java.lang.String().v("data", bVar);
        return getCom.tencent.ark.ark.ARKMETADATA_JSON java.lang.String();
    }

    public int hashCode() {
        String str = this.topic;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        ArrayList<DataItem> arrayList = this.data;
        return hashCode + (arrayList != null ? arrayList.hashCode() : 0);
    }

    public String toString() {
        return "RequestPayLoad(topic=" + this.topic + ", data=" + this.data + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RequestPayLoad)) {
            return false;
        }
        RequestPayLoad requestPayLoad = (RequestPayLoad) other;
        return Intrinsics.areEqual(this.topic, requestPayLoad.topic) && Intrinsics.areEqual(this.data, requestPayLoad.data);
    }
}
