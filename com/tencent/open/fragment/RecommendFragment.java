package com.tencent.open.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.biz.richframework.widget.RFWRoundImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.open.agent.util.g;
import com.tencent.open.agent.util.t;
import com.tencent.open.fragment.RecommendFragment;
import com.tencent.qconn.protofile.OpenSdkRecCommon$PromoteGroupView;
import com.tencent.qconn.protofile.OpenSdkRecCommon$PromoteViewItem;
import com.tencent.qconn.protofile.SubmitPromotePage$SubmitResultItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import dq3.f;
import eq3.RecSingleItem;
import fq3.a;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\b\u0018\u0000 E2\u00020\u00012\u00020\u0002:\u0001FB\u0007\u00a2\u0006\u0004\bC\u0010DJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\u0003H\u0002J\b\u0010\u000e\u001a\u00020\u0003H\u0002J&\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0003H\u0016J\u0012\u0010\u0018\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u0019\u001a\u00020\tH\u0016R\u0016\u0010\u001c\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010*\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010'R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R \u00106\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u0001038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0014\u0010:\u001a\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109R\u001a\u0010>\u001a\b\u0012\u0004\u0012\u00020<0;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u00105R\u001a\u0010B\u001a\b\u0012\u0004\u0012\u00020<0?8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010A\u00a8\u0006G"}, d2 = {"Lcom/tencent/open/fragment/RecommendFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Landroid/view/View$OnClickListener;", "", "initViews", "th", "uh", "Lcom/tencent/qconn/protofile/OpenSdkRecCommon$PromoteGroupView;", "data", "", "showTitle", "Landroid/view/View;", "qh", "vh", "wh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreateView", "onResume", "v", NodeProps.ON_CLICK, "onBackEvent", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/ViewGroup;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/widget/ImageView;", "D", "Landroid/widget/ImageView;", "btnBack", "Lcom/tencent/biz/richframework/widget/RFWRoundImageView;", "E", "Lcom/tencent/biz/richframework/widget/RFWRoundImageView;", "appIcon", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "appInfo", "G", "recTips", "Landroid/widget/LinearLayout;", "H", "Landroid/widget/LinearLayout;", "recContainer", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "I", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "btnConfirm", "", "J", "Ljava/util/List;", "groups", "Lfq3/a;", "K", "Lfq3/a;", "recommendItemConverter", "", "Leq3/b;", "L", "recSingleItemList", "", "M", "Ljava/util/Set;", "checkedRecSingleItemList", "<init>", "()V", "N", "a", "opensdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class RecommendFragment extends QPublicBaseFragment implements View.OnClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    private ViewGroup rootView;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private ImageView btnBack;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private RFWRoundImageView appIcon;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private TextView appInfo;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private TextView recTips;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private LinearLayout recContainer;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private QUIButton btnConfirm;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private List<OpenSdkRecCommon$PromoteGroupView> groups;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final a recommendItemConverter = new a();

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final List<RecSingleItem> recSingleItemList = new ArrayList();

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final Set<RecSingleItem> checkedRecSingleItemList = new LinkedHashSet();

    private final void initViews() {
        List<View> listOf;
        ViewGroup viewGroup = this.rootView;
        ViewGroup viewGroup2 = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            viewGroup = null;
        }
        this.btnBack = (ImageView) viewGroup.findViewById(R.id.a47);
        ViewGroup viewGroup3 = this.rootView;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            viewGroup3 = null;
        }
        this.appIcon = (RFWRoundImageView) viewGroup3.findViewById(R.id.f164379vi);
        ViewGroup viewGroup4 = this.rootView;
        if (viewGroup4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            viewGroup4 = null;
        }
        this.appInfo = (TextView) viewGroup4.findViewById(R.id.stn);
        ViewGroup viewGroup5 = this.rootView;
        if (viewGroup5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            viewGroup5 = null;
        }
        this.recTips = (TextView) viewGroup5.findViewById(R.id.f70733m9);
        ViewGroup viewGroup6 = this.rootView;
        if (viewGroup6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            viewGroup6 = null;
        }
        this.recContainer = (LinearLayout) viewGroup6.findViewById(R.id.f70713m7);
        ViewGroup viewGroup7 = this.rootView;
        if (viewGroup7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
        } else {
            viewGroup2 = viewGroup7;
        }
        this.btnConfirm = (QUIButton) viewGroup2.findViewById(R.id.agd);
        th();
        uh();
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new View[]{this.btnBack, this.btnConfirm});
        for (View view : listOf) {
            if (view != null) {
                view.setOnClickListener(this);
            }
        }
    }

    private final View qh(OpenSdkRecCommon$PromoteGroupView data, boolean showTitle) {
        List<OpenSdkRecCommon$PromoteViewItem> list = data.items.get();
        if (list == null || list.size() <= 0) {
            return null;
        }
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.fqr, (ViewGroup) this.recContainer, false);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) inflate;
        String str = data.group_name.get();
        if (showTitle && !TextUtils.isEmpty(str)) {
            ((LinearLayout) viewGroup.findViewById(R.id.cyp)).setVisibility(0);
            ((TextView) viewGroup.findViewById(R.id.vuq)).setText(str);
        } else {
            ((LinearLayout) viewGroup.findViewById(R.id.cyp)).setVisibility(8);
        }
        for (OpenSdkRecCommon$PromoteViewItem viewItem : list) {
            View inflate2 = LayoutInflater.from(getContext()).inflate(R.layout.fqs, viewGroup, false);
            Intrinsics.checkNotNull(inflate2, "null cannot be cast to non-null type android.view.ViewGroup");
            ViewGroup viewGroup2 = (ViewGroup) inflate2;
            QUICheckBox checkBox = (QUICheckBox) viewGroup2.findViewById(R.id.awy);
            a aVar = this.recommendItemConverter;
            Intrinsics.checkNotNullExpressionValue(viewItem, "viewItem");
            viewGroup2.addView(aVar.a(viewGroup, viewItem));
            int i3 = viewItem.type.get();
            String str2 = viewItem.f342463id.get();
            Intrinsics.checkNotNullExpressionValue(checkBox, "checkBox");
            final RecSingleItem recSingleItem = new RecSingleItem(i3, str2, checkBox);
            this.recSingleItemList.add(recSingleItem);
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: vp3.a
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                    RecommendFragment.sh(RecommendFragment.this, recSingleItem, compoundButton, z16);
                }
            });
            checkBox.setChecked(true);
            ((LinearLayout) viewGroup.findViewById(R.id.cxn)).addView(viewGroup2);
        }
        return viewGroup;
    }

    static /* synthetic */ View rh(RecommendFragment recommendFragment, OpenSdkRecCommon$PromoteGroupView openSdkRecCommon$PromoteGroupView, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        return recommendFragment.qh(openSdkRecCommon$PromoteGroupView, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sh(RecommendFragment this$0, RecSingleItem recSingleItem, CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(recSingleItem, "$recSingleItem");
        if (z16) {
            this$0.checkedRecSingleItemList.add(recSingleItem);
        } else {
            this$0.checkedRecSingleItemList.remove(recSingleItem);
        }
        this$0.vh();
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    private final void th() {
        TextView textView;
        TextView textView2;
        RFWRoundImageView rFWRoundImageView;
        f fVar = f.f394643a;
        String m3 = fVar.m();
        if (m3 != null && (rFWRoundImageView = this.appIcon) != null) {
            rFWRoundImageView.setImageDrawable(URLDrawable.getDrawable(m3));
        }
        String o16 = fVar.o();
        if (o16 != null && (textView2 = this.appInfo) != null) {
            textView2.setText(o16);
        }
        String n3 = fVar.n();
        if (n3 != null && (textView = this.recTips) != null) {
            textView.setText(n3);
        }
    }

    private final void uh() {
        LinearLayout linearLayout;
        OpenSdkRecCommon$PromoteGroupView openSdkRecCommon$PromoteGroupView;
        List<OpenSdkRecCommon$PromoteGroupView> list = this.groups;
        if (list != null) {
            int size = list.size();
            if (size != 0) {
                OpenSdkRecCommon$PromoteGroupView openSdkRecCommon$PromoteGroupView2 = null;
                if (size != 1) {
                    for (OpenSdkRecCommon$PromoteGroupView openSdkRecCommon$PromoteGroupView3 : list) {
                        if (openSdkRecCommon$PromoteGroupView3 != null) {
                            openSdkRecCommon$PromoteGroupView = openSdkRecCommon$PromoteGroupView3.get();
                        } else {
                            openSdkRecCommon$PromoteGroupView = null;
                        }
                        if (openSdkRecCommon$PromoteGroupView != null) {
                            Intrinsics.checkNotNullExpressionValue(openSdkRecCommon$PromoteGroupView, "groupItem?.get() ?: continue");
                            LinearLayout linearLayout2 = this.recContainer;
                            if (linearLayout2 != null) {
                                linearLayout2.addView(rh(this, openSdkRecCommon$PromoteGroupView, false, 2, null));
                            }
                        }
                    }
                    return;
                }
                OpenSdkRecCommon$PromoteGroupView openSdkRecCommon$PromoteGroupView4 = list.get(0);
                if (openSdkRecCommon$PromoteGroupView4 != null) {
                    openSdkRecCommon$PromoteGroupView2 = openSdkRecCommon$PromoteGroupView4.get();
                }
                if (openSdkRecCommon$PromoteGroupView2 != null && (linearLayout = this.recContainer) != null) {
                    linearLayout.addView(qh(openSdkRecCommon$PromoteGroupView2, false));
                    return;
                }
                return;
            }
            t.f("RecommendFragment", "groups is empty");
            getQBaseActivity().setResult(-1);
            getQBaseActivity().finish();
        }
    }

    private final void vh() {
        if (this.checkedRecSingleItemList.isEmpty()) {
            QUIButton qUIButton = this.btnConfirm;
            if (qUIButton != null) {
                qUIButton.setText(getString(R.string.f172852rk));
                return;
            }
            return;
        }
        QUIButton qUIButton2 = this.btnConfirm;
        if (qUIButton2 != null) {
            qUIButton2.setText(getString(R.string.f172912rq));
        }
    }

    private final void wh() {
        ArrayList arrayList = new ArrayList();
        for (RecSingleItem recSingleItem : this.checkedRecSingleItemList) {
            SubmitPromotePage$SubmitResultItem submitPromotePage$SubmitResultItem = new SubmitPromotePage$SubmitResultItem();
            submitPromotePage$SubmitResultItem.type.set(recSingleItem.getType());
            submitPromotePage$SubmitResultItem.item_id.set(recSingleItem.getId());
            submitPromotePage$SubmitResultItem.result.set(1);
            arrayList.add(submitPromotePage$SubmitResultItem);
        }
        f.x(arrayList);
        getQBaseActivity().setResult(-1);
        getQBaseActivity().finish();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        getQBaseActivity().setResult(0);
        getQBaseActivity().finish();
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (v3 != null) {
            num = Integer.valueOf(v3.getId());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == R.id.a47) {
            onBackEvent();
        } else if (num != null && num.intValue() == R.id.agd) {
            wh();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        List<OpenSdkRecCommon$PromoteGroupView> list;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        List<OpenSdkRecCommon$PromoteGroupView> p16 = f.f394643a.p();
        ViewGroup viewGroup = null;
        if (p16 != null) {
            list = CollectionsKt___CollectionsKt.toList(p16);
        } else {
            list = null;
        }
        this.groups = list;
        if (list == null) {
            getQBaseActivity().setResult(-1);
            getQBaseActivity().finish();
            t.f("RecommendFragment", "groups is null");
        } else {
            View inflate = inflater.inflate(R.layout.fqt, container, false);
            Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
            this.rootView = (ViewGroup) inflate;
            initViews();
            ViewGroup viewGroup2 = this.rootView;
            if (viewGroup2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            } else {
                viewGroup = viewGroup2;
            }
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, viewGroup);
        return viewGroup;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        g.Y(getQBaseActivity());
    }
}
