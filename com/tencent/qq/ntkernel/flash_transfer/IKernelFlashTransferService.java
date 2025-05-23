package com.tencent.qq.ntkernel.flash_transfer;

import com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFlashTransferViewModel$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.Module;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import vs3.a;
import ws3.ab;
import ws3.bo;
import ws3.br;
import ws3.bs;
import ws3.bv;
import ws3.cu;
import ws3.cv;
import ws3.cw;
import ws3.cx;
import ws3.cy;
import ws3.cz;
import ws3.da;
import ws3.db;
import ws3.dh;
import ws3.di;
import ws3.dn;
import ws3.dp;
import ws3.dq;
import ws3.dr;
import ws3.ds;
import ws3.du;
import ws3.dv;
import ws3.dw;
import ws3.y;
import ws3.z;

/* compiled from: P */
/* loaded from: classes34.dex */
public final class IKernelFlashTransferService extends Module {

    /* renamed from: i, reason: collision with root package name */
    public static final a f344757i = new a();

    /* renamed from: a, reason: collision with root package name */
    public final Map<dp, Function1<Object, Unit>> f344758a = new LinkedHashMap();

    /* renamed from: b, reason: collision with root package name */
    public final Map<di, Function1<Object, Unit>> f344759b = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name */
    public final Map<cz, Function1<Object, Unit>> f344760c = new LinkedHashMap();

    /* renamed from: d, reason: collision with root package name */
    public final Map<cy, Function1<Object, Unit>> f344761d;

    /* renamed from: e, reason: collision with root package name */
    public final Map<cv, Function1<Object, Unit>> f344762e;

    /* renamed from: f, reason: collision with root package name */
    public final Map<da, Function1<Object, Unit>> f344763f;

    /* renamed from: g, reason: collision with root package name */
    public final Map<cw, Function1<Object, Unit>> f344764g;

    /* renamed from: h, reason: collision with root package name */
    public final Map<dh, Function1<Object, Unit>> f344765h;

    /* compiled from: P */
    /* loaded from: classes34.dex */
    public static final class a {
        public final IKernelFlashTransferService a() {
            return (IKernelFlashTransferService) c.f117352a.g().acquireModule("KTIKernelFlashTransferService");
        }
    }

    public IKernelFlashTransferService() {
        new LinkedHashMap();
        this.f344761d = new LinkedHashMap();
        new LinkedHashMap();
        this.f344762e = new LinkedHashMap();
        this.f344763f = new LinkedHashMap();
        this.f344764g = new LinkedHashMap();
        this.f344765h = new LinkedHashMap();
    }

