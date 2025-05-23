package com.qzone.reborn.qzmoment.comment;

import android.app.Activity;
import android.content.DialogInterface;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.qzmoment.bean.QZMCommentInfoBean;
import com.qzone.reborn.qzmoment.comment.QZMBaseInputPopupWindow;
import com.qzone.util.ToastUtil;
import com.qzone.util.l;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import qzonemoment.QZMomentMeta$StComment;
import qzonemoment.QZMomentMeta$StFeed;
import qzonemoment.QZMomentMeta$StReply;
import qzonemoment.QZMomentMeta$StUser;

/* compiled from: P */
/* loaded from: classes37.dex */
public class d implements SimpleEventReceiver {

    /* renamed from: m, reason: collision with root package name */
    private static volatile d f58860m;

    /* renamed from: d, reason: collision with root package name */
    private final Map<String, QZMCommentInfoBean> f58861d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    private final Map<String, List<String>> f58862e = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    private WeakReference<QZMCommentInputPopupWindow> f58863f;

    /* renamed from: h, reason: collision with root package name */
    private InterfaceC0494d f58864h;

    /* renamed from: i, reason: collision with root package name */
    private QZMCommentBusinessViewModel f58865i;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a implements QZMBaseInputPopupWindow.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f58866a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QZMCommentInputPopupWindow f58867b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ QZMomentMeta$StFeed f58868c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QZMomentMeta$StComment f58869d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QZMomentMeta$StReply f58870e;

        a(Activity activity, QZMCommentInputPopupWindow qZMCommentInputPopupWindow, QZMomentMeta$StFeed qZMomentMeta$StFeed, QZMomentMeta$StComment qZMomentMeta$StComment, QZMomentMeta$StReply qZMomentMeta$StReply) {
            this.f58866a = activity;
            this.f58867b = qZMCommentInputPopupWindow;
            this.f58868c = qZMomentMeta$StFeed;
            this.f58869d = qZMomentMeta$StComment;
            this.f58870e = qZMomentMeta$StReply;
        }

