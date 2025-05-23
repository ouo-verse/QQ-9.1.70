package com.tencent.mobileqq.hermes.part;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.PorterDuff;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.core.content.res.ResourcesCompat;
import com.google.gson.Gson;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.part.Part;
import com.tencent.common.app.AppInterface;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseBusinessHandler;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.hermes.easteregg.BrandEasterConfigBean;
import com.tencent.mobileqq.hermes.easteregg.CoverPicInfo;
import com.tencent.mobileqq.hermes.event.BrandFlipEvent;
import com.tencent.mobileqq.hermes.task.TaskCountHandler;
import com.tencent.mobileqq.hermes.task.TaskRankingEvent;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.cn;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqnt.avatar.meta.b;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.richframework.gallery.RFWLayerLaunchUtil;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001c\u0018\u0000 K2\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001TB\u0007\u00a2\u0006\u0004\bR\u0010SJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\u0018\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0011\u001a\u00020\u0007H\u0002J\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\b\u0001\u0010\u0015\u001a\u00020\u0014H\u0002J\u0010\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\b\u0010\u001b\u001a\u00020\u0007H\u0002J\b\u0010\u001c\u001a\u00020\u0007H\u0002J\u001a\u0010!\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010#\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0017H\u0016J\u0010\u0010%\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u0017H\u0016J\u0010\u0010&\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\b\u0010'\u001a\u00020\fH\u0016J\u0010\u0010(\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J$\u0010,\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040*0)j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040*`+H\u0016R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010<\u001a\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010?\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010B\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010D\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010>R\u0016\u0010F\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010AR\u0016\u0010I\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010L\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0018\u0010N\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u00103R\u0016\u0010P\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010HR\u0014\u0010Q\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010>\u00a8\u0006U"}, d2 = {"Lcom/tencent/mobileqq/hermes/part/d;", "Lcom/tencent/biz/richframework/part/Part;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/tencent/mobileqq/hermes/task/TaskRankingEvent;", "event", "", "F9", "D9", "", "rank", "", "isFirstTime", "L9", "", "E9", "C9", "Landroid/graphics/drawable/Drawable;", "drawable", "", "color", "N9", "Landroid/view/View;", "dialogView", "H9", "J9", "K9", "B9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "v", NodeProps.ON_CLICK, "onPartDestroy", "onBackEvent", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Landroid/app/Dialog;", "d", "Landroid/app/Dialog;", "taskGuideDialog", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "guideWatchBtn", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "guideCloseBtn", "Lcom/tencent/mobileqq/hermes/easteregg/BrandEasterConfigBean;", h.F, "Lcom/tencent/mobileqq/hermes/easteregg/BrandEasterConfigBean;", "easterConfig", "i", "Ljava/lang/String;", "flipConfigStr", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "configTriggerTimes", BdhLogUtil.LogTag.Tag_Conn, "userFlipStr", "D", "userFlipTimes", "E", "Z", "firstFlip", UserInfo.SEX_FEMALE, "J", "taskRanking", "G", "rankTv", "H", "requestingTaskCount", "configStr", "<init>", "()V", "a", "hermes-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes8.dex */
public final class d extends Part implements View.OnClickListener, SimpleEventReceiver<SimpleBaseEvent> {
    static IPatchRedirector $redirector_;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private String userFlipStr;

    /* renamed from: D, reason: from kotlin metadata */
    private int userFlipTimes;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean firstFlip;

