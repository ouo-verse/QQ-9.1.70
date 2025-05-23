package com.tencent.state.library.focus.component;

import android.view.View;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.state.VasBaseFragment;
import com.tencent.state.VasBaseFragmentComponent;
import com.tencent.state.library.focus.FocusBaseFragment;
import com.tencent.state.library.focus.FocusDialogTips;
import com.tencent.state.library.focus.data.FocusBaseItem;
import com.tencent.state.library.focus.data.FocusItem;
import com.tencent.state.library.focus.view.ClickType;
import com.tencent.state.template.data.User;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020 H\u0016J\u001a\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u001b2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000bX\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000f8DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006%"}, d2 = {"Lcom/tencent/state/library/focus/component/FocusBaseComponent;", "Lcom/tencent/state/VasBaseFragmentComponent;", "Lcom/tencent/state/library/focus/component/IFocusEventListener;", "()V", "data", "Lcom/tencent/state/library/focus/data/FocusBaseItem;", "getData", "()Lcom/tencent/state/library/focus/data/FocusBaseItem;", "setData", "(Lcom/tencent/state/library/focus/data/FocusBaseItem;)V", "focusDialog", "Lcom/tencent/state/library/focus/FocusDialogTips;", "getFocusDialog", "()Lcom/tencent/state/library/focus/FocusDialogTips;", "focusFragment", "Lcom/tencent/state/library/focus/FocusBaseFragment;", "getFocusFragment", "()Lcom/tencent/state/library/focus/FocusBaseFragment;", "onChatBoxClicked", "", "v", "Landroid/view/View;", "onComeOnButtonClicked", QCircleAlphaUserReporter.KEY_USER, "Lcom/tencent/state/template/data/User;", "onEmptyTableClicked", "type", "", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/state/library/focus/data/FocusItem;", "onEnterFocus", "onFuncButtonClicked", "Lcom/tencent/state/library/focus/view/ClickType;", "onViewClick", "viewId", "extra", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public abstract class FocusBaseComponent extends VasBaseFragmentComponent implements IFocusEventListener {
    private FocusBaseItem data;
    private final FocusDialogTips focusDialog = FocusDialogTips.INSTANCE;

    /* JADX INFO: Access modifiers changed from: protected */
    public final FocusBaseItem getData() {
        return this.data;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final FocusDialogTips getFocusDialog() {
        return this.focusDialog;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final FocusBaseFragment getFocusFragment() {
        VasBaseFragment fragment = getFragment();
        if (!(fragment instanceof FocusBaseFragment)) {
            fragment = null;
        }
        return (FocusBaseFragment) fragment;
    }

    @Override // com.tencent.state.library.focus.component.IFocusEventListener
    public void onChatBoxClicked(View v3) {
        Intrinsics.checkNotNullParameter(v3, "v");
    }

    @Override // com.tencent.state.library.focus.component.IFocusEventListener
    public void onComeOnButtonClicked(User user) {
        Intrinsics.checkNotNullParameter(user, "user");
    }

    @Override // com.tencent.state.library.focus.component.IFocusEventListener
    public void onEmptyTableClicked(int type, FocusItem item) {
        Intrinsics.checkNotNullParameter(item, "item");
    }

    @Override // com.tencent.state.library.focus.component.IFocusEventListener
    public void onEnterFocus(FocusBaseItem data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
    }

    @Override // com.tencent.state.library.focus.component.IFocusEventListener
    public void onFuncButtonClicked(ClickType type) {
        Intrinsics.checkNotNullParameter(type, "type");
    }

    protected final void setData(FocusBaseItem focusBaseItem) {
        this.data = focusBaseItem;
    }

    @Override // com.tencent.state.library.focus.component.IFocusEventListener
    public void onViewClick(int viewId, Object extra) {
    }
}
