package com.tencent.mobileqq.qwallet.home;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.qwallet.protocol.Wallet.pb.QWalletHomePage$AppInfo;
import com.qwallet.protocol.Wallet.pb.QWalletHomePage$Market;
import com.qwallet.protocol.Wallet.pb.QWalletHomePage$RedDot;
import com.tencent.ams.xsad.rewarded.dynamic.method.AdCommonMethodHandler;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.util.UiThreadUtil;
import cooperation.qwallet.plugin.QWalletPicHelper;
import cooperation.qwallet.plugin.ipc.QWalletRedTouchInfo;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00122\u00020\u0001:\u0002\u001c\u001fB\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u00a2\u0006\u0004\b7\u00108J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u0012\u001a\u00020\u000bH\u0002J\b\u0010\u0013\u001a\u00020\u000bH\u0002J\u000e\u0010\u0014\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\u0015\u001a\u00020\u0005J\u000e\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0016J\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u001e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u001e\u0010&\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010\"R\u0016\u0010)\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00100\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R \u00103\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u00102R,\u00106\u001a\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u0002\u0012\u0004\u0012\u00020\r04018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00102\u00a8\u00069"}, d2 = {"Lcom/tencent/mobileqq/qwallet/home/am;", "", "", "Lcooperation/qwallet/plugin/ipc/QWalletRedTouchInfo;", "list", "", "y", "Lcom/qwallet/protocol/Wallet/pb/QWalletHomePage$AppInfo;", "appInfo", DomainData.DOMAIN_NAME, "v", "", "o", "", "event", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, ReportConstant.COSTREPORT_PREFIX, tl.h.F, "j", "l", HippyTKDListViewAdapter.X, "u", "Landroid/view/View;", "view", "t", "", "r", "Lcom/tencent/mobileqq/qwallet/home/am$b;", "a", "Lcom/tencent/mobileqq/qwallet/home/am$b;", "hostView", "b", "Lcom/qwallet/protocol/Wallet/pb/QWalletHomePage$AppInfo;", "c", "Ljava/util/List;", "touchInfoList", "Lcom/qwallet/protocol/Wallet/pb/QWalletHomePage$RedDot;", "d", "redDotList", "e", "I", "showCarouselRedDotAppId", "Ljava/lang/Runnable;", "f", "Ljava/lang/Runnable;", AdCommonMethodHandler.AdCommonEvent.CLICK_ACTION, "g", "Z", "hasShowedSystemRedPoint", "Landroidx/lifecycle/Observer;", "Landroidx/lifecycle/Observer;", "trueRedPointObserver", "Lkotlin/Pair;", "i", "carouselRedDotObserver", "<init>", "(Lcom/tencent/mobileqq/qwallet/home/am$b;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class am {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b hostView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QWalletHomePage$AppInfo appInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private List<? extends QWalletRedTouchInfo> touchInfoList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private List<QWalletHomePage$RedDot> redDotList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int showCarouselRedDotAppId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Runnable clickAction;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean hasShowedSystemRedPoint;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Observer<List<QWalletRedTouchInfo>> trueRedPointObserver;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Observer<Pair<List<QWalletHomePage$RedDot>, Integer>> carouselRedDotObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0006\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\u0004H&J\b\u0010\t\u001a\u00020\bH&J\b\u0010\n\u001a\u00020\u0004H&J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/qwallet/home/am$b;", "", "", "n0", "Landroid/widget/ImageView;", "l0", "G", ExifInterface.LATITUDE_SOUTH, "Landroid/widget/TextView;", "g0", UserInfo.SEX_FEMALE, "event", "Lcom/qwallet/protocol/Wallet/pb/QWalletHomePage$AppInfo;", "appInfo", "", "u0", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public interface b {
        @NotNull
        ImageView F();

        @NotNull
        ImageView G();

        @NotNull
        ImageView S();

        @NotNull
        TextView g0();

        @NotNull
        ImageView l0();

        int n0();

        void u0(int event, @NotNull QWalletHomePage$AppInfo appInfo);
    }

    public am(@NotNull b hostView) {
        Intrinsics.checkNotNullParameter(hostView, "hostView");
        this.hostView = hostView;
        this.trueRedPointObserver = new Observer() { // from class: com.tencent.mobileqq.qwallet.home.ak
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                am.w(am.this, (List) obj);
            }
        };
        this.carouselRedDotObserver = new Observer() { // from class: com.tencent.mobileqq.qwallet.home.al
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                am.g(am.this, (Pair) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(am this$0, Pair pair) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List<QWalletHomePage$RedDot> list = (List) pair.component1();
        int intValue = ((Number) pair.component2()).intValue();
        this$0.redDotList = list;
        this$0.showCarouselRedDotAppId = intValue;
        QWalletHomePage$AppInfo qWalletHomePage$AppInfo = this$0.appInfo;
        if (qWalletHomePage$AppInfo != null) {
            this$0.n(qWalletHomePage$AppInfo);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean h(QWalletHomePage$AppInfo appInfo) {
        int i3;
        final QWalletHomePage$RedDot qWalletHomePage$RedDot;
        final ImageView imageView;
        PBEnumField pBEnumField;
        Object obj;
        boolean z16;
        if (this.hostView.n0() != 2 || HomeLegacyBizManager.p("100007.102300") || (i3 = appInfo.f41686id.get()) != this.showCarouselRedDotAppId) {
            return false;
        }
        List<QWalletHomePage$RedDot> list = this.redDotList;
        boolean z17 = true;
        Integer num = null;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (((QWalletHomePage$RedDot) obj).app_id.get() == i3) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            qWalletHomePage$RedDot = (QWalletHomePage$RedDot) obj;
        } else {
            qWalletHomePage$RedDot = null;
        }
        if (qWalletHomePage$RedDot == null) {
            z17 = false;
        }
        if (z17) {
            if (qWalletHomePage$RedDot != null && (pBEnumField = qWalletHomePage$RedDot.type) != null) {
                num = Integer.valueOf(pBEnumField.get());
            }
            if (num != null && num.intValue() == 2) {
                TextView g06 = this.hostView.g0();
                g06.setText(qWalletHomePage$RedDot.content.get());
                imageView = g06;
            } else if (num != null && num.intValue() == 3) {
                ImageView F = this.hostView.F();
                F.setImageDrawable(QWalletPicHelper.getNetDrawableForQWallet(qWalletHomePage$RedDot.content.get()));
                imageView = F;
            } else {
                imageView = this.hostView.G();
            }
            imageView.setVisibility(0);
            q(2);
            this.clickAction = new Runnable() { // from class: com.tencent.mobileqq.qwallet.home.ah
                @Override // java.lang.Runnable
                public final void run() {
                    am.i(imageView, this, qWalletHomePage$RedDot);
                }
            };
        }
        return z17;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(View redDotView, am this$0, QWalletHomePage$RedDot qWalletHomePage$RedDot) {
        Intrinsics.checkNotNullParameter(redDotView, "$redDotView");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        redDotView.setVisibility(8);
        this$0.q(3);
        if (qWalletHomePage$RedDot != null) {
            d.f278053a.g(qWalletHomePage$RedDot);
        }
    }

    private final boolean j() {
        boolean z16;
        QWalletHomePage$AppInfo qWalletHomePage$AppInfo = this.appInfo;
        int i3 = 0;
        if (qWalletHomePage$AppInfo != null) {
            z16 = c4.a.c(qWalletHomePage$AppInfo);
        } else {
            z16 = false;
        }
        final ImageView S = this.hostView.S();
        if (!z16) {
            i3 = 8;
        }
        S.setVisibility(i3);
        if (z16) {
            q(4);
            this.clickAction = new Runnable() { // from class: com.tencent.mobileqq.qwallet.home.aj
                @Override // java.lang.Runnable
                public final void run() {
                    am.k(S, this);
                }
            };
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(ImageView redPointView, am this$0) {
        Intrinsics.checkNotNullParameter(redPointView, "$redPointView");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        redPointView.setVisibility(8);
        this$0.q(5);
        QWalletHomePage$AppInfo qWalletHomePage$AppInfo = this$0.appInfo;
        if (qWalletHomePage$AppInfo != null) {
            c4.a.B(qWalletHomePage$AppInfo);
        }
    }

    private final boolean l() {
        boolean z16;
        int i3;
        final QWalletHomePage$Market qWalletHomePage$Market;
        QWalletHomePage$AppInfo qWalletHomePage$AppInfo = this.appInfo;
        if (qWalletHomePage$AppInfo != null) {
            z16 = c4.a.a(qWalletHomePage$AppInfo);
        } else {
            z16 = false;
        }
        final ImageView F = this.hostView.F();
        if (z16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        F.setVisibility(i3);
        if (z16) {
            QWalletHomePage$AppInfo qWalletHomePage$AppInfo2 = this.appInfo;
            if (qWalletHomePage$AppInfo2 != null) {
                qWalletHomePage$Market = qWalletHomePage$AppInfo2.market;
            } else {
                qWalletHomePage$Market = null;
            }
            if (qWalletHomePage$Market == null) {
                return false;
            }
            Context context = F.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "marketTag.context");
            F.setImageDrawable(c4.a.h(qWalletHomePage$Market, context));
            q(6);
            this.clickAction = new Runnable() { // from class: com.tencent.mobileqq.qwallet.home.ag
                @Override // java.lang.Runnable
                public final void run() {
                    am.m(am.this, qWalletHomePage$Market, F);
                }
            };
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(am this$0, QWalletHomePage$Market market, ImageView marketTag) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(market, "$market");
        Intrinsics.checkNotNullParameter(marketTag, "$marketTag");
        this$0.q(7);
        if (c4.a.i(market)) {
            QWalletHomePage$AppInfo qWalletHomePage$AppInfo = this$0.appInfo;
            if (qWalletHomePage$AppInfo != null) {
                c4.a.z(qWalletHomePage$AppInfo);
            }
            marketTag.setVisibility(8);
        }
    }

    private final void n(QWalletHomePage$AppInfo appInfo) {
        if (!c4.a.u(appInfo)) {
            return;
        }
        v();
        if (o(appInfo)) {
            return;
        }
        if (s(appInfo)) {
            if (h(appInfo)) {
                return;
            }
            q(-1);
        } else {
            if (j() || l()) {
                return;
            }
            q(-1);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean o(final QWalletHomePage$AppInfo appInfo) {
        final QWalletRedTouchInfo qWalletRedTouchInfo;
        boolean z16;
        Integer num;
        final ImageView imageView;
        String str;
        boolean z17;
        Object obj;
        boolean z18;
        List<? extends QWalletRedTouchInfo> list = this.touchInfoList;
        String str2 = null;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    QWalletRedTouchInfo qWalletRedTouchInfo2 = (QWalletRedTouchInfo) obj;
                    if (qWalletRedTouchInfo2.site == this.hostView.n0() && qWalletRedTouchInfo2.appId == appInfo.f41686id.get() && Intrinsics.areEqual(qWalletRedTouchInfo2.path, "100007.102300")) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (z18) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            qWalletRedTouchInfo = (QWalletRedTouchInfo) obj;
        } else {
            qWalletRedTouchInfo = null;
        }
        if (qWalletRedTouchInfo != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (qWalletRedTouchInfo != null) {
                num = Integer.valueOf(qWalletRedTouchInfo.redDotType);
            } else {
                num = null;
            }
            if (num != null && num.intValue() == 2) {
                TextView g06 = this.hostView.g0();
                g06.setText(qWalletRedTouchInfo.redDotContent);
                imageView = g06;
            } else if (num != null && num.intValue() == 3) {
                ImageView F = this.hostView.F();
                F.setImageDrawable(QWalletPicHelper.getNetDrawableForQWallet(qWalletRedTouchInfo.redDotContent));
                imageView = F;
            } else {
                imageView = this.hostView.G();
            }
            if (qWalletRedTouchInfo != null) {
                str = qWalletRedTouchInfo.redDotIconUrl;
            } else {
                str = null;
            }
            if (str != null && str.length() != 0) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (!z17) {
                ImageView l06 = this.hostView.l0();
                if (qWalletRedTouchInfo != null) {
                    str2 = qWalletRedTouchInfo.redDotIconUrl;
                }
                l06.setImageDrawable(QWalletPicHelper.getNetDrawableForQWallet(str2));
            }
            imageView.setVisibility(0);
            q(0);
            this.hasShowedSystemRedPoint = true;
            this.clickAction = new Runnable() { // from class: com.tencent.mobileqq.qwallet.home.ai
                @Override // java.lang.Runnable
                public final void run() {
                    am.p(am.this, appInfo, imageView, qWalletRedTouchInfo);
                }
            };
        }
        return HomeLegacyBizManager.p("100007.102300");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(am this$0, QWalletHomePage$AppInfo appInfo, View redPointView, QWalletRedTouchInfo qWalletRedTouchInfo) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(appInfo, "$appInfo");
        Intrinsics.checkNotNullParameter(redPointView, "$redPointView");
        this$0.hostView.l0().setImageDrawable(QWalletPicHelper.getNetDrawableForQWallet(appInfo.icon.get()));
        redPointView.setVisibility(8);
        if (qWalletRedTouchInfo != null && (str = qWalletRedTouchInfo.path) != null) {
            HomeLegacyBizManager.f277929d.d(str);
        }
        this$0.q(1);
    }

    private final void q(int event) {
        QWalletHomePage$AppInfo qWalletHomePage$AppInfo = this.appInfo;
        if (qWalletHomePage$AppInfo != null) {
            this.hostView.u0(event, qWalletHomePage$AppInfo);
        }
    }

    private final boolean s(QWalletHomePage$AppInfo appInfo) {
        boolean z16;
        if (this.hasShowedSystemRedPoint) {
            return true;
        }
        if (this.hostView.n0() != 2) {
            return false;
        }
        List<QWalletHomePage$RedDot> list = this.redDotList;
        Object obj = null;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (((QWalletHomePage$RedDot) next).app_id.get() == appInfo.f41686id.get()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    obj = next;
                    break;
                }
            }
            obj = (QWalletHomePage$RedDot) obj;
        }
        if (obj != null) {
            return true;
        }
        return false;
    }

    private final void v() {
        this.hostView.G().setVisibility(8);
        this.hostView.S().setVisibility(8);
        this.hostView.g0().setVisibility(8);
        this.hostView.F().setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(am this$0, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(list, "list");
        this$0.y(list);
    }

    private final void y(List<? extends QWalletRedTouchInfo> list) {
        this.touchInfoList = list;
        QWalletHomePage$AppInfo qWalletHomePage$AppInfo = this.appInfo;
        if (qWalletHomePage$AppInfo != null) {
            n(qWalletHomePage$AppInfo);
        }
    }

    @Nullable
    public final String r() {
        QWalletHomePage$Market qWalletHomePage$Market;
        if (this.hostView.F().getVisibility() == 0) {
            QWalletHomePage$AppInfo qWalletHomePage$AppInfo = this.appInfo;
            if (qWalletHomePage$AppInfo == null || (qWalletHomePage$Market = qWalletHomePage$AppInfo.market) == null) {
                return null;
            }
            Context context = this.hostView.F().getContext();
            Intrinsics.checkNotNullExpressionValue(context, "hostView.marketView().context");
            return c4.a.e(qWalletHomePage$Market, context);
        }
        ImageView G = this.hostView.G();
        if (G.getVisibility() != 0) {
            return null;
        }
        return G.getResources().getString(R.string.vp5);
    }

    public final void t(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        LifecycleOwner lifecycleOwner = ViewTreeLifecycleOwner.get(view);
        if (lifecycleOwner != null) {
            HomeLegacyBizManager homeLegacyBizManager = HomeLegacyBizManager.f277929d;
            homeLegacyBizManager.o().observe(lifecycleOwner, this.trueRedPointObserver);
            if (this.hostView.n0() == 2) {
                homeLegacyBizManager.f().observe(lifecycleOwner, this.carouselRedDotObserver);
            }
        }
    }

    public final void u() {
        Runnable runnable = this.clickAction;
        if (runnable != null) {
            UiThreadUtil.runOnUiThread(runnable);
        }
    }

    public final void x(@NotNull QWalletHomePage$AppInfo appInfo) {
        Intrinsics.checkNotNullParameter(appInfo, "appInfo");
        this.appInfo = appInfo;
        n(appInfo);
    }
}
