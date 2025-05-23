package com.tencent.hippykotlin.demo.pages.base;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.k;
import com.tencent.kuikly.core.base.w;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class QQCirVideoAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QQCirVideoAttr.class, "playControl", "getPlayControl()Lcom/tencent/hippykotlin/demo/pages/base/QVideoPlayControl;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QQCirVideoAttr.class, "muted", "getMuted()Z", 0)};
    public boolean adaptHeight;
    public w autoFillMaxSize;
    public w autoFillMinSize;
    public Cover cover;
    public boolean disableAppendHostAfterIP;
    public boolean exactSize;
    public e extDtReportParams;
    public String feedPbToken;
    public int index;
    public boolean isLiveVideo;
    public String playUrl;
    public String title;
    public Video video;
    public final ReadWriteProperty playControl$delegate = c.a(QVideoPlayControl.NONE);
    public final ReadWriteProperty muted$delegate = c.a(Boolean.FALSE);
    public boolean preloadDownloadEnable = true;
    public boolean loop = true;

    public final Cover getCover() {
        Cover cover = this.cover;
        if (cover != null) {
            return cover;
        }
        Intrinsics.throwUninitializedPropertyAccessException("cover");
        return null;
    }

    public final QVideoPlayControl getPlayControl() {
        return (QVideoPlayControl) this.playControl$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final Video getVideo() {
        Video video = this.video;
        if (video != null) {
            return video;
        }
        Intrinsics.throwUninitializedPropertyAccessException("video");
        return null;
    }

    public final void setMuted(boolean z16) {
        this.muted$delegate.setValue(this, $$delegatedProperties[1], Boolean.valueOf(z16));
    }

    public final void setPlayControl(QVideoPlayControl qVideoPlayControl) {
        this.playControl$delegate.setValue(this, $$delegatedProperties[0], qVideoPlayControl);
    }
}
