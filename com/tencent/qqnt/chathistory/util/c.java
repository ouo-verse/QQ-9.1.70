package com.tencent.qqnt.chathistory.util;

import android.util.SparseIntArray;
import com.tencent.mobileqq.text.EmotcationConstants;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u0014\u0010\u0003\u001a\u00020\u00008@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0001\u0010\u0002\"\u0014\u0010\u0007\u001a\u00020\u00048@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\"\u001c\u0010\f\u001a\n \t*\u0004\u0018\u00010\b0\b8@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\r"}, d2 = {"", "b", "()C", "SYS_EMOTCATION_HEAD", "", "c", "()I", "VALID_SYS_EMOTCATION_COUNT", "Landroid/util/SparseIntArray;", "kotlin.jvm.PlatformType", "a", "()Landroid/util/SparseIntArray;", "EMOJI_MAP", "chathistory_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class c {
    public static final SparseIntArray a() {
        return EmotcationConstants.EMOJI_MAP;
    }

    public static final char b() {
        return (char) 20;
    }

    public static final int c() {
        return EmotcationConstants.VALID_SYS_EMOTCATION_COUNT;
    }
}
