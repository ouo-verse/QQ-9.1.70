package com.tencent.mobileqq.wink.dect;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/wink/dect/c;", "", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public interface c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f318193a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0005\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/wink/dect/c$a;", "", "", "b", "I", "()I", "TYPE_SMART_FILTER", "c", "a", "TYPE_PUBLIC", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.dect.c$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f318193a = new Companion();

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private static final int TYPE_SMART_FILTER = 1;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private static final int TYPE_PUBLIC = 2;

        Companion() {
        }

        public final int a() {
            return TYPE_PUBLIC;
        }

        public final int b() {
            return TYPE_SMART_FILTER;
        }
    }
}
