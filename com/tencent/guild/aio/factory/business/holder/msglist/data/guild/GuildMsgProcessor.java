package com.tencent.guild.aio.factory.business.holder.msglist.data.guild;

import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListIntent;
import com.tencent.guild.aio.factory.business.holder.msglist.i;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\b\u0018\u0000 \u00052\u00020\u0001:\u0003\u0014\u001c\"B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0013\u00a2\u0006\u0004\b!\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\u0014\u0010\r\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u0014\u0010\u000e\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000bJ\u0006\u0010\u0011\u001a\u00020\u0004J\u0006\u0010\u0012\u001a\u00020\u0004R\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/data/guild/GuildMsgProcessor;", "", "Lcom/tencent/guild/aio/factory/business/holder/msglist/data/guild/GuildMsgProcessor$b;", "msgInfo", "", "d", "f", "e", "", "g", "", "Lcom/tencent/aio/data/msglist/a;", TabPreloadItem.TAB_NAME_MESSAGE, "l", "k", "msg", tl.h.F, "j", "i", "Lcom/tencent/guild/aio/factory/business/holder/msglist/data/guild/GuildMsgListRepo;", "a", "Lcom/tencent/guild/aio/factory/business/holder/msglist/data/guild/GuildMsgListRepo;", "c", "()Lcom/tencent/guild/aio/factory/business/holder/msglist/data/guild/GuildMsgListRepo;", "setMsgRepo", "(Lcom/tencent/guild/aio/factory/business/holder/msglist/data/guild/GuildMsgListRepo;)V", "msgRepo", "", "b", "Ljava/util/List;", "holdMsgListCache", "Z", "forceNotHoldMsg", "<init>", "HoldMsgType", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildMsgProcessor {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private GuildMsgListRepo msgRepo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<HoldMsgInfo> holdMsgListCache;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean forceNotHoldMsg;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/data/guild/GuildMsgProcessor$HoldMsgType;", "", "(Ljava/lang/String;I)V", "ReceiveMsgType", "UpdateMsgType", "SendMsgType", "aio-guild_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public enum HoldMsgType {
        ReceiveMsgType,
        UpdateMsgType,
        SendMsgType
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR(\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0013\u001a\u0004\b\n\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/data/guild/GuildMsgProcessor$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/guild/aio/factory/business/holder/msglist/data/guild/GuildMsgProcessor$HoldMsgType;", "a", "Lcom/tencent/guild/aio/factory/business/holder/msglist/data/guild/GuildMsgProcessor$HoldMsgType;", "b", "()Lcom/tencent/guild/aio/factory/business/holder/msglist/data/guild/GuildMsgProcessor$HoldMsgType;", "setMsgType", "(Lcom/tencent/guild/aio/factory/business/holder/msglist/data/guild/GuildMsgProcessor$HoldMsgType;)V", QQBrowserActivity.KEY_MSG_TYPE, "", "Lcom/tencent/aio/data/msglist/a;", "Ljava/util/List;", "()Ljava/util/List;", "setMsgList", "(Ljava/util/List;)V", TabPreloadItem.TAB_NAME_MESSAGE, "<init>", "(Lcom/tencent/guild/aio/factory/business/holder/msglist/data/guild/GuildMsgProcessor$HoldMsgType;Ljava/util/List;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.guild.aio.factory.business.holder.msglist.data.guild.GuildMsgProcessor$b, reason: from toString */
    /* loaded from: classes6.dex */
    public static final /* data */ class HoldMsgInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private HoldMsgType msgType;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private List<? extends com.tencent.aio.data.msglist.a> msgList;

        public HoldMsgInfo(@NotNull HoldMsgType msgType, @NotNull List<? extends com.tencent.aio.data.msglist.a> msgList) {
            Intrinsics.checkNotNullParameter(msgType, "msgType");
            Intrinsics.checkNotNullParameter(msgList, "msgList");
            this.msgType = msgType;
            this.msgList = msgList;
        }

        @NotNull
        public final List<com.tencent.aio.data.msglist.a> a() {
            return this.msgList;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final HoldMsgType getMsgType() {
            return this.msgType;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof HoldMsgInfo)) {
                return false;
            }
            HoldMsgInfo holdMsgInfo = (HoldMsgInfo) other;
            if (this.msgType == holdMsgInfo.msgType && Intrinsics.areEqual(this.msgList, holdMsgInfo.msgList)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.msgType.hashCode() * 31) + this.msgList.hashCode();
        }

        @NotNull
        public String toString() {
            return "HoldMsgInfo(msgType=" + this.msgType + ", msgList size:" + this.msgList.size() + " hash:" + this.msgList.hashCode() + ")";
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f110521a;

        static {
            int[] iArr = new int[HoldMsgType.values().length];
            try {
                iArr[HoldMsgType.ReceiveMsgType.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[HoldMsgType.UpdateMsgType.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[HoldMsgType.SendMsgType.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f110521a = iArr;
        }
    }

    public GuildMsgProcessor(@NotNull GuildMsgListRepo msgRepo) {
        Intrinsics.checkNotNullParameter(msgRepo, "msgRepo");
        this.msgRepo = msgRepo;
        this.holdMsgListCache = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(HoldMsgInfo msgInfo) {
        Object firstOrNull;
        if (g()) {
            f(msgInfo);
            return;
        }
        this.forceNotHoldMsg = true;
        int i3 = c.f110521a[msgInfo.getMsgType().ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    GuildMsgListRepo guildMsgListRepo = this.msgRepo;
                    firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) msgInfo.a());
                    guildMsgListRepo.Y0((com.tencent.aio.data.msglist.a) firstOrNull);
                    return;
                }
                return;
            }
            this.msgRepo.a1(msgInfo.a());
            return;
        }
        if (this.msgRepo.N0()) {
            QLog.i("GuildMsgListRepo", 1, "onMsgReceive, delay handleMsg: " + msgInfo);
            BuildersKt__Builders_commonKt.launch$default(this.msgRepo.z0(), Dispatchers.getMain(), null, new GuildMsgProcessor$handleMsg$1(msgInfo, this, null), 2, null);
            return;
        }
        this.msgRepo.c1(msgInfo.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e() {
        this.forceNotHoldMsg = true;
        if (!this.holdMsgListCache.isEmpty()) {
            QLog.i("GuildMsgListRepo", 1, "handleMsgListCache size:" + this.holdMsgListCache.size());
            Iterator<HoldMsgInfo> it = this.holdMsgListCache.iterator();
            while (it.hasNext()) {
                d(it.next());
            }
            this.holdMsgListCache.clear();
        }
    }

    private final void f(HoldMsgInfo msgInfo) {
        QLog.i("GuildMsgListRepo", 1, "holdMsg: " + msgInfo);
        this.holdMsgListCache.add(msgInfo);
        if (this.holdMsgListCache.size() == 1) {
            BuildersKt__Builders_commonKt.launch$default(this.msgRepo.z0(), Dispatchers.getMain(), null, new GuildMsgProcessor$holdMsg$1(this, null), 2, null);
        }
    }

    private final boolean g() {
        i.e eVar;
        boolean z16;
        if (this.forceNotHoldMsg || !Intrinsics.areEqual(this.msgRepo.y0().g().n(), com.tencent.guild.aio.factory.a.class.getName())) {
            return false;
        }
        if (!this.holdMsgListCache.isEmpty()) {
            return true;
        }
        com.tencent.mvi.base.route.k k3 = this.msgRepo.y0().e().k(GuildMsgListIntent.GetLoadFirstPageFin.f110413d);
        if (k3 instanceof i.e) {
            eVar = (i.e) k3;
        } else {
            eVar = null;
        }
        if (eVar != null) {
            z16 = eVar.getResult();
        } else {
            z16 = true;
        }
        return !z16;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final GuildMsgListRepo getMsgRepo() {
        return this.msgRepo;
    }

    public final void h(@NotNull com.tencent.aio.data.msglist.a msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        BuildersKt__Builders_commonKt.launch$default(this.msgRepo.z0(), Dispatchers.getMain(), null, new GuildMsgProcessor$onAddLocalSendMsg$1(this, msg2, null), 2, null);
    }

    public final void i() {
        this.holdMsgListCache.clear();
        this.forceNotHoldMsg = true;
    }

    public final void j() {
        QLog.i("GuildMsgListRepo", 1, "onLoadFirstPageFin");
        BuildersKt__Builders_commonKt.launch$default(this.msgRepo.z0(), Dispatchers.getMain(), null, new GuildMsgProcessor$onLoadFirstPageFin$1(this, null), 2, null);
    }

    public final void k(@NotNull List<? extends com.tencent.aio.data.msglist.a> msgList) {
        Intrinsics.checkNotNullParameter(msgList, "msgList");
        BuildersKt__Builders_commonKt.launch$default(this.msgRepo.z0(), Dispatchers.getMain(), null, new GuildMsgProcessor$onMsgInfoListStatusUpdate$1(this, msgList, null), 2, null);
    }

    public final void l(@NotNull List<? extends com.tencent.aio.data.msglist.a> msgList) {
        Intrinsics.checkNotNullParameter(msgList, "msgList");
        BuildersKt__Builders_commonKt.launch$default(this.msgRepo.z0(), Dispatchers.getMain(), null, new GuildMsgProcessor$onMsgReceive$1(this, msgList, null), 2, null);
    }
}
