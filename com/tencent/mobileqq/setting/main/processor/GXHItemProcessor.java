package com.tencent.mobileqq.setting.main.processor;

import android.content.Context;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\f\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u001b\u0010\u000b\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/setting/main/processor/GXHItemProcessor;", "Lcom/tencent/mobileqq/setting/processor/c;", "Lcom/tencent/mobileqq/widget/listitem/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "onResume", "Lcom/tencent/mobileqq/setting/config/b;", "g", "Lkotlin/Lazy;", "v", "()Lcom/tencent/mobileqq/setting/config/b;", "gxhConfig", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "qq_setting_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class GXHItemProcessor extends com.tencent.mobileqq.setting.processor.c {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final Lazy gxhConfig;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GXHItemProcessor(Context context) {
        super(context, 20);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        lazy = LazyKt__LazyJVMKt.lazy(new GXHItemProcessor$gxhConfig$2(context));
        this.gxhConfig = lazy;
    }

    private final com.tencent.mobileqq.setting.config.b v() {
        return (com.tencent.mobileqq.setting.config.b) this.gxhConfig.getValue();
    }

    @Override // com.tencent.mobileqq.setting.processor.c, com.tencent.mobileqq.setting.processor.d
    public void onResume() {
        super.onResume();
        l();
    }

    @Override // com.tencent.mobileqq.setting.processor.c
    public com.tencent.mobileqq.widget.listitem.a<?> q() {
        return v();
    }
}
