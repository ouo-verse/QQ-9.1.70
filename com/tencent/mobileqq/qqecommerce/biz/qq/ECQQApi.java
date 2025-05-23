package com.tencent.mobileqq.qqecommerce.biz.qq;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ecommerce.biz.qq.api.IECQQApi;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.AuthDevOpenUgActivity;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.addfriend.api.IAddFriendServiceApi;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.emotionintegrate.SearchEmoticonFragment;
import com.tencent.mobileqq.emotionintegrate.SearchEmoticonWebBean;
import com.tencent.mobileqq.flock.api.IFlockLauncher;
import com.tencent.mobileqq.flock.api.JoinFlockAndTroopResult;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.MiniAppLaunchListener;
import com.tencent.mobileqq.minigame.kuikly.MiniGameKuiklyModule;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqecommerce.biz.qq.ECQQApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.SearchUtil;
import com.tencent.mobileqq.search.api.ISearchActivityJumpFetcher;
import com.tencent.mobileqq.search.api.ISearchUtilFetcher;
import com.tencent.mobileqq.search.model.SearchResultItem;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.troop.activity.f;
import com.tencent.mobileqq.troop.g;
import com.tencent.mobileqq.troop.troopjoin.api.ITroopJoinApi;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.aq;
import com.tencent.mobileqq.troop.utils.ax;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxmini.api.IWxMiniManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.plugins.QQFriendJsPlugin;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.util.LoadingUtil;
import com.tencent.util.NumberUtil;
import java.lang.ref.WeakReference;
import java.util.Set;
import java.util.WeakHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.trpcprotocol.TroopJoinQunAutoSwitch$RetrieveSubGroupRsp;
import tl.h;
import y45.k;
import y45.o;

