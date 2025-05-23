package com.qzone.reborn.intimate.part;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import com.qzone.reborn.intimate.event.QZIntimateShowCheckInRemindDialogEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.richframework.widget.RoundCornerImageView;
import com.tencent.biz.qqcircle.richframework.widget.RoundCorneredFrameLayout;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 22\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u00013B\u0007\u00a2\u0006\u0004\b0\u00101J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\u001c\u0010\u000e\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u001c\u0010\u0017\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u0019\u001a\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003H\u0016J\u0014\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001b0\u001aH\u0016R\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.\u00a8\u00064"}, d2 = {"Lcom/qzone/reborn/intimate/part/q;", "Lcom/qzone/reborn/base/k;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "D9", "E9", "G9", "", "isPartEnable", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "action", "", "args", "handleBroadcastMessage", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "Landroid/app/Dialog;", "d", "Landroid/app/Dialog;", "dialog", "e", "Landroid/view/View;", "contentView", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredFrameLayout;", "f", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCorneredFrameLayout;", "remindContainer", "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCornerImageView;", tl.h.F, "Lcom/tencent/biz/qqcircle/richframework/widget/RoundCornerImageView;", "remindImg", "Landroid/widget/ImageView;", "i", "Landroid/widget/ImageView;", "closeBtn", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class q extends com.qzone.reborn.base.k implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Dialog dialog;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View contentView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private RoundCorneredFrameLayout remindContainer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private RoundCornerImageView remindImg;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView closeBtn;

    private final void D9() {
        ReportDialog reportDialog = new ReportDialog(getContext());
        this.dialog = reportDialog;
        reportDialog.setCanceledOnTouchOutside(false);
        Dialog dialog = this.dialog;
        Dialog dialog2 = null;
        if (dialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialog");
            dialog = null;
        }
        Window window = dialog.getWindow();
        if (window != null) {
            window.requestFeature(1);
        }
        Dialog dialog3 = this.dialog;
        if (dialog3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialog");
            dialog3 = null;
        }
        Window window2 = dialog3.getWindow();
        if (window2 != null) {
            window2.setFlags(1024, 1024);
        }
        Dialog dialog4 = this.dialog;
        if (dialog4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialog");
            dialog4 = null;
        }
        Window window3 = dialog4.getWindow();
        if (window3 != null) {
            window3.setBackgroundDrawable(new ColorDrawable(0));
        }
        Dialog dialog5 = this.dialog;
        if (dialog5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialog");
        } else {
            dialog2 = dialog5;
        }
        Window window4 = dialog2.getWindow();
        if (window4 != null) {
            WindowManager.LayoutParams attributes = window4.getAttributes();
            attributes.gravity = 80;
            window4.setAttributes(attributes);
        }
    }

    private final void E9() {
        Context context = getContext();
        RoundCornerImageView roundCornerImageView = this.remindImg;
        if (roundCornerImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("remindImg");
            roundCornerImageView = null;
        }
        com.qzone.reborn.util.h.i(context, roundCornerImageView, "https://qzonestyle.gtimg.cn/qzone/client/intimate_space/publicity/checkin-push.png", ef.d.b(317), ef.d.b(161));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(q this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Dialog dialog = this$0.dialog;
        if (dialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialog");
            dialog = null;
        }
        dialog.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void G9() {
        if (!com.qzone.reborn.util.i.b().d("key_enable_show_check_in_remind_dialog", true)) {
            QLog.i("QZIntimateOpenCheckInRemindDialog", 1, "has shown before");
            return;
        }
        Dialog dialog = this.dialog;
        Dialog dialog2 = null;
        if (dialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialog");
            dialog = null;
        }
        View view = this.contentView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
            view = null;
        }
        dialog.setContentView(view);
        E9();
        Dialog dialog3 = this.dialog;
        if (dialog3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dialog");
        } else {
            dialog2 = dialog3;
        }
        if (ef.d.e(dialog2, getActivity())) {
            com.qzone.reborn.util.i.b().l("key_enable_show_check_in_remind_dialog", false);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String action, Object args) {
        super.handleBroadcastMessage(action, args);
        if (TextUtils.equals(action, "INTIMATE_SHOW_CHECK_IN_REMIND_DIALOG")) {
            G9();
        }
    }

    @Override // com.qzone.reborn.base.k, com.tencent.biz.richframework.part.Part
    public boolean isPartEnable() {
        return super.isPartEnable() && com.qzone.reborn.util.i.b().d("key_enable_show_check_in_remind_dialog", true);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        D9();
        RoundCornerImageView roundCornerImageView = null;
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.ckc, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context)\n          \u2026k_in_remind_dialog, null)");
        this.contentView = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
            inflate = null;
        }
        View findViewById = inflate.findViewById(R.id.n4k);
        Intrinsics.checkNotNullExpressionValue(findViewById, "contentView.findViewById\u2026mate_check_in_remind_img)");
        this.remindImg = (RoundCornerImageView) findViewById;
        View view = this.contentView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
            view = null;
        }
        View findViewById2 = view.findViewById(R.id.n4j);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "contentView.findViewById\u2026heck_in_remind_container)");
        this.remindContainer = (RoundCorneredFrameLayout) findViewById2;
        View view2 = this.contentView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentView");
            view2 = null;
        }
        View findViewById3 = view2.findViewById(R.id.f19706e);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "contentView.findViewById(R.id.close_btn)");
        ImageView imageView = (ImageView) findViewById3;
        this.closeBtn = imageView;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeBtn");
            imageView = null;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.intimate.part.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                q.F9(q.this, view3);
            }
        });
        RoundCorneredFrameLayout roundCorneredFrameLayout = this.remindContainer;
        if (roundCorneredFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("remindContainer");
            roundCorneredFrameLayout = null;
        }
        roundCorneredFrameLayout.setRadius(ef.d.b(8));
        RoundCornerImageView roundCornerImageView2 = this.remindImg;
        if (roundCornerImageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("remindImg");
        } else {
            roundCornerImageView = roundCornerImageView2;
        }
        roundCornerImageView.setCorner(ef.d.b(8));
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        if (event instanceof QZIntimateShowCheckInRemindDialogEvent) {
            G9();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QZIntimateShowCheckInRemindDialogEvent.class);
        return arrayListOf;
    }
}
