package com.tencent.mobileqq.guild.discoveryv2.parts;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedUtilsApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.richframework.preload.activity.ActivityPreloadManager;
import com.tencent.richframework.preload.activity.BaseActivityResPreloadTask;
import com.tencent.richframework.thread.RFWThreadManager;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u001c\u0010\t\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\n\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u000b\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016R\u001b\u0010\u0011\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0014\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010R\u001b\u0010\u0017\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0016\u0010\u0010R\u001b\u0010\u001c\u001a\u00020\u00188BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/parts/PreloadFeedPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "G9", "I9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartResume", "onPartDestroy", "Lcom/tencent/richframework/preload/activity/BaseActivityResPreloadTask;", "d", "Lkotlin/Lazy;", "E9", "()Lcom/tencent/richframework/preload/activity/BaseActivityResPreloadTask;", "mFeedSquarePreloadTask", "e", "C9", "mFeedDetailPreloadTask", "f", "D9", "mFeedGalleryPreloadTask", "", tl.h.F, "F9", "()Z", "preloadToolProcessEnable", "<init>", "()V", "i", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class PreloadFeedPart extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mFeedSquarePreloadTask;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mFeedDetailPreloadTask;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mFeedGalleryPreloadTask;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy preloadToolProcessEnable;

    public PreloadFeedPart() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<BaseActivityResPreloadTask>() { // from class: com.tencent.mobileqq.guild.discoveryv2.parts.PreloadFeedPart$mFeedSquarePreloadTask$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final BaseActivityResPreloadTask invoke() {
                return ((IGuildFeedUtilsApi) QRoute.api(IGuildFeedUtilsApi.class)).getFeedSquarePreloadTask();
            }
        });
        this.mFeedSquarePreloadTask = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<BaseActivityResPreloadTask>() { // from class: com.tencent.mobileqq.guild.discoveryv2.parts.PreloadFeedPart$mFeedDetailPreloadTask$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final BaseActivityResPreloadTask invoke() {
                return ((IGuildFeedUtilsApi) QRoute.api(IGuildFeedUtilsApi.class)).getFeedDetailPreloadTask();
            }
        });
        this.mFeedDetailPreloadTask = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<BaseActivityResPreloadTask>() { // from class: com.tencent.mobileqq.guild.discoveryv2.parts.PreloadFeedPart$mFeedGalleryPreloadTask$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final BaseActivityResPreloadTask invoke() {
                return ((IGuildFeedUtilsApi) QRoute.api(IGuildFeedUtilsApi.class)).getFeedGalleryPreloadTask();
            }
        });
        this.mFeedGalleryPreloadTask = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.guild.discoveryv2.parts.PreloadFeedPart$preloadToolProcessEnable$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                return Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("guild_feed_preload_tool_process_enable_119556107", true));
            }
        });
        this.preloadToolProcessEnable = lazy4;
    }

    private final BaseActivityResPreloadTask C9() {
        return (BaseActivityResPreloadTask) this.mFeedDetailPreloadTask.getValue();
    }

    private final BaseActivityResPreloadTask D9() {
        return (BaseActivityResPreloadTask) this.mFeedGalleryPreloadTask.getValue();
    }

    private final BaseActivityResPreloadTask E9() {
        return (BaseActivityResPreloadTask) this.mFeedSquarePreloadTask.getValue();
    }

    private final boolean F9() {
        return ((Boolean) this.preloadToolProcessEnable.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G9() {
        ActivityPreloadManager activityPreloadManager = ActivityPreloadManager.INSTANCE;
        activityPreloadManager.addPreloadTask(E9());
        activityPreloadManager.addPreloadTask(C9());
        activityPreloadManager.addPreloadTask(D9());
        ((IGuildFeedUtilsApi) QRoute.api(IGuildFeedUtilsApi.class)).loadFeedHtmlOffline();
        QLog.i("PreloadFeedPart", 2, "handleFirstScreenReady preloadToolProcessEnable=" + F9());
        if (F9()) {
            ((IGuildFeedUtilsApi) QRoute.api(IGuildFeedUtilsApi.class)).preloadToolProcess();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9() {
        Logger.f235387a.d().i("PreloadFeedPart", 1, "PreloadFeedPart onPartCreate");
        rh1.d.f431454a.l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I9() {
        RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.guild.discoveryv2.parts.i
            @Override // java.lang.Runnable
            public final void run() {
                PreloadFeedPart.J9();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9() {
        long currentTimeMillis = System.currentTimeMillis();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = null;
        try {
            try {
                ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream);
                try {
                    objectOutputStream2.writeObject(new GProStFeed());
                    byteArrayOutputStream.close();
                    objectOutputStream2.close();
                } catch (Exception unused) {
                    objectOutputStream = objectOutputStream2;
                    byteArrayOutputStream.close();
                    if (objectOutputStream != null) {
                        objectOutputStream.close();
                    }
                    QLog.i("PreloadFeedPart", 1, "preSerializableGProStFeed cost=" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
                } catch (Throwable th5) {
                    th = th5;
                    objectOutputStream = objectOutputStream2;
                    try {
                        byteArrayOutputStream.close();
                        if (objectOutputStream != null) {
                            objectOutputStream.close();
                        }
                    } catch (Exception unused2) {
                    }
                    throw th;
                }
            } catch (Exception unused3) {
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Exception unused4) {
        }
        QLog.i("PreloadFeedPart", 1, "preSerializableGProStFeed cost=" + (System.currentTimeMillis() - currentTimeMillis) + "ms");
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.guild.discoveryv2.parts.j
            @Override // java.lang.Runnable
            public final void run() {
                PreloadFeedPart.H9();
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        ActivityPreloadManager activityPreloadManager = ActivityPreloadManager.INSTANCE;
        activityPreloadManager.removePreloadTask(E9());
        activityPreloadManager.removePreloadTask(C9());
        activityPreloadManager.removePreloadTask(D9());
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        super.onPartResume(activity);
        BuildersKt__Builders_commonKt.launch$default(com.tencent.mobileqq.guild.discoveryv2.content.part.d.b(this), Dispatchers.getMain(), null, new PreloadFeedPart$onPartResume$1(this, null), 2, null);
    }
}
