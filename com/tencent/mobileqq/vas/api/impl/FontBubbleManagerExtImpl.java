package com.tencent.mobileqq.vas.api.impl;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.panel.FontBubbleManager;
import com.tencent.mobileqq.vas.api.IFontBubbleManagerExt;
import com.tencent.mobileqq.vas.panel.FontBubbleKuiklyComponent;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/vas/api/impl/FontBubbleManagerExtImpl;", "Lcom/tencent/mobileqq/vas/api/IFontBubbleManagerExt;", "Landroid/content/Context;", "context", "", ZPlanPublishSource.FROM_SCHEME, "Landroid/view/View;", "createKuiklyFontPanel", "createKuiklyBubblePanel", "Lcom/tencent/mobileqq/vas/api/IFontBubbleManagerExt$a;", "callback", "", "sendMessage", "<init>", "()V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class FontBubbleManagerExtImpl implements IFontBubbleManagerExt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendMessage$lambda$0(IFontBubbleManagerExt.a callback, boolean z16) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        callback.a(z16);
    }

    @Override // com.tencent.mobileqq.vas.api.IFontBubbleManagerExt
    public View createKuiklyBubblePanel(Context context, String scheme) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        FontBubbleKuiklyComponent fontBubbleKuiklyComponent = new FontBubbleKuiklyComponent(context);
        fontBubbleKuiklyComponent.g(scheme, FontBubbleKuiklyComponent.PanelType.BUBBLE);
        return fontBubbleKuiklyComponent;
    }

    @Override // com.tencent.mobileqq.vas.api.IFontBubbleManagerExt
    public View createKuiklyFontPanel(Context context, String scheme) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        FontBubbleKuiklyComponent fontBubbleKuiklyComponent = new FontBubbleKuiklyComponent(context);
        fontBubbleKuiklyComponent.g(scheme, FontBubbleKuiklyComponent.PanelType.FONT);
        return fontBubbleKuiklyComponent;
    }

    @Override // com.tencent.mobileqq.vas.api.IFontBubbleManagerExt
    public void sendMessage(final IFontBubbleManagerExt.a callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        FontBubbleManager.j((QQAppInterface) peekAppRuntime).t(new FontBubbleManager.d() { // from class: com.tencent.mobileqq.vas.api.impl.h
            @Override // com.tencent.mobileqq.panel.FontBubbleManager.d
            public final void a(boolean z16) {
                FontBubbleManagerExtImpl.sendMessage$lambda$0(IFontBubbleManagerExt.a.this, z16);
            }
        });
    }
}
