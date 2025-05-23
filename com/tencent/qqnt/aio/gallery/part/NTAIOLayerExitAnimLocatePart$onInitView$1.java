package com.tencent.qqnt.aio.gallery.part;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.AIOLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.richframework.gallery.anim.RFWTransAnimBean;
import com.tencent.richframework.gallery.anim.TransitionAnimUtil;
import com.tencent.richframework.gallery.bean.RFWLayerInitBean;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.qqnt.aio.gallery.part.NTAIOLayerExitAnimLocatePart$onInitView$1", f = "NTAIOLayerExitAnimLocatePart.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes23.dex */
final class NTAIOLayerExitAnimLocatePart$onInitView$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    int label;
    final /* synthetic */ NTAIOLayerExitAnimLocatePart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NTAIOLayerExitAnimLocatePart$onInitView$1(NTAIOLayerExitAnimLocatePart nTAIOLayerExitAnimLocatePart, Continuation<? super NTAIOLayerExitAnimLocatePart$onInitView$1> continuation) {
        super(2, continuation);
        this.this$0 = nTAIOLayerExitAnimLocatePart;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) nTAIOLayerExitAnimLocatePart, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new NTAIOLayerExitAnimLocatePart$onInitView$1(this.this$0, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0049, code lost:
    
        r2 = r12.C9(r2);
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        RFWLayerInitBean rFWLayerInitBean;
        Map map;
        UUID uUid;
        RecyclerView C9;
        boolean z16;
        ViewGroup viewGroup;
        Map map2;
        Map D9;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                NTAIOLayerExitAnimLocatePart nTAIOLayerExitAnimLocatePart = this.this$0;
                long nanoTime = System.nanoTime();
                rFWLayerInitBean = nTAIOLayerExitAnimLocatePart.mInitBean;
                if (rFWLayerInitBean == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mInitBean");
                    rFWLayerInitBean = null;
                }
                RFWTransAnimBean transitionBean = rFWLayerInitBean.getTransitionBean();
                if (transitionBean != null && (uUid = transitionBean.getUUid()) != null) {
                    try {
                        ImageView enterImageView = TransitionAnimUtil.INSTANCE.getTransViewAndDrawable(uUid).getEnterImageView();
                        if (enterImageView != null && C9 != null && (C9.getLayoutManager() instanceof AIOLayoutManager)) {
                            RecyclerView.LayoutManager layoutManager = C9.getLayoutManager();
                            Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.AIOLayoutManager");
                            AIOLayoutManager aIOLayoutManager = (AIOLayoutManager) layoutManager;
                            int findFirstVisibleItemPosition = aIOLayoutManager.findFirstVisibleItemPosition();
                            int findLastVisibleItemPosition = aIOLayoutManager.findLastVisibleItemPosition();
                            if (findFirstVisibleItemPosition >= 0 && findFirstVisibleItemPosition <= findLastVisibleItemPosition) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            if (z16 && findFirstVisibleItemPosition <= findLastVisibleItemPosition) {
                                while (true) {
                                    View findViewByPosition = aIOLayoutManager.findViewByPosition(findFirstVisibleItemPosition);
                                    if (findViewByPosition instanceof ViewGroup) {
                                        viewGroup = (ViewGroup) findViewByPosition;
                                    } else {
                                        viewGroup = null;
                                    }
                                    if (viewGroup != null) {
                                        map2 = nTAIOLayerExitAnimLocatePart.elementIdToView;
                                        D9 = nTAIOLayerExitAnimLocatePart.D9(viewGroup, R.id.f24840_8);
                                        map2.putAll(D9);
                                    }
                                    if (findFirstVisibleItemPosition == findLastVisibleItemPosition) {
                                        break;
                                    }
                                    findFirstVisibleItemPosition++;
                                }
                            }
                        }
                    } catch (Exception e16) {
                        RFWLog.e(nTAIOLayerExitAnimLocatePart.getTAG(), RFWLog.USR, e16);
                    }
                }
                long nanoTime2 = System.nanoTime() - nanoTime;
                String tag = this.this$0.getTAG();
                int i3 = RFWLog.USR;
                map = this.this$0.elementIdToView;
                RFWLog.i(tag, i3, "findViewCost:" + nanoTime2 + map.keySet());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((NTAIOLayerExitAnimLocatePart$onInitView$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
