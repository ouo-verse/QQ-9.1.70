package com.tencent.timi.game.jump.api.impl;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ax;
import com.tencent.timi.game.api.ITimiGameApi;
import com.tencent.timi.game.api.param.ExpandHallLaunchParam;
import com.tencent.timi.game.api.param.TimiGameConst$YesGameId;
import java.net.URLDecoder;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u001b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/timi/game/jump/api/impl/b;", "Lcom/tencent/mobileqq/utils/ax;", "", "b", "Lcom/tencent/timi/game/api/param/ExpandHallLaunchParam;", "openParam", "", "H", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "appInterface", "Landroid/content/Context;", "ctx", "<init>", "(Lcom/tencent/common/app/business/BaseQQAppInterface;Landroid/content/Context;)V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class b extends ax {

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ$\u0010\b\u001a\u00020\u00072\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\"\u0010\t\u001a\u00020\u00072\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005R\u0014\u0010\n\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/timi/game/jump/api/impl/b$a;", "", "Ljava/util/HashMap;", "", Node.ATTRS_ATTR, "Lcom/tencent/timi/game/api/param/ExpandHallLaunchParam;", "openParam", "", "a", "b", "TAG", "Ljava/lang/String;", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.timi.game.jump.api.impl.b$a, reason: from kotlin metadata */
    /* loaded from: classes26.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void a(HashMap<String, String> attrs, ExpandHallLaunchParam openParam) {
            Long l3;
            String str = attrs.get("guildid");
            Long l16 = null;
            if (str != null) {
                l3 = StringsKt__StringNumberConversionsKt.toLongOrNull(str);
            } else {
                l3 = null;
            }
            String str2 = attrs.get("channelname");
            String str3 = attrs.get("channelicon");
            String str4 = attrs.get("channelid");
            String str5 = attrs.get("teamid");
            if (str5 != null) {
                l16 = StringsKt__StringNumberConversionsKt.toLongOrNull(str5);
            }
            com.tencent.timi.game.utils.l.i("TimiGameJumpAction_", "parseGuildParams guildId:" + l3 + ", channelName:" + str2 + ", channelIcon:" + str3 + ", channelId:" + str4 + ", teamId:" + l16 + " ");
            if (l3 != null) {
                openParam.f376304h = l3.longValue();
            }
            if (str2 != null) {
                openParam.f376305i = URLDecoder.decode(str2);
            }
            if (str3 != null) {
                openParam.f376306m = URLDecoder.decode(str3);
            }
            openParam.C = str4;
            if (l16 != null) {
                openParam.F = l16.longValue();
            }
        }

        public final void b(@NotNull HashMap<String, String> attrs, @NotNull ExpandHallLaunchParam openParam) {
            Integer num;
            Integer num2;
            Long l3;
            Integer num3;
            boolean z16;
            boolean z17;
            Intrinsics.checkNotNullParameter(attrs, "attrs");
            Intrinsics.checkNotNullParameter(openParam, "openParam");
            String str = attrs.get("roomtype");
            Long l16 = null;
            if (str != null) {
                num = StringsKt__StringNumberConversionsKt.toIntOrNull(str);
            } else {
                num = null;
            }
            String str2 = attrs.get("entryscene");
            if (str2 != null) {
                num2 = StringsKt__StringNumberConversionsKt.toIntOrNull(str2);
            } else {
                num2 = null;
            }
            String str3 = attrs.get("teamid");
            if (str3 != null) {
                l3 = StringsKt__StringNumberConversionsKt.toLongOrNull(str3);
            } else {
                l3 = null;
            }
            String str4 = attrs.get("destscene");
            String str5 = attrs.get("yesgameid");
            if (str5 != null) {
                num3 = StringsKt__StringNumberConversionsKt.toIntOrNull(str5);
            } else {
                num3 = null;
            }
            String str6 = attrs.get("roomid");
            if (str6 != null) {
                l16 = StringsKt__StringNumberConversionsKt.toLongOrNull(str6);
            }
            com.tencent.timi.game.utils.l.i("TimiGameJumpAction_", "doAction roomType:" + num + ", entryScene:" + num2 + " teamId:" + l3 + " gameId:" + num3 + " roomId:" + l16);
            boolean z18 = false;
            if ((num != null && num.intValue() == 1) || (num != null && num.intValue() == 2)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                openParam.f376302e = num.intValue();
                if (l3 != null) {
                    openParam.F = l3.longValue();
                }
            }
            if ((num2 != null && num2.intValue() == 1) || (num2 != null && num2.intValue() == 2)) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17 || (num2 != null && num2.intValue() == 3)) {
                z18 = true;
            }
            if (z18) {
                openParam.f376301d = num2.intValue();
            }
            if (openParam.f376301d == 2) {
                a(attrs, openParam);
            }
            if (str4 != null) {
                if (Intrinsics.areEqual(str4, "1")) {
                    openParam.D = "0";
                } else {
                    openParam.D = str4;
                }
            }
            if (num3 != null) {
                int intValue = num3.intValue();
                if (TimiGameConst$YesGameId.a(intValue)) {
                    openParam.f376303f = intValue;
                } else {
                    com.tencent.timi.game.utils.l.e("TimiGameJumpAction_", "gameId " + num3 + " is invalid");
                }
            }
            if (l16 != null) {
                openParam.H = l16.longValue();
            }
        }

        Companion() {
        }
    }

    public b(@Nullable BaseQQAppInterface baseQQAppInterface, @Nullable Context context) {
        super(baseQQAppInterface, context);
        this.f307439d = "esports";
        this.f307440e = "open";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(b this$0, ExpandHallLaunchParam openParam) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(openParam, "$openParam");
        ITimiGameApi iTimiGameApi = (ITimiGameApi) QRoute.api(ITimiGameApi.class);
        Context context = this$0.f307437b;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        iTimiGameApi.openExpandHall(context, openParam);
    }

    public final void H(@NotNull ExpandHallLaunchParam openParam) {
        Intrinsics.checkNotNullParameter(openParam, "openParam");
        Companion companion = INSTANCE;
        HashMap<String, String> attrs = this.f307441f;
        Intrinsics.checkNotNullExpressionValue(attrs, "attrs");
        companion.b(attrs, openParam);
    }

    @Override // com.tencent.mobileqq.utils.ax
    public boolean b() {
        com.tencent.timi.game.utils.l.i("TimiGameJumpAction_", "doAction attrs:" + this.f307441f + ", source:" + this.f307438c);
        final ExpandHallLaunchParam expandHallLaunchParam = new ExpandHallLaunchParam();
        Companion companion = INSTANCE;
        HashMap<String, String> attrs = this.f307441f;
        Intrinsics.checkNotNullExpressionValue(attrs, "attrs");
        companion.b(attrs, expandHallLaunchParam);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.timi.game.jump.api.impl.a
            @Override // java.lang.Runnable
            public final void run() {
                b.G(b.this, expandHallLaunchParam);
            }
        });
        return true;
    }
}
