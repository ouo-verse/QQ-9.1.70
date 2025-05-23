package lq0;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.guild.aio.util.ui.UIUtil;
import com.tencent.guild.api.util.IGuildUtilApi;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IQQGuildAvatarApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001#B-\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018\u0012\u0006\u0010 \u001a\u00020\u001d\u00a2\u0006\u0004\b!\u0010\"J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000e\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\tH\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006$"}, d2 = {"Llq0/c;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Llq0/c$a;", "Lcom/tencent/image/URLImageView;", "view", "", "k0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "j0", "holder", "position", "i0", "getItemCount", "Landroid/view/View$OnClickListener;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View$OnClickListener;", "mClickListener", "Landroid/view/View$OnLongClickListener;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View$OnLongClickListener;", "mLongClickListener", "", "Llq0/f;", "D", "Ljava/util/List;", "mPlusPanelItemList", "Llq0/i;", "E", "Llq0/i;", "mAppInfoFactory", "<init>", "(Landroid/view/View$OnClickListener;Landroid/view/View$OnLongClickListener;Ljava/util/List;Llq0/i;)V", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class c extends RecyclerView.Adapter<a> {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final View.OnLongClickListener mLongClickListener;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final List<f> mPlusPanelItemList;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final i mAppInfoFactory;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View.OnClickListener mClickListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u00a2\u0006\u0004\b \u0010!R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001d\u001a\u00020\u00128\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018\u00a8\u0006\""}, d2 = {"Llq0/c$a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "o", "()Landroid/widget/TextView;", ReportConstant.COSTREPORT_PREFIX, "(Landroid/widget/TextView;)V", "mNameTv", "Lcom/tencent/image/URLImageView;", UserInfo.SEX_FEMALE, "Lcom/tencent/image/URLImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/image/URLImageView;", "r", "(Lcom/tencent/image/URLImageView;)V", "mIconIv", "Landroid/widget/ImageView;", "G", "Landroid/widget/ImageView;", "l", "()Landroid/widget/ImageView;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Landroid/widget/ImageView;)V", "mHotDotIv", "H", "p", "t", "mRobotTag", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class a extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        public TextView mNameTv;

        /* renamed from: F, reason: from kotlin metadata */
        public URLImageView mIconIv;

        /* renamed from: G, reason: from kotlin metadata */
        public ImageView mHotDotIv;

        /* renamed from: H, reason: from kotlin metadata */
        public ImageView mRobotTag;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
        }

        @NotNull
        public final ImageView l() {
            ImageView imageView = this.mHotDotIv;
            if (imageView != null) {
                return imageView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mHotDotIv");
            return null;
        }

        @NotNull
        public final URLImageView m() {
            URLImageView uRLImageView = this.mIconIv;
            if (uRLImageView != null) {
                return uRLImageView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mIconIv");
            return null;
        }

        @NotNull
        public final TextView o() {
            TextView textView = this.mNameTv;
            if (textView != null) {
                return textView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mNameTv");
            return null;
        }

        @NotNull
        public final ImageView p() {
            ImageView imageView = this.mRobotTag;
            if (imageView != null) {
                return imageView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mRobotTag");
            return null;
        }

        public final void q(@NotNull ImageView imageView) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.mHotDotIv = imageView;
        }

        public final void r(@NotNull URLImageView uRLImageView) {
            Intrinsics.checkNotNullParameter(uRLImageView, "<set-?>");
            this.mIconIv = uRLImageView;
        }

        public final void s(@NotNull TextView textView) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.mNameTv = textView;
        }

        public final void t(@NotNull ImageView imageView) {
            Intrinsics.checkNotNullParameter(imageView, "<set-?>");
            this.mRobotTag = imageView;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J&\u0010\n\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u001c\u0010\u000b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J&\u0010\r\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\fH\u0016J$\u0010\u000f\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\u000eH\u0016\u00a8\u0006\u0010"}, d2 = {"lq0/c$b", "Lcom/tencent/image/URLDrawableDownListener;", "Landroid/view/View;", "p0", "Lcom/tencent/image/URLDrawable;", "p1", "", "onLoadSuccessed", "", "p2", "onLoadFailed", "onLoadCancelled", "Ljava/lang/InterruptedException;", "onLoadInterrupted", "", "onLoadProgressed", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b implements URLDrawableDownListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ URLImageView f415393d;

        b(URLImageView uRLImageView) {
            this.f415393d = uRLImageView;
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadCancelled(@Nullable View p06, @Nullable URLDrawable p16) {
            Drawable drawable = this.f415393d.getDrawable();
            Intrinsics.checkNotNull(drawable, "null cannot be cast to non-null type com.tencent.image.URLDrawable");
            ((URLDrawable) drawable).setColorFilter(Color.parseColor("#A0A2A5"), PorterDuff.Mode.SRC_ATOP);
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadFailed(@Nullable View p06, @Nullable URLDrawable p16, @Nullable Throwable p26) {
            Drawable drawable = this.f415393d.getDrawable();
            Intrinsics.checkNotNull(drawable, "null cannot be cast to non-null type com.tencent.image.URLDrawable");
            ((URLDrawable) drawable).setColorFilter(Color.parseColor("#A0A2A5"), PorterDuff.Mode.SRC_ATOP);
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadInterrupted(@Nullable View p06, @Nullable URLDrawable p16, @Nullable InterruptedException p26) {
            Drawable drawable = this.f415393d.getDrawable();
            Intrinsics.checkNotNull(drawable, "null cannot be cast to non-null type com.tencent.image.URLDrawable");
            ((URLDrawable) drawable).setColorFilter(Color.parseColor("#A0A2A5"), PorterDuff.Mode.SRC_ATOP);
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadProgressed(@Nullable View p06, @Nullable URLDrawable p16, int p26) {
            Drawable drawable = this.f415393d.getDrawable();
            Intrinsics.checkNotNull(drawable, "null cannot be cast to non-null type com.tencent.image.URLDrawable");
            ((URLDrawable) drawable).setColorFilter(Color.parseColor("#A0A2A5"), PorterDuff.Mode.SRC_ATOP);
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadSuccessed(@Nullable View p06, @Nullable URLDrawable p16) {
            Drawable drawable = this.f415393d.getDrawable();
            Intrinsics.checkNotNull(drawable, "null cannot be cast to non-null type com.tencent.image.URLDrawable");
            ((URLDrawable) drawable).setColorFilter(Color.parseColor("#A0A2A5"), PorterDuff.Mode.SRC_ATOP);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(@NotNull View.OnClickListener mClickListener, @NotNull View.OnLongClickListener mLongClickListener, @NotNull List<? extends f> mPlusPanelItemList, @NotNull i mAppInfoFactory) {
        Intrinsics.checkNotNullParameter(mClickListener, "mClickListener");
        Intrinsics.checkNotNullParameter(mLongClickListener, "mLongClickListener");
        Intrinsics.checkNotNullParameter(mPlusPanelItemList, "mPlusPanelItemList");
        Intrinsics.checkNotNullParameter(mAppInfoFactory, "mAppInfoFactory");
        this.mClickListener = mClickListener;
        this.mLongClickListener = mLongClickListener;
        this.mPlusPanelItemList = mPlusPanelItemList;
        this.mAppInfoFactory = mAppInfoFactory;
    }

    private final void k0(URLImageView view) {
        view.setURLDrawableDownListener(new b(view));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mPlusPanelItemList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull a holder, int position) {
        int i3;
        Intrinsics.checkNotNullParameter(holder, "holder");
        f fVar = this.mPlusPanelItemList.get(position);
        holder.o().setText(holder.itemView.getContext().getResources().getText(fVar.c()));
        holder.o().setContentDescription(holder.itemView.getContext().getResources().getText(fVar.a()));
        holder.m().setImageResource(fVar.b());
        ImageView l3 = holder.l();
        if (fVar.getIsShowNew()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        l3.setVisibility(i3);
        holder.p().setVisibility(8);
        if (fVar.getIsRobotService()) {
            Intrinsics.checkNotNull(fVar, "null cannot be cast to non-null type com.tencent.guild.aio.panel.plus.subitem.GuildRobotServiceAppInfo");
            mq0.g gVar = (mq0.g) fVar;
            gVar.m(position);
            holder.o().setText(gVar.j());
            holder.m().setBackgroundResource(0);
            if (((IGuildUtilApi) QRoute.api(IGuildUtilApi.class)).isNowThemeIsNight()) {
                k0(holder.m());
                holder.p().setBackgroundResource(R.drawable.guild_add_panel_robot_tag_night);
            } else {
                holder.p().setBackgroundResource(R.drawable.guild_add_panel_robot_tag);
            }
            IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IQQGuildAvatarApi.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "sMobileQQ.peekAppRuntime\u2026va, ProcessConstant.MAIN)");
            IQQGuildAvatarApi iQQGuildAvatarApi = (IQQGuildAvatarApi) runtimeService;
            URLImageView m3 = holder.m();
            String i16 = gVar.i();
            wn0.a aVar = wn0.a.f445842a;
            m3.setImageDrawable(iQQGuildAvatarApi.getAvatarDrawable(i16, aVar.b(32), aVar.b(32), null, false));
            holder.p().setVisibility(0);
        }
        holder.m().setColorFilter(UIUtil.f112434a.x().getColor(R.color.qui_common_icon_primary));
        holder.itemView.setOnClickListener(this.mClickListener);
        holder.itemView.setOnLongClickListener(this.mLongClickListener);
        holder.itemView.setEnabled(true);
        holder.itemView.setTag(fVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        i iVar = this.mAppInfoFactory;
        Intrinsics.checkNotNullExpressionValue(inflater, "inflater");
        return iVar.b(inflater, parent);
    }
}
