package com.tencent.mobileqq.wink.editor.music.vo;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.editor.music.ax;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0019B\u0007\u00a2\u0006\u0004\b2\u00103J\u0016\u0010\u0005\u001a\u0010\u0012\f\u0012\n \u0004*\u0004\u0018\u00010\u00030\u00030\u0002H\u0002J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u0002J\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0002J\u0014\u0010\u000e\u001a\u00020\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u0002J\u0018\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\u0010J\u001a\u0010\u0016\u001a\u00020\r2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00140\u0013J\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u0002J\u0014\u0010\u0018\u001a\u00020\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u0002J\u0018\u0010\u0019\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\u0010J\u001a\u0010\u001a\u001a\u00020\r2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00140\u0013J\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\u0002J\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u0002J\u0014\u0010\u001d\u001a\u00020\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u0002J\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u0002J\u0014\u0010\u001f\u001a\u00020\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u0002J\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\b0\u00022\u0006\u0010 \u001a\u00020\u0003J\u001c\u0010#\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u00032\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\b0\u0002J \u0010$\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\u0010J\"\u0010%\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u00032\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00140\u0013J0\u0010'\u001a\u00020\r2\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00140\u00132\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r0\u0013J\u001c\u0010(\u001a\u00020\u00142\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00140\u0013J\u000e\u0010+\u001a\u00020\r2\u0006\u0010*\u001a\u00020)R<\u0010/\u001a*\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00020,j\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0002`-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010.R\u0018\u00101\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u00100\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/music/vo/MusicListData;", "", "", "Lcom/tencent/mobileqq/wink/editor/music/ax;", "kotlin.jvm.PlatformType", "o", "", "categoryId", "Lcom/tencent/mobileqq/wink/editor/music/vo/WinkEditorMusicInfo;", DomainData.DOMAIN_NAME, "l", "p", "list", "", "y", "music", "", "index", "c", "Lkotlin/Function1;", "", "predicate", ReportConstant.COSTREPORT_PREFIX, h.F, "t", "a", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "k", "j", "v", "i", "u", "categoryInfo", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "musicList", "w", "b", "r", "action", "e", "g", "Lcom/tencent/mobileqq/wink/editor/music/vo/MusicListData$a;", "listener", HippyTKDListViewAdapter.X, "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "dataMap", "Lcom/tencent/mobileqq/wink/editor/music/vo/MusicListData$a;", "dataChangedListener", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class MusicListData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<String, List<WinkEditorMusicInfo>> dataMap = new HashMap<>();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a dataChangedListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/music/vo/MusicListData$a;", "", "", "Lcom/tencent/mobileqq/wink/editor/music/vo/WinkEditorMusicInfo;", "list", "", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public interface a {
        void a(@NotNull List<? extends WinkEditorMusicInfo> list);
    }

    public static /* synthetic */ void d(MusicListData musicListData, WinkEditorMusicInfo winkEditorMusicInfo, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = -1;
        }
        musicListData.c(winkEditorMusicInfo, i3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void f(MusicListData musicListData, Function1 function1, Function1 function12, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            function1 = new Function1<WinkEditorMusicInfo, Boolean>() { // from class: com.tencent.mobileqq.wink.editor.music.vo.MusicListData$editMusicList$1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull WinkEditorMusicInfo it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.TRUE;
                }
            };
        }
        musicListData.e(function1, function12);
    }

    private final List<WinkEditorMusicInfo> n(String categoryId) {
        List<WinkEditorMusicInfo> emptyList;
        List<WinkEditorMusicInfo> list = this.dataMap.get(categoryId);
        if (list == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return list;
    }

    private final List<ax> o() {
        List<ax> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new ax[]{ax.f320779f, ax.f320778e});
        return listOf;
    }

    public final void a(@NotNull WinkEditorMusicInfo music, int index) {
        Intrinsics.checkNotNullParameter(music, "music");
        ax COLLECTION_CATEGORY_INFO = ax.f320779f;
        Intrinsics.checkNotNullExpressionValue(COLLECTION_CATEGORY_INFO, "COLLECTION_CATEGORY_INFO");
        b(COLLECTION_CATEGORY_INFO, music, index);
    }

    public final void b(@NotNull ax categoryInfo, @NotNull WinkEditorMusicInfo music, int index) {
        List<? extends WinkEditorMusicInfo> mutableList;
        Intrinsics.checkNotNullParameter(categoryInfo, "categoryInfo");
        Intrinsics.checkNotNullParameter(music, "music");
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) m(categoryInfo));
        if (index == -1) {
            mutableList.add(music);
        } else {
            mutableList.add(index, music);
        }
        w(categoryInfo, mutableList);
    }

    public final void c(@NotNull WinkEditorMusicInfo music, int index) {
        Intrinsics.checkNotNullParameter(music, "music");
        ax RECOMM_CATEGORY_INFO = ax.f320778e;
        Intrinsics.checkNotNullExpressionValue(RECOMM_CATEGORY_INFO, "RECOMM_CATEGORY_INFO");
        b(RECOMM_CATEGORY_INFO, music, index);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e(@NotNull Function1<? super WinkEditorMusicInfo, Boolean> predicate, @NotNull Function1<? super WinkEditorMusicInfo, Unit> action) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Intrinsics.checkNotNullParameter(action, "action");
        List<WinkEditorMusicInfo> l3 = l();
        ArrayList arrayList = new ArrayList();
        for (Object obj : l3) {
            if (predicate.invoke(obj).booleanValue()) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            action.invoke(it.next());
        }
        a aVar = this.dataChangedListener;
        if (aVar != null) {
            aVar.a(l());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean g(@NotNull Function1<? super WinkEditorMusicInfo, Boolean> predicate) {
        boolean z16;
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        List<WinkEditorMusicInfo> l3 = l();
        if (!(l3 instanceof Collection) || !l3.isEmpty()) {
            Iterator<T> it = l3.iterator();
            while (it.hasNext()) {
                if (predicate.invoke(it.next()).booleanValue()) {
                    z16 = false;
                    break;
                }
            }
        }
        z16 = true;
        return !z16;
    }

    @NotNull
    public final List<WinkEditorMusicInfo> h() {
        ax COLLECTION_CATEGORY_INFO = ax.f320779f;
        Intrinsics.checkNotNullExpressionValue(COLLECTION_CATEGORY_INFO, "COLLECTION_CATEGORY_INFO");
        return m(COLLECTION_CATEGORY_INFO);
    }

    @NotNull
    public final List<WinkEditorMusicInfo> i() {
        ax DAILY_SIGN_CATEGORY_INFO = ax.f320782i;
        Intrinsics.checkNotNullExpressionValue(DAILY_SIGN_CATEGORY_INFO, "DAILY_SIGN_CATEGORY_INFO");
        return m(DAILY_SIGN_CATEGORY_INFO);
    }

    @NotNull
    public final List<WinkEditorMusicInfo> j() {
        ax MAGIC_STUDIO_CATEGORY_INFO = ax.f320781h;
        Intrinsics.checkNotNullExpressionValue(MAGIC_STUDIO_CATEGORY_INFO, "MAGIC_STUDIO_CATEGORY_INFO");
        return m(MAGIC_STUDIO_CATEGORY_INFO);
    }

    @NotNull
    public final List<WinkEditorMusicInfo> k() {
        ax MOOD_CATEGORY_INFO = ax.f320780g;
        Intrinsics.checkNotNullExpressionValue(MOOD_CATEGORY_INFO, "MOOD_CATEGORY_INFO");
        return m(MOOD_CATEGORY_INFO);
    }

    @NotNull
    public final List<WinkEditorMusicInfo> l() {
        Object obj;
        ArrayList arrayList = new ArrayList();
        for (ax it : o()) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            arrayList.addAll(m(it));
        }
        for (Map.Entry<String, List<WinkEditorMusicInfo>> entry : this.dataMap.entrySet()) {
            Iterator<T> it5 = o().iterator();
            while (true) {
                if (it5.hasNext()) {
                    obj = it5.next();
                    if (Intrinsics.areEqual(((ax) obj).f320783a, entry.getKey())) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            if (((ax) obj) == null) {
                arrayList.addAll(n(entry.getKey()));
            }
        }
        return arrayList;
    }

    @NotNull
    public final List<WinkEditorMusicInfo> m(@NotNull ax categoryInfo) {
        Intrinsics.checkNotNullParameter(categoryInfo, "categoryInfo");
        String str = categoryInfo.f320783a;
        Intrinsics.checkNotNullExpressionValue(str, "categoryInfo.mCategoryId");
        return n(str);
    }

    @NotNull
    public final List<WinkEditorMusicInfo> p() {
        ax RECOMM_CATEGORY_INFO = ax.f320778e;
        Intrinsics.checkNotNullExpressionValue(RECOMM_CATEGORY_INFO, "RECOMM_CATEGORY_INFO");
        return m(RECOMM_CATEGORY_INFO);
    }

    public final void q(@NotNull Function1<? super WinkEditorMusicInfo, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ax COLLECTION_CATEGORY_INFO = ax.f320779f;
        Intrinsics.checkNotNullExpressionValue(COLLECTION_CATEGORY_INFO, "COLLECTION_CATEGORY_INFO");
        r(COLLECTION_CATEGORY_INFO, predicate);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void r(@NotNull ax categoryInfo, @NotNull Function1<? super WinkEditorMusicInfo, Boolean> predicate) {
        List<? extends WinkEditorMusicInfo> mutableList;
        Intrinsics.checkNotNullParameter(categoryInfo, "categoryInfo");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) m(categoryInfo));
        ArrayList arrayList = new ArrayList();
        for (Object obj : mutableList) {
            if (predicate.invoke(obj).booleanValue()) {
                arrayList.add(obj);
            }
        }
        if (!arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                mutableList.remove((WinkEditorMusicInfo) it.next());
            }
            w(categoryInfo, mutableList);
        }
    }

    public final void s(@NotNull Function1<? super WinkEditorMusicInfo, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        ax RECOMM_CATEGORY_INFO = ax.f320778e;
        Intrinsics.checkNotNullExpressionValue(RECOMM_CATEGORY_INFO, "RECOMM_CATEGORY_INFO");
        r(RECOMM_CATEGORY_INFO, predicate);
    }

    public final void t(@NotNull List<? extends WinkEditorMusicInfo> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        ax COLLECTION_CATEGORY_INFO = ax.f320779f;
        Intrinsics.checkNotNullExpressionValue(COLLECTION_CATEGORY_INFO, "COLLECTION_CATEGORY_INFO");
        w(COLLECTION_CATEGORY_INFO, list);
    }

    public final void u(@NotNull List<? extends WinkEditorMusicInfo> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        ax DAILY_SIGN_CATEGORY_INFO = ax.f320782i;
        Intrinsics.checkNotNullExpressionValue(DAILY_SIGN_CATEGORY_INFO, "DAILY_SIGN_CATEGORY_INFO");
        w(DAILY_SIGN_CATEGORY_INFO, list);
    }

    public final void v(@NotNull List<? extends WinkEditorMusicInfo> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        ax MOOD_CATEGORY_INFO = ax.f320780g;
        Intrinsics.checkNotNullExpressionValue(MOOD_CATEGORY_INFO, "MOOD_CATEGORY_INFO");
        w(MOOD_CATEGORY_INFO, list);
    }

    public final void w(@NotNull ax categoryInfo, @NotNull List<? extends WinkEditorMusicInfo> musicList) {
        Intrinsics.checkNotNullParameter(categoryInfo, "categoryInfo");
        Intrinsics.checkNotNullParameter(musicList, "musicList");
        HashMap<String, List<WinkEditorMusicInfo>> hashMap = this.dataMap;
        String str = categoryInfo.f320783a;
        Intrinsics.checkNotNullExpressionValue(str, "categoryInfo.mCategoryId");
        hashMap.put(str, musicList);
        a aVar = this.dataChangedListener;
        if (aVar != null) {
            aVar.a(l());
        }
    }

    public final void x(@NotNull a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.dataChangedListener = listener;
    }

    public final void y(@NotNull List<? extends WinkEditorMusicInfo> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        ax RECOMM_CATEGORY_INFO = ax.f320778e;
        Intrinsics.checkNotNullExpressionValue(RECOMM_CATEGORY_INFO, "RECOMM_CATEGORY_INFO");
        w(RECOMM_CATEGORY_INFO, list);
    }
}
