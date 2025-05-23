package nm;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.winkreport.dengta.WinkDengtaReportConstant;
import com.tencent.qzone.pb.QZoneOfficialAccountBase$Botton;
import com.tencent.qzone.pb.QZoneOfficialAccountBase$CellAction;
import com.tencent.qzone.pb.QZoneOfficialAccountBase$CellBottom;
import com.tencent.qzone.pb.QZoneOfficialAccountBase$CellBotton;
import com.tencent.qzone.pb.QZoneOfficialAccountBase$CellHeader;
import com.tencent.qzone.pb.QZoneOfficialAccountBase$CellPic;
import com.tencent.qzone.pb.QZoneOfficialAccountBase$CellPlainText;
import com.tencent.qzone.pb.QZoneOfficialAccountBase$CellTitle;
import com.tencent.qzone.pb.QZoneOfficialAccountBase$CellVisitor;
import com.tencent.qzone.pb.QZoneOfficialAccountBase$InnerMessage;
import com.tencent.qzone.pb.QZoneOfficialAccountBase$MapExtraInfo;
import com.tencent.qzone.pb.QZoneOfficialAccountBase$PicInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0004\bX\u0010YR\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R$\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u001c\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010#\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u000f\u0010 \"\u0004\b!\u0010\"R$\u0010*\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R$\u00101\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R$\u00108\u001a\u0004\u0018\u0001028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b\u0007\u00105\"\u0004\b6\u00107R$\u0010?\u001a\u0004\u0018\u0001098\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b\u001e\u0010<\"\u0004\b=\u0010>R\u0011\u0010C\u001a\u00020@8F\u00a2\u0006\u0006\u001a\u0004\bA\u0010BR\u0011\u0010E\u001a\u00020@8F\u00a2\u0006\u0006\u001a\u0004\bD\u0010BR\u0013\u0010I\u001a\u0004\u0018\u00010F8F\u00a2\u0006\u0006\u001a\u0004\bG\u0010HR\u0011\u0010L\u001a\u00020J8F\u00a2\u0006\u0006\u001a\u0004\b:\u0010KR\u0013\u0010O\u001a\u0004\u0018\u00010M8F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010NR\u0011\u0010S\u001a\u00020P8F\u00a2\u0006\u0006\u001a\u0004\bQ\u0010RR\u0017\u0010W\u001a\b\u0012\u0004\u0012\u00020U0T8F\u00a2\u0006\u0006\u001a\u0004\b3\u0010V\u00a8\u0006Z"}, d2 = {"Lnm/b;", "", "Lcom/tencent/qzone/pb/QZoneOfficialAccountBase$InnerMessage;", "a", "Lcom/tencent/qzone/pb/QZoneOfficialAccountBase$InnerMessage;", "mSourceData", "Lcom/tencent/qzone/pb/QZoneOfficialAccountBase$CellHeader;", "b", "Lcom/tencent/qzone/pb/QZoneOfficialAccountBase$CellHeader;", "d", "()Lcom/tencent/qzone/pb/QZoneOfficialAccountBase$CellHeader;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Lcom/tencent/qzone/pb/QZoneOfficialAccountBase$CellHeader;)V", "cellHeader", "Lcom/tencent/qzone/pb/QZoneOfficialAccountBase$CellTitle;", "c", "Lcom/tencent/qzone/pb/QZoneOfficialAccountBase$CellTitle;", "f", "()Lcom/tencent/qzone/pb/QZoneOfficialAccountBase$CellTitle;", "t", "(Lcom/tencent/qzone/pb/QZoneOfficialAccountBase$CellTitle;)V", "cellTitle", "Lcom/tencent/qzone/pb/QZoneOfficialAccountBase$CellVisitor;", "Lcom/tencent/qzone/pb/QZoneOfficialAccountBase$CellVisitor;", "g", "()Lcom/tencent/qzone/pb/QZoneOfficialAccountBase$CellVisitor;", "u", "(Lcom/tencent/qzone/pb/QZoneOfficialAccountBase$CellVisitor;)V", "cellVisitor", "Lcom/tencent/qzone/pb/QZoneOfficialAccountBase$CellBottom;", "e", "Lcom/tencent/qzone/pb/QZoneOfficialAccountBase$CellBottom;", "()Lcom/tencent/qzone/pb/QZoneOfficialAccountBase$CellBottom;", "o", "(Lcom/tencent/qzone/pb/QZoneOfficialAccountBase$CellBottom;)V", "cellBottom", "Lcom/tencent/qzone/pb/QZoneOfficialAccountBase$CellBotton;", "Lcom/tencent/qzone/pb/QZoneOfficialAccountBase$CellBotton;", "getCellButton", "()Lcom/tencent/qzone/pb/QZoneOfficialAccountBase$CellBotton;", "p", "(Lcom/tencent/qzone/pb/QZoneOfficialAccountBase$CellBotton;)V", "cellButton", "Lcom/tencent/qzone/pb/QZoneOfficialAccountBase$CellPic;", "Lcom/tencent/qzone/pb/QZoneOfficialAccountBase$CellPic;", "getCellPic", "()Lcom/tencent/qzone/pb/QZoneOfficialAccountBase$CellPic;", "r", "(Lcom/tencent/qzone/pb/QZoneOfficialAccountBase$CellPic;)V", "cellPic", "Lcom/tencent/qzone/pb/QZoneOfficialAccountBase$CellAction;", h.F, "Lcom/tencent/qzone/pb/QZoneOfficialAccountBase$CellAction;", "()Lcom/tencent/qzone/pb/QZoneOfficialAccountBase$CellAction;", DomainData.DOMAIN_NAME, "(Lcom/tencent/qzone/pb/QZoneOfficialAccountBase$CellAction;)V", "cellAction", "Lcom/tencent/qzone/pb/QZoneOfficialAccountBase$CellPlainText;", "i", "Lcom/tencent/qzone/pb/QZoneOfficialAccountBase$CellPlainText;", "()Lcom/tencent/qzone/pb/QZoneOfficialAccountBase$CellPlainText;", ReportConstant.COSTREPORT_PREFIX, "(Lcom/tencent/qzone/pb/QZoneOfficialAccountBase$CellPlainText;)V", "cellPlainText", "", "j", "()I", QQBrowserActivity.KEY_MSG_TYPE, "l", WinkDengtaReportConstant.Params.REPORT_TEMPLATE_TYPE, "Lcom/tencent/qzone/pb/QZoneOfficialAccountBase$PicInfo;", "k", "()Lcom/tencent/qzone/pb/QZoneOfficialAccountBase$PicInfo;", "picInfo", "", "()Ljava/lang/String;", WadlProxyConsts.KEY_JUMP_URL, "Lcom/tencent/qzone/pb/QZoneOfficialAccountBase$Botton;", "()Lcom/tencent/qzone/pb/QZoneOfficialAccountBase$Botton;", "button", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Z", "isPlainText", "", "Lcom/tencent/qzone/pb/QZoneOfficialAccountBase$MapExtraInfo;", "()Ljava/util/List;", "extInfo", "<init>", "(Lcom/tencent/qzone/pb/QZoneOfficialAccountBase$InnerMessage;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final QZoneOfficialAccountBase$InnerMessage mSourceData;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private QZoneOfficialAccountBase$CellHeader cellHeader;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private QZoneOfficialAccountBase$CellTitle cellTitle;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private QZoneOfficialAccountBase$CellVisitor cellVisitor;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QZoneOfficialAccountBase$CellBottom cellBottom;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private QZoneOfficialAccountBase$CellBotton cellButton;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private QZoneOfficialAccountBase$CellPic cellPic;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private QZoneOfficialAccountBase$CellAction cellAction;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QZoneOfficialAccountBase$CellPlainText cellPlainText;

    public b(QZoneOfficialAccountBase$InnerMessage mSourceData) {
        Intrinsics.checkNotNullParameter(mSourceData, "mSourceData");
        this.mSourceData = mSourceData;
        c.f420447a.a(this, mSourceData);
    }

    public final QZoneOfficialAccountBase$Botton a() {
        QZoneOfficialAccountBase$CellBotton qZoneOfficialAccountBase$CellBotton = this.cellButton;
        if (qZoneOfficialAccountBase$CellBotton != null) {
            Intrinsics.checkNotNull(qZoneOfficialAccountBase$CellBotton);
            if (qZoneOfficialAccountBase$CellBotton.botton_list.size() != 0) {
                QZoneOfficialAccountBase$CellBotton qZoneOfficialAccountBase$CellBotton2 = this.cellButton;
                Intrinsics.checkNotNull(qZoneOfficialAccountBase$CellBotton2);
                return qZoneOfficialAccountBase$CellBotton2.botton_list.get(0);
            }
        }
        return null;
    }

    /* renamed from: b, reason: from getter */
    public final QZoneOfficialAccountBase$CellAction getCellAction() {
        return this.cellAction;
    }

    /* renamed from: c, reason: from getter */
    public final QZoneOfficialAccountBase$CellBottom getCellBottom() {
        return this.cellBottom;
    }

    /* renamed from: d, reason: from getter */
    public final QZoneOfficialAccountBase$CellHeader getCellHeader() {
        return this.cellHeader;
    }

    /* renamed from: e, reason: from getter */
    public final QZoneOfficialAccountBase$CellPlainText getCellPlainText() {
        return this.cellPlainText;
    }

    /* renamed from: f, reason: from getter */
    public final QZoneOfficialAccountBase$CellTitle getCellTitle() {
        return this.cellTitle;
    }

    /* renamed from: g, reason: from getter */
    public final QZoneOfficialAccountBase$CellVisitor getCellVisitor() {
        return this.cellVisitor;
    }

    public final List<QZoneOfficialAccountBase$MapExtraInfo> h() {
        List<QZoneOfficialAccountBase$MapExtraInfo> list = this.mSourceData.ext_info.get();
        Intrinsics.checkNotNullExpressionValue(list, "mSourceData.ext_info.get()");
        return list;
    }

    public final String i() {
        QZoneOfficialAccountBase$CellAction qZoneOfficialAccountBase$CellAction = this.cellAction;
        if (qZoneOfficialAccountBase$CellAction != null) {
            Intrinsics.checkNotNull(qZoneOfficialAccountBase$CellAction);
            if (qZoneOfficialAccountBase$CellAction.has()) {
                QZoneOfficialAccountBase$CellAction qZoneOfficialAccountBase$CellAction2 = this.cellAction;
                Intrinsics.checkNotNull(qZoneOfficialAccountBase$CellAction2);
                String str = qZoneOfficialAccountBase$CellAction2.jump_url.get();
                Intrinsics.checkNotNullExpressionValue(str, "cellAction!!.jump_url.get()");
                return str;
            }
        }
        return "";
    }

    public final int j() {
        return this.mSourceData.inner_msg_type.get();
    }

    public final QZoneOfficialAccountBase$PicInfo k() {
        QZoneOfficialAccountBase$CellPic qZoneOfficialAccountBase$CellPic = this.cellPic;
        if (qZoneOfficialAccountBase$CellPic != null) {
            Intrinsics.checkNotNull(qZoneOfficialAccountBase$CellPic);
            if (qZoneOfficialAccountBase$CellPic.pic_list.size() != 0) {
                QZoneOfficialAccountBase$CellPic qZoneOfficialAccountBase$CellPic2 = this.cellPic;
                Intrinsics.checkNotNull(qZoneOfficialAccountBase$CellPic2);
                return qZoneOfficialAccountBase$CellPic2.pic_list.get(0);
            }
        }
        return null;
    }

    public final int l() {
        return this.mSourceData.template_type.get();
    }

    public final boolean m() {
        QZoneOfficialAccountBase$CellPlainText qZoneOfficialAccountBase$CellPlainText;
        if (k() == null && (qZoneOfficialAccountBase$CellPlainText = this.cellPlainText) != null) {
            Intrinsics.checkNotNull(qZoneOfficialAccountBase$CellPlainText);
            if (qZoneOfficialAccountBase$CellPlainText.has()) {
                return true;
            }
        }
        return false;
    }

    public final void n(QZoneOfficialAccountBase$CellAction qZoneOfficialAccountBase$CellAction) {
        this.cellAction = qZoneOfficialAccountBase$CellAction;
    }

    public final void o(QZoneOfficialAccountBase$CellBottom qZoneOfficialAccountBase$CellBottom) {
        this.cellBottom = qZoneOfficialAccountBase$CellBottom;
    }

    public final void p(QZoneOfficialAccountBase$CellBotton qZoneOfficialAccountBase$CellBotton) {
        this.cellButton = qZoneOfficialAccountBase$CellBotton;
    }

    public final void q(QZoneOfficialAccountBase$CellHeader qZoneOfficialAccountBase$CellHeader) {
        this.cellHeader = qZoneOfficialAccountBase$CellHeader;
    }

    public final void r(QZoneOfficialAccountBase$CellPic qZoneOfficialAccountBase$CellPic) {
        this.cellPic = qZoneOfficialAccountBase$CellPic;
    }

    public final void s(QZoneOfficialAccountBase$CellPlainText qZoneOfficialAccountBase$CellPlainText) {
        this.cellPlainText = qZoneOfficialAccountBase$CellPlainText;
    }

    public final void t(QZoneOfficialAccountBase$CellTitle qZoneOfficialAccountBase$CellTitle) {
        this.cellTitle = qZoneOfficialAccountBase$CellTitle;
    }

    public final void u(QZoneOfficialAccountBase$CellVisitor qZoneOfficialAccountBase$CellVisitor) {
        this.cellVisitor = qZoneOfficialAccountBase$CellVisitor;
    }
}
