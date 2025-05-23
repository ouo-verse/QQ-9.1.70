package com.tencent.aio.part.root.panel.mvx.vb;

import android.util.SparseArray;
import android.view.View;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.part.root.panel.mvx.config.b;
import com.tencent.aio.part.root.panel.mvx.config.c;
import com.tencent.aio.part.root.panel.mvx.state.DemoPanelState;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Deprecated(message = "\u5e9f\u5f03", replaceWith = @ReplaceWith(expression = "PanelContainerCompatVB", imports = {}))
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0011\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b&\u0010'J#\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0005H\u0016J\u0014\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tH\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016J\b\u0010\u000e\u001a\u00020\u0005H\u0016R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR5\u0010%\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020 0\u001c8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\u00a8\u0006("}, d2 = {"Lcom/tencent/aio/part/root/panel/mvx/vb/PanelContainerVB;", "Lcom/tencent/aio/part/root/panel/mvx/vb/AbsPanelContainerVB;", "", "showPanelId", "hidePanelId", "", "f1", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "onPreCreate", "Lcom/tencent/aio/base/mvvm/b;", "Lcom/tencent/aio/part/root/panel/mvx/intent/a;", "Lcom/tencent/aio/part/root/panel/mvx/state/DemoPanelState;", "c1", "bindViewAndData", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/aio/part/root/panel/mvx/config/a;", h.F, "Lcom/tencent/aio/part/root/panel/mvx/config/a;", "mPanelFactory", "Lcom/tencent/aio/part/root/panel/mvx/vm/a;", "i", "Lcom/tencent/aio/part/root/panel/mvx/vm/a;", "mVm", "Landroid/util/SparseArray;", "Lcom/tencent/aio/part/root/panel/mvx/vb/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/util/SparseArray;", "mPanelCacheList", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "panelId", "Landroid/view/View;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/jvm/functions/Function1;", "d1", "()Lkotlin/jvm/functions/Function1;", "panelFetcher", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public class PanelContainerVB extends AbsPanelContainerVB {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Function1<Integer, View> panelFetcher;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.part.root.panel.mvx.config.a mPanelFactory;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.part.root.panel.mvx.vm.a mVm;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final SparseArray<a> mPanelCacheList;

    public PanelContainerVB() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.mPanelCacheList = new SparseArray<>(4);
            this.panelFetcher = new Function1<Integer, View>() { // from class: com.tencent.aio.part.root.panel.mvx.vb.PanelContainerVB$panelFetcher$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) PanelContainerVB.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ View invoke(Integer num) {
                    return invoke(num.intValue());
                }

                @NotNull
                public final View invoke(int i3) {
                    SparseArray sparseArray;
                    com.tencent.aio.part.root.panel.mvx.config.a aVar;
                    SparseArray sparseArray2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        return (View) iPatchRedirector2.redirect((short) 1, (Object) this, i3);
                    }
                    sparseArray = PanelContainerVB.this.mPanelCacheList;
                    a aVar2 = (a) sparseArray.get(i3);
                    if (aVar2 == null) {
                        aVar = PanelContainerVB.this.mPanelFactory;
                        b b16 = aVar != null ? aVar.b(i3) : null;
                        if (b16 != null) {
                            a aVar3 = new a(b16, b16.a(PanelContainerVB.this.getMContext()));
                            sparseArray2 = PanelContainerVB.this.mPanelCacheList;
                            sparseArray2.append(i3, aVar3);
                            aVar2 = aVar3;
                        } else {
                            throw new IllegalStateException((i3 + " not have suit provider, please check your logic").toString());
                        }
                    } else if (aVar2.a().b()) {
                        aVar2.c(aVar2.a().a(PanelContainerVB.this.getMContext()));
                    }
                    return aVar2.b();
                }
            };
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.bindViewAndData();
        com.tencent.aio.part.root.panel.mvx.config.a aVar = this.mPanelFactory;
        if (aVar != null) {
            com.tencent.aio.part.root.panel.mvx.vm.a aVar2 = this.mVm;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVm");
            }
            AIOParam m3 = aVar2.m();
            com.tencent.aio.api.runtime.a mAIOContext$sdk_debug = getMAIOContext$sdk_debug();
            Intrinsics.checkNotNull(mAIOContext$sdk_debug);
            aVar.c(new c(m3, mAIOContext$sdk_debug));
        }
    }

    @Override // com.tencent.aio.part.root.panel.mvx.vb.AbsPanelContainerVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: c1 */
    public com.tencent.aio.base.mvvm.b<com.tencent.aio.part.root.panel.mvx.intent.a, DemoPanelState> createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.aio.base.mvvm.b) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        com.tencent.aio.part.root.panel.mvx.vm.a aVar = new com.tencent.aio.part.root.panel.mvx.vm.a();
        this.mVm = aVar;
        return aVar;
    }

    @Override // com.tencent.aio.part.root.panel.mvx.vb.AbsPanelContainerVB
    @NotNull
    public Function1<Integer, View> d1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (Function1) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.panelFetcher;
    }

    @Override // com.tencent.aio.part.root.panel.mvx.vb.AbsPanelContainerVB
    public void f1(@Nullable Integer showPanelId, @Nullable Integer hidePanelId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) showPanelId, (Object) hidePanelId);
            return;
        }
        int i3 = 0;
        if (showPanelId == null && hidePanelId == null) {
            SparseArray<a> sparseArray = this.mPanelCacheList;
            int size = sparseArray.size();
            while (i3 < size) {
                sparseArray.keyAt(i3);
                sparseArray.valueAt(i3).a().c();
                i3++;
            }
            return;
        }
        SparseArray<a> sparseArray2 = this.mPanelCacheList;
        int size2 = sparseArray2.size();
        while (i3 < size2) {
            sparseArray2.keyAt(i3);
            sparseArray2.valueAt(i3).a().e(hidePanelId, showPanelId);
            i3++;
        }
    }

    @Override // com.tencent.aio.part.root.panel.mvx.vb.AbsPanelContainerVB, com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.onDestroy();
        SparseArray<a> sparseArray = this.mPanelCacheList;
        int size = sparseArray.size();
        for (int i3 = 0; i3 < size; i3++) {
            sparseArray.keyAt(i3);
            sparseArray.valueAt(i3).a().onDestroy();
        }
        this.mPanelCacheList.clear();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onPreCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.onPreCreate();
        Object b16 = getMStrategyService().b(com.tencent.aio.part.root.panel.mvx.config.a.class);
        Intrinsics.checkNotNull(b16);
        this.mPanelFactory = (com.tencent.aio.part.root.panel.mvx.config.a) b16;
    }
}
