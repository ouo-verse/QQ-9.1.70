package com.tencent.mobileqq.wink.editor.subtitle.source;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u001a\u0010\u0004\u001a\u00020\u00008\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0001\u0010\u0003\"\u001a\u0010\t\u001a\u00020\u00058\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\b\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/subtitle/source/a;", "a", "Lcom/tencent/mobileqq/wink/editor/subtitle/source/a;", "()Lcom/tencent/mobileqq/wink/editor/subtitle/source/a;", "EMPTY_CANCELABLE", "Lcom/tencent/mobileqq/wink/editor/subtitle/source/c;", "b", "Lcom/tencent/mobileqq/wink/editor/subtitle/source/c;", "()Lcom/tencent/mobileqq/wink/editor/subtitle/source/c;", "EMPTY_CHAIN_CANCELABLE", "qq-wink-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final com.tencent.mobileqq.wink.editor.subtitle.source.a f322262a = new a();

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final c f322263b = new b();

    @NotNull
    public static final com.tencent.mobileqq.wink.editor.subtitle.source.a a() {
        return f322262a;
    }

    @NotNull
    public static final c b() {
        return f322263b;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\t\u001a\u00020\u00048\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/wink/editor/subtitle/source/g$a", "Lcom/tencent/mobileqq/wink/editor/subtitle/source/a;", "", "cancel", "", "d", "Z", "a", "()Z", "canceled", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements com.tencent.mobileqq.wink.editor.subtitle.source.a {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final boolean canceled = true;

        a() {
        }

        @Override // com.tencent.mobileqq.wink.editor.subtitle.source.a
        /* renamed from: a, reason: from getter */
        public boolean getCanceled() {
            return this.canceled;
        }

        @Override // com.tencent.mobileqq.wink.editor.subtitle.source.a
        public void cancel() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/wink/editor/subtitle/source/g$b", "Lcom/tencent/mobileqq/wink/editor/subtitle/source/c;", "Lcom/tencent/mobileqq/wink/editor/subtitle/source/a;", "child", "", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b extends c {
        b() {
        }

        @Override // com.tencent.mobileqq.wink.editor.subtitle.source.c, com.tencent.mobileqq.wink.editor.subtitle.source.b
        public void b(@Nullable com.tencent.mobileqq.wink.editor.subtitle.source.a child) {
        }
    }
}
