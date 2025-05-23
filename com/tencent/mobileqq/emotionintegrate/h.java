package com.tencent.mobileqq.emotionintegrate;

import android.app.Activity;
import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J&\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007J\u001c\u0010\r\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0007J\u0012\u0010\u000e\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0007\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/emotionintegrate/h;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/mobileqq/activity/aio/SessionInfo;", "sessionInfo", "", "a", "bottomBar", "Lcom/tencent/mobileqq/emotionintegrate/p;", "data", "c", "b", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f205220a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55052);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f205220a = new h();
        }
    }

    h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @JvmStatic
    public static final void a(@Nullable Activity activity, @Nullable View rootView, @Nullable SessionInfo sessionInfo) {
        if (activity != null && rootView != null && sessionInfo != null) {
            VideoReport.addToDetectionWhitelist(activity);
            VideoReport.setPageId(rootView, "pg_emoticon_details");
            int i3 = sessionInfo.f179555d;
            int i16 = 1;
            if (i3 != 1) {
                if (i3 == 0) {
                    i16 = 2;
                } else if (com.tencent.mobileqq.activity.i.a(i3)) {
                    i16 = 3;
                } else if (i3 == 10016) {
                    i16 = 4;
                } else {
                    i16 = 5;
                }
            }
            VideoReport.setPageParams(rootView, "type_aio_pg", Integer.valueOf(i16));
        }
    }

    @JvmStatic
    public static final void b(@Nullable View bottomBar) {
        if (bottomBar == null) {
            return;
        }
        VideoReport.reportEvent("dt_clck", bottomBar, null);
    }

    @JvmStatic
    public static final void c(@Nullable View bottomBar, @Nullable p data) {
        int i3;
        if (bottomBar != null && data != null) {
            VideoReport.setElementId(bottomBar, "bottom_bar");
            VideoReport.setElementClickPolicy(bottomBar, ClickPolicy.REPORT_NONE);
            if (data.x()) {
                i3 = 3;
            } else if (data.r()) {
                i3 = 2;
            } else if (data.i() == 11) {
                i3 = 4;
            } else if (data.i() == 1) {
                i3 = 1;
            } else if (data.u()) {
                i3 = 5;
            } else if (data.m()) {
                i3 = 7;
            } else {
                i3 = 6;
            }
            VideoReport.setElementParam(bottomBar, "emoticon_type_import_from", Integer.valueOf(i3));
        }
    }
}
