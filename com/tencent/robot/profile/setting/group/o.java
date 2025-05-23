package com.tencent.robot.profile.setting.group;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUISingleLineListItem;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.robot.profile.setting.RobotPermissionsSettingFragment;
import com.tencent.robot.profile.setting.RobotSettingData;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\r\u001a\u00020\n\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0014J\b\u0010\t\u001a\u00020\u0002H\u0016R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR$\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0011R$\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0011\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/robot/profile/setting/group/o;", "Lt44/a;", "", tl.h.F, "", "permissionsType", "k", "Lcom/tencent/mobileqq/widget/listitem/Group;", "a", "e", "Lcom/tencent/robot/profile/setting/c;", "d", "Lcom/tencent/robot/profile/setting/c;", "settingData", "Lt44/b;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$g;", "Lt44/b;", "troopPermissionsConfig", "f", "chatPermissionsConfig", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/tencent/robot/profile/setting/c;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class o extends t44.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RobotSettingData settingData;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private t44.b<x.b.d, x.c.g> troopPermissionsConfig;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private t44.b<x.b.d, x.c.g> chatPermissionsConfig;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(@NotNull Context context, @NotNull RobotSettingData settingData) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(settingData, "settingData");
        this.settingData = settingData;
    }

    private final void h() {
        t44.b<x.b.d, x.c.g> bVar = this.troopPermissionsConfig;
        if (bVar != null) {
            bVar.b0(new View.OnClickListener() { // from class: com.tencent.robot.profile.setting.group.m
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    o.i(o.this, view);
                }
            });
        }
        t44.b<x.b.d, x.c.g> bVar2 = this.chatPermissionsConfig;
        if (bVar2 != null) {
            bVar2.b0(new View.OnClickListener() { // from class: com.tencent.robot.profile.setting.group.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    o.j(o.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(o this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.k(0);
        t44.b<x.b.d, x.c.g> bVar = this$0.troopPermissionsConfig;
        Intrinsics.checkNotNull(bVar);
        VideoReport.reportEvent("clck", bVar.V(), null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(o this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.k(1);
        t44.b<x.b.d, x.c.g> bVar = this$0.chatPermissionsConfig;
        Intrinsics.checkNotNull(bVar);
        VideoReport.reportEvent("clck", bVar.V(), null);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void k(int permissionsType) {
        if (!u64.g.f438512a.g()) {
            RobotPermissionsSettingFragment.Companion companion = RobotPermissionsSettingFragment.INSTANCE;
            Context context = c();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            companion.a(context, permissionsType, this.settingData.getRobotUin(), this.settingData.getTroopUin());
        }
    }

    @Override // t44.a
    @NotNull
    protected Group a() {
        String string = c().getString(R.string.f223376g2);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026obot_setting_troop_title)");
        this.troopPermissionsConfig = new t44.b<>(new x.b.d(string), new x.c.g("", true, false), d());
        String string2 = c().getString(R.string.f223316fw);
        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri\u2026tting_private_chat_title)");
        this.chatPermissionsConfig = new t44.b<>(new x.b.d(string2), new x.c.g("", true, false), d());
        ArrayList arrayList = new ArrayList();
        if (this.settingData.f() && this.settingData.h()) {
            t44.b<x.b.d, x.c.g> bVar = this.troopPermissionsConfig;
            Intrinsics.checkNotNull(bVar);
            arrayList.add(bVar);
        }
        if (this.settingData.getProfile().isFriend) {
            t44.b<x.b.d, x.c.g> bVar2 = this.chatPermissionsConfig;
            Intrinsics.checkNotNull(bVar2);
            arrayList.add(bVar2);
        }
        h();
        Object[] array = arrayList.toArray(new x[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        x[] xVarArr = (x[]) array;
        return new Group((com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(xVarArr, xVarArr.length));
    }

    @Override // t44.a
    public void e() {
        QUISingleLineListItem V;
        QUISingleLineListItem V2;
        super.e();
        t44.b<x.b.d, x.c.g> bVar = this.troopPermissionsConfig;
        if (bVar != null && (V2 = bVar.V()) != null) {
            com.tencent.robot.profile.setting.d.f368103a.a(V2, "em_bas_group_permission");
            VideoReport.reportEvent("imp", V2, null);
        }
        t44.b<x.b.d, x.c.g> bVar2 = this.chatPermissionsConfig;
        if (bVar2 != null && (V = bVar2.V()) != null) {
            com.tencent.robot.profile.setting.d.f368103a.a(V, "em_bas_private_chat_permission");
            VideoReport.reportEvent("imp", V, null);
        }
    }
}
