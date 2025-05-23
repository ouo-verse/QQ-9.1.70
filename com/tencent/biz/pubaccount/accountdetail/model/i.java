package com.tencent.biz.pubaccount.accountdetail.model;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetailActivity;
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDataCardFragment;
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl;
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailImpl;
import com.tencent.biz.pubaccount.api.IPublicAccountCommonMrg;
import com.tencent.biz.pubaccount.api.IPublicAccountManager;
import com.tencent.biz.pubaccount.api.impl.PublicAccountHandlerImpl;
import com.tencent.biz.pubaccount.api.impl.PublicAccountServletImpl;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.applets.c;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.mp.mobileqq_mp$FollowRequest;
import com.tencent.mobileqq.mp.mobileqq_mp$FollowResponse;
import com.tencent.mobileqq.mp.mobileqq_mp$UnFollowRequest;
import com.tencent.mobileqq.mp.mobileqq_mp$UnFollowResponse;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqshop.api.IQQShopApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.utils.z;
import com.tencent.mobileqq.utils.cc;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import mqq.observer.BusinessObserver;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xc96.oidb_cmd0xc96$RspBody;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bj\u0010kJ\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0004J\u0010\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u0016\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\b\u0010\u0011\u001a\u00020\u0010H\u0004R$\u0010\u0019\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u001d\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R$\u0010$\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010,\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R$\u00100\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010'\u001a\u0004\b.\u0010)\"\u0004\b/\u0010+R$\u00108\u001a\u0004\u0018\u0001018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R$\u0010<\u001a\u0004\u0018\u0001018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u00103\u001a\u0004\b:\u00105\"\u0004\b;\u00107R$\u0010D\u001a\u0004\u0018\u00010=8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR$\u0010L\u001a\u0004\u0018\u00010E8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR$\u0010T\u001a\u0004\u0018\u00010M8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR$\u0010\\\u001a\u0004\u0018\u00010U8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\u001a\u0010a\u001a\u00020\u00068\u0006X\u0086D\u00a2\u0006\f\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`R\"\u0010i\u001a\u00020b8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bc\u0010d\u001a\u0004\be\u0010f\"\u0004\bg\u0010h\u00a8\u0006l"}, d2 = {"Lcom/tencent/biz/pubaccount/accountdetail/model/i;", "Landroidx/lifecycle/ViewModel;", "Lcom/tencent/mobileqq/app/QQAppInterface;", "P1", "", "Z1", "", "uin", "d2", "R1", "f2", "Lcom/tencent/biz/pubaccount/accountdetail/api/impl/PublicAccountDetailImpl;", "detail", "Q1", "pUin", "c2", "", "U1", "Lmqq/app/NewIntent;", "i", "Lmqq/app/NewIntent;", "getUnfollowIntent", "()Lmqq/app/NewIntent;", "setUnfollowIntent", "(Lmqq/app/NewIntent;)V", "unfollowIntent", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getFollowIntent", "setFollowIntent", "followIntent", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/biz/pubaccount/accountdetail/api/impl/PublicAccountDetailImpl;", "T1", "()Lcom/tencent/biz/pubaccount/accountdetail/api/impl/PublicAccountDetailImpl;", ICustomDataEditor.STRING_ARRAY_PARAM_2, "(Lcom/tencent/biz/pubaccount/accountdetail/api/impl/PublicAccountDetailImpl;)V", "accountDetail", "Lmqq/observer/BusinessObserver;", "D", "Lmqq/observer/BusinessObserver;", "getUnfollowObserver", "()Lmqq/observer/BusinessObserver;", "setUnfollowObserver", "(Lmqq/observer/BusinessObserver;)V", "unfollowObserver", "E", "getFollowObserver", "setFollowObserver", "followObserver", "Lcom/tencent/mobileqq/applets/c;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/applets/c;", "getNewUnFollowObserver", "()Lcom/tencent/mobileqq/applets/c;", "setNewUnFollowObserver", "(Lcom/tencent/mobileqq/applets/c;)V", "newUnFollowObserver", "G", "getNewFollowObserver", "setNewFollowObserver", "newFollowObserver", "Landroid/content/Context;", "H", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "mContext", "Landroid/content/Intent;", "I", "Landroid/content/Intent;", "getMIntent", "()Landroid/content/Intent;", "setMIntent", "(Landroid/content/Intent;)V", "mIntent", "Lcom/tencent/biz/pubaccount/api/impl/PublicAccountHandlerImpl;", "J", "Lcom/tencent/biz/pubaccount/api/impl/PublicAccountHandlerImpl;", "getPublicAccountHandler", "()Lcom/tencent/biz/pubaccount/api/impl/PublicAccountHandlerImpl;", "setPublicAccountHandler", "(Lcom/tencent/biz/pubaccount/api/impl/PublicAccountHandlerImpl;)V", "publicAccountHandler", "Lcom/tencent/biz/pubaccount/accountdetail/api/impl/PublicAccountDataCardFragment;", "K", "Lcom/tencent/biz/pubaccount/accountdetail/api/impl/PublicAccountDataCardFragment;", "W1", "()Lcom/tencent/biz/pubaccount/accountdetail/api/impl/PublicAccountDataCardFragment;", "b2", "(Lcom/tencent/biz/pubaccount/accountdetail/api/impl/PublicAccountDataCardFragment;)V", "dataCardFragment", "L", "Ljava/lang/String;", "X1", "()Ljava/lang/String;", "TAG", "Landroid/os/Handler;", "M", "Landroid/os/Handler;", "getMHandler", "()Landroid/os/Handler;", "setMHandler", "(Landroid/os/Handler;)V", "mHandler", "<init>", "()V", "qqpubaccount_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class i extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    private PublicAccountDetailImpl accountDetail;

    /* renamed from: D, reason: from kotlin metadata */
    private BusinessObserver unfollowObserver;

    /* renamed from: E, reason: from kotlin metadata */
    private BusinessObserver followObserver;

    /* renamed from: F, reason: from kotlin metadata */
    private com.tencent.mobileqq.applets.c newUnFollowObserver;

    /* renamed from: G, reason: from kotlin metadata */
    private com.tencent.mobileqq.applets.c newFollowObserver;

    /* renamed from: H, reason: from kotlin metadata */
    private Context mContext;

    /* renamed from: I, reason: from kotlin metadata */
    private Intent mIntent;

    /* renamed from: J, reason: from kotlin metadata */
    private PublicAccountHandlerImpl publicAccountHandler;

    /* renamed from: K, reason: from kotlin metadata */
    private PublicAccountDataCardFragment dataCardFragment;

    /* renamed from: L, reason: from kotlin metadata */
    private final String TAG = "com.tencent.biz.pubaccount.AccountDetail.model.PublicAccountDataCardViewModel";

    /* renamed from: M, reason: from kotlin metadata */
    private Handler mHandler = new b();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private NewIntent unfollowIntent;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private NewIntent followIntent;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/biz/pubaccount/accountdetail/model/i$a", "Lcom/tencent/mobileqq/applets/c$a;", "", "e", "", "isSuccess", "", "data", "", "b", "unCheckResponseBody", "d", "c", "a", "qqpubaccount_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class a extends c.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f79132b;

        a(String str) {
            this.f79132b = str;
        }

        @Override // com.tencent.mobileqq.applets.c.a
        public void a(boolean isSuccess, Object data) {
            Intrinsics.checkNotNullParameter(data, "data");
        }

        @Override // com.tencent.mobileqq.applets.c.a
        public void b(boolean isSuccess, Object data) {
            Intrinsics.checkNotNullParameter(data, "data");
        }

        @Override // com.tencent.mobileqq.applets.c.a
        public void c(Object data) {
            Intrinsics.checkNotNullParameter(data, "data");
            QLog.d(i.this.getTAG(), 1, "follow request failure uin: " + this.f79132b);
        }

        @Override // com.tencent.mobileqq.applets.c.a
        public void d(Object unCheckResponseBody) {
            PublicAccountDetailImpl accountDetail;
            Intrinsics.checkNotNullParameter(unCheckResponseBody, "unCheckResponseBody");
            if (unCheckResponseBody instanceof oidb_cmd0xc96$RspBody) {
                if (QLog.isColorLevel()) {
                    QLog.d(i.this.getTAG(), 2, "data card 0xc96 responseBody success, wording=", ((oidb_cmd0xc96$RspBody) unCheckResponseBody).wording.get());
                }
                JSONObject jSONObject = new JSONObject();
                if (i.this.getAccountDetail() != null) {
                    try {
                        PublicAccountDetailImpl accountDetail2 = i.this.getAccountDetail();
                        jSONObject.put("uin", accountDetail2 != null ? accountDetail2.uin : null);
                        PublicAccountDetailImpl accountDetail3 = i.this.getAccountDetail();
                        jSONObject.put("name", accountDetail3 != null ? accountDetail3.name : null);
                        PublicAccountDetailImpl accountDetail4 = i.this.getAccountDetail();
                        jSONObject.put("summary", accountDetail4 != null ? accountDetail4.summary : null);
                        PublicAccountDetailImpl accountDetail5 = i.this.getAccountDetail();
                        jSONObject.put("certified", accountDetail5 != null ? Integer.valueOf(accountDetail5.certifiedGrade) : null);
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(PublicAccountDetailActivityImpl.DOMAIN_MP_FIND);
                        arrayList.add(PublicAccountDetailActivityImpl.DOMAIN_MP_POST);
                        arrayList.add(PublicAccountDetailActivityImpl.DOMAIN_MP_ARTICLE);
                        com.tencent.mobileqq.jsp.h.w("follow", jSONObject, arrayList, null);
                    } catch (JSONException e16) {
                        e16.printStackTrace();
                    }
                }
                if (i.this.getAccountDetail() != null && (accountDetail = i.this.getAccountDetail()) != null) {
                    accountDetail.followType = 1;
                }
                PublicAccountDataCardFragment dataCardFragment = i.this.getDataCardFragment();
                if (dataCardFragment != null) {
                    dataCardFragment.Ii(1);
                }
            }
        }

        @Override // com.tencent.mobileqq.applets.c.a
        public int e() {
            return 4;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/biz/pubaccount/accountdetail/model/i$b", "Landroid/os/Handler;", "Landroid/os/Message;", "msg", "", "handleMessage", "qqpubaccount_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class b extends Handler {
        b() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            if (msg2.what == 2) {
                new Intent().putExtra(AppConstants.Key.IS_NEED_FINISH, true);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/biz/pubaccount/accountdetail/model/i$c", "Lcom/tencent/biz/pubaccount/api/IPublicAccountCommonMrg$a;", "", QzoneIPCModule.RESULT_CODE, "", "isTop", "", "b", "qqpubaccount_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class c extends IPublicAccountCommonMrg.a {
        c() {
        }

        @Override // com.tencent.biz.pubaccount.api.IPublicAccountCommonMrg.a
        public void b(int resultCode, boolean isTop) {
            String str;
            PublicAccountDetailImpl accountDetail = i.this.getAccountDetail();
            if (accountDetail == null || (str = accountDetail.uid) == null) {
                return;
            }
            i iVar = i.this;
            IPublicAccountCommonMrg iPublicAccountCommonMrg = (IPublicAccountCommonMrg) QRoute.api(IPublicAccountCommonMrg.class);
            PublicAccountDetailImpl accountDetail2 = iVar.getAccountDetail();
            iPublicAccountCommonMrg.setTop(com.tencent.mobileqq.qcall.g.e(accountDetail2 != null ? accountDetail2.getUin() : null), str, !isTop, null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0006H\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/biz/pubaccount/accountdetail/model/i$d", "Lcom/tencent/mobileqq/applets/c$a;", "", "e", "", "isSuccess", "", "data", "", "b", "unCheckResponseBody", "d", "c", "a", "qqpubaccount_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class d extends c.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f79135b;

        d(String str) {
            this.f79135b = str;
        }

        @Override // com.tencent.mobileqq.applets.c.a
        public void a(boolean isSuccess, Object data) {
            Intrinsics.checkNotNullParameter(data, "data");
        }

        @Override // com.tencent.mobileqq.applets.c.a
        public void b(boolean isSuccess, Object data) {
            Intrinsics.checkNotNullParameter(data, "data");
        }

        @Override // com.tencent.mobileqq.applets.c.a
        public void c(Object data) {
            Intrinsics.checkNotNullParameter(data, "data");
            QLog.d(i.this.getTAG(), 1, "unfollow request is failed");
        }

        @Override // com.tencent.mobileqq.applets.c.a
        public void d(Object unCheckResponseBody) {
            Intrinsics.checkNotNullParameter(unCheckResponseBody, "unCheckResponseBody");
            if (unCheckResponseBody instanceof oidb_cmd0xc96$RspBody) {
                if (QLog.isColorLevel()) {
                    QLog.d(i.this.getTAG(), 2, "0xc96 responseBody success, wording=", ((oidb_cmd0xc96$RspBody) unCheckResponseBody).wording.get());
                }
                JSONObject jSONObject = new JSONObject();
                String str = this.f79135b;
                if (str != null) {
                    try {
                        jSONObject.put("uin", str);
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(PublicAccountDetailActivityImpl.DOMAIN_MP_FIND);
                        arrayList.add(PublicAccountDetailActivityImpl.DOMAIN_MP_POST);
                        arrayList.add(PublicAccountDetailActivityImpl.DOMAIN_MP_ARTICLE);
                        com.tencent.mobileqq.jsp.h.w("unFollow", jSONObject, arrayList, null);
                    } catch (JSONException e16) {
                        e16.printStackTrace();
                    }
                }
                i.this.f2(this.f79135b);
                PublicAccountDataCardFragment dataCardFragment = i.this.getDataCardFragment();
                if (dataCardFragment != null) {
                    dataCardFragment.Ii(0);
                }
                QQAppInterface P1 = i.this.P1();
                Manager manager = P1 != null ? P1.getManager(QQManagerFactory.TROOP_BIND_PUBACCOUNT_MANAGER) : null;
                Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.troop.utils.TroopBindPublicAccountMgr");
                z zVar = (z) manager;
                PublicAccountDetailImpl accountDetail = i.this.getAccountDetail();
                zVar.b(accountDetail != null ? accountDetail.uin : null);
            }
        }

        @Override // com.tencent.mobileqq.applets.c.a
        public int e() {
            return 5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S1(i this$0, String uin, int i3, boolean z16, Bundle bundle) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(uin, "$uin");
        if (QLog.isColorLevel()) {
            QLog.d(this$0.TAG, 2, "follow isSuccess:" + z16);
        }
        if (z16) {
            JSONObject jSONObject = new JSONObject();
            PublicAccountDetailImpl publicAccountDetailImpl = this$0.accountDetail;
            if (publicAccountDetailImpl != null) {
                if (publicAccountDetailImpl != null) {
                    try {
                        str = publicAccountDetailImpl.uin;
                    } catch (JSONException e16) {
                        e16.printStackTrace();
                    }
                } else {
                    str = null;
                }
                jSONObject.put("uin", str);
                PublicAccountDetailImpl publicAccountDetailImpl2 = this$0.accountDetail;
                jSONObject.put("name", publicAccountDetailImpl2 != null ? publicAccountDetailImpl2.name : null);
                PublicAccountDetailImpl publicAccountDetailImpl3 = this$0.accountDetail;
                jSONObject.put("summary", publicAccountDetailImpl3 != null ? publicAccountDetailImpl3.summary : null);
                PublicAccountDetailImpl publicAccountDetailImpl4 = this$0.accountDetail;
                jSONObject.put("certified", publicAccountDetailImpl4 != null ? Integer.valueOf(publicAccountDetailImpl4.certifiedGrade) : null);
                ArrayList arrayList = new ArrayList();
                arrayList.add(PublicAccountDetailActivityImpl.DOMAIN_MP_FIND);
                arrayList.add(PublicAccountDetailActivityImpl.DOMAIN_MP_POST);
                arrayList.add(PublicAccountDetailActivityImpl.DOMAIN_MP_ARTICLE);
                com.tencent.mobileqq.jsp.h.w("follow", jSONObject, arrayList, null);
            }
            try {
                if (z16) {
                    byte[] byteArray = bundle.getByteArray("data");
                    if (byteArray != null) {
                        mobileqq_mp$FollowResponse mobileqq_mp_followresponse = new mobileqq_mp$FollowResponse();
                        mobileqq_mp_followresponse.mergeFrom(byteArray);
                        int i16 = mobileqq_mp_followresponse.ret_info.get().ret_code.get();
                        if (i16 == 0) {
                            PublicAccountDetailImpl publicAccountDetailImpl5 = this$0.accountDetail;
                            if (publicAccountDetailImpl5 != null && publicAccountDetailImpl5 != null) {
                                publicAccountDetailImpl5.followType = 1;
                            }
                            QLog.d(this$0.TAG, 1, "follow success uin:" + uin + ", retcode: " + i16);
                            Intent intent = this$0.mIntent;
                            if (intent != null) {
                                intent.hasExtra(IPublicAccountDetailActivity.REPORT_BUSINESS_TVALUE);
                                return;
                            }
                            return;
                        }
                        if (i16 == 58) {
                            QLog.d(this$0.TAG, 1, "follow error uin:" + uin + ", retcode: " + i16);
                            return;
                        }
                        if (i16 != 65) {
                            QLog.d(this$0.TAG, 1, "follow error uin:" + uin + ", retcode: " + i16);
                            return;
                        }
                        QLog.d(this$0.TAG, 1, "follow error uin:" + uin + ", retcode: " + i16);
                        return;
                    }
                    return;
                }
                QLog.d(this$0.TAG, 1, "follow failure uin: " + uin + ", ");
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e2(i this$0, String uin, int i3, boolean z16, Bundle bundle) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(uin, "$uin");
        QLog.d(this$0.TAG, 1, "unfollow isSuccess:" + z16);
        if (z16) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("uin", uin);
                ArrayList arrayList = new ArrayList();
                arrayList.add(PublicAccountDetailActivityImpl.DOMAIN_MP_FIND);
                arrayList.add(PublicAccountDetailActivityImpl.DOMAIN_MP_POST);
                arrayList.add(PublicAccountDetailActivityImpl.DOMAIN_MP_ARTICLE);
                com.tencent.mobileqq.jsp.h.w(IPublicAccountManager.SSO_COMMAND_GET_UNFOLLOW, jSONObject, arrayList, null);
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
            if (z16) {
                try {
                    byte[] byteArray = bundle.getByteArray("data");
                    if (byteArray != null) {
                        mobileqq_mp$UnFollowResponse mobileqq_mp_unfollowresponse = new mobileqq_mp$UnFollowResponse();
                        mobileqq_mp_unfollowresponse.mergeFrom(byteArray);
                        if (mobileqq_mp_unfollowresponse.ret_info.get().ret_code.get() == 0) {
                            QLog.d(this$0.TAG, 1, "unFollowResponse unfollow success");
                            this$0.f2(uin);
                            PublicAccountDataCardFragment publicAccountDataCardFragment = this$0.dataCardFragment;
                            if (publicAccountDataCardFragment != null) {
                                publicAccountDataCardFragment.Ii(0);
                            }
                            if (this$0.accountDetail != null) {
                                QQAppInterface P1 = this$0.P1();
                                Manager manager = P1 != null ? P1.getManager(QQManagerFactory.TROOP_BIND_PUBACCOUNT_MANAGER) : null;
                                Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.troop.utils.TroopBindPublicAccountMgr");
                                z zVar = (z) manager;
                                PublicAccountDetailImpl publicAccountDetailImpl = this$0.accountDetail;
                                zVar.b(publicAccountDetailImpl != null ? publicAccountDetailImpl.uin : null);
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g2(i this$0, String uin) {
        String str;
        String str2;
        String str3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(uin, "$uin");
        if (QLog.isColorLevel()) {
            QLog.d(this$0.TAG, 2, "updateUnfollowInfo");
        }
        PublicAccountDetailImpl publicAccountDetailImpl = this$0.accountDetail;
        if (publicAccountDetailImpl == null) {
            QLog.e(this$0.TAG, 1, "accountDetail is null!!!!");
            return;
        }
        if (TextUtils.isEmpty(publicAccountDetailImpl != null ? publicAccountDetailImpl.uid : null)) {
            String str4 = this$0.TAG;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("invalid uin, uid: ");
            PublicAccountDetailImpl publicAccountDetailImpl2 = this$0.accountDetail;
            sb5.append(publicAccountDetailImpl2 != null ? publicAccountDetailImpl2.uid : null);
            QLog.e(str4, 1, sb5.toString());
            return;
        }
        this$0.mHandler.sendEmptyMessage(2);
        PublicAccountDetailImpl publicAccountDetailImpl3 = this$0.accountDetail;
        final String str5 = publicAccountDetailImpl3 != null ? publicAccountDetailImpl3.uid : null;
        if (publicAccountDetailImpl3 != null && (str3 = publicAccountDetailImpl3.uid) != null) {
            IPublicAccountCommonMrg iPublicAccountCommonMrg = (IPublicAccountCommonMrg) QRoute.api(IPublicAccountCommonMrg.class);
            PublicAccountDetailImpl publicAccountDetailImpl4 = this$0.accountDetail;
            iPublicAccountCommonMrg.setTop(com.tencent.mobileqq.qcall.g.c(publicAccountDetailImpl4 != null ? publicAccountDetailImpl4.uin : null), str3, false, new IOperateCallback() { // from class: com.tencent.biz.pubaccount.accountdetail.model.h
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str6) {
                    i.h2(str5, i3, str6);
                }
            });
        }
        PublicAccountDetailImpl publicAccountDetailImpl5 = this$0.accountDetail;
        if (publicAccountDetailImpl5 != null && (str2 = publicAccountDetailImpl5.uid) != null) {
            ((IPublicAccountCommonMrg) QRoute.api(IPublicAccountCommonMrg.class)).markRead4PA(str2, null);
        }
        PublicAccountDetailImpl publicAccountDetailImpl6 = this$0.accountDetail;
        if (publicAccountDetailImpl6 != null && (str = publicAccountDetailImpl6.uid) != null) {
            ((IPublicAccountCommonMrg) QRoute.api(IPublicAccountCommonMrg.class)).clearMsgRecords4PA(str, null);
        }
        QQAppInterface P1 = this$0.P1();
        BusinessHandler businessHandler = P1 != null ? P1.getBusinessHandler(BusinessHandlerFactory.HANDLER_PUBLIC_ACCOUNT) : null;
        Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.biz.pubaccount.api.impl.PublicAccountHandlerImpl");
        PublicAccountHandlerImpl publicAccountHandlerImpl = (PublicAccountHandlerImpl) businessHandler;
        this$0.publicAccountHandler = publicAccountHandlerImpl;
        if (publicAccountHandlerImpl != null) {
            publicAccountHandlerImpl.onUnfollowPublicAccount(this$0.accountDetail);
        }
        this$0.Q1(this$0.accountDetail);
        if (TextUtils.equals(uin, IPublicAccountUtil.UIN_FOR_SHOP)) {
            ((IQQShopApi) QRoute.api(IQQShopApi.class)).afterUnFollowQQShop(2);
        }
        cc.a(" pubAcc_follow_cancel", null, uin);
    }

    public final QQAppInterface P1() {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime();
        Intrinsics.checkNotNullExpressionValue(waitAppRuntime, "sMobileQQ.waitAppRuntime()");
        if (waitAppRuntime instanceof QQAppInterface) {
            return (QQAppInterface) waitAppRuntime;
        }
        return null;
    }

    public final void R1(final String uin) {
        QQAppInterface P1;
        Intrinsics.checkNotNullParameter(uin, "uin");
        cc.a(null, "pubAcc_follow_confirm", uin);
        if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "follow uin=" + uin);
        }
        PublicAccountDetailImpl publicAccountDetailImpl = this.accountDetail;
        boolean z16 = false;
        if (publicAccountDetailImpl != null) {
            if (((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).getAccountType(publicAccountDetailImpl.accountFlag) == -4) {
                z16 = true;
            }
        }
        if (z16) {
            NewIntent newIntent = new NewIntent(this.mContext, PublicAccountServletImpl.class);
            this.followIntent = newIntent;
            newIntent.putExtra("cmd", "follow");
            mobileqq_mp$FollowRequest mobileqq_mp_followrequest = new mobileqq_mp$FollowRequest();
            mobileqq_mp_followrequest.ext.set("1");
            mobileqq_mp_followrequest.uin.set(((Integer) Long.valueOf(Long.parseLong(uin))).intValue());
            mobileqq_mp_followrequest.account_type.set(U1());
            NewIntent newIntent2 = this.followIntent;
            if (newIntent2 != null) {
                newIntent2.putExtra("data", mobileqq_mp_followrequest.toByteArray());
            }
            NewIntent newIntent3 = this.followIntent;
            if (newIntent3 != null) {
                newIntent3.putExtra("source", 1);
            }
            BusinessObserver businessObserver = new BusinessObserver() { // from class: com.tencent.biz.pubaccount.accountdetail.model.e
                @Override // mqq.observer.BusinessObserver
                public final void onReceive(int i3, boolean z17, Bundle bundle) {
                    i.S1(i.this, uin, i3, z17, bundle);
                }
            };
            this.followObserver = businessObserver;
            NewIntent newIntent4 = this.followIntent;
            if (newIntent4 != null) {
                newIntent4.setObserver(businessObserver);
            }
            QQAppInterface P12 = P1();
            if (P12 != null) {
                P12.startServlet(this.followIntent);
            }
        } else {
            if (this.newFollowObserver != null && (P1 = P1()) != null) {
                P1.removeObserver(this.newFollowObserver);
            }
            this.newFollowObserver = new com.tencent.mobileqq.applets.c(new a(uin));
            QQAppInterface P13 = P1();
            if (P13 != null) {
                P13.addObserver(this.newFollowObserver);
                PublicAccountDetailImpl publicAccountDetailImpl2 = this.accountDetail;
                com.tencent.mobileqq.applets.e.c(P13, true, publicAccountDetailImpl2 != null ? publicAccountDetailImpl2.uin : null, 1);
            }
        }
        ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).reportFollowEvent(P1(), uin, 1);
        if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "follow exit");
        }
    }

    /* renamed from: T1, reason: from getter */
    public final PublicAccountDetailImpl getAccountDetail() {
        return this.accountDetail;
    }

    protected final int U1() {
        return 1;
    }

    /* renamed from: W1, reason: from getter */
    public final PublicAccountDataCardFragment getDataCardFragment() {
        return this.dataCardFragment;
    }

    /* renamed from: X1, reason: from getter */
    public final String getTAG() {
        return this.TAG;
    }

    public final void Z1() {
        QQAppInterface P1;
        QQAppInterface P12;
        com.tencent.mobileqq.applets.c cVar = this.newUnFollowObserver;
        if (cVar != null && (P12 = P1()) != null) {
            P12.removeObserver(cVar);
        }
        com.tencent.mobileqq.applets.c cVar2 = this.newFollowObserver;
        if (cVar2 != null && (P1 = P1()) != null) {
            P1.removeObserver(cVar2);
        }
        NewIntent newIntent = this.unfollowIntent;
        if (newIntent != null) {
            newIntent.setObserver(null);
        }
        NewIntent newIntent2 = this.followIntent;
        if (newIntent2 != null) {
            newIntent2.setObserver(null);
        }
    }

    public final void a2(PublicAccountDetailImpl publicAccountDetailImpl) {
        this.accountDetail = publicAccountDetailImpl;
    }

    public final void b2(PublicAccountDataCardFragment publicAccountDataCardFragment) {
        this.dataCardFragment = publicAccountDataCardFragment;
    }

    public final void c2(String pUin, String uin) {
        String str;
        Intrinsics.checkNotNullParameter(pUin, "pUin");
        Intrinsics.checkNotNullParameter(uin, "uin");
        if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 1, "ActionSheet setOrCancelSetTop");
        }
        int uinType = ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).getUinType(P1(), uin);
        if (uinType == 1024) {
            QLog.d(this.TAG, 1, "setOrCancelTop pUin = " + pUin + " userType = " + uinType + " is UIN_TYPE_BUSINESS_CMR_TMP");
        }
        PublicAccountDetailImpl publicAccountDetailImpl = this.accountDetail;
        if (publicAccountDetailImpl != null) {
            if (!TextUtils.isEmpty(publicAccountDetailImpl != null ? publicAccountDetailImpl.uid : null)) {
                PublicAccountDetailImpl publicAccountDetailImpl2 = this.accountDetail;
                if (publicAccountDetailImpl2 == null || (str = publicAccountDetailImpl2.uid) == null) {
                    return;
                }
                ((IPublicAccountCommonMrg) QRoute.api(IPublicAccountCommonMrg.class)).getTopState(str, new c());
                return;
            }
        }
        QLog.e(this.TAG, 1, "setOrCancelSetTop detail or uid null!!!");
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void d2(final String uin) {
        boolean z16;
        QQAppInterface P1;
        Intrinsics.checkNotNullParameter(uin, "uin");
        cc.a(null, " pubAcc_follow_cancel", uin);
        QLog.d(this.TAG, 1, "card mode unfollow uin " + uin);
        PublicAccountDetailImpl publicAccountDetailImpl = this.accountDetail;
        if (publicAccountDetailImpl != null) {
            if (publicAccountDetailImpl != null) {
                if (((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).getAccountType(publicAccountDetailImpl.accountFlag) == -4) {
                    z16 = true;
                    if (!z16) {
                        if (this.newUnFollowObserver != null && (P1 = P1()) != null) {
                            P1.removeObserver(this.newUnFollowObserver);
                        }
                        this.newUnFollowObserver = new com.tencent.mobileqq.applets.c(new d(uin));
                        QQAppInterface P12 = P1();
                        if (P12 != null) {
                            P12.addObserver(this.newUnFollowObserver);
                        }
                        QQAppInterface P13 = P1();
                        if (P13 != null) {
                            PublicAccountDetailImpl publicAccountDetailImpl2 = this.accountDetail;
                            com.tencent.mobileqq.applets.e.c(P13, false, publicAccountDetailImpl2 != null ? publicAccountDetailImpl2.uin : null, 1);
                        }
                        ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).removeLbsUin(P1(), uin);
                        if (QLog.isColorLevel()) {
                            return;
                        }
                        QLog.d(this.TAG, 2, "unfollow exit");
                        return;
                    }
                }
            }
            z16 = false;
            if (!z16) {
            }
        }
        NewIntent newIntent = this.unfollowIntent;
        if (newIntent != null && newIntent != null) {
            newIntent.setObserver(null);
        }
        NewIntent newIntent2 = new NewIntent(this.mContext, PublicAccountServletImpl.class);
        this.unfollowIntent = newIntent2;
        newIntent2.putExtra("cmd", IPublicAccountManager.SSO_COMMAND_GET_UNFOLLOW);
        mobileqq_mp$UnFollowRequest mobileqq_mp_unfollowrequest = new mobileqq_mp$UnFollowRequest();
        mobileqq_mp_unfollowrequest.uin.set(((Integer) Long.valueOf(Long.parseLong(uin))).intValue());
        mobileqq_mp_unfollowrequest.account_type.set(U1());
        NewIntent newIntent3 = this.unfollowIntent;
        if (newIntent3 != null) {
            newIntent3.putExtra("data", mobileqq_mp_unfollowrequest.toByteArray());
        }
        NewIntent newIntent4 = this.unfollowIntent;
        if (newIntent4 != null) {
            newIntent4.putExtra("source", 1);
        }
        BusinessObserver businessObserver = new BusinessObserver() { // from class: com.tencent.biz.pubaccount.accountdetail.model.f
            @Override // mqq.observer.BusinessObserver
            public final void onReceive(int i3, boolean z17, Bundle bundle) {
                i.e2(i.this, uin, i3, z17, bundle);
            }
        };
        this.unfollowObserver = businessObserver;
        NewIntent newIntent5 = this.unfollowIntent;
        if (newIntent5 != null) {
            newIntent5.setObserver(businessObserver);
        }
        QQAppInterface P14 = P1();
        if (P14 != null) {
            P14.startServlet(this.unfollowIntent);
        }
        ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).removeLbsUin(P1(), uin);
        if (QLog.isColorLevel()) {
        }
    }

    protected final void f2(final String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        ThreadManager.getSubThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.biz.pubaccount.accountdetail.model.g
            @Override // java.lang.Runnable
            public final void run() {
                i.g2(i.this, uin);
            }
        }, 10L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h2(String str, int i3, String str2) {
        if (str != null) {
            ((IPublicAccountCommonMrg) QRoute.api(IPublicAccountCommonMrg.class)).deleteRecentContact4PA(str, (IOperateCallback) null);
        }
    }

    public final void Q1(PublicAccountDetailImpl detail) {
        com.tencent.mobileqq.persistence.l entityManagerFactory;
        if (detail == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "deleteAccount");
        }
        QQAppInterface P1 = P1();
        EntityManager createEntityManager = (P1 == null || (entityManagerFactory = P1.getEntityManagerFactory()) == null) ? null : entityManagerFactory.createEntityManager();
        if (createEntityManager != null) {
            createEntityManager.remove(detail);
        }
        if (createEntityManager != null) {
            createEntityManager.close();
        }
    }
}
