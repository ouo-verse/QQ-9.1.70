package com.tencent.mobileqq.wink.publish.part;

import com.tencent.mobileqq.wink.api.QQWinkConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H\u0004J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004H\u0004\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/wink/publish/part/j;", "Lp53/a;", "", "B9", "", "A9", "enable", "", "z9", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public abstract class j extends p53.a {
    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean A9() {
        Integer defaultValue = uq3.c.X0("qqcircle", "qqcircle_save_media_in_device_when_publish", 1);
        com.tencent.mobileqq.wink.utils.ar arVar = com.tencent.mobileqq.wink.utils.ar.f326685a;
        String k3 = arVar.k(QQWinkConstants.WINK_PUBLISH_PARAM_IS_SAVE_MEDIA);
        Intrinsics.checkNotNullExpressionValue(defaultValue, "defaultValue");
        if (arVar.e(k3, defaultValue.intValue()) == 1) {
            return true;
        }
        return false;
    }

    @NotNull
    public abstract String B9();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void z9(boolean enable) {
        com.tencent.mobileqq.wink.utils.ar arVar = com.tencent.mobileqq.wink.utils.ar.f326685a;
        arVar.o(arVar.k(QQWinkConstants.WINK_PUBLISH_PARAM_IS_SAVE_MEDIA), enable ? 1 : 0);
    }
}
