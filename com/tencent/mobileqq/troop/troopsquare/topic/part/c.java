package com.tencent.mobileqq.troop.troopsquare.topic.part;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.troopsquare.topic.share.TroopSquareTopicShareSheet;
import com.tencent.mobileqq.troop.troopsquare.topic.vm.TroopSquareTopicViewModel;
import com.tencent.mobileqq.troop.troopsquare.utils.ShareAction;
import com.tencent.mobileqq.troop.utils.h;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 /2\u00020\u0001:\u00010B\u0007\u00a2\u0006\u0004\b-\u0010.J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010\f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\"\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u001b\u0010,\u001a\u00020'8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsquare/topic/part/c;", "Lcom/tencent/biz/richframework/part/Part;", "", "D9", "G9", "F9", "Landroid/content/Intent;", "data", "", "B9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "requestCode", QzoneIPCModule.RESULT_CODE, "onActivityResult", "Lcom/tencent/mobileqq/troop/troopsquare/topic/share/a;", "d", "Lcom/tencent/mobileqq/troop/troopsquare/topic/share/a;", "reporter", "Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "e", "Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "navBar", "Lcom/tencent/mobileqq/troop/troopsquare/topic/share/TroopSquareTopicShareSheet;", "f", "Lcom/tencent/mobileqq/troop/troopsquare/topic/share/TroopSquareTopicShareSheet;", "shareSheet", "", h.F, "Z", "isLastShareWechat", "Lcom/tencent/mobileqq/wxapi/WXShareHelper$a;", "i", "Lcom/tencent/mobileqq/wxapi/WXShareHelper$a;", "wechatShareCallback", "Lcom/tencent/mobileqq/troop/troopsquare/topic/vm/TroopSquareTopicViewModel;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Lazy;", "C9", "()Lcom/tencent/mobileqq/troop/troopsquare/topic/vm/TroopSquareTopicViewModel;", "viewModel", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class c extends Part {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.troop.troopsquare.topic.share.a reporter;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QUISecNavBar navBar;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TroopSquareTopicShareSheet shareSheet;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isLastShareWechat;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WXShareHelper.a wechatShareCallback;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsquare/topic/part/c$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopsquare.topic.part.c$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\u0014\u0010\u000b\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\n\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/troop/troopsquare/topic/part/c$b", "Lcom/tencent/biz/qui/quisecnavbar/a;", "", "b", "Landroid/view/View;", "view", "", "a", "", "getDrawable", "()I", "drawable", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b extends com.tencent.biz.qui.quisecnavbar.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        @Override // com.tencent.biz.qui.quisecnavbar.a, com.tencent.biz.qui.quisecnavbar.b
        public void a(@Nullable View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                TroopSquareTopicShareSheet troopSquareTopicShareSheet = c.this.shareSheet;
                if (troopSquareTopicShareSheet != null) {
                    troopSquareTopicShareSheet.o();
                }
                com.tencent.mobileqq.troop.troopsquare.common.c cVar = com.tencent.mobileqq.troop.troopsquare.common.c.f301578a;
                if (view == null) {
                    return;
                }
                h.a.f(cVar, view, "em_group_share_btn", null, null, 12, null);
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view);
        }

        @Override // com.tencent.biz.qui.quisecnavbar.a, com.tencent.biz.qui.quisecnavbar.b
        @NotNull
        public String b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            String string = c.this.getActivity().getString(R.string.hja);
            Intrinsics.checkNotNullExpressionValue(string, "activity.getString(com.t\u2026q.qqui.R.string.share_to)");
            return string;
        }

        @Override // com.tencent.biz.qui.quisecnavbar.b
        public int getDrawable() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return R.drawable.qui_share_icon_nav_secondary;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\t\u001a\u00028\u00008VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/troop/troopsquare/topic/part/c$c", "Lkotlin/Lazy;", "", "isInitialized", "d", "Landroidx/lifecycle/ViewModel;", "cached", "a", "()Landroidx/lifecycle/ViewModel;", "value", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopsquare.topic.part.c$c, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public static final class C8829c implements Lazy<TroopSquareTopicViewModel> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private TroopSquareTopicViewModel cached;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Part f301691e;

        public C8829c(Part part) {
            this.f301691e = part;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) part);
            }
        }

        /* JADX WARN: Type inference failed for: r0v4, types: [androidx.lifecycle.ViewModel, java.lang.Object, com.tencent.mobileqq.troop.troopsquare.topic.vm.TroopSquareTopicViewModel] */
        /* JADX WARN: Type inference failed for: r0v6, types: [androidx.lifecycle.ViewModel, com.tencent.mobileqq.troop.troopsquare.topic.vm.TroopSquareTopicViewModel] */
        @Override // kotlin.Lazy
        @NotNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TroopSquareTopicViewModel getValue() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (ViewModel) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            TroopSquareTopicViewModel troopSquareTopicViewModel = this.cached;
            Object partHost = this.f301691e.getPartHost();
            Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
            Fragment fragment = (Fragment) partHost;
            if (troopSquareTopicViewModel == null) {
                ViewModelProvider.Factory a16 = com.tencent.mobileqq.troop.homework.common.b.a(fragment);
                ViewModelStore viewModelStore = fragment.get_viewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "fragment.viewModelStore");
                ?? r06 = new ViewModelProvider(viewModelStore, a16).get(TroopSquareTopicViewModel.class);
                this.cached = r06;
                Intrinsics.checkNotNullExpressionValue(r06, "{\n                val fa\u2026          }\n            }");
                return r06;
            }
            return troopSquareTopicViewModel;
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61693);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.wechatShareCallback = new WXShareHelper.a() { // from class: com.tencent.mobileqq.troop.troopsquare.topic.part.b
                @Override // com.tencent.mobileqq.wxapi.WXShareHelper.a
                public final void onWXShareResp(BaseResp baseResp) {
                    c.H9(c.this, baseResp);
                }
            };
            this.viewModel = new C8829c(this);
        }
    }

    private final int B9(Intent data) {
        Bundle extras;
        boolean z16 = false;
        if (data != null && (extras = data.getExtras()) != null && extras.getInt("uintype") == 0) {
            z16 = true;
        }
        if (z16) {
            return 1;
        }
        return 2;
    }

    private final TroopSquareTopicViewModel C9() {
        return (TroopSquareTopicViewModel) this.viewModel.getValue();
    }

    private final void D9() {
        QIphoneTitleBarFragment qIphoneTitleBarFragment;
        IPartHost partHost = getPartHost();
        if (partHost instanceof QIphoneTitleBarFragment) {
            qIphoneTitleBarFragment = (QIphoneTitleBarFragment) partHost;
        } else {
            qIphoneTitleBarFragment = null;
        }
        if (qIphoneTitleBarFragment == null) {
            QLog.e("TroopSquare.Topic.TroopSquareTopicSharePart", 1, "host is not QIphoneTitleBarFragment");
            return;
        }
        this.reporter = new com.tencent.mobileqq.troop.troopsquare.topic.share.a(qIphoneTitleBarFragment);
        QUISecNavBar qUISecNavBar = qIphoneTitleBarFragment.quiSecNavBar;
        if (qUISecNavBar == null) {
            QLog.e("TroopSquare.Topic.TroopSquareTopicSharePart", 1, "cannot find navbar");
            return;
        }
        this.navBar = qUISecNavBar;
        Activity activity = getActivity();
        if (activity == null) {
            QLog.e("TroopSquare.Topic.TroopSquareTopicSharePart", 1, "cannot find activity");
            return;
        }
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(qIphoneTitleBarFragment);
        long S1 = C9().S1();
        String U1 = C9().U1();
        Intrinsics.checkNotNullExpressionValue(U1, "viewModel.ext");
        TroopSquareTopicShareSheet troopSquareTopicShareSheet = new TroopSquareTopicShareSheet(activity, lifecycleScope, S1, U1);
        troopSquareTopicShareSheet.n(new ShareActionSheet.c() { // from class: com.tencent.mobileqq.troop.troopsquare.topic.part.a
            @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.c
            public final void w6(View view, ShareActionSheetBuilder.ActionSheetItem actionSheetItem, ShareActionSheet shareActionSheet) {
                c.E9(c.this, view, actionSheetItem, shareActionSheet);
            }
        });
        this.shareSheet = troopSquareTopicShareSheet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E9(c this$0, View view, ShareActionSheetBuilder.ActionSheetItem item, ShareActionSheet sheet) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (item.action == 9) {
            z16 = true;
        } else {
            z16 = false;
        }
        this$0.isLastShareWechat = z16;
        Intrinsics.checkNotNullExpressionValue(view, "view");
        Intrinsics.checkNotNullExpressionValue(item, "item");
        Intrinsics.checkNotNullExpressionValue(sheet, "sheet");
        ShareAction shareAction = new ShareAction(view, item, sheet);
        com.tencent.mobileqq.troop.troopsquare.topic.share.a aVar = this$0.reporter;
        if (aVar == null) {
            return;
        }
        shareAction.d(aVar);
    }

    private final void F9() {
        WXShareHelper.b0().A(this.wechatShareCallback);
    }

    private final void G9() {
        b bVar = new b();
        QUISecNavBar qUISecNavBar = this.navBar;
        if (qUISecNavBar == null) {
            QLog.e("TroopSquare.Topic.TroopSquareTopicSharePart", 1, "nav bar is null");
        } else {
            h.a.j(com.tencent.mobileqq.troop.troopsquare.common.c.f301578a, qUISecNavBar, "em_group_share_btn", null, null, 12, null);
            qUISecNavBar.d(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(c this$0, BaseResp baseResp) {
        int i3;
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.troop.troopsquare.topic.share.a aVar = this$0.reporter;
        if (aVar != null) {
            if (this$0.isLastShareWechat) {
                i3 = 3;
            } else {
                i3 = 4;
            }
            if (baseResp.errCode == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            aVar.i(i3, null, null, Boolean.valueOf(z16));
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Bundle extras;
        com.tencent.mobileqq.troop.troopsquare.topic.share.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
            return;
        }
        if (QLog.isDebugVersion()) {
            QLog.d("TroopSquare.Topic.TroopSquareTopicSharePart", 4, resultCode + ", " + resultCode + ", " + data);
        }
        if (resultCode == -1) {
            z16 = true;
        }
        String str = null;
        if (requestCode != 0 && requestCode != 1) {
            if (requestCode != 5) {
                if (requestCode == 20000 && (aVar = this.reporter) != null) {
                    aVar.i(2, null, null, Boolean.valueOf(z16));
                    return;
                }
                return;
            }
            com.tencent.mobileqq.troop.troopsquare.topic.share.a aVar2 = this.reporter;
            if (aVar2 != null) {
                aVar2.i(5, null, null, Boolean.valueOf(z16));
                return;
            }
            return;
        }
        com.tencent.mobileqq.troop.troopsquare.topic.share.a aVar3 = this.reporter;
        if (aVar3 != null) {
            if (data != null && (extras = data.getExtras()) != null) {
                str = extras.getString("uin");
            }
            aVar3.i(1, str, Integer.valueOf(B9(data)), Boolean.valueOf(z16));
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        D9();
        G9();
        F9();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity);
        } else {
            super.onPartDestroy(activity);
            WXShareHelper.b0().q0(this.wechatShareCallback);
        }
    }
}
