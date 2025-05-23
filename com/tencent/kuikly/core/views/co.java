package com.tencent.kuikly.core.views;

import com.heytap.databaseengine.model.UserInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0012\u0018\u0000 &2\u00020\u0001:\u0001\u0003B_\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u0012\u0006\u0010 \u001a\u00020\u0002\u0012\u0006\u0010#\u001a\u00020\u0002\u00a2\u0006\u0004\b$\u0010%R\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0017\u0010\b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\u0007\u0010\u0005R\u0017\u0010\u000b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0005R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0005R\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0005R\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0005R\u0017\u0010\u0018\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\t\u0010\u0005R\u0017\u0010\u001d\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\f\u0010\u0005R\u0017\u0010 \u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0005R\u0017\u0010#\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0005\u00a8\u0006'"}, d2 = {"Lcom/tencent/kuikly/core/views/co;", "", "", "a", UserInfo.SEX_FEMALE, "()F", "offsetX", "b", "offsetY", "c", "getContentWidth", "contentWidth", "d", "getContentHeight", "contentHeight", "e", "getViewWidth", "viewWidth", "f", "getViewHeight", "viewHeight", "", "g", "Z", "isDragging", "()Z", tl.h.F, "velocityX", "i", "velocityY", "j", "getTargetContentOffsetX", "targetContentOffsetX", "k", "getTargetContentOffsetY", "targetContentOffsetY", "<init>", "(FFFFFFZFFFF)V", "l", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class co {

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final float offsetX;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final float offsetY;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final float contentWidth;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final float contentHeight;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final float viewWidth;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final float viewHeight;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final boolean isDragging;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final float velocityX;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final float velocityY;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final float targetContentOffsetX;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final float targetContentOffsetY;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\"\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/kuikly/core/views/co$a;", "", "Lcom/tencent/kuikly/core/nvi/serialization/json/e;", "params", "Lcom/tencent/kuikly/core/views/ScrollerView;", "scrollView", "Lcom/tencent/kuikly/core/views/co;", "a", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.kuikly.core.views.co$a, reason: from kotlin metadata */
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }

        public final co a(com.tencent.kuikly.core.nvi.serialization.json.e params, ScrollerView<?, ?> scrollView) {
            Intrinsics.checkNotNullParameter(params, "params");
            return new co((float) params.h("offsetX"), (float) params.h("offsetY"), (float) params.h("contentWidth"), (float) params.h("contentHeight"), (float) params.h("viewWidth"), (float) params.h("viewHeight"), params.j("isDragging") == 1, (float) params.h("velocityX"), (float) params.h("velocityY"), (float) params.h("targetContentOffsetX"), (float) params.h("targetContentOffsetY"));
        }
    }

    public co(float f16, float f17, float f18, float f19, float f26, float f27, boolean z16, float f28, float f29, float f36, float f37) {
        this.offsetX = f16;
        this.offsetY = f17;
        this.contentWidth = f18;
        this.contentHeight = f19;
        this.viewWidth = f26;
        this.viewHeight = f27;
        this.isDragging = z16;
        this.velocityX = f28;
        this.velocityY = f29;
        this.targetContentOffsetX = f36;
        this.targetContentOffsetY = f37;
    }

    /* renamed from: a, reason: from getter */
    public final float getOffsetX() {
        return this.offsetX;
    }

    /* renamed from: b, reason: from getter */
    public final float getOffsetY() {
        return this.offsetY;
    }

    /* renamed from: c, reason: from getter */
    public final float getVelocityX() {
        return this.velocityX;
    }

    /* renamed from: d, reason: from getter */
    public final float getVelocityY() {
        return this.velocityY;
    }
}
