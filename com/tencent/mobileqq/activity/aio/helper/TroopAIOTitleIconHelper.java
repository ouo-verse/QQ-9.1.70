package com.tencent.mobileqq.activity.aio.helper;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleKt;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.aio.event.AIOTitleEvent;
import com.tencent.mobileqq.aio.title.ac;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qqnt.aio.helper.cw;
import com.tencent.qqnt.troop.ITroopListRepoApi;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u000b2\u00020\u00012\u00020\u0002:\u0001*B\u0007\u00a2\u0006\u0004\b(\u0010)J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\u000b\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tH\u0002J\u0014\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tH\u0002J\b\u0010\r\u001a\u00020\nH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u000eH\u0016J\b\u0010\u0018\u001a\u00020\u0007H\u0016R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u00038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020!0 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010'\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010&\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/helper/TroopAIOTitleIconHelper;", "Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/mvi/base/route/g;", "", "curTroopUin", "", "needAnim", "", "j", "Lkotlin/Pair;", "Lcom/tencent/mobileqq/aio/title/ae;", "i", tl.h.F, "g", "", "getId", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "state", "onMoveToState", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/aio/api/runtime/a;", "d", "Lcom/tencent/aio/api/runtime/a;", "mAIOContext", "e", "Ljava/lang/String;", "mTroopUin", "Landroid/util/SparseArray;", "Lcom/tencent/mobileqq/activity/aio/helper/p;", "f", "Landroid/util/SparseArray;", "mProcessorList", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/a;", "mAction", "<init>", "()V", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes10.dex */
public final class TroopAIOTitleIconHelper implements com.tencent.aio.main.businesshelper.h, com.tencent.mvi.base.route.g {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mAIOContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String mTroopUin;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SparseArray<p> mProcessorList = new SparseArray<>();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mvi.base.route.a mAction = new c();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000A\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J(\u0010\f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\b0\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J*\u0010\u0014\u001a\u00020\u00132\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\bH\u0016\u00a8\u0006\u0015"}, d2 = {"com/tencent/mobileqq/activity/aio/helper/TroopAIOTitleIconHelper$b", "Lcom/tencent/mobileqq/aio/title/ac;", "", "d", "", "c", "Landroid/content/Context;", "context", "Landroid/graphics/drawable/Drawable;", "defaultIconDrawable", "Lkotlin/Pair;", "", "b", "Landroid/content/res/Resources;", DKConfiguration.Directory.RESOURCES, "Landroid/widget/ImageView;", "view", "iconUrl", "iconDrawable", "", "f", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements com.tencent.mobileqq.aio.title.ac {
        b() {
        }

        @Override // com.tencent.mobileqq.aio.title.ac
        public void a() {
            ac.a.a(this);
        }

        @Override // com.tencent.mobileqq.aio.title.ac
        @NotNull
        public Pair<String, Drawable> b(@Nullable Context context, @NotNull Drawable defaultIconDrawable) {
            Intrinsics.checkNotNullParameter(defaultIconDrawable, "defaultIconDrawable");
            return new Pair<>("", defaultIconDrawable);
        }

        @Override // com.tencent.mobileqq.aio.title.ac
        public boolean c() {
            return false;
        }

        @Override // com.tencent.mobileqq.aio.title.ac
        public float d() {
            return 1.0f;
        }

        @Override // com.tencent.mobileqq.aio.title.ac
        public void e() {
            ac.a.b(this);
        }

        @Override // com.tencent.mobileqq.aio.title.ac
        public void f(@Nullable Resources resources, @NotNull ImageView view, @NotNull String iconUrl, @NotNull Drawable iconDrawable) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
            Intrinsics.checkNotNullParameter(iconDrawable, "iconDrawable");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/activity/aio/helper/TroopAIOTitleIconHelper$c", "Lcom/tencent/mvi/base/route/a;", "", "sticky", "Lcom/tencent/mvi/base/route/MsgIntent;", "msgIntent", "", "call", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class c implements com.tencent.mvi.base.route.a {
        c() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent msgIntent) {
            Intrinsics.checkNotNullParameter(msgIntent, "msgIntent");
            if (msgIntent instanceof AIOTitleEvent.MutualMarkRequestEvent) {
                TroopAIOTitleIconHelper troopAIOTitleIconHelper = TroopAIOTitleIconHelper.this;
                String str = troopAIOTitleIconHelper.mTroopUin;
                if (str == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTroopUin");
                    str = null;
                }
                troopAIOTitleIconHelper.j(str, false);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return false;
        }
    }

