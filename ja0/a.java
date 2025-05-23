package ja0;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.output.QCircleWinkOutputRouter;
import com.tencent.mobileqq.winkpublish.TaskInfo;
import com.tencent.mobileqq.winkpublish.WinkPublishHelper2;
import com.tencent.mobileqq.winkpublish.WinkPublishServiceProxy2;
import com.tencent.mobileqq.winkpublish.model.params.FeedParams;
import com.tencent.mobileqq.winkpublish.model.params.ImageParams;
import com.tencent.mobileqq.winkpublish.model.params.NetVideoParams;
import com.tencent.mobileqq.winkpublish.model.params.WinkPublishParams;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.mobileqq.winkreport.datong.WinkNativeSessionManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import com.tencent.tmassistantbase.common.TMAssistantDownloadErrorCode;
import cooperation.qqcircle.report.QCircleLpReportDc05494;
import cooperation.qqcircle.report.QCirclePublishQualityReporter;
import feedcloud.FeedCloudMeta$StImage;
import feedcloud.FeedCloudMeta$StVideo;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v4.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001c\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\bH\u0002J\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\bJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0010\u001a\u00020\bJ(\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015J\u000e\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u0018\u00a8\u0006\u001d"}, d2 = {"Lja0/a;", "", "Lfeedcloud/FeedCloudMeta$StVideo;", "feedVideo", "Lfeedcloud/FeedCloudMeta$StImage;", "feedCover", "Lcom/tencent/mobileqq/winkpublish/model/params/NetVideoParams;", "a", "", "cameraSessionId", "Ljava/util/HashMap;", "c", "b", "avatarPath", "", "f", QQWinkConstants.COVER_PATH, "Lcom/tencent/mobileqq/winkpublish/TaskInfo;", "g", "Lcom/tencent/mobileqq/winkpublish/model/params/FeedParams;", "feedParams", "Landroid/os/Bundle;", "transParams", "e", "Landroid/content/Context;", "context", "d", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f409680a = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"ja0/a$a", "Lcom/tencent/mobileqq/winkpublish/WinkPublishHelper2$Callback;", "Lcom/tencent/mobileqq/winkpublish/WinkPublishServiceProxy2;", "service", "", "onServiceConnected", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ja0.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C10579a implements WinkPublishHelper2.Callback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WinkPublishParams f409681a;

        C10579a(WinkPublishParams winkPublishParams) {
            this.f409681a = winkPublishParams;
        }

        @Override // com.tencent.mobileqq.winkpublish.WinkPublishHelper2.Callback
        public void onServiceConnected(@NotNull WinkPublishServiceProxy2 service) {
            Intrinsics.checkNotNullParameter(service, "service");
            service.addTask(this.f409681a);
        }
    }

    a() {
    }

    private final NetVideoParams a(FeedCloudMeta$StVideo feedVideo, FeedCloudMeta$StImage feedCover) {
        boolean z16;
        if (RFWApplication.isDebug()) {
            String str = feedVideo.fileId.get();
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                throw new IllegalArgumentException("missing feed video id");
            }
        }
        String str2 = feedVideo.fileId.get();
        String str3 = feedVideo.videoMD5.get();
        int i3 = feedVideo.width.get();
        int i16 = feedVideo.height.get();
        long j3 = feedVideo.fileSize.get();
        long j16 = feedVideo.duration.get();
        String str4 = feedCover.picUrl.get();
        int i17 = feedCover.width.get();
        int i18 = feedCover.height.get();
        Intrinsics.checkNotNullExpressionValue(str2, "get()");
        Intrinsics.checkNotNullExpressionValue(str4, "get()");
        Intrinsics.checkNotNullExpressionValue(str3, "get()");
        return new NetVideoParams(str2, i3, i16, j3, 0L, str4, i17, i18, j16, str3);
    }

    private final String b() {
        String str;
        Object obj = WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_SESSION_ID);
        if (obj instanceof String) {
            str = (String) obj;
        } else {
            str = null;
        }
        if (str != null && !Intrinsics.areEqual(str, "none")) {
            return str;
        }
        String cameraSessionId = WinkNativeSessionManager.g().getCameraSessionId();
        Intrinsics.checkNotNullExpressionValue(cameraSessionId, "g().cameraSessionId");
        return cameraSessionId;
    }

    private final HashMap<String, String> c(String cameraSessionId) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_SESSION_ID, cameraSessionId);
        return hashMap;
    }

    public final void d(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent intent = new Intent();
        intent.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
        intent.setData(Uri.parse(QCircleWinkOutputRouter.JUMP_TO_FOLDER_SCHEMA));
        context.startActivity(intent);
    }

    public final void e(@NotNull FeedCloudMeta$StVideo feedVideo, @NotNull FeedCloudMeta$StImage feedCover, @NotNull FeedParams feedParams, @Nullable Bundle transParams) {
        List listOf;
        Intrinsics.checkNotNullParameter(feedVideo, "feedVideo");
        Intrinsics.checkNotNullParameter(feedCover, "feedCover");
        Intrinsics.checkNotNullParameter(feedParams, "feedParams");
        NetVideoParams a16 = a(feedVideo, feedCover);
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        HashMap<String, String> requestExtInfo = feedParams.getRequestExtInfo();
        requestExtInfo.put(QCircleLpReportDc05494.KEY_UP_TYPE, "0");
        requestExtInfo.put("up_source", "0");
        requestExtInfo.put(b.CLIENTKEY, uuid);
        String b16 = b();
        QLog.i("OneClickPublishingHelper", 1, "[publish] cameraSessionId=" + b16);
        String traceId = QCirclePublishQualityReporter.getTraceId();
        listOf = CollectionsKt__CollectionsJVMKt.listOf(a16);
        HashMap<String, String> c16 = c(b16);
        Intrinsics.checkNotNullExpressionValue(traceId, "getTraceId()");
        WinkPublishHelper2.INSTANCE.bindService(1, new C10579a(new WinkPublishParams(1, uuid, traceId, false, 23, listOf, null, feedParams, transParams, c16, 72, null)));
    }

    public final void f(@NotNull String avatarPath) {
        List listOf;
        Intrinsics.checkNotNullParameter(avatarPath, "avatarPath");
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        String traceId = QCirclePublishQualityReporter.getTraceId();
        Intrinsics.checkNotNullExpressionValue(traceId, "getTraceId()");
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new ImageParams(avatarPath, 0, 0, 0, 0L, 0, 0, 0L, null, null, MiniReportManager.EventId.SDK_EMBEDDED_VIDEO, null));
        WinkPublishParams winkPublishParams = new WinkPublishParams(3, uuid, traceId, false, 23, listOf, null, null, null, null, 968, null);
        WinkPublishServiceProxy2 service = WinkPublishHelper2.INSTANCE.getService(3);
        if (service != null) {
            service.addTask(winkPublishParams);
        }
    }

    @Nullable
    public final TaskInfo g(@NotNull String coverPath) {
        List listOf;
        Intrinsics.checkNotNullParameter(coverPath, "coverPath");
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        String traceId = QCirclePublishQualityReporter.getTraceId();
        Intrinsics.checkNotNullExpressionValue(traceId, "getTraceId()");
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new ImageParams(coverPath, 0, 0, 0, 0L, 0, 0, 0L, null, null, MiniReportManager.EventId.SDK_EMBEDDED_VIDEO, null));
        Bundle bundle = new Bundle();
        bundle.putInt(com.tencent.mobileqq.qcircle.api.constant.a.f261590o, 1);
        Unit unit = Unit.INSTANCE;
        WinkPublishParams winkPublishParams = new WinkPublishParams(11, uuid, traceId, false, 23, listOf, null, null, bundle, null, TMAssistantDownloadErrorCode.DOWNLOAD_ERR_KNOWN_LENGTH_CHECK_ERROR, null);
        WinkPublishServiceProxy2 service = WinkPublishHelper2.INSTANCE.getService(11);
        if (service != null) {
            return service.addTask(winkPublishParams);
        }
        return null;
    }
}
