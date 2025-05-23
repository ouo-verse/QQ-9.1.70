package com.tencent.mobileqq.wink.newalbum.collector;

import android.database.Cursor;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ads.data.AdParam;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.startup.step.InitSkin;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmdownloader.internal.storage.table.CacheTable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0019\u0018\u0000 \u00122\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\bQ\u0010RJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u0096\u0002R\"\u0010\u0010\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0014\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\"\u0010\u0018\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR(\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR(\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00050\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u001a\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR(\u0010'\u001a\b\u0012\u0004\u0012\u00020#0\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010\u001a\u001a\u0004\b%\u0010\u001c\"\u0004\b&\u0010\u001eR(\u0010,\u001a\b\u0012\u0004\u0012\u00020(0\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010\u001a\u001a\u0004\b*\u0010\u001c\"\u0004\b+\u0010\u001eR\"\u00103\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u00109\u001a\u0002048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010!\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010@\u001a\u00020:8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R(\u0010C\u001a\b\u0012\u0004\u0012\u00020#0\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010\u001a\u001a\u0004\b)\u0010\u001c\"\u0004\bB\u0010\u001eR(\u0010E\u001a\b\u0012\u0004\u0012\u00020(0\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u001a\u001a\u0004\b-\u0010\u001c\"\u0004\bD\u0010\u001eR\"\u0010G\u001a\u0002048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u0010!\u001a\u0004\bA\u00106\"\u0004\bF\u00108R$\u0010I\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u000b\u001a\u0004\b\u0015\u0010\r\"\u0004\bH\u0010\u000fR(\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00050\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b<\u0010\u001a\u001a\u0004\b$\u0010\u001c\"\u0004\bJ\u0010\u001eR\"\u0010N\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010.\u001a\u0004\bL\u00100\"\u0004\bM\u00102R\u0013\u0010P\u001a\u0004\u0018\u00010(8F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010O\u00a8\u0006S"}, d2 = {"Lcom/tencent/mobileqq/wink/newalbum/collector/WinkNewMemoryAlbumResult;", "", "", "p", "l", "", DomainData.DOMAIN_NAME, "other", "", "equals", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "v", "(Ljava/lang/String;)V", "albumID", "b", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "H", "storyID", "c", "e", "w", AEEditorConstants.ALBUMNAME, "", "Ljava/util/List;", "getTemplateIDList", "()Ljava/util/List;", "J", "(Ljava/util/List;)V", "templateIDList", "getTagNameList", "I", "tagNameList", "Lcom/tencent/mobileqq/wink/newalbum/database/a;", "f", "j", "B", "collectResultList", "Lz83/a;", "g", "i", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "collectPhotoList", tl.h.F, "Z", "r", "()Z", "E", "(Z)V", "isExposed", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()I", "D", "(I)V", "exposeTimes", "Lcom/tencent/mobileqq/wink/newalbum/collector/k;", "Lcom/tencent/mobileqq/wink/newalbum/collector/k;", "o", "()Lcom/tencent/mobileqq/wink/newalbum/collector/k;", "G", "(Lcom/tencent/mobileqq/wink/newalbum/collector/k;)V", CacheTable.TABLE_NAME, "k", "y", "allSearchedDBList", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "allSearchedPhototList", BdhLogUtil.LogTag.Tag_Conn, "currentLoop", "u", "albumCoverPhotoId", HippyTKDListViewAdapter.X, "albumPhotoIdList", ReportConstant.COSTREPORT_PREFIX, UserInfo.SEX_FEMALE, "isLast", "()Lz83/a;", "albumCoverPhoto", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkNewMemoryAlbumResult {

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String albumID;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String storyID;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String albumName;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<String> templateIDList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<String> tagNameList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<com.tencent.mobileqq.wink.newalbum.database.a> collectResultList;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<z83.a> collectPhotoList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isExposed;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int exposeTimes;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private WinkNewAlbumCollectorResultReportInfo reportInfo;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<com.tencent.mobileqq.wink.newalbum.database.a> allSearchedDBList;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<z83.a> allSearchedPhototList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int currentLoop;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String albumCoverPhotoId;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<String> albumPhotoIdList;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private boolean isLast;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H\u0007\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/wink/newalbum/collector/WinkNewMemoryAlbumResult$a;", "", "Landroid/database/Cursor;", "cursor", "Lcom/tencent/mobileqq/wink/newalbum/collector/WinkNewMemoryAlbumResult;", "a", "target", "", "cachedExposedResultList", "", "b", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.newalbum.collector.WinkNewMemoryAlbumResult$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @Nullable
        public final WinkNewMemoryAlbumResult a(@NotNull Cursor cursor) {
            List split$default;
            int collectionSizeOrDefault;
            Intrinsics.checkNotNullParameter(cursor, "cursor");
            WinkNewMemoryAlbumResult winkNewMemoryAlbumResult = new WinkNewMemoryAlbumResult();
            try {
                int columnIndex = cursor.getColumnIndex("albumid");
                if (columnIndex >= 0 && columnIndex < cursor.getColumnCount()) {
                    String string = cursor.getString(columnIndex);
                    Intrinsics.checkNotNullExpressionValue(string, "cursor.getString(columnIndex)");
                    winkNewMemoryAlbumResult.v(string);
                }
                int columnIndex2 = cursor.getColumnIndex("storyid");
                if (columnIndex2 >= 0 && columnIndex2 < cursor.getColumnCount()) {
                    String string2 = cursor.getString(columnIndex2);
                    Intrinsics.checkNotNullExpressionValue(string2, "cursor.getString(columnIndex)");
                    winkNewMemoryAlbumResult.H(string2);
                }
                int columnIndex3 = cursor.getColumnIndex(AdParam.COVERID);
                if (columnIndex3 >= 0 && columnIndex3 < cursor.getColumnCount()) {
                    winkNewMemoryAlbumResult.u(cursor.getString(columnIndex3));
                }
                int columnIndex4 = cursor.getColumnIndex(AEEditorConstants.ALBUMNAME);
                if (columnIndex4 >= 0 && columnIndex4 < cursor.getColumnCount()) {
                    String string3 = cursor.getString(columnIndex4);
                    Intrinsics.checkNotNullExpressionValue(string3, "cursor.getString(columnIndex)");
                    winkNewMemoryAlbumResult.w(string3);
                }
                int columnIndex5 = cursor.getColumnIndex("photoIds");
                if (columnIndex5 >= 0 && columnIndex5 < cursor.getColumnCount()) {
                    String string4 = cursor.getString(columnIndex5);
                    Intrinsics.checkNotNullExpressionValue(string4, "cursor.getString(columnIndex)");
                    split$default = StringsKt__StringsKt.split$default((CharSequence) string4, new String[]{","}, false, 0, 6, (Object) null);
                    List list = split$default;
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                    ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add((String) it.next());
                    }
                    winkNewMemoryAlbumResult.x(arrayList);
                }
                int columnIndex6 = cursor.getColumnIndex("exposureTimes");
                if (columnIndex6 >= 0 && columnIndex6 < cursor.getColumnCount()) {
                    winkNewMemoryAlbumResult.D(cursor.getInt(columnIndex6));
                }
                return winkNewMemoryAlbumResult;
            } catch (Exception unused) {
                return null;
            }
        }

        @JvmStatic
        public final boolean b(@NotNull WinkNewMemoryAlbumResult target, @NotNull List<WinkNewMemoryAlbumResult> cachedExposedResultList) {
            int collectionSizeOrDefault;
            Set set;
            int collectionSizeOrDefault2;
            Set set2;
            Set intersect;
            Intrinsics.checkNotNullParameter(target, "target");
            Intrinsics.checkNotNullParameter(cachedExposedResultList, "cachedExposedResultList");
            try {
                List<z83.a> i3 = target.i();
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(i3, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                Iterator<T> it = i3.iterator();
                while (it.hasNext()) {
                    arrayList.add(((z83.a) it.next()).getId());
                }
                set = CollectionsKt___CollectionsKt.toSet(arrayList);
                int size = set.size();
                Iterator<WinkNewMemoryAlbumResult> it5 = cachedExposedResultList.iterator();
                while (it5.hasNext()) {
                    List<z83.a> i16 = it5.next().i();
                    collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(i16, 10);
                    ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
                    Iterator<T> it6 = i16.iterator();
                    while (it6.hasNext()) {
                        arrayList2.add(((z83.a) it6.next()).getId());
                    }
                    set2 = CollectionsKt___CollectionsKt.toSet(arrayList2);
                    intersect = CollectionsKt___CollectionsKt.intersect(set, set2);
                    if (intersect.size() >= size * w83.b.f445025a.e()) {
                        return true;
                    }
                }
                return false;
            } catch (Exception e16) {
                QLog.e("WinkNewMemoryAlbumResult", 1, e16, new Object[0]);
                return false;
            }
        }

        Companion() {
        }
    }

    public WinkNewMemoryAlbumResult() {
        List<String> emptyList;
        List<String> emptyList2;
        List<com.tencent.mobileqq.wink.newalbum.database.a> emptyList3;
        List<z83.a> emptyList4;
        List<com.tencent.mobileqq.wink.newalbum.database.a> emptyList5;
        List<z83.a> emptyList6;
        String str;
        List<String> emptyList7;
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        this.albumID = uuid;
        this.storyID = "";
        this.albumName = "";
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.templateIDList = emptyList;
        emptyList2 = CollectionsKt__CollectionsKt.emptyList();
        this.tagNameList = emptyList2;
        emptyList3 = CollectionsKt__CollectionsKt.emptyList();
        this.collectResultList = emptyList3;
        emptyList4 = CollectionsKt__CollectionsKt.emptyList();
        this.collectPhotoList = emptyList4;
        this.reportInfo = new WinkNewAlbumCollectorResultReportInfo(0, 0, null, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0, 0, null, null, null, InitSkin.DRAWABLE_COUNT, null);
        emptyList5 = CollectionsKt__CollectionsKt.emptyList();
        this.allSearchedDBList = emptyList5;
        emptyList6 = CollectionsKt__CollectionsKt.emptyList();
        this.allSearchedPhototList = emptyList6;
        z83.a b16 = b();
        if (b16 != null) {
            str = b16.getId();
        } else {
            str = null;
        }
        this.albumCoverPhotoId = str;
        emptyList7 = CollectionsKt__CollectionsKt.emptyList();
        this.albumPhotoIdList = emptyList7;
    }

    @JvmStatic
    @Nullable
    public static final WinkNewMemoryAlbumResult a(@NotNull Cursor cursor) {
        return INSTANCE.a(cursor);
    }

    @JvmStatic
    public static final boolean t(@NotNull WinkNewMemoryAlbumResult winkNewMemoryAlbumResult, @NotNull List<WinkNewMemoryAlbumResult> list) {
        return INSTANCE.b(winkNewMemoryAlbumResult, list);
    }

    public final void A(@NotNull List<z83.a> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.collectPhotoList = list;
    }

    public final void B(@NotNull List<com.tencent.mobileqq.wink.newalbum.database.a> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.collectResultList = list;
    }

    public final void C(int i3) {
        this.currentLoop = i3;
    }

    public final void D(int i3) {
        this.exposeTimes = i3;
    }

    public final void E(boolean z16) {
        this.isExposed = z16;
    }

    public final void F(boolean z16) {
        this.isLast = z16;
    }

    public final void G(@NotNull WinkNewAlbumCollectorResultReportInfo winkNewAlbumCollectorResultReportInfo) {
        Intrinsics.checkNotNullParameter(winkNewAlbumCollectorResultReportInfo, "<set-?>");
        this.reportInfo = winkNewAlbumCollectorResultReportInfo;
    }

    public final void H(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.storyID = str;
    }

    public final void I(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.tagNameList = list;
    }

    public final void J(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.templateIDList = list;
    }

    @Nullable
    public final z83.a b() {
        Object firstOrNull;
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) this.collectPhotoList);
        return (z83.a) firstOrNull;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final String getAlbumCoverPhotoId() {
        return this.albumCoverPhotoId;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getAlbumID() {
        return this.albumID;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getAlbumName() {
        return this.albumName;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(WinkNewMemoryAlbumResult.class), Reflection.getOrCreateKotlinClass(other.getClass()))) {
            return false;
        }
        WinkNewMemoryAlbumResult winkNewMemoryAlbumResult = (WinkNewMemoryAlbumResult) other;
        if (Intrinsics.areEqual(this.storyID, winkNewMemoryAlbumResult.storyID) && this.collectPhotoList.size() == winkNewMemoryAlbumResult.albumPhotoIdList.size() && Intrinsics.areEqual(this.albumCoverPhotoId, winkNewMemoryAlbumResult.albumCoverPhotoId)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final List<String> f() {
        return this.albumPhotoIdList;
    }

    @NotNull
    public final List<com.tencent.mobileqq.wink.newalbum.database.a> g() {
        return this.allSearchedDBList;
    }

    @NotNull
    public final List<z83.a> h() {
        return this.allSearchedPhototList;
    }

    @NotNull
    public final List<z83.a> i() {
        return this.collectPhotoList;
    }

    @NotNull
    public final List<com.tencent.mobileqq.wink.newalbum.database.a> j() {
        return this.collectResultList;
    }

    /* renamed from: k, reason: from getter */
    public final int getCurrentLoop() {
        return this.currentLoop;
    }

    public final long l() {
        Object obj;
        Iterator<T> it = this.collectPhotoList.iterator();
        if (!it.hasNext()) {
            obj = null;
        } else {
            Object next = it.next();
            if (it.hasNext()) {
                long timestamp = ((z83.a) next).getTimestamp();
                do {
                    Object next2 = it.next();
                    long timestamp2 = ((z83.a) next2).getTimestamp();
                    if (timestamp < timestamp2) {
                        next = next2;
                        timestamp = timestamp2;
                    }
                } while (it.hasNext());
            }
            obj = next;
        }
        z83.a aVar = (z83.a) obj;
        if (aVar != null) {
            return aVar.getTimestamp();
        }
        return 0L;
    }

    /* renamed from: m, reason: from getter */
    public final int getExposeTimes() {
        return this.exposeTimes;
    }

    @NotNull
    public final String n() {
        String joinToString$default;
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(this.collectPhotoList, ",", null, null, 0, null, new Function1<z83.a, CharSequence>() { // from class: com.tencent.mobileqq.wink.newalbum.collector.WinkNewMemoryAlbumResult$getPhotoIdList$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final CharSequence invoke(@NotNull z83.a it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getId();
            }
        }, 30, null);
        return joinToString$default;
    }

    @NotNull
    /* renamed from: o, reason: from getter */
    public final WinkNewAlbumCollectorResultReportInfo getReportInfo() {
        return this.reportInfo;
    }

    public final long p() {
        Object obj;
        Iterator<T> it = this.collectPhotoList.iterator();
        if (!it.hasNext()) {
            obj = null;
        } else {
            Object next = it.next();
            if (it.hasNext()) {
                long timestamp = ((z83.a) next).getTimestamp();
                do {
                    Object next2 = it.next();
                    long timestamp2 = ((z83.a) next2).getTimestamp();
                    if (timestamp > timestamp2) {
                        next = next2;
                        timestamp = timestamp2;
                    }
                } while (it.hasNext());
            }
            obj = next;
        }
        z83.a aVar = (z83.a) obj;
        if (aVar != null) {
            return aVar.getTimestamp();
        }
        return 0L;
    }

    @NotNull
    /* renamed from: q, reason: from getter */
    public final String getStoryID() {
        return this.storyID;
    }

    /* renamed from: r, reason: from getter */
    public final boolean getIsExposed() {
        return this.isExposed;
    }

    /* renamed from: s, reason: from getter */
    public final boolean getIsLast() {
        return this.isLast;
    }

    public final void u(@Nullable String str) {
        this.albumCoverPhotoId = str;
    }

    public final void v(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.albumID = str;
    }

    public final void w(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.albumName = str;
    }

    public final void x(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.albumPhotoIdList = list;
    }

    public final void y(@NotNull List<com.tencent.mobileqq.wink.newalbum.database.a> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.allSearchedDBList = list;
    }

    public final void z(@NotNull List<z83.a> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.allSearchedPhototList = list;
    }
}
