package com.tencent.mobileqq.sharepanel.channel;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.sharepanel.launcher.SharePanelParam;
import com.tencent.mobileqq.sharepanel.model.SharePanelContactItem;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00162\u00020\u0001:\u0001\rB\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0014\u0010\u0015J>\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u001a\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\nH\u0016R\"\u0010\u0012\u001a\u0010\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u000f0\u000f0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/channel/h;", "Lcom/tencent/mobileqq/sharepanel/channel/a;", "Lcom/tencent/mobileqq/sharepanel/launcher/SharePanelParam;", "sharePanelParam", "", "channelId", "Lcom/tencent/mobileqq/sharepanel/model/SharePanelContactItem;", "contact", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/selectmember/ResultRecord;", "Lkotlin/collections/ArrayList;", "selectedTargets", "", "a", "Ljava/lang/ref/WeakReference;", "Landroidx/fragment/app/FragmentActivity;", "kotlin.jvm.PlatformType", "Ljava/lang/ref/WeakReference;", "activityRef", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "<init>", "(Landroidx/fragment/app/FragmentActivity;)V", "b", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class h implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<FragmentActivity> activityRef;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/channel/h$a;", "", "", "FRAGMENT_TAG", "Ljava/lang/String;", "TAG", "<init>", "()V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.sharepanel.channel.h$a, reason: from kotlin metadata */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32931);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public h(@NotNull FragmentActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity);
        } else {
            this.activityRef = new WeakReference<>(activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007c A[Catch: Exception -> 0x008c, TryCatch #0 {Exception -> 0x008c, blocks: (B:11:0x0037, B:13:0x004f, B:15:0x0053, B:16:0x0056, B:18:0x0068, B:20:0x0070, B:25:0x007c, B:26:0x0082), top: B:10:0x0037 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void c(h this$0, SharePanelParam sharePanelParam, String channelId, SharePanelContactItem sharePanelContactItem, ArrayList arrayList) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(sharePanelParam, "$sharePanelParam");
        Intrinsics.checkNotNullParameter(channelId, "$channelId");
        FragmentActivity fragmentActivity = this$0.activityRef.get();
        if (fragmentActivity == null) {
            QLog.e("ShareChannelHandlerListenerImpl", 1, "handleChannel activity is null");
            return;
        }
        if (!fragmentActivity.isFinishing() && !fragmentActivity.isDestroyed()) {
            try {
                Fragment findFragmentByTag = fragmentActivity.getSupportFragmentManager().findFragmentByTag("ShareChannelHandlerFragment");
                FragmentTransaction beginTransaction = fragmentActivity.getSupportFragmentManager().beginTransaction();
                Intrinsics.checkNotNullExpressionValue(beginTransaction, "activity.supportFragmentManager.beginTransaction()");
                if (findFragmentByTag != null && (findFragmentByTag instanceof ShareChannelHandlerFragment)) {
                    beginTransaction.remove(findFragmentByTag);
                }
                ShareChannelHandlerFragment shareChannelHandlerFragment = new ShareChannelHandlerFragment(sharePanelParam);
                Bundle bundle = new Bundle();
                bundle.putString("channelId", channelId);
                if (sharePanelContactItem != null) {
                    bundle.putParcelable("contact", sharePanelContactItem);
                }
                if (arrayList != null && !arrayList.isEmpty()) {
                    z16 = false;
                    if (!z16) {
                        bundle.putParcelableArrayList("selectedTargets", arrayList);
                    }
                    shareChannelHandlerFragment.setArguments(bundle);
                    beginTransaction.add(shareChannelHandlerFragment, "ShareChannelHandlerFragment");
                    beginTransaction.commitAllowingStateLoss();
                    return;
                }
                z16 = true;
                if (!z16) {
                }
                shareChannelHandlerFragment.setArguments(bundle);
                beginTransaction.add(shareChannelHandlerFragment, "ShareChannelHandlerFragment");
                beginTransaction.commitAllowingStateLoss();
                return;
            } catch (Exception e16) {
                QLog.e("ShareChannelHandlerListenerImpl", 1, "handleChannel: ", e16);
                return;
            }
        }
        QLog.e("ShareChannelHandlerListenerImpl", 1, "handleChannel activity is invalid");
    }

    @Override // com.tencent.mobileqq.sharepanel.channel.a
    public void a(@NotNull final SharePanelParam sharePanelParam, @NotNull final String channelId, @Nullable final SharePanelContactItem contact, @Nullable final ArrayList<ResultRecord> selectedTargets) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, sharePanelParam, channelId, contact, selectedTargets);
            return;
        }
        Intrinsics.checkNotNullParameter(sharePanelParam, "sharePanelParam");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.sharepanel.channel.g
            @Override // java.lang.Runnable
            public final void run() {
                h.c(h.this, sharePanelParam, channelId, contact, selectedTargets);
            }
        }, 100L);
    }
}
