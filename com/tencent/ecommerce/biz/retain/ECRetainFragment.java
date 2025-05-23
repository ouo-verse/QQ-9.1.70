package com.tencent.ecommerce.biz.retain;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import bi0.ECHREvent;
import com.tencent.ecommerce.base.eventbus.EventObserver;
import com.tencent.ecommerce.base.eventbus.LifecycleEventBus;
import com.tencent.ecommerce.base.eventbus.ThreadMode;
import com.tencent.ecommerce.base.router.api.IECSchemeCallback;
import com.tencent.ecommerce.biz.hr.ECHRFragment;
import com.tencent.ecommerce.biz.util.ECThreadUtilKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/ecommerce/biz/retain/ECRetainFragment;", "Lcom/tencent/ecommerce/biz/hr/ECHRFragment;", "", "Ai", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECRetainFragment extends ECHRFragment {
    private final void Ai() {
        LifecycleEventBus.f100688b.c(ThreadMode.MAIN, this, ECHREvent.class, new EventObserver<ECHREvent>() { // from class: com.tencent.ecommerce.biz.retain.ECRetainFragment$registerKTVEventObserver$1
            @Override // com.tencent.ecommerce.base.eventbus.EventObserver
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final void onEvent(final ECHREvent eCHREvent) {
                String str;
                Intent intent;
                if (Intrinsics.areEqual(eCHREvent.getEventName(), "cancelBtnPressed") || Intrinsics.areEqual(eCHREvent.getEventName(), "confirmBtnPressed")) {
                    cg0.a.b("Retain", "ktv popup click key:" + eCHREvent.getEventName() + " option:" + eCHREvent.getData());
                    FragmentActivity activity = ECRetainFragment.this.getActivity();
                    if (activity == null || (intent = activity.getIntent()) == null || (str = intent.getStringExtra("scheme_callback_id")) == null) {
                        str = "";
                    }
                    final IECSchemeCallback b16 = ug0.a.b(str);
                    if (b16 != null) {
                        ECThreadUtilKt.b(100L, new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.retain.ECRetainFragment$registerKTVEventObserver$1$$special$$inlined$let$lambda$1
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
                                eCHREvent.getData().put("retain_callback_option_key", eCHREvent.getEventName());
                                IECSchemeCallback.this.onCallbackFinished(eCHREvent.getData());
                            }
                        });
                    }
                }
            }
        });
    }

    @Override // com.tencent.ecommerce.biz.hr.ECHRFragment, com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Ai();
    }
}
