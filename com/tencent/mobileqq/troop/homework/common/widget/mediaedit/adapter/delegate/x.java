package com.tencent.mobileqq.troop.homework.common.widget.mediaedit.adapter.delegate;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.VideoItem;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.view.HWItemLoadImageView;
import com.tencent.mobileqq.utils.TriggerRunnerKt;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014J*\u0010\u000f\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0014R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/adapter/delegate/x;", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/adapter/delegate/BaseMediaEditSection;", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/VideoItem;", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "onInitView", "data", "", "position", "", "", "payload", "t", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/view/HWItemLoadImageView;", "f", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/view/HWItemLoadImageView;", "videoIv", tl.h.F, "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/VideoItem;", "curItem", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class x extends BaseMediaEditSection<VideoItem> {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private HWItemLoadImageView videoIv;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private VideoItem curItem;

    public x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(x this$0, View this_apply, View view) {
        Activity activity;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        VideoItem videoItem = this$0.curItem;
        if (videoItem != null) {
            qs2.a q16 = this$0.q();
            Context context = this_apply.getContext();
            if (context instanceof Activity) {
                activity = (Activity) context;
            } else {
                activity = null;
            }
            q16.m(videoItem, activity);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (int[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new int[]{R.id.f1194276t};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.troop.homework.common.widget.mediaedit.adapter.delegate.BaseMediaEditSection, com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable final View containerView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) containerView);
            return;
        }
        super.onInitView(containerView);
        if (containerView != null) {
            View findViewById = containerView.findViewById(R.id.xy7);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.item_video_iv)");
            this.videoIv = (HWItemLoadImageView) findViewById;
            View findViewById2 = containerView.findViewById(R.id.xwh);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById<View>(R.id.item_play_icon)");
            TriggerRunnerKt.c(findViewById2, 0L, new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.homework.common.widget.mediaedit.adapter.delegate.w
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    x.u(x.this, containerView, view);
                }
            }, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable VideoItem data, int position, @Nullable List<Object> payload) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, data, Integer.valueOf(position), payload);
            return;
        }
        if (data == null) {
            return;
        }
        this.curItem = data;
        HWItemLoadImageView hWItemLoadImageView = this.videoIv;
        if (hWItemLoadImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("videoIv");
            hWItemLoadImageView = null;
        }
        hWItemLoadImageView.p(data);
    }
}
