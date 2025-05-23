package com.tencent.guild.aio.factory.business.holder.msglist.data.guild;

import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgList;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.MsgListRepo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.AppInterface;
import com.tencent.guild.aio.factory.b;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListIntent;
import com.tencent.guild.aio.factory.business.holder.msglist.data.guild.GuildMsgRepoDelegate;
import com.tencent.guild.aio.factory.business.holder.msglist.i;
import com.tencent.guild.aio.msglist.welcome.GuildWelcomeMsgItem;
import com.tencent.guild.api.channel.IGuildChannelApi;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.msg.service.ChannelAIOMsgService;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.mainframe.centerpanel.MFGestureListIntent;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qqguildsdk.tianjige.GuildHistogramScene;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import zs.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00e3\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\t*\u0003mqu\b\u0016\u0018\u0000 {2\u00020\u0001:\u0001|B\u000f\u0012\u0006\u0010K\u001a\u00020F\u00a2\u0006\u0004\by\u0010zJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\u000b\u001a\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0016\u0010\f\u001a\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0016\u0010\u0010\u001a\u00020\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\rH\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0002J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u0018\u001a\u00020\u0004H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001b\u001a\u00020\u0004H\u0002J\u0016\u0010\u001e\u001a\u00020\u00042\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\t0\u001cH\u0002J\u0016\u0010\u001f\u001a\u00020\u00192\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\t0\u001cH\u0002J'\u0010!\u001a\u00020\u00042\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\t0\u001c2\b\u0010 \u001a\u0004\u0018\u00010\u0019H\u0002\u00a2\u0006\u0004\b!\u0010\"J\b\u0010#\u001a\u00020\u0019H\u0002J\b\u0010$\u001a\u00020\u0019H\u0002J\u0016\u0010%\u001a\u00020\u00042\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\t0\u001cH\u0002J\u0016\u0010&\u001a\u00020\u00042\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\t0\u001cH\u0002J\u001e\u0010)\u001a\u00020\u00042\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\t0\u001c2\u0006\u0010(\u001a\u00020'H\u0002J\b\u0010*\u001a\u00020\u0004H\u0002J\b\u0010+\u001a\u00020\u000fH\u0002J\b\u0010,\u001a\u00020\u0004H\u0002J\b\u0010-\u001a\u00020\u0004H\u0016J\u0018\u00102\u001a\u00020\u00042\u0006\u0010/\u001a\u00020.2\u0006\u00101\u001a\u000200H\u0016J\u001e\u00106\u001a\u00020\u00042\u0014\u00105\u001a\u0010\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00020\u0004\u0018\u000103H\u0016J\u0010\u00109\u001a\u00020\u00042\u0006\u00108\u001a\u000207H\u0016J\b\u0010:\u001a\u00020\u0004H\u0016J\u001c\u0010<\u001a\b\u0012\u0004\u0012\u00020\t0;2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0;H\u0016J\u000e\u0010?\u001a\u00020\u00042\u0006\u0010>\u001a\u00020=J\u001c\u0010@\u001a\b\u0012\u0004\u0012\u00020\t0\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\rH\u0016J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010(\u001a\u00020'H\u0016J\u0010\u0010B\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\u0015H\u0016J\u0010\u0010D\u001a\u0002042\u0006\u0010C\u001a\u000204H\u0016J\b\u0010E\u001a\u00020\u0004H\u0016R\u0017\u0010K\u001a\u00020F8\u0006\u00a2\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bI\u0010JR\u0014\u0010O\u001a\u00020L8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010R\u001a\u00020P8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bB\u0010QR\u0016\u0010U\u001a\u00020S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010TR\u0016\u0010X\u001a\u00020V8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010WR\u001e\u0010Z\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010YR\u001e\u0010[\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010YR\u0016\u0010\\\u001a\u00020V8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u0010WR\u0016\u0010]\u001a\u00020S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010TR\u0016\u0010`\u001a\u00020^8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010_R\u0014\u0010d\u001a\u00020a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bb\u0010cR\u0014\u0010h\u001a\u00020e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bf\u0010gR\u0014\u0010l\u001a\u00020i8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bj\u0010kR\u0014\u0010p\u001a\u00020m8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bn\u0010oR\u0014\u0010t\u001a\u00020q8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\br\u0010sR\u0014\u0010x\u001a\u00020u8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bv\u0010w\u00a8\u0006}"}, d2 = {"Lcom/tencent/guild/aio/factory/business/holder/msglist/data/guild/GuildMsgRepoDelegate;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/k;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "K", "Lcom/tencent/mvi/base/route/k;", "L", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/aio/data/msglist/a;", "list", BdhLogUtil.LogTag.Tag_Conn, "c0", "", "displayList", "", "G", "Lrr1/i;", "notifyData", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, ExifInterface.LATITUDE_SOUTH, "", "startTime", BdhLogUtil.LogTag.Tag_Req, "V", "", "X", "I", "Lcom/tencent/aio/msgservice/h;", "rsp", "P", "D", "hasEnoughCount", "Z", "(Lcom/tencent/aio/msgservice/h;Ljava/lang/Boolean;)V", "T", "b0", "N", "Y", "", "source", "M", "O", UserInfo.SEX_FEMALE, "E", "c", "Lcom/tencent/aio/api/runtime/a;", "context", "Lkotlinx/coroutines/CoroutineScope;", "scope", "l", "Lkotlin/Function1;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/l;", "notifyAction", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/a;", "model", "j", "o", "", "b", "Lcom/tencent/guild/aio/factory/business/holder/msglist/data/guild/v;", "notifier", "a0", "k", "msgSeq", tl.h.F, "msgListWithOpType", DomainData.DOMAIN_NAME, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/MsgListRepo;", "f", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/MsgListRepo;", "H", "()Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/MsgListRepo;", "host", "Lcom/tencent/guild/aio/factory/business/holder/msglist/data/guild/GuildDefaultNavigateDelegate;", "g", "Lcom/tencent/guild/aio/factory/business/holder/msglist/data/guild/GuildDefaultNavigateDelegate;", "navigateDelegate", "Lcom/tencent/guild/aio/msglist/welcome/GuildWelcomeMsgItem;", "Lcom/tencent/guild/aio/msglist/welcome/GuildWelcomeMsgItem;", "welcomeMsg", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isLoadFirstPageFin", "Ljava/util/concurrent/atomic/AtomicInteger;", "Ljava/util/concurrent/atomic/AtomicInteger;", "aioOpenAnimStatus", "Lcom/tencent/aio/msgservice/h;", "latestDbMsgsCache", "firstPageMsgListCache", "postLatestDbMsgSize", "postFirstPageMsg", "Ljava/util/concurrent/atomic/AtomicLong;", "Ljava/util/concurrent/atomic/AtomicLong;", "skeletonStartTime", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "p", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "gpServiceObserver", "Lcom/tencent/guild/aio/msglist/graytips/combine/c;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/guild/aio/msglist/graytips/combine/c;", "mCombineGrayTipCenter", "Laq0/a;", "r", "Laq0/a;", "mCombineMsgCenter", "com/tencent/guild/aio/factory/business/holder/msglist/data/guild/GuildMsgRepoDelegate$f", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/guild/aio/factory/business/holder/msglist/data/guild/GuildMsgRepoDelegate$f;", "mAction", "com/tencent/guild/aio/factory/business/holder/msglist/data/guild/GuildMsgRepoDelegate$g", "t", "Lcom/tencent/guild/aio/factory/business/holder/msglist/data/guild/GuildMsgRepoDelegate$g;", "mActionR", "com/tencent/guild/aio/factory/business/holder/msglist/data/guild/GuildMsgRepoDelegate$d", "u", "Lcom/tencent/guild/aio/factory/business/holder/msglist/data/guild/GuildMsgRepoDelegate$d;", "firstScreenMsgChangedObserver", "<init>", "(Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/MsgListRepo;)V", "v", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public class GuildMsgRepoDelegate extends com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.k {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MsgListRepo host;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildDefaultNavigateDelegate navigateDelegate;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private GuildWelcomeMsgItem welcomeMsg;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AtomicBoolean isLoadFirstPageFin;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AtomicInteger aioOpenAnimStatus;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a> latestDbMsgsCache;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a> firstPageMsgListCache;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AtomicInteger postLatestDbMsgSize;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AtomicBoolean postFirstPageMsg;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AtomicLong skeletonStartTime;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GPServiceObserver gpServiceObserver;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.guild.aio.msglist.graytips.combine.c mCombineGrayTipCenter;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final aq0.a mCombineMsgCenter;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final f mAction;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final g mActionR;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final d firstScreenMsgChangedObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class b<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((com.tencent.aio.data.msglist.a) t16).getMsgSeq()), Long.valueOf(((com.tencent.aio.data.msglist.a) t17).getMsgSeq()));
            return compareValues;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class c<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((com.tencent.aio.data.msglist.a) t16).getMsgSeq()), Long.valueOf(((com.tencent.aio.data.msglist.a) t17).getMsgSeq()));
            return compareValues;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/guild/aio/factory/business/holder/msglist/data/guild/GuildMsgRepoDelegate$d", "Ljava/util/Observer;", "Ljava/util/Observable;", "o", "", "arg", "", "update", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class d implements Observer {
        d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(GuildMsgRepoDelegate this$0, Object obj) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.P(((b.C1185b) obj).b());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(GuildMsgRepoDelegate this$0, Object obj) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.N(((b.C1185b) obj).b());
        }

        @Override // java.util.Observer
        public void update(@Nullable Observable o16, @Nullable final Object arg) {
            if (!(arg instanceof b.C1185b)) {
                return;
            }
            b.C1185b c1185b = (b.C1185b) arg;
            QLog.i("GuildMsgRepoDelegate", 1, "update NotifyData type = " + c1185b.getType() + " channelId = " + c1185b.getChannelId() + " peerUid = " + GuildMsgRepoDelegate.this.d().g().r().c().j());
            if (Intrinsics.areEqual(c1185b.getChannelId(), GuildMsgRepoDelegate.this.d().g().r().c().j()) && c1185b.b() != null) {
                if (c1185b.getType() == 1) {
                    zs.a a16 = zs.b.a(Dispatchers.INSTANCE);
                    final GuildMsgRepoDelegate guildMsgRepoDelegate = GuildMsgRepoDelegate.this;
                    a.C11711a.b(a16, new Runnable() { // from class: com.tencent.guild.aio.factory.business.holder.msglist.data.guild.q
                        @Override // java.lang.Runnable
                        public final void run() {
                            GuildMsgRepoDelegate.d.c(GuildMsgRepoDelegate.this, arg);
                        }
                    }, null, 2, null);
                } else if (c1185b.getType() == 2) {
                    zs.a a17 = zs.b.a(Dispatchers.INSTANCE);
                    final GuildMsgRepoDelegate guildMsgRepoDelegate2 = GuildMsgRepoDelegate.this;
                    a.C11711a.b(a17, new Runnable() { // from class: com.tencent.guild.aio.factory.business.holder.msglist.data.guild.r
                        @Override // java.lang.Runnable
                        public final void run() {
                            GuildMsgRepoDelegate.d.d(GuildMsgRepoDelegate.this, arg);
                        }
                    }, null, 2, null);
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014\u00a8\u0006\u0006"}, d2 = {"com/tencent/guild/aio/factory/business/holder/msglist/data/guild/GuildMsgRepoDelegate$e", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "channelUin", "", "onChannelInfoUpdated", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class e extends GPServiceObserver {
        e() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(GuildMsgRepoDelegate this$0) {
            Object first;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            MsgList g16 = this$0.g();
            if (!g16.isEmpty()) {
                first = CollectionsKt___CollectionsKt.first((List<? extends Object>) g16);
                if (first instanceof GuildWelcomeMsgItem) {
                    GuildWelcomeMsgItem guildWelcomeMsgItem = this$0.welcomeMsg;
                    GuildWelcomeMsgItem guildWelcomeMsgItem2 = null;
                    if (guildWelcomeMsgItem == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("welcomeMsg");
                        guildWelcomeMsgItem = null;
                    }
                    com.tencent.aio.data.msglist.a cloneNewInstance = guildWelcomeMsgItem.cloneNewInstance();
                    Intrinsics.checkNotNull(cloneNewInstance, "null cannot be cast to non-null type com.tencent.guild.aio.msglist.welcome.GuildWelcomeMsgItem");
                    this$0.welcomeMsg = (GuildWelcomeMsgItem) cloneNewInstance;
                    GuildWelcomeMsgItem guildWelcomeMsgItem3 = this$0.welcomeMsg;
                    if (guildWelcomeMsgItem3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("welcomeMsg");
                    } else {
                        guildWelcomeMsgItem2 = guildWelcomeMsgItem3;
                    }
                    guildWelcomeMsgItem2.init();
                    com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b bVar = com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.f110545a;
                    com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.o(bVar, this$0.getHost(), IMsgListRepository.MsgListRepoOpType.OtherOperation, g16, bVar.e("GuildMsgRepoDelegate", "onChannelInfoUpdated"), null, 16, null);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelInfoUpdated(@Nullable String channelUin) {
            super.onChannelInfoUpdated(channelUin);
            if (channelUin != null) {
                AIOParam g16 = GuildMsgRepoDelegate.this.d().g();
                Intrinsics.checkNotNullExpressionValue(g16, "context.aioParam");
                if (Intrinsics.areEqual(com.tencent.guild.aio.util.a.b(g16), channelUin)) {
                    zs.a a16 = zs.b.a(Dispatchers.INSTANCE);
                    final GuildMsgRepoDelegate guildMsgRepoDelegate = GuildMsgRepoDelegate.this;
                    a.C11711a.b(a16, new Runnable() { // from class: com.tencent.guild.aio.factory.business.holder.msglist.data.guild.t
                        @Override // java.lang.Runnable
                        public final void run() {
                            GuildMsgRepoDelegate.e.e(GuildMsgRepoDelegate.this);
                        }
                    }, null, 2, null);
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/guild/aio/factory/business/holder/msglist/data/guild/GuildMsgRepoDelegate$f", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class f implements com.tencent.mvi.base.route.a {
        f() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            GuildMsgRepoDelegate.this.K(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/guild/aio/factory/business/holder/msglist/data/guild/GuildMsgRepoDelegate$g", "Lcom/tencent/mvi/base/route/b;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "Lcom/tencent/mvi/base/route/k;", "call", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class g implements com.tencent.mvi.base.route.b {
        g() {
        }

        @Override // com.tencent.mvi.base.route.b
        @NotNull
        public com.tencent.mvi.base.route.k call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            return GuildMsgRepoDelegate.this.L(i3);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildMsgRepoDelegate(@NotNull MsgListRepo host) {
        super(host);
        Intrinsics.checkNotNullParameter(host, "host");
        this.host = host;
        this.navigateDelegate = new GuildDefaultNavigateDelegate(host);
        this.isLoadFirstPageFin = new AtomicBoolean(false);
        this.aioOpenAnimStatus = new AtomicInteger(0);
        this.postLatestDbMsgSize = new AtomicInteger(-1);
        this.postFirstPageMsg = new AtomicBoolean(false);
        this.skeletonStartTime = new AtomicLong(0L);
        this.gpServiceObserver = new e();
        this.mCombineGrayTipCenter = new com.tencent.guild.aio.msglist.graytips.combine.c();
        this.mCombineMsgCenter = new aq0.a();
        this.mAction = new f();
        this.mActionR = new g();
        this.firstScreenMsgChangedObserver = new d();
    }

    private final void C(CopyOnWriteArrayList<com.tencent.aio.data.msglist.a> list) {
        Object first;
        Object first2;
        if (((IGuildChannelApi) QRoute.api(IGuildChannelApi.class)).isSelfGuest(d().g().r().c().j(), d().g().r().c().f())) {
            QLog.i("GuildMsgRepoDelegate", 1, "addWelcomeMsgIfNeed, isGuest, return. channelId: " + d().g().r().c().j() + ", guildId: " + d().g().r().c().f());
            return;
        }
        GuildWelcomeMsgItem guildWelcomeMsgItem = this.welcomeMsg;
        GuildWelcomeMsgItem guildWelcomeMsgItem2 = null;
        if (guildWelcomeMsgItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("welcomeMsg");
            guildWelcomeMsgItem = null;
        }
        if (!Intrinsics.areEqual(guildWelcomeMsgItem.getChannelId(), d().g().r().c().j())) {
            GuildWelcomeMsgItem guildWelcomeMsgItem3 = this.welcomeMsg;
            if (guildWelcomeMsgItem3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("welcomeMsg");
                guildWelcomeMsgItem3 = null;
            }
            guildWelcomeMsgItem3.setChannelId(d().g().r().c().j());
            GuildWelcomeMsgItem guildWelcomeMsgItem4 = this.welcomeMsg;
            if (guildWelcomeMsgItem4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("welcomeMsg");
                guildWelcomeMsgItem4 = null;
            }
            guildWelcomeMsgItem4.setGuildId(d().g().r().c().f());
            GuildWelcomeMsgItem guildWelcomeMsgItem5 = this.welcomeMsg;
            if (guildWelcomeMsgItem5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("welcomeMsg");
                guildWelcomeMsgItem5 = null;
            }
            guildWelcomeMsgItem5.init();
        }
        if (!list.isEmpty()) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) list);
            if (!(first instanceof GuildWelcomeMsgItem)) {
                first2 = CollectionsKt___CollectionsKt.first((List<? extends Object>) list);
                if (((com.tencent.aio.data.msglist.a) first2).getMsgSeq() <= 1) {
                    GuildWelcomeMsgItem guildWelcomeMsgItem6 = this.welcomeMsg;
                    if (guildWelcomeMsgItem6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("welcomeMsg");
                    } else {
                        guildWelcomeMsgItem2 = guildWelcomeMsgItem6;
                    }
                    list.add(0, guildWelcomeMsgItem2);
                    return;
                }
                return;
            }
            return;
        }
        GuildWelcomeMsgItem guildWelcomeMsgItem7 = this.welcomeMsg;
        if (guildWelcomeMsgItem7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("welcomeMsg");
        } else {
            guildWelcomeMsgItem2 = guildWelcomeMsgItem7;
        }
        list.add(guildWelcomeMsgItem2);
    }

    private final boolean D(com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a> rsp) {
        boolean z16;
        Object first;
        boolean z17;
        if (!rsp.d() || rsp.a() == null) {
            return false;
        }
        if (rsp.a().size() >= 10) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!rsp.a().isEmpty()) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) rsp.a());
            if (((com.tencent.aio.data.msglist.a) first).getMsgSeq() <= 1) {
                z17 = true;
                if (z16 && !z17 && !com.tencent.guild.aio.factory.d.f110653a.j(rsp.a(), 10)) {
                    return false;
                }
                return true;
            }
        }
        z17 = false;
        if (z16) {
        }
        return true;
    }

    private final void E() {
        this.welcomeMsg = new GuildWelcomeMsgItem(new MsgRecord(), d().g().r().c().j(), d().g().r().c().f(), false, 8, null);
    }

    private final int F() {
        if (!X()) {
            return 0;
        }
        if (this.postLatestDbMsgSize.get() == 0 && !this.postFirstPageMsg.get()) {
            return 0;
        }
        return 60;
    }

    private final int G(List<? extends com.tencent.aio.data.msglist.a> displayList) {
        int i3;
        int size = displayList.size();
        int size2 = displayList.size() - 1;
        while (true) {
            int i16 = size2;
            i3 = size;
            size = i16;
            if (-1 >= size) {
                break;
            }
            com.tencent.aio.data.msglist.a aVar = displayList.get(size);
            Intrinsics.checkNotNull(aVar, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
            GuildMsgItem guildMsgItem = (GuildMsgItem) aVar;
            if (!guildMsgItem.isLocalSend() || guildMsgItem.getMsgRecord().sendStatus != 1) {
                break;
            }
            QLog.i("GuildMsgRepoDelegate", 1, "getFirstLocalSendingMsgPos pos = " + size + ", seq: " + guildMsgItem.getMsgSeq() + ", id: " + guildMsgItem.getMsgId() + ", msgType: " + guildMsgItem.getMsgRecord().msgType + ", subMsgType: " + guildMsgItem.getMsgRecord().subMsgType + ", msgTime: " + guildMsgItem.getMsgRecord().msgTime + ", ");
            size2 = size + (-1);
        }
        QLog.i("GuildMsgRepoDelegate", 1, "getFirstLocalSendingMsgPos pos = " + i3 + ", size = " + displayList.size());
        return i3;
    }

    private final void I() {
        com.tencent.guild.aio.factory.b e16 = com.tencent.guild.aio.util.ex.a.e(d());
        boolean z16 = false;
        if (e16 != null) {
            AIOParam g16 = d().g();
            Intrinsics.checkNotNullExpressionValue(g16, "context.aioParam");
            if (e16.j(com.tencent.guild.aio.util.a.b(g16))) {
                z16 = true;
            }
        }
        if (z16) {
            AIOParam g17 = d().g();
            Intrinsics.checkNotNullExpressionValue(g17, "context.aioParam");
            QLog.i("GuildMsgRepoDelegate", 1, "getLatestDbMsgs, isLoadFirstScreenMsg channelId = " + com.tencent.guild.aio.util.a.b(g17));
            return;
        }
        a.C11711a.b(zs.b.a(Dispatchers.INSTANCE), new Runnable() { // from class: com.tencent.guild.aio.factory.business.holder.msglist.data.guild.p
            @Override // java.lang.Runnable
            public final void run() {
                GuildMsgRepoDelegate.J(GuildMsgRepoDelegate.this);
            }
        }, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(GuildMsgRepoDelegate this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AIOParam g16 = this$0.d().g();
        Intrinsics.checkNotNullExpressionValue(g16, "context.aioParam");
        QLog.i("GuildMsgRepoDelegate", 1, "getLatestDbMsgs, channelId = " + com.tencent.guild.aio.util.a.b(g16));
        ChannelAIOMsgService.f112613a.p(15, this$0.d().g().r(), new GuildMsgRepoDelegate$getLatestDbMsgs$1$1(this$0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K(MsgIntent i3) {
        if (i3 instanceof MFGestureListIntent.NotifyEvent) {
            Q(((MFGestureListIntent.NotifyEvent) i3).getNotifyData());
            return;
        }
        if (i3 instanceof GuildMsgListIntent.GetLatestDbMsgsEvent) {
            I();
            return;
        }
        if (i3 instanceof GuildMsgListIntent.GetDelayAnimTimeEvent) {
            ((GuildMsgListIntent.GetDelayAnimTimeEvent) i3).b(F());
            return;
        }
        if (i3 instanceof GuildMsgListIntent.OnSkeletonLastEnoughTime) {
            S();
        } else if (i3 instanceof GuildMsgListIntent.OnSkeletonShow) {
            R(((GuildMsgListIntent.OnSkeletonShow) i3).getStartTime());
        } else {
            pn0.b bVar = pn0.b.f426490a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mvi.base.route.k L(MsgIntent i3) {
        if (i3 instanceof GuildMsgListIntent.GetLoadFirstPageFin) {
            return new i.e(this.isLoadFirstPageFin.get());
        }
        return pn0.b.f426490a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M(com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a> rsp, String source) {
        Object firstOrNull;
        Long l3;
        Object lastOrNull;
        if (rsp.d() && (!rsp.a().isEmpty())) {
            AIOParam g16 = d().g();
            Intrinsics.checkNotNullExpressionValue(g16, "context.aioParam");
            String b16 = com.tencent.guild.aio.util.a.b(g16);
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) rsp.a());
            com.tencent.aio.data.msglist.a aVar = (com.tencent.aio.data.msglist.a) firstOrNull;
            Long l16 = null;
            if (aVar != null) {
                l3 = Long.valueOf(aVar.getMsgSeq());
            } else {
                l3 = null;
            }
            lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) rsp.a());
            com.tencent.aio.data.msglist.a aVar2 = (com.tencent.aio.data.msglist.a) lastOrNull;
            if (aVar2 != null) {
                l16 = Long.valueOf(aVar2.getMsgSeq());
            }
            QLog.i("GuildMsgRepoDelegate", 1, "[handleFirstPage], channelId = " + b16 + ", firstSeq = " + l3 + " lastSeq = " + l16 + "}, source: " + source);
            MsgList M = this.host.M();
            M.clear();
            M.addAll(rsp.a());
            boolean areEqual = Intrinsics.areEqual(source, "from_receive_msg");
            com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b bVar = com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.f110545a;
            bVar.p(this.host, IMsgListRepository.MsgListRepoOpType.LoadFirst, M, bVar.e("GuildMsgRepoDelegate", "handleFirstPage"), bVar.b(areEqual, false));
            long j3 = d().g().l().getLong("navigate_msg_seq", 0L);
            d().g().l().putLong("navigate_msg_seq", 0L);
            if (j3 != 0) {
                h(j3);
                return;
            }
            return;
        }
        C(this.host.M());
        com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b bVar2 = com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.f110545a;
        MsgListRepo msgListRepo = this.host;
        com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.o(bVar2, msgListRepo, IMsgListRepository.MsgListRepoOpType.LoadFirst, msgListRepo.M(), bVar2.e("GuildMsgRepoDelegate", "handleFirstPage"), null, 16, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N(com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a> rsp) {
        AIOParam g16 = d().g();
        Intrinsics.checkNotNullExpressionValue(g16, "context.aioParam");
        QLog.i("GuildMsgRepoDelegate", 1, "[handleFirstPageForFirstScreen], channelId = " + com.tencent.guild.aio.util.a.b(g16) + ", succ = " + rsp.d() + ", data size = " + rsp.a().size() + " aioOpenAnimStatus: " + this.aioOpenAnimStatus);
        ao0.d.j(ao0.d.f26594a, rsp.a(), d(), false, 4, null);
        if (!T() && !b0()) {
            Y(rsp);
        } else {
            QLog.i("GuildMsgRepoDelegate", 1, "[handleFirstPageForFirstScreen], isAnimIng or skeletonDelayHide");
            this.firstPageMsgListCache = rsp;
        }
    }

    private final void O() {
        com.tencent.guild.aio.factory.b e16 = com.tencent.guild.aio.util.ex.a.e(d());
        if (e16 == null) {
            return;
        }
        e16.f(this.firstScreenMsgChangedObserver);
        if (!Intrinsics.areEqual(e16.i(), d().g().r().c().j())) {
            return;
        }
        e16.k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P(com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a> rsp) {
        AIOParam g16 = d().g();
        Intrinsics.checkNotNullExpressionValue(g16, "context.aioParam");
        QLog.i("GuildMsgRepoDelegate", 1, "[handleGetLatestDbMsgs], channelId = " + com.tencent.guild.aio.util.a.b(g16) + ", succ = " + rsp.d() + ", data size = " + rsp.a().size() + ", aioOpenAnimStatus = " + this.aioOpenAnimStatus);
        boolean D = D(rsp);
        if (rsp.d() && D && !this.isLoadFirstPageFin.get()) {
            if (rsp.a().size() >= 10) {
                ao0.d.j(ao0.d.f26594a, rsp.a().subList(rsp.a().size() - 10, rsp.a().size()), d(), false, 4, null);
            } else {
                ao0.d.j(ao0.d.f26594a, rsp.a(), d(), false, 4, null);
            }
        }
        if (!T() && !b0()) {
            Z(rsp, Boolean.valueOf(D));
        } else {
            QLog.i("GuildMsgRepoDelegate", 1, "[handleGetLatestDbMsgs], isAnimIng or skeletonDelayHide");
            this.latestDbMsgsCache = rsp;
        }
    }

    private final void Q(rr1.i notifyData) {
        if (notifyData.f() == 1 && notifyData.d() == 2 && notifyData.g() == 3 && notifyData.a() == 3) {
            AIOParam g16 = d().g();
            Intrinsics.checkNotNullExpressionValue(g16, "context.aioParam");
            QLog.i("GuildMsgRepoDelegate", 1, "[handleMFGesture] aioOpenAnimationStarted. channelId: " + com.tencent.guild.aio.util.a.b(g16));
            this.aioOpenAnimStatus.set(1);
            return;
        }
        if (notifyData.f() == 2) {
            if (notifyData.b() < bi.d() && notifyData.b() > bi.d() * 0.0f) {
                if (this.aioOpenAnimStatus.get() == 1) {
                    this.aioOpenAnimStatus.set(2);
                    AtomicInteger atomicInteger = this.aioOpenAnimStatus;
                    float b16 = notifyData.b();
                    AIOParam g17 = d().g();
                    Intrinsics.checkNotNullExpressionValue(g17, "context.aioParam");
                    QLog.i("GuildMsgRepoDelegate", 1, "[handleMFGesture] aioOpenAnimStatus " + atomicInteger + " curTranslationX: " + b16 + " channelId: " + com.tencent.guild.aio.util.a.b(g17));
                    return;
                }
                return;
            }
            if (notifyData.b() <= bi.d() * 0.0f) {
                if (this.aioOpenAnimStatus.get() == 1 || this.aioOpenAnimStatus.get() == 2) {
                    this.aioOpenAnimStatus.set(3);
                    V();
                    AtomicInteger atomicInteger2 = this.aioOpenAnimStatus;
                    float b17 = notifyData.b();
                    AIOParam g18 = d().g();
                    Intrinsics.checkNotNullExpressionValue(g18, "context.aioParam");
                    QLog.i("GuildMsgRepoDelegate", 1, "[handleMFGesture] aioOpenAnimStatus " + atomicInteger2 + " curTranslationX: " + b17 + " channelId: " + com.tencent.guild.aio.util.a.b(g18));
                    return;
                }
                return;
            }
            return;
        }
        if (notifyData.f() == 3) {
            if (this.aioOpenAnimStatus.get() == 1 || this.aioOpenAnimStatus.get() == 2) {
                this.aioOpenAnimStatus.set(3);
                V();
                AIOParam g19 = d().g();
                Intrinsics.checkNotNullExpressionValue(g19, "context.aioParam");
                QLog.i("GuildMsgRepoDelegate", 1, "[handleMFGesture] aioOpenAnimationEnded. channelId: " + com.tencent.guild.aio.util.a.b(g19));
            }
        }
    }

    private final void R(long startTime) {
        if (!this.isLoadFirstPageFin.get()) {
            QLog.i("GuildMsgRepoDelegate", 1, "handleOnSkeletonShow, startTime: " + startTime);
            this.skeletonStartTime.set(startTime);
        }
    }

    private final void S() {
        if (this.skeletonStartTime.get() > 0) {
            QLog.i("GuildMsgRepoDelegate", 1, "handleSkeletonLastEnoughTime");
            this.skeletonStartTime.set(0L);
            V();
        }
    }

    private final boolean T() {
        int i3 = this.aioOpenAnimStatus.get();
        if (i3 == 1 || i3 == 2) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(GuildMsgRepoDelegate this$0, String source) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(source, "$source");
        AIOParam g16 = this$0.d().g();
        Intrinsics.checkNotNullExpressionValue(g16, "context.aioParam");
        QLog.i("GuildMsgRepoDelegate", 1, "loadFirstPage, channelId = " + com.tencent.guild.aio.util.a.b(g16) + " source = " + source);
        com.tencent.guild.aio.factory.b e16 = com.tencent.guild.aio.util.ex.a.e(this$0.d());
        if (e16 != null) {
            e16.m();
        }
        ChannelAIOMsgService.f112613a.k(new com.tencent.aio.msgservice.c(this$0.d().g().r(), 15), new GuildMsgRepoDelegate$loadFirstPage$1$1(source, this$0));
    }

    private final void V() {
        a.C11711a.b(zs.b.a(Dispatchers.INSTANCE), new Runnable() { // from class: com.tencent.guild.aio.factory.business.holder.msglist.data.guild.o
            @Override // java.lang.Runnable
            public final void run() {
                GuildMsgRepoDelegate.W(GuildMsgRepoDelegate.this);
            }
        }, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(GuildMsgRepoDelegate this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.firstPageMsgListCache != null) {
            AIOParam g16 = this$0.d().g();
            Intrinsics.checkNotNullExpressionValue(g16, "context.aioParam");
            QLog.i("GuildMsgRepoDelegate", 1, "[loadMsgFromCache] handleFirstPage. channelId: " + com.tencent.guild.aio.util.a.b(g16));
            com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a> hVar = this$0.firstPageMsgListCache;
            Intrinsics.checkNotNull(hVar);
            this$0.Y(hVar);
        } else if (this$0.latestDbMsgsCache != null) {
            AIOParam g17 = this$0.d().g();
            Intrinsics.checkNotNullExpressionValue(g17, "context.aioParam");
            QLog.i("GuildMsgRepoDelegate", 1, "[loadMsgFromCache] handleGetLatestDbMsgs. channelId: " + com.tencent.guild.aio.util.a.b(g17));
            com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a> hVar2 = this$0.latestDbMsgsCache;
            Intrinsics.checkNotNull(hVar2);
            this$0.Z(hVar2, null);
        }
        this$0.firstPageMsgListCache = null;
        this$0.latestDbMsgsCache = null;
    }

    private final boolean X() {
        return Intrinsics.areEqual(d().g().n(), com.tencent.guild.aio.factory.a.class.getName());
    }

    private final void Y(com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a> rsp) {
        AIOParam g16 = d().g();
        Intrinsics.checkNotNullExpressionValue(g16, "context.aioParam");
        QLog.i("GuildMsgRepoDelegate", 1, "[realHandleFirstPageForFirstScreen], channelId = " + com.tencent.guild.aio.util.a.b(g16) + ", succ = " + rsp.d() + ", data size = " + rsp.a().size() + " aioOpenAnimStatus: " + this.aioOpenAnimStatus);
        this.postFirstPageMsg.set(true);
        M(rsp, "from_first_screen");
        if (this.isLoadFirstPageFin.compareAndSet(false, true)) {
            BuildersKt__Builders_commonKt.launch$default(r(), Dispatchers.getMain(), null, new GuildMsgRepoDelegate$realHandleFirstPageForFirstScreen$1(this, null), 2, null);
        }
    }

    private final void Z(com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a> rsp, Boolean hasEnoughCount) {
        boolean D;
        List<com.tencent.aio.data.msglist.a> a16;
        Object firstOrNull;
        Long l3;
        Object lastOrNull;
        AIOParam g16 = d().g();
        Intrinsics.checkNotNullExpressionValue(g16, "context.aioParam");
        QLog.i("GuildMsgRepoDelegate", 1, "[realHandleGetLatestDbMsgs], channelId = " + com.tencent.guild.aio.util.a.b(g16) + ", succ = " + rsp.d() + ", data size = " + rsp.a().size() + ", aioOpenAnimStatus = " + this.aioOpenAnimStatus);
        this.postLatestDbMsgSize.set(0);
        if (hasEnoughCount != null) {
            D = hasEnoughCount.booleanValue();
        } else {
            D = D(rsp);
        }
        if (rsp.d() && D && !this.isLoadFirstPageFin.get()) {
            this.postLatestDbMsgSize.set(rsp.a().size());
            MsgList M = this.host.M();
            M.clear();
            if (rsp.a().size() >= 10) {
                a16 = rsp.a().subList(rsp.a().size() - 10, rsp.a().size());
            } else {
                a16 = rsp.a();
            }
            AIOParam g17 = d().g();
            Intrinsics.checkNotNullExpressionValue(g17, "context.aioParam");
            String b16 = com.tencent.guild.aio.util.a.b(g17);
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) a16);
            com.tencent.aio.data.msglist.a aVar = (com.tencent.aio.data.msglist.a) firstOrNull;
            Long l16 = null;
            if (aVar != null) {
                l3 = Long.valueOf(aVar.getMsgSeq());
            } else {
                l3 = null;
            }
            lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) a16);
            com.tencent.aio.data.msglist.a aVar2 = (com.tencent.aio.data.msglist.a) lastOrNull;
            if (aVar2 != null) {
                l16 = Long.valueOf(aVar2.getMsgSeq());
            }
            QLog.i("GuildMsgRepoDelegate", 1, "[handleGetLatestDbMsgs], channelId = " + b16 + ", firstSeq = " + l3 + " lastSeq = " + l16 + "}");
            M.addAll(a16);
            com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b bVar = com.tencent.guild.aio.factory.business.holder.msglist.data.guild.b.f110545a;
            bVar.p(this.host, IMsgListRepository.MsgListRepoOpType.LoadFirst, M, bVar.e("GuildMsgRepoDelegate", "realHandleGetLatestDbMsgs"), bVar.b(false, false));
        }
    }

    private final boolean b0() {
        if (!X()) {
            return false;
        }
        return bo0.a.INSTANCE.a(this.skeletonStartTime.get());
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0094, code lost:
    
        if ((r0 instanceof com.tencent.guild.aio.msglist.welcome.GuildWelcomeMsgItem) == false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00d8, code lost:
    
        if (r3.isSameItem((com.tencent.aio.data.msglist.a) r6) == false) goto L34;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void c0(CopyOnWriteArrayList<com.tencent.aio.data.msglist.a> list) {
        boolean z16;
        GuildWelcomeMsgItem guildWelcomeMsgItem;
        Object first;
        boolean z17;
        Object first2;
        Object first3;
        boolean z18 = true;
        if (((IGuildChannelApi) QRoute.api(IGuildChannelApi.class)).isSelfGuest(d().g().r().c().j(), d().g().r().c().f())) {
            QLog.i("GuildMsgRepoDelegate", 1, "addWelcomeMsgIfNeed, isGuest, return. channelId: " + d().g().r().c().j() + ", guildId: " + d().g().r().c().f());
            return;
        }
        if (list.size() <= 1) {
            if (list.size() == 1) {
                first3 = CollectionsKt___CollectionsKt.first((List<? extends Object>) list);
            }
            z16 = false;
            GuildWelcomeMsgItem guildWelcomeMsgItem2 = null;
            if (!list.isEmpty()) {
                first = CollectionsKt___CollectionsKt.first((List<? extends Object>) list);
                if (first instanceof GuildWelcomeMsgItem) {
                    GuildWelcomeMsgItem guildWelcomeMsgItem3 = this.welcomeMsg;
                    if (guildWelcomeMsgItem3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("welcomeMsg");
                        guildWelcomeMsgItem3 = null;
                    }
                    if (z16 != guildWelcomeMsgItem3.getShowBottomLine()) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (!z17) {
                        GuildWelcomeMsgItem guildWelcomeMsgItem4 = this.welcomeMsg;
                        if (guildWelcomeMsgItem4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("welcomeMsg");
                            guildWelcomeMsgItem4 = null;
                        }
                        first2 = CollectionsKt___CollectionsKt.first((List<? extends Object>) list);
                        Intrinsics.checkNotNullExpressionValue(first2, "list.first()");
                    }
                    guildWelcomeMsgItem = this.welcomeMsg;
                    if (guildWelcomeMsgItem == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("welcomeMsg");
                        guildWelcomeMsgItem = null;
                    }
                    guildWelcomeMsgItem.setShowBottomLine(z16);
                    if (z18) {
                        GuildWelcomeMsgItem guildWelcomeMsgItem5 = this.welcomeMsg;
                        if (guildWelcomeMsgItem5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("welcomeMsg");
                            guildWelcomeMsgItem5 = null;
                        }
                        com.tencent.aio.data.msglist.a cloneNewInstance = guildWelcomeMsgItem5.cloneNewInstance();
                        Intrinsics.checkNotNull(cloneNewInstance, "null cannot be cast to non-null type com.tencent.guild.aio.msglist.welcome.GuildWelcomeMsgItem");
                        this.welcomeMsg = (GuildWelcomeMsgItem) cloneNewInstance;
                        list.remove(0);
                        GuildWelcomeMsgItem guildWelcomeMsgItem6 = this.welcomeMsg;
                        if (guildWelcomeMsgItem6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("welcomeMsg");
                        } else {
                            guildWelcomeMsgItem2 = guildWelcomeMsgItem6;
                        }
                        list.add(0, guildWelcomeMsgItem2);
                        return;
                    }
                    return;
                }
            }
            z18 = false;
            guildWelcomeMsgItem = this.welcomeMsg;
            if (guildWelcomeMsgItem == null) {
            }
            guildWelcomeMsgItem.setShowBottomLine(z16);
            if (z18) {
            }
        }
        z16 = true;
        GuildWelcomeMsgItem guildWelcomeMsgItem22 = null;
        if (!list.isEmpty()) {
        }
        z18 = false;
        guildWelcomeMsgItem = this.welcomeMsg;
        if (guildWelcomeMsgItem == null) {
        }
        guildWelcomeMsgItem.setShowBottomLine(z16);
        if (z18) {
        }
    }

    @NotNull
    /* renamed from: H, reason: from getter */
    public final MsgListRepo getHost() {
        return this.host;
    }

    public final void a0(@NotNull v notifier) {
        Intrinsics.checkNotNullParameter(notifier, "notifier");
        this.navigateDelegate.x(notifier);
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.k, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository
    @NotNull
    public Collection<com.tencent.aio.data.msglist.a> b(@NotNull Collection<? extends com.tencent.aio.data.msglist.a> list) {
        Object firstOrNull;
        ArrayList arrayList;
        boolean z16;
        Intrinsics.checkNotNullParameter(list, "list");
        synchronized (list) {
            com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.a E = this.host.E();
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull(list);
            E.f((com.tencent.aio.data.msglist.a) firstOrNull);
            CopyOnWriteArrayList<com.tencent.aio.data.msglist.a> copyOnWriteArrayList = new CopyOnWriteArrayList<>(list);
            C(copyOnWriteArrayList);
            arrayList = new ArrayList();
            for (Object obj : copyOnWriteArrayList) {
                com.tencent.aio.data.msglist.a it = (com.tencent.aio.data.msglist.a) obj;
                MsgListRepo msgListRepo = this.host;
                Intrinsics.checkNotNull(msgListRepo, "null cannot be cast to non-null type com.tencent.guild.aio.factory.business.holder.msglist.data.guild.GuildMsgListRepo");
                Intrinsics.checkNotNullExpressionValue(it, "it");
                ((GuildMsgListRepo) msgListRepo).k1(it);
                if ((it instanceof GuildMsgItem) && ((GuildMsgItem) it).getMsgRecord().msgType != 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    QLog.i("GuildMsgRepoDelegate", 1, "beforeMsgAddToMemory, filter msg class = " + it.getClass() + ", seq = " + it.getMsgSeq());
                }
                if (z16) {
                    arrayList.add(obj);
                }
            }
        }
        return arrayList;
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.k, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.e
    public void h(long msgSeq) {
        this.navigateDelegate.h(msgSeq);
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.k, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository
    public void i(@NotNull final String source) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (Intrinsics.areEqual(source, "from_first_screen")) {
            com.tencent.guild.aio.factory.b e16 = com.tencent.guild.aio.util.ex.a.e(d());
            boolean z16 = false;
            if (e16 != null) {
                AIOParam g16 = d().g();
                Intrinsics.checkNotNullExpressionValue(g16, "context.aioParam");
                if (e16.j(com.tencent.guild.aio.util.a.b(g16))) {
                    z16 = true;
                }
            }
            if (z16) {
                AIOParam g17 = d().g();
                Intrinsics.checkNotNullExpressionValue(g17, "context.aioParam");
                QLog.i("GuildMsgRepoDelegate", 1, "loadFirstPage, isLoadFirstScreenMsg channelId = " + com.tencent.guild.aio.util.a.b(g17));
                return;
            }
        }
        a.C11711a.b(zs.b.a(Dispatchers.INSTANCE), new Runnable() { // from class: com.tencent.guild.aio.factory.business.holder.msglist.data.guild.n
            @Override // java.lang.Runnable
            public final void run() {
                GuildMsgRepoDelegate.U(GuildMsgRepoDelegate.this, source);
            }
        }, null, 2, null);
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.k, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.f
    public void j(@NotNull com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.a model) {
        Intrinsics.checkNotNullParameter(model, "model");
        super.j(model);
        this.navigateDelegate.j(model);
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.k, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository
    @NotNull
    public List<com.tencent.aio.data.msglist.a> k(@NotNull List<? extends com.tencent.aio.data.msglist.a> displayList) {
        List sortedWith;
        CopyOnWriteArrayList<com.tencent.aio.data.msglist.a> copyOnWriteArrayList;
        ArrayList arrayList;
        boolean z16;
        List sortedWith2;
        List plus;
        Intrinsics.checkNotNullParameter(displayList, "displayList");
        synchronized (displayList) {
            int G = G(displayList);
            if (G < 0 || G >= displayList.size()) {
                sortedWith = CollectionsKt___CollectionsKt.sortedWith(displayList, new c());
                HashSet hashSet = new HashSet();
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : sortedWith) {
                    if (hashSet.add(Long.valueOf(((com.tencent.aio.data.msglist.a) obj).getMsgId()))) {
                        arrayList2.add(obj);
                    }
                }
                copyOnWriteArrayList = new CopyOnWriteArrayList<>(arrayList2);
            } else {
                sortedWith2 = CollectionsKt___CollectionsKt.sortedWith(displayList.subList(0, G), new b());
                plus = CollectionsKt___CollectionsKt.plus((Collection) sortedWith2, (Iterable) displayList.subList(G, displayList.size()));
                HashSet hashSet2 = new HashSet();
                ArrayList arrayList3 = new ArrayList();
                for (Object obj2 : plus) {
                    if (hashSet2.add(Long.valueOf(((com.tencent.aio.data.msglist.a) obj2).getMsgId()))) {
                        arrayList3.add(obj2);
                    }
                }
                copyOnWriteArrayList = new CopyOnWriteArrayList<>(arrayList3);
            }
            c0(copyOnWriteArrayList);
            this.mCombineGrayTipCenter.b(copyOnWriteArrayList);
            this.mCombineMsgCenter.g(copyOnWriteArrayList);
            arrayList = new ArrayList();
            boolean z17 = false;
            for (Object obj3 : copyOnWriteArrayList) {
                com.tencent.aio.data.msglist.a it = (com.tencent.aio.data.msglist.a) obj3;
                MsgListRepo msgListRepo = this.host;
                Intrinsics.checkNotNull(msgListRepo, "null cannot be cast to non-null type com.tencent.guild.aio.factory.business.holder.msglist.data.guild.GuildMsgListRepo");
                Intrinsics.checkNotNullExpressionValue(it, "it");
                ((GuildMsgListRepo) msgListRepo).k1(it);
                boolean z18 = it instanceof GuildWelcomeMsgItem;
                if ((it instanceof GuildMsgItem) && ((GuildMsgItem) it).getMsgRecord().msgType != 1 && (!z17 || !z18)) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z18) {
                    z17 = true;
                }
                if (!z16) {
                    QLog.i("GuildMsgRepoDelegate", 1, "beforeMsgToScreen, filter msg class = " + it.getClass() + ", seq = " + it.getMsgSeq());
                } else {
                    GuildMsgItem guildMsgItem = (GuildMsgItem) it;
                    if (com.tencent.guild.api.data.msglist.a.c(guildMsgItem)) {
                        com.tencent.guild.api.data.msglist.a.g(guildMsgItem);
                    }
                }
                if (z16) {
                    arrayList.add(obj3);
                }
            }
            g12.b bVar = g12.b.f401087a;
            if (!bVar.b()) {
                bVar.h(GuildHistogramScene.GUILD_AIO_FIRST_VIEW_TIME_COST, "");
            }
            super.k(displayList);
        }
        return arrayList;
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.k, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.f
    public void l(@NotNull com.tencent.aio.api.runtime.a context, @NotNull CoroutineScope scope) {
        AppInterface appInterface;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(scope, "scope");
        super.l(context, scope);
        E();
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
            iGPSService.addObserver(this.gpServiceObserver);
        }
        this.navigateDelegate.l(context, scope);
        context.e().d(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GetLatestDbMsgsEvent.class).getQualifiedName(), this.mAction);
        if (X()) {
            context.e().d(Reflection.getOrCreateKotlinClass(MFGestureListIntent.NotifyEvent.class).getQualifiedName(), this.mAction);
            context.e().d(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.OnSkeletonShow.class).getQualifiedName(), this.mAction);
            context.e().d(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.OnSkeletonLastEnoughTime.class).getQualifiedName(), this.mAction);
        }
        context.e().d(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GetDelayAnimTimeEvent.class).getQualifiedName(), this.mAction);
        context.e().j(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GetLoadFirstPageFin.class).getQualifiedName(), this.mActionR);
        O();
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.k, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.f
    public void m(@Nullable Function1<? super com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.l, Unit> notifyAction) {
        QLog.i("GuildMsgRepoDelegate", 1, "setUpdateNotify");
        super.m(notifyAction);
        this.navigateDelegate.m(notifyAction);
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.k, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository
    @NotNull
    public com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.l n(@NotNull com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.l msgListWithOpType) {
        Long l3;
        int i3;
        boolean z16;
        Intrinsics.checkNotNullParameter(msgListWithOpType, "msgListWithOpType");
        com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.l n3 = super.n(msgListWithOpType);
        Bundle a16 = msgListWithOpType.a();
        if (a16 != null) {
            l3 = Long.valueOf(a16.getLong("KEY_NAVIGATE_SEQ", -1L));
        } else {
            l3 = null;
        }
        if (l3 != null && l3.longValue() != -1) {
            Iterator<com.tencent.aio.data.msglist.a> it = n3.c().iterator();
            i3 = 0;
            while (it.hasNext()) {
                if (it.next().getMsgSeq() == l3.longValue()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
                i3++;
            }
        }
        i3 = -1;
        QLog.i("GuildMsgRepoDelegate", 1, "beforeMsgToScreenWithIndex, pos = " + i3 + ", msgSeq = " + l3);
        if (i3 != -1) {
            com.tencent.aio.data.msglist.a aVar = n3.c().get(i3);
            Intrinsics.checkNotNull(aVar, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
            if (!com.tencent.guild.aio.util.ex.f.b((GuildMsgItem) aVar)) {
                return new com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.l(n3.c(), n3.d(), null, n3.a());
            }
        }
        return n3;
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.k, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.e
    public void o() {
        i("from_nav_to_bottom");
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.k, com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.f
    public void onDestroy() {
        AppInterface appInterface;
        super.onDestroy();
        this.mCombineGrayTipCenter.c();
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
            iGPSService.deleteObserver(this.gpServiceObserver);
        }
        this.navigateDelegate.onDestroy();
        d().e().b(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GetLatestDbMsgsEvent.class).getQualifiedName(), this.mAction);
        if (X()) {
            d().e().b(Reflection.getOrCreateKotlinClass(MFGestureListIntent.NotifyEvent.class).getQualifiedName(), this.mAction);
            d().e().b(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.OnSkeletonLastEnoughTime.class).getQualifiedName(), this.mAction);
            d().e().b(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.OnSkeletonShow.class).getQualifiedName(), this.mAction);
        }
        d().e().b(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GetDelayAnimTimeEvent.class).getQualifiedName(), this.mAction);
        d().e().a(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GetLoadFirstPageFin.class).getQualifiedName());
        com.tencent.guild.aio.factory.b e16 = com.tencent.guild.aio.util.ex.a.e(d());
        if (e16 != null) {
            e16.h(this.firstScreenMsgChangedObserver);
        }
        this.skeletonStartTime.set(0L);
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.f
    public void c() {
    }
}
