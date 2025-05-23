package com.tencent.mobileqq.wink.editor.effect.model;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005j\u0002\b\bj\u0002\b\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/effect/model/WinkEffectCatType;", "", "", "value", "<init>", "(Ljava/lang/String;II)V", "Companion", "a", "TypeScreen", "TypeFace", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public enum WinkEffectCatType {
    TypeScreen(0),
    TypeFace(1);


    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/effect/model/WinkEffectCatType$a;", "", "", "value", "Lcom/tencent/mobileqq/wink/editor/effect/model/WinkEffectCatType;", "a", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.editor.effect.model.WinkEffectCatType$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final WinkEffectCatType a(int value) {
            boolean z16;
            for (WinkEffectCatType winkEffectCatType : WinkEffectCatType.values()) {
                if (winkEffectCatType.ordinal() == value) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    return winkEffectCatType;
                }
            }
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }

        Companion() {
        }
    }

    WinkEffectCatType(int i3) {
    }
}
