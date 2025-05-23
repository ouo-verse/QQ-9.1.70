package com.tencent.sqshow.zootopia.player.preload;

import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.engineering.preload.BasePreLoadTask;
import com.tencent.mobileqq.engineering.preload.PreLoader;
import com.tencent.mobileqq.engineering.preload.inter.OnPreLoadListener;
import com.tencent.mobileqq.engineering.preload.inter.OnTaskListener;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.data.ZootopiaDetailFeedsCardData;
import com.tencent.sqshow.zootopia.player.preload.VideoPlayerPreLoadManager;
import com.tencent.sqshow.zootopia.player.q;
import com.tencent.superplayer.view.ISPlayerVideoView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import na4.d;
import tl.h;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 *2\u00020\u0001:\u0007+\u001f\"*,\u000e-B\u0007\u00a2\u0006\u0004\b(\u0010)J*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J$\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u000e\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0004H\u0002J\u0006\u0010\u0011\u001a\u00020\bJ\u0016\u0010\u0015\u001a\u00020\n2\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012J\u001e\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0004J\u0010\u0010\u001b\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004J\b\u0010\u001c\u001a\u00020\nH\u0007R \u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001e0\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R(\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'\u00a8\u0006."}, d2 = {"Lcom/tencent/sqshow/zootopia/player/preload/VideoPlayerPreLoadManager;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "currentFieldId", "Lcom/tencent/sqshow/zootopia/player/f;", "options", "", "isMultiLevel", "", "k", "f", "currentRenderKey", "d", "renderKey", h.F, "j", "Ljava/util/ArrayList;", "Lcom/tencent/sqshow/zootopia/data/g;", "data", "p", "", "position", "o", "fieldId", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/sqshow/zootopia/player/preload/VideoPlayerPreLoadManager$c;", "a", "Ljava/util/concurrent/ConcurrentHashMap;", "renderPlayerMap", "b", "Ljava/util/ArrayList;", "g", "()Ljava/util/ArrayList;", DomainData.DOMAIN_NAME, "(Ljava/util/ArrayList;)V", "<init>", "()V", "c", "AttachRunnable", "RemoveRunnable", "e", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class VideoPlayerPreLoadManager {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name */
    private static final VideoPlayerPreLoadManager f372245d = new VideoPlayerPreLoadManager();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ConcurrentHashMap<String, c> renderPlayerMap = new ConcurrentHashMap<>();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public ArrayList<ZootopiaDetailFeedsCardData> data;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/sqshow/zootopia/player/preload/VideoPlayerPreLoadManager$AttachRunnable;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "Ljava/lang/ref/WeakReference;", "Landroid/view/ViewGroup;", "d", "Ljava/lang/ref/WeakReference;", "mDecorView", "Landroid/view/View;", "e", "mVideoView", "Lcom/tencent/sqshow/zootopia/player/f;", "f", "Lcom/tencent/sqshow/zootopia/player/f;", "mOption", "decorView", "videoView", "options", "<init>", "(Landroid/view/ViewGroup;Landroid/view/View;Lcom/tencent/sqshow/zootopia/player/f;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class AttachRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<ViewGroup> mDecorView;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<View> mVideoView;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final com.tencent.sqshow.zootopia.player.f mOption;

        public AttachRunnable(ViewGroup decorView, View videoView, com.tencent.sqshow.zootopia.player.f fVar) {
            Intrinsics.checkNotNullParameter(decorView, "decorView");
            Intrinsics.checkNotNullParameter(videoView, "videoView");
            this.mDecorView = new WeakReference<>(decorView);
            this.mVideoView = new WeakReference<>(videoView);
            this.mOption = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewGroup viewGroup = this.mDecorView.get();
            View view = this.mVideoView.get();
            if (viewGroup == null || view == null || this.mOption == null || view.getParent() != null) {
                return;
            }
            viewGroup.addView(view, 0, 0);
            QLog.d("VideoPlayerPreLoadManager", 1, "add to target decorView");
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/sqshow/zootopia/player/preload/VideoPlayerPreLoadManager$RemoveRunnable;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "Ljava/lang/ref/WeakReference;", "Landroid/view/ViewGroup;", "d", "Ljava/lang/ref/WeakReference;", "mDecorView", "Landroid/view/View;", "e", "mVideoView", "Lcom/tencent/sqshow/zootopia/player/f;", "f", "Lcom/tencent/sqshow/zootopia/player/f;", "mOption", "decorView", "videoView", "options", "<init>", "(Landroid/view/ViewGroup;Landroid/view/View;Lcom/tencent/sqshow/zootopia/player/f;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class RemoveRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<ViewGroup> mDecorView;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<View> mVideoView;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final com.tencent.sqshow.zootopia.player.f mOption;

        public RemoveRunnable(ViewGroup decorView, View videoView, com.tencent.sqshow.zootopia.player.f fVar) {
            Intrinsics.checkNotNullParameter(decorView, "decorView");
            Intrinsics.checkNotNullParameter(videoView, "videoView");
            this.mDecorView = new WeakReference<>(decorView);
            this.mVideoView = new WeakReference<>(videoView);
            this.mOption = fVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            ViewGroup viewGroup = this.mDecorView.get();
            View view = this.mVideoView.get();
            if (viewGroup == null || view == 0 || this.mOption == null || view.getParent() != viewGroup) {
                return;
            }
            ((ISPlayerVideoView) view).disableViewCallback();
            viewGroup.removeView(view);
            QLog.d("VideoPlayerPreLoadManager", 1, "remove from target decorView");
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/sqshow/zootopia/player/preload/VideoPlayerPreLoadManager$a;", "", "Lcom/tencent/sqshow/zootopia/player/preload/VideoPlayerPreLoadManager;", "a", "INSTANCE", "Lcom/tencent/sqshow/zootopia/player/preload/VideoPlayerPreLoadManager;", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.player.preload.VideoPlayerPreLoadManager$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final VideoPlayerPreLoadManager a() {
            return VideoPlayerPreLoadManager.f372245d;
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\t\b\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011R$\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\u000f\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/sqshow/zootopia/player/preload/VideoPlayerPreLoadManager$b;", "", "Lcom/tencent/sqshow/zootopia/player/q;", "a", "Lcom/tencent/sqshow/zootopia/player/q;", "()Lcom/tencent/sqshow/zootopia/player/q;", "c", "(Lcom/tencent/sqshow/zootopia/player/q;)V", "player", "", "b", "Z", "()Z", "d", "(Z)V", "isPreloadError", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private q player;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private boolean isPreloadError;

        /* renamed from: a, reason: from getter */
        public final q getPlayer() {
            return this.player;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getIsPreloadError() {
            return this.isPreloadError;
        }

        public final void c(q qVar) {
            this.player = qVar;
        }

        public final void d(boolean z16) {
            this.isPreloadError = z16;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u0012\u0006\u0010\u0013\u001a\u00020\n\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\bR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\b\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/sqshow/zootopia/player/preload/VideoPlayerPreLoadManager$d;", "Lma4/a;", "Lcom/tencent/sqshow/zootopia/player/q;", "player", "", "a", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "Ljava/lang/ref/WeakReference;", "mActivity", "Lcom/tencent/sqshow/zootopia/player/f;", "b", "Lcom/tencent/sqshow/zootopia/player/f;", "mOptions", "Lcom/tencent/sqshow/zootopia/player/preload/VideoPlayerPreLoadManager$c;", "c", "mPreloadTask", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "task", "options", "<init>", "(Landroid/app/Activity;Lcom/tencent/sqshow/zootopia/player/preload/VideoPlayerPreLoadManager$c;Lcom/tencent/sqshow/zootopia/player/f;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements ma4.a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<Activity> mActivity;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final com.tencent.sqshow.zootopia.player.f mOptions;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<c> mPreloadTask;

        public d(Activity activity, c task, com.tencent.sqshow.zootopia.player.f options) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(task, "task");
            Intrinsics.checkNotNullParameter(options, "options");
            this.mActivity = new WeakReference<>(activity);
            this.mOptions = options;
            this.mPreloadTask = new WeakReference<>(task);
        }

        @Override // ma4.a
        public void a(q player) {
            Activity activity = this.mActivity.get();
            c cVar = this.mPreloadTask.get();
            if (activity == null || cVar == null) {
                return;
            }
            cVar.e(activity, player, this.mOptions);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/sqshow/zootopia/player/preload/VideoPlayerPreLoadManager$e;", "Lcom/tencent/superplayer/view/ISPlayerVideoView$IVideoViewCallBack;", "", "o", "", "onSurfaceCreated", "onSurfaceChanged", "onSurfaceDestroy", "Ljava/lang/ref/WeakReference;", "Ljava/lang/Runnable;", "d", "Ljava/lang/ref/WeakReference;", "mRemoveRunnable", "Lcom/tencent/sqshow/zootopia/player/preload/VideoPlayerPreLoadManager$RemoveRunnable;", "removeCallback", "<init>", "(Lcom/tencent/sqshow/zootopia/player/preload/VideoPlayerPreLoadManager$RemoveRunnable;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class e implements ISPlayerVideoView.IVideoViewCallBack {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<Runnable> mRemoveRunnable;

        public e(RemoveRunnable removeRunnable) {
            this.mRemoveRunnable = new WeakReference<>(removeRunnable);
        }

        @Override // com.tencent.superplayer.view.ISPlayerVideoView.IVideoViewCallBack
        public void onSurfaceChanged(Object o16) {
            Intrinsics.checkNotNullParameter(o16, "o");
        }

        @Override // com.tencent.superplayer.view.ISPlayerVideoView.IVideoViewCallBack
        public void onSurfaceCreated(Object o16) {
            Intrinsics.checkNotNullParameter(o16, "o");
            Runnable runnable = this.mRemoveRunnable.get();
            if (runnable == null) {
                return;
            }
            ThreadManagerV2.getUIHandlerV2().post(runnable);
        }

        @Override // com.tencent.superplayer.view.ISPlayerVideoView.IVideoViewCallBack
        public void onSurfaceDestroy(Object o16) {
            Intrinsics.checkNotNullParameter(o16, "o");
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/sqshow/zootopia/player/preload/VideoPlayerPreLoadManager$f", "Lna4/d$b;", "Lcom/tencent/sqshow/zootopia/player/f;", "options", "", "continueNextProcess", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class f implements d.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f372268b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f372269c;

        f(Activity activity, String str) {
            this.f372268b = activity;
            this.f372269c = str;
        }

        @Override // na4.d.b
        public void a(com.tencent.sqshow.zootopia.player.f options, boolean continueNextProcess) {
            Intrinsics.checkNotNullParameter(options, "options");
            QLog.d("VideoPlayerPreLoadManager", 1, "url selected onFinish, selected play url: " + options.f());
            VideoPlayerPreLoadManager.this.f(this.f372268b, options, this.f372269c);
        }
    }

    private final void d(String currentRenderKey) {
        QLog.d("VideoPlayerPreLoadManager", 1, "cleaOldPreloadPlayer, currentRenderKey:" + currentRenderKey);
        Iterator<Map.Entry<String, c>> it = this.renderPlayerMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, c> next = it.next();
            if (!Intrinsics.areEqual(next.getKey(), currentRenderKey)) {
                final String key = next.getKey();
                final c value = next.getValue();
                if (value.getPlayer() != null) {
                    q player = value.getPlayer();
                    if (player != null) {
                        player.L();
                    }
                    value.release();
                    PreLoader.remove(key);
                    QLog.d("VideoPlayerPreLoadManager", 1, "clean from pool, preloadKey: " + key);
                } else if (PreLoader.exists(key)) {
                    QLog.d("VideoPlayerPreLoadManager", 1, "release, key: " + key);
                    PreLoader.addListener(key, new OnTaskListener() { // from class: com.tencent.sqshow.zootopia.player.preload.b
                        @Override // com.tencent.mobileqq.engineering.preload.inter.OnTaskListener
                        public final void onComplete(Object[] objArr) {
                            VideoPlayerPreLoadManager.e(VideoPlayerPreLoadManager.c.this, key, (VideoPlayerPreLoadManager.b[]) objArr);
                        }
                    });
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(c task, String preloadKey, b[] result) {
        b bVar;
        q player;
        Intrinsics.checkNotNullParameter(task, "$task");
        Intrinsics.checkNotNullParameter(preloadKey, "$preloadKey");
        Intrinsics.checkNotNullExpressionValue(result, "result");
        if (!(result.length == 0)) {
            b bVar2 = result[0];
            if ((bVar2 != null ? bVar2.getPlayer() : null) != null && (bVar = result[0]) != null && (player = bVar.getPlayer()) != null) {
                player.L();
            }
        }
        task.release();
        PreLoader.remove(preloadKey);
    }

    private final boolean h(String renderKey) {
        if (TextUtils.isEmpty(renderKey)) {
            return false;
        }
        return this.renderPlayerMap.containsKey(renderKey);
    }

    public final ArrayList<ZootopiaDetailFeedsCardData> g() {
        ArrayList<ZootopiaDetailFeedsCardData> arrayList = this.data;
        if (arrayList != null) {
            return arrayList;
        }
        Intrinsics.throwUninitializedPropertyAccessException("data");
        return null;
    }

    public final boolean i(String fieldId) {
        Intrinsics.checkNotNullParameter(fieldId, "fieldId");
        if (TextUtils.isEmpty(fieldId)) {
            QLog.d("VideoPlayerPreLoadManager", 1, "[Preload] error video");
            return false;
        }
        c cVar = this.renderPlayerMap.get(fieldId);
        QLog.d("VideoPlayerPreLoadManager", 1, "[Preload] video " + cVar + " vid " + fieldId);
        return cVar != null;
    }

    public final boolean j() {
        return true;
    }

    public final void m(String renderKey) {
        QLog.d("VideoPlayerPreLoadManager", 2, "removeKey: renderKey: " + renderKey);
        TypeIntrinsics.asMutableMap(this.renderPlayerMap).remove(renderKey);
        PreLoader.remove(renderKey);
    }

    public final void n(ArrayList<ZootopiaDetailFeedsCardData> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.data = arrayList;
    }

    public final void o(Activity activity, int position, boolean isMultiLevel) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        int i3 = position + 1;
        if (g().size() <= i3) {
            QLog.d("VideoPlayerPreLoadManager", 1, "position + 1 is up total size, position + 1: " + i3 + ", data size: " + g().size() + ", return");
            return;
        }
        ZootopiaDetailFeedsCardData.Companion companion = ZootopiaDetailFeedsCardData.INSTANCE;
        com.tencent.sqshow.zootopia.player.f a16 = companion.a(g().get(i3));
        QLog.d("VideoPlayerPreLoadManager", 1, "triggerPreloadPlayer, server play url: " + a16.d());
        ZootopiaDetailFeedsCardData zootopiaDetailFeedsCardData = g().get(position);
        Intrinsics.checkNotNullExpressionValue(zootopiaDetailFeedsCardData, "data[position]");
        k(activity, companion.i(zootopiaDetailFeedsCardData), a16, isMultiLevel);
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b-\u0010.J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0002H\u0002J\"\u0010\r\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\u0010\u001a\u00020\t2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000eH\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016J\u0006\u0010\u0012\u001a\u00020\tJ\"\u0010\u0015\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0006\u001a\u00020\u0005R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0016R\u0017\u0010\u0004\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u001b\u001a\u0004\b\u0017\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010%\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010,\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+\u00a8\u0006/"}, d2 = {"Lcom/tencent/sqshow/zootopia/player/preload/VideoPlayerPreLoadManager$c;", "Lcom/tencent/mobileqq/engineering/preload/BasePreLoadTask;", "Lcom/tencent/sqshow/zootopia/player/preload/VideoPlayerPreLoadManager$b;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/sqshow/zootopia/player/f;", "options", "d", "result", "", "c", "Lcom/tencent/superplayer/view/ISPlayerVideoView;", "videoView", "a", "Lcom/tencent/mobileqq/engineering/preload/inter/OnPreLoadListener;", "p0", "startLoadData", "onRemove", "release", "Lcom/tencent/sqshow/zootopia/player/q;", "player", "e", "Lcom/tencent/sqshow/zootopia/player/f;", "b", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "Lcom/tencent/sqshow/zootopia/player/q;", "()Lcom/tencent/sqshow/zootopia/player/q;", "setPlayer", "(Lcom/tencent/sqshow/zootopia/player/q;)V", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "getMAddToDecoderRunnable", "()Ljava/lang/Runnable;", "setMAddToDecoderRunnable", "(Ljava/lang/Runnable;)V", "mAddToDecoderRunnable", "Lcom/tencent/sqshow/zootopia/player/preload/VideoPlayerPreLoadManager$RemoveRunnable;", "Lcom/tencent/sqshow/zootopia/player/preload/VideoPlayerPreLoadManager$RemoveRunnable;", "getMRemoveViewRunnable", "()Lcom/tencent/sqshow/zootopia/player/preload/VideoPlayerPreLoadManager$RemoveRunnable;", "setMRemoveViewRunnable", "(Lcom/tencent/sqshow/zootopia/player/preload/VideoPlayerPreLoadManager$RemoveRunnable;)V", "mRemoveViewRunnable", "<init>", "(Lcom/tencent/sqshow/zootopia/player/f;Landroid/app/Activity;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c extends BasePreLoadTask<b> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final com.tencent.sqshow.zootopia.player.f options;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final Activity activity;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private q player;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private Runnable mAddToDecoderRunnable;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private RemoveRunnable mRemoveViewRunnable;

        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/sqshow/zootopia/player/preload/VideoPlayerPreLoadManager$c$a", "Lka4/b;", "Lcom/tencent/sqshow/zootopia/player/q;", "player", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes34.dex */
        public static final class a implements ka4.b {
            a() {
            }

            @Override // ka4.b
            public void a(q player) {
                QLog.d("VideoPlayerPreLoadManager", 1, "onVideoPrepared, player:" + player);
            }
        }

        @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/sqshow/zootopia/player/preload/VideoPlayerPreLoadManager$c$b", "Lka4/a;", "", "module", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, "errorCode", "", "extraInfo", "", "onVideoPlayError", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes34.dex */
        public static final class b implements ka4.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ b f372261a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ com.tencent.sqshow.zootopia.player.f f372262b;

            b(b bVar, com.tencent.sqshow.zootopia.player.f fVar) {
                this.f372261a = bVar;
                this.f372262b = fVar;
            }

            @Override // ka4.a
            public void onVideoPlayError(int module, int errorType, int errorCode, String extraInfo) {
                QLog.d("VideoPlayerPreLoadManager", 1, "onVideoPlayError, preload error, errorType:" + errorType + ", errorCode:" + errorCode + ", extraInfo:" + extraInfo);
                this.f372261a.d(true);
                VideoPlayerPreLoadManager.INSTANCE.a().m(this.f372262b.a());
            }
        }

        public c(com.tencent.sqshow.zootopia.player.f options, Activity activity) {
            Intrinsics.checkNotNullParameter(options, "options");
            Intrinsics.checkNotNullParameter(activity, "activity");
            this.options = options;
            this.activity = activity;
        }

        private final void c(com.tencent.sqshow.zootopia.player.f options, b result) {
            com.tencent.sqshow.zootopia.player.e b16;
            com.tencent.sqshow.zootopia.player.e playerListenerSet = options.getPlayerListenerSet();
            if (playerListenerSet != null) {
                playerListenerSet.c(new d(this.activity, this, options));
            }
            com.tencent.sqshow.zootopia.player.e playerListenerSet2 = options.getPlayerListenerSet();
            if (playerListenerSet2 == null || (b16 = playerListenerSet2.b(new a())) == null) {
                return;
            }
            b16.a(new b(result, options));
        }

        private final b d(Activity activity, com.tencent.sqshow.zootopia.player.f options) {
            b bVar = new b();
            q qVar = new q();
            c(options, bVar);
            qVar.w(options);
            bVar.c(qVar);
            this.player = qVar;
            QLog.d("VideoPlayerPreLoadManager", 1, "innerPreLoadPlayer, player:" + qVar);
            return bVar;
        }

        /* renamed from: b, reason: from getter */
        public final q getPlayer() {
            return this.player;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void e(Activity activity, q player, com.tencent.sqshow.zootopia.player.f options) {
            Intrinsics.checkNotNullParameter(options, "options");
            if (activity != null && player != null) {
                ISPlayerVideoView superPlayerView = player.getSuperPlayerView();
                if (superPlayerView != 0 && ((View) superPlayerView).getParent() == null) {
                    a(activity, superPlayerView, options);
                    return;
                }
                QLog.d("VideoPlayerPreLoadManager", 1, "init render to view return :" + options.d());
                return;
            }
            QLog.d("VideoPlayerPreLoadManager", 1, "init render to view return");
        }

        @Override // com.tencent.mobileqq.engineering.preload.BasePreLoadTask
        public void onRemove() {
            QLog.d("VideoPlayerPreLoadManager", 1, "onRemove, player:" + this.player);
        }

        public final void release() {
            Runnable runnable = this.mAddToDecoderRunnable;
            if (runnable != null) {
                ThreadManagerV2.getUIHandlerV2().removeCallbacks(runnable);
            }
            RemoveRunnable removeRunnable = this.mRemoveViewRunnable;
            if (removeRunnable != null) {
                ThreadManagerV2.getUIHandlerV2().removeCallbacks(removeRunnable);
            }
        }

        @Override // com.tencent.mobileqq.engineering.preload.BasePreLoadTask
        public void startLoadData(OnPreLoadListener<b> p06) {
            QLog.d("VideoPlayerPreLoadManager", 1, "startLoadData");
            if (p06 != null) {
                p06.onLoaded(d(this.activity, this.options));
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        private final void a(Activity activity, ISPlayerVideoView videoView, com.tencent.sqshow.zootopia.player.f options) {
            if (activity == null || activity.isFinishing()) {
                return;
            }
            View decorView = activity.getWindow().getDecorView();
            Intrinsics.checkNotNull(decorView, "null cannot be cast to non-null type android.view.ViewGroup");
            ViewGroup viewGroup = (ViewGroup) decorView;
            Intrinsics.checkNotNull(videoView, "null cannot be cast to non-null type android.view.View");
            RemoveRunnable removeRunnable = new RemoveRunnable(viewGroup, (View) videoView, options);
            this.mRemoveViewRunnable = removeRunnable;
            videoView.addViewCallBack(new e(removeRunnable));
            this.mAddToDecoderRunnable = new AttachRunnable(viewGroup, (View) videoView, options);
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            Runnable runnable = this.mAddToDecoderRunnable;
            Intrinsics.checkNotNull(runnable);
            uIHandlerV2.post(runnable);
        }
    }

    public final void l() {
        QLog.d("VideoPlayerPreLoadManager", 2, "releaseRender,map size: ", Integer.valueOf(this.renderPlayerMap.size()));
        d("-1");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(Activity activity, com.tencent.sqshow.zootopia.player.f options, String currentFieldId) {
        String a16 = options != null ? options.a() : null;
        boolean z16 = false;
        if (a16 != null) {
            if (a16.length() == 0) {
                z16 = true;
            }
        }
        if (z16) {
            QLog.d("VideoPlayerPreLoadManager", 1, "renderKey is empty, return");
            return;
        }
        d(currentFieldId);
        Intrinsics.checkNotNull(a16);
        if (h(a16)) {
            QLog.d("VideoPlayerPreLoadManager", 1, "has same render,return, fieldId: " + a16);
            return;
        }
        c cVar = new c(options, activity);
        this.renderPlayerMap.put(a16, cVar);
        PreLoader.preLoad(a16, cVar);
    }

    public final void p(ArrayList<ZootopiaDetailFeedsCardData> data) {
        if (data != null) {
            n(data);
        }
    }

    private final void k(Activity activity, String currentFieldId, com.tencent.sqshow.zootopia.player.f options, boolean isMultiLevel) {
        boolean z16 = false;
        if (currentFieldId != null) {
            if (currentFieldId.length() == 0) {
                z16 = true;
            }
        }
        if (z16) {
            QLog.d("VideoPlayerPreLoadManager", 1, "renderKey is empty, return");
            return;
        }
        LinkedList<Integer> linkedList = new LinkedList<>();
        if (isMultiLevel) {
            linkedList.add(Integer.valueOf(na4.d.INSTANCE.b()));
        }
        na4.d.INSTANCE.a().j(linkedList, options, new f(activity, currentFieldId));
    }
}
