package com.tencent.mobileqq.vas.ui;

import android.graphics.drawable.Animatable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/vas/ui/IDynamicDrawable;", "Landroid/graphics/drawable/Animatable;", "setLoadedListener", "", "block", "Lkotlin/Function1;", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public interface IDynamicDrawable extends Animatable {
    void setLoadedListener(@NotNull Function1<? super IDynamicDrawable, Unit> block);
}
