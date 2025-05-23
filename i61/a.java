package i61;

import androidx.recyclerview.widget.DiffUtil;
import com.tencent.biz.richframework.part.adapter.AsyncListDifferDelegationAdapter;
import com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegatesManager;
import com.tencent.mobileqq.activity.aio.intimate.reborn.itemdelegate.h;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import j61.IntimateBaseModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\t\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\b\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Li61/a;", "Lcom/tencent/biz/richframework/part/adapter/AsyncListDifferDelegationAdapter;", "Lj61/a;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "getBusinessTag", "()Ljava/lang/String;", "businessTag", "Lcom/tencent/mobileqq/activity/aio/intimate/reborn/itemdelegate/h;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/activity/aio/intimate/reborn/itemdelegate/h;", "i0", "()Lcom/tencent/mobileqq/activity/aio/intimate/reborn/itemdelegate/h;", "itemDelegate", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/activity/aio/intimate/reborn/itemdelegate/h;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public abstract class a extends AsyncListDifferDelegationAdapter<IntimateBaseModel> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final h itemDelegate;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String businessTag;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"i61/a$a", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lj61/a;", "oldItem", "newItem", "", "b", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: i61.a$a, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static final class C10508a extends DiffUtil.ItemCallback<IntimateBaseModel> {
        C10508a() {
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(@NotNull IntimateBaseModel oldItem, @NotNull IntimateBaseModel newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return false;
        }

        @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(@NotNull IntimateBaseModel oldItem, @NotNull IntimateBaseModel newItem) {
            Intrinsics.checkNotNullParameter(oldItem, "oldItem");
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            return false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001\u00a8\u0006\u0004"}, d2 = {"i61/a$b", "Lcom/tencent/biz/richframework/part/adapter/delegate/AdapterDelegatesManager;", "", "Lj61/a;", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b extends AdapterDelegatesManager<List<? extends IntimateBaseModel>> {
        b(h hVar) {
            addDelegate(hVar);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull String businessTag, @NotNull h itemDelegate) {
        super(new C10508a(), new b(itemDelegate));
        Intrinsics.checkNotNullParameter(businessTag, "businessTag");
        Intrinsics.checkNotNullParameter(itemDelegate, "itemDelegate");
        this.businessTag = businessTag;
        this.itemDelegate = itemDelegate;
    }

    @NotNull
    /* renamed from: i0, reason: from getter */
    public final h getItemDelegate() {
        return this.itemDelegate;
    }
}
