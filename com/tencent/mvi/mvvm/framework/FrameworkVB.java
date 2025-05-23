package com.tencent.mvi.mvvm.framework;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.CallSuper;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;
import com.tencent.mvi.api.runtime.b;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.exception.MviException;
import com.tencent.mvi.log.c;
import com.tencent.mvi.mvvm.BaseVB;
import com.tencent.mvi.mvvm.BaseVM;
import com.tencent.mvi.mvvm.a;
import com.tencent.mvi.mvvm.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ol3.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010!\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u0000 h*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u0003*\b\b\u0002\u0010\u0006*\u00020\u00052\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00072\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\b:\u0001iB\u0007\u00a2\u0006\u0004\bf\u0010gJ\b\u0010\n\u001a\u00020\tH\u0002J9\u0010\u000f\u001a\u00020\t2\u001c\u0010\f\u001a\u0018\u0012\u0006\b\u0001\u0012\u00020\u0001\u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00020\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J0\u0010\u0013\u001a\u00020\t2\u001c\u0010\f\u001a\u0018\u0012\u0006\b\u0001\u0012\u00020\u0001\u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J&\u0010\u0014\u001a\u00020\t2\u001c\u0010\f\u001a\u0018\u0012\u0006\b\u0001\u0012\u00020\u0001\u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00020\u000bH\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u0019\u001a\u0004\u0018\u00010\u0017J$\u0010\u001a\u001a\u00020\t2\u001c\u0010\f\u001a\u0018\u0012\u0006\b\u0001\u0012\u00020\u0001\u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00020\u000bJ,\u0010\u001a\u001a\u00020\t2\u001c\u0010\f\u001a\u0018\u0012\u0006\b\u0001\u0012\u00020\u0001\u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rJ&\u0010\u001b\u001a\u00020\t2\u001c\u0010\f\u001a\u0018\u0012\u0006\b\u0001\u0012\u00020\u0001\u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00020\u000bH\u0016J$\u0010\u001e\u001a\u00020\t2\u001a\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u001cH&J\u0010\u0010!\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u001fH\u0016J\b\u0010\"\u001a\u00020\tH\u0017J,\u0010)\u001a\u00020\u00172\u0006\u0010$\u001a\u00020#2\u0006\u0010&\u001a\u00020%2\b\b\u0002\u0010(\u001a\u00020'2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\"\u0010*\u001a\u00020\u00172\u0006\u0010$\u001a\u00020#2\u0006\u0010&\u001a\u00020%2\b\b\u0002\u0010(\u001a\u00020'H\u0016J\u0006\u0010+\u001a\u00020\tJ\"\u0010-\u001a\u00020\t2\u0018\u0010,\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u001cH\u0016J+\u0010/\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u001c2\u0006\u0010.\u001a\u00028\u0002H\u0016\u00a2\u0006\u0004\b/\u00100J\u0006\u00101\u001a\u00020\tJ\u0017\u00102\u001a\u00020\t2\u0006\u0010.\u001a\u00028\u0002H\u0017\u00a2\u0006\u0004\b2\u00103J\u0006\u00104\u001a\u00020\tJ\b\u00105\u001a\u00020\tH\u0017J\b\u00106\u001a\u00020\tH\u0007J&\u00107\u001a\u00020\t2\u001c\u0010\f\u001a\u0018\u0012\u0006\b\u0001\u0012\u00020\u0001\u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00020\u000bH\u0016J$\u00108\u001a\u00020\t2\u001c\u0010\f\u001a\u0018\u0012\u0006\b\u0001\u0012\u00020\u0001\u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00020\u000bRL\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u001c2\u001a\u00109\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u001c8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u001d\u0010:\u001a\u0004\b;\u0010<R*\u0010=\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010:R3\u0010?\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0006\b\u0001\u0012\u00020\u0001\u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00020\u000b0>8\u0006\u00a2\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR$\u0010C\u001a\u0004\u0018\u00018\u00028\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u00103R\"\u0010H\u001a\u00020\u00178\u0000@\u0000X\u0080.\u00a2\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\"\u0010N\u001a\u00020#8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\"\u0010T\u001a\u00020'8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\"\u0010Z\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bZ\u0010[\u001a\u0004\bZ\u0010\\\"\u0004\b]\u0010^R6\u0010`\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0018\u00010_8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b`\u0010a\u001a\u0004\bb\u0010c\"\u0004\bd\u0010e\u00a8\u0006j"}, d2 = {"Lcom/tencent/mvi/mvvm/framework/FrameworkVB;", "Lol3/b;", "I", "Lcom/tencent/mvi/base/mvi/MviUIState;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mvi/api/runtime/b;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mvi/mvvm/a;", "Lcom/tencent/mvi/mvvm/b;", "", "handleBuildChildVM", "Lcom/tencent/mvi/mvvm/BaseVB;", "child", "", "index", "buildChildVB", "(Lcom/tencent/mvi/mvvm/BaseVB;Ljava/lang/Integer;)V", "Lcom/tencent/mvi/api/runtime/a;", QAdVrReport.ElementID.AD_POSTER, "preBuildChildVB", "buildChildVM", "", "legalGroup", "Landroid/view/View;", "getHostView", "safetyGetHostView", "addChildVB", "removeChildVB", "Lcom/tencent/mvi/mvvm/BaseVM;", "mUIModel", "afterCreateVM", "Lcom/tencent/mvi/api/help/b;", "params", "resumeVB", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/content/Context;", "outContext", "Landroid/view/ViewGroup;", "viewGroup", "Lcom/tencent/mvi/runtime/strategy/b;", "strategyService", "preBuildViewTree", "buildViewTree", "preCreateVM", "vm", "attachVM", "context", "buildVM", "(Lcom/tencent/mvi/api/runtime/b;)Lcom/tencent/mvi/mvvm/BaseVM;", "handleAfterCreateVM", "handleCreateVM", "(Lcom/tencent/mvi/api/runtime/b;)V", "handleCompleteBuildVM", "destroy", "destroyVM", "attachChildVB", "detachChildVB", "<set-?>", "Lcom/tencent/mvi/mvvm/BaseVM;", "getMUIModel", "()Lcom/tencent/mvi/mvvm/BaseVM;", "preCreateUIModel", "", "mChildren", "Ljava/util/List;", "getMChildren", "()Ljava/util/List;", "mMviContext", "Lcom/tencent/mvi/api/runtime/b;", "getMMviContext$mvi_debug", "()Lcom/tencent/mvi/api/runtime/b;", "setMMviContext$mvi_debug", "mHost", "Landroid/view/View;", "getMHost$mvi_debug", "()Landroid/view/View;", "setMHost$mvi_debug", "(Landroid/view/View;)V", "mContext", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "mStrategyService", "Lcom/tencent/mvi/runtime/strategy/b;", "getMStrategyService", "()Lcom/tencent/mvi/runtime/strategy/b;", "setMStrategyService", "(Lcom/tencent/mvi/runtime/strategy/b;)V", "isPreload", "Z", "()Z", "setPreload", "(Z)V", "Lnl3/a;", "mVmIVMProvider", "Lnl3/a;", "getMVmIVMProvider", "()Lnl3/a;", "setMVmIVMProvider", "(Lnl3/a;)V", "<init>", "()V", "Companion", "a", "mvi_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes21.dex */
public abstract class FrameworkVB<I extends ol3.b, S extends MviUIState, C extends com.tencent.mvi.api.runtime.b> implements com.tencent.mvi.mvvm.a<I, S, C>, com.tencent.mvi.mvvm.b<I, S, C> {
    static IPatchRedirector $redirector_ = null;

    @NotNull
    private static final a Companion;

    @Deprecated
    @NotNull
    public static final String TAG = "FrameworkVB_Debug";
    private boolean isPreload;

    @NotNull
    private final List<BaseVB<? extends ol3.b, ? extends MviUIState, C>> mChildren;
    public Context mContext;
    public View mHost;

    @Nullable
    private C mMviContext;
    public com.tencent.mvi.runtime.strategy.b mStrategyService;

    @Nullable
    private BaseVM<I, S, C> mUIModel;

    @Nullable
    private nl3.a<I, S, C> mVmIVMProvider;
    private BaseVM<I, S, C> preCreateUIModel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mvi/mvvm/framework/FrameworkVB$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "mvi_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes21.dex */
    private static final class a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15178);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 35)) {
            redirector.redirect((short) 35);
        } else {
            Companion = new a(null);
        }
    }

    public FrameworkVB() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this);
        } else {
            this.mChildren = new ArrayList();
        }
    }

    private final void buildChildVB(BaseVB<? extends ol3.b, ? extends MviUIState, C> child, Integer index) {
        Context context = this.mContext;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        }
        View view = this.mHost;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHost");
        }
        if (view != null) {
            ViewGroup viewGroup = (ViewGroup) view;
            com.tencent.mvi.runtime.strategy.b bVar = this.mStrategyService;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mStrategyService");
            }
            View buildViewTree = child.buildViewTree(context, viewGroup, bVar);
            if (buildViewTree.getParent() == null) {
                if (this.mHost == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mHost");
                }
                if (!Intrinsics.areEqual(r0, buildViewTree)) {
                    if (index == null) {
                        View view2 = this.mHost;
                        if (view2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mHost");
                        }
                        if (view2 != null) {
                            ((ViewGroup) view2).addView(buildViewTree);
                            return;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
                    }
                    View view3 = this.mHost;
                    if (view3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mHost");
                    }
                    if (view3 != null) {
                        ((ViewGroup) view3).addView(buildViewTree, index.intValue());
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
                }
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    static /* synthetic */ void buildChildVB$default(FrameworkVB frameworkVB, BaseVB baseVB, Integer num, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                num = null;
            }
            frameworkVB.buildChildVB(baseVB, num);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: buildChildVB");
    }

    private final void buildChildVM(BaseVB<? extends ol3.b, ? extends MviUIState, C> child) {
        C c16 = this.mMviContext;
        if (c16 == null) {
            c.f337783b.b(TAG, "mMviContext is Null !!");
        } else {
            Intrinsics.checkNotNull(c16);
            child.buildVM(c16);
        }
    }

    public static /* synthetic */ View buildViewTree$default(FrameworkVB frameworkVB, Context context, ViewGroup viewGroup, com.tencent.mvi.runtime.strategy.b bVar, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 4) != 0) {
                bVar = new com.tencent.mvi.runtime.strategy.a();
            }
            return frameworkVB.buildViewTree(context, viewGroup, bVar);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: buildViewTree");
    }

    private final void handleBuildChildVM() {
        Iterator<T> it = this.mChildren.iterator();
        while (it.hasNext()) {
            buildChildVM((BaseVB) it.next());
        }
    }

    private final boolean legalGroup() {
        View view = this.mHost;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHost");
        }
        return view instanceof ViewGroup;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void preBuildChildVB(BaseVB<? extends ol3.b, ? extends MviUIState, C> child, com.tencent.mvi.api.runtime.a poster) {
        Context context = this.mContext;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        }
        View view = this.mHost;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHost");
        }
        if (view != null) {
            ViewGroup viewGroup = (ViewGroup) view;
            com.tencent.mvi.runtime.strategy.b bVar = this.mStrategyService;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mStrategyService");
            }
            View preBuildViewTree = child.preBuildViewTree(context, viewGroup, bVar, poster);
            if (preBuildViewTree.getParent() == null) {
                if (this.mHost == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mHost");
                }
                if (!Intrinsics.areEqual(r8, preBuildViewTree)) {
                    View view2 = this.mHost;
                    if (view2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mHost");
                    }
                    if (view2 != null) {
                        ((ViewGroup) view2).addView(preBuildViewTree);
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
                }
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public static /* synthetic */ View preBuildViewTree$default(FrameworkVB frameworkVB, Context context, ViewGroup viewGroup, com.tencent.mvi.runtime.strategy.b bVar, com.tencent.mvi.api.runtime.a aVar, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 4) != 0) {
                bVar = new com.tencent.mvi.runtime.strategy.a();
            }
            return frameworkVB.preBuildViewTree(context, viewGroup, bVar, aVar);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: preBuildViewTree");
    }

    public final void addChildVB(@NotNull BaseVB<? extends ol3.b, ? extends MviUIState, C> child) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) child);
            return;
        }
        Intrinsics.checkNotNullParameter(child, "child");
        if (legalGroup()) {
            this.mChildren.add(child);
            buildChildVB$default(this, child, null, 2, null);
            buildChildVM(child);
            return;
        }
        throw new MviException("view vb can not add Child ");
    }

    public abstract void afterCreateVM(@Nullable BaseVM<I, S, C> mUIModel);

    public void attachChildVB(@NotNull BaseVB<? extends ol3.b, ? extends MviUIState, C> child) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) child);
            return;
        }
        Intrinsics.checkNotNullParameter(child, "child");
        this.mChildren.add(child);
        View safetyGetHostView = child.safetyGetHostView();
        if (safetyGetHostView != null && safetyGetHostView.getParent() == null) {
            if (this.mHost == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHost");
            }
            if (!Intrinsics.areEqual(r0, safetyGetHostView)) {
                View view = this.mHost;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mHost");
                }
                if (view != null) {
                    ((ViewGroup) view).addView(safetyGetHostView);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
            }
        }
    }

    public void attachVM(@NotNull BaseVM<I, S, C> vm5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) vm5);
        } else {
            Intrinsics.checkNotNullParameter(vm5, "vm");
            this.mUIModel = vm5;
        }
    }

    public void bindViewAndData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this);
        } else {
            b.a.a(this);
        }
    }

    @Nullable
    public BaseVM<I, S, C> buildVM(@NotNull C context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (BaseVM) iPatchRedirector.redirect((short) 26, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        handleCreateVM(context);
        handleAfterCreateVM();
        handleBuildChildVM();
        handleCompleteBuildVM();
        return this.mUIModel;
    }

    @NotNull
    public View buildViewTree(@NotNull Context outContext, @NotNull ViewGroup viewGroup, @NotNull com.tencent.mvi.runtime.strategy.b strategyService) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (View) iPatchRedirector.redirect((short) 23, this, outContext, viewGroup, strategyService);
        }
        Intrinsics.checkNotNullParameter(outContext, "outContext");
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        Intrinsics.checkNotNullParameter(strategyService, "strategyService");
        this.mContext = outContext;
        this.mStrategyService = strategyService;
        onPreCreate();
        Context context = this.mContext;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        }
        View onCreateView = onCreateView(new com.tencent.mvi.api.help.a(context, viewGroup));
        this.mHost = onCreateView;
        List<BaseVB<? extends ol3.b, ? extends MviUIState, C>> list = this.mChildren;
        if (onCreateView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHost");
        }
        list.addAll(initializeChildVB(onCreateView));
        if (legalGroup()) {
            Iterator<T> it = this.mChildren.iterator();
            while (it.hasNext()) {
                BaseVB baseVB = (BaseVB) it.next();
                baseVB.setPreload(this.isPreload);
                buildChildVB$default(this, baseVB, null, 2, null);
            }
        }
        View view = this.mHost;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHost");
        }
        return view;
    }

    @Nullable
    public BaseVM<I, S, C> createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return (BaseVM) iPatchRedirector.redirect((short) 38, (Object) this);
        }
        return b.a.b(this);
    }

    @CallSuper
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this);
            return;
        }
        Iterator<T> it = this.mChildren.iterator();
        while (it.hasNext()) {
            ((BaseVB) it.next()).destroy();
        }
        destroyVM();
        this.mUIModel = null;
        onDestroy();
        this.mMviContext = null;
    }

    @CallSuper
    public final void destroyVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this);
            return;
        }
        BaseVM<I, S, C> baseVM = this.mUIModel;
        if (baseVM != null) {
            baseVM.destroy$mvi_debug();
        }
        this.mUIModel = null;
    }

    public final void detachChildVB(@NotNull BaseVB<? extends ol3.b, ? extends MviUIState, C> child) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) child);
            return;
        }
        Intrinsics.checkNotNullParameter(child, "child");
        this.mChildren.remove(child);
        View safetyGetHostView = child.safetyGetHostView();
        if (safetyGetHostView != null) {
            View view = this.mHost;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHost");
            }
            if (view != null) {
                ((ViewGroup) view).removeView(safetyGetHostView);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        }
    }

    @NotNull
    public View getHostView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (View) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        View view = this.mHost;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHost");
        }
        return view;
    }

    @NotNull
    public final List<BaseVB<? extends ol3.b, ? extends MviUIState, C>> getMChildren() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mChildren;
    }

    @NotNull
    public final Context getMContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Context) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        Context context = this.mContext;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        }
        return context;
    }

    @NotNull
    public final View getMHost$mvi_debug() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (View) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        View view = this.mHost;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHost");
        }
        return view;
    }

    @Nullable
    public final C getMMviContext$mvi_debug() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (C) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mMviContext;
    }

    @NotNull
    public final com.tencent.mvi.runtime.strategy.b getMStrategyService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (com.tencent.mvi.runtime.strategy.b) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        com.tencent.mvi.runtime.strategy.b bVar = this.mStrategyService;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mStrategyService");
        }
        return bVar;
    }

    @Nullable
    public final BaseVM<I, S, C> getMUIModel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (BaseVM) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.mUIModel;
    }

    @Nullable
    public nl3.a<I, S, C> getMVmIVMProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (nl3.a) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.mVmIVMProvider;
    }

    @NotNull
    public List<Class<? extends S>> getObserverStates() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return (List) iPatchRedirector.redirect((short) 42, (Object) this);
        }
        return b.a.c(this);
    }

    public final void handleAfterCreateVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
        } else {
            afterCreateVM(this.mUIModel);
        }
    }

    public final void handleCompleteBuildVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this);
            return;
        }
        nl3.a<I, S, C> mVmIVMProvider = getMVmIVMProvider();
        if (mVmIVMProvider != null) {
            mVmIVMProvider.b(this.mUIModel);
        } else {
            BaseVM<I, S, C> baseVM = this.mUIModel;
            if (baseVM != null) {
                baseVM.create();
            }
        }
        bindViewAndData();
    }

    @CallSuper
    public void handleCreateVM(@NotNull C context) {
        nl3.a<I, S, C> mVmIVMProvider;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        this.mMviContext = context;
        BaseVM<I, S, C> baseVM = this.preCreateUIModel;
        if (baseVM == null && ((mVmIVMProvider = getMVmIVMProvider()) == null || (baseVM = mVmIVMProvider.a()) == null)) {
            baseVM = createVM();
        }
        if (baseVM != null) {
            baseVM.attach(context);
            Unit unit = Unit.INSTANCE;
        } else {
            baseVM = null;
        }
        this.mUIModel = baseVM;
        this.preCreateUIModel = null;
    }

    @NotNull
    public List<BaseVB<? extends ol3.b, ? extends MviUIState, C>> initializeChildVB() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 37)) ? a.C9236a.a(this) : (List) iPatchRedirector.redirect((short) 37, (Object) this);
    }

    public final boolean isPreload() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return this.isPreload;
    }

    @CallSuper
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
        }
    }

    public void onPreCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this);
        } else {
            b.a.d(this);
        }
    }

    public void onReuseView(@NotNull com.tencent.mvi.api.help.b reuseParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this, (Object) reuseParam);
        } else {
            Intrinsics.checkNotNullParameter(reuseParam, "reuseParam");
            b.a.e(this, reuseParam);
        }
    }

    @NotNull
    public View preBuildViewTree(@NotNull Context outContext, @NotNull ViewGroup viewGroup, @NotNull com.tencent.mvi.runtime.strategy.b strategyService, @Nullable final com.tencent.mvi.api.runtime.a poster) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (View) iPatchRedirector.redirect((short) 22, this, outContext, viewGroup, strategyService, poster);
        }
        Intrinsics.checkNotNullParameter(outContext, "outContext");
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        Intrinsics.checkNotNullParameter(strategyService, "strategyService");
        this.mContext = outContext;
        this.mStrategyService = strategyService;
        onPreCreate();
        Context context = this.mContext;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
        }
        View onCreateView = onCreateView(new com.tencent.mvi.api.help.a(context, viewGroup));
        this.mHost = onCreateView;
        List<BaseVB<? extends ol3.b, ? extends MviUIState, C>> list = this.mChildren;
        if (onCreateView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHost");
        }
        list.addAll(initializeChildVB(onCreateView));
        if (legalGroup()) {
            for (final BaseVB<? extends ol3.b, ? extends MviUIState, C> baseVB : this.mChildren) {
                baseVB.setPreload(this.isPreload);
                if (poster == null) {
                    preBuildChildVB(baseVB, poster);
                } else {
                    poster.f(new Runnable(this, poster) { // from class: com.tencent.mvi.mvvm.framework.FrameworkVB$preBuildViewTree$$inlined$let$lambda$1
                        static IPatchRedirector $redirector_;

                        /* renamed from: e, reason: collision with root package name */
                        final /* synthetic */ com.tencent.mvi.api.runtime.a f337794e;
                        final /* synthetic */ FrameworkVB this$0;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.this$0 = this;
                            this.f337794e = poster;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, this, BaseVB.this, this, poster);
                            }
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                                this.this$0.preBuildChildVB(BaseVB.this, this.f337794e);
                            } else {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            }
                        }
                    });
                }
            }
        }
        View view = this.mHost;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHost");
        }
        return view;
    }

    public final void preCreateVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        this.preCreateUIModel = createVM();
        Iterator<T> it = this.mChildren.iterator();
        while (it.hasNext()) {
            ((BaseVB) it.next()).preCreateVM();
        }
    }

    public void removeChildVB(@NotNull BaseVB<? extends ol3.b, ? extends MviUIState, C> child) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) child);
            return;
        }
        Intrinsics.checkNotNullParameter(child, "child");
        if (legalGroup()) {
            this.mChildren.remove(child);
            child.destroy();
            View hostView = child.getHostView();
            if (hostView != null && (hostView.getParent() instanceof ViewGroup)) {
                ViewParent parent = hostView.getParent();
                if (parent != null) {
                    ((ViewGroup) parent).removeView(hostView);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
            }
            return;
        }
        throw new MviException("view vb can not remove Child ");
    }

    public void resumeVB(@NotNull com.tencent.mvi.api.help.b params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) params);
            return;
        }
        Intrinsics.checkNotNullParameter(params, "params");
        onReuseView(params);
        Iterator<T> it = this.mChildren.iterator();
        while (it.hasNext()) {
            ((BaseVB) it.next()).resumeVB(params);
        }
    }

    @Nullable
    public final View safetyGetHostView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (View) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        View view = this.mHost;
        if (view != null) {
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHost");
            }
            return view;
        }
        return null;
    }

    public final void setMContext(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) context);
        } else {
            Intrinsics.checkNotNullParameter(context, "<set-?>");
            this.mContext = context;
        }
    }

    public final void setMHost$mvi_debug(@NotNull View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view);
        } else {
            Intrinsics.checkNotNullParameter(view, "<set-?>");
            this.mHost = view;
        }
    }

    public final void setMMviContext$mvi_debug(@Nullable C c16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) c16);
        } else {
            this.mMviContext = c16;
        }
    }

    public final void setMStrategyService(@NotNull com.tencent.mvi.runtime.strategy.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) bVar);
        } else {
            Intrinsics.checkNotNullParameter(bVar, "<set-?>");
            this.mStrategyService = bVar;
        }
    }

    public void setMVmIVMProvider(@Nullable nl3.a<I, S, C> aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) aVar);
        } else {
            this.mVmIVMProvider = aVar;
        }
    }

    public final void setPreload(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
        } else {
            this.isPreload = z16;
        }
    }

    @NotNull
    public List<BaseVB<? extends ol3.b, ? extends MviUIState, C>> initializeChildVB(@NotNull View hostView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return (List) iPatchRedirector.redirect((short) 36, (Object) this, (Object) hostView);
        }
        Intrinsics.checkNotNullParameter(hostView, "hostView");
        return a.C9236a.b(this, hostView);
    }

    public final void addChildVB(@NotNull BaseVB<? extends ol3.b, ? extends MviUIState, C> child, int index) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) child, index);
            return;
        }
        Intrinsics.checkNotNullParameter(child, "child");
        if (legalGroup()) {
            this.mChildren.add(index, child);
            buildChildVB$default(this, child, null, 2, null);
            buildChildVM(child);
            return;
        }
        throw new MviException("view vb can not add Child ");
    }
}
