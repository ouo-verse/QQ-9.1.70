package com.tencent.robot.profile.setting.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.widget.listitem.QUISettingsRecyclerView;
import com.tencent.robot.profile.setting.RobotSettingData;
import com.tencent.robot.profile.setting.group.RobotSettingC2CPermissionsGroup;
import com.tencent.robot.profile.setting.group.RobotSettingDeleteRobotGroup;
import com.tencent.robot.profile.setting.group.RobotSettingRemoveTroopGroup;
import com.tencent.robot.profile.setting.group.RobotSettingTroopPermissionsGroup;
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

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!\u0012\b\b\u0002\u0010#\u001a\u00020\u0002\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0014J\u0016\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0002R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R$\u0010\u001e\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u001b\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006&"}, d2 = {"Lcom/tencent/robot/profile/setting/view/RobotPermissionsView;", "Lcom/tencent/robot/profile/setting/view/SettingBaseView;", "", "e", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroidx/recyclerview/widget/RecyclerView;", "d", "", "Lt44/a;", "f", "Lcom/tencent/robot/profile/setting/c;", "data", "type", "", "setData", "Lcom/tencent/mobileqq/widget/listitem/QUISettingsRecyclerView;", h.F, "Lcom/tencent/mobileqq/widget/listitem/QUISettingsRecyclerView;", "settingRecyclerView", "i", "I", "permissionsType", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/robot/profile/setting/c;", "settingData", "Lmqq/util/WeakReference;", "", BdhLogUtil.LogTag.Tag_Conn, "Lmqq/util/WeakReference;", "groupList", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotPermissionsView extends SettingBaseView {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private WeakReference<List<t44.a>> groupList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QUISettingsRecyclerView settingRecyclerView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int permissionsType;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private RobotSettingData settingData;

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/robot/profile/setting/view/RobotPermissionsView$a", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "", "onGlobalLayout", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            ViewTreeObserver viewTreeObserver;
            List list;
            int collectionSizeOrDefault;
            WeakReference weakReference = RobotPermissionsView.this.groupList;
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
            QUISettingsRecyclerView qUISettingsRecyclerView = RobotPermissionsView.this.settingRecyclerView;
            if (qUISettingsRecyclerView != null && (viewTreeObserver = qUISettingsRecyclerView.getViewTreeObserver()) != null) {
                viewTreeObserver.removeGlobalOnLayoutListener(this);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RobotPermissionsView(@NotNull Context context) {
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

    @Override // com.tencent.robot.profile.setting.view.SettingBaseView
    @NotNull
    protected List<t44.a> f() {
        ArrayList arrayList = new ArrayList();
        int i3 = this.permissionsType;
        if (i3 != 0) {
            if (i3 == 1) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                arrayList.add(new RobotSettingC2CPermissionsGroup(context, this.settingData));
                Context context2 = getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                arrayList.add(new RobotSettingDeleteRobotGroup(context2, this.settingData));
            }
        } else {
            Context context3 = getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "context");
            arrayList.add(new RobotSettingTroopPermissionsGroup(context3, this.settingData));
            Context context4 = getContext();
            Intrinsics.checkNotNullExpressionValue(context4, "context");
            arrayList.add(new RobotSettingRemoveTroopGroup(context4, this.settingData));
        }
        this.groupList = new WeakReference<>(arrayList);
        return arrayList;
    }

    public final void setData(@NotNull RobotSettingData data, int type) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.settingData = data;
        this.permissionsType = type;
        h();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RobotPermissionsView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ RobotPermissionsView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RobotPermissionsView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.permissionsType = 1;
        this.settingData = new RobotSettingData(null, null, null, 7, null);
    }
}
