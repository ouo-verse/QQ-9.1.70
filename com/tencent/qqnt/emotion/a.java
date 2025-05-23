package com.tencent.qqnt.emotion;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.a;
import com.tencent.qqnt.emotion.info.SystemAndEmojiEmotionInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 Z2\u00020\u00012\u00020\u0002:\u0001'B\u0019\u0012\u0006\u0010)\u001a\u00020\u0018\u0012\b\u0010,\u001a\u0004\u0018\u00010*\u00a2\u0006\u0004\bX\u0010YJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0007H\u0002J\u0018\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J0\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0017\u001a\u00020\u0010H\u0002J \u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\b\u0010\u001f\u001a\u00020\u0005H\u0002J\u000e\u0010\"\u001a\u00020\u00052\u0006\u0010!\u001a\u00020 J\u001a\u0010&\u001a\u00020%2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010$\u001a\u00020#H\u0017J\b\u0010'\u001a\u00020\u0005H\u0016R\u0016\u0010)\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010(R\u0018\u0010,\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010+R\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010-R\u0016\u0010/\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010.R\u0016\u00100\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010.R\u0016\u00103\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00106\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010!\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010?\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010>R\u0018\u0010C\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010E\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010>R\u0018\u0010G\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010FR\u0018\u0010I\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010BR\u0018\u0010L\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0018\u0010O\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010Q\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u00102R\u0016\u0010S\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u00102R\u0016\u0010W\u001a\u00020T8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010V\u00a8\u0006["}, d2 = {"Lcom/tencent/qqnt/emotion/a;", "Landroid/view/View$OnTouchListener;", "Lcom/tencent/qqnt/a$a;", "Landroid/view/View;", "view", "", "g", "Lcom/tencent/qqnt/emotion/info/SystemAndEmojiEmotionInfo;", "infoSystemAndEmoji", "i", "", "density", "b", "info", "Landroid/widget/TextView;", "d", "", "width", "Landroid/view/ViewGroup$MarginLayoutParams;", "containerLp", "k", "height", "j", "e", "Landroid/content/Context;", "context", "contentView", "Landroid/graphics/drawable/Drawable;", "windowBg", "Landroid/widget/PopupWindow;", tl.h.F, "f", "Landroidx/recyclerview/widget/RecyclerView;", "currentView", "c", "Landroid/view/MotionEvent;", "event", "", "onTouch", "a", "Landroid/content/Context;", "mContext", "Lcom/tencent/qqnt/b;", "Lcom/tencent/qqnt/b;", "callback", UserInfo.SEX_FEMALE, "I", "screenHeight", "screenWidth", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "hasPerformedLongPress", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", "pointView", "D", "Landroidx/recyclerview/widget/RecyclerView;", "Landroid/widget/FrameLayout;", "E", "Landroid/widget/FrameLayout;", "windowContent", "Landroid/widget/RelativeLayout;", "Landroid/widget/RelativeLayout;", "popupEmo", "Landroid/widget/ImageView;", "G", "Landroid/widget/ImageView;", "popupEmoImage", "H", "showEmoRelativeLayout", "Landroid/widget/TextView;", "emoTitleTv", "J", "arrowImageView", "K", "Landroid/widget/PopupWindow;", "popupWindow", "L", "Lcom/tencent/qqnt/emotion/info/SystemAndEmojiEmotionInfo;", "pointInfoSystemAndEmoji", "M", "haveRemovedWindowContent", "N", "show", "Landroid/view/GestureDetector;", "P", "Landroid/view/GestureDetector;", "gestureDetector", "<init>", "(Landroid/content/Context;Lcom/tencent/qqnt/b;)V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a implements View.OnTouchListener, a.InterfaceC9443a {
    static IPatchRedirector $redirector_;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final Rect R;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private View pointView;

    /* renamed from: D, reason: from kotlin metadata */
    private RecyclerView currentView;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private FrameLayout windowContent;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private RelativeLayout popupEmo;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private ImageView popupEmoImage;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private RelativeLayout showEmoRelativeLayout;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private TextView emoTitleTv;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private ImageView arrowImageView;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private PopupWindow popupWindow;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private SystemAndEmojiEmotionInfo pointInfoSystemAndEmoji;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean haveRemovedWindowContent;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean show;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private GestureDetector gestureDetector;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Context mContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.b callback;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float density;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int screenHeight;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int screenWidth;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean hasPerformedLongPress;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qqnt/emotion/a$a;", "", "<init>", "()V", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.emotion.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34981);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
            R = new Rect();
        }
    }

    public a(@NotNull Context mContext, @Nullable com.tencent.qqnt.b bVar) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mContext, (Object) bVar);
            return;
        }
        this.mContext = mContext;
        this.callback = bVar;
        DisplayMetrics displayMetrics = mContext.getResources().getDisplayMetrics();
        this.density = displayMetrics.density;
        this.screenHeight = displayMetrics.heightPixels;
        this.screenWidth = displayMetrics.widthPixels;
        com.tencent.qqnt.a aVar = new com.tencent.qqnt.a();
        aVar.a(this);
        this.gestureDetector = new GestureDetector(this.mContext, aVar);
    }

    private final void b(SystemAndEmojiEmotionInfo infoSystemAndEmoji, float density) {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.showEmoRelativeLayout = new RelativeLayout(this.mContext);
        RelativeLayout relativeLayout = this.popupEmo;
        Intrinsics.checkNotNull(relativeLayout);
        relativeLayout.addView(linearLayout);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.weight = 1.0f;
        linearLayout.addView(this.showEmoRelativeLayout, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.addRule(2, R.id.utp);
        RelativeLayout relativeLayout2 = this.showEmoRelativeLayout;
        Intrinsics.checkNotNull(relativeLayout2);
        relativeLayout2.addView(this.popupEmoImage, layoutParams2);
        this.emoTitleTv = d(infoSystemAndEmoji);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(14);
        layoutParams3.addRule(12);
        float f16 = 18 * density;
        layoutParams3.bottomMargin = (int) f16;
        float f17 = 12 * density;
        int i3 = (int) f17;
        layoutParams3.leftMargin = i3;
        layoutParams3.rightMargin = i3;
        RelativeLayout relativeLayout3 = this.showEmoRelativeLayout;
        Intrinsics.checkNotNull(relativeLayout3);
        relativeLayout3.addView(this.emoTitleTv, layoutParams3);
        ImageView imageView = new ImageView(this.mContext);
        this.arrowImageView = imageView;
        Intrinsics.checkNotNull(imageView);
        imageView.setImageDrawable(ResourcesCompat.getDrawable(this.mContext.getResources(), R.drawable.f160673mt3, null));
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams((int) (f16 + 0.5f), (int) (f17 + 0.5f));
        layoutParams4.topMargin = -((int) ((density * 9.0f) + 0.5f));
        layoutParams4.gravity = 1;
        linearLayout.addView(this.arrowImageView, layoutParams4);
    }

    private final TextView d(SystemAndEmojiEmotionInfo info) {
        TextView textView = new TextView(this.mContext);
        textView.setText(com.tencent.qqnt.emotion.data.b.INSTANCE.c(info));
        textView.setId(R.id.utp);
        textView.setTextColor(Color.parseColor("#878B99"));
        textView.setGravity(17);
        textView.setSingleLine();
        textView.setLines(1);
        textView.setTextSize(12.0f);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        return textView;
    }

    private final int e() {
        if (this.mContext.getResources().getConfiguration().orientation == 2) {
            return this.mContext.getResources().getDisplayMetrics().heightPixels;
        }
        return this.mContext.getResources().getDisplayMetrics().widthPixels;
    }

    private final void f() {
        if (this.popupEmo != null && this.windowContent != null && !this.haveRemovedWindowContent && this.show) {
            this.haveRemovedWindowContent = true;
            PopupWindow popupWindow = this.popupWindow;
            if (popupWindow != null) {
                Intrinsics.checkNotNull(popupWindow);
                popupWindow.dismiss();
                this.popupWindow = null;
            }
            com.tencent.qqnt.b bVar = this.callback;
            if (bVar != null) {
                bVar.i0(this.pointInfoSystemAndEmoji);
            }
            this.show = false;
        }
    }

    private final void g(View view) {
        SystemAndEmojiEmotionInfo systemAndEmojiEmotionInfo;
        com.tencent.qqnt.b bVar;
        Object tag = view.getTag(R.id.uto);
        Intrinsics.checkNotNullExpressionValue(tag, "view.getTag(R.id.emotion_panel_tag)");
        if (tag instanceof SystemAndEmojiEmotionInfo) {
            systemAndEmojiEmotionInfo = (SystemAndEmojiEmotionInfo) tag;
        } else {
            systemAndEmojiEmotionInfo = null;
        }
        if (systemAndEmojiEmotionInfo != null && (bVar = this.callback) != null) {
            bVar.f0(systemAndEmojiEmotionInfo);
        }
    }

    private final PopupWindow h(Context context, View contentView, Drawable windowBg) {
        PopupWindow popupWindow = new PopupWindow(context);
        popupWindow.setWidth(-1);
        popupWindow.setHeight(-1);
        popupWindow.setFocusable(true);
        if (contentView.getParent() != null) {
            ViewParent parent = contentView.getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent).removeView(contentView);
        }
        popupWindow.setBackgroundDrawable(windowBg);
        popupWindow.setContentView(contentView);
        popupWindow.showAtLocation(new View(context), 0, 0, 0);
        return popupWindow;
    }

    private final void i(View view, SystemAndEmojiEmotionInfo infoSystemAndEmoji) {
        TextView textView;
        Context context = this.mContext;
        if (context instanceof Activity) {
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            if (!((Activity) context).isDestroyed()) {
                Context context2 = this.mContext;
                Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type android.app.Activity");
                if (((Activity) context2).isFinishing()) {
                    return;
                }
            } else {
                return;
            }
        }
        Drawable a16 = infoSystemAndEmoji.a();
        if (a16 == null) {
            return;
        }
        Rect rect = R;
        view.getGlobalVisibleRect(rect);
        if (this.windowContent == null) {
            this.windowContent = new FrameLayout(this.mContext);
            RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
            this.popupEmo = relativeLayout;
            Intrinsics.checkNotNull(relativeLayout);
            relativeLayout.setTag(infoSystemAndEmoji);
            ImageView imageView = new ImageView(this.mContext);
            this.popupEmoImage = imageView;
            Intrinsics.checkNotNull(imageView);
            imageView.setImageDrawable(a16);
            b(infoSystemAndEmoji, this.density);
            FrameLayout frameLayout = this.windowContent;
            Intrinsics.checkNotNull(frameLayout);
            frameLayout.addView(this.popupEmo);
        }
        ImageView imageView2 = this.popupEmoImage;
        Intrinsics.checkNotNull(imageView2);
        ViewGroup.LayoutParams layoutParams = imageView2.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        float f16 = this.density;
        int i3 = (int) (94 * f16);
        int i16 = (int) (97 * f16);
        layoutParams2.width = (int) (f16 * 30.0f);
        layoutParams2.height = (int) (f16 * 30.0f);
        if (this.showEmoRelativeLayout != null && (textView = this.emoTitleTv) != null && this.arrowImageView != null) {
            Intrinsics.checkNotNull(textView);
            textView.setVisibility(0);
            ImageView imageView3 = this.arrowImageView;
            Intrinsics.checkNotNull(imageView3);
            imageView3.setVisibility(0);
            RelativeLayout relativeLayout2 = this.showEmoRelativeLayout;
            Intrinsics.checkNotNull(relativeLayout2);
            relativeLayout2.setBackgroundResource(R.drawable.f160672mt2);
        }
        layoutParams2.bottomMargin = (int) (6 * this.density);
        layoutParams2.addRule(14);
        layoutParams2.addRule(15);
        RelativeLayout relativeLayout3 = this.popupEmo;
        Intrinsics.checkNotNull(relativeLayout3);
        ViewGroup.LayoutParams layoutParams3 = relativeLayout3.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) layoutParams3;
        layoutParams4.gravity = 8388659;
        k(i3, layoutParams4);
        int i17 = rect.top - i16;
        float f17 = this.density;
        layoutParams4.topMargin = i17 - ((int) (15 * f17));
        layoutParams4.width = i3;
        layoutParams4.height = i16;
        j(view, f17, i3, i16, layoutParams4);
        if (this.windowContent != null) {
            PopupWindow popupWindow = this.popupWindow;
            if (popupWindow != null) {
                Intrinsics.checkNotNull(popupWindow);
                if (popupWindow.isShowing()) {
                    PopupWindow popupWindow2 = this.popupWindow;
                    Intrinsics.checkNotNull(popupWindow2);
                    popupWindow2.dismiss();
                }
            }
            Context context3 = this.mContext;
            View view2 = this.windowContent;
            Intrinsics.checkNotNull(view2);
            this.popupWindow = h(context3, view2, new ColorDrawable(0));
        }
        this.haveRemovedWindowContent = false;
        this.show = true;
        SystemAndEmojiEmotionInfo systemAndEmojiEmotionInfo = this.pointInfoSystemAndEmoji;
        this.pointInfoSystemAndEmoji = infoSystemAndEmoji;
        com.tencent.qqnt.b bVar = this.callback;
        if (bVar != null) {
            bVar.g0(systemAndEmojiEmotionInfo, infoSystemAndEmoji, a16);
        }
    }

    private final void j(View view, float density, int width, int height, ViewGroup.MarginLayoutParams containerLp) {
        if (this.arrowImageView != null) {
            containerLp.topMargin = (R.top - height) - ((int) (32 * density));
            int width2 = (int) (((int) (r0.left + (view.getWidth() / 2.0f))) - (containerLp.leftMargin + (width / 2.0f)));
            ImageView imageView = this.arrowImageView;
            Intrinsics.checkNotNull(imageView);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.leftMargin = width2;
                ImageView imageView2 = this.arrowImageView;
                Intrinsics.checkNotNull(imageView2);
                imageView2.setLayoutParams(layoutParams);
            }
        }
    }

    private final void k(int width, ViewGroup.MarginLayoutParams containerLp) {
        Rect rect = R;
        int width2 = rect.left - ((width - rect.width()) / 2);
        containerLp.leftMargin = width2;
        if (width2 + width >= e()) {
            containerLp.leftMargin = e() - width;
        } else if (containerLp.leftMargin <= 0) {
            containerLp.leftMargin = 0;
        }
    }

    @Override // com.tencent.qqnt.a.InterfaceC9443a
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        this.hasPerformedLongPress = true;
        View view = this.pointView;
        if (view != null) {
            RecyclerView recyclerView = null;
            if (view.getTag(R.id.uto) instanceof SystemAndEmojiEmotionInfo) {
                Object tag = view.getTag(R.id.uto);
                Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tencent.qqnt.emotion.info.SystemAndEmojiEmotionInfo");
                SystemAndEmojiEmotionInfo systemAndEmojiEmotionInfo = (SystemAndEmojiEmotionInfo) tag;
                com.tencent.qqnt.b bVar = this.callback;
                if (bVar != null) {
                    Intrinsics.checkNotNull(bVar);
                    if (bVar.h0(systemAndEmojiEmotionInfo)) {
                        this.pointView = null;
                        return;
                    }
                }
                i(view, systemAndEmojiEmotionInfo);
            }
            RecyclerView recyclerView2 = this.currentView;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentView");
            } else {
                recyclerView = recyclerView2;
            }
            recyclerView.requestDisallowInterceptTouchEvent(true);
        }
    }

    public final void c(@NotNull RecyclerView currentView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) currentView);
            return;
        }
        Intrinsics.checkNotNullParameter(currentView, "currentView");
        this.currentView = currentView;
        currentView.setClickable(true);
        currentView.setLongClickable(true);
    }

    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(@Nullable View view, @NotNull MotionEvent event) {
        View view2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, (Object) event)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(event, "event");
        this.gestureDetector.onTouchEvent(event);
        int action = event.getAction();
        if (action != 0) {
            RecyclerView recyclerView = null;
            if (action != 1) {
                if (action == 3) {
                    if (this.show) {
                        f();
                    }
                    View view3 = this.pointView;
                    if (view3 != null) {
                        view3.setAlpha(1.0f);
                    }
                    this.pointView = null;
                    RecyclerView recyclerView2 = this.currentView;
                    if (recyclerView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("currentView");
                    } else {
                        recyclerView = recyclerView2;
                    }
                    recyclerView.requestDisallowInterceptTouchEvent(false);
                }
            } else {
                if (this.show) {
                    f();
                }
                View view4 = this.pointView;
                if (view4 != null) {
                    if (!(!this.hasPerformedLongPress)) {
                        view4 = null;
                    }
                    if (view4 != null) {
                        g(view4);
                    }
                }
                this.windowContent = null;
                this.popupEmo = null;
                this.popupEmoImage = null;
                View view5 = this.pointView;
                if (view5 != null) {
                    view5.setAlpha(1.0f);
                }
                this.pointView = null;
                RecyclerView recyclerView3 = this.currentView;
                if (recyclerView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("currentView");
                } else {
                    recyclerView = recyclerView3;
                }
                recyclerView.requestDisallowInterceptTouchEvent(false);
            }
        } else {
            if (!Intrinsics.areEqual(this.pointView, view) && (view2 = this.pointView) != null) {
                view2.setAlpha(1.0f);
            }
            this.pointView = view;
            this.hasPerformedLongPress = false;
            if (view != null) {
                view.setAlpha(0.2f);
            }
        }
        return true;
    }
}
