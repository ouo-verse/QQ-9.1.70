package com.tencent.mobileqq.wink.picker.interceptor;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.wink.picker.MediaPickerOutput;
import com.tencent.mobileqq.wink.picker.interceptor.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \n2\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/interceptor/f;", "Lcom/tencent/mobileqq/wink/picker/interceptor/c;", "", "name", "Lcom/tencent/mobileqq/wink/picker/interceptor/c$a;", "chain", "Lcom/tencent/mobileqq/wink/picker/b;", "a", "<init>", "()V", "d", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class f implements c {
    @Override // com.tencent.mobileqq.wink.picker.interceptor.c
    @Nullable
    public MediaPickerOutput a(@NotNull c.a chain) {
        ArrayList arrayList;
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        Intrinsics.checkNotNullParameter(chain, "chain");
        List<LocalMediaInfo> i3 = chain.getMediaPickerInput().i();
        if (i3 != null) {
            List<LocalMediaInfo> list = i3;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(com.tencent.mobileqq.wink.utils.o.f326724a.k((LocalMediaInfo) it.next()));
            }
            collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
            arrayList = new ArrayList(collectionSizeOrDefault2);
            Iterator it5 = arrayList2.iterator();
            while (it5.hasNext()) {
                arrayList.add(com.tencent.mobileqq.wink.utils.o.f326724a.c((LocalMediaInfo) it5.next()));
            }
        } else {
            arrayList = null;
        }
        return new MediaPickerOutput(chain.getMediaPickerInput().getMediaPickerScene(), chain.getMediaPickerInput().j(), chain.getMediaPickerInput().getVideoTemplateData(), arrayList, chain.getMediaPickerInput().f(), chain.getMediaPickerInput().g());
    }

    @Override // com.tencent.mobileqq.wink.picker.interceptor.c
    @NotNull
    public String name() {
        return "OutputMediaInterceptor";
    }
}
