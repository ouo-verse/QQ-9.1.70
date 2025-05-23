package com.tencent.mobileqq.guild.feed.util;

import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/util/bg;", "", "", "filePath", "a", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class bg {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final bg f223884a = new bg();

    bg() {
    }

    @Nullable
    public final String a(@NotNull String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        String str = null;
        try {
            byte[] partfileMd5 = MD5.getPartfileMd5(filePath, 0L);
            if (partfileMd5 != null) {
                str = com.tencent.qqprotect.singleupdate.a.b(partfileMd5);
            }
            if (QLog.isDebugVersion()) {
                QLog.e("GuildFeedMd5Util", 2, "getFileMD5String md5: " + str);
            }
            return str;
        } catch (Exception e16) {
            QLog.e("GuildFeedMd5Util", 2, "error getFileMD5String filePath: " + filePath + ", error=" + e16.getMessage());
            return null;
        }
    }
}
