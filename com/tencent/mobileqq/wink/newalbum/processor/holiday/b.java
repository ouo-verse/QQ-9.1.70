package com.tencent.mobileqq.wink.newalbum.processor.holiday;

import android.text.TextUtils;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.startup.step.InitSkin;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.wink.newalbum.collector.WinkNewAlbumCollectorResultReportInfo;
import com.tencent.mobileqq.wink.newalbum.collector.WinkNewMemoryAlbumResult;
import com.tencent.mobileqq.wink.newalbum.collector.j;
import com.tencent.mobileqq.wink.newalbum.processor.WinkNewAlbumContext;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 $2\u00020\u0001:\u0001\u001aB!\u0012\b\u00100\u001a\u0004\u0018\u00010/\u0012\u0006\u00102\u001a\u000201\u0012\u0006\u0010\u001d\u001a\u00020\u001b\u00a2\u0006\u0004\b3\u00104J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002H\u0002J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0010H\u0002J\u0018\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u0010H\u0002J\b\u0010\u0017\u001a\u00020\u0004H\u0002J\b\u0010\u0018\u001a\u00020\u0004H\u0016J\b\u0010\u0019\u001a\u00020\u0004H\u0016J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u001d\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u001cR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010$R\u0016\u0010)\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010$R\u0016\u0010+\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010$R\u0016\u0010.\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/wink/newalbum/processor/holiday/b;", "Lcom/tencent/mobileqq/wink/newalbum/processor/b;", "Lcom/tencent/mobileqq/wink/newalbum/processor/d;", "context", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/wink/newalbum/processor/holiday/a;", QZoneJsConstants.SOURCE_HOLIDAY, "", "albumContexts", "j", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "firstMemoryAlbum", "secondMemoryAlbum", "l", "Lcom/tencent/mobileqq/wink/newalbum/collector/WinkNewMemoryAlbumResult;", "k", "album", DomainData.DOMAIN_NAME, "", "startCollectTime", "p", "o", "g", DKHippyEvent.EVENT_STOP, "a", "La93/b;", "La93/b;", "terminatorProcessor", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "candidateAlbumContexts", "", "D", "I", "totalCount", "E", "lowQualityCount", UserInfo.SEX_FEMALE, "noCameraCount", "G", "usedCount", "H", "J", "collectStartTime", "Lcom/tencent/mobileqq/wink/newalbum/processor/a;", "next", "", "traceId", "<init>", "(Lcom/tencent/mobileqq/wink/newalbum/processor/a;Ljava/lang/String;La93/b;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class b extends com.tencent.mobileqq.wink.newalbum.processor.b {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final List<WinkNewAlbumContext> candidateAlbumContexts;

    /* renamed from: D, reason: from kotlin metadata */
    private int totalCount;

    /* renamed from: E, reason: from kotlin metadata */
    private int lowQualityCount;

    /* renamed from: F, reason: from kotlin metadata */
    private int noCameraCount;

    /* renamed from: G, reason: from kotlin metadata */
    private int usedCount;

    /* renamed from: H, reason: from kotlin metadata */
    private long collectStartTime;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a93.b terminatorProcessor;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.wink.newalbum.processor.holiday.b$b, reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public static final class C9066b<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Float.valueOf(((WinkNewAlbumContext) t17).getAestheticScore()), Float.valueOf(((WinkNewAlbumContext) t16).getAestheticScore()));
            return compareValues;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@Nullable com.tencent.mobileqq.wink.newalbum.processor.a aVar, @NotNull String traceId, @NotNull a93.b terminatorProcessor) {
        super(aVar, traceId);
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        Intrinsics.checkNotNullParameter(terminatorProcessor, "terminatorProcessor");
        this.terminatorProcessor = terminatorProcessor;
        this.candidateAlbumContexts = new ArrayList();
        this.collectStartTime = System.currentTimeMillis();
    }

    private final void j(Festival holiday, List<WinkNewAlbumContext> albumContexts) {
        List sortedWith;
        int collectionSizeOrDefault;
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(albumContexts, new C9066b());
        if (sortedWith.size() > 10) {
            sortedWith = CollectionsKt___CollectionsKt.take(sortedWith, 10);
        }
        WinkNewMemoryAlbumResult k3 = k(holiday, albumContexts.get(0));
        List list = sortedWith;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((WinkNewAlbumContext) it.next()).getMetaData());
        }
        k3.A(arrayList);
        n(k3);
    }

    private final WinkNewMemoryAlbumResult k(Festival holiday, WinkNewAlbumContext context) {
        List<String> mutableListOf;
        WinkNewMemoryAlbumResult winkNewMemoryAlbumResult = new WinkNewMemoryAlbumResult();
        winkNewMemoryAlbumResult.H("memory_jr_" + context.getMetaData().getYear() + "_" + context.getMetaData().getMonth() + "_" + context.getMetaData().getDayOfMonth());
        winkNewMemoryAlbumResult.w(holiday.getFestivalName());
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(holiday.getFestivalName());
        winkNewMemoryAlbumResult.I(mutableListOf);
        winkNewMemoryAlbumResult.J(holiday.b());
        return winkNewMemoryAlbumResult;
    }

    private final boolean l(WinkNewAlbumContext firstMemoryAlbum, WinkNewAlbumContext secondMemoryAlbum) {
        z83.a metaData = firstMemoryAlbum.getMetaData();
        z83.a metaData2 = secondMemoryAlbum.getMetaData();
        if (metaData.getYear() == metaData2.getYear() && metaData.getMonth() == metaData2.getMonth() && metaData.getDayOfMonth() == metaData2.getDayOfMonth()) {
            return false;
        }
        return true;
    }

    private final void m(WinkNewAlbumContext context) {
        if (context.getAestheticScore() < w83.b.f445025a.c()) {
            this.lowQualityCount++;
            return;
        }
        if (context.getMetaData().getSubMediaType() != 1) {
            this.noCameraCount++;
            return;
        }
        if (q(context)) {
            z83.a metaData = this.candidateAlbumContexts.get(0).getMetaData();
            if (this.candidateAlbumContexts.size() >= 4) {
                Festival b16 = WinkNewAlbumHolidayChecker.f324258a.b(metaData);
                if (b16 != null && !TextUtils.isEmpty(b16.getFestivalName())) {
                    j(b16, this.candidateAlbumContexts);
                } else {
                    QLog.d("WinkNewAlbumHolidayCollectorProcessor", 4, "prepareCollect qive up, not holiday, " + metaData.getYear() + "_" + metaData.getMonth() + "_" + metaData.getDayOfMonth());
                }
            } else {
                QLog.d("WinkNewAlbumHolidayCollectorProcessor", 4, "prepareCollect qive up, candidateAlbumContexts.size:" + this.candidateAlbumContexts.size() + ", " + metaData.getYear() + "_" + metaData.getMonth() + "_" + metaData.getDayOfMonth());
            }
            this.candidateAlbumContexts.clear();
        }
        this.candidateAlbumContexts.add(context);
    }

    private final void n(WinkNewMemoryAlbumResult album) {
        a93.b bVar = this.terminatorProcessor;
        if (bVar != null) {
            bVar.f(album);
        }
        p(this.collectStartTime, album);
        this.collectStartTime = System.currentTimeMillis();
        this.usedCount += album.i().size();
        QLog.i("WinkNewAlbumHolidayCollectorProcessor", 1, "pushCollectedAlbumResult albumID=" + album.getStoryID() + ", albumName=" + album.getCom.tencent.aelight.camera.constants.AEEditorConstants.ALBUMNAME java.lang.String());
    }

    private final void o() {
        h(j.INSTANCE.b(this.totalCount, this.lowQualityCount, this.noCameraCount, this.usedCount, System.currentTimeMillis() - getStartTime()));
    }

    private final void p(long startCollectTime, WinkNewMemoryAlbumResult album) {
        long currentTimeMillis = System.currentTimeMillis() - startCollectTime;
        WinkNewAlbumCollectorResultReportInfo winkNewAlbumCollectorResultReportInfo = new WinkNewAlbumCollectorResultReportInfo(0, 0, null, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0, 0, null, null, null, InitSkin.DRAWABLE_COUNT, null);
        winkNewAlbumCollectorResultReportInfo.o(album.getStoryID());
        winkNewAlbumCollectorResultReportInfo.q(album.i().size());
        winkNewAlbumCollectorResultReportInfo.r(getTraceId());
        h(j.INSTANCE.f(winkNewAlbumCollectorResultReportInfo, currentTimeMillis));
    }

    private final boolean q(WinkNewAlbumContext context) {
        if (this.candidateAlbumContexts.size() == 0) {
            return false;
        }
        if (context.getIsLast()) {
            return true;
        }
        return l(context, this.candidateAlbumContexts.get(0));
    }

    @Override // com.tencent.mobileqq.wink.newalbum.processor.b, com.tencent.mobileqq.wink.newalbum.processor.a
    public void a(@NotNull WinkNewAlbumContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.a(context);
        if (w83.b.f445025a.C()) {
            m(context);
            this.totalCount++;
        }
    }

    @Override // com.tencent.mobileqq.wink.newalbum.processor.b
    public void g() {
        QLog.i("WinkNewAlbumHolidayCollectorProcessor", 1, "onStart");
    }

    @Override // com.tencent.mobileqq.wink.newalbum.processor.b
    public void onStop() {
        this.candidateAlbumContexts.clear();
        o();
        QLog.i("WinkNewAlbumHolidayCollectorProcessor", 1, "totalCount:" + this.totalCount + ", lowQualityCount:" + this.lowQualityCount + ", noCameraCount:" + this.noCameraCount + ", usedCount:" + this.usedCount);
    }
}
