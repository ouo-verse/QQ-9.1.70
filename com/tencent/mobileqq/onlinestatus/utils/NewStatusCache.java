package com.tencent.mobileqq.onlinestatus.utils;

import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.onlinestatus.au;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010#\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b3\u00104J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\u0007\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0016\u0010\t\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\u001e\u0010\r\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0002J\u001e\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010H\u0002J\u0006\u0010\u0013\u001a\u00020\u0002J\u0014\u0010\u0014\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u0018\u0010\u0019\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0018\u001a\u00020\u0017J\u0018\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0018\u001a\u00020\u0017J\u0006\u0010\u001c\u001a\u00020\u0002R\u0016\u0010\u001f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R8\u0010&\u001a&\u0012\f\u0012\n $*\u0004\u0018\u00010\b0\b $*\u0012\u0012\f\u0012\n $*\u0004\u0018\u00010\b0\b\u0018\u00010\u00040#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010%R8\u0010(\u001a&\u0012\f\u0012\n $*\u0004\u0018\u00010\b0\b $*\u0012\u0012\f\u0012\n $*\u0004\u0018\u00010\b0\b\u0018\u00010\u00040#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010%R\u001c\u0010*\u001a\b\u0012\u0004\u0012\u00020\b0\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010%R\u0014\u0010-\u001a\u00020+8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b)\u0010,R$\u00102\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020\u000e8B@BX\u0082\u000e\u00a2\u0006\f\u001a\u0004\b'\u0010/\"\u0004\b0\u00101\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/utils/NewStatusCache;", "", "", tl.h.F, "", "Lcom/tencent/mobileqq/onlinestatus/au;", "newStatusSet", "k", "", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "key", "values", "p", "", "threadType", "Lkotlin/Function0;", "block", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "j", "Lmqq/app/AppRuntime$Status;", "status", "", "extStatus", "l", "", "g", "d", "b", "I", "mLoadState", "c", "Ljava/lang/String;", "mKey", "", "kotlin.jvm.PlatformType", "Ljava/util/Set;", "mAlreadySetCollection", "e", "mAlreadySetBuffer", "f", "mNewStatusCollection", "Lcom/tencent/mobileqq/qmmkv/v2/MMKVOptionEntityV2;", "()Lcom/tencent/mobileqq/qmmkv/v2/MMKVOptionEntityV2;", "mEntity", "value", "()I", "r", "(I)V", "loadState", "<init>", "()V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class NewStatusCache {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static int mLoadState;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static Set<String> mNewStatusCollection;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final NewStatusCache f256304a = new NewStatusCache();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String mKey = "";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final Set<String> mAlreadySetCollection = Collections.newSetFromMap(new ConcurrentHashMap());

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final Set<String> mAlreadySetBuffer = Collections.newSetFromMap(new ConcurrentHashMap());

    static {
        Set<String> emptySet;
        emptySet = SetsKt__SetsKt.emptySet();
        mNewStatusCollection = emptySet;
    }

    NewStatusCache() {
    }

    private final int e() {
        return mLoadState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MMKVOptionEntityV2 f() {
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        return fromV2;
    }

    private final void h() {
        r(1);
        Set<String> stringSet = f().getStringSet(mKey, null);
        if (stringSet != null) {
            mAlreadySetCollection.addAll(stringSet);
        }
        Set<String> mAlreadySetBuffer2 = mAlreadySetBuffer;
        Intrinsics.checkNotNullExpressionValue(mAlreadySetBuffer2, "mAlreadySetBuffer");
        if (!mAlreadySetBuffer2.isEmpty()) {
            Set<String> set = mAlreadySetCollection;
            Intrinsics.checkNotNullExpressionValue(mAlreadySetBuffer2, "mAlreadySetBuffer");
            set.addAll(mAlreadySetBuffer2);
        }
        r(2);
        QLog.d("NewStatusCache", 1, "already set loaded: " + mAlreadySetCollection);
    }

    private final void i(Set<String> newStatusSet) {
        Set<String> emptySet;
        mNewStatusCollection = newStatusSet;
        QLog.d("NewStatusCache", 1, "merge new status set: " + newStatusSet);
        if (e() != 2) {
            h();
        }
        Set<String> set = mAlreadySetCollection;
        if (set.isEmpty()) {
            return;
        }
        if (newStatusSet.isEmpty()) {
            mAlreadySetBuffer.clear();
            set.clear();
            String str = mKey;
            emptySet = SetsKt__SetsKt.emptySet();
            p(str, emptySet);
            return;
        }
        HashSet hashSet = new HashSet();
        for (String str2 : set) {
            if (!newStatusSet.contains(str2)) {
                hashSet.add(str2);
            }
        }
        if (!hashSet.isEmpty()) {
            mAlreadySetCollection.removeAll(hashSet);
        }
        if (!(!hashSet.isEmpty())) {
            Set<String> mAlreadySetBuffer2 = mAlreadySetBuffer;
            Intrinsics.checkNotNullExpressionValue(mAlreadySetBuffer2, "mAlreadySetBuffer");
            if (!(!mAlreadySetBuffer2.isEmpty())) {
                return;
            }
        }
        mAlreadySetBuffer.clear();
        q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(Set<? extends au> newStatusSet) {
        HashSet hashSet = new HashSet();
        for (au auVar : newStatusSet) {
            hashSet.add(au.a(auVar.f255494g, auVar.f255489b));
        }
        i(hashSet);
    }

    private final void n(int threadType, final Function0<Unit> block) {
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.onlinestatus.utils.s
                @Override // java.lang.Runnable
                public final void run() {
                    NewStatusCache.o(Function0.this);
                }
            }, threadType, null, false);
        } else {
            block.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(Function0 block) {
        Intrinsics.checkNotNullParameter(block, "$block");
        block.invoke();
    }

    private final void p(final String key, final Set<String> values) {
        n(64, new Function0<Unit>() { // from class: com.tencent.mobileqq.onlinestatus.utils.NewStatusCache$saveSetToMMKV$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                MMKVOptionEntityV2 f16;
                f16 = NewStatusCache.f256304a.f();
                f16.putStringSet(key, values);
                QLog.d("NewStatusCache", 1, "save: " + values);
            }
        });
    }

    private final void q() {
        p(mKey, new HashSet(mAlreadySetCollection));
    }

    private final void r(int i3) {
        int i16 = mLoadState;
        if (i3 != i16) {
            QLog.d("NewStatusCache", 1, "load state change " + i16 + " -> " + i3);
            mLoadState = i3;
        }
    }

    public final void d() {
        mAlreadySetCollection.clear();
        q();
    }

    public final boolean g(@Nullable AppRuntime.Status status, long extStatus) {
        if (status == null || extStatus == -1) {
            return false;
        }
        String a16 = au.a(status, extStatus);
        if (!mNewStatusCollection.contains(a16) || mAlreadySetCollection.contains(a16)) {
            return false;
        }
        return true;
    }

    public final void j(@NotNull final Set<? extends au> newStatusSet) {
        Intrinsics.checkNotNullParameter(newStatusSet, "newStatusSet");
        n(64, new Function0<Unit>() { // from class: com.tencent.mobileqq.onlinestatus.utils.NewStatusCache$mergeNewStatusSet$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                NewStatusCache.f256304a.k(newStatusSet);
            }
        });
    }

    public final void l(@Nullable AppRuntime.Status status, long extStatus) {
        if (status != null && extStatus != -1) {
            m();
            String a16 = au.a(status, extStatus);
            QLog.d("NewStatusCache", 1, "on set status: " + a16);
            if (e() != 2) {
                if (e() == 0) {
                    QLog.d("NewStatusCache", 1, "data not load, save to buffer");
                    mAlreadySetBuffer.add(a16);
                    return;
                } else {
                    QLog.d("NewStatusCache", 1, "data is loading, save to cache");
                    mAlreadySetCollection.add(a16);
                    return;
                }
            }
            if (mNewStatusCollection.contains(a16)) {
                Set<String> set = mAlreadySetCollection;
                if (!set.contains(a16)) {
                    set.add(a16);
                    q();
                }
            }
        }
    }

    public final void m() {
        String str;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentUin();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        String str2 = "new_online_status_map_key_" + str;
        if (Intrinsics.areEqual(mKey, str2)) {
            return;
        }
        QLog.d("NewStatusCache", 1, "reset cache uin: " + str);
        mKey = str2;
        r(0);
        mAlreadySetCollection.clear();
        mAlreadySetBuffer.clear();
    }
}
