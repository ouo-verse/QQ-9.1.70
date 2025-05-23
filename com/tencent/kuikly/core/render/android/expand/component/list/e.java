package com.tencent.kuikly.core.render.android.expand.component.list;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mtt.hippy.views.waterfalllist.WaterFallComponentName;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B3\u0012\b\u0010#\u001a\u0004\u0018\u00010\"\u0012\b\b\u0002\u0010%\u001a\u00020$\u0012\u0016\b\u0002\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aj\u0004\u0018\u0001`\u001c\u00a2\u0006\u0004\b&\u0010'R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\bR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000f\u0010\bR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\"\u0010\u0019\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0015\u001a\u0004\b\u0003\u0010\u0016\"\u0004\b\u0017\u0010\u0018R0\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aj\u0004\u0018\u0001`\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u001d\u001a\u0004\b\u000e\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u0006("}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/component/list/e;", "", "", "a", UserInfo.SEX_FEMALE, "f", "()F", "j", "(F)V", "top", "b", "d", "i", "left", "c", "setBottom", "bottom", "e", "setRight", "right", "", "Z", "()Z", "g", "(Z)V", "animate", "Lkotlin/Function0;", "", "Lcom/tencent/kuikly/core/render/android/expand/component/list/KRContentInsertFinishCallback;", "Lkotlin/jvm/functions/Function0;", "()Lkotlin/jvm/functions/Function0;", tl.h.F, "(Lkotlin/jvm/functions/Function0;)V", "finishCallback", "Lcom/tencent/kuikly/core/render/android/a;", "kuiklyRenderViewContext", "", WaterFallComponentName.PROPERTY_CONTENT_INSET, "<init>", "(Lcom/tencent/kuikly/core/render/android/a;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private float top;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private float left;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private float bottom;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private float right;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean animate;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function0<Unit> finishCallback;

    public e(@Nullable com.tencent.kuikly.core.render.android.a aVar, @NotNull String contentInset, @Nullable Function0<Unit> function0) {
        List split$default;
        Intrinsics.checkNotNullParameter(contentInset, "contentInset");
        this.finishCallback = function0;
        if (contentInset.length() > 0) {
            split$default = StringsKt__StringsKt.split$default((CharSequence) contentInset, new String[]{" "}, false, 0, 6, (Object) null);
            this.top = com.tencent.kuikly.core.render.android.css.ktx.b.I(aVar, Float.parseFloat((String) split$default.get(0)));
            this.left = com.tencent.kuikly.core.render.android.css.ktx.b.I(aVar, Float.parseFloat((String) split$default.get(1)));
            this.bottom = com.tencent.kuikly.core.render.android.css.ktx.b.I(aVar, Float.parseFloat((String) split$default.get(2)));
            this.right = com.tencent.kuikly.core.render.android.css.ktx.b.I(aVar, Float.parseFloat((String) split$default.get(3)));
            if (split$default.size() > 4) {
                this.animate = Integer.parseInt((String) split$default.get(4)) == 1;
            }
        }
    }

    /* renamed from: a, reason: from getter */
    public final boolean getAnimate() {
        return this.animate;
    }

    /* renamed from: b, reason: from getter */
    public final float getBottom() {
        return this.bottom;
    }

    @Nullable
    public final Function0<Unit> c() {
        return this.finishCallback;
    }

    /* renamed from: d, reason: from getter */
    public final float getLeft() {
        return this.left;
    }

    /* renamed from: e, reason: from getter */
    public final float getRight() {
        return this.right;
    }

    /* renamed from: f, reason: from getter */
    public final float getTop() {
        return this.top;
    }

    public final void g(boolean z16) {
        this.animate = z16;
    }

    public final void h(@Nullable Function0<Unit> function0) {
        this.finishCallback = function0;
    }

    public final void i(float f16) {
        this.left = f16;
    }

    public final void j(float f16) {
        this.top = f16;
    }

    public /* synthetic */ e(com.tencent.kuikly.core.render.android.a aVar, String str, Function0 function0, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(aVar, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? null : function0);
    }
}
