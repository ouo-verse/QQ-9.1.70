package a52;

import com.tencent.icgame.trpc.yes.common.MessageOuterClass$AnchorRoomBulletScreenMsg;
import com.tencent.icgame.trpc.yes.common.MessageOuterClass$TimMsgBody;
import com.tencent.mobileqq.icgame.widget.chat.message.LiveLocalMsg;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.qqlive.data.announce.AnnouncePushMessage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import w42.FollowPushScreenMessage;
import w42.GiftScreenMsg;
import w42.TeamPlayJoinMsg;
import w42.e;
import w42.g;
import w42.j;
import w42.k;
import w42.m;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u000e\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u00a8\u0006\u0004"}, d2 = {"", "msg", "", "a", "ic-game-widget-kit_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes15.dex */
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
        if (msg2 instanceof m) {
            if (((m) msg2).getMsg().msg_type.get() != 83) {
                return 102;
            }
            return 7;
        }
        if (msg2 instanceof FollowPushScreenMessage) {
            return 2;
        }
        if (msg2 instanceof w42.b) {
            return 3;
        }
        if (msg2 instanceof AnnouncePushMessage) {
            return 4;
        }
        if (msg2 instanceof j) {
            if (((j) msg2).getSysMsgType() == 0) {
                return 6;
            }
            return 11;
        }
        if (msg2 instanceof GiftScreenMsg) {
            return 5;
        }
        if ((msg2 instanceof LiveLocalMsg) || (msg2 instanceof MessageOuterClass$AnchorRoomBulletScreenMsg)) {
            return 100;
        }
        if (msg2 instanceof TeamPlayJoinMsg) {
            return 8;
        }
        if (msg2 instanceof g) {
            return 6;
        }
        if (msg2 instanceof k) {
            return 13;
        }
        return 9;
    }
}
