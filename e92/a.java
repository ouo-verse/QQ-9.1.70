package e92;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.minikuikly.MiniKuiklyBaseFragment;
import com.tencent.mobileqq.minikuikly.MiniKuiklyTransparentFragment;
import com.tencent.mobileqq.minikuikly.MiniKuiklyWebViewFragment;
import com.tencent.mobileqq.vas.VasPerfReportUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.util.URLUtil;
import cooperation.qzone.QzoneIPCModule;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.Constants;
import mqq.util.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 =2\u00020\u0001:\u0001\u0006B\u000f\u0012\u0006\u0010B\u001a\u000200\u00a2\u0006\u0004\bC\u0010DJ\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0002J\u0012\u0010\r\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u000e\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0010\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0002J\n\u0010\u0012\u001a\u0004\u0018\u00010\bH\u0002J:\u0010\u0016\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u0005H\u0016J\b\u0010\u0018\u001a\u00020\u0005H\u0016J\b\u0010\u0019\u001a\u00020\u0005H\u0016J\b\u0010\u001a\u001a\u00020\u0005H\u0016J\b\u0010\u001b\u001a\u00020\u0005H\u0016J\b\u0010\u001c\u001a\u00020\u0005H\u0016J\"\u0010\"\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001d2\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J0\u0010#\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010&\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010$H\u0016J8\u0010)\u001a\u00020\u00052\u0006\u0010(\u001a\u00020'2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J8\u0010*\u001a\u00020\u00052\u0006\u0010(\u001a\u00020'2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J8\u0010+\u001a\u00020\u00052\u0006\u0010(\u001a\u00020'2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010-\u001a\u00020\u00052\b\u0010,\u001a\u0004\u0018\u00010\u0002H\u0016J\u0006\u0010.\u001a\u00020\u0005R\u001a\u00102\u001a\b\u0012\u0004\u0012\u0002000/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u00101R\u0014\u00105\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u00104R\u0018\u00108\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u00107R\u0018\u0010;\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010?\u001a\u0004\u0018\u00010<8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b=\u0010>R\u0014\u0010A\u001a\u00020\u00028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b9\u0010@\u00a8\u0006E"}, d2 = {"Le92/a;", "Lg92/a;", "", "extInfo", "firstPath", "", "a", "c", "Landroidx/fragment/app/Fragment;", "fragment", "l", "k", "extendData", h.F, "g", "", "i", "j", "f", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "appId", "onCreate", "onResume", "onStart", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, DKHippyEvent.EVENT_STOP, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onBackPressed", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "onNewIntent", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "initView", VasPerfReportUtils.WHILE_UPDATE_ITEM, "handleRestart", "url", "openUrl", "b", "Lmqq/util/WeakReference;", "Landroid/app/Activity;", "Lmqq/util/WeakReference;", "activityRef", "Ljava/util/concurrent/atomic/AtomicInteger;", "Ljava/util/concurrent/atomic/AtomicInteger;", "fragmentIndex", "Lcom/tencent/mobileqq/minikuikly/MiniKuiklyBaseFragment;", "Lcom/tencent/mobileqq/minikuikly/MiniKuiklyBaseFragment;", "kuiklyFragment", "d", "Ljava/lang/String;", "miniAppId", "Landroidx/fragment/app/FragmentManager;", "e", "()Landroidx/fragment/app/FragmentManager;", "supportFragmentManager", "()Ljava/lang/String;", "fragmentTag", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "<init>", "(Landroid/app/Activity;)V", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a implements g92.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final WeakReference<Activity> activityRef;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final AtomicInteger fragmentIndex;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private MiniKuiklyBaseFragment kuiklyFragment;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String miniAppId;

    public a(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.fragmentIndex = new AtomicInteger(0);
        this.activityRef = new WeakReference<>(activity);
    }

    private final void a(String extInfo, String firstPath) {
        FragmentTransaction beginTransaction;
        QLog.d("MiniKuiklyController", 1, "addKuiklyFragment");
        if (extInfo == null || extInfo.length() == 0) {
            QLog.e("MiniKuiklyController", 1, "addKuiklyFragment extInfo null");
            return;
        }
        this.kuiklyFragment = new MiniKuiklyBaseFragment();
        Intent intent = new Intent();
        intent.putExtra("extra_open_kuikly_info", extInfo);
        intent.putExtra("mini_first_path", firstPath);
        MiniKuiklyBaseFragment miniKuiklyBaseFragment = this.kuiklyFragment;
        Intrinsics.checkNotNull(miniKuiklyBaseFragment);
        miniKuiklyBaseFragment.setArguments(intent.getExtras());
        FragmentManager e16 = e();
        if (e16 == null || (beginTransaction = e16.beginTransaction()) == null) {
            return;
        }
        MiniKuiklyBaseFragment miniKuiklyBaseFragment2 = this.kuiklyFragment;
        Intrinsics.checkNotNull(miniKuiklyBaseFragment2);
        FragmentTransaction replace = beginTransaction.replace(R.id.ckj, miniKuiklyBaseFragment2);
        if (replace != null) {
            replace.commitAllowingStateLoss();
        }
    }

    private final String d() {
        return "MiniKuikly-" + this.fragmentIndex.getAndIncrement();
    }

    private final FragmentManager e() {
        QBaseActivity qBaseActivity = (QBaseActivity) this.activityRef.get();
        if (qBaseActivity == null) {
            return null;
        }
        return qBaseActivity.getSupportFragmentManager();
    }

    private final Fragment f() {
        Fragment findFragmentByTag;
        if (e() == null) {
            return null;
        }
        FragmentManager e16 = e();
        Intrinsics.checkNotNull(e16);
        int backStackEntryCount = e16.getBackStackEntryCount();
        if (backStackEntryCount <= 0) {
            findFragmentByTag = this.kuiklyFragment;
        } else {
            FragmentManager e17 = e();
            Intrinsics.checkNotNull(e17);
            FragmentManager.BackStackEntry backStackEntryAt = e17.getBackStackEntryAt(backStackEntryCount - 1);
            Intrinsics.checkNotNullExpressionValue(backStackEntryAt, "supportFragmentManager!!\u2026ckStackEntryAt(count - 1)");
            FragmentManager e18 = e();
            Intrinsics.checkNotNull(e18);
            findFragmentByTag = e18.findFragmentByTag(backStackEntryAt.getName());
        }
        QLog.i("MiniKuiklyController", 2, "getTopFragment: count=" + backStackEntryCount + ", fragment=" + findFragmentByTag);
        return findFragmentByTag;
    }

    private final String j(String extendData) {
        try {
            return new JSONObject(extendData).optString("webUrl");
        } catch (JSONException unused) {
            QLog.e("MiniKuiklyController", 1, "parseWebUrl: webUrlJson parse failed. extendData=" + extendData);
            return null;
        }
    }

    private final void k() {
        QLog.i("MiniKuiklyController", 1, "[popOrBackFragment]");
        if (e() == null) {
            return;
        }
        FragmentManager e16 = e();
        Intrinsics.checkNotNull(e16);
        int backStackEntryCount = e16.getBackStackEntryCount();
        QLog.i("MiniKuiklyController", 1, "popKuiklyFragment: fragment backStackCount= " + backStackEntryCount);
        if (backStackEntryCount > 0) {
            FragmentManager e17 = e();
            Intrinsics.checkNotNull(e17);
            e17.popBackStack();
        } else {
            QBaseActivity qBaseActivity = (QBaseActivity) this.activityRef.get();
            if (qBaseActivity == null || qBaseActivity.moveTaskToBack(true)) {
                return;
            }
            qBaseActivity.finish();
        }
    }

    private final void l(Fragment fragment) {
        if (e() == null) {
            return;
        }
        String d16 = d();
        FragmentManager e16 = e();
        Intrinsics.checkNotNull(e16);
        e16.beginTransaction().setCustomAnimations(R.anim.f154476ii, 0, 0, R.anim.f154480ae).add(R.id.ckj, fragment, d16).addToBackStack(d16).commitAllowingStateLoss();
    }

    public final void b() {
        if (e() == null) {
            return;
        }
        FragmentManager e16 = e();
        Intrinsics.checkNotNull(e16);
        int backStackEntryCount = e16.getBackStackEntryCount();
        for (int i3 = 0; i3 < backStackEntryCount; i3++) {
            FragmentManager e17 = e();
            Intrinsics.checkNotNull(e17);
            e17.popBackStack();
        }
    }

    @Override // g92.a
    public void handleRestart(ViewGroup container, String appId, String extInfo, String extendData, String firstPath) {
        Intrinsics.checkNotNullParameter(container, "container");
        QLog.d("MiniKuiklyController", 1, "handleRestart");
        b();
        c();
        a(extInfo, firstPath);
    }

    @Override // g92.a
    public void initView(ViewGroup container, String appId, String extInfo, String extendData, String firstPath) {
        Intrinsics.checkNotNullParameter(container, "container");
        QLog.d("MiniKuiklyController", 1, "initView");
        a(extInfo, firstPath);
    }

    @Override // g92.a
    public void onBackPressed() {
        k();
    }

    @Override // g92.a
    public void onCreate(Bundle savedInstanceState, String appId, String extInfo, String extendData, String firstPath) {
        this.miniAppId = appId;
    }

    @Override // g92.a
    public void onNewIntent(String appId, String extInfo, String extendData, String firstPath) {
        h(extendData);
        g(firstPath);
    }

    @Override // g92.a
    public void updateView(ViewGroup container, String appId, String extInfo, String extendData, String firstPath) {
        Intrinsics.checkNotNullParameter(container, "container");
        QLog.d("MiniKuiklyController", 1, VasPerfReportUtils.WHILE_UPDATE_ITEM);
        b();
        c();
        a(extInfo, firstPath);
    }

    private final void c() {
        FragmentManager e16;
        FragmentTransaction beginTransaction;
        QLog.d("MiniKuiklyController", 1, "destroyKuiklyView");
        if (this.kuiklyFragment == null || (e16 = e()) == null || (beginTransaction = e16.beginTransaction()) == null) {
            return;
        }
        MiniKuiklyBaseFragment miniKuiklyBaseFragment = this.kuiklyFragment;
        Intrinsics.checkNotNull(miniKuiklyBaseFragment);
        FragmentTransaction remove = beginTransaction.remove(miniKuiklyBaseFragment);
        if (remove != null) {
            remove.commitAllowingStateLoss();
        }
    }

    private final void g(String firstPath) {
        if (firstPath == null || firstPath.length() == 0) {
            QLog.i("MiniKuiklyController", 2, "handleQueryOnNewIntent pagePath null");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("MiniKuiklyController", 2, "handleQueryOnNewIntent pagePath:" + firstPath);
        }
        Fragment f16 = f();
        if (f16 instanceof MiniKuiklyBaseFragment) {
            ((MiniKuiklyBaseFragment) f16).sh(firstPath);
        }
    }

    private final boolean i(String extendData) {
        boolean contains$default;
        if (extendData == null || extendData.length() == 0) {
            return false;
        }
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) extendData, (CharSequence) "webUrl", false, 2, (Object) null);
        return contains$default;
    }

    private final void h(String extendData) {
        if (extendData == null || extendData.length() == 0) {
            QLog.i("MiniKuiklyController", 1, "handleSchemeOnNewIntent scheme null");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("MiniKuiklyController", 2, "handleSchemeOnNewIntent extendData:" + extendData);
        }
        if (i(extendData)) {
            String j3 = j(extendData);
            if (j3 == null || j3.length() == 0) {
                return;
            }
            openUrl(j3);
            return;
        }
        Fragment f16 = f();
        if (f16 instanceof MiniKuiklyBaseFragment) {
            ((MiniKuiklyBaseFragment) f16).th(extendData);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006d  */
    @Override // g92.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void openUrl(String url) {
        boolean startsWith$default;
        boolean z16;
        boolean startsWith$default2;
        if (url == null || url.length() == 0) {
            return;
        }
        String lowerCase = url.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(lowerCase, "http://", false, 2, null);
        if (!startsWith$default) {
            startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(lowerCase, "https://", false, 2, null);
            if (!startsWith$default2) {
                z16 = false;
                if (!z16) {
                    String newUrl = URLUtil.addParameterWithoutEncode(url, "isInMiniApp", "1");
                    if (QLog.isColorLevel()) {
                        QLog.i("MiniKuiklyController", 2, "openUrl: url=" + newUrl);
                    }
                    MiniKuiklyWebViewFragment.Companion companion = MiniKuiklyWebViewFragment.INSTANCE;
                    Intrinsics.checkNotNullExpressionValue(newUrl, "newUrl");
                    l(companion.a(newUrl));
                    return;
                }
                Activity activity = this.activityRef.get();
                if (activity == null) {
                    return;
                }
                String str = this.miniAppId;
                if (!(str == null || str.length() == 0)) {
                    MiniKuiklyTransparentFragment.Companion companion2 = MiniKuiklyTransparentFragment.INSTANCE;
                    String str2 = this.miniAppId;
                    Intrinsics.checkNotNull(str2);
                    Intent a16 = companion2.a(url, str2);
                    a16.putExtra("public_fragment_window_feature", 1);
                    QPublicFragmentActivity.b.b(activity, a16, QPublicTransFragmentActivity.class, MiniKuiklyTransparentFragment.class);
                    return;
                }
                QLog.w("MiniKuiklyController", 1, "openUrl miniAppId null");
                return;
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    @Override // g92.a
    public void onDestroy() {
    }

    @Override // g92.a
    public void onPause() {
    }

    @Override // g92.a
    public void onResume() {
    }

    @Override // g92.a
    public void onStart() {
    }

    @Override // g92.a
    public void onStop() {
    }

    @Override // g92.a
    public void onConfigurationChanged(Configuration newConfig) {
    }

    @Override // g92.a
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
    }
}
