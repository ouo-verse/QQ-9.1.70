package com.tencent.mobileqq.aio.panel.photo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.aio.base.mvi.part.PanelUIState;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.panel.photo.PhotoPanelUIState;
import com.tencent.mobileqq.aio.panel.photo.g;
import com.tencent.mobileqq.aio.panel.photo.widget.ItemSwipeSendDecoration;
import com.tencent.mobileqq.aio.utils.AIOUtil;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqui.widget.InterceptParentTouchLayout;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.qqnt.photopanel.api.IPhotoPanelApi;
import com.tencent.qqnt.qbasealbum.customization.SendByFile;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import w71.ah;

@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 @2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001AB\u0007\u00a2\u0006\u0004\b>\u0010?J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0002H\u0002J\b\u0010\u000e\u001a\u00020\u0007H\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0014\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0007H\u0016J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0003H\u0016J\u0010\u0010\u0018\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0017H\u0016J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u000e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00190\u001cH\u0016J\u0018\u0010!\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u001eH\u0016J$\u0010$\u001a\u001e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001e0\"j\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001e`#H\u0016J\b\u0010%\u001a\u00020\u0007H\u0016J\b\u0010&\u001a\u00020\u0007H\u0016J\u000e\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00190'H\u0016J\b\u0010)\u001a\u00020\u0005H\u0016J\u0010\u0010*\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010+\u001a\u00020\u0007H\u0016J\b\u0010,\u001a\u00020\u0007H\u0016R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u001b\u00106\u001a\u0002018BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u0016\u00109\u001a\u0002078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u00108R\u0014\u0010=\u001a\u00020:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010<\u00a8\u0006B"}, d2 = {"Lcom/tencent/mobileqq/aio/panel/photo/PhotoPanelVB;", "Lcom/tencent/aio/base/mvvm/a;", "Lat/c;", "Lcom/tencent/aio/base/mvi/part/PanelUIState;", "Lcom/tencent/mobileqq/aio/panel/photo/a;", "", "isChecked", "", "y1", "Lcom/tencent/mobileqq/aio/panel/photo/PhotoPanelUIState$UpdateMediaInfo;", "state", "x1", "intent", "z1", "u1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "Lcom/tencent/aio/base/mvvm/b;", ICustomDataEditor.STRING_PARAM_1, "bindViewAndData", "w1", "Lcom/tencent/mobileqq/aio/panel/photo/g;", "v0", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "mediainfo", "e0", "", "E0", "", "originPath", "editPath", "X0", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "H", "u", "f0", "", "K", "m0", "w", "t", "f", "Lw71/ah;", "d", "Lw71/ah;", "binding", "Lcom/tencent/mobileqq/aio/panel/photo/PhotoPanelVM;", "e", "Lkotlin/Lazy;", "v1", "()Lcom/tencent/mobileqq/aio/panel/photo/PhotoPanelVM;", "viewModel", "Lcom/tencent/mobileqq/aio/panel/photo/PhotoPanelAdapter;", "Lcom/tencent/mobileqq/aio/panel/photo/PhotoPanelAdapter;", "photoPanelAdapter", "Lcom/tencent/qqnt/qbasealbum/customization/SendByFile;", tl.h.F, "Lcom/tencent/qqnt/qbasealbum/customization/SendByFile;", "sendByFile", "<init>", "()V", "i", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class PhotoPanelVB extends com.tencent.aio.base.mvvm.a<at.c, PanelUIState> implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ah binding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private PhotoPanelAdapter photoPanelAdapter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SendByFile sendByFile;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/panel/photo/PhotoPanelVB$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.panel.photo.PhotoPanelVB$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64513);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public PhotoPanelVB() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<PhotoPanelVM>() { // from class: com.tencent.mobileqq.aio.panel.photo.PhotoPanelVB$viewModel$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PhotoPanelVB.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final PhotoPanelVM invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new PhotoPanelVM(PhotoPanelVB.this) : (PhotoPanelVM) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.viewModel = lazy;
            this.sendByFile = new SendByFile(0L, 0L, 0L, 0, 0, false, 63, null);
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l1(final PhotoPanelVB this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ox3.a.c("PhotoPanelVB", PhotoPanelVB$bindViewAndData$2$1.INSTANCE);
        ah ahVar = this$0.binding;
        ah ahVar2 = null;
        if (ahVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            ahVar = null;
        }
        this$0.v0(new g.C7339g(ahVar.f444751h.isChecked()));
        com.tencent.qqnt.qbasealbum.report.c.f361503a.c("em_bas_send", 1, new Function0<Map<String, ? extends Object>>() { // from class: com.tencent.mobileqq.aio.panel.photo.PhotoPanelVB$bindViewAndData$2$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhotoPanelVB.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Map<String, ? extends Object> invoke() {
                ah ahVar3;
                PhotoPanelVM v16;
                Map<String, ? extends Object> mapOf;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (Map) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                Pair[] pairArr = new Pair[3];
                pairArr[0] = TuplesKt.to("number_sent", Integer.valueOf(PhotoPanelVB.this.E0().size()));
                ahVar3 = PhotoPanelVB.this.binding;
                if (ahVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    ahVar3 = null;
                }
                pairArr[1] = TuplesKt.to("is_original", Integer.valueOf(!ahVar3.f444751h.isChecked() ? 1 : 0));
                v16 = PhotoPanelVB.this.v1();
                pairArr[2] = TuplesKt.to("aio_type", String.valueOf(v16.C()));
                mapOf = MapsKt__MapsKt.mapOf(pairArr);
                return mapOf;
            }
        });
        ah ahVar3 = this$0.binding;
        if (ahVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            ahVar2 = ahVar3;
        }
        ahVar2.f444751h.setChecked(false);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m1(PhotoPanelVB this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!FastClickUtils.isFastDoubleClick("PhotoPanelVB")) {
            ox3.a.c("PhotoPanelVB", PhotoPanelVB$bindViewAndData$3$1.INSTANCE);
            this$0.v0(g.b.f193095d);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n1(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        com.tencent.qqnt.qbasealbum.report.c.f361503a.c(WinkDaTongReportConstant.ElementId.EM_BAS_ORIGINAL_DRAWING, 1, PhotoPanelVB$bindViewAndData$4$1.INSTANCE);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void o1(PhotoPanelVB this$0, CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16) {
            SendByFile sendByFile = this$0.sendByFile;
            Context context = compoundButton.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            sendByFile.g(context, this$0.E0(), ((com.tencent.aio.api.runtime.a) this$0.v1().getMContext()).g().r().c().e());
        }
        this$0.y1(z16);
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p1(PhotoPanelVB this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ah ahVar = this$0.binding;
        ah ahVar2 = null;
        if (ahVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            ahVar = null;
        }
        QUICheckBox qUICheckBox = ahVar.f444751h;
        ah ahVar3 = this$0.binding;
        if (ahVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            ahVar2 = ahVar3;
        }
        qUICheckBox.setChecked(!ahVar2.f444751h.isChecked());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q1(PhotoPanelVB this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int a16 = com.tencent.biz.qui.quicommon.e.a(25.0f);
        AIOUtil aIOUtil = AIOUtil.f194084a;
        ah ahVar = this$0.binding;
        if (ahVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            ahVar = null;
        }
        aIOUtil.e(ahVar.f444753j, a16, a16, a16, a16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void r1(PhotoPanelVB this$0, View view) {
        List<LocalMediaInfo> list;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!FastClickUtils.isFastDoubleClick("PhotoPanelVB")) {
            ox3.a.c("PhotoPanelVB", PhotoPanelVB$bindViewAndData$9$1.INSTANCE);
            IPhotoPanelApi iPhotoPanelApi = (IPhotoPanelApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IPhotoPanelApi.class);
            com.tencent.aio.api.runtime.a aVar = (com.tencent.aio.api.runtime.a) this$0.v1().getMContext();
            list = CollectionsKt___CollectionsKt.toList(this$0.E0());
            ah ahVar = this$0.binding;
            if (ahVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                ahVar = null;
            }
            iPhotoPanelApi.onEditBtnClicked(aVar, list, ahVar.f444751h.isChecked());
            com.tencent.qqnt.qbasealbum.report.c.f361503a.c(WinkDaTongReportConstant.ElementId.EM_BAS_EDIT, 1, PhotoPanelVB$bindViewAndData$9$2.INSTANCE);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void u1() {
        ah ahVar = this.binding;
        ah ahVar2 = null;
        if (ahVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            ahVar = null;
        }
        ViewCompat.setImportantForAccessibility(ahVar.f444753j, 2);
        ah ahVar3 = this.binding;
        if (ahVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            ahVar2 = ahVar3;
        }
        ahVar2.f444751h.setContentDescription(HardCodeUtil.qqStr(R.string.f174272ve));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PhotoPanelVM v1() {
        return (PhotoPanelVM) this.viewModel.getValue();
    }

    private final void x1(PhotoPanelUIState.UpdateMediaInfo state) {
        PhotoPanelAdapter photoPanelAdapter = this.photoPanelAdapter;
        ah ahVar = null;
        if (photoPanelAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoPanelAdapter");
            photoPanelAdapter = null;
        }
        if (photoPanelAdapter.x0(state.a(), state.b(), state.c())) {
            ox3.a.a("PhotoPanelVB", PhotoPanelVB$refreshList$1.INSTANCE);
            ah ahVar2 = this.binding;
            if (ahVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                ahVar2 = null;
            }
            ahVar2.f444747d.scrollToPosition(0);
        }
        PhotoPanelAdapter photoPanelAdapter2 = this.photoPanelAdapter;
        if (photoPanelAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoPanelAdapter");
            photoPanelAdapter2 = null;
        }
        if (!photoPanelAdapter2.n0().isEmpty()) {
            ah ahVar3 = this.binding;
            if (ahVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                ahVar3 = null;
            }
            ahVar3.f444749f.setVisibility(8);
            ah ahVar4 = this.binding;
            if (ahVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                ahVar = ahVar4;
            }
            ahVar.f444747d.setVisibility(0);
            return;
        }
        ah ahVar5 = this.binding;
        if (ahVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            ahVar5 = null;
        }
        ahVar5.f444749f.setVisibility(0);
        ah ahVar6 = this.binding;
        if (ahVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            ahVar = ahVar6;
        }
        ahVar.f444747d.setVisibility(8);
    }

    private final void y1(boolean isChecked) {
        ah ahVar = null;
        if (isChecked) {
            ah ahVar2 = this.binding;
            if (ahVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                ahVar2 = null;
            }
            ahVar2.f444752i.setVisibility(0);
            ah ahVar3 = this.binding;
            if (ahVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                ahVar = ahVar3;
            }
            ahVar.f444752i.setText(v1().a0());
            return;
        }
        ah ahVar4 = this.binding;
        if (ahVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            ahVar4 = null;
        }
        ahVar4.f444752i.setVisibility(4);
        ah ahVar5 = this.binding;
        if (ahVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            ahVar = ahVar5;
        }
        ahVar.f444752i.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z1(at.c intent) {
        v1().handleIntent(intent);
    }

    @Override // com.tencent.mobileqq.aio.panel.photo.a
    @NotNull
    public List<LocalMediaInfo> E0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (List) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return v1().G();
    }

    @Override // com.tencent.mobileqq.aio.panel.photo.a
    @NotNull
    public HashMap<String, String> H() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (HashMap) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        PhotoPanelAdapter photoPanelAdapter = this.photoPanelAdapter;
        if (photoPanelAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoPanelAdapter");
            photoPanelAdapter = null;
        }
        return photoPanelAdapter.o0();
    }

    @Override // com.tencent.mobileqq.aio.panel.photo.a
    @NotNull
    public List<LocalMediaInfo> K() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (List) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        PhotoPanelAdapter photoPanelAdapter = this.photoPanelAdapter;
        if (photoPanelAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoPanelAdapter");
            photoPanelAdapter = null;
        }
        return photoPanelAdapter.n0();
    }

    @Override // com.tencent.mobileqq.aio.panel.photo.a
    public void X0(@NotNull String originPath, @NotNull String editPath) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) originPath, (Object) editPath);
            return;
        }
        Intrinsics.checkNotNullParameter(originPath, "originPath");
        Intrinsics.checkNotNullParameter(editPath, "editPath");
        PhotoPanelAdapter photoPanelAdapter = this.photoPanelAdapter;
        if (photoPanelAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoPanelAdapter");
            photoPanelAdapter = null;
        }
        photoPanelAdapter.l0(originPath, editPath);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void bindViewAndData() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        boolean z16 = true;
        QLog.d("PhotoPanelVB", 1, "bindViewAndData");
        this.photoPanelAdapter = new PhotoPanelAdapter(this, v1());
        ah ahVar = this.binding;
        ah ahVar2 = null;
        if (ahVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            ahVar = null;
        }
        RecyclerView recyclerView = ahVar.f444747d;
        PhotoPanelAdapter photoPanelAdapter = this.photoPanelAdapter;
        if (photoPanelAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoPanelAdapter");
            photoPanelAdapter = null;
        }
        recyclerView.setAdapter(photoPanelAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 0, false));
        recyclerView.setItemAnimator(null);
        PhotoPanelAdapter photoPanelAdapter2 = this.photoPanelAdapter;
        if (photoPanelAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoPanelAdapter");
            photoPanelAdapter2 = null;
        }
        new ItemSwipeSendDecoration(new f(photoPanelAdapter2, new PhotoPanelVB$bindViewAndData$1$1(this))).attachToRecyclerView(recyclerView);
        ah ahVar3 = this.binding;
        if (ahVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            ahVar3 = null;
        }
        ahVar3.f444754k.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.panel.photo.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PhotoPanelVB.l1(PhotoPanelVB.this, view);
            }
        });
        ah ahVar4 = this.binding;
        if (ahVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            ahVar4 = null;
        }
        ahVar4.f444745b.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.panel.photo.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PhotoPanelVB.m1(PhotoPanelVB.this, view);
            }
        });
        ah ahVar5 = this.binding;
        if (ahVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            ahVar5 = null;
        }
        ahVar5.f444751h.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.panel.photo.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PhotoPanelVB.n1(view);
            }
        });
        ah ahVar6 = this.binding;
        if (ahVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            ahVar6 = null;
        }
        ahVar6.f444751h.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.aio.panel.photo.k
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z17) {
                PhotoPanelVB.o1(PhotoPanelVB.this, compoundButton, z17);
            }
        });
        ah ahVar7 = this.binding;
        if (ahVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            ahVar7 = null;
        }
        ahVar7.f444753j.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.panel.photo.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PhotoPanelVB.p1(PhotoPanelVB.this, view);
            }
        });
        ah ahVar8 = this.binding;
        if (ahVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            ahVar8 = null;
        }
        ahVar8.f444753j.post(new Runnable() { // from class: com.tencent.mobileqq.aio.panel.photo.m
            @Override // java.lang.Runnable
            public final void run() {
                PhotoPanelVB.q1(PhotoPanelVB.this);
            }
        });
        ah ahVar9 = this.binding;
        if (ahVar9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            ahVar9 = null;
        }
        TextView textView = ahVar9.f444748e;
        if (E0().size() <= 0) {
            z16 = false;
        }
        textView.setEnabled(z16);
        ah ahVar10 = this.binding;
        if (ahVar10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            ahVar10 = null;
        }
        TextView textView2 = ahVar10.f444748e;
        Context context = textView2.getContext();
        ah ahVar11 = this.binding;
        if (ahVar11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            ahVar11 = null;
        }
        if (ahVar11.f444748e.isEnabled()) {
            i3 = R.color.qui_common_text_primary;
        } else {
            i3 = R.color.qui_common_text_secondary_light;
        }
        textView2.setTextColor(context.getColorStateList(i3));
        ah ahVar12 = this.binding;
        if (ahVar12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            ahVar12 = null;
        }
        ahVar12.f444748e.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.panel.photo.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PhotoPanelVB.r1(PhotoPanelVB.this, view);
            }
        });
        if (FontSettingManager.isFontSizeLarge()) {
            ah ahVar13 = this.binding;
            if (ahVar13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                ahVar13 = null;
            }
            Context context2 = ahVar13.getRoot().getContext();
            ah ahVar14 = this.binding;
            if (ahVar14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                ahVar2 = ahVar14;
            }
            FontSettingManager.resetViewSize2Normal(context2, ahVar2.f444746c);
        }
        u1();
    }

    @Override // com.tencent.mobileqq.aio.panel.photo.a
    public boolean e0(@NotNull LocalMediaInfo mediainfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) mediainfo)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(mediainfo, "mediainfo");
        return v1().x(mediainfo);
    }

    @Override // com.tencent.mobileqq.aio.panel.photo.a
    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        ah ahVar = this.binding;
        if (ahVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            ahVar = null;
        }
        VideoReport.reportPgIn(ahVar.getRoot());
    }

    @Override // com.tencent.mobileqq.aio.panel.photo.a
    public void f0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            v1().A();
        }
    }

    @Override // com.tencent.mobileqq.aio.panel.photo.a
    public boolean m0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        ah ahVar = this.binding;
        if (ahVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            ahVar = null;
        }
        return ahVar.f444751h.isChecked();
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Map<String, Object> mutableMapOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) createViewParams);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        ah g16 = ah.g(LayoutInflater.from(createViewParams.a()));
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.f\u2026reateViewParams.context))");
        this.binding = g16;
        com.tencent.qqnt.qbasealbum.report.c cVar = com.tencent.qqnt.qbasealbum.report.c.f361503a;
        ah ahVar = null;
        if (g16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            g16 = null;
        }
        InterceptParentTouchLayout root = g16.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("graph_selector_source", 1), TuplesKt.to("qq_ref_pgid", "pg_aio"));
        cVar.f(root, "pg_bas_album_selector", mutableMapOf);
        ah ahVar2 = this.binding;
        if (ahVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            ahVar2 = null;
        }
        VideoReport.setPageReportPolicy(ahVar2.getRoot(), PageReportPolicy.REPORT_NONE);
        QLog.d("PhotoPanelVB", 1, "onCreateView()");
        ah ahVar3 = this.binding;
        if (ahVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            ahVar = ahVar3;
        }
        InterceptParentTouchLayout root2 = ahVar.getRoot();
        Intrinsics.checkNotNullExpressionValue(root2, "binding.root");
        return root2;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: s1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<at.c, PanelUIState> createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.aio.base.mvvm.b) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return v1();
    }

    @Override // com.tencent.mobileqq.aio.panel.photo.a
    public void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        ah ahVar = this.binding;
        if (ahVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            ahVar = null;
        }
        VideoReport.reportPgOut(ahVar.getRoot());
    }

    @Override // com.tencent.mobileqq.aio.panel.photo.a
    public void u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        PhotoPanelAdapter photoPanelAdapter = this.photoPanelAdapter;
        if (photoPanelAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoPanelAdapter");
            photoPanelAdapter = null;
        }
        photoPanelAdapter.m0();
    }

    @Override // com.tencent.mobileqq.aio.panel.photo.a
    public void v0(@NotNull g intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) intent);
        } else {
            Intrinsics.checkNotNullParameter(intent, "intent");
            sendIntent(intent);
        }
    }

    @Override // com.tencent.mobileqq.aio.panel.photo.a
    public void w(boolean isChecked) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, isChecked);
            return;
        }
        ah ahVar = this.binding;
        if (ahVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            ahVar = null;
        }
        ahVar.f444751h.setChecked(isChecked);
    }

    @Override // com.tencent.mvi.mvvm.BaseVB
    /* renamed from: w1, reason: merged with bridge method [inline-methods] */
    public void handleUIState(@NotNull PanelUIState state) {
        boolean z16;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) state);
            return;
        }
        Intrinsics.checkNotNullParameter(state, "state");
        String str = "";
        boolean z17 = true;
        ah ahVar = null;
        if (state instanceof PhotoPanelUIState.UpdateMediaInfo) {
            PhotoPanelUIState.UpdateMediaInfo updateMediaInfo = (PhotoPanelUIState.UpdateMediaInfo) state;
            QLog.d("PhotoPanelVB", 1, "UpdateMediaInfo, size " + updateMediaInfo.a().size());
            x1(updateMediaInfo);
            ah ahVar2 = this.binding;
            if (ahVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                ahVar2 = null;
            }
            y1(ahVar2.f444751h.isChecked());
            int size = E0().size();
            ah ahVar3 = this.binding;
            if (ahVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                ahVar3 = null;
            }
            TextView textView = ahVar3.f444748e;
            if (size == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            textView.setEnabled(z16);
            ah ahVar4 = this.binding;
            if (ahVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                ahVar4 = null;
            }
            TextView textView2 = ahVar4.f444748e;
            Context context = textView2.getContext();
            ah ahVar5 = this.binding;
            if (ahVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                ahVar5 = null;
            }
            if (ahVar5.f444748e.isEnabled()) {
                i3 = R.color.qui_common_text_primary;
            } else {
                i3 = R.color.qui_common_text_secondary_light;
            }
            textView2.setTextColor(context.getColorStateList(i3));
            if (size > 0) {
                str = "(" + size + ")";
            }
            String str2 = "\u53d1\u9001" + str;
            ah ahVar6 = this.binding;
            if (ahVar6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                ahVar6 = null;
            }
            ahVar6.f444754k.setText(str2);
            ah ahVar7 = this.binding;
            if (ahVar7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                ahVar = ahVar7;
            }
            QUIButton qUIButton = ahVar.f444754k;
            if (size <= 0) {
                z17 = false;
            }
            qUIButton.setEnabled(z17);
            return;
        }
        if (state instanceof PhotoPanelUIState.ShieldQuality) {
            QLog.d("PhotoPanelVB", 1, "PhotoPanelUIState.ShieldQuality");
            ah ahVar8 = this.binding;
            if (ahVar8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                ahVar8 = null;
            }
            ahVar8.f444751h.setVisibility(4);
            ah ahVar9 = this.binding;
            if (ahVar9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                ahVar9 = null;
            }
            ahVar9.f444753j.setVisibility(4);
            ah ahVar10 = this.binding;
            if (ahVar10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                ahVar10 = null;
            }
            ahVar10.f444752i.setVisibility(4);
            ah ahVar11 = this.binding;
            if (ahVar11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                ahVar = ahVar11;
            }
            ahVar.f444752i.setText("");
        }
    }
}
