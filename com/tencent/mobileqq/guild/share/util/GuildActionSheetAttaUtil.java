package com.tencent.mobileqq.guild.share.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import androidx.core.os.BundleKt;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.base.extension.MiscKt;
import com.tencent.mobileqq.guild.data.ark.AttaIdReportData;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.setting.guildsetting.fragment.GuildSettingQRCodeFragment;
import com.tencent.mobileqq.guild.share.s;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.bg;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.api.IGProDataApi;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProBusinessData;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProFetchShareUrlRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProInviteInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.dv;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.group_pro_proto.channel_share.ChannelShareRequest$FeedParam;
import tencent.im.group_pro_proto.channel_share.ChannelShareResponse$Schedule;
import wh2.em;
import wh2.r;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b6\u00107J\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J0\u0010\u000e\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\tH\u0007J>\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\t2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0007J4\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\t2\b\b\u0002\u0010\u0019\u001a\u00020\t2\b\b\u0002\u0010\u001a\u001a\u00020\tH\u0007J \u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0007J*\u0010!\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010 \u001a\u00020\tH\u0007J*\u0010#\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010 \u001a\u00020\tH\u0007J7\u0010$\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010 \u001a\u00020\tH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b$\u0010%J\u001a\u0010*\u001a\u0004\u0018\u00010)2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u000bH\u0002J\u0010\u0010,\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0005H\u0007R0\u00101\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t0-j\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t`.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R0\u00103\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t0-j\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t`.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00100R0\u00105\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000b0-j\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000b`.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00100\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/guild/share/util/GuildActionSheetAttaUtil;", "", "", "Lcom/tencent/mobileqq/selectmember/ResultRecord;", "targetList", "Lcom/tencent/mobileqq/guild/data/ark/AttaIdReportData;", "attaData", "", DomainData.DOMAIN_NAME, "", "shareUrl", "", "sharePanelPageSource", "forceUpdateAttaId", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Landroid/content/Intent;", "intent", "Lcom/tencent/mobileqq/guild/share/s;", "shareForwardCB", "Lcom/tencent/mobileqq/guild/share/util/g;", "callback", "j", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProFetchShareUrlRsp;", "fetchedCommonInfo", "guildId", "channelId", "feedId", "p", "Landroid/content/Context;", "context", "k", "ShareChannelId", "toGuildId", "r", "actionItem", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Ljava/lang/String;IILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "businessParam", "businessType", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam$ChannelDetailPageJumpInfo;", "l", "data", "g", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "attaShareSourceMap", "c", "attaContentTypeMap", "d", "newSharePanelChannelMap", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildActionSheetAttaUtil {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GuildActionSheetAttaUtil f235105a = new GuildActionSheetAttaUtil();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<Integer, String> attaShareSourceMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<Integer, String> attaContentTypeMap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<String, Integer> newSharePanelChannelMap;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\n\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\u00002\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022\u000e\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00010\u00050\u00052\u000e\u0010\b\u001a\n \u0003*\u0004\u0018\u00010\u00070\u0007H\n\u00a2\u0006\u0004\b\n\u0010\u000b"}, d2 = {"", "result", "", "kotlin.jvm.PlatformType", "errMsg", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProInviteInfo;", "inviteInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProBusinessData;", "bizData", "", "a", "(ILjava/lang/String;Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProInviteInfo;Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProBusinessData;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a implements r {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<AttaIdReportData> f235109a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Uri f235110b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f235111c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f235112d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f235113e;

        /* JADX WARN: Multi-variable type inference failed */
        a(Continuation<? super AttaIdReportData> continuation, Uri uri, int i3, int i16, String str) {
            this.f235109a = continuation;
            this.f235110b = uri;
            this.f235111c = i3;
            this.f235112d = i16;
            this.f235113e = str;
        }

        @Override // wh2.r
        public final void a(int i3, String str, IGProInviteInfo iGProInviteInfo, IGProBusinessData iGProBusinessData) {
            boolean z16;
            String str2;
            String str3;
            boolean z17;
            String str4;
            ArrayList arrayListOf;
            String queryParameter;
            Logger.f235387a.d().d("GuildActionSheetAttaUtil", 1, "[reportGuildShareContentInfoAtta] decodeInviteJumpInfo result " + i3 + ", errMsg " + str);
            String str5 = null;
            if (i3 == 0 && iGProInviteInfo != null && iGProBusinessData != null) {
                byte[] businessParam = iGProBusinessData.getBusinessParam();
                Intrinsics.checkNotNullExpressionValue(businessParam, "bizData.businessParam");
                if (businessParam.length == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!(!z16)) {
                    str2 = "";
                } else {
                    GuildActionSheetAttaUtil guildActionSheetAttaUtil = GuildActionSheetAttaUtil.f235105a;
                    byte[] businessParam2 = iGProBusinessData.getBusinessParam();
                    Intrinsics.checkNotNullExpressionValue(businessParam2, "bizData.businessParam");
                    JumpGuildParam.ChannelDetailPageJumpInfo l3 = guildActionSheetAttaUtil.l(businessParam2, iGProBusinessData.getBusinessType());
                    if (l3 != null) {
                        str5 = l3.getDetailId();
                    }
                    if (str5 == null) {
                        str5 = "";
                    }
                    str2 = str5;
                }
                Uri uri = this.f235110b;
                if (uri == null || (queryParameter = uri.getQueryParameter("attaContentID")) == null) {
                    str3 = "";
                } else {
                    str3 = queryParameter;
                }
                String valueOf = String.valueOf(iGProInviteInfo.getGuildId());
                String valueOf2 = String.valueOf(iGProInviteInfo.getChnId());
                if (valueOf2.length() == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    valueOf2 = "0";
                }
                String str6 = valueOf2;
                String valueOf3 = String.valueOf(this.f235111c);
                String str7 = (String) GuildActionSheetAttaUtil.attaContentTypeMap.get(Integer.valueOf(iGProBusinessData.getBusinessType()));
                if (str7 == null) {
                    str7 = WadlProxyConsts.CHANNEL;
                }
                String str8 = str7;
                String str9 = (String) GuildActionSheetAttaUtil.attaShareSourceMap.get(Integer.valueOf(this.f235112d));
                if (str9 == null) {
                    str4 = "";
                } else {
                    str4 = str9;
                }
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(this.f235113e);
                this.f235109a.resumeWith(Result.m476constructorimpl(new AttaIdReportData(str3, valueOf, str6, str2, valueOf3, str8, str4, arrayListOf, null, null, null, 1792, null)));
                return;
            }
            this.f235109a.resumeWith(Result.m476constructorimpl(null));
        }
    }

    static {
        HashMap<Integer, String> hashMapOf;
        HashMap<Integer, String> hashMapOf2;
        HashMap<String, Integer> hashMapOf3;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to(2, "qq"), TuplesKt.to(9, "wechat_contacts"), TuplesKt.to(10, "wechat_moments"), TuplesKt.to(3, "qzone"), TuplesKt.to(1, "copylink"), TuplesKt.to(197, "copylink"), TuplesKt.to(171, WadlProxyConsts.CHANNEL), TuplesKt.to(196, "qr"), TuplesKt.to(153, "generate_pic"));
        attaShareSourceMap = hashMapOf;
        hashMapOf2 = MapsKt__MapsKt.hashMapOf(TuplesKt.to(9, WadlProxyConsts.CHANNEL), TuplesKt.to(4, "voice_channel"), TuplesKt.to(3, "stream_channel"), TuplesKt.to(7, "aio_channel"), TuplesKt.to(1, "event_detail"), TuplesKt.to(2, "forum_detail"));
        attaContentTypeMap = hashMapOf2;
        hashMapOf3 = MapsKt__MapsKt.hashMapOf(TuplesKt.to("qqfriend", 2), TuplesKt.to("qqchannel", 171), TuplesKt.to("qzoneshuoshuo", 3), TuplesKt.to("weixin", 9), TuplesKt.to("weixincircle", 10), TuplesKt.to(WinkDaTongReportConstant.ElementParamValue.XSJ_SHARE_COPY_LINK, 1), TuplesKt.to("generate_qr_code", 196), TuplesKt.to("generate_share_image", 153));
        newSharePanelChannelMap = hashMapOf3;
    }

    GuildActionSheetAttaUtil() {
    }

    @JvmStatic
    public static final void g(@NotNull final AttaIdReportData data) {
        boolean z16;
        String joinToString$default;
        Intrinsics.checkNotNullParameter(data, "data");
        if (data.getAttaContentId().length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "[doReportAtta] illegal data: " + data;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("GuildActionSheetAttaUtil", 1, (String) it.next(), null);
            }
            return;
        }
        String attaContentId = data.getAttaContentId();
        String shareSource = data.getShareSource();
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(data.f(), null, null, null, 0, null, null, 63, null);
        if (o.c(attaContentId + shareSource + joinToString$default)) {
            Logger logger2 = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("GuildActionSheetAttaUtil", "[doReportAtta] isFastClick data " + data);
                return;
            }
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.share.util.a
            @Override // java.lang.Runnable
            public final void run() {
                GuildActionSheetAttaUtil.h(AttaIdReportData.this);
            }
        }, 128, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(AttaIdReportData data) {
        Intrinsics.checkNotNullParameter(data, "$data");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GuildActionSheetAttaUtil", 2, "[doReportAtta] " + data);
        }
        com.tencent.mobileqq.guild.base.extension.r rVar = com.tencent.mobileqq.guild.base.extension.r.f214743a;
        IGPSService iGPSService = (IGPSService) MiscKt.c(IGPSService.class, "GuildActionSheetAttaUtil", "");
        dv dvVar = new dv();
        dvVar.d(IGProDataApi.INSTANCE.a().encodeShareAttaData(data.c()));
        dvVar.c(data.getAttaContentId());
        iGPSService.reportShareAtta(dvVar, new em() { // from class: com.tencent.mobileqq.guild.share.util.b
            @Override // wh2.em
            public final void onResult(int i3, String str) {
                GuildActionSheetAttaUtil.i(i3, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(int i3, String str) {
        Logger.f235387a.d().d("GuildActionSheetAttaUtil", 1, "[doReportAtta.onResult] result " + i3 + ", errMsg " + str);
    }

    @JvmStatic
    public static final void j(@NotNull Intent intent, @NotNull String shareUrl, int sharePanelPageSource, @NotNull String forceUpdateAttaId, @Nullable s shareForwardCB, @NotNull g callback) {
        Uri uri;
        String str;
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(shareUrl, "shareUrl");
        Intrinsics.checkNotNullParameter(forceUpdateAttaId, "forceUpdateAttaId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        boolean z16 = true;
        try {
            uri = bg.f235465a.a(shareUrl);
        } catch (Throwable th5) {
            Logger.f235387a.d().d("GuildActionSheetAttaUtil", 1, "[reportContentInfoAttaForShareLongUrl] parse error " + th5);
            uri = null;
        }
        if (uri == null || (str = uri.getQueryParameter("jumpInfo")) == null) {
            str = "";
        }
        if (str.length() != 0) {
            z16 = false;
        }
        if (z16) {
            callback.a(intent);
            return;
        }
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.e.f261783e);
        if (f16 != null) {
            CorountineFunKt.e(f16, "GuildActionSheetAttaUtil", null, null, null, new GuildActionSheetAttaUtil$generateTotalArkMsgIntentAsync$1(shareUrl, sharePanelPageSource, forceUpdateAttaId, intent, shareForwardCB, callback, null), 14, null);
        }
    }

    @JvmStatic
    public static final void k(@NotNull Context context, @NotNull String guildId, int sharePanelPageSource) {
        boolean z16;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        if (guildId.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        GuildSettingQRCodeFragment.INSTANCE.b(context, guildId, BundleKt.bundleOf(TuplesKt.to("extra_key_atta_report_id", new AttaIdReportData("", guildId, "0", null, String.valueOf(sharePanelPageSource), WadlProxyConsts.CHANNEL, "qr", null, null, null, null, 1928, null))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JumpGuildParam.ChannelDetailPageJumpInfo l(byte[] businessParam, int businessType) {
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
                    Logger.f235387a.d().e("GuildActionSheetAttaUtil", 1, (String) it.next(), e16);
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
                Logger.f235387a.d().e("GuildActionSheetAttaUtil", 1, (String) it5.next(), e17);
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object m(String str, int i3, int i16, String str2, Continuation<? super AttaIdReportData> continuation) {
        Continuation intercepted;
        Uri uri;
        String str3;
        Object coroutine_suspended;
        String queryParameter;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        boolean z16 = true;
        try {
            uri = bg.f235465a.a(str);
        } catch (Throwable th5) {
            Logger.f235387a.d().d("GuildActionSheetAttaUtil", 1, "[parseUrlJumpInfo] error " + th5);
            uri = null;
        }
        if (uri == null || (queryParameter = uri.getQueryParameter("jumpInfo")) == null) {
            str3 = "";
        } else {
            str3 = queryParameter;
        }
        Intrinsics.checkNotNullExpressionValue(str3, "uri?.getQueryParameter(J\u2026Constants.JUMPINFO) ?: \"\"");
        if (str3.length() != 0) {
            z16 = false;
        }
        if (z16) {
            safeContinuation.resumeWith(Result.m476constructorimpl(null));
        } else {
            com.tencent.mobileqq.guild.base.extension.r rVar = com.tencent.mobileqq.guild.base.extension.r.f214743a;
            ((IGPSService) MiscKt.c(IGPSService.class, "GuildActionSheetAttaUtil", "")).decodeInviteJumpInfo(str3, new a(safeContinuation, uri, i16, i3, str2));
        }
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    @JvmStatic
    public static final void n(@NotNull List<? extends ResultRecord> targetList, @NotNull AttaIdReportData attaData) {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        boolean z16;
        Intrinsics.checkNotNullParameter(targetList, "targetList");
        Intrinsics.checkNotNullParameter(attaData, "attaData");
        List<? extends ResultRecord> list = targetList;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            boolean z17 = false;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((ResultRecord) next).uinType == 0) {
                z17 = true;
            }
            if (z17) {
                arrayList.add(next);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            arrayList2.add(((ResultRecord) it5.next()).uin);
        }
        if (!arrayList2.isEmpty()) {
            AttaIdReportData a16 = attaData.a();
            a16.k(new ArrayList<>(arrayList2));
            a16.j("c2c");
            g(a16);
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : list) {
            if (((ResultRecord) obj).uinType == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList3.add(obj);
            }
        }
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList3, 10);
        ArrayList arrayList4 = new ArrayList(collectionSizeOrDefault2);
        Iterator it6 = arrayList3.iterator();
        while (it6.hasNext()) {
            arrayList4.add(((ResultRecord) it6.next()).uin);
        }
        if (!arrayList4.isEmpty()) {
            AttaIdReportData a17 = attaData.a();
            a17.k(new ArrayList<>(arrayList4));
            a17.j(VipFunCallConstants.KEY_GROUP);
            g(a17);
        }
    }

    @JvmStatic
    public static final void o(@NotNull String shareUrl, int actionItem, int sharePanelPageSource, @NotNull String toGuildId) {
        boolean z16;
        boolean startsWith$default;
        String str;
        CoroutineScope f16;
        boolean z17;
        Intrinsics.checkNotNullParameter(shareUrl, "shareUrl");
        Intrinsics.checkNotNullParameter(toGuildId, "toGuildId");
        boolean z18 = true;
        Logger.f235387a.d().d("GuildActionSheetAttaUtil", 1, "[reportGuildShareContentInfoAtta], actionItem " + actionItem + ", toGuildId " + toGuildId + ", sharePanelPageSource " + sharePanelPageSource + ", shareUrl " + shareUrl);
        if (shareUrl.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            Uri uri = null;
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(shareUrl, "http", false, 2, null);
            if (startsWith$default) {
                if (actionItem == 171) {
                    if (toGuildId.length() == 0) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        return;
                    }
                }
                try {
                    uri = bg.f235465a.a(shareUrl);
                } catch (Throwable th5) {
                    Logger.f235387a.d().d("GuildActionSheetAttaUtil", 1, "[reportContentInfoAttaForShareLongUrl] parse error " + th5);
                }
                if (uri == null || (str = uri.getQueryParameter("jumpInfo")) == null) {
                    str = "";
                }
                if (str.length() != 0) {
                    z18 = false;
                }
                if (!z18 && (f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.e.f261783e)) != null) {
                    CorountineFunKt.e(f16, "GuildActionSheetAttaUtil", null, null, null, new GuildActionSheetAttaUtil$reportContentInfoAttaForShareLongUrl$2(shareUrl, actionItem, sharePanelPageSource, toGuildId, null), 14, null);
                }
            }
        }
    }

    @JvmStatic
    public static final void p(@NotNull IGProFetchShareUrlRsp fetchedCommonInfo, int sharePanelPageSource, @NotNull String guildId, @NotNull String channelId, @NotNull String feedId) {
        Intrinsics.checkNotNullParameter(fetchedCommonInfo, "fetchedCommonInfo");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        String attaContentId = fetchedCommonInfo.getAttaContentId();
        Intrinsics.checkNotNullExpressionValue(attaContentId, "fetchedCommonInfo.attaContentId");
        g(new AttaIdReportData(attaContentId, guildId, channelId, feedId, String.valueOf(sharePanelPageSource), "forum_detail", "generate_pic", null, null, null, null, 1920, null));
    }

    @JvmStatic
    public static final void q(@NotNull List<? extends ResultRecord> targetList, @NotNull String shareUrl, int sharePanelPageSource, @NotNull String forceUpdateAttaId) {
        Uri uri;
        String str;
        boolean z16;
        Intrinsics.checkNotNullParameter(targetList, "targetList");
        Intrinsics.checkNotNullParameter(shareUrl, "shareUrl");
        Intrinsics.checkNotNullParameter(forceUpdateAttaId, "forceUpdateAttaId");
        try {
            uri = bg.f235465a.a(shareUrl);
        } catch (Throwable th5) {
            Logger.f235387a.d().d("GuildActionSheetAttaUtil", 1, "[reportNewArkAttaIdOnForwardCallback] parse error " + th5);
            uri = null;
        }
        if (uri == null || (str = uri.getQueryParameter("jumpInfo")) == null) {
            str = "";
        }
        if (str.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        Logger.f235387a.d().d("GuildActionSheetAttaUtil", 1, "[reportNewArkAttaIdOnForwardCallback] targetList " + targetList.size() + ", forceUpdateAttaId: " + forceUpdateAttaId);
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.e.f261783e);
        if (f16 != null) {
            CorountineFunKt.e(f16, "GuildActionSheetAttaUtil", null, null, null, new GuildActionSheetAttaUtil$reportNewArkAttaIdOnForwardCallback$2(shareUrl, sharePanelPageSource, forceUpdateAttaId, targetList, null), 14, null);
        }
    }

    @JvmStatic
    public static final void r(@NotNull String shareUrl, @NotNull String ShareChannelId, int sharePanelPageSource, @NotNull String toGuildId) {
        Intrinsics.checkNotNullParameter(shareUrl, "shareUrl");
        Intrinsics.checkNotNullParameter(ShareChannelId, "ShareChannelId");
        Intrinsics.checkNotNullParameter(toGuildId, "toGuildId");
        Integer num = newSharePanelChannelMap.get(ShareChannelId);
        if (num != null) {
            o(shareUrl, num.intValue(), sharePanelPageSource, toGuildId);
        }
    }
}
