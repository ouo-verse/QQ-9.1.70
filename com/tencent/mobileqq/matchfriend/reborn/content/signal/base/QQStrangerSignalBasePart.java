package com.tencent.mobileqq.matchfriend.reborn.content.signal.base;

import android.app.Activity;
import android.os.Bundle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.matchfriend.reborn.content.signal.base.QQStrangerSignalBaseViewModel;
import com.tencent.mobileqq.matchfriend.reborn.content.signal.base.c;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\b&\u0018\u0000*\u0014\b\u0000\u0010\u0002*\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u0003*\b\b\u0002\u0010\u0006*\u00020\u00052\u00020\u0007B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000e\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0017\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00028\u0001H\u0016\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00028\u00008&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/base/QQStrangerSignalBasePart;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/base/QQStrangerSignalBaseViewModel;", "Model", "Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/base/c;", "State", "", "Intent", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onPartCreate", "onPartDestroy", "state", "B9", "(Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/base/c;)V", "A9", "()Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/base/QQStrangerSignalBaseViewModel;", "viewModel", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public abstract class QQStrangerSignalBasePart<Model extends QQStrangerSignalBaseViewModel<State, Intent>, State extends c, Intent> extends Part {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void C9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public abstract Model A9();

    public void B9(State state) {
        Intrinsics.checkNotNullParameter(state, "state");
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartCreate(activity, savedInstanceState);
        LiveData<State> N1 = A9().N1();
        LifecycleOwner hostLifecycleOwner = getPartHost().getHostLifecycleOwner();
        final QQStrangerSignalBasePart$onPartCreate$1 qQStrangerSignalBasePart$onPartCreate$1 = new QQStrangerSignalBasePart$onPartCreate$1(this);
        N1.observe(hostLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.signal.base.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQStrangerSignalBasePart.C9(Function1.this, obj);
            }
        });
        A9().onCreate();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        A9().onDestroy();
        LiveData<State> N1 = A9().N1();
        final QQStrangerSignalBasePart$onPartDestroy$1 qQStrangerSignalBasePart$onPartDestroy$1 = new QQStrangerSignalBasePart$onPartDestroy$1(this);
        N1.removeObserver(new Observer() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.signal.base.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QQStrangerSignalBasePart.D9(Function1.this, obj);
            }
        });
    }
}
