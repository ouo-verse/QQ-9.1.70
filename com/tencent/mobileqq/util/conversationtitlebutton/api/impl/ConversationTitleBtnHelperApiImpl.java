package com.tencent.mobileqq.util.conversationtitlebutton.api.impl;

import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.jsengine.animation.custom.CustomAnimation;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.studymode.StudyModeChangeListener;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.conversationtitlebutton.ConversationTitleBtnConfig;
import com.tencent.mobileqq.util.conversationtitlebutton.TitleButtonProcessorManager;
import com.tencent.mobileqq.util.conversationtitlebutton.TitleButtonState;
import com.tencent.mobileqq.util.conversationtitlebutton.api.impl.ConversationTitleBtnHelperApiImpl;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mobileqq.widget.tip.QUIDefaultBubbleTip;
import com.tencent.mobileqq.widget.tip.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.page.PageUtils;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a7\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t*\u0001c\u0018\u0000 w2\u00020\u0001:\u0005<E4C2B\u000f\u0012\u0006\u0010H\u001a\u00020F\u00a2\u0006\u0004\bu\u0010vJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002J \u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0016\u001a\u00020\u0004H\u0002J\b\u0010\u0017\u001a\u00020\u0004H\u0002J\b\u0010\u0018\u001a\u00020\u0004H\u0002J\b\u0010\u0019\u001a\u00020\u0004H\u0002J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001a\u001a\u00020\tH\u0002J\b\u0010\u001d\u001a\u00020\u0004H\u0002J\b\u0010\u001e\u001a\u00020\u0010H\u0002J\u0012\u0010 \u001a\u00020\u00042\b\b\u0002\u0010\u001f\u001a\u00020\u0010H\u0002J\u0010\u0010!\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u0010H\u0002J\b\u0010\"\u001a\u00020\u0004H\u0002J\b\u0010#\u001a\u00020\u0004H\u0002J \u0010(\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010\t2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020&0%H\u0002J\u0010\u0010*\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\u0010H\u0002J\b\u0010+\u001a\u00020\u0004H\u0002J\b\u0010,\u001a\u00020\u0004H\u0002J\b\u0010-\u001a\u00020\u0004H\u0002J\b\u0010.\u001a\u00020\u0010H\u0002J\u0012\u0010/\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001a\u001a\u00020\tH\u0002J\u0012\u00100\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\tH\u0002J\b\u00101\u001a\u00020\u0004H\u0002J\b\u00102\u001a\u00020\u0010H\u0016J\b\u00103\u001a\u00020\u0004H\u0016J\b\u00104\u001a\u00020\u0004H\u0016J\b\u00105\u001a\u00020\u0004H\u0016J\u0010\u00107\u001a\u00020\u00042\u0006\u00106\u001a\u00020\fH\u0016J\u0010\u00108\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u0010H\u0016J\u0010\u0010:\u001a\u00020\u00042\u0006\u00109\u001a\u00020\u0010H\u0016J\b\u0010;\u001a\u00020\u0004H\u0016J\b\u0010<\u001a\u00020\u0004H\u0016J\b\u0010=\u001a\u00020\u0004H\u0016J\b\u0010>\u001a\u00020\u0004H\u0016J\b\u0010?\u001a\u00020\u0004H\u0016J\b\u0010@\u001a\u00020\u0004H\u0016J\u0010\u0010C\u001a\u00020\u00042\u0006\u0010B\u001a\u00020AH\u0016J\u0010\u0010E\u001a\u00020\u00042\u0006\u0010D\u001a\u00020AH\u0016R\u0014\u0010H\u001a\u00020F8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010GR\u0016\u0010K\u001a\u00020I8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bE\u0010JR\u0016\u0010N\u001a\u00020L8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u0010MR\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bC\u0010OR\u0016\u0010P\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010(R\u0018\u0010R\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u0010QR\u0018\u0010T\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u0010SR\u0018\u0010V\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u0010UR\u0016\u0010W\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010(R\u0018\u0010[\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u0018\u0010_\u001a\u0004\u0018\u00010\\8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010b\u001a\u00020`8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\ba\u0010\bR\u0014\u0010f\u001a\u00020c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bd\u0010eR\u0014\u0010j\u001a\u00020g8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bh\u0010iR\u0014\u0010n\u001a\u00020k8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bl\u0010mR\u001a\u0010t\u001a\u00020o8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\bp\u0010q\u001a\u0004\br\u0010s\u00a8\u0006x"}, d2 = {"Lcom/tencent/mobileqq/util/conversationtitlebutton/api/impl/ConversationTitleBtnHelperApiImpl;", "Lcom/tencent/mobileqq/util/conversationtitlebutton/d;", "Lmqq/app/AppRuntime;", BdhLogUtil.LogTag.Tag_Conn, "", "d0", "Lcom/tencent/mobileqq/util/conversationtitlebutton/a;", DownloadInfo.spKey_Config, "J", "", "E", "I", "Landroid/view/View;", "v", "O", "event", "", "hasRedTouch", "isTipsShowing", "X", "Lcom/tencent/mobileqq/util/conversationtitlebutton/l;", "D", "H", "V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "P", "url", "Lcom/tencent/image/URLDrawable;", "G", BdhLogUtil.LogTag.Tag_Req, "L", "needClear", ExifInterface.LATITUDE_SOUTH, "T", "b0", "U", "tipText", "", "Landroid/graphics/drawable/Drawable;", "avatars", "Z", "ignoreCheckForeground", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "N", "W", "Y", "K", UserInfo.SEX_FEMALE, "B", "c0", "e", "f", "c", "i", "view", "g", tl.h.F, "tabChange", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "a", "resetVisibility", "onBeforeAccountChanged", "onAccountChanged", "onPostThemeChanged", "", "color", "d", com.tencent.luggage.wxa.c8.c.f123400v, "b", "Lcom/tencent/mobileqq/util/conversationtitlebutton/c;", "Lcom/tencent/mobileqq/util/conversationtitlebutton/c;", "host", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "icon", "Lcom/tencent/mobileqq/tianshu/ui/RedTouch;", "Lcom/tencent/mobileqq/tianshu/ui/RedTouch;", "iconRedTouch", "Lcom/tencent/mobileqq/util/conversationtitlebutton/a;", "isIconLoadSuccess", "Ljava/lang/Integer;", "iconFilterColor", "Ljava/lang/String;", "iconDrawableUrl", "Lcom/tencent/image/URLDrawable;", "iconImageDrawable", "shouldReplyIconAnimation", "Lcom/tencent/mobileqq/widget/tip/a;", "j", "Lcom/tencent/mobileqq/widget/tip/a;", "showingTipView", "Ljava/lang/Runnable;", "k", "Ljava/lang/Runnable;", "pendingShowTipsRunnable", "", "l", "startShowingTipsTime", "com/tencent/mobileqq/util/conversationtitlebutton/api/impl/ConversationTitleBtnHelperApiImpl$f", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/util/conversationtitlebutton/api/impl/ConversationTitleBtnHelperApiImpl$f;", "dataObserver", "Lcom/tencent/mobileqq/util/conversationtitlebutton/api/impl/ConversationTitleBtnHelperApiImpl$d;", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/util/conversationtitlebutton/api/impl/ConversationTitleBtnHelperApiImpl$d;", "studyModeChangeListener", "Lcom/tencent/mobileqq/util/conversationtitlebutton/api/impl/ConversationTitleBtnHelperApiImpl$b;", "o", "Lcom/tencent/mobileqq/util/conversationtitlebutton/api/impl/ConversationTitleBtnHelperApiImpl$b;", "guardManagerCallback", "Landroid/view/View$OnTouchListener;", "p", "Landroid/view/View$OnTouchListener;", "getButtonTouchListener", "()Landroid/view/View$OnTouchListener;", "buttonTouchListener", "<init>", "(Lcom/tencent/mobileqq/util/conversationtitlebutton/c;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ConversationTitleBtnHelperApiImpl implements com.tencent.mobileqq.util.conversationtitlebutton.d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.mobileqq.util.conversationtitlebutton.c host;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private ImageView icon;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private RedTouch iconRedTouch;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ConversationTitleBtnConfig config;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isIconLoadSuccess;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Integer iconFilterColor;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private String iconDrawableUrl;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private URLDrawable iconImageDrawable;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean shouldReplyIconAnimation;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.widget.tip.a showingTipView;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private Runnable pendingShowTipsRunnable;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private long startShowingTipsTime;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final f dataObserver;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private final d studyModeChangeListener;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private final b guardManagerCallback;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private final View.OnTouchListener buttonTouchListener;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\u000b\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/util/conversationtitlebutton/api/impl/ConversationTitleBtnHelperApiImpl$d;", "Lcom/tencent/mobileqq/studymode/StudyModeChangeListener;", "", "isStudyMode", "", "onChange", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/util/conversationtitlebutton/api/impl/ConversationTitleBtnHelperApiImpl;", "kotlin.jvm.PlatformType", "d", "Ljava/lang/ref/WeakReference;", "weakReference", "host", "<init>", "(Lcom/tencent/mobileqq/util/conversationtitlebutton/api/impl/ConversationTitleBtnHelperApiImpl;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d implements StudyModeChangeListener {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<ConversationTitleBtnHelperApiImpl> weakReference;

        public d(ConversationTitleBtnHelperApiImpl host) {
            Intrinsics.checkNotNullParameter(host, "host");
            this.weakReference = new WeakReference<>(host);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(d this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            ConversationTitleBtnHelperApiImpl conversationTitleBtnHelperApiImpl = this$0.weakReference.get();
            if (conversationTitleBtnHelperApiImpl != null) {
                conversationTitleBtnHelperApiImpl.Y();
                conversationTitleBtnHelperApiImpl.d0();
            }
        }

        @Override // com.tencent.mobileqq.studymode.StudyModeChangeListener
        public void onChange(boolean isStudyMode) {
            QLog.i("ConversationTitleBtnHelper", 1, "study mode updated, refresh ui, studyMode=" + isStudyMode);
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.util.conversationtitlebutton.api.impl.g
                @Override // java.lang.Runnable
                public final void run() {
                    ConversationTitleBtnHelperApiImpl.d.b(ConversationTitleBtnHelperApiImpl.d.this);
                }
            });
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/util/conversationtitlebutton/api/impl/ConversationTitleBtnHelperApiImpl$f", "Lcom/tencent/mobileqq/util/conversationtitlebutton/TitleButtonProcessorManager$b;", "", "onConfigChanged", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class f implements TitleButtonProcessorManager.b {
        f() {
        }

        @Override // com.tencent.mobileqq.util.conversationtitlebutton.TitleButtonProcessorManager.b
        public void onConfigChanged() {
            QLog.i("ConversationTitleBtnHelper", 1, "config updated, refresh ui, uin=" + ConversationTitleBtnHelperApiImpl.this.E());
            ConversationTitleBtnHelperApiImpl.this.d0();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/util/conversationtitlebutton/api/impl/ConversationTitleBtnHelperApiImpl$g", "Lcom/tencent/mobileqq/widget/tip/a$b;", "", "onShow", "onDismiss", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class g implements a.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f306710a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ConversationTitleBtnHelperApiImpl f306711b;

        g(String str, ConversationTitleBtnHelperApiImpl conversationTitleBtnHelperApiImpl) {
            this.f306710a = str;
            this.f306711b = conversationTitleBtnHelperApiImpl;
        }

        @Override // com.tencent.mobileqq.widget.tip.a.b
        public /* bridge */ /* synthetic */ void onClick(View view) {
            l53.d.a(this, view);
        }

        @Override // com.tencent.mobileqq.widget.tip.a.b
        public void onDismiss() {
            this.f306711b.showingTipView = null;
        }

        @Override // com.tencent.mobileqq.widget.tip.a.b
        public void onShow() {
            if (QLog.isDevelopLevel()) {
                QLog.i("ConversationTitleBtnHelper", 1, "[refreshTip] tip did show, tips=" + this.f306710a);
            }
            this.f306711b.startShowingTipsTime = System.currentTimeMillis();
        }
    }

    public ConversationTitleBtnHelperApiImpl(com.tencent.mobileqq.util.conversationtitlebutton.c host) {
        Intrinsics.checkNotNullParameter(host, "host");
        this.host = host;
        this.dataObserver = new f();
        this.studyModeChangeListener = new d(this);
        this.guardManagerCallback = new b(this);
        this.buttonTouchListener = new View.OnTouchListener() { // from class: com.tencent.mobileqq.util.conversationtitlebutton.api.impl.a
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean z16;
                z16 = ConversationTitleBtnHelperApiImpl.z(view, motionEvent);
                return z16;
            }
        };
    }

    private final boolean A(boolean ignoreCheckForeground) {
        boolean b16 = this.host.b();
        boolean z16 = false;
        boolean z17 = ignoreCheckForeground || (this.host.a() && !b16);
        boolean c16 = this.host.c();
        if (z17 && !c16) {
            z16 = true;
        }
        QLog.d("ConversationTitleBtnHelper", 1, "canShowTips:" + z16 + " foreground:" + z17 + " isAccountPanelShow:" + b16 + " isDrawerOpen:" + c16);
        return z16;
    }

    private final AppRuntime C() {
        return MobileQQ.sMobileQQ.peekAppRuntime();
    }

    private final TitleButtonState D() {
        RedTouch redTouch = this.iconRedTouch;
        if (redTouch == null) {
            Intrinsics.throwUninitializedPropertyAccessException("iconRedTouch");
            redTouch = null;
        }
        return new TitleButtonState(redTouch.hasRedTouch(), System.currentTimeMillis() - this.startShowingTipsTime < 5000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String E() {
        AppRuntime C = C();
        String currentUin = C != null ? C.getCurrentUin() : null;
        return currentUin == null ? "" : currentUin;
    }

    private final URLDrawable F(String url) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mUseApngImage = true;
        obtain.mLoadingDrawable = new ColorDrawable(0);
        obtain.mFailedDrawable = new ColorDrawable(0);
        Bundle bundle = new Bundle();
        bundle.putBoolean(ApngImage.KEY_USE_FILE_LOOP, true);
        obtain.mExtraInfo = bundle;
        try {
            return URLDrawable.getDrawable(url, obtain);
        } catch (Exception e16) {
            QLog.i("ConversationTitleBtnHelper", 1, "[getUrlApngDrawable] exc=" + e16);
            return null;
        }
    }

    private final URLDrawable G(String url) {
        ConversationTitleBtnConfig conversationTitleBtnConfig = this.config;
        if (conversationTitleBtnConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
            conversationTitleBtnConfig = null;
        }
        this.iconDrawableUrl = conversationTitleBtnConfig.getIconUrl();
        c0();
        URLDrawable F = F(url);
        if (F == null) {
            QLog.i("ConversationTitleBtnHelper", 1, "icon drawable load failed, url=" + url);
            this.isIconLoadSuccess = false;
        } else if (F.getStatus() == 1) {
            QLog.i("ConversationTitleBtnHelper", 1, "icon drawable load success, url=" + url);
            R();
        } else {
            F.setURLDrawableListener(new c(this, url));
        }
        return F;
    }

    private final void H() {
        if (QLog.isColorLevel()) {
            QLog.i("ConversationTitleBtnHelper", 2, "[hideIcon]");
        }
        this.isIconLoadSuccess = false;
        com.tencent.mobileqq.widget.tip.a aVar = this.showingTipView;
        if (aVar != null) {
            aVar.o();
        }
        this.showingTipView = null;
        RedTouch redTouch = this.iconRedTouch;
        if (redTouch == null) {
            Intrinsics.throwUninitializedPropertyAccessException("iconRedTouch");
            redTouch = null;
        }
        redTouch.setVisibility(8);
        RedTouch redTouch2 = this.iconRedTouch;
        if (redTouch2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("iconRedTouch");
            redTouch2 = null;
        }
        redTouch2.clearRedTouch();
        ImageView imageView = this.icon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("icon");
            imageView = null;
        }
        imageView.setImageDrawable(null);
    }

    private final void I() {
        if (!K()) {
            QLog.i("ConversationTitleBtnHelper", 1, "config Not Valid");
            H();
            return;
        }
        ConversationTitleBtnConfig conversationTitleBtnConfig = this.config;
        ImageView imageView = null;
        if (conversationTitleBtnConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
            conversationTitleBtnConfig = null;
        }
        int redDotSet = conversationTitleBtnConfig.getRedDotSet();
        ConversationTitleBtnConfig conversationTitleBtnConfig2 = this.config;
        if (conversationTitleBtnConfig2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
            conversationTitleBtnConfig2 = null;
        }
        int redDotAppId = conversationTitleBtnConfig2.getRedDotAppId();
        ConversationTitleBtnConfig conversationTitleBtnConfig3 = this.config;
        if (conversationTitleBtnConfig3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
            conversationTitleBtnConfig3 = null;
        }
        int tipsSet = conversationTitleBtnConfig3.getTipsSet();
        ConversationTitleBtnConfig conversationTitleBtnConfig4 = this.config;
        if (conversationTitleBtnConfig4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
            conversationTitleBtnConfig4 = null;
        }
        int tipsAppId = conversationTitleBtnConfig4.getTipsAppId();
        ConversationTitleBtnConfig conversationTitleBtnConfig5 = this.config;
        if (conversationTitleBtnConfig5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
            conversationTitleBtnConfig5 = null;
        }
        String iconUrl = conversationTitleBtnConfig5.getIconUrl();
        ConversationTitleBtnConfig conversationTitleBtnConfig6 = this.config;
        if (conversationTitleBtnConfig6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
            conversationTitleBtnConfig6 = null;
        }
        QLog.i("ConversationTitleBtnHelper", 1, "init ui, redDotSet = " + redDotSet + ", redDotAppId = " + redDotAppId + ", tipsSet = " + tipsSet + ", tipsAppId = " + tipsAppId + ", iconUrl = " + iconUrl + ", jumpUrl = " + conversationTitleBtnConfig6.getJumpUrl());
        RedTouch redTouch = this.iconRedTouch;
        if (redTouch == null) {
            Intrinsics.throwUninitializedPropertyAccessException("iconRedTouch");
            redTouch = null;
        }
        redTouch.setVisibility(0);
        RedTouch redTouch2 = this.iconRedTouch;
        if (redTouch2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("iconRedTouch");
            redTouch2 = null;
        }
        redTouch2.clearRedTouch();
        com.tencent.mobileqq.widget.tip.a aVar = this.showingTipView;
        if (aVar != null) {
            aVar.o();
        }
        this.showingTipView = null;
        this.isIconLoadSuccess = false;
        ImageView imageView2 = this.icon;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("icon");
            imageView2 = null;
        }
        imageView2.setVisibility(0);
        ConversationTitleBtnConfig conversationTitleBtnConfig7 = this.config;
        if (conversationTitleBtnConfig7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
            conversationTitleBtnConfig7 = null;
        }
        URLDrawable G = G(conversationTitleBtnConfig7.getIconUrl());
        if (G != null) {
            ImageView imageView3 = this.icon;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("icon");
                imageView3 = null;
            }
            imageView3.setImageDrawable(G);
        } else {
            G = null;
        }
        this.iconImageDrawable = G;
        ImageView imageView4 = this.icon;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("icon");
        } else {
            imageView = imageView4;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.util.conversationtitlebutton.api.impl.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ConversationTitleBtnHelperApiImpl.this.O(view);
            }
        });
        b0();
        X("qq_imp", false, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J(ConversationTitleBtnConfig config) {
        this.config = config;
        I();
    }

    private final boolean K() {
        ConversationTitleBtnConfig conversationTitleBtnConfig = this.config;
        if (conversationTitleBtnConfig == null) {
            return false;
        }
        if (conversationTitleBtnConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
            conversationTitleBtnConfig = null;
        }
        return conversationTitleBtnConfig.i();
    }

    private final boolean L() {
        if (this.icon == null || this.iconRedTouch == null || !K() || !this.isIconLoadSuccess) {
            return false;
        }
        ImageView imageView = this.icon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("icon");
            imageView = null;
        }
        if (imageView.getDrawable() != null) {
            return true;
        }
        QLog.i("ConversationTitleBtnHelper", 1, "[isIconLoaded] icon drawable is null");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(ConversationTitleBtnHelperApiImpl this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.d0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O(View v3) {
        TitleButtonState D = D();
        X("qq_clck", D.getHasRedTouch(), D.getIsTipsShowing());
        TitleButtonProcessorManager a16 = TitleButtonProcessorManager.INSTANCE.a();
        ConversationTitleBtnConfig conversationTitleBtnConfig = this.config;
        ConversationTitleBtnConfig conversationTitleBtnConfig2 = null;
        if (conversationTitleBtnConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
            conversationTitleBtnConfig = null;
        }
        String businessId = conversationTitleBtnConfig.getBusinessId();
        Context context = v3.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "v.context");
        ConversationTitleBtnConfig conversationTitleBtnConfig3 = this.config;
        if (conversationTitleBtnConfig3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
            conversationTitleBtnConfig3 = null;
        }
        if (a16.m(D, businessId, context, conversationTitleBtnConfig3.getJumpUrl())) {
            if (QLog.isColorLevel()) {
                ConversationTitleBtnConfig conversationTitleBtnConfig4 = this.config;
                if (conversationTitleBtnConfig4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
                } else {
                    conversationTitleBtnConfig2 = conversationTitleBtnConfig4;
                }
                QLog.i("ConversationTitleBtnHelper", 2, "[onClickIcon] business=" + conversationTitleBtnConfig2.getBusinessId() + " handled by processor, buttonState=" + D);
            }
        } else {
            if (QLog.isColorLevel()) {
                ConversationTitleBtnConfig conversationTitleBtnConfig5 = this.config;
                if (conversationTitleBtnConfig5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
                    conversationTitleBtnConfig5 = null;
                }
                QLog.i("ConversationTitleBtnHelper", 2, "[onClickIcon] business=" + conversationTitleBtnConfig5.getBusinessId() + " handled by default, buttonState=" + D);
            }
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            BaseQQAppInterface baseQQAppInterface = peekAppRuntime instanceof BaseQQAppInterface ? (BaseQQAppInterface) peekAppRuntime : null;
            if (baseQQAppInterface == null) {
                return;
            }
            Context context2 = v3.getContext();
            ConversationTitleBtnConfig conversationTitleBtnConfig6 = this.config;
            if (conversationTitleBtnConfig6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
            } else {
                conversationTitleBtnConfig2 = conversationTitleBtnConfig6;
            }
            bi.c(baseQQAppInterface, context2, conversationTitleBtnConfig2.getJumpUrl()).b();
        }
        S(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q() {
        R();
        h(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v1, types: [com.tencent.mobileqq.util.conversationtitlebutton.a] */
    private final void S(boolean needClear) {
        IRedTouchManager iRedTouchManager;
        if (!L()) {
            if (QLog.isColorLevel()) {
                QLog.i("ConversationTitleBtnHelper", 2, "[refreshRedDot] icon not loaded");
                return;
            }
            return;
        }
        RedTouch redTouch = null;
        if (QLog.isColorLevel()) {
            ConversationTitleBtnConfig conversationTitleBtnConfig = this.config;
            if (conversationTitleBtnConfig == null) {
                Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
                conversationTitleBtnConfig = null;
            }
            String businessId = conversationTitleBtnConfig.getBusinessId();
            RedTouch redTouch2 = this.iconRedTouch;
            if (redTouch2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("iconRedTouch");
                redTouch2 = null;
            }
            int visibility = redTouch2.getVisibility();
            ImageView imageView = this.icon;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("icon");
                imageView = null;
            }
            int visibility2 = imageView.getVisibility();
            ImageView imageView2 = this.icon;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("icon");
                imageView2 = null;
            }
            QLog.i("ConversationTitleBtnHelper", 1, "[refreshRedDot] business=" + businessId + " iconRedTouchVisibility=" + visibility + " iconVisibility=" + visibility2 + " iconDrawable=" + (imageView2.getDrawable() != null));
        }
        ConversationTitleBtnConfig conversationTitleBtnConfig2 = this.config;
        if (conversationTitleBtnConfig2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
            conversationTitleBtnConfig2 = null;
        }
        if (conversationTitleBtnConfig2.getRedDotSet() != -1) {
            ConversationTitleBtnConfig conversationTitleBtnConfig3 = this.config;
            if (conversationTitleBtnConfig3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
                conversationTitleBtnConfig3 = null;
            }
            if (conversationTitleBtnConfig3.getRedDotAppId() != -1) {
                TitleButtonProcessorManager.Companion companion = TitleButtonProcessorManager.INSTANCE;
                TitleButtonProcessorManager a16 = companion.a();
                ConversationTitleBtnConfig conversationTitleBtnConfig4 = this.config;
                if (conversationTitleBtnConfig4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
                    conversationTitleBtnConfig4 = null;
                }
                if (!a16.n(conversationTitleBtnConfig4.getBusinessId())) {
                    T(needClear);
                    return;
                }
                AppRuntime C = C();
                if (C == null || (iRedTouchManager = (IRedTouchManager) C.getRuntimeService(IRedTouchManager.class, "")) == null) {
                    return;
                }
                ConversationTitleBtnConfig conversationTitleBtnConfig5 = this.config;
                if (conversationTitleBtnConfig5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
                    conversationTitleBtnConfig5 = null;
                }
                int redDotSet = conversationTitleBtnConfig5.getRedDotSet();
                ConversationTitleBtnConfig conversationTitleBtnConfig6 = this.config;
                if (conversationTitleBtnConfig6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
                    conversationTitleBtnConfig6 = null;
                }
                int redDotAppId = conversationTitleBtnConfig6.getRedDotAppId();
                StringBuilder sb5 = new StringBuilder();
                sb5.append(redDotAppId);
                BusinessInfoCheckUpdate.AppInfo appInfo = iRedTouchManager.getAppInfo(redDotSet, sb5.toString());
                if (appInfo == null) {
                    return;
                }
                TitleButtonProcessorManager a17 = companion.a();
                ConversationTitleBtnConfig conversationTitleBtnConfig7 = this.config;
                if (conversationTitleBtnConfig7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
                    conversationTitleBtnConfig7 = null;
                }
                String businessId2 = conversationTitleBtnConfig7.getBusinessId();
                RedTouch redTouch3 = this.iconRedTouch;
                if (redTouch3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("iconRedTouch");
                } else {
                    redTouch = redTouch3;
                }
                a17.r(businessId2, redTouch, appInfo, needClear);
                return;
            }
        }
        ?? r122 = this.config;
        if (r122 == 0) {
            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
        } else {
            redTouch = r122;
        }
        QLog.i("ConversationTitleBtnHelper", 1, "[refreshRedDot] invalid red dot config, config=" + redTouch);
    }

    private final void V() {
        URLDrawable uRLDrawable = this.iconImageDrawable;
        Drawable currDrawable = uRLDrawable != null ? uRLDrawable.getCurrDrawable() : null;
        ApngDrawable apngDrawable = currDrawable instanceof ApngDrawable ? (ApngDrawable) currDrawable : null;
        if (apngDrawable != null) {
            apngDrawable.repaly();
            ApngImage.resumeAll();
        }
    }

    private final void W() {
        if (this.shouldReplyIconAnimation) {
            this.shouldReplyIconAnimation = false;
            V();
        }
    }

    private final void X(String event, boolean hasRedTouch, boolean isTipsShowing) {
        if (QLog.isDevelopLevel()) {
            QLog.d("ConversationTitleBtnHelper", 4, "[reportDaTong] event=" + event + " hasRedTouch=" + hasRedTouch + " isTipsShowing=" + isTipsShowing);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("qq_eid", "em_bas_upper_right_service_entry");
        ConversationTitleBtnConfig conversationTitleBtnConfig = this.config;
        if (conversationTitleBtnConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
            conversationTitleBtnConfig = null;
        }
        hashMap.put("buss_id", conversationTitleBtnConfig.getBusinessId());
        hashMap.put("is_red_tips", Integer.valueOf(hasRedTouch ? 1 : 0));
        hashMap.put("is_bubble", Integer.valueOf(isTipsShowing ? 1 : 0));
        hashMap.put("qq_pgid", "pg_bas_msglist");
        hashMap.put("qq_pgstp", 1);
        hashMap.put("qq_ref_pgid", PageUtils.VR_PAGE_NONE);
        AppRuntime C = C();
        String currentUid = C != null ? C.getCurrentUid() : null;
        String str = "";
        if (currentUid == null) {
            currentUid = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(currentUid, "getAppRuntime()?.currentUid ?: \"\"");
        }
        hashMap.put("uid", currentUid);
        AppRuntime C2 = C();
        String currentUin = C2 != null ? C2.getCurrentUin() : null;
        if (currentUin != null) {
            Intrinsics.checkNotNullExpressionValue(currentUin, "getAppRuntime()?.currentUin ?: \"\"");
            str = currentUin;
        }
        hashMap.put("home_uin", str);
        hashMap.put("msglist_type", 0);
        VideoReport.reportEvent(event, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z(final String tipText, final List<? extends Drawable> avatars) {
        if (TextUtils.isEmpty(tipText)) {
            QLog.i("ConversationTitleBtnHelper", 1, "[refreshTip] tip text is empty");
            return;
        }
        if (!A(false)) {
            QLog.i("ConversationTitleBtnHelper", 1, "[refreshTip] can not show tips, add to pending");
            this.pendingShowTipsRunnable = new Runnable() { // from class: com.tencent.mobileqq.util.conversationtitlebutton.api.impl.e
                @Override // java.lang.Runnable
                public final void run() {
                    ConversationTitleBtnHelperApiImpl.a0(ConversationTitleBtnHelperApiImpl.this, tipText, avatars);
                }
            };
            return;
        }
        ImageView imageView = this.icon;
        ConversationTitleBtnConfig conversationTitleBtnConfig = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("icon");
            imageView = null;
        }
        com.tencent.mobileqq.widget.tip.a r16 = QUIDefaultBubbleTip.r(imageView.getContext());
        ImageView imageView2 = this.icon;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("icon");
            imageView2 = null;
        }
        com.tencent.mobileqq.widget.tip.a f16 = r16.S(imageView2).o0(tipText).k0(1).R(2).i0(12.0f, 0.0f).b0(5000L).g0(false).m0(3).f(new g(tipText, this));
        List<? extends Drawable> list = avatars;
        if (!list.isEmpty()) {
            Object[] array = list.toArray(new Drawable[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            f16.U((Drawable[]) array);
        }
        ConversationTitleBtnConfig conversationTitleBtnConfig2 = this.config;
        if (conversationTitleBtnConfig2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
        } else {
            conversationTitleBtnConfig = conversationTitleBtnConfig2;
        }
        QLog.i("ConversationTitleBtnHelper", 1, "[refreshTip] start showing tips, tag=" + conversationTitleBtnConfig.getBusinessId() + " content=" + tipText + " avatars=" + avatars.size());
        f16.s0();
        this.showingTipView = f16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(ConversationTitleBtnHelperApiImpl this$0, String str, List avatars) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(avatars, "$avatars");
        this$0.pendingShowTipsRunnable = null;
        QLog.i("ConversationTitleBtnHelper", 1, "[refreshTip] show pending tips, tips=" + str);
        this$0.Z(str, avatars);
    }

    private final void b0() {
        String accessibilityLabel;
        ConversationTitleBtnConfig conversationTitleBtnConfig = this.config;
        ImageView imageView = null;
        if (conversationTitleBtnConfig == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
            conversationTitleBtnConfig = null;
        }
        if (TextUtils.isEmpty(conversationTitleBtnConfig.getAccessibilityLabel())) {
            return;
        }
        RedTouch redTouch = this.iconRedTouch;
        if (redTouch == null) {
            Intrinsics.throwUninitializedPropertyAccessException("iconRedTouch");
            redTouch = null;
        }
        if (redTouch.hasRedTouch()) {
            ConversationTitleBtnConfig conversationTitleBtnConfig2 = this.config;
            if (conversationTitleBtnConfig2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
                conversationTitleBtnConfig2 = null;
            }
            accessibilityLabel = conversationTitleBtnConfig2.getAccessibilityLabel() + "\u6709\u66f4\u65b0";
        } else {
            ConversationTitleBtnConfig conversationTitleBtnConfig3 = this.config;
            if (conversationTitleBtnConfig3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
                conversationTitleBtnConfig3 = null;
            }
            accessibilityLabel = conversationTitleBtnConfig3.getAccessibilityLabel();
        }
        ImageView imageView2 = this.icon;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("icon");
        } else {
            imageView = imageView2;
        }
        AccessibilityUtil.c(imageView, accessibilityLabel, Button.class.getName());
    }

    private final void c0() {
        Integer num = this.iconFilterColor;
        if (num != null) {
            d(num.intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d0() {
        if (StudyModeManager.t()) {
            if (QLog.isColorLevel()) {
                QLog.i("ConversationTitleBtnHelper", 2, "[getConfig] study mode, return");
            }
            this.config = new ConversationTitleBtnConfig(null, 0, 0, 0, 0, null, null, null, 255, null);
            I();
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        final WeakReference weakReference = new WeakReference(this);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.util.conversationtitlebutton.api.impl.b
            @Override // java.lang.Runnable
            public final void run() {
                ConversationTitleBtnHelperApiImpl.e0(currentTimeMillis, this, weakReference);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(long j3, ConversationTitleBtnHelperApiImpl this$0, WeakReference weakSelf) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(weakSelf, "$weakSelf");
        TitleButtonProcessorManager.j(TitleButtonProcessorManager.INSTANCE.a(), false, new ConversationTitleBtnHelperApiImpl$updateConfig$1$1(j3, this$0, weakSelf), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean z(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            view.setAlpha(0.5f);
            return false;
        }
        if (action != 1 && action != 3) {
            return false;
        }
        view.setAlpha(1.0f);
        return false;
    }

    @Override // com.tencent.mobileqq.util.conversationtitlebutton.d
    public void a() {
        W();
    }

    @Override // com.tencent.mobileqq.util.conversationtitlebutton.d
    public void b(int alpha) {
        ImageView imageView = this.icon;
        if (imageView == null) {
            return;
        }
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("icon");
            imageView = null;
        }
        imageView.setImageAlpha(alpha);
    }

    @Override // com.tencent.mobileqq.util.conversationtitlebutton.d
    public void c() {
        TitleButtonProcessorManager.INSTANCE.a().s(this.dataObserver);
        StudyModeManager.U(this.studyModeChangeListener);
        GuardManager.sInstance.unregisterCallback(this.guardManagerCallback);
    }

    @Override // com.tencent.mobileqq.util.conversationtitlebutton.d
    public void d(int color) {
        this.iconFilterColor = Integer.valueOf(color);
        if (this.icon == null) {
            if (QLog.isColorLevel()) {
                QLog.i("ConversationTitleBtnHelper", 2, "[updateColorFilter] icon not initialized, color=" + color);
                return;
            }
            return;
        }
        ImageView imageView = null;
        if (B(this.iconDrawableUrl)) {
            ImageView imageView2 = this.icon;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("icon");
            } else {
                imageView = imageView2;
            }
            imageView.setColorFilter(new PorterDuffColorFilter(color, PorterDuff.Mode.SRC_ATOP));
            return;
        }
        ImageView imageView3 = this.icon;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("icon");
            imageView3 = null;
        }
        imageView3.setColorFilter((ColorFilter) null);
    }

    @Override // com.tencent.mobileqq.util.conversationtitlebutton.d
    public boolean e() {
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("main_page_enable_new_title_button_9020", true)) {
            return true;
        }
        QLog.i("ConversationTitleBtnHelper", 1, "[useNewVersionTitleButton] switch is off");
        return false;
    }

    @Override // com.tencent.mobileqq.util.conversationtitlebutton.d
    public void f() {
        TitleButtonProcessorManager.INSTANCE.a().f(this.dataObserver);
        StudyModeManager.H(this.studyModeChangeListener);
        GuardManager.sInstance.registerCallBack(this.guardManagerCallback);
    }

    @Override // com.tencent.mobileqq.util.conversationtitlebutton.d
    public void g(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.u9a);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.c\u2026rsation_title_second_btn)");
        this.icon = (ImageView) findViewById;
        c0();
        ImageView imageView = this.icon;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("icon");
            imageView = null;
        }
        imageView.setOnTouchListener(this.buttonTouchListener);
        Context context = this.host.getContext();
        ImageView imageView3 = this.icon;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("icon");
        } else {
            imageView2 = imageView3;
        }
        RedTouch applyTo = new RedTouch(context, imageView2).setGravity(53).applyTo();
        Intrinsics.checkNotNullExpressionValue(applyTo, "RedTouch(host.getContext\u2026P)\n            .applyTo()");
        this.iconRedTouch = applyTo;
        d0();
    }

    @Override // com.tencent.mobileqq.util.conversationtitlebutton.d
    public void h(boolean needClear) {
        if (this.config == null) {
            QLog.i("ConversationTitleBtnHelper", 1, "[refreshRedDotAndTips] config not initialized");
            return;
        }
        if (QLog.isDevelopLevel()) {
            ConversationTitleBtnConfig conversationTitleBtnConfig = this.config;
            if (conversationTitleBtnConfig == null) {
                Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
                conversationTitleBtnConfig = null;
            }
            QLog.d("ConversationTitleBtnHelper", 1, "[refreshRedDotAndTips] needClear=" + needClear + " businessId=" + conversationTitleBtnConfig.getBusinessId() + "}");
        }
        S(needClear);
        U();
    }

    @Override // com.tencent.mobileqq.util.conversationtitlebutton.d
    public void i() {
        g(this.host.getContainerView());
    }

    @Override // com.tencent.mobileqq.util.conversationtitlebutton.d
    public void onResume(boolean tabChange) {
        if (QLog.isColorLevel()) {
            QLog.i("ConversationTitleBtnHelper", 1, "[onResume] tabChange=" + tabChange);
        }
        Runnable runnable = this.pendingShowTipsRunnable;
        if (runnable != null) {
            runnable.run();
        }
        ApngImage.resumeAll();
        if (!tabChange && !this.host.c()) {
            W();
        }
        if (L()) {
            TitleButtonState D = D();
            X("qq_imp", D.getHasRedTouch(), D.getIsTipsShowing());
        }
    }

    @Override // com.tencent.mobileqq.util.conversationtitlebutton.d
    public void resetVisibility() {
        if (this.iconRedTouch == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ConversationTitleBtnHelper", 2, "[resetVisibility]");
        }
        ImageView imageView = this.icon;
        RedTouch redTouch = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("icon");
            imageView = null;
        }
        imageView.setImageDrawable(null);
        RedTouch redTouch2 = this.iconRedTouch;
        if (redTouch2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("iconRedTouch");
        } else {
            redTouch = redTouch2;
        }
        redTouch.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N() {
        this.shouldReplyIconAnimation = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P() {
        this.isIconLoadSuccess = false;
    }

    private final void R() {
        this.isIconLoadSuccess = true;
        ApngImage.resumeAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y() {
        this.shouldReplyIconAnimation = true;
    }

    @Override // com.tencent.mobileqq.util.conversationtitlebutton.d
    public void onAccountChanged() {
        QLog.i("ConversationTitleBtnHelper", 1, "onAccountChanged");
        this.pendingShowTipsRunnable = null;
        if (this.icon == null || this.iconRedTouch == null) {
            return;
        }
        H();
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.util.conversationtitlebutton.api.impl.c
            @Override // java.lang.Runnable
            public final void run() {
                ConversationTitleBtnHelperApiImpl.M(ConversationTitleBtnHelperApiImpl.this);
            }
        });
    }

    @Override // com.tencent.mobileqq.util.conversationtitlebutton.d
    public void onBeforeAccountChanged() {
        QLog.i("ConversationTitleBtnHelper", 1, "onBeforeAccountChanged");
        this.config = new ConversationTitleBtnConfig(null, 0, 0, 0, 0, null, null, null, 255, null);
        ImageView imageView = this.icon;
        RedTouch redTouch = null;
        if (imageView != null) {
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("icon");
                imageView = null;
            }
            imageView.setVisibility(8);
        }
        RedTouch redTouch2 = this.iconRedTouch;
        if (redTouch2 != null) {
            if (redTouch2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("iconRedTouch");
            } else {
                redTouch = redTouch2;
            }
            redTouch.setVisibility(8);
        }
    }

    @Override // com.tencent.mobileqq.util.conversationtitlebutton.d
    public void onPostThemeChanged() {
        this.shouldReplyIconAnimation = true;
    }

    private final void U() {
        ImageView imageView;
        PBUInt32Field pBUInt32Field;
        PBInt32Field pBInt32Field;
        PBUInt32Field pBUInt32Field2;
        PBInt32Field pBInt32Field2;
        ConversationTitleBtnConfig conversationTitleBtnConfig;
        if (!L()) {
            if (QLog.isColorLevel()) {
                QLog.i("ConversationTitleBtnHelper", 2, "[refreshTip] icon not loaded");
                return;
            }
            return;
        }
        if (this.showingTipView != null) {
            QLog.i("ConversationTitleBtnHelper", 1, "[refreshTip] tip is showing, return");
            return;
        }
        final AppRuntime C = C();
        if (C == null) {
            return;
        }
        TitleButtonProcessorManager.Companion companion = TitleButtonProcessorManager.INSTANCE;
        TitleButtonProcessorManager a16 = companion.a();
        ConversationTitleBtnConfig conversationTitleBtnConfig2 = this.config;
        if (conversationTitleBtnConfig2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
            conversationTitleBtnConfig2 = null;
        }
        if (a16.o(conversationTitleBtnConfig2.getBusinessId())) {
            TitleButtonProcessorManager a17 = companion.a();
            ConversationTitleBtnConfig conversationTitleBtnConfig3 = this.config;
            if (conversationTitleBtnConfig3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
                conversationTitleBtnConfig = null;
            } else {
                conversationTitleBtnConfig = conversationTitleBtnConfig3;
            }
            a17.k(conversationTitleBtnConfig.getBusinessId(), this.host.getContext(), new Function2<String, List<? extends Drawable>, Unit>() { // from class: com.tencent.mobileqq.util.conversationtitlebutton.api.impl.ConversationTitleBtnHelperApiImpl$refreshTip$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(String str, List<? extends Drawable> list) {
                    invoke2(str, list);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String tipText, List<? extends Drawable> avatars) {
                    ConversationTitleBtnConfig conversationTitleBtnConfig4;
                    ConversationTitleBtnConfig conversationTitleBtnConfig5;
                    Intrinsics.checkNotNullParameter(tipText, "tipText");
                    Intrinsics.checkNotNullParameter(avatars, "avatars");
                    if (QLog.isColorLevel()) {
                        conversationTitleBtnConfig4 = ConversationTitleBtnHelperApiImpl.this.config;
                        ConversationTitleBtnConfig conversationTitleBtnConfig6 = null;
                        if (conversationTitleBtnConfig4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
                            conversationTitleBtnConfig4 = null;
                        }
                        String businessId = conversationTitleBtnConfig4.getBusinessId();
                        conversationTitleBtnConfig5 = ConversationTitleBtnHelperApiImpl.this.config;
                        if (conversationTitleBtnConfig5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
                        } else {
                            conversationTitleBtnConfig6 = conversationTitleBtnConfig5;
                        }
                        QLog.i("ConversationTitleBtnHelper", 2, "[refreshTip] custom tips, business=" + businessId + " tips=" + tipText + "  tipsAppId=" + conversationTitleBtnConfig6.getTipsAppId());
                    }
                    ConversationTitleBtnHelperApiImpl.this.Z(tipText, avatars);
                }
            });
            return;
        }
        e eVar = e.f306708a;
        ConversationTitleBtnConfig conversationTitleBtnConfig4 = this.config;
        if (conversationTitleBtnConfig4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
            conversationTitleBtnConfig4 = null;
        }
        final BusinessInfoCheckUpdate.AppInfo d16 = eVar.d(C, conversationTitleBtnConfig4);
        final String e16 = eVar.e(d16);
        if (TextUtils.isEmpty(e16)) {
            if (QLog.isColorLevel()) {
                ConversationTitleBtnConfig conversationTitleBtnConfig5 = this.config;
                if (conversationTitleBtnConfig5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
                    conversationTitleBtnConfig5 = null;
                }
                String businessId = conversationTitleBtnConfig5.getBusinessId();
                ConversationTitleBtnConfig conversationTitleBtnConfig6 = this.config;
                if (conversationTitleBtnConfig6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
                    conversationTitleBtnConfig6 = null;
                }
                QLog.i("ConversationTitleBtnHelper", 2, "[refreshTip] no tips, business=" + businessId + " tipsAppId=" + conversationTitleBtnConfig6.getTipsAppId() + " newFlag=" + ((d16 == null || (pBInt32Field2 = d16.iNewFlag) == null) ? null : Integer.valueOf(pBInt32Field2.get())) + " exposureMax=" + ((d16 == null || (pBUInt32Field2 = d16.exposure_max) == null) ? null : Integer.valueOf(pBUInt32Field2.get())));
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            ConversationTitleBtnConfig conversationTitleBtnConfig7 = this.config;
            if (conversationTitleBtnConfig7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
                conversationTitleBtnConfig7 = null;
            }
            String businessId2 = conversationTitleBtnConfig7.getBusinessId();
            ConversationTitleBtnConfig conversationTitleBtnConfig8 = this.config;
            if (conversationTitleBtnConfig8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
                conversationTitleBtnConfig8 = null;
            }
            QLog.i("ConversationTitleBtnHelper", 2, "[refreshTip] default tips, business=" + businessId2 + " tips=" + e16 + "  tipsAppId=" + conversationTitleBtnConfig8.getTipsAppId() + " newFlag=" + ((d16 == null || (pBInt32Field = d16.iNewFlag) == null) ? null : Integer.valueOf(pBInt32Field.get())) + " exposureMax=" + ((d16 == null || (pBUInt32Field = d16.exposure_max) == null) ? null : Integer.valueOf(pBUInt32Field.get())));
        }
        TitleButtonProcessorManager a18 = companion.a();
        ConversationTitleBtnConfig conversationTitleBtnConfig9 = this.config;
        if (conversationTitleBtnConfig9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
            conversationTitleBtnConfig9 = null;
        }
        String businessId3 = conversationTitleBtnConfig9.getBusinessId();
        ImageView imageView2 = this.icon;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("icon");
            imageView = null;
        } else {
            imageView = imageView2;
        }
        Context context = imageView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "icon.context");
        a18.g(businessId3, d16, context, new Function1<Drawable[], Unit>() { // from class: com.tencent.mobileqq.util.conversationtitlebutton.api.impl.ConversationTitleBtnHelperApiImpl$refreshTip$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Drawable[] drawableArr) {
                invoke2(drawableArr);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Drawable[] it) {
                List list;
                Intrinsics.checkNotNullParameter(it, "it");
                ConversationTitleBtnHelperApiImpl.e.f306708a.g(AppRuntime.this, d16);
                ConversationTitleBtnHelperApiImpl conversationTitleBtnHelperApiImpl = this;
                String str = e16;
                list = ArraysKt___ArraysKt.toList(it);
                conversationTitleBtnHelperApiImpl.Z(str, list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u00c2\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/util/conversationtitlebutton/api/impl/ConversationTitleBtnHelperApiImpl$e;", "", "Lmqq/app/AppRuntime;", "app", "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;", "appInfoForTip", "", "b", "Lcom/tencent/mobileqq/util/conversationtitlebutton/a;", DownloadInfo.spKey_Config, "d", "", "e", "f", "g", "<init>", "()V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        public static final e f306708a = new e();

        e() {
        }

        private final void b(final AppRuntime app, final BusinessInfoCheckUpdate.AppInfo appInfoForTip) {
            ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.util.conversationtitlebutton.api.impl.h
                @Override // java.lang.Runnable
                public final void run() {
                    ConversationTitleBtnHelperApiImpl.e.c(AppRuntime.this, appInfoForTip);
                }
            }, 16, null, false, 1L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(AppRuntime app, BusinessInfoCheckUpdate.AppInfo appInfoForTip) {
            Intrinsics.checkNotNullParameter(app, "$app");
            Intrinsics.checkNotNullParameter(appInfoForTip, "$appInfoForTip");
            IRuntimeService runtimeService = app.getRuntimeService(IRedTouchManager.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IR\u2026va, ProcessConstant.MAIN)");
            IRedTouchManager iRedTouchManager = (IRedTouchManager) runtimeService;
            BusinessInfoCheckUpdate.AppInfo appInfo = new BusinessInfoCheckUpdate.AppInfo();
            appInfo.set(appInfoForTip);
            int i3 = appInfo.exposure_max.get() - 1;
            if (i3 == 0) {
                i3 = -1;
            }
            appInfo.exposure_max.set(i3);
            iRedTouchManager.updateAppInfo(appInfo, false);
        }

        public final BusinessInfoCheckUpdate.AppInfo d(AppRuntime app, ConversationTitleBtnConfig config) {
            Intrinsics.checkNotNullParameter(app, "app");
            Intrinsics.checkNotNullParameter(config, "config");
            if (config.getTipsSet() != -1 && config.getTipsAppId() != -1) {
                IRuntimeService runtimeService = app.getRuntimeService(IRedTouchManager.class, "");
                Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IR\u2026va, ProcessConstant.MAIN)");
                int tipsSet = config.getTipsSet();
                int tipsAppId = config.getTipsAppId();
                StringBuilder sb5 = new StringBuilder();
                sb5.append(tipsAppId);
                BusinessInfoCheckUpdate.AppInfo appInfo = ((IRedTouchManager) runtimeService).getAppInfo(tipsSet, sb5.toString());
                if (appInfo == null) {
                    QLog.i("ConversationTitleBtnHelper", 1, "[getAppInfoByConfig] app info is null, id=" + config.getBusinessId());
                    return null;
                }
                if (appInfo.iNewFlag.get() == 1 && appInfo.exposure_max.get() > 0) {
                    return appInfo;
                }
                if (QLog.isDevelopLevel()) {
                    QLog.i("ConversationTitleBtnHelper", 1, "[getAppInfoByConfig] tips data not valid, id=" + config.getBusinessId() + " iNewFlag=" + appInfo.iNewFlag.get() + " exposureMax=" + appInfo.exposure_max.get());
                }
                return null;
            }
            QLog.i("ConversationTitleBtnHelper", 1, "[getAppInfoByConfig] invalid tip config, id=" + config.getBusinessId());
            return null;
        }

        public final void f(AppRuntime app, BusinessInfoCheckUpdate.AppInfo appInfoForTip) {
            Intrinsics.checkNotNullParameter(app, "app");
            if (appInfoForTip == null) {
                return;
            }
            IRuntimeService runtimeService = app.getRuntimeService(IRedTouchManager.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IR\u2026va, ProcessConstant.MAIN)");
            ((IRedTouchManager) runtimeService).onRedTouchItemExposure(appInfoForTip, null);
            b(app, appInfoForTip);
        }

        public final void g(AppRuntime app, BusinessInfoCheckUpdate.AppInfo appInfoForTip) {
            Intrinsics.checkNotNullParameter(app, "app");
            f(app, appInfoForTip);
        }

        public final String e(BusinessInfoCheckUpdate.AppInfo appInfoForTip) {
            if (appInfoForTip == null) {
                return null;
            }
            try {
                PBRepeatMessageField<BusinessInfoCheckUpdate.RedTypeInfo> pBRepeatMessageField = appInfoForTip.red_display_info.red_type_info;
                int size = pBRepeatMessageField.size();
                for (int i3 = 0; i3 < size; i3++) {
                    BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo = pBRepeatMessageField.get(i3);
                    if (redTypeInfo.red_type.get() == 4 || redTypeInfo.red_type.get() == 26) {
                        String text = redTypeInfo.red_content.get();
                        Intrinsics.checkNotNullExpressionValue(text, "text");
                        if ((text.length() > 0) && !Intrinsics.areEqual(text, "0")) {
                            return redTypeInfo.red_content.get();
                        }
                    }
                }
            } catch (Exception e16) {
                QLog.i("ConversationTitleBtnHelper", 1, "[getTipContentFromAppInfo] exc=" + e16);
            }
            return null;
        }
    }

    private final boolean B(String url) {
        if (url == null || url.length() == 0) {
            return true;
        }
        try {
            String queryParameter = Uri.parse(url).getQueryParameter(CustomAnimation.KeyPath.COLOR_FILTER);
            if (queryParameter != null) {
                if (Intrinsics.areEqual(queryParameter, "0")) {
                    return false;
                }
                return !Intrinsics.areEqual(queryParameter, "false");
            }
        } catch (Exception e16) {
            QLog.i("ConversationTitleBtnHelper", 1, "[enableColorFilterForIcon] url=" + url + " exc=" + e16);
        }
        return true;
    }

    private final void T(boolean needClear) {
        String str;
        ConversationTitleBtnConfig conversationTitleBtnConfig;
        PBRepeatMessageField<BusinessInfoCheckUpdate.RedTypeInfo> pBRepeatMessageField;
        List<BusinessInfoCheckUpdate.RedTypeInfo> list;
        ImageView imageView;
        String str2;
        Integer num;
        RedTouch redTouch;
        PBRepeatMessageField<BusinessInfoCheckUpdate.RedTypeInfo> pBRepeatMessageField2;
        List<BusinessInfoCheckUpdate.RedTypeInfo> list2;
        ConversationTitleBtnConfig conversationTitleBtnConfig2;
        ConversationTitleBtnHelperApiImpl conversationTitleBtnHelperApiImpl = this;
        AppRuntime C = C();
        if (C == null) {
            return;
        }
        IRuntimeService runtimeService = C.getRuntimeService(IRedTouchManager.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
        IRedTouchManager iRedTouchManager = (IRedTouchManager) runtimeService;
        ConversationTitleBtnConfig conversationTitleBtnConfig3 = conversationTitleBtnHelperApiImpl.config;
        if (conversationTitleBtnConfig3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
            conversationTitleBtnConfig3 = null;
        }
        if (conversationTitleBtnConfig3.getRedDotSet() == -1) {
            str = "ConversationTitleBtnHelper";
            conversationTitleBtnHelperApiImpl = this;
        } else {
            ConversationTitleBtnConfig conversationTitleBtnConfig4 = conversationTitleBtnHelperApiImpl.config;
            if (conversationTitleBtnConfig4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
                conversationTitleBtnConfig4 = null;
            }
            if (conversationTitleBtnConfig4.getRedDotAppId() == -1) {
                str = "ConversationTitleBtnHelper";
            } else {
                ConversationTitleBtnConfig conversationTitleBtnConfig5 = conversationTitleBtnHelperApiImpl.config;
                if (conversationTitleBtnConfig5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
                    conversationTitleBtnConfig5 = null;
                }
                int redDotSet = conversationTitleBtnConfig5.getRedDotSet();
                ConversationTitleBtnConfig conversationTitleBtnConfig6 = conversationTitleBtnHelperApiImpl.config;
                if (conversationTitleBtnConfig6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
                    conversationTitleBtnConfig6 = null;
                }
                int redDotAppId = conversationTitleBtnConfig6.getRedDotAppId();
                StringBuilder sb5 = new StringBuilder();
                sb5.append(redDotAppId);
                BusinessInfoCheckUpdate.AppInfo appInfo = iRedTouchManager.getAppInfo(redDotSet, sb5.toString());
                if (appInfo == null) {
                    ConversationTitleBtnConfig conversationTitleBtnConfig7 = conversationTitleBtnHelperApiImpl.config;
                    if (conversationTitleBtnConfig7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
                        conversationTitleBtnConfig2 = null;
                    } else {
                        conversationTitleBtnConfig2 = conversationTitleBtnConfig7;
                    }
                    QLog.i("ConversationTitleBtnHelper", 1, "[refreshRedDotDefault] app info not exists, config=" + conversationTitleBtnConfig2);
                    return;
                }
                boolean hasRedTouch = RedTouch.hasRedTouch(appInfo);
                RedTouch redTouch2 = conversationTitleBtnHelperApiImpl.iconRedTouch;
                if (redTouch2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("iconRedTouch");
                    redTouch2 = null;
                }
                boolean hasRedTouch2 = redTouch2.hasRedTouch();
                if (hasRedTouch && !hasRedTouch2) {
                    RedTouch redTouch3 = conversationTitleBtnHelperApiImpl.iconRedTouch;
                    if (redTouch3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("iconRedTouch");
                        redTouch3 = null;
                    }
                    redTouch3.parseRedTouch(appInfo);
                    RedTouch redTouch4 = conversationTitleBtnHelperApiImpl.iconRedTouch;
                    if (redTouch4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("iconRedTouch");
                        redTouch4 = null;
                    }
                    int outerRedType = redTouch4.getOuterRedType();
                    ConversationTitleBtnConfig conversationTitleBtnConfig8 = conversationTitleBtnHelperApiImpl.config;
                    if (conversationTitleBtnConfig8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
                        conversationTitleBtnConfig8 = null;
                    }
                    int redDotSet2 = conversationTitleBtnConfig8.getRedDotSet();
                    ConversationTitleBtnConfig conversationTitleBtnConfig9 = conversationTitleBtnHelperApiImpl.config;
                    if (conversationTitleBtnConfig9 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
                        conversationTitleBtnConfig9 = null;
                    }
                    int redDotAppId2 = conversationTitleBtnConfig9.getRedDotAppId();
                    int i3 = appInfo.iNewFlag.get();
                    int i16 = appInfo.exposure_max.get();
                    BusinessInfoCheckUpdate.RedDisplayInfo redDisplayInfo = appInfo.red_display_info.get();
                    if (redDisplayInfo == null || (pBRepeatMessageField2 = redDisplayInfo.red_type_info) == null || (list2 = pBRepeatMessageField2.get()) == null) {
                        str2 = "iconRedTouch";
                        num = null;
                    } else {
                        num = Integer.valueOf(list2.size());
                        str2 = "iconRedTouch";
                    }
                    QLog.i("ConversationTitleBtnHelper", 1, "[refreshRedDotDefault] show red point, outerRedType=" + outerRedType + " redDot=" + redDotSet2 + "-" + redDotAppId2 + " newFlag=" + i3 + " exposureMax=" + i16 + " redTypeInfoSize=" + num);
                    if (outerRedType == 0) {
                        e.f306708a.f(C, appInfo);
                    } else {
                        QLog.i("ConversationTitleBtnHelper", 1, "[refreshRedDotDefault] red point type not supported, type=" + outerRedType);
                        RedTouch redTouch5 = this.iconRedTouch;
                        if (redTouch5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException(str2);
                            redTouch = null;
                        } else {
                            redTouch = redTouch5;
                        }
                        redTouch.clearRedTouch();
                    }
                } else if (hasRedTouch2 && needClear) {
                    ConversationTitleBtnConfig conversationTitleBtnConfig10 = conversationTitleBtnHelperApiImpl.config;
                    if (conversationTitleBtnConfig10 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
                        conversationTitleBtnConfig10 = null;
                    }
                    int redDotSet3 = conversationTitleBtnConfig10.getRedDotSet();
                    ConversationTitleBtnConfig conversationTitleBtnConfig11 = conversationTitleBtnHelperApiImpl.config;
                    if (conversationTitleBtnConfig11 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
                        conversationTitleBtnConfig11 = null;
                    }
                    QLog.i("ConversationTitleBtnHelper", 1, "[refreshRedDotDefault] clear red point, because hasShown redDot=" + redDotSet3 + "-" + conversationTitleBtnConfig11.getRedDotAppId());
                    iRedTouchManager.onRedTouchItemClick(appInfo, null);
                    RedTouch redTouch6 = conversationTitleBtnHelperApiImpl.iconRedTouch;
                    if (redTouch6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("iconRedTouch");
                        redTouch6 = null;
                    }
                    redTouch6.clearRedTouch();
                    ImageView imageView2 = conversationTitleBtnHelperApiImpl.icon;
                    if (imageView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("icon");
                        imageView = null;
                    } else {
                        imageView = imageView2;
                    }
                    imageView.setVisibility(0);
                } else if (QLog.isDevelopLevel()) {
                    ConversationTitleBtnConfig conversationTitleBtnConfig12 = conversationTitleBtnHelperApiImpl.config;
                    if (conversationTitleBtnConfig12 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
                        conversationTitleBtnConfig12 = null;
                    }
                    String businessId = conversationTitleBtnConfig12.getBusinessId();
                    ConversationTitleBtnConfig conversationTitleBtnConfig13 = conversationTitleBtnHelperApiImpl.config;
                    if (conversationTitleBtnConfig13 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
                        conversationTitleBtnConfig13 = null;
                    }
                    int redDotSet4 = conversationTitleBtnConfig13.getRedDotSet();
                    ConversationTitleBtnConfig conversationTitleBtnConfig14 = conversationTitleBtnHelperApiImpl.config;
                    if (conversationTitleBtnConfig14 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
                        conversationTitleBtnConfig14 = null;
                    }
                    int redDotAppId3 = conversationTitleBtnConfig14.getRedDotAppId();
                    int i17 = appInfo.iNewFlag.get();
                    int i18 = appInfo.exposure_max.get();
                    BusinessInfoCheckUpdate.RedDisplayInfo redDisplayInfo2 = appInfo.red_display_info.get();
                    QLog.i("ConversationTitleBtnHelper", 1, "[refreshRedDotDefault] do nothing, business=" + businessId + " needShow=" + hasRedTouch + " hasShown=" + hasRedTouch2 + " needClear=" + needClear + " redDot=" + redDotSet4 + "-" + redDotAppId3 + " newFlag=" + i17 + " exposureMax=" + i18 + " redTypeInfoSize=" + ((redDisplayInfo2 == null || (pBRepeatMessageField = redDisplayInfo2.red_type_info) == null || (list = pBRepeatMessageField.get()) == null) ? null : Integer.valueOf(list.size())));
                }
                b0();
                return;
            }
        }
        ConversationTitleBtnConfig conversationTitleBtnConfig15 = conversationTitleBtnHelperApiImpl.config;
        if (conversationTitleBtnConfig15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(DownloadInfo.spKey_Config);
            conversationTitleBtnConfig = null;
        } else {
            conversationTitleBtnConfig = conversationTitleBtnConfig15;
        }
        QLog.i(str, 1, "[refreshRedDotDefault] invalid red dot config, config=" + conversationTitleBtnConfig);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016R\"\u0010\u0012\u001a\u0010\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u000e0\u000e0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/util/conversationtitlebutton/api/impl/ConversationTitleBtnHelperApiImpl$b;", "Lcom/tencent/mobileqq/app/guard/guardinterface/IGuardInterface;", "", "onApplicationForeground", "onApplicationBackground", "", "isEnabled", "onScreensStateChanged", "", "tick", "onBackgroundTimeTick", "onLiteTimeTick", "onBackgroundUnguardTimeTick", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/util/conversationtitlebutton/api/impl/ConversationTitleBtnHelperApiImpl;", "kotlin.jvm.PlatformType", "d", "Ljava/lang/ref/WeakReference;", "weakReference", "host", "<init>", "(Lcom/tencent/mobileqq/util/conversationtitlebutton/api/impl/ConversationTitleBtnHelperApiImpl;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    private static final class b implements IGuardInterface {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<ConversationTitleBtnHelperApiImpl> weakReference;

        public b(ConversationTitleBtnHelperApiImpl host) {
            Intrinsics.checkNotNullParameter(host, "host");
            this.weakReference = new WeakReference<>(host);
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onApplicationBackground() {
            ConversationTitleBtnHelperApiImpl conversationTitleBtnHelperApiImpl = this.weakReference.get();
            if (conversationTitleBtnHelperApiImpl != null) {
                conversationTitleBtnHelperApiImpl.N();
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onApplicationForeground() {
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onBackgroundTimeTick(long tick) {
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onBackgroundUnguardTimeTick(long tick) {
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onLiteTimeTick(long tick) {
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onScreensStateChanged(boolean isEnabled) {
        }
    }

    @Override // com.tencent.mobileqq.util.conversationtitlebutton.d
    public void onPause() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u0012\u0006\u0010\u0010\u001a\u00020\r\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016R\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\"\u0010\u0016\u001a\u0010\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\u00120\u00120\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/util/conversationtitlebutton/api/impl/ConversationTitleBtnHelperApiImpl$c;", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "Lcom/tencent/image/URLDrawable;", "drawable", "", "onLoadSuccessed", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "onLoadFialed", "onLoadCanceled", "", "progress", "onLoadProgressed", "", "d", "Ljava/lang/String;", "url", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/util/conversationtitlebutton/api/impl/ConversationTitleBtnHelperApiImpl;", "kotlin.jvm.PlatformType", "e", "Ljava/lang/ref/WeakReference;", "weakReference", "host", "<init>", "(Lcom/tencent/mobileqq/util/conversationtitlebutton/api/impl/ConversationTitleBtnHelperApiImpl;Ljava/lang/String;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements URLDrawable.URLDrawableListener {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final String url;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final WeakReference<ConversationTitleBtnHelperApiImpl> weakReference;

        public c(ConversationTitleBtnHelperApiImpl host, String url) {
            Intrinsics.checkNotNullParameter(host, "host");
            Intrinsics.checkNotNullParameter(url, "url");
            this.url = url;
            this.weakReference = new WeakReference<>(host);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(c this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            QLog.i("ConversationTitleBtnHelper", 1, "icon drawable load success, url=" + this$0.url);
            ConversationTitleBtnHelperApiImpl conversationTitleBtnHelperApiImpl = this$0.weakReference.get();
            if (conversationTitleBtnHelperApiImpl != null) {
                conversationTitleBtnHelperApiImpl.Q();
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable drawable, Throwable cause) {
            QLog.i("ConversationTitleBtnHelper", 1, "icon drawable load failed, url=" + this.url);
            ConversationTitleBtnHelperApiImpl conversationTitleBtnHelperApiImpl = this.weakReference.get();
            if (conversationTitleBtnHelperApiImpl != null) {
                conversationTitleBtnHelperApiImpl.P();
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable drawable) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.util.conversationtitlebutton.api.impl.f
                @Override // java.lang.Runnable
                public final void run() {
                    ConversationTitleBtnHelperApiImpl.c.b(ConversationTitleBtnHelperApiImpl.c.this);
                }
            });
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable drawable) {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable drawable, int progress) {
        }
    }
}
