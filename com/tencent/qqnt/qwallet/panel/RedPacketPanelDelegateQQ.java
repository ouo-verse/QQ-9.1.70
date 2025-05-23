package com.tencent.qqnt.qwallet.panel;

import android.content.Context;
import android.view.View;
import com.tencent.aio.api.runtime.a;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.p;
import com.tencent.mobileqq.qwallet.hb.panel.RedPacketPanel;
import com.tencent.mobileqq.qwallet.hb.panel.e;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.nt.adapter.session.f;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rx3.c;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J \u0010\u000f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u0016\u0010\u0012\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqnt/qwallet/panel/RedPacketPanelDelegateQQ;", "Lrx3/c;", "Landroid/content/Context;", "context", "Landroid/view/View;", "createPanelView", "", "a", "b", "", "chatType", "", "chatId", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "c", "Lcom/tencent/mobileqq/qwallet/hb/panel/RedPacketPanel;", "Lcom/tencent/mobileqq/qwallet/hb/panel/RedPacketPanel;", "panelView", "<init>", "()V", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RedPacketPanelDelegateQQ implements c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private RedPacketPanel panelView;

    @Override // rx3.c
    public void a() {
        RedPacketPanel redPacketPanel = this.panelView;
        if (redPacketPanel != null) {
            if (redPacketPanel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("panelView");
                redPacketPanel = null;
            }
            redPacketPanel.onShow();
        }
    }

    @Override // rx3.c
    public void b() {
        RedPacketPanel redPacketPanel = this.panelView;
        if (redPacketPanel != null) {
            if (redPacketPanel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("panelView");
                redPacketPanel = null;
            }
            redPacketPanel.onHide();
        }
    }

    @Override // rx3.c
    public void c(final int chatType, @NotNull String chatId, @NotNull final a aioContext) {
        Intrinsics.checkNotNullParameter(chatId, "chatId");
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        com.tencent.nt.adapter.session.c.h(chatId, chatType, new Function2<Boolean, f, Unit>() { // from class: com.tencent.qqnt.qwallet.panel.RedPacketPanelDelegateQQ$setChatInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, f fVar) {
                invoke(bool.booleanValue(), fVar);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, @Nullable f fVar) {
                RedPacketPanel redPacketPanel;
                if (fVar == null) {
                    return;
                }
                p pVar = new p();
                pVar.f179555d = fVar.b();
                pVar.f179557e = fVar.a();
                pVar.f179559f = fVar.a();
                com.tencent.mobileqq.qwallet.a b16 = e.INSTANCE.b(chatType);
                redPacketPanel = this.panelView;
                if (redPacketPanel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("panelView");
                    redPacketPanel = null;
                }
                redPacketPanel.O0(pVar, b16, aioContext);
            }
        });
    }

    @Override // rx3.c
    @NotNull
    public View createPanelView(@NotNull Context context) {
        int i3;
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.panelView == null) {
            if (QQTheme.isNowThemeIsNight()) {
                i3 = R.style.a7g;
            } else {
                i3 = R.style.a7e;
            }
            this.panelView = new RedPacketPanel(context, i3);
        }
        RedPacketPanel redPacketPanel = this.panelView;
        if (redPacketPanel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("panelView");
            return null;
        }
        return redPacketPanel;
    }
}
