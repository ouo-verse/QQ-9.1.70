package com.tencent.guild.aio.msglist.graytips.local.subscribe;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.aio.data.AIOContact;
import com.tencent.common.app.AppInterface;
import com.tencent.guild.aio.msglist.graytips.local.subscribe.b;
import com.tencent.guild.aio.msglist.holder.component.t;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildChannelSubscribeApi;
import com.tencent.mobileqq.guild.util.IQQGuildSPUtilsApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import vh2.cc;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/guild/aio/msglist/graytips/local/subscribe/d;", "Lcom/tencent/guild/aio/msglist/holder/component/t;", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/fragment/app/FragmentManager;", "fm", "o", "Lol3/b;", "intent", "handleIntent", "<init>", "()V", "d", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class d extends t {
    /* JADX WARN: Multi-variable type inference failed */
    private final void m(com.tencent.aio.data.msglist.a msgItem) {
        final FragmentManager fragmentManager;
        AppInterface appInterface;
        AIOContact c16 = ((com.tencent.aio.api.runtime.a) getMContext()).g().r().c();
        Fragment c17 = ((com.tencent.aio.api.runtime.a) getMContext()).c();
        IRuntimeService iRuntimeService = null;
        if (c17 != null) {
            fragmentManager = c17.getChildFragmentManager();
        } else {
            fragmentManager = null;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService != null) {
            iGPSService.setQQMsgListChannel(c16.f(), c16.j(), 1, new cc() { // from class: com.tencent.guild.aio.msglist.graytips.local.subscribe.c
                @Override // vh2.cc
                public final void onResult(int i3, String str) {
                    d.n(d.this, fragmentManager, i3, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(d this$0, FragmentManager fragmentManager, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 != 0) {
            if (i3 != 110000) {
                QQToast.makeText(BaseApplication.context, 1, R.string.f1511016s, 0).show();
                QLog.d("GuildSubscribeGrayTipsVM", 1, "addToMsgList failed result=" + i3 + ", errMsg=" + str);
                return;
            }
            QQToast.makeText(BaseApplication.context, 1, R.string.f141010fi, 0).show();
            return;
        }
        this$0.o(fragmentManager);
    }

    private final void o(FragmentManager fm5) {
        if (!((IQQGuildSPUtilsApi) QRoute.api(IQQGuildSPUtilsApi.class)).hasSubscribeChannelSuccessfullyEver()) {
            ((IQQGuildSPUtilsApi) QRoute.api(IQQGuildSPUtilsApi.class)).setSubscribeChannelSuccessfully();
            if (fm5 != null) {
                ((IGuildChannelSubscribeApi) QRoute.api(IGuildChannelSubscribeApi.class)).showSubscribeSuccessFeedBackDialog(fm5);
                return;
            }
            return;
        }
        QQToast.makeText(BaseApplication.context, 2, R.string.f141020fj, 0).show();
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.t, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void handleIntent(@NotNull ol3.b intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof b.a) {
            m(((b.a) intent).getMsgItem());
        }
    }
}
