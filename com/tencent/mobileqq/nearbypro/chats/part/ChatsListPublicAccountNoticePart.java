package com.tencent.mobileqq.nearbypro.chats.part;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import ca2.PublicAccountConfig;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.noticebar.QUINoticeBarManager;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.nearbypro.api.IStrangerPublicAccountUtil;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.QQToastUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/chats/part/ChatsListPublicAccountNoticePart;", "Lcom/tencent/mobileqq/nearbypro/chats/part/a;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "<init>", "()V", "f", "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class ChatsListPublicAccountNoticePart extends a {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(final ViewGroup container, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(container, "$container");
        ((IStrangerPublicAccountUtil) QRoute.api(IStrangerPublicAccountUtil.class)).follow(2, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.nearbypro.chats.part.ChatsListPublicAccountNoticePart$onInitView$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                if (z16) {
                    QQToastUtil.showQQToastInUiThread(2, "\u5173\u6ce8\u6210\u529f");
                    container.removeAllViews();
                }
            }
        });
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(ViewGroup container, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(container, "$container");
        ((IStrangerPublicAccountUtil) QRoute.api(IStrangerPublicAccountUtil.class)).markCloseFollowBar(2);
        container.removeAllViews();
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        PublicAccountConfig.FollowBarConfig followBarConfig;
        String str;
        boolean z16;
        String icon;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        final ViewGroup publicAccountNotice = A9().getPublicAccountNotice();
        publicAccountNotice.removeAllViews();
        boolean shouldShowFollowBar = ((IStrangerPublicAccountUtil) QRoute.api(IStrangerPublicAccountUtil.class)).shouldShowFollowBar(2);
        if (shouldShowFollowBar) {
            PublicAccountConfig loadConfig = ((IStrangerPublicAccountUtil) QRoute.api(IStrangerPublicAccountUtil.class)).loadConfig(2);
            if (loadConfig != null) {
                followBarConfig = loadConfig.getFollowBar();
            } else {
                followBarConfig = null;
            }
            String str2 = "";
            if (followBarConfig == null || (str = followBarConfig.getTitle()) == null) {
                str = "";
            }
            if (followBarConfig != null && (icon = followBarConfig.getIcon()) != null) {
                str2 = icon;
            }
            if (str.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                QUINoticeBarManager a16 = QUINoticeBarManager.INSTANCE.a();
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                com.tencent.biz.qui.noticebar.d h16 = a16.h(context);
                if (!TextUtils.isEmpty(str2)) {
                    URLDrawable drawable = URLDrawable.getDrawable(str2, URLDrawable.URLDrawableOptions.obtain());
                    h16.setIcon(drawable);
                    j.c().c("ChatsListPublicAccountNoticePart", "urlDrawable" + drawable.getStatus());
                }
                ((com.tencent.biz.qui.noticebar.d) h16.setMsg(str)).g(true).b("\u5173\u6ce8", new View.OnClickListener() { // from class: com.tencent.mobileqq.nearbypro.chats.part.d
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ChatsListPublicAccountNoticePart.H9(publicAccountNotice, view);
                    }
                }).k(new View.OnClickListener() { // from class: com.tencent.mobileqq.nearbypro.chats.part.e
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ChatsListPublicAccountNoticePart.I9(publicAccountNotice, view);
                    }
                });
                publicAccountNotice.addView(h16.getView());
            } else {
                j.c().e("ChatsListPublicAccountNoticePart", "title.isEmpty");
            }
        } else {
            publicAccountNotice.removeAllViews();
        }
        j.c().e("ChatsListPublicAccountNoticePart", "shouldShowFollowBar: " + shouldShowFollowBar);
    }
}
