package com.tencent.state.library.focus.component;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.state.ViewExtensionsKt;
import com.tencent.state.library.focus.FocusBaseFragment;
import com.tencent.state.library.focus.IFocusParentView;
import com.tencent.state.library.focus.data.FocusBaseItem;
import com.tencent.state.library.focus.data.FocusDataKt;
import com.tencent.state.library.focus.data.FocusItem;
import com.tencent.state.library.focus.view.FocusCommonView;
import com.tencent.state.library.focus.view.LibraryFocusTimeBubble;
import com.tencent.state.service.VasFocusLikeService;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.databinding.VasSquareLibraryBubbleBinding;
import com.tencent.state.square.databinding.VasSquareLibraryCommonViewBinding;
import com.tencent.state.square.databinding.VasSquareLibrarySingleBubbleBinding;
import com.tencent.state.template.data.User;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import os4.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J,\u0010\u0012\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0006\u0010\u0016\u001a\u00020\u0006R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001a8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/state/library/focus/component/FocusLikeReddotComponent;", "Lcom/tencent/state/library/focus/component/FocusBaseComponent;", "", "isShowRedDot", "", "redText", "", "initRedDotView", "Landroid/widget/TextView;", "getRedDotTextView", "Landroidx/fragment/app/FragmentManager;", "fm", "Landroidx/fragment/app/Fragment;", "f", "Landroid/view/View;", "v", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onFragmentViewCreated", "Lcom/tencent/state/template/data/User;", QCircleAlphaUserReporter.KEY_USER, "onComeOnButtonClicked", "updateRedDotView", "Los4/b;", "lastRedDot", "Los4/b;", "Lcom/tencent/state/library/focus/view/LibraryFocusTimeBubble;", "getBubbleView", "()Lcom/tencent/state/library/focus/view/LibraryFocusTimeBubble;", "bubbleView", "<init>", "()V", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class FocusLikeReddotComponent extends FocusBaseComponent {
    private b lastRedDot;

    private final LibraryFocusTimeBubble getBubbleView() {
        IFocusParentView fragmentView;
        FocusCommonView commonView;
        VasSquareLibraryCommonViewBinding binding;
        FocusBaseFragment focusFragment = getFocusFragment();
        if (focusFragment == null || (fragmentView = focusFragment.getFragmentView()) == null || (commonView = fragmentView.getCommonView()) == null || (binding = commonView.getBinding()) == null) {
            return null;
        }
        return binding.focusTimeBubble;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView getRedDotTextView() {
        FocusItem rightItem;
        User user;
        LibraryFocusTimeBubble bubbleView;
        VasSquareLibraryBubbleBinding binding;
        VasSquareLibrarySingleBubbleBinding vasSquareLibrarySingleBubbleBinding;
        FocusItem item;
        User user2;
        VasSquareLibraryBubbleBinding binding2;
        VasSquareLibrarySingleBubbleBinding vasSquareLibrarySingleBubbleBinding2;
        VasSquareLibraryBubbleBinding binding3;
        FocusBaseItem data = getData();
        if (data != null && data.isSingleUser()) {
            LibraryFocusTimeBubble bubbleView2 = getBubbleView();
            if (bubbleView2 == null || (binding3 = bubbleView2.getBinding()) == null) {
                return null;
            }
            return binding3.likeReddot;
        }
        FocusBaseItem data2 = getData();
        if (data2 != null && (item = data2.getItem()) != null && (user2 = item.getUser()) != null && user2.isMe()) {
            LibraryFocusTimeBubble bubbleView3 = getBubbleView();
            if (bubbleView3 == null || (binding2 = bubbleView3.getBinding()) == null || (vasSquareLibrarySingleBubbleBinding2 = binding2.leftBubble) == null) {
                return null;
            }
            return vasSquareLibrarySingleBubbleBinding2.likeReddot;
        }
        FocusBaseItem data3 = getData();
        if (data3 == null || (rightItem = data3.getRightItem()) == null || (user = rightItem.getUser()) == null || !user.isMe() || (bubbleView = getBubbleView()) == null || (binding = bubbleView.getBinding()) == null || (vasSquareLibrarySingleBubbleBinding = binding.rightBubble) == null) {
            return null;
        }
        return vasSquareLibrarySingleBubbleBinding.likeReddot;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initRedDotView(boolean isShowRedDot, String redText) {
        TextView redDotTextView = getRedDotTextView();
        if (redDotTextView != null) {
            ViewExtensionsKt.setVisibility(redDotTextView, isShowRedDot);
            redDotTextView.setText(redText);
            if (isShowRedDot) {
                SquareBaseKt.getSquareReporter().setElementInfo(redDotTextView, "em_zplan_refueling_button_red_dot", new LinkedHashMap(), false, false);
                SquareBaseKt.getSquareReporter().reportEvent("imp", redDotTextView, new LinkedHashMap());
            }
        }
    }

    @Override // com.tencent.state.library.focus.component.FocusBaseComponent, com.tencent.state.library.focus.component.IFocusEventListener
    public void onComeOnButtonClicked(User user) {
        Intrinsics.checkNotNullParameter(user, "user");
        b bVar = this.lastRedDot;
        if (!user.isMe() || bVar == null) {
            return;
        }
        this.lastRedDot = null;
        VasFocusLikeService.INSTANCE.doLikeRedDotClick(bVar.f423981b, new Function1<Boolean, Unit>() { // from class: com.tencent.state.library.focus.component.FocusLikeReddotComponent$onComeOnButtonClicked$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:2:0x0002, code lost:
            
                r2 = r1.this$0.getRedDotTextView();
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke(boolean z16) {
                TextView redDotTextView;
                if (!z16 || redDotTextView == null) {
                    return;
                }
                ViewExtensionsKt.setVisibility(redDotTextView, false);
            }
        });
    }

    @Override // com.tencent.state.VasBaseFragmentComponent, com.tencent.state.FragmentComponent
    public void onFragmentViewCreated(FragmentManager fm5, Fragment f16, View v3, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(f16, "f");
        Intrinsics.checkNotNullParameter(v3, "v");
        updateRedDotView();
    }

    public final void updateRedDotView() {
        FocusBaseItem data = getData();
        if (data == null || !FocusDataKt.hasMe(data)) {
            return;
        }
        VasFocusLikeService.INSTANCE.getUnreadLikeNumber(new Function1<b, Unit>() { // from class: com.tencent.state.library.focus.component.FocusLikeReddotComponent$updateRedDotView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(b bVar) {
                invoke2(bVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(b redDot) {
                String str;
                Intrinsics.checkNotNullParameter(redDot, "redDot");
                FocusLikeReddotComponent.this.lastRedDot = redDot;
                long j3 = redDot.f423980a;
                FocusLikeReddotComponent focusLikeReddotComponent = FocusLikeReddotComponent.this;
                boolean z16 = j3 > 0;
                long j16 = 99;
                if (1 <= j3 && j16 >= j3) {
                    str = String.valueOf(j3);
                } else {
                    str = j3 > j16 ? "99+" : "";
                }
                focusLikeReddotComponent.initRedDotView(z16, str);
            }
        });
    }
}
