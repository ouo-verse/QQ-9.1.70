package com.tencent.robot.profile.setting.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.QUIListItemStyle;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t44.a;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\b\u0001\u0010 \u001a\u00020\u001f\u00a2\u0006\u0004\b!\u0010\"B\u001f\b\u0016\u0012\b\b\u0001\u0010 \u001a\u00020\u001f\u0012\n\b\u0001\u0010$\u001a\u0004\u0018\u00010#\u00a2\u0006\u0004\b!\u0010%B'\b\u0016\u0012\b\b\u0001\u0010 \u001a\u00020\u001f\u0012\n\b\u0001\u0010$\u001a\u0004\u0018\u00010#\u0012\u0006\u0010&\u001a\u00020\u000f\u00a2\u0006\u0004\b!\u0010'J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0017\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\b\u001a\u00020\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0004J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH$J\b\u0010\u0010\u001a\u00020\u000fH$J\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\n\u001a\u0004\u0018\u00010\tH$R\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0014R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006("}, d2 = {"Lcom/tencent/robot/profile/setting/view/SettingBaseView;", "Landroid/widget/FrameLayout;", "", "g", "", "Lcom/tencent/mobileqq/widget/listitem/Group;", "c", "()[Lcom/tencent/mobileqq/widget/listitem/Group;", h.F, "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "a", "", "Lt44/a;", "f", "", "e", "Landroidx/recyclerview/widget/RecyclerView;", "d", "", "Ljava/lang/String;", "TAG", "Ljava/util/List;", "mGroupsList", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "mQUIListItemAdapter", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemStyle;", "b", "()Lcom/tencent/mobileqq/widget/listitem/QUIListItemStyle;", "adapterItemStyle", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public abstract class SettingBaseView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<a> mGroupsList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private QUIListItemAdapter mQUIListItemAdapter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingBaseView(@NonNull @NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.TAG = "RobotSettingBaseView";
        this.mGroupsList = new ArrayList();
        g();
    }

    private final Group[] c() {
        Object[] requireNoNulls;
        List<a> f16 = f();
        this.mGroupsList = f16;
        if (f16.isEmpty()) {
            QLog.e(this.TAG, 1, "[getListItemGroup] mGroupsList == null || mGroupsList.isEmpty().");
            return null;
        }
        int size = this.mGroupsList.size();
        Group[] groupArr = new Group[size];
        for (int i3 = 0; i3 < size; i3++) {
            a aVar = this.mGroupsList.get(i3);
            QUIListItemAdapter qUIListItemAdapter = this.mQUIListItemAdapter;
            if (qUIListItemAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mQUIListItemAdapter");
                qUIListItemAdapter = null;
            }
            groupArr[i3] = aVar.b(qUIListItemAdapter);
        }
        requireNoNulls = ArraysKt___ArraysKt.requireNoNulls(groupArr);
        return (Group[]) requireNoNulls;
    }

    private final void g() {
        LayoutInflater.from(getContext()).inflate(e(), (ViewGroup) this, true);
        RecyclerView d16 = d(this);
        this.mQUIListItemAdapter = new QUIListItemAdapter(b(), false, false, 6, null);
        if (d16 != null) {
            d16.setVerticalScrollBarEnabled(false);
        }
        if (d16 != null) {
            d16.setPadding(0, 0, 0, 0);
        }
        if (d16 != null) {
            QUIListItemAdapter qUIListItemAdapter = this.mQUIListItemAdapter;
            if (qUIListItemAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mQUIListItemAdapter");
                qUIListItemAdapter = null;
            }
            d16.setAdapter(qUIListItemAdapter);
        }
        a(this);
    }

    protected final void a(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
    }

    @NotNull
    protected final QUIListItemStyle b() {
        return QUIListItemStyle.Card;
    }

    @Nullable
    protected abstract RecyclerView d(@Nullable View rootView);

    protected abstract int e();

    @NotNull
    protected abstract List<a> f();

    public final void h() {
        boolean z16;
        if (this.mQUIListItemAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mQUIListItemAdapter");
        }
        Group[] c16 = c();
        if (c16 != null) {
            if (c16.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                QUIListItemAdapter qUIListItemAdapter = this.mQUIListItemAdapter;
                if (qUIListItemAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mQUIListItemAdapter");
                    qUIListItemAdapter = null;
                }
                qUIListItemAdapter.t0((Group[]) Arrays.copyOf(c16, c16.length));
                return;
            }
        }
        QLog.e(this.TAG, 1, "[updateConfigItems] listItemGroups == null || listItemGroups.isEmpty.");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingBaseView(@NonNull @NotNull Context context, @androidx.annotation.Nullable @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.TAG = "RobotSettingBaseView";
        this.mGroupsList = new ArrayList();
        g();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingBaseView(@NonNull @NotNull Context context, @androidx.annotation.Nullable @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.TAG = "RobotSettingBaseView";
        this.mGroupsList = new ArrayList();
        g();
    }
}
