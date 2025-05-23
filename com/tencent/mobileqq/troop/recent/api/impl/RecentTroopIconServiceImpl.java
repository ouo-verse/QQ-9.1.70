package com.tencent.mobileqq.troop.recent.api.impl;

import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.recent.api.IRecentTroopIconService;
import com.tencent.mobileqq.troop.recent.c;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\u001a\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016JF\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0010\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n2\"\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n\u0012\u0004\u0012\u00020\u00040\u000eH\u0016R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R$\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0018j\b\u0012\u0004\u0012\u00020\u0002`\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/troop/recent/api/impl/RecentTroopIconServiceImpl;", "Lcom/tencent/mobileqq/troop/recent/api/IRecentTroopIconService;", "", "troopUin", "", "preLoadTroopIcon", "Lmqq/app/AppRuntime;", "appRuntime", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "Landroid/graphics/drawable/Drawable;", "getTroopIconListFromCache", "oldDrawableList", "Lkotlin/Function2;", "callback", "checkTroopIconListAsync", "Lcom/tencent/mobileqq/app/QQAppInterface;", "mAppRuntime", "Lcom/tencent/mobileqq/app/QQAppInterface;", "Landroid/util/SparseArray;", "Lcom/tencent/mobileqq/troop/recent/a;", "mProcessList", "Landroid/util/SparseArray;", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "mProcessingSet", "Ljava/util/HashSet;", "<init>", "()V", "Companion", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class RecentTroopIconServiceImpl implements IRecentTroopIconService {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "RecentTroopIconServiceImpl";
    private QQAppInterface mAppRuntime;

    @NotNull
    private final SparseArray<com.tencent.mobileqq.troop.recent.a> mProcessList;

    @NotNull
    private final HashSet<String> mProcessingSet;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/recent/api/impl/RecentTroopIconServiceImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.recent.api.impl.RecentTroopIconServiceImpl$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62282);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public RecentTroopIconServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mProcessList = new SparseArray<>();
            this.mProcessingSet = new HashSet<>();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkTroopIconListAsync$lambda$5(RecentTroopIconServiceImpl this$0, final String troopUin, List list, final Function2 callback) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(troopUin, "$troopUin");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        this$0.preLoadTroopIcon(troopUin);
        final List<Drawable> troopIconListFromCache = this$0.getTroopIconListFromCache(troopUin);
        if (!Intrinsics.areEqual(troopIconListFromCache, list)) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.troop.recent.api.impl.a
                @Override // java.lang.Runnable
                public final void run() {
                    RecentTroopIconServiceImpl.checkTroopIconListAsync$lambda$5$lambda$4(Function2.this, troopUin, troopIconListFromCache);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkTroopIconListAsync$lambda$5$lambda$4(Function2 callback, String troopUin, List list) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(troopUin, "$troopUin");
        callback.invoke(troopUin, list);
    }

    private final void preLoadTroopIcon(String troopUin) {
        SparseArray<com.tencent.mobileqq.troop.recent.a> sparseArray = this.mProcessList;
        int size = sparseArray.size();
        for (int i3 = 0; i3 < size; i3++) {
            sparseArray.keyAt(i3);
            com.tencent.mobileqq.troop.recent.a valueAt = sparseArray.valueAt(i3);
            QQAppInterface qQAppInterface = this.mAppRuntime;
            if (qQAppInterface == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAppRuntime");
                qQAppInterface = null;
            }
            if (valueAt.a(qQAppInterface, troopUin)) {
                return;
            }
        }
    }

    @Override // com.tencent.mobileqq.troop.recent.api.IRecentTroopIconService
    public void checkTroopIconListAsync(@NotNull final String troopUin, @Nullable final List<? extends Drawable> oldDrawableList, @NotNull final Function2<? super String, ? super List<? extends Drawable>, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, troopUin, oldDrawableList, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.troop.recent.api.impl.b
            @Override // java.lang.Runnable
            public final void run() {
                RecentTroopIconServiceImpl.checkTroopIconListAsync$lambda$5(RecentTroopIconServiceImpl.this, troopUin, oldDrawableList, callback);
            }
        }, 16, null, true);
    }

    @Override // com.tencent.mobileqq.troop.recent.api.IRecentTroopIconService
    @Nullable
    public List<Drawable> getTroopIconListFromCache(@NotNull String troopUin) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this, (Object) troopUin);
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        SparseArray<com.tencent.mobileqq.troop.recent.a> sparseArray = this.mProcessList;
        int size = sparseArray.size();
        int i3 = 0;
        while (true) {
            QQAppInterface qQAppInterface = null;
            if (i3 >= size) {
                return null;
            }
            sparseArray.keyAt(i3);
            com.tencent.mobileqq.troop.recent.a valueAt = sparseArray.valueAt(i3);
            QQAppInterface qQAppInterface2 = this.mAppRuntime;
            if (qQAppInterface2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAppRuntime");
            } else {
                qQAppInterface = qQAppInterface2;
            }
            List<Drawable> b16 = valueAt.b(qQAppInterface, troopUin);
            List<Drawable> list = b16;
            if (list != null && !list.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                return b16;
            }
            i3++;
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(@NotNull AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
            return;
        }
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        this.mAppRuntime = (QQAppInterface) appRuntime;
        c cVar = new c();
        this.mProcessList.put(cVar.c(), cVar);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        SparseArray<com.tencent.mobileqq.troop.recent.a> sparseArray = this.mProcessList;
        int size = sparseArray.size();
        for (int i3 = 0; i3 < size; i3++) {
            sparseArray.keyAt(i3);
            sparseArray.valueAt(i3).onDestroy();
        }
    }
}
