package com.caverock.androidsvg;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.util.Base64;
import android.util.Log;
import com.caverock.androidsvg.CSSParser;
import com.caverock.androidsvg.PreserveAspectRatio;
import com.caverock.androidsvg.SVG;
import com.google.android.exoplayer2.C;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.vaswebviewplugin.VasBusiness;
import com.tencent.thumbplayer.api.common.TPChannelLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.Stack;

/* compiled from: P */
/* loaded from: classes.dex */
public class SVGAndroidRenderer {
    private static /* synthetic */ int[] $SWITCH_TABLE$com$caverock$androidsvg$PreserveAspectRatio$Alignment = null;
    private static /* synthetic */ int[] $SWITCH_TABLE$com$caverock$androidsvg$SVG$Style$FillRule = null;
    private static /* synthetic */ int[] $SWITCH_TABLE$com$caverock$androidsvg$SVG$Style$LineCaps = null;
    private static /* synthetic */ int[] $SWITCH_TABLE$com$caverock$androidsvg$SVG$Style$LineJoin = null;
    private static final float BEZIER_ARC_FACTOR = 0.5522848f;
    private static final String DEFAULT_FONT_FAMILY = "sans-serif";
    private static final int LUMINANCE_FACTOR_SHIFT = 15;
    private static final int LUMINANCE_TO_ALPHA_BLUE = 2362;
    private static final int LUMINANCE_TO_ALPHA_GREEN = 23442;
    private static final int LUMINANCE_TO_ALPHA_RED = 6963;
    private static final String TAG = "SVGAndroidRenderer";
    private Stack<Bitmap> bitmapStack;
    private Canvas canvas;
    private Stack<Canvas> canvasStack;
    private SVG.Box canvasViewPort;
    private boolean directRenderingMode;
    private SVG document;
    private float dpi;
    private Stack<Matrix> matrixStack;
    private Stack<SVG.SvgContainer> parentStack;
    private RendererState state;
    private Stack<RendererState> stateStack;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class MarkerPositionCalculator implements SVG.PathInterface {
        private boolean closepathReAdjustPending;
        private float startX;
        private float startY;
        private List<MarkerVector> markers = new ArrayList();
        private MarkerVector lastPos = null;
        private boolean startArc = false;
        private boolean normalCubic = true;
        private int subpathStartIndex = -1;

        public MarkerPositionCalculator(SVG.PathDefinition pathDefinition) {
            pathDefinition.enumeratePath(this);
            if (this.closepathReAdjustPending) {
                this.lastPos.add(this.markers.get(this.subpathStartIndex));
                this.markers.set(this.subpathStartIndex, this.lastPos);
                this.closepathReAdjustPending = false;
            }
            MarkerVector markerVector = this.lastPos;
            if (markerVector != null) {
                this.markers.add(markerVector);
            }
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void arcTo(float f16, float f17, float f18, boolean z16, boolean z17, float f19, float f26) {
            this.startArc = true;
            this.normalCubic = false;
            MarkerVector markerVector = this.lastPos;
            SVGAndroidRenderer.arcTo(markerVector.f31997x, markerVector.f31998y, f16, f17, f18, z16, z17, f19, f26, this);
            this.normalCubic = true;
            this.closepathReAdjustPending = false;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void close() {
            this.markers.add(this.lastPos);
            lineTo(this.startX, this.startY);
            this.closepathReAdjustPending = true;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void cubicTo(float f16, float f17, float f18, float f19, float f26, float f27) {
            if (this.normalCubic || this.startArc) {
                this.lastPos.add(f16, f17);
                this.markers.add(this.lastPos);
                this.startArc = false;
            }
            this.lastPos = new MarkerVector(f26, f27, f26 - f18, f27 - f19);
            this.closepathReAdjustPending = false;
        }

        public List<MarkerVector> getMarkers() {
            return this.markers;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void lineTo(float f16, float f17) {
            this.lastPos.add(f16, f17);
            this.markers.add(this.lastPos);
            SVGAndroidRenderer sVGAndroidRenderer = SVGAndroidRenderer.this;
            MarkerVector markerVector = this.lastPos;
            this.lastPos = new MarkerVector(f16, f17, f16 - markerVector.f31997x, f17 - markerVector.f31998y);
            this.closepathReAdjustPending = false;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void moveTo(float f16, float f17) {
            if (this.closepathReAdjustPending) {
                this.lastPos.add(this.markers.get(this.subpathStartIndex));
                this.markers.set(this.subpathStartIndex, this.lastPos);
                this.closepathReAdjustPending = false;
            }
            MarkerVector markerVector = this.lastPos;
            if (markerVector != null) {
                this.markers.add(markerVector);
            }
            this.startX = f16;
            this.startY = f17;
            this.lastPos = new MarkerVector(f16, f17, 0.0f, 0.0f);
            this.subpathStartIndex = this.markers.size();
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void quadTo(float f16, float f17, float f18, float f19) {
            this.lastPos.add(f16, f17);
            this.markers.add(this.lastPos);
            this.lastPos = new MarkerVector(f18, f19, f18 - f16, f19 - f17);
            this.closepathReAdjustPending = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class PathConverter implements SVG.PathInterface {
        float lastX;
        float lastY;
        Path path = new Path();

        public PathConverter(SVG.PathDefinition pathDefinition) {
            pathDefinition.enumeratePath(this);
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void arcTo(float f16, float f17, float f18, boolean z16, boolean z17, float f19, float f26) {
            SVGAndroidRenderer.arcTo(this.lastX, this.lastY, f16, f17, f18, z16, z17, f19, f26, this);
            this.lastX = f19;
            this.lastY = f26;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void close() {
            this.path.close();
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void cubicTo(float f16, float f17, float f18, float f19, float f26, float f27) {
            this.path.cubicTo(f16, f17, f18, f19, f26, f27);
            this.lastX = f26;
            this.lastY = f27;
        }

        public Path getPath() {
            return this.path;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void lineTo(float f16, float f17) {
            this.path.lineTo(f16, f17);
            this.lastX = f16;
            this.lastY = f17;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void moveTo(float f16, float f17) {
            this.path.moveTo(f16, f17);
            this.lastX = f16;
            this.lastY = f17;
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void quadTo(float f16, float f17, float f18, float f19) {
            this.path.quadTo(f16, f17, f18, f19);
            this.lastX = f18;
            this.lastY = f19;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class PathTextDrawer extends PlainTextDrawer {
        private Path path;

        public PathTextDrawer(Path path, float f16, float f17) {
            super(f16, f17);
            this.path = path;
        }

        @Override // com.caverock.androidsvg.SVGAndroidRenderer.PlainTextDrawer, com.caverock.androidsvg.SVGAndroidRenderer.TextProcessor
        public void processText(String str) {
            if (SVGAndroidRenderer.this.visible()) {
                if (SVGAndroidRenderer.this.state.hasFill) {
                    SVGAndroidRenderer.this.canvas.drawTextOnPath(str, this.path, this.f31999x, this.f32000y, SVGAndroidRenderer.this.state.fillPaint);
                }
                if (SVGAndroidRenderer.this.state.hasStroke) {
                    SVGAndroidRenderer.this.canvas.drawTextOnPath(str, this.path, this.f31999x, this.f32000y, SVGAndroidRenderer.this.state.strokePaint);
                }
            }
            this.f31999x += SVGAndroidRenderer.this.state.fillPaint.measureText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class PlainTextDrawer extends TextProcessor {

        /* renamed from: x, reason: collision with root package name */
        public float f31999x;

        /* renamed from: y, reason: collision with root package name */
        public float f32000y;

        public PlainTextDrawer(float f16, float f17) {
            super(SVGAndroidRenderer.this, null);
            this.f31999x = f16;
            this.f32000y = f17;
        }

        @Override // com.caverock.androidsvg.SVGAndroidRenderer.TextProcessor
        public void processText(String str) {
            SVGAndroidRenderer.debug("TextSequence render", new Object[0]);
            if (SVGAndroidRenderer.this.visible()) {
                if (SVGAndroidRenderer.this.state.hasFill) {
                    SVGAndroidRenderer.this.canvas.drawText(str, this.f31999x, this.f32000y, SVGAndroidRenderer.this.state.fillPaint);
                }
                if (SVGAndroidRenderer.this.state.hasStroke) {
                    SVGAndroidRenderer.this.canvas.drawText(str, this.f31999x, this.f32000y, SVGAndroidRenderer.this.state.strokePaint);
                }
            }
            this.f31999x += SVGAndroidRenderer.this.state.fillPaint.measureText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class PlainTextToPath extends TextProcessor {
        public Path textAsPath;

        /* renamed from: x, reason: collision with root package name */
        public float f32001x;

        /* renamed from: y, reason: collision with root package name */
        public float f32002y;

        public PlainTextToPath(float f16, float f17, Path path) {
            super(SVGAndroidRenderer.this, null);
            this.f32001x = f16;
            this.f32002y = f17;
            this.textAsPath = path;
        }

        @Override // com.caverock.androidsvg.SVGAndroidRenderer.TextProcessor
        public boolean doTextContainer(SVG.TextContainer textContainer) {
            if (textContainer instanceof SVG.TextPath) {
                SVGAndroidRenderer.warn("Using <textPath> elements in a clip path is not supported.", new Object[0]);
                return false;
            }
            return true;
        }

        @Override // com.caverock.androidsvg.SVGAndroidRenderer.TextProcessor
        public void processText(String str) {
            if (SVGAndroidRenderer.this.visible()) {
                Path path = new Path();
                SVGAndroidRenderer.this.state.fillPaint.getTextPath(str, 0, str.length(), this.f32001x, this.f32002y, path);
                this.textAsPath.addPath(path);
            }
            this.f32001x += SVGAndroidRenderer.this.state.fillPaint.measureText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class RendererState implements Cloneable {
        public boolean directRendering;
        public Paint fillPaint;
        public boolean hasFill;
        public boolean hasStroke;
        public boolean spacePreserve;
        public Paint strokePaint;
        public SVG.Style style;
        public SVG.Box viewBox;
        public SVG.Box viewPort;

        public RendererState() {
            Paint paint = new Paint();
            this.fillPaint = paint;
            paint.setFlags(385);
            this.fillPaint.setStyle(Paint.Style.FILL);
            this.fillPaint.setTypeface(Typeface.DEFAULT);
            Paint paint2 = new Paint();
            this.strokePaint = paint2;
            paint2.setFlags(385);
            this.strokePaint.setStyle(Paint.Style.STROKE);
            this.strokePaint.setTypeface(Typeface.DEFAULT);
            this.style = SVG.Style.getDefaultStyle();
        }

        protected Object clone() {
            try {
                RendererState rendererState = (RendererState) super.clone();
                rendererState.style = (SVG.Style) this.style.clone();
                rendererState.fillPaint = new Paint(this.fillPaint);
                rendererState.strokePaint = new Paint(this.strokePaint);
                return rendererState;
            } catch (CloneNotSupportedException e16) {
                throw new InternalError(e16.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class TextBoundsCalculator extends TextProcessor {
        RectF bbox;

        /* renamed from: x, reason: collision with root package name */
        float f32003x;

        /* renamed from: y, reason: collision with root package name */
        float f32004y;

        public TextBoundsCalculator(float f16, float f17) {
            super(SVGAndroidRenderer.this, null);
            this.bbox = new RectF();
            this.f32003x = f16;
            this.f32004y = f17;
        }

        @Override // com.caverock.androidsvg.SVGAndroidRenderer.TextProcessor
        public boolean doTextContainer(SVG.TextContainer textContainer) {
            if (!(textContainer instanceof SVG.TextPath)) {
                return true;
            }
            SVG.TextPath textPath = (SVG.TextPath) textContainer;
            SVG.SvgObject resolveIRI = textContainer.document.resolveIRI(textPath.href);
            if (resolveIRI == null) {
                SVGAndroidRenderer.error("TextPath path reference '%s' not found", textPath.href);
                return false;
            }
            SVG.Path path = (SVG.Path) resolveIRI;
            Path path2 = new PathConverter(path.f31962d).getPath();
            Matrix matrix = path.transform;
            if (matrix != null) {
                path2.transform(matrix);
            }
            RectF rectF = new RectF();
            path2.computeBounds(rectF, true);
            this.bbox.union(rectF);
            return false;
        }

        @Override // com.caverock.androidsvg.SVGAndroidRenderer.TextProcessor
        public void processText(String str) {
            if (SVGAndroidRenderer.this.visible()) {
                Rect rect = new Rect();
                SVGAndroidRenderer.this.state.fillPaint.getTextBounds(str, 0, str.length(), rect);
                RectF rectF = new RectF(rect);
                rectF.offset(this.f32003x, this.f32004y);
                this.bbox.union(rectF);
            }
            this.f32003x += SVGAndroidRenderer.this.state.fillPaint.measureText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public abstract class TextProcessor {
        TextProcessor() {
        }

        public boolean doTextContainer(SVG.TextContainer textContainer) {
            return true;
        }

        public abstract void processText(String str);

        /* synthetic */ TextProcessor(SVGAndroidRenderer sVGAndroidRenderer, TextProcessor textProcessor) {
            this();
        }
    }

    static /* synthetic */ int[] $SWITCH_TABLE$com$caverock$androidsvg$PreserveAspectRatio$Alignment() {
        int[] iArr = $SWITCH_TABLE$com$caverock$androidsvg$PreserveAspectRatio$Alignment;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[PreserveAspectRatio.Alignment.valuesCustom().length];
        try {
            iArr2[PreserveAspectRatio.Alignment.None.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[PreserveAspectRatio.Alignment.XMaxYMax.ordinal()] = 10;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[PreserveAspectRatio.Alignment.XMaxYMid.ordinal()] = 7;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            iArr2[PreserveAspectRatio.Alignment.XMaxYMin.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            iArr2[PreserveAspectRatio.Alignment.XMidYMax.ordinal()] = 9;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            iArr2[PreserveAspectRatio.Alignment.XMidYMid.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            iArr2[PreserveAspectRatio.Alignment.XMidYMin.ordinal()] = 3;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            iArr2[PreserveAspectRatio.Alignment.XMinYMax.ordinal()] = 8;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            iArr2[PreserveAspectRatio.Alignment.XMinYMid.ordinal()] = 5;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            iArr2[PreserveAspectRatio.Alignment.XMinYMin.ordinal()] = 2;
        } catch (NoSuchFieldError unused10) {
        }
        $SWITCH_TABLE$com$caverock$androidsvg$PreserveAspectRatio$Alignment = iArr2;
        return iArr2;
    }

    static /* synthetic */ int[] $SWITCH_TABLE$com$caverock$androidsvg$SVG$Style$FillRule() {
        int[] iArr = $SWITCH_TABLE$com$caverock$androidsvg$SVG$Style$FillRule;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[SVG.Style.FillRule.valuesCustom().length];
        try {
            iArr2[SVG.Style.FillRule.EvenOdd.ordinal()] = 2;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[SVG.Style.FillRule.NonZero.ordinal()] = 1;
        } catch (NoSuchFieldError unused2) {
        }
        $SWITCH_TABLE$com$caverock$androidsvg$SVG$Style$FillRule = iArr2;
        return iArr2;
    }

    static /* synthetic */ int[] $SWITCH_TABLE$com$caverock$androidsvg$SVG$Style$LineCaps() {
        int[] iArr = $SWITCH_TABLE$com$caverock$androidsvg$SVG$Style$LineCaps;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[SVG.Style.LineCaps.valuesCustom().length];
        try {
            iArr2[SVG.Style.LineCaps.Butt.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[SVG.Style.LineCaps.Round.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[SVG.Style.LineCaps.Square.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        $SWITCH_TABLE$com$caverock$androidsvg$SVG$Style$LineCaps = iArr2;
        return iArr2;
    }

    static /* synthetic */ int[] $SWITCH_TABLE$com$caverock$androidsvg$SVG$Style$LineJoin() {
        int[] iArr = $SWITCH_TABLE$com$caverock$androidsvg$SVG$Style$LineJoin;
        if (iArr != null) {
            return iArr;
        }
        int[] iArr2 = new int[SVG.Style.LineJoin.valuesCustom().length];
        try {
            iArr2[SVG.Style.LineJoin.Bevel.ordinal()] = 3;
        } catch (NoSuchFieldError unused) {
        }
        try {
            iArr2[SVG.Style.LineJoin.Miter.ordinal()] = 1;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            iArr2[SVG.Style.LineJoin.Round.ordinal()] = 2;
        } catch (NoSuchFieldError unused3) {
        }
        $SWITCH_TABLE$com$caverock$androidsvg$SVG$Style$LineJoin = iArr2;
        return iArr2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SVGAndroidRenderer(Canvas canvas, SVG.Box box, float f16) {
        this.canvas = canvas;
        this.dpi = f16;
        this.canvasViewPort = box;
    }

    private void addObjectToClip(SVG.SvgObject svgObject, boolean z16, Path path, Matrix matrix) {
        if (display()) {
            clipStatePush();
            if (svgObject instanceof SVG.Use) {
                if (z16) {
                    addObjectToClip((SVG.Use) svgObject, path, matrix);
                } else {
                    error("<use> elements inside a <clipPath> cannot reference another <use>", new Object[0]);
                }
            } else if (svgObject instanceof SVG.Path) {
                addObjectToClip((SVG.Path) svgObject, path, matrix);
            } else if (svgObject instanceof SVG.Text) {
                addObjectToClip((SVG.Text) svgObject, path, matrix);
            } else if (svgObject instanceof SVG.GraphicsElement) {
                addObjectToClip((SVG.GraphicsElement) svgObject, path, matrix);
            } else {
                error("Invalid %s element found in clipPath definition", svgObject.getClass().getSimpleName());
            }
            clipStatePop();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void arcTo(float f16, float f17, float f18, float f19, float f26, boolean z16, boolean z17, float f27, float f28, SVG.PathInterface pathInterface) {
        int i3;
        double d16;
        double d17;
        if (f16 == f27 && f17 == f28) {
            return;
        }
        if (f18 != 0.0f && f19 != 0.0f) {
            float abs = Math.abs(f18);
            float abs2 = Math.abs(f19);
            double radians = (float) Math.toRadians(f26 % 360.0d);
            double cos = Math.cos(radians);
            double sin = Math.sin(radians);
            double d18 = (f16 - f27) / 2.0d;
            double d19 = (f17 - f28) / 2.0d;
            double d26 = (cos * d18) + (sin * d19);
            double d27 = ((-sin) * d18) + (d19 * cos);
            double d28 = abs * abs;
            double d29 = abs2 * abs2;
            double d36 = d26 * d26;
            double d37 = d27 * d27;
            double d38 = (d36 / d28) + (d37 / d29);
            double d39 = 1.0d;
            if (d38 > 1.0d) {
                abs *= (float) Math.sqrt(d38);
                abs2 *= (float) Math.sqrt(d38);
                d28 = abs * abs;
                d29 = abs2 * abs2;
            }
            if (z16 == z17) {
                i3 = -1;
            } else {
                i3 = 1;
            }
            double d46 = i3;
            double d47 = d28 * d29;
            double d48 = d28 * d37;
            double d49 = d29 * d36;
            double d56 = ((d47 - d48) - d49) / (d48 + d49);
            if (d56 < 0.0d) {
                d56 = 0.0d;
            }
            double sqrt = d46 * Math.sqrt(d56);
            double d57 = abs;
            double d58 = abs2;
            double d59 = ((d57 * d27) / d58) * sqrt;
            float f29 = abs;
            float f36 = abs2;
            double d65 = sqrt * (-((d58 * d26) / d57));
            double d66 = ((f16 + f27) / 2.0d) + ((cos * d59) - (sin * d65));
            double d67 = ((f17 + f28) / 2.0d) + (sin * d59) + (cos * d65);
            double d68 = (d26 - d59) / d57;
            double d69 = (d27 - d65) / d58;
            double d75 = ((-d26) - d59) / d57;
            double d76 = ((-d27) - d65) / d58;
            double d77 = (d68 * d68) + (d69 * d69);
            double sqrt2 = Math.sqrt(d77);
            if (d69 < 0.0d) {
                d16 = -1.0d;
            } else {
                d16 = 1.0d;
            }
            double degrees = Math.toDegrees(d16 * Math.acos(d68 / sqrt2));
            double sqrt3 = Math.sqrt(d77 * ((d75 * d75) + (d76 * d76)));
            double d78 = (d68 * d75) + (d69 * d76);
            if ((d68 * d76) - (d69 * d75) < 0.0d) {
                d39 = -1.0d;
            }
            double degrees2 = Math.toDegrees(d39 * Math.acos(d78 / sqrt3));
            if (!z17 && degrees2 > 0.0d) {
                d17 = 360.0d;
                degrees2 -= 360.0d;
            } else {
                d17 = 360.0d;
                if (z17 && degrees2 < 0.0d) {
                    degrees2 += 360.0d;
                }
            }
            float[] arcToBeziers = arcToBeziers(degrees % d17, degrees2 % d17);
            Matrix matrix = new Matrix();
            matrix.postScale(f29, f36);
            matrix.postRotate(f26);
            matrix.postTranslate((float) d66, (float) d67);
            matrix.mapPoints(arcToBeziers);
            arcToBeziers[arcToBeziers.length - 2] = f27;
            arcToBeziers[arcToBeziers.length - 1] = f28;
            for (int i16 = 0; i16 < arcToBeziers.length; i16 += 6) {
                pathInterface.cubicTo(arcToBeziers[i16], arcToBeziers[i16 + 1], arcToBeziers[i16 + 2], arcToBeziers[i16 + 3], arcToBeziers[i16 + 4], arcToBeziers[i16 + 5]);
            }
            return;
        }
        pathInterface.lineTo(f27, f28);
    }

    private static float[] arcToBeziers(double d16, double d17) {
        int ceil = (int) Math.ceil(Math.abs(d17) / 90.0d);
        double radians = Math.toRadians(d16);
        double radians2 = (float) (Math.toRadians(d17) / ceil);
        double d18 = radians2 / 2.0d;
        double sin = (Math.sin(d18) * 1.3333333333333333d) / (Math.cos(d18) + 1.0d);
        float[] fArr = new float[ceil * 6];
        int i3 = 0;
        int i16 = 0;
        while (i3 < ceil) {
            double d19 = (i3 * r3) + radians;
            double cos = Math.cos(d19);
            double sin2 = Math.sin(d19);
            int i17 = i16 + 1;
            int i18 = ceil;
            double d26 = radians;
            fArr[i16] = (float) (cos - (sin * sin2));
            int i19 = i17 + 1;
            fArr[i17] = (float) (sin2 + (cos * sin));
            double d27 = d19 + radians2;
            double cos2 = Math.cos(d27);
            double sin3 = Math.sin(d27);
            int i26 = i19 + 1;
            fArr[i19] = (float) ((sin * sin3) + cos2);
            int i27 = i26 + 1;
            fArr[i26] = (float) (sin3 - (sin * cos2));
            int i28 = i27 + 1;
            fArr[i27] = (float) cos2;
            fArr[i28] = (float) sin3;
            i3++;
            radians = d26;
            i16 = i28 + 1;
            ceil = i18;
        }
        return fArr;
    }

    private List<MarkerVector> calculateMarkerPositions(SVG.Line line) {
        SVG.Length length = line.f31956x1;
        float floatValueX = length != null ? length.floatValueX(this) : 0.0f;
        SVG.Length length2 = line.f31958y1;
        float floatValueY = length2 != null ? length2.floatValueY(this) : 0.0f;
        SVG.Length length3 = line.f31957x2;
        float floatValueX2 = length3 != null ? length3.floatValueX(this) : 0.0f;
        SVG.Length length4 = line.f31959y2;
        float floatValueY2 = length4 != null ? length4.floatValueY(this) : 0.0f;
        ArrayList arrayList = new ArrayList(2);
        float f16 = floatValueX2 - floatValueX;
        float f17 = floatValueY2 - floatValueY;
        arrayList.add(new MarkerVector(floatValueX, floatValueY, f16, f17));
        arrayList.add(new MarkerVector(floatValueX2, floatValueY2, f16, f17));
        return arrayList;
    }

    private SVG.Box calculatePathBounds(Path path) {
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        return new SVG.Box(rectF.left, rectF.top, rectF.width(), rectF.height());
    }

    private float calculateTextWidth(SVG.TextContainer textContainer) {
        TextWidthCalculator textWidthCalculator = new TextWidthCalculator(this, null);
        enumerateTextSpans(textContainer, textWidthCalculator);
        return textWidthCalculator.f32005x;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x006e, code lost:
    
        if (r6 != 10) goto L31;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0090  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Matrix calculateViewBoxTransform(SVG.Box box, SVG.Box box2, PreserveAspectRatio preserveAspectRatio) {
        float min;
        float f16;
        float f17;
        Matrix matrix = new Matrix();
        if (preserveAspectRatio != null && preserveAspectRatio.getAlignment() != null) {
            float f18 = box.width / box2.width;
            float f19 = box.height / box2.height;
            float f26 = -box2.minX;
            float f27 = -box2.minY;
            if (preserveAspectRatio.equals(PreserveAspectRatio.STRETCH)) {
                matrix.preTranslate(box.minX, box.minY);
                matrix.preScale(f18, f19);
                matrix.preTranslate(f26, f27);
                return matrix;
            }
            if (preserveAspectRatio.getScale() == PreserveAspectRatio.Scale.Slice) {
                min = Math.max(f18, f19);
            } else {
                min = Math.min(f18, f19);
            }
            float f28 = box.width / min;
            float f29 = box.height / min;
            int i3 = $SWITCH_TABLE$com$caverock$androidsvg$PreserveAspectRatio$Alignment()[preserveAspectRatio.getAlignment().ordinal()];
            if (i3 != 3) {
                if (i3 != 4) {
                    if (i3 != 6) {
                        if (i3 != 7) {
                            if (i3 != 9) {
                            }
                        }
                    }
                }
                f16 = box2.width - f28;
                f26 -= f16;
                switch ($SWITCH_TABLE$com$caverock$androidsvg$PreserveAspectRatio$Alignment()[preserveAspectRatio.getAlignment().ordinal()]) {
                    case 5:
                    case 6:
                    case 7:
                        f17 = (box2.height - f29) / 2.0f;
                        break;
                    case 8:
                    case 9:
                    case 10:
                        f17 = box2.height - f29;
                        break;
                }
                f27 -= f17;
                matrix.preTranslate(box.minX, box.minY);
                matrix.preScale(min, min);
                matrix.preTranslate(f26, f27);
            }
            f16 = (box2.width - f28) / 2.0f;
            f26 -= f16;
            switch ($SWITCH_TABLE$com$caverock$androidsvg$PreserveAspectRatio$Alignment()[preserveAspectRatio.getAlignment().ordinal()]) {
            }
            f27 -= f17;
            matrix.preTranslate(box.minX, box.minY);
            matrix.preScale(min, min);
            matrix.preTranslate(f26, f27);
        }
        return matrix;
    }

    private void checkForClipPath(SVG.SvgElement svgElement) {
        checkForClipPath(svgElement, svgElement.boundingBox);
    }

    private void checkForGradiantsAndPatterns(SVG.SvgElement svgElement) {
        SVG.SvgPaint svgPaint = this.state.style.fill;
        if (svgPaint instanceof SVG.PaintReference) {
            decodePaintReference(true, svgElement.boundingBox, (SVG.PaintReference) svgPaint);
        }
        SVG.SvgPaint svgPaint2 = this.state.style.stroke;
        if (svgPaint2 instanceof SVG.PaintReference) {
            decodePaintReference(false, svgElement.boundingBox, (SVG.PaintReference) svgPaint2);
        }
    }

    private Bitmap checkForImageDataURL(String str) {
        int indexOf;
        if (!str.startsWith("data:") || str.length() < 14 || (indexOf = str.indexOf(44)) == -1 || indexOf < 12 || !";base64".equals(str.substring(indexOf - 7, indexOf))) {
            return null;
        }
        byte[] decode = Base64.decode(str.substring(indexOf + 1), 0);
        return BitmapFactory.decodeByteArray(decode, 0, decode.length);
    }

    private Typeface checkGenericFont(String str, Integer num, SVG.Style.FontStyle fontStyle) {
        boolean z16;
        int i3 = 1;
        if (fontStyle == SVG.Style.FontStyle.Italic) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (num.intValue() > 500) {
            if (z16) {
                i3 = 3;
            }
        } else if (z16) {
            i3 = 2;
        } else {
            i3 = 0;
        }
        if (str.equals(C.SERIF_NAME)) {
            return Typeface.create(Typeface.SERIF, i3);
        }
        if (str.equals("sans-serif")) {
            return Typeface.create(Typeface.SANS_SERIF, i3);
        }
        if (str.equals("monospace")) {
            return Typeface.create(Typeface.MONOSPACE, i3);
        }
        if (str.equals("cursive")) {
            return Typeface.create(Typeface.SANS_SERIF, i3);
        }
        if (str.equals("fantasy")) {
            return Typeface.create(Typeface.SANS_SERIF, i3);
        }
        return null;
    }

    private void checkXMLSpaceAttribute(SVG.SvgObject svgObject) {
        Boolean bool;
        if ((svgObject instanceof SVG.SvgElementBase) && (bool = ((SVG.SvgElementBase) svgObject).spacePreserve) != null) {
            this.state.spacePreserve = bool.booleanValue();
        }
    }

    private int clamp255(float f16) {
        int i3 = (int) (f16 * 256.0f);
        if (i3 < 0) {
            return 0;
        }
        if (i3 > 255) {
            return 255;
        }
        return i3;
    }

    private void clipStatePop() {
        this.canvas.restore();
        this.state = this.stateStack.pop();
    }

    private void clipStatePush() {
        this.canvas.save(1);
        this.stateStack.push(this.state);
        this.state = (RendererState) this.state.clone();
    }

    private void decodePaintReference(boolean z16, SVG.Box box, SVG.PaintReference paintReference) {
        String str;
        SVG.SvgObject resolveIRI = this.document.resolveIRI(paintReference.href);
        if (resolveIRI == null) {
            Object[] objArr = new Object[2];
            if (z16) {
                str = "Fill";
            } else {
                str = "Stroke";
            }
            objArr[0] = str;
            objArr[1] = paintReference.href;
            error("%s reference '%s' not found", objArr);
            SVG.SvgPaint svgPaint = paintReference.fallback;
            if (svgPaint != null) {
                setPaintColour(this.state, z16, svgPaint);
                return;
            } else if (z16) {
                this.state.hasFill = false;
                return;
            } else {
                this.state.hasStroke = false;
                return;
            }
        }
        if (resolveIRI instanceof SVG.SvgLinearGradient) {
            makeLinearGradiant(z16, box, (SVG.SvgLinearGradient) resolveIRI);
        }
        if (resolveIRI instanceof SVG.SvgRadialGradient) {
            makeRadialGradiant(z16, box, (SVG.SvgRadialGradient) resolveIRI);
        }
        if (resolveIRI instanceof SVG.SolidColor) {
            setSolidColor(z16, (SVG.SolidColor) resolveIRI);
        }
    }

    private boolean display() {
        Boolean bool = this.state.style.display;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    private void doFilledPath(SVG.SvgElement svgElement, Path path) {
        SVG.SvgPaint svgPaint = this.state.style.fill;
        if (svgPaint instanceof SVG.PaintReference) {
            SVG.SvgObject resolveIRI = this.document.resolveIRI(((SVG.PaintReference) svgPaint).href);
            if (resolveIRI instanceof SVG.Pattern) {
                fillWithPattern(svgElement, path, (SVG.Pattern) resolveIRI);
                return;
            }
        }
        this.canvas.drawPath(path, this.state.fillPaint);
    }

    private void doStroke(Path path) {
        RendererState rendererState = this.state;
        if (rendererState.style.vectorEffect == SVG.Style.VectorEffect.NonScalingStroke) {
            Matrix matrix = this.canvas.getMatrix();
            Path path2 = new Path();
            path.transform(matrix, path2);
            this.canvas.setMatrix(new Matrix());
            Shader shader = this.state.strokePaint.getShader();
            Matrix matrix2 = new Matrix();
            if (shader != null) {
                shader.getLocalMatrix(matrix2);
                Matrix matrix3 = new Matrix(matrix2);
                matrix3.postConcat(matrix);
                shader.setLocalMatrix(matrix3);
            }
            this.canvas.drawPath(path2, this.state.strokePaint);
            this.canvas.setMatrix(matrix);
            if (shader != null) {
                shader.setLocalMatrix(matrix2);
                return;
            }
            return;
        }
        this.canvas.drawPath(path, rendererState.strokePaint);
    }

    private void duplicateCanvas() {
        try {
            Bitmap createBitmap = Bitmap.createBitmap(this.canvas.getWidth(), this.canvas.getHeight(), Bitmap.Config.ARGB_8888);
            this.bitmapStack.push(createBitmap);
            Canvas canvas = new Canvas(createBitmap);
            canvas.setMatrix(this.canvas.getMatrix());
            this.canvas = canvas;
        } catch (OutOfMemoryError e16) {
            error("Not enough memory to create temporary bitmaps for mask processing", new Object[0]);
            throw e16;
        }
    }

    private void enumerateTextSpans(SVG.TextContainer textContainer, TextProcessor textProcessor) {
        if (!display()) {
            return;
        }
        Iterator<SVG.SvgObject> it = textContainer.children.iterator();
        boolean z16 = true;
        while (it.hasNext()) {
            SVG.SvgObject next = it.next();
            if (next instanceof SVG.TextSequence) {
                textProcessor.processText(textXMLSpaceTransform(((SVG.TextSequence) next).text, z16, !it.hasNext()));
            } else {
                processTextChild(next, textProcessor);
            }
            z16 = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void error(String str, Object... objArr) {
        Log.e(TAG, String.format(str, objArr));
    }

    private void extractRawText(SVG.TextContainer textContainer, StringBuilder sb5) {
        Iterator<SVG.SvgObject> it = textContainer.children.iterator();
        boolean z16 = true;
        while (it.hasNext()) {
            SVG.SvgObject next = it.next();
            if (next instanceof SVG.TextContainer) {
                extractRawText((SVG.TextContainer) next, sb5);
            } else if (next instanceof SVG.TextSequence) {
                sb5.append(textXMLSpaceTransform(((SVG.TextSequence) next).text, z16, !it.hasNext()));
            }
            z16 = false;
        }
    }

    private void fillInChainedGradientFields(SVG.GradientElement gradientElement, String str) {
        SVG.SvgObject resolveIRI = gradientElement.document.resolveIRI(str);
        if (resolveIRI == null) {
            warn("Gradient reference '%s' not found", str);
            return;
        }
        if (!(resolveIRI instanceof SVG.GradientElement)) {
            error("Gradient href attributes must point to other gradient elements", new Object[0]);
            return;
        }
        if (resolveIRI == gradientElement) {
            error("Circular reference in gradient href attribute '%s'", str);
            return;
        }
        SVG.GradientElement gradientElement2 = (SVG.GradientElement) resolveIRI;
        if (gradientElement.gradientUnitsAreUser == null) {
            gradientElement.gradientUnitsAreUser = gradientElement2.gradientUnitsAreUser;
        }
        if (gradientElement.gradientTransform == null) {
            gradientElement.gradientTransform = gradientElement2.gradientTransform;
        }
        if (gradientElement.spreadMethod == null) {
            gradientElement.spreadMethod = gradientElement2.spreadMethod;
        }
        if (gradientElement.children.isEmpty()) {
            gradientElement.children = gradientElement2.children;
        }
        try {
            if (gradientElement instanceof SVG.SvgLinearGradient) {
                fillInChainedGradientFields((SVG.SvgLinearGradient) gradientElement, (SVG.SvgLinearGradient) resolveIRI);
            } else {
                fillInChainedGradientFields((SVG.SvgRadialGradient) gradientElement, (SVG.SvgRadialGradient) resolveIRI);
            }
        } catch (ClassCastException unused) {
        }
        String str2 = gradientElement2.href;
        if (str2 != null) {
            fillInChainedGradientFields(gradientElement, str2);
        }
    }

    private void fillInChainedPatternFields(SVG.Pattern pattern, String str) {
        SVG.SvgObject resolveIRI = pattern.document.resolveIRI(str);
        if (resolveIRI == null) {
            warn("Pattern reference '%s' not found", str);
            return;
        }
        if (!(resolveIRI instanceof SVG.Pattern)) {
            error("Pattern href attributes must point to other pattern elements", new Object[0]);
            return;
        }
        if (resolveIRI == pattern) {
            error("Circular reference in pattern href attribute '%s'", str);
            return;
        }
        SVG.Pattern pattern2 = (SVG.Pattern) resolveIRI;
        if (pattern.patternUnitsAreUser == null) {
            pattern.patternUnitsAreUser = pattern2.patternUnitsAreUser;
        }
        if (pattern.patternContentUnitsAreUser == null) {
            pattern.patternContentUnitsAreUser = pattern2.patternContentUnitsAreUser;
        }
        if (pattern.patternTransform == null) {
            pattern.patternTransform = pattern2.patternTransform;
        }
        if (pattern.f31963x == null) {
            pattern.f31963x = pattern2.f31963x;
        }
        if (pattern.f31964y == null) {
            pattern.f31964y = pattern2.f31964y;
        }
        if (pattern.width == null) {
            pattern.width = pattern2.width;
        }
        if (pattern.height == null) {
            pattern.height = pattern2.height;
        }
        if (pattern.children.isEmpty()) {
            pattern.children = pattern2.children;
        }
        if (pattern.viewBox == null) {
            pattern.viewBox = pattern2.viewBox;
        }
        if (pattern.preserveAspectRatio == null) {
            pattern.preserveAspectRatio = pattern2.preserveAspectRatio;
        }
        String str2 = pattern2.href;
        if (str2 != null) {
            fillInChainedPatternFields(pattern, str2);
        }
    }

    private void fillWithPattern(SVG.SvgElement svgElement, Path path, SVG.Pattern pattern) {
        boolean z16;
        float f16;
        float f17;
        float f18;
        float f19;
        float f26;
        float f27;
        float f28;
        float f29;
        boolean z17;
        Boolean bool = pattern.patternUnitsAreUser;
        if (bool != null && bool.booleanValue()) {
            z16 = true;
        } else {
            z16 = false;
        }
        String str = pattern.href;
        if (str != null) {
            fillInChainedPatternFields(pattern, str);
        }
        if (z16) {
            SVG.Length length = pattern.f31963x;
            if (length != null) {
                f26 = length.floatValueX(this);
            } else {
                f26 = 0.0f;
            }
            SVG.Length length2 = pattern.f31964y;
            if (length2 != null) {
                f28 = length2.floatValueY(this);
            } else {
                f28 = 0.0f;
            }
            SVG.Length length3 = pattern.width;
            if (length3 != null) {
                f29 = length3.floatValueX(this);
            } else {
                f29 = 0.0f;
            }
            SVG.Length length4 = pattern.height;
            if (length4 != null) {
                f27 = length4.floatValueY(this);
            } else {
                f27 = 0.0f;
            }
        } else {
            SVG.Length length5 = pattern.f31963x;
            if (length5 != null) {
                f16 = length5.floatValue(this, 1.0f);
            } else {
                f16 = 0.0f;
            }
            SVG.Length length6 = pattern.f31964y;
            if (length6 != null) {
                f17 = length6.floatValue(this, 1.0f);
            } else {
                f17 = 0.0f;
            }
            SVG.Length length7 = pattern.width;
            if (length7 != null) {
                f18 = length7.floatValue(this, 1.0f);
            } else {
                f18 = 0.0f;
            }
            SVG.Length length8 = pattern.height;
            if (length8 != null) {
                f19 = length8.floatValue(this, 1.0f);
            } else {
                f19 = 0.0f;
            }
            SVG.Box box = svgElement.boundingBox;
            float f36 = box.minX;
            float f37 = box.width;
            f26 = (f16 * f37) + f36;
            float f38 = box.minY;
            float f39 = box.height;
            float f46 = f18 * f37;
            f27 = f19 * f39;
            f28 = (f17 * f39) + f38;
            f29 = f46;
        }
        if (f29 != 0.0f && f27 != 0.0f) {
            PreserveAspectRatio preserveAspectRatio = pattern.preserveAspectRatio;
            if (preserveAspectRatio == null) {
                preserveAspectRatio = PreserveAspectRatio.LETTERBOX;
            }
            statePush();
            this.canvas.clipPath(path);
            RendererState rendererState = new RendererState();
            updateStyle(rendererState, SVG.Style.getDefaultStyle());
            rendererState.style.overflow = Boolean.FALSE;
            this.state = findInheritFromAncestorState(pattern, rendererState);
            SVG.Box box2 = svgElement.boundingBox;
            Matrix matrix = pattern.patternTransform;
            if (matrix != null) {
                this.canvas.concat(matrix);
                Matrix matrix2 = new Matrix();
                if (pattern.patternTransform.invert(matrix2)) {
                    SVG.Box box3 = svgElement.boundingBox;
                    SVG.Box box4 = svgElement.boundingBox;
                    SVG.Box box5 = svgElement.boundingBox;
                    float[] fArr = {box3.minX, box3.minY, box3.maxX(), box4.minY, box4.maxX(), svgElement.boundingBox.maxY(), box5.minX, box5.maxY()};
                    matrix2.mapPoints(fArr);
                    float f47 = fArr[0];
                    float f48 = fArr[1];
                    RectF rectF = new RectF(f47, f48, f47, f48);
                    for (int i3 = 2; i3 <= 6; i3 += 2) {
                        float f49 = fArr[i3];
                        if (f49 < rectF.left) {
                            rectF.left = f49;
                        }
                        if (f49 > rectF.right) {
                            rectF.right = f49;
                        }
                        float f56 = fArr[i3 + 1];
                        if (f56 < rectF.top) {
                            rectF.top = f56;
                        }
                        if (f56 > rectF.bottom) {
                            rectF.bottom = f56;
                        }
                    }
                    float f57 = rectF.left;
                    float f58 = rectF.top;
                    box2 = new SVG.Box(f57, f58, rectF.right - f57, rectF.bottom - f58);
                }
            }
            float floor = f26 + (((float) Math.floor((box2.minX - f26) / f29)) * f29);
            float maxX = box2.maxX();
            float maxY = box2.maxY();
            SVG.Box box6 = new SVG.Box(0.0f, 0.0f, f29, f27);
            for (float floor2 = f28 + (((float) Math.floor((box2.minY - f28) / f27)) * f27); floor2 < maxY; floor2 += f27) {
                for (float f59 = floor; f59 < maxX; f59 += f29) {
                    box6.minX = f59;
                    box6.minY = floor2;
                    statePush();
                    if (!this.state.style.overflow.booleanValue()) {
                        setClipRect(box6.minX, box6.minY, box6.width, box6.height);
                    }
                    SVG.Box box7 = pattern.viewBox;
                    if (box7 != null) {
                        this.canvas.concat(calculateViewBoxTransform(box6, box7, preserveAspectRatio));
                    } else {
                        Boolean bool2 = pattern.patternContentUnitsAreUser;
                        if (bool2 != null && !bool2.booleanValue()) {
                            z17 = false;
                        } else {
                            z17 = true;
                        }
                        this.canvas.translate(f59, floor2);
                        if (!z17) {
                            Canvas canvas = this.canvas;
                            SVG.Box box8 = svgElement.boundingBox;
                            canvas.scale(box8.width, box8.height);
                        }
                    }
                    boolean pushLayer = pushLayer();
                    Iterator<SVG.SvgObject> it = pattern.children.iterator();
                    while (it.hasNext()) {
                        render(it.next());
                    }
                    if (pushLayer) {
                        popLayer(pattern);
                    }
                    statePop();
                }
            }
            statePop();
        }
    }

    private RendererState findInheritFromAncestorState(SVG.SvgObject svgObject) {
        RendererState rendererState = new RendererState();
        updateStyle(rendererState, SVG.Style.getDefaultStyle());
        return findInheritFromAncestorState(svgObject, rendererState);
    }

    private SVG.Style.TextAnchor getAnchorPosition() {
        SVG.Style.TextAnchor textAnchor;
        SVG.Style style = this.state.style;
        if (style.direction != SVG.Style.TextDirection.LTR && (textAnchor = style.textAnchor) != SVG.Style.TextAnchor.Middle) {
            SVG.Style.TextAnchor textAnchor2 = SVG.Style.TextAnchor.Start;
            if (textAnchor == textAnchor2) {
                return SVG.Style.TextAnchor.End;
            }
            return textAnchor2;
        }
        return style.textAnchor;
    }

    private Path.FillType getClipRuleFromState() {
        if (this.state.style.clipRule == null) {
            return Path.FillType.WINDING;
        }
        if ($SWITCH_TABLE$com$caverock$androidsvg$SVG$Style$FillRule()[this.state.style.clipRule.ordinal()] != 2) {
            return Path.FillType.WINDING;
        }
        return Path.FillType.EVEN_ODD;
    }

    private Path.FillType getFillTypeFromState() {
        if (this.state.style.fillRule == null) {
            return Path.FillType.WINDING;
        }
        if ($SWITCH_TABLE$com$caverock$androidsvg$SVG$Style$FillRule()[this.state.style.fillRule.ordinal()] != 2) {
            return Path.FillType.WINDING;
        }
        return Path.FillType.EVEN_ODD;
    }

    private static void info(String str, Object... objArr) {
        Log.i(TAG, String.format(str, objArr));
    }

    private boolean isSpecified(SVG.Style style, long j3) {
        if ((style.specifiedFlags & j3) != 0) {
            return true;
        }
        return false;
    }

    private void makeLinearGradiant(boolean z16, SVG.Box box, SVG.SvgLinearGradient svgLinearGradient) {
        boolean z17;
        Paint paint;
        float f16;
        float f17;
        float f18;
        float f19;
        float f26;
        float f27;
        float f28;
        float f29;
        float f36;
        float f37;
        String str = svgLinearGradient.href;
        if (str != null) {
            fillInChainedGradientFields(svgLinearGradient, str);
        }
        Boolean bool = svgLinearGradient.gradientUnitsAreUser;
        int i3 = 0;
        if (bool != null && bool.booleanValue()) {
            z17 = true;
        } else {
            z17 = false;
        }
        RendererState rendererState = this.state;
        if (z16) {
            paint = rendererState.fillPaint;
        } else {
            paint = rendererState.strokePaint;
        }
        float f38 = 0.0f;
        if (z17) {
            SVG.Box currentViewPortInUserUnits = getCurrentViewPortInUserUnits();
            SVG.Length length = svgLinearGradient.f31972x1;
            if (length != null) {
                f29 = length.floatValueX(this);
            } else {
                f29 = 0.0f;
            }
            SVG.Length length2 = svgLinearGradient.f31974y1;
            if (length2 != null) {
                f36 = length2.floatValueY(this);
            } else {
                f36 = 0.0f;
            }
            SVG.Length length3 = svgLinearGradient.f31973x2;
            if (length3 != null) {
                f37 = length3.floatValueX(this);
            } else {
                f37 = currentViewPortInUserUnits.width;
            }
            SVG.Length length4 = svgLinearGradient.f31975y2;
            if (length4 != null) {
                f38 = length4.floatValueY(this);
            }
            f19 = f38;
            f28 = f37;
            f26 = f29;
            f27 = f36;
        } else {
            SVG.Length length5 = svgLinearGradient.f31972x1;
            if (length5 != null) {
                f16 = length5.floatValue(this, 1.0f);
            } else {
                f16 = 0.0f;
            }
            SVG.Length length6 = svgLinearGradient.f31974y1;
            if (length6 != null) {
                f17 = length6.floatValue(this, 1.0f);
            } else {
                f17 = 0.0f;
            }
            SVG.Length length7 = svgLinearGradient.f31973x2;
            if (length7 != null) {
                f18 = length7.floatValue(this, 1.0f);
            } else {
                f18 = 1.0f;
            }
            SVG.Length length8 = svgLinearGradient.f31975y2;
            if (length8 != null) {
                f38 = length8.floatValue(this, 1.0f);
            }
            f19 = f38;
            f26 = f16;
            f27 = f17;
            f28 = f18;
        }
        statePush();
        this.state = findInheritFromAncestorState(svgLinearGradient);
        Matrix matrix = new Matrix();
        if (!z17) {
            matrix.preTranslate(box.minX, box.minY);
            matrix.preScale(box.width, box.height);
        }
        Matrix matrix2 = svgLinearGradient.gradientTransform;
        if (matrix2 != null) {
            matrix.preConcat(matrix2);
        }
        int size = svgLinearGradient.children.size();
        if (size == 0) {
            statePop();
            if (z16) {
                this.state.hasFill = false;
                return;
            } else {
                this.state.hasStroke = false;
                return;
            }
        }
        int[] iArr = new int[size];
        float[] fArr = new float[size];
        Iterator<SVG.SvgObject> it = svgLinearGradient.children.iterator();
        float f39 = -1.0f;
        while (it.hasNext()) {
            SVG.Stop stop = (SVG.Stop) it.next();
            if (i3 != 0 && stop.offset.floatValue() < f39) {
                fArr[i3] = f39;
            } else {
                fArr[i3] = stop.offset.floatValue();
                f39 = stop.offset.floatValue();
            }
            statePush();
            updateStyleForElement(this.state, stop);
            SVG.Style style = this.state.style;
            SVG.Colour colour = (SVG.Colour) style.stopColor;
            if (colour == null) {
                colour = SVG.Colour.BLACK;
            }
            iArr[i3] = (clamp255(style.stopOpacity.floatValue()) << 24) | colour.colour;
            i3++;
            statePop();
        }
        if ((f26 == f28 && f27 == f19) || size == 1) {
            statePop();
            paint.setColor(iArr[size - 1]);
            return;
        }
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        SVG.GradientSpread gradientSpread = svgLinearGradient.spreadMethod;
        if (gradientSpread != null) {
            if (gradientSpread == SVG.GradientSpread.reflect) {
                tileMode = Shader.TileMode.MIRROR;
            } else if (gradientSpread == SVG.GradientSpread.repeat) {
                tileMode = Shader.TileMode.REPEAT;
            }
        }
        statePop();
        LinearGradient linearGradient = new LinearGradient(f26, f27, f28, f19, iArr, fArr, tileMode);
        linearGradient.setLocalMatrix(matrix);
        paint.setShader(linearGradient);
    }

    private Path makePathAndBoundingBox(SVG.Line line) {
        SVG.Length length = line.f31956x1;
        float floatValueX = length == null ? 0.0f : length.floatValueX(this);
        SVG.Length length2 = line.f31958y1;
        float floatValueY = length2 == null ? 0.0f : length2.floatValueY(this);
        SVG.Length length3 = line.f31957x2;
        float floatValueX2 = length3 == null ? 0.0f : length3.floatValueX(this);
        SVG.Length length4 = line.f31959y2;
        float floatValueY2 = length4 != null ? length4.floatValueY(this) : 0.0f;
        if (line.boundingBox == null) {
            line.boundingBox = new SVG.Box(Math.min(floatValueX, floatValueY), Math.min(floatValueY, floatValueY2), Math.abs(floatValueX2 - floatValueX), Math.abs(floatValueY2 - floatValueY));
        }
        Path path = new Path();
        path.moveTo(floatValueX, floatValueY);
        path.lineTo(floatValueX2, floatValueY2);
        return path;
    }

    private void makeRadialGradiant(boolean z16, SVG.Box box, SVG.SvgRadialGradient svgRadialGradient) {
        boolean z17;
        Paint paint;
        float f16;
        float f17;
        float f18;
        float f19;
        float f26;
        float f27;
        float floatValueX;
        float floatValueY;
        float floatValue;
        String str = svgRadialGradient.href;
        if (str != null) {
            fillInChainedGradientFields(svgRadialGradient, str);
        }
        Boolean bool = svgRadialGradient.gradientUnitsAreUser;
        int i3 = 0;
        if (bool != null && bool.booleanValue()) {
            z17 = true;
        } else {
            z17 = false;
        }
        RendererState rendererState = this.state;
        if (z16) {
            paint = rendererState.fillPaint;
        } else {
            paint = rendererState.strokePaint;
        }
        if (z17) {
            SVG.Length length = new SVG.Length(50.0f, SVG.Unit.percent);
            SVG.Length length2 = svgRadialGradient.f31976cx;
            if (length2 != null) {
                floatValueX = length2.floatValueX(this);
            } else {
                floatValueX = length.floatValueX(this);
            }
            SVG.Length length3 = svgRadialGradient.f31977cy;
            if (length3 != null) {
                floatValueY = length3.floatValueY(this);
            } else {
                floatValueY = length.floatValueY(this);
            }
            SVG.Length length4 = svgRadialGradient.f31980r;
            if (length4 != null) {
                floatValue = length4.floatValue(this);
            } else {
                floatValue = length.floatValue(this);
            }
            f26 = floatValue;
            f19 = floatValueX;
            f27 = floatValueY;
        } else {
            SVG.Length length5 = svgRadialGradient.f31976cx;
            if (length5 != null) {
                f16 = length5.floatValue(this, 1.0f);
            } else {
                f16 = 0.5f;
            }
            SVG.Length length6 = svgRadialGradient.f31977cy;
            if (length6 != null) {
                f17 = length6.floatValue(this, 1.0f);
            } else {
                f17 = 0.5f;
            }
            SVG.Length length7 = svgRadialGradient.f31980r;
            if (length7 != null) {
                f18 = length7.floatValue(this, 1.0f);
            } else {
                f18 = 0.5f;
            }
            f19 = f16;
            f26 = f18;
            f27 = f17;
        }
        statePush();
        this.state = findInheritFromAncestorState(svgRadialGradient);
        Matrix matrix = new Matrix();
        if (!z17) {
            matrix.preTranslate(box.minX, box.minY);
            matrix.preScale(box.width, box.height);
        }
        Matrix matrix2 = svgRadialGradient.gradientTransform;
        if (matrix2 != null) {
            matrix.preConcat(matrix2);
        }
        int size = svgRadialGradient.children.size();
        if (size == 0) {
            statePop();
            if (z16) {
                this.state.hasFill = false;
                return;
            } else {
                this.state.hasStroke = false;
                return;
            }
        }
        int[] iArr = new int[size];
        float[] fArr = new float[size];
        Iterator<SVG.SvgObject> it = svgRadialGradient.children.iterator();
        float f28 = -1.0f;
        while (it.hasNext()) {
            SVG.Stop stop = (SVG.Stop) it.next();
            if (i3 != 0 && stop.offset.floatValue() < f28) {
                fArr[i3] = f28;
            } else {
                fArr[i3] = stop.offset.floatValue();
                f28 = stop.offset.floatValue();
            }
            statePush();
            updateStyleForElement(this.state, stop);
            SVG.Style style = this.state.style;
            SVG.Colour colour = (SVG.Colour) style.stopColor;
            if (colour == null) {
                colour = SVG.Colour.BLACK;
            }
            iArr[i3] = (clamp255(style.stopOpacity.floatValue()) << 24) | colour.colour;
            i3++;
            statePop();
        }
        if (f26 != 0.0f && size != 1) {
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            SVG.GradientSpread gradientSpread = svgRadialGradient.spreadMethod;
            if (gradientSpread != null) {
                if (gradientSpread == SVG.GradientSpread.reflect) {
                    tileMode = Shader.TileMode.MIRROR;
                } else if (gradientSpread == SVG.GradientSpread.repeat) {
                    tileMode = Shader.TileMode.REPEAT;
                }
            }
            statePop();
            RadialGradient radialGradient = new RadialGradient(f19, f27, f26, iArr, fArr, tileMode);
            radialGradient.setLocalMatrix(matrix);
            paint.setShader(radialGradient);
            return;
        }
        statePop();
        paint.setColor(iArr[size - 1]);
    }

    private void parentPop() {
        this.parentStack.pop();
        this.matrixStack.pop();
    }

    private void parentPush(SVG.SvgContainer svgContainer) {
        this.parentStack.push(svgContainer);
        this.matrixStack.push(this.canvas.getMatrix());
    }

    private void popLayer(SVG.SvgElement svgElement) {
        RendererState rendererState = this.state;
        String str = rendererState.style.mask;
        if (str != null && rendererState.directRendering) {
            SVG.SvgObject resolveIRI = this.document.resolveIRI(str);
            duplicateCanvas();
            renderMask((SVG.Mask) resolveIRI, svgElement);
            Bitmap processMaskBitmaps = processMaskBitmaps();
            Canvas pop = this.canvasStack.pop();
            this.canvas = pop;
            pop.save();
            this.canvas.setMatrix(new Matrix());
            this.canvas.drawBitmap(processMaskBitmaps, 0.0f, 0.0f, this.state.fillPaint);
            processMaskBitmaps.recycle();
            this.canvas.restore();
        }
        statePop();
    }

    private Bitmap processMaskBitmaps() {
        Bitmap pop = this.bitmapStack.pop();
        Bitmap pop2 = this.bitmapStack.pop();
        int width = pop.getWidth();
        int height = pop.getHeight();
        int[] iArr = new int[width];
        int[] iArr2 = new int[width];
        int i3 = 0;
        while (i3 < height) {
            pop.getPixels(iArr, 0, width, 0, i3, width, 1);
            int i16 = i3;
            pop2.getPixels(iArr2, 0, width, 0, i3, width, 1);
            for (int i17 = 0; i17 < width; i17++) {
                int i18 = iArr[i17];
                int i19 = i18 & 255;
                int i26 = (i18 >> 8) & 255;
                int i27 = (i18 >> 16) & 255;
                int i28 = (i18 >> 24) & 255;
                if (i28 == 0) {
                    iArr2[i17] = 0;
                } else {
                    int i29 = ((((i27 * LUMINANCE_TO_ALPHA_RED) + (i26 * LUMINANCE_TO_ALPHA_GREEN)) + (i19 * LUMINANCE_TO_ALPHA_BLUE)) * i28) / 8355840;
                    int i36 = iArr2[i17];
                    iArr2[i17] = (i36 & 16777215) | (((((i36 >> 24) & 255) * i29) / 255) << 24);
                }
            }
            pop2.setPixels(iArr2, 0, width, 0, i16, width, 1);
            i3 = i16 + 1;
        }
        pop.recycle();
        return pop2;
    }

    private void processTextChild(SVG.SvgObject svgObject, TextProcessor textProcessor) {
        float f16;
        float f17;
        float f18;
        float f19;
        if (!textProcessor.doTextContainer((SVG.TextContainer) svgObject)) {
            return;
        }
        if (svgObject instanceof SVG.TextPath) {
            statePush();
            renderTextPath((SVG.TextPath) svgObject);
            statePop();
            return;
        }
        if (svgObject instanceof SVG.TSpan) {
            debug("TSpan render", new Object[0]);
            statePush();
            SVG.TSpan tSpan = (SVG.TSpan) svgObject;
            updateStyleForElement(this.state, tSpan);
            if (display()) {
                boolean z16 = textProcessor instanceof PlainTextDrawer;
                float f26 = 0.0f;
                if (z16) {
                    List<SVG.Length> list = tSpan.f31983x;
                    if (list != null && list.size() != 0) {
                        f19 = tSpan.f31983x.get(0).floatValueX(this);
                    } else {
                        f19 = ((PlainTextDrawer) textProcessor).f31999x;
                    }
                    List<SVG.Length> list2 = tSpan.f31984y;
                    if (list2 != null && list2.size() != 0) {
                        f17 = tSpan.f31984y.get(0).floatValueY(this);
                    } else {
                        f17 = ((PlainTextDrawer) textProcessor).f32000y;
                    }
                    List<SVG.Length> list3 = tSpan.f31981dx;
                    if (list3 != null && list3.size() != 0) {
                        f18 = tSpan.f31981dx.get(0).floatValueX(this);
                    } else {
                        f18 = 0.0f;
                    }
                    List<SVG.Length> list4 = tSpan.f31982dy;
                    if (list4 != null && list4.size() != 0) {
                        f26 = tSpan.f31982dy.get(0).floatValueY(this);
                    }
                    f16 = f26;
                    f26 = f19;
                } else {
                    f16 = 0.0f;
                    f17 = 0.0f;
                    f18 = 0.0f;
                }
                checkForGradiantsAndPatterns((SVG.SvgElement) tSpan.getTextRoot());
                if (z16) {
                    PlainTextDrawer plainTextDrawer = (PlainTextDrawer) textProcessor;
                    plainTextDrawer.f31999x = f26 + f18;
                    plainTextDrawer.f32000y = f17 + f16;
                }
                boolean pushLayer = pushLayer();
                enumerateTextSpans(tSpan, textProcessor);
                if (pushLayer) {
                    popLayer(tSpan);
                }
            }
            statePop();
            return;
        }
        if (svgObject instanceof SVG.TRef) {
            statePush();
            SVG.TRef tRef = (SVG.TRef) svgObject;
            updateStyleForElement(this.state, tRef);
            if (display()) {
                checkForGradiantsAndPatterns((SVG.SvgElement) tRef.getTextRoot());
                SVG.SvgObject resolveIRI = svgObject.document.resolveIRI(tRef.href);
                if (resolveIRI != null && (resolveIRI instanceof SVG.TextContainer)) {
                    StringBuilder sb5 = new StringBuilder();
                    extractRawText((SVG.TextContainer) resolveIRI, sb5);
                    if (sb5.length() > 0) {
                        textProcessor.processText(sb5.toString());
                    }
                } else {
                    error("Tref reference '%s' not found", tRef.href);
                }
            }
            statePop();
        }
    }

    private boolean pushLayer() {
        if (!requiresCompositing()) {
            return false;
        }
        this.canvas.saveLayerAlpha(null, clamp255(this.state.style.opacity.floatValue()), 4);
        this.stateStack.push(this.state);
        RendererState rendererState = (RendererState) this.state.clone();
        this.state = rendererState;
        String str = rendererState.style.mask;
        if (str != null && rendererState.directRendering) {
            SVG.SvgObject resolveIRI = this.document.resolveIRI(str);
            if (resolveIRI != null && (resolveIRI instanceof SVG.Mask)) {
                this.canvasStack.push(this.canvas);
                duplicateCanvas();
            } else {
                error("Mask reference '%s' not found", this.state.style.mask);
                this.state.style.mask = null;
            }
        }
        return true;
    }

    private void render(SVG.SvgObject svgObject) {
        if (svgObject instanceof SVG.NotDirectlyRendered) {
            return;
        }
        statePush();
        checkXMLSpaceAttribute(svgObject);
        if (svgObject instanceof SVG.Svg) {
            render((SVG.Svg) svgObject);
        } else if (svgObject instanceof SVG.Use) {
            render((SVG.Use) svgObject);
        } else if (svgObject instanceof SVG.Switch) {
            render((SVG.Switch) svgObject);
        } else if (svgObject instanceof SVG.Group) {
            render((SVG.Group) svgObject);
        } else if (svgObject instanceof SVG.Image) {
            render((SVG.Image) svgObject);
        } else if (svgObject instanceof SVG.Path) {
            render((SVG.Path) svgObject);
        } else if (svgObject instanceof SVG.Rect) {
            render((SVG.Rect) svgObject);
        } else if (svgObject instanceof SVG.Circle) {
            render((SVG.Circle) svgObject);
        } else if (svgObject instanceof SVG.Ellipse) {
            render((SVG.Ellipse) svgObject);
        } else if (svgObject instanceof SVG.Line) {
            render((SVG.Line) svgObject);
        } else if (svgObject instanceof SVG.Polygon) {
            render((SVG.Polygon) svgObject);
        } else if (svgObject instanceof SVG.PolyLine) {
            render((SVG.PolyLine) svgObject);
        } else if (svgObject instanceof SVG.Text) {
            render((SVG.Text) svgObject);
        }
        statePop();
    }

    private void renderChildren(SVG.SvgContainer svgContainer, boolean z16) {
        if (z16) {
            parentPush(svgContainer);
        }
        Iterator<SVG.SvgObject> it = svgContainer.getChildren().iterator();
        while (it.hasNext()) {
            render(it.next());
        }
        if (z16) {
            parentPop();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x011a, code lost:
    
        if (r11.state.style.overflow.booleanValue() != false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x011c, code lost:
    
        setClipRect(r0, r1, r2, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x011f, code lost:
    
        r3.reset();
        r3.preScale(r6, r5);
        r11.canvas.concat(r3);
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void renderMarker(SVG.Marker marker, MarkerVector markerVector) {
        float f16;
        float floatValue;
        SVG.Length length;
        float f17;
        SVG.Length length2;
        float f18;
        SVG.Length length3;
        float f19;
        SVG.Length length4;
        SVG.Box box;
        boolean pushLayer;
        float f26;
        float f27;
        float f28;
        float min;
        statePush();
        Float f29 = marker.orient;
        float f36 = 0.0f;
        if (f29 != null) {
            if (Float.isNaN(f29.floatValue())) {
                float f37 = markerVector.f31995dx;
                if (f37 != 0.0f || markerVector.f31996dy != 0.0f) {
                    f16 = (float) Math.toDegrees(Math.atan2(markerVector.f31996dy, f37));
                }
            } else {
                f16 = marker.orient.floatValue();
            }
            if (!marker.markerUnitsAreUser) {
                floatValue = 1.0f;
            } else {
                floatValue = this.state.style.strokeWidth.floatValue(this.dpi);
            }
            this.state = findInheritFromAncestorState(marker);
            Matrix matrix = new Matrix();
            matrix.preTranslate(markerVector.f31997x, markerVector.f31998y);
            matrix.preRotate(f16);
            matrix.preScale(floatValue, floatValue);
            length = marker.refX;
            if (length == null) {
                f17 = length.floatValueX(this);
            } else {
                f17 = 0.0f;
            }
            length2 = marker.refY;
            if (length2 == null) {
                f18 = length2.floatValueY(this);
            } else {
                f18 = 0.0f;
            }
            length3 = marker.markerWidth;
            float f38 = 3.0f;
            if (length3 == null) {
                f19 = length3.floatValueX(this);
            } else {
                f19 = 3.0f;
            }
            length4 = marker.markerHeight;
            if (length4 != null) {
                f38 = length4.floatValueY(this);
            }
            box = marker.viewBox;
            if (box == null) {
                float f39 = f19 / box.width;
                float f46 = f38 / box.height;
                PreserveAspectRatio preserveAspectRatio = marker.preserveAspectRatio;
                if (preserveAspectRatio == null) {
                    preserveAspectRatio = PreserveAspectRatio.LETTERBOX;
                }
                if (!preserveAspectRatio.equals(PreserveAspectRatio.STRETCH)) {
                    if (preserveAspectRatio.getScale() == PreserveAspectRatio.Scale.Slice) {
                        min = Math.max(f39, f46);
                    } else {
                        min = Math.min(f39, f46);
                    }
                    f39 = min;
                    f46 = f39;
                }
                matrix.preTranslate((-f17) * f39, (-f18) * f46);
                this.canvas.concat(matrix);
                SVG.Box box2 = marker.viewBox;
                float f47 = box2.width * f39;
                float f48 = box2.height * f46;
                int i3 = $SWITCH_TABLE$com$caverock$androidsvg$PreserveAspectRatio$Alignment()[preserveAspectRatio.getAlignment().ordinal()];
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 6) {
                            if (i3 != 7) {
                                if (i3 != 9) {
                                    if (i3 != 10) {
                                        f27 = 0.0f;
                                        switch ($SWITCH_TABLE$com$caverock$androidsvg$PreserveAspectRatio$Alignment()[preserveAspectRatio.getAlignment().ordinal()]) {
                                            case 5:
                                            case 6:
                                            case 7:
                                                f28 = (f38 - f48) / 2.0f;
                                                f36 = 0.0f - f28;
                                                break;
                                            case 8:
                                            case 9:
                                            case 10:
                                                f28 = f38 - f48;
                                                f36 = 0.0f - f28;
                                                break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    f26 = f19 - f47;
                    f27 = 0.0f - f26;
                    switch ($SWITCH_TABLE$com$caverock$androidsvg$PreserveAspectRatio$Alignment()[preserveAspectRatio.getAlignment().ordinal()]) {
                    }
                }
                f26 = (f19 - f47) / 2.0f;
                f27 = 0.0f - f26;
                switch ($SWITCH_TABLE$com$caverock$androidsvg$PreserveAspectRatio$Alignment()[preserveAspectRatio.getAlignment().ordinal()]) {
                }
            } else {
                matrix.preTranslate(-f17, -f18);
                this.canvas.concat(matrix);
                if (!this.state.style.overflow.booleanValue()) {
                    setClipRect(0.0f, 0.0f, f19, f38);
                }
            }
            pushLayer = pushLayer();
            renderChildren(marker, false);
            if (pushLayer) {
                popLayer(marker);
            }
            statePop();
        }
        f16 = 0.0f;
        if (!marker.markerUnitsAreUser) {
        }
        this.state = findInheritFromAncestorState(marker);
        Matrix matrix2 = new Matrix();
        matrix2.preTranslate(markerVector.f31997x, markerVector.f31998y);
        matrix2.preRotate(f16);
        matrix2.preScale(floatValue, floatValue);
        length = marker.refX;
        if (length == null) {
        }
        length2 = marker.refY;
        if (length2 == null) {
        }
        length3 = marker.markerWidth;
        float f382 = 3.0f;
        if (length3 == null) {
        }
        length4 = marker.markerHeight;
        if (length4 != null) {
        }
        box = marker.viewBox;
        if (box == null) {
        }
        pushLayer = pushLayer();
        renderChildren(marker, false);
        if (pushLayer) {
        }
        statePop();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0099 A[ADDED_TO_REGION, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void renderMarkers(SVG.GraphicsElement graphicsElement) {
        SVG.Marker marker;
        String str;
        SVG.Marker marker2;
        String str2;
        SVG.Marker marker3;
        List<MarkerVector> calculateMarkerPositions;
        int size;
        SVG.Style style = this.state.style;
        String str3 = style.markerStart;
        if (str3 == null && style.markerMid == null && style.markerEnd == null) {
            return;
        }
        if (str3 != null) {
            SVG.SvgObject resolveIRI = graphicsElement.document.resolveIRI(str3);
            if (resolveIRI != null) {
                marker = (SVG.Marker) resolveIRI;
                str = this.state.style.markerMid;
                if (str != null) {
                    SVG.SvgObject resolveIRI2 = graphicsElement.document.resolveIRI(str);
                    if (resolveIRI2 != null) {
                        marker2 = (SVG.Marker) resolveIRI2;
                        str2 = this.state.style.markerEnd;
                        if (str2 != null) {
                            SVG.SvgObject resolveIRI3 = graphicsElement.document.resolveIRI(str2);
                            if (resolveIRI3 != null) {
                                marker3 = (SVG.Marker) resolveIRI3;
                                if (!(graphicsElement instanceof SVG.Path)) {
                                    calculateMarkerPositions = new MarkerPositionCalculator(((SVG.Path) graphicsElement).f31962d).getMarkers();
                                } else if (graphicsElement instanceof SVG.Line) {
                                    calculateMarkerPositions = calculateMarkerPositions((SVG.Line) graphicsElement);
                                } else {
                                    calculateMarkerPositions = calculateMarkerPositions((SVG.PolyLine) graphicsElement);
                                }
                                if (calculateMarkerPositions != null || (size = calculateMarkerPositions.size()) == 0) {
                                    return;
                                }
                                SVG.Style style2 = this.state.style;
                                style2.markerEnd = null;
                                style2.markerMid = null;
                                style2.markerStart = null;
                                if (marker != null) {
                                    renderMarker(marker, calculateMarkerPositions.get(0));
                                }
                                if (marker2 != null) {
                                    for (int i3 = 1; i3 < size - 1; i3++) {
                                        renderMarker(marker2, calculateMarkerPositions.get(i3));
                                    }
                                }
                                if (marker3 == null) {
                                    renderMarker(marker3, calculateMarkerPositions.get(size - 1));
                                    return;
                                }
                                return;
                            }
                            error("Marker reference '%s' not found", this.state.style.markerEnd);
                        }
                        marker3 = null;
                        if (!(graphicsElement instanceof SVG.Path)) {
                        }
                        if (calculateMarkerPositions != null) {
                            return;
                        }
                        SVG.Style style22 = this.state.style;
                        style22.markerEnd = null;
                        style22.markerMid = null;
                        style22.markerStart = null;
                        if (marker != null) {
                        }
                        if (marker2 != null) {
                        }
                        if (marker3 == null) {
                        }
                    } else {
                        error("Marker reference '%s' not found", this.state.style.markerMid);
                    }
                }
                marker2 = null;
                str2 = this.state.style.markerEnd;
                if (str2 != null) {
                }
                marker3 = null;
                if (!(graphicsElement instanceof SVG.Path)) {
                }
                if (calculateMarkerPositions != null) {
                }
            } else {
                error("Marker reference '%s' not found", this.state.style.markerStart);
            }
        }
        marker = null;
        str = this.state.style.markerMid;
        if (str != null) {
        }
        marker2 = null;
        str2 = this.state.style.markerEnd;
        if (str2 != null) {
        }
        marker3 = null;
        if (!(graphicsElement instanceof SVG.Path)) {
        }
        if (calculateMarkerPositions != null) {
        }
    }

    private void renderMask(SVG.Mask mask, SVG.SvgElement svgElement) {
        boolean z16;
        float f16;
        float f17;
        float f18;
        debug("Mask render", new Object[0]);
        Boolean bool = mask.maskUnitsAreUser;
        boolean z17 = true;
        if (bool != null && bool.booleanValue()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            SVG.Length length = mask.width;
            if (length != null) {
                f17 = length.floatValueX(this);
            } else {
                f17 = svgElement.boundingBox.width;
            }
            SVG.Length length2 = mask.height;
            if (length2 != null) {
                f18 = length2.floatValueY(this);
            } else {
                f18 = svgElement.boundingBox.height;
            }
            SVG.Length length3 = mask.f31960x;
            if (length3 != null) {
                length3.floatValueX(this);
            } else {
                SVG.Box box = svgElement.boundingBox;
                float f19 = box.minX;
                float f26 = box.width;
            }
            SVG.Length length4 = mask.f31961y;
            if (length4 != null) {
                length4.floatValueY(this);
            } else {
                SVG.Box box2 = svgElement.boundingBox;
                float f27 = box2.minY;
                float f28 = box2.height;
            }
        } else {
            SVG.Length length5 = mask.f31960x;
            if (length5 != null) {
                length5.floatValue(this, 1.0f);
            }
            SVG.Length length6 = mask.f31961y;
            if (length6 != null) {
                length6.floatValue(this, 1.0f);
            }
            SVG.Length length7 = mask.width;
            float f29 = 1.2f;
            if (length7 != null) {
                f16 = length7.floatValue(this, 1.0f);
            } else {
                f16 = 1.2f;
            }
            SVG.Length length8 = mask.height;
            if (length8 != null) {
                f29 = length8.floatValue(this, 1.0f);
            }
            SVG.Box box3 = svgElement.boundingBox;
            float f36 = box3.minX;
            float f37 = box3.width;
            float f38 = box3.minY;
            f17 = f16 * f37;
            f18 = f29 * box3.height;
        }
        if (f17 != 0.0f && f18 != 0.0f) {
            statePush();
            RendererState findInheritFromAncestorState = findInheritFromAncestorState(mask);
            this.state = findInheritFromAncestorState;
            findInheritFromAncestorState.style.opacity = Float.valueOf(1.0f);
            Boolean bool2 = mask.maskContentUnitsAreUser;
            if (bool2 != null && !bool2.booleanValue()) {
                z17 = false;
            }
            if (!z17) {
                Canvas canvas = this.canvas;
                SVG.Box box4 = svgElement.boundingBox;
                canvas.translate(box4.minX, box4.minY);
                Canvas canvas2 = this.canvas;
                SVG.Box box5 = svgElement.boundingBox;
                canvas2.scale(box5.width, box5.height);
            }
            renderChildren(mask, false);
            statePop();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void renderSwitchChild(SVG.Switch r85) {
        Set<String> systemLanguage;
        String language = Locale.getDefault().getLanguage();
        SVGExternalFileResolver fileResolver = this.document.getFileResolver();
        for (SVG.SvgObject svgObject : r85.getChildren()) {
            if (svgObject instanceof SVG.SvgConditional) {
                SVG.SvgConditional svgConditional = (SVG.SvgConditional) svgObject;
                if (svgConditional.getRequiredExtensions() == null && ((systemLanguage = svgConditional.getSystemLanguage()) == null || (!systemLanguage.isEmpty() && systemLanguage.contains(language)))) {
                    Set<String> requiredFeatures = svgConditional.getRequiredFeatures();
                    if (requiredFeatures == null || (!requiredFeatures.isEmpty() && SVGParser.supportedFeatures.containsAll(requiredFeatures))) {
                        Set<String> requiredFormats = svgConditional.getRequiredFormats();
                        if (requiredFormats != null) {
                            if (!requiredFormats.isEmpty() && fileResolver != null) {
                                Iterator<String> it = requiredFormats.iterator();
                                while (it.hasNext()) {
                                    if (!fileResolver.isFormatSupported(it.next())) {
                                        break;
                                    }
                                }
                            }
                        }
                        Set<String> requiredFonts = svgConditional.getRequiredFonts();
                        if (requiredFonts != null) {
                            if (!requiredFonts.isEmpty() && fileResolver != null) {
                                Iterator<String> it5 = requiredFonts.iterator();
                                while (it5.hasNext()) {
                                    if (fileResolver.resolveFont(it5.next(), this.state.style.fontWeight.intValue(), String.valueOf(this.state.style.fontStyle)) == null) {
                                        break;
                                    }
                                }
                            }
                        }
                        render(svgObject);
                        return;
                    }
                }
            }
        }
    }

    private void renderTextPath(SVG.TextPath textPath) {
        float f16;
        debug("TextPath render", new Object[0]);
        updateStyleForElement(this.state, textPath);
        if (!display() || !visible()) {
            return;
        }
        SVG.SvgObject resolveIRI = textPath.document.resolveIRI(textPath.href);
        if (resolveIRI == null) {
            error("TextPath reference '%s' not found", textPath.href);
            return;
        }
        SVG.Path path = (SVG.Path) resolveIRI;
        Path path2 = new PathConverter(path.f31962d).getPath();
        Matrix matrix = path.transform;
        if (matrix != null) {
            path2.transform(matrix);
        }
        PathMeasure pathMeasure = new PathMeasure(path2, false);
        SVG.Length length = textPath.startOffset;
        if (length != null) {
            f16 = length.floatValue(this, pathMeasure.getLength());
        } else {
            f16 = 0.0f;
        }
        SVG.Style.TextAnchor anchorPosition = getAnchorPosition();
        if (anchorPosition != SVG.Style.TextAnchor.Start) {
            float calculateTextWidth = calculateTextWidth(textPath);
            if (anchorPosition == SVG.Style.TextAnchor.Middle) {
                calculateTextWidth /= 2.0f;
            }
            f16 -= calculateTextWidth;
        }
        checkForGradiantsAndPatterns((SVG.SvgElement) textPath.getTextRoot());
        boolean pushLayer = pushLayer();
        enumerateTextSpans(textPath, new PathTextDrawer(path2, f16, 0.0f));
        if (pushLayer) {
            popLayer(textPath);
        }
    }

    private boolean requiresCompositing() {
        RendererState rendererState = this.state;
        if (rendererState.style.mask != null && !rendererState.directRendering) {
            warn("Masks are not supported when using getPicture()", new Object[0]);
        }
        if (this.state.style.opacity.floatValue() >= 1.0f) {
            RendererState rendererState2 = this.state;
            if (rendererState2.style.mask == null || !rendererState2.directRendering) {
                return false;
            }
            return true;
        }
        return true;
    }

    private void resetState() {
        this.state = new RendererState();
        this.stateStack = new Stack<>();
        updateStyle(this.state, SVG.Style.getDefaultStyle());
        RendererState rendererState = this.state;
        rendererState.viewPort = this.canvasViewPort;
        rendererState.spacePreserve = false;
        rendererState.directRendering = this.directRenderingMode;
        this.stateStack.push((RendererState) rendererState.clone());
        this.canvasStack = new Stack<>();
        this.bitmapStack = new Stack<>();
        this.matrixStack = new Stack<>();
        this.parentStack = new Stack<>();
    }

    private void setClipRect(float f16, float f17, float f18, float f19) {
        float f26 = f18 + f16;
        float f27 = f19 + f17;
        SVG.CSSClipRect cSSClipRect = this.state.style.clip;
        if (cSSClipRect != null) {
            f16 += cSSClipRect.left.floatValueX(this);
            f17 += this.state.style.clip.top.floatValueY(this);
            f26 -= this.state.style.clip.right.floatValueX(this);
            f27 -= this.state.style.clip.bottom.floatValueY(this);
        }
        this.canvas.clipRect(f16, f17, f26, f27);
    }

    private void setPaintColour(RendererState rendererState, boolean z16, SVG.SvgPaint svgPaint) {
        Float f16;
        int i3;
        SVG.Style style = rendererState.style;
        if (z16) {
            f16 = style.fillOpacity;
        } else {
            f16 = style.strokeOpacity;
        }
        float floatValue = f16.floatValue();
        if (svgPaint instanceof SVG.Colour) {
            i3 = ((SVG.Colour) svgPaint).colour;
        } else if (svgPaint instanceof SVG.CurrentColor) {
            i3 = rendererState.style.color.colour;
        } else {
            return;
        }
        int clamp255 = i3 | (clamp255(floatValue) << 24);
        if (z16) {
            rendererState.fillPaint.setColor(clamp255);
        } else {
            rendererState.strokePaint.setColor(clamp255);
        }
    }

    private void setSolidColor(boolean z16, SVG.SolidColor solidColor) {
        boolean z17 = true;
        if (z16) {
            if (isSpecified(solidColor.baseStyle, 2147483648L)) {
                RendererState rendererState = this.state;
                SVG.Style style = rendererState.style;
                SVG.SvgPaint svgPaint = solidColor.baseStyle.solidColor;
                style.fill = svgPaint;
                if (svgPaint == null) {
                    z17 = false;
                }
                rendererState.hasFill = z17;
            }
            if (isSpecified(solidColor.baseStyle, 4294967296L)) {
                this.state.style.fillOpacity = solidColor.baseStyle.solidOpacity;
            }
            if (isSpecified(solidColor.baseStyle, 6442450944L)) {
                RendererState rendererState2 = this.state;
                setPaintColour(rendererState2, z16, rendererState2.style.fill);
                return;
            }
            return;
        }
        if (isSpecified(solidColor.baseStyle, 2147483648L)) {
            RendererState rendererState3 = this.state;
            SVG.Style style2 = rendererState3.style;
            SVG.SvgPaint svgPaint2 = solidColor.baseStyle.solidColor;
            style2.stroke = svgPaint2;
            if (svgPaint2 == null) {
                z17 = false;
            }
            rendererState3.hasStroke = z17;
        }
        if (isSpecified(solidColor.baseStyle, 4294967296L)) {
            this.state.style.strokeOpacity = solidColor.baseStyle.solidOpacity;
        }
        if (isSpecified(solidColor.baseStyle, 6442450944L)) {
            RendererState rendererState4 = this.state;
            setPaintColour(rendererState4, z16, rendererState4.style.stroke);
        }
    }

    private void statePop() {
        this.canvas.restore();
        this.state = this.stateStack.pop();
    }

    private void statePush() {
        this.canvas.save();
        this.stateStack.push(this.state);
        this.state = (RendererState) this.state.clone();
    }

    private String textXMLSpaceTransform(String str, boolean z16, boolean z17) {
        if (this.state.spacePreserve) {
            return str.replaceAll("[\\n\\t]", " ");
        }
        String replaceAll = str.replaceAll(RedTouch.NEWLINE_CHAR, "").replaceAll("\\t", " ");
        if (z16) {
            replaceAll = replaceAll.replaceAll("^\\s+", "");
        }
        if (z17) {
            replaceAll = replaceAll.replaceAll("\\s+$", "");
        }
        return replaceAll.replaceAll("\\s{2,}", " ");
    }

    private void updateParentBoundingBox(SVG.SvgElement svgElement) {
        if (svgElement.parent == null || svgElement.boundingBox == null) {
            return;
        }
        Matrix matrix = new Matrix();
        if (this.matrixStack.peek().invert(matrix)) {
            SVG.Box box = svgElement.boundingBox;
            SVG.Box box2 = svgElement.boundingBox;
            SVG.Box box3 = svgElement.boundingBox;
            float[] fArr = {box.minX, box.minY, box.maxX(), box2.minY, box2.maxX(), svgElement.boundingBox.maxY(), box3.minX, box3.maxY()};
            matrix.preConcat(this.canvas.getMatrix());
            matrix.mapPoints(fArr);
            float f16 = fArr[0];
            float f17 = fArr[1];
            RectF rectF = new RectF(f16, f17, f16, f17);
            for (int i3 = 2; i3 <= 6; i3 += 2) {
                float f18 = fArr[i3];
                if (f18 < rectF.left) {
                    rectF.left = f18;
                }
                if (f18 > rectF.right) {
                    rectF.right = f18;
                }
                float f19 = fArr[i3 + 1];
                if (f19 < rectF.top) {
                    rectF.top = f19;
                }
                if (f19 > rectF.bottom) {
                    rectF.bottom = f19;
                }
            }
            SVG.SvgElement svgElement2 = (SVG.SvgElement) this.parentStack.peek();
            SVG.Box box4 = svgElement2.boundingBox;
            if (box4 == null) {
                svgElement2.boundingBox = SVG.Box.fromLimits(rectF.left, rectF.top, rectF.right, rectF.bottom);
            } else {
                box4.union(SVG.Box.fromLimits(rectF.left, rectF.top, rectF.right, rectF.bottom));
            }
        }
    }

    private void updateStyle(RendererState rendererState, SVG.Style style) {
        boolean z16;
        boolean z17;
        boolean z18;
        SVG svg;
        int i3;
        boolean z19;
        boolean z26;
        if (isSpecified(style, 4096L)) {
            rendererState.style.color = style.color;
        }
        if (isSpecified(style, 2048L)) {
            rendererState.style.opacity = style.opacity;
        }
        boolean z27 = false;
        if (isSpecified(style, 1L)) {
            rendererState.style.fill = style.fill;
            if (style.fill != null) {
                z26 = true;
            } else {
                z26 = false;
            }
            rendererState.hasFill = z26;
        }
        if (isSpecified(style, 4L)) {
            rendererState.style.fillOpacity = style.fillOpacity;
        }
        if (isSpecified(style, 6149L)) {
            setPaintColour(rendererState, true, rendererState.style.fill);
        }
        if (isSpecified(style, 2L)) {
            rendererState.style.fillRule = style.fillRule;
        }
        if (isSpecified(style, 8L)) {
            rendererState.style.stroke = style.stroke;
            if (style.stroke != null) {
                z19 = true;
            } else {
                z19 = false;
            }
            rendererState.hasStroke = z19;
        }
        if (isSpecified(style, 16L)) {
            rendererState.style.strokeOpacity = style.strokeOpacity;
        }
        if (isSpecified(style, 6168L)) {
            setPaintColour(rendererState, false, rendererState.style.stroke);
        }
        if (isSpecified(style, 34359738368L)) {
            rendererState.style.vectorEffect = style.vectorEffect;
        }
        if (isSpecified(style, 32L)) {
            SVG.Style style2 = rendererState.style;
            SVG.Length length = style.strokeWidth;
            style2.strokeWidth = length;
            rendererState.strokePaint.setStrokeWidth(length.floatValue(this));
        }
        if (isSpecified(style, 64L)) {
            rendererState.style.strokeLineCap = style.strokeLineCap;
            int i16 = $SWITCH_TABLE$com$caverock$androidsvg$SVG$Style$LineCaps()[style.strokeLineCap.ordinal()];
            if (i16 != 1) {
                if (i16 != 2) {
                    if (i16 == 3) {
                        rendererState.strokePaint.setStrokeCap(Paint.Cap.SQUARE);
                    }
                } else {
                    rendererState.strokePaint.setStrokeCap(Paint.Cap.ROUND);
                }
            } else {
                rendererState.strokePaint.setStrokeCap(Paint.Cap.BUTT);
            }
        }
        if (isSpecified(style, 128L)) {
            rendererState.style.strokeLineJoin = style.strokeLineJoin;
            int i17 = $SWITCH_TABLE$com$caverock$androidsvg$SVG$Style$LineJoin()[style.strokeLineJoin.ordinal()];
            if (i17 != 1) {
                if (i17 != 2) {
                    if (i17 == 3) {
                        rendererState.strokePaint.setStrokeJoin(Paint.Join.BEVEL);
                    }
                } else {
                    rendererState.strokePaint.setStrokeJoin(Paint.Join.ROUND);
                }
            } else {
                rendererState.strokePaint.setStrokeJoin(Paint.Join.MITER);
            }
        }
        if (isSpecified(style, 256L)) {
            rendererState.style.strokeMiterLimit = style.strokeMiterLimit;
            rendererState.strokePaint.setStrokeMiter(style.strokeMiterLimit.floatValue());
        }
        if (isSpecified(style, 512L)) {
            rendererState.style.strokeDashArray = style.strokeDashArray;
        }
        if (isSpecified(style, 1024L)) {
            rendererState.style.strokeDashOffset = style.strokeDashOffset;
        }
        Typeface typeface = null;
        if (isSpecified(style, 1536L)) {
            SVG.Length[] lengthArr = rendererState.style.strokeDashArray;
            if (lengthArr == null) {
                rendererState.strokePaint.setPathEffect(null);
            } else {
                int length2 = lengthArr.length;
                if (length2 % 2 == 0) {
                    i3 = length2;
                } else {
                    i3 = length2 * 2;
                }
                float[] fArr = new float[i3];
                float f16 = 0.0f;
                for (int i18 = 0; i18 < i3; i18++) {
                    float floatValue = rendererState.style.strokeDashArray[i18 % length2].floatValue(this);
                    fArr[i18] = floatValue;
                    f16 += floatValue;
                }
                if (f16 == 0.0f) {
                    rendererState.strokePaint.setPathEffect(null);
                } else {
                    float floatValue2 = rendererState.style.strokeDashOffset.floatValue(this);
                    if (floatValue2 < 0.0f) {
                        floatValue2 = (floatValue2 % f16) + f16;
                    }
                    rendererState.strokePaint.setPathEffect(new DashPathEffect(fArr, floatValue2));
                }
            }
        }
        if (isSpecified(style, 16384L)) {
            float currentFontSize = getCurrentFontSize();
            rendererState.style.fontSize = style.fontSize;
            rendererState.fillPaint.setTextSize(style.fontSize.floatValue(this, currentFontSize));
            rendererState.strokePaint.setTextSize(style.fontSize.floatValue(this, currentFontSize));
        }
        if (isSpecified(style, 8192L)) {
            rendererState.style.fontFamily = style.fontFamily;
        }
        if (isSpecified(style, 32768L)) {
            if (style.fontWeight.intValue() == -1 && rendererState.style.fontWeight.intValue() > 100) {
                SVG.Style style3 = rendererState.style;
                style3.fontWeight = Integer.valueOf(style3.fontWeight.intValue() - 100);
            } else if (style.fontWeight.intValue() == 1 && rendererState.style.fontWeight.intValue() < 900) {
                SVG.Style style4 = rendererState.style;
                style4.fontWeight = Integer.valueOf(style4.fontWeight.intValue() + 100);
            } else {
                rendererState.style.fontWeight = style.fontWeight;
            }
        }
        if (isSpecified(style, 65536L)) {
            rendererState.style.fontStyle = style.fontStyle;
        }
        if (isSpecified(style, 106496L)) {
            if (rendererState.style.fontFamily != null && (svg = this.document) != null) {
                SVGExternalFileResolver fileResolver = svg.getFileResolver();
                for (String str : rendererState.style.fontFamily) {
                    SVG.Style style5 = rendererState.style;
                    Typeface checkGenericFont = checkGenericFont(str, style5.fontWeight, style5.fontStyle);
                    if (checkGenericFont == null && fileResolver != null) {
                        typeface = fileResolver.resolveFont(str, rendererState.style.fontWeight.intValue(), String.valueOf(rendererState.style.fontStyle));
                    } else {
                        typeface = checkGenericFont;
                    }
                    if (typeface != null) {
                        break;
                    }
                }
            }
            if (typeface == null) {
                SVG.Style style6 = rendererState.style;
                typeface = checkGenericFont("sans-serif", style6.fontWeight, style6.fontStyle);
            }
            rendererState.fillPaint.setTypeface(typeface);
            rendererState.strokePaint.setTypeface(typeface);
        }
        if (isSpecified(style, 131072L)) {
            rendererState.style.textDecoration = style.textDecoration;
            Paint paint = rendererState.fillPaint;
            SVG.Style.TextDecoration textDecoration = style.textDecoration;
            SVG.Style.TextDecoration textDecoration2 = SVG.Style.TextDecoration.LineThrough;
            if (textDecoration == textDecoration2) {
                z16 = true;
            } else {
                z16 = false;
            }
            paint.setStrikeThruText(z16);
            Paint paint2 = rendererState.fillPaint;
            SVG.Style.TextDecoration textDecoration3 = style.textDecoration;
            SVG.Style.TextDecoration textDecoration4 = SVG.Style.TextDecoration.Underline;
            if (textDecoration3 == textDecoration4) {
                z17 = true;
            } else {
                z17 = false;
            }
            paint2.setUnderlineText(z17);
            Paint paint3 = rendererState.strokePaint;
            if (style.textDecoration == textDecoration2) {
                z18 = true;
            } else {
                z18 = false;
            }
            paint3.setStrikeThruText(z18);
            Paint paint4 = rendererState.strokePaint;
            if (style.textDecoration == textDecoration4) {
                z27 = true;
            }
            paint4.setUnderlineText(z27);
        }
        if (isSpecified(style, TPChannelLayout.TP_CH_TOP_SIDE_LEFT)) {
            rendererState.style.direction = style.direction;
        }
        if (isSpecified(style, 262144L)) {
            rendererState.style.textAnchor = style.textAnchor;
        }
        if (isSpecified(style, 524288L)) {
            rendererState.style.overflow = style.overflow;
        }
        if (isSpecified(style, 2097152L)) {
            rendererState.style.markerStart = style.markerStart;
        }
        if (isSpecified(style, 4194304L)) {
            rendererState.style.markerMid = style.markerMid;
        }
        if (isSpecified(style, VasBusiness.CHAT_FONT_SWITCH)) {
            rendererState.style.markerEnd = style.markerEnd;
        }
        if (isSpecified(style, 16777216L)) {
            rendererState.style.display = style.display;
        }
        if (isSpecified(style, 33554432L)) {
            rendererState.style.visibility = style.visibility;
        }
        if (isSpecified(style, 1048576L)) {
            rendererState.style.clip = style.clip;
        }
        if (isSpecified(style, VasBusiness.QWALLET)) {
            rendererState.style.clipPath = style.clipPath;
        }
        if (isSpecified(style, 536870912L)) {
            rendererState.style.clipRule = style.clipRule;
        }
        if (isSpecified(style, 1073741824L)) {
            rendererState.style.mask = style.mask;
        }
        if (isSpecified(style, 67108864L)) {
            rendererState.style.stopColor = style.stopColor;
        }
        if (isSpecified(style, 134217728L)) {
            rendererState.style.stopOpacity = style.stopOpacity;
        }
        if (isSpecified(style, 8589934592L)) {
            rendererState.style.viewportFill = style.viewportFill;
        }
        if (isSpecified(style, 17179869184L)) {
            rendererState.style.viewportFillOpacity = style.viewportFillOpacity;
        }
    }

    private void updateStyleForElement(RendererState rendererState, SVG.SvgElementBase svgElementBase) {
        boolean z16;
        if (svgElementBase.parent == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        rendererState.style.resetNonInheritingProperties(z16);
        SVG.Style style = svgElementBase.baseStyle;
        if (style != null) {
            updateStyle(rendererState, style);
        }
        if (this.document.hasCSSRules()) {
            for (CSSParser.Rule rule : this.document.getCSSRules()) {
                if (CSSParser.ruleMatch(rule.selector, svgElementBase)) {
                    updateStyle(rendererState, rule.style);
                }
            }
        }
        SVG.Style style2 = svgElementBase.style;
        if (style2 != null) {
            updateStyle(rendererState, style2);
        }
    }

    private void viewportFill() {
        int i3;
        SVG.Style style = this.state.style;
        SVG.SvgPaint svgPaint = style.viewportFill;
        if (svgPaint instanceof SVG.Colour) {
            i3 = ((SVG.Colour) svgPaint).colour;
        } else if (svgPaint instanceof SVG.CurrentColor) {
            i3 = style.color.colour;
        } else {
            return;
        }
        Float f16 = style.viewportFillOpacity;
        if (f16 != null) {
            i3 |= clamp255(f16.floatValue()) << 24;
        }
        this.canvas.drawColor(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean visible() {
        Boolean bool = this.state.style.visibility;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void warn(String str, Object... objArr) {
        Log.w(TAG, String.format(str, objArr));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float getCurrentFontSize() {
        return this.state.fillPaint.getTextSize();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float getCurrentFontXHeight() {
        return this.state.fillPaint.getTextSize() / 2.0f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SVG.Box getCurrentViewPortInUserUnits() {
        RendererState rendererState = this.state;
        SVG.Box box = rendererState.viewBox;
        if (box != null) {
            return box;
        }
        return rendererState.viewPort;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float getDPI() {
        return this.dpi;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void renderDocument(SVG svg, SVG.Box box, PreserveAspectRatio preserveAspectRatio, boolean z16) {
        this.document = svg;
        this.directRenderingMode = z16;
        SVG.Svg rootElement = svg.getRootElement();
        if (rootElement == null) {
            warn("Nothing to render. Document is empty.", new Object[0]);
            return;
        }
        resetState();
        checkXMLSpaceAttribute(rootElement);
        SVG.Length length = rootElement.width;
        SVG.Length length2 = rootElement.height;
        if (box == null) {
            box = rootElement.viewBox;
        }
        SVG.Box box2 = box;
        if (preserveAspectRatio == null) {
            preserveAspectRatio = rootElement.preserveAspectRatio;
        }
        render(rootElement, length, length2, box2, preserveAspectRatio);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class TextWidthCalculator extends TextProcessor {

        /* renamed from: x, reason: collision with root package name */
        public float f32005x;

        TextWidthCalculator() {
            super(SVGAndroidRenderer.this, null);
            this.f32005x = 0.0f;
        }

        @Override // com.caverock.androidsvg.SVGAndroidRenderer.TextProcessor
        public void processText(String str) {
            this.f32005x += SVGAndroidRenderer.this.state.fillPaint.measureText(str);
        }

        /* synthetic */ TextWidthCalculator(SVGAndroidRenderer sVGAndroidRenderer, TextWidthCalculator textWidthCalculator) {
            this();
        }
    }

    private void checkForClipPath(SVG.SvgElement svgElement, SVG.Box box) {
        String str = this.state.style.clipPath;
        if (str == null) {
            return;
        }
        SVG.SvgObject resolveIRI = svgElement.document.resolveIRI(str);
        if (resolveIRI == null) {
            error("ClipPath reference '%s' not found", this.state.style.clipPath);
            return;
        }
        SVG.ClipPath clipPath = (SVG.ClipPath) resolveIRI;
        if (clipPath.children.isEmpty()) {
            this.canvas.clipRect(0, 0, 0, 0);
            return;
        }
        Boolean bool = clipPath.clipPathUnitsAreUser;
        boolean z16 = bool == null || bool.booleanValue();
        if ((svgElement instanceof SVG.Group) && !z16) {
            warn("<clipPath clipPathUnits=\"objectBoundingBox\"> is not supported when referenced from container elements (like %s)", svgElement.getClass().getSimpleName());
            return;
        }
        clipStatePush();
        if (!z16) {
            Matrix matrix = new Matrix();
            matrix.preTranslate(box.minX, box.minY);
            matrix.preScale(box.width, box.height);
            this.canvas.concat(matrix);
        }
        Matrix matrix2 = clipPath.transform;
        if (matrix2 != null) {
            this.canvas.concat(matrix2);
        }
        this.state = findInheritFromAncestorState(clipPath);
        checkForClipPath(clipPath);
        Path path = new Path();
        Iterator<SVG.SvgObject> it = clipPath.children.iterator();
        while (it.hasNext()) {
            addObjectToClip(it.next(), true, path, new Matrix());
        }
        this.canvas.clipPath(path);
        clipStatePop();
    }

    private RendererState findInheritFromAncestorState(SVG.SvgObject svgObject, RendererState rendererState) {
        ArrayList arrayList = new ArrayList();
        while (true) {
            if (svgObject instanceof SVG.SvgElementBase) {
                arrayList.add(0, (SVG.SvgElementBase) svgObject);
            }
            Object obj = svgObject.parent;
            if (obj == null) {
                break;
            }
            svgObject = (SVG.SvgObject) obj;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            updateStyleForElement(rendererState, (SVG.SvgElementBase) it.next());
        }
        SVG.Box box = this.document.getRootElement().viewBox;
        rendererState.viewBox = box;
        if (box == null) {
            rendererState.viewBox = this.canvasViewPort;
        }
        rendererState.viewPort = this.canvasViewPort;
        rendererState.directRendering = this.state.directRendering;
        return rendererState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class MarkerVector {

        /* renamed from: dx, reason: collision with root package name */
        public float f31995dx;

        /* renamed from: dy, reason: collision with root package name */
        public float f31996dy;

        /* renamed from: x, reason: collision with root package name */
        public float f31997x;

        /* renamed from: y, reason: collision with root package name */
        public float f31998y;

        public MarkerVector(float f16, float f17, float f18, float f19) {
            this.f31995dx = 0.0f;
            this.f31996dy = 0.0f;
            this.f31997x = f16;
            this.f31998y = f17;
            double sqrt = Math.sqrt((f18 * f18) + (f19 * f19));
            if (sqrt != 0.0d) {
                this.f31995dx = (float) (f18 / sqrt);
                this.f31996dy = (float) (f19 / sqrt);
            }
        }

        public void add(float f16, float f17) {
            float f18 = f16 - this.f31997x;
            float f19 = f17 - this.f31998y;
            double sqrt = Math.sqrt((f18 * f18) + (f19 * f19));
            if (sqrt != 0.0d) {
                this.f31995dx += (float) (f18 / sqrt);
                this.f31996dy += (float) (f19 / sqrt);
            }
        }

        public String toString() {
            return "(" + this.f31997x + "," + this.f31998y + " " + this.f31995dx + "," + this.f31996dy + ")";
        }

        public void add(MarkerVector markerVector) {
            this.f31995dx += markerVector.f31995dx;
            this.f31996dy += markerVector.f31996dy;
        }
    }

    private List<MarkerVector> calculateMarkerPositions(SVG.PolyLine polyLine) {
        int length = polyLine.points.length;
        int i3 = 2;
        if (length < 2) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        float[] fArr = polyLine.points;
        MarkerVector markerVector = new MarkerVector(fArr[0], fArr[1], 0.0f, 0.0f);
        float f16 = 0.0f;
        float f17 = 0.0f;
        while (i3 < length) {
            float[] fArr2 = polyLine.points;
            float f18 = fArr2[i3];
            float f19 = fArr2[i3 + 1];
            markerVector.add(f18, f19);
            arrayList.add(markerVector);
            i3 += 2;
            markerVector = new MarkerVector(f18, f19, f18 - markerVector.f31997x, f19 - markerVector.f31998y);
            f17 = f19;
            f16 = f18;
        }
        if (polyLine instanceof SVG.Polygon) {
            float[] fArr3 = polyLine.points;
            float f26 = fArr3[0];
            if (f16 != f26) {
                float f27 = fArr3[1];
                if (f17 != f27) {
                    markerVector.add(f26, f27);
                    arrayList.add(markerVector);
                    MarkerVector markerVector2 = new MarkerVector(f26, f27, f26 - markerVector.f31997x, f27 - markerVector.f31998y);
                    markerVector2.add((MarkerVector) arrayList.get(0));
                    arrayList.add(markerVector2);
                    arrayList.set(0, markerVector2);
                }
            }
        } else {
            arrayList.add(markerVector);
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Path makePathAndBoundingBox(SVG.Rect rect) {
        float floatValueX;
        float floatValueY;
        float min;
        float floatValueX2;
        float floatValueY2;
        float f16;
        float f17;
        Path path;
        Path path2;
        SVG.Length length = rect.f31965rx;
        if (length == null && rect.f31966ry == null) {
            floatValueX = 0.0f;
        } else if (length == null) {
            floatValueX = rect.f31966ry.floatValueY(this);
        } else if (rect.f31966ry == null) {
            floatValueX = length.floatValueX(this);
        } else {
            floatValueX = length.floatValueX(this);
            floatValueY = rect.f31966ry.floatValueY(this);
            min = Math.min(floatValueX, rect.width.floatValueX(this) / 2.0f);
            float min2 = Math.min(floatValueY, rect.height.floatValueY(this) / 2.0f);
            SVG.Length length2 = rect.f31967x;
            floatValueX2 = length2 == null ? length2.floatValueX(this) : 0.0f;
            SVG.Length length3 = rect.f31968y;
            floatValueY2 = length3 == null ? length3.floatValueY(this) : 0.0f;
            float floatValueX3 = rect.width.floatValueX(this);
            float floatValueY3 = rect.height.floatValueY(this);
            if (rect.boundingBox == null) {
                rect.boundingBox = new SVG.Box(floatValueX2, floatValueY2, floatValueX3, floatValueY3);
            }
            f16 = floatValueX2 + floatValueX3;
            f17 = floatValueY2 + floatValueY3;
            path = new Path();
            if (min == 0.0f && min2 != 0.0f) {
                float f18 = min * BEZIER_ARC_FACTOR;
                float f19 = BEZIER_ARC_FACTOR * min2;
                float f26 = floatValueY2 + min2;
                path.moveTo(floatValueX2, f26);
                float f27 = f26 - f19;
                float f28 = floatValueX2 + min;
                float f29 = f28 - f18;
                path.cubicTo(floatValueX2, f27, f29, floatValueY2, f28, floatValueY2);
                float f36 = f16 - min;
                path.lineTo(f36, floatValueY2);
                float f37 = f36 + f18;
                path.cubicTo(f37, floatValueY2, f16, f27, f16, f26);
                float f38 = f17 - min2;
                path.lineTo(f16, f38);
                float f39 = f38 + f19;
                path2 = path;
                path.cubicTo(f16, f39, f37, f17, f36, f17);
                path2.lineTo(f28, f17);
                path2.cubicTo(f29, f17, floatValueX2, f39, floatValueX2, f38);
                path2.lineTo(floatValueX2, f26);
            } else {
                path2 = path;
                path2.moveTo(floatValueX2, floatValueY2);
                path2.lineTo(f16, floatValueY2);
                path2.lineTo(f16, f17);
                path2.lineTo(floatValueX2, f17);
                path2.lineTo(floatValueX2, floatValueY2);
            }
            path2.close();
            return path2;
        }
        floatValueY = floatValueX;
        min = Math.min(floatValueX, rect.width.floatValueX(this) / 2.0f);
        float min22 = Math.min(floatValueY, rect.height.floatValueY(this) / 2.0f);
        SVG.Length length22 = rect.f31967x;
        if (length22 == null) {
        }
        SVG.Length length32 = rect.f31968y;
        if (length32 == null) {
        }
        float floatValueX32 = rect.width.floatValueX(this);
        float floatValueY32 = rect.height.floatValueY(this);
        if (rect.boundingBox == null) {
        }
        f16 = floatValueX2 + floatValueX32;
        f17 = floatValueY2 + floatValueY32;
        path = new Path();
        if (min == 0.0f) {
        }
        path2 = path;
        path2.moveTo(floatValueX2, floatValueY2);
        path2.lineTo(f16, floatValueY2);
        path2.lineTo(f16, f17);
        path2.lineTo(floatValueX2, f17);
        path2.lineTo(floatValueX2, floatValueY2);
        path2.close();
        return path2;
    }

    private void addObjectToClip(SVG.Path path, Path path2, Matrix matrix) {
        updateStyleForElement(this.state, path);
        if (display() && visible()) {
            Matrix matrix2 = path.transform;
            if (matrix2 != null) {
                matrix.preConcat(matrix2);
            }
            Path path3 = new PathConverter(path.f31962d).getPath();
            if (path.boundingBox == null) {
                path.boundingBox = calculatePathBounds(path3);
            }
            checkForClipPath(path);
            path2.setFillType(getClipRuleFromState());
            path2.addPath(path3, matrix);
        }
    }

    private void fillInChainedGradientFields(SVG.SvgLinearGradient svgLinearGradient, SVG.SvgLinearGradient svgLinearGradient2) {
        if (svgLinearGradient.f31972x1 == null) {
            svgLinearGradient.f31972x1 = svgLinearGradient2.f31972x1;
        }
        if (svgLinearGradient.f31974y1 == null) {
            svgLinearGradient.f31974y1 = svgLinearGradient2.f31974y1;
        }
        if (svgLinearGradient.f31973x2 == null) {
            svgLinearGradient.f31973x2 = svgLinearGradient2.f31973x2;
        }
        if (svgLinearGradient.f31975y2 == null) {
            svgLinearGradient.f31975y2 = svgLinearGradient2.f31975y2;
        }
    }

    private void addObjectToClip(SVG.GraphicsElement graphicsElement, Path path, Matrix matrix) {
        Path makePathAndBoundingBox;
        updateStyleForElement(this.state, graphicsElement);
        if (display() && visible()) {
            Matrix matrix2 = graphicsElement.transform;
            if (matrix2 != null) {
                matrix.preConcat(matrix2);
            }
            if (graphicsElement instanceof SVG.Rect) {
                makePathAndBoundingBox = makePathAndBoundingBox((SVG.Rect) graphicsElement);
            } else if (graphicsElement instanceof SVG.Circle) {
                makePathAndBoundingBox = makePathAndBoundingBox((SVG.Circle) graphicsElement);
            } else if (graphicsElement instanceof SVG.Ellipse) {
                makePathAndBoundingBox = makePathAndBoundingBox((SVG.Ellipse) graphicsElement);
            } else if (!(graphicsElement instanceof SVG.PolyLine)) {
                return;
            } else {
                makePathAndBoundingBox = makePathAndBoundingBox((SVG.PolyLine) graphicsElement);
            }
            checkForClipPath(graphicsElement);
            path.setFillType(makePathAndBoundingBox.getFillType());
            path.addPath(makePathAndBoundingBox, matrix);
        }
    }

    private void fillInChainedGradientFields(SVG.SvgRadialGradient svgRadialGradient, SVG.SvgRadialGradient svgRadialGradient2) {
        if (svgRadialGradient.f31976cx == null) {
            svgRadialGradient.f31976cx = svgRadialGradient2.f31976cx;
        }
        if (svgRadialGradient.f31977cy == null) {
            svgRadialGradient.f31977cy = svgRadialGradient2.f31977cy;
        }
        if (svgRadialGradient.f31980r == null) {
            svgRadialGradient.f31980r = svgRadialGradient2.f31980r;
        }
        if (svgRadialGradient.f31978fx == null) {
            svgRadialGradient.f31978fx = svgRadialGradient2.f31978fx;
        }
        if (svgRadialGradient.f31979fy == null) {
            svgRadialGradient.f31979fy = svgRadialGradient2.f31979fy;
        }
    }

    private void render(SVG.Svg svg) {
        render(svg, svg.width, svg.height);
    }

    private void render(SVG.Svg svg, SVG.Length length, SVG.Length length2) {
        render(svg, length, length2, svg.viewBox, svg.preserveAspectRatio);
    }

    private void render(SVG.Svg svg, SVG.Length length, SVG.Length length2, SVG.Box box, PreserveAspectRatio preserveAspectRatio) {
        float f16;
        debug("Svg render", new Object[0]);
        if (length == null || !length.isZero()) {
            if (length2 == null || !length2.isZero()) {
                if (preserveAspectRatio == null && (preserveAspectRatio = svg.preserveAspectRatio) == null) {
                    preserveAspectRatio = PreserveAspectRatio.LETTERBOX;
                }
                updateStyleForElement(this.state, svg);
                if (display()) {
                    if (svg.parent != null) {
                        SVG.Length length3 = svg.f31969x;
                        float floatValueX = length3 != null ? length3.floatValueX(this) : 0.0f;
                        SVG.Length length4 = svg.f31970y;
                        r1 = floatValueX;
                        f16 = length4 != null ? length4.floatValueY(this) : 0.0f;
                    } else {
                        f16 = 0.0f;
                    }
                    SVG.Box currentViewPortInUserUnits = getCurrentViewPortInUserUnits();
                    this.state.viewPort = new SVG.Box(r1, f16, length != null ? length.floatValueX(this) : currentViewPortInUserUnits.width, length2 != null ? length2.floatValueY(this) : currentViewPortInUserUnits.height);
                    if (!this.state.style.overflow.booleanValue()) {
                        SVG.Box box2 = this.state.viewPort;
                        setClipRect(box2.minX, box2.minY, box2.width, box2.height);
                    }
                    checkForClipPath(svg, this.state.viewPort);
                    if (box != null) {
                        this.canvas.concat(calculateViewBoxTransform(this.state.viewPort, box, preserveAspectRatio));
                        this.state.viewBox = svg.viewBox;
                    } else {
                        this.canvas.translate(r1, f16);
                    }
                    boolean pushLayer = pushLayer();
                    viewportFill();
                    renderChildren(svg, true);
                    if (pushLayer) {
                        popLayer(svg);
                    }
                    updateParentBoundingBox(svg);
                }
            }
        }
    }

    private Path makePathAndBoundingBox(SVG.Circle circle) {
        SVG.Length length = circle.f31947cx;
        float floatValueX = length != null ? length.floatValueX(this) : 0.0f;
        SVG.Length length2 = circle.f31948cy;
        float floatValueY = length2 != null ? length2.floatValueY(this) : 0.0f;
        float floatValue = circle.f31949r.floatValue(this);
        float f16 = floatValueX - floatValue;
        float f17 = floatValueY - floatValue;
        float f18 = floatValueX + floatValue;
        float f19 = floatValueY + floatValue;
        if (circle.boundingBox == null) {
            float f26 = 2.0f * floatValue;
            circle.boundingBox = new SVG.Box(f16, f17, f26, f26);
        }
        float f27 = BEZIER_ARC_FACTOR * floatValue;
        Path path = new Path();
        path.moveTo(floatValueX, f17);
        float f28 = floatValueX + f27;
        float f29 = floatValueY - f27;
        path.cubicTo(f28, f17, f18, f29, f18, floatValueY);
        float f36 = floatValueY + f27;
        path.cubicTo(f18, f36, f28, f19, floatValueX, f19);
        float f37 = floatValueX - f27;
        path.cubicTo(f37, f19, f16, f36, f16, floatValueY);
        path.cubicTo(f16, f29, f37, f17, floatValueX, f17);
        path.close();
        return path;
    }

    private void addObjectToClip(SVG.Use use, Path path, Matrix matrix) {
        updateStyleForElement(this.state, use);
        if (display() && visible()) {
            Matrix matrix2 = use.transform;
            if (matrix2 != null) {
                matrix.preConcat(matrix2);
            }
            SVG.SvgObject resolveIRI = use.document.resolveIRI(use.href);
            if (resolveIRI == null) {
                error("Use reference '%s' not found", use.href);
            } else {
                checkForClipPath(use);
                addObjectToClip(resolveIRI, false, path, matrix);
            }
        }
    }

    private void addObjectToClip(SVG.Text text, Path path, Matrix matrix) {
        updateStyleForElement(this.state, text);
        if (display()) {
            Matrix matrix2 = text.transform;
            if (matrix2 != null) {
                matrix.preConcat(matrix2);
            }
            List<SVG.Length> list = text.f31983x;
            float f16 = 0.0f;
            float floatValueX = (list == null || list.size() == 0) ? 0.0f : text.f31983x.get(0).floatValueX(this);
            List<SVG.Length> list2 = text.f31984y;
            float floatValueY = (list2 == null || list2.size() == 0) ? 0.0f : text.f31984y.get(0).floatValueY(this);
            List<SVG.Length> list3 = text.f31981dx;
            float floatValueX2 = (list3 == null || list3.size() == 0) ? 0.0f : text.f31981dx.get(0).floatValueX(this);
            List<SVG.Length> list4 = text.f31982dy;
            if (list4 != null && list4.size() != 0) {
                f16 = text.f31982dy.get(0).floatValueY(this);
            }
            if (this.state.style.textAnchor != SVG.Style.TextAnchor.Start) {
                float calculateTextWidth = calculateTextWidth(text);
                if (this.state.style.textAnchor == SVG.Style.TextAnchor.Middle) {
                    calculateTextWidth /= 2.0f;
                }
                floatValueX -= calculateTextWidth;
            }
            if (text.boundingBox == null) {
                TextBoundsCalculator textBoundsCalculator = new TextBoundsCalculator(floatValueX, floatValueY);
                enumerateTextSpans(text, textBoundsCalculator);
                RectF rectF = textBoundsCalculator.bbox;
                text.boundingBox = new SVG.Box(rectF.left, rectF.top, rectF.width(), textBoundsCalculator.bbox.height());
            }
            checkForClipPath(text);
            Path path2 = new Path();
            enumerateTextSpans(text, new PlainTextToPath(floatValueX + floatValueX2, floatValueY + f16, path2));
            path.setFillType(getClipRuleFromState());
            path.addPath(path2, matrix);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void debug(String str, Object... objArr) {
    }

    private Path makePathAndBoundingBox(SVG.Ellipse ellipse) {
        SVG.Length length = ellipse.f31950cx;
        float floatValueX = length != null ? length.floatValueX(this) : 0.0f;
        SVG.Length length2 = ellipse.f31951cy;
        float floatValueY = length2 != null ? length2.floatValueY(this) : 0.0f;
        float floatValueX2 = ellipse.f31952rx.floatValueX(this);
        float floatValueY2 = ellipse.f31953ry.floatValueY(this);
        float f16 = floatValueX - floatValueX2;
        float f17 = floatValueY - floatValueY2;
        float f18 = floatValueX + floatValueX2;
        float f19 = floatValueY + floatValueY2;
        if (ellipse.boundingBox == null) {
            ellipse.boundingBox = new SVG.Box(f16, f17, floatValueX2 * 2.0f, 2.0f * floatValueY2);
        }
        float f26 = floatValueX2 * BEZIER_ARC_FACTOR;
        float f27 = BEZIER_ARC_FACTOR * floatValueY2;
        Path path = new Path();
        path.moveTo(floatValueX, f17);
        float f28 = floatValueX + f26;
        float f29 = floatValueY - f27;
        path.cubicTo(f28, f17, f18, f29, f18, floatValueY);
        float f36 = f27 + floatValueY;
        path.cubicTo(f18, f36, f28, f19, floatValueX, f19);
        float f37 = floatValueX - f26;
        path.cubicTo(f37, f19, f16, f36, f16, floatValueY);
        path.cubicTo(f16, f29, f37, f17, floatValueX, f17);
        path.close();
        return path;
    }

    private void render(SVG.Group group) {
        debug("Group render", new Object[0]);
        updateStyleForElement(this.state, group);
        if (display()) {
            Matrix matrix = group.transform;
            if (matrix != null) {
                this.canvas.concat(matrix);
            }
            checkForClipPath(group);
            boolean pushLayer = pushLayer();
            renderChildren(group, true);
            if (pushLayer) {
                popLayer(group);
            }
            updateParentBoundingBox(group);
        }
    }

    private Path makePathAndBoundingBox(SVG.PolyLine polyLine) {
        Path path = new Path();
        float[] fArr = polyLine.points;
        path.moveTo(fArr[0], fArr[1]);
        int i3 = 2;
        while (true) {
            float[] fArr2 = polyLine.points;
            if (i3 >= fArr2.length) {
                break;
            }
            path.lineTo(fArr2[i3], fArr2[i3 + 1]);
            i3 += 2;
        }
        if (polyLine instanceof SVG.Polygon) {
            path.close();
        }
        if (polyLine.boundingBox == null) {
            polyLine.boundingBox = calculatePathBounds(path);
        }
        path.setFillType(getClipRuleFromState());
        return path;
    }

    private void render(SVG.Switch r36) {
        debug("Switch render", new Object[0]);
        updateStyleForElement(this.state, r36);
        if (display()) {
            Matrix matrix = r36.transform;
            if (matrix != null) {
                this.canvas.concat(matrix);
            }
            checkForClipPath(r36);
            boolean pushLayer = pushLayer();
            renderSwitchChild(r36);
            if (pushLayer) {
                popLayer(r36);
            }
            updateParentBoundingBox(r36);
        }
    }

    private void render(SVG.Use use) {
        debug("Use render", new Object[0]);
        SVG.Length length = use.width;
        if (length == null || !length.isZero()) {
            SVG.Length length2 = use.height;
            if (length2 == null || !length2.isZero()) {
                updateStyleForElement(this.state, use);
                if (display()) {
                    SVG.SvgObject resolveIRI = use.document.resolveIRI(use.href);
                    if (resolveIRI == null) {
                        error("Use reference '%s' not found", use.href);
                        return;
                    }
                    Matrix matrix = use.transform;
                    if (matrix != null) {
                        this.canvas.concat(matrix);
                    }
                    Matrix matrix2 = new Matrix();
                    SVG.Length length3 = use.f31993x;
                    float floatValueX = length3 != null ? length3.floatValueX(this) : 0.0f;
                    SVG.Length length4 = use.f31994y;
                    matrix2.preTranslate(floatValueX, length4 != null ? length4.floatValueY(this) : 0.0f);
                    this.canvas.concat(matrix2);
                    checkForClipPath(use);
                    boolean pushLayer = pushLayer();
                    parentPush(use);
                    if (resolveIRI instanceof SVG.Svg) {
                        statePush();
                        SVG.Svg svg = (SVG.Svg) resolveIRI;
                        SVG.Length length5 = use.width;
                        if (length5 == null) {
                            length5 = svg.width;
                        }
                        SVG.Length length6 = use.height;
                        if (length6 == null) {
                            length6 = svg.height;
                        }
                        render(svg, length5, length6);
                        statePop();
                    } else if (resolveIRI instanceof SVG.Symbol) {
                        SVG.Length length7 = use.width;
                        if (length7 == null) {
                            length7 = new SVG.Length(100.0f, SVG.Unit.percent);
                        }
                        SVG.Length length8 = use.height;
                        if (length8 == null) {
                            length8 = new SVG.Length(100.0f, SVG.Unit.percent);
                        }
                        statePush();
                        render((SVG.Symbol) resolveIRI, length7, length8);
                        statePop();
                    } else {
                        render(resolveIRI);
                    }
                    parentPop();
                    if (pushLayer) {
                        popLayer(use);
                    }
                    updateParentBoundingBox(use);
                }
            }
        }
    }

    private void render(SVG.Path path) {
        debug("Path render", new Object[0]);
        updateStyleForElement(this.state, path);
        if (display() && visible()) {
            RendererState rendererState = this.state;
            if (rendererState.hasStroke || rendererState.hasFill) {
                Matrix matrix = path.transform;
                if (matrix != null) {
                    this.canvas.concat(matrix);
                }
                Path path2 = new PathConverter(path.f31962d).getPath();
                if (path.boundingBox == null) {
                    path.boundingBox = calculatePathBounds(path2);
                }
                updateParentBoundingBox(path);
                checkForGradiantsAndPatterns(path);
                checkForClipPath(path);
                boolean pushLayer = pushLayer();
                if (this.state.hasFill) {
                    path2.setFillType(getFillTypeFromState());
                    doFilledPath(path, path2);
                }
                if (this.state.hasStroke) {
                    doStroke(path2);
                }
                renderMarkers(path);
                if (pushLayer) {
                    popLayer(path);
                }
            }
        }
    }

    private void render(SVG.Rect rect) {
        debug("Rect render", new Object[0]);
        SVG.Length length = rect.width;
        if (length == null || rect.height == null || length.isZero() || rect.height.isZero()) {
            return;
        }
        updateStyleForElement(this.state, rect);
        if (display() && visible()) {
            Matrix matrix = rect.transform;
            if (matrix != null) {
                this.canvas.concat(matrix);
            }
            Path makePathAndBoundingBox = makePathAndBoundingBox(rect);
            updateParentBoundingBox(rect);
            checkForGradiantsAndPatterns(rect);
            checkForClipPath(rect);
            boolean pushLayer = pushLayer();
            if (this.state.hasFill) {
                doFilledPath(rect, makePathAndBoundingBox);
            }
            if (this.state.hasStroke) {
                doStroke(makePathAndBoundingBox);
            }
            if (pushLayer) {
                popLayer(rect);
            }
        }
    }

    private void render(SVG.Circle circle) {
        debug("Circle render", new Object[0]);
        SVG.Length length = circle.f31949r;
        if (length == null || length.isZero()) {
            return;
        }
        updateStyleForElement(this.state, circle);
        if (display() && visible()) {
            Matrix matrix = circle.transform;
            if (matrix != null) {
                this.canvas.concat(matrix);
            }
            Path makePathAndBoundingBox = makePathAndBoundingBox(circle);
            updateParentBoundingBox(circle);
            checkForGradiantsAndPatterns(circle);
            checkForClipPath(circle);
            boolean pushLayer = pushLayer();
            if (this.state.hasFill) {
                doFilledPath(circle, makePathAndBoundingBox);
            }
            if (this.state.hasStroke) {
                doStroke(makePathAndBoundingBox);
            }
            if (pushLayer) {
                popLayer(circle);
            }
        }
    }

    private void render(SVG.Ellipse ellipse) {
        debug("Ellipse render", new Object[0]);
        SVG.Length length = ellipse.f31952rx;
        if (length == null || ellipse.f31953ry == null || length.isZero() || ellipse.f31953ry.isZero()) {
            return;
        }
        updateStyleForElement(this.state, ellipse);
        if (display() && visible()) {
            Matrix matrix = ellipse.transform;
            if (matrix != null) {
                this.canvas.concat(matrix);
            }
            Path makePathAndBoundingBox = makePathAndBoundingBox(ellipse);
            updateParentBoundingBox(ellipse);
            checkForGradiantsAndPatterns(ellipse);
            checkForClipPath(ellipse);
            boolean pushLayer = pushLayer();
            if (this.state.hasFill) {
                doFilledPath(ellipse, makePathAndBoundingBox);
            }
            if (this.state.hasStroke) {
                doStroke(makePathAndBoundingBox);
            }
            if (pushLayer) {
                popLayer(ellipse);
            }
        }
    }

    private void render(SVG.Line line) {
        debug("Line render", new Object[0]);
        updateStyleForElement(this.state, line);
        if (display() && visible() && this.state.hasStroke) {
            Matrix matrix = line.transform;
            if (matrix != null) {
                this.canvas.concat(matrix);
            }
            Path makePathAndBoundingBox = makePathAndBoundingBox(line);
            updateParentBoundingBox(line);
            checkForGradiantsAndPatterns(line);
            checkForClipPath(line);
            boolean pushLayer = pushLayer();
            doStroke(makePathAndBoundingBox);
            renderMarkers(line);
            if (pushLayer) {
                popLayer(line);
            }
        }
    }

    private void render(SVG.PolyLine polyLine) {
        debug("PolyLine render", new Object[0]);
        updateStyleForElement(this.state, polyLine);
        if (display() && visible()) {
            RendererState rendererState = this.state;
            if (rendererState.hasStroke || rendererState.hasFill) {
                Matrix matrix = polyLine.transform;
                if (matrix != null) {
                    this.canvas.concat(matrix);
                }
                if (polyLine.points.length < 2) {
                    return;
                }
                Path makePathAndBoundingBox = makePathAndBoundingBox(polyLine);
                updateParentBoundingBox(polyLine);
                checkForGradiantsAndPatterns(polyLine);
                checkForClipPath(polyLine);
                boolean pushLayer = pushLayer();
                if (this.state.hasFill) {
                    doFilledPath(polyLine, makePathAndBoundingBox);
                }
                if (this.state.hasStroke) {
                    doStroke(makePathAndBoundingBox);
                }
                renderMarkers(polyLine);
                if (pushLayer) {
                    popLayer(polyLine);
                }
            }
        }
    }

    private void render(SVG.Polygon polygon) {
        debug("Polygon render", new Object[0]);
        updateStyleForElement(this.state, polygon);
        if (display() && visible()) {
            RendererState rendererState = this.state;
            if (rendererState.hasStroke || rendererState.hasFill) {
                Matrix matrix = polygon.transform;
                if (matrix != null) {
                    this.canvas.concat(matrix);
                }
                if (polygon.points.length < 2) {
                    return;
                }
                Path makePathAndBoundingBox = makePathAndBoundingBox(polygon);
                updateParentBoundingBox(polygon);
                checkForGradiantsAndPatterns(polygon);
                checkForClipPath(polygon);
                boolean pushLayer = pushLayer();
                if (this.state.hasFill) {
                    doFilledPath(polygon, makePathAndBoundingBox);
                }
                if (this.state.hasStroke) {
                    doStroke(makePathAndBoundingBox);
                }
                renderMarkers(polygon);
                if (pushLayer) {
                    popLayer(polygon);
                }
            }
        }
    }

    private void render(SVG.Text text) {
        debug("Text render", new Object[0]);
        updateStyleForElement(this.state, text);
        if (display()) {
            Matrix matrix = text.transform;
            if (matrix != null) {
                this.canvas.concat(matrix);
            }
            List<SVG.Length> list = text.f31983x;
            float f16 = 0.0f;
            float floatValueX = (list == null || list.size() == 0) ? 0.0f : text.f31983x.get(0).floatValueX(this);
            List<SVG.Length> list2 = text.f31984y;
            float floatValueY = (list2 == null || list2.size() == 0) ? 0.0f : text.f31984y.get(0).floatValueY(this);
            List<SVG.Length> list3 = text.f31981dx;
            float floatValueX2 = (list3 == null || list3.size() == 0) ? 0.0f : text.f31981dx.get(0).floatValueX(this);
            List<SVG.Length> list4 = text.f31982dy;
            if (list4 != null && list4.size() != 0) {
                f16 = text.f31982dy.get(0).floatValueY(this);
            }
            SVG.Style.TextAnchor anchorPosition = getAnchorPosition();
            if (anchorPosition != SVG.Style.TextAnchor.Start) {
                float calculateTextWidth = calculateTextWidth(text);
                if (anchorPosition == SVG.Style.TextAnchor.Middle) {
                    calculateTextWidth /= 2.0f;
                }
                floatValueX -= calculateTextWidth;
            }
            if (text.boundingBox == null) {
                TextBoundsCalculator textBoundsCalculator = new TextBoundsCalculator(floatValueX, floatValueY);
                enumerateTextSpans(text, textBoundsCalculator);
                RectF rectF = textBoundsCalculator.bbox;
                text.boundingBox = new SVG.Box(rectF.left, rectF.top, rectF.width(), textBoundsCalculator.bbox.height());
            }
            updateParentBoundingBox(text);
            checkForGradiantsAndPatterns(text);
            checkForClipPath(text);
            boolean pushLayer = pushLayer();
            enumerateTextSpans(text, new PlainTextDrawer(floatValueX + floatValueX2, floatValueY + f16));
            if (pushLayer) {
                popLayer(text);
            }
        }
    }

    private void render(SVG.Symbol symbol, SVG.Length length, SVG.Length length2) {
        debug("Symbol render", new Object[0]);
        if (length == null || !length.isZero()) {
            if (length2 == null || !length2.isZero()) {
                PreserveAspectRatio preserveAspectRatio = symbol.preserveAspectRatio;
                if (preserveAspectRatio == null) {
                    preserveAspectRatio = PreserveAspectRatio.LETTERBOX;
                }
                updateStyleForElement(this.state, symbol);
                this.state.viewPort = new SVG.Box(0.0f, 0.0f, length != null ? length.floatValueX(this) : this.state.viewPort.width, length2 != null ? length2.floatValueX(this) : this.state.viewPort.height);
                if (!this.state.style.overflow.booleanValue()) {
                    SVG.Box box = this.state.viewPort;
                    setClipRect(box.minX, box.minY, box.width, box.height);
                }
                SVG.Box box2 = symbol.viewBox;
                if (box2 != null) {
                    this.canvas.concat(calculateViewBoxTransform(this.state.viewPort, box2, preserveAspectRatio));
                    this.state.viewBox = symbol.viewBox;
                }
                boolean pushLayer = pushLayer();
                renderChildren(symbol, true);
                if (pushLayer) {
                    popLayer(symbol);
                }
                updateParentBoundingBox(symbol);
            }
        }
    }

    private void render(SVG.Image image) {
        SVG.Length length;
        String str;
        debug("Image render", new Object[0]);
        SVG.Length length2 = image.width;
        if (length2 == null || length2.isZero() || (length = image.height) == null || length.isZero() || (str = image.href) == null) {
            return;
        }
        PreserveAspectRatio preserveAspectRatio = image.preserveAspectRatio;
        if (preserveAspectRatio == null) {
            preserveAspectRatio = PreserveAspectRatio.LETTERBOX;
        }
        Bitmap checkForImageDataURL = checkForImageDataURL(str);
        if (checkForImageDataURL == null) {
            SVGExternalFileResolver fileResolver = this.document.getFileResolver();
            if (fileResolver == null) {
                return;
            } else {
                checkForImageDataURL = fileResolver.resolveImage(image.href);
            }
        }
        if (checkForImageDataURL == null) {
            error("Could not locate image '%s'", image.href);
            return;
        }
        updateStyleForElement(this.state, image);
        if (display() && visible()) {
            Matrix matrix = image.transform;
            if (matrix != null) {
                this.canvas.concat(matrix);
            }
            SVG.Length length3 = image.f31954x;
            float floatValueX = length3 != null ? length3.floatValueX(this) : 0.0f;
            SVG.Length length4 = image.f31955y;
            this.state.viewPort = new SVG.Box(floatValueX, length4 != null ? length4.floatValueY(this) : 0.0f, image.width.floatValueX(this), image.height.floatValueX(this));
            if (!this.state.style.overflow.booleanValue()) {
                SVG.Box box = this.state.viewPort;
                setClipRect(box.minX, box.minY, box.width, box.height);
            }
            SVG.Box box2 = new SVG.Box(0.0f, 0.0f, checkForImageDataURL.getWidth(), checkForImageDataURL.getHeight());
            image.boundingBox = box2;
            this.canvas.concat(calculateViewBoxTransform(this.state.viewPort, box2, preserveAspectRatio));
            updateParentBoundingBox(image);
            checkForClipPath(image);
            boolean pushLayer = pushLayer();
            viewportFill();
            this.canvas.drawBitmap(checkForImageDataURL, 0.0f, 0.0f, this.state.fillPaint);
            if (pushLayer) {
                popLayer(image);
            }
        }
    }
}
