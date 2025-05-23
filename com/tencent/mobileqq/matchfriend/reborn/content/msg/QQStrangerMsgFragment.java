package com.tencent.mobileqq.matchfriend.reborn.content.msg;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.part.QQStrangerMsgSubFragmentPart;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.part.b;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.part.i;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.top.QQStrangerMsgMatchChatPart;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.top.QQStrangerMsgPublicAccountNoticePart;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.top.QQStrangerMsgTopPart;
import com.tencent.mobileqq.matchfriend.reborn.titlebar.QQStrangerOnPageBackEvent;
import com.tencent.mobileqq.quibadge.QUIBadgeDragLayout;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0016J$\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016R#\u0010\u0016\u001a\n \u0011*\u0004\u0018\u00010\u00100\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/QQStrangerMsgFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", "useArgusLifecycle", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "onBackEvent", "Lcom/tencent/mobileqq/quibadge/QUIBadgeDragLayout;", "kotlin.jvm.PlatformType", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "ph", "()Lcom/tencent/mobileqq/quibadge/QUIBadgeDragLayout;", "mDragHost", "<init>", "()V", "D", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerMsgFragment extends QPublicBaseFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private final Lazy mDragHost;

    public QQStrangerMsgFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QUIBadgeDragLayout>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.QQStrangerMsgFragment$mDragHost$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final QUIBadgeDragLayout invoke() {
                return (QUIBadgeDragLayout) QQStrangerMsgFragment.this.requireActivity().findViewById(R.id.oni);
            }
        });
        this.mDragHost = lazy;
    }

    private final QUIBadgeDragLayout ph() {
        return (QUIBadgeDragLayout) this.mDragHost.getValue();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new b());
        QUIBadgeDragLayout mDragHost = ph();
        Intrinsics.checkNotNullExpressionValue(mDragHost, "mDragHost");
        arrayList.add(new i(mDragHost));
        arrayList.add(new QQStrangerMsgPublicAccountNoticePart());
        arrayList.add(new QQStrangerMsgTopPart());
        arrayList.add(new QQStrangerMsgMatchChatPart());
        arrayList.add(new QQStrangerMsgSubFragmentPart());
        arrayList.add(new p82.a());
        return arrayList;
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
        View inflate = LayoutInflater.from(getQBaseActivity()).inflate(R.layout.cxm, container, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(qBaseActivity)\n    \u2026layout, container, false)");
        return inflate;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public boolean useArgusLifecycle() {
        return true;
    }
}
