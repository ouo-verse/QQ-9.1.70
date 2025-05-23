package com.tencent.mobileqq.wink.output;

import android.content.Context;
import android.os.Bundle;
import b93.OutputData;
import b93.a;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.event.WinkFinishActivityEvent;
import com.tencent.mobileqq.wink.output.QCircleWinkOutputRouterForH5;
import com.tencent.mobileqq.winkpublish.TaskInfo;
import com.tencent.mobileqq.winkpublish.result.ImageResult;
import com.tencent.mobileqq.winkpublish.result.MediaUploadResult;
import com.tencent.mobileqq.winkpublish.result.VideoResult;
import com.tencent.mobileqq.winkpublish.util.FSToastUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import w53.b;

/* compiled from: P */
@RoutePage(desc = "\u5c0f\u4e16\u754c\u7ec4\u961f\u88c2\u53d8\u4efb\u52a1\u7684\u8f93\u51fa\u8def\u7531", path = QCircleWinkOutputRouterForH5.ROUTE_PATH)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/wink/output/QCircleWinkOutputRouterForH5;", "Lb93/a;", "Landroid/content/Context;", "context", "Landroid/os/Bundle;", "bundle", "", "onBack", "Lb93/b;", "outputData", "onOutput", "<init>", "()V", "Companion", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class QCircleWinkOutputRouterForH5 implements a {

    @NotNull
    public static final String ROUTE_PATH = "/wink/output/h5_fission";

    @NotNull
    public static final String TAG = "QCircleWinkOutputRouterForH5";

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onOutput$lambda$0() {
        SimpleEventBus.getInstance().dispatchEvent(new WinkFinishActivityEvent(false, false, 0, null, 15, null), true);
    }

    @Override // b93.a
    public boolean interceptExitWink() {
        return a.C0112a.a(this);
    }

    @Override // b93.a
    public void onBack(@NotNull Context context, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // b93.a
    public void onOutput(@NotNull Context context, @NotNull OutputData outputData) {
        Object obj;
        String smallUrl;
        String bigUrl;
        String originUrl;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(outputData, "outputData");
        b.f(TAG, "[onOutput] point=" + outputData.getOutputPoint());
        try {
            String p16 = WinkContext.INSTANCE.d().p(QCircleScheme.AttrQQPublish.PUBLISH_TASKID);
            Bundle bundle = outputData.getBundle();
            if (bundle != null) {
                obj = bundle.get(QQWinkConstants.TASKINFO);
            } else {
                obj = null;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.mobileqq.winkpublish.TaskInfo");
            TaskInfo taskInfo = (TaskInfo) obj;
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt(QCircleScheme.AttrQQPublish.PUBLISH_TASKID, p16);
            jSONObject.putOpt("feed_id", taskInfo.getFeedId());
            jSONObject.putOpt(QQWinkConstants.FEEDTIME, Long.valueOf(taskInfo.getFeedTime()));
            MediaUploadResult uploadResult = taskInfo.getMediaInfos().get(0).getUploadResult();
            if (uploadResult instanceof VideoResult) {
                ImageResult coverResult = ((VideoResult) uploadResult).getCoverResult();
                Intrinsics.checkNotNull(coverResult);
                smallUrl = coverResult.getSmallUrl();
            } else {
                Intrinsics.checkNotNull(uploadResult, "null cannot be cast to non-null type com.tencent.mobileqq.winkpublish.result.ImageResult");
                smallUrl = ((ImageResult) uploadResult).getSmallUrl();
            }
            if (uploadResult instanceof VideoResult) {
                ImageResult coverResult2 = ((VideoResult) uploadResult).getCoverResult();
                Intrinsics.checkNotNull(coverResult2);
                bigUrl = coverResult2.getBigUrl();
            } else {
                bigUrl = ((ImageResult) uploadResult).getBigUrl();
            }
            if (uploadResult instanceof VideoResult) {
                ImageResult coverResult3 = ((VideoResult) uploadResult).getCoverResult();
                Intrinsics.checkNotNull(coverResult3);
                originUrl = coverResult3.getOriginUrl();
            } else {
                originUrl = ((ImageResult) uploadResult).getOriginUrl();
            }
            jSONObject.putOpt(QQWinkConstants.COVERSMALLURL, smallUrl);
            jSONObject.putOpt(QQWinkConstants.COVERBIGURL, bigUrl);
            jSONObject.putOpt(QQWinkConstants.COVERORIURL, originUrl);
            QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_QCIRCLE).encodeString(QQWinkConstants.FISSION_KEY + p16, jSONObject.toString());
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: b93.d
                @Override // java.lang.Runnable
                public final void run() {
                    QCircleWinkOutputRouterForH5.onOutput$lambda$0();
                }
            }, 1000L);
        } catch (Exception e16) {
            b.d(TAG, "QCircleWinkOutputRouterForH5 onOutput error", e16);
            FSToastUtil.makeTextAndShow(context.getResources().getString(R.string.f216215xp), 0);
        }
    }
}
