package com.tencent.ecommerce.biz.hr.component;

import android.content.Context;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.biz.guild.api.IECGuildApi;
import com.tencent.kuikly.core.render.android.expand.component.KRImageView;
import com.tencent.mobileqq.app.AppConstants;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\u000e\u001a\u00020\b8\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/ecommerce/biz/hr/component/HRGuildMixBackgroundView;", "Lcom/tencent/kuikly/core/render/android/expand/component/KRImageView;", "", "propValue", "", "p0", "", "propKey", "", "b", "P", "Z", "k", "()Z", "reusable", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class HRGuildMixBackgroundView extends KRImageView {

    /* renamed from: P, reason: from kotlin metadata */
    private final boolean reusable;

    public HRGuildMixBackgroundView(Context context) {
        super(context);
        this.reusable = true;
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.KRImageView, i01.c
    public boolean b(String propKey, Object propValue) {
        if (propKey.hashCode() == 114148 && propKey.equals("src")) {
            p0(propValue);
            return true;
        }
        return super.b(propKey, propValue);
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.KRImageView, i01.c
    /* renamed from: k, reason: from getter */
    public boolean getReusable() {
        return this.reusable;
    }

    private final void p0(Object propValue) {
        if (propValue != null) {
            String str = (String) propValue;
            IECGuildApi guildApi = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getGuildApi();
            setImageDrawable(guildApi != null ? guildApi.getMixBackgroundDrawable(str) : null);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }
}
