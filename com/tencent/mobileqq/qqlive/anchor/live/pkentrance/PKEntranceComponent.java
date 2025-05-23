package com.tencent.mobileqq.qqlive.anchor.live.pkentrance;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.component.core.event.Eventor;
import com.tencent.component.core.event.impl.OnEvent;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.luggage.wxa.ig.w;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomInfo;
import com.tencent.mobileqq.qqlive.framework.interfaceService.InjectService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.now.linkpkanchorplay.componententry.AnchorRoomInfo;
import com.tencent.now.linkpkanchorplay.componententry.f;
import com.tencent.now.linkpkanchorplay.componententry.g;
import com.tencent.now.linkpkanchorplay.event.LinkPKWebEvent;
import com.tencent.now.linkpkanchorplay.guide.LinkMicVideoCutGuideDialog;
import com.tencent.now.linkpkanchorplay.invite.view.BottomDialog;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.timi.game.api.remoteres.BizId;
import com.tencent.timi.game.api.remoteres.IZipResDownloadApi;
import com.tencent.timi.game.api.remoteres.ZipInfo;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 72\u00020\u00012\u00020\u0002:\u00018B\u000f\u0012\u0006\u00104\u001a\u000203\u00a2\u0006\u0004\b5\u00106J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\f\u001a\u00020\u0005H\u0002J\u0006\u0010\r\u001a\u00020\u0005J\u0006\u0010\u000e\u001a\u00020\u0005J\u0006\u0010\u000f\u001a\u00020\u0005J\b\u0010\u0010\u001a\u00020\u0005H\u0016J\b\u0010\u0011\u001a\u00020\u0005H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0083.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0083.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010&\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010%R\u0016\u0010(\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010%R\u0016\u0010)\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010%R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u001b\u00102\u001a\u00020.8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010/\u001a\u0004\b0\u00101\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/qqlive/anchor/live/pkentrance/PKEntranceComponent;", "Lcom/tencent/mobileqq/qqlive/framework/component/b;", "Landroidx/lifecycle/ViewModelStoreOwner;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", BdhLogUtil.LogTag.Tag_Conn, "v", "Landroidx/lifecycle/ViewModelProvider$Factory;", "factory", "Landroidx/lifecycle/ViewModelProvider;", "y", "B", "u", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "E", "k", "i", "Landroidx/lifecycle/ViewModelStore;", "getViewModelStore", "Lcom/tencent/now/linkpkanchorplay/componententry/f;", "pkBtnSupport", "Lcom/tencent/now/linkpkanchorplay/componententry/f;", "Lcom/tencent/mobileqq/qqlive/base/room/service/a;", "qqLiveRoomService", "Lcom/tencent/mobileqq/qqlive/base/room/service/a;", "e", "Landroidx/lifecycle/ViewModelStore;", "viewModelStore", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "f", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "aegisLogger", "Lcom/tencent/component/core/event/Eventor;", h.F, "Lcom/tencent/component/core/event/Eventor;", "eventor", "Z", "isDownloadSuccess", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "isStartDownload", "isWaitCallProcessEntryClick", "Ljava/lang/Runnable;", "D", "Ljava/lang/Runnable;", "downloadResTask", "Lcom/tencent/now/linkpkanchorplay/componententry/g;", "Lkotlin/Lazy;", HippyTKDListViewAdapter.X, "()Lcom/tencent/now/linkpkanchorplay/componententry/g;", "linkPKAnchorLogic", "Lfi2/a;", "cc", "<init>", "(Lfi2/a;)V", UserInfo.SEX_FEMALE, "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class PKEntranceComponent extends com.tencent.mobileqq.qqlive.framework.component.b implements ViewModelStoreOwner {
    static IPatchRedirector $redirector_;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private boolean isWaitCallProcessEntryClick;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Runnable downloadResTask;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy linkPKAnchorLogic;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewModelStore viewModelStore;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IAegisLogApi aegisLogger;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Eventor eventor;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isDownloadSuccess;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isStartDownload;

    @InjectService(key = f.class)
    private f pkBtnSupport;

    @InjectService(key = com.tencent.mobileqq.qqlive.base.room.service.a.class)
    private com.tencent.mobileqq.qqlive.base.room.service.a qqLiveRoomService;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/qqlive/anchor/live/pkentrance/PKEntranceComponent$a;", "", "", "MMKV_KEY_HAS_SHOW_VIDEO_CUT_GUIDE", "Ljava/lang/String;", "TAG", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.anchor.live.pkentrance.PKEntranceComponent$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
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

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qqlive/anchor/live/pkentrance/PKEntranceComponent$b", "Lcom/tencent/component/core/event/impl/OnEvent;", "Lcom/tencent/now/linkpkanchorplay/event/c;", "event", "", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b implements OnEvent<LinkPKWebEvent> {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PKEntranceComponent.this);
            }
        }

        @Override // com.tencent.component.core.event.impl.OnEvent
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onRecv(@Nullable LinkPKWebEvent event) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) event);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("height_web_dialog", w.CTRL_INDEX);
            Drawable drawable = ContextCompat.getDrawable(PKEntranceComponent.this.e().getContext(), R.drawable.f161950l22);
            Context context = PKEntranceComponent.this.e().getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            Activity activity = (Activity) context;
            String str2 = null;
            if (event != null) {
                str = event.getTitle();
            } else {
                str = null;
            }
            if (event != null) {
                str2 = event.getUrl();
            }
            com.tencent.mobileqq.qqlive.base.webview.a.g(activity, drawable, str, str2, bundle);
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u001a\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/qqlive/anchor/live/pkentrance/PKEntranceComponent$c", "Lcom/tencent/timi/game/api/remoteres/a;", "", "a", "onSuccess", "", "errorCode", "", "errorMsg", "onFailed", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class c implements com.tencent.timi.game.api.remoteres.a {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PKEntranceComponent.this);
            }
        }

        @Override // com.tencent.timi.game.api.remoteres.a
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                PKEntranceComponent.this.aegisLogger.i("PKEntranceComponent", "start download");
            }
        }

        @Override // com.tencent.timi.game.api.remoteres.a
        public void onFailed(int errorCode, @Nullable String errorMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                PKEntranceComponent.this.isStartDownload = false;
                PKEntranceComponent.this.aegisLogger.i("PKEntranceComponent", "downLoad fail:code:" + errorCode + " msg:" + errorMsg);
                QQToast.makeText(PKEntranceComponent.this.e().getContext(), 1, PKEntranceComponent.this.e().getContext().getResources().getString(R.string.f221206a7), 1).show();
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, errorCode, (Object) errorMsg);
        }

        @Override // com.tencent.timi.game.api.remoteres.a
        public void onSuccess() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            PKEntranceComponent.this.aegisLogger.i("PKEntranceComponent", "download success");
            PKEntranceComponent.this.isDownloadSuccess = true;
            PKEntranceComponent.this.isStartDownload = false;
            if (PKEntranceComponent.this.isWaitCallProcessEntryClick) {
                PKEntranceComponent.this.A();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20559);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PKEntranceComponent(@NotNull fi2.a cc5) {
        super(cc5);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(cc5, "cc");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) cc5);
            return;
        }
        this.viewModelStore = new ViewModelStore();
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.aegisLogger = (IAegisLogApi) api;
        this.eventor = new Eventor();
        this.downloadResTask = new Runnable() { // from class: com.tencent.mobileqq.qqlive.anchor.live.pkentrance.c
            @Override // java.lang.Runnable
            public final void run() {
                PKEntranceComponent.w(PKEntranceComponent.this);
            }
        };
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<g>() { // from class: com.tencent.mobileqq.qqlive.anchor.live.pkentrance.PKEntranceComponent$linkPKAnchorLogic$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PKEntranceComponent.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final g invoke() {
                f fVar;
                f fVar2;
                ViewModelProvider y16;
                com.tencent.mobileqq.qqlive.base.room.service.a aVar;
                com.tencent.mobileqq.qqlive.base.room.service.a aVar2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (g) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                Context context = PKEntranceComponent.this.e().getContext();
                fVar = PKEntranceComponent.this.pkBtnSupport;
                com.tencent.mobileqq.qqlive.base.room.service.a aVar3 = null;
                if (fVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pkBtnSupport");
                    fVar2 = null;
                } else {
                    fVar2 = fVar;
                }
                Context context2 = PKEntranceComponent.this.e().getContext();
                Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                FragmentManager supportFragmentManager = ((FragmentActivity) context2).getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "componentContext.getCont\u2026y).supportFragmentManager");
                LifecycleOwner lifecycleOwner = PKEntranceComponent.this.e().getLifecycleOwner();
                y16 = PKEntranceComponent.this.y(null);
                aVar = PKEntranceComponent.this.qqLiveRoomService;
                if (aVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
                    aVar = null;
                }
                long roomId = aVar.getRoomId();
                aVar2 = PKEntranceComponent.this.qqLiveRoomService;
                if (aVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
                } else {
                    aVar3 = aVar2;
                }
                QQLiveAnchorRoomInfo anchorRoomInfo = aVar3.getAnchorRoomInfo();
                return new g(context, fVar2, supportFragmentManager, lifecycleOwner, y16, new AnchorRoomInfo(roomId, anchorRoomInfo != null ? anchorRoomInfo.uid : 0L));
            }
        });
        this.linkPKAnchorLogic = lazy;
    }

    private final void B() {
        com.tencent.mobileqq.qqlive.sail.c cVar = com.tencent.mobileqq.qqlive.sail.c.f272176a;
        if (cVar.d().t()) {
            HashMap hashMap = new HashMap();
            hashMap.put("qqlive_user_id", String.valueOf(cVar.G()));
            hashMap.put("qqlive_anchor_id", String.valueOf(cVar.G()));
            hashMap.put("qqlive_room_id", String.valueOf(cVar.d().n()));
            hashMap.put("qqlive_program_id", cVar.d().l());
            hashMap.put("qqlive_zhibo_type", String.valueOf(cVar.d().p()));
            hashMap.put("qqlive_zhibo_content", String.valueOf(cVar.d().p()));
            x().g(hashMap);
            return;
        }
        com.tencent.mobileqq.qqlive.base.room.service.a aVar = this.qqLiveRoomService;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            aVar = null;
        }
        QQLiveAnchorRoomInfo anchorRoomInfo = aVar.getAnchorRoomInfo();
        if (anchorRoomInfo != null) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("qqlive_user_id", String.valueOf(anchorRoomInfo.uid));
            hashMap2.put("qqlive_anchor_id", String.valueOf(anchorRoomInfo.uid));
            hashMap2.put("qqlive_room_id", String.valueOf(anchorRoomInfo.roomAttr.roomId));
            hashMap2.put("qqlive_program_id", anchorRoomInfo.roomData.programId.toString());
            hashMap2.put("qqlive_zhibo_type", String.valueOf(anchorRoomInfo.roomData.liveRoomType));
            hashMap2.put("qqlive_zhibo_content", String.valueOf(anchorRoomInfo.roomData.liveRoomType));
            x().g(hashMap2);
        }
    }

    private final void C() {
        final LinkMicVideoCutGuideDialog linkMicVideoCutGuideDialog = new LinkMicVideoCutGuideDialog();
        linkMicVideoCutGuideDialog.th(new BottomDialog.a() { // from class: com.tencent.mobileqq.qqlive.anchor.live.pkentrance.b
            @Override // com.tencent.now.linkpkanchorplay.invite.view.BottomDialog.a
            public final void onDismiss(DialogInterface dialogInterface) {
                PKEntranceComponent.D(LinkMicVideoCutGuideDialog.this, this, dialogInterface);
            }
        });
        Context context = e().getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        linkMicVideoCutGuideDialog.show(((FragmentActivity) context).getSupportFragmentManager(), "showVideoCutGuideDialog");
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_QQLIVE);
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_QQLIVE)");
        from.encodeBool("hasShowVideoCutGuide", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(LinkMicVideoCutGuideDialog dialog, PKEntranceComponent this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (dialog.getDismissFromClickButton()) {
            this$0.A();
        }
    }

    private final void v() {
        ThreadManagerV2.excute(this.downloadResTask, 64, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(PKEntranceComponent this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isStartDownload) {
            return;
        }
        this$0.isStartDownload = true;
        long currentTimeMillis = System.currentTimeMillis();
        ((IZipResDownloadApi) QRoute.api(IZipResDownloadApi.class)).download(this$0.e().getContext(), BizId.PK_ANCHOR, new ZipInfo("https://downv6.qq.com/video_story/qcircle/qqlive/qqlive_linkpk_anchorplay_impl.zip", "36f888bb67b7d6724115f39d7caef72e"), new c());
        long currentTimeMillis2 = System.currentTimeMillis();
        this$0.aegisLogger.i("PKEntranceComponent", "diff time: " + (currentTimeMillis2 - currentTimeMillis));
    }

    private final g x() {
        return (g) this.linkPKAnchorLogic.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ViewModelProvider y(ViewModelProvider.Factory factory) {
        if (factory == null) {
            factory = ViewModelProvider.AndroidViewModelFactory.getInstance(ul3.b.c());
        }
        return new ViewModelProvider(this.viewModelStore, factory);
    }

    private final boolean z() {
        if (com.tencent.mobileqq.qqlive.sail.c.f272176a.d().r() != 2) {
            return false;
        }
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_QQLIVE);
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_QQLIVE)");
        if (from.decodeBool("hasShowVideoCutGuide", false)) {
            return false;
        }
        return true;
    }

    public final void A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (this.isStartDownload) {
            this.isWaitCallProcessEntryClick = true;
            return;
        }
        if (!this.isDownloadSuccess) {
            this.isWaitCallProcessEntryClick = true;
            v();
        } else if (z()) {
            C();
        } else {
            this.isWaitCallProcessEntryClick = false;
            x().f();
        }
    }

    public final void E() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            x().h();
        }
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    @NotNull
    public ViewModelStore getViewModelStore() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (ViewModelStore) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.viewModelStore;
    }

    @Override // com.tencent.mobileqq.qqlive.framework.component.e
    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            x().i();
            this.eventor.removeAll();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.framework.component.e
    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }

    public final void u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        v();
        x().e();
        this.eventor.addOnEvent(new b());
        B();
    }
}
