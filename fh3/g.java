package fh3;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.IZplanOutboundAvatar;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.profilecard.api.IProfileDataService;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.zplan.aio.IZPlanHeadEffectUtil;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.easteregg.ZPlanHeaderEffectUtil;
import com.tencent.mobileqq.zplan.easteregg.u;
import com.tencent.mobileqq.zplan.easteregg.w;
import com.tencent.mobileqq.zplan.servlet.api.IZPlanRequest;
import com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.msg.api.IAIOMsgItemApi;
import fh3.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import nk3.l;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001e2\u00020\u0001:\u0001NB\u000f\u0012\u0006\u0010K\u001a\u00020J\u00a2\u0006\u0004\bL\u0010MJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001c\u0010\u000e\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J \u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\u0010\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001c\u0010\u0011\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J \u0010\u0012\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002J \u0010\u001a\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u0010\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\u0010\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\u0012\u0010 \u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001f\u001a\u00020\u001bH\u0002J\u0010\u0010!\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\u000e\u0010#\u001a\b\u0012\u0004\u0012\u00020\f0\"H\u0014J\u0010\u0010&\u001a\u00020\b2\u0006\u0010%\u001a\u00020$H\u0014J\u0010\u0010(\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020'H\u0016J\b\u0010)\u001a\u00020\bH\u0016R\u0014\u0010+\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010*R\u0016\u0010-\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010\u0010R\u0018\u00100\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00105\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010\u0010R\u0016\u00106\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010\u0010R\u0016\u00108\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u0010\u0010R\u0016\u0010:\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010\u0010R\u0016\u0010<\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010\u0010R\u0016\u0010>\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010\u0010R\u0016\u0010@\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010\u0010R\u0016\u0010B\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010\u0010R\u0016\u0010D\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010\u0010R\u0016\u0010F\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010\u0010R\u0016\u0010H\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010\u0010R\u0016\u0010I\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010\u0010\u00a8\u0006O"}, d2 = {"Lfh3/g;", "Lcom/tencent/mobileqq/aio/msglist/holder/external/c;", "Lcom/tencent/qqnt/aio/refresher/b;", Const.BUNDLE_KEY_REQUEST, "Lcom/tencent/mobileqq/zplan/easteregg/a;", DownloadInfo.spKey_Config, "Landroid/graphics/drawable/Drawable;", "faceDrawable", "", "B", BdhLogUtil.LogTag.Tag_Conn, "G", "", "avatarInfo", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "D", "I", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "E", "Lcom/tencent/mobileqq/zplan/easteregg/w;", HippyTKDListViewAdapter.X, "", "isSelf", "isSelectMode", "Landroid/widget/FrameLayout$LayoutParams;", "layoutParams", "K", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "t", ReportConstant.COSTREPORT_PREFIX, "msgItem", "r", "y", "", "g", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "d", "Lcom/tencent/mobileqq/aio/msglist/holder/external/h;", "c", tl.h.F, "Z", "needZPlanOutBoundAvatar", "", "atmosphereHeight", "e", "Lcom/tencent/mobileqq/zplan/easteregg/w;", "easterEggPlayerManager", "Landroid/view/View;", "f", "Landroid/view/View;", "headEffectView", "headEffectViewHeight", "headEffectViewWidth", "i", "avatarViewSize", "j", "avatarTopMargin", "k", "avatarHorizontalMargin", "l", "headEffectHorizontalMargin", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "headEffectHorizontalMarginWithCheckBox", DomainData.DOMAIN_NAME, "headEffectTopMargin", "o", "headEffectBottomMargin", "p", "designSpacing", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "checkBoxSize", "checkBoxSizeLeftMargin", "Lcom/tencent/mobileqq/aio/msglist/holder/external/e;", "helper", "<init>", "(Lcom/tencent/mobileqq/aio/msglist/holder/external/e;)V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class g extends com.tencent.mobileqq.aio.msglist.holder.external.c {

    /* renamed from: t, reason: collision with root package name */
    private static final Map<String, Boolean> f398730t = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final boolean needZPlanOutBoundAvatar;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int atmosphereHeight;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private w easterEggPlayerManager;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View headEffectView;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int headEffectViewHeight;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int headEffectViewWidth;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int avatarViewSize;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private int avatarTopMargin;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private int avatarHorizontalMargin;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private int headEffectHorizontalMargin;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int headEffectHorizontalMarginWithCheckBox;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private int headEffectTopMargin;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private int headEffectBottomMargin;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private int designSpacing;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private int checkBoxSize;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private int checkBoxSizeLeftMargin;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\u0007\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\b\u0010\u0006J!\u0010\u000b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\tH\u0016\u00a2\u0006\u0004\b\u000b\u0010\f\u00a8\u0006\r"}, d2 = {"fh3/g$b", "Lcom/tencent/mobileqq/zplan/easteregg/w$a;", "", "bubbleId", "", "a", "(Ljava/lang/Long;)V", "d", "b", "", "msgCode", "c", "(Ljava/lang/Long;I)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b implements w.a {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g(Long l3, g this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (l3 != null) {
                this$0.e(new com.tencent.qqnt.aio.refresher.c(l3.longValue(), new com.tencent.qqnt.aio.avatar.egg.a(1, null, null, null, 0, 30, null)));
                this$0.headEffectView = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void h(Long l3, g this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (l3 != null) {
                this$0.e(new com.tencent.qqnt.aio.refresher.c(l3.longValue(), new com.tencent.qqnt.aio.avatar.egg.a(1, null, null, null, 0, 30, null)));
                this$0.headEffectView = null;
            }
        }

        @Override // com.tencent.mobileqq.zplan.easteregg.w.a
        public void a(Long bubbleId) {
            QLog.i("ZPlanAioHeadEffectRefresher", 1, "onStart bubbleId: " + bubbleId);
        }

        @Override // com.tencent.mobileqq.zplan.easteregg.w.a
        public void b(Long bubbleId) {
            QLog.i("ZPlanAioHeadEffectRefresher", 1, "onRelease bubbleId: " + bubbleId);
        }

        @Override // com.tencent.mobileqq.zplan.easteregg.w.a
        public void c(final Long bubbleId, int msgCode) {
            QLog.i("ZPlanAioHeadEffectRefresher", 1, "onError bubbleId: " + bubbleId);
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final g gVar = g.this;
            uIHandlerV2.post(new Runnable() { // from class: fh3.h
                @Override // java.lang.Runnable
                public final void run() {
                    g.b.h(bubbleId, gVar);
                }
            });
        }

        @Override // com.tencent.mobileqq.zplan.easteregg.w.a
        public void d(final Long bubbleId) {
            QLog.i("ZPlanAioHeadEffectRefresher", 1, "onComplete bubbleId: " + bubbleId);
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final g gVar = g.this;
            uIHandlerV2.post(new Runnable() { // from class: fh3.i
                @Override // java.lang.Runnable
                public final void run() {
                    g.b.g(bubbleId, gVar);
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(com.tencent.mobileqq.aio.msglist.holder.external.e helper) {
        super(helper);
        Intrinsics.checkNotNullParameter(helper, "helper");
        this.needZPlanOutBoundAvatar = ((IZPlanFeatureSwitchHelper) QRoute.api(IZPlanFeatureSwitchHelper.class)).needOutBoundAvatar2EasterEgg();
    }

    private final void B(com.tencent.qqnt.aio.refresher.b request, com.tencent.mobileqq.zplan.easteregg.a config, Drawable faceDrawable) {
        if (config.getIsOutBoundAvatar()) {
            if (config.getBackgroundUrl().length() > 0) {
                D(request, config, faceDrawable);
                return;
            }
        }
        if (this.needZPlanOutBoundAvatar) {
            return;
        }
        C(request, config, faceDrawable);
    }

    private final void C(com.tencent.qqnt.aio.refresher.b request, com.tencent.mobileqq.zplan.easteregg.a config, Drawable faceDrawable) {
        QLog.i("ZPlanAioHeadEffectRefresher", 1, "prepareZPlanAvatarInfoV1");
        String valueOf = String.valueOf(request.c().getMsgRecord().senderUin);
        Map<String, Boolean> map = f398730t;
        Boolean bool = map.get(valueOf);
        Boolean bool2 = Boolean.TRUE;
        if (Intrinsics.areEqual(bool, bool2)) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                QLog.i("ZPlanAioHeadEffectRefresher", 1, "prepareZPlanAvatarInfoV1, appRuntime is null, return.");
                return;
            }
            IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IProfileDataService.class, "all");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026ava, ProcessConstant.ALL)");
            Card profileCard = ((IProfileDataService) runtimeService).getProfileCard(valueOf, true);
            if (!profileCard.isZPlanAvatar) {
                QLog.i("ZPlanAioHeadEffectRefresher", 1, "prepareZPlanAvatarInfoV1, isZPlanAvatar is false, return.");
                return;
            }
            String str = profileCard.zplanGander;
            if (!(str == null || str.length() == 0)) {
                String str2 = profileCard.zplanAvatarBackgroundUrl;
                if (!(str2 == null || str2.length() == 0)) {
                    config.C(Intrinsics.areEqual("1", profileCard.zplanGander));
                    String str3 = profileCard.zplanAvatarBackgroundUrl;
                    Intrinsics.checkNotNullExpressionValue(str3, "card.zplanAvatarBackgroundUrl");
                    config.y(str3);
                    config.v(profileCard.zplanAppearanceKey);
                    E(request, config, faceDrawable);
                    return;
                }
            }
            QLog.i("ZPlanAioHeadEffectRefresher", 1, "prepareZPlanAvatarInfoV1, zplanGander: " + profileCard.zplanGander + ", zplanAvatarBackgroundUrl: " + profileCard.zplanAvatarBackgroundUrl + ", return.");
            return;
        }
        G(request, config, faceDrawable);
        map.put(valueOf, bool2);
    }

    private final void D(com.tencent.qqnt.aio.refresher.b request, com.tencent.mobileqq.zplan.easteregg.a config, Drawable faceDrawable) {
        QLog.i("ZPlanAioHeadEffectRefresher", 1, "prepareZPlanAvatarInfoV2");
        String valueOf = String.valueOf(request.c().getMsgRecord().senderUin);
        Map<String, Boolean> map = f398730t;
        Boolean bool = map.get(valueOf);
        Boolean bool2 = Boolean.TRUE;
        if (Intrinsics.areEqual(bool, bool2)) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                QLog.i("ZPlanAioHeadEffectRefresher", 1, "prepareZPlanAvatarInfoV2, appRuntime is null, return.");
                return;
            }
            IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IProfileDataService.class, "all");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026ava, ProcessConstant.ALL)");
            Card profileCard = ((IProfileDataService) runtimeService).getProfileCard(valueOf, true);
            String str = profileCard.zplanGander;
            if (!(str == null || str.length() == 0)) {
                String str2 = profileCard.zplanAppearanceKey;
                if (!(str2 == null || str2.length() == 0)) {
                    config.C(Intrinsics.areEqual("1", profileCard.zplanGander));
                    config.v(profileCard.zplanAppearanceKey);
                    E(request, config, faceDrawable);
                    return;
                }
            }
            QLog.i("ZPlanAioHeadEffectRefresher", 1, "prepareZPlanAvatarInfoV2, zplanGander: " + profileCard.zplanGander + ", zplanAvatarBackgroundUrl: " + profileCard.zplanAvatarBackgroundUrl + ", return.");
            return;
        }
        I(request, config, faceDrawable);
        map.put(valueOf, bool2);
    }

    private final void E(final com.tencent.qqnt.aio.refresher.b request, final com.tencent.mobileqq.zplan.easteregg.a config, final Drawable faceDrawable) {
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: fh3.e
            @Override // java.lang.Runnable
            public final void run() {
                g.F(com.tencent.qqnt.aio.refresher.b.this, config, this, faceDrawable);
            }
        }, request.c().getMsgRecord().msgType == 10 ? 500L : 0L);
    }

    private final void G(final com.tencent.qqnt.aio.refresher.b request, final com.tencent.mobileqq.zplan.easteregg.a config, final Drawable faceDrawable) {
        ArrayList arrayListOf;
        final long j3 = request.c().getMsgRecord().senderUin;
        ArrayList<Long> arrayList = new ArrayList<>();
        try {
            arrayList.add(Long.valueOf(j3));
            com.tencent.mobileqq.zplan.model.c cVar = new com.tencent.mobileqq.zplan.model.c(17, 1);
            com.tencent.mobileqq.zplan.model.c cVar2 = new com.tencent.mobileqq.zplan.model.c(ProfileContants.FIELD_IS_ZPLAN_AVATAR, 6);
            com.tencent.mobileqq.zplan.model.c cVar3 = new com.tencent.mobileqq.zplan.model.c(45140, 3);
            IZPlanRequest iZPlanRequest = (IZPlanRequest) QRoute.api(IZPlanRequest.class);
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(cVar, cVar2, cVar3);
            iZPlanRequest.requestOidb1127(arrayListOf, arrayList, 18, new l() { // from class: fh3.f
                @Override // nk3.l
                public final void onResult(HashMap hashMap) {
                    g.H(j3, config, this, request, faceDrawable, hashMap);
                }
            });
        } catch (NumberFormatException e16) {
            QLog.e("ZPlanAioHeadEffectRefresher", 1, "requestZPlanInfoV1 NumberFormatException, " + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(long j3, com.tencent.mobileqq.zplan.easteregg.a config, g this$0, com.tencent.qqnt.aio.refresher.b request, Drawable faceDrawable, HashMap hashMap) {
        Intrinsics.checkNotNullParameter(config, "$config");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(request, "$request");
        Intrinsics.checkNotNullParameter(faceDrawable, "$faceDrawable");
        if (hashMap != null && !hashMap.isEmpty()) {
            for (Map.Entry entry : hashMap.entrySet()) {
                Object value = entry.getValue();
                Intrinsics.checkNotNullExpressionValue(value, "avatarInfo.value");
                HashMap hashMap2 = (HashMap) value;
                if (!Intrinsics.areEqual(String.valueOf(j3), String.valueOf(entry.getKey()))) {
                    QLog.i("ZPlanAioHeadEffectRefresher", 1, "requestZPlanInfoV1, uin error, return.");
                } else {
                    AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                    if (peekAppRuntime == null) {
                        QLog.i("ZPlanAioHeadEffectRefresher", 1, "requestZPlanInfoV1, appRuntime is null, return.");
                    } else {
                        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IProfileDataService.class, "all");
                        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026ava, ProcessConstant.ALL)");
                        Card profileCard = ((IProfileDataService) runtimeService).getProfileCard(String.valueOf(j3), true);
                        if (Intrinsics.areEqual(hashMap2.get(Integer.valueOf(ProfileContants.FIELD_IS_ZPLAN_AVATAR)), "0")) {
                            profileCard.isZPlanAvatar = false;
                            QLog.i("ZPlanAioHeadEffectRefresher", 1, "requestZPlanInfoV1, isZPlanAvatar is false, return.");
                            return;
                        }
                        config.C(Intrinsics.areEqual("1", hashMap2.get(45140)));
                        this$0.z((String) hashMap2.get(17), config);
                        profileCard.zplanAvatarBackgroundUrl = config.getBackgroundUrl();
                        profileCard.zplanGander = (String) hashMap2.get(45140);
                        profileCard.zplanAppearanceKey = config.getAppearanceKey();
                        profileCard.isZPlanAvatar = true;
                        this$0.E(request, config, faceDrawable);
                    }
                }
            }
            return;
        }
        QLog.i("ZPlanAioHeadEffectRefresher", 1, "requestZPlanInfoV1, map is null, return.");
    }

    private final void I(final com.tencent.qqnt.aio.refresher.b request, final com.tencent.mobileqq.zplan.easteregg.a config, final Drawable faceDrawable) {
        ArrayList arrayListOf;
        ArrayList<Long> arrayList = new ArrayList<>();
        final AIOMsgItem c16 = request.c();
        try {
            arrayList.add(Long.valueOf(c16.getMsgRecord().senderUin));
            com.tencent.mobileqq.zplan.model.c cVar = new com.tencent.mobileqq.zplan.model.c(17, 1);
            com.tencent.mobileqq.zplan.model.c cVar2 = new com.tencent.mobileqq.zplan.model.c(45140, 3);
            IZPlanRequest iZPlanRequest = (IZPlanRequest) QRoute.api(IZPlanRequest.class);
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(cVar, cVar2);
            iZPlanRequest.requestOidb1127(arrayListOf, arrayList, 18, new l() { // from class: fh3.d
                @Override // nk3.l
                public final void onResult(HashMap hashMap) {
                    g.J(AIOMsgItem.this, config, this, request, faceDrawable, hashMap);
                }
            });
        } catch (NumberFormatException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(AIOMsgItem msgItem, com.tencent.mobileqq.zplan.easteregg.a config, g this$0, com.tencent.qqnt.aio.refresher.b request, Drawable faceDrawable, HashMap hashMap) {
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        Intrinsics.checkNotNullParameter(config, "$config");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(request, "$request");
        Intrinsics.checkNotNullParameter(faceDrawable, "$faceDrawable");
        if (hashMap != null && !hashMap.isEmpty()) {
            for (Map.Entry entry : hashMap.entrySet()) {
                Object value = entry.getValue();
                Intrinsics.checkNotNullExpressionValue(value, "avatarInfo.value");
                HashMap hashMap2 = (HashMap) value;
                if (!Intrinsics.areEqual(String.valueOf(msgItem.getMsgRecord().senderUin), String.valueOf(entry.getKey()))) {
                    QLog.i("ZPlanAioHeadEffectRefresher", 1, "requestZPlanInfoV2, uin error, return.");
                } else {
                    AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                    if (peekAppRuntime == null) {
                        QLog.i("ZPlanAioHeadEffectRefresher", 1, "requestZPlanInfoV2, appRuntime is null, return.");
                    } else {
                        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IProfileDataService.class, "all");
                        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026ant.ALL\n                )");
                        Card profileCard = ((IProfileDataService) runtimeService).getProfileCard(String.valueOf(msgItem.getMsgRecord().senderUin), true);
                        config.C(Intrinsics.areEqual("1", hashMap2.get(45140)));
                        this$0.A((String) hashMap2.get(17), config);
                        profileCard.zplanGander = (String) hashMap2.get(45140);
                        profileCard.zplanAppearanceKey = config.getAppearanceKey();
                        this$0.E(request, config, faceDrawable);
                    }
                }
            }
            return;
        }
        QLog.i("ZPlanAioHeadEffectRefresher", 1, "requestZPlanInfoV2, map is null, return.");
    }

    private final com.tencent.mobileqq.zplan.easteregg.a r(AIOMsgItem msgItem) {
        String joinToString$default;
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(msgItem.Q(), null, null, null, 0, null, null, 63, null);
        return ((IZPlanApi) QRoute.api(IZPlanApi.class)).getMatchKeywordEasterEggConfig(joinToString$default, msgItem.getMsgRecord().msgType);
    }

    private final boolean s(AIOMsgItem item) {
        int i3 = item.v().chatType;
        if (i3 == 1) {
            if (!com.tencent.mobileqq.aio.utils.d.Z(item) && !com.tencent.mobileqq.aio.utils.d.e0(item) && !y(item)) {
                QLog.e("ZPlanAioHeadEffectRefresher", 2, "checkMessage is not TextMsgItem or isWalletMsg or isC2CGiftMsg, retrun false.");
                return false;
            }
            ZPlanHeaderEffectUtil zPlanHeaderEffectUtil = ZPlanHeaderEffectUtil.f332844a;
            if (zPlanHeaderEffectUtil.a(item.getMsgRecord()) == 1) {
                QLog.e("ZPlanAioHeadEffectRefresher", 2, "checkMessage has play, return false");
                return false;
            }
            zPlanHeaderEffectUtil.d(item.getMsgRecord(), true);
            return true;
        }
        if (i3 != 2) {
            return false;
        }
        if (item.getMsgRecord().sendStatus != 0 && item.getMsgRecord().sendStatus != 0) {
            if (!com.tencent.mobileqq.aio.utils.d.Z(item) && !com.tencent.mobileqq.aio.utils.d.e0(item) && !com.tencent.mobileqq.aio.utils.d.P(item.getMsgRecord())) {
                QLog.e("ZPlanAioHeadEffectRefresher", 1, "checkMessage is not TextMsgItem or isWalletMsg or isQunTextGiftMsg, retrun false.");
                return false;
            }
            ZPlanHeaderEffectUtil zPlanHeaderEffectUtil2 = ZPlanHeaderEffectUtil.f332844a;
            if (zPlanHeaderEffectUtil2.a(item.getMsgRecord()) == 1) {
                QLog.e("ZPlanAioHeadEffectRefresher", 2, "checkMessage has play, return false");
                return false;
            }
            zPlanHeaderEffectUtil2.d(item.getMsgRecord(), true);
            return true;
        }
        QLog.e("ZPlanAioHeadEffectRefresher", 2, "checkMessage msg sending or failed, return false.");
        return false;
    }

    private final boolean t(AIOMsgItem item) {
        return !(String.valueOf(item.getMsgRecord().senderUin).length() == 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(final g this$0, final AIOMsgItem msgItem, final com.tencent.mobileqq.aio.msglist.holder.external.h request) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        Intrinsics.checkNotNullParameter(request, "$request");
        if (((IZPlanHeadEffectUtil) QRoute.api(IZPlanHeadEffectUtil.class)).enable("aio")) {
            if (!this$0.t(msgItem)) {
                QLog.e("ZPlanAioHeadEffectRefresher", 1, "getEggView checkUin false, retrun.");
                return;
            }
            final com.tencent.mobileqq.zplan.easteregg.a r16 = this$0.r(msgItem);
            if (r16 != null && this$0.s(msgItem)) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: fh3.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        g.v(com.tencent.mobileqq.aio.msglist.holder.external.h.this, msgItem, r16, this$0);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(final com.tencent.mobileqq.aio.msglist.holder.external.h request, final AIOMsgItem msgItem, final com.tencent.mobileqq.zplan.easteregg.a aVar, final g this$0) {
        Intrinsics.checkNotNullParameter(request, "$request");
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        final Object a16 = ((com.tencent.qqnt.aio.refresher.b) request).a();
        if (!(a16 instanceof Drawable)) {
            QLog.e("ZPlanAioHeadEffectRefresher", 1, "getEggView drawable fail return");
        } else if (!(a16 instanceof IZplanOutboundAvatar)) {
            QLog.e("ZPlanAioHeadEffectRefresher", 1, "getEggView zplanOutboundAvatar fail return");
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: fh3.c
                @Override // java.lang.Runnable
                public final void run() {
                    g.w(a16, msgItem, aVar, this$0, request);
                }
            }, 16, null, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(Object faceDrawable, AIOMsgItem msgItem, com.tencent.mobileqq.zplan.easteregg.a aVar, g this$0, com.tencent.mobileqq.aio.msglist.holder.external.h request) {
        boolean isShowZplanOutboundAvatar;
        Intrinsics.checkNotNullParameter(faceDrawable, "$faceDrawable");
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(request, "$request");
        IZplanOutboundAvatar iZplanOutboundAvatar = (IZplanOutboundAvatar) faceDrawable;
        iZplanOutboundAvatar.preloadOutboundResource();
        int zPlanEasterEggSupportVersion = ((IZPlanFeatureSwitchHelper) QRoute.api(IZPlanFeatureSwitchHelper.class)).getZPlanEasterEggSupportVersion();
        if (zPlanEasterEggSupportVersion == 0) {
            isShowZplanOutboundAvatar = iZplanOutboundAvatar.isShowZplanOutboundAvatar();
        } else if (zPlanEasterEggSupportVersion == 1) {
            isShowZplanOutboundAvatar = iZplanOutboundAvatar.isSupportZPlanOutboundAvatar();
        } else {
            if (zPlanEasterEggSupportVersion != 2) {
                return;
            }
            isShowZplanOutboundAvatar = iZplanOutboundAvatar.isShowZplanOutboundAvatar();
            if (!isShowZplanOutboundAvatar && iZplanOutboundAvatar.isSupportZPlanOutboundAvatar() && msgItem.isSelf()) {
                ((IZPlanApi) QRoute.api(IZPlanApi.class)).reportEasterEggPlaySuccess(aVar);
                return;
            }
        }
        String zPlanAvatarBackgroundUrl = iZplanOutboundAvatar.getZPlanAvatarBackgroundUrl();
        if (zPlanAvatarBackgroundUrl == null) {
            zPlanAvatarBackgroundUrl = "";
        }
        aVar.y(zPlanAvatarBackgroundUrl);
        aVar.F(isShowZplanOutboundAvatar);
        this$0.B((com.tencent.qqnt.aio.refresher.b) request, aVar, (Drawable) faceDrawable);
    }

    private final w x() {
        if (this.easterEggPlayerManager == null) {
            w createZPlanAvatarEasterEggManager = ((IZPlanApi) QRoute.api(IZPlanApi.class)).createZPlanAvatarEasterEggManager();
            this.easterEggPlayerManager = createZPlanAvatarEasterEggManager;
            if (createZPlanAvatarEasterEggManager != null) {
                createZPlanAvatarEasterEggManager.c(new b());
            }
        }
        return this.easterEggPlayerManager;
    }

    private final boolean y(AIOMsgItem item) {
        com.tencent.qqnt.msg.data.a parseArkModel;
        return com.tencent.mobileqq.aio.utils.d.u(item.getMsgRecord()) && (parseArkModel = ((IAIOMsgItemApi) QRoute.api(IAIOMsgItemApi.class)).parseArkModel(item)) != null && "com.tencent.giftmall.giftark".equals(parseArkModel.d());
    }

    private final void z(String avatarInfo, com.tencent.mobileqq.zplan.easteregg.a config) {
        if (config != null) {
            if (avatarInfo == null || avatarInfo.length() == 0) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(avatarInfo);
                String optString = jSONObject.optString("background_image_url", "");
                Intrinsics.checkNotNullExpressionValue(optString, "avatarInfoJson.optString\u2026ackground_image_url\", \"\")");
                config.y(optString);
                config.v(jSONObject.optString("appearance_key", ""));
            } catch (Exception e16) {
                QLog.w("ZPlanAioHeadEffectRefresher", 1, "parseAvatarInfo " + e16);
            }
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.external.c
    public void c(final com.tencent.mobileqq.aio.msglist.holder.external.h request) {
        Intrinsics.checkNotNullParameter(request, "request");
        if (!(request instanceof com.tencent.qqnt.aio.refresher.b)) {
            QLog.i("ZPlanAioHeadEffectRefresher", 1, "[getData]");
            return;
        }
        com.tencent.qqnt.aio.refresher.b bVar = (com.tencent.qqnt.aio.refresher.b) request;
        Context b16 = bVar.b();
        final AIOMsgItem c16 = bVar.c();
        this.atmosphereHeight = BaseAIOUtils.f(197.0f, b16.getResources());
        this.headEffectViewHeight = BaseAIOUtils.f(64.0f, b16.getResources());
        this.headEffectViewWidth = BaseAIOUtils.f(72.0f, b16.getResources());
        this.avatarViewSize = b16.getResources().getDimensionPixelSize(R.dimen.f158194bz1);
        this.avatarTopMargin = b16.getResources().getDimensionPixelSize(R.dimen.bzt);
        this.avatarHorizontalMargin = b16.getResources().getDimensionPixelSize(R.dimen.bzr);
        this.checkBoxSize = b16.getResources().getDimensionPixelSize(R.dimen.c0p);
        this.checkBoxSizeLeftMargin = b16.getResources().getDimensionPixelSize(R.dimen.c0o);
        int f16 = BaseAIOUtils.f(16.0f, b16.getResources());
        this.designSpacing = f16;
        int i3 = ((this.avatarViewSize / 2) + this.avatarHorizontalMargin) - (this.headEffectViewWidth / 2);
        this.headEffectHorizontalMargin = i3;
        this.headEffectHorizontalMarginWithCheckBox = this.checkBoxSize + this.checkBoxSizeLeftMargin + i3;
        this.headEffectTopMargin = this.avatarTopMargin - f16;
        this.headEffectBottomMargin = -BaseAIOUtils.f(2.0f, b16.getResources());
        ThreadManagerV2.excute(new Runnable() { // from class: fh3.a
            @Override // java.lang.Runnable
            public final void run() {
                g.u(g.this, c16, request);
            }
        }, 16, null, true);
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.external.c
    protected void d(MsgIntent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof AIOMsgListEvent.MultiSelectModeChangeEvent) {
            QLog.i("ZPlanAioHeadEffectRefresher", 1, "[MultiSelectModeChangeEvent]: " + intent);
            View view = this.headEffectView;
            if (view != null) {
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams != null) {
                    Intrinsics.checkNotNullExpressionValue(layoutParams, "layoutParams");
                    K(false, ((AIOMsgListEvent.MultiSelectModeChangeEvent) intent).b(), (FrameLayout.LayoutParams) layoutParams);
                }
                view.requestLayout();
            }
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.external.c
    protected List<String> g() {
        List<String> mutableListOf;
        String qualifiedName = Reflection.getOrCreateKotlinClass(AIOMsgListEvent.MultiSelectModeChangeEvent.class).getQualifiedName();
        Intrinsics.checkNotNull(qualifiedName);
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(qualifiedName);
        return mutableListOf;
    }

    private final void K(boolean isSelf, boolean isSelectMode, FrameLayout.LayoutParams layoutParams) {
        int i3;
        if (isSelf) {
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = this.headEffectHorizontalMargin;
        } else {
            if (isSelectMode) {
                i3 = this.headEffectHorizontalMarginWithCheckBox;
            } else {
                i3 = this.headEffectHorizontalMargin;
            }
            layoutParams.leftMargin = i3;
            layoutParams.rightMargin = 0;
        }
        layoutParams.topMargin = this.headEffectTopMargin;
        layoutParams.bottomMargin = this.headEffectBottomMargin;
    }

    private final void A(String avatarInfo, com.tencent.mobileqq.zplan.easteregg.a config) {
        if (config != null) {
            if (avatarInfo == null || avatarInfo.length() == 0) {
                return;
            }
            try {
                config.v(new JSONObject(avatarInfo).optString("appearance_key", ""));
            } catch (Exception e16) {
                QLog.e("ZPlanAioHeadEffectRefresher", 1, "parseAvatarInfo " + e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(com.tencent.qqnt.aio.refresher.b request, com.tencent.mobileqq.zplan.easteregg.a config, g this$0, Drawable faceDrawable) {
        String valueOf;
        View view;
        View view2;
        View view3;
        Intrinsics.checkNotNullParameter(request, "$request");
        Intrinsics.checkNotNullParameter(config, "$config");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(faceDrawable, "$faceDrawable");
        AIOMsgItem c16 = request.c();
        QLog.i("ZPlanAioHeadEffectRefresher", 1, "setZPlanHeadEffect, " + c16.getMsgId());
        String valueOf2 = String.valueOf(c16.getMsgRecord().senderUin);
        int portraitID = config.getPortraitID();
        String portraitName = config.getPortraitName();
        int i3 = c16.getMsgRecord().chatType;
        if (c16.getMsgRecord().chatType == 2) {
            valueOf = c16.getMsgRecord().guildId;
        } else {
            valueOf = String.valueOf(c16.getMsgRecord().peerUin);
        }
        String str = valueOf;
        Intrinsics.checkNotNullExpressionValue(str, "if (msgItem.msgRecord.ch\u2026Record.peerUin.toString()");
        u.EasterEggReportParam easterEggReportParam = new u.EasterEggReportParam(valueOf2, portraitID, portraitName, i3, str, 0L, false, 96, null);
        ((IZPlanApi) QRoute.api(IZPlanApi.class)).createEasterEggDaTongReporter().a(easterEggReportParam);
        w x16 = this$0.x();
        if (x16 == null || (view = x16.a(request.b())) == null) {
            view = null;
        } else {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this$0.headEffectViewWidth, this$0.headEffectViewHeight);
            this$0.K(c16.isSelf(), request.d(), layoutParams);
            view.setLayoutParams(layoutParams);
        }
        this$0.headEffectView = view;
        if (x16 == null || (view2 = x16.a(request.b())) == null) {
            view2 = null;
        } else {
            view2.setLayoutParams(new FrameLayout.LayoutParams(-1, this$0.atmosphereHeight));
        }
        if (x16 == null || (view3 = x16.a(request.b())) == null) {
            view3 = null;
        } else {
            view3.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        if (MobileQQ.sMobileQQ.peekAppRuntime() == null) {
            QLog.i("ZPlanAioHeadEffectRefresher", 1, "setZPlanHeadEffect, appRuntime is null, return.");
            return;
        }
        boolean isSelf = c16.isSelf();
        com.tencent.mobileqq.zplan.easteregg.model.c cVar = new com.tencent.mobileqq.zplan.easteregg.model.c(System.currentTimeMillis());
        cVar.v(this$0.headEffectView);
        cVar.t(view2);
        cVar.x(view3);
        cVar.z(faceDrawable);
        cVar.F(c16.getMsgId());
        cVar.y(config);
        cVar.H(String.valueOf(c16.getMsgRecord().senderUin));
        cVar.B(false);
        cVar.G(System.currentTimeMillis());
        cVar.w((isSelf && config.getShouldReverseForAvatar()) ? -1.0f : 1.0f);
        cVar.u((isSelf && config.getShouldReverseForEffect()) ? -1.0f : 1.0f);
        cVar.D(true);
        cVar.E(easterEggReportParam);
        this$0.e(new com.tencent.qqnt.aio.refresher.c(request.c().getMsgId(), new com.tencent.qqnt.aio.avatar.egg.a(0, this$0.headEffectView, view2, view3, 0, 16, null)));
        if (x16 != null) {
            x16.b(cVar);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.external.c
    public void h() {
    }
}
