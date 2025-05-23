package com.tencent.mobileqq.aio.helper;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.event.AIOMsgSendEvent;
import com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent;
import com.tencent.mobileqq.aio.msglist.holder.external.MsgItemExternalRefreshEvent;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.AIOLifeCycleEvent;
import com.tencent.qqnt.aio.api.IAIOAnimationApi;
import com.tencent.qqnt.doutu.api.IDoutuService;
import com.tencent.qqnt.emoticon.api.IQCircleEmoticonApi;
import com.tencent.qqnt.emotion.stickerrecommended.IStickerRecManager;
import com.tencent.qqnt.emotion.stickerrecommended.adapter.mvp.StickerRecKeywordFrom;
import com.tencent.qqnt.emotion.stickerrecommended.event.StickerRecommendEvent;
import com.tencent.qqnt.emotion.stickerrecommended.mvvm.IStickerRecMvvmCreator;
import com.tencent.qqnt.emotion.stickerrecommended.mvvm.b;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b3\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\t*\u0001_\b\u0007\u0018\u0000 \f2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001fB\u0007\u00a2\u0006\u0004\bd\u0010eJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\"\u0010\f\u001a\u00020\u00042\u0018\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b0\u0007H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\"\u0010\u000e\u001a\u00020\u00042\u0018\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b0\u0007H\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\b\u0010\u0012\u001a\u00020\u0004H\u0002J\u0012\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010\u0016\u001a\u00020\u0004H\u0002J\b\u0010\u0017\u001a\u00020\u0004H\u0002J\b\u0010\u0018\u001a\u00020\u0004H\u0002J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J4\u0010!\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\t2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\tH\u0002J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\"H\u0002J\u0010\u0010&\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020%H\u0002J\u0018\u0010(\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020%2\u0006\u0010'\u001a\u00020\u0014H\u0002J\u0012\u0010+\u001a\u00020\u00142\b\u0010*\u001a\u0004\u0018\u00010)H\u0002J\u0012\u0010-\u001a\u00020\u00042\b\u0010,\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010.\u001a\u00020\u0004H\u0002J\b\u0010/\u001a\u00020\u0004H\u0002J\u001a\u00101\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020%2\b\b\u0002\u0010\u0013\u001a\u000200H\u0002J\u0010\u00103\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u0014H\u0002J\u0010\u00106\u001a\u00020\u00042\u0006\u00105\u001a\u000204H\u0002J\b\u00107\u001a\u000204H\u0016J\b\u00108\u001a\u00020\tH\u0016J\u0010\u0010;\u001a\u00020\u00042\u0006\u0010:\u001a\u000209H\u0016J\b\u0010=\u001a\u00020<H\u0016J\u0010\u0010?\u001a\u00020\u00042\u0006\u0010>\u001a\u000204H\u0016J\u0010\u0010B\u001a\u00020\u00142\u0006\u0010A\u001a\u00020@H\u0016J\u0010\u0010C\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020%H\u0004R\u0016\u0010F\u001a\u0002098\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010I\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010L\u001a\u00020J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010$R\u0018\u0010O\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u0018\u0010S\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0018\u0010V\u001a\u0004\u0018\u00010T8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010UR\u0018\u0010Y\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010XR\u0016\u0010\\\u001a\u00020Z8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0005\u0010[R\u0016\u0010]\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010HR\u0016\u0010^\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010HR\u0014\u0010a\u001a\u00020_8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010`R&\u0010c\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020_0\b0\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010b\u00a8\u0006g"}, d2 = {"Lcom/tencent/mobileqq/aio/helper/StickerRecHelper;", "Lcom/tencent/aio/main/businesshelper/h;", "Landroid/os/Handler$Callback;", "Lcom/tencent/mvi/base/route/g;", "", "D", "H", "", "Lkotlin/Pair;", "", "Lcom/tencent/mvi/base/route/a;", "messageList", "I", "M", "N", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, DomainData.DOMAIN_NAME, "from", "", "G", BdhLogUtil.LogTag.Tag_Conn, "r", "o", "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", ReportConstant.COSTREPORT_PREFIX, "filePath", "keyword", "Lcom/tencent/qqnt/msg/data/g;", "picExtBizInfo", "originalMd5", "K", "Lcom/tencent/mobileqq/data/MarkFaceMessage;", "marketFaceMessage", "J", "", "u", "ignoreSwitch", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Landroid/os/Bundle;", "customParam", "E", "title", "L", "t", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/qqnt/emotion/stickerrecommended/adapter/mvp/StickerRecKeywordFrom;", "w", "inWords", "B", "", "newState", "v", "getId", "getTag", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "", "interestedIn", "state", "onMoveToState", "Landroid/os/Message;", "msg", "handleMessage", UserInfo.SEX_FEMALE, "d", "Lcom/tencent/aio/main/businesshelper/b;", "mParam", "e", "Z", "enableAsyncAnalyze", "", "f", "mLastShowTime", tl.h.F, "Ljava/lang/CharSequence;", "mCurrentInputText", "Lcom/tencent/qqnt/emotion/stickerrecommended/mvvm/b;", "i", "Lcom/tencent/qqnt/emotion/stickerrecommended/mvvm/b;", "mViewModel", "Lcom/tencent/qqnt/emotion/stickerrecommended/mvvm/a;", "Lcom/tencent/qqnt/emotion/stickerrecommended/mvvm/a;", "mViewBinder", "Landroidx/fragment/app/Fragment;", "Landroidx/fragment/app/Fragment;", "mOwner", "Lmqq/os/MqqHandler;", "Lmqq/os/MqqHandler;", "mUiHandler", "canShowStickerRecommend", "hasInit", "com/tencent/mobileqq/aio/helper/StickerRecHelper$b", "Lcom/tencent/mobileqq/aio/helper/StickerRecHelper$b;", "mAction", "Ljava/util/List;", "mFirstMessageList", "<init>", "()V", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes10.dex */
public final class StickerRecHelper implements com.tencent.aio.main.businesshelper.h, Handler.Callback, com.tencent.mvi.base.route.g {
    static IPatchRedirector $redirector_;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private Fragment mOwner;

    /* renamed from: D, reason: from kotlin metadata */
    private MqqHandler mUiHandler;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean canShowStickerRecommend;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean hasInit;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final b mAction;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final List<Pair<String, b>> mFirstMessageList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.main.businesshelper.b mParam;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean enableAsyncAnalyze;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long mLastShowTime;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CharSequence mCurrentInputText;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.emotion.stickerrecommended.mvvm.b mViewModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.emotion.stickerrecommended.mvvm.a mViewBinder;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/helper/StickerRecHelper$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.helper.StickerRecHelper$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/aio/helper/StickerRecHelper$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) StickerRecHelper.this);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) i3);
            } else {
                Intrinsics.checkNotNullParameter(i3, "i");
                StickerRecHelper.this.s(i3);
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return a.C9235a.a(this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52196);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public StickerRecHelper() {
        List<Pair<String, b>> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.enableAsyncAnalyze = true;
        b bVar = new b();
        this.mAction = bVar;
        com.tencent.qqnt.aio.utils.j jVar = com.tencent.qqnt.aio.utils.j.f352301a;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(jVar.a(Reflection.getOrCreateKotlinClass(MsgItemExternalRefreshEvent.EnterAIOAnimationEnd.class)), bVar), TuplesKt.to(jVar.a(Reflection.getOrCreateKotlinClass(AIOLifeCycleEvent.ResetAIO.class)), bVar)});
        this.mFirstMessageList = listOf;
    }

    private final void A() {
        com.tencent.qqnt.emotion.stickerrecommended.mvvm.b bVar = this.mViewModel;
        if (bVar != null) {
            bVar.Y0(new com.tencent.qqnt.emotion.stickerrecommended.mvvm.data.a(2));
        }
    }

    private final void B(boolean inWords) {
        long currentTimeMillis = (System.currentTimeMillis() - this.mLastShowTime) - 3000;
        if (!inWords) {
            if (currentTimeMillis > 0) {
                t();
                return;
            }
            MqqHandler mqqHandler = this.mUiHandler;
            if (mqqHandler == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mUiHandler");
                mqqHandler = null;
            }
            mqqHandler.sendEmptyMessageDelayed(69, -currentTimeMillis);
        }
    }

    private final void C() {
        if (this.hasInit) {
            return;
        }
        this.hasInit = true;
        com.tencent.aio.main.businesshelper.b bVar = this.mParam;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mParam");
            bVar = null;
        }
        LifecycleOwner d16 = bVar.a().d();
        Intrinsics.checkNotNullExpressionValue(d16, "mParam.aioContext.lifecycleOwner");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(d16), Dispatchers.getIO(), null, new StickerRecHelper$init$1(this, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D() {
        com.tencent.aio.main.businesshelper.b bVar = this.mParam;
        com.tencent.aio.main.businesshelper.b bVar2 = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mParam");
            bVar = null;
        }
        this.mOwner = bVar.a().c();
        com.tencent.qqnt.emotion.stickerrecommended.mvvm.b createViewModel = ((IStickerRecMvvmCreator) QRoute.api(IStickerRecMvvmCreator.class)).createViewModel(this.mOwner);
        if (createViewModel == null) {
            QLog.e("StickerRecHelper", 1, "[initViewModel] error, mViewModel is null! mOwner=" + this.mOwner);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        AppInterface appInterface = (AppInterface) peekAppRuntime;
        createViewModel.K0(appInterface);
        createViewModel.d1(true);
        com.tencent.aio.main.businesshelper.b bVar3 = this.mParam;
        if (bVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mParam");
            bVar3 = null;
        }
        createViewModel.init(bVar3.a().g());
        IStickerRecMvvmCreator iStickerRecMvvmCreator = (IStickerRecMvvmCreator) QRoute.api(IStickerRecMvvmCreator.class);
        com.tencent.aio.main.businesshelper.b bVar4 = this.mParam;
        if (bVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mParam");
            bVar4 = null;
        }
        Context context = bVar4.a().c().getContext();
        com.tencent.aio.main.businesshelper.b bVar5 = this.mParam;
        if (bVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mParam");
        } else {
            bVar2 = bVar5;
        }
        this.mViewBinder = iStickerRecMvvmCreator.createViewBinder(appInterface, context, bVar2.a(), createViewModel);
        this.mViewModel = createViewModel;
    }

    private final boolean E(Bundle customParam) {
        Object obj;
        String str = null;
        if (customParam != null) {
            try {
                obj = customParam.get("uintype");
            } catch (Throwable unused) {
                return false;
            }
        } else {
            obj = null;
        }
        if (obj != null) {
            str = obj.toString();
        }
        return TextUtils.equals(str, "10008");
    }

    private final boolean G(String from) {
        boolean z16;
        if (QLog.isDevelopLevel()) {
            QLog.d("StickerRecHelper", 4, "needRegisterMsgActionOnCreate from=" + from);
        }
        if (!Intrinsics.areEqual(from, "0") && !Intrinsics.areEqual(from, "23")) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (QLog.isColorLevel()) {
            QLog.i("StickerRecHelper", 2, "needRegisterMsgActionOnCreate from=" + from + ", result: " + z16);
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H() {
        com.tencent.aio.main.businesshelper.b bVar = this.mParam;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mParam");
            bVar = null;
        }
        bVar.a().e().f(this, this.mAction);
    }

    private final void I(List<? extends Pair<String, ? extends com.tencent.mvi.base.route.a>> messageList) {
        Iterator<T> it = messageList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            com.tencent.aio.main.businesshelper.b bVar = this.mParam;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mParam");
                bVar = null;
            }
            bVar.a().e().d((String) pair.getFirst(), (com.tencent.mvi.base.route.a) pair.getSecond());
        }
    }

    private final void J(MarkFaceMessage marketFaceMessage) {
        com.tencent.aio.main.businesshelper.b bVar = this.mParam;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mParam");
            bVar = null;
        }
        bVar.a().e().h(new AIOMsgSendEvent.MarketFaceSendEvent(marketFaceMessage));
    }

    private final void K(String filePath, String keyword, com.tencent.qqnt.msg.data.g picExtBizInfo, String originalMd5) {
        com.tencent.aio.main.businesshelper.b bVar = this.mParam;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mParam");
            bVar = null;
        }
        bVar.a().e().h(new AIOMsgSendEvent.PicEmotionSendEvent(filePath, 7, "[" + keyword + "]", picExtBizInfo, originalMd5));
    }

    private final void L(String title) {
        if (QLog.isColorLevel()) {
            QLog.d("StickerRecHelper", 2, "MSG_SHOW_EMOTIONKEYWORD_LAYOUT");
        }
        com.tencent.qqnt.emotion.stickerrecommended.mvvm.data.a aVar = new com.tencent.qqnt.emotion.stickerrecommended.mvvm.data.a(1);
        aVar.f356585b = title;
        com.tencent.qqnt.emotion.stickerrecommended.mvvm.b bVar = this.mViewModel;
        Intrinsics.checkNotNull(bVar);
        bVar.Y0(aVar);
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IDoutuService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "sMobileQQ.peekAppRuntime\u2026va, ProcessConstant.MAIN)");
        ((IDoutuService) runtimeService).hideDoutuEmotionLayout();
        MqqHandler mqqHandler = this.mUiHandler;
        MqqHandler mqqHandler2 = null;
        if (mqqHandler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUiHandler");
            mqqHandler = null;
        }
        mqqHandler.removeMessages(69);
        MqqHandler mqqHandler3 = this.mUiHandler;
        if (mqqHandler3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUiHandler");
        } else {
            mqqHandler2 = mqqHandler3;
        }
        mqqHandler2.sendEmptyMessageDelayed(69, 6000L);
        this.mLastShowTime = System.currentTimeMillis();
    }

    private final void M() {
        QLog.i("StickerRecHelper", 1, "unregisterMessage");
        com.tencent.aio.main.businesshelper.b bVar = this.mParam;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mParam");
            bVar = null;
        }
        bVar.a().e().i(this, this.mAction);
    }

    private final void N(List<? extends Pair<String, ? extends com.tencent.mvi.base.route.a>> messageList) {
        Iterator<T> it = messageList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            com.tencent.aio.main.businesshelper.b bVar = this.mParam;
            if (bVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mParam");
                bVar = null;
            }
            bVar.a().e().b((String) pair.getFirst(), (com.tencent.mvi.base.route.a) pair.getSecond());
        }
    }

    private final void m() {
        com.tencent.aio.main.businesshelper.b bVar = this.mParam;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mParam");
            bVar = null;
        }
        String string = bVar.a().g().l().getString("key_from");
        if (QLog.isColorLevel()) {
            QLog.i("StickerRecHelper", 2, "doOnCreate from=" + string);
        }
        if (G(string)) {
            I(this.mFirstMessageList);
        }
    }

    private final void n() {
        com.tencent.aio.main.businesshelper.b bVar = this.mParam;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mParam");
            bVar = null;
        }
        String string = bVar.a().g().l().getString("key_from");
        if (QLog.isColorLevel()) {
            QLog.d("StickerRecHelper", 2, "doOnDelayLoad from=" + string);
        }
        if (!G(string)) {
            if (QLog.isColorLevel()) {
                QLog.d("StickerRecHelper", 2, "doOnDelayLoad init.");
            }
            C();
        }
    }

    private final void o() {
        QLog.i("StickerRecHelper", 1, "doOnDestroy");
        N(this.mFirstMessageList);
        M();
        com.tencent.qqnt.emotion.stickerrecommended.mvvm.b bVar = this.mViewModel;
        if (bVar != null) {
            bVar.Y0(new com.tencent.qqnt.emotion.stickerrecommended.mvvm.data.a(3));
            bVar.d1(false);
        }
        com.tencent.qqnt.emotion.stickerrecommended.mvvm.a aVar = this.mViewBinder;
        if (aVar != null) {
            aVar.a(this.mOwner);
        }
        this.enableAsyncAnalyze = true;
        this.hasInit = false;
        this.mLastShowTime = 0L;
        this.mCurrentInputText = null;
        this.mViewModel = null;
        this.mViewBinder = null;
        this.mOwner = null;
    }

    private final void p() {
        if (QLog.isDevelopLevel()) {
            QLog.d("StickerRecHelper", 4, "doOnNewIntent");
        }
        com.tencent.qqnt.emotion.stickerrecommended.mvvm.b bVar = this.mViewModel;
        if (bVar != null) {
            bVar.Y0(new com.tencent.qqnt.emotion.stickerrecommended.mvvm.data.a(4));
        }
    }

    private final void q() {
        if (QLog.isDevelopLevel()) {
            QLog.d("StickerRecHelper", 4, "doOnResume");
        }
    }

    private final void r() {
        if (QLog.isDevelopLevel()) {
            QLog.d("StickerRecHelper", 4, "doOnStop");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(MsgIntent intent) {
        if (intent instanceof InputEditTextMsgIntent.EditTextChangedMsgIntent) {
            u(((InputEditTextMsgIntent.EditTextChangedMsgIntent) intent).c());
            return;
        }
        if (intent instanceof StickerRecommendEvent.ShowEmotionKeywordLayout) {
            if (QLog.isColorLevel()) {
                QLog.d("StickerRecHelper", 2, "StickerRecommendEvent.ShowEmotionKeywordLayout, mCurrentInputText = " + com.tencent.util.k.c(this.mCurrentInputText));
            }
            if (!TextUtils.isEmpty(this.mCurrentInputText) || this.canShowStickerRecommend) {
                L(((StickerRecommendEvent.ShowEmotionKeywordLayout) intent).a());
                return;
            }
            return;
        }
        MqqHandler mqqHandler = null;
        if (intent instanceof StickerRecommendEvent.HideEmotionKeywordLayout) {
            MqqHandler mqqHandler2 = this.mUiHandler;
            if (mqqHandler2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mUiHandler");
            } else {
                mqqHandler = mqqHandler2;
            }
            mqqHandler.sendEmptyMessageDelayed(69, ((StickerRecommendEvent.HideEmotionKeywordLayout) intent).a());
            return;
        }
        if (intent instanceof StickerRecommendEvent.CancelHideEmotionKeywordLayout) {
            MqqHandler mqqHandler3 = this.mUiHandler;
            if (mqqHandler3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mUiHandler");
            } else {
                mqqHandler = mqqHandler3;
            }
            mqqHandler.removeMessages(69);
            return;
        }
        if (intent instanceof StickerRecommendEvent.SendSticker) {
            StickerRecommendEvent.SendSticker sendSticker = (StickerRecommendEvent.SendSticker) intent;
            K(sendSticker.a(), sendSticker.b(), sendSticker.d(), sendSticker.c());
            return;
        }
        if (intent instanceof StickerRecommendEvent.SendMarketFace) {
            J(((StickerRecommendEvent.SendMarketFace) intent).a());
            return;
        }
        if (intent instanceof AIOMsgListEvent.ListScrollStateChanged) {
            v(((AIOMsgListEvent.ListScrollStateChanged) intent).a());
            return;
        }
        if (intent instanceof StickerRecommendEvent.TriggerShowEmotionKeywordLayout) {
            StickerRecommendEvent.TriggerShowEmotionKeywordLayout triggerShowEmotionKeywordLayout = (StickerRecommendEvent.TriggerShowEmotionKeywordLayout) intent;
            z(triggerShowEmotionKeywordLayout.b(), triggerShowEmotionKeywordLayout.a());
            return;
        }
        if (intent instanceof MsgItemExternalRefreshEvent.EnterAIOAnimationEnd) {
            if (((MsgItemExternalRefreshEvent.EnterAIOAnimationEnd) intent).a() == IAIOAnimationApi.AnimationScene.AIO_ENTER) {
                if (QLog.isColorLevel()) {
                    QLog.d("StickerRecHelper", 2, "EnterAIOAnimationEnd");
                }
                C();
                return;
            }
            return;
        }
        if (intent instanceof AIOLifeCycleEvent.ResetAIO) {
            boolean isSwitchOn = FreesiaWrapperImpl.INSTANCE.b().isSwitchOn("emoticon_sticker_reset_aio_124353103", true);
            QLog.d("StickerRecHelper", 1, "ResetAIOIntent  isSwitchOn:" + isSwitchOn);
            if (isSwitchOn) {
                C();
            }
        }
    }

    private final void t() {
        MqqHandler mqqHandler = this.mUiHandler;
        if (mqqHandler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUiHandler");
            mqqHandler = null;
        }
        mqqHandler.removeMessages(69);
        A();
    }

    private final void u(CharSequence s16) {
        boolean z16;
        this.mCurrentInputText = s16;
        if (s16.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            t();
        }
        if (F(s16)) {
            x(this, s16, null, 2, null);
        }
    }

    private final void v(int newState) {
        if (newState == 1) {
            t();
        }
    }

    private final void w(CharSequence s16, StickerRecKeywordFrom from) {
        if (this.enableAsyncAnalyze) {
            com.tencent.qqnt.emotion.stickerrecommended.mvvm.b bVar = this.mViewModel;
            if (bVar != null) {
                bVar.O0(s16.toString(), null, from, new b.a() { // from class: com.tencent.mobileqq.aio.helper.bf
                    @Override // com.tencent.qqnt.emotion.stickerrecommended.mvvm.b.a
                    public final void a(boolean z16) {
                        StickerRecHelper.y(StickerRecHelper.this, z16);
                    }
                });
                return;
            }
            return;
        }
        com.tencent.qqnt.emotion.stickerrecommended.mvvm.b bVar2 = this.mViewModel;
        boolean z16 = false;
        if (bVar2 != null && bVar2.z1(s16.toString(), null, from)) {
            z16 = true;
        }
        B(z16);
    }

    static /* synthetic */ void x(StickerRecHelper stickerRecHelper, CharSequence charSequence, StickerRecKeywordFrom stickerRecKeywordFrom, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            stickerRecKeywordFrom = StickerRecKeywordFrom.INPUT;
        }
        stickerRecHelper.w(charSequence, stickerRecKeywordFrom);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(StickerRecHelper this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.B(z16);
    }

    private final void z(CharSequence keyword, boolean ignoreSwitch) {
        boolean z16;
        boolean z17 = true;
        if (keyword.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.canShowStickerRecommend = z16;
        if (keyword.length() != 0) {
            z17 = false;
        }
        if (z17) {
            t();
        }
        if (ignoreSwitch || F(keyword)) {
            w(keyword, StickerRecKeywordFrom.LITE_ACTION);
        }
    }

    protected final boolean F(@NotNull CharSequence s16) {
        Bundle bundle;
        IStickerRecManager iStickerRecManager;
        AIOParam g16;
        AIOParam g17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) s16)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(s16, "s");
        com.tencent.aio.main.businesshelper.b bVar = this.mParam;
        String str = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mParam");
            bVar = null;
        }
        com.tencent.aio.api.runtime.a a16 = bVar.a();
        if (a16 != null && (g17 = a16.g()) != null) {
            bundle = g17.l();
        } else {
            bundle = null;
        }
        if (E(bundle)) {
            IQCircleEmoticonApi iQCircleEmoticonApi = (IQCircleEmoticonApi) QRoute.api(IQCircleEmoticonApi.class);
            com.tencent.aio.main.businesshelper.b bVar2 = this.mParam;
            if (bVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mParam");
                bVar2 = null;
            }
            com.tencent.aio.api.runtime.a a17 = bVar2.a();
            if (a17 != null && (g16 = a17.g()) != null) {
                str = Long.valueOf(su3.c.a(g16)).toString();
            }
            if (iQCircleEmoticonApi.isSingleFollowUin(str)) {
                return false;
            }
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null || (iStickerRecManager = (IStickerRecManager) peekAppRuntime.getRuntimeService(IStickerRecManager.class, "")) == null || !iStickerRecManager.isEmotionRecSettingOpen()) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 16;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Set) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.aio.input.edit.InputEditTextMsgIntent.EditTextChangedMsgIntent");
        hashSet.add("com.tencent.qqnt.emotion.stickerrecommended.event.StickerRecommendEvent.ShowEmotionKeywordLayout");
        hashSet.add("com.tencent.qqnt.emotion.stickerrecommended.event.StickerRecommendEvent.HideEmotionKeywordLayout");
        hashSet.add("com.tencent.qqnt.emotion.stickerrecommended.event.StickerRecommendEvent.CancelHideEmotionKeywordLayout");
        hashSet.add("com.tencent.qqnt.emotion.stickerrecommended.event.StickerRecommendEvent.SendSticker");
        hashSet.add("com.tencent.mobileqq.aio.event.AIOMsgListEvent.ListScrollStateChanged");
        hashSet.add("com.tencent.qqnt.emotion.stickerrecommended.event.StickerRecommendEvent.TriggerShowEmotionKeywordLayout");
        hashSet.add("com.tencent.qqnt.emotion.stickerrecommended.event.StickerRecommendEvent.SendMarketFace");
        return hashSet;
    }

    @Override // com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventRNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Set) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return new HashSet();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @NotNull
    public String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "StickerRecHelper";
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NotNull Message msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) msg2)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        int i3 = msg2.what;
        MqqHandler mqqHandler = null;
        if (i3 != 69) {
            if (i3 != 94) {
                return false;
            }
            com.tencent.qqnt.emotion.stickerrecommended.mvvm.b bVar = this.mViewModel;
            if (bVar != null) {
                bVar.Y0(new com.tencent.qqnt.emotion.stickerrecommended.mvvm.data.a(2));
            }
            MqqHandler mqqHandler2 = this.mUiHandler;
            if (mqqHandler2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mUiHandler");
            } else {
                mqqHandler = mqqHandler2;
            }
            mqqHandler.removeMessages(69);
            this.canShowStickerRecommend = false;
            return true;
        }
        MqqHandler mqqHandler3 = this.mUiHandler;
        if (mqqHandler3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUiHandler");
        } else {
            mqqHandler = mqqHandler3;
        }
        mqqHandler.removeMessages(69);
        com.tencent.qqnt.emotion.stickerrecommended.mvvm.b bVar2 = this.mViewModel;
        if (bVar2 != null) {
            bVar2.Y0(new com.tencent.qqnt.emotion.stickerrecommended.mvvm.data.a(3));
        }
        com.tencent.qqnt.emotion.stickerrecommended.mvvm.b bVar3 = this.mViewModel;
        if (bVar3 != null) {
            bVar3.f0(true);
        }
        this.canShowStickerRecommend = false;
        return true;
    }

    @Override // com.tencent.aio.main.businesshelper.g
    @NotNull
    public int[] interestedIn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (int[]) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return new int[]{0, 2, 3, 4, 9, 12};
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(@NotNull com.tencent.aio.main.businesshelper.b param) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) param);
            return;
        }
        Intrinsics.checkNotNullParameter(param, "param");
        this.mParam = param;
        this.mUiHandler = new MqqHandler(Looper.getMainLooper(), this);
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            h.a.b(this);
        }
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, state);
            return;
        }
        if (state != 0) {
            if (state != 9) {
                if (state != 12) {
                    if (state != 2) {
                        if (state != 3) {
                            if (state == 4) {
                                n();
                                return;
                            }
                            return;
                        }
                        q();
                        return;
                    }
                    p();
                    return;
                }
                o();
                return;
            }
            r();
            return;
        }
        m();
    }
}
