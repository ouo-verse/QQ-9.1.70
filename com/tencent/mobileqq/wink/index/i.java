package com.tencent.mobileqq.wink.index;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.aelight.camera.api.IQQWinkFragmentLoader;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qqlive.config.QQLiveEntrance;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.QQWinkConfig;
import com.tencent.mobileqq.wink.QQWinkPage;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.event.WinkLaunchEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J(\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\r\u001a\u00020\nH\u0002J\u001e\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/wink/index/i;", "", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "Landroid/os/Bundle;", "bundle", "Lcom/tencent/mobileqq/wink/QQWinkConfig;", "winkConfig", "", "d", "b", "f", "e", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i f322938a = new i();

    i() {
    }

    private final void b(final Context context, Intent intent, Bundle bundle, QQWinkConfig winkConfig) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.index.h
            @Override // java.lang.Runnable
            public final void run() {
                i.c(context);
            }
        });
        bundle.putSerializable("WINK_MEDIA_PICKER_CONFIG", winkConfig.getMediaPickerConfig());
        bundle.putSerializable("WINK_MEDIA_PICKER_INIT_BEAN", winkConfig.getMediaPickerInitBean());
        intent.putExtras(bundle);
        com.tencent.mobileqq.wink.picker.f.f324854a.h(context, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(Context context) {
        Intrinsics.checkNotNullParameter(context, "$context");
        QQToast.makeText(context, "\u8d44\u6e90\u52a0\u8f7d\u4e2d\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5", 0).show();
    }

    private final void d(Context context, Intent intent, Bundle bundle, QQWinkConfig winkConfig) {
        try {
            if (!QQWinkPageManager.f322925a.b(context)) {
                com.tencent.mobileqq.qqlive.config.c.f271178a.d(context, QQLiveEntrance.WINK);
            }
            intent.putExtras(bundle);
            if (winkConfig.getInitPage() == QQWinkPage.Capture && Intrinsics.areEqual(bundle.getString("frompage"), "webview")) {
                intent.addFlags(603979776);
            }
            if (context instanceof Activity) {
                ((Activity) context).startActivityForResult(intent, bundle.getInt(QQWinkConstants.ACTIVITY_REQUEST_CODE, 0));
                ((Activity) context).overridePendingTransition(R.anim.f155067i2, R.anim.f154550b4);
            } else {
                context.startActivity(intent);
            }
        } catch (Exception e16) {
            w53.b.d("QQWinkIndexLauncher", "open wink error", e16);
        }
    }

    private final void f() {
        w53.b.f("QQWinkIndexLauncher", "notifyLaunchEvent");
        SimpleEventBus.getInstance().dispatchEvent(new WinkLaunchEvent());
    }

    public final void e(@NotNull Context context, @NotNull QQWinkConfig winkConfig, @NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(winkConfig, "winkConfig");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        bundle.containsKey("app_key");
        String string = bundle.getString(QQWinkConstants.CAPTURE_ABILITY, "all");
        boolean z16 = true;
        if (Intrinsics.areEqual("photo", string)) {
            bundle.putInt("ability_flag", 2);
        } else if (Intrinsics.areEqual("video", string)) {
            bundle.putInt("ability_flag", 3);
        } else {
            bundle.putInt("ability_flag", 1);
        }
        bundle.putParcelable("key_qq_wink_config", winkConfig);
        Intent intent = new Intent(context, (Class<?>) QQWinkIndexActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        bundle.putInt(AECameraConstants.VIDEO_STORY_FROM_TYPE, js.a.O.b());
        if (bundle.getBoolean(QQWinkConstants.IS_CAMERA_RES_READY)) {
            w53.b.f("QQWinkIndexLauncher", "[launch] isCameraResReady");
        } else {
            z16 = ((IAECameraLauncher) QRoute.api(IAECameraLauncher.class)).isFlashCameraResReady(QQWinkConstants.ENTRY_QQ_WORLD, false);
            w53.b.f("QQWinkIndexLauncher", "[launch] isFlashCameraResReady=" + z16);
        }
        if (z16) {
            d(context, intent, bundle, winkConfig);
        } else {
            b(context, intent, bundle, winkConfig);
        }
        f();
        ((IQQWinkFragmentLoader) QRoute.api(IQQWinkFragmentLoader.class)).loadLightResource(z16);
        if (winkConfig.g().contains(QQWinkPage.Capture)) {
            ((IQQWinkFragmentLoader) QRoute.api(IQQWinkFragmentLoader.class)).preloadCaptureResource(bundle);
        }
    }
}
