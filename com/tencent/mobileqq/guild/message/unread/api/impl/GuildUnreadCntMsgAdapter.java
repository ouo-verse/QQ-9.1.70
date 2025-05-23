package com.tencent.mobileqq.guild.message.unread.api.impl;

import android.os.Looper;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.message.unread.UnreadInfo;
import com.tencent.mobileqq.guild.message.unread.api.DataSource;
import com.tencent.mobileqq.guild.util.s;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGProSession;
import com.tencent.mobileqq.qqguildsdk.api.IGuildMsgService;
import com.tencent.mobileqq.qqguildsdk.data.GProUnreadCntUpData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProContact;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProUnreadCnt;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProUnreadCntInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.IUnreadCntCallback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.flow.FlowKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b/\u00100J0\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0002J0\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u0004j\b\u0012\u0004\u0012\u00020\u0010`\u0006H\u0002J\u001c\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00132\u0006\u0010\u000e\u001a\u00020\u0010H\u0002J\u0016\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0019J\u000e\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0017J\u0016\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u0017J\u001c\u0010\"\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u00172\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00170 J\u0016\u0010$\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u0017J\u000e\u0010%\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u0017J\u000e\u0010&\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u0017R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\"\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00190+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/guild/message/unread/api/impl/GuildUnreadCntMsgAdapter;", "", "", "unreadCntUpType", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/guild/message/unread/UnreadInfo;", "Lkotlin/collections/ArrayList;", "unreadInfos", "Lcom/tencent/mobileqq/guild/message/unread/api/DataSource;", "dataSource", "", "j", HippyTKDListViewAdapter.X, "Lcom/tencent/mobileqq/qqguildsdk/data/cd;", "unreadCntInfo", "v", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProUnreadCntInfo;", "unreadInfoList", "w", "", "Lcom/tencent/mobileqq/guild/message/unread/UnreadInfo$UnreadType;", "Lcom/tencent/mobileqq/guild/message/unread/UnreadInfo$a;", "o", "", "tag", "Lcom/tencent/mobileqq/guild/message/unread/api/f;", "callback", "t", "u", "guildId", "channelId", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "channelIds", tl.h.F, "categoryId", "k", "r", "p", "Lkotlinx/coroutines/CoroutineScope;", "b", "Lkotlinx/coroutines/CoroutineScope;", "unreadCntCorutine", "Ljava/util/concurrent/ConcurrentHashMap;", "c", "Ljava/util/concurrent/ConcurrentHashMap;", "onUnreadInfoCallbackMap", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildUnreadCntMsgAdapter {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GuildUnreadCntMsgAdapter f230860a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static CoroutineScope unreadCntCorutine;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static ConcurrentHashMap<String, com.tencent.mobileqq.guild.message.unread.api.f> onUnreadInfoCallbackMap;

    static {
        CompletableJob Job$default;
        GuildUnreadCntMsgAdapter guildUnreadCntMsgAdapter = new GuildUnreadCntMsgAdapter();
        f230860a = guildUnreadCntMsgAdapter;
        Job$default = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
        unreadCntCorutine = CoroutineScopeKt.CoroutineScope(Job$default.plus(Dispatchers.getIO()));
        onUnreadInfoCallbackMap = new ConcurrentHashMap<>();
        guildUnreadCntMsgAdapter.x();
    }

    GuildUnreadCntMsgAdapter() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(String guildId, List channelIds, int i3, String str, ArrayList unreadCntInfos) {
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        Intrinsics.checkNotNullParameter(channelIds, "$channelIds");
        if (i3 != 0) {
            QLog.e("GuildUnreadCntMsgAdapter", 4, "batchGetChannelUnreadCntInfo failed(" + i3 + ", " + str + "): guildId = " + guildId + ", channelIds = " + channelIds);
            return;
        }
        GuildUnreadCntMsgAdapter guildUnreadCntMsgAdapter = f230860a;
        Intrinsics.checkNotNullExpressionValue(unreadCntInfos, "unreadCntInfos");
        guildUnreadCntMsgAdapter.j(1, guildUnreadCntMsgAdapter.w(unreadCntInfos), DataSource.FETCH);
    }

    private final void j(final int unreadCntUpType, final ArrayList<UnreadInfo> unreadInfos, final DataSource dataSource) {
        Object m476constructorimpl;
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            try {
                for (com.tencent.mobileqq.guild.message.unread.api.f fVar : onUnreadInfoCallbackMap.values()) {
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        fVar.a(unreadCntUpType, unreadInfos, dataSource);
                        m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
                    } catch (Throwable th5) {
                        Result.Companion companion2 = Result.INSTANCE;
                        m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
                    }
                    Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
                    if (m479exceptionOrNullimpl != null) {
                        s.f("GuildUnreadCntMsgAdapter", "dispatch callback fail", m479exceptionOrNullimpl);
                    }
                }
                return;
            } catch (Exception e16) {
                s.f("GuildUnreadCntMsgAdapter", "executeCallback fail", e16);
                return;
            }
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.message.unread.api.impl.GuildUnreadCntMsgAdapter$excuteCallback$$inlined$executeOnUIThread$1
            @Override // java.lang.Runnable
            public final void run() {
                Object m476constructorimpl2;
                try {
                    for (com.tencent.mobileqq.guild.message.unread.api.f fVar2 : GuildUnreadCntMsgAdapter.onUnreadInfoCallbackMap.values()) {
                        GuildUnreadCntMsgAdapter guildUnreadCntMsgAdapter = GuildUnreadCntMsgAdapter.f230860a;
                        try {
                            Result.Companion companion3 = Result.INSTANCE;
                            fVar2.a(unreadCntUpType, unreadInfos, dataSource);
                            m476constructorimpl2 = Result.m476constructorimpl(Unit.INSTANCE);
                        } catch (Throwable th6) {
                            Result.Companion companion4 = Result.INSTANCE;
                            m476constructorimpl2 = Result.m476constructorimpl(ResultKt.createFailure(th6));
                        }
                        Throwable m479exceptionOrNullimpl2 = Result.m479exceptionOrNullimpl(m476constructorimpl2);
                        if (m479exceptionOrNullimpl2 != null) {
                            s.f("GuildUnreadCntMsgAdapter", "dispatch callback fail", m479exceptionOrNullimpl2);
                        }
                    }
                } catch (Exception e17) {
                    s.f("GuildUnreadCntMsgAdapter", "executeCallback fail", e17);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(String guildId, String categoryId, int i3, String str, ArrayList unreadCntInfos) {
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        Intrinsics.checkNotNullParameter(categoryId, "$categoryId");
        if (i3 != 0) {
            QLog.e("GuildUnreadCntMsgAdapter", 4, "getCategoryUnreadCntInfo failed(" + i3 + ", " + str + "): guildId = " + guildId + ", categoryId = " + categoryId);
            return;
        }
        GuildUnreadCntMsgAdapter guildUnreadCntMsgAdapter = f230860a;
        Intrinsics.checkNotNullExpressionValue(unreadCntInfos, "unreadCntInfos");
        guildUnreadCntMsgAdapter.j(5, guildUnreadCntMsgAdapter.w(unreadCntInfos), DataSource.FETCH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(String guildId, String channelId, int i3, String str, ArrayList unreadCntInfos) {
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        Intrinsics.checkNotNullParameter(channelId, "$channelId");
        if (i3 != 0) {
            QLog.e("GuildUnreadCntMsgAdapter", 4, "getChannelUnreadCntInfo failed(" + i3 + ", " + str + "): guildId = " + guildId + ", channelId = " + channelId);
            return;
        }
        GuildUnreadCntMsgAdapter guildUnreadCntMsgAdapter = f230860a;
        Intrinsics.checkNotNullExpressionValue(unreadCntInfos, "unreadCntInfos");
        guildUnreadCntMsgAdapter.j(1, guildUnreadCntMsgAdapter.w(unreadCntInfos), DataSource.FETCH);
    }

    private final Map<UnreadInfo.UnreadType, UnreadInfo.a> o(GProUnreadCntInfo unreadCntInfo) {
        boolean z16;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        boolean z17 = false;
        if (unreadCntInfo.showUnreadCnt.cnt > 0) {
            UnreadInfo.UnreadType unreadType = UnreadInfo.UnreadType.TYPE_GUILD_SHOW;
            GProUnreadCnt gProUnreadCnt = unreadCntInfo.showUnreadCnt;
            int i3 = gProUnreadCnt.type;
            if (i3 == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            linkedHashMap.put(unreadType, new UnreadInfo.a(z16, gProUnreadCnt.cnt, i3));
        }
        if (unreadCntInfo.allUnreadCnt.cnt > 0) {
            UnreadInfo.UnreadType unreadType2 = UnreadInfo.UnreadType.TYPE_GUILD_ALL;
            GProUnreadCnt gProUnreadCnt2 = unreadCntInfo.allUnreadCnt;
            int i16 = gProUnreadCnt2.type;
            if (i16 == 1) {
                z17 = true;
            }
            linkedHashMap.put(unreadType2, new UnreadInfo.a(z17, gProUnreadCnt2.cnt, i16));
        }
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(String guildId, int i3, String str, ArrayList unreadCntInfos) {
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        if (i3 != 0) {
            QLog.e("GuildUnreadCntMsgAdapter", 1, "getGuildFeedsUnreadCntInfo failed(" + i3 + ", " + str + "): guildId = " + guildId);
            return;
        }
        GuildUnreadCntMsgAdapter guildUnreadCntMsgAdapter = f230860a;
        Intrinsics.checkNotNullExpressionValue(unreadCntInfos, "unreadCntInfos");
        guildUnreadCntMsgAdapter.j(6, guildUnreadCntMsgAdapter.w(unreadCntInfos), DataSource.FETCH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(String guildId, int i3, String str, ArrayList unreadCntInfos) {
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        if (i3 != 0) {
            QLog.e("GuildUnreadCntMsgAdapter", 1, "getGuildUnreadCntInfo failed(" + i3 + ", " + str + "): guildId = " + guildId);
            return;
        }
        GuildUnreadCntMsgAdapter guildUnreadCntMsgAdapter = f230860a;
        Intrinsics.checkNotNullExpressionValue(unreadCntInfos, "unreadCntInfos");
        guildUnreadCntMsgAdapter.j(2, guildUnreadCntMsgAdapter.w(unreadCntInfos), DataSource.FETCH);
    }

    private final void v(GProUnreadCntUpData unreadCntInfo) {
        HashMap<Integer, ArrayList<GProUnreadCntInfo>> a16 = unreadCntInfo.a();
        if (a16 != null && (!a16.isEmpty())) {
            for (Map.Entry<Integer, ArrayList<GProUnreadCntInfo>> entry : a16.entrySet()) {
                int intValue = entry.getKey().intValue();
                ArrayList<GProUnreadCntInfo> value = entry.getValue();
                if (!value.isEmpty()) {
                    GuildUnreadCntMsgAdapter guildUnreadCntMsgAdapter = f230860a;
                    guildUnreadCntMsgAdapter.j(intValue, guildUnreadCntMsgAdapter.w(value), DataSource.PUSH);
                }
            }
        }
    }

    private final ArrayList<UnreadInfo> w(ArrayList<GProUnreadCntInfo> unreadInfoList) {
        ArrayList<UnreadInfo> arrayList = new ArrayList<>();
        Iterator<GProUnreadCntInfo> it = unreadInfoList.iterator();
        while (it.hasNext()) {
            GProUnreadCntInfo unreadInfo = it.next();
            String str = unreadInfo.peer.guildId;
            Intrinsics.checkNotNullExpressionValue(str, "unreadInfo.peer.guildId");
            String str2 = unreadInfo.peer.peerUid;
            Intrinsics.checkNotNullExpressionValue(str2, "unreadInfo.peer.peerUid");
            Intrinsics.checkNotNullExpressionValue(unreadInfo, "unreadInfo");
            Map<UnreadInfo.UnreadType, UnreadInfo.a> o16 = o(unreadInfo);
            String str3 = unreadInfo.relatedToMeString;
            if (str3 == null) {
                str3 = "";
            }
            arrayList.add(new UnreadInfo(str, str2, o16, str3, unreadInfo.relatedToMeCnt));
        }
        return arrayList;
    }

    private final void x() {
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(((IGuildMsgService) QRoute.api(IGuildMsgService.class)).registerUnreadCntInfoUpdateFlow(), new GuildUnreadCntMsgAdapter$unreadTransToLastMsgFlow$1(this)), Dispatchers.getDefault()), unreadCntCorutine);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object y(GuildUnreadCntMsgAdapter guildUnreadCntMsgAdapter, GProUnreadCntUpData gProUnreadCntUpData, Continuation continuation) {
        guildUnreadCntMsgAdapter.v(gProUnreadCntUpData);
        return Unit.INSTANCE;
    }

    public final void h(@NotNull final String guildId, @NotNull final List<String> channelIds) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelIds, "channelIds");
        QLog.i("GuildUnreadCntMsgAdapter", 1, "batchGetChannelUnreadCntInfo(" + guildId + ", size\uff1a" + channelIds.size() + ")");
        ArrayList<GProContact> arrayList = new ArrayList<>();
        Iterator<T> it = channelIds.iterator();
        while (it.hasNext()) {
            arrayList.add(new GProContact(4, (String) it.next(), guildId));
        }
        uh2.c gProGuildMsgService = ((IGProSession) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGProSession.class, "")).getGProGuildMsgService();
        if (gProGuildMsgService != null) {
            gProGuildMsgService.getUnreadCntInfo(arrayList, new IUnreadCntCallback() { // from class: com.tencent.mobileqq.guild.message.unread.api.impl.d
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IUnreadCntCallback
                public final void onResult(int i3, String str, ArrayList arrayList2) {
                    GuildUnreadCntMsgAdapter.i(guildId, channelIds, i3, str, arrayList2);
                }
            });
        }
    }

    public final void k(@NotNull final String guildId, @NotNull final String categoryId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(categoryId, "categoryId");
        QLog.i("GuildUnreadCntMsgAdapter", 4, "getCategoryUnreadCntInfo(" + guildId + ", " + categoryId + ")");
        uh2.c gProGuildMsgService = ((IGProSession) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGProSession.class, "")).getGProGuildMsgService();
        if (gProGuildMsgService != null) {
            gProGuildMsgService.x(new GProContact(2, categoryId, guildId), new IUnreadCntCallback() { // from class: com.tencent.mobileqq.guild.message.unread.api.impl.b
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IUnreadCntCallback
                public final void onResult(int i3, String str, ArrayList arrayList) {
                    GuildUnreadCntMsgAdapter.l(guildId, categoryId, i3, str, arrayList);
                }
            });
        }
    }

    public final void m(@NotNull final String guildId, @NotNull final String channelId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        QLog.i("GuildUnreadCntMsgAdapter", 4, "getChannelUnreadCntInfo(" + guildId + ", " + channelId + ")");
        uh2.c gProGuildMsgService = ((IGProSession) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGProSession.class, "")).getGProGuildMsgService();
        if (gProGuildMsgService != null) {
            gProGuildMsgService.G(new GProContact(4, channelId, guildId), new IUnreadCntCallback() { // from class: com.tencent.mobileqq.guild.message.unread.api.impl.c
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IUnreadCntCallback
                public final void onResult(int i3, String str, ArrayList arrayList) {
                    GuildUnreadCntMsgAdapter.n(guildId, channelId, i3, str, arrayList);
                }
            });
        }
    }

    public final void p(@NotNull final String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        QLog.i("GuildUnreadCntMsgAdapter", 1, "getGuildFeedsUnreadCntInfo(" + guildId + ")");
        uh2.c gProGuildMsgService = ((IGProSession) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGProSession.class, "")).getGProGuildMsgService();
        if (gProGuildMsgService != null) {
            gProGuildMsgService.P(new GProContact(4, "", guildId), new IUnreadCntCallback() { // from class: com.tencent.mobileqq.guild.message.unread.api.impl.e
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IUnreadCntCallback
                public final void onResult(int i3, String str, ArrayList arrayList) {
                    GuildUnreadCntMsgAdapter.q(guildId, i3, str, arrayList);
                }
            });
        }
    }

    public final void r(@NotNull final String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        QLog.i("GuildUnreadCntMsgAdapter", 1, "getGuildUnreadCntInfo(" + guildId + ")");
        uh2.c gProGuildMsgService = ((IGProSession) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGProSession.class, "")).getGProGuildMsgService();
        if (gProGuildMsgService != null) {
            gProGuildMsgService.p(new GProContact(4, "", guildId), new IUnreadCntCallback() { // from class: com.tencent.mobileqq.guild.message.unread.api.impl.f
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IUnreadCntCallback
                public final void onResult(int i3, String str, ArrayList arrayList) {
                    GuildUnreadCntMsgAdapter.s(guildId, i3, str, arrayList);
                }
            });
        }
    }

    public final void t(@NotNull String tag, @NotNull com.tencent.mobileqq.guild.message.unread.api.f callback) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!onUnreadInfoCallbackMap.containsKey(tag)) {
            onUnreadInfoCallbackMap.put(tag, callback);
        }
    }

    public final void u(@NotNull String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (onUnreadInfoCallbackMap.containsKey(tag)) {
            onUnreadInfoCallbackMap.remove(tag);
        }
    }
}
