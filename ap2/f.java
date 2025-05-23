package ap2;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.util.ah;
import com.tencent.mobileqq.search.util.p;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.studymode.api.IStudyModeApi;
import kotlin.Metadata;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004R\u0016\u0010\u000b\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lap2/f;", "", "", "a", "", "b", "count", "", "c", "", "Ljava/lang/String;", "thirdAppUUID", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f26688a = new f();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String thirdAppUUID = "";

    f() {
    }

    public final boolean a() {
        g c16;
        if (((IStudyModeApi) QRoute.api(IStudyModeApi.class)).isStudyMode() || (c16 = p.f285069a.c()) == null) {
            return false;
        }
        if (c16.getEnable() && c16.i()) {
            thirdAppUUID = c16.getThirdAppUUID();
            if (!ABTestController.getInstance().getExpEntity(ABTestController.APPID_1505, c16.getExpName()).isExperiment()) {
                QLog.w("SearchThirdAppABTestHelper", 1, "canShowThirdAppGuideNow tab disable");
                return false;
            }
            if (c16.getCheckAppInstalled() && PackageUtil.isAppInstalled(MobileQQ.sMobileQQ.getApplicationContext(), c16.getCom.tencent.ams.dsdk.core.DKEngine.GlobalKey.APP_PACKAGE_NAME java.lang.String())) {
                QLog.w("SearchThirdAppABTestHelper", 1, "canShowThirdAppGuideNow app installed disable");
                return false;
            }
            if (c16.getMaxDisplayCount() > 0 && b() >= c16.getMaxDisplayCount()) {
                QLog.w("SearchThirdAppABTestHelper", 1, "canShowThirdAppGuideNow display count disable");
                return false;
            }
            QLog.i("SearchThirdAppABTestHelper", 1, "canShowThirdAppGuideNow enable, thirdAppUUID=" + thirdAppUUID);
            return true;
        }
        QLog.w("SearchThirdAppABTestHelper", 1, "canShowThirdAppGuideNow qqmc disable");
        return false;
    }

    public final int b() {
        return ah.f284994a.d("key_third_app_displayed_count_" + thirdAppUUID, 0);
    }

    public final void c(int count) {
        ah.f284994a.m("key_third_app_displayed_count_" + thirdAppUUID, count);
    }
}
