package nc;

import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonStUser;
import com.qzone.reborn.albumx.qzonex.bean.initbean.QZAlbumxAnswerCheckPageInitBean;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqnt.kernel.nativeinterface.AlbumInfo;
import com.tencent.qqnt.kernel.nativeinterface.AlbumQuestion;
import com.tencent.qqnt.kernel.nativeinterface.AlbumReqType;
import com.tencent.qqnt.kernel.nativeinterface.AnswerStatus;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceQueryAlbumCallback;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceVerifyAlbumQuestionCallback;
import com.tencent.qqnt.kernel.nativeinterface.PAQueryAlbumReq;
import com.tencent.qqnt.kernel.nativeinterface.PAQueryAlbumRsp;
import com.tencent.qqnt.kernel.nativeinterface.PAVerifyAlbumQuestionReq;
import com.tencent.qqnt.kernel.nativeinterface.PAVerifyAlbumQuestionRsp;
import com.tencent.richframework.thread.RFWThreadManager;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0014\b\u0016\u0018\u0000 02\u00020\u0001:\u00011B\u0007\u00a2\u0006\u0004\b.\u0010/J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J \u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ\u0016\u0010\u0013\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0002J\u0006\u0010\u0014\u001a\u00020\u0004R$\u0010\u001c\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR(\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R(\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00020\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010 \u001a\u0004\b'\u0010\"\"\u0004\b(\u0010$R(\u0010-\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010 \u001a\u0004\b+\u0010\"\"\u0004\b,\u0010$\u00a8\u00062"}, d2 = {"Lnc/g;", "Lcom/qzone/reborn/base/n;", "", "errorMsg", "", "b2", "", "verifySuccess", "details", "answer", "Z1", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "albumInfo", "X1", "getLogTag", "Landroid/content/Intent;", "intent", "d2", "question", SemanticAttributes.DbSystemValues.H2, "e2", "Lcom/qzone/reborn/albumx/qzonex/bean/initbean/QZAlbumxAnswerCheckPageInitBean;", "i", "Lcom/qzone/reborn/albumx/qzonex/bean/initbean/QZAlbumxAnswerCheckPageInitBean;", "S1", "()Lcom/qzone/reborn/albumx/qzonex/bean/initbean/QZAlbumxAnswerCheckPageInitBean;", "setAnswerPageInitBean", "(Lcom/qzone/reborn/albumx/qzonex/bean/initbean/QZAlbumxAnswerCheckPageInitBean;)V", "answerPageInitBean", "Landroidx/lifecycle/MutableLiveData;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "T1", "()Landroidx/lifecycle/MutableLiveData;", "setCommitState", "(Landroidx/lifecycle/MutableLiveData;)V", "commitState", BdhLogUtil.LogTag.Tag_Conn, "U1", "setQuestionDate", "questionDate", "D", "W1", "setVerifyDate", "verifyDate", "<init>", "()V", "E", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public class g extends com.qzone.reborn.base.n {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QZAlbumxAnswerCheckPageInitBean answerPageInitBean;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private MutableLiveData<Integer> commitState = new MutableLiveData<>();

    /* renamed from: C, reason: from kotlin metadata */
    private MutableLiveData<String> questionDate = new MutableLiveData<>();

    /* renamed from: D, reason: from kotlin metadata */
    private MutableLiveData<Integer> verifyDate = new MutableLiveData<>();

    private final void X1(CommonAlbumInfo albumInfo) {
        this.questionDate.postValue(albumInfo.getCooperation.qqcircle.report.datong.QCircleDaTongConstant.ElementParamValue.PERMISSION java.lang.String().getQuestion());
        if (albumInfo.getCooperation.qqcircle.report.datong.QCircleDaTongConstant.ElementParamValue.PERMISSION java.lang.String().getPermissionType() != 5) {
            com.qzone.reborn.albumx.qzonex.utils.e.f53405a.h(albumInfo.getAlbumId());
            this.verifyDate.postValue(2);
        }
    }

    private final void Z1(boolean verifySuccess, String details, String answer) {
        String str;
        int i3 = 1;
        RFWLog.e("QZAlbumxAlbumAnswerCheckViewModel", RFWLog.USR, " verify Album Question success\uff1a " + verifySuccess + ", details is " + details);
        if (!verifySuccess) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: nc.f
                @Override // java.lang.Runnable
                public final void run() {
                    g.a2();
                }
            });
        }
        MutableLiveData<Integer> mutableLiveData = this.verifyDate;
        if (verifySuccess) {
            com.qzone.reborn.albumx.qzonex.utils.e eVar = com.qzone.reborn.albumx.qzonex.utils.e.f53405a;
            QZAlbumxAnswerCheckPageInitBean qZAlbumxAnswerCheckPageInitBean = this.answerPageInitBean;
            if (qZAlbumxAnswerCheckPageInitBean == null || (str = qZAlbumxAnswerCheckPageInitBean.getAlbumId()) == null) {
                str = "";
            }
            eVar.f(str, answer);
        } else {
            i3 = 0;
        }
        mutableLiveData.postValue(Integer.valueOf(i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a2() {
        QQToast.makeText(BaseApplication.context, 4, com.qzone.util.l.a(R.string.f134308g), 0).show();
    }

    private final void b2(final String errorMsg) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: nc.e
            @Override // java.lang.Runnable
            public final void run() {
                g.c2(errorMsg);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c2(String str) {
        QQToast.makeText(BaseApplication.context, 4, str, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f2(final g this$0, final PAQueryAlbumRsp pAQueryAlbumRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RFWLog.e("QZAlbumxAlbumAnswerCheckViewModel", RFWLog.USR, " requestQuestion traceId is " + pAQueryAlbumRsp.traceId + " result: " + pAQueryAlbumRsp.result);
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: nc.d
            @Override // java.lang.Runnable
            public final void run() {
                g.g2(PAQueryAlbumRsp.this, this$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g2(PAQueryAlbumRsp pAQueryAlbumRsp, g this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (pAQueryAlbumRsp.result == 0) {
            AlbumInfo albumInfo = pAQueryAlbumRsp.album;
            Intrinsics.checkNotNullExpressionValue(albumInfo, "response.album");
            this$0.X1(xh.a.a(albumInfo));
            return;
        }
        RFWLog.e("QZAlbumxAlbumAnswerCheckViewModel", RFWLog.USR, "get request question error, error msg is " + pAQueryAlbumRsp.errMs + ", error traceId is " + pAQueryAlbumRsp.traceId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i2(final g this$0, final String answer, final PAVerifyAlbumQuestionRsp pAVerifyAlbumQuestionRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(answer, "$answer");
        RFWLog.e("QZAlbumxAlbumAnswerCheckViewModel", RFWLog.USR, " verify Album Question traceId is " + pAVerifyAlbumQuestionRsp.traceId + " result: " + pAVerifyAlbumQuestionRsp.result);
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: nc.c
            @Override // java.lang.Runnable
            public final void run() {
                g.j2(PAVerifyAlbumQuestionRsp.this, this$0, answer);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j2(PAVerifyAlbumQuestionRsp pAVerifyAlbumQuestionRsp, g this$0, String answer) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(answer, "$answer");
        if (pAVerifyAlbumQuestionRsp.result == 0) {
            boolean z16 = pAVerifyAlbumQuestionRsp.status == AnswerStatus.KANSWERSTATUSSUCC.ordinal();
            String str = pAVerifyAlbumQuestionRsp.details;
            Intrinsics.checkNotNullExpressionValue(str, "response.details");
            this$0.Z1(z16, str, answer);
            return;
        }
        this$0.b2("\u9a8c\u8bc1\u5931\u8d25");
        RFWLog.e("QZAlbumxAlbumAnswerCheckViewModel", RFWLog.USR, " verify Album Question error, error msg is " + pAVerifyAlbumQuestionRsp.errMs + ", error traceId is " + pAVerifyAlbumQuestionRsp.traceId);
    }

    /* renamed from: S1, reason: from getter */
    public final QZAlbumxAnswerCheckPageInitBean getAnswerPageInitBean() {
        return this.answerPageInitBean;
    }

    public final MutableLiveData<Integer> T1() {
        return this.commitState;
    }

    public final MutableLiveData<String> U1() {
        return this.questionDate;
    }

    public final MutableLiveData<Integer> W1() {
        return this.verifyDate;
    }

    public final void e2() {
        String str;
        String str2;
        String ownerUid;
        if (!NetworkUtil.isNetworkAvailable()) {
            b2("\u65e0\u7f51\u7edc");
            return;
        }
        PAQueryAlbumReq pAQueryAlbumReq = new PAQueryAlbumReq();
        QZAlbumxAnswerCheckPageInitBean qZAlbumxAnswerCheckPageInitBean = this.answerPageInitBean;
        String str3 = "";
        if (qZAlbumxAnswerCheckPageInitBean == null || (str = qZAlbumxAnswerCheckPageInitBean.getAlbumId()) == null) {
            str = "";
        }
        pAQueryAlbumReq.albumId = str;
        pAQueryAlbumReq.reqType = AlbumReqType.KALBUMREQTYPEPERMISSIONINFO.ordinal();
        CommonStUser commonStUser = new CommonStUser();
        QZAlbumxAnswerCheckPageInitBean qZAlbumxAnswerCheckPageInitBean2 = this.answerPageInitBean;
        if (qZAlbumxAnswerCheckPageInitBean2 == null || (str2 = qZAlbumxAnswerCheckPageInitBean2.getOwnerUin()) == null) {
            str2 = "";
        }
        commonStUser.g(str2);
        QZAlbumxAnswerCheckPageInitBean qZAlbumxAnswerCheckPageInitBean3 = this.answerPageInitBean;
        if (qZAlbumxAnswerCheckPageInitBean3 != null && (ownerUid = qZAlbumxAnswerCheckPageInitBean3.getOwnerUid()) != null) {
            str3 = ownerUid;
        }
        commonStUser.f(str3);
        pAQueryAlbumReq.owner = xh.i.b(commonStUser);
        pAQueryAlbumReq.requestTimeLine.requestInvokeTime = System.currentTimeMillis();
        com.tencent.qqnt.kernel.api.z b16 = com.qzone.reborn.albumx.qzonex.utils.i.b();
        if (b16 != null) {
            b16.queryAlbum(pAQueryAlbumReq, new IPersonalAlbumServiceQueryAlbumCallback() { // from class: nc.b
                @Override // com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceQueryAlbumCallback
                public final void onQueryAlbum(PAQueryAlbumRsp pAQueryAlbumRsp) {
                    g.f2(g.this, pAQueryAlbumRsp);
                }
            });
        }
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZAlbumxAlbumAnswerCheckViewModel";
    }

    public final void h2(final String answer, String question) {
        String str;
        String str2;
        String ownerUid;
        Intrinsics.checkNotNullParameter(answer, "answer");
        Intrinsics.checkNotNullParameter(question, "question");
        if (!NetworkUtil.isNetworkAvailable()) {
            b2("\u65e0\u7f51\u7edc");
            return;
        }
        if (answer.length() == 0) {
            b2("\u8bf7\u8f93\u5165\u7b54\u6848");
            return;
        }
        PAVerifyAlbumQuestionReq pAVerifyAlbumQuestionReq = new PAVerifyAlbumQuestionReq();
        QZAlbumxAnswerCheckPageInitBean qZAlbumxAnswerCheckPageInitBean = this.answerPageInitBean;
        String str3 = "";
        if (qZAlbumxAnswerCheckPageInitBean == null || (str = qZAlbumxAnswerCheckPageInitBean.getAlbumId()) == null) {
            str = "";
        }
        pAVerifyAlbumQuestionReq.albumId = str;
        AlbumQuestion albumQuestion = pAVerifyAlbumQuestionReq.questionAnswer;
        albumQuestion.answer = answer;
        albumQuestion.questionId = 0;
        albumQuestion.questionText = question;
        CommonStUser commonStUser = new CommonStUser();
        QZAlbumxAnswerCheckPageInitBean qZAlbumxAnswerCheckPageInitBean2 = this.answerPageInitBean;
        if (qZAlbumxAnswerCheckPageInitBean2 == null || (str2 = qZAlbumxAnswerCheckPageInitBean2.getOwnerUin()) == null) {
            str2 = "";
        }
        commonStUser.g(str2);
        QZAlbumxAnswerCheckPageInitBean qZAlbumxAnswerCheckPageInitBean3 = this.answerPageInitBean;
        if (qZAlbumxAnswerCheckPageInitBean3 != null && (ownerUid = qZAlbumxAnswerCheckPageInitBean3.getOwnerUid()) != null) {
            str3 = ownerUid;
        }
        commonStUser.f(str3);
        pAVerifyAlbumQuestionReq.albumOwner = xh.i.b(commonStUser);
        pAVerifyAlbumQuestionReq.requestTimeLine.requestInvokeTime = System.currentTimeMillis();
        com.tencent.qqnt.kernel.api.z b16 = com.qzone.reborn.albumx.qzonex.utils.i.b();
        if (b16 != null) {
            b16.verifyAlbumQuestion(pAVerifyAlbumQuestionReq, new IPersonalAlbumServiceVerifyAlbumQuestionCallback() { // from class: nc.a
                @Override // com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceVerifyAlbumQuestionCallback
                public final void onVerifyAlbumQuestion(PAVerifyAlbumQuestionRsp pAVerifyAlbumQuestionRsp) {
                    g.i2(g.this, answer, pAVerifyAlbumQuestionRsp);
                }
            });
        }
    }

    public final void d2(Intent intent) {
        Bundle extras;
        if (intent == null || (extras = intent.getExtras()) == null || !extras.containsKey("key_bundle_common_init_bean")) {
            return;
        }
        Serializable serializable = extras.getSerializable("key_bundle_common_init_bean");
        Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type com.qzone.reborn.albumx.qzonex.bean.initbean.QZAlbumxAnswerCheckPageInitBean");
        this.answerPageInitBean = (QZAlbumxAnswerCheckPageInitBean) serializable;
    }
}
