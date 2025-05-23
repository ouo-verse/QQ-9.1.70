package ep0;

import androidx.recyclerview.widget.DiffUtil;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.guild.aio.input.at.trooptag.dialogui.delegate.BottomDecorationDelegate;
import com.tencent.guild.aio.input.at.trooptag.dialogui.delegate.EmptyPageAdapterDelegate;
import com.tencent.guild.aio.input.at.trooptag.dialogui.delegate.HashTagChannelItemDelegate;
import com.tencent.guild.aio.input.at.trooptag.dialogui.delegate.HashTagGroupAdapterDelegate;
import com.tencent.guild.aio.input.at.trooptag.dialogui.delegate.HashTagInActiveTrooplItemDelegate;
import com.tencent.guild.aio.input.at.trooptag.dialogui.delegate.HashTagLoadingDelegate;
import com.tencent.guild.aio.input.at.trooptag.dialogui.delegate.HashTagTroopItemDelegate;
import com.tencent.mobileqq.guild.widget.adapterdelegates.d;
import com.tencent.mobileqq.guild.widget.adapterdelegates.h;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.widget.listitem.QUIListItemBackgroundType;
import cp0.HashTagChannelData;
import cp0.HashTagGroupType;
import cp0.HashTagTroopData;
import cp0.HashTagTroopInActiveData;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0001\u001dB\u0017\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\u0005H\u0016J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fH\u0016R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lep0/b;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/d;", "Lcp0/a;", "Lip0/a;", "Lip0/b;", "", "k0", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/mobileqq/widget/listitem/QUIListItemBackgroundType;", "b", "data", "O", "itemData", "U", "i", "Lcp0/g;", "type", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/guild/aio/input/at/trooptag/model/a;", "I", "Lcom/tencent/guild/aio/input/at/trooptag/model/a;", "troopTabModel", "Lfp0/b;", "J", "Lfp0/b;", "panelStyle", "<init>", "(Lcom/tencent/guild/aio/input/at/trooptag/model/a;Lfp0/b;)V", "K", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class b extends d<cp0.a> implements ip0.a, ip0.b {

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.guild.aio.input.at.trooptag.model.a troopTabModel;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final fp0.b panelStyle;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002\u00a8\u0006\u0007"}, d2 = {"Lep0/b$a;", "", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcp0/a;", "b", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ep0.b$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u001a\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"ep0/b$a$a", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcp0/a;", "oldItem", "newItem", "", "b", "a", "", "c", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: ep0.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static final class C10256a extends DiffUtil.ItemCallback<cp0.a> {
            C10256a() {
            }

            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public boolean areContentsTheSame(@NotNull cp0.a oldItem, @NotNull cp0.a newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                return oldItem.a(newItem);
            }

            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public boolean areItemsTheSame(@NotNull cp0.a oldItem, @NotNull cp0.a newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                return oldItem.b(newItem);
            }

            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            @Nullable
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public Object getChangePayload(@NotNull cp0.a oldItem, @NotNull cp0.a newItem) {
                Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                Intrinsics.checkNotNullParameter(newItem, "newItem");
                return oldItem.c(newItem);
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final DiffUtil.ItemCallback<cp0.a> b() {
            return new C10256a();
        }

        Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull com.tencent.guild.aio.input.at.trooptag.model.a troopTabModel, @NotNull fp0.b panelStyle) {
        super(INSTANCE.b(), new h());
        Intrinsics.checkNotNullParameter(troopTabModel, "troopTabModel");
        Intrinsics.checkNotNullParameter(panelStyle, "panelStyle");
        this.troopTabModel = troopTabModel;
        this.panelStyle = panelStyle;
        this.f236209m.c(new HashTagLoadingDelegate()).c(new EmptyPageAdapterDelegate()).c(new HashTagGroupAdapterDelegate(this)).c(new HashTagChannelItemDelegate(this)).c(new HashTagInActiveTrooplItemDelegate(this)).c(new HashTagTroopItemDelegate(this)).c(new BottomDecorationDelegate());
        troopTabModel.a(this);
    }

    private final void k0() {
        List mutableList;
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) this.troopTabModel.e());
        setItems(mutableList);
    }

    @Override // ip0.a
    public void O(@NotNull cp0.a data) {
        boolean z16;
        Intrinsics.checkNotNullParameter(data, "data");
        if (data instanceof HashTagTroopInActiveData) {
            this.troopTabModel.b((HashTagTroopInActiveData) data);
            return;
        }
        if (data instanceof HashTagTroopData) {
            z16 = true;
        } else {
            z16 = data instanceof HashTagChannelData;
        }
        if (z16) {
            this.troopTabModel.k(data);
        }
    }

    @Override // ip0.b
    public void U(@NotNull cp0.a itemData) {
        Intrinsics.checkNotNullParameter(itemData, "itemData");
    }

    @Override // ip0.a
    @NotNull
    public QUIListItemBackgroundType b(@NotNull cp0.a item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return this.troopTabModel.f(item);
    }

    @Override // ip0.b
    public void i() {
        k0();
    }

    @Override // ip0.a
    public void z(@NotNull HashTagGroupType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.troopTabModel.l(type);
    }
}
