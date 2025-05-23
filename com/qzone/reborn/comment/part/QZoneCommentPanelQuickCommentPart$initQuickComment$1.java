package com.qzone.reborn.comment.part;

import android.app.Activity;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lq5/a;", "commentInfo", "", "invoke", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneCommentPanelQuickCommentPart$initQuickComment$1 extends Lambda implements Function1<List<? extends q5.a>, Unit> {
    final /* synthetic */ QZoneCommentPanelQuickCommentPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneCommentPanelQuickCommentPart$initQuickComment$1(QZoneCommentPanelQuickCommentPart qZoneCommentPanelQuickCommentPart) {
        super(1);
        this.this$0 = qZoneCommentPanelQuickCommentPart;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(List commentInfo, QZoneCommentPanelQuickCommentPart this$0) {
        Intrinsics.checkNotNullParameter(commentInfo, "$commentInfo");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!commentInfo.isEmpty()) {
            this$0.Q9(commentInfo);
            QLog.i("QZoneCommentPanelQuickCommentPart", 2, "already get AI quick comment, count: " + commentInfo.size());
            return;
        }
        QLog.i("QZoneCommentPanelQuickCommentPart", 2, "AI quick comment is empty, load default quick comment");
        this$0.N9();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends q5.a> list) {
        invoke2(list);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(final List<? extends q5.a> commentInfo) {
        Intrinsics.checkNotNullParameter(commentInfo, "commentInfo");
        Activity activity = this.this$0.getActivity();
        if (activity != null) {
            final QZoneCommentPanelQuickCommentPart qZoneCommentPanelQuickCommentPart = this.this$0;
            activity.runOnUiThread(new Runnable() { // from class: com.qzone.reborn.comment.part.af
                @Override // java.lang.Runnable
                public final void run() {
                    QZoneCommentPanelQuickCommentPart$initQuickComment$1.b(commentInfo, qZoneCommentPanelQuickCommentPart);
                }
            });
        }
    }
}
