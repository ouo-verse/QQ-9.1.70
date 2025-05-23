package com.tencent.timi.game.jump.api.impl;

import ag4.i;
import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.utils.ax;
import com.tencent.timi.game.jump.api.impl.i;
import com.tencent.timi.game.ui.TGDialogHelperFragment;
import fm4.TeamCreatePageParam;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameAuthOuterClass$GetGameAuthRsp;
import trpc.yes.common.YesGameInfoOuterClass$GetUserGameDefaultRoleRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB\u001b\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/timi/game/jump/api/impl/i;", "Lcom/tencent/mobileqq/utils/ax;", "", "b", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "appInterface", "Landroid/content/Context;", "ctx", "<init>", "(Lcom/tencent/common/app/business/BaseQQAppInterface;Landroid/content/Context;)V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class i extends ax {

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0002J\"\u0010\u0010\u001a\u00020\u000f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000e\u001a\u00020\fR\u0014\u0010\u0011\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/timi/game/jump/api/impl/i$a;", "", "", "yesGameId", "Lfm4/c;", "guildParam", "Lfm4/h;", "liveTeamParams", "entryScene", "", "e", "Ljava/util/HashMap;", "", Node.ATTRS_ATTR, "source", "", "i", "TAG", "Ljava/lang/String;", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.timi.game.jump.api.impl.i$a, reason: from kotlin metadata */
    /* loaded from: classes26.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void e(final int yesGameId, final fm4.c guildParam, final fm4.h liveTeamParams, final int entryScene) {
            ((ag4.i) mm4.b.b(ag4.i.class)).J2(yesGameId, new i.b() { // from class: com.tencent.timi.game.jump.api.impl.f
                @Override // ag4.i.b
                public final void i(boolean z16, int i3, String str, Object obj) {
                    i.Companion.f(yesGameId, entryScene, guildParam, liveTeamParams, z16, i3, str, (GameAuthOuterClass$GetGameAuthRsp) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(final int i3, final int i16, final fm4.c cVar, final fm4.h liveTeamParams, boolean z16, int i17, String str, GameAuthOuterClass$GetGameAuthRsp gameAuthOuterClass$GetGameAuthRsp) {
            Intrinsics.checkNotNullParameter(liveTeamParams, "$liveTeamParams");
            ((ag4.i) mm4.b.b(ag4.i.class)).s0(i3, new i.b() { // from class: com.tencent.timi.game.jump.api.impl.g
                @Override // ag4.i.b
                public final void i(boolean z17, int i18, String str2, Object obj) {
                    i.Companion.g(i3, i16, cVar, liveTeamParams, z17, i18, str2, (YesGameInfoOuterClass$GetUserGameDefaultRoleRsp) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g(final int i3, final int i16, final fm4.c cVar, final fm4.h liveTeamParams, boolean z16, int i17, String str, YesGameInfoOuterClass$GetUserGameDefaultRoleRsp yesGameInfoOuterClass$GetUserGameDefaultRoleRsp) {
            Intrinsics.checkNotNullParameter(liveTeamParams, "$liveTeamParams");
            TGDialogHelperFragment.INSTANCE.d(new Runnable() { // from class: com.tencent.timi.game.jump.api.impl.h
                @Override // java.lang.Runnable
                public final void run() {
                    i.Companion.h(i3, i16, cVar, liveTeamParams);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void h(int i3, int i16, fm4.c cVar, fm4.h liveTeamParams) {
            Intrinsics.checkNotNullParameter(liveTeamParams, "$liveTeamParams");
            ((sm4.a) mm4.b.b(sm4.a.class)).j1(vf4.a.b(), i3, com.tencent.timi.game.utils.b.h(i16), 2, 0L, cVar, liveTeamParams, new TeamCreatePageParam(true));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void j(int i3, fm4.c cVar, fm4.h liveTeamParams, int i16, boolean z16) {
            Intrinsics.checkNotNullParameter(liveTeamParams, "$liveTeamParams");
            i.INSTANCE.e(i3, cVar, liveTeamParams, i16);
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x006e, code lost:
        
            r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x0084, code lost:
        
            r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x00a4, code lost:
        
            r12 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r12);
         */
        /* JADX WARN: Code restructure failed: missing block: B:3:0x003a, code lost:
        
            r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r0);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final boolean i(@NotNull HashMap<String, String> attrs, @NotNull String source) {
            long j3;
            boolean z16;
            final int i3;
            final int i16;
            final fm4.c cVar;
            Integer intOrNull;
            Integer intOrNull2;
            Long longOrNull;
            Long longOrNull2;
            Intrinsics.checkNotNullParameter(attrs, "attrs");
            Intrinsics.checkNotNullParameter(source, "source");
            com.tencent.timi.game.utils.l.i("TimiGameTeamCreateAction_", "doAction attrs:" + attrs + ", source:" + source);
            String str = attrs.get("guildid");
            long j16 = 0;
            if (str != null && longOrNull2 != null) {
                j3 = longOrNull2.longValue();
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
            if (str4 != null && longOrNull != null) {
                j16 = longOrNull.longValue();
            }
            long j17 = j16;
            String str5 = attrs.get("yesgameid");
            if (str5 != null && intOrNull2 != null) {
                i3 = intOrNull2.intValue();
            } else {
                i3 = 101;
            }
            final fm4.h hVar = new fm4.h();
            hVar.f399881h = source;
            String str6 = attrs.get("entryscene");
            if (str6 != null && intOrNull != null) {
                i16 = intOrNull.intValue();
            } else {
                i16 = 2;
            }
            if (i16 == 2) {
                cVar = new fm4.c(j3, j17, str3);
            } else {
                cVar = null;
            }
            ((hi4.b) mm4.b.b(hi4.b.class)).d3(new hi4.a() { // from class: com.tencent.timi.game.jump.api.impl.e
                @Override // hi4.a
                public final void a(boolean z17) {
                    i.Companion.j(i3, cVar, hVar, i16, z17);
                }
            });
            return true;
        }

        Companion() {
        }
    }

    public i(@Nullable BaseQQAppInterface baseQQAppInterface, @Nullable Context context) {
        super(baseQQAppInterface, context);
        this.f307439d = "esports";
        this.f307440e = "team/create";
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean b() {
        Companion companion = INSTANCE;
        HashMap<String, String> attrs = this.f307441f;
        Intrinsics.checkNotNullExpressionValue(attrs, "attrs");
        String source = this.f307438c;
        Intrinsics.checkNotNullExpressionValue(source, "source");
        return companion.i(attrs, source);
    }
}
