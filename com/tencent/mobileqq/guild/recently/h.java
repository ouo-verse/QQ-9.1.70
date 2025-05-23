package com.tencent.mobileqq.guild.recently;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import java.util.Date;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010\r\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016R\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0013\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/recently/h;", "Lcom/tencent/biz/richframework/part/Part;", "", "time", "", "x9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "", "action", "", "args", "handleBroadcastMessage", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "mTimeView", "e", "J", "mTodayTime", "f", "mYesterdayTime", tl.h.F, "mOneWeekTime", "<init>", "()V", "i", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class h extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private TextView mTimeView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long mTodayTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long mYesterdayTime;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long mOneWeekTime;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/recently/h$b", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            StaggeredGridLayoutManager staggeredGridLayoutManager;
            Integer minOrNull;
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof StaggeredGridLayoutManager) {
                staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
            } else {
                staggeredGridLayoutManager = null;
            }
            if (staggeredGridLayoutManager == null) {
                return;
            }
            int[] intArray = staggeredGridLayoutManager.findFirstVisibleItemPositions(null);
            h hVar = h.this;
            Intrinsics.checkNotNullExpressionValue(intArray, "intArray");
            minOrNull = ArraysKt___ArraysKt.minOrNull(intArray);
            hVar.broadcastMessage("message_recyclerview_scroll", minOrNull);
        }
    }

    public h() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        Intrinsics.checkNotNullExpressionValue(calendar, "getInstance()");
        calendar.setTime(date);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.add(5, 0);
        long j3 = 1000;
        this.mTodayTime = calendar.getTimeInMillis() / j3;
        calendar.add(5, -1);
        this.mYesterdayTime = calendar.getTimeInMillis() / j3;
        calendar.add(5, -7);
        long timeInMillis = calendar.getTimeInMillis() / j3;
        this.mOneWeekTime = timeInMillis;
        QLog.d("TimePart", 4, "TimePart mTodayTime=" + this.mTodayTime + ", mYesterdayTime=" + this.mYesterdayTime + ", mOneWeekTime=" + timeInMillis);
    }

    private final void x9(long time) {
        String str;
        QLog.d("TimePart", 4, "handleTimeShow mTodayTime=" + this.mTodayTime + ", mYesterdayTime=" + this.mYesterdayTime + ", mOneWeekTime=" + this.mOneWeekTime + ", time=" + time);
        TextView textView = this.mTimeView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTimeView");
            textView = null;
        }
        if (time >= this.mTodayTime) {
            str = "\u4eca\u5929";
        } else if (time >= this.mYesterdayTime) {
            str = "\u6628\u5929";
        } else if (time >= this.mOneWeekTime) {
            str = "\u4e00\u5468\u5185";
        } else {
            str = "";
        }
        textView.setText(str);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        super.handleBroadcastMessage(action, args);
        if (Intrinsics.areEqual(action, "message_update_time_show") && (args instanceof Long)) {
            x9(((Number) args).longValue());
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        if (rootView == null) {
            return;
        }
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.wv5);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026ild_recently_viewed_time)");
        this.mTimeView = (TextView) findViewById;
        ((RecyclerView) rootView.findViewById(R.id.uiw)).addOnScrollListener(new b());
    }
}
