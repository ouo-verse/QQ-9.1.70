package cooperation.qqcircle.report;

import androidx.annotation.Nullable;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QCircleReportBean implements Serializable {
    public static final String DEFAULT_CUSTOM_PAGE_ID = "0";
    public static final String TAG = "QCircleReportBean";
    private static final long serialVersionUID = 2688137205670436632L;
    private String mAuthUin;
    private String mDtCustomPagId;
    private String mDtFromElement;
    private String mDtFromPageId;
    private String mDtPageId;
    private String mFeedId;
    private int mFromPageId;
    private int mPageId;

    public QCircleReportBean() {
        this.mPageId = -1;
        this.mDtCustomPagId = "0";
    }

    public static String getDtFromElement(String str, QCircleReportBean qCircleReportBean) {
        if (qCircleReportBean != null) {
            QLog.d(str, 1, ":getFromElement value:" + qCircleReportBean.getFromElement());
            return qCircleReportBean.getFromElement();
        }
        return "";
    }

    public static int getParentPageId(String str, QCircleReportBean qCircleReportBean) {
        if (qCircleReportBean != null) {
            return qCircleReportBean.getFromPageId();
        }
        if (QLog.isColorLevel()) {
            QLog.d(str, 2, ":getParentPageId return invalid value:0");
            return 0;
        }
        return 0;
    }

    public static QCircleReportBean getReportBean(String str, QCircleReportBean qCircleReportBean) {
        if (qCircleReportBean == null) {
            if (((IAppSettingApi) QRoute.api(IAppSettingApi.class)).isDebugVersion()) {
                QQToast.makeText(RFWApplication.getApplication(), str + ":getReportBean is empty", 1).show();
                QLog.d(TAG, 1, str + ":getReportBean is empty");
            } else {
                return new QCircleReportBean();
            }
        }
        return qCircleReportBean;
    }

    public static boolean isContentDetailPage(int i3) {
        if (57 == i3) {
            return true;
        }
        return false;
    }

    public static boolean isFeedDetailPage(int i3) {
        if (69 == i3) {
            return true;
        }
        return false;
    }

    public static boolean isPublicAccountLayerPage(int i3) {
        if (301 == i3) {
            return true;
        }
        return false;
    }

    public static boolean isQQVideoPage(int i3) {
        if (i3 == 200) {
            return true;
        }
        return false;
    }

    public static boolean isSquarePage(int i3) {
        if (503 == i3) {
            return true;
        }
        return false;
    }

    public static QCircleReportBean setReportBean(String str, QCircleReportBean qCircleReportBean) {
        if (qCircleReportBean == null) {
            QLog.d(TAG, 1, str + ":setReportBean input is null");
            return null;
        }
        return qCircleReportBean.m466clone();
    }

    public void assembleFromReportData(QCircleReportBean qCircleReportBean) {
        this.mFromPageId = qCircleReportBean.mPageId;
    }

    public String getAuthUin() {
        return this.mAuthUin;
    }

    public String getDtCustomPagId() {
        return this.mDtCustomPagId;
    }

    public String getDtFromPageId() {
        return this.mDtFromPageId;
    }

    @Nullable
    public String getDtPageId() {
        return this.mDtPageId;
    }

    public String getFeedId() {
        return this.mFeedId;
    }

    public String getFromElement() {
        return this.mDtFromElement;
    }

    public int getFromPageId() {
        return this.mFromPageId;
    }

    public int getPageId() {
        return this.mPageId;
    }

    public QCircleReportBean setAuthUin(String str) {
        this.mAuthUin = str;
        return this;
    }

    public QCircleReportBean setDtCustomPageId(String str) {
        this.mDtCustomPagId = str;
        return this;
    }

    public QCircleReportBean setDtFromPageId(String str) {
        this.mDtFromPageId = str;
        return this;
    }

    public QCircleReportBean setDtPageId(String str) {
        this.mDtPageId = str;
        return this;
    }

    public QCircleReportBean setFeedId(String str) {
        this.mFeedId = str;
        return this;
    }

    public QCircleReportBean setFromElement(String str) {
        this.mDtFromElement = str;
        return this;
    }

    public QCircleReportBean setFromPageId(int i3) {
        this.mFromPageId = i3;
        return this;
    }

    public QCircleReportBean setPageId(int i3) {
        this.mPageId = i3;
        return this;
    }

    public String toString() {
        return "QCircleReportBean{mFromPageId=" + this.mFromPageId + ", mPageId=" + this.mPageId + ", mDtPageId='" + this.mDtPageId + "', mDtFromPageId='" + this.mDtFromPageId + "', mDtFromElement='" + this.mDtFromElement + "'}";
    }

    public static int getPageId(String str, QCircleReportBean qCircleReportBean) {
        if (qCircleReportBean != null) {
            return qCircleReportBean.getPageId();
        }
        return -1;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public QCircleReportBean m466clone() {
        QCircleReportBean qCircleReportBean = new QCircleReportBean();
        qCircleReportBean.mFromPageId = this.mFromPageId;
        qCircleReportBean.mPageId = this.mPageId;
        qCircleReportBean.mDtPageId = this.mDtPageId;
        qCircleReportBean.mDtFromPageId = this.mDtFromPageId;
        qCircleReportBean.mDtFromElement = this.mDtFromElement;
        qCircleReportBean.mDtCustomPagId = this.mDtCustomPagId;
        qCircleReportBean.mFeedId = this.mFeedId;
        qCircleReportBean.mAuthUin = this.mAuthUin;
        return qCircleReportBean;
    }

    public QCircleReportBean(int i3) {
        this.mDtCustomPagId = "0";
        this.mPageId = i3;
    }
}
