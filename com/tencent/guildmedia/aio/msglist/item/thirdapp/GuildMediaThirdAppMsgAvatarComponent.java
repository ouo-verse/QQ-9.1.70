package com.tencent.guildmedia.aio.msglist.item.thirdapp;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.data.AIOParam;
import com.tencent.common.app.AppInterface;
import com.tencent.guild.aio.component.combinestyle.o;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.guild.api.IGuildQCircleAvatarApi;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarView;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u000b\u00a2\u0006\u0004\b\u001c\u0010\u001dJ&\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0016\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\rH\u0016R\u0017\u0010\u0015\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u001b\u001a\u00020\u00168DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006 "}, d2 = {"Lcom/tencent/guildmedia/aio/msglist/item/thirdapp/GuildMediaThirdAppMsgAvatarComponent;", "Lcom/tencent/guildmedia/aio/msglist/holder/component/a;", "", "position", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "", "payloads", "", "b1", "Landroid/view/View;", "d1", "Lcom/tencent/aio/base/mvvm/b;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "e1", "D", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "root", "Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarView;", "E", "Lkotlin/Lazy;", "J1", "()Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarView;", "avatarView", "<init>", "(Landroid/view/View;)V", UserInfo.SEX_FEMALE, "a", "aio-guild-media_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public class GuildMediaThirdAppMsgAvatarComponent extends com.tencent.guildmedia.aio.msglist.holder.component.a {

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final View root;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy avatarView;

    public GuildMediaThirdAppMsgAvatarComponent(@NotNull View root) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(root, "root");
        this.root = root;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GuildUserAvatarView>() { // from class: com.tencent.guildmedia.aio.msglist.item.thirdapp.GuildMediaThirdAppMsgAvatarComponent$avatarView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildUserAvatarView invoke() {
                GuildUserAvatarView guildUserAvatarView = new GuildUserAvatarView(GuildMediaThirdAppMsgAvatarComponent.this.getRoot().getContext());
                int dip2px = ViewUtils.dip2px(20.0f);
                guildUserAvatarView.setLayoutParams(new ViewGroup.LayoutParams(dip2px, dip2px));
                guildUserAvatarView.setRoundRect(ViewUtils.dip2px(3.0f));
                vs0.a.o(guildUserAvatarView, "em_aio_profile", null, 4, null);
                return guildUserAvatarView;
            }
        });
        this.avatarView = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I1(GuildMediaThirdAppMsgAvatarComponent this$0, String appId, View view) {
        String str;
        AIOParam g16;
        String b16;
        AIOParam g17;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(appId, "$appId");
        if (this$0.u1(this$0.root)) {
            Context mContext = this$0.getMContext();
            Intrinsics.checkNotNull(mContext, "null cannot be cast to non-null type android.app.Activity");
            Activity activity = (Activity) mContext;
            com.tencent.aio.api.runtime.a f16 = this$0.f1();
            String str2 = "";
            if (f16 == null || (g17 = f16.g()) == null || (str = com.tencent.guild.aio.util.a.g(g17)) == null) {
                str = "";
            }
            com.tencent.aio.api.runtime.a f17 = this$0.f1();
            if (f17 != null && (g16 = f17.g()) != null && (b16 = com.tencent.guild.aio.util.a.b(g16)) != null) {
                str2 = b16;
            }
            vs0.a.k(activity, appId, str, str2);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @NotNull
    protected final GuildUserAvatarView J1() {
        return (GuildUserAvatarView) this.avatarView.getValue();
    }

    @Override // com.tencent.guild.aio.component.combinestyle.AbsGuildMediaStyleComponent, com.tencent.guild.aio.msglist.holder.component.a
    public void b1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        IGProChannelInfo channelInfo;
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.b1(position, msgItem, payloads);
        if (msgItem instanceof GuildMsgItem) {
            String d16 = vs0.a.d(msgItem, MiniConst.WxMiniAppInfoConst.EXTRA_ICON);
            final String d17 = vs0.a.d(msgItem, "app_id");
            if (TextUtils.isEmpty(d16)) {
                J1().setImageDrawable(BaseImageUtil.getDefaultFaceDrawable());
                return;
            }
            ((IGuildQCircleAvatarApi) QRoute.api(IGuildQCircleAvatarApi.class)).loadAvatarByUrl(d16, J1());
            J1().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guildmedia.aio.msglist.item.thirdapp.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildMediaThirdAppMsgAvatarComponent.I1(GuildMediaThirdAppMsgAvatarComponent.this, d17, view);
                }
            });
            HashMap hashMap = new HashMap();
            GuildMsgItem guildMsgItem = (GuildMsgItem) msgItem;
            String str = guildMsgItem.getMsgRecord().channelId;
            hashMap.put("sgrp_channel_id", guildMsgItem.getMsgRecord().guildId);
            hashMap.put("sgrp_sub_channel_id", str);
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            Integer num = null;
            if (peekAppRuntime instanceof AppInterface) {
                appInterface = (AppInterface) peekAppRuntime;
            } else {
                appInterface = null;
            }
            if (appInterface != null) {
                iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
            } else {
                iRuntimeService = null;
            }
            IGPSService iGPSService = (IGPSService) iRuntimeService;
            if (iGPSService != null && (channelInfo = iGPSService.getChannelInfo(str)) != null) {
                num = Integer.valueOf(channelInfo.getType());
            }
            hashMap.put("sgrp_sub_channel_type", num);
            VideoReport.setElementParams(J1(), hashMap);
        }
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    @NotNull
    public View d1() {
        return J1();
    }

    @Override // com.tencent.guild.aio.component.combinestyle.AbsGuildMediaStyleComponent, com.tencent.guild.aio.msglist.holder.component.a, com.tencent.mvi.mvvm.framework.FrameworkVB
    @Nullable
    /* renamed from: e1 */
    public com.tencent.aio.base.mvvm.b<ol3.b, MviUIState> createVM() {
        return new o();
    }

    @NotNull
    public final View getRoot() {
        return this.root;
    }
}
