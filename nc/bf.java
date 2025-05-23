package nc;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonClientAttr;
import com.qzone.reborn.albumx.common.convert.bean.CommonStUser;
import com.qzone.reborn.albumx.common.convert.bean.CommonUinAttr;
import com.qzone.reborn.albumx.qzonex.bean.initbean.QZAlbumxAlbumDetailInitBean;
import com.qzone.reborn.albumx.qzonex.bean.initbean.QZAlbumxInvitePageInitBean;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.AlbumInfo;
import com.tencent.qqnt.kernel.nativeinterface.AuditAction;
import com.tencent.qqnt.kernel.nativeinterface.ClientAttr;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceGetAlbumInviteJoinPageCallback;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceGetAlbumJoinApprovalPageCallback;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceJoinShareAlbumCallback;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceRespondToJoinRequestCallback;
import com.tencent.qqnt.kernel.nativeinterface.JoinPageLoginUserAlbumStatus;
import com.tencent.qqnt.kernel.nativeinterface.JoinSource;
import com.tencent.qqnt.kernel.nativeinterface.PAGetAlbumInviteJoinPageReq;
import com.tencent.qqnt.kernel.nativeinterface.PAGetAlbumInviteJoinPageRsp;
import com.tencent.qqnt.kernel.nativeinterface.PAGetAlbumJoinApprovalPageReq;
import com.tencent.qqnt.kernel.nativeinterface.PAGetAlbumJoinApprovalPageRsp;
import com.tencent.qqnt.kernel.nativeinterface.PAJoinShareAlbumReq;
import com.tencent.qqnt.kernel.nativeinterface.PAJoinShareAlbumRsp;
import com.tencent.qqnt.kernel.nativeinterface.PARespondToJoinRequestReq;
import com.tencent.qqnt.kernel.nativeinterface.PARespondToJoinRequestRsp;
import com.tencent.qqnt.kernel.nativeinterface.StUser;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 G2\u00020\u0001:\u0001HB\u0007\u00a2\u0006\u0004\bE\u0010FJ8\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J8\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0012\u0010\u0015\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\tH\u0002J\u0010\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0016\u0010\u001c\u001a\u00020\f2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0002J\b\u0010\u001d\u001a\u00020\tH\u0016J\u0010\u0010 \u001a\u00020\f2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eJ\u000e\u0010\"\u001a\u00020\f2\u0006\u0010!\u001a\u00020\u0006J\u0006\u0010#\u001a\u00020\u0016J\u0006\u0010$\u001a\u00020\u0016J\u0006\u0010%\u001a\u00020\fJ\u0006\u0010&\u001a\u00020\fJ\u000e\u0010'\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0016J\u000e\u0010)\u001a\u00020\f2\u0006\u0010(\u001a\u00020\u0006J\u000e\u0010,\u001a\u00020\f2\u0006\u0010+\u001a\u00020*R\"\u00104\u001a\u00020-8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R(\u0010<\u001a\b\u0012\u0004\u0012\u00020\u0006058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R(\u0010@\u001a\b\u0012\u0004\u0012\u00020\u0006058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b=\u00107\u001a\u0004\b>\u00109\"\u0004\b?\u0010;R(\u0010D\u001a\b\u0012\u0004\u0012\u00020\u0011058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bA\u00107\u001a\u0004\bB\u00109\"\u0004\bC\u0010;\u00a8\u0006I"}, d2 = {"Lnc/bf;", "Lcom/qzone/reborn/base/n;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStUser;", "pendingUser", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "albumInfo", "", "loginUserStatus", "approvalStatus", "", "entranceAlbumId", "entranceAlbumOwner", "", "i2", "invitee", "inviteStatus", "j2", "Lab/a;", "rsp", "t2", "errorMsg", "u2", "", "isPass", "m2", "", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonClientAttr;", "clientAttrs", "k2", "getLogTag", "Landroid/content/Intent;", "intent", "w2", "roleId", "B2", ICustomDataEditor.NUMBER_PARAM_2, "o2", "X1", "d2", "x2", "role", "p2", "Landroid/content/Context;", "context", ICustomDataEditor.STRING_PARAM_2, "Lcom/qzone/reborn/albumx/qzonex/bean/initbean/QZAlbumxInvitePageInitBean;", "i", "Lcom/qzone/reborn/albumx/qzonex/bean/initbean/QZAlbumxInvitePageInitBean;", "g2", "()Lcom/qzone/reborn/albumx/qzonex/bean/initbean/QZAlbumxInvitePageInitBean;", NowProxyConstants.AccountInfoKey.A2, "(Lcom/qzone/reborn/albumx/qzonex/bean/initbean/QZAlbumxInvitePageInitBean;)V", "invitePageInitBean", "Landroidx/lifecycle/MutableLiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "b2", "()Landroidx/lifecycle/MutableLiveData;", "setBabyRoleData", "(Landroidx/lifecycle/MutableLiveData;)V", "babyRoleData", BdhLogUtil.LogTag.Tag_Conn, SemanticAttributes.DbSystemValues.H2, "setLoginUserAlbumStatus", "loginUserAlbumStatus", "D", "c2", "setGetInfoRsp", "getInfoRsp", "<init>", "()V", "E", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class bf extends com.qzone.reborn.base.n {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public QZAlbumxInvitePageInitBean invitePageInitBean;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private MutableLiveData<Integer> babyRoleData = new MutableLiveData<>();

    /* renamed from: C, reason: from kotlin metadata */
    private MutableLiveData<Integer> loginUserAlbumStatus = new MutableLiveData<>();

    /* renamed from: D, reason: from kotlin metadata */
    private MutableLiveData<ab.a> getInfoRsp = new MutableLiveData<>();

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z1(final bf this$0, final PAGetAlbumJoinApprovalPageRsp pAGetAlbumJoinApprovalPageRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RFWLog.e("QZAlbumxInviteViewModel", RFWLog.USR, " getApplyInfo traceId is " + pAGetAlbumJoinApprovalPageRsp.traceId + " result: " + pAGetAlbumJoinApprovalPageRsp.result);
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: nc.bb
            @Override // java.lang.Runnable
            public final void run() {
                bf.a2(PAGetAlbumJoinApprovalPageRsp.this, this$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a2(PAGetAlbumJoinApprovalPageRsp pAGetAlbumJoinApprovalPageRsp, bf this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (pAGetAlbumJoinApprovalPageRsp.result == 0) {
            StUser stUser = pAGetAlbumJoinApprovalPageRsp.pendingUser;
            Intrinsics.checkNotNullExpressionValue(stUser, "response.pendingUser");
            CommonStUser a16 = xh.i.a(stUser);
            AlbumInfo albumInfo = pAGetAlbumJoinApprovalPageRsp.album;
            Intrinsics.checkNotNullExpressionValue(albumInfo, "response.album");
            CommonAlbumInfo a17 = xh.a.a(albumInfo);
            int i3 = pAGetAlbumJoinApprovalPageRsp.loginUserStatus;
            int i16 = pAGetAlbumJoinApprovalPageRsp.approvalStatus;
            String str = pAGetAlbumJoinApprovalPageRsp.entranceAlbumId;
            Intrinsics.checkNotNullExpressionValue(str, "response.entranceAlbumId");
            StUser stUser2 = pAGetAlbumJoinApprovalPageRsp.entranceAlbumOwner;
            Intrinsics.checkNotNullExpressionValue(stUser2, "response.entranceAlbumOwner");
            this$0.i2(a16, a17, i3, i16, str, xh.i.a(stUser2));
            return;
        }
        this$0.u2(pAGetAlbumJoinApprovalPageRsp.errMs);
        RFWLog.e("QZAlbumxInviteViewModel", RFWLog.USR, "getApplyInfo error, error msg is " + pAGetAlbumJoinApprovalPageRsp.errMs + ", error traceId is " + pAGetAlbumJoinApprovalPageRsp.traceId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e2(final bf this$0, final PAGetAlbumInviteJoinPageRsp pAGetAlbumInviteJoinPageRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RFWLog.e("QZAlbumxInviteViewModel", RFWLog.USR, " getInviteInfo traceId is " + pAGetAlbumInviteJoinPageRsp.traceId + " result: " + pAGetAlbumInviteJoinPageRsp.result);
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: nc.bc
            @Override // java.lang.Runnable
            public final void run() {
                bf.f2(PAGetAlbumInviteJoinPageRsp.this, this$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f2(PAGetAlbumInviteJoinPageRsp pAGetAlbumInviteJoinPageRsp, bf this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (pAGetAlbumInviteJoinPageRsp.result == 0) {
            StUser stUser = pAGetAlbumInviteJoinPageRsp.invitee;
            Intrinsics.checkNotNullExpressionValue(stUser, "response.invitee");
            CommonStUser a16 = xh.i.a(stUser);
            AlbumInfo albumInfo = pAGetAlbumInviteJoinPageRsp.album;
            Intrinsics.checkNotNullExpressionValue(albumInfo, "response.album");
            CommonAlbumInfo a17 = xh.a.a(albumInfo);
            int i3 = pAGetAlbumInviteJoinPageRsp.loginUserStatus;
            int i16 = pAGetAlbumInviteJoinPageRsp.inviteStatus;
            String str = pAGetAlbumInviteJoinPageRsp.entranceAlbumId;
            Intrinsics.checkNotNullExpressionValue(str, "response.entranceAlbumId");
            StUser stUser2 = pAGetAlbumInviteJoinPageRsp.entranceAlbumOwner;
            Intrinsics.checkNotNullExpressionValue(stUser2, "response.entranceAlbumOwner");
            this$0.j2(a16, a17, i3, i16, str, xh.i.a(stUser2));
            return;
        }
        this$0.u2(pAGetAlbumInviteJoinPageRsp.errMs);
        RFWLog.e("QZAlbumxInviteViewModel", RFWLog.USR, "getInviteInfo error, error msg is " + pAGetAlbumInviteJoinPageRsp.errMs + ", error traceId is " + pAGetAlbumInviteJoinPageRsp.traceId);
    }

    private final void i2(CommonStUser pendingUser, CommonAlbumInfo albumInfo, int loginUserStatus, int approvalStatus, String entranceAlbumId, CommonStUser entranceAlbumOwner) {
        int i3;
        ab.a aVar = new ab.a();
        aVar.n(pendingUser);
        aVar.h(albumInfo);
        aVar.i(approvalStatus);
        if (loginUserStatus == JoinPageLoginUserAlbumStatus.KUSERJOINALBUMSTATUSPENDINGNOJOINREQUEST.ordinal()) {
            i3 = 1;
        } else if (loginUserStatus == JoinPageLoginUserAlbumStatus.KUSERJOINALBUMSTATUSPENDINGAPPROVAL.ordinal()) {
            i3 = 2;
        } else {
            i3 = loginUserStatus == JoinPageLoginUserAlbumStatus.KUSERJOINALBUMSTATUSHASPERMISSION.ordinal() ? 3 : 0;
        }
        aVar.m(i3);
        aVar.j(entranceAlbumId);
        aVar.k(entranceAlbumOwner);
        t2(aVar);
    }

    private final void j2(CommonStUser invitee, CommonAlbumInfo albumInfo, int loginUserStatus, int inviteStatus, String entranceAlbumId, CommonStUser entranceAlbumOwner) {
        int i3;
        ab.a aVar = new ab.a();
        aVar.n(invitee);
        aVar.h(albumInfo);
        aVar.l(inviteStatus);
        if (loginUserStatus == JoinPageLoginUserAlbumStatus.KUSERJOINALBUMSTATUSPENDINGNOJOINREQUEST.ordinal()) {
            i3 = 1;
        } else if (loginUserStatus == JoinPageLoginUserAlbumStatus.KUSERJOINALBUMSTATUSPENDINGAPPROVAL.ordinal()) {
            i3 = 2;
        } else {
            i3 = loginUserStatus == JoinPageLoginUserAlbumStatus.KUSERJOINALBUMSTATUSHASPERMISSION.ordinal() ? 3 : 0;
        }
        aVar.m(i3);
        aVar.j(entranceAlbumId);
        aVar.k(entranceAlbumOwner);
        t2(aVar);
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [T, java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v8, types: [T, java.lang.Object, java.lang.String] */
    private final void k2(List<CommonClientAttr> clientAttrs) {
        CommonClientAttr commonClientAttr;
        CommonUinAttr attr;
        CommonUinAttr attr2;
        Iterator<CommonClientAttr> it = clientAttrs.iterator();
        while (true) {
            if (!it.hasNext()) {
                commonClientAttr = null;
                break;
            } else {
                commonClientAttr = it.next();
                if (Intrinsics.areEqual(LoginData.getInstance().getUinString(), commonClientAttr.getCooperation.qqcircle.report.QCircleAlphaUserReporter.KEY_USER java.lang.String().getUin())) {
                    break;
                }
            }
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = "";
        MutableLiveData<Integer> mutableLiveData = this.loginUserAlbumStatus;
        int i3 = 2;
        if (!((commonClientAttr == null || (attr2 = commonClientAttr.getAttr()) == null || attr2.getStatus() != 2) ? false : true)) {
            if (!((commonClientAttr == null || (attr = commonClientAttr.getAttr()) == null || attr.getStatus() != 3) ? false : true)) {
                ?? qqStr = HardCodeUtil.qqStr(R.string.f134017o);
                Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.qzone_alb\u2026bum_detail_apply_success)");
                objectRef.element = qqStr;
                mutableLiveData.postValue(Integer.valueOf(i3));
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: nc.be
                    @Override // java.lang.Runnable
                    public final void run() {
                        bf.l2(Ref.ObjectRef.this);
                    }
                });
            }
        }
        ?? qqStr2 = HardCodeUtil.qqStr(R.string.jfa);
        Intrinsics.checkNotNullExpressionValue(qqStr2, "qqStr(R.string.qzone_alb\u2026um_toast_tips_join_album)");
        objectRef.element = qqStr2;
        i3 = 3;
        mutableLiveData.postValue(Integer.valueOf(i3));
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: nc.be
            @Override // java.lang.Runnable
            public final void run() {
                bf.l2(Ref.ObjectRef.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l2(Ref.ObjectRef toast) {
        Intrinsics.checkNotNullParameter(toast, "$toast");
        QQToast.makeText(BaseApplication.context, 5, (CharSequence) toast.element, 0).show();
    }

    private final void m2(boolean isPass) {
        this.loginUserAlbumStatus.postValue(Integer.valueOf(isPass ? 4 : 5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q2(final bf this$0, final PAJoinShareAlbumRsp pAJoinShareAlbumRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RFWLog.e("QZAlbumxInviteViewModel", RFWLog.USR, "joinShareAlbum, traceId: " + pAJoinShareAlbumRsp.traceId + ", result is " + pAJoinShareAlbumRsp.result + " errmsg: " + pAJoinShareAlbumRsp.errMs);
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: nc.bd
            @Override // java.lang.Runnable
            public final void run() {
                bf.r2(PAJoinShareAlbumRsp.this, this$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r2(PAJoinShareAlbumRsp pAJoinShareAlbumRsp, bf this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (pAJoinShareAlbumRsp.result == 0) {
            ArrayList arrayList = new ArrayList();
            ArrayList<ClientAttr> arrayList2 = pAJoinShareAlbumRsp.shareUsers;
            Intrinsics.checkNotNullExpressionValue(arrayList2, "response.shareUsers");
            for (ClientAttr it : arrayList2) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                arrayList.add(fb.a.e(it));
            }
            this$0.k2(arrayList);
            return;
        }
        this$0.u2(pAJoinShareAlbumRsp.errMs);
        RFWLog.e("QZAlbumxInviteViewModel", RFWLog.USR, "joinShareAlbum error, error msg is " + pAJoinShareAlbumRsp.errMs + ", error traceId is " + pAJoinShareAlbumRsp.traceId);
    }

    private final void t2(ab.a rsp) {
        QLog.i("QZAlbumxInviteViewModel", 2, "user: " + rsp.getCooperation.qqcircle.report.QCircleAlphaUserReporter.KEY_USER java.lang.String().getUin() + ", albumId: " + rsp.getAlbumInfo().getAlbumId() + ", approvalStatus: " + rsp.getApprovalStatus() + ", inviteStatus: " + rsp.getInviteStatus() + ", loginStatus: " + rsp.getLoginUserStatus() + "entranceAlbumId: " + rsp.getEntranceAlbumId() + "entranceAlbumOwner: " + rsp.getEntranceAlbumOwner().getUin());
        this.getInfoRsp.postValue(rsp);
    }

    private final void u2(final String errorMsg) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: nc.ax
            @Override // java.lang.Runnable
            public final void run() {
                bf.v2(errorMsg);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v2(String str) {
        QQToast.makeText(BaseApplication.context, 4, str, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y2(final bf this$0, final boolean z16, final PARespondToJoinRequestRsp pARespondToJoinRequestRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RFWLog.e("QZAlbumxInviteViewModel", RFWLog.USR, "respondToJoinRequest, traceId: " + pARespondToJoinRequestRsp.traceId + ", result is " + pARespondToJoinRequestRsp.result + " errmsg: " + pARespondToJoinRequestRsp.errMs);
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: nc.az
            @Override // java.lang.Runnable
            public final void run() {
                bf.z2(PARespondToJoinRequestRsp.this, this$0, z16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z2(PARespondToJoinRequestRsp pARespondToJoinRequestRsp, bf this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (pARespondToJoinRequestRsp.result == 0) {
            this$0.m2(z16);
            return;
        }
        this$0.u2(pARespondToJoinRequestRsp.errMs);
        RFWLog.e("QZAlbumxInviteViewModel", RFWLog.USR, "respondToJoinRequest error, error msg is " + pARespondToJoinRequestRsp.errMs + ", error traceId is " + pARespondToJoinRequestRsp.traceId);
    }

    public final void A2(QZAlbumxInvitePageInitBean qZAlbumxInvitePageInitBean) {
        Intrinsics.checkNotNullParameter(qZAlbumxInvitePageInitBean, "<set-?>");
        this.invitePageInitBean = qZAlbumxInvitePageInitBean;
    }

    public final void B2(int roleId) {
        this.babyRoleData.postValue(Integer.valueOf(roleId));
    }

    public final void X1() {
        if (!NetworkUtil.isNetworkAvailable()) {
            u2("\u65e0\u7f51\u7edc");
            return;
        }
        PAGetAlbumJoinApprovalPageReq pAGetAlbumJoinApprovalPageReq = new PAGetAlbumJoinApprovalPageReq();
        pAGetAlbumJoinApprovalPageReq.albumId = g2().getAlbumId();
        CommonStUser commonStUser = new CommonStUser();
        commonStUser.g(g2().getAlbumOwner());
        pAGetAlbumJoinApprovalPageReq.albumOwner = xh.i.b(commonStUser);
        pAGetAlbumJoinApprovalPageReq.joinAttachInfo = g2().getJoinAttachInfo();
        pAGetAlbumJoinApprovalPageReq.requestTimeLine.requestInvokeTime = System.currentTimeMillis();
        com.tencent.qqnt.kernel.api.z b16 = com.qzone.reborn.albumx.qzonex.utils.i.b();
        if (b16 != null) {
            b16.getAlbumJoinApprovalPage(pAGetAlbumJoinApprovalPageReq, new IPersonalAlbumServiceGetAlbumJoinApprovalPageCallback() { // from class: nc.aw
                @Override // com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceGetAlbumJoinApprovalPageCallback
                public final void onGetAlbumJoinApprovalPage(PAGetAlbumJoinApprovalPageRsp pAGetAlbumJoinApprovalPageRsp) {
                    bf.Z1(bf.this, pAGetAlbumJoinApprovalPageRsp);
                }
            });
        }
    }

    public final MutableLiveData<Integer> b2() {
        return this.babyRoleData;
    }

    public final MutableLiveData<ab.a> c2() {
        return this.getInfoRsp;
    }

    public final void d2() {
        if (!NetworkUtil.isNetworkAvailable()) {
            u2("\u65e0\u7f51\u7edc");
            return;
        }
        PAGetAlbumInviteJoinPageReq pAGetAlbumInviteJoinPageReq = new PAGetAlbumInviteJoinPageReq();
        pAGetAlbumInviteJoinPageReq.albumId = g2().getAlbumId();
        CommonStUser commonStUser = new CommonStUser();
        commonStUser.g(g2().getAlbumOwner());
        pAGetAlbumInviteJoinPageReq.albumOwner = xh.i.b(commonStUser);
        pAGetAlbumInviteJoinPageReq.inviteAttachInfo = g2().getInviteAttachInfo();
        pAGetAlbumInviteJoinPageReq.requestTimeLine.requestInvokeTime = System.currentTimeMillis();
        com.tencent.qqnt.kernel.api.z b16 = com.qzone.reborn.albumx.qzonex.utils.i.b();
        if (b16 != null) {
            b16.getAlbumInviteJoinPage(pAGetAlbumInviteJoinPageReq, new IPersonalAlbumServiceGetAlbumInviteJoinPageCallback() { // from class: nc.ay
                @Override // com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceGetAlbumInviteJoinPageCallback
                public final void onGetAlbumInviteJoinPage(PAGetAlbumInviteJoinPageRsp pAGetAlbumInviteJoinPageRsp) {
                    bf.e2(bf.this, pAGetAlbumInviteJoinPageRsp);
                }
            });
        }
    }

    public final QZAlbumxInvitePageInitBean g2() {
        QZAlbumxInvitePageInitBean qZAlbumxInvitePageInitBean = this.invitePageInitBean;
        if (qZAlbumxInvitePageInitBean != null) {
            return qZAlbumxInvitePageInitBean;
        }
        Intrinsics.throwUninitializedPropertyAccessException("invitePageInitBean");
        return null;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZAlbumxInviteViewModel";
    }

    public final MutableLiveData<Integer> h2() {
        return this.loginUserAlbumStatus;
    }

    public final boolean n2() {
        CommonAlbumInfo albumInfo;
        ab.a value = this.getInfoRsp.getValue();
        if (value == null || (albumInfo = value.getAlbumInfo()) == null) {
            return false;
        }
        return com.qzone.reborn.albumx.qzonex.utils.c.f53402a.f(albumInfo);
    }

    public final boolean o2() {
        CommonStUser commonStUser;
        ab.a value = this.getInfoRsp.getValue();
        if (value == null || (commonStUser = value.getCooperation.qqcircle.report.QCircleAlphaUserReporter.KEY_USER java.lang.String()) == null) {
            return false;
        }
        return Intrinsics.areEqual(commonStUser.getUin(), LoginData.getInstance().getUinString());
    }

    public final void p2(int role) {
        if (!NetworkUtil.isNetworkAvailable()) {
            u2("\u65e0\u7f51\u7edc");
            return;
        }
        ab.a value = this.getInfoRsp.getValue();
        CommonAlbumInfo albumInfo = value != null ? value.getAlbumInfo() : null;
        if (albumInfo == null) {
            QLog.e("QZAlbumxInviteViewModel", 1, "albumInfo null");
            return;
        }
        PAJoinShareAlbumReq pAJoinShareAlbumReq = new PAJoinShareAlbumReq();
        pAJoinShareAlbumReq.albumId = albumInfo.getAlbumId();
        pAJoinShareAlbumReq.familyRole = role;
        pAJoinShareAlbumReq.albumOwner = xh.i.b(albumInfo.getCreator());
        pAJoinShareAlbumReq.requestTimeLine.requestInvokeTime = System.currentTimeMillis();
        com.tencent.qqnt.kernel.api.z b16 = com.qzone.reborn.albumx.qzonex.utils.i.b();
        if (b16 != null) {
            b16.joinShareAlbum(pAJoinShareAlbumReq, new IPersonalAlbumServiceJoinShareAlbumCallback() { // from class: nc.ba
                @Override // com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceJoinShareAlbumCallback
                public final void onJoinShareAlbum(PAJoinShareAlbumRsp pAJoinShareAlbumRsp) {
                    bf.q2(bf.this, pAJoinShareAlbumRsp);
                }
            });
        }
    }

    public final void s2(Context context) {
        String albumOwner;
        String str;
        CommonAlbumInfo albumInfo;
        CommonAlbumInfo albumInfo2;
        CommonAlbumInfo albumInfo3;
        String name;
        CommonStUser entranceAlbumOwner;
        Intrinsics.checkNotNullParameter(context, "context");
        ab.a value = this.getInfoRsp.getValue();
        if (value == null || (entranceAlbumOwner = value.getEntranceAlbumOwner()) == null || (albumOwner = entranceAlbumOwner.getUin()) == null) {
            albumOwner = g2().getAlbumOwner();
        }
        QZAlbumxAlbumDetailInitBean qZAlbumxAlbumDetailInitBean = new QZAlbumxAlbumDetailInitBean(albumOwner);
        ab.a value2 = this.getInfoRsp.getValue();
        String str2 = "";
        if (value2 == null || (str = value2.getEntranceAlbumId()) == null) {
            ab.a value3 = this.getInfoRsp.getValue();
            if (value3 == null || (albumInfo = value3.getAlbumInfo()) == null) {
                str = "";
            } else {
                str = albumInfo.getAlbumId();
            }
        }
        qZAlbumxAlbumDetailInitBean.setAlbumId(str);
        ab.a value4 = this.getInfoRsp.getValue();
        if (value4 != null && (albumInfo3 = value4.getAlbumInfo()) != null && (name = albumInfo3.getName()) != null) {
            str2 = name;
        }
        qZAlbumxAlbumDetailInitBean.setAlbumName(str2);
        ab.a value5 = this.getInfoRsp.getValue();
        qZAlbumxAlbumDetailInitBean.setSortType((value5 == null || (albumInfo2 = value5.getAlbumInfo()) == null) ? null : Integer.valueOf(albumInfo2.getSortType()));
        ho.i.x().g(context, qZAlbumxAlbumDetailInitBean);
    }

    public final void x2(final boolean isPass) {
        AuditAction auditAction;
        if (!NetworkUtil.isNetworkAvailable()) {
            u2("\u65e0\u7f51\u7edc");
            return;
        }
        ab.a value = this.getInfoRsp.getValue();
        CommonAlbumInfo albumInfo = value != null ? value.getAlbumInfo() : null;
        ab.a value2 = this.getInfoRsp.getValue();
        CommonStUser commonStUser = value2 != null ? value2.getCooperation.qqcircle.report.QCircleAlphaUserReporter.KEY_USER java.lang.String() : null;
        if (albumInfo != null && commonStUser != null) {
            PARespondToJoinRequestReq pARespondToJoinRequestReq = new PARespondToJoinRequestReq();
            pARespondToJoinRequestReq.albumId = albumInfo.getAlbumId();
            pARespondToJoinRequestReq.albumOwner = xh.i.b(albumInfo.getCreator());
            pARespondToJoinRequestReq.pendingUsers.add(xh.i.b(commonStUser));
            pARespondToJoinRequestReq.joinSource = JoinSource.KJOINSOURCEMIDDLEPAGE.ordinal();
            if (!isPass) {
                auditAction = AuditAction.KAUDITACTIONREJECT;
            } else {
                auditAction = AuditAction.KAUDITACTIONAPPROVE;
            }
            pARespondToJoinRequestReq.action = auditAction.ordinal();
            pARespondToJoinRequestReq.requestTimeLine.requestInvokeTime = System.currentTimeMillis();
            com.tencent.qqnt.kernel.api.z b16 = com.qzone.reborn.albumx.qzonex.utils.i.b();
            if (b16 != null) {
                b16.respondToJoinRequest(pARespondToJoinRequestReq, new IPersonalAlbumServiceRespondToJoinRequestCallback() { // from class: nc.av
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceRespondToJoinRequestCallback
                    public final void onRespondToJoinRequest(PARespondToJoinRequestRsp pARespondToJoinRequestRsp) {
                        bf.y2(bf.this, isPass, pARespondToJoinRequestRsp);
                    }
                });
                return;
            }
            return;
        }
        QLog.e("QZAlbumxInviteViewModel", 1, "albumInfo or user null");
    }

    public final void w2(Intent intent) {
        Bundle extras;
        if (intent == null || (extras = intent.getExtras()) == null || !extras.containsKey("key_bundle_common_init_bean")) {
            return;
        }
        Serializable serializable = extras.getSerializable("key_bundle_common_init_bean");
        Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type com.qzone.reborn.albumx.qzonex.bean.initbean.QZAlbumxInvitePageInitBean");
        A2((QZAlbumxInvitePageInitBean) serializable);
    }
}