    public final void a(String str, List<String> list) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        arrayList.add(Integer.valueOf(list.size()));
        arrayList.addAll(list);
        Object[] array = arrayList.toArray(new Object[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        syncToNativeMethod(true, "addFileSetSimpleStatusMonitoring", array, null);
    }

    public final void b(final dp dpVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(String.valueOf(dpVar.hashCode()));
        Function1<Object, Unit> function1 = new Function1<Object, Unit>() { // from class: com.tencent.qq.ntkernel.flash_transfer.IKernelFlashTransferService$addFileSetUploadListener$fileSetUploadListener$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                Object[] objArr = obj instanceof Object[] ? (Object[]) obj : null;
                if (objArr != null) {
                    int i3 = 0;
                    if (!(objArr.length == 0)) {
                        Iterator it = ArrayIteratorKt.iterator(objArr);
                        String str = (String) dr.a(it, "null cannot be cast to non-null type kotlin.String");
                        switch (str.hashCode()) {
                            case -627941691:
                                if (str.equals("onFileUploadDidError")) {
                                    Object next = it.next();
                                    Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.Int");
                                    int intValue = ((Integer) next).intValue();
                                    Object[] objArr2 = new Object[intValue];
                                    while (i3 < intValue) {
                                        objArr2[i3] = it.next();
                                        i3++;
                                    }
                                    dp.this.onFileUploadDidError(bo.b(objArr2));
                                    break;
                                }
                                break;
                            case 209011679:
                                if (str.equals("onFileDidStartUpload")) {
                                    Object next2 = it.next();
                                    Intrinsics.checkNotNull(next2, "null cannot be cast to non-null type kotlin.Int");
                                    int intValue2 = ((Integer) next2).intValue();
                                    Object[] objArr3 = new Object[intValue2];
                                    while (i3 < intValue2) {
                                        objArr3[i3] = it.next();
                                        i3++;
                                    }
                                    dp.this.onFileDidStartUpload(bo.b(objArr3));
                                    break;
                                }
                                break;
                            case 320244198:
                                if (str.equals("onFileUploadStatusChanged")) {
                                    Object next3 = it.next();
                                    Intrinsics.checkNotNull(next3, "null cannot be cast to non-null type kotlin.Int");
                                    int intValue3 = ((Integer) next3).intValue();
                                    Object[] objArr4 = new Object[intValue3];
                                    while (i3 < intValue3) {
                                        objArr4[i3] = it.next();
                                        i3++;
                                    }
                                    dp.this.onFileUploadStatusChanged(bo.b(objArr4));
                                    break;
                                }
                                break;
                            case 632109919:
                                if (str.equals("onFileSetUploadProgressChanged")) {
                                    Object next4 = it.next();
                                    Intrinsics.checkNotNull(next4, "null cannot be cast to non-null type kotlin.Int");
                                    int intValue4 = ((Integer) next4).intValue();
                                    Object[] objArr5 = new Object[intValue4];
                                    for (int i16 = 0; i16 < intValue4; i16++) {
                                        objArr5[i16] = it.next();
                                    }
                                    Iterator it5 = ArrayIteratorKt.iterator(objArr5);
                                    bv bvVar = new bv(new br(), 0L, 0L, 0L, 0L, 0L);
                                    while (it5.hasNext()) {
                                        Object next5 = it5.next();
                                        if (Intrinsics.areEqual(next5, "fileSet")) {
                                            Object next6 = it5.next();
                                            Intrinsics.checkNotNull(next6, "null cannot be cast to non-null type kotlin.Int");
                                            int intValue5 = ((Integer) next6).intValue();
                                            Object[] objArr6 = new Object[intValue5];
                                            for (int i17 = 0; i17 < intValue5; i17++) {
                                                objArr6[i17] = it5.next();
                                            }
                                            bvVar.f446213a = bs.a(objArr6);
                                        } else if (Intrinsics.areEqual(next5, "uploadedFileCount")) {
                                            Object next7 = it5.next();
                                            Intrinsics.checkNotNull(next7, "null cannot be cast to non-null type kotlin.String");
                                            bvVar.f446214b = a.b((String) next7);
                                        } else if (Intrinsics.areEqual(next5, "failedFileCount")) {
                                            Object next8 = it5.next();
                                            Intrinsics.checkNotNull(next8, "null cannot be cast to non-null type kotlin.String");
                                            a.b((String) next8);
                                        } else if (Intrinsics.areEqual(next5, "totalFileCount")) {
                                            Object next9 = it5.next();
                                            Intrinsics.checkNotNull(next9, "null cannot be cast to non-null type kotlin.String");
                                            bvVar.f446215c = a.b((String) next9);
                                        } else if (Intrinsics.areEqual(next5, "uploadedFileSize")) {
                                            Object next10 = it5.next();
                                            Intrinsics.checkNotNull(next10, "null cannot be cast to non-null type kotlin.String");
                                            bvVar.f446216d = a.b((String) next10);
                                        } else if (Intrinsics.areEqual(next5, "uploadSpeed")) {
                                            Object next11 = it5.next();
                                            Intrinsics.checkNotNull(next11, "null cannot be cast to non-null type kotlin.String");
                                            bvVar.f446217e = a.b((String) next11);
                                        } else if (Intrinsics.areEqual(next5, "vipUploadSpeed")) {
                                            Object next12 = it5.next();
                                            Intrinsics.checkNotNull(next12, "null cannot be cast to non-null type kotlin.String");
                                            a.b((String) next12);
                                        } else if (Intrinsics.areEqual(next5, "timeRemain")) {
                                            Object next13 = it5.next();
                                            Intrinsics.checkNotNull(next13, "null cannot be cast to non-null type kotlin.String");
                                            bvVar.f446218f = a.b((String) next13);
                                        }
                                    }
                                    dp.this.onFileSetUploadProgressChanged(bvVar);
                                    break;
                                }
                                break;
                            case 900078586:
                                if (str.equals("onFileSetUploadStatusChanged")) {
                                    Object next14 = it.next();
                                    Intrinsics.checkNotNull(next14, "null cannot be cast to non-null type kotlin.Int");
                                    int intValue6 = ((Integer) next14).intValue();
                                    Object[] objArr7 = new Object[intValue6];
                                    while (i3 < intValue6) {
                                        objArr7[i3] = it.next();
                                        i3++;
                                    }
                                    dp.this.onFileSetUploadStatusChanged(bs.a(objArr7));
                                    break;
                                }
                                break;
                            case 1090949400:
                                if (str.equals("onFileDidFinishUpload")) {
                                    Object next15 = it.next();
                                    Intrinsics.checkNotNull(next15, "null cannot be cast to non-null type kotlin.Int");
                                    int intValue7 = ((Integer) next15).intValue();
                                    Object[] objArr8 = new Object[intValue7];
                                    while (i3 < intValue7) {
                                        objArr8[i3] = it.next();
                                        i3++;
                                    }
                                    dp.this.onFileDidFinishUpload(bo.b(objArr8));
                                    break;
                                }
                                break;
                            case 1737728665:
                                if (str.equals("onFileStaticStatusChanged")) {
                                    Object next16 = it.next();
                                    Intrinsics.checkNotNull(next16, "null cannot be cast to non-null type kotlin.Int");
                                    int intValue8 = ((Integer) next16).intValue();
                                    Object[] objArr9 = new Object[intValue8];
                                    while (i3 < intValue8) {
                                        objArr9[i3] = it.next();
                                        i3++;
                                    }
                                    dp.this.onFileStaticStatusChanged(bo.b(objArr9));
                                    break;
                                }
                                break;
                            case 1757011531:
                                if (str.equals("onFileUploadProgressChanged")) {
                                    Object next17 = it.next();
                                    Intrinsics.checkNotNull(next17, "null cannot be cast to non-null type kotlin.Int");
                                    int intValue9 = ((Integer) next17).intValue();
                                    Object[] objArr10 = new Object[intValue9];
                                    while (i3 < intValue9) {
                                        objArr10[i3] = it.next();
                                        i3++;
                                    }
                                    ab b16 = bo.b(objArr10);
                                    Object next18 = it.next();
                                    Intrinsics.checkNotNull(next18, "null cannot be cast to non-null type kotlin.String");
                                    long b17 = a.b((String) next18);
                                    Object next19 = it.next();
                                    Intrinsics.checkNotNull(next19, "null cannot be cast to non-null type kotlin.String");
                                    dp.this.mo121onFileUploadProgressChangedZFynlJw(b16, b17, a.b((String) next19));
                                    break;
                                }
                                break;
                            case 1932575143:
                                if (str.equals("onThumbnailGeneratePath")) {
                                    Object next20 = it.next();
                                    Intrinsics.checkNotNull(next20, "null cannot be cast to non-null type kotlin.Int");
                                    int intValue10 = ((Integer) next20).intValue();
                                    Object[] objArr11 = new Object[intValue10];
                                    while (i3 < intValue10) {
                                        objArr11[i3] = it.next();
                                        i3++;
                                    }
                                    Iterator it6 = ArrayIteratorKt.iterator(objArr11);
                                    while (it6.hasNext()) {
                                        Object next21 = it6.next();
                                        if (Intrinsics.areEqual(next21, "result")) {
                                            Object next22 = it6.next();
                                            Intrinsics.checkNotNull(next22, "null cannot be cast to non-null type kotlin.Int");
                                            ((Integer) next22).intValue();
                                        } else if (Intrinsics.areEqual(next21, "errMsg")) {
                                            Object next23 = it6.next();
                                            Intrinsics.checkNotNull(next23, "null cannot be cast to non-null type kotlin.String");
                                        } else if (Intrinsics.areEqual(next21, "fileSetId")) {
                                            Object next24 = it6.next();
                                            Intrinsics.checkNotNull(next24, "null cannot be cast to non-null type kotlin.String");
                                        } else if (Intrinsics.areEqual(next21, "cliFileId")) {
                                            Object next25 = it6.next();
                                            Intrinsics.checkNotNull(next25, "null cannot be cast to non-null type kotlin.String");
                                        } else if (Intrinsics.areEqual(next21, "thumbnailPath")) {
                                            Object next26 = it6.next();
                                            Intrinsics.checkNotNull(next26, "null cannot be cast to non-null type kotlin.String");
                                        }
                                    }
                                    dp.this.onThumbnailGeneratePath();
                                    break;
                                }
                                break;
                            case 1935554909:
                                if (str.equals("onFileUploadDidCancel")) {
                                    Object next27 = it.next();
                                    Intrinsics.checkNotNull(next27, "null cannot be cast to non-null type kotlin.Int");
                                    int intValue11 = ((Integer) next27).intValue();
                                    Object[] objArr12 = new Object[intValue11];
                                    while (i3 < intValue11) {
                                        objArr12[i3] = it.next();
                                        i3++;
                                    }
                                    dp.this.onFileUploadDidCancel(bo.b(objArr12));
                                    break;
                                }
                                break;
                        }
                    }
                }
                return Unit.INSTANCE;
            }
        };
        Object[] array = arrayList.toArray(new Object[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        syncToNativeMethod(true, "addFileSetUploadListener", array, function1);
        this.f344758a.put(dpVar, function1);
    }

    public final void c(List list, final cu cuVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(dq.a(1));
        arrayList.add(Integer.valueOf(list.size()));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Object[] a16 = bo.a((ab) it.next());
            arrayList.add(Integer.valueOf(a16.length));
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, a16);
        }
        arrayList.add(String.valueOf(cuVar.hashCode()));
        Function1<Object, Unit> function1 = new Function1<Object, Unit>() { // from class: com.tencent.qq.ntkernel.flash_transfer.IKernelFlashTransferService$cleanFailedFiles$kernelCallback$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                Object[] objArr = obj instanceof Object[] ? (Object[]) obj : null;
                if (objArr != null) {
                    if (!(objArr.length == 0)) {
                        Iterator it5 = ArrayIteratorKt.iterator(objArr);
                        if (Intrinsics.areEqual((String) dr.a(it5, "null cannot be cast to non-null type kotlin.String"), "onCleanFailedFilesResult")) {
                            Object next = it5.next();
                            Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.Int");
                            int intValue = ((Integer) next).intValue();
                            Object next2 = it5.next();
                            Intrinsics.checkNotNull(next2, "null cannot be cast to non-null type kotlin.String");
                            cu.this.onCleanFailedFilesResult(intValue, (String) next2);
                        }
                    }
                }
                return Unit.INSTANCE;
            }
        };
        Object[] array = arrayList.toArray(new Object[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        syncToNativeMethod(true, "cleanFailedFiles", array, function1);
    }

    public final void d(ds dsVar, final db dbVar) {
        ArrayList arrayList = new ArrayList();
        Object[] a16 = du.a(dsVar);
        arrayList.add(Integer.valueOf(a16.length));
        CollectionsKt__MutableCollectionsKt.addAll(arrayList, a16);
        arrayList.add(String.valueOf(dbVar.hashCode()));
        Function1<Object, Unit> function1 = new Function1<Object, Unit>() { // from class: com.tencent.qq.ntkernel.flash_transfer.IKernelFlashTransferService$getFileSetClusteringDetail$kernelCallback$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                List emptyList;
                Object[] objArr = obj instanceof Object[] ? (Object[]) obj : null;
                if (objArr != null) {
                    if (!(objArr.length == 0)) {
                        Iterator it = ArrayIteratorKt.iterator(objArr);
                        if (Intrinsics.areEqual((String) dr.a(it, "null cannot be cast to non-null type kotlin.String"), "onGetClusteringDetail")) {
                            Object next = it.next();
                            Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.Int");
                            int intValue = ((Integer) next).intValue();
                            Object[] objArr2 = new Object[intValue];
                            for (int i3 = 0; i3 < intValue; i3++) {
                                objArr2[i3] = it.next();
                            }
                            Iterator it5 = ArrayIteratorKt.iterator(objArr2);
                            emptyList = CollectionsKt__CollectionsKt.emptyList();
                            dv dvVar = new dv(0, "", "", new byte[0], false, emptyList, new dw());
                            while (it5.hasNext()) {
                                Object next2 = it5.next();
                                if (Intrinsics.areEqual(next2, "seq")) {
                                    Object next3 = it5.next();
                                    Intrinsics.checkNotNull(next3, "null cannot be cast to non-null type kotlin.Int");
                                    ((Integer) next3).intValue();
                                } else if (Intrinsics.areEqual(next2, "result")) {
                                    Object next4 = it5.next();
                                    Intrinsics.checkNotNull(next4, "null cannot be cast to non-null type kotlin.Int");
                                    dvVar.f446296a = ((Integer) next4).intValue();
                                } else if (Intrinsics.areEqual(next2, "errMs")) {
                                    Object next5 = it5.next();
                                    Intrinsics.checkNotNull(next5, "null cannot be cast to non-null type kotlin.String");
                                } else if (Intrinsics.areEqual(next2, "fileSetId")) {
                                    Object next6 = it5.next();
                                    Intrinsics.checkNotNull(next6, "null cannot be cast to non-null type kotlin.String");
                                    dvVar.f446297b = (String) next6;
                                } else if (Intrinsics.areEqual(next2, "type")) {
                                    Object next7 = it5.next();
                                    Intrinsics.checkNotNull(next7, "null cannot be cast to non-null type kotlin.Int{ com.tencent.qq.ntkernel.flash_transfer.ClusteringTypeKt.ClusteringType }");
                                    ((Integer) next7).intValue();
                                } else if (Intrinsics.areEqual(next2, "clusteringId")) {
                                    Object next8 = it5.next();
                                    Intrinsics.checkNotNull(next8, "null cannot be cast to non-null type kotlin.String");
                                    dvVar.f446298c = (String) next8;
                                } else if (Intrinsics.areEqual(next2, "paginationInfo")) {
                                    Object next9 = it5.next();
                                    Intrinsics.checkNotNull(next9, "null cannot be cast to non-null type kotlin.ByteArray");
                                    dvVar.f446299d = (byte[]) next9;
                                } else if (Intrinsics.areEqual(next2, "isEnd")) {
                                    Object next10 = it5.next();
                                    Intrinsics.checkNotNull(next10, "null cannot be cast to non-null type kotlin.Int");
                                    dvVar.f446300e = ((Integer) next10).intValue() == 1;
                                } else if (Intrinsics.areEqual(next2, "fileLists")) {
                                    Object next11 = it5.next();
                                    Intrinsics.checkNotNull(next11, "null cannot be cast to non-null type kotlin.Int");
                                    int intValue2 = ((Integer) next11).intValue();
                                    ArrayList arrayList2 = new ArrayList();
                                    for (int i16 = 0; i16 < intValue2; i16++) {
                                        Object next12 = it5.next();
                                        Intrinsics.checkNotNull(next12, "null cannot be cast to non-null type kotlin.Int");
                                        int intValue3 = ((Integer) next12).intValue();
                                        Object[] objArr3 = new Object[intValue3];
                                        for (int i17 = 0; i17 < intValue3; i17++) {
                                            objArr3[i17] = it5.next();
                                        }
                                        arrayList2.add(bo.b(objArr3));
                                    }
                                    dvVar.f446301f = arrayList2;
                                } else if (Intrinsics.areEqual(next2, "totalInfo")) {
                                    Object next13 = it5.next();
                                    Intrinsics.checkNotNull(next13, "null cannot be cast to non-null type kotlin.Int");
                                    int intValue4 = ((Integer) next13).intValue();
                                    Object[] objArr4 = new Object[intValue4];
                                    for (int i18 = 0; i18 < intValue4; i18++) {
                                        objArr4[i18] = it5.next();
                                    }
                                    Iterator it6 = ArrayIteratorKt.iterator(objArr4);
                                    dw dwVar = new dw();
                                    while (it6.hasNext()) {
                                        Object next14 = it6.next();
                                        if (Intrinsics.areEqual(next14, "count")) {
                                            Object next15 = it6.next();
                                            Intrinsics.checkNotNull(next15, "null cannot be cast to non-null type kotlin.String");
                                            dwVar.f446303a = a.a((String) next15);
                                        } else if (Intrinsics.areEqual(next14, "size")) {
                                            Object next16 = it6.next();
                                            Intrinsics.checkNotNull(next16, "null cannot be cast to non-null type kotlin.String");
                                            dwVar.f446304b = a.b((String) next16);
                                        }
                                    }
                                    dvVar.f446302g = dwVar;
                                }
                            }
                            db.this.onGetClusteringDetail(dvVar);
                        }
                    }
                }
                return Unit.INSTANCE;
            }
        };
        Object[] array = arrayList.toArray(new Object[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        syncToNativeMethod(true, "getFileSetClusteringDetail", array, function1);
    }

    public final void e(String str, final dn dnVar) {
        ArrayList m3 = QQFlashTransferViewModel$$ExternalSyntheticOutline0.m(str);
        m3.add(String.valueOf(dnVar.hashCode()));
        Function1<Object, Unit> function1 = new Function1<Object, Unit>() { // from class: com.tencent.qq.ntkernel.flash_transfer.IKernelFlashTransferService$getShareLinkReq$kernelCallback$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                Object[] objArr = obj instanceof Object[] ? (Object[]) obj : null;
                if (objArr != null) {
                    if (!(objArr.length == 0)) {
                        Iterator it = ArrayIteratorKt.iterator(objArr);
                        if (Intrinsics.areEqual((String) dr.a(it, "null cannot be cast to non-null type kotlin.String"), "onGetShareLink")) {
                            Object next = it.next();
                            Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.String");
                            String str2 = (String) next;
                            Object next2 = it.next();
                            Intrinsics.checkNotNull(next2, "null cannot be cast to non-null type kotlin.String");
                            long b16 = a.b((String) next2);
                            Object next3 = it.next();
                            Intrinsics.checkNotNull(next3, "null cannot be cast to non-null type kotlin.Int");
                            int intValue = ((Integer) next3).intValue();
                            Object next4 = it.next();
                            Intrinsics.checkNotNull(next4, "null cannot be cast to non-null type kotlin.String");
                            dn.this.mo122onGetShareLink32etgaw(str2, b16, intValue, (String) next4);
                        }
                    }
                }
                return Unit.INSTANCE;
            }
        };
        Object[] array = m3.toArray(new Object[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        syncToNativeMethod(true, "getShareLinkReq", array, function1);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.LinkedHashMap, java.util.Map<ws3.cw, kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit>>] */
    public final void f(cw cwVar) {
        Function1<Object, Unit> function1 = (Function1) this.f344764g.get(cwVar);
        if (function1 != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(String.valueOf(cwVar.hashCode()));
            Object[] array = arrayList.toArray(new Object[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            asyncToNativeMethod("removeCompressedFileListener", array, function1);
            this.f344764g.remove(cwVar);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.LinkedHashMap, java.util.Map<ws3.dh, kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit>>] */
    public final void g(dh dhVar) {
        Function1<Object, Unit> function1 = (Function1) this.f344765h.get(dhVar);
        if (function1 != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(String.valueOf(dhVar.hashCode()));
            Object[] array = arrayList.toArray(new Object[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            asyncToNativeMethod("removeDeviceStatusListener", array, function1);
            this.f344765h.remove(dhVar);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.LinkedHashMap, java.util.Map<ws3.cv, kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit>>] */
    public final void h(cv cvVar) {
        Function1<Object, Unit> function1 = (Function1) this.f344762e.get(cvVar);
        if (function1 != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(String.valueOf(cvVar.hashCode()));
            Object[] array = arrayList.toArray(new Object[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            asyncToNativeMethod("removeFileSetClusteringListListener", array, function1);
            this.f344762e.remove(cvVar);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.LinkedHashMap, java.util.Map<ws3.di, kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit>>] */
    public final void i(di diVar) {
        Function1<Object, Unit> function1 = (Function1) this.f344759b.get(diVar);
        if (function1 != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(String.valueOf(diVar.hashCode()));
            Object[] array = arrayList.toArray(new Object[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            asyncToNativeMethod("removeFileSetDownloadListener", array, function1);
            this.f344759b.remove(diVar);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.Map<ws3.cy, kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit>>, java.util.LinkedHashMap] */
    public final void j(cy cyVar) {
        Function1<Object, Unit> function1 = (Function1) this.f344761d.get(cyVar);
        if (function1 != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(String.valueOf(cyVar.hashCode()));
            Object[] array = arrayList.toArray(new Object[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            asyncToNativeMethod("removeFileSetSimpleUploadInfoListener", array, function1);
            this.f344761d.remove(cyVar);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.LinkedHashMap, java.util.Map<ws3.dp, kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit>>] */
    public final void k(dp dpVar) {
        Function1<Object, Unit> function1 = (Function1) this.f344758a.get(dpVar);
        if (function1 != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(String.valueOf(dpVar.hashCode()));
            Object[] array = arrayList.toArray(new Object[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            asyncToNativeMethod("removeFileSetUploadListener", array, function1);
            this.f344758a.remove(dpVar);
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.LinkedHashMap, java.util.Map<ws3.da, kotlin.jvm.functions.Function1<java.lang.Object, kotlin.Unit>>] */
    public final void l(da daVar) {
        Function1<Object, Unit> function1 = (Function1) this.f344763f.get(daVar);
        if (function1 != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(String.valueOf(daVar.hashCode()));
            Object[] array = arrayList.toArray(new Object[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            asyncToNativeMethod("removeFolderListener", array, function1);
            this.f344763f.remove(daVar);
        }
    }

    public final void m(String str, y yVar, final cx cxVar) {
        ArrayList m3 = QQFlashTransferViewModel$$ExternalSyntheticOutline0.m(str);
        Object[] a16 = z.a(yVar);
        m3.add(Integer.valueOf(a16.length));
        CollectionsKt__MutableCollectionsKt.addAll(m3, a16);
        m3.add(String.valueOf(cxVar.hashCode()));
        Function1<Object, Unit> function1 = new Function1<Object, Unit>() { // from class: com.tencent.qq.ntkernel.flash_transfer.IKernelFlashTransferService$resumeFileSetDownload$kernelCallback$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                Object[] objArr = obj instanceof Object[] ? (Object[]) obj : null;
                if (objArr != null) {
                    if (!(objArr.length == 0)) {
                        Iterator it = ArrayIteratorKt.iterator(objArr);
                        if (Intrinsics.areEqual((String) dr.a(it, "null cannot be cast to non-null type kotlin.String"), "onResult")) {
                            Object next = it.next();
                            Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.Int");
                            int intValue = ((Integer) next).intValue();
                            Object next2 = it.next();
                            Intrinsics.checkNotNull(next2, "null cannot be cast to non-null type kotlin.String");
                            Object next3 = it.next();
                            Intrinsics.checkNotNull(next3, "null cannot be cast to non-null type kotlin.String");
                            cx.this.mo120onResultjXDDuk8(intValue, (String) next2, a.a((String) next3));
                        }
                    }
                }
                return Unit.INSTANCE;
            }
        };
        Object[] array = m3.toArray(new Object[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        syncToNativeMethod(true, "resumeFileSetDownload", array, function1);
    }

    @Override // com.tencent.kuikly.core.module.Module
    public final String moduleName() {
        return "KTIKernelFlashTransferService";
    }

    public final void n(String str, List<ab> list, final cx cxVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        arrayList.add(Integer.valueOf(list.size()));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Object[] a16 = bo.a((ab) it.next());
            arrayList.add(Integer.valueOf(a16.length));
            CollectionsKt__MutableCollectionsKt.addAll(arrayList, a16);
        }
        arrayList.add(String.valueOf(cxVar.hashCode()));
        Function1<Object, Unit> function1 = new Function1<Object, Unit>() { // from class: com.tencent.qq.ntkernel.flash_transfer.IKernelFlashTransferService$startFileListDownLoad$kernelCallback$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                Object[] objArr = obj instanceof Object[] ? (Object[]) obj : null;
                if (objArr != null) {
                    if (!(objArr.length == 0)) {
                        Iterator it5 = ArrayIteratorKt.iterator(objArr);
                        if (Intrinsics.areEqual((String) dr.a(it5, "null cannot be cast to non-null type kotlin.String"), "onResult")) {
                            Object next = it5.next();
                            Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.Int");
                            int intValue = ((Integer) next).intValue();
                            Object next2 = it5.next();
                            Intrinsics.checkNotNull(next2, "null cannot be cast to non-null type kotlin.String");
                            Object next3 = it5.next();
                            Intrinsics.checkNotNull(next3, "null cannot be cast to non-null type kotlin.String");
                            cx.this.mo120onResultjXDDuk8(intValue, (String) next2, a.a((String) next3));
                        }
                    }
                }
                return Unit.INSTANCE;
            }
        };
        Object[] array = arrayList.toArray(new Object[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        syncToNativeMethod(true, "startFileListDownLoad", array, function1);
    }

    public final void o(String str, y yVar, final cx cxVar) {
        ArrayList m3 = QQFlashTransferViewModel$$ExternalSyntheticOutline0.m(str);
        Object[] a16 = z.a(yVar);
        m3.add(Integer.valueOf(a16.length));
        CollectionsKt__MutableCollectionsKt.addAll(m3, a16);
        m3.add(String.valueOf(cxVar.hashCode()));
        Function1<Object, Unit> function1 = new Function1<Object, Unit>() { // from class: com.tencent.qq.ntkernel.flash_transfer.IKernelFlashTransferService$stopFileSetDownload$kernelCallback$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                Object[] objArr = obj instanceof Object[] ? (Object[]) obj : null;
                if (objArr != null) {
                    if (!(objArr.length == 0)) {
                        Iterator it = ArrayIteratorKt.iterator(objArr);
                        if (Intrinsics.areEqual((String) dr.a(it, "null cannot be cast to non-null type kotlin.String"), "onResult")) {
                            Object next = it.next();
                            Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlin.Int");
                            int intValue = ((Integer) next).intValue();
                            Object next2 = it.next();
                            Intrinsics.checkNotNull(next2, "null cannot be cast to non-null type kotlin.String");
                            Object next3 = it.next();
                            Intrinsics.checkNotNull(next3, "null cannot be cast to non-null type kotlin.String");
                            cx.this.mo120onResultjXDDuk8(intValue, (String) next2, a.a((String) next3));
                        }
                    }
                }
                return Unit.INSTANCE;
            }
        };
        Object[] array = m3.toArray(new Object[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        syncToNativeMethod(true, "stopFileSetDownload", array, function1);
    }
}
