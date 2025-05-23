package com.tencent.qqnt.mycomputer.aio.impl;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.aio.api.runtime.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.bottombar.sectionbar.adapter.b;
import com.tencent.qqnt.aio.bottombar.sectionbar.processor.BottomSectionBarBaseProcessor;
import com.tencent.qqnt.mycomputer.api.IMyComputerHelpApi;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\fH\u0016R\u0014\u0010\u0011\u001a\u00020\u00048\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqnt/mycomputer/aio/impl/MyComputerHelpApiNtImpl;", "Lcom/tencent/qqnt/mycomputer/api/IMyComputerHelpApi;", "Lcom/tencent/aio/api/runtime/a;", "context", "", "devicePeerUid", "deviceNick", "", "myComputerOpenCamera", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "myComputerOpenFileSelector", "", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/adapter/b;", "getExtSectionBarAdapters", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/processor/BottomSectionBarBaseProcessor;", "getExtSectionBarProcessors", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class MyComputerHelpApiNtImpl implements IMyComputerHelpApi {
    static IPatchRedirector $redirector_;

    @NotNull
    private final String TAG;

    public MyComputerHelpApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.TAG = "MyComputerHelpApiNtImpl";
        }
    }

    @Override // com.tencent.qqnt.mycomputer.api.IMyComputerHelpApi
    @NotNull
    public List<b> getExtSectionBarAdapters() {
        List<b> emptyList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return (List) iPatchRedirector.redirect((short) 4, (Object) this);
    }

    @Override // com.tencent.qqnt.mycomputer.api.IMyComputerHelpApi
    @NotNull
    public List<BottomSectionBarBaseProcessor> getExtSectionBarProcessors() {
        List<BottomSectionBarBaseProcessor> emptyList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return (List) iPatchRedirector.redirect((short) 5, (Object) this);
    }

    @Override // com.tencent.qqnt.mycomputer.api.IMyComputerHelpApi
    public <T> int multipleForwardToMyComputer(@NotNull String str, @NotNull Bundle bundle, T t16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, this, str, bundle, t16)).intValue();
        }
        return IMyComputerHelpApi.a.a(this, str, bundle, t16);
    }

    @Override // com.tencent.qqnt.mycomputer.api.IMyComputerHelpApi
    public void myComputerOpenCamera(@NotNull a context, @NotNull String devicePeerUid, @NotNull String deviceNick) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, devicePeerUid, deviceNick);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(devicePeerUid, "devicePeerUid");
        Intrinsics.checkNotNullParameter(deviceNick, "deviceNick");
        QLog.d(this.TAG, 1, "MyComputerHelpApiNtImpl myComputerOpenCamera");
    }

    @Override // com.tencent.qqnt.mycomputer.api.IMyComputerHelpApi
    public void myComputerOpenFileSelector(@NotNull Activity activity, @NotNull String devicePeerUid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity, (Object) devicePeerUid);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(devicePeerUid, "devicePeerUid");
        QLog.d(this.TAG, 1, "MyComputerHelpApiNtImpl myComputerOpenFileSelector");
    }

    @Override // com.tencent.qqnt.mycomputer.api.IMyComputerHelpApi
    public void myComputerSendFileFromPhoto(@NotNull String str, @NotNull String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) str2);
        } else {
            IMyComputerHelpApi.a.b(this, str, str2);
        }
    }

    @Override // com.tencent.qqnt.mycomputer.api.IMyComputerHelpApi
    public void myComputerSendMultiFileFromPhoto(@NotNull String str, @NotNull List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, (Object) list);
        } else {
            IMyComputerHelpApi.a.c(this, str, list);
        }
    }

    @Override // com.tencent.qqnt.mycomputer.api.IMyComputerHelpApi
    public <T> int singleForwardToMyComputer(@NotNull String str, @NotNull Bundle bundle, T t16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, this, str, bundle, t16)).intValue();
        }
        return IMyComputerHelpApi.a.d(this, str, bundle, t16);
    }
}
