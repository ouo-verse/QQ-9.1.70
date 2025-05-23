package com.tencent.biz.qqcircle.immersive.redpacket.util;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.annotation.WorkerThread;
import com.dataline.util.j;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qcircleshadow.lib.QCirclePluginInitHelper;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.hippy.qq.adapter.image.CustomImageProps;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J0\u0010\u0006\u001a\u00020\u00032&\u0010\u0005\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0004H\u0002J<\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032&\u0010\u0005\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0004H\u0002J8\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2(\b\u0002\u0010\u0005\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0004JD\u0010\r\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032(\b\u0002\u0010\u0005\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0004J\u0016\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0003J$\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0012H\u0007J\u0006\u0010\u0016\u001a\u00020\u000b\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/redpacket/util/d;", "", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", Node.ATTRS_ATTR, "b", ZPlanPublishSource.FROM_SCHEME, "c", "Landroid/content/Context;", "context", "", "d", "f", "e", "path", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", CustomImageProps.QUALITY, "Ljava/io/File;", "j", h.F, "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f89585a = new d();

    d() {
    }

    private final String b(HashMap<String, String> attrs) {
        String str = "mqqapi://qcircle/openpersonalcoverfeedpage?&is_from_red_envelope=1";
        if (attrs != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, String> entry : attrs.entrySet()) {
                if (!Intrinsics.areEqual(entry.getKey(), "key_scheme")) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                str = ((Object) str) + ContainerUtils.FIELD_DELIMITER + entry2.getKey() + ContainerUtils.KEY_VALUE_DELIMITER + entry2.getValue();
            }
        }
        QLog.d("RedPacketUtil", 1, "getFeedListScheme, realScheme:" + ((Object) str));
        return str;
    }

    private final String c(String scheme, HashMap<String, String> attrs) {
        boolean z16;
        if (scheme != null && scheme.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            scheme = "mqqapi://qcircle/openqqpublish?target=1";
        }
        String str = scheme + "&is_from_red_envelope=1" + j.d("&should_publish_incompose=1&compose_page_button_title=\u53d1\u8868\u5230\u5c0f\u4e16\u754c\uff0c\u5e76\u8bbe\u4e3a\u7ea2\u5305\u5c01\u9762&hide_publish_permission=1&tag=QQ\u7ea2\u5305\u89c6\u9891\u5c01\u9762") + "&wink_output_route=/wink/output/qcircle/red_pocket&wink_output_point=64&hide_edit_become_photo=1&up_source=101";
        if (attrs != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, String> entry : attrs.entrySet()) {
                if (!Intrinsics.areEqual(entry.getKey(), "key_scheme")) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                str = ((Object) str) + ContainerUtils.FIELD_DELIMITER + entry2.getKey() + ContainerUtils.KEY_VALUE_DELIMITER + entry2.getValue();
            }
        }
        QLog.d("RedPacketUtil", 1, "getWinkScheme, realScheme:" + ((Object) str));
        return str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void g(d dVar, Context context, String str, HashMap hashMap, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = null;
        }
        if ((i3 & 4) != 0) {
            hashMap = null;
        }
        dVar.f(context, str, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i() {
        QCirclePluginInitHelper.PreloadWink(RFWApplication.getApplication());
    }

    public static /* synthetic */ File k(d dVar, String str, Bitmap bitmap, int i3, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            i3 = 100;
        }
        return dVar.j(str, bitmap, i3);
    }

    public final void d(@NotNull Context context, @Nullable HashMap<String, String> attrs) {
        Intrinsics.checkNotNullParameter(context, "context");
        com.tencent.biz.qqcircle.launcher.c.g(context, b(attrs));
    }

    public final void e(@NotNull Context context, @NotNull String scheme) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        com.tencent.biz.qqcircle.launcher.c.g(context, scheme);
    }

    public final void f(@NotNull Context context, @Nullable String scheme, @Nullable HashMap<String, String> attrs) {
        Intrinsics.checkNotNullParameter(context, "context");
        com.tencent.biz.qqcircle.launcher.c.g(context, c(scheme, attrs));
    }

    public final void h() {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.redpacket.util.c
            @Override // java.lang.Runnable
            public final void run() {
                d.i();
            }
        });
        a aVar = a.f89583a;
        a.b(aVar, null, "qvideo_hongbao_close", false, true, 5, null);
        a.b(aVar, null, "qvideo_hongbao_opened_v2", false, true, 5, null);
        a.b(aVar, null, "qvideo_hongbao_icon_open_back", false, false, 13, null);
        a.b(aVar, null, "qvideo_hongbao_icon_open_front", false, false, 13, null);
        a.b(aVar, null, "qvideo_hongbao_amount_v2", false, false, 13, null);
    }

    @WorkerThread
    @Nullable
    public final File j(@NotNull String path, @NotNull Bitmap bitmap, int quality) {
        FileOutputStream fileOutputStream;
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        QLog.d("RedPacketUtil", 1, "saveBitmap, path:" + path);
        File file = new File(path);
        if (file.exists()) {
            file.delete();
        }
        File parentFile = file.getParentFile();
        FileOutputStream fileOutputStream2 = null;
        if (parentFile == null) {
            QLog.w("RedPacketUtil", 1, "saveBitmap, parentFile is null ");
            return null;
        }
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        try {
            file.createNewFile();
            fileOutputStream = new FileOutputStream(file);
        } catch (IOException e16) {
            e = e16;
            fileOutputStream = null;
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            try {
                bitmap.compress(Bitmap.CompressFormat.JPEG, quality, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                try {
                    fileOutputStream.close();
                } catch (IOException e17) {
                    QLog.w("RedPacketUtil", 1, "saveBitmap, error ", e17);
                }
                return file;
            } catch (IOException e18) {
                e = e18;
                QLog.w("RedPacketUtil", 1, "saveBitmap, error ", e);
                file.delete();
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e19) {
                        QLog.w("RedPacketUtil", 1, "saveBitmap, error ", e19);
                    }
                }
                return null;
            }
        } catch (Throwable th6) {
            th = th6;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e26) {
                    QLog.w("RedPacketUtil", 1, "saveBitmap, error ", e26);
                }
            }
            throw th;
        }
    }
}
