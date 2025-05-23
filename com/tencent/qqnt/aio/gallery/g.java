package com.tencent.qqnt.aio.gallery;

import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.richframework.data.base.BaseDataStore;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0014\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00020\u0003H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016R0\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00020\bj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0002`\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/aio/gallery/g;", "Lcom/tencent/richframework/data/base/BaseDataStore;", "Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;", "", "", "getAllData", "data", "a", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "richMediaStore", "<init>", "()V", "b", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class g extends BaseDataStore<AIORichMediaData> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final HashMap<String, AIORichMediaData> richMediaStore = new HashMap<>();

    @Override // com.tencent.richframework.data.idata.IDataStore
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String getKeyFromData(AIORichMediaData data) {
        return h.f350002a.b(data);
    }

    @Override // com.tencent.richframework.data.idata.IDataStore
    public Map<String, AIORichMediaData> getAllData() {
        return this.richMediaStore;
    }
}
