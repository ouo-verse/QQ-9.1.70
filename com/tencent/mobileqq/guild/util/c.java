package com.tencent.mobileqq.guild.util;

import android.view.View;
import androidx.annotation.ColorRes;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H&J&\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\bH&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/util/c;", "", "", "color", "", "setColor", "", "useUnderLine", "Lkotlin/Function1;", "Landroid/view/View;", NodeProps.ON_CLICK, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public interface c {
    void a(boolean useUnderLine, @NotNull Function1<? super View, Unit> onClick);

    void setColor(@ColorRes int color);
}
