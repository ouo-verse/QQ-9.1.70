package com.tencent.mobileqq.aio.msglist.holder.component.poke;

import android.os.Handler;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.PokeMsgItem;
import com.tencent.mobileqq.aio.msglist.AbsAIOMsgProcessor;
import com.tencent.mobileqq.aio.utils.AIOUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOPokeApi;
import com.tencent.qqnt.kernel.nativeinterface.AnonymousExtInfo;
import com.tencent.qqnt.kernel.nativeinterface.DirectMsgMember;
import com.tencent.qqnt.kernel.nativeinterface.FaceElement;
import com.tencent.qqnt.kernel.nativeinterface.FoldingInfo;
import com.tencent.qqnt.kernel.nativeinterface.FreqLimitInfo;
import com.tencent.qqnt.kernel.nativeinterface.FromRoleInfo;
import com.tencent.qqnt.kernel.nativeinterface.GuildClientIdentity;
import com.tencent.qqnt.kernel.nativeinterface.GuildMedal;
import com.tencent.qqnt.kernel.nativeinterface.MsgAttributeInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgEmojiLikes;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.MultiTransInfo;
import com.tencent.qqnt.kernel.nativeinterface.TextElement;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 12\u00020\u0001:\u0001\u0017B\u0017\u0012\u0006\u0010,\u001a\u00020+\u0012\u0006\u0010.\u001a\u00020-\u00a2\u0006\u0004\b/\u00100J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J$\u0010\n\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\u0002J \u0010\u000f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bH\u0002J,\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u000b2\b\b\u0002\u0010\u0013\u001a\u00020\u000b2\b\b\u0002\u0010\u0014\u001a\u00020\u000bH\u0002J\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\b\u0010\u0018\u001a\u00020\u0002H\u0016J\b\u0010\u0019\u001a\u00020\u0002H\u0016R$\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u001cR\u0014\u0010 \u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001fR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u001b\u0010*\u001a\u00020%8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/poke/AIOMsgPokeProcessor;", "Lcom/tencent/mobileqq/aio/msglist/AbsAIOMsgProcessor;", "", "p", DomainData.DOMAIN_NAME, "", "Lcom/tencent/aio/data/msglist/a;", "displayList", "", "newDisplayList", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "prevPokeType", "targetPokeType", "prevStrength", "l", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "pokeType", "vasPokeId", "strength", "Lcom/tencent/mobileqq/aio/msg/PokeMsgItem;", "r", "a", "d", "e", "Lkotlin/Function1;", "", "Lkotlin/jvm/functions/Function1;", "vasResourceCallback", "Landroid/os/Handler;", "Landroid/os/Handler;", "handler", "Lcom/tencent/mobileqq/qdispatchqueue/h;", "f", "Lcom/tencent/mobileqq/qdispatchqueue/h;", "serialQueue", "", "g", "Lkotlin/Lazy;", "o", "()Z", "useSerialQueue", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lkotlinx/coroutines/CoroutineScope;", "scope", "<init>", "(Lcom/tencent/aio/api/runtime/a;Lkotlinx/coroutines/CoroutineScope;)V", tl.h.F, "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOMsgPokeProcessor extends AbsAIOMsgProcessor {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    private static final HashMap<Long, Integer> f191426i;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    private static final int[] f191427j;

    /* renamed from: k, reason: collision with root package name */
    private static int f191428k;

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    private static final Map<Integer, Integer> f191429l;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<? super String, Unit> vasResourceCallback;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Handler handler;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.qdispatchqueue.h serialQueue;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy useSerialQueue;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR#\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/poke/AIOMsgPokeProcessor$a;", "", "", "", "pokeSvipMap", "Ljava/util/Map;", "a", "()Ljava/util/Map;", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.poke.AIOMsgPokeProcessor$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
                return;
            }
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final Map<Integer, Integer> a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                return AIOMsgPokeProcessor.f191429l;
            }
            return (Map) iPatchRedirector.redirect((short) 6, (Object) this);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49158);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        INSTANCE = new Companion(null);
        f191426i = new HashMap<>();
        f191427j = new int[]{2011, 2007, 2006, 2009, 2005, 2004, 2003, 2001, 2002, 2000};
        f191428k = -1;
        f191429l = new HashMap();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIOMsgPokeProcessor(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull CoroutineScope scope) {
        super(aioContext, scope);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(scope, "scope");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aioContext, (Object) scope);
            return;
        }
        this.handler = new Handler(ThreadManagerV2.getQQCommonThreadLooper());
        com.tencent.mobileqq.qdispatchqueue.h a16 = com.tencent.mobileqq.qdispatchqueue.d.a("AIOMsgPokeProcessor");
        Intrinsics.checkNotNullExpressionValue(a16, "createSerialQueue(\"AIOMsgPokeProcessor\")");
        this.serialQueue = a16;
        lazy = LazyKt__LazyJVMKt.lazy(AIOMsgPokeProcessor$useSerialQueue$2.INSTANCE);
        this.useSerialQueue = lazy;
    }

    private final int l(int prevPokeType, int targetPokeType, int prevStrength) {
        int coerceAtMost;
        if (prevPokeType == targetPokeType) {
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(prevStrength + 1, 3);
            return coerceAtMost;
        }
        return 0;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:19:0x0042. Please report as an issue. */
    private final void m(List<? extends com.tencent.aio.data.msglist.a> displayList, List<com.tencent.aio.data.msglist.a> newDisplayList) {
        AIOMsgItem aIOMsgItem;
        MsgRecord msgRecord;
        ArrayList<MsgElement> arrayList;
        Object orNull;
        TextElement textElement;
        int i3 = -1;
        int i16 = 0;
        for (com.tencent.aio.data.msglist.a aVar : displayList) {
            String str = null;
            if (aVar instanceof AIOMsgItem) {
                aIOMsgItem = (AIOMsgItem) aVar;
            } else {
                aIOMsgItem = null;
            }
            if (aIOMsgItem != null && (msgRecord = aIOMsgItem.getMsgRecord()) != null && (arrayList = msgRecord.elements) != null) {
                orNull = CollectionsKt___CollectionsKt.getOrNull(arrayList, 0);
                MsgElement msgElement = (MsgElement) orNull;
                if (msgElement != null && (textElement = msgElement.textElement) != null) {
                    str = textElement.content;
                }
            }
            if (str != null) {
                int i17 = 1;
                switch (str.hashCode()) {
                    case -1369391077:
                        if (str.equals("[666]\u8bf7\u4f7f\u7528\u6700\u65b0\u7248\u672c\u624b\u673aQQ\u67e5\u770b\u3002")) {
                            i17 = 5;
                            i16 = l(i3, 5, i16);
                            newDisplayList.add(s(this, ((AIOMsgItem) aVar).getMsgRecord(), 5, 0, i16, 4, null));
                            i3 = i17;
                            break;
                        } else {
                            break;
                        }
                    case -582758778:
                        if (str.equals("[\u6233\u4e00\u6233]\u8bf7\u4f7f\u7528\u6700\u65b0\u7248\u624b\u673aQQ\u4f53\u9a8c\u65b0\u529f\u80fd\u3002")) {
                            i16 = l(i3, 1, i16);
                            newDisplayList.add(s(this, ((AIOMsgItem) aVar).getMsgRecord(), 1, 0, i16, 4, null));
                            i3 = i17;
                            break;
                        } else {
                            break;
                        }
                    case -279723585:
                        if (str.equals("[\u653e\u5927\u62db]\u8bf7\u4f7f\u7528\u6700\u65b0\u7248\u672c\u624b\u673aQQ\u67e5\u770b\u3002")) {
                            i17 = 6;
                            i16 = l(i3, 6, i16);
                            newDisplayList.add(s(this, ((AIOMsgItem) aVar).getMsgRecord(), 6, 0, i16, 4, null));
                            i3 = i17;
                            break;
                        } else {
                            break;
                        }
                    case 590615404:
                        if (str.equals("[\u6bd4\u5fc3]\u8bf7\u4f7f\u7528\u6700\u65b0\u7248\u672c\u624b\u673aQQ\u67e5\u770b\u3002")) {
                            i17 = 2;
                            i16 = l(i3, 2, i16);
                            newDisplayList.add(s(this, ((AIOMsgItem) aVar).getMsgRecord(), 2, 0, i16, 4, null));
                            i3 = i17;
                            break;
                        } else {
                            break;
                        }
                    case 692336107:
                        if (str.equals("[\u6233\u4e00\u6233]\u8bf7\u4f7f\u7528\u6700\u65b0\u7248\u672c\u624b\u673aQQ\u67e5\u770b\u3002")) {
                            HashMap<Long, Integer> hashMap = f191426i;
                            Long valueOf = Long.valueOf(aVar.getMsgId());
                            Integer num = hashMap.get(valueOf);
                            if (num == null) {
                                int[] iArr = f191427j;
                                int i18 = f191428k + 1;
                                f191428k = i18;
                                num = Integer.valueOf(iArr[i18 % iArr.length]);
                                hashMap.put(valueOf, num);
                            }
                            newDisplayList.add(s(this, ((AIOMsgItem) aVar).getMsgRecord(), 126, num.intValue(), 0, 8, null));
                            i3 = -1;
                            break;
                        }
                        break;
                    case 703674198:
                        if (str.equals("[\u70b9\u8d5e]\u8bf7\u4f7f\u7528\u6700\u65b0\u7248\u672c\u624b\u673aQQ\u67e5\u770b\u3002")) {
                            i17 = 3;
                            i16 = l(i3, 3, i16);
                            newDisplayList.add(s(this, ((AIOMsgItem) aVar).getMsgRecord(), 3, 0, i16, 4, null));
                            i3 = i17;
                            break;
                        } else {
                            break;
                        }
                    case 1560027440:
                        if (str.equals("[\u5fc3\u788e]\u8bf7\u4f7f\u7528\u6700\u65b0\u7248\u672c\u624b\u673aQQ\u67e5\u770b\u3002")) {
                            i17 = 4;
                            i16 = l(i3, 4, i16);
                            newDisplayList.add(s(this, ((AIOMsgItem) aVar).getMsgRecord(), 4, 0, i16, 4, null));
                            i3 = i17;
                            break;
                        } else {
                            break;
                        }
                }
            }
            newDisplayList.add(aVar);
            i3 = -1;
        }
    }

    private final void n() {
        QLog.i("AIOMsgPokeProcessor", 1, "destroyPokeMessage");
        ((IAIOPokeApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOPokeApi.class)).destroy();
        this.vasResourceCallback = null;
        f191429l.clear();
    }

    private final boolean o() {
        return ((Boolean) this.useSerialQueue.getValue()).booleanValue();
    }

    private final void p() {
        QLog.i("AIOMsgPokeProcessor", 1, "initPokeMessage");
        this.vasResourceCallback = new Function1<String, Unit>() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.poke.AIOMsgPokeProcessor$initPokeMessage$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOMsgPokeProcessor.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull String errMsg) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) errMsg);
                    return;
                }
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                QLog.i("AIOMsgPokeProcessor", 1, "vas resource callback, errMsg:" + errMsg);
                if (errMsg.length() == 0) {
                    AIOMsgPokeProcessor.this.b().e().h(AIOMsgListEvent.PokeVasResReady.f188360d);
                }
            }
        };
        ((IAIOPokeApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOPokeApi.class)).init(f191429l, this.vasResourceCallback);
        if (AIOUtil.f194084a.t()) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.poke.e
                @Override // java.lang.Runnable
                public final void run() {
                    AIOMsgPokeProcessor.q();
                }
            }, 64, null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q() {
        File file = new File(VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + File.separator));
        if (!new File(file, "newpoke").isDirectory()) {
            if (!file.exists()) {
                file.mkdirs();
            }
            try {
                InputStream open = BaseApplication.getContext().getAssets().open("newpoke.zip");
                Intrinsics.checkNotNullExpressionValue(open, "getContext().assets.open(\"newpoke.zip\")");
                File file2 = new File(file, "newpoke.zip");
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = open.read(bArr);
                    Integer valueOf = Integer.valueOf(read);
                    if (read != -1) {
                        fileOutputStream.write(bArr, 0, valueOf.intValue());
                    } else {
                        open.close();
                        fileOutputStream.close();
                        FileUtils.uncompressZip(file2.getAbsolutePath(), file.getAbsolutePath(), false);
                        file2.delete();
                        return;
                    }
                }
            } catch (FileNotFoundException unused) {
                QLog.i("AIOMsgPokeProcessor", 1, "newpoke.zip not exist");
            }
        }
    }

    private final PokeMsgItem r(MsgRecord msgRecord, int pokeType, int vasPokeId, int strength) {
        FaceElement faceElement = new FaceElement();
        faceElement.pokeType = Integer.valueOf(pokeType);
        faceElement.vaspokeId = Integer.valueOf(vasPokeId);
        faceElement.pokeStrength = Integer.valueOf(strength);
        faceElement.faceType = 5;
        MsgElement msgElement = new MsgElement();
        msgElement.faceElement = faceElement;
        msgElement.elementType = 6;
        ArrayList arrayList = new ArrayList();
        arrayList.add(msgElement);
        long j3 = msgRecord.msgId;
        long j16 = msgRecord.msgRandom;
        long j17 = msgRecord.msgSeq;
        long j18 = msgRecord.cntSeq;
        int i3 = msgRecord.chatType;
        int i16 = msgRecord.subMsgType;
        int i17 = msgRecord.sendType;
        String str = msgRecord.senderUid;
        String str2 = msgRecord.peerUid;
        String str3 = msgRecord.channelId;
        String str4 = msgRecord.guildId;
        long j19 = msgRecord.guildCode;
        long j26 = msgRecord.fromUid;
        long j27 = msgRecord.fromAppid;
        long j28 = msgRecord.msgTime;
        byte[] bArr = msgRecord.msgMeta;
        int i18 = msgRecord.sendStatus;
        String str5 = msgRecord.sendRemarkName;
        String str6 = msgRecord.sendMemberName;
        String str7 = msgRecord.sendNickName;
        String str8 = msgRecord.guildName;
        String str9 = msgRecord.channelName;
        ArrayList<MsgRecord> arrayList2 = msgRecord.records;
        ArrayList<MsgEmojiLikes> arrayList3 = msgRecord.emojiLikesList;
        long j29 = msgRecord.commentCnt;
        int i19 = msgRecord.directMsgFlag;
        ArrayList<DirectMsgMember> arrayList4 = msgRecord.directMsgMembers;
        String str10 = msgRecord.peerName;
        FreqLimitInfo freqLimitInfo = msgRecord.freqLimitInfo;
        boolean z16 = msgRecord.editable;
        String str11 = msgRecord.avatarMeta;
        String str12 = msgRecord.avatarPendant;
        String str13 = msgRecord.feedId;
        long j36 = msgRecord.roleId;
        long j37 = msgRecord.timeStamp;
        GuildClientIdentity guildClientIdentity = msgRecord.clientIdentityInfo;
        boolean z17 = msgRecord.isImportMsg;
        int i26 = msgRecord.atType;
        int i27 = msgRecord.roleType;
        FromRoleInfo fromRoleInfo = msgRecord.fromChannelRoleInfo;
        FromRoleInfo fromRoleInfo2 = msgRecord.fromGuildRoleInfo;
        FromRoleInfo fromRoleInfo3 = msgRecord.levelRoleInfo;
        long j38 = msgRecord.recallTime;
        boolean z18 = msgRecord.isOnlineMsg;
        byte[] bArr2 = msgRecord.generalFlags;
        long j39 = msgRecord.clientSeq;
        Integer num = msgRecord.fileGroupSize;
        FoldingInfo foldingInfo = msgRecord.foldingInfo;
        MultiTransInfo multiTransInfo = msgRecord.multiTransInfo;
        long j46 = msgRecord.senderUin;
        long j47 = msgRecord.peerUin;
        HashMap<Integer, MsgAttributeInfo> hashMap = msgRecord.msgAttrs;
        AnonymousExtInfo anonymousExtInfo = msgRecord.anonymousExtInfo;
        int i28 = msgRecord.nameType;
        int i29 = msgRecord.avatarFlag;
        byte[] bArr3 = msgRecord.extInfoForUI;
        GuildMedal guildMedal = new GuildMedal();
        guildMedal.startTime = 0L;
        guildMedal.endTime = 0L;
        guildMedal.url = "";
        guildMedal.desc = "";
        Unit unit = Unit.INSTANCE;
        PokeMsgItem pokeMsgItem = new PokeMsgItem(new MsgRecord(j3, j16, j17, j18, i3, 2, i16, i17, str, str2, str3, str4, j19, j26, j27, j28, bArr, i18, str5, str6, str7, str8, str9, arrayList, arrayList2, arrayList3, j29, i19, arrayList4, str10, freqLimitInfo, z16, str11, str12, str13, j36, j37, guildClientIdentity, z17, i26, i27, fromRoleInfo, fromRoleInfo2, fromRoleInfo3, j38, z18, bArr2, j39, num, foldingInfo, multiTransInfo, j46, j47, hashMap, anonymousExtInfo, i28, i29, bArr3, guildMedal, 0, msgRecord.msgEventInfo));
        pokeMsgItem.v2(true);
        return pokeMsgItem;
    }

    static /* synthetic */ PokeMsgItem s(AIOMsgPokeProcessor aIOMsgPokeProcessor, MsgRecord msgRecord, int i3, int i16, int i17, int i18, Object obj) {
        if ((i18 & 4) != 0) {
            i16 = 0;
        }
        if ((i18 & 8) != 0) {
            i17 = 0;
        }
        return aIOMsgPokeProcessor.r(msgRecord, i3, i16, i17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(AIOMsgPokeProcessor this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(AIOMsgPokeProcessor this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(AIOMsgPokeProcessor this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(AIOMsgPokeProcessor this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.n();
    }

    @Override // com.tencent.mobileqq.aio.msglist.AbsAIOMsgProcessor
    @NotNull
    public List<com.tencent.aio.data.msglist.a> a(@NotNull List<? extends com.tencent.aio.data.msglist.a> displayList) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) displayList);
        }
        Intrinsics.checkNotNullParameter(displayList, "displayList");
        ArrayList arrayList = new ArrayList();
        if (AIOUtil.f194084a.t()) {
            m(displayList, arrayList);
        } else {
            arrayList.addAll(displayList);
        }
        ArrayList arrayList2 = new ArrayList();
        Pair pair = null;
        Pair pair2 = null;
        int i16 = 0;
        for (com.tencent.aio.data.msglist.a aVar : arrayList) {
            int i17 = i16 + 1;
            Intrinsics.checkNotNull(aVar, "null cannot be cast to non-null type com.tencent.mobileqq.aio.msg.AIOMsgItem");
            if (((AIOMsgItem) aVar).getMsgRecord().msgType == 2 && (aVar instanceof PokeMsgItem)) {
                arrayList2.add(aVar);
                if (!aVar.isSelf()) {
                    Pair pair3 = new Pair(Integer.valueOf(i16), aVar);
                    i16 = i17;
                    pair2 = pair;
                    pair = pair3;
                }
            }
            i16 = i17;
        }
        int size = arrayList2.size();
        if (size > 1 && size - 2 >= 0) {
            int i18 = 0;
            while (true) {
                PokeMsgItem pokeMsgItem = (PokeMsgItem) arrayList2.get(i18);
                if (!pokeMsgItem.s2()) {
                    pokeMsgItem.x2();
                }
                if (i18 == i3) {
                    break;
                }
                i18++;
            }
        }
        if (size > 0) {
            PokeMsgItem pokeMsgItem2 = (PokeMsgItem) arrayList2.get(size - 1);
            if (pokeMsgItem2.H() && !pokeMsgItem2.s2()) {
                pokeMsgItem2.x2();
            }
        }
        if (pair != null) {
            ((PokeMsgItem) pair.getSecond()).w2(true);
            b().e().h(new AIOMsgListEvent.PokeToggleQuickBack(((Number) pair.getFirst()).intValue()));
        }
        if (pair2 != null) {
            ((PokeMsgItem) pair2.getSecond()).w2(false);
            b().e().h(new AIOMsgListEvent.PokeToggleQuickBack(((Number) pair2.getFirst()).intValue()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.aio.msglist.AbsAIOMsgProcessor
    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.d();
        if (o()) {
            this.serialQueue.post(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.poke.c
                @Override // java.lang.Runnable
                public final void run() {
                    AIOMsgPokeProcessor.t(AIOMsgPokeProcessor.this);
                }
            });
        } else {
            this.handler.post(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.poke.d
                @Override // java.lang.Runnable
                public final void run() {
                    AIOMsgPokeProcessor.u(AIOMsgPokeProcessor.this);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.AbsAIOMsgProcessor
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.e();
        if (o()) {
            this.serialQueue.post(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.poke.a
                @Override // java.lang.Runnable
                public final void run() {
                    AIOMsgPokeProcessor.v(AIOMsgPokeProcessor.this);
                }
            });
        } else {
            this.handler.post(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.poke.b
                @Override // java.lang.Runnable
                public final void run() {
                    AIOMsgPokeProcessor.w(AIOMsgPokeProcessor.this);
                }
            });
        }
    }
}
