package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.bean;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellBigTail;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellCommon;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellLBS;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellLocalInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellMedia;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellPermission;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellRemark;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellSummary;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonCellUserInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010-\u001a\u0004\u0018\u00010.X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R \u00103\u001a\b\u0012\u0004\u0012\u00020504X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109\u00a8\u0006:"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/bean/QzoneCommonFakeFeedBean;", "", "()V", "cellCommon", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellCommon;", "getCellCommon", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellCommon;", "setCellCommon", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellCommon;)V", "cellLbs", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellLBS;", "getCellLbs", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellLBS;", "setCellLbs", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellLBS;)V", "cellLocalInfo", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellLocalInfo;", "getCellLocalInfo", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellLocalInfo;", "setCellLocalInfo", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellLocalInfo;)V", "cellMedia", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellMedia;", "getCellMedia", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellMedia;", "setCellMedia", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellMedia;)V", "cellPermission", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellPermission;", "getCellPermission", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellPermission;", "setCellPermission", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellPermission;)V", "cellRemark", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellRemark;", "getCellRemark", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellRemark;", "setCellRemark", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellRemark;)V", "cellSummary", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellSummary;", "getCellSummary", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellSummary;", "setCellSummary", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellSummary;)V", "cellUserInfo", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellUserInfo;", "getCellUserInfo", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellUserInfo;", "setCellUserInfo", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellUserInfo;)V", "rptCellBigTail", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellBigTail;", "getRptCellBigTail", "()Ljava/util/List;", "setRptCellBigTail", "(Ljava/util/List;)V", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class QzoneCommonFakeFeedBean {
    public static final int $stable = 8;
    private CommonCellCommon cellCommon;
    private CommonCellLBS cellLbs;
    private CommonCellLocalInfo cellLocalInfo;
    private CommonCellMedia cellMedia;
    private CommonCellPermission cellPermission;
    private CommonCellRemark cellRemark;
    private CommonCellSummary cellSummary;
    private CommonCellUserInfo cellUserInfo;
    private List<CommonCellBigTail> rptCellBigTail = new ArrayList();

    public final CommonCellCommon getCellCommon() {
        return this.cellCommon;
    }

    public final CommonCellLBS getCellLbs() {
        return this.cellLbs;
    }

    public final CommonCellLocalInfo getCellLocalInfo() {
        return this.cellLocalInfo;
    }

    public final CommonCellMedia getCellMedia() {
        return this.cellMedia;
    }

    public final CommonCellPermission getCellPermission() {
        return this.cellPermission;
    }

    public final CommonCellRemark getCellRemark() {
        return this.cellRemark;
    }

    public final CommonCellSummary getCellSummary() {
        return this.cellSummary;
    }

    public final CommonCellUserInfo getCellUserInfo() {
        return this.cellUserInfo;
    }

    public final List<CommonCellBigTail> getRptCellBigTail() {
        return this.rptCellBigTail;
    }

    public final void setCellCommon(CommonCellCommon commonCellCommon) {
        this.cellCommon = commonCellCommon;
    }

    public final void setCellLbs(CommonCellLBS commonCellLBS) {
        this.cellLbs = commonCellLBS;
    }

    public final void setCellLocalInfo(CommonCellLocalInfo commonCellLocalInfo) {
        this.cellLocalInfo = commonCellLocalInfo;
    }

    public final void setCellMedia(CommonCellMedia commonCellMedia) {
        this.cellMedia = commonCellMedia;
    }

    public final void setCellPermission(CommonCellPermission commonCellPermission) {
        this.cellPermission = commonCellPermission;
    }

    public final void setCellRemark(CommonCellRemark commonCellRemark) {
        this.cellRemark = commonCellRemark;
    }

    public final void setCellSummary(CommonCellSummary commonCellSummary) {
        this.cellSummary = commonCellSummary;
    }

    public final void setCellUserInfo(CommonCellUserInfo commonCellUserInfo) {
        this.cellUserInfo = commonCellUserInfo;
    }

    public final void setRptCellBigTail(List<CommonCellBigTail> list) {
        this.rptCellBigTail = list;
    }
}
