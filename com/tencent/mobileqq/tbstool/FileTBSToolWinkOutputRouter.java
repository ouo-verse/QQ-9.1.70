package com.tencent.mobileqq.tbstool;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import b93.OutputData;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.wink.api.IWinkAPI;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@RoutePage(desc = "\u6587\u4ef6tbs\u5de5\u5177\u8f93\u51fa\u8def\u7531", path = "/wink/output/filetbstool")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/tbstool/FileTBSToolWinkOutputRouter;", "Lb93/a;", "", "interceptExitWink", "Landroid/content/Context;", "context", "Landroid/os/Bundle;", "bundle", "", "onBack", "Lb93/b;", "outputData", "onOutput", "<init>", "()V", "qqfile-filebrowser-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class FileTBSToolWinkOutputRouter implements b93.a {
    static IPatchRedirector $redirector_;

    public FileTBSToolWinkOutputRouter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // b93.a
    public boolean interceptExitWink() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // b93.a
    public void onBack(@NotNull Context context, @Nullable Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) bundle);
        } else {
            Intrinsics.checkNotNullParameter(context, "context");
        }
    }

    @Override // b93.a
    public void onOutput(@NotNull Context context, @NotNull OutputData outputData) {
        int collectionSizeOrDefault;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) outputData);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(outputData, "outputData");
        if (outputData.getOutputPoint() == 2) {
            QRouteApi api = QRoute.api(IWinkAPI.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IWinkAPI::class.java)");
            IWinkAPI iWinkAPI = (IWinkAPI) api;
            Intent intent = new Intent();
            Bundle bundle = outputData.getBundle();
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            List<LocalMediaInfo> e16 = outputData.e();
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(e16, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = e16.iterator();
            while (it.hasNext()) {
                arrayList.add(new File(((LocalMediaInfo) it.next()).path));
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                if (((File) obj).exists()) {
                    arrayList2.add(obj);
                }
            }
            intent.putExtra("OUTPUT_MEDIA", new ArrayList(arrayList2));
            Unit unit = Unit.INSTANCE;
            IWinkAPI.DefaultImpls.exitWink$default(iWinkAPI, false, -1, intent, 1, null);
        }
    }
}
