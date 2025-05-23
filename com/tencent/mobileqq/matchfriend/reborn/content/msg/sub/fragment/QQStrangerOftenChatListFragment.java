package com.tencent.mobileqq.matchfriend.reborn.content.msg.sub.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.nt.u;
import com.tencent.mobileqq.quibadge.QUIBadgeDragLayout;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqnt.biz.lightbusiness.lightinteraction.view.LIAAnimView;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ&\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016R\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0017\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001c\u001a\u00020\u00188BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/sub/fragment/QQStrangerOftenChatListFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/nt/u;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/nt/u;", "mChatListHelper", "Lcom/tencent/mobileqq/quibadge/QUIBadgeDragLayout;", "D", "Lkotlin/Lazy;", "ph", "()Lcom/tencent/mobileqq/quibadge/QUIBadgeDragLayout;", "mDragHost", "Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/view/LIAAnimView;", "E", "qh", "()Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/view/LIAAnimView;", "mLightInterActionView", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerOftenChatListFragment extends QPublicBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private u mChatListHelper;

    /* renamed from: D, reason: from kotlin metadata */
    private final Lazy mDragHost;

    /* renamed from: E, reason: from kotlin metadata */
    private final Lazy mLightInterActionView;

    public QQStrangerOftenChatListFragment() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QUIBadgeDragLayout>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.sub.fragment.QQStrangerOftenChatListFragment$mDragHost$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final QUIBadgeDragLayout invoke() {
                return (QUIBadgeDragLayout) QQStrangerOftenChatListFragment.this.requireActivity().findViewById(R.id.oni);
            }
        });
        this.mDragHost = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<LIAAnimView>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.sub.fragment.QQStrangerOftenChatListFragment$mLightInterActionView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LIAAnimView invoke() {
                return (LIAAnimView) QQStrangerOftenChatListFragment.this.requireActivity().findViewById(R.id.oj8);
            }
        });
        this.mLightInterActionView = lazy2;
    }

    private final QUIBadgeDragLayout ph() {
        Object value = this.mDragHost.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mDragHost>(...)");
        return (QUIBadgeDragLayout) value;
    }

    private final LIAAnimView qh() {
        Object value = this.mLightInterActionView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mLightInterActionView>(...)");
        return (LIAAnimView) value;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View rootView = LayoutInflater.from(getQBaseActivity()).inflate(R.layout.cxn, container, false);
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        u uVar = new u(requireContext);
        this.mChatListHelper = uVar;
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        uVar.b(rootView, ph(), qh());
        return rootView;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        u uVar = this.mChatListHelper;
        if (uVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatListHelper");
            uVar = null;
        }
        uVar.c();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        u uVar = this.mChatListHelper;
        if (uVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatListHelper");
            uVar = null;
        }
        uVar.d();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        u uVar = this.mChatListHelper;
        if (uVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatListHelper");
            uVar = null;
        }
        uVar.e();
    }
}
