package com.tencent.mobileqq.gamecenter.qa.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.EditText;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.gamecenter.qa.model.GameQALinkCardData;
import com.tencent.mobileqq.gamecenter.qa.model.LinkType;
import com.tencent.mobileqq.gamecenter.qa.util.GameQAUtil;
import com.tencent.mobileqq.gamecenter.qa.view.ab;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItemPriorityHelper;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuNoIconLayout;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.BubblePopupWindow;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 X2\u00020\u0001:\u0001YB\u000f\u0012\u0006\u0010U\u001a\u00020T\u00a2\u0006\u0004\bV\u0010WJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0000H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J>\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0018H\u0002J2\u0010\"\u001a\u0004\u0018\u00010!2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010 \u001a\u0004\u0018\u00010\u0014H\u0002J\u0006\u0010#\u001a\u00020\u0000J6\u0010+\u001a\u00020\u00042\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u00182\u0006\u0010*\u001a\u00020\u0018J\u0006\u0010-\u001a\u00020,J\u000e\u0010/\u001a\u00020\u00102\u0006\u0010.\u001a\u00020\u0018J\u001a\u00101\u001a\u00020\u00042\b\u0010%\u001a\u0004\u0018\u0001002\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0006\u00102\u001a\u00020\u0010JR\u0010>\u001a\u00020\u00042\u0006\u00104\u001a\u0002032\b\u00106\u001a\u0004\u0018\u0001052\u0006\u00107\u001a\u00020\u00182\u0006\u00108\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u0002092\u0006\u0010:\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010;\u001a\u00020\u00182\u0006\u0010=\u001a\u00020<H\u0016J\b\u0010?\u001a\u0004\u0018\u00010\u0010J\b\u0010@\u001a\u0004\u0018\u00010\u0010R\u0016\u0010B\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010AR\u0016\u0010C\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010AR\u0018\u0010E\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010DR\u001e\u0010H\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001000F8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010GR\u0018\u0010J\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010IR\u0018\u0010L\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010KR\u0018\u0010N\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010KR\"\u0010.\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bO\u0010A\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010S\u00a8\u0006Z"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/view/w;", "Landroid/text/style/ImageSpan;", "Lcom/tencent/mobileqq/gamecenter/qa/view/ab;", "linkSpan", "", "u", "", "o", "Landroid/view/View;", "view", "w", "linkCardSpan", ReportConstant.COSTREPORT_PREFIX, "p", "e", "r", "", tl.h.F, "Lcom/tencent/mobileqq/utils/dialogutils/a;", "menu", "Landroid/view/View$OnClickListener;", "onClickListener", "Lcom/tencent/widget/BubblePopupWindow$OnDismissListener;", "onDismissListener", "", HippyTKDListViewAdapter.X, "y", "Lcom/tencent/widget/BubblePopupWindow;", "v", "popup", "Landroid/content/Context;", "ctx", "listener", "Lcom/tencent/mobileqq/utils/dialogutils/QQCustomMenuNoIconLayout;", "g", "f", "Lcom/tencent/mobileqq/gamecenter/qa/view/GameStrategyEditTextView;", "editText", "rawX", "rawY", "lineTop", "lineBottom", DebugKt.DEBUG_PROPERTY_VALUE_OFF, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/gamecenter/qa/model/GameQALinkCardData;", "l", "index", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/EditText;", "d", "i", "Landroid/graphics/Canvas;", PM.CANVAS, "", "text", "start", "end", "", "top", "bottom", "Landroid/graphics/Paint;", "paint", "draw", DomainData.DOMAIN_NAME, "k", "I", "mPopX", "mPopY", "Lcom/tencent/mobileqq/gamecenter/qa/view/ab;", "mLinkSpan", "Ljava/lang/ref/WeakReference;", "Ljava/lang/ref/WeakReference;", "mEditTextViewRef", "Lcom/tencent/mobileqq/gamecenter/qa/model/GameQALinkCardData;", "mLinkCardData", "Ljava/lang/String;", "mTitle", BdhLogUtil.LogTag.Tag_Conn, "mLink", "D", "j", "()I", "t", "(I)V", "Landroid/graphics/drawable/Drawable;", "drawable", "<init>", "(Landroid/graphics/drawable/Drawable;)V", "E", "a", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class w extends ImageSpan {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private String mLink;

    /* renamed from: D, reason: from kotlin metadata */
    private int index;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int mPopX;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int mPopY;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ab mLinkSpan;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private WeakReference<EditText> mEditTextViewRef;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GameQALinkCardData mLinkCardData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mTitle;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/view/w$a;", "", "Landroid/graphics/Bitmap;", "cardBitmap", "Lcom/tencent/mobileqq/gamecenter/qa/model/GameQALinkCardData;", "data", "Lcom/tencent/mobileqq/gamecenter/qa/view/w;", "a", "", "CARD_TAG", "Ljava/lang/String;", "NEW_LINE", "TAG", "<init>", "()V", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.gamecenter.qa.view.w$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final w a(@NotNull Bitmap cardBitmap, @NotNull GameQALinkCardData data) {
            Intrinsics.checkNotNullParameter(cardBitmap, "cardBitmap");
            Intrinsics.checkNotNullParameter(data, "data");
            BitmapDrawable bitmapDrawable = new BitmapDrawable(cardBitmap);
            float screenWidth = (ViewUtils.getScreenWidth() - com.tencent.mobileqq.utils.x.a(52.0f)) / cardBitmap.getWidth();
            bitmapDrawable.setBounds(0, 0, (int) (cardBitmap.getWidth() * screenWidth), (int) (cardBitmap.getHeight() * screenWidth));
            w wVar = new w(bitmapDrawable);
            wVar.mLinkCardData = data;
            return wVar;
        }

        Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(@NotNull Drawable drawable) {
        super(drawable);
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        this.mEditTextViewRef = new WeakReference<>(null);
    }

    private final void e() {
        if (GameQAUtil.b(k())) {
            QQToast.makeText(BaseApplication.context, R.string.f1370605u, 0).show();
        }
    }

    private final QQCustomMenuNoIconLayout g(BubblePopupWindow popup, Context ctx, com.tencent.mobileqq.utils.dialogutils.a menu, View.OnClickListener listener) {
        if (popup != null) {
            popup.setFocusable(false);
        }
        QQCustomMenuItemPriorityHelper.d(menu);
        QQCustomMenuNoIconLayout qQCustomMenuNoIconLayout = new QQCustomMenuNoIconLayout(ctx);
        qQCustomMenuNoIconLayout.setGravity(17);
        qQCustomMenuNoIconLayout.setPadding(0, 0, 0, 0);
        qQCustomMenuNoIconLayout.setPopupWindow(popup, null);
        qQCustomMenuNoIconLayout.setMenu(menu);
        qQCustomMenuNoIconLayout.setMenuIconClickListener(listener);
        qQCustomMenuNoIconLayout.D();
        return qQCustomMenuNoIconLayout;
    }

    private final String h() {
        return "\n\u5361\u7247_" + com.tencent.mobileqq.gamecenter.qa.manager.b.INSTANCE.a(n(), k()) + "\n";
    }

    private final boolean o() {
        LinkType linkType;
        GameQALinkCardData gameQALinkCardData = this.mLinkCardData;
        if (gameQALinkCardData != null) {
            linkType = gameQALinkCardData.getLinkType();
        } else {
            linkType = null;
        }
        if (linkType == LinkType.REFERENCE_TYPE_XWORLD) {
            return true;
        }
        return false;
    }

    private final void p() {
        ab abVar = this.mLinkSpan;
        if (abVar != null) {
            abVar.w();
        }
    }

    private final void r() {
        EditText editText;
        WeakReference<EditText> weakReference = this.mEditTextViewRef;
        if (weakReference != null) {
            editText = weakReference.get();
        } else {
            editText = null;
        }
        if (editText != null) {
            editText.getEditableText().removeSpan(this);
        }
    }

    private final void s(w linkCardSpan) {
        ab.b mListener;
        EditText editText = this.mEditTextViewRef.get();
        if (editText != null) {
            GameQAUtil.c(linkCardSpan, editText);
            ab a16 = ab.INSTANCE.a(k(), n(), true);
            ab abVar = this.mLinkSpan;
            this.mLinkSpan = a16;
            a16.i(editText);
            if (abVar != null && (mListener = abVar.getMListener()) != null) {
                a16.D(mListener);
            }
        }
    }

    private final void u(ab linkSpan) {
        this.mLinkSpan = linkSpan;
        this.mTitle = linkSpan.getMTitle();
        this.mLink = linkSpan.getMLink();
    }

    private final BubblePopupWindow v(View view, com.tencent.mobileqq.utils.dialogutils.a menu, View.OnClickListener onClickListener, BubblePopupWindow.OnDismissListener onDismissListener, int x16, int y16) {
        BubblePopupWindow bubblePopupWindow = new BubblePopupWindow(-2, -2);
        bubblePopupWindow.setContentView(g(bubblePopupWindow, view.getContext(), menu, onClickListener));
        bubblePopupWindow.setOnDismissListener(onDismissListener);
        bubblePopupWindow.setBackgroundDrawable(new ColorDrawable(0));
        bubblePopupWindow.setOutsideTouchable(true);
        bubblePopupWindow.setFocusable(false);
        bubblePopupWindow.showAtLocation(view, x16, y16);
        return bubblePopupWindow;
    }

    private final void w(final View view) {
        com.tencent.mobileqq.utils.dialogutils.a aVar = new com.tencent.mobileqq.utils.dialogutils.a();
        if (!o()) {
            aVar.a(R.id.vk8, BaseApplication.getContext().getString(R.string.f1370705v));
            aVar.a(R.id.vk7, BaseApplication.getContext().getString(R.string.f1370505t));
        }
        aVar.a(R.id.vkb, BaseApplication.getContext().getString(R.string.f13713061));
        if (!o()) {
            aVar.a(R.id.vka, BaseApplication.getContext().getString(R.string.f1371005y));
        }
        v(view, aVar, new View.OnClickListener() { // from class: com.tencent.mobileqq.gamecenter.qa.view.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                w.x(w.this, view2);
            }
        }, new BubblePopupWindow.OnDismissListener() { // from class: com.tencent.mobileqq.gamecenter.qa.view.v
            @Override // com.tencent.widget.BubblePopupWindow.OnDismissListener
            public final void onDismiss() {
                w.y(view);
            }
        }, this.mPopX, this.mPopY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(w this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int id5 = view.getId();
        if (id5 == R.id.vk8) {
            this$0.p();
        } else if (id5 == R.id.vk7) {
            this$0.e();
        } else if (id5 == R.id.vkb) {
            this$0.r();
        } else if (id5 == R.id.vka) {
            this$0.s(this$0);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(View view) {
        Intrinsics.checkNotNullParameter(view, "$view");
        view.setSelected(false);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void d(@Nullable EditText editText, @NotNull ab linkSpan) {
        Intrinsics.checkNotNullParameter(linkSpan, "linkSpan");
        if (editText != null) {
            this.mEditTextViewRef = new WeakReference<>(editText);
            u(linkSpan);
            Editable editableText = editText.getEditableText();
            GameQAUtil.d(linkSpan, editText);
            SpannableString spannableString = new SpannableString(h());
            spannableString.setSpan(this, 1, spannableString.length() - 1, 33);
            int selectionStart = editText.getSelectionStart();
            if (selectionStart >= 0 && selectionStart < editableText.length()) {
                editableText.insert(selectionStart, spannableString);
                editText.setText(editableText);
                editText.setSelection(selectionStart + spannableString.length());
            } else {
                editableText.append((CharSequence) spannableString);
                editText.setText(editableText);
                editText.setSelection(editableText.length());
            }
            editText.requestFocus();
        }
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(@NotNull Canvas canvas, @Nullable CharSequence text, int start, int end, float x16, int top, int y16, int bottom, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        super.draw(canvas, text, start, end, x16, top, y16, bottom, paint);
    }

    @NotNull
    public final w f() {
        Drawable drawable = getDrawable();
        Intrinsics.checkNotNullExpressionValue(drawable, "drawable");
        w wVar = new w(drawable);
        wVar.mLinkCardData = this.mLinkCardData;
        wVar.mEditTextViewRef = new WeakReference<>(this.mEditTextViewRef.get());
        return wVar;
    }

    @NotNull
    public final String i() {
        return "\u5361\u7247_" + com.tencent.mobileqq.gamecenter.qa.manager.b.INSTANCE.a(n(), k());
    }

    /* renamed from: j, reason: from getter */
    public final int getIndex() {
        return this.index;
    }

    @Nullable
    public final String k() {
        String str = this.mLink;
        if (str == null) {
            GameQALinkCardData gameQALinkCardData = this.mLinkCardData;
            if (gameQALinkCardData != null) {
                return gameQALinkCardData.getUrl();
            }
            return null;
        }
        return str;
    }

    @NotNull
    public final GameQALinkCardData l() {
        GameQALinkCardData gameQALinkCardData = this.mLinkCardData;
        Intrinsics.checkNotNull(gameQALinkCardData);
        return gameQALinkCardData;
    }

    @NotNull
    public final String m(int index) {
        String encode;
        String str = "";
        if (TextUtils.isEmpty(k())) {
            encode = "";
        } else {
            encode = URLEncoder.encode(k(), "UTF-8");
        }
        if (!TextUtils.isEmpty(n())) {
            str = URLEncoder.encode(n(), "UTF-8");
        }
        return "{{link:" + encode + "|" + str + "|" + index + "}}";
    }

    @Nullable
    public final String n() {
        String str = this.mTitle;
        if (str == null) {
            GameQALinkCardData gameQALinkCardData = this.mLinkCardData;
            if (gameQALinkCardData != null) {
                return gameQALinkCardData.getTitle();
            }
            return null;
        }
        return str;
    }

    public final void q(@NotNull GameStrategyEditTextView editText, int rawX, int rawY, int lineTop, int lineBottom, int off) {
        Intrinsics.checkNotNullParameter(editText, "editText");
        editText.getEditableText().getSpanEnd(this);
        editText.getEditableText().getSpanStart(this);
        int[] iArr = new int[2];
        editText.getLocationOnScreen(iArr);
        this.mPopX = rawX;
        this.mPopY = iArr[1] + lineTop;
        w(editText);
    }

    public final void t(int i3) {
        this.index = i3;
    }
}
