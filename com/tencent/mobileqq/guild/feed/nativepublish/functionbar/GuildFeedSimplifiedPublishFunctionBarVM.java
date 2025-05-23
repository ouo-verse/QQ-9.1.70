package com.tencent.mobileqq.guild.feed.nativepublish.functionbar;

import android.app.Activity;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.AppInterface;
import com.tencent.guild.aio.input.at.trooptag.dialogui.bean.HashTagPageType;
import com.tencent.guild.aio.input.at.trooptag.dialogui.bean.a;
import com.tencent.guild.aio.input.at.utils.AtUserHelper;
import com.tencent.guild.aio.input.at.utils.j;
import com.tencent.guild.api.IGuildAioPopupPanelConfigApi;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.input.base.mvicompat.ex.VMMessengerProtocolSupport;
import com.tencent.input.base.mvicompat.ex.a;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.input.base.panelcontainer.h;
import com.tencent.mobileqq.guild.animate.subchannellist.GuildChannelListAnim;
import com.tencent.mobileqq.guild.base.extension.MiscKt;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedPreloadConfigAPi;
import com.tencent.mobileqq.guild.feed.nativepublish.FeedEditorConfiguration;
import com.tencent.mobileqq.guild.feed.nativepublish.content.monitor.FeedEditorRestrictionSupervisorMsgIntent;
import com.tencent.mobileqq.guild.feed.nativepublish.edittext.GuildFeedEditTextMsgIntent;
import com.tencent.mobileqq.guild.feed.nativepublish.feature.msgintent.SimplifiedFeedEditorGlobalMsgIntent;
import com.tencent.mobileqq.guild.feed.nativepublish.functionbar.GuildFeedPublishFunctionBarMsgIntent;
import com.tencent.mobileqq.guild.feed.nativepublish.functionbar.GuildFeedPublishFunctionBarMviUIState;
import com.tencent.mobileqq.guild.feed.nativepublish.functionbar.a;
import com.tencent.mobileqq.guild.feed.nativepublish.mediapreview.FeedEditorMediaMsgIntent;
import com.tencent.mobileqq.guild.feed.nativepublish.publish.msgintent.PublishFeedMsgIntent;
import com.tencent.mobileqq.guild.feed.nativepublish.utils.GuildFeedPublishUtils;
import com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate.FeedEditorAtUseCaseMsgIntent;
import com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate.c;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.k;
import com.tencent.mvi.mvvm.BaseVM;
import com.tencent.qphone.base.util.QLog;
import cp0.HashTagChannelData;
import cp0.HashTagTroopData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 F2.\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u00060\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u00072\u00020\b2\u00020\t:\u0001GB\u0007\u00a2\u0006\u0004\bD\u0010EJ\b\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\nH\u0002J\b\u0010\u0010\u001a\u00020\nH\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0015\u001a\u00020\u0011H\u0002J\b\u0010\u0016\u001a\u00020\nH\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0002J\u0012\u0010\u001b\u001a\u00020\n2\b\b\u0002\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001c\u001a\u00020\nH\u0002J\b\u0010\u001d\u001a\u00020\nH\u0002J\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00130\u001eH\u0016J\u001a\u0010!\u001a\u00020\n2\u0010\u0010 \u001a\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u0006H\u0016J\b\u0010\"\u001a\u00020\nH\u0016J\u0010\u0010$\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u0002H\u0016J\u0010\u0010'\u001a\u00020\n2\u0006\u0010&\u001a\u00020%H\u0016J\u0018\u0010+\u001a\u00020\n2\u0006\u0010)\u001a\u00020(2\u0006\u0010&\u001a\u00020*H\u0016R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00106\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0014\u0010:\u001a\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010=\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u001b\u0010A\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010>\u001a\u0004\b?\u0010@R\u0016\u0010C\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010<\u00a8\u0006H"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/functionbar/GuildFeedSimplifiedPublishFunctionBarVM;", "Lcom/tencent/mvi/mvvm/BaseVM;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/functionbar/a;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/functionbar/GuildFeedPublishFunctionBarMviUIState;", "Lcom/tencent/base/api/runtime/a;", "Lzl1/a;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/FeedEditorContext;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/EditorBaseVM;", "Landroidx/lifecycle/LifecycleEventObserver;", "Lcom/tencent/input/base/mvicompat/ex/a;", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "newFlag", "B", "r", "l", "", "t", "", "o", "u", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/guild/aio/input/at/trooptag/dialogui/bean/b;", DomainData.DOMAIN_NAME, "Lcom/tencent/guild/aio/input/at/trooptag/dialogui/bean/HashTagPageType;", "showListType", "y", ReportConstant.COSTREPORT_PREFIX, "v", "", "J2", "context", HippyTKDListViewAdapter.X, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "intent", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mvi/base/route/MsgIntent;", "event", "E", "Landroidx/lifecycle/LifecycleOwner;", "source", "Landroidx/lifecycle/Lifecycle$Event;", "onStateChanged", "Landroid/view/View;", "d", "Landroid/view/View;", "mAnchorView", "Lip0/c;", "e", "Lip0/c;", "mTroopAndChannelPanel", "f", "Z", "alreadyAddMedia", "Lcom/tencent/input/base/mvicompat/ex/VMMessengerProtocolSupport;", tl.h.F, "Lcom/tencent/input/base/mvicompat/ex/VMMessengerProtocolSupport;", "messageHandlerSupport", "i", "I", "overTextLimitCount", "Lkotlin/Lazy;", "p", "()I", "sMaxTextLimit", BdhLogUtil.LogTag.Tag_Conn, "functionEnableStateFlag", "<init>", "()V", "D", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedSimplifiedPublishFunctionBarVM extends BaseVM<a, GuildFeedPublishFunctionBarMviUIState, com.tencent.base.api.runtime.a<zl1.a>> implements LifecycleEventObserver, com.tencent.input.base.mvicompat.ex.a {

    /* renamed from: C, reason: from kotlin metadata */
    private int functionEnableStateFlag;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mAnchorView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ip0.c mTroopAndChannelPanel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean alreadyAddMedia;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final VMMessengerProtocolSupport messageHandlerSupport = new VMMessengerProtocolSupport(this);

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int overTextLimitCount;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy sMaxTextLimit;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/feed/nativepublish/functionbar/GuildFeedSimplifiedPublishFunctionBarVM$b", "Lip0/d;", "Lcp0/a;", "selectedTroopTagData", "", "c", "f", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements ip0.d {
        b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // ip0.d
        public void c(@Nullable cp0.a selectedTroopTagData) {
            HashTagChannelData hashTagChannelData;
            QLog.d("GuildFeedSimplifiedPublishFunctionBarVM", 2, "mNewHashTagPanel onPanelDismiss selectedTroopTagData " + selectedTroopTagData);
            HashTagTroopData hashTagTroopData = null;
            if (selectedTroopTagData instanceof HashTagChannelData) {
                hashTagChannelData = (HashTagChannelData) selectedTroopTagData;
            } else {
                hashTagChannelData = null;
            }
            if (hashTagChannelData != null) {
                ((com.tencent.base.api.runtime.a) GuildFeedSimplifiedPublishFunctionBarVM.this.getMContext()).e().h(new GuildFeedEditTextMsgIntent.ReplyTextByHashtag(String.valueOf(hashTagChannelData.getChannelUin()), hashTagChannelData.getChannelName(), hashTagChannelData.getChannelType(), hashTagChannelData.getAioHashViewType()));
            }
            if (selectedTroopTagData instanceof HashTagTroopData) {
                hashTagTroopData = (HashTagTroopData) selectedTroopTagData;
            }
            if (hashTagTroopData != null) {
                ((com.tencent.base.api.runtime.a) GuildFeedSimplifiedPublishFunctionBarVM.this.getMContext()).e().h(new GuildFeedEditTextMsgIntent.ReplyTextByGroupTag(MiscKt.l(hashTagTroopData.getGroupCode()), hashTagTroopData.getGroupName()));
            }
            ((com.tencent.base.api.runtime.a) GuildFeedSimplifiedPublishFunctionBarVM.this.getMContext()).e().h(new SimplifiedFeedEditorGlobalMsgIntent.OverwriteCloseIntent("GuildFeedSimplifiedPublishFunctionBarVM", null, false, 4, null));
            ((com.tencent.base.api.runtime.a) GuildFeedSimplifiedPublishFunctionBarVM.this.getMContext()).e().h(GuildFeedEditTextMsgIntent.ShowKeyboard.f221846d);
        }

        @Override // ye1.b
        public void f() {
            QLog.d("GuildFeedSimplifiedPublishFunctionBarVM", 2, "mNewHashTagPanel onPanelShow");
        }
    }

    public GuildFeedSimplifiedPublishFunctionBarVM() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.functionbar.GuildFeedSimplifiedPublishFunctionBarVM$sMaxTextLimit$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                return Integer.valueOf(((IGuildFeedPreloadConfigAPi) QRoute.api(IGuildFeedPreloadConfigAPi.class)).getFeedPublishMaxLimit());
            }
        });
        this.sMaxTextLimit = lazy;
        this.functionEnableStateFlag = 7;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void A() {
        FeedEditorConfiguration configuration = ((zl1.a) ((com.tencent.base.api.runtime.a) getMContext()).h()).getConfiguration();
        int i3 = this.functionEnableStateFlag;
        if (!configuration.getIsSupportPlus()) {
            i3 &= -3;
        }
        if (!configuration.getIsSupportLongFeedEditor()) {
            i3 &= -5;
        }
        B(i3);
    }

    private final void B(int newFlag) {
        if (newFlag != this.functionEnableStateFlag) {
            this.functionEnableStateFlag = newFlag;
            updateUI(new GuildFeedPublishFunctionBarMviUIState.FunctionButtonsVisibilityState(newFlag));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void l() {
        IGuildAioPopupPanelConfigApi iGuildAioPopupPanelConfigApi = (IGuildAioPopupPanelConfigApi) QRoute.api(IGuildAioPopupPanelConfigApi.class);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        iGuildAioPopupPanelConfigApi.fetchTroopListSwitch((AppInterface) peekAppRuntime, MiscKt.l(((zl1.a) ((com.tencent.base.api.runtime.a) getMContext()).h()).h()), new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.functionbar.GuildFeedSimplifiedPublishFunctionBarVM$checkIfEnableTroopList$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                Logger.f235387a.d().d("GuildFeedSimplifiedPublishFunctionBarVM", 1, "[checkIfEnableTroopList] enableTroopList " + z16);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void m() {
        ArrayList arrayListOf;
        String o16 = o();
        Logger logger = Logger.f235387a;
        logger.d().d("GuildFeedSimplifiedPublishFunctionBarVM", 1, "[createTroopAndChannelPanel] guildId " + o16 + ", mContext.baseParam: " + ((com.tencent.base.api.runtime.a) getMContext()).h());
        ip0.c cVar = this.mTroopAndChannelPanel;
        if (cVar != null) {
            cVar.destroy();
        }
        HashTagPageType hashTagPageType = HashTagPageType.Troop_Page;
        HashTagPageType hashTagPageType2 = HashTagPageType.Channel_Page;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(hashTagPageType, hashTagPageType2);
        if (!t()) {
            arrayListOf.remove(hashTagPageType2);
        }
        if (!u()) {
            arrayListOf.remove(hashTagPageType);
        }
        logger.d().d("GuildFeedSimplifiedPublishFunctionBarVM", 1, "[initTroopAndChannelPanel] defaultPageList " + arrayListOf);
        if (arrayListOf.isEmpty()) {
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        Activity f16 = ((com.tencent.base.api.runtime.a) getMContext()).f();
        Intrinsics.checkNotNullExpressionValue(f16, "mContext.activity");
        ip0.c cVar2 = (ip0.c) j.a(new a.C1192a((AppInterface) peekAppRuntime, f16, o16, "", 7).d(1).c(arrayListOf).b(n()).a());
        this.mTroopAndChannelPanel = cVar2;
        if (cVar2 != null) {
            cVar2.k(new b());
        }
    }

    private final com.tencent.guild.aio.input.at.trooptag.dialogui.bean.b n() {
        return new c();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final String o() {
        return ((zl1.a) ((com.tencent.base.api.runtime.a) getMContext()).h()).h();
    }

    private final int p() {
        return ((Number) this.sMaxTextLimit.getValue()).intValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void r() {
        h.a aVar;
        k k3 = ((com.tencent.base.api.runtime.a) getMContext()).e().k(PanelContainerMsgIntent.GetPanelContainerStateMsgIntent.f116805d);
        if (k3 instanceof h.a) {
            aVar = (h.a) k3;
        } else {
            aVar = null;
        }
        if (aVar == null) {
            return;
        }
        Integer a16 = aVar.a();
        if (a16 != null && a16.intValue() == 1) {
            ((com.tencent.base.api.runtime.a) getMContext()).e().h(GuildFeedEditTextMsgIntent.ShowKeyboard.f221846d);
        } else {
            ((com.tencent.base.api.runtime.a) getMContext()).e().h(new PanelContainerMsgIntent.ShowPanelMsgIntent("GuildFeedSimplifiedPublishFunctionBarVM", 1, false, 0, 12, null));
        }
    }

    private final void s() {
        v();
    }

    private final boolean t() {
        boolean isBlank;
        String o16 = o();
        isBlank = StringsKt__StringsJVMKt.isBlank(o16);
        if ((!isBlank) && !Intrinsics.areEqual(o16, "0")) {
            return true;
        }
        return false;
    }

    private final boolean u() {
        return ((IGuildAioPopupPanelConfigApi) QRoute.api(IGuildAioPopupPanelConfigApi.class)).isEnableTroopList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void v() {
        int i3;
        int i16;
        final FragmentActivity activity = ((com.tencent.base.api.runtime.a) getMContext()).c().getActivity();
        if (activity != null && !activity.isFinishing()) {
            zl1.a param = (zl1.a) ((com.tencent.base.api.runtime.a) getMContext()).h();
            yl1.i iVar = yl1.i.f450608a;
            Intrinsics.checkNotNullExpressionValue(param, "param");
            if (iVar.k(zl1.b.l(param))) {
                i3 = 14;
            } else {
                i3 = 15;
            }
            Object h16 = ((com.tencent.base.api.runtime.a) getMContext()).h();
            Intrinsics.checkNotNullExpressionValue(h16, "mContext.baseParam");
            int c16 = zl1.b.c((zl1.a) h16);
            if (c16 != 7 && c16 != 9) {
                i16 = i3;
            } else {
                i16 = c16;
            }
            GuildFeedPublishUtils guildFeedPublishUtils = GuildFeedPublishUtils.f222315a;
            guildFeedPublishUtils.E(activity, param.h(), param.a(), "", i16, guildFeedPublishUtils.s(param), (JumpGuildParam.JoinInfoParam) param.getExtra().getParcelable(JumpGuildParam.KEY_JOIN_INFO_PARAM), new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.functionbar.i
                @Override // java.lang.Runnable
                public final void run() {
                    GuildFeedSimplifiedPublishFunctionBarVM.w(FragmentActivity.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(FragmentActivity fragmentActivity) {
        fragmentActivity.finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void y(HashTagPageType showListType) {
        c.a aVar;
        Logger.f235387a.d().d("GuildFeedSimplifiedPublishFunctionBarVM", 1, "[openPlustag] showListType " + showListType + ", ");
        Object h16 = ((com.tencent.base.api.runtime.a) getMContext()).h();
        Intrinsics.checkNotNullExpressionValue(h16, "mContext.baseParam");
        if (zl1.b.o((zl1.a) h16)) {
            return;
        }
        if (this.mTroopAndChannelPanel == null) {
            m();
        }
        if (this.mTroopAndChannelPanel == null) {
            QLog.i("GuildFeedSimplifiedPublishFunctionBarVM", 1, "[openPlustag]: createTroopAndChannelPanel but it's still null, mainTaskId=" + com.tencent.mobileqq.guild.feed.nativepublish.utils.a.a((com.tencent.base.api.runtime.a) getMContext()) + ", contact=" + ((zl1.a) ((com.tencent.base.api.runtime.a) getMContext()).h()).getContact());
        }
        ((com.tencent.base.api.runtime.a) getMContext()).e().h(new SimplifiedFeedEditorGlobalMsgIntent.HideAllPanelAndKeyboard("GuildFeedSimplifiedPublishFunctionBarVM"));
        if (this.mAnchorView == null) {
            k k3 = ((com.tencent.base.api.runtime.a) getMContext()).e().k(FeedEditorAtUseCaseMsgIntent.GetAnchorView.f222388d);
            View view = null;
            if (k3 instanceof c.a) {
                aVar = (c.a) k3;
            } else {
                aVar = null;
            }
            if (aVar != null) {
                view = aVar.getAnchorView();
            }
            this.mAnchorView = view;
        }
        QLog.i("GuildFeedSimplifiedPublishFunctionBarVM", 1, "[openPlustag]: mAnchorView:" + this.mAnchorView);
        ip0.c cVar = this.mTroopAndChannelPanel;
        if (cVar != null) {
            cVar.g(this.mAnchorView, showListType);
        }
    }

    static /* synthetic */ void z(GuildFeedSimplifiedPublishFunctionBarVM guildFeedSimplifiedPublishFunctionBarVM, HashTagPageType hashTagPageType, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            hashTagPageType = HashTagPageType.Troop_Page;
        }
        guildFeedSimplifiedPublishFunctionBarVM.y(hashTagPageType);
    }

    @Override // com.tencent.input.base.mvicompat.ex.a
    public void E(@NotNull MsgIntent event) {
        int coerceAtLeast;
        Intrinsics.checkNotNullParameter(event, "event");
        boolean z16 = false;
        if (event instanceof PanelContainerMsgIntent.OnPanelStateChangedMsgIntent) {
            PanelContainerMsgIntent.OnPanelStateChangedMsgIntent onPanelStateChangedMsgIntent = (PanelContainerMsgIntent.OnPanelStateChangedMsgIntent) event;
            if (onPanelStateChangedMsgIntent.b() && onPanelStateChangedMsgIntent.a() == 1) {
                z16 = true;
            }
            updateUI(new GuildFeedPublishFunctionBarMviUIState.UpdateEmojiButton(z16));
            return;
        }
        if (event instanceof GuildFeedPublishFunctionBarMsgIntent.OpenPlusTag) {
            y(((GuildFeedPublishFunctionBarMsgIntent.OpenPlusTag) event).getShowListType());
            return;
        }
        if (event instanceof GuildFeedEditTextMsgIntent.OnTextChanged) {
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(((GuildFeedEditTextMsgIntent.OnTextChanged) event).getLength() - p(), 0);
            if (this.overTextLimitCount != coerceAtLeast) {
                this.overTextLimitCount = coerceAtLeast;
                updateUI(new GuildFeedPublishFunctionBarMviUIState.UpdateTextCountOverLimit(coerceAtLeast));
                return;
            }
            return;
        }
        if (event instanceof GuildFeedPublishFunctionBarMviUIState.FunctionBarVisibility) {
            updateUI((MviUIState) event);
        } else if (event instanceof FeedEditorRestrictionSupervisorMsgIntent.ContentStatisticChangeMsgIntent) {
            updateUI(new GuildFeedPublishFunctionBarMviUIState.UpdatePublishBtnEnable(((FeedEditorRestrictionSupervisorMsgIntent.ContentStatisticChangeMsgIntent) event).getSupervisorAttachInfo().getHasSomethingToSave()));
        }
    }

    @Override // com.tencent.input.base.mvicompat.ex.a
    @NotNull
    public k I(@NotNull MsgIntent msgIntent) {
        return a.C5857a.d(this, msgIntent);
    }

    @Override // com.tencent.input.base.mvicompat.ex.a
    @NotNull
    public List<String> J2() {
        List<String> listOf;
        String b16 = com.tencent.mvi.base.route.c.b(GuildFeedEditTextMsgIntent.OnTextChanged.class);
        Intrinsics.checkNotNullExpressionValue(b16, "get(java)");
        String b17 = com.tencent.mvi.base.route.c.b(GuildFeedPublishFunctionBarMsgIntent.OpenPlusTag.class);
        Intrinsics.checkNotNullExpressionValue(b17, "get(java)");
        String b18 = com.tencent.mvi.base.route.c.b(PanelContainerMsgIntent.OnPanelStateChangedMsgIntent.class);
        Intrinsics.checkNotNullExpressionValue(b18, "get(java)");
        String b19 = com.tencent.mvi.base.route.c.b(FeedEditorRestrictionSupervisorMsgIntent.ContentStatisticChangeMsgIntent.class);
        Intrinsics.checkNotNullExpressionValue(b19, "get(java)");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{b16, b17, b18, b19});
        return listOf;
    }

    @Override // com.tencent.input.base.mvicompat.ex.a
    @Nullable
    public List<String> f0() {
        return a.C5857a.b(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        super.onDestroy();
        VMMessengerProtocolSupport vMMessengerProtocolSupport = this.messageHandlerSupport;
        com.tencent.mvi.base.route.j e16 = ((com.tencent.base.api.runtime.a) getMContext()).e();
        Intrinsics.checkNotNullExpressionValue(e16, "mContext.messenger");
        vMMessengerProtocolSupport.e(e16);
        ((com.tencent.base.api.runtime.a) getMContext()).d().getLifecycle().removeObserver(this);
        ip0.c cVar = this.mTroopAndChannelPanel;
        if (cVar != null) {
            cVar.destroy();
        }
        AtUserHelper.b();
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NotNull LifecycleOwner source, @NotNull Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event == Lifecycle.Event.ON_RESUME) {
            QLog.i("GuildFeedSimplifiedPublishFunctionBarVM", 1, "onStateChanged ON_RESUME alreadyAddMedia=" + this.alreadyAddMedia);
            if (!this.alreadyAddMedia) {
                updateUI(new GuildFeedPublishFunctionBarMviUIState.InitBliVideoInsertGuide());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull a intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof a.d) {
            r();
            return;
        }
        if (intent instanceof a.e) {
            z(this, null, 1, null);
            return;
        }
        if (intent instanceof a.g) {
            s();
            return;
        }
        if (intent instanceof a.b) {
            ((com.tencent.base.api.runtime.a) getMContext()).e().h(new GuildFeedEditTextMsgIntent.OnTouchEvent());
        } else if (intent instanceof a.h) {
            ((com.tencent.base.api.runtime.a) getMContext()).e().h(PublishFeedMsgIntent.TriggerPublish.f222235d);
        } else if (intent instanceof a.c) {
            ((com.tencent.base.api.runtime.a) getMContext()).e().h(FeedEditorMediaMsgIntent.OpenAlbum.f222124d);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public void onCreate(@NotNull com.tencent.base.api.runtime.a<zl1.a> context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate((GuildFeedSimplifiedPublishFunctionBarVM) context);
        VMMessengerProtocolSupport vMMessengerProtocolSupport = this.messageHandlerSupport;
        com.tencent.mvi.base.route.j e16 = context.e();
        Intrinsics.checkNotNullExpressionValue(e16, "context.messenger");
        vMMessengerProtocolSupport.d(e16);
        ((com.tencent.base.api.runtime.a) getMContext()).d().getLifecycle().addObserver(this);
        l();
        A();
        AtUserHelper.h(((zl1.a) ((com.tencent.base.api.runtime.a) getMContext()).h()).h(), ((zl1.a) ((com.tencent.base.api.runtime.a) getMContext()).h()).a());
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/guild/feed/nativepublish/functionbar/GuildFeedSimplifiedPublishFunctionBarVM$c", "Lcom/tencent/guild/aio/input/at/trooptag/dialogui/bean/b;", "Landroidx/recyclerview/widget/RecyclerView$ItemAnimator;", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements com.tencent.guild.aio.input.at.trooptag.dialogui.bean.b {
        c() {
        }

        @Override // com.tencent.guild.aio.input.at.trooptag.dialogui.bean.b
        @Nullable
        public RecyclerView.ItemAnimator a() {
            return new GuildChannelListAnim(new a(), 3);
        }

        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/feed/nativepublish/functionbar/GuildFeedSimplifiedPublishFunctionBarVM$c$a", "Lcom/tencent/mobileqq/guild/animate/subchannellist/GuildChannelListAnim$h;", "", "c", "b", "a", "onAnimEnd", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes13.dex */
        public static final class a implements GuildChannelListAnim.h {
            a() {
            }

            @Override // com.tencent.mobileqq.guild.animate.subchannellist.GuildChannelListAnim.h
            public void a() {
            }

            @Override // com.tencent.mobileqq.guild.animate.subchannellist.GuildChannelListAnim.h
            public void b() {
            }

            @Override // com.tencent.mobileqq.guild.animate.subchannellist.GuildChannelListAnim.h
            public void c() {
            }

            @Override // com.tencent.mobileqq.guild.animate.subchannellist.GuildChannelListAnim.h
            public void onAnimEnd() {
            }
        }
    }
}
