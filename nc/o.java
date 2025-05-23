package nc;

import com.qzone.common.account.LoginData;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonClientAttr;
import com.qzone.reborn.albumx.common.convert.bean.CommonStUser;
import com.qzone.reborn.albumx.common.convert.bean.CommonUinAttr;
import com.qzone.reborn.base.n;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.ClientAttr;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceJoinShareAlbumCallback;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceSendAlbumInvitationCallback;
import com.tencent.qqnt.kernel.nativeinterface.PAJoinShareAlbumReq;
import com.tencent.qqnt.kernel.nativeinterface.PAJoinShareAlbumRsp;
import com.tencent.qqnt.kernel.nativeinterface.PASendAlbumInvitationReq;
import com.tencent.qqnt.kernel.nativeinterface.PASendAlbumInvitationRsp;
import com.tencent.qqnt.kernel.nativeinterface.Toast;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u0016\u0018\u0000 #2\u00020\u0001:\u0001$B\u0007\u00a2\u0006\u0004\b!\u0010\"J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0002J\u0016\u0010\r\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\b\u0010\u0011\u001a\u00020\u0002H\u0016J\"\u0010\u0015\u001a\u00020\u00042\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\n2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\nJ\u001e\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00062\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017R$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u0006%"}, d2 = {"Lnc/o;", "Lcom/qzone/reborn/base/n;", "", "errorMsg", "", "d2", "", "code", "content", "X1", "", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonClientAttr;", "clientAttrs", "U1", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "albumInfo", "T1", "getLogTag", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStUser;", "users", "groups", "f2", "role", "Lcom/qzone/reborn/base/n$a;", "", "callback", ICustomDataEditor.STRING_ARRAY_PARAM_2, "i", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "getAlbumInfo", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "setAlbumInfo", "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;)V", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public class o extends com.qzone.reborn.base.n {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private CommonAlbumInfo albumInfo;

    private final void U1(List<CommonClientAttr> clientAttrs) {
        CommonClientAttr commonClientAttr;
        final String a16;
        CommonUinAttr attr;
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
        boolean z16 = false;
        if (commonClientAttr != null && (attr = commonClientAttr.getAttr()) != null && attr.getStatus() == 2) {
            z16 = true;
        }
        if (z16) {
            a16 = com.qzone.util.l.a(R.string.f133997m);
        } else {
            a16 = com.qzone.util.l.a(R.string.f134017o);
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: nc.n
            @Override // java.lang.Runnable
            public final void run() {
                o.W1(a16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W1(String str) {
        QQToast.makeText(BaseApplication.context, 5, str, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z1(String str) {
        QQToast.makeText(BaseApplication.context, 5, str, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b2(final o this$0, final n.a aVar, final PAJoinShareAlbumRsp pAJoinShareAlbumRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RFWLog.e("QZAlbumxAlbumDetailInviteViewModel", RFWLog.USR, "joinShareAlbum, traceId: " + pAJoinShareAlbumRsp.traceId + ", result is " + pAJoinShareAlbumRsp.result + " errmsg: " + pAJoinShareAlbumRsp.errMs);
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: nc.m
            @Override // java.lang.Runnable
            public final void run() {
                o.c2(PAJoinShareAlbumRsp.this, this$0, aVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c2(PAJoinShareAlbumRsp pAJoinShareAlbumRsp, o this$0, n.a aVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (pAJoinShareAlbumRsp.result == 0) {
            ArrayList arrayList = new ArrayList();
            ArrayList<ClientAttr> arrayList2 = pAJoinShareAlbumRsp.shareUsers;
            Intrinsics.checkNotNullExpressionValue(arrayList2, "response.shareUsers");
            for (ClientAttr it : arrayList2) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                arrayList.add(fb.a.e(it));
            }
            this$0.U1(arrayList);
            if (aVar != null) {
                Boolean bool = Boolean.TRUE;
                long j3 = pAJoinShareAlbumRsp.result;
                String str = pAJoinShareAlbumRsp.errMs;
                Intrinsics.checkNotNullExpressionValue(str, "response.errMs");
                aVar.onSuccess(bool, j3, str, true);
                return;
            }
            return;
        }
        this$0.d2(pAJoinShareAlbumRsp.errMs);
        RFWLog.e("QZAlbumxAlbumDetailInviteViewModel", RFWLog.USR, "joinShareAlbum error, error msg is " + pAJoinShareAlbumRsp.errMs + ", error traceId is " + pAJoinShareAlbumRsp.traceId);
        if (aVar != null) {
            aVar.onFailure(pAJoinShareAlbumRsp.result, pAJoinShareAlbumRsp.errMs);
        }
    }

    private final void d2(final String errorMsg) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: nc.j
            @Override // java.lang.Runnable
            public final void run() {
                o.e2(errorMsg);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e2(String str) {
        QQToast.makeText(BaseApplication.context, 4, str, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g2(final o this$0, final PASendAlbumInvitationRsp pASendAlbumInvitationRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RFWLog.e("QZAlbumxAlbumDetailInviteViewModel", RFWLog.USR, "sendAlbumInvite, traceId: " + pASendAlbumInvitationRsp.traceId + ", result is " + pASendAlbumInvitationRsp.result + " errmsg: " + pASendAlbumInvitationRsp.errMs);
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: nc.i
            @Override // java.lang.Runnable
            public final void run() {
                o.h2(PASendAlbumInvitationRsp.this, this$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h2(PASendAlbumInvitationRsp pASendAlbumInvitationRsp, o this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (pASendAlbumInvitationRsp.result == 0) {
            Toast toast = pASendAlbumInvitationRsp.toast;
            int i3 = toast.code;
            String str = toast.content;
            Intrinsics.checkNotNullExpressionValue(str, "response.toast.content");
            this$0.X1(i3, str);
            return;
        }
        this$0.d2(pASendAlbumInvitationRsp.errMs);
        RFWLog.e("QZAlbumxAlbumDetailInviteViewModel", RFWLog.USR, "sendAlbumInvite error, error msg is " + pASendAlbumInvitationRsp.errMs + ", error traceId is " + pASendAlbumInvitationRsp.traceId);
    }

    public final void T1(CommonAlbumInfo albumInfo) {
        this.albumInfo = albumInfo;
        int i3 = RFWLog.USR;
        Object[] objArr = new Object[1];
        objArr[0] = "[doInit] albumId:" + (albumInfo != null ? albumInfo.getAlbumId() : null);
        RFWLog.d("QZAlbumxAlbumDetailInviteViewModel", i3, objArr);
    }

    public final void a2(int role, final n.a<Boolean> callback) {
        String str;
        CommonStUser commonStUser;
        if (!NetworkUtil.isNetworkAvailable()) {
            d2("\u65e0\u7f51\u7edc");
            return;
        }
        if (this.albumInfo == null) {
            QLog.e("QZAlbumxAlbumDetailInviteViewModel", 1, "albumInfo null");
            return;
        }
        PAJoinShareAlbumReq pAJoinShareAlbumReq = new PAJoinShareAlbumReq();
        CommonAlbumInfo commonAlbumInfo = this.albumInfo;
        if (commonAlbumInfo == null || (str = commonAlbumInfo.getAlbumId()) == null) {
            str = "";
        }
        pAJoinShareAlbumReq.albumId = str;
        pAJoinShareAlbumReq.familyRole = role;
        CommonAlbumInfo commonAlbumInfo2 = this.albumInfo;
        if (commonAlbumInfo2 == null || (commonStUser = commonAlbumInfo2.getCreator()) == null) {
            commonStUser = new CommonStUser();
        }
        pAJoinShareAlbumReq.albumOwner = xh.i.b(commonStUser);
        pAJoinShareAlbumReq.requestTimeLine.requestInvokeTime = System.currentTimeMillis();
        com.tencent.qqnt.kernel.api.z b16 = com.qzone.reborn.albumx.qzonex.utils.i.b();
        if (b16 != null) {
            b16.joinShareAlbum(pAJoinShareAlbumReq, new IPersonalAlbumServiceJoinShareAlbumCallback() { // from class: nc.k
                @Override // com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceJoinShareAlbumCallback
                public final void onJoinShareAlbum(PAJoinShareAlbumRsp pAJoinShareAlbumRsp) {
                    o.b2(o.this, callback, pAJoinShareAlbumRsp);
                }
            });
        }
    }

    public final void f2(List<CommonStUser> users, List<String> groups) {
        String str;
        CommonStUser commonStUser;
        Intrinsics.checkNotNullParameter(users, "users");
        Intrinsics.checkNotNullParameter(groups, "groups");
        if (!NetworkUtil.isNetworkAvailable()) {
            d2("\u65e0\u7f51\u7edc");
            return;
        }
        if (this.albumInfo == null) {
            QLog.e("QZAlbumxAlbumDetailInviteViewModel", 1, "albumInfo null");
            return;
        }
        PASendAlbumInvitationReq pASendAlbumInvitationReq = new PASendAlbumInvitationReq();
        CommonAlbumInfo commonAlbumInfo = this.albumInfo;
        if (commonAlbumInfo == null || (str = commonAlbumInfo.getAlbumId()) == null) {
            str = "";
        }
        pASendAlbumInvitationReq.albumId = str;
        CommonAlbumInfo commonAlbumInfo2 = this.albumInfo;
        if (commonAlbumInfo2 == null || (commonStUser = commonAlbumInfo2.getCreator()) == null) {
            commonStUser = new CommonStUser();
        }
        pASendAlbumInvitationReq.albumOwner = xh.i.b(commonStUser);
        Iterator<T> it = users.iterator();
        while (it.hasNext()) {
            pASendAlbumInvitationReq.receivers.add(xh.i.b((CommonStUser) it.next()));
        }
        pASendAlbumInvitationReq.groupList.addAll(groups);
        pASendAlbumInvitationReq.requestTimeLine.requestInvokeTime = System.currentTimeMillis();
        com.tencent.qqnt.kernel.api.z b16 = com.qzone.reborn.albumx.qzonex.utils.i.b();
        if (b16 != null) {
            b16.sendAlbumInvitation(pASendAlbumInvitationReq, new IPersonalAlbumServiceSendAlbumInvitationCallback() { // from class: nc.h
                @Override // com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceSendAlbumInvitationCallback
                public final void onSendAlbumInvitation(PASendAlbumInvitationRsp pASendAlbumInvitationRsp) {
                    o.g2(o.this, pASendAlbumInvitationRsp);
                }
            });
        }
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZAlbumxAlbumDetailInviteViewModel";
    }

    private final void X1(int code, final String content) {
        if (content == null || content.length() == 0) {
            content = com.qzone.util.l.a(R.string.f134027p);
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: nc.l
            @Override // java.lang.Runnable
            public final void run() {
                o.Z1(content);
            }
        });
    }
}
