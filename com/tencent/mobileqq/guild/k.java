package com.tencent.mobileqq.guild;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.home.chats.api.IChatApi;
import com.tencent.mobileqq.app.parser.JumpParserResult;
import com.tencent.mobileqq.app.parser.av;
import com.tencent.mobileqq.guild.util.at;
import com.tencent.mobileqq.qqguildsdk.api.IGProSession;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ax;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000b2\u00020\u0001:\u0002\u000b\u000eB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ.\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/k;", "Lcom/tencent/mobileqq/app/parser/av;", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "app", "Landroid/content/Context;", "context", "", "jump", "Lcom/tencent/mobileqq/app/parser/JumpParserResult;", "jumpParserResult", "Lcom/tencent/mobileqq/utils/ax;", "a", "<init>", "()V", "b", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class k extends av {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/k$b;", "Lcom/tencent/mobileqq/utils/ax;", "", "b", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "app", "Landroid/content/Context;", "context", "<init>", "(Lcom/tencent/common/app/business/BaseQQAppInterface;Landroid/content/Context;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class b extends ax {
        public b(BaseQQAppInterface baseQQAppInterface, Context context) {
            super(baseQQAppInterface, context);
        }

        @Override // com.tencent.mobileqq.utils.ax
        public boolean b() {
            uh2.c gProGuildMsgService;
            IChatApi iChatApi = (IChatApi) QRoute.api(IChatApi.class);
            Context context = this.f307437b;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            iChatApi.jumpToGuildHelperFragment(context);
            at atVar = at.f235448a;
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
            IGProSession iGProSession = (IGProSession) (appInterface != null ? appInterface.getRuntimeService(IGProSession.class, "") : null);
            if (iGProSession == null || (gProGuildMsgService = iGProSession.getGProGuildMsgService()) == null) {
                return true;
            }
            gProGuildMsgService.forceShowGuildHelperNode();
            return true;
        }
    }

    @Override // com.tencent.mobileqq.app.parser.av
    public ax a(BaseQQAppInterface app, Context context, String jump, JumpParserResult jumpParserResult) {
        Intrinsics.checkNotNullParameter(jump, "jump");
        QLog.d("GuildHelperParser", 2, "parse\uff1a" + jump);
        b bVar = new b(app, context);
        bVar.f307438c = jump;
        if (jumpParserResult != null) {
            bVar.f307439d = jumpParserResult.getServer();
            bVar.f307440e = jumpParserResult.getAction();
            bVar.s(jumpParserResult.getParamMap());
        }
        return bVar;
    }
}
