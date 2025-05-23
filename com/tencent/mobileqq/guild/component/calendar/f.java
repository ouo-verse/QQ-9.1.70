package com.tencent.mobileqq.guild.component.calendar;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.component.calendar.d;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/component/calendar/f;", "Lcom/tencent/mobileqq/guild/component/calendar/i;", "Lcom/tencent/mobileqq/guild/component/calendar/d$b;", "data", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "month", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "<init>", "(Landroid/view/ViewGroup;)V", UserInfo.SEX_FEMALE, "a", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class f extends i<d.CalendarMonth> {

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final TextView month;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/component/calendar/f$a;", "", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/widget/TextView;", "b", "<init>", "()V", "qqguild-component_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.component.calendar.f$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final TextView b(ViewGroup parent) {
            TextView textView = new TextView(parent.getContext());
            textView.setTextColor(textView.getContext().getResources().getColorStateList(R.color.qui_common_text_primary));
            textView.setTextSize(1, 22.0f);
            textView.setGravity(16);
            RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(-1, kotlin.g.c(textView, 26.0f));
            layoutParams.setMargins(kotlin.g.c(textView, 2.0f), kotlin.g.c(textView, 26.0f), 0, kotlin.g.c(textView, 8.0f));
            textView.setLayoutParams(layoutParams);
            return textView;
        }

        Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(@NotNull ViewGroup parent) {
        super(INSTANCE.b(parent), null);
        Intrinsics.checkNotNullParameter(parent, "parent");
        View view = this.itemView;
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.widget.TextView");
        this.month = (TextView) view;
    }

    @Override // com.tencent.mobileqq.guild.component.calendar.i
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void l(@NotNull d.CalendarMonth data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.month.setText(data.getMonth() + "\u6708");
    }
}
