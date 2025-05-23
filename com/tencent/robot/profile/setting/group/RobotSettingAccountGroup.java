package com.tencent.robot.profile.setting.group;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUISingleLineListItem;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.robot.profile.setting.RobotSettingData;
import com.tencent.robot.profile.setting.RobotSettingUtil;
import com.tencent.robot.profile.utils.RobotProfileUtils;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00192\u00020\u0001:\u0001\u0006B\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\b\u0010\u0007\u001a\u00020\u0002H\u0016R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR$\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000fR$\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000fR$\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000f\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/robot/profile/setting/group/RobotSettingAccountGroup;", "Lt44/a;", "", DomainData.DOMAIN_NAME, "j", "Lcom/tencent/mobileqq/widget/listitem/Group;", "a", "e", "Lcom/tencent/robot/profile/setting/c;", "d", "Lcom/tencent/robot/profile/setting/c;", "settingData", "Lt44/b;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$g;", "Lt44/b;", "jointTroopConfig", "f", "lookAtAdderConfig", "g", "accountInfoConfig", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/tencent/robot/profile/setting/c;)V", tl.h.F, "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotSettingAccountGroup extends t44.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RobotSettingData settingData;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private t44.b<x.b.d, x.c.g> jointTroopConfig;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private t44.b<x.b.d, x.c.g> lookAtAdderConfig;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private t44.b<x.b.d, x.c.g> accountInfoConfig;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotSettingAccountGroup(@NotNull Context context, @NotNull RobotSettingData settingData) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(settingData, "settingData");
        this.settingData = settingData;
    }

    private final void j() {
        t44.b<x.b.d, x.c.g> bVar = this.jointTroopConfig;
        if (bVar != null) {
            bVar.b0(new View.OnClickListener() { // from class: com.tencent.robot.profile.setting.group.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RobotSettingAccountGroup.k(RobotSettingAccountGroup.this, view);
                }
            });
        }
        t44.b<x.b.d, x.c.g> bVar2 = this.lookAtAdderConfig;
        if (bVar2 != null) {
            bVar2.b0(new View.OnClickListener() { // from class: com.tencent.robot.profile.setting.group.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RobotSettingAccountGroup.l(RobotSettingAccountGroup.this, view);
                }
            });
        }
        t44.b<x.b.d, x.c.g> bVar3 = this.accountInfoConfig;
        if (bVar3 != null) {
            bVar3.b0(new View.OnClickListener() { // from class: com.tencent.robot.profile.setting.group.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RobotSettingAccountGroup.m(RobotSettingAccountGroup.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(RobotSettingAccountGroup this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!u64.g.f438512a.g()) {
            if (!AppNetConnInfo.isNetSupport()) {
                QQToast.makeText(BaseApplication.getContext(), 1, this$0.c().getString(R.string.f223276fs), 0).show();
            } else {
                t44.b<x.b.d, x.c.g> bVar = this$0.jointTroopConfig;
                Intrinsics.checkNotNull(bVar);
                VideoReport.reportEvent("clck", bVar.V(), null);
                RobotSettingUtil robotSettingUtil = RobotSettingUtil.f368093a;
                Context context = this$0.c();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                RobotSettingUtil.s(robotSettingUtil, context, this$0.settingData.getRobotUin(), this$0.settingData.getRobotUin(), null, 8, null);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(RobotSettingAccountGroup this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!u64.g.f438512a.g()) {
            t44.b<x.b.d, x.c.g> bVar = this$0.lookAtAdderConfig;
            Intrinsics.checkNotNull(bVar);
            VideoReport.reportEvent("clck", bVar.V(), null);
            RobotSettingUtil robotSettingUtil = RobotSettingUtil.f368093a;
            Context context = this$0.c();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            robotSettingUtil.v(context, this$0.settingData.b());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(RobotSettingAccountGroup this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!u64.g.f438512a.g()) {
            t44.b<x.b.d, x.c.g> bVar = this$0.accountInfoConfig;
            Intrinsics.checkNotNull(bVar);
            VideoReport.reportEvent("clck", bVar.V(), null);
            RobotProfileUtils robotProfileUtils = RobotProfileUtils.f368193a;
            Context context = this$0.c();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            String robotUin = this$0.settingData.getRobotUin();
            String str = this$0.settingData.getProfile().robotData.verify;
            Intrinsics.checkNotNullExpressionValue(str, "settingData.profile.robotData.verify");
            robotProfileUtils.r(context, robotUin, str);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void n() {
        RobotSettingUtil robotSettingUtil = RobotSettingUtil.f368093a;
        Context context = c();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        robotSettingUtil.t(context, this.settingData.b(), this.settingData.getTroopUin(), new Function1<String, Unit>() { // from class: com.tencent.robot.profile.setting.group.RobotSettingAccountGroup$loadAdderNick$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String nickname) {
                t44.b bVar;
                t44.b bVar2;
                Intrinsics.checkNotNullParameter(nickname, "nickname");
                bVar = RobotSettingAccountGroup.this.lookAtAdderConfig;
                if (bVar != null) {
                    bVar.a0(nickname);
                }
                bVar2 = RobotSettingAccountGroup.this.lookAtAdderConfig;
                if (bVar2 != null) {
                    bVar2.c0(nickname.length() == 0 ? 8 : 0);
                }
            }
        });
    }

    @Override // t44.a
    @NotNull
    protected Group a() {
        ArrayList arrayList = new ArrayList();
        if (this.settingData.a()) {
            CharSequence text = c().getText(R.string.f223246fp);
            Intrinsics.checkNotNullExpressionValue(text, "context.getText(R.string\u2026t_setting_joint_to_troop)");
            t44.b<x.b.d, x.c.g> bVar = new t44.b<>(new x.b.d(text), new x.c.g("", true, false), d());
            this.jointTroopConfig = bVar;
            Intrinsics.checkNotNull(bVar);
            arrayList.add(bVar);
        }
        CharSequence text2 = c().getText(R.string.f223156fg);
        Intrinsics.checkNotNullExpressionValue(text2, "context.getText(R.string\u2026bot_setting_account_info)");
        this.accountInfoConfig = new t44.b<>(new x.b.d(text2), new x.c.g("", true, false), d());
        if (this.settingData.g() && this.settingData.f()) {
            CharSequence text3 = c().getText(R.string.f223256fq);
            Intrinsics.checkNotNullExpressionValue(text3, "context.getText(R.string\u2026ot_setting_look_at_adder)");
            t44.b<x.b.d, x.c.g> bVar2 = new t44.b<>(new x.b.d(text3), new x.c.g("", true, false), d());
            this.lookAtAdderConfig = bVar2;
            Intrinsics.checkNotNull(bVar2);
            arrayList.add(bVar2);
            n();
        }
        t44.b<x.b.d, x.c.g> bVar3 = this.accountInfoConfig;
        Intrinsics.checkNotNull(bVar3);
        arrayList.add(bVar3);
        j();
        Object[] array = arrayList.toArray(new x[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        x[] xVarArr = (x[]) array;
        return new Group((com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(xVarArr, xVarArr.length));
    }

    @Override // t44.a
    public void e() {
        QUISingleLineListItem V;
        QUISingleLineListItem V2;
        QUISingleLineListItem V3;
        super.e();
        t44.b<x.b.d, x.c.g> bVar = this.jointTroopConfig;
        if (bVar != null && (V3 = bVar.V()) != null) {
            com.tencent.robot.profile.setting.d.f368103a.a(V3, "em_bas_add_to_group_chat");
            VideoReport.reportEvent("imp", V3, null);
        }
        t44.b<x.b.d, x.c.g> bVar2 = this.lookAtAdderConfig;
        if (bVar2 != null && (V2 = bVar2.V()) != null) {
            com.tencent.robot.profile.setting.d.f368103a.a(V2, "em_bas_view_adders");
            VideoReport.reportEvent("imp", V2, null);
        }
        t44.b<x.b.d, x.c.g> bVar3 = this.accountInfoConfig;
        if (bVar3 != null && (V = bVar3.V()) != null) {
            com.tencent.robot.profile.setting.d.f368103a.a(V, "em_bas_account_information");
            VideoReport.reportEvent("imp", V, null);
        }
    }
}
