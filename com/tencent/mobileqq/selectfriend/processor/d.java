package com.tencent.mobileqq.selectfriend.processor;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectfriend.api.IContentProcessorApi;
import com.tencent.mobileqq.selectfriend.callback.IConfirmDialogCancelClickCallback;
import com.tencent.mobileqq.selectfriend.callback.IConfirmDialogConfirmClickCallback;
import com.tencent.mobileqq.selectfriend.callback.IForwardFriendSelectCallback;
import com.tencent.mobileqq.selectfriend.model.a;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.constants.EventKey;
import com.tencent.util.QQToastUtil;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u0000 \f2\u00020\u00012\u00020\u0002:\u00010B\u0007\u00a2\u0006\u0004\bi\u0010jJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\n\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002J\u0012\u0010\u000f\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0012\u001a\u00020\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0018\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0014J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0006H\u0004J\u0018\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0014J\u001a\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J\b\u0010\u001c\u001a\u00020\u0003H\u0016J\u0010\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u0010\u0010!\u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u0010\u0010\"\u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\n\u0010#\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010$\u001a\u00020\u0003H\u0016J\n\u0010&\u001a\u0004\u0018\u00010%H\u0016J\b\u0010'\u001a\u00020\u0003H\u0016J\n\u0010)\u001a\u0004\u0018\u00010(H\u0016J\u0010\u0010,\u001a\u00020\u00032\u0006\u0010+\u001a\u00020*H\u0016J\b\u0010-\u001a\u00020\tH\u0014J\u0010\u0010/\u001a\u00020\u00032\u0006\u0010.\u001a\u00020\u0015H\u0016R$\u00106\u001a\u0004\u0018\u00010\r8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\"\u0010=\u001a\u00020\u00108\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R$\u0010D\u001a\u0004\u0018\u00010\u001d8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR$\u0010K\u001a\u0004\u0018\u00010(8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR*\u0010P\u001a\u0012\u0012\u0004\u0012\u00020\u00060Lj\b\u0012\u0004\u0012\u00020\u0006`M8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b,\u0010N\u001a\u0004\b\u0014\u0010OR$\u0010W\u001a\u0004\u0018\u00010Q8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR2\u0010_\u001a\u0012\u0012\u0004\u0012\u00020\u00150Xj\b\u0012\u0004\u0012\u00020\u0015`Y8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010Z\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\u0014\u0010c\u001a\u00020`8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\ba\u0010bR\u0014\u0010e\u001a\u00020`8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bd\u0010bR\u0014\u0010h\u001a\u00020\u00038DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\bf\u0010g\u00a8\u0006k"}, d2 = {"Lcom/tencent/mobileqq/selectfriend/processor/d;", "Lcom/tencent/mobileqq/selectfriend/processor/a;", "", "", UserInfo.SEX_FEMALE, "isSendFinish", "Lcom/tencent/mobileqq/selectmember/ResultRecord;", "resultRecord", "E", "", "H", "Lcom/tencent/mobileqq/selectfriend/model/a;", tl.h.F, "Landroid/app/Activity;", EventKey.ACT, "y", "Landroid/os/Bundle;", "extra", "G", "Landroid/content/DialogInterface;", "v", "", "which", "k", "D", "j", "isFinish", BdhLogUtil.LogTag.Tag_Conn, "B", "Landroid/content/Context;", "context", "", HippyTKDListViewAdapter.X, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "o", DomainData.DOMAIN_NAME, "p", "Landroid/view/View;", "g", "I", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "f", "Lcom/tencent/mobileqq/data/RecentUser;", "recentUser", "e", "i", "nodeType", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "a", "Landroid/app/Activity;", "r", "()Landroid/app/Activity;", "setMActivity", "(Landroid/app/Activity;)V", "mActivity", "b", "Landroid/os/Bundle;", "u", "()Landroid/os/Bundle;", "setMExtraData", "(Landroid/os/Bundle;)V", "mExtraData", "c", "Landroid/content/Context;", ReportConstant.COSTREPORT_PREFIX, "()Landroid/content/Context;", "setMAppContext", "(Landroid/content/Context;)V", "mAppContext", "d", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "t", "()Lcom/tencent/mobileqq/utils/QQCustomDialog;", "setMConfirmDialog", "(Lcom/tencent/mobileqq/utils/QQCustomDialog;)V", "mConfirmDialog", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "mForwardTargets", "Lcom/tencent/mobileqq/selectfriend/model/b;", "Lcom/tencent/mobileqq/selectfriend/model/b;", "w", "()Lcom/tencent/mobileqq/selectfriend/model/b;", "setMFsEventDelegate", "(Lcom/tencent/mobileqq/selectfriend/model/b;)V", "mFsEventDelegate", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "Ljava/util/HashSet;", "getMForwardNodes", "()Ljava/util/HashSet;", "setMForwardNodes", "(Ljava/util/HashSet;)V", "mForwardNodes", "Landroid/content/DialogInterface$OnClickListener;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/content/DialogInterface$OnClickListener;", "confirmListener", "l", "cancelListener", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "()Z", "isExitTarget2Send", "<init>", "()V", "qq_selectfriend_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public class d extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Activity mActivity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Bundle mExtraData;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Context mAppContext;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QQCustomDialog mConfirmDialog;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<ResultRecord> mForwardTargets;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.selectfriend.model.b mFsEventDelegate;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private HashSet<Integer> mForwardNodes;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/selectfriend/processor/d$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq_selectfriend_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.selectfriend.processor.d$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/selectfriend/processor/d$b", "Lcom/tencent/mobileqq/selectfriend/callback/a;", "", "code", "", "msg", "", "a", "qq_selectfriend_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes18.dex */
    public static final class b implements com.tencent.mobileqq.selectfriend.callback.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f285507a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f285508b;

        b(boolean z16, d dVar) {
            this.f285507a = z16;
            this.f285508b = dVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), dVar);
            }
        }

        @Override // com.tencent.mobileqq.selectfriend.callback.a
        public void a(int code, @NotNull String msg2) {
            IForwardFriendSelectCallback c16;
            IForwardFriendSelectCallback c17;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, code, (Object) msg2);
                return;
            }
            Intrinsics.checkNotNullParameter(msg2, "msg");
            if (!this.f285507a) {
                return;
            }
            if (code == 0) {
                QQToastUtil.showQQToast(2, R.string.f1357402_, 0);
                com.tencent.mobileqq.selectfriend.model.b w3 = this.f285508b.w();
                if (w3 != null && (c17 = w3.c()) != null) {
                    c17.a(0, "");
                    return;
                }
                return;
            }
            QQToastUtil.showQQToast(2, R.string.f13573029, 0);
            com.tencent.mobileqq.selectfriend.model.b w16 = this.f285508b.w();
            if (w16 != null && (c16 = w16.c()) != null) {
                c16.a(1, "");
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22941);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 34)) {
            redirector.redirect((short) 34);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mExtraData = new Bundle();
        this.mForwardTargets = new ArrayList<>();
        this.mForwardNodes = new HashSet<>();
    }

    private final boolean E(boolean isSendFinish, ResultRecord resultRecord) {
        C(isSendFinish, resultRecord);
        return true;
    }

    private final boolean F() {
        if (!z()) {
            if (QLog.isColorLevel()) {
                QLog.d("ForwardBaseProcessor", 2, "!isExitTarget2Send");
            }
            return false;
        }
        int size = this.mForwardTargets.size();
        for (int i3 = 0; i3 < size; i3++) {
            ResultRecord resultRecord = this.mForwardTargets.get(i3);
            Intrinsics.checkNotNullExpressionValue(resultRecord, "mForwardTargets[i]");
            ResultRecord resultRecord2 = resultRecord;
            if (B()) {
                D(resultRecord2);
            }
            if (i3 == size - 1) {
                E(true, resultRecord2);
            } else {
                E(false, resultRecord2);
            }
        }
        return true;
    }

    private final void H() {
        if (!z()) {
            return;
        }
        Iterator<ResultRecord> it = this.mForwardTargets.iterator();
        while (it.hasNext()) {
            ResultRecord next = it.next();
            ((IContentProcessorApi) QRoute.api(IContentProcessorApi.class)).saveForwardRecord(next.uin, String.valueOf(next.uinType), next.uinType, next.guildId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(d this$0, DialogInterface v3, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(v3, "v");
        this$0.j(v3, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(d this$0, DialogInterface v3, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(v3, "v");
        this$0.k(v3, i3);
    }

    private final com.tencent.mobileqq.selectfriend.model.a h() {
        if (this.mActivity == null) {
            return null;
        }
        a.C8561a n3 = new a.C8561a().p(p()).m(g()).n(n());
        Activity activity = this.mActivity;
        Intrinsics.checkNotNull(activity);
        a.C8561a o16 = n3.o(o(activity));
        Activity activity2 = this.mActivity;
        Intrinsics.checkNotNull(activity2);
        a.C8561a q16 = o16.q(q(activity2));
        Activity activity3 = this.mActivity;
        Intrinsics.checkNotNull(activity3);
        return q16.r(x(activity3)).l(m()).k(l()).s(this.mForwardTargets).a();
    }

    private final DialogInterface.OnClickListener l() {
        return new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.selectfriend.processor.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                d.c(d.this, dialogInterface, i3);
            }
        };
    }

    private final DialogInterface.OnClickListener m() {
        return new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.selectfriend.processor.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                d.d(d.this, dialogInterface, i3);
            }
        };
    }

    public boolean A(int nodeType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Boolean) iPatchRedirector.redirect((short) 33, (Object) this, nodeType)).booleanValue();
        }
        return this.mForwardNodes.contains(Integer.valueOf(nodeType));
    }

    public boolean B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this)).booleanValue();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean C(boolean isFinish, @Nullable ResultRecord resultRecord) {
        Integer num;
        Integer num2;
        RecyclerView.Adapter<?> adapter;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, this, Boolean.valueOf(isFinish), resultRecord)).booleanValue();
        }
        if (resultRecord != null) {
            num = Integer.valueOf(resultRecord.uinType);
        } else {
            num = null;
        }
        Activity activity = this.mActivity;
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.tencent.mobileqq.activity.QPublicFragmentActivity");
        List<RecyclerView.Adapter<?>> forwardNodeAdapter = ((IContentProcessorApi) QRoute.api(IContentProcessorApi.class)).getForwardNodeAdapter((QPublicFragmentActivity) activity);
        if (forwardNodeAdapter != null) {
            num2 = Integer.valueOf(forwardNodeAdapter.size());
        } else {
            num2 = null;
        }
        if (num2 != null && num2.intValue() > 0) {
            int intValue = num2.intValue();
            for (int i3 = 0; i3 < intValue; i3++) {
                if (forwardNodeAdapter != null) {
                    adapter = forwardNodeAdapter.get(i3);
                } else {
                    adapter = null;
                }
                if (adapter instanceof com.tencent.mobileqq.selectfriend.adapter.a) {
                    com.tencent.mobileqq.selectfriend.adapter.a aVar = (com.tencent.mobileqq.selectfriend.adapter.a) adapter;
                    Integer valueOf = Integer.valueOf(aVar.supportMsgToNodeUinType());
                    if (Intrinsics.areEqual(num, valueOf) || valueOf.intValue() == com.tencent.mobileqq.selectfriend.constant.a.INSTANCE.b()) {
                        aVar.sendToNode(this.mActivity, this.mExtraData, new b(isFinish, this));
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void D(@NotNull ResultRecord resultRecord) {
        String str;
        int[] iArr;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) resultRecord);
            return;
        }
        Intrinsics.checkNotNullParameter(resultRecord, "resultRecord");
        QQCustomDialog qQCustomDialog = this.mConfirmDialog;
        if (qQCustomDialog != null) {
            str = qQCustomDialog.getInputValue();
        } else {
            str = null;
        }
        int forwardId = ((IContentProcessorApi) QRoute.api(IContentProcessorApi.class)).getForwardId();
        if (!TextUtils.isEmpty(str)) {
            int[] intArray = this.mExtraData.getIntArray("KEY_MSG_FORWARD_ID_ARRAY");
            this.mExtraData.remove("KEY_MSG_FORWARD_ID_ARRAY");
            if (intArray != null) {
                iArr = new int[intArray.length + 1];
                if (intArray.length == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (true ^ z16) {
                    System.arraycopy(intArray, 0, iArr, 0, intArray.length);
                }
                iArr[intArray.length] = forwardId;
            } else {
                iArr = new int[]{forwardId};
            }
            this.mExtraData.putIntArray("KEY_MSG_FORWARD_ID_ARRAY", iArr);
            this.mExtraData.putString(AppConstants.Key.SHARE_RES_COMMENT_MESSAGE, str);
            ((IContentProcessorApi) QRoute.api(IContentProcessorApi.class)).sendMessage(this.mExtraData, resultRecord);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x008b, code lost:
    
        if (r1 == false) goto L41;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void G(@Nullable Bundle extra) {
        boolean z16;
        ArrayList arrayList;
        QQCustomDialog f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) extra);
            return;
        }
        QQCustomDialog qQCustomDialog = this.mConfirmDialog;
        boolean z17 = true;
        if (qQCustomDialog != null && qQCustomDialog.isShowing()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        this.mExtraData.putAll(extra);
        Bundle bundle = this.mExtraData;
        if (bundle != null) {
            arrayList = bundle.getParcelableArrayList("selected_target_list");
        } else {
            arrayList = null;
        }
        if (arrayList != null) {
            this.mForwardTargets.clear();
            this.mForwardTargets.addAll(arrayList);
        } else {
            ArrayList parcelableArrayList = this.mExtraData.getParcelableArrayList(AppConstants.Key.FORWARD_MULTI_TARGET);
            if (parcelableArrayList != null) {
                this.mForwardTargets.clear();
                this.mForwardTargets.addAll(parcelableArrayList);
            }
        }
        com.tencent.mobileqq.selectfriend.model.a h16 = h();
        if (I()) {
            if (this.mActivity == null) {
                return;
            }
            IContentProcessorApi iContentProcessorApi = (IContentProcessorApi) QRoute.api(IContentProcessorApi.class);
            Activity activity = this.mActivity;
            Intrinsics.checkNotNull(activity);
            f16 = iContentProcessorApi.getForwardDefaultDialog(activity, h16);
        } else {
            f16 = f();
        }
        this.mConfirmDialog = f16;
        if (f16 != null) {
            if (f16 != null) {
                if (f16 == null || !f16.isShowing()) {
                    z17 = false;
                }
            }
            if (this.mActivity != null && this.mForwardTargets.size() != 0) {
                QQCustomDialog qQCustomDialog2 = this.mConfirmDialog;
                if (qQCustomDialog2 != null) {
                    qQCustomDialog2.show();
                    return;
                }
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("ForwardBaseProcessor", 2, " mConfirmDialog exist ||  null == mActivity || mForwardTargets.size() == 0");
        }
    }

    public boolean I() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Boolean) iPatchRedirector.redirect((short) 29, (Object) this)).booleanValue();
        }
        return true;
    }

    public boolean e(@NotNull RecentUser recentUser) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Boolean) iPatchRedirector.redirect((short) 31, (Object) this, (Object) recentUser)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(recentUser, "recentUser");
        return true;
    }

    @Nullable
    public QQCustomDialog f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (QQCustomDialog) iPatchRedirector.redirect((short) 30, (Object) this);
        }
        return null;
    }

    @Nullable
    public View g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (View) iPatchRedirector.redirect((short) 28, (Object) this);
        }
        return null;
    }

    protected void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this);
        } else {
            this.mForwardNodes.add(1);
            this.mForwardNodes.add(10000);
        }
    }

    protected void j(@NotNull DialogInterface v3, int which) {
        IConfirmDialogCancelClickCallback a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) v3, which);
            return;
        }
        Intrinsics.checkNotNullParameter(v3, "v");
        this.mForwardTargets.clear();
        com.tencent.mobileqq.selectfriend.model.b bVar = this.mFsEventDelegate;
        if (bVar != null && (a16 = bVar.a()) != null) {
            a16.a(v3);
        }
    }

    protected void k(@NotNull DialogInterface v3, int which) {
        com.tencent.mobileqq.selectfriend.model.b bVar;
        IConfirmDialogConfirmClickCallback b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) v3, which);
            return;
        }
        Intrinsics.checkNotNullParameter(v3, "v");
        H();
        if (F() && (bVar = this.mFsEventDelegate) != null && (b16 = bVar.b()) != null) {
            b16.a(v3);
        }
    }

    @Nullable
    public String n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (String) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        return null;
    }

    @NotNull
    public String o(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (String) iPatchRedirector.redirect((short) 25, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        String string = context.getResources().getString(R.string.zr7);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026.string.dialog_edit_hint)");
        return string;
    }

    public boolean p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this)).booleanValue();
        }
        return true;
    }

    @NotNull
    public String q(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (String) iPatchRedirector.redirect((short) 24, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        String string = context.getResources().getString(R.string.zrf);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026ing.dialog_left_btn_text)");
        return string;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final Activity r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Activity) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final Context s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Context) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.mAppContext;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final QQCustomDialog t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (QQCustomDialog) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.mConfirmDialog;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final Bundle u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Bundle) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mExtraData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final ArrayList<ResultRecord> v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (ArrayList) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.mForwardTargets;
    }

    @Nullable
    protected final com.tencent.mobileqq.selectfriend.model.b w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (com.tencent.mobileqq.selectfriend.model.b) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.mFsEventDelegate;
    }

    @NotNull
    public String x(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (String) iPatchRedirector.redirect((short) 23, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        String string = context.getResources().getString(R.string.zrn);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026ng.dialog_right_btn_text)");
        return string;
    }

    public void y(@Nullable Activity act) {
        Intent intent;
        Intent intent2;
        Bundle extras;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) act);
            return;
        }
        this.mActivity = act;
        this.mAppContext = act;
        if (act == null) {
            return;
        }
        i();
        Activity activity = this.mActivity;
        Object obj = null;
        if (activity != null) {
            intent = activity.getIntent();
        } else {
            intent = null;
        }
        if (intent == null) {
            return;
        }
        if (act != null && (intent2 = act.getIntent()) != null && (extras = intent2.getExtras()) != null) {
            obj = extras.get("fs_forward_event_obj");
        }
        com.tencent.mobileqq.selectfriend.model.b bVar = (com.tencent.mobileqq.selectfriend.model.b) obj;
        if (bVar == null) {
            return;
        }
        this.mFsEventDelegate = bVar;
    }

    protected final boolean z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this)).booleanValue();
        }
        ArrayList<ResultRecord> arrayList = this.mForwardTargets;
        if (arrayList != null && arrayList.size() > 0) {
            return true;
        }
        return false;
    }
}
