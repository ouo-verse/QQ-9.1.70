package com.tencent.qqnt.emotion.msg.utils;

import com.tencent.commonsdk.util.HexUtil;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0010\u0012\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0014\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0000H\u0002\u00a8\u0006\u0004"}, d2 = {"", "", "kotlin.jvm.PlatformType", "b", "emotion_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class b {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String b(byte[] bArr) {
        return HexUtil.bytes2HexStr(bArr);
    }
}
