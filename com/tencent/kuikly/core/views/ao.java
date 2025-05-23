package com.tencent.kuikly.core.views;

import com.heytap.databaseengine.apiv3.data.Element;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.kuikly.core.base.AbstractBaseView;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u001a\b\u0016\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0006R\"\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\b\u001a\u00020\u00068\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\n\u001a\u00020\u00068\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0012\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\"\u0010\u0019\u001a\u00020\u00068\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0012\u001a\u0004\b\u001a\u0010\u0014\"\u0004\b\u001b\u0010\u0016\u00a8\u0006 "}, d2 = {"Lcom/tencent/kuikly/core/views/ao;", "Lcom/tencent/kuikly/core/views/ScrollerAttr;", "", "maxIndex", "", "firstContentLoadMaxIndex", "", Element.ELEMENT_NAME_DISTANCE, "preloadViewDistance", "initOffset", "initContentOffset", "minOffset", "headerBouncesEnable", "I", "getFirstContentLoadMaxIndex", "()I", "setFirstContentLoadMaxIndex", "(I)V", UserInfo.SEX_FEMALE, "getPreloadViewDistance$core_release", "()F", "setPreloadViewDistance$core_release", "(F)V", "getInitContentOffset$core_release", "setInitContentOffset$core_release", "contentInsetTop", "getContentInsetTop$core_release", "setContentInsetTop$core_release", "<init>", "()V", "Companion", "a", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public class ao extends ScrollerAttr {
    public static final String MIN_CONTENT_OFFSET = "minContentOffset";
    public static final int MIN_LOAD_INDEX = 1;
    private float contentInsetTop;
    private int firstContentLoadMaxIndex = 8;
    private float initContentOffset;
    private float preloadViewDistance;

    /* renamed from: getContentInsetTop$core_release, reason: from getter */
    public final float getContentInsetTop() {
        return this.contentInsetTop;
    }

    public final int getFirstContentLoadMaxIndex() {
        return this.firstContentLoadMaxIndex;
    }

    /* renamed from: getInitContentOffset$core_release, reason: from getter */
    public final float getInitContentOffset() {
        return this.initContentOffset;
    }

    /* renamed from: getPreloadViewDistance$core_release, reason: from getter */
    public final float getPreloadViewDistance() {
        return this.preloadViewDistance;
    }

    public final void headerBouncesEnable(float minOffset) {
        with(MIN_CONTENT_OFFSET, Float.valueOf(minOffset));
    }

    public final void initContentOffset(float initOffset) {
        this.initContentOffset = initOffset;
    }

    public final void preloadViewDistance(float distance) {
        if (this.preloadViewDistance == distance) {
            return;
        }
        this.preloadViewDistance = distance;
        AbstractBaseView<?, ?> view = view();
        aq aqVar = view instanceof aq ? (aq) view : null;
        if (aqVar != null) {
            aqVar.preloadViewDistanceDidUpdate$core_release();
        }
    }

    public final void setContentInsetTop$core_release(float f16) {
        this.contentInsetTop = f16;
    }

    public final void setFirstContentLoadMaxIndex(int i3) {
        this.firstContentLoadMaxIndex = i3;
    }

    public final void setInitContentOffset$core_release(float f16) {
        this.initContentOffset = f16;
    }

    public final void setPreloadViewDistance$core_release(float f16) {
        this.preloadViewDistance = f16;
    }

    public void firstContentLoadMaxIndex(int maxIndex) {
        this.firstContentLoadMaxIndex = Math.max(maxIndex, 1);
    }
}
