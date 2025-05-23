package nc;

import androidx.lifecycle.MutableLiveData;
import com.qzone.reborn.albumx.common.convert.bean.CommonStUser;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceSendAlbumInvitationCallback;
import com.tencent.qqnt.kernel.nativeinterface.PASendAlbumInvitationReq;
import com.tencent.qqnt.kernel.nativeinterface.PASendAlbumInvitationRsp;
import com.tencent.qqnt.kernel.nativeinterface.Toast;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.util.QQToastUtil;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0016\u0018\u0000 %2\u00020\u0001:\u0001&B\u0007\u00a2\u0006\u0004\b#\u0010$J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0016J\u0016\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002J\"\u0010\u0012\u001a\u00020\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u000eR\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\"\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001f\u00a8\u0006'"}, d2 = {"Lnc/ah;", "Lcom/qzone/reborn/base/n;", "", "errorMsg", "", "R1", "", "code", "content", "P1", "getLogTag", "albumId", "ownerUin", "Q1", "", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStUser;", "users", "groups", "S1", "Landroidx/lifecycle/MutableLiveData;", "", "i", "Landroidx/lifecycle/MutableLiveData;", "O1", "()Landroidx/lifecycle/MutableLiveData;", "inviteActionSheetState", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "getAlbumId", "()Ljava/lang/String;", "setAlbumId", "(Ljava/lang/String;)V", BdhLogUtil.LogTag.Tag_Conn, "getOwnerUin", "setOwnerUin", "<init>", "()V", "D", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public class ah extends com.qzone.reborn.base.n {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<Boolean> inviteActionSheetState = new MutableLiveData<>();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private String albumId = "";

    /* renamed from: C, reason: from kotlin metadata */
    private String ownerUin = "";

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T1(final ah this$0, final PASendAlbumInvitationRsp pASendAlbumInvitationRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: nc.ag
            @Override // java.lang.Runnable
            public final void run() {
                ah.U1(PASendAlbumInvitationRsp.this, this$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U1(PASendAlbumInvitationRsp pASendAlbumInvitationRsp, ah this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (pASendAlbumInvitationRsp.result == 0) {
            Toast toast = pASendAlbumInvitationRsp.toast;
            int i3 = toast.code;
            String str = toast.content;
            Intrinsics.checkNotNullExpressionValue(str, "response.toast.content");
            this$0.P1(i3, str);
            return;
        }
        this$0.R1(pASendAlbumInvitationRsp.errMs);
        RFWLog.e("QZAlbumxAlbumDetailInviteViewModel", RFWLog.USR, "get all album list error, error msg is " + pASendAlbumInvitationRsp.errMs + ", error traceId is " + pASendAlbumInvitationRsp.traceId);
    }

    public final MutableLiveData<Boolean> O1() {
        return this.inviteActionSheetState;
    }

    public final void Q1(String albumId, String ownerUin) {
        Intrinsics.checkNotNullParameter(albumId, "albumId");
        Intrinsics.checkNotNullParameter(ownerUin, "ownerUin");
        this.albumId = albumId;
        this.ownerUin = ownerUin;
    }

    public final void S1(List<CommonStUser> users, List<String> groups) {
        Intrinsics.checkNotNullParameter(users, "users");
        Intrinsics.checkNotNullParameter(groups, "groups");
        if (!NetworkUtil.isNetworkAvailable()) {
            R1("\u65e0\u7f51\u7edc");
            return;
        }
        String str = this.albumId;
        if (!(str == null || str.length() == 0)) {
            String str2 = this.ownerUin;
            if (!(str2 == null || str2.length() == 0)) {
                PASendAlbumInvitationReq pASendAlbumInvitationReq = new PASendAlbumInvitationReq();
                pASendAlbumInvitationReq.albumId = this.albumId;
                CommonStUser commonStUser = new CommonStUser();
                commonStUser.g(this.ownerUin);
                pASendAlbumInvitationReq.albumOwner = xh.i.b(commonStUser);
                Iterator<T> it = users.iterator();
                while (it.hasNext()) {
                    pASendAlbumInvitationReq.receivers.add(xh.i.b((CommonStUser) it.next()));
                }
                pASendAlbumInvitationReq.groupList.addAll(groups);
                pASendAlbumInvitationReq.requestTimeLine.requestInvokeTime = System.currentTimeMillis();
                com.tencent.qqnt.kernel.api.z b16 = com.qzone.reborn.albumx.qzonex.utils.i.b();
                if (b16 != null) {
                    b16.sendAlbumInvitation(pASendAlbumInvitationReq, new IPersonalAlbumServiceSendAlbumInvitationCallback() { // from class: nc.af
                        @Override // com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceSendAlbumInvitationCallback
                        public final void onSendAlbumInvitation(PASendAlbumInvitationRsp pASendAlbumInvitationRsp) {
                            ah.T1(ah.this, pASendAlbumInvitationRsp);
                        }
                    });
                    return;
                }
                return;
            }
        }
        QLog.e("QZAlbumxAlbumDetailInviteViewModel", 1, "albumId or ownerUin null");
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZAlbumxAlbumDetailInviteViewModel";
    }

    private final void R1(String errorMsg) {
        QQToastUtil.showQQToastInUiThread(4, errorMsg);
    }

    private final void P1(int code, String content) {
        if (content == null || content.length() == 0) {
            content = com.qzone.util.l.a(R.string.f134027p);
        }
        QQToastUtil.showQQToastInUiThread(5, content);
    }
}
