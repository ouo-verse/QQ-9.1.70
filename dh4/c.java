package dh4;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.timi.game.emo.ui.panel.sys.EmoPicView;
import com.tencent.timi.game.emo.ui.panel.sys.TitleView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import xg4.m;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 22\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00013B'\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u0012\u0006\u0010\u001e\u001a\u00020\u0003\u0012\u0006\u0010$\u001a\u00020\u001f\u0012\u0006\u0010*\u001a\u00020%\u00a2\u0006\u0004\b0\u00101J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0014\u0010\u000b\u001a\u00020\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0018\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0003H\u0016J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H\u0016R\u0017\u0010\u0019\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001e\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010$\u001a\u00020\u001f8\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010*\u001a\u00020%8\u0006\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R$\u0010/\u001a\u0012\u0012\u0004\u0012\u00020\b0+j\b\u0012\u0004\u0012\u00020\b`,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.\u00a8\u00064"}, d2 = {"Ldh4/c;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "", "viewType", "Landroid/view/View;", "i0", "", "Lcom/tencent/mobileqq/emoticonview/SystemAndEmojiEmoticonInfo;", "data", "", "refresh", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "onCreateViewHolder", "holder", "position", "onBindViewHolder", "getItemCount", "getItemViewType", "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", BdhLogUtil.LogTag.Tag_Conn, "I", "getColumnNum", "()I", "columnNum", "Lxg4/m;", "D", "Lxg4/m;", "getParam", "()Lxg4/m;", "param", "Lxg4/a;", "E", "Lxg4/a;", "getPanelItemData", "()Lxg4/a;", "panelItemData", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", UserInfo.SEX_FEMALE, "Ljava/util/ArrayList;", "mDataList", "<init>", "(Landroid/content/Context;ILxg4/m;Lxg4/a;)V", "G", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class c extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: C, reason: from kotlin metadata */
    private final int columnNum;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final m param;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final xg4.a panelItemData;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final ArrayList<SystemAndEmojiEmoticonInfo> mDataList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"dh4/c$b", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b extends RecyclerView.ViewHolder {
        b(View view) {
            super(view);
        }
    }

    public c(@NotNull Context context, int i3, @NotNull m param, @NotNull xg4.a panelItemData) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(panelItemData, "panelItemData");
        this.context = context;
        this.columnNum = i3;
        this.param = param;
        this.panelItemData = panelItemData;
        this.mDataList = new ArrayList<>();
    }

    private final View i0(int viewType) {
        if (viewType != 1) {
            if (viewType != 2) {
                return new View(this.context);
            }
            return new EmoPicView(this.context, null, 0, this.columnNum, this.param, this.panelItemData, 6, null);
        }
        return new TitleView(this.context, null, 0, this.columnNum, 6, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        if (this.mDataList.size() % this.columnNum == 0) {
            return this.mDataList.size() / this.columnNum;
        }
        return (this.mDataList.size() / this.columnNum) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo = this.mDataList.get(position * this.columnNum);
        Intrinsics.checkNotNullExpressionValue(systemAndEmojiEmoticonInfo, "mDataList[lineFirstIndex]");
        if (systemAndEmojiEmoticonInfo.emotionType == 3) {
            return 1;
        }
        return 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder holder, int position) {
        dh4.b bVar;
        Intrinsics.checkNotNullParameter(holder, "holder");
        KeyEvent.Callback callback = holder.itemView;
        if (callback instanceof dh4.b) {
            bVar = (dh4.b) callback;
        } else {
            bVar = null;
        }
        if (bVar != null) {
            bVar.a(position, this.mDataList);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return new b(i0(viewType));
    }

    public final void refresh(@NotNull List<? extends SystemAndEmojiEmoticonInfo> data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.mDataList.clear();
        this.mDataList.addAll(data);
        notifyDataSetChanged();
    }
}
