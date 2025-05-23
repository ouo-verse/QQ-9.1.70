package com.tencent.mobileqq.guild.mainframe.helper.jump;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.api.IGuildEmotionCodecApi;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.base.GuildBaseBottomSheetFragment;
import com.tencent.mobileqq.guild.channel.joinchannel.JoinGuildLogic;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.manager.GuildOpenRecordManager;
import com.tencent.mobileqq.guild.mainframe.standalone.GuildStandaloneDialogAttachFragment;
import com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils;
import com.tencent.mobileqq.guild.profile.profilecard.baseprofile.GuildUserProfileCardFragment;
import com.tencent.mobileqq.guild.setting.guildwelcome.fragment.GuildWelcomeGuideDialogFragment;
import com.tencent.mobileqq.guild.u;
import com.tencent.mobileqq.guild.util.GuildMedalUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ca;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildResult;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMedalInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.RoundRectImageView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vh2.bv;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 f2\u00020\u00012\u00020\u0002:\u0001gB\u0007\u00a2\u0006\u0004\bd\u0010eJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J(\u0010\u000e\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00062\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0011\u001a\u00020\u0003H\u0002J\b\u0010\u0012\u001a\u00020\u0003H\u0002J\b\u0010\u0013\u001a\u00020\u0003H\u0002J\b\u0010\u0014\u001a\u00020\u000fH\u0002J\b\u0010\u0015\u001a\u00020\u0003H\u0002J\b\u0010\u0016\u001a\u00020\u0003H\u0002J$\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010\u001f\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010!\u001a\u00020 2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\b\u0010\"\u001a\u00020\u0003H\u0016J\b\u0010#\u001a\u00020\u0003H\u0016J\u0010\u0010%\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u001dH\u0016J\u0010\u0010(\u001a\u00020\u00032\u0006\u0010'\u001a\u00020&H\u0016R\u0016\u0010+\u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00105\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u0010.R\u0016\u00107\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u0010.R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010=\u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b<\u0010*R\u0016\u0010?\u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b>\u0010*R\u0016\u0010A\u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b@\u0010*R\u0016\u0010C\u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bB\u0010*R\u0018\u0010G\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0018\u0010K\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010N\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010R\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0018\u0010V\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010Z\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u0018\u0010]\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010_\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010MR\u0016\u0010a\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010MR\u0016\u0010c\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010M\u00a8\u0006h"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/helper/jump/JoinGuildChannelFrag;", "Lcom/tencent/mobileqq/guild/base/GuildBaseBottomSheetFragment;", "Landroid/view/View$OnClickListener;", "", "init", "resetData", "", "profile", "Fh", "guildName", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProMedalInfo;", "Lkotlin/collections/ArrayList;", "medals", "Dh", "", "yh", "Kh", "Jh", "Ch", "Hh", "Ah", "Gh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "onCreate", "Landroid/app/Dialog;", "onCreateDialog", "onResume", DKHippyEvent.EVENT_STOP, "v", NodeProps.ON_CLICK, "Landroid/content/DialogInterface;", "dialog", "onDismiss", "D", "Landroid/view/View;", "mRootView", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "mGuildTextTitle", "Lcom/tencent/widget/RoundRectImageView;", UserInfo.SEX_FEMALE, "Lcom/tencent/widget/RoundRectImageView;", "mGuildAvatar", "G", "mGuildName", "H", "mChannelInfoText", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "I", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "mJoinBtn", "J", "mUserInfoGroup", "K", "mRightArrowView", "L", "mBottomGroup", "M", "mBottomTextInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "N", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "mGuildInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "P", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "mChannelInfo", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Z", "mIsNeedJoinGuild", "", BdhLogUtil.LogTag.Tag_Req, "Ljava/lang/Integer;", "mOpenFrom", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "mJumpGuildParam", "Lcom/tencent/mobileqq/guild/setting/guildwelcome/fragment/GuildWelcomeGuideDialogFragment;", "T", "Lcom/tencent/mobileqq/guild/setting/guildwelcome/fragment/GuildWelcomeGuideDialogFragment;", "mGuideDialog", "U", "Ljava/lang/String;", "mDialogTip", "V", "mJump2AIOAfterJoin", "W", "mShowSuccessDialog", "X", "mIsManualDismiss", "<init>", "()V", "Y", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class JoinGuildChannelFrag extends GuildBaseBottomSheetFragment implements View.OnClickListener {

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: D, reason: from kotlin metadata */
    private View mRootView;

    /* renamed from: E, reason: from kotlin metadata */
    private TextView mGuildTextTitle;

    /* renamed from: F, reason: from kotlin metadata */
    private RoundRectImageView mGuildAvatar;

    /* renamed from: G, reason: from kotlin metadata */
    private TextView mGuildName;

    /* renamed from: H, reason: from kotlin metadata */
    private TextView mChannelInfoText;

    /* renamed from: I, reason: from kotlin metadata */
    private QUIButton mJoinBtn;

    /* renamed from: J, reason: from kotlin metadata */
    private View mUserInfoGroup;

    /* renamed from: K, reason: from kotlin metadata */
    private View mRightArrowView;

    /* renamed from: L, reason: from kotlin metadata */
    private View mBottomGroup;

    /* renamed from: M, reason: from kotlin metadata */
    private View mBottomTextInfo;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private IGProGuildInfo mGuildInfo;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private IGProChannelInfo mChannelInfo;

    /* renamed from: Q, reason: from kotlin metadata */
    private boolean mIsNeedJoinGuild;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private Integer mOpenFrom = 0;

    /* renamed from: S, reason: from kotlin metadata */
    @Nullable
    private JumpGuildParam mJumpGuildParam;

    /* renamed from: T, reason: from kotlin metadata */
    @Nullable
    private GuildWelcomeGuideDialogFragment mGuideDialog;

    /* renamed from: U, reason: from kotlin metadata */
    @Nullable
    private String mDialogTip;

    /* renamed from: V, reason: from kotlin metadata */
    private boolean mJump2AIOAfterJoin;

    /* renamed from: W, reason: from kotlin metadata */
    private boolean mShowSuccessDialog;

    /* renamed from: X, reason: from kotlin metadata */
    private boolean mIsManualDismiss;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0007R\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\fR\u0014\u0010\u0010\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\fR\u0014\u0010\u0012\u001a\u00020\u00118\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00118\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00118\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/helper/jump/JoinGuildChannelFrag$a;", "", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "jumpGuildParam", "", "dialogTip", "", "jump2AIOAfterJoin", "showSuccessDialog", "Landroid/content/Intent;", "a", "KEY_DIALOG_TIPS", "Ljava/lang/String;", "KEY_JUMP_TO_AIO_AFTER_JOIN", "KEY_OPEN_FROM", "KEY_SHOW_SUCCESS_DIALOG", "TAG", "", "VALUE_OPEN_FROM_DEFAULT", "I", "VALUE_OPEN_FROM_STANDALONE", "VALUE_OPEN_FROM_VISITOR_TIMER", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.mainframe.helper.jump.JoinGuildChannelFrag$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final Intent a(@NotNull JumpGuildParam jumpGuildParam, @NotNull String dialogTip, boolean jump2AIOAfterJoin, boolean showSuccessDialog) {
            Intrinsics.checkNotNullParameter(jumpGuildParam, "jumpGuildParam");
            Intrinsics.checkNotNullParameter(dialogTip, "dialogTip");
            Intent intent = new Intent();
            intent.putExtra(JumpGuildParam.KEY_JUMP_GUILD_PARAM, (Serializable) jumpGuildParam);
            intent.putExtra("key_dialog_tips", dialogTip);
            intent.putExtra("key_jump_to_aio_after_join", jump2AIOAfterJoin);
            intent.putExtra("key_show_success_dialog", showSuccessDialog);
            return intent;
        }

        Companion() {
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0028, code lost:
    
        if (r0.equals("profile_card") == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0032, code lost:
    
        if (r0.equals("discover_new") != false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003c, code lost:
    
        if (r0.equals("discover") == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0046, code lost:
    
        if (r0.equals("channel_the_public") == false) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void Ah() {
        int i3;
        JumpGuildParam jumpGuildParam = this.mJumpGuildParam;
        if (jumpGuildParam != null) {
            String mainSource = jumpGuildParam.getMainSource();
            if (mainSource != null) {
                i3 = 11;
                switch (mainSource.hashCode()) {
                    case -723491149:
                        break;
                    case 273184745:
                        break;
                    case 1177891914:
                        break;
                    case 1223379942:
                        break;
                    case 1971934347:
                        if (mainSource.equals("private_aio")) {
                            i3 = 12;
                            break;
                        }
                        break;
                }
                JoinGuildLogic.JumpParam jumpParam = new JoinGuildLogic.JumpParam();
                jumpParam.a(i3);
                jumpParam.d(true);
                com.tencent.mobileqq.guild.channel.joinchannel.h.a(getActivity(), this.mJumpGuildParam, jumpParam, "Guild.jump.JoinGuildChannelFrag", new bv() { // from class: com.tencent.mobileqq.guild.mainframe.helper.jump.f
                    @Override // vh2.bv
                    public final void a(int i16, String str, IGProSecurityResult iGProSecurityResult, IGProJoinGuildResult iGProJoinGuildResult) {
                        JoinGuildChannelFrag.Bh(JoinGuildChannelFrag.this, i16, str, iGProSecurityResult, iGProJoinGuildResult);
                    }
                });
            }
            i3 = 0;
            JoinGuildLogic.JumpParam jumpParam2 = new JoinGuildLogic.JumpParam();
            jumpParam2.a(i3);
            jumpParam2.d(true);
            com.tencent.mobileqq.guild.channel.joinchannel.h.a(getActivity(), this.mJumpGuildParam, jumpParam2, "Guild.jump.JoinGuildChannelFrag", new bv() { // from class: com.tencent.mobileqq.guild.mainframe.helper.jump.f
                @Override // vh2.bv
                public final void a(int i16, String str, IGProSecurityResult iGProSecurityResult, IGProJoinGuildResult iGProJoinGuildResult) {
                    JoinGuildChannelFrag.Bh(JoinGuildChannelFrag.this, i16, str, iGProSecurityResult, iGProJoinGuildResult);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Bh(JoinGuildChannelFrag this$0, int i3, String str, IGProSecurityResult iGProSecurityResult, IGProJoinGuildResult iGProJoinGuildResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!com.tencent.mobileqq.guild.channel.joinchannel.h.d(i3, iGProSecurityResult)) {
            com.tencent.mobileqq.guild.channel.joinchannel.h.c(this$0.getContext(), i3, str, iGProSecurityResult);
        }
        this$0.Gh();
    }

    private final void Ch() {
        boolean z16 = true;
        if (!this.mIsNeedJoinGuild) {
            Logger.f235387a.d().d("Guild.jump.JoinGuildChannelFrag", 1, "joinGuildIfNeed don't need");
            return;
        }
        if (getActivity() != null) {
            if (this.mShowSuccessDialog) {
                Ah();
                return;
            }
            JoinGuildLogic.JumpParam jumpParam = new JoinGuildLogic.JumpParam();
            jumpParam.d(Hh());
            if (!((IGuildTempApi) QRoute.api(IGuildTempApi.class)).isGuildTabSelected()) {
                IGProChannelInfo iGProChannelInfo = this.mChannelInfo;
                if (iGProChannelInfo == null || iGProChannelInfo.getType() != 6) {
                    z16 = false;
                }
                if (!z16) {
                    jumpParam.c(this.mJump2AIOAfterJoin);
                    com.tencent.mobileqq.guild.channel.joinchannel.h.a(getActivity(), this.mJumpGuildParam, jumpParam, "Guild.jump.JoinGuildChannelFrag", null);
                    Gh();
                }
            }
            com.tencent.mobileqq.guild.channel.joinchannel.h.b(getActivity(), this.mJumpGuildParam, jumpParam, "Guild.jump.JoinGuildChannelFrag");
            Gh();
        }
    }

    private final void Dh(final String guildName, ArrayList<IGProMedalInfo> medals) {
        TextView textView = null;
        final List t16 = GuildMedalUtils.t(medals, 0, 2, null);
        if (t16.isEmpty()) {
            return;
        }
        TextView textView2 = this.mGuildName;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildName");
        } else {
            textView = textView2;
        }
        textView.post(new Runnable() { // from class: com.tencent.mobileqq.guild.mainframe.helper.jump.d
            @Override // java.lang.Runnable
            public final void run() {
                JoinGuildChannelFrag.Eh(JoinGuildChannelFrag.this, guildName, t16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Eh(JoinGuildChannelFrag this$0, String guildName, List validMedals) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(guildName, "$guildName");
        Intrinsics.checkNotNullParameter(validMedals, "$validMedals");
        if (this$0.yh()) {
            return;
        }
        GuildMedalUtils guildMedalUtils = GuildMedalUtils.f235347a;
        TextView textView = this$0.mGuildName;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildName");
            textView = null;
        }
        GuildMedalUtils.w(guildMedalUtils, guildName, validMedals, textView, null, 0, null, 56, null);
    }

    private final void Fh(String profile) {
        TextView textView = null;
        if (TextUtils.isEmpty(profile)) {
            TextView textView2 = this.mGuildName;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGuildName");
                textView2 = null;
            }
            ViewGroup.LayoutParams layoutParams = textView2.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.topMargin = 0;
            layoutParams2.addRule(15);
            TextView textView3 = this.mGuildName;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGuildName");
            } else {
                textView = textView3;
            }
            textView.setLayoutParams(layoutParams2);
            return;
        }
        TextView textView4 = this.mChannelInfoText;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChannelInfoText");
        } else {
            textView = textView4;
        }
        textView.setText(((IGuildEmotionCodecApi) QRoute.api(IGuildEmotionCodecApi.class)).toQQText(profile, 13));
    }

    private final void Gh() {
        this.mIsManualDismiss = true;
        dismissAllowingStateLoss();
    }

    private final boolean Hh() {
        IGProChannelInfo iGProChannelInfo = this.mChannelInfo;
        boolean z16 = false;
        if (iGProChannelInfo != null && iGProChannelInfo.getType() == 6) {
            z16 = true;
        }
        if (!z16) {
            return true;
        }
        return !ch.k0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ih(JoinGuildChannelFrag this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Gh();
    }

    private final void Jh() {
        IGuildDTReportApi iGuildDTReportApi = (IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class);
        QUIButton qUIButton = this.mJoinBtn;
        if (qUIButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mJoinBtn");
            qUIButton = null;
        }
        iGuildDTReportApi.setElementExposureAndClickParams(qUIButton, "em_sgrp_layerjoin_channel_button", null);
        IGuildDTReportApi iGuildDTReportApi2 = (IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class);
        View view = this.mUserInfoGroup;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserInfoGroup");
            view = null;
        }
        iGuildDTReportApi2.setElementExposureAndClickParams(view, "em_sgrp_see_intro_page", null);
        IGuildDTReportApi iGuildDTReportApi3 = (IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class);
        View view2 = this.mBottomTextInfo;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBottomTextInfo");
            view2 = null;
        }
        iGuildDTReportApi3.setElementExposureAndClickParams(view2, "em_sgrp_invited_channel", null);
    }

    private final void Kh() {
        VideoReport.addToDetectionWhitelist(getActivity());
        View view = this.mRootView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        VideoReport.setPageId(view, "pg_sgrp_invite_user_join_layer");
        HashMap hashMap = new HashMap();
        hashMap.put("pgid", "pg_sgrp_invite_user_join_layer");
        IGProGuildInfo iGProGuildInfo = this.mGuildInfo;
        if (iGProGuildInfo != null) {
            Intrinsics.checkNotNull(iGProGuildInfo);
            String guildID = iGProGuildInfo.getGuildID();
            Intrinsics.checkNotNullExpressionValue(guildID, "mGuildInfo!!.guildID");
            hashMap.put("sgrp_channel_id", guildID);
        }
        IGProChannelInfo iGProChannelInfo = this.mChannelInfo;
        if (iGProChannelInfo != null) {
            Intrinsics.checkNotNull(iGProChannelInfo);
            String channelUin = iGProChannelInfo.getChannelUin();
            Intrinsics.checkNotNullExpressionValue(channelUin, "mChannelInfo!!.channelUin");
            hashMap.put("sgrp_sub_channel_id", channelUin);
            IGProChannelInfo iGProChannelInfo2 = this.mChannelInfo;
            Intrinsics.checkNotNull(iGProChannelInfo2);
            hashMap.put("sgrp_subchannel_type", String.valueOf(iGProChannelInfo2.getType()));
        }
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setOpenGuildSourceParams(getArguments(), hashMap);
        View view3 = this.mRootView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        } else {
            view2 = view3;
        }
        VideoReport.setPageParams(view2, new PageParams(hashMap));
    }

    private final void init() {
        int i3;
        View view = this.mRootView;
        TextView textView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        View findViewById = view.findViewById(R.id.x27);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R.id.guild_text_title)");
        this.mGuildTextTitle = (TextView) findViewById;
        View view2 = this.mRootView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view2 = null;
        }
        View findViewById2 = view2.findViewById(R.id.f165437w02);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById(R.id.guild_avatar_image)");
        this.mGuildAvatar = (RoundRectImageView) findViewById2;
        View view3 = this.mRootView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view3 = null;
        }
        View findViewById3 = view3.findViewById(R.id.f113126ps);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mRootView.findViewById(R.id.txt_guild_name)");
        this.mGuildName = (TextView) findViewById3;
        View view4 = this.mRootView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view4 = null;
        }
        View findViewById4 = view4.findViewById(R.id.f113136pt);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "mRootView.findViewById(R.id.txt_guild_profile)");
        this.mChannelInfoText = (TextView) findViewById4;
        View view5 = this.mRootView;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view5 = null;
        }
        View findViewById5 = view5.findViewById(R.id.f164665ai2);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "mRootView.findViewById(R.id.btn_join)");
        this.mJoinBtn = (QUIButton) findViewById5;
        View view6 = this.mRootView;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view6 = null;
        }
        View findViewById6 = view6.findViewById(R.id.ieb);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "mRootView.findViewById(R.id.rl_user_info)");
        this.mUserInfoGroup = findViewById6;
        View view7 = this.mRootView;
        if (view7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view7 = null;
        }
        View findViewById7 = view7.findViewById(R.id.wkq);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "mRootView.findViewById(R.id.guild_iv_right_arrow)");
        this.mRightArrowView = findViewById7;
        View view8 = this.mRootView;
        if (view8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view8 = null;
        }
        View findViewById8 = view8.findViewById(R.id.wkw);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "mRootView.findViewById(R\u2026join_dialog_bottom_group)");
        this.mBottomGroup = findViewById8;
        View view9 = this.mRootView;
        if (view9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view9 = null;
        }
        View findViewById9 = view9.findViewById(R.id.wki);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "mRootView.findViewById(R.id.guild_iv_info)");
        this.mBottomTextInfo = findViewById9;
        QUIButton qUIButton = this.mJoinBtn;
        if (qUIButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mJoinBtn");
            qUIButton = null;
        }
        qUIButton.setOnClickListener(this);
        View view10 = this.mBottomTextInfo;
        if (view10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBottomTextInfo");
            view10 = null;
        }
        view10.setOnClickListener(this);
        View view11 = this.mBottomGroup;
        if (view11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBottomGroup");
            view11 = null;
        }
        if (ca.a()) {
            i3 = 4;
        } else {
            i3 = 0;
        }
        view11.setVisibility(i3);
        TextView textView2 = this.mGuildTextTitle;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGuildTextTitle");
            textView2 = null;
        }
        String str = this.mDialogTip;
        if (str == null) {
            str = HardCodeUtil.qqStr(R.string.f147280wg);
        }
        textView2.setText(str);
        IGProGuildInfo iGProGuildInfo = this.mGuildInfo;
        if (iGProGuildInfo != null) {
            if (GuildOpenRecordManager.g(iGProGuildInfo.getGuildID())) {
                View view12 = this.mUserInfoGroup;
                if (view12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mUserInfoGroup");
                    view12 = null;
                }
                view12.setOnClickListener(this);
                View view13 = this.mRightArrowView;
                if (view13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mRightArrowView");
                    view13 = null;
                }
                view13.setVisibility(0);
            }
            String avatarUrl = iGProGuildInfo.getAvatarUrl(100);
            RoundRectImageView roundRectImageView = this.mGuildAvatar;
            if (roundRectImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGuildAvatar");
                roundRectImageView = null;
            }
            u.q(avatarUrl, roundRectImageView, true);
            RoundRectImageView roundRectImageView2 = this.mGuildAvatar;
            if (roundRectImageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGuildAvatar");
                roundRectImageView2 = null;
            }
            roundRectImageView2.setCornerRadiusAndMode(QQGuildUIUtil.f(6.0f), 1);
            TextView textView3 = this.mGuildName;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGuildName");
            } else {
                textView = textView3;
            }
            textView.setText(iGProGuildInfo.getGuildName());
            String profile = iGProGuildInfo.getProfile();
            Intrinsics.checkNotNullExpressionValue(profile, "guildInfo.profile");
            Fh(profile);
            String guildName = iGProGuildInfo.getGuildName();
            Intrinsics.checkNotNullExpressionValue(guildName, "guildInfo.guildName");
            ArrayList<IGProMedalInfo> medalInfoList = iGProGuildInfo.getMedalInfoList();
            Intrinsics.checkNotNullExpressionValue(medalInfoList, "guildInfo.medalInfoList");
            Dh(guildName, medalInfoList);
        }
        Kh();
        Jh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void resetData() {
        IGProGuildInfo iGProGuildInfo = this.mGuildInfo;
        if (iGProGuildInfo != null) {
            String avatarUrl = iGProGuildInfo.getAvatarUrl(100);
            RoundRectImageView roundRectImageView = this.mGuildAvatar;
            TextView textView = null;
            if (roundRectImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGuildAvatar");
                roundRectImageView = null;
            }
            u.q(avatarUrl, roundRectImageView, true);
            RoundRectImageView roundRectImageView2 = this.mGuildAvatar;
            if (roundRectImageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGuildAvatar");
                roundRectImageView2 = null;
            }
            roundRectImageView2.setCornerRadiusAndMode(QQGuildUIUtil.f(6.0f), 1);
            TextView textView2 = this.mGuildName;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mGuildName");
            } else {
                textView = textView2;
            }
            textView.setText(iGProGuildInfo.getGuildName());
            String profile = iGProGuildInfo.getProfile();
            Intrinsics.checkNotNullExpressionValue(profile, "guildInfo.profile");
            Fh(profile);
            String guildName = iGProGuildInfo.getGuildName();
            Intrinsics.checkNotNullExpressionValue(guildName, "guildInfo.guildName");
            ArrayList<IGProMedalInfo> medalInfoList = iGProGuildInfo.getMedalInfoList();
            Intrinsics.checkNotNullExpressionValue(medalInfoList, "guildInfo.medalInfoList");
            Dh(guildName, medalInfoList);
        }
        Kh();
        Jh();
    }

    private final boolean yh() {
        boolean z16;
        boolean z17;
        if (getActivity() != null) {
            FragmentActivity activity = getActivity();
            if (activity != null && activity.isFinishing()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                FragmentActivity activity2 = getActivity();
                if (activity2 != null && activity2.isDestroyed()) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!z17 && isAdded()) {
                    return false;
                }
            }
        }
        Logger logger = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        bVar.a().add("loadGuildMedal activity is finishing!");
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e("Guild.jump.JoinGuildChannelFrag", 1, (String) it.next(), null);
        }
        return true;
    }

    @JvmStatic
    @NotNull
    public static final Intent zh(@NotNull JumpGuildParam jumpGuildParam, @NotNull String str, boolean z16, boolean z17) {
        return INSTANCE.a(jumpGuildParam, str, z16, z17);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        int id5 = v3.getId();
        if (id5 == R.id.f164665ai2) {
            Ch();
        } else if (id5 == R.id.wki) {
            if (getContext() != null) {
                this.mGuideDialog = new GuildWelcomeGuideDialogFragment();
                FragmentManager fragmentManager = getFragmentManager();
                if (fragmentManager != null) {
                    GuildWelcomeGuideDialogFragment guildWelcomeGuideDialogFragment = this.mGuideDialog;
                    if (guildWelcomeGuideDialogFragment != null) {
                        guildWelcomeGuideDialogFragment.show(fragmentManager, "Guild.jump.JoinGuildChannelFrag");
                    }
                    GuildWelcomeGuideDialogFragment guildWelcomeGuideDialogFragment2 = this.mGuideDialog;
                    if (guildWelcomeGuideDialogFragment2 != null) {
                        guildWelcomeGuideDialogFragment2.Jh(new GuildWelcomeGuideDialogFragment.c() { // from class: com.tencent.mobileqq.guild.mainframe.helper.jump.e
                            @Override // com.tencent.mobileqq.guild.setting.guildwelcome.fragment.GuildWelcomeGuideDialogFragment.c
                            public final void onDismiss() {
                                JoinGuildChannelFrag.Ih(JoinGuildChannelFrag.this);
                            }
                        });
                    }
                }
            }
        } else if (id5 == R.id.ieb) {
            GuildStandaloneDialogAttachFragment.rh(getContext(), this.mJumpGuildParam, true);
            Gh();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mDialogTip = arguments.getString("key_dialog_tips");
            this.mJump2AIOAfterJoin = arguments.getBoolean("key_jump_to_aio_after_join");
            this.mShowSuccessDialog = arguments.getBoolean("key_show_success_dialog");
            JumpGuildParam jumpGuildParam = (JumpGuildParam) arguments.get(JumpGuildParam.KEY_JUMP_GUILD_PARAM);
            Intrinsics.checkNotNull(jumpGuildParam);
            this.mJumpGuildParam = jumpGuildParam;
            IGPSService iGPSService = (IGPSService) ch.R0(IGPSService.class);
            this.mGuildInfo = iGPSService.getGuildInfo(jumpGuildParam.guildId);
            this.mChannelInfo = iGPSService.getChannelInfo(jumpGuildParam.getChannelId());
            this.mIsNeedJoinGuild = ch.j0(jumpGuildParam.guildId);
            this.mOpenFrom = Integer.valueOf(jumpGuildParam.extras.getInt(JumpGuildParam.EXTRA_KEY_OPEN_FROM, 0));
        }
        Logger.f235387a.d().d("Guild.jump.JoinGuildChannelFrag", 1, "onCreate arg: " + arguments + " mJoinGuildParam:" + this.mJumpGuildParam);
        final JumpGuildParam jumpGuildParam2 = this.mJumpGuildParam;
        if (jumpGuildParam2 == null) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
            }
            Logger.b bVar = new Logger.b();
            String str = "onCreate param is invalid: " + this.mJumpGuildParam + ", " + this.mGuildInfo + ", " + this.mChannelInfo;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.jump.JoinGuildChannelFrag", 1, (String) it.next(), null);
            }
            return;
        }
        if (this.mGuildInfo == null && jumpGuildParam2 != null) {
            String str2 = jumpGuildParam2.guildId;
            Intrinsics.checkNotNullExpressionValue(str2, "params.guildId");
            GuildMainFrameUtils.i(str2, null, 0, null, false, new Function1<GuildMainFrameUtils.GuildAndChannelInfoRsp, Unit>() { // from class: com.tencent.mobileqq.guild.mainframe.helper.jump.JoinGuildChannelFrag$onCreate$3$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(GuildMainFrameUtils.GuildAndChannelInfoRsp guildAndChannelInfoRsp) {
                    invoke2(guildAndChannelInfoRsp);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull GuildMainFrameUtils.GuildAndChannelInfoRsp it5) {
                    Intrinsics.checkNotNullParameter(it5, "it");
                    if (it5.k() == 0) {
                        JoinGuildChannelFrag.this.mGuildInfo = it5.h();
                        JoinGuildChannelFrag.this.resetData();
                        return;
                    }
                    QLog.w("Guild.jump.JoinGuildChannelFrag", 1, "fetchGuildAndChannelInfo error, guildId:" + jumpGuildParam2.guildId + " errMsg:" + it5.e());
                }
            }, 30, null);
        }
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        WindowManager.LayoutParams layoutParams;
        Bundle bundle;
        Dialog onCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.checkNotNullExpressionValue(onCreateDialog, "super.onCreateDialog(savedInstanceState)");
        JumpGuildParam jumpGuildParam = this.mJumpGuildParam;
        boolean z16 = false;
        if (jumpGuildParam != null && (bundle = jumpGuildParam.extras) != null && bundle.getBoolean("jumpGuildFromLoadingPage")) {
            z16 = true;
        }
        if (z16) {
            Window window = onCreateDialog.getWindow();
            if (window != null) {
                layoutParams = window.getAttributes();
            } else {
                layoutParams = null;
            }
            if (layoutParams != null) {
                layoutParams.windowAnimations = R.style.avq;
            }
        }
        return onCreateDialog;
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.evf, container);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou\u2026nnel_fragment, container)");
        this.mRootView = inflate;
        init();
        View view = this.mRootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.mobileqq.guild.base.GuildBaseBottomSheetFragment, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NotNull DialogInterface dialog) {
        int i3;
        String str;
        int i16;
        Bundle bundle;
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        if (!this.mIsManualDismiss) {
            JumpGuildParam jumpGuildParam = this.mJumpGuildParam;
            if (jumpGuildParam != null) {
                i3 = jumpGuildParam.getExtraJoinGuildSource();
            } else {
                i3 = 0;
            }
            JumpGuildParam jumpGuildParam2 = this.mJumpGuildParam;
            String str2 = null;
            if (jumpGuildParam2 != null) {
                str = jumpGuildParam2.getExtraJoinGuildTinyId();
            } else {
                str = null;
            }
            JumpGuildParam jumpGuildParam3 = this.mJumpGuildParam;
            if (jumpGuildParam3 != null && (bundle = jumpGuildParam3.extras) != null) {
                i16 = bundle.getInt(JumpGuildParam.EXTRA_PERSON_CARD_SCENE_TYPE);
            } else {
                i16 = 6;
            }
            int i17 = i16;
            if ((i3 == 1 || i3 == 2) && str != null) {
                JumpGuildParam jumpGuildParam4 = this.mJumpGuildParam;
                if (jumpGuildParam4 != null) {
                    str2 = jumpGuildParam4.guildId;
                }
                GuildProfileData guildProfileData = new GuildProfileData(str2, "", str, 6, i17);
                Context it = getContext();
                if (it != null) {
                    GuildUserProfileCardFragment.Companion companion = GuildUserProfileCardFragment.INSTANCE;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    companion.a(it, guildProfileData);
                }
            }
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com.google.android.material.bottomsheet.a aVar;
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior;
        ViewParent viewParent;
        super.onResume();
        Dialog dialog = getDialog();
        View view = null;
        if (dialog instanceof com.google.android.material.bottomsheet.a) {
            aVar = (com.google.android.material.bottomsheet.a) dialog;
        } else {
            aVar = null;
        }
        if (aVar != null) {
            bottomSheetBehavior = aVar.getBehavior();
        } else {
            bottomSheetBehavior = null;
        }
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.setPeekHeight(getResources().getDimensionPixelSize(R.dimen.cfk));
        }
        View view2 = getView();
        if (view2 != null) {
            viewParent = view2.getParent();
        } else {
            viewParent = null;
        }
        if (viewParent instanceof View) {
            view = (View) viewParent;
        }
        if (view != null) {
            view.setBackgroundColor(0);
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        GuildWelcomeGuideDialogFragment guildWelcomeGuideDialogFragment = this.mGuideDialog;
        if (guildWelcomeGuideDialogFragment != null) {
            guildWelcomeGuideDialogFragment.dismissAllowingStateLoss();
        }
        this.mGuideDialog = null;
    }
}
