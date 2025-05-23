package com.tencent.mobileqq.guild.home.parts;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.util.Log;
import android.view.View;
import com.tencent.biz.richframework.part.Part;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.api.IWebProcessPreload;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001c\u001dB\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0012\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\r\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/home/parts/GuildOnIdlePreloadPart;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/os/MessageQueue$IdleHandler;", "C9", "", "F9", "E9", "Landroid/view/View;", "view", "", "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Ljava/lang/Runnable;", "d", "Ljava/lang/Runnable;", "preloadRunnable", "e", "Landroid/os/MessageQueue$IdleHandler;", "preloadIdleHandler", "", "f", "I", "x5CoreVersion", "<init>", "()V", tl.h.F, "a", "PreloadRunnable", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildOnIdlePreloadPart extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Runnable preloadRunnable;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MessageQueue.IdleHandler preloadIdleHandler;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int x5CoreVersion = -1;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u0005\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R%\u0010\u000b\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/home/parts/GuildOnIdlePreloadPart$PreloadRunnable;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/guild/home/parts/GuildOnIdlePreloadPart;", "kotlin.jvm.PlatformType", "d", "Lmqq/util/WeakReference;", "getWeakRef", "()Lmqq/util/WeakReference;", "weakRef", "part", "<init>", "(Lcom/tencent/mobileqq/guild/home/parts/GuildOnIdlePreloadPart;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    private static final class PreloadRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<GuildOnIdlePreloadPart> weakRef;

        public PreloadRunnable(@NotNull GuildOnIdlePreloadPart part) {
            Intrinsics.checkNotNullParameter(part, "part");
            this.weakRef = new WeakReference<>(part);
        }

        @Override // java.lang.Runnable
        public void run() {
            GuildOnIdlePreloadPart guildOnIdlePreloadPart = this.weakRef.get();
            if (guildOnIdlePreloadPart != null) {
                Logger logger = Logger.f235387a;
                if (QLog.isDevelopLevel()) {
                    Log.d("GuildOnIdlePreloadPart", "[PreloadRunnable] run");
                }
                MessageQueue.IdleHandler C9 = guildOnIdlePreloadPart.C9();
                Looper.myQueue().addIdleHandler(C9);
                guildOnIdlePreloadPart.preloadIdleHandler = C9;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MessageQueue.IdleHandler C9() {
        return new MessageQueue.IdleHandler() { // from class: com.tencent.mobileqq.guild.home.parts.cg
            @Override // android.os.MessageQueue.IdleHandler
            public final boolean queueIdle() {
                boolean D9;
                D9 = GuildOnIdlePreloadPart.D9(GuildOnIdlePreloadPart.this);
                return D9;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean D9(GuildOnIdlePreloadPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Logger.f235387a.d().d("GuildOnIdlePreloadPart", 1, "[MessageQueue.IdleHandler] run!");
        if (this$0.F9()) {
            ((IWebProcessPreload) QRoute.api(IWebProcessPreload.class)).preDownX5(8, false);
        }
        return false;
    }

    private final boolean E9() {
        if (this.x5CoreVersion < 0) {
            try {
                this.x5CoreVersion = QbSdk.getTbsVersion(BaseApplication.getContext());
            } catch (Throwable th5) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                bVar.a().add("[hasX5Core] error");
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("GuildOnIdlePreloadPart", 1, (String) it.next(), th5);
                }
            }
            Logger logger2 = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger2.d().d("GuildOnIdlePreloadPart", 2, "[hasX5Core] x5CoreVersion " + this.x5CoreVersion);
            }
        }
        if (this.x5CoreVersion > 0) {
            return true;
        }
        return false;
    }

    private final boolean F9() {
        boolean enableMainFrameWeb = com.tencent.mobileqq.guild.util.bs.f235483a.h("105455").getGuildMainWebConfBean().getEnableMainFrameWeb();
        if (!E9() && enableMainFrameWeb) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View view) {
        super.onInitView(view);
        PreloadRunnable preloadRunnable = new PreloadRunnable(this);
        Handler mainHandler = getMainHandler();
        if (mainHandler != null) {
            mainHandler.postDelayed(preloadRunnable, 30000L);
        }
        this.preloadRunnable = preloadRunnable;
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        Handler mainHandler;
        Runnable runnable = this.preloadRunnable;
        if (runnable != null && (mainHandler = getMainHandler()) != null) {
            mainHandler.removeCallbacks(runnable);
        }
        MessageQueue.IdleHandler idleHandler = this.preloadIdleHandler;
        if (idleHandler != null) {
            Looper.myQueue().removeIdleHandler(idleHandler);
        }
        super.onPartDestroy(activity);
    }
}
