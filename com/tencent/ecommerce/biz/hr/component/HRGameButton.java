package com.tencent.ecommerce.biz.hr.component;

import android.content.Context;
import android.view.View;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.biz.game.api.IECGameApi;
import com.tencent.kuikly.core.render.android.expand.component.KRView;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0007H\u0016R\u0018\u0010\r\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001a\u0010\u0012\u001a\u00020\b8\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/ecommerce/biz/hr/component/HRGameButton;", "Lcom/tencent/kuikly/core/render/android/expand/component/KRView;", "", "propValue", "", "K", "propKey", "", "", "b", "Landroid/view/View;", "H", "Landroid/view/View;", "gameButton", "I", "Z", "k", "()Z", "reusable", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "J", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class HRGameButton extends KRView {

    /* renamed from: H, reason: from kotlin metadata */
    private View gameButton;

    /* renamed from: I, reason: from kotlin metadata */
    private final boolean reusable;

    public HRGameButton(Context context) {
        super(context);
    }

    private final void K(String propValue) {
        View view = this.gameButton;
        if (view != null) {
            removeView(view);
        }
        IECGameApi gameApi = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getGameApi();
        View createGameButton = gameApi != null ? gameApi.createGameButton(getContext(), propValue) : null;
        if (createGameButton != null) {
            addView(createGameButton, -1, -1);
        }
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.KRView, i01.c
    public boolean b(String propKey, Object propValue) {
        if (propKey.hashCode() != -794273169 || !propKey.equals("appInfo")) {
            return super.b(propKey, propValue);
        }
        if (propValue != null) {
            K((String) propValue);
            return true;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.KRView, i01.c
    /* renamed from: k, reason: from getter */
    public boolean getReusable() {
        return this.reusable;
    }
}
