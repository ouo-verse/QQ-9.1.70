package com.tencent.guild.api.media.album;

import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bI\u0010JJ\u001c\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J#\u0010\n\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJR\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r0\u000ej\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r`\u000f*\b\u0012\u0004\u0012\u00020\r0\f2\"\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r0\u000ej\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r`\u000fH\u0002J\u000e\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012J\u0014\u0010\u0016\u001a\u00020\u00052\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\u0017J\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\fJ\u0014\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u001bH\u0007J\u000e\u0010\u001f\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001dJ\u000e\u0010\"\u001a\u00020!2\u0006\u0010 \u001a\u00020\rJ\u000e\u0010$\u001a\u00020\r2\u0006\u0010#\u001a\u00020\u001dJ\u0006\u0010%\u001a\u00020\u001dJ\u0016\u0010(\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020\u001dJ\u000e\u0010)\u001a\u00020!2\u0006\u0010 \u001a\u00020\rJ\u0006\u0010*\u001a\u00020\u0005J\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00010\fJ\u0014\u0010-\u001a\u00020\u00052\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u0014\u0010/\u001a\u00020\u00052\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u0006\u00100\u001a\u00020\u0005R\"\u00107\u001a\u00020!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106RT\u0010=\u001aB\u0012\u0004\u0012\u00020\u001d\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0017\u0012\u0004\u0012\u00020\u00050908j \u0012\u0004\u0012\u00020\u001d\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0017\u0012\u0004\u0012\u00020\u000509`:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010<R0\u0010@\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r0\u000ej\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r`\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010?R3\u0010C\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000308j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`:8\u0006\u00a2\u0006\f\n\u0004\b)\u0010<\u001a\u0004\bA\u0010BR\u001a\u0010E\u001a\b\u0012\u0004\u0012\u00020\r0\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010DR\u0017\u0010H\u001a\b\u0012\u0004\u0012\u00020\r0\u00178F\u00a2\u0006\u0006\u001a\u0004\bF\u0010G\u00a8\u0006K"}, d2 = {"Lcom/tencent/guild/api/media/album/GuildAIOMediasRepository;", "", "", "", "map", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, BdhLogUtil.LogTag.Tag_Req, "Lkotlin/Function0;", "func", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "", "Lcom/tencent/guild/api/media/album/e;", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "destination", "w", "Lcom/tencent/guild/api/media/album/a;", "result", HippyTKDListViewAdapter.X, "select", "r", "", "k", "Lcom/tencent/guild/api/media/album/d;", h.F, "Lkotlinx/coroutines/flow/Flow;", "f", "", "position", "l", "localMediaInfo", "", "t", com.tencent.luggage.wxa.c8.c.G, ReportConstant.COSTREPORT_PREFIX, "u", "start", "target", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "d", "e", "o", "tag", "y", "selected", "p", DomainData.DOMAIN_NAME, "a", "Z", "j", "()Z", "v", "(Z)V", "mQuality", "Ljava/util/HashMap;", "Lkotlin/Function1;", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "listeners", "c", "Ljava/util/LinkedHashMap;", "localMediaInfoMap", "g", "()Ljava/util/HashMap;", "editMap", "Ljava/util/List;", "selectedMediaInfos", "i", "()Ljava/util/List;", AEEditorConstants.KEY_WINK_LOCAL_MEDIA_INFOS, "<init>", "()V", "nt-guild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildAIOMediasRepository {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean mQuality;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<Integer, Function1<List<e>, Unit>> listeners = new HashMap<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LinkedHashMap<String, e> localMediaInfoMap = new LinkedHashMap<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<String, String> editMap = new HashMap<>();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<e> selectedMediaInfos = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(Map<String, String> map) {
        Map mutableMap;
        Object value;
        mutableMap = MapsKt__MapsKt.toMutableMap(this.editMap);
        for (Map.Entry entry : mutableMap.entrySet()) {
            if (map.containsKey(entry.getValue())) {
                AbstractMap abstractMap = this.editMap;
                Object key = entry.getKey();
                value = MapsKt__MapsKt.getValue(map, entry.getValue());
                abstractMap.put(key, value);
                map.remove(entry.getValue());
            }
        }
        this.editMap.putAll(map);
        for (Map.Entry<String, String> entry2 : this.editMap.entrySet()) {
            e eVar = this.localMediaInfoMap.get(entry2.getKey());
            if (eVar != null) {
                eVar.a(entry2.getKey());
                eVar.setPath(entry2.getValue());
            }
        }
    }

    private final LinkedHashMap<String, e> w(List<? extends e> list, LinkedHashMap<String, e> linkedHashMap) {
        linkedHashMap.clear();
        for (e eVar : list) {
            linkedHashMap.put(eVar.getPath(), eVar);
        }
        return linkedHashMap;
    }

    private final <R> R z(Function0<? extends R> func) {
        R invoke = func.invoke();
        n();
        return invoke;
    }

    public final boolean d(@NotNull final e localMediaInfo) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "localMediaInfo");
        return ((Boolean) z(new Function0<Boolean>() { // from class: com.tencent.guild.api.media.album.GuildAIOMediasRepository$addSelectedMedia$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                List list;
                list = GuildAIOMediasRepository.this.selectedMediaInfos;
                return Boolean.valueOf(list.add(localMediaInfo));
            }
        })).booleanValue();
    }

    public final void e() {
        z(new Function0<Unit>() { // from class: com.tencent.guild.api.media.album.GuildAIOMediasRepository$clearSelectedMedia$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                List list;
                list = GuildAIOMediasRepository.this.selectedMediaInfos;
                list.clear();
            }
        });
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public final Flow<List<e>> f() {
        return FlowKt.callbackFlow(new GuildAIOMediasRepository$getDataChangeFlow$1(this, null));
    }

    @NotNull
    public final HashMap<String, String> g() {
        return this.editMap;
    }

    @NotNull
    public final List<GuildPickPhotoResult> h() {
        int collectionSizeOrDefault;
        List<e> k3 = k();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(k3, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = k3.iterator();
        while (it.hasNext()) {
            arrayList.add(b.b((e) it.next(), this.mQuality, null, 2, null));
        }
        return arrayList;
    }

    @NotNull
    public final List<e> i() {
        List<e> mutableList;
        Collection<e> values = this.localMediaInfoMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "localMediaInfoMap.values");
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) values);
        return mutableList;
    }

    /* renamed from: j, reason: from getter */
    public final boolean getMQuality() {
        return this.mQuality;
    }

    @NotNull
    public final List<e> k() {
        List<e> mutableList;
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) this.selectedMediaInfos);
        return mutableList;
    }

    @NotNull
    public final e l(int position) {
        return this.selectedMediaInfos.get(position);
    }

    public final void m(int start, int target) {
        if (start != target) {
            this.selectedMediaInfos.add(target, this.selectedMediaInfos.remove(start));
        }
    }

    public final void n() {
        List<e> k3 = k();
        Collection<Function1<List<e>, Unit>> values = this.listeners.values();
        Intrinsics.checkNotNullExpressionValue(values, "listeners.values");
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            ((Function1) it.next()).invoke(k3);
        }
    }

    @NotNull
    public final List<Object> o() {
        int collectionSizeOrDefault;
        List<e> list = this.selectedMediaInfos;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((e) it.next()).d());
        }
        return arrayList;
    }

    public final void p(@NotNull final List<? extends e> selected) {
        Intrinsics.checkNotNullParameter(selected, "selected");
        z(new Function0<Unit>() { // from class: com.tencent.guild.api.media.album.GuildAIOMediasRepository$recoverDraft$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                List list;
                List<e> list2;
                list = GuildAIOMediasRepository.this.selectedMediaInfos;
                list.addAll(selected);
                GuildAIOMediasRepository.this.g().clear();
                list2 = GuildAIOMediasRepository.this.selectedMediaInfos;
                GuildAIOMediasRepository guildAIOMediasRepository = GuildAIOMediasRepository.this;
                for (e eVar : list2) {
                    if (eVar.c().length() > 0) {
                        guildAIOMediasRepository.g().put(eVar.c(), eVar.getPath());
                    }
                }
            }
        });
    }

    public final void r(@NotNull List<? extends e> select) {
        int collectionSizeOrDefault;
        int mapCapacity;
        int coerceAtLeast;
        int collectionSizeOrDefault2;
        Intrinsics.checkNotNullParameter(select, "select");
        this.selectedMediaInfos.clear();
        List<e> i3 = i();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(i3, 10);
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (Object obj : i3) {
            linkedHashMap.put(((e) obj).getPath(), obj);
        }
        List<e> list = this.selectedMediaInfos;
        List<? extends e> list2 = select;
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault2);
        for (e eVar : list2) {
            e eVar2 = (e) linkedHashMap.get(eVar.getPath());
            if (eVar2 != null) {
                eVar = eVar2;
            }
            arrayList.add(eVar);
        }
        list.addAll(arrayList);
    }

    @NotNull
    public final e s(int pos) {
        return this.selectedMediaInfos.remove(pos);
    }

    public final boolean t(@NotNull final e localMediaInfo) {
        Intrinsics.checkNotNullParameter(localMediaInfo, "localMediaInfo");
        return ((Boolean) z(new Function0<Boolean>() { // from class: com.tencent.guild.api.media.album.GuildAIOMediasRepository$removeSelectedMedia$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                List list;
                list = GuildAIOMediasRepository.this.selectedMediaInfos;
                return Boolean.valueOf(list.remove(localMediaInfo));
            }
        })).booleanValue();
    }

    public final int u() {
        return this.selectedMediaInfos.size();
    }

    public final void v(boolean z16) {
        this.mQuality = z16;
    }

    public final void x(@NotNull final AlbumResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        z(new Function0<Unit>() { // from class: com.tencent.guild.api.media.album.GuildAIOMediasRepository$updateFromAlbumResult$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                if (AlbumResult.this.d()) {
                    this.v(AlbumResult.this.getQuality());
                    if (AlbumResult.this.a() != null) {
                        this.q(AlbumResult.this.a());
                    }
                    this.r(AlbumResult.this.c());
                }
            }
        });
    }

    public final void y(@NotNull List<? extends e> tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        w(tag, this.localMediaInfoMap);
        q(this.editMap);
    }
}
