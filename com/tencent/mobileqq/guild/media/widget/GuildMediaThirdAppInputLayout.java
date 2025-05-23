package com.tencent.mobileqq.guild.media.widget;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;
import cooperation.qzone.QZoneShareManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 52\u00020\u0001:\u00016B\u0011\b\u0016\u0012\u0006\u0010-\u001a\u00020,\u00a2\u0006\u0004\b.\u0010/B\u001b\b\u0016\u0012\u0006\u0010-\u001a\u00020,\u0012\b\u00101\u001a\u0004\u0018\u000100\u00a2\u0006\u0004\b.\u00102B#\b\u0016\u0012\u0006\u0010-\u001a\u00020,\u0012\b\u00101\u001a\u0004\u0018\u000100\u0012\u0006\u00103\u001a\u00020\n\u00a2\u0006\u0004\b.\u00104J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002JA\u0010\u0015\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2!\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00020\u0010R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\"R\u0016\u0010%\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010$R$\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010&R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/guild/media/widget/GuildMediaThirdAppInputLayout;", "Landroid/widget/FrameLayout;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o", "k", "j", "i", "", "g", "", tl.h.F, "", "hintText", "actionText", QZoneShareManager.QZONE_SHARE_VIDEO_TEXT, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "showInput", "callback", DomainData.DOMAIN_NAME, "Landroid/view/View;", "d", "Landroid/view/View;", "mInputLayout", "Landroid/widget/EditText;", "e", "Landroid/widget/EditText;", "mInputTextView", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "mActionBtn", "I", "mUsableHeightPrevious", "Z", "mShowingInputLayout", "Lkotlin/jvm/functions/Function1;", "mCallback", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "mLayoutListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "D", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildMediaThirdAppInputLayout extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final ViewTreeObserver.OnGlobalLayoutListener mLayoutListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View mInputLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final EditText mInputTextView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView mActionBtn;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mUsableHeightPrevious;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean mShowingInputLayout;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<? super Boolean, Unit> mCallback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildMediaThirdAppInputLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R.layout.eyc, this);
        View findViewById = findViewById(R.id.f96625i7);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.third_app_input_layout)");
        this.mInputLayout = findViewById;
        View findViewById2 = findViewById(R.id.f96615i6);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.third_app_input_edit)");
        this.mInputTextView = (EditText) findViewById2;
        View findViewById3 = findViewById(R.id.f96605i5);
        TextView _init_$lambda$0 = (TextView) findViewById3;
        Intrinsics.checkNotNullExpressionValue(_init_$lambda$0, "_init_$lambda$0");
        kotlin.b.b(_init_$lambda$0, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.media.widget.GuildMediaThirdAppInputLayout$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                GuildMediaThirdAppInputLayout.this.j();
            }
        });
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById<TextView?>(\u2026tionClicked() }\n        }");
        this.mActionBtn = _init_$lambda$0;
        setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.widget.ac
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildMediaThirdAppInputLayout.c(GuildMediaThirdAppInputLayout.this, view);
            }
        });
        this.mLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.tencent.mobileqq.guild.media.widget.ad
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                GuildMediaThirdAppInputLayout.l(GuildMediaThirdAppInputLayout.this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(GuildMediaThirdAppInputLayout this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.i();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final boolean g() {
        return NetworkUtil.isNetworkAvailable(null);
    }

    private final int h() {
        Rect rect = new Rect();
        this.mInputLayout.getWindowVisibleDisplayFrame(rect);
        return rect.bottom - rect.top;
    }

    private final void i() {
        Logger.f235387a.d().d("GuildMediaThirdAppInputLayout", 1, "handleClickedBlankArea");
        com.tencent.mobileqq.guild.media.core.j.d().i(new com.tencent.mobileqq.guild.media.core.notify.ay(false, ""));
        k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        if (!g()) {
            com.tencent.mobileqq.guild.util.qqui.g.c(1, R.string.f1499713q);
            com.tencent.mobileqq.guild.media.core.j.d().i(new com.tencent.mobileqq.guild.media.core.notify.ay(false, ""));
            k();
            return;
        }
        String obj = this.mInputTextView.getText().toString();
        this.mInputTextView.setText("");
        Logger.f235387a.d().d("GuildMediaThirdAppInputLayout", 1, "handleInputActionClicked, size " + obj.length());
        com.tencent.mobileqq.guild.media.core.j.a().d0().s2(obj, new Function4<Integer, String, Boolean, String, Unit>() { // from class: com.tencent.mobileqq.guild.media.widget.GuildMediaThirdAppInputLayout$handleInputActionClicked$2
            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str, Boolean bool, String str2) {
                invoke(num.intValue(), str, bool.booleanValue(), str2);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, @NotNull String errMsg, boolean z16, @NotNull String encryptedText) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                Intrinsics.checkNotNullParameter(encryptedText, "encryptedText");
                Logger.f235387a.d().i("GuildMediaThirdAppInputLayout", 1, "handleInputActionClicked: requestThirdAppInputTextCheck. ret[" + i3 + "] errMsg[" + errMsg + "] isPass[" + z16 + "] text[" + encryptedText + "]");
                if (i3 == 0 && z16) {
                    com.tencent.mobileqq.guild.media.core.j.d().i(new com.tencent.mobileqq.guild.media.core.notify.ay(true, encryptedText.toString()));
                } else {
                    com.tencent.mobileqq.guild.media.core.j.d().i(new com.tencent.mobileqq.guild.media.core.notify.ay(true, ""));
                }
            }
        });
        k();
    }

    private final void k() {
        InputMethodUtil.hide(this.mInputTextView);
        m();
        Logger.f235387a.d().d("GuildMediaThirdAppInputLayout", 1, "hideSoftInputMethod");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(GuildMediaThirdAppInputLayout this$0) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int h16 = this$0.h();
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GuildMediaThirdAppInputLayout", 2, "onGlobalLayout: show[" + this$0.mShowingInputLayout + "] previous[" + this$0.mUsableHeightPrevious + "] now[" + h16 + "] height[" + this$0.getHeight() + "] rootHeight[" + this$0.getRootView().getHeight() + "]");
        }
        if (h16 != this$0.mUsableHeightPrevious) {
            int height = this$0.getRootView().getHeight();
            if (height - h16 > height / 4) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (this$0.mShowingInputLayout && !z16) {
                this$0.m();
            }
            this$0.mShowingInputLayout = z16;
            this$0.mUsableHeightPrevious = h16;
        }
    }

    private final void m() {
        getViewTreeObserver().removeOnGlobalLayoutListener(this.mLayoutListener);
        this.mShowingInputLayout = false;
        this.mUsableHeightPrevious = 0;
        setVisibility(8);
        this.mInputTextView.setHint("");
        this.mActionBtn.setText("");
        Function1<? super Boolean, Unit> function1 = this.mCallback;
        if (function1 != null) {
            function1.invoke(Boolean.FALSE);
        }
    }

    private final void o() {
        this.mInputTextView.setFocusable(true);
        this.mInputTextView.requestFocus();
        InputMethodUtil.show(this.mInputTextView);
        Logger.f235387a.d().d("GuildMediaThirdAppInputLayout", 1, "showSoftInputMethod");
    }

    public final void n(@NotNull String hintText, @NotNull String actionText, @NotNull String defaultText, @NotNull Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(hintText, "hintText");
        Intrinsics.checkNotNullParameter(actionText, "actionText");
        Intrinsics.checkNotNullParameter(defaultText, "defaultText");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.mCallback = callback;
        getViewTreeObserver().addOnGlobalLayoutListener(this.mLayoutListener);
        setVisibility(0);
        this.mInputTextView.setHint(hintText);
        this.mActionBtn.setText(actionText);
        if (!TextUtils.isEmpty(defaultText)) {
            this.mInputTextView.setText(defaultText);
            this.mInputTextView.setSelection(defaultText.length());
        }
        Function1<? super Boolean, Unit> function1 = this.mCallback;
        if (function1 != null) {
            function1.invoke(Boolean.TRUE);
        }
        o();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildMediaThirdAppInputLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R.layout.eyc, this);
        View findViewById = findViewById(R.id.f96625i7);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.third_app_input_layout)");
        this.mInputLayout = findViewById;
        View findViewById2 = findViewById(R.id.f96615i6);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.third_app_input_edit)");
        this.mInputTextView = (EditText) findViewById2;
        View findViewById3 = findViewById(R.id.f96605i5);
        TextView _init_$lambda$0 = (TextView) findViewById3;
        Intrinsics.checkNotNullExpressionValue(_init_$lambda$0, "_init_$lambda$0");
        kotlin.b.b(_init_$lambda$0, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.media.widget.GuildMediaThirdAppInputLayout$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                GuildMediaThirdAppInputLayout.this.j();
            }
        });
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById<TextView?>(\u2026tionClicked() }\n        }");
        this.mActionBtn = _init_$lambda$0;
        setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.widget.ac
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildMediaThirdAppInputLayout.c(GuildMediaThirdAppInputLayout.this, view);
            }
        });
        this.mLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.tencent.mobileqq.guild.media.widget.ad
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                GuildMediaThirdAppInputLayout.l(GuildMediaThirdAppInputLayout.this);
            }
        };
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildMediaThirdAppInputLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R.layout.eyc, this);
        View findViewById = findViewById(R.id.f96625i7);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.third_app_input_layout)");
        this.mInputLayout = findViewById;
        View findViewById2 = findViewById(R.id.f96615i6);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.third_app_input_edit)");
        this.mInputTextView = (EditText) findViewById2;
        View findViewById3 = findViewById(R.id.f96605i5);
        TextView _init_$lambda$0 = (TextView) findViewById3;
        Intrinsics.checkNotNullExpressionValue(_init_$lambda$0, "_init_$lambda$0");
        kotlin.b.b(_init_$lambda$0, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.media.widget.GuildMediaThirdAppInputLayout$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                GuildMediaThirdAppInputLayout.this.j();
            }
        });
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById<TextView?>(\u2026tionClicked() }\n        }");
        this.mActionBtn = _init_$lambda$0;
        setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.widget.ac
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildMediaThirdAppInputLayout.c(GuildMediaThirdAppInputLayout.this, view);
            }
        });
        this.mLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.tencent.mobileqq.guild.media.widget.ad
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                GuildMediaThirdAppInputLayout.l(GuildMediaThirdAppInputLayout.this);
            }
        };
    }
}
