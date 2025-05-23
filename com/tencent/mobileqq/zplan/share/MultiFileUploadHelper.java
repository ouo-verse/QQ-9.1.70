package com.tencent.mobileqq.zplan.share;

import com.tencent.mobileqq.zplan.avatar.upload.ZplanFileUploader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.utils.t;
import com.tencent.sqshow.zootopia.utils.w;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \f2\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J8\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u001e\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J:\u0010\u000b\u001a\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\t2\u001e\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005J\u0006\u0010\f\u001a\u00020\u0006R$\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/zplan/share/MultiFileUploadHelper;", "", "", "key", "filePath", "Lkotlin/Function3;", "", "callback", "d", "", "paths", "c", "b", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "a", "Ljava/util/ArrayList;", "uploadList", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class MultiFileUploadHelper {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<Long> uploadList = new ArrayList<>();

    public final void b() {
        ZplanFileUploader.INSTANCE.b().d(this.uploadList);
    }

    public final void c(Map<String, String> paths, Function3<? super String, ? super String, ? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(paths, "paths");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (paths.isEmpty()) {
            QLog.e("mutiFileUploadHelper", 1, "paths is empty");
            callback.invoke("", "", "");
            return;
        }
        for (Map.Entry<String, String> entry : paths.entrySet()) {
            String value = entry.getValue();
            if (com.tencent.mobileqq.zplan.cc.util.h.f332563a.d(value)) {
                d(entry.getKey(), value, callback);
            } else {
                QLog.e("mutiFileUploadHelper", 1, "File is not exist " + value);
                callback.invoke(entry.getKey(), value, "");
            }
        }
    }

    private final void d(final String key, final String filePath, final Function3<? super String, ? super String, ? super String, Unit> callback) {
        String b16 = w.f373306a.b();
        String str = com.tencent.open.base.g.b(new File(filePath)) + com.tencent.mobileqq.zplan.cc.util.h.f332563a.c(filePath);
        final String str2 = "home_ark_share_all/" + t.f373300a.g() + "/" + com.tencent.open.base.g.d(b16) + "/" + str;
        final long hashCode = key.hashCode();
        this.uploadList.add(Long.valueOf(hashCode));
        ZplanFileUploader.INSTANCE.b().f(hashCode, filePath, str2, new Function2<Boolean, String, Unit>() { // from class: com.tencent.mobileqq.zplan.share.MultiFileUploadHelper$uploadSingleFile$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, String str3) {
                invoke(bool.booleanValue(), str3);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, String remoteUrl) {
                ArrayList arrayList;
                Intrinsics.checkNotNullParameter(remoteUrl, "remoteUrl");
                QLog.i("mutiFileUploadHelper", 1, "upload " + key + ", uuid: " + str2 + ", filePath: " + filePath + ",  res: " + z16 + ", remoteUrl: " + remoteUrl + " ");
                arrayList = this.uploadList;
                arrayList.remove(Long.valueOf(hashCode));
                callback.invoke(key, filePath, remoteUrl);
            }
        });
    }
}
