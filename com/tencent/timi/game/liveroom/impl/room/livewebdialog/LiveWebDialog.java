package com.tencent.timi.game.liveroom.impl.room.livewebdialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqlive.webview.LiveWebDialogEvent;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.common.screen.ScreenUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import com.tencent.timi.game.ui.widget.RoundCornerImageView;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u000f\u0012\u0006\u0010A\u001a\u00020@\u00a2\u0006\u0004\bB\u0010CJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0003H\u0002J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J$\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0015\u001a\u00020\u0004H\u0016J\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016J\u000e\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u001a\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001cJ\u0010\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001fH\u0016J\u000e\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\"J\u0012\u0010&\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010%H\u0016J(\u0010*\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030(\u0018\u00010'j\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030(\u0018\u0001`)H\u0016R\u0014\u0010.\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u0010#\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00105\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010=\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?\u00a8\u0006D"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/livewebdialog/LiveWebDialog;", "Landroidx/fragment/app/DialogFragment;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/mobileqq/qqlive/webview/LiveWebDialogEvent;", "", "initConfig", "", "title", "qh", "event", "", "sh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "onResume", "Lcom/tencent/timi/game/liveroom/impl/room/util/h;", DownloadInfo.spKey_Config, "th", "setTitle", "Lcom/tencent/timi/game/liveroom/impl/room/livewebdialog/LiveWebViewContainer;", "view", "Landroid/widget/FrameLayout$LayoutParams;", "param", "uh", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "Landroid/content/DialogInterface$OnDismissListener;", "listener", "vh", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Landroid/widget/FrameLayout;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/FrameLayout;", "dialogContainer", "D", "Lcom/tencent/timi/game/liveroom/impl/room/util/h;", "E", "Landroid/content/DialogInterface$OnDismissListener;", UserInfo.SEX_FEMALE, "Lcom/tencent/timi/game/liveroom/impl/room/livewebdialog/LiveWebViewContainer;", "webContainer", "Landroid/widget/TextView;", "G", "Landroid/widget/TextView;", "titleView", "Lcom/tencent/timi/game/ui/widget/RoundCornerImageView;", "H", "Lcom/tencent/timi/game/ui/widget/RoundCornerImageView;", "closeView", "I", "Ljava/lang/String;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class LiveWebDialog extends DialogFragment implements SimpleEventReceiver<LiveWebDialogEvent> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final FrameLayout dialogContainer;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private com.tencent.timi.game.liveroom.impl.room.util.h config;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private DialogInterface.OnDismissListener listener;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private LiveWebViewContainer webContainer;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private TextView titleView;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private RoundCornerImageView closeView;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private String title;

    public LiveWebDialog(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.dialogContainer = new FrameLayout(context);
        this.title = "";
    }

    private final void initConfig() {
        com.tencent.timi.game.liveroom.impl.room.util.h hVar;
        int originWidth;
        int originHeight;
        int folderWidth;
        int folderHeight;
        Window window;
        Context context = getContext();
        if (context != null && (hVar = this.config) != null) {
            if (hVar.getIsOriginDp()) {
                originWidth = com.tencent.timi.game.liveroom.impl.room.util.g.b(context, hVar.getOriginWidth());
            } else {
                originWidth = hVar.getOriginWidth();
            }
            if (hVar.getIsOriginDp()) {
                originHeight = com.tencent.timi.game.liveroom.impl.room.util.g.b(context, hVar.getOriginHeight());
            } else {
                originHeight = hVar.getOriginHeight();
            }
            if (hVar.getIsFolderDp()) {
                folderWidth = com.tencent.timi.game.liveroom.impl.room.util.g.b(context, hVar.getFolderWidth());
            } else {
                folderWidth = hVar.getFolderWidth();
            }
            if (hVar.getIsFolderDp()) {
                folderHeight = com.tencent.timi.game.liveroom.impl.room.util.g.b(context, hVar.getFolderHeight());
            } else {
                folderHeight = hVar.getFolderHeight();
            }
            Pair<Integer, Integer> c16 = com.tencent.timi.game.liveroom.impl.room.util.g.c(context, originWidth, originHeight, folderWidth, folderHeight, hVar.getIsSupportFolder());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(c16.getFirst().intValue(), c16.getSecond().intValue());
            layoutParams.gravity = 80;
            this.dialogContainer.setLayoutParams(layoutParams);
            this.dialogContainer.setBackground(new ColorDrawable(hVar.getColor()));
            Dialog dialog = getDialog();
            if (dialog != null && (window = dialog.getWindow()) != null) {
                window.setWindowAnimations(hVar.getAnimationStyle());
            }
            Dialog dialog2 = getDialog();
            if (dialog2 != null) {
                dialog2.setCanceledOnTouchOutside(hVar.getIsOutsideTouchable());
            }
            setCancelable(true);
        }
    }

    private final void qh(String title) {
        if (!TextUtils.isEmpty(title)) {
            View inflate = View.inflate(getContext(), R.layout.hvf, null);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, ViewUtils.dpToPx(32.0f));
            layoutParams.topMargin = ViewUtils.dpToPx(12.0f);
            this.titleView = (TextView) inflate.findViewById(R.id.jq_);
            RoundCornerImageView roundCornerImageView = (RoundCornerImageView) inflate.findViewById(R.id.u0f);
            this.closeView = roundCornerImageView;
            Intrinsics.checkNotNull(roundCornerImageView);
            roundCornerImageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.liveroom.impl.room.livewebdialog.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LiveWebDialog.rh(LiveWebDialog.this, view);
                }
            });
            inflate.setLayoutParams(layoutParams);
            inflate.setVisibility(0);
            TextView textView = this.titleView;
            Intrinsics.checkNotNull(textView);
            textView.setText(title);
            this.dialogContainer.addView(inflate);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void rh(LiveWebDialog this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final boolean sh(LiveWebDialogEvent event) {
        TouchWebView webView;
        if (event.getHashKey() == 0) {
            return true;
        }
        LiveWebViewContainer liveWebViewContainer = this.webContainer;
        if (liveWebViewContainer != null && (webView = liveWebViewContainer.getWebView()) != null && webView.hashCode() == event.getHashKey()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @Nullable
    public ArrayList<Class<LiveWebDialogEvent>> getEventClass() {
        ArrayList<Class<LiveWebDialogEvent>> arrayList = new ArrayList<>();
        arrayList.add(LiveWebDialogEvent.class);
        return arrayList;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(0, R.style.b0s);
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        initConfig();
        qh(this.title);
        SimpleEventBus.getInstance().registerReceiver(this);
        FrameLayout frameLayout = this.dialogContainer;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, frameLayout);
        return frameLayout;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NotNull DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        DialogInterface.OnDismissListener onDismissListener = this.listener;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialog);
        }
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        LiveWebViewContainer liveWebViewContainer;
        if (event instanceof LiveWebDialogEvent) {
            LiveWebDialogEvent liveWebDialogEvent = (LiveWebDialogEvent) event;
            if (liveWebDialogEvent.getCmd().compareTo("hide") == 0 && sh(liveWebDialogEvent)) {
                dismissAllowingStateLoss();
            } else if (liveWebDialogEvent.getCmd().compareTo(UIJsPlugin.EVENT_HIDE_LOADING) == 0 && sh(liveWebDialogEvent) && (liveWebViewContainer = this.webContainer) != null) {
                liveWebViewContainer.i();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        Window window;
        super.onResume();
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = 80;
            attributes.width = ScreenUtils.getScreenWidth(getContext());
            attributes.height = -2;
            window.setAttributes(attributes);
        }
        initConfig();
    }

    public final void setTitle(@NotNull String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        this.title = title;
    }

    public final void th(@NotNull com.tencent.timi.game.liveroom.impl.room.util.h config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
    }

    public final void uh(@NotNull LiveWebViewContainer view, @Nullable FrameLayout.LayoutParams param) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (param == null) {
            param = new FrameLayout.LayoutParams(-1, -1);
        }
        this.webContainer = view;
        this.dialogContainer.addView(view, param);
    }

    public final void vh(@NotNull DialogInterface.OnDismissListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }
}
