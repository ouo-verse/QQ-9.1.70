package com.tencent.robot.profile.adapterdelegates;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.biz.richframework.part.adapter.section.SectionViewHolder;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqnt.kernel.nativeinterface.RobotStatus;
import com.tencent.robot.profile.data.RobotProfileOfflineData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b%\u0010&J&\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0014J\b\u0010\n\u001a\u00020\u0006H\u0016J4\u0010\u0013\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u001a\u0010\u0011\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00020\u00100\u000f0\u0004H\u0016J2\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u00142\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0004H\u0014R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006'"}, d2 = {"Lcom/tencent/robot/profile/adapterdelegates/f;", "Lcom/tencent/robot/profile/adapterdelegates/g;", "Lcom/tencent/robot/profile/data/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", "b", "getLayoutId", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "itemView", "Ljava/lang/Class;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "sections", "", "initSection", "Lcom/tencent/biz/richframework/part/adapter/section/SectionViewHolder;", "holder", "", "payloads", "c", "Landroid/widget/FrameLayout;", "d", "Landroid/widget/FrameLayout;", "offlineIconContainer", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "offlineTv", "Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "f", "Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "robotEmptyIcon", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class f extends g {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private FrameLayout offlineIconContainer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView offlineTv;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private QUIEmptyState robotEmptyIcon;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f367846a;

        static {
            int[] iArr = new int[RobotStatus.values().length];
            try {
                iArr[RobotStatus.KOFFLINE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RobotStatus.KDELETED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RobotStatus.KBANNED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f367846a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean isForViewType(@NotNull com.tencent.robot.profile.data.g item, @NotNull List<com.tencent.robot.profile.data.g> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return item instanceof RobotProfileOfflineData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder2(@NotNull com.tencent.robot.profile.data.g item, @NotNull SectionViewHolder<?> holder, int position, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.onBindViewHolder2((f) item, (SectionViewHolder) holder, position, payloads);
        RobotProfileOfflineData robotProfileOfflineData = (RobotProfileOfflineData) item;
        Context context = holder.itemView.getContext();
        holder.itemView.setBackgroundColor(context.getColor(R.color.qui_common_bg_bottom_light));
        TextView textView = this.offlineTv;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("offlineTv");
            textView = null;
        }
        textView.setTextColor(context.getColor(R.color.qui_common_text_primary));
        QUIEmptyState qUIEmptyState = this.robotEmptyIcon;
        if (qUIEmptyState == null) {
            Intrinsics.throwUninitializedPropertyAccessException("robotEmptyIcon");
            qUIEmptyState = null;
        }
        qUIEmptyState.setImageView(14);
        if (robotProfileOfflineData.getIsOffline()) {
            int i3 = a.f367846a[robotProfileOfflineData.getRobotStatus().ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        TextView textView3 = this.offlineTv;
                        if (textView3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("offlineTv");
                        } else {
                            textView2 = textView3;
                        }
                        textView2.setText(HardCodeUtil.qqStr(R.string.f222746ec));
                        return;
                    }
                    TextView textView4 = this.offlineTv;
                    if (textView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("offlineTv");
                    } else {
                        textView2 = textView4;
                    }
                    textView2.setText(HardCodeUtil.qqStr(R.string.f222746ec));
                    return;
                }
                TextView textView5 = this.offlineTv;
                if (textView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("offlineTv");
                } else {
                    textView2 = textView5;
                }
                textView2.setText(HardCodeUtil.qqStr(R.string.f222756ed));
                return;
            }
            TextView textView6 = this.offlineTv;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("offlineTv");
            } else {
                textView2 = textView6;
            }
            textView2.setText(HardCodeUtil.qqStr(R.string.f222736eb));
            return;
        }
        if (robotProfileOfflineData.getIsEmpty()) {
            TextView textView7 = this.offlineTv;
            if (textView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("offlineTv");
            } else {
                textView2 = textView7;
            }
            textView2.setText(HardCodeUtil.qqStr(R.string.f222766ee));
        }
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public int getLayoutId() {
        return R.layout.hoj;
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public void initSection(@NotNull ViewGroup parent, @NotNull View itemView, @NotNull List<Class<? extends Section<com.tencent.robot.profile.data.g>>> sections) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(sections, "sections");
        Context context = itemView.getContext();
        View findViewById = itemView.findViewById(R.id.zwh);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.offline_icon_container)");
        this.offlineIconContainer = (FrameLayout) findViewById;
        View findViewById2 = itemView.findViewById(R.id.zwi);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.offline_tv)");
        this.offlineTv = (TextView) findViewById2;
        this.robotEmptyIcon = new QUIEmptyState.Builder(context).setThemeType(0).setImageType(14).setBackgroundColorType(0).setHalfScreenState(true).build();
        FrameLayout frameLayout = this.offlineIconContainer;
        QUIEmptyState qUIEmptyState = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("offlineIconContainer");
            frameLayout = null;
        }
        QUIEmptyState qUIEmptyState2 = this.robotEmptyIcon;
        if (qUIEmptyState2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("robotEmptyIcon");
        } else {
            qUIEmptyState = qUIEmptyState2;
        }
        frameLayout.addView(qUIEmptyState);
    }
}
