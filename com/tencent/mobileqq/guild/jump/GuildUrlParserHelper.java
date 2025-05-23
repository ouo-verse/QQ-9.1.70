package com.tencent.mobileqq.guild.jump;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.dt.api.ScanPicData;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.api.impl.QQGuildRouterApiImpl;
import com.tencent.mobileqq.guild.base.extension.MiscKt;
import com.tencent.mobileqq.guild.jump.GuildJumpArkCheck;
import com.tencent.mobileqq.guild.jump.model.BaseGuildShareParam;
import com.tencent.mobileqq.guild.jump.model.GuildShareInviteCodeParam;
import com.tencent.mobileqq.guild.jump.model.GuildShareUrlParam;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ThreadUtils;
import com.tencent.mobileqq.guild.util.bg;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProBusinessData;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProInviteInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProVerifyShareInfoRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.fg;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.zootopia.ue.PayPluginScene;
import com.tencent.util.QQToastUtil;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.group_pro_proto.channel_share.ChannelShareRequest$FeedParam;
import tencent.im.group_pro_proto.channel_share.ChannelShareResponse$Schedule;
import wh2.ez;
import wh2.r;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002FGB\t\b\u0002\u00a2\u0006\u0004\bD\u0010EJW\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0004\u0018\u00010\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000fJ-\u0010\u0011\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012J9\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0004\u0018\u00010\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0012J\u0018\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0004H\u0002J\u001e\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0004\u0018\u00010\f2\u0006\u0010\u0017\u001a\u00020\u0004H\u0002J4\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00040\f2\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004H\u0002J9\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0004\u0018\u00010\f2\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\"\u0010\"\u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u00042\b\b\u0002\u0010 \u001a\u00020\bH\u0002J\u001a\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010$\u001a\u00020#2\u0006\u0010\t\u001a\u00020\bH\u0002J \u0010+\u001a\u00020!2\u0006\u0010'\u001a\u00020\r2\u0006\u0010(\u001a\u00020\u00042\u0006\u0010*\u001a\u00020)H\u0002J@\u00103\u001a\u00020!2\u0006\u0010'\u001a\u00020\r2\u0006\u0010,\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u00152\u0006\u0010.\u001a\u00020\u00042\u0006\u0010*\u001a\u00020)2\u0006\u00100\u001a\u00020/2\u0006\u00102\u001a\u000201H\u0002J(\u00107\u001a\u0002012\u0006\u00105\u001a\u0002042\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\r2\u0006\u00106\u001a\u00020)H\u0002J(\u00108\u001a\u00020/2\u0006\u00105\u001a\u0002042\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\r2\u0006\u00106\u001a\u00020)H\u0002J\u0010\u0010;\u001a\u00020\b2\u0006\u0010:\u001a\u000209H\u0002J\u0018\u0010>\u001a\u00020\u00042\u0006\u0010<\u001a\u00020/2\u0006\u0010=\u001a\u000201H\u0002J \u0010?\u001a\u00020\u00042\u0006\u0010<\u001a\u00020/2\u0006\u0010=\u001a\u0002012\u0006\u0010,\u001a\u00020\u0004H\u0002J-\u0010B\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010A\u001a\u00020@2\u0006\u0010\u000b\u001a\u00020\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\bB\u0010C\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006H"}, d2 = {"Lcom/tencent/mobileqq/guild/jump/GuildUrlParserHelper;", "", "Landroid/content/Context;", "context", "", "inviteCode", "contentId", "shortUrl", "", "businessType", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "reportTask", "Lkotlin/Pair;", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "o", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mobileqq/guild/report/IPerformanceReportTask;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "jumpInfo", "g", "(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "originalUrl", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "url", "e", "guildNumber", "channelId", "f", "d", "(Ljava/lang/String;Landroid/content/Context;Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "textResId", "tag", "iconId", "", ReportConstant.COSTREPORT_PREFIX, "", "businessParam", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam$ChannelDetailPageJumpInfo;", DomainData.DOMAIN_NAME, "params", "longUrl", "Landroid/os/Bundle;", "extra", "u", "defaultPginSource", "isFromQZone", "inviteContentID", "Lcom/tencent/mobileqq/guild/jump/GuildUrlParserHelper$SHARE_SOURCE;", "shareJumpSource", "Lcom/tencent/mobileqq/guild/jump/GuildUrlParserHelper$SHARE_SCENE;", "shareJumpScene", "v", "Landroid/content/Intent;", "intent", "jumpExtra", "i", "j", "Landroid/net/Uri;", LayoutAttrDefine.CLICK_URI, tl.h.F, "source", "scene", "l", "k", "Lcom/tencent/mobileqq/guild/jump/model/BaseGuildShareParam;", "originalParam", "r", "(Landroid/content/Context;Lcom/tencent/mobileqq/guild/jump/model/BaseGuildShareParam;Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "SHARE_SCENE", "SHARE_SOURCE", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildUrlParserHelper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GuildUrlParserHelper f226381a = new GuildUrlParserHelper();

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/jump/GuildUrlParserHelper$SHARE_SCENE;", "", "(Ljava/lang/String;I)V", ProtocolDownloaderConstants.HOST_C2C, "GROUP", "QZONE", "GUILD_INSIDE", "OUTSIDE", PayPluginScene.OTHERS, "FORWARD", "QQSCAN", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public enum SHARE_SCENE {
        C2C,
        GROUP,
        QZONE,
        GUILD_INSIDE,
        OUTSIDE,
        OTHERS,
        FORWARD,
        QQSCAN
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/jump/GuildUrlParserHelper$SHARE_SOURCE;", "", "(Ljava/lang/String;I)V", "SHARE_ARK", "GUILD_QR_CODE", "FEED_QR_CODE", "GUILD_NUMBER", "WEB_URL", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public enum SHARE_SOURCE {
        SHARE_ARK,
        GUILD_QR_CODE,
        FEED_QR_CODE,
        GUILD_NUMBER,
        WEB_URL
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f226386a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f226387b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f226388c;

        static {
            int[] iArr = new int[GuildJumpArkCheck.ArkShareScene.values().length];
            try {
                iArr[GuildJumpArkCheck.ArkShareScene.C2C.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[GuildJumpArkCheck.ArkShareScene.TROOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[GuildJumpArkCheck.ArkShareScene.QZONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[GuildJumpArkCheck.ArkShareScene.GUILD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f226386a = iArr;
            int[] iArr2 = new int[SHARE_SCENE.values().length];
            try {
                iArr2[SHARE_SCENE.C2C.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[SHARE_SCENE.GROUP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[SHARE_SCENE.GUILD_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[SHARE_SCENE.QZONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[SHARE_SCENE.OUTSIDE.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[SHARE_SCENE.QQSCAN.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr2[SHARE_SCENE.FORWARD.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            f226387b = iArr2;
            int[] iArr3 = new int[SHARE_SOURCE.values().length];
            try {
                iArr3[SHARE_SOURCE.SHARE_ARK.ordinal()] = 1;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr3[SHARE_SOURCE.GUILD_QR_CODE.ordinal()] = 2;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr3[SHARE_SOURCE.FEED_QR_CODE.ordinal()] = 3;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr3[SHARE_SOURCE.WEB_URL.ordinal()] = 4;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr3[SHARE_SOURCE.GUILD_NUMBER.ordinal()] = 5;
            } catch (NoSuchFieldError unused16) {
            }
            f226388c = iArr3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\n\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\u00002\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022\u000e\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\b\u001a\n \u0003*\u0004\u0018\u00010\u00070\u0007H\n\u00a2\u0006\u0004\b\n\u0010\u000b"}, d2 = {"", "result", "", "kotlin.jvm.PlatformType", "errMsg", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProInviteInfo;", "inviteInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProBusinessData;", "bizData", "", "a", "(ILjava/lang/String;Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProInviteInfo;Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProBusinessData;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements r {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IPerformanceReportTask f226389a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Continuation<JumpGuildParam> f226390b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f226391c;

        /* JADX WARN: Multi-variable type inference failed */
        b(IPerformanceReportTask iPerformanceReportTask, Continuation<? super JumpGuildParam> continuation, String str) {
            this.f226389a = iPerformanceReportTask;
            this.f226390b = continuation;
            this.f226391c = str;
        }

        @Override // wh2.r
        public final void a(int i3, String errMsg, IGProInviteInfo iGProInviteInfo, IGProBusinessData iGProBusinessData) {
            boolean z16;
            IPerformanceReportTask iPerformanceReportTask = this.f226389a;
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            qw1.b.b(iPerformanceReportTask, i3, errMsg);
            if (i3 == 0 && iGProInviteInfo != null) {
                JumpGuildParam jumpGuildParam = new JumpGuildParam(String.valueOf(iGProInviteInfo.getGuildId()), String.valueOf(iGProInviteInfo.getChnId()));
                byte[] businessParam = iGProBusinessData.getBusinessParam();
                Intrinsics.checkNotNullExpressionValue(businessParam, "bizData.businessParam");
                if (businessParam.length == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    GuildUrlParserHelper guildUrlParserHelper = GuildUrlParserHelper.f226381a;
                    byte[] businessParam2 = iGProBusinessData.getBusinessParam();
                    Intrinsics.checkNotNullExpressionValue(businessParam2, "bizData.businessParam");
                    jumpGuildParam.setDetailPageJumpInfo(guildUrlParserHelper.n(businessParam2, iGProBusinessData.getBusinessType()));
                }
                Logger logger = Logger.f235387a;
                String str = this.f226391c;
                logger.d().d("Guild.jump.GuildUrlParserHelper", 1, "fetInviteInfoByJumpInfo params:" + jumpGuildParam + " jumpInfo:" + str);
                this.f226390b.resumeWith(Result.m476constructorimpl(jumpGuildParam));
                return;
            }
            Logger logger2 = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str2 = "fetInviteInfoByJumpInfo error result:" + i3 + " errMsg:" + errMsg + " ";
            if (str2 instanceof String) {
                bVar.a().add(str2);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.jump.GuildUrlParserHelper", 1, (String) it.next(), null);
            }
            this.f226390b.resumeWith(Result.m476constructorimpl(null));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004H\n\u00a2\u0006\u0004\b\b\u0010\t"}, d2 = {"", "result", "", "errMsg", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProVerifyShareInfoRsp;", "kotlin.jvm.PlatformType", "rsp", "", "a", "(ILjava/lang/String;Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProVerifyShareInfoRsp;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements ez {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IPerformanceReportTask f226392a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f226393b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Continuation<Pair<? extends JumpGuildParam, String>> f226394c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f226395d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f226396e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f226397f;

        /* JADX WARN: Multi-variable type inference failed */
        c(IPerformanceReportTask iPerformanceReportTask, Context context, Continuation<? super Pair<? extends JumpGuildParam, String>> continuation, String str, String str2, String str3) {
            this.f226392a = iPerformanceReportTask;
            this.f226393b = context;
            this.f226394c = continuation;
            this.f226395d = str;
            this.f226396e = str2;
            this.f226397f = str3;
        }

        @Override // wh2.ez
        public final void a(int i3, @NotNull String errMsg, IGProVerifyShareInfoRsp iGProVerifyShareInfoRsp) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            qw1.b.b(this.f226392a, i3, errMsg);
            IGProGuildInfo convertToGuildInfo = ((IGPSService) ch.R0(IGPSService.class)).convertToGuildInfo(iGProVerifyShareInfoRsp.getGuildInfo(), iGProVerifyShareInfoRsp.getErrCode(), iGProVerifyShareInfoRsp.getUserInfo());
            if (i3 != 0) {
                com.tencent.mobileqq.guild.util.security.b.c(this.f226393b, i3, errMsg, QQGuildUIUtil.r(R.string.f15162187));
                this.f226394c.resumeWith(Result.m476constructorimpl(null));
                return;
            }
            GuildJumpHelper guildJumpHelper = GuildJumpHelper.f226371a;
            Context context = this.f226393b;
            int errCode = iGProVerifyShareInfoRsp.getErrCode();
            String errMsg2 = iGProVerifyShareInfoRsp.getErrMsg();
            Intrinsics.checkNotNullExpressionValue(errMsg2, "rsp.errMsg");
            if (guildJumpHelper.g(context, errCode, errMsg2, new JumpGuildParam(String.valueOf(iGProVerifyShareInfoRsp.getGuildInfo().getGuildId()), String.valueOf(iGProVerifyShareInfoRsp.getGuildInfo().getChannel())), convertToGuildInfo)) {
                Logger logger = Logger.f235387a;
                String str = this.f226395d;
                String str2 = this.f226396e;
                String str3 = this.f226397f;
                Logger.b bVar = new Logger.b();
                String str4 = "parseCodeToJumpParam error " + str + "-" + str2 + "-" + str3 + " result:" + i3 + " errMsg:" + errMsg + " ";
                if (str4 instanceof String) {
                    bVar.a().add(str4);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("Guild.jump.GuildUrlParserHelper", 1, (String) it.next(), null);
                }
                this.f226394c.resumeWith(Result.m476constructorimpl(null));
                return;
            }
            JumpGuildParam jumpGuildParam = new JumpGuildParam(String.valueOf(iGProVerifyShareInfoRsp.getGuildInfo().getGuildId()), String.valueOf(iGProVerifyShareInfoRsp.getGuildInfo().getChannel()));
            String str5 = "";
            jumpGuildParam.setJoinInfoParam(new JumpGuildParam.JoinInfoParam(iGProVerifyShareInfoRsp.getGuildInfo().getJoinGuildSig(), "", ""));
            if (iGProVerifyShareInfoRsp.getBusinessData() != null && iGProVerifyShareInfoRsp.getBusinessData().getBusinessParam() != null) {
                GuildUrlParserHelper guildUrlParserHelper = GuildUrlParserHelper.f226381a;
                byte[] businessParam = iGProVerifyShareInfoRsp.getBusinessData().getBusinessParam();
                Intrinsics.checkNotNullExpressionValue(businessParam, "rsp.businessData.businessParam");
                jumpGuildParam.setDetailPageJumpInfo(guildUrlParserHelper.n(businessParam, iGProVerifyShareInfoRsp.getBusinessData().getBusinessType()));
            }
            jumpGuildParam.businessType = iGProVerifyShareInfoRsp.getBusinessData().getBusinessType();
            jumpGuildParam.extras.putBoolean("jumpGuildFromLoadingPage", true);
            Logger logger2 = Logger.f235387a;
            String str6 = this.f226395d;
            String str7 = this.f226397f;
            logger2.d().d("Guild.jump.GuildUrlParserHelper", 1, "parseCodeToJumpParam params:" + jumpGuildParam + " code:" + str6 + " shortUrl:" + str7 + " longUrl:" + iGProVerifyShareInfoRsp.getLinkDetail().getLongUrl());
            Continuation<Pair<? extends JumpGuildParam, String>> continuation = this.f226394c;
            String longUrl = iGProVerifyShareInfoRsp.getLinkDetail().getLongUrl();
            if (longUrl != null) {
                str5 = longUrl;
            }
            continuation.resumeWith(Result.m476constructorimpl(new Pair(jumpGuildParam, str5)));
        }
    }

    GuildUrlParserHelper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x014e, code lost:
    
        if (r0 == null) goto L43;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0032  */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15, types: [T] */
    /* JADX WARN: Type inference failed for: r0v23, types: [T] */
    /* JADX WARN: Type inference failed for: r0v28, types: [com.tencent.mobileqq.guild.util.Logger$a] */
    /* JADX WARN: Type inference failed for: r0v37 */
    /* JADX WARN: Type inference failed for: r0v40 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r26v0, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v8, types: [int] */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3, types: [T] */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7, types: [T] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object d(String str, Context context, IPerformanceReportTask iPerformanceReportTask, Continuation<? super Pair<? extends JumpGuildParam, String>> continuation) {
        GuildUrlParserHelper$buildGuildParamByInviteCode$1 guildUrlParserHelper$buildGuildParamByInviteCode$1;
        Object coroutine_suspended;
        int i3;
        String str2;
        String str3;
        boolean z16;
        boolean isBlank;
        String str4;
        Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        String str5;
        int i16;
        IPerformanceReportTask iPerformanceReportTask2;
        Context context2;
        GuildUrlParserHelper guildUrlParserHelper;
        Ref.ObjectRef objectRef3;
        GuildUrlParserHelper guildUrlParserHelper2;
        Ref.ObjectRef objectRef4;
        Ref.ObjectRef objectRef5;
        ?? r06;
        int i17;
        int i18;
        GuildUrlParserHelper guildUrlParserHelper3;
        String str6;
        String str7;
        Ref.ObjectRef objectRef6;
        Ref.ObjectRef objectRef7;
        Object obj;
        Pair pair;
        ?? r85;
        ?? r07;
        boolean isBlank2;
        ?? r75;
        Object obj2;
        boolean z17;
        JumpGuildParam jumpGuildParam;
        Object obj3;
        Pair pair2;
        ?? r86;
        Context context3 = context;
        IPerformanceReportTask iPerformanceReportTask3 = iPerformanceReportTask;
        if (continuation instanceof GuildUrlParserHelper$buildGuildParamByInviteCode$1) {
            guildUrlParserHelper$buildGuildParamByInviteCode$1 = (GuildUrlParserHelper$buildGuildParamByInviteCode$1) continuation;
            int i19 = guildUrlParserHelper$buildGuildParamByInviteCode$1.label;
            if ((i19 & Integer.MIN_VALUE) != 0) {
                guildUrlParserHelper$buildGuildParamByInviteCode$1.label = i19 - Integer.MIN_VALUE;
                GuildUrlParserHelper$buildGuildParamByInviteCode$1 guildUrlParserHelper$buildGuildParamByInviteCode$12 = guildUrlParserHelper$buildGuildParamByInviteCode$1;
                Object obj4 = guildUrlParserHelper$buildGuildParamByInviteCode$12.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = guildUrlParserHelper$buildGuildParamByInviteCode$12.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 == 3) {
                                objectRef2 = (Ref.ObjectRef) guildUrlParserHelper$buildGuildParamByInviteCode$12.L$1;
                                objectRef = (Ref.ObjectRef) guildUrlParserHelper$buildGuildParamByInviteCode$12.L$0;
                                ResultKt.throwOnFailure(obj4);
                                obj2 = null;
                                z17 = true;
                                obj3 = obj4;
                                pair2 = (Pair) obj3;
                                if (pair2 == null) {
                                    r86 = (JumpGuildParam) pair2.getFirst();
                                } else {
                                    r86 = obj2;
                                }
                                objectRef2.element = r86;
                                r75 = z17;
                                if (objectRef2.element != null) {
                                    GuildJumpLoadingFragment.INSTANCE.a();
                                    return obj2;
                                }
                                Logger.f235387a.d().d("Guild.jump.GuildUrlParserHelper", r75, "buildGuildParamByInviteCode params:" + objectRef2.element + " url:" + objectRef.element);
                                return new Pair(objectRef2.element, objectRef.element);
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        i17 = guildUrlParserHelper$buildGuildParamByInviteCode$12.I$0;
                        objectRef3 = (Ref.ObjectRef) guildUrlParserHelper$buildGuildParamByInviteCode$12.L$7;
                        str5 = (String) guildUrlParserHelper$buildGuildParamByInviteCode$12.L$6;
                        str4 = (String) guildUrlParserHelper$buildGuildParamByInviteCode$12.L$5;
                        objectRef4 = (Ref.ObjectRef) guildUrlParserHelper$buildGuildParamByInviteCode$12.L$4;
                        objectRef5 = (Ref.ObjectRef) guildUrlParserHelper$buildGuildParamByInviteCode$12.L$3;
                        IPerformanceReportTask iPerformanceReportTask4 = (IPerformanceReportTask) guildUrlParserHelper$buildGuildParamByInviteCode$12.L$2;
                        context3 = (Context) guildUrlParserHelper$buildGuildParamByInviteCode$12.L$1;
                        GuildUrlParserHelper guildUrlParserHelper4 = (GuildUrlParserHelper) guildUrlParserHelper$buildGuildParamByInviteCode$12.L$0;
                        ResultKt.throwOnFailure(obj4);
                        z16 = true;
                        iPerformanceReportTask3 = iPerformanceReportTask4;
                        guildUrlParserHelper2 = guildUrlParserHelper4;
                        r06 = obj4;
                        objectRef3.element = r06;
                        jumpGuildParam = (JumpGuildParam) objectRef4.element;
                        if (jumpGuildParam != null) {
                            jumpGuildParam.inviteCode = str4;
                        }
                        i16 = i17;
                        objectRef2 = objectRef4;
                        objectRef = objectRef5;
                        iPerformanceReportTask2 = iPerformanceReportTask3;
                        context2 = context3;
                        guildUrlParserHelper = guildUrlParserHelper2;
                    } else {
                        i18 = guildUrlParserHelper$buildGuildParamByInviteCode$12.I$0;
                        str6 = (String) guildUrlParserHelper$buildGuildParamByInviteCode$12.L$6;
                        str7 = (String) guildUrlParserHelper$buildGuildParamByInviteCode$12.L$5;
                        objectRef6 = (Ref.ObjectRef) guildUrlParserHelper$buildGuildParamByInviteCode$12.L$4;
                        objectRef7 = (Ref.ObjectRef) guildUrlParserHelper$buildGuildParamByInviteCode$12.L$3;
                        IPerformanceReportTask iPerformanceReportTask5 = (IPerformanceReportTask) guildUrlParserHelper$buildGuildParamByInviteCode$12.L$2;
                        Context context4 = (Context) guildUrlParserHelper$buildGuildParamByInviteCode$12.L$1;
                        GuildUrlParserHelper guildUrlParserHelper5 = (GuildUrlParserHelper) guildUrlParserHelper$buildGuildParamByInviteCode$12.L$0;
                        ResultKt.throwOnFailure(obj4);
                        iPerformanceReportTask3 = iPerformanceReportTask5;
                        z16 = true;
                        guildUrlParserHelper3 = guildUrlParserHelper5;
                        context3 = context4;
                        obj = obj4;
                        pair = (Pair) obj;
                        if (pair == null) {
                            r85 = (JumpGuildParam) pair.getFirst();
                        } else {
                            r85 = 0;
                        }
                        objectRef6.element = r85;
                        if (pair != null) {
                            String str8 = (String) pair.getSecond();
                            r07 = str8;
                        }
                        r07 = "";
                        objectRef7.element = r07;
                        i16 = i18;
                        objectRef2 = objectRef6;
                        iPerformanceReportTask2 = iPerformanceReportTask3;
                        str4 = str7;
                        context2 = context3;
                        str5 = str6;
                        objectRef = objectRef7;
                        guildUrlParserHelper = guildUrlParserHelper3;
                    }
                } else {
                    ResultKt.throwOnFailure(obj4);
                    Ref.ObjectRef objectRef8 = new Ref.ObjectRef();
                    objectRef8.element = str;
                    Ref.ObjectRef objectRef9 = new Ref.ObjectRef();
                    Uri a16 = bg.f235465a.a((String) objectRef8.element);
                    String queryParameter = a16.getQueryParameter("inviteCode");
                    if (queryParameter == null) {
                        str2 = "";
                    } else {
                        str2 = queryParameter;
                    }
                    String queryParameter2 = a16.getQueryParameter("contentID");
                    if (queryParameter2 == null) {
                        str3 = "";
                    } else {
                        str3 = queryParameter2;
                    }
                    String queryParameter3 = a16.getQueryParameter("jumpInfo");
                    if (queryParameter3 == null) {
                        queryParameter3 = "";
                    }
                    int h16 = h(a16);
                    if (com.tencent.mobileqq.guild.share.shorturl.a.k(str)) {
                        guildUrlParserHelper$buildGuildParamByInviteCode$12.L$0 = this;
                        guildUrlParserHelper$buildGuildParamByInviteCode$12.L$1 = context3;
                        guildUrlParserHelper$buildGuildParamByInviteCode$12.L$2 = iPerformanceReportTask3;
                        guildUrlParserHelper$buildGuildParamByInviteCode$12.L$3 = objectRef8;
                        guildUrlParserHelper$buildGuildParamByInviteCode$12.L$4 = objectRef9;
                        guildUrlParserHelper$buildGuildParamByInviteCode$12.L$5 = str2;
                        guildUrlParserHelper$buildGuildParamByInviteCode$12.L$6 = str3;
                        guildUrlParserHelper$buildGuildParamByInviteCode$12.I$0 = h16;
                        guildUrlParserHelper$buildGuildParamByInviteCode$12.label = 1;
                        String str9 = str3;
                        String str10 = str2;
                        z16 = true;
                        Object p16 = p(this, context, null, null, str, h16, iPerformanceReportTask, guildUrlParserHelper$buildGuildParamByInviteCode$12, 6, null);
                        if (p16 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        i18 = h16;
                        guildUrlParserHelper3 = this;
                        str6 = str9;
                        str7 = str10;
                        objectRef6 = objectRef9;
                        objectRef7 = objectRef8;
                        obj = p16;
                        pair = (Pair) obj;
                        if (pair == null) {
                        }
                        objectRef6.element = r85;
                        if (pair != null) {
                        }
                        r07 = "";
                        objectRef7.element = r07;
                        i16 = i18;
                        objectRef2 = objectRef6;
                        iPerformanceReportTask2 = iPerformanceReportTask3;
                        str4 = str7;
                        context2 = context3;
                        str5 = str6;
                        objectRef = objectRef7;
                        guildUrlParserHelper = guildUrlParserHelper3;
                    } else {
                        String str11 = str3;
                        String str12 = str2;
                        z16 = true;
                        isBlank = StringsKt__StringsJVMKt.isBlank(queryParameter3);
                        if (!isBlank) {
                            guildUrlParserHelper$buildGuildParamByInviteCode$12.L$0 = this;
                            guildUrlParserHelper$buildGuildParamByInviteCode$12.L$1 = context3;
                            guildUrlParserHelper$buildGuildParamByInviteCode$12.L$2 = iPerformanceReportTask3;
                            guildUrlParserHelper$buildGuildParamByInviteCode$12.L$3 = objectRef8;
                            guildUrlParserHelper$buildGuildParamByInviteCode$12.L$4 = objectRef9;
                            str4 = str12;
                            guildUrlParserHelper$buildGuildParamByInviteCode$12.L$5 = str4;
                            guildUrlParserHelper$buildGuildParamByInviteCode$12.L$6 = str11;
                            guildUrlParserHelper$buildGuildParamByInviteCode$12.L$7 = objectRef9;
                            guildUrlParserHelper$buildGuildParamByInviteCode$12.I$0 = h16;
                            guildUrlParserHelper$buildGuildParamByInviteCode$12.label = 2;
                            Object g16 = g(context3, queryParameter3, iPerformanceReportTask3, guildUrlParserHelper$buildGuildParamByInviteCode$12);
                            if (g16 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            objectRef3 = objectRef9;
                            guildUrlParserHelper2 = this;
                            str5 = str11;
                            objectRef4 = objectRef3;
                            objectRef5 = objectRef8;
                            r06 = g16;
                            i17 = h16;
                            objectRef3.element = r06;
                            jumpGuildParam = (JumpGuildParam) objectRef4.element;
                            if (jumpGuildParam != null) {
                            }
                            i16 = i17;
                            objectRef2 = objectRef4;
                            objectRef = objectRef5;
                            iPerformanceReportTask2 = iPerformanceReportTask3;
                            context2 = context3;
                            guildUrlParserHelper = guildUrlParserHelper2;
                        } else {
                            str4 = str12;
                            objectRef = objectRef8;
                            objectRef2 = objectRef9;
                            str5 = str11;
                            i16 = h16;
                            iPerformanceReportTask2 = iPerformanceReportTask3;
                            context2 = context3;
                            guildUrlParserHelper = this;
                        }
                    }
                }
                isBlank2 = StringsKt__StringsJVMKt.isBlank(str4);
                if (!(isBlank2 ^ z16) && objectRef2.element == null) {
                    guildUrlParserHelper$buildGuildParamByInviteCode$12.L$0 = objectRef;
                    guildUrlParserHelper$buildGuildParamByInviteCode$12.L$1 = objectRef2;
                    obj2 = null;
                    guildUrlParserHelper$buildGuildParamByInviteCode$12.L$2 = null;
                    guildUrlParserHelper$buildGuildParamByInviteCode$12.L$3 = null;
                    guildUrlParserHelper$buildGuildParamByInviteCode$12.L$4 = null;
                    guildUrlParserHelper$buildGuildParamByInviteCode$12.L$5 = null;
                    guildUrlParserHelper$buildGuildParamByInviteCode$12.L$6 = null;
                    guildUrlParserHelper$buildGuildParamByInviteCode$12.L$7 = null;
                    guildUrlParserHelper$buildGuildParamByInviteCode$12.label = 3;
                    z17 = z16;
                    Object p17 = p(guildUrlParserHelper, context2, str4, str5, null, i16, iPerformanceReportTask2, guildUrlParserHelper$buildGuildParamByInviteCode$12, 8, null);
                    obj3 = p17;
                    if (p17 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    pair2 = (Pair) obj3;
                    if (pair2 == null) {
                    }
                    objectRef2.element = r86;
                    r75 = z17;
                    if (objectRef2.element != null) {
                    }
                } else {
                    r75 = z16;
                    obj2 = null;
                    if (objectRef2.element != null) {
                    }
                }
            }
        }
        guildUrlParserHelper$buildGuildParamByInviteCode$1 = new GuildUrlParserHelper$buildGuildParamByInviteCode$1(this, continuation);
        GuildUrlParserHelper$buildGuildParamByInviteCode$1 guildUrlParserHelper$buildGuildParamByInviteCode$122 = guildUrlParserHelper$buildGuildParamByInviteCode$1;
        Object obj42 = guildUrlParserHelper$buildGuildParamByInviteCode$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = guildUrlParserHelper$buildGuildParamByInviteCode$122.label;
        if (i3 == 0) {
        }
        isBlank2 = StringsKt__StringsJVMKt.isBlank(str4);
        if (!(isBlank2 ^ z16)) {
        }
        r75 = z16;
        obj2 = null;
        if (objectRef2.element != null) {
        }
    }

    private final Pair<JumpGuildParam, String> e(String url) {
        String queryParameter;
        Pair<JumpGuildParam, String> pair;
        Uri parse = Uri.parse(url);
        String path = parse.getPath();
        if (path == null) {
            return null;
        }
        List<String> pathSegments = parse.getPathSegments();
        if (pathSegments.size() < 2) {
            return null;
        }
        String guildNumber = pathSegments.get(1);
        com.tencent.mobileqq.guild.share.shorturl.a aVar = com.tencent.mobileqq.guild.share.shorturl.a.f235094a;
        if (!aVar.d().matches(path) && !aVar.c().matches(path)) {
            if (pathSegments.size() >= 4) {
                if (aVar.g().matches(path)) {
                    Intrinsics.checkNotNullExpressionValue(guildNumber, "guildNumber");
                    String str = pathSegments.get(3);
                    Intrinsics.checkNotNullExpressionValue(str, "pathSegments[3]");
                    return f(guildNumber, 7, str, url);
                }
                if (aVar.h().matches(path)) {
                    Intrinsics.checkNotNullExpressionValue(guildNumber, "guildNumber");
                    String str2 = pathSegments.get(3);
                    Intrinsics.checkNotNullExpressionValue(str2, "pathSegments[3]");
                    return f(guildNumber, 4, str2, url);
                }
                if (aVar.e().matches(path)) {
                    Intrinsics.checkNotNullExpressionValue(guildNumber, "guildNumber");
                    String str3 = pathSegments.get(3);
                    Intrinsics.checkNotNullExpressionValue(str3, "pathSegments[3]");
                    return f(guildNumber, 3, str3, url);
                }
                if (aVar.f().matches(path)) {
                    String queryParameter2 = parse.getQueryParameter("subc");
                    if (queryParameter2 == null) {
                        return null;
                    }
                    String str4 = pathSegments.get(3);
                    JumpGuildParam jumpGuildParam = new JumpGuildParam(guildNumber);
                    jumpGuildParam.businessType = 2;
                    jumpGuildParam.setChannelId(queryParameter2);
                    jumpGuildParam.setDetailPageJumpInfo(new JumpGuildParam.ChannelDetailPageJumpInfo(str4));
                    pair = new Pair<>(jumpGuildParam, url);
                } else {
                    if (!aVar.b().matches(path) || (queryParameter = parse.getQueryParameter("subc")) == null) {
                        return null;
                    }
                    String str5 = pathSegments.get(3);
                    JumpGuildParam jumpGuildParam2 = new JumpGuildParam(guildNumber);
                    jumpGuildParam2.businessType = 1;
                    jumpGuildParam2.setChannelId(queryParameter);
                    jumpGuildParam2.setDetailPageJumpInfo(new JumpGuildParam.ChannelDetailPageJumpInfo(str5));
                    pair = new Pair<>(jumpGuildParam2, url);
                }
                return pair;
            }
            Logger.f235387a.d().d("Guild.jump.GuildUrlParserHelper", 1, "buildGuildParamByWebUrl failed. pathSegments' size is wrong: " + url);
            return null;
        }
        String queryParameter3 = parse.getQueryParameter("subc");
        if (queryParameter3 == null) {
            return new Pair<>(new JumpGuildParam(guildNumber), url);
        }
        Intrinsics.checkNotNullExpressionValue(guildNumber, "guildNumber");
        return f(guildNumber, 10, queryParameter3, url);
    }

    private final Pair<JumpGuildParam, String> f(String guildNumber, int businessType, String channelId, String url) {
        JumpGuildParam jumpGuildParam = new JumpGuildParam(guildNumber);
        jumpGuildParam.businessType = businessType;
        jumpGuildParam.setChannelId(channelId);
        return new Pair<>(jumpGuildParam, url);
    }

    private final Object g(Context context, String str, IPerformanceReportTask iPerformanceReportTask, Continuation<? super JumpGuildParam> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        com.tencent.mobileqq.guild.base.extension.r rVar = com.tencent.mobileqq.guild.base.extension.r.f214743a;
        ((IGPSService) MiscKt.c(IGPSService.class, "Guild.jump.GuildUrlParserHelper", "")).decodeInviteJumpInfo(str, new b(iPerformanceReportTask.duplicate(new String[0]).setStageCode("stage_get_jump_info"), safeContinuation, str));
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x001a, code lost:
    
        r2 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int h(Uri uri) {
        Integer num;
        int i3;
        String queryParameter = uri.getQueryParameter("businessType");
        if (queryParameter != null) {
            num = StringsKt__StringNumberConversionsKt.toIntOrNull(queryParameter);
        } else {
            num = null;
        }
        if (num == null) {
            String queryParameter2 = uri.getQueryParameter("b");
            if (queryParameter2 == null || i3 == null) {
                i3 = 0;
            }
            num = i3;
        }
        return num.intValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:70:0x0135, code lost:
    
        if (r8 == true) goto L84;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:57:0x00d3. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0142  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final SHARE_SCENE i(Intent intent, String url, JumpGuildParam params, Bundle jumpExtra) {
        boolean z16;
        SHARE_SCENE share_scene;
        String queryParameter;
        boolean z17;
        boolean z18;
        ScanPicData scanPicData;
        SHARE_SCENE share_scene2 = SHARE_SCENE.OTHERS;
        Uri parse = Uri.parse(url);
        parse.getQueryParameter("mainSourceId");
        if (Intrinsics.areEqual("biz_src_jc_qzone", intent.getStringExtra("big_brother_source_key"))) {
            return SHARE_SCENE.QZONE;
        }
        boolean z19 = true;
        if (jumpExtra.containsKey("o3_scan_pic_data")) {
            Parcelable parcelable = jumpExtra.getParcelable("o3_scan_pic_data");
            if (parcelable instanceof ScanPicData) {
                scanPicData = (ScanPicData) parcelable;
            } else {
                scanPicData = null;
            }
            if (scanPicData == null) {
                return share_scene2;
            }
            int l3 = scanPicData.l();
            if (l3 != 1) {
                if (l3 != 2) {
                    if (l3 != 3) {
                        if (l3 != 4) {
                            if (l3 != 6) {
                                switch (l3) {
                                    case 11:
                                    case 12:
                                        return SHARE_SCENE.GUILD_INSIDE;
                                    case 13:
                                        break;
                                    default:
                                        return share_scene2;
                                }
                            } else {
                                return SHARE_SCENE.QZONE;
                            }
                        }
                    }
                }
                return SHARE_SCENE.GROUP;
            }
            return SHARE_SCENE.C2C;
        }
        if (jumpExtra.containsKey(IProfileCardConst.KEY_FROM_TYPE) && (jumpExtra.getInt(IProfileCardConst.KEY_FROM_TYPE) == 8 || jumpExtra.getInt(IProfileCardConst.KEY_FROM_TYPE) == 8)) {
            return SHARE_SCENE.QQSCAN;
        }
        if (jumpExtra.containsKey("OPEN_FROM_OUTSIDE") && jumpExtra.getBoolean("OPEN_FROM_OUTSIDE")) {
            return SHARE_SCENE.OUTSIDE;
        }
        String stringExtra = intent.getStringExtra("key_url_source");
        if (stringExtra != null) {
            if (stringExtra.length() > 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (z18) {
                z16 = true;
                if (!z16) {
                    String stringExtra2 = intent.getStringExtra("key_url_source");
                    if (stringExtra2 == null) {
                        stringExtra2 = "";
                    }
                    Logger.f235387a.d().d("Guild.jump.GuildUrlParserHelper", 1, "[getJumpShareScene] KEY_URL_SOURCE: " + stringExtra2);
                    switch (stringExtra2.hashCode()) {
                        case -1772647522:
                            if (!stringExtra2.equals("mqq.pindao")) {
                                return share_scene2;
                            }
                            queryParameter = parse.getQueryParameter("jumpInfo");
                            if (queryParameter != null) {
                                if (queryParameter.length() > 0) {
                                    z17 = true;
                                    break;
                                } else {
                                    z17 = false;
                                    break;
                                }
                            }
                            z19 = false;
                            if (!z19) {
                                share_scene = SHARE_SCENE.FORWARD;
                                break;
                            } else {
                                share_scene = SHARE_SCENE.GUILD_INSIDE;
                                break;
                            }
                        case -1450697570:
                            if (!stringExtra2.equals("mqq.group")) {
                                return share_scene2;
                            }
                            return SHARE_SCENE.GROUP;
                        case -1441224260:
                            if (stringExtra2.equals("mqq.qzone")) {
                                return SHARE_SCENE.QZONE;
                            }
                            return share_scene2;
                        case -1008071319:
                            if (!stringExtra2.equals("mqq.discussion")) {
                                return share_scene2;
                            }
                            return SHARE_SCENE.GROUP;
                        case -606257282:
                            if (!stringExtra2.equals("main.guild")) {
                                return share_scene2;
                            }
                            queryParameter = parse.getQueryParameter("jumpInfo");
                            if (queryParameter != null) {
                            }
                            z19 = false;
                            if (!z19) {
                            }
                            break;
                        case 1294572531:
                            if (stringExtra2.equals("mqq.c2c")) {
                                return SHARE_SCENE.C2C;
                            }
                            return share_scene2;
                        default:
                            return share_scene2;
                    }
                } else {
                    int i3 = a.f226386a[GuildJumpArkCheck.a(intent).ordinal()];
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 != 3) {
                                if (i3 == 4) {
                                    share_scene = SHARE_SCENE.GUILD_INSIDE;
                                } else {
                                    return share_scene2;
                                }
                            } else {
                                share_scene = SHARE_SCENE.QZONE;
                            }
                        } else {
                            share_scene = SHARE_SCENE.GROUP;
                        }
                    } else {
                        share_scene = SHARE_SCENE.C2C;
                    }
                }
                return share_scene;
            }
        }
        z16 = false;
        if (!z16) {
        }
        return share_scene;
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x00a0, code lost:
    
        if (r1 == true) goto L47;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final SHARE_SOURCE j(Intent intent, String url, JumpGuildParam params, Bundle jumpExtra) {
        boolean z16;
        boolean z17;
        SHARE_SOURCE share_source;
        SHARE_SOURCE share_source2 = SHARE_SOURCE.WEB_URL;
        Uri uri = Uri.parse(url);
        String queryParameter = uri.getQueryParameter("mainSourceId");
        GuildJumpArkCheck.ArkShareScene a16 = GuildJumpArkCheck.a(intent);
        boolean z18 = true;
        if (jumpExtra.containsKey("o3_scan_pic_data")) {
            String queryParameter2 = uri.getQueryParameter("contentID");
            if (queryParameter2 == null) {
                queryParameter2 = "";
            }
            Intrinsics.checkNotNullExpressionValue(uri, "uri");
            int h16 = h(uri);
            if (queryParameter2.length() <= 0) {
                z18 = false;
            }
            if (z18 && h16 == 2) {
                share_source = SHARE_SOURCE.FEED_QR_CODE;
            } else {
                share_source = SHARE_SOURCE.GUILD_QR_CODE;
            }
            return share_source;
        }
        if (jumpExtra.containsKey("OPEN_FROM_OUTSIDE") && jumpExtra.getBoolean("OPEN_FROM_OUTSIDE")) {
            if (Intrinsics.areEqual(queryParameter, QCircleDaTongConstant.ElementParamValue.QRCODE)) {
                return SHARE_SOURCE.GUILD_QR_CODE;
            }
            if (Intrinsics.areEqual(queryParameter, "feed_qr_code")) {
                return SHARE_SOURCE.FEED_QR_CODE;
            }
            return share_source2;
        }
        String str = params.guildNumber;
        Intrinsics.checkNotNullExpressionValue(str, "params.guildNumber");
        if (str.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return SHARE_SOURCE.GUILD_NUMBER;
        }
        if (a16 != GuildJumpArkCheck.ArkShareScene.C2C && a16 != GuildJumpArkCheck.ArkShareScene.TROOP) {
            String queryParameter3 = uri.getQueryParameter("jumpInfo");
            if (queryParameter3 != null) {
                if (queryParameter3.length() > 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
            }
            z18 = false;
            if (z18 && i(intent, url, params, jumpExtra) == SHARE_SCENE.QZONE) {
                return SHARE_SOURCE.SHARE_ARK;
            }
            if (Intrinsics.areEqual(queryParameter, QCircleDaTongConstant.ElementParamValue.QRCODE)) {
                return SHARE_SOURCE.GUILD_QR_CODE;
            }
            if (Intrinsics.areEqual(queryParameter, "feed_qr_code")) {
                return SHARE_SOURCE.FEED_QR_CODE;
            }
            return share_source2;
        }
        return SHARE_SOURCE.SHARE_ARK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String k(SHARE_SOURCE source, SHARE_SCENE scene, String defaultPginSource) {
        boolean isBlank;
        int i3 = a.f226388c[source.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            isBlank = StringsKt__StringsJVMKt.isBlank(defaultPginSource);
                            if (isBlank) {
                                defaultPginSource = "share_others";
                            }
                            return defaultPginSource;
                        }
                        if (a.f226387b[scene.ordinal()] == 1) {
                            return "channel_code_highlight_c2c";
                        }
                        return "channel_code_highlight_group";
                    }
                    int i16 = a.f226387b[scene.ordinal()];
                    if (i16 != 1) {
                        if (i16 != 2) {
                            if (i16 != 3) {
                                if (i16 != 4) {
                                    if (i16 != 7) {
                                        return "share_others";
                                    }
                                    return "share_feed_channel";
                                }
                                return "share_qq_zone";
                            }
                            return MiniProgramLpReportDC04239.MORE_BUTTON_RESERVERS_SHARE_CHANNEL;
                        }
                        return "share_group";
                    }
                    return "share_c2c";
                }
                int i17 = a.f226387b[scene.ordinal()];
                if (i17 != 1) {
                    if (i17 != 2) {
                        if (i17 != 3) {
                            if (i17 != 4) {
                                if (i17 != 6) {
                                    return "forum_qr_other";
                                }
                                return "forum_qr_qqscan";
                            }
                            return "forum_qr_zone";
                        }
                        return "forum_qr_channel";
                    }
                    return "forum_qr_group";
                }
                return "forum_qr_c2c";
            }
            int i18 = a.f226387b[scene.ordinal()];
            if (i18 != 1) {
                if (i18 != 2) {
                    if (i18 != 3) {
                        if (i18 != 4) {
                            if (i18 != 6) {
                                return "qr_others";
                            }
                            return "qr_qqscan";
                        }
                        return "qr_zone";
                    }
                    return "qr_channel";
                }
                return "qr_group";
            }
            return "qr_c2c";
        }
        int i19 = a.f226387b[scene.ordinal()];
        if (i19 != 1) {
            if (i19 != 2) {
                if (i19 != 4) {
                    return "share_others";
                }
                return "share_ark_outside_qq_zone";
            }
            return "share_ark_group";
        }
        return "share_ark_c2c";
    }

    private final String l(SHARE_SOURCE source, SHARE_SCENE scene) {
        int i3 = a.f226388c[source.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        return "others";
                    }
                    int i16 = a.f226387b[scene.ordinal()];
                    if (i16 != 1) {
                        if (i16 != 2) {
                            if (i16 != 3) {
                                if (i16 != 4) {
                                    if (i16 != 5) {
                                        if (i16 != 7) {
                                            return "others";
                                        }
                                        return "link_feed_channel";
                                    }
                                    return "link_outside";
                                }
                                return "link_qqzone";
                            }
                            return "link_channel";
                        }
                        return "link_grp";
                    }
                    return "link_c2c";
                }
                switch (a.f226387b[scene.ordinal()]) {
                    case 1:
                        return "forum_qr_c2c";
                    case 2:
                        return "forum_qr_grp";
                    case 3:
                        return "forum_qr_channel";
                    case 4:
                        return "forum_qr_qqzone";
                    case 5:
                        return "forum_qr_outside";
                    case 6:
                        return "forum_qr_qqscan";
                    default:
                        return "others";
                }
            }
            switch (a.f226387b[scene.ordinal()]) {
                case 1:
                    return "qr_c2c";
                case 2:
                    return "qr_grp";
                case 3:
                    return "qr_channel";
                case 4:
                    return "qr_qqzone";
                case 5:
                    return "qr_outside";
                case 6:
                    return "qr_qqscan";
                default:
                    return "others";
            }
        }
        int i17 = a.f226387b[scene.ordinal()];
        if (i17 != 1) {
            if (i17 != 2) {
                if (i17 != 3) {
                    if (i17 != 4) {
                        return "others";
                    }
                    return "ark_qqzone";
                }
                return "ark_channel";
            }
            return "ark_grp";
        }
        return "ark_c2c";
    }

    private final boolean m(Context context, String originalUrl) {
        dq1.c a16 = com.tencent.mobileqq.guild.share.shorturl.a.f235094a.a(originalUrl);
        if (a16 != null) {
            Logger.f235387a.d().d("Guild.jump.GuildUrlParserHelper", 1, "handleInnerGuildPageJump: " + originalUrl);
            a16.jump(context);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JumpGuildParam.ChannelDetailPageJumpInfo n(byte[] businessParam, int businessType) {
        if (businessType != 1) {
            if (businessType != 2) {
                return null;
            }
            ChannelShareRequest$FeedParam channelShareRequest$FeedParam = new ChannelShareRequest$FeedParam();
            try {
                channelShareRequest$FeedParam.mergeFrom(businessParam);
                return new JumpGuildParam.ChannelDetailPageJumpInfo(channelShareRequest$FeedParam.feed_id.get());
            } catch (InvalidProtocolBufferMicroException e16) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                bVar.a().add("parsrBusinessParam FEED error");
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("Guild.jump.GuildUrlParserHelper", 1, (String) it.next(), e16);
                }
                return null;
            }
        }
        ChannelShareResponse$Schedule channelShareResponse$Schedule = new ChannelShareResponse$Schedule();
        try {
            channelShareResponse$Schedule.mergeFrom(businessParam);
            return new JumpGuildParam.ChannelDetailPageJumpInfo(String.valueOf(channelShareResponse$Schedule.f435939id.get()));
        } catch (InvalidProtocolBufferMicroException e17) {
            Logger logger2 = Logger.f235387a;
            Logger.b bVar2 = new Logger.b();
            bVar2.a().add("parsrBusinessParam SCHEDULE error");
            Iterator<T> it5 = bVar2.a().iterator();
            while (it5.hasNext()) {
                Logger.f235387a.d().e("Guild.jump.GuildUrlParserHelper", 1, (String) it5.next(), e17);
            }
            return null;
        }
    }

    private final Object o(Context context, String str, String str2, String str3, int i3, IPerformanceReportTask iPerformanceReportTask, Continuation<? super Pair<? extends JumpGuildParam, String>> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        IPerformanceReportTask stageCode = iPerformanceReportTask.duplicate(new String[0]).setStageCode("stage_get_invite_info");
        GuildJumpLoadingFragment.INSTANCE.b(context, i3, GuildSplitViewUtils.f235370a.e(str3));
        fg fgVar = new fg();
        fgVar.f(str);
        fgVar.e(str2);
        fgVar.g(str3);
        ((IGPSService) ch.R0(IGPSService.class)).getGuildVerifyShareInfo(fgVar, new c(stageCode, context, safeContinuation, str, str2, str3));
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    static /* synthetic */ Object p(GuildUrlParserHelper guildUrlParserHelper, Context context, String str, String str2, String str3, int i3, IPerformanceReportTask iPerformanceReportTask, Continuation continuation, int i16, Object obj) {
        String str4;
        String str5;
        String str6;
        if ((i16 & 2) != 0) {
            str4 = "";
        } else {
            str4 = str;
        }
        if ((i16 & 4) != 0) {
            str5 = "";
        } else {
            str5 = str2;
        }
        if ((i16 & 8) != 0) {
            str6 = "";
        } else {
            str6 = str3;
        }
        return guildUrlParserHelper.o(context, str4, str5, str6, i3, iPerformanceReportTask, continuation);
    }

    private final Object q(Context context, String str, IPerformanceReportTask iPerformanceReportTask, Continuation<? super Pair<? extends JumpGuildParam, String>> continuation) {
        boolean isBlank;
        isBlank = StringsKt__StringsJVMKt.isBlank(str);
        if (isBlank) {
            t(this, R.string.f15162187, "parseInviteCodeParamFromUrl url empty", 0, 4, null);
            return null;
        }
        Logger.f235387a.d().d("Guild.jump.GuildUrlParserHelper", 1, "parseUrlToJumpParam originalUrl:" + str);
        if (com.tencent.mobileqq.guild.share.shorturl.a.f235094a.n(str)) {
            return e(str);
        }
        return d(str, context, iPerformanceReportTask, continuation);
    }

    private final void s(final int textResId, final String tag, final int iconId) {
        ThreadUtils threadUtils = ThreadUtils.f235400a;
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            QQToastUtil.showQQToast(iconId, textResId);
            GuildJumpLoadingFragment.INSTANCE.a();
            Logger.f235387a.d().w("Guild.jump.GuildUrlParserHelper", 1, "showJumpErrorToast " + tag);
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.jump.GuildUrlParserHelper$showJumpErrorToast$$inlined$ensureUiThread$1
            @Override // java.lang.Runnable
            public final void run() {
                QQToastUtil.showQQToast(iconId, textResId);
                GuildJumpLoadingFragment.INSTANCE.a();
                Logger.f235387a.d().w("Guild.jump.GuildUrlParserHelper", 1, "showJumpErrorToast " + tag);
            }
        });
    }

    static /* synthetic */ void t(GuildUrlParserHelper guildUrlParserHelper, int i3, String str, int i16, int i17, Object obj) {
        if ((i17 & 4) != 0) {
            i16 = 1;
        }
        guildUrlParserHelper.s(i3, str, i16);
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0185, code lost:
    
        r9 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r9);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void u(JumpGuildParam params, String longUrl, Bundle extra) {
        String str;
        String str2;
        long j3;
        boolean isBlank;
        String str3;
        Long longOrNull;
        boolean z16;
        Intent intent = (Intent) extra.getParcelable("activity_bundle");
        if (intent == null) {
            intent = new Intent();
        }
        intent.setExtrasClassLoader(GuildUrlParserHelper.class.getClassLoader());
        com.tencent.util.Pair<String, String> joinSource = QQGuildRouterApiImpl.getJoinSource(intent, longUrl);
        SHARE_SCENE i3 = i(intent, longUrl, params, extra);
        SHARE_SOURCE j16 = j(intent, longUrl, params, extra);
        String str4 = joinSource.first;
        String str5 = joinSource.second;
        String str6 = "share";
        if (!Intrinsics.areEqual(str4, "share") && !Intrinsics.areEqual(str4, QCircleDaTongConstant.ElementParamValue.QRCODE) && !Intrinsics.areEqual(str4, "feed_qr_code")) {
            str6 = str4;
        } else {
            str5 = l(j16, i3);
        }
        Logger logger = Logger.f235387a;
        Logger.a d16 = logger.d();
        String str7 = joinSource.first;
        String str8 = joinSource.second;
        d16.d("Guild.jump.GuildUrlParserHelper", 1, "[updateParamByUrlAndExtra] shareJumpScene " + i3 + ", shareJumpSource " + j16 + " mainSource->" + ((Object) str6) + " subSource->" + ((Object) str5) + " , joinSource-> " + ((Object) str7) + " , " + ((Object) str8) + " getPginSource->" + f226381a.k(j16, i3, ""));
        params.getJoinInfoParam().setMainSource(str6);
        params.getJoinInfoParam().setSubSource(str5);
        Uri a16 = bg.f235465a.a(longUrl);
        String queryParameter = a16.getQueryParameter("contentID");
        if (queryParameter == null) {
            queryParameter = "";
        }
        int h16 = h(a16);
        if (h16 != 0) {
            params.businessType = h16;
        }
        String queryParameter2 = a16.getQueryParameter("inviteCode");
        String str9 = queryParameter;
        if (queryParameter2 == null) {
            str = "";
        } else {
            str = queryParameter2;
        }
        String queryParameter3 = a16.getQueryParameter("attaContentID");
        if (queryParameter3 == null) {
            queryParameter3 = "";
        }
        Logger.a d17 = logger.d();
        int identityHashCode = System.identityHashCode(params.getJoinInfoParam());
        String str10 = str5;
        StringBuilder sb5 = new StringBuilder();
        String str11 = str6;
        sb5.append("updateParamByUrlAndExtra inviteCode=");
        sb5.append(str);
        sb5.append(" inviteUUID=");
        sb5.append(queryParameter3);
        sb5.append(" id:");
        sb5.append(identityHashCode);
        d17.d("Guild.jump.GuildUrlParserHelper", 1, sb5.toString());
        params.getJoinInfoParam().setInviteUUID(queryParameter3);
        params.inviteCode = str;
        if (params.businessType == 20) {
            str2 = a16.getQueryParameter("arkInnerID");
            if (str2 != null && str2.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                str2 = str9;
            }
            params.getJoinInfoParam().setMainSource(JumpGuildParam.ARK_ADD_FRIENDS_MAIN_SOURCE_ID);
            params.getJoinInfoParam().setSubSource(JumpGuildParam.ARK_ADD_FRIENDS_SUB_SOURCE_ID);
            params.setArkJumpId(str, str2);
        } else {
            str2 = str9;
        }
        String queryParameter4 = a16.getQueryParameter("categoryId");
        if (queryParameter4 != null && longOrNull != null) {
            j3 = longOrNull.longValue();
        } else {
            j3 = 0;
        }
        params.setCategoryId(j3);
        String joinSignature = params.getJoinSignature();
        Intrinsics.checkNotNullExpressionValue(joinSignature, "params.joinSignature");
        isBlank = StringsKt__StringsJVMKt.isBlank(joinSignature);
        if (isBlank) {
            bq1.b.a(params, str);
        }
        Bundle updateParamByUrlAndExtra$lambda$18 = params.extras;
        Intrinsics.checkNotNullExpressionValue(updateParamByUrlAndExtra$lambda$18, "updateParamByUrlAndExtra$lambda$18");
        MiscKt.g(updateParamByUrlAndExtra$lambda$18, "openType", a16.getQueryParameter("openType"));
        MiscKt.g(updateParamByUrlAndExtra$lambda$18, "shareType", a16.getQueryParameter("shareType"));
        MiscKt.g(updateParamByUrlAndExtra$lambda$18, "sessionId", a16.getQueryParameter("sessionId"));
        MiscKt.g(updateParamByUrlAndExtra$lambda$18, "inviteCode", str);
        MiscKt.g(updateParamByUrlAndExtra$lambda$18, "contentID", str2);
        MiscKt.g(updateParamByUrlAndExtra$lambda$18, "sgrp_channel_extension_info", a16.getQueryParameter("sgrp_channel_extension_info"));
        MiscKt.g(updateParamByUrlAndExtra$lambda$18, "param_key_search_extension_info", a16.getQueryParameter("param_key_search_extension_info"));
        MiscKt.g(updateParamByUrlAndExtra$lambda$18, "scrollTop", a16.getQueryParameter("scrollTop"));
        updateParamByUrlAndExtra$lambda$18.putAll(extra);
        boolean areEqual = Intrinsics.areEqual("biz_src_jc_qzone", intent.getStringExtra("big_brother_source_key"));
        String queryParameter5 = a16.getQueryParameter("appChannel");
        if (queryParameter5 == null) {
            str3 = "";
        } else {
            str3 = queryParameter5;
        }
        v(params, str3, areEqual, queryParameter3, extra, j16, i3);
        logger.d().d("Guild.jump.GuildUrlParserHelper", 1, "[updateParamByUrlAndExtra] end  mainSource->" + ((Object) str11) + " subSource->" + ((Object) str10) + " getPginSource->" + com.tencent.mobileqq.guild.report.b.c());
    }

    private final void v(JumpGuildParam params, String defaultPginSource, boolean isFromQZone, String inviteContentID, Bundle extra, SHARE_SOURCE shareJumpSource, SHARE_SCENE shareJumpScene) {
        boolean isBlank;
        boolean isBlank2;
        if (Intrinsics.areEqual(params.getMainSource(), "share")) {
            com.tencent.mobileqq.guild.report.b.h(k(shareJumpSource, shareJumpScene, defaultPginSource), "Guild.jump.GuildUrlParserHelper", inviteContentID);
            return;
        }
        boolean z16 = extra.getBoolean("OPEN_FROM_OUTSIDE");
        if (((IGuildTempApi) QRoute.api(IGuildTempApi.class)).isGuildTabSelected() && !z16) {
            return;
        }
        if (Intrinsics.areEqual(params.getMainSource(), "small_world")) {
            com.tencent.mobileqq.guild.report.b.h("functional_qq_little_world_feed", "Guild.jump.GuildUrlParserHelper", inviteContentID);
            return;
        }
        if (!Intrinsics.areEqual(params.getMainSource(), "channel_connect")) {
            isBlank = StringsKt__StringsJVMKt.isBlank(defaultPginSource);
            if (!isBlank) {
                com.tencent.mobileqq.guild.report.b.h(defaultPginSource, "Guild.jump.GuildUrlParserHelper", inviteContentID);
                return;
            }
            String str = params.guildNumber;
            Intrinsics.checkNotNullExpressionValue(str, "params.guildNumber");
            isBlank2 = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank2) {
                com.tencent.mobileqq.guild.report.b.h("share_channel_url", "Guild.jump.GuildUrlParserHelper", inviteContentID);
                return;
            }
            return;
        }
        com.tencent.mobileqq.guild.report.b.h("channel_connect", "Guild.jump.GuildUrlParserHelper", inviteContentID);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x011f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002f  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object r(@NotNull Context context, @NotNull BaseGuildShareParam baseGuildShareParam, @NotNull IPerformanceReportTask iPerformanceReportTask, @NotNull Continuation<? super JumpGuildParam> continuation) {
        GuildUrlParserHelper$parserUrlOrCode$1 guildUrlParserHelper$parserUrlOrCode$1;
        Object coroutine_suspended;
        int i3;
        GuildUrlParserHelper guildUrlParserHelper;
        Pair pair;
        BaseGuildShareParam baseGuildShareParam2 = baseGuildShareParam;
        IPerformanceReportTask iPerformanceReportTask2 = iPerformanceReportTask;
        if (continuation instanceof GuildUrlParserHelper$parserUrlOrCode$1) {
            guildUrlParserHelper$parserUrlOrCode$1 = (GuildUrlParserHelper$parserUrlOrCode$1) continuation;
            int i16 = guildUrlParserHelper$parserUrlOrCode$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                guildUrlParserHelper$parserUrlOrCode$1.label = i16 - Integer.MIN_VALUE;
                GuildUrlParserHelper$parserUrlOrCode$1 guildUrlParserHelper$parserUrlOrCode$12 = guildUrlParserHelper$parserUrlOrCode$1;
                Object obj = guildUrlParserHelper$parserUrlOrCode$12.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = guildUrlParserHelper$parserUrlOrCode$12.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            IPerformanceReportTask iPerformanceReportTask3 = (IPerformanceReportTask) guildUrlParserHelper$parserUrlOrCode$12.L$2;
                            BaseGuildShareParam baseGuildShareParam3 = (BaseGuildShareParam) guildUrlParserHelper$parserUrlOrCode$12.L$1;
                            guildUrlParserHelper = (GuildUrlParserHelper) guildUrlParserHelper$parserUrlOrCode$12.L$0;
                            ResultKt.throwOnFailure(obj);
                            iPerformanceReportTask2 = iPerformanceReportTask3;
                            baseGuildShareParam2 = baseGuildShareParam3;
                            pair = (Pair) obj;
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        IPerformanceReportTask iPerformanceReportTask4 = (IPerformanceReportTask) guildUrlParserHelper$parserUrlOrCode$12.L$2;
                        BaseGuildShareParam baseGuildShareParam4 = (BaseGuildShareParam) guildUrlParserHelper$parserUrlOrCode$12.L$1;
                        guildUrlParserHelper = (GuildUrlParserHelper) guildUrlParserHelper$parserUrlOrCode$12.L$0;
                        ResultKt.throwOnFailure(obj);
                        iPerformanceReportTask2 = iPerformanceReportTask4;
                        baseGuildShareParam2 = baseGuildShareParam4;
                        pair = (Pair) obj;
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    if (baseGuildShareParam2 instanceof GuildShareUrlParam) {
                        GuildShareUrlParam guildShareUrlParam = (GuildShareUrlParam) baseGuildShareParam2;
                        String c16 = guildShareUrlParam.c();
                        Intrinsics.checkNotNullExpressionValue(c16, "originalParam.jumpUrl");
                        if (m(context, c16)) {
                            return null;
                        }
                        String c17 = guildShareUrlParam.c();
                        Intrinsics.checkNotNullExpressionValue(c17, "originalParam.jumpUrl");
                        guildUrlParserHelper$parserUrlOrCode$12.L$0 = this;
                        guildUrlParserHelper$parserUrlOrCode$12.L$1 = baseGuildShareParam2;
                        guildUrlParserHelper$parserUrlOrCode$12.L$2 = iPerformanceReportTask2;
                        guildUrlParserHelper$parserUrlOrCode$12.label = 1;
                        obj = q(context, c17, iPerformanceReportTask2, guildUrlParserHelper$parserUrlOrCode$12);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        guildUrlParserHelper = this;
                        pair = (Pair) obj;
                    } else if (baseGuildShareParam2 instanceof GuildShareInviteCodeParam) {
                        GuildShareInviteCodeParam guildShareInviteCodeParam = (GuildShareInviteCodeParam) baseGuildShareParam2;
                        String e16 = guildShareInviteCodeParam.e();
                        Intrinsics.checkNotNullExpressionValue(e16, "originalParam.inviteCode");
                        String c18 = guildShareInviteCodeParam.c();
                        Intrinsics.checkNotNullExpressionValue(c18, "originalParam.contentId");
                        guildUrlParserHelper$parserUrlOrCode$12.L$0 = this;
                        guildUrlParserHelper$parserUrlOrCode$12.L$1 = baseGuildShareParam2;
                        guildUrlParserHelper$parserUrlOrCode$12.L$2 = iPerformanceReportTask2;
                        guildUrlParserHelper$parserUrlOrCode$12.label = 2;
                        obj = p(this, context, e16, c18, null, 0, iPerformanceReportTask, guildUrlParserHelper$parserUrlOrCode$12, 8, null);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        guildUrlParserHelper = this;
                        pair = (Pair) obj;
                    } else {
                        Logger logger = Logger.f235387a;
                        Logger.b bVar = new Logger.b();
                        String str = "parserUrlOrCode not supportType:" + baseGuildShareParam2;
                        if (str instanceof String) {
                            bVar.a().add(str);
                        }
                        Iterator<T> it = bVar.a().iterator();
                        while (it.hasNext()) {
                            Logger.f235387a.d().e("Guild.jump.GuildUrlParserHelper", 1, (String) it.next(), null);
                        }
                        guildUrlParserHelper = this;
                        pair = null;
                    }
                }
                if (pair != null) {
                    return null;
                }
                JumpGuildParam jumpGuildParam = (JumpGuildParam) pair.getFirst();
                String str2 = (String) pair.getSecond();
                Bundle a16 = baseGuildShareParam2.a();
                Intrinsics.checkNotNullExpressionValue(a16, "originalParam.bundle");
                guildUrlParserHelper.u(jumpGuildParam, str2, a16);
                Bundle bundle = jumpGuildParam.extras;
                Intrinsics.checkNotNullExpressionValue(bundle, "params.extras");
                qw1.b.t(bundle, iPerformanceReportTask2, JumpGuildParam.EXTRA_JUMP_REPORT_TASK);
                return jumpGuildParam;
            }
        }
        guildUrlParserHelper$parserUrlOrCode$1 = new GuildUrlParserHelper$parserUrlOrCode$1(this, continuation);
        GuildUrlParserHelper$parserUrlOrCode$1 guildUrlParserHelper$parserUrlOrCode$122 = guildUrlParserHelper$parserUrlOrCode$1;
        Object obj2 = guildUrlParserHelper$parserUrlOrCode$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = guildUrlParserHelper$parserUrlOrCode$122.label;
        if (i3 == 0) {
        }
        if (pair != null) {
        }
    }
}
