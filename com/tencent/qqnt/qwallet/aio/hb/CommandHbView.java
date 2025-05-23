package com.tencent.qqnt.qwallet.aio.hb;

import android.content.Context;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qqnt.qwallet.aio.AIOContextHolder;
import com.tencent.qqnt.qwallet.unclaimed.UnclaimedEvent;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0014R\u001b\u0010\t\u001a\u00020\u00048VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u000f\u001a\u00020\n8\u0014X\u0094D\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0015\u001a\u00020\u00108\u0014X\u0094\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0018\u001a\u00020\u00108\u0014X\u0094\u0004\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0017\u0010\u0014\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/qqnt/qwallet/aio/hb/CommandHbView;", "Lcom/tencent/qqnt/qwallet/aio/hb/DefaultHbView;", "", "H0", "Lcom/tencent/qqnt/qwallet/aio/hb/h;", "N", "Lkotlin/Lazy;", "d1", "()Lcom/tencent/qqnt/qwallet/aio/hb/h;", "viewModel", "", "P", "Ljava/lang/String;", "V0", "()Ljava/lang/String;", "typeText", "", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "I", "O0", "()I", "bgResId", BdhLogUtil.LogTag.Tag_Req, "T0", "topIconResId", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class CommandHbView extends DefaultHbView {

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final String typeText;

    /* renamed from: Q, reason: from kotlin metadata */
    private final int bgResId;

    /* renamed from: R, reason: from kotlin metadata */
    private final int topIconResId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommandHbView(@NotNull Context context) {
        super(context);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<h>() { // from class: com.tencent.qqnt.qwallet.aio.hb.CommandHbView$viewModel$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final h invoke() {
                return new h();
            }
        });
        this.viewModel = lazy;
        this.typeText = "\u53e3\u4ee4\u7ea2\u5305";
        this.bgResId = R.drawable.nur;
        this.topIconResId = R.drawable.f162118fq2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qqnt.qwallet.aio.hb.AbstractHbView
    public void H0() {
        Map<String, ? extends Object> emptyMap;
        boolean z16 = true;
        if (W0().Z1()) {
            String string = getContext().getString(R.string.f170952mf, getTypeText());
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026b_in_anonymous, typeText)");
            rx3.i.f432935a.b(string, W0().M1().getPeerUinStr(), W0().M1().getChatType());
            return;
        }
        AIOContextHolder.f361707d.c(new UnclaimedEvent.UpdateHbList(false));
        if (!W0().T1()) {
            if (W0().S1().length() <= 0) {
                z16 = false;
            }
            if (!z16) {
                CommandHbGrabber commandHbGrabber = CommandHbGrabber.f361741a;
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                commandHbGrabber.n(context, W0().M1().getTitle(), W0().M1().getBillNo(), W0().M1().f());
                return;
            }
        }
        GrabHbViewModel F0 = F0();
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        rx3.b M1 = W0().M1();
        emptyMap = MapsKt__MapsKt.emptyMap();
        F0.X1(context2, M1, emptyMap);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qqnt.qwallet.aio.hb.DefaultHbView
    /* renamed from: O0, reason: from getter */
    public int getBgResId() {
        return this.bgResId;
    }

    @Override // com.tencent.qqnt.qwallet.aio.hb.DefaultHbView
    /* renamed from: T0, reason: from getter */
    protected int getTopIconResId() {
        return this.topIconResId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qqnt.qwallet.aio.hb.DefaultHbView
    @NotNull
    /* renamed from: V0, reason: from getter */
    public String getTypeText() {
        return this.typeText;
    }

    @Override // com.tencent.qqnt.qwallet.aio.hb.DefaultHbView
    @NotNull
    /* renamed from: d1, reason: merged with bridge method [inline-methods] */
    public h W0() {
        return (h) this.viewModel.getValue();
    }
}
