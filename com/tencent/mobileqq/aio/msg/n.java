package com.tencent.mobileqq.aio.msg;

import android.content.Context;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.emotion.adapter.api.IMarketFaceApi;
import com.tencent.qqnt.kernel.nativeinterface.MarketFaceElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u0002\u00a2\u0006\u0004\b \u0010!J\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016R$\u0010\u0016\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R0\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/aio/msg/n;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "targetMsgRecord", "b0", "Landroid/content/Context;", "context", "", "Y0", "", "f1", "", "J0", "", "getViewType", "Lcom/tencent/qqnt/kernel/nativeinterface/MarketFaceElement;", "W0", "Lcom/tencent/qqnt/kernel/nativeinterface/MarketFaceElement;", "j2", "()Lcom/tencent/qqnt/kernel/nativeinterface/MarketFaceElement;", "setMarketFaceElement", "(Lcom/tencent/qqnt/kernel/nativeinterface/MarketFaceElement;)V", "marketFaceElement", "Lkotlin/Pair;", "X0", "Lkotlin/Pair;", "i2", "()Lkotlin/Pair;", "setAioShowSize", "(Lkotlin/Pair;)V", "aioShowSize", "msgRecord", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class n extends AIOMsgItem {
    static IPatchRedirector $redirector_;

    /* renamed from: W0, reason: from kotlin metadata */
    @Nullable
    private MarketFaceElement marketFaceElement;

    /* renamed from: X0, reason: from kotlin metadata */
    @Nullable
    private Pair<Integer, Integer> aioShowSize;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(@NotNull MsgRecord msgRecord) {
        super(msgRecord);
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) msgRecord);
        }
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    public boolean J0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        if (p0() == 100) {
            return true;
        }
        return super.I0();
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    public void Y0(@Nullable Context context) {
        MarketFaceElement marketFaceElement;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) context);
            return;
        }
        super.Y0(context);
        MsgElement firstTypeElement = getFirstTypeElement(11);
        if (firstTypeElement != null) {
            marketFaceElement = firstTypeElement.marketFaceElement;
        } else {
            marketFaceElement = null;
        }
        this.marketFaceElement = marketFaceElement;
        if (marketFaceElement != null) {
            this.aioShowSize = ((IMarketFaceApi) QRoute.api(IMarketFaceApi.class)).calculateMarketFaceViewSize(marketFaceElement);
        }
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    @NotNull
    public AIOMsgItem b0(@NotNull MsgRecord targetMsgRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (AIOMsgItem) iPatchRedirector.redirect((short) 6, (Object) this, (Object) targetMsgRecord);
        }
        Intrinsics.checkNotNullParameter(targetMsgRecord, "targetMsgRecord");
        return new n(targetMsgRecord);
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem
    @NotNull
    public String f1() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        String qqStr = HardCodeUtil.qqStr(R.string.f170197yp0);
        MarketFaceElement marketFaceElement = this.marketFaceElement;
        if (marketFaceElement != null) {
            str = marketFaceElement.faceName;
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        return qqStr + str;
    }

    @Override // com.tencent.mobileqq.aio.msg.AIOMsgItem, com.tencent.aio.data.msglist.a
    public int getViewType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        if (isSelf()) {
            return 37;
        }
        return 36;
    }

    @Nullable
    public final Pair<Integer, Integer> i2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Pair) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.aioShowSize;
    }

    @Nullable
    public final MarketFaceElement j2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MarketFaceElement) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.marketFaceElement;
    }
}
