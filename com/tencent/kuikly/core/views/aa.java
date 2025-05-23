package com.tencent.kuikly.core.views;

import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006R\"\u0010\u0011\u001a\u00020\u00068\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0018\u001a\u0004\u0018\u00010\u00068\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/kuikly/core/views/aa;", "Lcom/tencent/kuikly/core/base/m;", "", "index", "", tl.h.F, "", "offset", "j", "maxMargin", "k", "a", UserInfo.SEX_FEMALE, "i", "()F", "setHoverMarginTop$core_release", "(F)V", "hoverMarginTop", "b", "Ljava/lang/Float;", "getHoverMaxMarginTop$core_release", "()Ljava/lang/Float;", "setHoverMaxMarginTop$core_release", "(Ljava/lang/Float;)V", "hoverMaxMarginTop", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class aa extends com.tencent.kuikly.core.base.m {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private float hoverMarginTop;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private Float hoverMaxMarginTop;

    public final void h(int index) {
        with("bringIndex", Integer.valueOf(index));
    }

    /* renamed from: i, reason: from getter */
    public final float getHoverMarginTop() {
        return this.hoverMarginTop;
    }

    public final void j(float offset) {
        this.hoverMarginTop = offset;
        with("hoverMarginTop", Float.valueOf(offset));
    }

    public final void k(float maxMargin) {
        this.hoverMaxMarginTop = Float.valueOf(maxMargin);
        with("hoverMaxMarginTop", Float.valueOf(maxMargin));
    }
}
