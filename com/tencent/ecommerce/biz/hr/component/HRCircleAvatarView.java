package com.tencent.ecommerce.biz.hr.component;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.proto.ECPBParser;
import com.tencent.ecommerce.biz.qcircle.api.IECQCircleApi;
import com.tencent.ecommerce.biz.qcircle.api.IECQCircleAvatarView;
import com.tencent.ecommerce.biz.util.ECThreadUtilKt;
import com.tencent.kuikly.core.render.android.expand.component.KRView;
import com.tencent.mobileqq.pb.MessageMicro;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010\r\u001a\u0004\u0018\u00010\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/ecommerce/biz/hr/component/HRCircleAvatarView;", "Lcom/tencent/kuikly/core/render/android/expand/component/KRView;", "", "propValue", "", "L", "", "propKey", "", "b", "Lcom/tencent/ecommerce/biz/qcircle/api/IECQCircleAvatarView;", "H", "Lcom/tencent/ecommerce/biz/qcircle/api/IECQCircleAvatarView;", "avatarView", "I", "Ljava/lang/String;", "pbToken", "k", "()Z", "reusable", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "J", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class HRCircleAvatarView extends KRView {

    /* renamed from: H, reason: from kotlin metadata */
    private final IECQCircleAvatarView avatarView;

    /* renamed from: I, reason: from kotlin metadata */
    private String pbToken;

    /* JADX WARN: Multi-variable type inference failed */
    public HRCircleAvatarView(Context context) {
        super(context);
        IECQCircleApi qCircleApi = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getQCircleApi();
        IECQCircleAvatarView createQCircleAvatarView = qCircleApi != null ? qCircleApi.createQCircleAvatarView(context) : 0;
        this.avatarView = createQCircleAvatarView;
        if (createQCircleAvatarView instanceof FrameLayout) {
            addView((View) createQCircleAvatarView);
        }
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.KRView, i01.c
    public boolean b(String propKey, Object propValue) {
        if (propKey.hashCode() == -1278410736 && propKey.equals("feedPB")) {
            L(propValue);
            return true;
        }
        return super.b(propKey, propValue);
    }

    @Override // com.tencent.kuikly.core.render.android.expand.component.KRView, i01.c
    /* renamed from: k */
    public boolean getReusable() {
        return false;
    }

    private final void L(Object propValue) {
        if (propValue != null) {
            String str = (String) propValue;
            if (Intrinsics.areEqual(this.pbToken, str)) {
                return;
            }
            this.pbToken = str;
            ECPBParser.f100901b.e(str, new Function1<MessageMicro<?>, Unit>() { // from class: com.tencent.ecommerce.biz.hr.component.HRCircleAvatarView$setFeedPb$$inlined$run$lambda$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(MessageMicro<?> messageMicro) {
                    invoke2(messageMicro);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(final MessageMicro<?> messageMicro) {
                    ECThreadUtilKt.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.hr.component.HRCircleAvatarView$setFeedPb$$inlined$run$lambda$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            IECQCircleAvatarView iECQCircleAvatarView;
                            iECQCircleAvatarView = HRCircleAvatarView.this.avatarView;
                            if (iECQCircleAvatarView != null) {
                                iECQCircleAvatarView.setFeedPb(messageMicro);
                            }
                        }
                    });
                }
            });
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }
}
