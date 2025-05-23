package com.tencent.mobileqq.aio.msglist.holder.component.nick.pit;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.aio.api.runtime.a;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.component.c;
import com.tencent.mobileqq.aio.msglist.holder.component.nick.AIONickState$NickCoverAnimation;
import com.tencent.mobileqq.aio.msglist.holder.component.nick.AIONickState$NickUpdate;
import com.tencent.mobileqq.aio.msglist.holder.component.nick.AIONickState$UpdateAnonymousTagColor;
import com.tencent.mobileqq.aio.msglist.holder.component.nick.a;
import com.tencent.mobileqq.aio.msglist.holder.component.nick.block.MainNickNameBlock;
import com.tencent.mobileqq.aio.msglist.holder.component.nick.block.NickBlockInject;
import com.tencent.mobileqq.aio.msglist.holder.component.nick.pit.component.b;
import com.tencent.mobileqq.aio.utils.StopWatch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mvi.mvvm.BaseVM;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.holder.IMsgItemMviUIState;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 B2\u00020\u0001:\u0001CB\u000f\u0012\u0006\u0010\u001c\u001a\u00020%\u00a2\u0006\u0004\b@\u0010AJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0007H\u0002J&\u0010\u0012\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\u0014\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00130\u0018H\u0016J$\u0010\u001e\u001a\u0016\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001d2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0010\u0010!\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u001fH\u0016J\b\u0010\"\u001a\u00020\u0002H\u0016J\u0010\u0010$\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u000bH\u0016R\u0017\u0010\u001c\u001a\u00020%8\u0006\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001b\u0010/\u001a\u00020*8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R!\u00103\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b0\u0010,\u001a\u0004\b1\u00102R\u0016\u00106\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R&\u0010<\u001a\u0012\u0012\u0004\u0012\u00020807j\b\u0012\u0004\u0012\u000208`98\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010?\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>\u00a8\u0006D"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/nick/pit/AIONickComponentV2;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/c;", "", "u1", "Landroid/util/SparseArray;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/nick/block/a;", "p1", "", "v1", "w1", ICustomDataEditor.STRING_PARAM_1, "", "position", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "", "payloads", "b1", "Lcom/tencent/qqnt/aio/holder/IMsgItemMviUIState;", "state", "g1", "Landroid/view/View;", "c1", "Lcom/tencent/aio/base/mvvm/b;", "Lcom/tencent/qqnt/aio/holder/a;", "d1", "Lcom/tencent/aio/api/runtime/a;", "context", "Lcom/tencent/mvi/mvvm/BaseVM;", "o1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "importance", "l1", "Landroid/content/Context;", "e", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Landroid/widget/LinearLayout;", "f", "Lkotlin/Lazy;", "r1", "()Landroid/widget/LinearLayout;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, h.F, "q1", "()Landroid/util/SparseArray;", "nickBlocks", "i", "Z", "isBlockInitialized", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/nick/pit/component/b;", "Lkotlin/collections/ArrayList;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/ArrayList;", "subComponents", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/aio/api/runtime/a;", "aioContext", "<init>", "(Landroid/content/Context;)V", "D", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIONickComponentV2 extends c {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private a aioContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy rootView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy nickBlocks;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isBlockInitialized;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<b> subComponents;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/nick/pit/AIONickComponentV2$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.nick.pit.AIONickComponentV2$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62667);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIONickComponentV2(@NotNull Context context) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.context = context;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.nick.pit.AIONickComponentV2$rootView$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIONickComponentV2.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final LinearLayout invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (LinearLayout) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                LinearLayout linearLayout = new LinearLayout(AIONickComponentV2.this.getContext());
                linearLayout.setOrientation(0);
                linearLayout.setGravity(16);
                return linearLayout;
            }
        });
        this.rootView = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<SparseArray<com.tencent.mobileqq.aio.msglist.holder.component.nick.block.a>>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.nick.pit.AIONickComponentV2$nickBlocks$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIONickComponentV2.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final SparseArray<com.tencent.mobileqq.aio.msglist.holder.component.nick.block.a> invoke() {
                SparseArray<com.tencent.mobileqq.aio.msglist.holder.component.nick.block.a> p16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (SparseArray) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                p16 = AIONickComponentV2.this.p1();
                return p16;
            }
        });
        this.nickBlocks = lazy2;
        this.subComponents = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SparseArray<com.tencent.mobileqq.aio.msglist.holder.component.nick.block.a> p1() {
        if (w1()) {
            return NickBlockInject.f191343a.c(this.context, r1());
        }
        if (s1()) {
            return NickBlockInject.f191343a.d(this.context, r1());
        }
        return NickBlockInject.f191343a.f(this.context, r1());
    }

    private final SparseArray<com.tencent.mobileqq.aio.msglist.holder.component.nick.block.a> q1() {
        return (SparseArray) this.nickBlocks.getValue();
    }

    private final LinearLayout r1() {
        return (LinearLayout) this.rootView.getValue();
    }

    private final boolean s1() {
        sendIntent(new a.C7315a(false, 1, null));
        return !r0.a();
    }

    private final void u1() {
        ArrayList<b> arrayList;
        if (!w1() && !s1()) {
            arrayList = new com.tencent.mobileqq.aio.msglist.holder.component.nick.pit.component.a(this.context, r1()).b(this);
        } else {
            arrayList = new ArrayList<>();
        }
        this.subComponents = arrayList;
    }

    private final boolean v1() {
        a.b bVar = new a.b(false, 1, null);
        sendIntent(bVar);
        return bVar.a();
    }

    private final boolean w1() {
        a.c cVar = new a.c(false, 1, null);
        sendIntent(cVar);
        return cVar.a();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    public void b1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(position), msgItem, payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        StopWatch i16 = new StopWatch("AIOBind.AIONickComponentV2", false).i();
        i16.e("set mosaic for blocks");
        AIOMsgItem aIOMsgItem = (AIOMsgItem) msgItem;
        if (!v1()) {
            f1().setVisibility(8);
            return;
        }
        f1().setVisibility(0);
        i16.e("need show nick");
        if (this.isBlockInitialized) {
            SparseArray<com.tencent.mobileqq.aio.msglist.holder.component.nick.block.a> q16 = q1();
            int size = q16.size();
            while (i3 < size) {
                q16.keyAt(i3);
                com.tencent.mobileqq.aio.msglist.holder.component.nick.block.a valueAt = q16.valueAt(i3);
                if (valueAt.h(aIOMsgItem)) {
                    if (QQTheme.isNowSimpleUI() && !valueAt.r()) {
                        valueAt.m();
                    } else {
                        valueAt.i(aIOMsgItem, payloads);
                    }
                    i16.e(valueAt.getClass().getSimpleName() + "-update");
                }
                i3++;
            }
            Iterator<T> it = this.subComponents.iterator();
            while (it.hasNext()) {
                ((b) it.next()).a(msgItem, payloads);
            }
            i16.b("block-update");
            return;
        }
        this.isBlockInitialized = true;
        f1().setVisibility(0);
        SparseArray<com.tencent.mobileqq.aio.msglist.holder.component.nick.block.a> q17 = q1();
        int size2 = q17.size();
        while (i3 < size2) {
            q17.keyAt(i3);
            com.tencent.mobileqq.aio.msglist.holder.component.nick.block.a valueAt2 = q17.valueAt(i3);
            if (valueAt2.h(aIOMsgItem)) {
                long currentTimeMillis = System.currentTimeMillis();
                valueAt2.c();
                valueAt2.a(this);
                if (QQTheme.isNowSimpleUI() && !valueAt2.r()) {
                    valueAt2.m();
                } else {
                    valueAt2.i(aIOMsgItem, payloads);
                }
                i16.e(valueAt2.getClass().getSimpleName() + "-bind");
                if (QLog.isColorLevel() && System.currentTimeMillis() - currentTimeMillis >= 5) {
                    QLog.i("AIONickComponentV2", 2, valueAt2.getClass().getSimpleName() + " bind cost: " + (System.currentTimeMillis() - currentTimeMillis));
                }
            }
            i3++;
        }
        u1();
        Iterator<T> it5 = this.subComponents.iterator();
        while (it5.hasNext()) {
            ((b) it5.next()).a(msgItem, payloads);
        }
        i16.b("block-bind");
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    @NotNull
    public View c1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (View) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return r1();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c, com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: d1 */
    public com.tencent.aio.base.mvvm.b<com.tencent.qqnt.aio.holder.a, IMsgItemMviUIState> createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.aio.base.mvvm.b) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return new com.tencent.mobileqq.aio.msglist.holder.component.nick.b();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c, com.tencent.mvi.mvvm.BaseVB
    /* renamed from: g1 */
    public void handleUIState(@NotNull IMsgItemMviUIState state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        MainNickNameBlock mainNickNameBlock = null;
        if (state instanceof AIONickState$NickUpdate) {
            com.tencent.mobileqq.aio.msglist.holder.component.nick.block.a aVar = q1().get(2);
            if (aVar instanceof MainNickNameBlock) {
                mainNickNameBlock = (MainNickNameBlock) aVar;
            }
            if (mainNickNameBlock != null) {
                mainNickNameBlock.B();
                return;
            }
            return;
        }
        if (state instanceof AIONickState$UpdateAnonymousTagColor) {
            com.tencent.mobileqq.aio.msglist.holder.component.nick.block.a aVar2 = q1().get(1);
            if (aVar2 != null) {
                aVar2.g(state);
                return;
            }
            return;
        }
        if (state instanceof AIONickState$NickCoverAnimation) {
            com.tencent.mobileqq.aio.msglist.holder.component.nick.block.a aVar3 = q1().get(2);
            if (aVar3 instanceof MainNickNameBlock) {
                mainNickNameBlock = (MainNickNameBlock) aVar3;
            }
            if (mainNickNameBlock != null) {
                mainNickNameBlock.x();
            }
        }
    }

    @NotNull
    public final Context getContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Context) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.context;
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c
    public void l1(int importance) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, importance);
            return;
        }
        if (this.isBlockInitialized) {
            SparseArray<com.tencent.mobileqq.aio.msglist.holder.component.nick.block.a> q16 = q1();
            int size = q16.size();
            for (int i3 = 0; i3 < size; i3++) {
                q16.keyAt(i3);
                q16.valueAt(i3).p(importance);
            }
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @Nullable
    /* renamed from: o1, reason: merged with bridge method [inline-methods] */
    public BaseVM<com.tencent.qqnt.aio.holder.a, IMsgItemMviUIState, com.tencent.aio.api.runtime.a> buildVM(@NotNull com.tencent.aio.api.runtime.a context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (BaseVM) iPatchRedirector.redirect((short) 7, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        this.aioContext = context;
        return super.buildVM(context);
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (View) iPatchRedirector.redirect((short) 8, (Object) this, (Object) createViewParams);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        return f1();
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        super.onDestroy();
        Iterator<T> it = this.subComponents.iterator();
        while (it.hasNext()) {
            ((b) it.next()).j();
        }
    }
}
