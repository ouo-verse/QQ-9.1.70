package com.tencent.robot.profile.setting.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.widget.listitem.QUISettingsRecyclerView;
import com.tencent.robot.profile.setting.RobotSettingData;
import com.tencent.robot.profile.setting.group.RobotSettingAccountGroup;
import com.tencent.robot.profile.setting.group.RobotSettingC2CPermissionsGroup;
import com.tencent.robot.profile.setting.group.RobotSettingDeleteRobotGroup;
import com.tencent.robot.profile.setting.group.o;
import com.tencent.robot.profile.setting.group.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0002\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0014J\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R$\u0010\u001a\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u0017\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\""}, d2 = {"Lcom/tencent/robot/profile/setting/view/RobotSettingView;", "Lcom/tencent/robot/profile/setting/view/SettingBaseView;", "", "e", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroidx/recyclerview/widget/RecyclerView;", "d", "", "Lt44/a;", "f", "Lcom/tencent/robot/profile/setting/c;", "data", "", "setData", "Lcom/tencent/mobileqq/widget/listitem/QUISettingsRecyclerView;", h.F, "Lcom/tencent/mobileqq/widget/listitem/QUISettingsRecyclerView;", "settingRecyclerView", "i", "Lcom/tencent/robot/profile/setting/c;", "settingData", "Lmqq/util/WeakReference;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lmqq/util/WeakReference;", "groupList", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotSettingView extends SettingBaseView {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QUISettingsRecyclerView settingRecyclerView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private RobotSettingData settingData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WeakReference<List<t44.a>> groupList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/robot/profile/setting/view/RobotSettingView$a", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "", "onGlobalLayout", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            ViewTreeObserver viewTreeObserver;
            List list;
            int collectionSizeOrDefault;
            WeakReference weakReference = RobotSettingView.this.groupList;
            if (weakReference != null && (list = (List) weakReference.get()) != null) {
                List list2 = list;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                Iterator it = list2.iterator();
                while (it.hasNext()) {
                    ((t44.a) it.next()).e();
                    arrayList.add(Unit.INSTANCE);
                }
            }
            QUISettingsRecyclerView qUISettingsRecyclerView = RobotSettingView.this.settingRecyclerView;
            if (qUISettingsRecyclerView != null && (viewTreeObserver = qUISettingsRecyclerView.getViewTreeObserver()) != null) {
                viewTreeObserver.removeGlobalOnLayoutListener(this);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RobotSettingView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.tencent.robot.profile.setting.view.SettingBaseView
    @Nullable
    protected RecyclerView d(@Nullable View rootView) {
        ViewTreeObserver viewTreeObserver;
        if (rootView == null) {
            return null;
        }
        QUISettingsRecyclerView qUISettingsRecyclerView = (QUISettingsRecyclerView) rootView.findViewById(R.id.f83824kl);
        this.settingRecyclerView = qUISettingsRecyclerView;
        if (qUISettingsRecyclerView != null && (viewTreeObserver = qUISettingsRecyclerView.getViewTreeObserver()) != null) {
            viewTreeObserver.addOnGlobalLayoutListener(new a());
        }
        return qUISettingsRecyclerView;
    }

    @Override // com.tencent.robot.profile.setting.view.SettingBaseView
    protected int e() {
        return R.layout.hp9;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x006d  */
    @Override // com.tencent.robot.profile.setting.view.SettingBaseView
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected List<t44.a> f() {
        boolean z16;
        ArrayList arrayList = new ArrayList();
        if (this.settingData.g()) {
            if (this.settingData.f() && (this.settingData.h() || this.settingData.getProfile().isFriend)) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                arrayList.add(new o(context, this.settingData));
            }
        } else if (this.settingData.getProfile().isFriend) {
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            arrayList.add(new RobotSettingC2CPermissionsGroup(context2, this.settingData));
            z16 = true;
            Context context3 = getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "context");
            arrayList.add(new RobotSettingAccountGroup(context3, this.settingData));
            if (z16) {
                Context context4 = getContext();
                Intrinsics.checkNotNullExpressionValue(context4, "context");
                arrayList.add(new RobotSettingDeleteRobotGroup(context4, this.settingData));
            }
            Context context5 = getContext();
            Intrinsics.checkNotNullExpressionValue(context5, "context");
            arrayList.add(new t(context5, this.settingData));
            this.groupList = new WeakReference<>(arrayList);
            return arrayList;
        }
        z16 = false;
        Context context32 = getContext();
        Intrinsics.checkNotNullExpressionValue(context32, "context");
        arrayList.add(new RobotSettingAccountGroup(context32, this.settingData));
        if (z16) {
        }
        Context context52 = getContext();
        Intrinsics.checkNotNullExpressionValue(context52, "context");
        arrayList.add(new t(context52, this.settingData));
        this.groupList = new WeakReference<>(arrayList);
        return arrayList;
    }

    public final void setData(@NotNull RobotSettingData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.settingData = data;
        h();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RobotSettingView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ RobotSettingView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RobotSettingView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.settingData = new RobotSettingData(null, null, null, 7, null);
    }
}
