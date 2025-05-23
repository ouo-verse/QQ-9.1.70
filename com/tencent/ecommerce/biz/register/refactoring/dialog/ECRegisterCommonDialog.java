package com.tencent.ecommerce.biz.register.refactoring.dialog;

import android.content.Context;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.base.ui.g;
import com.tencent.ecommerce.base.ui.i;
import com.tencent.ecommerce.biz.router.ECScheme;
import com.tencent.ecommerce.biz.util.ECThreadUtilKt;
import com.tencent.ecommerce.repo.register.ECRegisterRespStatus;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/ecommerce/biz/register/refactoring/dialog/ECRegisterCommonDialog;", "", "Landroid/content/Context;", "context", "", "E", "D", "w", HippyTKDListViewAdapter.X, UserInfo.SEX_FEMALE, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "B", "r", BdhLogUtil.LogTag.Tag_Conn, "Lorg/json/JSONObject;", "toastInfo", "v", "y", "t", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "u", ReportConstant.COSTREPORT_PREFIX, "", "status", "p", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECRegisterCommonDialog {

    /* renamed from: a */
    public static final ECRegisterCommonDialog f104005a = new ECRegisterCommonDialog();

    ECRegisterCommonDialog() {
    }

    public final void A(Context context) {
        final g gVar = new g(context);
        gVar.setTitle(context.getResources().getString(R.string.wus));
        gVar.Y(context.getResources().getString(R.string.wrk));
        gVar.b0(context.getResources().getString(R.string.wi6));
        gVar.a0(new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.register.refactoring.dialog.ECRegisterCommonDialog$toastForUnderAge$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                g.this.dismiss();
            }
        });
        gVar.f0("");
        gVar.e0(null);
        gVar.show();
    }

    public final void B(Context context) {
        final g gVar = new g(context);
        gVar.setTitle(context.getResources().getString(R.string.wr5));
        gVar.Y(context.getResources().getString(R.string.wrl));
        gVar.b0(context.getResources().getString(R.string.wi6));
        gVar.a0(new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.register.refactoring.dialog.ECRegisterCommonDialog$toastForVerificationError$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                g.this.dismiss();
            }
        });
        gVar.f0("");
        gVar.e0(null);
        gVar.show();
    }

    public final void C(Context context) {
        final g gVar = new g(context);
        gVar.setTitle(context.getResources().getString(R.string.wr6));
        gVar.Y(context.getResources().getString(R.string.wrb));
        gVar.b0(context.getResources().getString(R.string.wgw));
        gVar.a0(new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.register.refactoring.dialog.ECRegisterCommonDialog$toastForWalletAccountErr$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                g.this.dismiss();
            }
        });
        gVar.f0(context.getResources().getString(R.string.f169635wr4));
        gVar.e0(new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.register.refactoring.dialog.ECRegisterCommonDialog$toastForWalletAccountErr$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                ECScheme.g("https://support.qq.com/products/394271", null, 2, null);
                g.this.dismiss();
            }
        });
        gVar.show();
    }

    public final void D(Context context) {
        final g gVar = new g(context);
        gVar.setTitle(context.getResources().getString(R.string.wr5));
        gVar.Y(context.getResources().getString(R.string.wrn));
        gVar.b0(context.getResources().getString(R.string.wgw));
        gVar.a0(new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.register.refactoring.dialog.ECRegisterCommonDialog$toastForWalletInconsistent$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                g.this.dismiss();
            }
        });
        gVar.f0(context.getResources().getString(R.string.f169635wr4));
        gVar.e0(new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.register.refactoring.dialog.ECRegisterCommonDialog$toastForWalletInconsistent$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                ECScheme.g("https://support.qq.com/products/394271", null, 2, null);
                g.this.dismiss();
            }
        });
        gVar.show();
    }

    public final void E(Context context) {
        i.f(i.f101155b, context.getResources().getString(R.string.wrm), null, 0, 6, null);
    }

    public final void F(Context context) {
        final g gVar = new g(context);
        gVar.setTitle(context.getResources().getString(R.string.wr6));
        gVar.Y(context.getResources().getString(R.string.wrb));
        gVar.b0(context.getResources().getString(R.string.wgw));
        gVar.a0(new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.register.refactoring.dialog.ECRegisterCommonDialog$toastForWindowBeenToken$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                g.this.dismiss();
            }
        });
        gVar.f0(context.getResources().getString(R.string.f169635wr4));
        gVar.e0(new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.register.refactoring.dialog.ECRegisterCommonDialog$toastForWindowBeenToken$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                ECScheme.g("https://support.qq.com/products/394271", null, 2, null);
                g.this.dismiss();
            }
        });
        gVar.show();
    }

    public final void r(Context context) {
        final g gVar = new g(context);
        gVar.setTitle(context.getResources().getString(R.string.wr6));
        gVar.Y(context.getResources().getString(R.string.wra));
        gVar.b0(context.getResources().getString(R.string.wgw));
        gVar.a0(new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.register.refactoring.dialog.ECRegisterCommonDialog$toastForHasOpenAccount$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                g.this.dismiss();
            }
        });
        gVar.f0(context.getResources().getString(R.string.f169635wr4));
        gVar.e0(new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.register.refactoring.dialog.ECRegisterCommonDialog$toastForHasOpenAccount$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                ECScheme.g("https://support.qq.com/products/394271", null, 2, null);
                g.this.dismiss();
            }
        });
        gVar.show();
    }

    public final void s(Context context) {
        final g gVar = new g(context);
        gVar.setTitle(context.getResources().getString(R.string.wr5));
        gVar.Y(context.getResources().getString(R.string.wrc));
        gVar.b0(context.getResources().getString(R.string.wi6));
        gVar.a0(new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.register.refactoring.dialog.ECRegisterCommonDialog$toastForIDNumInvalidate$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                g.this.dismiss();
            }
        });
        gVar.f0("");
        gVar.e0(null);
        gVar.show();
    }

    public final void t(Context context) {
        i.f(i.f101155b, context.getResources().getString(R.string.wrd), null, 0, 6, null);
    }

    public final void u(Context context) {
        i.f(i.f101155b, context.getResources().getString(R.string.wre), null, 0, 6, null);
    }

    public final void v(Context context, JSONObject toastInfo) {
        String optString;
        String str = "";
        if (toastInfo != null && (optString = toastInfo.optString("originPhoneNum", "")) != null) {
            str = optString;
        }
        final g gVar = new g(context);
        gVar.setTitle(context.getResources().getString(R.string.weq));
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(context.getResources().getString(R.string.wrg), Arrays.copyOf(new Object[]{str}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        gVar.Y(format);
        gVar.b0(context.getResources().getString(R.string.wgw));
        gVar.a0(new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.register.refactoring.dialog.ECRegisterCommonDialog$toastForPhoneNumExist$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                g.this.dismiss();
            }
        });
        gVar.f0(context.getResources().getString(R.string.wil));
        gVar.e0(new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.register.refactoring.dialog.ECRegisterCommonDialog$toastForPhoneNumExist$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                ECScheme.g("https://support.qq.com/products/394271", null, 2, null);
                g.this.dismiss();
            }
        });
        gVar.show();
    }

    public final void w(Context context) {
        final g gVar = new g(context);
        gVar.setTitle(context.getResources().getString(R.string.win));
        gVar.Y(context.getResources().getString(R.string.wrf));
        gVar.b0(context.getResources().getString(R.string.wgw));
        gVar.a0(new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.register.refactoring.dialog.ECRegisterCommonDialog$toastForPhoneNumOccupy$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                g.this.dismiss();
            }
        });
        gVar.f0(context.getResources().getString(R.string.f169635wr4));
        gVar.e0(new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.register.refactoring.dialog.ECRegisterCommonDialog$toastForPhoneNumOccupy$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                ECScheme.g("https://support.qq.com/products/394271", null, 2, null);
                g.this.dismiss();
            }
        });
        gVar.show();
    }

    public final void x(Context context) {
        final g gVar = new g(context);
        gVar.setTitle(context.getResources().getString(R.string.wr5));
        gVar.Y(context.getResources().getString(R.string.wp9));
        gVar.b0(context.getResources().getString(R.string.wi6));
        gVar.a0(new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.register.refactoring.dialog.ECRegisterCommonDialog$toastForSmsCodeError$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                g.this.dismiss();
            }
        });
        gVar.f0("");
        gVar.e0(null);
        gVar.show();
    }

    public final void y(Context context) {
        i.f(i.f101155b, context.getResources().getString(R.string.wri), null, 0, 6, null);
    }

    public final void z(Context context) {
        i.f(i.f101155b, context.getResources().getString(R.string.wrj), null, 0, 6, null);
    }

    public final void p(final int status, final Context context, final JSONObject toastInfo) {
        ECThreadUtilKt.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.register.refactoring.dialog.ECRegisterCommonDialog$showDialogWithStatusCode$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                int i3 = status;
                if (i3 == ECRegisterRespStatus.USER_WALLET_NO_IDENTITY_VERIFICATION.status) {
                    ECRegisterCommonDialog.f104005a.E(context);
                    return;
                }
                if (i3 == ECRegisterRespStatus.USER_WALLET_IDENTITY_VERIFICATION_INCONSISTENT.status) {
                    ECRegisterCommonDialog.f104005a.D(context);
                    return;
                }
                if (i3 == ECRegisterRespStatus.PHONE_NUMBER_HAS_BEEN_TOKEN.status) {
                    ECRegisterCommonDialog.f104005a.w(context);
                    return;
                }
                if (i3 == ECRegisterRespStatus.PHONE_SMSCODE_ERR.status) {
                    ECRegisterCommonDialog.f104005a.x(context);
                    return;
                }
                if (i3 == ECRegisterRespStatus.WINDOW_ID_HAS_BEEN_TOKEN.status) {
                    ECRegisterCommonDialog.f104005a.F(context);
                    return;
                }
                if (i3 == ECRegisterRespStatus.SYSTEM_BUSY_AND_TRY_AGAIN_LATER.status) {
                    ECRegisterCommonDialog.f104005a.z(context);
                    return;
                }
                if (i3 == ECRegisterRespStatus.IDENTITY_VERIFICATION_INFO_ERR.status) {
                    ECRegisterCommonDialog.f104005a.B(context);
                    return;
                }
                if (i3 == ECRegisterRespStatus.WALLET_ACCOUNT_ABNORMAL.status) {
                    ECRegisterCommonDialog.f104005a.C(context);
                    return;
                }
                if (i3 == ECRegisterRespStatus.IDENTITY_HAS_OPENED_ACCOUNT.status) {
                    ECRegisterCommonDialog.f104005a.r(context);
                    return;
                }
                if (i3 == ECRegisterRespStatus.PHONE_SMSCODE_SESSION_EXPIRED.status) {
                    ECRegisterCommonDialog.f104005a.y(context);
                    return;
                }
                if (i3 == ECRegisterRespStatus.LOGIN_STATUS_EXPIRED.status) {
                    ECRegisterCommonDialog.f104005a.t(context);
                    return;
                }
                if (i3 == ECRegisterRespStatus.PHONE_NUMBER_EXIST.status) {
                    ECRegisterCommonDialog.f104005a.v(context, toastInfo);
                    return;
                }
                if (i3 == ECRegisterRespStatus.SYSTEM_REGISTER_ERR.status) {
                    ECRegisterCommonDialog.f104005a.F(context);
                    return;
                }
                if (i3 == ECRegisterRespStatus.REGISTER_ERROR_CODE_UNDER_AGE.status) {
                    ECRegisterCommonDialog.f104005a.A(context);
                } else if (i3 == ECRegisterRespStatus.REGISTER_ERROR_CODE_NOT_MEET_CONDITION.status) {
                    ECRegisterCommonDialog.f104005a.u(context);
                } else if (i3 == ECRegisterRespStatus.REGISTER_ERROR_CODE_ID_INVALID.status) {
                    ECRegisterCommonDialog.f104005a.s(context);
                }
            }
        });
    }

    public static /* synthetic */ void q(ECRegisterCommonDialog eCRegisterCommonDialog, int i3, Context context, JSONObject jSONObject, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            jSONObject = new JSONObject();
        }
        eCRegisterCommonDialog.p(i3, context, jSONObject);
    }
}
