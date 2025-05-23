package com.tencent.qqnt.contacts.cache;

import android.text.TextUtils;
import android.util.LruCache;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.y;
import com.tencent.qqnt.kernel.nativeinterface.BaseInfo;
import com.tencent.qqnt.kernel.nativeinterface.CoreInfo;
import com.tencent.qqnt.kernel.nativeinterface.IKernelProfileListener;
import com.tencent.qqnt.kernel.nativeinterface.Intimate;
import com.tencent.qqnt.kernel.nativeinterface.OtherFlag;
import com.tencent.qqnt.kernel.nativeinterface.RelationFlag;
import com.tencent.qqnt.kernel.nativeinterface.StatusInfo;
import com.tencent.qqnt.kernel.nativeinterface.StockLocalData;
import com.tencent.qqnt.kernel.nativeinterface.UserDetailInfo;
import com.tencent.qqnt.kernel.nativeinterface.UserSimpleInfo;
import com.tencent.qqnt.kernel.nativeinterface.VasInfo;
import com.tencent.qqnt.kernel.nativeinterface.be;
import com.tencent.qqnt.msg.f;
import com.tencent.qqnt.ntrelation.api.IFriendsTABService;
import com.tencent.qqnt.ntrelation.util.j;
import com.tencent.qqnt.ntrelation.util.m;
import com.tencent.qqnt.ntrelation.vasinfo.bean.NTVasSimpleInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00172\u00020\u0001:\u0003*03B\u0007\u00a2\u0006\u0004\b@\u0010AJ:\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0004j\b\u0012\u0004\u0012\u00020\u0002`\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\f\u001a\u00020\nH\u0002J\u001a\u0010\u0010\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u0018\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u0002H\u0002J\u0018\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u0002H\u0002J\u0018\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u0002H\u0002J\u0018\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u0002H\u0002J\b\u0010\u0017\u001a\u00020\nH\u0002J\"\u0010\u0018\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0002J2\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0004j\b\u0012\u0004\u0012\u00020\u0002`\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0002J>\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0002J\u001a\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002J\u0006\u0010\u001e\u001a\u00020\nJ0\u0010\u001f\u001a\u00020\n2\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0004j\b\u0012\u0004\u0012\u00020\u0002`\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0002J\u001c\u0010\"\u001a\u00020\n2\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e\u0018\u00010 J\u000e\u0010#\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0002J\"\u0010$\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0002J\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020&0%J\u0016\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010(2\u0006\u0010\u0003\u001a\u00020\u0002R\u001b\u0010.\u001a\u00020\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R.\u00102\u001a\u001c\u0012\u0004\u0012\u00020\u0002\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\b\u0001\u0012\u00020\u001b0/0%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R \u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020&0%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00101R&\u00106\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020(0%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00101R&\u00109\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u0002070%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00101R\u0016\u0010<\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010>\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010;R\u0016\u0010?\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010;\u00a8\u0006B"}, d2 = {"Lcom/tencent/qqnt/contacts/cache/FriendListInfoCache;", "", "", "cacheType", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "uidList", "", "isFirstInit", "trace", "", "u", h.F, "uid", "Lcom/tencent/qqnt/kernel/nativeinterface/StatusInfo;", "statusInfo", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/qqnt/kernel/nativeinterface/UserSimpleInfo;", "userSimpleInfo", "B", "y", BdhLogUtil.LogTag.Tag_Conn, HippyTKDListViewAdapter.X, "i", "o", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/qqnt/ntrelation/baseinfo/bean/a;", "baseFriendInfo", "w", "t", "v", "Ljava/util/HashMap;", "status", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "j", "k", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/qqnt/contacts/cache/FriendListInfoCache$c;", ReportConstant.COSTREPORT_PREFIX, "Ljava/util/concurrent/CopyOnWriteArrayList;", "r", "a", "Lkotlin/Lazy;", DomainData.DOMAIN_NAME, "()Z", NodeProps.ENABLED, "Lcom/tencent/qqnt/contacts/cache/FriendListInfoCache$b;", "b", "Ljava/util/concurrent/ConcurrentHashMap;", "cacheType2Cache", "c", "lruReportDataMap", "d", "lruSampleUidMap", "Ljava/util/concurrent/CopyOnWriteArraySet;", "e", "needCacheUidMap", "f", "Z", "initLruCacheFinish", "g", "isLogOpen", "mergeUidCacheSwitch", "<init>", "()V", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class FriendListInfoCache {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: j, reason: collision with root package name */
    private static int f355788j;

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    private static final Lazy<FriendListInfoCache> f355789k;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy enabled;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<String, b<String, ? extends com.tencent.qqnt.ntrelation.baseinfo.bean.a>> cacheType2Cache;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<String, c> lruReportDataMap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<String, CopyOnWriteArrayList<String>> lruSampleUidMap;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<String, CopyOnWriteArraySet<String>> needCacheUidMap;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private volatile boolean initLruCacheFinish;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean isLogOpen;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean mergeUidCacheSwitch;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/contacts/cache/FriendListInfoCache$a;", "", "Lcom/tencent/qqnt/contacts/cache/FriendListInfoCache;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/qqnt/contacts/cache/FriendListInfoCache;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "", "CACHE_SIZE", "I", "MAX_SIZE_OF_UPDATE_UID", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.contacts.cache.FriendListInfoCache$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final FriendListInfoCache a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (FriendListInfoCache) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return (FriendListInfoCache) FriendListInfoCache.f355789k.getValue();
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0003*\u00020\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/contacts/cache/FriendListInfoCache$b;", "K", "Lcom/tencent/qqnt/ntrelation/baseinfo/bean/a;", "V", "Landroid/util/LruCache;", "", "maxSize", "<init>", "(I)V", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class b<K, V extends com.tencent.qqnt.ntrelation.baseinfo.bean.a> extends LruCache<K, V> {
        static IPatchRedirector $redirector_;

        public b(int i3) {
            super(i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0016\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0019\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\"\u0010\u001b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0010\u0010\u0013\"\u0004\b\u001a\u0010\u0015R\"\u0010\u001d\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0011\u001a\u0004\b\t\u0010\u0013\"\u0004\b\u001c\u0010\u0015\u00a8\u0006 "}, d2 = {"Lcom/tencent/qqnt/contacts/cache/FriendListInfoCache$c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setSource", "(Ljava/lang/String;)V", "source", "b", "I", "e", "()I", h.F, "(I)V", "totalReqCount", "d", "g", "totalHitCount", "setLruCapacity", "lruCapacity", "f", "lruCacheSize", "<init>", "(Ljava/lang/String;IIII)V", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final /* data */ class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String source;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int totalReqCount;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private int totalHitCount;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int lruCapacity;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private int lruCacheSize;

        public c() {
            this(null, 0, 0, 0, 0, 31, null);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 22)) {
                return;
            }
            iPatchRedirector.redirect((short) 22, (Object) this);
        }

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
            }
            return this.lruCacheSize;
        }

        public final int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
            }
            return this.lruCapacity;
        }

        @NotNull
        public final String c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.source;
        }

        public final int d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
            }
            return this.totalHitCount;
        }

        public final int e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            return this.totalReqCount;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
                return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof c)) {
                return false;
            }
            c cVar = (c) other;
            if (Intrinsics.areEqual(this.source, cVar.source) && this.totalReqCount == cVar.totalReqCount && this.totalHitCount == cVar.totalHitCount && this.lruCapacity == cVar.lruCapacity && this.lruCacheSize == cVar.lruCacheSize) {
                return true;
            }
            return false;
        }

        public final void f(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                iPatchRedirector.redirect((short) 12, (Object) this, i3);
            } else {
                this.lruCacheSize = i3;
            }
        }

        public final void g(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, i3);
            } else {
                this.totalHitCount = i3;
            }
        }

        public final void h(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, i3);
            } else {
                this.totalReqCount = i3;
            }
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
                return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
            }
            return (((((((this.source.hashCode() * 31) + this.totalReqCount) * 31) + this.totalHitCount) * 31) + this.lruCapacity) * 31) + this.lruCacheSize;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
                return (String) iPatchRedirector.redirect((short) 19, (Object) this);
            }
            return "LRUReportData(source=" + this.source + ", totalReqCount=" + this.totalReqCount + ", totalHitCount=" + this.totalHitCount + ", lruCapacity=" + this.lruCapacity + ", lruCacheSize=" + this.lruCacheSize + ")";
        }

        public c(@NotNull String source, int i3, int i16, int i17, int i18) {
            Intrinsics.checkNotNullParameter(source, "source");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, source, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
                return;
            }
            this.source = source;
            this.totalReqCount = i3;
            this.totalHitCount = i16;
            this.lruCapacity = i17;
            this.lruCacheSize = i18;
        }

        public /* synthetic */ c(String str, int i3, int i16, int i17, int i18, int i19, DefaultConstructorMarker defaultConstructorMarker) {
            this((i19 & 1) != 0 ? "" : str, (i19 & 2) != 0 ? 0 : i3, (i19 & 4) != 0 ? 0 : i16, (i19 & 8) != 0 ? 0 : i17, (i19 & 16) != 0 ? 0 : i18);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), defaultConstructorMarker);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\u0007\u001a\u00020\u00062\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/qqnt/contacts/cache/FriendListInfoCache$d", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelProfileListener;", "Ljava/util/HashMap;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/UserSimpleInfo;", "profiles", "", "onProfileSimpleChanged", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class d implements IKernelProfileListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FriendListInfoCache.this);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:40:0x00a8, code lost:
        
            if (r4 != null) goto L49;
         */
        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onProfileSimpleChanged(@Nullable HashMap<String, UserSimpleInfo> profiles) {
            Set<String> keySet;
            BaseInfo baseInfo;
            VasInfo vasInfo;
            Intimate intimate;
            CoreInfo coreInfo;
            RelationFlag relationFlag;
            Long l3;
            Boolean bool;
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) profiles);
                return;
            }
            if (profiles != null && (keySet = profiles.keySet()) != null) {
                for (String uid : keySet) {
                    UserSimpleInfo userSimpleInfo = profiles.get(uid);
                    boolean z16 = true;
                    OtherFlag otherFlag = null;
                    if (QLog.isDebugVersion()) {
                        if (userSimpleInfo != null) {
                            l3 = Long.valueOf(userSimpleInfo.uin);
                        } else {
                            l3 = null;
                        }
                        if (userSimpleInfo != null) {
                            bool = Boolean.valueOf(userSimpleInfo.isBuddy);
                        } else {
                            bool = null;
                        }
                        if (userSimpleInfo != null) {
                            str = userSimpleInfo.uid;
                        } else {
                            str = null;
                        }
                        QLog.i("FriendListInfoCache", 1, "onProfileSimpleChanged uin: " + l3 + " isbuddy\uff1a" + bool + " uid: " + str);
                    }
                    if (userSimpleInfo == null || !userSimpleInfo.isBuddy) {
                        z16 = false;
                    }
                    if (!z16) {
                        FriendListInfoCache friendListInfoCache = FriendListInfoCache.this;
                        Intrinsics.checkNotNullExpressionValue(uid, "uid");
                        friendListInfoCache.j(uid);
                        return;
                    }
                    if (userSimpleInfo != null) {
                        baseInfo = userSimpleInfo.baseInfo;
                    } else {
                        baseInfo = null;
                    }
                    if (baseInfo == null) {
                        if (userSimpleInfo != null) {
                            coreInfo = userSimpleInfo.coreInfo;
                        } else {
                            coreInfo = null;
                        }
                        if (coreInfo == null) {
                            if (userSimpleInfo != null) {
                                relationFlag = userSimpleInfo.relationFlags;
                            } else {
                                relationFlag = null;
                            }
                        }
                    }
                    FriendListInfoCache friendListInfoCache2 = FriendListInfoCache.this;
                    Intrinsics.checkNotNullExpressionValue(uid, "uid");
                    friendListInfoCache2.x(userSimpleInfo, uid);
                    if (userSimpleInfo != null) {
                        vasInfo = userSimpleInfo.vasInfo;
                    } else {
                        vasInfo = null;
                    }
                    if (vasInfo != null) {
                        FriendListInfoCache friendListInfoCache3 = FriendListInfoCache.this;
                        Intrinsics.checkNotNullExpressionValue(uid, "uid");
                        friendListInfoCache3.C(userSimpleInfo, uid);
                    }
                    if (userSimpleInfo != null) {
                        intimate = userSimpleInfo.intimate;
                    } else {
                        intimate = null;
                    }
                    if (intimate != null) {
                        FriendListInfoCache friendListInfoCache4 = FriendListInfoCache.this;
                        Intrinsics.checkNotNullExpressionValue(uid, "uid");
                        friendListInfoCache4.y(userSimpleInfo, uid);
                    }
                    if (userSimpleInfo != null) {
                        otherFlag = userSimpleInfo.otherFlags;
                    }
                    if (otherFlag != null) {
                        FriendListInfoCache friendListInfoCache5 = FriendListInfoCache.this;
                        Intrinsics.checkNotNullExpressionValue(uid, "uid");
                        friendListInfoCache5.B(userSimpleInfo, uid);
                    }
                }
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileListener
        public /* synthetic */ void onSelfStatusChanged(StatusInfo statusInfo) {
            be.b(this, statusInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileListener
        public /* synthetic */ void onStatusAsyncFieldUpdate(HashMap hashMap) {
            be.c(this, hashMap);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileListener
        public /* synthetic */ void onStatusUpdate(HashMap hashMap) {
            be.d(this, hashMap);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileListener
        public /* synthetic */ void onStrangerRemarkChanged(HashMap hashMap) {
            be.e(this, hashMap);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileListener
        public /* synthetic */ void onUserDetailInfoChanged(UserDetailInfo userDetailInfo) {
            be.f(this, userDetailInfo);
        }
    }

    static {
        Lazy<FriendListInfoCache> lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30781);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        INSTANCE = new Companion(null);
        f355788j = ((IFriendsTABService) QRoute.api(IFriendsTABService.class)).getCacheFriendCount();
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) FriendListInfoCache$Companion$instance$2.INSTANCE);
        f355789k = lazy;
    }

    public FriendListInfoCache() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(FriendListInfoCache$enabled$2.INSTANCE);
            this.enabled = lazy;
            this.cacheType2Cache = new ConcurrentHashMap<>();
            this.lruReportDataMap = new ConcurrentHashMap<>();
            this.lruSampleUidMap = new ConcurrentHashMap<>();
            this.needCacheUidMap = new ConcurrentHashMap<>();
            this.isLogOpen = ((IFriendsTABService) QRoute.api(IFriendsTABService.class)).isNTLogOpen();
            this.mergeUidCacheSwitch = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("105632", true);
            t();
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void B(UserSimpleInfo userSimpleInfo, String uid) {
        com.tencent.qqnt.ntrelation.baseinfo.bean.a aVar;
        HashMap<String, StockLocalData> hashMap;
        b<String, ? extends com.tencent.qqnt.ntrelation.baseinfo.bean.a> bVar = this.cacheType2Cache.get(a.f355804a.d());
        StockLocalData stockLocalData = null;
        if (bVar != null) {
            aVar = (com.tencent.qqnt.ntrelation.baseinfo.bean.a) bVar.get(uid);
        } else {
            aVar = null;
        }
        if (aVar != null && (aVar instanceof com.tencent.qqnt.ntrelation.otherinfo.bean.c)) {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(uid);
            y f16 = f.f();
            if (f16 != null) {
                hashMap = f16.getStockLocalData("FriendListInfoCache", arrayList);
            } else {
                hashMap = null;
            }
            if (hashMap != null) {
                stockLocalData = hashMap.get(uid);
            }
            com.tencent.qqnt.ntrelation.util.c.f360229a.p(userSimpleInfo.otherFlags, userSimpleInfo.relationFlags, stockLocalData, (com.tencent.qqnt.ntrelation.otherinfo.bean.c) aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void C(UserSimpleInfo userSimpleInfo, String uid) {
        com.tencent.qqnt.ntrelation.baseinfo.bean.a aVar;
        b<String, ? extends com.tencent.qqnt.ntrelation.baseinfo.bean.a> bVar = this.cacheType2Cache.get(a.f355804a.f());
        if (bVar != null) {
            aVar = (com.tencent.qqnt.ntrelation.baseinfo.bean.a) bVar.get(uid);
        } else {
            aVar = null;
        }
        if (aVar != null && (aVar instanceof NTVasSimpleInfo)) {
            m.f360286a.o("FriendListInfoCache_updateVasSimpleInfo", userSimpleInfo.vasInfo, (NTVasSimpleInfo) aVar);
        }
    }

    private final void h() {
        IKernelService iKernelService;
        y profileService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (iKernelService = (IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "all")) != null && (profileService = iKernelService.getProfileService()) != null) {
            profileService.addKernelProfileListenerForUICache(new d());
        }
    }

    private final void i() {
        this.cacheType2Cache.clear();
        ConcurrentHashMap<String, b<String, ? extends com.tencent.qqnt.ntrelation.baseinfo.bean.a>> concurrentHashMap = this.cacheType2Cache;
        a aVar = a.f355804a;
        concurrentHashMap.put(aVar.a(), new b<>(f355788j));
        this.cacheType2Cache.put(aVar.c(), new b<>(f355788j));
        this.cacheType2Cache.put(aVar.f(), new b<>(f355788j));
        this.cacheType2Cache.put(aVar.b(), new b<>(f355788j));
        this.cacheType2Cache.put(aVar.g(), new b<>(f355788j));
        this.cacheType2Cache.put(aVar.d(), new b<>(f355788j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void l(FriendListInfoCache this$0, String cacheType, Ref.ObjectRef uidSet, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(cacheType, "$cacheType");
        Intrinsics.checkNotNullParameter(uidSet, "$uidSet");
        this$0.p(cacheType, new ArrayList<>((Collection) uidSet.element), str);
        ((CopyOnWriteArraySet) uidSet.element).clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(FriendListInfoCache this$0, String uid, String cacheType, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(uid, "$uid");
        Intrinsics.checkNotNullParameter(cacheType, "$cacheType");
        this$0.o(uid, cacheType, str);
    }

    private final boolean n() {
        return ((Boolean) this.enabled.getValue()).booleanValue();
    }

    private final void o(String uid, String cacheType, String trace) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(uid);
        p(cacheType, arrayList, trace);
    }

    private final void p(String cacheType, ArrayList<String> uidList, String trace) {
        q(cacheType, uidList, false, trace);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void q(String cacheType, ArrayList<String> uidList, boolean isFirstInit, String trace) {
        HashMap<String, OtherFlag> otherFlag;
        Set<String> keySet;
        HashMap<String, RelationFlag> hashMap;
        RelationFlag relationFlag;
        y f16;
        HashMap hashMap2;
        Set<String> keySet2;
        StatusInfo statusInfo;
        HashMap<String, VasInfo> vasInfo;
        HashMap<String, StockLocalData> stockLocalData;
        StockLocalData stockLocalData2;
        HashMap<String, StockLocalData> hashMap3;
        HashMap<String, UserSimpleInfo> hashMap4;
        HashMap<String, StatusInfo> hashMap5;
        HashMap<String, RelationFlag> hashMap6;
        UserSimpleInfo userSimpleInfo;
        StatusInfo statusInfo2;
        RelationFlag relationFlag2;
        StockLocalData stockLocalData3;
        a aVar = a.f355804a;
        HashMap hashMap7 = null;
        if (Intrinsics.areEqual(cacheType, aVar.a())) {
            if (uidList == null) {
                return;
            }
            y f17 = f.f();
            if (f17 != null) {
                hashMap3 = f17.getStockLocalData("FriendListInfoCache_getKernelDataAndPutCache", uidList);
            } else {
                hashMap3 = null;
            }
            y f18 = f.f();
            if (f18 != null) {
                hashMap4 = f18.getCoreAndBaseInfo("FriendListInfoCache_getKernelDataAndPutCache", uidList);
            } else {
                hashMap4 = null;
            }
            y f19 = f.f();
            if (f19 != null) {
                hashMap5 = f19.getStatusInfo("FriendListInfoCache_getKernelDataAndPutCache", uidList);
            } else {
                hashMap5 = null;
            }
            y f26 = f.f();
            if (f26 != null) {
                hashMap6 = f26.getRelationFlag("FriendListInfoCache_getKernelDataAndPutCache", uidList);
            } else {
                hashMap6 = null;
            }
            Iterator<String> it = uidList.iterator();
            while (it.hasNext()) {
                String uid = it.next();
                if (hashMap4 != null && (userSimpleInfo = hashMap4.get(uid)) != null) {
                    if (hashMap5 != null) {
                        statusInfo2 = hashMap5.get(uid);
                    } else {
                        statusInfo2 = null;
                    }
                    userSimpleInfo.status = statusInfo2;
                    if (hashMap6 != null) {
                        relationFlag2 = hashMap6.get(uid);
                    } else {
                        relationFlag2 = null;
                    }
                    userSimpleInfo.relationFlags = relationFlag2;
                    com.tencent.qqnt.ntrelation.util.c cVar = com.tencent.qqnt.ntrelation.util.c.f360229a;
                    Intrinsics.checkNotNullExpressionValue(uid, "uid");
                    if (hashMap3 != null) {
                        stockLocalData3 = hashMap3.get(uid);
                    } else {
                        stockLocalData3 = null;
                    }
                    com.tencent.qqnt.ntrelation.friendsinfo.bean.d f27 = cVar.f("FriendListInfoCache_getKernelDataAndPutCache", uid, userSimpleInfo, stockLocalData3);
                    if (f27 != null) {
                        w(cacheType, f27);
                    }
                }
            }
            return;
        }
        if (Intrinsics.areEqual(cacheType, aVar.f())) {
            if (isFirstInit) {
                y f28 = f.f();
                if (f28 != null) {
                    vasInfo = f28.getVasInfo("FriendListInfoCache_getKernelDataAndPutCache", new ArrayList<>());
                }
                vasInfo = null;
            } else {
                y f29 = f.f();
                if (f29 != null) {
                    vasInfo = f29.getVasInfo("FriendListInfoCache_getKernelDataAndPutCache", uidList);
                }
                vasInfo = null;
            }
            if (vasInfo == null) {
                return;
            }
            if (isFirstInit) {
                y f36 = f.f();
                if (f36 != null) {
                    stockLocalData = f36.getStockLocalData("FriendListInfoCache_getKernelDataAndPutCache", new ArrayList<>());
                }
                stockLocalData = null;
            } else {
                y f37 = f.f();
                if (f37 != null) {
                    stockLocalData = f37.getStockLocalData("FriendListInfoCache_getKernelDataAndPutCache", uidList);
                }
                stockLocalData = null;
            }
            Collection<String> keySet3 = vasInfo.keySet();
            if (keySet3 == null) {
                keySet3 = new ArrayList();
            }
            for (String uid2 : keySet3) {
                m mVar = m.f360286a;
                Intrinsics.checkNotNullExpressionValue(uid2, "uid");
                VasInfo vasInfo2 = vasInfo.get(uid2);
                if (stockLocalData != null) {
                    stockLocalData2 = stockLocalData.get(uid2);
                } else {
                    stockLocalData2 = null;
                }
                NTVasSimpleInfo b16 = mVar.b("FriendListInfoCache", uid2, vasInfo2, stockLocalData2);
                if (b16 != null) {
                    w(cacheType, b16);
                }
            }
            return;
        }
        if (Intrinsics.areEqual(cacheType, aVar.c())) {
            if (uidList == null) {
                return;
            }
            y f38 = f.f();
            if (f38 != null) {
                hashMap7 = f38.getStatusInfo("FriendListInfoCache_getKernelDataAndPutCache", uidList);
            }
            Iterator<String> it5 = uidList.iterator();
            while (it5.hasNext()) {
                String uid3 = it5.next();
                if (hashMap7 != null && (statusInfo = hashMap7.get(uid3)) != null) {
                    j jVar = j.f360277a;
                    Intrinsics.checkNotNullExpressionValue(uid3, "uid");
                    w(cacheType, jVar.b("FriendListInfoCache_getKernelDataAndPutCache", uid3, statusInfo));
                }
            }
            return;
        }
        if (Intrinsics.areEqual(cacheType, aVar.b())) {
            if (isFirstInit) {
                y f39 = f.f();
                if (f39 != null) {
                    hashMap2 = f39.getIntimate("FriendListInfoCache_getKernelDataAndPutCache", new ArrayList<>());
                }
                hashMap2 = null;
            } else {
                y f46 = f.f();
                if (f46 != null) {
                    hashMap2 = f46.getIntimate("FriendListInfoCache_getKernelDataAndPutCache", uidList);
                }
                hashMap2 = null;
            }
            if (hashMap2 != null) {
                hashMap7 = hashMap2;
            }
            if (hashMap7 != null && (keySet2 = hashMap7.keySet()) != null) {
                for (String uid4 : keySet2) {
                    Intimate intimate = (Intimate) hashMap7.get(uid4);
                    if (intimate != null) {
                        com.tencent.qqnt.ntrelation.util.d dVar = com.tencent.qqnt.ntrelation.util.d.f360234a;
                        Intrinsics.checkNotNullExpressionValue(uid4, "uid");
                        w(cacheType, dVar.c("FriendListInfoCache_getKernelDataAndPutCache", uid4, intimate));
                    }
                }
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(cacheType, aVar.d())) {
            if (isFirstInit) {
                y f47 = f.f();
                if (f47 != null) {
                    otherFlag = f47.getOtherFlag("FriendListInfoCache_getKernelDataAndPutCache", new ArrayList<>());
                }
                otherFlag = null;
            } else {
                y f48 = f.f();
                if (f48 != null) {
                    otherFlag = f48.getOtherFlag("FriendListInfoCache_getKernelDataAndPutCache", uidList);
                }
                otherFlag = null;
            }
            if (otherFlag == null || (keySet = otherFlag.keySet()) == null) {
                return;
            }
            if (uidList != null && (f16 = f.f()) != null) {
                hashMap = f16.getRelationFlag("FriendListInfoCache_getKernelDataAndPutCache", uidList);
            } else {
                hashMap = null;
            }
            for (String str : keySet) {
                if (str != null) {
                    com.tencent.qqnt.ntrelation.util.c cVar2 = com.tencent.qqnt.ntrelation.util.c.f360229a;
                    OtherFlag otherFlag2 = otherFlag.get(str);
                    if (hashMap != null) {
                        relationFlag = hashMap.get(str);
                    } else {
                        relationFlag = null;
                    }
                    com.tencent.qqnt.ntrelation.otherinfo.bean.c h16 = cVar2.h(str, otherFlag2, relationFlag);
                    if (h16 != null) {
                        w(cacheType, h16);
                    }
                }
            }
            return;
        }
        QLog.i("FriendListInfoCache", 1, "unSupport cache type " + cacheType + " trace " + trace);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void u(String cacheType, ArrayList<String> uidList, boolean isFirstInit, String trace) {
        boolean z16;
        if (!n()) {
            return;
        }
        if (cacheType.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (QLog.isDebugVersion()) {
                QLog.d("FriendListInfoCache", 1, "cacheType.isEmpty()");
                return;
            }
            return;
        }
        b<String, ? extends com.tencent.qqnt.ntrelation.baseinfo.bean.a> bVar = this.cacheType2Cache.get(cacheType);
        if (bVar == null) {
            QLog.d("FriendListInfoCache", 1, "lruCache == null name = " + cacheType);
            return;
        }
        if (isFirstInit) {
            q(cacheType, uidList, true, trace);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<String> it = uidList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (((com.tencent.qqnt.ntrelation.baseinfo.bean.a) bVar.get(next)) == null) {
                arrayList.add(next);
            }
        }
        p(cacheType, arrayList, trace);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void w(String cacheType, com.tencent.qqnt.ntrelation.baseinfo.bean.a baseFriendInfo) {
        boolean z16;
        if (!n()) {
            return;
        }
        if (cacheType.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && baseFriendInfo != null) {
            b<String, ? extends com.tencent.qqnt.ntrelation.baseinfo.bean.a> bVar = this.cacheType2Cache.get(cacheType);
            if (bVar == null) {
                QLog.i("FriendListInfoCache", 1, "lruCache == null cacheType = " + cacheType);
                return;
            }
            c cVar = this.lruReportDataMap.get(cacheType);
            if (cVar != null) {
                cVar.e();
            }
            synchronized (this.cacheType2Cache) {
            }
            return;
        }
        if (QLog.isDebugVersion()) {
            QLog.i("FriendListInfoCache", 1, "cacheType.isEmpty() || baseFriendInfo == null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void x(UserSimpleInfo userSimpleInfo, String uid) {
        com.tencent.qqnt.ntrelation.baseinfo.bean.a aVar;
        b<String, ? extends com.tencent.qqnt.ntrelation.baseinfo.bean.a> bVar = this.cacheType2Cache.get(a.f355804a.a());
        if (bVar != null) {
            aVar = (com.tencent.qqnt.ntrelation.baseinfo.bean.a) bVar.get(uid);
        } else {
            aVar = null;
        }
        if (aVar != null && (aVar instanceof com.tencent.qqnt.ntrelation.friendsinfo.bean.d)) {
            com.tencent.qqnt.ntrelation.util.c.f360229a.q("FriendListInfoCache_updateFriendSimpleInfo2", uid, userSimpleInfo, (com.tencent.qqnt.ntrelation.friendsinfo.bean.d) aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void y(UserSimpleInfo userSimpleInfo, String uid) {
        com.tencent.qqnt.ntrelation.baseinfo.bean.a aVar;
        b<String, ? extends com.tencent.qqnt.ntrelation.baseinfo.bean.a> bVar = this.cacheType2Cache.get(a.f355804a.b());
        if (bVar != null) {
            aVar = (com.tencent.qqnt.ntrelation.baseinfo.bean.a) bVar.get(uid);
        } else {
            aVar = null;
        }
        if (aVar != null && (aVar instanceof com.tencent.qqnt.ntrelation.intimateinfo.bean.a)) {
            com.tencent.qqnt.ntrelation.util.d.f360234a.h("FriendListInfoCache_updateIntimateSimpleInfo", userSimpleInfo.intimate, (com.tencent.qqnt.ntrelation.intimateinfo.bean.a) aVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void z(String uid, StatusInfo statusInfo) {
        com.tencent.qqnt.ntrelation.baseinfo.bean.a aVar;
        b<String, ? extends com.tencent.qqnt.ntrelation.baseinfo.bean.a> bVar = this.cacheType2Cache.get(a.f355804a.c());
        if (bVar != null) {
            aVar = (com.tencent.qqnt.ntrelation.baseinfo.bean.a) bVar.get(uid);
        } else {
            aVar = null;
        }
        if (aVar == null) {
            new ArrayList().add(uid);
            com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c b16 = j.f360277a.b("FriendListInfoCache_updateOnlineStatusInfoSimpleInfo", uid, statusInfo);
            if (bVar != null) {
                return;
            }
            return;
        }
        if (!(aVar instanceof com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c)) {
            return;
        }
        j.f360277a.d("FriendListInfoCache_updateOnlineStatusInfoSimpleInfo", statusInfo, (com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c) aVar);
    }

    public final void A(@Nullable HashMap<String, StatusInfo> status) {
        List list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) status);
            return;
        }
        if (status == null) {
            return;
        }
        Set<String> keySet = status.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "status.keys");
        list = CollectionsKt___CollectionsKt.toList(keySet);
        Iterator it = new ArrayList(list).iterator();
        while (it.hasNext()) {
            String uid = (String) it.next();
            StatusInfo statusInfo = status.get(uid);
            Intrinsics.checkNotNullExpressionValue(uid, "uid");
            z(uid, statusInfo);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void j(@NotNull String uid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) uid);
            return;
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        if (!TextUtils.isEmpty(uid)) {
            if (QLog.isDebugVersion()) {
                QLog.i("FriendListInfoCache", 1, "deleteFriendCache " + uid);
            }
            ConcurrentHashMap<String, b<String, ? extends com.tencent.qqnt.ntrelation.baseinfo.bean.a>> concurrentHashMap = this.cacheType2Cache;
            a aVar = a.f355804a;
            b<String, ? extends com.tencent.qqnt.ntrelation.baseinfo.bean.a> bVar = concurrentHashMap.get(aVar.a());
            if (bVar != null) {
            }
            b<String, ? extends com.tencent.qqnt.ntrelation.baseinfo.bean.a> bVar2 = this.cacheType2Cache.get(aVar.c());
            if (bVar2 != null) {
            }
            b<String, ? extends com.tencent.qqnt.ntrelation.baseinfo.bean.a> bVar3 = this.cacheType2Cache.get(aVar.f());
            if (bVar3 != null) {
            }
            b<String, ? extends com.tencent.qqnt.ntrelation.baseinfo.bean.a> bVar4 = this.cacheType2Cache.get(aVar.b());
            if (bVar4 != null) {
            }
            b<String, ? extends com.tencent.qqnt.ntrelation.baseinfo.bean.a> bVar5 = this.cacheType2Cache.get(aVar.g());
            if (bVar5 != null) {
            }
            b<String, ? extends com.tencent.qqnt.ntrelation.baseinfo.bean.a> bVar6 = this.cacheType2Cache.get(aVar.d());
            if (bVar6 != null) {
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v2, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v9, types: [T, java.util.concurrent.CopyOnWriteArraySet] */
    @Nullable
    public final synchronized Object k(@NotNull final String cacheType, @NotNull final String uid, @Nullable final String trace) {
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return iPatchRedirector.redirect((short) 6, this, cacheType, uid, trace);
        }
        Intrinsics.checkNotNullParameter(cacheType, "cacheType");
        Intrinsics.checkNotNullParameter(uid, "uid");
        if (!n()) {
            return null;
        }
        if (cacheType.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            if (uid.length() == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                b<String, ? extends com.tencent.qqnt.ntrelation.baseinfo.bean.a> bVar = this.cacheType2Cache.get(cacheType);
                if (bVar == null) {
                    QLog.i("FriendListInfoCache", 1, "lruCache == null name = " + cacheType);
                    return null;
                }
                c cVar = this.lruReportDataMap.get(cacheType);
                if (cVar == null) {
                    c cVar2 = new c(cacheType, 0, 0, bVar.maxSize(), 0, 22, null);
                    this.lruReportDataMap.put(cacheType, cVar2);
                    cVar = cVar2;
                }
                CopyOnWriteArrayList<String> copyOnWriteArrayList = this.lruSampleUidMap.get(cacheType);
                if (copyOnWriteArrayList == null) {
                    copyOnWriteArrayList = new CopyOnWriteArrayList<>();
                    this.lruSampleUidMap.put(cacheType, copyOnWriteArrayList);
                }
                if (copyOnWriteArrayList.size() >= 3) {
                    copyOnWriteArrayList.remove(0);
                }
                copyOnWriteArrayList.add(uid);
                com.tencent.qqnt.ntrelation.baseinfo.bean.a aVar = (com.tencent.qqnt.ntrelation.baseinfo.bean.a) bVar.get(uid);
                if (aVar == null) {
                    if (this.mergeUidCacheSwitch) {
                        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                        ?? r102 = this.needCacheUidMap.get(cacheType);
                        objectRef.element = r102;
                        if (r102 == 0) {
                            objectRef.element = new CopyOnWriteArraySet();
                        }
                        if (!((CopyOnWriteArraySet) objectRef.element).contains(uid)) {
                            ((CopyOnWriteArraySet) objectRef.element).add(uid);
                        }
                        if (((CopyOnWriteArraySet) objectRef.element).size() == 30) {
                            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.contacts.cache.b
                                @Override // java.lang.Runnable
                                public final void run() {
                                    FriendListInfoCache.l(FriendListInfoCache.this, cacheType, objectRef, trace);
                                }
                            }, 16, null, true);
                        }
                    } else {
                        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.contacts.cache.c
                            @Override // java.lang.Runnable
                            public final void run() {
                                FriendListInfoCache.m(FriendListInfoCache.this, uid, cacheType, trace);
                            }
                        }, 16, null, true);
                    }
                } else if (this.initLruCacheFinish) {
                    cVar.g(cVar.d() + 1);
                    cVar.h(cVar.e() + 1);
                }
                cVar.f(bVar.size());
                return aVar;
            }
        }
        if (this.isLogOpen) {
            QLog.i("FriendListInfoCache", 1, "cacheType.isEmpty() || uid.isEmpty() trace " + trace);
        }
        return null;
    }

    @Nullable
    public final CopyOnWriteArrayList<String> r(@NotNull String cacheType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (CopyOnWriteArrayList) iPatchRedirector.redirect((short) 8, (Object) this, (Object) cacheType);
        }
        Intrinsics.checkNotNullParameter(cacheType, "cacheType");
        return this.lruSampleUidMap.get(cacheType);
    }

    @NotNull
    public final ConcurrentHashMap<String, c> s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (ConcurrentHashMap) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.lruReportDataMap;
    }

    public final void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            h();
            i();
        }
    }

    public final void v(@NotNull ArrayList<String> uidList, boolean isFirstInit, @Nullable String trace) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, uidList, Boolean.valueOf(isFirstInit), trace);
            return;
        }
        Intrinsics.checkNotNullParameter(uidList, "uidList");
        a aVar = a.f355804a;
        u(aVar.f(), uidList, isFirstInit, trace);
        u(aVar.b(), uidList, isFirstInit, trace);
        u(aVar.d(), uidList, isFirstInit, trace);
        u(aVar.a(), uidList, isFirstInit, trace);
        u(aVar.c(), uidList, isFirstInit, trace);
        if (isFirstInit) {
            this.initLruCacheFinish = true;
        }
    }
}
