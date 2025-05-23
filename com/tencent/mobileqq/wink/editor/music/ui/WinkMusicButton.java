package com.tencent.mobileqq.wink.editor.music.ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.wink.view.WinkRoundedCornerImageView;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 ;2\u00020\u00012\u00020\u0002:\u0002\"QB\u0011\b\u0016\u0012\u0006\u0010I\u001a\u00020H\u00a2\u0006\u0004\bJ\u0010KB\u001b\b\u0016\u0012\u0006\u0010I\u001a\u00020H\u0012\b\u0010M\u001a\u0004\u0018\u00010L\u00a2\u0006\u0004\bJ\u0010NB#\b\u0016\u0012\u0006\u0010I\u001a\u00020H\u0012\b\u0010M\u001a\u0004\u0018\u00010L\u0012\u0006\u0010O\u001a\u00020\b\u00a2\u0006\u0004\bJ\u0010PJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\f\u0010\t\u001a\u00020\b*\u00020\bH\u0002J<\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\bH\u0002J\u0014\u0010\u0015\u001a\u00020\u0003*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\bH\u0002J\u0006\u0010\u0016\u001a\u00020\u0003J\u0018\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\fJ\u000e\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0019J\u0018\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\bH\u0014J\u0010\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\fJ\"\u0010!\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u0011\u001a\u00020\bJ\b\u0010\"\u001a\u00020\u0003H\u0016J\u000e\u0010$\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u000fJ\u0010\u0010&\u001a\u00020\u00032\b\b\u0002\u0010%\u001a\u00020\fR\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\"\u00100\u001a\u00020\u00138\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b&\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010:\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u00109R\u0014\u0010<\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010;R\u0014\u0010>\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010;R\u0014\u0010@\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010;R\u0014\u0010B\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010;R\u0014\u0010D\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010;R\u0016\u0010G\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010F\u00a8\u0006R"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/music/ui/WinkMusicButton;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mobileqq/wink/editor/music/ui/a;", "", "j", "l", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "r", "Lcom/tencent/mobileqq/wink/editor/music/ui/WinkMusicButton$State;", "state", "", "musicTitle", "albumUrl", "", "requestLayout", "showClose", "c", "Landroid/view/View;", "extraPadding", "g", "setMusicOff", "title", "setMusicOn", "Landroid/view/View$OnClickListener;", "listener", "setCloseButtonListener", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", DomainData.DOMAIN_NAME, "name", "p", "a", NodeProps.VISIBLE, "setCloseBtnVisible", "elementId", "e", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "textView", "Landroid/view/View;", "i", "()Landroid/view/View;", "setCloseButton", "(Landroid/view/View;)V", "closeButton", "Landroid/widget/ProgressBar;", "f", "Landroid/widget/ProgressBar;", "progressView", "Lcom/tencent/mobileqq/wink/view/WinkRoundedCornerImageView;", h.F, "Lcom/tencent/mobileqq/wink/view/WinkRoundedCornerImageView;", "albumIcon", "Z", "closeButtonShow", "I", "musicIconSize", BdhLogUtil.LogTag.Tag_Conn, "textSize", "D", "textColor", "E", "textHorizontalMargin", UserInfo.SEX_FEMALE, "closeIconSize", "G", "Lcom/tencent/mobileqq/wink/editor/music/ui/WinkMusicButton$State;", "currentState", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "State", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkMusicButton extends LinearLayout implements a {

    /* renamed from: C */
    private final int textSize;

    /* renamed from: D, reason: from kotlin metadata */
    private final int textColor;

    /* renamed from: E, reason: from kotlin metadata */
    private final int textHorizontalMargin;

    /* renamed from: F */
    private final int closeIconSize;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private State currentState;

    @NotNull
    public Map<Integer, View> H;

    /* renamed from: d, reason: from kotlin metadata */
    private TextView textView;

    /* renamed from: e, reason: from kotlin metadata */
    public View closeButton;

    /* renamed from: f, reason: from kotlin metadata */
    private ProgressBar progressView;

    /* renamed from: h */
    private WinkRoundedCornerImageView albumIcon;

    /* renamed from: i, reason: from kotlin metadata */
    private boolean closeButtonShow;

    /* renamed from: m */
    private final int musicIconSize;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/music/ui/WinkMusicButton$State;", "", "(Ljava/lang/String;I)V", "IDLE", "ANIMATING", "LOADING", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public enum State {
        IDLE,
        ANIMATING,
        LOADING
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public /* synthetic */ class b {

        /* renamed from: a */
        public static final /* synthetic */ int[] f321145a;

        static {
            int[] iArr = new int[State.values().length];
            try {
                iArr[State.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[State.ANIMATING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f321145a = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WinkMusicButton(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void c(State state, String musicTitle, String albumUrl, boolean requestLayout, int showClose) {
        this.currentState = state;
        int i3 = b.f321145a[state.ordinal()];
        boolean z16 = true;
        TextView textView = null;
        if (i3 != 1) {
            if (i3 != 2) {
                i().setVisibility(showClose);
                WinkRoundedCornerImageView winkRoundedCornerImageView = this.albumIcon;
                if (winkRoundedCornerImageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("albumIcon");
                    winkRoundedCornerImageView = null;
                }
                winkRoundedCornerImageView.setVisibility(8);
                ProgressBar progressBar = this.progressView;
                if (progressBar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("progressView");
                    progressBar = null;
                }
                progressBar.setVisibility(0);
                TextView textView2 = this.textView;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("textView");
                    textView2 = null;
                }
                textView2.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                if (showClose == 0 && i().getVisibility() != 0 && !this.closeButtonShow) {
                    e("dt_imp");
                }
                i().setVisibility(showClose);
                WinkRoundedCornerImageView winkRoundedCornerImageView2 = this.albumIcon;
                if (winkRoundedCornerImageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("albumIcon");
                    winkRoundedCornerImageView2 = null;
                }
                winkRoundedCornerImageView2.setVisibility(0);
                ProgressBar progressBar2 = this.progressView;
                if (progressBar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("progressView");
                    progressBar2 = null;
                }
                progressBar2.setVisibility(8);
                TextView textView3 = this.textView;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("textView");
                    textView3 = null;
                }
                textView3.setText(musicTitle);
                TextView textView4 = this.textView;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("textView");
                    textView4 = null;
                }
                textView4.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, 0, 0);
                if (!TextUtils.isEmpty(albumUrl)) {
                    QCircleFeedPicLoader g16 = QCircleFeedPicLoader.g();
                    Option obtain = Option.obtain();
                    WinkRoundedCornerImageView winkRoundedCornerImageView3 = this.albumIcon;
                    if (winkRoundedCornerImageView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("albumIcon");
                        winkRoundedCornerImageView3 = null;
                    }
                    obtain.setTargetView(winkRoundedCornerImageView3);
                    obtain.setUrl(albumUrl);
                    obtain.setNeedShowLoadingDrawable(false);
                    g16.loadImage(obtain);
                } else {
                    WinkRoundedCornerImageView winkRoundedCornerImageView4 = this.albumIcon;
                    if (winkRoundedCornerImageView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("albumIcon");
                        winkRoundedCornerImageView4 = null;
                    }
                    winkRoundedCornerImageView4.setImageResource(R.drawable.ont);
                }
            }
        } else {
            i().setVisibility(showClose);
            WinkRoundedCornerImageView winkRoundedCornerImageView5 = this.albumIcon;
            if (winkRoundedCornerImageView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("albumIcon");
                winkRoundedCornerImageView5 = null;
            }
            winkRoundedCornerImageView5.setVisibility(8);
            ProgressBar progressBar3 = this.progressView;
            if (progressBar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("progressView");
                progressBar3 = null;
            }
            progressBar3.setVisibility(8);
            TextView textView5 = this.textView;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("textView");
                textView5 = null;
            }
            textView5.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.m4y, 0, 0, 0);
            TextView textView6 = this.textView;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("textView");
                textView6 = null;
            }
            textView6.setCompoundDrawablePadding(this.textHorizontalMargin);
        }
        TextView textView7 = this.textView;
        if (textView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textView");
        } else {
            textView = textView7;
        }
        textView.setText(musicTitle);
        if (requestLayout) {
            requestLayout();
        }
        if (showClose != 0) {
            z16 = false;
        }
        this.closeButtonShow = z16;
    }

    static /* synthetic */ void d(WinkMusicButton winkMusicButton, State state, String str, String str2, boolean z16, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            str = "\u9009\u62e9\u97f3\u4e50";
        }
        String str3 = str;
        if ((i16 & 4) != 0) {
            str2 = null;
        }
        String str4 = str2;
        if ((i16 & 8) != 0) {
            z16 = true;
        }
        boolean z17 = z16;
        if ((i16 & 16) != 0) {
            i3 = 8;
        }
        winkMusicButton.c(state, str3, str4, z17, i3);
    }

    public static /* synthetic */ void f(WinkMusicButton winkMusicButton, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = "dt_clck";
        }
        winkMusicButton.e(str);
    }

    private final void g(final View view, final int i3) {
        final ViewGroup viewGroup;
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            viewGroup = (ViewGroup) parent;
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            return;
        }
        viewGroup.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.music.ui.b
            @Override // java.lang.Runnable
            public final void run() {
                WinkMusicButton.h(view, i3, viewGroup);
            }
        });
    }

    public static final void h(View this_expandTouchArea, int i3, ViewGroup parentView) {
        Intrinsics.checkNotNullParameter(this_expandTouchArea, "$this_expandTouchArea");
        Intrinsics.checkNotNullParameter(parentView, "$parentView");
        Rect rect = new Rect();
        this_expandTouchArea.getHitRect(rect);
        rect.top -= i3;
        rect.bottom += i3;
        rect.left -= i3;
        rect.right += i3;
        parentView.setTouchDelegate(new TouchDelegate(rect, this_expandTouchArea));
    }

    private final void j() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        WinkRoundedCornerImageView winkRoundedCornerImageView = new WinkRoundedCornerImageView(context, null, 0, 6, null);
        setGravity(16);
        winkRoundedCornerImageView.setBackgroundColor(0);
        int c16 = x.c(winkRoundedCornerImageView.getContext(), 26.0f);
        float c17 = x.c(winkRoundedCornerImageView.getContext(), 6.0f);
        int c18 = x.c(winkRoundedCornerImageView.getContext(), 6.0f);
        winkRoundedCornerImageView.setCornerRadius(c17, c17, c17, c17);
        LinearLayoutCompat.LayoutParams layoutParams = new LinearLayoutCompat.LayoutParams(c16, c16);
        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = c18;
        addView(winkRoundedCornerImageView, layoutParams);
        this.albumIcon = winkRoundedCornerImageView;
    }

    private final void k() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        ImageView imageView = new ImageView(linearLayout.getContext());
        imageView.setImageResource(R.drawable.ons);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        linearLayout.addView(imageView, new LinearLayout.LayoutParams(x.c(linearLayout.getContext(), 1.0f), x.c(linearLayout.getContext(), 26.0f)));
        AppCompatImageView appCompatImageView = new AppCompatImageView(linearLayout.getContext());
        appCompatImageView.setImageResource(R.drawable.m3v);
        appCompatImageView.setContentDescription("\u5173\u95ed\u97f3\u4e50");
        int i3 = this.closeIconSize;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i3, i3);
        layoutParams.leftMargin = x.c(linearLayout.getContext(), 8.0f);
        linearLayout.addView(appCompatImageView, layoutParams);
        addView(linearLayout, new LinearLayout.LayoutParams(-2, -1));
        setCloseButton(linearLayout);
        g(i(), x.c(getContext(), 4.0f));
    }

    private final void l() {
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
        appCompatTextView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        appCompatTextView.setGravity(16);
        appCompatTextView.setMaxLines(1);
        appCompatTextView.setMarqueeRepeatLimit(-1);
        appCompatTextView.setSingleLine(true);
        appCompatTextView.setMaxWidth(r(108));
        appCompatTextView.setTextSize(0, appCompatTextView.getTextSize());
        appCompatTextView.setTextColor(this.textColor);
        appCompatTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.m4y, 0, 0, 0);
        appCompatTextView.setCompoundDrawablePadding(this.textHorizontalMargin);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        int i3 = this.textHorizontalMargin;
        layoutParams.leftMargin = i3;
        layoutParams.rightMargin = i3;
        addView(appCompatTextView, layoutParams);
        this.textView = appCompatTextView;
    }

    private final void m() {
        ProgressBar progressBar = new ProgressBar(getContext());
        int i3 = this.musicIconSize;
        addView(progressBar, new LinearLayout.LayoutParams(i3, i3));
        progressBar.setVisibility(8);
        this.progressView = progressBar;
    }

    public static /* synthetic */ void o(WinkMusicButton winkMusicButton, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = "\u914d\u4e50\u52a0\u8f7d\u4e2d";
        }
        winkMusicButton.n(str);
    }

    public static /* synthetic */ void q(WinkMusicButton winkMusicButton, String str, String str2, int i3, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            i3 = 0;
        }
        winkMusicButton.p(str, str2, i3);
    }

    private final int r(int i3) {
        return (int) TypedValue.applyDimension(1, i3, getResources().getDisplayMetrics());
    }

    @Override // com.tencent.mobileqq.wink.editor.music.ui.a
    public void a() {
        setSelected(false);
        d(this, State.IDLE, null, null, false, 0, 30, null);
    }

    public final void e(@NotNull String elementId) {
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        VideoReport.setElementId(i(), WinkDaTongReportConstant.ElementId.EM_XSJ_MUSIC_CLOSE_BUTTON);
        Map<String, Object> map = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(map, "map");
        map.put("xsj_music_id", WinkDatongCurrentParams.get("xsj_music_id"));
        map.put("xsj_music_name", WinkDatongCurrentParams.get("xsj_music_name"));
        VideoReport.setElementParams(i(), map);
        VideoReport.setElementClickPolicy(i(), ClickPolicy.REPORT_NONE);
        VideoReport.reportEvent(elementId, i(), map);
    }

    @NotNull
    public final View i() {
        View view = this.closeButton;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("closeButton");
        return null;
    }

    public final void n(@NotNull String musicTitle) {
        Intrinsics.checkNotNullParameter(musicTitle, "musicTitle");
        setSelected(false);
        d(this, State.LOADING, musicTitle, null, false, 8, 12, null);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public final void p(@NotNull String name, @Nullable String albumUrl, int showClose) {
        Intrinsics.checkNotNullParameter(name, "name");
        setSelected(true);
        c(State.ANIMATING, name, albumUrl, true, showClose);
    }

    public final void setCloseBtnVisible(boolean r26) {
        if (r26) {
            View i3 = i();
            if (i3 != null) {
                i3.setVisibility(0);
                return;
            }
            return;
        }
        View i16 = i();
        if (i16 != null) {
            i16.setVisibility(8);
        }
    }

    public final void setCloseButton(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.closeButton = view;
    }

    public final void setCloseButtonListener(@NotNull View.OnClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        i().setOnClickListener(listener);
    }

    public final void setMusicOff() {
        if (this.currentState != State.IDLE) {
            a();
        }
    }

    public final void setMusicOn(@NotNull String title, @Nullable String albumUrl) {
        boolean z16;
        Intrinsics.checkNotNullParameter(title, "title");
        if (this.currentState == State.ANIMATING) {
            TextView textView = this.textView;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("textView");
                textView = null;
            }
            CharSequence text = textView.getText();
            if (text == null) {
                text = "";
            }
            if (Intrinsics.areEqual(text, title)) {
                return;
            }
        }
        if (title.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            q(this, "\u89c6\u9891\u539f\u58f0", albumUrl, 0, 4, null);
        } else {
            q(this, title, albumUrl, 0, 4, null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WinkMusicButton(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkMusicButton(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.H = new LinkedHashMap();
        State state = State.IDLE;
        this.currentState = state;
        setOrientation(0);
        setGravity(17);
        this.musicIconSize = r(16);
        this.textSize = r(13);
        this.textColor = Color.parseColor("#FFFFFF");
        this.textHorizontalMargin = r(8);
        this.closeIconSize = r(18);
        m();
        j();
        l();
        k();
        d(this, state, null, null, false, 0, 30, null);
    }
}
