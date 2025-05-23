package com.tencent.qqnt.chathistory.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResultCaller;
import androidx.annotation.CallSuper;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqnt.chathistory.ui.base.BaseHistoryViewModel;
import com.tencent.qqnt.chathistory.ui.widget.ChatHistoryGestureLayout;
import com.tencent.qqnt.chathistory.ui.widget.bottomBar.BottomBarOperationType;
import com.tencent.qqnt.chathistory.ui.widget.bottomBar.BottomBarType;
import com.tencent.qqnt.chathistory.ui.widget.bottomBar.HistoryBottomBarHelper;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\b&\u0018\u0000*\u0010\b\u0000\u0010\u0002*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00012\u00020\u0003B\u0007\u00a2\u0006\u0004\b7\u00108J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0002J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u000f\u0010\f\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\f\u0010\rJ$\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\t\u001a\u0004\u0018\u00010\bJ&\u0010\u0014\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\t\u001a\u0004\u0018\u00010\bH&J\b\u0010\u0015\u001a\u00020\u0004H\u0016JA\u0010\"\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a2!\u0010!\u001a\u001d\u0012\u0013\u0012\u00110\u001d\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00040\u001cJ\u0006\u0010#\u001a\u00020\u0004J\u0018\u0010'\u001a\u00020\u00042\u0006\u0010%\u001a\u00020$2\b\b\u0002\u0010&\u001a\u00020$J\b\u0010(\u001a\u00020\u0004H\u0017R$\u00100\u001a\u0004\u0018\u00010)8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00106\u001a\u00028\u00008\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u0010\r\"\u0004\b4\u00105\u00a8\u00069"}, d2 = {"Lcom/tencent/qqnt/chathistory/ui/base/BaseHistoryFragment;", "Lcom/tencent/qqnt/chathistory/ui/base/BaseHistoryViewModel;", "T", "Landroidx/fragment/app/Fragment;", "", "initViewModel", "fragment", "qh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "clearRestore", "onCreate", "ph", "()Lcom/tencent/qqnt/chathistory/ui/base/BaseHistoryViewModel;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "uh", "th", "", "chatType", "", "peerUid", "Lcom/tencent/qqnt/chathistory/ui/widget/bottomBar/BottomBarType;", "type", "Lkotlin/Function1;", "Lcom/tencent/qqnt/chathistory/ui/widget/bottomBar/BottomBarOperationType;", "Lkotlin/ParameterName;", "name", "operationType", "callback", "yh", "sh", "", "isEnabled", "isFavEnabled", "vh", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "Lcom/tencent/qqnt/chathistory/ui/widget/bottomBar/HistoryBottomBarHelper;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/qqnt/chathistory/ui/widget/bottomBar/HistoryBottomBarHelper;", "getBottomBarHelper$chathistory_impl_release", "()Lcom/tencent/qqnt/chathistory/ui/widget/bottomBar/HistoryBottomBarHelper;", "setBottomBarHelper$chathistory_impl_release", "(Lcom/tencent/qqnt/chathistory/ui/widget/bottomBar/HistoryBottomBarHelper;)V", "bottomBarHelper", "D", "Lcom/tencent/qqnt/chathistory/ui/base/BaseHistoryViewModel;", "rh", "xh", "(Lcom/tencent/qqnt/chathistory/ui/base/BaseHistoryViewModel;)V", "viewModel", "<init>", "()V", "chathistory_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public abstract class BaseHistoryFragment<T extends BaseHistoryViewModel<?, ?>> extends Fragment {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private HistoryBottomBarHelper bottomBarHelper;

    /* renamed from: D, reason: from kotlin metadata */
    public T viewModel;

    public BaseHistoryFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void clearRestore(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            return;
        }
        savedInstanceState.remove("android:fragments");
        savedInstanceState.remove("android:support:fragments");
    }

    private final void initViewModel() {
        Fragment requireParentFragment = requireParentFragment();
        Intrinsics.checkNotNullExpressionValue(requireParentFragment, "requireParentFragment()");
        ActivityResultCaller qh5 = qh(requireParentFragment);
        Intrinsics.checkNotNull(qh5, "null cannot be cast to non-null type com.tencent.qqnt.chathistory.ui.base.IChatHistoryFrameContainer");
        com.tencent.qqnt.chathistory.business.a viewModel = ((h) qh5).viewModel();
        T ph5 = ph();
        ph5.P1(viewModel);
        xh(ph5);
        LifecycleOwnerKt.getLifecycleScope(this).launchWhenStarted(new BaseHistoryFragment$initViewModel$2(this, null));
    }

    private final Fragment qh(Fragment fragment) {
        if (fragment.getParentFragment() != null) {
            Fragment requireParentFragment = fragment.requireParentFragment();
            Intrinsics.checkNotNullExpressionValue(requireParentFragment, "fragment.requireParentFragment()");
            return qh(requireParentFragment);
        }
        return fragment;
    }

    public static /* synthetic */ void wh(BaseHistoryFragment baseHistoryFragment, boolean z16, boolean z17, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                z17 = false;
            }
            baseHistoryFragment.vh(z16, z17);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setBottomBarEnableState");
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) savedInstanceState);
            return;
        }
        clearRestore(savedInstanceState);
        super.onCreate(savedInstanceState);
        initViewModel();
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public final View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View onCreateView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            onCreateView = (View) iPatchRedirector.redirect((short) 8, this, inflater, container, savedInstanceState);
        } else {
            Intrinsics.checkNotNullParameter(inflater, "inflater");
            View uh5 = uh(inflater, container, savedInstanceState);
            if (uh5 != null) {
                Context context = inflater.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "inflater.context");
                ChatHistoryGestureLayout chatHistoryGestureLayout = new ChatHistoryGestureLayout(context);
                chatHistoryGestureLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                chatHistoryGestureLayout.addView(uh5);
                onCreateView = chatHistoryGestureLayout;
            } else {
                onCreateView = super.onCreateView(inflater, container, savedInstanceState);
            }
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView);
        return onCreateView;
    }

    @Override // androidx.fragment.app.Fragment
    @CallSuper
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            super.onPause();
            sh();
        }
    }

    @NotNull
    public T ph() {
        Class cls;
        Method method;
        Type type;
        Class cls2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (T) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        Method[] declaredMethods = getClass().getSuperclass().getDeclaredMethods();
        Intrinsics.checkNotNullExpressionValue(declaredMethods, "myClass.declaredMethods");
        int length = declaredMethods.length;
        int i3 = 0;
        while (true) {
            cls = null;
            if (i3 < length) {
                method = declaredMethods[i3];
                if (Intrinsics.areEqual(method.getName(), "createFragmentViewModel")) {
                    break;
                }
                i3++;
            } else {
                method = null;
                break;
            }
        }
        if (method != null) {
            type = method.getGenericReturnType();
        } else {
            type = null;
        }
        System.out.println(type);
        QLog.d("BaseHistoryFragment", 2, "createFragmentViewModel = " + type);
        boolean z16 = type instanceof ParameterizedType;
        if (z16) {
            Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            if (type2 instanceof Class) {
                cls2 = (Class) type2;
            } else {
                cls2 = null;
            }
            QLog.d("BaseHistoryFragment", 2, "createFragmentViewModel = " + cls2);
        }
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (genericSuperclass instanceof ParameterizedType) {
            Type type3 = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
            if (type3 instanceof Class) {
                cls = (Class) type3;
            }
        } else if (z16) {
            Type type4 = ((ParameterizedType) type).getActualTypeArguments()[0];
            if (type4 instanceof Class) {
                cls = (Class) type4;
            }
        }
        if (cls != null) {
            ViewModel viewModel = new ViewModelProvider(this).get(cls);
            Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this).get(tClass)");
            return (T) viewModel;
        }
        throw new IllegalStateException("BaseHistoryFragment must have a generic type parameter.");
    }

    @NotNull
    public final T rh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (T) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        T t16 = this.viewModel;
        if (t16 != null) {
            return t16;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    public final void sh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        HistoryBottomBarHelper historyBottomBarHelper = this.bottomBarHelper;
        if (historyBottomBarHelper != null) {
            historyBottomBarHelper.n();
        }
    }

    public void th() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        }
    }

    @Nullable
    public abstract View uh(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState);

    public final void vh(boolean isEnabled, boolean isFavEnabled) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Boolean.valueOf(isEnabled), Boolean.valueOf(isFavEnabled));
            return;
        }
        HistoryBottomBarHelper historyBottomBarHelper = this.bottomBarHelper;
        if (historyBottomBarHelper != null) {
            historyBottomBarHelper.q(isEnabled, isFavEnabled);
        }
    }

    public final void xh(@NotNull T t16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) t16);
        } else {
            Intrinsics.checkNotNullParameter(t16, "<set-?>");
            this.viewModel = t16;
        }
    }

    public final void yh(int chatType, @NotNull String peerUid, @NotNull BottomBarType type, @NotNull Function1<? super BottomBarOperationType, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(chatType), peerUid, type, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (this.bottomBarHelper == null) {
            this.bottomBarHelper = new HistoryBottomBarHelper();
        }
        HistoryBottomBarHelper historyBottomBarHelper = this.bottomBarHelper;
        Intrinsics.checkNotNull(historyBottomBarHelper);
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        View view = getView();
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.view.ViewGroup");
        historyBottomBarHelper.r(requireContext, (ViewGroup) view, chatType, peerUid, type, callback);
    }
}
