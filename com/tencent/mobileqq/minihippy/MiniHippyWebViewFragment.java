package com.tencent.mobileqq.minihippy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.minigame.ui.controller.MiniHippyController;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016J\u000e\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/minihippy/MiniHippyWebViewFragment;", "Lcom/tencent/mobileqq/webview/swift/WebViewFragment;", "", "ph", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "doOnBackEvent", "Lcom/tencent/mobileqq/minigame/ui/controller/MiniHippyController;", "controller", "rh", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/minigame/ui/controller/MiniHippyController;", "mController", "<init>", "()V", "D", "a", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class MiniHippyWebViewFragment extends WebViewFragment {

    /* renamed from: D, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private MiniHippyController mController;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/minihippy/MiniHippyWebViewFragment$a;", "", "", "url", "Lcom/tencent/mobileqq/minihippy/MiniHippyWebViewFragment;", "a", "<init>", "()V", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.minihippy.MiniHippyWebViewFragment$a, reason: from kotlin metadata */
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final MiniHippyWebViewFragment a(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intent intent = new Intent();
            intent.putExtra("url", url);
            Bundle bundle = new Bundle();
            bundle.putParcelable("intent", intent);
            MiniHippyWebViewFragment miniHippyWebViewFragment = new MiniHippyWebViewFragment();
            miniHippyWebViewFragment.setArguments(bundle);
            return miniHippyWebViewFragment;
        }

        Companion() {
        }
    }

    private final void ph() {
        MiniHippyController miniHippyController;
        Bundle arguments = getArguments();
        if (!Intrinsics.areEqual(arguments != null ? Boolean.valueOf(arguments.getBoolean("minihippy_root", false)) : null, Boolean.TRUE) || (miniHippyController = this.mController) == null) {
            return;
        }
        miniHippyController.onHippyLoadFinish();
    }

    @JvmStatic
    public static final MiniHippyWebViewFragment qh(String str) {
        return INSTANCE.a(str);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webview.swift.WebViewProvider
    public void doOnBackEvent() {
        QBaseActivity qBaseActivity = getQBaseActivity();
        if (qBaseActivity != null) {
            qBaseActivity.doOnBackPressed();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ph();
    }

    public final void rh(MiniHippyController controller) {
        Intrinsics.checkNotNullParameter(controller, "controller");
        this.mController = controller;
    }
}
