package com.tencent.mobileqq.guild.media.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.data.GuildAudioChannelData;
import com.tencent.mobileqq.guild.data.profilecard.GuildBaseProfileData;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.media.core.data.p;
import com.tencent.mobileqq.guild.media.core.m;
import com.tencent.mobileqq.guild.media.core.notify.y;
import com.tencent.mobileqq.guild.media.dialog.modedialog.ModeChooseDialog;
import com.tencent.mobileqq.guild.profile.profilecard.baseprofile.card.GuildProfileCard;
import com.tencent.mobileqq.guild.robot.components.console.RobotInfoFragment;
import com.tencent.mobileqq.guild.setting.channeldetails.GuildChannelDetailHeadViewNew;
import com.tencent.mobileqq.guild.setting.channeldetails.GuildChannelDetailHeadViewStyle;
import com.tencent.mobileqq.guild.setting.channeldetails.QQGuildPaddingImmerseTitleBarFragment;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.as;
import com.tencent.mobileqq.guild.util.bw;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.widget.GuildChannelBaseNavBarStyle;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pad.LaunchMode;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.dx;
import com.tencent.mobileqq.qqguildsdk.data.fk;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 Y2\u00020\u00012\u00020\u0002:\u0001ZB\u0007\u00a2\u0006\u0004\bW\u0010XJ\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J&\u0010\r\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014J\u001a\u0010\u0012\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0014J\b\u0010\u0013\u001a\u00020\u0007H\u0014J\b\u0010\u0014\u001a\u00020\u0007H\u0016J\u0012\u0010\u0017\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0007H\u0016J\b\u0010\u0019\u001a\u00020\u0007H\u0016J\b\u0010\u001a\u001a\u00020\u0007H\u0002J\b\u0010\u001b\u001a\u00020\u0010H\u0002J\b\u0010\u001c\u001a\u00020\u0007H\u0002J\b\u0010\u001d\u001a\u00020\u0007H\u0002J\b\u0010\u001e\u001a\u00020\u0007H\u0002J\b\u0010\u001f\u001a\u00020\u0007H\u0002J\b\u0010 \u001a\u00020\u0007H\u0002J\b\u0010!\u001a\u00020\u0007H\u0002J\u0010\u0010\"\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u001c\u0010'\u001a\u00020\u00072\b\u0010$\u001a\u0004\u0018\u00010#2\b\u0010&\u001a\u0004\u0018\u00010%H\u0002J\b\u0010(\u001a\u00020\u0007H\u0002J\b\u0010)\u001a\u00020\u0007H\u0002R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u00101\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0018\u00108\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010;\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010>\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010B\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010D\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010AR\u0016\u0010F\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u00106R\u0016\u0010I\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010HR\u0014\u0010N\u001a\u00020K8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0014\u0010R\u001a\u00020O8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0014\u0010V\u001a\u00020S8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bT\u0010U\u00a8\u0006["}, d2 = {"Lcom/tencent/mobileqq/guild/media/detail/QQGuildMediaChannelDetailFragment;", "Lcom/tencent/mobileqq/guild/setting/channeldetails/QQGuildPaddingImmerseTitleBarFragment;", "Landroid/view/View$OnClickListener;", "", "getContentLayoutId", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "doOnCreateView", "", "title", "", "isMsgNotifyOpen", "rh", "qh", "onResume", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "onDestroyView", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Dh", "Fh", "Ch", "initData", "initView", "Ih", "Gh", "Mh", "Eh", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "channelInfo", "Hh", "Kh", "Lh", "Lcom/tencent/mobileqq/guild/media/detail/QQGuildMediaChannelDetailListView;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/media/detail/QQGuildMediaChannelDetailListView;", "mMemberListView", "Lcom/tencent/mobileqq/guild/setting/channeldetails/GuildChannelDetailHeadViewNew;", "G", "Lcom/tencent/mobileqq/guild/setting/channeldetails/GuildChannelDetailHeadViewNew;", "mChannelDetailHeadViewNew", "Landroid/widget/TextView;", "H", "Landroid/widget/TextView;", "mSettingView", "I", "Landroid/view/View;", "mSettingRedDot", "J", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "mGuildInfo", "K", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "mChannelInfo", "", "L", "Ljava/lang/String;", "mChannelId", "M", "mGuildId", "N", "mChatPieContainerType", "P", "Z", "mIsWithoutMainframe", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "mGPServiceObserver", "Lcom/tencent/mobileqq/guild/media/core/notify/y;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/guild/media/core/notify/y;", "mMediaChannelObserver", "Lcom/tencent/mobileqq/guild/media/detail/b;", "T", "Lcom/tencent/mobileqq/guild/media/detail/b;", "mediaMemberClick", "<init>", "()V", "U", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class QQGuildMediaChannelDetailFragment extends QQGuildPaddingImmerseTitleBarFragment implements View.OnClickListener {

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private QQGuildMediaChannelDetailListView mMemberListView;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private GuildChannelDetailHeadViewNew mChannelDetailHeadViewNew;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private TextView mSettingView;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private View mSettingRedDot;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private IGProGuildInfo mGuildInfo;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private IGProChannelInfo mChannelInfo;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private String mChannelId;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private String mGuildId;

    /* renamed from: N, reason: from kotlin metadata */
    private int mChatPieContainerType;

    /* renamed from: P, reason: from kotlin metadata */
    private boolean mIsWithoutMainframe;

    /* renamed from: Q, reason: from kotlin metadata */
    private boolean isMsgNotifyOpen;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final GPServiceObserver mGPServiceObserver = new b();

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final y mMediaChannelObserver = new c();

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.media.detail.b mediaMemberClick = new d();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J6\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\tR\u0014\u0010\r\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/media/detail/QQGuildMediaChannelDetailFragment$a;", "", "Lcom/tencent/common/app/AppInterface;", "app", "Landroid/content/Context;", "context", "", "guildId", "channelId", "", "chatPieContainerType", "", "a", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.media.detail.QQGuildMediaChannelDetailFragment$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@Nullable AppInterface app, @Nullable Context context, @Nullable String guildId, @Nullable String channelId, int chatPieContainerType) {
            if (app != null && context != null && !TextUtils.isEmpty(guildId) && !TextUtils.isEmpty(channelId)) {
                Intent intent = new Intent();
                intent.putExtra("extra_guild_id", guildId);
                intent.putExtra("extra_channel_id", channelId);
                intent.putExtra("START_WITHOUT_MAIN_FRAME", true);
                intent.putExtra("extra_key_chatpie_container", chatPieContainerType);
                if (QQGuildUIUtil.A(context)) {
                    com.tencent.mobileqq.pad.i.e(context, intent.getExtras(), QQGuildMediaChannelDetailFragment.class, new com.tencent.mobileqq.pad.b().e(false).g(false).c(R.anim.f154637p9, R.anim.f154634p6, R.anim.f154637p9, R.anim.f154634p6).h(LaunchMode.standard).a());
                } else {
                    QPublicFragmentActivity.b.b(context, intent, QPublicFragmentActivity.class, QQGuildMediaChannelDetailFragment.class);
                }
            }
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000C\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0014J\u001e\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bH\u0014J$\u0010\u0011\u001a\u00020\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u000b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000bH\u0014J\u001c\u0010\u0014\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0014J.\u0010\u0017\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u001a\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0015j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u0016H\u0014\u00a8\u0006\u0018"}, d2 = {"com/tencent/mobileqq/guild/media/detail/QQGuildMediaChannelDetailFragment$b", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "guildId", "", "onRemoveGuild", "onDestoryGuild", "onDeleteGuild", "", "black", "onBeKickFromGuild", "", "channelIds", "onPushChannelDestroy", "ops", "Lcom/tencent/mobileqq/qqguildsdk/data/fk;", "list", "onQQMsgListChannelUpdated", "Lcom/tencent/mobileqq/qqguildsdk/data/dx;", QCircleDaTongConstant.ElementParamValue.PERMISSION, "onGuildPermissionChanged", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "onChannelPermissionChanged", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends GPServiceObserver {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onBeKickFromGuild(@NotNull String guildId, int black) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            if (QQGuildMediaChannelDetailFragment.this.mIsWithoutMainframe) {
                IGProGuildInfo iGProGuildInfo = QQGuildMediaChannelDetailFragment.this.mGuildInfo;
                Intrinsics.checkNotNull(iGProGuildInfo);
                if (Intrinsics.areEqual(iGProGuildInfo.getGuildID(), guildId)) {
                    QLog.i("QQGuildMediaChannelDetailFragment", 1, "onBeKickFromGuild");
                    QQGuildMediaChannelDetailFragment.this.Dh();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelPermissionChanged(@Nullable String guildId, @Nullable HashSet<String> channelIds) {
            boolean contains;
            if (Intrinsics.areEqual(QQGuildMediaChannelDetailFragment.this.mGuildId, guildId) && channelIds != null) {
                contains = CollectionsKt___CollectionsKt.contains(channelIds, QQGuildMediaChannelDetailFragment.this.mChannelId);
                if (contains) {
                    IGPSService iGPSService = (IGPSService) ch.R0(IGPSService.class);
                    QQGuildMediaChannelDetailFragment qQGuildMediaChannelDetailFragment = QQGuildMediaChannelDetailFragment.this;
                    qQGuildMediaChannelDetailFragment.Hh(iGPSService.getGuildInfo(qQGuildMediaChannelDetailFragment.mGuildId), iGPSService.getChannelInfo(QQGuildMediaChannelDetailFragment.this.mChannelId));
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onDeleteGuild(@NotNull String guildId) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            IGProGuildInfo iGProGuildInfo = QQGuildMediaChannelDetailFragment.this.mGuildInfo;
            if (iGProGuildInfo != null && iGProGuildInfo.getGuildID() != null) {
                QQGuildMediaChannelDetailFragment qQGuildMediaChannelDetailFragment = QQGuildMediaChannelDetailFragment.this;
                if (qQGuildMediaChannelDetailFragment.mIsWithoutMainframe) {
                    IGProGuildInfo iGProGuildInfo2 = qQGuildMediaChannelDetailFragment.mGuildInfo;
                    Intrinsics.checkNotNull(iGProGuildInfo2);
                    if (Intrinsics.areEqual(iGProGuildInfo2.getGuildID(), guildId)) {
                        QLog.i("QQGuildMediaChannelDetailFragment", 1, "onDeleteGuild");
                        qQGuildMediaChannelDetailFragment.Dh();
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onDestoryGuild(@NotNull String guildId) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            if (QQGuildMediaChannelDetailFragment.this.mIsWithoutMainframe) {
                IGProGuildInfo iGProGuildInfo = QQGuildMediaChannelDetailFragment.this.mGuildInfo;
                Intrinsics.checkNotNull(iGProGuildInfo);
                if (Intrinsics.areEqual(iGProGuildInfo.getGuildID(), guildId)) {
                    QLog.i("QQGuildMediaChannelDetailFragment", 1, "onDestroyGuild");
                    QQGuildMediaChannelDetailFragment.this.Dh();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildPermissionChanged(@Nullable String guildId, @Nullable dx permission) {
            if (Intrinsics.areEqual(QQGuildMediaChannelDetailFragment.this.mGuildId, guildId)) {
                IGPSService iGPSService = (IGPSService) ch.R0(IGPSService.class);
                QQGuildMediaChannelDetailFragment qQGuildMediaChannelDetailFragment = QQGuildMediaChannelDetailFragment.this;
                qQGuildMediaChannelDetailFragment.Hh(iGPSService.getGuildInfo(qQGuildMediaChannelDetailFragment.mGuildId), iGPSService.getChannelInfo(QQGuildMediaChannelDetailFragment.this.mChannelId));
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onPushChannelDestroy(@NotNull String guildId, @NotNull List<String> channelIds) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(channelIds, "channelIds");
            if (QQGuildMediaChannelDetailFragment.this.mIsWithoutMainframe) {
                IGProGuildInfo iGProGuildInfo = QQGuildMediaChannelDetailFragment.this.mGuildInfo;
                Intrinsics.checkNotNull(iGProGuildInfo);
                if (Intrinsics.areEqual(iGProGuildInfo.getGuildID(), guildId)) {
                    Iterator<String> it = channelIds.iterator();
                    while (it.hasNext()) {
                        if (Intrinsics.areEqual(QQGuildMediaChannelDetailFragment.this.mChannelId, it.next())) {
                            QLog.i("QQGuildMediaChannelDetailFragment", 1, "onPushChannelDestroy");
                            QQGuildMediaChannelDetailFragment.this.Dh();
                        }
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onQQMsgListChannelUpdated(@NotNull List<Integer> ops, @NotNull List<fk> list) {
            Intrinsics.checkNotNullParameter(ops, "ops");
            Intrinsics.checkNotNullParameter(list, "list");
            Iterator<fk> it = list.iterator();
            while (it.hasNext()) {
                if (Intrinsics.areEqual(it.next().getChannelId(), QQGuildMediaChannelDetailFragment.this.mChannelId)) {
                    QLog.i("QQGuildMediaChannelDetailFragment", 1, "onQQMsgListChannelUpdated");
                    GuildChannelDetailHeadViewNew guildChannelDetailHeadViewNew = QQGuildMediaChannelDetailFragment.this.mChannelDetailHeadViewNew;
                    if (guildChannelDetailHeadViewNew != null) {
                        guildChannelDetailHeadViewNew.I(QQGuildMediaChannelDetailFragment.this.mGuildInfo, QQGuildMediaChannelDetailFragment.this.mChannelInfo);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onRemoveGuild(@NotNull String guildId) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            if (QQGuildMediaChannelDetailFragment.this.mIsWithoutMainframe) {
                IGProGuildInfo iGProGuildInfo = QQGuildMediaChannelDetailFragment.this.mGuildInfo;
                Intrinsics.checkNotNull(iGProGuildInfo);
                if (Intrinsics.areEqual(iGProGuildInfo.getGuildID(), guildId)) {
                    QLog.i("QQGuildMediaChannelDetailFragment", 1, "onRemoveGuild");
                    QQGuildMediaChannelDetailFragment.this.Dh();
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/media/detail/QQGuildMediaChannelDetailFragment$c", "Lcom/tencent/mobileqq/guild/media/core/notify/y;", "", "guildId", "channelId", "reason", "", "t", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c extends y {
        c() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.y
        public void t(@NotNull String guildId, @NotNull String channelId, @NotNull String reason) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            Intrinsics.checkNotNullParameter(reason, "reason");
            super.t(guildId, channelId, reason);
            if (QQGuildMediaChannelDetailFragment.this.mChatPieContainerType == 3 && Intrinsics.areEqual(channelId, QQGuildMediaChannelDetailFragment.this.mChannelId)) {
                QLog.d("QQGuildMediaChannelDetailFragment", 1, "exit " + reason);
                QQGuildMediaChannelDetailFragment.this.Dh();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/media/detail/QQGuildMediaChannelDetailFragment$d", "Lcom/tencent/mobileqq/guild/media/detail/b;", "Landroid/view/View;", "view", "", "b", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d implements com.tencent.mobileqq.guild.media.detail.b {
        d() {
        }

        @Override // com.tencent.mobileqq.guild.media.detail.b
        public boolean a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            return true;
        }

        @Override // com.tencent.mobileqq.guild.media.detail.b
        public void b(@NotNull View view) {
            String str;
            String str2;
            JumpGuildParam.JoinInfoParam joinInfoParam;
            JumpGuildParam.JoinInfoParam joinInfoParam2;
            Intrinsics.checkNotNullParameter(view, "view");
            Object tag = view.getTag();
            Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tencent.mobileqq.guild.media.core.data.UserInfo");
            p pVar = (p) tag;
            if (pVar.f228098f == 1) {
                FragmentActivity requireActivity = QQGuildMediaChannelDetailFragment.this.requireActivity();
                String str3 = QQGuildMediaChannelDetailFragment.this.mChannelId;
                IGProGuildInfo iGProGuildInfo = QQGuildMediaChannelDetailFragment.this.mGuildInfo;
                Intrinsics.checkNotNull(iGProGuildInfo);
                RobotInfoFragment.wh(requireActivity, str3, iGProGuildInfo.getGuildID(), pVar.f228093a, "", "0", false, 0);
                return;
            }
            Bundle loadBeanBundle = com.tencent.mobileqq.guild.media.core.j.a().getLoadBeanBundle();
            if (loadBeanBundle != null && (joinInfoParam2 = (JumpGuildParam.JoinInfoParam) loadBeanBundle.getParcelable(JumpGuildParam.KEY_JOIN_INFO_PARAM)) != null) {
                str = joinInfoParam2.getMainSource();
            } else {
                str = null;
            }
            String str4 = "";
            if (str == null) {
                str = "";
            }
            if (loadBeanBundle != null && (joinInfoParam = (JumpGuildParam.JoinInfoParam) loadBeanBundle.getParcelable(JumpGuildParam.KEY_JOIN_INFO_PARAM)) != null) {
                str2 = joinInfoParam.getSubSource();
            } else {
                str2 = null;
            }
            if (str2 != null) {
                str4 = str2;
            }
            int sceneTypeBySource = GuildProfileData.getSceneTypeBySource(str, str4, 3);
            IGProChannelInfo iGProChannelInfo = QQGuildMediaChannelDetailFragment.this.mChannelInfo;
            Intrinsics.checkNotNull(iGProChannelInfo);
            GuildProfileData guildProfileData = new GuildProfileData(iGProChannelInfo.getGuildId(), String.valueOf(QQGuildMediaChannelDetailFragment.this.mChannelInfo), pVar.f228093a, 1, sceneTypeBySource);
            IGProChannelInfo iGProChannelInfo2 = QQGuildMediaChannelDetailFragment.this.mChannelInfo;
            Intrinsics.checkNotNull(iGProChannelInfo2);
            String channelUin = iGProChannelInfo2.getChannelUin();
            IGProChannelInfo iGProChannelInfo3 = QQGuildMediaChannelDetailFragment.this.mChannelInfo;
            Intrinsics.checkNotNull(iGProChannelInfo3);
            guildProfileData.getExtras().putParcelable(GuildProfileData.KEY_CHANNEL_DATA, new GuildAudioChannelData(channelUin, iGProChannelInfo3.getType(), com.tencent.mobileqq.guild.media.core.j.c().getSelfUserInfo().f228093a, com.tencent.mobileqq.guild.media.core.j.c().getSelfUserInfo().f228097e, pVar.f228093a, pVar.f228097e, pVar.f228112t, pVar.f228113u, pVar.f228105m));
            GuildBaseProfileData guildBaseProfileData = guildProfileData.getGuildBaseProfileData();
            IGProChannelInfo iGProChannelInfo4 = QQGuildMediaChannelDetailFragment.this.mChannelInfo;
            Intrinsics.checkNotNull(iGProChannelInfo4);
            guildBaseProfileData.r(iGProChannelInfo4.getChannelUin());
            GuildProfileCard.Lh(QQGuildMediaChannelDetailFragment.this.requireActivity(), guildProfileData);
            VideoReport.setElementId(view, "em_sgrp_sub_channel_member");
            VideoReport.reportEvent("clck", view, null);
        }
    }

    private final void Ch() {
        boolean z16;
        AppInterface appInterface = getAppInterface();
        if (appInterface == null) {
            QLog.d("QQGuildMediaChannelDetailFragment", 1, "doOnResume appInterface is null, channelId = " + this.mChannelId);
            return;
        }
        if (!m.h(com.tencent.mobileqq.guild.media.core.j.c())) {
            Dh();
        }
        IGProChannelInfo channelInfo = ((IGPSService) appInterface.getRuntimeService(IGPSService.class, "")).getChannelInfo(String.valueOf(this.mChannelId));
        this.mChannelInfo = channelInfo;
        if (channelInfo == null) {
            QLog.d("QQGuildMediaChannelDetailFragment", 1, "channelInfo is null, channelId = " + this.mChannelId);
            return;
        }
        Intrinsics.checkNotNull(channelInfo);
        if (channelInfo.getFinalMsgNotify() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.isMsgNotifyOpen = z16;
        Hh(this.mGuildInfo, this.mChannelInfo);
        IGProChannelInfo iGProChannelInfo = this.mChannelInfo;
        Intrinsics.checkNotNull(iGProChannelInfo);
        rh(iGProChannelInfo.getChannelName(), this.isMsgNotifyOpen);
        qh();
        if (QLog.isColorLevel()) {
            QLog.d("QQGuildMediaChannelDetailFragment", 1, "[doOnResume] mChannelInfo: ", this.mChannelInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Dh() {
        if (!Fh() && !com.tencent.mobileqq.pad.m.b(requireActivity())) {
            QLog.d("QQGuildMediaChannelDetailFragment", 1, "exitWithPadJudge activity finish");
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    private final void Eh(ViewGroup container) {
        if (this.mIsWithoutMainframe) {
            Window window = requireActivity().getWindow();
            window.clearFlags(67108864);
            window.getDecorView().setSystemUiVisibility(1280);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
            ImmersiveUtils.setStatusTextColor(!QQTheme.isNowThemeIsNight(), window);
        }
        RelativeLayout relativeLayout = this.D;
        if (relativeLayout != null) {
            View findViewById = relativeLayout.findViewById(R.id.uzi);
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-1, 0);
            }
            layoutParams.height = ImmersiveUtils.getStatusBarHeight(getContext());
            findViewById.setLayoutParams(layoutParams);
            findViewById.setBackgroundColor(ie0.a.f().g(getContext(), R.color.qui_common_bg_nav_secondary, 1002));
            container.setPadding(container.getPaddingLeft(), 0, container.getPaddingRight(), container.getPaddingBottom());
        }
    }

    private final boolean Fh() {
        boolean z16;
        boolean z17;
        if (getActivity() == null) {
            return true;
        }
        FragmentActivity activity = getActivity();
        if (activity != null && activity.isFinishing()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return true;
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null && activity2.isDestroyed()) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17 || getContext() == null) {
            return true;
        }
        return false;
    }

    private final void Gh() {
        bw.f235485a.y1(true);
        View view = this.mSettingRedDot;
        if (view != null) {
            view.setVisibility(8);
        }
        if (QQGuildUIUtil.v()) {
            return;
        }
        Kh();
        if (this.mChannelInfo != null && getAppInterface() != null && getActivity() != null) {
            IGProChannelInfo iGProChannelInfo = this.mChannelInfo;
            Intrinsics.checkNotNull(iGProChannelInfo);
            if (as.j(iGProChannelInfo)) {
                IQQGuildRouterApi iQQGuildRouterApi = (IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class);
                AppInterface appInterface = getAppInterface();
                FragmentActivity activity = getActivity();
                IGProChannelInfo iGProChannelInfo2 = this.mChannelInfo;
                Intrinsics.checkNotNull(iGProChannelInfo2);
                String guildId = iGProChannelInfo2.getGuildId();
                IGProChannelInfo iGProChannelInfo3 = this.mChannelInfo;
                Intrinsics.checkNotNull(iGProChannelInfo3);
                iQQGuildRouterApi.openGuildChannelInfoSetting(appInterface, activity, guildId, iGProChannelInfo3.getChannelUin(), 2);
                return;
            }
            QLog.i("QQGuildMediaChannelDetailFragment", 1, "handleSettingClick not admin. guildId=" + this.mGuildId);
            return;
        }
        QLog.i("QQGuildMediaChannelDetailFragment", 1, "handleSettingClick error. guildId=" + this.mGuildId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Hh(IGProGuildInfo guildInfo, IGProChannelInfo channelInfo) {
        boolean z16 = true;
        if (guildInfo != null && channelInfo != null) {
            this.mGuildInfo = guildInfo;
            this.mChannelInfo = channelInfo;
            int i3 = 0;
            if (channelInfo.getFinalMsgNotify() != 1) {
                z16 = false;
            }
            this.isMsgNotifyOpen = z16;
            rh(channelInfo.getChannelName(), this.isMsgNotifyOpen);
            TextView textView = this.mSettingView;
            if (textView != null) {
                IGProChannelInfo iGProChannelInfo = this.mChannelInfo;
                Intrinsics.checkNotNull(iGProChannelInfo);
                if (!as.j(iGProChannelInfo)) {
                    i3 = 8;
                }
                textView.setVisibility(i3);
            }
            GuildChannelDetailHeadViewNew guildChannelDetailHeadViewNew = this.mChannelDetailHeadViewNew;
            if (guildChannelDetailHeadViewNew != null) {
                guildChannelDetailHeadViewNew.I(guildInfo, channelInfo);
                return;
            }
            return;
        }
        QLog.e("QQGuildMediaChannelDetailFragment", 1, "refreshHeader info is null");
    }

    private final void Ih() {
        IRuntimeService runtimeService = getAppInterface().getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appInterface.getRuntimeS\u2026va, ProcessConstant.MAIN)");
        ((IGPSService) runtimeService).addObserver(this.mGPServiceObserver);
        MutableLiveData<Boolean> a16 = ModeChooseDialog.INSTANCE.a();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.media.detail.QQGuildMediaChannelDetailFragment$registerObservers$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                GuildChannelDetailHeadViewNew guildChannelDetailHeadViewNew = QQGuildMediaChannelDetailFragment.this.mChannelDetailHeadViewNew;
                if (guildChannelDetailHeadViewNew != null) {
                    guildChannelDetailHeadViewNew.setGuildDetailAudioIcon();
                }
            }
        };
        a16.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.media.detail.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQGuildMediaChannelDetailFragment.Jh(Function1.this, obj);
            }
        });
        com.tencent.mobileqq.guild.media.core.j.a().l0().b(this.mMediaChannelObserver);
        QQGuildMediaChannelDetailListView qQGuildMediaChannelDetailListView = this.mMemberListView;
        if (qQGuildMediaChannelDetailListView != null) {
            qQGuildMediaChannelDetailListView.M();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Jh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void Kh() {
        ch.Y0(this.mSettingView, "em_sgrp_set", ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_NONE);
        HashMap hashMap = new HashMap();
        hashMap.putAll(com.tencent.mobileqq.guild.media.core.j.a().f0().O());
        hashMap.put("dt_pgid", "pg_sgrp_sub_channel_info");
        VideoReport.reportEvent("clck", this.mSettingView, hashMap);
    }

    private final void Lh() {
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(this.E, "pg_sgrp_sub_channel_info");
        HashMap hashMap = new HashMap();
        hashMap.putAll(com.tencent.mobileqq.guild.media.core.j.a().f0().O());
        VideoReport.setPageParams(this.E, new PageParams(hashMap));
    }

    private final void Mh() {
        if (getAppInterface() != null) {
            ((IGPSService) getAppInterface().getRuntimeService(IGPSService.class, "")).deleteObserver(this.mGPServiceObserver);
        }
        com.tencent.mobileqq.guild.media.core.j.a().l0().B(this.mMediaChannelObserver);
        QQGuildMediaChannelDetailListView qQGuildMediaChannelDetailListView = this.mMemberListView;
        if (qQGuildMediaChannelDetailListView != null) {
            qQGuildMediaChannelDetailListView.O();
        }
    }

    private final void initData() {
        IGProChannelInfo iGProChannelInfo = this.mChannelInfo;
        boolean z16 = true;
        if (iGProChannelInfo == null) {
            QLog.e("QQGuildMediaChannelDetailFragment", 1, "initData but mChannelInfo == null");
            return;
        }
        Intrinsics.checkNotNull(iGProChannelInfo);
        if (iGProChannelInfo.getFinalMsgNotify() != 1) {
            z16 = false;
        }
        this.isMsgNotifyOpen = z16;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x007e, code lost:
    
        if (com.tencent.mobileqq.guild.util.bw.f235485a.R() == false) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void initView() {
        int i3;
        IGProChannelInfo iGProChannelInfo = this.mChannelInfo;
        if (iGProChannelInfo == null) {
            Dh();
            return;
        }
        Intrinsics.checkNotNull(iGProChannelInfo);
        rh(iGProChannelInfo.getChannelName(), this.isMsgNotifyOpen);
        RelativeLayout relativeLayout = this.D;
        if (relativeLayout != null) {
            TextView textView = (TextView) relativeLayout.findViewById(R.id.w1n);
            this.mSettingView = textView;
            int i16 = 0;
            if (textView != null) {
                IGProChannelInfo iGProChannelInfo2 = this.mChannelInfo;
                Intrinsics.checkNotNull(iGProChannelInfo2);
                if (as.j(iGProChannelInfo2)) {
                    i3 = 0;
                } else {
                    i3 = 8;
                }
                textView.setVisibility(i3);
            }
            TextView textView2 = this.mSettingView;
            if (textView2 != null) {
                textView2.setTextColor(textView2.getResources().getColor(R.color.f158017al3));
            }
            TextView textView3 = this.mSettingView;
            if (textView3 != null) {
                textView3.setOnClickListener(this);
            }
            View findViewById = this.D.findViewById(R.id.f165620x00);
            this.mSettingRedDot = findViewById;
            if (findViewById != null) {
                IGProChannelInfo iGProChannelInfo3 = this.mChannelInfo;
                Intrinsics.checkNotNull(iGProChannelInfo3);
                if (as.j(iGProChannelInfo3)) {
                    IGProChannelInfo iGProChannelInfo4 = this.mChannelInfo;
                    Intrinsics.checkNotNull(iGProChannelInfo4);
                    if (iGProChannelInfo4.getType() == 2) {
                    }
                }
                i16 = 8;
                findViewById.setVisibility(i16);
            }
            RelativeLayout mTitleRoot = this.D;
            Intrinsics.checkNotNullExpressionValue(mTitleRoot, "mTitleRoot");
            Eh(mTitleRoot);
        }
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        GuildChannelDetailHeadViewNew guildChannelDetailHeadViewNew = new GuildChannelDetailHeadViewNew(requireActivity, this.mGuildInfo, this.mChannelInfo, this.mChatPieContainerType, GuildChannelDetailHeadViewStyle.STYLE_NIGHT);
        this.mChannelDetailHeadViewNew = guildChannelDetailHeadViewNew;
        View mContentView = this.E;
        Intrinsics.checkNotNullExpressionValue(mContentView, "mContentView");
        guildChannelDetailHeadViewNew.setContentView(mContentView);
        QQGuildMediaChannelDetailListView qQGuildMediaChannelDetailListView = (QQGuildMediaChannelDetailListView) this.E.findViewById(R.id.wpu);
        this.mMemberListView = qQGuildMediaChannelDetailListView;
        if (qQGuildMediaChannelDetailListView != null) {
            ViewTreeViewModelStoreOwner.set(qQGuildMediaChannelDetailListView, this);
            ViewTreeLifecycleOwner.set(qQGuildMediaChannelDetailListView, this);
            GuildChannelDetailHeadViewNew guildChannelDetailHeadViewNew2 = this.mChannelDetailHeadViewNew;
            Intrinsics.checkNotNull(guildChannelDetailHeadViewNew2);
            qQGuildMediaChannelDetailListView.I(guildChannelDetailHeadViewNew2);
            qQGuildMediaChannelDetailListView.F(this.mediaMemberClick);
        }
        Hh(this.mGuildInfo, this.mChannelInfo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.setting.channeldetails.QQGuildPaddingImmerseTitleBarFragment
    public void doOnCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.doOnCreateView(inflater, container, savedInstanceState);
        initData();
        initView();
        Ih();
        Lh();
        GuildSplitViewUtils.f235370a.B(this.D);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.setting.channeldetails.QQGuildPaddingImmerseTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.ey8;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (Intrinsics.areEqual(v3, this.mSettingView)) {
            Gh();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mGuildId = arguments.getString("extra_guild_id");
            this.mChannelId = arguments.getString("extra_channel_id");
            this.mIsWithoutMainframe = arguments.getBoolean("START_WITHOUT_MAIN_FRAME", false);
            this.mChatPieContainerType = arguments.getInt("extra_key_chatpie_container", 0);
            if (getAppInterface() != null) {
                this.mGuildInfo = ch.L(this.mGuildId);
                this.mChannelInfo = ch.C(getAppInterface(), this.mGuildId, this.mChannelId);
            }
            if (this.mChannelInfo == null) {
                QLog.d("QQGuildMediaChannelDetailFragment", 1, "mChannelInfo is null");
                Dh();
            }
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        QLog.i("QQGuildMediaChannelDetailFragment", 1, "onDestroy !!");
        Mh();
        bw.f235485a.M0(false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        Mh();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Ch();
    }

    @Override // com.tencent.mobileqq.guild.setting.channeldetails.QQGuildPaddingImmerseTitleBarFragment
    protected void qh() {
        this.C.setBarStyle(GuildChannelBaseNavBarStyle.STYLE_NIGHT);
        this.C.setBackgroundColor(ie0.a.f().g(getContext(), R.color.qui_common_bg_nav_secondary, 1002));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.setting.channeldetails.QQGuildPaddingImmerseTitleBarFragment
    public void rh(@Nullable CharSequence title, boolean isMsgNotifyOpen) {
        super.rh(title, true);
    }
}
