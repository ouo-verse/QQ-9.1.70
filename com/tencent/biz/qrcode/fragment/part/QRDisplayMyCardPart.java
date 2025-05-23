package com.tencent.biz.qrcode.fragment.part;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qrcode.fragment.viewmodel.QRDisplayMyCardViewModel;
import com.tencent.biz.qrcode.util.QRCodeLoadingComponent;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.proavatar.e;
import com.tencent.mobileqq.profilecard.base.utils.LongClickCopyAction;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.pendant.api.ISpecialShapeAvatarMaskLayer;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qcircle.weseevideo.model.utils.LocaleUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.MaxHeightRelativelayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u00aa\u00012\u00020\u0001:\u0002\u00ab\u0001B\t\u00a2\u0006\u0006\b\u00a8\u0001\u0010\u00a9\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J_\u0010\u0011\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\nH\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0013\u001a\u00020\u0004H\u0002J\b\u0010\u0014\u001a\u00020\u0002H\u0002J\b\u0010\u0015\u001a\u00020\u0002H\u0002J\b\u0010\u0016\u001a\u00020\u0002H\u0002J\u0010\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H\u0003J\b\u0010\u001a\u001a\u00020\u0002H\u0002J\b\u0010\u001b\u001a\u00020\u0002H\u0002J\u0010\u0010\u001c\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010!\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001fH\u0002J\u0018\u0010$\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\"2\u0006\u0010 \u001a\u00020\u001fH\u0002J\u0018\u0010'\u001a\u00020\u00022\u0006\u0010&\u001a\u00020%2\u0006\u0010 \u001a\u00020\u001fH\u0002J\u0012\u0010)\u001a\u00020\u00022\b\u0010(\u001a\u0004\u0018\u00010\bH\u0017R\"\u00101\u001a\u00020*8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00108\u001a\u00020\b8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u0010?\u001a\u00020\u001d8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\"\u0010G\u001a\u00020@8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\"\u0010N\u001a\u00020\"8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\"\u0010#\u001a\u00020\"8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bO\u0010I\u001a\u0004\bP\u0010K\"\u0004\bQ\u0010MR\"\u0010&\u001a\u00020%8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\"\u0010_\u001a\u00020X8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\"\u0010c\u001a\u00020*8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b`\u0010,\u001a\u0004\ba\u0010.\"\u0004\bb\u00100R\"\u0010g\u001a\u00020*8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bd\u0010,\u001a\u0004\be\u0010.\"\u0004\bf\u00100R\"\u0010k\u001a\u00020*8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bh\u0010,\u001a\u0004\bi\u0010.\"\u0004\bj\u00100R\"\u0010o\u001a\u00020\"8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bl\u0010I\u001a\u0004\bm\u0010K\"\u0004\bn\u0010MR\"\u0010s\u001a\u00020\u001d8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bp\u0010:\u001a\u0004\bq\u0010<\"\u0004\br\u0010>R\"\u0010w\u001a\u00020\"8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bt\u0010I\u001a\u0004\bu\u0010K\"\u0004\bv\u0010MR\"\u0010{\u001a\u00020@8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bx\u0010B\u001a\u0004\by\u0010D\"\u0004\bz\u0010FR\"\u0010\u007f\u001a\u00020\"8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b|\u0010I\u001a\u0004\b}\u0010K\"\u0004\b~\u0010MR*\u0010\u0087\u0001\u001a\u00030\u0080\u00018\u0006@\u0006X\u0086.\u00a2\u0006\u0018\n\u0006\b\u0081\u0001\u0010\u0082\u0001\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001\"\u0006\b\u0085\u0001\u0010\u0086\u0001R&\u0010\u008b\u0001\u001a\u00020X8\u0006@\u0006X\u0086.\u00a2\u0006\u0015\n\u0005\b\u0088\u0001\u0010Z\u001a\u0005\b\u0089\u0001\u0010\\\"\u0005\b\u008a\u0001\u0010^R&\u0010\u008f\u0001\u001a\u00020X8\u0006@\u0006X\u0086.\u00a2\u0006\u0015\n\u0005\b\u008c\u0001\u0010Z\u001a\u0005\b\u008d\u0001\u0010\\\"\u0005\b\u008e\u0001\u0010^R&\u0010\u0093\u0001\u001a\u00020\b8\u0006@\u0006X\u0086.\u00a2\u0006\u0015\n\u0005\b\u0090\u0001\u00103\u001a\u0005\b\u0091\u0001\u00105\"\u0005\b\u0092\u0001\u00107R&\u0010\u0097\u0001\u001a\u00020\b8\u0006@\u0006X\u0086.\u00a2\u0006\u0015\n\u0005\b\u0094\u0001\u00103\u001a\u0005\b\u0095\u0001\u00105\"\u0005\b\u0096\u0001\u00107R&\u0010\u009b\u0001\u001a\u00020*8\u0006@\u0006X\u0086.\u00a2\u0006\u0015\n\u0005\b\u0098\u0001\u0010,\u001a\u0005\b\u0099\u0001\u0010.\"\u0005\b\u009a\u0001\u00100R&\u0010\u009f\u0001\u001a\u00020\"8\u0006@\u0006X\u0086.\u00a2\u0006\u0015\n\u0005\b\u009c\u0001\u0010I\u001a\u0005\b\u009d\u0001\u0010K\"\u0005\b\u009e\u0001\u0010MR*\u0010\u00a7\u0001\u001a\u00030\u00a0\u00018\u0006@\u0006X\u0086.\u00a2\u0006\u0018\n\u0006\b\u00a1\u0001\u0010\u00a2\u0001\u001a\u0006\b\u00a3\u0001\u0010\u00a4\u0001\"\u0006\b\u00a5\u0001\u0010\u00a6\u0001\u00a8\u0006\u00ac\u0001"}, d2 = {"Lcom/tencent/biz/qrcode/fragment/part/QRDisplayMyCardPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "I9", "", "scaleRatio", "Aa", "za", "Landroid/view/View;", "view", "", "width", "height", "marginStart", NodeProps.MARGIN_TOP, "marginEnd", NodeProps.MARGIN_BOTTOM, "Ba", "(Landroid/view/View;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "K9", "initData", "xa", "bb", "Landroid/content/Context;", "context", "ua", "ma", "ta", "wa", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "avatarView", "", "uin", "na", "Landroid/widget/TextView;", "uinText", "va", "Lcom/tencent/biz/qrcode/util/QRCodeLoadingComponent;", CommonConstant.KEY_QR_CODE, "X9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/widget/RelativeLayout;", "d", "Landroid/widget/RelativeLayout;", "Y9", "()Landroid/widget/RelativeLayout;", "Pa", "(Landroid/widget/RelativeLayout;)V", "mCardPart", "e", "Landroid/view/View;", "Z9", "()Landroid/view/View;", "Qa", "(Landroid/view/View;)V", "myCardRoot", "f", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "W9", "()Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "Oa", "(Lcom/tencent/mobileqq/proavatar/QQProAvatarView;)V", "avatar", "Lcom/tencent/widget/MaxHeightRelativelayout;", tl.h.F, "Lcom/tencent/widget/MaxHeightRelativelayout;", "ga", "()Lcom/tencent/widget/MaxHeightRelativelayout;", "Wa", "(Lcom/tencent/widget/MaxHeightRelativelayout;)V", "normalNickMaxHeight", "i", "Landroid/widget/TextView;", "aa", "()Landroid/widget/TextView;", "Ra", "(Landroid/widget/TextView;)V", "nameText", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, LocaleUtils.L_JAPANESE, "Za", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/biz/qrcode/util/QRCodeLoadingComponent;", "ia", "()Lcom/tencent/biz/qrcode/util/QRCodeLoadingComponent;", "Ya", "(Lcom/tencent/biz/qrcode/util/QRCodeLoadingComponent;)V", "Landroidx/cardview/widget/CardView;", "D", "Landroidx/cardview/widget/CardView;", "da", "()Landroidx/cardview/widget/CardView;", "Ua", "(Landroidx/cardview/widget/CardView;)V", "normalCardView", "E", "ba", "Sa", "normCardLayout", UserInfo.SEX_FEMALE, "ca", "Ta", "normProfileContainer", "G", "ea", "Va", "normalLayout", "H", "ha", "Xa", "normalTips", "I", "L9", "Da", "aigcAvatar", "J", "R9", "Ja", "aigcNameText", "K", "S9", "Ka", "aigcNickMaxHeight", "L", "V9", "Na", "aigcUinText", "Landroid/widget/ImageView;", "M", "Landroid/widget/ImageView;", "P9", "()Landroid/widget/ImageView;", "Ha", "(Landroid/widget/ImageView;)V", "aigcImage", "N", "Q9", "Ia", "aigcImageCardView", "P", "O9", "Ga", "aigcCardView", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "M9", "Ea", "aigcCardContentContainer", BdhLogUtil.LogTag.Tag_Req, "T9", "La", "aigcProfileContainer", ExifInterface.LATITUDE_SOUTH, "N9", "Fa", "aigcCardLayout", "T", "U9", "Ma", "aigcTips", "Lcom/tencent/biz/qrcode/fragment/viewmodel/QRDisplayMyCardViewModel;", "U", "Lcom/tencent/biz/qrcode/fragment/viewmodel/QRDisplayMyCardViewModel;", "la", "()Lcom/tencent/biz/qrcode/fragment/viewmodel/QRDisplayMyCardViewModel;", "ab", "(Lcom/tencent/biz/qrcode/fragment/viewmodel/QRDisplayMyCardViewModel;)V", "viewModel", "<init>", "()V", "V", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class QRDisplayMyCardPart extends Part {

    /* renamed from: C, reason: from kotlin metadata */
    public QRCodeLoadingComponent qrCode;

    /* renamed from: D, reason: from kotlin metadata */
    public CardView normalCardView;

    /* renamed from: E, reason: from kotlin metadata */
    public RelativeLayout normCardLayout;

    /* renamed from: F, reason: from kotlin metadata */
    public RelativeLayout normProfileContainer;

    /* renamed from: G, reason: from kotlin metadata */
    public RelativeLayout normalLayout;

    /* renamed from: H, reason: from kotlin metadata */
    public TextView normalTips;

    /* renamed from: I, reason: from kotlin metadata */
    public QQProAvatarView aigcAvatar;

    /* renamed from: J, reason: from kotlin metadata */
    public TextView aigcNameText;

    /* renamed from: K, reason: from kotlin metadata */
    public MaxHeightRelativelayout aigcNickMaxHeight;

    /* renamed from: L, reason: from kotlin metadata */
    public TextView aigcUinText;

    /* renamed from: M, reason: from kotlin metadata */
    public ImageView aigcImage;

    /* renamed from: N, reason: from kotlin metadata */
    public CardView aigcImageCardView;

    /* renamed from: P, reason: from kotlin metadata */
    public CardView aigcCardView;

    /* renamed from: Q, reason: from kotlin metadata */
    public View aigcCardContentContainer;

    /* renamed from: R, reason: from kotlin metadata */
    public View aigcProfileContainer;

    /* renamed from: S, reason: from kotlin metadata */
    public RelativeLayout aigcCardLayout;

    /* renamed from: T, reason: from kotlin metadata */
    public TextView aigcTips;

    /* renamed from: U, reason: from kotlin metadata */
    public QRDisplayMyCardViewModel viewModel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public RelativeLayout mCardPart;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public View myCardRoot;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public QQProAvatarView avatar;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public MaxHeightRelativelayout normalNickMaxHeight;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public TextView nameText;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public TextView uinText;

    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J@\u0010\u000e\u001a\u00020\f26\u0010\r\u001a2\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007H\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/biz/qrcode/fragment/part/QRDisplayMyCardPart$b", "Lcom/tencent/biz/qrcode/util/QRCodeLoadingComponent$b;", "", "d", "c", "", "e", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "isSuccess", "chain", "", "cb", "b", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public static final class b extends QRCodeLoadingComponent.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f94861a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ QRDisplayMyCardPart f94862b;

        b(String str, QRDisplayMyCardPart qRDisplayMyCardPart) {
            this.f94861a = str;
            this.f94862b = qRDisplayMyCardPart;
        }

        @Override // com.tencent.biz.qrcode.util.QRCodeLoadingComponent.b
        public void b(@NotNull Function2<? super Boolean, ? super String, Unit> cb5) {
            Intrinsics.checkNotNullParameter(cb5, "cb");
            this.f94862b.la().D2();
        }

        @Override // com.tencent.biz.qrcode.util.QRCodeLoadingComponent.b
        @NotNull
        /* renamed from: c, reason: from getter */
        public String getF94861a() {
            return this.f94861a;
        }

        @Override // com.tencent.biz.qrcode.util.QRCodeLoadingComponent.b
        @NotNull
        public String d() {
            return "QRDisplayMyCardPart";
        }

        @Override // com.tencent.biz.qrcode.util.QRCodeLoadingComponent.b
        public boolean e() {
            return false;
        }
    }

    private final void Aa(float scaleRatio) {
        Ca(this, da(), Integer.valueOf((int) Math.ceil(ViewUtils.dpToPx(348.0f) * scaleRatio)), Integer.valueOf((int) Math.ceil(ViewUtils.dpToPx(521.0f) * scaleRatio)), null, null, null, null, 120, null);
        da().setRadius(ViewUtils.dpToPx(16.0f) * scaleRatio);
        Ba(ca(), -1, Integer.valueOf((int) Math.ceil(ViewUtils.dpToPx(70.0f) * scaleRatio)), Integer.valueOf((int) Math.ceil(ViewUtils.dpToPx(30.0f) * scaleRatio)), Integer.valueOf((int) Math.ceil(ViewUtils.dpToPx(38.0f) * scaleRatio)), Integer.valueOf((int) Math.ceil(ViewUtils.dpToPx(30.0f) * scaleRatio)), Integer.valueOf((int) Math.ceil(ViewUtils.dpToPx(38.0f) * scaleRatio)));
        Ca(this, W9(), Integer.valueOf((int) Math.ceil(ViewUtils.dpToPx(70.0f) * scaleRatio)), Integer.valueOf((int) Math.ceil(ViewUtils.dpToPx(70.0f) * scaleRatio)), null, null, null, null, 120, null);
        aa().setTextSize(scaleRatio * 22.0f);
        Ca(this, aa(), null, null, Integer.valueOf((int) Math.ceil(ViewUtils.dpToPx(22.0f) * scaleRatio)), null, null, null, 112, null);
        ga().setMaxHeight(ViewUtils.dpToPx(35.0f));
        ja().setTextSize(16.0f * scaleRatio);
        Ca(this, ja(), null, null, Integer.valueOf((int) Math.ceil(ViewUtils.dpToPx(22.0f) * scaleRatio)), Integer.valueOf((int) Math.ceil(ViewUtils.dpToPx(4.0f) * scaleRatio)), null, null, 96, null);
        Ca(this, ia(), Integer.valueOf((int) Math.ceil(ViewUtils.dpToPx(286.0f) * scaleRatio)), Integer.valueOf((int) Math.ceil(ViewUtils.dpToPx(286.0f) * scaleRatio)), null, null, null, null, 120, null);
        ha().setTextSize(14.0f * scaleRatio);
        Ca(this, ha(), null, null, null, Integer.valueOf((int) Math.ceil(ViewUtils.dpToPx(32.0f) * scaleRatio)), null, null, 96, null);
    }

    private final void Ba(View view, Integer width, Integer height, Integer marginStart, Integer marginTop, Integer marginEnd, Integer marginBottom) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams == null) {
            return;
        }
        if (width != null && height != null) {
            marginLayoutParams.width = width.intValue();
            marginLayoutParams.height = height.intValue();
        }
        if (marginStart != null) {
            marginLayoutParams.setMarginStart(marginStart.intValue());
        }
        if (marginTop != null) {
            marginLayoutParams.topMargin = marginTop.intValue();
        }
        if (marginEnd != null) {
            marginLayoutParams.setMarginEnd(marginEnd.intValue());
        }
        if (marginBottom != null) {
            marginLayoutParams.bottomMargin = marginBottom.intValue();
        }
        view.setLayoutParams(marginLayoutParams);
    }

    static /* synthetic */ void Ca(QRDisplayMyCardPart qRDisplayMyCardPart, View view, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, Integer num6, int i3, Object obj) {
        Integer num7;
        Integer num8;
        Integer num9;
        Integer num10;
        Integer num11;
        Integer num12 = null;
        if ((i3 & 2) != 0) {
            num7 = null;
        } else {
            num7 = num;
        }
        if ((i3 & 4) != 0) {
            num8 = null;
        } else {
            num8 = num2;
        }
        if ((i3 & 8) != 0) {
            num9 = null;
        } else {
            num9 = num3;
        }
        if ((i3 & 16) != 0) {
            num10 = null;
        } else {
            num10 = num4;
        }
        if ((i3 & 32) != 0) {
            num11 = null;
        } else {
            num11 = num5;
        }
        if ((i3 & 64) == 0) {
            num12 = num6;
        }
        qRDisplayMyCardPart.Ba(view, num7, num8, num9, num10, num11, num12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I9() {
        Y9().post(new Runnable() { // from class: com.tencent.biz.qrcode.fragment.part.p
            @Override // java.lang.Runnable
            public final void run() {
                QRDisplayMyCardPart.J9(QRDisplayMyCardPart.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J9(QRDisplayMyCardPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        float K9 = this$0.K9();
        if (K9 >= 0.0f && K9 <= 1.0f) {
            QLog.i("QRDisplayMyCardPart", 1, "adjustCard scaleRatio=" + K9);
            if (this$0.la().x2()) {
                this$0.za(K9);
            } else {
                this$0.Aa(K9);
            }
        }
    }

    private final float K9() {
        int dpToPx;
        int dpToPx2;
        int coerceAtMost;
        int coerceAtMost2;
        float coerceAtMost3;
        int width = Z9().getWidth();
        int height = Z9().getHeight();
        if (width <= 0 || height <= 0) {
            return 1.0f;
        }
        if (la().x2()) {
            dpToPx = ViewUtils.dpToPx(348.0f);
            dpToPx2 = ViewUtils.dpToPx(610.0f);
        } else {
            dpToPx = ViewUtils.dpToPx(348.0f);
            dpToPx2 = ViewUtils.dpToPx(521.0f);
        }
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(ViewUtils.dpToPx(50.0f), 50);
        coerceAtMost2 = RangesKt___RangesKt.coerceAtMost(ViewUtils.dpToPx(40.0f), 40);
        int i3 = width - (coerceAtMost * 2);
        int i16 = height - (coerceAtMost2 * 2);
        if (dpToPx > i3 || dpToPx2 > i16) {
            coerceAtMost3 = RangesKt___RangesKt.coerceAtMost(i3 / dpToPx, i16 / dpToPx2);
            return coerceAtMost3;
        }
        return 1.0f;
    }

    private final void X9(QRCodeLoadingComponent qrCode, String uin) {
        qrCode.setGetChainProcess(new b(uin, this));
        qrCode.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void bb() {
        Unit unit;
        QLog.i("QRDisplayMyCardPart", 1, "shotNormalCard");
        ia().z();
        Bitmap createBitmap = Bitmap.createBitmap(ia().getWidth(), ia().getHeight(), Bitmap.Config.ARGB_8888);
        ia().draw(new Canvas(createBitmap));
        if (createBitmap != null) {
            la().g2().postValue(createBitmap);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            QLog.i("QRDisplayMyCardPart", 1, "cardBitmap is null");
        }
    }

    private final void initData() {
        QBaseActivity qBaseActivity = (QBaseActivity) getActivity();
        if (qBaseActivity != null) {
            aa().setText(la().getCurName());
            R9().setText(la().getCurName());
            String curUin = la().getCurUin();
            if (curUin != null) {
                na(W9(), curUin);
                va(ja(), curUin);
                X9(ia(), curUin);
                na(L9(), curUin);
                va(V9(), curUin);
            }
            MutableLiveData<Boolean> v3 = ia().v();
            final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.biz.qrcode.fragment.part.QRDisplayMyCardPart$initData$1$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke2(bool);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Boolean it) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    if (it.booleanValue()) {
                        QRDisplayMyCardPart.this.ia().A();
                    }
                }
            };
            v3.observe(qBaseActivity, new Observer() { // from class: com.tencent.biz.qrcode.fragment.part.k
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QRDisplayMyCardPart.ra(Function1.this, obj);
                }
            });
            MutableLiveData<Boolean> s26 = la().s2();
            final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.biz.qrcode.fragment.part.QRDisplayMyCardPart$initData$1$3
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke2(bool);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Boolean bool) {
                    if (QRDisplayMyCardPart.this.la().x2()) {
                        QRDisplayMyCardPart qRDisplayMyCardPart = QRDisplayMyCardPart.this;
                        qRDisplayMyCardPart.wa(qRDisplayMyCardPart.M9());
                    } else {
                        QRDisplayMyCardPart qRDisplayMyCardPart2 = QRDisplayMyCardPart.this;
                        qRDisplayMyCardPart2.wa(qRDisplayMyCardPart2.ba());
                        QRDisplayMyCardPart.this.ia().C();
                    }
                    QRDisplayMyCardPart.this.la().r2().postValue(null);
                }
            };
            s26.observe(qBaseActivity, new Observer() { // from class: com.tencent.biz.qrcode.fragment.part.l
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QRDisplayMyCardPart.sa(Function1.this, obj);
                }
            });
            MutableLiveData<Boolean> y26 = la().y2();
            final Function1<Boolean, Unit> function13 = new Function1<Boolean, Unit>() { // from class: com.tencent.biz.qrcode.fragment.part.QRDisplayMyCardPart$initData$1$4
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke2(bool);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Boolean it) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    if (it.booleanValue()) {
                        QRDisplayMyCardPart.this.la().y2().postValue(Boolean.FALSE);
                        QRDisplayMyCardPart.this.I9();
                    }
                }
            };
            y26.observe(qBaseActivity, new Observer() { // from class: com.tencent.biz.qrcode.fragment.part.m
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QRDisplayMyCardPart.oa(Function1.this, obj);
                }
            });
            MutableLiveData<com.tencent.biz.qrcode.mgr.d> p26 = la().p2();
            final Function1<com.tencent.biz.qrcode.mgr.d, Unit> function14 = new Function1<com.tencent.biz.qrcode.mgr.d, Unit>() { // from class: com.tencent.biz.qrcode.fragment.part.QRDisplayMyCardPart$initData$1$5
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(com.tencent.biz.qrcode.mgr.d dVar) {
                    invoke2(dVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable com.tencent.biz.qrcode.mgr.d dVar) {
                    if (dVar != null) {
                        QRDisplayMyCardPart qRDisplayMyCardPart = QRDisplayMyCardPart.this;
                        qRDisplayMyCardPart.xa();
                        qRDisplayMyCardPart.la().r2().postValue(null);
                    }
                }
            };
            p26.observe(qBaseActivity, new Observer() { // from class: com.tencent.biz.qrcode.fragment.part.n
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QRDisplayMyCardPart.pa(Function1.this, obj);
                }
            });
            MutableLiveData<Boolean> h26 = la().h2();
            final Function1<Boolean, Unit> function15 = new Function1<Boolean, Unit>() { // from class: com.tencent.biz.qrcode.fragment.part.QRDisplayMyCardPart$initData$1$6
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke2(bool);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Boolean it) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    if (it.booleanValue()) {
                        QRDisplayMyCardPart.this.bb();
                        QRDisplayMyCardPart.this.la().h2().postValue(Boolean.FALSE);
                    }
                }
            };
            h26.observe(qBaseActivity, new Observer() { // from class: com.tencent.biz.qrcode.fragment.part.o
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    QRDisplayMyCardPart.qa(Function1.this, obj);
                }
            });
        }
    }

    private final void ma() {
        if (this.myCardRoot == null) {
            return;
        }
        View findViewById = Z9().findViewById(R.id.f646336r);
        Intrinsics.checkNotNullExpressionValue(findViewById, "myCardRoot.findViewById(R.id.qr_code_aigc_layout)");
        Fa((RelativeLayout) findViewById);
        View findViewById2 = Z9().findViewById(R.id.f646036o);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "myCardRoot.findViewById(\u2026d.qr_code_aigc_card_view)");
        Ga((CardView) findViewById2);
        View findViewById3 = Z9().findViewById(R.id.y66);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "myCardRoot.findViewById(R.id.iv_my_head_aigc)");
        Da((QQProAvatarView) findViewById3);
        View findViewById4 = Z9().findViewById(R.id.f109546g4);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "myCardRoot.findViewById(R.id.tv_nickName_aigc)");
        Ja((TextView) findViewById4);
        View findViewById5 = Z9().findViewById(R.id.zr5);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "myCardRoot.findViewById(R.id.nick_max_height_aigc)");
        Ka((MaxHeightRelativelayout) findViewById5);
        View findViewById6 = Z9().findViewById(R.id.f112176n8);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "myCardRoot.findViewById(R.id.tv_uin_aigc)");
        Na((TextView) findViewById6);
        View findViewById7 = Z9().findViewById(R.id.f646236q);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "myCardRoot.findViewById(R.id.qr_code_aigc_image)");
        Ha((ImageView) findViewById7);
        View findViewById8 = Z9().findViewById(R.id.f645736l);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "myCardRoot.findViewById(\u2026.qr_aigc_image_card_view)");
        Ia((CardView) findViewById8);
        View findViewById9 = Z9().findViewById(R.id.f646136p);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "myCardRoot.findViewById(\u2026e_aigc_content_container)");
        Ea(findViewById9);
        View findViewById10 = Z9().findViewById(R.id.f646536t);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "myCardRoot.findViewById(\u2026e_aigc_profile_container)");
        La(findViewById10);
        View findViewById11 = Z9().findViewById(R.id.f111956mm);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "myCardRoot.findViewById(R.id.tv_tips_aigc)");
        Ma((TextView) findViewById11);
        wa(M9());
    }

    private final void na(QQProAvatarView avatarView, String uin) {
        avatarView.x(1, uin, new e.a(0, false, false, false, 0, false, 0, 0, null, false, false, 0, null, null, 0, 32767, null).e(!((ISpecialShapeAvatarMaskLayer) QRoute.api(ISpecialShapeAvatarMaskLayer.class)).isSpecialShapeAvatar(uin)).g(200).a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void oa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void qa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ra(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void ta() {
        if (this.myCardRoot == null) {
            return;
        }
        View findViewById = Z9().findViewById(R.id.y67);
        Intrinsics.checkNotNullExpressionValue(findViewById, "myCardRoot.findViewById(R.id.iv_my_head_short)");
        Oa((QQProAvatarView) findViewById);
        View findViewById2 = Z9().findViewById(R.id.f109556g5);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "myCardRoot.findViewById(R.id.tv_nickName_short)");
        Ra((TextView) findViewById2);
        View findViewById3 = Z9().findViewById(R.id.zr6);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "myCardRoot.findViewById(\u2026d.nick_max_height_normal)");
        Wa((MaxHeightRelativelayout) findViewById3);
        View findViewById4 = Z9().findViewById(R.id.f112186n9);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "myCardRoot.findViewById(R.id.tv_uin_short)");
        Za((TextView) findViewById4);
        View findViewById5 = Z9().findViewById(R.id.y7k);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "myCardRoot.findViewById(R.id.iv_qr_code_short)");
        Ya((QRCodeLoadingComponent) findViewById5);
        View findViewById6 = Z9().findViewById(R.id.f6474372);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "myCardRoot.findViewById(\u2026qr_code_normal_card_view)");
        Ua((CardView) findViewById6);
        View findViewById7 = Z9().findViewById(R.id.f6475373);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "myCardRoot.findViewById(\u2026id.qr_code_normal_layout)");
        Va((RelativeLayout) findViewById7);
        View findViewById8 = Z9().findViewById(R.id.f6476374);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "myCardRoot.findViewById(\u2026normal_profile_container)");
        Ta((RelativeLayout) findViewById8);
        View findViewById9 = Z9().findViewById(R.id.f6473371);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "myCardRoot.findViewById(\u2026_code_normal_card_layout)");
        Sa((RelativeLayout) findViewById9);
        View findViewById10 = Z9().findViewById(R.id.f109486fy);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "myCardRoot.findViewById(\u2026id.tv_my_card_tips_short)");
        Xa((TextView) findViewById10);
        wa(ba());
    }

    @SuppressLint({"InflateParams"})
    private final void ua(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.fxs, (ViewGroup) Y9(), true);
        if (inflate == null) {
            return;
        }
        Qa(inflate);
        ta();
        ma();
        I9();
    }

    private final void va(TextView uinText, String uin) {
        uinText.setText(String.format(HardCodeUtil.qqStr(R.string.f171509fq0), uin));
        uinText.setContentDescription(HardCodeUtil.qqStr(R.string.f216565yn));
        String qqStr = HardCodeUtil.qqStr(R.string.f1790338_);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.qb_qrcode_copy_my_uin)");
        LongClickCopyAction attachCopyAction = LongClickCopyAction.attachCopyAction(uinText, qqStr, uin);
        if (attachCopyAction != null) {
            attachCopyAction.setCopyListener(new c());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void wa(final View view) {
        if (!QQTheme.isVasTheme()) {
            Context context = getContext();
            if (context != null) {
                view.setBackgroundColor(context.getColor(R.color.qui_common_fill_light_secondary));
                return;
            }
            return;
        }
        Context context2 = getContext();
        if (context2 != null) {
            la().A2(context2, new Function1<Boolean, Unit>() { // from class: com.tencent.biz.qrcode.fragment.part.QRDisplayMyCardPart$refreshBg$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16) {
                    view.setBackgroundColor(this.la().u2(z16));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void xa() {
        String shortChain;
        Bitmap bitmap;
        if (la().x2()) {
            ea().setVisibility(8);
            ImageView P9 = P9();
            com.tencent.biz.qrcode.mgr.d value = la().p2().getValue();
            if (value != null) {
                bitmap = value.getCom.tencent.mobileqq.activity.photo.MimeHelper.IMAGE_SUBTYPE_BITMAP java.lang.String();
            } else {
                bitmap = null;
            }
            P9.setImageBitmap(bitmap);
            N9().setVisibility(0);
            wa(M9());
        } else {
            N9().setVisibility(8);
            ea().setVisibility(0);
            com.tencent.biz.qrcode.mgr.d value2 = la().p2().getValue();
            if (value2 != null && (shortChain = value2.getShortChain()) != null) {
                ia().setChain(shortChain, true);
            }
            wa(ba());
        }
        I9();
    }

    private final void za(float scaleRatio) {
        Ca(this, O9(), Integer.valueOf((int) Math.ceil(ViewUtils.dpToPx(348.0f) * scaleRatio)), Integer.valueOf((int) Math.ceil(ViewUtils.dpToPx(610.0f) * scaleRatio)), null, null, null, null, 120, null);
        O9().setRadius(ViewUtils.dpToPx(16.0f) * scaleRatio);
        Ba(T9(), -1, Integer.valueOf((int) Math.ceil(ViewUtils.dpToPx(50.0f) * scaleRatio)), Integer.valueOf((int) Math.ceil(ViewUtils.dpToPx(20.0f) * scaleRatio)), Integer.valueOf((int) Math.ceil(ViewUtils.dpToPx(20.0f) * scaleRatio)), Integer.valueOf((int) Math.ceil(ViewUtils.dpToPx(20.0f) * scaleRatio)), Integer.valueOf((int) Math.ceil(ViewUtils.dpToPx(18.0f) * scaleRatio)));
        Ca(this, L9(), Integer.valueOf((int) Math.ceil(ViewUtils.dpToPx(50.0f) * scaleRatio)), Integer.valueOf((int) Math.ceil(ViewUtils.dpToPx(50.0f) * scaleRatio)), null, null, null, null, 120, null);
        R9().setTextSize(18.0f * scaleRatio);
        Ca(this, R9(), null, null, Integer.valueOf((int) Math.ceil(ViewUtils.dpToPx(12.0f) * scaleRatio)), null, null, null, 112, null);
        S9().setMaxHeight(ViewUtils.dpToPx(25.0f));
        V9().setTextSize(14.0f * scaleRatio);
        Ca(this, V9(), null, null, Integer.valueOf((int) Math.ceil(ViewUtils.dpToPx(12.0f) * scaleRatio)), Integer.valueOf((int) Math.ceil(ViewUtils.dpToPx(5.0f) * scaleRatio)), null, null, 96, null);
        Ca(this, Q9(), Integer.valueOf((int) Math.ceil(ViewUtils.dpToPx(348.0f) * scaleRatio)), Integer.valueOf((int) Math.ceil(ViewUtils.dpToPx(522.0f) * scaleRatio)), null, null, null, null, 120, null);
        Q9().setRadius(ViewUtils.dpToPx(16.0f) * scaleRatio);
        U9().setTextSize(12.0f * scaleRatio);
    }

    public final void Da(@NotNull QQProAvatarView qQProAvatarView) {
        Intrinsics.checkNotNullParameter(qQProAvatarView, "<set-?>");
        this.aigcAvatar = qQProAvatarView;
    }

    public final void Ea(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.aigcCardContentContainer = view;
    }

    public final void Fa(@NotNull RelativeLayout relativeLayout) {
        Intrinsics.checkNotNullParameter(relativeLayout, "<set-?>");
        this.aigcCardLayout = relativeLayout;
    }

    public final void Ga(@NotNull CardView cardView) {
        Intrinsics.checkNotNullParameter(cardView, "<set-?>");
        this.aigcCardView = cardView;
    }

    public final void Ha(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.aigcImage = imageView;
    }

    public final void Ia(@NotNull CardView cardView) {
        Intrinsics.checkNotNullParameter(cardView, "<set-?>");
        this.aigcImageCardView = cardView;
    }

    public final void Ja(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.aigcNameText = textView;
    }

    public final void Ka(@NotNull MaxHeightRelativelayout maxHeightRelativelayout) {
        Intrinsics.checkNotNullParameter(maxHeightRelativelayout, "<set-?>");
        this.aigcNickMaxHeight = maxHeightRelativelayout;
    }

    @NotNull
    public final QQProAvatarView L9() {
        QQProAvatarView qQProAvatarView = this.aigcAvatar;
        if (qQProAvatarView != null) {
            return qQProAvatarView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("aigcAvatar");
        return null;
    }

    public final void La(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.aigcProfileContainer = view;
    }

    @NotNull
    public final View M9() {
        View view = this.aigcCardContentContainer;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("aigcCardContentContainer");
        return null;
    }

    public final void Ma(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.aigcTips = textView;
    }

    @NotNull
    public final RelativeLayout N9() {
        RelativeLayout relativeLayout = this.aigcCardLayout;
        if (relativeLayout != null) {
            return relativeLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("aigcCardLayout");
        return null;
    }

    public final void Na(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.aigcUinText = textView;
    }

    @NotNull
    public final CardView O9() {
        CardView cardView = this.aigcCardView;
        if (cardView != null) {
            return cardView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("aigcCardView");
        return null;
    }

    public final void Oa(@NotNull QQProAvatarView qQProAvatarView) {
        Intrinsics.checkNotNullParameter(qQProAvatarView, "<set-?>");
        this.avatar = qQProAvatarView;
    }

    @NotNull
    public final ImageView P9() {
        ImageView imageView = this.aigcImage;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("aigcImage");
        return null;
    }

    public final void Pa(@NotNull RelativeLayout relativeLayout) {
        Intrinsics.checkNotNullParameter(relativeLayout, "<set-?>");
        this.mCardPart = relativeLayout;
    }

    @NotNull
    public final CardView Q9() {
        CardView cardView = this.aigcImageCardView;
        if (cardView != null) {
            return cardView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("aigcImageCardView");
        return null;
    }

    public final void Qa(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.myCardRoot = view;
    }

    @NotNull
    public final TextView R9() {
        TextView textView = this.aigcNameText;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("aigcNameText");
        return null;
    }

    public final void Ra(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.nameText = textView;
    }

    @NotNull
    public final MaxHeightRelativelayout S9() {
        MaxHeightRelativelayout maxHeightRelativelayout = this.aigcNickMaxHeight;
        if (maxHeightRelativelayout != null) {
            return maxHeightRelativelayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("aigcNickMaxHeight");
        return null;
    }

    public final void Sa(@NotNull RelativeLayout relativeLayout) {
        Intrinsics.checkNotNullParameter(relativeLayout, "<set-?>");
        this.normCardLayout = relativeLayout;
    }

    @NotNull
    public final View T9() {
        View view = this.aigcProfileContainer;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("aigcProfileContainer");
        return null;
    }

    public final void Ta(@NotNull RelativeLayout relativeLayout) {
        Intrinsics.checkNotNullParameter(relativeLayout, "<set-?>");
        this.normProfileContainer = relativeLayout;
    }

    @NotNull
    public final TextView U9() {
        TextView textView = this.aigcTips;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("aigcTips");
        return null;
    }

    public final void Ua(@NotNull CardView cardView) {
        Intrinsics.checkNotNullParameter(cardView, "<set-?>");
        this.normalCardView = cardView;
    }

    @NotNull
    public final TextView V9() {
        TextView textView = this.aigcUinText;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("aigcUinText");
        return null;
    }

    public final void Va(@NotNull RelativeLayout relativeLayout) {
        Intrinsics.checkNotNullParameter(relativeLayout, "<set-?>");
        this.normalLayout = relativeLayout;
    }

    @NotNull
    public final QQProAvatarView W9() {
        QQProAvatarView qQProAvatarView = this.avatar;
        if (qQProAvatarView != null) {
            return qQProAvatarView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("avatar");
        return null;
    }

    public final void Wa(@NotNull MaxHeightRelativelayout maxHeightRelativelayout) {
        Intrinsics.checkNotNullParameter(maxHeightRelativelayout, "<set-?>");
        this.normalNickMaxHeight = maxHeightRelativelayout;
    }

    public final void Xa(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.normalTips = textView;
    }

    @NotNull
    public final RelativeLayout Y9() {
        RelativeLayout relativeLayout = this.mCardPart;
        if (relativeLayout != null) {
            return relativeLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mCardPart");
        return null;
    }

    public final void Ya(@NotNull QRCodeLoadingComponent qRCodeLoadingComponent) {
        Intrinsics.checkNotNullParameter(qRCodeLoadingComponent, "<set-?>");
        this.qrCode = qRCodeLoadingComponent;
    }

    @NotNull
    public final View Z9() {
        View view = this.myCardRoot;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("myCardRoot");
        return null;
    }

    public final void Za(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.uinText = textView;
    }

    @NotNull
    public final TextView aa() {
        TextView textView = this.nameText;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("nameText");
        return null;
    }

    public final void ab(@NotNull QRDisplayMyCardViewModel qRDisplayMyCardViewModel) {
        Intrinsics.checkNotNullParameter(qRDisplayMyCardViewModel, "<set-?>");
        this.viewModel = qRDisplayMyCardViewModel;
    }

    @NotNull
    public final RelativeLayout ba() {
        RelativeLayout relativeLayout = this.normCardLayout;
        if (relativeLayout != null) {
            return relativeLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("normCardLayout");
        return null;
    }

    @NotNull
    public final RelativeLayout ca() {
        RelativeLayout relativeLayout = this.normProfileContainer;
        if (relativeLayout != null) {
            return relativeLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("normProfileContainer");
        return null;
    }

    @NotNull
    public final CardView da() {
        CardView cardView = this.normalCardView;
        if (cardView != null) {
            return cardView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("normalCardView");
        return null;
    }

    @NotNull
    public final RelativeLayout ea() {
        RelativeLayout relativeLayout = this.normalLayout;
        if (relativeLayout != null) {
            return relativeLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("normalLayout");
        return null;
    }

    @NotNull
    public final MaxHeightRelativelayout ga() {
        MaxHeightRelativelayout maxHeightRelativelayout = this.normalNickMaxHeight;
        if (maxHeightRelativelayout != null) {
            return maxHeightRelativelayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("normalNickMaxHeight");
        return null;
    }

    @NotNull
    public final TextView ha() {
        TextView textView = this.normalTips;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("normalTips");
        return null;
    }

    @NotNull
    public final QRCodeLoadingComponent ia() {
        QRCodeLoadingComponent qRCodeLoadingComponent = this.qrCode;
        if (qRCodeLoadingComponent != null) {
            return qRCodeLoadingComponent;
        }
        Intrinsics.throwUninitializedPropertyAccessException(CommonConstant.KEY_QR_CODE);
        return null;
    }

    @NotNull
    public final TextView ja() {
        TextView textView = this.uinText;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("uinText");
        return null;
    }

    @NotNull
    public final QRDisplayMyCardViewModel la() {
        QRDisplayMyCardViewModel qRDisplayMyCardViewModel = this.viewModel;
        if (qRDisplayMyCardViewModel != null) {
            return qRDisplayMyCardViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    @Override // com.tencent.biz.richframework.part.Part
    @SuppressLint({"ClickableViewAccessibility"})
    public void onInitView(@Nullable View rootView) {
        RelativeLayout relativeLayout;
        super.onInitView(rootView);
        if (rootView != null) {
            relativeLayout = (RelativeLayout) rootView.findViewById(R.id.toc);
        } else {
            relativeLayout = null;
        }
        if (relativeLayout == null) {
            QLog.i("QRDisplayMyCardPart", 1, "card part is null");
            return;
        }
        Pa(relativeLayout);
        QRDisplayMyCardViewModel qRDisplayMyCardViewModel = (QRDisplayMyCardViewModel) getViewModel(QRDisplayMyCardViewModel.class);
        if (qRDisplayMyCardViewModel == null) {
            return;
        }
        ab(qRDisplayMyCardViewModel);
        Context context = getContext();
        if (context != null) {
            ua(context);
            initData();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/biz/qrcode/fragment/part/QRDisplayMyCardPart$c", "Lcom/tencent/mobileqq/profilecard/base/utils/LongClickCopyAction$ICopyListener;", "", "onShowCopyMenu", "", "content", "onCopyContent", "onDismiss", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes5.dex */
    public static final class c implements LongClickCopyAction.ICopyListener {
        c() {
        }

        @Override // com.tencent.mobileqq.profilecard.base.utils.LongClickCopyAction.ICopyListener
        public void onCopyContent(@NotNull String content) {
            QQAppInterface qQAppInterface;
            Intrinsics.checkNotNullParameter(content, "content");
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime instanceof QQAppInterface) {
                qQAppInterface = (QQAppInterface) peekAppRuntime;
            } else {
                qQAppInterface = null;
            }
            QQAppInterface qQAppInterface2 = qQAppInterface;
            if (qQAppInterface2 == null) {
                return;
            }
            ReportController.o(qQAppInterface2, "CliOper", "", "", "0X800AEB3", "0X800AEB3", 0, 0, "", "", "", "");
        }

        @Override // com.tencent.mobileqq.profilecard.base.utils.LongClickCopyAction.ICopyListener
        public void onShowCopyMenu() {
            QQAppInterface qQAppInterface;
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime instanceof QQAppInterface) {
                qQAppInterface = (QQAppInterface) peekAppRuntime;
            } else {
                qQAppInterface = null;
            }
            QQAppInterface qQAppInterface2 = qQAppInterface;
            if (qQAppInterface2 == null) {
                return;
            }
            ReportController.o(qQAppInterface2, "CliOper", "", "", "0X800AEB1", "0X800AEB1", 0, 0, "", "", "", "");
        }

        @Override // com.tencent.mobileqq.profilecard.base.utils.LongClickCopyAction.ICopyListener
        public void onDismiss() {
        }
    }
}
