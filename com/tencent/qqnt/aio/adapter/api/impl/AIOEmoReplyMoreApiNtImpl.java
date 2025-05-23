package com.tencent.qqnt.aio.adapter.api.impl;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqnt.aio.adapter.api.IAIOEmoReplyMoreApi;
import com.tencent.qqnt.aio.adapter.api.IAIOEmoReplyMorePanel;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOEmoReplyMoreApiNtImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IAIOEmoReplyMoreApi;", "()V", "createPanel", "Lcom/tencent/qqnt/aio/adapter/api/IAIOEmoReplyMorePanel;", "aio_adapter_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
public final class AIOEmoReplyMoreApiNtImpl implements IAIOEmoReplyMoreApi {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000E\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JL\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016\u00a8\u0006\u0016"}, d2 = {"com/tencent/qqnt/aio/adapter/api/impl/AIOEmoReplyMoreApiNtImpl$a", "Lcom/tencent/qqnt/aio/adapter/api/IAIOEmoReplyMorePanel;", "Landroid/content/Context;", "context", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Landroid/view/View;", "anchorView", HippyNestedScrollComponent.PRIORITY_PARENT, "", "from", "Lcom/tencent/qqnt/aio/adapter/api/IAIOEmoReplyMorePanel$Source;", "source", "", NodeProps.PADDING_BOTTOM, "Lcom/tencent/qqnt/aio/emoreply/j;", "callBack", "", "a", "dismiss", "", "isShowing", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class a implements IAIOEmoReplyMorePanel {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.qqnt.aio.adapter.api.IAIOEmoReplyMorePanel
        public void a(@NotNull Context context, @NotNull MsgRecord msgRecord, @NotNull View anchorView, @Nullable View parent, @NotNull String from, @NotNull IAIOEmoReplyMorePanel.Source source, int paddingBottom, @Nullable com.tencent.qqnt.aio.emoreply.j callBack) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, context, msgRecord, anchorView, parent, from, source, Integer.valueOf(paddingBottom), callBack);
                return;
            }
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
            Intrinsics.checkNotNullParameter(anchorView, "anchorView");
            Intrinsics.checkNotNullParameter(from, "from");
            Intrinsics.checkNotNullParameter(source, "source");
        }

        @Override // com.tencent.qqnt.aio.adapter.api.IAIOEmoReplyMorePanel
        public void dismiss() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }

        @Override // com.tencent.qqnt.aio.adapter.api.IAIOEmoReplyMorePanel
        public boolean isShowing() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
            }
            return false;
        }
    }

    public AIOEmoReplyMoreApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOEmoReplyMoreApi
    @NotNull
    public IAIOEmoReplyMorePanel createPanel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (IAIOEmoReplyMorePanel) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new a();
    }
}
