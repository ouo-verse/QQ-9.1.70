package com.tencent.kuikly.core.views;

import com.heytap.databaseengine.apiv3.data.Element;
import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002R\"\u0010\u000f\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0017\u001a\u00020\u00108\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/kuikly/core/views/x;", "Lcom/tencent/kuikly/core/base/m;", "", Element.ELEMENT_NAME_DISTANCE, "", "k", "minContentWidth", "minContentHeight", "j", "a", UserInfo.SEX_FEMALE, "i", "()F", "setPreloadDistance$core_release", "(F)V", "preloadDistance", "Lcom/tencent/kuikly/core/base/w;", "b", "Lcom/tencent/kuikly/core/base/w;", tl.h.F, "()Lcom/tencent/kuikly/core/base/w;", "setMinContentSize$core_release", "(Lcom/tencent/kuikly/core/base/w;)V", "minContentSize", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class x extends com.tencent.kuikly.core.base.m {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private float preloadDistance = 100.0f;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private com.tencent.kuikly.core.base.w minContentSize = new com.tencent.kuikly.core.base.w(0.0f, 0.0f);

    /* renamed from: h, reason: from getter */
    public final com.tencent.kuikly.core.base.w getMinContentSize() {
        return this.minContentSize;
    }

    /* renamed from: i, reason: from getter */
    public final float getPreloadDistance() {
        return this.preloadDistance;
    }

    public final void j(float minContentWidth, float minContentHeight) {
        this.minContentSize = new com.tencent.kuikly.core.base.w(minContentWidth, minContentHeight);
    }

    public final void k(float distance) {
        this.preloadDistance = distance;
    }
}
