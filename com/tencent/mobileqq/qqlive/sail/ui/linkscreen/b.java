package com.tencent.mobileqq.qqlive.sail.ui.linkscreen;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.component.core.event.Eventor;
import com.tencent.component.core.event.impl.OnEvent;
import com.tencent.luggage.wxa.ig.w;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.now.linkpkanchorplay.componententry.AnchorRoomInfo;
import com.tencent.now.linkpkanchorplay.event.LinkPKWebEvent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.qqlive.tvkplayer.report.capability.spatialaudio.TVKDeviceSpatialAudioCapabilityReportConstant;
import com.tencent.timi.game.api.remoteres.BizId;
import com.tencent.timi.game.api.remoteres.IZipResDownloadApi;
import com.tencent.timi.game.api.remoteres.ZipInfo;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 32\u00020\u0001:\u00014B\u0007\u00a2\u0006\u0004\b1\u00102J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u0010\u001a\u00020\nJ\u0006\u0010\u0011\u001a\u00020\nJ\u0006\u0010\u0012\u001a\u00020\nJ\u000e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u0010\u0017\u001a\u00020\nR\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00150\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001d\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00150\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/linkscreen/b;", "Lcom/tencent/mobileqq/qqlive/sail/base/d;", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/qqlive/sail/model/d;", "roomInfo", "Lcom/tencent/biz/richframework/part/interfaces/IPartHost;", "partHost", "Lcom/tencent/now/linkpkanchorplay/componententry/f;", TVKDeviceSpatialAudioCapabilityReportConstant.SPATIAL_AUDIO_CAPABILITY_PARAM_SURPPORT, "", "Z1", "T1", "Landroidx/lifecycle/ViewModelProvider;", "Q1", "U1", "W1", "X1", "O1", "", "streamRecordType", "", "S1", "R1", "Landroidx/lifecycle/MutableLiveData;", "i", "Landroidx/lifecycle/MutableLiveData;", "_resReadyLiveData", "Landroidx/lifecycle/LiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LiveData;", "P1", "()Landroidx/lifecycle/LiveData;", "resReadyLiveData", "Lcom/tencent/qqlive/common/api/IAegisLogApi;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/qqlive/common/api/IAegisLogApi;", "aegisLogger", "D", "Z", "isStartDownload", "Lcom/tencent/component/core/event/Eventor;", "E", "Lcom/tencent/component/core/event/Eventor;", "eventor", "Lcom/tencent/now/linkpkanchorplay/componententry/g;", UserInfo.SEX_FEMALE, "Lcom/tencent/now/linkpkanchorplay/componententry/g;", "linkPKAnchorLogic", "<init>", "()V", "G", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class b extends com.tencent.mobileqq.qqlive.sail.base.d {
    static IPatchRedirector $redirector_;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final IAegisLogApi aegisLogger;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean isStartDownload;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Eventor eventor;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private com.tencent.now.linkpkanchorplay.componententry.g linkPKAnchorLogic;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _resReadyLiveData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> resReadyLiveData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/linkscreen/b$a;", "", "", "MMKV_KEY_HAS_SHOW_VIDEO_CUT_GUIDE", "Ljava/lang/String;", "TAG", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.linkscreen.b$a, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u001a\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/qqlive/sail/ui/linkscreen/b$b", "Lcom/tencent/timi/game/api/remoteres/a;", "", "a", "onSuccess", "", "errorCode", "", "errorMsg", "onFailed", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.linkscreen.b$b, reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public static final class C8395b implements com.tencent.timi.game.api.remoteres.a {
        static IPatchRedirector $redirector_;

        C8395b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // com.tencent.timi.game.api.remoteres.a
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                b.this.aegisLogger.i("PK_Biz|LinkScreenEntranceViewModel", "start download");
            }
        }

        @Override // com.tencent.timi.game.api.remoteres.a
        public void onFailed(int errorCode, @Nullable String errorMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                b.this.isStartDownload = false;
                b.this.aegisLogger.i("PK_Biz|LinkScreenEntranceViewModel", "downLoad fail:code:" + errorCode + " msg:" + errorMsg);
                b.this._resReadyLiveData.postValue(Boolean.FALSE);
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
            b.this.aegisLogger.i("PK_Biz|LinkScreenEntranceViewModel", "download success");
            b.this.isStartDownload = false;
            b.this._resReadyLiveData.postValue(Boolean.TRUE);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qqlive/sail/ui/linkscreen/b$c", "Lcom/tencent/component/core/event/impl/OnEvent;", "Lcom/tencent/now/linkpkanchorplay/event/c;", "event", "", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class c implements OnEvent<LinkPKWebEvent> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f272817a;

        c(Context context) {
            this.f272817a = context;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            }
        }

        @Override // com.tencent.component.core.event.impl.OnEvent
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onRecv(@Nullable LinkPKWebEvent event) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) event);
                return;
            }
            QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
            if (qBaseActivity != null) {
                Context context = this.f272817a;
                Bundle bundle = new Bundle();
                bundle.putInt("height_web_dialog", w.CTRL_INDEX);
                Drawable drawable = ContextCompat.getDrawable(context, R.drawable.f161950l22);
                Intrinsics.checkNotNull(event);
                com.tencent.mobileqq.qqlive.base.webview.a.g(qBaseActivity, drawable, event.getTitle(), event.getUrl(), bundle);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52280);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>();
        this._resReadyLiveData = mutableLiveData;
        this.resReadyLiveData = mutableLiveData;
        QRouteApi api = QRoute.api(IAegisLogApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IAegisLogApi::class.java)");
        this.aegisLogger = (IAegisLogApi) api;
        this.eventor = new Eventor();
    }

    private final ViewModelProvider Q1(IPartHost partHost) {
        ViewModelProvider.AndroidViewModelFactory androidViewModelFactory = ViewModelProvider.AndroidViewModelFactory.getInstance(ul3.b.c());
        Intrinsics.checkNotNullExpressionValue(androidViewModelFactory, "getInstance(AppRuntime.getApplication())");
        return new ViewModelProvider(partHost.getViewModelStore(), androidViewModelFactory);
    }

    private final void T1(Context context) {
        this.eventor.addOnEvent(new c(context));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void Z1(Context context, com.tencent.mobileqq.qqlive.sail.model.d roomInfo, IPartHost partHost, com.tencent.now.linkpkanchorplay.componententry.f support) {
        long j3;
        HashMap hashMap = new HashMap();
        com.tencent.mobileqq.qqlive.sail.c cVar = com.tencent.mobileqq.qqlive.sail.c.f272176a;
        hashMap.put("qqlive_user_id", String.valueOf(cVar.G()));
        hashMap.put("qqlive_anchor_id", String.valueOf(cVar.G()));
        hashMap.put("qqlive_room_id", String.valueOf(roomInfo.getRoomId()));
        hashMap.put("qqlive_program_id", roomInfo.getProgramId());
        hashMap.put("qqlive_zhibo_type", String.valueOf(roomInfo.getRoomType()));
        hashMap.put("qqlive_zhibo_content", String.valueOf(roomInfo.getRoomType()));
        Intrinsics.checkNotNull(partHost, "null cannot be cast to non-null type androidx.fragment.app.Fragment");
        FragmentManager parentFragmentManager = ((Fragment) partHost).getParentFragmentManager();
        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "partHost as Fragment).parentFragmentManager");
        LifecycleOwner lifecycleOwner = partHost.getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
        ViewModelProvider Q1 = Q1(partHost);
        long roomId = roomInfo.getRoomId();
        com.tencent.mobileqq.qqlive.sail.model.common.UserInfo j16 = roomInfo.j();
        if (j16 != null) {
            j3 = j16.f();
        } else {
            j3 = 0;
        }
        com.tencent.now.linkpkanchorplay.componententry.g gVar = new com.tencent.now.linkpkanchorplay.componententry.g(context, support, parentFragmentManager, lifecycleOwner, Q1, new AnchorRoomInfo(roomId, j3));
        gVar.e();
        gVar.g(hashMap);
        this.linkPKAnchorLogic = gVar;
    }

    public final void O1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (this.isStartDownload) {
            return;
        }
        this.isStartDownload = true;
        long currentTimeMillis = System.currentTimeMillis();
        IZipResDownloadApi iZipResDownloadApi = (IZipResDownloadApi) QRoute.api(IZipResDownloadApi.class);
        BaseApplication context = BaseApplication.context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        iZipResDownloadApi.download(context, BizId.PK_ANCHOR, new ZipInfo("https://downv6.qq.com/video_story/qcircle/qqlive/qqlive_linkpk_anchorplay_impl.zip", "36f888bb67b7d6724115f39d7caef72e"), new C8395b());
        long currentTimeMillis2 = System.currentTimeMillis();
        this.aegisLogger.i("PK_Biz|LinkScreenEntranceViewModel", "diff time: " + (currentTimeMillis2 - currentTimeMillis));
    }

    @NotNull
    public final LiveData<Boolean> P1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (LiveData) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.resReadyLiveData;
    }

    public final void R1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_QQLIVE);
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_QQLIVE)");
        from.encodeBool("hasShowVideoCutGuide", true);
    }

    public final boolean S1(int streamRecordType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, streamRecordType)).booleanValue();
        }
        if (streamRecordType != 2) {
            return false;
        }
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_QQLIVE);
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_QQLIVE)");
        if (from.decodeBool("hasShowVideoCutGuide", false)) {
            return false;
        }
        return true;
    }

    public final void U1(@NotNull com.tencent.mobileqq.qqlive.sail.model.d roomInfo, @NotNull IPartHost partHost, @NotNull com.tencent.now.linkpkanchorplay.componententry.f support) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, roomInfo, partHost, support);
            return;
        }
        Intrinsics.checkNotNullParameter(roomInfo, "roomInfo");
        Intrinsics.checkNotNullParameter(partHost, "partHost");
        Intrinsics.checkNotNullParameter(support, "support");
        BaseApplication context = BaseApplication.context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        Z1(context, roomInfo, partHost, support);
        BaseApplication context2 = BaseApplication.context;
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        T1(context2);
    }

    public final void W1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        com.tencent.now.linkpkanchorplay.componententry.g gVar = this.linkPKAnchorLogic;
        if (gVar != null) {
            gVar.i();
        }
        this.eventor.removeAll();
    }

    public final void X1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        com.tencent.now.linkpkanchorplay.componententry.g gVar = this.linkPKAnchorLogic;
        if (gVar != null) {
            gVar.f();
        }
    }
}
