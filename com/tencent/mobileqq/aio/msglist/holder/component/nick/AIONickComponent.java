package com.tencent.mobileqq.aio.msglist.holder.component.nick;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.component.c;
import com.tencent.mobileqq.aio.msglist.holder.component.nick.a;
import com.tencent.mobileqq.aio.msglist.holder.component.nick.block.MainNickNameBlock;
import com.tencent.mobileqq.aio.msglist.holder.component.nick.block.NickBlockInject;
import com.tencent.mobileqq.aio.utils.StopWatch;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.holder.IMsgItemMviUIState;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 32\u00020\u0001:\u00014B\u000f\u0012\u0006\u0010!\u001a\u00020\u001c\u00a2\u0006\u0004\b1\u00102J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J&\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0014\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u000e0\u0013H\u0016J\u0010\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u0019\u001a\u00020\fH\u0016J\u0010\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0006H\u0016R\u0017\u0010!\u001a\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001b\u0010'\u001a\u00020\"8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R!\u0010-\u001a\b\u0012\u0004\u0012\u00020)0(8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b*\u0010$\u001a\u0004\b+\u0010,R\u0016\u00100\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/nick/AIONickComponent;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/c;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "", "q1", "", "position", "Lcom/tencent/aio/data/msglist/a;", "", "", "payloads", "", "b1", "Lcom/tencent/qqnt/aio/holder/IMsgItemMviUIState;", "state", "g1", "Landroid/view/View;", "c1", "Lcom/tencent/aio/base/mvvm/b;", "Lcom/tencent/qqnt/aio/holder/a;", "d1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "importance", "l1", "Landroid/content/Context;", "e", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Landroid/widget/LinearLayout;", "f", "Lkotlin/Lazy;", "p1", "()Landroid/widget/LinearLayout;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/util/SparseArray;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/nick/block/a;", h.F, "o1", "()Landroid/util/SparseArray;", "nickBlocks", "i", "Z", "blockInited", "<init>", "(Landroid/content/Context;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIONickComponent extends c {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

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
    private boolean blockInited;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/nick/AIONickComponent$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.nick.AIONickComponent$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62573);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIONickComponent(@NotNull Context context) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.context = context;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.nick.AIONickComponent$rootView$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIONickComponent.this);
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
                LinearLayout linearLayout = new LinearLayout(AIONickComponent.this.getContext());
                linearLayout.setOrientation(0);
                linearLayout.setGravity(16);
                return linearLayout;
            }
        });
        this.rootView = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<SparseArray<com.tencent.mobileqq.aio.msglist.holder.component.nick.block.a>>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.nick.AIONickComponent$nickBlocks$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIONickComponent.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final SparseArray<com.tencent.mobileqq.aio.msglist.holder.component.nick.block.a> invoke() {
                LinearLayout p16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (SparseArray) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                NickBlockInject nickBlockInject = NickBlockInject.f191343a;
                Context context2 = AIONickComponent.this.getContext();
                p16 = AIONickComponent.this.p1();
                return nickBlockInject.e(context2, p16);
            }
        });
        this.nickBlocks = lazy2;
    }

    private final SparseArray<com.tencent.mobileqq.aio.msglist.holder.component.nick.block.a> o1() {
        return (SparseArray) this.nickBlocks.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LinearLayout p1() {
        return (LinearLayout) this.rootView.getValue();
    }

    private final boolean q1(AIOMsgItem msgItem) {
        a.b bVar = new a.b(false, 1, null);
        sendIntent(bVar);
        return bVar.a();
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
        StopWatch i16 = new StopWatch("AIOBind.AIONickComponent", QLog.isDevelopLevel()).i();
        if (QLog.isDevelopLevel()) {
            QLog.i("AIONickComponent", 4, "[bind]: msgId is " + msgItem.getMsgId() + ", msgItem is " + System.identityHashCode(msgItem));
        }
        i16.e("set mosaic for blocks");
        AIOMsgItem aIOMsgItem = (AIOMsgItem) msgItem;
        if (!q1(aIOMsgItem)) {
            View f16 = f1();
            Intrinsics.checkNotNull(f16);
            f16.setVisibility(8);
            return;
        }
        i16.e("need show nick");
        if (this.blockInited) {
            SparseArray<com.tencent.mobileqq.aio.msglist.holder.component.nick.block.a> o16 = o1();
            int size = o16.size();
            while (i3 < size) {
                o16.keyAt(i3);
                com.tencent.mobileqq.aio.msglist.holder.component.nick.block.a valueAt = o16.valueAt(i3);
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
            i16.b("block-update");
            return;
        }
        this.blockInited = true;
        View f17 = f1();
        Intrinsics.checkNotNull(f17);
        f17.setVisibility(0);
        SparseArray<com.tencent.mobileqq.aio.msglist.holder.component.nick.block.a> o17 = o1();
        int size2 = o17.size();
        while (i3 < size2) {
            o17.keyAt(i3);
            com.tencent.mobileqq.aio.msglist.holder.component.nick.block.a valueAt2 = o17.valueAt(i3);
            if (valueAt2.h(aIOMsgItem)) {
                System.currentTimeMillis();
                valueAt2.c();
                valueAt2.a(this);
                if (QQTheme.isNowSimpleUI() && !valueAt2.r()) {
                    valueAt2.m();
                } else {
                    valueAt2.i(aIOMsgItem, payloads);
                }
                i16.e(valueAt2.getClass().getSimpleName() + "-bind");
            }
            i3++;
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
        SparseArray<com.tencent.mobileqq.aio.msglist.holder.component.nick.block.a> o16 = o1();
        int size = o16.size();
        for (int i3 = 0; i3 < size; i3++) {
            o16.keyAt(i3);
            o16.valueAt(i3).l();
        }
        return p1();
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.c, com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: d1 */
    public com.tencent.aio.base.mvvm.b<com.tencent.qqnt.aio.holder.a, IMsgItemMviUIState> getViewModel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.aio.base.mvvm.b) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return new b();
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
            com.tencent.mobileqq.aio.msglist.holder.component.nick.block.a aVar = o1().get(2);
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
            com.tencent.mobileqq.aio.msglist.holder.component.nick.block.a aVar2 = o1().get(1);
            if (aVar2 != null) {
                aVar2.g(state);
                return;
            }
            return;
        }
        if (state instanceof AIONickState$NickCoverAnimation) {
            com.tencent.mobileqq.aio.msglist.holder.component.nick.block.a aVar3 = o1().get(2);
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, importance);
            return;
        }
        if (this.blockInited) {
            SparseArray<com.tencent.mobileqq.aio.msglist.holder.component.nick.block.a> o16 = o1();
            int size = o16.size();
            for (int i3 = 0; i3 < size; i3++) {
                o16.keyAt(i3);
                o16.valueAt(i3).p(importance);
            }
        }
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (View) iPatchRedirector.redirect((short) 7, (Object) this, (Object) createViewParams);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        View f16 = f1();
        Intrinsics.checkNotNull(f16);
        return f16;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.onDestroy();
        SparseArray<com.tencent.mobileqq.aio.msglist.holder.component.nick.block.a> o16 = o1();
        int size = o16.size();
        for (int i3 = 0; i3 < size; i3++) {
            o16.keyAt(i3);
            o16.valueAt(i3).k();
        }
    }
}
