package com.tencent.tencentmap.mapsdk.maps.model;

import android.graphics.Color;
import android.os.Parcel;
import com.tencent.mapsdk.internal.ga;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes26.dex */
public class PolylineOptions {
    private static final int LINE_DEFAULT_WIDTH = 9;
    private static final int LINE_UNINITIALIZED_WIDTH = -1;

    @Deprecated
    private static String sDefaultArrowTexture;
    private boolean boArraw;
    private float fBorderWidth;
    private Animation initAnimation;
    private boolean mGradientEnable;
    private IndoorInfo mIndoorInfo;
    private Text mText;
    private List<Integer> pattern;
    private static final int COLOR_DEFAULT_POLYLINE = Color.argb(200, 0, 163, 255);
    private static String sDefaultColorTexture = ga.f148427i;
    private boolean boIsAbove = false;
    private int[] iColors = null;
    private int[] iBorderColors = {-16711936};
    private int[] iIndexs = null;
    private int eraseColor = -7829368;
    private int lineType = 0;
    private BitmapDescriptor mCustomeColorTexture = BitmapDescriptorFactory.fromAsset(sDefaultColorTexture);
    private boolean mAboveMaskLayer = false;
    private boolean mIsRoad = true;
    private BitmapDescriptor mArrowTexture = null;
    private boolean mClickable = true;
    private ColorType colorType = ColorType.LINE_COLOR_NONE;
    private int iLevel = 0;

    @Deprecated
    private String strCustomerTextName = sDefaultColorTexture;
    private int mArrowSpacing = 150;
    private float fwidth = -1.0f;
    private int iStrokeColor = COLOR_DEFAULT_POLYLINE;
    private boolean boVisible = true;
    private boolean boIsGeodes = false;
    private final List<LatLng> listLatLngs = new ArrayList();
    private float alpha = 1.0f;
    private boolean lineCap = true;
    private int fIndex = 0;

    /* loaded from: classes26.dex */
    public enum ColorType {
        LINE_COLOR_NONE,
        LINE_COLOR_TEXTURE,
        LINE_COLOR_ARGB
    }

    /* loaded from: classes26.dex */
    public static final class Colors {
        public static final int DARK_BLUE = 6;
        public static final int DASHED = 33;
        public static final int GRAYBLUE = 8;
        public static final int GREEN = 4;
        public static final int GREY = 0;
        public static final int LAST_BLUE = 20;
        public static final int LIGHT_BLUE = 1;
        public static final int LIVER_RED = 9;
        public static final int MID_BLUE = 5;
        public static final int RED = 2;
        public static final int TRANSPARENT = 7;
        public static final int WHITE_BLUE = 19;
        public static final int YELLOW = 3;
    }

    /* loaded from: classes26.dex */
    public static final class LineType {
        public static final int LINE_TYPE_DOTTEDLINE = 2;
        public static final int LINE_TYPE_IMAGEINARYLINE = 1;
        public static final int LINE_TYPE_MULTICOLORLINE = 0;
    }

    /* loaded from: classes26.dex */
    public static final class SegmentText {
        private final int endIndex;
        private final int startIndex;
        private final String text;

        public SegmentText(int i3, int i16, String str) {
            this.startIndex = i3;
            this.endIndex = i16;
            this.text = str;
        }

        public final int getEndIndex() {
            return this.endIndex;
        }

        public final int getStartIndex() {
            return this.startIndex;
        }

        public final String getText() {
            return this.text;
        }
    }

    /* loaded from: classes26.dex */
    public static final class Text {
        private Builder mBuilder;
        private final List<SegmentText> mSegmentTexts;

        public final TextPriority getPriority() {
            return this.mBuilder.priority;
        }

        public final List<SegmentText> getSegmentTexts() {
            return this.mSegmentTexts;
        }

        public final int getStrokeColor() {
            return this.mBuilder.strokeColor;
        }

