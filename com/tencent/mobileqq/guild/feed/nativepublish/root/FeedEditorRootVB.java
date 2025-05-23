package com.tencent.mobileqq.guild.feed.nativepublish.root;

import android.view.View;
import androidx.viewbinding.ViewBinding;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.guild.feed.nativepublish.root.msgintent.FeedEditorRootMsgIntent;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.base.route.j;
import com.tencent.mvi.mvvm.BaseVB;
import com.tencent.mvi.mvvm.BaseVM;
import com.tencent.mvi.mvvm.framework.FrameworkVM;
import dm1.d;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import yl1.n;

/* compiled from: P */
@Metadata(d1 = {"\u0000Q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u000b\u0018\u00002\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001j\u0002`\u0005B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJS\u0010\f\u001a\u00020\u000b2\u001a\u0010\u0007\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00010\u00062&\u0010\n\u001a\"\u0012\u001e\u0012\u001c\u0012\u0006\b\u0001\u0012\u00020\u0002\u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001j\u0002`\t0\bH\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J0\u0010\u0016\u001a\"\u0012\u001e\u0012\u001c\u0012\u0006\b\u0001\u0012\u00020\u0002\u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001j\u0002`\t0\u00152\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\u001a\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0017H\u0016J\b\u0010\u0019\u001a\u00020\u0012H\u0016R4\u0010\u001c\u001a \u0012\u0006\b\u0001\u0012\u00020\u0002\u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0001j\u0004\u0018\u0001`\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/root/FeedEditorRootVB;", "Lcom/tencent/mvi/mvvm/BaseVB;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "Lcom/tencent/mvi/api/runtime/b;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/GenericBaseVB;", "Ldm1/d$b;", "rootLayerBlueprint", "Ljava/util/LinkedList;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/GenericChildBaseVB;", "contentLayerVBList", "com/tencent/mobileqq/guild/feed/nativepublish/root/FeedEditorRootVB$a", "c1", "(Ldm1/d$b;Ljava/util/LinkedList;)Lcom/tencent/mobileqq/guild/feed/nativepublish/root/FeedEditorRootVB$a;", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "", "bindViewAndData", "hostView", "", "initializeChildVB", "Lcom/tencent/mvi/mvvm/BaseVM;", "createVM", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "d", "Lcom/tencent/mvi/mvvm/BaseVB;", "globalVB", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedEditorRootVB extends BaseVB<ol3.b, MviUIState, com.tencent.mvi.api.runtime.b> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private BaseVB<? extends ol3.b, ? extends MviUIState, com.tencent.mvi.api.runtime.b> globalVB;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u001c\u0012\u0006\b\u0001\u0012\u00020\u0002\u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001j\u0002`\u0005J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J0\u0010\f\u001a\"\u0012\u001e\u0012\u001c\u0012\u0006\b\u0001\u0012\u00020\u0002\u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001j\u0002`\u00050\u000b2\u0006\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/guild/feed/nativepublish/root/FeedEditorRootVB$a", "Lcom/tencent/mvi/mvvm/BaseVB;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "Lcom/tencent/mvi/api/runtime/b;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/GenericChildBaseVB;", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "hostView", "", "initializeChildVB", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a extends BaseVB<? extends ol3.b, ? extends MviUIState, com.tencent.mvi.api.runtime.b> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ d.b<? extends BaseVB<?, ?, ?>> f222237d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ LinkedList<BaseVB<? extends ol3.b, ? extends MviUIState, com.tencent.mvi.api.runtime.b>> f222238e;

        a(d.b<? extends BaseVB<?, ?, ?>> bVar, LinkedList<BaseVB<? extends ol3.b, ? extends MviUIState, com.tencent.mvi.api.runtime.b>> linkedList) {
            this.f222237d = bVar;
            this.f222238e = linkedList;
        }

        @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
        @NotNull
        public List<BaseVB<? extends ol3.b, ? extends MviUIState, com.tencent.mvi.api.runtime.b>> initializeChildVB(@NotNull View hostView) {
            Intrinsics.checkNotNullParameter(hostView, "hostView");
            return this.f222238e;
        }

        @Override // com.tencent.mvi.mvvm.b
        @NotNull
        public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
            Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
            View onCreateView = this.f222237d.a().onCreateView(createViewParams);
            if (onCreateView == null) {
                return createViewParams.b();
            }
            return onCreateView;
        }
    }

    private final a c1(d.b<? extends BaseVB<?, ?, ?>> rootLayerBlueprint, LinkedList<BaseVB<? extends ol3.b, ? extends MviUIState, com.tencent.mvi.api.runtime.b>> contentLayerVBList) {
        return new a(rootLayerBlueprint, contentLayerVBList);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        com.tencent.mvi.api.runtime.b mContext;
        j e16;
        super.bindViewAndData();
        FrameworkVM mUIModel = getMUIModel();
        if (mUIModel != null && (mContext = mUIModel.getMContext()) != null && (e16 = mContext.e()) != null) {
            e16.h(FeedEditorRootMsgIntent.OnBindViewAndData.f222245d);
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public BaseVM<ol3.b, MviUIState, com.tencent.mvi.api.runtime.b> createVM() {
        return new d(new Function1<BaseVM<ol3.b, MviUIState, com.tencent.mvi.api.runtime.b>, com.tencent.input.base.mvicompat.f<com.tencent.mvi.api.runtime.b>[]>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.root.FeedEditorRootVB$createVM$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            /* JADX WARN: Code restructure failed: missing block: B:10:0x0033, code lost:
            
                if (r3 != null) goto L14;
             */
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final com.tencent.input.base.mvicompat.f<com.tencent.mvi.api.runtime.b>[] invoke(@NotNull BaseVM<ol3.b, MviUIState, com.tencent.mvi.api.runtime.b> it) {
                BaseVB baseVB;
                BaseVM<I, S, C> mUIModel;
                dm1.d b16;
                com.tencent.input.base.mvicompat.f<com.tencent.mvi.api.runtime.b>[] fVarArr;
                List<com.tencent.input.base.mvicompat.f<? extends com.tencent.mvi.api.runtime.b>> g16;
                Intrinsics.checkNotNullParameter(it, "it");
                baseVB = FeedEditorRootVB.this.globalVB;
                if (baseVB != null && (mUIModel = baseVB.getMUIModel()) != 0) {
                    b16 = b.b(FeedEditorRootVB.this);
                    if (b16 != null && (g16 = b16.g(mUIModel)) != null) {
                        Object[] array = g16.toArray(new com.tencent.input.base.mvicompat.f[0]);
                        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                        fVarArr = (com.tencent.input.base.mvicompat.f[]) array;
                    }
                    fVarArr = null;
                    if (fVarArr != null) {
                        return fVarArr;
                    }
                }
                return new com.tencent.input.base.mvicompat.f[0];
            }
        });
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<BaseVB<? extends ol3.b, ? extends MviUIState, com.tencent.mvi.api.runtime.b>> initializeChildVB(@NotNull View hostView) {
        dm1.d b16;
        d.b<? extends BaseVB<?, ?, ?>> bVar;
        BaseVB<? extends ol3.b, ? extends MviUIState, com.tencent.mvi.api.runtime.b> d16;
        BaseVB<? extends ol3.b, ? extends MviUIState, com.tencent.mvi.api.runtime.b> f16;
        Intrinsics.checkNotNullParameter(hostView, "hostView");
        b16 = b.b(this);
        BaseVB<? extends ol3.b, ? extends MviUIState, com.tencent.mvi.api.runtime.b> baseVB = null;
        if (b16 != null) {
            bVar = b16.a();
        } else {
            bVar = null;
        }
        if (b16 != null && (f16 = b16.f()) != null) {
            baseVB = f16;
        }
        this.globalVB = baseVB;
        LinkedList linkedList = new LinkedList();
        linkedList.add(new com.tencent.mobileqq.guild.feed.nativepublish.root.a());
        linkedList.add(new e());
        if (b16 != null && (d16 = b16.d()) != null) {
            linkedList.add(d16);
        }
        if (bVar != null) {
            LinkedList linkedList2 = new LinkedList();
            BaseVB<?, ?, ?> b17 = bVar.b();
            if (b17 != null) {
                linkedList2.add(b17);
                linkedList2.add(c1(bVar, linkedList));
                linkedList = linkedList2;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type com.tencent.mvi.mvvm.BaseVB<out com.tencent.mvi.base.mvi.MviIntent, out com.tencent.mvi.base.mvi.MviUIState, com.tencent.mvi.api.runtime.MviContext>");
            }
        }
        BaseVB<? extends ol3.b, ? extends MviUIState, com.tencent.mvi.api.runtime.b> baseVB2 = this.globalVB;
        if (baseVB2 != null) {
            linkedList.add(baseVB2);
        }
        return linkedList;
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        dm1.d b16;
        View view;
        ViewBinding b17;
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        b16 = b.b(this);
        if (b16 != null && (b17 = b16.b(createViewParams)) != null) {
            View mContainer = b17.getMContainer();
            Intrinsics.checkNotNullExpressionValue(mContainer, "it.root");
            n.y(mContainer, ViewBinding.class, b17);
            view = b17.getMContainer();
        } else {
            view = null;
        }
        if (view == null) {
            return createViewParams.b();
        }
        return view;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        super.onDestroy();
        View safetyGetHostView = safetyGetHostView();
        if (safetyGetHostView != null) {
            n.D(safetyGetHostView, ViewBinding.class);
        }
    }
}
