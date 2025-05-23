package com.tencent.mobileqq.zplan.drawable;

import com.tencent.image.SharpDrawable;
import com.tencent.image.sharp.SharpImage;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\",\u0010\u0007\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00018B@BX\u0082\u000e\u00a2\u0006\f\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006\u00a8\u0006\b"}, d2 = {"Lcom/tencent/image/SharpDrawable;", "", "value", "getLoopCount", "(Lcom/tencent/image/SharpDrawable;)Ljava/lang/Integer;", "b", "(Lcom/tencent/image/SharpDrawable;Ljava/lang/Integer;)V", "loopCount", "zplan_api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class b {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(SharpDrawable sharpDrawable, Integer num) {
        SharpImage image;
        if (num != null && (image = sharpDrawable.getImage()) != null) {
            image.setLoopCount(num.intValue());
        }
    }
}
