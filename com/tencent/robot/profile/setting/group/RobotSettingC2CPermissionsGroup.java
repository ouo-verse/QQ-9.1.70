package com.tencent.robot.profile.setting.group;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.CompoundButton;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001f2\u00020\u0001:\u0001\tB\u0017\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0014J\b\u0010\n\u001a\u00020\u0004H\u0016R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR$\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0012R$\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0012R$\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0012R$\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0012\u00a8\u0006 "}, d2 = {"Lcom/tencent/robot/profile/setting/group/RobotSettingC2CPermissionsGroup;", "Lt44/a;", "", "B", "", ReportConstant.COSTREPORT_PREFIX, HippyTKDListViewAdapter.X, "y", "Lcom/tencent/mobileqq/widget/listitem/Group;", "a", "e", "Lcom/tencent/robot/profile/setting/c;", "d", "Lcom/tencent/robot/profile/setting/c;", "settingData", "Lt44/b;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$f;", "Lt44/b;", "sendMessageToC2CConfig", "Lcom/tencent/mobileqq/widget/listitem/x$c$g;", "f", "subscribeMessageConfig", "g", "messageNotDisturbConfig", tl.h.F, "joinInBlackListConfig", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/tencent/robot/profile/setting/c;)V", "i", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotSettingC2CPermissionsGroup extends t44.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RobotSettingData settingData;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private t44.b<x.b.d, x.c.f> sendMessageToC2CConfig;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private t44.b<x.b.d, x.c.g> subscribeMessageConfig;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private t44.b<x.b.d, x.c.f> messageNotDisturbConfig;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private t44.b<x.b.d, x.c.f> joinInBlackListConfig;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotSettingC2CPermissionsGroup(@NotNull Context context, @NotNull RobotSettingData settingData) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(settingData, "settingData");
        this.settingData = settingData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(final RobotSettingC2CPermissionsGroup this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RobotSettingUtil.f368093a.z(this$0.settingData.getRobotUin(), new Function1<Boolean, Unit>() { // from class: com.tencent.robot.profile.setting.group.RobotSettingC2CPermissionsGroup$showAddBlackListDialog$1$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                t44.b bVar;
                t44.b bVar2;
                t44.b bVar3;
                t44.b bVar4;
                if (!z16) {
                    bVar4 = RobotSettingC2CPermissionsGroup.this.joinInBlackListConfig;
                    if (bVar4 == null) {
                        return;
                    }
                    bVar4.Y(false);
                    return;
                }
                bVar = RobotSettingC2CPermissionsGroup.this.sendMessageToC2CConfig;
                if (bVar != null) {
                    bVar.c0(8);
                }
                bVar2 = RobotSettingC2CPermissionsGroup.this.subscribeMessageConfig;
                if (bVar2 != null) {
                    bVar2.c0(8);
                }
                bVar3 = RobotSettingC2CPermissionsGroup.this.messageNotDisturbConfig;
                if (bVar3 != null) {
                    bVar3.c0(8);
                }
                com.tencent.robot.profile.setting.a.f368094a.b();
            }
        });
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean B() {
        if (this.settingData.getProfile().robotData.activeMsgConfig.supportC2c == 1) {
            return true;
        }
        return false;
    }

    private final void s() {
        RobotSettingUtil.f368093a.o(this.settingData.getRobotUin(), new Function1<Boolean, Unit>() { // from class: com.tencent.robot.profile.setting.group.RobotSettingC2CPermissionsGroup$initEvent$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                t44.b bVar;
                t44.b bVar2;
                t44.b bVar3;
                t44.b bVar4;
                t44.b bVar5;
                QUISingleLineListItem V;
                Map mapOf;
                boolean B;
                bVar = RobotSettingC2CPermissionsGroup.this.joinInBlackListConfig;
                if (bVar != null) {
                    bVar.Y(z16);
                }
                int i3 = 8;
                int i16 = z16 ? 8 : 0;
                if (!z16) {
                    B = RobotSettingC2CPermissionsGroup.this.B();
                    if (B) {
                        i3 = 0;
                    }
                }
                bVar2 = RobotSettingC2CPermissionsGroup.this.sendMessageToC2CConfig;
                if (bVar2 != null) {
                    bVar2.c0(i3);
                }
                bVar3 = RobotSettingC2CPermissionsGroup.this.subscribeMessageConfig;
                if (bVar3 != null) {
                    bVar3.c0(i16);
                }
                bVar4 = RobotSettingC2CPermissionsGroup.this.messageNotDisturbConfig;
                if (bVar4 != null) {
                    bVar4.c0(i16);
                }
                bVar5 = RobotSettingC2CPermissionsGroup.this.joinInBlackListConfig;
                if (bVar5 == null || (V = bVar5.V()) == null) {
                    return;
                }
                com.tencent.robot.profile.setting.d.f368103a.a(V, "em_bas_join_blacklist");
                mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("op_result", Integer.valueOf(z16 ? 1 : 2)));
                VideoReport.reportEvent("imp", V, mapOf);
                Object parent = V.getParent();
                VideoReport.setLogicParent(V, parent instanceof View ? (View) parent : null);
            }
        });
        t44.b<x.b.d, x.c.g> bVar = this.subscribeMessageConfig;
        if (bVar != null) {
            bVar.b0(new View.OnClickListener() { // from class: com.tencent.robot.profile.setting.group.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RobotSettingC2CPermissionsGroup.t(RobotSettingC2CPermissionsGroup.this, view);
                }
            });
        }
        t44.b<x.b.d, x.c.f> bVar2 = this.sendMessageToC2CConfig;
        if (bVar2 != null) {
            bVar2.Z(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.robot.profile.setting.group.e
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                    RobotSettingC2CPermissionsGroup.u(RobotSettingC2CPermissionsGroup.this, compoundButton, z16);
                }
            });
        }
        t44.b<x.b.d, x.c.f> bVar3 = this.messageNotDisturbConfig;
        if (bVar3 != null) {
            bVar3.Z(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.robot.profile.setting.group.f
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                    RobotSettingC2CPermissionsGroup.v(RobotSettingC2CPermissionsGroup.this, compoundButton, z16);
                }
            });
        }
        t44.b<x.b.d, x.c.f> bVar4 = this.joinInBlackListConfig;
        if (bVar4 != null) {
            bVar4.Z(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.robot.profile.setting.group.g
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                    RobotSettingC2CPermissionsGroup.w(RobotSettingC2CPermissionsGroup.this, compoundButton, z16);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(RobotSettingC2CPermissionsGroup this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!u64.g.f438512a.g()) {
            t44.b<x.b.d, x.c.g> bVar = this$0.subscribeMessageConfig;
            Intrinsics.checkNotNull(bVar);
            VideoReport.reportEvent("clck", bVar.V(), null);
            RobotSettingUtil robotSettingUtil = RobotSettingUtil.f368093a;
            Context context = this$0.c();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            robotSettingUtil.w(context, "", this$0.settingData.getRobotUin(), this$0.settingData.getProfile().userMembership);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(final RobotSettingC2CPermissionsGroup this$0, CompoundButton compoundButton, final boolean z16) {
        int i3;
        Map mapOf;
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("RobotSettingC2CPermissionsGroup", 1, "isChecked=" + z16);
        t44.b<x.b.d, x.c.f> bVar = this$0.sendMessageToC2CConfig;
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
            t44.b<x.b.d, x.c.f> bVar2 = this$0.sendMessageToC2CConfig;
            if (bVar2 != null) {
                bVar2.Y(!z16);
            }
        } else {
            this$0.settingData.getProfile().isReceive = z16;
            RobotSettingUtil.f368093a.E(z16, false, this$0.settingData.getRobotUin(), "", new Function2<Boolean, String, Unit>() { // from class: com.tencent.robot.profile.setting.group.RobotSettingC2CPermissionsGroup$initEvent$3$1
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
                    robotSettingData = RobotSettingC2CPermissionsGroup.this.settingData;
                    robotSettingData.getProfile().isReceive = !z16;
                    bVar3 = RobotSettingC2CPermissionsGroup.this.sendMessageToC2CConfig;
                    if (bVar3 != null) {
                        bVar3.Y(!z16);
                    }
                    c16 = RobotSettingC2CPermissionsGroup.this.c();
                    QQToast.makeText(c16, 1, errMsg, 0).show();
                }
            });
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(RobotSettingC2CPermissionsGroup this$0, CompoundButton compoundButton, boolean z16) {
        int i3;
        Map mapOf;
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!NetworkUtil.isNetSupport(this$0.c())) {
            QQToast.makeText(this$0.c(), 1, this$0.c().getString(R.string.f223276fs), 0).show();
            t44.b<x.b.d, x.c.f> bVar = this$0.messageNotDisturbConfig;
            if (bVar != null) {
                bVar.Y(!z16);
            }
        } else {
            t44.b<x.b.d, x.c.f> bVar2 = this$0.messageNotDisturbConfig;
            Intrinsics.checkNotNull(bVar2);
            QUISingleLineListItem V = bVar2.V();
            if (z16) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("op_result", Integer.valueOf(i3)));
            VideoReport.reportEvent("clck", V, mapOf);
            QLog.i("RobotSettingC2CPermissionsGroup", 1, "messageNotDisturbConfig isChecked = " + z16);
            RobotSettingUtil robotSettingUtil = RobotSettingUtil.f368093a;
            String robotUin = this$0.settingData.getRobotUin();
            String str = this$0.settingData.getProfile().robotData.robotUid;
            Intrinsics.checkNotNullExpressionValue(str, "settingData.profile.robotData.robotUid");
            robotSettingUtil.D(robotUin, str, z16);
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(RobotSettingC2CPermissionsGroup this$0, CompoundButton compoundButton, boolean z16) {
        int i3;
        Map mapOf;
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        t44.b<x.b.d, x.c.f> bVar = this$0.joinInBlackListConfig;
        Intrinsics.checkNotNull(bVar);
        QUISingleLineListItem V = bVar.V();
        if (z16) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("op_result", Integer.valueOf(i3)));
        VideoReport.reportEvent("clck", V, mapOf);
        QLog.i("RobotSettingC2CPermissionsGroup", 1, "joinInBlackListConfig isChecked = " + z16);
        if (!NetworkUtil.isNetSupport(this$0.c())) {
            QQToast.makeText(this$0.c(), 1, this$0.c().getString(R.string.f223276fs), 0).show();
            t44.b<x.b.d, x.c.f> bVar2 = this$0.joinInBlackListConfig;
            if (bVar2 != null) {
                bVar2.Y(!z16);
            }
        } else if (z16) {
            this$0.y();
        } else {
            this$0.x();
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    private final void x() {
        RobotSettingUtil.f368093a.B(this.settingData.getRobotUin(), new Function1<Boolean, Unit>() { // from class: com.tencent.robot.profile.setting.group.RobotSettingC2CPermissionsGroup$sendCancelBlacklist$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:10:0x0019, code lost:
            
                r2 = r1.this$0.sendMessageToC2CConfig;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke(boolean z16) {
                boolean B;
                t44.b bVar;
                t44.b bVar2;
                t44.b bVar3;
                t44.b bVar4;
                if (!z16) {
                    bVar4 = RobotSettingC2CPermissionsGroup.this.joinInBlackListConfig;
                    if (bVar4 == null) {
                        return;
                    }
                    bVar4.Y(true);
                    return;
                }
                B = RobotSettingC2CPermissionsGroup.this.B();
                if (B && bVar3 != null) {
                    bVar3.c0(0);
                }
                bVar = RobotSettingC2CPermissionsGroup.this.subscribeMessageConfig;
                if (bVar != null) {
                    bVar.c0(0);
                }
                bVar2 = RobotSettingC2CPermissionsGroup.this.messageNotDisturbConfig;
                if (bVar2 != null) {
                    bVar2.c0(0);
                }
                com.tencent.robot.profile.setting.a.f368094a.b();
            }
        });
    }

    private final void y() {
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(c(), 0);
        createCustomDialog.setTitle(createCustomDialog.getContext().getString(R.string.f223176fi));
        createCustomDialog.setMessage(createCustomDialog.getContext().getString(R.string.f223166fh));
        createCustomDialog.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.tencent.robot.profile.setting.group.h
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                RobotSettingC2CPermissionsGroup.z(RobotSettingC2CPermissionsGroup.this, dialogInterface, i3);
            }
        });
        createCustomDialog.setPositiveButton(R.string.f171151ok, new DialogInterface.OnClickListener() { // from class: com.tencent.robot.profile.setting.group.i
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                RobotSettingC2CPermissionsGroup.A(RobotSettingC2CPermissionsGroup.this, dialogInterface, i3);
            }
        });
        createCustomDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(RobotSettingC2CPermissionsGroup this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        t44.b<x.b.d, x.c.f> bVar = this$0.joinInBlackListConfig;
        if (bVar != null) {
            bVar.Y(false);
        }
        dialogInterface.dismiss();
    }

    @Override // t44.a
    @NotNull
    protected Group a() {
        ArrayList arrayList = new ArrayList();
        String string = c().getString(R.string.f223186fj);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026tting_allow_send_message)");
        t44.b<x.b.d, x.c.f> bVar = new t44.b<>(new x.b.d(string), new x.c.f(this.settingData.getProfile().isReceive, null), d());
        this.sendMessageToC2CConfig = bVar;
        Intrinsics.checkNotNull(bVar);
        arrayList.add(bVar);
        if (this.settingData.getProfile().c2cSubscribeMsgTplCnt > 0) {
            String string2 = c().getString(R.string.f223356g0);
            Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri\u2026_subscribe_robot_message)");
            t44.b<x.b.d, x.c.g> bVar2 = new t44.b<>(new x.b.d(string2), new x.c.g(String.valueOf(this.settingData.getProfile().c2cSubscribeMsgTplCnt), true, false), d());
            this.subscribeMessageConfig = bVar2;
            Intrinsics.checkNotNull(bVar2);
            arrayList.add(bVar2);
        }
        boolean q16 = RobotSettingUtil.f368093a.q(this.settingData.getRobotUin());
        String string3 = c().getString(R.string.f223286ft);
        Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.stri\u2026ting_not_disturb_message)");
        t44.b<x.b.d, x.c.f> bVar3 = new t44.b<>(new x.b.d(string3), new x.c.f(q16, null), d());
        this.messageNotDisturbConfig = bVar3;
        Intrinsics.checkNotNull(bVar3);
        arrayList.add(bVar3);
        String string4 = c().getString(R.string.f223236fo);
        Intrinsics.checkNotNullExpressionValue(string4, "context.getString(R.stri\u2026setting_joint_black_list)");
        t44.b<x.b.d, x.c.f> bVar4 = new t44.b<>(new x.b.d(string4), new x.c.f(false, null), d());
        this.joinInBlackListConfig = bVar4;
        Intrinsics.checkNotNull(bVar4);
        arrayList.add(bVar4);
        s();
        String string5 = c().getString(R.string.f223206fl);
        Intrinsics.checkNotNullExpressionValue(string5, "context.getString(R.stri\u2026ot_setting_back_list_tip)");
        Object[] array = arrayList.toArray(new x[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        x[] xVarArr = (x[]) array;
        return new Group("", string5, (com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(xVarArr, xVarArr.length));
    }

    @Override // t44.a
    public void e() {
        QUISingleLineListItem V;
        Map mapOf;
        QUISingleLineListItem V2;
        QUISingleLineListItem V3;
        boolean z16;
        int i3;
        Map mapOf2;
        super.e();
        t44.b<x.b.d, x.c.f> bVar = this.sendMessageToC2CConfig;
        int i16 = 2;
        boolean z17 = false;
        if (bVar != null && (V3 = bVar.V()) != null) {
            com.tencent.robot.profile.setting.d.f368103a.a(V3, "em_bas_allows_active_sending");
            t44.b<x.b.d, x.c.f> bVar2 = this.sendMessageToC2CConfig;
            if (bVar2 != null && bVar2.W()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            mapOf2 = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("op_result", Integer.valueOf(i3)));
            VideoReport.reportEvent("imp", V3, mapOf2);
        }
        t44.b<x.b.d, x.c.g> bVar3 = this.subscribeMessageConfig;
        if (bVar3 != null && (V2 = bVar3.V()) != null) {
            com.tencent.robot.profile.setting.d.f368103a.a(V2, "em_bas_subscribe_bot_news");
            VideoReport.reportEvent("imp", V2, null);
        }
        t44.b<x.b.d, x.c.f> bVar4 = this.messageNotDisturbConfig;
        if (bVar4 != null && (V = bVar4.V()) != null) {
            com.tencent.robot.profile.setting.d.f368103a.a(V, "em_bas_message_not_disturb");
            t44.b<x.b.d, x.c.f> bVar5 = this.messageNotDisturbConfig;
            if (bVar5 != null && bVar5.W()) {
                z17 = true;
            }
            if (z17) {
                i16 = 1;
            }
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("op_result", Integer.valueOf(i16)));
            VideoReport.reportEvent("imp", V, mapOf);
        }
    }
}
