package com.tencent.mobileqq.gamecenter.qa.view;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.TextView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.gamecenter.qa.model.GameListItem;
import com.tencent.mobileqq.guild.widget.C11728RoundRectUrlImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0005B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\b\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0007R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/view/bi;", "", "Lcom/tencent/mobileqq/gamecenter/qa/model/GameListItem;", "gameItem", "", "a", "Landroid/view/View;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "b", "Lcom/tencent/mobileqq/gamecenter/qa/model/GameListItem;", "mGameItem", "Landroid/widget/TextView;", "c", "Landroid/widget/TextView;", "mGameNameView", "Lcom/tencent/mobileqq/guild/widget/RoundRectUrlImageView;", "d", "Lcom/tencent/mobileqq/guild/widget/RoundRectUrlImageView;", "mGameIconView", "<init>", "(Landroid/view/View;)V", "e", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class bi {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View rootView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GameListItem mGameItem;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView mGameNameView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final C11728RoundRectUrlImageView mGameIconView;

    public bi(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        this.rootView = rootView;
        View findViewById = rootView.findViewById(R.id.f113096pp);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.txt_game_name)");
        this.mGameNameView = (TextView) findViewById;
        View findViewById2 = rootView.findViewById(R.id.xdy);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.icon_game)");
        this.mGameIconView = (C11728RoundRectUrlImageView) findViewById2;
    }

    public final void a(@NotNull GameListItem gameItem) {
        String str;
        Intrinsics.checkNotNullParameter(gameItem, "gameItem");
        this.mGameItem = gameItem;
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = new ColorDrawable(0);
        obtain.mFailedDrawable = new ColorDrawable(0);
        C11728RoundRectUrlImageView c11728RoundRectUrlImageView = this.mGameIconView;
        GameListItem gameListItem = this.mGameItem;
        String str2 = null;
        if (gameListItem != null) {
            str = gameListItem.getIcon();
        } else {
            str = null;
        }
        c11728RoundRectUrlImageView.setImageDrawable(URLDrawable.getDrawable(str, obtain));
        this.mGameIconView.setAllRadius(com.tencent.mobileqq.utils.x.a(15.0f));
        TextView textView = this.mGameNameView;
        GameListItem gameListItem2 = this.mGameItem;
        if (gameListItem2 != null) {
            str2 = gameListItem2.getName();
        }
        textView.setText(str2);
    }
}