    private final com.tencent.mobileqq.aio.title.ae g() {
        return new com.tencent.mobileqq.aio.title.ae("", 0, "", new b());
    }

    private final Pair<com.tencent.mobileqq.aio.title.ae, com.tencent.mobileqq.aio.title.ae> h() {
        return new Pair<>(g(), g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Pair<com.tencent.mobileqq.aio.title.ae, com.tencent.mobileqq.aio.title.ae> i() {
        FragmentActivity fragmentActivity;
        boolean z16;
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        TroopInfo troopInfo;
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        String j3 = aVar.g().r().c().j();
        com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar2 = null;
        }
        Fragment c16 = aVar2.c();
        if (c16 != null) {
            fragmentActivity = c16.getActivity();
        } else {
            fragmentActivity = null;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (j3.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && fragmentActivity != null && peekAppRuntime != null) {
            AppRuntime peekAppRuntime2 = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime2 instanceof AppInterface) {
                appInterface = (AppInterface) peekAppRuntime2;
            } else {
                appInterface = null;
            }
            if (appInterface != null) {
                iRuntimeService = appInterface.getRuntimeService(ITroopInfoService.class, "");
            } else {
                iRuntimeService = null;
            }
            ITroopInfoService iTroopInfoService = (ITroopInfoService) iRuntimeService;
            if (iTroopInfoService != null) {
                troopInfo = iTroopInfoService.findTroopInfo(j3);
            } else {
                troopInfo = null;
            }
            if (troopInfo == null) {
                return new Pair<>(null, null);
            }
            synchronized (this) {
                SparseArray<p> sparseArray = this.mProcessorList;
                int size = sparseArray.size();
                for (int i3 = 0; i3 < size; i3++) {
                    sparseArray.keyAt(i3);
                    Pair<com.tencent.mobileqq.aio.title.ae, com.tencent.mobileqq.aio.title.ae> d16 = sparseArray.valueAt(i3).d(fragmentActivity, troopInfo);
                    if (d16.getFirst() != null) {
                        if (d16.getSecond() == null) {
                            d16 = new Pair<>(d16.getFirst(), g());
                        }
                        return d16;
                    }
                }
                Unit unit = Unit.INSTANCE;
                return h();
            }
        }
        return h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(String curTroopUin, boolean needAnim) {
        QRouteApi api = QRoute.api(ITroopListRepoApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(ITroopListRepoApi::class.java)");
        if (ITroopListRepoApi.a.b((ITroopListRepoApi) api, curTroopUin, "TroopAIOTitleIconHelper", false, 4, null)) {
            return;
        }
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        Lifecycle lifecycle = aVar.d().getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "mAIOContext.lifecycleOwner.lifecycle");
        CorountineFunKt.e(LifecycleKt.getCoroutineScope(lifecycle), "TroopAIOTitleIconHelper_handleTroopHonorRequest", Boolean.FALSE, null, null, new TroopAIOTitleIconHelper$handleTroopHonorRequest$1(this, needAnim, null), 12, null);
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.f350664q;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.event.AIOTitleEvent.MutualMarkRequestEvent");
        return hashSet;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        return new HashSet();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        return "TroopAIOTitleIconHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        return new int[0];
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        TroopAIOTitleLuckyCharProcessor troopAIOTitleLuckyCharProcessor = new TroopAIOTitleLuckyCharProcessor();
        synchronized (this) {
            this.mProcessorList.put(troopAIOTitleLuckyCharProcessor.g(), troopAIOTitleLuckyCharProcessor);
            Unit unit = Unit.INSTANCE;
        }
        com.tencent.aio.api.runtime.a a16 = param.a();
        this.mAIOContext = a16;
        com.tencent.aio.api.runtime.a aVar = null;
        if (a16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            a16 = null;
        }
        this.mTroopUin = a16.g().r().c().j();
        com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
        } else {
            aVar = aVar2;
        }
        aVar.e().f(this, this.mAction);
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        h.a.b(this);
        synchronized (this) {
            SparseArray<p> sparseArray = this.mProcessorList;
            int size = sparseArray.size();
            for (int i3 = 0; i3 < size; i3++) {
                sparseArray.keyAt(i3);
                sparseArray.valueAt(i3).e();
            }
            this.mProcessorList.clear();
            Unit unit = Unit.INSTANCE;
        }
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        aVar.e().i(this, this.mAction);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
    }
}
