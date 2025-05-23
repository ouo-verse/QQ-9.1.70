package com.tencent.mobileqq.guild.message.directmessage.model.repositories;

import android.os.Looper;
import androidx.annotation.UiThread;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.base.repository.AccountChangedNotifier;
import com.tencent.mobileqq.guild.base.repository.RepositoryCallbackConfig;
import com.tencent.mobileqq.guild.base.repository.ResultDispatcher;
import com.tencent.mobileqq.guild.mainframe.api.IGuildInboxRedService;
import com.tencent.mobileqq.guild.message.directmessage.model.data.InboxNoticeNode;
import com.tencent.mobileqq.guild.message.directmessage.model.repositories.InboxNoticeNodeRepository;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ThreadUtils;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.co;
import com.tencent.mobileqq.qqguildsdk.data.cq;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AppSetting;
import com.tenpay.sdk.util.UinConfigManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vh2.al;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0004ZN[\\B\t\b\u0002\u00a2\u0006\u0004\bY\u00103J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0007J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0007J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0007J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0007J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\bH\u0007J\u0018\u0010\u0013\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0011H\u0007J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\bH\u0007J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0003H\u0007J\b\u0010\u0016\u001a\u00020\u0005H\u0002J\u001e\u0010\u001a\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0002J\u0010\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001bH\u0003J\b\u0010\u001e\u001a\u00020\u0005H\u0002J\b\u0010\u001f\u001a\u00020\u0005H\u0002J\u0010\u0010!\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\bH\u0002J\u0010\u0010\"\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\bH\u0002J\u0018\u0010%\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010$\u001a\u00020#H\u0002R\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020\b0&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R$\u0010.\u001a\u0012\u0012\u0004\u0012\u00020\b0*j\b\u0012\u0004\u0012\u00020\b`+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R&\u00104\u001a\b\u0012\u0004\u0012\u00020\u000f0&8\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b/\u0010(\u0012\u0004\b2\u00103\u001a\u0004\b0\u00101R \u00107\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000f058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u00106R\u0014\u0010:\u001a\u0002088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u00109R\u0016\u0010=\u001a\u00020;8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010<R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b?\u0010@R \u0010D\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020B058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u00106R\u001a\u0010H\u001a\b\u0012\u0004\u0012\u00020\u000b0E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0014\u0010L\u001a\u00020I8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0014\u0010P\u001a\u00020M8VX\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\bN\u0010OR\u0014\u0010T\u001a\u00020Q8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bR\u0010SR\u0014\u0010X\u001a\u00020U8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bV\u0010W\u00a8\u0006]"}, d2 = {"Lcom/tencent/mobileqq/guild/message/directmessage/model/repositories/InboxNoticeNodeRepository;", "Lcom/tencent/mobileqq/guild/base/repository/a;", "Lcom/tencent/mobileqq/guild/base/repository/b;", "", "account", "", "onAccountChanged", "o", "", "noticeType", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/message/directmessage/model/repositories/m;", "listener", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/mobileqq/guild/message/directmessage/model/data/b;", "u", "", "show", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "v", "w", "y", "Lcom/tencent/mobileqq/guild/base/repository/h;", "Lcom/tencent/mobileqq/qqguildsdk/data/co;", "callback", "p", "Lcom/tencent/mobileqq/guild/message/directmessage/model/repositories/InboxNoticeNodeRepository$NotifyListenerSource;", "messageChange", HippyTKDListViewAdapter.X, "B", "l", "type", "D", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/message/directmessage/model/repositories/InboxNoticeNodeRepository$FetchNewestNoticeSource;", "source", DomainData.DOMAIN_NAME, "", "f", "Ljava/util/List;", "noticeTypes", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", tl.h.F, "Ljava/util/ArrayList;", "visibleNoticeTypes", "i", "t", "()Ljava/util/List;", "getNoticeNodes$annotations", "()V", "noticeNodes", "", "Ljava/util/Map;", "noticesWithType", "Lcom/tencent/mobileqq/guild/message/directmessage/model/data/c;", "Lcom/tencent/mobileqq/guild/message/directmessage/model/data/c;", "invisibleNotifyTypeSet", "Lcom/tencent/common/app/AppInterface;", "Lcom/tencent/common/app/AppInterface;", "appInterface", "Lcom/tencent/mobileqq/guild/message/directmessage/model/repositories/ServiceCache$LazyHolder;", "E", "Lcom/tencent/mobileqq/guild/message/directmessage/model/repositories/ServiceCache$LazyHolder;", "serviceHolder", "Lcom/tencent/mobileqq/guild/message/directmessage/model/repositories/InboxNoticeNodeRepository$a;", UserInfo.SEX_FEMALE, "noticeHandlers", "Ljava/util/concurrent/CopyOnWriteArrayList;", "G", "Ljava/util/concurrent/CopyOnWriteArrayList;", "listeners", "Lcom/tencent/mobileqq/guild/mainframe/api/IGuildInboxRedService$a;", "H", "Lcom/tencent/mobileqq/guild/mainframe/api/IGuildInboxRedService$a;", "onNoticeRedUpdate", "Lcom/tencent/mobileqq/guild/base/repository/c;", "a", "()Lcom/tencent/mobileqq/guild/base/repository/c;", "repositoryCallbackConfig", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "r", "()Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "gproService", "Lcom/tencent/mobileqq/guild/mainframe/api/IGuildInboxRedService;", ReportConstant.COSTREPORT_PREFIX, "()Lcom/tencent/mobileqq/guild/mainframe/api/IGuildInboxRedService;", "guildInboxRedService", "<init>", "FetchNewestNoticeSource", "NotifyListenerSource", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class InboxNoticeNodeRepository implements com.tencent.mobileqq.guild.base.repository.a, com.tencent.mobileqq.guild.base.repository.b {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private static final com.tencent.mobileqq.guild.message.directmessage.model.data.c invisibleNotifyTypeSet;

    /* renamed from: D, reason: from kotlin metadata */
    private static AppInterface appInterface;

    /* renamed from: E, reason: from kotlin metadata */
    private static ServiceCache$LazyHolder serviceHolder;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private static final Map<Integer, a> noticeHandlers;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private static final CopyOnWriteArrayList<m> listeners;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private static final IGuildInboxRedService.a onNoticeRedUpdate;

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static final InboxNoticeNodeRepository f230502e = new InboxNoticeNodeRepository();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<Integer> noticeTypes;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ArrayList<Integer> visibleNoticeTypes;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<InboxNoticeNode> noticeNodes;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<Integer, InboxNoticeNode> noticesWithType;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ com.tencent.mobileqq.guild.base.repository.d f230507d = new com.tencent.mobileqq.guild.base.repository.d("InboxNoticeNodeRepository");

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/guild/message/directmessage/model/repositories/InboxNoticeNodeRepository$FetchNewestNoticeSource;", "", "(Ljava/lang/String;I)V", "FromSetup", "FromInboxServicePush", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public enum FetchNewestNoticeSource {
        FromSetup,
        FromInboxServicePush
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/message/directmessage/model/repositories/InboxNoticeNodeRepository$NotifyListenerSource;", "", "(Ljava/lang/String;I)V", "SetVisibleChange", "VisibleLoadedChange", "RedPointChange", "MessageChange", "AccountChange", "StartupRepository", "NotTriggerFetchRedPoint", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public enum NotifyListenerSource {
        SetVisibleChange,
        VisibleLoadedChange,
        RedPointChange,
        MessageChange,
        AccountChange,
        StartupRepository,
        NotTriggerFetchRedPoint
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/message/directmessage/model/repositories/InboxNoticeNodeRepository$a;", "Lcom/tencent/mobileqq/guild/base/repository/h;", "Lcom/tencent/mobileqq/qqguildsdk/data/co;", "Lri1/a;", "error", "result", "", "c", "", "a", "I", "b", "()I", "noticeType", "Lcom/tencent/mobileqq/guild/message/directmessage/model/data/b;", "Lcom/tencent/mobileqq/guild/message/directmessage/model/data/b;", "getNotice", "()Lcom/tencent/mobileqq/guild/message/directmessage/model/data/b;", UinConfigManager.KEY_ADS, "<init>", "(I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a implements com.tencent.mobileqq.guild.base.repository.h<co> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int noticeType;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final InboxNoticeNode notice;

        public a(int i3) {
            this.noticeType = i3;
            Object obj = InboxNoticeNodeRepository.noticesWithType.get(Integer.valueOf(i3));
            Intrinsics.checkNotNull(obj);
            this.notice = (InboxNoticeNode) obj;
        }

        /* renamed from: b, reason: from getter */
        public final int getNoticeType() {
            return this.noticeType;
        }

        @Override // com.tencent.mobileqq.guild.base.repository.h
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(@NotNull ri1.a error, @Nullable co result) {
            Intrinsics.checkNotNullParameter(error, "error");
            if (!error.d()) {
                if (error.f431477a == -10) {
                    Logger logger = Logger.f235387a;
                    if (QLog.isColorLevel()) {
                        logger.d().d("Guild.C2C.InboxNoticeNodeRepository", 2, "GuildNoticeHandler result " + getNoticeType() + " SDK_CLIENT_RETURN_NULL_OBJECT");
                    }
                    if (this.notice.a()) {
                        InboxNoticeNodeRepository.f230502e.x(NotifyListenerSource.MessageChange);
                        return;
                    }
                    return;
                }
                Logger logger2 = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                String str = "GuildNoticeHandler " + getNoticeType() + " error: " + error;
                if (str instanceof String) {
                    bVar.a().add(str);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("Guild.C2C.InboxNoticeNodeRepository", 1, (String) it.next(), null);
                }
                return;
            }
            if (result != null) {
                Logger logger3 = Logger.f235387a;
                if (QLog.isColorLevel()) {
                    logger3.d().d("Guild.C2C.InboxNoticeNodeRepository", 2, "GuildNoticeHandler result(" + result.f265899o + "): " + result);
                }
                if (this.notice.j(result)) {
                    InboxNoticeNodeRepository.f230502e.x(NotifyListenerSource.MessageChange);
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010\t\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0007H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/message/directmessage/model/repositories/InboxNoticeNodeRepository$b;", "Lcom/tencent/mobileqq/guild/mainframe/api/IGuildInboxRedService$a;", "Lcom/tencent/mobileqq/guild/message/unread/api/IGuildUnreadCntService$b;", "newTotalCount", "", "a", "", "Lcom/tencent/mobileqq/qqguildsdk/data/cq;", "redPointList", "b", "redPoint", "c", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    private static final class b implements IGuildInboxRedService.a {
        @Override // com.tencent.mobileqq.guild.mainframe.api.IGuildInboxRedService.a
        public void a(@NotNull IGuildUnreadCntService.b newTotalCount) {
            Intrinsics.checkNotNullParameter(newTotalCount, "newTotalCount");
        }

        @Override // com.tencent.mobileqq.guild.mainframe.api.IGuildInboxRedService.a
        public void b(@NotNull List<? extends cq> redPointList) {
            Intrinsics.checkNotNullParameter(redPointList, "redPointList");
        }

        @Override // com.tencent.mobileqq.guild.mainframe.api.IGuildInboxRedService.a
        public void c(@NotNull cq redPoint) {
            Intrinsics.checkNotNullParameter(redPoint, "redPoint");
            Logger.f235387a.d().d("Guild.C2C.InboxNoticeNodeRepository", 1, "onOneTypeRedCountChanged update " + redPoint);
            InboxNoticeNodeRepository inboxNoticeNodeRepository = InboxNoticeNodeRepository.f230502e;
            inboxNoticeNodeRepository.n(redPoint.f265931a, FetchNewestNoticeSource.FromInboxServicePush);
            InboxNoticeNode inboxNoticeNode = (InboxNoticeNode) InboxNoticeNodeRepository.noticesWithType.get(Integer.valueOf(redPoint.f265931a));
            if (inboxNoticeNode == null) {
                return;
            }
            boolean k3 = inboxNoticeNode.k(redPoint);
            boolean C = inboxNoticeNodeRepository.C(redPoint.f265931a);
            if (k3 || C) {
                inboxNoticeNodeRepository.x(NotifyListenerSource.RedPointChange);
            }
        }
    }

    static {
        List<Integer> listOf;
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        int mapCapacity;
        int coerceAtLeast;
        int collectionSizeOrDefault3;
        int mapCapacity2;
        int coerceAtLeast2;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(8);
        noticeTypes = listOf;
        visibleNoticeTypes = new ArrayList<>();
        List<Integer> list = listOf;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new InboxNoticeNode(((Number) it.next()).intValue(), null, 0L, null, false, 30, null));
        }
        noticeNodes = arrayList;
        ArrayList arrayList2 = arrayList;
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault2);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (Object obj : arrayList2) {
            linkedHashMap.put(Integer.valueOf(((InboxNoticeNode) obj).getType()), obj);
        }
        noticesWithType = linkedHashMap;
        invisibleNotifyTypeSet = new com.tencent.mobileqq.guild.message.directmessage.model.data.c(null, new InboxNoticeNodeRepository$invisibleNotifyTypeSet$1(f230502e), 1, null);
        List<Integer> list2 = noticeTypes;
        collectionSizeOrDefault3 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        mapCapacity2 = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault3);
        coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(mapCapacity2, 16);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(coerceAtLeast2);
        for (Object obj2 : list2) {
            linkedHashMap2.put(obj2, new a(((Number) obj2).intValue()));
        }
        noticeHandlers = linkedHashMap2;
        listeners = new CopyOnWriteArrayList<>();
        onNoticeRedUpdate = new b();
        AccountChangedNotifier accountChangedNotifier = AccountChangedNotifier.f214789d;
        InboxNoticeNodeRepository inboxNoticeNodeRepository = f230502e;
        accountChangedNotifier.a(inboxNoticeNodeRepository);
        inboxNoticeNodeRepository.B();
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.message.directmessage.model.repositories.j
            @Override // java.lang.Runnable
            public final void run() {
                InboxNoticeNodeRepository.d();
            }
        });
    }

    InboxNoticeNodeRepository() {
    }

    @JvmStatic
    public static final void A(@NotNull String noticeType, boolean show) {
        Integer intOrNull;
        int i3;
        Intrinsics.checkNotNullParameter(noticeType, "noticeType");
        com.tencent.mobileqq.guild.message.directmessage.model.data.c cVar = invisibleNotifyTypeSet;
        cVar.g();
        if (show) {
            if (cVar.remove(noticeType)) {
                cVar.o();
            }
        } else if (cVar.add(noticeType)) {
            cVar.o();
        }
        intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(noticeType);
        boolean z16 = false;
        if (intOrNull != null) {
            i3 = intOrNull.intValue();
        } else {
            i3 = 0;
        }
        InboxNoticeNode inboxNoticeNode = noticesWithType.get(Integer.valueOf(i3));
        if (inboxNoticeNode != null && inboxNoticeNode.l(show)) {
            z16 = true;
        }
        if (z16) {
            ThreadUtils threadUtils = ThreadUtils.f235400a;
            if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
                f230502e.x(NotifyListenerSource.SetVisibleChange);
            } else {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.message.directmessage.model.repositories.InboxNoticeNodeRepository$setNodeVisible$$inlined$ensureUiThread$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        InboxNoticeNodeRepository.f230502e.x(InboxNoticeNodeRepository.NotifyListenerSource.SetVisibleChange);
                    }
                });
            }
        }
    }

    private final void B() {
        AppInterface l3 = ch.l();
        Intrinsics.checkNotNullExpressionValue(l3, "appInterface()");
        appInterface = l3;
        serviceHolder = new ServiceCache$LazyHolder("Guild.C2C.InboxNoticeNodeRepository");
        s().addNoticeRedUpdateListener(onNoticeRedUpdate);
        Iterator<Integer> it = noticeTypes.iterator();
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            D(intValue);
            C(intValue);
            n(intValue, FetchNewestNoticeSource.FromSetup);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean C(int type) {
        boolean z16;
        InboxNoticeNode inboxNoticeNode = noticesWithType.get(Integer.valueOf(type));
        if (inboxNoticeNode != null) {
            boolean z17 = true;
            if (inboxNoticeNode.getRedPoint().f265932b > 0 && visibleNoticeTypes.contains(Integer.valueOf(type))) {
                z16 = true;
            } else {
                z16 = false;
            }
            boolean v3 = v(type);
            if (!z16 && !v3) {
                z17 = false;
            }
            boolean l3 = inboxNoticeNode.l(z17);
            if (z16) {
                com.tencent.mobileqq.guild.message.directmessage.model.data.c cVar = invisibleNotifyTypeSet;
                if (cVar.remove(String.valueOf(type))) {
                    cVar.o();
                }
            }
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("Guild.C2C.InboxNoticeNodeRepository", 2, "updateVisibleIfHasRedPoint " + type + " hasRedPoint" + z16 + " " + inboxNoticeNode.b());
            }
            return l3;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    private final void D(int type) {
        InboxNoticeNode inboxNoticeNode = noticesWithType.get(Integer.valueOf(type));
        if (inboxNoticeNode != null) {
            cq noticeRedPoint = s().getNoticeRedPoint(type);
            Intrinsics.checkNotNullExpressionValue(noticeRedPoint, "guildInboxRedService.getNoticeRedPoint(type)");
            inboxNoticeNode.k(noticeRedPoint);
            return;
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d() {
        f230502e.x(NotifyListenerSource.StartupRepository);
    }

    @JvmStatic
    public static final void k(@NotNull m listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        listeners.addIfAbsent(listener);
    }

    private final void l() {
        s().removeNoticeRedUpdateListener(onNoticeRedUpdate);
        Iterator<T> it = noticeNodes.iterator();
        while (it.hasNext()) {
            ((InboxNoticeNode) it.next()).i();
        }
        invisibleNotifyTypeSet.n();
    }

    @JvmStatic
    public static final void m(int noticeType) {
        f230502e.s().clearNoticeRedPoint(noticeType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(int noticeType, FetchNewestNoticeSource source) {
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.C2C.InboxNoticeNodeRepository", 2, "fetchNewestNotice " + noticeType + " from " + source);
        }
        a aVar = noticeHandlers.get(Integer.valueOf(noticeType));
        if (aVar == null) {
            return;
        }
        p(noticeType, aVar);
    }

    @JvmStatic
    public static final void o() {
        ThreadUtils threadUtils = ThreadUtils.f235400a;
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.guild.message.directmessage.model.repositories.InboxNoticeNodeRepository$fetchNotice$$inlined$executeOnWorkThread$1
            @Override // java.lang.Runnable
            public final void run() {
                InboxNoticeNodeRepository.invisibleNotifyTypeSet.g();
            }
        });
        InboxNoticeNodeRepository inboxNoticeNodeRepository = f230502e;
        IGuildInboxRedService s16 = inboxNoticeNodeRepository.s();
        AppInterface appInterface2 = appInterface;
        if (appInterface2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appInterface");
            appInterface2 = null;
        }
        if (!s16.fetchNoticeRedPoint(appInterface2)) {
            if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
                inboxNoticeNodeRepository.x(NotifyListenerSource.NotTriggerFetchRedPoint);
            } else {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.message.directmessage.model.repositories.InboxNoticeNodeRepository$fetchNotice$$inlined$ensureUiThread$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        InboxNoticeNodeRepository.f230502e.x(InboxNoticeNodeRepository.NotifyListenerSource.NotTriggerFetchRedPoint);
                    }
                });
            }
        }
    }

    private final void p(int noticeType, com.tencent.mobileqq.guild.base.repository.h<co> callback) {
        ResultDispatcher resultDispatcher = new ResultDispatcher("fetchNotice", callback, getRepositoryCallbackConfig().getInlineDispatcher());
        if (!NetworkUtil.isNetworkAvailable()) {
            ri1.a b16 = ri1.a.b(-93, "\u76ee\u524d\u6ca1\u6709\u7f51\u7edc\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5!");
            Intrinsics.checkNotNullExpressionValue(b16, "error(GProStateCode.ERRO\u2026R_NETWORK_NOTSUPPORT_MSG)");
            resultDispatcher.b(b16);
        } else {
            IGPSService r16 = f230502e.r();
            final Function3 a16 = resultDispatcher.a();
            r16.fetchNewestNotice(noticeType, "", new al() { // from class: com.tencent.mobileqq.guild.message.directmessage.model.repositories.k
                @Override // vh2.al
                public final void a(int i3, String str, co coVar) {
                    InboxNoticeNodeRepository.q(Function3.this, i3, str, coVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(Function3 tmp0, int i3, String str, co coVar) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(Integer.valueOf(i3), str, coVar);
    }

    private final IGPSService r() {
        ServiceCache$LazyHolder serviceCache$LazyHolder = serviceHolder;
        if (serviceCache$LazyHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceHolder");
            serviceCache$LazyHolder = null;
        }
        return serviceCache$LazyHolder.b();
    }

    private final IGuildInboxRedService s() {
        ServiceCache$LazyHolder serviceCache$LazyHolder = serviceHolder;
        if (serviceCache$LazyHolder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceHolder");
            serviceCache$LazyHolder = null;
        }
        return serviceCache$LazyHolder.d();
    }

    @NotNull
    public static final List<InboxNoticeNode> t() {
        return noticeNodes;
    }

    @JvmStatic
    @NotNull
    public static final InboxNoticeNode u(int noticeType) {
        InboxNoticeNode inboxNoticeNode = noticesWithType.get(Integer.valueOf(noticeType));
        if (inboxNoticeNode != null) {
            return inboxNoticeNode;
        }
        throw new IllegalArgumentException(("\u672a\u627e\u5230\u5bf9\u5e94\u7684\u901a\u77e5\u7c7b\u578b: " + noticeType).toString());
    }

    @JvmStatic
    public static final boolean v(int noticeType) {
        if (visibleNoticeTypes.contains(Integer.valueOf(noticeType)) && w(String.valueOf(noticeType))) {
            return true;
        }
        return false;
    }

    @JvmStatic
    public static final boolean w(@NotNull String noticeType) {
        Intrinsics.checkNotNullParameter(noticeType, "noticeType");
        invisibleNotifyTypeSet.g();
        return !r0.contains(noticeType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @UiThread
    public final void x(NotifyListenerSource messageChange) {
        if (!AppSetting.isPublicVersion() && QLog.isColorLevel()) {
            Logger.f235387a.d().d("Guild.C2C.InboxNoticeNodeRepository", 1, "notifyListener from " + messageChange);
            for (InboxNoticeNode inboxNoticeNode : noticeNodes) {
                Logger.f235387a.d().d("Guild.C2C.InboxNoticeNodeRepository", 1, "notifyListener " + inboxNoticeNode.b());
            }
        }
        Iterator<T> it = listeners.iterator();
        while (it.hasNext()) {
            ((m) it.next()).d9(noticeNodes);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y() {
        boolean z16;
        boolean z17;
        boolean z18;
        loop0: while (true) {
            z16 = false;
            for (InboxNoticeNode inboxNoticeNode : noticeNodes) {
                if (inboxNoticeNode.getRedPoint().f265932b > 0 && visibleNoticeTypes.contains(Integer.valueOf(inboxNoticeNode.getType()))) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!z17 && !v(inboxNoticeNode.getType())) {
                    z18 = false;
                } else {
                    z18 = true;
                }
                boolean l3 = inboxNoticeNode.l(z18);
                if (z16 || l3) {
                    z16 = true;
                }
            }
        }
        if (z16) {
            ThreadUtils threadUtils = ThreadUtils.f235400a;
            if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
                f230502e.x(NotifyListenerSource.VisibleLoadedChange);
            } else {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.message.directmessage.model.repositories.InboxNoticeNodeRepository$onNotifyTypeSetLoaded$$inlined$ensureUiThread$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        InboxNoticeNodeRepository.f230502e.x(InboxNoticeNodeRepository.NotifyListenerSource.VisibleLoadedChange);
                    }
                });
            }
        }
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.C2C.InboxNoticeNodeRepository", 2, "onNotifyTypeSetLoaded " + invisibleNotifyTypeSet);
        }
    }

    @JvmStatic
    public static final void z(@NotNull m listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        listeners.remove(listener);
    }

    @Override // com.tencent.mobileqq.guild.base.repository.b
    @NotNull
    /* renamed from: a */
    public RepositoryCallbackConfig getRepositoryCallbackConfig() {
        return this.f230507d.getRepositoryCallbackConfig();
    }

    @Override // com.tencent.mobileqq.guild.base.repository.a
    public void onAccountChanged(@NotNull String account) {
        Intrinsics.checkNotNullParameter(account, "account");
        l();
        B();
        x(NotifyListenerSource.AccountChange);
    }
}
