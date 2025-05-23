package com.tencent.mobileqq.matchfriend.reborn.content.msg.setting.part;

import android.widget.CompoundButton;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.setting.viewmodel.QQStrangerMsgSettingViewModel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class QQStrangerMsgSettingListPart$hideModeCheckedChangeListener$2 extends Lambda implements Function0<CompoundButton.OnCheckedChangeListener> {
    final /* synthetic */ QQStrangerMsgSettingListPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQStrangerMsgSettingListPart$hideModeCheckedChangeListener$2(QQStrangerMsgSettingListPart qQStrangerMsgSettingListPart) {
        super(0);
        this.this$0 = qQStrangerMsgSettingListPart;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(QQStrangerMsgSettingListPart this$0, CompoundButton buttonView, boolean z16) {
        QQStrangerMsgSettingViewModel I9;
        Map mapOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.hadSetHideModeChangedFlag = true;
        I9 = this$0.I9();
        I9.U1(z16);
        Intrinsics.checkNotNullExpressionValue(buttonView, "buttonView");
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("after_switch_state", Integer.valueOf(z16 ? 1 : 0)));
        this$0.P9(buttonView, "em_kl_stealth_mode", mapOf);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final CompoundButton.OnCheckedChangeListener invoke() {
        final QQStrangerMsgSettingListPart qQStrangerMsgSettingListPart = this.this$0;
        return new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.setting.part.c
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                QQStrangerMsgSettingListPart$hideModeCheckedChangeListener$2.b(QQStrangerMsgSettingListPart.this, compoundButton, z16);
            }
        };
    }
}
