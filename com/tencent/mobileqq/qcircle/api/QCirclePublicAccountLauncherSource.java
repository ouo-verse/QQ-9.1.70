package com.tencent.mobileqq.qcircle.api;

import com.tencent.mobileqq.activity.framebusiness.controllerinject.TabDataHelper;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import cooperation.qzone.QZoneClickReport;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/qcircle/api/QCirclePublicAccountLauncherSource;", "", "value", "", "(Ljava/lang/String;II)V", HippyTextInputController.COMMAND_getValue, "()I", "MESSAGE_TAB", "PUBLIC_ACCOUNT_PROFILE_PAGE", DTConstants.KeyBoardAction.ACTION_SEARCH, TabDataHelper.TAB_CONTACT, QZoneClickReport.ClickReportConfig.SOURCE_FROM_AIO, "WEB", "qcircle-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public enum QCirclePublicAccountLauncherSource {
    MESSAGE_TAB(1),
    PUBLIC_ACCOUNT_PROFILE_PAGE(2),
    SEARCH(3),
    CONTACT(4),
    AIO(5),
    WEB(6);

    private final int value;

    QCirclePublicAccountLauncherSource(int i3) {
        this.value = i3;
    }

    public final int getValue() {
        return this.value;
    }
}
