package com.tencent.mobileqq.guild.message.draft.api.impl;

import android.os.Looper;
import android.util.Log;
import com.tencent.guild.api.msg.impl.GuildMsgElementApiImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.emoj.api.IQQGuildEmojiApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.FaceElement;
import com.tencent.qqnt.kernel.nativeinterface.IGetDraftOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import com.tencent.qqnt.msg.data.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
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
import org.jetbrains.annotations.NotNull;
import tl.h;
import yt1.DraftInfo;
import yt1.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J \u0010\f\u001a\u00020\u000b2\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tH\u0002J \u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0016\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0017J\u000e\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u000bJ\u0016\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000bR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\"\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00170\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/guild/message/draft/api/impl/GuildDraftAdapter;", "", "", "d", "Lcom/tencent/qqnt/msg/data/c;", "draftUpdateData", "g", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "Lkotlin/collections/ArrayList;", "msgElements", "", h.F, "", "result", "msg", "Lyt1/a;", "draftInfo", "f", "Lcom/tencent/qqnt/kernel/nativeinterface/FaceElement;", "faceElement", "k", "tag", "Lyt1/b;", "callback", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "guildId", "channelId", "i", "Lkotlinx/coroutines/CoroutineScope;", "b", "Lkotlinx/coroutines/CoroutineScope;", "draftCoroutine", "Ljava/util/concurrent/ConcurrentHashMap;", "c", "Ljava/util/concurrent/ConcurrentHashMap;", "onDraftCallbackMap", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildDraftAdapter {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GuildDraftAdapter f230542a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static CoroutineScope draftCoroutine;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static ConcurrentHashMap<String, b> onDraftCallbackMap;

    static {
        CompletableJob Job$default;
        GuildDraftAdapter guildDraftAdapter = new GuildDraftAdapter();
        f230542a = guildDraftAdapter;
        Job$default = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
        draftCoroutine = CoroutineScopeKt.CoroutineScope(Job$default.plus(Dispatchers.getIO()));
        onDraftCallbackMap = new ConcurrentHashMap<>();
        guildDraftAdapter.d();
    }

    GuildDraftAdapter() {
    }

    private final void d() {
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(((IMsgService) QRoute.api(IMsgService.class)).registerDraftUpdateNotificationFlow(), new GuildDraftAdapter$draftUpdateFlow$1(this)), Dispatchers.getDefault()), draftCoroutine);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ Object e(GuildDraftAdapter guildDraftAdapter, c cVar, Continuation continuation) {
        guildDraftAdapter.g(cVar);
        return Unit.INSTANCE;
    }

    private final void f(final int result, final String msg2, final DraftInfo draftInfo) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            Iterator it = onDraftCallbackMap.values().iterator();
            while (it.hasNext()) {
                ((b) it.next()).a(result, msg2, draftInfo);
            }
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.message.draft.api.impl.GuildDraftAdapter$executeCallback$$inlined$executeOnUIThread$1
            @Override // java.lang.Runnable
            public final void run() {
                Iterator it5 = GuildDraftAdapter.onDraftCallbackMap.values().iterator();
                while (it5.hasNext()) {
                    ((b) it5.next()).a(result, msg2, draftInfo);
                }
            }
        });
    }

    private final void g(c draftUpdateData) {
        ArrayList<MsgElement> b16;
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("GuildDraftAdapter", "executeDraftUpdateData draftUpdateData: " + draftUpdateData);
        }
        if (draftUpdateData != null && (b16 = draftUpdateData.b()) != null) {
            GuildDraftAdapter guildDraftAdapter = f230542a;
            String h16 = guildDraftAdapter.h(b16);
            String str = draftUpdateData.c().guildId;
            Intrinsics.checkNotNullExpressionValue(str, "draftData.peer.guildId");
            String str2 = draftUpdateData.c().peerUid;
            Intrinsics.checkNotNullExpressionValue(str2, "draftData.peer.peerUid");
            guildDraftAdapter.f(0, "", new DraftInfo(str, str2, draftUpdateData.a(), h16));
        }
    }

    private final String h(ArrayList<MsgElement> msgElements) {
        String str;
        String str2 = "";
        if (msgElements.isEmpty()) {
            return "";
        }
        Iterator<MsgElement> it = msgElements.iterator();
        while (it.hasNext()) {
            MsgElement next = it.next();
            int i3 = next.elementType;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 5) {
                        if (i3 == 6) {
                            FaceElement faceElement = next.faceElement;
                            Intrinsics.checkNotNullExpressionValue(faceElement, "msgElement.faceElement");
                            str = str2 + k(faceElement);
                        }
                    } else {
                        str = str2 + "[\u89c6\u9891]";
                    }
                } else {
                    str = str2 + GuildMsgElementApiImpl.DESC_ELEMENT_PIC;
                }
            } else {
                str = str2 + next.textElement.content;
            }
            str2 = str;
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(String guildId, String channelId, int i3, String errMsg, ArrayList msgElements, long j3) {
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        Intrinsics.checkNotNullParameter(channelId, "$channelId");
        GuildDraftAdapter guildDraftAdapter = f230542a;
        Intrinsics.checkNotNullExpressionValue(msgElements, "msgElements");
        DraftInfo draftInfo = new DraftInfo(guildId, channelId, j3, guildDraftAdapter.h(msgElements));
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        guildDraftAdapter.f(i3, errMsg, draftInfo);
    }

    private final String k(FaceElement faceElement) {
        if (faceElement.faceIndex > 0) {
            return ((IQQGuildEmojiApi) QRoute.api(IQQGuildEmojiApi.class)).fetchEmoSpan(faceElement.faceType, faceElement.faceIndex).toString();
        }
        return "";
    }

    public final void i(@NotNull final String guildId, @NotNull final String channelId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        ((IMsgService) QRoute.api(IMsgService.class)).getDraft(new Contact(4, channelId, guildId), new IGetDraftOperateCallback() { // from class: com.tencent.mobileqq.guild.message.draft.api.impl.a
            @Override // com.tencent.qqnt.kernel.nativeinterface.IGetDraftOperateCallback
            public final void onResult(int i3, String str, ArrayList arrayList, long j3) {
                GuildDraftAdapter.j(guildId, channelId, i3, str, arrayList, j3);
            }
        });
    }

    public final void l(@NotNull String tag, @NotNull b callback) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(callback, "callback");
        onDraftCallbackMap.putIfAbsent(tag, callback);
    }

    public final void m(@NotNull String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        onDraftCallbackMap.remove(tag);
    }
}