        public final int getTextColor() {
            return this.mBuilder.textColor;
        }

        public final int getTextSize() {
            return this.mBuilder.textSize;
        }

        public final void setPriority(TextPriority textPriority) {
            this.mBuilder.priority = textPriority;
        }

        public final void setStrokeColor(int i3) {
            this.mBuilder.strokeColor = i3;
        }

        public final void setTextColor(int i3) {
            this.mBuilder.textColor = i3;
        }

        public final void setTextSize(int i3) {
            this.mBuilder.textSize = i3;
        }

        Text(Builder builder) {
            this.mSegmentTexts = Collections.unmodifiableList(builder.mTexts);
            this.mBuilder = builder;
        }

        /* loaded from: classes26.dex */
        public static final class Builder {
            private List<SegmentText> mTexts = new ArrayList();
            private int textColor = -16777216;
            private int strokeColor = -1;
            private int textSize = 14;
            private TextPriority priority = TextPriority.HIGH;

            public Builder(SegmentText segmentText) {
                addSegmentText(segmentText);
            }

            public final Builder addAllSegmentText(List<SegmentText> list) {
                this.mTexts.addAll(list);
                return this;
            }

            public final Builder addSegmentText(SegmentText segmentText) {
                this.mTexts.add(segmentText);
                return this;
            }

            public final Text build() {
                return new Text(this);
            }

            public final Builder color(int i3) {
                this.textColor = i3;
                return this;
            }

            public final Builder priority(TextPriority textPriority) {
                this.priority = textPriority;
                return this;
            }

            public final Builder size(int i3) {
                this.textSize = i3;
                return this;
            }

            public final Builder strokeColor(int i3) {
                this.strokeColor = i3;
                return this;
            }

            public Builder(List<SegmentText> list) {
                addAllSegmentText(list);
            }
        }
    }

    /* loaded from: classes26.dex */
    public enum TextPriority {
        NORMAL,
        HIGH
    }

    private PolylineOptions geodesic(boolean z16) {
        this.boIsGeodes = z16;
        return this;
    }

    @Deprecated
    public static String getsDefaultArrowTexture() {
        return sDefaultArrowTexture;
    }

    private boolean isGeodesic() {
        return this.boIsGeodes;
    }

    @Deprecated
    public static void setDefaultArrowTexture(String str) {
        sDefaultArrowTexture = str;
    }

    public PolylineOptions aboveMaskLayer(boolean z16) {
        this.mAboveMaskLayer = z16;
        return this;
    }

    public PolylineOptions abovePillar(boolean z16) {
        this.boIsAbove = z16;
        if (this.mIndoorInfo != null) {
            this.boIsAbove = true;
        }
        return this;
    }

    public PolylineOptions add(LatLng latLng, LatLng... latLngArr) {
        this.listLatLngs.add(latLng);
        if (latLngArr != null) {
            add(latLngArr);
        }
        return this;
    }

    public PolylineOptions addAll(Iterable<LatLng> iterable) {
        if (iterable != null) {
            Iterator<LatLng> it = iterable.iterator();
            while (it.hasNext()) {
                add(it.next(), new LatLng[0]);
            }
        }
        return this;
    }

    public PolylineOptions alpha(float f16) {
        this.alpha = f16;
        return this;
    }

    public PolylineOptions animation(Animation animation) {
        this.initAnimation = animation;
        return this;
    }

    public PolylineOptions arrow(boolean z16) {
        this.boArraw = z16;
        return this;
    }

    public PolylineOptions arrowSpacing(int i3) {
        this.mArrowSpacing = i3;
        return this;
    }

    public PolylineOptions arrowTexture(BitmapDescriptor bitmapDescriptor) {
        this.mArrowTexture = bitmapDescriptor;
        return this;
    }

    public PolylineOptions borderColor(int i3) {
        this.iBorderColors = new int[]{i3};
        return this;
    }

    public PolylineOptions borderColors(int[] iArr) {
        this.iBorderColors = iArr;
        return this;
    }

