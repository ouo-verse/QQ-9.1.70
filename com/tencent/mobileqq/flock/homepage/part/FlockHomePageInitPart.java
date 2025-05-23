package com.tencent.mobileqq.flock.homepage.part;

import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.google.protobuf.nano.MessageNano;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.flock.api.FlockConstants$FlockListScene;
import com.tencent.mobileqq.flock.feedlist.viewmodel.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.util.LoadingUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\b\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004H\u0002J\u001c\u0010\t\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004H\u0002J\u001c\u0010\n\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004H\u0002J\u0012\u0010\r\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016R\u001b\u0010\u0013\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0018\u001a\u00020\u00148FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/flock/homepage/part/FlockHomePageInitPart;", "Lcom/tencent/mobileqq/flock/base/b;", "", "initData", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Lcom/tencent/mobileqq/flock/feeddetail/bean/a;", "it", "D9", "E9", "C9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/tencent/mobileqq/flock/feedlist/viewmodel/e;", "d", "Lkotlin/Lazy;", "B9", "()Lcom/tencent/mobileqq/flock/feedlist/viewmodel/e;", "feedListVm", "Landroid/app/Dialog;", "e", "A9", "()Landroid/app/Dialog;", "dialog", "<init>", "()V", "f", "a", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class FlockHomePageInitPart extends com.tencent.mobileqq.flock.base.b {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy feedListVm;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy dialog;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/flock/homepage/part/FlockHomePageInitPart$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.flock.homepage.part.FlockHomePageInitPart$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46478);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public FlockHomePageInitPart() {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<e>() { // from class: com.tencent.mobileqq.flock.homepage.part.FlockHomePageInitPart$feedListVm$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlockHomePageInitPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final e invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (e) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    ViewModel viewModel = FlockHomePageInitPart.this.getViewModel(com.tencent.mobileqq.flock.feedlist.viewmodel.a.INSTANCE.a(FlockConstants$FlockListScene.PUBLISH));
                    Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.tencent.mobileqq.flock.feedlist.viewmodel.FlockGetHomePageFeedListViewModel");
                    return (e) viewModel;
                }
            });
            this.feedListVm = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Dialog>() { // from class: com.tencent.mobileqq.flock.homepage.part.FlockHomePageInitPart$dialog$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlockHomePageInitPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Dialog invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? LoadingUtil.showOnlyLoadingImageDialog(FlockHomePageInitPart.this.getContext(), 2, true) : (Dialog) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.dialog = lazy2;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private final e B9() {
        return (e) this.feedListVm.getValue();
    }

    private final void C9(UIStateData<List<com.tencent.mobileqq.flock.feeddetail.bean.a>> it) {
        QLog.e("FlockHomePageInitPart", 1, "handleErrorState");
        broadcastMessage("ACTION_MSG_INIT", Integer.valueOf(B9().c2()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D9(UIStateData<List<com.tencent.mobileqq.flock.feeddetail.bean.a>> it) {
        int state = it.getState();
        if (state != 0) {
            if (state != 2) {
                if (state != 3) {
                    if (state == 4) {
                        C9(it);
                    }
                } else {
                    E9(it);
                }
            } else {
                E9(it);
            }
        } else {
            C9(it);
        }
        A9().dismiss();
    }

    private final void E9(UIStateData<List<com.tencent.mobileqq.flock.feeddetail.bean.a>> it) {
        QLog.i("FlockHomePageInitPart", 1, "handleSuccessState");
        Intent intent = getActivity().getIntent();
        ArrayList arrayList = new ArrayList();
        List<com.tencent.mobileqq.flock.feeddetail.bean.a> data = it.getData();
        Intrinsics.checkNotNullExpressionValue(data, "it.data");
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it5 = data.iterator();
        while (it5.hasNext()) {
            byte[] byteArray = MessageNano.toByteArray(((com.tencent.mobileqq.flock.feeddetail.bean.a) it5.next()).a());
            if (byteArray != null) {
                arrayList2.add(byteArray);
            }
        }
        arrayList.addAll(arrayList2);
        Unit unit = Unit.INSTANCE;
        intent.putExtra("key_flock_feeds", arrayList);
        getActivity().getIntent().putExtra("key_flock_homepage_recom", B9().c2());
        getActivity().getIntent().putExtra("key_flock_homepage_session", B9().O1());
        getActivity().getIntent().putExtra("key_flock_homepage_fetch_finish", B9().f2());
        broadcastMessage("ACTION_MSG_INIT", Integer.valueOf(B9().c2()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void initData() {
        LiveData<UIStateData<List<com.tencent.mobileqq.flock.feeddetail.bean.a>>> R1 = B9().R1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<UIStateData<List<? extends com.tencent.mobileqq.flock.feeddetail.bean.a>>, Unit> function1 = new Function1<UIStateData<List<? extends com.tencent.mobileqq.flock.feeddetail.bean.a>>, Unit>() { // from class: com.tencent.mobileqq.flock.homepage.part.FlockHomePageInitPart$initData$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) FlockHomePageInitPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UIStateData<List<? extends com.tencent.mobileqq.flock.feeddetail.bean.a>> uIStateData) {
                invoke2((UIStateData<List<com.tencent.mobileqq.flock.feeddetail.bean.a>>) uIStateData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UIStateData<List<com.tencent.mobileqq.flock.feeddetail.bean.a>> it) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                FlockHomePageInitPart flockHomePageInitPart = FlockHomePageInitPart.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                flockHomePageInitPart.D9(it);
            }
        };
        R1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.flock.homepage.part.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FlockHomePageInitPart.F9(Function1.this, obj);
            }
        });
        B9().i2(0);
        e B9 = B9();
        if (B9 != null) {
            B9.W1(false);
        }
    }

    @NotNull
    public final Dialog A9() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Dialog) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        Object value = this.dialog.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-dialog>(...)");
        return (Dialog) value;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        A9().show();
        initData();
    }
}
