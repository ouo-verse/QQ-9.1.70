package com.tencent.mobileqq.guild.setting.channeldetails;

import android.app.Activity;
import android.content.Context;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.guildmedia.api.IGuildMediaAioApi;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.data.GuildSharePageSource;
import com.tencent.mobileqq.guild.media.core.RefreshType;
import com.tencent.mobileqq.guild.media.core.j;
import com.tencent.mobileqq.guild.media.dialog.modedialog.ModeChooseDialog;
import com.tencent.mobileqq.guild.robot.components.audio.AudioRobotListFragment;
import com.tencent.mobileqq.guild.setting.channelsubscribe.GuildConfirmSubscribeDialogFragment;
import com.tencent.mobileqq.guild.setting.subscribe.recommend.GuildSubscribeSuccessDialogFragment;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.az;
import com.tencent.mobileqq.guild.util.bw;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pad.m;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.type.IChannelType;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vh2.cc;
import vp1.v;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00062\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u0081\u0001B\u0011\b\u0016\u0012\u0006\u0010u\u001a\u00020t\u00a2\u0006\u0004\bv\u0010wB\u001b\b\u0016\u0012\u0006\u0010u\u001a\u00020t\u0012\b\u0010y\u001a\u0004\u0018\u00010x\u00a2\u0006\u0004\bv\u0010zB#\b\u0016\u0012\u0006\u0010u\u001a\u00020t\u0012\b\u0010y\u001a\u0004\u0018\u00010x\u0012\u0006\u0010{\u001a\u00020\u0011\u00a2\u0006\u0004\bv\u0010|B+\b\u0016\u0012\u0006\u0010u\u001a\u00020t\u0012\b\u0010y\u001a\u0004\u0018\u00010x\u0012\u0006\u0010{\u001a\u00020\u0011\u0012\u0006\u0010}\u001a\u00020\u0011\u00a2\u0006\u0004\bv\u0010~B8\b\u0017\u0012\u0006\u0010u\u001a\u00020t\u0012\b\u0010A\u001a\u0004\u0018\u00010@\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010Q\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u007f\u001a\u00020l\u00a2\u0006\u0005\bv\u0010\u0080\u0001J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0012\u0010\u000f\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\u0012\u0010\u0010\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\u001a\u0010\u0013\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0012\u0010\u0014\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\u0012\u0010\u0015\u001a\u00020\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\nH\u0002J\b\u0010\u0018\u001a\u00020\nH\u0002J\u0012\u0010\u0019\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\u0012\u0010\u001a\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\nH\u0002J\u0012\u0010\u001d\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\nH\u0002J\u0010\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 H\u0002J\u0010\u0010#\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 H\u0002J\b\u0010$\u001a\u00020\u0004H\u0002J\u0010\u0010&\u001a\u00020%2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010'\u001a\u00020\u0004H\u0002J\b\u0010(\u001a\u00020\u0004H\u0002J\b\u0010)\u001a\u00020\u0004H\u0002J\b\u0010*\u001a\u00020\u0004H\u0002J\b\u0010+\u001a\u00020\nH\u0002J\b\u0010,\u001a\u00020\u0004H\u0002J\u0010\u0010/\u001a\u00020\u00042\u0006\u0010.\u001a\u00020-H\u0002J\b\u00100\u001a\u00020\u0004H\u0002J\u0010\u00103\u001a\u0002022\u0006\u00101\u001a\u00020\nH\u0002J\u001a\u00106\u001a\u00020\u00042\u0006\u00101\u001a\u00020\n2\b\u00105\u001a\u0004\u0018\u000104H\u0002J\u0012\u00107\u001a\u00020\u00042\b\u00105\u001a\u0004\u0018\u000104H\u0002J\u0010\u00108\u001a\u00020\u00042\u0006\u00101\u001a\u00020\nH\u0002J\u0012\u00109\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010:\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 H\u0002J\b\u0010;\u001a\u00020\u0004H\u0002J\u0018\u0010>\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 2\u0006\u0010=\u001a\u00020<H\u0002J\u0010\u0010?\u001a\u00020\u00042\u0006\u00101\u001a\u00020\nH\u0002J\u001e\u0010B\u001a\u00020\u00042\n\b\u0002\u0010A\u001a\u0004\u0018\u00010@2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u0006\u0010C\u001a\u00020\u0004J\u0012\u0010D\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010 H\u0016J\u000e\u0010E\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 J\b\u0010G\u001a\u0004\u0018\u00010FJ\u0012\u0010H\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010 H\u0016R\u0018\u0010A\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010N\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010BR\u0016\u0010P\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010OR\u0016\u0010Q\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u0010BR\u0016\u0010S\u001a\u00020\u00018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010RR\u0016\u0010T\u001a\u00020\u00018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010RR\u0016\u0010U\u001a\u00020\u00018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u0010RR\u0016\u0010V\u001a\u00020\u00018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010RR\u0016\u0010W\u001a\u00020\u00018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010RR\u0016\u0010X\u001a\u00020\u00018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u0010RR\u0016\u0010Z\u001a\u00020\u00018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bY\u0010RR\u0016\u0010[\u001a\u00020\u00018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bB\u0010RR\u0016\u0010\\\u001a\u00020\u00018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b?\u0010RR\u0016\u0010]\u001a\u00020\u00018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b>\u0010RR\u0016\u0010`\u001a\u00020^8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u0010_R\u0016\u0010a\u001a\u00020^8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010_R\u0016\u0010b\u001a\u00020^8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u0010_R\u0016\u0010c\u001a\u00020^8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010_R\u0016\u0010e\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010dR\u0014\u0010h\u001a\u00020f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010gR\u0016\u0010j\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bi\u0010OR\u0016\u0010k\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010OR*\u0010s\u001a\u00020l2\u0006\u0010m\u001a\u00020l8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010n\u001a\u0004\bo\u0010p\"\u0004\bq\u0010r\u00a8\u0006\u0082\u0001"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/channeldetails/GuildChannelDetailHeadViewNew;", "Landroid/widget/LinearLayout;", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnLongClickListener;", "", "u", "V", "Y", "T", "W", "", "isInTextChannel", "X", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "channelInfo", BdhLogUtil.LogTag.Tag_Conn, "B", "", QCircleLpReportDc010001.KEY_SUBTYPE, "v", HippyTKDListViewAdapter.X, "l", "isSubscribe", "M", "E", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "isSupportUpTop", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "y", "isSupportInvite", "P", "Landroid/view/View;", "view", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "t", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "g", ReportConstant.COSTREPORT_PREFIX, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", "U", UserInfo.SEX_FEMALE, BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/guild/setting/channelsubscribe/GuildConfirmSubscribeDialogFragment;", "frag", "N", tl.h.F, "isChecked", "Lvh2/cc;", "i", "Landroidx/fragment/app/FragmentManager;", "fm", "o", "G", "D", "w", "r", "L", "", "id", "K", "J", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "I", "setGuildDetailAudioIcon", NodeProps.ON_CLICK, "setContentView", "Lcom/tencent/common/app/AppInterface;", "k", NodeProps.ON_LONG_CLICK, "d", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "e", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "f", "msgNotifyType", "Z", "isChannelSubscribe", "chatPieContainerType", "Landroid/widget/LinearLayout;", "guildDetailUpTopContainer", "guildDetailSubscribeContainer", "guildDetailInviteContainer", "guildDetailOnlyInviteContainer", "guildDetailAudioContainer", "guildDetailRobotContainer", "H", "guildDetailSettingContainer", "guildDetailReportContainer", "guildDetailTextChannelOperateRoot", "guildDetailOperateRoot", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "guildDetailSubscribeIcon", "guildDetailSubscribeRedDot", "guildDetailAudioIcon", "guildDetailAudioIconRedDot", "Landroid/view/View;", "contentView", "Lvp1/v;", "Lvp1/v;", "viewBinding", ExifInterface.LATITUDE_SOUTH, "mHasRemaingAtCount", "mGuildAtallSwitchOpen", "Lcom/tencent/mobileqq/guild/setting/channeldetails/GuildChannelDetailHeadViewStyle;", "value", "Lcom/tencent/mobileqq/guild/setting/channeldetails/GuildChannelDetailHeadViewStyle;", "getMStyle", "()Lcom/tencent/mobileqq/guild/setting/channeldetails/GuildChannelDetailHeadViewStyle;", "setMStyle", "(Lcom/tencent/mobileqq/guild/setting/channeldetails/GuildChannelDetailHeadViewStyle;)V", "mStyle", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "style", "(Landroid/content/Context;Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;ILcom/tencent/mobileqq/guild/setting/channeldetails/GuildChannelDetailHeadViewStyle;)V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildChannelDetailHeadViewNew extends LinearLayout implements View.OnClickListener, View.OnLongClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    private LinearLayout guildDetailSubscribeContainer;

    /* renamed from: D, reason: from kotlin metadata */
    private LinearLayout guildDetailInviteContainer;

    /* renamed from: E, reason: from kotlin metadata */
    private LinearLayout guildDetailOnlyInviteContainer;

    /* renamed from: F, reason: from kotlin metadata */
    private LinearLayout guildDetailAudioContainer;

    /* renamed from: G, reason: from kotlin metadata */
    private LinearLayout guildDetailRobotContainer;

    /* renamed from: H, reason: from kotlin metadata */
    private LinearLayout guildDetailSettingContainer;

    /* renamed from: I, reason: from kotlin metadata */
    private LinearLayout guildDetailReportContainer;

    /* renamed from: J, reason: from kotlin metadata */
    private LinearLayout guildDetailTextChannelOperateRoot;

    /* renamed from: K, reason: from kotlin metadata */
    private LinearLayout guildDetailOperateRoot;

    /* renamed from: L, reason: from kotlin metadata */
    private ImageView guildDetailSubscribeIcon;

    /* renamed from: M, reason: from kotlin metadata */
    private ImageView guildDetailSubscribeRedDot;

    /* renamed from: N, reason: from kotlin metadata */
    private ImageView guildDetailAudioIcon;

    /* renamed from: P, reason: from kotlin metadata */
    private ImageView guildDetailAudioIconRedDot;

    /* renamed from: Q, reason: from kotlin metadata */
    private View contentView;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final v viewBinding;

    /* renamed from: S, reason: from kotlin metadata */
    private boolean mHasRemaingAtCount;

    /* renamed from: T, reason: from kotlin metadata */
    private boolean mGuildAtallSwitchOpen;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private GuildChannelDetailHeadViewStyle mStyle;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IGProGuildInfo guildInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IGProChannelInfo channelInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int msgNotifyType;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isChannelSubscribe;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int chatPieContainerType;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private LinearLayout guildDetailUpTopContainer;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GuildChannelDetailHeadViewNew(@NotNull Context context) {
        this(context, null, 0, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final boolean A(IGProChannelInfo channelInfo) {
        if ((channelInfo == null || (channelInfo.getType() != 7 && channelInfo.getType() != 6)) && !x(channelInfo)) {
            return true;
        }
        return false;
    }

    private final boolean B(IGProChannelInfo channelInfo) {
        if (channelInfo == null || channelInfo.getType() != 1) {
            return false;
        }
        return true;
    }

    private final boolean C(IGProChannelInfo channelInfo) {
        if (channelInfo == null || channelInfo.getType() != 2) {
            return false;
        }
        return true;
    }

    private final void D(boolean isChecked) {
        int i3;
        if (isChecked) {
            i3 = R.string.f141020fj;
        } else {
            i3 = R.string.f141880hv;
        }
        QQToast.makeText(BaseApplication.getContext(), 2, i3, 0).show();
    }

    private final boolean E() {
        IGPSService iGPSService;
        AppInterface k3 = k();
        if (k3 != null && (iGPSService = (IGPSService) k3.getRuntimeService(IGPSService.class, "")) != null) {
            if (!iGPSService.getQQMsgListChannels().isEmpty()) {
                bw.S0();
                return false;
            }
            String[] showRedDotVersions = GuildConfirmSubscribeDialogFragment.L;
            Intrinsics.checkNotNullExpressionValue(showRedDotVersions, "showRedDotVersions");
            for (String str : showRedDotVersions) {
                if (str.equals(AppSetting.f99551k)) {
                    return !bw.s0();
                }
            }
        }
        return false;
    }

    private final boolean F() {
        if (!this.isChannelSubscribe && !bw.r0()) {
            return true;
        }
        return false;
    }

    private final void G(FragmentManager fm5) {
        if (bw.o0()) {
            D(true);
            return;
        }
        bw.W1();
        if (fm5 != null) {
            GuildSubscribeSuccessDialogFragment.Ph(fm5, new Runnable() { // from class: com.tencent.mobileqq.guild.setting.channeldetails.d
                @Override // java.lang.Runnable
                public final void run() {
                    GuildChannelDetailHeadViewNew.H(GuildChannelDetailHeadViewNew.this);
                }
            }, 0);
        } else {
            D(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(GuildChannelDetailHeadViewNew this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.C(this$0.channelInfo)) {
            this$0.h();
        }
    }

    private final void J(boolean isChecked) {
        int i3;
        HashMap hashMap = new HashMap();
        if (isChecked) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        hashMap.put("sgrp_sub_channel_switch", Integer.valueOf(i3));
        LinearLayout linearLayout = this.guildDetailSubscribeContainer;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildDetailSubscribeContainer");
            linearLayout = null;
        }
        VideoReport.reportEvent("clck", linearLayout, hashMap);
    }

    private final void K(View view, String id5) {
        VideoReport.setElementId(view, id5);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
    }

    private final void L() {
        LinearLayout linearLayout;
        String str;
        String str2;
        LinearLayout linearLayout2 = null;
        if (B(this.channelInfo)) {
            linearLayout = this.guildDetailTextChannelOperateRoot;
            if (linearLayout == null) {
                str = "guildDetailTextChannelOperateRoot";
                Intrinsics.throwUninitializedPropertyAccessException(str);
                linearLayout = null;
            }
        } else {
            linearLayout = this.guildDetailUpTopContainer;
            if (linearLayout == null) {
                str = "guildDetailUpTopContainer";
                Intrinsics.throwUninitializedPropertyAccessException(str);
                linearLayout = null;
            }
        }
        ClickPolicy clickPolicy = ClickPolicy.REPORT_NONE;
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_ALL;
        ch.T0(linearLayout, "em_sgrp_announcement", clickPolicy, exposurePolicy, null);
        IGProChannelInfo iGProChannelInfo = this.channelInfo;
        boolean z16 = false;
        if (iGProChannelInfo != null && iGProChannelInfo.getType() == 1) {
            z16 = true;
        }
        if (z16) {
            LinearLayout linearLayout3 = this.guildDetailInviteContainer;
            if (linearLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildDetailInviteContainer");
                linearLayout3 = null;
            }
            ch.T0(linearLayout3, "em_sgrp_subchannel_top_invite", clickPolicy, exposurePolicy, null);
        } else {
            LinearLayout linearLayout4 = this.guildDetailInviteContainer;
            if (linearLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildDetailInviteContainer");
                linearLayout4 = null;
            }
            K(linearLayout4, "em_sgrp_invite");
        }
        LinearLayout linearLayout5 = this.guildDetailOnlyInviteContainer;
        if (linearLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildDetailOnlyInviteContainer");
            linearLayout5 = null;
        }
        K(linearLayout5, "em_sgrp_invite");
        if (this.channelInfo == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        if (C(this.channelInfo)) {
            hashMap.putAll(j.a().f0().O());
        }
        IGProChannelInfo iGProChannelInfo2 = this.channelInfo;
        Intrinsics.checkNotNull(iGProChannelInfo2);
        String channelUin = iGProChannelInfo2.getChannelUin();
        Intrinsics.checkNotNullExpressionValue(channelUin, "channelInfo!!.channelUin");
        hashMap.put("sgrp_sub_channel_id", channelUin);
        IGProChannelInfo iGProChannelInfo3 = this.channelInfo;
        Intrinsics.checkNotNull(iGProChannelInfo3);
        hashMap.put("sgrp_sub_channel_type", Integer.valueOf(iGProChannelInfo3.getType()));
        hashMap.put("dt_pgid", "pg_sgrp_sub_channel_info");
        if (this.isChannelSubscribe) {
            str2 = "1";
        } else {
            str2 = "2";
        }
        LinearLayout linearLayout6 = this.guildDetailSubscribeContainer;
        if (linearLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildDetailSubscribeContainer");
            linearLayout6 = null;
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.putAll(hashMap);
        hashMap2.put("sgrp_sub_channel_switch", str2);
        Unit unit = Unit.INSTANCE;
        ch.T0(linearLayout6, "em_sgrp_add_shortcut", clickPolicy, exposurePolicy, hashMap2);
        LinearLayout linearLayout7 = this.guildDetailAudioContainer;
        if (linearLayout7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildDetailAudioContainer");
            linearLayout7 = null;
        }
        ch.T0(linearLayout7, "em_sgrp_audio_quality", clickPolicy, exposurePolicy, hashMap);
        LinearLayout linearLayout8 = this.guildDetailRobotContainer;
        if (linearLayout8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildDetailRobotContainer");
            linearLayout8 = null;
        }
        ch.T0(linearLayout8, "em_sgrp_more_bot", clickPolicy, exposurePolicy, hashMap);
        LinearLayout linearLayout9 = this.guildDetailSettingContainer;
        if (linearLayout9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildDetailSettingContainer");
        } else {
            linearLayout2 = linearLayout9;
        }
        ch.T0(linearLayout2, "em_sgrp_set", clickPolicy, exposurePolicy, hashMap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v4, types: [android.widget.LinearLayout] */
    private final void M(boolean isSubscribe) {
        int i3 = 8;
        ImageView imageView = null;
        if (!z(this.channelInfo)) {
            ?? r85 = this.guildDetailSubscribeContainer;
            if (r85 == 0) {
                Intrinsics.throwUninitializedPropertyAccessException("guildDetailSubscribeContainer");
            } else {
                imageView = r85;
            }
            imageView.setVisibility(8);
            return;
        }
        LinearLayout linearLayout = this.guildDetailSubscribeContainer;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildDetailSubscribeContainer");
            linearLayout = null;
        }
        linearLayout.setVisibility(0);
        GuildChannelDetailHeadViewStyle guildChannelDetailHeadViewStyle = this.mStyle;
        ImageView imageView2 = this.guildDetailSubscribeIcon;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildDetailSubscribeIcon");
            imageView2 = null;
        }
        TextView textView = this.viewBinding.f443120s;
        Intrinsics.checkNotNullExpressionValue(textView, "viewBinding.guildDetailSettingTv");
        guildChannelDetailHeadViewStyle.setGuildDetailSubscribeIcon(imageView2, textView, isSubscribe);
        ImageView imageView3 = this.guildDetailSubscribeRedDot;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildDetailSubscribeRedDot");
        } else {
            imageView = imageView3;
        }
        if (E()) {
            i3 = 0;
        }
        imageView.setVisibility(i3);
    }

    private final void N(GuildConfirmSubscribeDialogFragment frag) {
        if (!C(this.channelInfo)) {
            return;
        }
        frag.Dh(new Runnable() { // from class: com.tencent.mobileqq.guild.setting.channeldetails.c
            @Override // java.lang.Runnable
            public final void run() {
                GuildChannelDetailHeadViewNew.O(GuildChannelDetailHeadViewNew.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(GuildChannelDetailHeadViewNew this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.h();
    }

    private final void P(boolean isSupportInvite) {
        int i3;
        LinearLayout linearLayout = this.guildDetailInviteContainer;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildDetailInviteContainer");
            linearLayout = null;
        }
        if (isSupportInvite) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        linearLayout.setVisibility(i3);
        GuildChannelDetailHeadViewStyle guildChannelDetailHeadViewStyle = this.mStyle;
        ImageView imageView = this.viewBinding.f443107f;
        Intrinsics.checkNotNullExpressionValue(imageView, "viewBinding.guildDetailMemberInviteIcon");
        TextView textView = this.viewBinding.f443108g;
        Intrinsics.checkNotNullExpressionValue(textView, "viewBinding.guildDetailMemberInviteTv");
        guildChannelDetailHeadViewStyle.bindShareIcon(imageView, textView);
    }

    private final void Q(boolean isSupportUpTop) {
        int i3;
        LinearLayout linearLayout = this.guildDetailUpTopContainer;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildDetailUpTopContainer");
            linearLayout = null;
        }
        if (isSupportUpTop) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        linearLayout.setVisibility(i3);
    }

    private final void R() {
        FragmentActivity fragmentActivity;
        FragmentManager fragmentManager;
        String str;
        Context context = getContext();
        String str2 = null;
        if (context instanceof FragmentActivity) {
            fragmentActivity = (FragmentActivity) context;
        } else {
            fragmentActivity = null;
        }
        if (fragmentActivity != null) {
            fragmentManager = fragmentActivity.getSupportFragmentManager();
        } else {
            fragmentManager = null;
        }
        if (fragmentManager != null) {
            IGProChannelInfo iGProChannelInfo = this.channelInfo;
            if (iGProChannelInfo != null) {
                str = iGProChannelInfo.getGuildId();
            } else {
                str = null;
            }
            IGProChannelInfo iGProChannelInfo2 = this.channelInfo;
            if (iGProChannelInfo2 != null) {
                str2 = iGProChannelInfo2.getChannelUin();
            }
            GuildConfirmSubscribeDialogFragment Gh = GuildConfirmSubscribeDialogFragment.Gh(fragmentManager, str, str2, new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.channeldetails.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildChannelDetailHeadViewNew.S(GuildChannelDetailHeadViewNew.this, view);
                }
            });
            Intrinsics.checkNotNullExpressionValue(Gh, "this");
            N(Gh);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(GuildChannelDetailHeadViewNew this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.U();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void T() {
        LinearLayout linearLayout = this.guildDetailRobotContainer;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildDetailRobotContainer");
            linearLayout = null;
        }
        linearLayout.setVisibility(0);
        GuildChannelDetailHeadViewStyle guildChannelDetailHeadViewStyle = this.mStyle;
        ImageView imageView = this.viewBinding.f443115n;
        Intrinsics.checkNotNullExpressionValue(imageView, "viewBinding.guildDetailRobotIcon");
        TextView textView = this.viewBinding.f443117p;
        Intrinsics.checkNotNullExpressionValue(textView, "viewBinding.guildDetailRobotTv");
        guildChannelDetailHeadViewStyle.bindRobotIcon(imageView, textView);
    }

    private final void U() {
        AppInterface k3 = k();
        if (k3 == null) {
            return;
        }
        int i3 = 1;
        this.isChannelSubscribe = !this.isChannelSubscribe;
        IRuntimeService runtimeService = k3.getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appInterface.getRuntimeS\u2026va, ProcessConstant.MAIN)");
        IGPSService iGPSService = (IGPSService) runtimeService;
        if (!this.isChannelSubscribe) {
            i3 = 2;
        }
        IGProChannelInfo iGProChannelInfo = this.channelInfo;
        Intrinsics.checkNotNull(iGProChannelInfo);
        String guildId = iGProChannelInfo.getGuildId();
        Intrinsics.checkNotNullExpressionValue(guildId, "channelInfo!!.guildId");
        IGProChannelInfo iGProChannelInfo2 = this.channelInfo;
        Intrinsics.checkNotNull(iGProChannelInfo2);
        String channelUin = iGProChannelInfo2.getChannelUin();
        Intrinsics.checkNotNullExpressionValue(channelUin, "channelInfo!!.channelUin");
        iGPSService.setQQMsgListChannel(guildId, channelUin, i3, i(this.isChannelSubscribe));
    }

    private final void V() {
        LinearLayout linearLayout = this.guildDetailUpTopContainer;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildDetailUpTopContainer");
            linearLayout = null;
        }
        Object parent = linearLayout.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
        ((View) parent).getLayoutParams().height = 0;
        X(false);
    }

    private final void W() {
        X(false);
        LinearLayout linearLayout = this.guildDetailUpTopContainer;
        LinearLayout linearLayout2 = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildDetailUpTopContainer");
            linearLayout = null;
        }
        Object parent = linearLayout.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
        ((View) parent).setPadding(ViewUtils.dip2px(20.0f), ViewUtils.dip2px(13.0f), ViewUtils.dip2px(20.0f), 0);
        LinearLayout linearLayout3 = this.guildDetailUpTopContainer;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildDetailUpTopContainer");
            linearLayout3 = null;
        }
        linearLayout3.setVisibility(8);
        LinearLayout linearLayout4 = this.guildDetailSubscribeContainer;
        if (linearLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildDetailSubscribeContainer");
            linearLayout4 = null;
        }
        linearLayout4.setVisibility(0);
        P(true);
        LinearLayout linearLayout5 = this.guildDetailOnlyInviteContainer;
        if (linearLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildDetailOnlyInviteContainer");
            linearLayout5 = null;
        }
        linearLayout5.setVisibility(8);
        LinearLayout linearLayout6 = this.guildDetailAudioContainer;
        if (linearLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildDetailAudioContainer");
            linearLayout6 = null;
        }
        linearLayout6.setVisibility(8);
        LinearLayout linearLayout7 = this.guildDetailRobotContainer;
        if (linearLayout7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildDetailRobotContainer");
        } else {
            linearLayout2 = linearLayout7;
        }
        linearLayout2.setVisibility(8);
    }

    private final void X(boolean isInTextChannel) {
        int i3;
        LinearLayout linearLayout = this.guildDetailOperateRoot;
        LinearLayout linearLayout2 = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildDetailOperateRoot");
            linearLayout = null;
        }
        int i16 = 8;
        if (isInTextChannel) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        linearLayout.setVisibility(i3);
        LinearLayout linearLayout3 = this.guildDetailTextChannelOperateRoot;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildDetailTextChannelOperateRoot");
        } else {
            linearLayout2 = linearLayout3;
        }
        if (isInTextChannel) {
            i16 = 0;
        }
        linearLayout2.setVisibility(i16);
    }

    private final void Y() {
        X(false);
        LinearLayout linearLayout = this.guildDetailUpTopContainer;
        ImageView imageView = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildDetailUpTopContainer");
            linearLayout = null;
        }
        Object parent = linearLayout.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
        ((View) parent).setPadding(ViewUtils.dip2px(9.0f), ViewUtils.dip2px(24.0f), ViewUtils.dip2px(9.0f), 0);
        LinearLayout linearLayout2 = this.guildDetailUpTopContainer;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildDetailUpTopContainer");
            linearLayout2 = null;
        }
        linearLayout2.setVisibility(0);
        LinearLayout linearLayout3 = this.guildDetailUpTopContainer;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildDetailUpTopContainer");
            linearLayout3 = null;
        }
        TextView textView = (TextView) linearLayout3.findViewById(R.id.w48);
        textView.setText(textView.getContext().getText(R.string.f141060fn));
        GuildChannelDetailHeadViewStyle guildChannelDetailHeadViewStyle = this.mStyle;
        ImageView imageView2 = this.viewBinding.f443125x;
        Intrinsics.checkNotNullExpressionValue(imageView2, "viewBinding.guildDetailUptopIcon");
        TextView textView2 = this.viewBinding.f443127z;
        Intrinsics.checkNotNullExpressionValue(textView2, "viewBinding.guildDetailUptopTv");
        guildChannelDetailHeadViewStyle.bindUpTopIcon(imageView2, textView2, R.drawable.guild_detail_channel_announce_icon);
        LinearLayout linearLayout4 = this.guildDetailSubscribeContainer;
        if (linearLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildDetailSubscribeContainer");
            linearLayout4 = null;
        }
        linearLayout4.setVisibility(0);
        LinearLayout linearLayout5 = this.guildDetailInviteContainer;
        if (linearLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildDetailInviteContainer");
            linearLayout5 = null;
        }
        linearLayout5.setVisibility(8);
        T();
        LinearLayout linearLayout6 = this.guildDetailOnlyInviteContainer;
        if (linearLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildDetailOnlyInviteContainer");
            linearLayout6 = null;
        }
        linearLayout6.setVisibility(8);
        LinearLayout linearLayout7 = this.guildDetailAudioContainer;
        if (linearLayout7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildDetailAudioContainer");
            linearLayout7 = null;
        }
        linearLayout7.setVisibility(0);
        LinearLayout linearLayout8 = this.guildDetailSettingContainer;
        if (linearLayout8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildDetailSettingContainer");
            linearLayout8 = null;
        }
        linearLayout8.setVisibility(8);
        setGuildDetailAudioIcon();
        if (bw.f235485a.l()) {
            ImageView imageView3 = this.guildDetailAudioIconRedDot;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildDetailAudioIconRedDot");
            } else {
                imageView = imageView3;
            }
            imageView.setVisibility(0);
            return;
        }
        ImageView imageView4 = this.guildDetailAudioIconRedDot;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildDetailAudioIconRedDot");
        } else {
            imageView = imageView4;
        }
        imageView.setVisibility(8);
    }

    private final Contact g(IGProChannelInfo channelInfo) {
        Contact contact = new Contact();
        contact.guildId = channelInfo.getGuildId();
        contact.peerUid = channelInfo.getChannelUin();
        return contact;
    }

    private final void h() {
        Activity activity;
        j.a().D("", "go to conversation tab");
        Context context = getContext();
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (activity == null) {
            return;
        }
        if (AppSetting.t(activity)) {
            m.a(activity);
        } else {
            activity.finish();
        }
    }

    private final cc i(final boolean isChecked) {
        FragmentActivity fragmentActivity;
        Context context = getContext();
        final FragmentManager fragmentManager = null;
        if (context instanceof FragmentActivity) {
            fragmentActivity = (FragmentActivity) context;
        } else {
            fragmentActivity = null;
        }
        if (fragmentActivity != null) {
            fragmentManager = fragmentActivity.getSupportFragmentManager();
        }
        return new cc() { // from class: com.tencent.mobileqq.guild.setting.channeldetails.a
            @Override // vh2.cc
            public final void onResult(int i3, String str) {
                GuildChannelDetailHeadViewNew.j(GuildChannelDetailHeadViewNew.this, isChecked, fragmentManager, i3, str);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(GuildChannelDetailHeadViewNew this$0, boolean z16, FragmentManager fragmentManager, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 != 0) {
            if (i3 != 110000) {
                QQToast.makeText(BaseApplication.getContext(), 1, R.string.f1511016s, 0).show();
                this$0.isChannelSubscribe = this$0.w(this$0.channelInfo);
                QLog.d("Guild.MF.End.GuildChannelDetailHeadViewNew", 1, "addToMsgList failed result=" + i3 + ", errMsg=" + str);
                return;
            }
            QQToast.makeText(BaseApplication.getContext(), 1, R.string.f141010fi, 0).show();
            this$0.isChannelSubscribe = this$0.w(this$0.channelInfo);
            return;
        }
        this$0.o(z16, fragmentManager);
    }

    private final int l(IGProChannelInfo channelInfo) {
        if (channelInfo != null) {
            return channelInfo.getFinalMsgNotify();
        }
        return 0;
    }

    private final void m(View view) {
        LinearLayout linearLayout = this.guildDetailAudioContainer;
        View view2 = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildDetailAudioContainer");
            linearLayout = null;
        }
        ch.Y0(linearLayout, "em_sgrp_audio_quality", ClickPolicy.REPORT_ALL, ExposurePolicy.REPORT_NONE);
        bw.f235485a.M0(false);
        ImageView imageView = this.guildDetailAudioIconRedDot;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildDetailAudioIconRedDot");
            imageView = null;
        }
        if (imageView.getVisibility() == 0) {
            ImageView imageView2 = this.guildDetailAudioIconRedDot;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildDetailAudioIconRedDot");
                imageView2 = null;
            }
            imageView2.setVisibility(8);
        }
        if (getContext() instanceof FragmentActivity) {
            ModeChooseDialog modeChooseDialog = new ModeChooseDialog();
            View view3 = this.contentView;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentView");
            } else {
                view2 = view3;
            }
            modeChooseDialog.uh(view2);
            Context context = getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
            FragmentManager supportFragmentManager = ((FragmentActivity) context).getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "context as FragmentActiv\u2026y).supportFragmentManager");
            com.tencent.mobileqq.guild.base.extension.d.a(modeChooseDialog, supportFragmentManager, "Guild.MF.End.GuildChannelDetailHeadViewNew");
            return;
        }
        QLog.d("Guild.MF.End.GuildChannelDetailHeadViewNew", 1, "handAutioClick open fail");
    }

    private final void n(View view) {
        String str;
        String str2;
        LinearLayout linearLayout = null;
        com.tencent.mobileqq.guild.performance.report.e.b("audio_room_add_robot_button", null, 0, null, 0, null, 62, null);
        if (getContext() instanceof FragmentActivity) {
            Context context = getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
            FragmentActivity fragmentActivity = (FragmentActivity) context;
            IGProChannelInfo iGProChannelInfo = this.channelInfo;
            if (iGProChannelInfo != null) {
                str = iGProChannelInfo.getChannelUin();
            } else {
                str = null;
            }
            IGProGuildInfo iGProGuildInfo = this.guildInfo;
            if (iGProGuildInfo != null) {
                str2 = iGProGuildInfo.getGuildID();
            } else {
                str2 = null;
            }
            AudioRobotListFragment.wh(fragmentActivity, str, str2, 1, new b());
        } else {
            QLog.d("Guild.MF.End.GuildChannelDetailHeadViewNew", 1, "handleAddRobot open fail");
        }
        LinearLayout linearLayout2 = this.guildDetailRobotContainer;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildDetailRobotContainer");
        } else {
            linearLayout = linearLayout2;
        }
        VideoReport.reportEvent("clck", linearLayout, new HashMap());
    }

    private final void o(boolean isChecked, FragmentManager fm5) {
        M(isChecked);
        if (!isChecked) {
            D(false);
        } else {
            G(fm5);
        }
    }

    private final void p() {
        String str;
        String str2;
        LinearLayout linearLayout = this.guildDetailReportContainer;
        LinearLayout linearLayout2 = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildDetailReportContainer");
            linearLayout = null;
        }
        ch.Y0(linearLayout, "em_sgrp_subchannel_report", ClickPolicy.REPORT_NONE, ExposurePolicy.REPORT_NONE);
        HashMap hashMap = new HashMap();
        IGProChannelInfo iGProChannelInfo = this.channelInfo;
        if (iGProChannelInfo != null) {
            str = iGProChannelInfo.getGuildId();
        } else {
            str = null;
        }
        hashMap.put("sgrp_channel_id_report", str);
        IGProChannelInfo iGProChannelInfo2 = this.channelInfo;
        if (iGProChannelInfo2 != null) {
            str2 = iGProChannelInfo2.getChannelUin();
        } else {
            str2 = null;
        }
        hashMap.put("sgrp_subchannel_id_report", str2);
        LinearLayout linearLayout3 = this.guildDetailReportContainer;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildDetailReportContainer");
        } else {
            linearLayout2 = linearLayout3;
        }
        VideoReport.reportEvent("clck", linearLayout2, hashMap);
    }

    private final void q() {
        LinearLayout linearLayout = this.guildDetailSettingContainer;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildDetailSettingContainer");
            linearLayout = null;
        }
        VideoReport.reportEvent("clck", linearLayout, new HashMap());
        IGProChannelInfo iGProChannelInfo = this.channelInfo;
        if (iGProChannelInfo != null) {
            ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).openGuildChannelInfoSetting(k(), getContext(), iGProChannelInfo.getGuildId(), iGProChannelInfo.getChannelUin(), 2);
        }
    }

    private final void r(View view) {
        IGProGuildInfo iGProGuildInfo;
        Integer num;
        GuildSharePageSource guildSharePageSource;
        VideoReport.reportEvent("clck", view, new HashMap());
        boolean z16 = true;
        if ((getContext() instanceof Activity) && (iGProGuildInfo = this.guildInfo) != null && this.channelInfo != null) {
            Intrinsics.checkNotNull(iGProGuildInfo);
            if (ch.C0(iGProGuildInfo.getCreatorId())) {
                IGProChannelInfo iGProChannelInfo = this.channelInfo;
                if (iGProChannelInfo != null) {
                    num = Integer.valueOf(iGProChannelInfo.getType());
                } else {
                    num = null;
                }
                if (num != null && num.intValue() == 1) {
                    guildSharePageSource = GuildSharePageSource.CHANNEL_DETAIL_TEXT;
                } else if (num != null && num.intValue() == 7) {
                    guildSharePageSource = GuildSharePageSource.CHANNEL_DETAIL_FEED;
                } else if (num != null && num.intValue() == 6) {
                    if (x(this.channelInfo)) {
                        guildSharePageSource = GuildSharePageSource.CHANNEL_DETAIL_SCHEDULE;
                    } else {
                        guildSharePageSource = GuildSharePageSource.SUB_CHANNEL_DETAIL;
                    }
                } else {
                    guildSharePageSource = GuildSharePageSource.SUB_CHANNEL_DETAIL;
                }
                Context context = getContext();
                Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
                IGProGuildInfo iGProGuildInfo2 = this.guildInfo;
                Intrinsics.checkNotNull(iGProGuildInfo2);
                new com.tencent.mobileqq.guild.share.m((Activity) context, iGProGuildInfo2, this.channelInfo, guildSharePageSource).z();
                return;
            }
        }
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            Logger.a d16 = logger.d();
            boolean z17 = !(getContext() instanceof Activity);
            if (this.channelInfo != null) {
                z16 = false;
            }
            d16.d("Guild.MF.End.GuildChannelDetailHeadViewNew", 2, "handleShareGroupClick error, " + z17 + APLogFileUtil.SEPARATOR_LOG + z16 + APLogFileUtil.SEPARATOR_LOG + this.guildInfo);
        }
    }

    private final void s() {
        Vibrator vibrator;
        if (this.channelInfo == null) {
            return;
        }
        if (!NetworkUtil.isNetworkAvailable()) {
            QQToast.makeText(BaseApplication.getContext(), 1, R.string.f1511016s, 0).show();
            return;
        }
        bw.S0();
        ImageView imageView = this.guildDetailSubscribeRedDot;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildDetailSubscribeRedDot");
            imageView = null;
        }
        imageView.setVisibility(8);
        if (F()) {
            R();
        } else {
            if (getContext() != null && (vibrator = (Vibrator) getContext().getSystemService("vibrator")) != null) {
                vibrator.vibrate(20L);
            }
            U();
        }
        J(this.isChannelSubscribe);
    }

    private final void t() {
        LinearLayout linearLayout;
        String str;
        Activity activity = null;
        if (B(this.channelInfo)) {
            linearLayout = this.guildDetailTextChannelOperateRoot;
            if (linearLayout == null) {
                str = "guildDetailTextChannelOperateRoot";
                Intrinsics.throwUninitializedPropertyAccessException(str);
                linearLayout = null;
            }
        } else {
            linearLayout = this.guildDetailUpTopContainer;
            if (linearLayout == null) {
                str = "guildDetailUpTopContainer";
                Intrinsics.throwUninitializedPropertyAccessException(str);
                linearLayout = null;
            }
        }
        VideoReport.reportEvent("clck", linearLayout, new HashMap());
        IGProChannelInfo iGProChannelInfo = this.channelInfo;
        if (iGProChannelInfo == null) {
            return;
        }
        if (C(iGProChannelInfo)) {
            IGuildMediaAioApi iGuildMediaAioApi = (IGuildMediaAioApi) QRoute.api(IGuildMediaAioApi.class);
            Context context = getContext();
            IGProChannelInfo iGProChannelInfo2 = this.channelInfo;
            Intrinsics.checkNotNull(iGProChannelInfo2);
            String guildId = iGProChannelInfo2.getGuildId();
            Intrinsics.checkNotNullExpressionValue(guildId, "channelInfo!!.guildId");
            IGProChannelInfo iGProChannelInfo3 = this.channelInfo;
            Intrinsics.checkNotNull(iGProChannelInfo3);
            String channelUin = iGProChannelInfo3.getChannelUin();
            Intrinsics.checkNotNullExpressionValue(channelUin, "channelInfo!!.channelUin");
            long a16 = j.c().a();
            String str2 = j.c().getSelfUserInfo().f228093a;
            Intrinsics.checkNotNullExpressionValue(str2, "getDataHub().selfUserInfo.id");
            iGuildMediaAioApi.jumpToAnnounceDetail(context, guildId, channelUin, a16, str2);
            return;
        }
        Context context2 = getContext();
        if (context2 instanceof Activity) {
            activity = (Activity) context2;
        }
        if (activity != null) {
            IGProChannelInfo iGProChannelInfo4 = this.channelInfo;
            Intrinsics.checkNotNull(iGProChannelInfo4);
            sn0.b.f433994a.a(activity, g(iGProChannelInfo4), 2);
        }
    }

    private final void u() {
        View findViewById = getRootView().findViewById(R.id.w47);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.guild_detail_uptop_ll)");
        this.guildDetailUpTopContainer = (LinearLayout) findViewById;
        View findViewById2 = getRootView().findViewById(R.id.f165463w44);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026uild_detail_subscribe_ll)");
        this.guildDetailSubscribeContainer = (LinearLayout) findViewById2;
        View findViewById3 = getRootView().findViewById(R.id.w3n);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.guild_detail_invite_ll)");
        this.guildDetailInviteContainer = (LinearLayout) findViewById3;
        View findViewById4 = getRootView().findViewById(R.id.w3q);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.\u2026ld_detail_only_invite_ll)");
        this.guildDetailOnlyInviteContainer = (LinearLayout) findViewById4;
        View findViewById5 = getRootView().findViewById(R.id.w3l);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.id.guild_detail_audio_ll)");
        this.guildDetailAudioContainer = (LinearLayout) findViewById5;
        View findViewById6 = getRootView().findViewById(R.id.w3x);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.id.guild_detail_robot_ll)");
        this.guildDetailRobotContainer = (LinearLayout) findViewById6;
        View findViewById7 = getRootView().findViewById(R.id.f165459w40);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "rootView.findViewById(R.\u2026.guild_detail_setting_ll)");
        this.guildDetailSettingContainer = (LinearLayout) findViewById7;
        View findViewById8 = getRootView().findViewById(R.id.w3u);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "rootView.findViewById(R.id.guild_detail_report_ll)");
        this.guildDetailReportContainer = (LinearLayout) findViewById8;
        View findViewById9 = getRootView().findViewById(R.id.f165462w43);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "rootView.findViewById(R.\u2026ld_detail_subscribe_icon)");
        this.guildDetailSubscribeIcon = (ImageView) findViewById9;
        View findViewById10 = getRootView().findViewById(R.id.f165464w45);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "rootView.findViewById(R.\u2026detail_subscribe_red_dot)");
        this.guildDetailSubscribeRedDot = (ImageView) findViewById10;
        View findViewById11 = getRootView().findViewById(R.id.w3k);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "rootView.findViewById(R.\u2026.guild_detail_audio_icon)");
        this.guildDetailAudioIcon = (ImageView) findViewById11;
        View findViewById12 = getRootView().findViewById(R.id.f165461w42);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "rootView.findViewById(R.\u2026ld_detail_speech_red_dot)");
        this.guildDetailAudioIconRedDot = (ImageView) findViewById12;
        View findViewById13 = getRootView().findViewById(R.id.f95175e_);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "rootView.findViewById(R.\u2026ext_channel_operate_root)");
        this.guildDetailTextChannelOperateRoot = (LinearLayout) findViewById13;
        View findViewById14 = getRootView().findViewById(R.id.f211800b);
        Intrinsics.checkNotNullExpressionValue(findViewById14, "rootView.findViewById(R.id.operation_root)");
        this.guildDetailOperateRoot = (LinearLayout) findViewById14;
        LinearLayout linearLayout = this.guildDetailUpTopContainer;
        LinearLayout linearLayout2 = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildDetailUpTopContainer");
            linearLayout = null;
        }
        linearLayout.setOnClickListener(this);
        LinearLayout linearLayout3 = this.guildDetailSubscribeContainer;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildDetailSubscribeContainer");
            linearLayout3 = null;
        }
        linearLayout3.setOnClickListener(this);
        LinearLayout linearLayout4 = this.guildDetailInviteContainer;
        if (linearLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildDetailInviteContainer");
            linearLayout4 = null;
        }
        linearLayout4.setOnClickListener(this);
        LinearLayout linearLayout5 = this.guildDetailOnlyInviteContainer;
        if (linearLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildDetailOnlyInviteContainer");
            linearLayout5 = null;
        }
        linearLayout5.setOnClickListener(this);
        LinearLayout linearLayout6 = this.guildDetailAudioContainer;
        if (linearLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildDetailAudioContainer");
            linearLayout6 = null;
        }
        linearLayout6.setOnClickListener(this);
        LinearLayout linearLayout7 = this.guildDetailRobotContainer;
        if (linearLayout7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildDetailRobotContainer");
            linearLayout7 = null;
        }
        linearLayout7.setOnClickListener(this);
        LinearLayout linearLayout8 = this.guildDetailSettingContainer;
        if (linearLayout8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildDetailSettingContainer");
            linearLayout8 = null;
        }
        linearLayout8.setOnClickListener(this);
        LinearLayout linearLayout9 = this.guildDetailReportContainer;
        if (linearLayout9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildDetailReportContainer");
            linearLayout9 = null;
        }
        linearLayout9.setOnClickListener(this);
        LinearLayout linearLayout10 = this.guildDetailTextChannelOperateRoot;
        if (linearLayout10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildDetailTextChannelOperateRoot");
        } else {
            linearLayout2 = linearLayout10;
        }
        linearLayout2.setOnClickListener(this);
    }

    private final boolean v(IGProChannelInfo channelInfo, int subType) {
        if (channelInfo == null || channelInfo.getType() != 6 || ((int) channelInfo.getApplicationId()) != subType) {
            return false;
        }
        return true;
    }

    private final boolean w(IGProChannelInfo channelInfo) {
        AppInterface k3;
        if (channelInfo == null || (k3 = k()) == null) {
            return false;
        }
        IRuntimeService runtimeService = k3.getRuntimeService(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appInterface.getRuntimeS\u2026va, ProcessConstant.MAIN)");
        String guildId = channelInfo.getGuildId();
        Intrinsics.checkNotNullExpressionValue(guildId, "channelInfo.guildId");
        String channelUin = channelInfo.getChannelUin();
        Intrinsics.checkNotNullExpressionValue(channelUin, "channelInfo.channelUin");
        return ((uh2.e) runtimeService).isQQMsgListChannel(guildId, channelUin);
    }

    private final boolean x(IGProChannelInfo channelInfo) {
        return v(channelInfo, IChannelType.APP_SUB_CHANNEL_TYPE_SCHEDULE);
    }

    private final boolean y(IGProChannelInfo channelInfo) {
        List listOf;
        if (channelInfo == null) {
            return false;
        }
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{7, 2, 5});
        if (listOf.contains(Integer.valueOf(channelInfo.getType())) || v(channelInfo, IChannelType.APP_SUB_CHANNEL_TYPE_GAMECENTER_QA)) {
            return false;
        }
        return true;
    }

    private final boolean z(IGProChannelInfo channelInfo) {
        if (d12.a.c()) {
            return false;
        }
        IGPSService iGPSService = (IGPSService) ch.R0(IGPSService.class);
        if (channelInfo == null) {
            return false;
        }
        if ((channelInfo.getType() != 1 && channelInfo.getType() != 7 && channelInfo.getType() != 2) || iGPSService.isQQMsgListGuild(az.d(channelInfo.getGuildId(), 0L))) {
            return false;
        }
        return true;
    }

    public final void I(@Nullable IGProGuildInfo guildInfo, @Nullable IGProChannelInfo channelInfo) {
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.MF.End.GuildChannelDetailHeadViewNew", 2, "refresh: guildInfo:" + guildInfo + ", channelInfo:" + channelInfo + "," + new Exception());
        }
        this.guildInfo = guildInfo;
        this.channelInfo = channelInfo;
        this.msgNotifyType = l(channelInfo);
        this.isChannelSubscribe = w(channelInfo);
        if (x(channelInfo)) {
            V();
            return;
        }
        if (C(channelInfo)) {
            Y();
            M(this.isChannelSubscribe);
            return;
        }
        if (B(channelInfo)) {
            X(true);
            return;
        }
        W();
        M(this.isChannelSubscribe);
        Q(A(channelInfo));
        GuildChannelDetailHeadViewStyle guildChannelDetailHeadViewStyle = this.mStyle;
        ImageView imageView = this.viewBinding.f443125x;
        Intrinsics.checkNotNullExpressionValue(imageView, "viewBinding.guildDetailUptopIcon");
        TextView textView = this.viewBinding.f443127z;
        Intrinsics.checkNotNullExpressionValue(textView, "viewBinding.guildDetailUptopTv");
        guildChannelDetailHeadViewStyle.bindUpTopIcon(imageView, textView, R.drawable.guild_detail_uptop_icon);
        P(y(channelInfo));
    }

    @Nullable
    public final AppInterface k() {
        QBaseActivity qBaseActivity;
        Context context = getContext();
        if (context instanceof QBaseActivity) {
            qBaseActivity = (QBaseActivity) context;
        } else {
            qBaseActivity = null;
        }
        if (qBaseActivity == null || !(qBaseActivity.getAppRuntime() instanceof AppInterface)) {
            return null;
        }
        AppRuntime appRuntime = qBaseActivity.getAppRuntime();
        Intrinsics.checkNotNull(appRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        return (AppInterface) appRuntime;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (!QQGuildUIUtil.v()) {
            LinearLayout linearLayout = this.guildDetailUpTopContainer;
            LinearLayout linearLayout2 = null;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildDetailUpTopContainer");
                linearLayout = null;
            }
            if (v3 == linearLayout) {
                t();
            } else {
                LinearLayout linearLayout3 = this.guildDetailSubscribeContainer;
                if (linearLayout3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("guildDetailSubscribeContainer");
                    linearLayout3 = null;
                }
                if (v3 == linearLayout3) {
                    s();
                } else {
                    LinearLayout linearLayout4 = this.guildDetailInviteContainer;
                    if (linearLayout4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("guildDetailInviteContainer");
                        linearLayout4 = null;
                    }
                    if (v3 == linearLayout4) {
                        r(v3);
                    } else {
                        LinearLayout linearLayout5 = this.guildDetailOnlyInviteContainer;
                        if (linearLayout5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("guildDetailOnlyInviteContainer");
                            linearLayout5 = null;
                        }
                        if (v3 == linearLayout5) {
                            r(v3);
                        } else {
                            LinearLayout linearLayout6 = this.guildDetailAudioContainer;
                            if (linearLayout6 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("guildDetailAudioContainer");
                                linearLayout6 = null;
                            }
                            if (v3 == linearLayout6) {
                                m(v3);
                            } else {
                                LinearLayout linearLayout7 = this.guildDetailRobotContainer;
                                if (linearLayout7 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("guildDetailRobotContainer");
                                    linearLayout7 = null;
                                }
                                if (v3 == linearLayout7) {
                                    n(v3);
                                } else {
                                    LinearLayout linearLayout8 = this.guildDetailSettingContainer;
                                    if (linearLayout8 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("guildDetailSettingContainer");
                                        linearLayout8 = null;
                                    }
                                    if (v3 == linearLayout8) {
                                        q();
                                    } else {
                                        LinearLayout linearLayout9 = this.guildDetailReportContainer;
                                        if (linearLayout9 == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException("guildDetailReportContainer");
                                            linearLayout9 = null;
                                        }
                                        if (v3 == linearLayout9) {
                                            p();
                                        } else {
                                            LinearLayout linearLayout10 = this.guildDetailTextChannelOperateRoot;
                                            if (linearLayout10 == null) {
                                                Intrinsics.throwUninitializedPropertyAccessException("guildDetailTextChannelOperateRoot");
                                            } else {
                                                linearLayout2 = linearLayout10;
                                            }
                                            if (Intrinsics.areEqual(v3, linearLayout2)) {
                                                t();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(@Nullable View v3) {
        EventCollector.getInstance().onViewLongClickedBefore(v3);
        EventCollector.getInstance().onViewLongClicked(v3);
        return false;
    }

    public final void setContentView(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.contentView = view;
    }

    public final void setGuildDetailAudioIcon() {
        GuildChannelDetailHeadViewStyle guildChannelDetailHeadViewStyle = this.mStyle;
        ImageView imageView = this.guildDetailAudioIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildDetailAudioIcon");
            imageView = null;
        }
        TextView textView = this.viewBinding.f443105d;
        Intrinsics.checkNotNullExpressionValue(textView, "viewBinding.guildDetailAudioTv");
        guildChannelDetailHeadViewStyle.setGuildDetailAudioIcon(imageView, textView);
    }

    public final void setMStyle(@NotNull GuildChannelDetailHeadViewStyle value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.mStyle = value;
        LinearLayout linearLayout = this.viewBinding.C;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "viewBinding.operationRoot");
        View view = this.viewBinding.D;
        Intrinsics.checkNotNullExpressionValue(view, "viewBinding.splitLine");
        value.setBackground(linearLayout, view);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GuildChannelDetailHeadViewNew(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GuildChannelDetailHeadViewNew(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildChannelDetailHeadViewNew(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mHasRemaingAtCount = true;
        this.mGuildAtallSwitchOpen = !((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("guild_offline_aio_atall_entrance", false);
        this.mStyle = GuildChannelDetailHeadViewStyle.STYLE_SKIN;
        v g16 = v.g(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context), this, true)");
        this.viewBinding = g16;
        u();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @RequiresApi(21)
    public GuildChannelDetailHeadViewNew(@NotNull Context context, @Nullable IGProGuildInfo iGProGuildInfo, @Nullable IGProChannelInfo iGProChannelInfo, int i3, @NotNull GuildChannelDetailHeadViewStyle style) {
        this(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(style, "style");
        setMStyle(style);
        this.chatPieContainerType = i3;
        I(iGProGuildInfo, iGProChannelInfo);
        L();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/guild/setting/channeldetails/GuildChannelDetailHeadViewNew$b", "Lcom/tencent/mobileqq/guild/robot/components/audio/AudioRobotListFragment$b;", "", "b", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements AudioRobotListFragment.b {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.robot.components.audio.AudioRobotListFragment.b
        public void a() {
            String str;
            com.tencent.mobileqq.guild.media.core.e a16 = j.a();
            IGProChannelInfo iGProChannelInfo = GuildChannelDetailHeadViewNew.this.channelInfo;
            if (iGProChannelInfo != null) {
                str = iGProChannelInfo.getChannelUin();
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            a16.G(str, RefreshType.BY_AUDIO_ROBOT);
        }

        @Override // com.tencent.mobileqq.guild.robot.components.audio.AudioRobotListFragment.b
        public void b() {
        }
    }
}
