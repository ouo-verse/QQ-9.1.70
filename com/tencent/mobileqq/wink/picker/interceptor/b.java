package com.tencent.mobileqq.wink.picker.interceptor;

import androidx.annotation.RequiresApi;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.picker.MediaPickerInput;
import com.tencent.mobileqq.wink.picker.MediaPickerOutput;
import com.tencent.mobileqq.wink.picker.interceptor.c;
import com.tencent.mobileqq.wink.sdk.Wink;
import com.tencent.mobileqq.winkpublish.report.MediaPickerErrorCode;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \n2\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0017\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/interceptor/b;", "Lcom/tencent/mobileqq/wink/picker/interceptor/c;", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "localMediaInfo", "", "c", "b", "", AEEditorConstants.KEY_WINK_LOCAL_MEDIA_INFOS, "", "d", "", "name", "Lcom/tencent/mobileqq/wink/picker/interceptor/c$a;", "chain", "Lcom/tencent/mobileqq/wink/picker/b;", "a", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class b implements c {
    private final boolean b(LocalMediaInfo localMediaInfo) {
        boolean exists = new File(localMediaInfo.path).exists();
        if (!exists) {
            w53.b.c("LocalMediaInfoCheckInterceptor", "file not exists, drop it: " + localMediaInfo);
        }
        return exists;
    }

    private final boolean c(LocalMediaInfo localMediaInfo) {
        boolean z16;
        String str = localMediaInfo.path;
        Intrinsics.checkNotNullExpressionValue(str, "localMediaInfo.path");
        if (str.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            w53.b.c("LocalMediaInfoCheckInterceptor", "empty path, drop it: " + localMediaInfo);
        }
        return !z16;
    }

    private final void d(List<? extends LocalMediaInfo> localMediaInfos) {
        Integer num;
        try {
            if (WinkContext.INSTANCE.d().u("QCIRCLE")) {
                if (localMediaInfos != null) {
                    num = Integer.valueOf(localMediaInfos.size());
                } else {
                    num = null;
                }
                String valueOf = String.valueOf(num);
                ArrayList arrayList = new ArrayList();
                for (Object obj : localMediaInfos) {
                    if (e93.i.G((LocalMediaInfo) obj)) {
                        arrayList.add(obj);
                    }
                }
                String valueOf2 = String.valueOf(arrayList.size());
                ArrayList arrayList2 = new ArrayList();
                for (Object obj2 : localMediaInfos) {
                    if (((LocalMediaInfo) obj2).isHDRVideo) {
                        arrayList2.add(obj2);
                    }
                }
                String valueOf3 = String.valueOf(arrayList2.size());
                WinkContext.Companion companion = WinkContext.INSTANCE;
                WinkPublishQualityReportData winkPublishQualityReportData = new WinkPublishQualityReportData("P_PICKER_MEDIAINFO", companion.d().getTraceId(), "0", valueOf, valueOf2, valueOf3, null, null, null, null, null, null, null, null, 0L, 32704, null);
                z93.c f16 = Wink.INSTANCE.f();
                if (f16 != null) {
                    f16.a(winkPublishQualityReportData, companion.d().k().b());
                }
            }
        } catch (Exception e16) {
            w53.b.d("WinkEditorFragment", "report error", e16);
        }
    }

    @Override // com.tencent.mobileqq.wink.picker.interceptor.c
    @RequiresApi(16)
    @Nullable
    public MediaPickerOutput a(@NotNull c.a chain) {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        boolean z16;
        Intrinsics.checkNotNullParameter(chain, "chain");
        List<LocalMediaInfo> e16 = chain.e();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = e16.iterator();
        while (true) {
            boolean z17 = false;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            LocalMediaInfo localMediaInfo = (LocalMediaInfo) next;
            if (e93.i.D(localMediaInfo) || c(localMediaInfo)) {
                z17 = true;
            }
            if (z17) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            LocalMediaInfo localMediaInfo2 = (LocalMediaInfo) obj;
            if (!e93.i.D(localMediaInfo2) && !b(localMediaInfo2)) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                arrayList2.add(obj);
            }
        }
        if (!(!chain.e().isEmpty()) || !arrayList2.isEmpty()) {
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
            ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault);
            Iterator it5 = arrayList2.iterator();
            while (it5.hasNext()) {
                arrayList3.add(com.tencent.mobileqq.wink.utils.o.f326724a.k((LocalMediaInfo) it5.next()));
            }
            collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList3, 10);
            ArrayList arrayList4 = new ArrayList(collectionSizeOrDefault2);
            Iterator it6 = arrayList3.iterator();
            while (it6.hasNext()) {
                arrayList4.add(com.tencent.mobileqq.wink.utils.o.f326724a.c((LocalMediaInfo) it6.next()));
            }
            d(arrayList4);
            return chain.f(MediaPickerInput.b(chain.getMediaPickerInput(), null, null, null, arrayList4, null, null, null, null, null, null, 1015, null));
        }
        throw new InterceptException(name(), new MediaPickerErrorCode(MediaPickerErrorCode.ERROR_CODE_EMPTY_SELECTED_MEDIA_INVALID_FILE, null, 2, null));
    }

    @Override // com.tencent.mobileqq.wink.picker.interceptor.c
    @NotNull
    public String name() {
        return "LocalMediaInfoCheckInterceptor";
    }
}
