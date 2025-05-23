package com.tencent.mobileqq.guild.component.calendar;

import android.view.ViewGroup;
import android.widget.Space;
import com.tencent.mobileqq.guild.component.calendar.d;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/component/calendar/g;", "Lcom/tencent/mobileqq/guild/component/calendar/i;", "Lcom/tencent/mobileqq/guild/component/calendar/d$c;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "<init>", "(Landroid/view/ViewGroup;)V", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class g extends i<d.PlaceHolder> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(@NotNull ViewGroup parent) {
        super(new Space(parent.getContext()), null);
        Intrinsics.checkNotNullParameter(parent, "parent");
    }
}
