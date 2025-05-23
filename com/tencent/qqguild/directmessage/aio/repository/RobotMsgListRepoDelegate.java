package com.tencent.qqguild.directmessage.aio.repository;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.aio.msgservice.c;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgList;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgListRepo;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.k;
import com.tencent.guild.aio.factory.business.holder.msglist.data.guild.GuildMsgListRepo;
import com.tencent.guild.aio.msglist.welcome.GuildDirectRobotWelcomeMsgItem;
import com.tencent.guild.api.channel.IGuildChannelApi;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.msg.service.ChannelAIOMsgService;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.guild.message.directmessage.model.data.DirectMessageNode;
import com.tencent.mobileqq.guild.message.directmessage.model.data.MessageSource;
import com.tencent.mobileqq.guild.message.directmessage.model.repositories.DirectMessageNodeRepository;
import com.tencent.mobileqq.guild.robot.api.IGuildRobotConfigApi;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqguild.directmessage.aio.graytips.local.robotblack.GuildBlackRobotGrayTipsMsgItem;
import com.tencent.qqguild.directmessage.aio.graytips.local.robotmsglimit.GuildRobotMsgLimitGrayTipsMsgItem;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.TextElement;
import com.tencent.qqnt.msg.api.IMsgUtilApi;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import tl.h;
import vh2.q;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001'B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u0017\u00a2\u0006\u0004\b%\u0010&J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0016\u0010\u0007\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0016\u0010\b\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0016\u0010\u000b\u001a\u00020\n2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u0002J\u0016\u0010\u000e\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\fH\u0002J\b\u0010\u000f\u001a\u00020\u0005H\u0016J\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010H\u0016J\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u0016J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014H\u0016R\u0017\u0010\u001c\u001a\u00020\u00178\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006("}, d2 = {"Lcom/tencent/qqguild/directmessage/aio/repository/RobotMsgListRepoDelegate;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/k;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/aio/data/msglist/a;", "list", "", HippyTKDListViewAdapter.X, "u", "w", "", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/aio/msgservice/h;", "rsp", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "c", "", "y", "displayList", "k", "", "source", "i", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/MsgListRepo;", "f", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/MsgListRepo;", "getHost", "()Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/MsgListRepo;", "host", "Laq0/a;", "g", "Laq0/a;", "combineMsgCenter", "Lcom/tencent/guild/aio/msglist/welcome/GuildDirectRobotWelcomeMsgItem;", h.F, "Lcom/tencent/guild/aio/msglist/welcome/GuildDirectRobotWelcomeMsgItem;", "robotWelcomeMsgItem", "<init>", "(Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/MsgListRepo;)V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class RobotMsgListRepoDelegate extends k {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MsgListRepo host;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final aq0.a combineMsgCenter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private GuildDirectRobotWelcomeMsgItem robotWelcomeMsgItem;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes22.dex */
    public static final class b<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((com.tencent.aio.data.msglist.a) t16).getMsgSeq()), Long.valueOf(((com.tencent.aio.data.msglist.a) t17).getMsgSeq()));
            return compareValues;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotMsgListRepoDelegate(@NotNull MsgListRepo host) {
        super(host);
        Intrinsics.checkNotNullParameter(host, "host");
        this.host = host;
        this.combineMsgCenter = new aq0.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A(com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a> rsp) {
        QLog.i("Guild.C2C.AIO.RobotMsgListRepoDelegate", 1, "handleFirstPage, succ = " + rsp.d() + ", data size = " + rsp.a().size());
        if (rsp.d() && (!rsp.a().isEmpty())) {
            MsgList M = this.host.M();
            M.clear();
            M.addAll(rsp.a());
            com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b bVar = com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.f110545a;
            bVar.p(this.host, IMsgListRepository.MsgListRepoOpType.LoadFirst, M, bVar.e("Guild.C2C.AIO.RobotMsgListRepoDelegate", "handleFirstPage"), bVar.b(false, false));
            long j3 = d().g().l().getLong("navigate_msg_seq", 0L);
            d().g().l().putLong("navigate_msg_seq", 0L);
            if (j3 != 0) {
                h(j3);
                return;
            }
            return;
        }
        x(this.host.M());
        com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b bVar2 = com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.f110545a;
        MsgListRepo msgListRepo = this.host;
        com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.o(bVar2, msgListRepo, IMsgListRepository.MsgListRepoOpType.LoadFirst, msgListRepo.M(), bVar2.e("Guild.C2C.AIO.RobotMsgListRepoDelegate", "handleFirstPage"), null, 16, null);
    }

    private final void u(CopyOnWriteArrayList<com.tencent.aio.data.msglist.a> list) {
        MessageSource messageSource;
        if (((IGuildChannelApi) QRoute.api(IGuildChannelApi.class)).isSelfGuest(d().g().r().c().j(), d().g().r().c().f())) {
            return;
        }
        int robotInitiativeMsgNum = ((IGuildRobotConfigApi) QRoute.api(IGuildRobotConfigApi.class)).getRobotInitiativeMsgNum(3);
        Iterator<com.tencent.aio.data.msglist.a> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.tencent.aio.data.msglist.a next = it.next();
            if (next instanceof GuildBlackRobotGrayTipsMsgItem) {
                list.remove(next);
                break;
            }
        }
        if (list.size() < robotInitiativeMsgNum) {
            return;
        }
        int size = list.size();
        int size2 = (list.size() - robotInitiativeMsgNum) + 1;
        if (size2 <= size) {
            while (true) {
                com.tencent.aio.data.msglist.a aVar = list.get(size - 1);
                if (!(aVar instanceof GuildMsgItem) || !com.tencent.guild.api.data.msglist.a.d((GuildMsgItem) aVar)) {
                    return;
                }
                if (size == size2) {
                    break;
                } else {
                    size--;
                }
            }
        }
        String j3 = d().g().r().c().j();
        String f16 = d().g().r().c().f();
        DirectMessageNode C = DirectMessageNodeRepository.C(j3);
        if (C != null) {
            messageSource = C.getSource();
        } else {
            messageSource = null;
        }
        if (messageSource != null) {
            String tinyId = messageSource.getTinyId();
            ArrayList<MsgElement> arrayList = new ArrayList<>();
            TextElement textElement = new TextElement();
            textElement.content = "";
            arrayList.add(((IMsgUtilApi) QRoute.api(IMsgUtilApi.class)).createTextElement(textElement));
            final GuildBlackRobotGrayTipsMsgItem guildBlackRobotGrayTipsMsgItem = new GuildBlackRobotGrayTipsMsgItem(((IMsgUtilApi) QRoute.api(IMsgUtilApi.class)).createMsgItem(arrayList, "", "", 54, 0, z(list), "", 0L, ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).generateMsgUniqueId()).a(), j3, f16, tinyId, d());
            ((IGPSService) ch.S0(IGPSService.class, "")).fetchDirectMsgBlack(tinyId, new q() { // from class: com.tencent.qqguild.directmessage.aio.repository.b
                @Override // vh2.q
                public final void onResult(int i3, String str, boolean z16) {
                    RobotMsgListRepoDelegate.v(GuildBlackRobotGrayTipsMsgItem.this, i3, str, z16);
                }
            });
            list.add(guildBlackRobotGrayTipsMsgItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(GuildBlackRobotGrayTipsMsgItem blackGrayTip, int i3, String str, boolean z16) {
        Intrinsics.checkNotNullParameter(blackGrayTip, "$blackGrayTip");
        blackGrayTip.setBlack(z16);
    }

    private final void w(CopyOnWriteArrayList<com.tencent.aio.data.msglist.a> list) {
        MessageSource messageSource;
        String str;
        if (((IGuildChannelApi) QRoute.api(IGuildChannelApi.class)).isSelfGuest(d().g().r().c().j(), d().g().r().c().f())) {
            return;
        }
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        Iterator<com.tencent.aio.data.msglist.a> it = list.iterator();
        while (it.hasNext()) {
            com.tencent.aio.data.msglist.a next = it.next();
            if (next instanceof GuildRobotMsgLimitGrayTipsMsgItem) {
                copyOnWriteArrayList.add(next);
            }
        }
        list.removeAll(copyOnWriteArrayList);
        Iterator<com.tencent.aio.data.msglist.a> it5 = list.iterator();
        while (it5.hasNext()) {
            com.tencent.aio.data.msglist.a next2 = it5.next();
            if ((next2 instanceof GuildMsgItem) && com.tencent.guild.api.data.msglist.a.e((GuildMsgItem) next2)) {
                String j3 = d().g().r().c().j();
                String f16 = d().g().r().c().f();
                DirectMessageNode C = DirectMessageNodeRepository.C(j3);
                if (C != null) {
                    messageSource = C.getSource();
                } else {
                    messageSource = null;
                }
                if (messageSource != null) {
                    String tinyId = messageSource.getTinyId();
                    String nickName = messageSource.getNickName();
                    if (TextUtils.isEmpty(nickName)) {
                        str = messageSource.getRemarkName();
                    } else {
                        str = nickName;
                    }
                    ArrayList<MsgElement> arrayList = new ArrayList<>();
                    TextElement textElement = new TextElement();
                    textElement.content = "";
                    arrayList.add(((IMsgUtilApi) QRoute.api(IMsgUtilApi.class)).createTextElement(textElement));
                    list.add(new GuildRobotMsgLimitGrayTipsMsgItem(((IMsgUtilApi) QRoute.api(IMsgUtilApi.class)).createMsgItem(arrayList, "", "", 54, 0, z(list), "", 0L, ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).generateMsgUniqueId()).a(), f16, tinyId, str, d()));
                    return;
                }
                return;
            }
        }
    }

    private final void x(CopyOnWriteArrayList<com.tencent.aio.data.msglist.a> list) {
        MessageSource messageSource;
        String str;
        Object first;
        Object first2;
        if (((IGuildChannelApi) QRoute.api(IGuildChannelApi.class)).isSelfGuest(d().g().r().c().j(), d().g().r().c().f())) {
            return;
        }
        String j3 = d().g().r().c().j();
        String f16 = d().g().r().c().f();
        DirectMessageNode C = DirectMessageNodeRepository.C(j3);
        GuildDirectRobotWelcomeMsgItem guildDirectRobotWelcomeMsgItem = null;
        if (C != null) {
            messageSource = C.getSource();
        } else {
            messageSource = null;
        }
        if (messageSource != null) {
            String tinyId = messageSource.getTinyId();
            String nickName = messageSource.getNickName();
            if (TextUtils.isEmpty(nickName)) {
                str = messageSource.getRemarkName();
            } else {
                str = nickName;
            }
            this.robotWelcomeMsgItem = new GuildDirectRobotWelcomeMsgItem(new MsgRecord(), j3, f16, str, tinyId, d());
            if (!list.isEmpty()) {
                first = CollectionsKt___CollectionsKt.first((List<? extends Object>) list);
                if (!(first instanceof GuildDirectRobotWelcomeMsgItem)) {
                    first2 = CollectionsKt___CollectionsKt.first((List<? extends Object>) list);
                    if (((com.tencent.aio.data.msglist.a) first2).getMsgSeq() == 1) {
                        GuildDirectRobotWelcomeMsgItem guildDirectRobotWelcomeMsgItem2 = this.robotWelcomeMsgItem;
                        if (guildDirectRobotWelcomeMsgItem2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("robotWelcomeMsgItem");
                        } else {
                            guildDirectRobotWelcomeMsgItem = guildDirectRobotWelcomeMsgItem2;
                        }
                        list.add(0, guildDirectRobotWelcomeMsgItem);
                        return;
                    }
                    return;
                }
                return;
            }
            GuildDirectRobotWelcomeMsgItem guildDirectRobotWelcomeMsgItem3 = this.robotWelcomeMsgItem;
            if (guildDirectRobotWelcomeMsgItem3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("robotWelcomeMsgItem");
            } else {
                guildDirectRobotWelcomeMsgItem = guildDirectRobotWelcomeMsgItem3;
            }
            list.add(guildDirectRobotWelcomeMsgItem);
        }
    }

    private final long z(List<? extends com.tencent.aio.data.msglist.a> list) {
        int size = list.size();
        if (size == 0) {
            return 0L;
        }
        return list.get(size - 1).getMsgSeq();
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.k, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository
    public void i(@NotNull String source) {
        Intrinsics.checkNotNullParameter(source, "source");
        QLog.i("Guild.C2C.AIO.RobotMsgListRepoDelegate", 1, "loadFirstPage");
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(ChannelAIOMsgService.f112613a.j(new c(d().g().r(), 15)), new RobotMsgListRepoDelegate$loadFirstPage$1(this, null)), zs.b.a(Dispatchers.INSTANCE)), r());
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.k, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository
    @NotNull
    public List<com.tencent.aio.data.msglist.a> k(@NotNull List<? extends com.tencent.aio.data.msglist.a> displayList) {
        List sortedWith;
        boolean z16;
        Intrinsics.checkNotNullParameter(displayList, "displayList");
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : displayList) {
            if (hashSet.add(Long.valueOf(((com.tencent.aio.data.msglist.a) obj).getMsgId()))) {
                arrayList.add(obj);
            }
        }
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(arrayList, new b());
        CopyOnWriteArrayList<com.tencent.aio.data.msglist.a> copyOnWriteArrayList = new CopyOnWriteArrayList<>(sortedWith);
        this.combineMsgCenter.g(copyOnWriteArrayList);
        u(copyOnWriteArrayList);
        w(copyOnWriteArrayList);
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : copyOnWriteArrayList) {
            com.tencent.aio.data.msglist.a msg2 = (com.tencent.aio.data.msglist.a) obj2;
            MsgListRepo msgListRepo = this.host;
            Intrinsics.checkNotNull(msgListRepo, "null cannot be cast to non-null type com.tencent.guild.aio.factory.business.holder.msglist.data.guild.GuildMsgListRepo");
            Intrinsics.checkNotNullExpressionValue(msg2, "msg");
            ((GuildMsgListRepo) msgListRepo).k1(msg2);
            if ((msg2 instanceof GuildMsgItem) && ((GuildMsgItem) msg2).getMsgRecord().msgType != 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                Logger.f235387a.d().i("Guild.C2C.AIO.RobotMsgListRepoDelegate", 1, "beforeMsgToScreen, filter msg class = " + msg2.getClass() + ", seq = " + msg2.getMsgSeq());
            }
            if (z16) {
                arrayList2.add(obj2);
            }
        }
        return arrayList2;
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.k, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository
    @NotNull
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public List<com.tencent.aio.data.msglist.a> b(@NotNull Collection<? extends com.tencent.aio.data.msglist.a> list) {
        Object firstOrNull;
        boolean z16;
        Intrinsics.checkNotNullParameter(list, "list");
        CopyOnWriteArrayList<com.tencent.aio.data.msglist.a> copyOnWriteArrayList = new CopyOnWriteArrayList<>(list);
        x(copyOnWriteArrayList);
        com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.a E = this.host.E();
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull(list);
        E.f((com.tencent.aio.data.msglist.a) firstOrNull);
        ArrayList arrayList = new ArrayList();
        for (Object obj : copyOnWriteArrayList) {
            com.tencent.aio.data.msglist.a msg2 = (com.tencent.aio.data.msglist.a) obj;
            MsgListRepo msgListRepo = this.host;
            Intrinsics.checkNotNull(msgListRepo, "null cannot be cast to non-null type com.tencent.guild.aio.factory.business.holder.msglist.data.guild.GuildMsgListRepo");
            Intrinsics.checkNotNullExpressionValue(msg2, "msg");
            ((GuildMsgListRepo) msgListRepo).k1(msg2);
            if ((msg2 instanceof GuildMsgItem) && ((GuildMsgItem) msg2).getMsgRecord().msgType != 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                Logger.f235387a.d().i("Guild.C2C.AIO.RobotMsgListRepoDelegate", 1, "beforeMsgAddToMemory, filter msg class = " + msg2.getClass() + ", seq = " + msg2.getMsgSeq());
            } else {
                GuildMsgItem guildMsgItem = (GuildMsgItem) msg2;
                if (com.tencent.guild.api.data.msglist.a.c(guildMsgItem)) {
                    com.tencent.guild.api.data.msglist.a.g(guildMsgItem);
                }
            }
            if (z16) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.f
    public void c() {
    }
}
