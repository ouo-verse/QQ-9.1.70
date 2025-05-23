package com.tencent.mobileqq.ai;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.aelight.camera.download.AEResManagerConfigBean;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quipagetabbar.QUIPageTabBar;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vas.inject.IAvatarPendantView;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ#\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/ai/c;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/mobileqq/vas/inject/IAvatarPendantView;", "avatarPendantView", "", "b", "Lcom/tencent/biz/qui/quipagetabbar/QUIPageTabBar;", "tabView", "c", "", "", "tabNameArr", "a", "(Lcom/tencent/biz/qui/quipagetabbar/QUIPageTabBar;[Ljava/lang/String;)V", "[Ljava/lang/String;", "TAB_ID", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f187660a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String[] TAB_ID;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21351);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f187660a = new c();
            TAB_ID = new String[]{"em_bas_ai_avatar_tab", "em_bas_personality_avatar", "em_bas_avatar_frame"};
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public final void a(@NotNull QUIPageTabBar tabView, @NotNull String[] tabNameArr) {
        ViewGroup viewGroup;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) tabView, (Object) tabNameArr);
            return;
        }
        Intrinsics.checkNotNullParameter(tabView, "tabView");
        Intrinsics.checkNotNullParameter(tabNameArr, "tabNameArr");
        try {
            View childAt = tabView.getChildAt(0);
            if (childAt instanceof ViewGroup) {
                viewGroup = (ViewGroup) childAt;
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                int childCount = viewGroup.getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt2 = viewGroup.getChildAt(i3);
                    VideoReport.setElementParam(childAt2, "tab_name", tabNameArr[i3]);
                    VideoReport.setElementId(childAt2, "em_bas_category_tab");
                }
            }
        } catch (Exception e16) {
            QLog.e("AIAvatarHomeReporter", 1, "reportTabExp: ", e16);
        }
    }

    public final void b(@NotNull Activity activity, @NotNull View rootView, @NotNull IAvatarPendantView avatarPendantView) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, activity, rootView, avatarPendantView);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(avatarPendantView, "avatarPendantView");
        VideoReport.addToDetectionWhitelist(activity);
        HashMap hashMap = new HashMap();
        hashMap.put("pg_user_avatar_version", AEResManagerConfigBean.DEFAULT_VERSION);
        hashMap.put("user_avatar_type", "");
        if (avatarPendantView.isUserWearPendant()) {
            str = "1";
        } else {
            str = "2";
        }
        hashMap.put("pendant_is_visible", str);
        VideoReport.setPageParams(rootView, new PageParams(hashMap));
        VideoReport.setPageId(rootView, "pg_user_avatar");
        VideoReport.setElementId(avatarPendantView.getHeadView(), "em_avatar");
    }

    public final void c(@NotNull QUIPageTabBar tabView) {
        ViewGroup viewGroup;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) tabView);
            return;
        }
        Intrinsics.checkNotNullParameter(tabView, "tabView");
        try {
            View childAt = tabView.getChildAt(0);
            if (childAt instanceof ViewGroup) {
                viewGroup = (ViewGroup) childAt;
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                String[] strArr = TAB_ID;
                int length = strArr.length;
                for (int i3 = 0; i3 < length; i3++) {
                    VideoReport.setElementId(viewGroup.getChildAt(i3), strArr[i3]);
                }
            }
        } catch (Exception e16) {
            QLog.e("AIAvatarHomeReporter", 1, "reportTabExp: ", e16);
        }
    }
}
