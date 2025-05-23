package com.tencent.mobileqq.contact.robot;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListAdapter;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.contact.robot.RobotContactFragment;
import com.tencent.mobileqq.contact.robot.d;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.ac;
import com.tencent.qqnt.kernel.api.m;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.RobotCoreInfo;
import com.tencent.qqnt.msg.f;
import com.tencent.robot.profile.api.IRobotProfileCardApi;
import com.tencent.theme.SkinEngine;
import com.tencent.widget.ListView;
import h44.OpenRobotProfileCardArgs;
import java.util.List;
import kotlin.C11736d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 02\u00020\u0001:\u000212B\u0007\u00a2\u0006\u0004\b.\u0010/J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u001a\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u0002H\u0016J\b\u0010\u0013\u001a\u00020\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u0002H\u0014J\b\u0010\u0016\u001a\u00020\u0002H\u0014J\u0018\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010%\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/contact/robot/RobotContactFragment;", "Lcom/tencent/mobileqq/activity/contacts/base/tabs/ContactsBaseFragment;", "", "Nh", "Lh", "Qh", "Lcom/tencent/qqnt/kernel/api/ac;", "Ph", "Landroid/view/LayoutInflater;", "inflater", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "uh", "", "tabChange", "rh", "qh", "doOnDestroy", "refresh", "resetData", "ph", "Ah", "isDefaultTheme", "", "tabHeight", OcrConfig.CHINESE, "Lcom/tencent/widget/ListView;", "N", "Lcom/tencent/widget/ListView;", "robotListView", "Lcom/tencent/mobileqq/contact/robot/d;", "P", "Lcom/tencent/mobileqq/contact/robot/d;", "robotAdapter", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/qqnt/kernel/api/ac;", "robotService", "", BdhLogUtil.LogTag.Tag_Req, "Ljava/lang/Long;", "robotListenerId", "Lcom/tencent/mobileqq/contact/robot/RobotContactFragment$RobotListener;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/contact/robot/RobotContactFragment$RobotListener;", "robotListener", "<init>", "()V", "T", "a", "RobotListener", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class RobotContactFragment extends ContactsBaseFragment {

    /* renamed from: N, reason: from kotlin metadata */
    private ListView robotListView;

    /* renamed from: P, reason: from kotlin metadata */
    private d robotAdapter;

    /* renamed from: Q, reason: from kotlin metadata */
    private ac robotService;

    /* renamed from: R, reason: from kotlin metadata */
    private Long robotListenerId;

    /* renamed from: S, reason: from kotlin metadata */
    private final RobotListener robotListener = new RobotListener(new WeakReference(this));

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/contact/robot/RobotContactFragment$RobotListener;", "Lcom/tencent/qqnt/kernel/listeneradapt/a;", "", "onRobotFriendListChanged", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/contact/robot/RobotContactFragment;", "a", "Lmqq/util/WeakReference;", "ref", "<init>", "(Lmqq/util/WeakReference;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class RobotListener extends com.tencent.qqnt.kernel.listeneradapt.a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<RobotContactFragment> ref;

        public RobotListener(WeakReference<RobotContactFragment> ref) {
            Intrinsics.checkNotNullParameter(ref, "ref");
            this.ref = ref;
        }

        @Override // com.tencent.qqnt.kernel.listeneradapt.a, com.tencent.qqnt.kernel.nativeinterface.IKernelRobotListener
        public void onRobotFriendListChanged() {
            C11736d.c(new Function0<Unit>() { // from class: com.tencent.mobileqq.contact.robot.RobotContactFragment$RobotListener$onRobotFriendListChanged$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    WeakReference weakReference;
                    ContactsBaseFragment.c cVar;
                    weakReference = RobotContactFragment.RobotListener.this.ref;
                    RobotContactFragment robotContactFragment = (RobotContactFragment) weakReference.get();
                    if (robotContactFragment != null) {
                        if (QLog.isColorLevel()) {
                            QLog.i("RobotContactFragment", 2, "onRobotFriendListChanged");
                        }
                        cVar = ((ContactsBaseFragment) robotContactFragment).C;
                        if (cVar != null) {
                            cVar.c(robotContactFragment.th(), true, null);
                        }
                        robotContactFragment.Lh();
                    }
                }
            });
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/contact/robot/RobotContactFragment$b", "Lcom/tencent/mobileqq/contact/robot/d$e;", "", "uin", "", "a", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class b implements d.e {
        b() {
        }

        @Override // com.tencent.mobileqq.contact.robot.d.e
        public void a(String uin) {
            Intrinsics.checkNotNullParameter(uin, "uin");
            Context context = RobotContactFragment.this.getContext();
            if (context != null) {
                ((IRobotProfileCardApi) QRoute.api(IRobotProfileCardApi.class)).openRobotProfileCard(new OpenRobotProfileCardArgs(context, uin, "", 0, 12, null, 32, null));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Lh() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.contact.robot.a
            @Override // java.lang.Runnable
            public final void run() {
                RobotContactFragment.Mh(RobotContactFragment.this);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Mh(RobotContactFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Qh();
    }

    private final void Nh() {
        QLog.i("RobotContactFragment", 1, "fetchData");
        m b16 = f.b();
        if (b16 != null) {
            b16.getBuddyList(true, new IOperateCallback() { // from class: com.tencent.mobileqq.contact.robot.b
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    RobotContactFragment.Oh(RobotContactFragment.this, i3, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oh(final RobotContactFragment this$0, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("RobotContactFragment", 1, "getBuddyList result:" + i3 + ", errMsg:" + str);
        if (i3 != 0) {
            C11736d.c(new Function0<Unit>() { // from class: com.tencent.mobileqq.contact.robot.RobotContactFragment$fetchData$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ContactsBaseFragment.c cVar;
                    cVar = ((ContactsBaseFragment) RobotContactFragment.this).C;
                    if (cVar != null) {
                        cVar.c(RobotContactFragment.this.th(), false, null);
                    }
                }
            });
        }
    }

    private final ac Ph() {
        ac robotService = ((IKernelService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "all")).getRobotService();
        if (robotService == null) {
            QLog.e("RobotContactFragment", 1, "getRobotService service is null");
        }
        return robotService;
    }

    private final void Qh() {
        ac Ph = Ph();
        final List<RobotCoreInfo> allRobotFriendsFromCache = Ph != null ? Ph.getAllRobotFriendsFromCache() : null;
        if (allRobotFriendsFromCache == null) {
            allRobotFriendsFromCache = CollectionsKt__CollectionsKt.emptyList();
        }
        QLog.i("RobotContactFragment", 1, "updateData size=" + allRobotFriendsFromCache.size());
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            d dVar = this.robotAdapter;
            if (dVar != null) {
                dVar.i(allRobotFriendsFromCache);
                return;
            }
            return;
        }
        C11736d.c(new Function0<Unit>() { // from class: com.tencent.mobileqq.contact.robot.RobotContactFragment$updateData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                d dVar2;
                dVar2 = RobotContactFragment.this.robotAdapter;
                if (dVar2 != null) {
                    dVar2.i(allRobotFriendsFromCache);
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    protected void Ah() {
        Long l3 = this.robotListenerId;
        if (l3 != null) {
            long longValue = l3.longValue();
            QLog.d("RobotContactFragment", 1, "removeObservers robotListenerId=" + this.robotListenerId);
            ac acVar = this.robotService;
            if (acVar != null) {
                acVar.removeKernelRobotListener(longValue);
            }
            this.robotService = null;
            this.robotListenerId = null;
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    protected void ph() {
        Long l3 = this.robotListenerId;
        if (l3 == null || (l3 != null && l3.longValue() == 0)) {
            ac Ph = Ph();
            this.robotService = Ph;
            Long valueOf = Ph != null ? Long.valueOf(Ph.addKernelRobotListener(this.robotListener)) : null;
            this.robotListenerId = valueOf;
            QLog.d("RobotContactFragment", 1, "addObservers robotListenerId=" + valueOf);
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    public void refresh() {
        Nh();
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    public void rh(boolean tabChange) {
        Lh();
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    protected View uh(LayoutInflater inflater, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        PinnedDividerListView pinnedDividerListView = new PinnedDividerListView(inflater.getContext());
        pinnedDividerListView.setDivider(null);
        pinnedDividerListView.setPadding(0, 0, 0, ViewUtils.dpToPx(56.0f));
        pinnedDividerListView.setSelector(R.color.ajr);
        b bVar = new b();
        QBaseActivity qBaseActivity = getQBaseActivity();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        d dVar = new d(bVar, qBaseActivity, peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null, pinnedDividerListView, false);
        this.robotAdapter = dVar;
        pinnedDividerListView.setAdapter((ListAdapter) dVar);
        pinnedDividerListView.setClipToPadding(false);
        this.robotListView = pinnedDividerListView;
        return pinnedDividerListView;
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    public void doOnDestroy() {
        QLog.d("RobotContactFragment", 1, "doOnDestroy");
        Ah();
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    public void zh(boolean isDefaultTheme, int tabHeight) {
        QLog.i("RobotContactFragment", 1, "onThemeChange");
        super.zh(isDefaultTheme, tabHeight);
        SkinEngine.invalidateAll(this.robotListView);
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    public void resetData() {
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    public void qh(boolean tabChange) {
    }
}
