package com.tencent.mobileqq.qwallet.home;

import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.OnLifecycleEvent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.home.QWalletHomeVipPopVM;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.tuxmeterqui.config.TuxUIConstants;
import cooperation.qwallet.plugin.QWalletPicHelper;
import cooperation.vip.pb.TianShuAccess;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 (2\u00020\u00012\u00020\u0002:\u0003)*+B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0016\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\bH\u0002J\u0006\u0010\f\u001a\u00020\bJ\b\u0010\r\u001a\u00020\bH\u0007J\b\u0010\u000e\u001a\u00020\bH\u0007J\b\u0010\u0010\u001a\u00020\u000fH\u0014J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0014J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0014R\u0017\u0010\u001b\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR%\u0010\"\u001a\u0010\u0012\f\u0012\n \u001d*\u0004\u0018\u00010\u00060\u00060\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0018\u0010%\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/qwallet/home/QWalletHomeVipPopVM;", "Lcom/qwallet/home/c;", "Landroidx/lifecycle/LifecycleObserver;", "Landroid/widget/PopupWindow;", "c2", "window", "Lcom/tencent/mobileqq/qwallet/home/QWalletHomeVipPopVM$c;", "popInfo", "", "i2", SemanticAttributes.DbSystemValues.H2, "g2", "d2", "onCreate", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "Lcom/tencent/mobileqq/tianshu/data/TianShuGetAdvCallback;", "M1", "", "Lcom/tencent/mobileqq/tianshu/data/TianShuAdPosItemData;", "N1", "Lcooperation/vip/pb/TianShuAccess$AdItem;", "L1", "Lcom/tencent/mobileqq/qwallet/home/QWalletHomeFragment;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/qwallet/home/QWalletHomeFragment;", "getFragment", "()Lcom/tencent/mobileqq/qwallet/home/QWalletHomeFragment;", "fragment", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/MutableLiveData;", "e2", "()Landroidx/lifecycle/MutableLiveData;", "popLiveData", "D", "Landroid/widget/PopupWindow;", "vipPopupWindow", "<init>", "(Lcom/tencent/mobileqq/qwallet/home/QWalletHomeFragment;)V", "E", "a", "b", "c", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class QWalletHomeVipPopVM extends com.qwallet.home.c implements LifecycleObserver {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<PopInfo> popLiveData;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private PopupWindow vipPopupWindow;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QWalletHomeFragment fragment;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0015\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0010\u001a\u00020\n\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0006\u0012\u0006\u0010 \u001a\u00020\u001b\u00a2\u0006\u0004\b!\u0010\"J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0017\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001a\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\"\u0010 \u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u0011\u0010\u001d\"\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/qwallet/home/QWalletHomeVipPopVM$a;", "", "", "d", "", "toString", "", "hashCode", "other", "equals", "Landroid/view/View;", "a", "Landroid/view/View;", "()Landroid/view/View;", "setAnchorView", "(Landroid/view/View;)V", "anchorView", "b", "I", "c", "()I", "setWidth", "(I)V", "width", "getHeight", "setHeight", "height", "", "[I", "()[I", "setPosition", "([I)V", "position", "<init>", "(Landroid/view/View;II[I)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.home.QWalletHomeVipPopVM$a, reason: from toString */
    /* loaded from: classes16.dex */
    public static final /* data */ class AnchorInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private View anchorView;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private int width;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private int height;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private int[] position;

        public AnchorInfo(@NotNull View anchorView, int i3, int i16, @NotNull int[] position) {
            Intrinsics.checkNotNullParameter(anchorView, "anchorView");
            Intrinsics.checkNotNullParameter(position, "position");
            this.anchorView = anchorView;
            this.width = i3;
            this.height = i16;
            this.position = position;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final View getAnchorView() {
            return this.anchorView;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final int[] getPosition() {
            return this.position;
        }

        /* renamed from: c, reason: from getter */
        public final int getWidth() {
            return this.width;
        }

        public final boolean d() {
            if (this.width == 0) {
                return false;
            }
            int[] iArr = this.position;
            if (iArr.length != 2 || iArr[0] == 0 || iArr[1] == 0 || this.anchorView.getParent() == null || !this.anchorView.isAttachedToWindow()) {
                return false;
            }
            return true;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AnchorInfo)) {
                return false;
            }
            AnchorInfo anchorInfo = (AnchorInfo) other;
            if (Intrinsics.areEqual(this.anchorView, anchorInfo.anchorView) && this.width == anchorInfo.width && this.height == anchorInfo.height && Intrinsics.areEqual(this.position, anchorInfo.position)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((((this.anchorView.hashCode() * 31) + this.width) * 31) + this.height) * 31) + Arrays.hashCode(this.position);
        }

        @NotNull
        public String toString() {
            return "AnchorInfo(anchorView=" + this.anchorView + ", width=" + this.width + ", height=" + this.height + ", position=" + Arrays.toString(this.position) + ")";
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001Be\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010$\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010*\u00a2\u0006\u0004\b0\u00101J\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u001a\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R$\u0010\u001e\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u001c\u0010\u0013\"\u0004\b\u001d\u0010\u0015R$\u0010 \u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u0011\u001a\u0004\b\u0010\u0010\u0013\"\u0004\b\u001f\u0010\u0015R$\u0010#\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0011\u001a\u0004\b!\u0010\u0013\"\u0004\b\"\u0010\u0015R$\u0010)\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010%\u001a\u0004\b\u0017\u0010&\"\u0004\b'\u0010(R$\u0010/\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010+\u001a\u0004\b\u001b\u0010,\"\u0004\b-\u0010.\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/qwallet/home/QWalletHomeVipPopVM$c;", "", "", "a", "", "toString", "", "hashCode", "other", "equals", "Z", "getNoOtherDialog", "()Z", DomainData.DOMAIN_NAME, "(Z)V", "noOtherDialog", "b", "Ljava/lang/String;", "f", "()Ljava/lang/String;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Ljava/lang/String;)V", "icon", "c", tl.h.F, "p", "text", "d", "e", "l", TuxUIConstants.POP_BTN_TEXT, "i", "action", "g", "o", "reportExt", "Lcooperation/vip/pb/TianShuAccess$AdItem;", "Lcooperation/vip/pb/TianShuAccess$AdItem;", "()Lcooperation/vip/pb/TianShuAccess$AdItem;", "j", "(Lcooperation/vip/pb/TianShuAccess$AdItem;)V", "adItem", "Lcom/tencent/mobileqq/qwallet/home/QWalletHomeVipPopVM$a;", "Lcom/tencent/mobileqq/qwallet/home/QWalletHomeVipPopVM$a;", "()Lcom/tencent/mobileqq/qwallet/home/QWalletHomeVipPopVM$a;", "k", "(Lcom/tencent/mobileqq/qwallet/home/QWalletHomeVipPopVM$a;)V", "anchorInfo", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcooperation/vip/pb/TianShuAccess$AdItem;Lcom/tencent/mobileqq/qwallet/home/QWalletHomeVipPopVM$a;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qwallet.home.QWalletHomeVipPopVM$c, reason: from toString */
    /* loaded from: classes16.dex */
    public static final /* data */ class PopInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private boolean noOtherDialog;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private String icon;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private String text;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private String btnText;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private String action;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private String reportExt;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private TianShuAccess.AdItem adItem;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private AnchorInfo anchorInfo;

        public PopInfo() {
            this(false, null, null, null, null, null, null, null, 255, null);
        }

        public final boolean a() {
            boolean z16;
            boolean z17;
            boolean z18;
            boolean z19;
            String str = this.text;
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                return false;
            }
            String str2 = this.btnText;
            if (str2 != null && str2.length() != 0) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (z17) {
                return false;
            }
            String str3 = this.action;
            if (str3 != null && str3.length() != 0) {
                z18 = false;
            } else {
                z18 = true;
            }
            if (z18) {
                return false;
            }
            AnchorInfo anchorInfo = this.anchorInfo;
            if (anchorInfo != null && anchorInfo.d()) {
                z19 = true;
            } else {
                z19 = false;
            }
            if (!z19 || !this.noOtherDialog || this.adItem == null) {
                return false;
            }
            return true;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final String getAction() {
            return this.action;
        }

        @Nullable
        /* renamed from: c, reason: from getter */
        public final TianShuAccess.AdItem getAdItem() {
            return this.adItem;
        }

        @Nullable
        /* renamed from: d, reason: from getter */
        public final AnchorInfo getAnchorInfo() {
            return this.anchorInfo;
        }

        @Nullable
        /* renamed from: e, reason: from getter */
        public final String getBtnText() {
            return this.btnText;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PopInfo)) {
                return false;
            }
            PopInfo popInfo = (PopInfo) other;
            if (this.noOtherDialog == popInfo.noOtherDialog && Intrinsics.areEqual(this.icon, popInfo.icon) && Intrinsics.areEqual(this.text, popInfo.text) && Intrinsics.areEqual(this.btnText, popInfo.btnText) && Intrinsics.areEqual(this.action, popInfo.action) && Intrinsics.areEqual(this.reportExt, popInfo.reportExt) && Intrinsics.areEqual(this.adItem, popInfo.adItem) && Intrinsics.areEqual(this.anchorInfo, popInfo.anchorInfo)) {
                return true;
            }
            return false;
        }

        @Nullable
        /* renamed from: f, reason: from getter */
        public final String getIcon() {
            return this.icon;
        }

        @Nullable
        /* renamed from: g, reason: from getter */
        public final String getReportExt() {
            return this.reportExt;
        }

        @Nullable
        /* renamed from: h, reason: from getter */
        public final String getText() {
            return this.text;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v16 */
        /* JADX WARN: Type inference failed for: r0v17 */
        public int hashCode() {
            int hashCode;
            int hashCode2;
            int hashCode3;
            int hashCode4;
            int hashCode5;
            int hashCode6;
            boolean z16 = this.noOtherDialog;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int i3 = r06 * 31;
            String str = this.icon;
            int i16 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i17 = (i3 + hashCode) * 31;
            String str2 = this.text;
            if (str2 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = str2.hashCode();
            }
            int i18 = (i17 + hashCode2) * 31;
            String str3 = this.btnText;
            if (str3 == null) {
                hashCode3 = 0;
            } else {
                hashCode3 = str3.hashCode();
            }
            int i19 = (i18 + hashCode3) * 31;
            String str4 = this.action;
            if (str4 == null) {
                hashCode4 = 0;
            } else {
                hashCode4 = str4.hashCode();
            }
            int i26 = (i19 + hashCode4) * 31;
            String str5 = this.reportExt;
            if (str5 == null) {
                hashCode5 = 0;
            } else {
                hashCode5 = str5.hashCode();
            }
            int i27 = (i26 + hashCode5) * 31;
            TianShuAccess.AdItem adItem = this.adItem;
            if (adItem == null) {
                hashCode6 = 0;
            } else {
                hashCode6 = adItem.hashCode();
            }
            int i28 = (i27 + hashCode6) * 31;
            AnchorInfo anchorInfo = this.anchorInfo;
            if (anchorInfo != null) {
                i16 = anchorInfo.hashCode();
            }
            return i28 + i16;
        }

        public final void i(@Nullable String str) {
            this.action = str;
        }

        public final void j(@Nullable TianShuAccess.AdItem adItem) {
            this.adItem = adItem;
        }

        public final void k(@Nullable AnchorInfo anchorInfo) {
            this.anchorInfo = anchorInfo;
        }

        public final void l(@Nullable String str) {
            this.btnText = str;
        }

        public final void m(@Nullable String str) {
            this.icon = str;
        }

        public final void n(boolean z16) {
            this.noOtherDialog = z16;
        }

        public final void o(@Nullable String str) {
            this.reportExt = str;
        }

        public final void p(@Nullable String str) {
            this.text = str;
        }

        @NotNull
        public String toString() {
            return "PopInfo(noOtherDialog=" + this.noOtherDialog + ", icon=" + this.icon + ", text=" + this.text + ", btnText=" + this.btnText + ", action=" + this.action + ", reportExt=" + this.reportExt + ", adItem=" + this.adItem + ", anchorInfo=" + this.anchorInfo + ")";
        }

        public PopInfo(boolean z16, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable TianShuAccess.AdItem adItem, @Nullable AnchorInfo anchorInfo) {
            this.noOtherDialog = z16;
            this.icon = str;
            this.text = str2;
            this.btnText = str3;
            this.action = str4;
            this.reportExt = str5;
            this.adItem = adItem;
            this.anchorInfo = anchorInfo;
        }

        public /* synthetic */ PopInfo(boolean z16, String str, String str2, String str3, String str4, String str5, TianShuAccess.AdItem adItem, AnchorInfo anchorInfo, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? false : z16, (i3 & 2) != 0 ? null : str, (i3 & 4) != 0 ? null : str2, (i3 & 8) != 0 ? null : str3, (i3 & 16) != 0 ? null : str4, (i3 & 32) != 0 ? null : str5, (i3 & 64) != 0 ? null : adItem, (i3 & 128) == 0 ? anchorInfo : null);
        }
    }

    public QWalletHomeVipPopVM(@NotNull QWalletHomeFragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.fragment = fragment;
        MutableLiveData<PopInfo> mutableLiveData = new MutableLiveData<>(new PopInfo(false, null, null, null, null, null, null, null, 255, null));
        this.popLiveData = mutableLiveData;
        final Function1<PopInfo, Unit> function1 = new Function1<PopInfo, Unit>() { // from class: com.tencent.mobileqq.qwallet.home.QWalletHomeVipPopVM.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PopInfo popInfo) {
                invoke2(popInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PopInfo popInfo) {
                QLog.d("QWalletHomeVipPopVM", 2, "data change " + popInfo.a() + ". " + popInfo);
                if (popInfo.a()) {
                    PopupWindow popupWindow = QWalletHomeVipPopVM.this.vipPopupWindow;
                    if (popupWindow == null) {
                        popupWindow = QWalletHomeVipPopVM.this.c2();
                        QWalletHomeVipPopVM.this.vipPopupWindow = popupWindow;
                    }
                    QWalletHomeVipPopVM qWalletHomeVipPopVM = QWalletHomeVipPopVM.this;
                    Intrinsics.checkNotNullExpressionValue(popInfo, "popInfo");
                    qWalletHomeVipPopVM.i2(popupWindow, popInfo);
                    return;
                }
                QWalletHomeVipPopVM.this.d2();
            }
        };
        mutableLiveData.observe(fragment, new Observer() { // from class: com.tencent.mobileqq.qwallet.home.ab
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QWalletHomeVipPopVM.W1(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PopupWindow c2() {
        PopupWindow popupWindow = new PopupWindow(LayoutInflater.from(this.fragment.getContext()).inflate(R.layout.hjf, (ViewGroup) null, false), -1, -2);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        popupWindow.setOutsideTouchable(false);
        popupWindow.setTouchable(true);
        return popupWindow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f2(QWalletHomeVipPopVM this$0, boolean z16, TianShuAccess.GetAdsRsp getAdsRsp) {
        List<TianShuAccess.AdItem> list;
        List<TianShuAccess.MapEntry> list2;
        int collectionSizeOrDefault;
        int mapCapacity;
        int coerceAtLeast;
        String str;
        String str2;
        PBStringField pBStringField;
        PBStringField pBStringField2;
        TianShuAccess.AdPlacementInfo adPlacementInfo;
        PBRepeatMessageField<TianShuAccess.AdItem> pBRepeatMessageField;
        PBRepeatMessageField<TianShuAccess.RspEntry> pBRepeatMessageField2;
        List<TianShuAccess.RspEntry> list3;
        PBUInt32Field pBUInt32Field;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!z16) {
            if (QLog.isColorLevel()) {
                QLog.i("QWalletHomeVipPopVM", 2, "getTianShuCallback: result = false");
                return;
            }
            return;
        }
        if (getAdsRsp != null && (pBRepeatMessageField2 = getAdsRsp.mapAds) != null && (list3 = pBRepeatMessageField2.get()) != null) {
            for (TianShuAccess.RspEntry rspEntry : list3) {
                boolean z17 = false;
                if (rspEntry != null && (pBUInt32Field = rspEntry.key) != null && 1188 == pBUInt32Field.get()) {
                    z17 = true;
                }
            }
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        }
        rspEntry = null;
        if (rspEntry != null && (adPlacementInfo = rspEntry.value) != null && (pBRepeatMessageField = adPlacementInfo.lst) != null) {
            list = pBRepeatMessageField.get();
        } else {
            list = null;
        }
        if (list == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("QWalletHomeVipPopVM", 2, "adItemList size is " + list.size());
        }
        for (TianShuAccess.AdItem adItem : list) {
            PBRepeatMessageField<TianShuAccess.MapEntry> pBRepeatMessageField3 = adItem.argList;
            if (pBRepeatMessageField3 != null) {
                list2 = pBRepeatMessageField3.get();
            } else {
                list2 = null;
            }
            if (list2 != null) {
                Intrinsics.checkNotNullExpressionValue(list2, "adItem.argList?.get() ?: return@forEach");
                List<TianShuAccess.MapEntry> list4 = list2;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list4, 10);
                mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
                coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
                LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
                for (TianShuAccess.MapEntry mapEntry : list4) {
                    if (mapEntry != null && (pBStringField2 = mapEntry.key) != null) {
                        str = pBStringField2.get();
                    } else {
                        str = null;
                    }
                    if (mapEntry != null && (pBStringField = mapEntry.value) != null) {
                        str2 = pBStringField.get();
                    } else {
                        str2 = null;
                    }
                    linkedHashMap.put(str, str2);
                }
                PopInfo value = this$0.popLiveData.getValue();
                if (value != null) {
                    String str3 = (String) linkedHashMap.get("vip_pop_icon");
                    String str4 = "";
                    if (str3 == null) {
                        str3 = "";
                    }
                    value.m(str3);
                    String str5 = (String) linkedHashMap.get("vip_pop_text");
                    if (str5 == null) {
                        str5 = "";
                    }
                    value.p(str5);
                    String str6 = (String) linkedHashMap.get("vip_pop_btn");
                    if (str6 == null) {
                        str6 = "";
                    }
                    value.l(str6);
                    String str7 = (String) linkedHashMap.get("vip_pop_action");
                    if (str7 == null) {
                        str7 = "";
                    }
                    value.i(str7);
                    String str8 = (String) linkedHashMap.get("vip_pop_clm");
                    if (str8 != null) {
                        str4 = str8;
                    }
                    value.o(str4);
                    value.j(adItem);
                }
                this$0.popLiveData.postValue(value);
                return;
            }
        }
    }

    private final void g2() {
        String str;
        String text;
        PopInfo value = this.popLiveData.getValue();
        String str2 = "";
        if (value == null || (str = value.getReportExt()) == null) {
            str = "";
        }
        String valueOf = String.valueOf(NetConnInfoCenter.getServerTimeMillis());
        PopInfo value2 = this.popLiveData.getValue();
        if (value2 != null && (text = value2.getText()) != null) {
            str2 = text;
        }
        P1("index.pop.click", str, valueOf, str2);
        O1(102);
    }

    private final void h2() {
        String str;
        String text;
        PopInfo value = this.popLiveData.getValue();
        String str2 = "";
        if (value == null || (str = value.getReportExt()) == null) {
            str = "";
        }
        String valueOf = String.valueOf(NetConnInfoCenter.getServerTimeMillis());
        PopInfo value2 = this.popLiveData.getValue();
        if (value2 != null && (text = value2.getText()) != null) {
            str2 = text;
        }
        P1("index.pop.show", str, valueOf, str2);
        O1(101);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i2(PopupWindow window, final PopInfo popInfo) {
        View anchorView;
        int i3;
        int[] position;
        AnchorInfo anchorInfo = popInfo.getAnchorInfo();
        if (anchorInfo != null && (anchorView = anchorInfo.getAnchorView()) != null) {
            View contentView = window.getContentView();
            ImageView imageView = (ImageView) contentView.findViewById(R.id.f67513dj);
            AnchorInfo anchorInfo2 = popInfo.getAnchorInfo();
            if (anchorInfo2 == null) {
                return;
            }
            AnchorInfo anchorInfo3 = popInfo.getAnchorInfo();
            if (anchorInfo3 != null && (position = anchorInfo3.getPosition()) != null) {
                i3 = position[0];
            } else {
                i3 = 0;
            }
            int width = (anchorInfo2.getWidth() - this.fragment.getResources().getDimensionPixelSize(R.dimen.daz)) / 2;
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ((ViewGroup.MarginLayoutParams) layoutParams).setMarginStart(width + i3);
            QLog.i("QWalletHomeVipPopVM", 2, "show vip dialog, x=" + i3);
            ((ImageView) contentView.findViewById(R.id.f67533dl)).setImageDrawable(QWalletPicHelper.getNetDrawableForQWallet(popInfo.getIcon(), new ColorDrawable(0), new ColorDrawable(0)));
            TextView textView = (TextView) contentView.findViewById(R.id.f67543dm);
            textView.setText(popInfo.getText());
            textView.setSelected(true);
            TextView textView2 = (TextView) contentView.findViewById(R.id.f67523dk);
            textView2.setText(popInfo.getBtnText());
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qwallet.home.ac
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QWalletHomeVipPopVM.j2(QWalletHomeVipPopVM.PopInfo.this, this, view);
                }
            });
            contentView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qwallet.home.ad
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QWalletHomeVipPopVM.k2(QWalletHomeVipPopVM.PopInfo.this, this, view);
                }
            });
            window.showAsDropDown(anchorView);
            h2();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j2(PopInfo popInfo, QWalletHomeVipPopVM this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(popInfo, "$popInfo");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("QWalletHomeVipPopVM", 2, "click button goto uri=" + popInfo.getAction());
        this$0.g2();
        com.tencent.mobileqq.qwallet.utils.k.h(this$0.fragment.getContext(), popInfo.getAction());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k2(PopInfo popInfo, QWalletHomeVipPopVM this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(popInfo, "$popInfo");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("QWalletHomeVipPopVM", 2, "goto uri=" + popInfo.getAction());
        this$0.g2();
        com.tencent.mobileqq.qwallet.utils.k.h(this$0.fragment.getContext(), popInfo.getAction());
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.qwallet.home.c
    @Nullable
    protected TianShuAccess.AdItem L1() {
        PopInfo value = this.popLiveData.getValue();
        if (value != null) {
            return value.getAdItem();
        }
        return null;
    }

    @Override // com.qwallet.home.c
    @NotNull
    protected TianShuGetAdvCallback M1() {
        return new TianShuGetAdvCallback() { // from class: com.tencent.mobileqq.qwallet.home.aa
            @Override // com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback
            public final void onGetAdvs(boolean z16, TianShuAccess.GetAdsRsp getAdsRsp) {
                QWalletHomeVipPopVM.f2(QWalletHomeVipPopVM.this, z16, getAdsRsp);
            }
        };
    }

    @Override // com.qwallet.home.c
    @NotNull
    protected List<TianShuAdPosItemData> N1() {
        List<TianShuAdPosItemData> listOf;
        TianShuAdPosItemData tianShuAdPosItemData = new TianShuAdPosItemData();
        tianShuAdPosItemData.mPosId = 1188;
        tianShuAdPosItemData.mNeedCnt = 1;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(tianShuAdPosItemData);
        return listOf;
    }

    public final void d2() {
        PopupWindow popupWindow = this.vipPopupWindow;
        if (popupWindow != null) {
            popupWindow.dismiss();
            this.vipPopupWindow = null;
        }
    }

    @NotNull
    public final MutableLiveData<PopInfo> e2() {
        return this.popLiveData;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public final void onCreate() {
        if (((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
            if (QLog.isColorLevel()) {
                QLog.i("QWalletHomeVipPopVM", 2, "is exposure today or is study mode");
                return;
            }
            return;
        }
        Q1();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        d2();
    }
}