/* compiled from: P */
@Metadata(d1 = {"\u0000y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001A\u0018\u0000 \u00032\u00020\u0001:\u0001'B\u0007\u00a2\u0006\u0004\bI\u0010JJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0006H\u0016JR\u0010\u0016\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000628\u0010\u0015\u001a4\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\u0018\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\u0018\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\u0018\u0010\u001c\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016Jj\u0010 \u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001028\u0010\u0015\u001a4\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000fH\u0016Jh\u0010!\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u001028\u0010\u0015\u001a4\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000fJ\u0018\u0010\"\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016JP\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000626\u0010\u0015\u001a2\u0012\u0013\u0012\u00110\u0010\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00040\u000fH\u0016J\b\u0010%\u001a\u00020\u0006H\u0016R\u001e\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\"\u0010/\u001a\u0010\u0012\u0004\u0012\u00020+\u0012\u0006\u0012\u0004\u0018\u00010,0*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u001e\u00101\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010(R\u001d\u00107\u001a\u0004\u0018\u0001028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u001b\u0010<\u001a\u0002088BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b9\u00104\u001a\u0004\b:\u0010;R\u0018\u0010@\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0014\u0010D\u001a\u00020A8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0014\u0010H\u001a\u00020E8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bF\u0010G\u00a8\u0006K"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/qq/ECQQApi;", "Lcom/tencent/ecommerce/biz/qq/api/IECQQApi;", "Lcom/tencent/mobileqq/app/face/IFaceDecoder;", h.F, "", "j", "", "uin", "Landroid/graphics/drawable/Drawable;", "getContactFaceDrawable", "troopUin", "getTroopFaceDrawable", "Landroid/content/Context;", "context", "params", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "code", "msg", "callback", "joinDaZi", "getFriendStatus", QQFriendJsPlugin.API_ADD_FRIEND, "con", "addFriendWithParams", "openProfileCard", "openTroopPage", "troopName", "authSign", "sourceId", "joinTroop", "o", "openSearchEmoticonPage", "outContext", MiniGameKuiklyModule.METHOD_OPEN_MINI_APP, "getLbsInfo", "Ljava/lang/ref/WeakReference;", "a", "Ljava/lang/ref/WeakReference;", "faceDecoderRef", "Ljava/util/WeakHashMap;", "Lcom/tencent/mobileqq/qqecommerce/biz/qq/e;", "", "b", "Ljava/util/WeakHashMap;", "drawableMap", "c", "contextRef", "Lcom/tencent/mobileqq/search/api/ISearchUtilFetcher;", "d", "Lkotlin/Lazy;", DomainData.DOMAIN_NAME, "()Lcom/tencent/mobileqq/search/api/ISearchUtilFetcher;", "faceFetcher", "Lcom/tencent/mobileqq/addfriend/api/IAddFriendServiceApi;", "e", "l", "()Lcom/tencent/mobileqq/addfriend/api/IAddFriendServiceApi;", "addFriendService", "Lcom/tencent/mobileqq/qqecommerce/biz/qq/f;", "f", "Lcom/tencent/mobileqq/qqecommerce/biz/qq/f;", "joinTroopData", "com/tencent/mobileqq/qqecommerce/biz/qq/ECQQApi$c", "g", "Lcom/tencent/mobileqq/qqecommerce/biz/qq/ECQQApi$c;", "troopObserver", "Lcom/tencent/mobileqq/app/QQAppInterface;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/mobileqq/app/QQAppInterface;", "appInterface", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ECQQApi implements IECQQApi {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private WeakReference<IFaceDecoder> faceDecoderRef;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final WeakHashMap<e, Object> drawableMap = new WeakHashMap<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private WeakReference<Context> contextRef;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Lazy faceFetcher;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy addFriendService;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private JoinTroopData joinTroopData;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final c troopObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/qqecommerce/biz/qq/ECQQApi$b", "Lcom/tencent/mobileqq/flock/api/a;", "Lcom/tencent/mobileqq/flock/api/JoinFlockAndTroopResult;", "result", "", "a", "b", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements com.tencent.mobileqq.flock.api.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function2<Integer, String, Unit> f263386a;

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes35.dex */
        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f263387a;

            static {
                int[] iArr = new int[JoinFlockAndTroopResult.values().length];
                try {
                    iArr[JoinFlockAndTroopResult.SYS_ERROR.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[JoinFlockAndTroopResult.PARAMS_ERROR.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f263387a = iArr;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        b(Function2<? super Integer, ? super String, Unit> function2) {
            this.f263386a = function2;
        }

        @Override // com.tencent.mobileqq.flock.api.a
        public void a(JoinFlockAndTroopResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            Function2<Integer, String, Unit> function2 = this.f263386a;
            if (function2 != null) {
                function2.invoke(0, "");
            }
        }

        @Override // com.tencent.mobileqq.flock.api.a
        public void b(JoinFlockAndTroopResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            int i3 = a.f263387a[result.ordinal()];
            if (i3 == 1) {
                Function2<Integer, String, Unit> function2 = this.f263386a;
                if (function2 != null) {
                    function2.invoke(1, "\u7cfb\u7edf\u5f02\u5e38");
                    return;
                }
                return;
            }
            if (i3 != 2) {
                Function2<Integer, String, Unit> function22 = this.f263386a;
                if (function22 != null) {
                    function22.invoke(3, "\u5176\u4ed6\u5f02\u5e38");
                    return;
                }
                return;
            }
            Function2<Integer, String, Unit> function23 = this.f263386a;
            if (function23 != null) {
                function23.invoke(2, "\u53c2\u6570\u5f02\u5e38");
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0014\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/qqecommerce/biz/qq/ECQQApi$c", "Lcom/tencent/mobileqq/troop/api/observer/b;", "", "isSuccess", "", "troopUin", "", "highRiskTroop", "", "g", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c extends com.tencent.mobileqq.troop.api.observer.b {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void z(ECQQApi this$0, Object[] objArr) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.j();
        }

        @Override // com.tencent.mobileqq.troop.api.observer.b
        protected void g(boolean isSuccess, String troopUin, int highRiskTroop) {
            WeakReference weakReference;
            Context context;
            String troopUin2;
            ECQQApi.this.m().removeObserver(this);
            JoinTroopData joinTroopData = ECQQApi.this.joinTroopData;
            if (!((joinTroopData == null || (troopUin2 = joinTroopData.getTroopUin()) == null) ? false : troopUin2.equals(troopUin)) || (weakReference = ECQQApi.this.contextRef) == null || (context = (Context) weakReference.get()) == null) {
                return;
            }
            if (!isSuccess || highRiskTroop == 0) {
                ECQQApi.this.j();
            } else {
                final ECQQApi eCQQApi = ECQQApi.this;
                ax.c(context, new ax.c() { // from class: com.tencent.mobileqq.qqecommerce.biz.qq.d
                    @Override // com.tencent.mobileqq.troop.utils.ax.c
                    public final void a(Object[] objArr) {
                        ECQQApi.c.z(ECQQApi.this, objArr);
                    }
                }, new Object[0]);
            }
        }
    }

    public ECQQApi() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ISearchUtilFetcher>() { // from class: com.tencent.mobileqq.qqecommerce.biz.qq.ECQQApi$faceFetcher$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ISearchUtilFetcher invoke() {
                return (ISearchUtilFetcher) QRoute.api(ISearchUtilFetcher.class);
            }
        });
        this.faceFetcher = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<IAddFriendServiceApi>() { // from class: com.tencent.mobileqq.qqecommerce.biz.qq.ECQQApi$addFriendService$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final IAddFriendServiceApi invoke() {
                IRuntimeService runtimeService = ECQQApi.this.m().getRuntimeService(IAddFriendServiceApi.class);
                Intrinsics.checkNotNullExpressionValue(runtimeService, "appInterface.getRuntimeS\u2026ndServiceApi::class.java)");
                return (IAddFriendServiceApi) runtimeService;
            }
        });
        this.addFriendService = lazy2;
        this.troopObserver = new c();
    }

    private final IFaceDecoder h() {
        WeakReference<IFaceDecoder> weakReference = this.faceDecoderRef;
        IFaceDecoder iFaceDecoder = weakReference != null ? weakReference.get() : null;
        if (iFaceDecoder != null) {
            return iFaceDecoder;
        }
        IFaceDecoder iQQAvatarService = ((IQQAvatarService) m().getRuntimeService(IQQAvatarService.class, "")).getInstance(m());
        iQQAvatarService.setDecodeTaskCompletionListener(new DecodeTaskCompletionListener() { // from class: com.tencent.mobileqq.qqecommerce.biz.qq.b
            @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
            public final void onDecodeTaskCompleted(int i3, int i16, String str, Bitmap bitmap) {
                ECQQApi.i(ECQQApi.this, i3, i16, str, bitmap);
            }
        });
        this.faceDecoderRef = new WeakReference<>(iQQAvatarService);
        return iQQAvatarService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(ECQQApi this$0, int i3, int i16, String str, Bitmap bitmap) {
        IFaceDecoder iFaceDecoder;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WeakReference<IFaceDecoder> weakReference = this$0.faceDecoderRef;
        boolean z16 = false;
        if (weakReference != null && (iFaceDecoder = weakReference.get()) != null && !iFaceDecoder.isPausing()) {
            z16 = true;
        }
        if (z16) {
            Set<e> keySet = this$0.drawableMap.keySet();
            Intrinsics.checkNotNullExpressionValue(keySet, "drawableMap.keys");
            for (e eVar : keySet) {
                if (eVar.getType() == i16 && Intrinsics.areEqual(eVar.getUin(), str)) {
                    eVar.setDrawable(new BitmapDrawable(bitmap));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        final Context context;
        final JoinTroopData joinTroopData;
        WeakReference<Context> weakReference = this.contextRef;
        if (weakReference == null || (context = weakReference.get()) == null || (joinTroopData = this.joinTroopData) == null) {
            return;
        }
        this.joinTroopData = null;
        g gVar = new g();
        gVar.f296167a = joinTroopData.getTroopUin();
        gVar.f296168b = joinTroopData.getTroopName();
        gVar.f296169c = joinTroopData.getSourceId();
        gVar.f296171e = joinTroopData.getAuthSign();
        gVar.f296172f = true;
        com.tencent.mobileqq.troop.activity.f.i0(context, gVar, new f.c() { // from class: com.tencent.mobileqq.qqecommerce.biz.qq.c
            @Override // com.tencent.mobileqq.troop.activity.f.c
            public final void a(String str, int i3) {
                ECQQApi.k(JoinTroopData.this, context, str, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(JoinTroopData troopData, Context context, String str, int i3) {
        Intrinsics.checkNotNullParameter(troopData, "$troopData");
        Intrinsics.checkNotNullParameter(context, "$context");
        if (Intrinsics.areEqual(str, troopData.getTroopUin())) {
            Function2<Integer, String, Unit> b16 = troopData.b();
            if (b16 != null) {
                b16.invoke(Integer.valueOf(i3), "");
            }
            if (i3 == 1) {
                QQToast.makeText(context, R.string.f171049c01, 0).show();
            }
        }
    }

    private final IAddFriendServiceApi l() {
        return (IAddFriendServiceApi) this.addFriendService.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QQAppInterface m() {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        Intrinsics.checkNotNull(runtime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        return (QQAppInterface) runtime;
    }

    private final ISearchUtilFetcher n() {
        return (ISearchUtilFetcher) this.faceFetcher.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(Function2 callback, boolean z16, Bundle bundle) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        callback.invoke(Integer.valueOf(z16 ? 0 : -1), "");
    }

    @Override // com.tencent.ecommerce.biz.qq.api.IECQQApi
    public Drawable getContactFaceDrawable(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        IFaceDecoder h16 = h();
        ISearchUtilFetcher n3 = n();
        e eVar = new e(n3 != null ? n3.getFaceBitmap(h16, uin, 1) : null, uin, 1, h16);
        this.drawableMap.put(eVar, null);
        return eVar;
    }

    @Override // com.tencent.ecommerce.biz.qq.api.IECQQApi
    public int getFriendStatus(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        String uid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(uin);
        IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
        Intrinsics.checkNotNullExpressionValue(uid, "uid");
        if (iFriendsInfoService.isFriend(uid, "ECQQApi")) {
            return 2;
        }
        return l().hasSendAddFriendReq(uin, false) ? 1 : 0;
    }

    @Override // com.tencent.ecommerce.biz.qq.api.IECQQApi
    public String getLbsInfo() {
        String o16 = SearchUtil.o();
        Intrinsics.checkNotNullExpressionValue(o16, "getLbsInfo()");
        return o16;
    }

    @Override // com.tencent.ecommerce.biz.qq.api.IECQQApi
    public Drawable getTroopFaceDrawable(String troopUin) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        IFaceDecoder h16 = h();
        ISearchUtilFetcher n3 = n();
        e eVar = new e(n3 != null ? n3.getFaceBitmap(h16, troopUin, 4) : null, troopUin, 4, h16);
        this.drawableMap.put(eVar, null);
        return eVar;
    }

    public final void o(Context context, String troopUin, String troopName, String authSign, int sourceId, Function2<? super Integer, ? super String, Unit> callback) {
        Long longOrNull;
        Long longOrNull2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(troopName, "troopName");
        Intrinsics.checkNotNullParameter(authSign, "authSign");
        m().removeObserver(this.troopObserver);
        this.contextRef = new WeakReference<>(context);
        this.joinTroopData = new JoinTroopData(troopUin, troopName, sourceId, authSign, callback);
        try {
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(troopUin);
            if (longOrNull == null) {
                QLog.w("ECQQApi", 1, "#joinTroop: troopUin=" + troopUin + ", can not covert to Long");
                return;
            }
            String currentUin = m().getCurrentUin();
            Intrinsics.checkNotNullExpressionValue(currentUin, "appInterface.currentUin");
            longOrNull2 = StringsKt__StringNumberConversionsKt.toLongOrNull(currentUin);
            if (longOrNull2 == null) {
                QLog.w("ECQQApi", 1, "#joinTroop: appInterface.currentUin=" + m().getCurrentUin() + ", can not covert to Long");
                return;
            }
            m().addObserver(this.troopObserver);
            Object businessHandler = m().getBusinessHandler(BusinessHandlerFactory.TROOP_MNG_HANDLER);
            Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.mobileqq.troop.api.handler.ITroopMngHandler");
            ((com.tencent.mobileqq.troop.api.handler.h) businessHandler).v0(longOrNull.longValue(), longOrNull2.longValue(), null);
        } catch (Exception e16) {
            QLog.e("ECQQApi", 1, e16, new Object[0]);
        }
    }

    @Override // com.tencent.ecommerce.biz.qq.api.IECQQApi
    public void openMiniApp(Context outContext, String params, final Function2<? super Integer, ? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(outContext, "outContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.d("ECQQApi", 1, "#openMiniApp");
        WeakReference weakReference = new WeakReference(outContext);
        m().getManager(QQManagerFactory.MINI_APP_LOCAL_SEARCH);
        Context context = (Context) weakReference.get();
        if (context == null) {
            QLog.w("ECQQApi", 1, "#openMiniApp context is null");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(params);
            String appId = jSONObject.optString("appId");
            int optInt = jSONObject.optInt("type");
            int optInt2 = jSONObject.optInt("scene");
            Intrinsics.checkNotNullExpressionValue(appId, "appId");
            if (appId.length() == 0) {
                QLog.w("ECQQApi", 1, "#openMiniApp appId is empty");
                return;
            }
            QLog.d("ECQQApi", 1, "#openMiniApp appId=" + appId + ", type=" + optInt + ", scene=" + optInt2);
            if (optInt == 0) {
                ((IMiniAppService) QRoute.api(IMiniAppService.class)).launchMiniAppById(context, appId, null, null, null, null, optInt2, new MiniAppLaunchListener() { // from class: com.tencent.mobileqq.qqecommerce.biz.qq.a
                    @Override // com.tencent.mobileqq.mini.api.MiniAppLaunchListener
                    public final void onLaunchResult(boolean z16, Bundle bundle) {
                        ECQQApi.p(Function2.this, z16, bundle);
                    }
                });
                return;
            }
            if (optInt != 1) {
                QLog.w("ECQQApi", 1, "#openMiniApp unknown miniApp type:" + optInt);
                return;
            }
            if (WXShareHelper.b0().e0()) {
                ((IWxMiniManager) QRoute.api(IWxMiniManager.class)).startWxMiniAppByAppId(context, appId, "", optInt2);
                callback.invoke(0, "");
            } else {
                QQToast.makeText(context, R.string.cd8, 0).show();
                callback.invoke(-1, "");
            }
        } catch (JSONException e16) {
            QLog.w("ECQQApi", 1, e16.getMessage(), e16);
        }
    }

    @Override // com.tencent.ecommerce.biz.qq.api.IECQQApi
    public void openProfileCard(Context con, String params) {
        Intrinsics.checkNotNullParameter(con, "con");
        Intrinsics.checkNotNullParameter(params, "params");
        try {
            JSONObject jSONObject = new JSONObject(params);
            String optString = jSONObject.optString("uin");
            String optString2 = jSONObject.optString(AuthDevOpenUgActivity.KEY_PHONE_NUM);
            int optInt = jSONObject.optInt("user_type");
            String optString3 = jSONObject.optString("name");
            int optInt2 = jSONObject.optInt("subSourceId", -1);
            int i3 = optInt2 > -1 ? optInt2 : 3;
            SearchResultItem searchResultItem = new SearchResultItem();
            searchResultItem.G = 84;
            searchResultItem.f283460d = NumberUtil.stringToLong(optString);
            searchResultItem.f283462f = optString3;
            if (optInt == 2) {
                searchResultItem.f283460d = 0L;
                searchResultItem.f283463h = optString2;
            }
            if (optInt == 3) {
                searchResultItem.F = 1;
            }
            Activity a16 = af2.b.f25996a.a(con);
            if (a16 != null) {
                ((ISearchActivityJumpFetcher) QRoute.api(ISearchActivityJumpFetcher.class)).jumpToProfileCardActivity(a16, searchResultItem, m(), true, i3);
            }
        } catch (JSONException e16) {
            QLog.w("ECQQApi", 1, e16.getMessage(), e16);
        }
    }

    @Override // com.tencent.ecommerce.biz.qq.api.IECQQApi
    public void openSearchEmoticonPage(Context context, String params) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(params, "params");
        if (params.length() == 0) {
            QLog.w("ECQQApi", 1, "#openSearchEmoticonPage: params is empty");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(params);
            SearchEmoticonWebBean searchEmoticonWebBean = new SearchEmoticonWebBean();
            searchEmoticonWebBean.f205169d = jSONObject.optString("emt_name", "");
            searchEmoticonWebBean.f205170e = jSONObject.optString("emt_oriUrl", "");
            searchEmoticonWebBean.f205171f = jSONObject.optString("emt_oriMd5", "");
            searchEmoticonWebBean.C = jSONObject.optInt("emt_type", 0);
            searchEmoticonWebBean.D = jSONObject.optString("emt_packCoverUrl", "");
            searchEmoticonWebBean.F = jSONObject.optString("emt_packName", "");
            String optString = jSONObject.optString("emt_webUrl", "");
            searchEmoticonWebBean.J = optString;
            if (TextUtils.isEmpty(optString)) {
                searchEmoticonWebBean.C = 0;
            }
            SearchEmoticonFragment.Fh(context, searchEmoticonWebBean);
        } catch (JSONException e16) {
            QLog.e("ECQQApi", 1, e16, new Object[0]);
        }
    }

    @Override // com.tencent.ecommerce.biz.qq.api.IECQQApi
    public void openTroopPage(Context context, String params) {
        Integer intOrNull;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(params, "params");
        try {
            JSONObject jSONObject = new JSONObject(params);
            String optString = jSONObject.optString("troopUin");
            String optString2 = jSONObject.optString("troopName");
            String optString3 = jSONObject.optString("authSign");
            String optString4 = jSONObject.optString("transInfo");
            String optString5 = jSONObject.optString("keyword");
            String optString6 = jSONObject.optString("sourceId");
            Intrinsics.checkNotNullExpressionValue(optString6, "json.optString(\"sourceId\")");
            intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(optString6);
            int intValue = intOrNull != null ? intOrNull.intValue() : 0;
            QLog.d("ECQQApi", 1, "#openTroopPage: troopUin=" + optString + ", troopName=" + optString2 + ", keyword=" + optString5);
            Bundle b16 = aq.b(optString, intValue);
            b16.putInt("exposureSource", 3);
            b16.putString("keyword", optString5);
            b16.putBoolean("isFromNative", true);
            b16.putInt("t_s_f", 1000);
            b16.putString("authSig", optString3);
            b16.putString("trans_info", optString4);
            b16.putString(AppConstants.Key.TROOP_INFO_NAME, optString2);
            TroopUtils.I(context, b16, 2);
        } catch (JSONException e16) {
            QLog.w("ECQQApi", 1, e16.getMessage(), e16);
        }
    }

    @Override // com.tencent.ecommerce.biz.qq.api.IECQQApi
    public void addFriend(Context context, String name, String uin) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intent startAddFriend = ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).startAddFriend(context, 1, uin, null, 3020, 3, name, null, null, context.getString(R.string.f170028dd), null);
        Intrinsics.checkNotNullExpressionValue(startAddFriend, "api(IAddFriendApi::class\u2026           null\n        )");
        ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).launchAddFriend(context, startAddFriend);
    }

    @Override // com.tencent.ecommerce.biz.qq.api.IECQQApi
    public void addFriendWithParams(Context con, String params) {
        Intrinsics.checkNotNullParameter(con, "con");
        Intrinsics.checkNotNullParameter(params, "params");
        try {
            JSONObject jSONObject = new JSONObject(params);
            String optString = jSONObject.optString("uin");
            String optString2 = jSONObject.optString(AuthDevOpenUgActivity.KEY_PHONE_NUM);
            int optInt = jSONObject.optInt("user_type");
            String optString3 = jSONObject.optString("name");
            int optInt2 = jSONObject.optInt("sourceId", -1);
            if (optInt2 <= -1) {
                optInt2 = 3020;
            }
            int optInt3 = jSONObject.optInt("subSourceId", -1);
            if (optInt3 <= -1) {
                optInt3 = 3;
            }
            int i3 = optInt3;
            int i16 = 2;
            if (optInt != 2) {
                optString2 = optString;
                i16 = 1;
            }
            Intent startAddFriend = ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).startAddFriend(con, i16, optString2, null, optInt2, i3, optString3, null, null, con.getString(R.string.f170028dd), null);
            Intrinsics.checkNotNullExpressionValue(startAddFriend, "api(IAddFriendApi::class\u2026           null\n        )");
            ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).launchAddFriend(con, startAddFriend);
        } catch (JSONException e16) {
            QLog.w("ECQQApi", 1, e16.getMessage(), e16);
        }
    }

    @Override // com.tencent.ecommerce.biz.qq.api.IECQQApi
    public void joinDaZi(Context context, String params, Function2<? super Integer, ? super String, Unit> callback) {
        Long longOrNull;
        Integer intOrNull;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(params, "params");
        try {
            JSONObject jSONObject = new JSONObject(params);
            String optString = jSONObject.optString("feed");
            String subSourceId = jSONObject.optString("sourceId");
            try {
                JSONObject jSONObject2 = new JSONObject(optString);
                y45.b bVar = new y45.b();
                String troopUin = jSONObject2.optString("troopUin");
                String authSig = jSONObject2.optString("authSig");
                int optInt = jSONObject2.optInt("hasJoined");
                String optString2 = jSONObject2.optString("feedId");
                String optString3 = jSONObject2.optString("userId");
                long optLong = jSONObject2.optLong(WadlProxyConsts.CREATE_TIME);
                QLog.d("ECQQApi", 1, "#joinDaZi: troopUin=" + troopUin + ", hasJoined=" + optInt + ", feedId=" + optString2);
                Intrinsics.checkNotNullExpressionValue(troopUin, "troopUin");
                longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(troopUin);
                bVar.f449367b = longOrNull != null ? longOrNull.longValue() : 0L;
                Intrinsics.checkNotNullExpressionValue(authSig, "authSig");
                byte[] bytes = authSig.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                bVar.f449381p = bytes;
                bVar.f449373h = optLong;
                bVar.f449366a = optString2;
                o oVar = new o();
                oVar.f449449a = optString3;
                bVar.f449369d = oVar;
                k kVar = new k();
                kVar.f449418d = optInt;
                bVar.f449379n = kVar;
                IFlockLauncher iFlockLauncher = (IFlockLauncher) QRoute.api(IFlockLauncher.class);
                b bVar2 = new b(callback);
                Intrinsics.checkNotNullExpressionValue(subSourceId, "subSourceId");
                intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(subSourceId);
                iFlockLauncher.addFlockAndJoinTroop(context, bVar, bVar2, intOrNull != null ? intOrNull.intValue() : 0);
            } catch (JSONException e16) {
                QLog.w("ECQQApi", 1, e16.getMessage(), e16);
            }
        } catch (JSONException e17) {
            QLog.w("ECQQApi", 1, e17.getMessage(), e17);
        }
    }

    @Override // com.tencent.ecommerce.biz.qq.api.IECQQApi
    public void joinTroop(final Context context, final String troopUin, final String troopName, final String authSign, final int sourceId, final Function2<? super Integer, ? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(troopName, "troopName");
        Intrinsics.checkNotNullParameter(authSign, "authSign");
        try {
            final Dialog showOnlyLoadingImageDialog = LoadingUtil.showOnlyLoadingImageDialog(context, 2, true);
            showOnlyLoadingImageDialog.show();
            ((ITroopJoinApi) QRoute.api(ITroopJoinApi.class)).needShowSubTroopWithTroopId(troopUin, false, new Function2<Boolean, TroopJoinQunAutoSwitch$RetrieveSubGroupRsp, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.qq.ECQQApi$joinTroop$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, TroopJoinQunAutoSwitch$RetrieveSubGroupRsp troopJoinQunAutoSwitch$RetrieveSubGroupRsp) {
                    invoke(bool.booleanValue(), troopJoinQunAutoSwitch$RetrieveSubGroupRsp);
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16, TroopJoinQunAutoSwitch$RetrieveSubGroupRsp subTroopInfo) {
                    Intrinsics.checkNotNullParameter(subTroopInfo, "subTroopInfo");
                    showOnlyLoadingImageDialog.dismiss();
                    if (z16) {
                        Function2<Integer, String, Unit> function2 = callback;
                        if (function2 != null) {
                            function2.invoke(2, "");
                        }
                        ((ITroopJoinApi) QRoute.api(ITroopJoinApi.class)).showSwitchSubTroop(context, troopUin, subTroopInfo, sourceId == 30023 ? 1002 : 0, "pg_qq_network_search_result_level2_page");
                        return;
                    }
                    this.o(context, troopUin, troopName, authSign, sourceId, callback);
                }
            });
        } catch (Exception e16) {
            QLog.e("ECQQApi", 1, e16, new Object[0]);
            o(context, troopUin, troopName, authSign, sourceId, callback);
        }
    }
}
