package com.tencent.mobileqq.aio.msglist.holder.component.marketface;

import com.tencent.mobileqq.aio.msglist.holder.AIOMsgItemUIState;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/marketface/AIOMarketFaceUIState$MarketFaceInfoUpdateState", "Lcom/tencent/mobileqq/aio/msglist/holder/AIOMsgItemUIState;", "Lcom/tencent/qqnt/emotion/adapter/api/a;", "d", "Lcom/tencent/qqnt/emotion/adapter/api/a;", "b", "()Lcom/tencent/qqnt/emotion/adapter/api/a;", "marketFaceInfo", "", "e", "I", "a", "()I", "index", "<init>", "(Lcom/tencent/qqnt/emotion/adapter/api/a;I)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOMarketFaceUIState$MarketFaceInfoUpdateState extends AIOMsgItemUIState {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.emotion.adapter.api.a marketFaceInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int index;

    public AIOMarketFaceUIState$MarketFaceInfoUpdateState(@NotNull com.tencent.qqnt.emotion.adapter.api.a marketFaceInfo, int i3) {
        Intrinsics.checkNotNullParameter(marketFaceInfo, "marketFaceInfo");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) marketFaceInfo, i3);
        } else {
            this.marketFaceInfo = marketFaceInfo;
            this.index = i3;
        }
    }

    public final int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.index;
    }

    @NotNull
    public final com.tencent.qqnt.emotion.adapter.api.a b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.qqnt.emotion.adapter.api.a) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.marketFaceInfo;
    }

    public /* synthetic */ AIOMarketFaceUIState$MarketFaceInfoUpdateState(com.tencent.qqnt.emotion.adapter.api.a aVar, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(aVar, (i16 & 2) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, aVar, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }
}
