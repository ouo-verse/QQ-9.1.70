package com.tencent.qqnt.chats.main.vm.datasource;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.biz.guild.GuildLayoutManager;
import com.tencent.qqnt.chats.main.api.IMainChatEarManager;
import com.tencent.qqnt.chats.main.vm.datasource.LocalChatsCacheDataSource;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.aa;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactListChangedInfo;
import com.tencent.qqnt.kernel.nativeinterface.cq;
import com.tencent.qqnt.kernel.utils.n;
import com.tencent.state.data.SquareJSConst;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00aa\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 !2\u00020\u0001:\u00027*B5\u0012\u0006\u0010B\u001a\u00020>\u0012\f\u0010G\u001a\b\u0012\u0004\u0012\u00020C0\u0002\u0012\f\u0010J\u001a\b\u0012\u0004\u0012\u00020H0\u0002\u0012\b\b\u0002\u0010L\u001a\u00020\u0007\u00a2\u0006\u0004\bg\u0010hJ2\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002H\u0002J,\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\u0006\u0010\r\u001a\u00020\fH\u0002J4\u0010\u0011\u001a\u00020\u000e2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0002J@\u0010\u001a\u001a\u00020\u000e2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00070\u00122\u001a\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0013\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00150\u00122\u0006\u0010\u0019\u001a\u00020\u0018H\u0002JD\u0010\u001e\u001a\u00020\u000e2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00130\u00022\u0016\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u001bj\b\u0012\u0004\u0012\u00020\u0003`\u001c2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010!\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u001fH\u0002J\u0010\u0010#\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0005H\u0002J\u0010\u0010$\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0013H\u0002J\u0018\u0010'\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0007H\u0016J\u000e\u0010(\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020%J,\u0010*\u001a\u00020\u000e2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\u0006\u0010&\u001a\u00020\u0007H\u0016J\u0018\u0010.\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020\u00182\u0006\u0010-\u001a\u00020,H\u0016J\b\u0010/\u001a\u00020\u000eH\u0016J\u0016\u00101\u001a\u00020\u000e2\f\u00100\u001a\b\u0012\u0004\u0012\u00020,0\u0002H\u0016J\u0016\u00103\u001a\u00020\u000e2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J$\u00107\u001a\u00020\u000e2\u0006\u00104\u001a\u00020\u00182\b\u00105\u001a\u0004\u0018\u00010,2\b\u00106\u001a\u0004\u0018\u00010\u0005H\u0016J>\u00108\u001a\u00020\u000e2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00070\u00122\u001a\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0013\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00150\u00122\u0006\u0010\u0019\u001a\u00020\u0018J\u000e\u00109\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0002J\u000e\u0010:\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0002J\u000e\u0010;\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0002J\u0006\u0010<\u001a\u00020\u000eJ\u0006\u0010=\u001a\u00020\u000eR\u0017\u0010B\u001a\u00020>8\u0006\u00a2\u0006\f\n\u0004\b7\u0010?\u001a\u0004\b@\u0010AR\u001d\u0010G\u001a\b\u0012\u0004\u0012\u00020C0\u00028\u0006\u00a2\u0006\f\n\u0004\b*\u0010D\u001a\u0004\bE\u0010FR\u001d\u0010J\u001a\b\u0012\u0004\u0012\u00020H0\u00028\u0006\u00a2\u0006\f\n\u0004\b3\u0010D\u001a\u0004\bI\u0010FR\u0017\u0010L\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b1\u0010K\u001a\u0004\bL\u0010MR6\u0010Q\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0013\u0018\u00010Nj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0013\u0018\u0001`O8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010PR6\u0010R\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0013\u0018\u00010Nj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0013\u0018\u0001`O8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010PR\u0014\u0010U\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u001d\u0010[\u001a\b\u0012\u0004\u0012\u00020\u001f0V8\u0006\u00a2\u0006\f\n\u0004\bW\u0010X\u001a\u0004\bY\u0010ZR$\u0010c\u001a\u0004\u0018\u00010\\8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\u0014\u0010f\u001a\u00020d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010e\u00a8\u0006i"}, d2 = {"Lcom/tencent/qqnt/chats/main/vm/datasource/LocalChatsCacheDataSource;", "Lcom/tencent/qqnt/chats/main/vm/datasource/e;", "", "", "list", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "filterList", "", "partRefresh", "t", "changedList", DomainData.DOMAIN_NAME, "Lcom/tencent/qqnt/chats/main/vm/datasource/LocalChatsCacheDataSource$b;", "ext", "", "B", "start", "j", "Lkotlin/Function1;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", "opChanged", "", "", "opGetPayload", "", "from", "u", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "filterIdSet", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/qqnt/chats/data/b;", "data", "k", "info", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactListChangedInfo;", "isGuildUpdate", "f", "w", "sortedContactList", "b", NotificationCompat.CATEGORY_ERROR, "", "msg", "e", "onLitterEarChange", "uidList", "d", SquareJSConst.Params.PARAMS_UIN_LIST, "c", "result", "errMsg", "curSpecifyInfo", "a", "v", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "o", "y", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, HippyTKDListViewAdapter.X, "Lcom/tencent/qqnt/chats/data/converter/b;", "Lcom/tencent/qqnt/chats/data/converter/b;", "p", "()Lcom/tencent/qqnt/chats/data/converter/b;", "chatsItemConverter", "Lcom/tencent/qqnt/chats/main/vm/datasource/filter/b;", "Ljava/util/List;", "getPlatformDateFilterList", "()Ljava/util/List;", "platformDateFilterList", "Lcom/tencent/qqnt/chats/main/vm/datasource/filter/a;", ReportConstant.COSTREPORT_PREFIX, "localDateFilterList", "Z", "isSupportGuild", "()Z", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "Ljava/util/LinkedHashMap;", "chatsListCacheMap", "chatsListCacheMapAll", "g", "Ljava/lang/Object;", "updateLock", "Lcom/tencent/qqnt/chats/data/c;", h.F, "Lcom/tencent/qqnt/chats/data/c;", "r", "()Lcom/tencent/qqnt/chats/data/c;", "dataNotify", "Lcom/tencent/qqnt/chats/main/vm/datasource/d;", "i", "Lcom/tencent/qqnt/chats/main/vm/datasource/d;", "getExtActionCallback", "()Lcom/tencent/qqnt/chats/main/vm/datasource/d;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lcom/tencent/qqnt/chats/main/vm/datasource/d;)V", "extActionCallback", "Lcom/tencent/qqnt/chats/main/vm/datasource/b;", "Lcom/tencent/qqnt/chats/main/vm/datasource/b;", "procExecutor", "<init>", "(Lcom/tencent/qqnt/chats/data/converter/b;Ljava/util/List;Ljava/util/List;Z)V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class LocalChatsCacheDataSource implements e {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    private static AtomicBoolean f355312l;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.chats.data.converter.b chatsItemConverter;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<com.tencent.qqnt.chats.main.vm.datasource.filter.b> platformDateFilterList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<com.tencent.qqnt.chats.main.vm.datasource.filter.a> localDateFilterList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean isSupportGuild;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LinkedHashMap<Long, com.tencent.qqnt.chats.core.adapter.itemdata.g> chatsListCacheMap;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LinkedHashMap<Long, com.tencent.qqnt.chats.core.adapter.itemdata.g> chatsListCacheMapAll;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Object updateLock;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.chats.data.c<com.tencent.qqnt.chats.data.b> dataNotify;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private d extActionCallback;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.chats.main.vm.datasource.b procExecutor;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/chats/main/vm/datasource/LocalChatsCacheDataSource$a;", "", "", "FIRST_DATA_PROCESS_COUNT", "I", "", "TAG", "Ljava/lang/String;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isFirstDataProcess", "Ljava/util/concurrent/atomic/AtomicBoolean;", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.main.vm.datasource.LocalChatsCacheDataSource$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0012\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR$\u0010\u0019\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\t\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001c\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\n\u001a\u0004\b\u0014\u0010\f\"\u0004\b\u001b\u0010\u000eR\"\u0010\u001e\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u001a\u0010\f\"\u0004\b\u001d\u0010\u000e\u00a8\u0006!"}, d2 = {"Lcom/tencent/qqnt/chats/main/vm/datasource/LocalChatsCacheDataSource$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "e", "()Z", "setPartRefresh", "(Z)V", "isPartRefresh", "b", "f", "isFirst", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactListChangedInfo;", "c", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactListChangedInfo;", "()Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactListChangedInfo;", "setInfo", "(Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactListChangedInfo;)V", "info", "d", "setGuildUpdate", "isGuildUpdate", "setLocal", "isLocal", "<init>", "(ZZLcom/tencent/qqnt/kernel/nativeinterface/RecentContactListChangedInfo;ZZ)V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final /* data */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private boolean isPartRefresh;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private boolean isFirst;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private RecentContactListChangedInfo info;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private boolean isGuildUpdate;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private boolean isLocal;

        public b() {
            this(false, false, null, false, false, 31, null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 22)) {
                return;
            }
            iPatchRedirector.redirect((short) 22, (Object) this);
        }

        @Nullable
        public final RecentContactListChangedInfo a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (RecentContactListChangedInfo) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return this.info;
        }

        public final boolean b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
            }
            return this.isFirst;
        }

        public final boolean c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
            }
            return this.isGuildUpdate;
        }

        public final boolean d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
            }
            return this.isLocal;
        }

        public final boolean e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return this.isPartRefresh;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
                return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof b)) {
                return false;
            }
            b bVar = (b) other;
            if (this.isPartRefresh == bVar.isPartRefresh && this.isFirst == bVar.isFirst && Intrinsics.areEqual(this.info, bVar.info) && this.isGuildUpdate == bVar.isGuildUpdate && this.isLocal == bVar.isLocal) {
                return true;
            }
            return false;
        }

        public final void f(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, z16);
            } else {
                this.isFirst = z16;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v11 */
        /* JADX WARN: Type inference failed for: r0v15 */
        /* JADX WARN: Type inference failed for: r0v2, types: [int] */
        /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
        /* JADX WARN: Type inference failed for: r2v5, types: [boolean] */
        public int hashCode() {
            int hashCode;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
                return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
            }
            boolean z16 = this.isPartRefresh;
            int i3 = 1;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int i16 = r06 * 31;
            ?? r26 = this.isFirst;
            int i17 = r26;
            if (r26 != 0) {
                i17 = 1;
            }
            int i18 = (i16 + i17) * 31;
            RecentContactListChangedInfo recentContactListChangedInfo = this.info;
            if (recentContactListChangedInfo == null) {
                hashCode = 0;
            } else {
                hashCode = recentContactListChangedInfo.hashCode();
            }
            int i19 = (i18 + hashCode) * 31;
            ?? r27 = this.isGuildUpdate;
            int i26 = r27;
            if (r27 != 0) {
                i26 = 1;
            }
            int i27 = (i19 + i26) * 31;
            boolean z17 = this.isLocal;
            if (!z17) {
                i3 = z17 ? 1 : 0;
            }
            return i27 + i3;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
                return (String) iPatchRedirector.redirect((short) 19, (Object) this);
            }
            return "ExtParam(isPartRefresh=" + this.isPartRefresh + ", isFirst=" + this.isFirst + ", info=" + this.info + ", isGuildUpdate=" + this.isGuildUpdate + ", isLocal=" + this.isLocal + ")";
        }

        public b(boolean z16, boolean z17, @Nullable RecentContactListChangedInfo recentContactListChangedInfo, boolean z18, boolean z19) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), Boolean.valueOf(z17), recentContactListChangedInfo, Boolean.valueOf(z18), Boolean.valueOf(z19));
                return;
            }
            this.isPartRefresh = z16;
            this.isFirst = z17;
            this.info = recentContactListChangedInfo;
            this.isGuildUpdate = z18;
            this.isLocal = z19;
        }

        public /* synthetic */ b(boolean z16, boolean z17, RecentContactListChangedInfo recentContactListChangedInfo, boolean z18, boolean z19, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? false : z16, (i3 & 2) != 0 ? false : z17, (i3 & 4) != 0 ? null : recentContactListChangedInfo, (i3 & 8) != 0 ? false : z18, (i3 & 16) != 0 ? false : z19);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17), recentContactListChangedInfo, Boolean.valueOf(z18), Boolean.valueOf(z19), Integer.valueOf(i3), defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46064);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 24)) {
            redirector.redirect((short) 24);
        } else {
            INSTANCE = new Companion(null);
            f355312l = new AtomicBoolean(true);
        }
    }

    public LocalChatsCacheDataSource(@NotNull com.tencent.qqnt.chats.data.converter.b chatsItemConverter, @NotNull List<? extends com.tencent.qqnt.chats.main.vm.datasource.filter.b> platformDateFilterList, @NotNull List<? extends com.tencent.qqnt.chats.main.vm.datasource.filter.a> localDateFilterList, boolean z16) {
        Intrinsics.checkNotNullParameter(chatsItemConverter, "chatsItemConverter");
        Intrinsics.checkNotNullParameter(platformDateFilterList, "platformDateFilterList");
        Intrinsics.checkNotNullParameter(localDateFilterList, "localDateFilterList");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, chatsItemConverter, platformDateFilterList, localDateFilterList, Boolean.valueOf(z16));
            return;
        }
        this.chatsItemConverter = chatsItemConverter;
        this.platformDateFilterList = platformDateFilterList;
        this.localDateFilterList = localDateFilterList;
        this.isSupportGuild = z16;
        this.updateLock = new Object();
        this.dataNotify = new com.tencent.qqnt.chats.data.c<>();
        this.procExecutor = new com.tencent.qqnt.chats.main.vm.datasource.b();
    }

    private final void B(List<Long> list, List<RecentContactInfo> changedList, b ext) {
        List<com.tencent.qqnt.chats.core.adapter.itemdata.g> h16;
        if (!f355312l.get() && ext.d()) {
            QLog.i("LocalChatsCacheDataSource", 1, "local data notify before msg list first screen");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        HashSet<Long> hashSet = new HashSet<>();
        List<RecentContactInfo> n3 = n(changedList);
        ArrayList arrayList = new ArrayList();
        for (Object obj : n3) {
            if (m((RecentContactInfo) obj)) {
                arrayList.add(obj);
            }
        }
        if (f355312l.compareAndSet(true, false)) {
            QLog.d("LocalChatsCacheDataSource", 1, "firstTime: " + arrayList.size());
            ext.f(true);
            h16 = this.procExecutor.h(t(list, arrayList, ext.e()), this.chatsItemConverter, this.localDateFilterList, hashSet, ext);
            if (!ext.d()) {
                j(list, arrayList, currentTimeMillis, ext);
            }
        } else {
            h16 = this.procExecutor.h(arrayList, this.chatsItemConverter, this.localDateFilterList, hashSet, ext);
        }
        QLog.i("LocalChatsCacheDataSource", 1, "updateChatListByRemote filter cost: " + (System.currentTimeMillis() - currentTimeMillis) + ", size: " + h16.size());
        C(list, h16, hashSet, ext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00f4 A[Catch: all -> 0x01ee, TryCatch #0 {, blocks: (B:9:0x0034, B:10:0x0041, B:12:0x0047, B:15:0x005e, B:20:0x0062, B:21:0x0066, B:23:0x006c, B:43:0x0082, B:26:0x0091, B:28:0x0095, B:30:0x00a4, B:31:0x00ab, B:34:0x00af, B:37:0x00be, B:46:0x00c6, B:48:0x00cc, B:50:0x00d0, B:51:0x00d2, B:54:0x00e0, B:57:0x00e8, B:62:0x00f4, B:64:0x00fc, B:65:0x0100, B:67:0x0123, B:68:0x0172, B:71:0x0192, B:76:0x01bc, B:77:0x01ea, B:82:0x01a0, B:84:0x012a, B:85:0x01c8), top: B:8:0x0034 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01c8 A[Catch: all -> 0x01ee, TryCatch #0 {, blocks: (B:9:0x0034, B:10:0x0041, B:12:0x0047, B:15:0x005e, B:20:0x0062, B:21:0x0066, B:23:0x006c, B:43:0x0082, B:26:0x0091, B:28:0x0095, B:30:0x00a4, B:31:0x00ab, B:34:0x00af, B:37:0x00be, B:46:0x00c6, B:48:0x00cc, B:50:0x00d0, B:51:0x00d2, B:54:0x00e0, B:57:0x00e8, B:62:0x00f4, B:64:0x00fc, B:65:0x0100, B:67:0x0123, B:68:0x0172, B:71:0x0192, B:76:0x01bc, B:77:0x01ea, B:82:0x01a0, B:84:0x012a, B:85:0x01c8), top: B:8:0x0034 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void C(List<Long> list, List<com.tencent.qqnt.chats.core.adapter.itemdata.g> changedList, HashSet<Long> filterIdSet, b ext) {
        boolean z16;
        Object first;
        boolean z17;
        com.tencent.qqnt.chats.data.a aVar;
        HashMap hashMap = new HashMap();
        LinkedHashMap<Long, com.tencent.qqnt.chats.core.adapter.itemdata.g> linkedHashMap = new LinkedHashMap<>();
        LinkedHashMap<Long, com.tencent.qqnt.chats.core.adapter.itemdata.g> linkedHashMap2 = new LinkedHashMap<>();
        for (com.tencent.qqnt.chats.core.adapter.itemdata.g gVar : changedList) {
            hashMap.put(Long.valueOf(gVar.m()), gVar);
        }
        synchronized (this.updateLock) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (!filterIdSet.contains(Long.valueOf(((Number) obj).longValue()))) {
                    arrayList.add(obj);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                long longValue = ((Number) it.next()).longValue();
                com.tencent.qqnt.chats.core.adapter.itemdata.g gVar2 = (com.tencent.qqnt.chats.core.adapter.itemdata.g) hashMap.get(Long.valueOf(longValue));
                if (gVar2 != null) {
                    linkedHashMap.put(Long.valueOf(longValue), gVar2);
                    linkedHashMap2.put(Long.valueOf(longValue), gVar2);
                } else {
                    LinkedHashMap<Long, com.tencent.qqnt.chats.core.adapter.itemdata.g> linkedHashMap3 = this.chatsListCacheMap;
                    if (linkedHashMap3 != null) {
                        Intrinsics.checkNotNull(linkedHashMap3);
                        com.tencent.qqnt.chats.core.adapter.itemdata.g gVar3 = linkedHashMap3.get(Long.valueOf(longValue));
                        if (gVar3 != null) {
                            linkedHashMap.put(Long.valueOf(longValue), gVar3);
                        }
                    }
                    LinkedHashMap<Long, com.tencent.qqnt.chats.core.adapter.itemdata.g> linkedHashMap4 = this.chatsListCacheMapAll;
                    if (linkedHashMap4 != null) {
                        Intrinsics.checkNotNull(linkedHashMap4);
                        com.tencent.qqnt.chats.core.adapter.itemdata.g gVar4 = linkedHashMap4.get(Long.valueOf(longValue));
                        if (gVar4 != null) {
                            linkedHashMap2.put(Long.valueOf(longValue), gVar4);
                        }
                    }
                }
            }
            if (!ext.c() && this.isSupportGuild) {
                this.chatsListCacheMapAll = linkedHashMap2;
            }
            boolean s16 = GuildLayoutManager.f354256a.s();
            if (this.isSupportGuild && ((!s16 || !ext.c()) && (s16 || ext.c()))) {
                z16 = false;
                if (!z16) {
                    this.chatsListCacheMap = linkedHashMap;
                    List<com.tencent.qqnt.chats.core.adapter.itemdata.g> q16 = q();
                    if (q16 == null) {
                        q16 = CollectionsKt__CollectionsKt.emptyList();
                    }
                    List<com.tencent.qqnt.chats.core.adapter.itemdata.g> list2 = q16;
                    StringBuilder sb5 = new StringBuilder("emit chats list:");
                    sb5.append(list2.size());
                    sb5.append(", partRefresh: ");
                    sb5.append(ext.e());
                    if (hashMap.isEmpty()) {
                        sb5.append(", changeFirst=empty");
                    } else {
                        Collection values = hashMap.values();
                        Intrinsics.checkNotNullExpressionValue(values, "changeChatsList.values");
                        first = CollectionsKt___CollectionsKt.first(values);
                        Intrinsics.checkNotNullExpressionValue(first, "changeChatsList.values.first()");
                        com.tencent.qqnt.chats.core.adapter.itemdata.g gVar5 = (com.tencent.qqnt.chats.core.adapter.itemdata.g) first;
                        sb5.append(", changeFirst={title=");
                        sb5.append(cq.w(gVar5.w().e(), 2));
                        sb5.append(",hashCode=");
                        sb5.append(gVar5.hashCode());
                        sb5.append(",unread=");
                        sb5.append(gVar5.x());
                    }
                    QLog.d("LocalChatsCacheDataSource", 1, sb5.toString());
                    RecentContactListChangedInfo a16 = ext.a();
                    int size = list.size();
                    boolean e16 = ext.e();
                    if (this.isSupportGuild && s16 && ext.c()) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (a16 == null) {
                        aVar = null;
                    } else {
                        aVar = new com.tencent.qqnt.chats.data.a((int) a16.cacheLocation, a16.firstContactPos, a16.atTheTop, a16.atTheBottom, a16.moreDataAtTheBottom);
                    }
                    k(new com.tencent.qqnt.chats.data.b(list2, size, false, e16, 0, z17, aVar, 20, null));
                } else {
                    QLog.d("LocalChatsCacheDataSource", 1, "emit chats return partRefresh: " + ext.e() + ", no needNotify");
                }
                Unit unit = Unit.INSTANCE;
            }
            z16 = true;
            if (!z16) {
            }
            Unit unit2 = Unit.INSTANCE;
        }
    }

    private final void j(final List<Long> list, final List<RecentContactInfo> changedList, final long start, final b ext) {
        n.f359273a.h(new Function0<Unit>(changedList, ext, start, list) { // from class: com.tencent.qqnt.chats.main.vm.datasource.LocalChatsCacheDataSource$dispatchDelayUpdate$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ List<RecentContactInfo> $changedList;
            final /* synthetic */ LocalChatsCacheDataSource.b $ext;
            final /* synthetic */ List<Long> $list;
            final /* synthetic */ long $start;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$changedList = changedList;
                this.$ext = ext;
                this.$start = start;
                this.$list = list;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, LocalChatsCacheDataSource.this, changedList, ext, Long.valueOf(start), list);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                b bVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                HashSet<Long> hashSet = new HashSet<>();
                bVar = LocalChatsCacheDataSource.this.procExecutor;
                List<com.tencent.qqnt.chats.core.adapter.itemdata.g> h16 = bVar.h(this.$changedList, LocalChatsCacheDataSource.this.p(), LocalChatsCacheDataSource.this.s(), hashSet, this.$ext);
                QLog.i("LocalChatsCacheDataSource", 1, "slice List filter cost: " + (System.currentTimeMillis() - this.$start));
                LocalChatsCacheDataSource.this.C(this.$list, h16, hashSet, this.$ext);
            }
        });
    }

    private final void k(com.tencent.qqnt.chats.data.b data) {
        this.dataNotify.d(data);
    }

    private final boolean l(com.tencent.qqnt.chats.core.adapter.itemdata.g info) {
        Iterator<T> it = this.localDateFilterList.iterator();
        while (it.hasNext()) {
            if (((com.tencent.qqnt.chats.main.vm.datasource.filter.a) it.next()).a(info)) {
                return false;
            }
        }
        return true;
    }

    private final boolean m(RecentContactInfo info) {
        if (c.f355411a.a(info)) {
            return false;
        }
        Iterator<T> it = this.platformDateFilterList.iterator();
        while (it.hasNext()) {
            if (((com.tencent.qqnt.chats.main.vm.datasource.filter.b) it.next()).a(info)) {
                return false;
            }
        }
        return true;
    }

    private final List<RecentContactInfo> n(List<RecentContactInfo> changedList) {
        boolean z16;
        List<RecentContactInfo> list;
        aa recentContactService;
        if (this.chatsItemConverter.c() != 1) {
            return changedList;
        }
        LinkedHashMap<Long, com.tencent.qqnt.chats.core.adapter.itemdata.g> linkedHashMap = this.chatsListCacheMapAll;
        boolean z17 = false;
        if (linkedHashMap != null && !linkedHashMap.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            IKernelService i3 = com.tencent.qqnt.msg.f.i();
            if (i3 != null && (recentContactService = i3.getRecentContactService()) != null) {
                list = recentContactService.M(this.chatsItemConverter.c());
            } else {
                list = null;
            }
            List<RecentContactInfo> list2 = list;
            if (list2 == null || list2.isEmpty()) {
                z17 = true;
            }
            if (!z17) {
                QLog.d("LocalChatsCacheDataSource", 1, "[forceValidChangeData] origin data is reset, use cache.");
                return list;
            }
        }
        return changedList;
    }

    private final List<RecentContactInfo> t(List<Long> list, List<RecentContactInfo> filterList, boolean partRefresh) {
        HashSet hashSet;
        int min = Math.min(12, filterList.size());
        if (list.size() >= min) {
            hashSet = CollectionsKt___CollectionsKt.toHashSet(list.subList(0, min));
            ArrayList arrayList = new ArrayList(min);
            for (RecentContactInfo recentContactInfo : filterList) {
                if (hashSet.contains(Long.valueOf(recentContactInfo.contactId))) {
                    arrayList.add(recentContactInfo);
                }
            }
            return arrayList;
        }
        return filterList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(Function1<? super com.tencent.qqnt.chats.core.adapter.itemdata.g, Boolean> opChanged, Function1<? super com.tencent.qqnt.chats.core.adapter.itemdata.g, Object[]> opGetPayload, int from) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        HashSet<Long> hashSet = new HashSet<>();
        List<com.tencent.qqnt.chats.core.adapter.itemdata.g> o16 = o();
        if (o16 != null) {
            for (com.tencent.qqnt.chats.core.adapter.itemdata.g gVar : o16) {
                arrayList2.add(Long.valueOf(gVar.m()));
                if (opChanged.invoke(gVar).booleanValue()) {
                    com.tencent.qqnt.chats.core.adapter.itemdata.g f16 = gVar.f();
                    com.tencent.qqnt.chats.data.converter.b.h(this.chatsItemConverter, f16, com.tencent.qqnt.chats.core.adapter.itemdata.f.f354528a.b(opGetPayload.invoke(gVar)), false, 4, null);
                    if (l(f16)) {
                        arrayList.add(f16);
                    } else {
                        hashSet.add(Long.valueOf(f16.m()));
                    }
                }
            }
        }
        QLog.d("LocalChatsCacheDataSource", 1, "notifyMultiDiffChange: changedSize=" + arrayList.size() + ", totalSize=" + arrayList2.size() + ", from=" + from);
        if (!arrayList.isEmpty()) {
            C(arrayList2, arrayList, hashSet, new b(true, false, null, false, false, 30, null));
        }
    }

    public final void A(@Nullable d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) dVar);
        } else {
            this.extActionCallback = dVar;
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.e
    public void a(int result, @Nullable String errMsg, @Nullable RecentContactInfo curSpecifyInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Integer.valueOf(result), errMsg, curSpecifyInfo);
            return;
        }
        d dVar = this.extActionCallback;
        if (dVar != null) {
            dVar.a(result, errMsg, curSpecifyInfo);
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.e
    public void b(@NotNull List<Long> sortedContactList, @NotNull List<RecentContactInfo> changedList, boolean isGuildUpdate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, sortedContactList, changedList, Boolean.valueOf(isGuildUpdate));
            return;
        }
        Intrinsics.checkNotNullParameter(sortedContactList, "sortedContactList");
        Intrinsics.checkNotNullParameter(changedList, "changedList");
        B(sortedContactList, changedList, new b(true, false, null, isGuildUpdate, false, 22, null));
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.e
    public void c(@NotNull final List<Long> uinList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) uinList);
        } else {
            Intrinsics.checkNotNullParameter(uinList, "uinList");
            v(new Function1<com.tencent.qqnt.chats.core.adapter.itemdata.g, Boolean>(uinList) { // from class: com.tencent.qqnt.chats.main.vm.datasource.LocalChatsCacheDataSource$onAvatarChangeUin$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ List<Long> $uinList;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$uinList = uinList;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) uinList);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g it) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Boolean) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    }
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.valueOf(this.$uinList.contains(Long.valueOf(it.l())));
                }
            }, LocalChatsCacheDataSource$onAvatarChangeUin$2.INSTANCE, 0);
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.e
    public void d(@NotNull final List<String> uidList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) uidList);
        } else {
            Intrinsics.checkNotNullParameter(uidList, "uidList");
            v(new Function1<com.tencent.qqnt.chats.core.adapter.itemdata.g, Boolean>(uidList) { // from class: com.tencent.qqnt.chats.main.vm.datasource.LocalChatsCacheDataSource$onAvatarChangeUid$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ List<String> $uidList;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$uidList = uidList;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) uidList);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g it) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Boolean) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    }
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.valueOf(this.$uidList.contains(it.k()));
                }
            }, LocalChatsCacheDataSource$onAvatarChangeUid$2.INSTANCE, 0);
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.e
    public void e(int err, @NotNull String msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, err, (Object) msg2);
        } else {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            this.dataNotify.c(err, msg2);
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.e
    public void f(@NotNull RecentContactListChangedInfo info, boolean isGuildUpdate) {
        List<com.tencent.qqnt.chats.core.adapter.itemdata.g> emptyList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, info, Boolean.valueOf(isGuildUpdate));
            return;
        }
        Intrinsics.checkNotNullParameter(info, "info");
        QLog.d("LocalChatsCacheDataSource", 2, "onRecentContactListChanged s1=: " + info.sortedContactList.size() + ",s2= " + info.changedList.size() + "\"");
        com.tencent.qqnt.chats.perf.a.c(com.tencent.qqnt.chats.perf.a.f355516a, true, false, 2, null);
        if (info.sortedContactList.isEmpty()) {
            ArrayList<Long> arrayList = info.sortedContactList;
            Intrinsics.checkNotNullExpressionValue(arrayList, "info.sortedContactList");
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            C(arrayList, emptyList, new HashSet<>(), new b(false, false, null, isGuildUpdate, false, 23, null));
            return;
        }
        ArrayList<Long> arrayList2 = info.sortedContactList;
        Intrinsics.checkNotNullExpressionValue(arrayList2, "info.sortedContactList");
        ArrayList<RecentContactInfo> arrayList3 = info.changedList;
        Intrinsics.checkNotNullExpressionValue(arrayList3, "info.changedList");
        B(arrayList2, arrayList3, new b(false, false, info, isGuildUpdate, false, 19, null));
    }

    @Nullable
    public final List<com.tencent.qqnt.chats.core.adapter.itemdata.g> o() {
        List<com.tencent.qqnt.chats.core.adapter.itemdata.g> list;
        Collection<com.tencent.qqnt.chats.core.adapter.itemdata.g> values;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (List) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        if (!this.isSupportGuild) {
            return q();
        }
        synchronized (this.updateLock) {
            LinkedHashMap<Long, com.tencent.qqnt.chats.core.adapter.itemdata.g> linkedHashMap = this.chatsListCacheMapAll;
            if (linkedHashMap != null && (values = linkedHashMap.values()) != null) {
                Intrinsics.checkNotNullExpressionValue(values, "values");
                list = CollectionsKt___CollectionsKt.toList(values);
            } else {
                list = null;
            }
        }
        return list;
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.e
    public void onLitterEarChange() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            ((IMainChatEarManager) QRoute.api(IMainChatEarManager.class)).onLitterEarChange();
        }
    }

    @NotNull
    public final com.tencent.qqnt.chats.data.converter.b p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.qqnt.chats.data.converter.b) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.chatsItemConverter;
    }

    @Nullable
    public final List<com.tencent.qqnt.chats.core.adapter.itemdata.g> q() {
        List<com.tencent.qqnt.chats.core.adapter.itemdata.g> list;
        Collection<com.tencent.qqnt.chats.core.adapter.itemdata.g> values;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (List) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        synchronized (this.updateLock) {
            LinkedHashMap<Long, com.tencent.qqnt.chats.core.adapter.itemdata.g> linkedHashMap = this.chatsListCacheMap;
            if (linkedHashMap != null && (values = linkedHashMap.values()) != null) {
                Intrinsics.checkNotNullExpressionValue(values, "values");
                list = CollectionsKt___CollectionsKt.toList(values);
            } else {
                list = null;
            }
        }
        return list;
    }

    @NotNull
    public final com.tencent.qqnt.chats.data.c<com.tencent.qqnt.chats.data.b> r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (com.tencent.qqnt.chats.data.c) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.dataNotify;
    }

    @NotNull
    public final List<com.tencent.qqnt.chats.main.vm.datasource.filter.a> s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.localDateFilterList;
    }

    public final void v(@NotNull final Function1<? super com.tencent.qqnt.chats.core.adapter.itemdata.g, Boolean> opChanged, @NotNull final Function1<? super com.tencent.qqnt.chats.core.adapter.itemdata.g, Object[]> opGetPayload, final int from) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, opChanged, opGetPayload, Integer.valueOf(from));
            return;
        }
        Intrinsics.checkNotNullParameter(opChanged, "opChanged");
        Intrinsics.checkNotNullParameter(opGetPayload, "opGetPayload");
        n.f359273a.d(new Function0<Unit>(opChanged, opGetPayload, from) { // from class: com.tencent.qqnt.chats.main.vm.datasource.LocalChatsCacheDataSource$notifyMultiDiffChange$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ int $from;
            final /* synthetic */ Function1<com.tencent.qqnt.chats.core.adapter.itemdata.g, Boolean> $opChanged;
            final /* synthetic */ Function1<com.tencent.qqnt.chats.core.adapter.itemdata.g, Object[]> $opGetPayload;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$opChanged = opChanged;
                this.$opGetPayload = opGetPayload;
                this.$from = from;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, LocalChatsCacheDataSource.this, opChanged, opGetPayload, Integer.valueOf(from));
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    LocalChatsCacheDataSource.this.u(this.$opChanged, this.$opGetPayload, this.$from);
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        });
    }

    public final void w(@NotNull RecentContactListChangedInfo info) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) info);
            return;
        }
        Intrinsics.checkNotNullParameter(info, "info");
        QLog.d("LocalChatsCacheDataSource", 1, "onRecentContactListChangeLocal s1=: " + info.sortedContactList.size() + ",s2= " + info.changedList.size() + "\"");
        com.tencent.qqnt.chats.perf.a.f355516a.b(true, true);
        ArrayList<Long> arrayList = info.sortedContactList;
        Intrinsics.checkNotNullExpressionValue(arrayList, "info.sortedContactList");
        ArrayList<RecentContactInfo> arrayList2 = info.changedList;
        Intrinsics.checkNotNullExpressionValue(arrayList2, "info.changedList");
        B(arrayList, arrayList2, new b(false, false, info, false, true, 11, null));
    }

    public final void x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
        } else {
            this.procExecutor.i();
        }
    }

    @Nullable
    public final List<com.tencent.qqnt.chats.core.adapter.itemdata.g> y() {
        List<com.tencent.qqnt.chats.core.adapter.itemdata.g> list;
        Collection<com.tencent.qqnt.chats.core.adapter.itemdata.g> values;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (List) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        synchronized (this.updateLock) {
            LinkedHashMap<Long, com.tencent.qqnt.chats.core.adapter.itemdata.g> linkedHashMap = this.chatsListCacheMapAll;
            this.chatsListCacheMap = linkedHashMap;
            if (linkedHashMap != null && (values = linkedHashMap.values()) != null) {
                Intrinsics.checkNotNullExpressionValue(values, "values");
                list = CollectionsKt___CollectionsKt.toList(values);
            } else {
                list = null;
            }
        }
        return list;
    }

    public final void z() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        LinkedHashMap<Long, com.tencent.qqnt.chats.core.adapter.itemdata.g> linkedHashMap = this.chatsListCacheMapAll;
        if (linkedHashMap != null && !linkedHashMap.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            synchronized (this.updateLock) {
                List<com.tencent.qqnt.chats.core.adapter.itemdata.g> y16 = y();
                if (y16 == null) {
                    y16 = CollectionsKt__CollectionsKt.emptyList();
                }
                List<com.tencent.qqnt.chats.core.adapter.itemdata.g> list = y16;
                QLog.d("LocalChatsCacheDataSource", 1, "getRecentContactFromCache use local: " + list.size());
                k(new com.tencent.qqnt.chats.data.b(list, list.size(), false, false, 0, false, new com.tencent.qqnt.chats.data.a(-1, 0L, false, false, false, 30, null), 52, null));
                Unit unit = Unit.INSTANCE;
            }
            return;
        }
        QLog.d("LocalChatsCacheDataSource", 1, "getRecentContactFromCache fail chatsListCacheMapAll empty");
    }

    public /* synthetic */ LocalChatsCacheDataSource(com.tencent.qqnt.chats.data.converter.b bVar, List list, List list2, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(bVar, list, list2, (i3 & 8) != 0 ? false : z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, bVar, list, list2, Boolean.valueOf(z16), Integer.valueOf(i3), defaultConstructorMarker);
    }
}
