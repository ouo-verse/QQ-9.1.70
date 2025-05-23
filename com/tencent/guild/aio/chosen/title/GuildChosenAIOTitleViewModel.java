package com.tencent.guild.aio.chosen.title;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.os.BundleKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.AppInterface;
import com.tencent.guild.aio.chosen.msglist.GuildChosenMsgIntent;
import com.tencent.guild.aio.chosen.title.g;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListIntent;
import com.tencent.guild.aio.msglist.checkbox.GuildMultiMsgManager;
import com.tencent.guild.aio.title.GuildAioTitleBackBtnUIState;
import com.tencent.guild.aio.title.GuildAioTitleMultiSelectUIState;
import com.tencent.guild.aio.title.GuildAioTitleTextUIState;
import com.tencent.guild.aio.title.IGuildAioTitleUIState;
import com.tencent.guild.aio.title.c;
import com.tencent.guild.aio.util.apicompat.SuspendAipKt;
import com.tencent.guild.aio.util.y;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.ILaunchGuildChatPieApi;
import com.tencent.mobileqq.guild.api.LaunchGuildChatPieParam;
import com.tencent.mobileqq.guild.api.i;
import com.tencent.mobileqq.guild.util.IGuildFeedsHomeJumpApi;
import com.tencent.mobileqq.guild.util.IQQGuildUIUtilApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProTopMsg;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import tl.h;
import vh2.cc;

