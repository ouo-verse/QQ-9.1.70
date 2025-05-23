package com.tencent.qqnt.aio.helper;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.aio.event.AIOTitleEvent;
import com.tencent.mobileqq.aio.title.ac;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.business.MutualMarkConfProcessor;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.bus.api.IBusManager;
import com.tencent.qqnt.ntrelation.api.IFriendsTABService;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 $2\u00020\u00012\u00020\u0002:\u0001%B\u0007\u00a2\u0006\u0004\b\"\u0010#J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0014\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u000bH\u0016J\b\u0010\u0016\u001a\u00020\u0005H\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006&"}, d2 = {"Lcom/tencent/qqnt/aio/helper/cd;", "Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/mvi/base/route/g;", "", "needAnim", "", "e", "Lcom/tencent/mobileqq/mutualmark/info/c;", "oldInfo", "Lcom/tencent/mobileqq/aio/title/ae;", "c", "", "getId", "", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "state", "onMoveToState", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/aio/api/runtime/a;", "d", "Lcom/tencent/aio/api/runtime/a;", "mAIOContext", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/a;", "mAction1", "Lzv3/c;", "f", "Lzv3/c;", "mutualMarkEventObserver", "<init>", "()V", tl.h.F, "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes34.dex */
public final class cd implements com.tencent.aio.main.businesshelper.h, com.tencent.mvi.base.route.g {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mAIOContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.mvi.base.route.a mAction1 = new c();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final zv3.c mutualMarkEventObserver = new d();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000C\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J*\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J(\u0010\u0014\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\f0\u00132\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\fH\u0016J\b\u0010\u0015\u001a\u00020\u000eH\u0016\u00a8\u0006\u0016"}, d2 = {"com/tencent/qqnt/aio/helper/cd$b", "Lcom/tencent/mobileqq/aio/title/ac;", "", "d", "", "c", "Landroid/content/res/Resources;", DKConfiguration.Directory.RESOURCES, "Landroid/widget/ImageView;", "view", "", "iconUrl", "Landroid/graphics/drawable/Drawable;", "iconDrawable", "", "f", "Landroid/content/Context;", "context", "defaultIconDrawable", "Lkotlin/Pair;", "b", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements com.tencent.mobileqq.aio.title.ac {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.mutualmark.info.c f350579a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ cd f350580b;

        b(com.tencent.mobileqq.mutualmark.info.c cVar, cd cdVar) {
            this.f350579a = cVar;
            this.f350580b = cdVar;
        }

        @Override // com.tencent.mobileqq.aio.title.ac
        public void a() {
            Fragment c16;
            FragmentActivity activity;
            AIOParam g16;
            if (((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).isFastClick("MutualMarkHelper")) {
                return;
            }
            com.tencent.aio.api.runtime.a aVar = this.f350580b.mAIOContext;
            String valueOf = String.valueOf((aVar == null || (g16 = aVar.g()) == null) ? null : Long.valueOf(su3.c.a(g16)));
            com.tencent.aio.api.runtime.a aVar2 = this.f350580b.mAIOContext;
            if (aVar2 == null || (c16 = aVar2.c()) == null || (activity = c16.getActivity()) == null) {
                return;
            }
            Intent intent = new Intent(activity, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", MutualMarkConfProcessor.a().b(valueOf));
            activity.startActivity(intent);
        }

        @Override // com.tencent.mobileqq.aio.title.ac
        public Pair<String, Drawable> b(Context context, Drawable defaultIconDrawable) {
            Intrinsics.checkNotNullParameter(defaultIconDrawable, "defaultIconDrawable");
            if (!TextUtils.isEmpty(this.f350579a.f252103s)) {
                if (TextUtils.isEmpty(this.f350579a.f252102r)) {
                    com.tencent.mobileqq.mutualmark.info.c cVar = this.f350579a;
                    cVar.f252102r = cVar.f252103s;
                }
            } else {
                defaultIconDrawable = new com.tencent.mobileqq.mutualmark.e(context, this.f350579a.f252101q);
            }
            return new Pair<>(this.f350579a.f252102r, defaultIconDrawable);
        }

        @Override // com.tencent.mobileqq.aio.title.ac
        public boolean c() {
            return this.f350579a.c();
        }

        @Override // com.tencent.mobileqq.aio.title.ac
        public float d() {
            return this.f350579a.a();
        }

        @Override // com.tencent.mobileqq.aio.title.ac
        public void e() {
            ac.a.b(this);
        }

        @Override // com.tencent.mobileqq.aio.title.ac
        public void f(Resources resources, ImageView view, String iconUrl, Drawable iconDrawable) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(iconUrl, "iconUrl");
            Intrinsics.checkNotNullParameter(iconDrawable, "iconDrawable");
            com.tencent.mobileqq.mutualmark.alienation.f.m(resources, view, iconUrl, iconDrawable);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/qqnt/aio/helper/cd$c", "Lcom/tencent/mvi/base/route/a;", "", "sticky", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements com.tencent.mvi.base.route.a {
        c() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            if (i3 instanceof AIOTitleEvent.MutualMarkRequestEvent) {
                cd.this.e(false);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/helper/cd$d", "Lzv3/c;", "Lzv3/a;", "event", "", "B5", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements zv3.c {
        d() {
        }

        @Override // zv3.c
        public void B5(zv3.a event) {
            boolean contains;
            AIOParam g16;
            AIOSession r16;
            AIOContact c16;
            AIOParam g17;
            Intrinsics.checkNotNullParameter(event, "event");
            String str = null;
            if (event instanceof com.tencent.qqnt.bus.event.o) {
                String a16 = ((com.tencent.qqnt.bus.event.o) event).a();
                com.tencent.aio.api.runtime.a aVar = cd.this.mAIOContext;
                if (Intrinsics.areEqual(a16, String.valueOf((aVar == null || (g17 = aVar.g()) == null) ? null : Long.valueOf(su3.c.a(g17))))) {
                    cd.this.e(true);
                }
            }
            if (event instanceof com.tencent.qqnt.bus.event.u) {
                ArrayList<String> a17 = ((com.tencent.qqnt.bus.event.u) event).a();
                com.tencent.aio.api.runtime.a aVar2 = cd.this.mAIOContext;
                if (aVar2 != null && (g16 = aVar2.g()) != null && (r16 = g16.r()) != null && (c16 = r16.c()) != null) {
                    str = c16.j();
                }
                contains = CollectionsKt___CollectionsKt.contains(a17, str);
                if (contains) {
                    cd.this.e(true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(boolean needAnim) {
        com.tencent.mvi.base.route.j e16;
        AIOParam g16;
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        String valueOf = String.valueOf((aVar == null || (g16 = aVar.g()) == null) ? null : Long.valueOf(su3.c.a(g16)));
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        com.tencent.util.Pair<com.tencent.mobileqq.mutualmark.info.c, com.tencent.mobileqq.mutualmark.info.c> c16 = com.tencent.mobileqq.mutualmark.c.c((QQAppInterface) peekAppRuntime, valueOf);
        if (((IFriendsTABService) QRoute.api(IFriendsTABService.class)).isNTLogOpen()) {
            QLog.e("MutualMarkHelper", 1, "updateMutualMark  uin: " + valueOf + " \nfirst \n" + c16.first + " \nsecond\n" + c16.second);
        }
        com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
        if (aVar2 == null || (e16 = aVar2.e()) == null) {
            return;
        }
        e16.h(new AIOTitleEvent.MutualMarkResponseEvent(c(c16.first), c(c16.second), needAnim));
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.f350661p;
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
    public String getTag() {
        return "MutualMarkHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(com.tencent.aio.main.businesshelper.b param) {
        com.tencent.mvi.base.route.j e16;
        Intrinsics.checkNotNullParameter(param, "param");
        com.tencent.aio.api.runtime.a a16 = param.a();
        this.mAIOContext = a16;
        if (a16 != null && (e16 = a16.e()) != null) {
            e16.f(this, this.mAction1);
        }
        ((IBusManager) QRoute.api(IBusManager.class)).registerEvent(com.tencent.qqnt.bus.event.o.class, this.mutualMarkEventObserver);
        ((IBusManager) QRoute.api(IBusManager.class)).registerEvent(com.tencent.qqnt.bus.event.u.class, this.mutualMarkEventObserver);
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        com.tencent.mvi.base.route.j e16;
        h.a.b(this);
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar != null && (e16 = aVar.e()) != null) {
            e16.i(this, this.mAction1);
        }
        ((IBusManager) QRoute.api(IBusManager.class)).unRegisterEvent(com.tencent.qqnt.bus.event.o.class, this.mutualMarkEventObserver);
        ((IBusManager) QRoute.api(IBusManager.class)).unRegisterEvent(com.tencent.qqnt.bus.event.u.class, this.mutualMarkEventObserver);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public int[] interestedIn() {
        return new int[]{12, 0};
    }

    private final com.tencent.mobileqq.aio.title.ae c(com.tencent.mobileqq.mutualmark.info.c oldInfo) {
        if (oldInfo == null) {
            return null;
        }
        b bVar = new b(oldInfo, this);
        String iconUrl = oldInfo.f252106v;
        Intrinsics.checkNotNullExpressionValue(iconUrl, "iconUrl");
        return new com.tencent.mobileqq.aio.title.ae(iconUrl, oldInfo.f252107w, oldInfo.f252099o, bVar);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        if (state == 12) {
            onDestroy();
        }
    }
}
