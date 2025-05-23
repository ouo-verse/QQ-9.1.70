package com.tencent.mobileqq.wink.output;

import android.content.Context;
import android.os.Bundle;
import b93.OutputData;
import b93.a;
import com.tencent.biz.qqcircle.beans.QFSCommentPublishFeedAttrBean;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.api.WinkVideoCommentCompleteEvent;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.event.WinkFinishActivityEvent;
import e93.i;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import w53.b;

/* compiled from: P */
@RoutePage(desc = "\u5c0f\u4e16\u754c\u89c6\u9891\u8bc4\u8bba\u8f93\u51fa\u8def\u7531", path = QCircleWinkOutputRouterForVideoComment.ROUTE_PATH)
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J:\u0010\t\u001a\u00020\b2&\u0010\u0005\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u001a\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/wink/output/QCircleWinkOutputRouterForVideoComment;", "Lb93/a;", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "params", "Landroid/os/Bundle;", "bundle", "", "sendVideoCommentCompleteEvent", "Landroid/content/Context;", "context", "onBack", "Lb93/b;", "outputData", "onOutput", "", "selectPic", "Z", "<init>", "()V", "Companion", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class QCircleWinkOutputRouterForVideoComment implements a {

    @NotNull
    public static final String ROUTE_PATH = "/wink/output/videocomment";

    @NotNull
    public static final String TAG = "QCircleWinkOutputRouterForVideoComment";
    private boolean selectPic;

    private final void sendVideoCommentCompleteEvent(HashMap<String, String> params, Bundle bundle) {
        String string;
        String string2;
        String l3;
        this.selectPic = true;
        if (bundle != null && (l3 = Long.valueOf(bundle.getLong(QQWinkConstants.WINK_PUBLISH_PARAM_TASK_ID)).toString()) != null && params != null) {
            params.put(QQWinkConstants.WINK_PUBLISH_PARAM_TASK_ID, l3);
        }
        if (bundle != null && (string2 = bundle.getString(QQWinkConstants.WINK_PUBLISH_PARAM_CONTENT)) != null && params != null) {
            params.put(QQWinkConstants.WINK_PUBLISH_PARAM_CONTENT, string2);
        }
        if (bundle != null && (string = bundle.getString("taskid")) != null && params != null) {
            params.put("taskid", string);
        }
        SimpleEventBus.getInstance().dispatchEvent(new WinkVideoCommentCompleteEvent(params), true);
    }

    @Override // b93.a
    public boolean interceptExitWink() {
        return a.C0112a.a(this);
    }

    @Override // b93.a
    public void onBack(@NotNull Context context, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (!this.selectPic) {
            sendVideoCommentCompleteEvent(WinkContext.INSTANCE.d().r(), bundle);
        }
    }

    @Override // b93.a
    public void onOutput(@NotNull Context context, @NotNull OutputData outputData) {
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(outputData, "outputData");
        b.f(TAG, "[onOutput] point=" + outputData.getOutputPoint());
        HashMap<String, String> r16 = WinkContext.INSTANCE.d().r();
        if (i.I(outputData.e().get(0))) {
            if (r16 != null) {
                r16.put(QQWinkConstants.WINK_PUBLISH_TYPE, "video");
            }
            if (r16 != null) {
                r16.put(QQWinkConstants.WINK_PUBLISH_PARAM_COVER_PATH, outputData.e().get(0).thumbnailPath);
            }
        } else {
            if (r16 != null) {
                if (((int) outputData.getOutputPoint()) == 1) {
                    str = QFSCommentPublishFeedAttrBean.COMMENT_PIC_PUBLISH_TYPE;
                } else {
                    str = "image";
                }
                r16.put(QQWinkConstants.WINK_PUBLISH_TYPE, str);
            }
            if (r16 != null) {
                r16.put(QQWinkConstants.WINK_PUBLISH_PARAM_COVER_PATH, outputData.e().get(0).path);
            }
            if (r16 != null) {
                r16.put(QQWinkConstants.WINK_PUBLISH_PARAM_WIDTH, String.valueOf(outputData.e().get(0).mediaWidth));
            }
            if (r16 != null) {
                r16.put(QQWinkConstants.WINK_PUBLISH_PARAM_HEIGHT, String.valueOf(outputData.e().get(0).mediaHeight));
            }
        }
        sendVideoCommentCompleteEvent(r16, outputData.getBundle());
        SimpleEventBus.getInstance().dispatchEvent(new WinkFinishActivityEvent(false, false, 0, null, 15, null), true);
    }
}
