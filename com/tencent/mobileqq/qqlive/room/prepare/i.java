package com.tencent.mobileqq.qqlive.room.prepare;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.res.Resources;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.config.QQLiveBusinessConfig;
import com.tencent.mobileqq.qqlive.context.QQLiveContext;
import com.tencent.mobileqq.qqlive.room.floatview.QQLiveGameRoomService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.common.api.IQQLiveReportApi;
import com.tencent.qqlive.common.report.constant.QQLiveQualityReportData;
import com.tencent.qqlive.common.report.constant.QQLiveReportConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qg4.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\u000b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/prepare/i;", "", "", "configList", "", "errorCode", "", "d", "Landroid/app/Activity;", "hostActivity", "errorMsg", "b", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class i {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i f271952a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35116);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f271952a = new i();
        }
    }

    i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(Activity activity, DialogInterface dialogInterface, int i3) {
        if (activity != null && !activity.isFinishing()) {
            AegisLogger.INSTANCE.i("Open_Live|PrepareViolationHandler", "finishSelfActivity", "close self page end");
            QQLiveGameRoomService.INSTANCE.c();
            activity.finish();
        }
    }

    private final boolean d(String configList, long errorCode) {
        List<String> split$default;
        boolean equals;
        AegisLogger.INSTANCE.i("Open_Live|PrepareViolationHandler", "isInConfigList", "configList=" + configList + ", errorCode=" + errorCode);
        if (!Intrinsics.areEqual(configList, "all")) {
            split$default = StringsKt__StringsKt.split$default((CharSequence) configList, new String[]{","}, false, 0, 6, (Object) null);
            for (String str : split$default) {
                equals = StringsKt__StringsJVMKt.equals(str, String.valueOf(errorCode), true);
                if (equals) {
                    AegisLogger.INSTANCE.i("Open_Live|PrepareViolationHandler", "isInConfigList", "hit config list, check=" + str);
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public final boolean b(@Nullable final Activity hostActivity, long errorCode, @NotNull String errorMsg) {
        String str;
        String str2;
        Resources resources;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, hostActivity, Long.valueOf(errorCode), errorMsg)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        IQQLiveReportApi iQQLiveReportApi = (IQQLiveReportApi) QRoute.api(IQQLiveReportApi.class);
        QQLiveQualityReportData.Builder builder = new QQLiveQualityReportData.Builder(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 67108863, null);
        QQLiveContext c16 = QQLiveContext.INSTANCE.c(QQLiveBusinessConfig.QQLIVE_APP_ID);
        if (c16 != null) {
            str = c16.n();
        } else {
            str = null;
        }
        iQQLiveReportApi.qualityReport(builder.traceId(str).retCode(String.valueOf(errorCode)).desc("handlePrepareError: " + errorMsg).eventId(QQLiveReportConstants.Event.E_BEFORE_START_LIVE_FAIL_REASON).ext6(QQLiveReportConstants.Scene.SCENE_START_RTMP_LIVE));
        if (d(ht3.a.d("qqlive_need_show_close_prepare_page_alert", ""), errorCode)) {
            qg4.e.INSTANCE.d(errorMsg, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.qqlive.room.prepare.h
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    i.c(hostActivity, dialogInterface, i3);
                }
            });
            return true;
        }
        if (d(ht3.a.d("qqlive_need_show_alert", "1011002,1011009,1011012,2001,1002"), errorCode)) {
            qg4.e.INSTANCE.d(errorMsg, null);
            return true;
        }
        if (errorCode == 1007) {
            e.Companion companion = qg4.e.INSTANCE;
            if (hostActivity == null || (resources = hostActivity.getResources()) == null || (str2 = resources.getString(R.string.f210125h_)) == null) {
                str2 = "\u77e5\u9053\u4e86";
            }
            companion.e(errorMsg, str2, null, "", null);
            return true;
        }
        return false;
    }
}
