package com.tencent.timi.game.jump.api.impl;

import ag4.i;
import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.utils.ax;
import com.tencent.timi.game.jump.api.impl.n;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameAuthOuterClass$GetGameAuthRsp;
import trpc.yes.common.YesGameInfoOuterClass$GetUserGameDefaultRoleRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB\u001b\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/timi/game/jump/api/impl/n;", "Lcom/tencent/mobileqq/utils/ax;", "", "b", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "appInterface", "Landroid/content/Context;", "ctx", "<init>", "(Lcom/tencent/common/app/business/BaseQQAppInterface;Landroid/content/Context;)V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class n extends ax {

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J2\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H\u0002J\u001a\u0010\u0010\u001a\u00020\u000f2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fR\u0014\u0010\u0011\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/timi/game/jump/api/impl/n$a;", "", "", "yesGameId", "", "teamId", "Lfm4/c;", "guildShequnParams", "fromRoomId", "entryScene", "", "d", "Ljava/util/HashMap;", "", Node.ATTRS_ATTR, "", "g", "TAG", "Ljava/lang/String;", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.timi.game.jump.api.impl.n$a, reason: from kotlin metadata */
    /* loaded from: classes26.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void d(final int yesGameId, final long teamId, final fm4.c guildShequnParams, final long fromRoomId, final int entryScene) {
            ((ag4.i) mm4.b.b(ag4.i.class)).I1(yesGameId, new i.b() { // from class: com.tencent.timi.game.jump.api.impl.l
                @Override // ag4.i.b
                public final void i(boolean z16, int i3, String str, Object obj) {
                    n.Companion.e(yesGameId, teamId, entryScene, guildShequnParams, fromRoomId, z16, i3, str, (GameAuthOuterClass$GetGameAuthRsp) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(final int i3, final long j3, final int i16, final fm4.c cVar, final long j16, boolean z16, int i17, String str, GameAuthOuterClass$GetGameAuthRsp gameAuthOuterClass$GetGameAuthRsp) {
            ((ag4.i) mm4.b.b(ag4.i.class)).m2(i3, new i.b() { // from class: com.tencent.timi.game.jump.api.impl.m
                @Override // ag4.i.b
                public final void i(boolean z17, int i18, String str2, Object obj) {
                    n.Companion.f(j3, i16, i3, cVar, j16, z17, i18, str2, (YesGameInfoOuterClass$GetUserGameDefaultRoleRsp) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(long j3, int i3, int i16, fm4.c cVar, long j16, boolean z16, int i17, String str, YesGameInfoOuterClass$GetUserGameDefaultRoleRsp yesGameInfoOuterClass$GetUserGameDefaultRoleRsp) {
            List<Integer> emptyList;
            com.tencent.timi.game.room.impl.util.d dVar = new com.tencent.timi.game.room.impl.util.d();
            dVar.f379324a = j3;
            dVar.f379325b = com.tencent.timi.game.utils.b.h(i3);
            dVar.f379326c = 2;
            dVar.f379328e = ((fm4.g) mm4.b.b(fm4.g.class)).J(i16);
            dVar.f379329f = cVar;
            dVar.f379327d = ((fm4.g) mm4.b.b(fm4.g.class)).h2(com.tencent.timi.game.utils.b.k(i16));
            dVar.f379330g = j16;
            dVar.f379331h = 0L;
            com.tencent.timi.game.room.impl.util.c cVar2 = new com.tencent.timi.game.room.impl.util.c();
            cVar2.f379322a = 0;
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            cVar2.f379323b = emptyList;
            ((sm4.a) mm4.b.b(sm4.a.class)).Y2(true, vf4.a.b(), dVar, cVar2, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void h(int i3, long j3, fm4.c cVar, long j16, int i16, boolean z16) {
            n.INSTANCE.d(i3, j3, cVar, j16, i16);
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0061, code lost:
        
            r1 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x0079, code lost:
        
            r1 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0091, code lost:
        
            r1 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x00ab, code lost:
        
            r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:3:0x002d, code lost:
        
            r1 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r1);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final boolean g(@NotNull HashMap<String, String> attrs) {
            long j3;
            boolean z16;
            long j16;
            int i3;
            int i16;
            fm4.c cVar;
            Integer intOrNull;
            Integer intOrNull2;
            Long longOrNull;
            Long longOrNull2;
            Long longOrNull3;
            Intrinsics.checkNotNullParameter(attrs, "attrs");
            com.tencent.timi.game.utils.l.i("TimiGameTeamJoinAction_", "doAction attrs:" + attrs);
            String str = attrs.get("guildid");
            long j17 = 0;
            if (str != null && longOrNull3 != null) {
                j3 = longOrNull3.longValue();
            } else {
                j3 = 0;
            }
            String str2 = attrs.get("channelname");
            if (str2 != null && str2.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                str2 = "";
            }
            String str3 = str2;
            String str4 = attrs.get("channelid");
            if (str4 != null && longOrNull2 != null) {
                j16 = longOrNull2.longValue();
            } else {
                j16 = 0;
            }
            String str5 = attrs.get("teamid");
            if (str5 != null && longOrNull != null) {
                j17 = longOrNull.longValue();
            }
            final long j18 = j17;
            final long j19 = 0;
            String str6 = attrs.get("yesgameid");
            if (str6 != null && intOrNull2 != null) {
                i3 = intOrNull2.intValue();
            } else {
                i3 = 101;
            }
            final int i17 = i3;
            String str7 = attrs.get("entryscene");
            if (str7 != null && intOrNull != null) {
                i16 = intOrNull.intValue();
            } else {
                i16 = 2;
            }
            if (i16 == 2) {
                cVar = new fm4.c(j3, j16, str3);
            } else {
                cVar = null;
            }
            final fm4.c cVar2 = cVar;
            final int i18 = i16;
            ((hi4.b) mm4.b.b(hi4.b.class)).d3(new hi4.a() { // from class: com.tencent.timi.game.jump.api.impl.k
                @Override // hi4.a
                public final void a(boolean z17) {
                    n.Companion.h(i17, j18, cVar2, j19, i18, z17);
                }
            });
            return true;
        }

        Companion() {
        }
    }

    public n(@Nullable BaseQQAppInterface baseQQAppInterface, @Nullable Context context) {
        super(baseQQAppInterface, context);
        this.f307439d = "esports";
        this.f307440e = "team/join";
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean b() {
        Companion companion = INSTANCE;
        HashMap<String, String> attrs = this.f307441f;
        Intrinsics.checkNotNullExpressionValue(attrs, "attrs");
        return companion.g(attrs);
    }
}
