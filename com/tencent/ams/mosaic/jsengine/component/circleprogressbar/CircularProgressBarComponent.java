package com.tencent.ams.mosaic.jsengine.component.circleprogressbar;

import com.tencent.ams.mosaic.jsengine.annotation.JSAgent;
import com.tencent.ams.mosaic.jsengine.component.Component;

@JSAgent
/* loaded from: classes3.dex */
public interface CircularProgressBarComponent extends Component {
    void setBarBackground(String str);

    void setBarForeground(String str);

    void setBarWidth(int i3);

    void setProgress(float f16);
}
