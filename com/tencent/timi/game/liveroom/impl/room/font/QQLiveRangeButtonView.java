package com.tencent.timi.game.liveroom.impl.room.font;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.ColorInt;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mr2.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 Q2\u00020\u0001:\u0007R\u0003\u0006\u0005\u000e(SB'\b\u0007\u0012\u0006\u0010K\u001a\u00020J\u0012\n\b\u0002\u0010M\u001a\u0004\u0018\u00010L\u0012\b\b\u0002\u0010N\u001a\u00020\u0007\u00a2\u0006\u0004\bO\u0010PJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J0\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0002J\u0016\u0010\u0013\u001a\u00020\u00122\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fJ\u0010\u0010\u0015\u001a\u00020\u00122\b\b\u0001\u0010\u0014\u001a\u00020\u0007J\u0018\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0007H\u0014J\u0010\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0019H\u0014J\u0010\u0010\u001e\u001a\u00020\u00122\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cJ\u0010\u0010!\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u001fH\u0016R\u0018\u0010#\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\"R\u0018\u0010&\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010%R\u001c\u0010*\u001a\b\u0018\u00010'R\u00020\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u001a\u00102\u001a\u00060/R\u00020\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0014\u00106\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105R\u001e\u00109\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010=\u001a\u0004\u0018\u00010:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010@\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010C\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR$\u0010I\u001a\u00020\u00072\u0006\u0010D\u001a\u00020\u00078F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bE\u0010F\"\u0004\bG\u0010H\u00a8\u0006T"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/font/QQLiveRangeButtonView;", "Landroid/view/View;", "", "b", "value", "d", "c", "", HippyTKDListViewAdapter.X, "y", "xRange", "yRange", "", "needCalc", "e", "", "Lcom/tencent/timi/game/liveroom/impl/room/font/QQLiveRangeButtonView$e;", "data", "", "setTitleData", "color", "setTitleColor", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", "Lcom/tencent/timi/game/liveroom/impl/room/font/QQLiveRangeButtonView$b;", "listener", "setOnChangerListener", "Landroid/view/MotionEvent;", "event", "onTouchEvent", "Lcom/tencent/timi/game/liveroom/impl/room/font/QQLiveRangeButtonView$b;", "mListener", "Lcom/tencent/timi/game/liveroom/impl/room/font/QQLiveRangeButtonView$g;", "Lcom/tencent/timi/game/liveroom/impl/room/font/QQLiveRangeButtonView$g;", "mUnitBar", "Lcom/tencent/timi/game/liveroom/impl/room/font/QQLiveRangeButtonView$f;", "f", "Lcom/tencent/timi/game/liveroom/impl/room/font/QQLiveRangeButtonView$f;", "mTitleDrawer", "Lcom/tencent/timi/game/liveroom/impl/room/font/QQLiveRangeButtonView$d;", h.F, "Lcom/tencent/timi/game/liveroom/impl/room/font/QQLiveRangeButtonView$d;", "mThumbDrawer", "Lcom/tencent/timi/game/liveroom/impl/room/font/QQLiveRangeButtonView$c;", "i", "Lcom/tencent/timi/game/liveroom/impl/room/font/QQLiveRangeButtonView$c;", "mRangeButtonParams", "Landroid/text/TextPaint;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/text/TextPaint;", "mTextPaint", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "mTitlesList", "Landroid/graphics/Bitmap;", "D", "Landroid/graphics/Bitmap;", "mThumbBmp", "E", "Z", "isTitleUp2Line", UserInfo.SEX_FEMALE, "I", "mCurrentPosition", "position", "getThumbPosition", "()I", "setThumbPosition", "(I)V", "thumbPosition", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "G", "a", "g", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class QQLiveRangeButtonView extends View {

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private List<e> mTitlesList;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private final Bitmap mThumbBmp;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isTitleUp2Line;

    /* renamed from: F, reason: from kotlin metadata */
    private int mCurrentPosition;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b mListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private g mUnitBar;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private f mTitleDrawer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private d mThumbDrawer;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private c mRangeButtonParams;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextPaint mTextPaint;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\t"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/font/QQLiveRangeButtonView$a;", "", "", "text", "", "textSize", "a", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.timi.game.liveroom.impl.room.font.QQLiveRangeButtonView$a, reason: from kotlin metadata */
    /* loaded from: classes26.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final float a(@Nullable String text, float textSize) {
            TextPaint textPaint = new TextPaint();
            textPaint.setTextSize(textSize);
            return textPaint.measureText(text);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/font/QQLiveRangeButtonView$b;", "", "", "lastPosition", "newPosition", "", "onChange", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public interface b {
        void onChange(int lastPosition, int newPosition);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b \b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b(\u0010)R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0010\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0003\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0013\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0017\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0015\u0010\r\"\u0004\b\u0016\u0010\u000fR\"\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0018\u0010\bR\"\u0010\u001c\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\f\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u001b\u0010\u000fR\"\u0010\u001f\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\f\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001e\u0010\u000fR\"\u0010\"\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR\"\u0010%\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b$\u0010\bR\"\u0010'\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\f\u001a\u0004\b#\u0010\r\"\u0004\b&\u0010\u000f\u00a8\u0006*"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/font/QQLiveRangeButtonView$c;", "", "", "a", "I", h.F, "()I", "r", "(I)V", "titleColor", "", "b", UserInfo.SEX_FEMALE, "()F", "k", "(F)V", "barLeftPadding", "c", "l", "barRightPadding", "d", "e", "o", "lineOffset", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "lineColor", "f", DomainData.DOMAIN_NAME, NodeProps.LINE_HEIGHT, "g", "p", "lineWeight", "j", "t", "unitCount", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "thumbSrcId", ReportConstant.COSTREPORT_PREFIX, "titleTopPadding", "<init>", "(Lcom/tencent/timi/game/liveroom/impl/room/font/QQLiveRangeButtonView;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public final class c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int titleColor;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private float barLeftPadding;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private float barRightPadding;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private float lineOffset;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private int lineColor;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private float lineHeight;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private float lineWeight;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private int unitCount;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private int thumbSrcId;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        private float titleTopPadding;

        public c() {
        }

        /* renamed from: a, reason: from getter */
        public final float getBarLeftPadding() {
            return this.barLeftPadding;
        }

        /* renamed from: b, reason: from getter */
        public final float getBarRightPadding() {
            return this.barRightPadding;
        }

        /* renamed from: c, reason: from getter */
        public final int getLineColor() {
            return this.lineColor;
        }

        /* renamed from: d, reason: from getter */
        public final float getLineHeight() {
            return this.lineHeight;
        }

        /* renamed from: e, reason: from getter */
        public final float getLineOffset() {
            return this.lineOffset;
        }

        /* renamed from: f, reason: from getter */
        public final float getLineWeight() {
            return this.lineWeight;
        }

        /* renamed from: g, reason: from getter */
        public final int getThumbSrcId() {
            return this.thumbSrcId;
        }

        /* renamed from: h, reason: from getter */
        public final int getTitleColor() {
            return this.titleColor;
        }

        /* renamed from: i, reason: from getter */
        public final float getTitleTopPadding() {
            return this.titleTopPadding;
        }

        /* renamed from: j, reason: from getter */
        public final int getUnitCount() {
            return this.unitCount;
        }

        public final void k(float f16) {
            this.barLeftPadding = f16;
        }

        public final void l(float f16) {
            this.barRightPadding = f16;
        }

        public final void m(int i3) {
            this.lineColor = i3;
        }

        public final void n(float f16) {
            this.lineHeight = f16;
        }

        public final void o(float f16) {
            this.lineOffset = f16;
        }

        public final void p(float f16) {
            this.lineWeight = f16;
        }

        public final void q(int i3) {
            this.thumbSrcId = i3;
        }

        public final void r(int i3) {
            this.titleColor = i3;
        }

        public final void s(float f16) {
            this.titleTopPadding = f16;
        }

        public final void t(int i3) {
            this.unitCount = i3;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tR$\u0010\u0012\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R\u0011\u0010\u001d\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u0015\u00a8\u0006 "}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/font/QQLiveRangeButtonView$d;", "", "", "centerX", "centerY", "", "a", "Landroid/graphics/Canvas;", PM.CANVAS, "Landroid/graphics/Paint;", "paint", "b", "Landroid/graphics/Bitmap;", "Landroid/graphics/Bitmap;", "getBitmap", "()Landroid/graphics/Bitmap;", "setBitmap", "(Landroid/graphics/Bitmap;)V", MimeHelper.IMAGE_SUBTYPE_BITMAP, "I", "getLeft", "()I", "setLeft", "(I)V", "left", "c", "getTop", "setTop", "top", "thumbHeight", "<init>", "(IILandroid/graphics/Bitmap;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Bitmap bitmap;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private int left;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private int top;

        public d(int i3, int i16, @Nullable Bitmap bitmap) {
            this.bitmap = bitmap;
            a(i3, i16);
        }

        public final void a(int centerX, int centerY) {
            int i3;
            Bitmap bitmap = this.bitmap;
            int i16 = 0;
            if (bitmap != null) {
                i3 = bitmap.getWidth();
            } else {
                i3 = 0;
            }
            Bitmap bitmap2 = this.bitmap;
            if (bitmap2 != null) {
                i16 = bitmap2.getHeight();
            }
            this.left = centerX - (i3 / 2);
            this.top = centerY - (i16 / 2);
        }

        public final void b(@NotNull Canvas canvas, @Nullable Paint paint) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            Bitmap bitmap = this.bitmap;
            if (bitmap != null) {
                canvas.drawBitmap(bitmap, this.left, this.top, paint);
            }
        }

        public final int c() {
            Bitmap bitmap = this.bitmap;
            if (bitmap != null) {
                return bitmap.getHeight();
            }
            return 0;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u000b\u0012\u0006\u0010\u0018\u001a\u00020\u0012\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0019\u00a2\u0006\u0004\b$\u0010%J\"\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\u0010\b\u001a\u00060\u0006R\u00020\u0007R\"\u0010\u0011\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0018\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010 \u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0011\u0010#\u001a\u00020!8F\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\"\u00a8\u0006&"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/font/QQLiveRangeButtonView$e;", "", "Landroid/graphics/Canvas;", PM.CANVAS, "Landroid/graphics/Paint;", "paint", "Lcom/tencent/timi/game/liveroom/impl/room/font/QQLiveRangeButtonView$c;", "Lcom/tencent/timi/game/liveroom/impl/room/font/QQLiveRangeButtonView;", "params", "", "a", "", "Ljava/lang/String;", "getText", "()Ljava/lang/String;", IECSearchBar.METHOD_SET_TEXT, "(Ljava/lang/String;)V", "text", "", "b", UserInfo.SEX_FEMALE, "()F", "setTextSize", "(F)V", "textSize", "Landroid/graphics/Point;", "c", "Landroid/graphics/Point;", "getPoint", "()Landroid/graphics/Point;", "d", "(Landroid/graphics/Point;)V", "point", "", "()I", "textWidth", "<init>", "(Ljava/lang/String;FLandroid/graphics/Point;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class e {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private String text;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private float textSize;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Point point;

        @JvmOverloads
        public e(@NotNull String text, float f16, @Nullable Point point) {
            Intrinsics.checkNotNullParameter(text, "text");
            this.text = text;
            this.textSize = f16;
            this.point = point;
        }

        public final void a(@NotNull Canvas canvas, @NotNull Paint paint, @NotNull c params) {
            float f16;
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            Intrinsics.checkNotNullParameter(paint, "paint");
            Intrinsics.checkNotNullParameter(params, "params");
            if (this.point == null) {
                return;
            }
            paint.setTextSize(this.textSize);
            int color = paint.getColor();
            paint.setColor(params.getTitleColor());
            paint.setTypeface(Typeface.DEFAULT_BOLD);
            String str = this.text;
            Point point = this.point;
            float f17 = 0.0f;
            if (point != null) {
                f16 = point.x;
            } else {
                f16 = 0.0f;
            }
            if (point != null) {
                f17 = point.y;
            }
            canvas.drawText(str, f16, f17, paint);
            paint.setColor(color);
        }

        /* renamed from: b, reason: from getter */
        public final float getTextSize() {
            return this.textSize;
        }

        public final int c() {
            return (int) QQLiveRangeButtonView.INSTANCE.a(this.text, this.textSize);
        }

        public final void d(@Nullable Point point) {
            this.point = point;
        }

        public /* synthetic */ e(String str, float f16, Point point, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, f16, (i3 & 4) != 0 ? null : point);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J&\u0010\r\u001a\u00020\u00062\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\u0006\u0010\f\u001a\u00020\tR\u001c\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/font/QQLiveRangeButtonView$f;", "", "Landroid/graphics/Canvas;", PM.CANVAS, "Landroid/graphics/Paint;", "paint", "", "a", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "xs", "y", "b", "", "Lcom/tencent/timi/game/liveroom/impl/room/font/QQLiveRangeButtonView$e;", "Ljava/util/List;", "titles", "<init>", "(Lcom/tencent/timi/game/liveroom/impl/room/font/QQLiveRangeButtonView;Ljava/util/List;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public final class f {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final List<e> titles;

        public f(@Nullable List<e> list) {
            this.titles = list;
        }

        public final void a(@NotNull Canvas canvas, @NotNull Paint paint) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            Intrinsics.checkNotNullParameter(paint, "paint");
            List<e> list = this.titles;
            if (list == null) {
                return;
            }
            Iterator<e> it = list.iterator();
            while (it.hasNext()) {
                it.next().a(canvas, paint, QQLiveRangeButtonView.this.mRangeButtonParams);
            }
        }

        public final void b(@NotNull ArrayList<Integer> xs5, int y16) {
            Intrinsics.checkNotNullParameter(xs5, "xs");
            if (this.titles == null) {
                return;
            }
            int size = xs5.size();
            for (int i3 = 0; i3 < size; i3++) {
                e eVar = this.titles.get(i3);
                eVar.d(new Point(xs5.get(i3).intValue() - (eVar.c() >> 1), y16));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0010\u0007\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u00a2\u0006\u0004\b+\u0010,J6\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002J\"\u0010\u0013\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\n\u0010\u0011\u001a\u00060\u000fR\u00020\u0010R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0014R\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0018\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0014\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\u001d\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u0017\"\u0004\b\u001b\u0010\u001cR2\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001e\u0010 \"\u0004\b!\u0010\"R\"\u0010)\u001a\u00020$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b\u0015\u0010'\"\u0004\b%\u0010(R\u0011\u0010*\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u0017\u00a8\u0006-"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/font/QQLiveRangeButtonView$g;", "", "", "startX", "endX", "y", "number", "Ljava/util/ArrayList;", "Landroid/graphics/Point;", "Lkotlin/collections/ArrayList;", "a", "Landroid/graphics/Canvas;", PM.CANVAS, "Landroid/graphics/Paint;", "paint", "Lcom/tencent/timi/game/liveroom/impl/room/font/QQLiveRangeButtonView$c;", "Lcom/tencent/timi/game/liveroom/impl/room/font/QQLiveRangeButtonView;", "params", "", "b", "I", "c", "getCenterY", "()I", "centerY", "d", "getUnitNum", "setUnitNum", "(I)V", "unitNum", "e", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "setUnitPoints", "(Ljava/util/ArrayList;)V", "unitPoints", "", "f", UserInfo.SEX_FEMALE, "()F", "(F)V", "height", "uintSpace", "<init>", "(IIII)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class g {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int startX;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int endX;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final int centerY;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int unitNum;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private ArrayList<Point> unitPoints;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private float height;

        public g(int i3, int i16, int i17, int i18) {
            this.startX = i3;
            this.endX = i16;
            this.centerY = i17;
            this.unitNum = i18;
            this.unitPoints = new ArrayList<>();
            this.unitPoints = a(i3, i16, i17, this.unitNum);
        }

        @NotNull
        public final ArrayList<Point> a(int startX, int endX, int y16, int number) {
            int i3;
            ArrayList<Point> arrayList = new ArrayList<>(number);
            int i16 = (int) ((endX - startX) / (number - 1));
            for (int i17 = 0; i17 < number; i17++) {
                if (i17 == 0) {
                    i3 = 0;
                } else {
                    i3 = i16;
                }
                Point point = new Point(startX + i3, y16);
                arrayList.add(point);
                startX = point.x;
            }
            return arrayList;
        }

        public final void b(@NotNull Canvas canvas, @NotNull Paint paint, @NotNull c params) {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            Intrinsics.checkNotNullParameter(paint, "paint");
            Intrinsics.checkNotNullParameter(params, "params");
            int color = paint.getColor();
            float strokeWidth = paint.getStrokeWidth();
            paint.setColor(params.getLineColor());
            paint.setStrokeWidth(params.getLineWeight());
            float f16 = this.startX;
            int i3 = this.centerY;
            canvas.drawLine(f16, i3, this.endX, i3, paint);
            Iterator<Point> it = this.unitPoints.iterator();
            while (it.hasNext()) {
                Point next = it.next();
                int i16 = next.x;
                int i17 = next.y;
                float f17 = this.height;
                canvas.drawLine(i16, i17 - (f17 / 2.0f), i16, i17 + (f17 / 2.0f), paint);
            }
            paint.setColor(color);
            paint.setStrokeWidth(strokeWidth);
        }

        /* renamed from: c, reason: from getter */
        public final float getHeight() {
            return this.height;
        }

        public final int d() {
            return (int) ((this.endX - this.startX) / (this.unitNum - 1));
        }

        @NotNull
        public final ArrayList<Point> e() {
            return this.unitPoints;
        }

        public final void f(float f16) {
            this.height = f16;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QQLiveRangeButtonView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final float b() {
        List<e> list = this.mTitlesList;
        if (list != null) {
            TextPaint textPaint = new TextPaint();
            Iterator<e> it = list.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                textPaint.setTextSize(it.next().getTextSize());
                Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
                if (i3 - Math.abs(fontMetrics.top) < 0.0f) {
                    i3 = (int) Math.abs(fontMetrics.top);
                }
            }
            return i3;
        }
        return d(120.0f);
    }

    private final float c() {
        float f16;
        float b16 = b() + this.mRangeButtonParams.getLineOffset();
        float lineHeight = this.mRangeButtonParams.getLineHeight();
        Bitmap bitmap = this.mThumbBmp;
        if (bitmap != null) {
            f16 = bitmap.getHeight();
        } else {
            f16 = 0.0f;
        }
        return b16 + Math.max(lineHeight, f16);
    }

    private final float d(float value) {
        return TypedValue.applyDimension(1, value, getResources().getDisplayMetrics());
    }

    private final int e(int x16, int y16, int xRange, int yRange, boolean needCalc) {
        ArrayList<Point> arrayList;
        d dVar;
        g gVar = this.mUnitBar;
        if (gVar == null || (arrayList = gVar.e()) == null) {
            arrayList = new ArrayList<>();
        }
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            Point point = arrayList.get(i3);
            Intrinsics.checkNotNullExpressionValue(point, "points[i]");
            Point point2 = point;
            int i16 = point2.y;
            int i17 = i16 + yRange;
            if (y16 < i16 - yRange || y16 > i17) {
                break;
            }
            int i18 = point2.x;
            int i19 = i18 + xRange;
            boolean z16 = true;
            if ((i18 - xRange) + 1 > x16 || x16 >= i19) {
                z16 = false;
            }
            if (z16) {
                if (needCalc && (dVar = this.mThumbDrawer) != null) {
                    dVar.a(i18, i16);
                }
                return i3;
            }
        }
        return -1;
    }

    @Override // android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        int i3;
        int i16;
        float f16;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        if (this.mTitleDrawer == null) {
            c cVar = this.mRangeButtonParams;
            List<e> list = this.mTitlesList;
            int i17 = 0;
            if (list != null) {
                i3 = list.size();
            } else {
                i3 = 0;
            }
            cVar.t(i3);
            int paddingLeft = (int) (getPaddingLeft() + this.mRangeButtonParams.getBarLeftPadding());
            int width = (int) ((getWidth() - this.mRangeButtonParams.getBarRightPadding()) - getPaddingRight());
            if (this.isTitleUp2Line) {
                i16 = (int) (this.mRangeButtonParams.getTitleTopPadding() + this.mRangeButtonParams.getLineOffset() + b());
            } else {
                float titleTopPadding = this.mRangeButtonParams.getTitleTopPadding();
                Bitmap bitmap = this.mThumbBmp;
                if (bitmap != null) {
                    i17 = bitmap.getHeight();
                }
                i16 = (int) (titleTopPadding + (i17 / 2.0f));
            }
            g gVar = new g(paddingLeft, width, i16, this.mRangeButtonParams.getUnitCount());
            gVar.f(this.mRangeButtonParams.getLineHeight());
            this.mUnitBar = gVar;
            ArrayList<Point> e16 = gVar.e();
            ArrayList<Integer> arrayList = new ArrayList<>(e16.size());
            Iterator<Point> it = e16.iterator();
            while (it.hasNext()) {
                arrayList.add(Integer.valueOf(it.next().x));
            }
            Point point = gVar.e().get(this.mCurrentPosition);
            Intrinsics.checkNotNullExpressionValue(point, "it.unitPoints[mCurrentPosition]");
            Point point2 = point;
            this.mThumbDrawer = new d(point2.x, point2.y, this.mThumbBmp);
            f fVar = new f(this.mTitlesList);
            if (this.isTitleUp2Line) {
                fVar.b(arrayList, (int) (this.mRangeButtonParams.getTitleTopPadding() + b()));
            } else {
                d dVar = this.mThumbDrawer;
                if (dVar != null) {
                    f16 = dVar.c();
                } else {
                    f16 = 0.0f;
                }
                fVar.b(arrayList, (int) (this.mRangeButtonParams.getTitleTopPadding() + ((int) Math.max(f16, gVar.getHeight())) + this.mRangeButtonParams.getLineOffset()));
            }
            this.mTitleDrawer = fVar;
        }
        f fVar2 = this.mTitleDrawer;
        if (fVar2 != null) {
            fVar2.a(canvas, this.mTextPaint);
        }
        g gVar2 = this.mUnitBar;
        if (gVar2 != null) {
            gVar2.b(canvas, this.mTextPaint, this.mRangeButtonParams);
        }
        d dVar2 = this.mThumbDrawer;
        if (dVar2 != null) {
            dVar2.b(canvas, this.mTextPaint);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int c16 = (int) c();
        int mode = View.MeasureSpec.getMode(heightMeasureSpec);
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        if (mode != Integer.MIN_VALUE) {
            if (mode != 1073741824) {
                size2 = (int) (c16 + getPaddingTop() + this.mRangeButtonParams.getTitleTopPadding());
            }
        } else {
            size2 = Math.min(c16, size2);
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        int i3;
        Intrinsics.checkNotNullParameter(event, "event");
        int action = event.getAction();
        float x16 = event.getX();
        float y16 = event.getY();
        if (action == 0 || action == 1 || action == 2 || action == 3) {
            g gVar = this.mUnitBar;
            int i16 = 0;
            if (gVar == null || this.mThumbDrawer == null) {
                return false;
            }
            if (gVar != null) {
                i3 = gVar.d();
            } else {
                i3 = 0;
            }
            int i17 = i3 / 2;
            d dVar = this.mThumbDrawer;
            if (dVar != null) {
                i16 = dVar.c();
            }
            int e16 = e((int) x16, (int) y16, i17, i16 / 2, true);
            int i18 = this.mCurrentPosition;
            if (e16 != i18 && e16 != -1) {
                b bVar = this.mListener;
                if (bVar != null) {
                    bVar.onChange(i18, e16);
                }
                this.mCurrentPosition = e16;
                invalidate();
            }
        }
        return true;
    }

    public final void setOnChangerListener(@Nullable b listener) {
        this.mListener = listener;
    }

    public final void setThumbPosition(int i3) {
        this.mCurrentPosition = i3;
        g gVar = this.mUnitBar;
        if (gVar != null) {
            Point point = gVar.e().get(i3);
            Intrinsics.checkNotNullExpressionValue(point, "it.unitPoints[position]");
            Point point2 = point;
            d dVar = this.mThumbDrawer;
            if (dVar != null) {
                dVar.a(point2.x, point2.y);
            }
            invalidate();
        }
    }

    public final void setTitleColor(@ColorInt int color) {
        this.mRangeButtonParams.r(color);
    }

    public final void setTitleData(@Nullable List<e> data) {
        this.mTitlesList = data;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QQLiveRangeButtonView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ QQLiveRangeButtonView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? R.attr.listViewStyle : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QQLiveRangeButtonView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.isTitleUp2Line = true;
        this.mRangeButtonParams = new c();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.f417286g4, 0, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026iveRangeButtonView, 0, 0)");
        this.mRangeButtonParams.k(obtainStyledAttributes.getDimension(a.f417295h4, d(26.0f)));
        this.mRangeButtonParams.l(obtainStyledAttributes.getDimension(a.f417303i4, d(26.0f)));
        this.mRangeButtonParams.s(obtainStyledAttributes.getDimension(a.f417361p4, d(8.0f)));
        this.mRangeButtonParams.r(obtainStyledAttributes.getColor(a.f417352o4, R.color.background_dark));
        this.mRangeButtonParams.o(obtainStyledAttributes.getDimension(a.f417327l4, d(24.0f)));
        this.mRangeButtonParams.m(obtainStyledAttributes.getColor(a.f417311j4, R.color.background_dark));
        this.mRangeButtonParams.n(obtainStyledAttributes.getDimension(a.f417319k4, d(8.0f)));
        this.mRangeButtonParams.p(obtainStyledAttributes.getDimension(a.f417335m4, d(1.0f)));
        this.mRangeButtonParams.q(obtainStyledAttributes.getResourceId(a.f417343n4, com.tencent.mobileqq.R.drawable.h_4));
        obtainStyledAttributes.recycle();
        TextPaint textPaint = new TextPaint();
        this.mTextPaint = textPaint;
        textPaint.setAntiAlias(true);
        this.mThumbBmp = BitmapFactory.decodeResource(getResources(), this.mRangeButtonParams.getThumbSrcId());
    }
}
