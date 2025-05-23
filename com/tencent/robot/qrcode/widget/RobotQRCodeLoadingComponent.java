package com.tencent.robot.qrcode.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.a;
import androidx.lifecycle.MutableLiveData;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.component.qrcode.QUIColorfulQRCodeView;
import com.tencent.mobileqq.component.qrcode.d;
import com.tencent.mobileqq.component.qrcode.e;
import com.tencent.mobileqq.component.qrcode.g;
import com.tencent.mobileqq.component.qrcode.i;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import com.tencent.robot.qrcode.widget.RobotQRCodeLoadingComponent;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.util.LoadingUtil;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 u2\u00020\u0001:\u0003vwxB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010q\u001a\u0004\u0018\u00010p\u0012\b\b\u0002\u0010r\u001a\u00020\t\u00a2\u0006\u0004\bs\u0010tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0003J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0007\u001a\u00020\u0004J\"\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n`\u000bJ\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0012\u001a\u00020\u0004J\u0006\u0010\u0013\u001a\u00020\u0004J\u0006\u0010\u0014\u001a\u00020\u0004J\u000e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015J\b\u0010\u0018\u001a\u00020\u0004H\u0007J\u0018\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\t2\b\b\u0002\u0010\u001b\u001a\u00020\u001aJ\u000e\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001dR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\"\u0010*\u001a\u00020$8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u001f\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u00101\u001a\u00020+8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0007\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00108\u001a\u0002028\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b-\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u0010?\u001a\u0002098\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b4\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\"\u0010G\u001a\u00020@8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\"\u0010N\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR(\u0010V\u001a\b\u0012\u0004\u0012\u00020\u000f0O8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\"\u0010\\\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bW\u0010X\u001a\u0004\bA\u0010Y\"\u0004\bZ\u0010[R\u0017\u0010b\u001a\u00020]8\u0006\u00a2\u0006\f\n\u0004\b^\u0010_\u001a\u0004\b`\u0010aR\u0017\u0010h\u001a\u00020c8\u0006\u00a2\u0006\f\n\u0004\bd\u0010e\u001a\u0004\bf\u0010gR\"\u0010j\u001a\u00020i8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bj\u0010k\u001a\u0004\bl\u0010m\"\u0004\bn\u0010o\u00a8\u0006y"}, d2 = {"Lcom/tencent/robot/qrcode/widget/RobotQRCodeLoadingComponent;", "Landroid/widget/RelativeLayout;", "Landroid/content/Context;", "context", "", DomainData.DOMAIN_NAME, "p", "f", "Ljava/util/HashMap;", "", "Lcom/tencent/mobileqq/component/qrcode/d;", "Lkotlin/collections/HashMap;", "k", "", "chain", "", "forceUpdate", "setChain", "t", "u", "v", "Lcom/tencent/mobileqq/component/qrcode/i;", "params", "setLogoResParams", HippyTKDListViewAdapter.X, "color", "Lcom/tencent/mobileqq/component/qrcode/a;", "changeColorParams", "setRefreshQRCodeBgColor", "Landroid/graphics/Canvas;", PM.CANVAS, "e", "Ljava/lang/Runnable;", "d", "Ljava/lang/Runnable;", "timeoutCallback", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "g", "()Lcom/tencent/biz/qui/quibutton/QUIButton;", "setLoadingButton", "(Lcom/tencent/biz/qui/quibutton/QUIButton;)V", "loadingButton", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", h.F, "()Landroid/widget/ImageView;", "setLoadingIcon", "(Landroid/widget/ImageView;)V", "loadingIcon", "Landroid/view/View;", "Landroid/view/View;", "i", "()Landroid/view/View;", "setLoadingLayout", "(Landroid/view/View;)V", "loadingLayout", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "j", "()Landroid/widget/TextView;", "setLoadingTips", "(Landroid/widget/TextView;)V", "loadingTips", "Lcom/tencent/mobileqq/component/qrcode/QUIColorfulQRCodeView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/component/qrcode/QUIColorfulQRCodeView;", "l", "()Lcom/tencent/mobileqq/component/qrcode/QUIColorfulQRCodeView;", "setQrCodeView", "(Lcom/tencent/mobileqq/component/qrcode/QUIColorfulQRCodeView;)V", "qrCodeView", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "getCurChain", "()Ljava/lang/String;", "setCurChain", "(Ljava/lang/String;)V", "curChain", "Landroidx/lifecycle/MutableLiveData;", "D", "Landroidx/lifecycle/MutableLiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Landroidx/lifecycle/MutableLiveData;", "setInitialized", "(Landroidx/lifecycle/MutableLiveData;)V", "isInitialized", "E", "I", "()I", "setResCode", "(I)V", "resCode", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "getMEntity", "()Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "mEntity", "Landroid/os/Handler;", "G", "Landroid/os/Handler;", "getMHandler", "()Landroid/os/Handler;", "mHandler", "Lcom/tencent/robot/qrcode/widget/RobotQRCodeLoadingComponent$b;", "getChainProcess", "Lcom/tencent/robot/qrcode/widget/RobotQRCodeLoadingComponent$b;", "getGetChainProcess", "()Lcom/tencent/robot/qrcode/widget/RobotQRCodeLoadingComponent$b;", "setGetChainProcess", "(Lcom/tencent/robot/qrcode/widget/RobotQRCodeLoadingComponent$b;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "H", "Chain", "a", "b", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotQRCodeLoadingComponent extends RelativeLayout {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private String curChain;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<Boolean> isInitialized;

    /* renamed from: E, reason: from kotlin metadata */
    private int resCode;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final MMKVOptionEntity mEntity;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Handler mHandler;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Runnable timeoutCallback;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public QUIButton loadingButton;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public ImageView loadingIcon;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public View loadingLayout;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public TextView loadingTips;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public QUIColorfulQRCodeView qrCodeView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\r\b\u0086\b\u0018\u0000  2\u00020\u0001:\u0001!B\u0017\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012\u0006\u0010\u001c\u001a\u00020\u0015\u00a2\u0006\u0004\b\u001d\u0010\u001eB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\t\u0010\u000b\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u00d6\u0003R\u0017\u0010\u0014\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u001c\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006\""}, d2 = {"Lcom/tencent/robot/qrcode/widget/RobotQRCodeLoadingComponent$Chain;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "toString", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "getChain", "()Ljava/lang/String;", "chain", "", "e", "J", "getTimeStamp", "()J", "setTimeStamp", "(J)V", PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, "<init>", "(Ljava/lang/String;J)V", "(Landroid/os/Parcel;)V", "CREATOR", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final /* data */ class Chain implements Parcelable {

        /* renamed from: CREATOR, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String chain;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private long timeStamp;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/robot/qrcode/widget/RobotQRCodeLoadingComponent$Chain$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/robot/qrcode/widget/RobotQRCodeLoadingComponent$Chain;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/robot/qrcode/widget/RobotQRCodeLoadingComponent$Chain;", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.robot.qrcode.widget.RobotQRCodeLoadingComponent$Chain$a, reason: from kotlin metadata */
        /* loaded from: classes25.dex */
        public static final class Companion implements Parcelable.Creator<Chain> {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Chain createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Chain(parcel);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Chain[] newArray(int size) {
                return new Chain[size];
            }

            Companion() {
            }
        }

        public Chain(@NotNull String chain, long j3) {
            Intrinsics.checkNotNullParameter(chain, "chain");
            this.chain = chain;
            this.timeStamp = j3;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Chain)) {
                return false;
            }
            Chain chain = (Chain) other;
            if (Intrinsics.areEqual(this.chain, chain.chain) && this.timeStamp == chain.timeStamp) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.chain.hashCode() * 31) + a.a(this.timeStamp);
        }

        @NotNull
        public String toString() {
            return "Chain(chain=" + this.chain + ", timeStamp=" + this.timeStamp + ")";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.chain);
            parcel.writeLong(this.timeStamp);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Chain(@NotNull Parcel parcel) {
            this(r0 == null ? "" : r0, parcel.readLong());
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b&\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/robot/qrcode/widget/RobotQRCodeLoadingComponent$b;", "", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static abstract class b {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RobotQRCodeLoadingComponent(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @SuppressLint({"InflateParams"})
    private final void n(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.f169074hp1, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.\u2026code_short_loading, null)");
        setLoadingLayout(inflate);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14, -1);
        layoutParams.addRule(15, -1);
        addView(i(), layoutParams);
        View findViewById = i().findViewById(R.id.ysu);
        Intrinsics.checkNotNullExpressionValue(findViewById, "loadingLayout.findViewById(R.id.loading_icon)");
        setLoadingIcon((ImageView) findViewById);
        View findViewById2 = i().findViewById(R.id.yt9);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "loadingLayout.findViewById(R.id.loading_tip)");
        setLoadingTips((TextView) findViewById2);
        View findViewById3 = i().findViewById(R.id.f72703rk);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "loadingLayout.findViewById(R.id.reload_button)");
        setLoadingButton((QUIButton) findViewById3);
        g().setOnClickListener(new View.OnClickListener() { // from class: x44.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RobotQRCodeLoadingComponent.o(RobotQRCodeLoadingComponent.this, view);
            }
        });
        i().setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(RobotQRCodeLoadingComponent this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.t();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void p(Context context) {
        setQrCodeView(new QUIColorfulQRCodeView(context, null, 0, 0, 14, null));
        addView(l(), new RelativeLayout.LayoutParams(-1, -1));
        l().setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(RobotQRCodeLoadingComponent this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("robot.qr.RobotQRCodeLoadingComponent", 1, "onDrawn");
        this$0.isInitialized.postValue(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(RobotQRCodeLoadingComponent this$0, String chain, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(chain, "$chain");
        this$0.resCode = i3;
        if (i3 != 0 && i3 != -12) {
            QLog.e("robot.qr.RobotQRCodeLoadingComponent", 1, "refreshContent failed generateQRCode " + i3 + ", chain " + chain);
            this$0.curChain = "";
            this$0.f();
            return;
        }
        QLog.i("robot.qr.RobotQRCodeLoadingComponent", 1, "refresh success chain " + chain);
        this$0.curChain = chain;
    }

    public static /* synthetic */ void setChain$default(RobotQRCodeLoadingComponent robotQRCodeLoadingComponent, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        robotQRCodeLoadingComponent.setChain(str, z16);
    }

    public static /* synthetic */ void setRefreshQRCodeBgColor$default(RobotQRCodeLoadingComponent robotQRCodeLoadingComponent, int i3, com.tencent.mobileqq.component.qrcode.a aVar, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            aVar = com.tencent.mobileqq.component.qrcode.a.INSTANCE.a();
        }
        robotQRCodeLoadingComponent.setRefreshQRCodeBgColor(i3, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(RobotQRCodeLoadingComponent this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("robot.qr.RobotQRCodeLoadingComponent", 1, "time out");
        this$0.f();
    }

    public final void e(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        l().d(canvas);
    }

    public final void f() {
        this.isInitialized.postValue(Boolean.FALSE);
        this.curChain = "";
        this.mHandler.removeCallbacks(this.timeoutCallback);
        i().setVisibility(0);
        h().setVisibility(0);
        h().setImageResource(R.drawable.lj6);
        j().setVisibility(0);
        j().setText(R.string.f222856en);
        g().setVisibility(0);
        l().setVisibility(8);
    }

    @NotNull
    public final QUIButton g() {
        QUIButton qUIButton = this.loadingButton;
        if (qUIButton != null) {
            return qUIButton;
        }
        Intrinsics.throwUninitializedPropertyAccessException("loadingButton");
        return null;
    }

    @NotNull
    public final ImageView h() {
        ImageView imageView = this.loadingIcon;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("loadingIcon");
        return null;
    }

    @NotNull
    public final View i() {
        View view = this.loadingLayout;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("loadingLayout");
        return null;
    }

    @NotNull
    public final TextView j() {
        TextView textView = this.loadingTips;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("loadingTips");
        return null;
    }

    @NotNull
    public final HashMap<Integer, d> k() {
        HashMap<Integer, d> hashMap = new HashMap<>();
        hashMap.put(3, new d(7, 6, 32.0f, 3.0f));
        hashMap.put(4, new d(9, 7, 32.0f, 3.0f));
        hashMap.put(5, new d(10, 8, 32.0f, 3.0f));
        hashMap.put(6, new d(11, 9, 32.0f, 3.0f));
        hashMap.put(7, new d(12, 10, 32.0f, 3.0f));
        hashMap.put(8, new d(13, 11, 32.0f, 3.0f));
        hashMap.put(9, new d(14, 12, 32.0f, 3.0f));
        hashMap.put(10, new d(14, 12, 32.0f, 3.0f));
        hashMap.put(11, new d(14, 12, 32.0f, 3.0f));
        hashMap.put(12, new d(14, 12, 32.0f, 3.0f));
        hashMap.put(13, new d(14, 12, 32.0f, 3.0f));
        hashMap.put(14, new d(14, 12, 32.0f, 3.0f));
        hashMap.put(15, new d(14, 12, 32.0f, 3.0f));
        hashMap.put(16, new d(14, 12, 32.0f, 3.0f));
        hashMap.put(17, new d(14, 12, 32.0f, 3.0f));
        hashMap.put(18, new d(14, 12, 32.0f, 3.0f));
        hashMap.put(19, new d(14, 12, 32.0f, 3.0f));
        hashMap.put(20, new d(14, 12, 32.0f, 3.0f));
        hashMap.put(21, new d(14, 12, 32.0f, 3.0f));
        hashMap.put(22, new d(14, 12, 32.0f, 3.0f));
        hashMap.put(23, new d(14, 12, 32.0f, 3.0f));
        hashMap.put(24, new d(14, 12, 32.0f, 3.0f));
        hashMap.put(25, new d(14, 12, 32.0f, 3.0f));
        hashMap.put(26, new d(14, 12, 32.0f, 3.0f));
        hashMap.put(27, new d(14, 12, 32.0f, 3.0f));
        hashMap.put(28, new d(14, 12, 32.0f, 3.0f));
        hashMap.put(29, new d(14, 12, 32.0f, 3.0f));
        return hashMap;
    }

    @NotNull
    public final QUIColorfulQRCodeView l() {
        QUIColorfulQRCodeView qUIColorfulQRCodeView = this.qrCodeView;
        if (qUIColorfulQRCodeView != null) {
            return qUIColorfulQRCodeView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("qrCodeView");
        return null;
    }

    /* renamed from: m, reason: from getter */
    public final int getResCode() {
        return this.resCode;
    }

    @NotNull
    public final MutableLiveData<Boolean> q() {
        return this.isInitialized;
    }

    public final void setChain(@NotNull final String chain, boolean forceUpdate) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        this.mHandler.removeCallbacks(this.timeoutCallback);
        if (g().getVisibility() == 0 && !forceUpdate) {
            return;
        }
        u();
        x();
        l().setOnFirstTimeDrawnListener(new com.tencent.mobileqq.component.qrcode.h() { // from class: x44.a
            @Override // com.tencent.mobileqq.component.qrcode.h
            public final void a() {
                RobotQRCodeLoadingComponent.r(RobotQRCodeLoadingComponent.this);
            }
        });
        i().setVisibility(8);
        l().setVisibility(0);
        l().setTargetGenerateQRCodeParams(new e(3, 29, k(), ErrorCorrectionLevel.Q));
        l().f(chain, new g() { // from class: x44.b
            @Override // com.tencent.mobileqq.component.qrcode.g
            public final void onResult(int i3) {
                RobotQRCodeLoadingComponent.s(RobotQRCodeLoadingComponent.this, chain, i3);
            }
        });
    }

    public final void setCurChain(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.curChain = str;
    }

    public final void setGetChainProcess(@NotNull b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
    }

    public final void setInitialized(@NotNull MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.isInitialized = mutableLiveData;
    }

    public final void setLoadingButton(@NotNull QUIButton qUIButton) {
        Intrinsics.checkNotNullParameter(qUIButton, "<set-?>");
        this.loadingButton = qUIButton;
    }

    public final void setLoadingIcon(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.loadingIcon = imageView;
    }

    public final void setLoadingLayout(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.loadingLayout = view;
    }

    public final void setLoadingTips(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.loadingTips = textView;
    }

    public final void setLogoResParams(@NotNull i params) {
        Intrinsics.checkNotNullParameter(params, "params");
        l().g(params);
    }

    public final void setQrCodeView(@NotNull QUIColorfulQRCodeView qUIColorfulQRCodeView) {
        Intrinsics.checkNotNullParameter(qUIColorfulQRCodeView, "<set-?>");
        this.qrCodeView = qUIColorfulQRCodeView;
    }

    public final void setRefreshQRCodeBgColor(int color, @NotNull com.tencent.mobileqq.component.qrcode.a changeColorParams) {
        Intrinsics.checkNotNullParameter(changeColorParams, "changeColorParams");
        l().k(color, changeColorParams);
    }

    public final void setResCode(int i3) {
        this.resCode = i3;
    }

    public final void t() {
        this.isInitialized.postValue(Boolean.FALSE);
        i().setVisibility(0);
        h().setVisibility(0);
        h().setImageDrawable(LoadingUtil.getLoadingDrawable(getContext(), 2));
        j().setVisibility(0);
        j().setText(R.string.f222866eo);
        g().setVisibility(8);
        l().setVisibility(8);
        this.mHandler.postDelayed(this.timeoutCallback, 6000L);
        QLog.i("robot.qr.RobotQRCodeLoadingComponent", 1, "getChainProcess is not Initialized");
        f();
    }

    public final void u() {
        l().e(false);
        l().g(new i(0, null, null, 0, 9, null));
    }

    public final void v() {
        l().e(true);
        l().g(new i(0, null, null, 0, 15, null));
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    public final void x() {
        Unit unit;
        Resources resources;
        Context context = getContext();
        if (context != null && (resources = context.getResources()) != null) {
            if (QQTheme.isVasTheme()) {
                Drawable drawable = resources.getDrawable(R.drawable.qui_common_bg_bottom_standard_bg, null);
                if (drawable instanceof SkinnableBitmapDrawable) {
                    Bitmap bitmap = ((SkinnableBitmapDrawable) drawable).getBitmap();
                    QUIColorfulQRCodeView l3 = l();
                    Intrinsics.checkNotNullExpressionValue(bitmap, "bitmap");
                    QUIColorfulQRCodeView.p(l3, bitmap, null, 2, null);
                    unit = Unit.INSTANCE;
                }
            }
            QUIColorfulQRCodeView.o(l(), resources.getColor(R.color.qui_common_brand_standard), null, 2, null);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            QUIColorfulQRCodeView.o(l(), -1, null, 2, null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RobotQRCodeLoadingComponent(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ RobotQRCodeLoadingComponent(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RobotQRCodeLoadingComponent(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.timeoutCallback = new Runnable() { // from class: x44.c
            @Override // java.lang.Runnable
            public final void run() {
                RobotQRCodeLoadingComponent.w(RobotQRCodeLoadingComponent.this);
            }
        };
        this.curChain = "";
        this.isInitialized = new MutableLiveData<>(Boolean.FALSE);
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        this.mEntity = from;
        this.mHandler = new Handler();
        n(context);
        p(context);
    }
}
