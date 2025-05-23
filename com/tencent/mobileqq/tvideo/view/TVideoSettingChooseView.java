package com.tencent.mobileqq.tvideo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0016\u0018\u0000 \"2\u00020\u0001:\u0002\n\u0014B1\b\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001d\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001d\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006R$\u0010\u000e\u001a\u0004\u0018\u00010\u00018\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR2\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u00118\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/tvideo/view/TVideoSettingChooseView;", "Landroid/widget/LinearLayout;", "", "c", "", "d", "Lcom/tencent/mobileqq/tvideo/view/TVideoSettingChooseView$b;", "listener", "setOnItemClickListener", "Landroid/widget/LinearLayout;", "a", "()Landroid/widget/LinearLayout;", "setItemContainerView", "(Landroid/widget/LinearLayout;)V", "itemContainerView", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/tvideo/view/TVideoSettingChooseItemView;", "Lkotlin/collections/ArrayList;", "e", "Ljava/util/ArrayList;", "b", "()Ljava/util/ArrayList;", "setItemViewList", "(Ljava/util/ArrayList;)V", "itemViewList", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "f", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public class TVideoSettingChooseView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LinearLayout itemContainerView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<TVideoSettingChooseItemView> itemViewList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/mobileqq/tvideo/view/TVideoSettingChooseView$b;", "", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public interface b {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TVideoSettingChooseView(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: a, reason: from getter */
    public final LinearLayout getItemContainerView() {
        return this.itemContainerView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final ArrayList<TVideoSettingChooseItemView> b() {
        return this.itemViewList;
    }

    @NotNull
    protected String c() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
        LayoutInflater.from(getContext()).inflate(R.layout.gha, (ViewGroup) this, true);
        this.itemContainerView = (LinearLayout) findViewById(R.id.dpq);
        ((TextView) findViewById(R.id.title)).setText(c());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TVideoSettingChooseView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TVideoSettingChooseView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ TVideoSettingChooseView(Context context, AttributeSet attributeSet, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i17 & 2) != 0 ? null : attributeSet, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? 0 : i16);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TVideoSettingChooseView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Intrinsics.checkNotNullParameter(context, "context");
        this.itemViewList = new ArrayList<>();
    }

    public final void setOnItemClickListener(@Nullable b listener) {
    }
}
