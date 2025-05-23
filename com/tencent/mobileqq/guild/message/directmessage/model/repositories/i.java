package com.tencent.mobileqq.guild.message.directmessage.model.repositories;

import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001e\u0010\u0006\u001a\u00020\u00032\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002H\u0007J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0003H\u0007R\u0016\u0010\n\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/message/directmessage/model/repositories/i;", "", "Lkotlin/Function1;", "", "", "callback", "b", "switchType", "d", "I", "feedsCommentsSwitch", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i f230532a = new i();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static int feedsCommentsSwitch;

    i() {
    }

    @JvmStatic
    public static final int b(@Nullable final Function1<? super Integer, Unit> callback) {
        int i3 = feedsCommentsSwitch;
        if (i3 == 0) {
            IRuntimeService S0 = ch.S0(IGPSService.class, "");
            Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
            ((IGPSService) S0).fetchFeedsNotifySwitch(new vh2.k() { // from class: com.tencent.mobileqq.guild.message.directmessage.model.repositories.h
                @Override // vh2.k
                public final void onResult(int i16, String str, int i17) {
                    i.c(Function1.this, i16, str, i17);
                }
            });
        } else if (callback != null) {
            callback.invoke(Integer.valueOf(i3));
        }
        return feedsCommentsSwitch;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(Function1 function1, int i3, String str, int i16) {
        d(i16);
        if (function1 != null) {
            function1.invoke(Integer.valueOf(i16));
        }
    }

    @JvmStatic
    public static final void d(int switchType) {
        feedsCommentsSwitch = switchType;
    }
}
