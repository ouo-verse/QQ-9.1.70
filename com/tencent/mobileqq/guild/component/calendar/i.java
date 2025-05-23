package com.tencent.mobileqq.guild.component.calendar;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.guild.component.calendar.d;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u0011\b\u0004\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u0082\u0001\u0003\f\r\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/component/calendar/i;", "Lcom/tencent/mobileqq/guild/component/calendar/d;", "T", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "data", "", "l", "(Lcom/tencent/mobileqq/guild/component/calendar/d;)V", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "Lcom/tencent/mobileqq/guild/component/calendar/c;", "Lcom/tencent/mobileqq/guild/component/calendar/f;", "Lcom/tencent/mobileqq/guild/component/calendar/g;", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public abstract class i<T extends d> extends RecyclerView.ViewHolder {
    public /* synthetic */ i(View view, DefaultConstructorMarker defaultConstructorMarker) {
        this(view);
    }

    public void l(@NotNull T data) {
        Intrinsics.checkNotNullParameter(data, "data");
    }

    i(View view) {
        super(view);
    }
}
