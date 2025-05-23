package com.tencent.mobileqq.wink.publish.util;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u00062\u00020\u0001:\u0001\u0007B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0005R\u0016\u0010\t\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/wink/publish/util/PublishTagCounter;", "", "", "c", "d", "", "b", "a", "I", "tagNum", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class PublishTagCounter {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final Lazy<PublishTagCounter> f325954c;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int tagNum;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/wink/publish/util/PublishTagCounter$a;", "", "Lcom/tencent/mobileqq/wink/publish/util/PublishTagCounter;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/wink/publish/util/PublishTagCounter;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.publish.util.PublishTagCounter$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final PublishTagCounter a() {
            return (PublishTagCounter) PublishTagCounter.f325954c.getValue();
        }

        Companion() {
        }
    }

    static {
        Lazy<PublishTagCounter> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<PublishTagCounter>() { // from class: com.tencent.mobileqq.wink.publish.util.PublishTagCounter$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final PublishTagCounter invoke() {
                return new PublishTagCounter(null);
            }
        });
        f325954c = lazy;
    }

    public /* synthetic */ PublishTagCounter(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* renamed from: b, reason: from getter */
    public final int getTagNum() {
        return this.tagNum;
    }

    public final void c() {
        this.tagNum++;
    }

    public final void d() {
        this.tagNum = 0;
    }

    PublishTagCounter() {
    }
}
