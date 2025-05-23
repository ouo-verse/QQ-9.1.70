package com.tencent.qqmini.proxyimpl.tavcutplugin.apiproxy;

import com.vivo.push.PushClientConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqmini/proxyimpl/tavcutplugin/apiproxy/q;", "", "", "classKey", "Lcom/tencent/qqmini/proxyimpl/tavcutplugin/apiproxy/a;", "b", PushClientConstants.TAG_CLASS_NAME, "a", "<init>", "()V", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public static final q f347998a = new q();

    q() {
    }

    public final String a(String className) {
        if (className != null) {
            if (Intrinsics.areEqual(className, "TAVCutSession") ? true : Intrinsics.areEqual(className, e.class.getSimpleName())) {
                return "TAVCutSession";
            }
            if (Intrinsics.areEqual(className, "TAVClipResourceList") ? true : Intrinsics.areEqual(className, c.class.getSimpleName())) {
                return "TAVClipResourceList";
            }
            if (Intrinsics.areEqual(className, "TAVPlayer") ? true : Intrinsics.areEqual(className, o.class.getSimpleName())) {
                return "TAVPlayer";
            }
            if (Intrinsics.areEqual(className, "TAVImageGenerator") ? true : Intrinsics.areEqual(className, TavImageGenerator.class.getSimpleName())) {
                return "TAVImageGenerator";
            }
            if (Intrinsics.areEqual(className, "TAVSourceExportSession") ? true : Intrinsics.areEqual(className, i.class.getSimpleName())) {
                return "TAVSourceExportSession";
            }
            ee4.b.b("WS_TavProxyManager", "No match class name ! classname = " + className);
            return "";
        }
        ee4.b.b("WS_TavProxyManager", "Class name is null!");
        return "";
    }

    public final a b(String classKey) {
        String a16 = a(classKey);
        switch (a16.hashCode()) {
            case -1621224543:
                if (a16.equals("TAVImageGenerator")) {
                    return new l();
                }
                break;
            case -637668771:
                if (a16.equals("TAVCutSession")) {
                    return new g();
                }
                break;
            case 604872094:
                if (a16.equals("TAVSourceExportSession")) {
                    return new j();
                }
                break;
            case 1520189386:
                if (a16.equals("TAVPlayer")) {
                    return new p();
                }
                break;
            case 1609172709:
                if (a16.equals("TAVClipResourceList")) {
                    return new d();
                }
                break;
        }
        ee4.b.b("WS_TavProxyManager", "No match class name ! classname = " + classKey);
        return null;
    }
}
