package n44;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.robot.profile.adapterdelegates.RobotUsagePreviewInnerCardDelegate;
import com.tencent.robot.profile.data.RobotProfileUsagePreviewData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0001\u001e\u0018\u0000 (2\u00020\u0001:\u0005)*+,\u0017B\u0007\u00a2\u0006\u0004\b&\u0010'J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J*\u0010\r\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0014J6\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\u001e\u0010\u0014\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u0011j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u0001`\u0013R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006-"}, d2 = {"Ln44/g;", "Ln44/f;", "Landroid/view/View;", "containerView", "", "onInitView", "Lcom/tencent/robot/profile/data/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "position", "", "", "payload", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, com.tencent.luggage.wxa.c8.c.G, "Landroid/widget/ImageView;", "imageView", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "urlArray", "r", "Lcom/tencent/robot/profile/data/o;", "e", "Lcom/tencent/robot/profile/data/o;", "itemData", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "titleText", "n44/g$f", h.F, "Ln44/g$f;", "clickListener", "Ln44/g$c;", "i", "Ln44/g$c;", "innerAdapter", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "b", "c", "d", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class g extends n44.f {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private RobotProfileUsagePreviewData itemData;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView titleText;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final f clickListener;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c innerAdapter;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u0010"}, d2 = {"Ln44/g$a;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "<init>", "()V", "d", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class a extends RecyclerView.ItemDecoration {

        /* renamed from: e, reason: collision with root package name */
        private static int f418340e = ViewUtils.dip2px(12.0f);

        /* renamed from: f, reason: collision with root package name */
        private static int f418341f = ViewUtils.dip2px(16.0f);

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            int i3;
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            int childAdapterPosition = parent.getChildAdapterPosition(view);
            if (childAdapterPosition == 0) {
                outRect.left = f418341f;
            }
            RecyclerView.Adapter adapter = parent.getAdapter();
            if (adapter != null) {
                i3 = adapter.getItemCount();
            } else {
                i3 = 0;
            }
            if (childAdapterPosition == i3 - 1) {
                outRect.right = f418341f;
            } else {
                outRect.right = f418340e;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0007B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\b"}, d2 = {"Ln44/g$c;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/d;", "Lcom/tencent/robot/profile/data/o$b;", "Ln44/g$d;", "imageClickListener", "<init>", "(Ln44/g$d;)V", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class c extends com.tencent.mobileqq.guild.widget.adapterdelegates.d<RobotProfileUsagePreviewData.RobotUsage> {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Ln44/g$c$a;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/tencent/robot/profile/data/o$b;", "oldItem", "newItem", "", "b", "a", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes25.dex */
        private static final class a extends DiffUtil.ItemCallback<RobotProfileUsagePreviewData.RobotUsage> {
            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public boolean areContentsTheSame(@NotNull RobotProfileUsagePreviewData.RobotUsage oldItem, @NotNull RobotProfileUsagePreviewData.RobotUsage newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                return Intrinsics.areEqual(oldItem, newItem);
            }

            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public boolean areItemsTheSame(@NotNull RobotProfileUsagePreviewData.RobotUsage oldItem, @NotNull RobotProfileUsagePreviewData.RobotUsage newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                if (oldItem == newItem) {
                    return true;
                }
                return false;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NotNull d imageClickListener) {
            super(new a());
            Intrinsics.checkNotNullParameter(imageClickListener, "imageClickListener");
            this.f236209m.c(new RobotUsagePreviewInnerCardDelegate(imageClickListener));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Ln44/g$d;", "", "Landroid/widget/ImageView;", "imageView", "", com.tencent.luggage.wxa.c8.c.G, "", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public interface d {
        void a(@NotNull ImageView imageView, int pos);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"n44/g$f", "Ln44/g$d;", "Landroid/widget/ImageView;", "imageView", "", com.tencent.luggage.wxa.c8.c.G, "", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class f implements d {
        f() {
        }

        @Override // n44.g.d
        public void a(@NotNull ImageView imageView, int pos) {
            Intrinsics.checkNotNullParameter(imageView, "imageView");
            ArrayList<String> arrayList = new ArrayList<>();
            RobotProfileUsagePreviewData robotProfileUsagePreviewData = g.this.itemData;
            if (robotProfileUsagePreviewData == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemData");
                robotProfileUsagePreviewData = null;
            }
            Iterator<T> it = robotProfileUsagePreviewData.i().iterator();
            while (it.hasNext()) {
                arrayList.add(((RobotProfileUsagePreviewData.RobotUsage) it.next()).getUrl());
            }
            g.this.r(pos, imageView, arrayList);
        }
    }

    public g() {
        f fVar = new f();
        this.clickListener = fVar;
        this.innerAdapter = new c(fVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View containerView) {
        View findViewById = getRootView().findViewById(R.id.f7733443);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026_preview_title_text_view)");
        this.titleText = (TextView) findViewById;
        RecyclerView recyclerView = (RecyclerView) getRootView().findViewById(R.id.xvw);
        recyclerView.setAdapter(this.innerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getRootView().getContext(), 0, false));
        recyclerView.setItemAnimator(null);
        recyclerView.addItemDecoration(new a());
        recyclerView.addOnItemTouchListener(new e());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable com.tencent.robot.profile.data.g item, int position, @Nullable List<Object> payload) {
        boolean z16;
        Intrinsics.checkNotNull(item, "null cannot be cast to non-null type com.tencent.robot.profile.data.RobotProfileUsagePreviewData");
        RobotProfileUsagePreviewData robotProfileUsagePreviewData = (RobotProfileUsagePreviewData) item;
        this.itemData = robotProfileUsagePreviewData;
        this.innerAdapter.setItems(robotProfileUsagePreviewData.i());
        getRootView().setBackgroundColor(getRootView().getContext().getColor(R.color.qui_common_bg_bottom_light));
        TextView textView = this.titleText;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleText");
            textView = null;
        }
        textView.setTextColor(getRootView().getContext().getColor(R.color.qui_common_text_primary));
        TextView textView3 = this.titleText;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleText");
        } else {
            textView2 = textView3;
        }
        String title = robotProfileUsagePreviewData.getTitle();
        if (title.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            title = getRootView().getContext().getString(R.string.f222646e3);
            Intrinsics.checkNotNullExpressionValue(title, "rootView.context.getStri\u2026obot_preview_image_title)");
        }
        textView2.setText(title);
    }

    public final void r(int pos, @NotNull ImageView imageView, @Nullable ArrayList<String> urlArray) {
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putInt("index", pos);
        bundle.putStringArrayList(TroopAvatarWallPreviewActivity.KEY_SEQ_NUM, urlArray);
        bundle.putBoolean("from_photo_wall", true);
        bundle.putBoolean("SHOW_MENU", false);
        bundle.putBoolean("IS_EDIT", false);
        bundle.putBoolean("is_use_path", true);
        bundle.putBoolean("is_show_action", true);
        bundle.putBoolean(TroopAvatarWallPreviewActivity.KEY_IS_NOT_SHOW_INDEX, true);
        int[] iArr = new int[2];
        imageView.getLocationOnScreen(iArr);
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.valueOf(iArr[0]));
        arrayList.add(Integer.valueOf(iArr[1]));
        arrayList.add(Integer.valueOf(imageView.getWidth()));
        arrayList.add(Integer.valueOf(imageView.getHeight()));
        bundle.putIntegerArrayList("mPreviewPhotoLocation", arrayList);
        intent.putExtras(bundle);
        RouteUtils.startActivity(imageView.getContext(), intent, RouterConstants.UI_ROUTE_OPEN_TROOP_AVATAR_WALL_PREVIEW_ACTIVITY);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016R\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Ln44/g$e;", "Landroidx/recyclerview/widget/RecyclerView$OnItemTouchListener;", "Landroid/view/MotionEvent;", "e", "", "a", "Landroidx/recyclerview/widget/RecyclerView;", "rv", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "", "onTouchEvent", "disallowIntercept", "onRequestDisallowInterceptTouchEvent", "", "d", UserInfo.SEX_FEMALE, "mLastDownX", "mLastDownY", "<init>", "()V", "f", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class e implements RecyclerView.OnItemTouchListener {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private float mLastDownX;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private float mLastDownY;

        private final boolean a(MotionEvent e16) {
            if (Math.abs(this.mLastDownX - e16.getX()) > Math.abs(this.mLastDownY - e16.getY())) {
                return true;
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(@NotNull RecyclerView rv5, @NotNull MotionEvent e16) {
            Intrinsics.checkNotNullParameter(rv5, "rv");
            Intrinsics.checkNotNullParameter(e16, "e");
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("RecyclerViewItemTouchListener", "onInterceptTouchEvent e=" + e16);
            }
            int action = e16.getAction();
            if (action != 0) {
                if (action != 2) {
                    if (action == 3) {
                        rv5.getParent().requestDisallowInterceptTouchEvent(true);
                    }
                } else if (a(e16)) {
                    rv5.getParent().requestDisallowInterceptTouchEvent(true);
                } else {
                    rv5.getParent().requestDisallowInterceptTouchEvent(false);
                }
            } else {
                this.mLastDownX = e16.getX();
                this.mLastDownY = e16.getY();
                rv5.getParent().requestDisallowInterceptTouchEvent(true);
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(@NotNull RecyclerView rv5, @NotNull MotionEvent e16) {
            Intrinsics.checkNotNullParameter(rv5, "rv");
            Intrinsics.checkNotNullParameter(e16, "e");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        }
    }
}