    public PolylineOptions borderWidth(float f16) {
        if (f16 < 0.0f) {
            this.fBorderWidth = 1.0f;
        } else {
            this.fBorderWidth = f16;
        }
        return this;
    }

    public PolylineOptions clickable(boolean z16) {
        this.mClickable = z16;
        return this;
    }

    public PolylineOptions color(int i3) {
        this.iStrokeColor = i3;
        return this;
    }

    public PolylineOptions colorTexture(BitmapDescriptor bitmapDescriptor) {
        this.mCustomeColorTexture = bitmapDescriptor;
        this.colorType = ColorType.LINE_COLOR_TEXTURE;
        return this;
    }

    public PolylineOptions colorType(ColorType colorType) {
        this.colorType = colorType;
        return this;
    }

    public PolylineOptions colors(int[] iArr, int[] iArr2) {
        this.iColors = iArr;
        this.iIndexs = iArr2;
        return this;
    }

    public PolylineOptions eraseColor(int i3) {
        this.eraseColor = i3;
        return this;
    }

    public float getAlpha() {
        return this.alpha;
    }

    public Animation getAnimation() {
        return this.initAnimation;
    }

    public int getArrowSpacing() {
        return this.mArrowSpacing;
    }

    public BitmapDescriptor getArrowTexture() {
        return this.mArrowTexture;
    }

    public int[] getBorderColors() {
        return this.iBorderColors;
    }

    public float getBorderWidth() {
        return this.fBorderWidth;
    }

    public int getColor() {
        return this.iStrokeColor;
    }

    public BitmapDescriptor getColorTexture() {
        return this.mCustomeColorTexture;
    }

    public ColorType getColorType() {
        return this.colorType;
    }

