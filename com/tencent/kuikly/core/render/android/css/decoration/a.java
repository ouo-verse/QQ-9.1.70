package com.tencent.kuikly.core.render.android.css.decoration;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.kuikly.core.render.android.css.ktx.b;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u001f2\u00020\u0001:\u0001\u0005B\u0019\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0018\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0006\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\"\u0010\u0011\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0006\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\"\u0010\u0017\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0013\u001a\u0004\b\u0005\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0019\u00a8\u0006 "}, d2 = {"Lcom/tencent/kuikly/core/render/android/css/decoration/a;", "", "", "e", "", "a", UserInfo.SEX_FEMALE, "b", "()F", "setShadowOffsetX", "(F)V", NodeProps.SHADOW_OFFSET_X, "c", "setShadowOffsetY", NodeProps.SHADOW_OFFSET_Y, "d", "setShadowRadius", NodeProps.SHADOW_RADIUS, "", "I", "()I", "setShadowColor", "(I)V", NodeProps.SHADOW_COLOR, "Lcom/tencent/kuikly/core/render/android/a;", "Lcom/tencent/kuikly/core/render/android/a;", "context", "", "shadowValue", "<init>", "(Ljava/lang/String;Lcom/tencent/kuikly/core/render/android/a;)V", "f", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private float shadowOffsetX;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private float shadowOffsetY;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private float shadowRadius;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int shadowColor;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.kuikly.core.render.android.a context;

    public a(@NotNull String shadowValue, @Nullable com.tencent.kuikly.core.render.android.a aVar) {
        List split$default;
        Intrinsics.checkNotNullParameter(shadowValue, "shadowValue");
        this.context = aVar;
        split$default = StringsKt__StringsKt.split$default((CharSequence) shadowValue, new String[]{" "}, false, 0, 6, (Object) null);
        if (split$default.size() == 4) {
            this.shadowOffsetX = b.I(aVar, Float.parseFloat((String) split$default.get(0)));
            this.shadowOffsetY = b.I(aVar, Float.parseFloat((String) split$default.get(1)));
            this.shadowRadius = b.I(aVar, Float.parseFloat((String) split$default.get(2)));
            this.shadowColor = b.w((String) split$default.get(3));
        }
    }

    /* renamed from: a, reason: from getter */
    public final int getShadowColor() {
        return this.shadowColor;
    }

    /* renamed from: b, reason: from getter */
    public final float getShadowOffsetX() {
        return this.shadowOffsetX;
    }

    /* renamed from: c, reason: from getter */
    public final float getShadowOffsetY() {
        return this.shadowOffsetY;
    }

    /* renamed from: d, reason: from getter */
    public final float getShadowRadius() {
        return this.shadowRadius;
    }

    public final boolean e() {
        if (this.shadowOffsetY == 0.0f && this.shadowOffsetX == 0.0f) {
            return true;
        }
        return false;
    }
}
