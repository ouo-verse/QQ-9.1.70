package com.tencent.mobileqq.guild.feed.util;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.tencent.mobileqq.guild.base.extension.MiscKt;
import com.tencent.mobileqq.guild.mainframe.GuildFeedReportSourceInfo;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.bw;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetSimpleProfileAsyncRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.ca;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProDoFeedPreferReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProDoFeedPreferRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStChannelSign;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStCommonExt;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStIconInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStUser;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProTotalPrefer;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProDoFeedPreferCallback;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wh2.db;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001&B\t\b\u0002\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004H\u0007J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u001b\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0007J\u001c\u0010\u0014\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0003J.\u0010\u0019\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u000e2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\tH\u0007J \u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u000eH\u0007J\u0010\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\tH\u0002J\u0018\u0010!\u001a\u00020 2\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u0002H\u0007J\n\u0010\"\u001a\u00020\u000e*\u00020\fJ\n\u0010#\u001a\u00020\u0004*\u00020\f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/util/bc;", "", "", "key", "", "i", "prefer", "", "p", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "svrStFeed", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/guild/feed/util/bc$a;", "param", "", "e", "(Lcom/tencent/mobileqq/guild/feed/util/bc$a;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "d", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IGProDoFeedPreferCallback;", "cb", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "feedId", "preferType", "oriPreferType", "stFeed", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "gProStFeed", "lastPreferType", "currentPreferType", "l", "g", CommonConstant.KEY_DISPLAY_NAME, "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStUser;", "f", "k", "j", "<init>", "()V", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class bc {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final bc f223871a = new bc();

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fR\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0015\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/guild/feed/util/bc$a;", "", "", "a", "I", "curPreferStatus", "b", "operate", "", "c", "Ljava/lang/String;", "feedId", "", "d", "J", "guildId", "e", "channelId", "", "f", "Z", "enableFake", "Lcom/tencent/mobileqq/guild/mainframe/GuildFeedReportSourceInfo;", "g", "Lcom/tencent/mobileqq/guild/mainframe/GuildFeedReportSourceInfo;", "reportMap", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", tl.h.F, "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "stFeed", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @JvmField
        public int curPreferStatus;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @JvmField
        public int operate;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public String feedId;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @JvmField
        public long guildId;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @JvmField
        public long channelId;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @JvmField
        public boolean enableFake;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public GuildFeedReportSourceInfo reportMap;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @JvmField
        @Nullable
        public GProStFeed stFeed;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u0006\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n \u0006*\u0004\u0018\u00010\n0\nH\n\u00a2\u0006\u0002\b\u000b"}, d2 = {"<anonymous>", "", "result", "", "errMsg", "", "kotlin.jvm.PlatformType", "isDbCache", "", "rsp", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProDoFeedPreferRsp;", "onResult"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    static final class b implements IGProDoFeedPreferCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<Integer> f223880a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f223881b;

        /* JADX WARN: Multi-variable type inference failed */
        b(CancellableContinuation<? super Integer> cancellableContinuation, a aVar) {
            this.f223880a = cancellableContinuation;
            this.f223881b = aVar;
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProDoFeedPreferCallback
        public final void onResult(int i3, String str, boolean z16, GProDoFeedPreferRsp gProDoFeedPreferRsp) {
            if (this.f223880a.isActive()) {
                if (i3 == 0) {
                    CancellableContinuation<Integer> cancellableContinuation = this.f223880a;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m476constructorimpl(Integer.valueOf(this.f223881b.curPreferStatus)));
                    return;
                }
                Logger.f235387a.d().w("Guild_Feed_GuildPreferUtils", 1, "[feedLikeActionApiImpl] response result " + i3 + " " + str);
                CancellableContinuation<Integer> cancellableContinuation2 = this.f223880a;
                Result.Companion companion2 = Result.INSTANCE;
                cancellableContinuation2.resumeWith(Result.m476constructorimpl(1));
                return;
            }
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("[feedLikeActionApiImpl]continuation is inactive!");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild_Feed_GuildPreferUtils", 1, (String) it.next(), null);
            }
        }
    }

    bc() {
    }

    @JvmStatic
    public static final int d(@NotNull a param) {
        Intrinsics.checkNotNullParameter(param, "param");
        if (TextUtils.isEmpty(param.feedId)) {
            return 0;
        }
        n(param, null, 2, null);
        return param.curPreferStatus;
    }

    @JvmStatic
    @Nullable
    public static final Object e(@NotNull a aVar, @NotNull Continuation<? super Integer> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        m(aVar, new b(cancellableContinuationImpl, aVar));
        if (!cancellableContinuationImpl.isActive()) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("[feedLikeActionApiImpl]continuation is inactive when launching!");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild_Feed_GuildPreferUtils", 1, (String) it.next(), null);
            }
        }
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @JvmStatic
    @NotNull
    public static final GProStUser f(@NotNull GProStFeed stFeed, @NotNull String displayName) {
        Intrinsics.checkNotNullParameter(stFeed, "stFeed");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        String u16 = ax.u();
        long j3 = stFeed.channelInfo.sign.guildId;
        GProStUser gProStUser = new GProStUser();
        gProStUser.idd = ax.u();
        gProStUser.nick = displayName;
        GProStIconInfo gProStIconInfo = new GProStIconInfo();
        gProStIconInfo.iconUrl = ((IGPSService) ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).runtimeService(IGPSService.class)).getGuildUserAvatarUrl(String.valueOf(j3), u16.toString(), 0);
        gProStUser.icon = gProStIconInfo;
        gProStUser.avatarPendant = ((IGPSService) ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).runtimeService(IGPSService.class)).getGuildUserAvatarPendantUrl(u16);
        return gProStUser;
    }

    private final void g(final GProStFeed stFeed) {
        ca caVar = new ca();
        caVar.d(stFeed.channelInfo.sign.guildId);
        String u16 = ax.u();
        Intrinsics.checkNotNullExpressionValue(u16, "getCurrentTinyId()");
        caVar.f(MiscKt.l(u16));
        caVar.e(111);
        ((IGPSService) ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).runtimeService(IGPSService.class)).getSimpleProfileAsync(caVar, new db() { // from class: com.tencent.mobileqq.guild.feed.util.bb
            @Override // wh2.db
            public final void a(int i3, String str, IGProGetSimpleProfileAsyncRsp iGProGetSimpleProfileAsyncRsp) {
                bc.h(GProStFeed.this, i3, str, iGProGetSimpleProfileAsyncRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(GProStFeed stFeed, int i3, String str, IGProGetSimpleProfileAsyncRsp iGProGetSimpleProfileAsyncRsp) {
        Intrinsics.checkNotNullParameter(stFeed, "$stFeed");
        String str2 = "\u9891\u9053\u7528\u6237";
        if (i3 != 0) {
            QLog.e("Guild_Feed_GuildPreferUtils", 1, "[getSimpleProfileAsync] getUserNick is error." + str);
        } else {
            String displayName = iGProGetSimpleProfileAsyncRsp.getSimpleProfile().getDisplayName();
            if (displayName != null) {
                str2 = displayName;
            }
        }
        stFeed.externalLikeUserList.add(0, f(stFeed, str2));
        MutableLiveData globalData = jj1.b.c().getGlobalData(GProStFeed.class, stFeed.idd);
        if (globalData != null) {
            globalData.postValue(stFeed);
        }
    }

    @JvmStatic
    public static final boolean i(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return bw.L().decodeBool(bw.b2("MMKV_KEY_LOCAL_FEED_PREFER_" + key), false);
    }

    @JvmStatic
    public static final void l(@NotNull GProStFeed gProStFeed, int lastPreferType, int currentPreferType) {
        boolean z16;
        Intrinsics.checkNotNullParameter(gProStFeed, "gProStFeed");
        if (currentPreferType == 1) {
            ArrayList<GProStUser> arrayList = gProStFeed.externalLikeUserList;
            Intrinsics.checkNotNullExpressionValue(arrayList, "gProStFeed.externalLikeUserList");
            Iterator<GProStUser> it = arrayList.iterator();
            int i3 = 0;
            while (true) {
                if (it.hasNext()) {
                    if (Intrinsics.areEqual(it.next().idd, ch.f())) {
                        break;
                    } else {
                        i3++;
                    }
                } else {
                    i3 = -1;
                    break;
                }
            }
            if (i3 != -1) {
                gProStFeed.externalLikeUserList.add(0, gProStFeed.externalLikeUserList.remove(i3));
                return;
            }
            String guildUserDisplayNameInternal = ((IGPSService) ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).runtimeService(IGPSService.class)).getGuildUserDisplayNameInternal(String.valueOf(gProStFeed.channelInfo.sign.guildId), ax.u());
            Intrinsics.checkNotNullExpressionValue(guildUserDisplayNameInternal, "api(IQQGuildUtilApi::cla\u2026Utils.getCurrentTinyId())");
            if (guildUserDisplayNameInternal.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                QLog.e("Guild_Feed_GuildPreferUtils", 1, "[preferUpdateScreen] nick is null.");
                f223871a.g(gProStFeed);
                return;
            } else {
                gProStFeed.externalLikeUserList.add(0, f(gProStFeed, guildUserDisplayNameInternal));
                return;
            }
        }
        if (currentPreferType == 3 || (lastPreferType == 1 && currentPreferType == 2)) {
            ArrayList<GProStUser> arrayList2 = gProStFeed.externalLikeUserList;
            Intrinsics.checkNotNullExpressionValue(arrayList2, "gProStFeed.externalLikeUserList");
            ArrayList arrayList3 = new ArrayList();
            for (Object obj : arrayList2) {
                if (!Intrinsics.areEqual(((GProStUser) obj).idd, ch.f())) {
                    arrayList3.add(obj);
                }
            }
            gProStFeed.externalLikeUserList = com.tencent.mobileqq.troop.utils.bg.f302144a.n(arrayList3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final void m(a param, final IGProDoFeedPreferCallback cb5) {
        com.tencent.qqnt.kernel.api.o c16 = l.c();
        if (c16 == null) {
            return;
        }
        final GProDoFeedPreferReq gProDoFeedPreferReq = new GProDoFeedPreferReq();
        gProDoFeedPreferReq.feedId = param.feedId;
        gProDoFeedPreferReq.guildId = param.guildId;
        gProDoFeedPreferReq.channelId = param.channelId;
        gProDoFeedPreferReq.action = f223871a.k(param);
        GProStCommonExt gProStCommonExt = new GProStCommonExt();
        com.tencent.mobileqq.guild.feed.nativepublish.utils.k.a(param.reportMap, gProStCommonExt);
        com.tencent.mobileqq.guild.feed.nativepublish.utils.k.b(gProStCommonExt);
        gProDoFeedPreferReq.extInfo = gProStCommonExt;
        final IPerformanceReportTask i3 = com.tencent.mobileqq.guild.feed.report.c.f223280a.i(gProDoFeedPreferReq);
        c16.doFeedPrefer(gProDoFeedPreferReq, new IGProDoFeedPreferCallback() { // from class: com.tencent.mobileqq.guild.feed.util.ba
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProDoFeedPreferCallback
            public final void onResult(int i16, String str, boolean z16, GProDoFeedPreferRsp gProDoFeedPreferRsp) {
                bc.o(IGProDoFeedPreferCallback.this, i3, gProDoFeedPreferReq, i16, str, z16, gProDoFeedPreferRsp);
            }
        });
        if (param.enableFake) {
            q(param.feedId, gProDoFeedPreferReq.action, param.curPreferStatus, param.stFeed);
        }
    }

    static /* synthetic */ void n(a aVar, IGProDoFeedPreferCallback iGProDoFeedPreferCallback, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            iGProDoFeedPreferCallback = null;
        }
        m(aVar, iGProDoFeedPreferCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(IGProDoFeedPreferCallback iGProDoFeedPreferCallback, IPerformanceReportTask reportTask, GProDoFeedPreferReq feedPreferReq, int i3, String str, boolean z16, GProDoFeedPreferRsp gProDoFeedPreferRsp) {
        Intrinsics.checkNotNullParameter(reportTask, "$reportTask");
        Intrinsics.checkNotNullParameter(feedPreferReq, "$feedPreferReq");
        if (iGProDoFeedPreferCallback != null) {
            iGProDoFeedPreferCallback.onResult(i3, str, z16, gProDoFeedPreferRsp);
        }
        com.tencent.mobileqq.guild.feed.report.c.E(com.tencent.mobileqq.guild.feed.report.c.f223280a, reportTask, i3, str, false, 8, null);
        QLog.i("Guild_Feed_GuildPreferUtils", 1, "handleDoFeedPreferRsp action:" + feedPreferReq.action + " result:" + i3 + " errMsg:" + str);
    }

    @JvmStatic
    public static final void p(@NotNull String key, boolean prefer) {
        boolean z16;
        Intrinsics.checkNotNullParameter(key, "key");
        if (key.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        if (prefer) {
            bw.L().encodeBool(bw.b2("MMKV_KEY_LOCAL_FEED_PREFER_" + key), true);
            return;
        }
        bw.L().removeKey(bw.b2("MMKV_KEY_LOCAL_FEED_PREFER_" + key));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final void q(@Nullable String feedId, int preferType, int oriPreferType, @Nullable GProStFeed stFeed) {
        MutableLiveData globalData = jj1.b.c().getGlobalData(GProStFeed.class, feedId);
        if (globalData == null) {
            QLog.e("Guild_Feed_GuildPreferUtils", 1, "[startFake] mutable prefer data live data should not be null.");
            return;
        }
        if (globalData.getValue() == 0) {
            if (stFeed != null) {
                QLog.w("Guild_Feed_GuildPreferUtils", 1, "[startFake] prefer data is null, but re-applied.");
            } else {
                QLog.d("Guild_Feed_GuildPreferUtils", 1, "[startFake] mutable prefer data should not be null.");
                return;
            }
        } else {
            stFeed = (GProStFeed) globalData.getValue();
        }
        Intrinsics.checkNotNull(stFeed);
        int i3 = stFeed.totalPrefer.preferCountWithoutLike;
        if (preferType == 1) {
            i3++;
        } else if (preferType == 3 || (oriPreferType == 1 && preferType == 2)) {
            i3--;
        }
        l(stFeed, oriPreferType, preferType);
        GProTotalPrefer gProTotalPrefer = stFeed.totalPrefer;
        gProTotalPrefer.preferCountWithoutLike = i3;
        gProTotalPrefer.preferStatus = preferType;
        globalData.postValue(stFeed);
    }

    public static /* synthetic */ void r(String str, int i3, int i16, GProStFeed gProStFeed, int i17, Object obj) {
        if ((i17 & 8) != 0) {
            gProStFeed = null;
        }
        q(str, i3, i16, gProStFeed);
    }

    @JvmStatic
    public static final void s(@NotNull GProStFeed svrStFeed, @NotNull String key) {
        Intrinsics.checkNotNullParameter(svrStFeed, "svrStFeed");
        Intrinsics.checkNotNullParameter(key, "key");
        if (!i(key)) {
            return;
        }
        GProTotalPrefer gProTotalPrefer = svrStFeed.totalPrefer;
        gProTotalPrefer.preferStatus = 1;
        gProTotalPrefer.preferCountWithoutLike++;
        a aVar = new a();
        aVar.curPreferStatus = 2;
        aVar.operate = 2000;
        aVar.feedId = svrStFeed.idd;
        GProStChannelSign gProStChannelSign = svrStFeed.channelInfo.sign;
        aVar.guildId = gProStChannelSign.guildId;
        aVar.channelId = gProStChannelSign.channelId;
        aVar.enableFake = true;
        aVar.stFeed = svrStFeed;
        d(aVar);
        p(key, false);
        Logger.a d16 = Logger.f235387a.d();
        GProStChannelSign gProStChannelSign2 = svrStFeed.channelInfo.sign;
        d16.i("Guild_Feed_GuildPreferUtils", 1, "supplyLocalFeedPrefer guildId:" + gProStChannelSign2.guildId + " channelId:" + gProStChannelSign2.channelId + " key:" + key + " feedId:" + svrStFeed.idd);
    }

    public final boolean j(@NotNull a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        if (k(aVar) == 1) {
            return true;
        }
        return false;
    }

    public final int k(@NotNull a aVar) {
        int i3;
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        int i16 = aVar.operate;
        if (i16 != 2000) {
            if (i16 != 3000) {
                return 0;
            }
            i3 = 2;
            if (aVar.curPreferStatus == 2) {
                return 4;
            }
        } else {
            i3 = 1;
            if (aVar.curPreferStatus == 1) {
                return 3;
            }
        }
        return i3;
    }
}