    /* renamed from: F, reason: from kotlin metadata */
    private long taskRanking;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private TextView rankTv;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean requestingTaskCount;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final String configStr;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Dialog taskGuideDialog;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView guideWatchBtn;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView guideCloseBtn;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private BrandEasterConfigBean easterConfig;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String flipConfigStr;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int configTriggerTimes;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0007\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/hermes/part/d$a;", "", "", "DIALOG_WIDTH", "I", "", "SEPARATOR", "Ljava/lang/String;", "TAG", "URL_DIALOG_BG", "URL_LOTTIE_ANIM", "URL_RANK_BG", "<init>", "()V", "hermes-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.hermes.part.d$a, reason: from kotlin metadata */
    /* loaded from: classes8.dex */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25293);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.flipConfigStr = "";
        this.configTriggerTimes = Integer.MIN_VALUE;
        this.userFlipStr = "";
        this.taskRanking = Long.MIN_VALUE;
        this.configStr = com.tencent.mobileqq.hermes.util.a.f236827a.b();
    }

    private final void B9() {
        TextView textView = this.guideWatchBtn;
        if (textView != null) {
            textView.setOnClickListener(this);
        }
        ImageView imageView = this.guideCloseBtn;
        if (imageView != null) {
            imageView.setOnClickListener(this);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001e, code lost:
    
        if (r2 != null) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void C9() {
        String str;
        List<CoverPicInfo> coverUrls;
        Object orNull;
        String url;
        List<CoverPicInfo> coverUrls2;
        Object orNull2;
        this.userFlipTimes = 0;
        String str2 = "";
        this.userFlipStr = "";
        BrandEasterConfigBean brandEasterConfigBean = this.easterConfig;
        if (brandEasterConfigBean != null && (coverUrls2 = brandEasterConfigBean.getCoverUrls()) != null) {
            orNull2 = CollectionsKt___CollectionsKt.getOrNull(coverUrls2, 0);
            CoverPicInfo coverPicInfo = (CoverPicInfo) orNull2;
            if (coverPicInfo != null) {
                str = coverPicInfo.getUrl();
            }
        }
        str = "";
        if (!TextUtils.isEmpty(str)) {
            QQPicLoader.f201806a.d().download(Option.obtain().setUrl(str).setPredecode(false), null);
        }
        BrandEasterConfigBean brandEasterConfigBean2 = this.easterConfig;
        if (brandEasterConfigBean2 != null && (coverUrls = brandEasterConfigBean2.getCoverUrls()) != null) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(coverUrls, 1);
            CoverPicInfo coverPicInfo2 = (CoverPicInfo) orNull;
            if (coverPicInfo2 != null && (url = coverPicInfo2.getUrl()) != null) {
                str2 = url;
            }
        }
        if (!TextUtils.isEmpty(str2)) {
            QQPicLoader.f201806a.d().download(Option.obtain().setUrl(str2).setPredecode(false), null);
        }
    }

    private final void D9() {
        AppInterface appInterface;
        BaseBusinessHandler baseBusinessHandler;
        QLog.i("HermesTaskDialogPart", 1, "taskRanking:" + this.taskRanking);
        C9();
        long j3 = this.taskRanking;
        if (j3 > 0) {
            L9(j3, false);
            return;
        }
        if (!this.requestingTaskCount) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            TaskCountHandler taskCountHandler = null;
            if (peekAppRuntime instanceof AppInterface) {
                appInterface = (AppInterface) peekAppRuntime;
            } else {
                appInterface = null;
            }
            if (appInterface != null) {
                baseBusinessHandler = appInterface.getBusinessHandler(TaskCountHandler.class.getName());
            } else {
                baseBusinessHandler = null;
            }
            if (baseBusinessHandler instanceof TaskCountHandler) {
                taskCountHandler = (TaskCountHandler) baseBusinessHandler;
            }
            if (taskCountHandler != null) {
                taskCountHandler.getTaskCount(getContext().hashCode(), 1L);
            }
            this.requestingTaskCount = true;
        }
    }

    private final String E9() {
        ArrayList<String> arrayListOf;
        String uid = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUid();
        IFriendsInfoService iFriendsInfoService = (IFriendsInfoService) QRoute.api(IFriendsInfoService.class);
        Intrinsics.checkNotNullExpressionValue(uid, "uid");
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(uid);
        ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.d> friendSimpleInfoWithUid = iFriendsInfoService.getFriendSimpleInfoWithUid(arrayListOf, "HermesTaskDialogPart");
        if (friendSimpleInfoWithUid == null) {
            return "";
        }
        while (true) {
            String str = "";
            for (com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar : friendSimpleInfoWithUid) {
                if (Intrinsics.areEqual(dVar.getUid(), uid)) {
                    QLog.i("HermesTaskDialogPart", 1, "[getNick]: " + dVar.p());
                    str = dVar.p();
                    if (str == null) {
                        break;
                    }
                }
            }
            return str;
        }
    }

    private final void F9(final TaskRankingEvent event) {
        this.requestingTaskCount = false;
        if (event.getSuccess() && event.getRanking() > 0) {
            this.taskRanking = event.getRanking();
            com.tencent.mobileqq.hermes.util.a.f236827a.g(event.getRanking());
            if (event.getFromContext() == getContext().hashCode()) {
                runOnActivityUiThread(new Runnable() { // from class: com.tencent.mobileqq.hermes.part.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        d.G9(d.this, event);
                    }
                });
                return;
            }
            RFWLog.e("HermesTaskDialogPart", RFWLog.USR, " receive ranking result " + this.taskRanking + ",but context is not the same");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(d this$0, TaskRankingEvent event) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(event, "$event");
        this$0.L9(event.getRanking(), true);
    }

    private final void H9(View dialogView) {
        if (Build.VERSION.SDK_INT < 28) {
            return;
        }
        ImageView imageView = (ImageView) dialogView.findViewById(R.id.x9f);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(ImmersiveUtils.getScreenWidth(), ImmersiveUtils.getScreenHeight()));
        QQPicLoader qQPicLoader = QQPicLoader.f201806a;
        Option targetView = Option.obtain().setUrl("https://downv6.qq.com/extendfriend/mutual_lottie_boom.json").setLoadingDrawable(new ColorDrawable(0)).setFailDrawable(new ColorDrawable(0)).setPreferDecoder(com.tencent.libra.extension.a.class).setTargetView(imageView);
        Intrinsics.checkNotNullExpressionValue(targetView, "obtain().setUrl(URL_LOTT\u2026 .setTargetView(animView)");
        qQPicLoader.e(targetView, new IPicLoadStateListener() { // from class: com.tencent.mobileqq.hermes.part.c
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option) {
                d.I9(loadState, option);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(LoadState loadState, Option option) {
        r01.c cVar;
        if (loadState == LoadState.STATE_SUCCESS && (option.getAnimatable() instanceof r01.c)) {
            Animatable animatable = option.getAnimatable();
            if (animatable instanceof r01.c) {
                cVar = (r01.c) animatable;
            } else {
                cVar = null;
            }
            if (cVar != null) {
                cVar.start();
            }
        }
    }

    private final void J9(View dialogView) {
        ImageView imageView = (ImageView) dialogView.findViewById(R.id.x_2);
        QQPicLoader qQPicLoader = QQPicLoader.f201806a;
        Option targetView = Option.obtain().setUrl("https://downv6.qq.com/video_story/libra/task_dialog_bg.png").setLoadingDrawable(new ColorDrawable(0)).setFailDrawable(new ColorDrawable(0)).setTargetView(imageView);
        Intrinsics.checkNotNullExpressionValue(targetView, "obtain().setUrl(URL_DIAL\u2026 .setTargetView(avatarBg)");
        qQPicLoader.e(targetView, null);
    }

    private final void K9() {
        Window window;
        Window window2;
        Window window3;
        Dialog dialog = this.taskGuideDialog;
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(false);
        }
        Dialog dialog2 = this.taskGuideDialog;
        if (dialog2 != null && (window3 = dialog2.getWindow()) != null) {
            window3.requestFeature(1);
        }
        Dialog dialog3 = this.taskGuideDialog;
        if (dialog3 != null && (window2 = dialog3.getWindow()) != null) {
            window2.setFlags(1024, 1024);
        }
        Dialog dialog4 = this.taskGuideDialog;
        if (dialog4 != null && (window = dialog4.getWindow()) != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
    }

    private final void L9(long rank, boolean isFirstTime) {
        int indexOf$default;
        if (getPartRootView() != null && getActivity() != null && !getActivity().isFinishing()) {
            Dialog dialog = this.taskGuideDialog;
            boolean z16 = false;
            if (dialog != null && dialog.isShowing()) {
                z16 = true;
            }
            if (z16) {
                QLog.e("HermesTaskDialogPart", 1, " preDialog is showing");
                return;
            }
            this.taskGuideDialog = new ReportDialog(getContext());
            View dialogView = LayoutInflater.from(getContext()).inflate(R.layout.f_z, (ViewGroup) null);
            Intrinsics.checkNotNullExpressionValue(dialogView, "dialogView");
            J9(dialogView);
            H9(dialogView);
            View findViewById = dialogView.findViewById(R.id.x9g);
            Intrinsics.checkNotNullExpressionValue(findViewById, "dialogView.findViewById(R.id.hermes_dialog_avatar)");
            QQProAvatarView qQProAvatarView = (QQProAvatarView) findViewById;
            String currentAccountUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin();
            Intrinsics.checkNotNullExpressionValue(currentAccountUin, "sMobileQQ.peekAppRuntime().currentAccountUin");
            b.a aVar = new b.a(1, currentAccountUin, 140, true);
            aVar.a(FaceConstant.ZPLAN_OUT_BOUND_AVATAR_FLAG, Boolean.TRUE);
            aVar.a("KEY_BEAN_KEY_SUFFIX", "sz");
            qQProAvatarView.setEnableFrame(ImmersiveUtils.dpToPx(2.0f), -1);
            qQProAvatarView.A(aVar.b());
            TextView textView = (TextView) dialogView.findViewById(R.id.x9h);
            if (textView != null) {
                textView.setText(E9());
            }
            K9();
            View findViewById2 = dialogView.findViewById(R.id.x9r);
            Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
            this.guideWatchBtn = (TextView) findViewById2;
            View findViewById3 = dialogView.findViewById(R.id.x9e);
            Intrinsics.checkNotNull(findViewById3, "null cannot be cast to non-null type android.widget.ImageView");
            ImageView imageView = (ImageView) findViewById3;
            this.guideCloseBtn = imageView;
            if (imageView != null) {
                imageView.setImageDrawable(N9(ResourcesCompat.getDrawable(getPartRootView().getResources(), R.drawable.qui_close_circle, null), ResourcesCompat.getColor(getPartRootView().getResources(), R.color.qui_common_icon_white, null)));
            }
            this.rankTv = (TextView) dialogView.findViewById(R.id.x9j);
            com.tencent.mobileqq.hermes.util.a aVar2 = com.tencent.mobileqq.hermes.util.a.f236827a;
            String str = "NO. " + aVar2.a(rank);
            SpannableString spannableString = new SpannableString(str);
            indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str, " ", 0, false, 6, (Object) null);
            spannableString.setSpan(new StyleSpan(1), indexOf$default + 1, str.length(), 33);
            TextView textView2 = this.rankTv;
            if (textView2 != null) {
                textView2.setText(spannableString);
            }
            B9();
            Dialog dialog2 = this.taskGuideDialog;
            if (dialog2 != null) {
                dialog2.setContentView(dialogView);
                dialog2.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.tencent.mobileqq.hermes.part.b
                    @Override // android.content.DialogInterface.OnShowListener
                    public final void onShow(DialogInterface dialogInterface) {
                        d.M9(d.this, dialogInterface);
                    }
                });
                dialog2.show();
            }
            aVar2.f(isFirstTime);
            return;
        }
        QLog.e("HermesTaskDialogPart", 1, "[showPopupWindow] view == null || getActivity is finish");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(d this$0, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.C9();
    }

    private final Drawable N9(Drawable drawable, @ColorInt int color) {
        Drawable f16 = cn.f(drawable);
        if (f16 == null) {
            return drawable;
        }
        f16.setColorFilter(color, PorterDuff.Mode.SRC_IN);
        return f16;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(BrandFlipEvent.class, TaskRankingEvent.class);
            return arrayListOf;
        }
        return (ArrayList) iPatchRedirector.redirect((short) 8, (Object) this);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        ArrayList arrayList;
        List<CoverPicInfo> coverUrls;
        int collectionSizeOrDefault;
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) v3);
        } else {
            Intrinsics.checkNotNullParameter(v3, "v");
            if (v3.getId() == R.id.x9e) {
                QLog.d("HermesTaskDialogPart", 1, "click closed dialog");
                Dialog dialog = this.taskGuideDialog;
                if (dialog != null) {
                    dialog.dismiss();
                }
            } else if (v3.getId() == R.id.x9r) {
                BrandEasterConfigBean brandEasterConfigBean = this.easterConfig;
                if (brandEasterConfigBean != null && (coverUrls = brandEasterConfigBean.getCoverUrls()) != null) {
                    List<CoverPicInfo> list = coverUrls;
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                    arrayList = new ArrayList(collectionSizeOrDefault);
                    for (CoverPicInfo coverPicInfo : list) {
                        RFWLayerItemMediaInfo rFWLayerItemMediaInfo = new RFWLayerItemMediaInfo();
                        RFWLayerPicInfo rFWLayerPicInfo = new RFWLayerPicInfo();
                        RFWLayerPicInfo.RFWPicInfo rFWPicInfo = new RFWLayerPicInfo.RFWPicInfo();
                        rFWPicInfo.setUrl(coverPicInfo.getUrl());
                        rFWPicInfo.setLocalPath(QQPicLoader.f201806a.d().getPicLocalPath(Option.obtain().setUrl(rFWPicInfo.getUrl())));
                        rFWPicInfo.setWidth(coverPicInfo.getWidth());
                        rFWPicInfo.setHeight(coverPicInfo.getHeight());
                        rFWLayerPicInfo.setCurrentPicInfo(rFWPicInfo);
                        rFWLayerPicInfo.setBigPicInfo(rFWLayerPicInfo.getCurrentPicInfo());
                        rFWLayerPicInfo.setOriginPicInfo(rFWLayerPicInfo.getCurrentPicInfo());
                        rFWLayerItemMediaInfo.setLayerPicInfo(rFWLayerPicInfo);
                        arrayList.add(rFWLayerItemMediaInfo);
                    }
                } else {
                    arrayList = null;
                }
                if (arrayList != null) {
                    RFWLayerLaunchUtil rFWLayerLaunchUtil = RFWLayerLaunchUtil.INSTANCE;
                    Context context = getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    com.tencent.mobileqq.hermes.layer.a.a(rFWLayerLaunchUtil, context, 0, arrayList);
                }
                Dialog dialog2 = this.taskGuideDialog;
                if (dialog2 != null) {
                    dialog2.dismiss();
                }
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) rootView);
        } else {
            Intrinsics.checkNotNullParameter(rootView, "rootView");
            super.onInitView(rootView);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0069, code lost:
    
        r11 = kotlin.collections.ArraysKt___ArraysKt.joinToString$default(r1, (java.lang.CharSequence) ",", (java.lang.CharSequence) null, (java.lang.CharSequence) ",", 0, (java.lang.CharSequence) null, (kotlin.jvm.functions.Function1) null, 58, (java.lang.Object) null);
     */
    @Override // com.tencent.biz.richframework.part.Part
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onPartCreate(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
        String str;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) savedInstanceState);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartCreate(activity, savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
        QLog.i("HermesTaskDialogPart", 1, "configStr: " + this.configStr);
        if (!TextUtils.isEmpty(this.configStr)) {
            BrandEasterConfigBean brandEasterConfigBean = (BrandEasterConfigBean) new Gson().fromJson(this.configStr, BrandEasterConfigBean.class);
            this.easterConfig = brandEasterConfigBean;
            boolean z16 = false;
            if (brandEasterConfigBean != null && brandEasterConfigBean.isOpen()) {
                z16 = true;
            }
            if (z16) {
                BrandEasterConfigBean brandEasterConfigBean2 = this.easterConfig;
                if (brandEasterConfigBean2 == null || (r1 = brandEasterConfigBean2.getTriggerRule()) == null || str == null) {
                    str = "";
                }
                this.flipConfigStr = str;
                QLog.i("HermesTaskDialogPart", 1, "flipConfigStr: " + str);
                BrandEasterConfigBean brandEasterConfigBean3 = this.easterConfig;
                if (brandEasterConfigBean3 != null) {
                    i3 = brandEasterConfigBean3.getTriggerTimes();
                } else {
                    i3 = Integer.MIN_VALUE;
                }
                this.configTriggerTimes = i3;
                this.taskRanking = com.tencent.mobileqq.hermes.util.a.f236827a.c();
                return;
            }
            QLog.i("HermesTaskDialogPart", 1, "is close");
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@NotNull Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@NotNull SimpleBaseEvent event) {
        boolean z16;
        boolean contains$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) event);
            return;
        }
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof BrandFlipEvent) {
            BrandFlipEvent brandFlipEvent = (BrandFlipEvent) event;
            QLog.i("HermesTaskDialogPart", 1, "receive:" + brandFlipEvent.getDirection());
            BrandEasterConfigBean brandEasterConfigBean = this.easterConfig;
            if (brandEasterConfigBean != null && brandEasterConfigBean.isOpen()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                QLog.i("HermesTaskDialogPart", 1, "is close");
                return;
            }
            this.userFlipTimes++;
            if (!this.firstFlip) {
                QQPicLoader qQPicLoader = QQPicLoader.f201806a;
                qQPicLoader.d().download(Option.obtain().setUrl("https://downv6.qq.com/video_story/libra/task_dialog_bg.png").setPredecode(false), null);
                qQPicLoader.d().download(Option.obtain().setUrl("https://downv6.qq.com/video_story/libra/task_no_bg.png").setPredecode(false), null);
                this.firstFlip = true;
            }
            int i3 = this.configTriggerTimes;
            if (i3 > 0 && i3 == this.userFlipTimes) {
                D9();
                return;
            }
            if (!TextUtils.isEmpty(this.flipConfigStr)) {
                String str = this.userFlipStr + brandFlipEvent.getDirection() + ",";
                this.userFlipStr = str;
                QLog.i("HermesTaskDialogPart", 1, " userFlipStr: " + str + " flipConfigStr: " + this.flipConfigStr);
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) this.userFlipStr, (CharSequence) this.flipConfigStr, false, 2, (Object) null);
                if (contains$default) {
                    QLog.i("HermesTaskDialogPart", 1, " trigger dialog");
                    D9();
                    return;
                }
                return;
            }
            QLog.i("HermesTaskDialogPart", 1, "flipConfigStr: " + this.flipConfigStr);
            return;
        }
        if (event instanceof TaskRankingEvent) {
            F9((TaskRankingEvent) event);
        }
    }
}
