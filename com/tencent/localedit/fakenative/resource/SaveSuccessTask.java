package com.tencent.localedit.fakenative.resource;

import com.tencent.localedit.LocalEditSDK;
import com.tencent.localedit.fakenative.resource.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/localedit/fakenative/resource/SaveSuccessTask;", "Lcom/tencent/localedit/fakenative/resource/c;", "", "c", "Ljava/lang/String;", "localFilePath", "d", "data", "e", "tempDataPath", "f", "oldDataPath", "g", "globalPadId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "docx_local_edit_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes7.dex */
public final class SaveSuccessTask extends c {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String localFilePath;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String data;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String tempDataPath;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String oldDataPath;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String globalPadId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SaveSuccessTask(@NotNull final String localFilePath, @NotNull final String data, @NotNull final String tempDataPath, @NotNull final String oldDataPath, @NotNull final String globalPadId) {
        super(new Function0<Object>() { // from class: com.tencent.localedit.fakenative.resource.SaveSuccessTask.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Object invoke() {
                a.C5961a.c(LocalEditSDK.INSTANCE.getCache(), localFilePath, data, globalPadId, false, 8, null);
                w11.a aVar = w11.a.f444159a;
                aVar.f(tempDataPath);
                return Boolean.valueOf(aVar.f(oldDataPath));
            }
        }, new Function1<Object, Unit>() { // from class: com.tencent.localedit.fakenative.resource.SaveSuccessTask.2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2(obj);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Object it) {
                Intrinsics.checkNotNullParameter(it, "it");
                x11.b.f446855a.d("Local_edit", "SaveSuccessTask finish");
            }
        });
        Intrinsics.checkNotNullParameter(localFilePath, "localFilePath");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(tempDataPath, "tempDataPath");
        Intrinsics.checkNotNullParameter(oldDataPath, "oldDataPath");
        Intrinsics.checkNotNullParameter(globalPadId, "globalPadId");
        this.localFilePath = localFilePath;
        this.data = data;
        this.tempDataPath = tempDataPath;
        this.oldDataPath = oldDataPath;
        this.globalPadId = globalPadId;
    }
}
