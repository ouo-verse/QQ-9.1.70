package com.tencent.mobileqq.activity.ntcompat;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.msg.api.IAIOMsgItemApi;
import com.tencent.qqnt.textpreview.PreviewTextContainerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "foldMsgItem", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes10.dex */
public final class TextPreviewNTFoldCompat$handleNTFoldMsgUI$1 extends Lambda implements Function1<AIOMsgItem, Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ Activity $activity;
    final /* synthetic */ PreviewTextContainerView $containerView;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextPreviewNTFoldCompat$handleNTFoldMsgUI$1(Activity activity, PreviewTextContainerView previewTextContainerView) {
        super(1);
        this.$activity = activity;
        this.$containerView = previewTextContainerView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity, (Object) previewTextContainerView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(PreviewTextContainerView containerView, CharSequence charSequence, final Activity activity) {
        Intrinsics.checkNotNullParameter(containerView, "$containerView");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        containerView.h().setText(new QQText(charSequence, 45, 30));
        containerView.setDispatchTouchToTv(false);
        containerView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.ntcompat.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TextPreviewNTFoldCompat$handleNTFoldMsgUI$1.d(activity, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Activity activity, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(activity, "$activity");
        if (!activity.isFinishing()) {
            activity.finish();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(AIOMsgItem aIOMsgItem) {
        invoke2(aIOMsgItem);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull AIOMsgItem foldMsgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) foldMsgItem);
            return;
        }
        Intrinsics.checkNotNullParameter(foldMsgItem, "foldMsgItem");
        if (new WeakReference(this.$activity).get() == 0) {
            return;
        }
        final CharSequence previewText = ((IAIOMsgItemApi) QRoute.api(IAIOMsgItemApi.class)).getPreviewText(this.$activity, foldMsgItem);
        if (QLog.isColorLevel()) {
            QLog.d("TextPreviewNTCompat", 2, "msg ssb " + ((Object) previewText));
        }
        final Activity activity = this.$activity;
        final PreviewTextContainerView previewTextContainerView = this.$containerView;
        activity.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.activity.ntcompat.b
            @Override // java.lang.Runnable
            public final void run() {
                TextPreviewNTFoldCompat$handleNTFoldMsgUI$1.c(PreviewTextContainerView.this, previewText, activity);
            }
        });
    }
}
