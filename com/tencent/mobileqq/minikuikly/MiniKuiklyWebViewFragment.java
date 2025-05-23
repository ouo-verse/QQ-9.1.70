package com.tencent.mobileqq.minikuikly;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00062\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/minikuikly/MiniKuiklyWebViewFragment;", "Lcom/tencent/mobileqq/webview/swift/WebViewFragment;", "", "doOnBackEvent", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class MiniKuiklyWebViewFragment extends WebViewFragment {

    /* renamed from: C, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/minikuikly/MiniKuiklyWebViewFragment$a;", "", "", "url", "Lcom/tencent/mobileqq/minikuikly/MiniKuiklyWebViewFragment;", "a", "<init>", "()V", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.minikuikly.MiniKuiklyWebViewFragment$a, reason: from kotlin metadata */
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final MiniKuiklyWebViewFragment a(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intent intent = new Intent();
            intent.putExtra("url", url);
            Bundle bundle = new Bundle();
            bundle.putParcelable("intent", intent);
            MiniKuiklyWebViewFragment miniKuiklyWebViewFragment = new MiniKuiklyWebViewFragment();
            miniKuiklyWebViewFragment.setArguments(bundle);
            return miniKuiklyWebViewFragment;
        }

        Companion() {
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webview.swift.WebViewProvider
    public void doOnBackEvent() {
        FragmentManager supportFragmentManager;
        QBaseActivity qBaseActivity = getQBaseActivity();
        if (qBaseActivity == null || (supportFragmentManager = qBaseActivity.getSupportFragmentManager()) == null) {
            return;
        }
        supportFragmentManager.popBackStack();
    }
}
