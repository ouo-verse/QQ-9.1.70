package com.tencent.biz.qrcode.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.component.qrcode.QUIColorfulQRCodeView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.util.LoadingUtil;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 k2\u00020\u0001:\u0003lmnB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010g\u001a\u0004\u0018\u00010f\u0012\b\b\u0002\u0010h\u001a\u00020\u0016\u00a2\u0006\u0004\bi\u0010jJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0003J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0006\u0010\u0011\u001a\u00020\u0004J\u0006\u0010\u0012\u001a\u00020\u0004J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\u000fJ\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u0015J\b\u0010\u0019\u001a\u00020\u0004H\u0007J\u0006\u0010\u001a\u001a\u00020\u0004J\u0006\u0010\u001b\u001a\u00020\u0004R\"\u0010#\u001a\u00020\u001c8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010+\u001a\u00020$8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u00102\u001a\u00020,8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u000b\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00109\u001a\u0002038\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0007\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u0010A\u001a\u00020:8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\"\u0010H\u001a\u00020B8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u001f\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR(\u0010O\u001a\b\u0012\u0004\u0012\u00020\u000f0I8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\"\u0010U\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\b;\u0010R\"\u0004\bS\u0010TR\u0017\u0010[\u001a\u00020V8\u0006\u00a2\u0006\f\n\u0004\bW\u0010X\u001a\u0004\bY\u0010ZR\u0017\u0010a\u001a\u00020\\8\u0006\u00a2\u0006\f\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`R\u0016\u0010e\u001a\u00020b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010d\u00a8\u0006o"}, d2 = {"Lcom/tencent/biz/qrcode/util/QRCodeLoadingComponent;", "Landroid/widget/RelativeLayout;", "Landroid/content/Context;", "context", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, ReportConstant.COSTREPORT_PREFIX, tl.h.F, "", "key", "chain", "f", "t", "", PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, "", "u", "y", "g", "forceUpdate", "setChain", "Ljava/util/HashMap;", "", "Lcom/tencent/mobileqq/component/qrcode/d;", "o", BdhLogUtil.LogTag.Tag_Conn, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Landroid/view/View;", "d", "Landroid/view/View;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Landroid/view/View;", "setLoadingLayout", "(Landroid/view/View;)V", "loadingLayout", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "l", "()Landroid/widget/ImageView;", "setLoadingIcon", "(Landroid/widget/ImageView;)V", "loadingIcon", "Landroid/widget/TextView;", "Landroid/widget/TextView;", DomainData.DOMAIN_NAME, "()Landroid/widget/TextView;", "setLoadingTips", "(Landroid/widget/TextView;)V", "loadingTips", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "k", "()Lcom/tencent/biz/qui/quibutton/QUIButton;", "setLoadingButton", "(Lcom/tencent/biz/qui/quibutton/QUIButton;)V", "loadingButton", "Lcom/tencent/mobileqq/component/qrcode/QUIColorfulQRCodeView;", "i", "Lcom/tencent/mobileqq/component/qrcode/QUIColorfulQRCodeView;", "p", "()Lcom/tencent/mobileqq/component/qrcode/QUIColorfulQRCodeView;", "setQrCodeView", "(Lcom/tencent/mobileqq/component/qrcode/QUIColorfulQRCodeView;)V", "qrCodeView", "Lcom/tencent/biz/qrcode/util/QRCodeLoadingComponent$b;", "Lcom/tencent/biz/qrcode/util/QRCodeLoadingComponent$b;", "j", "()Lcom/tencent/biz/qrcode/util/QRCodeLoadingComponent$b;", "setGetChainProcess", "(Lcom/tencent/biz/qrcode/util/QRCodeLoadingComponent$b;)V", "getChainProcess", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/MutableLiveData;", "v", "()Landroidx/lifecycle/MutableLiveData;", "setInitialized", "(Landroidx/lifecycle/MutableLiveData;)V", "isInitialized", "D", "Ljava/lang/String;", "()Ljava/lang/String;", "setCurChain", "(Ljava/lang/String;)V", "curChain", "Landroid/os/Handler;", "E", "Landroid/os/Handler;", "getMHandler", "()Landroid/os/Handler;", "mHandler", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "getMEntity", "()Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "mEntity", "Ljava/lang/Runnable;", "G", "Ljava/lang/Runnable;", "timeoutCallback", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "H", "Chain", "a", "b", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class QRCodeLoadingComponent extends RelativeLayout {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<Boolean> isInitialized;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private String curChain;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Handler mHandler;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final MMKVOptionEntity mEntity;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private Runnable timeoutCallback;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public View loadingLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public ImageView loadingIcon;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public TextView loadingTips;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public QUIButton loadingButton;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public QUIColorfulQRCodeView qrCodeView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public b getChainProcess;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\f\b\u0086\b\u0018\u0000  2\u00020\u0001:\u0001\u0012B\u0017\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012\u0006\u0010\u001c\u001a\u00020\u0015\u00a2\u0006\u0004\b\u001d\u0010\u001eB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\t\u0010\u000b\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u00d6\u0003R\u0017\u0010\u0014\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u001c\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/tencent/biz/qrcode/util/QRCodeLoadingComponent$Chain;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "toString", "hashCode", "", "other", "", "equals", "d", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "chain", "", "e", "J", "b", "()J", "setTimeStamp", "(J)V", PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, "<init>", "(Ljava/lang/String;J)V", "(Landroid/os/Parcel;)V", "CREATOR", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
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
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/biz/qrcode/util/QRCodeLoadingComponent$Chain$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/biz/qrcode/util/QRCodeLoadingComponent$Chain;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/biz/qrcode/util/QRCodeLoadingComponent$Chain;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.biz.qrcode.util.QRCodeLoadingComponent$Chain$a, reason: from kotlin metadata */
        /* loaded from: classes5.dex */
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

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getChain() {
            return this.chain;
        }

        /* renamed from: b, reason: from getter */
        public final long getTimeStamp() {
            return this.timeStamp;
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
            return (this.chain.hashCode() * 31) + androidx.fragment.app.a.a(this.timeStamp);
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
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0002H&J@\u0010\u000f\u001a\u00020\r26\u0010\u000e\u001a2\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\bH&\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/biz/qrcode/util/QRCodeLoadingComponent$b;", "", "", "a", "d", "", "e", "c", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "isSuccess", "chain", "", "cb", "b", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public static abstract class b {
        @NotNull
        public final String a() {
            return d() + "_" + c();
        }

        public abstract void b(@NotNull Function2<? super Boolean, ? super String, Unit> cb5);

        @NotNull
        public abstract String c();

        @NotNull
        public String d() {
            return "default";
        }

        public boolean e() {
            return true;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QRCodeLoadingComponent(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(QRCodeLoadingComponent this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("QRCodeLoadingComponent", 1, "time out");
        this$0.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(String key, String chain) {
        this.mEntity.encodeParcelable(key, new Chain(chain, System.currentTimeMillis()));
    }

    private final void h() {
        if (j().e()) {
            Chain chain = (Chain) this.mEntity.decodeParcelable(j().a(), Chain.class, new Chain("", -1L));
            if (!TextUtils.isEmpty(chain.getChain()) && u(chain.getTimeStamp())) {
                QLog.i("QRCodeLoadingComponent", 1, "cache valid, key = " + j().a() + ", chain " + chain.getChain());
                setChain$default(this, chain.getChain(), false, 2, null);
                return;
            }
            if (!TextUtils.isEmpty(chain.getChain()) && !u(chain.getTimeStamp())) {
                QLog.i("QRCodeLoadingComponent", 1, "cache not valid, key = " + j().a() + ", chain " + chain.getChain());
            } else {
                QLog.i("QRCodeLoadingComponent", 1, "no cache , key = " + j().a() + ", chain " + chain.getChain());
            }
        }
        j().b(new Function2<Boolean, String, Unit>() { // from class: com.tencent.biz.qrcode.util.QRCodeLoadingComponent$getChain$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, String str) {
                invoke(bool.booleanValue(), str);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, @NotNull String chain2) {
                Intrinsics.checkNotNullParameter(chain2, "chain");
                if (z16 && !TextUtils.isEmpty(chain2)) {
                    if (QRCodeLoadingComponent.this.j().e()) {
                        QRCodeLoadingComponent qRCodeLoadingComponent = QRCodeLoadingComponent.this;
                        qRCodeLoadingComponent.f(qRCodeLoadingComponent.j().a(), chain2);
                    }
                    QRCodeLoadingComponent.setChain$default(QRCodeLoadingComponent.this, chain2, false, 2, null);
                    return;
                }
                QRCodeLoadingComponent.this.g();
            }
        });
    }

    @SuppressLint({"InflateParams"})
    private final void q(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.fxw, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.\u2026code_short_loading, null)");
        setLoadingLayout(inflate);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14, -1);
        layoutParams.addRule(15, -1);
        addView(m(), layoutParams);
        View findViewById = m().findViewById(R.id.ysu);
        Intrinsics.checkNotNullExpressionValue(findViewById, "loadingLayout.findViewById(R.id.loading_icon)");
        setLoadingIcon((ImageView) findViewById);
        View findViewById2 = m().findViewById(R.id.yt9);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "loadingLayout.findViewById(R.id.loading_tip)");
        setLoadingTips((TextView) findViewById2);
        View findViewById3 = m().findViewById(R.id.f72703rk);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "loadingLayout.findViewById(R.id.reload_button)");
        setLoadingButton((QUIButton) findViewById3);
        k().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.biz.qrcode.util.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QRCodeLoadingComponent.r(QRCodeLoadingComponent.this, view);
            }
        });
        m().setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(QRCodeLoadingComponent this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.y();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void s(Context context) {
        setQrCodeView(new QUIColorfulQRCodeView(context, null, 0, 0, 14, null));
        addView(p(), new RelativeLayout.LayoutParams(-1, -1));
        p().setVisibility(8);
    }

    public static /* synthetic */ void setChain$default(QRCodeLoadingComponent qRCodeLoadingComponent, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        qRCodeLoadingComponent.setChain(str, z16);
    }

    private final void t(String key) {
        this.mEntity.encodeParcelable(key, new Chain("", -1L));
    }

    private final boolean u(long timeStamp) {
        if (timeStamp == -1 || System.currentTimeMillis() - timeStamp >= 54000) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(QRCodeLoadingComponent this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("QRCodeLoadingComponent", 1, "onDrawn");
        this$0.isInitialized.postValue(Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(String chain, QRCodeLoadingComponent this$0, int i3) {
        Intrinsics.checkNotNullParameter(chain, "$chain");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 != 0 && i3 != -12) {
            QLog.e("QRCodeLoadingComponent", 1, "refreshContent failed generateQRCode " + i3 + ", chain " + chain);
            this$0.curChain = "";
            this$0.g();
            return;
        }
        QLog.i("QRCodeLoadingComponent", 1, "refresh success chain " + chain);
        this$0.curChain = chain;
    }

    public final void A() {
        p().e(true);
        p().g(new com.tencent.mobileqq.component.qrcode.i(0, null, null, 0, 15, null));
    }

    @SuppressLint({"UseCompatLoadingForDrawables"})
    public final void C() {
        Unit unit;
        Resources resources;
        Context context = getContext();
        if (context != null && (resources = context.getResources()) != null) {
            if (QQTheme.isVasTheme()) {
                Drawable drawable = resources.getDrawable(R.drawable.qui_common_bg_bottom_standard_bg, null);
                if (drawable instanceof SkinnableBitmapDrawable) {
                    Bitmap bitmap = ((SkinnableBitmapDrawable) drawable).getBitmap();
                    QUIColorfulQRCodeView p16 = p();
                    Intrinsics.checkNotNullExpressionValue(bitmap, "bitmap");
                    QUIColorfulQRCodeView.p(p16, bitmap, null, 2, null);
                    unit = Unit.INSTANCE;
                }
            }
            QUIColorfulQRCodeView.o(p(), resources.getColor(R.color.qui_common_brand_standard, null), null, 2, null);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            QUIColorfulQRCodeView.o(p(), -1, null, 2, null);
        }
    }

    public final void g() {
        if (this.getChainProcess != null && j().e()) {
            t(j().a());
        }
        this.isInitialized.postValue(Boolean.FALSE);
        this.curChain = "";
        this.mHandler.removeCallbacks(this.timeoutCallback);
        QLog.i("QRCodeLoadingComponent", 1, "fail without cache , key = " + j().a());
        m().setVisibility(0);
        l().setVisibility(0);
        l().setImageResource(R.drawable.qui_refresh_tertiary);
        n().setVisibility(0);
        n().setText(R.string.f2034650_);
        k().setVisibility(0);
        p().setVisibility(8);
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final String getCurChain() {
        return this.curChain;
    }

    @NotNull
    public final b j() {
        b bVar = this.getChainProcess;
        if (bVar != null) {
            return bVar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("getChainProcess");
        return null;
    }

    @NotNull
    public final QUIButton k() {
        QUIButton qUIButton = this.loadingButton;
        if (qUIButton != null) {
            return qUIButton;
        }
        Intrinsics.throwUninitializedPropertyAccessException("loadingButton");
        return null;
    }

    @NotNull
    public final ImageView l() {
        ImageView imageView = this.loadingIcon;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("loadingIcon");
        return null;
    }

    @NotNull
    public final View m() {
        View view = this.loadingLayout;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("loadingLayout");
        return null;
    }

    @NotNull
    public final TextView n() {
        TextView textView = this.loadingTips;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("loadingTips");
        return null;
    }

    @NotNull
    public final HashMap<Integer, com.tencent.mobileqq.component.qrcode.d> o() {
        HashMap<Integer, com.tencent.mobileqq.component.qrcode.d> hashMap = new HashMap<>();
        hashMap.put(3, new com.tencent.mobileqq.component.qrcode.d(7, 6, 32.0f, 3.0f));
        hashMap.put(4, new com.tencent.mobileqq.component.qrcode.d(9, 7, 32.0f, 3.0f));
        hashMap.put(5, new com.tencent.mobileqq.component.qrcode.d(10, 8, 32.0f, 3.0f));
        hashMap.put(6, new com.tencent.mobileqq.component.qrcode.d(11, 9, 32.0f, 3.0f));
        hashMap.put(7, new com.tencent.mobileqq.component.qrcode.d(12, 10, 32.0f, 3.0f));
        hashMap.put(8, new com.tencent.mobileqq.component.qrcode.d(13, 11, 32.0f, 3.0f));
        hashMap.put(9, new com.tencent.mobileqq.component.qrcode.d(14, 12, 32.0f, 3.0f));
        hashMap.put(10, new com.tencent.mobileqq.component.qrcode.d(14, 12, 32.0f, 3.0f));
        hashMap.put(11, new com.tencent.mobileqq.component.qrcode.d(14, 12, 32.0f, 3.0f));
        hashMap.put(12, new com.tencent.mobileqq.component.qrcode.d(14, 12, 32.0f, 3.0f));
        hashMap.put(13, new com.tencent.mobileqq.component.qrcode.d(14, 12, 32.0f, 3.0f));
        hashMap.put(14, new com.tencent.mobileqq.component.qrcode.d(14, 12, 32.0f, 3.0f));
        hashMap.put(15, new com.tencent.mobileqq.component.qrcode.d(14, 12, 32.0f, 3.0f));
        hashMap.put(16, new com.tencent.mobileqq.component.qrcode.d(14, 12, 32.0f, 3.0f));
        hashMap.put(17, new com.tencent.mobileqq.component.qrcode.d(14, 12, 32.0f, 3.0f));
        hashMap.put(18, new com.tencent.mobileqq.component.qrcode.d(14, 12, 32.0f, 3.0f));
        hashMap.put(19, new com.tencent.mobileqq.component.qrcode.d(14, 12, 32.0f, 3.0f));
        hashMap.put(20, new com.tencent.mobileqq.component.qrcode.d(14, 12, 32.0f, 3.0f));
        hashMap.put(21, new com.tencent.mobileqq.component.qrcode.d(14, 12, 32.0f, 3.0f));
        hashMap.put(22, new com.tencent.mobileqq.component.qrcode.d(14, 12, 32.0f, 3.0f));
        hashMap.put(23, new com.tencent.mobileqq.component.qrcode.d(14, 12, 32.0f, 3.0f));
        hashMap.put(24, new com.tencent.mobileqq.component.qrcode.d(14, 12, 32.0f, 3.0f));
        hashMap.put(25, new com.tencent.mobileqq.component.qrcode.d(14, 12, 32.0f, 3.0f));
        hashMap.put(26, new com.tencent.mobileqq.component.qrcode.d(14, 12, 32.0f, 3.0f));
        hashMap.put(27, new com.tencent.mobileqq.component.qrcode.d(14, 12, 32.0f, 3.0f));
        hashMap.put(28, new com.tencent.mobileqq.component.qrcode.d(14, 12, 32.0f, 3.0f));
        hashMap.put(29, new com.tencent.mobileqq.component.qrcode.d(14, 12, 32.0f, 3.0f));
        return hashMap;
    }

    @NotNull
    public final QUIColorfulQRCodeView p() {
        QUIColorfulQRCodeView qUIColorfulQRCodeView = this.qrCodeView;
        if (qUIColorfulQRCodeView != null) {
            return qUIColorfulQRCodeView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("qrCodeView");
        return null;
    }

    public final void setChain(@NotNull final String chain, boolean forceUpdate) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        this.mHandler.removeCallbacks(this.timeoutCallback);
        if (k().getVisibility() == 0 && !forceUpdate) {
            return;
        }
        z();
        C();
        p().setOnFirstTimeDrawnListener(new com.tencent.mobileqq.component.qrcode.h() { // from class: com.tencent.biz.qrcode.util.b
            @Override // com.tencent.mobileqq.component.qrcode.h
            public final void a() {
                QRCodeLoadingComponent.w(QRCodeLoadingComponent.this);
            }
        });
        m().setVisibility(8);
        p().setVisibility(0);
        p().setTargetGenerateQRCodeParams(new com.tencent.mobileqq.component.qrcode.e(3, 29, o(), ErrorCorrectionLevel.Q));
        p().f(chain, new com.tencent.mobileqq.component.qrcode.g() { // from class: com.tencent.biz.qrcode.util.c
            @Override // com.tencent.mobileqq.component.qrcode.g
            public final void onResult(int i3) {
                QRCodeLoadingComponent.x(chain, this, i3);
            }
        });
        if (AppSetting.f99565y) {
            AccessibilityUtil.n(p(), true);
            AccessibilityUtil.c(p(), HardCodeUtil.qqStr(R.string.f172949g21), ImageView.class.getName());
        }
    }

    public final void setCurChain(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.curChain = str;
    }

    public final void setGetChainProcess(@NotNull b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        this.getChainProcess = bVar;
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

    public final void setQrCodeView(@NotNull QUIColorfulQRCodeView qUIColorfulQRCodeView) {
        Intrinsics.checkNotNullParameter(qUIColorfulQRCodeView, "<set-?>");
        this.qrCodeView = qUIColorfulQRCodeView;
    }

    @NotNull
    public final MutableLiveData<Boolean> v() {
        return this.isInitialized;
    }

    public final void y() {
        this.isInitialized.postValue(Boolean.FALSE);
        m().setVisibility(0);
        l().setVisibility(0);
        l().setImageDrawable(LoadingUtil.getLoadingDrawable(getContext(), 2));
        n().setVisibility(0);
        n().setText(R.string.f2034750a);
        k().setVisibility(8);
        p().setVisibility(8);
        this.mHandler.postDelayed(this.timeoutCallback, 6000L);
        if (this.getChainProcess != null) {
            h();
        } else {
            QLog.i("QRCodeLoadingComponent", 1, "getChainProcess is not Initialized");
            g();
        }
    }

    public final void z() {
        p().e(false);
        p().g(new com.tencent.mobileqq.component.qrcode.i(0, null, null, 0, 9, null));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QRCodeLoadingComponent(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ QRCodeLoadingComponent(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QRCodeLoadingComponent(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.isInitialized = new MutableLiveData<>(Boolean.FALSE);
        this.curChain = "";
        this.mHandler = new Handler();
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        this.mEntity = from;
        this.timeoutCallback = new Runnable() { // from class: com.tencent.biz.qrcode.util.d
            @Override // java.lang.Runnable
            public final void run() {
                QRCodeLoadingComponent.B(QRCodeLoadingComponent.this);
            }
        };
        q(context);
        s(context);
    }
}
