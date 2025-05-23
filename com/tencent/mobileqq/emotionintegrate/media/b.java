package com.tencent.mobileqq.emotionintegrate.media;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
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
import cooperation.qzone.QZoneNavigateToQQTransparentFragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007J\f\u0010\t\u001a\u00020\u0006*\u00020\bH\u0002J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/emotionintegrate/media/b;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "requestCode", "", "d", "Landroid/os/Bundle;", "b", "c", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a */
    @NotNull
    public static final b f205253a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\t\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/emotionintegrate/media/b$a", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "", "", "permissions", "", ForwardMiniChooseFriendOption.RESULT_LIST, "onDenied", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class a extends QQPermission.BasePermissionsListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a */
        final /* synthetic */ Activity f205254a;

        /* renamed from: b */
        final /* synthetic */ int f205255b;

        a(Activity activity, int i3) {
            this.f205254a = activity;
            this.f205255b = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity, i3);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                b.f205253a.c(this.f205254a, this.f205255b);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(@Nullable List<String> permissions, @Nullable List<Integer> r56) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) permissions, (Object) r56);
            } else {
                QLog.e("WinkAIAvatarMediaLauncher", 1, "launchWinkCaptureForResult permission denied.");
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17081);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f205253a = new b();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void b(Bundle bundle) {
        bundle.putString("app_key", "0S200MNJT807V3GE");
        bundle.putString(QQWinkConstants.ENTRY_BUSINESS_NAME, "AI_AVATAR");
        bundle.putString("wink_output_route", WinkAIAvatarOutputRouter.ROUTE_PATH);
        bundle.putLong("wink_output_point", 8L);
    }

    public final void c(Activity r112, int requestCode) {
        List listOf;
        Bundle bundle = new Bundle();
        f205253a.b(bundle);
        bundle.putString(QQWinkConstants.CAPTURE_ABILITY, "photo");
        bundle.putBoolean(QQWinkConstants.HOME_SHOW_CAPTURE_TAB, true);
        bundle.putBoolean(QQWinkConstants.EDITOR_ENABLE_MUSIC, false);
        bundle.putBoolean(QQWinkConstants.EDITOR_ENABLE_SWITCH_EDIT_MODE, false);
        bundle.putInt(QQWinkConstants.EDITOR_DEFAULT_EDIT_MODE, 1);
        bundle.putInt(QQWinkConstants.ACTIVITY_REQUEST_CODE, requestCode);
        bundle.putSerializable("selected_style_material", r112.getIntent().getSerializableExtra("selected_style_material"));
        bundle.putSerializable(QZoneNavigateToQQTransparentFragment.EXTRA_KEY_REQUEST_CODE, Integer.valueOf(r112.getIntent().getIntExtra(QZoneNavigateToQQTransparentFragment.EXTRA_KEY_REQUEST_CODE, -1)));
        QQWinkPage qQWinkPage = QQWinkPage.Capture;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(qQWinkPage);
        ((IQQWinkLauncher) QRoute.api(IQQWinkLauncher.class)).jumpToQQWinkIndex(r112, new QQWinkConfig(listOf, qQWinkPage, null, null, 12, null), bundle);
    }

    @JvmStatic
    public static final void d(@NotNull Activity r56, int requestCode) {
        Intrinsics.checkNotNullParameter(r56, "activity");
        if (r56.checkSelfPermission(QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE) == 0 && r56.checkSelfPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) == 0) {
            f205253a.c(r56, requestCode);
            return;
        }
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(r56, new BusinessConfig(QQPermissionConstants.Business.ID.QQ_BUSINESS_CARD, QQPermissionConstants.Business.SCENE.PROFILE_CARD_EDIT_TAKE_AVATAR_PHOTO));
        if (qQPermission != null) {
            qQPermission.requestPermissions(new String[]{QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new a(r56, requestCode));
        }
    }

    public static /* synthetic */ void e(Activity activity, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = 4;
        }
        d(activity, i3);
    }
}