/* compiled from: P */
@Metadata(d1 = {"\u0000_\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001&\u0018\u0000 \u00132\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00010B\u0007\u00a2\u0006\u0004\b.\u0010/J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0013\u0010\b\u001a\u00020\u0007H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u0004H\u0002J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0007H\u0002J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J\u001e\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bJ\b\u0010\u001e\u001a\u00020\u0004H\u0016R\u0016\u0010!\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00061"}, d2 = {"Lcom/tencent/guild/aio/chosen/title/GuildChosenAIOTitleViewModel;", "Lcom/tencent/aio/base/mvvm/b;", "Lcom/tencent/guild/aio/title/c;", "Lcom/tencent/guild/aio/title/IGuildAioTitleUIState;", "", "v", "u", "", "t", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", HippyTKDListViewAdapter.X, "", "channelId", "guildId", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/guild/aio/title/c$k;", "intent", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "E", "isMultiSelectMode", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", "w", "Landroid/content/Context;", "ctx", "B", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "d", "Z", "isHideBtnClickable", "Lcom/tencent/aio/data/AIOContact;", "e", "Lcom/tencent/aio/data/AIOContact;", "contact", "com/tencent/guild/aio/chosen/title/GuildChosenAIOTitleViewModel$b", "f", "Lcom/tencent/guild/aio/chosen/title/GuildChosenAIOTitleViewModel$b;", "mAction", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", h.F, "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "mGPServiceObserver", "<init>", "()V", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildChosenAIOTitleViewModel extends com.tencent.aio.base.mvvm.b<com.tencent.guild.aio.title.c, IGuildAioTitleUIState> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private AIOContact contact;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isHideBtnClickable = true;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mAction = new b();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GPServiceObserver mGPServiceObserver = new c();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/guild/aio/chosen/title/GuildChosenAIOTitleViewModel$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            GuildChosenAIOTitleViewModel.this.E(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JP\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b2\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bH\u0014\u00a8\u0006\r"}, d2 = {"com/tencent/guild/aio/chosen/title/GuildChosenAIOTitleViewModel$c", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "guildId", "channelId", "fromTinyId", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProTopMsg;", "Lkotlin/collections/ArrayList;", "topMsgList", "oldMsgList", "", "onChannelTopMsgUpdated", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class c extends GPServiceObserver {
        c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onChannelTopMsgUpdated(@NotNull String guildId, @NotNull String channelId, @NotNull String fromTinyId, @NotNull ArrayList<IGProTopMsg> topMsgList, @NotNull ArrayList<IGProTopMsg> oldMsgList) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            Intrinsics.checkNotNullParameter(fromTinyId, "fromTinyId");
            Intrinsics.checkNotNullParameter(topMsgList, "topMsgList");
            Intrinsics.checkNotNullParameter(oldMsgList, "oldMsgList");
            if (TextUtils.equals(guildId, ((com.tencent.aio.api.runtime.a) GuildChosenAIOTitleViewModel.this.getMContext()).g().r().c().f()) && TextUtils.equals(channelId, ((com.tencent.aio.api.runtime.a) GuildChosenAIOTitleViewModel.this.getMContext()).g().r().c().j())) {
                GuildChosenAIOTitleViewModel.this.u();
            }
        }
    }

    private final void A(boolean isMultiSelectMode) {
        updateUI(new GuildAioTitleMultiSelectUIState.a().e(isMultiSelectMode).getState());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(QQCustomDialog topMsgDlg, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(topMsgDlg, "$topMsgDlg");
        topMsgDlg.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(final String guildId, final String channelId, final GuildChosenAIOTitleViewModel this$0, DialogInterface dialogInterface, int i3) {
        AppInterface appInterface;
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        Intrinsics.checkNotNullParameter(channelId, "$channelId");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRuntimeService iRuntimeService = null;
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
            iGPSService.closeChannelTopMsg(guildId, channelId, new cc() { // from class: com.tencent.guild.aio.chosen.title.f
                @Override // vh2.cc
                public final void onResult(int i16, String str) {
                    GuildChosenAIOTitleViewModel.F(GuildChosenAIOTitleViewModel.this, channelId, guildId, i16, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(MsgIntent i3) {
        boolean z16;
        if (i3 instanceof GuildMsgListIntent.GuildMultiSelectModeChangeEvent) {
            A(((GuildMsgListIntent.GuildMultiSelectModeChangeEvent) i3).getIsSelectMode());
        } else if (i3 instanceof GuildChosenMsgIntent.ChosenMsgSizeChange) {
            if (((GuildChosenMsgIntent.ChosenMsgSizeChange) i3).getSize() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            updateUI(new GuildAioTitleEmptyDataUIState(z16));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(GuildChosenAIOTitleViewModel this$0, String channelId, String guildId, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(channelId, "$channelId");
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        QLog.i("HideChosenBarItem", 1, "close top msg, result = " + i3 + " errMsg = " + str);
        if (y.b(i3)) {
            com.tencent.guild.aio.util.flowbus.a.INSTANCE.b(new nq0.c());
            QQToast.makeText(BaseApplication.getContext(), 2, R.string.f157961ob, 0).show();
            this$0.s(channelId, guildId);
            return;
        }
        QQToast.makeText(BaseApplication.getContext(), R.string.f157951oa, 0).show();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void s(String channelId, String guildId) {
        FragmentActivity activity;
        if (((IGuildFeedsHomeJumpApi) QRoute.api(IGuildFeedsHomeJumpApi.class)).isJumpFeedsHome()) {
            i a16 = new i().b(channelId).f(guildId).e(BundleKt.bundleOf(new Pair[0])).d(com.tencent.guild.aio.factory.a.class.getName()).a();
            if (((IQQGuildUIUtilApi) QRoute.api(IQQGuildUIUtilApi.class)).shouldLaunchInSplitViewMode(((com.tencent.aio.api.runtime.a) getMContext()).c().requireActivity())) {
                ((ILaunchGuildChatPieApi) QRoute.api(ILaunchGuildChatPieApi.class)).launchGuildChatFragment(((com.tencent.aio.api.runtime.a) getMContext()).c().requireActivity(), a16);
                return;
            } else {
                ((ILaunchGuildChatPieApi) QRoute.api(ILaunchGuildChatPieApi.class)).launchGuildChatActivity(((com.tencent.aio.api.runtime.a) getMContext()).c().requireActivity(), a16);
                return;
            }
        }
        Intent guildChatPieIntent = ((ILaunchGuildChatPieApi) QRoute.api(ILaunchGuildChatPieApi.class)).getGuildChatPieIntent(((com.tencent.aio.api.runtime.a) getMContext()).c().getActivity(), new LaunchGuildChatPieParam().b(channelId).l(guildId).r(true).o(1).g(8).f(true).a());
        if (guildChatPieIntent != null && (activity = ((com.tencent.aio.api.runtime.a) getMContext()).c().getActivity()) != null) {
            activity.startActivity(guildChatPieIntent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object t(Continuation<? super Boolean> continuation) {
        GuildChosenAIOTitleViewModel$checkChannelChosenMsgCloseSuspend$1 guildChosenAIOTitleViewModel$checkChannelChosenMsgCloseSuspend$1;
        Object coroutine_suspended;
        int i3;
        com.tencent.qqnt.msg.api.c cVar;
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        if (continuation instanceof GuildChosenAIOTitleViewModel$checkChannelChosenMsgCloseSuspend$1) {
            guildChosenAIOTitleViewModel$checkChannelChosenMsgCloseSuspend$1 = (GuildChosenAIOTitleViewModel$checkChannelChosenMsgCloseSuspend$1) continuation;
            int i16 = guildChosenAIOTitleViewModel$checkChannelChosenMsgCloseSuspend$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                guildChosenAIOTitleViewModel$checkChannelChosenMsgCloseSuspend$1.label = i16 - Integer.MIN_VALUE;
                Object obj = guildChosenAIOTitleViewModel$checkChannelChosenMsgCloseSuspend$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = guildChosenAIOTitleViewModel$checkChannelChosenMsgCloseSuspend$1.label;
                boolean z16 = true;
                if (i3 == 0) {
                    if (i3 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
                    Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
                    String g17 = com.tencent.guild.aio.util.a.g(g16);
                    if (g17 == null) {
                        g17 = "";
                    }
                    AIOParam g18 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
                    Intrinsics.checkNotNullExpressionValue(g18, "mContext.aioParam");
                    String b16 = com.tencent.guild.aio.util.a.b(g18);
                    if (b16 == null) {
                        b16 = "";
                    }
                    AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                    cVar = null;
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
                        guildChosenAIOTitleViewModel$checkChannelChosenMsgCloseSuspend$1.label = 1;
                        obj = SuspendAipKt.a(iGPSService, g17, b16, guildChosenAIOTitleViewModel$checkChannelChosenMsgCloseSuspend$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    if (cVar != null) {
                        if (!y.b(cVar.c()) || !((Boolean) cVar.a()).booleanValue()) {
                            z16 = false;
                        }
                        return Boxing.boxBoolean(z16);
                    }
                    return Boxing.boxBoolean(true);
                }
                cVar = (com.tencent.qqnt.msg.api.c) obj;
                if (cVar != null) {
                }
            }
        }
        guildChosenAIOTitleViewModel$checkChannelChosenMsgCloseSuspend$1 = new GuildChosenAIOTitleViewModel$checkChannelChosenMsgCloseSuspend$1(this, continuation);
        Object obj2 = guildChosenAIOTitleViewModel$checkChannelChosenMsgCloseSuspend$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = guildChosenAIOTitleViewModel$checkChannelChosenMsgCloseSuspend$1.label;
        boolean z162 = true;
        if (i3 == 0) {
        }
        cVar = (com.tencent.qqnt.msg.api.c) obj2;
        if (cVar != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u() {
        String string;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        IRuntimeService runtimeService = ((AppInterface) peekAppRuntime).getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IG\u2026va, ProcessConstant.MAIN)");
        IGPSService iGPSService = (IGPSService) runtimeService;
        AIOContact aIOContact = this.contact;
        if (aIOContact == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contact");
            aIOContact = null;
        }
        IGProChannelInfo channelInfo = iGPSService.getChannelInfo(aIOContact.j());
        if (channelInfo != null && channelInfo.getTopMsgList().size() > 1) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string2 = MobileQQ.sMobileQQ.getString(R.string.f157971oc);
            Intrinsics.checkNotNullExpressionValue(string2, "sMobileQQ.getString(R.st\u2026g.guild_top_msg_with_num)");
            string = String.format(string2, Arrays.copyOf(new Object[]{Integer.valueOf(channelInfo.getTopMsgList().size())}, 1));
            Intrinsics.checkNotNullExpressionValue(string, "format(format, *args)");
        } else {
            string = MobileQQ.sMobileQQ.getString(R.string.f157881o4);
            Intrinsics.checkNotNullExpressionValue(string, "{\n            MobileQQ.s\u2026.guild_top_msg)\n        }");
        }
        updateUI(new GuildAioTitleTextUIState.a().b(string).getState());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void v() {
        GuildMultiMsgManager.d dVar = new GuildMultiMsgManager.d(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j(), com.tencent.guild.aio.util.ex.a.d((com.tencent.aio.api.runtime.a) getMContext()));
        GuildMultiMsgManager.Companion companion = GuildMultiMsgManager.INSTANCE;
        boolean i3 = companion.a().i(dVar);
        if (i3) {
            companion.a().n(dVar, false);
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildMsgListIntent.GuildMultiSelectModeChangeEvent("GuildAioTitleViewModel", false));
        }
        updateUI(new GuildAioTitleBackBtnUIState(i3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void x() {
        Context context;
        View view = ((com.tencent.aio.api.runtime.a) getMContext()).c().getView();
        if ((view == null || (context = view.getContext()) == null) && (context = ((com.tencent.aio.api.runtime.a) getMContext()).c().getContext()) == null) {
            return;
        }
        final ActionSheet create = ActionSheet.create(context);
        if (this.isHideBtnClickable) {
            create.addButton(MobileQQ.sMobileQQ.getString(R.string.f157941o_));
        } else {
            View inflate = LayoutInflater.from(context).inflate(R.layout.action_sheet_common_button, (ViewGroup) null);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(context)\n          \u2026heet_common_button, null)");
            TextView textView = (TextView) inflate.findViewById(R.id.action_sheet_button);
            textView.setText(MobileQQ.sMobileQQ.getString(R.string.f157941o_));
            textView.setTextColor(context.getResources().getColor(R.color.qui_common_text_primary));
            inflate.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.f160041q));
            create.addView(inflate);
        }
        create.addCancelButton(R.string.cancel);
        create.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.guild.aio.chosen.title.c
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view2, int i3) {
                GuildChosenAIOTitleViewModel.y(GuildChosenAIOTitleViewModel.this, create, view2, i3);
            }
        });
        create.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void y(GuildChosenAIOTitleViewModel this$0, ActionSheet actionSheet, View view, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 0) {
            if (this$0.isHideBtnClickable) {
                FragmentActivity activity = ((com.tencent.aio.api.runtime.a) this$0.getMContext()).c().getActivity();
                if (activity != null) {
                    AIOParam g16 = ((com.tencent.aio.api.runtime.a) this$0.getMContext()).g();
                    Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
                    String g17 = com.tencent.guild.aio.util.a.g(g16);
                    AIOParam g18 = ((com.tencent.aio.api.runtime.a) this$0.getMContext()).g();
                    Intrinsics.checkNotNullExpressionValue(g18, "mContext.aioParam");
                    this$0.B(activity, g17, com.tencent.guild.aio.util.a.b(g18));
                    HashMap hashMap = new HashMap();
                    hashMap.put("dt_pgid", "pg_sgrp_sticky_post_info");
                    AIOParam g19 = ((com.tencent.aio.api.runtime.a) this$0.getMContext()).g();
                    Intrinsics.checkNotNullExpressionValue(g19, "mContext.aioParam");
                    hashMap.put("sgrp_channel_id", com.tencent.guild.aio.util.a.g(g19));
                    AIOParam g26 = ((com.tencent.aio.api.runtime.a) this$0.getMContext()).g();
                    Intrinsics.checkNotNullExpressionValue(g26, "mContext.aioParam");
                    hashMap.put("sgrp_sub_channel_id", com.tencent.guild.aio.util.a.b(g26));
                    hashMap.put("eid", "em_aio_hide_top_sticky");
                    VideoReport.reportEvent("dt_clck", hashMap);
                }
                actionSheet.dismiss();
                return;
            }
            return;
        }
        actionSheet.dismiss();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void z(c.k intent) {
        AIOContact aIOContact = this.contact;
        if (aIOContact == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contact");
            aIOContact = null;
        }
        GuildMultiMsgManager.INSTANCE.a().n(new GuildMultiMsgManager.d(aIOContact.j(), com.tencent.guild.aio.util.ex.a.d((com.tencent.aio.api.runtime.a) getMContext())), false);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildMsgListIntent.GuildMultiSelectModeChangeEvent("GuildAioDefaultTitleViewBinder", intent.getIsMultiple()));
    }

    public final void B(@NotNull Context ctx, @NotNull final String guildId, @NotNull final String channelId) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        String string = ctx.getString(R.string.f157931o9);
        Intrinsics.checkNotNullExpressionValue(string, "ctx.getString(com.tencen\u2026.guild_top_msg_hide_tips)");
        final QQCustomDialog d16 = com.tencent.mobileqq.guild.util.qqui.c.d(ctx, 0, null, string, null, null);
        Intrinsics.checkNotNullExpressionValue(d16, "createCustomDialog(ctx, \u2026, dlgContent, null, null)");
        d16.setNegativeButton(ctx.getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.tencent.guild.aio.chosen.title.d
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                GuildChosenAIOTitleViewModel.C(QQCustomDialog.this, dialogInterface, i3);
            }
        });
        d16.setPositiveButton(ctx.getString(R.string.f157921o8), new DialogInterface.OnClickListener() { // from class: com.tencent.guild.aio.chosen.title.e
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                GuildChosenAIOTitleViewModel.D(guildId, channelId, this, dialogInterface, i3);
            }
        });
        d16.show();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        AppInterface appInterface;
        super.onDestroy();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRuntimeService iRuntimeService = null;
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
            iGPSService.deleteObserver(this.mGPServiceObserver);
        }
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildMultiSelectModeChangeEvent.class).getQualifiedName(), this.mAction);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull com.tencent.guild.aio.title.c intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof c.k) {
            z((c.k) intent);
            return;
        }
        if (intent instanceof g.a) {
            x();
        } else if (intent instanceof g.b) {
            u();
        } else if (intent instanceof c.l) {
            v();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ((com.tencent.aio.api.runtime.a) getMContext()).e().d(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildMultiSelectModeChangeEvent.class).getQualifiedName(), this.mAction);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().d(Reflection.getOrCreateKotlinClass(GuildChosenMsgIntent.ChosenMsgSizeChange.class).getQualifiedName(), this.mAction);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        IGPSService iGPSService = (IGPSService) (appInterface != null ? appInterface.getRuntimeService(IGPSService.class, "") : null);
        if (iGPSService != null) {
            iGPSService.addObserver(this.mGPServiceObserver);
        }
        this.contact = context.g().r().c();
        A(GuildMultiMsgManager.INSTANCE.a().i(new GuildMultiMsgManager.d(((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j(), com.tencent.guild.aio.util.ex.a.d((com.tencent.aio.api.runtime.a) getMContext()))));
        BuildersKt__Builders_commonKt.launch$default(vmScope(), null, null, new GuildChosenAIOTitleViewModel$onCreate$1(this, null), 3, null);
    }
}