    public int[][] getColors() {
        int[] iArr;
        int[] iArr2 = this.iColors;
        if (iArr2 != null && (iArr = this.iIndexs) != null) {
            int[][] iArr3 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 2, Math.max(iArr2.length, iArr.length));
            iArr3[0] = this.iColors;
            iArr3[1] = this.iIndexs;
            return iArr3;
        }
        return null;
    }

    public int getEraseColor() {
        return this.eraseColor;
    }

    public IndoorInfo getIndoorInfo() {
        return this.mIndoorInfo;
    }

    public int getLevel() {
        return this.iLevel;
    }

    public boolean getLineCap() {
        return this.lineCap;
    }

    public int getLineType() {
        return this.lineType;
    }

    public List<Integer> getPattern() {
        return this.pattern;
    }

    public List<LatLng> getPoints() {
        return this.listLatLngs;
    }

    public Text getText() {
        return this.mText;
    }

    @Deprecated
    public String getTextureName() {
        return this.strCustomerTextName;
    }

    public float getWidth() {
        return this.fwidth;
    }

    public int getZIndex() {
        return this.fIndex;
    }

    public PolylineOptions gradient(boolean z16) {
        this.mGradientEnable = z16;
        return this;
    }

    public PolylineOptions indoorInfo(IndoorInfo indoorInfo) {
        if (indoorInfo != null) {
            this.mIndoorInfo = indoorInfo;
            this.boIsAbove = true;
        }
        return this;
    }

    public boolean isAboveMaskLayer() {
        return this.mAboveMaskLayer;
    }

    public boolean isAbovePillar() {
        return this.boIsAbove;
    }

    public boolean isArrow() {
        return this.boArraw;
    }

    public boolean isClickable() {
        return this.mClickable;
    }

    public boolean isGradientEnable() {
        return this.mGradientEnable;
    }

    public boolean isRoad() {
        return this.mIsRoad;
    }

    public boolean isVisible() {
        return this.boVisible;
    }

    public PolylineOptions latLngs(List<LatLng> list) {
        if (list != null) {
            this.listLatLngs.clear();
            this.listLatLngs.addAll(list);
        }
        return this;
    }

    public PolylineOptions level(int i3) {
        if (i3 >= 0 && i3 <= 2) {
            this.iLevel = i3;
        }
        return this;
    }

    public PolylineOptions lineCap(boolean z16) {
        this.lineCap = z16;
        return this;
    }

    public PolylineOptions lineType(int i3) {
        this.lineType = i3;
        return this;
    }

    public PolylineOptions pattern(List<Integer> list) {
        this.pattern = list;
        return this;
    }

    public PolylineOptions road(boolean z16) {
        this.mIsRoad = z16;
        return this;
    }

    @Deprecated
    public PolylineOptions setColorTexture(String str) {
        this.strCustomerTextName = str;
        return colorTexture(BitmapDescriptorFactory.fromAsset(str));
    }

    @Deprecated
    public void setColors(int[] iArr, int[] iArr2) {
        this.iColors = iArr;
        this.iIndexs = iArr2;
    }

    @Deprecated
    public void setLatLngs(List<LatLng> list) {
        latLngs(list);
    }

    @Deprecated
    public PolylineOptions setLineType(int i3) {
        return lineType(i3);
    }

    public PolylineOptions text(Text text) {
        this.mText = text;
        return this;
    }

    public String toString() {
        return "PolylineOptions{listLatLngs=" + this.listLatLngs + ", fwidth=" + this.fwidth + ", fBorderWidth=" + this.fBorderWidth + ", iStrokeColor=" + this.iStrokeColor + ", fIndex=" + this.fIndex + ", boVisible=" + this.boVisible + ", boIsGeodes=" + this.boIsGeodes + ", boArraw=" + this.boArraw + ", boIsAbove=" + this.boIsAbove + ", alpha=" + this.alpha + ", lineCap=" + this.lineCap + ", initAnimation=" + this.initAnimation + ", pattern=" + this.pattern + ", iColors=" + Arrays.toString(this.iColors) + ", iBorderColors=" + Arrays.toString(this.iBorderColors) + ", iIndexs=" + Arrays.toString(this.iIndexs) + ", eraseColor=" + this.eraseColor + ", lineType=" + this.lineType + ", mCustomeColorTexture=" + this.mCustomeColorTexture + ", mAboveMaskLayer=" + this.mAboveMaskLayer + ", mIsRoad=" + this.mIsRoad + ", mArrowTexture=" + this.mArrowTexture + ", mClickable=" + this.mClickable + ", colorType=" + this.colorType + ", mIndoorInfo=" + this.mIndoorInfo + ", iLevel=" + this.iLevel + ", mText=" + this.mText + ", strCustomerTextName='" + this.strCustomerTextName + "', mGradientEnable=" + this.mGradientEnable + ", mArrowSpacing=" + this.mArrowSpacing + '}';
    }

    public PolylineOptions updatePoints(Iterable<LatLng> iterable) {
        ArrayList arrayList = new ArrayList();
        if (iterable != null) {
            Iterator<LatLng> it = iterable.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
        }
        this.listLatLngs.clear();
        addAll(arrayList);
        return this;
    }

    public PolylineOptions visible(boolean z16) {
        this.boVisible = z16;
        return this;
    }

    public PolylineOptions width(float f16) {
        if (f16 < 0.0f) {
            this.fwidth = 9.0f;
        } else {
            if (f16 > 128.0f) {
                f16 = 128.0f;
            }
            this.fwidth = f16;
        }
        return this;
    }

    public void writeToParcel(Parcel parcel, int i3) {
        if (parcel == null) {
            return;
        }
        parcel.writeFloat(this.fwidth);
    }

    public PolylineOptions zIndex(int i3) {
        this.fIndex = Math.max(0, i3);
        return this;
    }

    public PolylineOptions add(LatLng[] latLngArr) {
        if (latLngArr != null) {
            this.listLatLngs.addAll(Arrays.asList(latLngArr));
        }
        return this;
    }
}
