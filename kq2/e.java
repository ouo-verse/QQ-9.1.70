package kq2;

import android.content.Context;
import android.content.Intent;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.qqsec.api.ISafeBlockApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import sq2.l;
import sq2.n;
import sq2.o;
import sq2.p;
import sq2.r;
import sq2.s;
import sq2.t;
import sq2.u;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001c\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0001\u0018\u0001`\u0005H\u0016J\u0006\u0010\b\u001a\u00020\u0007J\"\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0011"}, d2 = {"Lkq2/e;", "Ljq2/c;", "", "e", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "c", "", tl.h.F, "title", "Landroid/content/Context;", "context", "id", "", "f", "<init>", "()V", "qq_setting_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class e extends jq2.c {
    @Override // jq2.c
    public ArrayList<jq2.c> c() {
        ArrayList<jq2.c> arrayList = new ArrayList<>();
        arrayList.add(new s());
        arrayList.add(new l());
        arrayList.add(new o());
        if (h()) {
            arrayList.add(new n());
        }
        arrayList.add(new p());
        arrayList.add(new u());
        arrayList.add(new sq2.h());
        if (((ISafeBlockApi) QRoute.api(ISafeBlockApi.class)).isNotDisturbTimeConfigOpen()) {
            arrayList.add(new sq2.i());
        }
        arrayList.add(new sq2.k());
        arrayList.add(new sq2.b());
        arrayList.add(new t());
        arrayList.add(new r());
        return arrayList;
    }

    @Override // jq2.c
    /* renamed from: e */
    public String getDetailTitle() {
        return "\u6d88\u606f\u901a\u77e5";
    }

    @Override // jq2.c
    public void f(String title, Context context, String id5) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent();
        intent.putExtra("setting_search_title", title);
        ((ISafeBlockApi) QRoute.api(ISafeBlockApi.class)).startPushSettingFragmentPage(context, intent, 2004);
        QLog.d("AccountSafety", 2, "startRouteToPage ");
    }

    public final boolean h() {
        boolean areNotificationsEnabled = QQNotificationManager.getInstance().areNotificationsEnabled(BaseApplication.getContext());
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime();
        Intrinsics.checkNotNull(waitAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        return areNotificationsEnabled && SettingCloneUtil.readValue((Context) BaseApplication.getContext(), ((QQAppInterface) waitAppRuntime).getCurrentUin(), (String) null, AppConstants.NEW_MSG_NOTIFICATION_KEY, true);
    }
}
