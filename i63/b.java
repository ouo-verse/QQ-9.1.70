package i63;

import androidx.annotation.VisibleForTesting;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import j63.d;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 !2\u00020\u0001:\u0003*$\u0015B\u0007\u00a2\u0006\u0004\bI\u0010JJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002J$\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\r2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0002J$\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\r2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0002J\u0018\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0007H\u0002J\u0018\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0002H\u0002J\u0018\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u000bH\u0002J\u000e\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0019J\u0006\u0010\u001b\u001a\u00020\u0019J\u0006\u0010\u001c\u001a\u00020\u000bJ\u000e\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001dJ\u000e\u0010!\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001dJ\u0006\u0010\"\u001a\u00020\u0019J\u000e\u0010#\u001a\u00020\u00192\u0006\u0010\b\u001a\u00020\u0007J\u001c\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\r2\u0006\u0010\u0016\u001a\u00020\u0007H\u0007J\u000e\u0010%\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0007J\u000e\u0010&\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0007J\u000e\u0010'\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0019J\u000e\u0010*\u001a\u00020\u00042\u0006\u0010)\u001a\u00020(J\u000e\u0010+\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0007J\u000e\u0010,\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0007J\u000e\u0010/\u001a\u00020\u00042\u0006\u0010.\u001a\u00020-R\u001d\u00104\u001a\b\u0012\u0004\u0012\u00020\u001d008\u0006\u00a2\u0006\f\n\u0004\b*\u00101\u001a\u0004\b2\u00103R$\u00108\u001a\u0012\u0012\u0004\u0012\u00020\u000205j\b\u0012\u0004\u0012\u00020\u0002`68\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u00107R\u0016\u0010:\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u00109R\u0016\u0010;\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u00109R\u0018\u0010>\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\"\u0010D\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u0016\u0010E\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010?R\u0016\u0010F\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010?R\u0018\u0010)\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010GR\u0014\u0010H\u001a\u00020\u00078BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b<\u0010A\u00a8\u0006K"}, d2 = {"Li63/b;", "", "Lj63/d;", "sizeParam", "", "u", "v", "", "px", "w", "space", "", "index", "Lkotlin/Pair;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "timeUs", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "oldSize", "newSize", "c", "scaleFactor", "nextIndex", DomainData.DOMAIN_NAME, "", "r", "g", "d", "Li63/c;", "scalePoint", "", "k", "j", "f", HippyTKDListViewAdapter.X, "b", ReportConstant.COSTREPORT_PREFIX, "t", "y", "Li63/b$c;", "scaleView", "a", "o", "p", "Li63/b$b;", "dataProvider", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "Ljava/util/List;", "i", "()Ljava/util/List;", "scaleList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "sizeParamArrayList", "J", "startTimeUs", "endTimeUs", "e", "Lj63/d;", "currSizeParam", UserInfo.SEX_FEMALE, h.F, "()F", "setPerSpace", "(F)V", "perSpace", "maxSpace", "minSpace", "Li63/b$c;", "currentScrollX", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class b {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long startTimeUs;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long endTimeUs;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private d currSizeParam;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private c scaleView;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<ScalePoint> scaleList = new ArrayList();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ArrayList<d> sizeParamArrayList = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float perSpace = 93.0f;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private float maxSpace = 93.0f;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private float minSpace = 72.0f;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&J\b\u0010\u0006\u001a\u00020\u0005H&\u00a8\u0006\u0007"}, d2 = {"Li63/b$b;", "", "", "Lj63/d;", "a", "", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: i63.b$b, reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public interface InterfaceC10509b {
        @NotNull
        List<d> a();

        int b();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0002H&\u00a8\u0006\u0007"}, d2 = {"Li63/b$c;", "", "", HippyTKDListViewAdapter.X, "", "a", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public interface c {
        void a(int x16);

        /* renamed from: b */
        int getCurrentScrollX();
    }

    public b() {
        q(new j63.a());
    }

    private final float A(d sizeParam, float timeUs) {
        return this.perSpace * sizeParam.a(timeUs);
    }

    private final float c(d oldSize, d newSize) {
        return oldSize.a(1000000.0f) / newSize.a(1000000.0f);
    }

    private final float e() {
        if (this.scaleView != null) {
            return r0.getCurrentScrollX();
        }
        return 0.0f;
    }

    private final Pair<Integer, Integer> l(float space, int index) {
        if (space >= this.maxSpace) {
            if (index == 0) {
                return TuplesKt.to(1, Integer.valueOf(index));
            }
            return TuplesKt.to(0, Integer.valueOf(index - 1));
        }
        return TuplesKt.to(2, Integer.valueOf(index));
    }

    private final Pair<Integer, Integer> m(float space, int index) {
        int lastIndex;
        if (space <= this.minSpace) {
            lastIndex = CollectionsKt__CollectionsKt.getLastIndex(this.sizeParamArrayList);
            if (index == lastIndex) {
                return TuplesKt.to(1, Integer.valueOf(index));
            }
            return TuplesKt.to(0, Integer.valueOf(index + 1));
        }
        return TuplesKt.to(2, Integer.valueOf(index));
    }

    private final void n(float scaleFactor, int nextIndex) {
        float f16;
        float f17;
        d dVar = this.sizeParamArrayList.get(nextIndex);
        Intrinsics.checkNotNullExpressionValue(dVar, "sizeParamArrayList[nextIndex]");
        d dVar2 = dVar;
        d dVar3 = this.currSizeParam;
        if (dVar3 != null) {
            f16 = c(dVar3, dVar2);
        } else {
            f16 = 1.0f;
        }
        if (scaleFactor > 1.0f) {
            f17 = this.maxSpace;
        } else {
            f17 = this.minSpace;
        }
        this.perSpace = f17 * f16;
        u(dVar2);
    }

    private final void u(d sizeParam) {
        this.currSizeParam = sizeParam;
        v();
    }

    private final void v() {
        int i3;
        d dVar = this.currSizeParam;
        if (dVar != null) {
            this.scaleList.clear();
            int a16 = ((int) dVar.a((float) (this.endTimeUs - this.startTimeUs))) + 1;
            for (int i16 = 0; i16 < a16; i16++) {
                if (i16 % 2 == 0) {
                    i3 = 0;
                } else {
                    i3 = 1;
                }
                this.scaleList.add(new ScalePoint(i16, i3));
            }
        }
    }

    private final float w(float px5) {
        d dVar = this.currSizeParam;
        if (dVar != null) {
            return ((float) this.startTimeUs) + dVar.c(px5, this.perSpace);
        }
        return (float) this.startTimeUs;
    }

    private final float z(float timeUs) {
        float f16;
        d dVar = this.currSizeParam;
        if (dVar != null) {
            f16 = A(dVar, timeUs);
        } else {
            f16 = 0.0f;
        }
        if (Float.isNaN(f16)) {
            return 0.0f;
        }
        return f16;
    }

    public final void a(@NotNull c scaleView) {
        Intrinsics.checkNotNullParameter(scaleView, "scaleView");
        this.scaleView = scaleView;
    }

    @VisibleForTesting
    @NotNull
    public final Pair<Integer, Integer> b(float scaleFactor) {
        int indexOf;
        boolean z16;
        indexOf = CollectionsKt___CollectionsKt.indexOf((List<? extends d>) ((List<? extends Object>) this.sizeParamArrayList), this.currSizeParam);
        if (scaleFactor == 1.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return TuplesKt.to(1, Integer.valueOf(indexOf));
        }
        float f16 = this.perSpace * scaleFactor;
        if (scaleFactor > 1.0f) {
            return l(f16, indexOf);
        }
        return m(f16, indexOf);
    }

    public final int d() {
        int roundToInt;
        roundToInt = MathKt__MathJVMKt.roundToInt(z((float) this.endTimeUs));
        return roundToInt;
    }

    public final long f() {
        return w(e());
    }

    /* renamed from: g, reason: from getter */
    public final long getEndTimeUs() {
        return this.endTimeUs;
    }

    /* renamed from: h, reason: from getter */
    public final float getPerSpace() {
        return this.perSpace;
    }

    @NotNull
    public final List<ScalePoint> i() {
        return this.scaleList;
    }

    public final long j(@NotNull ScalePoint scalePoint) {
        long roundToLong;
        Intrinsics.checkNotNullParameter(scalePoint, "scalePoint");
        d dVar = this.currSizeParam;
        if (dVar != null) {
            long j3 = this.startTimeUs;
            float position = scalePoint.getPosition();
            float f16 = this.perSpace;
            roundToLong = MathKt__MathJVMKt.roundToLong(dVar.c(position * f16, f16));
            return j3 + roundToLong;
        }
        return 0L;
    }

    @NotNull
    public final String k(@NotNull ScalePoint scalePoint) {
        Intrinsics.checkNotNullParameter(scalePoint, "scalePoint");
        d dVar = this.currSizeParam;
        if (dVar != null) {
            return dVar.b(j(scalePoint));
        }
        return "";
    }

    public final void o(float scaleFactor) {
        int roundToInt;
        float w3 = w(e());
        Pair<Integer, Integer> b16 = b(scaleFactor);
        int intValue = b16.component1().intValue();
        int intValue2 = b16.component2().intValue();
        if (intValue != 1) {
            if (intValue == 0) {
                n(scaleFactor, intValue2);
            } else {
                this.perSpace *= scaleFactor;
            }
            float z16 = z(w3);
            c cVar = this.scaleView;
            if (cVar != null) {
                roundToInt = MathKt__MathJVMKt.roundToInt(z16);
                cVar.a(roundToInt);
            }
        }
    }

    public final void p(float scaleFactor) {
        int roundToInt;
        float w3 = w(e());
        this.perSpace *= scaleFactor;
        float z16 = z(w3);
        c cVar = this.scaleView;
        if (cVar != null) {
            roundToInt = MathKt__MathJVMKt.roundToInt(z16);
            cVar.a(roundToInt);
        }
    }

    public final void q(@NotNull InterfaceC10509b dataProvider) {
        boolean z16;
        d dVar;
        int lastIndex;
        Intrinsics.checkNotNullParameter(dataProvider, "dataProvider");
        List<d> a16 = dataProvider.a();
        if (a16 != null && !a16.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        ArrayList<d> arrayList = this.sizeParamArrayList;
        arrayList.clear();
        arrayList.addAll(dataProvider.a());
        int b16 = dataProvider.b();
        if (b16 >= 0) {
            lastIndex = CollectionsKt__CollectionsKt.getLastIndex(arrayList);
            if (b16 <= lastIndex) {
                dVar = arrayList.get(b16);
                this.currSizeParam = dVar;
                v();
            }
        }
        d dVar2 = arrayList.get(0);
        Intrinsics.checkNotNullExpressionValue(dVar2, "this[0]");
        dVar = dVar2;
        this.currSizeParam = dVar;
        v();
    }

    public final void r(long timeUs) {
        this.endTimeUs = timeUs;
        v();
    }

    public final void s(float space) {
        this.maxSpace = space;
        this.perSpace = space;
    }

    public final void t(float space) {
        this.minSpace = space;
    }

    public final long x(float px5) {
        return w(px5);
    }

    public final int y(long timeUs) {
        return (int) z((float) timeUs);
    }
}
