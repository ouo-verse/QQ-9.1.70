package com.tencent.mobileqq.aio.robot.multiselect;

import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.robot.multiselect.c;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.widget.SelectTouchBarView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/tencent/qqnt/aio/widget/SelectTouchBarView;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes11.dex */
public final class RobotMultiSelectBarVB$mTouchBar$2 extends Lambda implements Function0<SelectTouchBarView> {
    final /* synthetic */ RobotMultiSelectBarVB this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RobotMultiSelectBarVB$mTouchBar$2(RobotMultiSelectBarVB robotMultiSelectBarVB) {
        super(0);
        this.this$0 = robotMultiSelectBarVB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(RobotMultiSelectBarVB this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (view.getId() == R.id.l9j) {
            this$0.sendIntent(new c.SelectToBottom(this$0.N()));
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final SelectTouchBarView invoke() {
        int i3;
        SelectTouchBarView selectTouchBarView = new SelectTouchBarView(this.this$0.getMContext());
        final RobotMultiSelectBarVB robotMultiSelectBarVB = this.this$0;
        selectTouchBarView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        i3 = robotMultiSelectBarVB.TOUCH_BAR_HEIGHT;
        selectTouchBarView.e(i3);
        selectTouchBarView.c();
        selectTouchBarView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.aio.robot.multiselect.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RobotMultiSelectBarVB$mTouchBar$2.b(RobotMultiSelectBarVB.this, view);
            }
        });
        return selectTouchBarView;
    }
}
