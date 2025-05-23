package com.caverock.androidsvg;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Picture;
import android.graphics.RectF;
import android.util.Log;
import com.caverock.androidsvg.CSSParser;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.xml.sax.SAXException;

/* compiled from: P */
/* loaded from: classes.dex */
public class SVG {
    private static final int DEFAULT_PICTURE_HEIGHT = 512;
    private static final int DEFAULT_PICTURE_WIDTH = 512;
    private static final List<SvgObject> EMPTY_CHILD_LIST = new ArrayList(0);
    protected static final long SPECIFIED_ALL = -1;
    protected static final long SPECIFIED_CLIP = 1048576;
    protected static final long SPECIFIED_CLIP_PATH = 268435456;
    protected static final long SPECIFIED_CLIP_RULE = 536870912;
    protected static final long SPECIFIED_COLOR = 4096;
    protected static final long SPECIFIED_DIRECTION = 68719476736L;
    protected static final long SPECIFIED_DISPLAY = 16777216;
    protected static final long SPECIFIED_FILL = 1;
    protected static final long SPECIFIED_FILL_OPACITY = 4;
    protected static final long SPECIFIED_FILL_RULE = 2;
    protected static final long SPECIFIED_FONT_FAMILY = 8192;
    protected static final long SPECIFIED_FONT_SIZE = 16384;
    protected static final long SPECIFIED_FONT_STYLE = 65536;
    protected static final long SPECIFIED_FONT_WEIGHT = 32768;
    protected static final long SPECIFIED_MARKER_END = 8388608;
    protected static final long SPECIFIED_MARKER_MID = 4194304;
    protected static final long SPECIFIED_MARKER_START = 2097152;
    protected static final long SPECIFIED_MASK = 1073741824;
    protected static final long SPECIFIED_NON_INHERITING = 68133849088L;
    protected static final long SPECIFIED_OPACITY = 2048;
    protected static final long SPECIFIED_OVERFLOW = 524288;
    protected static final long SPECIFIED_SOLID_COLOR = 2147483648L;
    protected static final long SPECIFIED_SOLID_OPACITY = 4294967296L;
    protected static final long SPECIFIED_STOP_COLOR = 67108864;
    protected static final long SPECIFIED_STOP_OPACITY = 134217728;
    protected static final long SPECIFIED_STROKE = 8;
    protected static final long SPECIFIED_STROKE_DASHARRAY = 512;
    protected static final long SPECIFIED_STROKE_DASHOFFSET = 1024;
    protected static final long SPECIFIED_STROKE_LINECAP = 64;
    protected static final long SPECIFIED_STROKE_LINEJOIN = 128;
    protected static final long SPECIFIED_STROKE_MITERLIMIT = 256;
    protected static final long SPECIFIED_STROKE_OPACITY = 16;
    protected static final long SPECIFIED_STROKE_WIDTH = 32;
    protected static final long SPECIFIED_TEXT_ANCHOR = 262144;
    protected static final long SPECIFIED_TEXT_DECORATION = 131072;
    protected static final long SPECIFIED_VECTOR_EFFECT = 34359738368L;
    protected static final long SPECIFIED_VIEWPORT_FILL = 8589934592L;
    protected static final long SPECIFIED_VIEWPORT_FILL_OPACITY = 17179869184L;
    protected static final long SPECIFIED_VISIBILITY = 33554432;
    private static final double SQRT2 = 1.414213562373095d;
    protected static final String SUPPORTED_SVG_VERSION = "1.2";
    private static final String TAG = "AndroidSVG";
    private static final String VERSION = "1.2.1";
    private Svg rootElement = null;
    private String title = "";
    private String desc = "";
    private SVGExternalFileResolver fileResolver = null;
    private float renderDPI = 96.0f;
    private CSSParser.Ruleset cssRules = new CSSParser.Ruleset();

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class Box implements Cloneable {
        public float height;
        public float minX;
        public float minY;
        public float width;

        public Box(float f16, float f17, float f18, float f19) {
            this.minX = f16;
            this.minY = f17;
            this.width = f18;
            this.height = f19;
        }

        public static Box fromLimits(float f16, float f17, float f18, float f19) {
            return new Box(f16, f17, f18 - f16, f19 - f17);
        }

        public float maxX() {
            return this.minX + this.width;
        }

        public float maxY() {
            return this.minY + this.height;
        }

        public RectF toRectF() {
            return new RectF(this.minX, this.minY, maxX(), maxY());
        }

        public String toString() {
            return "[" + this.minX + " " + this.minY + " " + this.width + " " + this.height + "]";
        }

        public void union(Box box) {
            float f16 = box.minX;
            if (f16 < this.minX) {
                this.minX = f16;
            }
            float f17 = box.minY;
            if (f17 < this.minY) {
                this.minY = f17;
            }
            if (box.maxX() > maxX()) {
                this.width = box.maxX() - this.minX;
            }
            if (box.maxY() > maxY()) {
                this.height = box.maxY() - this.minY;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class CSSClipRect {
        public Length bottom;
        public Length left;
        public Length right;
        public Length top;

        public CSSClipRect(Length length, Length length2, Length length3, Length length4) {
            this.top = length;
            this.right = length2;
            this.bottom = length3;
            this.left = length4;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class Circle extends GraphicsElement {

        /* renamed from: cx, reason: collision with root package name */
        public Length f31947cx;

        /* renamed from: cy, reason: collision with root package name */
        public Length f31948cy;

        /* renamed from: r, reason: collision with root package name */
        public Length f31949r;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class ClipPath extends Group implements NotDirectlyRendered {
        public Boolean clipPathUnitsAreUser;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class Colour extends SvgPaint {
        public static final Colour BLACK = new Colour(0);
        public int colour;

        public Colour(int i3) {
            this.colour = i3;
        }

        public String toString() {
            return String.format("#%06x", Integer.valueOf(this.colour));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class CurrentColor extends SvgPaint {
        private static CurrentColor instance = new CurrentColor();

        CurrentColor() {
        }

        public static CurrentColor getInstance() {
            return instance;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class Defs extends Group implements NotDirectlyRendered {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class Ellipse extends GraphicsElement {

        /* renamed from: cx, reason: collision with root package name */
        public Length f31950cx;

        /* renamed from: cy, reason: collision with root package name */
        public Length f31951cy;

        /* renamed from: rx, reason: collision with root package name */
        public Length f31952rx;

        /* renamed from: ry, reason: collision with root package name */
        public Length f31953ry;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class GradientElement extends SvgElementBase implements SvgContainer {
        public List<SvgObject> children = new ArrayList();
        public Matrix gradientTransform;
        public Boolean gradientUnitsAreUser;
        public String href;
        public GradientSpread spreadMethod;

        protected GradientElement() {
        }

        @Override // com.caverock.androidsvg.SVG.SvgContainer
        public void addChild(SvgObject svgObject) throws SAXException {
            if (svgObject instanceof Stop) {
                this.children.add(svgObject);
                return;
            }
            throw new SAXException("Gradient elements cannot contain " + svgObject + " elements.");
        }

        @Override // com.caverock.androidsvg.SVG.SvgContainer
        public List<SvgObject> getChildren() {
            return this.children;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public enum GradientSpread {
        pad,
        reflect,
        repeat;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static GradientSpread[] valuesCustom() {
            GradientSpread[] valuesCustom = values();
            int length = valuesCustom.length;
            GradientSpread[] gradientSpreadArr = new GradientSpread[length];
            System.arraycopy(valuesCustom, 0, gradientSpreadArr, 0, length);
            return gradientSpreadArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static abstract class GraphicsElement extends SvgConditionalElement implements HasTransform {
        public Matrix transform;

        protected GraphicsElement() {
        }

        @Override // com.caverock.androidsvg.SVG.HasTransform
        public void setTransform(Matrix matrix) {
            this.transform = matrix;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class Group extends SvgConditionalContainer implements HasTransform {
        public Matrix transform;

        @Override // com.caverock.androidsvg.SVG.HasTransform
        public void setTransform(Matrix matrix) {
            this.transform = matrix;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface HasTransform {
        void setTransform(Matrix matrix);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class Image extends SvgPreserveAspectRatioContainer implements HasTransform {
        public Length height;
        public String href;
        public Matrix transform;
        public Length width;

        /* renamed from: x, reason: collision with root package name */
        public Length f31954x;

        /* renamed from: y, reason: collision with root package name */
        public Length f31955y;

        @Override // com.caverock.androidsvg.SVG.HasTransform
        public void setTransform(Matrix matrix) {
            this.transform = matrix;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class Length implements Cloneable {
        private static /* synthetic */ int[] $SWITCH_TABLE$com$caverock$androidsvg$SVG$Unit;
        Unit unit;
        float value;

        static /* synthetic */ int[] $SWITCH_TABLE$com$caverock$androidsvg$SVG$Unit() {
            int[] iArr = $SWITCH_TABLE$com$caverock$androidsvg$SVG$Unit;
            if (iArr != null) {
                return iArr;
            }
            int[] iArr2 = new int[Unit.valuesCustom().length];
            try {
                iArr2[Unit.cm.ordinal()] = 5;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr2[Unit.em.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr2[Unit.ex.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[Unit.in.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[Unit.mm.ordinal()] = 6;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[Unit.pc.ordinal()] = 8;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[Unit.percent.ordinal()] = 9;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[Unit.pt.ordinal()] = 7;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[Unit.px.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            $SWITCH_TABLE$com$caverock$androidsvg$SVG$Unit = iArr2;
            return iArr2;
        }

        public Length(float f16, Unit unit) {
            this.value = 0.0f;
            Unit unit2 = Unit.px;
            this.value = f16;
            this.unit = unit;
        }

        public float floatValue() {
            return this.value;
        }

        public float floatValueX(SVGAndroidRenderer sVGAndroidRenderer) {
            switch ($SWITCH_TABLE$com$caverock$androidsvg$SVG$Unit()[this.unit.ordinal()]) {
                case 1:
                    return this.value;
                case 2:
                    return this.value * sVGAndroidRenderer.getCurrentFontSize();
                case 3:
                    return this.value * sVGAndroidRenderer.getCurrentFontXHeight();
                case 4:
                    return this.value * sVGAndroidRenderer.getDPI();
                case 5:
                    return (this.value * sVGAndroidRenderer.getDPI()) / 2.54f;
                case 6:
                    return (this.value * sVGAndroidRenderer.getDPI()) / 25.4f;
                case 7:
                    return (this.value * sVGAndroidRenderer.getDPI()) / 72.0f;
                case 8:
                    return (this.value * sVGAndroidRenderer.getDPI()) / 6.0f;
                case 9:
                    Box currentViewPortInUserUnits = sVGAndroidRenderer.getCurrentViewPortInUserUnits();
                    if (currentViewPortInUserUnits == null) {
                        return this.value;
                    }
                    return (this.value * currentViewPortInUserUnits.width) / 100.0f;
                default:
                    return this.value;
            }
        }

        public float floatValueY(SVGAndroidRenderer sVGAndroidRenderer) {
            if (this.unit == Unit.percent) {
                Box currentViewPortInUserUnits = sVGAndroidRenderer.getCurrentViewPortInUserUnits();
                if (currentViewPortInUserUnits == null) {
                    return this.value;
                }
                return (this.value * currentViewPortInUserUnits.height) / 100.0f;
            }
            return floatValueX(sVGAndroidRenderer);
        }

        public boolean isNegative() {
            if (this.value < 0.0f) {
                return true;
            }
            return false;
        }

        public boolean isZero() {
            if (this.value == 0.0f) {
                return true;
            }
            return false;
        }

        public String toString() {
            return String.valueOf(String.valueOf(this.value)) + this.unit;
        }

        public float floatValue(SVGAndroidRenderer sVGAndroidRenderer) {
            if (this.unit == Unit.percent) {
                Box currentViewPortInUserUnits = sVGAndroidRenderer.getCurrentViewPortInUserUnits();
                if (currentViewPortInUserUnits == null) {
                    return this.value;
                }
                float f16 = currentViewPortInUserUnits.width;
                if (f16 == currentViewPortInUserUnits.height) {
                    return (this.value * f16) / 100.0f;
                }
                return (this.value * ((float) (Math.sqrt((f16 * f16) + (r6 * r6)) / SVG.SQRT2))) / 100.0f;
            }
            return floatValueX(sVGAndroidRenderer);
        }

        public Length(float f16) {
            this.value = 0.0f;
            Unit unit = Unit.px;
            this.value = f16;
            this.unit = unit;
        }

        public float floatValue(SVGAndroidRenderer sVGAndroidRenderer, float f16) {
            if (this.unit == Unit.percent) {
                return (this.value * f16) / 100.0f;
            }
            return floatValueX(sVGAndroidRenderer);
        }

        public float floatValue(float f16) {
            int i3 = $SWITCH_TABLE$com$caverock$androidsvg$SVG$Unit()[this.unit.ordinal()];
            if (i3 != 1) {
                switch (i3) {
                    case 4:
                        return this.value * f16;
                    case 5:
                        return (this.value * f16) / 2.54f;
                    case 6:
                        return (this.value * f16) / 25.4f;
                    case 7:
                        return (this.value * f16) / 72.0f;
                    case 8:
                        return (this.value * f16) / 6.0f;
                    default:
                        return this.value;
                }
            }
            return this.value;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class Line extends GraphicsElement {

        /* renamed from: x1, reason: collision with root package name */
        public Length f31956x1;

        /* renamed from: x2, reason: collision with root package name */
        public Length f31957x2;

        /* renamed from: y1, reason: collision with root package name */
        public Length f31958y1;

        /* renamed from: y2, reason: collision with root package name */
        public Length f31959y2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class Marker extends SvgViewBoxContainer implements NotDirectlyRendered {
        public Length markerHeight;
        public boolean markerUnitsAreUser;
        public Length markerWidth;
        public Float orient;
        public Length refX;
        public Length refY;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class Mask extends SvgConditionalContainer implements NotDirectlyRendered {
        public Length height;
        public Boolean maskContentUnitsAreUser;
        public Boolean maskUnitsAreUser;
        public Length width;

        /* renamed from: x, reason: collision with root package name */
        public Length f31960x;

        /* renamed from: y, reason: collision with root package name */
        public Length f31961y;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface NotDirectlyRendered {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class PaintReference extends SvgPaint {
        public SvgPaint fallback;
        public String href;

        public PaintReference(String str, SvgPaint svgPaint) {
            this.href = str;
            this.fallback = svgPaint;
        }

        public String toString() {
            return String.valueOf(this.href) + " " + this.fallback;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class Path extends GraphicsElement {

        /* renamed from: d, reason: collision with root package name */
        public PathDefinition f31962d;
        public Float pathLength;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class PathDefinition implements PathInterface {
        private static final byte ARCTO = 4;
        private static final byte CLOSE = 8;
        private static final byte CUBICTO = 2;
        private static final byte LINETO = 1;
        private static final byte MOVETO = 0;
        private static final byte QUADTO = 3;
        private List<Byte> commands;
        private List<Float> coords;

        public PathDefinition() {
            this.commands = null;
            this.coords = null;
            this.commands = new ArrayList();
            this.coords = new ArrayList();
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void arcTo(float f16, float f17, float f18, boolean z16, boolean z17, float f19, float f26) {
            int i3;
            if (z16) {
                i3 = 2;
            } else {
                i3 = 0;
            }
            this.commands.add(Byte.valueOf((byte) (i3 | 4 | (z17 ? 1 : 0))));
            this.coords.add(Float.valueOf(f16));
            this.coords.add(Float.valueOf(f17));
            this.coords.add(Float.valueOf(f18));
            this.coords.add(Float.valueOf(f19));
            this.coords.add(Float.valueOf(f26));
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void close() {
            this.commands.add((byte) 8);
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void cubicTo(float f16, float f17, float f18, float f19, float f26, float f27) {
            this.commands.add((byte) 2);
            this.coords.add(Float.valueOf(f16));
            this.coords.add(Float.valueOf(f17));
            this.coords.add(Float.valueOf(f18));
            this.coords.add(Float.valueOf(f19));
            this.coords.add(Float.valueOf(f26));
            this.coords.add(Float.valueOf(f27));
        }

        public void enumeratePath(PathInterface pathInterface) {
            boolean z16;
            boolean z17;
            Iterator<Float> it = this.coords.iterator();
            Iterator<Byte> it5 = this.commands.iterator();
            while (it5.hasNext()) {
                byte byteValue = it5.next().byteValue();
                if (byteValue != 0) {
                    if (byteValue != 1) {
                        if (byteValue != 2) {
                            if (byteValue != 3) {
                                if (byteValue != 8) {
                                    if ((byteValue & 2) != 0) {
                                        z16 = true;
                                    } else {
                                        z16 = false;
                                    }
                                    if ((byteValue & 1) != 0) {
                                        z17 = true;
                                    } else {
                                        z17 = false;
                                    }
                                    pathInterface.arcTo(it.next().floatValue(), it.next().floatValue(), it.next().floatValue(), z16, z17, it.next().floatValue(), it.next().floatValue());
                                } else {
                                    pathInterface.close();
                                }
                            } else {
                                pathInterface.quadTo(it.next().floatValue(), it.next().floatValue(), it.next().floatValue(), it.next().floatValue());
                            }
                        } else {
                            pathInterface.cubicTo(it.next().floatValue(), it.next().floatValue(), it.next().floatValue(), it.next().floatValue(), it.next().floatValue(), it.next().floatValue());
                        }
                    } else {
                        pathInterface.lineTo(it.next().floatValue(), it.next().floatValue());
                    }
                } else {
                    pathInterface.moveTo(it.next().floatValue(), it.next().floatValue());
                }
            }
        }

        public boolean isEmpty() {
            return this.commands.isEmpty();
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void lineTo(float f16, float f17) {
            this.commands.add((byte) 1);
            this.coords.add(Float.valueOf(f16));
            this.coords.add(Float.valueOf(f17));
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void moveTo(float f16, float f17) {
            this.commands.add((byte) 0);
            this.coords.add(Float.valueOf(f16));
            this.coords.add(Float.valueOf(f17));
        }

        @Override // com.caverock.androidsvg.SVG.PathInterface
        public void quadTo(float f16, float f17, float f18, float f19) {
            this.commands.add((byte) 3);
            this.coords.add(Float.valueOf(f16));
            this.coords.add(Float.valueOf(f17));
            this.coords.add(Float.valueOf(f18));
            this.coords.add(Float.valueOf(f19));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface PathInterface {
        void arcTo(float f16, float f17, float f18, boolean z16, boolean z17, float f19, float f26);

        void close();

        void cubicTo(float f16, float f17, float f18, float f19, float f26, float f27);

        void lineTo(float f16, float f17);

        void moveTo(float f16, float f17);

        void quadTo(float f16, float f17, float f18, float f19);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class Pattern extends SvgViewBoxContainer implements NotDirectlyRendered {
        public Length height;
        public String href;
        public Boolean patternContentUnitsAreUser;
        public Matrix patternTransform;
        public Boolean patternUnitsAreUser;
        public Length width;

        /* renamed from: x, reason: collision with root package name */
        public Length f31963x;

        /* renamed from: y, reason: collision with root package name */
        public Length f31964y;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class PolyLine extends GraphicsElement {
        public float[] points;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class Polygon extends PolyLine {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class Rect extends GraphicsElement {
        public Length height;

        /* renamed from: rx, reason: collision with root package name */
        public Length f31965rx;

        /* renamed from: ry, reason: collision with root package name */
        public Length f31966ry;
        public Length width;

        /* renamed from: x, reason: collision with root package name */
        public Length f31967x;

        /* renamed from: y, reason: collision with root package name */
        public Length f31968y;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class Style implements Cloneable {
        public static final int FONT_WEIGHT_BOLD = 700;
        public static final int FONT_WEIGHT_BOLDER = 1;
        public static final int FONT_WEIGHT_LIGHTER = -1;
        public static final int FONT_WEIGHT_NORMAL = 400;
        public CSSClipRect clip;
        public String clipPath;
        public FillRule clipRule;
        public Colour color;
        public TextDirection direction;
        public Boolean display;
        public SvgPaint fill;
        public Float fillOpacity;
        public FillRule fillRule;
        public List<String> fontFamily;
        public Length fontSize;
        public FontStyle fontStyle;
        public Integer fontWeight;
        public String markerEnd;
        public String markerMid;
        public String markerStart;
        public String mask;
        public Float opacity;
        public Boolean overflow;
        public SvgPaint solidColor;
        public Float solidOpacity;
        public long specifiedFlags = 0;
        public SvgPaint stopColor;
        public Float stopOpacity;
        public SvgPaint stroke;
        public Length[] strokeDashArray;
        public Length strokeDashOffset;
        public LineCaps strokeLineCap;
        public LineJoin strokeLineJoin;
        public Float strokeMiterLimit;
        public Float strokeOpacity;
        public Length strokeWidth;
        public TextAnchor textAnchor;
        public TextDecoration textDecoration;
        public VectorEffect vectorEffect;
        public SvgPaint viewportFill;
        public Float viewportFillOpacity;
        public Boolean visibility;

        /* compiled from: P */
        /* loaded from: classes.dex */
        public enum FillRule {
            NonZero,
            EvenOdd;

            /* renamed from: values, reason: to resolve conflict with enum method */
            public static FillRule[] valuesCustom() {
                FillRule[] valuesCustom = values();
                int length = valuesCustom.length;
                FillRule[] fillRuleArr = new FillRule[length];
                System.arraycopy(valuesCustom, 0, fillRuleArr, 0, length);
                return fillRuleArr;
            }
        }

        /* compiled from: P */
        /* loaded from: classes.dex */
        public enum FontStyle {
            Normal,
            Italic,
            Oblique;

            /* renamed from: values, reason: to resolve conflict with enum method */
            public static FontStyle[] valuesCustom() {
                FontStyle[] valuesCustom = values();
                int length = valuesCustom.length;
                FontStyle[] fontStyleArr = new FontStyle[length];
                System.arraycopy(valuesCustom, 0, fontStyleArr, 0, length);
                return fontStyleArr;
            }
        }

        /* compiled from: P */
        /* loaded from: classes.dex */
        public enum LineCaps {
            Butt,
            Round,
            Square;

            /* renamed from: values, reason: to resolve conflict with enum method */
            public static LineCaps[] valuesCustom() {
                LineCaps[] valuesCustom = values();
                int length = valuesCustom.length;
                LineCaps[] lineCapsArr = new LineCaps[length];
                System.arraycopy(valuesCustom, 0, lineCapsArr, 0, length);
                return lineCapsArr;
            }
        }

        /* compiled from: P */
        /* loaded from: classes.dex */
        public enum LineJoin {
            Miter,
            Round,
            Bevel;

            /* renamed from: values, reason: to resolve conflict with enum method */
            public static LineJoin[] valuesCustom() {
                LineJoin[] valuesCustom = values();
                int length = valuesCustom.length;
                LineJoin[] lineJoinArr = new LineJoin[length];
                System.arraycopy(valuesCustom, 0, lineJoinArr, 0, length);
                return lineJoinArr;
            }
        }

        /* compiled from: P */
        /* loaded from: classes.dex */
        public enum TextAnchor {
            Start,
            Middle,
            End;

            /* renamed from: values, reason: to resolve conflict with enum method */
            public static TextAnchor[] valuesCustom() {
                TextAnchor[] valuesCustom = values();
                int length = valuesCustom.length;
                TextAnchor[] textAnchorArr = new TextAnchor[length];
                System.arraycopy(valuesCustom, 0, textAnchorArr, 0, length);
                return textAnchorArr;
            }
        }

        /* compiled from: P */
        /* loaded from: classes.dex */
        public enum TextDecoration {
            None,
            Underline,
            Overline,
            LineThrough,
            Blink;

            /* renamed from: values, reason: to resolve conflict with enum method */
            public static TextDecoration[] valuesCustom() {
                TextDecoration[] valuesCustom = values();
                int length = valuesCustom.length;
                TextDecoration[] textDecorationArr = new TextDecoration[length];
                System.arraycopy(valuesCustom, 0, textDecorationArr, 0, length);
                return textDecorationArr;
            }
        }

        /* compiled from: P */
        /* loaded from: classes.dex */
        public enum TextDirection {
            LTR,
            RTL;

            /* renamed from: values, reason: to resolve conflict with enum method */
            public static TextDirection[] valuesCustom() {
                TextDirection[] valuesCustom = values();
                int length = valuesCustom.length;
                TextDirection[] textDirectionArr = new TextDirection[length];
                System.arraycopy(valuesCustom, 0, textDirectionArr, 0, length);
                return textDirectionArr;
            }
        }

        /* compiled from: P */
        /* loaded from: classes.dex */
        public enum VectorEffect {
            None,
            NonScalingStroke;

            /* renamed from: values, reason: to resolve conflict with enum method */
            public static VectorEffect[] valuesCustom() {
                VectorEffect[] valuesCustom = values();
                int length = valuesCustom.length;
                VectorEffect[] vectorEffectArr = new VectorEffect[length];
                System.arraycopy(valuesCustom, 0, vectorEffectArr, 0, length);
                return vectorEffectArr;
            }
        }

        public static Style getDefaultStyle() {
            Style style = new Style();
            style.specifiedFlags = -1L;
            Colour colour = Colour.BLACK;
            style.fill = colour;
            FillRule fillRule = FillRule.NonZero;
            style.fillRule = fillRule;
            Float valueOf = Float.valueOf(1.0f);
            style.fillOpacity = valueOf;
            style.stroke = null;
            style.strokeOpacity = valueOf;
            style.strokeWidth = new Length(1.0f);
            style.strokeLineCap = LineCaps.Butt;
            style.strokeLineJoin = LineJoin.Miter;
            style.strokeMiterLimit = Float.valueOf(4.0f);
            style.strokeDashArray = null;
            style.strokeDashOffset = new Length(0.0f);
            style.opacity = valueOf;
            style.color = colour;
            style.fontFamily = null;
            style.fontSize = new Length(12.0f, Unit.pt);
            style.fontWeight = 400;
            style.fontStyle = FontStyle.Normal;
            style.textDecoration = TextDecoration.None;
            style.direction = TextDirection.LTR;
            style.textAnchor = TextAnchor.Start;
            Boolean bool = Boolean.TRUE;
            style.overflow = bool;
            style.clip = null;
            style.markerStart = null;
            style.markerMid = null;
            style.markerEnd = null;
            style.display = bool;
            style.visibility = bool;
            style.stopColor = colour;
            style.stopOpacity = valueOf;
            style.clipPath = null;
            style.clipRule = fillRule;
            style.mask = null;
            style.solidColor = null;
            style.solidOpacity = valueOf;
            style.viewportFill = null;
            style.viewportFillOpacity = valueOf;
            style.vectorEffect = VectorEffect.None;
            return style;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public Object clone() {
            try {
                Style style = (Style) super.clone();
                Length[] lengthArr = this.strokeDashArray;
                if (lengthArr != null) {
                    style.strokeDashArray = (Length[]) lengthArr.clone();
                }
                return style;
            } catch (CloneNotSupportedException e16) {
                throw new InternalError(e16.toString());
            }
        }

        public void resetNonInheritingProperties() {
            resetNonInheritingProperties(false);
        }

        public void resetNonInheritingProperties(boolean z16) {
            Boolean bool = Boolean.TRUE;
            this.display = bool;
            if (!z16) {
                bool = Boolean.FALSE;
            }
            this.overflow = bool;
            this.clip = null;
            this.clipPath = null;
            this.opacity = Float.valueOf(1.0f);
            this.stopColor = Colour.BLACK;
            this.stopOpacity = Float.valueOf(1.0f);
            this.mask = null;
            this.solidColor = null;
            this.solidOpacity = Float.valueOf(1.0f);
            this.viewportFill = null;
            this.viewportFillOpacity = Float.valueOf(1.0f);
            this.vectorEffect = VectorEffect.None;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class Svg extends SvgViewBoxContainer {
        public Length height;
        public String version;
        public Length width;

        /* renamed from: x, reason: collision with root package name */
        public Length f31969x;

        /* renamed from: y, reason: collision with root package name */
        public Length f31970y;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface SvgConditional {
        String getRequiredExtensions();

        Set<String> getRequiredFeatures();

        Set<String> getRequiredFonts();

        Set<String> getRequiredFormats();

        Set<String> getSystemLanguage();

        void setRequiredExtensions(String str);

        void setRequiredFeatures(Set<String> set);

        void setRequiredFonts(Set<String> set);

        void setRequiredFormats(Set<String> set);

        void setSystemLanguage(Set<String> set);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class SvgConditionalContainer extends SvgElement implements SvgContainer, SvgConditional {
        public List<SvgObject> children = new ArrayList();
        public Set<String> requiredFeatures = null;
        public String requiredExtensions = null;
        public Set<String> systemLanguage = null;
        public Set<String> requiredFormats = null;
        public Set<String> requiredFonts = null;

        protected SvgConditionalContainer() {
        }

        @Override // com.caverock.androidsvg.SVG.SvgContainer
        public void addChild(SvgObject svgObject) throws SAXException {
            this.children.add(svgObject);
        }

        @Override // com.caverock.androidsvg.SVG.SvgContainer
        public List<SvgObject> getChildren() {
            return this.children;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public String getRequiredExtensions() {
            return this.requiredExtensions;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public Set<String> getRequiredFeatures() {
            return this.requiredFeatures;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public Set<String> getRequiredFonts() {
            return this.requiredFonts;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public Set<String> getRequiredFormats() {
            return this.requiredFormats;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public Set<String> getSystemLanguage() {
            return null;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void setRequiredExtensions(String str) {
            this.requiredExtensions = str;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void setRequiredFeatures(Set<String> set) {
            this.requiredFeatures = set;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void setRequiredFonts(Set<String> set) {
            this.requiredFonts = set;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void setRequiredFormats(Set<String> set) {
            this.requiredFormats = set;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void setSystemLanguage(Set<String> set) {
            this.systemLanguage = set;
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    protected static class SvgConditionalElement extends SvgElement implements SvgConditional {
        public Set<String> requiredFeatures = null;
        public String requiredExtensions = null;
        public Set<String> systemLanguage = null;
        public Set<String> requiredFormats = null;
        public Set<String> requiredFonts = null;

        protected SvgConditionalElement() {
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public String getRequiredExtensions() {
            return this.requiredExtensions;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public Set<String> getRequiredFeatures() {
            return this.requiredFeatures;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public Set<String> getRequiredFonts() {
            return this.requiredFonts;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public Set<String> getRequiredFormats() {
            return this.requiredFormats;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public Set<String> getSystemLanguage() {
            return this.systemLanguage;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void setRequiredExtensions(String str) {
            this.requiredExtensions = str;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void setRequiredFeatures(Set<String> set) {
            this.requiredFeatures = set;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void setRequiredFonts(Set<String> set) {
            this.requiredFonts = set;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void setRequiredFormats(Set<String> set) {
            this.requiredFormats = set;
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditional
        public void setSystemLanguage(Set<String> set) {
            this.systemLanguage = set;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface SvgContainer {
        void addChild(SvgObject svgObject) throws SAXException;

        List<SvgObject> getChildren();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class SvgElement extends SvgElementBase {
        public Box boundingBox = null;

        protected SvgElement() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class SvgElementBase extends SvgObject {

        /* renamed from: id, reason: collision with root package name */
        public String f31971id = null;
        public Boolean spacePreserve = null;
        public Style baseStyle = null;
        public Style style = null;
        public List<String> classNames = null;

        protected SvgElementBase() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class SvgLinearGradient extends GradientElement {

        /* renamed from: x1, reason: collision with root package name */
        public Length f31972x1;

        /* renamed from: x2, reason: collision with root package name */
        public Length f31973x2;

        /* renamed from: y1, reason: collision with root package name */
        public Length f31974y1;

        /* renamed from: y2, reason: collision with root package name */
        public Length f31975y2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class SvgObject {
        public SVG document;
        public SvgContainer parent;

        protected SvgObject() {
        }

        public String toString() {
            return getClass().getSimpleName();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static abstract class SvgPaint implements Cloneable {
        protected SvgPaint() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class SvgPreserveAspectRatioContainer extends SvgConditionalContainer {
        public PreserveAspectRatio preserveAspectRatio = null;

        protected SvgPreserveAspectRatioContainer() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class SvgRadialGradient extends GradientElement {

        /* renamed from: cx, reason: collision with root package name */
        public Length f31976cx;

        /* renamed from: cy, reason: collision with root package name */
        public Length f31977cy;

        /* renamed from: fx, reason: collision with root package name */
        public Length f31978fx;

        /* renamed from: fy, reason: collision with root package name */
        public Length f31979fy;

        /* renamed from: r, reason: collision with root package name */
        public Length f31980r;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class SvgViewBoxContainer extends SvgPreserveAspectRatioContainer {
        public Box viewBox;

        protected SvgViewBoxContainer() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class Switch extends Group {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class Symbol extends SvgViewBoxContainer implements NotDirectlyRendered {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class TRef extends TextContainer implements TextChild {
        public String href;
        private TextRoot textRoot;

        @Override // com.caverock.androidsvg.SVG.TextChild
        public TextRoot getTextRoot() {
            return this.textRoot;
        }

        @Override // com.caverock.androidsvg.SVG.TextChild
        public void setTextRoot(TextRoot textRoot) {
            this.textRoot = textRoot;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class TSpan extends TextPositionedContainer implements TextChild {
        private TextRoot textRoot;

        @Override // com.caverock.androidsvg.SVG.TextChild
        public TextRoot getTextRoot() {
            return this.textRoot;
        }

        @Override // com.caverock.androidsvg.SVG.TextChild
        public void setTextRoot(TextRoot textRoot) {
            this.textRoot = textRoot;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class Text extends TextPositionedContainer implements TextRoot, HasTransform {
        public Matrix transform;

        @Override // com.caverock.androidsvg.SVG.HasTransform
        public void setTransform(Matrix matrix) {
            this.transform = matrix;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface TextChild {
        TextRoot getTextRoot();

        void setTextRoot(TextRoot textRoot);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class TextContainer extends SvgConditionalContainer {
        protected TextContainer() {
        }

        @Override // com.caverock.androidsvg.SVG.SvgConditionalContainer, com.caverock.androidsvg.SVG.SvgContainer
        public void addChild(SvgObject svgObject) throws SAXException {
            if (svgObject instanceof TextChild) {
                this.children.add(svgObject);
                return;
            }
            throw new SAXException("Text content elements cannot contain " + svgObject + " elements.");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class TextPath extends TextContainer implements TextChild {
        public String href;
        public Length startOffset;
        private TextRoot textRoot;

        @Override // com.caverock.androidsvg.SVG.TextChild
        public TextRoot getTextRoot() {
            return this.textRoot;
        }

        @Override // com.caverock.androidsvg.SVG.TextChild
        public void setTextRoot(TextRoot textRoot) {
            this.textRoot = textRoot;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class TextPositionedContainer extends TextContainer {

        /* renamed from: dx, reason: collision with root package name */
        public List<Length> f31981dx;

        /* renamed from: dy, reason: collision with root package name */
        public List<Length> f31982dy;

        /* renamed from: x, reason: collision with root package name */
        public List<Length> f31983x;

        /* renamed from: y, reason: collision with root package name */
        public List<Length> f31984y;

        protected TextPositionedContainer() {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface TextRoot {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class TextSequence extends SvgObject implements TextChild {
        public String text;
        private TextRoot textRoot;

        public TextSequence(String str) {
            this.text = str;
        }

        @Override // com.caverock.androidsvg.SVG.TextChild
        public TextRoot getTextRoot() {
            return this.textRoot;
        }

        @Override // com.caverock.androidsvg.SVG.TextChild
        public void setTextRoot(TextRoot textRoot) {
            this.textRoot = textRoot;
        }

        @Override // com.caverock.androidsvg.SVG.SvgObject
        public String toString() {
            return getClass().getSimpleName() + " '" + this.text + "'";
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public enum Unit {
        px,
        em,
        ex,
        in,
        cm,
        mm,
        pt,
        pc,
        percent;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static Unit[] valuesCustom() {
            Unit[] valuesCustom = values();
            int length = valuesCustom.length;
            Unit[] unitArr = new Unit[length];
            System.arraycopy(valuesCustom, 0, unitArr, 0, length);
            return unitArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class Use extends Group {
        public Length height;
        public String href;
        public Length width;

        /* renamed from: x, reason: collision with root package name */
        public Length f31993x;

        /* renamed from: y, reason: collision with root package name */
        public Length f31994y;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class View extends SvgViewBoxContainer implements NotDirectlyRendered {
    }

    private Box getDocumentDimensions(float f16) {
        Unit unit;
        Unit unit2;
        Unit unit3;
        Unit unit4;
        float f17;
        Unit unit5;
        Svg svg = this.rootElement;
        Length length = svg.width;
        Length length2 = svg.height;
        if (length != null && !length.isZero() && (unit = length.unit) != (unit2 = Unit.percent) && unit != (unit3 = Unit.em) && unit != (unit4 = Unit.ex)) {
            float floatValue = length.floatValue(f16);
            if (length2 != null) {
                if (!length2.isZero() && (unit5 = length2.unit) != unit2 && unit5 != unit3 && unit5 != unit4) {
                    f17 = length2.floatValue(f16);
                } else {
                    return new Box(-1.0f, -1.0f, -1.0f, -1.0f);
                }
            } else {
                Box box = this.rootElement.viewBox;
                if (box != null) {
                    f17 = (box.height * floatValue) / box.width;
                } else {
                    f17 = floatValue;
                }
            }
            return new Box(0.0f, 0.0f, floatValue, f17);
        }
        return new Box(-1.0f, -1.0f, -1.0f, -1.0f);
    }

    public static SVG getFromAsset(AssetManager assetManager, String str) throws SVGParseException, IOException {
        SVGParser sVGParser = new SVGParser();
        InputStream open = assetManager.open(str);
        SVG parse = sVGParser.parse(open);
        open.close();
        return parse;
    }

    public static SVG getFromInputStream(InputStream inputStream) throws SVGParseException {
        return new SVGParser().parse(inputStream);
    }

    public static SVG getFromResource(Context context, int i3) throws SVGParseException {
        return getFromResource(context.getResources(), i3);
    }

    public static SVG getFromString(String str) throws SVGParseException {
        return new SVGParser().parse(new ByteArrayInputStream(str.getBytes()));
    }

    public static String getVersion() {
        return VERSION;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addCSSRules(CSSParser.Ruleset ruleset) {
        this.cssRules.addAll(ruleset);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<CSSParser.Rule> getCSSRules() {
        return this.cssRules.getRules();
    }

    public float getDocumentAspectRatio() {
        Svg svg = this.rootElement;
        if (svg != null) {
            Length length = svg.width;
            Length length2 = svg.height;
            if (length != null && length2 != null) {
                Unit unit = length.unit;
                Unit unit2 = Unit.percent;
                if (unit != unit2 && length2.unit != unit2) {
                    if (length.isZero() || length2.isZero()) {
                        return -1.0f;
                    }
                    return length.floatValue(this.renderDPI) / length2.floatValue(this.renderDPI);
                }
            }
            Box box = svg.viewBox;
            if (box != null) {
                float f16 = box.width;
                if (f16 != 0.0f) {
                    float f17 = box.height;
                    if (f17 != 0.0f) {
                        return f16 / f17;
                    }
                }
            }
            return -1.0f;
        }
        throw new IllegalArgumentException("SVG document is empty");
    }

    public String getDocumentDescription() {
        if (this.rootElement != null) {
            return this.desc;
        }
        throw new IllegalArgumentException("SVG document is empty");
    }

    public float getDocumentHeight() {
        if (this.rootElement != null) {
            return getDocumentDimensions(this.renderDPI).height;
        }
        throw new IllegalArgumentException("SVG document is empty");
    }

    public PreserveAspectRatio getDocumentPreserveAspectRatio() {
        Svg svg = this.rootElement;
        if (svg != null) {
            PreserveAspectRatio preserveAspectRatio = svg.preserveAspectRatio;
            if (preserveAspectRatio == null) {
                return null;
            }
            return preserveAspectRatio;
        }
        throw new IllegalArgumentException("SVG document is empty");
    }

    public String getDocumentSVGVersion() {
        Svg svg = this.rootElement;
        if (svg != null) {
            return svg.version;
        }
        throw new IllegalArgumentException("SVG document is empty");
    }

    public String getDocumentTitle() {
        if (this.rootElement != null) {
            return this.title;
        }
        throw new IllegalArgumentException("SVG document is empty");
    }

    public RectF getDocumentViewBox() {
        Svg svg = this.rootElement;
        if (svg != null) {
            Box box = svg.viewBox;
            if (box == null) {
                return null;
            }
            return box.toRectF();
        }
        throw new IllegalArgumentException("SVG document is empty");
    }

    public float getDocumentWidth() {
        if (this.rootElement != null) {
            return getDocumentDimensions(this.renderDPI).width;
        }
        throw new IllegalArgumentException("SVG document is empty");
    }

    protected SvgObject getElementById(String str) {
        if (str.equals(this.rootElement.f31971id)) {
            return this.rootElement;
        }
        return getElementById(this.rootElement, str);
    }

    protected List<SvgObject> getElementsByTagName(Class cls) {
        return getElementsByTagName(this.rootElement, cls);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SVGExternalFileResolver getFileResolver() {
        return this.fileResolver;
    }

    public float getRenderDPI() {
        return this.renderDPI;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Svg getRootElement() {
        return this.rootElement;
    }

    public Set<String> getViewList() {
        if (this.rootElement != null) {
            List<SvgObject> elementsByTagName = getElementsByTagName(View.class);
            HashSet hashSet = new HashSet(elementsByTagName.size());
            Iterator<SvgObject> it = elementsByTagName.iterator();
            while (it.hasNext()) {
                String str = ((View) it.next()).f31971id;
                if (str != null) {
                    hashSet.add(str);
                } else {
                    Log.w(TAG, "getViewList(): found a <view> without an id attribute");
                }
            }
            return hashSet;
        }
        throw new IllegalArgumentException("SVG document is empty");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean hasCSSRules() {
        return !this.cssRules.isEmpty();
    }

    public void registerExternalFileResolver(SVGExternalFileResolver sVGExternalFileResolver) {
        this.fileResolver = sVGExternalFileResolver;
    }

    public void renderToCanvas(Canvas canvas) {
        renderToCanvas(canvas, null);
    }

    public Picture renderToPicture() {
        float floatValue;
        Length length = this.rootElement.width;
        if (length != null) {
            float floatValue2 = length.floatValue(this.renderDPI);
            Svg svg = this.rootElement;
            Box box = svg.viewBox;
            if (box != null) {
                floatValue = (box.height * floatValue2) / box.width;
            } else {
                Length length2 = svg.height;
                floatValue = length2 != null ? length2.floatValue(this.renderDPI) : floatValue2;
            }
            return renderToPicture((int) Math.ceil(floatValue2), (int) Math.ceil(floatValue));
        }
        return renderToPicture(512, 512);
    }

    public void renderViewToCanvas(String str, Canvas canvas) {
        renderViewToCanvas(str, canvas, null);
    }

    public Picture renderViewToPicture(String str, int i3, int i16) {
        SvgObject elementById = getElementById(str);
        if (elementById == null || !(elementById instanceof View)) {
            return null;
        }
        View view = (View) elementById;
        if (view.viewBox == null) {
            Log.w(TAG, "View element is missing a viewBox attribute.");
            return null;
        }
        Picture picture = new Picture();
        new SVGAndroidRenderer(picture.beginRecording(i3, i16), new Box(0.0f, 0.0f, i3, i16), this.renderDPI).renderDocument(this, view.viewBox, view.preserveAspectRatio, false);
        picture.endRecording();
        return picture;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SvgObject resolveIRI(String str) {
        if (str == null || str.length() <= 1 || !str.startsWith("#")) {
            return null;
        }
        return getElementById(str.substring(1));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setDesc(String str) {
        this.desc = str;
    }

    public void setDocumentHeight(float f16) {
        Svg svg = this.rootElement;
        if (svg != null) {
            svg.height = new Length(f16);
            return;
        }
        throw new IllegalArgumentException("SVG document is empty");
    }

    public void setDocumentPreserveAspectRatio(PreserveAspectRatio preserveAspectRatio) {
        Svg svg = this.rootElement;
        if (svg != null) {
            svg.preserveAspectRatio = preserveAspectRatio;
            return;
        }
        throw new IllegalArgumentException("SVG document is empty");
    }

    public void setDocumentViewBox(float f16, float f17, float f18, float f19) {
        Svg svg = this.rootElement;
        if (svg != null) {
            svg.viewBox = new Box(f16, f17, f18, f19);
            return;
        }
        throw new IllegalArgumentException("SVG document is empty");
    }

    public void setDocumentWidth(float f16) {
        Svg svg = this.rootElement;
        if (svg != null) {
            svg.width = new Length(f16);
            return;
        }
        throw new IllegalArgumentException("SVG document is empty");
    }

    public void setRenderDPI(float f16) {
        this.renderDPI = f16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setRootElement(Svg svg) {
        this.rootElement = svg;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setTitle(String str) {
        this.title = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private List<SvgObject> getElementsByTagName(SvgContainer svgContainer, Class cls) {
        ArrayList arrayList = new ArrayList();
        if (svgContainer.getClass() == cls) {
            arrayList.add((SvgObject) svgContainer);
        }
        for (Object obj : svgContainer.getChildren()) {
            if (obj.getClass() == cls) {
                arrayList.add(obj);
            }
            if (obj instanceof SvgContainer) {
                getElementsByTagName((SvgContainer) obj, cls);
            }
        }
        return arrayList;
    }

    public static SVG getFromResource(Resources resources, int i3) throws SVGParseException {
        return new SVGParser().parse(resources.openRawResource(i3));
    }

    public void renderToCanvas(Canvas canvas, RectF rectF) {
        Box box;
        if (rectF != null) {
            box = Box.fromLimits(rectF.left, rectF.top, rectF.right, rectF.bottom);
        } else {
            box = new Box(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        }
        new SVGAndroidRenderer(canvas, box, this.renderDPI).renderDocument(this, null, null, true);
    }

    public void renderViewToCanvas(String str, Canvas canvas, RectF rectF) {
        Box box;
        SvgObject elementById = getElementById(str);
        if (elementById != null && (elementById instanceof View)) {
            View view = (View) elementById;
            if (view.viewBox == null) {
                Log.w(TAG, "View element is missing a viewBox attribute.");
                return;
            }
            if (rectF != null) {
                box = Box.fromLimits(rectF.left, rectF.top, rectF.right, rectF.bottom);
            } else {
                box = new Box(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
            }
            new SVGAndroidRenderer(canvas, box, this.renderDPI).renderDocument(this, view.viewBox, view.preserveAspectRatio, true);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private SvgElementBase getElementById(SvgContainer svgContainer, String str) {
        SvgElementBase elementById;
        SvgElementBase svgElementBase = (SvgElementBase) svgContainer;
        if (str.equals(svgElementBase.f31971id)) {
            return svgElementBase;
        }
        for (Object obj : svgContainer.getChildren()) {
            if (obj instanceof SvgElementBase) {
                SvgElementBase svgElementBase2 = (SvgElementBase) obj;
                if (str.equals(svgElementBase2.f31971id)) {
                    return svgElementBase2;
                }
                if ((obj instanceof SvgContainer) && (elementById = getElementById((SvgContainer) obj, str)) != null) {
                    return elementById;
                }
            }
        }
        return null;
    }

    public void setDocumentHeight(String str) throws SVGParseException {
        Svg svg = this.rootElement;
        if (svg != null) {
            try {
                svg.height = SVGParser.parseLength(str);
                return;
            } catch (SAXException e16) {
                throw new SVGParseException(e16.getMessage());
            }
        }
        throw new IllegalArgumentException("SVG document is empty");
    }

    public void setDocumentWidth(String str) throws SVGParseException {
        Svg svg = this.rootElement;
        if (svg != null) {
            try {
                svg.width = SVGParser.parseLength(str);
                return;
            } catch (SAXException e16) {
                throw new SVGParseException(e16.getMessage());
            }
        }
        throw new IllegalArgumentException("SVG document is empty");
    }

    public Picture renderToPicture(int i3, int i16) {
        Picture picture = new Picture();
        new SVGAndroidRenderer(picture.beginRecording(i3, i16), new Box(0.0f, 0.0f, i3, i16), this.renderDPI).renderDocument(this, null, null, false);
        picture.endRecording();
        return picture;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class SolidColor extends SvgElementBase implements SvgContainer {
        public Length solidColor;
        public Length solidOpacity;

        @Override // com.caverock.androidsvg.SVG.SvgContainer
        public List<SvgObject> getChildren() {
            return SVG.EMPTY_CHILD_LIST;
        }

        @Override // com.caverock.androidsvg.SVG.SvgContainer
        public void addChild(SvgObject svgObject) throws SAXException {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class Stop extends SvgElementBase implements SvgContainer {
        public Float offset;

        @Override // com.caverock.androidsvg.SVG.SvgContainer
        public List<SvgObject> getChildren() {
            return SVG.EMPTY_CHILD_LIST;
        }

        @Override // com.caverock.androidsvg.SVG.SvgContainer
        public void addChild(SvgObject svgObject) throws SAXException {
        }
    }
}
