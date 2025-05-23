package com.tencent.mobileqq.guild.feed.nativepublish.functionbar;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.AppInterface;
import com.tencent.frame.panelcontainer.PanelContainerMsgIntent;
import com.tencent.frame.panelcontainer.f;
import com.tencent.guild.aio.input.at.trooptag.dialogui.bean.HashTagPageType;
import com.tencent.guild.aio.input.at.trooptag.dialogui.bean.a;
import com.tencent.guild.aio.input.at.utils.j;
import com.tencent.guild.api.IGuildAioPopupPanelConfigApi;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.input.base.mvicompat.ex.VMMessengerProtocolSupport;
import com.tencent.input.base.mvicompat.ex.a;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.animate.subchannellist.GuildChannelListAnim;
import com.tencent.mobileqq.guild.base.extension.MiscKt;
import com.tencent.mobileqq.guild.feed.nativepublish.content.monitor.FeedEditorRestrictionSupervisorMsgIntent;
import com.tencent.mobileqq.guild.feed.nativepublish.content.monitor.FeedEditorRestrictionSupervisorVMDelegate;
import com.tencent.mobileqq.guild.feed.nativepublish.edittext.GuildFeedEditTextMsgIntent;
import com.tencent.mobileqq.guild.feed.nativepublish.functionbar.GuildFeedPublishFunctionBarMsgIntent;
import com.tencent.mobileqq.guild.feed.nativepublish.functionbar.GuildFeedPublishFunctionBarMviUIState;
import com.tencent.mobileqq.guild.feed.nativepublish.functionbar.a;
import com.tencent.mobileqq.guild.feed.nativepublish.guildselector.GuildFeedPublishGuildSelectorMsgIntent;
import com.tencent.mobileqq.guild.feed.nativepublish.mediapreview.FeedEditorMediaMsgIntent;
import com.tencent.mobileqq.guild.feed.nativepublish.root.msgintent.FeedEditorRootMsgIntent;
import com.tencent.mobileqq.guild.feed.nativepublish.utils.GuildFeedPublishUtils;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.window.s;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.k;
import com.tencent.mvi.mvvm.BaseVM;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import cp0.HashTagChannelData;
import cp0.HashTagTroopData;
import java.util.ArrayList;
import java.util.List;
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

