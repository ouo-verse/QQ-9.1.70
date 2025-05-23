package com.tencent.robot.adelie.homepage.maintab;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.quibadge.QUIBadge;
import com.tencent.qphone.base.util.QLog;
import com.tencent.robot.adelie.reddot.RedDotInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/lifecycle/Observer;", "", "Lcom/tencent/robot/adelie/reddot/a;", "invoke", "()Landroidx/lifecycle/Observer;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class IconTextTab$redDotObserver$2 extends Lambda implements Function0<Observer<List<? extends RedDotInfo>>> {
    final /* synthetic */ IconTextTab this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IconTextTab$redDotObserver$2(IconTextTab iconTextTab) {
        super(0);
        this.this$0 = iconTextTab;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(IconTextTab this$0, List list) {
        Integer num;
        QUIBadge qUIBadge;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (list != null) {
            num = Integer.valueOf(list.size());
        } else {
            num = null;
        }
        boolean z16 = true;
        QLog.i("IconTextTab", 1, "observe new red dot num:" + num);
        qUIBadge = this$0.redDotView;
        if (qUIBadge != null) {
            List list2 = list;
            int i3 = 0;
            if (list2 != null && !list2.isEmpty()) {
                z16 = false;
            }
            if (z16) {
                i3 = 8;
            }
            qUIBadge.setVisibility(i3);
        }
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Observer<List<? extends RedDotInfo>> invoke() {
        final IconTextTab iconTextTab = this.this$0;
        return new Observer() { // from class: com.tencent.robot.adelie.homepage.maintab.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                IconTextTab$redDotObserver$2.b(IconTextTab.this, (List) obj);
            }
        };
    }
}
