package com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core;

import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.AIOLayoutManager;
import androidx.recyclerview.widget.AIORecycleView;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.impl.ListNotifyImpl;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.differ.AutoCancelAsyncListDiffer;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.differ.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0003*\u00020\u0002H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lat/b;", "I", "Lcom/tencent/aio/base/mvi/part/MsgListUiState;", ExifInterface.LATITUDE_SOUTH, "Landroidx/recyclerview/widget/AIORecycleView;", "invoke", "()Landroidx/recyclerview/widget/AIORecycleView;", "<anonymous>"}, k = 3, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class AbsMsgListVB$recyclerView$2 extends Lambda implements Function0<AIORecycleView> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ AbsMsgListVB this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbsMsgListVB$recyclerView$2(AbsMsgListVB absMsgListVB) {
        super(0);
        this.this$0 = absMsgListVB;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) absMsgListVB);
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final AIORecycleView invoke() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (AIORecycleView) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        final AIORecycleView aIORecycleView = new AIORecycleView(this.this$0.getMContext(), null, 0, new Function0<Unit>() { // from class: com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.AbsMsgListVB$recyclerView$2.1
            static IPatchRedirector $redirector_;

            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) AbsMsgListVB$recyclerView$2.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this);
                    return;
                }
                com.tencent.aio.api.runtime.a mAIOContext$sdk_debug = AbsMsgListVB$recyclerView$2.this.this$0.getMAIOContext$sdk_debug();
                if (mAIOContext$sdk_debug != null) {
                    com.tencent.aio.runtime.dispatcher.b.a(mAIOContext$sdk_debug, 16);
                }
            }
        }, 6, null);
        AIOLayoutManager aIOLayoutManager = new AIOLayoutManager(this.this$0.getMContext());
        aIOLayoutManager.setStackFromEnd(true);
        Unit unit = Unit.INSTANCE;
        aIORecycleView.setLayoutManager(aIOLayoutManager);
        aIORecycleView.setOverScrollMode(2);
        AbsMsgListVB absMsgListVB = this.this$0;
        com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.a aVar = new com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.a(this.this$0);
        aVar.setHasStableIds(false);
        this.this$0.A1(new ListNotifyImpl(aVar, aIORecycleView, new Function0<CoroutineScope>(this) { // from class: com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.AbsMsgListVB$recyclerView$2$$special$$inlined$apply$lambda$2
            static IPatchRedirector $redirector_;
            final /* synthetic */ AbsMsgListVB$recyclerView$2 this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIORecycleView.this, (Object) this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final CoroutineScope invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? this.this$0.this$0.h1() : (CoroutineScope) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        }));
        com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.differ.d dVar = new com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.differ.d(this.this$0.i1());
        com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.differ.a a16 = new a.C0643a(new com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.differ.c()).a();
        Intrinsics.checkNotNullExpressionValue(a16, "AIODifferConfig.Builder(\u2026                 .build()");
        aVar.w0(new AutoCancelAsyncListDiffer<>(dVar, a16));
        absMsgListVB.B1(aVar);
        aIORecycleView.setAdapter(this.this$0.j1());
        aIORecycleView.addOnScrollListener(new d(aIORecycleView.getLayoutManager()));
        com.tencent.aio.base.b.b(aIORecycleView, AbsMsgListVB$recyclerView$2$2$3.INSTANCE);
        aIORecycleView.setHasFixedSize(true);
        return aIORecycleView;
    }
}
