package com.tencent.qqmini.minigame.ui;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqmini.minigame.R;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u001cB\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0019\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/qqmini/minigame/ui/a;", "Landroid/app/Dialog;", "", "initView", "Lcom/tencent/qqmini/sdk/launcher/model/MiniAppInfo;", "appInfo", "Lcom/tencent/qqmini/minigame/ui/a$a;", "listener", "O", "Landroid/widget/ImageView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/ImageView;", "mAppIconIv", "Landroid/widget/TextView;", "D", "Landroid/widget/TextView;", "mAppNameTv", "E", "Lcom/tencent/qqmini/minigame/ui/a$a;", "mResultListener", "Landroid/app/Activity;", UserInfo.SEX_FEMALE, "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "<init>", "(Landroid/app/Activity;)V", "a", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes23.dex */
public final class a extends ReportDialog {

    /* renamed from: C, reason: from kotlin metadata */
    private ImageView mAppIconIv;

    /* renamed from: D, reason: from kotlin metadata */
    private TextView mAppNameTv;

    /* renamed from: E, reason: from kotlin metadata */
    private InterfaceC9395a mResultListener;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Activity activity;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/qqmini/minigame/ui/a$a;", "", "", "isAllowed", "", "onResult", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.qqmini.minigame.ui.a$a, reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    public interface InterfaceC9395a {
        void onResult(boolean isAllowed);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes23.dex */
    public static final class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            InterfaceC9395a interfaceC9395a = a.this.mResultListener;
            if (interfaceC9395a != null) {
                interfaceC9395a.onResult(true);
            }
            a.this.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes23.dex */
    public static final class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            InterfaceC9395a interfaceC9395a = a.this.mResultListener;
            if (interfaceC9395a != null) {
                interfaceC9395a.onResult(false);
            }
            a.this.dismiss();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull Activity activity) {
        super(activity, R.style.mini_sdk_base_dialog_style);
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        this.activity = activity;
        initView();
    }

    private final void initView() {
        setContentView(R.layout.mini_sdk_join_group_confirm_layout);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        Window window = getWindow();
        if (window != null) {
            window.setGravity(80);
        }
        View findViewById = findViewById(R.id.iv_app_icon);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "findViewById(R.id.iv_app_icon)");
        this.mAppIconIv = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.tv_app_name);
        Intrinsics.checkExpressionValueIsNotNull(findViewById2, "findViewById(R.id.tv_app_name)");
        this.mAppNameTv = (TextView) findViewById2;
        ((TextView) findViewById(R.id.tv_allowed)).setOnClickListener(new b());
        ((TextView) findViewById(R.id.tv_refused)).setOnClickListener(new c());
    }

    public final void O(@NotNull MiniAppInfo appInfo, @NotNull InterfaceC9395a listener) {
        Drawable drawable;
        Intrinsics.checkParameterIsNotNull(appInfo, "appInfo");
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        this.mResultListener = listener;
        TextView textView = this.mAppNameTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAppNameTv");
        }
        textView.setText(appInfo.name);
        MiniAppProxy miniAppProxy = (MiniAppProxy) ProxyManager.get(MiniAppProxy.class);
        if (miniAppProxy != null) {
            drawable = miniAppProxy.getDrawable(this.activity, appInfo.iconUrl, 0, 0, null);
        } else {
            drawable = null;
        }
        if (drawable != null) {
            ImageView imageView = this.mAppIconIv;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAppIconIv");
            }
            imageView.setImageDrawable(drawable);
        }
    }
}
