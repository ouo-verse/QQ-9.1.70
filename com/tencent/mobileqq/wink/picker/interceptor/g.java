package com.tencent.mobileqq.wink.picker.interceptor;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.wink.editor.extractor.FirstFramePreLoader;
import com.tencent.mobileqq.wink.picker.MediaPickerOutput;
import com.tencent.mobileqq.wink.picker.interceptor.c;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \n2\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/interceptor/g;", "Lcom/tencent/mobileqq/wink/picker/interceptor/c;", "", "name", "Lcom/tencent/mobileqq/wink/picker/interceptor/c$a;", "chain", "Lcom/tencent/mobileqq/wink/picker/b;", "a", "<init>", "()V", "d", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class g implements c {
    @Override // com.tencent.mobileqq.wink.picker.interceptor.c
    @NotNull
    public MediaPickerOutput a(@NotNull c.a chain) {
        boolean z16;
        Object first;
        Intrinsics.checkNotNullParameter(chain, "chain");
        List<LocalMediaInfo> j3 = chain.getMediaPickerInput().j();
        if (j3 != null && !j3.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 && !chain.c()) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) chain.getMediaPickerInput().j());
            if (!e93.i.D((LocalMediaInfo) first)) {
                FirstFramePreLoader.f320286a.o(chain.getMediaPickerInput().j().get(0));
                return chain.f(chain.getMediaPickerInput());
            }
        }
        return chain.f(chain.getMediaPickerInput());
    }

    @Override // com.tencent.mobileqq.wink.picker.interceptor.c
    @NotNull
    public String name() {
        return "PreloadFirstFrameInterceptor";
    }
}
