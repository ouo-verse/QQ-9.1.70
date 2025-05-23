package com.tencent.mobileqq.guild.channel.create.widget;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewStub;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.util.URLUtil;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 /2\u00020\u0001:\u0001\u0014B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u00a2\u0006\u0004\b?\u0010@J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002J\u0006\u0010\u0007\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\u0004J\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u0004R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0016\u001a\n \u0013*\u0004\u0018\u00010\u00120\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R#\u0010\u001b\u001a\n \u0013*\u0004\u0018\u00010\u000e0\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010!\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010\u0010R\u0014\u0010#\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010\u0010R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010)\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010\u0010R\u001b\u0010,\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b*\u0010\u0018\u001a\u0004\b+\u0010\u001aR\u001b\u00101\u001a\u00020-8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b.\u0010\u0018\u001a\u0004\b/\u00100R\u001b\u00104\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b2\u0010\u0018\u001a\u0004\b3\u0010\u001aR\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010=\u001a\u0002098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010;R\u0016\u0010>\u001a\u0002098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u0010;\u00a8\u0006A"}, d2 = {"Lcom/tencent/mobileqq/guild/channel/create/widget/SubChannelApplicationLinkController;", "", "", MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK, "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "r", DomainData.DOMAIN_NAME, "y", "t", "B", "w", "v", "u", "Landroid/view/View;", "a", "Landroid/view/View;", ParseCommon.CONTAINER, "Landroid/content/Context;", "kotlin.jvm.PlatformType", "b", "Landroid/content/Context;", "context", "c", "Lkotlin/Lazy;", ReportConstant.COSTREPORT_PREFIX, "()Landroid/view/View;", "view", "Landroid/widget/EditText;", "d", "Landroid/widget/EditText;", "linkEdit", "e", "hintText", "f", "errorHintText", "Landroid/widget/ImageView;", "g", "Landroid/widget/ImageView;", "errorHintIcon", h.F, "clearInput", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "pasteHintView", "Landroid/widget/TextView;", "j", "p", "()Landroid/widget/TextView;", "pasteHintTextView", "k", "o", "pasteHintClickArea", "Landroid/widget/PopupWindow;", "l", "Landroid/widget/PopupWindow;", "pasteTipPopupWindow", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "editTextActionModeShowing", "linkEditFocused", "resumed", "<init>", "(Landroid/view/View;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class SubChannelApplicationLinkController {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View container;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy view;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final EditText linkEdit;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View hintText;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View errorHintText;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView errorHintIcon;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View clearInput;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy pasteHintView;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy pasteHintTextView;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy pasteHintClickArea;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private PopupWindow pasteTipPopupWindow;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean editTextActionModeShowing;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private boolean linkEditFocused;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private boolean resumed;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/guild/channel/create/widget/SubChannelApplicationLinkController$c", "Landroid/view/ActionMode$Callback;", "Landroid/view/ActionMode;", "mode", "Landroid/view/Menu;", "menu", "", "onCreateActionMode", "onPrepareActionMode", "Landroid/view/MenuItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "onActionItemClicked", "", "onDestroyActionMode", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class c implements ActionMode.Callback {
        c() {
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(@NotNull ActionMode mode, @NotNull MenuItem item) {
            Intrinsics.checkNotNullParameter(mode, "mode");
            Intrinsics.checkNotNullParameter(item, "item");
            return false;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(@NotNull ActionMode mode, @NotNull Menu menu) {
            Intrinsics.checkNotNullParameter(mode, "mode");
            Intrinsics.checkNotNullParameter(menu, "menu");
            SubChannelApplicationLinkController.this.editTextActionModeShowing = true;
            SubChannelApplicationLinkController.this.u();
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(@NotNull ActionMode mode) {
            Intrinsics.checkNotNullParameter(mode, "mode");
            SubChannelApplicationLinkController.this.editTextActionModeShowing = false;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(@NotNull ActionMode mode, @NotNull Menu menu) {
            Intrinsics.checkNotNullParameter(mode, "mode");
            Intrinsics.checkNotNullParameter(menu, "menu");
            return false;
        }
    }

    public SubChannelApplicationLinkController(@NotNull View container) {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        Intrinsics.checkNotNullParameter(container, "container");
        this.container = container;
        this.context = container.getContext();
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<View>() { // from class: com.tencent.mobileqq.guild.channel.create.widget.SubChannelApplicationLinkController$view$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final View invoke() {
                View view;
                View view2;
                view = SubChannelApplicationLinkController.this.container;
                ViewStub viewStub = (ViewStub) view.findViewById(R.id.f89304ze);
                if (viewStub == null) {
                    view2 = SubChannelApplicationLinkController.this.container;
                    return view2.findViewById(R.id.sus);
                }
                return viewStub.inflate();
            }
        });
        this.view = lazy;
        View findViewById = s().findViewById(R.id.yj8);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.link_text)");
        EditText editText = (EditText) findViewById;
        this.linkEdit = editText;
        View findViewById2 = s().findViewById(R.id.d5s);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.hint)");
        this.hintText = findViewById2;
        View findViewById3 = s().findViewById(R.id.bya);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.error_hint)");
        this.errorHintText = findViewById3;
        View findViewById4 = s().findViewById(R.id.uwr);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.error_hint_icon)");
        this.errorHintIcon = (ImageView) findViewById4;
        View findViewById5 = s().findViewById(R.id.txo);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.clear_input)");
        this.clearInput = findViewById5;
        lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<View>() { // from class: com.tencent.mobileqq.guild.channel.create.widget.SubChannelApplicationLinkController$pasteHintView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final View invoke() {
                Context context;
                context = SubChannelApplicationLinkController.this.context;
                return View.inflate(context, R.layout.f1u, null);
            }
        });
        this.pasteHintView = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<TextView>() { // from class: com.tencent.mobileqq.guild.channel.create.widget.SubChannelApplicationLinkController$pasteHintTextView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TextView invoke() {
                View q16;
                q16 = SubChannelApplicationLinkController.this.q();
                return (TextView) q16.findViewById(R.id.f226804d);
            }
        });
        this.pasteHintTextView = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<View>() { // from class: com.tencent.mobileqq.guild.channel.create.widget.SubChannelApplicationLinkController$pasteHintClickArea$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final View invoke() {
                View q16;
                q16 = SubChannelApplicationLinkController.this.q();
                return q16.findViewById(R.id.f226904e);
            }
        });
        this.pasteHintClickArea = lazy4;
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.tencent.mobileqq.guild.channel.create.widget.b
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z16) {
                SubChannelApplicationLinkController.f(SubChannelApplicationLinkController.this, view, z16);
            }
        });
        editText.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.channel.create.widget.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SubChannelApplicationLinkController.g(SubChannelApplicationLinkController.this, view);
            }
        });
        editText.addTextChangedListener(new a());
        c cVar = new c();
        editText.setCustomSelectionActionModeCallback(cVar);
        editText.setCustomInsertionActionModeCallback(cVar);
        findViewById5.setVisibility(8);
        findViewById5.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.channel.create.widget.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SubChannelApplicationLinkController.h(SubChannelApplicationLinkController.this, view);
            }
        });
        t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(SubChannelApplicationLinkController this$0, String link, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(link, "$link");
        this$0.linkEdit.setText(link);
        EditText editText = this$0.linkEdit;
        editText.setSelection(editText.length());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(SubChannelApplicationLinkController this$0, View view, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.resumed) {
            this$0.linkEditFocused = z16;
        }
        this$0.B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(SubChannelApplicationLinkController this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.B();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(SubChannelApplicationLinkController this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.linkEdit.requestFocus();
        this$0.linkEdit.setText("");
        EventCollector.getInstance().onViewClicked(view);
    }

    private final View o() {
        Object value = this.pasteHintClickArea.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-pasteHintClickArea>(...)");
        return (View) value;
    }

    private final TextView p() {
        Object value = this.pasteHintTextView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-pasteHintTextView>(...)");
        return (TextView) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View q() {
        Object value = this.pasteHintView.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-pasteHintView>(...)");
        return (View) value;
    }

    private final String r() {
        Object systemService = this.context.getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ClipData primaryClip = ClipboardMonitor.getPrimaryClip((ClipboardManager) systemService);
        if (primaryClip != null && primaryClip.getItemCount() > 0) {
            CharSequence coerceToText = primaryClip.getItemAt(0).coerceToText(this.context);
            if (URLUtil.isValidUrl(coerceToText.toString())) {
                return coerceToText.toString();
            }
        }
        return null;
    }

    private final View s() {
        return (View) this.view.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(SubChannelApplicationLinkController this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.resumed && this$0.linkEditFocused) {
            this$0.linkEdit.requestFocus();
        }
        this$0.B();
    }

    private final void z(final String link) {
        boolean z16;
        PopupWindow popupWindow = this.pasteTipPopupWindow;
        if (popupWindow != null && popupWindow.isShowing()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        p().setText(link);
        PopupWindow popupWindow2 = new PopupWindow(q(), -1, -2);
        popupWindow2.showAsDropDown(this.linkEdit, 0, -(this.linkEdit.getHeight() + this.context.getResources().getDimensionPixelOffset(R.dimen.ci7) + QQGuildUIUtil.f(8.0f)), 1);
        o().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.channel.create.widget.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SubChannelApplicationLinkController.A(SubChannelApplicationLinkController.this, link, view);
            }
        });
        this.pasteTipPopupWindow = popupWindow2;
    }

    public final void B() {
        boolean z16;
        String r16 = r();
        if (!this.editTextActionModeShowing && this.linkEdit.hasFocus()) {
            Editable text = this.linkEdit.getText();
            boolean z17 = false;
            if (text != null && text.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                if (r16 == null || r16.length() == 0) {
                    z17 = true;
                }
                if (!z17) {
                    z(r16);
                    return;
                }
            }
        }
        u();
    }

    @NotNull
    public final String n() {
        String obj;
        CharSequence trim;
        Editable text = this.linkEdit.getText();
        if (text != null && (obj = text.toString()) != null) {
            trim = StringsKt__StringsKt.trim((CharSequence) obj);
            String obj2 = trim.toString();
            if (obj2 != null) {
                return obj2;
            }
        }
        return "";
    }

    public final void t() {
        this.errorHintText.setVisibility(8);
        this.hintText.setVisibility(0);
    }

    public final void u() {
        PopupWindow popupWindow = this.pasteTipPopupWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
        this.pasteTipPopupWindow = null;
    }

    public final void v() {
        this.resumed = false;
        Logger.f235387a.d().d("SubChannelApplicationLinkController", 1, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
    }

    public final void w() {
        Logger.f235387a.d().d("SubChannelApplicationLinkController", 1, "onResume");
        this.resumed = true;
        this.linkEdit.post(new Runnable() { // from class: com.tencent.mobileqq.guild.channel.create.widget.a
            @Override // java.lang.Runnable
            public final void run() {
                SubChannelApplicationLinkController.x(SubChannelApplicationLinkController.this);
            }
        });
    }

    public final void y() {
        this.errorHintText.setVisibility(0);
        this.hintText.setVisibility(8);
        Drawable drawable = this.errorHintIcon.getDrawable();
        if (drawable instanceof SkinnableBitmapDrawable) {
            this.errorHintIcon.setImageDrawable(((SkinnableBitmapDrawable) drawable).mutate2());
        }
        this.errorHintIcon.setColorFilter(Color.parseColor("#FF5765"));
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J*\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/guild/channel/create/widget/SubChannelApplicationLinkController$a", "Landroid/text/TextWatcher;", "", ReportConstant.COSTREPORT_PREFIX, "", "start", "count", "after", "", "beforeTextChanged", "before", "onTextChanged", "Landroid/text/Editable;", "afterTextChanged", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@Nullable Editable s16) {
            boolean z16;
            View view = SubChannelApplicationLinkController.this.clearInput;
            int i3 = 0;
            if (s16 != null && s16.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!(!z16)) {
                i3 = 8;
            }
            view.setVisibility(i3);
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@Nullable CharSequence s16, int start, int before, int count) {
            SubChannelApplicationLinkController.this.B();
            SubChannelApplicationLinkController.this.t();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@Nullable CharSequence s16, int start, int count, int after) {
        }
    }
}
