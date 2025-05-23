package com.tencent.qqnt.aio.helper;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.ark.api.IArkQQApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mvi.annotation.AutoEventName;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.helper.ArkHelper;
import com.tencent.qqnt.aio.helper.ArkHelper$containerEvents$2;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b*\u0002\u0014\u0018\b\u0007\u0018\u0000 \u00042\u00020\u00012\u00020\u0002:\u0003()\u0006B\u0007\u00a2\u0006\u0004\b&\u0010'J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\b\u0010\u0013\u001a\u00020\u000fH\u0016R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001d\u001a\u00020\u00188BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006*"}, d2 = {"Lcom/tencent/qqnt/aio/helper/ArkHelper;", "Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/mvi/base/route/g;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "Lcom/tencent/mvi/base/route/k;", "b", "", "getId", "", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "", "onCreate", "state", "onMoveToState", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "com/tencent/qqnt/aio/helper/ArkHelper$c", "d", "Lcom/tencent/qqnt/aio/helper/ArkHelper$c;", "mActionR", "com/tencent/qqnt/aio/helper/ArkHelper$containerEvents$2$1", "e", "Lkotlin/Lazy;", "getContainerEvents", "()Lcom/tencent/qqnt/aio/helper/ArkHelper$containerEvents$2$1;", "containerEvents", "Lcom/tencent/aio/api/runtime/a;", "f", "Lcom/tencent/aio/api/runtime/a;", "mAIOContext", "Landroid/content/Context;", tl.h.F, "Landroid/content/Context;", "mContext", "<init>", "()V", "ArkHelperEvent", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ArkHelper implements com.tencent.aio.main.businesshelper.h, com.tencent.mvi.base.route.g {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final c mActionR = new c();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy containerEvents;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mAIOContext;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private Context mContext;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0001\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/qqnt/aio/helper/ArkHelper$ArkHelperEvent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "()V", "ArkHelper", "Lcom/tencent/qqnt/aio/helper/ArkHelper$ArkHelperEvent$ArkHelper;", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public static abstract class ArkHelperEvent implements MsgIntent {

        /* compiled from: P */
        @AutoEventName
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/qqnt/aio/helper/ArkHelper$ArkHelperEvent$ArkHelper;", "Lcom/tencent/qqnt/aio/helper/ArkHelper$ArkHelperEvent;", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* renamed from: com.tencent.qqnt.aio.helper.ArkHelper$ArkHelperEvent$ArkHelper, reason: collision with other inner class name */
        /* loaded from: classes34.dex */
        public static final class C9478ArkHelper extends ArkHelperEvent {

            /* renamed from: d, reason: collision with root package name */
            public static final C9478ArkHelper f350258d = new C9478ArkHelper();

            @Override // com.tencent.mvi.base.route.i
            public String eventName() {
                return "com.tencent.qqnt.aio.helper.ArkHelper.ArkHelperEvent.ArkHelper";
            }

            C9478ArkHelper() {
                super(null);
            }
        }

        public /* synthetic */ ArkHelperEvent(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // com.tencent.mvi.base.route.MsgIntent
        public boolean isSticky() {
            return MsgIntent.a.a(this);
        }

        ArkHelperEvent() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/helper/ArkHelper$a;", "Lcom/tencent/mvi/base/route/k;", "<init>", "()V", "a", "b", "Lcom/tencent/qqnt/aio/helper/ArkHelper$a$a;", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static abstract class a implements com.tencent.mvi.base.route.k {

        /* compiled from: P */
        @AutoEventName
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/aio/helper/ArkHelper$a$a;", "Lcom/tencent/qqnt/aio/helper/ArkHelper$a;", "Lcom/tencent/qqnt/aio/helper/ArkHelper;", "a", "Lcom/tencent/qqnt/aio/helper/ArkHelper;", "getArkHelper", "()Lcom/tencent/qqnt/aio/helper/ArkHelper;", "arkHelper", "<init>", "(Lcom/tencent/qqnt/aio/helper/ArkHelper;)V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.qqnt.aio.helper.ArkHelper$a$a, reason: collision with other inner class name */
        /* loaded from: classes34.dex */
        public static final class C9479a extends a {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            private final ArkHelper arkHelper;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C9479a(ArkHelper arkHelper) {
                super(null);
                Intrinsics.checkNotNullParameter(arkHelper, "arkHelper");
                this.arkHelper = arkHelper;
            }
        }

        /* compiled from: P */
        @AutoEventName
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qqnt/aio/helper/ArkHelper$a$b;", "Lcom/tencent/mvi/base/route/k;", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes34.dex */
        public static final class b implements com.tencent.mvi.base.route.k {

            /* renamed from: a, reason: collision with root package name */
            public static final b f350260a = new b();

            b() {
            }
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/helper/ArkHelper$c", "Lcom/tencent/mvi/base/route/b;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "Lcom/tencent/mvi/base/route/k;", "call", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements com.tencent.mvi.base.route.b {
        c() {
        }

        @Override // com.tencent.mvi.base.route.b
        public com.tencent.mvi.base.route.k call(MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            return ArkHelper.this.b(i3);
        }
    }

    public ArkHelper() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ArkHelper$containerEvents$2.AnonymousClass1>() { // from class: com.tencent.qqnt.aio.helper.ArkHelper$containerEvents$2
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v0, types: [com.tencent.qqnt.aio.helper.ArkHelper$containerEvents$2$1] */
            @Override // kotlin.jvm.functions.Function0
            public final AnonymousClass1 invoke() {
                return new ArrayList<String>() { // from class: com.tencent.qqnt.aio.helper.ArkHelper$containerEvents$2.1
                    {
                        add(Reflection.getOrCreateKotlinClass(ArkHelper.ArkHelperEvent.C9478ArkHelper.class).getQualifiedName());
                    }

                    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
                    public final /* bridge */ boolean contains(Object obj) {
                        if (obj == null ? true : obj instanceof String) {
                            return contains((String) obj);
                        }
                        return false;
                    }

                    public /* bridge */ int getSize() {
                        return super.size();
                    }

                    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
                    public final /* bridge */ int indexOf(Object obj) {
                        if (obj == null ? true : obj instanceof String) {
                            return indexOf((String) obj);
                        }
                        return -1;
                    }

                    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
                    public final /* bridge */ int lastIndexOf(Object obj) {
                        if (obj == null ? true : obj instanceof String) {
                            return lastIndexOf((String) obj);
                        }
                        return -1;
                    }

                    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
                    public final /* bridge */ String remove(int i3) {
                        return removeAt(i3);
                    }

                    public /* bridge */ String removeAt(int i3) {
                        return (String) super.remove(i3);
                    }

                    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
                    public final /* bridge */ int size() {
                        return getSize();
                    }

                    public /* bridge */ boolean contains(String str) {
                        return super.contains((Object) str);
                    }

                    public /* bridge */ int indexOf(String str) {
                        return super.indexOf((Object) str);
                    }

                    public /* bridge */ int lastIndexOf(String str) {
                        return super.lastIndexOf((Object) str);
                    }

                    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
                    public final /* bridge */ boolean remove(Object obj) {
                        if (obj == null ? true : obj instanceof String) {
                            return remove((String) obj);
                        }
                        return false;
                    }

                    public /* bridge */ boolean remove(String str) {
                        return super.remove((Object) str);
                    }
                };
            }
        });
        this.containerEvents = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mvi.base.route.k b(MsgIntent i3) {
        if (i3 instanceof ArkHelperEvent.C9478ArkHelper) {
            return new a.C9479a(this);
        }
        return a.b.f350260a;
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.C0;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        return new HashSet();
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.qqnt.aio.helper.ArkHelper.ArkHelperEvent.ArkHelper");
        return hashSet;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public String getTag() {
        return "ArkHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(com.tencent.aio.main.businesshelper.b param) {
        com.tencent.mvi.base.route.j e16;
        Fragment c16;
        Intrinsics.checkNotNullParameter(param, "param");
        QLog.d("ArkHelper", 1, "onCreate");
        ((IArkQQApi) QRoute.api(IArkQQApi.class)).registerArkQQCallBack();
        com.tencent.aio.api.runtime.a a16 = param.a();
        this.mAIOContext = a16;
        Context requireContext = (a16 == null || (c16 = a16.c()) == null) ? null : c16.requireContext();
        Intrinsics.checkNotNull(requireContext);
        this.mContext = requireContext;
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null || (e16 = aVar.e()) == null) {
            return;
        }
        e16.l(this, this.mActionR);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public int[] interestedIn() {
        return new int[]{3};
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        com.tencent.mvi.base.route.j e16;
        QLog.d("ArkHelper", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar != null && (e16 = aVar.e()) != null) {
            e16.e(this);
        }
        com.tencent.mobileqq.ark.n.c().g(this.mAIOContext);
        ((IArkQQApi) QRoute.api(IArkQQApi.class)).unregisterArkQQCallBack();
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        if (state == 4) {
            com.tencent.mobileqq.ark.n.c().e(this.mAIOContext);
        }
    }
}
