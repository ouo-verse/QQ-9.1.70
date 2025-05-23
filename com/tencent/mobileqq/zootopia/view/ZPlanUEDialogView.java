package com.tencent.mobileqq.zootopia.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.state.report.SquareReportConst;
import com.tencent.zplan.luabridge.LuaArgument;
import fi3.ca;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 &2\u00020\u0001:\u0001'B'\u0012\u0006\u0010!\u001a\u00020 \u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J2\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\f8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R$\u0010\u001f\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/zootopia/view/ZPlanUEDialogView;", "Landroid/widget/FrameLayout;", "", "msg", "", "d", "title", "cancelBtn", "confirmBtn", "Lcom/tencent/mobileqq/zootopia/view/b;", "listener", "e", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "getSource", "()Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "reportHelper", "Lfi3/ca;", "f", "Lfi3/ca;", "binding", "Lcom/tencent/zplan/luabridge/LuaArgument;", tl.h.F, "Lcom/tencent/zplan/luabridge/LuaArgument;", "getArgument", "()Lcom/tencent/zplan/luabridge/LuaArgument;", "setArgument", "(Lcom/tencent/zplan/luabridge/LuaArgument;)V", "argument", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;Lcom/tencent/mobileqq/zootopia/ZootopiaSource;)V", "i", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanUEDialogView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ZootopiaSource source;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ZplanViewReportHelper reportHelper;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final ca binding;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private LuaArgument argument;

    public /* synthetic */ ZPlanUEDialogView(Context context, AttributeSet attributeSet, ZootopiaSource zootopiaSource, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? null : zootopiaSource);
    }

    private final void d(String msg2) {
        this.binding.f399219e.setText(msg2);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(com.tencent.sqshow.zootopia.utils.i.b(236), Integer.MIN_VALUE);
        this.binding.f399219e.measure(makeMeasureSpec, 0);
        int measuredHeight = this.binding.f399219e.getMeasuredHeight();
        this.binding.f399219e.setText("\u6d4b\u8bd5\n\u6d4b\u8bd5\n\u6d4b\u8bd5\n\u6d4b\u8bd5\n\u6d4b\u8bd5");
        this.binding.f399219e.measure(makeMeasureSpec, 0);
        int measuredHeight2 = this.binding.f399219e.getMeasuredHeight();
        QLog.i("ZPlanUEDialogView", 1, "msgHeight:" + measuredHeight + ", lineHeight:" + measuredHeight2);
        ViewGroup viewGroup = (ViewGroup) this.binding.f399219e.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this.binding.f399219e);
        }
        if (measuredHeight <= measuredHeight2) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            ca caVar = this.binding;
            caVar.f399223i.addView(caVar.f399219e, layoutParams);
        } else {
            ViewGroup.LayoutParams layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
            ca caVar2 = this.binding;
            caVar2.f399224j.addView(caVar2.f399219e, layoutParams2);
        }
        this.binding.f399219e.setText(msg2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(ZPlanUEDialogView this$0, b bVar, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("ZPlanUEDialogView", 1, "click left btn");
        this$0.setVisibility(8);
        if (bVar != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            bVar.c(it);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(ZPlanUEDialogView this$0, b bVar, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("ZPlanUEDialogView", 1, "click right btn");
        this$0.setVisibility(8);
        if (bVar != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            bVar.a(it);
        }
    }

    public final void e(String title, String msg2, String cancelBtn, String confirmBtn, final b listener) {
        Map<String, Object> mutableMapOf;
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(cancelBtn, "cancelBtn");
        Intrinsics.checkNotNullParameter(confirmBtn, "confirmBtn");
        setVisibility(4);
        ZplanViewReportHelper zplanViewReportHelper = this.reportHelper;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Pair[] pairArr = new Pair[1];
        ZootopiaSource zootopiaSource = this.source;
        if (zootopiaSource == null) {
            zootopiaSource = ZootopiaSource.INSTANCE.g();
        }
        pairArr[0] = TuplesKt.to(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, zootopiaSource);
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        zplanViewReportHelper.a(context, this, "pg_zplan_xiaowo_loading", mutableMapOf);
        this.binding.f399218d.setText(cancelBtn);
        this.binding.f399220f.setText(confirmBtn);
        this.binding.f399221g.setText(title);
        this.binding.f399219e.setText(msg2);
        if (cancelBtn.length() == 0) {
            this.binding.f399218d.setVisibility(8);
            this.binding.f399217c.setVisibility(8);
        } else {
            this.binding.f399218d.setVisibility(0);
            this.binding.f399218d.setText(cancelBtn);
        }
        if (confirmBtn.length() == 0) {
            this.binding.f399220f.setVisibility(8);
            this.binding.f399217c.setVisibility(8);
        } else {
            this.binding.f399220f.setVisibility(0);
            this.binding.f399220f.setText(confirmBtn);
        }
        if (cancelBtn.length() > 0) {
            if (confirmBtn.length() > 0) {
                this.binding.f399217c.setVisibility(0);
            }
        }
        d(msg2);
        if (listener != null) {
            TextView textView = this.binding.f399218d;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.dialogLeftBtn");
            listener.b(textView);
        }
        if (listener != null) {
            TextView textView2 = this.binding.f399220f;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.dialogRightBtn");
            listener.e(textView2);
        }
        if (listener != null) {
            listener.d(this);
        }
        this.binding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.view.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZPlanUEDialogView.f(view);
            }
        });
        TextView textView3 = this.binding.f399218d;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.dialogLeftBtn");
        com.tencent.sqshow.zootopia.utils.aa.d(textView3, new View.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.view.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZPlanUEDialogView.g(ZPlanUEDialogView.this, listener, view);
            }
        });
        TextView textView4 = this.binding.f399220f;
        Intrinsics.checkNotNullExpressionValue(textView4, "binding.dialogRightBtn");
        com.tencent.sqshow.zootopia.utils.aa.d(textView4, new View.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.view.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZPlanUEDialogView.h(ZPlanUEDialogView.this, listener, view);
            }
        });
        setVisibility(0);
    }

    public final void setArgument(LuaArgument luaArgument) {
        this.argument = luaArgument;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanUEDialogView(Context context, AttributeSet attributeSet, ZootopiaSource zootopiaSource) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.source = zootopiaSource;
        this.reportHelper = new ZplanViewReportHelper();
        ca g16 = ca.g(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context), this, true)");
        this.binding = g16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(View view) {
        QLog.d("ZPlanUEDialogView", 1, "click root view");
    }
}
