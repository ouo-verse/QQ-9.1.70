package com.tencent.mobileqq.qwallet.hb.aigc;

import android.app.Dialog;
import android.content.Context;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qwallet.hb.aigc.data.OutputImageInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.wink.view.QCircleCommonLoadingDialog;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 )2\u00020\u00012\u00020\u0002:\u0002*+B\u0007\u00a2\u0006\u0004\b'\u0010(J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u001e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bJ\b\u0010\f\u001a\u00020\u0005H\u0014J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0007R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00190\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/aigc/QWalletMediaPickerViewModel;", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/LifecycleObserver;", "Landroid/content/Context;", "context", "", "U1", "R1", "", "path", "bizId", "Z1", "onCleared", "Landroidx/lifecycle/LifecycleOwner;", "owner", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lkotlinx/coroutines/CoroutineScope;", "i", "Lkotlinx/coroutines/CoroutineScope;", "viewModelScope", "Lcom/tencent/mobileqq/qwallet/hb/aigc/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/qwallet/hb/aigc/a;", "service", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mobileqq/qwallet/hb/aigc/QWalletMediaPickerViewModel$b;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/MutableLiveData;", "_processEvent", "Landroidx/lifecycle/LiveData;", "D", "Landroidx/lifecycle/LiveData;", "T1", "()Landroidx/lifecycle/LiveData;", "processEvent", "Landroid/app/Dialog;", "E", "Landroid/app/Dialog;", "uploadDialog", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "b", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class QWalletMediaPickerViewModel extends ViewModel implements LifecycleObserver {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<b> _processEvent;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final LiveData<b> processEvent;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private Dialog uploadDialog;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CoroutineScope viewModelScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getMain()));

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a service = new a();

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/aigc/QWalletMediaPickerViewModel$b;", "", "<init>", "()V", "a", "b", "c", "Lcom/tencent/mobileqq/qwallet/hb/aigc/QWalletMediaPickerViewModel$b$a;", "Lcom/tencent/mobileqq/qwallet/hb/aigc/QWalletMediaPickerViewModel$b$b;", "Lcom/tencent/mobileqq/qwallet/hb/aigc/QWalletMediaPickerViewModel$b$c;", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static abstract class b {

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/aigc/QWalletMediaPickerViewModel$b$a;", "Lcom/tencent/mobileqq/qwallet/hb/aigc/QWalletMediaPickerViewModel$b;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "a", "Ljava/lang/Throwable;", "()Ljava/lang/Throwable;", "throwable", "<init>", "(Ljava/lang/Throwable;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.qwallet.hb.aigc.QWalletMediaPickerViewModel$b$a, reason: from toString */
        /* loaded from: classes16.dex */
        public static final /* data */ class DetectFail extends b {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
            @NotNull
            private final Throwable throwable;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public DetectFail(@NotNull Throwable throwable) {
                super(null);
                Intrinsics.checkNotNullParameter(throwable, "throwable");
                this.throwable = throwable;
            }

            @NotNull
            /* renamed from: a, reason: from getter */
            public final Throwable getThrowable() {
                return this.throwable;
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if ((other instanceof DetectFail) && Intrinsics.areEqual(this.throwable, ((DetectFail) other).throwable)) {
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return this.throwable.hashCode();
            }

            @NotNull
            public String toString() {
                return "DetectFail(throwable=" + this.throwable + ")";
            }
        }

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/aigc/QWalletMediaPickerViewModel$b$b;", "Lcom/tencent/mobileqq/qwallet/hb/aigc/QWalletMediaPickerViewModel$b;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/mobileqq/qwallet/hb/aigc/data/OutputImageInfo;", "a", "Lcom/tencent/mobileqq/qwallet/hb/aigc/data/OutputImageInfo;", "()Lcom/tencent/mobileqq/qwallet/hb/aigc/data/OutputImageInfo;", "imageInfo", "<init>", "(Lcom/tencent/mobileqq/qwallet/hb/aigc/data/OutputImageInfo;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.qwallet.hb.aigc.QWalletMediaPickerViewModel$b$b, reason: collision with other inner class name and from toString */
        /* loaded from: classes16.dex */
        public static final /* data */ class DetectSuccess extends b {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
            @NotNull
            private final OutputImageInfo imageInfo;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public DetectSuccess(@NotNull OutputImageInfo imageInfo) {
                super(null);
                Intrinsics.checkNotNullParameter(imageInfo, "imageInfo");
                this.imageInfo = imageInfo;
            }

            @NotNull
            /* renamed from: a, reason: from getter */
            public final OutputImageInfo getImageInfo() {
                return this.imageInfo;
            }

            public boolean equals(@Nullable Object other) {
                if (this == other) {
                    return true;
                }
                if ((other instanceof DetectSuccess) && Intrinsics.areEqual(this.imageInfo, ((DetectSuccess) other).imageInfo)) {
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return this.imageInfo.hashCode();
            }

            @NotNull
            public String toString() {
                return "DetectSuccess(imageInfo=" + this.imageInfo + ")";
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/aigc/QWalletMediaPickerViewModel$b$c;", "Lcom/tencent/mobileqq/qwallet/hb/aigc/QWalletMediaPickerViewModel$b;", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes16.dex */
        public static final class c extends b {

            /* renamed from: a, reason: collision with root package name */
            @NotNull
            public static final c f277210a = new c();

            c() {
                super(null);
            }
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        b() {
        }
    }

    public QWalletMediaPickerViewModel() {
        MutableLiveData<b> mutableLiveData = new MutableLiveData<>();
        this._processEvent = mutableLiveData;
        this.processEvent = mutableLiveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R1() {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.qwallet.hb.aigc.f
            @Override // java.lang.Runnable
            public final void run() {
                QWalletMediaPickerViewModel.S1(QWalletMediaPickerViewModel.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S1(QWalletMediaPickerViewModel this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Dialog dialog = this$0.uploadDialog;
        if (dialog != null) {
            if (dialog.isShowing()) {
                dialog.dismiss();
            }
            this$0.uploadDialog = null;
        }
    }

    private final void U1(final Context context) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.qwallet.hb.aigc.g
            @Override // java.lang.Runnable
            public final void run() {
                QWalletMediaPickerViewModel.W1(QWalletMediaPickerViewModel.this, context);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W1(QWalletMediaPickerViewModel this$0, Context context) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        Dialog dialog = this$0.uploadDialog;
        if (dialog != null) {
            dialog.dismiss();
        }
        QCircleCommonLoadingDialog a16 = new QCircleCommonLoadingDialog.c(context, R.style.f173547a45).n(false).d(new Callable() { // from class: com.tencent.mobileqq.qwallet.hb.aigc.h
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Boolean X1;
                X1 = QWalletMediaPickerViewModel.X1();
                return X1;
            }
        }).b().p(context.getString(R.string.f2176561l)).a();
        this$0.uploadDialog = a16;
        if (a16 != null) {
            a16.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean X1() {
        return Boolean.TRUE;
    }

    @NotNull
    public final LiveData<b> T1() {
        return this.processEvent;
    }

    public final void Z1(@NotNull Context context, @NotNull String path, @NotNull String bizId) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(bizId, "bizId");
        if (!NetworkUtil.isNetworkAvailable()) {
            c.f277218a.d(0L, BaseApplication.getContext().getString(R.string.ci8));
            this._processEvent.postValue(b.c.f277210a);
        } else {
            U1(context);
            BuildersKt__Builders_commonKt.launch$default(this.viewModelScope, null, null, new QWalletMediaPickerViewModel$startCheckImageFlow$1(path, this, bizId, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        CoroutineScopeKt.cancel$default(this.viewModelScope, null, 1, null);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy(@NotNull LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        this.service.f();
        R1();
    }
}
