package com.tencent.aelight.camera.ae.flashshow.view;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 >2\u00020\u0001:\u0001\bB\u0011\b\u0016\u0012\u0006\u00106\u001a\u000205\u00a2\u0006\u0004\b7\u00108B\u001b\b\u0016\u0012\u0006\u00106\u001a\u000205\u0012\b\u0010:\u001a\u0004\u0018\u000109\u00a2\u0006\u0004\b7\u0010;B#\b\u0016\u0012\u0006\u00106\u001a\u000205\u0012\b\u0010:\u001a\u0004\u0018\u000109\u0012\u0006\u0010<\u001a\u00020\u0004\u00a2\u0006\u0004\b7\u0010=J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0002J\f\u0010\t\u001a\u00020\u0004*\u00020\u0004H\u0002J\u0006\u0010\n\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0006J\u000e\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004H\u0014J\u0010\u0010\u0016\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\u0018\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u0006R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u001eR\u0014\u0010 \u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u001bR\u0016\u0010#\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010*\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010,\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010)R\u0014\u0010.\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010)R\u0014\u00100\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u0010)R\u0014\u00102\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u0010)R\u0016\u00104\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u0010)\u00a8\u0006?"}, d2 = {"Lcom/tencent/aelight/camera/ae/flashshow/view/FlashShowMusicButton;", "Landroid/widget/LinearLayout;", "", "e", "", "state", "", "musicTitle", "a", "g", "setMusicOff", "title", "setMusicOn", "Landroid/view/View$OnClickListener;", "listener", "setCloseButtonListener", "", "show", "f", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "setLoadingMusicTitle", "elementId", "c", "Landroid/view/View;", "d", "Landroid/view/View;", "musicIcon", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "textView", "closeButton", h.F, "Z", "closeButtonShow", "Landroid/widget/ProgressBar;", "i", "Landroid/widget/ProgressBar;", "progressView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "musicIconSize", BdhLogUtil.LogTag.Tag_Conn, "textSize", "D", "textColor", "E", "textHorizontalMargin", UserInfo.SEX_FEMALE, "closeIconSize", "G", "currentState", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "H", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class FlashShowMusicButton extends LinearLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private final int textSize;

    /* renamed from: D, reason: from kotlin metadata */
    private final int textColor;

    /* renamed from: E, reason: from kotlin metadata */
    private final int textHorizontalMargin;

    /* renamed from: F, reason: from kotlin metadata */
    private final int closeIconSize;

    /* renamed from: G, reason: from kotlin metadata */
    private int currentState;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final View musicIcon;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final TextView textView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final View closeButton;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean closeButtonShow;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ProgressBar progressView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final int musicIconSize;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FlashShowMusicButton(Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void e() {
        ProgressBar progressBar = new ProgressBar(getContext());
        int c16 = x.c(progressBar.getContext(), 16.0f);
        addView(progressBar, new LinearLayout.LayoutParams(c16, c16));
        progressBar.setVisibility(8);
        this.progressView = progressBar;
    }

    public final void c(String elementId) {
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        VideoReport.setElementId(this.closeButton, WinkDaTongReportConstant.ElementId.EM_XSJ_MUSIC_CLOSE_BUTTON);
        Map<String, Object> map = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(map, "map");
        map.put("xsj_music_id", WinkDatongCurrentParams.get("xsj_music_id"));
        map.put("xsj_music_name", WinkDatongCurrentParams.get("xsj_music_name"));
        VideoReport.setElementParams(this.closeButton, map);
        VideoReport.setElementClickPolicy(this.closeButton, ClickPolicy.REPORT_NONE);
        VideoReport.reportEvent(elementId, this.closeButton, map);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public final void setCloseButtonListener(View.OnClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.closeButton.setOnClickListener(listener);
    }

    public final void setLoadingMusicTitle(String musicTitle) {
        Intrinsics.checkNotNullParameter(musicTitle, "musicTitle");
        this.textView.setText(musicTitle);
    }

    public final void setMusicOff() {
        if (this.currentState != 0) {
            b(this, 0, null, 2, null);
        }
    }

    public final void setMusicOn(String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        if (this.currentState == 1) {
            CharSequence text = this.textView.getText();
            if (text == null) {
                text = "";
            }
            if (Intrinsics.areEqual(text, title)) {
                return;
            }
        }
        f(true);
        if (title.length() == 0) {
            String string = getContext().getString(R.string.y3x);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026ae_editor_original_sound)");
            a(1, string);
            return;
        }
        a(1, title);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FlashShowMusicButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final int g(int i3) {
        return (int) TypedValue.applyDimension(1, i3, getResources().getDisplayMetrics());
    }

    public final void f(boolean show) {
        ProgressBar progressBar = null;
        if (show) {
            this.musicIcon.setVisibility(0);
            ProgressBar progressBar2 = this.progressView;
            if (progressBar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("progressView");
            } else {
                progressBar = progressBar2;
            }
            progressBar.setVisibility(8);
            return;
        }
        this.musicIcon.setVisibility(8);
        ProgressBar progressBar3 = this.progressView;
        if (progressBar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("progressView");
        } else {
            progressBar = progressBar3;
        }
        progressBar.setVisibility(0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlashShowMusicButton(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        setOrientation(0);
        setGravity(17);
        int g16 = g(16);
        this.musicIconSize = g16;
        this.textSize = g(12);
        int parseColor = Color.parseColor("#FFFFFF");
        this.textColor = parseColor;
        int g17 = g(6);
        this.textHorizontalMargin = g17;
        int g18 = g(16);
        this.closeIconSize = g18;
        e();
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(R.drawable.ize);
        addView(imageView, new LinearLayout.LayoutParams(g16, g16));
        this.musicIcon = imageView;
        TextView textView = new TextView(getContext());
        textView.setTextSize(0, textView.getTextSize());
        textView.setTextColor(parseColor);
        textView.setMaxWidth(g(102));
        textView.setSingleLine();
        textView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        textView.setMarqueeRepeatLimit(-1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = g17;
        layoutParams.rightMargin = g17;
        addView(textView, layoutParams);
        this.textView = textView;
        ImageView imageView2 = new ImageView(getContext());
        imageView2.setImageResource(R.drawable.izb);
        addView(imageView2, new LinearLayout.LayoutParams(g18, g18));
        this.closeButton = imageView2;
        b(this, 0, null, 2, null);
    }

    static /* synthetic */ void b(FlashShowMusicButton flashShowMusicButton, int i3, String str, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            str = "\u9009\u62e9\u97f3\u4e50";
        }
        flashShowMusicButton.a(i3, str);
    }

    public static /* synthetic */ void d(FlashShowMusicButton flashShowMusicButton, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = "dt_clck";
        }
        flashShowMusicButton.c(str);
    }

    public static /* synthetic */ void setLoadingMusicTitle$default(FlashShowMusicButton flashShowMusicButton, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = "\u9009\u62e9\u97f3\u4e50";
        }
        flashShowMusicButton.setLoadingMusicTitle(str);
    }

    private final void a(int state, String musicTitle) {
        boolean z16 = state == 1;
        if (z16 && !this.closeButtonShow) {
            c("dt_imp");
        }
        this.closeButtonShow = z16;
        this.closeButton.setVisibility(z16 ? 0 : 8);
        this.textView.setText(musicTitle);
        this.textView.setSelected(z16);
        this.currentState = state;
        requestLayout();
    }
}
