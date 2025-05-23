package com.tencent.mobileqq.guild.mainframe.util;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import com.tencent.aelight.camera.qqstory.api.IVideoFilterTools;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.be;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.api.ILaunchGuildChatPieApi;
import com.tencent.mobileqq.guild.api.LaunchGuildChatPieParam;
import com.tencent.mobileqq.guild.base.extension.MiscKt;
import com.tencent.mobileqq.guild.heartbeatreport.impl.FacadeFragmentOnlineReportHelper;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.GuildFeedReportSourceInfo;
import com.tencent.mobileqq.guild.mainframe.GuildFragmentDelegateFrame;
import com.tencent.mobileqq.guild.mainframe.centerpanel.GuildCenterPanelController;
import com.tencent.mobileqq.guild.mainframe.manager.GuildMainFrameManager;
import com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.az;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.cy;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProCmd0x1258ExtendRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.cf;
import com.tencent.mobileqq.qqguildsdk.data.genc.cn;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetGuildAndChannelReq;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vh2.s;
import vh2.t;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u00014B\t\b\u0002\u00a2\u0006\u0004\b2\u00103J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u0014\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0007J\"\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0017J4\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\u0004H\u0017J&\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00022\u0014\u0010\u001b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0012\u0004\u0012\u00020\b0\u0019H\u0007J.\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00042\u0014\u0010\u001b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0012\u0004\u0012\u00020\b0\u0019H\u0007J4\u0010!\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u001a\u0010\u001b\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010 \u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u001fH\u0007JL\u0010%\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020\u000f2\b\b\u0002\u0010#\u001a\u00020\u00022\b\b\u0002\u0010\u001d\u001a\u00020\u00042\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\b0\u0019H\u0007J\u0018\u0010(\u001a\u00020\b2\u0006\u0010'\u001a\u00020&2\u0006\u0010\u0018\u001a\u00020\u0002H\u0002J$\u0010,\u001a\u0004\u0018\u00010 2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)H\u0002J9\u0010-\u001a\u00020$2\u0006\u0010\u0018\u001a\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020\u000f2\b\b\u0002\u0010#\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b-\u0010.J%\u00100\u001a\u00020$2\u0006\u0010/\u001a\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b0\u00101\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/util/GuildMainFrameUtils;", "", "", "channelId", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/guild/mainframe/i;", "mainViewContext", "", "d", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/guild/mainframe/s;", "p", "Lcom/tencent/mobileqq/app/QBaseActivity;", "", "fragmentType", "Lcom/tencent/mobileqq/guild/api/LaunchGuildChatPieParam;", "guildChatPieParam", "r", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam$ChannelDetailPageJumpInfo;", "pageJumpInfo", "fromLink", ReportConstant.COSTREPORT_PREFIX, "guildId", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "block", "k", "isForce", "l", "Lkotlin/Function2;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "e", "businessType", "inviteCode", "Lcom/tencent/mobileqq/guild/mainframe/util/GuildMainFrameUtils$a;", "g", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "gproService", "t", "", "Lcom/tencent/mobileqq/qqguildsdk/data/cy;", IVideoFilterTools.CATEGORYS, "o", "f", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "guildNum", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildMainFrameUtils {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GuildMainFrameUtils f227682a = new GuildMainFrameUtils();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\u0006\u0010\u0015\u001a\u00020\u0004\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001a\u0012\u0006\u0010 \u001a\u00020\u0004\u0012\u0006\u0010\"\u001a\u00020\u0006\u0012\u0006\u0010%\u001a\u00020\u0004\u0012\u0006\u0010&\u001a\u00020\u0006\u00a2\u0006\u0004\b'\u0010(J\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\t\u0010\u0007\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\b\u001a\u00020\u0004H\u00c6\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\tH\u00c6\u0003J\t\u0010\u000b\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\r\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0011\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0015\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001b\u0010\u001dR\u0017\u0010 \u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0012\u001a\u0004\b\u001f\u0010\u0014R\u0017\u0010\"\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b!\u0010\u000e\u001a\u0004\b!\u0010\u0010R\u0017\u0010%\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b#\u0010\u0012\u001a\u0004\b$\u0010\u0014R\u0017\u0010&\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u000e\u001a\u0004\b#\u0010\u0010\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/util/GuildMainFrameUtils$a;", "", "", "l", "", "toString", "", "a", "b", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "c", "hashCode", "other", "equals", "I", "k", "()I", "result", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "errMsg", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", tl.h.F, "()Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "d", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "()Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "channelInfo", "j", "joinSig", "f", "extCode", "g", "i", "inviterName", "feedNum", "<init>", "(ILjava/lang/String;Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;Ljava/lang/String;ILjava/lang/String;I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils$a, reason: from toString */
    /* loaded from: classes14.dex */
    public static final /* data */ class GuildAndChannelInfoRsp {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int result;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String errMsg;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final IGProGuildInfo guildInfo;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final IGProChannelInfo channelInfo;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String joinSig;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final int extCode;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String inviterName;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private final int feedNum;

        public GuildAndChannelInfoRsp(int i3, @NotNull String errMsg, @Nullable IGProGuildInfo iGProGuildInfo, @Nullable IGProChannelInfo iGProChannelInfo, @NotNull String joinSig, int i16, @NotNull String inviterName, int i17) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            Intrinsics.checkNotNullParameter(joinSig, "joinSig");
            Intrinsics.checkNotNullParameter(inviterName, "inviterName");
            this.result = i3;
            this.errMsg = errMsg;
            this.guildInfo = iGProGuildInfo;
            this.channelInfo = iGProChannelInfo;
            this.joinSig = joinSig;
            this.extCode = i16;
            this.inviterName = inviterName;
            this.feedNum = i17;
        }

        /* renamed from: a, reason: from getter */
        public final int getResult() {
            return this.result;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getErrMsg() {
            return this.errMsg;
        }

        @Nullable
        /* renamed from: c, reason: from getter */
        public final IGProGuildInfo getGuildInfo() {
            return this.guildInfo;
        }

        @Nullable
        /* renamed from: d, reason: from getter */
        public final IGProChannelInfo getChannelInfo() {
            return this.channelInfo;
        }

        @NotNull
        public final String e() {
            return this.errMsg;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GuildAndChannelInfoRsp)) {
                return false;
            }
            GuildAndChannelInfoRsp guildAndChannelInfoRsp = (GuildAndChannelInfoRsp) other;
            if (this.result == guildAndChannelInfoRsp.result && Intrinsics.areEqual(this.errMsg, guildAndChannelInfoRsp.errMsg) && Intrinsics.areEqual(this.guildInfo, guildAndChannelInfoRsp.guildInfo) && Intrinsics.areEqual(this.channelInfo, guildAndChannelInfoRsp.channelInfo) && Intrinsics.areEqual(this.joinSig, guildAndChannelInfoRsp.joinSig) && this.extCode == guildAndChannelInfoRsp.extCode && Intrinsics.areEqual(this.inviterName, guildAndChannelInfoRsp.inviterName) && this.feedNum == guildAndChannelInfoRsp.feedNum) {
                return true;
            }
            return false;
        }

        /* renamed from: f, reason: from getter */
        public final int getExtCode() {
            return this.extCode;
        }

        /* renamed from: g, reason: from getter */
        public final int getFeedNum() {
            return this.feedNum;
        }

        @Nullable
        public final IGProGuildInfo h() {
            return this.guildInfo;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2 = ((this.result * 31) + this.errMsg.hashCode()) * 31;
            IGProGuildInfo iGProGuildInfo = this.guildInfo;
            int i3 = 0;
            if (iGProGuildInfo == null) {
                hashCode = 0;
            } else {
                hashCode = iGProGuildInfo.hashCode();
            }
            int i16 = (hashCode2 + hashCode) * 31;
            IGProChannelInfo iGProChannelInfo = this.channelInfo;
            if (iGProChannelInfo != null) {
                i3 = iGProChannelInfo.hashCode();
            }
            return ((((((((i16 + i3) * 31) + this.joinSig.hashCode()) * 31) + this.extCode) * 31) + this.inviterName.hashCode()) * 31) + this.feedNum;
        }

        @NotNull
        /* renamed from: i, reason: from getter */
        public final String getInviterName() {
            return this.inviterName;
        }

        @NotNull
        /* renamed from: j, reason: from getter */
        public final String getJoinSig() {
            return this.joinSig;
        }

        public final int k() {
            return this.result;
        }

        public final boolean l() {
            IGProGuildInfo iGProGuildInfo;
            if (this.result == 0 && (iGProGuildInfo = this.guildInfo) != null) {
                String guildID = iGProGuildInfo.getGuildID();
                Intrinsics.checkNotNullExpressionValue(guildID, "guildInfo.guildID");
                if (MiscKt.l(guildID) != 0) {
                    return true;
                }
            }
            return false;
        }

        @NotNull
        public String toString() {
            return "GuildAndChannelInfoRsp(result=" + this.result + ", errMsg='" + this.errMsg + "', guildInfo=" + this.guildInfo + ", channelInfo=" + this.channelInfo + ", joinSig='" + this.joinSig + "')";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J4\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/guild/mainframe/util/GuildMainFrameUtils$b", "Lvh2/s;", "", "result", "", "errMsg", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "", "Lcom/tencent/mobileqq/qqguildsdk/data/cy;", IVideoFilterTools.CATEGORYS, "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements s {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function2<IGProChannelInfo, Boolean, Unit> f227691a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f227692b;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function2<? super IGProChannelInfo, ? super Boolean, Unit> function2, String str) {
            this.f227691a = function2;
            this.f227692b = str;
        }

        @Override // vh2.s
        public void a(int result, @Nullable String errMsg, @Nullable IGProGuildInfo guildInfo, @Nullable List<cy> categorys) {
            if (result == 0 && categorys != null) {
                String str = this.f227692b;
                Function2<IGProChannelInfo, Boolean, Unit> function2 = this.f227691a;
                Iterator<T> it = categorys.iterator();
                while (it.hasNext()) {
                    List<IGProChannelInfo> channelList = ((cy) it.next()).getChannelList();
                    Intrinsics.checkNotNullExpressionValue(channelList, "category.channelList");
                    for (IGProChannelInfo iGProChannelInfo : channelList) {
                        if (Intrinsics.areEqual(iGProChannelInfo.getChannelUin(), str)) {
                            function2.invoke(iGProChannelInfo, Boolean.TRUE);
                            return;
                        }
                    }
                }
                this.f227691a.invoke(null, Boolean.TRUE);
                return;
            }
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str2 = "fetchChannelInfoAnyway error, result" + result + " err:" + errMsg;
            if (str2 instanceof String) {
                bVar.a().add(str2);
            }
            Iterator<T> it5 = bVar.a().iterator();
            while (it5.hasNext()) {
                Logger.f235387a.d().e("GuildMainFrameUtils", 1, (String) it5.next(), null);
            }
            this.f227691a.invoke(null, Boolean.TRUE);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J4\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/guild/mainframe/util/GuildMainFrameUtils$c", "Lvh2/s;", "", "result", "", "errMsg", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "", "Lcom/tencent/mobileqq/qqguildsdk/data/cy;", IVideoFilterTools.CATEGORYS, "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements s {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<IGProGuildInfo, Unit> f227693a;

        /* JADX WARN: Multi-variable type inference failed */
        c(Function1<? super IGProGuildInfo, Unit> function1) {
            this.f227693a = function1;
        }

        @Override // vh2.s
        public void a(int result, @Nullable String errMsg, @Nullable IGProGuildInfo guildInfo, @Nullable List<cy> categorys) {
            if (result != 0) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                String str = "fetchGuildInfoAnyway error, result" + result + " err:" + errMsg;
                if (str instanceof String) {
                    bVar.a().add(str);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("GuildMainFrameUtils", 1, (String) it.next(), null);
                }
                this.f227693a.invoke(null);
                return;
            }
            this.f227693a.invoke(guildInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0001\u001a\u00020\u00002\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022\u000e\u0010\u0005\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062,\u0010\u000b\u001a(\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\t0\t\u0018\u0001 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\t0\t\u0018\u00010\n0\b2\u0006\u0010\f\u001a\u00020\u00002\u000e\u0010\u000e\u001a\n \u0003*\u0004\u0018\u00010\r0\rH\n\u00a2\u0006\u0004\b\u0010\u0010\u0011"}, d2 = {"", "result", "", "kotlin.jvm.PlatformType", "errMsg", "joinSig", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "", "Lcom/tencent/mobileqq/qqguildsdk/data/cy;", "", IVideoFilterTools.CATEGORYS, "extCode", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProCmd0x1258ExtendRsp;", "extendRsp", "", "a", "(ILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;Ljava/util/List;ILcom/tencent/mobileqq/qqguildsdk/data/genc/IGProCmd0x1258ExtendRsp;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d implements t {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f227694a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Continuation<GuildAndChannelInfoRsp> f227695b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ IGPSService f227696c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f227697d;

        /* JADX WARN: Multi-variable type inference failed */
        d(String str, Continuation<? super GuildAndChannelInfoRsp> continuation, IGPSService iGPSService, String str2) {
            this.f227694a = str;
            this.f227695b = continuation;
            this.f227696c = iGPSService;
            this.f227697d = str2;
        }

        @Override // vh2.t
        public final void a(int i3, String errMsg, String joinSig, @Nullable IGProGuildInfo iGProGuildInfo, @Nullable List<cy> list, int i16, IGProCmd0x1258ExtendRsp iGProCmd0x1258ExtendRsp) {
            Logger logger = Logger.f235387a;
            String str = this.f227697d;
            String str2 = this.f227694a;
            logger.d().w("GuildMainFrameUtils", 1, "fetchGuildInfoByNum guildId:" + str + " channelId:" + str2 + " result:" + i3 + " errMsg:" + errMsg + " joinSig:" + joinSig);
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            GuildMainFrameUtils guildMainFrameUtils = GuildMainFrameUtils.f227682a;
            IGProChannelInfo o16 = guildMainFrameUtils.o(this.f227694a, list);
            Intrinsics.checkNotNullExpressionValue(joinSig, "joinSig");
            String inviterName = iGProCmd0x1258ExtendRsp.getInviterName();
            Intrinsics.checkNotNullExpressionValue(inviterName, "extendRsp.inviterName");
            GuildAndChannelInfoRsp guildAndChannelInfoRsp = new GuildAndChannelInfoRsp(i3, errMsg, iGProGuildInfo, o16, joinSig, i16, inviterName, iGProCmd0x1258ExtendRsp.getGuildFeedNum());
            this.f227695b.resumeWith(Result.m476constructorimpl(guildAndChannelInfoRsp));
            if (guildAndChannelInfoRsp.l() && guildAndChannelInfoRsp.h() != null) {
                IGPSService iGPSService = this.f227696c;
                String guildID = guildAndChannelInfoRsp.h().getGuildID();
                Intrinsics.checkNotNullExpressionValue(guildID, "guildAndChannelInfoRsp.guildInfo.guildID");
                guildMainFrameUtils.t(iGPSService, guildID);
            }
        }
    }

    GuildMainFrameUtils() {
    }

    @JvmStatic
    public static final void d(@NotNull com.tencent.mobileqq.guild.mainframe.i mainViewContext) {
        Intrinsics.checkNotNullParameter(mainViewContext, "mainViewContext");
        QLog.d("GuildMainFrameUtils", 1, "closeCenterPanel");
        GuildCenterPanelController Z0 = mainViewContext.Z0();
        Intrinsics.checkNotNullExpressionValue(Z0, "mainViewContext\n        \u2026uildCenterPanelController");
        Z0.r();
    }

    @JvmStatic
    public static final void e(@NotNull String guildId, @NotNull String channelId, @NotNull Function2<? super IGProChannelInfo, ? super Boolean, Unit> block) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(block, "block");
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        IGPSService iGPSService = (IGPSService) S0;
        IGProChannelInfo channelInfo = iGPSService.getChannelInfo(channelId);
        if (channelInfo != null) {
            block.invoke(channelInfo, Boolean.FALSE);
            return;
        }
        long d16 = az.d(guildId, 0L);
        if (d16 <= 0) {
            QLog.e("GuildMainFrameUtils", 1, "guildId is Illegal, guildId = " + d16);
            block.invoke(null, Boolean.FALSE);
            return;
        }
        cn cnVar = new cn();
        cnVar.o(az.d(iGPSService.getSelfTinyId(), 0L));
        cnVar.l(true);
        cf cfVar = new cf();
        cfVar.d(d16);
        cnVar.b().add(cfVar);
        FacadeFragmentOnlineReportHelper.f224676a.l(iGPSService, guildId, cnVar);
        iGPSService.fetchGuestGuild(guildId, false, new b(block, channelId));
    }

    @JvmStatic
    public static final void g(@NotNull final String guildId, @NotNull final String channelId, final int businessType, @NotNull final String inviteCode, boolean isForce, @NotNull final Function1<? super GuildAndChannelInfoRsp, Unit> block) {
        boolean isBlank;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(inviteCode, "inviteCode");
        Intrinsics.checkNotNullParameter(block, "block");
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        IGPSService iGPSService = (IGPSService) S0;
        if (!isForce) {
            isBlank = StringsKt__StringsJVMKt.isBlank(inviteCode);
            if (isBlank && !iGPSService.isGuest(guildId)) {
                block.invoke(new GuildAndChannelInfoRsp(0, "", iGPSService.getGuildInfo(guildId), iGPSService.getChannelInfo(channelId), "", 0, "", 0));
                return;
            }
        }
        f227682a.t(iGPSService, guildId);
        GProGetGuildAndChannelReq gProGetGuildAndChannelReq = new GProGetGuildAndChannelReq();
        gProGetGuildAndChannelReq.guildId = MiscKt.l(guildId);
        gProGetGuildAndChannelReq.businessType = businessType;
        gProGetGuildAndChannelReq.inviteCode = inviteCode;
        iGPSService.fetchGuestGuildWithChannelListAndJoinSig(0, gProGetGuildAndChannelReq, new t() { // from class: com.tencent.mobileqq.guild.mainframe.util.g
            @Override // vh2.t
            public final void a(int i3, String str, String str2, IGProGuildInfo iGProGuildInfo, List list, int i16, IGProCmd0x1258ExtendRsp iGProCmd0x1258ExtendRsp) {
                GuildMainFrameUtils.j(channelId, block, guildId, businessType, inviteCode, i3, str, str2, iGProGuildInfo, list, i16, iGProCmd0x1258ExtendRsp);
            }
        });
    }

    public static /* synthetic */ Object h(GuildMainFrameUtils guildMainFrameUtils, String str, String str2, int i3, String str3, Continuation continuation, int i16, Object obj) {
        String str4;
        String str5;
        if ((i16 & 2) != 0) {
            str4 = "";
        } else {
            str4 = str2;
        }
        if ((i16 & 4) != 0) {
            i3 = 0;
        }
        int i17 = i3;
        if ((i16 & 8) != 0) {
            str5 = "";
        } else {
            str5 = str3;
        }
        return guildMainFrameUtils.f(str, str4, i17, str5, continuation);
    }

    public static /* synthetic */ void i(String str, String str2, int i3, String str3, boolean z16, Function1 function1, int i16, Object obj) {
        String str4;
        int i17;
        String str5;
        boolean z17;
        if ((i16 & 2) != 0) {
            str4 = "";
        } else {
            str4 = str2;
        }
        if ((i16 & 4) != 0) {
            i17 = 0;
        } else {
            i17 = i3;
        }
        if ((i16 & 8) != 0) {
            str5 = "";
        } else {
            str5 = str3;
        }
        if ((i16 & 16) != 0) {
            z17 = false;
        } else {
            z17 = z16;
        }
        g(str, str4, i17, str5, z17, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(String channelId, Function1 block, String guildId, int i3, String inviteCode, int i16, String errMsg, String joinSig, IGProGuildInfo iGProGuildInfo, List list, int i17, IGProCmd0x1258ExtendRsp iGProCmd0x1258ExtendRsp) {
        Intrinsics.checkNotNullParameter(channelId, "$channelId");
        Intrinsics.checkNotNullParameter(block, "$block");
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        Intrinsics.checkNotNullParameter(inviteCode, "$inviteCode");
        Logger.f235387a.d().w("GuildMainFrameUtils", 1, "fetchGuildAndChannelInfo guildId:" + guildId + " result:" + i16 + " errMsg:" + errMsg + " businessType:" + i3 + " inviteCode:" + inviteCode + " joinSig:" + joinSig);
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        IGProChannelInfo o16 = f227682a.o(channelId, list);
        Intrinsics.checkNotNullExpressionValue(joinSig, "joinSig");
        String inviterName = iGProCmd0x1258ExtendRsp.getInviterName();
        Intrinsics.checkNotNullExpressionValue(inviterName, "extendRsp.inviterName");
        block.invoke(new GuildAndChannelInfoRsp(i16, errMsg, iGProGuildInfo, o16, joinSig, i17, inviterName, iGProCmd0x1258ExtendRsp.getGuildFeedNum()));
    }

    @JvmStatic
    public static final void k(@NotNull String guildId, @NotNull Function1<? super IGProGuildInfo, Unit> block) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(block, "block");
        l(guildId, false, block);
    }

    @JvmStatic
    public static final void l(@NotNull String guildId, boolean isForce, @NotNull Function1<? super IGProGuildInfo, Unit> block) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(block, "block");
        try {
            IRuntimeService S0 = ch.S0(IGPSService.class, "");
            Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
            IGPSService iGPSService = (IGPSService) S0;
            IGProGuildInfo guildInfo = iGPSService.getGuildInfo(guildId);
            if (guildInfo != null && guildInfo.isMember()) {
                block.invoke(guildInfo);
                return;
            }
            if (guildInfo != null && !isForce) {
                block.invoke(guildInfo);
                return;
            }
            long d16 = az.d(guildId, 0L);
            if (d16 <= 0) {
                QLog.e("GuildMainFrameUtils", 1, "guildId is Illegal, guildId = " + d16);
                block.invoke(null);
                return;
            }
            cn cnVar = new cn();
            cnVar.o(az.d(iGPSService.getSelfTinyId(), 0L));
            cnVar.l(true);
            cnVar.n(0);
            cf cfVar = new cf();
            cfVar.d(d16);
            cnVar.b().add(cfVar);
            FacadeFragmentOnlineReportHelper.f224676a.l(iGPSService, guildId, cnVar);
            iGPSService.fetchGuestGuild(guildId, false, new c(block));
        } catch (IllegalStateException e16) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("fetchGuildInfoAnyway but sdk not ready");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("GuildMainFrameUtils", 1, (String) it.next(), e16);
            }
            block.invoke(null);
        }
    }

    public static /* synthetic */ Object n(GuildMainFrameUtils guildMainFrameUtils, String str, String str2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str2 = "";
        }
        return guildMainFrameUtils.m(str, str2, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IGProChannelInfo o(String channelId, List<? extends cy> categorys) {
        if (!q(channelId) && categorys != null) {
            Iterator<? extends cy> it = categorys.iterator();
            while (it.hasNext()) {
                for (IGProChannelInfo iGProChannelInfo : it.next().getChannelList()) {
                    if (Intrinsics.areEqual(iGProChannelInfo.getChannelUin(), channelId)) {
                        return iGProChannelInfo;
                    }
                }
            }
        }
        return null;
    }

    @JvmStatic
    @Nullable
    public static final com.tencent.mobileqq.guild.mainframe.s p(@Nullable FragmentActivity activity) {
        FrameFragment mainFragment;
        if (activity == null) {
            mainFragment = ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).getMainFragment();
        } else {
            mainFragment = ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).getMainFragment(activity);
        }
        if (mainFragment == null) {
            return null;
        }
        be frame = mainFragment.getFrame(GuildFragmentDelegateFrame.class);
        if (!(frame instanceof com.tencent.mobileqq.guild.mainframe.s)) {
            return null;
        }
        return (com.tencent.mobileqq.guild.mainframe.s) frame;
    }

    @JvmStatic
    public static final boolean q(@Nullable String channelId) {
        if (!TextUtils.isEmpty(channelId) && !Intrinsics.areEqual("0", channelId)) {
            return false;
        }
        return true;
    }

    @JvmStatic
    public static boolean r(@NotNull QBaseActivity activity, int fragmentType, @Nullable LaunchGuildChatPieParam guildChatPieParam) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return s(activity, fragmentType, guildChatPieParam, null, false);
    }

    @JvmStatic
    public static boolean s(@NotNull QBaseActivity activity, int fragmentType, @Nullable LaunchGuildChatPieParam guildChatPieParam, @Nullable JumpGuildParam.ChannelDetailPageJumpInfo pageJumpInfo, boolean fromLink) {
        Integer num;
        Intrinsics.checkNotNullParameter(activity, "activity");
        boolean z16 = false;
        if (!AppSetting.t(activity) && ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).isChatFragmentShowing(activity)) {
            QLog.w("GuildMainFrameUtils", 1, "open text channel but other aio is open!!");
            return false;
        }
        Logger.a d16 = Logger.f235387a.d();
        if (guildChatPieParam != null) {
            num = Integer.valueOf(guildChatPieParam.E);
        } else {
            num = null;
        }
        d16.i("GuildMainFrameUtils", 1, "openChatCenterPanel Type=" + fragmentType + " from=" + num + " params=" + guildChatPieParam + " ");
        Intent intent = activity.getIntent();
        if (guildChatPieParam != null && guildChatPieParam.E == 6) {
            z16 = true;
        }
        if (!z16) {
            intent = ((ILaunchGuildChatPieApi) QRoute.api(ILaunchGuildChatPieApi.class)).getGuildChatPieIntent(activity, guildChatPieParam);
        } else {
            QLog.w("GuildMainFrameUtils", 1, "openChatCenterPanel from jumpAction guildId=" + guildChatPieParam.f214354d);
        }
        if (pageJumpInfo != null) {
            intent.putExtra(JumpGuildParam.KEY_DETAIL_PAGE_JUMP_INFO, (Parcelable) pageJumpInfo);
        }
        GuildFeedReportSourceInfo guildFeedReportSourceInfo = new GuildFeedReportSourceInfo();
        if (!fromLink) {
            guildFeedReportSourceInfo.addReportItem("extra_feeds_pre_page_id", "pg_sgrp_channel");
        } else {
            guildFeedReportSourceInfo.addReportItem("extra_feeds_pre_page_id", "ark_link_share");
        }
        Bundle bundleExtra = intent.getBundleExtra(AppConstants.Key.GUILD_EXTRA);
        if (bundleExtra != null) {
            bundleExtra.putParcelable("GuildFeedReportSourceInfo", guildFeedReportSourceInfo);
        }
        GuildCenterPanelController f16 = GuildMainFrameManager.f();
        if (f16 != null) {
            f16.F(fragmentType, intent);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(IGPSService gproService, String guildId) {
        Long longOrNull;
        long j3;
        Long longOrNull2;
        cn cnVar = new cn();
        String selfTinyId = gproService.getSelfTinyId();
        Intrinsics.checkNotNullExpressionValue(selfTinyId, "gproService.selfTinyId");
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(selfTinyId);
        long j16 = 0;
        if (longOrNull != null) {
            j3 = longOrNull.longValue();
        } else {
            j3 = 0;
        }
        cnVar.o(j3);
        cnVar.l(true);
        cf cfVar = new cf();
        longOrNull2 = StringsKt__StringNumberConversionsKt.toLongOrNull(guildId);
        if (longOrNull2 != null) {
            j16 = longOrNull2.longValue();
        }
        cfVar.d(j16);
        cnVar.b().add(cfVar);
        FacadeFragmentOnlineReportHelper.f224676a.l(gproService, guildId, cnVar);
    }

    @Nullable
    public final Object f(@NotNull String str, @NotNull String str2, int i3, @NotNull String str3, @NotNull Continuation<? super GuildAndChannelInfoRsp> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("GuildMainFrameUtils", "fetchGuildAndChannelInfo async");
        }
        i(str, str2, i3, str3, false, new Function1<GuildAndChannelInfoRsp, Unit>() { // from class: com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils$fetchGuildAndChannelInfo$3$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GuildMainFrameUtils.GuildAndChannelInfoRsp guildAndChannelInfoRsp) {
                invoke2(guildAndChannelInfoRsp);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull GuildMainFrameUtils.GuildAndChannelInfoRsp guildAndChannelInfoRsp) {
                Intrinsics.checkNotNullParameter(guildAndChannelInfoRsp, "guildAndChannelInfoRsp");
                safeContinuation.resumeWith(Result.m476constructorimpl(guildAndChannelInfoRsp));
            }
        }, 16, null);
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    @Nullable
    public final Object m(@NotNull String str, @NotNull String str2, @NotNull Continuation<? super GuildAndChannelInfoRsp> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        GProGetGuildAndChannelReq gProGetGuildAndChannelReq = new GProGetGuildAndChannelReq();
        gProGetGuildAndChannelReq.guildNum = str;
        gProGetGuildAndChannelReq.businessType = 21;
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        IGPSService iGPSService = (IGPSService) S0;
        iGPSService.fetchGuestGuildWithChannelListAndJoinSig(0, gProGetGuildAndChannelReq, new d(str2, safeContinuation, iGPSService, str));
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }
}
