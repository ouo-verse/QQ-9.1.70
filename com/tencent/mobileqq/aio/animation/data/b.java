package com.tencent.mobileqq.aio.animation.data;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0002H&J\b\u0010\b\u001a\u00020\u0002H&J\b\u0010\t\u001a\u00020\u0005H&J\b\u0010\n\u001a\u00020\u0005H&J\b\u0010\f\u001a\u00020\u000bH&J\b\u0010\u000e\u001a\u00020\rH&J\b\u0010\u000f\u001a\u00020\u000bH&J\b\u0010\u0010\u001a\u00020\u000bH&J\b\u0010\u0011\u001a\u00020\rH&J\b\u0010\u0012\u001a\u00020\rH&J\b\u0010\u0013\u001a\u00020\rH&\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/aio/animation/data/b;", "", "", "getMsgId", "getMsgSeq", "", "getSenderUid", "getSenderUin", "getPeerUin", "getPeerUid", "e", "", "d", "", "c", "b", "f", "a", "getChatType", "getVipType", "aio_animation_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public interface b {
    int a();

    boolean b();

    int c();

    boolean d();

    @NotNull
    String e();

    boolean f();

    int getChatType();

    long getMsgId();

    long getMsgSeq();

    @NotNull
    String getPeerUid();

    long getPeerUin();

    @NotNull
    String getSenderUid();

    long getSenderUin();

    int getVipType();
}
