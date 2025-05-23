package com.tencent.qqnt.aio.helper;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.event.AIOTitleEvent;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.listentogether.ListenTogetherSession;
import com.tencent.mobileqq.listentogether.nt.ListenTogetherHelper;
import com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi;
import com.tencent.mobileqq.onlinestatus.music.OnlineStatusLyricView;
import com.tencent.mobileqq.onlinestatus.utils.OnlineStatusToggleUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.richstatus.SignatureHistoryFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.CustomOnlineStatusManager;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.helper.C2CSubTitleHelper;
import com.tencent.qqnt.ntrelation.onlinestatusinfo.api.IOnlineStatusInfoService;
import friendlist.GetOnlineInfoResp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 E2\u00020\u00012\u00020\u0002:\u0001FB\u0007\u00a2\u0006\u0004\bC\u0010DJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0003H\u0002J\b\u0010\r\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0002J$\u0010\u0012\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u001a\u0010\u0016\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J \u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001c\u001a\u00020\u0003H\u0002J\b\u0010\u001d\u001a\u00020\tH\u0016J\b\u0010\u001e\u001a\u00020\u0010H\u0016J\b\u0010 \u001a\u00020\u001fH\u0016J\u0010\u0010#\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020!H\u0016J\u0010\u0010%\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\tH\u0016J\b\u0010&\u001a\u00020\u0003H\u0016R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00103\u001a\u00020/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u00101R\u001e\u00106\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u00105R\u001b\u0010:\u001a\u00020/8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u00107\u001a\u0004\b8\u00109R\u0014\u0010>\u001a\u00020;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0014\u0010B\u001a\u00020?8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010A\u00a8\u0006G"}, d2 = {"Lcom/tencent/qqnt/aio/helper/C2CSubTitleHelper;", "Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/mvi/base/route/g;", "", tl.h.F, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "k", "", "type", "o", DomainData.DOMAIN_NAME, ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/qqnt/ntrelation/onlinestatusinfo/bean/c;", "simpleInfo", "", "uin", "v", "Lcom/tencent/mobileqq/listentogether/nt/ListenTogetherHelper;", "listenTogetherHelper", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "t", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "Lcom/tencent/mobileqq/onlinestatus/au;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "r", "p", "getId", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "state", "onMoveToState", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/aio/api/runtime/a;", "d", "Lcom/tencent/aio/api/runtime/a;", "mAIOContext", "Lcom/tencent/mobileqq/app/FriendListHandler;", "e", "Lcom/tencent/mobileqq/app/FriendListHandler;", "mFriendListHandler", "", "f", "Z", "mIsSelectedMode", "hasReqNTOnlineStatus", "Lhx3/b;", "Lhx3/b;", "onlineStatusInfoCallback", "Lkotlin/Lazy;", "j", "()Z", "useOnlineStatusNTData", "Lcom/tencent/mvi/base/route/a;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mvi/base/route/a;", "mAction1", "Lcom/tencent/mobileqq/app/ar;", "D", "Lcom/tencent/mobileqq/app/ar;", "onlineStateObserver", "<init>", "()V", "E", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes34.dex */
public final class C2CSubTitleHelper implements com.tencent.aio.main.businesshelper.h, com.tencent.mvi.base.route.g {

