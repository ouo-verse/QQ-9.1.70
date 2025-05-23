package com.tencent.qqnt.aio.adapter.api.impl;

import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.adapter.api.IAIOMarketFaceApi;
import com.tencent.qqnt.kernel.nativeinterface.MarketFaceElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J*\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\rH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOMarketFaceApiNtImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IAIOMarketFaceApi;", "()V", "enterMarketFacePreview", "", "clickedView", "Landroid/view/View;", "msgRecord", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "marketFaceElement", "Lcom/tencent/qqnt/kernel/nativeinterface/MarketFaceElement;", "enterMarketFacePreviewWithSource", "source", "", "aio_adapter_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
public final class AIOMarketFaceApiNtImpl implements IAIOMarketFaceApi {
    static IPatchRedirector $redirector_;

    public AIOMarketFaceApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOMarketFaceApi
    public void enterMarketFacePreview(@NotNull View clickedView, @NotNull MsgRecord msgRecord, @Nullable MarketFaceElement marketFaceElement) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, clickedView, msgRecord, marketFaceElement);
        } else {
            Intrinsics.checkNotNullParameter(clickedView, "clickedView");
            Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOMarketFaceApi
    public void enterMarketFacePreviewWithSource(@NotNull View clickedView, @NotNull MsgRecord msgRecord, @Nullable MarketFaceElement marketFaceElement, int source) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, clickedView, msgRecord, marketFaceElement, Integer.valueOf(source));
        } else {
            Intrinsics.checkNotNullParameter(clickedView, "clickedView");
            Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        }
    }
}
