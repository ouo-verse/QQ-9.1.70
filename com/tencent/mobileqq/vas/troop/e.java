package com.tencent.mobileqq.vas.troop;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.RichTextHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.api.IVasUtilProxy;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 #2\u00020\u0001:\u0003\u0014\u0017\u0019BA\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0012\u0012\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00100\u0012\u00a2\u0006\u0004\b!\u0010\"JX\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000bH\u0002J\u0006\u0010\u0011\u001a\u00020\u0010R\"\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R \u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00100\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/vas/troop/e;", "", "Landroid/content/Context;", "context", "", "checkText", "titleText", "", "contentText", "lBtnText", "rBtnText", "Landroid/content/DialogInterface$OnClickListener;", "onConfirm", "onCancel", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", h.F, "", "j", "Lkotlin/Function1;", "", "a", "Lkotlin/jvm/functions/Function1;", "onLeftCallback", "b", "onRightCallback", "c", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "dialog", "d", "Z", "isChecked", "Lcom/tencent/mobileqq/vas/troop/e$c;", "data", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/vas/troop/e$c;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "e", "vas_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class e {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    private static DialogData f311007f;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Function1<Boolean, Unit> onLeftCallback;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<Boolean, Unit> onRightCallback;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QQCustomDialog dialog;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isChecked;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\r\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/vas/troop/e$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "text", "b", "url", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "vas_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vas.troop.e$a, reason: from toString */
    /* loaded from: classes20.dex */
    public static final /* data */ class Button {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String text;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String url;

        public Button() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getText() {
            return this.text;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Button)) {
                return false;
            }
            Button button = (Button) other;
            if (Intrinsics.areEqual(this.text, button.text) && Intrinsics.areEqual(this.url, button.url)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.text.hashCode() * 31) + this.url.hashCode();
        }

        @NotNull
        public String toString() {
            return "Button(text=" + this.text + ", url=" + this.url + ")";
        }

        public Button(@NotNull String text, @NotNull String url) {
            Intrinsics.checkNotNullParameter(text, "text");
            Intrinsics.checkNotNullParameter(url, "url");
            this.text = text;
            this.url = url;
        }

        public /* synthetic */ Button(String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/vas/troop/e$b;", "", "Lcom/tencent/mobileqq/vas/troop/e$c;", "cacheDialog", "Lcom/tencent/mobileqq/vas/troop/e$c;", "a", "()Lcom/tencent/mobileqq/vas/troop/e$c;", "b", "(Lcom/tencent/mobileqq/vas/troop/e$c;)V", "<init>", "()V", "vas_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vas.troop.e$b, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final DialogData a() {
            return e.f311007f;
        }

        public final void b(@Nullable DialogData dialogData) {
            e.f311007f = dialogData;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0018\u0012\u0006\u0010\u001d\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000e\u0010\fR\u001f\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0017\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u001c\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0012\u0010\u001bR\u0017\u0010\u001d\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u0019\u0010\u001b\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/vas/troop/e$c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "title", "b", "content", "", "Lcom/tencent/mobileqq/app/RichTextHelper$RichTextData;", "c", "Ljava/util/List;", "d", "()Ljava/util/List;", "richTexts", "checkText", "Lcom/tencent/mobileqq/vas/troop/e$a;", "e", "Lcom/tencent/mobileqq/vas/troop/e$a;", "()Lcom/tencent/mobileqq/vas/troop/e$a;", "leftButton", "rightButton", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lcom/tencent/mobileqq/vas/troop/e$a;Lcom/tencent/mobileqq/vas/troop/e$a;)V", "vas_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vas.troop.e$c, reason: from toString */
    /* loaded from: classes20.dex */
    public static final /* data */ class DialogData {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String title;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String content;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final List<RichTextHelper.RichTextData> richTexts;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String checkText;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final Button leftButton;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final Button rightButton;

        /* JADX WARN: Multi-variable type inference failed */
        public DialogData(@NotNull String title, @NotNull String content, @Nullable List<? extends RichTextHelper.RichTextData> list, @NotNull String checkText, @NotNull Button leftButton, @NotNull Button rightButton) {
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(content, "content");
            Intrinsics.checkNotNullParameter(checkText, "checkText");
            Intrinsics.checkNotNullParameter(leftButton, "leftButton");
            Intrinsics.checkNotNullParameter(rightButton, "rightButton");
            this.title = title;
            this.content = content;
            this.richTexts = list;
            this.checkText = checkText;
            this.leftButton = leftButton;
            this.rightButton = rightButton;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getCheckText() {
            return this.checkText;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getContent() {
            return this.content;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final Button getLeftButton() {
            return this.leftButton;
        }

        @Nullable
        public final List<RichTextHelper.RichTextData> d() {
            return this.richTexts;
        }

        @NotNull
        /* renamed from: e, reason: from getter */
        public final Button getRightButton() {
            return this.rightButton;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DialogData)) {
                return false;
            }
            DialogData dialogData = (DialogData) other;
            if (Intrinsics.areEqual(this.title, dialogData.title) && Intrinsics.areEqual(this.content, dialogData.content) && Intrinsics.areEqual(this.richTexts, dialogData.richTexts) && Intrinsics.areEqual(this.checkText, dialogData.checkText) && Intrinsics.areEqual(this.leftButton, dialogData.leftButton) && Intrinsics.areEqual(this.rightButton, dialogData.rightButton)) {
                return true;
            }
            return false;
        }

        @NotNull
        /* renamed from: f, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2 = ((this.title.hashCode() * 31) + this.content.hashCode()) * 31;
            List<RichTextHelper.RichTextData> list = this.richTexts;
            if (list == null) {
                hashCode = 0;
            } else {
                hashCode = list.hashCode();
            }
            return ((((((hashCode2 + hashCode) * 31) + this.checkText.hashCode()) * 31) + this.leftButton.hashCode()) * 31) + this.rightButton.hashCode();
        }

        @NotNull
        public String toString() {
            return "DialogData(title=" + this.title + ", content=" + this.content + ", richTexts=" + this.richTexts + ", checkText=" + this.checkText + ", leftButton=" + this.leftButton + ", rightButton=" + this.rightButton + ")";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(@NotNull final Context context, @NotNull final DialogData data, @Nullable Function1<? super Boolean, Unit> function1, @NotNull Function1<? super Boolean, Unit> onRightCallback) {
        boolean z16;
        TextView messageTextView;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(onRightCallback, "onRightCallback");
        this.onLeftCallback = function1;
        this.onRightCallback = onRightCallback;
        QQCustomDialog h16 = h(context, data.getCheckText(), data.getTitle(), data.getContent(), data.getLeftButton().getText(), data.getRightButton().getText(), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.vas.troop.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                e.d(e.this, data, context, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.vas.troop.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                e.e(e.this, data, context, dialogInterface, i3);
            }
        });
        if (data.getCheckText().length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && h16 != null) {
            h16.setCheckBox(data.getCheckText(), false, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.vas.troop.d
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    e.i(e.this, dialogInterface, i3);
                }
            });
        }
        List<RichTextHelper.RichTextData> d16 = data.d();
        if (d16 != null) {
            SpannableString buildSpannable = RichTextHelper.buildSpannable(data.getContent(), context, false, d16);
            if (h16 != null && (messageTextView = h16.getMessageTextView()) != null) {
                Intrinsics.checkNotNullExpressionValue(messageTextView, "messageTextView");
                messageTextView.setHintTextColor(0);
                messageTextView.setMovementMethod(RichTextHelper.getMovementMethodInstance());
                messageTextView.setText(buildSpannable);
                messageTextView.setContentDescription(buildSpannable);
                messageTextView.setVisibility(0);
            }
        }
        this.dialog = h16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(e this$0, DialogData data, Context context, DialogInterface dialogInterface, int i3) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        Intrinsics.checkNotNullParameter(context, "$context");
        QQCustomDialog qQCustomDialog = this$0.dialog;
        if (qQCustomDialog != null) {
            qQCustomDialog.dismiss();
        }
        if (data.getRightButton().getUrl().length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            ((IVasUtilProxy) QRoute.api(IVasUtilProxy.class)).openSchema(context, data.getRightButton().getUrl());
        }
        this$0.onRightCallback.invoke(Boolean.valueOf(this$0.isChecked));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(e this$0, DialogData data, Context context, DialogInterface dialogInterface, int i3) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        Intrinsics.checkNotNullParameter(context, "$context");
        QQCustomDialog qQCustomDialog = this$0.dialog;
        if (qQCustomDialog != null) {
            qQCustomDialog.dismiss();
        }
        if (data.getLeftButton().getUrl().length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            ((IVasUtilProxy) QRoute.api(IVasUtilProxy.class)).openSchema(context, data.getLeftButton().getUrl());
        }
        Function1<Boolean, Unit> function1 = this$0.onLeftCallback;
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(this$0.isChecked));
        }
    }

    private final QQCustomDialog h(Context context, String checkText, String titleText, CharSequence contentText, String lBtnText, String rBtnText, DialogInterface.OnClickListener onConfirm, DialogInterface.OnClickListener onCancel) {
        boolean z16;
        QQCustomDialog qQCustomDialog = new QQCustomDialog(context, R.style.qZoneInputDialog);
        if (checkText.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            qQCustomDialog.setContentView(R.layout.f167856jn);
        } else {
            qQCustomDialog.setContentView(R.layout.custom_dialog);
        }
        qQCustomDialog.setTitle(titleText);
        qQCustomDialog.setMessage(contentText);
        qQCustomDialog.setNegativeButton(lBtnText, onCancel);
        qQCustomDialog.setPositiveButton(rBtnText, onConfirm);
        qQCustomDialog.setCanceledOnTouchOutside(false);
        qQCustomDialog.getTitleTextView().setTypeface(Typeface.DEFAULT_BOLD);
        qQCustomDialog.getBtnight().setTypeface(Typeface.DEFAULT_BOLD);
        qQCustomDialog.getBtnLeft().setTypeface(Typeface.DEFAULT_BOLD);
        return qQCustomDialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(e this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean z16 = true;
        if (i3 != 1) {
            z16 = false;
        }
        this$0.isChecked = z16;
    }

    public final void j() {
        QQCustomDialog qQCustomDialog = this.dialog;
        if (qQCustomDialog != null) {
            qQCustomDialog.show();
        }
    }
}
