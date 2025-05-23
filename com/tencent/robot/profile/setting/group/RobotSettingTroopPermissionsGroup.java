package com.tencent.robot.profile.setting.group;

import android.content.Context;
import android.view.View;
import android.widget.CompoundButton;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUISingleLineListItem;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.robot.profile.setting.RobotSettingData;
import com.tencent.robot.profile.setting.RobotSettingUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00172\u00020\u0001:\u0001\u0005B\u0017\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\n\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\b\u0010\u0006\u001a\u00020\u0002H\u0016R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR$\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u000eR$\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000e\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/robot/profile/setting/group/RobotSettingTroopPermissionsGroup;", "Lt44/a;", "", "k", "Lcom/tencent/mobileqq/widget/listitem/Group;", "a", "e", "Lcom/tencent/robot/profile/setting/c;", "d", "Lcom/tencent/robot/profile/setting/c;", "settingData", "Lt44/b;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$f;", "Lt44/b;", "sendMessageToTroopConfig", "Lcom/tencent/mobileqq/widget/listitem/x$c$g;", "f", "receiveTroopSubscribeMessage", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/tencent/robot/profile/setting/c;)V", "g", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotSettingTroopPermissionsGroup extends t44.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RobotSettingData settingData;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private t44.b<x.b.d, x.c.f> sendMessageToTroopConfig;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private t44.b<x.b.d, x.c.g> receiveTroopSubscribeMessage;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotSettingTroopPermissionsGroup(@NotNull Context context, @NotNull RobotSettingData settingData) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(settingData, "settingData");
        this.settingData = settingData;
    }

    private final void k() {
        t44.b<x.b.d, x.c.f> bVar = this.sendMessageToTroopConfig;
        if (bVar != null) {
            bVar.Z(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.robot.profile.setting.group.u
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                    RobotSettingTroopPermissionsGroup.l(RobotSettingTroopPermissionsGroup.this, compoundButton, z16);
                }
            });
        }
        t44.b<x.b.d, x.c.g> bVar2 = this.receiveTroopSubscribeMessage;
        if (bVar2 != null) {
            bVar2.b0(new View.OnClickListener() { // from class: com.tencent.robot.profile.setting.group.v
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RobotSettingTroopPermissionsGroup.m(RobotSettingTroopPermissionsGroup.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(final RobotSettingTroopPermissionsGroup this$0, CompoundButton compoundButton, final boolean z16) {
        int i3;
        Map mapOf;
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("RobotSettingTroopPermissionsGroup", 1, "isChecked=" + z16);
        if (!u64.g.f438512a.g()) {
            t44.b<x.b.d, x.c.f> bVar = this$0.sendMessageToTroopConfig;
            Intrinsics.checkNotNull(bVar);
            QUISingleLineListItem V = bVar.V();
            if (z16) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("op_result", Integer.valueOf(i3)));
            VideoReport.reportEvent("clck", V, mapOf);
            if (!NetworkUtil.isNetSupport(this$0.c())) {
                QQToast.makeText(this$0.c(), 1, this$0.c().getString(R.string.f223276fs), 0).show();
                t44.b<x.b.d, x.c.f> bVar2 = this$0.sendMessageToTroopConfig;
                if (bVar2 != null) {
                    bVar2.Y(!z16);
                }
            } else {
                this$0.settingData.getProfile().isGroupReceive = z16;
                RobotSettingUtil.f368093a.E(z16, this$0.settingData.f(), this$0.settingData.getRobotUin(), this$0.settingData.getTroopUin(), new Function2<Boolean, String, Unit>() { // from class: com.tencent.robot.profile.setting.group.RobotSettingTroopPermissionsGroup$initEvent$1$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, String str) {
                        invoke(bool.booleanValue(), str);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z17, @NotNull String errMsg) {
                        RobotSettingData robotSettingData;
                        t44.b bVar3;
                        Context c16;
                        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                        if (z17) {
                            return;
                        }
                        robotSettingData = RobotSettingTroopPermissionsGroup.this.settingData;
                        robotSettingData.getProfile().isGroupReceive = !z16;
                        bVar3 = RobotSettingTroopPermissionsGroup.this.sendMessageToTroopConfig;
                        if (bVar3 != null) {
                            bVar3.Y(!z16);
                        }
                        c16 = RobotSettingTroopPermissionsGroup.this.c();
                        QQToast.makeText(c16, 1, errMsg, 0).show();
                    }
                });
            }
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(RobotSettingTroopPermissionsGroup this$0, View view) {
        QUISingleLineListItem qUISingleLineListItem;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!u64.g.f438512a.g()) {
            t44.b<x.b.d, x.c.g> bVar = this$0.receiveTroopSubscribeMessage;
            if (bVar != null) {
                qUISingleLineListItem = bVar.V();
            } else {
                qUISingleLineListItem = null;
            }
            VideoReport.reportEvent("clck", qUISingleLineListItem, null);
            RobotSettingUtil robotSettingUtil = RobotSettingUtil.f368093a;
            Context context = this$0.c();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            robotSettingUtil.w(context, this$0.settingData.getTroopUin(), this$0.settingData.getRobotUin(), this$0.settingData.getProfile().userMembership);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // t44.a
    @NotNull
    protected Group a() {
        ArrayList arrayList = new ArrayList();
        QLog.i("buildGroup isGroupReceive", 1, " = " + this.settingData.getProfile().isGroupReceive);
        if (this.settingData.getProfile().robotData.activeMsgConfig.supportGroup == 1) {
            String string = c().getString(R.string.f223196fk);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026ow_send_message_to_troop)");
            t44.b<x.b.d, x.c.f> bVar = new t44.b<>(new x.b.d(string), new x.c.f(this.settingData.getProfile().isGroupReceive, null), d());
            this.sendMessageToTroopConfig = bVar;
            Intrinsics.checkNotNull(bVar);
            arrayList.add(bVar);
        }
        if (this.settingData.getProfile().groupSubscribeMsgTplCnt > 0) {
            String string2 = c().getString(R.string.f223346fz);
            Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri\u2026etting_subscribe_message)");
            t44.b<x.b.d, x.c.g> bVar2 = new t44.b<>(new x.b.d(string2), new x.c.g(String.valueOf(this.settingData.getProfile().groupSubscribeMsgTplCnt), true, false), d());
            this.receiveTroopSubscribeMessage = bVar2;
            Intrinsics.checkNotNull(bVar2);
            arrayList.add(bVar2);
        }
        k();
        Object[] array = arrayList.toArray(new x[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        x[] xVarArr = (x[]) array;
        return new Group((com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(xVarArr, xVarArr.length));
    }

    @Override // t44.a
    public void e() {
        QUISingleLineListItem V;
        QUISingleLineListItem V2;
        Map mapOf;
        super.e();
        t44.b<x.b.d, x.c.f> bVar = this.sendMessageToTroopConfig;
        if (bVar != null && (V2 = bVar.V()) != null) {
            com.tencent.robot.profile.setting.d.f368103a.a(V2, "em_bas_allows_active_sending");
            t44.b<x.b.d, x.c.f> bVar2 = this.sendMessageToTroopConfig;
            boolean z16 = false;
            int i3 = 1;
            if (bVar2 != null && bVar2.W()) {
                z16 = true;
            }
            if (!z16) {
                i3 = 2;
            }
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("op_result", Integer.valueOf(i3)));
            VideoReport.reportEvent("imp", V2, mapOf);
        }
        t44.b<x.b.d, x.c.g> bVar3 = this.receiveTroopSubscribeMessage;
        if (bVar3 != null && (V = bVar3.V()) != null) {
            com.tencent.robot.profile.setting.d.f368103a.a(V, "em_bas_subscribe_bot_news");
            VideoReport.reportEvent("imp", V, null);
        }
    }
}
