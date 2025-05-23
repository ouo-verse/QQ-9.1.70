package com.tencent.mobileqq.managers;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import com.tencent.util.LoadingUtil;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00052\u00020\u0001:\u0004\u000e;\u0013<B\t\b\u0002\u00a2\u0006\u0004\b9\u0010:J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\u0004J\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\f\u001a\u00020\u0004R$\u0010\u0012\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\u0017\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0016R$\u0010\u001f\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010'\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010.\u001a\u00020(8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0016\u00100\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010)R\u0016\u00101\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010)R\u0014\u00104\u001a\u0002028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u00103R\u001c\u00107\u001a\b\u0018\u000105R\u00020\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u00106R\u0016\u00108\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010)\u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/managers/MsgRefreshTipMgr;", "", "", "event", "", "k", "Landroid/os/Bundle;", "extraInfo", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "i", "j", "e", "<set-?>", "a", "I", tl.h.F, "()I", "state", "b", "g", "setLastState", "(I)V", "lastState", "Lcom/tencent/mobileqq/managers/MsgRefreshTipMgr$MsgRefreshTipView;", "c", "Lcom/tencent/mobileqq/managers/MsgRefreshTipMgr$MsgRefreshTipView;", "getRefreshTipView", "()Lcom/tencent/mobileqq/managers/MsgRefreshTipMgr$MsgRefreshTipView;", "o", "(Lcom/tencent/mobileqq/managers/MsgRefreshTipMgr$MsgRefreshTipView;)V", "refreshTipView", "Lcom/tencent/mobileqq/managers/MsgRefreshTipMgr$b;", "d", "Lcom/tencent/mobileqq/managers/MsgRefreshTipMgr$b;", "getOnMsgRefreshChangedListener", "()Lcom/tencent/mobileqq/managers/MsgRefreshTipMgr$b;", DomainData.DOMAIN_NAME, "(Lcom/tencent/mobileqq/managers/MsgRefreshTipMgr$b;)V", "onMsgRefreshChangedListener", "", "Z", "getSwitch", "()Z", "p", "(Z)V", TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, "f", "isDelayDone", "hasPostDelayJob", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "delayRunnable", "Lcom/tencent/mobileqq/managers/MsgRefreshTipMgr$TimeOutRunnable;", "Lcom/tencent/mobileqq/managers/MsgRefreshTipMgr$TimeOutRunnable;", "timeoutRunnable", "firstReceivedConn", "<init>", "()V", "MsgRefreshTipView", "TimeOutRunnable", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class MsgRefreshTipMgr {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    private static final Integer[][] f243638l;

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    private static final Lazy<MsgRefreshTipMgr> f243639m;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int state;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int lastState;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MsgRefreshTipView refreshTipView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b onMsgRefreshChangedListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean switch;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isDelayDone;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean hasPostDelayJob;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Runnable delayRunnable;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TimeOutRunnable timeoutRunnable;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private boolean firstReceivedConn;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u00a2\u0006\u0004\b\u001d\u0010\u001eB\u001b\b\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001f\u00a2\u0006\u0004\b\u001d\u0010!B#\b\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\u0006\u0010#\u001a\u00020\"\u00a2\u0006\u0004\b\u001d\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0014J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0002R\u0018\u0010\n\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\tR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\rR\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/managers/MsgRefreshTipMgr$MsgRefreshTipView;", "Landroid/widget/FrameLayout;", "", "d", "a", NodeProps.ON_ATTACHED_TO_WINDOW, "c", "b", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Drawable;", "drawable", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "leftTv", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "loadingIv", tl.h.F, "rightTv", "", "i", "J", "startConnTime", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "startRecvTime", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class MsgRefreshTipView extends FrameLayout {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Drawable drawable;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private TextView leftTv;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private ImageView loadingIv;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private TextView rightTv;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private long startConnTime;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        private long startRecvTime;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public MsgRefreshTipView(@NotNull Context context) {
            this(context, null);
            Intrinsics.checkNotNullParameter(context, "context");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }

        private final void a() {
            ImageView imageView = this.loadingIv;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
        }

        private final void d() {
            if (this.drawable == null) {
                ImageView imageView = this.loadingIv;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    return;
                }
                return;
            }
            ImageView imageView2 = this.loadingIv;
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
            ImageView imageView3 = this.loadingIv;
            if (imageView3 != null) {
                imageView3.setImageDrawable(this.drawable);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x0044, code lost:
        
            if (r0.equals("3064") != false) goto L29;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x005b, code lost:
        
            r2 = 3;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x004e, code lost:
        
            if (r0.equals("2971") == false) goto L34;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0058, code lost:
        
            if (r0.equals("2921") == false) goto L34;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
                return;
            }
            int i3 = 1;
            if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("navigation_bar_loading_9.0_887617015", true) && (QQTheme.isDefaultTheme() || QQTheme.isNowThemeDefaultNight())) {
                i3 = 4;
            } else {
                String currentThemeId = QQTheme.getCurrentThemeId();
                if (currentThemeId != null) {
                    switch (currentThemeId.hashCode()) {
                        case 56601:
                            if (currentThemeId.equals("999")) {
                                i3 = 2;
                                break;
                            }
                            break;
                        case 1545926:
                            break;
                        case 1546081:
                            break;
                        case 1567195:
                            break;
                    }
                }
            }
            this.drawable = LoadingUtil.getLoadingDrawable(getContext(), i3);
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0050, code lost:
        
            if (r2 != 4) goto L50;
         */
        /* JADX WARN: Removed duplicated region for block: B:18:0x00ed  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0155  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x015c  */
        /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:28:0x011a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void c() {
            int g16;
            TextView textView;
            TextView textView2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
                return;
            }
            Companion companion = MsgRefreshTipMgr.INSTANCE;
            QLog.d("MsgRefreshTipMgr", 1, "showByState state=" + companion.a().h());
            int h16 = companion.a().h();
            if (h16 != 0) {
                if (h16 != 1) {
                    if (h16 != 2) {
                        if (h16 == 3) {
                            this.startRecvTime = System.currentTimeMillis();
                            TextView textView3 = this.leftTv;
                            if (textView3 != null) {
                                textView3.setText("(");
                            }
                            TextView textView4 = this.rightTv;
                            if (textView4 != null) {
                                textView4.setText(getContext().getString(R.string.f168422fl) + ")");
                            }
                            d();
                        }
                    } else {
                        this.startConnTime = System.currentTimeMillis();
                        TextView textView5 = this.leftTv;
                        if (textView5 != null) {
                            textView5.setText("(");
                        }
                        TextView textView6 = this.rightTv;
                        if (textView6 != null) {
                            textView6.setText(getContext().getString(R.string.f168402fj) + ")");
                        }
                        d();
                    }
                } else {
                    TextView textView7 = this.leftTv;
                    if (textView7 != null) {
                        textView7.setText(R.string.f168412fk);
                    }
                    TextView textView8 = this.rightTv;
                    if (textView8 != null) {
                        textView8.setText("");
                    }
                    a();
                }
                g16 = companion.a().g();
                if (g16 == 2) {
                    if (g16 == 3) {
                        ReportController.o(null, "dc00898", "", "", "0X800C0B1", "0X800C0B1", 0, 0, String.valueOf(System.currentTimeMillis() - this.startRecvTime), "", "", "");
                    }
                } else {
                    ReportController.o(null, "dc00898", "", "", "0X800C0B0", "0X800C0B0", 0, 0, String.valueOf(System.currentTimeMillis() - this.startConnTime), "", "", "");
                }
                int color = getContext().getColor(R.color.qui_common_text_nav_primary);
                textView = this.leftTv;
                if (textView != null) {
                    textView.setTextColor(color);
                }
                textView2 = this.rightTv;
                if (textView2 == null) {
                    textView2.setTextColor(color);
                    return;
                }
                return;
            }
            TextView textView9 = this.leftTv;
            if (textView9 != null) {
                textView9.setText("");
            }
            TextView textView10 = this.rightTv;
            if (textView10 != null) {
                textView10.setText("");
            }
            a();
            g16 = companion.a().g();
            if (g16 == 2) {
            }
            int color2 = getContext().getColor(R.color.qui_common_text_nav_primary);
            textView = this.leftTv;
            if (textView != null) {
            }
            textView2 = this.rightTv;
            if (textView2 == null) {
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onAttachedToWindow() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            super.onAttachedToWindow();
            this.leftTv = (TextView) findViewById(R.id.f72193q7);
            this.loadingIv = (ImageView) findViewById(R.id.f72203q8);
            this.rightTv = (TextView) findViewById(R.id.f72213q9);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public MsgRefreshTipView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
            this(context, attributeSet, 0);
            Intrinsics.checkNotNullParameter(context, "context");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MsgRefreshTipView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
            super(context, attributeSet, i3);
            Intrinsics.checkNotNullParameter(context, "context");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                LayoutInflater.from(context).inflate(R.layout.e4n, this);
            } else {
                iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/managers/MsgRefreshTipMgr$TimeOutRunnable;", "Ljava/lang/Runnable;", "", TencentLocation.RUN_MODE, "", "d", "I", "state", "<init>", "(Lcom/tencent/mobileqq/managers/MsgRefreshTipMgr;I)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public final class TimeOutRunnable implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int state;

        public TimeOutRunnable(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MsgRefreshTipMgr.this, i3);
            } else {
                this.state = i3;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (this.state == 2) {
                str = "0X800C0B2";
            } else {
                str = "0X800C0B3";
            }
            String str2 = str;
            ReportController.o(null, "dc00898", "", "", str2, str2, 0, 0, "", "", "", "");
            MsgRefreshTipMgr.this.k(6);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b#\u0010\bR!\u0010\t\u001a\u00020\u00028FX\u0087\u0084\u0002\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u000fR\u0014\u0010\u0015\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u000fR\u0014\u0010\u0016\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u000fR\u0014\u0010\u0017\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u000fR\u0014\u0010\u0019\u001a\u00020\u00188\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\fR\u0014\u0010\u001c\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u000fR\u0014\u0010\u001d\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u000fR\u0014\u0010\u001e\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u000fR\u0014\u0010\u001f\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u000fR\u0014\u0010 \u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b \u0010\u000fR\u0014\u0010!\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b!\u0010\u000fR\u0014\u0010\"\u001a\u00020\u00188\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001a\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/managers/MsgRefreshTipMgr$a;", "", "Lcom/tencent/mobileqq/managers/MsgRefreshTipMgr;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/managers/MsgRefreshTipMgr;", "getInstance$annotations", "()V", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "", "DELAY_SHOW_TIME", "J", "", "EVENT_NETWORK_RECOVER", "I", "EVENT_NO_NETWORK", "EVENT_PULL_REFRESH", "EVENT_PULL_REFRESH_END", "EVENT_RECEIVE_END", "EVENT_RECEIVE_FAIL", "EVENT_RECEIVING", "EVENT_SEND_REQ", "EVENT_TIMEOUT", "", "KEY_IS_NEED_DELAY", "Ljava/lang/String;", "SHOW_TIMEOUT", "STATE_CONNECTING", "STATE_INIT", "STATE_NONE", "STATE_NO_NETWORK", "STATE_PULL_REFRESHING", "STATE_RECEIVING", "TAG", "<init>", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.managers.MsgRefreshTipMgr$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final MsgRefreshTipMgr a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (MsgRefreshTipMgr) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return (MsgRefreshTipMgr) MsgRefreshTipMgr.f243639m.getValue();
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
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/managers/MsgRefreshTipMgr$b;", "", "", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public interface b {
        void a();
    }

    static {
        Lazy<MsgRefreshTipMgr> lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58943);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
            return;
        }
        INSTANCE = new Companion(null);
        f243638l = new Integer[][]{new Integer[]{1, -1, 2, 3, -1, -1, -1, 4, -1}, new Integer[]{1, 0, -1, 3, 0, 0, 0, -1, -1}, new Integer[]{1, -1, -1, 3, 0, 0, 0, 4, -1}, new Integer[]{1, -1, -1, -1, 0, 0, 0, 4, -1}, new Integer[]{1, -1, -1, -1, -1, -1, -1, -1, 0}};
        lazy = LazyKt__LazyJVMKt.lazy(MsgRefreshTipMgr$Companion$instance$2.INSTANCE);
        f243639m = lazy;
    }

    public /* synthetic */ MsgRefreshTipMgr(DefaultConstructorMarker defaultConstructorMarker) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 17)) {
            return;
        }
        iPatchRedirector.redirect((short) 17, (Object) this, (Object) defaultConstructorMarker);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(MsgRefreshTipMgr this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("MsgRefreshTipMgr", 1, "delayRunnable run");
        this$0.isDelayDone = true;
        this$0.q();
    }

    @NotNull
    public static final MsgRefreshTipMgr f() {
        return INSTANCE.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(MsgRefreshTipMgr this$0, int i3) {
        b bVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("MsgRefreshTipMgr", 1, "sendEvent state=" + this$0.state + " event=" + i3);
        if (i3 != 0) {
            if (i3 != 2 && i3 != 3) {
                if (i3 == 4 || i3 == 5 || i3 == 6) {
                    this$0.firstReceivedConn = true;
                }
            } else if (this$0.firstReceivedConn) {
                return;
            }
        } else {
            this$0.firstReceivedConn = false;
        }
        int intValue = f243638l[this$0.state][i3].intValue();
        if (intValue == -1) {
            return;
        }
        this$0.state = intValue;
        QLog.d("MsgRefreshTipMgr", 1, "sendEvent next state=" + intValue);
        int i16 = this$0.state;
        if (i16 != 2 && i16 != 3) {
            ThreadManager.getUIHandler().removeCallbacks(this$0.delayRunnable);
            this$0.hasPostDelayJob = false;
            this$0.isDelayDone = true;
            this$0.q();
        } else {
            if (!this$0.hasPostDelayJob) {
                this$0.hasPostDelayJob = true;
                this$0.isDelayDone = false;
                ThreadManager.getUIHandler().postDelayed(this$0.delayRunnable, 800L);
            }
            if (this$0.isDelayDone) {
                this$0.q();
            }
        }
        int i17 = this$0.state;
        if (i17 != 2 && i17 != 3) {
            ThreadManager.getUIHandler().removeCallbacks(this$0.timeoutRunnable);
        } else {
            ThreadManager.getUIHandler().removeCallbacks(this$0.timeoutRunnable);
            this$0.timeoutRunnable = new TimeOutRunnable(this$0.state);
            ThreadManager.getUIHandler().postDelayed(this$0.timeoutRunnable, 15000L);
        }
        if ((i3 == 4 || i3 == 5 || i3 == 6) && (bVar = this$0.onMsgRefreshChangedListener) != null) {
            bVar.a();
        }
    }

    public final void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        } else {
            if (!this.switch) {
                return;
            }
            QLog.d("MsgRefreshTipMgr", 1, "destroy");
            j();
            this.refreshTipView = null;
            this.firstReceivedConn = false;
        }
    }

    public final int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.lastState;
    }

    public final int h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.state;
    }

    public final void i() {
        MsgRefreshTipView msgRefreshTipView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else if (this.switch && (msgRefreshTipView = this.refreshTipView) != null) {
            msgRefreshTipView.b();
        }
    }

    public final void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        if (!this.switch) {
            return;
        }
        QLog.d("MsgRefreshTipMgr", 1, "onBeforeAccountChanged");
        this.lastState = -1;
        this.state = 0;
        this.onMsgRefreshChangedListener = null;
        this.hasPostDelayJob = true;
        this.isDelayDone = false;
        this.firstReceivedConn = false;
        ThreadManager.getUIHandler().postDelayed(this.delayRunnable, 100L);
        ThreadManager.getUIHandler().removeCallbacks(this.timeoutRunnable);
    }

    public final void k(int event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, event);
        } else {
            l(event, new Bundle());
        }
    }

    public final void l(final int event, @NotNull Bundle extraInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, event, (Object) extraInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        if (!this.switch) {
            return;
        }
        QLog.d("MsgRefreshTipMgr", 1, "sendEvent start event=" + event);
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.managers.f
            @Override // java.lang.Runnable
            public final void run() {
                MsgRefreshTipMgr.m(MsgRefreshTipMgr.this, event);
            }
        });
    }

    public final void n(@Nullable b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) bVar);
        } else {
            this.onMsgRefreshChangedListener = bVar;
        }
    }

    public final void o(@Nullable MsgRefreshTipView msgRefreshTipView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) msgRefreshTipView);
        } else {
            this.refreshTipView = msgRefreshTipView;
        }
    }

    public final void p(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
        } else {
            this.switch = z16;
        }
    }

    public final void q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        if (!this.switch || this.state == this.lastState) {
            return;
        }
        MsgRefreshTipView msgRefreshTipView = this.refreshTipView;
        if (msgRefreshTipView != null) {
            msgRefreshTipView.c();
        }
        this.lastState = this.state;
    }

    MsgRefreshTipMgr() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.lastState = -1;
            this.delayRunnable = new Runnable() { // from class: com.tencent.mobileqq.managers.e
                @Override // java.lang.Runnable
                public final void run() {
                    MsgRefreshTipMgr.d(MsgRefreshTipMgr.this);
                }
            };
        }
    }
}
