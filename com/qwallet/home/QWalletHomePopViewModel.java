package com.qwallet.home;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.qwallet.utils.QWalletUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.home.QWalletHomeFragment;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import cooperation.qwallet.plugin.ipc.QWalletRedTouchInfo;
import cooperation.qwallet.plugin.ipc.WalletHomeReq;
import cooperation.vip.pb.TianShuAccess;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 '2\u00020\u00012\u00020\u0002:\u0001(B\u0007\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u000e\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nJ\b\u0010\r\u001a\u00020\u0005H\u0007J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0014J\b\u0010\u0012\u001a\u00020\u0011H\u0014J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0014R\"\u0010\u001c\u001a\u00020\u00158\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010$\u001a\u00020\u001d8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#\u00a8\u0006)"}, d2 = {"Lcom/qwallet/home/QWalletHomePopViewModel;", "Lcom/qwallet/home/c;", "Landroidx/lifecycle/LifecycleObserver;", "", ICustomDataEditor.STRING_ARRAY_PARAM_2, "", "X1", "Landroid/os/Bundle;", "data", "b2", "Lcom/tencent/mobileqq/qwallet/home/QWalletHomeFragment;", "fragment", "Z1", "onCreate", "", "Lcom/tencent/mobileqq/tianshu/data/TianShuAdPosItemData;", "N1", "Lcom/tencent/mobileqq/tianshu/data/TianShuGetAdvCallback;", "M1", "Lcooperation/vip/pb/TianShuAccess$AdItem;", "L1", "Lcom/qwallet/home/NativePopViewModel;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qwallet/home/NativePopViewModel;", "U1", "()Lcom/qwallet/home/NativePopViewModel;", "d2", "(Lcom/qwallet/home/NativePopViewModel;)V", "nativePopupViewModel", "Lcom/qwallet/home/BackendControlPopViewModel;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/qwallet/home/BackendControlPopViewModel;", "T1", "()Lcom/qwallet/home/BackendControlPopViewModel;", "c2", "(Lcom/qwallet/home/BackendControlPopViewModel;)V", "backendControlPopViewModel", "<init>", "()V", "D", "a", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes3.dex */
public final class QWalletHomePopViewModel extends c implements LifecycleObserver {

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    public BackendControlPopViewModel backendControlPopViewModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public NativePopViewModel nativePopupViewModel;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/qwallet/home/QWalletHomePopViewModel$a;", "", "", "a", "", "POS_POP_RED_POINT_PATH", "Ljava/lang/String;", "TAG", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qwallet.home.QWalletHomePopViewModel$a, reason: from kotlin metadata */
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a() {
            WalletHomeReq walletHomeReq = new WalletHomeReq();
            walletHomeReq.type = 2;
            walletHomeReq.isAppLoadFinished = true;
            walletHomeReq.redTouchPath = "100007.100007001";
            QWalletUtils.u(walletHomeReq);
        }

