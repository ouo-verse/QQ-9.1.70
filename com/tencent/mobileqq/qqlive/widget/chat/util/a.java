package com.tencent.mobileqq.qqlive.widget.chat.util;

import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.qqlive.data.announce.AnnouncePushMessage;
import com.tencent.mobileqq.qqlive.widget.chat.message.LiveLocalMsg;
import com.tencent.mobileqq.qqlive.widget.chat.message.d;
import com.tencent.mobileqq.qqlive.widget.chat.message.e;
import com.tencent.mobileqq.qqlive.widget.chat.message.g;
import com.tencent.mobileqq.qqlive.widget.chat.message.j;
import com.tencent.mobileqq.qqlive.widget.chat.message.k;
import com.tencent.mobileqq.qqlive.widget.chat.message.l;
import com.tencent.mobileqq.qqlive.widget.chat.message.n;
import com.tencent.mobileqq.qqlive.widget.chat.message.o;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.MessageOuterClass$AnchorRoomBulletScreenMsg;
import trpc.yes.common.MessageOuterClass$TimMsgBody;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u000e\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u00a8\u0006\u0004"}, d2 = {"", "msg", "", "a", "qq-live-widget-kit_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class a {
    public static final int a(@NotNull Object msg2) {
        int i3;
        PBInt32Field pBInt32Field;
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (msg2 instanceof e) {
            MessageOuterClass$TimMsgBody a16 = ((e) msg2).a();
            if (a16 != null && (pBInt32Field = a16.msg_type) != null) {
                i3 = pBInt32Field.get();
            } else {
                i3 = 0;
            }
            if (i3 == 0) {
                return 1;
            }
            if (i3 == 1) {
                return 100;
            }
            if (i3 != 70) {
                return 102;
            }
            return 101;
        }
        if (msg2 instanceof l) {
            if (((l) msg2).a().msg_type.get() != 83) {
                return 102;
            }
            return 7;
        }
        if (msg2 instanceof com.tencent.mobileqq.qqlive.widget.chat.message.c) {
            return 2;
        }
        if (msg2 instanceof com.tencent.mobileqq.qqlive.widget.chat.message.b) {
            return 3;
        }
        if (msg2 instanceof AnnouncePushMessage) {
            return 4;
        }
        if (msg2 instanceof j) {
            if (((j) msg2).c() == 0) {
                return 6;
            }
            return 11;
        }
        if (msg2 instanceof d) {
            return 5;
        }
        if ((msg2 instanceof LiveLocalMsg) || (msg2 instanceof MessageOuterClass$AnchorRoomBulletScreenMsg)) {
            return 100;
        }
        if (msg2 instanceof k) {
            return 8;
        }
        if (msg2 instanceof n) {
            return 10;
        }
        if (msg2 instanceof o) {
            return 12;
        }
        if (msg2 instanceof g) {
            return 6;
        }
        return 9;
    }
}
