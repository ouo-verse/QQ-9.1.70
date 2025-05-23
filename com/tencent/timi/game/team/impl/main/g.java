package com.tencent.timi.game.team.impl.main;

import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.l;
import com.tencent.timi.game.utils.o;
import java.util.Random;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.MessageOuterClass$AtUser;
import trpc.yes.common.MessageOuterClass$AtUserMsg;
import trpc.yes.common.MessageOuterClass$MsgContent;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomInfo;

/* compiled from: P */
/* loaded from: classes26.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private static String[] f379611a = {"\u6781\u901f\u53d1\u8f66\uff0c\u5feb\u6765\uff01", "\u5feb\u4e0a\u8f66\uff0c\u4e0d\u89e3\u91ca\uff01", "\u4e00\u8d77\u6765\u73a9\uff0c\u6ef4~", "\u6765\u4e0d\u53ca\u89e3\u91ca\u5566\uff0c\u5feb\u4e0a\u8f66\u554a\uff01", "\u8f66\u901f\u8f83\u5feb\uff0c\u5373\u5c06\u53d1\u8f66\uff01"};

    /* renamed from: b, reason: collision with root package name */
    private static Random f379612b = new Random();

    public static String a() {
        String[] strArr = f379611a;
        return strArr[f379612b.nextInt(strArr.length)];
    }

    public static void b(YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo, long j3, CommonOuterClass$QQUserId commonOuterClass$QQUserId, String str) {
        l.i("TeamMessageUtil", "sendRoomMsgToExpandHall expandHallRoomId = " + j3 + ", shareUserId = " + commonOuterClass$QQUserId);
        if (o.f("handleTeamInviteClick_" + com.tencent.timi.game.utils.b.j(commonOuterClass$QQUserId), ((fm4.g) mm4.b.b(fm4.g.class)).S2().a() * 1000)) {
            com.tencent.timi.game.ui.widget.f.c("\u8bf4\u8bdd\u592a\u5feb\u4e86\uff0c\u4f11\u606f\u4e00\u4e0b\u5427\u3002");
            l.e("TeamMessageUtil", "sendRoomMsgToExpandHall but too quick!");
        } else {
            ((sm4.a) mm4.b.b(sm4.a.class)).m1(new a(str, commonOuterClass$QQUserId, j3));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public class a implements IResultListener<Boolean> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f379613a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CommonOuterClass$QQUserId f379614b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f379615c;

        a(String str, CommonOuterClass$QQUserId commonOuterClass$QQUserId, long j3) {
            this.f379613a = str;
            this.f379614b = commonOuterClass$QQUserId;
            this.f379615c = j3;
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(Boolean bool) {
            String a16 = g.a();
            gh4.e I0 = ((gh4.f) mm4.b.b(gh4.f.class)).I0();
            if (I0 != null) {
                MessageOuterClass$AtUserMsg messageOuterClass$AtUserMsg = new MessageOuterClass$AtUserMsg();
                messageOuterClass$AtUserMsg.text.set("@" + this.f379613a + " " + a16);
                MessageOuterClass$AtUser messageOuterClass$AtUser = new MessageOuterClass$AtUser();
                messageOuterClass$AtUser.nick_name.set(this.f379613a);
                messageOuterClass$AtUser.user_id.set(this.f379614b);
                messageOuterClass$AtUserMsg.user_list.add(messageOuterClass$AtUser);
                MessageOuterClass$MsgContent messageOuterClass$MsgContent = new MessageOuterClass$MsgContent();
                messageOuterClass$MsgContent.at_user_msg.set(messageOuterClass$AtUserMsg);
                ((kn4.b) mm4.b.b(kn4.b.class)).M(this.f379615c).c(I0.s4(), 70, messageOuterClass$MsgContent);
                com.tencent.timi.game.ui.widget.f.c("\u9080\u8bf7\u6210\u529f\uff0c\u7b49\u5f85\u4e0a\u8f66\u3002");
            }
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int i3, String str) {
        }
    }
}