        Companion() {
        }
    }

    private final void X1() {
        final Handler handler = new Handler(Looper.getMainLooper());
        ResultReceiver resultReceiver = new ResultReceiver(handler) { // from class: com.qwallet.home.QWalletHomePopViewModel$getTrueRedPoint$resultReceiver$1
            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int code, @Nullable Bundle data) {
                QWalletHomePopViewModel.this.b2(data);
            }
        };
        WalletHomeReq walletHomeReq = new WalletHomeReq();
        walletHomeReq.type = 1;
        walletHomeReq.fromReceiver = resultReceiver;
        walletHomeReq.isAppLoadFinished = true;
        ArrayList<String> arrayList = new ArrayList<>();
        walletHomeReq.redTouchPaths = arrayList;
        arrayList.add("100007.100007001");
        QWalletUtils.u(walletHomeReq);
    }

    private final boolean a2() {
        boolean studyModeSwitch = ((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch();
        boolean c16 = ol2.a.c();
        boolean j3 = AccessibilityUtil.j(MobileQQ.sMobileQQ);
        if (!studyModeSwitch && !c16 && !j3) {
            return false;
        }
        QLog.w("QWalletHomePopViewModel", 1, "isDisablePopupWindow: isStudyMode=" + studyModeSwitch + " isElderMode=" + c16 + " isAccessibilityEnabled=" + j3);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void b2(Bundle data) {
        Serializable serializable;
        ArrayList arrayList;
        String str;
        QWalletRedTouchInfo qWalletRedTouchInfo = null;
        if (data != null) {
            serializable = data.getSerializable("_qwallet_ipc_WalletHome_resp");
        } else {
            serializable = null;
        }
        if (serializable instanceof ArrayList) {
            arrayList = (ArrayList) serializable;
        } else {
            arrayList = null;
        }
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                QWalletRedTouchInfo qWalletRedTouchInfo2 = (QWalletRedTouchInfo) next;
                if (qWalletRedTouchInfo2 != null) {
                    str = qWalletRedTouchInfo2.path;
                } else {
                    str = null;
                }
                if (Intrinsics.areEqual(str, "100007.100007001")) {
                    qWalletRedTouchInfo = next;
                    break;
                }
            }
            qWalletRedTouchInfo = qWalletRedTouchInfo;
        }
        if (T1().W1(qWalletRedTouchInfo)) {
            QLog.i("QWalletHomePopViewModel", 1, "getTianShuCallback: handleBackendControlPop success");
        } else {
            U1().c2(qWalletRedTouchInfo);
        }
    }

    @Override // com.qwallet.home.c
    @Nullable
    protected TianShuAccess.AdItem L1() {
        return null;
    }

    @Override // com.qwallet.home.c
    @NotNull
    protected TianShuGetAdvCallback M1() {
        return new TianShuGetAdvCallback() { // from class: com.qwallet.home.n
            @Override // com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback
            public final void onGetAdvs(boolean z16, TianShuAccess.GetAdsRsp getAdsRsp) {
                QWalletHomePopViewModel.W1(z16, getAdsRsp);
            }
        };
    }

    @Override // com.qwallet.home.c
    @NotNull
    protected List<TianShuAdPosItemData> N1() {
        List<TianShuAdPosItemData> emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return emptyList;
    }

    @NotNull
    public final BackendControlPopViewModel T1() {
        BackendControlPopViewModel backendControlPopViewModel = this.backendControlPopViewModel;
        if (backendControlPopViewModel != null) {
            return backendControlPopViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("backendControlPopViewModel");
        return null;
    }

    @NotNull
    public final NativePopViewModel U1() {
        NativePopViewModel nativePopViewModel = this.nativePopupViewModel;
        if (nativePopViewModel != null) {
            return nativePopViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("nativePopupViewModel");
        return null;
    }

    public final void Z1(@NotNull QWalletHomeFragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        ViewModel viewModel = new ViewModelProvider(fragment).get(NativePopViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(fragme\u2026PopViewModel::class.java)");
        NativePopViewModel nativePopViewModel = (NativePopViewModel) viewModel;
        fragment.getLifecycle().addObserver(nativePopViewModel);
        d2(nativePopViewModel);
        ViewModel viewModel2 = new ViewModelProvider(fragment).get(BackendControlPopViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "ViewModelProvider(fragme\u2026PopViewModel::class.java)");
        BackendControlPopViewModel backendControlPopViewModel = (BackendControlPopViewModel) viewModel2;
        fragment.getLifecycle().addObserver(backendControlPopViewModel);
        c2(backendControlPopViewModel);
    }

    public final void c2(@NotNull BackendControlPopViewModel backendControlPopViewModel) {
        Intrinsics.checkNotNullParameter(backendControlPopViewModel, "<set-?>");
        this.backendControlPopViewModel = backendControlPopViewModel;
    }

    public final void d2(@NotNull NativePopViewModel nativePopViewModel) {
        Intrinsics.checkNotNullParameter(nativePopViewModel, "<set-?>");
        this.nativePopupViewModel = nativePopViewModel;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public final void onCreate() {
        if (a2()) {
            return;
        }
        X1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W1(boolean z16, TianShuAccess.GetAdsRsp getAdsRsp) {
    }
}
