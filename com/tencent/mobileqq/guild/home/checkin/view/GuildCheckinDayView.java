package com.tencent.mobileqq.guild.home.checkin.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import vo1.DayData;
import vo1.LineData;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J(\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0014R\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0010\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/guild/home/checkin/view/GuildCheckinDayView;", "Landroidx/recyclerview/widget/RecyclerView;", "", UserInfo.SEX_FEMALE, "", "checkinDay", "E", "w", h.F, "oldw", "oldh", MosaicConstants$JsFunction.FUNC_ON_SIZE_CHANGED, "Lcom/tencent/mobileqq/guild/home/checkin/view/a;", "f", "Lcom/tencent/mobileqq/guild/home/checkin/view/a;", "dataAdapter", "I", "i", "lineLengthPx", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildCheckinDayView extends RecyclerView {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.guild.home.checkin.view.a dataAdapter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int checkinDay;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int lineLengthPx;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/guild/home/checkin/view/GuildCheckinDayView$a", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a extends RecyclerView.ItemDecoration {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            if (parent.getChildLayoutPosition(view) % 2 == 0) {
                outRect.left = ScreenUtil.dip2px(-5.0f);
                outRect.right = ScreenUtil.dip2px(-5.0f);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildCheckinDayView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void F() {
        if (this.checkinDay > 0 && this.lineLengthPx > 0) {
            ArrayList arrayList = new ArrayList();
            if (this.checkinDay <= 5) {
                arrayList.add(new DayData(1, true));
                int i3 = this.checkinDay - 1;
                for (int i16 = 0; i16 < i3; i16++) {
                    arrayList.add(new LineData(false, this.lineLengthPx));
                    arrayList.add(new DayData(i16 + 2, true));
                }
                int i17 = 7 - this.checkinDay;
                for (int i18 = 0; i18 < i17; i18++) {
                    arrayList.add(new LineData(false, this.lineLengthPx));
                    arrayList.add(new DayData(this.checkinDay + i18 + 1, false));
                }
            } else {
                arrayList.add(new DayData(1, true));
                for (int i19 = 0; i19 < 3; i19++) {
                    arrayList.add(new LineData(false, this.lineLengthPx));
                    arrayList.add(new DayData(i19 + 2, true));
                }
                arrayList.add(new LineData(true, this.lineLengthPx));
                arrayList.add(new DayData(this.checkinDay, true));
                for (int i26 = 0; i26 < 2; i26++) {
                    arrayList.add(new LineData(false, this.lineLengthPx));
                    arrayList.add(new DayData(this.checkinDay + i26 + 1, false));
                }
            }
            this.dataAdapter.setItems(arrayList);
            return;
        }
        Logger.f235387a.d().w("GuildCheckinDayView", 1, "updateView invalid: checkinDay=" + this.checkinDay + ", lineLengthPx=" + this.lineLengthPx);
    }

    public final void E(int checkinDay) {
        this.checkinDay = checkinDay;
        this.lineLengthPx = ConnectingLineAdapterDelegate.INSTANCE.a(getWidth());
        F();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onSizeChanged(int w3, int h16, int oldw, int oldh) {
        super.onSizeChanged(w3, h16, oldw, oldh);
        int a16 = ConnectingLineAdapterDelegate.INSTANCE.a(w3);
        if (this.lineLengthPx != a16) {
            this.lineLengthPx = a16;
            F();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildCheckinDayView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GuildCheckinDayView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildCheckinDayView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.checkinDay = -1;
        setOverScrollMode(2);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(0);
        setLayoutManager(linearLayoutManager);
        com.tencent.mobileqq.guild.home.checkin.view.a aVar = new com.tencent.mobileqq.guild.home.checkin.view.a();
        this.dataAdapter = aVar;
        setAdapter(aVar);
        addItemDecoration(new a());
    }
}
