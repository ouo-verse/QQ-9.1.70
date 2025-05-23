package com.tencent.kuikly.core.base;

import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/kuikly/core/base/ExecuteMode;", "", "", "value", "I", HippyTextInputController.COMMAND_getValue, "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "a", "JVM", "FRAMEWORK", "JS", "DEX", "SO", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public enum ExecuteMode {
    JVM(0),
    FRAMEWORK(1),
    JS(2),
    DEX(3),
    SO(4);


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int value;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/kuikly/core/base/ExecuteMode$a;", "", "", "value", "Lcom/tencent/kuikly/core/base/ExecuteMode;", "a", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.kuikly.core.base.ExecuteMode$a, reason: from kotlin metadata */
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ExecuteMode a(int value) {
            for (ExecuteMode executeMode : ExecuteMode.values()) {
                if (executeMode.getValue() == value) {
                    return executeMode;
                }
            }
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }

        Companion() {
        }
    }

    ExecuteMode(int i3) {
        this.value = i3;
    }

    public final int getValue() {
        return this.value;
    }
}
