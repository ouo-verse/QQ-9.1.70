package bl;

import androidx.exifinterface.media.ExifInterface;
import cl.CommonNoticeInteractiveInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonStCommonExt;
import com.qzone.reborn.albumx.common.convert.bean.CommonStUser;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqnt.kernel.nativeinterface.StFeed;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bd\u0010eR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0018\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u000b\u0010\u0015\"\u0004\b\u0016\u0010\u0017R(\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010)\u001a\u00020\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u00101\u001a\u00020*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00107\u001a\u0002028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u00103\u001a\u0004\b\u0003\u00104\"\u0004\b5\u00106R\"\u0010>\u001a\u0002088\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\"\u0010E\u001a\u00020?8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR(\u0010H\u001a\b\u0012\u0004\u0012\u00020\n0\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010\u001c\u001a\u0004\bF\u0010\u001e\"\u0004\bG\u0010 R\"\u0010O\u001a\u00020I8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\"\u0010U\u001a\u00020P8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bF\u0010Q\u001a\u0004\b\u001b\u0010R\"\u0004\bS\u0010TR$\u0010[\u001a\u0004\u0018\u00010V8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010W\u001a\u0004\b#\u0010X\"\u0004\bY\u0010ZR(\u0010^\u001a\b\u0012\u0004\u0012\u00020\\0\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u0010\u001c\u001a\u0004\b+\u0010\u001e\"\u0004\b]\u0010 R$\u0010c\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010_\u001a\u0004\b\u0013\u0010`\"\u0004\ba\u0010b\u00a8\u0006f"}, d2 = {"Lbl/f;", "", "", "a", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "u", "(Ljava/lang/String;)V", "noticeId", "", "b", "I", "k", "()I", "y", "(I)V", "noticeType", "", "c", "J", "()J", "o", "(J)V", WadlProxyConsts.CREATE_TIME, "", "Lbl/h;", "d", "Ljava/util/List;", tl.h.F, "()Ljava/util/List;", "v", "(Ljava/util/List;)V", "noticeMessage", "Lbl/b;", "e", "Lbl/b;", "i", "()Lbl/b;", "w", "(Lbl/b;)V", "noticeMessageIcon", "Lbl/c;", "f", "Lbl/c;", "j", "()Lbl/c;", HippyTKDListViewAdapter.X, "(Lbl/c;)V", "noticePatton", "Lbl/d;", "Lbl/d;", "()Lbl/d;", DomainData.DOMAIN_NAME, "(Lbl/d;)V", "action", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStUser;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStUser;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonStUser;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonStUser;)V", "opUser", "Lcom/tencent/qqnt/kernel/nativeinterface/StFeed;", "Lcom/tencent/qqnt/kernel/nativeinterface/StFeed;", "getFeed", "()Lcom/tencent/qqnt/kernel/nativeinterface/StFeed;", "setFeed", "(Lcom/tencent/qqnt/kernel/nativeinterface/StFeed;)V", "feed", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "opMask", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStCommonExt;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStCommonExt;", "getExt", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonStCommonExt;", "p", "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonStCommonExt;)V", "ext", "Lbl/e;", "Lbl/e;", "()Lbl/e;", "r", "(Lbl/e;)V", "feedComment", "Lbl/g;", "Lbl/g;", "()Lbl/g;", ReportConstant.COSTREPORT_PREFIX, "(Lbl/g;)V", "feedReply", "Lcl/c;", "t", "interactiveActions", "Ljava/lang/Object;", "()Ljava/lang/Object;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Ljava/lang/Object;)V", WadlProxyConsts.EXTRA_DATA, "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class f {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int noticeType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long createTime;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private CommonStReply feedReply;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private Object extraData;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String noticeId = "";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private List<CommonStRichMsg> noticeMessage = new ArrayList();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private CommonNoticeMessageIcon noticeMessageIcon = new CommonNoticeMessageIcon(0, null, 3, null);

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private CommonNoticePattonInfo noticePatton = new CommonNoticePattonInfo(0, null, null, false, 15, null);

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private CommonPattonAction action = new CommonPattonAction(0, null, 3, null);

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private CommonStUser opUser = new CommonStUser();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private StFeed feed = new StFeed();

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private List<Integer> opMask = new ArrayList();

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private CommonStCommonExt ext = new CommonStCommonExt();

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private CommonStComment feedComment = new CommonStComment(null, null, null, 0, 0 == true ? 1 : 0, 0 == true ? 1 : 0, null, 0 == true ? 1 : 0, 255, null);

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private List<CommonNoticeInteractiveInfo> interactiveActions = new ArrayList();

    public final void A(CommonStUser commonStUser) {
        Intrinsics.checkNotNullParameter(commonStUser, "<set-?>");
        this.opUser = commonStUser;
    }

    /* renamed from: a, reason: from getter */
    public final CommonPattonAction getAction() {
        return this.action;
    }

    /* renamed from: b, reason: from getter */
    public final long getCreateTime() {
        return this.createTime;
    }

    /* renamed from: c, reason: from getter */
    public final Object getExtraData() {
        return this.extraData;
    }

    /* renamed from: d, reason: from getter */
    public final CommonStComment getFeedComment() {
        return this.feedComment;
    }

    /* renamed from: e, reason: from getter */
    public final CommonStReply getFeedReply() {
        return this.feedReply;
    }

    public final List<CommonNoticeInteractiveInfo> f() {
        return this.interactiveActions;
    }

    /* renamed from: g, reason: from getter */
    public final String getNoticeId() {
        return this.noticeId;
    }

    public final List<CommonStRichMsg> h() {
        return this.noticeMessage;
    }

    /* renamed from: i, reason: from getter */
    public final CommonNoticeMessageIcon getNoticeMessageIcon() {
        return this.noticeMessageIcon;
    }

    /* renamed from: j, reason: from getter */
    public final CommonNoticePattonInfo getNoticePatton() {
        return this.noticePatton;
    }

    /* renamed from: k, reason: from getter */
    public final int getNoticeType() {
        return this.noticeType;
    }

    public final List<Integer> l() {
        return this.opMask;
    }

    /* renamed from: m, reason: from getter */
    public final CommonStUser getOpUser() {
        return this.opUser;
    }

    public final void n(CommonPattonAction commonPattonAction) {
        Intrinsics.checkNotNullParameter(commonPattonAction, "<set-?>");
        this.action = commonPattonAction;
    }

    public final void o(long j3) {
        this.createTime = j3;
    }

    public final void p(CommonStCommonExt commonStCommonExt) {
        Intrinsics.checkNotNullParameter(commonStCommonExt, "<set-?>");
        this.ext = commonStCommonExt;
    }

    public final void q(Object obj) {
        this.extraData = obj;
    }

    public final void r(CommonStComment commonStComment) {
        Intrinsics.checkNotNullParameter(commonStComment, "<set-?>");
        this.feedComment = commonStComment;
    }

    public final void s(CommonStReply commonStReply) {
        this.feedReply = commonStReply;
    }

    public final void t(List<CommonNoticeInteractiveInfo> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.interactiveActions = list;
    }

    public final void u(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.noticeId = str;
    }

    public final void v(List<CommonStRichMsg> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.noticeMessage = list;
    }

    public final void w(CommonNoticeMessageIcon commonNoticeMessageIcon) {
        Intrinsics.checkNotNullParameter(commonNoticeMessageIcon, "<set-?>");
        this.noticeMessageIcon = commonNoticeMessageIcon;
    }

    public final void x(CommonNoticePattonInfo commonNoticePattonInfo) {
        Intrinsics.checkNotNullParameter(commonNoticePattonInfo, "<set-?>");
        this.noticePatton = commonNoticePattonInfo;
    }

    public final void y(int i3) {
        this.noticeType = i3;
    }

    public final void z(List<Integer> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.opMask = list;
    }
}
