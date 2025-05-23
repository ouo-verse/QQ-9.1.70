package com.tencent.mobileqq.guild.quiprofile;

import android.graphics.ColorFilter;
import android.util.Log;
import com.tencent.ams.mosaic.jsengine.animation.custom.CustomAnimation;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.BaseConstantState;
import com.tencent.theme.SkinData;
import com.tencent.theme.SkinnableColorStateList;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u001c\u0010\u000e\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\u0011\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0018\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0002H\u0016J\u0010\u0010\u0018\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/quiprofile/GuildTokenEngine;", "Lcom/tencent/mobileqq/skin/a;", "Lcom/tencent/theme/BaseConstantState;", "constantState", "", "onDrawableLoaded", "onDrawableReloaded", "Lcom/tencent/theme/SkinnableColorStateList;", "colorStateList", "onColorLoaded", "onColorReloaded", "Landroid/graphics/ColorFilter;", CustomAnimation.KeyPath.COLOR_FILTER, "", "needBlockSetColorFilter", "", com.tencent.luggage.wxa.c8.c.f123400v, "needBlockSetAlpha", "resId", "", "filePath", "addResources", "state", "isFocusedDrawable", "isFocusedColor", "<init>", "()V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildTokenEngine implements com.tencent.mobileqq.skin.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00038\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/quiprofile/GuildTokenEngine$a;", "", "Lkotlin/Function0;", "", "block", "", "b", "", "DEBUG", "Z", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.quiprofile.GuildTokenEngine$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void b(Function0<String> block) {
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("Guild.GuildTokenEngine", block.invoke());
            }
        }

        Companion() {
        }
    }

    public GuildTokenEngine() {
        Logger.f235387a.d().i("Guild.GuildTokenEngine", 1, "init");
    }

    @Override // com.tencent.theme.i
    public boolean addResources(final int resId, @NotNull final String filePath) {
        boolean contains$default;
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) filePath, (CharSequence) (File.separator + "guild"), false, 2, (Object) null);
        if (!contains$default) {
            INSTANCE.b(new Function0<String>() { // from class: com.tencent.mobileqq.guild.quiprofile.GuildTokenEngine$addResources$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final String invoke() {
                    return "addResources fail filePath: " + filePath + ", resId: " + resId;
                }
            });
            return false;
        }
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.GuildTokenEngine", "addResources success filePath: " + filePath + ", resId: " + resId);
            return true;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.skin.a
    public boolean isFocusedColor(@NotNull SkinnableColorStateList colorStateList) {
        Intrinsics.checkNotNullParameter(colorStateList, "colorStateList");
        return false;
    }

    @Override // com.tencent.mobileqq.skin.a
    public boolean isFocusedDrawable(@NotNull BaseConstantState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        return false;
    }

    @Override // com.tencent.theme.i
    public boolean needBlockSetAlpha(@Nullable BaseConstantState constantState, int alpha) {
        return false;
    }

    @Override // com.tencent.theme.i
    public boolean needBlockSetColorFilter(@Nullable BaseConstantState constantState, @Nullable ColorFilter colorFilter) {
        return false;
    }

    @Override // com.tencent.theme.i
    public void onColorLoaded(@NotNull final SkinnableColorStateList colorStateList) {
        Intrinsics.checkNotNullParameter(colorStateList, "colorStateList");
        INSTANCE.b(new Function0<String>() { // from class: com.tencent.mobileqq.guild.quiprofile.GuildTokenEngine$onColorLoaded$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                SkinData skinData = SkinnableColorStateList.this.skinData;
                return "onColorLoaded success filePath: " + skinData.mFilePath + ", resId: " + skinData.mResourcesID;
            }
        });
    }

    @Override // com.tencent.theme.i
    public void onColorReloaded(@NotNull final SkinnableColorStateList colorStateList) {
        Intrinsics.checkNotNullParameter(colorStateList, "colorStateList");
        INSTANCE.b(new Function0<String>() { // from class: com.tencent.mobileqq.guild.quiprofile.GuildTokenEngine$onColorReloaded$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                SkinData skinData = SkinnableColorStateList.this.skinData;
                return "onColorReloaded success filePath: " + skinData.mFilePath + ", resId: " + skinData.mResourcesID;
            }
        });
    }

    @Override // com.tencent.theme.i
    public void onDrawableLoaded(@NotNull final BaseConstantState constantState) {
        Intrinsics.checkNotNullParameter(constantState, "constantState");
        INSTANCE.b(new Function0<String>() { // from class: com.tencent.mobileqq.guild.quiprofile.GuildTokenEngine$onDrawableLoaded$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                SkinData skinData = BaseConstantState.this.skinData;
                return "onDrawableLoaded success filePath: " + skinData.mFilePath + ", resId: " + skinData.mResourcesID;
            }
        });
    }

    @Override // com.tencent.theme.i
    public void onDrawableReloaded(@NotNull final BaseConstantState constantState) {
        Intrinsics.checkNotNullParameter(constantState, "constantState");
        INSTANCE.b(new Function0<String>() { // from class: com.tencent.mobileqq.guild.quiprofile.GuildTokenEngine$onDrawableReloaded$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                SkinData skinData = BaseConstantState.this.skinData;
                return "onDrawableReloaded success filePath: " + skinData.mFilePath + ", resId: " + skinData.mResourcesID;
            }
        });
    }
}
