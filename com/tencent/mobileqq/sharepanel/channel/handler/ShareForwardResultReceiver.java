package com.tencent.mobileqq.sharepanel.channel.handler;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u001b\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\u0004\b\u0016\u0010\u0017J \u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0014R\u001c\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000f\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/channel/handler/ShareForwardResultReceiver;", "Landroid/os/ResultReceiver;", "Landroid/os/Bundle;", "extra", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/selectmember/ResultRecord;", "Lkotlin/collections/ArrayList;", "b", "", QzoneIPCModule.RESULT_CODE, "resultData", "", "onReceiveResult", "Lmqq/util/WeakReference;", "d", "Lmqq/util/WeakReference;", "weakBaseReceiver", "Lcom/tencent/mobileqq/sharepanel/channel/handler/a;", "e", "weakCallback", "baseReceiver", "callback", "<init>", "(Landroid/os/ResultReceiver;Lcom/tencent/mobileqq/sharepanel/channel/handler/a;)V", "f", "a", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class ShareForwardResultReceiver extends ResultReceiver {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<ResultReceiver> weakBaseReceiver;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WeakReference<a> weakCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/sharepanel/channel/handler/ShareForwardResultReceiver$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-sharepanel-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.sharepanel.channel.handler.ShareForwardResultReceiver$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32983);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ShareForwardResultReceiver(@Nullable ResultReceiver resultReceiver, @Nullable a aVar) {
        super(new Handler(Looper.getMainLooper()));
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) resultReceiver, (Object) aVar);
        } else {
            this.weakBaseReceiver = new WeakReference<>(resultReceiver);
            this.weakCallback = new WeakReference<>(aVar);
        }
    }

    private final ArrayList<ResultRecord> b(Bundle extra) {
        boolean z16;
        boolean z17;
        ArrayList<ResultRecord> arrayListOf;
        ArrayList<ResultRecord> parcelableArrayList = extra.getParcelableArrayList(AppConstants.Key.FORWARD_MULTI_TARGET);
        if (parcelableArrayList != null && !parcelableArrayList.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            return parcelableArrayList;
        }
        String string = extra.getString("uin");
        int i3 = extra.getInt("uintype");
        String string2 = extra.getString("uinname");
        if (string != null && string.length() != 0) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (!z17) {
            ResultRecord resultRecord = new ResultRecord();
            resultRecord.uin = string;
            resultRecord.uinType = i3;
            resultRecord.name = string2;
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(resultRecord);
            return arrayListOf;
        }
        return new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(ShareForwardResultReceiver this$0, int i3, Bundle bundle) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            ResultReceiver resultReceiver = this$0.weakBaseReceiver.get();
            if (resultReceiver != null) {
                resultReceiver.send(i3, bundle);
            }
        } catch (Exception e16) {
            QLog.e("ShareForwardResultReceiver", 1, "send base receiver error: ", e16);
        }
    }

    @Override // android.os.ResultReceiver
    protected void onReceiveResult(final int resultCode, @Nullable final Bundle resultData) {
        boolean z16;
        ArrayList<ResultRecord> arrayList;
        c cVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, resultCode, (Object) resultData);
            return;
        }
        super.onReceiveResult(resultCode, resultData);
        QLog.d("ShareForwardResultReceiver", 1, "onReceiveResult resultCode:" + resultCode);
        if (resultData != null) {
            resultData.setClassLoader(ShareForwardResultReceiver.class.getClassLoader());
        }
        if (resultCode == -1 && resultData != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && resultData != null) {
            arrayList = b(resultData);
        } else {
            arrayList = new ArrayList<>();
        }
        a aVar = this.weakCallback.get();
        if (aVar instanceof c) {
            cVar = (c) aVar;
        } else {
            cVar = null;
        }
        if (cVar != null) {
            cVar.b(z16, arrayList);
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.sharepanel.channel.handler.g
            @Override // java.lang.Runnable
            public final void run() {
                ShareForwardResultReceiver.c(ShareForwardResultReceiver.this, resultCode, resultData);
            }
        }, 16, null, true);
    }
}
