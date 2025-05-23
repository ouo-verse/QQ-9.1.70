package com.tencent.qqnt.qwallet.aio.hb;

import android.content.Context;
import android.content.Intent;
import com.qwallet.temp.IQwTemp;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.qwallet.aio.AIOContextHolder;
import com.tencent.qqnt.qwallet.grab.GrabVoiceHbFragment;
import com.tencent.qqnt.qwallet.unclaimed.UnclaimedEvent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0014R\u001a\u0010\u000b\u001a\u00020\u00068\u0014X\u0094D\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0011\u001a\u00020\f8\u0014X\u0094\u0004\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0014\u001a\u00020\f8\u0014X\u0094\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/qqnt/qwallet/aio/hb/VoiceHbView;", "Lcom/tencent/qqnt/qwallet/aio/hb/DefaultHbView;", "", "d1", "", "H0", "", "N", "Ljava/lang/String;", "V0", "()Ljava/lang/String;", "typeText", "", "P", "I", "O0", "()I", "bgResId", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "T0", "topIconResId", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class VoiceHbView extends DefaultHbView {

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final String typeText;

    /* renamed from: P, reason: from kotlin metadata */
    private final int bgResId;

    /* renamed from: Q, reason: from kotlin metadata */
    private final int topIconResId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceHbView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.typeText = "\u8bed\u97f3\u7ea2\u5305";
        this.bgResId = R.drawable.nus;
        this.topIconResId = R.drawable.f162120fq4;
    }

    private final boolean d1() {
        if (2 == W0().M1().getChatType() && ((IQwTemp) QRoute.api(IQwTemp.class)).isUinSilencedInTroop(W0().M1().getPeerUinStr())) {
            return true;
        }
        return false;
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
        if (d1()) {
            String string2 = getContext().getString(R.string.f170962mg, getTypeText());
            Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri\u2026ab_in_silenced, typeText)");
            rx3.i.f432935a.b(string2, W0().M1().getPeerUinStr(), W0().M1().getChatType());
            return;
        }
        AIOContextHolder.f361707d.c(new UnclaimedEvent.UpdateHbList(false));
        if (!W0().T1()) {
            if (W0().S1().length() <= 0) {
                z16 = false;
            }
            if (!z16) {
                Intent intent = new Intent();
                intent.putExtras(sx3.a.b(W0().M1()));
                com.tencent.mobileqq.base.c.f(getContext(), intent, GrabVoiceHbFragment.class, false, 8, null);
                return;
            }
        }
        GrabHbViewModel F0 = F0();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        rx3.b M1 = W0().M1();
        emptyMap = MapsKt__MapsKt.emptyMap();
        F0.X1(context, M1, emptyMap);
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
}