        @Override // com.qzone.reborn.qzmoment.comment.QZMBaseInputPopupWindow.b
        public void a() {
            QLog.d("QZMCommentHelper", 1, "onClickSend()");
            if (this.f58866a.isFinishing()) {
                QLog.d("QZMCommentHelper", 1, "onCommentSend(): mCommentInputPopupWindow null");
                return;
            }
            String U = this.f58867b.U();
            this.f58867b.e0("");
            if (TextUtils.isEmpty(U.trim())) {
                ToastUtil.o(R.string.f133867_, 4);
                return;
            }
            if (!NetworkUtil.isNetworkAvailable(MobileQQ.sMobileQQ)) {
                ToastUtil.o(R.string.f1338579, 4);
                return;
            }
            if (this.f58868c != null) {
                InterfaceC0494d interfaceC0494d = d.this.f58864h != null ? d.this.f58864h : null;
                QZMomentMeta$StComment qZMomentMeta$StComment = this.f58869d;
                if (qZMomentMeta$StComment != null) {
                    d.this.e(this.f58868c, qZMomentMeta$StComment, this.f58870e, U, interfaceC0494d, this.f58866a);
                } else {
                    d.this.d(this.f58868c, U, interfaceC0494d, this.f58866a);
                }
                this.f58867b.b0(null);
                this.f58867b.dismiss();
                d.l().o(this.f58868c, this.f58869d, this.f58870e);
                return;
            }
            QLog.e("QZMCommentHelper", 1, "feed is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class b implements DialogInterface.OnShowListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QZMomentMeta$StFeed f58872d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QZMomentMeta$StComment f58873e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ QZMomentMeta$StReply f58874f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ QZMCommentInputPopupWindow f58875h;

        b(QZMomentMeta$StFeed qZMomentMeta$StFeed, QZMomentMeta$StComment qZMomentMeta$StComment, QZMomentMeta$StReply qZMomentMeta$StReply, QZMCommentInputPopupWindow qZMCommentInputPopupWindow) {
            this.f58872d = qZMomentMeta$StFeed;
            this.f58873e = qZMomentMeta$StComment;
            this.f58874f = qZMomentMeta$StReply;
            this.f58875h = qZMCommentInputPopupWindow;
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            QZMCommentInfoBean j3 = d.l().j(this.f58872d, this.f58873e, this.f58874f);
            if (j3 != null) {
                this.f58875h.e0(j3.getText());
            } else {
                this.f58875h.e0("");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class c implements QZMBaseInputPopupWindow.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QZMCommentInputPopupWindow f58877a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QZMomentMeta$StFeed f58878b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ QZMomentMeta$StComment f58879c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QZMomentMeta$StReply f58880d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f58881e;

        c(QZMCommentInputPopupWindow qZMCommentInputPopupWindow, QZMomentMeta$StFeed qZMomentMeta$StFeed, QZMomentMeta$StComment qZMomentMeta$StComment, QZMomentMeta$StReply qZMomentMeta$StReply, String str) {
            this.f58877a = qZMCommentInputPopupWindow;
            this.f58878b = qZMomentMeta$StFeed;
            this.f58879c = qZMomentMeta$StComment;
            this.f58880d = qZMomentMeta$StReply;
            this.f58881e = str;
        }

        @Override // com.qzone.reborn.qzmoment.comment.QZMBaseInputPopupWindow.c
        public void onDismiss() {
            this.f58877a.b0("");
            d.l().s(this.f58878b, this.f58879c, this.f58880d, this.f58877a.U());
            this.f58877a.b0(d.this.k(null, null, null, this.f58881e));
        }
    }

    /* compiled from: P */
    /* renamed from: com.qzone.reborn.qzmoment.comment.d$d, reason: collision with other inner class name */
    /* loaded from: classes37.dex */
    public interface InterfaceC0494d {
        void a(QZMomentMeta$StComment qZMomentMeta$StComment);

        void b(QZMomentMeta$StReply qZMomentMeta$StReply);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(QZMomentMeta$StFeed qZMomentMeta$StFeed, String str, InterfaceC0494d interfaceC0494d, Activity activity) {
        QZMomentMeta$StComment f16 = f(str);
        if (interfaceC0494d != null) {
            QLog.d("QZMCommentHelper", 1, "addFakeComment commentInputListener callback success");
            interfaceC0494d.a(f16);
        } else {
            QLog.e("QZMCommentHelper", 1, "addFakeComment commentInputListener null");
        }
        QZMCommentBusinessViewModel qZMCommentBusinessViewModel = this.f58865i;
        if (qZMCommentBusinessViewModel != null) {
            qZMCommentBusinessViewModel.h2(activity.hashCode(), qZMomentMeta$StFeed, f16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(QZMomentMeta$StFeed qZMomentMeta$StFeed, QZMomentMeta$StComment qZMomentMeta$StComment, QZMomentMeta$StReply qZMomentMeta$StReply, String str, InterfaceC0494d interfaceC0494d, Activity activity) {
        QZMomentMeta$StReply g16 = g(str);
        if (qZMomentMeta$StReply != null && !TextUtils.isEmpty(qZMomentMeta$StReply.postUser.f430367id.get())) {
            g16.targetUser.set(qZMomentMeta$StReply.postUser.get());
        }
        if (interfaceC0494d != null) {
            QLog.d("QZMCommentHelper", 1, "addFakeReply commentInputListener callback success");
            interfaceC0494d.b(g16);
        } else {
            QLog.e("QZMCommentHelper", 1, "addFakeReply commentInputListener null");
        }
        QZMCommentBusinessViewModel qZMCommentBusinessViewModel = this.f58865i;
        if (qZMCommentBusinessViewModel != null) {
            qZMCommentBusinessViewModel.e2(activity.hashCode(), qZMomentMeta$StFeed, qZMomentMeta$StComment, g16, qZMomentMeta$StReply);
        }
    }

    private QZMomentMeta$StComment f(String str) {
        QZMomentMeta$StComment qZMomentMeta$StComment = new QZMomentMeta$StComment();
        qZMomentMeta$StComment.f430361id.set("fakeId_" + System.currentTimeMillis());
        qZMomentMeta$StComment.content.set(str);
        qZMomentMeta$StComment.createTime.set((long) ((int) (System.currentTimeMillis() / 1000)));
        QZMomentMeta$StUser qZMomentMeta$StUser = new QZMomentMeta$StUser();
        qZMomentMeta$StUser.f430367id.set(LoginData.getInstance().getUinString());
        qZMomentMeta$StUser.nick.set(LoginData.getInstance().getNickName(""));
        qZMomentMeta$StComment.postUser.set(qZMomentMeta$StUser);
        return qZMomentMeta$StComment;
    }

    private QZMomentMeta$StReply g(String str) {
        QZMomentMeta$StReply qZMomentMeta$StReply = new QZMomentMeta$StReply();
        qZMomentMeta$StReply.f430366id.set("fakeId_" + System.currentTimeMillis());
        qZMomentMeta$StReply.content.set(str);
        qZMomentMeta$StReply.createTime.set((long) ((int) (System.currentTimeMillis() / 1000)));
        QZMomentMeta$StUser qZMomentMeta$StUser = new QZMomentMeta$StUser();
        qZMomentMeta$StUser.f430367id.set(LoginData.getInstance().getUinString());
        qZMomentMeta$StUser.nick.set(LoginData.getInstance().getNickName(""));
        qZMomentMeta$StReply.postUser.set(qZMomentMeta$StUser);
        return qZMomentMeta$StReply;
    }

    private String h(String str, String str2, String str3) {
        StringBuilder sb5 = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb5.append(str);
        } else {
            sb5.append("null");
        }
        if (!TextUtils.isEmpty(str2)) {
            sb5.append(ContainerUtils.FIELD_DELIMITER);
            sb5.append(str2);
        } else {
            sb5.append(ContainerUtils.FIELD_DELIMITER);
            sb5.append("null");
        }
        if (!TextUtils.isEmpty(str3)) {
            sb5.append(ContainerUtils.FIELD_DELIMITER);
            sb5.append(str3);
        } else {
            sb5.append(ContainerUtils.FIELD_DELIMITER);
            sb5.append("null");
        }
        return sb5.toString();
    }

    public static d l() {
        if (f58860m == null) {
            synchronized (d.class) {
                if (f58860m == null) {
                    f58860m = new d();
                }
            }
        }
        return f58860m;
    }

    private String n(String str) {
        if (str.length() <= 10) {
            return str;
        }
        return str.substring(0, 10) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        return null;
    }

    public String i(QZMomentMeta$StFeed qZMomentMeta$StFeed, QZMomentMeta$StComment qZMomentMeta$StComment, QZMomentMeta$StReply qZMomentMeta$StReply) {
        String str;
        String str2;
        String str3 = "";
        if (qZMomentMeta$StFeed == null) {
            str = "";
        } else {
            str = qZMomentMeta$StFeed.f430362id.get();
        }
        if (qZMomentMeta$StComment == null) {
            str2 = "";
        } else {
            str2 = qZMomentMeta$StComment.f430361id.get();
        }
        if (qZMomentMeta$StReply != null) {
            str3 = qZMomentMeta$StReply.f430366id.get();
        }
        return h(str, str2, str3);
    }

    public QZMCommentInfoBean j(QZMomentMeta$StFeed qZMomentMeta$StFeed, QZMomentMeta$StComment qZMomentMeta$StComment, QZMomentMeta$StReply qZMomentMeta$StReply) {
        String i3 = i(qZMomentMeta$StFeed, qZMomentMeta$StComment, qZMomentMeta$StReply);
        if (this.f58861d.containsKey(i3)) {
            return this.f58861d.get(i3);
        }
        return null;
    }

    public String k(QZMomentMeta$StFeed qZMomentMeta$StFeed, QZMomentMeta$StComment qZMomentMeta$StComment, QZMomentMeta$StReply qZMomentMeta$StReply, String str) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        if (qZMomentMeta$StReply != null && !TextUtils.isEmpty(qZMomentMeta$StReply.f430366id.get()) && qZMomentMeta$StReply.postUser != null) {
            return n(String.format(l.a(R.string.f170928b51), qZMomentMeta$StReply.postUser.nick.get()));
        }
        if (qZMomentMeta$StComment != null && !TextUtils.isEmpty(qZMomentMeta$StComment.f430361id.get()) && qZMomentMeta$StComment.postUser != null) {
            return n(String.format(l.a(R.string.f170928b51), qZMomentMeta$StComment.postUser.nick.get()));
        }
        return "\u8bf4\u70b9\u4ec0\u4e48\u5427";
    }

    public void o(QZMomentMeta$StFeed qZMomentMeta$StFeed, QZMomentMeta$StComment qZMomentMeta$StComment, QZMomentMeta$StReply qZMomentMeta$StReply) {
        this.f58861d.remove(i(qZMomentMeta$StFeed, qZMomentMeta$StComment, qZMomentMeta$StReply));
        if (qZMomentMeta$StFeed != null) {
            this.f58861d.remove(qZMomentMeta$StFeed.f430362id.get());
        }
    }

    public void p(QZMCommentBusinessViewModel qZMCommentBusinessViewModel) {
        this.f58865i = qZMCommentBusinessViewModel;
    }

    public void q(Activity activity, QZMFeedCommentInfo qZMFeedCommentInfo, InterfaceC0494d interfaceC0494d) {
        if (activity != null && qZMFeedCommentInfo != null && !FastClickUtils.isFastDoubleClick("QZMCommentHelper", 500L)) {
            QZMomentMeta$StFeed qZMomentMeta$StFeed = qZMFeedCommentInfo.mFeed;
            QZMomentMeta$StComment qZMomentMeta$StComment = qZMFeedCommentInfo.mComment;
            QZMomentMeta$StReply qZMomentMeta$StReply = qZMFeedCommentInfo.mReply;
            QZMCommentInputPopupWindow qZMCommentInputPopupWindow = new QZMCommentInputPopupWindow(activity);
            String str = qZMFeedCommentInfo.mHintText;
            this.f58864h = interfaceC0494d;
            this.f58863f = new WeakReference<>(qZMCommentInputPopupWindow);
            qZMCommentInputPopupWindow.b0(k(qZMomentMeta$StFeed, qZMomentMeta$StComment, qZMomentMeta$StReply, str));
            qZMCommentInputPopupWindow.c0(new a(activity, qZMCommentInputPopupWindow, qZMomentMeta$StFeed, qZMomentMeta$StComment, qZMomentMeta$StReply));
            m(qZMCommentInputPopupWindow, qZMomentMeta$StFeed, qZMomentMeta$StComment, qZMomentMeta$StReply, interfaceC0494d, qZMFeedCommentInfo.mHintText);
            qZMCommentInputPopupWindow.Q0(false);
            return;
        }
        QLog.e("QZMCommentHelper", 1, "showInputPopupWindow param error");
    }

    public void r(String str, String str2) {
        QZMCommentInfoBean qZMCommentInfoBean = new QZMCommentInfoBean();
        qZMCommentInfoBean.setText(str2);
        this.f58861d.put(str, qZMCommentInfoBean);
    }

    public void s(QZMomentMeta$StFeed qZMomentMeta$StFeed, QZMomentMeta$StComment qZMomentMeta$StComment, QZMomentMeta$StReply qZMomentMeta$StReply, String str) {
        r(i(qZMomentMeta$StFeed, qZMomentMeta$StComment, qZMomentMeta$StReply), str);
    }

    public void onDestroy() {
        this.f58864h = null;
        this.f58865i = null;
    }

    private void m(QZMCommentInputPopupWindow qZMCommentInputPopupWindow, QZMomentMeta$StFeed qZMomentMeta$StFeed, QZMomentMeta$StComment qZMomentMeta$StComment, QZMomentMeta$StReply qZMomentMeta$StReply, InterfaceC0494d interfaceC0494d, String str) {
        if (qZMCommentInputPopupWindow == null) {
            return;
        }
        qZMCommentInputPopupWindow.setOnShowListener(new b(qZMomentMeta$StFeed, qZMomentMeta$StComment, qZMomentMeta$StReply, qZMCommentInputPopupWindow));
        qZMCommentInputPopupWindow.d0(new c(qZMCommentInputPopupWindow, qZMomentMeta$StFeed, qZMomentMeta$StComment, qZMomentMeta$StReply, str));
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
    }
}
