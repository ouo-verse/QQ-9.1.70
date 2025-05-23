package com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.logic;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.data.GuildSharePageSource;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.morepanel.FeedMorePanelLauncher;
import com.tencent.mobileqq.guild.feed.morepanel.FeedSharePanelReportHelper;
import com.tencent.mobileqq.guild.feed.morepanel.PanelContext;
import com.tencent.mobileqq.guild.feed.morepanel.impl.FeedMorePanelBusiImpl;
import com.tencent.mobileqq.guild.feed.morepanel.impl.n;
import com.tencent.mobileqq.guild.feed.morepanel.k;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.data.GProStFeedDetailRspWrapper;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.guild.feed.util.l;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.o;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStGetFeedDetailReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStGetFeedDetailRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetFeedDetailCallback;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a(\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002\u001a \u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002\u001a\u0016\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\n\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/morepanel/k;", ConstantsAPI.Token.WX_LAUNCH_PARAM_KEY, "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedBaseInitBean;", "initBean", "", "position", "Lvk1/a;", "feedSourceDataProvider", "", "e", "", "feedId", "Landroid/os/Bundle;", "d", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, tl.h.F, "qqguild_feed_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class ShareManageKt {
    private static final Bundle d(int i3, GuildFeedBaseInitBean guildFeedBaseInitBean, String str) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(com.tencent.mobileqq.guild.feed.b.f218115a, guildFeedBaseInitBean);
        bundle.putString("default_select_feed_id", str);
        bundle.putInt("default_select_feed_position", i3);
        bundle.putString("data_surface_key_data_type", "data_type_feed_list");
        return bundle;
    }

    private static final void e(k kVar, final GuildFeedBaseInitBean guildFeedBaseInitBean, final int i3, final vk1.a aVar) {
        PanelContext<Activity, vk1.b> e16 = kVar.e();
        e16.getExtra().putInt("src_business_type", guildFeedBaseInitBean.getBusinessType());
        e16.getExtra().putInt(AppConstants.Key.SHARE_PANEL_PAGE_SOURCE, GuildSharePageSource.FEED_LIST.ordinal());
        e16.getApiRouter().a(FeedMorePanelBusiImpl.OperationListProvider.b.class, new FeedMorePanelBusiImpl.OperationListProvider.b() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.logic.h
            @Override // com.tencent.mobileqq.guild.feed.morepanel.impl.FeedMorePanelBusiImpl.OperationListProvider.b
            public final Bundle a() {
                Bundle f16;
                f16 = ShareManageKt.f(i3, guildFeedBaseInitBean, aVar);
                return f16;
            }
        });
        e16.getApiRouter().a(FeedMorePanelBusiImpl.OperationListProvider.e.class, new FeedMorePanelBusiImpl.OperationListProvider.e() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.logic.i
            @Override // com.tencent.mobileqq.guild.feed.morepanel.impl.FeedMorePanelBusiImpl.OperationListProvider.e
            public final boolean a(String str) {
                boolean g16;
                g16 = ShareManageKt.g(vk1.a.this, guildFeedBaseInitBean, str);
                return g16;
            }
        });
        e16.getApiRouter().a(FeedMorePanelBusiImpl.OperationListProvider.c.class, new com.tencent.mobileqq.guild.feed.morepanel.cooperate.f(guildFeedBaseInitBean));
        e16.getApiRouter().a(com.tencent.mobileqq.guild.feed.morepanel.g.class, new FeedSharePanelReportHelper(aVar, kVar.getOperationListProvider(), null, 4, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bundle f(int i3, GuildFeedBaseInitBean initBean, vk1.a feedSourceDataProvider) {
        Intrinsics.checkNotNullParameter(initBean, "$initBean");
        Intrinsics.checkNotNullParameter(feedSourceDataProvider, "$feedSourceDataProvider");
        return d(i3, initBean, feedSourceDataProvider.getFeedId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean g(vk1.a feedSourceDataProvider, GuildFeedBaseInitBean initBean, String it) {
        String str;
        Intrinsics.checkNotNullParameter(feedSourceDataProvider, "$feedSourceDataProvider");
        Intrinsics.checkNotNullParameter(initBean, "$initBean");
        Intrinsics.checkNotNullParameter(it, "it");
        String str2 = "";
        if (!Intrinsics.areEqual(it, "") && !feedSourceDataProvider.B()) {
            yl1.i iVar = yl1.i.f450608a;
            String guildId = initBean.getGuildId();
            if (guildId != null) {
                str2 = guildId;
            }
            Boolean d16 = iVar.d(str2, feedSourceDataProvider.getFeedId(), String.valueOf(feedSourceDataProvider.getChannelId()));
            if (d16 != null) {
                return d16.booleanValue();
            }
            if (feedSourceDataProvider.g() > 0) {
                return true;
            }
        } else {
            yl1.i iVar2 = yl1.i.f450608a;
            String guildId2 = initBean.getGuildId();
            if (guildId2 == null) {
                str = "";
            } else {
                str = guildId2;
            }
            Boolean e16 = yl1.i.e(iVar2, str, feedSourceDataProvider.getFeedId(), null, 4, null);
            if (e16 != null) {
                return e16.booleanValue();
            }
            if (feedSourceDataProvider.getTopTimestamp() > 0) {
                return true;
            }
        }
        return false;
    }

    public static final void h(@NotNull final FragmentActivity activity, @NotNull String feedId) {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        String str = null;
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
        if (iGPSService != null) {
            str = iGPSService.getSelfTinyId();
        }
        GProStGetFeedDetailReq gProStGetFeedDetailReq = new GProStGetFeedDetailReq();
        gProStGetFeedDetailReq.userId = str;
        gProStGetFeedDetailReq.feedId = feedId;
        gProStGetFeedDetailReq.contentType = 2;
        gProStGetFeedDetailReq.detailType = 1;
        gProStGetFeedDetailReq.notReportReadCnt = true;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        o c16 = l.c();
        if (c16 != null) {
            c16.getFeedDetail(gProStGetFeedDetailReq, true, new IGProGetFeedDetailCallback() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.logic.g
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetFeedDetailCallback
                public final void onResult(int i3, String str2, boolean z16, GProStGetFeedDetailRsp gProStGetFeedDetailRsp) {
                    ShareManageKt.i(Ref.ObjectRef.this, activity, i3, str2, z16, gProStGetFeedDetailRsp);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r4v2, types: [yl1.k, T] */
    public static final void i(Ref.ObjectRef morePanelHandle, FragmentActivity activity, int i3, String errMsg, boolean z16, GProStGetFeedDetailRsp gProStGetFeedDetailRsp) {
        Intrinsics.checkNotNullParameter(morePanelHandle, "$morePanelHandle");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        QLog.d("Search.ShareManage", 1, "result = [" + i3 + "], errMsg = [" + errMsg + "], isDbCache = [" + z16 + "], rsp = [" + gProStGetFeedDetailRsp + "]");
        if (i3 == 0) {
            if (morePanelHandle.element != 0) {
                QLog.d("Search.ShareManage", 1, "is showing dialog, do not show again");
                return;
            }
            GProStFeed feed = gProStGetFeedDetailRsp.feed;
            GuildFeedBaseInitBean initBean = ax.o(null);
            Intrinsics.checkNotNullExpressionValue(feed, "feed");
            vk1.a aVar = new vk1.a(new GProStFeedDetailRspWrapper(feed, null, 2, null));
            FeedMorePanelLauncher feedMorePanelLauncher = new FeedMorePanelLauncher("pindao_feed");
            k d16 = feedMorePanelLauncher.d(activity, aVar, new Function2<k, PanelContext<Activity, vk1.b>, Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.bottom.interactive.layout.main.logic.ShareManageKt$startSharApiImpl$1$1$1

                /* compiled from: P */
                @Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0014\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/guild/feed/nativedetail/bottom/interactive/layout/main/logic/ShareManageKt$startSharApiImpl$1$1$1$a", "Lcom/tencent/mobileqq/guild/feed/morepanel/impl/FeedMorePanelBusiImpl$OperationListProvider;", "", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", "f", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
                /* loaded from: classes13.dex */
                public static final class a extends FeedMorePanelBusiImpl.OperationListProvider {
                    a(PanelContext<Activity, vk1.b> panelContext) {
                        super(panelContext);
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.tencent.mobileqq.guild.feed.morepanel.impl.FeedMorePanelBusiImpl.OperationListProvider
                    @NotNull
                    public List<ShareActionSheetBuilder.ActionSheetItem> f() {
                        return c(new int[]{153, 1, 11});
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(k kVar, PanelContext<Activity, vk1.b> panelContext) {
                    invoke2(kVar, panelContext);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull k buildLaunchParam, @NotNull PanelContext<Activity, vk1.b> it) {
                    Intrinsics.checkNotNullParameter(buildLaunchParam, "$this$buildLaunchParam");
                    Intrinsics.checkNotNullParameter(it, "it");
                    buildLaunchParam.f(new FeedMorePanelBusiImpl.a(it));
                    buildLaunchParam.i(new a(it));
                }
            });
            Intrinsics.checkNotNullExpressionValue(initBean, "initBean");
            e(d16, initBean, 0, aVar);
            d16.h(new n(d16.e()));
            morePanelHandle.element = feedMorePanelLauncher.h();
            return;
        }
        if (!z16 && morePanelHandle.element == 0) {
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            yl1.n.C(false, errMsg);
        }
    }
}
