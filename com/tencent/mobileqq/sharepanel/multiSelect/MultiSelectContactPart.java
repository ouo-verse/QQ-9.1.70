package com.tencent.mobileqq.sharepanel.multiSelect;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.sharepanel.launcher.SharePanelParam;
import com.tencent.mobileqq.sharepanel.model.SharePanelContactItem;
import com.tencent.mobileqq.sharepanel.part.i;
import com.tencent.mobileqq.sharepanel.preview.k;
import com.tencent.mobileqq.utils.u;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 B2\u00020\u00012\u00020\u0002:\u0001CB\u000f\u0012\u0006\u0010?\u001a\u00020>\u00a2\u0006\u0004\b@\u0010AJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u000bH\u0002J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0002J\u001c\u0010\u0017\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0012\u0010\u001d\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016R\u001b\u0010#\u001a\u00020\u001e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001b\u0010(\u001a\u00020$8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010 \u001a\u0004\b&\u0010'R\u001b\u0010-\u001a\u00020)8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b*\u0010 \u001a\u0004\b+\u0010,R\u001e\u00102\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0018\u00106\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0014\u0010:\u001a\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010=\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<\u00a8\u0006D"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/multiSelect/MultiSelectContactPart;", "Lcom/tencent/mobileqq/sharepanel/part/i;", "Lcom/tencent/mobileqq/sharepanel/ioc/a;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "Z9", "ba", "W9", "Lcom/tencent/mobileqq/sharepanel/model/SharePanelContactItem;", "contact", "", "afterPrepare", "da", "ca", "aa", "R9", "S9", "ea", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onInitView", "Z", "Landroid/content/Context;", "context", "O8", "onPartDestroy", "Lcom/tencent/mobileqq/sharepanel/multiSelect/vm/a;", "e", "Lkotlin/Lazy;", "T9", "()Lcom/tencent/mobileqq/sharepanel/multiSelect/vm/a;", "multiSelectVM", "Lcom/tencent/mobileqq/sharepanel/preview/i;", "f", "U9", "()Lcom/tencent/mobileqq/sharepanel/preview/i;", "previewVM", "Lcom/tencent/mobileqq/sharepanel/preview/k;", h.F, "V9", "()Lcom/tencent/mobileqq/sharepanel/preview/k;", "singlePreviewVM", "Lcom/tencent/qqnt/avatar/meta/refresh/c;", "Landroid/app/Dialog;", "i", "Lcom/tencent/qqnt/avatar/meta/refresh/c;", "weakSelectCountLimitDialog", "Landroidx/recyclerview/widget/RecyclerView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/tencent/mobileqq/sharepanel/multiSelect/adapter/a;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/sharepanel/multiSelect/adapter/a;", "contactAdapter", "D", "Lcom/tencent/mobileqq/sharepanel/model/SharePanelContactItem;", "waitingHandleContact", "Lcom/tencent/mobileqq/sharepanel/launcher/SharePanelParam;", "param", "<init>", "(Lcom/tencent/mobileqq/sharepanel/launcher/SharePanelParam;)V", "E", "a", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class MultiSelectContactPart extends i implements com.tencent.mobileqq.sharepanel.ioc.a {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.sharepanel.multiSelect.adapter.a contactAdapter;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private SharePanelContactItem waitingHandleContact;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy multiSelectVM;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy previewVM;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy singlePreviewVM;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.avatar.meta.refresh.c<Dialog> weakSelectCountLimitDialog;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView recyclerView;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/multiSelect/MultiSelectContactPart$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.sharepanel.multiSelect.MultiSelectContactPart$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
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

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/sharepanel/multiSelect/MultiSelectContactPart$b", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b extends RecyclerView.ItemDecoration {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, outRect, view, parent, state);
                return;
            }
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            outRect.right = cx.a(2.0f);
            outRect.left = cx.a(2.0f);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39279);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiSelectContactPart(@NotNull SharePanelParam param) {
        super(param);
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Intrinsics.checkNotNullParameter(param, "param");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.sharepanel.multiSelect.vm.a>() { // from class: com.tencent.mobileqq.sharepanel.multiSelect.MultiSelectContactPart$multiSelectVM$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MultiSelectContactPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final com.tencent.mobileqq.sharepanel.multiSelect.vm.a invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (com.tencent.mobileqq.sharepanel.multiSelect.vm.a) MultiSelectContactPart.this.getViewModel(com.tencent.mobileqq.sharepanel.multiSelect.vm.a.class) : (com.tencent.mobileqq.sharepanel.multiSelect.vm.a) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.multiSelectVM = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.sharepanel.preview.i>() { // from class: com.tencent.mobileqq.sharepanel.multiSelect.MultiSelectContactPart$previewVM$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MultiSelectContactPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final com.tencent.mobileqq.sharepanel.preview.i invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (com.tencent.mobileqq.sharepanel.preview.i) MultiSelectContactPart.this.getViewModel(com.tencent.mobileqq.sharepanel.preview.i.class) : (com.tencent.mobileqq.sharepanel.preview.i) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.previewVM = lazy2;
            lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<k>() { // from class: com.tencent.mobileqq.sharepanel.multiSelect.MultiSelectContactPart$singlePreviewVM$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MultiSelectContactPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final k invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (k) MultiSelectContactPart.this.getViewModel(k.class) : (k) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.singlePreviewVM = lazy3;
            this.contactAdapter = new com.tencent.mobileqq.sharepanel.multiSelect.adapter.a();
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) param);
    }

    private final void R9(SharePanelContactItem contact) {
        LifecycleOwner lifecycleOwner;
        LifecycleCoroutineScope lifecycleScope;
        IPartHost partHost = getPartHost();
        if (partHost != null && (lifecycleOwner = partHost.getLifecycleOwner()) != null && (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(lifecycleOwner)) != null) {
            BuildersKt__Builders_commonKt.launch$default(lifecycleScope, null, null, new MultiSelectContactPart$delayMultiSelectContact$1(this, contact, null), 3, null);
        }
    }

    private final void S9(SharePanelContactItem contact) {
        IPartHost partHost;
        LifecycleOwner lifecycleOwner;
        LifecycleCoroutineScope lifecycleScope;
        if (!u.a().c(300L) && (partHost = getPartHost()) != null && (lifecycleOwner = partHost.getLifecycleOwner()) != null && (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(lifecycleOwner)) != null) {
            BuildersKt__Builders_commonKt.launch$default(lifecycleScope, null, null, new MultiSelectContactPart$directForwardToGuild$1(contact, this, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.sharepanel.multiSelect.vm.a T9() {
        Object value = this.multiSelectVM.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-multiSelectVM>(...)");
        return (com.tencent.mobileqq.sharepanel.multiSelect.vm.a) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.mobileqq.sharepanel.preview.i U9() {
        Object value = this.previewVM.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-previewVM>(...)");
        return (com.tencent.mobileqq.sharepanel.preview.i) value;
    }

    private final k V9() {
        Object value = this.singlePreviewVM.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-singlePreviewVM>(...)");
        return (k) value;
    }

    private final void W9() {
        T9().R1(new MultiSelectContactPart$initObserver$1(this));
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        if (lifecycleOwner == null) {
            return;
        }
        MutableLiveData<List<SharePanelContactItem>> L1 = T9().L1();
        final Function1<List<SharePanelContactItem>, Unit> function1 = new Function1<List<SharePanelContactItem>, Unit>() { // from class: com.tencent.mobileqq.sharepanel.multiSelect.MultiSelectContactPart$initObserver$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) MultiSelectContactPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<SharePanelContactItem> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<SharePanelContactItem> it) {
                RecyclerView recyclerView;
                com.tencent.mobileqq.sharepanel.multiSelect.adapter.a aVar;
                com.tencent.mobileqq.sharepanel.multiSelect.adapter.a aVar2;
                RecyclerView recyclerView2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                List<SharePanelContactItem> list = it;
                if (list == null || list.isEmpty()) {
                    recyclerView2 = MultiSelectContactPart.this.recyclerView;
                    if (recyclerView2 == null) {
                        return;
                    }
                    recyclerView2.setVisibility(8);
                    return;
                }
                recyclerView = MultiSelectContactPart.this.recyclerView;
                if (recyclerView != null) {
                    recyclerView.setVisibility(0);
                }
                if (it.size() > 15) {
                    aVar2 = MultiSelectContactPart.this.contactAdapter;
                    aVar2.setData(it.subList(0, 16));
                } else {
                    aVar = MultiSelectContactPart.this.contactAdapter;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    aVar.setData(it);
                }
            }
        };
        L1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.sharepanel.multiSelect.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MultiSelectContactPart.X9(Function1.this, obj);
            }
        });
        MutableLiveData<Boolean> O1 = U9().O1();
        final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.sharepanel.multiSelect.MultiSelectContactPart$initObserver$3
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) MultiSelectContactPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:10:0x001b, code lost:
            
                r4 = r3.this$0.waitingHandleContact;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2(Boolean it) {
                SharePanelContactItem sharePanelContactItem;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (!it.booleanValue() || sharePanelContactItem == null) {
                    return;
                }
                MultiSelectContactPart multiSelectContactPart = MultiSelectContactPart.this;
                multiSelectContactPart.waitingHandleContact = null;
                multiSelectContactPart.da(sharePanelContactItem, true);
            }
        };
        O1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.sharepanel.multiSelect.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MultiSelectContactPart.Y9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void Z9(View rootView) {
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.f71853p_);
        if (recyclerView != null) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(rootView.getContext());
            linearLayoutManager.setOrientation(0);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(this.contactAdapter);
            recyclerView.addItemDecoration(new b());
        } else {
            recyclerView = null;
        }
        this.recyclerView = recyclerView;
    }

    private final boolean aa(SharePanelContactItem contact) {
        if (!F9().z() || contact.g()) {
            return false;
        }
        return true;
    }

    private final void ba() {
        List<SharePanelContactItem> mutableList;
        MutableLiveData<List<SharePanelContactItem>> L1 = T9().L1();
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) F9().s());
        L1.setValue(mutableList);
    }

    private final boolean ca() {
        Integer num;
        Intent f16 = F9().f();
        if (f16 != null) {
            num = Integer.valueOf(f16.getIntExtra("forward_type", Integer.MAX_VALUE));
        } else {
            num = null;
        }
        if (num != null && num.intValue() == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void da(SharePanelContactItem contact, boolean afterPrepare) {
        boolean z16;
        if (aa(contact)) {
            if (afterPrepare && ca()) {
                R9(contact);
                return;
            } else {
                T9().P1(contact);
                return;
            }
        }
        if (contact.g()) {
            List<SharePanelContactItem> value = T9().M1().getValue();
            if (value != null && !value.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                S9(contact);
                return;
            } else {
                QQToast.makeText(BaseApplication.context, ForwardRecentActivity.NOT_SUPPORT_MULTI_GUILD, 0).show();
                return;
            }
        }
        ea(contact);
    }

    private final void ea(SharePanelContactItem contact) {
        if (u.a().c(300L)) {
            return;
        }
        V9().M1().postValue(contact);
    }

    @Override // com.tencent.mobileqq.sharepanel.ioc.a
    public void O8(@NotNull Context context) {
        LifecycleOwner lifecycleOwner;
        LifecycleCoroutineScope lifecycleScope;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        if (u.a().c(300L)) {
            return;
        }
        ArrayList<ResultRecord> N1 = T9().N1();
        IPartHost partHost = getPartHost();
        if (partHost != null && (lifecycleOwner = partHost.getLifecycleOwner()) != null && (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(lifecycleOwner)) != null) {
            BuildersKt__Builders_commonKt.launch$default(lifecycleScope, null, null, new MultiSelectContactPart$onMoreFriendClick$1(this, N1, null), 3, null);
        }
    }

    @Override // com.tencent.mobileqq.sharepanel.ioc.a
    public void Z(@NotNull SharePanelContactItem contact) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) contact);
            return;
        }
        Intrinsics.checkNotNullParameter(contact, "contact");
        if (F9().f() == null) {
            this.waitingHandleContact = contact;
            ArrayList<ResultRecord> N1 = T9().N1();
            if (N1.isEmpty()) {
                N1.add(new ResultRecord(contact.e(), contact.b(), contact.f(), contact.a()));
            }
            U9().P1(F9(), N1);
            return;
        }
        da(contact, false);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) rootView);
            return;
        }
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        Z9(rootView);
        W9();
        ba();
        RFWIocAbilityProvider.g().registerIoc(rootView, this, com.tencent.mobileqq.sharepanel.ioc.a.class);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) savedInstanceState);
        } else {
            super.onPartCreate(activity, savedInstanceState);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        Dialog dialog;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity);
            return;
        }
        super.onPartDestroy(activity);
        com.tencent.qqnt.avatar.meta.refresh.c<Dialog> cVar = this.weakSelectCountLimitDialog;
        if (cVar != null && (dialog = cVar.get()) != null) {
            dialog.dismiss();
        }
    }
}
