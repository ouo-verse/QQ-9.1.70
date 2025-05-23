package com.qzone.reborn.feedx.part;

import android.content.Intent;
import android.os.Message;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.feed.utils.QZoneFeedUtil;
import com.qzone.feed.utils.e;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.comment.bean.QZoneCommentPanelResultBean;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import java.io.Serializable;
import java.util.Map;

/* loaded from: classes37.dex */
public class QZoneFeedxForwardOperationPart extends g implements gf.b, com.qzone.feed.utils.e {

    /* renamed from: d, reason: collision with root package name */
    private BusinessFeedData f54892d;

    /* renamed from: e, reason: collision with root package name */
    private String f54893e;

    /* renamed from: f, reason: collision with root package name */
    private gf.a f54894f;

    private void F9(Intent intent) {
        Parcelable parcelableExtra = intent.getParcelableExtra("comment_panel_result_bean");
        if (!(parcelableExtra instanceof QZoneCommentPanelResultBean)) {
            QLog.e("QZoneFeedxForwardOperationPart", 1, "[doCommentIfNeed] bean is not instanceof");
            return;
        }
        QZoneCommentPanelResultBean qZoneCommentPanelResultBean = (QZoneCommentPanelResultBean) parcelableExtra;
        if (TextUtils.isEmpty(qZoneCommentPanelResultBean.getInputContent()) || !qZoneCommentPanelResultBean.getIsCheckedForwardAndComment() || TextUtils.isEmpty(com.qzone.reborn.feedx.util.aa.g(this.f54892d))) {
            return;
        }
        if (this.f54894f == null) {
            this.f54894f = (gf.a) getIocInterface(gf.a.class);
        }
        if (this.f54894f != null) {
            com.qzone.reborn.feedx.bean.b bVar = new com.qzone.reborn.feedx.bean.b(this.f54892d);
            bVar.f54740a = 0;
            bVar.f54741b = 4;
            this.f54894f.f6(bVar);
            this.f54894f.a9(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int G9() {
        gf.k kVar = (gf.k) getIocInterface(gf.k.class);
        if (kVar != null) {
            return com.qzone.reborn.feedx.util.x.f55790a.c(kVar.getPageType()) ? 2 : 0;
        }
        RFWLog.fatal("QZoneFeedxForwardOperationPart", RFWLog.USR, new RuntimeException("getClickScene error, pageTypeIoc is null"));
        return -1;
    }

    private void I9(QZoneResult qZoneResult) {
        String string;
        boolean z16 = qZoneResult.getBundle().getBoolean("isLongClick", false);
        if (qZoneResult.getSucceed()) {
            int intValue = ((Integer) qZoneResult.getData()).intValue();
            if (intValue == 1) {
                string = getActivity().getResources().getString(R.string.akw);
            } else if (intValue != 2) {
                string = intValue != 7 ? null : getActivity().getResources().getString(R.string.f170824al0);
            } else {
                string = getActivity().getResources().getString(R.string.f170825al1);
            }
            c6.a.j(string, 5);
            if (z16) {
                LpReportInfo_pf00064.allReport(85, 6, 1);
                return;
            }
            return;
        }
        c6.a.i(qZoneResult.getMessage());
        if (z16) {
            LpReportInfo_pf00064.allReport(85, 6, 2);
        }
    }

    private void L9() {
        if (getActivity() == null) {
            QLog.e("QZoneFeedxForwardOperationPart", 1, "qzm activity is null");
            return;
        }
        Intent intent = getActivity().getIntent();
        if (intent == null) {
            QLog.e("QZoneFeedxForwardOperationPart", 1, "qzm activity intent is null");
        } else if (intent.hasExtra("todayinhistoryheader")) {
            this.f54893e = intent.getStringExtra("todayinhistoryheader");
        }
    }

    protected String H9() {
        gf.k kVar = (gf.k) getIocInterface(gf.k.class);
        if (kVar == null) {
            return "";
        }
        return fo.c.h(kVar.getPageType());
    }

    public boolean K9() {
        return !TextUtils.isEmpty(this.f54893e);
    }

    @Override // d5.n
    public boolean Lc() {
        return false;
    }

    public void M9(BusinessFeedData businessFeedData) {
        this.f54892d = businessFeedData;
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneFeedxForwardOperationPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        if (i3 == 1205) {
            if (i16 == -1) {
                J9(intent, 2);
            }
        } else if (i3 == 1206 && i16 == -1) {
            J9(intent, 1);
            F9(intent);
        }
    }

    @Override // com.qzone.reborn.feedx.part.g, com.qzone.reborn.feedx.viewmodel.b
    public void onHandleMessage(Message message) {
        super.onHandleMessage(message);
        QZoneResult unpack = QZoneResult.unpack(message);
        if (unpack != null && message.what == 999908) {
            I9(unpack);
        }
    }

    @Override // com.qzone.reborn.feedx.part.g, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        registerIoc(this, gf.b.class);
        L9();
    }

    private void J9(final Intent intent, final int i3) {
        if (intent == null) {
            QLog.d("QZoneFeedxForwardOperationPart", 1, "handleForwardOrShareResult: data is null, actionType is: " + i3);
            return;
        }
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.reborn.feedx.part.QZoneFeedxForwardOperationPart.1
            @Override // java.lang.Runnable
            public void run() {
                if (intent.getBooleanExtra(QZoneHelper.QzoneFeedActionPanelConstants.KEY_IS_LONG_CLICK, false) && !com.qzone.reborn.configx.g.f53821a.a().j()) {
                    QZoneFeedUtil.t(QZoneFeedxForwardOperationPart.this.f54892d, "", i3, null, null, QZoneFeedxForwardOperationPart.this.getMainHandler(), false, QZoneFeedxForwardOperationPart.this.G9(), false, true);
                    com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface().doCommentActionReport(3);
                    return;
                }
                Parcelable parcelableExtra = intent.getParcelableExtra("comment_panel_result_bean");
                if (!(parcelableExtra instanceof QZoneCommentPanelResultBean)) {
                    QLog.e("QZoneFeedxForwardOperationPart", 1, "[handleForwardOrShareResult] bean is not instanceof");
                    return;
                }
                QZoneCommentPanelResultBean qZoneCommentPanelResultBean = (QZoneCommentPanelResultBean) parcelableExtra;
                if (qZoneCommentPanelResultBean.getInputContent() == null) {
                    qZoneCommentPanelResultBean.C("");
                }
                QZoneFeedUtil.t(QZoneFeedxForwardOperationPart.this.f54892d, qZoneCommentPanelResultBean.getInputContent(), i3, null, qZoneCommentPanelResultBean.getCacheUniKey(), QZoneFeedxForwardOperationPart.this.getMainHandler(), qZoneCommentPanelResultBean.getIsCheckedForwardAndComment(), QZoneFeedxForwardOperationPart.this.G9(), false, false);
                com.qzone.proxy.feedcomponent.c.f50143a.getUiInterface().doCommentActionReport(3);
            }
        });
    }

    @Override // gf.b
    public void O3(BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            return;
        }
        M9(businessFeedData);
        if (QZoneFeedUtil.m(businessFeedData)) {
            Intent intent = new Intent();
            intent.putExtra(QZoneHelper.QzoneFeedActionPanelConstants.KEY_IS_LONG_CLICK, true);
            int i3 = businessFeedData.getFeedCommInfo().appid;
            J9(intent, (i3 == 311 || i3 == 6100) ? 1 : 2);
            return;
        }
        LpReportInfo_pf00064.allReport(85, 6, 2);
    }

    @Override // gf.b
    public void P4(BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            return;
        }
        M9(businessFeedData);
        QZoneFeedUtil.X(businessFeedData, getHostFragment(), K9(), H9());
        LpReportInfo_pf00064.allReport(85, 5);
    }

    @Override // d5.n
    public void F7() {
    }

    @Override // d5.n
    public void b9(d5.k<BusinessFeedData> kVar) {
    }

    @Override // com.qzone.feed.utils.e
    public void x0(e.a aVar, Serializable serializable, Parcelable parcelable, Map<String, Object> map) {
    }
}
