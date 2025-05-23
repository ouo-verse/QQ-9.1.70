package com.tencent.guildlive.aio.excellentdetail.msglist;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.base.mvi.part.MsgListUiState;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.intent.MsgListIntent;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.intent.a;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.AppInterface;
import com.tencent.guild.aio.chosen.data.GuildChosenMsgListDataManager;
import com.tencent.guild.aio.chosen.msglist.GuildChosenMsgInputHeightChange;
import com.tencent.guild.aio.chosen.msglist.GuildChosenMsgIntent;
import com.tencent.guild.aio.chosen.msglist.a;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListDataState;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListIntent;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListViewState;
import com.tencent.guild.aio.factory.business.holder.msglist.a;
import com.tencent.guild.aio.util.ex.FromScene;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.msg.service.ChannelAIOMsgService;
import com.tencent.guild.api.msg.service.l;
import com.tencent.guildlive.aio.excellentdetail.GuildLiveAnnounceMsgIntent;
import com.tencent.guildlive.aio.halfpop.menu.GuildLiveSetAnnounceActionItem;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProTopMsg;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.xweb.FileReaderHelper;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.aspectj.lang.JoinPoint;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 M2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u0005:\u0001NB\u0007\u00a2\u0006\u0004\bK\u0010LJ\b\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0002J\b\u0010\r\u001a\u00020\u0006H\u0002J\u0016\u0010\u0011\u001a\u00020\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J\u0016\u0010\u0012\u001a\u00020\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u001e\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00162\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0002J\u001c\u0010\u001e\u001a\u00020\u00062\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u001d\u001a\u00020\u001cH\u0002J\b\u0010\u001f\u001a\u00020\u0006H\u0002J\u0010\u0010!\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\bH\u0002J\b\u0010\"\u001a\u00020\u0006H\u0007J\u0010\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#0\u000eH\u0016J\u0010\u0010'\u001a\u00020\u00062\u0006\u0010&\u001a\u00020%H\u0016J\u0010\u0010(\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u0002H\u0016J\u000e\u0010*\u001a\u00020\u00062\u0006\u0010&\u001a\u00020)J\u0010\u0010-\u001a\u00020\u00062\u0006\u0010,\u001a\u00020+H\u0016J\b\u0010.\u001a\u00020\u0006H\u0016J\u001c\u00103\u001a\u00020\u00062\b\u00100\u001a\u0004\u0018\u00010/2\b\u00102\u001a\u0004\u0018\u000101H\u0016R\u0014\u00107\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106R\u001c\u0010;\u001a\b\u0012\u0004\u0012\u00020\u000f088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010>\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010?\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010=R\u001a\u0010@\u001a\b\u0012\u0004\u0012\u00020\u0016088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010:R\u001b\u0010F\u001a\u00020A8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010ER\u0014\u0010J\u001a\u00020G8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bH\u0010I\u00a8\u0006O"}, d2 = {"Lcom/tencent/guildlive/aio/excellentdetail/msglist/GuildLiveExcellentMsgListDataVM;", "Lpn0/a;", "Lat/b;", "Lcom/tencent/aio/base/mvi/part/MsgListUiState;", "Ljava/util/Observer;", "Landroidx/lifecycle/LifecycleObserver;", "", "w", "", HippyTKDListViewAdapter.SCROLL_STATE, "firstPosition", "lastPosition", "u", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "Lcom/tencent/aio/data/msglist/a;", TabPreloadItem.TAB_NAME_MESSAGE, "y", "B", "Lcom/tencent/guild/aio/chosen/data/GuildChosenMsgListDataManager$c;", "notifyData", HippyTKDListViewAdapter.X, "", "focusIndex", "Lcom/tencent/aio/msgservice/h;", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "rsp", "r", "", FileReaderHelper.OPEN_FILE_FROM_FORCE, BdhLogUtil.LogTag.Tag_Conn, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "height", ReportConstant.COSTREPORT_PREFIX, "onResume", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "j", "t", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/intent/MsgListIntent$a;", "v", "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Ljava/util/Observable;", "o", "", "data", "update", "Ljava/lang/Object;", "f", "Ljava/lang/Object;", JoinPoint.SYNCHRONIZATION_LOCK, "Ljava/util/concurrent/CopyOnWriteArrayList;", h.F, "Ljava/util/concurrent/CopyOnWriteArrayList;", "displayList", "i", "Lcom/tencent/aio/data/msglist/a;", "firstAIOMsg", "lastAIOMsg", "visibleIds", "Las0/a;", "D", "Lkotlin/Lazy;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Las0/a;", "articleMsgDataManager", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "E", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "mGPServiceObserver", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildLiveExcellentMsgListDataVM extends pn0.a<at.b, MsgListUiState> implements Observer, LifecycleObserver {

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Lazy articleMsgDataManager;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final GPServiceObserver mGPServiceObserver;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.aio.data.msglist.a firstAIOMsg;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.aio.data.msglist.a lastAIOMsg;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Object lock = new Object();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private CopyOnWriteArrayList<com.tencent.aio.data.msglist.a> displayList = new CopyOnWriteArrayList<>();

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final CopyOnWriteArrayList<Long> visibleIds = new CopyOnWriteArrayList<>();

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f112692a;

        static {
            int[] iArr = new int[GuildChosenMsgListDataManager.RefreshType.values().length];
            try {
                iArr[GuildChosenMsgListDataManager.RefreshType.REFRESH_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[GuildChosenMsgListDataManager.RefreshType.REFRESH_JUMP_BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f112692a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J<\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0014\u00a8\u0006\f"}, d2 = {"com/tencent/guildlive/aio/excellentdetail/msglist/GuildLiveExcellentMsgListDataVM$c", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "guildId", "channelId", "fromTinyId", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProTopMsg;", "topMsgList", "oldMsgList", "", "onChannelTopMsgUpdated", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class c extends GPServiceObserver {
        c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onChannelTopMsgUpdated(@NotNull String guildId, @NotNull String channelId, @NotNull String fromTinyId, @NotNull ArrayList<IGProTopMsg> topMsgList, @NotNull ArrayList<IGProTopMsg> oldMsgList) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            Intrinsics.checkNotNullParameter(fromTinyId, "fromTinyId");
            Intrinsics.checkNotNullParameter(topMsgList, "topMsgList");
            Intrinsics.checkNotNullParameter(oldMsgList, "oldMsgList");
            if (TextUtils.equals(guildId, ((com.tencent.aio.api.runtime.a) GuildLiveExcellentMsgListDataVM.this.getMContext()).g().r().c().f()) && TextUtils.equals(channelId, ((com.tencent.aio.api.runtime.a) GuildLiveExcellentMsgListDataVM.this.getMContext()).g().r().c().j())) {
                GuildLiveExcellentMsgListDataVM.this.q().k(GuildChosenMsgListDataManager.RefreshType.REFRESH_NONE);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"T", "kotlin.jvm.PlatformType", "a", "b", "", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class d<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((com.tencent.aio.data.msglist.a) t16).getMsgSeq()), Long.valueOf(((com.tencent.aio.data.msglist.a) t17).getMsgSeq()));
            return compareValues;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"T", "kotlin.jvm.PlatformType", "a", "b", "", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class e<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((com.tencent.aio.data.msglist.a) t16).getMsgSeq()), Long.valueOf(((com.tencent.aio.data.msglist.a) t17).getMsgSeq()));
            return compareValues;
        }
    }

    public GuildLiveExcellentMsgListDataVM() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<as0.a>() { // from class: com.tencent.guildlive.aio.excellentdetail.msglist.GuildLiveExcellentMsgListDataVM$articleMsgDataManager$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final as0.a invoke() {
                Contact contact = new Contact();
                GuildLiveExcellentMsgListDataVM guildLiveExcellentMsgListDataVM = GuildLiveExcellentMsgListDataVM.this;
                contact.chatType = ((com.tencent.aio.api.runtime.a) guildLiveExcellentMsgListDataVM.getMContext()).g().r().c().e();
                contact.guildId = ((com.tencent.aio.api.runtime.a) guildLiveExcellentMsgListDataVM.getMContext()).g().r().c().f();
                contact.peerUid = ((com.tencent.aio.api.runtime.a) guildLiveExcellentMsgListDataVM.getMContext()).g().r().c().j();
                as0.a aVar = new as0.a(contact);
                aVar.k(GuildChosenMsgListDataManager.RefreshType.REFRESH_NONE);
                return aVar;
            }
        });
        this.articleMsgDataManager = lazy;
        this.mGPServiceObserver = new c();
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0022, code lost:
    
        if (r0 > ((com.tencent.aio.data.msglist.a) r2).getMsgSeq()) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void A() {
        Object first;
        Object last;
        Object last2;
        Object first2;
        if (this.displayList.isEmpty()) {
            return;
        }
        com.tencent.aio.data.msglist.a aVar = this.firstAIOMsg;
        if (aVar != null) {
            Intrinsics.checkNotNull(aVar);
            long msgSeq = aVar.getMsgSeq();
            first2 = CollectionsKt___CollectionsKt.first((List<? extends Object>) this.displayList);
        }
        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) this.displayList);
        this.firstAIOMsg = (com.tencent.aio.data.msglist.a) first;
        com.tencent.aio.data.msglist.a aVar2 = this.lastAIOMsg;
        if (aVar2 != null) {
            Intrinsics.checkNotNull(aVar2);
            long msgSeq2 = aVar2.getMsgSeq();
            last2 = CollectionsKt___CollectionsKt.last((List<? extends Object>) this.displayList);
            if (msgSeq2 >= ((com.tencent.aio.data.msglist.a) last2).getMsgSeq()) {
                return;
            }
        }
        last = CollectionsKt___CollectionsKt.last((List<? extends Object>) this.displayList);
        this.lastAIOMsg = (com.tencent.aio.data.msglist.a) last;
    }

    private final void B(List<? extends com.tencent.aio.data.msglist.a> msgList) {
        if (this.displayList.isEmpty()) {
            return;
        }
        for (com.tencent.aio.data.msglist.a aVar : msgList) {
            int size = this.displayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (aVar.getMsgId() == this.displayList.get(i3).getMsgId() && aVar.getViewType() != 50) {
                    this.displayList.set(i3, aVar);
                }
            }
        }
        CopyOnWriteArrayList<com.tencent.aio.data.msglist.a> copyOnWriteArrayList = this.displayList;
        if (copyOnWriteArrayList.size() > 1) {
            if (Build.VERSION.SDK_INT >= 24) {
                if (copyOnWriteArrayList.size() > 1) {
                    CollectionsKt__MutableCollectionsJVMKt.sortWith(copyOnWriteArrayList, new d());
                }
            } else {
                ArrayList arrayList = new ArrayList(copyOnWriteArrayList);
                if (arrayList.size() > 1) {
                    CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList, new e());
                }
                copyOnWriteArrayList.clear();
                copyOnWriteArrayList.addAll(arrayList);
            }
        }
    }

    private final void C(long focusIndex, boolean force) {
        A();
        Bundle bundle = null;
        if (focusIndex == -1) {
            bundle = com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.c(com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.f110545a, false, false, 2, null);
        }
        updateUI(new GuildMsgListDataState(this.displayList, force, null, 3, bundle));
    }

    static /* synthetic */ void D(GuildLiveExcellentMsgListDataVM guildLiveExcellentMsgListDataVM, long j3, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = -3;
        }
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        guildLiveExcellentMsgListDataVM.C(j3, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final as0.a q() {
        return (as0.a) this.articleMsgDataManager.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void r(long focusIndex, com.tencent.aio.msgservice.h<GuildMsgItem> rsp) {
        boolean z16;
        synchronized (this.lock) {
            if (rsp.d()) {
                this.displayList.clear();
                CopyOnWriteArrayList<com.tencent.aio.data.msglist.a> copyOnWriteArrayList = this.displayList;
                List<GuildMsgItem> a16 = rsp.a();
                ArrayList arrayList = new ArrayList();
                for (Object obj : a16) {
                    if (((GuildMsgItem) obj).getMsgRecord().msgSeq >= yr0.a.a((com.tencent.aio.api.runtime.a) getMContext())) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        arrayList.add(obj);
                    }
                }
                copyOnWriteArrayList.addAll(arrayList);
                this.visibleIds.clear();
                Iterator<com.tencent.aio.data.msglist.a> it = this.displayList.iterator();
                while (it.hasNext()) {
                    this.visibleIds.add(Long.valueOf(it.next().getMsgId()));
                }
                D(this, focusIndex, false, 2, null);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void s(int height) {
        updateUI(new GuildMsgListViewState.GuildInputBarHeightChangeDataState(height));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void u(int scrollState, int firstPosition, int lastPosition) {
        if (scrollState == 0) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildMsgListIntent.ExposureVisibleMsgListEvent(firstPosition, lastPosition, new CopyOnWriteArrayList(this.displayList)));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void w() {
        Object firstOrNull;
        ArrayList arrayListOf;
        if (yr0.a.e((com.tencent.aio.api.runtime.a) getMContext())) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) this.displayList);
            com.tencent.aio.data.msglist.a aVar = (com.tencent.aio.data.msglist.a) firstOrNull;
            if (aVar == null) {
                return;
            }
            co0.b bVar = co0.b.f31162a;
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(GuildLiveSetAnnounceActionItem.class);
            ps0.a.b(new ps0.a(), (com.tencent.aio.api.runtime.a) getMContext(), co0.b.b(bVar, arrayListOf, aVar, (com.tencent.aio.api.runtime.a) getMContext(), false, 8, null), null, 4, null);
            return;
        }
        QLog.i("GuildChosenMsgListDataVM", 1, "handleShowRemoveFirstAnnounceMenu, have not permissions.");
    }

    private final void x(GuildChosenMsgListDataManager.c notifyData) {
        int i3;
        long j3;
        GuildChosenMsgListDataManager.RefreshType c16 = notifyData.c();
        if (c16 == null) {
            i3 = -1;
        } else {
            i3 = b.f112692a[c16.ordinal()];
        }
        if (i3 != 1) {
            if (i3 == 2) {
                j3 = -1;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else {
            j3 = -3;
        }
        boolean a16 = notifyData.a();
        String str = "result:" + notifyData.a();
        l lVar = l.f112634a;
        List<MsgRecord> b16 = notifyData.b();
        Intrinsics.checkNotNullExpressionValue(b16, "notifyData.msgRecordList");
        r(j3, new com.tencent.aio.msgservice.h<>(a16, 0, str, lVar.g(b16)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0054, code lost:
    
        if (r4.getMsgRecord().msgSeq >= yr0.a.a((com.tencent.aio.api.runtime.a) getMContext())) goto L13;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void y(List<? extends com.tencent.aio.data.msglist.a> msgList) {
        String j3 = ((com.tencent.aio.api.runtime.a) getMContext()).g().r().c().j();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = msgList.iterator();
        while (true) {
            boolean z16 = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            com.tencent.aio.data.msglist.a aVar = (com.tencent.aio.data.msglist.a) next;
            if (aVar instanceof GuildMsgItem) {
                GuildMsgItem guildMsgItem = (GuildMsgItem) aVar;
                if (TextUtils.equals(guildMsgItem.getMsgRecord().peerUid, j3)) {
                }
            }
            z16 = false;
            if (z16) {
                arrayList.add(next);
            }
        }
        if (!(!arrayList.isEmpty())) {
            arrayList = null;
        }
        if (arrayList != null) {
            synchronized (this.lock) {
                B(arrayList);
                D(this, 0L, false, 3, null);
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    private final void z() {
        FlowKt.launchIn(FlowKt.flowOn(FlowKt.onEach(ChannelAIOMsgService.f112613a.x(), new GuildLiveExcellentMsgListDataVM$registerMsgNotification$1(this, null)), Dispatchers.getIO()), vmScope());
    }

    @Override // pn0.a
    public void j(@NotNull MsgIntent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof GuildMsgListIntent.GuildMultiSelectModeChangeEvent) {
            C(-3L, true);
        } else if (intent instanceof GuildChosenMsgInputHeightChange) {
            s(((GuildChosenMsgInputHeightChange) intent).getHeight());
        } else if (intent instanceof GuildLiveAnnounceMsgIntent.ShowRemoveFirstAnnounceMenu) {
            w();
        }
    }

    @Override // pn0.a
    @NotNull
    public List<String> m() {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildMultiSelectModeChangeEvent.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(GuildChosenMsgInputHeightChange.class).getQualifiedName(), Reflection.getOrCreateKotlinClass(GuildLiveAnnounceMsgIntent.ShowRemoveFirstAnnounceMenu.class).getQualifiedName()});
        return listOf;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // pn0.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        AppInterface appInterface;
        super.onDestroy();
        q().g();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRuntimeService iRuntimeService = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService != null) {
            iGPSService.deleteObserver(this.mGPServiceObserver);
        }
        q().i(this);
        ((com.tencent.aio.api.runtime.a) getMContext()).d().getLifecycle().removeObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        QLog.i("GuildChosenMsgListDataVM", 1, "[onResume]");
        AbstractGifImage.resumeAll();
        ApngImage.resumeAll();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull at.b intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof MsgListIntent.a) {
            v((MsgListIntent.a) intent);
            return;
        }
        if (intent instanceof a.g) {
            a.g gVar = (a.g) intent;
            u(gVar.getCom.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter.SCROLL_STATE java.lang.String(), gVar.getFirstPosition(), gVar.getLastPosition());
        } else if (intent instanceof com.tencent.guildlive.aio.excellentdetail.msglist.b) {
            ((com.tencent.guildlive.aio.excellentdetail.msglist.b) intent).b(yr0.a.e((com.tencent.aio.api.runtime.a) getMContext()));
        } else if (intent instanceof a.d) {
            z();
        } else if (intent instanceof a.C1178a) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildChosenMsgIntent.ChosenMsgSizeChange(((a.C1178a) intent).getSize()));
        }
    }

    @Override // java.util.Observer
    public void update(@Nullable Observable o16, @Nullable Object data) {
        if (data instanceof GuildChosenMsgListDataManager.c) {
            x((GuildChosenMsgListDataManager.c) data);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void v(@NotNull MsgListIntent.a intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent.e() == 0) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildMsgListIntent.ExposureVisibleMsgListEvent(intent.a(), intent.c(), new CopyOnWriteArrayList(this.displayList)));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // pn0.a, com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        com.tencent.guild.aio.util.ex.a.m((com.tencent.aio.api.runtime.a) getMContext(), FromScene.CHOSEN.ordinal());
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        IGPSService iGPSService = (IGPSService) (appInterface != null ? appInterface.getRuntimeService(IGPSService.class, "") : null);
        if (iGPSService != null) {
            iGPSService.addObserver(this.mGPServiceObserver);
        }
        q().f(this);
        ((com.tencent.aio.api.runtime.a) getMContext()).d().getLifecycle().addObserver(this);
    }
}
