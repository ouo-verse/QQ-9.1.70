package com.tencent.qqnt.aio.helper;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils;
import com.tencent.mobileqq.aio.event.AIOTitleEvent;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.helper.CallHelper$mBuddyListListener$2;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.CoreInfo;
import com.tencent.qqnt.kernel.nativeinterface.UserSimpleInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000m\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001*\b\u0007\u0018\u0000 62\u00020\u00012\u00020\u0002:\u0001 B\u0007\u00a2\u0006\u0004\b4\u00105J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\u001a\u0010\u0010\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u000eH\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0013H\u0016J\u0006\u0010\u001d\u001a\u00020\u0005J\b\u0010\u001e\u001a\u00020\u0005H\u0016J\u0012\u0010 \u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u000eH\u0016R\u001e\u0010%\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u001b\u0010/\u001a\u00020*8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0014\u00103\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102\u00a8\u00067"}, d2 = {"Lcom/tencent/qqnt/aio/helper/CallHelper;", "Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/mobileqq/app/LBSHandler$a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/qqnt/kernel/api/y;", "k", "", "uin", "", "nick", "t", "", DomainData.DOMAIN_NAME, "", "getId", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "state", "onMoveToState", "p", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "content", "a", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/aio/api/runtime/a;", "d", "Ljava/lang/ref/WeakReference;", "mAIOContext", "Landroid/app/Dialog;", "e", "Landroid/app/Dialog;", "mAddFriendDialog", "com/tencent/qqnt/aio/helper/CallHelper$mBuddyListListener$2$a", "f", "Lkotlin/Lazy;", "j", "()Lcom/tencent/qqnt/aio/helper/CallHelper$mBuddyListListener$2$a;", "mBuddyListListener", "Lcom/tencent/mvi/base/route/a;", tl.h.F, "Lcom/tencent/mvi/base/route/a;", "mAction1", "<init>", "()V", "i", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes34.dex */
public final class CallHelper implements com.tencent.aio.main.businesshelper.h, LBSHandler.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private WeakReference<com.tencent.aio.api.runtime.a> mAIOContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Dialog mAddFriendDialog;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Lazy mBuddyListListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.mvi.base.route.a mAction1;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/qqnt/aio/helper/CallHelper$b", "Lcom/tencent/mvi/base/route/a;", "", "sticky", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            CallHelper.this.m(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return false;
        }
    }

    public CallHelper() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<CallHelper$mBuddyListListener$2.a>() { // from class: com.tencent.qqnt.aio.helper.CallHelper$mBuddyListListener$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final a invoke() {
                return new a(CallHelper.this);
            }

            /* compiled from: P */
            @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J8\u0010\b\u001a\u00020\u00072.\u0010\u0006\u001a*\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0002j\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/qqnt/aio/helper/CallHelper$mBuddyListListener$2$a", "Lcom/tencent/qqnt/aio/helper/dc;", "Ljava/util/HashMap;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/UserSimpleInfo;", "Lkotlin/collections/HashMap;", "profiles", "", "onProfileSimpleChanged", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes34.dex */
            public static final class a extends dc {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ CallHelper f350297d;

                a(CallHelper callHelper) {
                    this.f350297d = callHelper;
                }

                /* JADX WARN: Code restructure failed: missing block: B:35:0x006f, code lost:
                
                    r5 = r0.k();
                 */
                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelProfileListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onProfileSimpleChanged(HashMap<String, UserSimpleInfo> profiles) {
                    WeakReference weakReference;
                    Unit unit;
                    com.tencent.qqnt.kernel.api.y k3;
                    List listOf;
                    com.tencent.aio.api.runtime.a aVar;
                    AIOParam g16;
                    AIOSession r16;
                    AIOContact c16;
                    if (profiles == null) {
                        return;
                    }
                    for (Map.Entry<String, UserSimpleInfo> entry : profiles.entrySet()) {
                        String key = entry.getKey();
                        UserSimpleInfo value = entry.getValue();
                        weakReference = this.f350297d.mAIOContext;
                        Unit unit2 = null;
                        if (Intrinsics.areEqual(key, (weakReference == null || (aVar = (com.tencent.aio.api.runtime.a) weakReference.get()) == null || (g16 = aVar.g()) == null || (r16 = g16.r()) == null || (c16 = r16.c()) == null) ? null : c16.j())) {
                            if (value != null) {
                                CoreInfo coreInfo = value.coreInfo;
                                if (coreInfo != null) {
                                    this.f350297d.t(value.uin, coreInfo.nick);
                                    unit = Unit.INSTANCE;
                                } else {
                                    unit = null;
                                }
                                if (unit == null) {
                                    CallHelper callHelper = this.f350297d;
                                    if (key != null && k3 != null) {
                                        listOf = CollectionsKt__CollectionsJVMKt.listOf(key);
                                        HashMap<String, UserSimpleInfo> coreAndBaseInfo = k3.getCoreAndBaseInfo("CallHelper", new ArrayList<>(listOf));
                                        if (coreAndBaseInfo != null) {
                                            if (coreAndBaseInfo.containsKey(key)) {
                                                UserSimpleInfo userSimpleInfo = coreAndBaseInfo.get(key);
                                                if (userSimpleInfo == null) {
                                                    QLog.i("CallHelper", 1, "coreInfo is null uid:" + key);
                                                    return;
                                                }
                                                Intrinsics.checkNotNullExpressionValue(userSimpleInfo, "coreMap[it] ?:let {\n    \u2026                        }");
                                                callHelper.t(userSimpleInfo.uin, userSimpleInfo.coreInfo.nick);
                                            }
                                            unit2 = Unit.INSTANCE;
                                        }
                                    }
                                    if (unit2 == null) {
                                        QLog.i("CallHelper", 1, "uid is null");
                                    }
                                } else {
                                    continue;
                                }
                            } else {
                                QLog.i("CallHelper", 1, "info is null is null uid:" + key);
                            }
                        }
                    }
                }
            }
        });
        this.mBuddyListListener = lazy;
        this.mAction1 = new b();
    }

    private final CallHelper$mBuddyListListener$2.a j() {
        return (CallHelper$mBuddyListListener$2.a) this.mBuddyListListener.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.qqnt.kernel.api.y k() {
        IKernelService iKernelService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null || (iKernelService = (IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")) == null) {
            return null;
        }
        return iKernelService.getProfileService();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(MsgIntent intent) {
        if (intent instanceof AIOTitleEvent.Right2IvClickEvent) {
            o();
        }
    }

    private final boolean n() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("105916", false);
    }

    private final void o() {
        com.tencent.aio.api.runtime.a aVar;
        AIOParam g16;
        Bundle l3;
        com.tencent.aio.api.runtime.a aVar2;
        AIOParam g17;
        com.tencent.aio.api.runtime.a aVar3;
        AIOParam g18;
        AIOSession r16;
        AIOContact c16;
        com.tencent.aio.api.runtime.a aVar4;
        Fragment c17;
        WeakReference<com.tencent.aio.api.runtime.a> weakReference = this.mAIOContext;
        String str = null;
        FragmentActivity requireActivity = (weakReference == null || (aVar4 = weakReference.get()) == null || (c17 = aVar4.c()) == null) ? null : c17.requireActivity();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
        SessionInfo sessionInfo = new SessionInfo();
        WeakReference<com.tencent.aio.api.runtime.a> weakReference2 = this.mAIOContext;
        Integer valueOf = (weakReference2 == null || (aVar3 = weakReference2.get()) == null || (g18 = aVar3.g()) == null || (r16 = g18.r()) == null || (c16 = r16.c()) == null) ? null : Integer.valueOf(c16.e());
        Intrinsics.checkNotNull(valueOf);
        sessionInfo.f179555d = com.tencent.nt.adapter.session.c.c(valueOf.intValue());
        WeakReference<com.tencent.aio.api.runtime.a> weakReference3 = this.mAIOContext;
        String valueOf2 = String.valueOf((weakReference3 == null || (aVar2 = weakReference3.get()) == null || (g17 = aVar2.g()) == null) ? null : Long.valueOf(su3.c.a(g17)));
        sessionInfo.f179557e = valueOf2;
        String s16 = com.tencent.mobileqq.utils.ac.s(qQAppInterface, valueOf2, sessionInfo.f179559f, com.tencent.mobileqq.utils.ac.w(sessionInfo.f179555d), 3);
        sessionInfo.f179563i = s16;
        if (TextUtils.isEmpty(s16) || sessionInfo.f179563i.equals(sessionInfo.f179557e)) {
            WeakReference<com.tencent.aio.api.runtime.a> weakReference4 = this.mAIOContext;
            if (weakReference4 != null && (aVar = weakReference4.get()) != null && (g16 = aVar.g()) != null && (l3 = g16.l()) != null) {
                str = l3.getString("nick_" + sessionInfo.f179557e);
            }
            QLog.d("CallHelper", 1, "onClockClick new Nick=" + str);
            if (!TextUtils.isEmpty(str)) {
                sessionInfo.f179563i = str;
            }
        }
        PlusPanelUtils.k(qQAppInterface, requireActivity, sessionInfo, this);
    }

    private final void q() {
        com.tencent.qqnt.kernel.api.y k3 = k();
        if (k3 != null) {
            k3.r0(j());
        }
        if (k() == null) {
            QLog.d("CallHelper", 1, "registerBuddyInfoListener getBuddyService is null.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(CallHelper this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Dialog dialog = this$0.mAddFriendDialog;
        if (dialog != null) {
            Intrinsics.checkNotNull(dialog);
            if (dialog.isShowing()) {
                Dialog dialog2 = this$0.mAddFriendDialog;
                Intrinsics.checkNotNull(dialog2);
                dialog2.dismiss();
            }
        }
    }

    private final void s() {
        com.tencent.qqnt.kernel.api.y k3 = k();
        if (k3 != null) {
            k3.D0(j());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(CallHelper this$0, long j3, String it) {
        com.tencent.aio.api.runtime.a aVar;
        AIOParam g16;
        Bundle l3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "$it");
        WeakReference<com.tencent.aio.api.runtime.a> weakReference = this$0.mAIOContext;
        if (weakReference == null || (aVar = weakReference.get()) == null || (g16 = aVar.g()) == null || (l3 = g16.l()) == null) {
            return;
        }
        l3.putString("nick_" + j3, it);
    }

    @Override // com.tencent.mobileqq.app.LBSHandler.a
    public void a(String content) {
        com.tencent.aio.api.runtime.a aVar;
        Fragment c16;
        WeakReference<com.tencent.aio.api.runtime.a> weakReference = this.mAIOContext;
        FragmentActivity requireActivity = (weakReference == null || (aVar = weakReference.get()) == null || (c16 = aVar.c()) == null) ? null : c16.requireActivity();
        if (this.mAddFriendDialog == null) {
            Dialog N2 = LBSHandler.N2(requireActivity, content, new DialogInterface.OnClickListener() { // from class: com.tencent.qqnt.aio.helper.aj
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    CallHelper.r(CallHelper.this, dialogInterface, i3);
                }
            }, null);
            this.mAddFriendDialog = N2;
            Intrinsics.checkNotNull(N2);
            View findViewById = N2.findViewById(R.id.dialogRightBtn);
            Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
            ((TextView) findViewById).setText(requireActivity != null ? requireActivity.getString(R.string.f171151ok) : null);
        }
        Dialog dialog = this.mAddFriendDialog;
        if (dialog != null) {
            Intrinsics.checkNotNull(dialog);
            if (dialog.isShowing() || requireActivity == null || requireActivity.isFinishing()) {
                return;
            }
            Dialog dialog2 = this.mAddFriendDialog;
            Intrinsics.checkNotNull(dialog2);
            View findViewById2 = dialog2.findViewById(R.id.dialogText);
            Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
            ((TextView) findViewById2).setText(content);
            Dialog dialog3 = this.mAddFriendDialog;
            Intrinsics.checkNotNull(dialog3);
            dialog3.show();
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.f350634g;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public String getTag() {
        return "CallHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(com.tencent.aio.main.businesshelper.b param) {
        com.tencent.mvi.base.route.j e16;
        Intrinsics.checkNotNullParameter(param, "param");
        WeakReference<com.tencent.aio.api.runtime.a> weakReference = new WeakReference<>(param.a());
        this.mAIOContext = weakReference;
        com.tencent.aio.api.runtime.a aVar = weakReference.get();
        if (aVar != null && (e16 = aVar.e()) != null) {
            e16.d(Reflection.getOrCreateKotlinClass(AIOTitleEvent.Right2IvClickEvent.class).getQualifiedName(), this.mAction1);
        }
        q();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        com.tencent.aio.api.runtime.a aVar;
        com.tencent.mvi.base.route.j e16;
        h.a.b(this);
        WeakReference<com.tencent.aio.api.runtime.a> weakReference = this.mAIOContext;
        if (weakReference != null && (aVar = weakReference.get()) != null && (e16 = aVar.e()) != null) {
            e16.b(Reflection.getOrCreateKotlinClass(AIOTitleEvent.Right2IvClickEvent.class).getQualifiedName(), this.mAction1);
        }
        s();
        Dialog dialog = this.mAddFriendDialog;
        if (dialog != null) {
            Intrinsics.checkNotNull(dialog);
            if (dialog.isShowing()) {
                Dialog dialog2 = this.mAddFriendDialog;
                Intrinsics.checkNotNull(dialog2);
                dialog2.dismiss();
                this.mAddFriendDialog = null;
            }
        }
    }

    public final void p() {
        com.tencent.aio.api.runtime.a aVar;
        com.tencent.mvi.base.route.j e16;
        com.tencent.aio.api.runtime.a aVar2;
        com.tencent.mvi.base.route.j e17;
        if (!n()) {
            Drawable drawable = BaseApplication.getContext().getDrawable(R.drawable.qui_telephone_icon_nav_secondary);
            WeakReference<com.tencent.aio.api.runtime.a> weakReference = this.mAIOContext;
            if (weakReference == null || (aVar2 = weakReference.get()) == null || (e17 = aVar2.e()) == null) {
                return;
            }
            e17.h(new AIOTitleEvent.UpdateRight2IvEvent(false, true, drawable, 1, "0"));
            return;
        }
        WeakReference<com.tencent.aio.api.runtime.a> weakReference2 = this.mAIOContext;
        if (weakReference2 == null || (aVar = weakReference2.get()) == null || (e16 = aVar.e()) == null) {
            return;
        }
        e16.h(new AIOTitleEvent.UpdateRight2IvEvent(false, true, null, 1, "0"));
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public int[] interestedIn() {
        return new int[]{3, 12};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(final long uin, final String nick) {
        if (nick != null) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqnt.aio.helper.ak
                @Override // java.lang.Runnable
                public final void run() {
                    CallHelper.u(CallHelper.this, uin, nick);
                }
            });
        }
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        if (state == 3) {
            p();
        } else {
            if (state != 12) {
                return;
            }
            onDestroy();
        }
    }
}
