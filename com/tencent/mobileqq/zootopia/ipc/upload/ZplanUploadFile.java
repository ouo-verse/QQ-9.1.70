package com.tencent.mobileqq.zootopia.ipc.upload;

import com.tencent.mobileqq.zplan.avatar.upload.ZplanFileUploader;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/zootopia/ipc/upload/ZplanUploadFile;", "Lcom/tencent/mobileqq/zootopia/ipc/upload/b;", "", "filePath", "uuid", "Lcom/tencent/mobileqq/zootopia/ipc/upload/a;", "callback", "", "uploadFile", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZplanUploadFile implements b {
    @Override // com.tencent.mobileqq.zootopia.ipc.upload.b
    public void uploadFile(String filePath, String uuid, final a callback) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ZplanFileUploader.INSTANCE.b().f(filePath.hashCode(), filePath, uuid, new Function2<Boolean, String, Unit>() { // from class: com.tencent.mobileqq.zootopia.ipc.upload.ZplanUploadFile$uploadFile$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, String str) {
                invoke(bool.booleanValue(), str);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, String remoteUrl) {
                Intrinsics.checkNotNullParameter(remoteUrl, "remoteUrl");
                a.this.a(z16, remoteUrl);
            }
        });
    }
}
