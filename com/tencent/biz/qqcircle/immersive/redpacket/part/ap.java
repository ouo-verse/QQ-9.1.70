package com.tencent.biz.qqcircle.immersive.redpacket.part;

import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\f\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B%\u0012\b\b\u0001\u0010\t\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u000b\u001a\u00020\u0006\u0012\b\b\u0001\u0010\r\u001a\u00020\u0006\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\r\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\b\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/redpacket/part/ap;", "Lcom/tencent/biz/qqcircle/immersive/redpacket/part/i;", "", "z9", "", "onBackEvent", "", BdhLogUtil.LogTag.Tag_Conn, "I", "ivRes", "D", "tvColor", "E", "tvText", "<init>", "(III)V", UserInfo.SEX_FEMALE, "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class ap extends i {

    /* renamed from: C, reason: from kotlin metadata */
    private final int ivRes;

    /* renamed from: D, reason: from kotlin metadata */
    private final int tvColor;

    /* renamed from: E, reason: from kotlin metadata */
    private final int tvText;

    public ap(@DrawableRes int i3, @ColorRes int i16, @StringRes int i17) {
        super(i3, i16, i17);
        this.ivRes = i3;
        this.tvColor = i16;
        this.tvText = i17;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        z9();
        return true;
    }

    @Override // com.tencent.biz.qqcircle.immersive.redpacket.part.i
    public void z9() {
        broadcastMessage("EVENT_BACK_BTN_CLICKED", null);
    }
}
