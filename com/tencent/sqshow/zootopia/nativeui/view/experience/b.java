package com.tencent.sqshow.zootopia.nativeui.view.experience;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import uv4.az;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0013\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001-B%\u0012\u0006\u0010\u001a\u001a\u00020\u0013\u0012\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00110\u001b\u0012\u0006\u0010%\u001a\u00020\u0003\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0003H\u0016J\b\u0010\u0010\u001a\u00020\u0003H\u0016J\u0006\u0010\u0012\u001a\u00020\u0011R\"\u0010\u001a\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R(\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00110\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0014\u0010%\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010$R\u0018\u0010*\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u0006."}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/experience/b;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/sqshow/zootopia/nativeui/view/experience/n;", "", "j0", "Lcom/tencent/sqshow/zootopia/nativeui/view/experience/b$a;", "callback", "", "o0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "n0", "holder", "position", "l0", "getItemCount", "Luv4/az;", "k0", "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "context", "", BdhLogUtil.LogTag.Tag_Conn, "[Luv4/az;", "getExperienceCardList", "()[Luv4/az;", "setExperienceCardList", "([Luv4/az;)V", "experienceCardList", "D", "I", "defaultSelectItemId", "E", "selectedPosition", UserInfo.SEX_FEMALE, "Lcom/tencent/sqshow/zootopia/nativeui/view/experience/b$a;", "itemSelectedCallback", "<init>", "(Landroid/content/Context;[Luv4/az;I)V", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class b extends RecyclerView.Adapter<n> {

    /* renamed from: C, reason: from kotlin metadata */
    private az[] experienceCardList;

    /* renamed from: D, reason: from kotlin metadata */
    private final int defaultSelectItemId;

    /* renamed from: E, reason: from kotlin metadata */
    private int selectedPosition;

    /* renamed from: F, reason: from kotlin metadata */
    private a itemSelectedCallback;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private Context context;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/view/experience/b$a;", "", "", "position", "Luv4/az;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public interface a {
        void a(int position, az item);
    }

    public b(Context context, az[] experienceCardList, int i3) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(experienceCardList, "experienceCardList");
        this.context = context;
        this.experienceCardList = experienceCardList;
        this.defaultSelectItemId = i3;
        this.selectedPosition = j0();
    }

    private final int j0() {
        if (this.defaultSelectItemId < 0) {
            return 0;
        }
        int length = this.experienceCardList.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (this.experienceCardList[i3].f440275b == this.defaultSelectItemId) {
                return i3;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(b this$0, n holder, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(holder, "$holder");
        this$0.selectedPosition = holder.getAdapterPosition();
        this$0.notifyDataSetChanged();
        a aVar = this$0.itemSelectedCallback;
        if (aVar != null) {
            aVar.a(this$0.selectedPosition, this$0.k0());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.experienceCardList.length;
    }

    public final az k0() {
        return this.experienceCardList[this.selectedPosition];
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(final n holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        holder.l(this.experienceCardList[position]);
        holder.getViewBinding().getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.sqshow.zootopia.nativeui.view.experience.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b.m0(b.this, holder, view);
            }
        });
        holder.getViewBinding().f419363g.setSelected(this.selectedPosition == position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public n onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        n74.k g16 = n74.k.g(LayoutInflater.from(this.context));
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(\n               \u2026om(context)\n            )");
        return new n(g16);
    }

    public final void o0(a callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.itemSelectedCallback = callback;
    }
}
