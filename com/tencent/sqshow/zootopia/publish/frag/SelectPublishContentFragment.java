package com.tencent.sqshow.zootopia.publish.frag;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.zootopia.FragmentSource;
import com.tencent.mobileqq.zootopia.Source;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.qqmini.sdk.request.GetAdInfoRequest;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import com.tencent.sqshow.zootopia.publish.page.b;
import com.tencent.sqshow.zootopia.publish.tab.SelectPublishContentBtmTitle;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import n74.co;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 *2\u00020\u0001:\u0001+B\u0007\u00a2\u0006\u0004\b(\u0010)J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\f\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J$\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00112\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u0015\u001a\u00020\bH\u0016J\b\u0010\u0016\u001a\u00020\bH\u0016R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001b\u0010$\u001a\u00020\u001f8DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001b\u0010'\u001a\u00020\u001f8DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010!\u001a\u0004\b&\u0010#\u00a8\u0006,"}, d2 = {"Lcom/tencent/sqshow/zootopia/publish/frag/SelectPublishContentFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Lcom/tencent/mobileqq/zootopia/FragmentSource;", "sh", "Lcom/tencent/mobileqq/zootopia/Source;", "rh", "Ln74/co;", "binding", "", "vh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onDestroyView", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "mPublishContentSource", "Lcom/tencent/sqshow/zootopia/publish/frag/a;", "D", "Lcom/tencent/sqshow/zootopia/publish/frag/a;", "mController", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "E", "Lkotlin/Lazy;", "uh", "()Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", GetAdInfoRequest.SOURCE_FROM, UserInfo.SEX_FEMALE, "th", "sourceCurrent", "<init>", "()V", "G", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class SelectPublishContentFragment extends QPublicBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private String mPublishContentSource = ZPlanPublishSource.FROM_DRESS_SQUARE_TITLE;

    /* renamed from: D, reason: from kotlin metadata */
    private final a mController = new a();

    /* renamed from: E, reason: from kotlin metadata */
    private final Lazy sourceFrom;

    /* renamed from: F, reason: from kotlin metadata */
    private final Lazy sourceCurrent;

    public SelectPublishContentFragment() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ZootopiaSource>() { // from class: com.tencent.sqshow.zootopia.publish.frag.SelectPublishContentFragment$sourceFrom$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZootopiaSource invoke() {
                FragmentSource sh5;
                ZootopiaSource from;
                sh5 = SelectPublishContentFragment.this.sh();
                return (sh5 == null || (from = sh5.getFrom()) == null) ? ZootopiaSource.INSTANCE.i() : from;
            }
        });
        this.sourceFrom = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<ZootopiaSource>() { // from class: com.tencent.sqshow.zootopia.publish.frag.SelectPublishContentFragment$sourceCurrent$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZootopiaSource invoke() {
                Source rh5;
                ZootopiaSource.Companion companion = ZootopiaSource.INSTANCE;
                rh5 = SelectPublishContentFragment.this.rh();
                return companion.c(rh5, "SelectPublishContentFragment", SelectPublishContentFragment.this.uh());
            }
        });
        this.sourceCurrent = lazy2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Source rh() {
        Source current;
        FragmentSource sh5 = sh();
        return (sh5 == null || (current = sh5.getCurrent()) == null) ? Source.UnSet : current;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentSource sh() {
        Intent intent;
        ZootopiaSource.Companion companion = ZootopiaSource.INSTANCE;
        FragmentSource f16 = companion.f(getArguments());
        if (f16 != null) {
            return f16;
        }
        FragmentActivity activity = getActivity();
        return companion.f((activity == null || (intent = activity.getIntent()) == null) ? null : intent.getExtras());
    }

    private final void vh(co binding) {
        binding.f419047c.setOverScrollMode(2);
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        a aVar = this.mController;
        SelectPublishContentBtmTitle selectPublishContentBtmTitle = binding.f419046b;
        Intrinsics.checkNotNullExpressionValue(selectPublishContentBtmTitle, "binding.btmTitle");
        ViewPager viewPager = binding.f419047c;
        Intrinsics.checkNotNullExpressionValue(viewPager, "binding.viewPager");
        aVar.a(selectPublishContentBtmTitle, viewPager, new b(childFragmentManager, th()));
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        Bundle bundle = null;
        String string = arguments != null ? arguments.getString("zplan_publish_back_scheme", "") : null;
        a aVar = this.mController;
        if (!TextUtils.isEmpty(string)) {
            bundle = new Bundle();
            bundle.putString("zplan_publish_back_scheme", string);
        }
        aVar.b(bundle);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        co g16 = co.g(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(inflater, container, false)");
        vh(g16);
        ConstraintLayout root = g16.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
    }

    protected final ZootopiaSource th() {
        return (ZootopiaSource) this.sourceCurrent.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ZootopiaSource uh() {
        return (ZootopiaSource) this.sourceFrom.getValue();
    }
}
