package com.tencent.qqnt.ntrelation.friendsinfo.manager;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.contacts.cache.FriendListInfoCache;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.m;
import com.tencent.qqnt.kernel.api.y;
import com.tencent.qqnt.kernel.nativeinterface.BuddyCategory;
import com.tencent.qqnt.kernel.nativeinterface.BuddyListCategory;
import com.tencent.qqnt.kernel.nativeinterface.BuddyReqInfo;
import com.tencent.qqnt.kernel.nativeinterface.BuddySetting;
import com.tencent.qqnt.kernel.nativeinterface.BuddyVerify;
import com.tencent.qqnt.kernel.nativeinterface.DoubtBuddyReqListRsp;
import com.tencent.qqnt.kernel.nativeinterface.IBuddyListCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyListener;
import com.tencent.qqnt.kernel.nativeinterface.IKernelProfileListener;
import com.tencent.qqnt.kernel.nativeinterface.StatusInfo;
import com.tencent.qqnt.kernel.nativeinterface.UserDetailInfo;
import com.tencent.qqnt.kernel.nativeinterface.UserSimpleInfo;
import com.tencent.qqnt.kernel.nativeinterface.ab;
import com.tencent.qqnt.kernel.nativeinterface.be;
import com.tencent.qqnt.kernel.nativeinterface.cq;
import com.tencent.qqnt.ntrelation.api.IFriendsTABService;
import com.tencent.qqnt.ntrelation.constant.RelationListReqType;
import com.tencent.qqnt.ntrelation.constant.RelationObserverType;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.ntrelation.friendsinfo.manager.c;
import com.tencent.qqnt.ntrelation.intimateinfo.manager.cache.MutualMarkCacheEntityManager;
import com.tencent.xweb.FileReaderHelper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\u0006*\u0002\u0011J\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bM\u0010NJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J0\u0010\u000f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J0\u0010\u0010\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000f\u0010\u0012\u001a\u00020\u0011H\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J4\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00142\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00170\u00162\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019H\u0002J\u0018\u0010\u001f\u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001e\u001a\u00020\u0002J$\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00162\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014J6\u0010%\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\n2\u0006\u0010\"\u001a\u00020\u00022\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001a0#J&\u0010&\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\n2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001a0#J\u001e\u0010'\u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\n2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\n0#J\u001e\u0010*\u001a\u00020\u00062\u0016\u0010)\u001a\u0012\u0012\u0004\u0012\u00020\n0\fj\b\u0012\u0004\u0012\u00020\n`(J&\u0010-\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\n2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020,0#J.\u0010.\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u001d\u001a\u0004\u0018\u00010\n2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001a0#J\u000e\u00101\u001a\u00020\u00062\u0006\u00100\u001a\u00020/J\u001e\u00102\u001a\u00020\u00062\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020/0\fj\b\u0012\u0004\u0012\u00020/`(J\u001e\u00104\u001a\u00020\u00062\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00192\u0006\u00103\u001a\u00020\u0002J\u001e\u00105\u001a\u00020\u00062\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00192\u0006\u00103\u001a\u00020\u0002J\u0016\u00106\u001a\u00020\u00062\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\u0019R \u00109\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020/0\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108R,\u0010<\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020:0\u00160\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u00108R,\u0010>\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020=0\u00160\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u00108R \u0010?\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020:0\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u00108R \u0010@\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020:0\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u00108R \u0010B\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020A0\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u00108R \u0010C\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00170\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u00108R \u0010E\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00170\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u00108R \u0010F\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00170\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u00108R \u0010G\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00170\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u00108R\u0016\u0010I\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010HR\u0014\u0010L\u001a\u00020J8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010K\u00a8\u0006O"}, d2 = {"Lcom/tencent/qqnt/ntrelation/friendsinfo/manager/c;", "", "", FileReaderHelper.OPEN_FILE_FROM_FORCE, "Lcom/tencent/qqnt/ntrelation/constant/RelationListReqType;", "reqType", "", tl.h.F, "", "result", "", "errMsg", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/BuddyListCategory;", "data", "u", "j", "com/tencent/qqnt/ntrelation/friendsinfo/manager/c$b", "f", "()Lcom/tencent/qqnt/ntrelation/friendsinfo/manager/c$b;", "Lcom/tencent/qqnt/ntrelation/constant/RelationObserverType;", "observerType", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/qqnt/ntrelation/friendsinfo/manager/i;", "map", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/e;", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/b;", WebViewPlugin.KEY_RESPONSE, DomainData.DOMAIN_NAME, "trace", "forceInit", "k", "g", "isObserver", "forceUpdate", "Lhx3/b;", "iQueryGeneralDataCallback", "e", "v", "d", "Lkotlin/collections/ArrayList;", "uids", "p", "uid", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/c;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/d;", "ntFriendSimpleInfo", "t", "o", "isFromKernel", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, ReportConstant.COSTREPORT_PREFIX, "r", "b", "Ljava/util/concurrent/ConcurrentHashMap;", "friendSimpleInfoCacheMap", "Lcom/tencent/qqnt/ntrelation/friendsinfo/manager/l;", "c", "friendSimpleInfoCallbackHashMap", "Lcom/tencent/qqnt/ntrelation/friendsinfo/manager/k;", "friendDetailInfoCallbackHashMap", "allFriendsCallbackHashMap", "friendChangeCallbackHashMap", "Lcom/tencent/qqnt/ntrelation/friendsinfo/manager/j;", "changeFriendUidsCallbackHashMap", "allCategoryCallbackHashMap", "i", "allCategoryOnceCallbackHashMap", "allLetterCallBackHashMap", "allLetterOnceCallBackHashMap", "Z", "hasInitListener", "com/tencent/qqnt/ntrelation/friendsinfo/manager/c$c", "Lcom/tencent/qqnt/ntrelation/friendsinfo/manager/c$c;", "mKernelProfileListener", "<init>", "()V", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f360050a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<String, com.tencent.qqnt.ntrelation.friendsinfo.bean.d> friendSimpleInfoCacheMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<String, ConcurrentHashMap<Integer, l>> friendSimpleInfoCallbackHashMap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<String, ConcurrentHashMap<Integer, k>> friendDetailInfoCallbackHashMap;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<Integer, l> allFriendsCallbackHashMap;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<Integer, l> friendChangeCallbackHashMap;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<Integer, j> changeFriendUidsCallbackHashMap;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<Integer, i> allCategoryCallbackHashMap;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<Integer, i> allCategoryOnceCallbackHashMap;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<Integer, i> allLetterCallBackHashMap;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final ConcurrentHashMap<Integer, i> allLetterOnceCallBackHashMap;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean hasInitListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final C9668c mKernelProfileListener;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes22.dex */
    public /* synthetic */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f360063a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36792);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[RelationListReqType.values().length];
            try {
                iArr[RelationListReqType.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RelationListReqType.LETTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f360063a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\u0007\u001a\u00020\u00062\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/qqnt/ntrelation/friendsinfo/manager/c$b", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelBuddyListener;", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/BuddyCategory;", "Lkotlin/collections/ArrayList;", "data", "", "onBuddyListChange", "", MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_FIRST, "onBuddyListChangedV2", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class b implements IKernelBuddyListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(ArrayList arrayList) {
            if (arrayList == null) {
                QLog.e("FriendsInfoManager", 1, "getBuddyListener onBuddyListChange infos is null!");
                return;
            }
            ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> arrayList2 = new ArrayList<>();
            arrayList2.addAll(c.friendSimpleInfoCacheMap.values());
            c.f360050a.o(arrayList2);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyListener
        public /* synthetic */ void onAddBuddyNeedVerify(BuddyVerify buddyVerify) {
            ab.a(this, buddyVerify);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyListener
        public /* synthetic */ void onAddMeSettingChanged(int i3, HashMap hashMap) {
            ab.b(this, i3, hashMap);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyListener
        public /* synthetic */ void onAvatarUrlUpdated(String str) {
            ab.c(this, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyListener
        public /* synthetic */ void onBlockChanged(HashMap hashMap) {
            ab.d(this, hashMap);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyListener
        public /* synthetic */ void onBuddyDeleted(String str) {
            ab.e(this, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyListener
        public void onBuddyListChange(@Nullable final ArrayList<BuddyCategory> data) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) data);
            } else {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.ntrelation.friendsinfo.manager.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        c.b.b(data);
                    }
                }, 16, null, true);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyListener
        public void onBuddyListChangedV2(boolean first) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, first);
                return;
            }
            ab.g(this, first);
            c cVar = c.f360050a;
            cVar.h(false, RelationListReqType.NORMAL);
            cVar.h(false, RelationListReqType.LETTER);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyListener
        public /* synthetic */ void onBuddyRemarkUpdated(String str, String str2) {
            ab.h(this, str, str2);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyListener
        public /* synthetic */ void onBuddyReqChange(BuddyReqInfo buddyReqInfo) {
            ab.i(this, buddyReqInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyListener
        public /* synthetic */ void onBuddyReqUnreadCntChange(int i3) {
            ab.j(this, i3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyListener
        public /* synthetic */ void onCheckBuddySettingResult(BuddySetting buddySetting) {
            ab.k(this, buddySetting);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyListener
        public /* synthetic */ void onDelBatchBuddyInfos(ArrayList arrayList) {
            ab.l(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyListener
        public /* synthetic */ void onDoubtBuddyReqChange(DoubtBuddyReqListRsp doubtBuddyReqListRsp) {
            ab.m(this, doubtBuddyReqListRsp);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyListener
        public /* synthetic */ void onDoubtBuddyReqUnreadNumChange(int i3) {
            ab.n(this, i3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyListener
        public /* synthetic */ void onNickUpdated(String str, String str2) {
            ab.o(this, str, str2);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyListener
        public /* synthetic */ void onSmartInfos(String str, String str2, int i3) {
            ab.p(this, str, str2, i3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelBuddyListener
        public /* synthetic */ void onSpacePermissionInfos(HashMap hashMap) {
            ab.q(this, hashMap);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\u0007\u001a\u00020\u00062\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u001e\u0010\r\u001a\u00020\u00062\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0002H\u0016J\u0012\u0010\u000e\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u000bH\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/qqnt/ntrelation/friendsinfo/manager/c$c", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelProfileListener;", "Ljava/util/HashMap;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/UserSimpleInfo;", "profiles", "", "onProfileSimpleChanged", "Lcom/tencent/qqnt/kernel/nativeinterface/UserDetailInfo;", "info", "onUserDetailInfoChanged", "Lcom/tencent/qqnt/kernel/nativeinterface/StatusInfo;", "status", "onStatusUpdate", "onSelfStatusChanged", "contacts_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.ntrelation.friendsinfo.manager.c$c, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public static final class C9668c implements IKernelProfileListener {
        static IPatchRedirector $redirector_;

        C9668c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(HashMap hashMap) {
            List list;
            if (hashMap == null) {
                QLog.e("FriendsInfoManager", 1, "getBuddyListener onBuddyInfoChange infos is null!");
                return;
            }
            c cVar = c.f360050a;
            Set keySet = hashMap.keySet();
            Intrinsics.checkNotNullExpressionValue(keySet, "profiles.keys");
            list = CollectionsKt___CollectionsKt.toList(keySet);
            cVar.p(new ArrayList<>(list));
            com.tencent.qqnt.ntrelation.friendsinfo.manager.a.f360048a.d(hashMap);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(StatusInfo statusInfo) {
            if (statusInfo == null) {
                QLog.e("FriendsInfoManager", 1, "getBuddyListener onSelfStatusChanged infos is null!");
                return;
            }
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(statusInfo.uid);
            HashMap<String, StatusInfo> hashMap = new HashMap<>();
            String str = statusInfo.uid;
            Intrinsics.checkNotNullExpressionValue(str, "info.uid");
            hashMap.put(str, statusInfo);
            FriendListInfoCache.INSTANCE.a().A(hashMap);
            c.f360050a.p(arrayList);
            com.tencent.qqnt.ntrelation.friendsinfo.manager.a.f360048a.a(statusInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g(HashMap hashMap) {
            List list;
            if (hashMap == null) {
                QLog.e("FriendsInfoManager", 1, "getBuddyListener onStatusUpdate infos is null!");
                return;
            }
            FriendListInfoCache.INSTANCE.a().A(hashMap);
            Set keySet = hashMap.keySet();
            Intrinsics.checkNotNullExpressionValue(keySet, "status.keys");
            list = CollectionsKt___CollectionsKt.toList(keySet);
            c.f360050a.p(new ArrayList<>(list));
            com.tencent.qqnt.ntrelation.friendsinfo.manager.a.f360048a.b(hashMap);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void h(UserDetailInfo userDetailInfo) {
            com.tencent.qqnt.ntrelation.friendsinfo.manager.a.f360048a.c(userDetailInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileListener
        public void onProfileSimpleChanged(@Nullable final HashMap<String, UserSimpleInfo> profiles) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) profiles);
            } else {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.ntrelation.friendsinfo.manager.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        c.C9668c.e(profiles);
                    }
                }, 16, null, true);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileListener
        public void onSelfStatusChanged(@Nullable final StatusInfo info) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) info);
            } else {
                be.b(this, info);
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.ntrelation.friendsinfo.manager.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        c.C9668c.f(StatusInfo.this);
                    }
                }, 16, null, true);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileListener
        public /* synthetic */ void onStatusAsyncFieldUpdate(HashMap hashMap) {
            be.c(this, hashMap);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileListener
        public void onStatusUpdate(@Nullable final HashMap<String, StatusInfo> status) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) status);
            } else {
                be.d(this, status);
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.ntrelation.friendsinfo.manager.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        c.C9668c.g(status);
                    }
                }, 16, null, true);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileListener
        public /* synthetic */ void onStrangerRemarkChanged(HashMap hashMap) {
            be.e(this, hashMap);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileListener
        public void onUserDetailInfoChanged(@Nullable final UserDetailInfo info) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) info);
            } else {
                be.f(this, info);
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.ntrelation.friendsinfo.manager.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        c.C9668c.h(UserDetailInfo.this);
                    }
                }, 16, null, true);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(36805);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
            return;
        }
        f360050a = new c();
        friendSimpleInfoCacheMap = new ConcurrentHashMap<>();
        friendSimpleInfoCallbackHashMap = new ConcurrentHashMap<>();
        friendDetailInfoCallbackHashMap = new ConcurrentHashMap<>();
        allFriendsCallbackHashMap = new ConcurrentHashMap<>();
        friendChangeCallbackHashMap = new ConcurrentHashMap<>();
        changeFriendUidsCallbackHashMap = new ConcurrentHashMap<>();
        allCategoryCallbackHashMap = new ConcurrentHashMap<>();
        allCategoryOnceCallbackHashMap = new ConcurrentHashMap<>();
        allLetterCallBackHashMap = new ConcurrentHashMap<>();
        allLetterOnceCallBackHashMap = new ConcurrentHashMap<>();
        mKernelProfileListener = new C9668c();
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final b f() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(boolean force, final RelationListReqType reqType) {
        m buddyService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (buddyService = ((IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "all")).getBuddyService()) != null) {
            buddyService.getBuddyListV2("getNormalBuddyList", force, com.tencent.qqnt.ntrelation.constant.a.f359917a.a(reqType), new IBuddyListCallback() { // from class: com.tencent.qqnt.ntrelation.friendsinfo.manager.b
                @Override // com.tencent.qqnt.kernel.nativeinterface.IBuddyListCallback
                public final void onResult(int i3, String str, ArrayList arrayList) {
                    c.i(RelationListReqType.this, i3, str, arrayList);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(RelationListReqType reqType, int i3, String str, ArrayList data) {
        Intrinsics.checkNotNullParameter(reqType, "$reqType");
        if (((IFriendsTABService) QRoute.api(IFriendsTABService.class)).getNormalBuddyListSyncSwitch()) {
            c cVar = f360050a;
            Intrinsics.checkNotNullExpressionValue(data, "data");
            cVar.u(i3, str, data, reqType);
        } else {
            c cVar2 = f360050a;
            Intrinsics.checkNotNullExpressionValue(data, "data");
            cVar2.j(i3, str, data, reqType);
        }
    }

    private final void j(int result, String errMsg, ArrayList<BuddyListCategory> data, RelationListReqType reqType) {
        com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> eVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.e<>();
        int size = data.size();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("initFriendsInfoListener getBuddyList result ");
        sb5.append(result);
        sb5.append(" errMsg ");
        sb5.append(errMsg);
        sb5.append(" dataCount ");
        sb5.append(size);
        String str = " reqType: ";
        sb5.append(" reqType: ");
        sb5.append(reqType);
        int i3 = 1;
        QLog.i("FriendsInfoManager", 1, sb5.toString());
        if (result != 0) {
            eVar.d(-1);
        } else {
            ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> arrayList = new ArrayList<>();
            arrayList.clear();
            Iterator<BuddyListCategory> it = data.iterator();
            while (it.hasNext()) {
                BuddyListCategory data2 = it.next();
                Intrinsics.checkNotNullExpressionValue(data2, "data");
                BuddyListCategory buddyListCategory = data2;
                QLog.i("FriendsInfoManager", i3, cq.w("UpdateCategory id: " + buddyListCategory.categoryId + ", name " + buddyListCategory.categroyName + " onLine: " + buddyListCategory.onlineCount + " total: " + buddyListCategory.categroyMbCount + str + reqType, 2));
                int i16 = buddyListCategory.categoryId;
                String str2 = buddyListCategory.categroyName;
                int i17 = buddyListCategory.categroyMbCount;
                int i18 = buddyListCategory.onlineCount;
                byte b16 = (byte) buddyListCategory.categorySortId;
                IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
                ArrayList<String> arrayList2 = buddyListCategory.buddyUids;
                String str3 = str;
                Intrinsics.checkNotNullExpressionValue(arrayList2, "info.buddyUids");
                ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> friendSimpleInfoWithUid = iFriendsInfoService.getFriendSimpleInfoWithUid(arrayList2, "FriendsInfoManager");
                if (friendSimpleInfoWithUid == null) {
                    friendSimpleInfoWithUid = new ArrayList<>();
                }
                ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> arrayList3 = friendSimpleInfoWithUid;
                ArrayList<String> arrayList4 = buddyListCategory.buddyUids;
                Intrinsics.checkNotNullExpressionValue(arrayList4, "info.buddyUids");
                arrayList.add(new com.tencent.qqnt.ntrelation.friendsinfo.bean.b(i16, str2, i17, i18, b16, arrayList3, arrayList4));
                str = str3;
                i3 = 1;
            }
            eVar.e(arrayList);
        }
        if (reqType == RelationListReqType.LETTER) {
            s(eVar, true);
        } else if (reqType == RelationListReqType.NORMAL) {
            q(eVar, true);
        }
    }

    private final void n(RelationObserverType observerType, ConcurrentHashMap<Integer, i> map, com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> responseData) {
        Iterator<Map.Entry<Integer, i>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            i value = it.next().getValue();
            if (value.a() == null || observerType == RelationObserverType.ONLY_ONCE) {
                it.remove();
            }
            value.b(responseData);
        }
    }

    private final synchronized void u(int result, String errMsg, ArrayList<BuddyListCategory> data, RelationListReqType reqType) {
        j(result, errMsg, data, reqType);
    }

    public final void d(@Nullable String trace, @NotNull hx3.b<String> iQueryGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) trace, (Object) iQueryGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        int hashCode = iQueryGeneralDataCallback.hashCode();
        ConcurrentHashMap<Integer, j> concurrentHashMap = changeFriendUidsCallbackHashMap;
        if (concurrentHashMap.contains(Integer.valueOf(hashCode))) {
            QLog.i("FriendsInfoManager", 1, "addAnySimpleInfoChange insert exited callback, hashcode is " + hashCode);
            return;
        }
        concurrentHashMap.put(Integer.valueOf(iQueryGeneralDataCallback.hashCode()), new j(trace, new WeakReference(iQueryGeneralDataCallback)));
    }

    public final void e(@NotNull RelationListReqType reqType, boolean isObserver, @Nullable String trace, boolean forceUpdate, @NotNull hx3.b<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> iQueryGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, reqType, Boolean.valueOf(isObserver), trace, Boolean.valueOf(forceUpdate), iQueryGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(reqType, "reqType");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        if (isObserver) {
            l(reqType, RelationObserverType.CONTINUOUS, trace, iQueryGeneralDataCallback);
        } else {
            l(reqType, RelationObserverType.ONLY_ONCE, trace, iQueryGeneralDataCallback);
        }
        QLog.i("FriendsInfoManager", 1, "categoryInfo forceUpdate " + forceUpdate + ", request trace " + trace);
        h(forceUpdate, reqType);
    }

    @Nullable
    public final ConcurrentHashMap<Integer, i> g(@NotNull RelationListReqType reqType, @NotNull RelationObserverType observerType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ConcurrentHashMap) iPatchRedirector.redirect((short) 3, (Object) this, (Object) reqType, (Object) observerType);
        }
        Intrinsics.checkNotNullParameter(reqType, "reqType");
        Intrinsics.checkNotNullParameter(observerType, "observerType");
        int i3 = a.f360063a[reqType.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                return null;
            }
            if (observerType == RelationObserverType.CONTINUOUS) {
                return allLetterCallBackHashMap;
            }
            if (observerType != RelationObserverType.ONLY_ONCE) {
                return null;
            }
            return allLetterOnceCallBackHashMap;
        }
        if (observerType == RelationObserverType.CONTINUOUS) {
            return allCategoryCallbackHashMap;
        }
        if (observerType != RelationObserverType.ONLY_ONCE) {
            return null;
        }
        return allCategoryOnceCallbackHashMap;
    }

    public final void k(@Nullable String trace, boolean forceInit) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, trace, Boolean.valueOf(forceInit));
            return;
        }
        QLog.i("FriendsInfoManager", 1, "trace " + trace + " initFriendsInfoListener hasInit is " + hasInitListener + "\uff0cforce " + forceInit);
        if (hasInitListener && !forceInit) {
            return;
        }
        hasInitListener = true;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        m buddyService = ((IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "all")).getBuddyService();
        if (buddyService != null) {
            buddyService.I(f());
        }
        y profileService = ((IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "all")).getProfileService();
        if (profileService != null) {
            profileService.r0(mKernelProfileListener);
        }
        MutualMarkCacheEntityManager.f360092a.k();
    }

    public final void l(@NotNull RelationListReqType reqType, @NotNull RelationObserverType observerType, @Nullable String trace, @NotNull hx3.b<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> iQueryGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, reqType, observerType, trace, iQueryGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(reqType, "reqType");
        Intrinsics.checkNotNullParameter(observerType, "observerType");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        int hashCode = iQueryGeneralDataCallback.hashCode();
        ConcurrentHashMap<Integer, i> g16 = g(reqType, observerType);
        if (g16 == null || g16.contains(Integer.valueOf(hashCode))) {
            return;
        }
        QLog.i("FriendsInfoManager", 1, trace + " insertCategoryInfoCallbackV2 hashcode = " + hashCode);
        g16.put(Integer.valueOf(hashCode), new i(trace, iQueryGeneralDataCallback));
    }

    public final void m(@NotNull String uid, @Nullable String trace, @NotNull hx3.b<com.tencent.qqnt.ntrelation.friendsinfo.bean.c> iQueryGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, uid, trace, iQueryGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        ConcurrentHashMap<String, ConcurrentHashMap<Integer, k>> concurrentHashMap = friendDetailInfoCallbackHashMap;
        ConcurrentHashMap<Integer, k> concurrentHashMap2 = concurrentHashMap.get(uid);
        if (concurrentHashMap2 == null) {
            concurrentHashMap2 = new ConcurrentHashMap<>();
        }
        int hashCode = iQueryGeneralDataCallback.hashCode();
        if (concurrentHashMap2.contains(Integer.valueOf(hashCode))) {
            return;
        }
        concurrentHashMap2.put(Integer.valueOf(hashCode), new k(uid, trace, new WeakReference(iQueryGeneralDataCallback)));
        concurrentHashMap.put(uid, concurrentHashMap2);
    }

    public final void o(@NotNull ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) result);
            return;
        }
        Intrinsics.checkNotNullParameter(result, "result");
        Iterator<Map.Entry<Integer, l>> it = allFriendsCallbackHashMap.entrySet().iterator();
        com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> eVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.e<>();
        eVar.e(result);
        while (it.hasNext()) {
            l value = it.next().getValue();
            if (value.a().get() == null) {
                it.remove();
            } else {
                value.b(eVar);
            }
        }
    }

    public final void p(@NotNull ArrayList<String> uids) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) uids);
            return;
        }
        Intrinsics.checkNotNullParameter(uids, "uids");
        if (uids.isEmpty()) {
            return;
        }
        com.tencent.qqnt.ntrelation.friendsinfo.bean.e<String> eVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.e<>();
        eVar.e(uids);
        Iterator<Map.Entry<Integer, j>> it = changeFriendUidsCallbackHashMap.entrySet().iterator();
        while (it.hasNext()) {
            j value = it.next().getValue();
            if (value.a().get() == null) {
                it.remove();
            } else {
                value.b(eVar);
            }
        }
    }

    public final void q(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> responseData, boolean isFromKernel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, responseData, Boolean.valueOf(isFromKernel));
            return;
        }
        if (((IFriendsTABService) QRoute.api(IFriendsTABService.class)).isNtDataService() != isFromKernel) {
            return;
        }
        RelationListReqType relationListReqType = RelationListReqType.NORMAL;
        RelationObserverType relationObserverType = RelationObserverType.ONLY_ONCE;
        ConcurrentHashMap<Integer, i> g16 = g(relationListReqType, relationObserverType);
        if (g16 != null) {
            f360050a.n(relationObserverType, g16, responseData);
        }
        RelationObserverType relationObserverType2 = RelationObserverType.CONTINUOUS;
        ConcurrentHashMap<Integer, i> g17 = g(relationListReqType, relationObserverType2);
        if (g17 != null) {
            f360050a.n(relationObserverType2, g17, responseData);
        }
    }

    public final void r(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.friendsinfo.bean.c> responseData) {
        ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.c> arrayList;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) responseData);
            return;
        }
        if (responseData != null) {
            arrayList = responseData.b();
        } else {
            arrayList = null;
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<com.tencent.qqnt.ntrelation.friendsinfo.bean.c> it = arrayList.iterator();
            while (it.hasNext()) {
                com.tencent.qqnt.ntrelation.friendsinfo.bean.c next = it.next();
                ConcurrentHashMap<Integer, k> concurrentHashMap = friendDetailInfoCallbackHashMap.get(next.getUid());
                if (concurrentHashMap != null && !concurrentHashMap.isEmpty()) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.c> arrayList2 = new ArrayList<>();
                    arrayList2.add(next);
                    com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.friendsinfo.bean.c> eVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.e<>();
                    eVar.e(arrayList2);
                    Iterator<Map.Entry<Integer, k>> it5 = concurrentHashMap.entrySet().iterator();
                    while (it5.hasNext()) {
                        k value = it5.next().getValue();
                        if (value.a().get() == null) {
                            it5.remove();
                        } else {
                            value.b(eVar);
                        }
                    }
                }
            }
        }
    }

    public final void s(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> responseData, boolean isFromKernel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, responseData, Boolean.valueOf(isFromKernel));
            return;
        }
        if (((IFriendsTABService) QRoute.api(IFriendsTABService.class)).isNtDataService() != isFromKernel) {
            return;
        }
        RelationListReqType relationListReqType = RelationListReqType.LETTER;
        RelationObserverType relationObserverType = RelationObserverType.ONLY_ONCE;
        ConcurrentHashMap<Integer, i> g16 = g(relationListReqType, relationObserverType);
        if (g16 != null) {
            f360050a.n(relationObserverType, g16, responseData);
        }
        RelationObserverType relationObserverType2 = RelationObserverType.CONTINUOUS;
        ConcurrentHashMap<Integer, i> g17 = g(relationListReqType, relationObserverType2);
        if (g17 != null) {
            f360050a.n(relationObserverType2, g17, responseData);
        }
    }

    public final void t(@NotNull com.tencent.qqnt.ntrelation.friendsinfo.bean.d ntFriendSimpleInfo) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) ntFriendSimpleInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(ntFriendSimpleInfo, "ntFriendSimpleInfo");
        ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> arrayList = new ArrayList<>();
        arrayList.add(ntFriendSimpleInfo);
        ConcurrentHashMap<Integer, l> concurrentHashMap = friendSimpleInfoCallbackHashMap.get(ntFriendSimpleInfo.getUid());
        if (concurrentHashMap != null && !concurrentHashMap.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> eVar = new com.tencent.qqnt.ntrelation.friendsinfo.bean.e<>();
        eVar.e(arrayList);
        Iterator<Map.Entry<Integer, l>> it = concurrentHashMap.entrySet().iterator();
        while (it.hasNext()) {
            l value = it.next().getValue();
            if (value.a().get() == null) {
                it.remove();
            } else {
                value.c(eVar);
            }
        }
    }

    public final void v(@NotNull RelationListReqType reqType, @Nullable String trace, @NotNull hx3.b<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> iQueryGeneralDataCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, reqType, trace, iQueryGeneralDataCallback);
            return;
        }
        Intrinsics.checkNotNullParameter(reqType, "reqType");
        Intrinsics.checkNotNullParameter(iQueryGeneralDataCallback, "iQueryGeneralDataCallback");
        int i3 = a.f360063a[reqType.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                int hashCode = iQueryGeneralDataCallback.hashCode();
                ConcurrentHashMap<Integer, i> concurrentHashMap = allLetterCallBackHashMap;
                QLog.i("FriendsInfoManager", 1, "unregisterFriendCategoryInfoV2Callback hashcode " + hashCode + " allLetterCallBackHashMap = " + concurrentHashMap);
                Iterator<Map.Entry<Integer, i>> it = concurrentHashMap.entrySet().iterator();
                while (it.hasNext()) {
                    if (it.next().getKey().intValue() == hashCode) {
                        it.remove();
                    }
                }
                QLog.i("FriendsInfoManager", 1, "unregisterFriendCategoryInfoV2Callback removed allLetterCallBackHashMap.size = " + allLetterCallBackHashMap);
                return;
            }
            return;
        }
        int hashCode2 = iQueryGeneralDataCallback.hashCode();
        ConcurrentHashMap<Integer, i> concurrentHashMap2 = allCategoryCallbackHashMap;
        QLog.i("FriendsInfoManager", 1, "unregisterFriendCategoryInfoV2Callback hashcode " + hashCode2 + " allCategoryCallbackHashMap = " + concurrentHashMap2);
        Iterator<Map.Entry<Integer, i>> it5 = concurrentHashMap2.entrySet().iterator();
        while (it5.hasNext()) {
            if (it5.next().getKey().intValue() == hashCode2) {
                it5.remove();
            }
        }
        QLog.i("FriendsInfoManager", 1, "unregisterFriendCategoryInfoV2Callback removed allCategoryCallbackHashMap = " + allCategoryCallbackHashMap);
    }
}
