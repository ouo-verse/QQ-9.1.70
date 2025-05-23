package com.tencent.mobileqq.activity.aio.helper;

import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.aio.input.draft.InputDraftMsgIntent;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qqnt.aio.helper.cw;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000M\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\b*\u0001\u001d\b\u0007\u0018\u0000 \t2\u00020\u00012\u00020\u0002:\u0001#B\u0007\u00a2\u0006\u0004\b!\u0010\"J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u000eH\u0016R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/helper/TroopEggAnimHelper;", "Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/mvi/base/route/g;", "Lcom/tencent/mvi/base/route/MsgIntent;", "msgIntent", "", "e", "g", "c", tl.h.F, "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "getId", "", "getTag", "", "interestedIn", "state", "onMoveToState", "", "d", "Z", "mDraftRecovered", "Lcom/tencent/aio/api/runtime/a;", "Lcom/tencent/aio/api/runtime/a;", "mAIOContext", "com/tencent/mobileqq/activity/aio/helper/TroopEggAnimHelper$b", "f", "Lcom/tencent/mobileqq/activity/aio/helper/TroopEggAnimHelper$b;", "mAction", "<init>", "()V", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes10.dex */
public final class TroopEggAnimHelper implements com.tencent.aio.main.businesshelper.h, com.tencent.mvi.base.route.g {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean mDraftRecovered;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mAIOContext;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mAction = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/activity/aio/helper/TroopEggAnimHelper$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            TroopEggAnimHelper.this.e(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    private final void c() {
        if (this.mDraftRecovered) {
            h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(MsgIntent msgIntent) {
        if (msgIntent instanceof InputDraftMsgIntent.RecoverDraftCompletedMsgIntent) {
            g();
        }
    }

    private final void g() {
        if (!this.mDraftRecovered) {
            com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
                aVar = null;
            }
            if (aVar.d().getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED)) {
                this.mDraftRecovered = true;
                h();
            }
        }
    }

    private final void h() {
        Intent intent;
        boolean z16;
        FragmentActivity activity;
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        Fragment c16 = aVar.c();
        if (c16 != null && (activity = c16.getActivity()) != null) {
            intent = activity.getIntent();
        } else {
            intent = null;
        }
        if (intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra("chat_inputBarContent");
        if (stringExtra != null && stringExtra.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        intent.removeExtra("chat_inputBarContent");
        com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar2 = null;
        }
        LifecycleOwner d16 = aVar2.d();
        Intrinsics.checkNotNullExpressionValue(d16, "mAIOContext.lifecycleOwner");
        CorountineFunKt.e(LifecycleOwnerKt.getLifecycleScope(d16), "TroopEggAnimHelper_doOnLifeCreate", Boolean.TRUE, null, null, new TroopEggAnimHelper$tryToSetInputContent$1(this, stringExtra, null), 12, null);
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.M0;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.input.draft.InputDraftMsgIntent.RecoverDraftCompletedMsgIntent");
        return hashSet;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        return new HashSet();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        return "TroopEggAnimHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        return new int[]{3};
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        h.a.a(this, param);
        this.mDraftRecovered = false;
        com.tencent.aio.api.runtime.a a16 = param.a();
        this.mAIOContext = a16;
        if (a16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            a16 = null;
        }
        a16.e().f(this, this.mAction);
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        h.a.b(this);
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAIOContext");
            aVar = null;
        }
        aVar.e().i(this, this.mAction);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        if (state == 3) {
            c();
        }
    }
}
