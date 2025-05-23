package com.tencent.robot.profile.setting.group;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.kuikly.core.render.android.css.ktx.KRCSSViewExtensionKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.ac;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.robot.profile.setting.RobotSettingData;
import com.tencent.robot.profile.setting.RobotSettingUtil;
import com.tencent.robot.profile.setting.group.RobotSettingDeleteRobotGroup;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00192\u00020\u0001:\u0001\tB\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0014\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\bH\u0014J\b\u0010\n\u001a\u00020\u0006H\u0016R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0010R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/robot/profile/setting/group/RobotSettingDeleteRobotGroup;", "Lt44/a;", "Lcom/tencent/mobileqq/widget/listitem/a;", "Lcom/tencent/mobileqq/widget/listitem/ac;", "Landroid/view/View;", "l", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/widget/listitem/Group;", "a", "e", "Lcom/tencent/robot/profile/setting/c;", "d", "Lcom/tencent/robot/profile/setting/c;", "settingData", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "deleteRobotView", "f", "Landroid/view/View;", "dlgReportView", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/tencent/robot/profile/setting/c;)V", "g", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotSettingDeleteRobotGroup extends t44.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RobotSettingData settingData;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView deleteRobotView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View dlgReportView;

    /* compiled from: P */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J,\u0010\u000e\u001a\u00020\r2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\t\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/robot/profile/setting/group/RobotSettingDeleteRobotGroup$b", "Lcom/tencent/mobileqq/widget/listitem/a;", "Lcom/tencent/mobileqq/widget/listitem/ac;", "Landroid/view/View;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "E", "viewHolder", "", "position", "", "", "payloads", "", "D", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b extends com.tencent.mobileqq.widget.listitem.a<ac<View>> {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void F(b this$0, RobotSettingDeleteRobotGroup this$1, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            if (!u64.g.f438512a.g()) {
                TextView textView = this$1.deleteRobotView;
                Intrinsics.checkNotNull(textView);
                VideoReport.reportEvent("clck", textView, null);
                this$1.m();
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
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.f169077hp4, parent, false);
            RobotSettingDeleteRobotGroup.this.deleteRobotView = (TextView) itemView.findViewById(R.id.f164966ug4);
            TextView textView = RobotSettingDeleteRobotGroup.this.deleteRobotView;
            if (textView != null) {
                final RobotSettingDeleteRobotGroup robotSettingDeleteRobotGroup = RobotSettingDeleteRobotGroup.this;
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.robot.profile.setting.group.l
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        RobotSettingDeleteRobotGroup.b.F(RobotSettingDeleteRobotGroup.b.this, robotSettingDeleteRobotGroup, view);
                    }
                });
            }
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            return new ac<>(itemView);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotSettingDeleteRobotGroup(@NotNull Context context, @NotNull RobotSettingData settingData) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(settingData, "settingData");
        this.settingData = settingData;
    }

    private final com.tencent.mobileqq.widget.listitem.a<ac<View>> l() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m() {
        Object obj;
        View view;
        if (!NetworkUtil.isNetSupport(c())) {
            QQToast.makeText(c(), 1, c().getString(R.string.f223276fs), 0).show();
            return;
        }
        final QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(c(), 0);
        createCustomDialog.setTitle(R.string.f223226fn);
        createCustomDialog.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.tencent.robot.profile.setting.group.j
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                RobotSettingDeleteRobotGroup.n(RobotSettingDeleteRobotGroup.this, dialogInterface, i3);
            }
        });
        createCustomDialog.setPositiveButton(R.string.f171151ok, new DialogInterface.OnClickListener() { // from class: com.tencent.robot.profile.setting.group.k
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                RobotSettingDeleteRobotGroup.o(RobotSettingDeleteRobotGroup.this, createCustomDialog, dialogInterface, i3);
            }
        });
        createCustomDialog.show();
        Context context = c();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Activity i3 = KRCSSViewExtensionKt.i(context);
        if (i3 != null) {
            View view2 = new View(i3);
            this.dlgReportView = view2;
            TextView textView = this.deleteRobotView;
            if (textView != null) {
                obj = textView.getParent();
            } else {
                obj = null;
            }
            if (obj instanceof View) {
                view = (View) obj;
            } else {
                view = null;
            }
            VideoReport.setLogicParent(view2, view);
            com.tencent.robot.profile.setting.d.f368103a.a(view2, "em_bas_double_confirm_window");
            VideoReport.reportEvent("imp", view2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(RobotSettingDeleteRobotGroup this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dialogInterface.dismiss();
        View view = this$0.dlgReportView;
        if (view != null) {
            com.tencent.robot.profile.setting.d.f368103a.a(view, "em_bas_cancel");
            VideoReport.reportEvent("clck", view, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(final RobotSettingDeleteRobotGroup this$0, final QQCustomDialog qQCustomDialog, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RobotSettingUtil.f368093a.l(this$0.settingData.getRobotUin(), this$0.settingData.getProfile().robotData.robotUid.toString(), new Function1<Boolean, Unit>() { // from class: com.tencent.robot.profile.setting.group.RobotSettingDeleteRobotGroup$showRemoveConfirmDialog$1$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                View view;
                view = RobotSettingDeleteRobotGroup.this.dlgReportView;
                if (view != null) {
                    com.tencent.robot.profile.setting.d.f368103a.a(view, "em_bas_confirm");
                    VideoReport.reportEvent("clck", view, null);
                }
                if (z16) {
                    QQToast.makeText(BaseApplication.getContext(), 2, R.string.f223026f4, 0).show();
                } else {
                    QQToast.makeText(BaseApplication.getContext(), 1, R.string.f222976ez, 0).show();
                }
                if (z16) {
                    Context context = qQCustomDialog.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    Activity i16 = KRCSSViewExtensionKt.i(context);
                    if (i16 != null) {
                        Intent intent = new Intent();
                        intent.putExtra("key_permissions_fragment_exit", true);
                        i16.setResult(-1, intent);
                        i16.finish();
                    }
                }
            }
        });
        dialogInterface.dismiss();
    }

    @Override // t44.a
    @NotNull
    protected Group a() {
        return Group.INSTANCE.d(l());
    }

    @Override // t44.a
    public void e() {
        TextView textView = this.deleteRobotView;
        if (textView != null) {
            com.tencent.robot.profile.setting.d.f368103a.a(textView, "em_bas_delete_robot");
            VideoReport.reportEvent("imp", textView, null);
        }
    }
}
