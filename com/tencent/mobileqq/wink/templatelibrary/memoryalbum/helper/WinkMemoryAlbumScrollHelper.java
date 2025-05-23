package com.tencent.mobileqq.wink.templatelibrary.memoryalbum.helper;

import android.content.Intent;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.newalbum.collector.WinkNewMemoryAlbumResult;
import com.tencent.mobileqq.wink.newalbum.database.WinkNewAlbumDatabaseImp;
import com.tencent.mobileqq.wink.templatelibrary.memoryalbum.data.WinkAlbumItemType;
import com.tencent.mobileqq.wink.templatelibrary.memoryalbum.data.WinkAlbumItemWrapper;
import com.tencent.mobileqq.wink.utils.e;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import w83.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 )2\u00020\u0001:\u0001\u000fB\u0019\u0012\u0006\u0010\r\u001a\u00020\n\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b'\u0010(J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001bR \u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001f0\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/wink/templatelibrary/memoryalbum/helper/WinkMemoryAlbumScrollHelper;", "", "", "position", "", "f", "e", "", "isLoadFinished", "g", "Landroidx/recyclerview/widget/RecyclerView;", "a", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Landroid/content/Intent;", "b", "Landroid/content/Intent;", "intent", "Lkotlinx/coroutines/CoroutineScope;", "c", "Lkotlinx/coroutines/CoroutineScope;", "mainScope", "", "d", "Ljava/lang/String;", "albumId", AEEditorConstants.ALBUMNAME, "Z", "isUserDragged", "hasScrolled", "", "", h.F, "Ljava/util/Map;", "visibleItems", "Lcom/tencent/mobileqq/wink/newalbum/database/WinkNewAlbumDatabaseImp;", "i", "Lcom/tencent/mobileqq/wink/newalbum/database/WinkNewAlbumDatabaseImp;", "winkNewAlbumDatabaseImp", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;Landroid/content/Intent;)V", "j", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkMemoryAlbumScrollHelper {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RecyclerView recyclerView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Intent intent;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final CoroutineScope mainScope;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String albumId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String albumName;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isUserDragged;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean hasScrolled;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<Integer, Long> visibleItems;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private WinkNewAlbumDatabaseImp winkNewAlbumDatabaseImp;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/wink/templatelibrary/memoryalbum/helper/WinkMemoryAlbumScrollHelper$a", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "dx", "dy", "onScrolled", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
            WinkMemoryAlbumScrollHelper winkMemoryAlbumScrollHelper = WinkMemoryAlbumScrollHelper.this;
            boolean z16 = true;
            if (!winkMemoryAlbumScrollHelper.isUserDragged && newState != 1) {
                z16 = false;
            }
            winkMemoryAlbumScrollHelper.isUserDragged = z16;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NotNull RecyclerView recyclerView, int dx5, int dy5) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, dx5, dy5);
            WinkMemoryAlbumScrollHelper.this.e();
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f326569a;

        static {
            int[] iArr = new int[WinkAlbumItemType.values().length];
            try {
                iArr[WinkAlbumItemType.UI_TYPE_MEMORY_ALBUM_PREVIEW_ITEM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[WinkAlbumItemType.UI_TYPE_NEW_ALBUM_PREVIEW_ITEM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f326569a = iArr;
        }
    }

    public WinkMemoryAlbumScrollHelper(@NotNull RecyclerView recyclerView, @Nullable Intent intent) {
        Object obj;
        Bundle extras;
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        this.recyclerView = recyclerView;
        this.intent = intent;
        this.mainScope = CoroutineScopeKt.MainScope();
        this.visibleItems = new LinkedHashMap();
        this.winkNewAlbumDatabaseImp = new WinkNewAlbumDatabaseImp();
        if (intent != null && (extras = intent.getExtras()) != null) {
            obj = extras.get("key_attrs");
        } else {
            obj = null;
        }
        HashMap hashMap = obj instanceof HashMap ? (HashMap) obj : null;
        if (hashMap != null) {
            this.albumId = (String) hashMap.get(QCircleScheme.AttrQQPublish.MEMORY_ALBUM_ID);
            this.albumName = (String) hashMap.get(QCircleScheme.AttrQQPublish.MEMORY_ALBUM_TITLE);
        }
        QLog.d("WinkMemoryAlbumScrollHelper", 1, "init, albumId:" + this.albumId + ", albumName:" + this.albumName);
        recyclerView.addOnScrollListener(new a());
    }

    private final void f(int position) {
        ia3.a aVar;
        List<WinkAlbumItemWrapper> emptyList;
        RecyclerView.Adapter adapter = this.recyclerView.getAdapter();
        String str = null;
        if (adapter instanceof ia3.a) {
            aVar = (ia3.a) adapter;
        } else {
            aVar = null;
        }
        if (aVar == null || (emptyList = aVar.getItems()) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        if (position >= 0 && position < emptyList.size()) {
            WinkAlbumItemWrapper winkAlbumItemWrapper = emptyList.get(position);
            if (winkAlbumItemWrapper.getWinkNewAlbum() != null) {
                WinkNewAlbumDatabaseImp.k(winkAlbumItemWrapper.getWinkNewAlbum());
                WinkNewAlbumDatabaseImp winkNewAlbumDatabaseImp = this.winkNewAlbumDatabaseImp;
                WinkNewMemoryAlbumResult winkNewAlbum = winkAlbumItemWrapper.getWinkNewAlbum();
                Intrinsics.checkNotNull(winkNewAlbum);
                String albumID = winkNewAlbum.getAlbumID();
                WinkNewMemoryAlbumResult winkNewAlbum2 = winkAlbumItemWrapper.getWinkNewAlbum();
                Intrinsics.checkNotNull(winkNewAlbum2);
                winkNewAlbumDatabaseImp.U(albumID, winkNewAlbum2.getExposeTimes() + 1);
                WinkNewMemoryAlbumResult winkNewAlbum3 = winkAlbumItemWrapper.getWinkNewAlbum();
                if (winkNewAlbum3 != null) {
                    str = winkNewAlbum3.getCom.tencent.aelight.camera.constants.AEEditorConstants.ALBUMNAME java.lang.String();
                }
                QLog.d("WinkMemoryAlbumScrollHelper", 1, "display index: " + position + " item: " + str + " is displayed!");
                return;
            }
            return;
        }
        QLog.d("WinkMemoryAlbumScrollHelper", 1, "Invalid position: " + position);
    }

    public final void e() {
        Set set;
        if (!(this.recyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
            if (QLog.isColorLevel()) {
                QLog.d("WinkMemoryAlbumScrollHelper", 1, "LayoutManager is not LinearLayoutManager");
                return;
            }
            return;
        }
        RecyclerView.LayoutManager layoutManager = this.recyclerView.getLayoutManager();
        Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
        if (findFirstVisibleItemPosition != -1 && findLastVisibleItemPosition != -1) {
            long currentTimeMillis = System.currentTimeMillis();
            if (findFirstVisibleItemPosition <= findLastVisibleItemPosition) {
                int i3 = findFirstVisibleItemPosition;
                while (true) {
                    if (!this.visibleItems.containsKey(Integer.valueOf(i3))) {
                        this.visibleItems.put(Integer.valueOf(i3), Long.valueOf(currentTimeMillis));
                    } else {
                        Long l3 = this.visibleItems.get(Integer.valueOf(i3));
                        Intrinsics.checkNotNull(l3);
                        if (currentTimeMillis - l3.longValue() >= b.f445025a.d()) {
                            f(i3);
                            this.visibleItems.remove(Integer.valueOf(i3));
                        }
                    }
                    if (i3 == findLastVisibleItemPosition) {
                        break;
                    } else {
                        i3++;
                    }
                }
            }
            set = CollectionsKt___CollectionsKt.toSet(new IntRange(findFirstVisibleItemPosition, findLastVisibleItemPosition));
            this.visibleItems.keySet().retainAll(set);
            return;
        }
        QLog.d("WinkMemoryAlbumScrollHelper", 1, "No visible items found");
    }

    public final void g(boolean isLoadFinished) {
        boolean z16;
        boolean z17;
        ia3.a aVar;
        List<WinkAlbumItemWrapper> emptyList;
        int i3;
        s53.a winkMemoryAlbum;
        boolean z18;
        WinkNewMemoryAlbumResult winkNewAlbum;
        String str;
        boolean areEqual;
        String str2;
        QLog.d("WinkMemoryAlbumScrollHelper", 1, "startScroll, userDragged:" + this.isUserDragged + ", hasScrolled:" + this.hasScrolled + ", isLoadFinished:" + isLoadFinished);
        if (!this.isUserDragged && !this.hasScrolled) {
            String str3 = this.albumId;
            if (str3 != null && str3.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                String str4 = this.albumName;
                if (str4 != null && str4.length() != 0) {
                    z17 = false;
                } else {
                    z17 = true;
                }
                if (!z17) {
                    RecyclerView.Adapter adapter = this.recyclerView.getAdapter();
                    if (adapter instanceof ia3.a) {
                        aVar = (ia3.a) adapter;
                    } else {
                        aVar = null;
                    }
                    if (aVar == null || (emptyList = aVar.getItems()) == null) {
                        emptyList = CollectionsKt__CollectionsKt.emptyList();
                    }
                    Iterator<WinkAlbumItemWrapper> it = emptyList.iterator();
                    int i16 = 0;
                    while (true) {
                        i3 = -1;
                        if (it.hasNext()) {
                            WinkAlbumItemWrapper next = it.next();
                            int i17 = c.f326569a[next.getType().ordinal()];
                            if (i17 != 1) {
                                if (i17 != 2) {
                                    areEqual = false;
                                } else {
                                    WinkNewMemoryAlbumResult winkNewAlbum2 = next.getWinkNewAlbum();
                                    if (winkNewAlbum2 != null) {
                                        str2 = winkNewAlbum2.getAlbumID();
                                    } else {
                                        str2 = null;
                                    }
                                    areEqual = Intrinsics.areEqual(str2, this.albumId);
                                }
                            } else {
                                s53.a winkMemoryAlbum2 = next.getWinkMemoryAlbum();
                                if (winkMemoryAlbum2 != null) {
                                    str = winkMemoryAlbum2.getId();
                                } else {
                                    str = null;
                                }
                                areEqual = Intrinsics.areEqual(str, this.albumId);
                            }
                            if (areEqual) {
                                break;
                            } else {
                                i16++;
                            }
                        } else {
                            i16 = -1;
                            break;
                        }
                    }
                    QLog.d("WinkMemoryAlbumScrollHelper", 1, "startScroll, step 1 find index:" + i16);
                    if (i16 >= 0) {
                        RecyclerView.Adapter adapter2 = this.recyclerView.getAdapter();
                        if (adapter2 != null) {
                            adapter2.notifyItemChanged(i16);
                        }
                        e.j(this.recyclerView, 0, i16, false, false);
                        this.hasScrolled = true;
                        return;
                    }
                    Iterator<WinkAlbumItemWrapper> it5 = emptyList.iterator();
                    int i18 = 0;
                    while (true) {
                        if (!it5.hasNext()) {
                            break;
                        }
                        WinkAlbumItemWrapper next2 = it5.next();
                        int i19 = c.f326569a[next2.getType().ordinal()];
                        if (i19 == 1 ? (winkMemoryAlbum = next2.getWinkMemoryAlbum()) == null || winkMemoryAlbum.getExposed() : i19 != 2 || (winkNewAlbum = next2.getWinkNewAlbum()) == null || winkNewAlbum.getIsExposed()) {
                            z18 = false;
                        } else {
                            z18 = true;
                        }
                        if (z18) {
                            i3 = i18;
                            break;
                        }
                        i18++;
                    }
                    QLog.d("WinkMemoryAlbumScrollHelper", 1, "startScroll, step 2 find index:" + i3);
                    if (i3 >= 0) {
                        e.j(this.recyclerView, 0, i3, false, false);
                        this.hasScrolled = true;
                    } else if (this.isUserDragged || isLoadFinished) {
                        BuildersKt__Builders_commonKt.launch$default(this.mainScope, null, null, new WinkMemoryAlbumScrollHelper$startScroll$2(this, null), 3, null);
                    }
                }
            }
        }
    }
}
