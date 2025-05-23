package com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.detail.model.BoxType$EnumUnboxingSharedUtility;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes31.dex */
public final class PopoverTriangleOffset {
    public final int alignment;
    public final float offset;

    public PopoverTriangleOffset() {
        this(0, 0.0f, 3, null);
    }

    public final float getOffset(float f16, int i3) {
        float f17;
        int ordinal = BoxType$EnumUnboxingSharedUtility.ordinal(this.alignment);
        if (ordinal == 0) {
            f17 = this.offset + f16;
        } else {
            if (ordinal == 1) {
                return this.offset * i3;
            }
            if (ordinal == 2) {
                f17 = this.offset - f16;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        return f17 * i3;
    }

    public final float getPercentageOffset() {
        int ordinal = BoxType$EnumUnboxingSharedUtility.ordinal(this.alignment);
        if (ordinal == 0) {
            return 0.0f;
        }
        if (ordinal == 1) {
            return -0.5f;
        }
        if (ordinal == 2) {
            return -1.0f;
        }
        throw new NoWhenBranchMatchedException();
    }

    public PopoverTriangleOffset(int i3, float f16) {
        this.alignment = i3;
        this.offset = f16;
    }

    public /* synthetic */ PopoverTriangleOffset(int i3, float f16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(2, 0.0f);
    }
}
