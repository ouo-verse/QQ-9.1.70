package com.tencent.mvi.mvvm.framework;

import android.os.Handler;
import android.text.TextUtils;
import androidx.annotation.CallSuper;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MVILiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mvi.api.runtime.b;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.log.c;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ll3.b;
import ol3.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010%\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0012\b&\u0018\u0000 X*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u0003*\b\b\u0002\u0010\u0006*\u00020\u00052\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0007:\u0001YB\u0007\u00a2\u0006\u0004\bW\u0010.J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00028\u0001H\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00028\u0001H\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u000f\u001a\u00020\tH\u0002J \u0010\u0014\u001a\u00020\t2\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u00102\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0012H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\f\u0010\u0017\u001a\u00020\u0015*\u00020\u0015H\u0002J\u0017\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00028\u0002H\u0016\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0006\u0010\u001b\u001a\u00020\tJ+\u0010 \u001a\u00020\t2\u000e\u0010\u001d\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00010\u001c2\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0012H\u0000\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010#\u001a\u00020\t2\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0012H\u0000\u00a2\u0006\u0004\b!\u0010\"J1\u0010\u0019\u001a\u00020\t2\u0014\u0010%\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00010\u001c0$2\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0012H\u0000\u00a2\u0006\u0004\b&\u0010'J+\u0010\u0019\u001a\u00020\t2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010(2\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0012H\u0000\u00a2\u0006\u0004\b&\u0010*J\u0017\u0010,\u001a\u00020\t2\u0006\u0010\b\u001a\u00028\u0001H\u0000\u00a2\u0006\u0004\b+\u0010\u000bJ\u000f\u0010/\u001a\u00020\tH\u0011\u00a2\u0006\u0004\b-\u0010.J\b\u00100\u001a\u00020\tH\u0004R\u001b\u00105\u001a\u00020\u00158@X\u0080\u0084\u0002\u00a2\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104R1\u0010:\u001a\u0018\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00010\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u0015068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b7\u00102\u001a\u0004\b8\u00109R)\u0010=\u001a\u0010\u0012\u0004\u0012\u00020)\u0012\u0006\u0012\u0004\u0018\u00010\u0015068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b;\u00102\u001a\u0004\b<\u00109R(\u0010>\u001a\u00028\u00028\u0006@\u0006X\u0087.\u00a2\u0006\u0018\n\u0004\b>\u0010?\u0012\u0004\bC\u0010.\u001a\u0004\b@\u0010A\"\u0004\bB\u0010\u001aR\u0016\u0010D\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010F\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010ER\u0016\u0010G\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010ER\u001b\u0010L\u001a\u00020H8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\bI\u00102\u001a\u0004\bJ\u0010KR\u001c\u0010M\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010O\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010ER\"\u0010P\u001a\u00020\f8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\bP\u0010E\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u0013\u0010V\u001a\u0004\u0018\u00018\u00028F\u00a2\u0006\u0006\u001a\u0004\bU\u0010A\u00a8\u0006Z"}, d2 = {"Lcom/tencent/mvi/mvvm/framework/FrameworkVM;", "Lol3/b;", "I", "Lcom/tencent/mvi/base/mvi/MviUIState;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mvi/api/runtime/b;", "Context", "Lll3/b;", "state", "", "dispatchStateByLazyOpt", "(Lcom/tencent/mvi/base/mvi/MviUIState;)V", "", "dispatchStateByLazyEvent", "(Lcom/tencent/mvi/base/mvi/MviUIState;)Z", "releaseLifecycleObserver", "Landroidx/lifecycle/LiveData;", "liveData", "Landroidx/lifecycle/Observer;", "observer", "innerRegisterLiveData", "Landroidx/lifecycle/MVILiveData;", "createLiveData", "checkRegisterObserver", "outContext", "attach", "(Lcom/tencent/mvi/api/runtime/b;)V", OperateCustomButton.OPERATE_CREATE, "Ljava/lang/Class;", "type", "addSource$mvi_debug", "(Ljava/lang/Class;Landroidx/lifecycle/Observer;)V", "addSource", "observe$mvi_debug", "(Landroidx/lifecycle/Observer;)V", "observe", "", "types", "attach$mvi_debug", "(Ljava/util/List;Landroidx/lifecycle/Observer;)V", "", "", "(Ljava/util/Collection;Landroidx/lifecycle/Observer;)V", "dispatchState$mvi_debug", "dispatchState", "destroy$mvi_debug", "()V", "destroy", "ensureAttach", "mUiState$delegate", "Lkotlin/Lazy;", "getMUiState$mvi_debug", "()Landroidx/lifecycle/MVILiveData;", "mUiState", "", "mChildrenUiState$delegate", "getMChildrenUiState", "()Ljava/util/Map;", "mChildrenUiState", "mChildrenUiStateV1$delegate", "getMChildrenUiStateV1", "mChildrenUiStateV1", "mContext", "Lcom/tencent/mvi/api/runtime/b;", "getMContext", "()Lcom/tencent/mvi/api/runtime/b;", "setMContext", "getMContext$annotations", "mIsAttached", "Z", "mChildrenStateV1Init", "mChildrenStateInit", "Landroid/os/Handler;", "mMainHandler$delegate", "getMMainHandler", "()Landroid/os/Handler;", "mMainHandler", "mVBObserver", "Landroidx/lifecycle/Observer;", "mMainStateUse", "optLiveData", "getOptLiveData$mvi_debug", "()Z", "setOptLiveData$mvi_debug", "(Z)V", "getSafetyContext", "safetyContext", "<init>", "Companion", "a", "mvi_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes21.dex */
public abstract class FrameworkVM<I extends ol3.b, S extends MviUIState, Context extends com.tencent.mvi.api.runtime.b> implements ll3.b<I, S, Context> {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "FrameworkVM";
    private boolean mChildrenStateInit;
    private boolean mChildrenStateV1Init;

