package com.tencent.richframework.argus.node;

import android.view.View;
import androidx.fragment.app.Argus;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.collection.RFWComparableWeakRef;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.delegate.impl.RFWReporter;
import com.tencent.biz.richframework.util.RFWStringBuilderUtils;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.richframework.lifecycle.RFWViewLifecycleUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0016\u0018\u0000 \u0087\u0001*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0002\u0087\u0001B\u0015\b\u0016\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000\u00a2\u0006\u0002\u0010\u0005B\u0017\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\tJ\u0012\u0010g\u001a\u00020h2\n\u0010i\u001a\u0006\u0012\u0002\b\u00030\u0000J\u0012\u0010j\u001a\u00020\u00182\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0013\u0010k\u001a\u00020\u00182\b\u0010l\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\u0010\u0010m\u001a\u00020\u00122\u0006\u0010n\u001a\u00020\u0002H\u0004J\u0017\u0010o\u001a\u00020\u00122\b\u0010\b\u001a\u0004\u0018\u00018\u0000H\u0016\u00a2\u0006\u0002\u0010pJ\b\u0010q\u001a\u00020rH\u0016J\u0018\u0010s\u001a\u0004\u0018\u00010N2\u0006\u0010t\u001a\u00020\u00182\u0006\u0010u\u001a\u00020\u0018J\b\u0010v\u001a\u00020$H\u0016J\u0012\u0010w\u001a\u00020\u00182\n\u0010x\u001a\u0006\u0012\u0002\b\u00030\u0000J\u000e\u0010y\u001a\u00020\u00182\u0006\u0010z\u001a\u00020NJ\u000e\u0010{\u001a\u00020\u00182\u0006\u0010|\u001a\u00020\u0018J\u0012\u0010}\u001a\u00020h2\n\u0010i\u001a\u0006\u0012\u0002\b\u00030\u0000J\u0010\u0010~\u001a\u00020h2\u0006\u0010\u007f\u001a\u00020AH\u0002J\u0015\u0010\u0080\u0001\u001a\u00020h2\f\u0010B\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0000J\u000f\u0010\u0081\u0001\u001a\u00020h2\u0006\u0010\u007f\u001a\u00020AJ\u0015\u0010\u0082\u0001\u001a\u00020h2\f\u0010a\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0000J\u0012\u0010\u0083\u0001\u001a\u00020$2\u0007\u0010\u0084\u0001\u001a\u00020$H\u0002J\t\u0010\u0085\u0001\u001a\u00020\u0012H\u0016J\t\u0010\u0086\u0001\u001a\u00020hH\u0002R)\u0010\n\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00000\u000bj\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0000`\f8F\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR&\u0010\u000f\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00000\u000bj\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0000`\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0013\u0010\b\u001a\u0004\u0018\u00018\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0012\u0010\u001c\u001a\u0006\u0012\u0002\b\u00030\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020$X\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000&X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R'\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00020,8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b/\u00100\u001a\u0004\b-\u0010.R\u001c\u00101\u001a\u0004\u0018\u00010\u0002X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u001b\"\u0004\b3\u00104R\u001a\u00105\u001a\u00020\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001a\u0010:\u001a\u00020\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b;\u00107\"\u0004\b<\u00109R\u001a\u0010=\u001a\u00020\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b>\u00107\"\u0004\b?\u00109R\u0010\u0010@\u001a\u0004\u0018\u00010AX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010B\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0000X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010C\u001a\u00020\u00188F\u00a2\u0006\u0006\u001a\u0004\bC\u00107R\u0014\u0010D\u001a\u00020\u00188VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bD\u00107R\u001c\u0010E\u001a\u0004\u0018\u00010FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u000e\u0010K\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020AX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0013\u0010M\u001a\u0004\u0018\u00010N8F\u00a2\u0006\u0006\u001a\u0004\bO\u0010PR\u0013\u0010Q\u001a\u0004\u0018\u00010\u00078F\u00a2\u0006\u0006\u001a\u0004\bR\u0010SR\u001a\u0010T\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bU\u0010 \"\u0004\bV\u0010\"R\u000e\u0010W\u001a\u00020$X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010X\u001a\u00020$X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R \u0010]\u001a\b\u0012\u0004\u0012\u00020\u00070&X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b^\u0010(\"\u0004\b_\u0010*R\u0014\u0010`\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0000X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010a\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00008F\u00a2\u0006\u0006\u001a\u0004\bb\u0010cR\u001a\u0010d\u001a\u00020\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\be\u00107\"\u0004\bf\u00109\u00a8\u0006\u0088\u0001"}, d2 = {"Lcom/tencent/richframework/argus/node/ArgusNode;", "T", "", "Landroidx/lifecycle/LifecycleOwner;", "argusNode", "(Lcom/tencent/richframework/argus/node/ArgusNode;)V", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/view/View;", ParseCommon.CONTAINER, "(Landroid/view/View;Ljava/lang/Object;)V", "allChildNode", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "getAllChildNode", "()Ljava/util/LinkedHashSet;", "allChildren", "annotationTags", "", "", "getAnnotationTags", "()Ljava/util/List;", "setAnnotationTags", "(Ljava/util/List;)V", "checkLocation", "", "checkShown", "getContainer", "()Ljava/lang/Object;", "containerClass", "Ljava/lang/Class;", "containerClassName", "getContainerClassName", "()Ljava/lang/String;", "setContainerClassName", "(Ljava/lang/String;)V", "containerHashCode", "", "containerWrf", "Lcom/tencent/biz/richframework/collection/RFWComparableWeakRef;", "getContainerWrf", "()Lcom/tencent/biz/richframework/collection/RFWComparableWeakRef;", "setContainerWrf", "(Lcom/tencent/biz/richframework/collection/RFWComparableWeakRef;)V", "extra", "", "getExtra", "()Ljava/util/Map;", "extra$delegate", "Lkotlin/Lazy;", "extraAnnotation", "getExtraAnnotation", "setExtraAnnotation", "(Ljava/lang/Object;)V", "hasDispatchAdd", "getHasDispatchAdd", "()Z", "setHasDispatchAdd", "(Z)V", "hasDispatchPending", "getHasDispatchPending", "setHasDispatchPending", "hasDispatchShown", "getHasDispatchShown", "setHasDispatchShown", "hostLifecycleState", "Landroidx/lifecycle/Lifecycle$State;", "hostNode", "isRelease", "isSelfVisible", "lifecycleRegistry", "Landroidx/lifecycle/LifecycleRegistry;", "getLifecycleRegistry", "()Landroidx/lifecycle/LifecycleRegistry;", "setLifecycleRegistry", "(Landroidx/lifecycle/LifecycleRegistry;)V", "nodeClassName", "nodeLifecycleState", "nodeTreeTag", "Lcom/tencent/richframework/argus/node/NodePO;", "getNodeTreeTag", "()Lcom/tencent/richframework/argus/node/NodePO;", "nodeView", "getNodeView", "()Landroid/view/View;", "nodeViewClassName", "getNodeViewClassName", "setNodeViewClassName", "nodeViewHashCode", "nodeViewId", "getNodeViewId", "()I", "setNodeViewId", "(I)V", "nodeViewWrf", "getNodeViewWrf", "setNodeViewWrf", HippyNestedScrollComponent.PRIORITY_PARENT, "parentNode", "getParentNode", "()Lcom/tencent/richframework/argus/node/ArgusNode;", "visibleFlag", "getVisibleFlag", "setVisibleFlag", "addChildNode", "", "childNode", "checkShowLocationInWindow", "equals", "other", "getClassDesc", "obj", "getContainerDesc", "(Ljava/lang/Object;)Ljava/lang/String;", "getLifecycle", "Landroidx/lifecycle/Lifecycle;", "getNodeStoreObject", "checkVisible", "considerChildren", "hashCode", "isAncestorOfNode", "node", "isPOGenerateFromNode", "po", "isVisible", "considerParent", "removeChildNode", "setHostLifecycleState", "state", "setHostNode", "setNodeLifecycleState", "setParentNode", "simplifyViewId", "viewId", "toString", "updateNodeLifecycleState", "Companion", "lifecycle_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public class ArgusNode<T> implements LifecycleOwner {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String IGNORE_PARENT_NODE = "IGNORE_PARENT_NODE";

    @NotNull
    public static final String USE_FULL_CLASS_NAME = "USE_FULL_CLASS_NAME";
    private LinkedHashSet<ArgusNode<?>> allChildren;

    @NotNull
    private List<String> annotationTags;
    private boolean checkLocation;
    private boolean checkShown;
    private Class<?> containerClass;

    @NotNull
    private String containerClassName;
    private int containerHashCode;

    @NotNull
    private RFWComparableWeakRef<T> containerWrf;

    /* renamed from: extra$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy extra;

    @Nullable
    private Object extraAnnotation;
    private boolean hasDispatchAdd;
    private boolean hasDispatchPending;
    private boolean hasDispatchShown;
    private Lifecycle.State hostLifecycleState;
    private ArgusNode<?> hostNode;

    @Nullable
    private volatile LifecycleRegistry lifecycleRegistry;
    private String nodeClassName;
    private Lifecycle.State nodeLifecycleState;

    @NotNull
    private String nodeViewClassName;
    private int nodeViewHashCode;
    private int nodeViewId;

    @NotNull
    private RFWComparableWeakRef<View> nodeViewWrf;
    private ArgusNode<?> parent;
    private boolean visibleFlag;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u001a\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/richframework/argus/node/ArgusNode$Companion;", "", "()V", ArgusNode.IGNORE_PARENT_NODE, "", ArgusNode.USE_FULL_CLASS_NAME, "isAncestorOf", "", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "child", "mergeLifecycleState", "Landroidx/lifecycle/Lifecycle$State;", "hostLifecycleState", "nodeLifecycleState", "lifecycle_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes25.dex */
    public static final class Companion {
        Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Lifecycle.State mergeLifecycleState(Lifecycle.State hostLifecycleState, Lifecycle.State nodeLifecycleState) {
            if (hostLifecycleState == null || (hostLifecycleState == Lifecycle.State.RESUMED && nodeLifecycleState != Lifecycle.State.INITIALIZED)) {
                return nodeLifecycleState;
            }
            return hostLifecycleState;
        }

        public final boolean isAncestorOf(@Nullable View parent, @Nullable View child) {
            if (child == null) {
                return false;
            }
            if (child == parent) {
                return true;
            }
            Object parent2 = child.getParent();
            if (!(parent2 instanceof View)) {
                return false;
            }
            return isAncestorOf(parent, (View) parent2);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ArgusNode(@NotNull ArgusNode<T> argusNode) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(argusNode, "argusNode");
        this.nodeViewId = -1;
        this.containerClassName = "";
        this.nodeViewClassName = "";
        String simpleName = getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
        this.nodeClassName = simpleName;
        this.allChildren = new LinkedHashSet<>();
        this.nodeLifecycleState = Lifecycle.State.INITIALIZED;
        this.annotationTags = new ArrayList();
        lazy = LazyKt__LazyJVMKt.lazy(ArgusNode$extra$2.INSTANCE);
        this.extra = lazy;
        this.nodeViewWrf = argusNode.nodeViewWrf;
        this.containerWrf = argusNode.containerWrf;
        this.nodeViewClassName = argusNode.nodeViewClassName;
        this.nodeViewId = argusNode.nodeViewId;
        this.containerClassName = argusNode.containerClassName;
        this.containerClass = argusNode.containerClass;
        this.nodeViewHashCode = argusNode.nodeViewHashCode;
        this.containerHashCode = argusNode.containerHashCode;
        this.annotationTags = argusNode.annotationTags;
        this.allChildren = argusNode.allChildren;
        this.parent = argusNode.getParentNode();
    }

    private final boolean checkShowLocationInWindow(View rootView) {
        boolean z16;
        int i3;
        if (!this.checkLocation) {
            return true;
        }
        int[] iArr = new int[2];
        if (rootView == null) {
            return false;
        }
        rootView.getLocationOnScreen(iArr);
        int i16 = iArr[0];
        if (i16 >= 0 && i16 < DisplayUtil.getInstantScreenWidth(rootView.getContext()) && (i3 = iArr[1]) >= 0 && i3 < DisplayUtil.getInstantScreenHeight(rootView.getContext())) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            RFWLog.i(Argus.TAG, RFWLog.USR, " location x:" + iArr[0] + " y:" + iArr[1] + " node:" + this);
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setHostLifecycleState(Lifecycle.State state) {
        this.hostLifecycleState = state;
        updateNodeLifecycleState();
    }

    private final int simplifyViewId(int viewId) {
        if (viewId < 16777215) {
            return -1;
        }
        return viewId;
    }

    private final void updateNodeLifecycleState() {
        Lifecycle.State state;
        boolean z16;
        LifecycleRegistry lifecycleRegistry;
        Lifecycle.State mergeLifecycleState = INSTANCE.mergeLifecycleState(this.hostLifecycleState, this.nodeLifecycleState);
        LifecycleRegistry lifecycleRegistry2 = this.lifecycleRegistry;
        if (lifecycleRegistry2 != null) {
            state = lifecycleRegistry2.getCurrentState();
        } else {
            state = null;
        }
        if (state != mergeLifecycleState) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && (lifecycleRegistry = this.lifecycleRegistry) != null) {
            lifecycleRegistry.setCurrentState(mergeLifecycleState);
        }
        if (Argus.INSTANCE.isDebug()) {
            RFWLog.i(Argus.TAG, RFWLog.USR, "updateNodeLifecycleState: hostLifecycleState:" + this.hostLifecycleState + " nodeLifecycleState:" + this.nodeLifecycleState + " mergeState:" + mergeLifecycleState + TokenParser.SP + this + " preState:" + state + " needChange:" + z16);
        }
    }

    public final void addChildNode(@NotNull ArgusNode<?> childNode) {
        Intrinsics.checkNotNullParameter(childNode, "childNode");
        this.allChildren.add(childNode);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ArgusNode)) {
            return false;
        }
        ArgusNode argusNode = (ArgusNode) other;
        if (Objects.equals(this.nodeViewWrf, argusNode.nodeViewWrf) && Objects.equals(this.containerWrf, argusNode.containerWrf)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final LinkedHashSet<ArgusNode<?>> getAllChildNode() {
        LinkedHashSet<ArgusNode<?>> allChildNode;
        ArgusNode<?> argusNode = this.hostNode;
        if (argusNode == null || (allChildNode = argusNode.getAllChildNode()) == null) {
            return this.allChildren;
        }
        return allChildNode;
    }

    @NotNull
    public final List<String> getAnnotationTags() {
        return this.annotationTags;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final String getClassDesc(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        if (this.annotationTags.contains(USE_FULL_CLASS_NAME)) {
            String name = obj.getClass().getName();
            Intrinsics.checkNotNullExpressionValue(name, "obj.javaClass.name");
            return name;
        }
        String simpleName = obj.getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "obj.javaClass.simpleName");
        return simpleName;
    }

    @Nullable
    public final T getContainer() {
        return this.containerWrf.get();
    }

    @NotNull
    public final String getContainerClassName() {
        return this.containerClassName;
    }

    @NotNull
    public String getContainerDesc(@Nullable T container) {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final RFWComparableWeakRef<T> getContainerWrf() {
        return this.containerWrf;
    }

    @NotNull
    public final Map<String, Object> getExtra() {
        return (Map) this.extra.getValue();
    }

    @Nullable
    public final Object getExtraAnnotation() {
        return this.extraAnnotation;
    }

    public final boolean getHasDispatchAdd() {
        return this.hasDispatchAdd;
    }

    public final boolean getHasDispatchPending() {
        return this.hasDispatchPending;
    }

    public final boolean getHasDispatchShown() {
        return this.hasDispatchShown;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    @NotNull
    public Lifecycle getLifecycle() {
        if (this.lifecycleRegistry == null) {
            synchronized (ArgusNode.class) {
                if (this.lifecycleRegistry == null) {
                    LifecycleOwner viewLifecycleOwner = RFWViewLifecycleUtil.getViewLifecycleOwner(this.nodeViewWrf.get(), false);
                    if (viewLifecycleOwner != null) {
                        final Lifecycle lifecycle = viewLifecycleOwner.getLifecycle();
                        Intrinsics.checkNotNullExpressionValue(lifecycle, "hostViewLifecycleOwner.lifecycle");
                        Lifecycle.State currentState = lifecycle.getCurrentState();
                        Intrinsics.checkNotNullExpressionValue(currentState, "hostLifecycle.currentState");
                        setHostLifecycleState(currentState);
                        lifecycle.addObserver(new LifecycleEventObserver() { // from class: com.tencent.richframework.argus.node.ArgusNode$getLifecycle$$inlined$synchronized$lambda$1
                            @Override // androidx.lifecycle.LifecycleEventObserver
                            public final void onStateChanged(@Nullable LifecycleOwner lifecycleOwner, @Nullable Lifecycle.Event event) {
                                ArgusNode argusNode = this;
                                Lifecycle.State currentState2 = Lifecycle.this.getCurrentState();
                                Intrinsics.checkNotNullExpressionValue(currentState2, "hostLifecycle.currentState");
                                argusNode.setHostLifecycleState(currentState2);
                            }
                        });
                    } else {
                        RFWLog.e(Argus.TAG, RFWLog.USR, toString());
                        RFWReporter.reportThrowableCache(new RuntimeException("NodeEmptyLifecycle"));
                    }
                    this.lifecycleRegistry = new LifecycleRegistry(this);
                    LifecycleRegistry lifecycleRegistry = this.lifecycleRegistry;
                    if (lifecycleRegistry != null) {
                        lifecycleRegistry.setCurrentState(INSTANCE.mergeLifecycleState(this.hostLifecycleState, this.nodeLifecycleState));
                    }
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        LifecycleRegistry lifecycleRegistry2 = this.lifecycleRegistry;
        Intrinsics.checkNotNull(lifecycleRegistry2);
        return lifecycleRegistry2;
    }

    @Nullable
    public final LifecycleRegistry getLifecycleRegistry() {
        return this.lifecycleRegistry;
    }

    @Nullable
    public final NodePO getNodeStoreObject(boolean checkVisible, boolean considerChildren) {
        if (checkVisible && !this.visibleFlag) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (considerChildren) {
            Iterator<ArgusNode<?>> it = this.allChildren.iterator();
            while (it.hasNext()) {
                NodePO nodeStoreObject = it.next().getNodeStoreObject(checkVisible, true);
                if (nodeStoreObject != null) {
                    arrayList.add(nodeStoreObject);
                }
            }
        }
        String str = this.nodeClassName;
        String str2 = this.nodeViewClassName;
        int i3 = this.nodeViewId;
        String name = this.containerClass.getName();
        Intrinsics.checkNotNullExpressionValue(name, "containerClass.name");
        return new NodePO(str, str2, i3, name, getContainerDesc(this.containerWrf.get()), arrayList, this.annotationTags);
    }

    @Nullable
    public final NodePO getNodeTreeTag() {
        NodePO nodeStoreObject = getNodeStoreObject(false, false);
        if (nodeStoreObject != null) {
            if (this.annotationTags.contains(IGNORE_PARENT_NODE)) {
                return nodeStoreObject;
            }
            ArgusNode<?> parentNode = getParentNode();
            while (parentNode != null) {
                NodePO nodeStoreObject2 = parentNode.getNodeStoreObject(false, false);
                ArrayList arrayList = new ArrayList();
                arrayList.add(nodeStoreObject);
                Intrinsics.checkNotNull(nodeStoreObject2);
                nodeStoreObject2.setChildren(arrayList);
                parentNode = parentNode.getParentNode();
                nodeStoreObject = nodeStoreObject2;
            }
            return nodeStoreObject;
        }
        return null;
    }

    @Nullable
    public final View getNodeView() {
        return this.nodeViewWrf.get();
    }

    @NotNull
    public final String getNodeViewClassName() {
        return this.nodeViewClassName;
    }

    public final int getNodeViewId() {
        return this.nodeViewId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final RFWComparableWeakRef<View> getNodeViewWrf() {
        return this.nodeViewWrf;
    }

    @Nullable
    public final ArgusNode<?> getParentNode() {
        ArgusNode<?> parentNode;
        ArgusNode<?> argusNode = this.hostNode;
        if (argusNode == null || (parentNode = argusNode.getParentNode()) == null) {
            return this.parent;
        }
        return parentNode;
    }

    public final boolean getVisibleFlag() {
        return this.visibleFlag;
    }

    public int hashCode() {
        return Objects.hash(this.nodeClassName, Integer.valueOf(this.containerHashCode), Integer.valueOf(this.nodeViewHashCode));
    }

    public final boolean isAncestorOfNode(@NotNull ArgusNode<?> node) {
        Intrinsics.checkNotNullParameter(node, "node");
        return INSTANCE.isAncestorOf(this.nodeViewWrf.get(), node.nodeViewWrf.get());
    }

    public final boolean isPOGenerateFromNode(@NotNull NodePO po5) {
        Intrinsics.checkNotNullParameter(po5, "po");
        if (Intrinsics.areEqual(po5.getNodeClass(), this.nodeClassName) && Intrinsics.areEqual(po5.getViewClass(), this.nodeViewClassName) && po5.getViewId() == this.nodeViewId && Intrinsics.areEqual(po5.getContainerClass(), this.containerClass.getName()) && Intrinsics.areEqual(po5.getContainerDesc(), getContainerDesc(this.containerWrf.get()))) {
            return true;
        }
        return false;
    }

    public final boolean isRelease() {
        if (this.nodeViewWrf.get() != null && this.containerWrf.get() != null) {
            return false;
        }
        return true;
    }

    public boolean isSelfVisible() {
        if (!this.checkShown) {
            return true;
        }
        View view = this.nodeViewWrf.get();
        if (view != null && view.isShown()) {
            return true;
        }
        return false;
    }

    public final boolean isVisible(boolean considerParent) {
        ArgusNode<?> parentNode;
        View view = this.nodeViewWrf.get();
        if (isSelfVisible() && ((!considerParent || ((parentNode = getParentNode()) != null && parentNode.isVisible(true))) && checkShowLocationInWindow(view))) {
            return true;
        }
        return false;
    }

    public final void removeChildNode(@NotNull ArgusNode<?> childNode) {
        Intrinsics.checkNotNullParameter(childNode, "childNode");
        this.allChildren.remove(childNode);
    }

    public final void setAnnotationTags(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.annotationTags = list;
    }

    public final void setContainerClassName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.containerClassName = str;
    }

    protected final void setContainerWrf(@NotNull RFWComparableWeakRef<T> rFWComparableWeakRef) {
        Intrinsics.checkNotNullParameter(rFWComparableWeakRef, "<set-?>");
        this.containerWrf = rFWComparableWeakRef;
    }

    public final void setExtraAnnotation(@Nullable Object obj) {
        this.extraAnnotation = obj;
    }

    public final void setHasDispatchAdd(boolean z16) {
        this.hasDispatchAdd = z16;
    }

    public final void setHasDispatchPending(boolean z16) {
        this.hasDispatchPending = z16;
    }

    public final void setHasDispatchShown(boolean z16) {
        this.hasDispatchShown = z16;
    }

    public final void setHostNode(@Nullable ArgusNode<?> hostNode) {
        this.hostNode = hostNode;
    }

    public final void setLifecycleRegistry(@Nullable LifecycleRegistry lifecycleRegistry) {
        this.lifecycleRegistry = lifecycleRegistry;
    }

    public final void setNodeLifecycleState(@NotNull Lifecycle.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        this.nodeLifecycleState = state;
        updateNodeLifecycleState();
    }

    public final void setNodeViewClassName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.nodeViewClassName = str;
    }

    public final void setNodeViewId(int i3) {
        this.nodeViewId = i3;
    }

    protected final void setNodeViewWrf(@NotNull RFWComparableWeakRef<View> rFWComparableWeakRef) {
        Intrinsics.checkNotNullParameter(rFWComparableWeakRef, "<set-?>");
        this.nodeViewWrf = rFWComparableWeakRef;
    }

    public final void setParentNode(@Nullable ArgusNode<?> parentNode) {
        this.parent = parentNode;
    }

    public final void setVisibleFlag(boolean z16) {
        this.visibleFlag = z16;
    }

    @NotNull
    public String toString() {
        String str;
        Object[] objArr = new Object[5];
        objArr[0] = this.nodeClassName;
        objArr[1] = " view:";
        View nodeView = getNodeView();
        String str2 = "";
        if (nodeView == null) {
            str = "";
        } else {
            str = nodeView.getClass().getName();
        }
        objArr[2] = str;
        objArr[3] = " container:";
        T container = getContainer();
        if (container != null) {
            str2 = container.getClass().getName();
        }
        objArr[4] = str2;
        String string = RFWStringBuilderUtils.getString(objArr);
        Intrinsics.checkNotNullExpressionValue(string, "RFWStringBuilderUtils.ge\u2026ass?.name ?: \"\"\n        )");
        return string;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0077, code lost:
    
        if (com.tencent.biz.richframework.delegate.impl.RFWConfig.getConfigValue(r2.testConfigKey(), "", false) != false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ArgusNode(@NotNull View rootView, @NotNull T container) {
        Lazy lazy;
        List<String> mutableList;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(container, "container");
        this.nodeViewId = -1;
        this.containerClassName = "";
        this.nodeViewClassName = "";
        String simpleName = getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
        this.nodeClassName = simpleName;
        this.allChildren = new LinkedHashSet<>();
        this.nodeLifecycleState = Lifecycle.State.INITIALIZED;
        this.annotationTags = new ArrayList();
        lazy = LazyKt__LazyJVMKt.lazy(ArgusNode$extra$2.INSTANCE);
        this.extra = lazy;
        HashSet hashSet = new HashSet();
        ArgusTag annotationTag = ArgusTagKt.getAnnotationTag(container.getClass());
        if (annotationTag != null) {
            CollectionsKt__MutableCollectionsKt.addAll(hashSet, annotationTag.tags());
            if (RFWApplication.isPublicVersion()) {
                if (annotationTag.testConfigKey().length() > 0) {
                }
            }
            CollectionsKt__MutableCollectionsKt.addAll(hashSet, annotationTag.testTags());
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) hashSet);
        this.annotationTags = mutableList;
        this.nodeViewWrf = new RFWComparableWeakRef<>(rootView);
        this.containerWrf = new RFWComparableWeakRef<>(container);
        this.nodeViewClassName = getClassDesc(rootView);
        this.nodeViewId = simplifyViewId(rootView.getId());
        this.containerClassName = getClassDesc(container);
        this.containerClass = container.getClass();
        this.nodeViewHashCode = rootView.hashCode();
        this.containerHashCode = container.hashCode();
    }
}
