package bq3;

import android.app.Activity;
import android.content.Intent;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.LpReportInfo_dc04586;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0004H\u0016J\u0018\u0010\f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\u000f"}, d2 = {"Lbq3/b;", "Lbq3/a;", "Landroid/content/Intent;", "intent", "", "b", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "targetIntent", "sign", "", "c", "a", "<init>", "()V", "opensdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class b implements a {
    @Override // bq3.a
    public boolean a(@NotNull Activity activity, @NotNull String sign) {
        BaseQQAppInterface baseQQAppInterface;
        Intent intent;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(sign, "sign");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof BaseQQAppInterface) {
            baseQQAppInterface = (BaseQQAppInterface) peekAppRuntime;
        } else {
            baseQQAppInterface = null;
        }
        if (baseQQAppInterface == null || (intent = activity.getIntent()) == null) {
            return false;
        }
        String stringExtra = intent.getStringExtra(AppConstants.Key.SHARE_REQ_SCHEME_CONTENT);
        if (!Intrinsics.areEqual(sign, stringExtra)) {
            return false;
        }
        QLog.i("JumpActionStashAddFriend", 1, "restoreAction handle sign: " + sign);
        try {
            ax c16 = bi.c(baseQQAppInterface, activity, stringExtra);
            if (c16 != null && Intrinsics.areEqual("gamesdk", c16.f307439d) && Intrinsics.areEqual(LpReportInfo_dc04586.ITEM_ID_BTN_ADD_FRIEND, c16.f307440e)) {
                c16.b();
            }
        } catch (Exception e16) {
            QLog.e("JumpActionStashAddFriend", 1, "restoreHandleAction", e16);
        }
        return true;
    }

    @Override // bq3.a
    @Nullable
    public String b(@NotNull Intent intent) {
        boolean z16;
        boolean startsWith$default;
        Intrinsics.checkNotNullParameter(intent, "intent");
        String stringExtra = intent.getStringExtra(AppConstants.Key.SHARE_REQ_SCHEME_CONTENT);
        if (stringExtra != null && stringExtra.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(stringExtra, "mqqapi://gamesdk/add_friend", false, 2, null);
            if (!startsWith$default) {
                return null;
            }
            QLog.i("JumpActionStashAddFriend", 1, "needSaveJumpAction scheme: " + stringExtra);
            return stringExtra;
        }
        return null;
    }

    @Override // bq3.a
    public boolean c(@NotNull Activity activity, @NotNull Intent targetIntent, @NotNull String sign) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(targetIntent, "targetIntent");
        Intrinsics.checkNotNullParameter(sign, "sign");
        Intent intent = activity.getIntent();
        if (intent == null || !Intrinsics.areEqual(sign, intent.getStringExtra(AppConstants.Key.SHARE_REQ_SCHEME_CONTENT))) {
            return false;
        }
        targetIntent.putExtras(intent);
        return true;
    }
}
