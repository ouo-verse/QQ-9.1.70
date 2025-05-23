package com.tencent.mobileqq.zplan.aigc.helper;

import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.zplan.avatar.image.sharpP.ZPlanAvatarShpImageUploadDownloadUtils;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.utils.ab;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002 !B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ,\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0002J<\u0010\u0010\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0002H\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0002J \u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\b\u001a\u0004\u0018\u00010\u0015R\u0014\u0010\u0019\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/helper/ZPlanUGCDyeingPublishHelper;", "", "", "dirPath", "ugcId", "Lkotlin/Function1;", "", "", "callback", "g", "", "resourceFileList", "uuidList", "Ljava/io/File;", "rootDir", "resourceDirAbsolutePath", "i", "e", "resourcePath", "Lzv4/a;", "ugcItem", "Lcom/tencent/mobileqq/zplan/aigc/helper/ZPlanUGCDyeingPublishHelper$a;", "f", "b", "Ljava/lang/String;", "TAG", "Lzv4/b;", "c", "Lzv4/b;", "cosData", "<init>", "()V", "a", "UGCResourceName", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanUGCDyeingPublishHelper {

    /* renamed from: a, reason: collision with root package name */
    public static final ZPlanUGCDyeingPublishHelper f330232a = new ZPlanUGCDyeingPublishHelper();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final String TAG = "ZPlanUGCDyeingPublishHelper";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static zv4.b cosData = new zv4.b();

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/helper/ZPlanUGCDyeingPublishHelper$UGCResourceName;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", HippyTextInputController.COMMAND_getValue, "()Ljava/lang/String;", "TEXTURE", "ICON", "OPERATE_DATA", "CONFIG_DATA", "THUMBNAIL", "zplan_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public enum UGCResourceName {
        TEXTURE("Texture"),
        ICON("Icon"),
        OPERATE_DATA("OperateData"),
        CONFIG_DATA("ConfigData"),
        THUMBNAIL("Thumbnail");

        private final String value;

        UGCResourceName(String str) {
            this.value = str;
        }

        public final String getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/helper/ZPlanUGCDyeingPublishHelper$a;", "", "", "onSuccess", "", "errorMsg", "onFailed", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public interface a {
        void onFailed(String errorMsg);

        void onSuccess();
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public static final class b<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(((File) t16).getName(), ((File) t17).getName());
            return compareValues;
        }
    }

    ZPlanUGCDyeingPublishHelper() {
    }

    private final String e() {
        String b16 = ab.INSTANCE.b();
        if (!Intrinsics.areEqual(b16, "191") && !Intrinsics.areEqual(b16, "417")) {
            return "Shipping";
        }
        return "Dev";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(Ref.ObjectRef<List<Boolean>> objectRef, Function1<? super Boolean, Unit> function1) {
        QLog.e(TAG, 2, "checkUploadSuccess: " + objectRef.element);
        if (objectRef.element.contains(Boolean.FALSE)) {
            return;
        }
        function1.invoke(Boolean.TRUE);
    }

    private final void i(List<String> resourceFileList, List<String> uuidList, File rootDir, String ugcId, String resourceDirAbsolutePath) {
        List<File> sortedWith;
        boolean contains$default;
        String replace$default;
        if (rootDir.exists() && rootDir.isDirectory()) {
            File[] listFiles = rootDir.listFiles();
            String e16 = e();
            if (listFiles != null) {
                ArrayList arrayList = new ArrayList();
                for (File file : listFiles) {
                    if (file.isFile()) {
                        arrayList.add(file);
                    }
                }
                sortedWith = CollectionsKt___CollectionsKt.sortedWith(arrayList, new b());
                if (sortedWith != null) {
                    for (File file2 : sortedWith) {
                        String name = file2.getName();
                        Intrinsics.checkNotNullExpressionValue(name, "it.name");
                        contains$default = StringsKt__StringsKt.contains$default((CharSequence) name, (CharSequence) ".zip", false, 2, (Object) null);
                        if (contains$default) {
                            file2.delete();
                        } else {
                            String name2 = file2.getParentFile().getName();
                            if (Intrinsics.areEqual(name2, UGCResourceName.TEXTURE.getValue())) {
                                cosData.f453563a++;
                            } else if (Intrinsics.areEqual(name2, UGCResourceName.ICON.getValue())) {
                                cosData.f453564b++;
                            } else if (Intrinsics.areEqual(name2, UGCResourceName.OPERATE_DATA.getValue())) {
                                cosData.f453565c++;
                            } else if (Intrinsics.areEqual(name2, UGCResourceName.CONFIG_DATA.getValue())) {
                                cosData.f453566d++;
                            } else if (Intrinsics.areEqual(name2, UGCResourceName.THUMBNAIL.getValue())) {
                                cosData.f453567e++;
                            }
                            String absolutePath = file2.getAbsolutePath();
                            Intrinsics.checkNotNullExpressionValue(absolutePath, "it.absolutePath");
                            resourceFileList.add(absolutePath);
                            String absolutePath2 = file2.getAbsolutePath();
                            Intrinsics.checkNotNullExpressionValue(absolutePath2, "it.absolutePath");
                            replace$default = StringsKt__StringsJVMKt.replace$default(absolutePath2, resourceDirAbsolutePath, e16 + "/Avatar/" + ugcId, false, 4, (Object) null);
                            uuidList.add(replace$default);
                        }
                    }
                }
            }
            if (listFiles != null) {
                ArrayList<File> arrayList2 = new ArrayList();
                for (File file3 : listFiles) {
                    if (file3.isDirectory()) {
                        arrayList2.add(file3);
                    }
                }
                for (File it : arrayList2) {
                    ZPlanUGCDyeingPublishHelper zPlanUGCDyeingPublishHelper = f330232a;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    zPlanUGCDyeingPublishHelper.i(resourceFileList, uuidList, it, ugcId, resourceDirAbsolutePath);
                }
            }
        }
    }

    public final void f(String resourcePath, zv4.a ugcItem, a callback) {
        Intrinsics.checkNotNullParameter(resourcePath, "resourcePath");
        Intrinsics.checkNotNullParameter(ugcItem, "ugcItem");
        if (!(resourcePath.length() == 0) && new File(resourcePath).exists() && new File(resourcePath).isDirectory()) {
            CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.f.f261784e);
            if (f16 != null) {
                CorountineFunKt.e(f16, TAG + "_uploadResourceFiles", null, null, null, new ZPlanUGCDyeingPublishHelper$publishDyeingUGC$1(resourcePath, ugcItem, callback, null), 14, null);
                return;
            }
            return;
        }
        QLog.e(TAG, 1, "resourcePath is invalid.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r2v3, types: [T, java.util.ArrayList] */
    public final void g(String dirPath, String ugcId, final Function1<? super Boolean, Unit> callback) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (dirPath.length() == 0) {
            return;
        }
        File file = new File(dirPath);
        if (file.exists() && file.isDirectory()) {
            i(arrayList, arrayList2, file, ugcId, dirPath);
            String str = dirPath + "/" + ugcId + "_texture.zip";
            try {
                com.tencent.open.base.l.d(dirPath, str);
            } catch (Throwable th5) {
                QLog.e(TAG, 1, "compress file error", th5);
            }
            arrayList.add(str);
            arrayList2.add("QQShow" + e() + "/Game/CMShow/Assets/Other/Avatar2Design/" + ugcId + "/Filement/" + ugcId + "_texture.zip");
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            int size = arrayList.size();
            ?? arrayList3 = new ArrayList(size);
            for (int i3 = 0; i3 < size; i3++) {
                arrayList3.add(Boolean.FALSE);
            }
            objectRef.element = arrayList3;
            int size2 = arrayList.size();
            for (final int i16 = 0; i16 < size2; i16++) {
                QLog.e(TAG, 2, "upload cos file: " + ((Object) arrayList.get(i16)));
                ZPlanAvatarShpImageUploadDownloadUtils.INSTANCE.c().j(System.currentTimeMillis() + ((long) i16), arrayList.get(i16), arrayList2.get(i16), false, FileMsg.TRANSFILE_TYPE_ZPLAN_UGC_DYEING, new Function2<Boolean, String, Unit>() { // from class: com.tencent.mobileqq.zplan.aigc.helper.ZPlanUGCDyeingPublishHelper$uploadResourceFiles$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, String str2) {
                        invoke(bool.booleanValue(), str2);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z16, String url) {
                        String str2;
                        String str3;
                        Intrinsics.checkNotNullParameter(url, "url");
                        if (!z16) {
                            str3 = ZPlanUGCDyeingPublishHelper.TAG;
                            QLog.e(str3, 2, "publishDyeingUGC failed!!! index: " + i16 + " url: " + url);
                            callback.invoke(Boolean.FALSE);
                            return;
                        }
                        str2 = ZPlanUGCDyeingPublishHelper.TAG;
                        QLog.e(str2, 2, "publishDyeingUGC index: " + i16 + " url: " + url);
                        objectRef.element.set(i16, Boolean.TRUE);
                        ZPlanUGCDyeingPublishHelper.h(objectRef, callback);
                    }
                });
            }
        }
    }
}
