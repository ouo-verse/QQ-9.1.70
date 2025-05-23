package com.tencent.mobileqq.guild.jump.model.extras;

import android.os.Bundle;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b&\u0018\u0000 \b2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/jump/model/extras/AbsJumpExtra;", "Ljava/io/Serializable;", "Landroid/os/Bundle;", "bundle", "", "saveTo", "<init>", "()V", "Companion", "a", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public abstract class AbsJumpExtra implements Serializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ1\u0010\b\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0007\u00a2\u0006\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/jump/model/extras/AbsJumpExtra$a;", "", "Lcom/tencent/mobileqq/guild/jump/model/extras/AbsJumpExtra;", "T", "Landroid/os/Bundle;", "bundle", "Ljava/lang/Class;", "clazz", "a", "(Landroid/os/Bundle;Ljava/lang/Class;)Lcom/tencent/mobileqq/guild/jump/model/extras/AbsJumpExtra;", "<init>", "()V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.jump.model.extras.AbsJumpExtra$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @Nullable
        public final <T extends AbsJumpExtra> T a(@NotNull Bundle bundle, @NotNull Class<T> clazz) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            Serializable serializable = bundle.getSerializable(clazz.getCanonicalName());
            if (serializable instanceof AbsJumpExtra) {
                return (T) serializable;
            }
            return null;
        }

        Companion() {
        }
    }

    @JvmStatic
    @Nullable
    public static final <T extends AbsJumpExtra> T loadFrom(@NotNull Bundle bundle, @NotNull Class<T> cls) {
        return (T) INSTANCE.a(bundle, cls);
    }

    public final void saveTo(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        bundle.putSerializable(getClass().getCanonicalName(), this);
    }
}
