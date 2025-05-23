package com.tencent.qqmini.proxyimpl.tavcutplugin.apiproxy;

import android.graphics.Bitmap;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.qqmini.proxyimpl.tavcutplugin.apiproxy.TavImageGenerator;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppFileManager;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tavcut.composition.model.component.Size;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\f\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u000eH\u0016J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqmini/proxyimpl/tavcutplugin/apiproxy/l;", "Lcom/tencent/qqmini/proxyimpl/tavcutplugin/apiproxy/a;", "Lcom/tencent/qqmini/proxyimpl/tavcutplugin/apiproxy/TavImageGenerator;", "imageGenerator", "Lnu3/d;", "eventBean", "", "w", "u", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, HippyTKDListViewAdapter.X, "v", "y", "Lnu3/c;", "f", "p", "<init>", "()V", "a", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class l extends a {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\nR\u0014\u0010\u000e\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\nR\u0014\u0010\u000f\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\nR\u0014\u0010\u0010\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\nR\u0014\u0010\u0011\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\nR\u0014\u0010\u0012\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\n\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqmini/proxyimpl/tavcutplugin/apiproxy/l$a;", "", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "Ljava/io/File;", "file", "", "a", "", "CUT_SESSION_KEY", "Ljava/lang/String;", "FILE_PATH_VALUE", "MAX_SIZE_KEY", "METHOD_GENERATE_IMAGE", "METHOD_SET_CUT_SESSION", "OBJECT_VALUE", "PNG_SUFFIX", "TIME_KEY", "TYPE_KEY", "<init>", "()V", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqmini.proxyimpl.tavcutplugin.apiproxy.l$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Bitmap bitmap, File file) throws Exception {
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            Intrinsics.checkNotNullParameter(file, "file");
            if (file.createNewFile()) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                fileOutputStream.write(byteArray);
                fileOutputStream.flush();
                fileOutputStream.close();
                return;
            }
            throw new RuntimeException("createNewFile return false, path = " + file.getAbsolutePath());
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/qqmini/proxyimpl/tavcutplugin/apiproxy/l$b", "Lcom/tencent/qqmini/proxyimpl/tavcutplugin/apiproxy/TavImageGenerator$c;", "Lcom/tencent/tav/coremedia/CMTime;", "requestedTime", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "a", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements TavImageGenerator.c {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ nu3.d f347974b;

        b(nu3.d dVar) {
            this.f347974b = dVar;
        }

        @Override // com.tencent.qqmini.proxyimpl.tavcutplugin.apiproxy.TavImageGenerator.c
        public void a(CMTime requestedTime, Bitmap bitmap) {
            Intrinsics.checkNotNullParameter(requestedTime, "requestedTime");
            l.this.x(bitmap, this.f347974b);
        }
    }

    private final void u(TavImageGenerator imageGenerator, nu3.d eventBean) throws JSONException {
        JSONObject param = eventBean.getParam();
        JSONObject jSONObject = param != null ? param.getJSONObject("time") : null;
        if (jSONObject == null) {
            i("seek failed, parameter 'time' parse error");
        } else {
            imageGenerator.d(com.tencent.qqmini.proxyimpl.tavcutplugin.apiproxy.b.f347944a.l(jSONObject), new b(eventBean));
        }
    }

    private final void w(TavImageGenerator imageGenerator, nu3.d eventBean) throws JSONException {
        Object f16 = eventBean.f("cutSession");
        if (!(f16 instanceof e)) {
            j("cutSession");
        } else {
            imageGenerator.g((e) f16);
            m();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(Bitmap bitmap, nu3.d eventBean) {
        try {
            v(bitmap, eventBean);
        } catch (Exception e16) {
            ee4.b.c(getTAG(), "tryOnCoverGenerated: ", e16);
            h();
        }
    }

    private final void y(Bitmap bitmap) throws Exception {
        IMiniAppFileManager iMiniAppFileManager = getCom.tencent.ams.mosaic.MosaicConstants$JsProperty.PROP_FILE_MANAGER java.lang.String();
        String tmpPath = iMiniAppFileManager != null ? iMiniAppFileManager.getTmpPath(".png") : null;
        INSTANCE.a(bitmap, new File(tmpPath));
        bitmap.recycle();
        IMiniAppFileManager iMiniAppFileManager2 = getCom.tencent.ams.mosaic.MosaicConstants$JsProperty.PROP_FILE_MANAGER java.lang.String();
        o(iMiniAppFileManager2 != null ? iMiniAppFileManager2.getWxFilePath(tmpPath) : null);
    }

    @Override // com.tencent.qqmini.proxyimpl.tavcutplugin.apiproxy.a
    public void f(nu3.c eventBean) throws JSONException {
        Size size;
        Intrinsics.checkNotNullParameter(eventBean, "eventBean");
        super.f(eventBean);
        Object f16 = eventBean.f("cutSession");
        if (!(f16 instanceof e)) {
            i("invoke new object failed, param object 'tavCutSession' cannot be found in object pool");
            return;
        }
        JSONObject param = eventBean.getParam();
        if (param == null || !param.has("maxSize")) {
            size = null;
        } else {
            JSONObject maxSize = param.getJSONObject("maxSize");
            com.tencent.qqmini.proxyimpl.tavcutplugin.apiproxy.b bVar = com.tencent.qqmini.proxyimpl.tavcutplugin.apiproxy.b.f347944a;
            Intrinsics.checkNotNullExpressionValue(maxSize, "maxSize");
            size = bVar.o(maxSize);
        }
        k(new TavImageGenerator((e) f16, size));
    }

    @Override // com.tencent.qqmini.proxyimpl.tavcutplugin.apiproxy.a
    public void p(nu3.d eventBean) throws JSONException {
        Intrinsics.checkNotNullParameter(eventBean, "eventBean");
        super.p(eventBean);
        Object targetObj = eventBean.getTargetObj();
        if (!(targetObj instanceof TavImageGenerator)) {
            i("invoke func failed, target object 'imageGenerator' cannot be found in object pool");
            return;
        }
        String methodName = eventBean.getMethodName();
        if (methodName != null) {
            if (Intrinsics.areEqual(methodName, "setCutSession")) {
                w((TavImageGenerator) targetObj, eventBean);
            } else if (Intrinsics.areEqual(methodName, "generateImage")) {
                u((TavImageGenerator) targetObj, eventBean);
            }
        }
    }

    private final void v(Bitmap bitmap, nu3.d eventBean) throws Exception {
        if (bitmap == null) {
            i("generate cover filed, bitmap null");
            return;
        }
        JSONObject param = eventBean.getParam();
        String string = param != null ? param.getString("type") : null;
        if (Intrinsics.areEqual("object", string)) {
            l(bitmap);
        } else if (Intrinsics.areEqual("filePath", string)) {
            y(bitmap);
        }
    }
}
