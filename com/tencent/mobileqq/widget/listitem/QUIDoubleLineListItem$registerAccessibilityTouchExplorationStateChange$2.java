package com.tencent.mobileqq.widget.listitem;

import android.view.View;
import com.google.android.flexbox.FlexboxLayout;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.widget.listitem.c;
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
public final class QUIDoubleLineListItem$registerAccessibilityTouchExplorationStateChange$2 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ c.b $rightConfig;
    final /* synthetic */ QUIDoubleLineListItem this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QUIDoubleLineListItem$registerAccessibilityTouchExplorationStateChange$2(QUIDoubleLineListItem qUIDoubleLineListItem, c.b bVar) {
        super(1);
        this.this$0 = qUIDoubleLineListItem;
        this.$rightConfig = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(c.b rightConfig, QUIDoubleLineListItem this$0, View view) {
        c cVar;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(rightConfig, "$rightConfig");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        c.b.C8994b c8994b = (c.b.C8994b) rightConfig;
        c8994b.e(!c8994b.getIsChecked());
        cVar = this$0.com.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
            cVar = null;
        }
        if (cVar.O() == rightConfig) {
            this$0.n().p().setChecked(c8994b.getIsChecked());
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
        c cVar;
        if (!z16) {
            cVar = this.this$0.com.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String;
            if (cVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
                cVar = null;
            }
            if (cVar.O() == this.$rightConfig) {
                this.this$0.getFlexboxLayout().setOnClickListener(null);
                this.this$0.getFlexboxLayout().setClickable(false);
                return;
            }
            return;
        }
        FlexboxLayout flexboxLayout = this.this$0.getFlexboxLayout();
        final c.b bVar = this.$rightConfig;
        final QUIDoubleLineListItem qUIDoubleLineListItem = this.this$0;
        flexboxLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.widget.listitem.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QUIDoubleLineListItem$registerAccessibilityTouchExplorationStateChange$2.b(c.b.this, qUIDoubleLineListItem, view);
            }
        });
    }
}
