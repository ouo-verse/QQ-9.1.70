package com.tencent.mtt.hippy.dom.node;

import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.smtt.flexbox.FlexNode;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b extends FlexNode {
    private DomNodeRecord domNodeRecord;
    private int mID;
    float mLastHeight;
    float mLastWidth;
    float mLastX;
    float mLastY;
    private String mViewClassName;
    private boolean mNodeUpdated = true;
    private boolean mIsJustLayout = false;
    HippyMap mTotalProps = null;
    boolean mIsLazy = false;
    boolean mShouldNotifyOnlayout = false;

    private void updateDomainData() {
        DomNodeRecord domNodeRecord = this.domNodeRecord;
        if (domNodeRecord instanceof a) {
            ((a) domNodeRecord).a(this.mLastX, this.mLastY, this.mLastWidth, this.mLastHeight);
        }
    }

    @Override // com.tencent.smtt.flexbox.FlexNode
    public void dirty() {
        if (!isVirtual()) {
            super.dirty();
        }
    }

    public DomNodeRecord getDomNodeRecord() {
        return this.domNodeRecord;
    }

    public final int getId() {
        return this.mID;
    }

    public HippyMap getTotalProps() {
        return this.mTotalProps;
    }

    public final String getViewClass() {
        return this.mViewClassName;
    }

    public final boolean hasUpdates() {
        if (!this.mNodeUpdated && !hasNewLayout() && !isDirty()) {
            return false;
        }
        return true;
    }

    public boolean isJustLayout() {
        return this.mIsJustLayout;
    }

    public boolean isLazy() {
        return this.mIsLazy;
    }

    public boolean isVirtual() {
        return false;
    }

    public final void markUpdateSeen() {
        this.mNodeUpdated = false;
        if (hasNewLayout()) {
            markLayoutSeen();
        }
    }

    public void markUpdated() {
        if (this.mNodeUpdated) {
            return;
        }
        this.mNodeUpdated = true;
        b parent = getParent();
        if (parent != null) {
            parent.markUpdated();
        }
    }

    public void setDefaultPadding(int i3, float f16) {
        super.setPadding(i3, f16);
    }

    public void setDomNodeRecord(DomNodeRecord domNodeRecord) {
        this.domNodeRecord = domNodeRecord;
    }

    public void setId(int i3) {
        this.mID = i3;
    }

    public void setIsJustLayout(boolean z16) {
        this.mIsJustLayout = z16;
    }

    public void setLazy(boolean z16) {
        this.mIsLazy = z16;
    }

    public void setProps(HippyMap hippyMap) {
        this.mTotalProps = hippyMap;
    }

    public void setShouldNotifyOnLayout(boolean z16) {
        this.mShouldNotifyOnlayout = z16;
    }

    public void setViewClassName(String str) {
        this.mViewClassName = str;
    }

    public boolean shouldNotifyOnLayout() {
        return this.mShouldNotifyOnlayout;
    }

    public boolean shouldUpdateLayout(float f16, float f17) {
        boolean z16;
        if (this.mLastX == f16 && this.mLastY == f17 && this.mLastWidth == getLayoutWidth() && this.mLastHeight == getLayoutHeight()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            this.mLastX = f16;
            this.mLastY = f17;
            this.mLastWidth = getLayoutWidth();
            this.mLastHeight = getLayoutHeight();
            updateDomainData();
        }
        return z16;
    }

    @Override // com.tencent.smtt.flexbox.FlexNode
    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        toStringWithIndentation(sb5, 0);
        return sb5.toString();
    }

    @Override // com.tencent.smtt.flexbox.FlexNode
    protected void toStringWithIndentation(StringBuilder sb5, int i3) {
        StringBuilder sb6 = new StringBuilder();
        for (int i16 = 0; i16 < i3; i16++) {
            sb6.append("__");
        }
        sb5.append(sb6.toString());
        sb5.append("id:");
        sb5.append(getId());
        sb5.append(" className:");
        sb5.append(getViewClass());
        sb5.append(" ");
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

    @Override // com.tencent.smtt.flexbox.FlexNode
    public void addChildAt(FlexNode flexNode, int i3) {
        super.addChildAt(flexNode, i3);
        markUpdated();
    }

    @Override // com.tencent.smtt.flexbox.FlexNode
    public b getChildAt(int i3) {
        return (b) super.getChildAt(i3);
    }

    @Override // com.tencent.smtt.flexbox.FlexNode
    public b getParent() {
        return (b) super.getParent();
    }

    @Override // com.tencent.smtt.flexbox.FlexNode
    public b removeChildAt(int i3) {
        b bVar = (b) super.removeChildAt(i3);
        markUpdated();
        return bVar;
    }

    public void layoutAfter(HippyEngineContext hippyEngineContext) {
    }

    public void layoutBefore(HippyEngineContext hippyEngineContext) {
    }

    public void updateProps(HippyMap hippyMap) {
    }
}
