package com.tencent.mobileqq.guild.mission.beginmission.mainframe.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/mission/beginmission/mainframe/view/MissionView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mobileqq/guild/mission/beginmission/mainframe/view/MissionProgressView;", "d", "Lcom/tencent/mobileqq/guild/mission/beginmission/mainframe/view/MissionProgressView;", "progressView", "Lcom/tencent/mobileqq/guild/mission/beginmission/mainframe/view/MissionListView;", "e", "Lcom/tencent/mobileqq/guild/mission/beginmission/mainframe/view/MissionListView;", "missionListView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class MissionView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MissionProgressView progressView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MissionListView missionListView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MissionView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ MissionView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MissionView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(context, R.layout.egt, this);
        setOrientation(1);
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        View findViewById = findViewById(R.id.g2d);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.progress_view)");
        this.progressView = (MissionProgressView) findViewById;
        View findViewById2 = findViewById(R.id.zbw);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.mission_list_view)");
        this.missionListView = (MissionListView) findViewById2;
    }
}
