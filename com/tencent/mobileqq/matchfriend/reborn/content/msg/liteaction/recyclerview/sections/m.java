package com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction.recyclerview.sections;

import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction.QQStrangerLiteActionModel;
import com.tencent.mobileqq.matchfriend.reborn.utils.p;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J*\u0010\r\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0014J\b\u0010\u000f\u001a\u00020\u000eH\u0014R\u0016\u0010\u0012\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0011\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/liteaction/recyclerview/sections/m;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/liteaction/recyclerview/sections/a;", "Landroid/view/View;", "mRootView", "", "onInitView", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/liteaction/l;", "inputData", "", "position", "", "", "payload", "u", "", "getViewStubLayoutId", "f", "Landroid/view/View;", "avatarView", "Landroid/widget/TextView;", tl.h.F, "Landroid/widget/TextView;", "nickView", "i", "dividerBarView", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class m extends a {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View avatarView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView nickView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private View dividerBarView;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(View view, m this$0, View view2) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.matchfriend.reborn.utils.l.g(view.getContext(), this$0.getData().getUserId(), 9, 8, null, 16, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public void onBindData(QQStrangerLiteActionModel inputData, int position, List<Object> payload) {
        s(position);
        if (inputData == null) {
            return;
        }
        r(inputData);
        Resources resources = this.mRootView.getResources();
        if (resources == null) {
            return;
        }
        View view = this.avatarView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avatarView");
            view = null;
        }
        p.a(view, getData().getAvatar(), ResourcesCompat.getDrawable(resources, R.drawable.g16, null), true);
        TextView textView = this.nickView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nickView");
            textView = null;
        }
        textView.setText(getData().getNick());
        View view3 = this.dividerBarView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dividerBarView");
        } else {
            view2 = view3;
        }
        view2.setVisibility(position == 0 ? 8 : 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(final View mRootView) {
        if (mRootView != null) {
            this.mRootView = mRootView;
            View findViewById = mRootView.findViewById(R.id.ono);
            Intrinsics.checkNotNullExpressionValue(findViewById, "it.findViewById(R.id.qqstranger_item_top_line)");
            this.dividerBarView = findViewById;
            View findViewById2 = mRootView.findViewById(R.id.oob);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "it.findViewById(R.id.qqstranger_lite_user_avatar)");
            this.avatarView = findViewById2;
            View findViewById3 = mRootView.findViewById(R.id.ooc);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "it.findViewById(R.id.qqstranger_lite_user_nick)");
            this.nickView = (TextView) findViewById3;
            View view = this.avatarView;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("avatarView");
                view = null;
            }
            view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction.recyclerview.sections.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    m.v(mRootView, this, view2);
                }
            });
        }
    }
}
