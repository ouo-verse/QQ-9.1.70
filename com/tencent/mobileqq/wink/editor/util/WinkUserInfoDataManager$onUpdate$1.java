package com.tencent.mobileqq.wink.editor.util;

import android.os.Handler;
import camera.SHADOW_BACKEND_INTERFACE.CircleTemplateInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
final class WinkUserInfoDataManager$onUpdate$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ CircleTemplateInfo $result;
    final /* synthetic */ WinkUserInfoDataManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkUserInfoDataManager$onUpdate$1(WinkUserInfoDataManager winkUserInfoDataManager, CircleTemplateInfo circleTemplateInfo) {
        super(1);
        this.this$0 = winkUserInfoDataManager;
        this.$result = circleTemplateInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(String str, WinkUserInfoDataManager this$0, CircleTemplateInfo circleTemplateInfo) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            this$0.f(null);
        } else {
            this$0.f(com.tencent.mobileqq.wink.editor.model.d.a(circleTemplateInfo, str));
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@Nullable final String str) {
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        final WinkUserInfoDataManager winkUserInfoDataManager = this.this$0;
        final CircleTemplateInfo circleTemplateInfo = this.$result;
        uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.util.p
            @Override // java.lang.Runnable
            public final void run() {
                WinkUserInfoDataManager$onUpdate$1.b(str, winkUserInfoDataManager, circleTemplateInfo);
            }
        });
    }
}
