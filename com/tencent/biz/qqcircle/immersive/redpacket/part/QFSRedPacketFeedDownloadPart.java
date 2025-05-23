package com.tencent.biz.qqcircle.immersive.redpacket.part;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.immersive.redpacket.bean.QFSRedPacketPreviewBean;
import com.tencent.biz.qqcircle.immersive.redpacket.task.DownloadVideoData;
import com.tencent.biz.qqcircle.immersive.redpacket.task.ErrorCode;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.widgets.dialog.QCircleLoadingDialog;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 '2\u00020\u0001:\u0001(B\u0007\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u0014\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u000eH\u0002J\b\u0010\u0010\u001a\u00020\u0002H\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0002J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0007H\u0002J\u001c\u0010\u0017\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u001a\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016R\u001b\u0010 \u001a\u00020\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006)"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/redpacket/part/QFSRedPacketFeedDownloadPart;", "Lcom/tencent/biz/qqcircle/bizparts/b;", "", "C9", "Lfeedcloud/FeedCloudMeta$StFeed;", "feed", "L9", "", "filePath", "G9", "F9", "localVideoPath", "stFeed", "I9", "Ljava/util/HashMap;", "D9", "J9", "H9", "message", "K9", "action", "", "args", "handleBroadcastMessage", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Lcom/tencent/biz/qqcircle/widgets/dialog/QCircleLoadingDialog;", "d", "Lkotlin/Lazy;", "E9", "()Lcom/tencent/biz/qqcircle/widgets/dialog/QCircleLoadingDialog;", "loadingDialog", "Lcom/tencent/biz/qqcircle/immersive/redpacket/task/j;", "e", "Lcom/tencent/biz/qqcircle/immersive/redpacket/task/j;", "downloadVideoTask", "<init>", "()V", "f", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSRedPacketFeedDownloadPart extends com.tencent.biz.qqcircle.bizparts.b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy loadingDialog;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.biz.qqcircle.immersive.redpacket.task.j downloadVideoTask;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/biz/qqcircle/immersive/redpacket/part/QFSRedPacketFeedDownloadPart$b", "Lcom/tencent/biz/qqcircle/immersive/redpacket/task/o;", "Lcom/tencent/biz/qqcircle/immersive/redpacket/task/h;", "value", "", "b", "Lcom/tencent/biz/qqcircle/immersive/redpacket/task/k;", "errorCode", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b implements com.tencent.biz.qqcircle.immersive.redpacket.task.o<DownloadVideoData> {
        b() {
        }

        @Override // com.tencent.biz.qqcircle.immersive.redpacket.task.o
        public void a(@NotNull ErrorCode errorCode) {
            Intrinsics.checkNotNullParameter(errorCode, "errorCode");
            QLog.d("QFSRedPacketFeedDownloadPart", 1, "startDownload, onError, errorCode:" + errorCode);
            QFSRedPacketFeedDownloadPart.this.F9();
        }

        @Override // com.tencent.biz.qqcircle.immersive.redpacket.task.o
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@NotNull DownloadVideoData value) {
            Intrinsics.checkNotNullParameter(value, "value");
            boolean z16 = true;
            QLog.d("QFSRedPacketFeedDownloadPart", 1, "startDownload, onSuccess, value:" + value);
            String filePath = value.getFilePath();
            if (filePath != null && filePath.length() != 0) {
                z16 = false;
            }
            if (z16) {
                QFSRedPacketFeedDownloadPart.this.F9();
            } else {
                QFSRedPacketFeedDownloadPart.this.G9(filePath, value.getFeed());
            }
        }
    }

    public QFSRedPacketFeedDownloadPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new QFSRedPacketFeedDownloadPart$loadingDialog$2(this));
        this.loadingDialog = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C9() {
        com.tencent.biz.qqcircle.immersive.redpacket.task.j jVar = this.downloadVideoTask;
        if (jVar != null) {
            jVar.f();
        }
    }

    private final HashMap<String, String> D9() {
        Activity activity;
        Serializable serializable;
        QCircleInitBean qCircleInitBean;
        Intent intent;
        Context context = getContext();
        HashMap<String, String> hashMap = null;
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (activity != null && (intent = activity.getIntent()) != null) {
            serializable = intent.getSerializableExtra("key_bundle_common_init_bean");
        } else {
            serializable = null;
        }
        if (serializable instanceof QCircleInitBean) {
            qCircleInitBean = (QCircleInitBean) serializable;
        } else {
            qCircleInitBean = null;
        }
        if (qCircleInitBean != null) {
            hashMap = qCircleInitBean.getSchemeAttrs();
        }
        if (hashMap == null) {
            return new HashMap<>();
        }
        return hashMap;
    }

    private final QCircleLoadingDialog E9() {
        return (QCircleLoadingDialog) this.loadingDialog.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F9() {
        H9();
        String string = getContext().getString(R.string.f194624ce);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026ket_download_feed_failed)");
        K9(string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G9(String filePath, FeedCloudMeta$StFeed feed) {
        H9();
        I9(filePath, feed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H9() {
        E9().dismiss();
    }

    private final void I9(String localVideoPath, FeedCloudMeta$StFeed stFeed) {
        Context context = getContext();
        QFSRedPacketPreviewBean qFSRedPacketPreviewBean = new QFSRedPacketPreviewBean(localVideoPath, null, 2, null);
        qFSRedPacketPreviewBean.setFeed(stFeed);
        qFSRedPacketPreviewBean.setSchemeAttrs(D9());
        com.tencent.biz.qqcircle.launcher.c.v0(context, qFSRedPacketPreviewBean);
    }

    private final void J9() {
        E9().showDialog();
    }

    private final void K9(String message) {
        QCircleToast.p(message, 0, true);
    }

    private final void L9(FeedCloudMeta$StFeed feed) {
        QLog.d("QFSRedPacketFeedDownloadPart", 1, "startDownload ");
        J9();
        C9();
        com.tencent.biz.qqcircle.immersive.redpacket.task.j jVar = new com.tencent.biz.qqcircle.immersive.redpacket.task.j();
        this.downloadVideoTask = jVar;
        jVar.n(new DownloadVideoData(feed, null, null, 6, null), new b());
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        if (Intrinsics.areEqual(action, "EVENT_DOWNLOAD_FEED") && (args instanceof FeedCloudMeta$StFeed)) {
            L9((FeedCloudMeta$StFeed) args);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        C9();
    }
}
