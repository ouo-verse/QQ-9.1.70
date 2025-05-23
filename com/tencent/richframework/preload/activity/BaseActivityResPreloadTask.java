package com.tencent.richframework.preload.activity;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import androidx.annotation.UiThread;
import androidx.fragment.app.Argus;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.hook.util.RFWFieldUtil;
import com.tencent.biz.richframework.layoutinflater.PreloadRequest;
import com.tencent.biz.richframework.layoutinflater.RFWLayoutPreLoader;
import com.tencent.biz.richframework.util.RFWAppUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.richframework.argus.ContextWrapperFactory;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0017J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0017J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0006H\u0002R\u001e\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0012\u0010\t\u001a\u00020\nX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u000f0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/richframework/preload/activity/BaseActivityResPreloadTask;", "Lcom/tencent/richframework/preload/activity/BaseActivityPreloadTask;", "()V", "preloadRes", "", "Lcom/tencent/biz/richframework/layoutinflater/PreloadRequest;", "", "getPreloadRes", "()Ljava/util/Map;", "targetPreLoader", "Lcom/tencent/biz/richframework/layoutinflater/RFWLayoutPreLoader;", "getTargetPreLoader", "()Lcom/tencent/biz/richframework/layoutinflater/RFWLayoutPreLoader;", "wrapperClass", "", "Ljava/lang/Class;", QCircleLpReportDc05507.KEY_CLEAR, "", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "doAfterActivityCreate", "doBeforeActivityBeUse", "setTheme", "", "context", "Landroid/content/Context;", "themeId", "Companion", "preload-activity_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public abstract class BaseActivityResPreloadTask extends BaseActivityPreloadTask {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final Set<Class<?>> wrapperClass = new HashSet();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001\u00a8\u0006\b"}, d2 = {"Lcom/tencent/richframework/preload/activity/BaseActivityResPreloadTask$Companion;", "", "()V", "setActivityFakeResource", "", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "baseContext", "preload-activity_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes25.dex */
    public static final class Companion {
        Companion() {
        }

        public final void setActivityFakeResource(@NotNull Activity activity, @Nullable Object baseContext) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            try {
                RFWFieldUtil.setField(ContextWrapper.class, activity, "mBase", baseContext);
                if (baseContext == null && ActivityPreloadConfig.INSTANCE.getResetBaseResourceEnabled()) {
                    if (Build.VERSION.SDK_INT >= 29) {
                        activity.setTheme((Resources.Theme) null);
                        RFWFieldUtil.setField(ContextThemeWrapper.class, activity, "mResources", null);
                    } else if (RFWAppUtil.INSTANCE.getTargetVersion() <= 28) {
                        RFWFieldUtil.setField(ContextThemeWrapper.class, activity, "mThemes", null);
                        RFWFieldUtil.setField(ContextThemeWrapper.class, activity, "mResources", null);
                    }
                }
            } catch (Exception e16) {
                RFWLog.e("ActivityPreloadManager", RFWLog.USR, e16);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final boolean setTheme(Context context, int themeId) {
        boolean contains$default;
        try {
            context.setTheme(themeId);
            return true;
        } catch (Exception e16) {
            if ((e16 instanceof NullPointerException) && !TextUtils.isEmpty(e16.getMessage())) {
                String message = e16.getMessage();
                Intrinsics.checkNotNull(message);
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) message, (CharSequence) "android.view.Window.setTheme(int)", false, 2, (Object) null);
                if (contains$default) {
                    RFWLog.i(Argus.TAG, RFWLog.USR, "preload activity set window npe as expect");
                    return true;
                }
            }
            RFWLog.e(Argus.TAG, RFWLog.USR, e16);
            return false;
        }
    }

    @Override // com.tencent.richframework.preload.activity.BaseActivityPreloadTask
    @UiThread
    public void clear(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        getTargetPreLoader().clearPagePreLoaders(activity);
    }

    @Override // com.tencent.richframework.preload.activity.BaseActivityPreloadTask
    @UiThread
    public void doAfterActivityCreate(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.doAfterActivityCreate(activity);
        INSTANCE.setActivityFakeResource(activity, RFWApplication.getApplication());
        int themeId = BaseActivityPreloadTask.INSTANCE.getThemeId(activity.getClass());
        if (themeId == Integer.MIN_VALUE) {
            RFWLog.e(Argus.TAG, RFWLog.USR, "preload activity get themeId failed");
            return;
        }
        if (themeId != 0 && !setTheme(activity, themeId)) {
            RFWLog.e(Argus.TAG, RFWLog.USR, "preload activity set themeId failed");
            return;
        }
        for (Map.Entry<PreloadRequest, Integer> entry : getPreloadRes().entrySet()) {
            PreloadRequest key = entry.getKey();
            int intValue = entry.getValue().intValue();
            if (key.getCustomContextClass() != null && !this.wrapperClass.contains(key.getCustomContextClass())) {
                this.wrapperClass.add(key.getCustomContextClass());
                ContextWrapperFactory contextWrapperFactory = ContextWrapperFactory.INSTANCE;
                Class<?> customContextClass = key.getCustomContextClass();
                Intrinsics.checkNotNull(customContextClass);
                Context contextWrapper = contextWrapperFactory.getContextWrapper(customContextClass, activity);
                if ((contextWrapper instanceof Activity) && themeId != 0 && !setTheme(contextWrapper, themeId)) {
                    RFWLog.e(Argus.TAG, RFWLog.USR, "preload activity set themeId failed");
                    return;
                }
            }
            getTargetPreLoader().fillPreloadView(activity, key, intValue);
        }
    }

    @Override // com.tencent.richframework.preload.activity.BaseActivityPreloadTask
    public void doBeforeActivityBeUse(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.doBeforeActivityBeUse(activity);
        if (!ActivityPreloadConfig.INSTANCE.getResetBaseContextBeforeAttachBaseEnabled()) {
            INSTANCE.setActivityFakeResource(activity, null);
        }
    }

    @NotNull
    public abstract Map<PreloadRequest, Integer> getPreloadRes();

    @NotNull
    public abstract RFWLayoutPreLoader getTargetPreLoader();
}
