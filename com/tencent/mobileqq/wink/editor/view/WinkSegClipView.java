package com.tencent.mobileqq.wink.editor.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.Space;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.editor.clipping.thumbnail.o;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.PlayTrackExpandWidthView;
import com.tencent.mobileqq.wink.picker.core.ktx.ViewExKt;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.ResourceModel;
import com.tencent.videocut.utils.r;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0093\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t*\u0001S\u0018\u0000 d2\u00020\u0001:\u0004efg'B\u0011\b\u0016\u0012\u0006\u0010\\\u001a\u00020[\u00a2\u0006\u0004\b]\u0010^B\u001b\b\u0016\u0012\u0006\u0010\\\u001a\u00020[\u0012\b\u0010`\u001a\u0004\u0018\u00010_\u00a2\u0006\u0004\b]\u0010aB#\b\u0016\u0012\u0006\u0010\\\u001a\u00020[\u0012\b\u0010`\u001a\u0004\u0018\u00010_\u0012\u0006\u0010b\u001a\u00020\u0010\u00a2\u0006\u0004\b]\u0010cJ\b\u0010\u0003\u001a\u00020\u0002H\u0003J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0002J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0010H\u0014J\u0010\u0010\u0018\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0006\u0010\u0019\u001a\u00020\u0002J\u0010\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u001aH\u0007J\u0010\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001cH\u0007J\b\u0010\u001f\u001a\u00020\u0002H\u0007J\u000e\u0010\"\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 J\u0006\u0010#\u001a\u00020\u001aJ\u000e\u0010&\u001a\u00020\u00022\u0006\u0010%\u001a\u00020$R\u0016\u0010)\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010(R\u0016\u0010-\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010(R\u0016\u00100\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00101\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010/R\u0016\u00104\u001a\u0004\u0018\u0001028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u00103R\u0016\u00106\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010/R\u0014\u0010:\u001a\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010A\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010G\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010?R\u0018\u0010I\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010HR\u001e\u0010M\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR$\u0010R\u001a\u00020\u00102\u0006\u0010N\u001a\u00020\u00108\u0002@BX\u0082\u000e\u00a2\u0006\f\n\u0004\bO\u0010/\"\u0004\bP\u0010QR\u0014\u0010V\u001a\u00020S8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0014\u0010Z\u001a\u00020W8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bX\u0010Y\u00a8\u0006h"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/view/WinkSegClipView;", "Landroid/widget/FrameLayout;", "", "p", "", "timeUs", "v", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Landroid/graphics/Canvas;", PM.CANVAS, "j", "Landroid/view/MotionEvent;", "event", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o", DomainData.DOMAIN_NAME, "", "px", "t", "y", "l", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "draw", "i", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/mobileqq/wink/editor/view/WinkSegClipView$d;", "model", "setSegClipModel", "u", "Lcom/tencent/mobileqq/wink/editor/view/WinkSegClipView$c;", "callback", "setSegClipCallback", "k", "", "show", "setNeedShowStartTimeText", "d", "Z", "needShowStartTimeText", "e", "durationWithKeepZerosAfterPoint", "f", "needMask", tl.h.F, "I", "singleThumbWidth", "thumbHeight", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Drawable;", "segDurationBg", BdhLogUtil.LogTag.Tag_Conn, "screeWidth", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/o;", "D", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/o;", "thumbProvider", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/f;", "E", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/f;", "thumbProviderListener", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/wink/editor/view/WinkSegClipView$d;", "segClipModel", "Lcom/tencent/mobileqq/wink/editor/view/WinkSegClipView$b;", "G", "Lcom/tencent/mobileqq/wink/editor/view/WinkSegClipView$b;", "scaleFactor", "H", "lastCursorTouchX", "Lcom/tencent/mobileqq/wink/editor/view/WinkSegClipView$c;", "segClipCallback", "Lmqq/util/WeakReference;", "J", "Lmqq/util/WeakReference;", "segClipCallbackWeakRef", "value", "K", "w", "(I)V", NodeProps.BORDER_WIDTH, "com/tencent/mobileqq/wink/editor/view/WinkSegClipView$f", "L", "Lcom/tencent/mobileqq/wink/editor/view/WinkSegClipView$f;", "videoThumbProvider", "Landroid/graphics/Paint;", "M", "Landroid/graphics/Paint;", "maskPaint", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "P", "a", "b", "c", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkSegClipView extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private int screeWidth;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final o thumbProvider;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.f thumbProviderListener;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private SegClipModel segClipModel;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private ScaleFactor scaleFactor;

    /* renamed from: H, reason: from kotlin metadata */
    private float lastCursorTouchX;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private c segClipCallback;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private WeakReference<c> segClipCallbackWeakRef;

    /* renamed from: K, reason: from kotlin metadata */
    private int borderWidth;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final f videoThumbProvider;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final Paint maskPaint;

    @NotNull
    public Map<Integer, View> N;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean needShowStartTimeText;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean durationWithKeepZerosAfterPoint;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean needMask;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int singleThumbWidth;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int thumbHeight;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Drawable segDurationBg;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\b\u0082\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/view/WinkSegClipView$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "px", "", "b", "J", "()J", "timeUs", "<init>", "(IJ)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.editor.view.WinkSegClipView$b, reason: from toString */
    /* loaded from: classes21.dex */
    public static final /* data */ class ScaleFactor {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int px;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final long timeUs;

        public ScaleFactor() {
            this(0, 0L, 3, null);
        }

        /* renamed from: a, reason: from getter */
        public final int getPx() {
            return this.px;
        }

        /* renamed from: b, reason: from getter */
        public final long getTimeUs() {
            return this.timeUs;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ScaleFactor)) {
                return false;
            }
            ScaleFactor scaleFactor = (ScaleFactor) other;
            if (this.px == scaleFactor.px && this.timeUs == scaleFactor.timeUs) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.px * 31) + androidx.fragment.app.a.a(this.timeUs);
        }

        @NotNull
        public String toString() {
            return "ScaleFactor(px=" + this.px + ", timeUs=" + this.timeUs + ")";
        }

        public ScaleFactor(int i3, long j3) {
            this.px = i3;
            this.timeUs = j3;
        }

        public /* synthetic */ ScaleFactor(int i3, long j3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this((i16 & 1) != 0 ? 1 : i3, (i16 & 2) != 0 ? 1L : j3);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\u0002H&J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004H&J\b\u0010\n\u001a\u00020\u0002H&J\b\u0010\u000b\u001a\u00020\u0002H&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/view/WinkSegClipView$c;", "", "", "b", "", "startTimeUs", "a", "c", "timeUs", "e", "d", "f", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public interface c {
        void a(long startTimeUs);

        void b();

        void c();

        void d();

        void e(long timeUs);

        void f();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/wink/editor/view/WinkSegClipView$e", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/f;", "", "tag", "", "startTimeMs", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class e implements com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.f {
        e() {
        }

        @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.f
        public void a(@Nullable Object tag, long startTimeMs, @Nullable Bitmap bitmap) {
            SegClipModel segClipModel = WinkSegClipView.this.segClipModel;
            if (segClipModel != null) {
                WinkSegClipView winkSegClipView = WinkSegClipView.this;
                if (Intrinsics.areEqual(tag, com.tencent.videocut.render.extension.e.n(segClipModel.getMediaClip()))) {
                    ((PlayTrackExpandWidthView) winkSegClipView.e(R.id.f1172370w)).postInvalidate();
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/wink/editor/view/WinkSegClipView$f", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/videotrack/e;", "", "offset", "", "tag", "Landroid/graphics/Bitmap;", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class f implements com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.e {
        f() {
        }

        @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.e
        @Nullable
        public Bitmap a(int offset, @Nullable Object tag) {
            MediaClip mediaClip;
            ResourceModel resourceModel;
            String str;
            String str2;
            MediaClip mediaClip2;
            SegClipModel segClipModel = WinkSegClipView.this.segClipModel;
            if (segClipModel != null && (mediaClip = segClipModel.getMediaClip()) != null && (resourceModel = mediaClip.resource) != null && (str = resourceModel.path) != null) {
                long t16 = WinkSegClipView.this.t(offset);
                o oVar = WinkSegClipView.this.thumbProvider;
                SegClipModel segClipModel2 = WinkSegClipView.this.segClipModel;
                if (segClipModel2 != null && (mediaClip2 = segClipModel2.getMediaClip()) != null) {
                    str2 = com.tencent.videocut.render.extension.e.n(mediaClip2);
                } else {
                    str2 = null;
                }
                Bitmap bitmapByTime = oVar.getBitmapByTime(t16, str2, str);
                if (bitmapByTime == null) {
                    return WinkSegClipView.this.thumbProvider.getDefaultBitmap();
                }
                return bitmapByTime;
            }
            return WinkSegClipView.this.thumbProvider.getDefaultBitmap();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WinkSegClipView(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void A(float timeUs) {
        boolean z16;
        if (timeUs == 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            ((TextView) e(R.id.f1056166h)).setText("0s");
            return;
        }
        float e16 = r.f384266a.e(timeUs / l());
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(Locale.getDefault(), "%.1fs", Arrays.copyOf(new Object[]{Float.valueOf(e16)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(locale, format, *args)");
        ((TextView) e(R.id.f1056166h)).setText(format);
    }

    private final void j(Canvas canvas) {
        int coerceIn;
        int coerceIn2;
        if (!this.needMask) {
            return;
        }
        int i3 = (this.screeWidth - this.borderWidth) / 2;
        int left = e(R.id.f115896x_).getLeft();
        coerceIn = RangesKt___RangesKt.coerceIn(((HorizontalScrollView) e(R.id.ii_)).getScrollX(), 0, i3);
        int i16 = left - coerceIn;
        if (left > i16) {
            canvas.drawRect(new Rect(i16, ((HorizontalScrollView) e(R.id.ii_)).getTop(), left, ((HorizontalScrollView) e(R.id.ii_)).getBottom()), this.maskPaint);
        }
        int right = e(R.id.f115896x_).getRight();
        coerceIn2 = RangesKt___RangesKt.coerceIn((((PlayTrackExpandWidthView) e(R.id.f1172370w)).getMeasuredWidth() - this.borderWidth) - ((HorizontalScrollView) e(R.id.ii_)).getScrollX(), 0, i3);
        int i17 = coerceIn2 + right;
        if (i17 > right) {
            canvas.drawRect(new Rect(right, ((HorizontalScrollView) e(R.id.ii_)).getTop(), i17, ((HorizontalScrollView) e(R.id.ii_)).getBottom()), this.maskPaint);
        }
    }

    private final float l() {
        SegClipModel segClipModel = this.segClipModel;
        if (segClipModel != null) {
            return segClipModel.getSpeedRate();
        }
        return 1.0f;
    }

    private final void m(MotionEvent event) {
        c cVar = this.segClipCallback;
        if (cVar != null) {
            cVar.d();
        }
        this.lastCursorTouchX = event.getRawX();
    }

    private final void n(MotionEvent event) {
        int coerceIn;
        e(R.id.f115896x_).getLocationOnScreen(new int[2]);
        coerceIn = RangesKt___RangesKt.coerceIn((int) (event.getRawX() - r0[0]), 0, this.borderWidth);
        long t16 = t(coerceIn) + k();
        c cVar = this.segClipCallback;
        if (cVar != null) {
            cVar.e(((float) t16) / l());
        }
    }

    private final void o(MotionEvent event) {
        c cVar = this.segClipCallback;
        if (cVar != null) {
            cVar.f();
        }
        this.lastCursorTouchX = 0.0f;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void p() {
        this.screeWidth = getContext().getResources().getDisplayMetrics().widthPixels;
        LayoutInflater.from(getContext()).inflate(R.layout.hfs, this);
        ((HorizontalScrollView) e(R.id.ii_)).getLayoutParams().height = this.thumbHeight;
        e(R.id.f115896x_).getLayoutParams().height = this.thumbHeight + ViewExKt.d(4);
        ((ImageView) e(R.id.xyl)).getLayoutParams().height = (int) ((this.thumbHeight + ViewExKt.d(4)) * 1.4f);
        int i3 = 0;
        setWillNotDraw(false);
        if (this.thumbProviderListener == null) {
            this.thumbProviderListener = new e();
        }
        o oVar = this.thumbProvider;
        com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.f fVar = this.thumbProviderListener;
        Intrinsics.checkNotNull(fVar);
        oVar.b(fVar);
        ((TextView) e(R.id.f1055766d)).setBackground(this.segDurationBg);
        ((PlayTrackExpandWidthView) e(R.id.f1172370w)).setThumbProvider(this.videoThumbProvider);
        ((PlayTrackExpandWidthView) e(R.id.f1172370w)).setSingleBitmapWidth(this.singleThumbWidth);
        ((HorizontalScrollView) e(R.id.ii_)).setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.wink.editor.view.g
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean q16;
                q16 = WinkSegClipView.q(WinkSegClipView.this, view, motionEvent);
                return q16;
            }
        });
        ((HorizontalScrollView) e(R.id.ii_)).setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.tencent.mobileqq.wink.editor.view.h
            @Override // android.view.View.OnScrollChangeListener
            public final void onScrollChange(View view, int i16, int i17, int i18, int i19) {
                WinkSegClipView.r(WinkSegClipView.this, view, i16, i17, i18, i19);
            }
        });
        ((ImageView) e(R.id.xyl)).setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.wink.editor.view.i
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean s16;
                s16 = WinkSegClipView.s(WinkSegClipView.this, view, motionEvent);
                return s16;
            }
        });
        TextView textView = (TextView) e(R.id.f1056166h);
        if (!this.needShowStartTimeText) {
            i3 = 8;
        }
        textView.setVisibility(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean q(WinkSegClipView this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1) {
                c cVar = this$0.segClipCallback;
                if (cVar != null) {
                    cVar.c();
                }
                ((ImageView) this$0.e(R.id.xyl)).setVisibility(0);
            }
        } else {
            c cVar2 = this$0.segClipCallback;
            if (cVar2 != null) {
                cVar2.b();
            }
            ((ImageView) this$0.e(R.id.xyl)).setVisibility(8);
        }
        return ((HorizontalScrollView) this$0.e(R.id.ii_)).onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(WinkSegClipView this$0, View view, int i3, int i16, int i17, int i18) {
        c cVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((PlayTrackExpandWidthView) this$0.e(R.id.f1172370w)).invalidate();
        float t16 = this$0.t(i3);
        WeakReference<c> weakReference = this$0.segClipCallbackWeakRef;
        if (weakReference != null && (cVar = weakReference.get()) != null) {
            cVar.a(t16);
        }
        this$0.A(t16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean s(WinkSegClipView this$0, View view, MotionEvent event) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int action = event.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    Intrinsics.checkNotNullExpressionValue(event, "event");
                    this$0.n(event);
                }
            } else {
                Intrinsics.checkNotNullExpressionValue(event, "event");
                this$0.o(event);
            }
        } else {
            Intrinsics.checkNotNullExpressionValue(event, "event");
            this$0.m(event);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float t(int px5) {
        return (((float) (px5 * this.scaleFactor.getTimeUs())) * 1.0f) / this.scaleFactor.getPx();
    }

    private final void v(float timeUs) {
        ((HorizontalScrollView) e(R.id.ii_)).scrollTo((int) y(timeUs), 0);
    }

    private final void w(int i3) {
        boolean z16;
        if (this.borderWidth != i3) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.borderWidth = i3;
        SegClipModel segClipModel = this.segClipModel;
        if (segClipModel != null && z16) {
            setSegClipModel(segClipModel);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(WinkSegClipView this$0, SegClipModel model) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(model, "$model");
        this$0.v((float) model.getModifiedStartTime());
    }

    private final float y(float timeUs) {
        return (timeUs * this.scaleFactor.getPx()) / ((float) this.scaleFactor.getTimeUs());
    }

    @Override // android.view.View
    public void draw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.draw(canvas);
        j(canvas);
    }

    @Nullable
    public View e(int i3) {
        Map<Integer, View> map = this.N;
        View view = map.get(Integer.valueOf(i3));
        if (view == null) {
            View findViewById = findViewById(i3);
            if (findViewById != null) {
                map.put(Integer.valueOf(i3), findViewById);
                return findViewById;
            }
            return null;
        }
        return view;
    }

    public final void i() {
        com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.f fVar = this.thumbProviderListener;
        if (fVar != null) {
            o oVar = this.thumbProvider;
            Intrinsics.checkNotNull(fVar);
            oVar.c(fVar);
            this.thumbProviderListener = null;
        }
        this.segClipCallback = null;
        ms.a.f("WinkSegClipView", "destroyView.");
    }

    public final long k() {
        return t(((HorizontalScrollView) e(R.id.ii_)).getScrollX());
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        measureChildren(widthMeasureSpec, heightMeasureSpec);
        int measuredWidth = (((HorizontalScrollView) e(R.id.ii_)).getMeasuredWidth() - e(R.id.f115896x_).getMeasuredWidth()) / 2;
        ((HorizontalScrollView) e(R.id.ii_)).setPadding(measuredWidth, 0, measuredWidth, 0);
        w(e(R.id.f115896x_).getMeasuredWidth());
    }

    public final void setNeedShowStartTimeText(boolean show) {
        int i3;
        TextView textView = (TextView) e(R.id.f1056166h);
        if (show) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        textView.setVisibility(i3);
    }

    public final void setSegClipCallback(@NotNull c callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.segClipCallback = callback;
        this.segClipCallbackWeakRef = new WeakReference<>(this.segClipCallback);
    }

    @MainThread
    public final void setSegClipModel(@NotNull final SegClipModel model) {
        String removeSuffix;
        String str;
        long coerceAtLeast;
        Intrinsics.checkNotNullParameter(model, "model");
        this.segClipModel = model;
        this.scaleFactor = new ScaleFactor(e(R.id.f115896x_).getMeasuredWidth(), model.getSelectDuration());
        float e16 = r.f384266a.e(((float) model.getSelectDuration()) / l());
        if (this.durationWithKeepZerosAfterPoint) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%.1f", Arrays.copyOf(new Object[]{Float.valueOf(e16)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            str = format + ReportConstant.COSTREPORT_PREFIX;
        } else {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String format2 = String.format("%.1f", Arrays.copyOf(new Object[]{Float.valueOf(e16)}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
            removeSuffix = StringsKt__StringsKt.removeSuffix(format2, (CharSequence) ".0");
            str = removeSuffix + ReportConstant.COSTREPORT_PREFIX;
        }
        ((TextView) e(R.id.f1055766d)).setText(str);
        PlayTrackExpandWidthView playTrackExpandWidthView = (PlayTrackExpandWidthView) e(R.id.f1172370w);
        ViewGroup.LayoutParams layoutParams = ((PlayTrackExpandWidthView) e(R.id.f1172370w)).getLayoutParams();
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(model.getSourceDuration(), model.getSelectDuration());
        layoutParams.width = (int) y((float) coerceAtLeast);
        playTrackExpandWidthView.setLayoutParams(layoutParams);
        invalidate();
        post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.view.j
            @Override // java.lang.Runnable
            public final void run() {
                WinkSegClipView.x(WinkSegClipView.this, model);
            }
        });
    }

    @MainThread
    public final void u() {
        ((PlayTrackExpandWidthView) e(R.id.f1172370w)).postInvalidate();
    }

    @MainThread
    public final void z(long timeUs) {
        int coerceIn;
        int y16 = (int) (y(((float) timeUs) * l()) - ((HorizontalScrollView) e(R.id.ii_)).getScrollX());
        if (y16 >= 0 && y16 <= this.borderWidth) {
            ((ImageView) e(R.id.xyl)).setVisibility(0);
        } else {
            ((ImageView) e(R.id.xyl)).setVisibility(8);
        }
        Space space = (Space) e(R.id.f116046xo);
        ViewGroup.LayoutParams layoutParams = ((Space) e(R.id.f116046xo)).getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        coerceIn = RangesKt___RangesKt.coerceIn(y16, 0, this.borderWidth);
        ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin = coerceIn;
        space.setLayoutParams(layoutParams2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WinkSegClipView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkSegClipView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.N = new LinkedHashMap();
        this.needShowStartTimeText = true;
        this.needMask = true;
        this.singleThumbWidth = com.tencent.videocut.utils.e.f384236a.a(56.0f);
        this.thumbProvider = o.f319264a;
        this.scaleFactor = new ScaleFactor(0, 0L, 3, null);
        this.videoThumbProvider = new f();
        Paint paint = new Paint();
        paint.setColor(ContextCompat.getColor(getContext(), R.color.bdr));
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        this.maskPaint = paint;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.tencent.mobileqq.wink.j.R9);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026tyleable.WinkSegClipView)");
        this.needShowStartTimeText = obtainStyledAttributes.getBoolean(com.tencent.mobileqq.wink.j.V9, this.needShowStartTimeText);
        this.durationWithKeepZerosAfterPoint = obtainStyledAttributes.getBoolean(com.tencent.mobileqq.wink.j.S9, this.durationWithKeepZerosAfterPoint);
        this.needMask = obtainStyledAttributes.getBoolean(com.tencent.mobileqq.wink.j.T9, this.needMask);
        this.singleThumbWidth = obtainStyledAttributes.getDimensionPixelSize(com.tencent.mobileqq.wink.j.W9, this.singleThumbWidth);
        this.thumbHeight = obtainStyledAttributes.getDimensionPixelSize(com.tencent.mobileqq.wink.j.X9, context.getResources().getDimensionPixelSize(R.dimen.djg));
        Drawable drawable = obtainStyledAttributes.getDrawable(com.tencent.mobileqq.wink.j.U9);
        this.segDurationBg = drawable == null ? ContextCompat.getDrawable(context, R.drawable.m36) : drawable;
        obtainStyledAttributes.recycle();
        p();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u00a2\u0006\u0004\b\"\u0010#JE\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u0006H\u00c6\u0001J\t\u0010\r\u001a\u00020\fH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u000eH\u00d6\u0001J\u0013\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0007\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001a\u001a\u0004\b\u001e\u0010\u001cR\u0017\u0010\t\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b\u001f\u0010\u001cR\"\u0010\n\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001a\u001a\u0004\b\u001d\u0010\u001c\"\u0004\b \u0010!\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/view/WinkSegClipView$d;", "", "Lcom/tencent/videocut/model/MediaClip;", "mediaClip", "", "speedRate", "", "sourceDuration", "selectDuration", "originStartTime", "modifiedStartTime", "a", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/videocut/model/MediaClip;", "c", "()Lcom/tencent/videocut/model/MediaClip;", "b", UserInfo.SEX_FEMALE, tl.h.F, "()F", "J", "g", "()J", "d", "f", "e", "i", "(J)V", "<init>", "(Lcom/tencent/videocut/model/MediaClip;FJJJJ)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.editor.view.WinkSegClipView$d, reason: from toString */
    /* loaded from: classes21.dex */
    public static final /* data */ class SegClipModel {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final MediaClip mediaClip;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final float speedRate;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final long sourceDuration;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final long selectDuration;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final long originStartTime;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private long modifiedStartTime;

        public SegClipModel(@NotNull MediaClip mediaClip, float f16, long j3, long j16, long j17, long j18) {
            Intrinsics.checkNotNullParameter(mediaClip, "mediaClip");
            this.mediaClip = mediaClip;
            this.speedRate = f16;
            this.sourceDuration = j3;
            this.selectDuration = j16;
            this.originStartTime = j17;
            this.modifiedStartTime = j18;
        }

        public static /* synthetic */ SegClipModel b(SegClipModel segClipModel, MediaClip mediaClip, float f16, long j3, long j16, long j17, long j18, int i3, Object obj) {
            MediaClip mediaClip2;
            float f17;
            long j19;
            long j26;
            long j27;
            long j28;
            if ((i3 & 1) != 0) {
                mediaClip2 = segClipModel.mediaClip;
            } else {
                mediaClip2 = mediaClip;
            }
            if ((i3 & 2) != 0) {
                f17 = segClipModel.speedRate;
            } else {
                f17 = f16;
            }
            if ((i3 & 4) != 0) {
                j19 = segClipModel.sourceDuration;
            } else {
                j19 = j3;
            }
            if ((i3 & 8) != 0) {
                j26 = segClipModel.selectDuration;
            } else {
                j26 = j16;
            }
            if ((i3 & 16) != 0) {
                j27 = segClipModel.originStartTime;
            } else {
                j27 = j17;
            }
            if ((i3 & 32) != 0) {
                j28 = segClipModel.modifiedStartTime;
            } else {
                j28 = j18;
            }
            return segClipModel.a(mediaClip2, f17, j19, j26, j27, j28);
        }

        @NotNull
        public final SegClipModel a(@NotNull MediaClip mediaClip, float speedRate, long sourceDuration, long selectDuration, long originStartTime, long modifiedStartTime) {
            Intrinsics.checkNotNullParameter(mediaClip, "mediaClip");
            return new SegClipModel(mediaClip, speedRate, sourceDuration, selectDuration, originStartTime, modifiedStartTime);
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final MediaClip getMediaClip() {
            return this.mediaClip;
        }

        /* renamed from: d, reason: from getter */
        public final long getModifiedStartTime() {
            return this.modifiedStartTime;
        }

        /* renamed from: e, reason: from getter */
        public final long getOriginStartTime() {
            return this.originStartTime;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SegClipModel)) {
                return false;
            }
            SegClipModel segClipModel = (SegClipModel) other;
            if (Intrinsics.areEqual(this.mediaClip, segClipModel.mediaClip) && Float.compare(this.speedRate, segClipModel.speedRate) == 0 && this.sourceDuration == segClipModel.sourceDuration && this.selectDuration == segClipModel.selectDuration && this.originStartTime == segClipModel.originStartTime && this.modifiedStartTime == segClipModel.modifiedStartTime) {
                return true;
            }
            return false;
        }

        /* renamed from: f, reason: from getter */
        public final long getSelectDuration() {
            return this.selectDuration;
        }

        /* renamed from: g, reason: from getter */
        public final long getSourceDuration() {
            return this.sourceDuration;
        }

        /* renamed from: h, reason: from getter */
        public final float getSpeedRate() {
            return this.speedRate;
        }

        public int hashCode() {
            return (((((((((this.mediaClip.hashCode() * 31) + Float.floatToIntBits(this.speedRate)) * 31) + androidx.fragment.app.a.a(this.sourceDuration)) * 31) + androidx.fragment.app.a.a(this.selectDuration)) * 31) + androidx.fragment.app.a.a(this.originStartTime)) * 31) + androidx.fragment.app.a.a(this.modifiedStartTime);
        }

        public final void i(long j3) {
            this.modifiedStartTime = j3;
        }

        @NotNull
        public String toString() {
            return "SegClipModel(mediaClip=" + this.mediaClip + ", speedRate=" + this.speedRate + ", sourceDuration=" + this.sourceDuration + ", selectDuration=" + this.selectDuration + ", originStartTime=" + this.originStartTime + ", modifiedStartTime=" + this.modifiedStartTime + ")";
        }

        public /* synthetic */ SegClipModel(MediaClip mediaClip, float f16, long j3, long j16, long j17, long j18, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(mediaClip, (i3 & 2) != 0 ? 1.0f : f16, j3, j16, j17, j18);
        }
    }
}
