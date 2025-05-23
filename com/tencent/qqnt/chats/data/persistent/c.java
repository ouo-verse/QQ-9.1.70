package com.tencent.qqnt.chats.data.persistent;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.aa;
import com.tencent.qqnt.kernel.nativeinterface.CompleteRecentContactInfo;
import com.tencent.qqnt.kernel.nativeinterface.IKernelRecentSnapShotCallback;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.kernel.nativeinterface.cq;
import com.tencent.qqnt.kernel.utils.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import mqq.app.QActivityLifecycleCallbacks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000U\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b*\u0001)\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b3\u00104J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0002J&\u0010\u000e\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0002J \u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0002J$\u0010\u0013\u001a\u00020\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u000bH\u0002J\u0010\u0010\u0016\u001a\u00020\t2\b\b\u0002\u0010\u0015\u001a\u00020\u0014J\u0006\u0010\u0017\u001a\u00020\tJ\u0006\u0010\u0018\u001a\u00020\tJ\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00110\u000bJ\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00110\u000bJ\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\u0006\u0010\u001d\u001a\u00020\tJ\u0006\u0010\u001e\u001a\u00020\tR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010%\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010&R\u0016\u0010(\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010&R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010/\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010.R\u001c\u00101\u001a\b\u0012\u0004\u0012\u00020\u00110\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u00100R\u001c\u00102\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u00100\u00a8\u00065"}, d2 = {"Lcom/tencent/qqnt/chats/data/persistent/c;", "", "", "data", "", "key", "Landroid/content/Context;", "context", "uin", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "", "sortList", "r", DomainData.DOMAIN_NAME, "i", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "changeData", "g", "", "immediately", "e", "p", h.F, "j", "k", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "d", "o", "Landroid/os/Handler;", "b", "Landroid/os/Handler;", "fileThreadHandler", "c", "J", "lastWriteTime", "Z", "isForeground", "isAddListener", "com/tencent/qqnt/chats/data/persistent/c$a", "f", "Lcom/tencent/qqnt/chats/data/persistent/c$a;", "foregroundListener", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "writeRunnable", "Ljava/util/List;", "cacheList", "cacheSortList", "<init>", "()V", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f355136a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Handler fileThreadHandler;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static long lastWriteTime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static boolean isForeground;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static boolean isAddListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final a foregroundListener;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Runnable writeRunnable;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static List<RecentContactInfo> cacheList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static List<Long> cacheSortList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0004H\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016\u00a8\u0006\u0011"}, d2 = {"com/tencent/qqnt/chats/data/persistent/c$a", "Lmqq/app/QActivityLifecycleCallbacks;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onActivityCreated", "onActivityStarted", "onActivityResumed", "onActivityPaused", "onActivityStopped", "outState", "onActivitySaveInstanceState", "onActivityDestroyed", "onProcessForeground", "onProcessBackground", "chats_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class a implements QActivityLifecycleCallbacks {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) savedInstanceState);
            } else {
                Intrinsics.checkNotNullParameter(activity, "activity");
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(@NotNull Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) activity);
            } else {
                Intrinsics.checkNotNullParameter(activity, "activity");
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(@NotNull Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
            } else {
                Intrinsics.checkNotNullParameter(activity, "activity");
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(@NotNull Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
            } else {
                Intrinsics.checkNotNullParameter(activity, "activity");
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(@NotNull Activity activity, @NotNull Bundle outState) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) activity, (Object) outState);
            } else {
                Intrinsics.checkNotNullParameter(activity, "activity");
                Intrinsics.checkNotNullParameter(outState, "outState");
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(@NotNull Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
            } else {
                Intrinsics.checkNotNullParameter(activity, "activity");
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(@NotNull Activity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity);
            } else {
                Intrinsics.checkNotNullParameter(activity, "activity");
            }
        }

        @Override // mqq.app.QActivityLifecycleCallbacks
        public void onProcessBackground() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
                c.isForeground = false;
            } else {
                iPatchRedirector.redirect((short) 10, (Object) this);
            }
        }

        @Override // mqq.app.QActivityLifecycleCallbacks
        public void onProcessForeground() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
                c.isForeground = true;
            } else {
                iPatchRedirector.redirect((short) 9, (Object) this);
            }
        }
    }

    static {
        List<RecentContactInfo> emptyList;
        List<Long> emptyList2;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45755);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
            return;
        }
        f355136a = new c();
        fileThreadHandler = new Handler(ThreadManagerV2.getFileThreadLooper());
        isForeground = true;
        foregroundListener = new a();
        writeRunnable = new Runnable() { // from class: com.tencent.qqnt.chats.data.persistent.a
            @Override // java.lang.Runnable
            public final void run() {
                c.s();
            }
        };
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        cacheList = emptyList;
        emptyList2 = CollectionsKt__CollectionsKt.emptyList();
        cacheSortList = emptyList2;
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static /* synthetic */ void f(c cVar, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        cVar.e(z16);
    }

    private final String g(List<Long> sortList, List<RecentContactInfo> changeData) {
        String joinToString$default;
        String str;
        HashMap hashMap = new HashMap();
        for (RecentContactInfo recentContactInfo : changeData) {
            hashMap.put(Long.valueOf(recentContactInfo.contactId), recentContactInfo);
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = sortList.iterator();
        while (it.hasNext()) {
            RecentContactInfo recentContactInfo2 = (RecentContactInfo) hashMap.get(Long.valueOf(((Number) it.next()).longValue()));
            if (recentContactInfo2 != null) {
                str = recentContactInfo2.peerName;
            } else {
                str = null;
            }
            if (str != null) {
                arrayList.add(str);
            }
        }
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(arrayList, ",", null, null, 0, null, null, 62, null);
        return joinToString$default;
    }

    private final byte[] i(String key, Context context, String uin) {
        MMKVOptionEntity from = QMMKV.from(context, "q_chat_item_mmkv_file_" + uin);
        Intrinsics.checkNotNullExpressionValue(from, "from(context, \"${CHAT_ITEM_MMKV_FILE}_$uin\")");
        byte[] res = from.decodeBytes(key, new byte[0]);
        QLog.d("ChatsItemWriter", 1, "readChatItemFromFile, size: " + res.length);
        Intrinsics.checkNotNullExpressionValue(res, "res");
        return res;
    }

    private final List<Long> n(Context context, String uin) {
        int collectionSizeOrDefault;
        boolean z16;
        MMKVOptionEntity from = QMMKV.from(context, "q_chat_item_mmkv_file_" + uin);
        Intrinsics.checkNotNullExpressionValue(from, "from(context, \"${CHAT_ITEM_MMKV_FILE}_$uin\")");
        IntRange intRange = new IntRange(0, 15);
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(intRange, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<Integer> it = intRange.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(from.decodeLong(String.valueOf(((IntIterator) it).nextInt()), -1L)));
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((Number) obj).longValue() != -1) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList2.add(obj);
            }
        }
        return arrayList2;
    }

    private final void q(byte[] data, String key, Context context, String uin) {
        QLog.d("ChatsItemWriter", 2, "writeChatItemToFile: " + data.length);
        MMKVOptionEntity from = QMMKV.from(context, "q_chat_item_mmkv_file_" + uin);
        Intrinsics.checkNotNullExpressionValue(from, "from(context, \"${CHAT_ITEM_MMKV_FILE}_$uin\")");
        from.encodeBytes(key, data);
        from.commitSync();
    }

    private final void r(List<Long> sortList, Context context, String uin) {
        QLog.d("ChatsItemWriter", 2, "writeChatItemToFile: " + sortList.size());
        MMKVOptionEntity from = QMMKV.from(context, "q_chat_item_mmkv_file_" + uin);
        Intrinsics.checkNotNullExpressionValue(from, "from(context, \"${CHAT_ITEM_MMKV_FILE}_$uin\")");
        int i3 = 0;
        for (Object obj : sortList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            from.encodeLong(String.valueOf(i3), ((Number) obj).longValue());
            i3 = i16;
        }
        from.commitSync();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s() {
        QLog.d("ChatsItemWriter", 1, "begin writeRunnable");
        final AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        aa recentContactService = ((IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")).getRecentContactService();
        if (recentContactService == null) {
            return;
        }
        lastWriteTime = System.currentTimeMillis();
        recentContactService.getRecentContactListSnapShot(15, new IKernelRecentSnapShotCallback() { // from class: com.tencent.qqnt.chats.data.persistent.b
            @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRecentSnapShotCallback
            public final void onResult(int i3, String str, CompleteRecentContactInfo completeRecentContactInfo) {
                c.t(AppRuntime.this, i3, str, completeRecentContactInfo);
            }
        });
        f355136a.p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(AppRuntime appRuntime, int i3, String str, CompleteRecentContactInfo completeRecentContactInfo) {
        if (i3 == 0 && completeRecentContactInfo != null) {
            if (QLog.isColorLevel() || !com.tencent.qqnt.util.b.f362976b.isPublicVersion()) {
                c cVar = f355136a;
                ArrayList<Long> arrayList = completeRecentContactInfo.sortedContactList;
                Intrinsics.checkNotNullExpressionValue(arrayList, "data.sortedContactList");
                ArrayList<RecentContactInfo> arrayList2 = completeRecentContactInfo.changedList;
                Intrinsics.checkNotNullExpressionValue(arrayList2, "data.changedList");
                QLog.d("ChatsItemWriter", 2, "logWriteData: ", cVar.g(arrayList, arrayList2));
            }
            byte[] bArr = completeRecentContactInfo.dataBuffer;
            if (bArr != null && completeRecentContactInfo.sortedContactList != null) {
                c cVar2 = f355136a;
                Intrinsics.checkNotNullExpressionValue(bArr, "data.dataBuffer");
                MobileQQ sMobileQQ = MobileQQ.sMobileQQ;
                Intrinsics.checkNotNullExpressionValue(sMobileQQ, "sMobileQQ");
                String currentUin = appRuntime.getCurrentUin();
                Intrinsics.checkNotNullExpressionValue(currentUin, "app.currentUin");
                cVar2.q(bArr, "1-data", sMobileQQ, currentUin);
                ArrayList<Long> arrayList3 = completeRecentContactInfo.sortedContactList;
                Intrinsics.checkNotNullExpressionValue(arrayList3, "data.sortedContactList");
                MobileQQ sMobileQQ2 = MobileQQ.sMobileQQ;
                Intrinsics.checkNotNullExpressionValue(sMobileQQ2, "sMobileQQ");
                String currentUin2 = appRuntime.getCurrentUin();
                Intrinsics.checkNotNullExpressionValue(currentUin2, "app.currentUin");
                cVar2.r(arrayList3, sMobileQQ2, currentUin2);
            }
        }
    }

    public final void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else if (!isAddListener) {
            Foreground.addActivityLifeCallback(foregroundListener);
            isAddListener = true;
        }
    }

    public final void e(boolean immediately) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, immediately);
            return;
        }
        QLog.d("ChatsItemWriter", 1, "beginWriteToFile, immediately: " + immediately);
        if (!n.f359273a.j()) {
            if (!immediately) {
                Handler handler = fileThreadHandler;
                Runnable runnable = writeRunnable;
                if (isForeground) {
                    j3 = 30000;
                } else {
                    j3 = 5000;
                }
                handler.postDelayed(runnable, j3);
                return;
            }
            fileThreadHandler.post(writeRunnable);
        }
    }

    public final void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            cacheList = l();
            cacheSortList = m();
        }
    }

    @NotNull
    public final List<RecentContactInfo> j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return cacheList;
    }

    @NotNull
    public final List<Long> k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return cacheSortList;
    }

    @NotNull
    public final List<RecentContactInfo> l() {
        boolean z16;
        List<RecentContactInfo> emptyList;
        List<RecentContactInfo> emptyList2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (List) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        MobileQQ sMobileQQ = MobileQQ.sMobileQQ;
        Intrinsics.checkNotNullExpressionValue(sMobileQQ, "sMobileQQ");
        String currentUin = peekAppRuntime.getCurrentUin();
        Intrinsics.checkNotNullExpressionValue(currentUin, "app.currentUin");
        byte[] i3 = i("1-data", sMobileQQ, currentUin);
        if (i3.length == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            return emptyList2;
        }
        try {
            ArrayList<RecentContactInfo> a16 = cq.a(i3);
            QLog.d("ChatsItemWriter", 1, "readRecentChatData, after Decode: " + a16.size());
            Intrinsics.checkNotNullExpressionValue(a16, "{\n            val res = \u2026            res\n        }");
            return a16;
        } catch (UnsatisfiedLinkError unused) {
            QLog.w("ChatsItemWriter", 1, "hit UnsatisfiedLinkError");
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
    }

    @NotNull
    public final List<Long> m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (List) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        MobileQQ sMobileQQ = MobileQQ.sMobileQQ;
        Intrinsics.checkNotNullExpressionValue(sMobileQQ, "sMobileQQ");
        String currentUin = peekAppRuntime.getCurrentUin();
        Intrinsics.checkNotNullExpressionValue(currentUin, "app.currentUin");
        List<Long> n3 = n(sMobileQQ, currentUin);
        QLog.d("ChatsItemWriter", 1, "readRecentSortList: " + n3.size());
        return n3;
    }

    public final void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else if (isAddListener) {
            Foreground.removeActivityLifeCallback(foregroundListener);
            isAddListener = false;
        }
    }

    public final void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            QLog.d("ChatsItemWriter", 1, "removeWriteToFile");
            fileThreadHandler.removeCallbacks(writeRunnable);
        }
    }
}
