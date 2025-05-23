package com.tencent.mobileqq.troop.teamup.publish.part;

import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.teamup.publish.view.TroopTeamUpPublishLayout;
import com.tencent.mobileqq.troop.teamup.publish.vm.TroopTeamUpPublishVM;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.QQToastUtil;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u001b\u0010\r\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/publish/part/TroopTeamUpPublishMediaInputButtonsPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "getLogTag", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "Lcom/tencent/mobileqq/troop/teamup/publish/vm/TroopTeamUpPublishVM;", "d", "Lkotlin/Lazy;", "A9", "()Lcom/tencent/mobileqq/troop/teamup/publish/vm/TroopTeamUpPublishVM;", "data", "", "Lcom/tencent/mobileqq/troop/teamup/publish/part/a;", "e", "Ljava/util/List;", "inputButtons", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopTeamUpPublishMediaInputButtonsPart extends Part {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy data;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<com.tencent.mobileqq.troop.teamup.publish.part.a> inputButtons;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\t\u001a\u00028\u00008VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/troop/teamup/publish/part/TroopTeamUpPublishMediaInputButtonsPart$a", "Lkotlin/Lazy;", "", "isInitialized", "d", "Landroidx/lifecycle/ViewModel;", "cached", "a", "()Landroidx/lifecycle/ViewModel;", "value", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class a implements Lazy<TroopTeamUpPublishVM> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private TroopTeamUpPublishVM cached;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Part f299131e;

        public a(Part part) {
            this.f299131e = part;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) part);
            }
        }

        /* JADX WARN: Type inference failed for: r0v4, types: [androidx.lifecycle.ViewModel, java.lang.Object, com.tencent.mobileqq.troop.teamup.publish.vm.TroopTeamUpPublishVM] */
        /* JADX WARN: Type inference failed for: r0v6, types: [androidx.lifecycle.ViewModel, com.tencent.mobileqq.troop.teamup.publish.vm.TroopTeamUpPublishVM] */
        @Override // kotlin.Lazy
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TroopTeamUpPublishVM getValue() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (ViewModel) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            TroopTeamUpPublishVM troopTeamUpPublishVM = this.cached;
            Object partHost = this.f299131e.getPartHost();
            Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
            Fragment fragment = (Fragment) partHost;
            if (troopTeamUpPublishVM == null) {
                ViewModelProvider.Factory a16 = com.tencent.mobileqq.troop.homework.common.b.a(fragment);
                ViewModelStore viewModelStore = fragment.get_viewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "fragment.viewModelStore");
                ?? r06 = new ViewModelProvider(viewModelStore, a16).get(TroopTeamUpPublishVM.class);
                this.cached = r06;
                Intrinsics.checkNotNullExpressionValue(r06, "{\n                val fa\u2026          }\n            }");
                return r06;
            }
            return troopTeamUpPublishVM;
        }

        @Override // kotlin.Lazy
        public boolean isInitialized() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            if (this.cached != null) {
                return true;
            }
            return false;
        }
    }

    public TroopTeamUpPublishMediaInputButtonsPart() {
        List<com.tencent.mobileqq.troop.teamup.publish.part.a> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.data = new a(this);
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.mobileqq.troop.teamup.publish.part.a[]{new com.tencent.mobileqq.troop.teamup.publish.part.a(R.drawable.qui_image_selector, new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.teamup.publish.part.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopTeamUpPublishMediaInputButtonsPart.B9(TroopTeamUpPublishMediaInputButtonsPart.this, view);
            }
        }), new com.tencent.mobileqq.troop.teamup.publish.part.a(R.drawable.qui_camera_selector, new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.teamup.publish.part.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopTeamUpPublishMediaInputButtonsPart.C9(TroopTeamUpPublishMediaInputButtonsPart.this, view);
            }
        })});
        this.inputButtons = listOf;
    }

    private final TroopTeamUpPublishVM A9() {
        return (TroopTeamUpPublishVM) this.data.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B9(TroopTeamUpPublishMediaInputButtonsPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.A9().P1().n() >= this$0.A9().O1()) {
            QQToastUtil.showQQToast(1, "\u6700\u591a\u53ea\u80fd\u9009\u4e2d" + this$0.A9().O1() + "\u4e2a\u56fe\u7247");
        } else {
            this$0.broadcastMessage("start_select_media", new com.tencent.mobileqq.troop.homework.common.widget.mediaedit.part.k(Math.max(this$0.A9().O1() - this$0.A9().P1().n(), 0), 4));
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C9(TroopTeamUpPublishMediaInputButtonsPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.A9().P1().n() >= this$0.A9().O1()) {
            QQToastUtil.showQQToast(1, "\u6700\u591a\u53ea\u80fd\u9009\u4e2d" + this$0.A9().O1() + "\u4e2a\u56fe\u7247");
        } else {
            this$0.broadcastMessage("start_capture_media", null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "TroopTeamUp.PublishPublishMediaInputButtonsPart";
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
        ((TroopTeamUpPublishLayout) rootView).c().setAdapter(com.tencent.mobileqq.troop.teamup.publish.e.a(this.inputButtons, ImageView.class, TroopTeamUpPublishMediaInputButtonsPart$onInitView$1.INSTANCE));
    }
}
