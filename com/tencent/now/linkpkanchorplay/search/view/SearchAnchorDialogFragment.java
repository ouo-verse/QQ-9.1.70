package com.tencent.now.linkpkanchorplay.search.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.component.core.event.Eventor;
import com.tencent.component.core.event.impl.OnEvent;
import com.tencent.now.linkpkanchorplay.event.d;
import com.tencent.now.linkpkanchorplay.invite.model.AnchorTabPageContext;
import com.tencent.now.linkpkanchorplay.invite.view.BottomDialog;
import com.tencent.now.linkpkanchorplay.search.view.SearchAnchorDialogFragment;
import com.tencent.now.linkpkanchorplay.search.view.SearchAnchorViewCtrl;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import om3.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000O\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0007*\u0001\u001f\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\r\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0002J&\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016R\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001b\u0010\u001a\u001a\u00020\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/search/view/SearchAnchorDialogFragment;", "Lcom/tencent/now/linkpkanchorplay/invite/view/BottomDialog;", "", "yh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/now/linkpkanchorplay/invite/model/a;", "H", "Lcom/tencent/now/linkpkanchorplay/invite/model/a;", "pageContext", "", "I", "Ljava/lang/String;", "TAG", "Lcom/tencent/now/linkpkanchorplay/search/view/SearchAnchorViewCtrl;", "J", "Lkotlin/Lazy;", "xh", "()Lcom/tencent/now/linkpkanchorplay/search/view/SearchAnchorViewCtrl;", "searchCtrl", "Lcom/tencent/component/core/event/Eventor;", "K", "Lcom/tencent/component/core/event/Eventor;", "eventor", "com/tencent/now/linkpkanchorplay/search/view/SearchAnchorDialogFragment$a", "L", "Lcom/tencent/now/linkpkanchorplay/search/view/SearchAnchorDialogFragment$a;", "cancelSearchListener", "<init>", "(Lcom/tencent/now/linkpkanchorplay/invite/model/a;)V", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class SearchAnchorDialogFragment extends BottomDialog {

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final AnchorTabPageContext pageContext;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final String TAG;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Lazy searchCtrl;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Eventor eventor;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final a cancelSearchListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/now/linkpkanchorplay/search/view/SearchAnchorDialogFragment$a", "Lcom/tencent/now/linkpkanchorplay/search/view/SearchAnchorViewCtrl$a;", "", "a", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class a implements SearchAnchorViewCtrl.a {
        a() {
        }

        @Override // com.tencent.now.linkpkanchorplay.search.view.SearchAnchorViewCtrl.a
        public void a() {
            Dialog dialog = SearchAnchorDialogFragment.this.getDialog();
            if (dialog != null) {
                dialog.cancel();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/now/linkpkanchorplay/search/view/SearchAnchorDialogFragment$b", "Lcom/tencent/component/core/event/impl/OnEvent;", "Lcom/tencent/now/linkpkanchorplay/event/d$h;", "event", "", "a", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class b implements OnEvent<d.StateChangeEvent> {
        b() {
        }

        @Override // com.tencent.component.core.event.impl.OnEvent
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onRecv(@NotNull d.StateChangeEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (event.getCurState() instanceof d.InvitationSent) {
                SearchAnchorDialogFragment.this.xh().J();
                SearchAnchorDialogFragment.this.dismissAllowingStateLoss();
            }
        }
    }

    public SearchAnchorDialogFragment(@NotNull AnchorTabPageContext pageContext) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(pageContext, "pageContext");
        this.pageContext = pageContext;
        this.TAG = "SearchAnchorDialogFragment";
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<SearchAnchorViewCtrl>() { // from class: com.tencent.now.linkpkanchorplay.search.view.SearchAnchorDialogFragment$searchCtrl$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final SearchAnchorViewCtrl invoke() {
                AnchorTabPageContext anchorTabPageContext;
                SearchAnchorDialogFragment.a aVar;
                Context context = SearchAnchorDialogFragment.this.getContext();
                Intrinsics.checkNotNull(context);
                anchorTabPageContext = SearchAnchorDialogFragment.this.pageContext;
                SearchAnchorDialogFragment searchAnchorDialogFragment = SearchAnchorDialogFragment.this;
                aVar = searchAnchorDialogFragment.cancelSearchListener;
                return new SearchAnchorViewCtrl(context, anchorTabPageContext, searchAnchorDialogFragment, searchAnchorDialogFragment, aVar);
            }
        });
        this.searchCtrl = lazy;
        this.eventor = new Eventor();
        this.cancelSearchListener = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SearchAnchorViewCtrl xh() {
        return (SearchAnchorViewCtrl) this.searchCtrl.getValue();
    }

    private final void yh() {
        this.eventor.addOnEvent(new b());
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        yh();
        View C = xh().C();
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, C);
        return C;
    }

    @Override // com.tencent.now.linkpkanchorplay.invite.view.BottomDialog, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.eventor.removeAll();
    }
}
