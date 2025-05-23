package com.tencent.mobileqq.guild.feed.nativedetail.content.feedcomment.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewGroupKt;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.base.extension.d;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import ml1.a;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 <2\u00020\u00012\u00020\u0002:\u0001=B\u0007\u00a2\u0006\u0004\b:\u0010;J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0012\u0010\u0010\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u0011\u001a\u00020\rH\u0016R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0018R\u0016\u0010\u001f\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0018R$\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020!\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010*R\u0016\u0010/\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010*R\u0016\u00101\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u0010*R\u0016\u00103\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u0010*R\u0016\u00105\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u0010*R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108\u00a8\u0006>"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedcomment/fragment/CommentItemOptionFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Landroid/view/View$OnClickListener;", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/app/Dialog;", "onCreateDialog", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "", "onStart", "v", NodeProps.ON_CLICK, "onResume", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "contentStr", "", "D", "Z", "showDeleteItem", "E", "showTopItem", UserInfo.SEX_FEMALE, "showUnTopItem", "G", "showReportItem", "Lkotlin/Pair;", "Lcom/tencent/qqlive/module/videoreport/PageParams;", "H", "Lkotlin/Pair;", "pageInfo", "I", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/widget/LinearLayout;", "J", "Landroid/widget/LinearLayout;", "copyContainer", "K", "replyContainer", "L", "deleteContainer", "M", "reportContainer", "N", "topContainer", "P", "unTopContainer", "Lml1/a;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lml1/a;", "callback", "<init>", "()V", BdhLogUtil.LogTag.Tag_Req, "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class CommentItemOptionFragment extends BottomSheetDialogFragment implements View.OnClickListener {

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private String contentStr = "";

    /* renamed from: D, reason: from kotlin metadata */
    private boolean showDeleteItem;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean showTopItem;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean showUnTopItem;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean showReportItem;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private Pair<String, ? extends PageParams> pageInfo;

    /* renamed from: I, reason: from kotlin metadata */
    private View rootView;

    /* renamed from: J, reason: from kotlin metadata */
    private LinearLayout copyContainer;

    /* renamed from: K, reason: from kotlin metadata */
    private LinearLayout replyContainer;

    /* renamed from: L, reason: from kotlin metadata */
    private LinearLayout deleteContainer;

    /* renamed from: M, reason: from kotlin metadata */
    private LinearLayout reportContainer;

    /* renamed from: N, reason: from kotlin metadata */
    private LinearLayout topContainer;

    /* renamed from: P, reason: from kotlin metadata */
    private LinearLayout unTopContainer;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private a callback;

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJL\u0010\u0010\u001a\u00020\u000f2\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rR\u0014\u0010\u0012\u001a\u00020\u00118\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00118\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00118\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00118\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00118\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00118\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0013R\u0014\u0010\u0019\u001a\u00020\u00038\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedcomment/fragment/CommentItemOptionFragment$a;", "", "Lkotlin/Pair;", "", "Lcom/tencent/qqlive/module/videoreport/PageParams;", "pageInfo", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "showTop", "showUnTop", "showDelete", "showReport", "Lml1/a;", "optionCallback", "", "a", "", "OPTION_TYPE_COPY", "I", "OPTION_TYPE_DELETE", "OPTION_TYPE_REPLY", "OPTION_TYPE_REPORT", "OPTION_TYPE_TOP", "OPTION_TYPE_UNTOP", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.nativedetail.content.feedcomment.fragment.CommentItemOptionFragment$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Pair<String, ? extends PageParams> pageInfo, @NotNull FragmentManager fragmentManager, boolean showTop, boolean showUnTop, boolean showDelete, boolean showReport, @Nullable a optionCallback) {
            Intrinsics.checkNotNullParameter(pageInfo, "pageInfo");
            Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
            CommentItemOptionFragment commentItemOptionFragment = new CommentItemOptionFragment();
            commentItemOptionFragment.callback = optionCallback;
            commentItemOptionFragment.showDeleteItem = showDelete;
            commentItemOptionFragment.showTopItem = showTop;
            commentItemOptionFragment.showUnTopItem = showUnTop;
            commentItemOptionFragment.showReportItem = showReport;
            commentItemOptionFragment.pageInfo = pageInfo;
            d.a(commentItemOptionFragment, fragmentManager, "CommentItemOptionFragment");
        }

        Companion() {
        }
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
        if (num != null && num.intValue() == R.id.u1r) {
            a aVar = this.callback;
            if (aVar != null) {
                aVar.a(3);
            }
            dismiss();
        } else if (num != null && num.intValue() == R.id.u1x) {
            a aVar2 = this.callback;
            if (aVar2 != null) {
                aVar2.a(1);
            }
            dismiss();
        } else if (num != null && num.intValue() == R.id.u1u) {
            a aVar3 = this.callback;
            if (aVar3 != null) {
                aVar3.a(0);
            }
            dismiss();
        } else if (num != null && num.intValue() == R.id.u1y) {
            a aVar4 = this.callback;
            if (aVar4 != null) {
                aVar4.a(2);
            }
            dismiss();
        } else if (num != null && num.intValue() == R.id.f164855u21) {
            a aVar5 = this.callback;
            if (aVar5 != null) {
                aVar5.a(4);
            }
            dismiss();
        } else if (num != null && num.intValue() == R.id.u1q) {
            a aVar6 = this.callback;
            if (aVar6 != null) {
                aVar6.a(5);
            }
            dismiss();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Dialog onCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.checkNotNull(onCreateDialog, "null cannot be cast to non-null type com.google.android.material.bottomsheet.BottomSheetDialog");
        com.google.android.material.bottomsheet.a aVar = (com.google.android.material.bottomsheet.a) onCreateDialog;
        Window window = aVar.getWindow();
        Intrinsics.checkNotNull(window);
        window.getAttributes().windowAnimations = R.style.f174032aw0;
        Window window2 = aVar.getWindow();
        Intrinsics.checkNotNull(window2);
        window2.setBackgroundDrawable(null);
        return aVar;
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        List<LinearLayout> listOf;
        int i3;
        int i16;
        int i17;
        Sequence filter;
        Object firstOrNull;
        CharSequence charSequence;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.epm, container);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou\u2026option_layout, container)");
        this.rootView = inflate;
        View view = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            inflate = null;
        }
        View findViewById = inflate.findViewById(R.id.f164855u21);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026_option_sticky_container)");
        this.topContainer = (LinearLayout) findViewById;
        View view2 = this.rootView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view2 = null;
        }
        View findViewById2 = view2.findViewById(R.id.u1q);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026_cancel_sticky_container)");
        this.unTopContainer = (LinearLayout) findViewById2;
        View view3 = this.rootView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view3 = null;
        }
        View findViewById3 = view3.findViewById(R.id.u1r);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026em_option_copy_container)");
        this.copyContainer = (LinearLayout) findViewById3;
        View view4 = this.rootView;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view4 = null;
        }
        View findViewById4 = view4.findViewById(R.id.u1x);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.\u2026m_option_reply_container)");
        this.replyContainer = (LinearLayout) findViewById4;
        View view5 = this.rootView;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view5 = null;
        }
        View findViewById5 = view5.findViewById(R.id.u1u);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.\u2026_option_delete_container)");
        this.deleteContainer = (LinearLayout) findViewById5;
        View view6 = this.rootView;
        if (view6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view6 = null;
        }
        View findViewById6 = view6.findViewById(R.id.u1y);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "rootView.findViewById(R.\u2026_option_report_container)");
        this.reportContainer = (LinearLayout) findViewById6;
        LinearLayout[] linearLayoutArr = new LinearLayout[6];
        LinearLayout linearLayout = this.topContainer;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topContainer");
            linearLayout = null;
        }
        int i18 = 0;
        linearLayoutArr[0] = linearLayout;
        LinearLayout linearLayout2 = this.unTopContainer;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("unTopContainer");
            linearLayout2 = null;
        }
        linearLayoutArr[1] = linearLayout2;
        LinearLayout linearLayout3 = this.copyContainer;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("copyContainer");
            linearLayout3 = null;
        }
        linearLayoutArr[2] = linearLayout3;
        LinearLayout linearLayout4 = this.replyContainer;
        if (linearLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("replyContainer");
            linearLayout4 = null;
        }
        linearLayoutArr[3] = linearLayout4;
        LinearLayout linearLayout5 = this.deleteContainer;
        if (linearLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deleteContainer");
            linearLayout5 = null;
        }
        linearLayoutArr[4] = linearLayout5;
        LinearLayout linearLayout6 = this.reportContainer;
        if (linearLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reportContainer");
            linearLayout6 = null;
        }
        linearLayoutArr[5] = linearLayout6;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) linearLayoutArr);
        for (LinearLayout linearLayout7 : listOf) {
            linearLayout7.setOnClickListener(this);
            VideoReport.setElementId(linearLayout7, "em_sgrp_operate");
            VideoReport.setElementExposePolicy(linearLayout7, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementClickPolicy(linearLayout7, ClickPolicy.REPORT_ALL);
            filter = SequencesKt___SequencesKt.filter(ViewGroupKt.getChildren(linearLayout7), new Function1<Object, Boolean>() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.feedcomment.fragment.CommentItemOptionFragment$onCreateView$lambda$0$$inlined$filterIsInstance$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@Nullable Object obj) {
                    return Boolean.valueOf(obj instanceof TextView);
                }
            });
            Intrinsics.checkNotNull(filter, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>");
            firstOrNull = SequencesKt___SequencesKt.firstOrNull(filter);
            TextView textView = (TextView) firstOrNull;
            if (textView != null) {
                charSequence = textView.getText();
            } else {
                charSequence = null;
            }
            VideoReport.setElementParam(linearLayout7, "sgrp_btn_name", String.valueOf(charSequence));
        }
        LinearLayout linearLayout8 = this.topContainer;
        if (linearLayout8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topContainer");
            linearLayout8 = null;
        }
        if (this.showTopItem) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        linearLayout8.setVisibility(i3);
        LinearLayout linearLayout9 = this.unTopContainer;
        if (linearLayout9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("unTopContainer");
            linearLayout9 = null;
        }
        if (this.showUnTopItem) {
            i16 = 0;
        } else {
            i16 = 8;
        }
        linearLayout9.setVisibility(i16);
        LinearLayout linearLayout10 = this.deleteContainer;
        if (linearLayout10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deleteContainer");
            linearLayout10 = null;
        }
        if (this.showDeleteItem) {
            i17 = 0;
        } else {
            i17 = 8;
        }
        linearLayout10.setVisibility(i17);
        LinearLayout linearLayout11 = this.reportContainer;
        if (linearLayout11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reportContainer");
            linearLayout11 = null;
        }
        if (!this.showReportItem) {
            i18 = 8;
        }
        linearLayout11.setVisibility(i18);
        View view7 = this.rootView;
        if (view7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
        } else {
            view = view7;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Pair<String, ? extends PageParams> pair = this.pageInfo;
        if (pair == null) {
            return;
        }
        VideoReport.addToDetectionWhitelist(getActivity());
        View view = this.rootView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        VideoReport.setPageId(view, pair.getFirst());
        View view3 = this.rootView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
        } else {
            view2 = view3;
        }
        VideoReport.setPageParams(view2, pair.getSecond());
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        View view = this.rootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        ((ViewGroup) view.getRootView().findViewById(tp1.a.b())).setBackgroundResource(17170445);
    }
}
