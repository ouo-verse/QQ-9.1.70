package com.tencent.mobileqq.notification.modularize;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.s2c.msgtype0x210.submsgtype0x135.ModulePushPb$ForcePushInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000\u00a8\u0006\u0003"}, d2 = {"Ltencent/im/s2c/msgtype0x210/submsgtype0x135/ModulePushPb$ForcePushInfo;", "Lcom/tencent/mobileqq/notification/modularize/b;", "a", "AQQLiteModule_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public final class g {
    @Nullable
    public static final b a(@NotNull ModulePushPb$ForcePushInfo modulePushPb$ForcePushInfo) {
        Intrinsics.checkNotNullParameter(modulePushPb$ForcePushInfo, "<this>");
        if (!modulePushPb$ForcePushInfo.has()) {
            return null;
        }
        String str = modulePushPb$ForcePushInfo.action_text.get();
        Intrinsics.checkNotNullExpressionValue(str, "this.action_text.get()");
        String str2 = modulePushPb$ForcePushInfo.action_jump.get();
        Intrinsics.checkNotNullExpressionValue(str2, "this.action_jump.get()");
        String str3 = modulePushPb$ForcePushInfo.bg_url.get();
        Intrinsics.checkNotNullExpressionValue(str3, "this.bg_url.get()");
        String str4 = modulePushPb$ForcePushInfo.voice_url.get();
        Intrinsics.checkNotNullExpressionValue(str4, "this.voice_url.get()");
        String str5 = modulePushPb$ForcePushInfo.content.get();
        Intrinsics.checkNotNullExpressionValue(str5, "this.content.get()");
        String str6 = modulePushPb$ForcePushInfo.title.get();
        Intrinsics.checkNotNullExpressionValue(str6, "this.title.get()");
        long j3 = modulePushPb$ForcePushInfo.duration.get();
        boolean z16 = modulePushPb$ForcePushInfo.is_loop.get();
        String str7 = modulePushPb$ForcePushInfo.left_icon.get();
        Intrinsics.checkNotNullExpressionValue(str7, "this.left_icon.get()");
        String str8 = modulePushPb$ForcePushInfo.bg_title.get();
        Intrinsics.checkNotNullExpressionValue(str8, "this.bg_title.get()");
        return new b(str, str2, str3, str4, str5, str6, j3, z16, str7, str8);
    }
}
