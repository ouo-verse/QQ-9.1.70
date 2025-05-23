package com.tencent.mobileqq.widget.listitem;

import android.view.View;
import com.google.android.flexbox.FlexboxLayout;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class QUISingleLineListItem$registerAccessibilityTouchExplorationStateChange$2 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ x.c $rightConfig;
    final /* synthetic */ QUISingleLineListItem this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QUISingleLineListItem$registerAccessibilityTouchExplorationStateChange$2(QUISingleLineListItem qUISingleLineListItem, x.c cVar) {
        super(1);
        this.this$0 = qUISingleLineListItem;
        this.$rightConfig = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(x.c rightConfig, QUISingleLineListItem this$0, View view) {
        x xVar;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(rightConfig, "$rightConfig");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        x.c.f fVar = (x.c.f) rightConfig;
        fVar.f(!fVar.getIsChecked());
        xVar = this$0.com.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String;
        if (xVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
            xVar = null;
        }
        if (xVar.O() == rightConfig) {
            this$0.n().p().setChecked(fVar.getIsChecked());
        }
        this$0.sendAccessibilityEvent(1);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z16) {
        x xVar;
        if (!z16) {
            xVar = this.this$0.com.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String;
            if (xVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
                xVar = null;
            }
            if (xVar.O() == this.$rightConfig) {
                this.this$0.getFlexboxLayout().setOnClickListener(null);
                this.this$0.getFlexboxLayout().setClickable(false);
                return;
            }
            return;
        }
        FlexboxLayout flexboxLayout = this.this$0.getFlexboxLayout();
        final x.c cVar = this.$rightConfig;
        final QUISingleLineListItem qUISingleLineListItem = this.this$0;
        flexboxLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.widget.listitem.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QUISingleLineListItem$registerAccessibilityTouchExplorationStateChange$2.b(x.c.this, qUISingleLineListItem, view);
            }
        });
    }
}
