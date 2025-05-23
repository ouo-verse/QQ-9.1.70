package p44;

import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.part.block.base.SafeGridLayoutManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotQzoneData;
import com.tencent.robot.profile.data.RobotQZoneInfoData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J*\u0010\r\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0014R\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lp44/d;", "Ln44/f;", "Landroid/view/View;", "containerView", "", "onInitView", "Lcom/tencent/robot/profile/data/g;", "data", "", "position", "", "", "payload", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "e", "Ljava/lang/String;", "TAG", "Landroidx/recyclerview/widget/RecyclerView;", "f", "Landroidx/recyclerview/widget/RecyclerView;", "mediaRv", "Lp44/b;", h.F, "Lp44/b;", "listItemAdapter", "<init>", "()V", "i", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class d extends n44.f {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String TAG = "RobotQZoneMediaListSection";

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private RecyclerView mediaRv;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b listItemAdapter;

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean r(d this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 3) {
                    this$0.getRootView().setPressed(false);
                }
            } else {
                this$0.getRootView().setPressed(false);
                this$0.getRootView().performClick();
            }
        } else {
            this$0.getRootView().setPressed(true);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.z09);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewById(R.id.media_rv)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.mediaRv = recyclerView;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaRv");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(new SafeGridLayoutManager(getRootView().getContext(), 4));
        this.listItemAdapter = new b(new a());
        RecyclerView recyclerView3 = this.mediaRv;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaRv");
            recyclerView3 = null;
        }
        recyclerView3.setAdapter(new RFWConcatAdapter(new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build(), (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) new RecyclerView.Adapter[]{this.listItemAdapter}));
        RecyclerView recyclerView4 = this.mediaRv;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaRv");
        } else {
            recyclerView2 = recyclerView4;
        }
        recyclerView2.setOnTouchListener(new View.OnTouchListener() { // from class: p44.c
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean r16;
                r16 = d.r(d.this, view, motionEvent);
                return r16;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable com.tencent.robot.profile.data.g data, int position, @Nullable List<Object> payload) {
        List list;
        boolean z16 = true;
        if (!(data instanceof RobotQZoneInfoData)) {
            QLog.e(this.TAG, 1, "onBindData data is not RobotQZoneInfoData");
            return;
        }
        b bVar = this.listItemAdapter;
        RecyclerView recyclerView = null;
        if (bVar != null) {
            ArrayList<GroupRobotQzoneData> arrayList = ((RobotQZoneInfoData) data).getQZoneInfo().imageList;
            if (arrayList != null) {
                list = CollectionsKt___CollectionsKt.take(arrayList, 4);
            } else {
                list = null;
            }
            bVar.setItems(list);
        }
        ArrayList<GroupRobotQzoneData> arrayList2 = ((RobotQZoneInfoData) data).getQZoneInfo().imageList;
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            z16 = false;
        }
        if (z16) {
            RecyclerView recyclerView2 = this.mediaRv;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mediaRv");
            } else {
                recyclerView = recyclerView2;
            }
            recyclerView.setVisibility(8);
            return;
        }
        RecyclerView recyclerView3 = this.mediaRv;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaRv");
        } else {
            recyclerView = recyclerView3;
        }
        recyclerView.setVisibility(0);
    }
}
