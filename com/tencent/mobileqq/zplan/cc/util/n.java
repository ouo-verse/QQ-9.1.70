package com.tencent.mobileqq.zplan.cc.util;

import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R*\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/zplan/cc/util/n;", "Landroid/text/style/ClickableSpan;", "Landroid/view/View;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, "", NodeProps.ON_CLICK, "Landroid/text/TextPaint;", "ds", "updateDrawState", "Lkotlin/Function0;", "d", "Lkotlin/jvm/functions/Function0;", "getAction", "()Lkotlin/jvm/functions/Function0;", "a", "(Lkotlin/jvm/functions/Function0;)V", "action", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class n extends ClickableSpan {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Function0<Unit> action;

    public final void a(Function0<Unit> function0) {
        this.action = function0;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View widget) {
        Intrinsics.checkNotNullParameter(widget, "widget");
        QLog.i("ZPlanCamera_FilamentAIFace", 1, "policyTipClickSpan onClick");
        Function0<Unit> function0 = this.action;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint ds5) {
        Intrinsics.checkNotNullParameter(ds5, "ds");
        super.updateDrawState(ds5);
        ds5.setUnderlineText(false);
        ds5.setColor(Color.parseColor("#0099FF"));
    }
}