    /* renamed from: E, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private final com.tencent.mvi.base.route.a mAction1;

    /* renamed from: D, reason: from kotlin metadata */
    private final com.tencent.mobileqq.app.ar onlineStateObserver;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a mAIOContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private FriendListHandler mFriendListHandler;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean mIsSelectedMode;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean hasReqNTOnlineStatus;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private hx3.b<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c> onlineStatusInfoCallback;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final Lazy useOnlineStatusNTData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/aio/helper/C2CSubTitleHelper$a;", "", "Lcom/tencent/qqnt/ntrelation/onlinestatusinfo/bean/c;", "simpleInfo", "", "b", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lcom/tencent/mobileqq/aio/title/ai;", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.helper.C2CSubTitleHelper$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }

        public final com.tencent.mobileqq.aio.title.ai a(com.tencent.aio.api.runtime.a aioContext) {
            if (aioContext == null || !com.tencent.mobileqq.activity.aio.l.K()) {
                return null;
            }
            AIOParam g16 = aioContext.g();
            String valueOf = String.valueOf(g16 != null ? Long.valueOf(su3.c.a(g16)) : null);
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
            ListenTogetherSession Q = ListenTogetherManager.J((QQAppInterface) peekAppRuntime).Q(2, valueOf);
            if (Q == null) {
                return null;
            }
            boolean z16 = Q.M;
            com.tencent.mobileqq.listentogether.nt.c cVar = com.tencent.mobileqq.listentogether.nt.c.f241083a;
            QLog.d("C2CSubTitleHelper", 1, "getTogetherDataFromCache session.fold=" + z16 + ", isPanelShow=" + (!cVar.e(valueOf)));
            int i3 = Q.f437191i;
            if (i3 == 0 || i3 == 3 || cVar.e(valueOf)) {
                return null;
            }
            Drawable B = com.tencent.mobileqq.activity.aio.l.B(false);
            String qqStr = HardCodeUtil.qqStr(R.string.isv);
            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.listen_together_subtitle_hide)");
            return new com.tencent.mobileqq.aio.title.ai(null, B, null, qqStr, "3");
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x002a A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:15:0x002b A[RETURN] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final boolean b(com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c simpleInfo) {
            boolean z16;
            boolean contains$default;
            if (simpleInfo == null) {
                return false;
            }
            if (com.tencent.mobileqq.friend.status.b.a(simpleInfo.u(), simpleInfo.z()) != 0) {
                return true;
            }
            String c06 = simpleInfo.c0();
            if (c06 != null) {
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) c06, (CharSequence) "TIM", false, 2, (Object) null);
                if (contains$default) {
                    z16 = true;
                    return !z16;
                }
            }
            z16 = false;
            if (!z16) {
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0003H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/qqnt/aio/helper/C2CSubTitleHelper$c", "Lhx3/b;", "Lcom/tencent/qqnt/ntrelation/onlinestatusinfo/bean/a;", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/e;", WebViewPlugin.KEY_RESPONSE, "", "onQueryResult", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements hx3.b<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c> f350275a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ C2CSubTitleHelper f350276b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f350277c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f350278d;

        c(Ref.ObjectRef<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c> objectRef, C2CSubTitleHelper c2CSubTitleHelper, String str, int i3) {
            this.f350275a = objectRef;
            this.f350276b = c2CSubTitleHelper;
            this.f350277c = str;
            this.f350278d = i3;
        }

        /* JADX WARN: Type inference failed for: r4v3, types: [com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a, T] */
        @Override // hx3.b
        public void onQueryResult(com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a> responseData) {
            ArrayList<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a> b16;
            Object orNull;
            Ref.ObjectRef<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c> objectRef = this.f350275a;
            if (responseData == null || (b16 = responseData.b()) == null) {
                return;
            }
            orNull = CollectionsKt___CollectionsKt.getOrNull(b16, 0);
            ?? r46 = (com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.a) orNull;
            if (r46 != 0) {
                objectRef.element = r46;
                this.f350276b.v(this.f350275a.element, this.f350277c, this.f350278d);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/qqnt/aio/helper/C2CSubTitleHelper$d", "Lcom/tencent/mvi/base/route/a;", "", "sticky", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements com.tencent.mvi.base.route.a {
        d() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            if (i3 instanceof AIOTitleEvent.SubTitleRequestEvent) {
                C2CSubTitleHelper.this.k(i3);
            } else if (i3 instanceof AIOTitleEvent.SubTitleClickEvent) {
                C2CSubTitleHelper.this.k(i3);
            } else if (i3 instanceof AIOTitleEvent.SubTitle2ClickEvent) {
                C2CSubTitleHelper.this.k(i3);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0014J'\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\fH\u0014\u00a2\u0006\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0010"}, d2 = {"com/tencent/qqnt/aio/helper/C2CSubTitleHelper$e", "Lcom/tencent/mobileqq/app/ar;", "", "isSuccess", "", "type", "", "uinOrMobileStr", "Lfriendlist/GetOnlineInfoResp;", "resp", "", "onGetOnlineInfoByUinOrMobile", "", "uin", "onUpdateOnlineFriend", "(Z[Ljava/lang/String;)V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class e extends com.tencent.mobileqq.app.ar {
        e() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.ar
        public void onGetOnlineInfoByUinOrMobile(boolean isSuccess, long type, String uinOrMobileStr, GetOnlineInfoResp resp) {
            AIOParam g16;
            Intrinsics.checkNotNullParameter(uinOrMobileStr, "uinOrMobileStr");
            Intrinsics.checkNotNullParameter(resp, "resp");
            com.tencent.aio.api.runtime.a aVar = C2CSubTitleHelper.this.mAIOContext;
            if (TextUtils.equals(uinOrMobileStr, (aVar == null || (g16 = aVar.g()) == null) ? null : su3.c.b(g16))) {
                QLog.d("C2CSubTitleHelper", 1, "onGetOnlineInfoByUinOrMobile isSuccess=" + isSuccess);
                C2CSubTitleHelper.this.i(0);
            }
        }

        @Override // com.tencent.mobileqq.app.ar
        protected void onUpdateOnlineFriend(boolean isSuccess, String[] uin) {
            QLog.d("C2CSubTitleHelper", 1, "onUpdateOnlineFriend isSuccess=" + isSuccess);
            C2CSubTitleHelper.this.i(0);
        }
    }

    public C2CSubTitleHelper() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<Boolean>() { // from class: com.tencent.qqnt.aio.helper.C2CSubTitleHelper$useOnlineStatusNTData$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(OnlineStatusToggleUtils.F());
            }
        });
        this.useOnlineStatusNTData = lazy;
        this.mAction1 = new d();
        this.onlineStateObserver = new e();
    }

    private final void h() {
        AIOParam g16;
        AIOSession r16;
        AIOContact c16;
        String j3;
        if (this.onlineStatusInfoCallback != null) {
            return;
        }
        b bVar = new b();
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar != null && (g16 = aVar.g()) != null && (r16 = g16.r()) != null && (c16 = r16.c()) != null && (j3 = c16.j()) != null) {
            ((IOnlineStatusInfoService) QRoute.api(IOnlineStatusInfoService.class)).addOnlineStatusSimpleInfoCallback(j3, "C2CSubTitleHelper", bVar);
        }
        this.onlineStatusInfoCallback = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c, T] */
    public final void i(int type) {
        String str;
        com.tencent.mvi.base.route.j e16;
        AIOParam g16;
        AIOSession r16;
        AIOContact c16;
        AIOParam g17;
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        String b16 = (aVar == null || (g17 = aVar.g()) == null) ? null : su3.c.b(g17);
        com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
        if (aVar2 == null || (g16 = aVar2.g()) == null || (r16 = g16.r()) == null || (c16 = r16.c()) == null || (str = c16.j()) == null) {
            str = "";
        }
        ListenTogetherHelper d16 = com.tencent.mobileqq.listentogether.nt.c.f241083a.d(str);
        if (com.tencent.mobileqq.activity.aio.l.K() && d16 != null && d16.y()) {
            m(d16);
            return;
        }
        com.tencent.mobileqq.aio.title.ai a16 = INSTANCE.a(this.mAIOContext);
        if (a16 != null) {
            com.tencent.aio.api.runtime.a aVar3 = this.mAIOContext;
            if (aVar3 == null || (e16 = aVar3.e()) == null) {
                return;
            }
            e16.h(new AIOTitleEvent.SubTitleResponseEvent(a16));
            return;
        }
        QRouteApi api = QRoute.api(IOnlineStatusInfoService.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IOnlineStatusInfoService::class.java)");
        IOnlineStatusInfoService iOnlineStatusInfoService = (IOnlineStatusInfoService) api;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ?? onlineStatusSimpleInfoWithUid = iOnlineStatusInfoService.getOnlineStatusSimpleInfoWithUid(str, "C2CSubTitleHelper_checkRichStatus");
        objectRef.element = onlineStatusSimpleInfoWithUid;
        if (onlineStatusSimpleInfoWithUid == 0) {
            iOnlineStatusInfoService.getOnlineStatusInfoWithUid(str, "C2CSubTitleHelper_checkRichStatus", new c(objectRef, this, b16, type));
        } else {
            v(onlineStatusSimpleInfoWithUid, b16, type);
        }
    }

    private final boolean j() {
        return ((Boolean) this.useOnlineStatusNTData.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(MsgIntent i3) {
        if (i3 instanceof AIOTitleEvent.SubTitleRequestEvent) {
            o(((AIOTitleEvent.SubTitleRequestEvent) i3).a());
            return;
        }
        if (i3 instanceof AIOTitleEvent.SubTitleClickEvent) {
            n();
        } else if (i3 instanceof AIOTitleEvent.SubTitle2ClickEvent) {
            p();
        } else if (i3 instanceof AIOMsgListEvent.MultiSelectModeChangeEvent) {
            this.mIsSelectedMode = ((AIOMsgListEvent.MultiSelectModeChangeEvent) i3).b();
        }
    }

    private final void m(ListenTogetherHelper listenTogetherHelper) {
        com.tencent.mvi.base.route.j e16;
        QLog.d("C2CSubTitleHelper", 1, "handleListenerTogether");
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null || (e16 = aVar.e()) == null) {
            return;
        }
        e16.h(new AIOTitleEvent.SubTitleResponseEvent(new com.tencent.mobileqq.aio.title.ai(null, com.tencent.mobileqq.activity.aio.l.B(true ^ listenTogetherHelper.getMIsPanelShow()), null, listenTogetherHelper.v(), "3")));
    }

    private final void n() {
        String str;
        AIOParam g16;
        AIOSession r16;
        AIOContact c16;
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null || (g16 = aVar.g()) == null || (r16 = g16.r()) == null || (c16 = r16.c()) == null || (str = c16.j()) == null) {
            str = "";
        }
        com.tencent.mobileqq.listentogether.nt.c cVar = com.tencent.mobileqq.listentogether.nt.c.f241083a;
        ListenTogetherHelper d16 = cVar.d(str);
        boolean y16 = d16 != null ? d16.y() : false;
        boolean mIsPanelShow = d16 != null ? d16.getMIsPanelShow() : false;
        if (y16) {
            if (this.mIsSelectedMode) {
                return;
            }
            if (d16 != null) {
                if (mIsPanelShow) {
                    d16.x();
                    cVar.f(str, true);
                } else {
                    d16.D();
                    cVar.f(str, false);
                }
            }
            if (d16 != null) {
                m(d16);
                return;
            }
            return;
        }
        s();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void o(int type) {
        AIOParam g16;
        AIOSession r16;
        AIOContact c16;
        String j3;
        boolean z16;
        AIOParam g17;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
        if (this.mFriendListHandler == null) {
            com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
            String b16 = (aVar == null || (g17 = aVar.g()) == null) ? null : su3.c.b(g17);
            BusinessHandler businessHandler = qQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
            Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.app.FriendListHandler");
            FriendListHandler friendListHandler = (FriendListHandler) businessHandler;
            this.mFriendListHandler = friendListHandler;
            Intrinsics.checkNotNull(friendListHandler);
            if (!friendListHandler.isGetOnlineListRecently()) {
                FriendListHandler friendListHandler2 = this.mFriendListHandler;
                Intrinsics.checkNotNull(friendListHandler2);
                if (!friendListHandler2.shouldGetOnlineInfo()) {
                    z16 = true;
                    if (!z16) {
                        z16 = CustomOnlineStatusManager.d().b(b16);
                    }
                    if (z16) {
                        FriendListHandler friendListHandler3 = this.mFriendListHandler;
                        if (friendListHandler3 != null) {
                            friendListHandler3.getOnlineInfo(b16, false);
                        }
                        QLog.d("C2CSubTitleHelper", 1, "handleSubTitleRequest getOnlineInfo");
                    }
                }
            }
            z16 = false;
            if (!z16) {
            }
            if (z16) {
            }
        }
        if (!this.hasReqNTOnlineStatus) {
            this.hasReqNTOnlineStatus = true;
            com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
            if (aVar2 != null && (g16 = aVar2.g()) != null && (r16 = g16.r()) != null && (c16 = r16.c()) != null && (j3 = c16.j()) != null) {
                ((IOnLineStatueHelperApi) QRoute.api(IOnLineStatueHelperApi.class)).requestNTOnlineStatus(j3, false, "C2CSubTitleHelper");
            }
        }
        i(type);
    }

    private final void p() {
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar != null) {
            Intent intent = new Intent(aVar.c().getContext(), (Class<?>) PublicFragmentActivity.class);
            AIOParam g16 = aVar.g();
            Intrinsics.checkNotNullExpressionValue(g16, "it.aioParam");
            intent.putExtra("key_uin", su3.c.b(g16));
            intent.putExtra("key_uin_name", aVar.g().r().c().g());
            intent.putExtra("key_open_via", "history-liaotian");
            PublicFragmentActivity.b.a(aVar.c().getContext(), intent, PublicFragmentActivity.class, SignatureHistoryFragment.class);
            ReportController.o(MobileQQ.sMobileQQ.peekAppRuntime(), "CliOper", "", "", "0X800A66B", "0X800A66B", 0, 0, "", "", "", "");
        }
    }

    private final void q() {
        AIOParam g16;
        AIOSession r16;
        AIOContact c16;
        String j3;
        hx3.b<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c> bVar;
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar == null || (g16 = aVar.g()) == null || (r16 = g16.r()) == null || (c16 = r16.c()) == null || (j3 = c16.j()) == null || (bVar = this.onlineStatusInfoCallback) == null) {
            return;
        }
        ((IOnlineStatusInfoService) QRoute.api(IOnlineStatusInfoService.class)).removeOnlineStatusSimpleInfoCallback(j3, "C2CSubTitleHelper", bVar);
    }

    private final void s() {
        Fragment c16;
        AIOParam g16;
        Bundle l3;
        AIOParam g17;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        FragmentActivity fragmentActivity = null;
        String b16 = (aVar == null || (g17 = aVar.g()) == null) ? null : su3.c.b(g17);
        boolean z16 = false;
        if (CustomOnlineStatusManager.d().c() || ((IOnLineStatueHelperApi) QRoute.api(IOnLineStatueHelperApi.class)).enableAIOSubTitleClicked(qQAppInterface, b16)) {
            com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
            if (aVar2 != null && (g16 = aVar2.g()) != null && (l3 = g16.l()) != null) {
                z16 = l3.getBoolean("key_is_scale_chat");
            }
            com.tencent.aio.api.runtime.a aVar3 = this.mAIOContext;
            if (aVar3 != null && (c16 = aVar3.c()) != null) {
                fragmentActivity = c16.requireActivity();
            }
            com.tencent.mobileqq.activity.aio.l.W(fragmentActivity, b16, 1, !z16);
        }
    }

    private final void t(String uin, final com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c simpleInfo) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        final QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
        boolean areEqual = Intrinsics.areEqual(uin, qQAppInterface.getCurrentUin());
        final com.tencent.mobileqq.onlinestatus.au onlineStatusItem = ((IOnLineStatueHelperApi) QRoute.api(IOnLineStatueHelperApi.class)).getOnlineStatusItem(((IOnLineStatueHelperApi) QRoute.api(IOnLineStatueHelperApi.class)).getOldStatus(simpleInfo), simpleInfo.e0(), !areEqual);
        if (onlineStatusItem == null) {
            return;
        }
        if (onlineStatusItem.f255489b == 1000 && areEqual) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.helper.af
                @Override // java.lang.Runnable
                public final void run() {
                    C2CSubTitleHelper.u(C2CSubTitleHelper.this, qQAppInterface, simpleInfo, onlineStatusItem);
                }
            }, 64, null, true);
        } else {
            r(qQAppInterface, simpleInfo, onlineStatusItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(C2CSubTitleHelper this$0, QQAppInterface app, com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c simpleInfo, com.tencent.mobileqq.onlinestatus.au item) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(app, "$app");
        Intrinsics.checkNotNullParameter(simpleInfo, "$simpleInfo");
        Intrinsics.checkNotNullParameter(item, "$item");
        this$0.r(app, simpleInfo, item);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c simpleInfo, String uin, int type) {
        com.tencent.aio.api.runtime.a aVar;
        com.tencent.mvi.base.route.j e16;
        if (INSTANCE.b(simpleInfo)) {
            Intrinsics.checkNotNull(simpleInfo);
            t(uin, simpleInfo);
        } else {
            if (type != 1 || (aVar = this.mAIOContext) == null || (e16 = aVar.e()) == null) {
                return;
            }
            e16.h(new AIOTitleEvent.TitleResponseEvent(11, ""));
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.f350637h;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.event.AIOTitleEvent.SubTitleRequestEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOTitleEvent.SubTitleClickEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOTitleEvent.SubTitle2ClickEvent");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.MultiSelectModeChangeEvent");
        return hashSet;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        return new HashSet();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public String getTag() {
        return "C2CSubTitleHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        com.tencent.aio.api.runtime.a a16 = param.a();
        this.mAIOContext = a16;
        Intrinsics.checkNotNull(a16);
        a16.e().f(this, this.mAction1);
        if (j()) {
            h();
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        QQAppInterface qQAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
        if (qQAppInterface != null) {
            qQAppInterface.addObserver(this.onlineStateObserver);
        }
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        Fragment c16;
        View view;
        com.tencent.mvi.base.route.j e16;
        h.a.b(this);
        if (j()) {
            q();
        } else {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            QQAppInterface qQAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
            if (qQAppInterface != null) {
                qQAppInterface.removeObserver(this.onlineStateObserver);
            }
        }
        com.tencent.aio.api.runtime.a aVar = this.mAIOContext;
        if (aVar != null && (e16 = aVar.e()) != null) {
            e16.i(this, this.mAction1);
        }
        com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
        View findViewById = (aVar2 == null || (c16 = aVar2.c()) == null || (view = c16.getView()) == null) ? null : view.findViewById(R.id.f166931j64);
        if (findViewById instanceof OnlineStatusLyricView) {
            ((OnlineStatusLyricView) findViewById).e();
        }
        this.mFriendListHandler = null;
        this.hasReqNTOnlineStatus = false;
        this.onlineStatusInfoCallback = null;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0003H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/qqnt/aio/helper/C2CSubTitleHelper$b", "Lhx3/b;", "Lcom/tencent/qqnt/ntrelation/onlinestatusinfo/bean/c;", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/e;", WebViewPlugin.KEY_RESPONSE, "", "onQueryResult", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements hx3.b<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c> {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(C2CSubTitleHelper this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.i(0);
        }

        @Override // hx3.b
        public void onQueryResult(com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c> responseData) {
            ArrayList<com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c> b16;
            Object orNull;
            com.tencent.aio.api.runtime.a aVar;
            AIOParam g16;
            AIOSession r16;
            AIOContact c16;
            String j3;
            if (responseData == null || (b16 = responseData.b()) == null) {
                return;
            }
            orNull = CollectionsKt___CollectionsKt.getOrNull(b16, 0);
            com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c cVar = (com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c) orNull;
            if (cVar == null || (aVar = C2CSubTitleHelper.this.mAIOContext) == null || (g16 = aVar.g()) == null || (r16 = g16.r()) == null || (c16 = r16.c()) == null || (j3 = c16.j()) == null || !Intrinsics.areEqual(j3, cVar.getUid())) {
                return;
            }
            QLog.d("C2CSubTitleHelper", 1, "onNTQueryResult " + j3);
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final C2CSubTitleHelper c2CSubTitleHelper = C2CSubTitleHelper.this;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.qqnt.aio.helper.ag
                @Override // java.lang.Runnable
                public final void run() {
                    C2CSubTitleHelper.b.b(C2CSubTitleHelper.this);
                }
            });
        }
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public int[] interestedIn() {
        return new int[]{12, 0};
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        if (state == 12) {
            onDestroy();
        }
    }

    private final void r(QQAppInterface app, com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c simpleInfo, com.tencent.mobileqq.onlinestatus.au item) {
        com.tencent.aio.api.runtime.a aVar;
        com.tencent.mvi.base.route.j e16;
        com.tencent.mvi.base.route.j e17;
        Drawable[] subtitleOnlineDrawable = ((IOnLineStatueHelperApi) QRoute.api(IOnLineStatueHelperApi.class)).getSubtitleOnlineDrawable(app, simpleInfo, true, true);
        String statusName = ((IOnLineStatueHelperApi) QRoute.api(IOnLineStatueHelperApi.class)).getDisplayOnlineStatusInfo(app, simpleInfo, null, 1, item, Boolean.valueOf(com.tencent.mobileqq.friend.status.b.a(simpleInfo.u(), simpleInfo.z()) == 4 && item.f255489b > 0));
        Drawable drawable = subtitleOnlineDrawable[0];
        Drawable drawable2 = subtitleOnlineDrawable[1];
        Intrinsics.checkNotNullExpressionValue(statusName, "statusName");
        com.tencent.mobileqq.aio.title.ai aiVar = new com.tencent.mobileqq.aio.title.ai(null, drawable, drawable2, statusName, "1");
        com.tencent.aio.api.runtime.a aVar2 = this.mAIOContext;
        if (aVar2 != null && (e17 = aVar2.e()) != null) {
            e17.h(new AIOTitleEvent.SubTitleResponseEvent(aiVar));
        }
        if (item.f255489b != 1028 || (aVar = this.mAIOContext) == null || (e16 = aVar.e()) == null) {
            return;
        }
        e16.h(new AIOTitleEvent.LyricsEvent(simpleInfo, statusName));
    }
}
