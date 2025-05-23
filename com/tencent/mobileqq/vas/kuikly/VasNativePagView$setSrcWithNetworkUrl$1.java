package com.tencent.mobileqq.vas.kuikly;

import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "file", "Ljava/io/File;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class VasNativePagView$setSrcWithNetworkUrl$1 extends Lambda implements Function1<File, Unit> {
    final /* synthetic */ String $src;
    final /* synthetic */ VasNativePagView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VasNativePagView$setSrcWithNetworkUrl$1(VasNativePagView vasNativePagView, String str) {
        super(1);
        this.this$0 = vasNativePagView;
        this.$src = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(VasNativePagView this$0, File file, String src) {
        Function1 function1;
        Map emptyMap;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(src, "$src");
        this$0.setVisibility(0);
        if (file == null) {
            function1 = this$0.loadFailureCallback;
            if (function1 != null) {
                emptyMap = MapsKt__MapsKt.emptyMap();
                function1.invoke(emptyMap);
            }
            QLog.e("HRPAGView", 1, "download pag file error, src: " + src + ", hashCode: " + this$0.hashCode());
            return;
        }
        this$0.srcSourceReady = true;
        String absolutePath = file.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "file.absolutePath");
        this$0.w0(absolutePath);
        this$0.p0();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(File file) {
        invoke2(file);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@Nullable final File file) {
        final VasNativePagView vasNativePagView = this.this$0;
        final String str = this.$src;
        vasNativePagView.post(new Runnable() { // from class: com.tencent.mobileqq.vas.kuikly.y
            @Override // java.lang.Runnable
            public final void run() {
                VasNativePagView$setSrcWithNetworkUrl$1.b(VasNativePagView.this, file, str);
            }
        });
    }
}
