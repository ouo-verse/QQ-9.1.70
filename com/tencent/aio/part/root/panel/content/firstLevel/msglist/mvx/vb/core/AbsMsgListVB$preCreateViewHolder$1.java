package com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\n\u001a\u0004\u0018\u00010\t\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0003*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0082@"}, d2 = {"Lat/b;", "I", "Lcom/tencent/aio/base/mvi/part/MsgListUiState;", ExifInterface.LATITUDE_SOUTH, "", "viewType", "Lkotlin/coroutines/Continuation;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "continuation", "", "preCreateViewHolder"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.AbsMsgListVB", f = "AbsMsgListVB.kt", i = {}, l = {381}, m = "preCreateViewHolder", n = {}, s = {})
/* loaded from: classes3.dex */
public final class AbsMsgListVB$preCreateViewHolder$1 extends ContinuationImpl {
    static IPatchRedirector $redirector_;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AbsMsgListVB this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbsMsgListVB$preCreateViewHolder$1(AbsMsgListVB absMsgListVB, Continuation continuation) {
        super(continuation);
        this.this$0 = absMsgListVB;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) absMsgListVB, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return iPatchRedirector.redirect((short) 1, (Object) this, obj);
        }
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.x1(0, this);
    }
}
