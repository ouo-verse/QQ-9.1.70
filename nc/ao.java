package nc;

import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonClientAttr;
import com.qzone.reborn.albumx.common.convert.bean.CommonStUser;
import com.qzone.reborn.albumx.qzonex.bean.initbean.QZAlbumxAlbumMemberInitBean;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.AlbumInfo;
import com.tencent.qqnt.kernel.nativeinterface.ClientAttr;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceGetAlbumMemberListCallback;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceRemoveAlbumMemberCallback;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceUpdateAlbumMemberCallback;
import com.tencent.qqnt.kernel.nativeinterface.PAGetAlbumMemberListReq;
import com.tencent.qqnt.kernel.nativeinterface.PAGetAlbumMemberListRsp;
import com.tencent.qqnt.kernel.nativeinterface.PARemoveAlbumMemberReq;
import com.tencent.qqnt.kernel.nativeinterface.PARemoveAlbumMemberRsp;
import com.tencent.qqnt.kernel.nativeinterface.PAUpdateAlbumMemberReq;
import com.tencent.qqnt.kernel.nativeinterface.PAUpdateAlbumMemberRsp;
import com.tencent.qqnt.kernel.nativeinterface.UpdateMemberDesc;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0016\u0018\u0000 @2\u00020\u0001:\u0001AB\u0007\u00a2\u0006\u0004\b>\u0010?J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\tH\u0002J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\tH\u0002J\u000e\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014J\b\u0010\u0017\u001a\u00020\u0002H\u0016J\u0006\u0010\u0018\u001a\u00020\u0004J\u0006\u0010\u001a\u001a\u00020\u0019J\u000e\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0002J\u0006\u0010\u001d\u001a\u00020\u0019J\b\u0010\u001e\u001a\u00020\u0004H\u0016J\u000e\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\tJ\u000e\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\tR$\u0010)\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R#\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100+0*8\u0006\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\"\u0010=\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<\u00a8\u0006B"}, d2 = {"Lnc/ao;", "Lcom/qzone/reborn/base/n;", "", "errorMsg", "", "j2", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "albumInfo", "", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonClientAttr;", "sharers", "b2", "", "result", "changeUser", "d2", "Lya/a;", "albumMemberRsp", "i2", "c2", "Landroid/content/Intent;", "intent", "S1", "getLogTag", "W1", "", "f2", "checkUin", "g2", "e2", "L1", ICustomDataEditor.NUMBER_PARAM_2, "removeUser", "k2", "Lcom/qzone/reborn/albumx/qzonex/bean/initbean/QZAlbumxAlbumMemberInitBean;", "i", "Lcom/qzone/reborn/albumx/qzonex/bean/initbean/QZAlbumxAlbumMemberInitBean;", ICustomDataEditor.STRING_ARRAY_PARAM_2, "()Lcom/qzone/reborn/albumx/qzonex/bean/initbean/QZAlbumxAlbumMemberInitBean;", "setInitBean", "(Lcom/qzone/reborn/albumx/qzonex/bean/initbean/QZAlbumxAlbumMemberInitBean;)V", "initBean", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/richframework/data/base/UIStateData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "U1", "()Landroidx/lifecycle/MutableLiveData;", "albumMemberRspData", BdhLogUtil.LogTag.Tag_Conn, "Lya/a;", "T1", "()Lya/a;", "setAlbumMemberRsp", "(Lya/a;)V", "D", "Z", SemanticAttributes.DbSystemValues.H2, "()Z", "setRemoveMember", "(Z)V", "isRemoveMember", "<init>", "()V", "E", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public class ao extends com.qzone.reborn.base.n {

    /* renamed from: C, reason: from kotlin metadata */
    private ya.a albumMemberRsp;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean isRemoveMember;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QZAlbumxAlbumMemberInitBean initBean;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<UIStateData<ya.a>> albumMemberRspData = new MutableLiveData<>();

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X1(final ao this$0, final PAGetAlbumMemberListRsp pAGetAlbumMemberListRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RFWLog.d("QZAlbumxAlbumMemberViewModel", RFWLog.USR, "get album member list is " + pAGetAlbumMemberListRsp.traceId);
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: nc.aj
            @Override // java.lang.Runnable
            public final void run() {
                ao.Z1(PAGetAlbumMemberListRsp.this, this$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z1(PAGetAlbumMemberListRsp pAGetAlbumMemberListRsp, ao this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (pAGetAlbumMemberListRsp.result == 0) {
            ArrayList arrayList = new ArrayList();
            ArrayList<ClientAttr> arrayList2 = pAGetAlbumMemberListRsp.sharers;
            Intrinsics.checkNotNullExpressionValue(arrayList2, "response.sharers");
            for (ClientAttr it : arrayList2) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                arrayList.add(fb.a.e(it));
            }
            AlbumInfo albumInfo = pAGetAlbumMemberListRsp.album;
            Intrinsics.checkNotNullExpressionValue(albumInfo, "response.album");
            this$0.b2(xh.a.a(albumInfo), arrayList);
            return;
        }
        this$0.j2(pAGetAlbumMemberListRsp.errMs);
        RFWLog.e("QZAlbumxAlbumMemberViewModel", RFWLog.USR, "get all album list error, error msg is " + pAGetAlbumMemberListRsp.errMs + ", error traceId is " + pAGetAlbumMemberListRsp.traceId);
    }

    private final void b2(CommonAlbumInfo albumInfo, List<CommonClientAttr> sharers) {
        List<CommonClientAttr> a16;
        ya.a aVar = new ya.a();
        this.albumMemberRsp = aVar;
        aVar.b(albumInfo);
        ya.a aVar2 = this.albumMemberRsp;
        if (aVar2 != null && (a16 = aVar2.a()) != null) {
            a16.addAll(sharers);
        }
        ya.a aVar3 = this.albumMemberRsp;
        if (aVar3 != null) {
            aVar3.a();
        }
        ya.a aVar4 = this.albumMemberRsp;
        Intrinsics.checkNotNull(aVar4);
        i2(aVar4);
    }

    private final void i2(ya.a albumMemberRsp) {
        this.albumMemberRspData.postValue(UIStateData.obtainSuccess(false).setDataList(albumMemberRsp).setLatestModifyRecord(UIStateData.ModifyListRecord.obtainNotifyDataSetChanged()).setLoadMore(false).setFinish(true));
    }

    private final void j2(String errorMsg) {
        this.albumMemberRspData.postValue(UIStateData.obtainError(errorMsg).setRetCode(0L).setLoadMore(false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l2(final ao this$0, final CommonClientAttr removeUser, final PARemoveAlbumMemberRsp pARemoveAlbumMemberRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(removeUser, "$removeUser");
        RFWLog.d("QZAlbumxAlbumMemberViewModel", RFWLog.USR, "updateAlbumMember seq:" + pARemoveAlbumMemberRsp.traceId + " result:" + pARemoveAlbumMemberRsp.result + " errMs:" + pARemoveAlbumMemberRsp.errMs);
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: nc.am
            @Override // java.lang.Runnable
            public final void run() {
                ao.m2(ao.this, pARemoveAlbumMemberRsp, removeUser);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m2(ao this$0, PARemoveAlbumMemberRsp pARemoveAlbumMemberRsp, CommonClientAttr removeUser) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(removeUser, "$removeUser");
        this$0.c2(pARemoveAlbumMemberRsp.result, removeUser);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o2(final ao this$0, final CommonClientAttr changeUser, final PAUpdateAlbumMemberRsp pAUpdateAlbumMemberRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(changeUser, "$changeUser");
        RFWLog.d("QZAlbumxAlbumMemberViewModel", RFWLog.USR, "updateAlbumMember traceId:" + pAUpdateAlbumMemberRsp.traceId + " seq:" + pAUpdateAlbumMemberRsp.seq + " result:" + pAUpdateAlbumMemberRsp.result + " errMs:" + pAUpdateAlbumMemberRsp.errMs);
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: nc.an
            @Override // java.lang.Runnable
            public final void run() {
                ao.p2(ao.this, pAUpdateAlbumMemberRsp, changeUser);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p2(ao this$0, PAUpdateAlbumMemberRsp pAUpdateAlbumMemberRsp, CommonClientAttr changeUser) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(changeUser, "$changeUser");
        this$0.d2(pAUpdateAlbumMemberRsp.result, changeUser);
    }

    public final void S1(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Bundle extras = intent.getExtras();
        if (extras != null && extras.containsKey("key_bundle_common_init_bean")) {
            Serializable serializable = extras.getSerializable("key_bundle_common_init_bean");
            if (serializable instanceof QZAlbumxAlbumMemberInitBean) {
                this.initBean = (QZAlbumxAlbumMemberInitBean) serializable;
            }
        }
        int i3 = RFWLog.USR;
        Object[] objArr = new Object[1];
        QZAlbumxAlbumMemberInitBean qZAlbumxAlbumMemberInitBean = this.initBean;
        objArr[0] = "[doInit] uin:" + (qZAlbumxAlbumMemberInitBean != null ? qZAlbumxAlbumMemberInitBean.getUin() : null);
        RFWLog.d("QZAlbumxAlbumMemberViewModel", i3, objArr);
    }

    /* renamed from: T1, reason: from getter */
    public final ya.a getAlbumMemberRsp() {
        return this.albumMemberRsp;
    }

    public final MutableLiveData<UIStateData<ya.a>> U1() {
        return this.albumMemberRspData;
    }

    public final void W1() {
        String str;
        String creatorUin;
        if (!NetworkUtil.isNetworkAvailable()) {
            j2("\u65e0\u7f51\u7edc");
            return;
        }
        QZAlbumxAlbumMemberInitBean qZAlbumxAlbumMemberInitBean = this.initBean;
        String albumId = qZAlbumxAlbumMemberInitBean != null ? qZAlbumxAlbumMemberInitBean.getAlbumId() : null;
        if (!(albumId == null || albumId.length() == 0)) {
            QZAlbumxAlbumMemberInitBean qZAlbumxAlbumMemberInitBean2 = this.initBean;
            String creatorUin2 = qZAlbumxAlbumMemberInitBean2 != null ? qZAlbumxAlbumMemberInitBean2.getCreatorUin() : null;
            if (!(creatorUin2 == null || creatorUin2.length() == 0)) {
                PAGetAlbumMemberListReq pAGetAlbumMemberListReq = new PAGetAlbumMemberListReq();
                QZAlbumxAlbumMemberInitBean qZAlbumxAlbumMemberInitBean3 = this.initBean;
                String str2 = "";
                if (qZAlbumxAlbumMemberInitBean3 == null || (str = qZAlbumxAlbumMemberInitBean3.getAlbumId()) == null) {
                    str = "";
                }
                pAGetAlbumMemberListReq.albumId = str;
                CommonStUser commonStUser = new CommonStUser();
                QZAlbumxAlbumMemberInitBean qZAlbumxAlbumMemberInitBean4 = this.initBean;
                if (qZAlbumxAlbumMemberInitBean4 != null && (creatorUin = qZAlbumxAlbumMemberInitBean4.getCreatorUin()) != null) {
                    str2 = creatorUin;
                }
                commonStUser.g(str2);
                pAGetAlbumMemberListReq.albumOwner = xh.i.b(commonStUser);
                pAGetAlbumMemberListReq.requestTimeLine.requestInvokeTime = System.currentTimeMillis();
                com.tencent.qqnt.kernel.api.z b16 = com.qzone.reborn.albumx.qzonex.utils.i.b();
                if (b16 != null) {
                    b16.getAlbumMemberList(pAGetAlbumMemberListReq, new IPersonalAlbumServiceGetAlbumMemberListCallback() { // from class: nc.ai
                        @Override // com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceGetAlbumMemberListCallback
                        public final void onGetAlbumMemberList(PAGetAlbumMemberListRsp pAGetAlbumMemberListRsp) {
                            ao.X1(ao.this, pAGetAlbumMemberListRsp);
                        }
                    });
                    return;
                }
                return;
            }
        }
        QLog.e(getTAG(), 1, "get all Album member error, albumId or ownerUin is empty");
    }

    /* renamed from: a2, reason: from getter */
    public final QZAlbumxAlbumMemberInitBean getInitBean() {
        return this.initBean;
    }

    public final boolean e2() {
        QZAlbumxAlbumMemberInitBean qZAlbumxAlbumMemberInitBean = this.initBean;
        return qZAlbumxAlbumMemberInitBean != null && qZAlbumxAlbumMemberInitBean.getPageType() == 2;
    }

    public final boolean f2() {
        String shareAlbumOwnerUin;
        QZAlbumxAlbumMemberInitBean qZAlbumxAlbumMemberInitBean = this.initBean;
        if (qZAlbumxAlbumMemberInitBean == null || (shareAlbumOwnerUin = qZAlbumxAlbumMemberInitBean.getShareAlbumOwnerUin()) == null) {
            return false;
        }
        if (shareAlbumOwnerUin.length() == 0) {
            return false;
        }
        return Intrinsics.areEqual(shareAlbumOwnerUin, String.valueOf(LoginData.getInstance().getUin()));
    }

    public final boolean g2(String checkUin) {
        String shareAlbumOwnerUin;
        Intrinsics.checkNotNullParameter(checkUin, "checkUin");
        QZAlbumxAlbumMemberInitBean qZAlbumxAlbumMemberInitBean = this.initBean;
        if (qZAlbumxAlbumMemberInitBean == null || (shareAlbumOwnerUin = qZAlbumxAlbumMemberInitBean.getShareAlbumOwnerUin()) == null) {
            return false;
        }
        return Intrinsics.areEqual(shareAlbumOwnerUin, checkUin);
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZAlbumxAlbumMemberViewModel";
    }

    /* renamed from: h2, reason: from getter */
    public final boolean getIsRemoveMember() {
        return this.isRemoveMember;
    }

    public final void k2(final CommonClientAttr removeUser) {
        Intrinsics.checkNotNullParameter(removeUser, "removeUser");
        if (this.initBean == null) {
            RFWLog.e("QZAlbumxAlbumMemberViewModel", RFWLog.USR, "updateAlbumMember initBean is null");
            return;
        }
        PARemoveAlbumMemberReq pARemoveAlbumMemberReq = new PARemoveAlbumMemberReq();
        pARemoveAlbumMemberReq.requestTimeLine.requestInvokeTime = System.currentTimeMillis();
        QZAlbumxAlbumMemberInitBean qZAlbumxAlbumMemberInitBean = this.initBean;
        Intrinsics.checkNotNull(qZAlbumxAlbumMemberInitBean);
        pARemoveAlbumMemberReq.albumId = qZAlbumxAlbumMemberInitBean.getAlbumId();
        pARemoveAlbumMemberReq.removeUser = fb.a.C(removeUser);
        com.tencent.qqnt.kernel.api.z b16 = com.qzone.reborn.albumx.qzonex.utils.i.b();
        if (b16 != null) {
            b16.removeAlbumMember(pARemoveAlbumMemberReq, new IPersonalAlbumServiceRemoveAlbumMemberCallback() { // from class: nc.ak
                @Override // com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceRemoveAlbumMemberCallback
                public final void onRemoveAlbumMember(PARemoveAlbumMemberRsp pARemoveAlbumMemberRsp) {
                    ao.l2(ao.this, removeUser, pARemoveAlbumMemberRsp);
                }
            });
        }
    }

    public final void n2(final CommonClientAttr changeUser) {
        Intrinsics.checkNotNullParameter(changeUser, "changeUser");
        if (this.initBean == null) {
            RFWLog.e("QZAlbumxAlbumMemberViewModel", RFWLog.USR, "updateAlbumMember initBean is null");
            return;
        }
        PAUpdateAlbumMemberReq pAUpdateAlbumMemberReq = new PAUpdateAlbumMemberReq();
        pAUpdateAlbumMemberReq.updateDesc = UpdateMemberDesc.KUPDATEMEMBERCHANGEFAMILYROLE.ordinal();
        pAUpdateAlbumMemberReq.requestTimeLine.requestInvokeTime = System.currentTimeMillis();
        QZAlbumxAlbumMemberInitBean qZAlbumxAlbumMemberInitBean = this.initBean;
        Intrinsics.checkNotNull(qZAlbumxAlbumMemberInitBean);
        pAUpdateAlbumMemberReq.albumId = qZAlbumxAlbumMemberInitBean.getAlbumId();
        pAUpdateAlbumMemberReq.changeUser = fb.a.C(changeUser);
        CommonStUser commonStUser = new CommonStUser();
        QZAlbumxAlbumMemberInitBean qZAlbumxAlbumMemberInitBean2 = this.initBean;
        Intrinsics.checkNotNull(qZAlbumxAlbumMemberInitBean2);
        commonStUser.g(qZAlbumxAlbumMemberInitBean2.getCreatorUin());
        pAUpdateAlbumMemberReq.albumOwner = xh.i.b(commonStUser);
        com.tencent.qqnt.kernel.api.z b16 = com.qzone.reborn.albumx.qzonex.utils.i.b();
        if (b16 != null) {
            b16.updateAlbumMember(pAUpdateAlbumMemberReq, new IPersonalAlbumServiceUpdateAlbumMemberCallback() { // from class: nc.al
                @Override // com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceUpdateAlbumMemberCallback
                public final void onUpdateAlbumMember(PAUpdateAlbumMemberRsp pAUpdateAlbumMemberRsp) {
                    ao.o2(ao.this, changeUser, pAUpdateAlbumMemberRsp);
                }
            });
        }
    }

    @Override // com.qzone.reborn.base.n
    public void L1() {
        this.albumMemberRsp = null;
    }

    private final void c2(int result, CommonClientAttr changeUser) {
        ya.a aVar;
        if (result == 0 && (aVar = this.albumMemberRsp) != null) {
            Object obj = null;
            List<CommonClientAttr> a16 = aVar != null ? aVar.a() : null;
            if (a16 == null || a16.isEmpty()) {
                return;
            }
            ya.a aVar2 = this.albumMemberRsp;
            Intrinsics.checkNotNull(aVar2);
            Iterator<T> it = aVar2.a().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (Intrinsics.areEqual(changeUser.getCooperation.qqcircle.report.QCircleAlphaUserReporter.KEY_USER java.lang.String().getUin(), ((CommonClientAttr) next).getCooperation.qqcircle.report.QCircleAlphaUserReporter.KEY_USER java.lang.String().getUin())) {
                    obj = next;
                    break;
                }
            }
            ya.a aVar3 = this.albumMemberRsp;
            Intrinsics.checkNotNull(aVar3);
            TypeIntrinsics.asMutableCollection(aVar3.a()).remove((CommonClientAttr) obj);
            this.isRemoveMember = true;
            ya.a aVar4 = this.albumMemberRsp;
            Intrinsics.checkNotNull(aVar4);
            i2(aVar4);
        }
    }

    private final void d2(int result, CommonClientAttr changeUser) {
        ya.a aVar;
        if (result == 0 && (aVar = this.albumMemberRsp) != null) {
            List<CommonClientAttr> a16 = aVar != null ? aVar.a() : null;
            if (a16 == null || a16.isEmpty()) {
                return;
            }
            ya.a aVar2 = this.albumMemberRsp;
            Intrinsics.checkNotNull(aVar2);
            for (CommonClientAttr commonClientAttr : aVar2.a()) {
                if (Intrinsics.areEqual(changeUser.getCooperation.qqcircle.report.QCircleAlphaUserReporter.KEY_USER java.lang.String().getUin(), commonClientAttr.getCooperation.qqcircle.report.QCircleAlphaUserReporter.KEY_USER java.lang.String().getUin())) {
                    commonClientAttr.getAttr().n(changeUser.getAttr().getFamilyRole());
                }
            }
            ya.a aVar3 = this.albumMemberRsp;
            Intrinsics.checkNotNull(aVar3);
            i2(aVar3);
        }
    }
}
