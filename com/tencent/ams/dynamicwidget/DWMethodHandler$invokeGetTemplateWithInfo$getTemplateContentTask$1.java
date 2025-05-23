package com.tencent.ams.dynamicwidget;

import com.tencent.ams.dsdk.event.DKMethodHandler;
import com.tencent.ams.dsdk.utils.FileUtils;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", TencentLocation.RUN_MODE}, k = 3, mv = {1, 1, 16})
/* loaded from: classes3.dex */
final class DWMethodHandler$invokeGetTemplateWithInfo$getTemplateContentTask$1 implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Ref.ObjectRef f70142d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ String f70143e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ DKMethodHandler.Callback f70144f;
    final /* synthetic */ DWMethodHandler this$0;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        com.tencent.ams.dynamicwidget.xjpage.a aVar = (com.tencent.ams.dynamicwidget.xjpage.a) this.f70142d.element;
        if (aVar != null) {
            str = aVar.c(this.f70143e);
        } else {
            str = null;
        }
        if (this.f70144f != null) {
            byte[] readBytesFromFile = FileUtils.readBytesFromFile(str);
            if (readBytesFromFile != null) {
                this.f70144f.onResult(new String(readBytesFromFile, Charsets.UTF_8));
            } else {
                DWMethodHandler.e(null, this.f70144f, -32, "content is empty.");
            }
        }
    }
}
