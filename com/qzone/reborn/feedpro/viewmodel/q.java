package com.qzone.reborn.feedpro.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data.CommonRightQuestion;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.manager.QzoneMainPageFeedManager;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_reader.feeds_reader.Questions;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_writer.feeds_writer.ApplyVisitRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_writer.feeds_writer.DeleteVisitRsp;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.com.tencent.trpcprotocol.qzone.feeds_writer.feeds_writer.ValidateQARsp;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 B2\u00020\u0001:\u0004CDEFB\u0007\u00a2\u0006\u0004\b@\u0010AJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002J\u0016\u0010\f\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002J\b\u0010\r\u001a\u00020\u0006H\u0014R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR$\u0010\u0018\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R(\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010'\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010/\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u00107\u001a\u0004\u0018\u0001008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R$\u0010?\u001a\u0004\u0018\u0001088\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>\u00a8\u0006G"}, d2 = {"Lcom/qzone/reborn/feedpro/viewmodel/q;", "Lcom/qzone/reborn/base/n;", "", "getLogTag", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/manager/QzoneMainPageFeedManager;", "manager", "", "U1", "hostUin", "c2", "N1", "applyContent", "M1", "onCleared", "i", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/manager/QzoneMainPageFeedManager;", "userHomeManager", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/Questions;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/Questions;", "S1", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/Questions;", ICustomDataEditor.STRING_ARRAY_PARAM_2, "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_reader/feeds_reader/Questions;)V", "questions", "Landroidx/lifecycle/MutableLiveData;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/MutableLiveData;", "R1", "()Landroidx/lifecycle/MutableLiveData;", "setQuestionContent", "(Landroidx/lifecycle/MutableLiveData;)V", "questionContent", "D", "Ljava/lang/String;", "O1", "()Ljava/lang/String;", "W1", "(Ljava/lang/String;)V", "answerContent", "Lcom/qzone/reborn/feedpro/viewmodel/q$d;", "E", "Lcom/qzone/reborn/feedpro/viewmodel/q$d;", "T1", "()Lcom/qzone/reborn/feedpro/viewmodel/q$d;", "b2", "(Lcom/qzone/reborn/feedpro/viewmodel/q$d;)V", "validateQAListener", "Lcom/qzone/reborn/feedpro/viewmodel/q$c;", UserInfo.SEX_FEMALE, "Lcom/qzone/reborn/feedpro/viewmodel/q$c;", "Q1", "()Lcom/qzone/reborn/feedpro/viewmodel/q$c;", "Z1", "(Lcom/qzone/reborn/feedpro/viewmodel/q$c;)V", "deleteVisitListener", "Lcom/qzone/reborn/feedpro/viewmodel/q$b;", "G", "Lcom/qzone/reborn/feedpro/viewmodel/q$b;", "P1", "()Lcom/qzone/reborn/feedpro/viewmodel/q$b;", "X1", "(Lcom/qzone/reborn/feedpro/viewmodel/q$b;)V", "applyVisitListener", "<init>", "()V", "H", "a", "b", "c", "d", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class q extends com.qzone.reborn.base.n {

    /* renamed from: C, reason: from kotlin metadata */
    private MutableLiveData<String> questionContent = new MutableLiveData<>();

    /* renamed from: D, reason: from kotlin metadata */
    private String answerContent = "";

    /* renamed from: E, reason: from kotlin metadata */
    private d validateQAListener;

    /* renamed from: F, reason: from kotlin metadata */
    private c deleteVisitListener;

    /* renamed from: G, reason: from kotlin metadata */
    private b applyVisitListener;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private QzoneMainPageFeedManager userHomeManager;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private Questions questions;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/qzone/reborn/feedpro/viewmodel/q$b;", "", "", "isSuccess", "", "errMsg", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public interface b {
        void a(boolean isSuccess, String errMsg);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/qzone/reborn/feedpro/viewmodel/q$c;", "", "", "isSuccess", "", "errMsg", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public interface c {
        void a(boolean isSuccess, String errMsg);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/qzone/reborn/feedpro/viewmodel/q$d;", "", "", "isSuccess", "", "errMsg", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public interface d {
        void a(boolean isSuccess, String errMsg);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\u000e\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"com/qzone/reborn/feedpro/viewmodel/q$e", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_writer/feeds_writer/ApplyVisitRsp;", "t", "", "retCode", "", "msg", "", "isFinish", "", "a", "errorCode", "errorMsg", "onFailure", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class e implements DataCallback<ApplyVisitRsp> {
        e() {
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(ApplyVisitRsp t16, long retCode, String msg2, boolean isFinish) {
            Intrinsics.checkNotNullParameter(t16, "t");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            b applyVisitListener = q.this.getApplyVisitListener();
            if (applyVisitListener != null) {
                applyVisitListener.a(true, "");
            }
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        public void onFailure(long errorCode, String errorMsg) {
            QLog.e("QzoneUserHomeForbiddenViewModel", 1, "apply visit fail, error code is " + errorCode + ", error msg is " + errorMsg);
            b applyVisitListener = q.this.getApplyVisitListener();
            if (applyVisitListener != null) {
                if (errorMsg == null) {
                    errorMsg = "";
                }
                applyVisitListener.a(false, errorMsg);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J(\u0010\u000e\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u000f"}, d2 = {"com/qzone/reborn/feedpro/viewmodel/q$f", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_writer/feeds_writer/DeleteVisitRsp;", "", "errorCode", "", "errorMsg", "", "onFailure", "t", "retCode", "msg", "", "isFinish", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class f implements DataCallback<DeleteVisitRsp> {
        f() {
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(DeleteVisitRsp t16, long retCode, String msg2, boolean isFinish) {
            Intrinsics.checkNotNullParameter(t16, "t");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            c deleteVisitListener = q.this.getDeleteVisitListener();
            if (deleteVisitListener != null) {
                deleteVisitListener.a(true, "");
            }
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        public void onFailure(long errorCode, String errorMsg) {
            QLog.e("QzoneUserHomeForbiddenViewModel", 1, "delete visit fail, error code is " + errorCode + ", error msg is " + errorMsg);
            c deleteVisitListener = q.this.getDeleteVisitListener();
            if (deleteVisitListener != null) {
                if (errorMsg == null) {
                    errorMsg = "";
                }
                deleteVisitListener.a(false, errorMsg);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J(\u0010\u000e\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u000f"}, d2 = {"com/qzone/reborn/feedpro/viewmodel/q$g", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/network/DataCallback;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/com/tencent/trpcprotocol/qzone/feeds_writer/feeds_writer/ValidateQARsp;", "", "errorCode", "", "errorMsg", "", "onFailure", "t", "retCode", "msg", "", "isFinish", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class g implements DataCallback<ValidateQARsp> {
        g() {
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(ValidateQARsp t16, long retCode, String msg2, boolean isFinish) {
            Intrinsics.checkNotNullParameter(t16, "t");
            Intrinsics.checkNotNullParameter(msg2, "msg");
            d validateQAListener = q.this.getValidateQAListener();
            if (validateQAListener != null) {
                validateQAListener.a(true, "");
            }
        }

        @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
        public void onFailure(long errorCode, String errorMsg) {
            QLog.e("QzoneUserHomeForbiddenViewModel", 1, "validate QA fail, error code is " + errorCode + ", error msg is " + errorMsg);
            d validateQAListener = q.this.getValidateQAListener();
            if (validateQAListener != null) {
                if (errorMsg == null) {
                    errorMsg = "";
                }
                validateQAListener.a(false, errorMsg);
            }
        }
    }

    public final void M1(String hostUin, String applyContent) {
        Intrinsics.checkNotNullParameter(hostUin, "hostUin");
        Intrinsics.checkNotNullParameter(applyContent, "applyContent");
        QzoneMainPageFeedManager qzoneMainPageFeedManager = this.userHomeManager;
        if (qzoneMainPageFeedManager != null) {
            qzoneMainPageFeedManager.applyVisit(hostUin, applyContent, new e());
        }
    }

    public final void N1(String hostUin) {
        Intrinsics.checkNotNullParameter(hostUin, "hostUin");
        QzoneMainPageFeedManager qzoneMainPageFeedManager = this.userHomeManager;
        if (qzoneMainPageFeedManager != null) {
            qzoneMainPageFeedManager.deleteVisit(hostUin, 0L, 8, new f());
        }
    }

    /* renamed from: O1, reason: from getter */
    public final String getAnswerContent() {
        return this.answerContent;
    }

    /* renamed from: P1, reason: from getter */
    public final b getApplyVisitListener() {
        return this.applyVisitListener;
    }

    /* renamed from: Q1, reason: from getter */
    public final c getDeleteVisitListener() {
        return this.deleteVisitListener;
    }

    public final MutableLiveData<String> R1() {
        return this.questionContent;
    }

    /* renamed from: S1, reason: from getter */
    public final Questions getQuestions() {
        return this.questions;
    }

    /* renamed from: T1, reason: from getter */
    public final d getValidateQAListener() {
        return this.validateQAListener;
    }

    public final void U1(QzoneMainPageFeedManager manager) {
        if (this.userHomeManager == null) {
            this.userHomeManager = manager;
        }
    }

    public final void W1(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.answerContent = str;
    }

    public final void X1(b bVar) {
        this.applyVisitListener = bVar;
    }

    public final void Z1(c cVar) {
        this.deleteVisitListener = cVar;
    }

    public final void a2(Questions questions) {
        this.questions = questions;
    }

    public final void b2(d dVar) {
        this.validateQAListener = dVar;
    }

    public final void c2(String hostUin) {
        Intrinsics.checkNotNullParameter(hostUin, "hostUin");
        CommonRightQuestion commonRightQuestion = new CommonRightQuestion();
        commonRightQuestion.setQuestion(this.questionContent.getValue());
        commonRightQuestion.setAnswer(this.answerContent);
        QzoneMainPageFeedManager qzoneMainPageFeedManager = this.userHomeManager;
        if (qzoneMainPageFeedManager != null) {
            qzoneMainPageFeedManager.validateQA(hostUin, commonRightQuestion, new g());
        }
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QzoneUserHomeForbiddenViewModel";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        QzoneMainPageFeedManager qzoneMainPageFeedManager = this.userHomeManager;
        if (qzoneMainPageFeedManager != null) {
            qzoneMainPageFeedManager.clear();
        }
    }
}
