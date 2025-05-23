package com.tencent.kuikly.core.render.android.expand.component.text;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B\u0019\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\f\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006R\u0016\u0010\f\u001a\u0004\u0018\u00010\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/component/text/k;", "Lcom/tencent/kuikly/core/render/android/expand/component/text/l;", "", "b", "I", "c", "()I", "width", "height", "Lcom/tencent/kuikly/core/render/android/a;", "d", "Lcom/tencent/kuikly/core/render/android/a;", "kuiklyContext", "Lorg/json/JSONObject;", "spanValue", "<init>", "(Lorg/json/JSONObject;Lcom/tencent/kuikly/core/render/android/a;)V", "e", "a", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class k extends l {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int width;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int height;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.kuikly.core.render.android.a kuiklyContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(@NotNull JSONObject spanValue, @Nullable com.tencent.kuikly.core.render.android.a aVar) {
        super(spanValue);
        Intrinsics.checkNotNullParameter(spanValue, "spanValue");
        this.kuiklyContext = aVar;
        this.width = com.tencent.kuikly.core.render.android.css.ktx.b.K(aVar, (float) spanValue.optDouble("placeholderWidth", 0.0d));
        this.height = com.tencent.kuikly.core.render.android.css.ktx.b.K(aVar, (float) spanValue.optDouble("placeholderHeight", 0.0d));
    }

    /* renamed from: b, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    /* renamed from: c, reason: from getter */
    public final int getWidth() {
        return this.width;
    }
}
