package com.tencent.biz.pubaccount.recentcontact;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.pubaccount.api.IPublicAccountCommonMrg;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.IPublicAccountManager;
import com.tencent.biz.pubaccount.api.IPublicAccountServlet;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.RecentPubAccHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.applets.c;
import com.tencent.mobileqq.mp.mobileqq_mp$UnFollowRequest;
import com.tencent.mobileqq.mp.mobileqq_mp$UnFollowResponse;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.troop.utils.z;
import com.tencent.mobileqq.utils.cc;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.widget.ActionSheet;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.app.api.IRuntimeService;
import mqq.manager.Manager;
import mqq.observer.BusinessObserver;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 52\u00020\u0001:\u0001\u0019B\u0017\u0012\u0006\u0010\u001d\u001a\u00020\u0018\u0012\u0006\u0010#\u001a\u00020\u001e\u00a2\u0006\u0004\b3\u00104J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0002H\u0002J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u001a\u0010\u0012\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u0013\u001a\u00020\u0002H\u0002J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0002H\u0002J\b\u0010\u0015\u001a\u00020\u0006H\u0002J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u000e\u0010\u0017\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bR\u0017\u0010\u001d\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010#\u001a\u00020\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010.\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0014\u00102\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101\u00a8\u00066"}, d2 = {"Lcom/tencent/biz/pubaccount/recentcontact/m;", "", "", "r", "", "show", "", "v", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/mobileqq/app/QQAppInterface;", "appInterface", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "resId", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "B", "Lcom/tencent/biz/pubaccount/accountdetail/api/IPublicAccountDetail;", "detail", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "u", "t", DomainData.DOMAIN_NAME, "w", "Lcom/tencent/qqnt/chats/main/vm/datasource/IRecentContactRepo;", "a", "Lcom/tencent/qqnt/chats/main/vm/datasource/IRecentContactRepo;", "getRecentContactRepo", "()Lcom/tencent/qqnt/chats/main/vm/datasource/IRecentContactRepo;", "recentContactRepo", "Landroid/content/Context;", "b", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "mContext", "Lcom/tencent/mobileqq/widget/QQProgressDialog;", "c", "Lcom/tencent/mobileqq/widget/QQProgressDialog;", "mProgressBar", "d", "Z", "unFollowActionSheetHasClick", "Lcom/tencent/biz/pubaccount/recentcontact/e;", "e", "Lcom/tencent/biz/pubaccount/recentcontact/e;", "paUnfollowClickMrg", "Ljava/lang/Runnable;", "f", "Ljava/lang/Runnable;", "progressRunnable", "<init>", "(Lcom/tencent/qqnt/chats/main/vm/datasource/IRecentContactRepo;Landroid/content/Context;)V", "g", "qqpubaccount_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class m {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final IRecentContactRepo recentContactRepo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Context mContext;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private QQProgressDialog mProgressBar;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean unFollowActionSheetHasClick;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final e paUnfollowClickMrg;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Runnable progressRunnable;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/biz/pubaccount/recentcontact/m$a;", "", "", IPublicAccountBrowser.KEY_PUB_UIN, "", "a", "", "ACCOUNT_TYPE_PUBLIC_ACCOUNT", "I", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqpubaccount_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.pubaccount.recentcontact.m$a, reason: from kotlin metadata */
    /* loaded from: classes32.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(String puin) {
            Intrinsics.checkNotNullParameter(puin, "puin");
            if (TextUtils.isEmpty(puin)) {
                return false;
            }
            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
            Intrinsics.checkNotNull(runtime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
            IRuntimeService runtimeService = ((QQAppInterface) runtime).getRuntimeService(IPublicAccountDataManager.class, "all");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "mApp.getRuntimeService(I\u2026ava, ProcessConstant.ALL)");
            IPublicAccountDataManager iPublicAccountDataManager = (IPublicAccountDataManager) runtimeService;
            IPublicAccountDetail findAccountDetailInfoCache = iPublicAccountDataManager.findAccountDetailInfoCache(puin);
            if (findAccountDetailInfoCache != null && !findAccountDetailInfoCache.isShowFollowButton()) {
                return false;
            }
            if (iPublicAccountDataManager.findPublicAccountInfoCache(puin) != null) {
                return true;
            }
            return findAccountDetailInfoCache != null && findAccountDetailInfoCache.getFollowType() == 1;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/biz/pubaccount/recentcontact/m$b", "Lcom/tencent/mobileqq/applets/c$a;", "", "e", "", "isSuccess", "", "data", "", "b", "unCheckResponseBody", "d", "c", "a", "qqpubaccount_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class b extends c.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.qqnt.chats.core.adapter.itemdata.g f79920b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f79921c;

        b(com.tencent.qqnt.chats.core.adapter.itemdata.g gVar, QQAppInterface qQAppInterface) {
            this.f79920b = gVar;
            this.f79921c = qQAppInterface;
        }

        @Override // com.tencent.mobileqq.applets.c.a
        public void a(boolean isSuccess, Object data) {
            Intrinsics.checkNotNullParameter(data, "data");
            m.this.t();
        }

        @Override // com.tencent.mobileqq.applets.c.a
        public void b(boolean isSuccess, Object data) {
            Intrinsics.checkNotNullParameter(data, "data");
        }

        @Override // com.tencent.mobileqq.applets.c.a
        public void c(Object data) {
            Intrinsics.checkNotNullParameter(data, "data");
            m.this.u(R.string.d6b);
        }

        @Override // com.tencent.mobileqq.applets.c.a
        public void d(Object unCheckResponseBody) {
            Intrinsics.checkNotNullParameter(unCheckResponseBody, "unCheckResponseBody");
            if (QLog.isColorLevel()) {
                QLog.d("RecentPAHelper", 2, "unfollow success");
            }
            m.this.B(this.f79920b, this.f79921c);
            Manager manager = this.f79921c.getManager(QQManagerFactory.TROOP_BIND_PUBACCOUNT_MANAGER);
            Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.troop.utils.TroopBindPublicAccountMgr");
            ((z) manager).b(String.valueOf(this.f79920b.l()));
            m.this.n(this.f79920b);
        }

        @Override // com.tencent.mobileqq.applets.c.a
        public int e() {
            return 5;
        }
    }

    public m(IRecentContactRepo recentContactRepo, Context mContext) {
        Intrinsics.checkNotNullParameter(recentContactRepo, "recentContactRepo");
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.recentContactRepo = recentContactRepo;
        this.mContext = mContext;
        this.paUnfollowClickMrg = new e();
        this.progressRunnable = new Runnable() { // from class: com.tencent.biz.pubaccount.recentcontact.f
            @Override // java.lang.Runnable
            public final void run() {
                m.s(m.this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(com.tencent.qqnt.chats.core.adapter.itemdata.g item, m this$0, QQAppInterface appInterface, int i3, boolean z16, Bundle bundle) {
        Intrinsics.checkNotNullParameter(item, "$item");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(appInterface, "$appInterface");
        if (QLog.isColorLevel()) {
            QLog.d("RecentPAHelper", 2, "unfollow isSuccess:" + z16 + ", uin: " + item.l());
        }
        if (!z16) {
            this$0.u(R.string.d6b);
            return;
        }
        try {
            byte[] byteArray = bundle.getByteArray("data");
            if (byteArray != null) {
                mobileqq_mp$UnFollowResponse mobileqq_mp_unfollowresponse = new mobileqq_mp$UnFollowResponse();
                mobileqq_mp_unfollowresponse.mergeFrom(byteArray);
                if (mobileqq_mp_unfollowresponse.ret_info.get().ret_code.get() == 0) {
                    if (QLog.isColorLevel()) {
                        QLog.d("RecentPAHelper", 2, "unfollow success");
                    }
                    this$0.B(item, appInterface);
                    Manager manager = appInterface.getManager(QQManagerFactory.TROOP_BIND_PUBACCOUNT_MANAGER);
                    Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.troop.utils.TroopBindPublicAccountMgr");
                    ((z) manager).b(String.valueOf(item.l()));
                    this$0.n(item);
                } else {
                    this$0.m(R.string.d6b);
                }
            }
        } catch (Exception unused) {
        }
        this$0.t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(final com.tencent.qqnt.chats.core.adapter.itemdata.g item, final QQAppInterface appInterface) {
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.biz.pubaccount.recentcontact.l
            @Override // java.lang.Runnable
            public final void run() {
                m.C(QQAppInterface.this, item, this);
            }
        }, 16, null, true, 10L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(QQAppInterface appInterface, com.tencent.qqnt.chats.core.adapter.itemdata.g item, m this$0) {
        Intrinsics.checkNotNullParameter(appInterface, "$appInterface");
        Intrinsics.checkNotNullParameter(item, "$item");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (QLog.isColorLevel()) {
            QLog.d("RecentPAHelper", 2, "updateUnfollowInfo");
        }
        ((IPublicAccountManager) QRoute.api(IPublicAccountManager.class)).removeMsgID(appInterface, String.valueOf(item.l()));
        IRuntimeService runtimeService = appInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appInterface.getRuntimeS\u2026onstant.ALL\n            )");
        IPublicAccountDataManager iPublicAccountDataManager = (IPublicAccountDataManager) runtimeService;
        iPublicAccountDataManager.delPublicAccountInfoCache(String.valueOf(item.l()));
        iPublicAccountDataManager.delPublicAccountInfo(String.valueOf(item.l()));
        IPublicAccountDetail findAccountDetailInfo = iPublicAccountDataManager.findAccountDetailInfo(String.valueOf(item.l()));
        if (findAccountDetailInfo != null) {
            this$0.l(findAccountDetailInfo, appInterface);
        }
        cc.a(" pubAcc_follow_cancel", null, String.valueOf(item.l()));
        this$0.paUnfollowClickMrg.a(item.s());
    }

    private final void m(int resId) {
        Toast.makeText(this.mContext, resId, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(final com.tencent.qqnt.chats.core.adapter.itemdata.g item) {
        IPublicAccountCommonMrg iPublicAccountCommonMrg = (IPublicAccountCommonMrg) QRoute.api(IPublicAccountCommonMrg.class);
        long j3 = item.s().peerUin;
        String str = item.s().peerUid;
        Intrinsics.checkNotNullExpressionValue(str, "item.originData.peerUid");
        iPublicAccountCommonMrg.setTop(j3, str, false, new IOperateCallback() { // from class: com.tencent.biz.pubaccount.recentcontact.j
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str2) {
                m.o(com.tencent.qqnt.chats.core.adapter.itemdata.g.this, i3, str2);
            }
        });
        this.recentContactRepo.g(new Contact(item.n(), item.k(), ""), new IOperateCallback() { // from class: com.tencent.biz.pubaccount.recentcontact.k
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str2) {
                m.p(i3, str2);
            }
        });
        ((IPublicAccountCommonMrg) QRoute.api(IPublicAccountCommonMrg.class)).clearMsgRecords4PA(item.k(), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(com.tencent.qqnt.chats.core.adapter.itemdata.g item, int i3, String str) {
        Intrinsics.checkNotNullParameter(item, "$item");
        ((IPublicAccountCommonMrg) QRoute.api(IPublicAccountCommonMrg.class)).deleteRecentContact4PA(item.s(), (IOperateCallback) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(int i3, String str) {
        QLog.d("RecentPAHelper", 1, "mark read: result: " + i3 + ", err: " + str);
    }

    private final int q() {
        return 1;
    }

    private final int r() {
        Context context = this.mContext;
        Intrinsics.checkNotNull(context);
        return context.getResources().getDimensionPixelSize(R.dimen.title_bar_height);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(m this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.v(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t() {
        QQProgressDialog qQProgressDialog = this.mProgressBar;
        if (qQProgressDialog != null) {
            Intrinsics.checkNotNull(qQProgressDialog);
            if (qQProgressDialog.isShowing()) {
                QQProgressDialog qQProgressDialog2 = this.mProgressBar;
                Intrinsics.checkNotNull(qQProgressDialog2);
                qQProgressDialog2.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u(int resId) {
        if (QLog.isColorLevel()) {
            QLog.d("RecentPAHelper", 2, "showNetworkErrorToast");
        }
        Toast.makeText(this.mContext, resId, 0).show();
    }

    private final void v(boolean show) {
        if (this.mProgressBar == null) {
            QQProgressDialog qQProgressDialog = new QQProgressDialog(this.mContext, r());
            this.mProgressBar = qQProgressDialog;
            Intrinsics.checkNotNull(qQProgressDialog);
            qQProgressDialog.setMessage(R.string.d7l);
            QQProgressDialog qQProgressDialog2 = this.mProgressBar;
            Intrinsics.checkNotNull(qQProgressDialog2);
            qQProgressDialog2.setCanceledOnTouchOutside(true);
        }
        QQProgressDialog qQProgressDialog3 = this.mProgressBar;
        if (qQProgressDialog3 != null) {
            if (show) {
                Intrinsics.checkNotNull(qQProgressDialog3);
                if (!qQProgressDialog3.isShowing()) {
                    QQProgressDialog qQProgressDialog4 = this.mProgressBar;
                    Intrinsics.checkNotNull(qQProgressDialog4);
                    qQProgressDialog4.show();
                    ThreadManagerV2.getUIHandlerV2().postDelayed(this.progressRunnable, 1000L);
                }
            }
            if (!show) {
                QQProgressDialog qQProgressDialog5 = this.mProgressBar;
                Intrinsics.checkNotNull(qQProgressDialog5);
                if (qQProgressDialog5.isShowing()) {
                    QQProgressDialog qQProgressDialog6 = this.mProgressBar;
                    Intrinsics.checkNotNull(qQProgressDialog6);
                    qQProgressDialog6.dismiss();
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("RecentPAHelper", 2, "showProgressBar->show:" + show);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(m this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.unFollowActionSheetHasClick = false;
    }

    private final void z(final com.tencent.qqnt.chats.core.adapter.itemdata.g item, final QQAppInterface appInterface) {
        cc.a(null, " pubAcc_follow_cancel", String.valueOf(item.l()));
        if (QLog.isColorLevel()) {
            QLog.d("RecentPAHelper", 2, "unfollow->UIN: " + item.l());
        }
        v(true);
        IRuntimeService runtimeService = appInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appInterface.getRuntimeS\u2026essConstant.ALL\n        )");
        IPublicAccountDetail findAccountDetailInfo = ((IPublicAccountDataManager) runtimeService).findAccountDetailInfo(String.valueOf(item.l()));
        if (findAccountDetailInfo != null && ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).getAccountType(findAccountDetailInfo.getAccountFlag()) == -4) {
            NewIntent newIntent = new NewIntent(this.mContext, ((IPublicAccountServlet) QRoute.api(IPublicAccountServlet.class)).getServletClass());
            newIntent.putExtra("cmd", IPublicAccountManager.SSO_COMMAND_GET_UNFOLLOW);
            mobileqq_mp$UnFollowRequest mobileqq_mp_unfollowrequest = new mobileqq_mp$UnFollowRequest();
            mobileqq_mp_unfollowrequest.uin.set((int) item.l());
            mobileqq_mp_unfollowrequest.account_type.set(q());
            newIntent.putExtra("data", mobileqq_mp_unfollowrequest.toByteArray());
            newIntent.setObserver(new BusinessObserver() { // from class: com.tencent.biz.pubaccount.recentcontact.i
                @Override // mqq.observer.BusinessObserver
                public final void onReceive(int i3, boolean z16, Bundle bundle) {
                    m.A(com.tencent.qqnt.chats.core.adapter.itemdata.g.this, this, appInterface, i3, z16, bundle);
                }
            });
            appInterface.startServlet(newIntent);
        } else {
            com.tencent.mobileqq.applets.c cVar = new com.tencent.mobileqq.applets.c(new b(item, appInterface), appInterface);
            appInterface.removeObserver(cVar);
            appInterface.addObserver(cVar);
            com.tencent.mobileqq.applets.e.b(appInterface, false, item.l(), 0);
        }
        ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).removeLbsUin(appInterface, String.valueOf(item.l()));
        if (QLog.isColorLevel()) {
            QLog.d("RecentPAHelper", 2, "unfollow exit");
        }
    }

    public final void w(final com.tencent.qqnt.chats.core.adapter.itemdata.g item) {
        Intrinsics.checkNotNullParameter(item, "item");
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        Intrinsics.checkNotNull(runtime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        final QQAppInterface qQAppInterface = (QQAppInterface) runtime;
        final ActionSheet create = ActionSheet.create(this.mContext);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = this.mContext.getResources().getString(R.string.f1765331i);
        Intrinsics.checkNotNullExpressionValue(string, "mContext.resources.getSt\u2026ount_slide_unfollow_tips)");
        String format = String.format(string, Arrays.copyOf(new Object[]{item.w().e()}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        create.setMainTitle(format);
        create.addButton(RecentPubAccHelper.f() ? R.string.f1765231h : R.string.f1765131g, 3);
        create.addCancelButton(R.string.f1765031f);
        create.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.biz.pubaccount.recentcontact.g
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                m.x(m.this, dialogInterface);
            }
        });
        create.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.biz.pubaccount.recentcontact.h
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                m.y(m.this, qQAppInterface, item, create, view, i3);
            }
        });
        if (create.isShowing()) {
            return;
        }
        this.unFollowActionSheetHasClick = false;
        create.show();
        if (RecentPubAccHelper.f()) {
            ReportController.o(qQAppInterface, "dc00898", "", String.valueOf(item.l()), "0X800BDD7", "0X800BDD7", 0, 0, "", "", "", "");
        }
    }

    private final void l(IPublicAccountDetail detail, QQAppInterface appInterface) {
        if (detail == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("RecentPAHelper", 2, "deleteAccount");
        }
        EntityManager createEntityManager = appInterface.getEntityManagerFactory().createEntityManager();
        createEntityManager.remove(detail.getEntity());
        createEntityManager.close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(m this$0, QQAppInterface mApp, com.tencent.qqnt.chats.core.adapter.itemdata.g item, ActionSheet actionSheet, View view, int i3) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(mApp, "$mApp");
        Intrinsics.checkNotNullParameter(item, "$item");
        if (this$0.unFollowActionSheetHasClick) {
            return;
        }
        this$0.unFollowActionSheetHasClick = true;
        if (i3 == 0) {
            if (RecentPubAccHelper.f()) {
                str = "0X800BDD8";
            } else {
                str = "0X800991E";
            }
            String str2 = str;
            ReportController.o(mApp, "dc00898", "", String.valueOf(item.l()), str2, str2, 0, 0, "", "", "", "");
            this$0.z(item, mApp);
        }
        actionSheet.dismiss();
    }
}
