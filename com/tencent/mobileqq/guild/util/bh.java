package com.tencent.mobileqq.guild.util;

import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/util/bh;", "", "", "isBackground", "", "a", "b", "Z", "mIsBackGround", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class bh {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final bh f235466a = new bh();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean mIsBackGround;

    bh() {
    }

    public final void a(boolean isBackground) {
        QLog.d("GuildUserOnlineStatusHelper", 1, "updateOnlineTime isBackground = " + isBackground);
        mIsBackGround = isBackground;
        if (isBackground) {
            bw.h1(System.currentTimeMillis());
        } else {
            bw.h1(0L);
        }
    }
}
