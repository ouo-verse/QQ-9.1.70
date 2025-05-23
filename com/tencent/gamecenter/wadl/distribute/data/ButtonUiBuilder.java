package com.tencent.gamecenter.wadl.distribute.data;

import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.distribute.provider.IBgAndFgColorFetcher;
import com.tencent.gamecenter.wadl.distribute.provider.IBgAndFgDrawableFetcher;
import com.tencent.gamecenter.wadl.distribute.provider.ITextColorFetcher;
import com.tencent.gamecenter.wadl.distribute.provider.ITextContentFetcher;
import com.tencent.gamecenter.wadl.distribute.provider.TextContentFetcherAdapter;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001d\u0018\u0000 \\2\u00020\u0001:\u0003\\]^B\u0007\u00a2\u0006\u0004\bZ\u0010[J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0002J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\u0010J\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002J\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0016J\u0006\u0010\u0019\u001a\u00020\u0016J\u000e\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u0005J\u0006\u0010\u001d\u001a\u00020\u0005J\u000e\u0010 \u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u001eJ\u0006\u0010!\u001a\u00020\u001eJ\u0010\u0010$\u001a\u00020\u00002\b\u0010#\u001a\u0004\u0018\u00010\"J\u0006\u0010%\u001a\u00020\"J\u000e\u0010(\u001a\u00020\u00002\u0006\u0010'\u001a\u00020&J\b\u0010)\u001a\u0004\u0018\u00010&J\u000e\u0010+\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u0005J\u0006\u0010,\u001a\u00020\u0005J\u0010\u0010/\u001a\u00020\u00002\b\u0010.\u001a\u0004\u0018\u00010-J\b\u00100\u001a\u0004\u0018\u00010-J\u000e\u00101\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0005J\u000e\u00104\u001a\u00020\u00002\u0006\u00103\u001a\u000202J\b\u00105\u001a\u0004\u0018\u000102J\u000e\u00107\u001a\u00020\u00002\u0006\u00103\u001a\u000206J\b\u00108\u001a\u0004\u0018\u000106J\u000e\u0010:\u001a\u00020\u00002\u0006\u00103\u001a\u000209J\u000e\u0010<\u001a\u00020\u00002\u0006\u00103\u001a\u00020;J\u000e\u0010>\u001a\u00020\u00002\u0006\u0010=\u001a\u00020\u0010J\u0006\u0010?\u001a\u00020\u0010J\u000e\u0010A\u001a\u00020\u00002\u0006\u0010@\u001a\u00020\u0010J\u0006\u0010@\u001a\u00020\u0010J\u0006\u0010C\u001a\u00020BJ\u000e\u0010E\u001a\u00020\u00002\u0006\u0010D\u001a\u00020\u0010J\u0006\u0010F\u001a\u00020\u0010R\u0016\u0010G\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010I\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0018\u0010K\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0018\u0010M\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010O\u001a\u00020B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010Q\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010HR\u0016\u0010R\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010HR\u0016\u0010\u001b\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010HR\u0016\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010SR\u0016\u0010#\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010TR\u0018\u0010'\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010UR\u0016\u0010*\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010HR\u0016\u0010?\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010VR\u0016\u0010W\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010@\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010VR\u0016\u0010D\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010VR\u0018\u0010.\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010Y\u00a8\u0006_"}, d2 = {"Lcom/tencent/gamecenter/wadl/distribute/data/ButtonUiBuilder;", "", "Landroid/graphics/drawable/Drawable;", "getFixEnableBgDrawable", "getFixDisableBgDrawable", "", "color", "style", "getShapeDrawableByUiStyle", "getFixProgressBgDrawable", "getFixProgressFgDrawable", "getLayerDrawable", "Landroid/graphics/drawable/ClipDrawable;", "getClipDrawable", "getEnableBgDrawable", "getDisableBgDrawable", "", "enable", "getFixTextColor", "getBgDrawable", "getProgressFgDrawable", "getProgressBgDrawable", "", "corner", "setBgCorner", "getBgCorner", "getTextColor", "textSize", "setTextSize", "getTextSize", "", "fontWeight", CanvasView.ACTION_SET_FONT_WEIGHT, "getFontWeight", "", "fontFamily", CanvasView.ACTION_SET_FONT_FAMILY, "getFontFamily", "Lcom/tencent/gamecenter/wadl/distribute/data/ButtonUiBuilder$a;", "shadow", CanvasView.ACTION_SET_SHADOW, "getShadow", "pressedColor", "setPressedColor", "getPressedColor", "Lorg/json/JSONObject;", "guildUIColor", "setGuildUIColor", "getGuildUIColor", "setUiStyle", "Lcom/tencent/gamecenter/wadl/distribute/provider/IBgAndFgDrawableFetcher;", "fetcher", "setCustomBgAndFgDrawableFetcher", "getCustomBgAndFgDrawableFetcher", "Lcom/tencent/gamecenter/wadl/distribute/provider/IBgAndFgColorFetcher;", "setCustomBgAndFgColorFetcher", "getBgAndFgColorFetcher", "Lcom/tencent/gamecenter/wadl/distribute/provider/ITextColorFetcher;", "setCustomTextColorFetcher", "Lcom/tencent/gamecenter/wadl/distribute/provider/TextContentFetcherAdapter;", "setCustomTextContentFetcher", "showProgressWhenPaused", "setShowProgressWhenPaused", "isShowProgressWhenPaused", "isWholeClipRound", "setWholeClipRound", "Lcom/tencent/gamecenter/wadl/distribute/provider/ITextContentFetcher;", "getTextContentFetcher", "autoClickBtn", "setAutoClickBtn", "isAutoClickBtn", "uiStyle", "I", "drawableFetcher", "Lcom/tencent/gamecenter/wadl/distribute/provider/IBgAndFgDrawableFetcher;", "bgAndFgColorFetcher", "Lcom/tencent/gamecenter/wadl/distribute/provider/IBgAndFgColorFetcher;", "textColorFetcher", "Lcom/tencent/gamecenter/wadl/distribute/provider/ITextColorFetcher;", "textContentFetcher", "Lcom/tencent/gamecenter/wadl/distribute/provider/ITextContentFetcher;", "enableTextColor", "disableTextColor", "D", "Ljava/lang/String;", "Lcom/tencent/gamecenter/wadl/distribute/data/ButtonUiBuilder$a;", "Z", "bgCorner", UserInfo.SEX_FEMALE, "Lorg/json/JSONObject;", "<init>", "()V", "Companion", "a", "Style", "qqgamedownloader-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class ButtonUiBuilder {
    private boolean autoClickBtn;

    @Nullable
    private IBgAndFgColorFetcher bgAndFgColorFetcher;

    @Nullable
    private IBgAndFgDrawableFetcher drawableFetcher;
    private double fontWeight;

    @Nullable
    private JSONObject guildUIColor;
    private boolean isShowProgressWhenPaused;
    private boolean isWholeClipRound;
    private int pressedColor;

    @Nullable
    private a shadow;

    @Nullable
    private ITextColorFetcher textColorFetcher;
    private int uiStyle;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int DEFAULT_BG_COLOR_ENABLE = Color.parseColor("#0099FF");
    private static final int DEFAULT_BG_COLOR_DISABLE = Color.parseColor("#B2E0FF");
    private static final int DEFAULT_PROGRESS_BG_COLOR = Color.parseColor("#B2E0FF");
    private static final int DEFAULT_PROGRESS_FG_COLOR = Color.parseColor("#0099FF");
    private static final int DEFAULT_TEXT_COLOR_WHITE = Color.parseColor("#FFFFFF");
    private static final int DEFAULT_TEXT_COLOR_BLUE_ENABLE = Color.parseColor("#0099FF");
    private static final int DEFAULT_TEXT_COLOR_BLUE_DISABLE = Color.parseColor("#B2E0FF");
    private static final float DEFAULT_BG_CORNER = ViewUtils.dpToPx(8.0f);
    private static final int DEFAULT_STROKE_WIDTH = ViewUtils.dpToPx(1.0f);

    @NotNull
    private ITextContentFetcher textContentFetcher = new b();
    private int enableTextColor = -1;
    private int disableTextColor = -1;
    private int textSize = ViewUtils.dpToPx(17.0f);

    @NotNull
    private String fontFamily = "";
    private float bgCorner = DEFAULT_BG_CORNER;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/gamecenter/wadl/distribute/data/ButtonUiBuilder$Companion;", "", "()V", "DEFAULT_BG_COLOR_DISABLE", "", "DEFAULT_BG_COLOR_ENABLE", "DEFAULT_BG_CORNER", "", "DEFAULT_PROGRESS_BG_COLOR", "DEFAULT_PROGRESS_FG_COLOR", "DEFAULT_STROKE_WIDTH", "DEFAULT_TEXT_COLOR_BLUE_DISABLE", "DEFAULT_TEXT_COLOR_BLUE_ENABLE", "DEFAULT_TEXT_COLOR_WHITE", "getDefault", "Lcom/tencent/gamecenter/wadl/distribute/data/ButtonUiBuilder;", "qqgamedownloader-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final ButtonUiBuilder getDefault() {
            return new ButtonUiBuilder();
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/gamecenter/wadl/distribute/data/ButtonUiBuilder$a;", "", "qqgamedownloader-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class a {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"com/tencent/gamecenter/wadl/distribute/data/ButtonUiBuilder$b", "Lcom/tencent/gamecenter/wadl/distribute/provider/TextContentFetcherAdapter;", "qqgamedownloader-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b extends TextContentFetcherAdapter {
        b() {
        }
    }

    private final ClipDrawable getClipDrawable(int color) {
        float bgCorner = getBgCorner();
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{bgCorner, bgCorner, bgCorner, bgCorner, bgCorner, bgCorner, bgCorner, bgCorner}, null, null));
        shapeDrawable.getPaint().setColor(color);
        return new ClipDrawable(shapeDrawable, 8388611, 1);
    }

    @JvmStatic
    @NotNull
    public static final ButtonUiBuilder getDefault() {
        return INSTANCE.getDefault();
    }

    private final Drawable getDisableBgDrawable() {
        Drawable drawable;
        if (this.uiStyle == 2) {
            IBgAndFgDrawableFetcher iBgAndFgDrawableFetcher = this.drawableFetcher;
            if (iBgAndFgDrawableFetcher != null) {
                drawable = iBgAndFgDrawableFetcher.fetchDisableDrawable();
            } else {
                drawable = null;
            }
            if (drawable != null) {
                IBgAndFgDrawableFetcher iBgAndFgDrawableFetcher2 = this.drawableFetcher;
                if (iBgAndFgDrawableFetcher2 == null) {
                    return null;
                }
                return iBgAndFgDrawableFetcher2.fetchDisableDrawable();
            }
        }
        return getFixDisableBgDrawable();
    }

    private final Drawable getEnableBgDrawable() {
        Drawable drawable;
        if (this.uiStyle == 2) {
            IBgAndFgDrawableFetcher iBgAndFgDrawableFetcher = this.drawableFetcher;
            if (iBgAndFgDrawableFetcher != null) {
                drawable = iBgAndFgDrawableFetcher.fetchEnableBgDrawable();
            } else {
                drawable = null;
            }
            if (drawable != null) {
                IBgAndFgDrawableFetcher iBgAndFgDrawableFetcher2 = this.drawableFetcher;
                if (iBgAndFgDrawableFetcher2 == null) {
                    return null;
                }
                return iBgAndFgDrawableFetcher2.fetchEnableBgDrawable();
            }
        }
        return getFixEnableBgDrawable();
    }

    private final Drawable getFixDisableBgDrawable() {
        Integer num;
        int i3 = DEFAULT_BG_COLOR_DISABLE;
        if (this.uiStyle != 2) {
            IBgAndFgColorFetcher iBgAndFgColorFetcher = this.bgAndFgColorFetcher;
            if (iBgAndFgColorFetcher != null) {
                num = Integer.valueOf(iBgAndFgColorFetcher.fetchDisableBgColor());
            } else {
                num = null;
            }
            if (num != null) {
                IBgAndFgColorFetcher iBgAndFgColorFetcher2 = this.bgAndFgColorFetcher;
                Intrinsics.checkNotNull(iBgAndFgColorFetcher2);
                i3 = iBgAndFgColorFetcher2.fetchDisableBgColor();
            }
        }
        return getShapeDrawableByUiStyle(i3, this.uiStyle);
    }

    private final Drawable getFixEnableBgDrawable() {
        Integer num;
        int i3 = DEFAULT_BG_COLOR_ENABLE;
        if (this.uiStyle != 2) {
            IBgAndFgColorFetcher iBgAndFgColorFetcher = this.bgAndFgColorFetcher;
            if (iBgAndFgColorFetcher != null) {
                num = Integer.valueOf(iBgAndFgColorFetcher.fetchEnableBgColor());
            } else {
                num = null;
            }
            if (num != null) {
                IBgAndFgColorFetcher iBgAndFgColorFetcher2 = this.bgAndFgColorFetcher;
                Intrinsics.checkNotNull(iBgAndFgColorFetcher2);
                i3 = iBgAndFgColorFetcher2.fetchEnableBgColor();
            }
        }
        return getShapeDrawableByUiStyle(i3, this.uiStyle);
    }

    private final Drawable getFixProgressBgDrawable() {
        Integer num;
        int i3 = DEFAULT_PROGRESS_BG_COLOR;
        if (this.uiStyle != 2) {
            IBgAndFgColorFetcher iBgAndFgColorFetcher = this.bgAndFgColorFetcher;
            if (iBgAndFgColorFetcher != null) {
                num = Integer.valueOf(iBgAndFgColorFetcher.fetchProgressBgColor());
            } else {
                num = null;
            }
            if (num != null) {
                IBgAndFgColorFetcher iBgAndFgColorFetcher2 = this.bgAndFgColorFetcher;
                Intrinsics.checkNotNull(iBgAndFgColorFetcher2);
                i3 = iBgAndFgColorFetcher2.fetchProgressBgColor();
            }
        }
        return getShapeDrawableByUiStyle(i3, 0);
    }

    private final Drawable getFixProgressFgDrawable() {
        Integer num;
        int i3 = DEFAULT_PROGRESS_FG_COLOR;
        if (this.uiStyle != 2) {
            IBgAndFgColorFetcher iBgAndFgColorFetcher = this.bgAndFgColorFetcher;
            if (iBgAndFgColorFetcher != null) {
                num = Integer.valueOf(iBgAndFgColorFetcher.fetchProgressFgColor());
            } else {
                num = null;
            }
            if (num != null) {
                IBgAndFgColorFetcher iBgAndFgColorFetcher2 = this.bgAndFgColorFetcher;
                Intrinsics.checkNotNull(iBgAndFgColorFetcher2);
                i3 = iBgAndFgColorFetcher2.fetchProgressFgColor();
            }
        }
        return getLayerDrawable(i3);
    }

    private final int getFixTextColor(boolean enable) {
        if (this.uiStyle == 1) {
            if (enable) {
                return DEFAULT_TEXT_COLOR_BLUE_ENABLE;
            }
            return DEFAULT_TEXT_COLOR_BLUE_DISABLE;
        }
        return DEFAULT_TEXT_COLOR_WHITE;
    }

    private final Drawable getLayerDrawable(int color) {
        return new LayerDrawable(new ClipDrawable[]{getClipDrawable(color)});
    }

    private final Drawable getShapeDrawableByUiStyle(int color, int style) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(getBgCorner());
        if (style != 0) {
            if (style == 1) {
                gradientDrawable.setStroke(DEFAULT_STROKE_WIDTH, color);
            }
        } else {
            gradientDrawable.setColor(color);
        }
        return gradientDrawable;
    }

    @Nullable
    public final IBgAndFgColorFetcher getBgAndFgColorFetcher() {
        return this.bgAndFgColorFetcher;
    }

    public final float getBgCorner() {
        return this.bgCorner;
    }

    @Nullable
    public final Drawable getBgDrawable(boolean enable) {
        if (enable) {
            return getEnableBgDrawable();
        }
        return getDisableBgDrawable();
    }

    @Nullable
    /* renamed from: getCustomBgAndFgDrawableFetcher, reason: from getter */
    public final IBgAndFgDrawableFetcher getDrawableFetcher() {
        return this.drawableFetcher;
    }

    @NotNull
    public final String getFontFamily() {
        return this.fontFamily;
    }

    public final double getFontWeight() {
        return this.fontWeight;
    }

    @Nullable
    public final JSONObject getGuildUIColor() {
        return this.guildUIColor;
    }

    public final int getPressedColor() {
        return this.pressedColor;
    }

    @Nullable
    public final Drawable getProgressBgDrawable() {
        Drawable drawable;
        if (this.uiStyle == 2) {
            IBgAndFgDrawableFetcher iBgAndFgDrawableFetcher = this.drawableFetcher;
            if (iBgAndFgDrawableFetcher != null) {
                drawable = iBgAndFgDrawableFetcher.fetchProgressBgDrawable();
            } else {
                drawable = null;
            }
            if (drawable != null) {
                IBgAndFgDrawableFetcher iBgAndFgDrawableFetcher2 = this.drawableFetcher;
                if (iBgAndFgDrawableFetcher2 == null) {
                    return null;
                }
                return iBgAndFgDrawableFetcher2.fetchProgressBgDrawable();
            }
        }
        return getFixProgressBgDrawable();
    }

    @Nullable
    public final Drawable getProgressFgDrawable() {
        Drawable drawable;
        if (this.uiStyle == 2) {
            IBgAndFgDrawableFetcher iBgAndFgDrawableFetcher = this.drawableFetcher;
            if (iBgAndFgDrawableFetcher != null) {
                drawable = iBgAndFgDrawableFetcher.fetchProgressFgDrawable();
            } else {
                drawable = null;
            }
            if (drawable != null) {
                IBgAndFgDrawableFetcher iBgAndFgDrawableFetcher2 = this.drawableFetcher;
                if (iBgAndFgDrawableFetcher2 == null) {
                    return null;
                }
                return iBgAndFgDrawableFetcher2.fetchProgressFgDrawable();
            }
        }
        return getFixProgressFgDrawable();
    }

    @Nullable
    public final a getShadow() {
        return null;
    }

    public final int getTextColor(boolean enable) {
        int fixTextColor = getFixTextColor(enable);
        if (enable) {
            ITextColorFetcher iTextColorFetcher = this.textColorFetcher;
            if (iTextColorFetcher != null) {
                return iTextColorFetcher.fetchEnableTextColor();
            }
            return fixTextColor;
        }
        ITextColorFetcher iTextColorFetcher2 = this.textColorFetcher;
        if (iTextColorFetcher2 != null) {
            return iTextColorFetcher2.fetchDisableTextColor();
        }
        return fixTextColor;
    }

    @NotNull
    public final ITextContentFetcher getTextContentFetcher() {
        return this.textContentFetcher;
    }

    public final int getTextSize() {
        return this.textSize;
    }

    /* renamed from: isAutoClickBtn, reason: from getter */
    public final boolean getAutoClickBtn() {
        return this.autoClickBtn;
    }

    /* renamed from: isShowProgressWhenPaused, reason: from getter */
    public final boolean getIsShowProgressWhenPaused() {
        return this.isShowProgressWhenPaused;
    }

    /* renamed from: isWholeClipRound, reason: from getter */
    public final boolean getIsWholeClipRound() {
        return this.isWholeClipRound;
    }

    @NotNull
    public final ButtonUiBuilder setAutoClickBtn(boolean autoClickBtn) {
        this.autoClickBtn = autoClickBtn;
        return this;
    }

    @NotNull
    public final ButtonUiBuilder setBgCorner(float corner) {
        this.bgCorner = corner;
        return this;
    }

    @NotNull
    public final ButtonUiBuilder setCustomBgAndFgColorFetcher(@NotNull IBgAndFgColorFetcher fetcher) {
        Intrinsics.checkNotNullParameter(fetcher, "fetcher");
        this.bgAndFgColorFetcher = fetcher;
        return this;
    }

    @NotNull
    public final ButtonUiBuilder setCustomBgAndFgDrawableFetcher(@NotNull IBgAndFgDrawableFetcher fetcher) {
        Intrinsics.checkNotNullParameter(fetcher, "fetcher");
        this.drawableFetcher = fetcher;
        return this;
    }

    @NotNull
    public final ButtonUiBuilder setCustomTextColorFetcher(@NotNull ITextColorFetcher fetcher) {
        Intrinsics.checkNotNullParameter(fetcher, "fetcher");
        this.textColorFetcher = fetcher;
        return this;
    }

    @NotNull
    public final ButtonUiBuilder setCustomTextContentFetcher(@NotNull TextContentFetcherAdapter fetcher) {
        Intrinsics.checkNotNullParameter(fetcher, "fetcher");
        this.textContentFetcher = fetcher;
        return this;
    }

    @NotNull
    public final ButtonUiBuilder setFontFamily(@Nullable String fontFamily) {
        boolean z16;
        if (fontFamily != null && fontFamily.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            this.fontFamily = fontFamily;
        }
        return this;
    }

    @NotNull
    public final ButtonUiBuilder setFontWeight(double fontWeight) {
        this.fontWeight = fontWeight;
        return this;
    }

    @NotNull
    public final ButtonUiBuilder setGuildUIColor(@Nullable JSONObject guildUIColor) {
        this.guildUIColor = guildUIColor;
        return this;
    }

    @NotNull
    public final ButtonUiBuilder setPressedColor(int pressedColor) {
        this.pressedColor = pressedColor;
        return this;
    }

    @NotNull
    public final ButtonUiBuilder setShadow(@NotNull a shadow) {
        Intrinsics.checkNotNullParameter(shadow, "shadow");
        return this;
    }

    @NotNull
    public final ButtonUiBuilder setShowProgressWhenPaused(boolean showProgressWhenPaused) {
        this.isShowProgressWhenPaused = showProgressWhenPaused;
        return this;
    }

    @NotNull
    public final ButtonUiBuilder setTextSize(int textSize) {
        this.textSize = textSize;
        return this;
    }

    @NotNull
    public final ButtonUiBuilder setUiStyle(int style) {
        this.uiStyle = style;
        return this;
    }

    @NotNull
    public final ButtonUiBuilder setWholeClipRound(boolean isWholeClipRound) {
        this.isWholeClipRound = isWholeClipRound;
        return this;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/gamecenter/wadl/distribute/data/ButtonUiBuilder$Style;", "", "Companion", "qqgamedownloader-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    /* loaded from: classes6.dex */
    public @interface Style {
        public static final int CUSTOM = 2;

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final int FILL = 0;
        public static final int KUIKLY = 3;
        public static final int STROKE = 1;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\u00020\u00048\u0006X\u0087T\u00a2\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0002\u00a8\u0006\t"}, d2 = {"Lcom/tencent/gamecenter/wadl/distribute/data/ButtonUiBuilder$Style$Companion;", "", "()V", "CUSTOM", "", "FILL", "KUIKLY", "STROKE", "getSTROKE$annotations", "qqgamedownloader-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes6.dex */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int CUSTOM = 2;
            public static final int FILL = 0;
            public static final int KUIKLY = 3;
            public static final int STROKE = 1;

            Companion() {
            }

            @Deprecated(message = "\u5e9f\u5f03\uff0c\u8bf7\u52ff\u4f7f\u7528")
            public static /* synthetic */ void getSTROKE$annotations() {
            }
        }
    }
}
