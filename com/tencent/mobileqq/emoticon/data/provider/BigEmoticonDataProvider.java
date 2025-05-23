package com.tencent.mobileqq.emoticon.data.provider;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.data.EmoticonTabInfo;
import com.tencent.mobileqq.emoticon.data.MarketEmoticonInfo;
import com.tencent.mobileqq.emoticon.data.api.IEmoticonDataService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0018\u0010\r\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/emoticon/data/provider/BigEmoticonDataProvider;", "Lcom/tencent/mobileqq/emoticon/data/api/IEmoticonDataService;", "()V", "appRuntime", "Lmqq/app/AppRuntime;", "getEmoticonTabInfo", "", "Lcom/tencent/mobileqq/emoticon/data/EmoticonTabInfo;", "tabType", "", "onCreate", "", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "updateEmoticonInfo", "callback", "Lcom/tencent/mobileqq/emoticon/data/api/IEmoticonDataService$UpdateEmoticonInfoCallback;", "qqemoticondata-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class BigEmoticonDataProvider implements IEmoticonDataService {
    static IPatchRedirector $redirector_;
    private AppRuntime appRuntime;

    public BigEmoticonDataProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.emoticon.data.api.IEmoticonDataService
    @NotNull
    public List<EmoticonTabInfo> getEmoticonTabInfo(int tabType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this, tabType);
        }
        ArrayList arrayList = new ArrayList();
        com.tencent.mobileqq.emoticon.data.ipc.a a16 = com.tencent.mobileqq.emoticon.data.ipc.a.INSTANCE.a();
        AppRuntime appRuntime = this.appRuntime;
        if (appRuntime == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appRuntime");
            appRuntime = null;
        }
        List<EmoticonPackage> i3 = a16.i(appRuntime);
        if (i3 == null) {
            return arrayList;
        }
        for (EmoticonPackage emoticonPackage : i3) {
            if (emoticonPackage.jobType == 0 && emoticonPackage.status == 2) {
                String str = emoticonPackage.name;
                Intrinsics.checkNotNullExpressionValue(str, "ep.name");
                com.tencent.mobileqq.emoticon.data.api.impl.c cVar = new com.tencent.mobileqq.emoticon.data.api.impl.c(6, str, emoticonPackage.ipUrl, emoticonPackage);
                com.tencent.mobileqq.emoticon.data.ipc.a a17 = com.tencent.mobileqq.emoticon.data.ipc.a.INSTANCE.a();
                AppRuntime appRuntime2 = this.appRuntime;
                if (appRuntime2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("appRuntime");
                    appRuntime2 = null;
                }
                String str2 = emoticonPackage.epId;
                Intrinsics.checkNotNullExpressionValue(str2, "ep.epId");
                List<Emoticon> h16 = a17.h(appRuntime2, str2);
                if (h16 != null && !h16.isEmpty()) {
                    ArrayList arrayList2 = new ArrayList();
                    Iterator<Emoticon> it = h16.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(new MarketEmoticonInfo(it.next()));
                    }
                    cVar.a().addAll(arrayList2);
                    arrayList.add(cVar);
                }
            }
        }
        return arrayList;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(@NotNull AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
        } else {
            Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
            this.appRuntime = appRuntime;
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.emoticon.data.api.IEmoticonDataService
    public void updateEmoticonInfo(int tabType, @NotNull IEmoticonDataService.UpdateEmoticonInfoCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, tabType, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(callback, "callback");
        }
    }
}
