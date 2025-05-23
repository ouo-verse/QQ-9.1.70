package com.tencent.mobileqq.guild.feed.util;

import cooperation.qzone.remote.logic.RemoteHandleConst;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u001a\f\u0010\u0001\u001a\u00020\u0000*\u0004\u0018\u00010\u0000\u001a\u0014\u0010\u0004\u001a\u00020\u0002*\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0005"}, d2 = {"", "a", "", RemoteHandleConst.PARAM_DEFAULT_VALUE, "b", "qqguild_feed_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class bh {
    @NotNull
    public static final String a(@Nullable String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    public static final long b(@Nullable String str, long j3) {
        if (str != null) {
            try {
                return Long.parseLong(str);
            } catch (Exception unused) {
                return j3;
            }
        }
        return j3;
    }
}
