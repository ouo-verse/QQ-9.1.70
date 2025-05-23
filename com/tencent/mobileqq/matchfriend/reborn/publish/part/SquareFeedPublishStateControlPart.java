package com.tencent.mobileqq.matchfriend.reborn.publish.part;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\u000e\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016R\u0016\u0010\u0012\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R#\u0010\u0019\u001a\n \u0014*\u0004\u0018\u00010\u00130\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/publish/part/SquareFeedPublishStateControlPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "flag", "", "add", "", "B9", "C9", "D9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onBackEvent", "d", "I", "currentState", "Ls82/a;", "kotlin.jvm.PlatformType", "e", "Lkotlin/Lazy;", "E9", "()Ls82/a;", "viewModel", "<init>", "()V", "f", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class SquareFeedPublishStateControlPart extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int currentState;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy viewModel;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/matchfriend/reborn/publish/part/SquareFeedPublishStateControlPart$b", "Landroid/content/DialogInterface$OnClickListener;", "Landroid/content/DialogInterface;", "dialog", "", "which", "", NodeProps.ON_CLICK, "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialog, int which) {
            Activity activity = SquareFeedPublishStateControlPart.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    public SquareFeedPublishStateControlPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<s82.a>() { // from class: com.tencent.mobileqq.matchfriend.reborn.publish.part.SquareFeedPublishStateControlPart$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final s82.a invoke() {
                return (s82.a) SquareFeedPublishStateControlPart.this.getViewModel(s82.a.class);
            }
        });
        this.viewModel = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B9(int flag, boolean add) {
        int i3 = this.currentState;
        if (add) {
            C9(flag);
        } else {
            D9(flag);
        }
        if (i3 != this.currentState) {
            E9().L1().postValue(Boolean.valueOf((this.currentState & 3) != 0));
        }
    }

    private final void C9(int flag) {
        this.currentState = (flag & 3) | this.currentState;
    }

    private final void D9(int flag) {
        this.currentState = (~(flag & 3)) & this.currentState;
    }

    private final s82.a E9() {
        return (s82.a) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        if (Intrinsics.areEqual(E9().L1().getValue(), Boolean.TRUE)) {
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(getContext(), 0, "", "\u786e\u5b9a\u5220\u9664\u6240\u6709\u5185\u5bb9\u5417\uff1f", new b(), new c());
            if (!getActivity().isFinishing() && !getActivity().isDestroyed()) {
                createCustomDialog.show();
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        MutableLiveData<CharSequence> O1 = E9().O1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<CharSequence, Unit> function1 = new Function1<CharSequence, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.publish.part.SquareFeedPublishStateControlPart$onPartCreate$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CharSequence charSequence) {
                invoke2(charSequence);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(CharSequence charSequence) {
                SquareFeedPublishStateControlPart.this.B9(2, !(charSequence == null || charSequence.length() == 0));
            }
        };
        O1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.matchfriend.reborn.publish.part.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SquareFeedPublishStateControlPart.F9(Function1.this, obj);
            }
        });
        MutableLiveData<Bitmap> M1 = E9().M1();
        LifecycleOwner lifecycleOwner2 = getPartHost().getLifecycleOwner();
        final Function1<Bitmap, Unit> function12 = new Function1<Bitmap, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.publish.part.SquareFeedPublishStateControlPart$onPartCreate$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap) {
                invoke2(bitmap);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Bitmap bitmap) {
                SquareFeedPublishStateControlPart.this.B9(1, bitmap != null);
            }
        };
        M1.observe(lifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.matchfriend.reborn.publish.part.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SquareFeedPublishStateControlPart.G9(Function1.this, obj);
            }
        });
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/matchfriend/reborn/publish/part/SquareFeedPublishStateControlPart$c", "Landroid/content/DialogInterface$OnClickListener;", "Landroid/content/DialogInterface;", "dialog", "", "which", "", NodeProps.ON_CLICK, "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class c implements DialogInterface.OnClickListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialog, int which) {
        }
    }
}
