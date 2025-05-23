package com.tencent.mobileqq.troop.selectmember.helper;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0010$\n\u0002\b\u0006\u0018\u0000 \u00162\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u001c\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005R\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bRl\u0010\u0013\u001aZ\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u000e0\u000e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u000f*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00100\u0010 \u000f*,\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u000e0\u000e\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003 \u000f*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00100\u0010\u0018\u00010\u00110\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/troop/selectmember/helper/c;", "", "", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;", "troopMemberInfoList", "Lcom/tencent/mobileqq/troop/selectmember/helper/a;", "callback", "", "b", "Lmqq/util/WeakReference;", "a", "Lmqq/util/WeakReference;", "callbackRef", "", "", "kotlin.jvm.PlatformType", "", "", "Ljava/util/Map;", "indexedFriends", "<init>", "()V", "c", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private WeakReference<a> callbackRef;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Map<String, List<TroopMemberInfo>> indexedFriends;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troop/selectmember/helper/c$a;", "", "", "PROCESS_MEM_COUNT_PER_JOB", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.selectmember.helper.c$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24916);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.callbackRef = new WeakReference<>(null);
            this.indexedFriends = Collections.synchronizedMap(new LinkedHashMap());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0093 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void c(List troopMemberInfoList, int i3, int i16, c this$0, AtomicInteger activeThreadCount) {
        a aVar;
        String str;
        char charAt;
        boolean z16;
        String upperCase;
        Map<String, List<TroopMemberInfo>> indexedFriends;
        boolean z17;
        Intrinsics.checkNotNullParameter(troopMemberInfoList, "$troopMemberInfoList");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activeThreadCount, "$activeThreadCount");
        Iterator it = troopMemberInfoList.subList(i3, i16).iterator();
        while (true) {
            boolean z18 = true;
            if (!it.hasNext()) {
                break;
            }
            TroopMemberInfo troopMemberInfo = (TroopMemberInfo) it.next();
            String showNamePyFirst = troopMemberInfo.nickInfo.getUIInfo().getShowNamePyFirst();
            troopMemberInfo.displayedNamePinyinFirst = showNamePyFirst;
            if (showNamePyFirst != null) {
                Intrinsics.checkNotNullExpressionValue(showNamePyFirst, "tm.displayedNamePinyinFirst");
                if (showNamePyFirst.length() == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!z17) {
                    String str2 = troopMemberInfo.displayedNamePinyinFirst;
                    Intrinsics.checkNotNullExpressionValue(str2, "tm.displayedNamePinyinFirst");
                    str = str2.substring(0, 1);
                    Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                    charAt = str.charAt(0);
                    if ('A' > charAt && charAt < '[') {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16) {
                        if ('a' > charAt || charAt >= '{') {
                            z18 = false;
                        }
                        if (!z18) {
                            upperCase = "#";
                            indexedFriends = this$0.indexedFriends;
                            Intrinsics.checkNotNullExpressionValue(indexedFriends, "indexedFriends");
                            synchronized (indexedFriends) {
                                if (this$0.indexedFriends.get(upperCase) == null) {
                                    Map<String, List<TroopMemberInfo>> indexedFriends2 = this$0.indexedFriends;
                                    Intrinsics.checkNotNullExpressionValue(indexedFriends2, "indexedFriends");
                                    indexedFriends2.put(upperCase, new ArrayList());
                                }
                                List<TroopMemberInfo> list = this$0.indexedFriends.get(upperCase);
                                if (list != null) {
                                    list.add(troopMemberInfo);
                                }
                            }
                        }
                    }
                    upperCase = str.toUpperCase();
                    Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase()");
                    indexedFriends = this$0.indexedFriends;
                    Intrinsics.checkNotNullExpressionValue(indexedFriends, "indexedFriends");
                    synchronized (indexedFriends) {
                    }
                }
            }
            str = "#";
            charAt = str.charAt(0);
            if ('A' > charAt) {
            }
            z16 = false;
            if (!z16) {
            }
            upperCase = str.toUpperCase();
            Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase()");
            indexedFriends = this$0.indexedFriends;
            Intrinsics.checkNotNullExpressionValue(indexedFriends, "indexedFriends");
            synchronized (indexedFriends) {
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopMemberNamePinyinCollector", 2, "[collect] end, id:" + Thread.currentThread().getId() + ", threadCnt:" + activeThreadCount.get());
        }
        if (activeThreadCount.getAndDecrement() <= 1 && (aVar = this$0.callbackRef.get()) != null) {
            Map<String, List<TroopMemberInfo>> indexedFriends3 = this$0.indexedFriends;
            Intrinsics.checkNotNullExpressionValue(indexedFriends3, "indexedFriends");
            aVar.u(indexedFriends3);
        }
    }

    public final void b(@NotNull final List<? extends TroopMemberInfo> troopMemberInfoList, @NotNull a callback) {
        int i3;
        final int coerceAtMost;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopMemberInfoList, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(troopMemberInfoList, "troopMemberInfoList");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callbackRef = new WeakReference<>(callback);
        int size = troopMemberInfoList.size();
        if (size > 0) {
            int i16 = size / 1000;
            final int i17 = 0;
            if (size % 1000 == 0) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            final AtomicInteger atomicInteger = new AtomicInteger(i16 + i3);
            if (QLog.isColorLevel()) {
                QLog.i("TroopMemberNamePinyinCollector", 2, "[collect] jobCount: " + atomicInteger.get());
            }
            while (i17 < size) {
                int i18 = i17 + 1000;
                coerceAtMost = RangesKt___RangesKt.coerceAtMost(i18 - 1, size);
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.troop.selectmember.helper.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        c.c(troopMemberInfoList, i17, coerceAtMost, this, atomicInteger);
                    }
                }, 16, null, true);
                i17 = i18;
            }
            return;
        }
        a aVar = this.callbackRef.get();
        if (aVar != null) {
            aVar.u(new LinkedHashMap());
        }
    }
}
