package com.tencent.mobileqq.nearbypro.chats.part;

import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.guild.nt.misc.api.IJumpApi;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendEntryApi;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u000b2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/chats/part/g;", "Lcom/tencent/mobileqq/nearbypro/chats/part/a;", "", "H9", "G9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "<init>", "()V", "f", "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class g extends a {
    private final boolean G9() {
        AppInterface appInterface;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface == null) {
            return false;
        }
        boolean matchFriendEntrance = ((IMatchFriendEntryApi) QRoute.api(IMatchFriendEntryApi.class)).getMatchFriendEntrance(appInterface);
        j.c().e("ChatsListTopBannerPart", "canShow\uff1a " + matchFriendEntrance);
        return matchFriendEntrance;
    }

    private final boolean H9() {
        boolean z16;
        boolean z17 = false;
        try {
            String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("102172", "");
            if (loadAsString.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                j.c().c("ChatsListTopBannerPart", "switch: 102172 is empty, default = false");
            } else {
                boolean optBoolean = new JSONObject(loadAsString).optBoolean("isFeatureTurnedOnAndroid", false);
                j.c().e("ChatsListTopBannerPart", "switch success: " + optBoolean);
                z17 = optBoolean;
            }
        } catch (Throwable th5) {
            j.c().d("ChatsListTopBannerPart", "switch error: " + th5);
        }
        j.c().e("ChatsListTopBannerPart", "isFeatureTurnedOn\uff1a " + z17);
        return z17;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(g this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((IJumpApi) QRoute.api(IJumpApi.class)).doJumpAction(this$0.getContext(), "mqqapi://stranger/jump_home_page?from=1");
        com.tencent.mobileqq.nearbypro.aio.utils.a.f253152a.a(view, "em_nearby_company_banner", null);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        Map<String, ? extends Object> emptyMap;
        super.onInitView(rootView);
        LayoutInflater a16 = xv3.a.a(A9().getRoot());
        A9().getTopBannerContainer().removeAllViews();
        if (!H9() || !G9()) {
            return;
        }
        xa2.f g16 = xa2.f.g(a16, A9().getTopBannerContainer(), true);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(\n            lay\u2026           true\n        )");
        ViewGroup.LayoutParams layoutParams = g16.f447592b.getLayoutParams();
        int i3 = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
        layoutParams.height = (i3 - ViewUtils.dpToPx(32.0f)) / 4;
        j.c().e("ChatsListTopBannerPart", "imageContent: " + i3 + ", " + ViewUtils.dpToPx(32.0f) + ", 4");
        g16.f447592b.setLayoutParams(layoutParams);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mFailedDrawable = new ColorDrawable(0);
        obtain.mLoadingDrawable = new ColorDrawable(0);
        g16.f447592b.setImageDrawable(URLDrawable.getDrawable("https://vfiles.gtimg.cn/wupload/xy/componenthub/dWD1TF3I.png", obtain));
        g16.f447592b.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.nearbypro.chats.part.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                g.I9(g.this, view);
            }
        });
        com.tencent.mobileqq.nearbypro.aio.utils.a aVar = com.tencent.mobileqq.nearbypro.aio.utils.a.f253152a;
        ImageView imageView = g16.f447592b;
        emptyMap = MapsKt__MapsKt.emptyMap();
        aVar.b(imageView, "em_nearby_company_banner", emptyMap);
    }
}
