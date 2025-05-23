package com.tencent.mobileqq.sharepanel.preview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.api.IForwardMsgApi;
import com.tencent.mobileqq.sharepanel.api.IForwardPreviewPanelApi;
import com.tencent.mobileqq.sharepanel.launcher.SharePanelParam;
import com.tencent.mobileqq.sharepanel.model.SharePanelContactItem;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.constants.EventKey;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 &2\u00020\u0001:\u0001'B\u000f\u0012\u0006\u0010#\u001a\u00020\"\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J*\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000bH\u0002J \u0010\u0013\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0012\u0010\u0015\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u0016\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R#\u0010!\u001a\n \u001c*\u0004\u0018\u00010\u001b0\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/sharepanel/preview/SharePanelSinglePreviewPart;", "Lcom/tencent/mobileqq/sharepanel/part/i;", "", "Q9", "Lcom/tencent/mobileqq/sharepanel/model/SharePanelContactItem;", "contact", "U9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/content/Intent;", "forwardIntent", "Landroid/view/View;", "O9", "Landroidx/fragment/app/FragmentActivity;", EventKey.ACT, "previewView", "T9", "", "leaveMsg", "S9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "onPartDestroy", "Lcom/tencent/mobileqq/sharepanel/forward/g;", "e", "Lcom/tencent/mobileqq/sharepanel/forward/g;", "previewPanel", "Lcom/tencent/mobileqq/sharepanel/preview/k;", "kotlin.jvm.PlatformType", "f", "Lkotlin/Lazy;", "P9", "()Lcom/tencent/mobileqq/sharepanel/preview/k;", "singlePreviewVM", "Lcom/tencent/mobileqq/sharepanel/launcher/SharePanelParam;", "param", "<init>", "(Lcom/tencent/mobileqq/sharepanel/launcher/SharePanelParam;)V", tl.h.F, "a", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SharePanelSinglePreviewPart extends com.tencent.mobileqq.sharepanel.part.i {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.sharepanel.forward.g previewPanel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy singlePreviewVM;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/preview/SharePanelSinglePreviewPart$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.sharepanel.preview.SharePanelSinglePreviewPart$a, reason: from kotlin metadata */
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

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/sharepanel/preview/SharePanelSinglePreviewPart$b", "Lcom/tencent/mobileqq/sharepanel/forward/a;", "", "message", "", "a", "onCancel", "onDismiss", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b implements com.tencent.mobileqq.sharepanel.forward.a {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Intent f287558b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ SharePanelContactItem f287559c;

        b(Intent intent, SharePanelContactItem sharePanelContactItem) {
            this.f287558b = intent;
            this.f287559c = sharePanelContactItem;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, SharePanelSinglePreviewPart.this, intent, sharePanelContactItem);
            }
        }

        @Override // com.tencent.mobileqq.sharepanel.forward.a
        public void a(@NotNull CharSequence message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
            } else {
                Intrinsics.checkNotNullParameter(message, "message");
                SharePanelSinglePreviewPart.this.S9(this.f287558b, this.f287559c, message.toString());
            }
        }

        @Override // com.tencent.mobileqq.sharepanel.forward.a
        public void onCancel() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.sharepanel.forward.a
        public void onDismiss() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            } else {
                SharePanelSinglePreviewPart.this.E9();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/sharepanel/preview/SharePanelSinglePreviewPart$c", "Lcom/tencent/mobileqq/sharepanel/forward/e;", "", "", "", "a", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class c implements com.tencent.mobileqq.sharepanel.forward.e {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SharePanelSinglePreviewPart.this);
            }
        }

        @Override // com.tencent.mobileqq.sharepanel.forward.e
        @Nullable
        public Map<String, Object> a() {
            Map<String, Object> plus;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                plus = MapsKt__MapsKt.plus(com.tencent.mobileqq.sharepanel.report.a.a(SharePanelSinglePreviewPart.this.F9()), new Pair("come_from", 1));
                return plus;
            }
            return (Map) iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/sharepanel/preview/SharePanelSinglePreviewPart$d", "Lcom/tencent/mobileqq/sharepanel/forward/f;", "Landroid/content/Context;", "context", "Landroid/view/View;", "a", "", "b", "c", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class d implements com.tencent.mobileqq.sharepanel.forward.f {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f287561a;

        d(View view) {
            this.f287561a = view;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
            }
        }

        @Override // com.tencent.mobileqq.sharepanel.forward.f
        @Nullable
        public View a(@NotNull Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            }
            Intrinsics.checkNotNullParameter(context, "context");
            return this.f287561a;
        }

        @Override // com.tencent.mobileqq.sharepanel.forward.f
        public boolean b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return true;
        }

        @Override // com.tencent.mobileqq.sharepanel.forward.f
        public boolean c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
            }
            return false;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41727);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SharePanelSinglePreviewPart(@NotNull SharePanelParam param) {
        super(param);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(param, "param");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<k>() { // from class: com.tencent.mobileqq.sharepanel.preview.SharePanelSinglePreviewPart$singlePreviewVM$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SharePanelSinglePreviewPart.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final k invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (k) SharePanelSinglePreviewPart.this.getViewModel(k.class) : (k) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.singlePreviewVM = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) param);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View O9(Activity activity, Intent forwardIntent) {
        Intent intent = new Intent(forwardIntent);
        intent.putExtra(AppConstants.Key.SHARE_REQ_FROM_NEW_PANEL, true);
        return ((IForwardMsgApi) QRoute.api(IForwardMsgApi.class)).captionForwardPreview(activity, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final k P9() {
        return (k) this.singlePreviewVM.getValue();
    }

    private final void Q9() {
        LifecycleOwner lifecycleOwner;
        IPartHost partHost = getPartHost();
        if (partHost != null) {
            lifecycleOwner = partHost.getLifecycleOwner();
        } else {
            lifecycleOwner = null;
        }
        if (lifecycleOwner == null) {
            return;
        }
        MutableLiveData<SharePanelContactItem> M1 = P9().M1();
        final Function1<SharePanelContactItem, Unit> function1 = new Function1<SharePanelContactItem, Unit>() { // from class: com.tencent.mobileqq.sharepanel.preview.SharePanelSinglePreviewPart$observeLiveData$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) SharePanelSinglePreviewPart.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SharePanelContactItem sharePanelContactItem) {
                invoke2(sharePanelContactItem);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SharePanelContactItem contact) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) contact);
                    return;
                }
                SharePanelSinglePreviewPart sharePanelSinglePreviewPart = SharePanelSinglePreviewPart.this;
                Intrinsics.checkNotNullExpressionValue(contact, "contact");
                sharePanelSinglePreviewPart.U9(contact);
            }
        };
        M1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.sharepanel.preview.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SharePanelSinglePreviewPart.R9(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S9(Intent forwardIntent, SharePanelContactItem contact, String leaveMsg) {
        LifecycleOwner lifecycleOwner;
        LifecycleCoroutineScope lifecycleScope;
        IPartHost partHost = getPartHost();
        if (partHost != null && (lifecycleOwner = partHost.getLifecycleOwner()) != null && (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(lifecycleOwner)) != null) {
            BuildersKt__Builders_commonKt.launch$default(lifecycleScope, null, null, new SharePanelSinglePreviewPart$sendMessage$1(this, contact, leaveMsg, forwardIntent, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T9(FragmentActivity act, Intent forwardIntent, SharePanelContactItem contact, View previewView) {
        ArrayList<SharePanelContactItem> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(contact);
        com.tencent.mobileqq.sharepanel.forward.g createV2 = ((IForwardPreviewPanelApi) QRoute.api(IForwardPreviewPanelApi.class)).createV2(act, arrayListOf, new d(previewView));
        createV2.b(new b(forwardIntent, contact));
        createV2.a(new c());
        createV2.show();
        this.previewPanel = createV2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U9(SharePanelContactItem contact) {
        LifecycleOwner lifecycleOwner;
        LifecycleCoroutineScope lifecycleScope;
        IPartHost partHost = getPartHost();
        if (partHost != null && (lifecycleOwner = partHost.getLifecycleOwner()) != null && (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(lifecycleOwner)) != null) {
            BuildersKt__Builders_commonKt.launch$default(lifecycleScope, null, null, new SharePanelSinglePreviewPart$singlePreview$1(this, contact, null), 3, null);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
        } else {
            super.onInitView(rootView);
            Q9();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
            return;
        }
        super.onPartDestroy(activity);
        com.tencent.mobileqq.sharepanel.forward.g gVar = this.previewPanel;
        if (gVar != null) {
            gVar.dismiss();
        }
    }
}
