package com.tencent.timi.game.component.chat.at;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.utils.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import trpc.yes.common.CommonOuterClass$QQUserId;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \b2\u00020\u0001:\u0002\u0010\rB\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u0016\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u0016\u0010\f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\r\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002R\"\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f0\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\"\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00130\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/timi/game/component/chat/at/b;", "", "", "chatId", "msgId", "", "d", "", "c", "groupId", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "myUserId", "e", "b", "", "Lcom/tencent/timi/game/tim/api/message/b;", "a", "Ljava/util/Map;", "msgListenerMap", "Lcom/tencent/timi/game/tim/api/message/c;", "msgManagerMap", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class b {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final b f376349d = new b();

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static Map<String, List<String>> f376350e = new HashMap();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Map<String, com.tencent.timi.game.tim.api.message.b> msgListenerMap = new HashMap();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Map<String, com.tencent.timi.game.tim.api.message.c> msgManagerMap = new HashMap();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0018\u001a\u00020\u0014\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0019\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\"\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u0016\u0010\u0013\u001a\u00020\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011H\u0016R\u0017\u0010\u0018\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00198\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/timi/game/component/chat/at/b$a;", "Lcom/tencent/timi/game/tim/api/message/b;", "Lcom/tencent/timi/game/tim/api/message/a;", "msg", "", "e", h.F, "d", "b", "", "code", "", "desc", "f", "c", "msgId", "a", "", "historyMessages", "g", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "getMyUserId", "()Ltrpc/yes/common/CommonOuterClass$QQUserId;", "myUserId", "", "Ljava/util/List;", "getAtMsgNeedRemindList", "()Ljava/util/List;", "atMsgNeedRemindList", "<init>", "(Ltrpc/yes/common/CommonOuterClass$QQUserId;Ljava/util/List;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    private static final class a implements com.tencent.timi.game.tim.api.message.b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final CommonOuterClass$QQUserId myUserId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<String> atMsgNeedRemindList;

        public a(@NotNull CommonOuterClass$QQUserId myUserId, @NotNull List<String> atMsgNeedRemindList) {
            Intrinsics.checkNotNullParameter(myUserId, "myUserId");
            Intrinsics.checkNotNullParameter(atMsgNeedRemindList, "atMsgNeedRemindList");
            this.myUserId = myUserId;
            this.atMsgNeedRemindList = atMsgNeedRemindList;
        }

        @Override // com.tencent.timi.game.tim.api.message.b
        public void a(@NotNull String msgId) {
            Intrinsics.checkNotNullParameter(msgId, "msgId");
        }

        @Override // com.tencent.timi.game.tim.api.message.b
        public void b(@NotNull com.tencent.timi.game.tim.api.message.a msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x003f, code lost:
        
            if (r2 == false) goto L14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0062, code lost:
        
            if (r0 != false) goto L26;
         */
        @Override // com.tencent.timi.game.tim.api.message.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void c(@NotNull com.tencent.timi.game.tim.api.message.a msg2) {
            boolean z16;
            PBUInt64Field pBUInt64Field;
            boolean z17;
            PBUInt64Field pBUInt64Field2;
            Intrinsics.checkNotNullParameter(msg2, "msg");
            if (msg2.a().at_user_msg.user_list.size() > 0) {
                CommonOuterClass$QQUserId c16 = msg2.c();
                CommonOuterClass$QQUserId commonOuterClass$QQUserId = this.myUserId;
                boolean z18 = true;
                if (c16.uid.get() != 0) {
                    if (commonOuterClass$QQUserId != null && (pBUInt64Field2 = commonOuterClass$QQUserId.uid) != null && c16.uid.get() == pBUInt64Field2.get()) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                }
                if (c16.yes_uid.get() != 0) {
                    if (commonOuterClass$QQUserId != null && (pBUInt64Field = commonOuterClass$QQUserId.yes_uid) != null && c16.yes_uid.get() == pBUInt64Field.get()) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                }
                z18 = false;
                if (z18 && SpecialMsgUtil.f376345a.c(msg2, this.myUserId) && !this.atMsgNeedRemindList.contains(msg2.id())) {
                    this.atMsgNeedRemindList.add(msg2.id());
                }
            }
        }

        @Override // com.tencent.timi.game.tim.api.message.b
        public void d(@NotNull com.tencent.timi.game.tim.api.message.a msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
        }

        @Override // com.tencent.timi.game.tim.api.message.b
        public void e(@NotNull com.tencent.timi.game.tim.api.message.a msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
        }

        @Override // com.tencent.timi.game.tim.api.message.b
        public void f(@NotNull com.tencent.timi.game.tim.api.message.a msg2, int code, @Nullable String desc) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
        }

        @Override // com.tencent.timi.game.tim.api.message.b
        public void g(@NotNull List<? extends com.tencent.timi.game.tim.api.message.a> historyMessages) {
            Intrinsics.checkNotNullParameter(historyMessages, "historyMessages");
        }

        @Override // com.tencent.timi.game.tim.api.message.b
        public void h(@NotNull com.tencent.timi.game.tim.api.message.a msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/timi/game/component/chat/at/b$b;", "", "Lcom/tencent/timi/game/component/chat/at/b;", "stance", "Lcom/tencent/timi/game/component/chat/at/b;", "a", "()Lcom/tencent/timi/game/component/chat/at/b;", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.timi.game.component.chat.at.b$b, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes26.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final b a() {
            return b.f376349d;
        }

        Companion() {
        }
    }

    public final void b(@NotNull String groupId) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        l.b("AtMsgManager ", "endListener ");
        com.tencent.timi.game.tim.api.message.c cVar = this.msgManagerMap.get(groupId);
        if (cVar != null) {
            cVar.k(this.msgListenerMap.get(groupId));
        }
        this.msgManagerMap.remove(groupId);
        f376350e.remove(groupId);
    }

    public final void c(@NotNull String chatId, @NotNull String msgId) {
        List<String> list;
        Intrinsics.checkNotNullParameter(chatId, "chatId");
        Intrinsics.checkNotNullParameter(msgId, "msgId");
        if (!TextUtils.isEmpty(msgId)) {
            List<String> list2 = f376350e.get(chatId);
            boolean z16 = false;
            if (list2 != null && list2.contains(msgId)) {
                z16 = true;
            }
            if (z16 && (list = f376350e.get(chatId)) != null) {
                list.remove(msgId);
            }
        }
    }

    public final boolean d(@NotNull String chatId, @NotNull String msgId) {
        List<String> list;
        Intrinsics.checkNotNullParameter(chatId, "chatId");
        Intrinsics.checkNotNullParameter(msgId, "msgId");
        if (TextUtils.isEmpty(msgId) || (list = f376350e.get(chatId)) == null) {
            return false;
        }
        return list.contains(msgId);
    }

    public final void e(@NotNull String groupId, @NotNull CommonOuterClass$QQUserId myUserId) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(myUserId, "myUserId");
        l.b("AtMsgManager ", "startListener " + groupId + " ");
        b(groupId);
        this.msgManagerMap.put(groupId, ((kn4.b) mm4.b.b(kn4.b.class)).M(Long.parseLong(groupId)));
        ArrayList arrayList = new ArrayList();
        f376350e.put(groupId, arrayList);
        this.msgListenerMap.put(groupId, new a(myUserId, arrayList));
        com.tencent.timi.game.tim.api.message.c cVar = this.msgManagerMap.get(groupId);
        if (cVar != null) {
            cVar.b(this.msgListenerMap.get(groupId));
        }
    }
}
