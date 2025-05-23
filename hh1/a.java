package hh1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.discovery.guildblockdetail.newrecommend.GuildRecommendListPart;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqnt.aio.utils.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ0\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fJ \u0010\u0013\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J \u0010\u0014\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016R\u0014\u0010\u0017\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001a\u00a8\u0006 "}, d2 = {"Lhh1/a;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Canvas;", PM.CANVAS, "", HippyTKDListViewAdapter.X, "y", "radius", "", "isBottomCorner", "", "a", "Landroid/content/Context;", "context", "b", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "onDraw", "onDrawOver", "d", UserInfo.SEX_FEMALE, "cornerRadius", "Landroid/graphics/Paint;", "e", "Landroid/graphics/Paint;", "backgroundPaint", "f", "overlayPaint", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a extends RecyclerView.ItemDecoration {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final float cornerRadius = ViewUtils.f352270a.a(8.0f);

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint backgroundPaint = new Paint(1);

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint overlayPaint = new Paint(1);

    private final void a(Canvas canvas, float x16, float y16, float radius, boolean isBottomCorner) {
        Path path = new Path();
        path.moveTo(x16, y16);
        if (isBottomCorner) {
            float f16 = y16 - radius;
            path.lineTo(x16, f16);
            float f17 = x16 - radius;
            path.arcTo(new RectF(f17, f16, x16, y16), 90.0f, -90.0f);
            path.lineTo(f17, y16);
        } else {
            float f18 = x16 - radius;
            path.lineTo(f18, y16);
            float f19 = radius + y16;
            path.arcTo(new RectF(f18, y16, x16, f19), 0.0f, -90.0f);
            path.lineTo(x16, f19);
        }
        path.close();
        canvas.drawPath(path, this.overlayPaint);
    }

    public final void b(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.backgroundPaint.setColor(context.getResources().getColor(R.color.qui_common_bg_middle_standard));
        this.overlayPaint.setColor(context.getResources().getColor(R.color.qui_common_bg_bottom_light));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(@NotNull Canvas canvas, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
        GuildRecommendListPart.CategoryItemAdapter categoryItemAdapter;
        int i3;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        canvas.drawRect(0.0f, 0.0f, parent.getWidth(), parent.getHeight(), this.backgroundPaint);
        RecyclerView.Adapter adapter = parent.getAdapter();
        if (adapter instanceof GuildRecommendListPart.CategoryItemAdapter) {
            categoryItemAdapter = (GuildRecommendListPart.CategoryItemAdapter) adapter;
        } else {
            categoryItemAdapter = null;
        }
        if (categoryItemAdapter != null) {
            i3 = categoryItemAdapter.getSelectedItemPosition();
        } else {
            i3 = -1;
        }
        int childCount = parent.getChildCount();
        for (int i16 = 0; i16 < childCount; i16++) {
            if (parent.getChildAdapterPosition(parent.getChildAt(i16)) == i3) {
                canvas.drawRect(r2.getLeft(), r2.getTop(), r2.getRight(), r2.getBottom(), this.overlayPaint);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(@NotNull Canvas canvas, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
        int i3;
        GuildRecommendListPart.CategoryItemAdapter categoryItemAdapter;
        int i16;
        View view;
        View view2;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        RecyclerView.Adapter adapter = parent.getAdapter();
        if (adapter != null) {
            i3 = adapter.getNUM_BACKGOURND_ICON();
        } else {
            i3 = 0;
        }
        RecyclerView.Adapter adapter2 = parent.getAdapter();
        View view3 = null;
        if (adapter2 instanceof GuildRecommendListPart.CategoryItemAdapter) {
            categoryItemAdapter = (GuildRecommendListPart.CategoryItemAdapter) adapter2;
        } else {
            categoryItemAdapter = null;
        }
        if (categoryItemAdapter != null) {
            i16 = categoryItemAdapter.getSelectedItemPosition();
        } else {
            i16 = -1;
        }
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = parent.findViewHolderForAdapterPosition(i16);
        if (findViewHolderForAdapterPosition != null) {
            view = findViewHolderForAdapterPosition.itemView;
        } else {
            view = null;
        }
        if (view != null) {
            if (i16 > 0) {
                RecyclerView.ViewHolder findViewHolderForAdapterPosition2 = parent.findViewHolderForAdapterPosition(i16 - 1);
                if (findViewHolderForAdapterPosition2 != null) {
                    view2 = findViewHolderForAdapterPosition2.itemView;
                } else {
                    view2 = null;
                }
                if (view2 != null) {
                    a(canvas, view2.getRight(), view2.getBottom(), this.cornerRadius, true);
                }
            }
            if (i16 < i3 - 1) {
                RecyclerView.ViewHolder findViewHolderForAdapterPosition3 = parent.findViewHolderForAdapterPosition(i16 + 1);
                if (findViewHolderForAdapterPosition3 != null) {
                    view3 = findViewHolderForAdapterPosition3.itemView;
                }
                if (view3 != null) {
                    a(canvas, view3.getRight(), view3.getTop(), this.cornerRadius, false);
                }
            } else {
                a(canvas, parent.getWidth(), view.getBottom(), this.cornerRadius, false);
            }
        }
        a(canvas, parent.getWidth(), 0.0f, this.cornerRadius, false);
    }
}