@Metadata(d1 = {"\u0000\u00de\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0018\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 u2.\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u00060\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u00072\u00020\b2\u00020\t:\u0001vJ\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\u001a\u0010\u000f\u001a\u00020\u000e2\u0010\u0010\r\u001a\f\u0012\u0004\u0012\u00020\u00050\u0004j\u0002`\u0006H\u0016J\b\u0010\u0010\u001a\u00020\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0002H\u0016J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0013H\u0016J\u0018\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0010\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u0010\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u001dH\u0002J\u0010\u0010 \u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u000bH\u0002J\u0010\u0010!\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u000bH\u0002J\u0010\u0010$\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\"H\u0002J\b\u0010%\u001a\u00020\u000eH\u0002J\u0010\u0010(\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020&H\u0002J\b\u0010)\u001a\u00020\u000eH\u0002J\u0010\u0010+\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020\u000bH\u0002J\b\u0010,\u001a\u00020\u000eH\u0002J\u0010\u0010.\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020-H\u0002J\u0010\u00101\u001a\u00020\u000e2\u0006\u00100\u001a\u00020/H\u0002J\u0010\u00103\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u000202H\u0002J\b\u00104\u001a\u00020\u000eH\u0002J\b\u00105\u001a\u00020\u000bH\u0002J\b\u00107\u001a\u000206H\u0002J\b\u00108\u001a\u000206H\u0002J\b\u0010:\u001a\u000209H\u0002J\b\u0010;\u001a\u00020\u000eH\u0002J\b\u0010=\u001a\u00020<H\u0002J\u0012\u0010?\u001a\u00020\u000e2\b\u0010>\u001a\u0004\u0018\u00010\"H\u0002J$\u0010C\u001a\u00020\u000e2\b\u0010>\u001a\u0004\u0018\u00010\"2\u0006\u0010@\u001a\u0002062\b\b\u0002\u0010B\u001a\u00020AH\u0002J\u001a\u0010D\u001a\u00020\u000e2\b\u0010>\u001a\u0004\u0018\u00010\"2\u0006\u0010@\u001a\u000206H\u0002J\b\u0010E\u001a\u00020\u000eH\u0002J\b\u0010F\u001a\u00020\u000eH\u0002J\b\u0010G\u001a\u00020\u000bH\u0002J\u0018\u0010J\u001a\u00020\u000e2\u0006\u0010H\u001a\u0002062\u0006\u0010I\u001a\u000209H\u0002J\u0010\u0010L\u001a\u00020\u000e2\u0006\u0010K\u001a\u000209H\u0002R\u0018\u0010O\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010S\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0018\u0010W\u001a\u0004\u0018\u00010T8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0018\u0010[\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u0018\u0010_\u001a\u0004\u0018\u00010\\8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010b\u001a\u0002068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010c\u001a\u0002068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010aR\u0016\u0010d\u001a\u0002068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010aR\u0016\u0010e\u001a\u0002068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010aR\u0018\u0010h\u001a\u0004\u0018\u00010f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010gR\u0014\u0010k\u001a\u00020i8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bE\u0010jR\u0016\u0010m\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010lR\u0016\u0010p\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bn\u0010oR\u0014\u0010t\u001a\u00020q8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\br\u0010s\u00a8\u0006w"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/functionbar/GuildFeedPublishFunctionBarVM;", "Lcom/tencent/mvi/mvvm/BaseVM;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/functionbar/a;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/functionbar/GuildFeedPublishFunctionBarMviUIState;", "Lcom/tencent/base/api/runtime/a;", "Lzl1/a;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/FeedEditorContext;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/EditorBaseVM;", "Landroidx/lifecycle/LifecycleEventObserver;", "Lcom/tencent/input/base/mvicompat/ex/a;", "", "", "J2", "context", "", ExifInterface.LATITUDE_SOUTH, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "intent", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/mvi/base/route/MsgIntent;", "E", "Landroidx/lifecycle/LifecycleOwner;", "source", "Landroidx/lifecycle/Lifecycle$Event;", "event", "onStateChanged", "Lcom/tencent/mobileqq/guild/feed/nativepublish/functionbar/GuildFeedPublishFunctionBarMviUIState$FunctionButtonsVisibilityState;", "newState", "e0", "Lcom/tencent/mobileqq/guild/feed/nativepublish/functionbar/a$f;", BdhLogUtil.LogTag.Tag_Conn, "url", "H", "a0", "Landroid/view/View;", HippyNestedScrollComponent.PRIORITY_PARENT, "P", "D", "Lcom/tencent/mobileqq/guild/feed/nativepublish/functionbar/GuildFeedPublishFunctionBarMviUIState$ReplayPartSelect;", "state", "b0", "y", "guildId", "d0", "c0", "Lcom/tencent/mobileqq/guild/feed/nativepublish/mediapreview/FeedEditorMediaMsgIntent$OnMediaChanged;", UserInfo.SEX_FEMALE, "Lnk1/a;", "selected", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/frame/panelcontainer/PanelContainerMsgIntent$OnKeyboardStatusChanged;", "L", "O", "v", "", "M", "N", "", "u", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/guild/aio/input/at/trooptag/dialogui/bean/b;", "t", "anchorView", "U", UIJsPlugin.EVENT_SHOW_TOAST, "Lcom/tencent/guild/aio/input/at/trooptag/dialogui/bean/HashTagPageType;", "showListType", "X", "T", "G", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "w", "isShowKeyboard", "curKeyboardHeight", "B", "curPanelHeight", HippyTKDListViewAdapter.X, "d", "Landroid/view/View;", "mAnchorView", "Lze1/b;", "e", "Lze1/b;", "mAtPanel", "Lcom/tencent/mobileqq/guild/window/s;", "f", "Lcom/tencent/mobileqq/guild/window/s;", "mSoftKeyboardStateHelper", "Lip0/c;", tl.h.F, "Lip0/c;", "mTroopAndChannelPanel", "Lcom/tencent/mobileqq/guild/feed/partpanel/ui/b;", "i", "Lcom/tencent/mobileqq/guild/feed/partpanel/ui/b;", "partManager", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "alreadyInitVideoInsertGuide", "alreadyAddMedia", "alreadyInsertedUrl", "alreadyInsertedThirdShare", "Lbn1/c;", "Lbn1/c;", "curSelectedPart", "", "[Z", "conditionForAt", "Lcom/tencent/mobileqq/guild/feed/nativepublish/functionbar/GuildFeedPublishFunctionBarMviUIState$ReplayPartSelect;", "replayPartState", "I", "Lcom/tencent/mobileqq/guild/feed/nativepublish/functionbar/GuildFeedPublishFunctionBarMviUIState$FunctionButtonsVisibilityState;", "functionEnableState", "Lcom/tencent/input/base/mvicompat/ex/VMMessengerProtocolSupport;", "J", "Lcom/tencent/input/base/mvicompat/ex/VMMessengerProtocolSupport;", "messageHandlerSupport", "K", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedPublishFunctionBarVM extends BaseVM<a, GuildFeedPublishFunctionBarMviUIState, com.tencent.base.api.runtime.a<zl1.a>> implements LifecycleEventObserver, com.tencent.input.base.mvicompat.ex.a {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean alreadyAddMedia;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean alreadyInsertedUrl;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean alreadyInsertedThirdShare;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private bn1.c curSelectedPart;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final boolean[] conditionForAt;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private GuildFeedPublishFunctionBarMviUIState.ReplayPartSelect replayPartState;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private GuildFeedPublishFunctionBarMviUIState.FunctionButtonsVisibilityState functionEnableState;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final VMMessengerProtocolSupport messageHandlerSupport;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mAnchorView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ze1.b mAtPanel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private s mSoftKeyboardStateHelper;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ip0.c mTroopAndChannelPanel;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.guild.feed.partpanel.ui.b partManager;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean alreadyInitVideoInsertGuide;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/feed/nativepublish/functionbar/GuildFeedPublishFunctionBarVM$b", "Lip0/d;", "Lcp0/a;", "selectedTroopTagData", "", "c", "f", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements ip0.d {
        b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // ip0.d
        public void c(@Nullable cp0.a selectedTroopTagData) {
            HashTagChannelData hashTagChannelData;
            QLog.d("GuildFeedPublishFunctionBarVM", 2, "mNewHashTagPanel onPanelDismiss selectedTroopTagData " + selectedTroopTagData);
            HashTagTroopData hashTagTroopData = null;
            if (selectedTroopTagData instanceof HashTagChannelData) {
                hashTagChannelData = (HashTagChannelData) selectedTroopTagData;
            } else {
                hashTagChannelData = null;
            }
            if (hashTagChannelData != null) {
                ((com.tencent.base.api.runtime.a) GuildFeedPublishFunctionBarVM.this.getMContext()).e().h(new GuildFeedEditTextMsgIntent.ReplyTextByHashtag(String.valueOf(hashTagChannelData.getChannelUin()), hashTagChannelData.getChannelName(), hashTagChannelData.getChannelType(), hashTagChannelData.getAioHashViewType()));
            }
            if (selectedTroopTagData instanceof HashTagTroopData) {
                hashTagTroopData = (HashTagTroopData) selectedTroopTagData;
            }
            if (hashTagTroopData != null) {
                ((com.tencent.base.api.runtime.a) GuildFeedPublishFunctionBarVM.this.getMContext()).e().h(new GuildFeedEditTextMsgIntent.ReplyTextByGroupTag(MiscKt.l(hashTagTroopData.getGroupCode()), hashTagTroopData.getGroupName()));
            }
            ((com.tencent.base.api.runtime.a) GuildFeedPublishFunctionBarVM.this.getMContext()).e().h(GuildFeedEditTextMsgIntent.ShowKeyboard.f221846d);
        }

        @Override // ye1.b
        public void f() {
            QLog.d("GuildFeedPublishFunctionBarVM", 2, "mNewHashTagPanel onPanelShow");
        }
    }

    @Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J0\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J&\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u000fH\u0016\u00a8\u0006\u0012"}, d2 = {"com/tencent/mobileqq/guild/feed/nativepublish/functionbar/GuildFeedPublishFunctionBarVM$d", "Lye1/c;", "", "select", "", "guildId", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProUserInfo;", "member", "", "selectCount", "triggerType", "", "e", "isFinishSelection", "dismissFlag", "", "selectedMembers", "d", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class d extends ye1.c {
        d() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // ye1.a
        public void d(boolean isFinishSelection, int dismissFlag, @NotNull List<? extends IGProUserInfo> selectedMembers) {
            Intrinsics.checkNotNullParameter(selectedMembers, "selectedMembers");
            QLog.d("GuildFeedPublishFunctionBarVM", 2, "members=" + selectedMembers);
            if (!selectedMembers.isEmpty()) {
                ((com.tencent.base.api.runtime.a) GuildFeedPublishFunctionBarVM.this.getMContext()).e().h(new GuildFeedEditTextMsgIntent.ReplyTextByAt(selectedMembers));
            } else {
                ((com.tencent.base.api.runtime.a) GuildFeedPublishFunctionBarVM.this.getMContext()).e().h(GuildFeedEditTextMsgIntent.ShowKeyboard.f221846d);
            }
        }

        @Override // ye1.a
        public void e(boolean select, @NotNull String guildId, @NotNull IGProUserInfo member, int selectCount, int triggerType) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(member, "member");
            if (GuildFeedPublishFunctionBarVM.this.mAtPanel != null) {
                ze1.b bVar = GuildFeedPublishFunctionBarVM.this.mAtPanel;
                Intrinsics.checkNotNull(bVar);
                if (!bVar.h()) {
                    ze1.b bVar2 = GuildFeedPublishFunctionBarVM.this.mAtPanel;
                    Intrinsics.checkNotNull(bVar2);
                    bVar2.dismiss();
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void B(boolean isShowKeyboard, int curKeyboardHeight) {
        int coerceAtLeast;
        k k3 = ((com.tencent.base.api.runtime.a) getMContext()).e().k(new PanelContainerMsgIntent.GetPanelStatus());
        Intrinsics.checkNotNull(k3, "null cannot be cast to non-null type com.tencent.frame.panelcontainer.PanelContainerMsgResult.GetPanelStatusMsgResult");
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(((f.c) k3).a(), curKeyboardHeight);
        updateUI(new GuildFeedPublishFunctionBarMviUIState.SetMarginBottom(coerceAtLeast));
        updateUI(new GuildFeedPublishFunctionBarMviUIState.UpdateEmojiButton(!isShowKeyboard));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void C(a.f intent) {
        if (intent.getFromInsertEntranceClick()) {
            if (!this.alreadyAddMedia && !this.alreadyInsertedThirdShare) {
                intent.getInputContent();
                throw null;
            }
            String string = ((com.tencent.base.api.runtime.a) getMContext()).f().getString(R.string.f158191oy);
            Intrinsics.checkNotNullExpressionValue(string, "mContext.activity.getStr\u2026d_video_entry_click_tips)");
            QQToast.makeText(((com.tencent.base.api.runtime.a) getMContext()).f(), string, 0).show();
            return;
        }
        H(intent.getInputContent());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void D() {
        k k3 = ((com.tencent.base.api.runtime.a) getMContext()).e().k(new PanelContainerMsgIntent.GetPanelStatus());
        Intrinsics.checkNotNull(k3, "null cannot be cast to non-null type com.tencent.frame.panelcontainer.PanelContainerMsgResult.GetPanelStatusMsgResult");
        if (((f.c) k3).b() == 1) {
            ((com.tencent.base.api.runtime.a) getMContext()).e().h(GuildFeedEditTextMsgIntent.ShowKeyboard.f221846d);
            updateUI(new GuildFeedPublishFunctionBarMviUIState.UpdateEmojiButton(false));
        } else {
            ((com.tencent.base.api.runtime.a) getMContext()).e().h(new PanelContainerMsgIntent.ShowPanel(1, false, 2, null));
            updateUI(new GuildFeedPublishFunctionBarMviUIState.UpdateEmojiButton(true));
        }
    }

    private final void F(FeedEditorMediaMsgIntent.OnMediaChanged intent) {
        boolean z16 = true;
        QLog.i("GuildFeedPublishFunctionBarVM", 1, "handlePublishMediaChange size=" + intent.getMediaCount() + ", isThirdPlatformMedia=" + intent.getThirdPlatform());
        if (intent.getThirdPlatform()) {
            if (intent.getMediaCount() <= 0) {
                z16 = false;
            }
            this.alreadyInsertedUrl = z16;
            this.alreadyAddMedia = false;
        } else {
            if (intent.getMediaCount() <= 0) {
                z16 = false;
            }
            this.alreadyAddMedia = z16;
            this.alreadyInsertedUrl = false;
        }
        this.alreadyInsertedThirdShare = intent.getThirdShare();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void G() {
        FeedEditorRestrictionSupervisorVMDelegate.b bVar;
        boolean z16;
        k k3 = ((com.tencent.base.api.runtime.a) getMContext()).e().k(FeedEditorRestrictionSupervisorMsgIntent.FetchContentStatisticMsgIntent.f221805d);
        if (k3 instanceof FeedEditorRestrictionSupervisorVMDelegate.b) {
            bVar = (FeedEditorRestrictionSupervisorVMDelegate.b) k3;
        } else {
            bVar = null;
        }
        if (bVar != null) {
            z16 = bVar.getHasSomethingToSave();
        } else {
            z16 = false;
        }
        QLog.d("GuildFeedPublishFunctionBarVM", 1, "[handleSwitchToH5Publisher]. hasContent: " + z16);
        if (z16) {
            if (!GuildFeedPublishUtils.f222315a.C((com.tencent.base.api.runtime.a) getMContext(), true, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.functionbar.GuildFeedPublishFunctionBarVM$handleSwitchToH5Publisher$showResult$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    GuildFeedPublishFunctionBarVM.this.Q();
                }
            })) {
                Q();
                return;
            }
            return;
        }
        Q();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void H(final String url) {
        if (this.alreadyInsertedUrl) {
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(((com.tencent.base.api.runtime.a) getMContext()).f(), 230, (String) null, ((com.tencent.base.api.runtime.a) getMContext()).f().getString(R.string.f157661ni), ((com.tencent.base.api.runtime.a) getMContext()).f().getString(R.string.cancel), ((com.tencent.base.api.runtime.a) getMContext()).f().getString(R.string.h1a), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.functionbar.d
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    GuildFeedPublishFunctionBarVM.J(GuildFeedPublishFunctionBarVM.this, url, dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.functionbar.e
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    GuildFeedPublishFunctionBarVM.K(dialogInterface, i3);
                }
            });
            Intrinsics.checkNotNullExpressionValue(createCustomDialog, "createCustomDialog(\n    \u2026) }\n                    )");
            createCustomDialog.show();
            return;
        }
        a0(url);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(GuildFeedPublishFunctionBarVM this$0, String url, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(url, "$url");
        dialogInterface.dismiss();
        this$0.a0(url);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(DialogInterface dialogInterface, int i3) {
        dialogInterface.dismiss();
    }

    private final void L(PanelContainerMsgIntent.OnKeyboardStatusChanged intent) {
        QLog.i("GuildFeedPublishFunctionBarVM", 4, "handleVideoInsertGuide isShowKeyboard=" + intent.b() + " alreadyInitGuide=" + this.alreadyInitVideoInsertGuide);
        if (intent.b() && intent.a() > 0 && !this.alreadyInitVideoInsertGuide) {
            updateUI(new GuildFeedPublishFunctionBarMviUIState.InitBliVideoInsertGuide());
            this.alreadyInitVideoInsertGuide = true;
        } else {
            updateUI(new GuildFeedPublishFunctionBarMviUIState.HideVideoInsertGuide());
            this.alreadyInitVideoInsertGuide = false;
        }
    }

    private final boolean M() {
        boolean isBlank;
        String v3 = v();
        isBlank = StringsKt__StringsJVMKt.isBlank(v3);
        if ((!isBlank) && !Intrinsics.areEqual(v3, "0")) {
            return true;
        }
        return false;
    }

    private final boolean N() {
        return ((IGuildAioPopupPanelConfigApi) QRoute.api(IGuildAioPopupPanelConfigApi.class)).isEnableTroopList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void O() {
        String h16 = ((zl1.a) ((com.tencent.base.api.runtime.a) getMContext()).h()).h();
        String a16 = ((zl1.a) ((com.tencent.base.api.runtime.a) getMContext()).h()).a();
        Activity f16 = ((com.tencent.base.api.runtime.a) getMContext()).f();
        Context context = ((com.tencent.base.api.runtime.a) getMContext()).c().getContext();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        ze1.b bVar = (ze1.b) j.a(new xe1.b(h16, a16, 7, f16, context, (AppInterface) peekAppRuntime, 1, xe1.b.h("pg_sgrp_forum_short_editor", "")));
        this.mAtPanel = bVar;
        if (bVar != null) {
            bVar.k(new d());
        }
    }

    private final void P(View parent) {
        s sVar = new s(parent);
        this.mSoftKeyboardStateHelper = sVar;
        sVar.g(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void Q() {
        int i3;
        int i16;
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
        Activity f16 = ((com.tencent.base.api.runtime.a) getMContext()).f();
        Intrinsics.checkNotNullExpressionValue(f16, "mContext.activity");
        guildFeedPublishUtils.E(f16, param.h(), param.a(), w(), i16, guildFeedPublishUtils.s(param), (JumpGuildParam.JoinInfoParam) param.getExtra().getParcelable(JumpGuildParam.KEY_JOIN_INFO_PARAM), new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.functionbar.f
            @Override // java.lang.Runnable
            public final void run() {
                GuildFeedPublishFunctionBarVM.R(GuildFeedPublishFunctionBarVM.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void R(GuildFeedPublishFunctionBarVM this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((com.tencent.base.api.runtime.a) this$0.getMContext()).f().finish();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void T(View anchorView, boolean showToast) {
        boolean z16;
        boolean[] zArr = this.conditionForAt;
        int length = zArr.length;
        int i3 = 0;
        while (true) {
            if (i3 < length) {
                if (!zArr[i3]) {
                    z16 = false;
                    break;
                }
                i3++;
            } else {
                z16 = true;
                break;
            }
        }
        if (!z16) {
            return;
        }
        Object h16 = ((com.tencent.base.api.runtime.a) getMContext()).h();
        Intrinsics.checkNotNullExpressionValue(h16, "mContext.baseParam");
        if (zl1.b.j((zl1.a) h16)) {
            if (showToast) {
                QQToast.makeText(((com.tencent.base.api.runtime.a) getMContext()).f(), ((com.tencent.base.api.runtime.a) getMContext()).f().getString(R.string.f145000qa), 0).show();
                return;
            }
            return;
        }
        Object h17 = ((com.tencent.base.api.runtime.a) getMContext()).h();
        Intrinsics.checkNotNullExpressionValue(h17, "mContext.baseParam");
        if (zl1.b.c((zl1.a) h17) == 7) {
            return;
        }
        ((com.tencent.base.api.runtime.a) getMContext()).e().h(new PanelContainerMsgIntent.HideAllPanelAndKeyboard(false));
        if (this.mAtPanel == null) {
            O();
        }
        ze1.b bVar = this.mAtPanel;
        if (bVar != null) {
            bVar.j("", anchorView);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void U(final View anchorView) {
        String str;
        Object h16 = ((com.tencent.base.api.runtime.a) getMContext()).h();
        Intrinsics.checkNotNullExpressionValue(h16, "mContext.baseParam");
        if (zl1.b.c((zl1.a) h16) == 7) {
            return;
        }
        k k3 = ((com.tencent.base.api.runtime.a) getMContext()).e().k(new PanelContainerMsgIntent.GetKeyboardStatus());
        Intrinsics.checkNotNull(k3, "null cannot be cast to non-null type com.tencent.frame.panelcontainer.PanelContainerMsgResult.GetKeyboardStatusMsgResult");
        boolean b16 = ((f.b) k3).b();
        ((com.tencent.base.api.runtime.a) getMContext()).e().h(new PanelContainerMsgIntent.HideAllPanelAndKeyboard(false));
        if (b16) {
            if (anchorView != null) {
                anchorView.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.functionbar.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        GuildFeedPublishFunctionBarVM.W(GuildFeedPublishFunctionBarVM.this, anchorView);
                    }
                }, 50L);
                return;
            }
            return;
        }
        com.tencent.mobileqq.guild.feed.partpanel.ui.b bVar = this.partManager;
        if (bVar != null) {
            bn1.c cVar = this.curSelectedPart;
            if (cVar != null) {
                str = cVar.f28687a;
            } else {
                str = null;
            }
            bVar.B(anchorView, str, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(GuildFeedPublishFunctionBarVM this$0, View view) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.guild.feed.partpanel.ui.b bVar = this$0.partManager;
        if (bVar != null) {
            bn1.c cVar = this$0.curSelectedPart;
            if (cVar != null) {
                str = cVar.f28687a;
            } else {
                str = null;
            }
            bVar.B(view, str, "");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void X(final View anchorView, boolean showToast, final HashTagPageType showListType) {
        boolean z16;
        Logger.a d16 = Logger.f235387a.d();
        Object h16 = ((com.tencent.base.api.runtime.a) getMContext()).h();
        Intrinsics.checkNotNullExpressionValue(h16, "mContext.baseParam");
        boolean j3 = zl1.b.j((zl1.a) h16);
        p(this);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[openPlustag] showListType ");
        sb5.append(showListType);
        sb5.append(", isBeyondGuild: ");
        sb5.append(j3);
        sb5.append(", isFakePersonalGuild: ");
        f.b bVar = null;
        sb5.append((Object) null);
        d16.d("GuildFeedPublishFunctionBarVM", 1, sb5.toString());
        if ((!M() && !N()) || (showListType == HashTagPageType.Channel_Page && !M())) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            int u16 = u();
            if (showToast && u16 != 0) {
                QQToast.makeText(((com.tencent.base.api.runtime.a) getMContext()).f(), ((com.tencent.base.api.runtime.a) getMContext()).f().getString(u16), 0).show();
                return;
            }
            return;
        }
        Object h17 = ((com.tencent.base.api.runtime.a) getMContext()).h();
        Intrinsics.checkNotNullExpressionValue(h17, "mContext.baseParam");
        if (zl1.b.c((zl1.a) h17) == 7) {
            return;
        }
        if (this.mTroopAndChannelPanel == null) {
            s();
        }
        if (this.mTroopAndChannelPanel == null) {
            QLog.i("GuildFeedPublishFunctionBarVM", 1, "[openPlustag]: createTroopAndChannelPanel but it's still null, mainTaskId=" + com.tencent.mobileqq.guild.feed.nativepublish.utils.a.a((com.tencent.base.api.runtime.a) getMContext()) + ", contact=" + ((zl1.a) ((com.tencent.base.api.runtime.a) getMContext()).h()).getContact());
        }
        k k3 = ((com.tencent.base.api.runtime.a) getMContext()).e().k(new PanelContainerMsgIntent.GetKeyboardStatus());
        if (k3 instanceof f.b) {
            bVar = (f.b) k3;
        }
        if (bVar == null) {
            return;
        }
        boolean b16 = bVar.b();
        ((com.tencent.base.api.runtime.a) getMContext()).e().h(new PanelContainerMsgIntent.HideAllPanelAndKeyboard(false));
        if (b16) {
            if (anchorView != null) {
                anchorView.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.functionbar.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        GuildFeedPublishFunctionBarVM.Z(GuildFeedPublishFunctionBarVM.this, anchorView, showListType);
                    }
                }, 50L);
            }
        } else {
            ip0.c cVar = this.mTroopAndChannelPanel;
            if (cVar != null) {
                cVar.g(anchorView, showListType);
            }
        }
    }

    static /* synthetic */ void Y(GuildFeedPublishFunctionBarVM guildFeedPublishFunctionBarVM, View view, boolean z16, HashTagPageType hashTagPageType, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            hashTagPageType = HashTagPageType.Troop_Page;
        }
        guildFeedPublishFunctionBarVM.X(view, z16, hashTagPageType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(GuildFeedPublishFunctionBarVM this$0, View view, HashTagPageType showListType) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(showListType, "$showListType");
        ip0.c cVar = this$0.mTroopAndChannelPanel;
        if (cVar != null) {
            cVar.g(view, showListType);
        }
    }

    private final void a0(String url) {
        updateUI(new GuildFeedPublishFunctionBarMviUIState.UpdateInsertLoadingStatus(true));
        new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.functionbar.GuildFeedPublishFunctionBarVM$processLinkInsert$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                QLog.i("GuildFeedPublishFunctionBarVM", 1, "processLinkInsert result=" + z16);
                GuildFeedPublishFunctionBarVM.this.updateUI(new GuildFeedPublishFunctionBarMviUIState.UpdateInsertLoadingStatus(false));
            }
        };
        throw null;
    }

    private final void b0(GuildFeedPublishFunctionBarMviUIState.ReplayPartSelect state) {
        this.replayPartState = state;
        updateUI(state);
    }

    private final void c0() {
        int i3;
        int stateFlag = this.functionEnableState.getStateFlag();
        boolean[] zArr = this.conditionForAt;
        int length = zArr.length;
        boolean z16 = false;
        int i16 = 0;
        while (true) {
            if (i16 < length) {
                if (!zArr[i16]) {
                    break;
                } else {
                    i16++;
                }
            } else {
                z16 = true;
                break;
            }
        }
        if (z16) {
            i3 = stateFlag | 2;
        } else {
            i3 = stateFlag & (-3);
        }
        if (i3 != this.functionEnableState.getStateFlag()) {
            e0(new GuildFeedPublishFunctionBarMviUIState.FunctionButtonsVisibilityState(i3));
        }
    }

    private final void d0(String guildId) {
        this.conditionForAt[0] = !ch.j0(guildId);
        c0();
    }

    private final void e0(GuildFeedPublishFunctionBarMviUIState.FunctionButtonsVisibilityState newState) {
        this.functionEnableState = newState;
        updateUI(newState);
    }

    public static final /* synthetic */ nk1.a p(GuildFeedPublishFunctionBarVM guildFeedPublishFunctionBarVM) {
        guildFeedPublishFunctionBarVM.getClass();
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void s() {
        ArrayList arrayListOf;
        String v3 = v();
        Logger logger = Logger.f235387a;
        Logger.a d16 = logger.d();
        p(this);
        d16.d("GuildFeedPublishFunctionBarVM", 1, "[createTroopAndChannelPanel] guildId " + v3 + ", curSelectedGuild: " + ((Object) null) + ", mContext.baseParam: " + ((com.tencent.base.api.runtime.a) getMContext()).h());
        ip0.c cVar = this.mTroopAndChannelPanel;
        if (cVar != null) {
            cVar.destroy();
        }
        HashTagPageType hashTagPageType = HashTagPageType.Troop_Page;
        HashTagPageType hashTagPageType2 = HashTagPageType.Channel_Page;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(hashTagPageType, hashTagPageType2);
        if (!M()) {
            arrayListOf.remove(hashTagPageType2);
        }
        if (!N()) {
            arrayListOf.remove(hashTagPageType);
        }
        logger.d().d("GuildFeedPublishFunctionBarVM", 1, "[initTroopAndChannelPanel] defaultPageList " + arrayListOf);
        if (arrayListOf.isEmpty()) {
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        Activity f16 = ((com.tencent.base.api.runtime.a) getMContext()).f();
        Intrinsics.checkNotNullExpressionValue(f16, "mContext.activity");
        ip0.c cVar2 = (ip0.c) j.a(new a.C1192a((AppInterface) peekAppRuntime, f16, v3, "", 7).d(1).c(arrayListOf).b(t()).a());
        this.mTroopAndChannelPanel = cVar2;
        if (cVar2 != null) {
            cVar2.k(new b());
        }
    }

    private final com.tencent.guild.aio.input.at.trooptag.dialogui.bean.b t() {
        return new c();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final int u() {
        Object h16 = ((com.tencent.base.api.runtime.a) getMContext()).h();
        Intrinsics.checkNotNullExpressionValue(h16, "mContext.baseParam");
        if (zl1.b.j((zl1.a) h16)) {
            return R.string.f145000qa;
        }
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final String v() {
        Object h16 = ((com.tencent.base.api.runtime.a) getMContext()).h();
        Intrinsics.checkNotNullExpressionValue(h16, "mContext.baseParam");
        if (zl1.b.j((zl1.a) h16)) {
            return "";
        }
        return ((zl1.a) ((com.tencent.base.api.runtime.a) getMContext()).h()).h();
    }

    private final String w() {
        boolean z16;
        bn1.c cVar = this.curSelectedPart;
        if (cVar != null) {
            String str = cVar.f28689c;
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16 && cVar.f28688b != 2) {
                String str2 = cVar.f28689c;
                Intrinsics.checkNotNullExpressionValue(str2, "{\n            curPart.partName\n        }");
                return str2;
            }
        }
        return "\u4e0d\u9009\u62e9\u7248\u5757";
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void x(int curPanelHeight) {
        int coerceAtLeast;
        k k3 = ((com.tencent.base.api.runtime.a) getMContext()).e().k(new PanelContainerMsgIntent.GetKeyboardStatus());
        Intrinsics.checkNotNull(k3, "null cannot be cast to non-null type com.tencent.frame.panelcontainer.PanelContainerMsgResult.GetKeyboardStatusMsgResult");
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(curPanelHeight, ((f.b) k3).a());
        updateUI(new GuildFeedPublishFunctionBarMviUIState.SetMarginBottom(coerceAtLeast));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void y() {
        boolean z16;
        String h16 = ((zl1.a) ((com.tencent.base.api.runtime.a) getMContext()).h()).h();
        if (h16.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            h16 = null;
        }
        if (h16 != null) {
            d0(h16);
        }
    }

    private final void z(nk1.a selected) {
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull a intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof a.C7767a) {
            a.C7767a c7767a = (a.C7767a) intent;
            this.mAnchorView = c7767a.getAnchorView();
            P(c7767a.getParentView());
            return;
        }
        if (intent instanceof a.d) {
            D();
            return;
        }
        if (intent instanceof a.e) {
            Y(this, this.mAnchorView, true, null, 4, null);
            return;
        }
        if (intent instanceof a.f) {
            C((a.f) intent);
        } else if (intent instanceof a.g) {
            G();
        } else if (intent instanceof a.b) {
            ((com.tencent.base.api.runtime.a) getMContext()).e().h(new GuildFeedEditTextMsgIntent.OnTouchEvent());
        }
    }

    @Override // com.tencent.input.base.mvicompat.ex.a
    public void E(@NotNull MsgIntent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof PanelContainerMsgIntent.OnKeyboardStatusChanged) {
            PanelContainerMsgIntent.OnKeyboardStatusChanged onKeyboardStatusChanged = (PanelContainerMsgIntent.OnKeyboardStatusChanged) intent;
            B(onKeyboardStatusChanged.b(), onKeyboardStatusChanged.a());
            if (!this.alreadyAddMedia) {
                L(onKeyboardStatusChanged);
                return;
            }
            return;
        }
        if (intent instanceof PanelContainerMsgIntent.OnPanelHeightChanged) {
            x(((PanelContainerMsgIntent.OnPanelHeightChanged) intent).a());
            return;
        }
        boolean z16 = true;
        boolean z17 = false;
        if (intent instanceof PanelContainerMsgIntent.OnPanelStatusChanged) {
            if (((PanelContainerMsgIntent.OnPanelStatusChanged) intent).a() != 1) {
                z16 = false;
            }
            updateUI(new GuildFeedPublishFunctionBarMviUIState.SetEmojiSelected(z16));
            return;
        }
        if (intent instanceof GuildFeedPublishFunctionBarMsgIntent.OpenAtPanel) {
            T(this.mAnchorView, false);
            return;
        }
        if (intent instanceof GuildFeedPublishFunctionBarMsgIntent.OpenPartPanel) {
            U(this.mAnchorView);
            return;
        }
        if (intent instanceof GuildFeedPublishFunctionBarMsgIntent.OpenPlusTag) {
            X(this.mAnchorView, false, ((GuildFeedPublishFunctionBarMsgIntent.OpenPlusTag) intent).getShowListType());
            return;
        }
        if (intent instanceof GuildFeedEditTextMsgIntent.OnTextChanged) {
            updateUI(new GuildFeedPublishFunctionBarMviUIState.HideVideoInsertGuide());
            return;
        }
        if (intent instanceof FeedEditorMediaMsgIntent.OnMediaChanged) {
            FeedEditorMediaMsgIntent.OnMediaChanged onMediaChanged = (FeedEditorMediaMsgIntent.OnMediaChanged) intent;
            F(onMediaChanged);
            if (this.alreadyAddMedia || onMediaChanged.getThirdShare()) {
                z17 = true;
            }
            updateUI(new GuildFeedPublishFunctionBarMviUIState.UpdateVideoEntranceStatus(!z17));
            return;
        }
        String str = null;
        if (intent instanceof GuildFeedPublishFunctionBarMsgIntent.OnPartSelect) {
            GuildFeedPublishFunctionBarMsgIntent.OnPartSelect onPartSelect = (GuildFeedPublishFunctionBarMsgIntent.OnPartSelect) intent;
            bn1.c partInfo = onPartSelect.getPartInfo();
            if (partInfo != null) {
                str = partInfo.f28689c;
            }
            bn1.c partInfo2 = onPartSelect.getPartInfo();
            if (partInfo2 == null || partInfo2.f28688b != 2) {
                z16 = false;
            }
            b0(new GuildFeedPublishFunctionBarMviUIState.ReplayPartSelect(str, z16, this.replayPartState.getEnableState()));
            return;
        }
        if (intent instanceof GuildFeedPublishGuildSelectorMsgIntent.OnGuildSelect) {
            ((GuildFeedPublishGuildSelectorMsgIntent.OnGuildSelect) intent).a();
            z(null);
        } else if (intent instanceof FeedEditorRootMsgIntent.OnBindViewAndData) {
            y();
        } else if (intent instanceof GuildFeedPublishFunctionBarMviUIState.FunctionBarVisibility) {
            updateUI((MviUIState) intent);
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
        String b17 = com.tencent.mvi.base.route.c.b(PanelContainerMsgIntent.OnKeyboardStatusChanged.class);
        Intrinsics.checkNotNullExpressionValue(b17, "get(java)");
        String b18 = com.tencent.mvi.base.route.c.b(PanelContainerMsgIntent.OnPanelHeightChanged.class);
        Intrinsics.checkNotNullExpressionValue(b18, "get(java)");
        String b19 = com.tencent.mvi.base.route.c.b(PanelContainerMsgIntent.OnPanelStatusChanged.class);
        Intrinsics.checkNotNullExpressionValue(b19, "get(java)");
        String b26 = com.tencent.mvi.base.route.c.b(GuildFeedPublishFunctionBarMsgIntent.OpenAtPanel.class);
        Intrinsics.checkNotNullExpressionValue(b26, "get(java)");
        String b27 = com.tencent.mvi.base.route.c.b(GuildFeedPublishFunctionBarMsgIntent.OpenPartPanel.class);
        Intrinsics.checkNotNullExpressionValue(b27, "get(java)");
        String b28 = com.tencent.mvi.base.route.c.b(GuildFeedPublishFunctionBarMsgIntent.OpenHashTag.class);
        Intrinsics.checkNotNullExpressionValue(b28, "get(java)");
        String b29 = com.tencent.mvi.base.route.c.b(GuildFeedPublishFunctionBarMsgIntent.OpenPlusTag.class);
        Intrinsics.checkNotNullExpressionValue(b29, "get(java)");
        String b36 = com.tencent.mvi.base.route.c.b(FeedEditorMediaMsgIntent.OnMediaChanged.class);
        Intrinsics.checkNotNullExpressionValue(b36, "get(java)");
        String b37 = com.tencent.mvi.base.route.c.b(GuildFeedPublishFunctionBarMsgIntent.OnPartSelect.class);
        Intrinsics.checkNotNullExpressionValue(b37, "get(java)");
        String b38 = com.tencent.mvi.base.route.c.b(GuildFeedPublishGuildSelectorMsgIntent.OnGuildSelect.class);
        Intrinsics.checkNotNullExpressionValue(b38, "get(java)");
        String b39 = com.tencent.mvi.base.route.c.b(FeedEditorRootMsgIntent.OnBindViewAndData.class);
        Intrinsics.checkNotNullExpressionValue(b39, "get(java)");
        String b46 = com.tencent.mvi.base.route.c.b(GuildFeedPublishFunctionBarMviUIState.FunctionBarVisibility.class);
        Intrinsics.checkNotNullExpressionValue(b46, "get(java)");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{b16, b17, b18, b19, b26, b27, b28, b29, b36, b37, b38, b39, b46});
        return listOf;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public void onCreate(@NotNull com.tencent.base.api.runtime.a<zl1.a> context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate((GuildFeedPublishFunctionBarVM) context);
        zl1.a h16 = context.h();
        Intrinsics.checkNotNullExpressionValue(h16, "context.baseParam");
        if (zl1.b.j(h16)) {
            updateUI(new GuildFeedPublishFunctionBarMviUIState.UpdateFunctionBarIfIsBeyondGuild(true));
        }
        VMMessengerProtocolSupport vMMessengerProtocolSupport = this.messageHandlerSupport;
        com.tencent.mvi.base.route.j e16 = context.e();
        Intrinsics.checkNotNullExpressionValue(e16, "context.messenger");
        vMMessengerProtocolSupport.d(e16);
        ((com.tencent.base.api.runtime.a) getMContext()).d().getLifecycle().addObserver(this);
        getMContext();
        throw null;
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
        ze1.b bVar = this.mAtPanel;
        if (bVar != null) {
            j.d(bVar);
        }
        ip0.c cVar = this.mTroopAndChannelPanel;
        if (cVar != null) {
            cVar.destroy();
        }
        com.tencent.mobileqq.guild.feed.partpanel.ui.b bVar2 = this.partManager;
        if (bVar2 != null) {
            bVar2.u();
        }
        s sVar = this.mSoftKeyboardStateHelper;
        if (sVar != null) {
            sVar.j();
        }
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NotNull LifecycleOwner source, @NotNull Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event != Lifecycle.Event.ON_RESUME) {
        } else {
            throw null;
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/guild/feed/nativepublish/functionbar/GuildFeedPublishFunctionBarVM$c", "Lcom/tencent/guild/aio/input/at/trooptag/dialogui/bean/b;", "Landroidx/recyclerview/widget/RecyclerView$ItemAnimator;", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements com.tencent.guild.aio.input.at.trooptag.dialogui.bean.b {
        c() {
        }

        @Override // com.tencent.guild.aio.input.at.trooptag.dialogui.bean.b
        @Nullable
        public RecyclerView.ItemAnimator a() {
            return new GuildChannelListAnim(new a(), 3);
        }

        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/feed/nativepublish/functionbar/GuildFeedPublishFunctionBarVM$c$a", "Lcom/tencent/mobileqq/guild/animate/subchannellist/GuildChannelListAnim$h;", "", "c", "b", "a", "onAnimEnd", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
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
