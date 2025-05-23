package com.tencent.mobileqq.guild.component.calendar;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.component.calendar.d;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/component/calendar/c;", "Lcom/tencent/mobileqq/guild/component/calendar/i;", "Lcom/tencent/mobileqq/guild/component/calendar/d$a;", "data", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "<init>", "(Landroid/view/ViewGroup;)V", "E", "a", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class c extends i<d.CalendarDay> {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/component/calendar/c$a;", "", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/widget/TextView;", "b", "<init>", "()V", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.component.calendar.c$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final TextView b(ViewGroup parent) {
            TextView textView = new TextView(parent.getContext());
            textView.setTextColor(textView.getContext().getResources().getColorStateList(R.color.qui_common_text_primary));
            textView.setTextSize(1, 16.0f);
            textView.setGravity(17);
            RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(kotlin.g.c(textView, 40.0f), kotlin.g.c(textView, 40.0f));
            layoutParams.setMargins(0, kotlin.g.c(textView, 8.0f), 0, kotlin.g.c(textView, 8.0f));
            textView.setLayoutParams(layoutParams);
            return textView;
        }

        Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull ViewGroup parent) {
        super(INSTANCE.b(parent), null);
        Intrinsics.checkNotNullParameter(parent, "parent");
    }

    @Override // com.tencent.mobileqq.guild.component.calendar.i
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void l(@NotNull d.CalendarDay data) {
        Intrinsics.checkNotNullParameter(data, "data");
        View view = this.itemView;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) view).setText(String.valueOf(data.getDay()));
    }
}
