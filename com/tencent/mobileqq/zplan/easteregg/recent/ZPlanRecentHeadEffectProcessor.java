package com.tencent.mobileqq.zplan.easteregg.recent;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.profilecard.api.IProfileDataService;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.zplan.aio.IZPlanHeadEffectUtil;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.easteregg.ZPlanHeaderEffectUtil;
import com.tencent.mobileqq.zplan.easteregg.w;
import com.tencent.mobileqq.zplan.servlet.api.IZPlanRequest;
import com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.core.adapter.holder.RecentContactItemBinding;
import com.tencent.qqnt.chats.core.adapter.holder.h;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CoroutineScope;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import nk3.l;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 =2\u00020\u0001:\u0001%B\u0007\u00a2\u0006\u0004\b;\u0010<J.\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J6\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J6\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J6\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J6\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\u001a\u0010\u0016\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0015\u001a\u00020\u0011H\u0002J\u0018\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0011H\u0002J8\u0010\u001a\u001a\u00020\u000b2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J'\u0010\u001b\u001a\u00020\u000b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u001e\u001a\u00020\u001dH\u0002J\u0010\u0010 \u001a\u00020\u001f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001b\u0010!\u001a\u00020\u001f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b!\u0010\"J \u0010%\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010$\u001a\u00020#H\u0016R\u001b\u0010)\u001a\u00020\u001f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001e\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u001e\u0010.\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010+R\u0014\u00101\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R \u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u000207068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006>"}, d2 = {"Lcom/tencent/mobileqq/zplan/easteregg/recent/ZPlanRecentHeadEffectProcessor;", "Lcom/tencent/qqnt/chats/inject/content/a;", "Lcom/tencent/mobileqq/zplan/easteregg/a;", DownloadInfo.spKey_Config, "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Ljava/lang/ref/WeakReference;", "Lcom/tencent/qqnt/chats/core/adapter/holder/h;", "view", "Landroid/widget/ImageView;", "avatar", "", "v", "Lcom/tencent/mobileqq/data/Card;", IndividuationUrlHelper.UrlId.CARD_HOME, "w", HippyTKDListViewAdapter.X, "", "uin", "y", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "avatarInfo", DomainData.DOMAIN_NAME, "o", "", "bubbleId", "t", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Ljava/lang/Long;Ljava/lang/ref/WeakReference;)V", "Landroid/widget/RelativeLayout$LayoutParams;", ReportConstant.COSTREPORT_PREFIX, "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", "(Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/qqnt/chats/core/adapter/holder/RecentContactItemBinding;", "binging", "a", "Lkotlin/Lazy;", "r", "()Z", "enableRecentHeadEffect", "b", "Ljava/lang/ref/WeakReference;", "contentViewRef", "c", "bindingRef", "d", "Z", "needZPlanOutBoundAvatar", "Lcom/tencent/mobileqq/zplan/easteregg/w;", "e", "Lcom/tencent/mobileqq/zplan/easteregg/w;", "zplanAvatarEasterEggManager", "", "Landroid/view/View;", "f", "Ljava/util/Map;", "easterEggViewMap", "<init>", "()V", "g", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanRecentHeadEffectProcessor extends com.tencent.qqnt.chats.inject.content.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Lazy enableRecentHeadEffect;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private WeakReference<h> contentViewRef;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private WeakReference<RecentContactItemBinding> bindingRef;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean needZPlanOutBoundAvatar;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private w zplanAvatarEasterEggManager;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Map<Long, View> easterEggViewMap;

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\u0007\u0010\u0006J!\u0010\n\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\f\u0010\u0006\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/zplan/easteregg/recent/ZPlanRecentHeadEffectProcessor$b", "Lcom/tencent/mobileqq/zplan/easteregg/w$a;", "", "bubbleId", "", "a", "(Ljava/lang/Long;)V", "d", "", "msgCode", "c", "(Ljava/lang/Long;I)V", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements w.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ WeakReference<h> f333001b;

        b(WeakReference<h> weakReference) {
            this.f333001b = weakReference;
        }

        @Override // com.tencent.mobileqq.zplan.easteregg.w.a
        public void a(Long bubbleId) {
            QLog.i("ZPlanRecentHeadEffectProcessor", 1, "onStart bubbleId: " + bubbleId);
        }

        @Override // com.tencent.mobileqq.zplan.easteregg.w.a
        public void b(Long bubbleId) {
            QLog.i("ZPlanRecentHeadEffectProcessor", 1, "onRelease bubbleId: " + bubbleId);
        }

        @Override // com.tencent.mobileqq.zplan.easteregg.w.a
        public void c(Long bubbleId, int msgCode) {
            QLog.i("ZPlanRecentHeadEffectProcessor", 1, "onError bubbleId: " + bubbleId);
            ZPlanRecentHeadEffectProcessor.this.A(bubbleId, this.f333001b);
        }

        @Override // com.tencent.mobileqq.zplan.easteregg.w.a
        public void d(Long bubbleId) {
            QLog.i("ZPlanRecentHeadEffectProcessor", 1, "onComplete bubbleId: " + bubbleId);
            ZPlanRecentHeadEffectProcessor.this.A(bubbleId, this.f333001b);
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JX\u0010\t\u001a\u00020\b2N\u0010\u0007\u001aJ\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0002\u0018\u00010\u0002j,\u0012\u0004\u0012\u00020\u0003\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0002j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\u0006\u0018\u0001`\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zplan/easteregg/recent/ZPlanRecentHeadEffectProcessor$c", "Lnk3/l;", "Ljava/util/HashMap;", "", "", "", "Lkotlin/collections/HashMap;", "usersInfoList", "", "onResult", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements l {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f333002a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zplan.easteregg.a f333003b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ZPlanRecentHeadEffectProcessor f333004c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ WeakReference<h> f333005d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ g f333006e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ WeakReference<ImageView> f333007f;

        c(String str, com.tencent.mobileqq.zplan.easteregg.a aVar, ZPlanRecentHeadEffectProcessor zPlanRecentHeadEffectProcessor, WeakReference<h> weakReference, g gVar, WeakReference<ImageView> weakReference2) {
            this.f333002a = str;
            this.f333003b = aVar;
            this.f333004c = zPlanRecentHeadEffectProcessor;
            this.f333005d = weakReference;
            this.f333006e = gVar;
            this.f333007f = weakReference2;
        }

        @Override // nk3.l
        public void onResult(HashMap<Long, HashMap<Integer, String>> usersInfoList) {
            if (usersInfoList != null && !usersInfoList.isEmpty()) {
                long parseLong = Long.parseLong(this.f333002a);
                if (!usersInfoList.containsKey(Long.valueOf(parseLong))) {
                    QLog.e("ZPlanRecentHeadEffectProcessor", 1, "requestZPlanAvatarInfoV1 usersInfoList is not contains uin: " + parseLong + ", return.");
                    return;
                }
                HashMap<Integer, String> hashMap = usersInfoList.get(Long.valueOf(parseLong));
                if (hashMap == null) {
                    QLog.e("ZPlanRecentHeadEffectProcessor", 1, "requestZPlanAvatarInfoV1 userInfo is null, return.");
                    return;
                }
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime == null) {
                    QLog.e("ZPlanRecentHeadEffectProcessor", 1, "requestZPlanAvatarInfoV1 app is null, return.");
                    return;
                }
                IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IProfileDataService.class, "all");
                Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(\n \u2026                        )");
                Card profileCard = ((IProfileDataService) runtimeService).getProfileCard(this.f333002a, true);
                if (!Intrinsics.areEqual("1", hashMap.get(Integer.valueOf(ProfileContants.FIELD_IS_ZPLAN_AVATAR)))) {
                    profileCard.isZPlanAvatar = false;
                    QLog.e("ZPlanRecentHeadEffectProcessor", 1, "requestZPlanAvatarInfoV1 isZPlanAvatar is false, return.");
                    return;
                }
                String str = hashMap.get(17);
                if (str != null) {
                    this.f333004c.n(this.f333003b, str);
                }
                this.f333003b.C(Intrinsics.areEqual("1", hashMap.get(45140)));
                profileCard.zplanAvatarBackgroundUrl = this.f333003b.getBackgroundUrl();
                profileCard.zplanGander = hashMap.get(45140);
                profileCard.zplanAppearanceKey = this.f333003b.getAppearanceKey();
                profileCard.isZPlanAvatar = true;
                this.f333004c.t(this.f333005d, this.f333003b, this.f333006e.s().contactId, String.valueOf(this.f333006e.s().senderUin), this.f333007f.get());
                return;
            }
            QLog.e("ZPlanRecentHeadEffectProcessor", 1, "requestZPlanAvatarInfoV1 usersInfoList is null or size is 0, return.");
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JX\u0010\t\u001a\u00020\b2N\u0010\u0007\u001aJ\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0002\u0018\u00010\u0002j,\u0012\u0004\u0012\u00020\u0003\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0002j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\u0006\u0018\u0001`\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zplan/easteregg/recent/ZPlanRecentHeadEffectProcessor$d", "Lnk3/l;", "Ljava/util/HashMap;", "", "", "", "Lkotlin/collections/HashMap;", "usersInfoList", "", "onResult", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements l {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f333008a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zplan.easteregg.a f333009b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ZPlanRecentHeadEffectProcessor f333010c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ WeakReference<h> f333011d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ g f333012e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ WeakReference<ImageView> f333013f;

        d(String str, com.tencent.mobileqq.zplan.easteregg.a aVar, ZPlanRecentHeadEffectProcessor zPlanRecentHeadEffectProcessor, WeakReference<h> weakReference, g gVar, WeakReference<ImageView> weakReference2) {
            this.f333008a = str;
            this.f333009b = aVar;
            this.f333010c = zPlanRecentHeadEffectProcessor;
            this.f333011d = weakReference;
            this.f333012e = gVar;
            this.f333013f = weakReference2;
        }

        @Override // nk3.l
        public void onResult(HashMap<Long, HashMap<Integer, String>> usersInfoList) {
            if (usersInfoList != null && !usersInfoList.isEmpty()) {
                long parseLong = Long.parseLong(this.f333008a);
                if (!usersInfoList.containsKey(Long.valueOf(parseLong))) {
                    QLog.e("ZPlanRecentHeadEffectProcessor", 1, "requestZPlanAvatarInfoV2 usersInfoList is not contains uin: " + parseLong + ", return.");
                    return;
                }
                HashMap<Integer, String> hashMap = usersInfoList.get(Long.valueOf(parseLong));
                if (hashMap == null) {
                    QLog.e("ZPlanRecentHeadEffectProcessor", 1, "requestZPlanAvatarInfoV2 userInfo is null, return.");
                    return;
                }
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime == null) {
                    QLog.e("ZPlanRecentHeadEffectProcessor", 1, "requestZPlanAvatarInfoV2 app is null, return.");
                    return;
                }
                IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IProfileDataService.class, "all");
                Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(\n \u2026ava, ProcessConstant.ALL)");
                Card profileCard = ((IProfileDataService) runtimeService).getProfileCard(this.f333008a, true);
                String str = hashMap.get(17);
                if (str != null) {
                    this.f333010c.o(this.f333009b, str);
                }
                this.f333009b.C(Intrinsics.areEqual("1", hashMap.get(45140)));
                profileCard.zplanAppearanceKey = this.f333009b.getAppearanceKey();
                profileCard.zplanGander = hashMap.get(45140);
                this.f333010c.t(this.f333011d, this.f333009b, this.f333012e.s().contactId, String.valueOf(this.f333012e.s().senderUin), this.f333013f.get());
                return;
            }
            QLog.e("ZPlanRecentHeadEffectProcessor", 1, "requestZPlanAvatarInfoV2 usersInfoList is null or size is 0, return.");
        }
    }

    public ZPlanRecentHeadEffectProcessor() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.zplan.easteregg.recent.ZPlanRecentHeadEffectProcessor$enableRecentHeadEffect$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(((IZPlanHeadEffectUtil) QRoute.api(IZPlanHeadEffectUtil.class)).enable(RecentUser.TABLE_NAME));
            }
        });
        this.enableRecentHeadEffect = lazy;
        this.needZPlanOutBoundAvatar = ((IZPlanFeatureSwitchHelper) QRoute.api(IZPlanFeatureSwitchHelper.class)).needOutBoundAvatar2EasterEgg();
        this.easterEggViewMap = new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A(final Long bubbleId, final WeakReference<h> view) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.easteregg.recent.a
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanRecentHeadEffectProcessor.B(ZPlanRecentHeadEffectProcessor.this, bubbleId, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(ZPlanRecentHeadEffectProcessor this$0, Long l3, WeakReference view) {
        h hVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "$view");
        View view2 = (View) TypeIntrinsics.asMutableMap(this$0.easterEggViewMap).remove(l3);
        if (view2 != null && (hVar = (h) view.get()) != null) {
            hVar.c(view2);
        }
        if (l3 != null) {
            long longValue = l3.longValue();
            w wVar = this$0.zplanAvatarEasterEggManager;
            if (wVar != null) {
                wVar.stop(longValue);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(com.tencent.mobileqq.zplan.easteregg.a config, String avatarInfo) {
        if (config == null || TextUtils.isEmpty(avatarInfo)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(avatarInfo);
            String optString = jSONObject.optString("background_image_url", "");
            Intrinsics.checkNotNullExpressionValue(optString, "avatarInfoJson.optString\u2026ackground_image_url\", \"\")");
            config.y(optString);
            config.v(jSONObject.optString("appearance_key", ""));
        } catch (Exception e16) {
            QLog.e("ZPlanRecentHeadEffectProcessor", 1, "addBackgroundUrlToConfigV1 exception, " + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(com.tencent.mobileqq.zplan.easteregg.a config, String avatarInfo) {
        if (TextUtils.isEmpty(avatarInfo)) {
            return;
        }
        try {
            config.v(new JSONObject(avatarInfo).optString("appearance_key", ""));
        } catch (Exception e16) {
            QLog.e("ZPlanRecentHeadEffectProcessor", 1, "addBackgroundUrlToConfigV2 exception, " + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object p(g gVar, Continuation<? super Boolean> continuation) {
        ZPlanRecentHeadEffectProcessor$checkMessage$1 zPlanRecentHeadEffectProcessor$checkMessage$1;
        Object coroutine_suspended;
        int i3;
        MsgRecord msgRecord;
        if (continuation instanceof ZPlanRecentHeadEffectProcessor$checkMessage$1) {
            zPlanRecentHeadEffectProcessor$checkMessage$1 = (ZPlanRecentHeadEffectProcessor$checkMessage$1) continuation;
            int i16 = zPlanRecentHeadEffectProcessor$checkMessage$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                zPlanRecentHeadEffectProcessor$checkMessage$1.label = i16 - Integer.MIN_VALUE;
                ZPlanRecentHeadEffectProcessor$checkMessage$1 zPlanRecentHeadEffectProcessor$checkMessage$12 = zPlanRecentHeadEffectProcessor$checkMessage$1;
                Object obj = zPlanRecentHeadEffectProcessor$checkMessage$12.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = zPlanRecentHeadEffectProcessor$checkMessage$12.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    ZPlanHeaderEffectUtil zPlanHeaderEffectUtil = ZPlanHeaderEffectUtil.f332844a;
                    int n3 = gVar.n();
                    String str = gVar.s().peerUid;
                    Intrinsics.checkNotNullExpressionValue(str, "item.originData.peerUid");
                    long j3 = gVar.s().msgId;
                    zPlanRecentHeadEffectProcessor$checkMessage$12.L$0 = gVar;
                    zPlanRecentHeadEffectProcessor$checkMessage$12.label = 1;
                    obj = zPlanHeaderEffectUtil.b(n3, str, j3, zPlanRecentHeadEffectProcessor$checkMessage$12);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    gVar = (g) zPlanRecentHeadEffectProcessor$checkMessage$12.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                msgRecord = (MsgRecord) obj;
                if (msgRecord != null) {
                    QLog.e("ZPlanRecentHeadEffectProcessor", 2, "checkMessage msgRecord is null, return false");
                    return Boxing.boxBoolean(false);
                }
                int n16 = gVar.n();
                if (n16 != 1) {
                    if (n16 == 2 && !com.tencent.mobileqq.aio.utils.d.a0(msgRecord) && msgRecord.msgType != 10 && !com.tencent.mobileqq.aio.utils.d.P(msgRecord)) {
                        QLog.e("ZPlanRecentHeadEffectProcessor", 2, "checkMessage is not TextMsgItem or isWalletMsg or isQunTextGiftMsg, retrun false.");
                        return Boxing.boxBoolean(false);
                    }
                } else if (!com.tencent.mobileqq.aio.utils.d.a0(msgRecord) && msgRecord.msgType != 10 && !com.tencent.mobileqq.aio.utils.d.u(msgRecord)) {
                    QLog.e("ZPlanRecentHeadEffectProcessor", 2, "checkMessage is not TextMsgItem or isWalletMsg or isC2CGiftMsg, retrun false.");
                    return Boxing.boxBoolean(false);
                }
                ZPlanHeaderEffectUtil zPlanHeaderEffectUtil2 = ZPlanHeaderEffectUtil.f332844a;
                if (zPlanHeaderEffectUtil2.a(msgRecord) == 1) {
                    QLog.e("ZPlanRecentHeadEffectProcessor", 2, "checkMessage aio has play, return false");
                    return Boxing.boxBoolean(false);
                }
                if (zPlanHeaderEffectUtil2.c(msgRecord) == 1) {
                    QLog.e("ZPlanRecentHeadEffectProcessor", 2, "checkMessage recent has play, return false");
                    return Boxing.boxBoolean(false);
                }
                zPlanHeaderEffectUtil2.e(msgRecord, true);
                return Boxing.boxBoolean(true);
            }
        }
        zPlanRecentHeadEffectProcessor$checkMessage$1 = new ZPlanRecentHeadEffectProcessor$checkMessage$1(this, continuation);
        ZPlanRecentHeadEffectProcessor$checkMessage$1 zPlanRecentHeadEffectProcessor$checkMessage$122 = zPlanRecentHeadEffectProcessor$checkMessage$1;
        Object obj2 = zPlanRecentHeadEffectProcessor$checkMessage$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = zPlanRecentHeadEffectProcessor$checkMessage$122.label;
        if (i3 != 0) {
        }
        msgRecord = (MsgRecord) obj2;
        if (msgRecord != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean q(g item) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e("ZPlanRecentHeadEffectProcessor", 1, "checkUin app is null, return false");
            return false;
        }
        long longAccountUin = peekAppRuntime.getLongAccountUin();
        long j3 = item.s().senderUin;
        if (longAccountUin != j3) {
            return true;
        }
        QLog.e("ZPlanRecentHeadEffectProcessor", 4, "checkUin " + longAccountUin + ", " + j3 + ", self uin, return false");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean r() {
        return ((Boolean) this.enableRecentHeadEffect.getValue()).booleanValue();
    }

    private final RelativeLayout.LayoutParams s() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewUtils.dpToPx(94.0f), ViewUtils.dpToPx(84.0f));
        layoutParams.addRule(9, -1);
        layoutParams.addRule(12, -1);
        layoutParams.leftMargin = ViewUtils.dpToPx(-5.0f);
        layoutParams.topMargin = ViewUtils.dpToPx(-21.0f);
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(final WeakReference<h> view, final com.tencent.mobileqq.zplan.easteregg.a config, final long bubbleId, final String uin, final ImageView avatar) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.easteregg.recent.b
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanRecentHeadEffectProcessor.u(ZPlanRecentHeadEffectProcessor.this, view, uin, bubbleId, config, avatar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(ZPlanRecentHeadEffectProcessor this$0, WeakReference view, String uin, long j3, com.tencent.mobileqq.zplan.easteregg.a config, ImageView imageView) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "$view");
        Intrinsics.checkNotNullParameter(uin, "$uin");
        Intrinsics.checkNotNullParameter(config, "$config");
        QLog.i("ZPlanRecentHeadEffectProcessor", 1, "playZplanEffect");
        if (this$0.zplanAvatarEasterEggManager == null) {
            w createZPlanAvatarEasterEggManager = ((IZPlanApi) QRoute.api(IZPlanApi.class)).createZPlanAvatarEasterEggManager();
            createZPlanAvatarEasterEggManager.c(new b(view));
            this$0.zplanAvatarEasterEggManager = createZPlanAvatarEasterEggManager;
        }
        w wVar = this$0.zplanAvatarEasterEggManager;
        View view2 = null;
        if (wVar != null) {
            h hVar = (h) view.get();
            view2 = wVar.a(hVar != null ? hVar.b() : null);
        }
        h hVar2 = (h) view.get();
        if (hVar2 != null) {
            hVar2.a(view2, this$0.s());
        }
        if (view2 != null) {
            view2.setTag(new String[]{uin, String.valueOf(j3)});
        }
        if (view2 != null) {
            this$0.easterEggViewMap.put(Long.valueOf(j3), view2);
        }
        com.tencent.mobileqq.zplan.easteregg.model.c cVar = new com.tencent.mobileqq.zplan.easteregg.model.c(System.currentTimeMillis());
        cVar.v(view2);
        cVar.y(config);
        cVar.H(uin);
        cVar.F(j3);
        cVar.w(1.0f);
        cVar.G(System.currentTimeMillis());
        cVar.B(true);
        cVar.D(false);
        cVar.A(imageView);
        w wVar2 = this$0.zplanAvatarEasterEggManager;
        if (wVar2 != null) {
            wVar2.b(cVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(com.tencent.mobileqq.zplan.easteregg.a config, g item, WeakReference<h> view, ImageView avatar) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.i("ZPlanRecentHeadEffectProcessor", 1, "updateContent, app is null, return.");
            return;
        }
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IProfileDataService.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(\n \u2026essConstant.ALL\n        )");
        Card card = ((IProfileDataService) runtimeService).getProfileCard(String.valueOf(item.s().senderUin), true);
        QLog.i("ZPlanRecentHeadEffectProcessor", 1, "updateContent, card: " + card);
        if (config.getIsOutBoundAvatar() && !TextUtils.isEmpty(config.getBackgroundUrl())) {
            Intrinsics.checkNotNullExpressionValue(card, "card");
            x(card, config, item, view, avatar);
        } else {
            if (this.needZPlanOutBoundAvatar) {
                return;
            }
            Intrinsics.checkNotNullExpressionValue(card, "card");
            w(card, config, item, view, avatar);
        }
    }

    private final void w(Card card, com.tencent.mobileqq.zplan.easteregg.a config, g item, WeakReference<h> view, ImageView avatar) {
        QLog.i("ZPlanRecentHeadEffectProcessor", 1, "prepareZPlanAvatarInfoV1, hasRequestZPlanAvatarInfo: " + card.hasRequestZPlanAvatarInfo);
        if (card.hasRequestZPlanAvatarInfo) {
            boolean z16 = card.isZPlanAvatar;
            if (!z16) {
                QLog.i("ZPlanRecentHeadEffectProcessor", 1, "prepareZPlanAvatarInfoV1\uff0cisZPlanAvatar: " + z16 + ", return.");
                return;
            }
            if (!TextUtils.isEmpty(card.zplanGander) && !TextUtils.isEmpty(card.zplanAvatarBackgroundUrl)) {
                config.C(Intrinsics.areEqual("1", card.zplanGander));
                String str = card.zplanAvatarBackgroundUrl;
                Intrinsics.checkNotNullExpressionValue(str, "card.zplanAvatarBackgroundUrl");
                config.y(str);
                config.v(card.zplanAppearanceKey);
                t(view, config, item.s().contactId, String.valueOf(item.s().senderUin), avatar);
                return;
            }
            QLog.i("ZPlanRecentHeadEffectProcessor", 1, "prepareZPlanAvatarInfoV1\uff0czplanGander: " + card.zplanGander + ", zplanAppearanceKey: " + card.zplanAppearanceKey + ", return.");
            return;
        }
        y(String.valueOf(item.s().senderUin), item, view, config, avatar);
        card.hasRequestZPlanAvatarInfo = true;
    }

    private final void x(Card card, com.tencent.mobileqq.zplan.easteregg.a config, g item, WeakReference<h> view, ImageView avatar) {
        QLog.i("ZPlanRecentHeadEffectProcessor", 1, "prepareZPlanAvatarInfoV2, hasRequestZPlanAvatarInfo: " + card.hasRequestZPlanAvatarInfo);
        if (card.hasRequestZPlanAvatarInfo) {
            if (!TextUtils.isEmpty(card.zplanGander) && !TextUtils.isEmpty(card.zplanAppearanceKey)) {
                config.C(Intrinsics.areEqual("1", card.zplanGander));
                config.v(card.zplanAppearanceKey);
                t(view, config, item.s().msgId, String.valueOf(item.s().senderUin), avatar);
                return;
            }
            QLog.i("ZPlanRecentHeadEffectProcessor", 1, "prepareZPlanAvatarInfoV2\uff0czplanGander: " + card.zplanGander + ", zplanAppearanceKey: " + card.zplanAppearanceKey + ", return.");
            return;
        }
        z(String.valueOf(item.s().senderUin), item, view, config, avatar);
        card.hasRequestZPlanAvatarInfo = true;
    }

    private final void y(String uin, g item, WeakReference<h> view, com.tencent.mobileqq.zplan.easteregg.a config, ImageView avatar) {
        List listOf;
        WeakReference weakReference = new WeakReference(avatar);
        ArrayList<Long> arrayList = new ArrayList<>();
        try {
            arrayList.add(Long.valueOf(Long.parseLong(uin)));
            com.tencent.mobileqq.zplan.model.c cVar = new com.tencent.mobileqq.zplan.model.c(17, 1);
            com.tencent.mobileqq.zplan.model.c cVar2 = new com.tencent.mobileqq.zplan.model.c(ProfileContants.FIELD_IS_ZPLAN_AVATAR, 6);
            com.tencent.mobileqq.zplan.model.c cVar3 = new com.tencent.mobileqq.zplan.model.c(45140, 3);
            IZPlanRequest iZPlanRequest = (IZPlanRequest) QRoute.api(IZPlanRequest.class);
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.mobileqq.zplan.model.c[]{cVar, cVar2, cVar3});
            iZPlanRequest.requestOidb1127(new ArrayList(listOf), arrayList, 18, new c(uin, config, this, view, item, weakReference));
        } catch (NumberFormatException e16) {
            QLog.e("ZPlanRecentHeadEffectProcessor", 1, "requestZPlanAvatarInfoV1 exception, " + e16);
        }
    }

    private final void z(String uin, g item, WeakReference<h> view, com.tencent.mobileqq.zplan.easteregg.a config, ImageView avatar) {
        List listOf;
        WeakReference weakReference = new WeakReference(avatar);
        ArrayList<Long> arrayList = new ArrayList<>();
        try {
            arrayList.add(Long.valueOf(Long.parseLong(uin)));
            com.tencent.mobileqq.zplan.model.c cVar = new com.tencent.mobileqq.zplan.model.c(17, 1);
            com.tencent.mobileqq.zplan.model.c cVar2 = new com.tencent.mobileqq.zplan.model.c(45140, 3);
            IZPlanRequest iZPlanRequest = (IZPlanRequest) QRoute.api(IZPlanRequest.class);
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.mobileqq.zplan.model.c[]{cVar, cVar2});
            iZPlanRequest.requestOidb1127(new ArrayList(listOf), arrayList, 18, new d(uin, config, this, view, item, weakReference));
        } catch (NumberFormatException e16) {
            QLog.e("ZPlanRecentHeadEffectProcessor", 1, "requestZPlanAvatarInfoV2 exception, " + e16);
        }
    }

    @Override // com.tencent.qqnt.chats.inject.content.a
    public void a(g item, h view, RecentContactItemBinding binging) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(binging, "binging");
        this.contentViewRef = new WeakReference<>(view);
        this.bindingRef = new WeakReference<>(binging);
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.d.f261782e);
        if (f16 != null) {
            CorountineFunKt.e(f16, "ZPlanRecentHeadEffectProcessor_updateContent", null, null, null, new ZPlanRecentHeadEffectProcessor$updateContent$1(this, item, null), 14, null);
        }
    }
}
