package org.light.lightAssetKit.components;

import com.tencent.biz.common.util.WebViewConstants;
import org.light.lightAssetKit.ComponentBase;

/* compiled from: P */
/* loaded from: classes29.dex */
public class TimeOffset extends Component {
    private long startOffset = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
    private long endOffset = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
    private long duration = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
    private int loopCount = 0;
    private boolean visibleWhileOverTime = false;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof TimeOffset) {
            TimeOffset timeOffset = (TimeOffset) componentBase;
            this.startOffset = timeOffset.startOffset;
            this.endOffset = timeOffset.endOffset;
            this.duration = timeOffset.duration;
            this.loopCount = timeOffset.loopCount;
            this.visibleWhileOverTime = timeOffset.visibleWhileOverTime;
        }
        super.doUpdate(componentBase);
    }

    public long getDuration() {
        return this.duration;
    }

    public long getEndOffset() {
        return this.endOffset;
    }

    public int getLoopCount() {
        return this.loopCount;
    }

    public long getStartOffset() {
        return this.startOffset;
    }

    public boolean getVisibleWhileOverTime() {
        return this.visibleWhileOverTime;
    }

    public void setDuration(long j3) {
        this.duration = j3;
        reportPropertyChange("duration", Long.valueOf(j3));
    }

    public void setEndOffset(long j3) {
        this.endOffset = j3;
        reportPropertyChange("endOffset", Long.valueOf(j3));
    }

    public void setLoopCount(int i3) {
        this.loopCount = i3;
        reportPropertyChange("loopCount", Integer.valueOf(i3));
    }

    public void setStartOffset(long j3) {
        this.startOffset = j3;
        reportPropertyChange("startOffset", Long.valueOf(j3));
    }

    public void setVisibleWhileOverTime(boolean z16) {
        this.visibleWhileOverTime = z16;
        reportPropertyChange("visibleWhileOverTime", Boolean.valueOf(z16));
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "TimeOffset";
    }
}
