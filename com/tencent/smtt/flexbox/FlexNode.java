package com.tencent.smtt.flexbox;

import com.tencent.mtt.hippy.dom.flex.FlexMeasureMode;
import com.tencent.mtt.hippy.dom.flex.b;
import com.tencent.mtt.hippy.dom.flex.d;
import com.tencent.mtt.hippy.dom.flex.e;
import com.tencent.mtt.hippy.dom.flex.f;
import com.tencent.mtt.hippy.dom.flex.h;
import com.tencent.mtt.hippy.dom.flex.i;
import com.tencent.mtt.hippy.dom.flex.j;
import com.tencent.mtt.hippy.dom.flex.k;
import com.tencent.mtt.hippy.utils.I18nUtil;
import com.tencent.smtt.flexbox.FlexNodeStyle;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class FlexNode implements f<FlexNode> {
    private static final int BORDER = 4;
    private static final int MARGIN = 1;
    private static final int PADDING = 2;
    private List<FlexNode> mChildren;
    private Object mData;
    protected FlexNodeStyle mFlexNodeStyle;
    private final long mNativeFlexNode;
    private FlexNode mParent;
    private final boolean mDirty = true;
    private int mEdgeSetFlag = 0;
    private boolean mHasSetPosition = false;
    private float mWidth = Float.NaN;
    private float mHeight = Float.NaN;
    private float mTop = Float.NaN;
    private float mLeft = Float.NaN;
    private float mMarginLeft = 0.0f;
    private float mMarginTop = 0.0f;
    private float mMarginRight = 0.0f;
    private float mMarginBottom = 0.0f;
    private float mPaddingLeft = 0.0f;
    private float mPaddingTop = 0.0f;
    private float mPaddingRight = 0.0f;
    private float mPaddingBottom = 0.0f;
    private float mBorderLeft = 0.0f;
    private float mBorderTop = 0.0f;
    private float mBorderRight = 0.0f;
    private float mBorderBottom = 0.0f;
    private boolean mHasNewLayout = true;
    private f.a mMeasureFunction = null;

    /* compiled from: P */
    /* renamed from: com.tencent.smtt.flexbox.FlexNode$1, reason: invalid class name */
    /* loaded from: classes22.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f368898a;

        static {
            int[] iArr = new int[FlexNodeStyle.b.values().length];
            f368898a = iArr;
            try {
                iArr[FlexNodeStyle.b.EDGE_LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f368898a[FlexNodeStyle.b.EDGE_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f368898a[FlexNodeStyle.b.EDGE_TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f368898a[FlexNodeStyle.b.EDGE_RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f368898a[FlexNodeStyle.b.EDGE_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f368898a[FlexNodeStyle.b.EDGE_BOTTOM.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public FlexNode() {
        long nativeFlexNodeNew = nativeFlexNodeNew();
        this.mNativeFlexNode = nativeFlexNodeNew;
        if (nativeFlexNodeNew != 0) {
            this.mFlexNodeStyle = new FlexNodeStyle(nativeFlexNodeNew);
            reset();
            return;
        }
        throw new IllegalStateException("Failed to allocate native memory");
    }

    private int TotalChildCount() {
        if (this.mChildren == null) {
            return 0;
        }
        int childCount = getChildCount();
        for (int i3 = 0; i3 < this.mChildren.size(); i3++) {
            childCount += this.mChildren.get(i3).TotalChildCount();
        }
        return childCount;
    }

    private int TotalDirtyChildCount() {
        if (this.mChildren == null) {
            return 0;
        }
        int dirtyChildCount = getDirtyChildCount();
        for (int i3 = 0; i3 < this.mChildren.size(); i3++) {
            dirtyChildCount += this.mChildren.get(i3).TotalDirtyChildCount();
        }
        return dirtyChildCount;
    }

    private long measureFunc(float f16, int i3, float f17, int i16) {
        return measure(f16, i3, f17, i16);
    }

    private native void nativeFlexNodeCalculateLayout(long j3, float f16, float f17, long[] jArr, FlexNode[] flexNodeArr, int i3);

    private native void nativeFlexNodeFree(long j3);

    private native float nativeFlexNodeGetBorderBottom(long j3);

    private native float nativeFlexNodeGetBorderLeft(long j3);

    private native float nativeFlexNodeGetBorderRight(long j3);

    private native float nativeFlexNodeGetBorderTop(long j3);

    private native float nativeFlexNodeGetBottom(long j3);

    private native float nativeFlexNodeGetHeight(long j3);

    private native float nativeFlexNodeGetLeft(long j3);

    private native float nativeFlexNodeGetMarginBottom(long j3);

    private native float nativeFlexNodeGetMarginLeft(long j3);

    private native float nativeFlexNodeGetMarginRight(long j3);

    private native float nativeFlexNodeGetMarginTop(long j3);

    private native float nativeFlexNodeGetPaddingBottom(long j3);

    private native float nativeFlexNodeGetPaddingLeft(long j3);

    private native float nativeFlexNodeGetPaddingRight(long j3);

    private native float nativeFlexNodeGetPaddingTop(long j3);

    private native float nativeFlexNodeGetRight(long j3);

    private native float nativeFlexNodeGetTop(long j3);

    private native float nativeFlexNodeGetWidth(long j3);

    private native void nativeFlexNodeInsertChild(long j3, long j16, int i3);

    private native long nativeFlexNodeNew();

    private native boolean nativeFlexNodeNodeIsDirty(long j3);

    private native void nativeFlexNodeNodeMarkDirty(long j3);

    private native void nativeFlexNodeNodeSetHasBaselineFunc(long j3, boolean z16);

    private native void nativeFlexNodeNodeSetHasMeasureFunc(long j3, boolean z16);

    private native void nativeFlexNodeRemoveChild(long j3, long j16);

    private native void nativeFlexNodeSetBorderBottom(long j3, float f16);

    private native void nativeFlexNodeSetBorderLeft(long j3, float f16);

    private native void nativeFlexNodeSetBorderRight(long j3, float f16);

    private native void nativeFlexNodeSetBorderTop(long j3, float f16);

    private native void nativeFlexNodeSetBottom(long j3, float f16);

    private native void nativeFlexNodeSetHeight(long j3, float f16);

    private native void nativeFlexNodeSetLeft(long j3, float f16);

    private native void nativeFlexNodeSetMarginBottom(long j3, float f16);

    private native void nativeFlexNodeSetMarginLeft(long j3, float f16);

    private native void nativeFlexNodeSetMarginRight(long j3, float f16);

    private native void nativeFlexNodeSetMarginTop(long j3, float f16);

    private native void nativeFlexNodeSetPaddingBottom(long j3, float f16);

    private native void nativeFlexNodeSetPaddingLeft(long j3, float f16);

    private native void nativeFlexNodeSetPaddingRight(long j3, float f16);

    private native void nativeFlexNodeSetPaddingTop(long j3, float f16);

    private native void nativeFlexNodeSetRight(long j3, float f16);

    private native void nativeFlexNodeSetTop(long j3, float f16);

    private native void nativeFlexNodeSetWidth(long j3, float f16);

    private native boolean nativeFlexNodehasNewLayout(long j3);

    private native void nativeFlexNodemarkHasNewLayout(long j3);

    private native void nativeFlexNodemarkLayoutSeen(long j3);

    private native void nativeFlexNodereset(long j3);

    public FlexNodeStyle Style() {
        return this.mFlexNodeStyle;
    }

    public void calculateLayout() {
        calculateLayout(Float.NaN, Float.NaN, getStyleDirection());
    }

    public void dirty() {
        nativeFlexNodeNodeMarkDirty(this.mNativeFlexNode);
    }

    protected void finalize() throws Throwable {
        try {
            nativeFlexNodeFree(this.mNativeFlexNode);
        } finally {
            super.finalize();
        }
    }

    public com.tencent.mtt.hippy.dom.flex.a getAlignContent() {
        return Style().f();
    }

    public com.tencent.mtt.hippy.dom.flex.a getAlignItems() {
        return Style().d();
    }

    public com.tencent.mtt.hippy.dom.flex.a getAlignSelf() {
        return Style().e();
    }

    public float getBorder(int i3) {
        switch (AnonymousClass1.f368898a[FlexNodeStyle.b.a(i3).ordinal()]) {
            case 1:
            case 2:
                return this.mBorderLeft;
            case 3:
                return this.mBorderTop;
            case 4:
            case 5:
                return this.mBorderRight;
            case 6:
                return this.mBorderBottom;
            default:
                return Style().c(FlexNodeStyle.b.a(i3)).a();
        }
    }

    public int getChildCount() {
        List<FlexNode> list = this.mChildren;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public Object getData() {
        return this.mData;
    }

    public d getDirection() {
        return Style().a();
    }

    public int getDirtyChildCount() {
        if (this.mChildren == null) {
            return 0;
        }
        int i3 = 0;
        for (int i16 = 0; i16 < this.mChildren.size(); i16++) {
            if (this.mChildren.get(i16).isDirty()) {
                i3++;
            }
        }
        return i3;
    }

    public float getFlexBasis() {
        return Style().l().a();
    }

    public b getFlexDirection() {
        return Style().b();
    }

    public float getFlexGrow() {
        return Style().j();
    }

    public float getFlexShrink() {
        return Style().k();
    }

    public e getJustifyContent() {
        return Style().c();
    }

    public d getLayoutDirection() {
        return Style().a();
    }

    public float getLayoutHeight() {
        return this.mHeight;
    }

    public float getLayoutWidth() {
        return this.mWidth;
    }

    public float getLayoutX() {
        return this.mLeft;
    }

    public float getLayoutY() {
        return this.mTop;
    }

    public float getMargin(int i3) {
        switch (AnonymousClass1.f368898a[FlexNodeStyle.b.a(i3).ordinal()]) {
            case 1:
            case 2:
                return this.mMarginLeft;
            case 3:
                return this.mMarginTop;
            case 4:
            case 5:
                return this.mMarginRight;
            case 6:
                return this.mMarginBottom;
            default:
                return Style().a(FlexNodeStyle.b.a(i3)).a();
        }
    }

    public h getOverflow() {
        return Style().i();
    }

    public float getPadding(int i3) {
        switch (AnonymousClass1.f368898a[FlexNodeStyle.b.a(i3).ordinal()]) {
            case 1:
            case 2:
                return this.mPaddingLeft;
            case 3:
                return this.mPaddingTop;
            case 4:
            case 5:
                return this.mPaddingRight;
            case 6:
                return this.mPaddingBottom;
            default:
                return Style().b(FlexNodeStyle.b.a(i3)).a();
        }
    }

    public float getPosition(int i3) {
        return Style().d(FlexNodeStyle.b.a(i3)).a();
    }

    public i getPositionType() {
        return Style().g();
    }

    public d getStyleDirection() {
        return Style().a();
    }

    public float getStyleHeight() {
        return Style().n().a();
    }

    public float getStyleMaxHeight() {
        return Style().r().a();
    }

    public float getStyleMaxWidth() {
        return Style().q().a();
    }

    public float getStyleMinHeight() {
        return Style().p().a();
    }

    public float getStyleMinWidth() {
        return Style().o().a();
    }

    public float getStyleWidth() {
        return Style().m().a();
    }

    public boolean hasNewLayout() {
        return this.mHasNewLayout;
    }

    public boolean isDirty() {
        return nativeFlexNodeNodeIsDirty(this.mNativeFlexNode);
    }

    public boolean isMeasureDefined() {
        if (this.mMeasureFunction != null) {
            return true;
        }
        return false;
    }

    public void markLayoutSeen() {
        this.mHasNewLayout = false;
        nativeFlexNodemarkLayoutSeen(this.mNativeFlexNode);
    }

    public final long measure(float f16, int i3, float f17, int i16) {
        if (isMeasureDefined()) {
            return this.mMeasureFunction.measure(this, f16, FlexMeasureMode.fromInt(i3), f17, FlexMeasureMode.fromInt(i16));
        }
        throw new RuntimeException("Measure function isn't defined!");
    }

    public void reset() {
        d dVar;
        if (this.mParent == null) {
            List<FlexNode> list = this.mChildren;
            if (list == null || list.size() <= 0) {
                nativeFlexNodereset(this.mNativeFlexNode);
                if (I18nUtil.isRTL()) {
                    dVar = d.RTL;
                } else {
                    dVar = d.LTR;
                }
                setDirection(dVar);
                setFlexDirection(b.COLUMN);
                setJustifyContent(e.FLEX_START);
                setAlignContent(com.tencent.mtt.hippy.dom.flex.a.FLEX_START);
                setAlignItems(com.tencent.mtt.hippy.dom.flex.a.STRETCH);
                setAlignSelf(com.tencent.mtt.hippy.dom.flex.a.AUTO);
                setPositionType(i.RELATIVE);
                setWrap(j.NOWRAP);
                setOverflow(h.VISIBLE);
                setFlexGrow(0.0f);
                setFlexShrink(0.0f);
                setFlexBasis(Float.NaN);
                this.mMeasureFunction = null;
                this.mEdgeSetFlag = 0;
                this.mHasSetPosition = false;
                this.mHasNewLayout = true;
                this.mWidth = Float.NaN;
                this.mHeight = Float.NaN;
                this.mTop = Float.NaN;
                this.mLeft = Float.NaN;
                this.mMarginLeft = 0.0f;
                this.mMarginTop = 0.0f;
                this.mMarginRight = 0.0f;
                this.mMarginBottom = 0.0f;
                this.mPaddingLeft = 0.0f;
                this.mPaddingTop = 0.0f;
                this.mPaddingRight = 0.0f;
                this.mPaddingBottom = 0.0f;
                this.mBorderLeft = 0.0f;
                this.mBorderTop = 0.0f;
                this.mBorderRight = 0.0f;
                this.mBorderBottom = 0.0f;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String resultToString() {
        return "layout: {left: " + getLayoutX() + ", top: " + getLayoutY() + ", width: " + getLayoutWidth() + ", height: " + getLayoutHeight() + ", }";
    }

    public void setAlignContent(com.tencent.mtt.hippy.dom.flex.a aVar) {
        Style().c(aVar);
    }

    public void setAlignItems(com.tencent.mtt.hippy.dom.flex.a aVar) {
        Style().a(aVar);
    }

    public void setAlignSelf(com.tencent.mtt.hippy.dom.flex.a aVar) {
        Style().b(aVar);
    }

    public void setBorder(int i3, float f16) {
        this.mEdgeSetFlag |= 4;
        Style().c(FlexNodeStyle.b.a(i3), f16);
    }

    public void setData(Object obj) {
        this.mData = obj;
    }

    public void setDirection(d dVar) {
        Style().a(dVar);
    }

    public void setDisplay(FlexNodeStyle.a aVar) {
        Style().a(aVar);
    }

    public void setFlex(float f16) {
        Style().a(f16);
    }

    public void setFlexBasis(float f16) {
        Style().d(f16);
    }

    public void setFlexDirection(b bVar) {
        Style().a(bVar);
    }

    public void setFlexGrow(float f16) {
        Style().b(f16);
    }

    public void setFlexShrink(float f16) {
        Style().c(f16);
    }

    public void setJustifyContent(e eVar) {
        Style().a(eVar);
    }

    public void setMargin(int i3, float f16) {
        this.mEdgeSetFlag |= 1;
        Style().a(FlexNodeStyle.b.a(i3), f16);
    }

    public void setMeasureFunction(f.a aVar) {
        boolean z16;
        this.mMeasureFunction = aVar;
        long j3 = this.mNativeFlexNode;
        if (aVar != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        nativeFlexNodeNodeSetHasMeasureFunc(j3, z16);
    }

    public void setOverflow(h hVar) {
        Style().a(hVar);
    }

    public void setPadding(int i3, float f16) {
        this.mEdgeSetFlag |= 2;
        Style().b(FlexNodeStyle.b.a(i3), f16);
    }

    public void setPosition(int i3, float f16) {
        this.mHasSetPosition = true;
        Style().d(FlexNodeStyle.b.a(i3), f16);
    }

    public void setPositionType(i iVar) {
        Style().a(iVar);
    }

    public void setStyleHeight(float f16) {
        Style().f(f16);
    }

    public void setStyleMaxHeight(float f16) {
        Style().j(f16);
    }

    public void setStyleMaxWidth(float f16) {
        Style().i(f16);
    }

    public void setStyleMinHeight(float f16) {
        Style().h(f16);
    }

    public void setStyleMinWidth(float f16) {
        Style().g(f16);
    }

    public void setStyleWidth(float f16) {
        Style().e(f16);
    }

    public void setWrap(j jVar) {
        Style().a(jVar);
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        toStringWithIndentation(sb5, 0);
        return sb5.toString();
    }

    protected void toStringWithIndentation(StringBuilder sb5, int i3) {
        StringBuilder sb6 = new StringBuilder();
        for (int i16 = 0; i16 < i3; i16++) {
            sb6.append("__");
        }
        sb5.append(sb6.toString());
        sb5.append(this.mFlexNodeStyle.toString());
        sb5.append(resultToString());
        if (getChildCount() == 0) {
            return;
        }
        sb5.append(", children: [\n");
        for (int i17 = 0; i17 < getChildCount(); i17++) {
            getChildAt(i17).toStringWithIndentation(sb5, i3 + 1);
            sb5.append("\n");
        }
        sb5.append((CharSequence) sb6);
        sb5.append("]");
    }

    public boolean valuesEqual(float f16, float f17) {
        return k.a(f16, f17);
    }

    @Override // 
    public void addChildAt(FlexNode flexNode, int i3) {
        if (flexNode.mParent != null) {
            throw new IllegalStateException("Child already has a parent, it must be removed first.");
        }
        if (this.mChildren == null) {
            this.mChildren = new ArrayList(4);
        }
        this.mChildren.add(i3, flexNode);
        flexNode.mParent = this;
        nativeFlexNodeInsertChild(this.mNativeFlexNode, flexNode.mNativeFlexNode, i3);
    }

    public void calculateLayout(float f16, float f17, d dVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this);
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            List<FlexNode> list = ((FlexNode) arrayList.get(i3)).mChildren;
            if (list != null) {
                arrayList.addAll(list);
            }
        }
        FlexNode[] flexNodeArr = (FlexNode[]) arrayList.toArray(new FlexNode[arrayList.size()]);
        long[] jArr = new long[flexNodeArr.length];
        for (int i16 = 0; i16 < flexNodeArr.length; i16++) {
            jArr[i16] = flexNodeArr[i16].mNativeFlexNode;
        }
        nativeFlexNodeCalculateLayout(this.mNativeFlexNode, f16, f17, jArr, flexNodeArr, dVar.ordinal());
    }

    @Override // 
    public FlexNode getChildAt(int i3) {
        return this.mChildren.get(i3);
    }

    @Override // 
    public FlexNode getParent() {
        return this.mParent;
    }

    public int indexOf(FlexNode flexNode) {
        List<FlexNode> list = this.mChildren;
        if (list == null) {
            return -1;
        }
        return list.indexOf(flexNode);
    }

    @Override // 
    public FlexNode removeChildAt(int i3) {
        FlexNode remove = this.mChildren.remove(i3);
        remove.mParent = null;
        nativeFlexNodeRemoveChild(this.mNativeFlexNode, remove.mNativeFlexNode);
        return remove;
    }
}
