package com.tencent.mobileqq.guild.api.impl;

import android.content.Context;
import com.tencent.aelight.camera.pref.api.IPhoneConfig;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/api/impl/s;", "Lcom/tencent/qqnt/chats/biz/guild/h;", "Landroid/content/Context;", "ctx", "", "a", "", "b", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class s implements com.tencent.qqnt.chats.biz.guild.h {

    /* renamed from: b, reason: collision with root package name */
    private static long f214461b;

    @Override // com.tencent.qqnt.chats.biz.guild.h
    public int a(@NotNull Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        return ((IPhoneConfig) QRoute.api(IPhoneConfig.class)).getPhoneLevel();
    }

    @Override // com.tencent.qqnt.chats.biz.guild.h
    public long b() {
        return f214461b;
    }
}
