package com.tencent.mobileqq.zplan.aio.badge;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.format.DateUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.ApngDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.zplan.aio.badge.ZPlanBrandAnimHelper;
import com.tencent.mobileqq.zplan.aio.badge.b;
import com.tencent.mobileqq.zplan.utils.v;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.TokenResUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;

@Metadata(d1 = {"\u0000m\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0006*\u0001B\u0018\u0000 \u000e2\u00020\u0001:\u0001\u001eB\u0019\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u001d\u0012\u0006\u0010(\u001a\u00020#\u00a2\u0006\u0004\bE\u0010FJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010\n\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010\u000b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\bH\u0002J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\bH\u0002J\u0012\u0010\u0014\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002J\u0012\u0010\u0015\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010\u0016\u001a\u00020\u0002H\u0002J\u001a\u0010\u001a\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018J\u0006\u0010\u001b\u001a\u00020\u0002J\u0006\u0010\u001c\u001a\u00020\u0002R\u0019\u0010\"\u001a\u0004\u0018\u00010\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010(\u001a\u00020#8\u0006\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00105\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u0010.R\u0016\u00108\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0014\u0010<\u001a\u0002098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010>\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010=R\u0018\u0010A\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010@R\u0014\u0010D\u001a\u00020B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010C\u00a8\u0006G"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/badge/ZPlanBrandAnimHelper;", "", "", "t", "w", "v", "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;", "redDotInfo", "", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "u", ReportConstant.COSTREPORT_PREFIX, "", "l", "url", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/image/URLDrawable;", "drawable", DomainData.DOMAIN_NAME, "o", HippyTKDListViewAdapter.X, "info", "Lcom/tencent/mobileqq/tianshu/ui/RedTouch;", "redTouch", "k", "i", "p", "Landroid/widget/ImageView;", "a", "Landroid/widget/ImageView;", "getAnimImageView", "()Landroid/widget/ImageView;", "animImageView", "Lcom/tencent/mobileqq/zplan/aio/badge/b;", "b", "Lcom/tencent/mobileqq/zplan/aio/badge/b;", "getZplanBadgeUI", "()Lcom/tencent/mobileqq/zplan/aio/badge/b;", "zplanBadgeUI", "c", "Z", "isActive", "", "d", "I", "totalPlayCount", "", "e", "J", "repeatPlayInterval", "f", "currentPlayCount", "g", "Ljava/lang/String;", "playUrl", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", tl.h.F, "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "entity", "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;", "redDotAppInfo", "Lcom/tencent/image/ApngDrawable$OnPlayRepeatListener;", "Lcom/tencent/image/ApngDrawable$OnPlayRepeatListener;", "apngRepeatListener", "com/tencent/mobileqq/zplan/aio/badge/ZPlanBrandAnimHelper$playAnimRunnable$1", "Lcom/tencent/mobileqq/zplan/aio/badge/ZPlanBrandAnimHelper$playAnimRunnable$1;", "playAnimRunnable", "<init>", "(Landroid/widget/ImageView;Lcom/tencent/mobileqq/zplan/aio/badge/b;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanBrandAnimHelper {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ImageView animImageView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.mobileqq.zplan.aio.badge.b zplanBadgeUI;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean isActive;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int totalPlayCount;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long repeatPlayInterval;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int currentPlayCount;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private String playUrl;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final MMKVOptionEntity entity;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private BusinessInfoCheckUpdate.AppInfo redDotAppInfo;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private ApngDrawable.OnPlayRepeatListener apngRepeatListener;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final ZPlanBrandAnimHelper$playAnimRunnable$1 playAnimRunnable;

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u000b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\nH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zplan/aio/badge/ZPlanBrandAnimHelper$b", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "Lcom/tencent/image/URLDrawable;", "p0", "", "onLoadSuccessed", "", "p1", "onLoadFialed", "onLoadCanceled", "", "onLoadProgressed", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements URLDrawable.URLDrawableListener {

        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/zplan/aio/badge/ZPlanBrandAnimHelper$b$a", "Lcom/tencent/image/ApngDrawable$OnPlayRepeatListener;", "", "count", "", HippyQQPagView.EventName.ON_PLAY_REPEAT, "", "d", "Z", "getHandledRepeat", "()Z", "setHandledRepeat", "(Z)V", "handledRepeat", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes35.dex */
        public static final class a implements ApngDrawable.OnPlayRepeatListener {

            /* renamed from: d, reason: collision with root package name and from kotlin metadata */
            private boolean handledRepeat;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ ApngDrawable f330930e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ ZPlanBrandAnimHelper f330931f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ URLDrawable f330932h;

            a(ApngDrawable apngDrawable, ZPlanBrandAnimHelper zPlanBrandAnimHelper, URLDrawable uRLDrawable) {
                this.f330930e = apngDrawable;
                this.f330931f = zPlanBrandAnimHelper;
                this.f330932h = uRLDrawable;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void b(ZPlanBrandAnimHelper this$0, URLDrawable uRLDrawable) {
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                this$0.n(uRLDrawable);
            }

            @Override // com.tencent.image.ApngDrawable.OnPlayRepeatListener
            public void onPlayRepeat(int count) {
                QLog.d("ZplanBrandAnimHelper", 1, "brand, playAnim, repeat, listener:" + hashCode() + ", repeatCount:" + count + ", handled:" + this.handledRepeat);
                if (this.handledRepeat) {
                    return;
                }
                this.handledRepeat = true;
                Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                final ZPlanBrandAnimHelper zPlanBrandAnimHelper = this.f330931f;
                final URLDrawable uRLDrawable = this.f330932h;
                uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aio.badge.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        ZPlanBrandAnimHelper.b.a.b(ZPlanBrandAnimHelper.this, uRLDrawable);
                    }
                });
                try {
                    this.f330930e.removeOnPlayRepeatListener(this);
                } catch (Throwable th5) {
                    QLog.e("ZplanBrandAnimHelper", 1, "remove listener err.", th5);
                }
            }
        }

        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(ZPlanBrandAnimHelper this$0, URLDrawable uRLDrawable) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.o(uRLDrawable);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(ZPlanBrandAnimHelper this$0, URLDrawable uRLDrawable) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.o(uRLDrawable);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(ZPlanBrandAnimHelper this$0, URLDrawable uRLDrawable) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.o(uRLDrawable);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(final URLDrawable p06) {
            QLog.i("ZplanBrandAnimHelper", 1, "brand, playAnim, onLoadCancel");
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final ZPlanBrandAnimHelper zPlanBrandAnimHelper = ZPlanBrandAnimHelper.this;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aio.badge.f
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanBrandAnimHelper.b.d(ZPlanBrandAnimHelper.this, p06);
                }
            });
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(final URLDrawable p06, Throwable p16) {
            QLog.i("ZplanBrandAnimHelper", 1, "brand, playAnim, onLoadFialed", p16);
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final ZPlanBrandAnimHelper zPlanBrandAnimHelper = ZPlanBrandAnimHelper.this;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aio.badge.e
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanBrandAnimHelper.b.e(ZPlanBrandAnimHelper.this, p06);
                }
            });
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(final URLDrawable p06) {
            QLog.i("ZplanBrandAnimHelper", 1, "brand, playAnim, onLoadSuccessed: " + (p06 != null ? Integer.valueOf(p06.hashCode()) : null));
            Drawable currDrawable = p06 != null ? p06.getCurrDrawable() : null;
            ApngDrawable apngDrawable = currDrawable instanceof ApngDrawable ? (ApngDrawable) currDrawable : null;
            if (apngDrawable != null) {
                ZPlanBrandAnimHelper zPlanBrandAnimHelper = ZPlanBrandAnimHelper.this;
                boolean z16 = (apngDrawable.getConstantState() == null || apngDrawable.getImage() == null) ? false : true;
                a aVar = new a(apngDrawable, zPlanBrandAnimHelper, p06);
                QLog.i("ZplanBrandAnimHelper", 1, "brand, playAnim, setListener: " + aVar.hashCode() + ", apng:" + apngDrawable.hashCode() + ", success:" + z16);
                if (z16 && QLog.isColorLevel()) {
                    Integer valueOf = p06 != null ? Integer.valueOf(p06.getIntrinsicWidth()) : null;
                    Integer valueOf2 = p06 != null ? Integer.valueOf(p06.getIntrinsicHeight()) : null;
                    QLog.d("ZplanBrandAnimHelper", 1, "apng info: " + valueOf + ", " + valueOf2 + ", " + apngDrawable.getImage().width + ", " + apngDrawable.getImage().height);
                }
                zPlanBrandAnimHelper.apngRepeatListener = aVar;
                apngDrawable.setOnPlayRepeatListener(aVar);
                return;
            }
            final ZPlanBrandAnimHelper zPlanBrandAnimHelper2 = ZPlanBrandAnimHelper.this;
            QLog.i("ZplanBrandAnimHelper", 1, "drawable not apng");
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zplan.aio.badge.g
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanBrandAnimHelper.b.f(ZPlanBrandAnimHelper.this, p06);
                }
            });
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable p06, int p16) {
        }
    }

    /* JADX WARN: Type inference failed for: r2v6, types: [com.tencent.mobileqq.zplan.aio.badge.ZPlanBrandAnimHelper$playAnimRunnable$1] */
    public ZPlanBrandAnimHelper(ImageView imageView, com.tencent.mobileqq.zplan.aio.badge.b zplanBadgeUI) {
        Intrinsics.checkNotNullParameter(zplanBadgeUI, "zplanBadgeUI");
        this.animImageView = imageView;
        this.zplanBadgeUI = zplanBadgeUI;
        this.totalPlayCount = 3;
        this.repeatPlayInterval = 20L;
        this.playUrl = "";
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_VAS)");
        this.entity = from;
        this.playAnimRunnable = new Runnable() { // from class: com.tencent.mobileqq.zplan.aio.badge.ZPlanBrandAnimHelper$playAnimRunnable$1
            @Override // java.lang.Runnable
            public void run() {
                boolean z16;
                int i3;
                int i16;
                boolean z17;
                String str;
                z16 = ZPlanBrandAnimHelper.this.isActive;
                i3 = ZPlanBrandAnimHelper.this.currentPlayCount;
                i16 = ZPlanBrandAnimHelper.this.totalPlayCount;
                QLog.d("ZplanBrandAnimHelper", 1, "brand, playAnimRunnable, active:" + z16 + ", curCount:" + i3 + ", totalCount:" + i16);
                z17 = ZPlanBrandAnimHelper.this.isActive;
                if (z17) {
                    ZPlanBrandAnimHelper zPlanBrandAnimHelper = ZPlanBrandAnimHelper.this;
                    str = zPlanBrandAnimHelper.playUrl;
                    zPlanBrandAnimHelper.r(str);
                }
            }
        };
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x001c, code lost:
    
        if (r1.equals("3064") == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0033, code lost:
    
        r3 = com.tencent.mobileqq.zplan.utils.v.l(com.tencent.mobileqq.zplan.utils.v.f335848a, r11.red_display_info, 18, null, 4, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0026, code lost:
    
        if (r1.equals("2971") == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0030, code lost:
    
        if (r1.equals("2921") == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0048, code lost:
    
        if (r1.equals("2920") == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0055, code lost:
    
        r3 = com.tencent.mobileqq.zplan.utils.v.l(com.tencent.mobileqq.zplan.utils.v.f335848a, r11.red_display_info, 16, null, 4, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0052, code lost:
    
        if (r1.equals("1103") == false) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String j(BusinessInfoCheckUpdate.AppInfo redDotInfo) {
        String str;
        boolean z16;
        if (redDotInfo == null) {
            return "";
        }
        String currentThemeId = ThemeUtil.getCurrentThemeId();
        if (currentThemeId != null) {
            switch (currentThemeId.hashCode()) {
                case 1508387:
                    break;
                case 1545925:
                    break;
                case 1545926:
                    break;
                case 1546081:
                    break;
                case 1567195:
                    break;
            }
            z16 = true;
            QLog.d("ZplanBrandAnimHelper", 1, "brand, getIconUrl, curTheme:" + currentThemeId + ", specialUrl:" + str);
            if (str != null && str.length() != 0) {
                z16 = false;
            }
            if (z16) {
                return str;
            }
            PBStringField pBStringField = redDotInfo.icon_url;
            String str2 = pBStringField != null ? pBStringField.get() : null;
            return str2 == null ? "" : str2;
        }
        str = null;
        z16 = true;
        QLog.d("ZplanBrandAnimHelper", 1, "brand, getIconUrl, curTheme:" + currentThemeId + ", specialUrl:" + str);
        if (str != null) {
            z16 = false;
        }
        if (z16) {
        }
    }

    private final boolean l() {
        if (s03.a.f433066a.a()) {
            return false;
        }
        d dVar = d.f330937a;
        String b16 = dVar.b();
        String c16 = dVar.c();
        int a16 = q03.i.f428160a.e().a();
        if (!DateUtils.isToday(this.entity.decodeLong(c16, 0L))) {
            QLog.i("ZplanBrandAnimHelper", 1, "isFrequencyLimited not today");
            this.entity.encodeLong(c16, System.currentTimeMillis());
            this.entity.encodeInt(b16, 0).commitAsync();
            return false;
        }
        int decodeInt = this.entity.decodeInt(b16, 0);
        QLog.i("ZplanBrandAnimHelper", 1, "isFrequencyLimited curCount:" + decodeInt + ", limitCount:" + a16);
        return decodeInt >= a16 - 1;
    }

    private final void m(BusinessInfoCheckUpdate.AppInfo redDotInfo) {
        String j3 = j(redDotInfo);
        boolean z16 = false;
        if (j3 == null || j3.length() == 0) {
            QLog.e("ZplanBrandAnimHelper", 1, "brand, loadAnim, url is empty");
            return;
        }
        if (l()) {
            QLog.i("ZplanBrandAnimHelper", 1, "FrequencyLimited");
            ImageView imageView = this.animImageView;
            if (imageView != null && imageView.getVisibility() == 0) {
                z16 = true;
            }
            if (z16) {
                return;
            }
            x();
            return;
        }
        w();
        u(redDotInfo);
        r(j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(URLDrawable drawable) {
        QLog.i("ZplanBrandAnimHelper", 1, "brand, onApngPlayRepeat, active:" + this.isActive + ", curCount:" + this.currentPlayCount + ", totalCount:" + this.totalPlayCount);
        if (this.isActive) {
            ImageView imageView = this.animImageView;
            boolean z16 = false;
            if (imageView != null && imageView.getVisibility() == 0) {
                z16 = true;
            }
            if (!z16) {
                QLog.i("ZplanBrandAnimHelper", 1, "onApngPlayRepeat inVisible, ignore");
                return;
            }
            ImageView imageView2 = this.animImageView;
            if (!Intrinsics.areEqual(drawable, imageView2 != null ? imageView2.getDrawable() : null)) {
                QLog.i("ZplanBrandAnimHelper", 1, "onApngPlayRepeat, drawable change, ignore");
                return;
            }
            o(drawable);
            if (this.currentPlayCount >= this.totalPlayCount || l()) {
                return;
            }
            ThreadManagerV2.getUIHandlerV2().postDelayed(this.playAnimRunnable, this.repeatPlayInterval);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(URLDrawable drawable) {
        ImageView imageView = this.animImageView;
        if (!Intrinsics.areEqual(drawable, imageView != null ? imageView.getDrawable() : null)) {
            QLog.i("ZplanBrandAnimHelper", 1, "onPlayOnce drawable change, ignore");
            return;
        }
        ImageView imageView2 = this.animImageView;
        boolean z16 = false;
        if (imageView2 != null && imageView2.getVisibility() == 0) {
            z16 = true;
        }
        if (!z16) {
            QLog.i("ZplanBrandAnimHelper", 1, "onPlayOnce inVisible, ignore");
        } else {
            this.currentPlayCount++;
            x();
        }
    }

    private final void q(String url) {
        ImageView imageView;
        Context context;
        if (QLog.isColorLevel()) {
            QLog.d("ZplanBrandAnimHelper", 1, "brand, playAnim, active:" + this.isActive + ", url:" + url + ",");
        }
        b.a.a(this.zplanBadgeUI, "brand-play", 4, 4, null, 0, null, 40, null);
        this.playUrl = url;
        ApngOptions apngOptions = new ApngOptions();
        apngOptions.setLoop(1);
        apngOptions.setRequestWidth(com.tencent.sqshow.zootopia.utils.i.b(24));
        apngOptions.setRequestHeight(com.tencent.sqshow.zootopia.utils.i.b(24));
        apngOptions.setAutoScale(false);
        ImageView imageView2 = this.animImageView;
        apngOptions.setLoadingDrawable((imageView2 == null || (context = imageView2.getContext()) == null) ? null : context.getDrawable(TokenResUtils.getTokenRes(R.drawable.lvg, R.drawable.qui_super_qq_show_icon_navigation_01_selector)));
        apngOptions.setLoadListener(new b());
        URLDrawable apngURLDrawable = ((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngURLDrawable("ZplanBrandAnimHelper", url, apngOptions);
        if (apngURLDrawable == null || (imageView = this.animImageView) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = layoutParams instanceof RelativeLayout.LayoutParams ? (RelativeLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 != null) {
            layoutParams2.topMargin = 0;
            layoutParams2.addRule(15);
            layoutParams2.width = com.tencent.sqshow.zootopia.utils.i.b(36);
            layoutParams2.height = com.tencent.sqshow.zootopia.utils.i.b(24);
        }
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setPadding(com.tencent.sqshow.zootopia.utils.i.b(1), 0, 0, 0);
        imageView.requestLayout();
        imageView.setImageDrawable(apngURLDrawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(String url) {
        if (QLog.isColorLevel()) {
            QLog.d("ZplanBrandAnimHelper", 1, "brand, playAnimWithCount, active:" + this.isActive + ", url:" + url + ",");
        }
        s();
        q(url);
    }

    private final void s() {
        String b16 = d.f330937a.b();
        int decodeInt = this.entity.decodeInt(b16, 0) + 1;
        this.entity.encodeInt(b16, decodeInt).commitAsync();
        QLog.i("ZplanBrandAnimHelper", 1, "recordShowCount, " + decodeInt);
    }

    private final void t() {
        String j3 = j(this.redDotAppInfo);
        boolean z16 = false;
        if (j3 == null || j3.length() == 0) {
            QLog.d("ZplanBrandAnimHelper", 1, "brand, refreshDrawableByTheme, url is empty");
            return;
        }
        this.playUrl = j3;
        if (this.isActive) {
            ImageView imageView = this.animImageView;
            if (imageView != null && imageView.getVisibility() == 0) {
                z16 = true;
            }
            if (z16) {
                q(this.playUrl);
            }
        }
    }

    private final void u(BusinessInfoCheckUpdate.AppInfo redDotInfo) {
        v vVar = v.f335848a;
        this.totalPlayCount = vVar.i(redDotInfo != null ? redDotInfo.red_display_info : null, 22, 3);
        long j3 = vVar.j(redDotInfo != null ? redDotInfo.red_display_info : null, 20, 20L) * 1000;
        this.repeatPlayInterval = j3;
        if (this.totalPlayCount <= 0) {
            this.totalPlayCount = 3;
        }
        if (j3 <= 0) {
            this.repeatPlayInterval = 20000L;
        }
        QLog.d("ZplanBrandAnimHelper", 1, "brand, refreshPlayControlParams: " + this.totalPlayCount + ", " + this.repeatPlayInterval);
    }

    private final void v() {
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.playAnimRunnable);
    }

    private final void x() {
        RedTouch a16 = this.zplanBadgeUI.a();
        if (a16 != null) {
            a16.parseRedTouch(this.redDotAppInfo);
        }
        b.a.a(this.zplanBadgeUI, "brand-play-once", 0, 0, null, 8, null, 40, null);
    }

    public final void i() {
        QLog.i("ZplanBrandAnimHelper", 1, "brand, clear, active:" + this.isActive);
        this.isActive = false;
        this.redDotAppInfo = null;
        w();
    }

    public final void k(BusinessInfoCheckUpdate.AppInfo info, RedTouch redTouch) {
        boolean a16 = i.INSTANCE.a(this.redDotAppInfo, info);
        boolean z16 = this.isActive;
        int i3 = this.currentPlayCount;
        int i16 = this.totalPlayCount;
        boolean z17 = info == null;
        ImageView imageView = this.animImageView;
        QLog.i("ZplanBrandAnimHelper", 1, "brand, handle, active:" + z16 + ", curCount: " + i3 + ", totalCount: " + i16 + ", info:" + z17 + ", sameModifyTs:" + a16 + ", visibility:" + (imageView != null ? Integer.valueOf(imageView.getVisibility()) : null));
        if (a16) {
            if (redTouch != null) {
                redTouch.parseRedTouch(info);
            }
        } else {
            if (info == null || this.animImageView == null) {
                return;
            }
            this.redDotAppInfo = info;
            this.isActive = true;
            this.zplanBadgeUI.c(info);
            m(info);
        }
    }

    public final void p() {
        boolean z16 = this.isActive;
        ImageView imageView = this.animImageView;
        QLog.i("ZplanBrandAnimHelper", 1, "brand, onPostThemeChanged, active:" + z16 + ", visibility:" + (imageView != null ? Integer.valueOf(imageView.getVisibility()) : null));
        if (this.isActive) {
            t();
        }
    }

    private final void w() {
        this.currentPlayCount = 0;
        v();
    }
}
