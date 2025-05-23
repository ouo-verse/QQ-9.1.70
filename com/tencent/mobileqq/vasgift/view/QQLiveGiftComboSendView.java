package com.tencent.mobileqq.vasgift.view;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqlive.utils.q;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.vas.ToggleProxy;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.mobileqq.vasgift.utils.LongClickHandler;
import com.tencent.mobileqq.vasgift.utils.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.libpag.PAGFile;
import org.libpag.PAGView;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 g2\u00020\u0001:\u0002h*B\u0011\b\u0016\u0012\u0006\u0010_\u001a\u00020^\u00a2\u0006\u0004\b`\u0010aB\u001b\b\u0016\u0012\u0006\u0010_\u001a\u00020^\u0012\b\u0010c\u001a\u0004\u0018\u00010b\u00a2\u0006\u0004\b`\u0010dB#\b\u0016\u0012\u0006\u0010_\u001a\u00020^\u0012\b\u0010c\u001a\u0004\u0018\u00010b\u0012\u0006\u0010e\u001a\u00020\n\u00a2\u0006\u0004\b`\u0010fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0004J\u0016\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nJ\u0006\u0010\u000e\u001a\u00020\nJ\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\u0012\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010\u0015\u001a\u00020\u0004H\u0002J\b\u0010\u0016\u001a\u00020\u0004H\u0002J\b\u0010\u0017\u001a\u00020\u0004H\u0002J\b\u0010\u0018\u001a\u00020\u0004H\u0002J\b\u0010\u0019\u001a\u00020\u0004H\u0002J\b\u0010\u001a\u001a\u00020\u0004H\u0002J\b\u0010\u001b\u001a\u00020\u0004H\u0002J\b\u0010\u001c\u001a\u00020\u0004H\u0002J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\nH\u0002J\b\u0010\u001f\u001a\u00020\u0004H\u0002J\b\u0010 \u001a\u00020\u0004H\u0002J\b\u0010!\u001a\u00020\u0004H\u0002J\u0016\u0010$\u001a\b\u0012\u0004\u0012\u00020\n0#2\u0006\u0010\"\u001a\u00020\nH\u0002J\b\u0010\u0013\u001a\u00020\u0002H\u0002J\u001a\u0010)\u001a\u00020'2\u0006\u0010&\u001a\u00020%2\b\b\u0002\u0010(\u001a\u00020'H\u0002R\u0016\u0010,\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00101\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010.R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010;\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u00104R\u0018\u0010>\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010=R\u0018\u0010A\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010@R\u0018\u0010D\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010CR\u0018\u0010F\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010ER\u0016\u0010G\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010+R\u0016\u0010H\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010+R\u0016\u0010J\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010IR\u0016\u0010K\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010.R\u0016\u0010M\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010+R\u0016\u0010O\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010IR\u0014\u0010S\u001a\u00020P8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0014\u0010U\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bT\u0010IR\u0014\u0010Y\u001a\u00020V8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u0014\u0010]\u001a\u00020Z8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b[\u0010\\\u00a8\u0006i"}, d2 = {"Lcom/tencent/mobileqq/vasgift/view/QQLiveGiftComboSendView;", "Landroid/widget/FrameLayout;", "", "enable", "", DomainData.DOMAIN_NAME, "Lph2/b;", "listener", "setListener", "E", "", "initCombo", "maxCombo", "H", "o", "show", "t", "u", "Landroid/view/View;", "v", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, HippyTKDListViewAdapter.X, "y", "l", "j", UserInfo.SEX_FEMALE, "r", "w", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, WidgetCacheConstellationData.NUM, "G", "B", "D", BdhLogUtil.LogTag.Tag_Conn, "comboNum", "", "p", "", "secondKey", "", RemoteHandleConst.PARAM_DEFAULT_VALUE, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "d", "I", "sendDelayTimeConfig", "e", "J", "sendConsumeDelayMilles", "f", "sendComboOverDelayMilles", "Lorg/libpag/PAGView;", h.F, "Lorg/libpag/PAGView;", "comboWaveView", "Landroid/widget/ImageView;", "i", "Landroid/widget/ImageView;", "comboRaiseView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "comboMainView", "Landroid/widget/LinearLayout;", "Landroid/widget/LinearLayout;", "numViewContainer", "Lcom/tencent/mobileqq/vasgift/utils/LongClickHandler;", "Lcom/tencent/mobileqq/vasgift/utils/LongClickHandler;", "longClickHandler", "Landroid/animation/ObjectAnimator;", "Landroid/animation/ObjectAnimator;", "clickScaleAnimation", "Lph2/b;", "comboSendViewListener", "curComboNum", "maxComboNum", "Z", "callBackMaxNum", "startSendTime", "K", "numOfSendDuration", "L", "enableLongPress", "Lcom/tencent/mobileqq/vasgift/view/QQLiveGiftComboSendView$d;", "M", "Lcom/tencent/mobileqq/vasgift/view/QQLiveGiftComboSendView$d;", "notifyStateRecord", "N", "bugfix", "Ljava/lang/Runnable;", "P", "Ljava/lang/Runnable;", "delaySendRunnable", "Lcom/tencent/mobileqq/vasgift/view/a;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/vasgift/view/a;", "pagViewListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attributeSet", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BdhLogUtil.LogTag.Tag_Req, "c", "vas-gift-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class QQLiveGiftComboSendView extends FrameLayout {

    @Nullable
    private static PAGFile S;

    @Nullable
    private static PAGFile T;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private LinearLayout numViewContainer;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private LongClickHandler longClickHandler;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private ObjectAnimator clickScaleAnimation;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private ph2.b comboSendViewListener;

    /* renamed from: G, reason: from kotlin metadata */
    private int curComboNum;

    /* renamed from: H, reason: from kotlin metadata */
    private int maxComboNum;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean callBackMaxNum;

    /* renamed from: J, reason: from kotlin metadata */
    private long startSendTime;

    /* renamed from: K, reason: from kotlin metadata */
    private int numOfSendDuration;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean enableLongPress;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final d notifyStateRecord;

    /* renamed from: N, reason: from kotlin metadata */
    private final boolean bugfix;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final Runnable delaySendRunnable;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.vasgift.view.a pagViewListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int sendDelayTimeConfig;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long sendConsumeDelayMilles;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long sendComboOverDelayMilles;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private PAGView comboWaveView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView comboRaiseView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private PAGView comboMainView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/vasgift/view/QQLiveGiftComboSendView$a", "Lcom/tencent/mobileqq/vasgift/view/b;", "Landroid/view/View;", "v", "", "a", "vas-gift-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class a extends com.tencent.mobileqq.vasgift.view.b {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ QQLiveGiftComboSendView f312057f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Ref.IntRef intRef, QQLiveGiftComboSendView qQLiveGiftComboSendView) {
            super(intRef.element);
            this.f312057f = qQLiveGiftComboSendView;
        }

        @Override // com.tencent.mobileqq.vasgift.view.b
        public void a(@Nullable View v3) {
            this.f312057f.z(v3);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/vasgift/view/QQLiveGiftComboSendView$b", "Lcom/tencent/mobileqq/vasgift/utils/LongClickHandler$c;", "Landroid/view/View;", "view", "", "b", "c", "a", "vas-gift-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b implements LongClickHandler.c {
        b() {
        }

        @Override // com.tencent.mobileqq.vasgift.utils.LongClickHandler.c
        public void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
        }

        @Override // com.tencent.mobileqq.vasgift.utils.LongClickHandler.c
        public void b(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            QQLiveGiftComboSendView.this.x();
        }

        @Override // com.tencent.mobileqq.vasgift.utils.LongClickHandler.c
        public void c(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            QQLiveGiftComboSendView.this.y();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\"\u0010\u000b\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/vasgift/view/QQLiveGiftComboSendView$d;", "", "", "b", "c", "", "a", "Z", "()Z", "setHasNotifyComboOver", "(Z)V", "hasNotifyComboOver", "<init>", "()V", "vas-gift-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private volatile boolean hasNotifyComboOver;

        /* renamed from: a, reason: from getter */
        public final boolean getHasNotifyComboOver() {
            return this.hasNotifyComboOver;
        }

        public final void b() {
            if (QLog.isDebugVersion()) {
                QLog.i("QQLiveGiftComboSendView", 1, "do notifyComboOver");
            }
            this.hasNotifyComboOver = true;
        }

        public final void c() {
            if (QLog.isDebugVersion()) {
                QLog.i("QQLiveGiftComboSendView", 1, "do resetRecord");
            }
            this.hasNotifyComboOver = false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/vasgift/view/QQLiveGiftComboSendView$e", "Lcom/tencent/mobileqq/vasgift/view/a;", "Lorg/libpag/PAGView;", "p0", "", "onAnimationEnd", "onAnimationCancel", "vas-gift-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class e extends com.tencent.mobileqq.vasgift.view.a {
        e() {
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationCancel(@Nullable PAGView p06) {
            QLog.i("QQLiveGiftComboSendView", 1, "pagViewListener onAnimationCancel");
            QQLiveGiftComboSendView.this.j();
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationEnd(@Nullable PAGView p06) {
            QLog.i("QQLiveGiftComboSendView", 1, "pagViewListener onAnimationEnd");
            ph2.b bVar = QQLiveGiftComboSendView.this.comboSendViewListener;
            if (bVar != null) {
                bVar.b(QQLiveGiftComboSendView.this.curComboNum);
            }
            QQLiveGiftComboSendView.this.j();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQLiveGiftComboSendView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.sendDelayTimeConfig = 1000;
        this.sendConsumeDelayMilles = q("QQLIVE_CONSUME_DELAY_MILLES", 500L);
        this.sendComboOverDelayMilles = q("QQLIVE_COMBOOVER_DELAY_MILLES", 500L);
        this.maxComboNum = Integer.MAX_VALUE;
        this.notifyStateRecord = new d();
        this.bugfix = VasNormalToggle.VAS_GIFT_DATA_BUG.isEnable(true);
        LayoutInflater.from(getContext()).inflate(R.layout.h8w, this);
        this.comboWaveView = (PAGView) findViewById(R.id.f6324330);
        this.comboRaiseView = (ImageView) findViewById(R.id.f632332z);
        this.comboMainView = (PAGView) findViewById(R.id.f632132x);
        this.numViewContainer = (LinearLayout) findViewById(R.id.f632232y);
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = 200;
        ToggleProxy toggleProxy = VasToggle.VAS_LIVE_GIFT_TIME_CONFIG;
        if (toggleProxy.isEnable(false)) {
            String stringDataSet = toggleProxy.getStringDataSet("click_delay", "200");
            String stringDataSet2 = toggleProxy.getStringDataSet("request_delay", "1000");
            if (stringDataSet != null) {
                intRef.element = Integer.parseInt(stringDataSet);
            }
            if (stringDataSet2 != null) {
                this.sendDelayTimeConfig = Integer.parseInt(stringDataSet2);
            }
        }
        PAGView pAGView = this.comboMainView;
        if (pAGView != null) {
            pAGView.setOnClickListener(new a(intRef, this));
        }
        LongClickHandler longClickHandler = new LongClickHandler(this.comboMainView);
        longClickHandler.h(new b(), 200);
        this.longClickHandler = longClickHandler;
        u();
        this.delaySendRunnable = new Runnable() { // from class: com.tencent.mobileqq.vasgift.view.c
            @Override // java.lang.Runnable
            public final void run() {
                QQLiveGiftComboSendView.m(QQLiveGiftComboSendView.this);
            }
        };
        this.pagViewListener = new e();
    }

    private final void A() {
        B();
        D();
        C();
        G(this.curComboNum);
    }

    private final void B() {
        t(true);
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.comboMainView, PropertyValuesHolder.ofFloat((Property<?, Float>) FrameLayout.SCALE_X, 1.0f, 0.8f, 1.0f), PropertyValuesHolder.ofFloat((Property<?, Float>) FrameLayout.SCALE_Y, 1.0f, 0.8f, 1.0f));
        this.clickScaleAnimation = ofPropertyValuesHolder;
        if (ofPropertyValuesHolder != null) {
            ofPropertyValuesHolder.setDuration(300L);
        }
        ObjectAnimator objectAnimator = this.clickScaleAnimation;
        if (objectAnimator != null) {
            objectAnimator.start();
        }
        PAGView pAGView = this.comboMainView;
        if (pAGView != null) {
            pAGView.setComposition(T);
            pAGView.setRepeatCount(1);
            pAGView.removeListener(this.pagViewListener);
            pAGView.addListener(this.pagViewListener);
            pAGView.setScaleMode(3);
            pAGView.setProgress(0.0d);
            pAGView.flush();
            pAGView.play();
        }
    }

    private final void C() {
        ViewGroup.LayoutParams layoutParams;
        t(true);
        if (this.curComboNum < 20) {
            ImageView imageView = this.comboRaiseView;
            if (imageView != null) {
                layoutParams = imageView.getLayoutParams();
            } else {
                layoutParams = null;
            }
            if (layoutParams != null) {
                layoutParams.height = q.a(getContext(), 26.0f) + q.a(getContext(), this.curComboNum);
            }
            ImageView imageView2 = this.comboRaiseView;
            if (imageView2 != null) {
                imageView2.setLayoutParams(layoutParams);
            }
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mPlayGifImage = true;
        obtain.mLoadingDrawable = new ColorDrawable(R.color.f157845ch2);
        obtain.mUseMemoryCache = true;
        ImageView imageView3 = this.comboRaiseView;
        if (imageView3 != null) {
            com.tencent.mobileqq.vasgift.mvvm.business.anim.c cVar = com.tencent.mobileqq.vasgift.mvvm.business.anim.c.f311706a;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            imageView3.setImageDrawable(URLDrawable.getFileDrawable(cVar.i(context), obtain));
        }
    }

    private final void D() {
        t(true);
        PAGView pAGView = this.comboWaveView;
        if (pAGView != null) {
            pAGView.setComposition(S);
            pAGView.setRepeatCount(1);
            pAGView.setScaleMode(3);
            pAGView.setProgress(0.2d);
            pAGView.flush();
            pAGView.play();
        }
    }

    private final void F() {
        this.curComboNum++;
        this.numOfSendDuration++;
        PAGView pAGView = this.comboMainView;
        if (pAGView != null) {
            pAGView.performHapticFeedback(0, 2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void G(int num) {
        int size;
        int i3;
        LinearLayout linearLayout;
        if (num == 0) {
            LinearLayout linearLayout2 = this.numViewContainer;
            Intrinsics.checkNotNull(linearLayout2);
            int childCount = linearLayout2.getChildCount();
            for (int i16 = 0; i16 < childCount; i16++) {
                LinearLayout linearLayout3 = this.numViewContainer;
                Intrinsics.checkNotNull(linearLayout3);
                linearLayout3.getChildAt(i16).setVisibility(8);
            }
            return;
        }
        List<Integer> p16 = p(num);
        QLog.i("QQLiveGiftComboSendView", 1, "updateNum comboNum show:" + num);
        LinearLayout linearLayout4 = this.numViewContainer;
        Intrinsics.checkNotNull(linearLayout4);
        float f16 = 18.0f;
        float f17 = 10.0f;
        if (linearLayout4.getChildCount() >= p16.size()) {
            LinearLayout linearLayout5 = this.numViewContainer;
            Intrinsics.checkNotNull(linearLayout5);
            if (linearLayout5.getChildCount() > p16.size()) {
                LinearLayout linearLayout6 = this.numViewContainer;
                Intrinsics.checkNotNull(linearLayout6);
                int childCount2 = linearLayout6.getChildCount();
                for (int size2 = p16.size(); size2 < childCount2; size2++) {
                    LinearLayout linearLayout7 = this.numViewContainer;
                    Intrinsics.checkNotNull(linearLayout7);
                    linearLayout7.getChildAt(size2).setVisibility(8);
                }
            }
            size = p16.size();
            i3 = 0;
            while (i3 < size) {
                LinearLayout linearLayout8 = this.numViewContainer;
                Intrinsics.checkNotNull(linearLayout8);
                View childAt = linearLayout8.getChildAt(i3);
                Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type android.widget.ImageView");
                ImageView imageView = (ImageView) childAt;
                Integer num2 = p16.get(i3);
                StringBuilder sb5 = new StringBuilder();
                sb5.append(num2);
                String sb6 = sb5.toString();
                if (num > 9) {
                    sb6 = sb6 + "-" + sb6;
                }
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                obtain.mRequestHeight = q.a(getContext(), f16);
                obtain.mRequestWidth = q.a(getContext(), f17);
                obtain.mFailedDrawable = new ColorDrawable(0);
                obtain.mLoadingDrawable = new ColorDrawable(0);
                com.tencent.mobileqq.vasgift.mvvm.business.anim.c cVar = com.tencent.mobileqq.vasgift.mvvm.business.anim.c.f311706a;
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                URLDrawable fileDrawable = URLDrawable.getFileDrawable(cVar.e(context) + "/" + sb6 + ".png", obtain);
                if (QLog.isDebugVersion()) {
                    Context context2 = getContext();
                    Intrinsics.checkNotNullExpressionValue(context2, "context");
                    QLog.i("QQLiveGiftComboSendView", 1, "load drawable from " + cVar.e(context2) + "/" + sb6 + ".png");
                }
                imageView.setImageDrawable(fileDrawable);
                imageView.setVisibility(0);
                i3++;
                f16 = 18.0f;
                f17 = 10.0f;
            }
        }
        do {
            LinearLayout linearLayout9 = this.numViewContainer;
            Intrinsics.checkNotNull(linearLayout9);
            linearLayout9.addView(new ImageView(getContext()), new LinearLayout.LayoutParams(q.a(getContext(), 10.0f), q.a(getContext(), 18.0f)));
            linearLayout = this.numViewContainer;
            Intrinsics.checkNotNull(linearLayout);
        } while (linearLayout.getChildCount() < p16.size());
        size = p16.size();
        i3 = 0;
        while (i3 < size) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        if (this.notifyStateRecord.getHasNotifyComboOver()) {
            QLog.w("QQLiveGiftComboSendView", 1, "hideCurrentView, already notified");
            return;
        }
        this.notifyStateRecord.b();
        int i3 = this.numOfSendDuration;
        if (i3 > 0) {
            QLog.w("QQLiveGiftComboSendView", 1, "checkAndNotifyComboOver, remain:" + i3 + ", need consume first");
            w();
            postDelayed(new Runnable() { // from class: com.tencent.mobileqq.vasgift.view.d
                @Override // java.lang.Runnable
                public final void run() {
                    QQLiveGiftComboSendView.k(QQLiveGiftComboSendView.this);
                }
            }, this.sendComboOverDelayMilles);
            return;
        }
        QLog.w("QQLiveGiftComboSendView", 1, "checkAndNotifyComboOver, request comboOver, curComboNum:" + this.curComboNum);
        ph2.b bVar = this.comboSendViewListener;
        if (bVar != null) {
            bVar.i();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(QQLiveGiftComboSendView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.w("QQLiveGiftComboSendView", 1, "checkAndNotifyComboOver, request comboOver in runnable, curComboNum:" + this$0.curComboNum);
        ph2.b bVar = this$0.comboSendViewListener;
        if (bVar != null) {
            bVar.i();
        }
    }

    private final void l() {
        if (this.notifyStateRecord.getHasNotifyComboOver()) {
            QLog.e("QQLiveGiftComboSendView", 1, "clickOnce hasNotifyComboOver");
            return;
        }
        if (this.curComboNum == this.maxComboNum) {
            if (this.callBackMaxNum) {
                return;
            }
            this.callBackMaxNum = true;
            ph2.b bVar = this.comboSendViewListener;
            if (bVar != null) {
                bVar.e();
            }
            j();
            QLog.i("QQLiveGiftComboSendView", 1, "clickOnce send_combo: onGetMaxNum numOfSendDuration:" + this.numOfSendDuration + ", curComboNum:" + this.curComboNum);
            return;
        }
        F();
        QLog.i("QQLiveGiftComboSendView", 1, "clickOnce send_combo, numOfSendDuration:" + this.numOfSendDuration + ", curComboNum:" + this.curComboNum);
        r();
        A();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(QQLiveGiftComboSendView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.w("QQLiveGiftComboSendView", 1, "delaySendRunnable, notifySend after " + this$0.sendConsumeDelayMilles);
        this$0.w();
    }

    private final List<Integer> p(int comboNum) {
        ArrayList arrayList = new ArrayList();
        do {
            arrayList.add(0, Integer.valueOf(comboNum % 10));
            comboNum /= 10;
        } while (comboNum > 0);
        return arrayList;
    }

    private final long q(String secondKey, long defaultValue) {
        return QzoneConfig.getInstance().getConfig("qqlive", secondKey, defaultValue);
    }

    private final void r() {
        ph2.b bVar = this.comboSendViewListener;
        if (bVar != null) {
            bVar.s(this.curComboNum);
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.curComboNum == this.maxComboNum) {
            w();
            return;
        }
        if (currentTimeMillis - this.startSendTime > this.sendDelayTimeConfig) {
            this.startSendTime = currentTimeMillis;
            if (this.bugfix) {
                w();
                return;
            } else {
                ThreadManager.b(new Runnable() { // from class: com.tencent.mobileqq.vasgift.view.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        QQLiveGiftComboSendView.s(QQLiveGiftComboSendView.this);
                    }
                }, this.sendDelayTimeConfig);
                return;
            }
        }
        ThreadManager.d(this.delaySendRunnable);
        ThreadManager.b(this.delaySendRunnable, this.sendConsumeDelayMilles);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(QQLiveGiftComboSendView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.w();
    }

    private final void u() {
        PAGFile pAGFile = null;
        if (S == null) {
            com.tencent.mobileqq.vasgift.mvvm.business.anim.c cVar = com.tencent.mobileqq.vasgift.mvvm.business.anim.c.f311706a;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            PAGFile Load = PagViewMonitor.Load(cVar.k(context));
            if (Load != null) {
                Intrinsics.checkNotNullExpressionValue(Load, "Load(QQGiftComboResDownl\u2026.getWavePagName(context))");
                if (Load.width() == 0) {
                    QLog.e("QQLiveGiftComboSendView", 1, "init wavePageFile while width==0");
                } else {
                    Matrix matrix = new Matrix();
                    float a16 = (q.a(getContext(), 108.0f) * 1.0f) / Load.width();
                    matrix.preScale(a16, a16, Load.width() / 2.0f, Load.height() / 2.0f);
                    Load.setMatrix(matrix);
                }
            } else {
                Load = null;
            }
            S = Load;
            QLog.i("QQLiveGiftComboSendView", 1, "init wavePageFile:" + Load);
            Unit unit = Unit.INSTANCE;
        }
        if (T == null) {
            com.tencent.mobileqq.vasgift.mvvm.business.anim.c cVar2 = com.tencent.mobileqq.vasgift.mvvm.business.anim.c.f311706a;
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            PAGFile Load2 = PagViewMonitor.Load(cVar2.g(context2));
            if (Load2 != null) {
                Intrinsics.checkNotNullExpressionValue(Load2, "Load(QQGiftComboResDownl\u2026.getMainPagName(context))");
                if (Load2.width() == 0) {
                    QLog.e("QQLiveGiftComboSendView", 1, "init mainPagFile while width==0");
                } else {
                    Matrix matrix2 = new Matrix();
                    float a17 = (q.a(getContext(), 108.0f) * 1.0f) / Load2.width();
                    matrix2.preScale(a17, a17, q.a(getContext(), 108.0f) / 2.0f, q.a(getContext(), 108.0f) / 2.0f);
                    Load2.setMatrix(matrix2);
                }
                pAGFile = Load2;
            }
            T = pAGFile;
            QLog.i("QQLiveGiftComboSendView", 1, "init mainPagFile:" + pAGFile);
            Unit unit2 = Unit.INSTANCE;
        }
    }

    private final boolean v() {
        if (T != null && S != null) {
            return false;
        }
        return true;
    }

    private final void w() {
        int i3 = this.numOfSendDuration;
        if (i3 > 0) {
            QLog.i("QQLiveGiftComboSendView", 1, "notifySend, request consume, numOfSendDuration:" + i3 + ", curComboNum:" + this.curComboNum);
            ph2.b bVar = this.comboSendViewListener;
            if (bVar != null) {
                bVar.c(this.numOfSendDuration, this.curComboNum, false);
            }
        }
        this.numOfSendDuration = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x() {
        l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y() {
        l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z(View v3) {
        l();
    }

    public final void E() {
        LongClickHandler longClickHandler = this.longClickHandler;
        if (longClickHandler != null) {
            longClickHandler.g();
        }
        this.curComboNum = 0;
        this.numOfSendDuration = 0;
        ObjectAnimator objectAnimator = this.clickScaleAnimation;
        if (objectAnimator != null) {
            objectAnimator.removeAllListeners();
        }
        ObjectAnimator objectAnimator2 = this.clickScaleAnimation;
        if (objectAnimator2 != null) {
            objectAnimator2.cancel();
        }
        this.clickScaleAnimation = null;
    }

    public final void H(int initCombo, int maxCombo) {
        QLog.i("QQLiveGiftComboSendView", 1, "work initCombo:" + initCombo + ", maxCombo:" + maxCombo);
        if (initCombo > maxCombo) {
            QLog.e("QQLiveGiftComboSendView", 1, "initCombo > maxCombo");
            return;
        }
        this.notifyStateRecord.c();
        this.curComboNum = initCombo;
        this.maxComboNum = maxCombo;
        this.numOfSendDuration = -1;
        this.callBackMaxNum = false;
        l();
        if (v()) {
            QLog.e("QQLiveGiftComboSendView", 1, "invalid resource, stop anim and notify comboOver...");
            this.notifyStateRecord.b();
            ph2.b bVar = this.comboSendViewListener;
            if (bVar != null) {
                bVar.j();
            }
            ph2.b bVar2 = this.comboSendViewListener;
            if (bVar2 != null) {
                bVar2.i();
            }
        }
    }

    public final void n(boolean enable) {
        this.enableLongPress = enable;
        if (!enable) {
            LongClickHandler longClickHandler = this.longClickHandler;
            if (longClickHandler != null) {
                longClickHandler.g();
            }
            com.tencent.mobileqq.vasgift.mvvm.business.anim.c cVar = com.tencent.mobileqq.vasgift.mvvm.business.anim.c.f311706a;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            T = PagViewMonitor.Load(cVar.h(context));
        }
    }

    /* renamed from: o, reason: from getter */
    public final int getCurComboNum() {
        return this.curComboNum;
    }

    public final void setListener(@NotNull ph2.b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.comboSendViewListener = listener;
    }

    public final void t(boolean show) {
        int i3;
        if (show) {
            i3 = 0;
        } else {
            i3 = 4;
        }
        setVisibility(i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQLiveGiftComboSendView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.sendDelayTimeConfig = 1000;
        this.sendConsumeDelayMilles = q("QQLIVE_CONSUME_DELAY_MILLES", 500L);
        this.sendComboOverDelayMilles = q("QQLIVE_COMBOOVER_DELAY_MILLES", 500L);
        this.maxComboNum = Integer.MAX_VALUE;
        this.notifyStateRecord = new d();
        this.bugfix = VasNormalToggle.VAS_GIFT_DATA_BUG.isEnable(true);
        LayoutInflater.from(getContext()).inflate(R.layout.h8w, this);
        this.comboWaveView = (PAGView) findViewById(R.id.f6324330);
        this.comboRaiseView = (ImageView) findViewById(R.id.f632332z);
        this.comboMainView = (PAGView) findViewById(R.id.f632132x);
        this.numViewContainer = (LinearLayout) findViewById(R.id.f632232y);
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = 200;
        ToggleProxy toggleProxy = VasToggle.VAS_LIVE_GIFT_TIME_CONFIG;
        if (toggleProxy.isEnable(false)) {
            String stringDataSet = toggleProxy.getStringDataSet("click_delay", "200");
            String stringDataSet2 = toggleProxy.getStringDataSet("request_delay", "1000");
            if (stringDataSet != null) {
                intRef.element = Integer.parseInt(stringDataSet);
            }
            if (stringDataSet2 != null) {
                this.sendDelayTimeConfig = Integer.parseInt(stringDataSet2);
            }
        }
        PAGView pAGView = this.comboMainView;
        if (pAGView != null) {
            pAGView.setOnClickListener(new a(intRef, this));
        }
        LongClickHandler longClickHandler = new LongClickHandler(this.comboMainView);
        longClickHandler.h(new b(), 200);
        this.longClickHandler = longClickHandler;
        u();
        this.delaySendRunnable = new Runnable() { // from class: com.tencent.mobileqq.vasgift.view.c
            @Override // java.lang.Runnable
            public final void run() {
                QQLiveGiftComboSendView.m(QQLiveGiftComboSendView.this);
            }
        };
        this.pagViewListener = new e();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQLiveGiftComboSendView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.sendDelayTimeConfig = 1000;
        this.sendConsumeDelayMilles = q("QQLIVE_CONSUME_DELAY_MILLES", 500L);
        this.sendComboOverDelayMilles = q("QQLIVE_COMBOOVER_DELAY_MILLES", 500L);
        this.maxComboNum = Integer.MAX_VALUE;
        this.notifyStateRecord = new d();
        this.bugfix = VasNormalToggle.VAS_GIFT_DATA_BUG.isEnable(true);
        LayoutInflater.from(getContext()).inflate(R.layout.h8w, this);
        this.comboWaveView = (PAGView) findViewById(R.id.f6324330);
        this.comboRaiseView = (ImageView) findViewById(R.id.f632332z);
        this.comboMainView = (PAGView) findViewById(R.id.f632132x);
        this.numViewContainer = (LinearLayout) findViewById(R.id.f632232y);
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = 200;
        ToggleProxy toggleProxy = VasToggle.VAS_LIVE_GIFT_TIME_CONFIG;
        if (toggleProxy.isEnable(false)) {
            String stringDataSet = toggleProxy.getStringDataSet("click_delay", "200");
            String stringDataSet2 = toggleProxy.getStringDataSet("request_delay", "1000");
            if (stringDataSet != null) {
                intRef.element = Integer.parseInt(stringDataSet);
            }
            if (stringDataSet2 != null) {
                this.sendDelayTimeConfig = Integer.parseInt(stringDataSet2);
            }
        }
        PAGView pAGView = this.comboMainView;
        if (pAGView != null) {
            pAGView.setOnClickListener(new a(intRef, this));
        }
        LongClickHandler longClickHandler = new LongClickHandler(this.comboMainView);
        longClickHandler.h(new b(), 200);
        this.longClickHandler = longClickHandler;
        u();
        this.delaySendRunnable = new Runnable() { // from class: com.tencent.mobileqq.vasgift.view.c
            @Override // java.lang.Runnable
            public final void run() {
                QQLiveGiftComboSendView.m(QQLiveGiftComboSendView.this);
            }
        };
        this.pagViewListener = new e();
    }
}
