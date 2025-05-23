package com.tencent.guild.aio.help;

import android.content.Context;
import android.view.View;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.guild.aio.background.GuildFullBackgroundMviIntent;
import com.tencent.guild.api.channel.IGuildAIOBackgroundApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0003B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\u0002H\u0016J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0004H\u0016R\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/guild/aio/help/d;", "Lcom/tencent/aio/main/businesshelper/h;", "", "a", "", "getId", "", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "state", "onMoveToState", "d", "Lcom/tencent/aio/main/businesshelper/b;", "<init>", "()V", "e", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class d implements com.tencent.aio.main.businesshelper.h {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.main.businesshelper.b param;

    private final void a() {
        IGuildAIOBackgroundApi iGuildAIOBackgroundApi = (IGuildAIOBackgroundApi) QRoute.api(IGuildAIOBackgroundApi.class);
        com.tencent.aio.main.businesshelper.b bVar = this.param;
        com.tencent.aio.main.businesshelper.b bVar2 = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            bVar = null;
        }
        Context context = bVar.a().c().getContext();
        com.tencent.aio.main.businesshelper.b bVar3 = this.param;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
            bVar3 = null;
        }
        View aioCreate = iGuildAIOBackgroundApi.aioCreate(context, bVar3.a().g().r().c().j(), 10014);
        if (aioCreate != null) {
            QLog.i("GuildAIOChatBackgroundHelper", 1, "create add the view: " + aioCreate);
            com.tencent.aio.main.businesshelper.b bVar4 = this.param;
            if (bVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("param");
            } else {
                bVar2 = bVar4;
            }
            bVar2.a().e().h(new GuildFullBackgroundMviIntent.GuildUpdateAIOBackground(aioCreate, false));
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return 30;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        return "GuildAIOChatBackgroundHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        return new int[]{0, 4, 3, 8, 12};
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        this.param = param;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        h.a.b(this);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        if (state != 0) {
            if (state != 8) {
                if (state != 12) {
                    if (state != 3) {
                        if (state == 4) {
                            IGuildAIOBackgroundApi iGuildAIOBackgroundApi = (IGuildAIOBackgroundApi) QRoute.api(IGuildAIOBackgroundApi.class);
                            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                            Intrinsics.checkNotNull(peekAppRuntime);
                            String account = peekAppRuntime.getAccount();
                            Intrinsics.checkNotNullExpressionValue(account, "sMobileQQ.peekAppRuntime()!!.account");
                            iGuildAIOBackgroundApi.aioDelayLoad(account);
                            return;
                        }
                        return;
                    }
                    ((IGuildAIOBackgroundApi) QRoute.api(IGuildAIOBackgroundApi.class)).aioResume();
                    return;
                }
                ((IGuildAIOBackgroundApi) QRoute.api(IGuildAIOBackgroundApi.class)).aioDestroy();
                return;
            }
            ((IGuildAIOBackgroundApi) QRoute.api(IGuildAIOBackgroundApi.class)).aioPause();
            return;
        }
        a();
    }
}
