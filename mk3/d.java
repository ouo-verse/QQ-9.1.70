package mk3;

import android.content.Context;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.vaswebviewplugin.IndividuationPlugin;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000b2\u00020\u0001:\u0001\fB\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\r"}, d2 = {"Lmk3/d;", "Lcom/tencent/mobileqq/utils/ax;", "", UserInfo.SEX_FEMALE, "b", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "app", "Landroid/content/Context;", "context", "<init>", "(Lcom/tencent/common/app/business/BaseQQAppInterface;Landroid/content/Context;)V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class d extends ax {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(BaseQQAppInterface app, Context context) {
        super(app, context);
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final boolean F() {
        return Intrinsics.areEqual(this.f307440e, "enterAvatarScene") || Intrinsics.areEqual(this.f307440e, IndividuationPlugin.Method_OpenPage) || Intrinsics.areEqual(this.f307440e, "toast") || Intrinsics.areEqual(this.f307440e, "thirdJump");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0188, code lost:
    
        r0 = (com.tencent.mobileqq.vas.api.IVasSquareApi) com.tencent.mobileqq.qroute.QRoute.api(com.tencent.mobileqq.vas.api.IVasSquareApi.class);
        r1 = r10.f307437b;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, "context");
        r2 = r10.f307438c;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, "source");
        r3 = r10.f307440e;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, "action_name");
        r4 = r10.f307441f;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, "attrs");
        r0.handleSquareScheme(r1, r2, r3, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x01aa, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0044, code lost:
    
        if (r0.equals("squareArkInvite") == false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00c9, code lost:
    
        if (r0.equals("squarePersonalCenter") == false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00d4, code lost:
    
        if (r0.equals("enterLibrary") == false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x017b, code lost:
    
        if (r0.equals("enterChatLand") == false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0185, code lost:
    
        if (r0.equals("enterThemeSpace") == false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0039, code lost:
    
        if (r0.equals("enterSocialSquare") == false) goto L70;
     */
    @Override // com.tencent.mobileqq.utils.ax
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean b() {
        if (F()) {
            ((cl3.b) vb3.a.f441346a.a(cl3.b.class)).j();
        }
        String str = this.f307440e;
        if (str != null) {
            switch (str.hashCode()) {
                case -2113014347:
                    break;
                case -1600241573:
                    break;
                case -1282163872:
                    if (str.equals("faceAd")) {
                        ISchemeApi iSchemeApi = (ISchemeApi) QRoute.api(ISchemeApi.class);
                        Context context = this.f307437b;
                        Intrinsics.checkNotNullExpressionValue(context, "context");
                        HashMap<String, String> attrs = this.f307441f;
                        Intrinsics.checkNotNullExpressionValue(attrs, "attrs");
                        iSchemeApi.handleFaceAdScheme(context, attrs);
                        return true;
                    }
                    break;
                case -585905233:
                    if (str.equals("thirdAuth")) {
                        ISchemeApi iSchemeApi2 = (ISchemeApi) QRoute.api(ISchemeApi.class);
                        Context context2 = this.f307437b;
                        Intrinsics.checkNotNullExpressionValue(context2, "context");
                        HashMap<String, String> attrs2 = this.f307441f;
                        Intrinsics.checkNotNullExpressionValue(attrs2, "attrs");
                        iSchemeApi2.handleThirdAuthCallback(context2, attrs2);
                        return true;
                    }
                    break;
                case -585637323:
                    if (str.equals("thirdJump")) {
                        try {
                            IZPlanApi iZPlanApi = (IZPlanApi) QRoute.api(IZPlanApi.class);
                            Context context3 = this.f307437b;
                            Intrinsics.checkNotNullExpressionValue(context3, "context");
                            HashMap<String, String> attrs3 = this.f307441f;
                            Intrinsics.checkNotNullExpressionValue(attrs3, "attrs");
                            iZPlanApi.handleZplanThirdScheme(context3, attrs3);
                            return true;
                        } catch (Exception unused) {
                            return false;
                        }
                    }
                    break;
                case -504772615:
                    if (str.equals(IndividuationPlugin.Method_OpenPage)) {
                        try {
                            IZPlanApi iZPlanApi2 = (IZPlanApi) QRoute.api(IZPlanApi.class);
                            Context context4 = this.f307437b;
                            Intrinsics.checkNotNullExpressionValue(context4, "context");
                            String source = this.f307438c;
                            Intrinsics.checkNotNullExpressionValue(source, "source");
                            HashMap<String, String> attrs4 = this.f307441f;
                            Intrinsics.checkNotNullExpressionValue(attrs4, "attrs");
                            return iZPlanApi2.handleZPlanOpenPageScheme(context4, source, attrs4);
                        } catch (Exception e16) {
                            QLog.e("ZPlanJumpAction", 1, "doAction openPage error: " + e16.getMessage());
                            return false;
                        }
                    }
                    break;
                case -485961021:
                    break;
                case -384131790:
                    break;
                case -192429893:
                    if (str.equals("enterAvatarScene")) {
                        try {
                            IZPlanApi iZPlanApi3 = (IZPlanApi) QRoute.api(IZPlanApi.class);
                            Context context5 = this.f307437b;
                            Intrinsics.checkNotNullExpressionValue(context5, "context");
                            String source2 = this.f307438c;
                            Intrinsics.checkNotNullExpressionValue(source2, "source");
                            HashMap<String, String> attrs5 = this.f307441f;
                            Intrinsics.checkNotNullExpressionValue(attrs5, "attrs");
                            return iZPlanApi3.handleZPlanEnterAvatarSceneScheme(context5, source2, attrs5);
                        } catch (Exception e17) {
                            QLog.e("ZPlanJumpAction", 1, "doAction enterAvatarScene error: " + e17.getMessage());
                            return false;
                        }
                    }
                    break;
                case 110532135:
                    if (str.equals("toast")) {
                        try {
                            IZPlanApi iZPlanApi4 = (IZPlanApi) QRoute.api(IZPlanApi.class);
                            Context context6 = this.f307437b;
                            Intrinsics.checkNotNullExpressionValue(context6, "context");
                            HashMap<String, String> attrs6 = this.f307441f;
                            Intrinsics.checkNotNullExpressionValue(attrs6, "attrs");
                            iZPlanApi4.handleToast(context6, attrs6);
                            return true;
                        } catch (Exception e18) {
                            QLog.e("ZPlanJumpAction", 1, "doAction toast error: " + e18.getMessage());
                            return false;
                        }
                    }
                    break;
                case 842113382:
                    break;
                case 1639329250:
                    break;
            }
        }
        return false;
    }
}