    /* renamed from: mChildrenUiState$delegate, reason: from kotlin metadata */
    private final Lazy mChildrenUiState;

    /* renamed from: mChildrenUiStateV1$delegate, reason: from kotlin metadata */
    private final Lazy mChildrenUiStateV1;
    public Context mContext;
    private boolean mIsAttached;

    /* renamed from: mMainHandler$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mMainHandler;
    private boolean mMainStateUse;

    /* renamed from: mUiState$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mUiState;
    private Observer<?> mVBObserver;
    private boolean optLiveData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mvi/mvvm/framework/FrameworkVM$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "mvi_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.mvi.mvvm.framework.FrameworkVM$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15593);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public FrameworkVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.mUiState = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<MVILiveData>() { // from class: com.tencent.mvi.mvvm.framework.FrameworkVM$mUiState$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) FrameworkVM.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MVILiveData invoke() {
                MVILiveData createLiveData;
                MVILiveData createLiveData2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    return (MVILiveData) iPatchRedirector2.redirect((short) 1, (Object) this);
                }
                if (FrameworkVM.this.getOptLiveData$mvi_debug()) {
                    createLiveData2 = FrameworkVM.this.createLiveData();
                    FrameworkVM.this.mMainStateUse = true;
                    return createLiveData2;
                }
                createLiveData = FrameworkVM.this.createLiveData();
                return createLiveData;
            }
        });
        this.mChildrenUiState = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<Map<Class<? extends S>, MVILiveData>>() { // from class: com.tencent.mvi.mvvm.framework.FrameworkVM$mChildrenUiState$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) FrameworkVM.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Map<Class<? extends S>, MVILiveData> invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    return (Map) iPatchRedirector2.redirect((short) 1, (Object) this);
                }
                FrameworkVM.this.mChildrenStateInit = true;
                return new LinkedHashMap();
            }
        });
        this.mChildrenUiStateV1 = LazyKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<Map<String, MVILiveData>>() { // from class: com.tencent.mvi.mvvm.framework.FrameworkVM$mChildrenUiStateV1$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) FrameworkVM.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Map<String, MVILiveData> invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    return (Map) iPatchRedirector2.redirect((short) 1, (Object) this);
                }
                FrameworkVM.this.mChildrenStateV1Init = true;
                return new LinkedHashMap();
            }
        });
        this.mMainHandler = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) FrameworkVM$mMainHandler$2.INSTANCE);
    }

    private final MVILiveData checkRegisterObserver(MVILiveData mVILiveData) {
        Observer<?> observer;
        if (!mVILiveData.hasObservers() && (observer = this.mVBObserver) != null) {
            if (observer != null) {
                innerRegisterLiveData(mVILiveData, observer);
            } else {
                throw new IllegalStateException("Required value was null.".toString());
            }
        }
        return mVILiveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MVILiveData createLiveData() {
        return new MVILiveData();
    }

    private final boolean dispatchStateByLazyEvent(S state) {
        String str;
        try {
            str = state.eventName();
        } catch (NoClassDefFoundError e16) {
            if (com.tencent.mvi.a.f337742b.a()) {
                e16.printStackTrace();
            }
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Map<String, MVILiveData> mChildrenUiStateV1 = getMChildrenUiStateV1();
        if (mChildrenUiStateV1 != null) {
            if (!mChildrenUiStateV1.containsKey(str)) {
                return false;
            }
            MVILiveData mVILiveData = getMChildrenUiStateV1().get(str);
            if (mVILiveData == null) {
                mVILiveData = createLiveData();
                Map<String, MVILiveData> mChildrenUiStateV12 = getMChildrenUiStateV1();
                Intrinsics.checkNotNull(str);
                mChildrenUiStateV12.put(str, mVILiveData);
            }
            checkRegisterObserver(mVILiveData).setValue(state);
            return true;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
    }

    private final void dispatchStateByLazyOpt(S state) {
        if (!dispatchStateByLazyEvent(state) && getMChildrenUiState().containsKey(state.getClass())) {
            MVILiveData mVILiveData = getMChildrenUiState().get(state.getClass());
            if (mVILiveData == null) {
                mVILiveData = createLiveData();
                getMChildrenUiState().put(state.getClass(), mVILiveData);
            }
            checkRegisterObserver(mVILiveData).setValue(state);
            return;
        }
        checkRegisterObserver(getMUiState$mvi_debug()).setValue(state);
    }

    private final Map<Class<? extends S>, MVILiveData> getMChildrenUiState() {
        return (Map) this.mChildrenUiState.getValue();
    }

    private final Map<String, MVILiveData> getMChildrenUiStateV1() {
        return (Map) this.mChildrenUiStateV1.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void innerRegisterLiveData(LiveData<?> liveData, Observer<?> observer) {
        if (liveData != 0) {
            if (observer != 0) {
                if (observerState(liveData, observer)) {
                    return;
                }
                Context context = this.mContext;
                if (context == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContext");
                }
                liveData.observe(context.d(), observer);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.Observer<S>");
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LiveData<S>");
    }

    private final void releaseLifecycleObserver() {
        if (com.tencent.mvi.a.f337742b.a()) {
            c.f337783b.a(TAG, "releaseLifecycleObserver");
        }
        if (this.optLiveData) {
            if (this.mMainStateUse) {
                MVILiveData mUiState$mvi_debug = getMUiState$mvi_debug();
                Context context = this.mContext;
                if (context == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContext");
                }
                mUiState$mvi_debug.removeObservers(context.d());
            }
            if (this.mChildrenStateInit) {
                for (MVILiveData mVILiveData : getMChildrenUiState().values()) {
                    if (mVILiveData != null) {
                        Context context2 = this.mContext;
                        if (context2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mContext");
                        }
                        mVILiveData.removeObservers(context2.d());
                    }
                }
            }
            if (this.mChildrenStateV1Init) {
                for (MVILiveData mVILiveData2 : getMChildrenUiStateV1().values()) {
                    if (mVILiveData2 != null) {
                        Context context3 = this.mContext;
                        if (context3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mContext");
                        }
                        mVILiveData2.removeObservers(context3.d());
                    }
                }
            }
            this.mVBObserver = null;
            return;
        }
        MVILiveData mUiState$mvi_debug2 = getMUiState$mvi_debug();
        Context context4 = this.mContext;
        if (context4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        }
        mUiState$mvi_debug2.removeObservers(context4.d());
        for (MVILiveData mVILiveData3 : getMChildrenUiState().values()) {
            if (mVILiveData3 != null) {
                Context context5 = this.mContext;
                if (context5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContext");
                }
                mVILiveData3.removeObservers(context5.d());
            }
        }
    }

    public final void addSource$mvi_debug(@NotNull Class<? extends S> type, @NotNull Observer<?> observer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) type, (Object) observer);
            return;
        }
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(observer, "observer");
        MVILiveData mVILiveData = new MVILiveData();
        innerRegisterLiveData(mVILiveData, observer);
        getMChildrenUiState().put(type, mVILiveData);
    }

    public void attach(@NotNull Context outContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) outContext);
            return;
        }
        Intrinsics.checkNotNullParameter(outContext, "outContext");
        this.mIsAttached = true;
        this.mContext = outContext;
    }

    public final void attach$mvi_debug(@NotNull List<? extends Class<? extends S>> types, @NotNull Observer<?> observer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) types, (Object) observer);
            return;
        }
        Intrinsics.checkNotNullParameter(types, "types");
        Intrinsics.checkNotNullParameter(observer, "observer");
        Iterator<T> it = types.iterator();
        while (it.hasNext()) {
            getMChildrenUiState().put((Class) it.next(), null);
        }
        this.mVBObserver = observer;
    }

    public final void create() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        Context context = this.mContext;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        }
        onCreate((Object) context);
    }

    @CallSuper
    public void destroy$mvi_debug() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        onDestroy();
        releaseLifecycleObserver();
        getMMainHandler().removeCallbacksAndMessages(null);
        this.mIsAttached = false;
    }

    public final void dispatchState$mvi_debug(@NotNull S state) {
        MVILiveData mVILiveData;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        if (this.optLiveData) {
            dispatchStateByLazyOpt(state);
        } else if (getMChildrenUiState().containsKey(state.getClass()) && (mVILiveData = getMChildrenUiState().get(state.getClass())) != null) {
            mVILiveData.setValue(state);
        } else {
            getMUiState$mvi_debug().setValue(state);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void ensureAttach() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        } else if (!this.mIsAttached) {
            c.f337783b.b(TAG, "this AioContext cannot Attach, please check your call");
        }
    }

    @NotNull
    public final Context getMContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Context) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        Context context = this.mContext;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        }
        return context;
    }

    @NotNull
    public final Handler getMMainHandler() {
        Object value;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            value = iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            value = this.mMainHandler.getValue();
        }
        return (Handler) value;
    }

    @NotNull
    public final MVILiveData getMUiState$mvi_debug() {
        Object value;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            value = iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            value = this.mUiState.getValue();
        }
        return (MVILiveData) value;
    }

    public final boolean getOptLiveData$mvi_debug() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.optLiveData;
    }

    @Nullable
    public final Context getSafetyContext() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Context) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        Context context = this.mContext;
        if (context != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return null;
        }
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        }
        return context;
    }

    public void handleIntent(@NotNull I intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) intent);
        } else {
            Intrinsics.checkNotNullParameter(intent, "intent");
            b.a.a(this, intent);
        }
    }

    public final void observe$mvi_debug(@NotNull Observer<?> observer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) observer);
        } else {
            Intrinsics.checkNotNullParameter(observer, "observer");
            innerRegisterLiveData(getMUiState$mvi_debug(), observer);
        }
    }

    public boolean observerState(@NotNull LiveData<S> stateLiveData, @NotNull Observer<S> observer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this, (Object) stateLiveData, (Object) observer)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(stateLiveData, "stateLiveData");
        Intrinsics.checkNotNullParameter(observer, "observer");
        return b.a.b(this, stateLiveData, observer);
    }

    @Override // 
    public void onCreate(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) context);
        } else {
            Intrinsics.checkNotNullParameter(context, "context");
            b.a.c(this, context);
        }
    }

    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
        } else {
            b.a.d(this);
        }
    }

    public final void setMContext(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
        } else {
            Intrinsics.checkNotNullParameter(context, "<set-?>");
            this.mContext = context;
        }
    }

    public final void setOptLiveData$mvi_debug(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        } else {
            this.optLiveData = z16;
        }
    }

    public final void attach$mvi_debug(@Nullable Collection<String> types, @NotNull Observer<?> observer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) types, (Object) observer);
            return;
        }
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (types == null || types.isEmpty()) {
            return;
        }
        Iterator<T> it = types.iterator();
        while (it.hasNext()) {
            getMChildrenUiStateV1().put((String) it.next(), null);
        }
        this.mVBObserver = observer;
    }

    @Deprecated(message = "\u5e9f\u5f03", replaceWith = @ReplaceWith(expression = "safetyContext", imports = {}))
    public static /* synthetic */ void getMContext$annotations() {
    }
}
