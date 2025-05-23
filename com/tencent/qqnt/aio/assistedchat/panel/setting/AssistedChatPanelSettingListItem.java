package com.tencent.qqnt.aio.assistedchat.panel.setting;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.pic.api.IPicAIOApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.listitem.QUIListItem;
import com.tencent.mobileqq.widget.listitem.QUIListItemBackgroundType;
import com.tencent.mobileqq.widget.listitem.ac;
import com.tencent.widget.FixRatioImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\f\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00012\u00020\u0003B\u001d\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004R\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/aio/assistedchat/panel/setting/AssistedChatPanelSettingListItem;", "Lcom/tencent/mobileqq/widget/listitem/QUIListItem;", "V", "Landroid/widget/LinearLayout;", "", "imageUrl", "", "b", "Lcom/tencent/mobileqq/widget/listitem/ac;", "d", "Lcom/tencent/mobileqq/widget/listitem/ac;", "a", "()Lcom/tencent/mobileqq/widget/listitem/ac;", "simpleHolder", "Lcom/tencent/widget/FixRatioImageView;", "e", "Lcom/tencent/widget/FixRatioImageView;", "imageIv", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/widget/listitem/ac;)V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AssistedChatPanelSettingListItem<V extends QUIListItem<?>> extends LinearLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ac<V> simpleHolder;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FixRatioImageView imageIv;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AssistedChatPanelSettingListItem(@NotNull Context context, @NotNull ac<V> simpleHolder) {
        super(context);
        QUIListItem qUIListItem;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(simpleHolder, "simpleHolder");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) simpleHolder);
            return;
        }
        this.simpleHolder = simpleHolder;
        FixRatioImageView fixRatioImageView = new FixRatioImageView(context, null, 0, 6, null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = com.tencent.qqnt.aio.utils.l.b(12);
        layoutParams.rightMargin = com.tencent.qqnt.aio.utils.l.b(12);
        layoutParams.topMargin = com.tencent.qqnt.aio.utils.l.b(12);
        fixRatioImageView.setLayoutParams(layoutParams);
        fixRatioImageView.setRatio(3.26f);
        fixRatioImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.imageIv = fixRatioImageView;
        setOrientation(1);
        addView(fixRatioImageView);
        View view = simpleHolder.itemView;
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        if (view instanceof QUIListItem) {
            qUIListItem = (QUIListItem) view;
        } else {
            qUIListItem = null;
        }
        if (qUIListItem != null) {
            qUIListItem.setBackgroundType(QUIListItemBackgroundType.None);
        }
        addView(view);
    }

    @NotNull
    public final ac<V> a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ac) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.simpleHolder;
    }

    public final void b(@NotNull String imageUrl) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) imageUrl);
            return;
        }
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        if (imageUrl.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.imageIv.setVisibility(8);
            return;
        }
        this.imageIv.setVisibility(0);
        Option option = Option.obtain().setUrl(imageUrl).setTargetView(this.imageIv).setLoadingDrawable(new ColorDrawable(0)).setFailDrawable(new ColorDrawable(0));
        IPicAIOApi iPicAIOApi = (IPicAIOApi) QRoute.api(IPicAIOApi.class);
        Intrinsics.checkNotNullExpressionValue(option, "option");
        iPicAIOApi.loadPic(option, null);
    }
}
