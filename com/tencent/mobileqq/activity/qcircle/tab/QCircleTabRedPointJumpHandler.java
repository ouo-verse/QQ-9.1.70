package com.tencent.mobileqq.activity.qcircle.tab;

import android.content.Intent;
import androidx.annotation.UiThread;
import com.tencent.biz.qqcircle.immersive.utils.br;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import qqcircle.QQCircleCounter$RedPointInfo;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \r2\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0007J\b\u0010\u000e\u001a\u00020\bH\u0007R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/activity/qcircle/tab/QCircleTabRedPointJumpHandler;", "", "Lcom/tencent/mobileqq/app/BaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "jumpType", "", "jumpLink", "", "e", "b", "Lqqcircle/QQCircleCounter$RedPointInfo;", "redPointInfo", "c", "d", "Lcom/tencent/mobileqq/widget/QQProgressDialog;", "a", "Lcom/tencent/mobileqq/widget/QQProgressDialog;", "progress", "Lcom/tencent/biz/qqcircle/immersive/utils/br;", "Lcom/tencent/biz/qqcircle/immersive/utils/br;", "triggerRunner", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class QCircleTabRedPointJumpHandler {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QQProgressDialog progress;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private br triggerRunner = new br(500);

    /* JADX WARN: Removed duplicated region for block: B:16:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String b(String jumpLink) {
        String str;
        boolean startsWith$default;
        JSONObject jSONObject;
        String config = QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_tab_red_point_jump_loading_tip", "{}");
        boolean z16 = true;
        QLog.i("QCircleTabRedPoint-JumpHandler", 1, "getLoadingTip, configJsonStr=" + config);
        String str2 = "";
        try {
            jSONObject = new JSONObject(config);
            str = jSONObject.optString("live_tip", "");
            Intrinsics.checkNotNullExpressionValue(str, "configJSONObject.optString(\"live_tip\", \"\")");
        } catch (JSONException e16) {
            e = e16;
            str = "";
        }
        try {
            String optString = jSONObject.optString("default_tip", "");
            Intrinsics.checkNotNullExpressionValue(optString, "configJSONObject.optString(\"default_tip\", \"\")");
            str2 = optString;
        } catch (JSONException e17) {
            e = e17;
            QLog.i("QCircleTabRedPoint-JumpHandler", 1, "getLoadingTip exception", e);
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(jumpLink, "mqqapi://vaslive", false, 2, null);
            if (!startsWith$default) {
            }
        }
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(jumpLink, "mqqapi://vaslive", false, 2, null);
        if (!startsWith$default) {
            if (str.length() != 0) {
                z16 = false;
            }
            if (z16) {
                return "\u76f4\u64ad\u95f4\u52a0\u8f7d\u4e2d\uff0c\u9a6c\u4e0a\u5c31\u6765";
            }
            return str;
        }
        if (str2.length() != 0) {
            z16 = false;
        }
        if (z16) {
            str2 = "\u5185\u5bb9\u52a0\u8f7d\u4e2d\uff0c\u9a6c\u4e0a\u5c31\u6765";
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(BaseActivity activity, int jumpType, String jumpLink) {
        ax c16;
        if (jumpType != 1) {
            if (jumpType != 2 || (c16 = bi.c(activity.app, activity, jumpLink)) == null) {
                return;
            } else {
                c16.b();
            }
        } else {
            activity.startActivity(new Intent(activity, (Class<?>) QQBrowserActivity.class).putExtra("url", jumpLink));
        }
        if (this.progress == null) {
            QQProgressDialog qQProgressDialog = new QQProgressDialog(activity, activity.getTitleBarHeight() + x.c(activity, 25.0f));
            qQProgressDialog.setMessage(b(jumpLink));
            qQProgressDialog.show();
            this.progress = qQProgressDialog;
        }
    }

    @UiThread
    public final void c(@NotNull QQCircleCounter$RedPointInfo redPointInfo) {
        final SplashActivity splashActivity;
        Intrinsics.checkNotNullParameter(redPointInfo, "redPointInfo");
        WeakReference<SplashActivity> weakReference = SplashActivity.sWeakInstance;
        if (weakReference != null) {
            splashActivity = weakReference.get();
        } else {
            splashActivity = null;
        }
        if (splashActivity == null) {
            QLog.i("QCircleTabRedPoint-JumpHandler", 1, "handleRedPointJumpInfo, activity=null");
            return;
        }
        final String str = redPointInfo.redJumpInfo.jumpLink.get();
        final int i3 = redPointInfo.redJumpInfo.jumpType.get();
        if (i3 == 0) {
            return;
        }
        QLog.i("QCircleTabRedPoint-JumpHandler", 1, "handleRedPointJumpInfo, jumpType=" + i3 + ",jumpLink=" + str);
        this.triggerRunner.a(new Function0<Unit>() { // from class: com.tencent.mobileqq.activity.qcircle.tab.QCircleTabRedPointJumpHandler$handleRedPointJumpInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                QCircleTabRedPointJumpHandler qCircleTabRedPointJumpHandler = QCircleTabRedPointJumpHandler.this;
                SplashActivity splashActivity2 = splashActivity;
                int i16 = i3;
                String jumpLink = str;
                Intrinsics.checkNotNullExpressionValue(jumpLink, "jumpLink");
                qCircleTabRedPointJumpHandler.e(splashActivity2, i16, jumpLink);
            }
        });
    }

    @UiThread
    public final void d() {
        QQProgressDialog qQProgressDialog = this.progress;
        if (qQProgressDialog != null) {
            qQProgressDialog.dismiss();
        }
        this.progress = null;
    }
}
