package com.tencent.mobileqq.troopmanage;

import android.content.Context;
import android.content.DialogInterface;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.dh;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.proavatar.QQProAvatarDrawable;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqpermission.authorization.QQAuthorizationDialog;
import com.tencent.mobileqq.qqpermission.base.AuthorizationRequestInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.ISetAddRobotToGroupCallback;
import com.tencent.qqnt.kernelpublic.nativeinterface.MemberRole;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.qqnt.troopmemberlist.g;
import com.tencent.robot.relation.api.IRobotRelationService;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 :2\u00020\u0001:\u0001#B!\u0012\u0006\u0010'\u001a\u00020\"\u0012\b\u0010+\u001a\u0004\u0018\u00010(\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u00a2\u0006\u0004\b8\u00109J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\u001a\u0010\u000b\u001a\u00020\u00022\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\tH\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\u0087\u0001\u0010!\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0018\u00010\tj\u0004\u0018\u0001`\u00152W\b\u0002\u0010 \u001aQ\u0012\u0013\u0012\u00110\u0018\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0015\u0012\u0013\u0018\u00010\u0018\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u001d\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0017j\u0004\u0018\u0001`\u001fR\u0017\u0010'\u001a\u00020\"8\u0006\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0016\u0010+\u001a\u0004\u0018\u00010(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0017\u0010\u001b\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R$\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0018\u00010\tj\u0004\u0018\u0001`\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105Re\u0010 \u001aQ\u0012\u0013\u0012\u00110\u0018\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0015\u0012\u0013\u0018\u00010\u0018\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u001d\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0017j\u0004\u0018\u0001`\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107\u00a8\u0006;"}, d2 = {"Lcom/tencent/mobileqq/troopmanage/QTroopRobotAdminRoleHelper;", "", "", "y", "", "needAdmin", "t", "l", "r", "Lkotlin/Function0;", "differSuccessCallback", "k", "w", "", "iconType", "contentResId", HippyTKDListViewAdapter.X, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", "isOwner", "needAdminRole", "Lcom/tencent/mobileqq/troopmanage/TargetAction;", "targetAction", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "troopUin", "memberUin", "", QCircleDaTongConstant.ElementParamValue.OPERATION, "Lcom/tencent/mobileqq/troopmanage/SetAdminSuccessCallback;", "setAdminSuccessCallback", DomainData.DOMAIN_NAME, "Landroid/content/Context;", "a", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Landroidx/lifecycle/LifecycleOwner;", "b", "Landroidx/lifecycle/LifecycleOwner;", "owner", "c", "Ljava/lang/String;", "o", "()Ljava/lang/String;", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;", "d", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;", "robotInfo", "e", "Lkotlin/jvm/functions/Function0;", "f", "Lkotlin/jvm/functions/Function3;", "<init>", "(Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;Ljava/lang/String;)V", "g", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class QTroopRobotAdminRoleHelper {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final LifecycleOwner owner;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final String troopUin;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private TroopMemberInfo robotInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Function0<Unit> targetAction;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Function3<? super String, ? super String, ? super Byte, Unit> setAdminSuccessCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0014\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/troopmanage/QTroopRobotAdminRoleHelper$b", "Lcom/tencent/mobileqq/troop/api/observer/e;", "", IProfileProtocolConst.PARAM_TROOP_CODE, "memberUin", "", QCircleDaTongConstant.ElementParamValue.OPERATION, "", "onSetTroopAdminSuccess", "", "errorCode", "onSetTroopAdminFail", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends com.tencent.mobileqq.troop.api.observer.e {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f302873e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ byte f302874f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f302875h;

        b(String str, byte b16, Function0<Unit> function0) {
            this.f302873e = str;
            this.f302874f = b16;
            this.f302875h = function0;
        }

        @Override // com.tencent.mobileqq.troop.api.observer.e
        protected void onSetTroopAdminFail(int errorCode) {
            QTroopRobotAdminRoleHelper.this.x(1, R.string.f234457_0);
            QLog.i("QTroopRobotAdminRoleHelper", 1, "[onSetTroopAdminFail] errorCode = " + errorCode);
        }

        @Override // com.tencent.mobileqq.troop.api.observer.e
        protected void onSetTroopAdminSuccess(String troopCode, String memberUin, byte operation) {
            QLog.i("QTroopRobotAdminRoleHelper", 1, "[onSetTroopAdminSuccess] troopCode = " + troopCode + " memberUin = " + memberUin + " operation = " + ((int) operation));
            if (Intrinsics.areEqual(troopCode, QTroopRobotAdminRoleHelper.this.getTroopUin()) && Intrinsics.areEqual(memberUin, this.f302873e) && operation == this.f302874f) {
                Function0<Unit> function0 = this.f302875h;
                if (function0 != null) {
                    function0.invoke();
                }
                Function0 function02 = QTroopRobotAdminRoleHelper.this.targetAction;
                if (function02 != null) {
                    function02.invoke();
                }
                QTroopRobotAdminRoleHelper.this.y();
                Function3 function3 = QTroopRobotAdminRoleHelper.this.setAdminSuccessCallback;
                if (function3 != null) {
                    function3.invoke(QTroopRobotAdminRoleHelper.this.getTroopUin(), memberUin, Byte.valueOf(operation));
                }
            }
        }
    }

    public QTroopRobotAdminRoleHelper(Context context, LifecycleOwner lifecycleOwner, String troopUin) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        this.context = context;
        this.owner = lifecycleOwner;
        this.troopUin = troopUin;
        y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(Function0<Unit> differSuccessCallback) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            return;
        }
        NewIntent newIntent = new NewIntent(this.context, dh.class);
        newIntent.putExtra("command", 0);
        newIntent.putExtra(QCircleDaTongConstant.ElementParamValue.OPERATION, (byte) 1);
        newIntent.putExtra(AppConstants.Key.TROOP_CODE, this.troopUin);
        newIntent.putExtra("troop_member_uin", "2854196310");
        newIntent.setObserver(new b("2854196310", (byte) 1, differSuccessCallback));
        appInterface.startServlet(newIntent);
    }

    private final void l(final boolean needAdmin) {
        IRobotRelationService iRobotRelationService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null || (iRobotRelationService = (IRobotRelationService) peekAppRuntime.getRuntimeService(IRobotRelationService.class, "")) == null) {
            return;
        }
        iRobotRelationService.addRobotToTroop("2854196310", this.troopUin, null, new ISetAddRobotToGroupCallback() { // from class: com.tencent.mobileqq.troopmanage.e
            @Override // com.tencent.qqnt.kernel.nativeinterface.ISetAddRobotToGroupCallback
            public final void onResult(int i3, String str) {
                QTroopRobotAdminRoleHelper.m(QTroopRobotAdminRoleHelper.this, needAdmin, i3, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(final QTroopRobotAdminRoleHelper this$0, boolean z16, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("QTroopRobotAdminRoleHelper", 1, "[addRobotToGroup] result = " + i3 + " errorMsg = " + str);
        if (i3 != 0) {
            if (i3 != 10022) {
                return;
            }
            this$0.x(1, R.string.f234507_5);
            return;
        }
        this$0.y();
        if (z16) {
            this$0.k(new Function0<Unit>() { // from class: com.tencent.mobileqq.troopmanage.QTroopRobotAdminRoleHelper$addRobotToGroup$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    QTroopRobotAdminRoleHelper.this.x(2, R.string.f2344379y);
                }
            });
            return;
        }
        this$0.x(2, R.string.f2344379y);
        Function0<Unit> function0 = this$0.targetAction;
        if (function0 != null) {
            function0.invoke();
        }
    }

    private final boolean p() {
        TroopMemberInfo troopMemberInfo = this.robotInfo;
        return (troopMemberInfo != null ? troopMemberInfo.role : null) == MemberRole.ADMIN;
    }

    private final boolean q() {
        TroopMemberInfo troopMemberInfo = this.robotInfo;
        if (troopMemberInfo != null) {
            if ((troopMemberInfo != null ? troopMemberInfo.role : null) != null) {
                if ((troopMemberInfo != null ? troopMemberInfo.role : null) != MemberRole.UNSPECIFIED) {
                    if ((troopMemberInfo != null ? troopMemberInfo.role : null) != MemberRole.STRANGER) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private final void r() {
        String string;
        Context context = this.context;
        String string2 = context.getString(R.string.f234487_3);
        if (q()) {
            string = this.context.getString(R.string.f234477_2);
        } else {
            string = this.context.getString(R.string.f2343979u);
        }
        DialogUtil.createCustomDialog(context, string2, string, this.context.getString(R.string.f2328575o), null, null, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troopmanage.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                QTroopRobotAdminRoleHelper.s(dialogInterface, i3);
            }
        }).show();
    }

    private final void t(final boolean needAdmin) {
        String string;
        Context context = this.context;
        String string2 = context.getString(R.string.f2344079v);
        if (needAdmin) {
            string = this.context.getString(R.string.f2343879t);
        } else {
            string = this.context.getString(R.string.f2344279x);
        }
        DialogUtil.createCustomDialog(context, string2, string, this.context.getString(R.string.f2059456z), this.context.getString(R.string.f2328475n), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troopmanage.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                QTroopRobotAdminRoleHelper.u(QTroopRobotAdminRoleHelper.this, needAdmin, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troopmanage.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                QTroopRobotAdminRoleHelper.v(dialogInterface, i3);
            }
        }).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(QTroopRobotAdminRoleHelper this$0, boolean z16, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.l(z16);
    }

    private final void w() {
        QQProAvatarDrawable qQProAvatarDrawable = new QQProAvatarDrawable();
        qQProAvatarDrawable.q(this.context, 1, "2854196310");
        AuthorizationRequestInfo authorizationRequestInfo = new AuthorizationRequestInfo(qQProAvatarDrawable, this.context.getString(R.string.f234467_1), this.context.getString(R.string.f234497_4), new QQAuthorizationDialog.AuthorizationListener() { // from class: com.tencent.mobileqq.troopmanage.QTroopRobotAdminRoleHelper$showAdminRoleRequestDialog$requestInfo$2
            @Override // com.tencent.mobileqq.qqpermission.authorization.QQAuthorizationDialog.AuthorizationListener
            public void onAllow() {
                QLog.i("QTroopRobotAdminRoleHelper", 1, "[showAdminRoleRequestDialog] [onAllow]");
                final QTroopRobotAdminRoleHelper qTroopRobotAdminRoleHelper = QTroopRobotAdminRoleHelper.this;
                qTroopRobotAdminRoleHelper.k(new Function0<Unit>() { // from class: com.tencent.mobileqq.troopmanage.QTroopRobotAdminRoleHelper$showAdminRoleRequestDialog$requestInfo$2$onAllow$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        QTroopRobotAdminRoleHelper.this.x(2, R.string.f235597c3);
                    }
                });
            }

            @Override // com.tencent.mobileqq.qqpermission.authorization.QQAuthorizationDialog.AuthorizationListener
            public void onRefuse() {
                QLog.i("QTroopRobotAdminRoleHelper", 1, "[showAdminRoleRequestDialog] [onRefuse]");
            }
        });
        authorizationRequestInfo.subHead = this.context.getString(R.string.f2344479z);
        QQAuthorizationDialog.showAuthorizationRequestDialog(this.context, authorizationRequestInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(int iconType, int contentResId) {
        Context context = this.context;
        QQToast.makeText(context, iconType, context.getString(contentResId), 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y() {
        ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberInfo(this.troopUin, "2854196310", true, this.owner, "QTroopRobotAdminRoleHelper", new g() { // from class: com.tencent.mobileqq.troopmanage.a
            @Override // com.tencent.qqnt.troopmemberlist.g
            public final void a(TroopMemberInfo troopMemberInfo) {
                QTroopRobotAdminRoleHelper.z(QTroopRobotAdminRoleHelper.this, troopMemberInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(QTroopRobotAdminRoleHelper this$0, TroopMemberInfo troopMemberInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.robotInfo = troopMemberInfo;
    }

    public final void n(boolean isOwner, boolean needAdminRole, Function0<Unit> targetAction, Function3<? super String, ? super String, ? super Byte, Unit> setAdminSuccessCallback) {
        this.targetAction = targetAction;
        this.setAdminSuccessCallback = setAdminSuccessCallback;
        if (isOwner) {
            if (!q()) {
                t(needAdminRole);
                return;
            }
            if (!p() && needAdminRole) {
                w();
                return;
            } else {
                if (targetAction != null) {
                    targetAction.invoke();
                    return;
                }
                return;
            }
        }
        if (!q() && !needAdminRole) {
            t(false);
            return;
        }
        if (!p() && needAdminRole) {
            r();
        } else if (targetAction != null) {
            targetAction.invoke();
        }
    }

    /* renamed from: o, reason: from getter */
    public final String getTroopUin() {
        return this.troopUin;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(DialogInterface dialogInterface, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(DialogInterface dialogInterface, int i3) {
    }
}
