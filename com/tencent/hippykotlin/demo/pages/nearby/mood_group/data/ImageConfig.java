package com.tencent.hippykotlin.demo.pages.nearby.mood_group.data;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.PopoverTriangle$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ImageConfig {
    public final float height;
    public final String src;
    public final int type;
    public final float width;

    public ImageConfig() {
        this(null, 0.0f, 0.0f, 7, null);
    }

    public final float getHeight() {
        return this.height;
    }

    public final String getSrc() {
        return this.src;
    }

    public final float getWidth() {
        return this.width;
    }

    public final int hashCode() {
        return Float.floatToIntBits(this.height) + PopoverTriangle$$ExternalSyntheticOutline0.m(this.width, this.src.hashCode() * 31, 31);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ImageConfig(src=");
        m3.append(this.src);
        m3.append(", width=");
        m3.append(this.width);
        m3.append(", height=");
        m3.append(this.height);
        m3.append(')');
        return m3.toString();
    }

    public ImageConfig(String str, float f16, float f17) {
        String substringAfterLast$default;
        this.src = str;
        this.width = f16;
        this.height = f17;
        ImageType$Companion imageType$Companion = ImageType$EnumUnboxingLocalUtility.Companion;
        substringAfterLast$default = StringsKt__StringsKt.substringAfterLast$default(str, ".", (String) null, 2, (Object) null);
        this.type = imageType$Companion.parseFromString$enumunboxing$(substringAfterLast$default);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ImageConfig)) {
            return false;
        }
        ImageConfig imageConfig = (ImageConfig) obj;
        return Intrinsics.areEqual(this.src, imageConfig.src) && Float.compare(this.width, imageConfig.width) == 0 && Float.compare(this.height, imageConfig.height) == 0;
    }

    public /* synthetic */ ImageConfig(String str, float f16, float f17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this("", 0.0f, 0.0f);
    }
}
