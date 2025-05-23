package com.tencent.mobileqq.zootopia.view;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.z1.cloudmod.api.ZPlanCloudGameInfo;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.mapstatus.ZootopiaMapStatusService;
import com.tencent.mobileqq.zootopia.view.ZootopiaDownloadButtonBinder;
import com.tencent.mobileqq.zplan.cloudmod.api.CloudModClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.sqshow.zootopia.data.ButtonStatus;
import com.tencent.sqshow.zootopia.data.ZootopiaMapSimpleInfo;
import com.tencent.sqshow.zootopia.mapstatus.ZootopiaMapStatusManager;
import com.tencent.sqshow.zootopia.mapstatus.b;
import com.tencent.sqshow.zootopia.portal.home.ParadiseLifecycleAdapter;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Foreground;
import qv4.ap;
import qv4.bf;
import si3.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\u0018\u0000 K2\u00020\u0001:\u0002LMB\u001f\u0012\u0006\u0010(\u001a\u00020$\u0012\u0006\u0010,\u001a\u00020\u001d\u0012\u0006\u00102\u001a\u00020-\u00a2\u0006\u0004\bI\u0010JJH\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0010H\u0002J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0013\u001a\u00020\u000bH\u0002J\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002JF\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nJ*\u0010\u001c\u001a\u00020\u000b2\"\u0010\u001b\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00190\u0018j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0019`\u001aJ\u0012\u0010\u001f\u001a\u00020\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010 \u001a\u00020\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010!\u001a\u00020\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010\"\u001a\u00020\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010#\u001a\u00020\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016R\u0017\u0010(\u001a\u00020$8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010%\u001a\u0004\b&\u0010'R\u0017\u0010,\u001a\u00020\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010)\u001a\u0004\b*\u0010+R\u0017\u00102\u001a\u00020-8\u0006\u00a2\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\"\u00108\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b.\u00105\"\u0004\b6\u00107R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u00109R6\u0010;\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018j\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0019\u0018\u0001`\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010:R\u001b\u0010A\u001a\u00020<8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\u001a\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00140B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u001a\u0010H\u001a\b\u0012\u0004\u0012\u00020F0B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u0010D\u00a8\u0006N"}, d2 = {"Lcom/tencent/mobileqq/zootopia/view/ZootopiaDownloadButtonBinder;", "Lpa4/a;", "Lcom/tencent/mobileqq/zootopia/view/ZootopiaDownloadButton;", "downloadButton", "Lcom/tencent/sqshow/zootopia/data/ZootopiaMapSimpleInfo;", "info", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "sourceCurrent", "", "loadedText", "Lkotlin/Function0;", "", "buttonClickListener", "", "isCloudMod", "d", "Lqv4/ap;", "k", DomainData.DOMAIN_NAME, "i", "Lcom/tencent/sqshow/zootopia/data/ButtonStatus;", "buttonStatus", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "e", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "params", "l", "Landroidx/lifecycle/LifecycleOwner;", "owner", DKHippyEvent.EVENT_STOP, "onStart", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/content/Context;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Landroidx/lifecycle/LifecycleOwner;", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Loa4/a;", "f", "Loa4/a;", "g", "()Loa4/a;", "mapResViewModel", tl.h.F, "Lcom/tencent/sqshow/zootopia/data/ZootopiaMapSimpleInfo;", "()Lcom/tencent/sqshow/zootopia/data/ZootopiaMapSimpleInfo;", "setCurrMapInfo", "(Lcom/tencent/sqshow/zootopia/data/ZootopiaMapSimpleInfo;)V", "currMapInfo", "Lcom/tencent/mobileqq/zootopia/view/ZootopiaDownloadButton;", "Ljava/util/HashMap;", "cardReportParams", "Lcom/tencent/mobileqq/zootopia/mapstatus/ZootopiaMapStatusService;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "getMapStatusService", "()Lcom/tencent/mobileqq/zootopia/mapstatus/ZootopiaMapStatusService;", "mapStatusService", "Landroidx/lifecycle/Observer;", "D", "Landroidx/lifecycle/Observer;", "statusObserver", "", "E", "progressObserver", "<init>", "(Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;Loa4/a;)V", UserInfo.SEX_FEMALE, "a", "ZootopiaItemDownloadListener", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaDownloadButtonBinder implements pa4.a {

    /* renamed from: F, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private final Lazy mapStatusService;

    /* renamed from: D, reason: from kotlin metadata */
    private final Observer<ButtonStatus> statusObserver;

    /* renamed from: E, reason: from kotlin metadata */
    private final Observer<Float> progressObserver;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final LifecycleOwner lifecycleOwner;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final oa4.a mapResViewModel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ZootopiaMapSimpleInfo currMapInfo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ZootopiaDownloadButton downloadButton;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private HashMap<String, Object> cardReportParams;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/zootopia/view/ZootopiaDownloadButtonBinder$a;", "", "Lcom/tencent/sqshow/zootopia/data/ButtonStatus;", "status", "", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zootopia.view.ZootopiaDownloadButtonBinder$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(ButtonStatus status) {
            Intrinsics.checkNotNullParameter(status, "status");
            return status == ButtonStatus.INIT || status == ButtonStatus.MAINTENANCE || status == ButtonStatus.UPDATE_SYSTEM || status == ButtonStatus.INVALID || status == ButtonStatus.ONLY_DOWNLOAD;
        }

        Companion() {
        }
    }

    public ZootopiaDownloadButtonBinder(Context context, LifecycleOwner lifecycleOwner, oa4.a mapResViewModel) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(mapResViewModel, "mapResViewModel");
        this.context = context;
        this.lifecycleOwner = lifecycleOwner;
        this.mapResViewModel = mapResViewModel;
        this.currMapInfo = new ZootopiaMapSimpleInfo(0, 1, null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ZootopiaMapStatusService>() { // from class: com.tencent.mobileqq.zootopia.view.ZootopiaDownloadButtonBinder$mapStatusService$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZootopiaMapStatusService invoke() {
                return new ZootopiaMapStatusService();
            }
        });
        this.mapStatusService = lazy;
        this.statusObserver = new Observer() { // from class: com.tencent.mobileqq.zootopia.view.r
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ZootopiaDownloadButtonBinder.j(ZootopiaDownloadButtonBinder.this, (ButtonStatus) obj);
            }
        };
        this.progressObserver = new Observer() { // from class: com.tencent.mobileqq.zootopia.view.s
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ZootopiaDownloadButtonBinder.h(ZootopiaDownloadButtonBinder.this, (Float) obj);
            }
        };
        lifecycleOwner.getLifecycle().addObserver(new ParadiseLifecycleAdapter(this, lifecycleOwner));
    }

    private final void d(ZootopiaDownloadButton downloadButton, ZootopiaMapSimpleInfo info, ZootopiaSource sourceCurrent, String loadedText, Function0<Unit> buttonClickListener, boolean isCloudMod) {
        if (this.currMapInfo.getMapID() != 0) {
            i();
        }
        this.currMapInfo = info;
        downloadButton.setDownloadSize(info);
        Context context = downloadButton.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        downloadButton.setButtonStatusListener(new ZootopiaItemDownloadListener(this, sourceCurrent, context, buttonClickListener));
        if (loadedText == null) {
            loadedText = info.getButton();
        }
        downloadButton.setIsInitCloudModType(isCloudMod);
        if (isCloudMod) {
            ButtonStatus buttonStatus = ButtonStatus.CLOUD_GAME;
            downloadButton.setStatus(buttonStatus);
            downloadButton.setStatusText(buttonStatus, loadedText);
        } else {
            downloadButton.setStatusText(ButtonStatus.LOADED, loadedText);
        }
        QLog.d("ZootopiaDownloadButtonBinder", 1, " binder Download Res " + info.getMapID());
        this.downloadButton = downloadButton;
        this.mapResViewModel.M1(String.valueOf(info.getMapID()));
        n(info);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(ZootopiaDownloadButtonBinder this$0, Float it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ZootopiaDownloadButton zootopiaDownloadButton = this$0.downloadButton;
        if (zootopiaDownloadButton != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            zootopiaDownloadButton.setProcess(it.floatValue());
        }
    }

    private final void i() {
        LiveData<ButtonStatus> P1 = this.mapResViewModel.P1(String.valueOf(this.currMapInfo.getMapID()));
        if (P1 != null) {
            P1.removeObserver(this.statusObserver);
        }
        LiveData<Float> O1 = this.mapResViewModel.O1(String.valueOf(this.currMapInfo.getMapID()));
        if (O1 != null) {
            O1.removeObserver(this.progressObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(ZootopiaDownloadButtonBinder this$0, ButtonStatus it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ZootopiaDownloadButton zootopiaDownloadButton = this$0.downloadButton;
        if (zootopiaDownloadButton != null) {
            if (zootopiaDownloadButton.getIsInitCloudModType()) {
                Companion companion = INSTANCE;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (companion.a(it)) {
                    zootopiaDownloadButton.setStatus(ButtonStatus.CLOUD_GAME);
                    return;
                }
            }
            zootopiaDownloadButton.B();
            Intrinsics.checkNotNullExpressionValue(it, "it");
            zootopiaDownloadButton.setStatus(it);
            this$0.m(it);
        }
    }

    private final void k(ap info) {
        pv4.y yVar = info.f429983j;
        if (yVar != null) {
            ZootopiaMapStatusManager.f370743d.e(String.valueOf(info.f429974a), yVar);
        }
    }

    private final void m(ButtonStatus buttonStatus) {
        com.tencent.sqshow.zootopia.mapstatus.b d16;
        b.MapServerStatusResult d17;
        QLog.i("ZootopiaDownloadButtonBinder", 1, "update mapInfo " + buttonStatus);
        if (buttonStatus != ButtonStatus.UPDATE || (d16 = ZootopiaMapStatusManager.f370743d.d(String.valueOf(this.currMapInfo.getMapID()))) == null || (d17 = d16.d()) == null) {
            return;
        }
        QLog.i("ZootopiaDownloadButtonBinder", 1, "update button mapId : $" + this.currMapInfo.getMapID() + " Info before: " + this.currMapInfo.getSimpleVerInfo().getModVersionSimpleData().getNowMapVer() + " after: " + d17.getModVersionSimpleData().getNowMapVer());
        this.currMapInfo.updateDataFromMapServerStatusResult(d17);
        ZootopiaDownloadButton zootopiaDownloadButton = this.downloadButton;
        if (zootopiaDownloadButton != null) {
            zootopiaDownloadButton.setDownloadSize(this.currMapInfo);
        }
    }

    private final void n(ZootopiaMapSimpleInfo info) {
        LiveData<ButtonStatus> P1 = this.mapResViewModel.P1(String.valueOf(info.getMapID()));
        if (P1 != null) {
            P1.observe(this.lifecycleOwner, this.statusObserver);
        }
        LiveData<Float> O1 = this.mapResViewModel.O1(String.valueOf(info.getMapID()));
        if (O1 != null) {
            O1.observe(this.lifecycleOwner, this.progressObserver);
        }
    }

    public final void e(ZootopiaDownloadButton downloadButton, ap info, ZootopiaSource sourceCurrent, String loadedText, boolean isCloudMod, Function0<Unit> buttonClickListener) {
        Intrinsics.checkNotNullParameter(downloadButton, "downloadButton");
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(sourceCurrent, "sourceCurrent");
        d(downloadButton, com.tencent.mobileqq.zootopia.utils.f.f329556a.c(info), sourceCurrent, loadedText, buttonClickListener, isCloudMod);
        k(info);
    }

    /* renamed from: f, reason: from getter */
    public final ZootopiaMapSimpleInfo getCurrMapInfo() {
        return this.currMapInfo;
    }

    /* renamed from: g, reason: from getter */
    public final oa4.a getMapResViewModel() {
        return this.mapResViewModel;
    }

    public final void l(HashMap<String, Object> params) {
        Intrinsics.checkNotNullParameter(params, "params");
        this.cardReportParams = params;
    }

    @Override // pa4.a
    public void onDestroy(LifecycleOwner owner) {
        QLog.i("ZootopiaDownloadButtonBinder", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        i();
    }

    @Override // pa4.a
    public void onPause(LifecycleOwner owner) {
        QLog.i("ZootopiaDownloadButtonBinder", 1, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
    }

    @Override // pa4.a
    public void onResume(LifecycleOwner owner) {
        QLog.i("ZootopiaDownloadButtonBinder", 1, "onResume");
    }

    @Override // pa4.a
    public void onStart(LifecycleOwner owner) {
        QLog.i("ZootopiaDownloadButtonBinder", 1, "onStart");
    }

    @Override // pa4.a
    public void onStop(LifecycleOwner owner) {
        QLog.i("ZootopiaDownloadButtonBinder", 1, DKHippyEvent.EVENT_STOP);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u001a\u001a\u00020\u0018\u0012\u0006\u0010%\u001a\u00020\u001b\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0011\u00a2\u0006\u0004\b&\u0010'J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u0017\u0010\u0010\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001f\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0019R\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0019R\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0019R\u001b\u0010$\u001a\u00020 8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\u0012\u0010#\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/zootopia/view/ZootopiaDownloadButtonBinder$ZootopiaItemDownloadListener;", "Lcom/tencent/mobileqq/zplan/cloudmod/api/CloudModClickListener;", "", "isSuccess", "", "f", "Landroid/view/View;", "view", "Lcom/tencent/sqshow/zootopia/data/ButtonStatus;", "type", "b", "Landroid/content/Context;", "d", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lkotlin/Function0;", "e", "Lkotlin/jvm/functions/Function0;", "getButtonClickListener", "()Lkotlin/jvm/functions/Function0;", "buttonClickListener", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/zootopia/view/ZootopiaDownloadButtonBinder;", "Ljava/lang/ref/WeakReference;", "binderRef", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "g", "sourceCurrentReference", tl.h.F, "contextReference", "Lcom/tencent/mobileqq/zootopia/utils/k;", "i", "Lkotlin/Lazy;", "()Lcom/tencent/mobileqq/zootopia/utils/k;", "upgradeUtils", "sourceCurrent", "<init>", "(Lcom/tencent/mobileqq/zootopia/view/ZootopiaDownloadButtonBinder;Lcom/tencent/mobileqq/zootopia/ZootopiaSource;Landroid/content/Context;Lkotlin/jvm/functions/Function0;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class ZootopiaItemDownloadListener extends CloudModClickListener {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final Context context;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final Function0<Unit> buttonClickListener;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<ZootopiaDownloadButtonBinder> binderRef;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private WeakReference<ZootopiaSource> sourceCurrentReference;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private WeakReference<Context> contextReference;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private final Lazy upgradeUtils;

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes35.dex */
        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f329646a;

            static {
                int[] iArr = new int[ButtonStatus.values().length];
                try {
                    iArr[ButtonStatus.INIT.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ButtonStatus.LOADED.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[ButtonStatus.PAUSE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[ButtonStatus.UPDATE.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[ButtonStatus.LOADING.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[ButtonStatus.UPDATE_SYSTEM.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[ButtonStatus.WAITING.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                try {
                    iArr[ButtonStatus.CAN_APPOINTMENT.ordinal()] = 8;
                } catch (NoSuchFieldError unused8) {
                }
                try {
                    iArr[ButtonStatus.MAINTENANCE.ordinal()] = 9;
                } catch (NoSuchFieldError unused9) {
                }
                try {
                    iArr[ButtonStatus.ONLY_DOWNLOAD.ordinal()] = 10;
                } catch (NoSuchFieldError unused10) {
                }
                try {
                    iArr[ButtonStatus.APPOINTED.ordinal()] = 11;
                } catch (NoSuchFieldError unused11) {
                }
                try {
                    iArr[ButtonStatus.CLOUD_GAME.ordinal()] = 12;
                } catch (NoSuchFieldError unused12) {
                }
                f329646a = iArr;
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zootopia/view/ZootopiaDownloadButtonBinder$ZootopiaItemDownloadListener$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lqv4/bf;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes35.dex */
        public static final class b implements com.tencent.mobileqq.zootopia.api.e<bf> {
            b() {
            }

            @Override // com.tencent.mobileqq.zootopia.api.e
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResultSuccess(bf result) {
                Intrinsics.checkNotNullParameter(result, "result");
                ZootopiaItemDownloadListener.this.f(true);
            }

            @Override // com.tencent.mobileqq.zootopia.api.e
            public void onResultFailure(int error, String message) {
                ZootopiaItemDownloadListener.this.f(false);
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/zootopia/view/ZootopiaDownloadButtonBinder$ZootopiaItemDownloadListener$c", "Lcom/tencent/mobileqq/zplan/cloudmod/api/b;", "", "b", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes35.dex */
        public static final class c implements com.tencent.mobileqq.zplan.cloudmod.api.b {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ ZootopiaDownloadButtonBinder f329648a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ ZootopiaMapSimpleInfo f329649b;

            c(ZootopiaDownloadButtonBinder zootopiaDownloadButtonBinder, ZootopiaMapSimpleInfo zootopiaMapSimpleInfo) {
                this.f329648a = zootopiaDownloadButtonBinder;
                this.f329649b = zootopiaMapSimpleInfo;
            }

            @Override // com.tencent.mobileqq.zplan.cloudmod.api.b
            public void a() {
                QLog.d("ZootopiaDownloadButtonBinder", 1, "onEnterMod");
            }

            @Override // com.tencent.mobileqq.zplan.cloudmod.api.b
            public void b() {
                QLog.d("ZootopiaDownloadButtonBinder", 1, "onBack2Native");
                oa4.a.X1(this.f329648a.getMapResViewModel(), this.f329649b, false, 2, null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ZootopiaItemDownloadListener(ZootopiaDownloadButtonBinder binderRef, ZootopiaSource sourceCurrent, Context context, Function0<Unit> function0) {
            super(binderRef.getCurrMapInfo().getMapID(), sourceCurrent, null, 4, null);
            Lazy lazy;
            Intrinsics.checkNotNullParameter(binderRef, "binderRef");
            Intrinsics.checkNotNullParameter(sourceCurrent, "sourceCurrent");
            Intrinsics.checkNotNullParameter(context, "context");
            this.context = context;
            this.buttonClickListener = function0;
            this.binderRef = new WeakReference<>(binderRef);
            this.sourceCurrentReference = new WeakReference<>(sourceCurrent);
            this.contextReference = new WeakReference<>(context);
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.zootopia.utils.k>() { // from class: com.tencent.mobileqq.zootopia.view.ZootopiaDownloadButtonBinder$ZootopiaItemDownloadListener$upgradeUtils$2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final com.tencent.mobileqq.zootopia.utils.k invoke() {
                    return new com.tencent.mobileqq.zootopia.utils.k();
                }
            });
            this.upgradeUtils = lazy;
        }

        private final com.tencent.mobileqq.zootopia.utils.k e() {
            return (com.tencent.mobileqq.zootopia.utils.k) this.upgradeUtils.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void f(final boolean isSuccess) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.view.t
                @Override // java.lang.Runnable
                public final void run() {
                    ZootopiaDownloadButtonBinder.ZootopiaItemDownloadListener.g(isSuccess);
                }
            });
        }

        @Override // com.tencent.mobileqq.zplan.cloudmod.api.CloudModClickListener
        public void b(View view, ButtonStatus type) {
            Context context;
            pv4.k[] kVarArr;
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(type, "type");
            Function0<Unit> function0 = this.buttonClickListener;
            if (function0 != null) {
                function0.invoke();
            }
            ZootopiaDownloadButtonBinder zootopiaDownloadButtonBinder = this.binderRef.get();
            if (zootopiaDownloadButtonBinder == null) {
                return;
            }
            ZootopiaMapSimpleInfo currMapInfo = zootopiaDownloadButtonBinder.getCurrMapInfo();
            ZootopiaSource zootopiaSource = this.sourceCurrentReference.get();
            if (zootopiaSource == null) {
                return;
            }
            QLog.i("ZootopiaDownloadButtonBinder", 1, "click download Button " + type + " and version: " + currMapInfo.getSimpleVerInfo().getModVersionSimpleData().getNowMapVer());
            com.tencent.sqshow.zootopia.report.a.f372690a.b(currMapInfo.getMapID(), type, zootopiaSource, zootopiaDownloadButtonBinder.cardReportParams);
            int i3 = 0;
            pv4.k kVar = null;
            switch (a.f329646a[type.ordinal()]) {
                case 1:
                    oa4.a.X1(zootopiaDownloadButtonBinder.getMapResViewModel(), currMapInfo, false, 2, null);
                    return;
                case 2:
                    c.a.a((si3.c) vb3.a.f441346a.a(si3.c.class), currMapInfo.getMapID(), zootopiaSource, null, null, 12, null);
                    return;
                case 3:
                case 4:
                    oa4.a.X1(zootopiaDownloadButtonBinder.getMapResViewModel(), currMapInfo, false, 2, null);
                    return;
                case 5:
                    zootopiaDownloadButtonBinder.getMapResViewModel().R1(String.valueOf(currMapInfo.getMapID()));
                    return;
                case 6:
                    Activity topActivity = Foreground.getTopActivity();
                    if (topActivity == null || topActivity.isFinishing()) {
                        return;
                    }
                    com.tencent.mobileqq.zootopia.utils.k.e(e(), topActivity, null, 2, null);
                    return;
                case 7:
                    zootopiaDownloadButtonBinder.getMapResViewModel().R1(String.valueOf(currMapInfo.getMapID()));
                    return;
                case 8:
                    pv4.j reserveItem = currMapInfo.getReserveItem();
                    if (reserveItem != null) {
                        ((tj3.a) vb3.a.f441346a.a(tj3.a.class)).s0(reserveItem, true, new b());
                        return;
                    }
                    return;
                case 9:
                default:
                    return;
                case 10:
                    String beforeOnlineToast = currMapInfo.getBeforeOnlineToast();
                    if (beforeOnlineToast == null || (context = this.contextReference.get()) == null) {
                        return;
                    }
                    QQToast.makeText(context, beforeOnlineToast, 0).show();
                    return;
                case 11:
                    pv4.j reserveItem2 = currMapInfo.getReserveItem();
                    if (reserveItem2 != null) {
                        tj3.a aVar = (tj3.a) vb3.a.f441346a.a(tj3.a.class);
                        String str = reserveItem2.f427619b;
                        Intrinsics.checkNotNullExpressionValue(str, "it.id");
                        pv4.j o16 = aVar.o(str, reserveItem2.f427618a);
                        if (o16 == null || (kVarArr = o16.f427623f) == null) {
                            return;
                        }
                        int length = kVarArr.length;
                        while (true) {
                            if (i3 < length) {
                                pv4.k findConfig = kVarArr[i3];
                                Intrinsics.checkNotNullExpressionValue(findConfig, "findConfig");
                                if (com.tencent.mobileqq.zootopia.utils.g.j(findConfig)) {
                                    kVar = findConfig;
                                } else {
                                    i3++;
                                }
                            }
                        }
                        if (kVar == null || kVar.f427628d) {
                            return;
                        }
                        ((tj3.a) vb3.a.f441346a.a(tj3.a.class)).E0(reserveItem2);
                        return;
                    }
                    return;
                case 12:
                    ZPlanCloudGameInfo cloudGameInfo = currMapInfo.getSimpleVerInfo().getCloudGameInfo();
                    if (cloudGameInfo != null) {
                        ((com.tencent.mobileqq.zplan.cloudmod.api.a) vb3.a.f441346a.a(com.tencent.mobileqq.zplan.cloudmod.api.a.class)).S0(cloudGameInfo, currMapInfo.getSimpleVerInfo().getMapID(), currMapInfo.getSimpleVerInfo().getMapStatus(), this.context, new c(zootopiaDownloadButtonBinder, currMapInfo));
                        return;
                    }
                    return;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g(boolean z16) {
            if (z16) {
                QQToast.makeText(BaseApplicationImpl.sApplication.getApplicationContext(), 2, R.string.xjx, 0).show();
            } else {
                QQToast.makeText(BaseApplicationImpl.sApplication.getApplicationContext(), 1, R.string.xjw, 0).show();
            }
        }
    }
}
