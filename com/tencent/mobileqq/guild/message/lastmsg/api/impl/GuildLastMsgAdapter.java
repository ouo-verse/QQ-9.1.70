package com.tencent.mobileqq.guild.message.lastmsg.api.impl;

import android.os.Looper;
import android.util.Log;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.message.lastmsg.LastMessage;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGProSession;
import com.tencent.mobileqq.qqguildsdk.api.IGuildMsgService;
import com.tencent.mobileqq.qqguildsdk.data.GProAbstractUpdateData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IGuestGetMsgAbstractsCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGuildGetMsgAbstractsCallback;
import com.tencent.qqnt.kernelpublic.nativeinterface.MsgAbstract;
import com.tencent.qqnt.msg.api.IMsgService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import kotlin.Metadata;
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
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b$\u0010%J4\u0010\u0006\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0003`\u00042\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0002J0\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00032\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0002j\b\u0012\u0004\u0012\u00020\n`\u0004H\u0002J\b\u0010\u000e\u001a\u00020\fH\u0002J\u0012\u0010\u0011\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J0\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0002j\b\u0012\u0004\u0012\u00020\n`\u00042\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0002j\b\u0012\u0004\u0012\u00020\u0012`\u0004H\u0002J\u0016\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0016J\u000e\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0003J&\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u00032\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004J0\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u00032\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016R\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\"\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00160!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\"\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/guild/message/lastmsg/api/impl/GuildLastMsgAdapter;", "", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "channelIds", h.F, "", "result", "msg", "Lcom/tencent/mobileqq/guild/message/lastmsg/LastMessage;", "abstractInfos", "", "j", "d", "Lcom/tencent/mobileqq/qqguildsdk/data/t;", "abstractUpdateData", "i", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/MsgAbstract;", "msgAbstracts", "c", "tag", "Lfu1/a;", "callback", "o", "p", "guildId", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "k", "Lkotlinx/coroutines/CoroutineScope;", "b", "Lkotlinx/coroutines/CoroutineScope;", "abstractMsgCorutine", "", "Ljava/util/Map;", "onMsgAbstracrsCallbackMap", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildLastMsgAdapter {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GuildLastMsgAdapter f230618a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static CoroutineScope abstractMsgCorutine;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static Map<String, fu1.a> onMsgAbstracrsCallbackMap;

    static {
        CompletableJob Job$default;
        GuildLastMsgAdapter guildLastMsgAdapter = new GuildLastMsgAdapter();
        f230618a = guildLastMsgAdapter;
        Job$default = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
        abstractMsgCorutine = CoroutineScopeKt.CoroutineScope(Job$default.plus(Dispatchers.getIO()));
        onMsgAbstracrsCallbackMap = new LinkedHashMap();
        guildLastMsgAdapter.d();
    }

    GuildLastMsgAdapter() {
    }

    private final ArrayList<LastMessage> c(ArrayList<MsgAbstract> msgAbstracts) {
        ArrayList<LastMessage> arrayList = new ArrayList<>();
        Iterator<MsgAbstract> it = msgAbstracts.iterator();
        while (it.hasNext()) {
            MsgAbstract abstractInfo = it.next();
            d dVar = d.f230639a;
            Intrinsics.checkNotNullExpressionValue(abstractInfo, "abstractInfo");
            LastMessage a16 = dVar.a(abstractInfo, "Guild.GSC.GuildLastMsgAdapter");
            if (a16 != null) {
                arrayList.add(a16);
            }
        }
        return arrayList;
    }

    private final void d() {
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(((IGuildMsgService) QRoute.api(IGuildMsgService.class)).registerMsgAbstractUpdateFlow(), new GuildLastMsgAdapter$abstractMsgUpdateFlow$1(this)), Dispatchers.getDefault()), abstractMsgCorutine);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object e(GuildLastMsgAdapter guildLastMsgAdapter, GProAbstractUpdateData gProAbstractUpdateData, Continuation continuation) {
        guildLastMsgAdapter.i(gProAbstractUpdateData);
        return Unit.INSTANCE;
    }

    private final ArrayList<String> h(ArrayList<String> channelIds) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.addAll(channelIds);
        return arrayList;
    }

    private final void i(GProAbstractUpdateData abstractUpdateData) {
        ArrayList<MsgAbstract> a16;
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.GSC.GuildLastMsgAdapter", "excuteAbstractUpdateData(" + abstractUpdateData + ")");
        }
        if (abstractUpdateData != null && (a16 = abstractUpdateData.a()) != null) {
            ArrayList<MsgAbstract> arrayList = new ArrayList<>();
            Iterator<MsgAbstract> it = a16.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
            if (!arrayList.isEmpty()) {
                GuildLastMsgAdapter guildLastMsgAdapter = f230618a;
                guildLastMsgAdapter.j(0, "", guildLastMsgAdapter.c(arrayList));
            }
        }
    }

    private final void j(final int result, final String msg2, final ArrayList<LastMessage> abstractInfos) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            Iterator it = onMsgAbstracrsCallbackMap.values().iterator();
            while (it.hasNext()) {
                ((fu1.a) it.next()).onResult(result, msg2, abstractInfos);
            }
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.message.lastmsg.api.impl.GuildLastMsgAdapter$excuteCallback$$inlined$executeOnUIThread$1
            @Override // java.lang.Runnable
            public final void run() {
                Iterator it5 = GuildLastMsgAdapter.onMsgAbstracrsCallbackMap.values().iterator();
                while (it5.hasNext()) {
                    ((fu1.a) it5.next()).onResult(result, msg2, abstractInfos);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(fu1.a aVar, String guildId, ArrayList channelIds, int i3, String msg2, ArrayList abstractInfos, HashMap hashMap) {
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        Intrinsics.checkNotNullParameter(channelIds, "$channelIds");
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("Guild.GSC.GuildLastMsgAdapter", "fetchGuestMsgAbstracts(" + guildId + ", " + channelIds + "): result = " + i3 + ", errMsg = " + msg2 + ", abstractInfos = " + abstractInfos);
        }
        if (aVar != null) {
            Intrinsics.checkNotNullExpressionValue(msg2, "msg");
            GuildLastMsgAdapter guildLastMsgAdapter = f230618a;
            Intrinsics.checkNotNullExpressionValue(abstractInfos, "abstractInfos");
            aVar.onResult(i3, msg2, guildLastMsgAdapter.c(abstractInfos));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(String guildId, ArrayList channelIds, int i3, String msg2, ArrayList abstractInfos) {
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        Intrinsics.checkNotNullParameter(channelIds, "$channelIds");
        QLog.i("Guild.GSC.GuildLastMsgAdapter", 4, "getMsgAbstracts(" + guildId + ", " + channelIds + "): " + abstractInfos);
        if (i3 != 0) {
            QLog.e("Guild.GSC.GuildLastMsgAdapter", 1, "getMsgAbstracts(" + guildId + ", " + channelIds + "):result = " + i3 + ", msg = " + msg2 + ")");
        } else if (abstractInfos.isEmpty()) {
            QLog.e("Guild.GSC.GuildLastMsgAdapter", 1, "getMsgAbstracts(" + guildId + ", " + channelIds + "):abstractInfos is empty");
        }
        GuildLastMsgAdapter guildLastMsgAdapter = f230618a;
        Intrinsics.checkNotNullExpressionValue(msg2, "msg");
        Intrinsics.checkNotNullExpressionValue(abstractInfos, "abstractInfos");
        guildLastMsgAdapter.j(i3, msg2, guildLastMsgAdapter.c(abstractInfos));
    }

    public final void k(@NotNull final String guildId, @NotNull final ArrayList<String> channelIds, @Nullable final fu1.a callback) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelIds, "channelIds");
        ((IMsgService) QRoute.api(IMsgService.class)).getGuestMsgAbstracts(guildId, channelIds, new Random().nextInt(), new IGuestGetMsgAbstractsCallback() { // from class: com.tencent.mobileqq.guild.message.lastmsg.api.impl.c
            @Override // com.tencent.qqnt.kernel.nativeinterface.IGuestGetMsgAbstractsCallback
            public final void onGetMsgAbstracts(int i3, String str, ArrayList arrayList, HashMap hashMap) {
                GuildLastMsgAdapter.l(fu1.a.this, guildId, channelIds, i3, str, arrayList, hashMap);
            }
        });
    }

    public final void m(@NotNull final String guildId, @NotNull final ArrayList<String> channelIds) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelIds, "channelIds");
        uh2.c gProGuildMsgService = ((IGProSession) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGProSession.class, "")).getGProGuildMsgService();
        if (gProGuildMsgService != null) {
            gProGuildMsgService.getMsgAbstracts(guildId, h(channelIds), new IGProGuildGetMsgAbstractsCallback() { // from class: com.tencent.mobileqq.guild.message.lastmsg.api.impl.b
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGuildGetMsgAbstractsCallback
                public final void onGetMsgAbstracts(int i3, String str, ArrayList arrayList) {
                    GuildLastMsgAdapter.n(guildId, channelIds, i3, str, arrayList);
                }
            });
        }
    }

    public final void o(@NotNull String tag, @NotNull fu1.a callback) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!onMsgAbstracrsCallbackMap.containsKey(tag)) {
            onMsgAbstracrsCallbackMap.put(tag, callback);
        }
    }

    public final void p(@NotNull String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (onMsgAbstracrsCallbackMap.containsKey(tag)) {
            onMsgAbstracrsCallbackMap.remove(tag);
        }
    }
}
