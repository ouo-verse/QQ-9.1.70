package com.tencent.mobileqq.qqecommerce.biz.messagecenter.data.data_source.message;

import com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.MessageStyle;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u00a8\u0006\u0003"}, d2 = {"", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/MessageStyle;", "a", "qqecommerce_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class b {
    public static final MessageStyle a(int i3) {
        if (i3 == 1) {
            return MessageStyle.TEXT;
        }
        if (i3 == 2) {
            return MessageStyle.TEXT_URL;
        }
        if (i3 == 3) {
            return MessageStyle.TEXT_URL_SMALL_PIC;
        }
        if (i3 != 4) {
            return MessageStyle.TEXT;
        }
        return MessageStyle.TEXT_URL_BIG_PIC;
    }
}
