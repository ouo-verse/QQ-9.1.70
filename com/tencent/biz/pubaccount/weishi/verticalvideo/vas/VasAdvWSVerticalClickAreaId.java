package com.tencent.biz.pubaccount.weishi.verticalvideo.vas;

import com.tencent.mobileqq.zootopia.ue.PayPluginScene;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u001b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001d\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/verticalvideo/vas/VasAdvWSVerticalClickAreaId;", "", "value", "", "(Ljava/lang/String;II)V", HippyTextInputController.COMMAND_getValue, "()I", "AD_ICON", "HOST_AVATAR", "HOST_NAME", "AD_DESCRIPTION", "AD_IMAGE", "AD_VIDEO", "AD_BUTTON", "INDUSTRY_LABEL", "NEGATIVE_FEEDBACK", "COUNTDOWN_WIDGET", "MARKETING_PENDANT_WIDGET", "DANMAKU_WIDGET", "AD_FLOAT_APP_TIPS", "CARD_VIEW_BG", "CARD_VIEW_AVATAR", "CARD_VIEW_DESC", "CARD_VIEW_NAME", "CARD_VIEW_BUTTON", "CARD_VIEW_COUNTDOWN", "CARD_VIEW_MARKET_PENDANT", "CARD_VIEW_LABELS", "AD_SHAKE", PayPluginScene.OTHERS, "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes32.dex */
public enum VasAdvWSVerticalClickAreaId {
    AD_ICON(1),
    HOST_AVATAR(2),
    HOST_NAME(3),
    AD_DESCRIPTION(4),
    AD_IMAGE(5),
    AD_VIDEO(6),
    AD_BUTTON(8),
    INDUSTRY_LABEL(49),
    NEGATIVE_FEEDBACK(50),
    COUNTDOWN_WIDGET(51),
    MARKETING_PENDANT_WIDGET(52),
    DANMAKU_WIDGET(53),
    AD_FLOAT_APP_TIPS(55),
    CARD_VIEW_BG(56),
    CARD_VIEW_AVATAR(57),
    CARD_VIEW_DESC(58),
    CARD_VIEW_NAME(59),
    CARD_VIEW_BUTTON(60),
    CARD_VIEW_COUNTDOWN(61),
    CARD_VIEW_MARKET_PENDANT(62),
    CARD_VIEW_LABELS(63),
    AD_SHAKE(80),
    OTHERS(1000);

    private final int value;

    VasAdvWSVerticalClickAreaId(int i3) {
        this.value = i3;
    }

    public final int getValue() {
        return this.value;
    }
}
