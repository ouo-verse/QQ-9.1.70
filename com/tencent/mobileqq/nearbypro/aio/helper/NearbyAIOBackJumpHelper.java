package com.tencent.mobileqq.nearbypro.aio.helper;

import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.nearbypro.aio.api.INearbyProAIOHelperApi;
import com.tencent.mobileqq.nearbypro.api.router.INearbyProPageRouter;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u0000  2\u00020\u00012\u00020\u0002:\u0001!B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0005H\u0016J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0003H\u0016R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R+\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00058B@BX\u0082\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u0018\u0010\u001c\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/nearbypro/aio/helper/NearbyAIOBackJumpHelper;", "Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/aio/api/runtime/emitter/a;", "", "c", "", "getId", "", "getTag", "", "interestedIn", "state", "onMoveToState", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "", "onBackEvent", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/aio/api/runtime/a;", "d", "Lcom/tencent/aio/api/runtime/a;", "mAIOContext", "<set-?>", "e", "Lkotlin/properties/ReadWriteProperty;", "b", "()I", "(I)V", "mOpenSource", "<init>", "()V", "f", "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes15.dex */
public final class NearbyAIOBackJumpHelper implements h, com.tencent.aio.api.runtime.emitter.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mAIOContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ReadWriteProperty mOpenSource = Delegates.INSTANCE.notNull();

    /* renamed from: h, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f253101h = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(NearbyAIOBackJumpHelper.class, "mOpenSource", "getMOpenSource()I", 0))};

    private final int b() {
        return ((Number) this.mOpenSource.getValue(this, f253101h[0])).intValue();
    }

    private final void c() {
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        Context context = aVar.c().getContext();
        if (context == null) {
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("open_chats_list_source", 1);
        intent.putExtra("exit_chats_list_action_open_main", true);
        ((INearbyProPageRouter) QRoute.api(INearbyProPageRouter.class)).launchNearbyChatsListFragment(context, intent);
        com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar2 = null;
        }
        aVar2.b().a(com.tencent.aio.api.runtime.emitter.a.class).c(this);
        com.tencent.aio.api.runtime.a aVar3 = this.mAIOContext;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar3 = null;
        }
        LifecycleOwner d16 = aVar3.d();
        Intrinsics.checkNotNullExpressionValue(d16, "mAIOContext.lifecycleOwner");
        CorountineFunKt.e(LifecycleOwnerKt.getLifecycleScope(d16), "NearbyAIOBackJumpHelper", Boolean.TRUE, null, null, new NearbyAIOBackJumpHelper$handleJumpToChatsListFragment$1(this, null), 12, null);
    }

    private final void e(int i3) {
        this.mOpenSource.setValue(this, f253101h[0], Integer.valueOf(i3));
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return ((INearbyProAIOHelperApi) QRoute.api(INearbyProAIOHelperApi.class)).getNearbyProExitAIOJumpHelperId();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        return "NearbyAIOBackJumpHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        return new int[0];
    }

    @Override // com.tencent.aio.api.runtime.emitter.a
    public boolean onBackEvent() {
        AIOSession r16;
        AIOContact c16;
        String j3;
        if (b() == 1) {
            c();
        }
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        Long l3 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        AIOParam g16 = aVar.g();
        if (g16 != null && (r16 = g16.r()) != null && (c16 = r16.c()) != null && (j3 = c16.j()) != null) {
            l3 = Long.valueOf(Long.parseLong(j3));
        }
        if (l3 != null) {
            aa2.a.f25755a.d(l3.longValue());
            return false;
        }
        return false;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        FragmentActivity activity;
        Intent intent;
        Intrinsics.checkNotNullParameter(param, "param");
        com.tencent.aio.api.runtime.a a16 = param.a();
        this.mAIOContext = a16;
        com.tencent.aio.api.runtime.a aVar = null;
        if (a16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            a16 = null;
        }
        a16.b().a(com.tencent.aio.api.runtime.emitter.a.class).a(this);
        com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
        } else {
            aVar = aVar2;
        }
        Fragment c16 = aVar.c();
        int i3 = 0;
        if (c16 != null && (activity = c16.getActivity()) != null && (intent = activity.getIntent()) != null) {
            i3 = intent.getIntExtra("key_nearby_pro_chat_open_source", 0);
        }
        e(i3);
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        h.a.b(this);
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        aVar.b().a(com.tencent.aio.api.runtime.emitter.a.class).c(this);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
    }
}
