package com.tencent.ecommerce.base.ktx;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u001a\u0014\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u001a \u0010\u000b\u001a\u00020\n\"\u000e\b\u0000\u0010\b*\b\u0012\u0004\u0012\u00028\u00000\u0007*\b\u0012\u0004\u0012\u00028\u00000\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/pb/PBBytesField;", "", RemoteHandleConst.PARAM_DEFAULT_VALUE, "c", "value", "", "b", "Lcom/tencent/mobileqq/pb/MessageMicro;", "T", "", "", "a", "ecommerce_sdk_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class c {
    public static final <T extends MessageMicro<T>> boolean a(List<? extends T> list) {
        return list.size() > 0;
    }

    public static final void b(PBBytesField pBBytesField, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        pBBytesField.set(ByteStringMicro.copyFromUtf8(str));
    }

    public static final String c(PBBytesField pBBytesField, String str) {
        return pBBytesField.has() ? pBBytesField.get().toStringUtf8() : str;
    }
}
