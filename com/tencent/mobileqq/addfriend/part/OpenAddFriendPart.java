package com.tencent.mobileqq.addfriend.part;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u001c\u0010\f\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u000e\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0006J\u0016\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/addfriend/part/OpenAddFriendPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "initViewModel", "", "C9", "Landroid/content/Intent;", "A9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "intent", "setIntent", "", "errorCode", "", "errorMsg", "z9", "d", "Landroid/content/Intent;", "mIntent", "Lcom/tencent/mobileqq/addfriend/part/b;", "e", "Lcom/tencent/mobileqq/addfriend/part/b;", "viewModel", "<init>", "()V", "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class OpenAddFriendPart extends Part {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Intent mIntent;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private b viewModel;

    public OpenAddFriendPart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final Intent A9() {
        QBaseFragment qBaseFragment;
        Intent intent = this.mIntent;
        if (intent != null) {
            return intent;
        }
        IPartHost partHost = getPartHost();
        if (partHost instanceof QBaseFragment) {
            qBaseFragment = (QBaseFragment) partHost;
        } else {
            qBaseFragment = null;
        }
        if (qBaseFragment == null) {
            return new Intent();
        }
        Bundle arguments = qBaseFragment.getArguments();
        if (arguments != null) {
            Parcelable parcelable = arguments.getParcelable("add_friend_intent");
            if (parcelable instanceof Intent) {
                return (Intent) parcelable;
            }
        }
        Activity activity = getActivity();
        if (activity == null) {
            return new Intent();
        }
        Intent intent2 = activity.getIntent();
        if (intent2 == null) {
            return new Intent();
        }
        return intent2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final boolean C9() {
        Bundle extras = A9().getExtras();
        if (extras == null || !extras.containsKey("IS_FROM_OPEN_SDK")) {
            return false;
        }
        return extras.getBoolean("IS_FROM_OPEN_SDK");
    }

    private final void initViewModel() {
        ViewModel viewModel = getViewModel(b.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(OpenAddFriendViewModel::class.java)");
        b bVar = (b) viewModel;
        this.viewModel = bVar;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            bVar = null;
        }
        MutableLiveData<c> M1 = bVar.M1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<c, Unit> function1 = new Function1<c, Unit>() { // from class: com.tencent.mobileqq.addfriend.part.OpenAddFriendPart$initViewModel$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) OpenAddFriendPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(c cVar) {
                invoke2(cVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(c cVar) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    OpenAddFriendPart.this.z9(cVar.a(), cVar.b());
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) cVar);
                }
            }
        };
        M1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.addfriend.part.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                OpenAddFriendPart.B9(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) savedInstanceState);
        } else {
            super.onPartCreate(activity, savedInstanceState);
            initViewModel();
        }
    }

    public final void setIntent(@NotNull Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent);
        } else {
            Intrinsics.checkNotNullParameter(intent, "intent");
            this.mIntent = intent;
        }
    }

    public final void z9(int errorCode, @NotNull String errorMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, errorCode, (Object) errorMsg);
            return;
        }
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        if (!C9()) {
            return;
        }
        com.tencent.mobileqq.addfriend.commonchannel.b.f187312a.a(errorCode, errorMsg);
    }
}
