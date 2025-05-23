package com.tencent.robot.profile.setting.group;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.ac;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.robot.profile.setting.RobotSettingData;
import com.tencent.robot.profile.setting.group.t;
import com.tencent.robot.profile.utils.RobotProfileUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\r\u001a\u00020\n\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0014\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\b\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/robot/profile/setting/group/t;", "Lt44/a;", "Lcom/tencent/mobileqq/widget/listitem/a;", "Lcom/tencent/mobileqq/widget/listitem/ac;", "Landroid/view/View;", "j", "Lcom/tencent/mobileqq/widget/listitem/Group;", "a", "", "e", "Lcom/tencent/robot/profile/setting/c;", "d", "Lcom/tencent/robot/profile/setting/c;", "settingData", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "reportRobot", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/tencent/robot/profile/setting/c;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class t extends t44.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RobotSettingData settingData;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView reportRobot;

    /* compiled from: P */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J,\u0010\u000e\u001a\u00020\r2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\t\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/robot/profile/setting/group/t$a", "Lcom/tencent/mobileqq/widget/listitem/a;", "Lcom/tencent/mobileqq/widget/listitem/ac;", "Landroid/view/View;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "E", "viewHolder", "", "position", "", "", "payloads", "", "D", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class a extends com.tencent.mobileqq.widget.listitem.a<ac<View>> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void F(a this$0, t this$1, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            if (!u64.g.f438512a.g()) {
                VideoReport.reportEvent("clck", view, null);
                RobotProfileUtils robotProfileUtils = RobotProfileUtils.f368193a;
                Context context = this$1.c();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                robotProfileUtils.x(context, this$1.settingData.getRobotUin(), this$1.settingData.getTroopUin(), this$1.settingData.getProfile().isFriend);
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        @Override // com.tencent.mobileqq.widget.listitem.a
        /* renamed from: D, reason: merged with bridge method [inline-methods] */
        public void m(@NotNull ac<View> viewHolder, int position, @NotNull List<? extends Object> payloads) {
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            Intrinsics.checkNotNullParameter(payloads, "payloads");
        }

        @Override // com.tencent.mobileqq.widget.listitem.a
        @NotNull
        /* renamed from: E, reason: merged with bridge method [inline-methods] */
        public ac<View> n(@NotNull ViewGroup parent) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.hp8, parent, false);
            t.this.reportRobot = (TextView) itemView.findViewById(R.id.f73423ti);
            TextView textView = t.this.reportRobot;
            if (textView != null) {
                final t tVar = t.this;
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.robot.profile.setting.group.s
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        t.a.F(t.a.this, tVar, view);
                    }
                });
            }
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            return new ac<>(itemView);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(@NotNull Context context, @NotNull RobotSettingData settingData) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(settingData, "settingData");
        this.settingData = settingData;
    }

    private final com.tencent.mobileqq.widget.listitem.a<ac<View>> j() {
        return new a();
    }

    @Override // t44.a
    @NotNull
    protected Group a() {
        return Group.INSTANCE.d(j());
    }

    @Override // t44.a
    public void e() {
        TextView textView = this.reportRobot;
        if (textView != null) {
            com.tencent.robot.profile.setting.d.f368103a.a(textView, "em_bas_report_robot");
            VideoReport.reportEvent("imp", textView, null);
        }
    }
}
