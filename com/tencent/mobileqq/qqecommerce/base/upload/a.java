package com.tencent.mobileqq.qqecommerce.base.upload;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ecommerce.base.uploader.ECBaseUploader;
import com.tencent.ecommerce.base.uploader.IECUploaderFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/base/upload/a;", "Lcom/tencent/ecommerce/base/uploader/IECUploaderFactory;", "", "filePath", "Lcom/tencent/ecommerce/base/uploader/IECUploaderFactory$UploaderType;", "type", "scene", "Lcom/tencent/ecommerce/base/uploader/ECBaseUploader;", "createUploaderByType", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class a implements IECUploaderFactory {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.qqecommerce.base.upload.a$a, reason: collision with other inner class name */
    /* loaded from: classes35.dex */
    public /* synthetic */ class C8300a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f262492a;

        static {
            int[] iArr = new int[IECUploaderFactory.UploaderType.values().length];
            try {
                iArr[IECUploaderFactory.UploaderType.IMAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f262492a = iArr;
        }
    }

    @Override // com.tencent.ecommerce.base.uploader.IECUploaderFactory
    public ECBaseUploader createUploaderByType(String filePath, IECUploaderFactory.UploaderType type, String scene) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(scene, "scene");
        if (C8300a.f262492a[type.ordinal()] == 1) {
            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
            Intrinsics.checkNotNull(runtime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
            return new ECImageUploader((QQAppInterface) runtime, filePath, scene);
        }
        throw new NoWhenBranchMatchedException();
    }
}
