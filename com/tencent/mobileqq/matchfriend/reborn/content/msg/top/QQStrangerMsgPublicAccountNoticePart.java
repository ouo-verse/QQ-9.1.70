package com.tencent.mobileqq.matchfriend.reborn.content.msg.top;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import ca2.PublicAccountConfig;
import com.google.android.material.appbar.AppBarLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.noticebar.QUINoticeBarManager;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.nearbypro.api.IStrangerPublicAccountUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.utils.l;
import com.tencent.util.QQToastUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/top/QQStrangerMsgPublicAccountNoticePart;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/part/a;", "", "title", "icon", "Lcom/tencent/biz/qui/noticebar/d;", "D9", "bar", "", "H9", "G9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lcom/google/android/material/appbar/AppBarLayout;", "e", "Lcom/google/android/material/appbar/AppBarLayout;", "appbarLayout", "f", "Landroid/view/View;", "noticeBar", "<init>", "()V", h.F, "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerMsgPublicAccountNoticePart extends com.tencent.mobileqq.matchfriend.reborn.content.msg.part.a {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private AppBarLayout appbarLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View noticeBar;

    private final com.tencent.biz.qui.noticebar.d D9(String title, String icon) {
        QUINoticeBarManager a16 = QUINoticeBarManager.INSTANCE.a();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        com.tencent.biz.qui.noticebar.d h16 = a16.h(context);
        if (!TextUtils.isEmpty(icon)) {
            URLDrawable drawable = URLDrawable.getDrawable(icon, URLDrawable.URLDrawableOptions.obtain());
            h16.setIcon(drawable);
            QLog.d("QQStrangerMsgPublicAccountNoticePart", 1, "urlDrawable" + drawable.getStatus());
        }
        ((com.tencent.biz.qui.noticebar.d) h16.setMsg(title)).g(true).b("\u5173\u6ce8", new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.top.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQStrangerMsgPublicAccountNoticePart.E9(QQStrangerMsgPublicAccountNoticePart.this, view);
            }
        }).k(new View.OnClickListener() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.top.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQStrangerMsgPublicAccountNoticePart.F9(QQStrangerMsgPublicAccountNoticePart.this, view);
            }
        });
        return h16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E9(final QQStrangerMsgPublicAccountNoticePart this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((IStrangerPublicAccountUtil) QRoute.api(IStrangerPublicAccountUtil.class)).follow(1, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.top.QQStrangerMsgPublicAccountNoticePart$createNoticeBar$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                    QQStrangerMsgPublicAccountNoticePart.this.G9();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(QQStrangerMsgPublicAccountNoticePart this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((IStrangerPublicAccountUtil) QRoute.api(IStrangerPublicAccountUtil.class)).markCloseFollowBar(1);
        this$0.G9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G9() {
        View view = this.noticeBar;
        if (view != null) {
            AppBarLayout appBarLayout = this.appbarLayout;
            if (appBarLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("appbarLayout");
                appBarLayout = null;
            }
            appBarLayout.removeView(view);
            this.noticeBar = null;
        }
    }

    private final void H9(com.tencent.biz.qui.noticebar.d bar) {
        G9();
        View view = bar.getView();
        AppBarLayout.LayoutParams layoutParams = new AppBarLayout.LayoutParams(-1, l.b(48));
        layoutParams.g(17);
        view.setLayoutParams(layoutParams);
        AppBarLayout appBarLayout = this.appbarLayout;
        if (appBarLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("appbarLayout");
            appBarLayout = null;
        }
        appBarLayout.addView(view, 0);
        this.noticeBar = view;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        String str;
        String icon;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.f163140oi4);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.appBarLayout)");
        this.appbarLayout = (AppBarLayout) findViewById;
        boolean shouldShowFollowBar = ((IStrangerPublicAccountUtil) QRoute.api(IStrangerPublicAccountUtil.class)).shouldShowFollowBar(1);
        if (shouldShowFollowBar) {
            PublicAccountConfig loadConfig = ((IStrangerPublicAccountUtil) QRoute.api(IStrangerPublicAccountUtil.class)).loadConfig(1);
            PublicAccountConfig.FollowBarConfig followBar = loadConfig != null ? loadConfig.getFollowBar() : null;
            String str2 = "";
            if (followBar == null || (str = followBar.getTitle()) == null) {
                str = "";
            }
            if (followBar != null && (icon = followBar.getIcon()) != null) {
                str2 = icon;
            }
            if (str.length() > 0) {
                H9(D9(str, str2));
            } else {
                QLog.d("QQStrangerMsgPublicAccountNoticePart", 1, "title.isEmpty");
                G9();
            }
        } else {
            G9();
        }
        QLog.d("QQStrangerMsgPublicAccountNoticePart", 1, "shouldShowFollowBar: " + shouldShowFollowBar);
    }
}
