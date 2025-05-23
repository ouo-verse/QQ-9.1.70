package com.tencent.mobileqq.wink.picker.core.repository;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.data.QZoneCommonServlet;
import com.tencent.mobileqq.data.QzoneCommonIntent;
import com.tencent.mobileqq.wink.picker.MediaMimeType;
import com.tencent.mobileqq.wink.picker.TabType;
import com.tencent.mobileqq.wink.picker.core.repository.a;
import com.tencent.mobileqq.wink.picker.core.repository.c;
import com.tencent.mobileqq.wink.picker.core.repository.d;
import e93.QZoneAlbumInfo;
import e93.QZoneAlbumStruct;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AccountNotMatchException;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001c2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0006\u0010\u0003\u001a\u00020\u0002J.\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0016R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0015R \u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/repository/m;", "Lcom/tencent/mobileqq/wink/picker/core/repository/a;", "", "e", "", "albumId", "", "mediaNum", "", "", "payload", "a", "Lcom/tencent/mobileqq/wink/picker/TabType;", "c", "Lcom/tencent/mobileqq/wink/picker/TabType;", "qZoneMediaTabType", "", "d", "Ljava/util/List;", "qZoneSupportedImageTypes", "Le93/j;", "Le93/j;", "qZoneAlbumInfo", "f", "Ljava/util/Map;", "albumIdToAttachInfo", "<init>", "()V", "g", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class m extends a {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final TabType qZoneMediaTabType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<String> qZoneSupportedImageTypes;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QZoneAlbumInfo qZoneAlbumInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, String> albumIdToAttachInfo;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f324674a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f324675b;

        static {
            int[] iArr = new int[MediaMimeType.values().length];
            try {
                iArr[MediaMimeType.IMAGE_JPEG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MediaMimeType.IMAGE_PNG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MediaMimeType.IMAGE_GIF.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MediaMimeType.IMAGE_WEBP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[MediaMimeType.IMAGE_HEIF.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[MediaMimeType.IMAGE_AVIF.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[MediaMimeType.VIDEO_MP4.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f324674a = iArr;
            int[] iArr2 = new int[TabType.values().length];
            try {
                iArr2[TabType.ONLY_VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[TabType.ONLY_IMAGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            f324675b = iArr2;
        }
    }

    public m() {
        int collectionSizeOrDefault;
        List<String> list;
        String str;
        com.tencent.mobileqq.wink.picker.core.c cVar = com.tencent.mobileqq.wink.picker.core.c.f324480a;
        this.qZoneMediaTabType = cVar.b().getZoneMediaTabType();
        List<MediaMimeType> supportImageType = cVar.b().getQueryMediaFilter().getSupportImageType();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(supportImageType, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = supportImageType.iterator();
        while (it.hasNext()) {
            switch (b.f324674a[((MediaMimeType) it.next()).ordinal()]) {
                case 1:
                    str = "image/jpeg";
                    break;
                case 2:
                    str = "image/png";
                    break;
                case 3:
                    str = "image/gif";
                    break;
                case 4:
                    str = "image/webp";
                    break;
                case 5:
                    str = MimeHelper.IMAGE_HEIF;
                    break;
                case 6:
                    str = "image/avif";
                    break;
                case 7:
                    str = "video/mp4";
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            arrayList.add(str);
        }
        list = CollectionsKt___CollectionsKt.toList(arrayList);
        this.qZoneSupportedImageTypes = list;
        this.albumIdToAttachInfo = new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(m this$0, List data) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(data, "data");
        Iterator it = data.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            i3 += ((QZoneAlbumStruct) it.next()).getAlbumNum();
        }
        w53.b.f("WinkQZoneMediaRepository", "[queryAlbum] ==> albumNum=" + data.size() + ", totalMediaNum=" + i3);
        QZoneAlbumInfo qZoneAlbumInfo = new QZoneAlbumInfo(data, i3);
        this$0.qZoneAlbumInfo = qZoneAlbumInfo;
        a.b bVar = this$0.mediaQueryListener;
        if (bVar != null) {
            Intrinsics.checkNotNull(qZoneAlbumInfo);
            bVar.a(qZoneAlbumInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(m this$0, String albumId, boolean z16, List data, boolean z17, String attachInfo) {
        int i3;
        boolean z18;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(albumId, "$albumId");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(attachInfo, "attachInfo");
        if (!z16) {
            w53.b.c("WinkQZoneMediaRepository", "[queryMediaNext] query qzone failed");
            a.b bVar = this$0.mediaQueryListener;
            if (bVar != null) {
                bVar.b(new com.tencent.mobileqq.wink.picker.core.repository.b(albumId, null, false, false, null, 18, null));
                return;
            }
            return;
        }
        this$0.albumIdToAttachInfo.put(albumId, attachInfo);
        TabType tabType = this$0.qZoneMediaTabType;
        if (tabType == null) {
            i3 = -1;
        } else {
            i3 = b.f324675b[tabType.ordinal()];
        }
        if (i3 != 1) {
            if (i3 == 2) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : data) {
                    LocalMediaInfo localMediaInfo = (LocalMediaInfo) obj;
                    if (e93.i.G(localMediaInfo) && this$0.qZoneSupportedImageTypes.contains(localMediaInfo.mMimeType)) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (z18) {
                        arrayList.add(obj);
                    }
                }
                data = CollectionsKt___CollectionsKt.toList(arrayList);
            }
        } else {
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : data) {
                if (e93.i.I((LocalMediaInfo) obj2)) {
                    arrayList2.add(obj2);
                }
            }
            data = CollectionsKt___CollectionsKt.toList(arrayList2);
        }
        List list = data;
        a.b bVar2 = this$0.mediaQueryListener;
        if (bVar2 != null) {
            bVar2.b(new com.tencent.mobileqq.wink.picker.core.repository.b(albumId, list, true, z17, null, 16, null));
        }
    }

    @Override // com.tencent.mobileqq.wink.picker.core.repository.a
    public void a(@NotNull final String albumId, int mediaNum, @Nullable Map<String, Object> payload) {
        Intrinsics.checkNotNullParameter(albumId, "albumId");
        d.a aVar = new d.a() { // from class: com.tencent.mobileqq.wink.picker.core.repository.l
            @Override // com.tencent.mobileqq.wink.picker.core.repository.d.a
            public final void a(boolean z16, List list, boolean z17, String str) {
                m.g(m.this, albumId, z16, list, z17, str);
            }
        };
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        long longAccountUin = peekAppRuntime.getLongAccountUin();
        Map<String, String> map = this.albumIdToAttachInfo;
        String str = map.get(albumId);
        if (str == null) {
            str = "";
            map.put(albumId, "");
        }
        d dVar = new d(longAccountUin, albumId, aVar, str);
        QzoneCommonIntent qzoneCommonIntent = new QzoneCommonIntent(peekAppRuntime.getApplicationContext(), QZoneCommonServlet.class);
        qzoneCommonIntent.setRequest(dVar);
        qzoneCommonIntent.setObserver(dVar);
        try {
            MobileQQ.sMobileQQ.getAppRuntime(peekAppRuntime.getAccount()).startServlet(qzoneCommonIntent);
        } catch (AccountNotMatchException e16) {
            w53.b.d("WinkQZoneMediaRepository", "Account not match", e16);
        }
    }

    public final void e() {
        List emptyList;
        QZoneAlbumInfo qZoneAlbumInfo = this.qZoneAlbumInfo;
        if (qZoneAlbumInfo == null) {
            c.a aVar = new c.a() { // from class: com.tencent.mobileqq.wink.picker.core.repository.k
                @Override // com.tencent.mobileqq.wink.picker.core.repository.c.a
                public final void a(List list) {
                    m.f(m.this, list);
                }
            };
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                w53.b.c("WinkQZoneMediaRepository", "[queryAlbum] appRuntime is null");
                a.b bVar = this.mediaQueryListener;
                if (bVar != null) {
                    emptyList = CollectionsKt__CollectionsKt.emptyList();
                    bVar.a(new QZoneAlbumInfo(emptyList, 0));
                    return;
                }
                return;
            }
            c cVar = new c(peekAppRuntime.getLongAccountUin(), 1, "", aVar);
            QzoneCommonIntent qzoneCommonIntent = new QzoneCommonIntent(peekAppRuntime.getApplicationContext(), QZoneCommonServlet.class);
            qzoneCommonIntent.setRequest(cVar);
            qzoneCommonIntent.setObserver(cVar);
            MobileQQ.sMobileQQ.getAppRuntime(peekAppRuntime.getAccount()).startServlet(qzoneCommonIntent);
            return;
        }
        a.b bVar2 = this.mediaQueryListener;
        if (bVar2 != null) {
            Intrinsics.checkNotNull(qZoneAlbumInfo);
            bVar2.a(qZoneAlbumInfo);
        }
    }
}
