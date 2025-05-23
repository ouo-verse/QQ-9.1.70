package com.tencent.kuikly.core.render.android.expand.component.text;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/component/text/l;", "", "", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "text", "Lorg/json/JSONObject;", "spanValue", "<init>", "(Lorg/json/JSONObject;)V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public abstract class l {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String text;

    public l(@NotNull JSONObject spanValue) {
        Intrinsics.checkNotNullParameter(spanValue, "spanValue");
        String optString = spanValue.optString("text", "");
        Intrinsics.checkNotNullExpressionValue(optString, "spanValue.optString(KRTextProps.PROP_KEY_TEXT, \"\")");
        this.text = optString;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getText() {
        return this.text;
    }
}
