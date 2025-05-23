package com.tencent.mobileqq.vas.kuikly;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.UiThread;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import i01.c;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 .2\u00020\u00012\u00020\u0002:\u0001/B\u000f\u0012\u0006\u0010+\u001a\u00020*\u00a2\u0006\u0004\b,\u0010-J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016JI\u0010\u0013\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u00052+\u0010\u0012\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0003\u0018\u00010\rj\u0004\u0018\u0001`\u0011H\u0016R\u001e\u0010\u0018\u001a\n \u0015*\u0004\u0018\u00010\u00140\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR;\u0010\u001e\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0003\u0018\u00010\rj\u0004\u0018\u0001`\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR;\u0010 \u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0003\u0018\u00010\rj\u0004\u0018\u0001`\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001dR;\u0010\"\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0003\u0018\u00010\rj\u0004\u0018\u0001`\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\u001dR;\u0010$\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0003\u0018\u00010\rj\u0004\u0018\u0001`\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010\u001dR;\u0010&\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0007\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0003\u0018\u00010\rj\u0004\u0018\u0001`\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010\u001dR\u0016\u0010)\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/vas/kuikly/VasActionSheetView;", "Landroid/widget/FrameLayout;", "Li01/c;", "", "t", "", "propKey", "", "propValue", "", "b", "method", "params", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "call", "Lcom/tencent/widget/ActionSheet;", "kotlin.jvm.PlatformType", "d", "Lcom/tencent/widget/ActionSheet;", "actionSheet", "e", "Z", "mSupportNightMode", "f", "Lkotlin/jvm/functions/Function1;", "callOnDismissCallback", tl.h.F, "callOnClickCallback", "i", "callOnPreShowListener", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "callOnButtonClickWithTextListener", BdhLogUtil.LogTag.Tag_Conn, "callOnBottomCancelListener", "D", "Ljava/lang/String;", "mainTitle", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "E", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VasActionSheetView extends FrameLayout implements i01.c {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private Function1<Object, Unit> callOnBottomCancelListener;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private String mainTitle;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ActionSheet actionSheet;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean mSupportNightMode;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<Object, Unit> callOnDismissCallback;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<Object, Unit> callOnClickCallback;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<Object, Unit> callOnPreShowListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<Object, Unit> callOnButtonClickWithTextListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VasActionSheetView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        ActionSheet create = ActionSheet.create(context);
        this.actionSheet = create;
        this.mSupportNightMode = true;
        this.mainTitle = "";
        create.setOnButtonClickListenerV2(new ActionSheet.OnButtonClickListenerV2() { // from class: com.tencent.mobileqq.vas.kuikly.c
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListenerV2
            public final void OnClick(View view, int i3, String str) {
                VasActionSheetView.l(VasActionSheetView.this, view, i3, str);
            }
        });
        this.actionSheet.registerWatchDisMissActionListener(new ActionSheet.WatchDismissActions() { // from class: com.tencent.mobileqq.vas.kuikly.d
            @Override // com.tencent.widget.ActionSheet.WatchDismissActions
            public final void onDismissOperations() {
                VasActionSheetView.m(VasActionSheetView.this);
            }
        });
        this.actionSheet.setOnDismissListener(new ActionSheet.OnDismissListener() { // from class: com.tencent.mobileqq.vas.kuikly.e
            @Override // com.tencent.widget.ActionSheet.OnDismissListener
            public final void onDismiss() {
                VasActionSheetView.o(VasActionSheetView.this);
            }
        });
        this.actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.vas.kuikly.f
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                VasActionSheetView.p(VasActionSheetView.this, view, i3);
            }
        });
        this.actionSheet.setOnBottomCancelListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.vas.kuikly.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VasActionSheetView.q(VasActionSheetView.this, view);
            }
        });
        ActionSheet actionSheet = this.actionSheet;
        if (actionSheet != null) {
            actionSheet.setOnPreShowListener(new ActionSheet.onPreShowListener() { // from class: com.tencent.mobileqq.vas.kuikly.h
                @Override // com.tencent.widget.ActionSheet.onPreShowListener
                public final void onPreShow() {
                    VasActionSheetView.r(VasActionSheetView.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(VasActionSheetView this$0, View view, int i3, String str) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Function1<Object, Unit> function1 = this$0.callOnButtonClickWithTextListener;
        if (function1 != null) {
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("index", Integer.valueOf(i3)), TuplesKt.to("text", str));
            function1.invoke(mapOf);
        }
        QLog.i("VasActionSheetView", 1, "OnButtonClickListenerV2 action");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(VasActionSheetView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Function1<Object, Unit> function1 = this$0.callOnDismissCallback;
        if (function1 != null) {
            function1.invoke(null);
        }
        QLog.i("VasActionSheetView", 1, "OnDismissAction action");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(VasActionSheetView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Function1<Object, Unit> function1 = this$0.callOnDismissCallback;
        if (function1 != null) {
            function1.invoke(null);
        }
        QLog.i("VasActionSheetView", 1, "OnDismiss action");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(VasActionSheetView this$0, View view, int i3) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Function1<Object, Unit> function1 = this$0.callOnClickCallback;
        if (function1 != null) {
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("index", Integer.valueOf(i3)));
            function1.invoke(mapOf);
        }
        QLog.i("VasActionSheetView", 1, "OnButtonClick action");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(VasActionSheetView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Function1<Object, Unit> function1 = this$0.callOnBottomCancelListener;
        if (function1 != null) {
            function1.invoke(null);
        }
        QLog.i("VasActionSheetView", 1, "OnBottomCancel action");
        this$0.actionSheet.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(VasActionSheetView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Function1<Object, Unit> function1 = this$0.callOnPreShowListener;
        if (function1 != null) {
            function1.invoke(null);
        }
        QLog.i("VasActionSheetView", 1, "OnPreShow action");
    }

    private final void t() {
        boolean z16 = true;
        this.actionSheet.setForceDayMode(true);
        if (this.mainTitle.length() <= 0) {
            z16 = false;
        }
        if (z16) {
            this.actionSheet.setMainTitle(this.mainTitle);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0011. Please report as an issue. */
    @Override // i01.c
    public boolean b(@NotNull String propKey, @NotNull Object propValue) {
        Integer num;
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        Intrinsics.checkNotNullParameter(propValue, "propValue");
        switch (propKey.hashCode()) {
            case -1714863352:
                if (propKey.equals("outsideDismissEnable")) {
                    this.actionSheet.setOutsideDismissEnableCompat(((Boolean) propValue).booleanValue());
                    return true;
                }
                return c.a.p(this, propKey, propValue);
            case -1614280392:
                if (propKey.equals("animationDuration")) {
                    this.actionSheet.setAnimationTime(((Integer) propValue).intValue());
                    return true;
                }
                return c.a.p(this, propKey, propValue);
            case -1373290804:
                if (propKey.equals("supportNightMode")) {
                    this.mSupportNightMode = ((Boolean) propValue).booleanValue();
                    return true;
                }
                return c.a.p(this, propKey, propValue);
            case -1306401257:
                if (propKey.equals("onButtonClick")) {
                    this.callOnClickCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
                    return true;
                }
                return c.a.p(this, propKey, propValue);
            case -1287015509:
                if (propKey.equals("onDismiss")) {
                    this.callOnDismissCallback = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
                    return true;
                }
                return c.a.p(this, propKey, propValue);
            case -45966052:
                if (propKey.equals("onClickWithText")) {
                    this.callOnButtonClickWithTextListener = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
                    return true;
                }
                return c.a.p(this, propKey, propValue);
            case 52888548:
                if (propKey.equals("onBottomCancelClick")) {
                    this.callOnBottomCancelListener = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
                    return true;
                }
                return c.a.p(this, propKey, propValue);
            case 110327241:
                if (propKey.equals("theme")) {
                    String str = (String) propValue;
                    if (Intrinsics.areEqual(str, "day")) {
                        num = 1001;
                    } else if (Intrinsics.areEqual(str, "night")) {
                        num = 1002;
                    } else {
                        num = null;
                    }
                    if (num == null || num.intValue() != 1001) {
                        return true;
                    }
                    t();
                    return true;
                }
                return c.a.p(this, propKey, propValue);
            case 110371416:
                if (propKey.equals("title")) {
                    String str2 = (String) propValue;
                    this.mainTitle = str2;
                    this.actionSheet.setMainTitle(str2);
                    return true;
                }
                return c.a.p(this, propKey, propValue);
            case 1017051489:
                if (propKey.equals("onPreShow")) {
                    this.callOnPreShowListener = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propValue, 1);
                    return true;
                }
                return c.a.p(this, propKey, propValue);
            default:
                return c.a.p(this, propKey, propValue);
        }
    }

    @Override // i01.a
    @Nullable
    public Object call(@NotNull String str, @Nullable Object obj, @Nullable Function1<Object, Unit> function1) {
        return c.a.a(this, str, obj, function1);
    }

    @Override // i01.c
    public void e(@NotNull ViewGroup viewGroup) {
        c.a.l(this, viewGroup);
    }

    @Override // i01.c
    @NotNull
    public View f() {
        return c.a.r(this);
    }

    @Override // i01.c, i01.a
    @Nullable
    public Activity getActivity() {
        return c.a.e(this);
    }

    @Override // i01.c, i01.a
    @Nullable
    /* renamed from: getKuiklyRenderContext */
    public com.tencent.kuikly.core.render.android.a get_kuiklyRenderContext() {
        return c.a.f(this);
    }

    @Override // i01.c
    @UiThread
    public void h() {
        c.a.n(this);
    }

    @Override // i01.c
    /* renamed from: k */
    public boolean getReusable() {
        return c.a.g(this);
    }

    @Override // i01.c
    public void n(@NotNull ViewGroup viewGroup) {
        c.a.i(this, viewGroup);
    }

    @Override // i01.a
    @UiThread
    public void onCreate() {
        c.a.j(this);
    }

    @Override // i01.c, i01.a
    public void onDestroy() {
        c.a.k(this);
    }

    @Override // i01.c
    @UiThread
    public boolean s(@NotNull String str) {
        return c.a.m(this, str);
    }

    @Override // i01.c, i01.a
    public void setKuiklyRenderContext(@Nullable com.tencent.kuikly.core.render.android.a aVar) {
        c.a.o(this, aVar);
    }

    @Override // i01.c
    @UiThread
    public void setShadow(@NotNull i01.b bVar) {
        c.a.q(this, bVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000d. Please report as an issue. */
    @Override // i01.c, i01.a
    @Nullable
    public Object call(@NotNull String method, @Nullable String params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(method, "method");
        switch (method.hashCode()) {
            case -484847821:
                if (method.equals("addButton")) {
                    this.actionSheet.addButton(params);
                    return Unit.INSTANCE;
                }
                return c.a.b(this, method, params, callback);
            case -270323796:
                if (method.equals("addRadioButton")) {
                    if (params == null) {
                        return Boolean.FALSE;
                    }
                    JSONObject jSONObject = new JSONObject(params);
                    this.actionSheet.addRadioButton(jSONObject.optString("text"), jSONObject.optBoolean("selected"));
                    return Unit.INSTANCE;
                }
                return c.a.b(this, method, params, callback);
            case -228662899:
                if (method.equals("addCancelButton")) {
                    this.actionSheet.addCancelButton(params);
                    return Unit.INSTANCE;
                }
                return c.a.b(this, method, params, callback);
            case 3529469:
                if (method.equals("show")) {
                    this.actionSheet.show();
                    return Unit.INSTANCE;
                }
                return c.a.b(this, method, params, callback);
            case 1671672458:
                if (method.equals("dismiss")) {
                    this.actionSheet.dismiss();
                    return Unit.INSTANCE;
                }
                return c.a.b(this, method, params, callback);
            case 1699033459:
                if (method.equals("addButtonWithType")) {
                    if (params == null) {
                        return Boolean.FALSE;
                    }
                    JSONObject jSONObject2 = new JSONObject(params);
                    this.actionSheet.addButton(jSONObject2.optString("text"), jSONObject2.optInt("typeId"));
                    return Unit.INSTANCE;
                }
                return c.a.b(this, method, params, callback);
            default:
                return c.a.b(this, method, params, callback);
        }
    }
}
