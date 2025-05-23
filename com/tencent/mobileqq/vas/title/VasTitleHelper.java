package com.tencent.mobileqq.vas.title;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.aio.event.AIOTitleEvent;
import com.tencent.mobileqq.aio.title.ao;
import com.tencent.mobileqq.aio.utils.ae;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.vas.api.IVasColorName;
import com.tencent.mobileqq.vas.api.IVasRecentData;
import com.tencent.mobileqq.vas.image.c;
import com.tencent.mobileqq.vas.vipicon.NamePlateVipType;
import com.tencent.mobileqq.vas.vipicon.api.IVipIconClick;
import com.tencent.mobileqq.vas.vipicon.api.IVipIconFactory;
import com.tencent.mobileqq.vip.api.IVipDataUtils;
import com.tencent.mobileqq.vip.api.VipData;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.base.route.j;
import cooperation.qzone.QZoneClickReport;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000=\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0007*\u0001\u0015\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0006H\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/vas/title/VasTitleHelper;", "Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/mobileqq/aio/event/AIOTitleEvent$TitleRequestEvent;", "event", "", "handleTitleRequest", "", "getId", "", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "state", "onMoveToState", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lcom/tencent/aio/api/runtime/a;", "com/tencent/mobileqq/vas/title/VasTitleHelper$a", "callbackInstance", "Lcom/tencent/mobileqq/vas/title/VasTitleHelper$a;", "<init>", "()V", "Companion", "vas_api_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes20.dex */
public final class VasTitleHelper implements h {

    @NotNull
    private static final String TAG = "VasTitleHelper";

    @Nullable
    private com.tencent.aio.api.runtime.a aioContext;

    @NotNull
    private final a callbackInstance = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/vas/title/VasTitleHelper$a", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "vas_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class a implements com.tencent.mvi.base.route.a {
        a() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            if (i3 instanceof AIOTitleEvent.TitleRequestEvent) {
                VasTitleHelper.this.handleTitleRequest((AIOTitleEvent.TitleRequestEvent) i3);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0006H\u0016R\u0017\u0010\u0010\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0011"}, d2 = {"com/tencent/mobileqq/vas/title/VasTitleHelper$b", "Lcom/tencent/mobileqq/aio/utils/ae;", "Landroid/content/res/Resources;", "res", "Landroid/graphics/drawable/Drawable;", "a", "Landroid/view/View;", "v", "", "b", "titleTv", "c", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnClickListener;", "getClickListener", "()Landroid/view/View$OnClickListener;", "clickListener", "vas_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b implements ae {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final View.OnClickListener clickListener;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f310986b;

        b(String str) {
            this.f310986b = str;
            this.clickListener = ((IVipIconClick) QRoute.api(IVipIconClick.class)).newClickListener(str, "VIA_AIO_TITLE");
        }

        @Override // com.tencent.mobileqq.aio.utils.ae
        @Nullable
        public Drawable a(@NotNull Resources res) {
            c icon;
            Intrinsics.checkNotNullParameter(res, "res");
            if (SimpleUIUtil.isNowSimpleMode()) {
                return null;
            }
            IVasRecentData.FriendsVipData friendsVipData = ((IVasRecentData) QRoute.api(IVasRecentData.class)).getFriendsVipData(this.f310986b);
            if (!NamePlateVipType.convert(friendsVipData.getVipType()).atLeastSuperVip() || !friendsVipData.getIsSuperVip() || (icon = ((IVipIconFactory) QRoute.api(IVipIconFactory.class)).getIcon(res, this.f310986b, friendsVipData, QZoneClickReport.ClickReportConfig.SOURCE_FROM_AIO)) == null) {
                return null;
            }
            ((IVipIconClick) QRoute.api(IVipIconClick.class)).report04586(friendsVipData.getNamePlateId(), false, "VIA_AIO_TITLE");
            return icon;
        }

        @Override // com.tencent.mobileqq.aio.utils.ae
        public void b(@NotNull View v3) {
            Intrinsics.checkNotNullParameter(v3, "v");
            this.clickListener.onClick(v3);
        }

        @Override // com.tencent.mobileqq.aio.utils.ae
        public void c(@NotNull View titleTv) {
            Intrinsics.checkNotNullParameter(titleTv, "titleTv");
            IVasRecentData.FriendsVipData friendsVipData = ((IVasRecentData) QRoute.api(IVasRecentData.class)).getFriendsVipData(this.f310986b);
            VipData vipDataForFriends = ((IVipDataUtils) QRoute.api(IVipDataUtils.class)).getVipDataForFriends(this.f310986b);
            ((IVasColorName) QRoute.api(IVasColorName.class)).updateTitle(friendsVipData.getGrayNameplateFlag(), friendsVipData.getVipType(), vipDataForFriends.getColorName(), titleTv, vipDataForFriends.getUseDefaultNickColor(), true);
            ((IVasColorName) QRoute.api(IVasColorName.class)).needAddTitleCover(friendsVipData.getGrayNameplateFlag(), friendsVipData.getVipType(), vipDataForFriends.getColorName(), titleTv);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleTitleRequest(AIOTitleEvent.TitleRequestEvent event) {
        String str;
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        if (aVar != null && event.a() == 1) {
            AIOParam g16 = aVar.g();
            if (g16 != null) {
                str = su3.c.b(g16);
            } else {
                str = null;
            }
            Intrinsics.checkNotNull(str);
            aVar.e().h(new AIOTitleEvent.TitleResponseEvent(1, new ao(new b(str))));
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return 34;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        return TAG;
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        return new int[]{12, 0};
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        com.tencent.aio.api.runtime.a a16 = param.a();
        a16.e().d(Reflection.getOrCreateKotlinClass(AIOTitleEvent.TitleRequestEvent.class).getQualifiedName(), this.callbackInstance);
        this.aioContext = a16;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        j e16;
        h.a.b(this);
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        if (aVar != null && (e16 = aVar.e()) != null) {
            e16.b(Reflection.getOrCreateKotlinClass(AIOTitleEvent.TitleRequestEvent.class).getQualifiedName(), this.callbackInstance);
        }
        this.aioContext = null;
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        if (state == 12) {
            onDestroy();
        }
    }

    public boolean withMonitor() {
        return h.a.c(this);
    }
}
