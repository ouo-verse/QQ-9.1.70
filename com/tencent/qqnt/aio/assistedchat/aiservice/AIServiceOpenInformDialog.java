package com.tencent.qqnt.aio.assistedchat.aiservice;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.assistedchat.permission.AssistedChatBaseDialog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001d\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0014\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tH\u0002J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\nJ\u001a\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0010\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001aH\u0016R\u001c\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/aiservice/AIServiceOpenInformDialog;", "Lcom/tencent/qqnt/aio/assistedchat/permission/AssistedChatBaseDialog;", "Landroid/text/SpannableString;", "yh", "", "Bh", "", "clickPos", "Ah", "", "", "", "xh", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "tag", "Ch", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Landroid/content/DialogInterface;", "dialog", "onDismiss", "onCancel", "Landroid/content/Context;", "context", "rh", "Lkotlin/Function0;", "E", "Lkotlin/jvm/functions/Function0;", "onDismissListener", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AIServiceOpenInformDialog extends AssistedChatBaseDialog {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private final Function0<Unit> onDismissListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/qqnt/aio/assistedchat/aiservice/AIServiceOpenInformDialog$a", "Landroid/text/style/ClickableSpan;", "Landroid/text/TextPaint;", "ds", "", "updateDrawState", "Landroid/view/View;", AECameraConstants.HOT_ENTRY_TYPE_WIDGET, NodeProps.ON_CLICK, "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class a extends ClickableSpan {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIServiceOpenInformDialog.this);
            }
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NotNull View widget) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) widget);
                return;
            }
            Intrinsics.checkNotNullParameter(widget, "widget");
            AIServiceOpenInformDialog.this.Ah(2);
            QRoute.createNavigator(widget.getContext(), RouterConstants.UI_ROUTE_BROWSER).withString("url", "https://rule.tencent.com/rule/abd15ee5-bbdf-402c-89d2-e10e9200cd1c").request();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NotNull TextPaint ds5) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) ds5);
                return;
            }
            Intrinsics.checkNotNullParameter(ds5, "ds");
            Context context = AIServiceOpenInformDialog.this.getContext();
            if (context != null) {
                i3 = context.getColor(R.color.qui_common_text_link);
            } else {
                i3 = 0;
            }
            ds5.setColor(i3);
            ds5.setUnderlineText(false);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/qqnt/aio/assistedchat/aiservice/AIServiceOpenInformDialog$b", "Lcom/tencent/mobileqq/widget/qus/QUSBaseHalfScreenFloatingView$o;", "", "a", "Landroid/view/View;", "v", "", NodeProps.ON_CLICK, "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes23.dex */
    public static final class b implements QUSBaseHalfScreenFloatingView.o {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIServiceOpenInformDialog.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.o
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                AIServiceOpenInformDialog.this.Ah(0);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.o
        public boolean onClick(@Nullable View v3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) v3)).booleanValue();
            }
            return false;
        }
    }

    public AIServiceOpenInformDialog() {
        this(null, 1, 0 == true ? 1 : 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            return;
        }
        iPatchRedirector.redirect((short) 8, (Object) this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ah(int clickPos) {
        Map plus;
        plus = MapsKt__MapsKt.plus(xh(), TuplesKt.to("click_pos", Integer.valueOf(clickPos)));
        VideoReport.reportEvent("qq_clck", plus);
    }

    private final void Bh() {
        VideoReport.reportEvent("qq_imp", xh());
    }

    private final Map<String, Object> xh() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("qq_eid", "em_ai_assistant_pop");
        linkedHashMap.put("qq_pgid", "pg_bas_msglist");
        linkedHashMap.put("msglist_type", 0);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "peekAppRuntime()");
            String currentUin = peekAppRuntime.getCurrentUin();
            String str = "";
            if (currentUin == null) {
                currentUin = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(currentUin, "it.currentUin ?: \"\"");
            }
            linkedHashMap.put("home_uin", currentUin);
            String currentUid = peekAppRuntime.getCurrentUid();
            if (currentUid != null) {
                Intrinsics.checkNotNullExpressionValue(currentUid, "it.currentUid ?: \"\"");
                str = currentUid;
            }
            linkedHashMap.put("uid", str);
        }
        return linkedHashMap;
    }

    private final SpannableString yh() {
        SpannableString spannableString = new SpannableString("AI\u670d\u52a1 \u53ef\u4e3a\u4f60\u63d0\u4f9b\u804a\u5929\u603b\u7ed3\u3001\u56de\u590d\u63a8\u8350\u7b49\u529f\u80fd\uff0c\u5f00\u542f\u540e\u5c06\u83b7\u53d6\u4f60\u7684QQ\u804a\u5929\u4fe1\u606f\uff0c\u4ec5\u7528\u4e8e\u751f\u6210\u56de\u590d\u5efa\u8bae\u3001\u6458\u8981\u7b49\u76ee\u7684\uff1bQQ\u5c06\u4e0d\u4f1a\u4fdd\u5b58\u4f60\u7684\u804a\u5929\u8bb0\u5f55\u3002\n\u8be6\u60c5\u8bf7\u53c2\u9605\u300aQQ AI\u670d\u52a1\u4e2a\u4eba\u4fe1\u606f\u5904\u7406\u89c4\u5219\u300b\u3002");
        spannableString.setSpan(new StyleSpan() { // from class: com.tencent.qqnt.aio.assistedchat.aiservice.AIServiceOpenInformDialog$getProtocolSpan$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIServiceOpenInformDialog.this);
                }
            }

            private final void a(TextPaint paint) {
                Typeface create;
                if (Build.VERSION.SDK_INT >= 28) {
                    create = Typeface.create(null, 500, false);
                    Intrinsics.checkNotNullExpressionValue(create, "create(null, 500, false)");
                    paint.setTypeface(create);
                }
            }

            @Override // android.text.style.StyleSpan, android.text.style.CharacterStyle
            public void updateDrawState(@Nullable TextPaint ds5) {
                int i3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) ds5);
                    return;
                }
                if (ds5 != null) {
                    Context context = AIServiceOpenInformDialog.this.getContext();
                    if (context != null) {
                        i3 = context.getColor(R.color.qui_common_text_primary);
                    } else {
                        i3 = 0;
                    }
                    ds5.setColor(i3);
                    a(ds5);
                }
            }

            @Override // android.text.style.StyleSpan, android.text.style.MetricAffectingSpan
            public void updateMeasureState(@NotNull TextPaint paint) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) paint);
                    return;
                }
                Intrinsics.checkNotNullParameter(paint, "paint");
                super.updateMeasureState(paint);
                a(paint);
            }
        }, 0, 4, 17);
        spannableString.setSpan(new a(), 74, 91, 17);
        return spannableString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void zh(AIServiceOpenInformDialog this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Ah(1);
        this$0.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void Ch(@NotNull FragmentManager fragmentManager, @Nullable String tag) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) fragmentManager, (Object) tag);
        } else {
            Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
            fragmentManager.beginTransaction().add(this, tag).commitAllowingStateLoss();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(@NotNull DialogInterface dialog) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) dialog);
            return;
        }
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onCancel(dialog);
        Ah(0);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NotNull DialogInterface dialog) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) dialog);
            return;
        }
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        Function0<Unit> function0 = this.onDismissListener;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        QUSHalfScreenFloatingView qh5 = qh();
        if (qh5 != null) {
            qh5.setOnOutsideAreaClickListener(new b());
        }
        Bh();
    }

    @Override // com.tencent.qqnt.aio.assistedchat.permission.AssistedChatBaseDialog
    @NotNull
    public View rh(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (View) iPatchRedirector.redirect((short) 7, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        linearLayout.setOrientation(1);
        linearLayout.setPadding(ViewUtils.dpToPx(40.0f), ViewUtils.dpToPx(32.0f), ViewUtils.dpToPx(40.0f), ViewUtils.dpToPx(20.0f));
        TextView textView = new TextView(context);
        textView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        textView.setTextColor(ContextCompat.getColorStateList(context, R.color.qui_common_text_primary));
        textView.setHighlightColor(0);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setTextSize(14.0f);
        textView.setGravity(8388611);
        textView.setText(yh());
        linearLayout.addView(textView);
        TextView textView2 = new TextView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = ViewUtils.dpToPx(16.0f);
        textView2.setLayoutParams(layoutParams);
        textView2.setTextColor(ContextCompat.getColorStateList(context, R.color.qui_common_text_primary));
        textView2.setTextSize(14.0f);
        textView2.setText("\u5982\u9700\u5173\u95ed\uff0c\u53ef\u5728\u300c\u8bbe\u7f6e-\u901a\u7528-\u804a\u5929-AI\u670d\u52a1\u300d\u91cc\u8fdb\u884c\u5173\u95ed");
        linearLayout.addView(textView2);
        QUIButton qUIButton = new QUIButton(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, ViewUtils.dpToPx(45.0f));
        layoutParams2.topMargin = ViewUtils.dpToPx(20.0f);
        layoutParams2.gravity = 1;
        qUIButton.setLayoutParams(layoutParams2);
        qUIButton.setType(0);
        qUIButton.setSizeType(1);
        qUIButton.setGravity(17);
        qUIButton.setText("\u6211\u77e5\u9053\u4e86");
        qUIButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.aio.assistedchat.aiservice.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AIServiceOpenInformDialog.zh(AIServiceOpenInformDialog.this, view);
            }
        });
        linearLayout.addView(qUIButton);
        return linearLayout;
    }

    public AIServiceOpenInformDialog(@Nullable Function0<Unit> function0) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.onDismissListener = function0;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) function0);
        }
    }

    public /* synthetic */ AIServiceOpenInformDialog(Function0 function0, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : function0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, function0, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
