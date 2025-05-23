package com.tencent.mobileqq.aio.msglist;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.recyclerview.widget.AIORecycleView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.aio.base.mvi.part.MsgListUiState;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msg.MsgSimpleInfo;
import com.tencent.mobileqq.aio.msglist.AIOMsgListMviIntent;
import com.tencent.mobileqq.aio.msglist.holder.AIOBubbleMsgItemVB;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a>\u0010\u000b\u001a\u00020\n*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u001a(\u0010\u0012\u001a\u00020\b*\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u0010\u001a\u001e\u0010\u0014\u001a\u00020\u0013*\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/core/c;", "Landroidx/recyclerview/widget/AIORecycleView;", "recyclerView", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "flushMsgItem", "", "bias", "Lkotlin/Function0;", "", "notifyUnreadCallback", "", "a", "Lat/b;", "Lcom/tencent/aio/base/mvi/part/MsgListUiState;", "Landroid/os/Bundle;", "bundle", "", "tag", "d", "Landroid/view/View$AccessibilityDelegate;", "c", "aio_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class aa {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/aio/msglist/aa$a", "Landroid/view/View$AccessibilityDelegate;", "Landroid/view/View;", "host", "Landroid/view/accessibility/AccessibilityNodeInfo;", "info", "", "onInitializeAccessibilityNodeInfo", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class a extends View.AccessibilityDelegate {
        static IPatchRedirector $redirector_;

        /* renamed from: a */
        final /* synthetic */ AIORecycleView f190446a;

        a(AIORecycleView aIORecycleView) {
            this.f190446a = aIORecycleView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) aIORecycleView);
            }
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(@Nullable View host, @Nullable AccessibilityNodeInfo info) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) host, (Object) info);
                return;
            }
            super.onInitializeAccessibilityNodeInfo(host, info);
            if (info != null) {
                info.setTraversalBefore(this.f190446a);
            }
        }
    }

    public static final boolean a(@NotNull com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.c<?, ?> cVar, @NotNull AIORecycleView recyclerView, @NotNull AIOMsgItem flushMsgItem, int i3, @Nullable Function0<Unit> function0) {
        com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.holder.a aVar;
        com.tencent.mvi.mvvm.b bVar;
        AIOMsgItem p16;
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(flushMsgItem, "flushMsgItem");
        int findFirstVisibleItemPosition = recyclerView.getLayoutManager().findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = recyclerView.getLayoutManager().findLastVisibleItemPosition();
        if (findFirstVisibleItemPosition <= findLastVisibleItemPosition) {
            while (true) {
                RecyclerView.ViewHolder findViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(findFirstVisibleItemPosition);
                AIOBubbleMsgItemVB aIOBubbleMsgItemVB = null;
                if (findViewHolderForAdapterPosition instanceof com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.holder.a) {
                    aVar = (com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.holder.a) findViewHolderForAdapterPosition;
                } else {
                    aVar = null;
                }
                if (aVar != null) {
                    bVar = aVar.m();
                } else {
                    bVar = null;
                }
                if (bVar instanceof AIOBubbleMsgItemVB) {
                    aIOBubbleMsgItemVB = (AIOBubbleMsgItemVB) bVar;
                }
                if (aIOBubbleMsgItemVB != null && (p16 = aIOBubbleMsgItemVB.p1()) != null && p16.getMsgId() > 0 && flushMsgItem.getMsgId() > 0 && p16.getMsgId() == flushMsgItem.getMsgId()) {
                    int[] iArr = new int[2];
                    aIOBubbleMsgItemVB.q1().getLocationOnScreen(iArr);
                    int i16 = iArr[1];
                    if (i16 >= i3) {
                        return true;
                    }
                    if (i16 + aIOBubbleMsgItemVB.q1().getMeasuredHeight() < i3 && function0 != null) {
                        function0.invoke();
                    }
                    QLog.i("AIOMsgItem", 1, "[checkFlushMsgInScreen]: item above title");
                    return false;
                }
                if (findFirstVisibleItemPosition == findLastVisibleItemPosition) {
                    break;
                }
                findFirstVisibleItemPosition++;
            }
        }
        if (function0 != null) {
            function0.invoke();
        }
        return false;
    }

    public static /* synthetic */ boolean b(com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.c cVar, AIORecycleView aIORecycleView, AIOMsgItem aIOMsgItem, int i3, Function0 function0, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            i3 = 0;
        }
        if ((i16 & 8) != 0) {
            function0 = null;
        }
        return a(cVar, aIORecycleView, aIOMsgItem, i3, function0);
    }

    @NotNull
    public static final View.AccessibilityDelegate c(@NotNull com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.c<at.b, MsgListUiState> cVar, @NotNull AIORecycleView recyclerView) {
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        return new a(recyclerView);
    }

    public static final void d(@NotNull com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.core.c<at.b, MsgListUiState> cVar, @Nullable Bundle bundle, @NotNull String tag) {
        MsgSimpleInfo msgSimpleInfo;
        Intrinsics.checkNotNullParameter(cVar, "<this>");
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (bundle != null && (msgSimpleInfo = (MsgSimpleInfo) bundle.getParcelable("reply_msg_info")) != null) {
            cVar.sendIntent(new AIOMsgListMviIntent.q(msgSimpleInfo));
        }
    }
}
