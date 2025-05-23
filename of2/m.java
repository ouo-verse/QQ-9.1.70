package of2;

import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qqnt.kernel.nativeinterface.BusiScene;
import com.tencent.qqnt.kernel.nativeinterface.CoverOriginalInfo;
import com.tencent.qqnt.kernel.nativeinterface.CreateFlashTransferParam;
import com.tencent.qqnt.kernel.nativeinterface.Uploader;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0015\u0010\u0002\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0000\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"", "Lcom/tencent/qqnt/kernel/nativeinterface/CreateFlashTransferParam;", "a", "([Ljava/lang/Object;)Lcom/tencent/qqnt/kernel/nativeinterface/CreateFlashTransferParam;", "qqecommerce_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class m {
    public static final CreateFlashTransferParam a(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        Iterator it = ArrayIteratorKt.iterator(objArr);
        CreateFlashTransferParam createFlashTransferParam = new CreateFlashTransferParam();
        while (it.hasNext()) {
            Object next = it.next();
            if (Intrinsics.areEqual(next, "scene")) {
                BusiScene[] values = BusiScene.values();
                Object next2 = it.next();
                Intrinsics.checkNotNull(next2, "null cannot be cast to non-null type kotlin.Int");
                createFlashTransferParam.scene = values[((Integer) next2).intValue()];
            } else if (Intrinsics.areEqual(next, "name")) {
                Object next3 = it.next();
                Intrinsics.checkNotNull(next3, "null cannot be cast to non-null type kotlin.String");
                createFlashTransferParam.name = (String) next3;
            } else {
                if (Intrinsics.areEqual(next, "uploaders")) {
                    Object next4 = it.next();
                    Intrinsics.checkNotNull(next4, "null cannot be cast to non-null type kotlin.Int");
                    int intValue = ((Integer) next4).intValue();
                    ArrayList<Uploader> arrayList = new ArrayList<>();
                    for (int i3 = 0; i3 < intValue; i3++) {
                        Object next5 = it.next();
                        Intrinsics.checkNotNull(next5, "null cannot be cast to non-null type kotlin.Int");
                        int intValue2 = ((Integer) next5).intValue();
                        Object[] objArr2 = new Object[intValue2];
                        for (int i16 = 0; i16 < intValue2; i16++) {
                            objArr2[i16] = it.next();
                        }
                        arrayList.add(cb.b(objArr2));
                    }
                    createFlashTransferParam.uploaders = arrayList;
                } else if (Intrinsics.areEqual(next, QCircleDaTongConstant.ElementParamValue.PERMISSION)) {
                    Object next6 = it.next();
                    Intrinsics.checkNotNull(next6, "null cannot be cast to non-null type kotlin.Int");
                    int intValue3 = ((Integer) next6).intValue();
                    Object[] objArr3 = new Object[intValue3];
                    for (int i17 = 0; i17 < intValue3; i17++) {
                        objArr3[i17] = it.next();
                    }
                    createFlashTransferParam.permission = bo.b(objArr3);
                } else if (Intrinsics.areEqual(next, QQWinkConstants.COVER_PATH)) {
                    Object next7 = it.next();
                    Intrinsics.checkNotNull(next7, "null cannot be cast to non-null type kotlin.String");
                    createFlashTransferParam.coverPath = (String) next7;
                } else if (Intrinsics.areEqual(next, "coverOriginalInfos")) {
                    Object next8 = it.next();
                    Intrinsics.checkNotNull(next8, "null cannot be cast to non-null type kotlin.Int");
                    int intValue4 = ((Integer) next8).intValue();
                    ArrayList<CoverOriginalInfo> arrayList2 = new ArrayList<>();
                    for (int i18 = 0; i18 < intValue4; i18++) {
                        Object next9 = it.next();
                        Intrinsics.checkNotNull(next9, "null cannot be cast to non-null type kotlin.Int");
                        int intValue5 = ((Integer) next9).intValue();
                        Object[] objArr4 = new Object[intValue5];
                        for (int i19 = 0; i19 < intValue5; i19++) {
                            objArr4[i19] = it.next();
                        }
                        arrayList2.add(l.a(objArr4));
                    }
                    createFlashTransferParam.coverOriginalInfos = arrayList2;
                } else if (Intrinsics.areEqual(next, "paths")) {
                    Object next10 = it.next();
                    Intrinsics.checkNotNull(next10, "null cannot be cast to non-null type kotlin.Int");
                    int intValue6 = ((Integer) next10).intValue();
                    ArrayList arrayList3 = new ArrayList(intValue6);
                    for (int i26 = 0; i26 < intValue6; i26++) {
                        Object next11 = it.next();
                        Intrinsics.checkNotNull(next11, "null cannot be cast to non-null type kotlin.String");
                        arrayList3.add((String) next11);
                    }
                    createFlashTransferParam.paths = new ArrayList<>(arrayList3);
                } else if (Intrinsics.areEqual(next, "excludePaths")) {
                    Object next12 = it.next();
                    Intrinsics.checkNotNull(next12, "null cannot be cast to non-null type kotlin.Int");
                    int intValue7 = ((Integer) next12).intValue();
                    ArrayList arrayList4 = new ArrayList(intValue7);
                    for (int i27 = 0; i27 < intValue7; i27++) {
                        Object next13 = it.next();
                        Intrinsics.checkNotNull(next13, "null cannot be cast to non-null type kotlin.String");
                        arrayList4.add((String) next13);
                    }
                    createFlashTransferParam.excludePaths = new ArrayList<>(arrayList4);
                } else if (Intrinsics.areEqual(next, "expireLeftTime")) {
                    Object next14 = it.next();
                    Intrinsics.checkNotNull(next14, "null cannot be cast to non-null type kotlin.String");
                    createFlashTransferParam.expireLeftTime = Integer.parseInt((String) next14);
                } else if (Intrinsics.areEqual(next, "isNeedDelExif")) {
                    Object next15 = it.next();
                    Intrinsics.checkNotNull(next15, "null cannot be cast to non-null type kotlin.Int");
                    createFlashTransferParam.isNeedDelExif = ((Integer) next15).intValue() == 1;
                }
            }
        }
        return createFlashTransferParam;
    }
}
