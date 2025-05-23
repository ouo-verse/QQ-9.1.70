package com.tencent.mobileqq.troop.homework.common.widget.mediaedit.adapter.delegate;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.AudioItem;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.view.HWMediaUploadStateView;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.view.HWPlayerSeekBar;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014J*\u0010\u000f\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0014R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010!\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010#\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010 \u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/adapter/delegate/AudioSection;", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/adapter/delegate/BaseMediaEditSection;", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/AudioItem;", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "onInitView", "data", "", "position", "", "", "payload", "v", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "delIv", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/view/HWMediaUploadStateView;", tl.h.F, "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/view/HWMediaUploadStateView;", "progressView", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/view/HWPlayerSeekBar;", "i", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/view/HWPlayerSeekBar;", "playerBar", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/AudioItem;", "curItem", BdhLogUtil.LogTag.Tag_Conn, "I", "paddingHor", "D", "paddingBt", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class AudioSection extends BaseMediaEditSection<AudioItem> {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    private final int paddingHor;

    /* renamed from: D, reason: from kotlin metadata */
    private final int paddingBt;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView delIv;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private HWMediaUploadStateView progressView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private HWPlayerSeekBar playerBar;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AudioItem curItem;

    public AudioSection() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.paddingHor = ViewUtils.dip2px(16.0f);
            this.paddingBt = ViewUtils.dip2px(16.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(AudioSection this$0, View this_apply, View view) {
        Activity activity;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        AudioItem audioItem = this$0.curItem;
        if (audioItem != null) {
            qs2.a q16 = this$0.q();
            Context context = this_apply.getContext();
            if (context instanceof Activity) {
                activity = (Activity) context;
            } else {
                activity = null;
            }
            q16.m(audioItem, activity);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(AudioSection this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AudioItem audioItem = this$0.curItem;
        if (audioItem != null) {
            this$0.q().y(audioItem);
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
        return new int[]{R.id.f1190675u};
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
            int i3 = this.paddingHor;
            containerView.setPadding(i3, 0, i3, this.paddingBt);
            View findViewById = containerView.findViewById(R.id.xwi);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.item_player_seekbar)");
            HWPlayerSeekBar hWPlayerSeekBar = (HWPlayerSeekBar) findViewById;
            this.playerBar = hWPlayerSeekBar;
            ImageView imageView = null;
            if (hWPlayerSeekBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("playerBar");
                hWPlayerSeekBar = null;
            }
            hWPlayerSeekBar.a().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.homework.common.widget.mediaedit.adapter.delegate.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AudioSection.w(AudioSection.this, containerView, view);
                }
            });
            View findViewById2 = containerView.findViewById(R.id.xwq);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.item_progress_view)");
            HWMediaUploadStateView hWMediaUploadStateView = (HWMediaUploadStateView) findViewById2;
            this.progressView = hWMediaUploadStateView;
            if (hWMediaUploadStateView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("progressView");
                hWMediaUploadStateView = null;
            }
            hWMediaUploadStateView.setOnRetryClickListener(new Function0<Unit>() { // from class: com.tencent.mobileqq.troop.homework.common.widget.mediaedit.adapter.delegate.AudioSection$onInitView$1$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AudioSection.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AudioItem audioItem;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    audioItem = AudioSection.this.curItem;
                    if (audioItem != null) {
                        AudioSection.this.q().j(audioItem);
                    }
                }
            });
            View findViewById3 = containerView.findViewById(R.id.xt7);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.item_del_iv)");
            ImageView imageView2 = (ImageView) findViewById3;
            this.delIv = imageView2;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("delIv");
            } else {
                imageView = imageView2;
            }
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.homework.common.widget.mediaedit.adapter.delegate.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AudioSection.x(AudioSection.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable AudioItem data, int position, @Nullable List<Object> payload) {
        HWMediaUploadStateView hWMediaUploadStateView;
        long coerceAtMost;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, data, Integer.valueOf(position), payload);
            return;
        }
        if (data == null) {
            return;
        }
        this.curItem = data;
        ImageView imageView = this.delIv;
        HWPlayerSeekBar hWPlayerSeekBar = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("delIv");
            imageView = null;
        }
        if (!data.isSupportDelete()) {
            i3 = 8;
        }
        imageView.setVisibility(i3);
        HWMediaUploadStateView hWMediaUploadStateView2 = this.progressView;
        if (hWMediaUploadStateView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressView");
            hWMediaUploadStateView = null;
        } else {
            hWMediaUploadStateView = hWMediaUploadStateView2;
        }
        HWMediaUploadStateView.e(hWMediaUploadStateView, data.getState(), data.getProgress(), 0, 4, null);
        HWPlayerSeekBar hWPlayerSeekBar2 = this.playerBar;
        if (hWPlayerSeekBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playerBar");
            hWPlayerSeekBar2 = null;
        }
        hWPlayerSeekBar2.setMax((int) data.getCountTime());
        HWPlayerSeekBar hWPlayerSeekBar3 = this.playerBar;
        if (hWPlayerSeekBar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playerBar");
            hWPlayerSeekBar3 = null;
        }
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(data.getPlayCountTime(), data.getCountTime());
        hWPlayerSeekBar3.setProgress((int) coerceAtMost);
        HWPlayerSeekBar hWPlayerSeekBar4 = this.playerBar;
        if (hWPlayerSeekBar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playerBar");
        } else {
            hWPlayerSeekBar = hWPlayerSeekBar4;
        }
        hWPlayerSeekBar.c(data.isPlaying());
    }
}
