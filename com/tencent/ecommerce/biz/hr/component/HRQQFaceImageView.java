package com.tencent.ecommerce.biz.hr.component;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.biz.qq.api.IECQQApi;
import com.tencent.kuikly.core.render.android.expand.component.KRImageView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010\f\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/ecommerce/biz/hr/component/HRQQFaceImageView;", "Lcom/tencent/kuikly/core/render/android/expand/component/KRImageView;", "", "propValue", "", "q0", "", "propKey", "", "b", "P", "Ljava/lang/String;", "uin", "", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "I", "type", "k", "()Z", "reusable", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", BdhLogUtil.LogTag.Tag_Req, "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class HRQQFaceImageView extends KRImageView {

    /* renamed from: P, reason: from kotlin metadata */
    private String uin;

    /* renamed from: Q, reason: from kotlin metadata */
    private int type;

    public HRQQFaceImageView(Context context) {
        super(context);
        this.uin = "";
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.KRImageView, i01.c
    public boolean b(String propKey, final Object propValue) {
        int hashCode = propKey.hashCode();
        if (hashCode != 115802) {
            if (hashCode == 3575610 && propKey.equals("type")) {
                if (propValue != null) {
                    this.type = ((Integer) propValue).intValue();
                    return true;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            }
        } else if (propKey.equals("uin")) {
            post(new Runnable() { // from class: com.tencent.ecommerce.biz.hr.component.HRQQFaceImageView$setProp$1
                @Override // java.lang.Runnable
                public final void run() {
                    HRQQFaceImageView.this.q0(propValue);
                }
            });
            return true;
        }
        return super.b(propKey, propValue);
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.KRImageView, i01.c
    /* renamed from: k */
    public boolean getReusable() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q0(Object propValue) {
        if (propValue != null) {
            String str = (String) propValue;
            if (Intrinsics.areEqual(this.uin, str)) {
                return;
            }
            this.uin = str;
            Drawable drawable = null;
            setImageDrawable(null);
            if (this.type == 0) {
                IECQQApi qqApi = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getQqApi();
                if (qqApi != null) {
                    drawable = qqApi.getContactFaceDrawable(str);
                }
            } else {
                IECQQApi qqApi2 = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getQqApi();
                if (qqApi2 != null) {
                    drawable = qqApi2.getTroopFaceDrawable(str);
                }
            }
            setImageDrawable(drawable);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }
}
