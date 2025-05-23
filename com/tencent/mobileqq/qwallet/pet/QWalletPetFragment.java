package com.tencent.mobileqq.qwallet.pet;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.qwallet.temp.IQwTemp;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.pet.QWalletPetFragment;
import com.tencent.mobileqq.qwallet.pet.QWalletPetStartup;
import com.tencent.mobileqq.qwallet.pet.h5event.QWalletPetH5Controller;
import com.tencent.mobileqq.qwallet.pet.logic.QWalletPetFilamentController;
import com.tencent.mobileqq.qwallet.pet.logic.f;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.ak;
import com.tencent.mobileqq.webview.swift.utils.t;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.util.QQToastUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import il2.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 $2\u00020\u0001:\u0001%B\u0007\u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J&\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0017\u0010!\u001a\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pet/QWalletPetFragment;", "Lcom/tencent/mobileqq/activity/QQTranslucentBrowserActivity$QQTranslucentBrowserFragment;", "", "th", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "onDestroyView", "Lcom/tencent/mobileqq/webview/swift/utils/t;", "getWebViewKernelCallBack", "Lcom/tencent/mobileqq/qwallet/pet/QWalletPetStartup;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/qwallet/pet/QWalletPetStartup;", "checker", "Lcom/tencent/mobileqq/qwallet/pet/logic/f;", "D", "Lcom/tencent/mobileqq/qwallet/pet/logic/f;", "bgController", "Lcom/tencent/mobileqq/qwallet/pet/h5event/QWalletPetH5Controller;", "E", "Lcom/tencent/mobileqq/qwallet/pet/h5event/QWalletPetH5Controller;", "petH5Controller", "Lcom/tencent/mobileqq/qwallet/pet/logic/QWalletPetFilamentController;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/qwallet/pet/logic/QWalletPetFilamentController;", "sh", "()Lcom/tencent/mobileqq/qwallet/pet/logic/QWalletPetFilamentController;", "filamentPetController", "<init>", "()V", "G", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class QWalletPetFragment extends QQTranslucentBrowserActivity.QQTranslucentBrowserFragment {

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final QWalletPetStartup checker = new QWalletPetStartup(QWalletPetStartup.Scene.PET_HOME);

    /* renamed from: D, reason: from kotlin metadata */
    private f bgController;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final QWalletPetH5Controller petH5Controller;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final QWalletPetFilamentController filamentPetController;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/qwallet/pet/QWalletPetFragment$a;", "", "Landroid/content/Context;", "context", "", "url", "", "a", "TAG", "Ljava/lang/String;", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.pet.QWalletPetFragment$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull String url) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(url, "url");
            Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            intent.putExtra("big_brother_source_key", "biz_src_zf_qianbao");
            intent.putExtra("isTransparentTitle", true);
            intent.putExtra("fragmentClass", QWalletPetFragment.class);
            intent.putExtra("url", url);
            context.startActivity(intent);
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0017J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/qwallet/pet/QWalletPetFragment$b", "Lcom/tencent/mobileqq/webview/swift/proxy/a;", "Landroid/os/Bundle;", WadlProxyConsts.EXTRA_DATA, "Lcom/tencent/biz/ui/TouchWebView;", "webView", "", "onWebViewInit", "onInitUIContent", "onFinalState", "", "interceptStartLoadUrl", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b extends com.tencent.mobileqq.webview.swift.proxy.a {
        b(ak akVar) {
            super(akVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean b(QWalletPetFragment this$0, View view, MotionEvent event) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            QWalletPetFilamentController filamentPetController = this$0.getFilamentPetController();
            Intrinsics.checkNotNullExpressionValue(event, "event");
            filamentPetController.m(event);
            return false;
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public boolean interceptStartLoadUrl() {
            boolean interceptStartLoadUrl = super.interceptStartLoadUrl();
            QLog.i("QWallet.Pet.Fragment", 1, "start load url: " + QWalletPetFragment.this.getUrl());
            return interceptStartLoadUrl;
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public void onFinalState(@Nullable Bundle extraData) {
            QWalletPetFragment.this.onFinalState(extraData, this.webViewKernelCallBack);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public void onInitUIContent(@Nullable Bundle extraData) {
            QWalletPetFragment.this.onInitUIContent(extraData, this.webViewKernelCallBack);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        @SuppressLint({"ClickableViewAccessibility"})
        public void onWebViewInit(@Nullable Bundle extraData, @Nullable TouchWebView webView) {
            int collectionSizeOrDefault;
            super.onWebViewInit(extraData, webView);
            if (webView == null) {
                return;
            }
            List<WebViewPlugin> qWalletJsPlugins = ((IQwTemp) QRoute.api(IQwTemp.class)).getQWalletJsPlugins();
            Intrinsics.checkNotNullExpressionValue(qWalletJsPlugins, "api(IQwTemp::class.java).qWalletJsPlugins");
            List<WebViewPlugin> list = qWalletJsPlugins;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((WebViewPlugin) it.next()).getNameSpace());
            }
            Object[] array = arrayList.toArray(new String[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            webView.getPluginEngine().D((String[]) array);
            final QWalletPetFragment qWalletPetFragment = QWalletPetFragment.this;
            webView.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.qwallet.pet.a
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean b16;
                    b16 = QWalletPetFragment.b.b(QWalletPetFragment.this, view, motionEvent);
                    return b16;
                }
            });
        }
    }

    public QWalletPetFragment() {
        QWalletPetH5Controller qWalletPetH5Controller = new QWalletPetH5Controller(this);
        this.petH5Controller = qWalletPetH5Controller;
        this.filamentPetController = new QWalletPetFilamentController(this, qWalletPetH5Controller);
    }

    private final void th() {
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        Window window = requireActivity.getWindow();
        if (window != null) {
            window.clearFlags(201326592);
            window.getDecorView().setSystemUiVisibility(1280);
            window.addFlags(Integer.MIN_VALUE);
            window.setBackgroundDrawableResource(R.color.ajr);
            window.setStatusBarColor(Color.parseColor("#B9956C"));
            ImmersiveUtils.setStatusTextColor(false, window);
        }
        View findViewById = requireActivity.findViewById(R.id.ae8);
        if (findViewById != null) {
            findViewById.setBackgroundResource(R.color.ajr);
        }
    }

    @Override // com.tencent.mobileqq.activity.QQTranslucentBrowserActivity.QQTranslucentBrowserFragment, com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webviewplugin.s
    @NotNull
    public t getWebViewKernelCallBack() {
        return new b(this.webViewSurface);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        th();
    }

    @Override // com.tencent.mobileqq.activity.QQTranslucentBrowserActivity.QQTranslucentBrowserFragment, com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View onCreateView = super.onCreateView(inflater, container, savedInstanceState);
        final View rootView = inflater.inflate(R.layout.hjy, container, false);
        ((FrameLayout) rootView.findViewById(R.id.f243108s)).addView(onCreateView);
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        this.bgController = new f(this, rootView);
        this.filamentPetController.l(rootView);
        this.checker.f(new QWalletPetStartup.d() { // from class: com.tencent.mobileqq.qwallet.pet.QWalletPetFragment$onCreateView$1
            @Override // com.tencent.mobileqq.qwallet.pet.QWalletPetStartup.d
            @Nullable
            public Object a(@NotNull QWalletPetStartup.EnumTask enumTask, @NotNull Continuation<? super Unit> continuation) {
                return Unit.INSTANCE;
            }

            @Override // com.tencent.mobileqq.qwallet.pet.QWalletPetStartup.d
            @Nullable
            public Object b(boolean z16, @Nullable QWalletPetStartup.FailResultData failResultData, @NotNull Continuation<? super Unit> continuation) {
                QWalletPetStartup.EnumTask enumTask;
                String str;
                String str2 = null;
                if (z16) {
                    return CorountineFunKt.i(i.e.f261783e, "QWallet.Pet.Fragment", null, new QWalletPetFragment$onCreateView$1$onCheckEnd$2(QWalletPetFragment.this, rootView, null), continuation, 4, null);
                }
                if (failResultData != null) {
                    enumTask = failResultData.getFailTask();
                } else {
                    enumTask = null;
                }
                boolean z17 = false;
                if (enumTask == QWalletPetStartup.EnumTask.TASK_SUPPORT) {
                    a.SupportResult supportResult = (a.SupportResult) failResultData.getFailData();
                    if (supportResult != null) {
                        String failUrl = supportResult.getFailUrl();
                        if (failUrl == null || failUrl.length() == 0) {
                            z17 = true;
                        }
                        if (!z17) {
                            Intent intent = new Intent(QWalletPetFragment.this.getContext(), (Class<?>) QQBrowserActivity.class);
                            intent.putExtra("big_brother_source_key", "biz_src_zf_qianbao");
                            intent.putExtra("url", supportResult.getFailUrl());
                            QWalletPetFragment.this.startActivity(intent);
                            FragmentActivity activity = QWalletPetFragment.this.getActivity();
                            if (activity != null) {
                                activity.finish();
                            }
                        }
                    }
                } else {
                    if (failResultData != null) {
                        str = failResultData.getFailMsg();
                    } else {
                        str = null;
                    }
                    if (str == null || str.length() == 0) {
                        z17 = true;
                    }
                    if (!z17) {
                        if (failResultData != null) {
                            str2 = failResultData.getFailMsg();
                        }
                        QQToastUtil.showQQToast(1, str2);
                    }
                }
                return Unit.INSTANCE;
            }
        });
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, rootView);
        return rootView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.filamentPetController.o();
    }

    @NotNull
    /* renamed from: sh, reason: from getter */
    public final QWalletPetFilamentController getFilamentPetController() {
        return this.filamentPetController;
    }
}
