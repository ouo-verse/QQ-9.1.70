package com.tencent.mobileqq.guild.base.fragments;

import androidx.lifecycle.ViewModelStore;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 \u00042\u00020\u0001:\u0001\u0005J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/guild/base/fragments/SharedViewModelStoreOwner;", "", "Landroidx/lifecycle/ViewModelStore;", "p3", "h4", "Companion", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public interface SharedViewModelStoreOwner {

    /* renamed from: h4, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f214747a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\u000b\u001a\u00020\b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\u0003\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/base/fragments/SharedViewModelStoreOwner$Companion;", "", "Lcom/tencent/mobileqq/guild/base/fragments/a;", "b", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/guild/base/fragments/a;", "getter", "Lcom/tencent/mobileqq/guild/base/fragments/c;", "c", "()Lcom/tencent/mobileqq/guild/base/fragments/c;", "ownerGetter", "<init>", "()V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f214747a = new Companion();

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private static final Lazy<b> getter;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private static final Lazy<e> ownerGetter;

        static {
            Lazy<b> lazy;
            Lazy<e> lazy2;
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<b>() { // from class: com.tencent.mobileqq.guild.base.fragments.SharedViewModelStoreOwner$Companion$getter$2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final b invoke() {
                    return new b();
                }
            });
            getter = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<e>() { // from class: com.tencent.mobileqq.guild.base.fragments.SharedViewModelStoreOwner$Companion$ownerGetter$2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final e invoke() {
                    return new e();
                }
            });
            ownerGetter = lazy2;
        }

        Companion() {
        }

        @NotNull
        public final a a() {
            return getter.getValue();
        }

        @NotNull
        public final c b() {
            return ownerGetter.getValue();
        }
    }

    @NotNull
    ViewModelStore p3();
}
