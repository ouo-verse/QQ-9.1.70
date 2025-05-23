package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory;
import com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0013\b\u0016\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u00a2\u0006\u0004\b\u0011\u0010\u0012B\u001d\b\u0016\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u00a2\u0006\u0004\b\u0011\u0010\u0015B%\b\u0016\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0011\u0010\u0017J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0014J\b\u0010\n\u001a\u00020\u0005H\u0014J\u001a\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/biz/qqcircle/widgets/QFSAdFollowView;", "Lcom/tencent/biz/qqcircle/widgets/QFSFollowView;", "Lcom/tencent/biz/richframework/animation/drawable/AnimationDrawableFactory$CreateResultListener;", "", "O", "", HippyTKDListViewAdapter.X, "", "showAnimation", "D", "E", "isSuccess", "Lcom/tencent/biz/richframework/animation/drawable/QQAnimationDrawable;", "animationDrawable", "onCreateResult", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class QFSAdFollowView extends QFSFollowView implements AnimationDrawableFactory.CreateResultListener {
    public QFSAdFollowView(@Nullable Context context) {
        super(context);
    }

    private final int O() {
        return R.drawable.f162040oo0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView
    public void D(boolean showAnimation) {
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView
    public void E() {
        setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QFSFollowView
    public void x() {
        super.x();
        setVisibility(0);
        setBackgroundDrawable(getResources().getDrawable(O()));
        setClickable(true);
    }

    public QFSAdFollowView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public QFSAdFollowView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }

    @Override // com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory.CreateResultListener
    public void onCreateResult(boolean isSuccess, @Nullable QQAnimationDrawable animationDrawable) {
    }
}
