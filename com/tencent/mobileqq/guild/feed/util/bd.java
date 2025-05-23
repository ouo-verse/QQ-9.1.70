package com.tencent.mobileqq.guild.feed.util;

import android.view.View;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.guild.feed.event.GuildScrollFollowClickViewEvent;
import com.tencent.mobileqq.guild.feed.event.GuildScrollFollowInputEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bR\u0016\u0010\r\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/util/bd;", "", "", "height", "targetHeightHint", "inputHeight", "", "b", "Landroid/view/View;", "view", "a", "", "Z", "isClickEventWaitConsumed", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class bd {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final bd f223882a = new bd();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean isClickEventWaitConsumed;

    bd() {
    }

    public final void a(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        isClickEventWaitConsumed = true;
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i3 = iArr[0];
        int i16 = iArr[1];
        hj1.b.a("GuildScrollFollowInputHelper", "[sendClickViewPosition] y = " + i16);
        SimpleEventBus.getInstance().dispatchEvent(new GuildScrollFollowClickViewEvent(i3, i16), true);
    }

    public final void b(int height, int targetHeightHint, int inputHeight) {
        if (!isClickEventWaitConsumed) {
            return;
        }
        isClickEventWaitConsumed = false;
        SimpleEventBus.getInstance().dispatchEvent(new GuildScrollFollowInputEvent(height, targetHeightHint, inputHeight), true);
    }
}
