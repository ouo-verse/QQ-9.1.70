package d01;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\u0010\u001a\u00020\f\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0017\u0010\u000b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\nR\u0017\u0010\u0010\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Ld01/y;", "", "", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "processor", "", "b", "Ljava/lang/CharSequence;", "()Ljava/lang/CharSequence;", "sourceText", "Lcom/tencent/kuikly/core/render/android/expand/component/d;", "c", "Lcom/tencent/kuikly/core/render/android/expand/component/d;", "()Lcom/tencent/kuikly/core/render/android/expand/component/d;", "textProps", "<init>", "(Ljava/lang/String;Ljava/lang/CharSequence;Lcom/tencent/kuikly/core/render/android/expand/component/d;)V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String processor;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CharSequence sourceText;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.kuikly.core.render.android.expand.component.d textProps;

    public y(@NotNull String processor, @NotNull CharSequence sourceText, @NotNull com.tencent.kuikly.core.render.android.expand.component.d textProps) {
        Intrinsics.checkNotNullParameter(processor, "processor");
        Intrinsics.checkNotNullParameter(sourceText, "sourceText");
        Intrinsics.checkNotNullParameter(textProps, "textProps");
        this.processor = processor;
        this.sourceText = sourceText;
        this.textProps = textProps;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getProcessor() {
        return this.processor;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final CharSequence getSourceText() {
        return this.sourceText;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final com.tencent.kuikly.core.render.android.expand.component.d getTextProps() {
        return this.textProps;
    }
}
