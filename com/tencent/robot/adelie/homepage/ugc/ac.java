package com.tencent.robot.adelie.homepage.ugc;

import android.content.Context;
import android.content.Intent;
import com.tencent.qqnt.kernel.nativeinterface.BotGender;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J0\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006J$\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000b\u001a\u00020\n\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/robot/adelie/homepage/ugc/ac;", "", "Landroid/content/Context;", "context", "Lcom/tencent/qqnt/kernel/nativeinterface/BotGender;", "avatarGender", "", "characterDescription", "", "a", "", "source", "avatarImageUrl", "coverImageUrl", "c", "originImageUrl", "b", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class ac {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ac f366521a = new ac();

    ac() {
    }

    public final void a(@NotNull Context context, @NotNull BotGender avatarGender, @NotNull String characterDescription) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(avatarGender, "avatarGender");
        Intrinsics.checkNotNullParameter(characterDescription, "characterDescription");
        Intent intent = new Intent();
        intent.putExtra("character.gender", avatarGender.ordinal());
        intent.putExtra("character.description", characterDescription);
        AdelieAvatarFragment.INSTANCE.a(context, intent, 133);
    }

    public final void b(@NotNull Context context, @Nullable String originImageUrl, int source) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent();
        intent.putExtra("source", source);
        intent.putExtra("origin_image_url", originImageUrl);
        AdelieAvatarEditFragment.INSTANCE.a(context, intent, 133);
    }

    public final void c(@NotNull Context context, int source, @Nullable String avatarImageUrl, @Nullable String coverImageUrl) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent();
        intent.putExtra("source", source);
        intent.putExtra("avatar_image_url", avatarImageUrl);
        intent.putExtra("cover_image_url", coverImageUrl);
        AdelieAvatarEditFragment.INSTANCE.a(context, intent, 133);
    }
}
