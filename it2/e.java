package it2;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.qui.quitagview.QUITagSize;
import com.tencent.biz.qui.quitagview.QUITagType;
import com.tencent.biz.qui.quitagview.QUITagView;
import com.tencent.biz.qui.quitagview.QUITagViewConfig;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqguildsdk.api.IQQGuildUtilApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.listitem.QUIListItemBackgroundType;
import com.tencent.mobileqq.widget.listitem.ab;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.AIOBindGuildInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010*\u001a\u00020&\u00a2\u0006\u0004\b+\u0010,J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J6\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b\u0018\u00010\fH\u0002JL\u0010\u0013\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\n2\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b\u0018\u00010\f2\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b\u0018\u00010\fR\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u0006-"}, d2 = {"Lit2/e;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/qqnt/kernel/nativeinterface/AIOBindGuildInfo;", "guildInfo", "Lcom/tencent/image/URLDrawable;", ReportConstant.COSTREPORT_PREFIX, "Landroid/content/Context;", "context", "", "r", "", "btnDesc", "Lkotlin/Function1;", "onManageBtnClick", "p", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemBackgroundType;", "bgType", "manageBtnDesc", "onClickListener", DomainData.DOMAIN_NAME, "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "guildAvatarImage", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "guildNameTv", "G", "guildIdTv", "Lcom/tencent/biz/qui/quitagview/QUITagView;", "H", "Lcom/tencent/biz/qui/quitagview/QUITagView;", "tagView", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "I", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "manageBtn", "Landroid/view/View;", "J", "Landroid/view/View;", "gapLine", "guildItemView", "<init>", "(Landroid/view/View;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class e extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final ImageView guildAvatarImage;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final TextView guildNameTv;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final TextView guildIdTv;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final QUITagView tagView;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final QUIButton manageBtn;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final View gapLine;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@NotNull View guildItemView) {
        super(guildItemView);
        Intrinsics.checkNotNullParameter(guildItemView, "guildItemView");
        View findViewById = guildItemView.findViewById(R.id.vzu);
        Intrinsics.checkNotNullExpressionValue(findViewById, "guildItemView.findViewById(R.id.guild_avatar)");
        this.guildAvatarImage = (ImageView) findViewById;
        View findViewById2 = guildItemView.findViewById(R.id.wrw);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "guildItemView.findViewById(R.id.guild_name)");
        this.guildNameTv = (TextView) findViewById2;
        View findViewById3 = guildItemView.findViewById(R.id.w3i);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "guildItemView.findViewById(R.id.guild_desc)");
        this.guildIdTv = (TextView) findViewById3;
        View findViewById4 = guildItemView.findViewById(R.id.x1q);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "guildItemView.findViewById(R.id.guild_tag)");
        this.tagView = (QUITagView) findViewById4;
        View findViewById5 = guildItemView.findViewById(R.id.wpb);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "guildItemView.findViewById(R.id.guild_manage_btn)");
        this.manageBtn = (QUIButton) findViewById5;
        View findViewById6 = guildItemView.findViewById(R.id.vl8);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "guildItemView.findViewById(R.id.gap_line)");
        this.gapLine = findViewById6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(Function1 function1, AIOBindGuildInfo aIOBindGuildInfo, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (function1 != null) {
            function1.invoke(aIOBindGuildInfo);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void p(final Context context, final AIOBindGuildInfo guildInfo, int btnDesc, final Function1<? super AIOBindGuildInfo, Unit> onManageBtnClick) {
        this.manageBtn.setText(context.getString(btnDesc));
        this.manageBtn.setOnClickListener(new View.OnClickListener() { // from class: it2.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.q(context, onManageBtnClick, guildInfo, view);
            }
        });
        if (guildInfo.status != 0) {
            this.manageBtn.setBackgroundDisabled();
        } else {
            this.manageBtn.o();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(Context context, Function1 function1, AIOBindGuildInfo guildInfo, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(guildInfo, "$guildInfo");
        if (!NetworkUtil.isNetworkAvailable()) {
            QQToast.makeText(context, 1, "\u65e0\u7f51\u7edc\uff0c\u8bf7\u68c0\u67e5\u7f51\u7edc\u8bbe\u7f6e", 0).show();
        } else if (function1 != null) {
            function1.invoke(guildInfo);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void r(Context context, AIOBindGuildInfo guildInfo) {
        int i3;
        QUITagView qUITagView = this.tagView;
        if (guildInfo.isOwner) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        qUITagView.setVisibility(i3);
        QUITagView qUITagView2 = this.tagView;
        QUITagType qUITagType = QUITagType.FILL;
        QUITagSize qUITagSize = QUITagSize.SMALL;
        String string = context.getString(R.string.f23374783);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026roop_guild_owner_tag_txt)");
        qUITagView2.setConfig(new QUITagViewConfig(qUITagType, qUITagSize, null, string));
    }

    private final URLDrawable s(AIOBindGuildInfo guildInfo) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        Intrinsics.checkNotNullExpressionValue(obtain, "obtain()");
        float f16 = R.dimen.dgr;
        obtain.mRequestWidth = ViewUtils.dip2px(f16);
        obtain.mRequestHeight = ViewUtils.dip2px(f16);
        URLDrawable drawable = URLDrawable.getDrawable(((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).getAvatarUrl(String.valueOf(guildInfo.guildId), guildInfo.faceSeq, 40), obtain);
        Intrinsics.checkNotNullExpressionValue(drawable, "getDrawable(avatarUrl, options)");
        return drawable;
    }

    public final void n(@Nullable final AIOBindGuildInfo guildInfo, @NotNull QUIListItemBackgroundType bgType, int manageBtnDesc, @Nullable final Function1<? super AIOBindGuildInfo, Unit> onClickListener, @Nullable Function1<? super AIOBindGuildInfo, Unit> onManageBtnClick) {
        Context context;
        int i3;
        Intrinsics.checkNotNullParameter(bgType, "bgType");
        if (guildInfo == null || (context = this.itemView.getContext()) == null) {
            return;
        }
        this.guildAvatarImage.setImageDrawable(s(guildInfo));
        ab.d(this.guildAvatarImage, ViewUtils.dip2px(4.0f));
        this.guildNameTv.setText(guildInfo.guildName);
        this.guildIdTv.setText(guildInfo.guildNumber);
        this.itemView.setOnClickListener(new View.OnClickListener() { // from class: it2.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.o(Function1.this, guildInfo, view);
            }
        });
        this.itemView.setBackground(bgType.getBackground(context, 1000));
        View view = this.gapLine;
        if (bgType != QUIListItemBackgroundType.AllRound && bgType != QUIListItemBackgroundType.BottomRound && bgType != QUIListItemBackgroundType.FullWidth) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view.setVisibility(i3);
        r(context, guildInfo);
        p(context, guildInfo, manageBtnDesc, onManageBtnClick);
    }
}
