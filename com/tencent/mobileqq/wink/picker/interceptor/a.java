package com.tencent.mobileqq.wink.picker.interceptor;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.wink.picker.MediaPickerInput;
import com.tencent.mobileqq.wink.picker.MediaPickerOutput;
import com.tencent.mobileqq.wink.picker.interceptor.c;
import com.tencent.mobileqq.wink.utils.am;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000f2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/interceptor/a;", "Lcom/tencent/mobileqq/wink/picker/interceptor/c;", "Lcom/tencent/mobileqq/wink/picker/a;", "input", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "b", "", "name", "Lcom/tencent/mobileqq/wink/picker/interceptor/c$a;", "chain", "Lcom/tencent/mobileqq/wink/picker/b;", "a", "<init>", "()V", "d", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a implements c {
    private final List<LocalMediaInfo> b(MediaPickerInput input) {
        List<LocalMediaInfo> i3 = input.i();
        if (i3 == null) {
            i3 = input.j();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : i3) {
            if (e93.i.F((LocalMediaInfo) obj)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.wink.picker.interceptor.c
    @Nullable
    public MediaPickerOutput a(@NotNull c.a chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        MediaPickerInput d16 = chain.d();
        List<LocalMediaInfo> b16 = b(d16);
        if (!b16.isEmpty()) {
            for (LocalMediaInfo localMediaInfo : b16) {
                am amVar = am.f326679a;
                String str = localMediaInfo.path;
                Intrinsics.checkNotNullExpressionValue(str, "it.path");
                String a16 = amVar.a(str);
                if (a16 != null) {
                    localMediaInfo.path = a16;
                    localMediaInfo.mMimeType = "image/jpeg";
                }
            }
        }
        return chain.f(d16);
    }

    @Override // com.tencent.mobileqq.wink.picker.interceptor.c
    @NotNull
    public String name() {
        return "GifMediaInterceptor";
    }
}
