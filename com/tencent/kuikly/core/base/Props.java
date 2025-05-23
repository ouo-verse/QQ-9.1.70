package com.tencent.kuikly.core.base;

import com.tencent.kuikly.core.layout.FlexNode;
import com.tencent.kuikly.core.pager.Pager;
import com.tencent.kuikly.core.reactive.ReactiveObserver;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b;\u0010<J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0016J\u0015\u0010\u000b\u001a\u00020\u0007*\u00020\u00032\u0006\u0010\n\u001a\u00020\u0005H\u0086\u0004J1\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00052!\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00070\fJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u0016\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u0014\u001a\u00020\u0007J\u0006\u0010\u0015\u001a\u00020\u0007J\u0006\u0010\u0017\u001a\u00020\u0016J\u0006\u0010\u0019\u001a\u00020\u0018J\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u001aJ\u0010\u0010\u001d\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u001cR6\u0010 \u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u001ej\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005`\u001f8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\"\u0010$\u001a\u00020\u00038\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010+\u001a\u00020*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00101\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u0011\u0010:\u001a\u0002078F\u00a2\u0006\u0006\u001a\u0004\b8\u00109\u00a8\u0006="}, d2 = {"Lcom/tencent/kuikly/core/base/Props;", "Lcom/tencent/kuikly/core/base/BaseObject;", "Lcom/tencent/kuikly/core/base/p;", "", "propKey", "", "propValue", "", "bindProp", "viewDidRemove", "propsValue", "with", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "value", "propBlock", "bindPropBlock", "getProp", "setProp", Pager.PAGER_EVENT_SET_NEED_LAYOUT, "setPropsToRenderView", "Lcom/tencent/kuikly/core/pager/b;", "getPager", "", "isEmpty", "", "copyPropsMap", "Lcom/tencent/kuikly/core/base/AbstractBaseView;", "view", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "propsMap", "Ljava/util/LinkedHashMap;", "getPropsMap", "()Ljava/util/LinkedHashMap;", "pagerId", "Ljava/lang/String;", "getPagerId", "()Ljava/lang/String;", "setPagerId", "(Ljava/lang/String;)V", "", "nativeRef", "I", "getNativeRef", "()I", "setNativeRef", "(I)V", "forceUpdate", "Z", "getForceUpdate", "()Z", "setForceUpdate", "(Z)V", "Lcom/tencent/kuikly/core/pager/g;", "getPagerData", "()Lcom/tencent/kuikly/core/pager/g;", "pagerData", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public abstract class Props extends BaseObject implements p {
    private boolean forceUpdate;
    private int nativeRef;
    private final LinkedHashMap<String, Object> propsMap = new LinkedHashMap<>();
    private String pagerId = "";

    private final void bindProp(final String propKey, final Object propValue) {
        if (propValue instanceof Function) {
            ReactiveObserver.INSTANCE.b(this, new Function1<Boolean, Unit>() { // from class: com.tencent.kuikly.core.base.Props$bindProp$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16) {
                    Object obj = propValue;
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Function0<kotlin.Any>");
                    this.setProp(propKey, ((Function0) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj, 0)).invoke());
                }
            });
        } else {
            setProp(propKey, propValue);
        }
    }

    public final void bindPropBlock(final Object propValue, final Function1<Object, Unit> propBlock) {
        Intrinsics.checkNotNullParameter(propValue, "propValue");
        Intrinsics.checkNotNullParameter(propBlock, "propBlock");
        if (propValue instanceof Function) {
            ReactiveObserver.INSTANCE.b(this, new Function1<Boolean, Unit>() { // from class: com.tencent.kuikly.core.base.Props$bindPropBlock$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16) {
                    Object obj = propValue;
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Function0<kotlin.Any>");
                    propBlock.invoke(((Function0) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj, 0)).invoke());
                }
            });
        } else {
            propBlock.invoke(propValue);
        }
    }

    public final Map<String, Object> copyPropsMap() {
        Map<String, Object> map;
        map = MapsKt__MapsKt.toMap(this.propsMap);
        return map;
    }

    public final boolean getForceUpdate() {
        return this.forceUpdate;
    }

    public final int getNativeRef() {
        return this.nativeRef;
    }

    public final com.tencent.kuikly.core.pager.b getPager() {
        return com.tencent.kuikly.core.manager.c.f117352a.k(getPagerId());
    }

    public final com.tencent.kuikly.core.pager.g getPagerData() {
        return getPager().getPageData();
    }

    @Override // com.tencent.kuikly.core.base.p
    public String getPagerId() {
        return this.pagerId;
    }

    public final Object getProp(String propKey) {
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        return this.propsMap.get(propKey);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedHashMap<String, Object> getPropsMap() {
        return this.propsMap;
    }

    public final boolean isEmpty() {
        return this.propsMap.isEmpty();
    }

    public final void setForceUpdate(boolean z16) {
        this.forceUpdate = z16;
    }

    public final void setNativeRef(int i3) {
        this.nativeRef = i3;
    }

    public final void setNeedLayout() {
        FlexNode flexNode;
        AbstractBaseView<?, ?> view = view();
        if (view == null || (flexNode = view.getFlexNode()) == null) {
            return;
        }
        flexNode.a0();
    }

    public void setPagerId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.pagerId = str;
    }

    public final void setProp(String propKey, Object propValue) {
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        Intrinsics.checkNotNullParameter(propValue, "propValue");
        if (!Intrinsics.areEqual(this.propsMap.get(propKey), propValue) || this.forceUpdate) {
            this.propsMap.put(propKey, propValue);
            AbstractBaseView<?, ?> view = view();
            if (view != null) {
                view.didSetProp(propKey, propValue);
            }
        }
    }

    public final void setPropsToRenderView() {
        AbstractBaseView<?, ?> view = view();
        if (view != null) {
            if (getPager().getPageData().getIsIOS() && ((this.propsMap.containsKey("boxShadow") && this.propsMap.containsKey(NodeProps.BORDER_RADIUS)) || (this.propsMap.containsKey("backgroundImage") && !(view instanceof ViewContainer)))) {
                view.syncProp("wrapperBoxShadowView", 1);
            }
            Set<String> keySet = this.propsMap.keySet();
            Intrinsics.checkNotNullExpressionValue(keySet, "propsMap.keys");
            for (String propKey : keySet) {
                Object propValue = this.propsMap.get(propKey);
                if (propValue != null) {
                    Intrinsics.checkNotNullExpressionValue(propKey, "propKey");
                    Intrinsics.checkNotNullExpressionValue(propValue, "propValue");
                    view.syncProp(propKey, propValue);
                }
            }
        }
    }

    public final AbstractBaseView<?, ?> view() {
        if (!(getPagerId().length() > 0) || this.nativeRef == 0) {
            return null;
        }
        return getPager().getViewWithNativeRef(this.nativeRef);
    }

    public void viewDidRemove() {
        ReactiveObserver.INSTANCE.f(this);
    }

    public final void with(String str, Object propsValue) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(propsValue, "propsValue");
        bindProp(str, propsValue);
    }
}
