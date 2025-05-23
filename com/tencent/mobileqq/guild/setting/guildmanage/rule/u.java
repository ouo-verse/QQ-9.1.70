package com.tencent.mobileqq.guild.setting.guildmanage.rule;

import android.graphics.Typeface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/rule/u;", "", "Landroid/graphics/Typeface;", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final u f234280a = new u();

    u() {
    }

    @NotNull
    public final Typeface a() {
        try {
            Typeface create = Typeface.create(Typeface.SANS_SERIF, 1);
            Intrinsics.checkNotNullExpressionValue(create, "create(Typeface.SANS_SERIF, Typeface.BOLD)");
            return create;
        } catch (Exception unused) {
            Typeface defaultFromStyle = Typeface.defaultFromStyle(1);
            Intrinsics.checkNotNullExpressionValue(defaultFromStyle, "defaultFromStyle(Typeface.BOLD)");
            return defaultFromStyle;
        }
    }
}
