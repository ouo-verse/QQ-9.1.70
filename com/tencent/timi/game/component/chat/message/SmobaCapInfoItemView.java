package com.tencent.timi.game.component.chat.message;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qqgift.updatasystem.QQGiftPanelResource;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.component.chat.message.SmobaCapInfoItemView;
import com.tencent.timi.game.component.chat.message.SmobaCapInfoSubItemView;
import com.tencent.timi.game.room.impl.util.YoloRoomUtil;
import com.tencent.timi.game.userinfo.api.view.AvatarRoundImageView;
import com.tencent.timi.game.widget.MediumBoldTextView;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.GameDataServerOuterClass$SmobaGameMode;
import trpc.yes.common.SmobaDataOuterClass$GameCampSettleInfo;
import trpc.yes.common.SmobaDataOuterClass$PlayerSettleInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloGiftConfig;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloSmobaRoomBattleResultAction;
import ug4.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010D\u001a\u00020C\u0012\n\b\u0002\u0010F\u001a\u0004\u0018\u00010E\u0012\b\b\u0002\u0010H\u001a\u00020G\u00a2\u0006\u0004\bI\u0010JJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0014R\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000eR\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\u0015R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010\u0015R\u0016\u0010*\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010\u001fR\u0016\u0010,\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010\u0015R\u0016\u0010.\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010%R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00104\u001a\u00020/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00101R\u0016\u00106\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u0010\u001fR\u0016\u00108\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u0010%R\u0016\u0010:\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010\u001fR\u0016\u0010<\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010\u001fR\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010B\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010\u0015\u00a8\u0006K"}, d2 = {"Lcom/tencent/timi/game/component/chat/message/SmobaCapInfoItemView;", "Lcom/tencent/timi/game/component/chat/message/BaseMessageView;", "", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "P", "Ltrpc/yes/common/YoloRoomOuterClass$YoloGiftConfig;", "giftConfig", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/timi/game/tim/api/message/a;", "msg", "I", "", "Lcom/tencent/timi/game/component/chat/message/SmobaCapInfoSubItemView;", "f0", "Ljava/util/List;", "subItemViews", "Lcom/tencent/timi/game/userinfo/api/view/AvatarRoundImageView;", "g0", "avatarViews", "Landroid/widget/ImageView;", "h0", "Landroid/widget/ImageView;", "bottomView", "i0", "capResultIv", "Landroidx/constraintlayout/widget/ConstraintLayout;", "j0", "Landroidx/constraintlayout/widget/ConstraintLayout;", "contentView", "Landroid/widget/TextView;", "k0", "Landroid/widget/TextView;", "giftDescTv", "l0", "giftIconIv", "Landroid/widget/LinearLayout;", "m0", "Landroid/widget/LinearLayout;", "giftLl", "n0", "middleView", "o0", "modeTv", "p0", "moreArrowIv", "q0", "moreInfoLl", "Lcom/tencent/timi/game/widget/MediumBoldTextView;", "r0", "Lcom/tencent/timi/game/widget/MediumBoldTextView;", "otherKillCountTv", "s0", "selfKillCountTv", "t0", "shareDescTv", "u0", "subItemLl", "v0", "timeTv", "w0", "titleTv", "Landroid/view/View;", "x0", "Landroid/view/View;", "topDividerView", "y0", "topView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class SmobaCapInfoItemView extends BaseMessageView {

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<SmobaCapInfoSubItemView> subItemViews;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<AvatarRoundImageView> avatarViews;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ImageView bottomView;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ImageView capResultIv;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ConstraintLayout contentView;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView giftDescTv;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ImageView giftIconIv;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LinearLayout giftLl;

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ImageView middleView;

    /* renamed from: o0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView modeTv;

    /* renamed from: p0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ImageView moreArrowIv;

    /* renamed from: q0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LinearLayout moreInfoLl;

    /* renamed from: r0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private MediumBoldTextView otherKillCountTv;

    /* renamed from: s0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private MediumBoldTextView selfKillCountTv;

    /* renamed from: t0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView shareDescTv;

    /* renamed from: u0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LinearLayout subItemLl;

    /* renamed from: v0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView timeTv;

    /* renamed from: w0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView titleTv;

    /* renamed from: x0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private View topDividerView;

    /* renamed from: y0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ImageView topView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J(\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/timi/game/component/chat/message/SmobaCapInfoItemView$a", "Lqh2/f;", "", "id", "Lcom/tencent/mobileqq/qqgift/updatasystem/QQGiftPanelResource;", "panelResource", "", "c", "errorCode", "httpCode", "", "errorMessage", "onLoadFail", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class a implements qh2.f {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(SmobaCapInfoItemView this$0, Drawable drawable) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.giftIconIv.setBackgroundDrawable(drawable);
        }

        @Override // qh2.f
        public void c(int id5, @NotNull QQGiftPanelResource panelResource) {
            Intrinsics.checkNotNullParameter(panelResource, "panelResource");
            String str = panelResource.f265002b;
            Intrinsics.checkNotNullExpressionValue(str, "panelResource.thumbPath");
            final URLDrawable a16 = um4.a.f439223a.a(str, URLDrawable.URLDrawableOptions.obtain());
            final SmobaCapInfoItemView smobaCapInfoItemView = SmobaCapInfoItemView.this;
            smobaCapInfoItemView.post(new Runnable() { // from class: com.tencent.timi.game.component.chat.message.an
                @Override // java.lang.Runnable
                public final void run() {
                    SmobaCapInfoItemView.a.b(SmobaCapInfoItemView.this, a16);
                }
            });
        }

        @Override // qh2.g
        public void onLoadFail(int id5, int errorCode, int httpCode, @NotNull String errorMessage) {
            Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes26.dex */
    public static final class b<T> implements Comparator {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f376530d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ SmobaCapInfoItemView f376531e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.tencent.timi.game.tim.api.message.a f376532f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ List f376533h;

        public b(boolean z16, SmobaCapInfoItemView smobaCapInfoItemView, com.tencent.timi.game.tim.api.message.a aVar, List list) {
            this.f376530d = z16;
            this.f376531e = smobaCapInfoItemView;
            this.f376532f = aVar;
            this.f376533h = list;
        }

        /* JADX WARN: Code restructure failed: missing block: B:108:0x008a, code lost:
        
            if (r7 == false) goto L37;
         */
        /* JADX WARN: Code restructure failed: missing block: B:109:0x00af, code lost:
        
            r0 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x0039, code lost:
        
            if (r7 == false) goto L14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x005e, code lost:
        
            r0 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0061, code lost:
        
            if (r0 == false) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:142:0x00ad, code lost:
        
            if (r0 != false) goto L47;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0132, code lost:
        
            if (r7 == false) goto L82;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x0157, code lost:
        
            r0 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x015a, code lost:
        
            if (r0 == false) goto L95;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x0155, code lost:
        
            if (r0 != false) goto L92;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x0183, code lost:
        
            if (r7 == false) goto L105;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x01a8, code lost:
        
            r0 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:85:0x01a6, code lost:
        
            if (r0 != false) goto L115;
         */
        /* JADX WARN: Code restructure failed: missing block: B:97:0x005c, code lost:
        
            if (r0 != false) goto L24;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:17:0x010b  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x016c  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x01ae  */
        /* JADX WARN: Removed duplicated region for block: B:79:0x018f  */
        @Override // java.util.Comparator
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final int compare(T t16, T t17) {
            boolean z16;
            PBUInt64Field pBUInt64Field;
            T t18;
            Integer num;
            PBInt32Field pBInt32Field;
            boolean z17;
            boolean z18;
            PBUInt64Field pBUInt64Field2;
            CommonOuterClass$QQUserId commonOuterClass$QQUserId;
            boolean z19;
            boolean z26;
            PBUInt64Field pBUInt64Field3;
            T t19;
            PBInt32Field pBInt32Field2;
            boolean z27;
            boolean z28;
            PBUInt64Field pBUInt64Field4;
            int compareValues;
            boolean z29;
            PBUInt64Field pBUInt64Field5;
            boolean z36;
            PBUInt64Field pBUInt64Field6;
            boolean z37;
            PBUInt64Field pBUInt64Field7;
            boolean z38;
            PBUInt64Field pBUInt64Field8;
            CommonOuterClass$QQUserId commonOuterClass$QQUserId2 = (CommonOuterClass$QQUserId) t17;
            Integer num2 = Integer.MAX_VALUE;
            if (this.f376530d) {
                CommonOuterClass$QQUserId selfQQUserId = this.f376531e.getSelfQQUserId();
                if (commonOuterClass$QQUserId2.uid.get() != 0) {
                    if (selfQQUserId != null && (pBUInt64Field8 = selfQQUserId.uid) != null && commonOuterClass$QQUserId2.uid.get() == pBUInt64Field8.get()) {
                        z38 = true;
                    } else {
                        z38 = false;
                    }
                }
                if (commonOuterClass$QQUserId2.yes_uid.get() != 0) {
                    if (selfQQUserId != null && (pBUInt64Field7 = selfQQUserId.yes_uid) != null && commonOuterClass$QQUserId2.yes_uid.get() == pBUInt64Field7.get()) {
                        z37 = true;
                    } else {
                        z37 = false;
                    }
                }
                boolean z39 = false;
            }
            CommonOuterClass$QQUserId c16 = this.f376532f.c();
            if (commonOuterClass$QQUserId2.uid.get() != 0) {
                if (c16 != null && (pBUInt64Field2 = c16.uid) != null && commonOuterClass$QQUserId2.uid.get() == pBUInt64Field2.get()) {
                    z18 = true;
                } else {
                    z18 = false;
                }
            }
            if (commonOuterClass$QQUserId2.yes_uid.get() != 0) {
                if (c16 != null && (pBUInt64Field = c16.yes_uid) != null && commonOuterClass$QQUserId2.yes_uid.get() == pBUInt64Field.get()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
            }
            boolean z46 = false;
            if (!z46) {
                Iterator<T> it = this.f376533h.iterator();
                while (true) {
                    if (it.hasNext()) {
                        t18 = it.next();
                        SmobaDataOuterClass$PlayerSettleInfo smobaDataOuterClass$PlayerSettleInfo = (SmobaDataOuterClass$PlayerSettleInfo) t18;
                        if (!com.tencent.timi.game.utils.b.e(commonOuterClass$QQUserId2, Long.valueOf(smobaDataOuterClass$PlayerSettleInfo.uid.get())) && !com.tencent.timi.game.utils.b.e(commonOuterClass$QQUserId2, Long.valueOf(smobaDataOuterClass$PlayerSettleInfo.yes_uid.get()))) {
                            z17 = false;
                        } else {
                            z17 = true;
                        }
                        if (z17) {
                            break;
                        }
                    } else {
                        t18 = (T) null;
                        break;
                    }
                }
                SmobaDataOuterClass$PlayerSettleInfo smobaDataOuterClass$PlayerSettleInfo2 = t18;
                if (smobaDataOuterClass$PlayerSettleInfo2 != null && (pBInt32Field = smobaDataOuterClass$PlayerSettleInfo2.oldmvpscore) != null) {
                    num = Integer.valueOf(pBInt32Field.get());
                } else {
                    num = null;
                }
                commonOuterClass$QQUserId = (CommonOuterClass$QQUserId) t16;
                if (this.f376530d) {
                    CommonOuterClass$QQUserId selfQQUserId2 = this.f376531e.getSelfQQUserId();
                    if (commonOuterClass$QQUserId.uid.get() != 0) {
                        if (selfQQUserId2 != null && (pBUInt64Field6 = selfQQUserId2.uid) != null && commonOuterClass$QQUserId.uid.get() == pBUInt64Field6.get()) {
                            z36 = true;
                        } else {
                            z36 = false;
                        }
                    }
                    if (commonOuterClass$QQUserId.yes_uid.get() != 0) {
                        if (selfQQUserId2 != null && (pBUInt64Field5 = selfQQUserId2.yes_uid) != null && commonOuterClass$QQUserId.yes_uid.get() == pBUInt64Field5.get()) {
                            z29 = true;
                        } else {
                            z29 = false;
                        }
                    }
                    boolean z47 = false;
                }
                CommonOuterClass$QQUserId c17 = this.f376532f.c();
                if (commonOuterClass$QQUserId.uid.get() != 0) {
                    if (c17 != null && (pBUInt64Field4 = c17.uid) != null && commonOuterClass$QQUserId.uid.get() == pBUInt64Field4.get()) {
                        z28 = true;
                    } else {
                        z28 = false;
                    }
                }
                if (commonOuterClass$QQUserId.yes_uid.get() != 0) {
                    if (c17 != null && (pBUInt64Field3 = c17.yes_uid) != null && commonOuterClass$QQUserId.yes_uid.get() == pBUInt64Field3.get()) {
                        z26 = true;
                    } else {
                        z26 = false;
                    }
                }
                z19 = false;
                if (!z19) {
                    Iterator<T> it5 = this.f376533h.iterator();
                    while (true) {
                        if (it5.hasNext()) {
                            t19 = it5.next();
                            SmobaDataOuterClass$PlayerSettleInfo smobaDataOuterClass$PlayerSettleInfo3 = (SmobaDataOuterClass$PlayerSettleInfo) t19;
                            if (!com.tencent.timi.game.utils.b.e(commonOuterClass$QQUserId, Long.valueOf(smobaDataOuterClass$PlayerSettleInfo3.uid.get())) && !com.tencent.timi.game.utils.b.e(commonOuterClass$QQUserId, Long.valueOf(smobaDataOuterClass$PlayerSettleInfo3.yes_uid.get()))) {
                                z27 = false;
                            } else {
                                z27 = true;
                            }
                            if (z27) {
                                break;
                            }
                        } else {
                            t19 = (T) null;
                            break;
                        }
                    }
                    SmobaDataOuterClass$PlayerSettleInfo smobaDataOuterClass$PlayerSettleInfo4 = t19;
                    num2 = (smobaDataOuterClass$PlayerSettleInfo4 == null || (pBInt32Field2 = smobaDataOuterClass$PlayerSettleInfo4.oldmvpscore) == null) ? null : Integer.valueOf(pBInt32Field2.get());
                }
                compareValues = ComparisonsKt__ComparisonsKt.compareValues(num, num2);
                return compareValues;
            }
            num = num2;
            commonOuterClass$QQUserId = (CommonOuterClass$QQUserId) t16;
            if (this.f376530d) {
            }
            CommonOuterClass$QQUserId c172 = this.f376532f.c();
            if (commonOuterClass$QQUserId.uid.get() != 0) {
            }
            if (commonOuterClass$QQUserId.yes_uid.get() != 0) {
            }
            z19 = false;
            if (!z19) {
            }
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(num, num2);
            return compareValues;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/timi/game/component/chat/message/SmobaCapInfoItemView$c", "Lcom/tencent/timi/game/component/chat/message/SmobaCapInfoSubItemView$b;", "Landroid/view/View;", "v", "", NodeProps.ON_CLICK, "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements SmobaCapInfoSubItemView.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.timi.game.tim.api.message.a f376534a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ SmobaCapInfoItemView f376535b;

        c(com.tencent.timi.game.tim.api.message.a aVar, SmobaCapInfoItemView smobaCapInfoItemView) {
            this.f376534a = aVar;
            this.f376535b = smobaCapInfoItemView;
        }

        @Override // com.tencent.timi.game.component.chat.message.SmobaCapInfoSubItemView.b
        public void onClick(@NotNull View v3) {
            Intrinsics.checkNotNullParameter(v3, "v");
            this.f376534a.k("1");
            this.f376535b.I(this.f376534a);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SmobaCapInfoItemView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void P() {
        LinearLayout linearLayout = this.moreInfoLl;
        AvatarRoundImageView avatarRoundImageView = new AvatarRoundImageView(getContext());
        this.avatarViews.add(avatarRoundImageView);
        avatarRoundImageView.setNeedDrawSex(true);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(fh4.b.b(26), fh4.b.b(26));
        layoutParams.leftMargin = fh4.b.b(15);
        Unit unit = Unit.INSTANCE;
        linearLayout.addView(avatarRoundImageView, layoutParams);
    }

    private final void Q() {
        LinearLayout linearLayout = this.subItemLl;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        SmobaCapInfoSubItemView smobaCapInfoSubItemView = new SmobaCapInfoSubItemView(context, null, 0, 6, null);
        this.subItemViews.add(smobaCapInfoSubItemView);
        linearLayout.addView(smobaCapInfoSubItemView, new LinearLayout.LayoutParams(fh4.b.f(this), fh4.b.f(this)));
    }

    private final void R(YoloRoomOuterClass$YoloGiftConfig giftConfig) {
        oh2.a b16;
        um4.k kVar = um4.k.f439239a;
        kVar.c();
        nh2.c d16 = kVar.d();
        if (d16 != null && (b16 = d16.b()) != null) {
            b16.e(giftConfig.gift_material_id.get(), new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(com.tencent.timi.game.tim.api.message.a msg2, SmobaCapInfoItemView this$0, List qqUsers, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(msg2, "$msg");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(qqUsers, "$qqUsers");
        msg2.n(1);
        int i3 = 0;
        fh4.g.o(this$0.moreInfoLl, false);
        fh4.g.o(this$0.moreArrowIv, false);
        for (Object obj : qqUsers) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            fh4.g.o(this$0.subItemViews.get(i3), true);
            i3 = i16;
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x04d0, code lost:
    
        if (((r9 == null || (r10 = r9.uid) == null || r7.uid.get() != r10.get()) ? false : true) == false) goto L184;
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x04f5, code lost:
    
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:236:0x04f3, code lost:
    
        if (((r9 == null || (r9 = r9.yes_uid) == null || r7.yes_uid.get() != r9.get()) ? false : true) != false) goto L194;
     */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0528  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0553  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x055d  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x05ee  */
    @Override // com.tencent.timi.game.component.chat.message.BaseMessageView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void I(@NotNull final com.tencent.timi.game.tim.api.message.a msg2) {
        Object obj;
        Object obj2;
        Object obj3;
        final ArrayList arrayList;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean isBlank;
        PBInt32Field pBInt32Field;
        Object obj4;
        ArrayList arrayList2;
        ArrayList arrayList3;
        int i3;
        PBRepeatMessageField<SmobaDataOuterClass$PlayerSettleInfo> pBRepeatMessageField;
        PBInt32Field pBInt32Field2;
        PBUInt32Field pBUInt32Field;
        PBStringField pBStringField;
        PBInt32Field pBInt32Field3;
        PBInt32Field pBInt32Field4;
        Object obj5;
        Object obj6;
        PBInt32Field pBInt32Field5;
        Intrinsics.checkNotNullParameter(msg2, "msg");
        super.I(msg2);
        YoloRoomOuterClass$YoloRoomInfo roomInfo = getRoomInfo();
        boolean z19 = false;
        boolean z26 = (roomInfo == null || (pBInt32Field5 = roomInfo.room_type) == null || pBInt32Field5.get() != 1) ? false : true;
        boolean y36 = ((sm4.a) mm4.b.b(sm4.a.class)).y3();
        YoloRoomOuterClass$YoloSmobaRoomBattleResultAction action = msg2.a().yolo_room_action_msg.yolo_room_action.yolo_smoba_room_battle_result_action;
        PBRepeatMessageField<SmobaDataOuterClass$GameCampSettleInfo> pBRepeatMessageField2 = action.smoba_battle_result.camp_settle_list;
        this.titleTv.setText(z26 ? "\u4f60\u4eec\u521a\u521a\u7ed3\u675f\u4e86\u4e00\u573a\u6bd4\u8d5b" : "\u5feb\u6765\u56f4\u89c2\u6211\u7684\u6218\u961f\u5427\uff01");
        List<SmobaDataOuterClass$GameCampSettleInfo> list = action.smoba_battle_result.camp_settle_list.get();
        Intrinsics.checkNotNullExpressionValue(list, "action.smoba_battle_result.camp_settle_list.get()");
        Iterator<T> it = list.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it.next();
            List<SmobaDataOuterClass$PlayerSettleInfo> list2 = ((SmobaDataOuterClass$GameCampSettleInfo) obj2).campsettledetail.get();
            Intrinsics.checkNotNullExpressionValue(list2, "list.campsettledetail.get()");
            Iterator<T> it5 = list2.iterator();
            while (true) {
                if (it5.hasNext()) {
                    obj6 = it5.next();
                    if (((SmobaDataOuterClass$PlayerSettleInfo) obj6).uid.get() > 0) {
                        break;
                    }
                } else {
                    obj6 = null;
                    break;
                }
            }
            if (obj6 != null) {
                break;
            }
        }
        SmobaDataOuterClass$GameCampSettleInfo smobaDataOuterClass$GameCampSettleInfo = (SmobaDataOuterClass$GameCampSettleInfo) obj2;
        List<SmobaDataOuterClass$GameCampSettleInfo> list3 = action.smoba_battle_result.camp_settle_list.get();
        Intrinsics.checkNotNullExpressionValue(list3, "action.smoba_battle_result.camp_settle_list.get()");
        Iterator<T> it6 = list3.iterator();
        while (true) {
            if (!it6.hasNext()) {
                obj3 = null;
                break;
            }
            obj3 = it6.next();
            List<SmobaDataOuterClass$PlayerSettleInfo> list4 = ((SmobaDataOuterClass$GameCampSettleInfo) obj3).campsettledetail.get();
            Intrinsics.checkNotNullExpressionValue(list4, "list.campsettledetail.get()");
            Iterator<T> it7 = list4.iterator();
            while (true) {
                if (it7.hasNext()) {
                    obj5 = it7.next();
                    if (((SmobaDataOuterClass$PlayerSettleInfo) obj5).uid.get() > 0) {
                        break;
                    }
                } else {
                    obj5 = null;
                    break;
                }
            }
            if (obj5 == null) {
                break;
            }
        }
        SmobaDataOuterClass$GameCampSettleInfo smobaDataOuterClass$GameCampSettleInfo2 = (SmobaDataOuterClass$GameCampSettleInfo) obj3;
        this.selfKillCountTv.setText(String.valueOf((smobaDataOuterClass$GameCampSettleInfo == null || (pBInt32Field4 = smobaDataOuterClass$GameCampSettleInfo.total_kill_count) == null) ? 0 : pBInt32Field4.get()));
        this.otherKillCountTv.setText(String.valueOf((smobaDataOuterClass$GameCampSettleInfo2 == null || (pBInt32Field3 = smobaDataOuterClass$GameCampSettleInfo2.total_kill_count) == null) ? 0 : pBInt32Field3.get()));
        TextView textView = this.modeTv;
        GameDataServerOuterClass$SmobaGameMode t06 = ((pm4.a) mm4.b.b(pm4.a.class)).t0(action.smoba_battle_result.smoba_config.game_mode.get());
        textView.setText((t06 == null || (pBStringField = t06.mode_name) == null) ? null : pBStringField.get());
        this.timeTv.setText((((smobaDataOuterClass$GameCampSettleInfo == null || (pBUInt32Field = smobaDataOuterClass$GameCampSettleInfo.battle_duration) == null) ? 0 : pBUInt32Field.get()) / 60) + "\u5206\u949f");
        boolean z27 = ((smobaDataOuterClass$GameCampSettleInfo == null || (pBInt32Field2 = smobaDataOuterClass$GameCampSettleInfo.campresult) == null) ? 0 : pBInt32Field2.get()) == 1;
        if (z27) {
            fh4.g.e(fh4.g.c(this.topView, Color.parseColor("#FF6D0E"), Color.parseColor("#FFC57A")), fh4.b.d(15), fh4.b.d(15), 0.0f, 0.0f);
            fh4.g.c(this.middleView, Color.parseColor("#FFC57A"), Color.parseColor("#FFFFFF"));
            this.capResultIv.setImageResource(R.drawable.o9s);
        } else {
            fh4.g.e(fh4.g.c(this.topView, Color.parseColor("#80858F"), Color.parseColor("#B0BBCC")), fh4.b.d(15), fh4.b.d(15), 0.0f, 0.0f);
            fh4.g.c(this.middleView, Color.parseColor("#B0BBCC"), Color.parseColor("#FFFFFF"));
            this.capResultIv.setImageResource(R.drawable.o9b);
        }
        fh4.g.e(fh4.g.c(this.bottomView, Color.parseColor("#FFFFFF"), Color.parseColor("#FFFFFF")), 0.0f, 0.0f, fh4.b.d(15), fh4.b.d(15));
        Iterator<T> it8 = this.subItemViews.iterator();
        while (it8.hasNext()) {
            fh4.g.o((SmobaCapInfoSubItemView) it8.next(), false);
        }
        int i16 = z26 ? 2 : 1;
        ArrayList arrayList4 = new ArrayList();
        List<CommonOuterClass$QQUserId> list5 = action.user_id_list.get();
        Intrinsics.checkNotNullExpressionValue(list5, "action.user_id_list.get()");
        arrayList4.addAll(list5);
        ArrayList arrayList5 = new ArrayList();
        List<SmobaDataOuterClass$PlayerSettleInfo> list6 = (smobaDataOuterClass$GameCampSettleInfo == null || (pBRepeatMessageField = smobaDataOuterClass$GameCampSettleInfo.campsettledetail) == null) ? null : pBRepeatMessageField.get();
        if (list6 == null) {
            list6 = CollectionsKt__CollectionsKt.emptyList();
        }
        arrayList5.addAll(list6);
        if (arrayList4.size() > 1) {
            CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList4, new b(z26, this, msg2, arrayList5));
        }
        int i17 = 0;
        for (Object obj7 : arrayList4) {
            int i18 = i17 + 1;
            if (i17 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            CommonOuterClass$QQUserId commonOuterClass$QQUserId = (CommonOuterClass$QQUserId) obj7;
            Iterator it9 = arrayList5.iterator();
            while (true) {
                if (!it9.hasNext()) {
                    obj4 = null;
                    break;
                }
                obj4 = it9.next();
                SmobaDataOuterClass$PlayerSettleInfo smobaDataOuterClass$PlayerSettleInfo = (SmobaDataOuterClass$PlayerSettleInfo) obj4;
                if ((com.tencent.timi.game.utils.b.e(commonOuterClass$QQUserId, Long.valueOf(smobaDataOuterClass$PlayerSettleInfo.uid.get())) || com.tencent.timi.game.utils.b.e(commonOuterClass$QQUserId, Long.valueOf(smobaDataOuterClass$PlayerSettleInfo.yes_uid.get()))) ? true : z19) {
                    break;
                }
            }
            SmobaDataOuterClass$PlayerSettleInfo smobaDataOuterClass$PlayerSettleInfo2 = (SmobaDataOuterClass$PlayerSettleInfo) obj4;
            if (smobaDataOuterClass$PlayerSettleInfo2 != null) {
                if (i17 < i16) {
                    fh4.g.o(this.subItemViews.get(i17), true);
                }
                String desc = i17 < action.battle_result_text.size() ? action.battle_result_text.get().get(i17) : "";
                SmobaCapInfoSubItemView smobaCapInfoSubItemView = this.subItemViews.get(i17);
                Intrinsics.checkNotNullExpressionValue(action, "action");
                Intrinsics.checkNotNullExpressionValue(desc, "desc");
                CommonOuterClass$QQUserId selfQQUserId = getSelfQQUserId();
                YoloRoomOuterClass$YoloRoomInfo roomInfo2 = getRoomInfo();
                String id5 = msg2.id();
                String str = action.smoba_battle_result.battle_id.get();
                Intrinsics.checkNotNullExpressionValue(str, "action.smoba_battle_result.battle_id.get()");
                arrayList2 = arrayList5;
                arrayList3 = arrayList4;
                i3 = i16;
                smobaCapInfoSubItemView.f(z27, action, commonOuterClass$QQUserId, smobaDataOuterClass$PlayerSettleInfo2, desc, selfQQUserId, roomInfo2, id5, str, getIMessageListener(), new c(msg2, this));
                Unit unit = Unit.INSTANCE;
            } else {
                arrayList2 = arrayList5;
                arrayList3 = arrayList4;
                i3 = i16;
            }
            i16 = i3;
            i17 = i18;
            arrayList5 = arrayList2;
            arrayList4 = arrayList3;
            z19 = false;
        }
        ArrayList arrayList6 = arrayList4;
        int i19 = i16;
        if (arrayList6.size() > i19) {
            fh4.g.o(this.topDividerView, true);
            fh4.g.o(this.moreInfoLl, true);
            fh4.g.o(this.moreArrowIv, true);
            Iterator<T> it10 = this.avatarViews.iterator();
            while (it10.hasNext()) {
                fh4.g.o((AvatarRoundImageView) it10.next(), false);
            }
            arrayList = arrayList6;
            int i26 = 0;
            for (Object obj8 : arrayList.subList(i19, arrayList6.size())) {
                int i27 = i26 + 1;
                if (i26 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                fh4.g.o(this.avatarViews.get(i26), true);
                this.avatarViews.get(i26).setUserId((CommonOuterClass$QQUserId) obj8);
                i26 = i27;
            }
            YoloRoomOuterClass$YoloRoomInfo roomInfo3 = getRoomInfo();
            if (roomInfo3 != null) {
                mm4.a b16 = mm4.b.b(ug4.b.class);
                Intrinsics.checkNotNullExpressionValue(b16, "getService(IReportService::class.java)");
                ug4.b bVar = (ug4.b) b16;
                ImageView imageView = this.moreArrowIv;
                String valueOf = String.valueOf(msg2.id());
                ConcurrentHashMap<String, String> L = YoloRoomUtil.L(roomInfo3);
                L.put("yes_battle_id", action.smoba_battle_result.battle_id.get());
                L.put("yes_battle_result", z27 ? "1" : "0");
                Unit unit2 = Unit.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(L, "getCommonRoomInfoReportP\u20260\")\n                    }");
                b.a.a(bVar, imageView, false, valueOf, "em_yes_chat_record_unfold", L, 2, null);
            }
            z16 = false;
        } else {
            arrayList = arrayList6;
            z16 = false;
            fh4.g.o(this.topDividerView, false);
            fh4.g.o(this.moreInfoLl, false);
            fh4.g.o(this.moreArrowIv, false);
        }
        this.moreArrowIv.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.component.chat.message.am
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SmobaCapInfoItemView.S(com.tencent.timi.game.tim.api.message.a.this, this, arrayList, view);
            }
        });
        if (msg2.m() == 1) {
            fh4.g.o(this.moreInfoLl, z16);
            fh4.g.o(this.moreArrowIv, z16);
            int i28 = 0;
            for (Object obj9 : arrayList) {
                int i29 = i28 + 1;
                if (i28 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                fh4.g.o(this.subItemViews.get(i28), true);
                i28 = i29;
            }
        }
        if (z26 && !y36) {
            Iterator it11 = arrayList.iterator();
            while (true) {
                if (!it11.hasNext()) {
                    break;
                }
                Object next = it11.next();
                CommonOuterClass$QQUserId commonOuterClass$QQUserId2 = (CommonOuterClass$QQUserId) next;
                CommonOuterClass$QQUserId selfQQUserId2 = getSelfQQUserId();
                if (commonOuterClass$QQUserId2.uid.get() != 0) {
                }
                if (commonOuterClass$QQUserId2.yes_uid.get() != 0) {
                }
                boolean z28 = false;
                if (z28) {
                    obj = next;
                    break;
                }
            }
            if (obj != null && !Intrinsics.areEqual("1", msg2.p())) {
                CommonOuterClass$QQUserId selfQQUserId3 = getSelfQQUserId();
                if (!((selfQQUserId3 == null || (pBInt32Field = selfQQUserId3.user_from) == null || pBInt32Field.get() != 4) ? false : true)) {
                    z17 = true;
                    fh4.g.o(this.shareDescTv, z17);
                    if (z17) {
                        this.shareDescTv.setText(z27 ? "\u5206\u4eab\u5230\u5927\u5385\uff0c\u70ab\u8000\u4e00\u4e0b" : "\u5c3d\u529b\u4e86\uff0c\u5feb\u53bb\u5927\u5385\u6c42\u5b89\u6170\u5427");
                    }
                    if (!z26 && action.gift_config.has()) {
                        String str2 = action.gift_room_battle_result_text.get();
                        Intrinsics.checkNotNullExpressionValue(str2, "action.gift_room_battle_result_text.get()");
                        isBlank = StringsKt__StringsJVMKt.isBlank(str2);
                        if (!isBlank) {
                            z18 = true;
                            fh4.g.o(this.giftLl, z18);
                            if (z18) {
                                ViewGroup.LayoutParams layoutParams = this.topView.getLayoutParams();
                                if (layoutParams != null) {
                                    layoutParams.height = fh4.b.b(100);
                                    Unit unit3 = Unit.INSTANCE;
                                }
                                this.contentView.setPadding(0, fh4.b.b(30), 0, 0);
                                if (z27) {
                                    fh4.g.e(fh4.g.c(this.giftLl, Color.parseColor("#1A7E6C67"), Color.parseColor("#66EB4C00")), fh4.b.d(15), fh4.b.d(15), 0.0f, 0.0f);
                                } else {
                                    fh4.g.e(fh4.g.c(this.giftLl, Color.parseColor("#1A68677E"), Color.parseColor("#6668677E")), fh4.b.d(15), fh4.b.d(15), 0.0f, 0.0f);
                                }
                                this.giftDescTv.setText(String.valueOf(action.gift_room_battle_result_text.get()));
                                YoloRoomOuterClass$YoloGiftConfig yoloRoomOuterClass$YoloGiftConfig = action.gift_config.get();
                                Intrinsics.checkNotNullExpressionValue(yoloRoomOuterClass$YoloGiftConfig, "action.gift_config.get()");
                                R(yoloRoomOuterClass$YoloGiftConfig);
                                return;
                            }
                            ViewGroup.LayoutParams layoutParams2 = this.topView.getLayoutParams();
                            if (layoutParams2 != null) {
                                layoutParams2.height = fh4.b.b(70);
                                Unit unit4 = Unit.INSTANCE;
                            }
                            this.contentView.setPadding(0, 0, 0, 0);
                            return;
                        }
                    }
                    z18 = false;
                    fh4.g.o(this.giftLl, z18);
                    if (z18) {
                    }
                }
            }
        }
        z17 = false;
        fh4.g.o(this.shareDescTv, z17);
        if (z17) {
        }
        if (!z26) {
            String str22 = action.gift_room_battle_result_text.get();
            Intrinsics.checkNotNullExpressionValue(str22, "action.gift_room_battle_result_text.get()");
            isBlank = StringsKt__StringsJVMKt.isBlank(str22);
            if (!isBlank) {
            }
        }
        z18 = false;
        fh4.g.o(this.giftLl, z18);
        if (z18) {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SmobaCapInfoItemView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ SmobaCapInfoItemView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SmobaCapInfoItemView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.subItemViews = new ArrayList();
        this.avatarViews = new ArrayList();
        setContentView(R.layout.hwe);
        View findViewById = findViewById(R.id.f164622ac0);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.bottomView)");
        this.bottomView = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.tlp);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.capResultIv)");
        this.capResultIv = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.b9r);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.contentView)");
        this.contentView = (ConstraintLayout) findViewById3;
        View findViewById4 = findViewById(R.id.vo7);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.giftDescTv)");
        this.giftDescTv = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.voa);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.giftIconIv)");
        this.giftIconIv = (ImageView) findViewById5;
        View findViewById6 = findViewById(R.id.voi);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.giftLl)");
        this.giftLl = (LinearLayout) findViewById6;
        View findViewById7 = findViewById(R.id.z6p);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.middleView)");
        this.middleView = (ImageView) findViewById7;
        View findViewById8 = findViewById(R.id.zcr);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.modeTv)");
        this.modeTv = (TextView) findViewById8;
        View findViewById9 = findViewById(R.id.zdq);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(R.id.moreArrowIv)");
        this.moreArrowIv = (ImageView) findViewById9;
        View findViewById10 = findViewById(R.id.zdr);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(R.id.moreInfoLl)");
        this.moreInfoLl = (LinearLayout) findViewById10;
        View findViewById11 = findViewById(R.id.f216001g);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "findViewById(R.id.otherKillCountTv)");
        this.otherKillCountTv = (MediumBoldTextView) findViewById11;
        View findViewById12 = findViewById(R.id.f82844hz);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "findViewById(R.id.selfKillCountTv)");
        this.selfKillCountTv = (MediumBoldTextView) findViewById12;
        View findViewById13 = findViewById(R.id.f84114ld);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "findViewById(R.id.shareDescTv)");
        this.shareDescTv = (TextView) findViewById13;
        View findViewById14 = findViewById(R.id.f8995516);
        Intrinsics.checkNotNullExpressionValue(findViewById14, "findViewById(R.id.subItemLl)");
        this.subItemLl = (LinearLayout) findViewById14;
        View findViewById15 = findViewById(R.id.f97225jt);
        Intrinsics.checkNotNullExpressionValue(findViewById15, "findViewById(R.id.timeTv)");
        this.timeTv = (TextView) findViewById15;
        View findViewById16 = findViewById(R.id.f98175md);
        Intrinsics.checkNotNullExpressionValue(findViewById16, "findViewById(R.id.titleTv)");
        this.titleTv = (TextView) findViewById16;
        View findViewById17 = findViewById(R.id.f99525q1);
        Intrinsics.checkNotNullExpressionValue(findViewById17, "findViewById(R.id.topDividerView)");
        this.topDividerView = findViewById17;
        View findViewById18 = findViewById(R.id.f99675qf);
        Intrinsics.checkNotNullExpressionValue(findViewById18, "findViewById(R.id.topView)");
        this.topView = (ImageView) findViewById18;
        fh4.d.a(this.selfKillCountTv);
        fh4.d.a(this.otherKillCountTv);
        for (int i16 = 0; i16 < 5; i16++) {
            Q();
        }
        for (int i17 = 0; i17 < 4; i17++) {
            P();
        }
    }
}
