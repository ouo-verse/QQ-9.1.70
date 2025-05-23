package org.light.lightAssetKit.components;

import com.tencent.biz.common.util.WebViewConstants;
import org.light.lightAssetKit.ComponentBase;
import org.light.lightAssetKit.enums.TimeOffsetType;

/* compiled from: P */
/* loaded from: classes29.dex */
public class EventTrigger extends Component {
    private String event = "";
    private long startOffset = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
    private TimeOffsetType timeOffsetType;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public void doUpdate(ComponentBase componentBase) {
        if (componentBase instanceof EventTrigger) {
            EventTrigger eventTrigger = (EventTrigger) componentBase;
            this.event = eventTrigger.event;
            this.startOffset = eventTrigger.startOffset;
            this.timeOffsetType = eventTrigger.timeOffsetType;
        }
        super.doUpdate(componentBase);
    }

    public String getEvent() {
        return this.event;
    }

    public long getStartOffset() {
        return this.startOffset;
    }

    public TimeOffsetType getTimeOffsetType() {
        return this.timeOffsetType;
    }

    public void setEvent(String str) {
        this.event = str;
        reportPropertyChange("event", str);
    }

    public void setStartOffset(long j3) {
        this.startOffset = j3;
        reportPropertyChange("startOffset", Long.valueOf(j3));
    }

    public void setTimeOffsetType(TimeOffsetType timeOffsetType) {
        this.timeOffsetType = timeOffsetType;
        reportPropertyChange("timeOffsetType", timeOffsetType);
    }

    @Override // org.light.lightAssetKit.components.Component, org.light.lightAssetKit.ComponentBase
    public String type() {
        return "EventTrigger";
    }
}
