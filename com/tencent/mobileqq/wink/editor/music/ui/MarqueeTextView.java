package com.tencent.mobileqq.wink.editor.music.ui;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 <2\u00020\u00012\u00020\u0002:\u0002\u0013=B\u0011\b\u0016\u0012\u0006\u00103\u001a\u000202\u00a2\u0006\u0004\b4\u00105B\u0019\b\u0016\u0012\u0006\u00103\u001a\u000202\u0012\u0006\u00107\u001a\u000206\u00a2\u0006\u0004\b4\u00108B!\b\u0016\u0012\u0006\u00103\u001a\u000202\u0012\u0006\u00107\u001a\u000206\u0012\u0006\u0010:\u001a\u000209\u00a2\u0006\u0004\b4\u0010;J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0002J&\u0010\u0010\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000f\u001a\u00020\bH\u0002J\u000e\u0010\u0011\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rJ\b\u0010\u0013\u001a\u00020\u0003H\u0016J\u0010\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\rJ\u000e\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0016J\u0010\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\rR$\u0010!\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010'R$\u0010-\u001a\u00020)2\u0006\u0010*\u001a\u00020)8\u0006@BX\u0086.\u00a2\u0006\f\n\u0004\b\u0004\u0010+\u001a\u0004\b#\u0010,R\u0016\u0010/\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010.R\u0016\u00101\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u00100\u00a8\u0006>"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/music/ui/MarqueeTextView;", "Landroidx/appcompat/widget/LinearLayoutCompat;", "Lcom/tencent/mobileqq/wink/editor/music/ui/a;", "", h.F, "j", "i", "g", "", NodeProps.VISIBLE, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/wink/editor/music/ui/MarqueeTextView$State;", "marquee", "", "name", "requestLayout", "b", "setCloseBtnVisible", DomainData.DOMAIN_NAME, "a", "musicTitle", "k", "Landroid/view/View$OnClickListener;", "listener", "setCloseButtonListener", "elementId", "d", "Lcom/tencent/mobileqq/wink/editor/music/ui/LyricStyleStickerImageVIew;", "Lcom/tencent/mobileqq/wink/editor/music/ui/LyricStyleStickerImageVIew;", "f", "()Lcom/tencent/mobileqq/wink/editor/music/ui/LyricStyleStickerImageVIew;", "setLyricStyleStickerImageVIew", "(Lcom/tencent/mobileqq/wink/editor/music/ui/LyricStyleStickerImageVIew;)V", "lyricStyleStickerImageVIew", "Landroid/widget/ProgressBar;", "e", "Landroid/widget/ProgressBar;", "progressView", "Landroidx/appcompat/widget/AppCompatTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "textView", "Landroid/view/View;", "<set-?>", "Landroid/view/View;", "()Landroid/view/View;", "closeView", "Z", "closeButtonShow", "Lcom/tencent/mobileqq/wink/editor/music/ui/MarqueeTextView$State;", "state", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "D", "State", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class MarqueeTextView extends LinearLayoutCompat implements a {

    @NotNull
    public Map<Integer, View> C;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LyricStyleStickerImageVIew lyricStyleStickerImageVIew;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ProgressBar progressView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private AppCompatTextView textView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private View closeView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean closeButtonShow;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private State state;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/music/ui/MarqueeTextView$State;", "", "(Ljava/lang/String;I)V", "IDLE", "ANIMATING", "LOADING", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public enum State {
        IDLE,
        ANIMATING,
        LOADING
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MarqueeTextView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.C = new LinkedHashMap();
        setOrientation(0);
        setGravity(17);
        setBackgroundResource(R.drawable.l67);
        h();
        j();
        i();
        g();
        State state = State.IDLE;
        c(this, state, null, false, 2, null);
        this.state = state;
    }

    private final void b(State marquee, String name, boolean requestLayout) {
        boolean z16;
        this.state = marquee;
        boolean z17 = true;
        if (marquee != State.IDLE && marquee != State.LOADING) {
            z16 = true;
        } else {
            z16 = false;
        }
        setCloseBtnVisible(z16);
        if (marquee != State.LOADING) {
            z17 = false;
        }
        m(z17);
        AppCompatTextView appCompatTextView = this.textView;
        if (appCompatTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textView");
            appCompatTextView = null;
        }
        appCompatTextView.setText(name);
        if (requestLayout) {
            requestLayout();
        }
    }

    static /* synthetic */ void c(MarqueeTextView marqueeTextView, State state, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = "\u9009\u62e9\u97f3\u4e50";
        }
        if ((i3 & 4) != 0) {
            z16 = true;
        }
        marqueeTextView.b(state, str, z16);
    }

    private final void g() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        View view = new View(linearLayout.getContext());
        view.setBackgroundDrawable(new ColorDrawable(872415231));
        linearLayout.addView(view, new LinearLayout.LayoutParams(x.c(linearLayout.getContext(), 1.0f), -1));
        AppCompatImageView appCompatImageView = new AppCompatImageView(linearLayout.getContext());
        appCompatImageView.setImageResource(R.drawable.m3v);
        appCompatImageView.setContentDescription("\u5173\u95ed\u97f3\u4e50");
        int c16 = x.c(linearLayout.getContext(), 16.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(c16, c16);
        layoutParams.leftMargin = x.c(linearLayout.getContext(), 8.0f);
        linearLayout.addView(appCompatImageView, layoutParams);
        addView(linearLayout, new LinearLayout.LayoutParams(-2, -1));
        this.closeView = linearLayout;
    }

    private final void h() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        LyricStyleStickerImageVIew lyricStyleStickerImageVIew = new LyricStyleStickerImageVIew(context);
        int c16 = x.c(lyricStyleStickerImageVIew.getContext(), 34.0f);
        lyricStyleStickerImageVIew.setBackgroundColor(0);
        addView(lyricStyleStickerImageVIew, new LinearLayout.LayoutParams(c16, c16));
        this.lyricStyleStickerImageVIew = lyricStyleStickerImageVIew;
    }

    private final void i() {
        AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
        appCompatTextView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        appCompatTextView.setGravity(16);
        appCompatTextView.setMaxLines(1);
        appCompatTextView.setMarqueeRepeatLimit(-1);
        appCompatTextView.setMaxWidth(x.c(appCompatTextView.getContext(), 120.0f));
        appCompatTextView.setTextSize(12.0f);
        appCompatTextView.setSingleLine(true);
        appCompatTextView.setTextColor(appCompatTextView.getResources().getColorStateList(R.color.d08));
        appCompatTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.m4y, 0, 0, 0);
        appCompatTextView.setCompoundDrawablePadding(x.c(appCompatTextView.getContext(), 6.0f));
        LinearLayoutCompat.LayoutParams layoutParams = new LinearLayoutCompat.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = x.c(appCompatTextView.getContext(), 6.0f);
        addView(appCompatTextView, layoutParams);
        this.textView = appCompatTextView;
    }

    private final void j() {
        ProgressBar progressBar = new ProgressBar(getContext());
        int c16 = x.c(progressBar.getContext(), 16.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(c16, c16);
        layoutParams.rightMargin = x.c(progressBar.getContext(), 8.0f);
        addView(progressBar, layoutParams);
        progressBar.setVisibility(8);
        this.progressView = progressBar;
    }

    public static /* synthetic */ void l(MarqueeTextView marqueeTextView, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = "\u914d\u4e50\u52a0\u8f7d\u4e2d";
        }
        marqueeTextView.k(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v3, types: [android.widget.ProgressBar] */
    private final void m(boolean visible) {
        AppCompatTextView appCompatTextView = null;
        if (visible) {
            ProgressBar progressBar = this.progressView;
            if (progressBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("progressView");
                progressBar = null;
            }
            progressBar.setVisibility(0);
            ProgressBar progressBar2 = this.progressView;
            if (progressBar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("progressView");
                progressBar2 = null;
            }
            ViewGroup.LayoutParams layoutParams = progressBar2.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = x.c(getContext(), 6.0f);
            AppCompatTextView appCompatTextView2 = this.textView;
            if (appCompatTextView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("textView");
            } else {
                appCompatTextView = appCompatTextView2;
            }
            appCompatTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, 0, 0);
            return;
        }
        AppCompatTextView appCompatTextView3 = this.textView;
        if (appCompatTextView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textView");
            appCompatTextView3 = null;
        }
        appCompatTextView3.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.m4y, 0, 0, 0);
        ?? r65 = this.progressView;
        if (r65 == 0) {
            Intrinsics.throwUninitializedPropertyAccessException("progressView");
        } else {
            appCompatTextView = r65;
        }
        appCompatTextView.setVisibility(8);
    }

    @Override // com.tencent.mobileqq.wink.editor.music.ui.a
    public void a() {
        setSelected(false);
        c(this, State.IDLE, null, false, 6, null);
    }

    public final void d(@NotNull String elementId) {
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        VideoReport.setElementId(e(), WinkDaTongReportConstant.ElementId.EM_XSJ_MUSIC_CLOSE_BUTTON);
        Map<String, Object> map = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(map, "map");
        map.put("xsj_music_id", WinkDatongCurrentParams.get("xsj_music_id"));
        map.put("xsj_music_name", WinkDatongCurrentParams.get("xsj_music_name"));
        VideoReport.setElementParams(e(), map);
        VideoReport.setElementClickPolicy(e(), ClickPolicy.REPORT_NONE);
        VideoReport.reportEvent(elementId, e(), map);
    }

    @NotNull
    public final View e() {
        View view = this.closeView;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("closeView");
        return null;
    }

    @Nullable
    /* renamed from: f, reason: from getter */
    public final LyricStyleStickerImageVIew getLyricStyleStickerImageVIew() {
        return this.lyricStyleStickerImageVIew;
    }

    public final void k(@NotNull String musicTitle) {
        Intrinsics.checkNotNullParameter(musicTitle, "musicTitle");
        setSelected(false);
        c(this, State.LOADING, musicTitle, false, 4, null);
    }

    public final void n(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        setSelected(true);
        c(this, State.ANIMATING, name, false, 4, null);
    }

    public final void setCloseBtnVisible(boolean visible) {
        if (visible) {
            if (e().getVisibility() != 0 && !this.closeButtonShow) {
                d("dt_imp");
            }
            e().setVisibility(0);
        } else {
            e().setVisibility(8);
        }
        this.closeButtonShow = visible;
    }

    public final void setCloseButtonListener(@NotNull View.OnClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        e().setOnClickListener(listener);
    }

    public final void setLyricStyleStickerImageVIew(@Nullable LyricStyleStickerImageVIew lyricStyleStickerImageVIew) {
        this.lyricStyleStickerImageVIew = lyricStyleStickerImageVIew;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MarqueeTextView(@NotNull Context context, @NotNull AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.C = new LinkedHashMap();
        setOrientation(0);
        setGravity(17);
        setBackgroundResource(R.drawable.l67);
        h();
        j();
        i();
        g();
        State state = State.IDLE;
        c(this, state, null, false, 2, null);
        this.state = state;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MarqueeTextView(@NotNull Context context, @NotNull AttributeSet attrs, int i3) {
        super(context, attrs, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.C = new LinkedHashMap();
        setOrientation(0);
        setGravity(17);
        setBackgroundResource(R.drawable.l67);
        h();
        j();
        i();
        g();
        State state = State.IDLE;
        c(this, state, null, false, 2, null);
        this.state = state;
    }
}
