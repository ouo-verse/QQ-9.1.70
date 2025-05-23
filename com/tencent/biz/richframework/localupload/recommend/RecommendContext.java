package com.tencent.biz.richframework.localupload.recommend;

import android.app.Application;
import com.tencent.biz.richframework.localupload.recommend.delegate.IRFWUploadRecommendDelegate;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 82\u00020\u0001:\u00018B\u0007\u00a2\u0006\u0004\b6\u00107J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0016\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007J\u0016\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007J\u0016\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007J\u0016\u0010\u000f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u0010\u001a\u00020\u0004J\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0014\u001a\u00020\u0004R\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\"\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001b\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010 \u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\u001c\u001a\u0004\b \u0010\u001d\"\u0004\b!\u0010\u001fR\"\u0010#\u001a\u00020\"8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010)\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u00100\u001a\u00020/8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105\u00a8\u00069"}, d2 = {"Lcom/tencent/biz/richframework/localupload/recommend/RecommendContext;", "", "Lcom/tencent/biz/richframework/localupload/recommend/IUploadRecommendCallBack;", "recommendCallBack", "", "registerRecommendCallBack", "unregisterRecommendCallBack", "", "tag", ReportConstant.COSTREPORT_PREFIX, "e", "d", APMidasPayAPI.ENV_DEV, "", "t", "fatal", "onRecommendFinish", "", "isFinish", "notifyScanProgressChange", "resetRecommendSessionId", "", "mRecommendCallBacks", "Ljava/util/List;", "getMRecommendCallBacks", "()Ljava/util/List;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isInQZoneEnv", "Ljava/util/concurrent/atomic/AtomicBoolean;", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "setInQZoneEnv", "(Ljava/util/concurrent/atomic/AtomicBoolean;)V", "isRecommending", "setRecommending", "Landroid/app/Application;", "androidContext", "Landroid/app/Application;", "getAndroidContext", "()Landroid/app/Application;", "setAndroidContext", "(Landroid/app/Application;)V", "mSessionId", "Ljava/lang/String;", "getMSessionId", "()Ljava/lang/String;", "setMSessionId", "(Ljava/lang/String;)V", "Lcom/tencent/biz/richframework/localupload/recommend/delegate/IRFWUploadRecommendDelegate;", "delegate", "Lcom/tencent/biz/richframework/localupload/recommend/delegate/IRFWUploadRecommendDelegate;", "getDelegate", "()Lcom/tencent/biz/richframework/localupload/recommend/delegate/IRFWUploadRecommendDelegate;", "setDelegate", "(Lcom/tencent/biz/richframework/localupload/recommend/delegate/IRFWUploadRecommendDelegate;)V", "<init>", "()V", "Companion", "local-upload-recommend-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class RecommendContext {
    public Application androidContext;
    public IRFWUploadRecommendDelegate delegate;

    @NotNull
    private AtomicBoolean isInQZoneEnv = new AtomicBoolean(false);

    @NotNull
    private AtomicBoolean isRecommending = new AtomicBoolean(false);

    @NotNull
    private String mSessionId = "";

    @NotNull
    private final List<IUploadRecommendCallBack> mRecommendCallBacks = new CopyOnWriteArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    public static final void notifyScanProgressChange$lambda$3(RecommendContext this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Iterator<T> it = this$0.mRecommendCallBacks.iterator();
        while (it.hasNext()) {
            ((IUploadRecommendCallBack) it.next()).onScanProcessChange(z16);
        }
    }

    public final void d(@NotNull String tag, @NotNull String s16) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(s16, "s");
        getDelegate().getLogDelegate().debug("MediaRecommend_" + tag, s16);
    }

    public final void dev(@NotNull String tag, @NotNull String s16) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(s16, "s");
        getDelegate().getLogDelegate().dev("MediaRecommend_" + tag, s16);
    }

    public final void e(@NotNull String tag, @NotNull String s16) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(s16, "s");
        getDelegate().getLogDelegate().error("MediaRecommend_" + tag, s16);
    }

    public final void fatal(@NotNull String tag, @NotNull Throwable t16) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(t16, "t");
        getDelegate().getLogDelegate().fatal("MediaRecommend_" + tag, t16);
    }

    @NotNull
    public final Application getAndroidContext() {
        Application application = this.androidContext;
        if (application != null) {
            return application;
        }
        Intrinsics.throwUninitializedPropertyAccessException("androidContext");
        return null;
    }

    @NotNull
    public final IRFWUploadRecommendDelegate getDelegate() {
        IRFWUploadRecommendDelegate iRFWUploadRecommendDelegate = this.delegate;
        if (iRFWUploadRecommendDelegate != null) {
            return iRFWUploadRecommendDelegate;
        }
        Intrinsics.throwUninitializedPropertyAccessException("delegate");
        return null;
    }

    @NotNull
    public final List<IUploadRecommendCallBack> getMRecommendCallBacks() {
        return this.mRecommendCallBacks;
    }

    @NotNull
    public final String getMSessionId() {
        return this.mSessionId;
    }

    @NotNull
    /* renamed from: isInQZoneEnv, reason: from getter */
    public final AtomicBoolean getIsInQZoneEnv() {
        return this.isInQZoneEnv;
    }

    @NotNull
    /* renamed from: isRecommending, reason: from getter */
    public final AtomicBoolean getIsRecommending() {
        return this.isRecommending;
    }

    public final void notifyScanProgressChange(final boolean isFinish) {
        RFWRecommendThread.INSTANCE.getS_MAIN_HANDLER().post(new Runnable() { // from class: com.tencent.biz.richframework.localupload.recommend.i
            @Override // java.lang.Runnable
            public final void run() {
                RecommendContext.notifyScanProgressChange$lambda$3(RecommendContext.this, isFinish);
            }
        });
    }

    public final void onRecommendFinish() {
        this.isRecommending.set(false);
        notifyScanProgressChange(true);
    }

    public final void registerRecommendCallBack(@Nullable IUploadRecommendCallBack recommendCallBack) {
        if (recommendCallBack != null && !this.mRecommendCallBacks.contains(recommendCallBack)) {
            this.mRecommendCallBacks.add(recommendCallBack);
        }
    }

    public final void resetRecommendSessionId() {
        this.mSessionId = getDelegate().getReportDelegate().getReportUin() + "_" + System.currentTimeMillis();
    }

    public final void setAndroidContext(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, "<set-?>");
        this.androidContext = application;
    }

    public final void setDelegate(@NotNull IRFWUploadRecommendDelegate iRFWUploadRecommendDelegate) {
        Intrinsics.checkNotNullParameter(iRFWUploadRecommendDelegate, "<set-?>");
        this.delegate = iRFWUploadRecommendDelegate;
    }

    public final void unregisterRecommendCallBack(@Nullable IUploadRecommendCallBack recommendCallBack) {
        if (recommendCallBack != null) {
            this.mRecommendCallBacks.remove(recommendCallBack);
        }
    }
}
