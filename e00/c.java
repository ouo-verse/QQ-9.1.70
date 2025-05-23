package e00;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import androidx.viewpager.widget.ViewPager;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.weishi.event.WSComboHomePageChangeEvent;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.xweb.FileReaderHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001d\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0016\u00a2\u0006\u0004\b8\u00109J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J(\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\u0012\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0002H\u0016J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0002H\u0016R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR*\u0010'\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u00028\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b\u001e\u0010&R\u0016\u0010)\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010#R\u0016\u0010+\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010#R\u0016\u0010.\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00100\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010#R\u0016\u00103\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\"\u00107\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u00102\u001a\u0004\b4\u00105\"\u0004\b\u001a\u00106\u00a8\u0006:"}, d2 = {"Le00/c;", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "", "index", "", "enterPercent", "", "leftToRight", FileReaderHelper.OPEN_FILE_FROM_FORCE, "", "b", "leavePercent", "c", "d", "a", "position", "positionOffset", "positionOffsetPixels", WSComboHomePageChangeEvent.EVENT_ON_PAGE_SCROLLED, "onPageSelected", "state", "onPageScrollStateChanged", "Le00/a;", "Le00/a;", "scrollListener", "Landroid/util/SparseBooleanArray;", "e", "Landroid/util/SparseBooleanArray;", "deselectedItems", "Landroid/util/SparseArray;", "f", "Landroid/util/SparseArray;", "leavePercents", "value", h.F, "I", "getTotalCount", "()I", "(I)V", "totalCount", "i", "currentIndex", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "lastIndex", BdhLogUtil.LogTag.Tag_Conn, UserInfo.SEX_FEMALE, "lastPositionOffsetSum", "D", HippyTKDListViewAdapter.SCROLL_STATE, "E", "Z", "isDragging", "getSkimOver", "()Z", "(Z)V", "skimOver", "<init>", "(Le00/a;)V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class c implements ViewPager.OnPageChangeListener {

    /* renamed from: C, reason: from kotlin metadata */
    private float lastPositionOffsetSum;

    /* renamed from: D, reason: from kotlin metadata */
    private int scrollState;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isDragging;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean skimOver;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final a scrollListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final SparseBooleanArray deselectedItems = new SparseBooleanArray();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final SparseArray<Float> leavePercents = new SparseArray<>();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int totalCount;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int currentIndex;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int lastIndex;

    public c(a aVar) {
        this.scrollListener = aVar;
    }

    private final void a(int index) {
        a aVar = this.scrollListener;
        if (aVar != null) {
            aVar.a(index, this.totalCount);
        }
        this.deselectedItems.put(index, true);
    }

    private final void b(int index, float enterPercent, boolean leftToRight, boolean force) {
        if (this.skimOver || index == this.currentIndex || this.scrollState == 1 || force) {
            a aVar = this.scrollListener;
            if (aVar != null) {
                aVar.b(index, this.totalCount, enterPercent, leftToRight);
            }
            this.leavePercents.put(index, Float.valueOf(1.0f - enterPercent));
        }
    }

    private final void c(int index, float leavePercent, boolean leftToRight, boolean force) {
        if (!this.skimOver && index != this.lastIndex && this.scrollState != 1) {
            int i3 = this.currentIndex;
            if (((index != i3 - 1 && index != i3 + 1) || Intrinsics.areEqual(this.leavePercents.get(index, Float.valueOf(0.0f)), 1.0f)) && !force) {
                return;
            }
        }
        a aVar = this.scrollListener;
        if (aVar != null) {
            aVar.d(index, this.totalCount, leavePercent, leftToRight);
        }
        this.leavePercents.put(index, Float.valueOf(leavePercent));
    }

    private final void d(int index) {
        a aVar = this.scrollListener;
        if (aVar != null) {
            aVar.c(index, this.totalCount);
        }
        this.deselectedItems.put(index, false);
    }

    public final void e(boolean z16) {
        this.skimOver = z16;
    }

    public final void f(int i3) {
        this.totalCount = i3;
        this.deselectedItems.clear();
        this.leavePercents.clear();
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        boolean z16;
        if (this.isDragging) {
            float f16 = position + positionOffset;
            float f17 = this.lastPositionOffsetSum;
            boolean z17 = f17 <= f16;
            if (this.scrollState != 0) {
                if (f16 == f17) {
                    return;
                }
                int i3 = position + 1;
                if ((positionOffset == 0.0f) && z17) {
                    i3 = position - 1;
                    z16 = false;
                } else {
                    z16 = true;
                }
                int i16 = this.totalCount;
                for (int i17 = 0; i17 < i16; i17++) {
                    if (i17 != position && i17 != i3 && !Intrinsics.areEqual(this.leavePercents.get(i17, Float.valueOf(0.0f)), 1.0f)) {
                        c(i17, 1.0f, z17, true);
                    }
                }
                if (!z16) {
                    float f18 = 1.0f - positionOffset;
                    c(i3, f18, true, false);
                    b(position, f18, true, false);
                } else if (z17) {
                    c(position, positionOffset, true, false);
                    b(i3, positionOffset, true, false);
                } else {
                    float f19 = 1.0f - positionOffset;
                    c(i3, f19, false, false);
                    b(position, f19, false, false);
                }
            } else {
                int i18 = this.totalCount;
                for (int i19 = 0; i19 < i18; i19++) {
                    if (i19 != this.currentIndex) {
                        if (!this.deselectedItems.get(i19)) {
                            a(i19);
                        }
                        if (!Intrinsics.areEqual(this.leavePercents.get(i19, Float.valueOf(0.0f)), 1.0f)) {
                            c(i19, 1.0f, false, true);
                        }
                    }
                }
                b(this.currentIndex, 1.0f, false, true);
                d(this.currentIndex);
            }
            this.lastPositionOffsetSum = f16;
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int position) {
        this.lastIndex = this.currentIndex;
        this.currentIndex = position;
        d(position);
        int i3 = this.totalCount;
        for (int i16 = 0; i16 < i3; i16++) {
            if (i16 != this.currentIndex && !this.deselectedItems.get(i16)) {
                a(i16);
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int state) {
        if (state == 0) {
            this.isDragging = false;
        } else if (state == 1) {
            this.isDragging = true;
        }
        this.scrollState = state;
    }
}
