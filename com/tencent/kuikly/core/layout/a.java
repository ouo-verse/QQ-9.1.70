package com.tencent.kuikly.core.layout;

import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.FloatCompanionObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/kuikly/core/layout/a;", "Lcom/tencent/kuikly/core/layout/FlexLayout;", "", "d", UserInfo.SEX_FEMALE, "f", "()F", "g", "(F)V", "parentMaxWidth", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class a extends FlexLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private float parentMaxWidth;

    public a() {
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        this.parentMaxWidth = Float.NaN;
    }

    /* renamed from: f, reason: from getter */
    public final float getParentMaxWidth() {
        return this.parentMaxWidth;
    }

    public final void g(float f16) {
        this.parentMaxWidth = f16;
    }
}
