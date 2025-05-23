package com.tencent.mobileqq.emotionintegrate.media;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.QQWinkConfig;
import com.tencent.mobileqq.wink.QQWinkPage;
import com.tencent.mobileqq.wink.api.IQQWinkLauncher;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\f\u0010\t\u001a\u00020\u0006*\u00020\bH\u0002J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/emotionintegrate/media/a;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "requestCode", "", "c", "Landroid/os/Bundle;", "b", "d", "<init>", "()V", "webview_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f205250a = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\t\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/emotionintegrate/media/a$a", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "", "", "permissions", "", ForwardMiniChooseFriendOption.RESULT_LIST, "onDenied", "webview_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.emotionintegrate.media.a$a, reason: collision with other inner class name */
    /* loaded from: classes33.dex */
    public static final class C7506a extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f205251a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f205252b;

        C7506a(Activity activity, int i3) {
            this.f205251a = activity;
            this.f205252b = i3;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            a.f205250a.d(this.f205251a, this.f205252b);
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> permissions, List<Integer> results) {
            QLog.e("QQEmotionMediaLauncher", 1, "launchQQWinkHomeForResult permission denied.");
        }
    }

    a() {
    }

    private final void b(Bundle bundle) {
        bundle.putString("app_key", "qqaiemt");
        bundle.putString(QQWinkConstants.ENTRY_BUSINESS_NAME, "emoticon");
        bundle.putString("wink_output_route", QQEmoticonWinkOutputRouter.ROUTE_PATH);
        bundle.putLong("wink_output_point", 8L);
    }

    @JvmStatic
    public static final void c(Activity activity, int requestCode) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (activity.checkSelfPermission(QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE) == 0 && activity.checkSelfPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) == 0) {
            f205250a.d(activity, requestCode);
            return;
        }
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(activity, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_WEBVIEW, QQPermissionConstants.Business.SCENE.WEBVIEW_MEDIA));
        if (qQPermission != null) {
            qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new C7506a(activity, requestCode));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(Activity activity, int requestCode) {
        List listOf;
        Bundle bundle = new Bundle();
        f205250a.b(bundle);
        bundle.putString(QQWinkConstants.CAPTURE_ABILITY, "photo");
        bundle.putBoolean(QQWinkConstants.HOME_SHOW_CAPTURE_TAB, true);
        bundle.putBoolean(QQWinkConstants.EDITOR_ENABLE_MUSIC, false);
        bundle.putBoolean(QQWinkConstants.EDITOR_ENABLE_SWITCH_EDIT_MODE, false);
        bundle.putInt(QQWinkConstants.EDITOR_DEFAULT_EDIT_MODE, 1);
        bundle.putInt(QQWinkConstants.ACTIVITY_REQUEST_CODE, requestCode);
        QQWinkPage qQWinkPage = QQWinkPage.Capture;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(qQWinkPage);
        ((IQQWinkLauncher) QRoute.api(IQQWinkLauncher.class)).jumpToQQWinkIndex(activity, new QQWinkConfig(listOf, qQWinkPage, null, null, 12, null), bundle);
    }
}
