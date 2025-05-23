package com.tencent.luggage.wxa.fd;

import com.tencent.mm.udr.api.IUdrBizFeature;
import com.tencent.mm.udr.api.WxUdrResource;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class d0 implements IUdrBizFeature {

    /* renamed from: a, reason: collision with root package name */
    public static final a f125708a = new a(null);

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(WxUdrResource resource) {
            Intrinsics.checkNotNullParameter(resource, "resource");
            String path = resource.getPath();
            if (path.length() == 0) {
                return false;
            }
            return com.tencent.luggage.wxa.tn.f0.e(path).getBoolean("ready", false);
        }

        public final void b(WxUdrResource resource) {
            Intrinsics.checkNotNullParameter(resource, "resource");
            com.tencent.luggage.wxa.cp.x.b(new com.tencent.luggage.wxa.cp.v(resource.getPostPath(), resource.getName()).m());
            c(resource);
        }

        public final void c(WxUdrResource resource) {
            Intrinsics.checkNotNullParameter(resource, "resource");
            boolean z16 = true;
            com.tencent.luggage.wxa.tn.w.d("UDRBizWAGameIconInfoFeatureService", "unzipResource, resource info: %s", resource.toString());
            com.tencent.luggage.wxa.cp.v vVar = new com.tencent.luggage.wxa.cp.v(resource.getPath());
            String postPath = resource.getPostPath();
            if (postPath == null) {
                return;
            }
            int d16 = com.tencent.luggage.wxa.cp.x.d(com.tencent.luggage.wxa.cp.x.b(vVar.m(), false), postPath);
            if (d16 < 0) {
                com.tencent.luggage.wxa.tn.w.b("UDRBizWAGameIconInfoFeatureService", "postProcess unzip resource failed, projectId: %s, resourcePath: %s, outputPath: %s", resource.getProjectId(), resource.getPath(), postPath);
            } else {
                com.tencent.luggage.wxa.tn.w.d("UDRBizWAGameIconInfoFeatureService", "unzip success, resource original path: %s, outputPath: %s", resource.getPath(), postPath);
            }
            if (d16 < 0) {
                z16 = false;
            }
            a(resource, z16);
        }

        public final void a(WxUdrResource wxUdrResource, boolean z16) {
            String path = wxUdrResource.getPath();
            if (path.length() == 0) {
                return;
            }
            com.tencent.luggage.wxa.tn.f0.e(path).putBoolean("ready", z16);
        }
    }
}
