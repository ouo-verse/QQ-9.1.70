package com.tencent.mobileqq.setting.main.processor;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.setting.mode.ModeChoiceFragment;
import com.tencent.mobileqq.widget.listitem.x;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0005\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\f\u0010\n\u001a\u0006\u0012\u0002\b\u00030\tH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016R\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/setting/main/processor/o;", "Lcom/tencent/mobileqq/setting/processor/c;", "", "", "", HippyTKDListViewAdapter.X, "", "type", "y", "Lcom/tencent/mobileqq/widget/listitem/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "onResume", "r", "Landroid/content/Context;", "g", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "qq_setting_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class o extends com.tencent.mobileqq.setting.processor.c {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(Context context) {
        super(context, 4);
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(o this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        com.tencent.mobileqq.setting.utils.o.f286768a.l(it, "em_bas_pattern_selection", this$0.x(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(o this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Activity e16 = this$0.e();
        if (e16 != null) {
            QPublicFragmentActivity.start(e16, new Intent(), ModeChoiceFragment.class);
        }
        com.tencent.mobileqq.setting.utils.o oVar = com.tencent.mobileqq.setting.utils.o.f286768a;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        oVar.f(it, "em_bas_pattern_selection", this$0.x());
    }

    @Override // com.tencent.mobileqq.setting.processor.c, com.tencent.mobileqq.setting.processor.d
    public void onResume() {
        super.onResume();
        com.tencent.mobileqq.widget.listitem.a<?> g16 = g();
        Intrinsics.checkNotNull(g16, "null cannot be cast to non-null type com.tencent.mobileqq.widget.listitem.SingleLineConfig<*, com.tencent.mobileqq.widget.listitem.SingleLineConfig.Right.Text>");
        if (TextUtils.equals(((x.c.g) ((x) g16).O()).getText(), y(com.tencent.mobileqq.studymode.g.a()))) {
            return;
        }
        com.tencent.mobileqq.widget.listitem.a<?> g17 = g();
        Intrinsics.checkNotNull(g17, "null cannot be cast to non-null type com.tencent.mobileqq.widget.listitem.SingleLineConfig<*, com.tencent.mobileqq.widget.listitem.SingleLineConfig.Right.Text>");
        ((x.c.g) ((x) g17).O()).h(y(com.tencent.mobileqq.studymode.g.a()));
        l();
    }

    @Override // com.tencent.mobileqq.setting.processor.c
    public com.tencent.mobileqq.widget.listitem.a<?> q() {
        String string = this.context.getString(R.string.wjw);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026eneral_mode_select_title)");
        x xVar = new x(new x.b.C8996b(string, R.drawable.qui_mode_selection), new x.c.g("", false, false, 6, null));
        xVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.setting.main.processor.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                o.z(o.this, view);
            }
        });
        ((x.c.g) xVar.O()).h(y(com.tencent.mobileqq.studymode.g.a()));
        xVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.setting.main.processor.n
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                o.A(o.this, view);
            }
        });
        return xVar;
    }

    @Override // com.tencent.mobileqq.setting.processor.c
    public void r() {
        com.tencent.mobileqq.widget.listitem.a<?> g16 = g();
        Intrinsics.checkNotNull(g16, "null cannot be cast to non-null type com.tencent.mobileqq.widget.listitem.SingleLineConfig<*, com.tencent.mobileqq.widget.listitem.SingleLineConfig.Right.Text>");
        ((x.c.g) ((x) g16).O()).h(y(com.tencent.mobileqq.studymode.g.a()));
        l();
    }

    private final Map<String, Object> x() {
        HashMap hashMapOf;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("pattern_type", y(com.tencent.mobileqq.studymode.g.a())));
        return hashMapOf;
    }

    private final String y(int type) {
        String string;
        if (type == 1) {
            string = this.context.getResources().getString(R.string.wjy);
        } else if (type == 2) {
            string = this.context.getResources().getString(R.string.f242937vx);
        } else if (type != 3) {
            string = this.context.getResources().getString(com.tencent.mobileqq.studymode.r.b());
        } else {
            string = this.context.getResources().getString(R.string.f167902e7);
        }
        Intrinsics.checkNotNullExpressionValue(string, "when (type) {\n        MO\u2026tDefaultModeName())\n    }");
        return string;
    }
}
