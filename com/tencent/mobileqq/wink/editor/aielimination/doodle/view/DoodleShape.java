package com.tencent.mobileqq.wink.editor.aielimination.doodle.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\t\b\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/aielimination/doodle/view/DoodleShape;", "", "Lcom/tencent/mobileqq/wink/editor/aielimination/doodle/view/g;", "<init>", "(Ljava/lang/String;I)V", "HAND_WRITE", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public enum DoodleShape implements g {
    HAND_WRITE { // from class: com.tencent.mobileqq.wink.editor.aielimination.doodle.view.DoodleShape.HAND_WRITE
        @Override // com.tencent.mobileqq.wink.editor.aielimination.doodle.view.DoodleShape, com.tencent.mobileqq.wink.editor.aielimination.doodle.view.g
        public void config(@Nullable e doodleItem, @Nullable Paint paint) {
            if (paint != null) {
                paint.setStyle(Paint.Style.STROKE);
            }
        }

        @Override // com.tencent.mobileqq.wink.editor.aielimination.doodle.view.DoodleShape, com.tencent.mobileqq.wink.editor.aielimination.doodle.view.g
        @NotNull
        public g copy() {
            return this;
        }

        @Override // com.tencent.mobileqq.wink.editor.aielimination.doodle.view.DoodleShape, com.tencent.mobileqq.wink.editor.aielimination.doodle.view.g
        public void drawHelpers(@Nullable Canvas canvas, @Nullable c doodle) {
        }
    };

    /* synthetic */ DoodleShape(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mobileqq.wink.editor.aielimination.doodle.view.g
    public abstract /* synthetic */ void config(@Nullable e eVar, @Nullable Paint paint);

    @Override // com.tencent.mobileqq.wink.editor.aielimination.doodle.view.g
    @Nullable
    public abstract /* synthetic */ g copy();

    @Override // com.tencent.mobileqq.wink.editor.aielimination.doodle.view.g
    public abstract /* synthetic */ void drawHelpers(@Nullable Canvas canvas, @Nullable c cVar);
}
