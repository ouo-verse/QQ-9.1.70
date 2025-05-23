package com.tencent.mobileqq.matchfriend.reborn.content.signal.base;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.matchfriend.reborn.content.signal.base.c;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u00020\u0005B\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\u0015\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00028\u0000\u00a2\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u001b\u001a\u00020\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/base/QQStrangerSignalBaseViewModel;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/base/c;", "State", "", "Intent", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "state", "O1", "(Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/base/c;)V", "Landroidx/lifecycle/MutableLiveData;", "i", "Landroidx/lifecycle/MutableLiveData;", "_updateUIStateLiveData", "Landroidx/lifecycle/LiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LiveData;", "N1", "()Landroidx/lifecycle/LiveData;", "updateUIStateLiveData", "Landroid/os/Handler;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "M1", "()Landroid/os/Handler;", "mainHandler", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public abstract class QQStrangerSignalBaseViewModel<State extends c, Intent> extends BaseViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    private final Lazy mainHandler;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<State> _updateUIStateLiveData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final LiveData<State> updateUIStateLiveData;

    public QQStrangerSignalBaseViewModel() {
        Lazy lazy;
        MutableLiveData<State> mutableLiveData = new MutableLiveData<>();
        this._updateUIStateLiveData = mutableLiveData;
        this.updateUIStateLiveData = mutableLiveData;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Handler>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.signal.base.QQStrangerSignalBaseViewModel$mainHandler$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Handler invoke() {
                return new Handler(Looper.getMainLooper());
            }
        });
        this.mainHandler = lazy;
    }

    private final Handler M1() {
        return (Handler) this.mainHandler.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P1(QQStrangerSignalBaseViewModel this$0, c state) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(state, "$state");
        this$0._updateUIStateLiveData.setValue(state);
    }

    public final LiveData<State> N1() {
        return this.updateUIStateLiveData;
    }

    public final void O1(final State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            this._updateUIStateLiveData.setValue(state);
        } else {
            M1().post(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.signal.base.d
                @Override // java.lang.Runnable
                public final void run() {
                    QQStrangerSignalBaseViewModel.P1(QQStrangerSignalBaseViewModel.this, state);
                }
            });
        }
    }

    public void onDestroy() {
        M1().removeCallbacksAndMessages(null);
    }

    public void onCreate() {
    }
}
