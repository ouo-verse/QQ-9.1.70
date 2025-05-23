package com.tencent.mobileqq.matchfriend.reborn.content.msg.sub.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendChatApi;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.nt.h;
import com.tencent.mobileqq.matchfriend.reborn.titlebar.QQStrangerOnPageBackEvent;
import com.tencent.mobileqq.matchfriend.utils.d;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.quibadge.QUIBadgeDragLayout;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqnt.biz.lightbusiness.lightinteraction.view.LIAAnimView;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0002J$\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001b\u0010\u001a\u001a\u00020\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001f\u001a\u00020\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/sub/fragment/QQStrangerMsgListFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", "rh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "", "onBackEvent", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/nt/h;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/nt/h;", "mChatListHelper", "Lcom/tencent/mobileqq/quibadge/QUIBadgeDragLayout;", "D", "Lkotlin/Lazy;", "ph", "()Lcom/tencent/mobileqq/quibadge/QUIBadgeDragLayout;", "mDragHost", "Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/view/LIAAnimView;", "E", "qh", "()Lcom/tencent/qqnt/biz/lightbusiness/lightinteraction/view/LIAAnimView;", "mLightInterActionView", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerMsgListFragment extends QPublicBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private h mChatListHelper;

    /* renamed from: D, reason: from kotlin metadata */
    private final Lazy mDragHost;

    /* renamed from: E, reason: from kotlin metadata */
    private final Lazy mLightInterActionView;

    public QQStrangerMsgListFragment() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QUIBadgeDragLayout>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.sub.fragment.QQStrangerMsgListFragment$mDragHost$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final QUIBadgeDragLayout invoke() {
                return (QUIBadgeDragLayout) QQStrangerMsgListFragment.this.requireActivity().findViewById(R.id.oni);
            }
        });
        this.mDragHost = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<LIAAnimView>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.sub.fragment.QQStrangerMsgListFragment$mLightInterActionView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LIAAnimView invoke() {
                return (LIAAnimView) QQStrangerMsgListFragment.this.requireActivity().findViewById(R.id.oj8);
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

    private final void rh() {
        d dVar = new d(getActivity());
        HashMap hashMap = new HashMap();
        hashMap.put("kl_new_from_openid", ((IMatchFriendChatApi) QRoute.api(IMatchFriendChatApi.class)).getSelfOpenId());
        dVar.c("pg_kl_new_chat_list", hashMap);
        ArrayList arrayList = new ArrayList();
        arrayList.add("em_kl_config");
        dVar.b(arrayList);
        dVar.f("em_kl_config");
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        if (getPartManager() != null) {
            getPartManager().onBackEvent();
        }
        SimpleEventBus.getInstance().dispatchEvent(new QQStrangerOnPageBackEvent());
        return true;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View rootView = LayoutInflater.from(getQBaseActivity()).inflate(R.layout.cxn, container, false);
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        h hVar = new h(requireContext);
        this.mChatListHelper = hVar;
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        hVar.b(rootView, ph(), qh());
        rh();
        return rootView;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        h hVar = this.mChatListHelper;
        if (hVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatListHelper");
            hVar = null;
        }
        hVar.c();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        h hVar = this.mChatListHelper;
        if (hVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatListHelper");
            hVar = null;
        }
        hVar.d();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        h hVar = this.mChatListHelper;
        if (hVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mChatListHelper");
            hVar = null;
        }
        hVar.e();
    }
}
