package com.tencent.zplan.common.utils;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0002*\u0004\u0018\u00010\u0002H\u0007\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/zplan/common/utils/i;", "", "", "a", "<init>", "()V", "common_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i f385295a = new i();

    i() {
    }

    @JvmStatic
    @Nullable
    public static final String a(@Nullable String str) {
        boolean z16;
        int i3 = 0;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return null;
        }
        int length = str.length() - 4;
        int i16 = length - 4;
        if (length < 0) {
            return str;
        }
        if (i16 >= 0) {
            i3 = i16;
        }
        StringBuffer stringBuffer = new StringBuffer(str);
        if (i3 < length && length > 0) {
            stringBuffer.replace(i3, length, "*");
        }
        return stringBuffer.toString();
    }
}
