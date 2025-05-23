package com.tencent.biz.qqcircle.immersive.datacardcover.widget;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.qqcircle.immersive.datacardcover.widget.QFSPersonalCoverPublishFailedItemView;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.wink.h;
import com.tencent.libra.request.Option;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.winkpublish.TaskInfo;
import com.tencent.mobileqq.winkpublish.WinkPublishHelper2;
import com.tencent.mobileqq.winkpublish.WinkPublishServiceProxy2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import h40.QFSPersonalCoverFeedInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\bH\u0014J\b\u0010\r\u001a\u00020\fH\u0014R\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/datacardcover/widget/QFSPersonalCoverPublishFailedItemView;", "Lcom/tencent/biz/qqcircle/immersive/datacardcover/widget/QFSPersonalCoverBaseItemView;", "Lh40/a;", "coverFeedInfo", "", "r0", "m0", "q0", "", "getLayoutId", c.G, "o0", "", "getLogTag", "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "ivCover", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "e", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSPersonalCoverPublishFailedItemView extends QFSPersonalCoverBaseItemView {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ImageView ivCover;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSPersonalCoverPublishFailedItemView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        q0();
    }

    private final void m0(final QFSPersonalCoverFeedInfo coverFeedInfo) {
        ImageView imageView = this.ivCover;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivCover");
            imageView = null;
        }
        imageView.post(new Runnable() { // from class: k40.h
            @Override // java.lang.Runnable
            public final void run() {
                QFSPersonalCoverPublishFailedItemView.n0(QFSPersonalCoverFeedInfo.this, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(QFSPersonalCoverFeedInfo coverFeedInfo, QFSPersonalCoverPublishFailedItemView this$0) {
        Intrinsics.checkNotNullParameter(coverFeedInfo, "$coverFeedInfo");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Option obtain = Option.obtain();
        obtain.setUrl(coverFeedInfo.getCoverUrl());
        ImageView imageView = this$0.ivCover;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivCover");
            imageView = null;
        }
        obtain.setTargetView(imageView);
        obtain.setRequestWidth(this$0.getMeasuredWidth());
        obtain.setRequestHeight(this$0.getMeasuredHeight());
        obtain.setLoadingDrawableColor(QCircleSkinHelper.getInstance().getColor(R.color.qvideo_skin_color_bg_skeleton));
        QCircleFeedPicLoader.g().loadImage(obtain);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(QFSPersonalCoverPublishFailedItemView this$0, QFSPersonalCoverFeedInfo coverFeedInfo, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(coverFeedInfo, "$coverFeedInfo");
        this$0.r0(coverFeedInfo);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void r0(QFSPersonalCoverFeedInfo coverFeedInfo) {
        Long l3;
        TaskInfo taskInfo = coverFeedInfo.getTaskInfo();
        if (taskInfo != null) {
            l3 = Long.valueOf(taskInfo.getTaskId());
        } else {
            l3 = null;
        }
        QLog.d("QFSPersonalCoverPublishFailedItemView", 1, "retryPublish, taskId: " + l3);
        WinkPublishServiceProxy2 qfsService = WinkPublishHelper2.INSTANCE.getQfsService();
        if (qfsService == null) {
            QLog.w("QFSPersonalCoverPublishFailedItemView", 1, "retryPublish, invalid service");
            QCircleToast.i(QCircleToast.f91644d, R.string.f196574ho, 0);
            h.f93953a.b(getContext(), "0", 23, "-100010", false);
        } else {
            TaskInfo taskInfo2 = coverFeedInfo.getTaskInfo();
            if (taskInfo2 != null) {
                qfsService.resumeTaskWithId(taskInfo2.getTaskId());
            }
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.gkw;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    @NotNull
    public String getLogTag() {
        return "QFSPersonalCoverPublishFailedItemView";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public void bindData(@NotNull final QFSPersonalCoverFeedInfo coverFeedInfo, int pos) {
        Intrinsics.checkNotNullParameter(coverFeedInfo, "coverFeedInfo");
        m0(coverFeedInfo);
        setOnClickListener(new View.OnClickListener() { // from class: k40.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QFSPersonalCoverPublishFailedItemView.p0(QFSPersonalCoverPublishFailedItemView.this, coverFeedInfo, view);
            }
        });
    }

    public void q0() {
        View findViewById = findViewById(R.id.duw);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.iv_cover)");
        this.ivCover = (ImageView) findViewById;
    }
}
