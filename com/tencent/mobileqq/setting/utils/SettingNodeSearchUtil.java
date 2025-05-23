package com.tencent.mobileqq.setting.utils;

import android.os.Handler;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0014B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0018\u0010\r\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/setting/utils/SettingNodeSearchUtil;", "", "", "content", "Ljq2/c;", "node", "Lcom/tencent/mobileqq/setting/utils/j;", "callback", "", "a", "Lcom/tencent/mobileqq/setting/utils/SettingNodeSearchUtil$SearchTask;", "b", "Lcom/tencent/mobileqq/setting/utils/SettingNodeSearchUtil$SearchTask;", "searchTask", "Landroid/os/Handler;", "c", "Landroid/os/Handler;", "searchHandler", "<init>", "()V", "SearchTask", "qq_setting_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class SettingNodeSearchUtil {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static SearchTask searchTask;

    /* renamed from: a, reason: collision with root package name */
    public static final SettingNodeSearchUtil f286734a = new SettingNodeSearchUtil();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static Handler searchHandler = new Handler(ThreadManagerV2.getSubThreadLooper());

    /* compiled from: P */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u00a2\u0006\u0004\b!\u0010\"J(\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002JP\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00022\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0006j\b\u0012\u0004\u0012\u00020\u0004`\b2\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bH\u0002J\b\u0010\u000f\u001a\u00020\rH\u0016J\u0006\u0010\u0010\u001a\u00020\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/setting/utils/SettingNodeSearchUtil$SearchTask;", "Ljava/lang/Runnable;", "", "content", "Ljq2/c;", "node", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/setting/utils/k;", "Lkotlin/collections/ArrayList;", "a", "path", "indexNodePath", "result", "", "b", TencentLocation.RUN_MODE, "cancel", "d", "Ljava/lang/String;", "getContent", "()Ljava/lang/String;", "e", "Ljq2/c;", "getNode", "()Ljq2/c;", "Lcom/tencent/mobileqq/setting/utils/j;", "f", "Lcom/tencent/mobileqq/setting/utils/j;", "callback", "", tl.h.F, "Z", "canceled", "<init>", "(Ljava/lang/String;Ljq2/c;Lcom/tencent/mobileqq/setting/utils/j;)V", "qq_setting_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class SearchTask implements Runnable {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final String content;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final jq2.c node;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final j callback;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private boolean canceled;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes35.dex */
        public static final class a<T> implements Comparator {
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t16, T t17) {
                int compareValues;
                compareValues = ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(((SearchResult) t16).b().size()), Integer.valueOf(((SearchResult) t17).b().size()));
                return compareValues;
            }
        }

        public SearchTask(String content, jq2.c node, j callback) {
            Intrinsics.checkNotNullParameter(content, "content");
            Intrinsics.checkNotNullParameter(node, "node");
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.content = content;
            this.node = node;
            this.callback = callback;
        }

        private final ArrayList<SearchResult> a(String content, jq2.c node) {
            ArrayList<SearchResult> arrayList = new ArrayList<>();
            b(content, node, "", new ArrayList<>(), arrayList);
            return arrayList;
        }

        private final void b(String content, jq2.c node, String path, ArrayList<jq2.c> indexNodePath, ArrayList<SearchResult> result) {
            boolean contains;
            String str;
            if (this.canceled) {
                return;
            }
            contains = StringsKt__StringsKt.contains((CharSequence) node.getTitle(), (CharSequence) content, false);
            if (contains) {
                result.add(new SearchResult(node, path, content, indexNodePath));
                QLog.d("SettingNodeSearchUtil", 2, "searchNodesRecursive path: " + path);
            } else {
                int[] d16 = com.tencent.mobileqq.search.util.a.d(node.getTitle(), content, 2);
                int i3 = d16[0];
                if (i3 >= 0) {
                    int i16 = d16[1] + i3;
                    CharSequence subSequence = node.getTitle().subSequence(i3, i16);
                    QLog.d("SettingNodeSearchUtil", 2, "searchNodesRecursive da sou result: " + ((Object) node.getTitle().subSequence(i3, i16)));
                    result.add(new SearchResult(node, path, subSequence.toString(), indexNodePath));
                } else {
                    int[] d17 = com.tencent.mobileqq.search.util.a.d(node.getTitle(), content, 1);
                    int i17 = d17[0];
                    if (i17 >= 0) {
                        int i18 = d17[1] + i17;
                        QLog.d("SettingNodeSearchUtil", 2, "searchNodesRecursive da sou result: " + ((Object) node.getTitle().subSequence(i17, i18)));
                        result.add(new SearchResult(node, path, node.getTitle().subSequence(i17, i18).toString(), indexNodePath));
                    }
                }
            }
            if (path.length() == 0) {
                str = node.getTitle();
            } else {
                str = path + " -> " + node.getTitle();
            }
            String str2 = str;
            ArrayList<jq2.c> arrayList = new ArrayList<>(indexNodePath);
            arrayList.add(node);
            if (!node.d().isEmpty()) {
                Iterator<jq2.c> it = node.d().iterator();
                while (it.hasNext()) {
                    jq2.c subNode = it.next();
                    Intrinsics.checkNotNullExpressionValue(subNode, "subNode");
                    b(content, subNode, str2, arrayList, result);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            ArrayList<SearchResult> a16 = a(this.content, this.node);
            if (a16.size() > 1) {
                CollectionsKt__MutableCollectionsJVMKt.sortWith(a16, new a());
            }
            if (this.canceled) {
                return;
            }
            this.callback.onSuccess(a16);
        }

        public final void cancel() {
            this.canceled = true;
        }
    }

    SettingNodeSearchUtil() {
    }

    public final void a(String content, jq2.c node, j callback) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(callback, "callback");
        SearchTask searchTask2 = searchTask;
        if (searchTask2 != null) {
            searchHandler.removeCallbacks(searchTask2);
            searchTask2.cancel();
        }
        SearchTask searchTask3 = new SearchTask(content, node, callback);
        searchTask = searchTask3;
        searchHandler.post(searchTask3);
    }
}
